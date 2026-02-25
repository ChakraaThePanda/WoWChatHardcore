/*
 * Decompiled with CFR 0.152.
 */
package scala.util.control;

import scala.Function0;
import scala.Function1;
import scala.None$;
import scala.Option;
import scala.PartialFunction;
import scala.Serializable;
import scala.Some;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.TraversableOnce;
import scala.reflect.ClassTag;
import scala.reflect.ClassTag$;
import scala.reflect.package$;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.util.control.ControlThrowable;
import scala.util.control.Exception;
import scala.util.control.Exception$Catch$;
import scala.util.control.NonFatal$;

public final class Exception$ {
    public static Exception$ MODULE$;
    private final PartialFunction<Throwable, Nothing$> nothingCatcher;
    private final Exception.Catch<Nothing$> noCatch;

    static {
        new Exception$();
    }

    public <Ex extends Throwable, T> PartialFunction<Throwable, T> mkCatcher(Function1<Ex, Object> isDef, Function1<Ex, T> f, ClassTag<Ex> evidence$1) {
        return new PartialFunction<Throwable, T>(evidence$1, isDef, f){
            private final ClassTag evidence$1$1;
            private final Function1 isDef$1;
            private final Function1 f$1;

            public <A1 extends Throwable, B1> PartialFunction<A1, B1> orElse(PartialFunction<A1, B1> that) {
                return PartialFunction.orElse$(this, that);
            }

            public <C> PartialFunction<Throwable, C> andThen(Function1<T, C> k) {
                return PartialFunction.andThen$(this, k);
            }

            public Function1<Throwable, Option<T>> lift() {
                return PartialFunction.lift$(this);
            }

            public Object applyOrElse(Object x, Function1 function1) {
                return PartialFunction.applyOrElse$(this, x, function1);
            }

            public <U> Function1<Throwable, Object> runWith(Function1<T, U> action) {
                return PartialFunction.runWith$(this, action);
            }

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

            public <A> Function1<A, T> compose(Function1<A, Throwable> g) {
                return Function1.compose$(this, g);
            }

            public String toString() {
                return Function1.toString$(this);
            }

            private Option<Ex> downcast(Throwable x) {
                if (package$.MODULE$.classTag(this.evidence$1$1).runtimeClass().isAssignableFrom(x.getClass())) {
                    return new Some<Throwable>(x);
                }
                return None$.MODULE$;
            }

            public boolean isDefinedAt(Throwable x) {
                return this.downcast(x).exists(this.isDef$1);
            }

            public T apply(Throwable x) {
                return (T)this.f$1.apply(this.downcast(x).get());
            }
            {
                this.evidence$1$1 = evidence$1$1;
                this.isDef$1 = isDef$1;
                this.f$1 = f$1;
                PartialFunction.$init$(this);
            }
        };
    }

    public <T> PartialFunction<Throwable, T> mkThrowableCatcher(Function1<Throwable, Object> isDef, Function1<Throwable, T> f) {
        ClassTag mkCatcher_evidence$1 = ClassTag$.MODULE$.apply(Throwable.class);
        return new /* invalid duplicate definition of identical inner class */;
    }

    /*
     * WARNING - void declaration
     */
    public <Ex extends Throwable, T> PartialFunction<Throwable, T> throwableSubtypeToCatcher(PartialFunction<Ex, T> pf, ClassTag<Ex> evidence$2) {
        void mkCatcher_f;
        Function1<Throwable, Object> & java.io.Serializable & Serializable intersect = (Function1<Throwable, Object> & java.io.Serializable & Serializable)v1 -> pf.apply(v1);
        Function1<Throwable, Object> & java.io.Serializable & Serializable mkCatcher_isDef = (Function1<Throwable, Object> & java.io.Serializable & Serializable)x -> BoxesRunTime.boxToBoolean(pf.isDefinedAt(x));
        return new /* invalid duplicate definition of identical inner class */;
    }

    public boolean shouldRethrow(Throwable x) {
        boolean bl = x instanceof ControlThrowable ? true : x instanceof InterruptedException;
        return bl;
    }

    public final PartialFunction<Throwable, Nothing$> nothingCatcher() {
        return this.nothingCatcher;
    }

    public final <T> PartialFunction<Throwable, T> nonFatalCatcher() {
        Function1<Throwable, Nothing$> & java.io.Serializable & Serializable mkThrowableCatcher_f = (Function1<Throwable, Nothing$> & java.io.Serializable & Serializable)x$7 -> {
            throw x$7;
        };
        Function1<Throwable, Object> & java.io.Serializable & Serializable mkThrowableCatcher_isDef = (Function1<Throwable, Object> & java.io.Serializable & Serializable)x0$1 -> BoxesRunTime.boxToBoolean(bl = !NonFatal$.MODULE$.unapply(x0$1).isEmpty());
        ClassTag mkThrowableCatcher_mkCatcher_evidence$1 = ClassTag$.MODULE$.apply(Throwable.class);
        return new /* invalid duplicate definition of identical inner class */;
    }

    public final <T> PartialFunction<Throwable, T> allCatcher() {
        Function1<Throwable, Nothing$> & java.io.Serializable & Serializable mkThrowableCatcher_f = (Function1<Throwable, Nothing$> & java.io.Serializable & Serializable)x$9 -> {
            throw x$9;
        };
        Function1<Throwable, Object> & java.io.Serializable & Serializable mkThrowableCatcher_isDef = (Function1<Throwable, Object> & java.io.Serializable & Serializable)x$8 -> BoxesRunTime.boxToBoolean(Exception$.$anonfun$allCatcher$1(x$8));
        ClassTag mkThrowableCatcher_mkCatcher_evidence$1 = ClassTag$.MODULE$.apply(Throwable.class);
        return new /* invalid duplicate definition of identical inner class */;
    }

    public final Exception.Catch<Nothing$> noCatch() {
        return this.noCatch;
    }

    public final <T> Exception.Catch<T> allCatch() {
        return (Exception.Catch)new Exception.Catch<T>(this.allCatcher(), Exception$Catch$.MODULE$.$lessinit$greater$default$2(), Exception$Catch$.MODULE$.$lessinit$greater$default$3()).withDesc("<everything>");
    }

    public final <T> Exception.Catch<T> nonFatalCatch() {
        return (Exception.Catch)new Exception.Catch<T>(this.nonFatalCatcher(), Exception$Catch$.MODULE$.$lessinit$greater$default$2(), Exception$Catch$.MODULE$.$lessinit$greater$default$3()).withDesc("<non-fatal>");
    }

    public <T> Exception.Catch<T> catching(Seq<Class<?>> exceptions) {
        return (Exception.Catch)new Exception.Catch<Nothing$>(this.pfFromExceptions(exceptions), Exception$Catch$.MODULE$.$lessinit$greater$default$2(), Exception$Catch$.MODULE$.$lessinit$greater$default$3()).withDesc(((TraversableOnce)exceptions.map((Function1<Class, String> & java.io.Serializable & Serializable)x$10 -> x$10.getName(), Seq$.MODULE$.canBuildFrom())).mkString(", "));
    }

    public <T> Exception.Catch<T> catching(PartialFunction<Throwable, T> c) {
        return new Exception.Catch<T>(c, Exception$Catch$.MODULE$.$lessinit$greater$default$2(), Exception$Catch$.MODULE$.$lessinit$greater$default$3());
    }

    public <T> Exception.Catch<T> catchingPromiscuously(Seq<Class<?>> exceptions) {
        return this.catchingPromiscuously(this.pfFromExceptions(exceptions));
    }

    public <T> Exception.Catch<T> catchingPromiscuously(PartialFunction<Throwable, T> c) {
        return new Exception.Catch<T>(c, None$.MODULE$, (Function1<Throwable, Object> & java.io.Serializable & Serializable)x$11 -> BoxesRunTime.boxToBoolean(Exception$.$anonfun$catchingPromiscuously$1(x$11)));
    }

    public Exception.Catch<BoxedUnit> ignoring(Seq<Class<?>> exceptions) {
        return this.catching(exceptions).withApply((Function1<Throwable, Object> & java.io.Serializable & Serializable)x$12 -> {
            Exception$.$anonfun$ignoring$1(x$12);
            return BoxedUnit.UNIT;
        });
    }

    public <T> Exception.Catch<Option<T>> failing(Seq<Class<?>> exceptions) {
        return this.catching(exceptions).withApply((Function1<Throwable, None$> & java.io.Serializable & Serializable)x$13 -> None$.MODULE$);
    }

    public <T> Exception.Catch<T> failAsValue(Seq<Class<?>> exceptions, Function0<T> value) {
        return this.catching(exceptions).withApply((Function1<Throwable, Object> & java.io.Serializable & Serializable)x$14 -> value.apply());
    }

    public <T> Exception.By<Function1<Throwable, T>, Exception.Catch<T>> handling(Seq<Class<?>> exceptions) {
        return new Exception.By<Function1<Throwable, T>, Exception.Catch<T>>((Function1<Function1, Exception.Catch> & java.io.Serializable & Serializable)f -> this.catching(exceptions).withApply(f));
    }

    public <T> Exception.Catch<T> ultimately(Function0<BoxedUnit> body) {
        return this.noCatch().andFinally(body);
    }

    public <T> Exception.Catch<T> unwrapping(Seq<Class<?>> exceptions) {
        return this.catching(exceptions).withApply((Function1<Throwable, Nothing$> & java.io.Serializable & Serializable)x -> {
            throw this.unwrap$1((Throwable)x, exceptions);
        });
    }

    public boolean scala$util$control$Exception$$wouldMatch(Throwable x, Seq<Class<?>> classes) {
        return classes.exists((Function1<Class, Object> & java.io.Serializable & Serializable)x$15 -> BoxesRunTime.boxToBoolean(x$15.isAssignableFrom(x.getClass())));
    }

    private PartialFunction<Throwable, Nothing$> pfFromExceptions(Seq<Class<?>> exceptions) {
        return new Serializable(exceptions){
            public static final long serialVersionUID = 0L;
            private final Seq exceptions$3;

            public final <A1 extends Throwable, B1> B1 applyOrElse(A1 x1, Function1<A1, B1> function1) {
                if (Exception$.MODULE$.scala$util$control$Exception$$wouldMatch(x1, this.exceptions$3)) {
                    throw x1;
                }
                return function1.apply(x1);
            }

            public final boolean isDefinedAt(Throwable x1) {
                boolean bl = Exception$.MODULE$.scala$util$control$Exception$$wouldMatch(x1, this.exceptions$3);
                return bl;
            }
            {
                this.exceptions$3 = exceptions$3;
            }
        };
    }

    public static final /* synthetic */ boolean $anonfun$nothingCatcher$1(Throwable x$5) {
        return false;
    }

    public static final /* synthetic */ boolean $anonfun$allCatcher$1(Throwable x$8) {
        return true;
    }

    public static final /* synthetic */ boolean $anonfun$catchingPromiscuously$1(Throwable x$11) {
        return false;
    }

    public static final /* synthetic */ void $anonfun$ignoring$1(Throwable x$12) {
    }

    private final Exception.Catch fun$1(Function1 f, Seq exceptions$1) {
        return this.catching(exceptions$1).withApply(f);
    }

    private final Throwable unwrap$1(Throwable x, Seq exceptions$2) {
        while (this.scala$util$control$Exception$$wouldMatch(x, exceptions$2) && x.getCause() != null) {
            x = x.getCause();
        }
        return x;
    }

    private Exception$() {
        MODULE$ = this;
        Function1<Throwable, Nothing$> & java.io.Serializable & Serializable mkThrowableCatcher_f = (Function1<Throwable, Nothing$> & java.io.Serializable & Serializable)x$6 -> {
            throw x$6;
        };
        Function1<Throwable, Object> & java.io.Serializable & Serializable mkThrowableCatcher_isDef = (Function1<Throwable, Object> & java.io.Serializable & Serializable)x$5 -> BoxesRunTime.boxToBoolean(Exception$.$anonfun$nothingCatcher$1(x$5));
        ClassTag mkThrowableCatcher_mkCatcher_evidence$1 = ClassTag$.MODULE$.apply(Throwable.class);
        this.nothingCatcher = new /* invalid duplicate definition of identical inner class */;
        this.noCatch = (Exception.Catch)new Exception.Catch<Nothing$>(this.nothingCatcher(), Exception$Catch$.MODULE$.$lessinit$greater$default$2(), Exception$Catch$.MODULE$.$lessinit$greater$default$3()).withDesc("<nothing>");
    }
}

