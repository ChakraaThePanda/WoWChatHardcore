/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.role.update;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.RoleIcon;
import net.dv8tion.jda.api.events.role.update.GenericRoleUpdateEvent;

public class RoleUpdateIconEvent
extends GenericRoleUpdateEvent<RoleIcon> {
    public static final String IDENTIFIER = "icon";

    public RoleUpdateIconEvent(@Nonnull JDA api2, long responseNumber, @Nonnull Role role, @Nullable RoleIcon oldIcon) {
        super(api2, responseNumber, role, oldIcon, role.getIcon(), IDENTIFIER);
    }

    @Nullable
    public RoleIcon getOldIcon() {
        return (RoleIcon)this.getOldValue();
    }

    @Nullable
    public RoleIcon getNewIcon() {
        return (RoleIcon)this.getNewValue();
    }
}

