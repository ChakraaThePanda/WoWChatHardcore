/*
 * Decompiled with CFR 0.152.
 */
package scala.math;

import java.util.Comparator;
import scala.Function1;
import scala.Function2;
import scala.Serializable;
import scala.math.Equiv$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001\u0005\raa\u0002\u0007\u000e!\u0003\r\nA\u0005\u0005\u00067\u00011\t\u0001H\u0004\u0006Y5A\t!\f\u0004\u0006\u00195A\ta\f\u0005\u0006m\r!\ta\u000e\u0005\u0006q\r!\t!\u000f\u0005\u0006\u007f\r!\t\u0001\u0011\u0005\u0006\u000b\u000e!\tA\u0012\u0005\u0006+\u000e!\tA\u0016\u0005\u0006?\u000e!\t\u0001\u0019\u0005\u0006c\u000e!\tA\u001d\u0005\bs\u000e\t\t\u0011\"\u0003{\u0005\u0015)\u0015/^5w\u0015\tqq\"\u0001\u0003nCRD'\"\u0001\t\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u00111\u0003J\n\u0004\u0001QA\u0002CA\u000b\u0017\u001b\u0005y\u0011BA\f\u0010\u0005\r\te.\u001f\t\u0003+eI!AG\b\u0003\u0019M+'/[1mSj\f'\r\\3\u0002\u000b\u0015\fX/\u001b<\u0015\u0007u\u0001#\u0006\u0005\u0002\u0016=%\u0011qd\u0004\u0002\b\u0005>|G.Z1o\u0011\u0015\t\u0013\u00011\u0001#\u0003\u0005A\bCA\u0012%\u0019\u0001!Q!\n\u0001C\u0002\u0019\u0012\u0011\u0001V\t\u0003OQ\u0001\"!\u0006\u0015\n\u0005%z!a\u0002(pi\"Lgn\u001a\u0005\u0006W\u0005\u0001\rAI\u0001\u0002s\u0006)Q)];jmB\u0011afA\u0007\u0002\u001bM!1\u0001M\u001a\u0019!\t)\u0012'\u0003\u00023\u001f\t1\u0011I\\=SK\u001a\u0004\"A\f\u001b\n\u0005Uj!\u0001\u0005'poB\u0013\u0018n\u001c:jif,\u0015/^5w\u0003\u0019a\u0014N\\5u}Q\tQ&A\u0005sK\u001a,'/\u001a8dKV\u0011!(P\u000b\u0002wA\u0019a\u0006\u0001\u001f\u0011\u0005\rjD!B\u0013\u0006\u0005\u0004q\u0014CA\u00141\u0003%)h.\u001b<feN\fG.\u0006\u0002B\tV\t!\tE\u0002/\u0001\r\u0003\"a\t#\u0005\u000b\u00152!\u0019\u0001\u0014\u0002\u001d\u0019\u0014x.\\\"p[B\f'/\u0019;peV\u0011qI\u0013\u000b\u0003\u0011.\u00032A\f\u0001J!\t\u0019#\nB\u0003&\u000f\t\u0007a\u0005C\u0003M\u000f\u0001\u0007Q*A\u0002d[B\u00042AT*J\u001b\u0005y%B\u0001)R\u0003\u0011)H/\u001b7\u000b\u0003I\u000bAA[1wC&\u0011Ak\u0014\u0002\u000b\u0007>l\u0007/\u0019:bi>\u0014\u0018\u0001\u00044s_64UO\\2uS>tWCA,[)\tA6\fE\u0002/\u0001e\u0003\"a\t.\u0005\u000b\u0015B!\u0019\u0001\u0014\t\u000b1C\u0001\u0019\u0001/\u0011\u000bUi\u0016,W\u000f\n\u0005y{!!\u0003$v]\u000e$\u0018n\u001c83\u0003\t\u0011\u00170F\u0002bK*$\"A\u00197\u0015\u0005\r4\u0007c\u0001\u0018\u0001IB\u00111%\u001a\u0003\u0006K%\u0011\rA\n\u0005\bO&\t\t\u0011q\u0001i\u0003))g/\u001b3f]\u000e,G%\r\t\u0004]\u0001I\u0007CA\u0012k\t\u0015Y\u0017B1\u0001'\u0005\u0005\u0019\u0006\"B7\n\u0001\u0004q\u0017!\u00014\u0011\tUyG-[\u0005\u0003a>\u0011\u0011BR;oGRLwN\\\u0019\u0002\u000b\u0005\u0004\b\u000f\\=\u0016\u0005M4HC\u0001;x!\rq\u0003!\u001e\t\u0003GY$Q!\n\u0006C\u0002\u0019Bq\u0001\u001f\u0006\u0002\u0002\u0003\u000fA/\u0001\u0006fm&$WM\\2fII\n1B]3bIJ+7o\u001c7wKR\t1\u0010\u0005\u0002}\u007f6\tQP\u0003\u0002\u007f#\u0006!A.\u00198h\u0013\r\t\t! \u0002\u0007\u001f\nTWm\u0019;")
public interface Equiv<T>
extends Serializable {
    public static <T> Equiv<T> apply(Equiv<T> equiv) {
        return Equiv$.MODULE$.apply(equiv);
    }

    public static <T, S> Equiv<T> by(Function1<T, S> function1, Equiv<S> equiv) {
        if (Equiv$.MODULE$ == null) {
            throw null;
        }
        Function2<Object, Object, Object> & java.io.Serializable & Serializable by_fromFunction_cmp = (arg_0, arg_1) -> Equiv$.$anonfun$by$1$adapted(equiv, function1, arg_0, arg_1);
        return new Equiv<T>(by_fromFunction_cmp){
            private final Function2 cmp$2;

            public boolean equiv(T x, T y) {
                return BoxesRunTime.unboxToBoolean(this.cmp$2.apply(x, y));
            }
            {
                this.cmp$2 = cmp$2;
            }
        };
    }

    public static <T> Equiv<T> fromFunction(Function2<T, T, Object> function2) {
        if (Equiv$.MODULE$ == null) {
            throw null;
        }
        return new /* invalid duplicate definition of identical inner class */;
    }

    public static <T> Equiv<T> fromComparator(Comparator<T> comparator) {
        if (Equiv$.MODULE$ == null) {
            throw null;
        }
        return new Equiv<T>(comparator){
            private final Comparator cmp$1;

            public boolean equiv(T x, T y) {
                return this.cmp$1.compare(x, y) == 0;
            }
            {
                this.cmp$1 = cmp$1;
            }
        };
    }

    public static <T> Equiv<T> universal() {
        return Equiv$.MODULE$.universal();
    }

    public static <T> Equiv<T> reference() {
        return Equiv$.MODULE$.reference();
    }

    public static <T> Equiv<T> universalEquiv() {
        return Equiv$.MODULE$.universalEquiv();
    }

    public boolean equiv(T var1, T var2);
}

