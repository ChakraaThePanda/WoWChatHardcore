/*
 * Decompiled with CFR 0.152.
 */
package scala.concurrent;

import scala.Function0;
import scala.concurrent.AwaitPermission$;
import scala.concurrent.BlockContext$;
import scala.concurrent.ExecutionContext;
import scala.concurrent.Future;
import scala.concurrent.Future$;
import scala.concurrent.Promise;
import scala.concurrent.Promise$;

public final class package$ {
    public static package$ MODULE$;

    static {
        new package$();
    }

    public <T> Future<T> future(Function0<T> body, ExecutionContext executor) {
        Future$ future$ = Future$.MODULE$;
        if (future$ == null) {
            throw null;
        }
        return future$.unit().map(arg_0 -> Future$.$anonfun$apply$1(body, arg_0), executor);
    }

    public <T> Promise<T> promise() {
        return Promise$.MODULE$.apply();
    }

    public <T> T blocking(Function0<T> body) throws Exception {
        return BlockContext$.MODULE$.current().blockOn(body, AwaitPermission$.MODULE$);
    }

    private package$() {
        MODULE$ = this;
    }
}

