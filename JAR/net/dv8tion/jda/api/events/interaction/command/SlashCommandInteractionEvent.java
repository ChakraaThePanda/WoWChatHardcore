/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.interaction.command;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.interaction.command.GenericCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;

public class SlashCommandInteractionEvent
extends GenericCommandInteractionEvent
implements SlashCommandInteraction {
    private final SlashCommandInteraction interaction;

    public SlashCommandInteractionEvent(@Nonnull JDA api2, long responseNumber, @Nonnull SlashCommandInteraction interaction) {
        super(api2, responseNumber, interaction);
        this.interaction = interaction;
    }

    @Override
    @Nonnull
    public SlashCommandInteraction getInteraction() {
        return this.interaction;
    }

    @Override
    @Nonnull
    public MessageChannelUnion getChannel() {
        return this.interaction.getChannel();
    }
}

