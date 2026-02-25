/*
 * Decompiled with CFR 0.152.
 */
package com.google.crypto.tink.aead.internal;

import com.google.crypto.tink.AccessesPartialKey;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.aead.ChaCha20Poly1305Key;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.subtle.EngineFactory;
import com.google.crypto.tink.subtle.Hex;
import com.google.crypto.tink.subtle.Random;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.util.Arrays;
import javax.annotation.Nullable;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

@Immutable
public final class ChaCha20Poly1305Jce
implements Aead {
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    private static final int NONCE_SIZE_IN_BYTES = 12;
    private static final int TAG_SIZE_IN_BYTES = 16;
    private static final int KEY_SIZE_IN_BYTES = 32;
    private static final String CIPHER_NAME = "ChaCha20-Poly1305";
    private static final String KEY_NAME = "ChaCha20";
    private static final byte[] TEST_KEY = Hex.decode("808182838485868788898a8b8c8d8e8f909192939495969798999a9b9c9d9e9f");
    private static final byte[] TEST_NONCE = Hex.decode("070000004041424344454647");
    private static final byte[] TEST_CIPHERTEXT_OF_EMPTY = Hex.decode("a0784d7a4716f3feb4f64e7f4b39bf04");
    private static final ThreadLocal<Cipher> localCipher = new ThreadLocal<Cipher>(){

        @Override
        @Nullable
        protected Cipher initialValue() {
            try {
                Cipher cipher = EngineFactory.CIPHER.getInstance(ChaCha20Poly1305Jce.CIPHER_NAME);
                if (!ChaCha20Poly1305Jce.isValid(cipher)) {
                    return null;
                }
                return cipher;
            }
            catch (GeneralSecurityException ex) {
                return null;
            }
        }
    };
    private final SecretKey keySpec;
    private final byte[] outputPrefix;

    private static boolean isValid(Cipher cipher) {
        try {
            IvParameterSpec params = new IvParameterSpec(TEST_NONCE);
            cipher.init(2, (Key)new SecretKeySpec(TEST_KEY, KEY_NAME), params);
            byte[] output = cipher.doFinal(TEST_CIPHERTEXT_OF_EMPTY);
            if (output.length != 0) {
                return false;
            }
            cipher.init(2, (Key)new SecretKeySpec(TEST_KEY, KEY_NAME), params);
            byte[] output2 = cipher.doFinal(TEST_CIPHERTEXT_OF_EMPTY);
            return output2.length == 0;
        }
        catch (GeneralSecurityException ex) {
            return false;
        }
    }

    private ChaCha20Poly1305Jce(byte[] key, byte[] outputPrefix) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
        }
        if (!ChaCha20Poly1305Jce.isSupported()) {
            throw new GeneralSecurityException("JCE does not support algorithm: ChaCha20-Poly1305");
        }
        if (key.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.keySpec = new SecretKeySpec(key, KEY_NAME);
        this.outputPrefix = outputPrefix;
    }

    @AccessesPartialKey
    public static Aead create(ChaCha20Poly1305Key key) throws GeneralSecurityException {
        return new ChaCha20Poly1305Jce(key.getKeyBytes().toByteArray(InsecureSecretKeyAccess.get()), key.getOutputPrefix().toByteArray());
    }

    @Nullable
    static Cipher getThreadLocalCipherOrNull() {
        return localCipher.get();
    }

    public static boolean isSupported() {
        return localCipher.get() != null;
    }

    @Override
    public byte[] encrypt(byte[] plaintext, byte[] associatedData) throws GeneralSecurityException {
        int outputSize;
        if (plaintext == null) {
            throw new NullPointerException("plaintext is null");
        }
        byte[] nonce = Random.randBytes(12);
        IvParameterSpec params = new IvParameterSpec(nonce);
        Cipher cipher = localCipher.get();
        cipher.init(1, (Key)this.keySpec, params);
        if (associatedData != null && associatedData.length != 0) {
            cipher.updateAAD(associatedData);
        }
        if ((outputSize = cipher.getOutputSize(plaintext.length)) > Integer.MAX_VALUE - this.outputPrefix.length - 12) {
            throw new GeneralSecurityException("plaintext too long");
        }
        int len = this.outputPrefix.length + 12 + outputSize;
        byte[] output = Arrays.copyOf(this.outputPrefix, len);
        System.arraycopy(nonce, 0, output, this.outputPrefix.length, 12);
        int written = cipher.doFinal(plaintext, 0, plaintext.length, output, this.outputPrefix.length + 12);
        if (written != outputSize) {
            throw new GeneralSecurityException("not enough data written");
        }
        return output;
    }

    @Override
    public byte[] decrypt(byte[] ciphertext, byte[] associatedData) throws GeneralSecurityException {
        if (ciphertext == null) {
            throw new NullPointerException("ciphertext is null");
        }
        if (ciphertext.length < this.outputPrefix.length + 12 + 16) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (!Util.isPrefix(this.outputPrefix, ciphertext)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        byte[] nonce = new byte[12];
        System.arraycopy(ciphertext, this.outputPrefix.length, nonce, 0, 12);
        IvParameterSpec params = new IvParameterSpec(nonce);
        Cipher cipher = localCipher.get();
        cipher.init(2, (Key)this.keySpec, params);
        if (associatedData != null && associatedData.length != 0) {
            cipher.updateAAD(associatedData);
        }
        int offset = this.outputPrefix.length + 12;
        int len = ciphertext.length - this.outputPrefix.length - 12;
        return cipher.doFinal(ciphertext, offset, len);
    }
}

