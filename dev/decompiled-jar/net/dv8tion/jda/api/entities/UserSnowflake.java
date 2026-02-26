/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.IMentionable;
import net.dv8tion.jda.api.utils.ImageProxy;
import net.dv8tion.jda.api.utils.MiscUtil;
import net.dv8tion.jda.internal.entities.UserSnowflakeImpl;

public interface UserSnowflake
extends IMentionable {
    @Nonnull
    public static UserSnowflake fromId(long id) {
        return new UserSnowflakeImpl(id);
    }

    @Nonnull
    public static UserSnowflake fromId(@Nonnull String id) {
        return UserSnowflake.fromId(MiscUtil.parseSnowflake(id));
    }

    @Nonnull
    public String getDefaultAvatarId();

    @Nonnull
    default public String getDefaultAvatarUrl() {
        return String.format("https://cdn.discordapp.com/embed/avatars/%s.png", this.getDefaultAvatarId());
    }

    @Nonnull
    default public ImageProxy getDefaultAvatar() {
        return new ImageProxy(this.getDefaultAvatarUrl());
    }
}

