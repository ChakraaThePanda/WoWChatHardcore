/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities;

import java.time.OffsetDateTime;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.IMentionable;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.ThreadChannel;

public interface ThreadMember
extends IMentionable {
    @Nonnull
    public JDA getJDA();

    @Nonnull
    public Guild getGuild();

    @Nonnull
    public ThreadChannel getThread();

    @Nonnull
    public User getUser();

    @Nonnull
    public Member getMember();

    @Nonnull
    public OffsetDateTime getTimeJoined();

    default public boolean isThreadOwner() {
        return this.getThread().getOwnerIdLong() == this.getIdLong();
    }
}

