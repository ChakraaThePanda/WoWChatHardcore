/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Function1;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.Map;
import scala.collection.SortedMapLike;
import scala.collection.generic.CanBuildFrom;
import scala.collection.immutable.SortedMap$;
import scala.collection.mutable.Builder;
import scala.math.Ordering;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001\u00055aaB\u0007\u000f!\u0003\r\ta\u0005\u0005\u0006_\u0001!\t\u0001\r\u0005\u0006i\u0001!\t%\u000e\u0005\u0007m\u0001\u0001K\u0011K\u001c\b\u000b\u0005s\u0001\u0012\u0001\"\u0007\u000b5q\u0001\u0012A\"\t\u000b-+A\u0011\u0001'\t\u000bQ*A\u0011A'\t\u000bu+A1\u00010\u0007\u0011=,\u0001\u0013aA\u0001\u001dADQaL\u0005\u0005\u0002ABQa^\u0005\u0005BaDq!!\u0002\n\t\u0003\n9AA\u0005T_J$X\rZ'ba*\u0011q\u0002E\u0001\u000bG>dG.Z2uS>t'\"A\t\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0019AcH\u0015\u0014\t\u0001)\u0012d\u000b\t\u0003-]i\u0011\u0001E\u0005\u00031A\u0011a!\u00118z%\u00164\u0007\u0003\u0002\u000e\u001c;!j\u0011AD\u0005\u000399\u00111!T1q!\tqr\u0004\u0004\u0001\u0005\u000b\u0001\u0002!\u0019A\u0011\u0003\u0003\u0005\u000b\"AI\u0013\u0011\u0005Y\u0019\u0013B\u0001\u0013\u0011\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"A\u0006\u0014\n\u0005\u001d\u0002\"aA!osB\u0011a$\u000b\u0003\u0007U\u0001!)\u0019A\u0011\u0003\u0003\t\u0003RA\u0007\u0017\u001eQ9J!!\f\b\u0003\u001bM{'\u000f^3e\u001b\u0006\u0004H*[6f!\u0011Q\u0002!\b\u0015\u0002\r\u0011Jg.\u001b;%)\u0005\t\u0004C\u0001\f3\u0013\t\u0019\u0004C\u0001\u0003V]&$\u0018!B3naRLX#\u0001\u0018\u0002\u00159,wOQ;jY\u0012,'/F\u00019!\u0011IDH\u0010\u0018\u000e\u0003iR!a\u000f\b\u0002\u000f5,H/\u00192mK&\u0011QH\u000f\u0002\b\u0005VLG\u000eZ3s!\u00111r(\b\u0015\n\u0005\u0001\u0003\"A\u0002+va2,''A\u0005T_J$X\rZ'baB\u0011!$B\n\u0003\u000b\u0011\u00032!\u0012%K\u001b\u00051%BA$\u000f\u0003\u001d9WM\\3sS\u000eL!!\u0013$\u0003!M{'\u000f^3e\u001b\u0006\u0004h)Y2u_JL\bC\u0001\u000e\u0001\u0003\u0019a\u0014N\\5u}Q\t!)F\u0002O#N#\"a\u0014+\u0011\ti\u0001\u0001K\u0015\t\u0003=E#Q\u0001I\u0004C\u0002\u0005\u0002\"AH*\u0005\u000b):!\u0019A\u0011\t\u000bU;\u00019\u0001,\u0002\u0007=\u0014H\rE\u0002X5Bs!A\u0006-\n\u0005e\u0003\u0012a\u00029bG.\fw-Z\u0005\u00037r\u0013\u0001b\u0014:eKJLgn\u001a\u0006\u00033B\tAbY1o\u0005VLG\u000e\u001a$s_6,2aX5l)\t\u0001W\u000eE\u0003FC\u000e<G.\u0003\u0002c\r\na1)\u00198Ck&dGM\u0012:p[B\u0011A-Z\u0007\u0002\u000b%\u0011a\r\u0013\u0002\u0005\u0007>dG\u000e\u0005\u0003\u0017\u007f!T\u0007C\u0001\u0010j\t\u0015\u0001\u0003B1\u0001\"!\tq2\u000eB\u0003+\u0011\t\u0007\u0011\u0005\u0005\u0003\u001b\u0001!T\u0007\"B+\t\u0001\bq\u0007cA,[Q\n9A)\u001a4bk2$XcA9umN\u0019\u0011\"\u0006:\u0011\ti\u00011/\u001e\t\u0003=Q$Q\u0001I\u0005C\u0002\u0005\u0002\"A\b<\u0005\r)JAQ1\u0001\"\u0003\u0015!\u0003\u000f\\;t+\tIH\u0010\u0006\u0002{\u007fB!!\u0004A:|!\tqB\u0010B\u0003~\u0017\t\u0007aP\u0001\u0002CcE\u0011Q/\n\u0005\b\u0003\u0003Y\u0001\u0019AA\u0002\u0003\tYg\u000f\u0005\u0003\u0017\u007fM\\\u0018A\u0002\u0013nS:,8\u000fF\u0002s\u0003\u0013Aa!a\u0003\r\u0001\u0004\u0019\u0018aA6fs\u0002")
public interface SortedMap<A, B>
extends Map<A, B>,
SortedMapLike<A, B, SortedMap<A, B>> {
    public static <A, B> CanBuildFrom<SortedMap<?, ?>, Tuple2<A, B>, SortedMap<A, B>> canBuildFrom(Ordering<A> ordering) {
        return scala.collection.SortedMap$.MODULE$.canBuildFrom(ordering);
    }

    public static /* synthetic */ SortedMap empty$(SortedMap $this) {
        return $this.empty();
    }

    @Override
    default public SortedMap<A, B> empty() {
        return scala.collection.SortedMap$.MODULE$.empty(this.ordering());
    }

    public static /* synthetic */ Builder newBuilder$(SortedMap $this) {
        return $this.newBuilder();
    }

    @Override
    default public Builder<Tuple2<A, B>, SortedMap<A, B>> newBuilder() {
        return SortedMap$.MODULE$.newBuilder(this.ordering());
    }

    public static void $init$(SortedMap $this) {
    }

    public static interface Default<A, B>
    extends SortedMap<A, B> {
        public static /* synthetic */ SortedMap $plus$(Default $this, Tuple2 kv) {
            return $this.$plus(kv);
        }

        @Override
        default public <B1> SortedMap<A, B1> $plus(Tuple2<A, B1> kv) {
            Builder b = scala.collection.SortedMap$.MODULE$.newBuilder(this.ordering());
            b.$plus$plus$eq(this);
            b.$plus$eq(new Tuple2<A, B1>(kv._1(), kv._2()));
            return (SortedMap)b.result();
        }

        public static /* synthetic */ SortedMap $minus$(Default $this, Object key) {
            return $this.$minus((A)key);
        }

        @Override
        default public SortedMap<A, B> $minus(A key) {
            Builder b = this.newBuilder();
            this.withFilter((Function1<Tuple2, Object> & java.io.Serializable & Serializable)kv -> BoxesRunTime.boxToBoolean(Default.$anonfun$$minus$1(key, kv))).foreach((Function1<Tuple2, Builder> & java.io.Serializable & Serializable)kv -> b.$plus$eq(kv));
            return b.result();
        }

        public static /* synthetic */ boolean $anonfun$$minus$1(Object key$1, Tuple2 kv) {
            return !BoxesRunTime.equals(kv._1(), key$1);
        }

        public static void $init$(Default $this) {
        }
    }
}

