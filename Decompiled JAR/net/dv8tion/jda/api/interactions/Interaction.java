/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.interactions;

import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Entitlement;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.ISnowflake;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.interactions.DiscordLocale;
import net.dv8tion.jda.api.interactions.IntegrationOwners;
import net.dv8tion.jda.api.interactions.InteractionContextType;
import net.dv8tion.jda.api.interactions.InteractionType;
import net.dv8tion.jda.internal.utils.ChannelUtil;

public interface Interaction
extends ISnowflake {
    public int getTypeRaw();

    @Nonnull
    default public InteractionType getType() {
        return InteractionType.fromKey(this.getTypeRaw());
    }

    @Nonnull
    public String getToken();

    @Nullable
    public Guild getGuild();

    default public boolean isFromAttachedGuild() {
        Guild guild = this.getGuild();
        if (guild == null) {
            return false;
        }
        return !guild.isDetached();
    }

    default public boolean isFromGuild() {
        return this.getGuild() != null;
    }

    @Nonnull
    default public ChannelType getChannelType() {
        Channel channel = this.getChannel();
        return channel != null ? channel.getType() : ChannelType.UNKNOWN;
    }

    @Nonnull
    public User getUser();

    @Nullable
    public Member getMember();

    public boolean isAcknowledged();

    @Nullable
    public Channel getChannel();

    public long getChannelIdLong();

    @Nullable
    default public String getChannelId() {
        long id = this.getChannelIdLong();
        return id != 0L ? Long.toUnsignedString(this.getChannelIdLong()) : null;
    }

    @Nonnull
    default public GuildChannel getGuildChannel() {
        return ChannelUtil.safeChannelCast(this.getChannel(), GuildChannel.class);
    }

    @Nonnull
    default public MessageChannel getMessageChannel() {
        return ChannelUtil.safeChannelCast(this.getChannel(), MessageChannel.class);
    }

    @Nonnull
    public DiscordLocale getUserLocale();

    @Nonnull
    default public DiscordLocale getGuildLocale() {
        if (!this.isFromGuild()) {
            throw new IllegalStateException("This interaction did not happen in a guild");
        }
        return this.getGuild().getLocale();
    }

    @Nonnull
    public List<Entitlement> getEntitlements();

    @Nonnull
    public InteractionContextType getContext();

    @Nonnull
    public IntegrationOwners getIntegrationOwners();

    @Nonnull
    public JDA getJDA();
}

