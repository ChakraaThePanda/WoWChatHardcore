/*
 * Decompiled with CFR 0.152.
 */
package scala;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import scala.Function1;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.PartialFunction;
import scala.PartialFunction$;
import scala.Serializable;
import scala.runtime.BoxesRunTime;
import scala.runtime.LambdaDeserialize;
import scala.runtime.Nothing$;

public final class PartialFunction$ {
    public static PartialFunction$ MODULE$;
    public final PartialFunction<Object, Object> scala$PartialFunction$$fallback_pf;
    public final Function1<Object, Object> scala$PartialFunction$$constFalse;
    private final PartialFunction<Object, Nothing$> empty_pf;

    static {
        new PartialFunction$();
    }

    public <B> PartialFunction<Object, B> scala$PartialFunction$$checkFallback() {
        return this.scala$PartialFunction$$fallback_pf;
    }

    public <B> boolean scala$PartialFunction$$fallbackOccurred(B x) {
        return this.scala$PartialFunction$$fallback_pf == x;
    }

    public <A, B> PartialFunction<A, B> unlifted(Function1<A, Option<B>> f) {
        PartialFunction partialFunction = f instanceof PartialFunction.Lifted ? ((PartialFunction.Lifted)f).pf() : new PartialFunction.Unlifted<A, B>(f);
        return partialFunction;
    }

    public <A, B> PartialFunction<A, B> apply(Function1<A, B> f) {
        return new Serializable(f){
            public static final long serialVersionUID = 0L;
            private final Function1 f$1;

            public final <A1 extends A, B1> B1 applyOrElse(A1 x1, Function1<A1, B1> function1) {
                return (B1)this.f$1.apply(x1);
            }

            public final boolean isDefinedAt(A x1) {
                return true;
            }
            {
                this.f$1 = f$1;
            }
        };
    }

    public <A, B> PartialFunction<A, B> empty() {
        return this.empty_pf;
    }

    public <T> boolean cond(T x, PartialFunction<T, Object> pf) {
        return BoxesRunTime.unboxToBoolean(pf.applyOrElse(x, this.scala$PartialFunction$$constFalse));
    }

    public <T, U> Option<U> condOpt(T x, PartialFunction<T, U> pf) {
        return pf.lift().apply(x);
    }

    public static final /* synthetic */ boolean $anonfun$constFalse$1(Object x$1) {
        return false;
    }

    private PartialFunction$() {
        MODULE$ = this;
        this.scala$PartialFunction$$fallback_pf = new Serializable(){
            public static final long serialVersionUID = 0L;

            public final <A1, B1> B1 applyOrElse(A1 x1, Function1<A1, B1> function1) {
                return (B1)PartialFunction$.MODULE$.scala$PartialFunction$$fallback_pf;
            }

            public final boolean isDefinedAt(Object x1) {
                return true;
            }
        };
        this.scala$PartialFunction$$constFalse = (Function1<Object, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToBoolean(PartialFunction$.$anonfun$constFalse$1(x$1));
        this.empty_pf = new PartialFunction<Object, Nothing$>(){
            private final Function1<Object, None$> lift;

            public <A1, B1> B1 applyOrElse(A1 x, Function1<A1, B1> function1) {
                return (B1)PartialFunction.applyOrElse$(this, x, function1);
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

            public <A> Function1<A, Nothing$> compose(Function1<A, Object> g) {
                return Function1.compose$(this, g);
            }

            public String toString() {
                return Function1.toString$(this);
            }

            public boolean isDefinedAt(Object x) {
                return false;
            }

            public Nothing$ apply(Object x) {
                throw new MatchError(x);
            }

            public <A1, B1> PartialFunction<A1, B1> orElse(PartialFunction<A1, B1> that) {
                return that;
            }

            public <C> anon.1 andThen(Function1<Nothing$, C> k) {
                return this;
            }

            public Function1<Object, None$> lift() {
                return this.lift;
            }

            public <U> Function1<Object, Object> runWith(Function1<Nothing$, U> action) {
                return PartialFunction$.MODULE$.scala$PartialFunction$$constFalse;
            }
            {
                PartialFunction.$init$(this);
                this.lift = (Function1<Object, None$> & java.io.Serializable & Serializable)x -> None$.MODULE$;
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$lift$1(java.lang.Object )}, serializedLambda);
            }
        };
    }
}

