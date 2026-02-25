/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities.emoji;

import java.util.Formatter;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.IMentionable;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.utils.ImageProxy;

public interface CustomEmoji
extends Emoji,
IMentionable {
    public static final int EMOJI_NAME_MAX_LENGTH = 32;
    public static final String ICON_URL = "https://cdn.discordapp.com/emojis/%s.%s";

    @Override
    @Nonnull
    default public Emoji.Type getType() {
        return Emoji.Type.CUSTOM;
    }

    public boolean isAnimated();

    @Nonnull
    default public String getImageUrl() {
        return String.format(ICON_URL, this.getId(), this.isAnimated() ? "gif" : "png");
    }

    @Nonnull
    default public ImageProxy getImage() {
        return new ImageProxy(this.getImageUrl());
    }

    @Override
    @Nonnull
    default public String getAsMention() {
        return (this.isAnimated() ? "<a:" : "<:") + this.getName() + ":" + this.getId() + ">";
    }

    @Override
    @Nonnull
    default public String getFormatted() {
        return this.getAsMention();
    }

    @Override
    default public void formatTo(Formatter formatter, int flags, int width, int precision) {
        Emoji.super.formatTo(formatter, flags, width, precision);
    }
}

