/*
 * Decompiled with CFR 0.152.
 */
package com.google.crypto.tink.subtle;

import com.google.crypto.tink.AccessesPartialKey;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.aead.AesEaxKey;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.subtle.EngineFactory;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AesEaxJce
implements Aead {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    private static final ThreadLocal<Cipher> localEcbCipher = new ThreadLocal<Cipher>(){

        @Override
        protected Cipher initialValue() {
            try {
                return EngineFactory.CIPHER.getInstance("AES/ECB/NOPADDING");
            }
            catch (GeneralSecurityException ex) {
                throw new IllegalStateException(ex);
            }
        }
    };
    private static final ThreadLocal<Cipher> localCtrCipher = new ThreadLocal<Cipher>(){

        @Override
        protected Cipher initialValue() {
            try {
                return EngineFactory.CIPHER.getInstance("AES/CTR/NOPADDING");
            }
            catch (GeneralSecurityException ex) {
                throw new IllegalStateException(ex);
            }
        }
    };
    static final int BLOCK_SIZE_IN_BYTES = 16;
    static final int TAG_SIZE_IN_BYTES = 16;
    private final byte[] b;
    private final byte[] p;
    private final byte[] outputPrefix;
    private final SecretKeySpec keySpec;
    private final int ivSizeInBytes;

    @AccessesPartialKey
    public static Aead create(AesEaxKey key) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        if (key.getParameters().getTagSizeBytes() != 16) {
            throw new GeneralSecurityException("AesEaxJce only supports 16 byte tag size, not " + key.getParameters().getTagSizeBytes());
        }
        return new AesEaxJce(key.getKeyBytes().toByteArray(InsecureSecretKeyAccess.get()), key.getParameters().getIvSizeBytes(), key.getOutputPrefix().toByteArray());
    }

    private AesEaxJce(byte[] key, int ivSizeInBytes, byte[] outputPrefix) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        if (ivSizeInBytes != 12 && ivSizeInBytes != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.ivSizeInBytes = ivSizeInBytes;
        Validators.validateAesKeySize(key.length);
        this.keySpec = new SecretKeySpec(key, "AES");
        Cipher ecb = localEcbCipher.get();
        ecb.init(1, this.keySpec);
        byte[] block = ecb.doFinal(new byte[16]);
        this.b = AesEaxJce.multiplyByX(block);
        this.p = AesEaxJce.multiplyByX(this.b);
        this.outputPrefix = outputPrefix;
    }

    public AesEaxJce(byte[] key, int ivSizeInBytes) throws GeneralSecurityException {
        this(key, ivSizeInBytes, new byte[0]);
    }

    private static void xor(byte[] x, byte[] y) {
        int len = x.length;
        for (int i = 0; i < len; ++i) {
            x[i] = (byte)(x[i] ^ y[i]);
        }
    }

    private static byte[] multiplyByX(byte[] block) {
        byte[] res = new byte[16];
        for (int i = 0; i < 15; ++i) {
            res[i] = (byte)((block[i] << 1 ^ (block[i + 1] & 0xFF) >>> 7) & 0xFF);
        }
        res[15] = (byte)(block[15] << 1 ^ block[0] >> 7 & 0x87);
        return res;
    }

    private byte[] pad(byte[] data, int lastBlockFrom, int lastBlockTo) {
        byte[] lastBlock = Arrays.copyOfRange(data, lastBlockFrom, lastBlockTo);
        if (lastBlock.length == 16) {
            AesEaxJce.xor(lastBlock, this.b);
            return lastBlock;
        }
        byte[] res = Arrays.copyOf(this.p, 16);
        for (int i = 0; i < lastBlock.length; ++i) {
            int n = i;
            res[n] = (byte)(res[n] ^ lastBlock[i]);
        }
        res[lastBlock.length] = (byte)(res[lastBlock.length] ^ 0x80);
        return res;
    }

    private byte[] omac(Cipher ecb, int tag, byte[] data, int offset, int length) throws IllegalBlockSizeException, BadPaddingException, ShortBufferException {
        assert (length >= 0);
        assert (0 <= tag && tag <= 3);
        byte[] block = new byte[16];
        block[15] = (byte)tag;
        if (length == 0) {
            AesEaxJce.xor(block, this.b);
            return ecb.doFinal(block);
        }
        byte[] buffer = new byte[16];
        ecb.doFinal(block, 0, 16, buffer);
        byte[] temp = block;
        block = buffer;
        buffer = temp;
        int position = 0;
        while (length - position > 16) {
            for (int i = 0; i < 16; ++i) {
                int n = i;
                block[n] = (byte)(block[n] ^ data[offset + position + i]);
            }
            ecb.doFinal(block, 0, 16, buffer);
            temp = block;
            block = buffer;
            buffer = temp;
            position += 16;
        }
        byte[] padded = this.pad(data, offset + position, offset + length);
        AesEaxJce.xor(block, padded);
        ecb.doFinal(block, 0, 16, buffer);
        return buffer;
    }

    @Override
    public byte[] encrypt(byte[] plaintext, byte[] associatedData) throws GeneralSecurityException {
        if (plaintext.length > Integer.MAX_VALUE - this.outputPrefix.length - this.ivSizeInBytes - 16) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] ciphertext = Arrays.copyOf(this.outputPrefix, this.outputPrefix.length + this.ivSizeInBytes + plaintext.length + 16);
        byte[] iv = Random.randBytes(this.ivSizeInBytes);
        System.arraycopy(iv, 0, ciphertext, this.outputPrefix.length, this.ivSizeInBytes);
        Cipher ecb = localEcbCipher.get();
        ecb.init(1, this.keySpec);
        byte[] n = this.omac(ecb, 0, iv, 0, iv.length);
        byte[] aad = associatedData;
        if (aad == null) {
            aad = new byte[]{};
        }
        byte[] h = this.omac(ecb, 1, aad, 0, aad.length);
        Cipher ctr = localCtrCipher.get();
        ctr.init(1, (Key)this.keySpec, new IvParameterSpec(n));
        ctr.doFinal(plaintext, 0, plaintext.length, ciphertext, this.outputPrefix.length + this.ivSizeInBytes);
        byte[] t = this.omac(ecb, 2, ciphertext, this.outputPrefix.length + this.ivSizeInBytes, plaintext.length);
        int offset = this.outputPrefix.length + plaintext.length + this.ivSizeInBytes;
        for (int i = 0; i < 16; ++i) {
            ciphertext[offset + i] = (byte)(h[i] ^ n[i] ^ t[i]);
        }
        return ciphertext;
    }

    @Override
    public byte[] decrypt(byte[] ciphertext, byte[] associatedData) throws GeneralSecurityException {
        int plaintextLength = ciphertext.length - this.outputPrefix.length - this.ivSizeInBytes - 16;
        if (plaintextLength < 0) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (!Util.isPrefix(this.outputPrefix, ciphertext)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        Cipher ecb = localEcbCipher.get();
        ecb.init(1, this.keySpec);
        byte[] n = this.omac(ecb, 0, ciphertext, this.outputPrefix.length, this.ivSizeInBytes);
        byte[] aad = associatedData;
        if (aad == null) {
            aad = new byte[]{};
        }
        byte[] h = this.omac(ecb, 1, aad, 0, aad.length);
        byte[] t = this.omac(ecb, 2, ciphertext, this.outputPrefix.length + this.ivSizeInBytes, plaintextLength);
        int res = 0;
        int offset = ciphertext.length - 16;
        for (int i = 0; i < 16; ++i) {
            res = (byte)(res | ciphertext[offset + i] ^ h[i] ^ n[i] ^ t[i]);
        }
        if (res != 0) {
            throw new AEADBadTagException("tag mismatch");
        }
        Cipher ctr = localCtrCipher.get();
        ctr.init(1, (Key)this.keySpec, new IvParameterSpec(n));
        return ctr.doFinal(ciphertext, this.outputPrefix.length + this.ivSizeInBytes, plaintextLength);
    }
}

