/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.channel;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.events.channel.GenericChannelEvent;

public class ChannelCreateEvent
extends GenericChannelEvent {
    public ChannelCreateEvent(@Nonnull JDA api2, long responseNumber, Channel channel) {
        super(api2, responseNumber, channel);
    }
}

