/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.thread;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.concrete.ThreadChannel;
import net.dv8tion.jda.api.events.thread.GenericThreadEvent;

public class ThreadRevealedEvent
extends GenericThreadEvent {
    public ThreadRevealedEvent(@Nonnull JDA api2, long responseNumber, ThreadChannel thread2) {
        super(api2, responseNumber, thread2);
    }
}

