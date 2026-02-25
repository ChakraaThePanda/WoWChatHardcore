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
import scala.collection.generic.SeqFactory;
import scala.collection.mutable.Builder;
import scala.collection.mutable.DoubleLinkedList;
import scala.collection.mutable.DoubleLinkedList$;

public final class DoubleLinkedList$
extends SeqFactory<DoubleLinkedList>
implements Serializable {
    public static DoubleLinkedList$ MODULE$;

    static {
        new DoubleLinkedList$();
    }

    public <A> CanBuildFrom<DoubleLinkedList<?>, A, DoubleLinkedList<A>> canBuildFrom() {
        return this.ReusableCBF();
    }

    @Override
    public <A> Builder<A, DoubleLinkedList<A>> newBuilder() {
        return new Builder<A, DoubleLinkedList<A>>(){
            private DoubleLinkedList<A> current;

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

            public <NewTo> Builder<A, NewTo> mapResult(Function1<DoubleLinkedList<A>, NewTo> f) {
                return Builder.mapResult$(this, f);
            }

            public Growable<A> $plus$eq(A elem1, A elem2, Seq<A> elems) {
                return Growable.$plus$eq$(this, elem1, elem2, elems);
            }

            public Growable<A> $plus$plus$eq(TraversableOnce<A> xs) {
                return Growable.$plus$plus$eq$(this, xs);
            }

            private DoubleLinkedList<A> emptyList() {
                return new DoubleLinkedList<A>();
            }

            private DoubleLinkedList<A> current() {
                return this.current;
            }

            private void current_$eq(DoubleLinkedList<A> x$1) {
                this.current = x$1;
            }

            public anon.1 $plus$eq(A elem) {
                if (this.current().isEmpty()) {
                    this.current_$eq(new DoubleLinkedList<A>(elem, this.emptyList()));
                } else {
                    this.current().append(new DoubleLinkedList<A>(elem, this.emptyList()));
                }
                return this;
            }

            public void clear() {
                this.current_$eq(this.emptyList());
            }

            public DoubleLinkedList<A> result() {
                return this.current();
            }
            {
                Growable.$init$(this);
                Builder.$init$(this);
                this.current = this.emptyList();
            }
        };
    }

    private Object readResolve() {
        return MODULE$;
    }

    private DoubleLinkedList$() {
        MODULE$ = this;
    }
}

