/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.channel.forum;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.attribute.IPostContainer;
import net.dv8tion.jda.api.entities.channel.forums.ForumTag;
import net.dv8tion.jda.api.events.channel.forum.GenericForumTagEvent;

public class ForumTagRemoveEvent
extends GenericForumTagEvent {
    public ForumTagRemoveEvent(@Nonnull JDA api2, long responseNumber, @Nonnull IPostContainer channel, @Nonnull ForumTag tag) {
        super(api2, responseNumber, channel, tag);
    }
}

