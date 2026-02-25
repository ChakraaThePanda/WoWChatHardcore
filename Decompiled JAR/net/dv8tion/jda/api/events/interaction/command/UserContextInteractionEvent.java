/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.interaction.command;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.GenericContextInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.context.UserContextInteraction;

public class UserContextInteractionEvent
extends GenericContextInteractionEvent<User>
implements UserContextInteraction {
    public UserContextInteractionEvent(@Nonnull JDA api2, long responseNumber, @Nonnull UserContextInteraction interaction) {
        super(api2, responseNumber, interaction);
    }

    @Override
    @Nonnull
    public UserContextInteraction getInteraction() {
        return (UserContextInteraction)super.getInteraction();
    }

    @Override
    @Nullable
    public Member getTargetMember() {
        return this.getInteraction().getTargetMember();
    }
}

