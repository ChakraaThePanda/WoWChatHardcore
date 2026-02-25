/*
 * Decompiled with CFR 0.152.
 */
package scala.concurrent;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Predef$ArrowAssoc$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.Iterator;
import scala.collection.TraversableOnce;
import scala.collection.TraversableOnce$;
import scala.collection.generic.CanBuildFrom;
import scala.collection.immutable.Iterable;
import scala.collection.immutable.Map;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.concurrent.ExecutionContext;
import scala.concurrent.Future;
import scala.concurrent.Future$InternalCallbackExecutor$;
import scala.concurrent.Promise;
import scala.concurrent.Promise$;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.util.Success;
import scala.util.Try;

public final class Future$ {
    public static Future$ MODULE$;
    private final Map<Class<?>, Class<?>> toBoxed;
    private final Future<BoxedUnit> unit;

    static {
        new Future$();
    }

    public Map<Class<?>, Class<?>> toBoxed() {
        return this.toBoxed;
    }

    public Future<BoxedUnit> unit() {
        return this.unit;
    }

    public <T> Future<T> failed(Throwable exception) {
        return Promise$.MODULE$.failed(exception).future();
    }

    public <T> Future<T> successful(T result2) {
        return Promise$.MODULE$.successful(result2).future();
    }

    public <T> Future<T> fromTry(Try<T> result2) {
        return Promise$.MODULE$.fromTry(result2).future();
    }

    public <T> Future<T> apply(Function0<T> body, ExecutionContext executor) {
        return this.unit().map((Function1<BoxedUnit, Object> & java.io.Serializable & Serializable)x$5 -> body.apply(), executor);
    }

    public <A, M extends TraversableOnce<Object>> Future<M> sequence(M in, CanBuildFrom<M, A, M> cbf, ExecutionContext executor) {
        return in.foldLeft(this.successful(cbf.apply(in)), (Function2<Future, Future, Future> & java.io.Serializable & Serializable)(fr, fa) -> fr.zipWith(fa, (Function2<Builder, Object, Builder> & java.io.Serializable & Serializable)(x$6, x$7) -> x$6.$plus$eq(x$7), executor)).map((Function1<Builder, TraversableOnce> & java.io.Serializable & Serializable)x$8 -> (TraversableOnce)x$8.result(), Future$InternalCallbackExecutor$.MODULE$);
    }

    public <T> Future<T> firstCompletedOf(TraversableOnce<Future<T>> futures, ExecutionContext executor) {
        Promise p = Promise$.MODULE$.apply();
        Function1 firstCompleteHandler = new Function1<Try<T>, BoxedUnit>(p){

            public boolean apply$mcZD$sp(double v1) {
                return Function1.apply$mcZD$sp$(this, v1);
            }

            public double apply$mcDD$sp(double v1) {
                return Function1.apply$mcDD$sp$(this, v1);
            }

            public float apply$mcFD$sp(double v1) {
                return Function1.apply$mcFD$sp$(this, v1);
            }

            public int apply$mcID$sp(double v1) {
                return Function1.apply$mcID$sp$(this, v1);
            }

            public long apply$mcJD$sp(double v1) {
                return Function1.apply$mcJD$sp$(this, v1);
            }

            public void apply$mcVD$sp(double v1) {
                Function1.apply$mcVD$sp$(this, v1);
            }

            public boolean apply$mcZF$sp(float v1) {
                return Function1.apply$mcZF$sp$(this, v1);
            }

            public double apply$mcDF$sp(float v1) {
                return Function1.apply$mcDF$sp$(this, v1);
            }

            public float apply$mcFF$sp(float v1) {
                return Function1.apply$mcFF$sp$(this, v1);
            }

            public int apply$mcIF$sp(float v1) {
                return Function1.apply$mcIF$sp$(this, v1);
            }

            public long apply$mcJF$sp(float v1) {
                return Function1.apply$mcJF$sp$(this, v1);
            }

            public void apply$mcVF$sp(float v1) {
                Function1.apply$mcVF$sp$(this, v1);
            }

            public boolean apply$mcZI$sp(int v1) {
                return Function1.apply$mcZI$sp$(this, v1);
            }

            public double apply$mcDI$sp(int v1) {
                return Function1.apply$mcDI$sp$(this, v1);
            }

            public float apply$mcFI$sp(int v1) {
                return Function1.apply$mcFI$sp$(this, v1);
            }

            public int apply$mcII$sp(int v1) {
                return Function1.apply$mcII$sp$(this, v1);
            }

            public long apply$mcJI$sp(int v1) {
                return Function1.apply$mcJI$sp$(this, v1);
            }

            public void apply$mcVI$sp(int v1) {
                Function1.apply$mcVI$sp$(this, v1);
            }

            public boolean apply$mcZJ$sp(long v1) {
                return Function1.apply$mcZJ$sp$(this, v1);
            }

            public double apply$mcDJ$sp(long v1) {
                return Function1.apply$mcDJ$sp$(this, v1);
            }

            public float apply$mcFJ$sp(long v1) {
                return Function1.apply$mcFJ$sp$(this, v1);
            }

            public int apply$mcIJ$sp(long v1) {
                return Function1.apply$mcIJ$sp$(this, v1);
            }

            public long apply$mcJJ$sp(long v1) {
                return Function1.apply$mcJJ$sp$(this, v1);
            }

            public void apply$mcVJ$sp(long v1) {
                Function1.apply$mcVJ$sp$(this, v1);
            }

            public <A> Function1<A, BoxedUnit> compose(Function1<A, Try<T>> g) {
                return Function1.compose$(this, g);
            }

            public <A> Function1<Try<T>, A> andThen(Function1<BoxedUnit, A> g) {
                return Function1.andThen$(this, g);
            }

            public String toString() {
                return Function1.toString$(this);
            }

            public void apply(Try<T> v1) {
                Promise promise = this.getAndSet(null);
                if (promise == null) {
                    return;
                }
                promise.tryComplete(v1);
            }
        };
        futures.foreach(arg_0 -> Future$.$anonfun$firstCompletedOf$1$adapted((AtomicReference)((Object)firstCompleteHandler), executor, arg_0));
        return p.future();
    }

    public <T> Future<Option<T>> find(TraversableOnce<Future<T>> futures, Function1<T, Object> p, ExecutionContext executor) {
        Buffer futuresBuffer = futures.toBuffer();
        if (futuresBuffer.isEmpty()) {
            return this.successful(None$.MODULE$);
        }
        Promise result2 = Promise$.MODULE$.apply();
        AtomicInteger ref = new AtomicInteger(futuresBuffer.size());
        Function1<Try, Object> & java.io.Serializable & Serializable search = (Function1<Try, Object> & java.io.Serializable & Serializable)v -> {
            Future$.$anonfun$find$1(p, result2, ref, v);
            return BoxedUnit.UNIT;
        };
        futuresBuffer.foreach((Function1<Future, Object> & java.io.Serializable & Serializable)x$10 -> {
            x$10.onComplete(search, executor);
            return BoxedUnit.UNIT;
        });
        return result2.future();
    }

    public <T> Future<Option<T>> find(Iterable<Future<T>> futures, Function1<T, Object> p, ExecutionContext executor) {
        Iterator searchNext$1_i = futures.iterator();
        if (!searchNext$1_i.hasNext()) {
            return this.successful(None$.MODULE$);
        }
        return ((Future)searchNext$1_i.next()).transformWith((Function1<Try, Future> & java.io.Serializable & Serializable)x0$1 -> {
            Object r;
            Future<Option> future = x0$1 instanceof Success && BoxesRunTime.unboxToBoolean(p.apply(r = ((Success)x0$1).value())) ? MODULE$.successful(new Some(r)) : (!searchNext$1_i.hasNext() ? this.successful(None$.MODULE$) : ((Future)searchNext$1_i.next()).transformWith(arg_0 -> Future$.$anonfun$find$3(this, p, searchNext$1_i, executor, arg_0), executor));
            return future;
        }, executor);
    }

    public <T, R> Future<R> foldLeft(Iterable<Future<T>> futures, R zero, Function2<R, T, R> op, ExecutionContext executor) {
        Iterator foldNext_i = futures.iterator();
        if (!foldNext_i.hasNext()) {
            return this.successful(zero);
        }
        return ((Future)foldNext_i.next()).flatMap((Function1<Object, Future> & java.io.Serializable & Serializable)value -> {
            void foldNext_prevValue;
            Future$ future$ = MODULE$;
            Object r = op.apply(v, value);
            if (future$ == null) {
                throw null;
            }
            Future$ foldNext_this = future$;
            if (!i.hasNext()) {
                return foldNext_this.successful(foldNext_prevValue);
            }
            return ((Future)i.next()).flatMap(arg_0 -> Future$.$anonfun$foldNext$1(i, op, foldNext_prevValue, executor, arg_0), executor);
        }, executor);
    }

    private <T, R> Future<R> foldNext(Iterator<Future<T>> i, R prevValue, Function2<R, T, R> op, ExecutionContext executor) {
        if (!i.hasNext()) {
            return this.successful(prevValue);
        }
        return i.next().flatMap((Function1<Object, Future> & java.io.Serializable & Serializable)value -> {
            void foldNext_prevValue;
            Future$ future$ = MODULE$;
            Object r = op.apply(v, value);
            if (future$ == null) {
                throw null;
            }
            Future$ foldNext_this = future$;
            if (!i.hasNext()) {
                return foldNext_this.successful(foldNext_prevValue);
            }
            return ((Future)i.next()).flatMap(arg_0 -> Future$.$anonfun$foldNext$1(i, op, foldNext_prevValue, executor, arg_0), executor);
        }, executor);
    }

    public <T, R> Future<R> fold(TraversableOnce<Future<T>> futures, R zero, Function2<R, T, R> op, ExecutionContext executor) {
        if (futures.isEmpty()) {
            return this.successful(zero);
        }
        return this.sequence(futures, TraversableOnce$.MODULE$.OnceCanBuildFrom(), executor).map((Function1<TraversableOnce, Object> & java.io.Serializable & Serializable)x$11 -> x$11.foldLeft(zero, op), executor);
    }

    public <T, R> Future<R> reduce(TraversableOnce<Future<T>> futures, Function2<R, T, R> op, ExecutionContext executor) {
        if (futures.isEmpty()) {
            return this.failed(new NoSuchElementException("reduce attempted on empty collection"));
        }
        return this.sequence(futures, TraversableOnce$.MODULE$.OnceCanBuildFrom(), executor).map((Function1<TraversableOnce, Object> & java.io.Serializable & Serializable)x$12 -> x$12.reduceLeft(op), executor);
    }

    public <T, R> Future<R> reduceLeft(Iterable<Future<T>> futures, Function2<R, T, R> op, ExecutionContext executor) {
        Iterator i = futures.iterator();
        if (!i.hasNext()) {
            return this.failed(new NoSuchElementException("reduceLeft attempted on empty collection"));
        }
        return ((Future)i.next()).flatMap((Function1<Object, Future> & java.io.Serializable & Serializable)v -> {
            Future$ future$ = MODULE$;
            if (future$ == null) {
                throw null;
            }
            Future$ foldNext_this = future$;
            if (!i.hasNext()) {
                return foldNext_this.successful(v);
            }
            return ((Future)i.next()).flatMap((Function1<Object, Future> & java.io.Serializable & Serializable)value -> {
                void foldNext_prevValue;
                Future$ future$ = MODULE$;
                Object r = op.apply(v, value);
                if (future$ == null) {
                    throw null;
                }
                Future$ foldNext_this = future$;
                if (!i.hasNext()) {
                    return foldNext_this.successful(foldNext_prevValue);
                }
                return ((Future)i.next()).flatMap(arg_0 -> Future$.$anonfun$foldNext$1(i, op, foldNext_prevValue, executor, arg_0), executor);
            }, executor);
        }, executor);
    }

    public <A, B, M extends TraversableOnce<Object>> Future<M> traverse(M in, Function1<A, Future<B>> fn, CanBuildFrom<M, B, M> cbf, ExecutionContext executor) {
        return in.foldLeft(this.successful(cbf.apply(in)), (Function2<Future, Object, Future> & java.io.Serializable & Serializable)(fr, a) -> fr.zipWith((Future)fn.apply(a), (Function2<Builder, Object, Builder> & java.io.Serializable & Serializable)(x$13, x$14) -> x$13.$plus$eq(x$14), executor)).map((Function1<Builder, TraversableOnce> & java.io.Serializable & Serializable)x$15 -> (TraversableOnce)x$15.result(), Future$InternalCallbackExecutor$.MODULE$);
    }

    public static final /* synthetic */ void $anonfun$find$1(Function1 p$3, Promise result$1, AtomicInteger ref$1, Try v) {
        try {
            Object r;
            if (v instanceof Success && BoxesRunTime.unboxToBoolean(p$3.apply(r = ((Success)v).value()))) {
                result$1.tryComplete(new Success(new Some(r)));
            }
        }
        finally {
            if (ref$1.decrementAndGet() == 0) {
                result$1.tryComplete(new Success<None$>(None$.MODULE$));
            }
        }
    }

    public static final /* synthetic */ void $anonfun$find$2(Function1 search$1, ExecutionContext executor$5, Future x$10) {
        x$10.onComplete(search$1, executor$5);
    }

    private final Future searchNext$1(Iterator i, Function1 p$4, ExecutionContext executor$6) {
        if (!i.hasNext()) {
            return this.successful(None$.MODULE$);
        }
        return ((Future)i.next()).transformWith((Function1<Try, Future> & java.io.Serializable & Serializable)x0$1 -> {
            Object r;
            Future<Option> future = x0$1 instanceof Success && BoxesRunTime.unboxToBoolean(p.apply(r = ((Success)x0$1).value())) ? MODULE$.successful(new Some(r)) : (!searchNext$1_i.hasNext() ? this.successful(None$.MODULE$) : ((Future)searchNext$1_i.next()).transformWith(arg_0 -> Future$.$anonfun$find$3(this, p, searchNext$1_i, executor, arg_0), executor));
            return future;
        }, executor$6);
    }

    /*
     * WARNING - void declaration
     */
    private Future$() {
        void $minus$greater$extension_y;
        void $minus$greater$extension_$this;
        void $minus$greater$extension_y2;
        void $minus$greater$extension_$this2;
        void $minus$greater$extension_y3;
        void $minus$greater$extension_$this3;
        void $minus$greater$extension_y4;
        void $minus$greater$extension_$this4;
        void $minus$greater$extension_y5;
        void $minus$greater$extension_$this5;
        void $minus$greater$extension_y6;
        void $minus$greater$extension_$this6;
        void $minus$greater$extension_y7;
        void $minus$greater$extension_$this7;
        void $minus$greater$extension_y8;
        void $minus$greater$extension_$this8;
        void $minus$greater$extension_y9;
        void $minus$greater$extension_$this9;
        MODULE$ = this;
        Tuple2[] tuple2Array = new Tuple2[9];
        Class<Boolean> clazz = Boolean.class;
        Class<Boolean> clazz2 = Predef$.MODULE$.ArrowAssoc(Boolean.TYPE);
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[0] = new Tuple2<void, void>($minus$greater$extension_$this9, $minus$greater$extension_y9);
        Class<Byte> clazz3 = Byte.class;
        Class<Byte> clazz4 = Predef$.MODULE$.ArrowAssoc(Byte.TYPE);
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[1] = new Tuple2<void, void>($minus$greater$extension_$this8, $minus$greater$extension_y8);
        Class<Character> clazz5 = Character.class;
        Class<Character> clazz6 = Predef$.MODULE$.ArrowAssoc(Character.TYPE);
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[2] = new Tuple2<void, void>($minus$greater$extension_$this7, $minus$greater$extension_y7);
        Class<Short> clazz7 = Short.class;
        Class<Short> clazz8 = Predef$.MODULE$.ArrowAssoc(Short.TYPE);
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[3] = new Tuple2<void, void>($minus$greater$extension_$this6, $minus$greater$extension_y6);
        Class<Integer> clazz9 = Integer.class;
        Class<Integer> clazz10 = Predef$.MODULE$.ArrowAssoc(Integer.TYPE);
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[4] = new Tuple2<void, void>($minus$greater$extension_$this5, $minus$greater$extension_y5);
        Class<Long> clazz11 = Long.class;
        Class<Long> clazz12 = Predef$.MODULE$.ArrowAssoc(Long.TYPE);
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[5] = new Tuple2<void, void>($minus$greater$extension_$this4, $minus$greater$extension_y4);
        Class<Float> clazz13 = Float.class;
        Class<Float> clazz14 = Predef$.MODULE$.ArrowAssoc(Float.TYPE);
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[6] = new Tuple2<void, void>($minus$greater$extension_$this3, $minus$greater$extension_y3);
        Class<Double> clazz15 = Double.class;
        Class<Double> clazz16 = Predef$.MODULE$.ArrowAssoc(Double.TYPE);
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[7] = new Tuple2<void, void>($minus$greater$extension_$this2, $minus$greater$extension_y2);
        Class<BoxedUnit> clazz17 = BoxedUnit.class;
        Class<Void> clazz18 = Predef$.MODULE$.ArrowAssoc(BoxedUnit.TYPE);
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[8] = new Tuple2<void, void>($minus$greater$extension_$this, $minus$greater$extension_y);
        this.toBoxed = (Map)Predef$.MODULE$.Map().apply(Predef$.MODULE$.wrapRefArray((Object[])tuple2Array));
        this.unit = this.successful(BoxedUnit.UNIT);
    }

    public static final /* synthetic */ Object $anonfun$firstCompletedOf$1$adapted(AtomicReference firstCompleteHandler$1, ExecutionContext executor$4, Future x$9) {
        x$9.onComplete((Function1)((Object)firstCompleteHandler$1), executor$4);
        return BoxedUnit.UNIT;
    }
}

