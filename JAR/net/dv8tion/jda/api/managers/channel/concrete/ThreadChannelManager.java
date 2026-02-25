/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.managers.channel.concrete;

import java.util.Arrays;
import java.util.Collection;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.channel.concrete.ThreadChannel;
import net.dv8tion.jda.api.entities.channel.forums.ForumTagSnowflake;
import net.dv8tion.jda.api.managers.channel.ChannelManager;
import net.dv8tion.jda.api.managers.channel.attribute.ISlowmodeChannelManager;
import net.dv8tion.jda.internal.utils.Checks;

public interface ThreadChannelManager
extends ChannelManager<ThreadChannel, ThreadChannelManager>,
ISlowmodeChannelManager<ThreadChannel, ThreadChannelManager> {
    @Nonnull
    @CheckReturnValue
    public ThreadChannelManager setAutoArchiveDuration(@Nonnull ThreadChannel.AutoArchiveDuration var1);

    @Nonnull
    @CheckReturnValue
    public ThreadChannelManager setArchived(boolean var1);

    @Nonnull
    @CheckReturnValue
    public ThreadChannelManager setLocked(boolean var1);

    @Nonnull
    @CheckReturnValue
    public ThreadChannelManager setInvitable(boolean var1);

    @Nonnull
    @CheckReturnValue
    public ThreadChannelManager setPinned(boolean var1);

    @Nonnull
    @CheckReturnValue
    public ThreadChannelManager setAppliedTags(@Nonnull Collection<? extends ForumTagSnowflake> var1);

    @Nonnull
    @CheckReturnValue
    default public ThreadChannelManager setAppliedTags(ForumTagSnowflake ... tags) {
        Checks.noneNull(tags, "Tags");
        return this.setAppliedTags(Arrays.asList(tags));
    }
}

