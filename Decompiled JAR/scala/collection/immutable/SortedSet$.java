/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.ImmutableSortedSetFactory;
import scala.collection.immutable.SortedSet;
import scala.collection.immutable.TreeSet$;
import scala.collection.mutable.Builder;
import scala.math.Ordering;

public final class SortedSet$
extends ImmutableSortedSetFactory<SortedSet> {
    public static SortedSet$ MODULE$;

    static {
        new SortedSet$();
    }

    public <A> CanBuildFrom<SortedSet<?>, A, SortedSet<A>> canBuildFrom(Ordering<A> ord) {
        return this.newCanBuildFrom(ord);
    }

    @Override
    public <A> SortedSet<A> empty(Ordering<A> ord) {
        return TreeSet$.MODULE$.empty((Ordering)ord);
    }

    @Override
    public <A> Builder<A, SortedSet<A>> newBuilder(Ordering<A> ord) {
        return TreeSet$.MODULE$.newBuilder(ord);
    }

    @Override
    public <A> CanBuildFrom<SortedSet<?>, A, SortedSet<A>> newCanBuildFrom(Ordering<A> ord) {
        return super.newCanBuildFrom(ord);
    }

    private SortedSet$() {
        MODULE$ = this;
    }
}

