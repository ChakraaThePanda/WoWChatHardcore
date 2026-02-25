/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.guild.scheduledevent;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.ScheduledEvent;
import net.dv8tion.jda.api.events.guild.scheduledevent.GenericScheduledEventUserEvent;

public class ScheduledEventUserAddEvent
extends GenericScheduledEventUserEvent {
    public ScheduledEventUserAddEvent(@Nonnull JDA api2, long responseNumber, @Nonnull ScheduledEvent scheduledEvent, long userId) {
        super(api2, responseNumber, scheduledEvent, userId);
    }
}

