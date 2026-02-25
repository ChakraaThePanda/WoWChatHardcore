/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.entities;

import gnu.trove.map.TLongObjectMap;
import gnu.trove.map.hash.TLongObjectHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Widget;
import net.dv8tion.jda.api.utils.ImageProxy;
import net.dv8tion.jda.api.utils.MiscUtil;
import net.dv8tion.jda.api.utils.data.DataArray;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.entities.EntityBuilder;
import net.dv8tion.jda.internal.utils.EntityString;

public class WidgetImpl
implements Widget {
    private final boolean isAvailable;
    private final long id;
    private final String name;
    private final String invite;
    private final TLongObjectMap<VoiceChannelImpl> channels;
    private final TLongObjectMap<Widget.Member> members;

    public WidgetImpl(long guildId) {
        this.isAvailable = false;
        this.id = guildId;
        this.name = null;
        this.invite = null;
        this.channels = new TLongObjectHashMap<VoiceChannelImpl>();
        this.members = new TLongObjectHashMap<Widget.Member>();
    }

    public WidgetImpl(@Nonnull DataObject json) {
        String inviteCode = json.getString("instant_invite", null);
        if (inviteCode != null) {
            inviteCode = inviteCode.substring(inviteCode.lastIndexOf("/") + 1);
        }
        this.isAvailable = true;
        this.id = json.getLong("id");
        this.name = json.getString("name");
        this.invite = inviteCode;
        this.channels = MiscUtil.newLongMap();
        this.members = MiscUtil.newLongMap();
        DataArray channelsJson = json.getArray("channels");
        for (int i = 0; i < channelsJson.length(); ++i) {
            DataObject channel = channelsJson.getObject(i);
            this.channels.put(channel.getLong("id"), new VoiceChannelImpl(channel, this));
        }
        DataArray membersJson = json.getArray("members");
        for (int i = 0; i < membersJson.length(); ++i) {
            DataObject memberJson = membersJson.getObject(i);
            MemberImpl member = new MemberImpl(memberJson, this);
            if (!memberJson.isNull("channel_id")) {
                VoiceChannelImpl channel = this.channels.get(memberJson.getLong("channel_id"));
                member.setVoiceState(new VoiceStateImpl(channel, memberJson.getBoolean("mute"), memberJson.getBoolean("deaf"), memberJson.getBoolean("suppress"), memberJson.getBoolean("self_mute"), memberJson.getBoolean("self_deaf"), member, this));
                channel.addMember(member);
            }
            this.members.put(member.getIdLong(), member);
        }
    }

    @Override
    public boolean isAvailable() {
        return this.isAvailable;
    }

    @Override
    public long getIdLong() {
        return this.id;
    }

    @Override
    @Nonnull
    public String getName() {
        this.checkAvailable();
        return this.name;
    }

    @Override
    @Nullable
    public String getInviteCode() {
        this.checkAvailable();
        return this.invite;
    }

    @Override
    @Nonnull
    public List<Widget.VoiceChannel> getVoiceChannels() {
        this.checkAvailable();
        return Collections.unmodifiableList(new ArrayList<VoiceChannelImpl>(this.channels.valueCollection()));
    }

    @Override
    @Nullable
    public Widget.VoiceChannel getVoiceChannelById(@Nonnull String id) {
        this.checkAvailable();
        return this.channels.get(MiscUtil.parseSnowflake(id));
    }

    @Override
    @Nullable
    public Widget.VoiceChannel getVoiceChannelById(long id) {
        this.checkAvailable();
        return this.channels.get(id);
    }

    @Override
    @Nonnull
    public List<Widget.Member> getMembers() {
        this.checkAvailable();
        return Collections.unmodifiableList(new ArrayList<Widget.Member>(this.members.valueCollection()));
    }

    @Override
    @Nullable
    public Widget.Member getMemberById(@Nonnull String id) {
        this.checkAvailable();
        return this.members.get(MiscUtil.parseSnowflake(id));
    }

    @Override
    @Nullable
    public Widget.Member getMemberById(long id) {
        this.checkAvailable();
        return this.members.get(id);
    }

    public int hashCode() {
        return Long.hashCode(this.id);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof WidgetImpl)) {
            return false;
        }
        WidgetImpl oWidget = (WidgetImpl)obj;
        return this == oWidget || this.id == oWidget.getIdLong();
    }

    public String toString() {
        EntityString entityString = new EntityString(this);
        if (this.isAvailable()) {
            entityString.setName(this.getName());
        }
        return entityString.toString();
    }

    private void checkAvailable() {
        if (!this.isAvailable) {
            throw new IllegalStateException("The widget for this Guild is unavailable!");
        }
    }

    public class VoiceChannelImpl
    implements Widget.VoiceChannel {
        private final int position;
        private final long id;
        private final String name;
        private final List<Widget.Member> members;
        private final Widget widget;

        private VoiceChannelImpl(@Nonnull DataObject json, Widget widget) {
            this.widget = widget;
            this.position = json.getInt("position");
            this.id = json.getLong("id");
            this.name = json.getString("name");
            this.members = new ArrayList<Widget.Member>();
        }

        private void addMember(@Nonnull Widget.Member member) {
            this.members.add(member);
        }

        @Override
        public int getPosition() {
            return this.position;
        }

        @Override
        public long getIdLong() {
            return this.id;
        }

        @Override
        @Nonnull
        public String getName() {
            return this.name;
        }

        @Override
        @Nonnull
        public List<Widget.Member> getMembers() {
            return this.members;
        }

        @Override
        @Nonnull
        public Widget getWidget() {
            return this.widget;
        }

        public int hashCode() {
            return Long.hashCode(this.id);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Widget.VoiceChannel)) {
                return false;
            }
            Widget.VoiceChannel oVChannel = (Widget.VoiceChannel)obj;
            return this == oVChannel || this.id == oVChannel.getIdLong();
        }

        public String toString() {
            return new EntityString(this).setName(this.getName()).toString();
        }
    }

    public class MemberImpl
    implements Widget.Member {
        private final boolean bot;
        private final long id;
        private final String username;
        private final String discriminator;
        private final String avatar;
        private final String nickname;
        private final OnlineStatus status;
        private final Activity game;
        private final WidgetImpl widget;
        private Widget.VoiceState state;

        private MemberImpl(@Nonnull DataObject json, WidgetImpl widget) {
            this.widget = widget;
            this.bot = json.getBoolean("bot");
            this.id = json.getLong("id");
            this.username = json.getString("username");
            this.discriminator = json.getString("discriminator");
            this.avatar = json.getString("avatar", null);
            this.nickname = json.getString("nick", null);
            this.status = OnlineStatus.fromKey(json.getString("status"));
            this.game = json.isNull("game") ? null : EntityBuilder.createActivity(json.getObject("game"));
        }

        private void setVoiceState(Widget.VoiceState voiceState) {
            this.state = voiceState;
        }

        @Override
        public boolean isBot() {
            return this.bot;
        }

        @Override
        @Nonnull
        public String getName() {
            return this.username;
        }

        @Override
        public long getIdLong() {
            return this.id;
        }

        @Override
        @Nonnull
        public String getAsMention() {
            return "<@" + this.getId() + ">";
        }

        @Override
        @Nonnull
        public String getDiscriminator() {
            return this.discriminator;
        }

        @Override
        @Nullable
        public String getAvatarId() {
            return this.avatar;
        }

        @Override
        @Nullable
        public String getAvatarUrl() {
            String avatarId = this.getAvatarId();
            return avatarId == null ? null : String.format("https://cdn.discordapp.com/avatars/%s/%s.%s", this.getId(), avatarId, avatarId.startsWith("a_") ? ".gif" : ".png");
        }

        @Override
        @Nullable
        public ImageProxy getAvatar() {
            String avatarUrl = this.getAvatarUrl();
            return avatarUrl == null ? null : new ImageProxy(avatarUrl);
        }

        @Override
        @Nonnull
        public String getDefaultAvatarId() {
            return String.valueOf(Integer.parseInt(this.getDiscriminator()) % 5);
        }

        @Override
        @Nonnull
        public String getDefaultAvatarUrl() {
            return String.format("https://cdn.discordapp.com/embed/avatars/%s.png", this.getDefaultAvatarId());
        }

        @Override
        @Nonnull
        public ImageProxy getDefaultAvatar() {
            return new ImageProxy(this.getDefaultAvatarUrl());
        }

        @Override
        @Nonnull
        public String getEffectiveAvatarUrl() {
            String avatarUrl = this.getAvatarUrl();
            return avatarUrl == null ? this.getDefaultAvatarUrl() : avatarUrl;
        }

        @Override
        @Nonnull
        public ImageProxy getEffectiveAvatar() {
            return new ImageProxy(this.getEffectiveAvatarUrl());
        }

        @Override
        @Nullable
        public String getNickname() {
            return this.nickname;
        }

        @Override
        @Nonnull
        public String getEffectiveName() {
            return this.nickname == null ? this.username : this.nickname;
        }

        @Override
        @Nonnull
        public OnlineStatus getOnlineStatus() {
            return this.status;
        }

        @Override
        @Nullable
        public Activity getActivity() {
            return this.game;
        }

        @Override
        @Nonnull
        public Widget.VoiceState getVoiceState() {
            return this.state == null ? new VoiceStateImpl(this, this.widget) : this.state;
        }

        @Override
        @Nonnull
        public WidgetImpl getWidget() {
            return this.widget;
        }

        public int hashCode() {
            return (this.widget.getId() + ' ' + this.id).hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Widget.Member)) {
                return false;
            }
            Widget.Member oMember = (Widget.Member)obj;
            return this == oMember || this.id == oMember.getIdLong() && this.widget.getIdLong() == oMember.getWidget().getIdLong();
        }

        public String toString() {
            return new EntityString(this).setName(this.getName()).toString();
        }
    }

    public class VoiceStateImpl
    implements Widget.VoiceState {
        private final Widget.VoiceChannel channel;
        private final boolean muted;
        private final boolean deafened;
        private final boolean suppress;
        private final boolean selfMute;
        private final boolean selfDeaf;
        private final Widget.Member member;
        private final Widget widget;

        private VoiceStateImpl(@Nonnull Widget.Member member, Widget widget) {
            this(null, false, false, false, false, false, member, widget);
        }

        private VoiceStateImpl(Widget.VoiceChannel channel, boolean muted, boolean deafened, boolean suppress, boolean selfMute, @Nonnull boolean selfDeaf, @Nonnull Widget.Member member, Widget widget) {
            this.channel = channel;
            this.muted = muted;
            this.deafened = deafened;
            this.suppress = suppress;
            this.selfMute = selfMute;
            this.selfDeaf = selfDeaf;
            this.member = member;
            this.widget = widget;
        }

        @Override
        @Nullable
        public Widget.VoiceChannel getChannel() {
            return this.channel;
        }

        @Override
        public boolean inVoiceChannel() {
            return this.channel != null;
        }

        @Override
        public boolean isGuildMuted() {
            return this.muted;
        }

        @Override
        public boolean isGuildDeafened() {
            return this.deafened;
        }

        @Override
        public boolean isSuppressed() {
            return this.suppress;
        }

        @Override
        public boolean isSelfMuted() {
            return this.selfMute;
        }

        @Override
        public boolean isSelfDeafened() {
            return this.selfDeaf;
        }

        @Override
        public boolean isMuted() {
            return this.selfMute || this.muted;
        }

        @Override
        public boolean isDeafened() {
            return this.selfDeaf || this.deafened;
        }

        @Override
        @Nonnull
        public Widget.Member getMember() {
            return this.member;
        }

        @Override
        @Nonnull
        public Widget getWidget() {
            return this.widget;
        }

        public int hashCode() {
            return this.member.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Widget.VoiceState)) {
                return false;
            }
            Widget.VoiceState oState = (Widget.VoiceState)obj;
            return this == oState || this.member.equals(oState.getMember()) && this.widget.equals(oState.getWidget());
        }

        public String toString() {
            return new EntityString(this).setName(this.widget.getName()).addMetadata("memberName", this.member.getEffectiveName()).toString();
        }
    }
}

