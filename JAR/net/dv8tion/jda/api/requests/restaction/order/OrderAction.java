/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.Unmodifiable
 */
package net.dv8tion.jda.api.requests.restaction.order;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.requests.RestAction;
import org.jetbrains.annotations.Unmodifiable;

public interface OrderAction<T, M extends OrderAction<T, M>>
extends RestAction<Void> {
    @Nonnull
    @CheckReturnValue
    public M setCheck(@Nullable BooleanSupplier var1);

    @Nonnull
    @CheckReturnValue
    public M timeout(long var1, @Nonnull TimeUnit var3);

    @Nonnull
    @CheckReturnValue
    public M deadline(long var1);

    public boolean isAscendingOrder();

    @Nonnull
    public @Unmodifiable List<T> getCurrentOrder();

    @Nonnull
    @CheckReturnValue
    public M selectPosition(int var1);

    @Nonnull
    @CheckReturnValue
    public M selectPosition(@Nonnull T var1);

    public int getSelectedPosition();

    @Nonnull
    public T getSelectedEntity();

    @Nonnull
    @CheckReturnValue
    public M moveUp(int var1);

    @Nonnull
    @CheckReturnValue
    public M moveDown(int var1);

    @Nonnull
    @CheckReturnValue
    public M moveTo(int var1);

    @Nonnull
    @CheckReturnValue
    public M moveBelow(@Nonnull T var1);

    @Nonnull
    @CheckReturnValue
    public M moveAbove(@Nonnull T var1);

    @Nonnull
    @CheckReturnValue
    public M swapPosition(int var1);

    @Nonnull
    @CheckReturnValue
    public M swapPosition(@Nonnull T var1);

    @Nonnull
    @CheckReturnValue
    public M reverseOrder();

    @Nonnull
    @CheckReturnValue
    public M shuffleOrder();

    @Nonnull
    @CheckReturnValue
    public M sortOrder(@Nonnull Comparator<T> var1);
}

