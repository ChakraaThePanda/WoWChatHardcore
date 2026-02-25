/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.collection.immutable.List;
import scala.reflect.internal.Depth;
import scala.reflect.internal.DepthFunction;

public final class Depth$ {
    public static Depth$ MODULE$;
    private final int AnyDepth;
    private final int Zero;

    static {
        new Depth$();
    }

    public final int AnyDepthValue() {
        return -3;
    }

    public final int AnyDepth() {
        return this.AnyDepth;
    }

    public final int Zero() {
        return this.Zero;
    }

    public final int apply(int depth) {
        if (depth < -3) {
            return this.AnyDepth();
        }
        return depth;
    }

    public <A> int maximumBy(List<A> xs, DepthFunction<A> ff) {
        List ys = xs;
        int mm = this.Zero();
        while (!ys.isEmpty()) {
            mm = this.max$extension(mm, ff.apply(ys.head()));
            ys = (List)ys.tail();
        }
        return mm;
    }

    public final int max$extension(int $this, int that) {
        if ($this < that) {
            return that;
        }
        return $this;
    }

    /*
     * WARNING - void declaration
     */
    public final int decr$extension0(int $this, int n) {
        void var3_3;
        if (this.isAnyDepth$extension($this)) {
            return $this;
        }
        int apply_depth = $this - n;
        if (apply_depth < -3) {
            return this.AnyDepth();
        }
        return (int)var3_3;
    }

    /*
     * WARNING - void declaration
     */
    public final int incr$extension0(int $this, int n) {
        void var3_3;
        if (this.isAnyDepth$extension($this)) {
            return $this;
        }
        int apply_depth = $this + n;
        if (apply_depth < -3) {
            return this.AnyDepth();
        }
        return (int)var3_3;
    }

    public final int decr$extension1(int $this) {
        return this.decr$extension0($this, 1);
    }

    public final int incr$extension1(int $this) {
        return this.incr$extension0($this, 1);
    }

    public final boolean isNegative$extension(int $this) {
        return $this < 0;
    }

    public final boolean isZero$extension(int $this) {
        return $this == 0;
    }

    public final boolean isAnyDepth$extension(int $this) {
        return $this == this.AnyDepth();
    }

    public final int compare$extension(int $this, int that) {
        if ($this < that) {
            return -1;
        }
        if ($this == that) {
            return 0;
        }
        return 1;
    }

    public final String toString$extension(int $this) {
        return new StringBuilder(7).append("Depth(").append($this).append(")").toString();
    }

    public final int hashCode$extension(int $this) {
        return Integer.hashCode($this);
    }

    public final boolean equals$extension(int $this, Object x$1) {
        int n;
        boolean bl = x$1 instanceof Depth;
        return bl && $this == (n = ((Depth)x$1).depth());
    }

    private Depth$() {
        MODULE$ = this;
        this.AnyDepth = -3;
        this.Zero = 0;
    }
}

