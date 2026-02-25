/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.entities.channel.concrete;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.concrete.PrivateChannel;
import net.dv8tion.jda.internal.entities.channel.AbstractChannelImpl;
import net.dv8tion.jda.internal.entities.channel.mixin.concrete.PrivateChannelMixin;

public class PrivateChannelImpl
extends AbstractChannelImpl<PrivateChannelImpl>
implements PrivateChannel,
PrivateChannelMixin<PrivateChannelImpl> {
    private User user;
    private long latestMessageId;

    public PrivateChannelImpl(JDA api2, long id, @Nullable User user) {
        super(id, api2);
        this.user = user;
    }

    @Override
    public boolean isDetached() {
        return false;
    }

    @Override
    @Nonnull
    public ChannelType getType() {
        return ChannelType.PRIVATE;
    }

    @Override
    @Nullable
    public User getUser() {
        this.updateUser();
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
        return this.user == null || !this.user.isBot();
    }

    @Override
    public void checkCanAccess() {
    }

    @Override
    public void checkCanSendMessage() {
        this.checkBot();
    }

    @Override
    public void checkCanSendMessageEmbeds() {
    }

    @Override
    public void checkCanSendFiles() {
    }

    @Override
    public void checkCanViewHistory() {
    }

    @Override
    public void checkCanAddReactions() {
    }

    @Override
    public void checkCanRemoveReactions() {
    }

    @Override
    public void checkCanControlMessagePins() {
    }

    @Override
    public boolean canDeleteOtherUsersMessages() {
        return false;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public PrivateChannelImpl setLatestMessageIdLong(long latestMessageId) {
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
        if (!(obj instanceof PrivateChannelImpl)) {
            return false;
        }
        PrivateChannelImpl impl = (PrivateChannelImpl)obj;
        return impl.id == this.id;
    }

    private void updateUser() {
        if (this.user == null) {
            return;
        }
        User realUser = this.getJDA().getUserById(this.user.getIdLong());
        if (realUser != null) {
            this.user = realUser;
        }
    }

    private void checkBot() {
        if (this.getUser() != null && this.getUser().isBot()) {
            throw new UnsupportedOperationException("Cannot send a private message between bots.");
        }
    }
}

