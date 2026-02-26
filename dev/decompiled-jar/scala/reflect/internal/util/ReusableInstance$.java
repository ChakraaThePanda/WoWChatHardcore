/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import scala.Function0;
import scala.reflect.internal.util.ReusableInstance;

public final class ReusableInstance$ {
    public static ReusableInstance$ MODULE$;

    static {
        new ReusableInstance$();
    }

    public <T> ReusableInstance<T> apply(Function0<T> make, boolean enabled) {
        return new ReusableInstance<T>(make, enabled);
    }

    private ReusableInstance$() {
        MODULE$ = this;
    }
}

