/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.LongMap;
import scala.collection.immutable.LongMapUtils$;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001Q;aAB\u0004\t\u0002\u001diaAB\b\b\u0011\u00039\u0001\u0003C\u0003 \u0003\u0011\u0005\u0011\u0005C\u0003#\u0003\u0011\u00051\u0005C\u0003.\u0003\u0011\u0005a\u0006C\u0003G\u0003\u0011\u0005q)\u0001\u0007M_:<W*\u00199Vi&d7O\u0003\u0002\t\u0013\u0005I\u0011.\\7vi\u0006\u0014G.\u001a\u0006\u0003\u0015-\t!bY8mY\u0016\u001cG/[8o\u0015\u0005a\u0011!B:dC2\f\u0007C\u0001\b\u0002\u001b\u00059!\u0001\u0004'p]\u001el\u0015\r]+uS2\u001c8cA\u0001\u0012+A\u0011!cE\u0007\u0002\u0017%\u0011Ac\u0003\u0002\u0007\u0003:L(+\u001a4\u0011\u0005YabBA\f\u001b\u001b\u0005A\"BA\r\n\u0003\u001d9WM\\3sS\u000eL!a\u0007\r\u0002\u001b\tKGo\u00149fe\u0006$\u0018n\u001c8t\u0013\tibD\u0001\u0003M_:<'BA\u000e\u0019\u0003\u0019a\u0014N\\5u}\r\u0001A#A\u0007\u0002\u0015\t\u0014\u0018M\\2i\u001b\u0006\u001c8\u000eF\u0002%M-\u0002\"AE\u0013\n\u0005uY\u0001\"B\u0014\u0004\u0001\u0004A\u0013!A5\u0011\u0005%RS\"A\u0001\n\u0005ua\u0002\"\u0002\u0017\u0004\u0001\u0004A\u0013!\u00016\u0002\t)|\u0017N\\\u000b\u0003_U\"R\u0001\r A\u0005\u0012\u00032AD\u00194\u0013\t\u0011tAA\u0004M_:<W*\u00199\u0011\u0005Q*D\u0002\u0001\u0003\u0006m\u0011\u0011\ra\u000e\u0002\u0002)F\u0011\u0001h\u000f\t\u0003%eJ!AO\u0006\u0003\u000f9{G\u000f[5oOB\u0011!\u0003P\u0005\u0003{-\u00111!\u00118z\u0011\u0015yD\u00011\u0001)\u0003\t\u0001\u0018\u0007C\u0003B\t\u0001\u0007\u0001'\u0001\u0002uc!)1\t\u0002a\u0001Q\u0005\u0011\u0001O\r\u0005\u0006\u000b\u0012\u0001\r\u0001M\u0001\u0003iJ\n1AY5o+\tA5\nF\u0003J\u0019:\u0003&\u000bE\u0002\u000fc)\u0003\"\u0001N&\u0005\u000bY*!\u0019A\u001c\t\u000b5+\u0001\u0019\u0001\u0015\u0002\rA\u0014XMZ5y\u0011\u0015yU\u00011\u0001)\u0003\u0011i\u0017m]6\t\u000bE+\u0001\u0019A%\u0002\t1,g\r\u001e\u0005\u0006'\u0016\u0001\r!S\u0001\u0006e&<\u0007\u000e\u001e")
public final class LongMapUtils {
    public static <T> LongMap<T> bin(long l, long l2, LongMap<T> longMap, LongMap<T> longMap2) {
        return LongMapUtils$.MODULE$.bin(l, l2, longMap, longMap2);
    }

    public static <T> LongMap<T> join(long l, LongMap<T> longMap, long l2, LongMap<T> longMap2) {
        return LongMapUtils$.MODULE$.join(l, longMap, l2, longMap2);
    }

    public static long branchMask(long l, long l2) {
        return LongMapUtils$.MODULE$.branchMask(l, l2);
    }

    public static long highestOneBit(long l) {
        return LongMapUtils$.MODULE$.highestOneBit(l);
    }

    public static String bitString$default$2() {
        return LongMapUtils$.MODULE$.bitString$default$2();
    }

    public static String bitString(long l, String string) {
        return LongMapUtils$.MODULE$.bitString(l, string);
    }

    public static IndexedSeq<Object> bits(long l) {
        return LongMapUtils$.MODULE$.bits(l);
    }

    public static long complement(long l) {
        return LongMapUtils$.MODULE$.complement(l);
    }

    public static boolean shorter(long l, long l2) {
        return LongMapUtils$.MODULE$.shorter(l, l2);
    }

    public static boolean unsignedCompare(long l, long l2) {
        return LongMapUtils$.MODULE$.unsignedCompare(l, l2);
    }

    public static boolean hasMatch(long l, long l2, long l3) {
        return LongMapUtils$.MODULE$.hasMatch(l, l2, l3);
    }

    public static long mask(long l, long l2) {
        return LongMapUtils$.MODULE$.mask(l, l2);
    }

    public static boolean zero(long l, long l2) {
        return LongMapUtils$.MODULE$.zero(l, l2);
    }
}

