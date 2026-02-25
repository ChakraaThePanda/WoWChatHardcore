/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.Function2;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.Seq;
import scala.collection.generic.CanBuildFrom;
import scala.collection.immutable.LongMap;
import scala.collection.immutable.LongMap$Nil$;
import scala.collection.mutable.Builder;
import scala.collection.mutable.MapBuilder;

public final class LongMap$ {
    public static LongMap$ MODULE$;
    private final CanBuildFrom<LongMap<Object>, Tuple2<Object, Object>, LongMap<Object>> ReusableCBF;

    static {
        new LongMap$();
    }

    public <A, B> CanBuildFrom<LongMap<A>, Tuple2<Object, B>, LongMap<B>> canBuildFrom() {
        return this.ReusableCBF;
    }

    public <T> LongMap<T> empty() {
        return LongMap$Nil$.MODULE$;
    }

    public <T> LongMap<T> singleton(long key, T value) {
        return new LongMap.Tip<T>(key, value);
    }

    public <T> LongMap<T> apply(Seq<Tuple2<Object, T>> elems) {
        return elems.foldLeft(this.empty(), (Function2<LongMap, Tuple2, LongMap> & java.io.Serializable & Serializable)(x, y) -> x.updated(y._1$mcJ$sp(), y._2()));
    }

    private LongMap$() {
        MODULE$ = this;
        this.ReusableCBF = new CanBuildFrom<LongMap<Object>, Tuple2<Object, Object>, LongMap<Object>>(){

            public Builder<Tuple2<Object, Object>, LongMap<Object>> apply(LongMap<Object> from) {
                return this.apply();
            }

            public Builder<Tuple2<Object, Object>, LongMap<Object>> apply() {
                return new MapBuilder<Object, Object, LongMap<Object>>(LongMap$.MODULE$.empty());
            }
        };
    }
}

