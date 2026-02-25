/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;

public final class Some$
implements Serializable {
    public static Some$ MODULE$;

    static {
        new Some$();
    }

    public final String toString() {
        return "Some";
    }

    public <A> Some<A> apply(A value) {
        return new Some<A>(value);
    }

    public <A> Option<A> unapply(Some<A> x$0) {
        if (x$0 == null) {
            return None$.MODULE$;
        }
        return new Some<A>(x$0.value());
    }

    private Object readResolve() {
        return MODULE$;
    }

    private Some$() {
        MODULE$ = this;
    }
}

