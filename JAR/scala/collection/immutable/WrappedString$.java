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
import scala.collection.immutable.WrappedString;
import scala.collection.mutable.Builder;
import scala.collection.mutable.Builder$;
import scala.collection.mutable.StringBuilder;
import scala.collection.mutable.StringBuilder$;

public final class WrappedString$ {
    public static WrappedString$ MODULE$;
    private final CanBuildFrom<WrappedString, Object, WrappedString> canBuildFrom;

    static {
        new WrappedString$();
    }

    public CanBuildFrom<WrappedString, Object, WrappedString> canBuildFrom() {
        return this.canBuildFrom;
    }

    /*
     * WARNING - void declaration
     */
    public Builder<Object, WrappedString> newBuilder() {
        void mapResult_f;
        StringBuilder stringBuilder = StringBuilder$.MODULE$.newBuilder();
        Function1<String, WrappedString> & java.io.Serializable & Serializable intersect = (Function1<String, WrappedString> & java.io.Serializable & Serializable)x -> new WrappedString((String)x);
        if (stringBuilder == null) {
            throw null;
        }
        StringBuilder mapResult_this = stringBuilder;
        return new Builder<Elem, NewTo>(mapResult_this, (Function1)mapResult_f){
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

    private WrappedString$() {
        MODULE$ = this;
        this.canBuildFrom = new CanBuildFrom<WrappedString, Object, WrappedString>(){

            public Builder<Object, WrappedString> apply(WrappedString from) {
                return WrappedString$.MODULE$.newBuilder();
            }

            public Builder<Object, WrappedString> apply() {
                return WrappedString$.MODULE$.newBuilder();
            }
        };
    }
}

