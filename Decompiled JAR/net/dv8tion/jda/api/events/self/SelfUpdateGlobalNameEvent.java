/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.self;

import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.self.GenericSelfUpdateEvent;

public class SelfUpdateGlobalNameEvent
extends GenericSelfUpdateEvent<String> {
    public static final String IDENTIFIER = "global_name";

    public SelfUpdateGlobalNameEvent(JDA api2, long responseNumber, String oldName) {
        super(api2, responseNumber, oldName, api2.getSelfUser().getGlobalName(), IDENTIFIER);
    }

    @Nullable
    public String getOldGlobalName() {
        return (String)this.getOldValue();
    }

    @Nullable
    public String getNewGlobalName() {
        return (String)this.getNewValue();
    }

    @Override
    public String toString() {
        return "SelfUpdateGlobalName(" + (String)this.getOldValue() + "->" + (String)this.getNewValue() + ')';
    }
}

