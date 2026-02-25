/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.entities.channel.middleman;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.internal.entities.GuildImpl;
import net.dv8tion.jda.internal.entities.channel.AbstractChannelImpl;
import net.dv8tion.jda.internal.entities.channel.mixin.middleman.GuildChannelMixin;
import net.dv8tion.jda.internal.utils.ChannelUtil;

public abstract class AbstractGuildChannelImpl<T extends AbstractGuildChannelImpl<T>>
extends AbstractChannelImpl<T>
implements GuildChannelMixin<T> {
    private Guild guild;

    public AbstractGuildChannelImpl(long id, Guild guild) {
        super(id, guild.getJDA());
        this.guild = guild;
    }

    @Override
    @Nonnull
    public Guild getGuild() {
        Guild cachedGuild = this.getJDA().getGuildById(this.id);
        if (cachedGuild instanceof GuildImpl) {
            this.guild = cachedGuild;
            return this.guild;
        }
        return this.guild;
    }

    @Override
    public int compareTo(@Nonnull GuildChannel o) {
        return ChannelUtil.compare(this, o);
    }
}

