/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.guild.update;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.update.GenericGuildUpdateEvent;

public class GuildUpdateSafetyAlertsChannelEvent
extends GenericGuildUpdateEvent<TextChannel> {
    public static final String IDENTIFIER = "safety_alerts_channel";

    public GuildUpdateSafetyAlertsChannelEvent(@Nonnull JDA api2, long responseNumber, @Nonnull Guild guild, @Nullable TextChannel oldSafetyAlertsChannel) {
        super(api2, responseNumber, guild, oldSafetyAlertsChannel, guild.getSafetyAlertsChannel(), IDENTIFIER);
    }

    @Nullable
    public TextChannel getOldSafetyAlertsChannel() {
        return (TextChannel)this.getOldValue();
    }

    @Nullable
    public TextChannel getNewSafetyAlertsChannel() {
        return (TextChannel)this.getNewValue();
    }
}

