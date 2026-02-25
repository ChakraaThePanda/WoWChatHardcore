/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities.sticker;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.sticker.RichSticker;
import net.dv8tion.jda.api.entities.sticker.Sticker;

public interface StandardSticker
extends RichSticker {
    @Override
    @Nonnull
    default public Sticker.Type getType() {
        return Sticker.Type.STANDARD;
    }

    public long getPackIdLong();

    @Nonnull
    default public String getPackId() {
        return Long.toUnsignedString(this.getPackIdLong());
    }

    public int getSortValue();
}

