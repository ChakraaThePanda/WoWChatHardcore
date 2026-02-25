/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.requests.restaction.pagination;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.ThreadChannel;
import net.dv8tion.jda.api.entities.channel.unions.IThreadContainerUnion;
import net.dv8tion.jda.api.requests.restaction.pagination.PaginationAction;

public interface ThreadChannelPaginationAction
extends PaginationAction<ThreadChannel, ThreadChannelPaginationAction> {
    @Nonnull
    public IThreadContainerUnion getChannel();

    @Nonnull
    default public Guild getGuild() {
        return this.getChannel().getGuild();
    }
}

