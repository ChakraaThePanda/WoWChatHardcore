/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities;

import java.util.Collection;
import java.util.EnumSet;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.ISnowflake;
import net.dv8tion.jda.api.entities.channel.attribute.IPermissionContainer;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.internal.utils.Checks;

public interface IPermissionHolder
extends ISnowflake {
    @Nonnull
    public Guild getGuild();

    @Nonnull
    public EnumSet<Permission> getPermissions();

    @Nonnull
    public EnumSet<Permission> getPermissions(@Nonnull GuildChannel var1);

    @Nonnull
    public EnumSet<Permission> getPermissionsExplicit();

    @Nonnull
    public EnumSet<Permission> getPermissionsExplicit(@Nonnull GuildChannel var1);

    public boolean hasPermission(Permission ... var1);

    default public boolean hasPermission(@Nonnull Collection<Permission> permissions) {
        Checks.notNull(permissions, "Permission Collection");
        return this.hasPermission(permissions.toArray(Permission.EMPTY_PERMISSIONS));
    }

    public boolean hasPermission(@Nonnull GuildChannel var1, Permission ... var2);

    default public boolean hasPermission(@Nonnull GuildChannel channel, @Nonnull Collection<Permission> permissions) {
        Checks.notNull(permissions, "Permission Collection");
        return this.hasPermission(channel, permissions.toArray(Permission.EMPTY_PERMISSIONS));
    }

    default public boolean hasAccess(@Nonnull GuildChannel channel) {
        Checks.notNull(channel, "Channel");
        return channel.getType().isAudio() ? this.hasPermission(channel, Permission.VOICE_CONNECT, Permission.VIEW_CHANNEL) : this.hasPermission(channel, Permission.VIEW_CHANNEL);
    }

    public boolean canSync(@Nonnull IPermissionContainer var1, @Nonnull IPermissionContainer var2);

    public boolean canSync(@Nonnull IPermissionContainer var1);
}

