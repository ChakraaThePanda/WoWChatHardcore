/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.managers;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.emoji.ApplicationEmoji;
import net.dv8tion.jda.api.managers.Manager;

public interface ApplicationEmojiManager
extends Manager<ApplicationEmojiManager> {
    public static final long NAME = 1L;

    @Override
    @Nonnull
    @CheckReturnValue
    public ApplicationEmojiManager reset(long var1);

    @Override
    @Nonnull
    @CheckReturnValue
    public ApplicationEmojiManager reset(long ... var1);

    @Nonnull
    public ApplicationEmoji getEmoji();

    @Nonnull
    @CheckReturnValue
    public ApplicationEmojiManager setName(@Nonnull String var1);
}

