/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function1;
import scala.Serializable;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.SeqFactory;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.ArraySeq;
import scala.collection.mutable.Builder;

public final class ArraySeq$
extends SeqFactory<ArraySeq>
implements Serializable {
    public static ArraySeq$ MODULE$;

    static {
        new ArraySeq$();
    }

    public <A> CanBuildFrom<ArraySeq<?>, A, ArraySeq<A>> canBuildFrom() {
        return this.ReusableCBF();
    }

    @Override
    public <A> Builder<A, ArraySeq<A>> newBuilder() {
        return new ArrayBuffer().mapResult((Function1<ArrayBuffer, ArraySeq> & java.io.Serializable & Serializable)buf -> {
            void var1_1;
            ArraySeq result2 = new ArraySeq(buf.length());
            buf.copyToArray(result2.array(), 0);
            return var1_1;
        });
    }

    private Object readResolve() {
        return MODULE$;
    }

    private ArraySeq$() {
        MODULE$ = this;
    }
}

