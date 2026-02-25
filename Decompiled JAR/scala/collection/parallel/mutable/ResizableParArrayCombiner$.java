/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.mutable;

import scala.Function1;
import scala.collection.Seq;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.Growable;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.Builder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.TaskSupport;
import scala.collection.parallel.mutable.ExposedArrayBuffer;
import scala.collection.parallel.mutable.LazyCombiner;
import scala.collection.parallel.mutable.ParArray;
import scala.collection.parallel.mutable.ResizableParArrayCombiner;

public final class ResizableParArrayCombiner$ {
    public static ResizableParArrayCombiner$ MODULE$;

    static {
        new ResizableParArrayCombiner$();
    }

    public <T> ResizableParArrayCombiner<T> apply(ArrayBuffer<ExposedArrayBuffer<T>> c) {
        return new ResizableParArrayCombiner<T>(c){
            private final ArrayBuffer<ExposedArrayBuffer<T>> chain;
            private final ExposedArrayBuffer<T> lastbuff;
            private volatile transient TaskSupport _combinerTaskSupport;

            public void sizeHint(int sz) {
                ResizableParArrayCombiner.sizeHint$(this, sz);
            }

            public final ResizableParArrayCombiner<T> newLazyCombiner(ArrayBuffer<ExposedArrayBuffer<T>> c) {
                return ResizableParArrayCombiner.newLazyCombiner$(this, c);
            }

            public ParArray<T> allocateAndCopy() {
                return ResizableParArrayCombiner.allocateAndCopy$(this);
            }

            public String toString() {
                return ResizableParArrayCombiner.toString$(this);
            }

            public LazyCombiner<T, ParArray<T>, ExposedArrayBuffer<T>> $plus$eq(T elem) {
                return LazyCombiner.$plus$eq$(this, elem);
            }

            public Object result() {
                return LazyCombiner.result$(this);
            }

            public void clear() {
                LazyCombiner.clear$(this);
            }

            public <N extends T, NewTo> Combiner<N, NewTo> combine(Combiner<N, NewTo> other) {
                return LazyCombiner.combine$(this, other);
            }

            public int size() {
                return LazyCombiner.size$(this);
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

            public ExposedArrayBuffer<T> lastbuff() {
                return this.lastbuff;
            }

            public void scala$collection$parallel$mutable$LazyCombiner$_setter_$lastbuff_$eq(ExposedArrayBuffer<T> x$1) {
                this.lastbuff = x$1;
            }

            public TaskSupport _combinerTaskSupport() {
                return this._combinerTaskSupport;
            }

            public void _combinerTaskSupport_$eq(TaskSupport x$1) {
                this._combinerTaskSupport = x$1;
            }

            public ArrayBuffer<ExposedArrayBuffer<T>> chain() {
                return this.chain;
            }
            {
                this.chain = c$1;
                Growable.$init$(this);
                Builder.$init$(this);
                Combiner.$init$(this);
                LazyCombiner.$init$(this);
                ResizableParArrayCombiner.$init$(this);
            }
        };
    }

    public <T> ResizableParArrayCombiner<T> apply() {
        return this.apply((ArrayBuffer<ExposedArrayBuffer<T>>)new ArrayBuffer().$plus$eq(new ExposedArrayBuffer()));
    }

    private ResizableParArrayCombiner$() {
        MODULE$ = this;
    }
}

