/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.entities.channel.mixin.middleman;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.entities.channel.middleman.StandardGuildMessageChannel;
import net.dv8tion.jda.internal.entities.channel.mixin.attribute.IAgeRestrictedChannelMixin;
import net.dv8tion.jda.internal.entities.channel.mixin.attribute.IThreadContainerMixin;
import net.dv8tion.jda.internal.entities.channel.mixin.attribute.ITopicChannelMixin;
import net.dv8tion.jda.internal.entities.channel.mixin.attribute.IWebhookContainerMixin;
import net.dv8tion.jda.internal.entities.channel.mixin.middleman.GuildMessageChannelMixin;
import net.dv8tion.jda.internal.entities.channel.mixin.middleman.StandardGuildChannelMixin;

public interface StandardGuildMessageChannelMixin<T extends StandardGuildMessageChannelMixin<T>>
extends StandardGuildMessageChannel,
StandardGuildChannelMixin<T>,
GuildMessageChannelMixin<T>,
IThreadContainerMixin<T>,
IAgeRestrictedChannelMixin<T>,
IWebhookContainerMixin<T>,
ITopicChannelMixin<T> {
    @Override
    default public boolean canTalk(@Nonnull Member member) {
        if (!this.getGuild().equals(member.getGuild())) {
            throw new IllegalArgumentException("Provided Member is not from the Guild that this channel is part of.");
        }
        return member.hasPermission((GuildChannel)this, Permission.VIEW_CHANNEL, Permission.MESSAGE_SEND);
    }
}

