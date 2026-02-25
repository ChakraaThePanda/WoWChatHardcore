/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.Serializable;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.ImmutableSetFactory;
import scala.collection.immutable.ListSet;
import scala.collection.immutable.ListSet$EmptyListSet$;

public final class ListSet$
extends ImmutableSetFactory<ListSet>
implements Serializable {
    public static ListSet$ MODULE$;
    private final CanBuildFrom<ListSet<?>, Object, ListSet<Object>> ReusableCBF;

    static {
        new ListSet$();
    }

    public <A> CanBuildFrom<ListSet<?>, A, ListSet<A>> canBuildFrom() {
        return this.ReusableCBF;
    }

    @Override
    public ListSet<Object> emptyInstance() {
        return ListSet$EmptyListSet$.MODULE$;
    }

    private Object readResolve() {
        return MODULE$;
    }

    private ListSet$() {
        MODULE$ = this;
        this.ReusableCBF = this.setCanBuildFrom();
    }
}

