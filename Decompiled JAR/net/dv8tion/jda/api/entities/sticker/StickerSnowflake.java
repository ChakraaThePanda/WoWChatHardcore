/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities.sticker;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.ISnowflake;
import net.dv8tion.jda.api.utils.MiscUtil;
import net.dv8tion.jda.internal.entities.sticker.StickerSnowflakeImpl;

public interface StickerSnowflake
extends ISnowflake {
    @Nonnull
    public static StickerSnowflake fromId(long id) {
        return new StickerSnowflakeImpl(id);
    }

    @Nonnull
    public static StickerSnowflake fromId(@Nonnull String id) {
        return StickerSnowflake.fromId(MiscUtil.parseSnowflake(id));
    }
}

