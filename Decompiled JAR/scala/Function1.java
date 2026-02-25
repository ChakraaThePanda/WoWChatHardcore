/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.Serializable;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001\u0005\raa\u0002\u0004\b!\u0003\r\tA\u0003\u0005\u0006!\u0001!\t!\u0005\u0005\u0006+\u00011\tA\u0006\u0005\u0006/\u0002!\t\u0001\u0017\u0005\u0006Q\u0002!\t!\u001b\u0005\u0006c\u0002!\tE\u001d\u0002\n\rVt7\r^5p]FR\u0011\u0001C\u0001\u0006g\u000e\fG.Y\u0002\u0001+\rYA*G\n\u0003\u00011\u0001\"!\u0004\b\u000e\u0003\u001dI!aD\u0004\u0003\r\u0005s\u0017PU3g\u0003\u0019!\u0013N\\5uIQ\t!\u0003\u0005\u0002\u000e'%\u0011Ac\u0002\u0002\u0005+:LG/A\u0003baBd\u0017\u0010\u0006\u0002\u0018\u0013B\u0011\u0001$\u0007\u0007\u0001\t%Q\u0002\u0001)A\u0001\n\u000b\u00071DA\u0001S#\tar\u0004\u0005\u0002\u000e;%\u0011ad\u0002\u0002\b\u001d>$\b.\u001b8h!\ti\u0001%\u0003\u0002\"\u000f\t\u0019\u0011I\\=)\u0011e\u0019c\u0005M\u001b;\u007f\u0011\u0003\"!\u0004\u0013\n\u0005\u0015:!aC:qK\u000eL\u0017\r\\5{K\u0012\fTaI\u0014._9r!\u0001K\u0017\u000f\u0005%bS\"\u0001\u0016\u000b\u0005-J\u0011A\u0002\u001fs_>$h(C\u0001\t\u0013\tqs!\u0001\u0003V]&$\u0018\u0007\u0002\u0013)Y!\tTaI\u00193iMr!\u0001\u000b\u001a\n\u0005M:\u0011a\u0002\"p_2,\u0017M\\\u0019\u0005I!b\u0003\"M\u0003$m]J\u0004H\u0004\u0002)o%\u0011\u0001hB\u0001\u0004\u0013:$\u0018\u0007\u0002\u0013)Y!\tTaI\u001e=}ur!\u0001\u000b\u001f\n\u0005u:\u0011!\u0002$m_\u0006$\u0018\u0007\u0002\u0013)Y!\tTa\t!B\u0007\ns!\u0001K!\n\u0005\t;\u0011\u0001\u0002'p]\u001e\fD\u0001\n\u0015-\u0011E*1%\u0012$I\u000f:\u0011\u0001FR\u0005\u0003\u000f\u001e\ta\u0001R8vE2,\u0017\u0007\u0002\u0013)Y!AQA\u0013\u0002A\u0002-\u000b!A^\u0019\u0011\u0005aaE!C'\u0001A\u0003\u0005\tR1\u0001\u001c\u0005\t!\u0016\u0007\u000b\u0004MG=\u000b6+V\u0019\u0006GY:\u0004\u000bO\u0019\u0005I!b\u0003\"M\u0003$\u0001\u0006\u0013&)\r\u0003%Q1B\u0011'B\u0012<yQk\u0014\u0007\u0002\u0013)Y!\tTaI#G-\u001e\u000bD\u0001\n\u0015-\u0011\u000591m\\7q_N,WCA-])\tQf\f\u0005\u0003\u000e\u0001m;\u0002C\u0001\r]\t\u0015i6A1\u0001\u001c\u0005\u0005\t\u0005\"B0\u0004\u0001\u0004\u0001\u0017!A4\u0011\t5\u00011l\u0013\u0015\u0003\u0007\t\u0004\"a\u00194\u000e\u0003\u0011T!!Z\u0004\u0002\u0015\u0005tgn\u001c;bi&|g.\u0003\u0002hI\niQO\\:qK\u000eL\u0017\r\\5{K\u0012\fq!\u00198e)\",g.\u0006\u0002k[R\u00111N\u001c\t\u0005\u001b\u0001YE\u000e\u0005\u0002\u0019[\u0012)Q\f\u0002b\u00017!)q\f\u0002a\u0001_B!Q\u0002A\fmQ\t!!-\u0001\u0005u_N#(/\u001b8h)\u0005\u0019\bC\u0001;z\u001b\u0005)(B\u0001<x\u0003\u0011a\u0017M\\4\u000b\u0003a\fAA[1wC&\u0011!0\u001e\u0002\u0007'R\u0014\u0018N\\4)\u0007\u0001ax\u0010\u0005\u0002d{&\u0011a\u0010\u001a\u0002\u0011S6\u0004H.[2ji:{GOR8v]\u0012\f#!!\u0001\u0002]9{\u0007%[7qY&\u001c\u0017\u000e\u001e\u0011wS\u0016<\b%\u0019<bS2\f'\r\\3!MJ|W\u000e\t\u0013|)Fj\b%\u0010 !Im\u0014VP\f")
public interface Function1<T1, R> {
    public R apply(T1 var1);

    public static /* synthetic */ Function1 compose$(Function1 $this, Function1 g) {
        return $this.compose(g);
    }

    default public <A> Function1<A, R> compose(Function1<A, T1> g) {
        return (Function1<Object, Object> & java.io.Serializable & Serializable)x -> this.apply(g.apply(x));
    }

    public static /* synthetic */ Function1 andThen$(Function1 $this, Function1 g) {
        return $this.andThen(g);
    }

    default public <A> Function1<T1, A> andThen(Function1<R, A> g) {
        return (Function1<Object, Object> & java.io.Serializable & Serializable)x -> g.apply(this.apply(x));
    }

    public static /* synthetic */ String toString$(Function1 $this) {
        return $this.toString();
    }

    default public String toString() {
        return "<function1>";
    }

    public static /* synthetic */ boolean apply$mcZD$sp$(Function1 $this, double v1) {
        return $this.apply$mcZD$sp(v1);
    }

    default public boolean apply$mcZD$sp(double v1) {
        return BoxesRunTime.unboxToBoolean(this.apply(BoxesRunTime.boxToDouble(v1)));
    }

    public static /* synthetic */ double apply$mcDD$sp$(Function1 $this, double v1) {
        return $this.apply$mcDD$sp(v1);
    }

    default public double apply$mcDD$sp(double v1) {
        return BoxesRunTime.unboxToDouble(this.apply(BoxesRunTime.boxToDouble(v1)));
    }

    public static /* synthetic */ float apply$mcFD$sp$(Function1 $this, double v1) {
        return $this.apply$mcFD$sp(v1);
    }

    default public float apply$mcFD$sp(double v1) {
        return BoxesRunTime.unboxToFloat(this.apply(BoxesRunTime.boxToDouble(v1)));
    }

    public static /* synthetic */ int apply$mcID$sp$(Function1 $this, double v1) {
        return $this.apply$mcID$sp(v1);
    }

    default public int apply$mcID$sp(double v1) {
        return BoxesRunTime.unboxToInt(this.apply(BoxesRunTime.boxToDouble(v1)));
    }

    public static /* synthetic */ long apply$mcJD$sp$(Function1 $this, double v1) {
        return $this.apply$mcJD$sp(v1);
    }

    default public long apply$mcJD$sp(double v1) {
        return BoxesRunTime.unboxToLong(this.apply(BoxesRunTime.boxToDouble(v1)));
    }

    public static /* synthetic */ void apply$mcVD$sp$(Function1 $this, double v1) {
        $this.apply$mcVD$sp(v1);
    }

    default public void apply$mcVD$sp(double v1) {
        this.apply(BoxesRunTime.boxToDouble(v1));
    }

    public static /* synthetic */ boolean apply$mcZF$sp$(Function1 $this, float v1) {
        return $this.apply$mcZF$sp(v1);
    }

    default public boolean apply$mcZF$sp(float v1) {
        return BoxesRunTime.unboxToBoolean(this.apply(BoxesRunTime.boxToFloat(v1)));
    }

    public static /* synthetic */ double apply$mcDF$sp$(Function1 $this, float v1) {
        return $this.apply$mcDF$sp(v1);
    }

    default public double apply$mcDF$sp(float v1) {
        return BoxesRunTime.unboxToDouble(this.apply(BoxesRunTime.boxToFloat(v1)));
    }

    public static /* synthetic */ float apply$mcFF$sp$(Function1 $this, float v1) {
        return $this.apply$mcFF$sp(v1);
    }

    default public float apply$mcFF$sp(float v1) {
        return BoxesRunTime.unboxToFloat(this.apply(BoxesRunTime.boxToFloat(v1)));
    }

    public static /* synthetic */ int apply$mcIF$sp$(Function1 $this, float v1) {
        return $this.apply$mcIF$sp(v1);
    }

    default public int apply$mcIF$sp(float v1) {
        return BoxesRunTime.unboxToInt(this.apply(BoxesRunTime.boxToFloat(v1)));
    }

    public static /* synthetic */ long apply$mcJF$sp$(Function1 $this, float v1) {
        return $this.apply$mcJF$sp(v1);
    }

    default public long apply$mcJF$sp(float v1) {
        return BoxesRunTime.unboxToLong(this.apply(BoxesRunTime.boxToFloat(v1)));
    }

    public static /* synthetic */ void apply$mcVF$sp$(Function1 $this, float v1) {
        $this.apply$mcVF$sp(v1);
    }

    default public void apply$mcVF$sp(float v1) {
        this.apply(BoxesRunTime.boxToFloat(v1));
    }

    public static /* synthetic */ boolean apply$mcZI$sp$(Function1 $this, int v1) {
        return $this.apply$mcZI$sp(v1);
    }

    default public boolean apply$mcZI$sp(int v1) {
        return BoxesRunTime.unboxToBoolean(this.apply(BoxesRunTime.boxToInteger(v1)));
    }

    public static /* synthetic */ double apply$mcDI$sp$(Function1 $this, int v1) {
        return $this.apply$mcDI$sp(v1);
    }

    default public double apply$mcDI$sp(int v1) {
        return BoxesRunTime.unboxToDouble(this.apply(BoxesRunTime.boxToInteger(v1)));
    }

    public static /* synthetic */ float apply$mcFI$sp$(Function1 $this, int v1) {
        return $this.apply$mcFI$sp(v1);
    }

    default public float apply$mcFI$sp(int v1) {
        return BoxesRunTime.unboxToFloat(this.apply(BoxesRunTime.boxToInteger(v1)));
    }

    public static /* synthetic */ int apply$mcII$sp$(Function1 $this, int v1) {
        return $this.apply$mcII$sp(v1);
    }

    default public int apply$mcII$sp(int v1) {
        return BoxesRunTime.unboxToInt(this.apply(BoxesRunTime.boxToInteger(v1)));
    }

    public static /* synthetic */ long apply$mcJI$sp$(Function1 $this, int v1) {
        return $this.apply$mcJI$sp(v1);
    }

    default public long apply$mcJI$sp(int v1) {
        return BoxesRunTime.unboxToLong(this.apply(BoxesRunTime.boxToInteger(v1)));
    }

    public static /* synthetic */ void apply$mcVI$sp$(Function1 $this, int v1) {
        $this.apply$mcVI$sp(v1);
    }

    default public void apply$mcVI$sp(int v1) {
        this.apply(BoxesRunTime.boxToInteger(v1));
    }

    public static /* synthetic */ boolean apply$mcZJ$sp$(Function1 $this, long v1) {
        return $this.apply$mcZJ$sp(v1);
    }

    default public boolean apply$mcZJ$sp(long v1) {
        return BoxesRunTime.unboxToBoolean(this.apply(BoxesRunTime.boxToLong(v1)));
    }

    public static /* synthetic */ double apply$mcDJ$sp$(Function1 $this, long v1) {
        return $this.apply$mcDJ$sp(v1);
    }

    default public double apply$mcDJ$sp(long v1) {
        return BoxesRunTime.unboxToDouble(this.apply(BoxesRunTime.boxToLong(v1)));
    }

    public static /* synthetic */ float apply$mcFJ$sp$(Function1 $this, long v1) {
        return $this.apply$mcFJ$sp(v1);
    }

    default public float apply$mcFJ$sp(long v1) {
        return BoxesRunTime.unboxToFloat(this.apply(BoxesRunTime.boxToLong(v1)));
    }

    public static /* synthetic */ int apply$mcIJ$sp$(Function1 $this, long v1) {
        return $this.apply$mcIJ$sp(v1);
    }

    default public int apply$mcIJ$sp(long v1) {
        return BoxesRunTime.unboxToInt(this.apply(BoxesRunTime.boxToLong(v1)));
    }

    public static /* synthetic */ long apply$mcJJ$sp$(Function1 $this, long v1) {
        return $this.apply$mcJJ$sp(v1);
    }

    default public long apply$mcJJ$sp(long v1) {
        return BoxesRunTime.unboxToLong(this.apply(BoxesRunTime.boxToLong(v1)));
    }

    public static /* synthetic */ void apply$mcVJ$sp$(Function1 $this, long v1) {
        $this.apply$mcVJ$sp(v1);
    }

    default public void apply$mcVJ$sp(long v1) {
        this.apply(BoxesRunTime.boxToLong(v1));
    }

    public static void $init$(Function1 $this) {
    }
}

