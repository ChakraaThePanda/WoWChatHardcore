/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.Tuple2;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenMapFactory;
import scala.collection.generic.ImmutableMapFactory;
import scala.collection.immutable.HashMap$;
import scala.collection.immutable.Map;
import scala.collection.immutable.Map$EmptyMap$;
import scala.collection.mutable.Builder;
import scala.collection.package;
import scala.runtime.Nothing$;

public final class Map$
extends ImmutableMapFactory<Map> {
    public static Map$ MODULE$;
    private final GenMapFactory.MapCanBuildFrom<Nothing$, Nothing$> ReusableCBF;

    static {
        new Map$();
    }

    @Override
    public <A, B> Builder<Tuple2<A, B>, Map<A, B>> newBuilder() {
        return new Map.MapBuilderImpl();
    }

    public <K, V> CanBuildFrom<Map<?, ?>, Tuple2<K, V>, Map<K, V>> canBuildFrom() {
        return this.ReusableCBF;
    }

    @Override
    public <K, V> Map<K, V> empty() {
        return Map$EmptyMap$.MODULE$;
    }

    public boolean scala$collection$immutable$Map$$isHashMapCBF(CanBuildFrom<?, ?, ?> cbf) {
        boolean bl = cbf instanceof package.WrappedCanBuildFrom ? ((package.WrappedCanBuildFrom)cbf).wrapped() == HashMap$.MODULE$.canBuildFrom() : cbf == HashMap$.MODULE$.canBuildFrom();
        return bl;
    }

    public boolean scala$collection$immutable$Map$$isMapCBF(CanBuildFrom<?, ?, ?> cbf) {
        boolean bl = cbf instanceof package.WrappedCanBuildFrom ? ((package.WrappedCanBuildFrom)cbf).wrapped() == this.canBuildFrom() : cbf == this.canBuildFrom();
        return bl;
    }

    private Map$() {
        MODULE$ = this;
        this.ReusableCBF = new GenMapFactory.MapCanBuildFrom();
    }
}

