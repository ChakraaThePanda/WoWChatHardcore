/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.entities.channel.concrete.detached;

import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.StageInstance;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.concrete.StageChannel;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.managers.channel.concrete.StageChannelManager;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.requests.restaction.StageInstanceAction;
import net.dv8tion.jda.internal.entities.channel.middleman.AbstractStandardGuildChannelImpl;
import net.dv8tion.jda.internal.entities.channel.mixin.attribute.IInteractionPermissionMixin;
import net.dv8tion.jda.internal.entities.channel.mixin.concrete.StageChannelMixin;
import net.dv8tion.jda.internal.entities.detached.DetachedGuildImpl;
import net.dv8tion.jda.internal.interactions.ChannelInteractionPermissions;
import net.dv8tion.jda.internal.utils.Checks;

public class DetachedStageChannelImpl
extends AbstractStandardGuildChannelImpl<DetachedStageChannelImpl>
implements StageChannel,
StageChannelMixin<DetachedStageChannelImpl>,
IInteractionPermissionMixin<DetachedStageChannelImpl> {
    private ChannelInteractionPermissions interactionPermissions;
    private String region;
    private int bitrate;
    private int userlimit;
    private int slowmode;
    private boolean ageRestricted;
    private long latestMessageId;

    public DetachedStageChannelImpl(long id, DetachedGuildImpl guild) {
        super(id, guild);
    }

    @Override
    public boolean isDetached() {
        return true;
    }

    @Override
    @Nonnull
    public ChannelType getType() {
        return ChannelType.STAGE;
    }

    @Override
    public int getBitrate() {
        return this.bitrate;
    }

    @Override
    public int getUserLimit() {
        return this.userlimit;
    }

    @Override
    @Nullable
    public String getRegionRaw() {
        return this.region;
    }

    @Override
    @Nullable
    public StageInstance getStageInstance() {
        throw this.detachedException();
    }

    @Override
    @Nonnull
    public List<Member> getMembers() {
        throw this.detachedException();
    }

    @Override
    @Nonnull
    public StageInstanceAction createStageInstance(@Nonnull String topic) {
        throw this.detachedException();
    }

    @Override
    public int getSlowmode() {
        return this.slowmode;
    }

    @Override
    public boolean isNSFW() {
        return this.ageRestricted;
    }

    @Override
    public boolean canTalk(@Nonnull Member member) {
        Checks.notNull(member, "Member");
        return member.hasPermission((GuildChannel)this, Permission.MESSAGE_SEND);
    }

    @Override
    public long getLatestMessageIdLong() {
        return this.latestMessageId;
    }

    @Override
    @Nonnull
    public StageChannelManager getManager() {
        throw this.detachedException();
    }

    @Override
    @Nonnull
    public RestAction<Void> requestToSpeak() {
        throw this.detachedException();
    }

    @Override
    @Nonnull
    public RestAction<Void> cancelRequestToSpeak() {
        throw this.detachedException();
    }

    @Override
    @Nonnull
    public ChannelInteractionPermissions getInteractionPermissions() {
        return this.interactionPermissions;
    }

    @Override
    public DetachedStageChannelImpl setBitrate(int bitrate) {
        this.bitrate = bitrate;
        return this;
    }

    @Override
    public DetachedStageChannelImpl setUserLimit(int userlimit) {
        this.userlimit = userlimit;
        return this;
    }

    @Override
    public DetachedStageChannelImpl setRegion(String region) {
        this.region = region;
        return this;
    }

    @Override
    public DetachedStageChannelImpl setNSFW(boolean ageRestricted) {
        this.ageRestricted = ageRestricted;
        return this;
    }

    @Override
    public DetachedStageChannelImpl setSlowmode(int slowmode) {
        this.slowmode = slowmode;
        return this;
    }

    @Override
    public DetachedStageChannelImpl setLatestMessageIdLong(long latestMessageId) {
        this.latestMessageId = latestMessageId;
        return this;
    }

    @Override
    @Nonnull
    public DetachedStageChannelImpl setInteractionPermissions(@Nonnull ChannelInteractionPermissions interactionPermissions) {
        this.interactionPermissions = interactionPermissions;
        return this;
    }
}

