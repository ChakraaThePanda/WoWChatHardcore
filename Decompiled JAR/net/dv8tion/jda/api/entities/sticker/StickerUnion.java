/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities.sticker;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.sticker.GuildSticker;
import net.dv8tion.jda.api.entities.sticker.RichSticker;
import net.dv8tion.jda.api.entities.sticker.StandardSticker;

public interface StickerUnion
extends RichSticker {
    @Nonnull
    public StandardSticker asStandardSticker();

    @Nonnull
    public GuildSticker asGuildSticker();
}

