/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities.channel.unions;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.channel.attribute.IThreadContainer;
import net.dv8tion.jda.api.entities.channel.concrete.NewsChannel;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.middleman.StandardGuildChannel;
import net.dv8tion.jda.api.entities.channel.middleman.StandardGuildMessageChannel;

public interface DefaultGuildChannelUnion
extends StandardGuildChannel {
    @Nonnull
    public TextChannel asTextChannel();

    @Nonnull
    public NewsChannel asNewsChannel();

    @Nonnull
    public IThreadContainer asThreadContainer();

    @Nonnull
    public StandardGuildMessageChannel asStandardGuildMessageChannel();
}

