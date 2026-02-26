/*
 * Decompiled with CFR 0.152.
 */
package com.google.crypto.tink.subtle;

import com.google.crypto.tink.AccessesPartialKey;
import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.daead.AesSivKey;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.mac.internal.AesUtil;
import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.EngineFactory;
import com.google.crypto.tink.subtle.PrfAesCmac;
import com.google.crypto.tink.subtle.SubtleUtil;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AesSiv
implements DeterministicAead {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    private static final Collection<Integer> KEY_SIZES = Arrays.asList(64);
    private static final byte[] BLOCK_ZERO = new byte[16];
    private static final byte[] BLOCK_ONE = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
    private final PrfAesCmac cmacForS2V;
    private final byte[] aesCtrKey;
    private final byte[] outputPrefix;
    private static final ThreadLocal<Cipher> localAesCtrCipher = new ThreadLocal<Cipher>(){

        @Override
        protected Cipher initialValue() {
            try {
                return EngineFactory.CIPHER.getInstance("AES/CTR/NoPadding");
            }
            catch (GeneralSecurityException ex) {
                throw new IllegalStateException(ex);
            }
        }
    };

    @AccessesPartialKey
    public static DeterministicAead create(AesSivKey key) throws GeneralSecurityException {
        return new AesSiv(key.getKeyBytes().toByteArray(InsecureSecretKeyAccess.get()), key.getOutputPrefix());
    }

    private AesSiv(byte[] key, com.google.crypto.tink.util.Bytes outputPrefix) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use AES-SIV in FIPS-mode.");
        }
        if (!KEY_SIZES.contains(key.length)) {
            throw new InvalidKeyException("invalid key size: " + key.length + " bytes; key must have 64 bytes");
        }
        byte[] k1 = Arrays.copyOfRange(key, 0, key.length / 2);
        this.aesCtrKey = Arrays.copyOfRange(key, key.length / 2, key.length);
        this.cmacForS2V = new PrfAesCmac(k1);
        this.outputPrefix = outputPrefix.toByteArray();
    }

    public AesSiv(byte[] key) throws GeneralSecurityException {
        this(key, com.google.crypto.tink.util.Bytes.copyFrom(new byte[0]));
    }

    private byte[] s2v(byte[] ... s) throws GeneralSecurityException {
        if (s.length == 0) {
            return this.cmacForS2V.compute(BLOCK_ONE, 16);
        }
        byte[] result2 = this.cmacForS2V.compute(BLOCK_ZERO, 16);
        for (int i = 0; i < s.length - 1; ++i) {
            byte[] currBlock = s[i] == null ? new byte[]{} : s[i];
            result2 = Bytes.xor(AesUtil.dbl(result2), this.cmacForS2V.compute(currBlock, 16));
        }
        byte[] lastBlock = s[s.length - 1];
        result2 = lastBlock.length >= 16 ? Bytes.xorEnd(lastBlock, result2) : Bytes.xor(AesUtil.cmacPad(lastBlock), AesUtil.dbl(result2));
        return this.cmacForS2V.compute(result2, 16);
    }

    @Override
    public byte[] encryptDeterministically(byte[] plaintext, byte[] associatedData) throws GeneralSecurityException {
        if (plaintext.length > Integer.MAX_VALUE - this.outputPrefix.length - 16) {
            throw new GeneralSecurityException("plaintext too long");
        }
        Cipher aesCtr = localAesCtrCipher.get();
        byte[] computedIv = this.s2v(associatedData, plaintext);
        byte[] ivForJavaCrypto = (byte[])computedIv.clone();
        ivForJavaCrypto[8] = (byte)(ivForJavaCrypto[8] & 0x7F);
        ivForJavaCrypto[12] = (byte)(ivForJavaCrypto[12] & 0x7F);
        aesCtr.init(1, (Key)new SecretKeySpec(this.aesCtrKey, "AES"), new IvParameterSpec(ivForJavaCrypto));
        int outputSize = this.outputPrefix.length + computedIv.length + plaintext.length;
        byte[] output = Arrays.copyOf(this.outputPrefix, outputSize);
        System.arraycopy(computedIv, 0, output, this.outputPrefix.length, computedIv.length);
        int written = aesCtr.doFinal(plaintext, 0, plaintext.length, output, this.outputPrefix.length + computedIv.length);
        if (written != plaintext.length) {
            throw new GeneralSecurityException("not enough data written");
        }
        return output;
    }

    @Override
    public byte[] decryptDeterministically(byte[] ciphertext, byte[] associatedData) throws GeneralSecurityException {
        byte[] computedIv;
        if (ciphertext.length < 16 + this.outputPrefix.length) {
            throw new GeneralSecurityException("Ciphertext too short.");
        }
        if (!Util.isPrefix(this.outputPrefix, ciphertext)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        Cipher aesCtr = localAesCtrCipher.get();
        byte[] expectedIv = Arrays.copyOfRange(ciphertext, this.outputPrefix.length, 16 + this.outputPrefix.length);
        byte[] ivForJavaCrypto = (byte[])expectedIv.clone();
        ivForJavaCrypto[8] = (byte)(ivForJavaCrypto[8] & 0x7F);
        ivForJavaCrypto[12] = (byte)(ivForJavaCrypto[12] & 0x7F);
        aesCtr.init(2, (Key)new SecretKeySpec(this.aesCtrKey, "AES"), new IvParameterSpec(ivForJavaCrypto));
        int offset = 16 + this.outputPrefix.length;
        int ctrCiphertextLen = ciphertext.length - offset;
        byte[] decryptedPt = aesCtr.doFinal(ciphertext, offset, ctrCiphertextLen);
        if (ctrCiphertextLen == 0 && decryptedPt == null && SubtleUtil.isAndroid()) {
            decryptedPt = new byte[]{};
        }
        if (Bytes.equal(expectedIv, computedIv = this.s2v(associatedData, decryptedPt))) {
            return decryptedPt;
        }
        throw new AEADBadTagException("Integrity check failed.");
    }
}

