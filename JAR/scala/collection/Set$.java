/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.collection.Set;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.SetFactory;
import scala.collection.mutable.Builder;

public final class Set$
extends SetFactory<Set> {
    public static Set$ MODULE$;
    private final CanBuildFrom<Set<?>, Object, Set<Object>> ReusableCBF;

    static {
        new Set$();
    }

    @Override
    public <A> Builder<A, scala.collection.immutable.Set<A>> newBuilder() {
        return scala.collection.immutable.Set$.MODULE$.newBuilder();
    }

    @Override
    public <A> Set<A> empty() {
        return scala.collection.immutable.Set$.MODULE$.empty();
    }

    public <A> CanBuildFrom<Set<?>, A, Set<A>> canBuildFrom() {
        return this.ReusableCBF;
    }

    private Set$() {
        MODULE$ = this;
        this.ReusableCBF = this.setCanBuildFrom();
    }
}

