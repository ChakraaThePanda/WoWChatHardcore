/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.entities.channel.mixin.concrete;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.Region;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.PermissionOverride;
import net.dv8tion.jda.api.entities.channel.concrete.Category;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.requests.restaction.ChannelAction;
import net.dv8tion.jda.internal.entities.channel.mixin.attribute.IAgeRestrictedChannelMixin;
import net.dv8tion.jda.internal.entities.channel.mixin.attribute.ISlowmodeChannelMixin;
import net.dv8tion.jda.internal.entities.channel.mixin.attribute.IWebhookContainerMixin;
import net.dv8tion.jda.internal.entities.channel.mixin.middleman.AudioChannelMixin;
import net.dv8tion.jda.internal.entities.channel.mixin.middleman.GuildMessageChannelMixin;
import net.dv8tion.jda.internal.utils.Checks;

public interface VoiceChannelMixin<T extends VoiceChannelMixin<T>>
extends VoiceChannel,
GuildMessageChannelMixin<T>,
AudioChannelMixin<T>,
IWebhookContainerMixin<T>,
IAgeRestrictedChannelMixin<T>,
ISlowmodeChannelMixin<T> {
    @Override
    default public boolean canTalk(@Nonnull Member member) {
        Checks.notNull(member, "Member");
        return member.hasPermission((GuildChannel)this, Permission.MESSAGE_SEND);
    }

    @Override
    @Nonnull
    default public ChannelAction<VoiceChannel> createCopy(@Nonnull Guild guild) {
        Checks.notNull(guild, "Guild");
        ChannelAction<VoiceChannel> action = guild.createVoiceChannel(this.getName()).setBitrate(this.getBitrate()).setUserlimit(this.getUserLimit());
        if (this.getRegionRaw() != null) {
            action.setRegion(Region.fromKey(this.getRegionRaw()));
        }
        if (guild.equals(this.getGuild())) {
            Category parent = this.getParentCategory();
            if (parent != null) {
                action.setParent(parent);
            }
            for (PermissionOverride o : this.getPermissionOverrideMap().valueCollection()) {
                if (o.isMemberOverride()) {
                    action.addMemberPermissionOverride(o.getIdLong(), o.getAllowedRaw(), o.getDeniedRaw());
                    continue;
                }
                action.addRolePermissionOverride(o.getIdLong(), o.getAllowedRaw(), o.getDeniedRaw());
            }
        }
        return action;
    }

    public T setStatus(String var1);
}

