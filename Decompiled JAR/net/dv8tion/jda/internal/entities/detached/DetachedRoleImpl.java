/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.entities.detached;

import java.awt.Color;
import java.util.EnumSet;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.RoleIcon;
import net.dv8tion.jda.api.entities.channel.attribute.IPermissionContainer;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.exceptions.DetachedEntityException;
import net.dv8tion.jda.api.managers.RoleManager;
import net.dv8tion.jda.api.requests.restaction.AuditableRestAction;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.JDAImpl;
import net.dv8tion.jda.internal.entities.RoleImpl;
import net.dv8tion.jda.internal.entities.detached.DetachedGuildImpl;
import net.dv8tion.jda.internal.entities.mixin.RoleMixin;
import net.dv8tion.jda.internal.utils.EntityString;
import net.dv8tion.jda.internal.utils.PermissionUtil;

public class DetachedRoleImpl
implements Role,
RoleMixin<DetachedRoleImpl> {
    private final long id;
    private final JDAImpl api;
    private final DetachedGuildImpl guild;
    private RoleImpl.RoleTagsImpl tags;
    private String name;
    private boolean managed;
    private boolean hoisted;
    private boolean mentionable;
    private long rawPermissions;
    private int color;
    private int rawPosition;
    private RoleIcon icon;

    public DetachedRoleImpl(long id, DetachedGuildImpl guild) {
        this.id = id;
        this.api = guild.getJDA();
        this.guild = guild;
        this.tags = this.api.isCacheFlagSet(CacheFlag.ROLE_TAGS) ? new RoleImpl.RoleTagsImpl() : null;
    }

    @Override
    public boolean isDetached() {
        return true;
    }

    @Override
    public int getPosition() {
        throw new DetachedEntityException("Cannot get the position of a detached role, only the raw position is available");
    }

    @Override
    public int getPositionRaw() {
        return this.rawPosition;
    }

    @Override
    @Nonnull
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isManaged() {
        return this.managed;
    }

    @Override
    public boolean isHoisted() {
        return this.hoisted;
    }

    @Override
    public boolean isMentionable() {
        return this.mentionable;
    }

    @Override
    public long getPermissionsRaw() {
        return this.rawPermissions;
    }

    @Override
    @Nonnull
    public EnumSet<Permission> getPermissions() {
        return Permission.getPermissions(this.rawPermissions);
    }

    @Override
    @Nonnull
    public EnumSet<Permission> getPermissions(@Nonnull GuildChannel channel) {
        throw this.detachedException();
    }

    @Override
    @Nonnull
    public EnumSet<Permission> getPermissionsExplicit() {
        return this.getPermissions();
    }

    @Override
    @Nonnull
    public EnumSet<Permission> getPermissionsExplicit(@Nonnull GuildChannel channel) {
        throw this.detachedException();
    }

    @Override
    public Color getColor() {
        return this.color != 0x1FFFFFFF ? new Color(this.color) : null;
    }

    @Override
    public int getColorRaw() {
        return this.color;
    }

    @Override
    public boolean isPublicRole() {
        return this.getIdLong() == this.getGuild().getIdLong();
    }

    @Override
    public boolean hasPermission(Permission ... permissions) {
        long effectivePerms = this.rawPermissions;
        for (Permission perm : permissions) {
            long rawValue = perm.getRawValue();
            if ((effectivePerms & rawValue) == rawValue) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean hasPermission(@Nonnull GuildChannel channel, Permission ... permissions) {
        throw this.detachedException();
    }

    @Override
    public boolean canSync(@Nonnull IPermissionContainer targetChannel, @Nonnull IPermissionContainer syncSource) {
        throw this.detachedException();
    }

    @Override
    public boolean canSync(@Nonnull IPermissionContainer channel) {
        throw this.detachedException();
    }

    @Override
    public boolean canInteract(@Nonnull Role role) {
        return PermissionUtil.canInteract(this, role);
    }

    @Override
    @Nonnull
    public Guild getGuild() {
        return this.guild;
    }

    @Override
    @Nonnull
    public RoleManager getManager() {
        throw this.detachedException();
    }

    @Override
    @Nonnull
    public AuditableRestAction<Void> delete() {
        throw this.detachedException();
    }

    @Override
    @Nonnull
    public JDA getJDA() {
        return this.api;
    }

    @Override
    @Nonnull
    public Role.RoleTags getTags() {
        return this.tags == null ? RoleImpl.RoleTagsImpl.EMPTY : this.tags;
    }

    @Override
    @Nullable
    public RoleIcon getIcon() {
        return this.icon;
    }

    @Override
    @Nonnull
    public String getAsMention() {
        return this.isPublicRole() ? "@everyone" : "<@&" + this.getId() + '>';
    }

    @Override
    public long getIdLong() {
        return this.id;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DetachedRoleImpl)) {
            return false;
        }
        DetachedRoleImpl oRole = (DetachedRoleImpl)o;
        return this.getIdLong() == oRole.getIdLong();
    }

    public int hashCode() {
        return Long.hashCode(this.id);
    }

    public String toString() {
        return new EntityString(this).setName(this.getName()).toString();
    }

    @Override
    public DetachedRoleImpl setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public DetachedRoleImpl setColor(int color) {
        this.color = color;
        return this;
    }

    @Override
    public DetachedRoleImpl setManaged(boolean managed) {
        this.managed = managed;
        return this;
    }

    @Override
    public DetachedRoleImpl setHoisted(boolean hoisted) {
        this.hoisted = hoisted;
        return this;
    }

    @Override
    public DetachedRoleImpl setMentionable(boolean mentionable) {
        this.mentionable = mentionable;
        return this;
    }

    @Override
    public DetachedRoleImpl setRawPermissions(long rawPermissions) {
        this.rawPermissions = rawPermissions;
        return this;
    }

    @Override
    public DetachedRoleImpl setRawPosition(int rawPosition) {
        this.rawPosition = rawPosition;
        return this;
    }

    @Override
    public DetachedRoleImpl setTags(DataObject tags) {
        if (this.tags == null) {
            return this;
        }
        this.tags = new RoleImpl.RoleTagsImpl(tags);
        return this;
    }

    @Override
    public DetachedRoleImpl setIcon(RoleIcon icon) {
        this.icon = icon;
        return this;
    }
}

