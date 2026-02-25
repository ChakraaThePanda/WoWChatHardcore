/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.interaction;

import java.util.List;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.interaction.GenericInteractionCreateEvent;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.modals.ModalInteraction;
import net.dv8tion.jda.api.interactions.modals.ModalMapping;
import net.dv8tion.jda.api.requests.restaction.interactions.MessageEditCallbackAction;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;

public class ModalInteractionEvent
extends GenericInteractionCreateEvent
implements ModalInteraction {
    private final ModalInteraction interaction;

    public ModalInteractionEvent(@Nonnull JDA api2, long responseNumber, @Nonnull ModalInteraction interaction) {
        super(api2, responseNumber, interaction);
        this.interaction = interaction;
    }

    @Override
    @Nonnull
    public ModalInteraction getInteraction() {
        return this.interaction;
    }

    @Override
    @Nonnull
    public String getModalId() {
        return this.interaction.getModalId();
    }

    @Override
    @Nonnull
    public List<ModalMapping> getValues() {
        return this.interaction.getValues();
    }

    @Override
    @Nullable
    public Message getMessage() {
        return this.interaction.getMessage();
    }

    @Override
    @Nonnull
    @CheckReturnValue
    public ReplyCallbackAction deferReply() {
        return this.interaction.deferReply();
    }

    @Override
    @Nonnull
    public InteractionHook getHook() {
        return this.interaction.getHook();
    }

    @Override
    @Nonnull
    @CheckReturnValue
    public MessageEditCallbackAction deferEdit() {
        return this.interaction.deferEdit();
    }

    @Override
    @Nonnull
    public MessageChannelUnion getChannel() {
        return this.interaction.getChannel();
    }
}

