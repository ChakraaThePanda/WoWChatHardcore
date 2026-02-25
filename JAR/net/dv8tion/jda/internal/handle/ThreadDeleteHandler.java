/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.handle;

import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.entities.channel.concrete.ThreadChannel;
import net.dv8tion.jda.api.events.channel.ChannelDeleteEvent;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.JDAImpl;
import net.dv8tion.jda.internal.entities.GuildImpl;
import net.dv8tion.jda.internal.handle.EventCache;
import net.dv8tion.jda.internal.handle.SocketHandler;
import net.dv8tion.jda.internal.requests.WebSocketClient;
import net.dv8tion.jda.internal.utils.cache.ChannelCacheViewImpl;

public class ThreadDeleteHandler
extends SocketHandler {
    public ThreadDeleteHandler(JDAImpl api2) {
        super(api2);
    }

    @Override
    protected Long handleInternally(DataObject content) {
        long guildId = content.getLong("guild_id");
        if (this.getJDA().getGuildSetupController().isLocked(guildId)) {
            return guildId;
        }
        GuildImpl guild = (GuildImpl)this.getJDA().getGuildById(guildId);
        long threadId = content.getLong("id");
        ChannelCacheViewImpl<Channel> channelsView = this.getJDA().getChannelsView();
        ThreadChannel thread2 = (ThreadChannel)((ChannelCacheViewImpl.FilteredCacheView)channelsView.ofType(ThreadChannel.class)).getElementById(threadId);
        if (thread2 == null || guild == null) {
            WebSocketClient.LOG.debug("THREAD_DELETE attempted to delete a thread that is not yet cached. JSON: {}", (Object)content);
            return null;
        }
        channelsView.remove(thread2.getType(), threadId);
        guild.getChannelView().remove(thread2);
        this.getJDA().handleEvent(new ChannelDeleteEvent(this.getJDA(), this.responseNumber, thread2));
        this.getJDA().getEventCache().clear(EventCache.Type.CHANNEL, threadId);
        return null;
    }
}

