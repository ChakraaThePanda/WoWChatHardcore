/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.interactions.commands;

import java.util.Arrays;
import java.util.Collection;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.internal.utils.Checks;

public class DefaultMemberPermissions {
    public static final DefaultMemberPermissions ENABLED = new DefaultMemberPermissions(null);
    public static final DefaultMemberPermissions DISABLED = new DefaultMemberPermissions(0L);
    private final Long permissions;

    private DefaultMemberPermissions(@Nullable Long permissions) {
        this.permissions = permissions;
    }

    @Nullable
    public Long getPermissionsRaw() {
        return this.permissions;
    }

    @Nonnull
    public static DefaultMemberPermissions enabledFor(@Nonnull Collection<Permission> permissions) {
        Checks.noneNull(permissions, "Permissions");
        if (permissions.isEmpty()) {
            return ENABLED;
        }
        return DefaultMemberPermissions.enabledFor(Permission.getRaw(permissions));
    }

    @Nonnull
    public static DefaultMemberPermissions enabledFor(Permission ... permissions) {
        return DefaultMemberPermissions.enabledFor(Arrays.asList(permissions));
    }

    @Nonnull
    public static DefaultMemberPermissions enabledFor(long permissions) {
        return new DefaultMemberPermissions(permissions);
    }
}

