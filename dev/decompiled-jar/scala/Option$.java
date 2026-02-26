/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.collection.Iterable;

public final class Option$
implements Serializable {
    public static Option$ MODULE$;

    static {
        new Option$();
    }

    public <A> Iterable<A> option2Iterable(Option<A> xo) {
        return xo.toList();
    }

    public <A> Option<A> apply(A x) {
        if (x == null) {
            return None$.MODULE$;
        }
        return new Some<A>(x);
    }

    public <A> Option<A> empty() {
        return None$.MODULE$;
    }

    private Object readResolve() {
        return MODULE$;
    }

    private Option$() {
        MODULE$ = this;
    }
}

