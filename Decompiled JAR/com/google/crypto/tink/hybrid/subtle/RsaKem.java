/*
 * Decompiled with CFR 0.152.
 */
package com.google.crypto.tink.hybrid.subtle;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

class RsaKem {
    static final byte[] EMPTY_AAD = new byte[0];
    static final int MIN_RSA_KEY_LENGTH_BITS = 2048;

    private RsaKem() {
    }

    static void validateRsaModulus(BigInteger mod) throws GeneralSecurityException {
        if (mod.bitLength() < 2048) {
            throw new GeneralSecurityException(String.format("RSA key must be of at least size %d bits, but got %d", 2048, mod.bitLength()));
        }
    }

    static int bigIntSizeInBytes(BigInteger mod) {
        return (mod.bitLength() + 7) / 8;
    }

    static byte[] bigIntToByteArray(BigInteger bigInt, int size) {
        byte[] value = bigInt.toByteArray();
        if (value.length == size) {
            return value;
        }
        byte[] result2 = new byte[size];
        if (value.length == result2.length + 1) {
            if (value[0] != 0) {
                throw new IllegalArgumentException("Value is one-byte longer than the expected size, but its first byte is not 0");
            }
            System.arraycopy(value, 1, result2, 0, result2.length);
        } else if (value.length < result2.length) {
            System.arraycopy(value, 0, result2, result2.length - value.length, value.length);
        } else {
            throw new IllegalArgumentException(String.format("Value has invalid length, must be of length at most (%d + 1), but got %d", size, value.length));
        }
        return result2;
    }

    static byte[] generateSecret(BigInteger max) {
        BigInteger r;
        int maxSizeInBytes = RsaKem.bigIntSizeInBytes(max);
        SecureRandom rand = new SecureRandom();
        while ((r = new BigInteger(max.bitLength(), rand)).signum() <= 0 || r.compareTo(max) >= 0) {
        }
        return RsaKem.bigIntToByteArray(r, maxSizeInBytes);
    }

    static KeyPair generateRsaKeyPair(int keySize) {
        KeyPairGenerator rsaGenerator;
        try {
            rsaGenerator = KeyPairGenerator.getInstance("RSA");
            rsaGenerator.initialize(keySize);
        }
        catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No support for RSA algorithm.", e);
        }
        return rsaGenerator.generateKeyPair();
    }
}

