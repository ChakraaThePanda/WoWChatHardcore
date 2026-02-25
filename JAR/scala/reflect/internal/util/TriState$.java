/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import scala.reflect.internal.util.TriState;
import scala.sys.package$;

public final class TriState$ {
    public static TriState$ MODULE$;
    private final int Unknown;
    private final int False;
    private final int True;

    static {
        new TriState$();
    }

    public int booleanToTriState(boolean b) {
        if (b) {
            return this.True();
        }
        return this.False();
    }

    public int Unknown() {
        return this.Unknown;
    }

    public int False() {
        return this.False;
    }

    public int True() {
        return this.True;
    }

    public final boolean isKnown$extension(int $this) {
        return $this != this.Unknown();
    }

    public final boolean booleanValue$extension(int $this) {
        boolean bl;
        if (this.True() == $this) {
            bl = true;
        } else if (this.False() == $this) {
            bl = false;
        } else {
            throw package$.MODULE$.error("Not a Boolean value");
        }
        return bl;
    }

    public final int hashCode$extension(int $this) {
        return Integer.hashCode($this);
    }

    public final boolean equals$extension(int $this, Object x$1) {
        int n;
        boolean bl = x$1 instanceof TriState;
        return bl && $this == (n = ((TriState)x$1).value());
    }

    private TriState$() {
        MODULE$ = this;
        this.Unknown = -1;
        this.False = 0;
        this.True = 1;
    }
}

