/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.Function1;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.immutable.Map;
import scala.collection.immutable.Map$;
import scala.collection.mutable.Builder;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001i2q\u0001B\u0003\u0011\u0002\u0007\u0005A\u0002C\u0003%\u0001\u0011\u0005Q\u0005C\u0003*\u0001\u0011\u0005#\u0006C\u00037\u0001\u0011\u0005sG\u0001\u0006EK\u001a\fW\u000f\u001c;NCBT!AB\u0004\u0002\u0013%lW.\u001e;bE2,'B\u0001\u0005\n\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002\u0015\u0005)1oY1mC\u000e\u0001QcA\u0007\u0019EM\u0019\u0001A\u0004\n\u0011\u0005=\u0001R\"A\u0005\n\u0005EI!AB!osJ+g\r\u0005\u0003\u0014)Y\tS\"A\u0003\n\u0005U)!aA'baB\u0011q\u0003\u0007\u0007\u0001\t\u0015I\u0002A1\u0001\u001b\u0005\u0005\t\u0015CA\u000e\u001f!\tyA$\u0003\u0002\u001e\u0013\t9aj\u001c;iS:<\u0007CA\b \u0013\t\u0001\u0013BA\u0002B]f\u0004\"a\u0006\u0012\u0005\r\r\u0002AQ1\u0001\u001b\u0005\u0005\u0011\u0015A\u0002\u0013j]&$H\u0005F\u0001'!\tyq%\u0003\u0002)\u0013\t!QK\\5u\u0003\u0015!\u0003\u000f\\;t+\tYc\u0006\u0006\u0002-cA!1\u0003\u0006\f.!\t9b\u0006B\u00030\u0005\t\u0007\u0001G\u0001\u0002CcE\u0011\u0011E\b\u0005\u0006e\t\u0001\raM\u0001\u0003WZ\u0004Ba\u0004\u001b\u0017[%\u0011Q'\u0003\u0002\u0007)V\u0004H.\u001a\u001a\u0002\r\u0011j\u0017N\\;t)\t\u0011\u0002\bC\u0003:\u0007\u0001\u0007a#A\u0002lKf\u0004")
public interface DefaultMap<A, B>
extends Map<A, B> {
    public static /* synthetic */ Map $plus$(DefaultMap $this, Tuple2 kv) {
        return $this.$plus(kv);
    }

    @Override
    default public <B1> Map<A, B1> $plus(Tuple2<A, B1> kv) {
        Builder b = Map$.MODULE$.newBuilder();
        b.$plus$plus$eq(this);
        b.$plus$eq(new Tuple2<A, B1>(kv._1(), kv._2()));
        return b.result();
    }

    public static /* synthetic */ Map $minus$(DefaultMap $this, Object key) {
        return $this.$minus((A)key);
    }

    @Override
    default public Map<A, B> $minus(A key) {
        Builder b = this.newBuilder();
        this.withFilter((Function1<Tuple2, Object> & java.io.Serializable & Serializable)kv -> BoxesRunTime.boxToBoolean(DefaultMap.$anonfun$$minus$1(key, kv))).foreach((Function1<Tuple2, Builder> & java.io.Serializable & Serializable)kv -> b.$plus$eq(kv));
        return (Map)b.result();
    }

    public static /* synthetic */ boolean $anonfun$$minus$1(Object key$1, Tuple2 kv) {
        return !BoxesRunTime.equals(kv._1(), key$1);
    }

    public static void $init$(DefaultMap $this) {
    }
}

