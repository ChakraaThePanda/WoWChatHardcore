/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.handle;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.StageInstance;
import net.dv8tion.jda.api.events.stage.StageInstanceCreateEvent;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.JDAImpl;
import net.dv8tion.jda.internal.entities.GuildImpl;
import net.dv8tion.jda.internal.handle.EventCache;
import net.dv8tion.jda.internal.handle.SocketHandler;

public class StageInstanceCreateHandler
extends SocketHandler {
    public StageInstanceCreateHandler(JDAImpl api2) {
        super(api2);
    }

    @Override
    protected Long handleInternally(DataObject content) {
        long guildId = content.getUnsignedLong("guild_id", 0L);
        if (this.getJDA().getGuildSetupController().isLocked(guildId)) {
            return guildId;
        }
        GuildImpl guild = (GuildImpl)this.getJDA().getGuildById(guildId);
        if (guild == null) {
            EventCache.LOG.debug("Caching STAGE_INSTANCE_CREATE for uncached guild with id {}", (Object)guildId);
            this.getJDA().getEventCache().cache(EventCache.Type.GUILD, guildId, this.responseNumber, this.allContent, this::handle);
            return null;
        }
        StageInstance instance = this.getJDA().getEntityBuilder().createStageInstance(guild, content);
        if (instance != null) {
            this.getJDA().handleEvent(new StageInstanceCreateEvent((JDA)this.getJDA(), this.responseNumber, instance));
            guild.updateRequestToSpeak();
        }
        return null;
    }
}

