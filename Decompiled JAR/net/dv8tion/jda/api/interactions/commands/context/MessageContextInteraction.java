/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.interactions.commands.context;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.unions.GuildMessageChannelUnion;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.interactions.commands.context.ContextInteraction;

public interface MessageContextInteraction
extends ContextInteraction<Message> {
    @Override
    @Nonnull
    default public ContextInteraction.ContextTarget getTargetType() {
        return ContextInteraction.ContextTarget.MESSAGE;
    }

    @Override
    @Nullable
    public MessageChannelUnion getChannel();

    @Override
    @Nonnull
    default public GuildMessageChannelUnion getGuildChannel() {
        return (GuildMessageChannelUnion)ContextInteraction.super.getGuildChannel();
    }
}

