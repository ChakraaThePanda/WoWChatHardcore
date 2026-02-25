/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.interaction.command;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.command.GenericCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.context.ContextInteraction;

public class GenericContextInteractionEvent<T>
extends GenericCommandInteractionEvent
implements ContextInteraction<T> {
    public GenericContextInteractionEvent(@Nonnull JDA api2, long responseNumber, @Nonnull ContextInteraction<T> interaction) {
        super(api2, responseNumber, interaction);
    }

    @Override
    @Nonnull
    public ContextInteraction<T> getInteraction() {
        return (ContextInteraction)super.getInteraction();
    }

    @Override
    @Nonnull
    public ContextInteraction.ContextTarget getTargetType() {
        return this.getInteraction().getTargetType();
    }

    @Override
    @Nonnull
    public T getTarget() {
        return this.getInteraction().getTarget();
    }
}

