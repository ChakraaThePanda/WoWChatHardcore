/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.entities.channel.concrete.detached;

import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.managers.channel.concrete.VoiceChannelManager;
import net.dv8tion.jda.api.requests.restaction.AuditableRestAction;
import net.dv8tion.jda.internal.entities.channel.middleman.AbstractStandardGuildChannelImpl;
import net.dv8tion.jda.internal.entities.channel.mixin.attribute.IInteractionPermissionMixin;
import net.dv8tion.jda.internal.entities.channel.mixin.concrete.VoiceChannelMixin;
import net.dv8tion.jda.internal.entities.detached.DetachedGuildImpl;
import net.dv8tion.jda.internal.interactions.ChannelInteractionPermissions;

public class DetachedVoiceChannelImpl
extends AbstractStandardGuildChannelImpl<DetachedVoiceChannelImpl>
implements VoiceChannel,
VoiceChannelMixin<DetachedVoiceChannelImpl>,
IInteractionPermissionMixin<DetachedVoiceChannelImpl> {
    private ChannelInteractionPermissions interactionPermissions;
    private String region;
    private String status = "";
    private long latestMessageId;
    private int bitrate;
    private int userLimit;
    private int slowmode;
    private boolean nsfw;

    public DetachedVoiceChannelImpl(long id, DetachedGuildImpl guild) {
        super(id, guild);
    }

    @Override
    public boolean isDetached() {
        return true;
    }

    @Override
    @Nonnull
    public ChannelType getType() {
        return ChannelType.VOICE;
    }

    @Override
    public int getBitrate() {
        return this.bitrate;
    }

    @Override
    @Nullable
    public String getRegionRaw() {
        return this.region;
    }

    @Override
    public int getUserLimit() {
        return this.userLimit;
    }

    @Override
    public boolean isNSFW() {
        return this.nsfw;
    }

    @Override
    public int getSlowmode() {
        return this.slowmode;
    }

    @Override
    public long getLatestMessageIdLong() {
        return this.latestMessageId;
    }

    @Override
    @Nonnull
    public List<Member> getMembers() {
        throw this.detachedException();
    }

    @Override
    @Nonnull
    public VoiceChannelManager getManager() {
        throw this.detachedException();
    }

    @Override
    @Nonnull
    public String getStatus() {
        return this.status;
    }

    @Override
    @Nonnull
    public AuditableRestAction<Void> modifyStatus(@Nonnull String status) {
        throw this.detachedException();
    }

    @Override
    @Nonnull
    public ChannelInteractionPermissions getInteractionPermissions() {
        return this.interactionPermissions;
    }

    @Override
    public DetachedVoiceChannelImpl setBitrate(int bitrate) {
        this.bitrate = bitrate;
        return this;
    }

    @Override
    public DetachedVoiceChannelImpl setRegion(String region) {
        this.region = region;
        return this;
    }

    @Override
    public DetachedVoiceChannelImpl setUserLimit(int userLimit) {
        this.userLimit = userLimit;
        return this;
    }

    @Override
    public DetachedVoiceChannelImpl setNSFW(boolean nsfw) {
        this.nsfw = nsfw;
        return this;
    }

    @Override
    public DetachedVoiceChannelImpl setSlowmode(int slowmode) {
        this.slowmode = slowmode;
        return this;
    }

    @Override
    public DetachedVoiceChannelImpl setLatestMessageIdLong(long latestMessageId) {
        this.latestMessageId = latestMessageId;
        return this;
    }

    @Override
    public DetachedVoiceChannelImpl setStatus(String status) {
        this.status = status;
        return this;
    }

    @Override
    @Nonnull
    public DetachedVoiceChannelImpl setInteractionPermissions(@Nonnull ChannelInteractionPermissions interactionPermissions) {
        this.interactionPermissions = interactionPermissions;
        return this;
    }
}

