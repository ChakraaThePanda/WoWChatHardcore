/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.collection.BitSet;
import scala.collection.Seq;
import scala.collection.generic.BitSetFactory;
import scala.collection.generic.CanBuildFrom;
import scala.collection.mutable.Builder;

public final class BitSet$
implements BitSetFactory<BitSet> {
    public static BitSet$ MODULE$;
    private final BitSet empty;
    private final CanBuildFrom<BitSet, Object, BitSet> canBuildFrom;

    static {
        new BitSet$();
    }

    @Override
    public BitSet apply(Seq<Object> elems) {
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

    @Override
    public Builder<Object, scala.collection.immutable.BitSet> newBuilder() {
        return scala.collection.immutable.BitSet$.MODULE$.newBuilder();
    }

    public CanBuildFrom<BitSet, Object, BitSet> canBuildFrom() {
        return this.canBuildFrom;
    }

    private BitSet$() {
        MODULE$ = this;
        BitSetFactory.$init$(this);
        this.empty = scala.collection.immutable.BitSet$.MODULE$.empty();
        this.canBuildFrom = this.bitsetCanBuildFrom();
    }
}

