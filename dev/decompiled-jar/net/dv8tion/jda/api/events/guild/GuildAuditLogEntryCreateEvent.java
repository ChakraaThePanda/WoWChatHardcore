/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.guild;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.audit.AuditLogEntry;
import net.dv8tion.jda.api.events.guild.GenericGuildEvent;

public class GuildAuditLogEntryCreateEvent
extends GenericGuildEvent {
    private final AuditLogEntry entry;

    public GuildAuditLogEntryCreateEvent(@Nonnull JDA api2, long responseNumber, @Nonnull AuditLogEntry entry) {
        super(api2, responseNumber, entry.getGuild());
        this.entry = entry;
    }

    @Nonnull
    public AuditLogEntry getEntry() {
        return this.entry;
    }
}

