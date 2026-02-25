/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.AnyValCompanion;
import scala.Predef$;

public final class Int$
implements AnyValCompanion {
    public static Int$ MODULE$;

    static {
        new Int$();
    }

    public final int MinValue() {
        return Integer.MIN_VALUE;
    }

    public final int MaxValue() {
        return Integer.MAX_VALUE;
    }

    public Integer box(int x) {
        throw Predef$.MODULE$.$qmark$qmark$qmark();
    }

    public int unbox(Object x) {
        throw Predef$.MODULE$.$qmark$qmark$qmark();
    }

    public String toString() {
        return "object scala.Int";
    }

    public long int2long(int x) {
        return x;
    }

    public float int2float(int x) {
        return x;
    }

    public double int2double(int x) {
        return x;
    }

    private Int$() {
        MODULE$ = this;
    }
}

