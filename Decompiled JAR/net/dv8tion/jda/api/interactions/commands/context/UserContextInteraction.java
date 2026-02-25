/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.interactions.commands.context;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.interactions.commands.context.ContextInteraction;

public interface UserContextInteraction
extends ContextInteraction<User> {
    @Override
    @Nonnull
    default public ContextInteraction.ContextTarget getTargetType() {
        return ContextInteraction.ContextTarget.USER;
    }

    @Nullable
    public Member getTargetMember();
}

