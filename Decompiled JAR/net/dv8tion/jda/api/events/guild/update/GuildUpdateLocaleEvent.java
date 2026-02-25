/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.guild.update;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.guild.update.GenericGuildUpdateEvent;
import net.dv8tion.jda.api.interactions.DiscordLocale;

public class GuildUpdateLocaleEvent
extends GenericGuildUpdateEvent<DiscordLocale> {
    public static final String IDENTIFIER = "locale";

    public GuildUpdateLocaleEvent(@Nonnull JDA api2, long responseNumber, @Nonnull Guild guild, @Nonnull DiscordLocale previous) {
        super(api2, responseNumber, guild, previous, guild.getLocale(), IDENTIFIER);
    }

    @Override
    @Nonnull
    public DiscordLocale getOldValue() {
        return (DiscordLocale)((Object)super.getOldValue());
    }

    @Override
    @Nonnull
    public DiscordLocale getNewValue() {
        return (DiscordLocale)((Object)super.getNewValue());
    }
}

