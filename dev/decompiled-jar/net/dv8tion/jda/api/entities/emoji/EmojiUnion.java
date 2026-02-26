/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities.emoji;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.emoji.ApplicationEmoji;
import net.dv8tion.jda.api.entities.emoji.CustomEmoji;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.entities.emoji.RichCustomEmoji;
import net.dv8tion.jda.api.entities.emoji.UnicodeEmoji;

public interface EmojiUnion
extends Emoji {
    @Nonnull
    public UnicodeEmoji asUnicode();

    @Nonnull
    public CustomEmoji asCustom();

    @Nonnull
    public RichCustomEmoji asRich();

    @Nonnull
    public ApplicationEmoji asApplication();
}

