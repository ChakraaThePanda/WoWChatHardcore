/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities.channel.attribute;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.managers.channel.attribute.ISlowmodeChannelManager;

public interface ISlowmodeChannel
extends GuildChannel {
    public static final int MAX_SLOWMODE = 21600;

    public int getSlowmode();

    @Nonnull
    @CheckReturnValue
    public ISlowmodeChannelManager<?, ?> getManager();
}

