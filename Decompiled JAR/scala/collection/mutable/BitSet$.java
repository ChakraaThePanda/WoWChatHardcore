/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Array$;
import scala.Serializable;
import scala.collection.Seq;
import scala.collection.generic.BitSetFactory;
import scala.collection.generic.CanBuildFrom;
import scala.collection.mutable.BitSet;
import scala.collection.mutable.Builder;
import scala.collection.mutable.GrowingBuilder;

public final class BitSet$
implements BitSetFactory<BitSet>,
Serializable {
    public static BitSet$ MODULE$;
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
        return new BitSet();
    }

    @Override
    public Builder<Object, BitSet> newBuilder() {
        return new GrowingBuilder<Object, BitSet>(this.empty());
    }

    public CanBuildFrom<BitSet, Object, BitSet> canBuildFrom() {
        return this.canBuildFrom;
    }

    public BitSet fromBitMask(long[] elems) {
        int len = elems.length;
        if (len == 0) {
            return this.empty();
        }
        long[] a = new long[len];
        Array$.MODULE$.copy(elems, 0, a, 0, len);
        return new BitSet(a);
    }

    public BitSet fromBitMaskNoCopy(long[] elems) {
        if (elems.length == 0) {
            return this.empty();
        }
        return new BitSet(elems);
    }

    private Object readResolve() {
        return MODULE$;
    }

    private BitSet$() {
        MODULE$ = this;
        BitSetFactory.$init$(this);
        this.canBuildFrom = this.bitsetCanBuildFrom();
    }
}

