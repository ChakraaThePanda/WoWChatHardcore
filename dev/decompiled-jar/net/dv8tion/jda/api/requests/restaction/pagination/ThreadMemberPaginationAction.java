/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.requests.restaction.pagination;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.ThreadMember;
import net.dv8tion.jda.api.entities.channel.concrete.ThreadChannel;
import net.dv8tion.jda.api.requests.restaction.pagination.PaginationAction;

public interface ThreadMemberPaginationAction
extends PaginationAction<ThreadMember, ThreadMemberPaginationAction> {
    @Nonnull
    public ThreadChannel getThreadChannel();
}

