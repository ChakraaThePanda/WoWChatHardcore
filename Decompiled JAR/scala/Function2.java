/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.Function1;
import scala.MatchError;
import scala.Serializable;
import scala.Tuple2;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001}4qAB\u0004\u0011\u0002\u0007\u0005!\u0002C\u0003\u0011\u0001\u0011\u0005\u0011\u0003C\u0003\u0016\u0001\u0019\u0005a\u0003C\u0003b\u0001\u0011\u0005!\rC\u0003o\u0001\u0011\u0005q\u000eC\u0003v\u0001\u0011\u0005cOA\u0005Gk:\u001cG/[8oe)\t\u0001\"A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\t-a\u0005,G\n\u0003\u00011\u0001\"!\u0004\b\u000e\u0003\u001dI!aD\u0004\u0003\r\u0005s\u0017PU3g\u0003\u0019!\u0013N\\5uIQ\t!\u0003\u0005\u0002\u000e'%\u0011Ac\u0002\u0002\u0005+:LG/A\u0003baBd\u0017\u0010F\u0002\u0018\u0013V\u0003\"\u0001G\r\r\u0001\u0011I!\u0004\u0001Q\u0001\u0002\u0013\u0015\ra\u0007\u0002\u0002%F\u0011Ad\b\t\u0003\u001buI!AH\u0004\u0003\u000f9{G\u000f[5oOB\u0011Q\u0002I\u0005\u0003C\u001d\u00111!\u00118zQ!I2E\n\u00196u}\"\u0005CA\u0007%\u0013\t)sAA\u0006ta\u0016\u001c\u0017.\u00197ju\u0016$\u0017'B\u0012([=rcB\u0001\u0015.\u001d\tIC&D\u0001+\u0015\tY\u0013\"\u0001\u0004=e>|GOP\u0005\u0002\u0011%\u0011afB\u0001\u0005+:LG/\r\u0003%Q1B\u0011'B\u00122eQ\u001adB\u0001\u00153\u0013\t\u0019t!A\u0004C_>dW-\u001982\t\u0011BC\u0006C\u0019\u0006GY:\u0014\b\u000f\b\u0003Q]J!\u0001O\u0004\u0002\u0007%sG/\r\u0003%Q1B\u0011'B\u0012<yyjdB\u0001\u0015=\u0013\tit!A\u0003GY>\fG/\r\u0003%Q1B\u0011'B\u0012A\u0003\u000e\u0013eB\u0001\u0015B\u0013\t\u0011u!\u0001\u0003M_:<\u0017\u0007\u0002\u0013)Y!\tTaI#G\u0011\u001es!\u0001\u000b$\n\u0005\u001d;\u0011A\u0002#pk\ndW-\r\u0003%Q1B\u0001\"\u0002&\u0003\u0001\u0004Y\u0015A\u0001<2!\tAB\nB\u0005N\u0001\u0001\u0006\t\u0011#b\u00017\t\u0011A+\r\u0015\u0006\u0019\u000ez\u0015kU\u0019\u0006GY:\u0004\u000bO\u0019\u0005I!b\u0003\"M\u0003$\u0001\u0006\u0013&)\r\u0003%Q1B\u0011'B\u0012F\rR;\u0015\u0007\u0002\u0013)Y!AQA\u0016\u0002A\u0002]\u000b!A\u001e\u001a\u0011\u0005aAF!C-\u0001A\u0003\u0005\tR1\u0001\u001c\u0005\t!&\u0007K\u0003YGmkv,M\u0003$m]b\u0006(\r\u0003%Q1B\u0011'B\u0012A\u0003z\u0013\u0015\u0007\u0002\u0013)Y!\tTaI#GA\u001e\u000bD\u0001\n\u0015-\u0011\u000591-\u001e:sS\u0016$W#A2\u0011\t5!7JZ\u0005\u0003K\u001e\u0011\u0011BR;oGRLwN\\\u0019\u0011\t5!wk\u0006\u0015\u0003\u0007!\u0004\"!\u001b7\u000e\u0003)T!a[\u0004\u0002\u0015\u0005tgn\u001c;bi&|g.\u0003\u0002nU\niQO\\:qK\u000eL\u0017\r\\5{K\u0012\fa\u0001^;qY\u0016$W#\u00019\u0011\t5!\u0017o\u0006\t\u0005\u001bI\\u+\u0003\u0002t\u000f\t1A+\u001e9mKJB#\u0001\u00025\u0002\u0011Q|7\u000b\u001e:j]\u001e$\u0012a\u001e\t\u0003qvl\u0011!\u001f\u0006\u0003un\fA\u0001\\1oO*\tA0\u0001\u0003kCZ\f\u0017B\u0001@z\u0005\u0019\u0019FO]5oO\u0002")
public interface Function2<T1, T2, R> {
    public R apply(T1 var1, T2 var2);

    public static /* synthetic */ Function1 curried$(Function2 $this) {
        return $this.curried();
    }

    default public Function1<T1, Function1<T2, R>> curried() {
        return (Function1<Object, Function1> & java.io.Serializable & Serializable)x1 -> (Function1<Object, Object> & java.io.Serializable & Serializable)x2 -> this.apply(x1, x2);
    }

    public static /* synthetic */ Function1 tupled$(Function2 $this) {
        return $this.tupled();
    }

    default public Function1<Tuple2<T1, T2>, R> tupled() {
        return (Function1<Tuple2, Object> & java.io.Serializable & Serializable)x0$1 -> {
            if (x0$1 == null) {
                throw new MatchError((Object)null);
            }
            Object x1 = x0$1._1();
            Object x2 = x0$1._2();
            Object r = this.apply(x1, x2);
            return r;
        };
    }

    public static /* synthetic */ String toString$(Function2 $this) {
        return $this.toString();
    }

    default public String toString() {
        return "<function2>";
    }

    public static /* synthetic */ boolean apply$mcZDD$sp$(Function2 $this, double v1, double v2) {
        return $this.apply$mcZDD$sp(v1, v2);
    }

    default public boolean apply$mcZDD$sp(double v1, double v2) {
        return BoxesRunTime.unboxToBoolean(this.apply(BoxesRunTime.boxToDouble(v1), BoxesRunTime.boxToDouble(v2)));
    }

    public static /* synthetic */ double apply$mcDDD$sp$(Function2 $this, double v1, double v2) {
        return $this.apply$mcDDD$sp(v1, v2);
    }

    default public double apply$mcDDD$sp(double v1, double v2) {
        return BoxesRunTime.unboxToDouble(this.apply(BoxesRunTime.boxToDouble(v1), BoxesRunTime.boxToDouble(v2)));
    }

    public static /* synthetic */ float apply$mcFDD$sp$(Function2 $this, double v1, double v2) {
        return $this.apply$mcFDD$sp(v1, v2);
    }

    default public float apply$mcFDD$sp(double v1, double v2) {
        return BoxesRunTime.unboxToFloat(this.apply(BoxesRunTime.boxToDouble(v1), BoxesRunTime.boxToDouble(v2)));
    }

    public static /* synthetic */ int apply$mcIDD$sp$(Function2 $this, double v1, double v2) {
        return $this.apply$mcIDD$sp(v1, v2);
    }

    default public int apply$mcIDD$sp(double v1, double v2) {
        return BoxesRunTime.unboxToInt(this.apply(BoxesRunTime.boxToDouble(v1), BoxesRunTime.boxToDouble(v2)));
    }

    public static /* synthetic */ long apply$mcJDD$sp$(Function2 $this, double v1, double v2) {
        return $this.apply$mcJDD$sp(v1, v2);
    }

    default public long apply$mcJDD$sp(double v1, double v2) {
        return BoxesRunTime.unboxToLong(this.apply(BoxesRunTime.boxToDouble(v1), BoxesRunTime.boxToDouble(v2)));
    }

    public static /* synthetic */ void apply$mcVDD$sp$(Function2 $this, double v1, double v2) {
        $this.apply$mcVDD$sp(v1, v2);
    }

    default public void apply$mcVDD$sp(double v1, double v2) {
        this.apply(BoxesRunTime.boxToDouble(v1), BoxesRunTime.boxToDouble(v2));
    }

    public static /* synthetic */ boolean apply$mcZDI$sp$(Function2 $this, double v1, int v2) {
        return $this.apply$mcZDI$sp(v1, v2);
    }

    default public boolean apply$mcZDI$sp(double v1, int v2) {
        return BoxesRunTime.unboxToBoolean(this.apply(BoxesRunTime.boxToDouble(v1), BoxesRunTime.boxToInteger(v2)));
    }

    public static /* synthetic */ double apply$mcDDI$sp$(Function2 $this, double v1, int v2) {
        return $this.apply$mcDDI$sp(v1, v2);
    }

    default public double apply$mcDDI$sp(double v1, int v2) {
        return BoxesRunTime.unboxToDouble(this.apply(BoxesRunTime.boxToDouble(v1), BoxesRunTime.boxToInteger(v2)));
    }

    public static /* synthetic */ float apply$mcFDI$sp$(Function2 $this, double v1, int v2) {
        return $this.apply$mcFDI$sp(v1, v2);
    }

    default public float apply$mcFDI$sp(double v1, int v2) {
        return BoxesRunTime.unboxToFloat(this.apply(BoxesRunTime.boxToDouble(v1), BoxesRunTime.boxToInteger(v2)));
    }

    public static /* synthetic */ int apply$mcIDI$sp$(Function2 $this, double v1, int v2) {
        return $this.apply$mcIDI$sp(v1, v2);
    }

    default public int apply$mcIDI$sp(double v1, int v2) {
        return BoxesRunTime.unboxToInt(this.apply(BoxesRunTime.boxToDouble(v1), BoxesRunTime.boxToInteger(v2)));
    }

    public static /* synthetic */ long apply$mcJDI$sp$(Function2 $this, double v1, int v2) {
        return $this.apply$mcJDI$sp(v1, v2);
    }

    default public long apply$mcJDI$sp(double v1, int v2) {
        return BoxesRunTime.unboxToLong(this.apply(BoxesRunTime.boxToDouble(v1), BoxesRunTime.boxToInteger(v2)));
    }

    public static /* synthetic */ void apply$mcVDI$sp$(Function2 $this, double v1, int v2) {
        $this.apply$mcVDI$sp(v1, v2);
    }

    default public void apply$mcVDI$sp(double v1, int v2) {
        this.apply(BoxesRunTime.boxToDouble(v1), BoxesRunTime.boxToInteger(v2));
    }

    public static /* synthetic */ boolean apply$mcZDJ$sp$(Function2 $this, double v1, long v2) {
        return $this.apply$mcZDJ$sp(v1, v2);
    }

    default public boolean apply$mcZDJ$sp(double v1, long v2) {
        return BoxesRunTime.unboxToBoolean(this.apply(BoxesRunTime.boxToDouble(v1), BoxesRunTime.boxToLong(v2)));
    }

    public static /* synthetic */ double apply$mcDDJ$sp$(Function2 $this, double v1, long v2) {
        return $this.apply$mcDDJ$sp(v1, v2);
    }

    default public double apply$mcDDJ$sp(double v1, long v2) {
        return BoxesRunTime.unboxToDouble(this.apply(BoxesRunTime.boxToDouble(v1), BoxesRunTime.boxToLong(v2)));
    }

    public static /* synthetic */ float apply$mcFDJ$sp$(Function2 $this, double v1, long v2) {
        return $this.apply$mcFDJ$sp(v1, v2);
    }

    default public float apply$mcFDJ$sp(double v1, long v2) {
        return BoxesRunTime.unboxToFloat(this.apply(BoxesRunTime.boxToDouble(v1), BoxesRunTime.boxToLong(v2)));
    }

    public static /* synthetic */ int apply$mcIDJ$sp$(Function2 $this, double v1, long v2) {
        return $this.apply$mcIDJ$sp(v1, v2);
    }

    default public int apply$mcIDJ$sp(double v1, long v2) {
        return BoxesRunTime.unboxToInt(this.apply(BoxesRunTime.boxToDouble(v1), BoxesRunTime.boxToLong(v2)));
    }

    public static /* synthetic */ long apply$mcJDJ$sp$(Function2 $this, double v1, long v2) {
        return $this.apply$mcJDJ$sp(v1, v2);
    }

    default public long apply$mcJDJ$sp(double v1, long v2) {
        return BoxesRunTime.unboxToLong(this.apply(BoxesRunTime.boxToDouble(v1), BoxesRunTime.boxToLong(v2)));
    }

    public static /* synthetic */ void apply$mcVDJ$sp$(Function2 $this, double v1, long v2) {
        $this.apply$mcVDJ$sp(v1, v2);
    }

    default public void apply$mcVDJ$sp(double v1, long v2) {
        this.apply(BoxesRunTime.boxToDouble(v1), BoxesRunTime.boxToLong(v2));
    }

    public static /* synthetic */ boolean apply$mcZID$sp$(Function2 $this, int v1, double v2) {
        return $this.apply$mcZID$sp(v1, v2);
    }

    default public boolean apply$mcZID$sp(int v1, double v2) {
        return BoxesRunTime.unboxToBoolean(this.apply(BoxesRunTime.boxToInteger(v1), BoxesRunTime.boxToDouble(v2)));
    }

    public static /* synthetic */ double apply$mcDID$sp$(Function2 $this, int v1, double v2) {
        return $this.apply$mcDID$sp(v1, v2);
    }

    default public double apply$mcDID$sp(int v1, double v2) {
        return BoxesRunTime.unboxToDouble(this.apply(BoxesRunTime.boxToInteger(v1), BoxesRunTime.boxToDouble(v2)));
    }

    public static /* synthetic */ float apply$mcFID$sp$(Function2 $this, int v1, double v2) {
        return $this.apply$mcFID$sp(v1, v2);
    }

    default public float apply$mcFID$sp(int v1, double v2) {
        return BoxesRunTime.unboxToFloat(this.apply(BoxesRunTime.boxToInteger(v1), BoxesRunTime.boxToDouble(v2)));
    }

    public static /* synthetic */ int apply$mcIID$sp$(Function2 $this, int v1, double v2) {
        return $this.apply$mcIID$sp(v1, v2);
    }

    default public int apply$mcIID$sp(int v1, double v2) {
        return BoxesRunTime.unboxToInt(this.apply(BoxesRunTime.boxToInteger(v1), BoxesRunTime.boxToDouble(v2)));
    }

    public static /* synthetic */ long apply$mcJID$sp$(Function2 $this, int v1, double v2) {
        return $this.apply$mcJID$sp(v1, v2);
    }

    default public long apply$mcJID$sp(int v1, double v2) {
        return BoxesRunTime.unboxToLong(this.apply(BoxesRunTime.boxToInteger(v1), BoxesRunTime.boxToDouble(v2)));
    }

    public static /* synthetic */ void apply$mcVID$sp$(Function2 $this, int v1, double v2) {
        $this.apply$mcVID$sp(v1, v2);
    }

    default public void apply$mcVID$sp(int v1, double v2) {
        this.apply(BoxesRunTime.boxToInteger(v1), BoxesRunTime.boxToDouble(v2));
    }

    public static /* synthetic */ boolean apply$mcZII$sp$(Function2 $this, int v1, int v2) {
        return $this.apply$mcZII$sp(v1, v2);
    }

    default public boolean apply$mcZII$sp(int v1, int v2) {
        return BoxesRunTime.unboxToBoolean(this.apply(BoxesRunTime.boxToInteger(v1), BoxesRunTime.boxToInteger(v2)));
    }

    public static /* synthetic */ double apply$mcDII$sp$(Function2 $this, int v1, int v2) {
        return $this.apply$mcDII$sp(v1, v2);
    }

    default public double apply$mcDII$sp(int v1, int v2) {
        return BoxesRunTime.unboxToDouble(this.apply(BoxesRunTime.boxToInteger(v1), BoxesRunTime.boxToInteger(v2)));
    }

    public static /* synthetic */ float apply$mcFII$sp$(Function2 $this, int v1, int v2) {
        return $this.apply$mcFII$sp(v1, v2);
    }

    default public float apply$mcFII$sp(int v1, int v2) {
        return BoxesRunTime.unboxToFloat(this.apply(BoxesRunTime.boxToInteger(v1), BoxesRunTime.boxToInteger(v2)));
    }

    public static /* synthetic */ int apply$mcIII$sp$(Function2 $this, int v1, int v2) {
        return $this.apply$mcIII$sp(v1, v2);
    }

    default public int apply$mcIII$sp(int v1, int v2) {
        return BoxesRunTime.unboxToInt(this.apply(BoxesRunTime.boxToInteger(v1), BoxesRunTime.boxToInteger(v2)));
    }

    public static /* synthetic */ long apply$mcJII$sp$(Function2 $this, int v1, int v2) {
        return $this.apply$mcJII$sp(v1, v2);
    }

    default public long apply$mcJII$sp(int v1, int v2) {
        return BoxesRunTime.unboxToLong(this.apply(BoxesRunTime.boxToInteger(v1), BoxesRunTime.boxToInteger(v2)));
    }

    public static /* synthetic */ void apply$mcVII$sp$(Function2 $this, int v1, int v2) {
        $this.apply$mcVII$sp(v1, v2);
    }

    default public void apply$mcVII$sp(int v1, int v2) {
        this.apply(BoxesRunTime.boxToInteger(v1), BoxesRunTime.boxToInteger(v2));
    }

    public static /* synthetic */ boolean apply$mcZIJ$sp$(Function2 $this, int v1, long v2) {
        return $this.apply$mcZIJ$sp(v1, v2);
    }

    default public boolean apply$mcZIJ$sp(int v1, long v2) {
        return BoxesRunTime.unboxToBoolean(this.apply(BoxesRunTime.boxToInteger(v1), BoxesRunTime.boxToLong(v2)));
    }

    public static /* synthetic */ double apply$mcDIJ$sp$(Function2 $this, int v1, long v2) {
        return $this.apply$mcDIJ$sp(v1, v2);
    }

    default public double apply$mcDIJ$sp(int v1, long v2) {
        return BoxesRunTime.unboxToDouble(this.apply(BoxesRunTime.boxToInteger(v1), BoxesRunTime.boxToLong(v2)));
    }

    public static /* synthetic */ float apply$mcFIJ$sp$(Function2 $this, int v1, long v2) {
        return $this.apply$mcFIJ$sp(v1, v2);
    }

    default public float apply$mcFIJ$sp(int v1, long v2) {
        return BoxesRunTime.unboxToFloat(this.apply(BoxesRunTime.boxToInteger(v1), BoxesRunTime.boxToLong(v2)));
    }

    public static /* synthetic */ int apply$mcIIJ$sp$(Function2 $this, int v1, long v2) {
        return $this.apply$mcIIJ$sp(v1, v2);
    }

    default public int apply$mcIIJ$sp(int v1, long v2) {
        return BoxesRunTime.unboxToInt(this.apply(BoxesRunTime.boxToInteger(v1), BoxesRunTime.boxToLong(v2)));
    }

    public static /* synthetic */ long apply$mcJIJ$sp$(Function2 $this, int v1, long v2) {
        return $this.apply$mcJIJ$sp(v1, v2);
    }

    default public long apply$mcJIJ$sp(int v1, long v2) {
        return BoxesRunTime.unboxToLong(this.apply(BoxesRunTime.boxToInteger(v1), BoxesRunTime.boxToLong(v2)));
    }

    public static /* synthetic */ void apply$mcVIJ$sp$(Function2 $this, int v1, long v2) {
        $this.apply$mcVIJ$sp(v1, v2);
    }

    default public void apply$mcVIJ$sp(int v1, long v2) {
        this.apply(BoxesRunTime.boxToInteger(v1), BoxesRunTime.boxToLong(v2));
    }

    public static /* synthetic */ boolean apply$mcZJD$sp$(Function2 $this, long v1, double v2) {
        return $this.apply$mcZJD$sp(v1, v2);
    }

    default public boolean apply$mcZJD$sp(long v1, double v2) {
        return BoxesRunTime.unboxToBoolean(this.apply(BoxesRunTime.boxToLong(v1), BoxesRunTime.boxToDouble(v2)));
    }

    public static /* synthetic */ double apply$mcDJD$sp$(Function2 $this, long v1, double v2) {
        return $this.apply$mcDJD$sp(v1, v2);
    }

    default public double apply$mcDJD$sp(long v1, double v2) {
        return BoxesRunTime.unboxToDouble(this.apply(BoxesRunTime.boxToLong(v1), BoxesRunTime.boxToDouble(v2)));
    }

    public static /* synthetic */ float apply$mcFJD$sp$(Function2 $this, long v1, double v2) {
        return $this.apply$mcFJD$sp(v1, v2);
    }

    default public float apply$mcFJD$sp(long v1, double v2) {
        return BoxesRunTime.unboxToFloat(this.apply(BoxesRunTime.boxToLong(v1), BoxesRunTime.boxToDouble(v2)));
    }

    public static /* synthetic */ int apply$mcIJD$sp$(Function2 $this, long v1, double v2) {
        return $this.apply$mcIJD$sp(v1, v2);
    }

    default public int apply$mcIJD$sp(long v1, double v2) {
        return BoxesRunTime.unboxToInt(this.apply(BoxesRunTime.boxToLong(v1), BoxesRunTime.boxToDouble(v2)));
    }

    public static /* synthetic */ long apply$mcJJD$sp$(Function2 $this, long v1, double v2) {
        return $this.apply$mcJJD$sp(v1, v2);
    }

    default public long apply$mcJJD$sp(long v1, double v2) {
        return BoxesRunTime.unboxToLong(this.apply(BoxesRunTime.boxToLong(v1), BoxesRunTime.boxToDouble(v2)));
    }

    public static /* synthetic */ void apply$mcVJD$sp$(Function2 $this, long v1, double v2) {
        $this.apply$mcVJD$sp(v1, v2);
    }

    default public void apply$mcVJD$sp(long v1, double v2) {
        this.apply(BoxesRunTime.boxToLong(v1), BoxesRunTime.boxToDouble(v2));
    }

    public static /* synthetic */ boolean apply$mcZJI$sp$(Function2 $this, long v1, int v2) {
        return $this.apply$mcZJI$sp(v1, v2);
    }

    default public boolean apply$mcZJI$sp(long v1, int v2) {
        return BoxesRunTime.unboxToBoolean(this.apply(BoxesRunTime.boxToLong(v1), BoxesRunTime.boxToInteger(v2)));
    }

    public static /* synthetic */ double apply$mcDJI$sp$(Function2 $this, long v1, int v2) {
        return $this.apply$mcDJI$sp(v1, v2);
    }

    default public double apply$mcDJI$sp(long v1, int v2) {
        return BoxesRunTime.unboxToDouble(this.apply(BoxesRunTime.boxToLong(v1), BoxesRunTime.boxToInteger(v2)));
    }

    public static /* synthetic */ float apply$mcFJI$sp$(Function2 $this, long v1, int v2) {
        return $this.apply$mcFJI$sp(v1, v2);
    }

    default public float apply$mcFJI$sp(long v1, int v2) {
        return BoxesRunTime.unboxToFloat(this.apply(BoxesRunTime.boxToLong(v1), BoxesRunTime.boxToInteger(v2)));
    }

    public static /* synthetic */ int apply$mcIJI$sp$(Function2 $this, long v1, int v2) {
        return $this.apply$mcIJI$sp(v1, v2);
    }

    default public int apply$mcIJI$sp(long v1, int v2) {
        return BoxesRunTime.unboxToInt(this.apply(BoxesRunTime.boxToLong(v1), BoxesRunTime.boxToInteger(v2)));
    }

    public static /* synthetic */ long apply$mcJJI$sp$(Function2 $this, long v1, int v2) {
        return $this.apply$mcJJI$sp(v1, v2);
    }

    default public long apply$mcJJI$sp(long v1, int v2) {
        return BoxesRunTime.unboxToLong(this.apply(BoxesRunTime.boxToLong(v1), BoxesRunTime.boxToInteger(v2)));
    }

    public static /* synthetic */ void apply$mcVJI$sp$(Function2 $this, long v1, int v2) {
        $this.apply$mcVJI$sp(v1, v2);
    }

    default public void apply$mcVJI$sp(long v1, int v2) {
        this.apply(BoxesRunTime.boxToLong(v1), BoxesRunTime.boxToInteger(v2));
    }

    public static /* synthetic */ boolean apply$mcZJJ$sp$(Function2 $this, long v1, long v2) {
        return $this.apply$mcZJJ$sp(v1, v2);
    }

    default public boolean apply$mcZJJ$sp(long v1, long v2) {
        return BoxesRunTime.unboxToBoolean(this.apply(BoxesRunTime.boxToLong(v1), BoxesRunTime.boxToLong(v2)));
    }

    public static /* synthetic */ double apply$mcDJJ$sp$(Function2 $this, long v1, long v2) {
        return $this.apply$mcDJJ$sp(v1, v2);
    }

    default public double apply$mcDJJ$sp(long v1, long v2) {
        return BoxesRunTime.unboxToDouble(this.apply(BoxesRunTime.boxToLong(v1), BoxesRunTime.boxToLong(v2)));
    }

    public static /* synthetic */ float apply$mcFJJ$sp$(Function2 $this, long v1, long v2) {
        return $this.apply$mcFJJ$sp(v1, v2);
    }

    default public float apply$mcFJJ$sp(long v1, long v2) {
        return BoxesRunTime.unboxToFloat(this.apply(BoxesRunTime.boxToLong(v1), BoxesRunTime.boxToLong(v2)));
    }

    public static /* synthetic */ int apply$mcIJJ$sp$(Function2 $this, long v1, long v2) {
        return $this.apply$mcIJJ$sp(v1, v2);
    }

    default public int apply$mcIJJ$sp(long v1, long v2) {
        return BoxesRunTime.unboxToInt(this.apply(BoxesRunTime.boxToLong(v1), BoxesRunTime.boxToLong(v2)));
    }

    public static /* synthetic */ long apply$mcJJJ$sp$(Function2 $this, long v1, long v2) {
        return $this.apply$mcJJJ$sp(v1, v2);
    }

    default public long apply$mcJJJ$sp(long v1, long v2) {
        return BoxesRunTime.unboxToLong(this.apply(BoxesRunTime.boxToLong(v1), BoxesRunTime.boxToLong(v2)));
    }

    public static /* synthetic */ void apply$mcVJJ$sp$(Function2 $this, long v1, long v2) {
        $this.apply$mcVJJ$sp(v1, v2);
    }

    default public void apply$mcVJJ$sp(long v1, long v2) {
        this.apply(BoxesRunTime.boxToLong(v1), BoxesRunTime.boxToLong(v2));
    }

    public static void $init$(Function2 $this) {
    }
}

