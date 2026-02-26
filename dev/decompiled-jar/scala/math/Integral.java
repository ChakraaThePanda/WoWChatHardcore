/*
 * Decompiled with CFR 0.152.
 */
package scala.math;

import scala.Tuple2;
import scala.math.Numeric;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001}4q!\u0006\f\u0011\u0002\u0007\u00051\u0004C\u00036\u0001\u0011\u0005a\u0007C\u0003;\u0001\u0019\u00051\bC\u0003A\u0001\u0019\u0005\u0011I\u0002\u0003E\u0001\u0001)\u0005\u0002\u0003&\u0005\u0005\u0003\u0005\u000b\u0011B\u0015\t\u000b-#A\u0011\u0001'\t\u000b=#A\u0011\u0001)\t\u000bM#A\u0011\u0001+\t\u000bY#A\u0011A,\t\u000bq\u0003A1I/\b\u000b}3\u0002\u0012\u00011\u0007\u000bU1\u0002\u0012A1\t\u000b-cA\u0011\u00015\u0007\u000f%d\u0001\u0013aA\u0001U\")QG\u0004C\u0001m!)1N\u0004C\u0002Y\u001e)a\u000f\u0004E\u0001o\u001a)\u0011\u0010\u0004E\u0001u\")1J\u0005C\u0001y\"9Q\u0010DA\u0001\n\u0013q(\u0001C%oi\u0016<'/\u00197\u000b\u0005]A\u0012\u0001B7bi\"T\u0011!G\u0001\u0006g\u000e\fG.Y\u0002\u0001+\ta2fE\u0002\u0001;\u0015\u0002\"AH\u0012\u000e\u0003}Q!\u0001I\u0011\u0002\t1\fgn\u001a\u0006\u0002E\u0005!!.\u0019<b\u0013\t!sD\u0001\u0004PE*,7\r\u001e\t\u0004M\u001dJS\"\u0001\f\n\u0005!2\"a\u0002(v[\u0016\u0014\u0018n\u0019\t\u0003U-b\u0001\u0001B\u0003-\u0001\t\u0007QFA\u0001U#\tq#\u0007\u0005\u00020a5\t\u0001$\u0003\u000221\t9aj\u001c;iS:<\u0007CA\u00184\u0013\t!\u0004DA\u0002B]f\fa\u0001J5oSR$C#A\u001c\u0011\u0005=B\u0014BA\u001d\u0019\u0005\u0011)f.\u001b;\u0002\tE,x\u000e\u001e\u000b\u0004Sqr\u0004\"B\u001f\u0003\u0001\u0004I\u0013!\u0001=\t\u000b}\u0012\u0001\u0019A\u0015\u0002\u0003e\f1A]3n)\rI#i\u0011\u0005\u0006{\r\u0001\r!\u000b\u0005\u0006\u007f\r\u0001\r!\u000b\u0002\f\u0013:$Xm\u001a:bY>\u00038o\u0005\u0002\u0005\rB\u0011q\tS\u0007\u0002\u0001%\u0011\u0011j\n\u0002\u0004\u001fB\u001c\u0018a\u00017ig\u00061A(\u001b8jiz\"\"!\u0014(\u0011\u0005\u001d#\u0001\"\u0002&\u0007\u0001\u0004I\u0013\u0001\u0002\u0013eSZ$\"!K)\t\u000bI;\u0001\u0019A\u0015\u0002\u0007ID7/\u0001\u0005%a\u0016\u00148-\u001a8u)\tIS\u000bC\u0003S\u0011\u0001\u0007\u0011&\u0001\u0007%I&4H\u0005]3sG\u0016tG\u000f\u0006\u0002Y7B!q&W\u0015*\u0013\tQ\u0006D\u0001\u0004UkBdWM\r\u0005\u0006%&\u0001\r!K\u0001\r[.tU/\\3sS\u000e|\u0005o\u001d\u000b\u0003\u001bzCQA\u0013\u0006A\u0002%\n\u0001\"\u00138uK\u001e\u0014\u0018\r\u001c\t\u0003M1\u00192\u0001\u00042f!\ty3-\u0003\u0002e1\t1\u0011I\\=SK\u001a\u0004\"a\f4\n\u0005\u001dD\"\u0001D*fe&\fG.\u001b>bE2,G#\u00011\u0003\u001d\u0015CHO]1J[Bd\u0017nY5ugN\u0011aBY\u0001\u0011S:4\u0017\u000e_%oi\u0016<'/\u00197PaN,\"!\u001c:\u0015\u00059,HCA8t!\t\u0001H\u0001E\u0002'\u0001E\u0004\"A\u000b:\u0005\u000b1\u0002\"\u0019A\u0017\t\u000bQ\u0004\u00029\u00019\u0002\u00079,X\u000eC\u0003>!\u0001\u0007\u0011/A\u0005J[Bd\u0017nY5ugB\u0011\u0001PE\u0007\u0002\u0019\tI\u0011*\u001c9mS\u000eLGo]\n\u0004%\t\\\bC\u0001=\u000f)\u00059\u0018a\u0003:fC\u0012\u0014Vm]8mm\u0016$\u0012!\b")
public interface Integral<T>
extends Numeric<T> {
    public T quot(T var1, T var2);

    public T rem(T var1, T var2);

    public static /* synthetic */ IntegralOps mkNumericOps$(Integral $this, Object lhs) {
        return $this.mkNumericOps(lhs);
    }

    @Override
    default public IntegralOps mkNumericOps(T lhs) {
        return new IntegralOps(this, lhs);
    }

    public static void $init$(Integral $this) {
    }

    public static interface ExtraImplicits {
        public static /* synthetic */ IntegralOps infixIntegralOps$(ExtraImplicits $this, Object x, Integral num) {
            return $this.infixIntegralOps(x, num);
        }

        default public <T> IntegralOps infixIntegralOps(T x, Integral<T> num) {
            return new IntegralOps(num, x);
        }

        public static void $init$(ExtraImplicits $this) {
        }
    }

    public class IntegralOps
    extends Numeric.Ops {
        private final T lhs;

        public T $div(T rhs) {
            return this.scala$math$Integral$IntegralOps$$$outer().quot(this.lhs, rhs);
        }

        public T $percent(T rhs) {
            return this.scala$math$Integral$IntegralOps$$$outer().rem(this.lhs, rhs);
        }

        public Tuple2<T, T> $div$percent(T rhs) {
            return new Tuple2(this.scala$math$Integral$IntegralOps$$$outer().quot(this.lhs, rhs), this.scala$math$Integral$IntegralOps$$$outer().rem(this.lhs, rhs));
        }

        public /* synthetic */ Integral scala$math$Integral$IntegralOps$$$outer() {
            return (Integral)this.$outer;
        }

        public IntegralOps(Integral $outer, T lhs) {
            this.lhs = lhs;
            super($outer, lhs);
        }
    }
}

