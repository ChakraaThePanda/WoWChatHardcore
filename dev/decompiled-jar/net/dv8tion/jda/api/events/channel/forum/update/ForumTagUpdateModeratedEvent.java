/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.channel.forum.update;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.attribute.IPostContainer;
import net.dv8tion.jda.api.entities.channel.forums.ForumTag;
import net.dv8tion.jda.api.events.channel.forum.update.GenericForumTagUpdateEvent;

public class ForumTagUpdateModeratedEvent
extends GenericForumTagUpdateEvent<Boolean> {
    public static final String IDENTIFIER = "moderated";

    public ForumTagUpdateModeratedEvent(@Nonnull JDA api2, long responseNumber, @Nonnull IPostContainer channel, @Nonnull ForumTag tag, boolean previous) {
        super(api2, responseNumber, channel, tag, previous, tag.isModerated(), IDENTIFIER);
    }

    @Override
    @Nonnull
    public Boolean getOldValue() {
        return (Boolean)super.getOldValue();
    }

    @Override
    @Nonnull
    public Boolean getNewValue() {
        return (Boolean)super.getNewValue();
    }
}

