/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import scala.runtime.BoxesRunTime;
import scala.runtime.StringAdd;

public final class StringAdd$ {
    public static StringAdd$ MODULE$;

    static {
        new StringAdd$();
    }

    public final String $plus$extension(Object $this, String other) {
        return new StringBuilder(0).append(String.valueOf($this)).append(other).toString();
    }

    public final int hashCode$extension(Object $this) {
        return $this.hashCode();
    }

    public final boolean equals$extension(Object $this, Object x$1) {
        Object object;
        boolean bl = x$1 instanceof StringAdd;
        return bl && BoxesRunTime.equals($this, object = x$1 == null ? null : ((StringAdd)x$1).self());
    }

    private StringAdd$() {
        MODULE$ = this;
    }
}

