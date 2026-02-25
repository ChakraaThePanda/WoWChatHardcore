/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.guild.scheduledevent.update;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.ScheduledEvent;
import net.dv8tion.jda.api.events.UpdateEvent;
import net.dv8tion.jda.api.events.guild.scheduledevent.GenericScheduledEventGatewayEvent;

public abstract class GenericScheduledEventUpdateEvent<T>
extends GenericScheduledEventGatewayEvent
implements UpdateEvent<ScheduledEvent, T> {
    protected final T previous;
    protected final T next;
    protected final String identifier;

    public GenericScheduledEventUpdateEvent(@Nonnull JDA api2, long responseNumber, @Nonnull ScheduledEvent scheduledEvent, @Nullable T previous, @Nullable T next, @Nonnull String identifier) {
        super(api2, responseNumber, scheduledEvent);
        this.previous = previous;
        this.next = next;
        this.identifier = identifier;
    }

    @Override
    @Nonnull
    public ScheduledEvent getEntity() {
        return this.getScheduledEvent();
    }

    @Override
    @Nonnull
    public String getPropertyIdentifier() {
        return this.identifier;
    }

    @Override
    @Nullable
    public T getOldValue() {
        return this.previous;
    }

    @Override
    @Nullable
    public T getNewValue() {
        return this.next;
    }

    @Override
    public String toString() {
        return "ScheduledEventUpdate[" + this.getPropertyIdentifier() + "](" + this.getOldValue() + "->" + this.getNewValue() + ')';
    }
}

