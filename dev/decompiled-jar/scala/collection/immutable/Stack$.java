/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.Function1;
import scala.Serializable;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.SeqFactory;
import scala.collection.immutable.Stack;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.Builder;

public final class Stack$
extends SeqFactory<Stack>
implements Serializable {
    public static Stack$ MODULE$;

    static {
        new Stack$();
    }

    public <A> CanBuildFrom<Stack<?>, A, Stack<A>> canBuildFrom() {
        return this.ReusableCBF();
    }

    @Override
    public <A> Builder<A, Stack<A>> newBuilder() {
        return new ArrayBuffer().mapResult((Function1<ArrayBuffer, Stack> & java.io.Serializable & Serializable)buf -> new Stack(buf.toList()));
    }

    private Object readResolve() {
        return MODULE$;
    }

    private Stack$() {
        MODULE$ = this;
    }
}

