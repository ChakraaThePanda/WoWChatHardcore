/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.handle;

import net.dv8tion.jda.api.events.entitlement.EntitlementDeleteEvent;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.JDAImpl;
import net.dv8tion.jda.internal.handle.SocketHandler;

public class EntitlementDeleteHandler
extends SocketHandler {
    public EntitlementDeleteHandler(JDAImpl api2) {
        super(api2);
    }

    @Override
    protected Long handleInternally(DataObject content) {
        this.getJDA().handleEvent(new EntitlementDeleteEvent(this.getJDA(), this.responseNumber, this.getJDA().getEntityBuilder().createEntitlement(content)));
        return null;
    }
}

