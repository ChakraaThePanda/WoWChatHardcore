/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.thread.member;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.ThreadMember;
import net.dv8tion.jda.api.entities.channel.concrete.ThreadChannel;
import net.dv8tion.jda.api.events.thread.GenericThreadEvent;

public class GenericThreadMemberEvent
extends GenericThreadEvent {
    protected final long threadMemberId;
    protected final ThreadMember threadMember;

    public GenericThreadMemberEvent(@Nonnull JDA api2, long responseNumber, ThreadChannel thread2, long threadMemberId, ThreadMember threadMember) {
        super(api2, responseNumber, thread2);
        this.threadMemberId = threadMemberId;
        this.threadMember = threadMember;
    }

    @Nonnull
    public String getThreadMemberId() {
        return Long.toUnsignedString(this.getThreadMemberIdLong());
    }

    public long getThreadMemberIdLong() {
        return this.threadMemberId;
    }

    @Nullable
    public ThreadMember getThreadMember() {
        return this.threadMember;
    }

    @Nullable
    public Member getMember() {
        return this.getGuild().getMemberById(this.threadMemberId);
    }
}

