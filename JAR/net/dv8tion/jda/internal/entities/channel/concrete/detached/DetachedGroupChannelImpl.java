/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.entities.channel.concrete.detached;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.internal.entities.channel.AbstractChannelImpl;
import net.dv8tion.jda.internal.entities.channel.mixin.concrete.GroupChannelMixin;
import net.dv8tion.jda.internal.entities.detached.mixin.IDetachableEntityMixin;

public class DetachedGroupChannelImpl
extends AbstractChannelImpl<DetachedGroupChannelImpl>
implements GroupChannelMixin<DetachedGroupChannelImpl>,
IDetachableEntityMixin {
    private long latestMessageId;
    private long ownerId;
    private String icon;

    public DetachedGroupChannelImpl(JDA api2, long id) {
        super(id, api2);
    }

    @Override
    @Nonnull
    public ChannelType getType() {
        return ChannelType.GROUP;
    }

    @Override
    public boolean isDetached() {
        return true;
    }

    @Override
    public long getOwnerIdLong() {
        return this.ownerId;
    }

    @Override
    @Nullable
    public String getIconId() {
        return this.icon;
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
    public DetachedGroupChannelImpl setLatestMessageIdLong(long latestMessageId) {
        this.latestMessageId = latestMessageId;
        return this;
    }

    @Override
    public DetachedGroupChannelImpl setOwnerId(long ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    @Override
    public DetachedGroupChannelImpl setIcon(@Nullable String icon) {
        this.icon = icon;
        return this;
    }
}

