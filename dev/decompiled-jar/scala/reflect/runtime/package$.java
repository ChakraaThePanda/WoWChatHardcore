/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.runtime;

import scala.reflect.runtime.JavaUniverse;

public final class package$ {
    public static package$ MODULE$;
    private scala.reflect.api.JavaUniverse universe;
    private volatile boolean bitmap$0;

    static {
        new package$();
    }

    private scala.reflect.api.JavaUniverse universe$lzycompute() {
        synchronized (this) {
            if (!this.bitmap$0) {
                this.universe = new JavaUniverse();
                this.bitmap$0 = true;
            }
        }
        return this.universe;
    }

    public scala.reflect.api.JavaUniverse universe() {
        if (!this.bitmap$0) {
            return this.universe$lzycompute();
        }
        return this.universe;
    }

    private package$() {
        MODULE$ = this;
    }
}

