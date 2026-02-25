/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.guild.update;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.guild.SecurityIncidentActions;
import net.dv8tion.jda.api.events.guild.update.GenericGuildUpdateEvent;

public class GuildUpdateSecurityIncidentActionsEvent
extends GenericGuildUpdateEvent<SecurityIncidentActions> {
    public static final String IDENTIFIER = "security_incident_actions";

    public GuildUpdateSecurityIncidentActionsEvent(@Nonnull JDA api2, long responseNumber, @Nonnull Guild guild, @Nonnull SecurityIncidentActions previous) {
        super(api2, responseNumber, guild, previous, guild.getSecurityIncidentActions(), IDENTIFIER);
    }

    @Nonnull
    public SecurityIncidentActions getOldSecurityIncidentActions() {
        return (SecurityIncidentActions)this.getOldValue();
    }

    @Nonnull
    public SecurityIncidentActions getNewSecurityIncidentActions() {
        return (SecurityIncidentActions)this.getNewValue();
    }
}

