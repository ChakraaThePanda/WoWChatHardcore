/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.guild.scheduledevent.update;

import java.time.OffsetDateTime;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.ScheduledEvent;
import net.dv8tion.jda.api.events.guild.scheduledevent.update.GenericScheduledEventUpdateEvent;

public class ScheduledEventUpdateStartTimeEvent
extends GenericScheduledEventUpdateEvent<OffsetDateTime> {
    public static final String IDENTIFIER = "start_time";

    public ScheduledEventUpdateStartTimeEvent(@Nonnull JDA api2, long responseNumber, @Nonnull ScheduledEvent scheduledEvent, @Nonnull OffsetDateTime previous) {
        super(api2, responseNumber, scheduledEvent, previous, scheduledEvent.getStartTime(), IDENTIFIER);
    }

    @Nonnull
    public OffsetDateTime getOldStartTime() {
        return this.getOldValue();
    }

    @Nonnull
    public OffsetDateTime getNewStartTime() {
        return this.getNewValue();
    }

    @Override
    @Nonnull
    public OffsetDateTime getOldValue() {
        return (OffsetDateTime)super.getOldValue();
    }

    @Override
    @Nonnull
    public OffsetDateTime getNewValue() {
        return (OffsetDateTime)super.getNewValue();
    }
}

