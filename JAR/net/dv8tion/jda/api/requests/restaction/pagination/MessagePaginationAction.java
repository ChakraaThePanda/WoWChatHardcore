/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.requests.restaction.pagination;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.requests.restaction.pagination.PaginationAction;

public interface MessagePaginationAction
extends PaginationAction<Message, MessagePaginationAction> {
    @Nonnull
    default public ChannelType getType() {
        return this.getChannel().getType();
    }

    @Nonnull
    public MessageChannelUnion getChannel();
}

