/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.requests.restaction.order;

import java.util.EnumSet;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.concrete.Category;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.requests.restaction.order.OrderAction;

public interface ChannelOrderAction
extends OrderAction<GuildChannel, ChannelOrderAction> {
    @Nonnull
    public Guild getGuild();

    public int getSortBucket();

    @Nonnull
    default public EnumSet<ChannelType> getChannelTypes() {
        return ChannelType.fromSortBucket(this.getSortBucket());
    }

    @Nonnull
    @CheckReturnValue
    public ChannelOrderAction setCategory(@Nullable Category var1, boolean var2);

    @Nonnull
    @CheckReturnValue
    default public ChannelOrderAction setCategory(@Nullable Category category) {
        return this.setCategory(category, false);
    }
}

