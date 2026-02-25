/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.channel.update;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.entities.channel.ChannelField;
import net.dv8tion.jda.api.entities.channel.concrete.Category;
import net.dv8tion.jda.api.events.channel.update.GenericChannelUpdateEvent;

public class ChannelUpdateParentEvent
extends GenericChannelUpdateEvent<Category> {
    public static final ChannelField FIELD = ChannelField.PARENT;
    public static final String IDENTIFIER = FIELD.getFieldName();

    public ChannelUpdateParentEvent(@Nonnull JDA api2, long responseNumber, Channel channel, Category oldValue, Category newValue) {
        super(api2, responseNumber, channel, FIELD, oldValue, newValue);
    }
}

