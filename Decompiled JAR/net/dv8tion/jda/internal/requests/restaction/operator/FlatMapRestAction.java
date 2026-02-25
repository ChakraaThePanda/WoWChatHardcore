/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.requests.restaction.operator;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.exceptions.RateLimitedException;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.internal.requests.restaction.operator.RestActionOperator;

public class FlatMapRestAction<I, O>
extends RestActionOperator<I, O> {
    private final Function<? super I, ? extends RestAction<O>> function;
    private final Predicate<? super I> condition;

    public FlatMapRestAction(RestAction<I> action, Predicate<? super I> condition, Function<? super I, ? extends RestAction<O>> function) {
        super(action);
        this.function = function;
        this.condition = condition;
    }

    private RestAction<O> supply(I input) {
        return this.applyContext(this.function.apply(input));
    }

    @Override
    public void queue(@Nullable Consumer<? super O> success, @Nullable Consumer<? super Throwable> failure) {
        Consumer<Throwable> catcher = this.contextWrap(failure);
        this.handle(this.action, catcher, result2 -> {
            if (this.condition != null && !this.condition.test(result2)) {
                return;
            }
            RestAction<O> then = this.supply(result2);
            if (then == null) {
                throw new IllegalStateException("FlatMap operand is null");
            }
            then.queue(success, catcher);
        });
    }

    @Override
    public O complete(boolean shouldQueue) throws RateLimitedException {
        Object complete = this.action.complete(shouldQueue);
        if (this.condition != null && !this.condition.test(complete)) {
            throw new CancellationException("FlatMap condition failed");
        }
        return this.supply(complete).complete(shouldQueue);
    }

    @Override
    @Nonnull
    public CompletableFuture<O> submit(boolean shouldQueue) {
        return this.action.submit(shouldQueue).thenCompose(result2 -> {
            if (this.condition != null && !this.condition.test(result2)) {
                CompletableFuture future = new CompletableFuture();
                future.cancel(true);
                return future;
            }
            return this.supply(result2).submit(shouldQueue);
        });
    }
}

