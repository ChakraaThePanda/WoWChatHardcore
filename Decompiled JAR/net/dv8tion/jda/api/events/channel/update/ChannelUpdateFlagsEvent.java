/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.channel.update;

import java.util.EnumSet;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.entities.channel.ChannelField;
import net.dv8tion.jda.api.entities.channel.ChannelFlag;
import net.dv8tion.jda.api.events.channel.update.GenericChannelUpdateEvent;

public class ChannelUpdateFlagsEvent
extends GenericChannelUpdateEvent<EnumSet<ChannelFlag>> {
    public static final ChannelField FIELD = ChannelField.FLAGS;
    public static final String IDENTIFIER = FIELD.getFieldName();

    public ChannelUpdateFlagsEvent(@Nonnull JDA api2, long responseNumber, @Nonnull Channel channel, @Nonnull EnumSet<ChannelFlag> oldValue, @Nonnull EnumSet<ChannelFlag> newValue) {
        super(api2, responseNumber, channel, FIELD, oldValue, newValue);
    }

    @Override
    @Nonnull
    public EnumSet<ChannelFlag> getOldValue() {
        return (EnumSet)super.getOldValue();
    }

    @Override
    @Nonnull
    public EnumSet<ChannelFlag> getNewValue() {
        return (EnumSet)super.getNewValue();
    }
}

