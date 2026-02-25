/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Tuple2;
import scala.collection.Map;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenMapFactory;
import scala.collection.generic.MapFactory;
import scala.runtime.Nothing$;

public final class Map$
extends MapFactory<Map> {
    public static Map$ MODULE$;
    private final GenMapFactory.MapCanBuildFrom<Nothing$, Nothing$> ReusableCBF;

    static {
        new Map$();
    }

    @Override
    public <K, V> scala.collection.immutable.Map<K, V> empty() {
        return scala.collection.immutable.Map$.MODULE$.empty();
    }

    public <K, V> CanBuildFrom<Map<?, ?>, Tuple2<K, V>, Map<K, V>> canBuildFrom() {
        return this.ReusableCBF;
    }

    private Map$() {
        MODULE$ = this;
        this.ReusableCBF = new GenMapFactory.MapCanBuildFrom(this);
    }
}

