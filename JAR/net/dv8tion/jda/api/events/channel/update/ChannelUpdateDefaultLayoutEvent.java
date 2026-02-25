/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.channel.update;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.entities.channel.ChannelField;
import net.dv8tion.jda.api.entities.channel.concrete.ForumChannel;
import net.dv8tion.jda.api.events.channel.update.GenericChannelUpdateEvent;

public class ChannelUpdateDefaultLayoutEvent
extends GenericChannelUpdateEvent<ForumChannel.Layout> {
    public static final ChannelField FIELD = ChannelField.DEFAULT_FORUM_LAYOUT;
    public static final String IDENTIFIER = FIELD.getFieldName();

    public ChannelUpdateDefaultLayoutEvent(@Nonnull JDA api2, long responseNumber, @Nonnull Channel channel, @Nonnull ForumChannel.Layout oldValue, @Nonnull ForumChannel.Layout newValue) {
        super(api2, responseNumber, channel, ChannelField.DEFAULT_FORUM_LAYOUT, oldValue, newValue);
    }

    @Override
    @Nonnull
    public ForumChannel.Layout getOldValue() {
        return (ForumChannel.Layout)((Object)super.getOldValue());
    }

    @Override
    @Nonnull
    public ForumChannel.Layout getNewValue() {
        return (ForumChannel.Layout)((Object)super.getNewValue());
    }
}

