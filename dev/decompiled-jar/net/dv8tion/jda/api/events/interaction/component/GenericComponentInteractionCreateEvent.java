/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.interaction.component;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.interaction.GenericInteractionCreateEvent;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.components.ActionComponent;
import net.dv8tion.jda.api.interactions.components.Component;
import net.dv8tion.jda.api.interactions.components.ComponentInteraction;
import net.dv8tion.jda.api.interactions.modals.Modal;
import net.dv8tion.jda.api.requests.restaction.interactions.MessageEditCallbackAction;
import net.dv8tion.jda.api.requests.restaction.interactions.ModalCallbackAction;
import net.dv8tion.jda.api.requests.restaction.interactions.PremiumRequiredCallbackAction;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;

public class GenericComponentInteractionCreateEvent
extends GenericInteractionCreateEvent
implements ComponentInteraction {
    private final ComponentInteraction interaction;

    public GenericComponentInteractionCreateEvent(@Nonnull JDA api2, long responseNumber, @Nonnull ComponentInteraction interaction) {
        super(api2, responseNumber, interaction);
        this.interaction = interaction;
    }

    @Override
    @Nonnull
    public ComponentInteraction getInteraction() {
        return this.interaction;
    }

    @Override
    @Nonnull
    public MessageChannelUnion getChannel() {
        return this.interaction.getChannel();
    }

    @Override
    @Nonnull
    public String getComponentId() {
        return this.interaction.getComponentId();
    }

    @Override
    @Nonnull
    public ActionComponent getComponent() {
        return this.interaction.getComponent();
    }

    @Override
    @Nonnull
    public Message getMessage() {
        return this.interaction.getMessage();
    }

    @Override
    public long getMessageIdLong() {
        return this.interaction.getMessageIdLong();
    }

    @Override
    @Nonnull
    public Component.Type getComponentType() {
        return this.interaction.getComponentType();
    }

    @Override
    @Nonnull
    @CheckReturnValue
    public MessageEditCallbackAction deferEdit() {
        return this.interaction.deferEdit();
    }

    @Override
    @Nonnull
    public InteractionHook getHook() {
        return this.interaction.getHook();
    }

    @Override
    @Nonnull
    @CheckReturnValue
    public ReplyCallbackAction deferReply() {
        return this.interaction.deferReply();
    }

    @Override
    @Nonnull
    @CheckReturnValue
    public ModalCallbackAction replyModal(@Nonnull Modal modal) {
        return this.interaction.replyModal(modal);
    }

    @Override
    @Nonnull
    @Deprecated
    @CheckReturnValue
    public PremiumRequiredCallbackAction replyWithPremiumRequired() {
        return this.interaction.replyWithPremiumRequired();
    }
}

