/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.entities.channel.mixin.middleman;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.channel.unions.AudioChannelUnion;
import net.dv8tion.jda.api.exceptions.MissingAccessException;
import net.dv8tion.jda.internal.entities.channel.mixin.middleman.StandardGuildChannelMixin;

public interface AudioChannelMixin<T extends AudioChannelMixin<T>>
extends AudioChannelUnion,
StandardGuildChannelMixin<T> {
    public T setBitrate(int var1);

    public T setUserLimit(int var1);

    public T setRegion(String var1);

    @Override
    default public void checkCanAccess() {
        this.checkAttached();
        if (!this.hasPermission(Permission.VIEW_CHANNEL)) {
            throw new MissingAccessException(this, Permission.VIEW_CHANNEL);
        }
        if (!this.hasPermission(Permission.VOICE_CONNECT)) {
            throw new MissingAccessException(this, Permission.VOICE_CONNECT);
        }
    }
}

