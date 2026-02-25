/*
 * Decompiled with CFR 0.152.
 */
package scala.math;

import scala.math.Numeric;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001=4qAE\n\u0011\u0002\u0007\u0005\u0001\u0004C\u00033\u0001\u0011\u00051\u0007C\u00038\u0001\u0019\u0005\u0001H\u0002\u0003>\u0001\u0001q\u0004\u0002C\"\u0004\u0005\u0003\u0005\u000b\u0011\u0002\u0014\t\u000b\u0011\u001bA\u0011A#\t\u000b!\u001bA\u0011A%\t\u000b1\u0003A1I'\b\u000b=\u001b\u0002\u0012\u0001)\u0007\u000bI\u0019\u0002\u0012A)\t\u000b\u0011KA\u0011\u0001-\u0007\u000feK\u0001\u0013aA\u00015\")!g\u0003C\u0001g!)1l\u0003C\u00029\u001e)a-\u0003E\u0001O\u001a)\u0011.\u0003E\u0001U\")Ai\u0004C\u0001Y\"9Q.CA\u0001\n\u0013q'A\u0003$sC\u000e$\u0018n\u001c8bY*\u0011A#F\u0001\u0005[\u0006$\bNC\u0001\u0017\u0003\u0015\u00198-\u00197b\u0007\u0001)\"!\u0007\u0015\u0014\u0007\u0001Q\"\u0005\u0005\u0002\u001cA5\tAD\u0003\u0002\u001e=\u0005!A.\u00198h\u0015\u0005y\u0012\u0001\u00026bm\u0006L!!\t\u000f\u0003\r=\u0013'.Z2u!\r\u0019CEJ\u0007\u0002'%\u0011Qe\u0005\u0002\b\u001dVlWM]5d!\t9\u0003\u0006\u0004\u0001\u0005\u000b%\u0002!\u0019\u0001\u0016\u0003\u0003Q\u000b\"aK\u0018\u0011\u00051jS\"A\u000b\n\u00059*\"a\u0002(pi\"Lgn\u001a\t\u0003YAJ!!M\u000b\u0003\u0007\u0005s\u00170\u0001\u0004%S:LG\u000f\n\u000b\u0002iA\u0011A&N\u0005\u0003mU\u0011A!\u00168ji\u0006\u0019A-\u001b<\u0015\u0007\u0019J4\bC\u0003;\u0005\u0001\u0007a%A\u0001y\u0011\u0015a$\u00011\u0001'\u0003\u0005I(!\u0004$sC\u000e$\u0018n\u001c8bY>\u00038o\u0005\u0002\u0004\u007fA\u0011\u0001)Q\u0007\u0002\u0001%\u0011!\t\n\u0002\u0004\u001fB\u001c\u0018a\u00017ig\u00061A(\u001b8jiz\"\"AR$\u0011\u0005\u0001\u001b\u0001\"B\"\u0006\u0001\u00041\u0013\u0001\u0002\u0013eSZ$\"A\n&\t\u000b-3\u0001\u0019\u0001\u0014\u0002\u0007ID7/\u0001\u0007nW:+X.\u001a:jG>\u00038\u000f\u0006\u0002G\u001d\")1i\u0002a\u0001M\u0005QaI]1di&|g.\u00197\u0011\u0005\rJ1cA\u0005S+B\u0011AfU\u0005\u0003)V\u0011a!\u00118z%\u00164\u0007C\u0001\u0017W\u0013\t9VC\u0001\u0007TKJL\u0017\r\\5{C\ndW\rF\u0001Q\u00059)\u0005\u0010\u001e:b\u00136\u0004H.[2jiN\u001c\"a\u0003*\u0002%%tg-\u001b=Ge\u0006\u001cG/[8oC2|\u0005o]\u000b\u0003;\n$\"AX3\u0015\u0005}\u001b\u0007C\u00011\u0004!\r\u0019\u0003!\u0019\t\u0003O\t$Q!K\u0007C\u0002)BQ\u0001Z\u0007A\u0004\u0001\f1A\\;n\u0011\u0015QT\u00021\u0001b\u0003%IU\u000e\u001d7jG&$8\u000f\u0005\u0002i\u001f5\t\u0011BA\u0005J[Bd\u0017nY5ugN\u0019qBU6\u0011\u0005!\\A#A4\u0002\u0017I,\u0017\r\u001a*fg>dg/\u001a\u000b\u00025\u0001")
public interface Fractional<T>
extends Numeric<T> {
    public T div(T var1, T var2);

    public static /* synthetic */ FractionalOps mkNumericOps$(Fractional $this, Object lhs) {
        return $this.mkNumericOps(lhs);
    }

    @Override
    default public FractionalOps mkNumericOps(T lhs) {
        return new FractionalOps(this, lhs);
    }

    public static void $init$(Fractional $this) {
    }

    public static interface ExtraImplicits {
        public static /* synthetic */ FractionalOps infixFractionalOps$(ExtraImplicits $this, Object x, Fractional num) {
            return $this.infixFractionalOps(x, num);
        }

        default public <T> FractionalOps infixFractionalOps(T x, Fractional<T> num) {
            return new FractionalOps(num, x);
        }

        public static void $init$(ExtraImplicits $this) {
        }
    }

    public class FractionalOps
    extends Numeric.Ops {
        private final T lhs;

        public T $div(T rhs) {
            return this.scala$math$Fractional$FractionalOps$$$outer().div(this.lhs, rhs);
        }

        public /* synthetic */ Fractional scala$math$Fractional$FractionalOps$$$outer() {
            return (Fractional)this.$outer;
        }

        public FractionalOps(Fractional $outer, T lhs) {
            this.lhs = lhs;
            super($outer, lhs);
        }
    }
}

