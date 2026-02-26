/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Serializable;
import scala.Tuple2;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenMapFactory;
import scala.collection.generic.MutableMapFactory;
import scala.collection.mutable.WeakHashMap;
import scala.runtime.Nothing$;

public final class WeakHashMap$
extends MutableMapFactory<WeakHashMap>
implements Serializable {
    public static WeakHashMap$ MODULE$;
    private final GenMapFactory.MapCanBuildFrom<Nothing$, Nothing$> ReusableCBF;

    static {
        new WeakHashMap$();
    }

    public <A, B> CanBuildFrom<WeakHashMap<?, ?>, Tuple2<A, B>, WeakHashMap<A, B>> canBuildFrom() {
        return this.ReusableCBF;
    }

    @Override
    public <A, B> WeakHashMap<A, B> empty() {
        return new WeakHashMap();
    }

    private Object readResolve() {
        return MODULE$;
    }

    private WeakHashMap$() {
        MODULE$ = this;
        this.ReusableCBF = new GenMapFactory.MapCanBuildFrom();
    }
}

