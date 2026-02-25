/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.interactions.callbacks;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.interactions.Interaction;
import net.dv8tion.jda.api.interactions.InteractionHook;

public interface IDeferrableCallback
extends Interaction {
    @Nonnull
    public InteractionHook getHook();
}

