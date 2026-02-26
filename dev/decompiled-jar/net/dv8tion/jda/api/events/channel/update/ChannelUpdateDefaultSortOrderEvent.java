/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.channel.update;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.ChannelField;
import net.dv8tion.jda.api.entities.channel.attribute.IPostContainer;
import net.dv8tion.jda.api.events.channel.update.GenericChannelUpdateEvent;

public class ChannelUpdateDefaultSortOrderEvent
extends GenericChannelUpdateEvent<IPostContainer.SortOrder> {
    public static final ChannelField FIELD = ChannelField.DEFAULT_SORT_ORDER;
    public static final String IDENTIFIER = FIELD.getFieldName();

    public ChannelUpdateDefaultSortOrderEvent(@Nonnull JDA api2, long responseNumber, IPostContainer channel, IPostContainer.SortOrder oldValue) {
        super(api2, responseNumber, channel, ChannelField.DEFAULT_SORT_ORDER, oldValue, channel.getDefaultSortOrder());
    }

    @Override
    @Nonnull
    public IPostContainer.SortOrder getOldValue() {
        return (IPostContainer.SortOrder)((Object)super.getOldValue());
    }

    @Override
    @Nonnull
    public IPostContainer.SortOrder getNewValue() {
        return (IPostContainer.SortOrder)((Object)super.getNewValue());
    }
}

