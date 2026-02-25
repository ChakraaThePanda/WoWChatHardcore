/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.requests.restaction;

import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.requests.RestAction;

public interface CacheRestAction<T>
extends RestAction<T> {
    @Override
    @Nonnull
    @CheckReturnValue
    public CacheRestAction<T> setCheck(@Nullable BooleanSupplier var1);

    @Override
    @Nonnull
    @CheckReturnValue
    default public CacheRestAction<T> addCheck(@Nonnull BooleanSupplier checks) {
        return (CacheRestAction)RestAction.super.addCheck(checks);
    }

    @Override
    @Nonnull
    @CheckReturnValue
    default public CacheRestAction<T> timeout(long timeout2, @Nonnull TimeUnit unit) {
        return (CacheRestAction)RestAction.super.timeout(timeout2, unit);
    }

    @Override
    @Nonnull
    @CheckReturnValue
    default public CacheRestAction<T> deadline(long timestamp) {
        return (CacheRestAction)RestAction.super.deadline(timestamp);
    }

    @Nonnull
    @CheckReturnValue
    public CacheRestAction<T> useCache(boolean var1);
}

