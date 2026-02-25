/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.collection.generic.CanBuildFrom;
import scala.collection.package;
import scala.runtime.Nothing$;

public final class package$ {
    public static package$ MODULE$;

    static {
        new package$();
    }

    public <From, T, To> CanBuildFrom<From, T, To> breakOut(CanBuildFrom<Nothing$, T, To> b) {
        return new package.WrappedCanBuildFrom(b);
    }

    private package$() {
        MODULE$ = this;
    }
}

