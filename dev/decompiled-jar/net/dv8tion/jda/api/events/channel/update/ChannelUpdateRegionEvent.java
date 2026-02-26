/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.channel.update;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.Region;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.entities.channel.ChannelField;
import net.dv8tion.jda.api.events.channel.update.GenericChannelUpdateEvent;

public class ChannelUpdateRegionEvent
extends GenericChannelUpdateEvent<Region> {
    public static final ChannelField FIELD = ChannelField.REGION;
    public static final String IDENTIFIER = FIELD.getFieldName();

    public ChannelUpdateRegionEvent(@Nonnull JDA api2, long responseNumber, Channel channel, Region oldValue, Region newValue) {
        super(api2, responseNumber, channel, FIELD, oldValue, newValue);
    }
}

