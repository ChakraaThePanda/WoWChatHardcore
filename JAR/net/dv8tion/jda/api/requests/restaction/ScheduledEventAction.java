/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.requests.restaction;

import java.time.temporal.TemporalAccessor;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Icon;
import net.dv8tion.jda.api.entities.ScheduledEvent;
import net.dv8tion.jda.api.requests.restaction.FluentAuditableRestAction;

public interface ScheduledEventAction
extends FluentAuditableRestAction<ScheduledEvent, ScheduledEventAction> {
    @Nonnull
    public Guild getGuild();

    @Nonnull
    @CheckReturnValue
    public ScheduledEventAction setName(@Nonnull String var1);

    @Nonnull
    @CheckReturnValue
    public ScheduledEventAction setDescription(@Nullable String var1);

    @Nonnull
    @CheckReturnValue
    public ScheduledEventAction setStartTime(@Nonnull TemporalAccessor var1);

    @Nonnull
    @CheckReturnValue
    public ScheduledEventAction setEndTime(@Nullable TemporalAccessor var1);

    @Nonnull
    @CheckReturnValue
    public ScheduledEventAction setImage(@Nullable Icon var1);
}

