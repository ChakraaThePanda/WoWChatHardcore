/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.interactions.component;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.interactions.components.ComponentInteraction;
import net.dv8tion.jda.api.interactions.modals.Modal;
import net.dv8tion.jda.api.requests.restaction.interactions.ModalCallbackAction;
import net.dv8tion.jda.api.requests.restaction.interactions.PremiumRequiredCallbackAction;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.JDAImpl;
import net.dv8tion.jda.internal.entities.ReceivedMessage;
import net.dv8tion.jda.internal.interactions.DeferrableInteractionImpl;
import net.dv8tion.jda.internal.requests.restaction.interactions.MessageEditCallbackActionImpl;
import net.dv8tion.jda.internal.requests.restaction.interactions.ModalCallbackActionImpl;
import net.dv8tion.jda.internal.requests.restaction.interactions.PremiumRequiredCallbackActionImpl;
import net.dv8tion.jda.internal.requests.restaction.interactions.ReplyCallbackActionImpl;
import net.dv8tion.jda.internal.utils.Checks;

public abstract class ComponentInteractionImpl
extends DeferrableInteractionImpl
implements ComponentInteraction {
    protected final String customId;
    protected final Message message;
    protected final long messageId;

    public ComponentInteractionImpl(JDAImpl jda, DataObject data) {
        super(jda, data);
        this.customId = data.getObject("data").getString("custom_id");
        DataObject messageJson = data.getObject("message");
        this.messageId = messageJson.getUnsignedLong("id");
        if (messageJson.isNull("type")) {
            this.message = null;
        } else {
            Guild guild = this.getGuild();
            MessageChannelUnion channel = this.getChannel();
            this.message = jda.getEntityBuilder().createMessageBestEffort(messageJson, channel, guild);
            ((ReceivedMessage)this.message).withHook(this.getHook());
        }
    }

    @Override
    public MessageChannelUnion getChannel() {
        return (MessageChannelUnion)super.getChannel();
    }

    @Override
    @Nonnull
    public String getComponentId() {
        return this.customId;
    }

    @Override
    @Nonnull
    public Message getMessage() {
        return this.message;
    }

    @Override
    public long getMessageIdLong() {
        return this.messageId;
    }

    @Override
    @Nonnull
    public MessageEditCallbackActionImpl deferEdit() {
        return new MessageEditCallbackActionImpl(this.hook);
    }

    @Override
    @Nonnull
    public ReplyCallbackAction deferReply() {
        return new ReplyCallbackActionImpl(this.hook);
    }

    @Override
    @Nonnull
    public ModalCallbackAction replyModal(@Nonnull Modal modal) {
        Checks.notNull(modal, "Modal");
        return new ModalCallbackActionImpl(this, modal);
    }

    @Override
    @Nonnull
    public PremiumRequiredCallbackAction replyWithPremiumRequired() {
        return new PremiumRequiredCallbackActionImpl(this);
    }
}

