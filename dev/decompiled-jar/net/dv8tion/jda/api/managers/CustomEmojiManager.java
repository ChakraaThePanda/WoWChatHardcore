/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.managers;

import java.util.Set;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.emoji.RichCustomEmoji;
import net.dv8tion.jda.api.managers.Manager;

public interface CustomEmojiManager
extends Manager<CustomEmojiManager> {
    public static final long NAME = 1L;
    public static final long ROLES = 2L;

    @Override
    @Nonnull
    @CheckReturnValue
    public CustomEmojiManager reset(long var1);

    @Override
    @Nonnull
    @CheckReturnValue
    public CustomEmojiManager reset(long ... var1);

    @Nonnull
    default public Guild getGuild() {
        return this.getEmoji().getGuild();
    }

    @Nonnull
    public RichCustomEmoji getEmoji();

    @Nonnull
    @CheckReturnValue
    public CustomEmojiManager setName(@Nonnull String var1);

    @Nonnull
    @CheckReturnValue
    public CustomEmojiManager setRoles(@Nullable Set<Role> var1);
}

