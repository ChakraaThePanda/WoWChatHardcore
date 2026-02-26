/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.requests;

import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.requests.RestAction;

public interface FluentRestAction<T, R extends FluentRestAction<T, R>>
extends RestAction<T> {
    @Nonnull
    @CheckReturnValue
    public R setCheck(@Nullable BooleanSupplier var1);

    @Nonnull
    @CheckReturnValue
    default public R addCheck(@Nonnull BooleanSupplier checks) {
        return (R)((FluentRestAction)RestAction.super.addCheck(checks));
    }

    @Nonnull
    @CheckReturnValue
    default public R timeout(long timeout2, @Nonnull TimeUnit unit) {
        return (R)((FluentRestAction)RestAction.super.timeout(timeout2, unit));
    }

    @Nonnull
    @CheckReturnValue
    default public R deadline(long timestamp) {
        return (R)((FluentRestAction)RestAction.super.deadline(timestamp));
    }
}

