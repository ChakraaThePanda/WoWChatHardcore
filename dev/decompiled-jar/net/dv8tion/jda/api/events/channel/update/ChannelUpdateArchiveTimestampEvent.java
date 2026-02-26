/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.channel.update;

import java.time.OffsetDateTime;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.entities.channel.ChannelField;
import net.dv8tion.jda.api.events.channel.update.GenericChannelUpdateEvent;
import net.dv8tion.jda.internal.utils.Helpers;

public class ChannelUpdateArchiveTimestampEvent
extends GenericChannelUpdateEvent<OffsetDateTime> {
    public static final ChannelField FIELD = ChannelField.ARCHIVED_TIMESTAMP;
    public static final String IDENTIFIER = FIELD.getFieldName();
    private final long oldTimestamp;
    private final long newTimestamp;

    public ChannelUpdateArchiveTimestampEvent(@Nonnull JDA api2, long responseNumber, Channel channel, long oldValue, long newValue) {
        super(api2, responseNumber, channel, FIELD, null, null);
        this.oldTimestamp = oldValue;
        this.newTimestamp = newValue;
    }

    @Override
    @Nonnull
    public OffsetDateTime getOldValue() {
        return Helpers.toOffset(this.oldTimestamp);
    }

    @Override
    @Nonnull
    public OffsetDateTime getNewValue() {
        return Helpers.toOffset(this.newTimestamp);
    }
}

