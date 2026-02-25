/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Tuple2;
import scala.collection.GenMap;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenMapFactory;
import scala.collection.immutable.Map;
import scala.collection.immutable.Map$;
import scala.runtime.Nothing$;

public final class GenMap$
extends GenMapFactory<GenMap> {
    public static GenMap$ MODULE$;
    private final GenMapFactory.MapCanBuildFrom<Nothing$, Nothing$> ReusableCBF;

    static {
        new GenMap$();
    }

    @Override
    public <K, V> Map<K, V> empty() {
        return Map$.MODULE$.empty();
    }

    public <K, V> CanBuildFrom<GenMap<?, ?>, Tuple2<K, V>, GenMap<K, V>> canBuildFrom() {
        return this.ReusableCBF;
    }

    private GenMap$() {
        MODULE$ = this;
        this.ReusableCBF = new GenMapFactory.MapCanBuildFrom(this);
    }
}

