/*
 * Decompiled with CFR 0.152.
 */
package com.fasterxml.jackson.core.util;

public abstract class InternalJacksonUtil {
    public static int addOverflowSafe(int base, int length) {
        int result2 = base + length;
        if (result2 < 0) {
            return Integer.MAX_VALUE;
        }
        return result2;
    }
}

