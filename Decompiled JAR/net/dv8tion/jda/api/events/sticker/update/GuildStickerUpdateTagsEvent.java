/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.sticker.update;

import java.util.Set;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.sticker.GuildSticker;
import net.dv8tion.jda.api.events.sticker.update.GenericGuildStickerUpdateEvent;

public class GuildStickerUpdateTagsEvent
extends GenericGuildStickerUpdateEvent<Set<String>> {
    public static final String IDENTIFIER = "tags";

    public GuildStickerUpdateTagsEvent(@Nonnull JDA api2, long responseNumber, @Nonnull Guild guild, @Nonnull GuildSticker sticker, @Nonnull Set<String> oldValue) {
        super(api2, responseNumber, guild, sticker, IDENTIFIER, oldValue, sticker.getTags());
    }

    @Override
    @Nonnull
    public Set<String> getOldValue() {
        return (Set)super.getOldValue();
    }

    @Override
    @Nonnull
    public Set<String> getNewValue() {
        return (Set)super.getNewValue();
    }
}

