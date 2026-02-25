/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.channel.update;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.entities.channel.ChannelField;
import net.dv8tion.jda.api.entities.channel.concrete.ThreadChannel;
import net.dv8tion.jda.api.events.channel.update.GenericChannelUpdateEvent;

public class ChannelUpdateAutoArchiveDurationEvent
extends GenericChannelUpdateEvent<ThreadChannel.AutoArchiveDuration> {
    public static final ChannelField FIELD = ChannelField.AUTO_ARCHIVE_DURATION;
    public static final String IDENTIFIER = FIELD.getFieldName();

    public ChannelUpdateAutoArchiveDurationEvent(@Nonnull JDA api2, long responseNumber, Channel channel, ThreadChannel.AutoArchiveDuration oldValue, ThreadChannel.AutoArchiveDuration newValue) {
        super(api2, responseNumber, channel, FIELD, oldValue, newValue);
    }
}

