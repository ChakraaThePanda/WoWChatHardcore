/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import scala.Function1;
import scala.Serializable;
import scala.collection.immutable.NumericRange;
import scala.collection.immutable.NumericRange$;
import scala.math.Fractional;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.RangedProxy;
import scala.runtime.ScalaNumberProxy;

@ScalaSignature(bytes="\u0006\u0001I4qAC\u0006\u0011\u0002\u0007\u0005\u0001\u0003C\u0003&\u0001\u0011\u0005a\u0005C\u0003+\u0001\u0019M1\u0006C\u00034\u0001\u0019MA'\u0002\u00039\u0001\u0001I\u0004\"\u0002%\u0001\t\u0003I\u0005\"B'\u0001\t\u0003q\u0005\"B'\u0001\t\u0003Y\u0006\"B4\u0001\t\u0003A\u0007\"B4\u0001\t\u0003Y'a\u0004$sC\u000e$\u0018n\u001c8bYB\u0013x\u000e_=\u000b\u00051i\u0011a\u0002:v]RLW.\u001a\u0006\u0002\u001d\u0005)1oY1mC\u000e\u0001QCA\t\u001d'\u0011\u0001!C\u0006\u0012\u0011\u0005M!R\"A\u0007\n\u0005Ui!aA!osB\u0019q\u0003\u0007\u000e\u000e\u0003-I!!G\u0006\u0003!M\u001b\u0017\r\\1Ok6\u0014WM\u001d)s_bL\bCA\u000e\u001d\u0019\u0001!Q!\b\u0001C\u0002y\u0011\u0011\u0001V\t\u0003?I\u0001\"a\u0005\u0011\n\u0005\u0005j!a\u0002(pi\"Lgn\u001a\t\u0004/\rR\u0012B\u0001\u0013\f\u0005-\u0011\u0016M\\4fIB\u0013x\u000e_=\u0002\r\u0011Jg.\u001b;%)\u00059\u0003CA\n)\u0013\tISB\u0001\u0003V]&$\u0018a\u00018v[V\tA\u0006E\u0002.aiq!a\u0005\u0018\n\u0005=j\u0011a\u00029bG.\fw-Z\u0005\u0003cI\u0012!B\u0012:bGRLwN\\1m\u0015\tyS\"A\u0006j]R,wM]1m\u001dVlW#A\u001b\u0011\u000752$$\u0003\u00028e\tA\u0011J\u001c;fOJ\fGNA\tSKN,H\u000e^,ji\"|W\u000f^*uKB\u0004BAO\u001f\u001b\t:\u0011QfO\u0005\u0003yI\nQAU1oO\u0016L!AP \u0003\u000fA\u000b'\u000f^5bY*\u0011A\b\u0011\u0006\u0003\u0003\n\u000b\u0011\"[7nkR\f'\r\\3\u000b\u0005\rk\u0011AC2pY2,7\r^5p]B\u0019QI\u0012\u000e\u000e\u0003\u0001K!a\u0012!\u0003\u00199+X.\u001a:jGJ\u000bgnZ3\u0002\u000f%\u001cx\u000b[8mKR\t!\n\u0005\u0002\u0014\u0017&\u0011A*\u0004\u0002\b\u0005>|G.Z1o\u0003\u0015)h\u000e^5m)\ty\u0015\u000b\u0005\u0002Q\t5\t\u0001\u0001C\u0003S\r\u0001\u0007!$A\u0002f]\u0012DCA\u0002+X3B\u00111#V\u0005\u0003-6\u0011!\u0002Z3qe\u0016\u001c\u0017\r^3eC\u0005A\u0016\u0001H;tK\u0002\u0012\u0015n\u001a#fG&l\u0017\r\u001c\u0011sC:<W\rI5ogR,\u0017\rZ\u0011\u00025\u00061!GL\u00193]Y\"2\u0001X2e!\ri\u0006M\u0007\b\u0003\u000bzK!a\u0018!\u0002\u00199+X.\u001a:jGJ\u000bgnZ3\n\u0005\u0005\u0014'!C#yG2,8/\u001b<f\u0015\ty\u0006\tC\u0003S\u000f\u0001\u0007!\u0004C\u0003f\u000f\u0001\u0007!$\u0001\u0003ti\u0016\u0004\b\u0006B\u0004U/f\u000b!\u0001^8\u0015\u0005=K\u0007\"\u0002*\t\u0001\u0004Q\u0002\u0006\u0002\u0005U/f#2\u0001\\8q!\riVNG\u0005\u0003]\n\u0014\u0011\"\u00138dYV\u001c\u0018N^3\t\u000bIK\u0001\u0019\u0001\u000e\t\u000b\u0015L\u0001\u0019\u0001\u000e)\t%!v+\u0017")
public interface FractionalProxy<T>
extends ScalaNumberProxy<T>,
RangedProxy<T> {
    @Override
    public Fractional<T> num();

    public Integral<T> integralNum();

    public static /* synthetic */ boolean isWhole$(FractionalProxy $this) {
        return $this.isWhole();
    }

    @Override
    default public boolean isWhole() {
        return false;
    }

    public static /* synthetic */ Function1 until$(FractionalProxy $this, Object end) {
        return $this.until(end);
    }

    @Override
    default public Function1<T, NumericRange<T>> until(T end) {
        return (Function1<Object, NumericRange.Exclusive> & java.io.Serializable & Serializable)x$1 -> NumericRange$.MODULE$.apply(this.self(), end, x$1, this.integralNum());
    }

    public static /* synthetic */ NumericRange.Exclusive until$(FractionalProxy $this, Object end, Object step) {
        return $this.until(end, step);
    }

    @Override
    default public NumericRange.Exclusive<T> until(T end, T step) {
        return NumericRange$.MODULE$.apply(this.self(), end, step, this.integralNum());
    }

    public static /* synthetic */ Function1 to$(FractionalProxy $this, Object end) {
        return $this.to(end);
    }

    @Override
    default public Function1<T, NumericRange<T>> to(T end) {
        return (Function1<Object, NumericRange.Inclusive> & java.io.Serializable & Serializable)x$2 -> NumericRange$.MODULE$.inclusive(this.self(), end, x$2, this.integralNum());
    }

    public static /* synthetic */ NumericRange.Inclusive to$(FractionalProxy $this, Object end, Object step) {
        return $this.to(end, step);
    }

    @Override
    default public NumericRange.Inclusive<T> to(T end, T step) {
        return NumericRange$.MODULE$.inclusive(this.self(), end, step, this.integralNum());
    }

    public static void $init$(FractionalProxy $this) {
    }
}

