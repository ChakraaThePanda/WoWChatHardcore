/*
 * Decompiled with CFR 0.152.
 */
package com.google.crypto.tink.aead.subtle;

import com.google.crypto.tink.AccessesPartialKey;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.aead.AesGcmSivKey;
import com.google.crypto.tink.annotations.Alpha;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.EngineFactory;
import com.google.crypto.tink.subtle.Hex;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

@Alpha
public final class AesGcmSiv
implements Aead {
    private static final byte[] TEST_PLAINTEXT = Hex.decode("7a806c");
    private static final byte[] TEST_AAD = Hex.decode("46bb91c3c5");
    private static final byte[] TEST_KEY = Hex.decode("36864200e0eaf5284d884a0e77d31646");
    private static final byte[] TEST_NOUNCE = Hex.decode("bae8e37fc83441b16034566b");
    private static final byte[] TEST_RESULT = Hex.decode("af60eb711bd85bc1e4d3e0a462e074eea428a8");
    private static final ThreadLocal<Cipher> localAesGcmSivCipher = new ThreadLocal<Cipher>(){

        @Override
        protected Cipher initialValue() {
            try {
                Cipher cipher = EngineFactory.CIPHER.getInstance("AES/GCM-SIV/NoPadding");
                if (!AesGcmSiv.isAesGcmSivCipher(cipher)) {
                    return null;
                }
                return cipher;
            }
            catch (GeneralSecurityException ex) {
                throw new IllegalStateException(ex);
            }
        }
    };
    private static final int IV_SIZE_IN_BYTES = 12;
    private static final int TAG_SIZE_IN_BYTES = 16;
    private final SecretKey keySpec;
    private final byte[] outputPrefix;

    private static boolean isAesGcmSivCipher(Cipher cipher) {
        try {
            AlgorithmParameterSpec params = AesGcmSiv.getParams(TEST_NOUNCE);
            cipher.init(2, (Key)new SecretKeySpec(TEST_KEY, "AES"), params);
            cipher.updateAAD(TEST_AAD);
            byte[] output = cipher.doFinal(TEST_RESULT, 0, TEST_RESULT.length);
            return Bytes.equal(output, TEST_PLAINTEXT);
        }
        catch (GeneralSecurityException ex) {
            return false;
        }
    }

    @AccessesPartialKey
    public static Aead create(AesGcmSivKey key) throws GeneralSecurityException {
        return new AesGcmSiv(key.getKeyBytes().toByteArray(InsecureSecretKeyAccess.get()), key.getOutputPrefix().toByteArray());
    }

    private AesGcmSiv(byte[] key, byte[] outputPrefix) throws GeneralSecurityException {
        this.outputPrefix = outputPrefix;
        Validators.validateAesKeySize(key.length);
        this.keySpec = new SecretKeySpec(key, "AES");
    }

    public AesGcmSiv(byte[] key) throws GeneralSecurityException {
        this(key, new byte[0]);
    }

    private Cipher getAesGcmSivCipher() throws GeneralSecurityException {
        Cipher cipher = localAesGcmSivCipher.get();
        if (cipher == null) {
            throw new GeneralSecurityException("AES GCM SIV cipher is not available or is invalid.");
        }
        return cipher;
    }

    private byte[] rawEncrypt(byte[] plaintext, byte[] associatedData) throws GeneralSecurityException {
        int written;
        Cipher cipher = this.getAesGcmSivCipher();
        if (plaintext.length > 2147483619) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] ciphertext = new byte[12 + plaintext.length + 16];
        byte[] iv = Random.randBytes(12);
        System.arraycopy(iv, 0, ciphertext, 0, 12);
        AlgorithmParameterSpec params = AesGcmSiv.getParams(iv);
        cipher.init(1, (Key)this.keySpec, params);
        if (associatedData != null && associatedData.length != 0) {
            cipher.updateAAD(associatedData);
        }
        if ((written = cipher.doFinal(plaintext, 0, plaintext.length, ciphertext, 12)) != plaintext.length + 16) {
            int actualTagSize = written - plaintext.length;
            throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", 16, actualTagSize));
        }
        return ciphertext;
    }

    @Override
    public byte[] encrypt(byte[] plaintext, byte[] associatedData) throws GeneralSecurityException {
        byte[] ciphertext = this.rawEncrypt(plaintext, associatedData);
        if (this.outputPrefix.length == 0) {
            return ciphertext;
        }
        return Bytes.concat(this.outputPrefix, ciphertext);
    }

    private byte[] rawDecrypt(byte[] ciphertext, byte[] associatedData) throws GeneralSecurityException {
        Cipher cipher = this.getAesGcmSivCipher();
        if (ciphertext.length < 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        AlgorithmParameterSpec params = AesGcmSiv.getParams(ciphertext, 0, 12);
        cipher.init(2, (Key)this.keySpec, params);
        if (associatedData != null && associatedData.length != 0) {
            cipher.updateAAD(associatedData);
        }
        return cipher.doFinal(ciphertext, 12, ciphertext.length - 12);
    }

    @Override
    public byte[] decrypt(byte[] ciphertext, byte[] associatedData) throws GeneralSecurityException {
        if (this.outputPrefix.length == 0) {
            return this.rawDecrypt(ciphertext, associatedData);
        }
        if (!Util.isPrefix(this.outputPrefix, ciphertext)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        byte[] copiedCiphertext = Arrays.copyOfRange(ciphertext, this.outputPrefix.length, ciphertext.length);
        return this.rawDecrypt(copiedCiphertext, associatedData);
    }

    private static AlgorithmParameterSpec getParams(byte[] iv) throws GeneralSecurityException {
        return AesGcmSiv.getParams(iv, 0, iv.length);
    }

    private static AlgorithmParameterSpec getParams(byte[] buf, int offset, int len) throws GeneralSecurityException {
        return new GCMParameterSpec(128, buf, offset, len);
    }
}

