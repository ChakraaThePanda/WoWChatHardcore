/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.interactions.components;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.unions.GuildMessageChannelUnion;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.interactions.callbacks.IMessageEditCallback;
import net.dv8tion.jda.api.interactions.callbacks.IModalCallback;
import net.dv8tion.jda.api.interactions.callbacks.IPremiumRequiredReplyCallback;
import net.dv8tion.jda.api.interactions.callbacks.IReplyCallback;
import net.dv8tion.jda.api.interactions.components.ActionComponent;
import net.dv8tion.jda.api.interactions.components.Component;

public interface ComponentInteraction
extends IReplyCallback,
IMessageEditCallback,
IModalCallback,
IPremiumRequiredReplyCallback {
    @Nonnull
    public String getComponentId();

    @Nonnull
    public ActionComponent getComponent();

    @Nonnull
    public Message getMessage();

    public long getMessageIdLong();

    @Nonnull
    default public String getMessageId() {
        return Long.toUnsignedString(this.getMessageIdLong());
    }

    @Nonnull
    public Component.Type getComponentType();

    @Override
    @Nonnull
    public MessageChannelUnion getChannel();

    @Override
    @Nonnull
    default public GuildMessageChannelUnion getGuildChannel() {
        return (GuildMessageChannelUnion)IReplyCallback.super.getGuildChannel();
    }
}

