/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.handle;

import gnu.trove.set.TLongSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.LongStream;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.entities.channel.ChannelFlag;
import net.dv8tion.jda.api.entities.channel.concrete.ThreadChannel;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.events.channel.update.ChannelUpdateAppliedTagsEvent;
import net.dv8tion.jda.api.events.channel.update.ChannelUpdateArchiveTimestampEvent;
import net.dv8tion.jda.api.events.channel.update.ChannelUpdateArchivedEvent;
import net.dv8tion.jda.api.events.channel.update.ChannelUpdateAutoArchiveDurationEvent;
import net.dv8tion.jda.api.events.channel.update.ChannelUpdateFlagsEvent;
import net.dv8tion.jda.api.events.channel.update.ChannelUpdateInvitableEvent;
import net.dv8tion.jda.api.events.channel.update.ChannelUpdateLockedEvent;
import net.dv8tion.jda.api.events.channel.update.ChannelUpdateNameEvent;
import net.dv8tion.jda.api.events.channel.update.ChannelUpdateSlowmodeEvent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import net.dv8tion.jda.api.utils.data.DataArray;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.JDAImpl;
import net.dv8tion.jda.internal.entities.channel.concrete.ThreadChannelImpl;
import net.dv8tion.jda.internal.handle.EventCache;
import net.dv8tion.jda.internal.handle.SocketHandler;
import net.dv8tion.jda.internal.utils.Helpers;
import net.dv8tion.jda.internal.utils.cache.ChannelCacheViewImpl;
import net.dv8tion.jda.internal.utils.cache.SortedChannelCacheViewImpl;

public class ThreadUpdateHandler
extends SocketHandler {
    public ThreadUpdateHandler(JDAImpl api2) {
        super(api2);
    }

    @Override
    protected Long handleInternally(DataObject content) {
        long guildId = content.getLong("guild_id");
        if (this.api.getGuildSetupController().isLocked(guildId)) {
            return guildId;
        }
        long threadId = content.getLong("id");
        ThreadChannelImpl thread2 = (ThreadChannelImpl)this.getJDA().getThreadChannelById(threadId);
        if (thread2 == null) {
            if (content.getObject("thread_metadata").getBoolean("archived")) {
                return null;
            }
            try {
                thread2 = (ThreadChannelImpl)this.api.getEntityBuilder().createThreadChannel(content, guildId);
                this.api.handleEvent(new ChannelUpdateArchivedEvent(this.api, this.responseNumber, thread2, true, false));
            }
            catch (IllegalArgumentException ex) {
                if ("MISSING_CHANNEL".equals(ex.getMessage())) {
                    long parentId = content.getUnsignedLong("parent_id", 0L);
                    EventCache.LOG.debug("Caching THREAD_UPDATE for a thread with uncached parent. Parent ID: {} JSON: {}", (Object)parentId, (Object)content);
                    this.api.getEventCache().cache(EventCache.Type.CHANNEL, parentId, this.responseNumber, this.allContent, this::handle);
                    return null;
                }
                throw ex;
            }
            return null;
        }
        DataObject threadMetadata = content.getObject("thread_metadata");
        String name = content.getString("name");
        int flags = content.getInt("flags", 0);
        ThreadChannel.AutoArchiveDuration autoArchiveDuration = ThreadChannel.AutoArchiveDuration.fromKey(threadMetadata.getInt("auto_archive_duration"));
        boolean locked = threadMetadata.getBoolean("locked");
        boolean archived = threadMetadata.getBoolean("archived");
        boolean invitable = threadMetadata.getBoolean("invitable");
        long archiveTimestamp = Helpers.toTimestamp(threadMetadata.getString("archive_timestamp"));
        int slowmode = content.getInt("rate_limit_per_user", 0);
        String oldName = thread2.getName();
        ThreadChannel.AutoArchiveDuration oldAutoArchiveDuration = thread2.getAutoArchiveDuration();
        boolean oldLocked = thread2.isLocked();
        boolean oldArchived = thread2.isArchived();
        boolean oldInvitable = !thread2.isPublic() && thread2.isInvitable();
        long oldArchiveTimestamp = thread2.getArchiveTimestamp();
        int oldSlowmode = thread2.getSlowmode();
        int oldFlags = thread2.getRawFlags();
        if (!Objects.equals(oldName, name)) {
            thread2.setName(name);
            this.api.handleEvent(new ChannelUpdateNameEvent(this.getJDA(), this.responseNumber, thread2, oldName, name));
        }
        if (oldFlags != flags) {
            thread2.setFlags(flags);
            this.api.handleEvent(new ChannelUpdateFlagsEvent(this.getJDA(), this.responseNumber, thread2, ChannelFlag.fromRaw(oldFlags), ChannelFlag.fromRaw(flags)));
        }
        if (oldSlowmode != slowmode) {
            thread2.setSlowmode(slowmode);
            this.api.handleEvent(new ChannelUpdateSlowmodeEvent(this.api, this.responseNumber, thread2, oldSlowmode, slowmode));
        }
        if (oldAutoArchiveDuration != autoArchiveDuration) {
            thread2.setAutoArchiveDuration(autoArchiveDuration);
            this.api.handleEvent(new ChannelUpdateAutoArchiveDurationEvent(this.api, this.responseNumber, thread2, oldAutoArchiveDuration, autoArchiveDuration));
        }
        if (oldLocked != locked) {
            thread2.setLocked(locked);
            this.api.handleEvent(new ChannelUpdateLockedEvent(this.api, this.responseNumber, thread2, oldLocked, locked));
        }
        if (oldArchived != archived) {
            thread2.setArchived(archived);
            this.api.handleEvent(new ChannelUpdateArchivedEvent(this.api, this.responseNumber, thread2, oldArchived, archived));
        }
        if (oldArchiveTimestamp != archiveTimestamp) {
            thread2.setArchiveTimestamp(archiveTimestamp);
            this.api.handleEvent(new ChannelUpdateArchiveTimestampEvent(this.api, this.responseNumber, thread2, oldArchiveTimestamp, archiveTimestamp));
        }
        if (oldInvitable != invitable) {
            thread2.setInvitable(invitable);
            this.api.handleEvent(new ChannelUpdateInvitableEvent(this.api, this.responseNumber, thread2, oldInvitable, invitable));
        }
        if (this.api.isCacheFlagSet(CacheFlag.FORUM_TAGS) && !content.isNull("applied_tags")) {
            TLongSet oldTags = thread2.getAppliedTagsSet();
            thread2.setAppliedTags(content.getArray("applied_tags").stream(DataArray::getUnsignedLong).mapToLong(Long::longValue));
            TLongSet tags = thread2.getAppliedTagsSet();
            if (!oldTags.equals(tags)) {
                List<Long> oldTagList = LongStream.of(oldTags.toArray()).boxed().collect(Helpers.toUnmodifiableList());
                List<Long> newTagList = LongStream.of(tags.toArray()).boxed().collect(Helpers.toUnmodifiableList());
                this.api.handleEvent(new ChannelUpdateAppliedTagsEvent(this.api, this.responseNumber, thread2, oldTagList, newTagList));
            }
        }
        if (thread2.isArchived()) {
            SortedChannelCacheViewImpl<GuildChannel> guildView = thread2.getGuild().getChannelView();
            ChannelCacheViewImpl<Channel> globalView = this.api.getChannelsView();
            guildView.remove(thread2);
            globalView.remove(thread2);
        }
        return null;
    }
}

