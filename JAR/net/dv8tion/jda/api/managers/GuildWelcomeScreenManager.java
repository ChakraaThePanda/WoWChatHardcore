/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.Unmodifiable
 */
package net.dv8tion.jda.api.managers;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.GuildWelcomeScreen;
import net.dv8tion.jda.api.managers.Manager;
import net.dv8tion.jda.internal.utils.Checks;
import org.jetbrains.annotations.Unmodifiable;

public interface GuildWelcomeScreenManager
extends Manager<GuildWelcomeScreenManager> {
    public static final long ENABLED = 1L;
    public static final long DESCRIPTION = 2L;
    public static final long CHANNELS = 4L;

    @Nonnull
    public Guild getGuild();

    @Override
    @Nonnull
    @CheckReturnValue
    public GuildWelcomeScreenManager reset(long var1);

    @Override
    @Nonnull
    @CheckReturnValue
    public GuildWelcomeScreenManager reset(long ... var1);

    @Nonnull
    @CheckReturnValue
    public GuildWelcomeScreenManager setEnabled(boolean var1);

    @Nonnull
    @CheckReturnValue
    public GuildWelcomeScreenManager setDescription(@Nullable String var1);

    @Nonnull
    public @Unmodifiable List<GuildWelcomeScreen.Channel> getWelcomeChannels();

    @Nonnull
    @CheckReturnValue
    public GuildWelcomeScreenManager clearWelcomeChannels();

    @Nonnull
    @CheckReturnValue
    public GuildWelcomeScreenManager setWelcomeChannels(@Nonnull Collection<? extends GuildWelcomeScreen.Channel> var1);

    @Nonnull
    @CheckReturnValue
    default public GuildWelcomeScreenManager setWelcomeChannels(GuildWelcomeScreen.Channel ... channels) {
        Checks.notNull(channels, "Welcome channels");
        return this.setWelcomeChannels(Arrays.asList(channels));
    }
}

