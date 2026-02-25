/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.collection.immutable.List;
import scala.reflect.internal.Variance;

public final class Variance$ {
    public static Variance$ MODULE$;
    private final int Bivariant;
    private final int Covariant;
    private final int Contravariant;
    private final int Invariant;

    static {
        new Variance$();
    }

    public Variance.SbtCompat SbtCompat(int v) {
        return new Variance.SbtCompat(v);
    }

    public int Bivariant() {
        return this.Bivariant;
    }

    public int Covariant() {
        return this.Covariant;
    }

    public int Contravariant() {
        return this.Contravariant;
    }

    public int Invariant() {
        return this.Invariant;
    }

    public <A> int foldExtract(List<A> as, Variance.Extractor<A> f) {
        return this.loop$1(as, this.Bivariant(), f);
    }

    public <A, B> int foldExtract2(List<A> as, List<B> bs, Variance.Extractor2<A, B> f) {
        return this.loop$2(as, bs, this.Bivariant(), f);
    }

    public final boolean isBivariant$extension(int $this) {
        return $this == 2;
    }

    public final boolean isCovariant$extension(int $this) {
        return $this == 1;
    }

    public final boolean isInvariant$extension(int $this) {
        return $this == 0;
    }

    public final boolean isContravariant$extension(int $this) {
        return $this == -1;
    }

    public final boolean isPositive$extension(int $this) {
        return $this > 0;
    }

    public final int $amp$extension(int $this, int other) {
        if ($this == other) {
            return $this;
        }
        if (this.isBivariant$extension($this)) {
            return other;
        }
        if (this.isBivariant$extension(other)) {
            return $this;
        }
        return this.Invariant();
    }

    public final int $times$extension(int $this, int other) {
        if (this.isPositive$extension(other)) {
            return $this;
        }
        if (this.isContravariant$extension(other)) {
            return this.flip$extension($this);
        }
        return this.cut$extension($this);
    }

    public final int flip$extension(int $this) {
        if (this.isCovariant$extension($this)) {
            return this.Contravariant();
        }
        if (this.isContravariant$extension($this)) {
            return this.Covariant();
        }
        return $this;
    }

    public final int cut$extension(int $this) {
        if (this.isBivariant$extension($this)) {
            return $this;
        }
        return this.Invariant();
    }

    public final String symbolicString$extension(int $this) {
        if (this.isCovariant$extension($this)) {
            return "+";
        }
        if (this.isContravariant$extension($this)) {
            return "-";
        }
        return "";
    }

    public final String toString$extension(int $this) {
        if (this.isContravariant$extension($this)) {
            return "contravariant";
        }
        if (this.isCovariant$extension($this)) {
            return "covariant";
        }
        if (this.isInvariant$extension($this)) {
            return "invariant";
        }
        return "";
    }

    public final int hashCode$extension(int $this) {
        return Integer.hashCode($this);
    }

    public final boolean equals$extension(int $this, Object x$1) {
        int n;
        boolean bl = x$1 instanceof Variance;
        return bl && $this == (n = ((Variance)x$1).flags());
    }

    private final int loop$1(List xs, int acc, Variance.Extractor f$1) {
        while (!this.isInvariant$extension(acc) && !xs.isEmpty()) {
            acc = this.$amp$extension(acc, f$1.apply(xs.head()));
            xs = (List)xs.tail();
        }
        return acc;
    }

    private final int loop$2(List xs, List ys, int acc, Variance.Extractor2 f$2) {
        while (!(this.isInvariant$extension(acc) || xs.isEmpty() || ys.isEmpty())) {
            acc = this.$amp$extension(acc, f$2.apply(xs.head(), ys.head()));
            ys = (List)ys.tail();
            xs = (List)xs.tail();
        }
        return acc;
    }

    private Variance$() {
        MODULE$ = this;
        this.Bivariant = 2;
        this.Covariant = 1;
        this.Contravariant = -1;
        this.Invariant = 0;
    }
}

