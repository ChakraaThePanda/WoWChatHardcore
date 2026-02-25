/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.collection.Set;
import scala.collection.SortedSet$;
import scala.collection.SortedSetLike;
import scala.collection.generic.CanBuildFrom;
import scala.math.Ordering;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u00154q!\u0003\u0006\u0011\u0002\u0007\u0005q\u0002C\u0003)\u0001\u0011\u0005\u0011\u0006C\u0003.\u0001\u0011\u0005cfB\u00030\u0015!\u0005\u0001GB\u0003\n\u0015!\u0005\u0011\u0007C\u0003:\t\u0011\u0005!\bC\u0003.\t\u0011\u00051\bC\u0003N\t\u0011\u0005a\nC\u0003]\t\u0011\rSLA\u0005T_J$X\rZ*fi*\u00111\u0002D\u0001\u000bG>dG.Z2uS>t'\"A\u0007\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0011\u0001cG\n\u0005\u0001E)B\u0005\u0005\u0002\u0013'5\tA\"\u0003\u0002\u0015\u0019\t1\u0011I\\=SK\u001a\u00042AF\f\u001a\u001b\u0005Q\u0011B\u0001\r\u000b\u0005\r\u0019V\r\u001e\t\u00035ma\u0001\u0001B\u0003\u001d\u0001\t\u0007QDA\u0001B#\tq\u0012\u0005\u0005\u0002\u0013?%\u0011\u0001\u0005\u0004\u0002\b\u001d>$\b.\u001b8h!\t\u0011\"%\u0003\u0002$\u0019\t\u0019\u0011I\\=\u0011\tY)\u0013dJ\u0005\u0003M)\u0011QbU8si\u0016$7+\u001a;MS.,\u0007c\u0001\f\u00013\u00051A%\u001b8ji\u0012\"\u0012A\u000b\t\u0003%-J!\u0001\f\u0007\u0003\tUs\u0017\u000e^\u0001\u0006K6\u0004H/_\u000b\u0002O\u0005I1k\u001c:uK\u0012\u001cV\r\u001e\t\u0003-\u0011\u0019\"\u0001\u0002\u001a\u0011\u0007M2\u0004(D\u00015\u0015\t)$\"A\u0004hK:,'/[2\n\u0005]\"$\u0001E*peR,GmU3u\r\u0006\u001cGo\u001c:z!\t1\u0002!\u0001\u0004=S:LGO\u0010\u000b\u0002aU\u0011Ah\u0011\u000b\u0003{\u0011\u00032AP!C\u001b\u0005y$B\u0001!\u000b\u0003%IW.\\;uC\ndW-\u0003\u0002\n\u007fA\u0011!d\u0011\u0003\u00069\u0019\u0011\r!\b\u0005\u0006\u000b\u001a\u0001\u001dAR\u0001\u0004_J$\u0007cA$K\u0005:\u0011!\u0003S\u0005\u0003\u00132\tq\u0001]1dW\u0006<W-\u0003\u0002L\u0019\nAqJ\u001d3fe&twM\u0003\u0002J\u0019\u0005a1-\u00198Ck&dGM\u0012:p[V\u0011q\n\u0017\u000b\u0003!j\u0003RaM)T/fK!A\u0015\u001b\u0003\u0019\r\u000bgNQ;jY\u00124%o\\7\u0011\u0005Q+V\"\u0001\u0003\n\u0005Y3$\u0001B\"pY2\u0004\"A\u0007-\u0005\u000bq9!\u0019A\u000f\u0011\u0007Y\u0001q\u000bC\u0003F\u000f\u0001\u000f1\fE\u0002H\u0015^\u000bqB\\3x\u0007\u0006t')^5mI\u001a\u0013x.\\\u000b\u0003=\u0006$\"aX2\u0011\u000bM\n6\u000b\u00192\u0011\u0005i\tG!\u0002\u000f\t\u0005\u0004i\u0002c\u0001\f\u0001A\")Q\t\u0003a\u0002IB\u0019qI\u00131")
public interface SortedSet<A>
extends Set<A>,
SortedSetLike<A, SortedSet<A>> {
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

