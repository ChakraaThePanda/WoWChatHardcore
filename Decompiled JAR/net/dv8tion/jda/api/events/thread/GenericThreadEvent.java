/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.thread;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.ThreadChannel;
import net.dv8tion.jda.api.events.Event;

public class GenericThreadEvent
extends Event {
    protected final ThreadChannel thread;

    public GenericThreadEvent(@Nonnull JDA api2, long responseNumber, ThreadChannel thread2) {
        super(api2, responseNumber);
        this.thread = thread2;
    }

    @Nonnull
    public ThreadChannel getThread() {
        return this.thread;
    }

    @Nonnull
    public Guild getGuild() {
        return this.thread.getGuild();
    }
}

