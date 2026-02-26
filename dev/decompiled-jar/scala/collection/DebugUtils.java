/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Function1;
import scala.collection.DebugUtils$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001];a!\u0003\u0006\t\u0002)qaA\u0002\t\u000b\u0011\u0003Q\u0011\u0003C\u0003\u0017\u0003\u0011\u0005\u0001\u0004C\u0003\u001a\u0003\u0011\u0005!\u0004C\u0003,\u0003\u0011\u0005A\u0006C\u0003/\u0003\u0011\u0005q\u0006C\u00036\u0003\u0011\u0005a\u0007C\u00039\u0003\u0011\u0005\u0011\bC\u0003G\u0003\u0011\u0005q)\u0001\u0006EK\n,x-\u0016;jYNT!a\u0003\u0007\u0002\u0015\r|G\u000e\\3di&|gNC\u0001\u000e\u0003\u0015\u00198-\u00197b!\ty\u0011!D\u0001\u000b\u0005)!UMY;h+RLGn]\n\u0003\u0003I\u0001\"a\u0005\u000b\u000e\u00031I!!\u0006\u0007\u0003\r\u0005s\u0017PU3g\u0003\u0019a\u0014N\\5u}\r\u0001A#\u0001\b\u0002\u0017Ut7/\u001e9q_J$X\r\u001a\u000b\u00037y\u0001\"a\u0005\u000f\n\u0005ua!a\u0002(pi\"Lgn\u001a\u0005\u0006?\r\u0001\r\u0001I\u0001\u0004[N<\u0007CA\u0011)\u001d\t\u0011c\u0005\u0005\u0002$\u00195\tAE\u0003\u0002&/\u00051AH]8pizJ!a\n\u0007\u0002\rA\u0013X\rZ3g\u0013\tI#F\u0001\u0004TiJLgn\u001a\u0006\u0003O1\tQB\\8Tk\u000eDW\t\\3nK:$HCA\u000e.\u0011\u0015yB\u00011\u0001!\u0003AIg\u000eZ3y\u001fV$xJ\u001a\"pk:$7\u000f\u0006\u0002\u001ca!)\u0011'\u0002a\u0001e\u0005)\u0011N\u001c3fqB\u00111cM\u0005\u0003i1\u00111!\u00138u\u0003=IG\u000e\\3hC2\f%oZ;nK:$HCA\u000e8\u0011\u0015yb\u00011\u0001!\u0003-\u0011W/\u001b7e'R\u0014\u0018N\\4\u0015\u0005\u0001R\u0004\"B\u001e\b\u0001\u0004a\u0014aB2m_N,(/\u001a\t\u0005'uz4)\u0003\u0002?\u0019\tIa)\u001e8di&|g.\r\t\u0005'u\u00025\t\u0005\u0002\u0014\u0003&\u0011!\t\u0004\u0002\u0004\u0003:L\bCA\nE\u0013\t)EB\u0001\u0003V]&$\u0018aC1se\u0006L8\u000b\u001e:j]\u001e,\"\u0001\u0013)\u0015\t\u0001J5+\u0016\u0005\u0006\u0015\"\u0001\raS\u0001\u0006CJ\u0014\u0018-\u001f\t\u0004'1s\u0015BA'\r\u0005\u0015\t%O]1z!\ty\u0005\u000b\u0004\u0001\u0005\u000bEC!\u0019\u0001*\u0003\u0003Q\u000b\"a\u0007!\t\u000bQC\u0001\u0019\u0001\u001a\u0002\t\u0019\u0014x.\u001c\u0005\u0006-\"\u0001\rAM\u0001\u0006k:$\u0018\u000e\u001c")
public final class DebugUtils {
    public static <T> String arrayString(Object object, int n, int n2) {
        return DebugUtils$.MODULE$.arrayString(object, n, n2);
    }

    public static String buildString(Function1<Function1<Object, BoxedUnit>, BoxedUnit> function1) {
        return DebugUtils$.MODULE$.buildString(function1);
    }

    public static Nothing$ illegalArgument(String string) {
        return DebugUtils$.MODULE$.illegalArgument(string);
    }

    public static Nothing$ indexOutOfBounds(int n) {
        return DebugUtils$.MODULE$.indexOutOfBounds(n);
    }

    public static Nothing$ noSuchElement(String string) {
        return DebugUtils$.MODULE$.noSuchElement(string);
    }

    public static Nothing$ unsupported(String string) {
        return DebugUtils$.MODULE$.unsupported(string);
    }
}

