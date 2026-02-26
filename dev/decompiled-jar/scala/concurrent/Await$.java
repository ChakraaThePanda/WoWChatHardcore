/*
 * Decompiled with CFR 0.152.
 */
package scala.concurrent;

import java.util.concurrent.TimeoutException;
import scala.Function0;
import scala.Serializable;
import scala.concurrent.AwaitPermission$;
import scala.concurrent.Awaitable;
import scala.concurrent.BlockContext$;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;
import scala.concurrent.package$;

public final class Await$ {
    public static Await$ MODULE$;

    static {
        new Await$();
    }

    /*
     * WARNING - void declaration
     */
    public <T> Awaitable<T> ready(Awaitable<T> awaitable, Duration atMost) throws TimeoutException, InterruptedException {
        Awaitable awaitable2;
        if (awaitable instanceof Future && ((Future)awaitable).isCompleted()) {
            awaitable2 = awaitable.ready(atMost, AwaitPermission$.MODULE$);
        } else {
            void blocking_body;
            Function0<Awaitable> & java.io.Serializable & Serializable intersect = (Function0<Awaitable> & java.io.Serializable & Serializable)() -> awaitable.ready(atMost, AwaitPermission$.MODULE$);
            if (package$.MODULE$ == null) {
                throw null;
            }
            awaitable2 = (Awaitable)BlockContext$.MODULE$.current().blockOn(blocking_body, AwaitPermission$.MODULE$);
        }
        return awaitable2;
    }

    /*
     * WARNING - void declaration
     */
    public <T> T result(Awaitable<T> awaitable, Duration atMost) throws TimeoutException, InterruptedException {
        T t;
        if (awaitable instanceof Future && ((Future)awaitable).isCompleted()) {
            t = awaitable.result(atMost, AwaitPermission$.MODULE$);
        } else {
            void blocking_body;
            Function0<Object> & java.io.Serializable & Serializable intersect = (Function0<Object> & java.io.Serializable & Serializable)() -> awaitable.result(atMost, AwaitPermission$.MODULE$);
            if (package$.MODULE$ == null) {
                throw null;
            }
            t = BlockContext$.MODULE$.current().blockOn(blocking_body, AwaitPermission$.MODULE$);
        }
        return t;
    }

    private Await$() {
        MODULE$ = this;
    }
}

