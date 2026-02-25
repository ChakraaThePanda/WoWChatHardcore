/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.sticker;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.sticker.GuildSticker;
import net.dv8tion.jda.api.events.sticker.GenericGuildStickerEvent;

public class GuildStickerRemovedEvent
extends GenericGuildStickerEvent {
    public GuildStickerRemovedEvent(@Nonnull JDA api2, long responseNumber, @Nonnull Guild guild, @Nonnull GuildSticker sticker) {
        super(api2, responseNumber, guild, sticker);
    }
}

