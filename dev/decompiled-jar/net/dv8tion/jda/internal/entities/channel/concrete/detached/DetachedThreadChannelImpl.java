/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.entities.channel.concrete.detached;

import java.time.OffsetDateTime;
import java.util.EnumSet;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.ThreadMember;
import net.dv8tion.jda.api.entities.channel.ChannelFlag;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.attribute.IPermissionContainer;
import net.dv8tion.jda.api.entities.channel.concrete.ThreadChannel;
import net.dv8tion.jda.api.entities.channel.forums.ForumTag;
import net.dv8tion.jda.api.entities.channel.unions.IThreadContainerUnion;
import net.dv8tion.jda.api.managers.channel.concrete.ThreadChannelManager;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.requests.restaction.CacheRestAction;
import net.dv8tion.jda.api.requests.restaction.pagination.ThreadMemberPaginationAction;
import net.dv8tion.jda.api.utils.TimeUtil;
import net.dv8tion.jda.internal.entities.channel.middleman.AbstractGuildChannelImpl;
import net.dv8tion.jda.internal.entities.channel.mixin.attribute.IInteractionPermissionMixin;
import net.dv8tion.jda.internal.entities.channel.mixin.concrete.ThreadChannelMixin;
import net.dv8tion.jda.internal.entities.detached.DetachedGuildImpl;
import net.dv8tion.jda.internal.interactions.ChannelInteractionPermissions;
import net.dv8tion.jda.internal.utils.Helpers;

public class DetachedThreadChannelImpl
extends AbstractGuildChannelImpl<DetachedThreadChannelImpl>
implements ThreadChannel,
ThreadChannelMixin<DetachedThreadChannelImpl>,
IInteractionPermissionMixin<DetachedThreadChannelImpl> {
    private final ChannelType type;
    private ChannelInteractionPermissions interactionPermissions;
    private ThreadChannel.AutoArchiveDuration autoArchiveDuration;
    private boolean locked;
    private boolean archived;
    private boolean invitable;
    private long archiveTimestamp;
    private long creationTimestamp;
    private long ownerId;
    private long latestMessageId;
    private int messageCount;
    private int totalMessageCount;
    private int memberCount;
    private int slowmode;
    private int flags;

    public DetachedThreadChannelImpl(long id, DetachedGuildImpl guild, ChannelType type) {
        super(id, guild);
        this.type = type;
    }

    @Override
    public boolean isDetached() {
        return true;
    }

    @Override
    @Nonnull
    public EnumSet<ChannelFlag> getFlags() {
        return ChannelFlag.fromRaw(this.flags);
    }

    @Override
    @Nonnull
    public ChannelType getType() {
        return this.type;
    }

    @Override
    public long getLatestMessageIdLong() {
        return this.latestMessageId;
    }

    @Override
    public int getMessageCount() {
        return this.messageCount;
    }

    @Override
    public int getTotalMessageCount() {
        return this.totalMessageCount;
    }

    @Override
    public int getMemberCount() {
        return this.memberCount;
    }

    @Override
    public boolean isLocked() {
        return this.locked;
    }

    @Override
    public boolean canTalk(@Nonnull Member member) {
        throw this.detachedException();
    }

    @Override
    @Nonnull
    public List<Member> getMembers() {
        throw this.detachedException();
    }

    @Override
    @Nonnull
    public IThreadContainerUnion getParentChannel() {
        throw this.detachedException();
    }

    @Override
    @Nonnull
    public List<ForumTag> getAppliedTags() {
        throw this.detachedException();
    }

    @Override
    @Nonnull
    public RestAction<Message> retrieveParentMessage() {
        throw this.detachedException();
    }

    @Override
    @Nonnull
    public RestAction<Message> retrieveStartMessage() {
        throw this.detachedException();
    }

    @Override
    @Nonnull
    public IPermissionContainer getPermissionContainer() {
        throw this.detachedException();
    }

    @Override
    @Nonnull
    public List<ThreadMember> getThreadMembers() {
        throw this.detachedException();
    }

    @Override
    @Nullable
    public ThreadMember getThreadMemberById(long id) {
        throw this.detachedException();
    }

    @Override
    @Nonnull
    public CacheRestAction<ThreadMember> retrieveThreadMemberById(long id) {
        throw this.detachedException();
    }

    @Override
    @Nonnull
    public ThreadMemberPaginationAction retrieveThreadMembers() {
        throw this.detachedException();
    }

    @Override
    public long getOwnerIdLong() {
        return this.ownerId;
    }

    @Override
    public boolean isArchived() {
        return this.archived;
    }

    @Override
    public boolean isInvitable() {
        if (this.type != ChannelType.GUILD_PRIVATE_THREAD) {
            throw new UnsupportedOperationException("Only private threads support the concept of invitable.");
        }
        return this.invitable;
    }

    @Override
    @Nonnull
    public OffsetDateTime getTimeArchiveInfoLastModified() {
        return Helpers.toOffset(this.archiveTimestamp);
    }

    @Override
    @Nonnull
    public ThreadChannel.AutoArchiveDuration getAutoArchiveDuration() {
        return this.autoArchiveDuration;
    }

    @Override
    @Nonnull
    public OffsetDateTime getTimeCreated() {
        return this.creationTimestamp == 0L ? TimeUtil.getTimeCreated(this.getIdLong()) : Helpers.toOffset(this.creationTimestamp);
    }

    @Override
    public int getSlowmode() {
        return this.slowmode;
    }

    @Override
    @Nonnull
    public RestAction<Void> join() {
        throw this.detachedException();
    }

    @Override
    @Nonnull
    public RestAction<Void> leave() {
        throw this.detachedException();
    }

    @Override
    @Nonnull
    public RestAction<Void> addThreadMemberById(long id) {
        throw this.detachedException();
    }

    @Override
    @Nonnull
    public RestAction<Void> removeThreadMemberById(long id) {
        throw this.detachedException();
    }

    @Override
    @Nonnull
    public ThreadChannelManager getManager() {
        throw this.detachedException();
    }

    @Override
    public void checkCanManage() {
        throw this.detachedException();
    }

    @Override
    @Nonnull
    public ChannelInteractionPermissions getInteractionPermissions() {
        return this.interactionPermissions;
    }

    @Override
    public DetachedThreadChannelImpl setLatestMessageIdLong(long latestMessageId) {
        this.latestMessageId = latestMessageId;
        return this;
    }

    @Override
    public DetachedThreadChannelImpl setAutoArchiveDuration(ThreadChannel.AutoArchiveDuration autoArchiveDuration) {
        this.autoArchiveDuration = autoArchiveDuration;
        return this;
    }

    @Override
    public DetachedThreadChannelImpl setLocked(boolean locked) {
        this.locked = locked;
        return this;
    }

    @Override
    public DetachedThreadChannelImpl setArchived(boolean archived) {
        this.archived = archived;
        return this;
    }

    @Override
    public DetachedThreadChannelImpl setInvitable(boolean invitable) {
        this.invitable = invitable;
        return this;
    }

    @Override
    public DetachedThreadChannelImpl setArchiveTimestamp(long archiveTimestamp) {
        this.archiveTimestamp = archiveTimestamp;
        return this;
    }

    @Override
    public DetachedThreadChannelImpl setCreationTimestamp(long creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
        return this;
    }

    @Override
    public DetachedThreadChannelImpl setOwnerId(long ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    @Override
    public DetachedThreadChannelImpl setMessageCount(int messageCount) {
        this.messageCount = messageCount;
        return this;
    }

    @Override
    public DetachedThreadChannelImpl setTotalMessageCount(int messageCount) {
        this.totalMessageCount = Math.max(messageCount, this.messageCount);
        return this;
    }

    @Override
    public DetachedThreadChannelImpl setMemberCount(int memberCount) {
        this.memberCount = memberCount;
        return this;
    }

    @Override
    public DetachedThreadChannelImpl setSlowmode(int slowmode) {
        this.slowmode = slowmode;
        return this;
    }

    @Override
    public DetachedThreadChannelImpl setFlags(int flags) {
        this.flags = flags;
        return this;
    }

    @Override
    @Nonnull
    public DetachedThreadChannelImpl setInteractionPermissions(@Nonnull ChannelInteractionPermissions interactionPermissions) {
        this.interactionPermissions = interactionPermissions;
        return this;
    }
}

