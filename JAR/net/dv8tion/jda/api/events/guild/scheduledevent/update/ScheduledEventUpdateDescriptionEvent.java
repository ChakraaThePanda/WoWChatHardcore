/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.guild.scheduledevent.update;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.ScheduledEvent;
import net.dv8tion.jda.api.events.guild.scheduledevent.update.GenericScheduledEventUpdateEvent;

public class ScheduledEventUpdateDescriptionEvent
extends GenericScheduledEventUpdateEvent<String> {
    public static final String IDENTIFIER = "description";

    public ScheduledEventUpdateDescriptionEvent(@Nonnull JDA api2, long responseNumber, @Nonnull ScheduledEvent scheduledEvent, @Nullable String previous) {
        super(api2, responseNumber, scheduledEvent, previous, scheduledEvent.getDescription(), IDENTIFIER);
    }

    @Nullable
    public String getOldDescription() {
        return (String)this.getOldValue();
    }

    @Nullable
    public String getNewDescription() {
        return (String)this.getNewValue();
    }
}

