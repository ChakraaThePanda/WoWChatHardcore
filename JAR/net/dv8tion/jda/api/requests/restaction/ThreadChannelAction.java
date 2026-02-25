/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.requests.restaction;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.channel.concrete.ThreadChannel;
import net.dv8tion.jda.api.requests.restaction.AbstractThreadCreateAction;
import net.dv8tion.jda.api.requests.restaction.FluentAuditableRestAction;

public interface ThreadChannelAction
extends AbstractThreadCreateAction<ThreadChannel, ThreadChannelAction>,
FluentAuditableRestAction<ThreadChannel, ThreadChannelAction> {
    @Nonnull
    @CheckReturnValue
    public ThreadChannelAction setInvitable(boolean var1);
}

