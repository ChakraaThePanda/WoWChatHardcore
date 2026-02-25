/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

public final class Reporter$ {
    public static Reporter$ MODULE$;

    static {
        new Reporter$();
    }

    public final int Display() {
        return 0;
    }

    public final int Count() {
        return 1;
    }

    public final int Suppress() {
        return 2;
    }

    private Reporter$() {
        MODULE$ = this;
    }
}

