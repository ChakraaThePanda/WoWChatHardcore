/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.thread.member;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.ThreadMember;
import net.dv8tion.jda.api.entities.channel.concrete.ThreadChannel;
import net.dv8tion.jda.api.events.thread.member.GenericThreadMemberEvent;

public class ThreadMemberLeaveEvent
extends GenericThreadMemberEvent {
    public ThreadMemberLeaveEvent(@Nonnull JDA api2, long responseNumber, ThreadChannel thread2, long threadMemberId, ThreadMember threadMember) {
        super(api2, responseNumber, thread2, threadMemberId, threadMember);
    }

    @Override
    @Nonnull
    public ThreadMember getThreadMember() {
        return super.getThreadMember();
    }

    @Override
    @Nonnull
    public Member getMember() {
        return this.getThreadMember().getMember();
    }
}

