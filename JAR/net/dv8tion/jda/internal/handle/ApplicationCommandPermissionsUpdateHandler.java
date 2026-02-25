/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.handle;

import java.util.List;
import java.util.stream.Collectors;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.ApplicationCommandUpdatePrivilegesEvent;
import net.dv8tion.jda.api.events.interaction.command.ApplicationUpdatePrivilegesEvent;
import net.dv8tion.jda.api.interactions.commands.privileges.IntegrationPrivilege;
import net.dv8tion.jda.api.utils.data.DataArray;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.JDAImpl;
import net.dv8tion.jda.internal.handle.SocketHandler;
import net.dv8tion.jda.internal.requests.WebSocketClient;

public class ApplicationCommandPermissionsUpdateHandler
extends SocketHandler {
    public ApplicationCommandPermissionsUpdateHandler(JDAImpl api2) {
        super(api2);
    }

    @Override
    protected Long handleInternally(DataObject content) {
        Guild guild;
        if (!content.isNull("guild_id")) {
            long guildId = content.getUnsignedLong("guild_id");
            guild = this.getJDA().getGuildById(guildId);
            if (this.getJDA().getGuildSetupController().isLocked(guildId)) {
                return guildId;
            }
            if (guild == null) {
                WebSocketClient.LOG.debug("Received APPLICATION_COMMAND_PERMISSIONS_UPDATE for a guild that is not cached: GuildID: {}", (Object)guildId);
                return null;
            }
        } else {
            return null;
        }
        long id = content.getUnsignedLong("id");
        long applicationId = content.getUnsignedLong("application_id");
        List<IntegrationPrivilege> privileges = content.getArray("permissions").stream(DataArray::getObject).map(obj -> new IntegrationPrivilege(guild, IntegrationPrivilege.Type.fromKey(obj.getInt("type")), obj.getBoolean("permission"), obj.getUnsignedLong("id"))).collect(Collectors.toList());
        if (id != applicationId) {
            this.api.handleEvent(new ApplicationCommandUpdatePrivilegesEvent(this.api, this.responseNumber, guild, id, applicationId, privileges));
        } else {
            this.api.handleEvent(new ApplicationUpdatePrivilegesEvent(this.api, this.responseNumber, guild, applicationId, privileges));
        }
        return null;
    }
}

