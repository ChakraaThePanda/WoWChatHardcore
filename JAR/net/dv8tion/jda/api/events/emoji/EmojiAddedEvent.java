/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.emoji;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.emoji.RichCustomEmoji;
import net.dv8tion.jda.api.events.emoji.GenericEmojiEvent;

public class EmojiAddedEvent
extends GenericEmojiEvent {
    public EmojiAddedEvent(@Nonnull JDA api2, long responseNumber, @Nonnull RichCustomEmoji emoji) {
        super(api2, responseNumber, emoji);
    }
}

