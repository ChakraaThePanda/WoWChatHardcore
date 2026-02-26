/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.sticker.update;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.sticker.GuildSticker;
import net.dv8tion.jda.api.events.sticker.update.GenericGuildStickerUpdateEvent;

public class GuildStickerUpdateAvailableEvent
extends GenericGuildStickerUpdateEvent<Boolean> {
    public static final String IDENTIFIER = "available";

    public GuildStickerUpdateAvailableEvent(@Nonnull JDA api2, long responseNumber, @Nonnull Guild guild, @Nonnull GuildSticker sticker, boolean oldValue) {
        super(api2, responseNumber, guild, sticker, IDENTIFIER, oldValue, sticker.isAvailable());
    }

    @Override
    @Nonnull
    public Boolean getOldValue() {
        return (Boolean)super.getOldValue();
    }

    @Override
    @Nonnull
    public Boolean getNewValue() {
        return (Boolean)super.getNewValue();
    }
}

