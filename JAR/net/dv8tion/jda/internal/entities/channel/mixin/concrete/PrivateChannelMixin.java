/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.entities.channel.mixin.concrete;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.PrivateChannel;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.requests.Route;
import net.dv8tion.jda.internal.JDAImpl;
import net.dv8tion.jda.internal.entities.channel.mixin.middleman.MessageChannelMixin;
import net.dv8tion.jda.internal.requests.CompletedRestAction;
import net.dv8tion.jda.internal.requests.RestActionImpl;

public interface PrivateChannelMixin<T extends PrivateChannelMixin<T>>
extends PrivateChannel,
MessageChannelMixin<T> {
    @Override
    @Nonnull
    default public String getName() {
        User user = this.getUser();
        if (user == null) {
            return "";
        }
        return user.getName();
    }

    @Override
    @Nonnull
    default public RestAction<User> retrieveUser() {
        User user = this.getUser();
        if (user != null) {
            return new CompletedRestAction<User>(this.getJDA(), user);
        }
        return this.retrievePrivateChannel().map(PrivateChannel::getUser);
    }

    @Nonnull
    default public RestAction<PrivateChannel> retrievePrivateChannel() {
        Route.CompiledRoute route = Route.Channels.GET_CHANNEL.compile(this.getId());
        return new RestActionImpl<PrivateChannel>(this.getJDA(), route, (response, request) -> ((JDAImpl)this.getJDA()).getEntityBuilder().createPrivateChannel(response.getObject()));
    }
}

