/*
 * Decompiled with CFR 0.152.
 */
package scala.util;

import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.util.Left;

public final class Left$
implements Serializable {
    public static Left$ MODULE$;

    static {
        new Left$();
    }

    public final String toString() {
        return "Left";
    }

    public <A, B> Left<A, B> apply(A value) {
        return new Left(value);
    }

    public <A, B> Option<A> unapply(Left<A, B> x$0) {
        if (x$0 == null) {
            return None$.MODULE$;
        }
        return new Some<A>(x$0.value());
    }

    private Object readResolve() {
        return MODULE$;
    }

    private Left$() {
        MODULE$ = this;
    }
}

