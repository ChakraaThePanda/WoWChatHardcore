/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.session;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.session.SessionState;

public abstract class GenericSessionEvent
extends Event {
    protected final SessionState state;

    public GenericSessionEvent(@Nonnull JDA api2, @Nonnull SessionState state) {
        super(api2);
        this.state = state;
    }

    @Nonnull
    public SessionState getState() {
        return this.state;
    }
}

