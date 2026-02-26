/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.collection.generic.CanBuildFrom;
import scala.collection.mutable.Set;
import scala.collection.mutable.SortedSet$;
import scala.math.Ordering;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001-4q!\u0003\u0006\u0011\u0002\u0007\u0005\u0011\u0003C\u00031\u0001\u0011\u0005\u0011\u0007C\u00036\u0001\u0011\u0005cgB\u00038\u0015!\u0005\u0001HB\u0003\n\u0015!\u0005\u0011\bC\u0003B\t\u0011\u0005!\tC\u0003D\t\u0011\u0005A\tC\u00036\t\u0011\u00051\fC\u0003c\t\u0011\r3MA\u0005T_J$X\rZ*fi*\u00111\u0002D\u0001\b[V$\u0018M\u00197f\u0015\tia\"\u0001\u0006d_2dWm\u0019;j_:T\u0011aD\u0001\u0006g\u000e\fG.Y\u0002\u0001+\t\u0011Bd\u0005\u0004\u0001'])#&\f\t\u0003)Ui\u0011AD\u0005\u0003-9\u0011a!\u00118z%\u00164\u0007c\u0001\r\u001a55\tA\"\u0003\u0002\n\u0019A\u00111\u0004\b\u0007\u0001\t\u0015i\u0002A1\u0001\u001f\u0005\u0005\t\u0015CA\u0010#!\t!\u0002%\u0003\u0002\"\u001d\t9aj\u001c;iS:<\u0007C\u0001\u000b$\u0013\t!cBA\u0002B]f\u0004B\u0001\u0007\u0014\u001bQ%\u0011q\u0005\u0004\u0002\u000e'>\u0014H/\u001a3TKRd\u0015n[3\u0011\u0007%\u0002!$D\u0001\u000b!\rI3FG\u0005\u0003Y)\u00111aU3u!\u0011IcF\u0007\u0015\n\u0005=R!aB*fi2K7.Z\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0015\u0003I\u0002\"\u0001F\u001a\n\u0005Qr!\u0001B+oSR\fQ!Z7qif,\u0012\u0001K\u0001\n'>\u0014H/\u001a3TKR\u0004\"!\u000b\u0003\u0014\u0005\u0011Q\u0004cA\u001e?\u00016\tAH\u0003\u0002>\u0019\u00059q-\u001a8fe&\u001c\u0017BA =\u0005]iU\u000f^1cY\u0016\u001cvN\u001d;fIN+GOR1di>\u0014\u0018\u0010\u0005\u0002*\u0001\u00051A(\u001b8jiz\"\u0012\u0001O\u0001\rG\u0006t')^5mI\u001a\u0013x.\\\u000b\u0003\u000bB#\"A\u0012*\u0011\u000bm:\u0015jT)\n\u0005!c$\u0001D\"b]\n+\u0018\u000e\u001c3Ge>l\u0007C\u0001&L\u001b\u0005!\u0011B\u0001'N\u0005\u0011\u0019u\u000e\u001c7\n\u00059c$\u0001E*peR,GmU3u\r\u0006\u001cGo\u001c:z!\tY\u0002\u000bB\u0003\u001e\r\t\u0007a\u0004E\u0002*\u0001=CQa\u0015\u0004A\u0004Q\u000b1a\u001c:e!\r)\u0006l\u0014\b\u0003)YK!a\u0016\b\u0002\u000fA\f7m[1hK&\u0011\u0011L\u0017\u0002\t\u001fJ$WM]5oO*\u0011qKD\u000b\u00039~#\"!\u00181\u0011\u0007%\u0002a\f\u0005\u0002\u001c?\u0012)Qd\u0002b\u0001=!)1k\u0002a\u0002CB\u0019Q\u000b\u00170\u0002\u001f9,woQ1o\u0005VLG\u000e\u001a$s_6,\"\u0001Z4\u0015\u0005\u0015L\u0007#B\u001eH\u0013\u001aD\u0007CA\u000eh\t\u0015i\u0002B1\u0001\u001f!\rI\u0003A\u001a\u0005\u0006'\"\u0001\u001dA\u001b\t\u0004+b3\u0007")
public interface SortedSet<A>
extends scala.collection.SortedSet<A>,
Set<A> {
    public static <A> CanBuildFrom<SortedSet<?>, A, SortedSet<A>> newCanBuildFrom(Ordering<A> ordering) {
        return SortedSet$.MODULE$.newCanBuildFrom(ordering);
    }

    public static <A> CanBuildFrom<SortedSet<?>, A, SortedSet<A>> canBuildFrom(Ordering<A> ordering) {
        return SortedSet$.MODULE$.canBuildFrom(ordering);
    }

    public static /* synthetic */ SortedSet empty$(SortedSet $this) {
        return $this.empty();
    }

    @Override
    default public SortedSet<A> empty() {
        return SortedSet$.MODULE$.empty(this.ordering());
    }

    public static void $init$(SortedSet $this) {
    }
}

