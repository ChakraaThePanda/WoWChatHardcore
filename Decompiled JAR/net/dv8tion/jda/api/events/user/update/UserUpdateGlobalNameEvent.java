/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.user.update;

import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.user.update.GenericUserUpdateEvent;

public class UserUpdateGlobalNameEvent
extends GenericUserUpdateEvent<String> {
    public static final String IDENTIFIER = "global_name";

    public UserUpdateGlobalNameEvent(JDA api2, long responseNumber, User user, String oldName) {
        super(api2, responseNumber, user, oldName, user.getGlobalName(), IDENTIFIER);
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
        return "UserUpdateGlobalName(" + (String)this.getOldValue() + "->" + (String)this.getNewValue() + ')';
    }
}

