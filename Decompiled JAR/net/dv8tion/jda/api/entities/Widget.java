/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities;

import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.IMentionable;
import net.dv8tion.jda.api.entities.ISnowflake;
import net.dv8tion.jda.api.utils.ImageProxy;

public interface Widget
extends ISnowflake {
    public boolean isAvailable();

    @Nonnull
    public String getName();

    @Nullable
    public String getInviteCode();

    @Nonnull
    public List<VoiceChannel> getVoiceChannels();

    @Nullable
    public VoiceChannel getVoiceChannelById(@Nonnull String var1);

    @Nullable
    public VoiceChannel getVoiceChannelById(long var1);

    @Nonnull
    public List<Member> getMembers();

    @Nullable
    public Member getMemberById(@Nonnull String var1);

    @Nullable
    public Member getMemberById(long var1);

    public static interface VoiceState {
        @Nullable
        public VoiceChannel getChannel();

        public boolean inVoiceChannel();

        public boolean isGuildMuted();

        public boolean isGuildDeafened();

        public boolean isSuppressed();

        public boolean isSelfMuted();

        public boolean isSelfDeafened();

        public boolean isMuted();

        public boolean isDeafened();

        @Nonnull
        public Member getMember();

        @Nonnull
        public Widget getWidget();
    }

    public static interface VoiceChannel
    extends ISnowflake {
        public int getPosition();

        @Nonnull
        public String getName();

        @Nonnull
        public List<Member> getMembers();

        @Nonnull
        public Widget getWidget();
    }

    public static interface Member
    extends IMentionable {
        public boolean isBot();

        @Nonnull
        public String getName();

        @Nonnull
        public String getDiscriminator();

        @Nullable
        public String getAvatarId();

        @Nullable
        public String getAvatarUrl();

        @Nullable
        public ImageProxy getAvatar();

        @Nonnull
        public String getDefaultAvatarId();

        @Nonnull
        public String getDefaultAvatarUrl();

        @Nonnull
        public ImageProxy getDefaultAvatar();

        @Nonnull
        public String getEffectiveAvatarUrl();

        @Nonnull
        public ImageProxy getEffectiveAvatar();

        @Nullable
        public String getNickname();

        @Nonnull
        public String getEffectiveName();

        @Nonnull
        public OnlineStatus getOnlineStatus();

        @Nullable
        public Activity getActivity();

        @Nonnull
        public VoiceState getVoiceState();

        @Nonnull
        public Widget getWidget();
    }
}

