/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.sticker.update;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.sticker.GuildSticker;
import net.dv8tion.jda.api.events.sticker.update.GenericGuildStickerUpdateEvent;

public class GuildStickerUpdateNameEvent
extends GenericGuildStickerUpdateEvent<String> {
    public static final String IDENTIFIER = "name";

    public GuildStickerUpdateNameEvent(@Nonnull JDA api2, long responseNumber, @Nonnull Guild guild, @Nonnull GuildSticker sticker, @Nonnull String oldValue) {
        super(api2, responseNumber, guild, sticker, IDENTIFIER, oldValue, sticker.getName());
    }

    @Override
    @Nonnull
    public String getOldValue() {
        return (String)super.getOldValue();
    }

    @Override
    @Nonnull
    public String getNewValue() {
        return (String)super.getNewValue();
    }
}

