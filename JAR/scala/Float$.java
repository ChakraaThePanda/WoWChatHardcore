/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.AnyValCompanion;
import scala.Predef$;

public final class Float$
implements AnyValCompanion {
    public static Float$ MODULE$;
    private final float MinValue;

    static {
        new Float$();
    }

    public final float MinPositiveValue() {
        return Float.MIN_VALUE;
    }

    public final float NaN() {
        return Float.NaN;
    }

    public final float PositiveInfinity() {
        return Float.POSITIVE_INFINITY;
    }

    public final float NegativeInfinity() {
        return Float.NEGATIVE_INFINITY;
    }

    public final float MinValue() {
        return this.MinValue;
    }

    public final float MaxValue() {
        return Float.MAX_VALUE;
    }

    public Float box(float x) {
        throw Predef$.MODULE$.$qmark$qmark$qmark();
    }

    public float unbox(Object x) {
        throw Predef$.MODULE$.$qmark$qmark$qmark();
    }

    public String toString() {
        return "object scala.Float";
    }

    public double float2double(float x) {
        return x;
    }

    private Float$() {
        MODULE$ = this;
        this.MinValue = -Float.MAX_VALUE;
    }
}

