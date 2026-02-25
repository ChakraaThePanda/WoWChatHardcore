/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.handle;

import net.dv8tion.jda.api.entities.channel.concrete.ThreadChannel;
import net.dv8tion.jda.api.events.thread.ThreadRevealedEvent;
import net.dv8tion.jda.api.utils.data.DataArray;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.JDAImpl;
import net.dv8tion.jda.internal.entities.EntityBuilder;
import net.dv8tion.jda.internal.handle.SocketHandler;

public class ThreadListSyncHandler
extends SocketHandler {
    public ThreadListSyncHandler(JDAImpl api2) {
        super(api2);
    }

    @Override
    protected Long handleInternally(DataObject content) {
        long guildId = content.getLong("guild_id");
        if (this.api.getGuildSetupController().isLocked(guildId)) {
            return guildId;
        }
        EntityBuilder entityBuilder = this.api.getEntityBuilder();
        DataArray threadsArrayJson = content.getArray("threads");
        for (int i = 0; i < threadsArrayJson.length(); ++i) {
            DataObject threadJson = threadsArrayJson.getObject(i);
            try {
                ThreadChannel thread2 = entityBuilder.createThreadChannel(threadJson, guildId);
                this.api.handleEvent(new ThreadRevealedEvent(this.api, this.responseNumber, thread2));
                continue;
            }
            catch (IllegalArgumentException ex) {
                if (!"MISSING_CHANNEL".equals(ex.getMessage())) {
                    throw ex;
                }
                EntityBuilder.LOG.debug("Discarding thread on sync because of missing parent channel cache. JSON: {}", (Object)threadJson);
            }
        }
        return null;
    }
}

