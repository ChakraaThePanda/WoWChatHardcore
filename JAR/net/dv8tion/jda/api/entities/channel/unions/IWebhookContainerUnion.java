/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities.channel.unions;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.channel.attribute.IThreadContainer;
import net.dv8tion.jda.api.entities.channel.attribute.IWebhookContainer;
import net.dv8tion.jda.api.entities.channel.concrete.ForumChannel;
import net.dv8tion.jda.api.entities.channel.concrete.MediaChannel;
import net.dv8tion.jda.api.entities.channel.concrete.NewsChannel;
import net.dv8tion.jda.api.entities.channel.concrete.StageChannel;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.entities.channel.middleman.GuildMessageChannel;
import net.dv8tion.jda.api.entities.channel.middleman.StandardGuildChannel;
import net.dv8tion.jda.api.entities.channel.middleman.StandardGuildMessageChannel;

public interface IWebhookContainerUnion
extends IWebhookContainer {
    @Nonnull
    public TextChannel asTextChannel();

    @Nonnull
    public NewsChannel asNewsChannel();

    @Nonnull
    public ForumChannel asForumChannel();

    @Nonnull
    public MediaChannel asMediaChannel();

    @Nonnull
    public IThreadContainer asThreadContainer();

    @Nonnull
    public VoiceChannel asVoiceChannel();

    @Nonnull
    public StageChannel asStageChannel();

    @Nonnull
    public GuildMessageChannel asGuildMessageChannel();

    @Nonnull
    public StandardGuildChannel asStandardGuildChannel();

    @Nonnull
    public StandardGuildMessageChannel asStandardGuildMessageChannel();

    @Nonnull
    public AudioChannel asAudioChannel();
}

