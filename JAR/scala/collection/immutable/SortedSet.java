/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.collection.Iterator;
import scala.collection.generic.CanBuildFrom;
import scala.collection.immutable.Set;
import scala.collection.immutable.SortedSet$;
import scala.math.Ordering;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001\u00055aa\u0002\u0007\u000e!\u0003\r\t\u0001\u0006\u0005\u0006a\u0001!\t!\r\u0005\u0006k\u0001!\tE\u000e\u0005\u0006o\u0001!\t\u0005\u000f\u0005\f}\u0001\u0001\n1!A\u0001\n\u0013y\u0014iB\u0003E\u001b!\u0005QIB\u0003\r\u001b!\u0005a\tC\u0003O\r\u0011\u0005q\nC\u0003Q\r\u0011\u0005\u0011\u000bC\u00036\r\u0011\u0005\u0001\u000eC\u0003p\r\u0011\u0005\u0003\u000fC\u0003~\r\u0011\rcPA\u0005T_J$X\rZ*fi*\u0011abD\u0001\nS6lW\u000f^1cY\u0016T!\u0001E\t\u0002\u0015\r|G\u000e\\3di&|gNC\u0001\u0013\u0003\u0015\u00198-\u00197b\u0007\u0001)\"!\u0006\u0011\u0014\u000b\u00011\"$\u000b\u0017\u0011\u0005]AR\"A\t\n\u0005e\t\"AB!osJ+g\rE\u0002\u001c9yi\u0011!D\u0005\u0003;5\u00111aU3u!\ty\u0002\u0005\u0004\u0001\u0005\u000b\u0005\u0002!\u0019\u0001\u0012\u0003\u0003\u0005\u000b\"a\t\u0014\u0011\u0005]!\u0013BA\u0013\u0012\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"aF\u0014\n\u0005!\n\"aA!osB\u0019!f\u000b\u0010\u000e\u0003=I!\u0001D\b\u0011\t)jcdL\u0005\u0003]=\u0011QbU8si\u0016$7+\u001a;MS.,\u0007cA\u000e\u0001=\u00051A%\u001b8ji\u0012\"\u0012A\r\t\u0003/MJ!\u0001N\t\u0003\tUs\u0017\u000e^\u0001\u0006K6\u0004H/_\u000b\u0002_\u00051Q-];bYN$\"!\u000f\u001f\u0011\u0005]Q\u0014BA\u001e\u0012\u0005\u001d\u0011un\u001c7fC:DQ!P\u0002A\u0002\u0019\nA\u0001\u001e5bi\u0006a1/\u001e9fe\u0012*\u0017/^1mgR\u0011\u0011\b\u0011\u0005\u0006{\u0011\u0001\rAJ\u0005\u0003o\tK!aQ\b\u0003\u0015\u001d+gnU3u\u0019&\\W-A\u0005T_J$X\rZ*fiB\u00111DB\n\u0003\r\u001d\u00032\u0001S&N\u001b\u0005I%B\u0001&\u0010\u0003\u001d9WM\\3sS\u000eL!\u0001T%\u00033%kW.\u001e;bE2,7k\u001c:uK\u0012\u001cV\r\u001e$bGR|'/\u001f\t\u00037\u0001\ta\u0001P5oSRtD#A#\u0002\u0019\r\fgNQ;jY\u00124%o\\7\u0016\u0005IkFCA*`!\u0015AEK\u0016/_\u0013\t)\u0016J\u0001\u0007DC:\u0014U/\u001b7e\rJ|W\u000e\u0005\u0002X16\ta!\u0003\u0002Z5\n!1i\u001c7m\u0013\tY\u0016J\u0001\tT_J$X\rZ*fi\u001a\u000b7\r^8ssB\u0011q$\u0018\u0003\u0006C!\u0011\rA\t\t\u00047\u0001a\u0006\"\u00021\t\u0001\b\t\u0017aA8sIB\u0019!-\u001a/\u000f\u0005]\u0019\u0017B\u00013\u0012\u0003\u001d\u0001\u0018mY6bO\u0016L!AZ4\u0003\u0011=\u0013H-\u001a:j]\u001eT!\u0001Z\t\u0016\u0005%dGC\u00016n!\rY\u0002a\u001b\t\u0003?1$Q!I\u0005C\u0002\tBQ\u0001Y\u0005A\u00049\u00042AY3l\u0003)qWm\u001e\"vS2$WM]\u000b\u0003cf$\"A]>\u0011\tM4\bP_\u0007\u0002i*\u0011QoD\u0001\b[V$\u0018M\u00197f\u0013\t9HOA\u0004Ck&dG-\u001a:\u0011\u0005}IH!B\u0011\u000b\u0005\u0004\u0011\u0003cA\u000e\u0001q\")\u0001M\u0003a\u0002yB\u0019!-\u001a=\u0002\u001f9,woQ1o\u0005VLG\u000e\u001a$s_6,2a`A\u0003)\u0011\t\t!!\u0003\u0011\u000f!#f+a\u0001\u0002\bA\u0019q$!\u0002\u0005\u000b\u0005Z!\u0019\u0001\u0012\u0011\tm\u0001\u00111\u0001\u0005\u0007A.\u0001\u001d!a\u0003\u0011\t\t,\u00171\u0001")
public interface SortedSet<A>
extends Set<A>,
scala.collection.SortedSet<A> {
    public static <A> CanBuildFrom<SortedSet<?>, A, SortedSet<A>> newCanBuildFrom(Ordering<A> ordering) {
        return SortedSet$.MODULE$.newCanBuildFrom(ordering);
    }

    public static <A> CanBuildFrom<SortedSet<?>, A, SortedSet<A>> canBuildFrom(Ordering<A> ordering) {
        return SortedSet$.MODULE$.canBuildFrom(ordering);
    }

    public /* synthetic */ boolean scala$collection$immutable$SortedSet$$super$equals(Object var1);

    public static /* synthetic */ SortedSet empty$(SortedSet $this) {
        return $this.empty();
    }

    @Override
    default public SortedSet<A> empty() {
        return SortedSet$.MODULE$.empty(this.ordering());
    }

    public static /* synthetic */ boolean equals$(SortedSet $this, Object that) {
        return $this.equals(that);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    default public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (!(that instanceof SortedSet)) return this.scala$collection$immutable$SortedSet$$super$equals(that);
        SortedSet sortedSet = (SortedSet)that;
        Ordering ordering = sortedSet.ordering();
        Ordering ordering2 = this.ordering();
        if (ordering == null) {
            if (ordering2 != null) {
                return this.scala$collection$immutable$SortedSet$$super$equals(that);
            }
        } else if (!ordering.equals(ordering2)) return this.scala$collection$immutable$SortedSet$$super$equals(that);
        if (!sortedSet.canEqual(this)) return false;
        if (this.size() != sortedSet.size()) return false;
        Iterator i1 = this.iterator();
        Iterator i2 = sortedSet.iterator();
        boolean allEqual = true;
        while (allEqual && i1.hasNext()) {
            if (!BoxesRunTime.equals(i1.next(), i2.next())) return false;
            boolean bl = true;
            allEqual = bl;
        }
        if (!allEqual) return false;
        return true;
    }

    public static void $init$(SortedSet $this) {
    }
}

