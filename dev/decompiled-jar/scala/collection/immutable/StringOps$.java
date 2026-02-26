/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.collection.immutable.StringOps;
import scala.collection.immutable.WrappedString;
import scala.collection.mutable.StringBuilder;
import scala.collection.mutable.StringBuilder$;

public final class StringOps$ {
    public static StringOps$ MODULE$;

    static {
        new StringOps$();
    }

    public final WrappedString thisCollection$extension(String $this) {
        return new WrappedString($this);
    }

    public final WrappedString toCollection$extension(String $this, String repr) {
        return new WrappedString(repr);
    }

    public final StringBuilder newBuilder$extension(String $this) {
        return StringBuilder$.MODULE$.newBuilder();
    }

    public final char apply$extension(String $this, int index) {
        return $this.charAt(index);
    }

    public final String slice$extension(String $this, int from, int until) {
        int start;
        int n = start = from < 0 ? 0 : from;
        if (until <= start || start >= $this.length()) {
            return "";
        }
        int end = until > this.length$extension($this) ? this.length$extension($this) : until;
        return $this.substring(start, end);
    }

    public final String toString$extension(String $this) {
        return $this;
    }

    public final int length$extension(String $this) {
        return $this.length();
    }

    public final WrappedString seq$extension(String $this) {
        return new WrappedString($this);
    }

    public final int hashCode$extension(String $this) {
        return $this.hashCode();
    }

    public final boolean equals$extension(String $this, Object x$1) {
        boolean bl = x$1 instanceof StringOps;
        if (bl) {
            String string = x$1 == null ? null : ((StringOps)x$1).repr();
            String string2 = $this;
            if (!(string2 != null ? !string2.equals(string) : string != null)) {
                return true;
            }
        }
        return false;
    }

    private StringOps$() {
        MODULE$ = this;
    }
}

