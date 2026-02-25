/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities.channel.middleman;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.entities.channel.attribute.IPermissionContainer;
import net.dv8tion.jda.api.managers.channel.ChannelManager;
import net.dv8tion.jda.api.requests.restaction.AuditableRestAction;
import net.dv8tion.jda.internal.utils.Helpers;

public interface GuildChannel
extends Channel,
Comparable<GuildChannel> {
    public static final String JUMP_URL = "https://discord.com/channels/%s/%s";

    @Nonnull
    public Guild getGuild();

    @Nonnull
    @CheckReturnValue
    public ChannelManager<?, ?> getManager();

    @Nonnull
    @CheckReturnValue
    public AuditableRestAction<Void> delete();

    @Nonnull
    public IPermissionContainer getPermissionContainer();

    @Nonnull
    default public String getJumpUrl() {
        return Helpers.format(JUMP_URL, this.getGuild().getId(), this.getId());
    }
}

