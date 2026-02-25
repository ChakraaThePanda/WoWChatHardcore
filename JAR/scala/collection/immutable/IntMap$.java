/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.Function2;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.Seq;
import scala.collection.generic.CanBuildFrom;
import scala.collection.immutable.IntMap;
import scala.collection.immutable.IntMap$Nil$;
import scala.collection.mutable.Builder;
import scala.collection.mutable.MapBuilder;

public final class IntMap$ {
    public static IntMap$ MODULE$;
    private final CanBuildFrom<IntMap<Object>, Tuple2<Object, Object>, IntMap<Object>> ReusableCBF;

    static {
        new IntMap$();
    }

    public <A, B> CanBuildFrom<IntMap<A>, Tuple2<Object, B>, IntMap<B>> canBuildFrom() {
        return this.ReusableCBF();
    }

    private CanBuildFrom<IntMap<Object>, Tuple2<Object, Object>, IntMap<Object>> ReusableCBF() {
        return this.ReusableCBF;
    }

    public <T> IntMap<T> empty() {
        return IntMap$Nil$.MODULE$;
    }

    public <T> IntMap<T> singleton(int key, T value) {
        return new IntMap.Tip<T>(key, value);
    }

    public <T> IntMap<T> apply(Seq<Tuple2<Object, T>> elems) {
        return elems.foldLeft(this.empty(), (Function2<IntMap, Tuple2, IntMap> & java.io.Serializable & Serializable)(x, y) -> x.updated(y._1$mcI$sp(), y._2()));
    }

    private IntMap$() {
        MODULE$ = this;
        this.ReusableCBF = new CanBuildFrom<IntMap<Object>, Tuple2<Object, Object>, IntMap<Object>>(){

            public Builder<Tuple2<Object, Object>, IntMap<Object>> apply(IntMap<Object> from) {
                return this.apply();
            }

            public Builder<Tuple2<Object, Object>, IntMap<Object>> apply() {
                return new MapBuilder<Object, Object, IntMap<Object>>(IntMap$.MODULE$.empty());
            }
        };
    }
}

