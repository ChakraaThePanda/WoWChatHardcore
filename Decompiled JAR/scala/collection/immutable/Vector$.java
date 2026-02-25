/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.Serializable;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.IndexedSeqFactory;
import scala.collection.immutable.Vector;
import scala.collection.immutable.VectorBuilder;
import scala.collection.immutable.VectorIterator;
import scala.collection.mutable.Builder;
import scala.runtime.Nothing$;

public final class Vector$
extends IndexedSeqFactory<Vector>
implements Serializable {
    public static Vector$ MODULE$;
    private final Vector<Nothing$> NIL;
    private final VectorIterator<Nothing$> scala$collection$immutable$Vector$$emptyIterator;

    static {
        new Vector$();
    }

    @Override
    public <A> Builder<A, Vector<A>> newBuilder() {
        return new VectorBuilder();
    }

    public <A> CanBuildFrom<Vector<?>, A, Vector<A>> canBuildFrom() {
        return this.ReusableCBF();
    }

    public Vector<Nothing$> NIL() {
        return this.NIL;
    }

    @Override
    public <A> Vector<A> empty() {
        return this.NIL();
    }

    private final int Log2ConcatFaster() {
        return 5;
    }

    private final int TinyAppendFaster() {
        return 2;
    }

    public VectorIterator<Nothing$> scala$collection$immutable$Vector$$emptyIterator() {
        return this.scala$collection$immutable$Vector$$emptyIterator;
    }

    private Object readResolve() {
        return MODULE$;
    }

    private Vector$() {
        MODULE$ = this;
        this.NIL = new Vector(0, 0, 0);
        this.scala$collection$immutable$Vector$$emptyIterator = new VectorIterator(0, 0);
    }
}

