/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities.channel.concrete;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.requests.RestAction;

public interface PrivateChannel
extends MessageChannel {
    @Nullable
    public User getUser();

    @Nonnull
    @CheckReturnValue
    public RestAction<User> retrieveUser();

    @Override
    @Nonnull
    public String getName();
}

