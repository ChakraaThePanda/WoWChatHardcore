/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities.channel.attribute;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.requests.restaction.AuditableRestAction;

public interface IVoiceStatusChannel
extends Channel {
    public static final int MAX_STATUS_LENGTH = 500;

    @Nonnull
    public String getStatus();

    @Nonnull
    @CheckReturnValue
    public AuditableRestAction<Void> modifyStatus(@Nonnull String var1);
}

