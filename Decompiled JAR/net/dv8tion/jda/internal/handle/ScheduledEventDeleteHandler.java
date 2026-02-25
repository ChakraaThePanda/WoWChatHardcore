/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.handle;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.ScheduledEvent;
import net.dv8tion.jda.api.events.guild.scheduledevent.ScheduledEventDeleteEvent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.JDAImpl;
import net.dv8tion.jda.internal.entities.GuildImpl;
import net.dv8tion.jda.internal.handle.EventCache;
import net.dv8tion.jda.internal.handle.SocketHandler;

public class ScheduledEventDeleteHandler
extends SocketHandler {
    public ScheduledEventDeleteHandler(JDAImpl api2) {
        super(api2);
    }

    @Override
    protected Long handleInternally(DataObject content) {
        if (!this.getJDA().isCacheFlagSet(CacheFlag.SCHEDULED_EVENTS)) {
            return null;
        }
        long guildId = content.getLong("guild_id");
        if (this.getJDA().getGuildSetupController().isLocked(guildId)) {
            return guildId;
        }
        GuildImpl guild = (GuildImpl)this.getJDA().getGuildById(guildId);
        if (guild == null) {
            EventCache.LOG.debug("SCHEDULED_EVENT_DELETE was received for a Guild that is not yet cached: {}", (Object)content);
            return null;
        }
        long eventId = content.getLong("id");
        ScheduledEvent removedEvent = (ScheduledEvent)guild.getScheduledEventsView().remove(eventId);
        if (removedEvent != null) {
            this.getJDA().handleEvent(new ScheduledEventDeleteEvent((JDA)this.getJDA(), this.responseNumber, removedEvent));
        }
        return null;
    }
}

