/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.guild.override;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.PermissionOverride;
import net.dv8tion.jda.api.entities.channel.attribute.IPermissionContainer;
import net.dv8tion.jda.api.events.guild.override.GenericPermissionOverrideEvent;

public class PermissionOverrideDeleteEvent
extends GenericPermissionOverrideEvent {
    public PermissionOverrideDeleteEvent(@Nonnull JDA api2, long responseNumber, @Nonnull IPermissionContainer channel, @Nonnull PermissionOverride override) {
        super(api2, responseNumber, channel, override);
    }
}

