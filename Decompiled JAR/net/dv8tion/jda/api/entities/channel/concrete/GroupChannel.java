/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities.channel.concrete;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.entities.detached.IDetachableEntity;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.utils.ImageProxy;
import net.dv8tion.jda.internal.utils.Helpers;

public interface GroupChannel
extends MessageChannel,
IDetachableEntity {
    public static final String ICON_URL = "https://cdn.discordapp.com/channel-icons/%s/%s.png";

    @Nullable
    public String getIconId();

    @Nullable
    default public String getIconUrl() {
        String iconId = this.getIconId();
        return iconId == null ? null : Helpers.format(ICON_URL, this.getId(), iconId);
    }

    @Nullable
    default public ImageProxy getIcon() {
        String iconUrl = this.getIconUrl();
        return iconUrl == null ? null : new ImageProxy(iconUrl);
    }

    public long getOwnerIdLong();

    @Nonnull
    default public String getOwnerId() {
        return Long.toUnsignedString(this.getOwnerIdLong());
    }

    @Nonnull
    @CheckReturnValue
    default public RestAction<User> retrieveOwner() {
        return this.getJDA().retrieveUserById(this.getOwnerIdLong());
    }
}

