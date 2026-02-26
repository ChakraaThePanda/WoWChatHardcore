/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Tuple2;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenMapFactory;
import scala.collection.generic.MutableMapFactory;
import scala.collection.mutable.HashMap;
import scala.collection.mutable.Map;
import scala.runtime.Nothing$;

public final class Map$
extends MutableMapFactory<Map> {
    public static Map$ MODULE$;
    private final GenMapFactory.MapCanBuildFrom<Nothing$, Nothing$> ReusableCBF;

    static {
        new Map$();
    }

    public <K, V> CanBuildFrom<Map<?, ?>, Tuple2<K, V>, Map<K, V>> canBuildFrom() {
        return this.ReusableCBF;
    }

    @Override
    public <K, V> Map<K, V> empty() {
        return new HashMap();
    }

    private Map$() {
        MODULE$ = this;
        this.ReusableCBF = new GenMapFactory.MapCanBuildFrom();
    }
}

