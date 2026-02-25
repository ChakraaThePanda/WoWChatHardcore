/*
 * Decompiled with CFR 0.152.
 */
package scala.util.hashing;

import scala.Function1;
import scala.Serializable;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.Statics;
import scala.util.hashing.Hashing$;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@ScalaSignature(bytes="\u0006\u0001\u00194qa\u0003\u0007\u0011\u0002G\u00051\u0003C\u0003\u001d\u0001\u0019\u0005QdB\u00038\u0019!\u0005\u0001HB\u0003\f\u0019!\u0005!\bC\u0003<\u0007\u0011\u0005AH\u0002\u0003>\u0007\tq\u0004\"B\u001e\u0006\t\u0003\u0019\u0005\"\u0002\u000f\u0006\t\u00031\u0005\"\u0002%\u0004\t\u0007I\u0005\"\u0002(\u0004\t\u0003y\u0005b\u0002/\u0004\u0003\u0003%I!\u0018\u0002\b\u0011\u0006\u001c\b.\u001b8h\u0015\tia\"A\u0004iCND\u0017N\\4\u000b\u0005=\u0001\u0012\u0001B;uS2T\u0011!E\u0001\u0006g\u000e\fG.Y\u0002\u0001+\t!ReE\u0002\u0001+e\u0001\"AF\f\u000e\u0003AI!\u0001\u0007\t\u0003\r\u0005s\u0017PU3g!\t1\"$\u0003\u0002\u001c!\ta1+\u001a:jC2L'0\u00192mK\u0006!\u0001.Y:i)\tq\u0012\u0005\u0005\u0002\u0017?%\u0011\u0001\u0005\u0005\u0002\u0004\u0013:$\b\"\u0002\u0012\u0002\u0001\u0004\u0019\u0013!\u0001=\u0011\u0005\u0011*C\u0002\u0001\u0003\u0006M\u0001\u0011\ra\n\u0002\u0002)F\u0011\u0001f\u000b\t\u0003-%J!A\u000b\t\u0003\u000f9{G\u000f[5oOB\u0011a\u0003L\u0005\u0003[A\u00111!\u00118zQ\r\u0001q&\u000e\t\u0003aMj\u0011!\r\u0006\u0003eA\t!\"\u00198o_R\fG/[8o\u0013\t!\u0014G\u0001\tj[Bd\u0017nY5u\u001d>$hi\\;oI\u0006\na'A\u0013O_\u0002JW\u000e\u001d7jG&$\b\u0005S1tQ&tw\r\t3fM&tW\r\u001a\u0011g_J\u0004Ce\u001f+~]\u00059\u0001*Y:iS:<\u0007CA\u001d\u0004\u001b\u0005a1cA\u0002\u00163\u00051A(\u001b8jiz\"\u0012\u0001\u000f\u0002\b\t\u00164\u0017-\u001e7u+\ty$iE\u0002\u0006+\u0001\u00032!\u000f\u0001B!\t!#\tB\u0003'\u000b\t\u0007q\u0005F\u0001E!\r)U!Q\u0007\u0002\u0007Q\u0011ad\u0012\u0005\u0006E\u001d\u0001\r!Q\u0001\bI\u00164\u0017-\u001e7u+\tQU*F\u0001L!\r)U\u0001\u0014\t\u0003I5#QA\n\u0005C\u0002\u001d\nAB\u001a:p[\u001a+hn\u0019;j_:,\"\u0001\u0015,\u0015\u0005E;&c\u0001*\u0016)\u001a!1+\u0003\u0001R\u00051a$/\u001a4j]\u0016lWM\u001c;?!\rI\u0004!\u0016\t\u0003IY#QAJ\u0005C\u0002\u001dBQ\u0001W\u0005A\u0002e\u000b\u0011A\u001a\t\u0005-i+f$\u0003\u0002\\!\tIa)\u001e8di&|g.M\u0001\fe\u0016\fGMU3t_24X\rF\u0001_!\tyF-D\u0001a\u0015\t\t'-\u0001\u0003mC:<'\"A2\u0002\t)\fg/Y\u0005\u0003K\u0002\u0014aa\u00142kK\u000e$\b")
public interface Hashing<T>
extends Serializable {
    public static <T> Hashing<T> fromFunction(Function1<T, Object> function1) {
        if (Hashing$.MODULE$ == null) {
            throw null;
        }
        return new Hashing<T>(function1){
            private final Function1 f$1;

            public int hash(T x) {
                return BoxesRunTime.unboxToInt(this.f$1.apply(x));
            }
            {
                this.f$1 = f$1;
            }
        };
    }

    public static <T> Default<T> default() {
        return Hashing$.MODULE$.default();
    }

    public int hash(T var1);

    public static final class Default<T>
    implements Hashing<T> {
        @Override
        public int hash(T x) {
            return Statics.anyHash(x);
        }
    }
}

