/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.handle;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.unions.AudioChannelUnion;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.JDAImpl;
import net.dv8tion.jda.internal.entities.GuildImpl;
import net.dv8tion.jda.internal.entities.GuildVoiceStateImpl;
import net.dv8tion.jda.internal.entities.MemberImpl;
import net.dv8tion.jda.internal.entities.UserImpl;
import net.dv8tion.jda.internal.handle.EventCache;
import net.dv8tion.jda.internal.handle.SocketHandler;
import net.dv8tion.jda.internal.utils.UnlockHook;
import net.dv8tion.jda.internal.utils.cache.SnowflakeCacheViewImpl;

public class GuildMemberRemoveHandler
extends SocketHandler {
    public GuildMemberRemoveHandler(JDAImpl api2) {
        super(api2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected Long handleInternally(DataObject content) {
        long id = content.getLong("guild_id");
        boolean setup = this.getJDA().getGuildSetupController().onRemoveMember(id, content);
        if (setup) {
            return null;
        }
        GuildImpl guild = (GuildImpl)this.getJDA().getGuildsView().get(id);
        if (guild == null) {
            return null;
        }
        long userId = content.getObject("user").getUnsignedLong("id");
        if (userId == this.getJDA().getSelfUser().getIdLong()) {
            return null;
        }
        try {
            UserImpl user = this.api.getEntityBuilder().createUser(content.getObject("user"));
            GuildVoiceStateImpl voiceState = guild.getVoiceStateView().getElementById(userId);
            if (voiceState != null && voiceState.inAudioChannel()) {
                AudioChannelUnion channel = voiceState.getChannel();
                voiceState.updateConnectedChannel(null);
                this.getJDA().handleEvent(new GuildVoiceUpdateEvent(this.getJDA(), this.responseNumber, voiceState.getMember(), channel));
            }
            MemberImpl member = (MemberImpl)guild.getMembersView().remove(userId);
            SnowflakeCacheViewImpl<User> userView = this.getJDA().getUsersView();
            try (UnlockHook hook = userView.writeLock();){
                if (user.getMutualGuilds().isEmpty()) {
                    userView.remove(userId);
                    this.getJDA().getEventCache().clear(EventCache.Type.USER, userId);
                }
            }
            this.getJDA().handleEvent(new GuildMemberRemoveEvent(this.getJDA(), this.responseNumber, guild, user, member));
            Long l = null;
            return l;
        }
        finally {
            guild.onMemberRemove(userId);
        }
    }
}

