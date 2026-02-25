/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.channel.update;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.entities.channel.ChannelField;
import net.dv8tion.jda.api.events.UpdateEvent;
import net.dv8tion.jda.api.events.channel.GenericChannelEvent;

public class GenericChannelUpdateEvent<T>
extends GenericChannelEvent
implements UpdateEvent<Channel, T> {
    protected final ChannelField channelField;
    protected final T oldValue;
    protected final T newValue;

    public GenericChannelUpdateEvent(@Nonnull JDA api2, long responseNumber, Channel channel, ChannelField channelField, T oldValue, T newValue) {
        super(api2, responseNumber, channel);
        this.channelField = channelField;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    @Override
    @Nonnull
    public String getPropertyIdentifier() {
        return this.channelField.getFieldName();
    }

    @Override
    @Nonnull
    public Channel getEntity() {
        return this.getChannel();
    }

    @Override
    @Nullable
    public T getOldValue() {
        return this.oldValue;
    }

    @Override
    @Nullable
    public T getNewValue() {
        return this.newValue;
    }
}

