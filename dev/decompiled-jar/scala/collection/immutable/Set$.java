/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.ImmutableSetFactory;
import scala.collection.immutable.Set;
import scala.collection.immutable.Set$EmptySet$;
import scala.collection.mutable.Builder;

public final class Set$
extends ImmutableSetFactory<Set> {
    public static Set$ MODULE$;
    private final CanBuildFrom<Set<?>, Object, Set<Object>> ReusableCBF;

    static {
        new Set$();
    }

    @Override
    public <A> Builder<A, Set<A>> newBuilder() {
        return new Set.SetBuilderImpl();
    }

    public <A> CanBuildFrom<Set<?>, A, Set<A>> canBuildFrom() {
        return this.ReusableCBF;
    }

    @Override
    public Set<Object> emptyInstance() {
        return Set$EmptySet$.MODULE$;
    }

    private Set$() {
        MODULE$ = this;
        this.ReusableCBF = this.setCanBuildFrom();
    }
}

