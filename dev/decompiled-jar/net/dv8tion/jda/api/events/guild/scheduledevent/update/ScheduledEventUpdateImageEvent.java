/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.guild.scheduledevent.update;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.ScheduledEvent;
import net.dv8tion.jda.api.events.guild.scheduledevent.update.GenericScheduledEventUpdateEvent;

public class ScheduledEventUpdateImageEvent
extends GenericScheduledEventUpdateEvent<String> {
    public static final String IDENTIFIER = "image";

    public ScheduledEventUpdateImageEvent(@Nonnull JDA api2, long responseNumber, @Nonnull ScheduledEvent scheduledEvent, @Nonnull String previous) {
        super(api2, responseNumber, scheduledEvent, previous, scheduledEvent.getImageUrl(), IDENTIFIER);
    }

    @Nonnull
    public String getOldImageUrl() {
        return this.getOldValue();
    }

    @Nonnull
    public String getNewImageUrl() {
        return this.getNewValue();
    }

    @Override
    @Nonnull
    public String getOldValue() {
        return (String)super.getOldValue();
    }

    @Override
    @Nonnull
    public String getNewValue() {
        return (String)super.getNewValue();
    }
}

