/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.requests.restaction;

import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.requests.restaction.AuditableRestAction;

public interface FluentAuditableRestAction<T, R extends FluentAuditableRestAction<T, R>>
extends AuditableRestAction<T> {
    @Nonnull
    @CheckReturnValue
    public R reason(@Nullable String var1);

    @Nonnull
    @CheckReturnValue
    public R setCheck(@Nullable BooleanSupplier var1);

    @Nonnull
    @CheckReturnValue
    default public R addCheck(@Nonnull BooleanSupplier checks) {
        return (R)((FluentAuditableRestAction)AuditableRestAction.super.addCheck(checks));
    }

    @Nonnull
    @CheckReturnValue
    default public R timeout(long timeout2, @Nonnull TimeUnit unit) {
        return (R)((FluentAuditableRestAction)AuditableRestAction.super.timeout(timeout2, unit));
    }

    @Nonnull
    @CheckReturnValue
    default public R deadline(long timestamp) {
        return (R)((FluentAuditableRestAction)AuditableRestAction.super.deadline(timestamp));
    }
}

