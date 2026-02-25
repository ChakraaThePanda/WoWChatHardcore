/*
 * Decompiled with CFR 0.152.
 */
package scala.util;

import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.util.Right;

public final class Right$
implements Serializable {
    public static Right$ MODULE$;

    static {
        new Right$();
    }

    public final String toString() {
        return "Right";
    }

    public <A, B> Right<A, B> apply(B value) {
        return new Right(value);
    }

    public <A, B> Option<B> unapply(Right<A, B> x$0) {
        if (x$0 == null) {
            return None$.MODULE$;
        }
        return new Some<B>(x$0.value());
    }

    private Object readResolve() {
        return MODULE$;
    }

    private Right$() {
        MODULE$ = this;
    }
}

