/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.sticker.update;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.sticker.GuildSticker;
import net.dv8tion.jda.api.events.UpdateEvent;
import net.dv8tion.jda.api.events.sticker.GenericGuildStickerEvent;

public abstract class GenericGuildStickerUpdateEvent<T>
extends GenericGuildStickerEvent
implements UpdateEvent<GuildSticker, T> {
    protected final String identifier;
    protected final T previous;
    protected final T next;

    public GenericGuildStickerUpdateEvent(@Nonnull JDA api2, long responseNumber, @Nonnull Guild guild, @Nonnull GuildSticker sticker, @Nonnull String identifier, T oldValue, T newValue) {
        super(api2, responseNumber, guild, sticker);
        this.identifier = identifier;
        this.previous = oldValue;
        this.next = newValue;
    }

    @Override
    @Nonnull
    public String getPropertyIdentifier() {
        return this.identifier;
    }

    @Override
    @Nonnull
    public GuildSticker getEntity() {
        return this.getSticker();
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
}

