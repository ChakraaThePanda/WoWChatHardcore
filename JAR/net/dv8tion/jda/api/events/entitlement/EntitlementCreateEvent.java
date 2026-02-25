/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.entitlement;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Entitlement;
import net.dv8tion.jda.api.events.entitlement.GenericEntitlementEvent;

public class EntitlementCreateEvent
extends GenericEntitlementEvent {
    public EntitlementCreateEvent(@Nonnull JDA api2, long responseNumber, @Nonnull Entitlement entitlement) {
        super(api2, responseNumber, entitlement);
    }
}

