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

public interface AuditableRestAction<T>
extends RestAction<T> {
    public static final int MAX_REASON_LENGTH = 512;

    @Nonnull
    @CheckReturnValue
    public AuditableRestAction<T> reason(@Nullable String var1);

    @Override
    @Nonnull
    @CheckReturnValue
    public AuditableRestAction<T> setCheck(@Nullable BooleanSupplier var1);

    @Override
    @Nonnull
    @CheckReturnValue
    default public AuditableRestAction<T> timeout(long timeout2, @Nonnull TimeUnit unit) {
        return (AuditableRestAction)RestAction.super.timeout(timeout2, unit);
    }

    @Override
    @Nonnull
    @CheckReturnValue
    default public AuditableRestAction<T> deadline(long timestamp) {
        return (AuditableRestAction)RestAction.super.deadline(timestamp);
    }
}

