/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.channel.forum.update;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.attribute.IPostContainer;
import net.dv8tion.jda.api.entities.channel.forums.ForumTag;
import net.dv8tion.jda.api.entities.emoji.EmojiUnion;
import net.dv8tion.jda.api.events.channel.forum.update.GenericForumTagUpdateEvent;

public class ForumTagUpdateEmojiEvent
extends GenericForumTagUpdateEvent<EmojiUnion> {
    public static final String IDENTIFIER = "emoji";

    public ForumTagUpdateEmojiEvent(@Nonnull JDA api2, long responseNumber, @Nonnull IPostContainer channel, @Nonnull ForumTag tag, @Nullable EmojiUnion previous) {
        super(api2, responseNumber, channel, tag, previous, tag.getEmoji(), IDENTIFIER);
    }

    @Nullable
    public EmojiUnion getOldEmoji() {
        return (EmojiUnion)this.getOldValue();
    }

    @Nullable
    public EmojiUnion getNewEmoji() {
        return (EmojiUnion)this.getNewValue();
    }
}

