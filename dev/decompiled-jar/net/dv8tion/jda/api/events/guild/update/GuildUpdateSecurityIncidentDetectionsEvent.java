/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.guild.update;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.guild.SecurityIncidentDetections;
import net.dv8tion.jda.api.events.guild.update.GenericGuildUpdateEvent;

public class GuildUpdateSecurityIncidentDetectionsEvent
extends GenericGuildUpdateEvent<SecurityIncidentDetections> {
    public static final String IDENTIFIER = "security_incident_detections";

    public GuildUpdateSecurityIncidentDetectionsEvent(@Nonnull JDA api2, long responseNumber, @Nonnull Guild guild, @Nonnull SecurityIncidentDetections previous) {
        super(api2, responseNumber, guild, previous, guild.getSecurityIncidentDetections(), IDENTIFIER);
    }

    @Nonnull
    public SecurityIncidentDetections getOldSecurityIncidentDetections() {
        return (SecurityIncidentDetections)this.getOldValue();
    }

    @Nonnull
    public SecurityIncidentDetections getNewSecurityIncidentDetections() {
        return (SecurityIncidentDetections)this.getNewValue();
    }
}

