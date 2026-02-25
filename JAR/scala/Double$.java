/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.AnyValCompanion;
import scala.Predef$;

public final class Double$
implements AnyValCompanion {
    public static Double$ MODULE$;
    private final double MinValue;

    static {
        new Double$();
    }

    public final double MinPositiveValue() {
        return Double.MIN_VALUE;
    }

    public final double NaN() {
        return Double.NaN;
    }

    public final double PositiveInfinity() {
        return Double.POSITIVE_INFINITY;
    }

    public final double NegativeInfinity() {
        return Double.NEGATIVE_INFINITY;
    }

    public final double MinValue() {
        return this.MinValue;
    }

    public final double MaxValue() {
        return Double.MAX_VALUE;
    }

    public Double box(double x) {
        throw Predef$.MODULE$.$qmark$qmark$qmark();
    }

    public double unbox(Object x) {
        throw Predef$.MODULE$.$qmark$qmark$qmark();
    }

    public String toString() {
        return "object scala.Double";
    }

    private Double$() {
        MODULE$ = this;
        this.MinValue = -Double.MAX_VALUE;
    }
}

