/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.interaction.command;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.interaction.command.GenericContextInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.context.MessageContextInteraction;

public class MessageContextInteractionEvent
extends GenericContextInteractionEvent<Message>
implements MessageContextInteraction {
    public MessageContextInteractionEvent(@Nonnull JDA api2, long responseNumber, @Nonnull MessageContextInteraction interaction) {
        super(api2, responseNumber, interaction);
    }

    @Override
    @Nonnull
    public MessageContextInteraction getInteraction() {
        return (MessageContextInteraction)super.getInteraction();
    }

    @Override
    @Nullable
    public MessageChannelUnion getChannel() {
        return this.getInteraction().getChannel();
    }
}

