/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.requests.restaction.operator;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.exceptions.RateLimitedException;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.internal.requests.restaction.operator.RestActionOperator;
import net.dv8tion.jda.internal.utils.Helpers;
import org.jetbrains.annotations.Contract;

public class MapErrorRestAction<T>
extends RestActionOperator<T, T> {
    private final Predicate<? super Throwable> check;
    private final Function<? super Throwable, ? extends T> map;

    public MapErrorRestAction(RestAction<T> action, Predicate<? super Throwable> check2, Function<? super Throwable, ? extends T> map) {
        super(action);
        this.check = check2;
        this.map = map;
    }

    @Override
    public void queue(@Nullable Consumer<? super T> success, @Nullable Consumer<? super Throwable> failure) {
        this.action.queue(success, this.contextWrap(error -> {
            try {
                if (this.check.test((Throwable)error)) {
                    MapErrorRestAction.doSuccess(success, this.map.apply((Throwable)error));
                } else {
                    MapErrorRestAction.doFailure(failure, error);
                }
            }
            catch (Throwable e) {
                MapErrorRestAction.doFailure(failure, Helpers.appendCause(e, error));
            }
        }));
    }

    @Override
    public T complete(boolean shouldQueue) throws RateLimitedException {
        try {
            return this.action.complete(shouldQueue);
        }
        catch (Throwable error) {
            try {
                if (this.check.test(error)) {
                    return this.map.apply(error);
                }
            }
            catch (Throwable e) {
                this.fail(Helpers.appendCause(e, error));
            }
            if (error instanceof RateLimitedException) {
                throw (RateLimitedException)error;
            }
            this.fail(error);
            throw new AssertionError((Object)"Unreachable");
        }
    }

    @Override
    @Nonnull
    public CompletableFuture<T> submit(boolean shouldQueue) {
        return this.action.submit(shouldQueue).handle((value, error) -> {
            Object result2 = value;
            if (error != null) {
                Throwable throwable = error = error instanceof CompletionException && error.getCause() != null ? error.getCause() : error;
                if (this.check.test((Throwable)error)) {
                    result2 = this.map.apply((Throwable)error);
                } else {
                    this.fail((Throwable)error);
                }
            }
            return result2;
        });
    }

    @Contract(value="_ -> fail")
    private void fail(Throwable error) {
        if (error instanceof RuntimeException) {
            throw (RuntimeException)error;
        }
        if (error instanceof Error) {
            throw (Error)error;
        }
        throw new RuntimeException(error);
    }
}

