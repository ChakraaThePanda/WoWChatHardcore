/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.guild.scheduledevent.update;

import java.time.OffsetDateTime;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.ScheduledEvent;
import net.dv8tion.jda.api.events.guild.scheduledevent.update.GenericScheduledEventUpdateEvent;

public class ScheduledEventUpdateEndTimeEvent
extends GenericScheduledEventUpdateEvent<OffsetDateTime> {
    public static final String IDENTIFIER = "end_time";

    public ScheduledEventUpdateEndTimeEvent(@Nonnull JDA api2, long responseNumber, @Nonnull ScheduledEvent scheduledEvent, @Nullable OffsetDateTime previous) {
        super(api2, responseNumber, scheduledEvent, previous, scheduledEvent.getEndTime(), IDENTIFIER);
    }

    @Nullable
    public OffsetDateTime getOldEndTime() {
        return (OffsetDateTime)this.getOldValue();
    }

    @Nullable
    public OffsetDateTime getNewEndTime() {
        return (OffsetDateTime)this.getNewValue();
    }
}

