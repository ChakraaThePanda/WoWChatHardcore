/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities.channel.unions;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.channel.attribute.IThreadContainer;
import net.dv8tion.jda.api.entities.channel.concrete.GroupChannel;
import net.dv8tion.jda.api.entities.channel.concrete.NewsChannel;
import net.dv8tion.jda.api.entities.channel.concrete.PrivateChannel;
import net.dv8tion.jda.api.entities.channel.concrete.StageChannel;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.concrete.ThreadChannel;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.entities.channel.middleman.GuildMessageChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

public interface MessageChannelUnion
extends MessageChannel {
    @Nonnull
    public PrivateChannel asPrivateChannel();

    @Nonnull
    public GroupChannel asGroupChannel();

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
    public IThreadContainer asThreadContainer();

    @Nonnull
    public GuildMessageChannel asGuildMessageChannel();

    @Nonnull
    public AudioChannel asAudioChannel();
}

