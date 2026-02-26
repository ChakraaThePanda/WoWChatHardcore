/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.utils.concurrent.task;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.exceptions.ContextException;
import net.dv8tion.jda.api.utils.concurrent.Task;
import net.dv8tion.jda.internal.requests.WebSocketClient;
import net.dv8tion.jda.internal.utils.Checks;
import net.dv8tion.jda.internal.utils.JDALogger;
import org.slf4j.Logger;

public class GatewayTask<T>
implements Task<T> {
    private static final Logger log = JDALogger.getLog(Task.class);
    private final Runnable onCancel;
    private final CompletableFuture<T> future;
    private LongConsumer setTimeout;

    public GatewayTask(CompletableFuture<T> future, Runnable onCancel) {
        this.future = future;
        this.onCancel = onCancel;
    }

    public GatewayTask<T> onSetTimeout(LongConsumer setTimeout) {
        this.setTimeout = setTimeout;
        return this;
    }

    @Override
    public boolean isStarted() {
        return true;
    }

    @Override
    @Nonnull
    public Task<T> onError(@Nonnull Consumer<? super Throwable> callback) {
        Checks.notNull(callback, "Callback");
        Consumer<Throwable> failureHandler = ContextException.here(error -> log.error("Task Failure callback threw error", (Throwable)error));
        this.future.exceptionally(error -> {
            block2: {
                try {
                    callback.accept((Throwable)error);
                }
                catch (Throwable e) {
                    failureHandler.accept(e);
                    if (!(e instanceof Error)) break block2;
                    throw e;
                }
            }
            return null;
        });
        return this;
    }

    @Override
    @Nonnull
    public Task<T> onSuccess(@Nonnull Consumer<? super T> callback) {
        Checks.notNull(callback, "Callback");
        Consumer<Throwable> failureHandler = ContextException.here(error -> log.error("Task Success callback threw error", (Throwable)error));
        this.future.thenAccept(result2 -> {
            block2: {
                try {
                    callback.accept(result2);
                }
                catch (Throwable error) {
                    failureHandler.accept(error);
                    if (!(error instanceof Error)) break block2;
                    throw error;
                }
            }
        });
        return this;
    }

    @Override
    @Nonnull
    public Task<T> setTimeout(@Nonnull Duration timeout2) {
        Checks.notNull(timeout2, "Timeout");
        long millis = timeout2.toMillis();
        Checks.positive(millis, "Timeout");
        if (this.setTimeout != null) {
            this.setTimeout.accept(millis);
        }
        return this;
    }

    @Override
    @Nonnull
    public T get() {
        if (WebSocketClient.WS_THREAD.get().booleanValue()) {
            throw new UnsupportedOperationException("Blocking operations are not permitted on the gateway thread");
        }
        return this.future.join();
    }

    @Override
    public void cancel() {
        this.onCancel.run();
    }
}

