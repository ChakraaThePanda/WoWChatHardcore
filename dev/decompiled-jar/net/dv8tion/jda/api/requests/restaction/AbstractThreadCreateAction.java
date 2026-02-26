/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.requests.restaction;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.concrete.ThreadChannel;
import net.dv8tion.jda.api.requests.RestAction;

public interface AbstractThreadCreateAction<T, R extends AbstractThreadCreateAction<T, R>>
extends RestAction<T> {
    @Nonnull
    public Guild getGuild();

    @Nonnull
    public ChannelType getType();

    @Nonnull
    @CheckReturnValue
    public R setName(@Nonnull String var1);

    @Nonnull
    @CheckReturnValue
    public R setAutoArchiveDuration(@Nonnull ThreadChannel.AutoArchiveDuration var1);

    @Nonnull
    @CheckReturnValue
    public R setSlowmode(int var1);
}

