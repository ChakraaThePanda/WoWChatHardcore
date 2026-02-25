/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Serializable;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.MutableSetFactory;
import scala.collection.mutable.LinkedHashSet;

public final class LinkedHashSet$
extends MutableSetFactory<LinkedHashSet>
implements Serializable {
    public static LinkedHashSet$ MODULE$;
    private final CanBuildFrom<LinkedHashSet<?>, Object, LinkedHashSet<Object>> ReusableCBF;

    static {
        new LinkedHashSet$();
    }

    public <A> CanBuildFrom<LinkedHashSet<?>, A, LinkedHashSet<A>> canBuildFrom() {
        return this.ReusableCBF;
    }

    @Override
    public <A> LinkedHashSet<A> empty() {
        return new LinkedHashSet();
    }

    private Object readResolve() {
        return MODULE$;
    }

    private LinkedHashSet$() {
        MODULE$ = this;
        this.ReusableCBF = this.setCanBuildFrom();
    }
}

