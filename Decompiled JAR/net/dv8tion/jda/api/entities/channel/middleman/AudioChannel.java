/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities.channel.middleman;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.Region;
import net.dv8tion.jda.api.entities.channel.middleman.StandardGuildChannel;
import net.dv8tion.jda.api.managers.channel.middleman.AudioChannelManager;

public interface AudioChannel
extends StandardGuildChannel {
    @Override
    @Nonnull
    @CheckReturnValue
    public AudioChannelManager<?, ?> getManager();

    public int getBitrate();

    public int getUserLimit();

    @Nonnull
    default public Region getRegion() {
        return this.getRegionRaw() == null ? Region.AUTOMATIC : Region.fromKey(this.getRegionRaw());
    }

    @Nullable
    public String getRegionRaw();
}

