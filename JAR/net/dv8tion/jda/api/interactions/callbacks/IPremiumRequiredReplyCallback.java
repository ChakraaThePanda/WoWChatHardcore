/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.interactions.callbacks;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.interactions.callbacks.IDeferrableCallback;
import net.dv8tion.jda.api.requests.restaction.interactions.PremiumRequiredCallbackAction;

@Deprecated
public interface IPremiumRequiredReplyCallback
extends IDeferrableCallback {
    @Nonnull
    @Deprecated
    @CheckReturnValue
    public PremiumRequiredCallbackAction replyWithPremiumRequired();
}

