/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.Array$;
import scala.Function1;
import scala.Serializable;
import scala.collection.Seq;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.BitSetFactory;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.Growable;
import scala.collection.immutable.BitSet;
import scala.collection.immutable.BitSet$;
import scala.collection.mutable.Builder;

public final class BitSet$
implements BitSetFactory<BitSet>,
Serializable {
    public static BitSet$ MODULE$;
    private final BitSet empty;
    private final CanBuildFrom<BitSet, Object, BitSet> canBuildFrom;

    static {
        new BitSet$();
    }

    @Override
    public scala.collection.BitSet apply(Seq elems) {
        return BitSetFactory.apply$(this, elems);
    }

    @Override
    public CanBuildFrom<BitSet, Object, BitSet> bitsetCanBuildFrom() {
        return BitSetFactory.bitsetCanBuildFrom$(this);
    }

    @Override
    public BitSet empty() {
        return this.empty;
    }

    public BitSet scala$collection$immutable$BitSet$$createSmall(long a, long b) {
        if (b == 0L) {
            return new BitSet.BitSet1(a);
        }
        return new BitSet.BitSet2(a, b);
    }

    @Override
    public Builder<Object, BitSet> newBuilder() {
        return new Builder<Object, BitSet>(){
            private final scala.collection.mutable.BitSet b;

            public void sizeHint(int size) {
                Builder.sizeHint$((Builder)this, size);
            }

            public void sizeHint(TraversableLike<?, ?> coll) {
                Builder.sizeHint$((Builder)this, coll);
            }

            public void sizeHint(TraversableLike<?, ?> coll, int delta) {
                Builder.sizeHint$(this, coll, delta);
            }

            public void sizeHintBounded(int size, TraversableLike<?, ?> boundingColl) {
                Builder.sizeHintBounded$(this, size, boundingColl);
            }

            public <NewTo> Builder<Object, NewTo> mapResult(Function1<BitSet, NewTo> f) {
                return Builder.mapResult$(this, f);
            }

            public Growable $plus$eq(Object elem1, Object elem2, Seq elems) {
                return Growable.$plus$eq$(this, elem1, elem2, elems);
            }

            public Growable<Object> $plus$plus$eq(TraversableOnce<Object> xs) {
                return Growable.$plus$plus$eq$(this, xs);
            }

            public anon.1 $plus$eq(int x) {
                this.b.$plus$eq(x);
                return this;
            }

            public void clear() {
                this.b.clear();
            }

            public BitSet result() {
                return this.b.toImmutable();
            }
            {
                Growable.$init$(this);
                Builder.$init$(this);
                this.b = new scala.collection.mutable.BitSet();
            }
        };
    }

    public CanBuildFrom<BitSet, Object, BitSet> canBuildFrom() {
        return this.canBuildFrom;
    }

    public BitSet fromBitMask(long[] elems) {
        int len = elems.length;
        if (len == 0) {
            return this.empty();
        }
        if (len == 1) {
            return new BitSet.BitSet1(elems[0]);
        }
        if (len == 2) {
            return this.scala$collection$immutable$BitSet$$createSmall(elems[0], elems[1]);
        }
        long[] a = new long[len];
        Array$.MODULE$.copy(elems, 0, a, 0, len);
        return new BitSet.BitSetN(a);
    }

    public BitSet fromBitMaskNoCopy(long[] elems) {
        int len = elems.length;
        if (len == 0) {
            return this.empty();
        }
        if (len == 1) {
            return new BitSet.BitSet1(elems[0]);
        }
        if (len == 2) {
            return this.scala$collection$immutable$BitSet$$createSmall(elems[0], elems[1]);
        }
        return new BitSet.BitSetN(elems);
    }

    private Object readResolve() {
        return MODULE$;
    }

    private BitSet$() {
        MODULE$ = this;
        BitSetFactory.$init$(this);
        this.empty = new BitSet.BitSet1(0L);
        this.canBuildFrom = this.bitsetCanBuildFrom();
    }
}

