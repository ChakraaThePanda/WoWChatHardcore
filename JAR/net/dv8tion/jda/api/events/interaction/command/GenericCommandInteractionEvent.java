/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.interaction.command;

import java.util.List;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.GenericInteractionCreateEvent;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.CommandInteraction;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.modals.Modal;
import net.dv8tion.jda.api.requests.restaction.interactions.ModalCallbackAction;
import net.dv8tion.jda.api.requests.restaction.interactions.PremiumRequiredCallbackAction;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;

public class GenericCommandInteractionEvent
extends GenericInteractionCreateEvent
implements CommandInteraction {
    public GenericCommandInteractionEvent(@Nonnull JDA api2, long responseNumber, @Nonnull CommandInteraction interaction) {
        super(api2, responseNumber, interaction);
    }

    @Override
    @Nonnull
    public CommandInteraction getInteraction() {
        return (CommandInteraction)super.getInteraction();
    }

    @Override
    @Nonnull
    public Command.Type getCommandType() {
        return this.getInteraction().getCommandType();
    }

    @Override
    @Nonnull
    public String getName() {
        return this.getInteraction().getName();
    }

    @Override
    @Nullable
    public String getSubcommandName() {
        return this.getInteraction().getSubcommandName();
    }

    @Override
    @Nullable
    public String getSubcommandGroup() {
        return this.getInteraction().getSubcommandGroup();
    }

    @Override
    public long getCommandIdLong() {
        return this.getInteraction().getCommandIdLong();
    }

    @Override
    public boolean isGuildCommand() {
        return this.getInteraction().isGuildCommand();
    }

    @Override
    @Nonnull
    public List<OptionMapping> getOptions() {
        return this.getInteraction().getOptions();
    }

    @Override
    @Nonnull
    public InteractionHook getHook() {
        return this.getInteraction().getHook();
    }

    @Override
    @Nonnull
    @CheckReturnValue
    public ReplyCallbackAction deferReply() {
        return this.getInteraction().deferReply();
    }

    @Override
    @Nonnull
    @CheckReturnValue
    public ModalCallbackAction replyModal(@Nonnull Modal modal) {
        return this.getInteraction().replyModal(modal);
    }

    @Override
    @Nonnull
    @Deprecated
    @CheckReturnValue
    public PremiumRequiredCallbackAction replyWithPremiumRequired() {
        return this.getInteraction().replyWithPremiumRequired();
    }
}

