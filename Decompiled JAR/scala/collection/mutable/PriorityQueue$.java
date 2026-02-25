/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function1;
import scala.Serializable;
import scala.collection.Seq;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.Growable;
import scala.collection.generic.OrderedTraversableFactory;
import scala.collection.mutable.Builder;
import scala.collection.mutable.PriorityQueue;
import scala.collection.mutable.PriorityQueue$;
import scala.math.Ordering;

public final class PriorityQueue$
extends OrderedTraversableFactory<PriorityQueue>
implements Serializable {
    public static PriorityQueue$ MODULE$;

    static {
        new PriorityQueue$();
    }

    @Override
    public <A> Builder<A, PriorityQueue<A>> newBuilder(Ordering<A> ord) {
        return new Builder<A, PriorityQueue<A>>(ord){
            private final PriorityQueue<A> pq;

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

            public <NewTo> Builder<A, NewTo> mapResult(Function1<PriorityQueue<A>, NewTo> f) {
                return Builder.mapResult$(this, f);
            }

            public Growable<A> $plus$eq(A elem1, A elem2, Seq<A> elems) {
                return Growable.$plus$eq$(this, elem1, elem2, elems);
            }

            public Growable<A> $plus$plus$eq(TraversableOnce<A> xs) {
                return Growable.$plus$plus$eq$(this, xs);
            }

            private PriorityQueue<A> pq() {
                return this.pq;
            }

            public anon.3 $plus$eq(A elem) {
                this.pq().scala$collection$mutable$PriorityQueue$$unsafeAdd(elem);
                return this;
            }

            public PriorityQueue<A> result() {
                this.pq().scala$collection$mutable$PriorityQueue$$heapify(1);
                return this.pq();
            }

            public void clear() {
                this.pq().clear();
            }
            {
                Growable.$init$(this);
                Builder.$init$(this);
                this.pq = new PriorityQueue<A>(ord$1);
            }
        };
    }

    public <A> CanBuildFrom<PriorityQueue<?>, A, PriorityQueue<A>> canBuildFrom(Ordering<A> ord) {
        return new OrderedTraversableFactory.GenericCanBuildFrom<A>(this, ord);
    }

    private Object readResolve() {
        return MODULE$;
    }

    private PriorityQueue$() {
        MODULE$ = this;
    }
}

