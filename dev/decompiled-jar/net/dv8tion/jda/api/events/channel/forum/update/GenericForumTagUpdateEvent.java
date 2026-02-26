/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.channel.forum.update;

import javax.annotation.Nonnull;
import net.dv8tion.jda.annotations.UnknownNullability;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.attribute.IPostContainer;
import net.dv8tion.jda.api.entities.channel.forums.ForumTag;
import net.dv8tion.jda.api.events.UpdateEvent;
import net.dv8tion.jda.api.events.channel.forum.GenericForumTagEvent;

public abstract class GenericForumTagUpdateEvent<T>
extends GenericForumTagEvent
implements UpdateEvent<ForumTag, T> {
    private final T previous;
    private final T next;
    private final String identifier;

    public GenericForumTagUpdateEvent(@Nonnull JDA api2, long responseNumber, @Nonnull IPostContainer channel, @Nonnull ForumTag tag, T previous, T next, @Nonnull String identifier) {
        super(api2, responseNumber, channel, tag);
        this.previous = previous;
        this.next = next;
        this.identifier = identifier;
    }

    @Override
    @Nonnull
    public ForumTag getEntity() {
        return this.getTag();
    }

    @Override
    @UnknownNullability
    public T getOldValue() {
        return this.previous;
    }

    @Override
    @UnknownNullability
    public T getNewValue() {
        return this.next;
    }

    @Override
    @Nonnull
    public String getPropertyIdentifier() {
        return this.identifier;
    }
}

