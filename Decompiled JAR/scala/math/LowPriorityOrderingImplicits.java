/*
 * Decompiled with CFR 0.152.
 */
package scala.math;

import java.util.Comparator;
import scala.Function1;
import scala.Some;
import scala.math.Ordering;
import scala.math.PartialOrdering;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u00053q\u0001B\u0003\u0011\u0002\u0007\u0005!\u0002C\u0003\u0010\u0001\u0011\u0005\u0001\u0003C\u0003\u0015\u0001\u0011\rQ\u0003C\u00034\u0001\u0011\rAG\u0001\u000fM_^\u0004&/[8sSRLxJ\u001d3fe&tw-S7qY&\u001c\u0017\u000e^:\u000b\u0005\u00199\u0011\u0001B7bi\"T\u0011\u0001C\u0001\u0006g\u000e\fG.Y\u0002\u0001'\t\u00011\u0002\u0005\u0002\r\u001b5\tq!\u0003\u0002\u000f\u000f\t1\u0011I\\=SK\u001a\fa\u0001J5oSR$C#A\t\u0011\u00051\u0011\u0012BA\n\b\u0005\u0011)f.\u001b;\u0002\u000f=\u0014H-\u001a:fIV\u0011a#\b\u000b\u0003/\u0019\u00022\u0001G\r\u001c\u001b\u0005)\u0011B\u0001\u000e\u0006\u0005!y%\u000fZ3sS:<\u0007C\u0001\u000f\u001e\u0019\u0001!QA\b\u0002C\u0002}\u0011\u0011!Q\t\u0003A\r\u0002\"\u0001D\u0011\n\u0005\t:!a\u0002(pi\"Lgn\u001a\t\u0003\u0019\u0011J!!J\u0004\u0003\u0007\u0005s\u0017\u0010C\u0004(\u0005\u0005\u0005\t9\u0001\u0015\u0002\u0015\u00154\u0018\u000eZ3oG\u0016$\u0013\u0007\u0005\u0003\rSmY\u0013B\u0001\u0016\b\u0005%1UO\\2uS>t\u0017\u0007E\u0002-cmi\u0011!\f\u0006\u0003]=\nA\u0001\\1oO*\t\u0001'\u0001\u0003kCZ\f\u0017B\u0001\u001a.\u0005)\u0019u.\u001c9be\u0006\u0014G.Z\u0001\u0015G>l\u0007/\u0019:bi>\u0014Hk\\(sI\u0016\u0014\u0018N\\4\u0016\u0005UBDC\u0001\u001c:!\rA\u0012d\u000e\t\u00039a\"QAH\u0002C\u0002}AQAO\u0002A\u0004m\n1aY7q!\rathN\u0007\u0002{)\u0011ahL\u0001\u0005kRLG.\u0003\u0002A{\tQ1i\\7qCJ\fGo\u001c:")
public interface LowPriorityOrderingImplicits {
    public static /* synthetic */ Ordering ordered$(LowPriorityOrderingImplicits $this, Function1 evidence$1) {
        return $this.ordered(evidence$1);
    }

    default public <A> Ordering<A> ordered(Function1<A, Comparable<A>> evidence$1) {
        return new Ordering<A>(null, evidence$1){
            private final Function1 evidence$1$1;

            public Some<Object> tryCompare(A x, A y) {
                return Ordering.tryCompare$(this, x, y);
            }

            public boolean lteq(A x, A y) {
                return Ordering.lteq$(this, x, y);
            }

            public boolean gteq(A x, A y) {
                return Ordering.gteq$(this, x, y);
            }

            public boolean lt(A x, A y) {
                return Ordering.lt$(this, x, y);
            }

            public boolean gt(A x, A y) {
                return Ordering.gt$(this, x, y);
            }

            public boolean equiv(A x, A y) {
                return Ordering.equiv$(this, x, y);
            }

            public A max(A x, A y) {
                return (A)Ordering.max$(this, x, y);
            }

            public A min(A x, A y) {
                return (A)Ordering.min$(this, x, y);
            }

            public Ordering<A> reverse() {
                return Ordering.reverse$(this);
            }

            public <U> Ordering<U> on(Function1<U, A> f) {
                return Ordering.on$(this, f);
            }

            public Ordering.Ops mkOrderingOps(A lhs) {
                return Ordering.mkOrderingOps$(this, lhs);
            }

            public int compare(A x, A y) {
                return ((Comparable)this.evidence$1$1.apply(x)).compareTo(y);
            }
            {
                this.evidence$1$1 = evidence$1$1;
                PartialOrdering.$init$(this);
                Ordering.$init$(this);
            }
        };
    }

    public static /* synthetic */ Ordering comparatorToOrdering$(LowPriorityOrderingImplicits $this, Comparator cmp) {
        return $this.comparatorToOrdering(cmp);
    }

    default public <A> Ordering<A> comparatorToOrdering(Comparator<A> cmp) {
        return new Ordering<A>(null, cmp){
            private final Comparator cmp$1;

            public Some<Object> tryCompare(A x, A y) {
                return Ordering.tryCompare$(this, x, y);
            }

            public boolean lteq(A x, A y) {
                return Ordering.lteq$(this, x, y);
            }

            public boolean gteq(A x, A y) {
                return Ordering.gteq$(this, x, y);
            }

            public boolean lt(A x, A y) {
                return Ordering.lt$(this, x, y);
            }

            public boolean gt(A x, A y) {
                return Ordering.gt$(this, x, y);
            }

            public boolean equiv(A x, A y) {
                return Ordering.equiv$(this, x, y);
            }

            public A max(A x, A y) {
                return (A)Ordering.max$(this, x, y);
            }

            public A min(A x, A y) {
                return (A)Ordering.min$(this, x, y);
            }

            public Ordering<A> reverse() {
                return Ordering.reverse$(this);
            }

            public <U> Ordering<U> on(Function1<U, A> f) {
                return Ordering.on$(this, f);
            }

            public Ordering.Ops mkOrderingOps(A lhs) {
                return Ordering.mkOrderingOps$(this, lhs);
            }

            public int compare(A x, A y) {
                return this.cmp$1.compare(x, y);
            }
            {
                this.cmp$1 = cmp$1;
                PartialOrdering.$init$(this);
                Ordering.$init$(this);
            }
        };
    }

    public static void $init$(LowPriorityOrderingImplicits $this) {
    }
}

