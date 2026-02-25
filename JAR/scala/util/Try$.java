/*
 * Decompiled with CFR 0.152.
 */
package scala.util;

import scala.Function0;
import scala.Option;
import scala.Serializable;
import scala.util.Failure;
import scala.util.Success;
import scala.util.Try;
import scala.util.control.NonFatal$;

public final class Try$
implements Serializable {
    public static Try$ MODULE$;

    static {
        new Try$();
    }

    public <T> Try<T> apply(Function0<T> r) {
        try {
            return new Success<T>(r.apply());
        }
        catch (Throwable throwable) {
            Option<Throwable> option = NonFatal$.MODULE$.unapply(throwable);
            if (option.isEmpty()) {
                throw throwable;
            }
            Throwable e = option.get();
            Failure failure = new Failure(e);
            return failure;
        }
    }

    private Object readResolve() {
        return MODULE$;
    }

    private Try$() {
        MODULE$ = this;
    }
}

