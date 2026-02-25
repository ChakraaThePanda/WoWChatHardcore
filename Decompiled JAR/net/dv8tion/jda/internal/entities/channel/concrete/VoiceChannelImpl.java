/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.entities.channel.concrete;

import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.managers.channel.concrete.VoiceChannelManager;
import net.dv8tion.jda.api.requests.Route;
import net.dv8tion.jda.api.requests.restaction.AuditableRestAction;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.entities.GuildImpl;
import net.dv8tion.jda.internal.entities.channel.middleman.AbstractStandardGuildChannelImpl;
import net.dv8tion.jda.internal.entities.channel.mixin.concrete.VoiceChannelMixin;
import net.dv8tion.jda.internal.managers.channel.concrete.VoiceChannelManagerImpl;
import net.dv8tion.jda.internal.requests.restaction.AuditableRestActionImpl;
import net.dv8tion.jda.internal.utils.Checks;

public class VoiceChannelImpl
extends AbstractStandardGuildChannelImpl<VoiceChannelImpl>
implements VoiceChannel,
VoiceChannelMixin<VoiceChannelImpl> {
    private String region;
    private String status = "";
    private long latestMessageId;
    private int bitrate;
    private int userLimit;
    private int slowmode;
    private boolean nsfw;

    public VoiceChannelImpl(long id, GuildImpl guild) {
        super(id, guild);
    }

    @Override
    public boolean isDetached() {
        return false;
    }

    @Override
    @Nonnull
    public GuildImpl getGuild() {
        return (GuildImpl)super.getGuild();
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
        return this.getGuild().getConnectedMembers(this);
    }

    @Override
    @Nonnull
    public VoiceChannelManager getManager() {
        return new VoiceChannelManagerImpl(this);
    }

    @Override
    @Nonnull
    public String getStatus() {
        return this.status;
    }

    @Override
    @Nonnull
    public AuditableRestAction<Void> modifyStatus(@Nonnull String status) {
        Checks.notLonger(status, 500, "Voice Status");
        this.checkCanAccess();
        if (this.equals(this.getGuild().getSelfMember().getVoiceState().getChannel())) {
            this.checkPermission(Permission.VOICE_SET_STATUS);
        } else {
            this.checkCanManage();
        }
        Route.CompiledRoute route = Route.Channels.SET_STATUS.compile(this.getId());
        DataObject body = DataObject.empty().put("status", status);
        return new AuditableRestActionImpl<Void>((JDA)this.api, route, body);
    }

    @Override
    public VoiceChannelImpl setBitrate(int bitrate) {
        this.bitrate = bitrate;
        return this;
    }

    @Override
    public VoiceChannelImpl setRegion(String region) {
        this.region = region;
        return this;
    }

    @Override
    public VoiceChannelImpl setUserLimit(int userLimit) {
        this.userLimit = userLimit;
        return this;
    }

    @Override
    public VoiceChannelImpl setNSFW(boolean nsfw) {
        this.nsfw = nsfw;
        return this;
    }

    @Override
    public VoiceChannelImpl setSlowmode(int slowmode) {
        this.slowmode = slowmode;
        return this;
    }

    @Override
    public VoiceChannelImpl setLatestMessageIdLong(long latestMessageId) {
        this.latestMessageId = latestMessageId;
        return this;
    }

    @Override
    public VoiceChannelImpl setStatus(String status) {
        this.status = status;
        return this;
    }
}

