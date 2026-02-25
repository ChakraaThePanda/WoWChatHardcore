/*
 * Decompiled with CFR 0.152.
 */
package com.google.crypto.tink.subtle;

public final class Hex {
    public static String encode(byte[] bytes) {
        String chars = "0123456789abcdef";
        StringBuilder result2 = new StringBuilder(2 * bytes.length);
        for (byte b : bytes) {
            int val = b & 0xFF;
            result2.append(chars.charAt(val / 16));
            result2.append(chars.charAt(val % 16));
        }
        return result2.toString();
    }

    public static byte[] decode(String hex) {
        if (hex.length() % 2 != 0) {
            throw new IllegalArgumentException("Expected a string of even length");
        }
        int size = hex.length() / 2;
        byte[] result2 = new byte[size];
        for (int i = 0; i < size; ++i) {
            int hi = Character.digit(hex.charAt(2 * i), 16);
            int lo = Character.digit(hex.charAt(2 * i + 1), 16);
            if (hi == -1 || lo == -1) {
                throw new IllegalArgumentException("input is not hexadecimal");
            }
            result2[i] = (byte)(16 * hi + lo);
        }
        return result2;
    }

    private Hex() {
    }
}

