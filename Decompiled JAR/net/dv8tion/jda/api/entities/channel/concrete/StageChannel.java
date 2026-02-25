/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities.channel.concrete;

import java.util.EnumSet;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.StageInstance;
import net.dv8tion.jda.api.entities.channel.attribute.IAgeRestrictedChannel;
import net.dv8tion.jda.api.entities.channel.attribute.ISlowmodeChannel;
import net.dv8tion.jda.api.entities.channel.attribute.IWebhookContainer;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.entities.channel.middleman.GuildMessageChannel;
import net.dv8tion.jda.api.entities.channel.middleman.StandardGuildChannel;
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;
import net.dv8tion.jda.api.managers.channel.concrete.StageChannelManager;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.requests.restaction.ChannelAction;
import net.dv8tion.jda.api.requests.restaction.StageInstanceAction;
import net.dv8tion.jda.internal.requests.restaction.StageInstanceActionImpl;
import net.dv8tion.jda.internal.utils.Checks;

public interface StageChannel
extends StandardGuildChannel,
GuildMessageChannel,
AudioChannel,
IWebhookContainer,
IAgeRestrictedChannel,
ISlowmodeChannel {
    public static final int MAX_USERLIMIT = 10000;

    @Nullable
    public StageInstance getStageInstance();

    @Nonnull
    @CheckReturnValue
    default public StageInstanceAction createStageInstance(@Nonnull String topic) {
        Checks.checkAttached(this);
        EnumSet<Permission> permissions = this.getGuild().getSelfMember().getPermissions(this);
        EnumSet<Permission> required = EnumSet.of(Permission.MANAGE_CHANNEL, Permission.VOICE_MUTE_OTHERS, Permission.VOICE_MOVE_OTHERS);
        for (Permission perm : required) {
            if (permissions.contains((Object)perm)) continue;
            throw new InsufficientPermissionException(this, perm, "You must be a stage moderator to create a stage instance! Missing Permission: " + (Object)((Object)perm));
        }
        return new StageInstanceActionImpl(this).setTopic(topic);
    }

    default public boolean isModerator(@Nonnull Member member) {
        Checks.notNull(member, "Member");
        return member.hasPermission((GuildChannel)this, Permission.MANAGE_CHANNEL, Permission.VOICE_MUTE_OTHERS, Permission.VOICE_MOVE_OTHERS);
    }

    @Nonnull
    @CheckReturnValue
    public ChannelAction<StageChannel> createCopy(@Nonnull Guild var1);

    @Nonnull
    @CheckReturnValue
    default public ChannelAction<StageChannel> createCopy() {
        return this.createCopy(this.getGuild());
    }

    @Override
    @Nonnull
    @CheckReturnValue
    public StageChannelManager getManager();

    @Nonnull
    @CheckReturnValue
    public RestAction<Void> requestToSpeak();

    @Nonnull
    @CheckReturnValue
    public RestAction<Void> cancelRequestToSpeak();
}

