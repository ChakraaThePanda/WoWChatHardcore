/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Serializable;
import scala.Tuple2;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenMapFactory;
import scala.collection.generic.MutableMapFactory;
import scala.collection.mutable.HashMap;

public final class HashMap$
extends MutableMapFactory<HashMap>
implements Serializable {
    public static HashMap$ MODULE$;
    private final GenMapFactory.MapCanBuildFrom<Object, Object> ReusableCBF;

    static {
        new HashMap$();
    }

    public <A, B> CanBuildFrom<HashMap<?, ?>, Tuple2<A, B>, HashMap<A, B>> canBuildFrom() {
        return this.ReusableCBF;
    }

    @Override
    public <A, B> HashMap<A, B> empty() {
        return new HashMap();
    }

    private Object readResolve() {
        return MODULE$;
    }

    private HashMap$() {
        MODULE$ = this;
        this.ReusableCBF = new GenMapFactory.MapCanBuildFrom();
    }
}

