/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.interaction.command;

import java.util.Collection;
import java.util.List;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.interaction.GenericAutoCompleteInteractionEvent;
import net.dv8tion.jda.api.interactions.AutoCompleteQuery;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.CommandAutoCompleteInteraction;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.requests.restaction.interactions.AutoCompleteCallbackAction;

public class CommandAutoCompleteInteractionEvent
extends GenericAutoCompleteInteractionEvent
implements CommandAutoCompleteInteraction {
    private final CommandAutoCompleteInteraction interaction;

    public CommandAutoCompleteInteractionEvent(@Nonnull JDA api2, long responseNumber, @Nonnull CommandAutoCompleteInteraction interaction) {
        super(api2, responseNumber, interaction);
        this.interaction = interaction;
    }

    @Override
    @Nonnull
    public CommandAutoCompleteInteraction getInteraction() {
        return this.interaction;
    }

    @Override
    @Nonnull
    public AutoCompleteQuery getFocusedOption() {
        return this.interaction.getFocusedOption();
    }

    @Override
    @Nonnull
    public Command.Type getCommandType() {
        return this.interaction.getCommandType();
    }

    @Override
    @Nonnull
    public String getName() {
        return this.interaction.getName();
    }

    @Override
    @Nullable
    public String getSubcommandName() {
        return this.interaction.getSubcommandName();
    }

    @Override
    @Nullable
    public String getSubcommandGroup() {
        return this.interaction.getSubcommandGroup();
    }

    @Override
    public long getCommandIdLong() {
        return this.interaction.getCommandIdLong();
    }

    @Override
    public boolean isGuildCommand() {
        return this.interaction.isGuildCommand();
    }

    @Override
    @Nonnull
    public List<OptionMapping> getOptions() {
        return this.interaction.getOptions();
    }

    @Override
    @Nonnull
    @CheckReturnValue
    public AutoCompleteCallbackAction replyChoices(@Nonnull Collection<Command.Choice> choices) {
        return this.interaction.replyChoices(choices);
    }

    @Override
    @Nonnull
    public MessageChannelUnion getChannel() {
        return this.interaction.getChannel();
    }
}

