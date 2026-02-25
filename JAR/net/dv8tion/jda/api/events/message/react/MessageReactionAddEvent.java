/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.message.react;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.react.GenericMessageReactionEvent;

public class MessageReactionAddEvent
extends GenericMessageReactionEvent {
    private final long messageAuthorId;

    public MessageReactionAddEvent(@Nonnull JDA api2, long responseNumber, @Nullable User user, @Nullable Member member, @Nonnull MessageReaction reaction, long userId, long messageAuthorId) {
        super(api2, responseNumber, user, member, reaction, userId);
        this.messageAuthorId = messageAuthorId;
    }

    @Nonnull
    public String getMessageAuthorId() {
        return Long.toUnsignedString(this.messageAuthorId);
    }

    public long getMessageAuthorIdLong() {
        return this.messageAuthorId;
    }
}

