/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.entities.channel.concrete.detached;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.concrete.PrivateChannel;
import net.dv8tion.jda.api.exceptions.DetachedEntityException;
import net.dv8tion.jda.internal.entities.channel.AbstractChannelImpl;
import net.dv8tion.jda.internal.entities.channel.mixin.concrete.PrivateChannelMixin;

public class DetachedPrivateChannelImpl
extends AbstractChannelImpl<DetachedPrivateChannelImpl>
implements PrivateChannel,
PrivateChannelMixin<DetachedPrivateChannelImpl> {
    private final User user;
    private long latestMessageId;

    public DetachedPrivateChannelImpl(JDA api2, long id, @Nullable User user) {
        super(id, api2);
        this.user = user;
    }

    @Override
    @Nonnull
    public DetachedEntityException detachedException() {
        return new DetachedEntityException("Cannot perform action in friend DMs");
    }

    @Override
    public boolean isDetached() {
        return true;
    }

    @Override
    @Nonnull
    public ChannelType getType() {
        return ChannelType.PRIVATE;
    }

    @Override
    @Nullable
    public User getUser() {
        return this.user;
    }

    @Override
    @Nonnull
    public String getName() {
        return PrivateChannelMixin.super.getName();
    }

    @Override
    public long getLatestMessageIdLong() {
        return this.latestMessageId;
    }

    @Override
    public boolean canTalk() {
        return false;
    }

    @Override
    public void checkCanAccess() {
        throw this.detachedException();
    }

    @Override
    public void checkCanSendMessage() {
        throw this.detachedException();
    }

    @Override
    public void checkCanSendMessageEmbeds() {
        throw this.detachedException();
    }

    @Override
    public void checkCanSendFiles() {
        throw this.detachedException();
    }

    @Override
    public void checkCanViewHistory() {
        throw this.detachedException();
    }

    @Override
    public void checkCanAddReactions() {
        throw this.detachedException();
    }

    @Override
    public void checkCanRemoveReactions() {
        throw this.detachedException();
    }

    @Override
    public void checkCanControlMessagePins() {
        throw this.detachedException();
    }

    @Override
    public boolean canDeleteOtherUsersMessages() {
        return false;
    }

    @Override
    public DetachedPrivateChannelImpl setLatestMessageIdLong(long latestMessageId) {
        this.latestMessageId = latestMessageId;
        return this;
    }

    public int hashCode() {
        return Long.hashCode(this.id);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DetachedPrivateChannelImpl)) {
            return false;
        }
        DetachedPrivateChannelImpl impl = (DetachedPrivateChannelImpl)obj;
        return impl.id == this.id;
    }
}

