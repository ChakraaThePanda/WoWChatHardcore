/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.Function4;
import scala.Function5;
import scala.MatchError;
import scala.Option;
import scala.PartialFunction;
import scala.PartialFunction$;
import scala.Serializable;
import scala.Tuple2;
import scala.Tuple3;
import scala.Tuple4;
import scala.Tuple5;
import scala.collection.Seq;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class Function$ {
    public static Function$ MODULE$;

    static {
        new Function$();
    }

    public <a> Function1<a, a> chain(Seq<Function1<a, a>> fs) {
        return (Function1<Object, Object> & java.io.Serializable & Serializable)x2 -> fs.$div$colon(x2, (Function2<Object, Function1, Object> & java.io.Serializable & Serializable)(x, f) -> f.apply(x));
    }

    public <T, U> T const(T x, U y) {
        return x;
    }

    public <T, R> PartialFunction<T, R> unlift(Function1<T, Option<R>> f) {
        if (PartialFunction$.MODULE$ == null) {
            throw null;
        }
        PartialFunction<Object, Object> partialFunction = f instanceof PartialFunction.Lifted ? ((PartialFunction.Lifted)f).pf() : new PartialFunction.Unlifted<T, R>(f);
        return partialFunction;
    }

    public <a1, a2, b> Function2<a1, a2, b> uncurried(Function1<a1, Function1<a2, b>> f) {
        return (Function2<Object, Object, Object> & java.io.Serializable & Serializable)(x1, x2) -> ((Function1)f.apply(x1)).apply(x2);
    }

    public <a1, a2, a3, b> Function3<a1, a2, a3, b> uncurried(Function1<a1, Function1<a2, Function1<a3, b>>> f) {
        return (Function3<Object, Object, Object, Object> & java.io.Serializable & Serializable)(x1, x2, x3) -> ((Function1)((Function1)f.apply(x1)).apply(x2)).apply(x3);
    }

    public <a1, a2, a3, a4, b> Function4<a1, a2, a3, a4, b> uncurried(Function1<a1, Function1<a2, Function1<a3, Function1<a4, b>>>> f) {
        return (Function4<Object, Object, Object, Object, Object> & java.io.Serializable & Serializable)(x1, x2, x3, x4) -> ((Function1)((Function1)((Function1)f.apply(x1)).apply(x2)).apply(x3)).apply(x4);
    }

    public <a1, a2, a3, a4, a5, b> Function5<a1, a2, a3, a4, a5, b> uncurried(Function1<a1, Function1<a2, Function1<a3, Function1<a4, Function1<a5, b>>>>> f) {
        return (Function5<Object, Object, Object, Object, Object, Object> & java.io.Serializable & Serializable)(x1, x2, x3, x4, x5) -> ((Function1)((Function1)((Function1)((Function1)f.apply(x1)).apply(x2)).apply(x3)).apply(x4)).apply(x5);
    }

    public <a1, a2, b> Function1<Tuple2<a1, a2>, b> tupled(Function2<a1, a2, b> f) {
        return (Function1<Tuple2, Object> & java.io.Serializable & Serializable)x0$1 -> {
            if (x0$1 == null) {
                throw new MatchError((Object)null);
            }
            Object x1 = x0$1._1();
            Object x2 = x0$1._2();
            Object r = f.apply(x1, x2);
            return r;
        };
    }

    public <a1, a2, a3, b> Function1<Tuple3<a1, a2, a3>, b> tupled(Function3<a1, a2, a3, b> f) {
        return (Function1<Tuple3, Object> & java.io.Serializable & Serializable)x0$1 -> {
            if (x0$1 == null) {
                throw new MatchError((Object)null);
            }
            Object x1 = x0$1._1();
            Object x2 = x0$1._2();
            Object x3 = x0$1._3();
            Object r = f.apply(x1, x2, x3);
            return r;
        };
    }

    public <a1, a2, a3, a4, b> Function1<Tuple4<a1, a2, a3, a4>, b> tupled(Function4<a1, a2, a3, a4, b> f) {
        return (Function1<Tuple4, Object> & java.io.Serializable & Serializable)x0$1 -> {
            if (x0$1 == null) {
                throw new MatchError((Object)null);
            }
            Object x1 = x0$1._1();
            Object x2 = x0$1._2();
            Object x3 = x0$1._3();
            Object x4 = x0$1._4();
            Object r = f.apply(x1, x2, x3, x4);
            return r;
        };
    }

    public <a1, a2, a3, a4, a5, b> Function1<Tuple5<a1, a2, a3, a4, a5>, b> tupled(Function5<a1, a2, a3, a4, a5, b> f) {
        return (Function1<Tuple5, Object> & java.io.Serializable & Serializable)x0$1 -> {
            if (x0$1 == null) {
                throw new MatchError((Object)null);
            }
            Object x1 = x0$1._1();
            Object x2 = x0$1._2();
            Object x3 = x0$1._3();
            Object x4 = x0$1._4();
            Object x5 = x0$1._5();
            Object r = f.apply(x1, x2, x3, x4, x5);
            return r;
        };
    }

    public <a1, a2, b> Function2<a1, a2, b> untupled(Function1<Tuple2<a1, a2>, b> f) {
        return (Function2<Object, Object, Object> & java.io.Serializable & Serializable)(x1, x2) -> f.apply(new Tuple2<Object, Object>(x1, x2));
    }

    public <a1, a2, a3, b> Function3<a1, a2, a3, b> untupled(Function1<Tuple3<a1, a2, a3>, b> f) {
        return (Function3<Object, Object, Object, Object> & java.io.Serializable & Serializable)(x1, x2, x3) -> f.apply(new Tuple3<Object, Object, Object>(x1, x2, x3));
    }

    public <a1, a2, a3, a4, b> Function4<a1, a2, a3, a4, b> untupled(Function1<Tuple4<a1, a2, a3, a4>, b> f) {
        return (Function4<Object, Object, Object, Object, Object> & java.io.Serializable & Serializable)(x1, x2, x3, x4) -> f.apply(new Tuple4<Object, Object, Object, Object>(x1, x2, x3, x4));
    }

    public <a1, a2, a3, a4, a5, b> Function5<a1, a2, a3, a4, a5, b> untupled(Function1<Tuple5<a1, a2, a3, a4, a5>, b> f) {
        return (Function5<Object, Object, Object, Object, Object, Object> & java.io.Serializable & Serializable)(x1, x2, x3, x4, x5) -> f.apply(new Tuple5<Object, Object, Object, Object, Object>(x1, x2, x3, x4, x5));
    }

    private Function$() {
        MODULE$ = this;
    }
}

