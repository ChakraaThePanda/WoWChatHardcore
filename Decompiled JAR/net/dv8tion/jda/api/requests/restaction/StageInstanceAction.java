/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.requests.restaction;

import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.StageInstance;
import net.dv8tion.jda.api.requests.RestAction;

public interface StageInstanceAction
extends RestAction<StageInstance> {
    @Nonnull
    @CheckReturnValue
    public StageInstanceAction setCheck(@Nullable BooleanSupplier var1);

    @Nonnull
    @CheckReturnValue
    public StageInstanceAction timeout(long var1, @Nonnull TimeUnit var3);

    @Nonnull
    @CheckReturnValue
    public StageInstanceAction deadline(long var1);

    @Nonnull
    @CheckReturnValue
    public StageInstanceAction setTopic(@Nonnull String var1);
}

