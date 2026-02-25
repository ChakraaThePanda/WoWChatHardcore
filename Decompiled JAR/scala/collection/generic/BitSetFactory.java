/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.Function2;
import scala.Serializable;
import scala.collection.BitSet;
import scala.collection.BitSetLike;
import scala.collection.Seq;
import scala.collection.generic.CanBuildFrom;
import scala.collection.mutable.Builder;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001\u001d3qAB\u0004\u0011\u0002\u0007\u0005a\u0002C\u0003\u0015\u0001\u0011\u0005Q\u0003C\u0003\u001a\u0001\u0019\u0005!\u0004C\u0003.\u0001\u0019\u0005a\u0006C\u00039\u0001\u0011\u0005\u0011\bC\u0003@\u0001\u0011\u0005\u0001IA\u0007CSR\u001cV\r\u001e$bGR|'/\u001f\u0006\u0003\u0011%\tqaZ3oKJL7M\u0003\u0002\u000b\u0017\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u00031\tQa]2bY\u0006\u001c\u0001!\u0006\u0002\u0010;M\u0011\u0001\u0001\u0005\t\u0003#Ii\u0011aC\u0005\u0003'-\u0011a!\u00118z%\u00164\u0017A\u0002\u0013j]&$H\u0005F\u0001\u0017!\t\tr#\u0003\u0002\u0019\u0017\t!QK\\5u\u0003\u0015)W\u000e\u001d;z+\u0005Y\u0002C\u0001\u000f\u001e\u0019\u0001!QA\b\u0001C\u0002}\u0011AaQ8mYF\u0011\u0001e\t\t\u0003#\u0005J!AI\u0006\u0003\u000f9{G\u000f[5oOJ\u0019AE\n\u0016\u0007\t\u0015\u0002\u0001a\t\u0002\ryI,g-\u001b8f[\u0016tGO\u0010\t\u0003O!j\u0011!C\u0005\u0003S%\u0011aAQ5u'\u0016$\bcA\u0014,7%\u0011A&\u0003\u0002\u000b\u0005&$8+\u001a;MS.,\u0017A\u00038fo\n+\u0018\u000e\u001c3feV\tq\u0006\u0005\u00031gUZR\"A\u0019\u000b\u0005IJ\u0011aB7vi\u0006\u0014G.Z\u0005\u0003iE\u0012qAQ;jY\u0012,'\u000f\u0005\u0002\u0012m%\u0011qg\u0003\u0002\u0004\u0013:$\u0018!B1qa2LHCA\u000e;\u0011\u0015YD\u00011\u0001=\u0003\u0015)G.Z7t!\r\tR(N\u0005\u0003}-\u0011!\u0002\u0010:fa\u0016\fG/\u001a3?\u0003I\u0011\u0017\u000e^:fi\u000e\u000bgNQ;jY\u00124%o\\7\u0016\u0003\u0005\u00132A\u0011\tD\r\u0011)S\u0001A!\u0011\u000b\u0011+5$N\u000e\u000e\u0003\u001dI!AR\u0004\u0003\u0019\r\u000bgNQ;jY\u00124%o\\7")
public interface BitSetFactory<Coll extends BitSet & BitSetLike<Coll>> {
    public Coll empty();

    public Builder<Object, Coll> newBuilder();

    public static /* synthetic */ BitSet apply$(BitSetFactory $this, Seq elems) {
        return $this.apply(elems);
    }

    default public Coll apply(Seq<Object> elems) {
        Coll Coll = this.empty();
        return (Coll)((BitSet)elems.$div$colon(Coll, (Function2<BitSet, Object, BitSet> & java.io.Serializable & Serializable)(x$2, x$3) -> BitSetFactory.$anonfun$apply$1(x$2, BoxesRunTime.unboxToInt(x$3))));
    }

    public static /* synthetic */ CanBuildFrom bitsetCanBuildFrom$(BitSetFactory $this) {
        return $this.bitsetCanBuildFrom();
    }

    default public CanBuildFrom<Coll, Object, Coll> bitsetCanBuildFrom() {
        return new CanBuildFrom<Coll, Object, Coll>(this){
            private final /* synthetic */ BitSetFactory $outer;

            public Builder<Object, Coll> apply(Coll from) {
                return this.$outer.newBuilder();
            }

            public Builder<Object, Coll> apply() {
                return this.$outer.newBuilder();
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
            }
        };
    }

    public static /* synthetic */ BitSet $anonfun$apply$1(BitSet x$2, int x$3) {
        return (BitSet)x$2.$plus(BoxesRunTime.boxToInteger(x$3));
    }

    public static void $init$(BitSetFactory $this) {
    }
}

