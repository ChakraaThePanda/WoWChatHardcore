/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities.channel.unions;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.channel.attribute.IThreadContainer;
import net.dv8tion.jda.api.entities.channel.concrete.Category;
import net.dv8tion.jda.api.entities.channel.concrete.ForumChannel;
import net.dv8tion.jda.api.entities.channel.concrete.MediaChannel;
import net.dv8tion.jda.api.entities.channel.concrete.NewsChannel;
import net.dv8tion.jda.api.entities.channel.concrete.StageChannel;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.concrete.ThreadChannel;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.entities.channel.middleman.GuildMessageChannel;
import net.dv8tion.jda.api.entities.channel.middleman.StandardGuildChannel;
import net.dv8tion.jda.api.entities.channel.middleman.StandardGuildMessageChannel;

public interface GuildChannelUnion
extends GuildChannel {
    @Nonnull
    public TextChannel asTextChannel();

    @Nonnull
    public NewsChannel asNewsChannel();

    @Nonnull
    public ThreadChannel asThreadChannel();

    @Nonnull
    public VoiceChannel asVoiceChannel();

    @Nonnull
    public StageChannel asStageChannel();

    @Nonnull
    public Category asCategory();

    @Nonnull
    public ForumChannel asForumChannel();

    @Nonnull
    public MediaChannel asMediaChannel();

    @Nonnull
    public GuildMessageChannel asGuildMessageChannel();

    @Nonnull
    public AudioChannel asAudioChannel();

    public IThreadContainer asThreadContainer();

    @Nonnull
    public StandardGuildChannel asStandardGuildChannel();

    @Nonnull
    public StandardGuildMessageChannel asStandardGuildMessageChannel();
}

