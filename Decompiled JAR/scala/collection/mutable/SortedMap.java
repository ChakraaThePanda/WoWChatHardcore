/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Tuple2;
import scala.collection.GenTraversableOnce;
import scala.collection.Seq;
import scala.collection.generic.CanBuildFrom;
import scala.collection.mutable.Builder;
import scala.collection.mutable.Map;
import scala.collection.mutable.SortedMap$;
import scala.math.Ordering;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u00055caB\u0007\u000f!\u0003\r\t!\u0006\u0005\u0006o\u0001!\t\u0001\u000f\u0005\u0007y\u0001\u0001K\u0011K\u001f\t\u000b\u0011\u0003A\u0011I#\t\u000b\u0019\u0003A\u0011I$\t\u000bI\u0003A\u0011I*\t\u000bI\u0003A\u0011I.\t\u000b)\u0004A\u0011I6\b\u000bYt\u0001\u0012A<\u0007\u000b5q\u0001\u0012\u0001=\t\u000f\u0005\u0005\u0011\u0002\"\u0001\u0002\u0004!1A)\u0003C\u0001\u0003\u000bAq!!\n\n\t\u0007\t9CA\u0005T_J$X\rZ'ba*\u0011q\u0002E\u0001\b[V$\u0018M\u00197f\u0015\t\t\"#\u0001\u0006d_2dWm\u0019;j_:T\u0011aE\u0001\u0006g\u000e\fG.Y\u0002\u0001+\r1\u0012eK\n\u0007\u0001]YR\u0006\r\u001b\u0011\u0005aIR\"\u0001\n\n\u0005i\u0011\"AB!osJ+g\r\u0005\u0003\u001d;}QS\"\u0001\b\n\u0005yq!aA'baB\u0011\u0001%\t\u0007\u0001\t\u0015\u0011\u0003A1\u0001$\u0005\u0005\t\u0015C\u0001\u0013(!\tAR%\u0003\u0002'%\t9aj\u001c;iS:<\u0007C\u0001\r)\u0013\tI#CA\u0002B]f\u0004\"\u0001I\u0016\u0005\u000b1\u0002!\u0019A\u0012\u0003\u0003\t\u0003BAL\u0018 U5\t\u0001#\u0003\u0002\u000e!A)A$M\u0010+g%\u0011!G\u0004\u0002\b\u001b\u0006\u0004H*[6f!\u0011a\u0002a\b\u0016\u0011\u000b9*tDK\u001a\n\u0005Y\u0002\"!D*peR,G-T1q\u0019&\\W-\u0001\u0004%S:LG\u000f\n\u000b\u0002sA\u0011\u0001DO\u0005\u0003wI\u0011A!\u00168ji\u0006Qa.Z<Ck&dG-\u001a:\u0016\u0003y\u0002B\u0001H Bg%\u0011\u0001I\u0004\u0002\b\u0005VLG\u000eZ3s!\u0011A\"i\b\u0016\n\u0005\r\u0013\"A\u0002+va2,''A\u0003f[B$\u00180F\u00014\u0003\u001d)\b\u000fZ1uK\u0012,\"\u0001S&\u0015\u0007%s\u0005\u000b\u0005\u0003\u001d\u0001}Q\u0005C\u0001\u0011L\t\u0015aEA1\u0001N\u0005\t\u0011\u0015'\u0005\u0002+O!)q\n\u0002a\u0001?\u0005\u00191.Z=\t\u000bE#\u0001\u0019\u0001&\u0002\u000bY\fG.^3\u0002\u000b\u0011\u0002H.^:\u0016\u0005Q;FCA+Y!\u0011a\u0002a\b,\u0011\u0005\u0001:F!\u0002'\u0006\u0005\u0004i\u0005\"B-\u0006\u0001\u0004Q\u0016AA6w!\u0011A\"i\b,\u0016\u0005q{F\u0003B/aG\u0016\u0004B\u0001\b\u0001 =B\u0011\u0001e\u0018\u0003\u0006\u0019\u001a\u0011\r!\u0014\u0005\u0006C\u001a\u0001\rAY\u0001\u0006K2,W.\r\t\u00051\t{b\fC\u0003e\r\u0001\u0007!-A\u0003fY\u0016l'\u0007C\u0003g\r\u0001\u0007q-A\u0003fY\u0016l7\u000fE\u0002\u0019Q\nL!!\u001b\n\u0003\u0015q\u0012X\r]3bi\u0016$g(\u0001\u0006%a2,8\u000f\n9mkN,\"\u0001\\8\u0015\u00055\u0004\b\u0003\u0002\u000f\u0001?9\u0004\"\u0001I8\u0005\u000b1;!\u0019A'\t\u000bE<\u0001\u0019\u0001:\u0002\u0005a\u001c\bc\u0001\u0018tk&\u0011A\u000f\u0005\u0002\u0013\u000f\u0016tGK]1wKJ\u001c\u0018M\u00197f\u001f:\u001cW\r\u0005\u0003\u0019\u0005~q\u0017!C*peR,G-T1q!\ta\u0012b\u0005\u0002\nsB\u0019!0`@\u000e\u0003mT!\u0001 \t\u0002\u000f\u001d,g.\u001a:jG&\u0011ap\u001f\u0002\u0018\u001bV$\u0018M\u00197f'>\u0014H/\u001a3NCB4\u0015m\u0019;pef\u0004\"\u0001\b\u0001\u0002\rqJg.\u001b;?)\u00059XCBA\u0004\u0003\u001b\t\t\u0002\u0006\u0003\u0002\n\u0005M\u0001C\u0002\u000f\u0001\u0003\u0017\ty\u0001E\u0002!\u0003\u001b!QAI\u0006C\u0002\r\u00022\u0001IA\t\t\u0015a3B1\u0001$\u0011\u001d\t)b\u0003a\u0002\u0003/\t1a\u001c:e!\u0019\tI\"a\b\u0002\f9\u0019\u0001$a\u0007\n\u0007\u0005u!#A\u0004qC\u000e\\\u0017mZ3\n\t\u0005\u0005\u00121\u0005\u0002\t\u001fJ$WM]5oO*\u0019\u0011Q\u0004\n\u0002\u0019\r\fgNQ;jY\u00124%o\\7\u0016\r\u0005%\u0012\u0011IA#)\u0011\tY#!\u0013\u0011\u0013i\fi#!\r\u0002>\u0005\u001d\u0013bAA\u0018w\na1)\u00198Ck&dGM\u0012:p[B!\u00111GA\u001b\u001b\u0005I\u0011\u0002BA\u001c\u0003s\u0011AaQ8mY&\u0019\u00111H>\u0003!M{'\u000f^3e\u001b\u0006\u0004h)Y2u_JL\bC\u0002\rC\u0003\u007f\t\u0019\u0005E\u0002!\u0003\u0003\"QA\t\u0007C\u0002\r\u00022\u0001IA#\t\u0015aCB1\u0001$!\u0019a\u0002!a\u0010\u0002D!9\u0011Q\u0003\u0007A\u0004\u0005-\u0003CBA\r\u0003?\ty\u0004")
public interface SortedMap<A, B>
extends Map<A, B>,
scala.collection.SortedMap<A, B> {
    public static <A, B> CanBuildFrom<SortedMap<?, ?>, Tuple2<A, B>, SortedMap<A, B>> canBuildFrom(Ordering<A> ordering) {
        return SortedMap$.MODULE$.canBuildFrom(ordering);
    }

    public static /* synthetic */ Builder newBuilder$(SortedMap $this) {
        return $this.newBuilder();
    }

    @Override
    default public Builder<Tuple2<A, B>, SortedMap<A, B>> newBuilder() {
        return SortedMap$.MODULE$.newBuilder(this.ordering());
    }

    public static /* synthetic */ SortedMap empty$(SortedMap $this) {
        return $this.empty();
    }

    @Override
    default public SortedMap<A, B> empty() {
        return SortedMap$.MODULE$.empty(this.ordering());
    }

    public static /* synthetic */ SortedMap updated$(SortedMap $this, Object key, Object value) {
        return $this.updated((A)key, (B1)value);
    }

    @Override
    default public <B1> SortedMap<A, B1> updated(A key, B1 value) {
        return this.$plus(new Tuple2<A, B1>(key, value));
    }

    public static /* synthetic */ SortedMap $plus$(SortedMap $this, Tuple2 kv) {
        return $this.$plus(kv);
    }

    @Override
    default public <B1> SortedMap<A, B1> $plus(Tuple2<A, B1> kv) {
        return (SortedMap)((SortedMap)this.clone()).$plus$eq(kv);
    }

    public static /* synthetic */ SortedMap $plus$(SortedMap $this, Tuple2 elem1, Tuple2 elem2, Seq elems) {
        return $this.$plus(elem1, elem2, elems);
    }

    @Override
    default public <B1> SortedMap<A, B1> $plus(Tuple2<A, B1> elem1, Tuple2<A, B1> elem2, Seq<Tuple2<A, B1>> elems) {
        return (SortedMap)((SortedMap)this.clone()).$plus$eq(elem1).$plus$eq(elem2).$plus$plus$eq(elems);
    }

    public static /* synthetic */ SortedMap $plus$plus$(SortedMap $this, GenTraversableOnce xs) {
        return $this.$plus$plus(xs);
    }

    @Override
    default public <B1> SortedMap<A, B1> $plus$plus(GenTraversableOnce<Tuple2<A, B1>> xs) {
        return (SortedMap)((SortedMap)this.clone()).$plus$plus$eq(xs.seq());
    }

    public static void $init$(SortedMap $this) {
    }
}

