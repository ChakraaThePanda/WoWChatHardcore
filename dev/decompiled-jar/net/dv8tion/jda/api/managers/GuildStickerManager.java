/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.managers;

import java.util.Arrays;
import java.util.Collection;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.managers.Manager;
import net.dv8tion.jda.internal.utils.Checks;

public interface GuildStickerManager
extends Manager<GuildStickerManager> {
    public static final long NAME = 1L;
    public static final long DESCRIPTION = 2L;
    public static final long TAGS = 4L;

    @Override
    @Nonnull
    @CheckReturnValue
    public GuildStickerManager reset(long var1);

    @Override
    @Nonnull
    @CheckReturnValue
    public GuildStickerManager reset(long ... var1);

    @Nullable
    public Guild getGuild();

    public long getGuildIdLong();

    @Nonnull
    default public String getGuildId() {
        return Long.toUnsignedString(this.getGuildIdLong());
    }

    @Nonnull
    @CheckReturnValue
    public GuildStickerManager setName(@Nonnull String var1);

    @Nonnull
    @CheckReturnValue
    public GuildStickerManager setDescription(@Nonnull String var1);

    @Nonnull
    @CheckReturnValue
    public GuildStickerManager setTags(@Nonnull Collection<String> var1);

    @Nonnull
    @CheckReturnValue
    default public GuildStickerManager setTags(String ... tags) {
        Checks.noneNull(tags, "Tags");
        return this.setTags(Arrays.asList(tags));
    }
}

