/*
 * Decompiled with CFR 0.152.
 */
package com.fasterxml.jackson.core.internal.shaded.fdp.v2_18_3;

import com.fasterxml.jackson.core.internal.shaded.fdp.v2_18_3.AbstractJavaFloatingPointBitsFromByteArray;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_18_3.FastFloatMath;
import java.nio.charset.StandardCharsets;

final class JavaFloatBitsFromByteArray
extends AbstractJavaFloatingPointBitsFromByteArray {
    @Override
    long nan() {
        return Float.floatToRawIntBits(Float.NaN);
    }

    @Override
    long negativeInfinity() {
        return Float.floatToRawIntBits(Float.NEGATIVE_INFINITY);
    }

    @Override
    long positiveInfinity() {
        return Float.floatToRawIntBits(Float.POSITIVE_INFINITY);
    }

    @Override
    long valueOfFloatLiteral(byte[] str, int startIndex, int endIndex, boolean isNegative, long significand, int exponent, boolean isSignificandTruncated, int exponentOfTruncatedSignificand) {
        float result2 = FastFloatMath.tryDecFloatToFloatTruncated(isNegative, significand, exponent, isSignificandTruncated, exponentOfTruncatedSignificand);
        return Float.floatToRawIntBits(Float.isNaN(result2) ? Float.parseFloat(new String(str, startIndex, endIndex - startIndex, StandardCharsets.ISO_8859_1)) : result2);
    }

    @Override
    long valueOfHexLiteral(byte[] str, int startIndex, int endIndex, boolean isNegative, long significand, int exponent, boolean isSignificandTruncated, int exponentOfTruncatedSignificand) {
        float d = FastFloatMath.tryHexFloatToFloatTruncated(isNegative, significand, exponent, isSignificandTruncated, exponentOfTruncatedSignificand);
        return Float.floatToRawIntBits(Float.isNaN(d) ? Float.parseFloat(new String(str, startIndex, endIndex - startIndex, StandardCharsets.ISO_8859_1)) : d);
    }
}

