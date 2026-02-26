/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import scala.math.Numeric;
import scala.math.ScalaNumericAnyConversions;
import scala.reflect.ScalaSignature;
import scala.runtime.OrderedProxy;

@ScalaSignature(bytes="\u0006\u0001=4qAD\b\u0011\u0002\u0007\u0005A\u0003C\u00034\u0001\u0011\u0005A\u0007C\u00039\u0001\u0019M\u0011\bC\u0003B\u0001\u0011\u0005!\tC\u0003G\u0001\u0011\u0005q\tC\u0003L\u0001\u0011\u0005A\nC\u0003Q\u0001\u0011\u0005\u0011\u000bC\u0003V\u0001\u0011\u0005a\u000bC\u0003[\u0001\u0011\u00051\fC\u0003`\u0001\u0011\u0005\u0001\rC\u0003e\u0001\u0011\u0005Q\rC\u0003i\u0001\u0011\u0005\u0011\u000eC\u0003l\u0001\u0011\u0005A\u000eC\u0003n\u0001\u0011\u0005aN\u0001\tTG\u0006d\u0017MT;nE\u0016\u0014\bK]8ys*\u0011\u0001#E\u0001\beVtG/[7f\u0015\u0005\u0011\u0012!B:dC2\f7\u0001A\u000b\u0003+%\u001aR\u0001\u0001\f\u001bA=\u0002\"a\u0006\r\u000e\u0003EI!!G\t\u0003\u0007\u0005s\u0017\u0010\u0005\u0002\u001c=5\tAD\u0003\u0002\u001e#\u0005!Q.\u0019;i\u0013\tyBD\u0001\u000eTG\u0006d\u0017MT;nKJL7-\u00118z\u0007>tg/\u001a:tS>t7\u000fE\u0002\"I\u001dr!a\u0006\u0012\n\u0005\r\n\u0012!\u0002)s_bL\u0018BA\u0013'\u0005\u0015!\u0016\u0010]3e\u0015\t\u0019\u0013\u0003\u0005\u0002)S1\u0001A!\u0002\u0016\u0001\u0005\u0004Y#!\u0001+\u0012\u000512\u0002CA\f.\u0013\tq\u0013CA\u0004O_RD\u0017N\\4\u0011\u0007A\nt%D\u0001\u0010\u0013\t\u0011tB\u0001\u0007Pe\u0012,'/\u001a3Qe>D\u00180\u0001\u0004%S:LG\u000f\n\u000b\u0002kA\u0011qCN\u0005\u0003oE\u0011A!\u00168ji\u0006\u0019a.^7\u0016\u0003i\u00022a\u000f (\u001d\t9B(\u0003\u0002>#\u00059\u0001/Y2lC\u001e,\u0017BA A\u0005\u001dqU/\\3sS\u000eT!!P\t\u0002\u0015UtG-\u001a:ms&tw\rF\u0001D!\t9B)\u0003\u0002F#\t1\u0011I\\=SK\u001a\f1\u0002Z8vE2,g+\u00197vKR\t\u0001\n\u0005\u0002\u0018\u0013&\u0011!*\u0005\u0002\u0007\t>,(\r\\3\u0002\u0015\u0019dw.\u0019;WC2,X\rF\u0001N!\t9b*\u0003\u0002P#\t)a\t\\8bi\u0006IAn\u001c8h-\u0006dW/\u001a\u000b\u0002%B\u0011qcU\u0005\u0003)F\u0011A\u0001T8oO\u0006A\u0011N\u001c;WC2,X\rF\u0001X!\t9\u0002,\u0003\u0002Z#\t\u0019\u0011J\u001c;\u0002\u0013\tLH/\u001a,bYV,G#\u0001/\u0011\u0005]i\u0016B\u00010\u0012\u0005\u0011\u0011\u0015\u0010^3\u0002\u0015MDwN\u001d;WC2,X\rF\u0001b!\t9\"-\u0003\u0002d#\t)1\u000b[8si\u0006\u0019Q.\u001b8\u0015\u0005\u001d2\u0007\"B4\u000b\u0001\u00049\u0013\u0001\u0002;iCR\f1!\\1y)\t9#\u000eC\u0003h\u0017\u0001\u0007q%A\u0002bEN,\u0012aJ\u0001\u0007g&<g.^7\u0016\u0003]\u0003")
public interface ScalaNumberProxy<T>
extends ScalaNumericAnyConversions,
OrderedProxy<T> {
    public Numeric<T> num();

    public static /* synthetic */ Object underlying$(ScalaNumberProxy $this) {
        return $this.underlying();
    }

    @Override
    default public Object underlying() {
        return this.self();
    }

    public static /* synthetic */ double doubleValue$(ScalaNumberProxy $this) {
        return $this.doubleValue();
    }

    @Override
    default public double doubleValue() {
        return this.num().toDouble(this.self());
    }

    public static /* synthetic */ float floatValue$(ScalaNumberProxy $this) {
        return $this.floatValue();
    }

    @Override
    default public float floatValue() {
        return this.num().toFloat(this.self());
    }

    public static /* synthetic */ long longValue$(ScalaNumberProxy $this) {
        return $this.longValue();
    }

    @Override
    default public long longValue() {
        return this.num().toLong(this.self());
    }

    public static /* synthetic */ int intValue$(ScalaNumberProxy $this) {
        return $this.intValue();
    }

    @Override
    default public int intValue() {
        return this.num().toInt(this.self());
    }

    public static /* synthetic */ byte byteValue$(ScalaNumberProxy $this) {
        return $this.byteValue();
    }

    @Override
    default public byte byteValue() {
        return (byte)this.intValue();
    }

    public static /* synthetic */ short shortValue$(ScalaNumberProxy $this) {
        return $this.shortValue();
    }

    @Override
    default public short shortValue() {
        return (short)this.intValue();
    }

    public static /* synthetic */ Object min$(ScalaNumberProxy $this, Object that) {
        return $this.min(that);
    }

    default public T min(T that) {
        return this.num().min(this.self(), that);
    }

    public static /* synthetic */ Object max$(ScalaNumberProxy $this, Object that) {
        return $this.max(that);
    }

    default public T max(T that) {
        return this.num().max(this.self(), that);
    }

    public static /* synthetic */ Object abs$(ScalaNumberProxy $this) {
        return $this.abs();
    }

    default public T abs() {
        return this.num().abs(this.self());
    }

    public static /* synthetic */ int signum$(ScalaNumberProxy $this) {
        return $this.signum();
    }

    default public int signum() {
        return this.num().signum(this.self());
    }

    public static void $init$(ScalaNumberProxy $this) {
    }
}

