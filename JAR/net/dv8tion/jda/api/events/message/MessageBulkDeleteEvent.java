/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.message;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.middleman.GuildMessageChannel;
import net.dv8tion.jda.api.entities.channel.unions.GuildMessageChannelUnion;
import net.dv8tion.jda.api.events.Event;

public class MessageBulkDeleteEvent
extends Event {
    protected final GuildMessageChannel channel;
    protected final List<String> messageIds;

    public MessageBulkDeleteEvent(@Nonnull JDA api2, long responseNumber, @Nonnull GuildMessageChannel channel, @Nonnull List<String> messageIds) {
        super(api2, responseNumber);
        this.channel = channel;
        this.messageIds = Collections.unmodifiableList(messageIds);
    }

    @Nonnull
    public GuildMessageChannelUnion getChannel() {
        return (GuildMessageChannelUnion)this.channel;
    }

    @Nonnull
    public Guild getGuild() {
        return this.channel.getGuild();
    }

    @Nonnull
    public List<String> getMessageIds() {
        return this.messageIds;
    }
}

