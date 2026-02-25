/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.managers.channel.middleman;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.Region;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.managers.channel.middleman.StandardGuildChannelManager;

public interface AudioChannelManager<T extends AudioChannel, M extends AudioChannelManager<T, M>>
extends StandardGuildChannelManager<T, M> {
    @Nonnull
    @CheckReturnValue
    public M setBitrate(int var1);

    @Nonnull
    @CheckReturnValue
    public M setUserLimit(int var1);

    @Nonnull
    @CheckReturnValue
    public M setRegion(@Nonnull Region var1);
}

