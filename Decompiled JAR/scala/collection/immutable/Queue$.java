/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.Function1;
import scala.Proxy;
import scala.Serializable;
import scala.collection.Seq;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.Growable;
import scala.collection.generic.SeqFactory;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Queue;
import scala.collection.immutable.Queue$EmptyQueue$;
import scala.collection.mutable.Builder;
import scala.collection.mutable.Builder$;
import scala.collection.mutable.ListBuffer;
import scala.runtime.Nothing$;

public final class Queue$
extends SeqFactory<Queue>
implements Serializable {
    public static Queue$ MODULE$;

    static {
        new Queue$();
    }

    public <A> CanBuildFrom<Queue<?>, A, Queue<A>> canBuildFrom() {
        return this.ReusableCBF();
    }

    @Override
    public <A> Builder<A, Queue<A>> newBuilder() {
        Function1<List, Queue> & java.io.Serializable & Serializable mapResult_f = (Function1<List, Queue> & java.io.Serializable & Serializable)x -> new Queue<Nothing$>(Nil$.MODULE$, x.toList());
        ListBuffer mapResult_this = new ListBuffer();
        return new Builder<Elem, NewTo>(mapResult_this, mapResult_f){
            private final Builder<Elem, To> self;
            private final Function1 f$1;

            public int hashCode() {
                return Proxy.hashCode$(this);
            }

            public boolean equals(Object that) {
                return Proxy.equals$(this, that);
            }

            public String toString() {
                return Proxy.toString$(this);
            }

            public void sizeHint(TraversableLike<?, ?> coll) {
                Builder.sizeHint$((Builder)this, coll);
            }

            public void sizeHint(TraversableLike<?, ?> coll, int delta) {
                Builder.sizeHint$(this, coll, delta);
            }

            public <NewTo> Builder<Elem, NewTo> mapResult(Function1<NewTo, NewTo> f) {
                return Builder.mapResult$(this, f);
            }

            public Growable<Elem> $plus$eq(Elem elem1, Elem elem2, Seq<Elem> elems) {
                return Growable.$plus$eq$(this, elem1, elem2, elems);
            }

            public Builder<Elem, To> self() {
                return this.self;
            }

            public Builder$.anon.1 $plus$eq(Elem x) {
                this.self().$plus$eq(x);
                return this;
            }

            public void clear() {
                this.self().clear();
            }

            public Builder$.anon.1 $plus$plus$eq(TraversableOnce<Elem> xs) {
                this.self().$plus$plus$eq(xs);
                return this;
            }

            public void sizeHint(int size) {
                this.self().sizeHint(size);
            }

            public void sizeHintBounded(int size, TraversableLike<?, ?> boundColl) {
                this.self().sizeHintBounded(size, boundColl);
            }

            public NewTo result() {
                return (NewTo)this.f$1.apply(this.self().result());
            }
            {
                this.f$1 = f$1;
                Growable.$init$(this);
                Builder.$init$(this);
                Proxy.$init$(this);
                this.self = $outer;
            }
        };
    }

    @Override
    public <A> Queue<A> empty() {
        return Queue$EmptyQueue$.MODULE$;
    }

    @Override
    public <A> Queue<A> apply(Seq<A> xs) {
        return new Queue<Nothing$>(Nil$.MODULE$, xs.toList());
    }

    private Object readResolve() {
        return MODULE$;
    }

    private Queue$() {
        MODULE$ = this;
    }
}

