/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.Tuple2;
import scala.collection.Seq;
import scala.collection.SortedMap;
import scala.collection.generic.CanBuildFrom;
import scala.collection.mutable.Builder;
import scala.collection.mutable.MapBuilder;
import scala.math.Ordering;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005=b!B\u0007\u000f\u0003\u0003)\u0002\"B\u000e\u0001\t\u0003aR\u0001B\u001f\u0001\u0001yBQA\u0012\u0001\u0007\u0002\u001dCQa\u0016\u0001\u0005\u0002aCQA\u001b\u0001\u0005\u0002-4Aa\u001f\u0001\u0001y\"IqJ\u0002B\u0001B\u0003-\u00111\u0003\u0005\u00077\u0019!\t!!\u0006\t\u0011\u0005ua\u0001\"\u0001\u0011\u0003?A\u0001\"!\t\u0007\t\u0003\u0001\u00121\u0005\u0005\u0007/\u001a!\t!!\n\t\r]3A\u0011AA\u0017\u0005A\u0019vN\u001d;fI6\u000b\u0007OR1di>\u0014\u0018P\u0003\u0002\u0010!\u00059q-\u001a8fe&\u001c'BA\t\u0013\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002'\u0005)1oY1mC\u000e\u0001QC\u0001\f\"'\t\u0001q\u0003\u0005\u0002\u001935\t!#\u0003\u0002\u001b%\t1\u0011I\\=SK\u001a\fa\u0001P5oSRtD#A\u000f\u0011\u0007y\u0001q$D\u0001\u000f!\t\u0001\u0013\u0005\u0004\u0001\u0005\u000b\t\u0002!\u0019A\u0012\u0003\u0005\r\u001bUc\u0001\u00131oE\u0011Q\u0005\u000b\t\u00031\u0019J!a\n\n\u0003\u000f9{G\u000f[5oOJ\u0019\u0011fK\u001d\u0007\t)\u0002\u0001\u0001\u000b\u0002\ryI,g-\u001b8f[\u0016tGO\u0010\t\u0005Y5zc'D\u0001\u0011\u0013\tq\u0003CA\u0005T_J$X\rZ'baB\u0011\u0001\u0005\r\u0003\u0006c\u0005\u0012\rA\r\u0002\u0002\u0003F\u0011Qe\r\t\u00031QJ!!\u000e\n\u0003\u0007\u0005s\u0017\u0010\u0005\u0002!o\u0011)\u0001(\tb\u0001e\t\t!\tE\u0003-u=2D(\u0003\u0002<!\ti1k\u001c:uK\u0012l\u0015\r\u001d'jW\u0016\u0004B\u0001I\u00110m\t!1i\u001c7ma\ry\u0014\t\u0012\t\u0005A\u0005\u00025\t\u0005\u0002!\u0003\u0012I!IAA\u0001\u0002\u0003\u0015\tA\r\u0002\u0004?\u0012\n\u0004C\u0001\u0011E\t%)%!!A\u0001\u0002\u000b\u0005!GA\u0002`II\nQ!Z7qif,2\u0001S&N)\tIe\n\u0005\u0003!C)c\u0005C\u0001\u0011L\t\u0015\t4A1\u00013!\t\u0001S\nB\u00039\u0007\t\u0007!\u0007C\u0003P\u0007\u0001\u000f\u0001+A\u0002pe\u0012\u00042!\u0015+K\u001d\tA\"+\u0003\u0002T%\u00059\u0001/Y2lC\u001e,\u0017BA+W\u0005!y%\u000fZ3sS:<'BA*\u0013\u0003\u0015\t\u0007\u000f\u001d7z+\rIVl\u0018\u000b\u00035\n$\"a\u00171\u0011\t\u0001\nCL\u0018\t\u0003Au#Q!\r\u0003C\u0002I\u0002\"\u0001I0\u0005\u000ba\"!\u0019\u0001\u001a\t\u000b=#\u00019A1\u0011\u0007E#F\fC\u0003d\t\u0001\u0007A-A\u0003fY\u0016l7\u000fE\u0002\u0019K\u001eL!A\u001a\n\u0003\u0015q\u0012X\r]3bi\u0016$g\b\u0005\u0003\u0019Qrs\u0016BA5\u0013\u0005\u0019!V\u000f\u001d7fe\u0005Qa.Z<Ck&dG-\u001a:\u0016\u00071,x\u000f\u0006\u0002nsB!a.]:y\u001b\u0005y'B\u00019\u0011\u0003\u001diW\u000f^1cY\u0016L!A]8\u0003\u000f\t+\u0018\u000e\u001c3feB!\u0001\u0004\u001b;w!\t\u0001S\u000fB\u00032\u000b\t\u0007!\u0007\u0005\u0002!o\u0012)\u0001(\u0002b\u0001eA!\u0001%\t;w\u0011\u0015yU\u0001q\u0001{!\r\tF\u000b\u001e\u0002\u0016'>\u0014H/\u001a3NCB\u001c\u0015M\u001c\"vS2$gI]8n+\u0015i\u00181BA\b'\r1qC \t\t=}\f\u0019!a\u0002\u0002\u0012%\u0019\u0011\u0011\u0001\b\u0003\u0019\r\u000bgNQ;jY\u00124%o\\7\u0011\u0007\u0005\u0015!!D\u0001\u0001!\u0019A\u0002.!\u0003\u0002\u000eA\u0019\u0001%a\u0003\u0005\u000bE2!\u0019\u0001\u001a\u0011\u0007\u0001\ny\u0001B\u00039\r\t\u0007!\u0007\u0005\u0004!C\u0005%\u0011Q\u0002\t\u0005#R\u000bI\u0001\u0006\u0002\u0002\u0018Q!\u0011\u0011DA\u000e!\u001d\t)ABA\u0005\u0003\u001bAaa\u0014\u0005A\u0004\u0005M\u0011a\u00024bGR|'/_\u000b\u0002;\u0005AqN\u001d3fe&tw-\u0006\u0002\u0002\u0014Q!\u0011qEA\u0015!\u0019q\u0017/a\u0002\u0002\u0012!9\u00111F\u0006A\u0002\u0005\r\u0011\u0001\u00024s_6$\"!a\n")
public abstract class SortedMapFactory<CC extends SortedMap<Object, Object>> {
    public abstract <A, B> CC empty(Ordering<A> var1);

    public <A, B> CC apply(Seq<Tuple2<A, B>> elems, Ordering<A> ord) {
        if (elems.isEmpty()) {
            return this.empty(ord);
        }
        return (CC)((SortedMap)((Builder)this.newBuilder(ord).$plus$plus$eq(elems)).result());
    }

    public <A, B> Builder<Tuple2<A, B>, CC> newBuilder(Ordering<A> ord) {
        return new MapBuilder(this.empty(ord));
    }

    public class SortedMapCanBuildFrom<A, B>
    implements CanBuildFrom<CC, Tuple2<A, B>, CC> {
        private final Ordering<A> ord;
        public final /* synthetic */ SortedMapFactory $outer;

        public SortedMapFactory<CC> factory() {
            return this.scala$collection$generic$SortedMapFactory$SortedMapCanBuildFrom$$$outer();
        }

        public Ordering<A> ordering() {
            return this.ord;
        }

        @Override
        public Builder<Tuple2<A, B>, CC> apply(CC from) {
            return this.scala$collection$generic$SortedMapFactory$SortedMapCanBuildFrom$$$outer().newBuilder(this.ord);
        }

        @Override
        public Builder<Tuple2<A, B>, CC> apply() {
            return this.scala$collection$generic$SortedMapFactory$SortedMapCanBuildFrom$$$outer().newBuilder(this.ord);
        }

        public /* synthetic */ SortedMapFactory scala$collection$generic$SortedMapFactory$SortedMapCanBuildFrom$$$outer() {
            return this.$outer;
        }

        public SortedMapCanBuildFrom(SortedMapFactory $outer, Ordering<A> ord) {
            this.ord = ord;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }
}

