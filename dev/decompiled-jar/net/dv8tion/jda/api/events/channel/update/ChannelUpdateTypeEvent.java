/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.channel.update;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.entities.channel.ChannelField;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.events.channel.update.GenericChannelUpdateEvent;

public class ChannelUpdateTypeEvent
extends GenericChannelUpdateEvent<ChannelType> {
    public static final ChannelField FIELD = ChannelField.TYPE;
    public static final String IDENTIFIER = FIELD.getFieldName();

    public ChannelUpdateTypeEvent(@Nonnull JDA api2, long responseNumber, Channel channel, ChannelType oldValue, ChannelType newValue) {
        super(api2, responseNumber, channel, FIELD, oldValue, newValue);
    }
}

