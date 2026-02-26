/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.collection.IndexedSeq;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.IndexedSeqFactory;
import scala.collection.mutable.Builder;

public final class IndexedSeq$
extends IndexedSeqFactory<IndexedSeq> {
    public static IndexedSeq$ MODULE$;

    static {
        new IndexedSeq$();
    }

    @Override
    public <A> Builder<A, IndexedSeq<A>> newBuilder() {
        return scala.collection.immutable.IndexedSeq$.MODULE$.newBuilder();
    }

    public <A> CanBuildFrom<IndexedSeq<?>, A, IndexedSeq<A>> canBuildFrom() {
        return this.ReusableCBF();
    }

    private IndexedSeq$() {
        MODULE$ = this;
    }
}

