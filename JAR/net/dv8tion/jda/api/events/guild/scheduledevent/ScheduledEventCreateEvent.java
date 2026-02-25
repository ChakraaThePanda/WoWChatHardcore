/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.guild.scheduledevent;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.ScheduledEvent;
import net.dv8tion.jda.api.events.guild.scheduledevent.GenericScheduledEventGatewayEvent;

public class ScheduledEventCreateEvent
extends GenericScheduledEventGatewayEvent {
    public ScheduledEventCreateEvent(@Nonnull JDA api2, long responseNumber, @Nonnull ScheduledEvent scheduledEvent) {
        super(api2, responseNumber, scheduledEvent);
    }
}

