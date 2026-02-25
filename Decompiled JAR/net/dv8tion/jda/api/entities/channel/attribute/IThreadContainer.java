/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.Unmodifiable
 */
package net.dv8tion.jda.api.entities.channel.attribute;

import java.util.List;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.channel.attribute.IPermissionContainer;
import net.dv8tion.jda.api.entities.channel.concrete.ThreadChannel;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.requests.restaction.ThreadChannelAction;
import net.dv8tion.jda.api.requests.restaction.pagination.ThreadChannelPaginationAction;
import net.dv8tion.jda.api.utils.MiscUtil;
import net.dv8tion.jda.internal.utils.Helpers;
import org.jetbrains.annotations.Unmodifiable;

public interface IThreadContainer
extends GuildChannel,
IPermissionContainer {
    public int getDefaultThreadSlowmode();

    @Nonnull
    default public @Unmodifiable List<ThreadChannel> getThreadChannels() {
        return this.getGuild().getThreadChannelCache().applyStream(stream -> stream.filter(thread2 -> thread2.getParentChannel() == this).collect(Helpers.toUnmodifiableList()));
    }

    @Nonnull
    @CheckReturnValue
    default public ThreadChannelAction createThreadChannel(@Nonnull String name) {
        return this.createThreadChannel(name, false);
    }

    @Nonnull
    @CheckReturnValue
    public ThreadChannelAction createThreadChannel(@Nonnull String var1, boolean var2);

    @Nonnull
    @CheckReturnValue
    public ThreadChannelAction createThreadChannel(@Nonnull String var1, long var2);

    @Nonnull
    @CheckReturnValue
    default public ThreadChannelAction createThreadChannel(@Nonnull String name, @Nonnull String messageId) {
        return this.createThreadChannel(name, MiscUtil.parseSnowflake(messageId));
    }

    @Nonnull
    @CheckReturnValue
    public ThreadChannelPaginationAction retrieveArchivedPublicThreadChannels();

    @Nonnull
    @CheckReturnValue
    public ThreadChannelPaginationAction retrieveArchivedPrivateThreadChannels();

    @Nonnull
    @CheckReturnValue
    public ThreadChannelPaginationAction retrieveArchivedPrivateJoinedThreadChannels();
}

