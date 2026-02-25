/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.Function0;
import scala.Function1;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.collection.Seq;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.SeqFactory;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Stream$Empty$;
import scala.collection.immutable.Stream$cons$;
import scala.collection.mutable.Builder;
import scala.math.Integral;
import scala.runtime.BoxesRunTime;

public final class Stream$
extends SeqFactory<Stream>
implements Serializable {
    public static Stream$ MODULE$;
    private final Stream.StreamCanBuildFrom<Object> ReusableCBF;

    static {
        new Stream$();
    }

    public <A> CanBuildFrom<Stream<?>, A, Stream<A>> canBuildFrom() {
        return this.ReusableCBF;
    }

    @Override
    public <A> Builder<A, Stream<A>> newBuilder() {
        return new Stream.StreamBuilder();
    }

    @Override
    public <A> Stream<A> empty() {
        return Stream$Empty$.MODULE$;
    }

    @Override
    public <A> Stream<A> apply(Seq<A> xs) {
        return xs.toStream();
    }

    public <A> Stream.ConsWrapper<A> consWrapper(Function0<Stream<A>> stream) {
        return new Stream.ConsWrapper<A>(stream);
    }

    /*
     * WARNING - void declaration
     */
    public <A> Stream<A> iterate(A start, Function1<A, A> f) {
        void apply_tl;
        Function0<Stream> & java.io.Serializable & Serializable intersect = (Function0<Stream> & java.io.Serializable & Serializable)() -> {
            void iterate_apply_tl;
            void iterate_start;
            Object r = f.apply(start);
            if (MODULE$ == null) {
                throw null;
            }
            Function0<Stream> & java.io.Serializable & Serializable intersect = () -> Stream$.$anonfun$iterate$1(f, iterate_start);
            if (Stream$cons$.MODULE$ == null) {
                throw null;
            }
            return new Stream.Cons<void>(iterate_start, (Function0<Stream<void>>)iterate_apply_tl);
        };
        if (Stream$cons$.MODULE$ == null) {
            throw null;
        }
        return new Stream.Cons<A>(start, apply_tl);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public <A> Stream<A> iterate(A start, int len, Function1<A, A> f) {
        void iterate_apply_tl;
        Function0<Stream> & java.io.Serializable & Serializable intersect = (Function0<Stream> & java.io.Serializable & Serializable)() -> {
            void iterate_apply_tl;
            void iterate_start;
            Object r = f.apply(start);
            if (MODULE$ == null) {
                throw null;
            }
            Function0<Stream> & java.io.Serializable & Serializable intersect = () -> Stream$.$anonfun$iterate$1(f, iterate_start);
            if (Stream$cons$.MODULE$ == null) {
                throw null;
            }
            return new Stream.Cons<void>(iterate_start, (Function0<Stream<void>>)iterate_apply_tl);
        };
        if (Stream$cons$.MODULE$ == null) {
            throw null;
        }
        return new Stream.Cons<A>(start, iterate_apply_tl).take(len);
    }

    /*
     * WARNING - void declaration
     */
    public Stream<Object> from(int start, int step) {
        void apply_tl;
        void apply_hd;
        Function0<Stream> & java.io.Serializable & Serializable intersect = (Function0<Stream> & java.io.Serializable & Serializable)() -> MODULE$.from(start + step, step);
        Integer n = BoxesRunTime.boxToInteger(start);
        if (Stream$cons$.MODULE$ == null) {
            throw null;
        }
        return new Stream.Cons<void>(apply_hd, (Function0<Stream<void>>)apply_tl);
    }

    public Stream<Object> from(int start) {
        return this.from(start, 1);
    }

    /*
     * WARNING - void declaration
     */
    public <A> Stream<A> continually(Function0<A> elem) {
        void apply_tl;
        void apply_hd;
        Function0<Stream> & java.io.Serializable & Serializable intersect = (Function0<Stream> & java.io.Serializable & Serializable)() -> {
            void continually_apply_tl;
            void continually_apply_hd;
            if (MODULE$ == null) {
                throw null;
            }
            Function0<Stream> & java.io.Serializable & Serializable intersect = () -> Stream$.$anonfun$continually$1(elem);
            Object r = elem.apply();
            if (Stream$cons$.MODULE$ == null) {
                throw null;
            }
            return new Stream.Cons<void>(continually_apply_hd, (Function0<Stream<void>>)continually_apply_tl);
        };
        A a = elem.apply();
        if (Stream$cons$.MODULE$ == null) {
            throw null;
        }
        return new Stream.Cons<void>(apply_hd, (Function0<Stream<void>>)apply_tl);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public <A> Stream<A> fill(int n, Function0<A> elem) {
        void apply_tl;
        void apply_hd;
        if (n <= 0) {
            return Stream$Empty$.MODULE$;
        }
        Function0<Stream> & java.io.Serializable & Serializable intersect = (Function0<Stream> & java.io.Serializable & Serializable)() -> {
            void fill_apply_tl;
            void fill_apply_hd;
            void fill_n;
            int n = n - 1;
            if (MODULE$ == null) {
                throw null;
            }
            if (fill_n <= false) {
                return Stream$Empty$.MODULE$;
            }
            Function0<Stream> & java.io.Serializable & Serializable intersect = () -> Stream$.$anonfun$fill$1((int)fill_n, elem);
            Object r = elem.apply();
            if (Stream$cons$.MODULE$ == null) {
                throw null;
            }
            return new Stream.Cons<void>(fill_apply_hd, (Function0<Stream<void>>)fill_apply_tl);
        };
        A a = elem.apply();
        if (Stream$cons$.MODULE$ == null) {
            throw null;
        }
        return new Stream.Cons<void>(apply_hd, (Function0<Stream<void>>)apply_tl);
    }

    @Override
    public <A> Stream<A> tabulate(int n, Function1<Object, A> f) {
        return Stream$.loop$4(0, n, f);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public <T> Stream<T> range(T start, T end, T step, Integral<T> evidence$1) {
        void apply_tl;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        Integral num = evidence$1;
        if (num.mkOrderingOps(step).$less(num.zero()) ? num.mkOrderingOps(start).$less$eq(end) : num.mkOrderingOps(end).$less$eq(start)) {
            return Stream$Empty$.MODULE$;
        }
        Function0<Stream> & java.io.Serializable & Serializable intersect = (Function0<Stream> & java.io.Serializable & Serializable)() -> MODULE$.range(num.mkNumericOps(start).$plus(step), end, step, evidence$1);
        if (Stream$cons$.MODULE$ == null) {
            throw null;
        }
        return new Stream.Cons<T>(start, apply_tl);
    }

    /*
     * WARNING - void declaration
     */
    public <A> Stream.Cons<A> filteredTail(Stream<A> stream, Function1<A, Object> p, boolean isFlipped) {
        void apply_tl;
        void apply_hd;
        Function0<Stream> & java.io.Serializable & Serializable intersect = (Function0<Stream> & java.io.Serializable & Serializable)() -> ((Stream)stream.tail()).filterImpl(p, isFlipped);
        A a = stream.head();
        if (Stream$cons$.MODULE$ == null) {
            throw null;
        }
        return new Stream.Cons<void>(apply_hd, (Function0<Stream<void>>)apply_tl);
    }

    /*
     * WARNING - void declaration
     */
    public <A, B, That> Stream.Cons<B> collectedTail(B head, Stream<A> stream, PartialFunction<A, B> pf, CanBuildFrom<Stream<A>, B, That> bf) {
        void apply_tl;
        Function0<Stream> & java.io.Serializable & Serializable intersect = (Function0<Stream> & java.io.Serializable & Serializable)() -> (Stream)((Stream)stream.tail()).collect(pf, bf);
        if (Stream$cons$.MODULE$ == null) {
            throw null;
        }
        return new Stream.Cons<B>(head, apply_tl);
    }

    private Object readResolve() {
        return MODULE$;
    }

    /*
     * WARNING - void declaration
     */
    private static final Stream loop$4(int i, int n$3, Function1 f$4) {
        void apply_tl;
        void apply_hd;
        if (i >= n$3) {
            return Stream$Empty$.MODULE$;
        }
        Function0<Stream> & java.io.Serializable & Serializable intersect = (Function0<Stream> & java.io.Serializable & Serializable)() -> Stream$.loop$4(i + 1, n$3, f$4);
        Object r = f$4.apply(BoxesRunTime.boxToInteger(i));
        if (Stream$cons$.MODULE$ == null) {
            throw null;
        }
        return new Stream.Cons<void>(apply_hd, (Function0<Stream<void>>)apply_tl);
    }

    private Stream$() {
        MODULE$ = this;
        this.ReusableCBF = new Stream.StreamCanBuildFrom();
    }
}

