/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.macros;

import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple3;
import scala.reflect.api.Position;
import scala.reflect.macros.UnexpectedReificationException;
import scala.runtime.AbstractFunction3;

public final class UnexpectedReificationException$
extends AbstractFunction3<Position, String, Throwable, UnexpectedReificationException>
implements Serializable {
    public static UnexpectedReificationException$ MODULE$;

    static {
        new UnexpectedReificationException$();
    }

    public Throwable $lessinit$greater$default$3() {
        return null;
    }

    @Override
    public final String toString() {
        return "UnexpectedReificationException";
    }

    @Override
    public UnexpectedReificationException apply(Position pos, String msg, Throwable cause) {
        return new UnexpectedReificationException(pos, msg, cause);
    }

    public Throwable apply$default$3() {
        return null;
    }

    public Option<Tuple3<Position, String, Throwable>> unapply(UnexpectedReificationException x$0) {
        if (x$0 == null) {
            return None$.MODULE$;
        }
        return new Some<Tuple3<Position, String, Throwable>>(new Tuple3<Position, String, Throwable>(x$0.pos(), x$0.msg(), x$0.cause()));
    }

    private Object readResolve() {
        return MODULE$;
    }

    private UnexpectedReificationException$() {
        MODULE$ = this;
    }
}

