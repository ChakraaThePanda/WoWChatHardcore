/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.Unmodifiable
 */
package net.dv8tion.jda.api.entities.emoji;

import java.util.List;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.entities.emoji.CustomEmoji;
import net.dv8tion.jda.api.managers.CustomEmojiManager;
import net.dv8tion.jda.api.requests.restaction.AuditableRestAction;
import net.dv8tion.jda.api.requests.restaction.CacheRestAction;
import net.dv8tion.jda.internal.utils.PermissionUtil;
import org.jetbrains.annotations.Unmodifiable;

public interface RichCustomEmoji
extends CustomEmoji {
    @Nonnull
    public Guild getGuild();

    @Nonnull
    public @Unmodifiable List<Role> getRoles();

    public boolean isManaged();

    public boolean isAvailable();

    @Nonnull
    public JDA getJDA();

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
    public CustomEmojiManager getManager();

    default public boolean canInteract(@Nonnull Member issuer) {
        return PermissionUtil.canInteract(issuer, this);
    }

    default public boolean canInteract(@Nonnull User issuer, @Nonnull MessageChannel channel) {
        return PermissionUtil.canInteract(issuer, this, channel);
    }

    default public boolean canInteract(@Nonnull User issuer, @Nonnull MessageChannel channel, boolean botOverride) {
        return PermissionUtil.canInteract(issuer, this, channel, botOverride);
    }
}

