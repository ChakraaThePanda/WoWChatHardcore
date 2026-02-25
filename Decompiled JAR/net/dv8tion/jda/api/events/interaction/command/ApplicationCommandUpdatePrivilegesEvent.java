/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.interaction.command;

import java.util.List;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.GenericPrivilegeUpdateEvent;
import net.dv8tion.jda.api.interactions.commands.privileges.IntegrationPrivilege;
import net.dv8tion.jda.api.interactions.commands.privileges.PrivilegeTargetType;

public class ApplicationCommandUpdatePrivilegesEvent
extends GenericPrivilegeUpdateEvent {
    public ApplicationCommandUpdatePrivilegesEvent(@Nonnull JDA api2, long responseNumber, @Nonnull Guild guild, long targetId, long applicationId, @Nonnull List<IntegrationPrivilege> privileges) {
        super(api2, responseNumber, guild, targetId, applicationId, privileges);
    }

    @Override
    @Nonnull
    public PrivilegeTargetType getTargetType() {
        return PrivilegeTargetType.COMMAND;
    }

    public long getCommandIdLong() {
        return this.getTargetIdLong();
    }

    @Nonnull
    public String getCommandId() {
        return this.getTargetId();
    }
}

