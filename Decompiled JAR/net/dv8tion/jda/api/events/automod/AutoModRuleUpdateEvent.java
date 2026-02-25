/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.automod;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.automod.AutoModRule;
import net.dv8tion.jda.api.events.automod.GenericAutoModRuleEvent;

public class AutoModRuleUpdateEvent
extends GenericAutoModRuleEvent {
    public AutoModRuleUpdateEvent(@Nonnull JDA api2, long responseNumber, @Nonnull AutoModRule rule) {
        super(api2, responseNumber, rule);
    }
}

