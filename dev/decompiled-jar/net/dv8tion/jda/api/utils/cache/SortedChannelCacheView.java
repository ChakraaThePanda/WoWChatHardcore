/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.utils.cache;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.utils.cache.ChannelCacheView;
import net.dv8tion.jda.api.utils.cache.SortedSnowflakeCacheView;

public interface SortedChannelCacheView<T extends Channel & Comparable<? super T>>
extends ChannelCacheView<T>,
SortedSnowflakeCacheView<T> {
    @Override
    @Nonnull
    public <C extends T> SortedChannelCacheView<C> ofType(@Nonnull Class<C> var1);
}

