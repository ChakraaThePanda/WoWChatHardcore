/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.guild.scheduledevent.update;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.ScheduledEvent;
import net.dv8tion.jda.api.events.guild.scheduledevent.update.GenericScheduledEventUpdateEvent;

public class ScheduledEventUpdateStatusEvent
extends GenericScheduledEventUpdateEvent<ScheduledEvent.Status> {
    public static final String IDENTIFIER = "status";

    public ScheduledEventUpdateStatusEvent(@Nonnull JDA api2, long responseNumber, @Nonnull ScheduledEvent scheduledEvent, @Nonnull ScheduledEvent.Status previous) {
        super(api2, responseNumber, scheduledEvent, previous, scheduledEvent.getStatus(), IDENTIFIER);
    }

    @Nonnull
    public ScheduledEvent.Status getOldStatus() {
        return this.getOldValue();
    }

    @Nonnull
    public ScheduledEvent.Status getNewStatus() {
        return this.getNewValue();
    }

    @Override
    @Nonnull
    public ScheduledEvent.Status getOldValue() {
        return (ScheduledEvent.Status)((Object)super.getOldValue());
    }

    @Override
    @Nonnull
    public ScheduledEvent.Status getNewValue() {
        return (ScheduledEvent.Status)((Object)super.getNewValue());
    }
}

