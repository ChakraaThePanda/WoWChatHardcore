/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.interactions.commands.context;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.interactions.commands.CommandInteraction;

public interface ContextInteraction<T>
extends CommandInteraction {
    @Nonnull
    public ContextTarget getTargetType();

    @Nonnull
    public T getTarget();

    public static enum ContextTarget {
        USER,
        MESSAGE;

    }
}

