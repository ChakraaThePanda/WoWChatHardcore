/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.mutable;

import scala.Function1;
import scala.collection.Seq;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.Growable;
import scala.collection.mutable.Builder;
import scala.collection.mutable.DoublingUnrolledBuffer;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.TaskSupport;
import scala.collection.parallel.mutable.ParArray;
import scala.collection.parallel.mutable.UnrolledParArrayCombiner;

public final class UnrolledParArrayCombiner$ {
    public static UnrolledParArrayCombiner$ MODULE$;

    static {
        new UnrolledParArrayCombiner$();
    }

    public <T> UnrolledParArrayCombiner<T> apply() {
        return new UnrolledParArrayCombiner<T>(){
            private final DoublingUnrolledBuffer<Object> buff;
            private volatile transient TaskSupport _combinerTaskSupport;

            public UnrolledParArrayCombiner<T> $plus$eq(T elem) {
                return UnrolledParArrayCombiner.$plus$eq$(this, elem);
            }

            public ParArray<T> result() {
                return UnrolledParArrayCombiner.result$(this);
            }

            public void clear() {
                UnrolledParArrayCombiner.clear$(this);
            }

            public void sizeHint(int sz) {
                UnrolledParArrayCombiner.sizeHint$(this, sz);
            }

            public <N extends T, NewTo> Combiner<N, NewTo> combine(Combiner<N, NewTo> other) {
                return UnrolledParArrayCombiner.combine$(this, other);
            }

            public int size() {
                return UnrolledParArrayCombiner.size$(this);
            }

            public TaskSupport combinerTaskSupport() {
                return Combiner.combinerTaskSupport$(this);
            }

            public void combinerTaskSupport_$eq(TaskSupport cts) {
                Combiner.combinerTaskSupport_$eq$(this, cts);
            }

            public boolean canBeShared() {
                return Combiner.canBeShared$(this);
            }

            public Object resultWithTaskSupport() {
                return Combiner.resultWithTaskSupport$(this);
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

            public <NewTo> Builder<T, NewTo> mapResult(Function1<ParArray<T>, NewTo> f) {
                return Builder.mapResult$(this, f);
            }

            public Growable<T> $plus$eq(T elem1, T elem2, Seq<T> elems) {
                return Growable.$plus$eq$(this, elem1, elem2, elems);
            }

            public Growable<T> $plus$plus$eq(TraversableOnce<T> xs) {
                return Growable.$plus$plus$eq$(this, xs);
            }

            public DoublingUnrolledBuffer<Object> buff() {
                return this.buff;
            }

            public void scala$collection$parallel$mutable$UnrolledParArrayCombiner$_setter_$buff_$eq(DoublingUnrolledBuffer<Object> x$1) {
                this.buff = x$1;
            }

            public TaskSupport _combinerTaskSupport() {
                return this._combinerTaskSupport;
            }

            public void _combinerTaskSupport_$eq(TaskSupport x$1) {
                this._combinerTaskSupport = x$1;
            }
            {
                Growable.$init$(this);
                Builder.$init$(this);
                Combiner.$init$(this);
                UnrolledParArrayCombiner.$init$(this);
            }
        };
    }

    private UnrolledParArrayCombiner$() {
        MODULE$ = this;
    }
}

