/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities.emoji;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.annotations.ReplaceWith;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.emoji.CustomEmoji;
import net.dv8tion.jda.api.managers.ApplicationEmojiManager;
import net.dv8tion.jda.api.requests.RestAction;

public interface ApplicationEmoji
extends CustomEmoji {
    @Deprecated
    @ReplaceWith(value="MAX_APPLICATION_EMOJIS")
    public static final int APPLICATION_EMOJI_CAP = 2000;
    public static final int MAX_APPLICATION_EMOJIS = 2000;

    @Nonnull
    public JDA getJDA();

    @Nullable
    public User getOwner();

    @Nonnull
    @CheckReturnValue
    public RestAction<Void> delete();

    @Nonnull
    @CheckReturnValue
    public ApplicationEmojiManager getManager();
}

