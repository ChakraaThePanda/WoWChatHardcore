/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.UpdateEvent;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.JDAImpl;
import net.dv8tion.jda.internal.handle.SocketHandler;
import net.dv8tion.jda.internal.utils.EntityString;

public abstract class Event
implements GenericEvent {
    protected final JDA api;
    protected final long responseNumber;
    protected final DataObject rawData;

    public Event(@Nonnull JDA api2, long responseNumber) {
        this.api = api2;
        this.responseNumber = responseNumber;
        this.rawData = api2 instanceof JDAImpl && ((JDAImpl)api2).isEventPassthrough() ? SocketHandler.CURRENT_EVENT.get() : null;
    }

    public Event(@Nonnull JDA api2) {
        this(api2, api2.getResponseTotal());
    }

    @Override
    @Nonnull
    public JDA getJDA() {
        return this.api;
    }

    @Override
    public long getResponseNumber() {
        return this.responseNumber;
    }

    @Override
    @Nullable
    public DataObject getRawData() {
        if (this.api instanceof JDAImpl && !((JDAImpl)this.api).isEventPassthrough()) {
            throw new IllegalStateException("Event passthrough is not enabled, see JDABuilder#setEventPassthrough(boolean)");
        }
        return this.rawData;
    }

    public String toString() {
        if (this instanceof UpdateEvent) {
            UpdateEvent event = (UpdateEvent)((Object)this);
            return new EntityString(this).setType(event.getPropertyIdentifier()).addMetadata(null, event.getOldValue() + " -> " + event.getNewValue()).toString();
        }
        return new EntityString(this).toString();
    }
}

