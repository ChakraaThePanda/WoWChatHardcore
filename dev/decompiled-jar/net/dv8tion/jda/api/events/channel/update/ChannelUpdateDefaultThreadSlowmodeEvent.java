/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.channel.update;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.entities.channel.ChannelField;
import net.dv8tion.jda.api.events.channel.update.GenericChannelUpdateEvent;

public class ChannelUpdateDefaultThreadSlowmodeEvent
extends GenericChannelUpdateEvent<Integer> {
    public static final ChannelField FIELD = ChannelField.DEFAULT_THREAD_SLOWMODE;
    public static final String IDENTIFIER = FIELD.getFieldName();

    public ChannelUpdateDefaultThreadSlowmodeEvent(@Nonnull JDA api2, long responseNumber, @Nonnull Channel channel, int oldValue, int newValue) {
        super(api2, responseNumber, channel, FIELD, oldValue, newValue);
    }

    @Override
    @Nonnull
    public Integer getOldValue() {
        return (Integer)super.getOldValue();
    }

    @Override
    @Nonnull
    public Integer getNewValue() {
        return (Integer)super.getNewValue();
    }
}

