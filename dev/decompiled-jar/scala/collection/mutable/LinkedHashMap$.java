/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Serializable;
import scala.Tuple2;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenMapFactory;
import scala.collection.generic.MutableMapFactory;
import scala.collection.mutable.LinkedHashMap;

public final class LinkedHashMap$
extends MutableMapFactory<LinkedHashMap>
implements Serializable {
    public static LinkedHashMap$ MODULE$;
    private final GenMapFactory.MapCanBuildFrom<Object, Object> ReusableCBF;

    static {
        new LinkedHashMap$();
    }

    public <A, B> CanBuildFrom<LinkedHashMap<?, ?>, Tuple2<A, B>, LinkedHashMap<A, B>> canBuildFrom() {
        return this.ReusableCBF;
    }

    @Override
    public <A, B> LinkedHashMap<A, B> empty() {
        return new LinkedHashMap();
    }

    private Object readResolve() {
        return MODULE$;
    }

    private LinkedHashMap$() {
        MODULE$ = this;
        this.ReusableCBF = new GenMapFactory.MapCanBuildFrom();
    }
}

