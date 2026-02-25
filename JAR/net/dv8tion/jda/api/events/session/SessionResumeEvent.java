/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.session;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.session.GenericSessionEvent;
import net.dv8tion.jda.api.events.session.SessionState;

public class SessionResumeEvent
extends GenericSessionEvent {
    public SessionResumeEvent(@Nonnull JDA api2) {
        super(api2, SessionState.RESUMED);
    }
}

