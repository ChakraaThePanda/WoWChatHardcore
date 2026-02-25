/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities.channel.forums;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.concrete.ThreadChannel;

public class ForumPost {
    private final Message message;
    private final ThreadChannel thread;

    public ForumPost(@Nonnull Message message, @Nonnull ThreadChannel thread2) {
        this.message = message;
        this.thread = thread2;
    }

    @Nonnull
    public Message getMessage() {
        return this.message;
    }

    @Nonnull
    public ThreadChannel getThreadChannel() {
        return this.thread;
    }
}

