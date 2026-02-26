/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.requests.restaction.pagination;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.requests.restaction.pagination.PaginationAction;

public interface ScheduledEventMembersPaginationAction
extends PaginationAction<Member, ScheduledEventMembersPaginationAction> {
    @Nonnull
    public Guild getGuild();
}

