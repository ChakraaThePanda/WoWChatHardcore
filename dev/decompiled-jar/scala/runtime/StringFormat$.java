/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import scala.Predef$;
import scala.collection.immutable.StringOps;
import scala.runtime.BoxesRunTime;
import scala.runtime.StringFormat;

public final class StringFormat$ {
    public static StringFormat$ MODULE$;

    static {
        new StringFormat$();
    }

    public final String formatted$extension(Object $this, String fmtstr) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return new StringOps(fmtstr).format(Predef$.MODULE$.genericWrapArray(new Object[]{$this}));
    }

    public final int hashCode$extension(Object $this) {
        return $this.hashCode();
    }

    public final boolean equals$extension(Object $this, Object x$1) {
        Object object;
        boolean bl = x$1 instanceof StringFormat;
        return bl && BoxesRunTime.equals($this, object = x$1 == null ? null : ((StringFormat)x$1).self());
    }

    private StringFormat$() {
        MODULE$ = this;
    }
}

