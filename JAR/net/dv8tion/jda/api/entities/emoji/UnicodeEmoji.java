/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities.emoji;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.emoji.Emoji;

public interface UnicodeEmoji
extends Emoji {
    @Nonnull
    public String getAsCodepoints();

    @Override
    @Nonnull
    default public Emoji.Type getType() {
        return Emoji.Type.UNICODE;
    }

    @Override
    @Nonnull
    default public String getFormatted() {
        return this.getName();
    }
}

