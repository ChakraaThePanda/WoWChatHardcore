/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.entities.channel.mixin.concrete;

import net.dv8tion.jda.api.entities.channel.concrete.ThreadChannel;
import net.dv8tion.jda.internal.entities.channel.mixin.attribute.ISlowmodeChannelMixin;
import net.dv8tion.jda.internal.entities.channel.mixin.middleman.GuildMessageChannelMixin;

public interface ThreadChannelMixin<T extends ThreadChannelMixin<T>>
extends ThreadChannel,
GuildMessageChannelMixin<T>,
ISlowmodeChannelMixin<T> {
    public T setAutoArchiveDuration(ThreadChannel.AutoArchiveDuration var1);

    public T setLocked(boolean var1);

    public T setArchived(boolean var1);

    public T setInvitable(boolean var1);

    public T setArchiveTimestamp(long var1);

    public T setCreationTimestamp(long var1);

    public T setOwnerId(long var1);

    public T setMessageCount(int var1);

    public T setTotalMessageCount(int var1);

    public T setMemberCount(int var1);

    public T setFlags(int var1);
}

