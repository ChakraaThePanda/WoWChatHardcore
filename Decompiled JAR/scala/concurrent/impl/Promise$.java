/*
 * Decompiled with CFR 0.152.
 */
package scala.concurrent.impl;

import java.util.concurrent.ExecutionException;
import scala.runtime.NonLocalReturnControl;
import scala.util.Failure;
import scala.util.Success;
import scala.util.Try;
import scala.util.control.ControlThrowable;

public final class Promise$ {
    public static Promise$ MODULE$;

    static {
        new Promise$();
    }

    public <T> Try<T> scala$concurrent$impl$Promise$$resolveTry(Try<T> source2) {
        Try<T> try_;
        if (source2 instanceof Failure) {
            Throwable t = ((Failure)source2).exception();
            try_ = this.resolver(t);
        } else {
            try_ = source2;
        }
        return try_;
    }

    private <T> Try<T> resolver(Throwable throwable) {
        Try try_;
        if (throwable instanceof NonLocalReturnControl) {
            NonLocalReturnControl nonLocalReturnControl = (NonLocalReturnControl)throwable;
            try_ = new Success(nonLocalReturnControl.value());
        } else if (throwable instanceof ControlThrowable) {
            ControlThrowable controlThrowable = (ControlThrowable)((Object)throwable);
            try_ = new Failure(new ExecutionException("Boxed ControlThrowable", (Throwable)((Object)controlThrowable)));
        } else if (throwable instanceof InterruptedException) {
            InterruptedException interruptedException = (InterruptedException)throwable;
            try_ = new Failure(new ExecutionException("Boxed InterruptedException", interruptedException));
        } else if (throwable instanceof Error) {
            Error error = (Error)throwable;
            try_ = new Failure(new ExecutionException("Boxed Error", error));
        } else {
            try_ = new Failure(throwable);
        }
        return try_;
    }

    private Promise$() {
        MODULE$ = this;
    }
}

