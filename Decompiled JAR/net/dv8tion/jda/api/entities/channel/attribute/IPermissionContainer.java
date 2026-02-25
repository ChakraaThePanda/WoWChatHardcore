/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.Unmodifiable
 */
package net.dv8tion.jda.api.entities.channel.attribute;

import java.util.List;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.IPermissionHolder;
import net.dv8tion.jda.api.entities.PermissionOverride;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.managers.channel.attribute.IPermissionContainerManager;
import net.dv8tion.jda.api.requests.restaction.PermissionOverrideAction;
import net.dv8tion.jda.internal.utils.Helpers;
import org.jetbrains.annotations.Unmodifiable;

public interface IPermissionContainer
extends GuildChannel {
    @Nonnull
    @CheckReturnValue
    public IPermissionContainerManager<?, ?> getManager();

    @Nullable
    public PermissionOverride getPermissionOverride(@Nonnull IPermissionHolder var1);

    @Nonnull
    public @Unmodifiable List<PermissionOverride> getPermissionOverrides();

    @Nonnull
    default public @Unmodifiable List<PermissionOverride> getMemberPermissionOverrides() {
        return this.getPermissionOverrides().stream().filter(PermissionOverride::isMemberOverride).collect(Helpers.toUnmodifiableList());
    }

    @Nonnull
    default public @Unmodifiable List<PermissionOverride> getRolePermissionOverrides() {
        return this.getPermissionOverrides().stream().filter(PermissionOverride::isRoleOverride).collect(Helpers.toUnmodifiableList());
    }

    @Nonnull
    @CheckReturnValue
    public PermissionOverrideAction upsertPermissionOverride(@Nonnull IPermissionHolder var1);
}

