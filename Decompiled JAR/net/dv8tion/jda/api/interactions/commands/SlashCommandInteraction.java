/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.interactions.commands;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.channel.unions.GuildMessageChannelUnion;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.interactions.commands.CommandInteraction;

public interface SlashCommandInteraction
extends CommandInteraction {
    @Override
    @Nonnull
    public MessageChannelUnion getChannel();

    @Override
    @Nonnull
    default public GuildMessageChannelUnion getGuildChannel() {
        return (GuildMessageChannelUnion)CommandInteraction.super.getGuildChannel();
    }
}

