/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.channel.update;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.ChannelField;
import net.dv8tion.jda.api.entities.channel.attribute.IPostContainer;
import net.dv8tion.jda.api.entities.emoji.EmojiUnion;
import net.dv8tion.jda.api.events.channel.update.GenericChannelUpdateEvent;

public class ChannelUpdateDefaultReactionEvent
extends GenericChannelUpdateEvent<EmojiUnion> {
    public static final ChannelField FIELD = ChannelField.DEFAULT_REACTION_EMOJI;
    public static final String IDENTIFIER = FIELD.getFieldName();

    public ChannelUpdateDefaultReactionEvent(@Nonnull JDA api2, long responseNumber, @Nonnull IPostContainer channel, @Nullable EmojiUnion oldValue, @Nullable EmojiUnion newValue) {
        super(api2, responseNumber, channel, FIELD, oldValue, newValue);
    }
}

