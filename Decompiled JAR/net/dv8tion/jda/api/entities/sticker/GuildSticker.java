/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities.sticker;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.sticker.RichSticker;
import net.dv8tion.jda.api.entities.sticker.Sticker;
import net.dv8tion.jda.api.managers.GuildStickerManager;
import net.dv8tion.jda.api.requests.restaction.AuditableRestAction;
import net.dv8tion.jda.api.requests.restaction.CacheRestAction;
import org.jetbrains.annotations.Contract;

public interface GuildSticker
extends RichSticker {
    @Override
    @Nonnull
    default public Sticker.Type getType() {
        return Sticker.Type.GUILD;
    }

    public boolean isAvailable();

    public long getGuildIdLong();

    @Nonnull
    default public String getGuildId() {
        return Long.toUnsignedString(this.getGuildIdLong());
    }

    @Nullable
    public Guild getGuild();

    @Nullable
    public User getOwner();

    @Nonnull
    @CheckReturnValue
    public CacheRestAction<User> retrieveOwner();

    @Nonnull
    @CheckReturnValue
    public AuditableRestAction<Void> delete();

    @Nonnull
    @CheckReturnValue
    @Contract(value="->new")
    public GuildStickerManager getManager();
}

