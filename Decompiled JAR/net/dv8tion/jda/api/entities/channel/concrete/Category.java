/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.Unmodifiable
 */
package net.dv8tion.jda.api.entities.channel.concrete;

import java.util.Collection;
import java.util.List;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.attribute.ICategorizableChannel;
import net.dv8tion.jda.api.entities.channel.attribute.ICopyableChannel;
import net.dv8tion.jda.api.entities.channel.attribute.IMemberContainer;
import net.dv8tion.jda.api.entities.channel.attribute.IPermissionContainer;
import net.dv8tion.jda.api.entities.channel.attribute.IPositionableChannel;
import net.dv8tion.jda.api.entities.channel.concrete.ForumChannel;
import net.dv8tion.jda.api.entities.channel.concrete.MediaChannel;
import net.dv8tion.jda.api.entities.channel.concrete.NewsChannel;
import net.dv8tion.jda.api.entities.channel.concrete.StageChannel;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.managers.channel.concrete.CategoryManager;
import net.dv8tion.jda.api.requests.restaction.ChannelAction;
import net.dv8tion.jda.api.requests.restaction.order.CategoryOrderAction;
import net.dv8tion.jda.internal.utils.Helpers;
import org.jetbrains.annotations.Unmodifiable;

public interface Category
extends GuildChannel,
ICopyableChannel,
IPositionableChannel,
IPermissionContainer,
IMemberContainer {
    @Nonnull
    default public @Unmodifiable List<GuildChannel> getChannels() {
        return this.getGuild().getChannelCache().ofType(ICategorizableChannel.class).applyStream(stream -> stream.filter(it -> this.equals(it.getParentCategory())).sorted().collect(Helpers.toUnmodifiableList()));
    }

    @Nonnull
    default public @Unmodifiable List<TextChannel> getTextChannels() {
        return this.getGuild().getTextChannelCache().applyStream(stream -> stream.filter(channel -> this.equals(channel.getParentCategory())).sorted().collect(Helpers.toUnmodifiableList()));
    }

    @Nonnull
    default public @Unmodifiable List<NewsChannel> getNewsChannels() {
        return this.getGuild().getNewsChannelCache().applyStream(stream -> stream.filter(channel -> this.equals(channel.getParentCategory())).sorted().collect(Helpers.toUnmodifiableList()));
    }

    @Nonnull
    default public @Unmodifiable List<ForumChannel> getForumChannels() {
        return this.getGuild().getForumChannelCache().applyStream(stream -> stream.filter(channel -> this.equals(channel.getParentCategory())).sorted().collect(Helpers.toUnmodifiableList()));
    }

    @Nonnull
    default public @Unmodifiable List<MediaChannel> getMediaChannels() {
        return this.getGuild().getMediaChannelCache().applyStream(stream -> stream.filter(channel -> this.equals(channel.getParentCategory())).sorted().collect(Helpers.toUnmodifiableList()));
    }

    @Nonnull
    default public @Unmodifiable List<VoiceChannel> getVoiceChannels() {
        return this.getGuild().getVoiceChannelCache().applyStream(stream -> stream.filter(channel -> this.equals(channel.getParentCategory())).sorted().collect(Helpers.toUnmodifiableList()));
    }

    @Nonnull
    default public @Unmodifiable List<StageChannel> getStageChannels() {
        return this.getGuild().getStageChannelCache().applyStream(stream -> stream.filter(channel -> this.equals(channel.getParentCategory())).sorted().collect(Helpers.toUnmodifiableList()));
    }

    @Nonnull
    @CheckReturnValue
    public ChannelAction<TextChannel> createTextChannel(@Nonnull String var1);

    @Nonnull
    @CheckReturnValue
    public ChannelAction<NewsChannel> createNewsChannel(@Nonnull String var1);

    @Nonnull
    @CheckReturnValue
    public ChannelAction<VoiceChannel> createVoiceChannel(@Nonnull String var1);

    @Nonnull
    @CheckReturnValue
    public ChannelAction<StageChannel> createStageChannel(@Nonnull String var1);

    @Nonnull
    @CheckReturnValue
    public ChannelAction<ForumChannel> createForumChannel(@Nonnull String var1);

    @Nonnull
    @CheckReturnValue
    public ChannelAction<MediaChannel> createMediaChannel(@Nonnull String var1);

    @Nonnull
    @CheckReturnValue
    public CategoryOrderAction modifyTextChannelPositions();

    @Nonnull
    @CheckReturnValue
    public CategoryOrderAction modifyVoiceChannelPositions();

    @Override
    @Nonnull
    default public @Unmodifiable List<Member> getMembers() {
        return this.getChannels().stream().filter(IMemberContainer.class::isInstance).map(IMemberContainer.class::cast).map(IMemberContainer::getMembers).flatMap(Collection::stream).distinct().collect(Helpers.toUnmodifiableList());
    }

    @Nonnull
    @CheckReturnValue
    public ChannelAction<Category> createCopy(@Nonnull Guild var1);

    @Nonnull
    @CheckReturnValue
    public ChannelAction<Category> createCopy();

    @Override
    @Nonnull
    @CheckReturnValue
    public CategoryManager getManager();
}

