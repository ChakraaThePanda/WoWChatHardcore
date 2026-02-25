/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities;

import java.time.OffsetDateTime;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.ISnowflake;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.unions.AudioChannelUnion;
import net.dv8tion.jda.api.requests.RestAction;

public interface GuildVoiceState
extends ISnowflake {
    @Nonnull
    public JDA getJDA();

    public boolean isSelfMuted();

    public boolean isSelfDeafened();

    public boolean isMuted();

    public boolean isDeafened();

    public boolean isGuildMuted();

    public boolean isGuildDeafened();

    public boolean isSuppressed();

    public boolean isStream();

    public boolean isSendingVideo();

    @Nullable
    public AudioChannelUnion getChannel();

    @Nonnull
    public Guild getGuild();

    @Nonnull
    public Member getMember();

    public boolean inAudioChannel();

    @Nullable
    public String getSessionId();

    @Nullable
    public OffsetDateTime getRequestToSpeakTimestamp();

    @Nonnull
    @CheckReturnValue
    public RestAction<Void> approveSpeaker();

    @Nonnull
    @CheckReturnValue
    public RestAction<Void> declineSpeaker();

    @Nonnull
    @CheckReturnValue
    public RestAction<Void> inviteSpeaker();
}

