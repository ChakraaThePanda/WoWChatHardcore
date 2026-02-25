/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Function1;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.Map;
import scala.collection.Map$;
import scala.collection.TraversableOnce;
import scala.collection.mutable.Builder;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001a2q\u0001B\u0003\u0011\u0002\u0007\u0005!\u0002C\u0003#\u0001\u0011\u00051\u0005C\u0003(\u0001\u0011\u0005\u0003\u0006C\u00035\u0001\u0011\u0005SG\u0001\u0006EK\u001a\fW\u000f\u001c;NCBT!AB\u0004\u0002\u0015\r|G\u000e\\3di&|gNC\u0001\t\u0003\u0015\u00198-\u00197b\u0007\u0001)2a\u0003\f!'\r\u0001A\u0002\u0005\t\u0003\u001b9i\u0011aB\u0005\u0003\u001f\u001d\u0011a!\u00118z%\u00164\u0007\u0003B\t\u0013)}i\u0011!B\u0005\u0003'\u0015\u00111!T1q!\t)b\u0003\u0004\u0001\u0005\u000b]\u0001!\u0019\u0001\r\u0003\u0003\u0005\u000b\"!\u0007\u000f\u0011\u00055Q\u0012BA\u000e\b\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"!D\u000f\n\u0005y9!aA!osB\u0011Q\u0003\t\u0003\u0007C\u0001!)\u0019\u0001\r\u0003\u0003\t\u000ba\u0001J5oSR$C#\u0001\u0013\u0011\u00055)\u0013B\u0001\u0014\b\u0005\u0011)f.\u001b;\u0002\u000b\u0011\u0002H.^:\u0016\u0005%bCC\u0001\u00160!\u0011\t\"\u0003F\u0016\u0011\u0005UaC!B\u0017\u0003\u0005\u0004q#A\u0001\"2#\tyB\u0004C\u00031\u0005\u0001\u0007\u0011'\u0001\u0002lmB!QB\r\u000b,\u0013\t\u0019tA\u0001\u0004UkBdWMM\u0001\u0007I5Lg.^:\u0015\u0005A1\u0004\"B\u001c\u0004\u0001\u0004!\u0012aA6fs\u0002")
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
        return (Map)b.result();
    }

    public static /* synthetic */ Map $minus$(DefaultMap $this, Object key) {
        return $this.$minus((A)key);
    }

    @Override
    default public Map<A, B> $minus(A key) {
        Builder b = this.newBuilder();
        b.$plus$plus$eq((TraversableOnce)this.filter((Function1<Tuple2, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToBoolean(DefaultMap.$anonfun$$minus$1(key, x$1))));
        return (Map)b.result();
    }

    public static /* synthetic */ boolean $anonfun$$minus$1(Object key$1, Tuple2 x$1) {
        return !BoxesRunTime.equals(key$1, x$1._1());
    }

    public static void $init$(DefaultMap $this) {
    }
}

