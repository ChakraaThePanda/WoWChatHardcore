/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import scala.Function1;
import scala.Option;
import scala.PartialFunction;
import scala.PartialFunction$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001m3Qa\u0001\u0003\u0002\u0002%AQa\u0015\u0001\u0005\u0002QCQa\u0016\u0001\u0005\u0002a\u0013q#\u00112tiJ\f7\r\u001e)beRL\u0017\r\u001c$v]\u000e$\u0018n\u001c8\u000b\u0005\u00151\u0011a\u0002:v]RLW.\u001a\u0006\u0002\u000f\u0005)1oY1mC\u000e\u0001Qc\u0001\u0006\u0015wM!\u0001aC\bQ!\taQ\"D\u0001\u0007\u0013\tqaA\u0001\u0004B]f\u0014VM\u001a\t\u0005\u0019A\u0011\"(\u0003\u0002\u0012\r\tIa)\u001e8di&|g.\r\t\u0003'Qa\u0001\u0001B\u0005\u0016\u0001\u0001\u0006\t\u0011#b\u0001-\t\u0011A+M\t\u0003/i\u0001\"\u0001\u0004\r\n\u0005e1!a\u0002(pi\"Lgn\u001a\t\u0003\u0019mI!\u0001\b\u0004\u0003\u0007\u0005s\u0017\u0010\u000b\u0004\u0015=\u0005Z\u0003'\u000e\t\u0003\u0019}I!\u0001\t\u0004\u0003\u0017M\u0004XmY5bY&TX\rZ\u0019\u0006G\tB#&\u000b\b\u0003G!r!\u0001J\u0014\u000e\u0003\u0015R!A\n\u0005\u0002\rq\u0012xn\u001c;?\u0013\u00059\u0011BA\u0015\u0007\u0003\rIe\u000e^\u0019\u0005I\r:s!M\u0003$Y5zcF\u0004\u0002$[%\u0011aFB\u0001\u0005\u0019>tw-\r\u0003%G\u001d:\u0011'B\u00122eQ\u001adBA\u00123\u0013\t\u0019d!A\u0003GY>\fG/\r\u0003%G\u001d:\u0011'B\u00127oeBdBA\u00128\u0013\tAd!\u0001\u0004E_V\u0014G.Z\u0019\u0005I\r:s\u0001\u0005\u0002\u0014w\u0011IA\b\u0001Q\u0001\u0002\u0013\u0015\rA\u0006\u0002\u0002%\"B1H\b D\u0011*ce*M\u0003$\u007f\u0001\u0013\u0015I\u0004\u0002$\u0001&\u0011\u0011IB\u0001\u0005+:LG/\r\u0003%G\u001d:\u0011'B\u0012E\u000b\u001e3eBA\u0012F\u0013\t1e!A\u0004C_>dW-\u001982\t\u0011\u001aseB\u0019\u0006G\tB\u0013*K\u0019\u0005I\r:s!M\u0003$cIZ5'\r\u0003%G\u001d:\u0011'B\u0012-[5s\u0013\u0007\u0002\u0013$O\u001d\tTa\t\u001c8\u001fb\nD\u0001J\u0012(\u000fA!A\"\u0015\n;\u0013\t\u0011fAA\bQCJ$\u0018.\u00197Gk:\u001cG/[8o\u0003\u0019a\u0014N\\5u}Q\tQ\u000b\u0005\u0003W\u0001IQT\"\u0001\u0003\u0002\u000b\u0005\u0004\b\u000f\\=\u0015\u0005iJ\u0006\"\u0002.\u0003\u0001\u0004\u0011\u0012!\u0001=")
public abstract class AbstractPartialFunction<T1, R>
implements PartialFunction<T1, R> {
    @Override
    public <A1 extends T1, B1> PartialFunction<A1, B1> orElse(PartialFunction<A1, B1> that) {
        return PartialFunction.orElse$(this, that);
    }

    @Override
    public <C> PartialFunction<T1, C> andThen(Function1<R, C> k) {
        return PartialFunction.andThen$(this, k);
    }

    @Override
    public Function1<T1, Option<R>> lift() {
        return PartialFunction.lift$(this);
    }

    @Override
    public <A1 extends T1, B1> B1 applyOrElse(A1 x, Function1<A1, B1> function1) {
        return (B1)PartialFunction.applyOrElse$(this, x, function1);
    }

    @Override
    public <U> Function1<T1, Object> runWith(Function1<R, U> action) {
        return PartialFunction.runWith$(this, action);
    }

    @Override
    public <A> Function1<A, R> compose(Function1<A, T1> g) {
        return Function1.compose$(this, g);
    }

    @Override
    public String toString() {
        return Function1.toString$(this);
    }

    @Override
    public R apply(T1 x) {
        return (R)this.applyOrElse(x, PartialFunction$.MODULE$.empty());
    }

    @Override
    public boolean apply$mcZD$sp(double x) {
        return BoxesRunTime.unboxToBoolean(this.apply(BoxesRunTime.boxToDouble(x)));
    }

    @Override
    public double apply$mcDD$sp(double x) {
        return BoxesRunTime.unboxToDouble(this.apply(BoxesRunTime.boxToDouble(x)));
    }

    @Override
    public float apply$mcFD$sp(double x) {
        return BoxesRunTime.unboxToFloat(this.apply(BoxesRunTime.boxToDouble(x)));
    }

    @Override
    public int apply$mcID$sp(double x) {
        return BoxesRunTime.unboxToInt(this.apply(BoxesRunTime.boxToDouble(x)));
    }

    @Override
    public long apply$mcJD$sp(double x) {
        return BoxesRunTime.unboxToLong(this.apply(BoxesRunTime.boxToDouble(x)));
    }

    @Override
    public void apply$mcVD$sp(double x) {
        this.apply(BoxesRunTime.boxToDouble(x));
    }

    @Override
    public boolean apply$mcZF$sp(float x) {
        return BoxesRunTime.unboxToBoolean(this.apply(BoxesRunTime.boxToFloat(x)));
    }

    @Override
    public double apply$mcDF$sp(float x) {
        return BoxesRunTime.unboxToDouble(this.apply(BoxesRunTime.boxToFloat(x)));
    }

    @Override
    public float apply$mcFF$sp(float x) {
        return BoxesRunTime.unboxToFloat(this.apply(BoxesRunTime.boxToFloat(x)));
    }

    @Override
    public int apply$mcIF$sp(float x) {
        return BoxesRunTime.unboxToInt(this.apply(BoxesRunTime.boxToFloat(x)));
    }

    @Override
    public long apply$mcJF$sp(float x) {
        return BoxesRunTime.unboxToLong(this.apply(BoxesRunTime.boxToFloat(x)));
    }

    @Override
    public void apply$mcVF$sp(float x) {
        this.apply(BoxesRunTime.boxToFloat(x));
    }

    @Override
    public boolean apply$mcZI$sp(int x) {
        return BoxesRunTime.unboxToBoolean(this.apply(BoxesRunTime.boxToInteger(x)));
    }

    @Override
    public double apply$mcDI$sp(int x) {
        return BoxesRunTime.unboxToDouble(this.apply(BoxesRunTime.boxToInteger(x)));
    }

    @Override
    public float apply$mcFI$sp(int x) {
        return BoxesRunTime.unboxToFloat(this.apply(BoxesRunTime.boxToInteger(x)));
    }

    @Override
    public int apply$mcII$sp(int x) {
        return BoxesRunTime.unboxToInt(this.apply(BoxesRunTime.boxToInteger(x)));
    }

    @Override
    public long apply$mcJI$sp(int x) {
        return BoxesRunTime.unboxToLong(this.apply(BoxesRunTime.boxToInteger(x)));
    }

    @Override
    public void apply$mcVI$sp(int x) {
        this.apply(BoxesRunTime.boxToInteger(x));
    }

    @Override
    public boolean apply$mcZJ$sp(long x) {
        return BoxesRunTime.unboxToBoolean(this.apply(BoxesRunTime.boxToLong(x)));
    }

    @Override
    public double apply$mcDJ$sp(long x) {
        return BoxesRunTime.unboxToDouble(this.apply(BoxesRunTime.boxToLong(x)));
    }

    @Override
    public float apply$mcFJ$sp(long x) {
        return BoxesRunTime.unboxToFloat(this.apply(BoxesRunTime.boxToLong(x)));
    }

    @Override
    public int apply$mcIJ$sp(long x) {
        return BoxesRunTime.unboxToInt(this.apply(BoxesRunTime.boxToLong(x)));
    }

    @Override
    public long apply$mcJJ$sp(long x) {
        return BoxesRunTime.unboxToLong(this.apply(BoxesRunTime.boxToLong(x)));
    }

    @Override
    public void apply$mcVJ$sp(long x) {
        this.apply(BoxesRunTime.boxToLong(x));
    }

    public AbstractPartialFunction() {
        PartialFunction.$init$(this);
    }
}

