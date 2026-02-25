/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.AnyValCompanion;
import scala.Predef$;

public final class Byte$
implements AnyValCompanion {
    public static Byte$ MODULE$;

    static {
        new Byte$();
    }

    public final byte MinValue() {
        return -128;
    }

    public final byte MaxValue() {
        return 127;
    }

    public Byte box(byte x) {
        throw Predef$.MODULE$.$qmark$qmark$qmark();
    }

    public byte unbox(Object x) {
        throw Predef$.MODULE$.$qmark$qmark$qmark();
    }

    public String toString() {
        return "object scala.Byte";
    }

    public short byte2short(byte x) {
        return x;
    }

    public int byte2int(byte x) {
        return x;
    }

    public long byte2long(byte x) {
        return x;
    }

    public float byte2float(byte x) {
        return x;
    }

    public double byte2double(byte x) {
        return x;
    }

    private Byte$() {
        MODULE$ = this;
    }
}

