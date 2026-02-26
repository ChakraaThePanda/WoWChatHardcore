/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.entities.channel.concrete;

import java.time.OffsetDateTime;
import java.util.EnumSet;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.StageInstance;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.concrete.StageChannel;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;
import net.dv8tion.jda.api.managers.channel.concrete.StageChannelManager;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.requests.Route;
import net.dv8tion.jda.api.requests.restaction.StageInstanceAction;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.entities.GuildImpl;
import net.dv8tion.jda.internal.entities.channel.middleman.AbstractStandardGuildChannelImpl;
import net.dv8tion.jda.internal.entities.channel.mixin.concrete.StageChannelMixin;
import net.dv8tion.jda.internal.managers.channel.concrete.StageChannelManagerImpl;
import net.dv8tion.jda.internal.requests.RestActionImpl;
import net.dv8tion.jda.internal.requests.restaction.StageInstanceActionImpl;
import net.dv8tion.jda.internal.utils.Checks;

public class StageChannelImpl
extends AbstractStandardGuildChannelImpl<StageChannelImpl>
implements StageChannel,
StageChannelMixin<StageChannelImpl> {
    private StageInstance instance;
    private String region;
    private int bitrate;
    private int userlimit;
    private int slowmode;
    private boolean ageRestricted;
    private long latestMessageId;

    public StageChannelImpl(long id, GuildImpl guild) {
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
        return this.instance;
    }

    @Override
    @Nonnull
    public List<Member> getMembers() {
        return this.getGuild().getConnectedMembers(this);
    }

    @Override
    @Nonnull
    public StageInstanceAction createStageInstance(@Nonnull String topic) {
        EnumSet<Permission> permissions = this.getGuild().getSelfMember().getPermissions(this);
        EnumSet<Permission> required = EnumSet.of(Permission.MANAGE_CHANNEL, Permission.VOICE_MUTE_OTHERS, Permission.VOICE_MOVE_OTHERS);
        for (Permission perm : required) {
            if (permissions.contains((Object)perm)) continue;
            throw new InsufficientPermissionException(this, perm, "You must be a stage moderator to create a stage instance! Missing Permission: " + (Object)((Object)perm));
        }
        return new StageInstanceActionImpl(this).setTopic(topic);
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
        return new StageChannelManagerImpl(this);
    }

    @Override
    @Nonnull
    public RestAction<Void> requestToSpeak() {
        GuildImpl guild = this.getGuild();
        Route.CompiledRoute route = Route.Guilds.UPDATE_VOICE_STATE.compile(guild.getId(), "@me");
        DataObject body = DataObject.empty().put("channel_id", this.getId());
        if (guild.getSelfMember().hasPermission((GuildChannel)this, Permission.VOICE_MUTE_OTHERS)) {
            body.putNull("request_to_speak_timestamp").put("suppress", false);
        } else {
            body.put("request_to_speak_timestamp", OffsetDateTime.now().toString());
        }
        if (!this.equals(guild.getSelfMember().getVoiceState().getChannel())) {
            throw new IllegalStateException("Cannot request to speak without being connected to the stage channel!");
        }
        return new RestActionImpl<Void>(this.getJDA(), route, body);
    }

    @Override
    @Nonnull
    public RestAction<Void> cancelRequestToSpeak() {
        GuildImpl guild = this.getGuild();
        Route.CompiledRoute route = Route.Guilds.UPDATE_VOICE_STATE.compile(guild.getId(), "@me");
        DataObject body = DataObject.empty().putNull("request_to_speak_timestamp").put("suppress", true).put("channel_id", this.getId());
        if (!this.equals(guild.getSelfMember().getVoiceState().getChannel())) {
            throw new IllegalStateException("Cannot cancel request to speak without being connected to the stage channel!");
        }
        return new RestActionImpl<Void>(this.getJDA(), route, body);
    }

    @Override
    public StageChannelImpl setBitrate(int bitrate) {
        this.bitrate = bitrate;
        return this;
    }

    @Override
    public StageChannelImpl setUserLimit(int userlimit) {
        this.userlimit = userlimit;
        return this;
    }

    @Override
    public StageChannelImpl setRegion(String region) {
        this.region = region;
        return this;
    }

    public StageChannelImpl setStageInstance(StageInstance instance) {
        this.instance = instance;
        return this;
    }

    @Override
    public StageChannelImpl setNSFW(boolean ageRestricted) {
        this.ageRestricted = ageRestricted;
        return this;
    }

    @Override
    public StageChannelImpl setSlowmode(int slowmode) {
        this.slowmode = slowmode;
        return this;
    }

    @Override
    public StageChannelImpl setLatestMessageIdLong(long latestMessageId) {
        this.latestMessageId = latestMessageId;
        return this;
    }
}

