/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function1;
import scala.Serializable;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.SeqFactory;
import scala.collection.mutable.Builder;
import scala.collection.mutable.LinkedList;
import scala.collection.mutable.MutableList;

public final class LinkedList$
extends SeqFactory<LinkedList>
implements Serializable {
    public static LinkedList$ MODULE$;

    static {
        new LinkedList$();
    }

    @Override
    public <A> LinkedList<A> empty() {
        return new LinkedList();
    }

    public <A> CanBuildFrom<LinkedList<?>, A, LinkedList<A>> canBuildFrom() {
        return this.ReusableCBF();
    }

    @Override
    public <A> Builder<A, LinkedList<A>> newBuilder() {
        return new MutableList().mapResult((Function1<MutableList, LinkedList> & java.io.Serializable & Serializable)l -> l.toLinkedList());
    }

    private Object readResolve() {
        return MODULE$;
    }

    private LinkedList$() {
        MODULE$ = this;
    }
}

