/*
 * Decompiled with CFR 0.152.
 */
package scala.util;

import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.util.Success;

public final class Success$
implements Serializable {
    public static Success$ MODULE$;

    static {
        new Success$();
    }

    public final String toString() {
        return "Success";
    }

    public <T> Success<T> apply(T value) {
        return new Success<T>(value);
    }

    public <T> Option<T> unapply(Success<T> x$0) {
        if (x$0 == null) {
            return None$.MODULE$;
        }
        return new Some<T>(x$0.value());
    }

    private Object readResolve() {
        return MODULE$;
    }

    private Success$() {
        MODULE$ = this;
    }
}

