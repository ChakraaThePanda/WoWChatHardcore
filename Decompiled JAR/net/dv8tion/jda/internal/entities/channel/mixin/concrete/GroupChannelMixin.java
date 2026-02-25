/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.entities.channel.mixin.concrete;

import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.channel.concrete.GroupChannel;
import net.dv8tion.jda.internal.entities.channel.mixin.middleman.MessageChannelMixin;

public interface GroupChannelMixin<T extends GroupChannelMixin<T>>
extends GroupChannel,
MessageChannelMixin<T> {
    public T setOwnerId(long var1);

    public T setIcon(@Nullable String var1);
}

