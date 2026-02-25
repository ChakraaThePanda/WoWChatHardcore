/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.Serializable;
import scala.collection.generic.ImmutableSortedSetFactory;
import scala.collection.immutable.TreeSet;
import scala.collection.mutable.Builder;
import scala.math.Ordering;

public final class TreeSet$
extends ImmutableSortedSetFactory<TreeSet>
implements Serializable {
    public static TreeSet$ MODULE$;

    static {
        new TreeSet$();
    }

    public <A> Builder<A, TreeSet<A>> implicitBuilder(Ordering<A> ordering) {
        return this.newBuilder(ordering);
    }

    @Override
    public <A> Builder<A, TreeSet<A>> newBuilder(Ordering<A> ordering) {
        return new TreeSet.TreeSetBuilder<A>(ordering);
    }

    @Override
    public <A> TreeSet<A> empty(Ordering<A> ordering) {
        return new TreeSet<A>(ordering);
    }

    private Object readResolve() {
        return MODULE$;
    }

    private TreeSet$() {
        MODULE$ = this;
    }
}

