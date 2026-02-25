/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.requests.restaction.pagination;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.requests.restaction.pagination.PaginationAction;

public interface BanPaginationAction
extends PaginationAction<Guild.Ban, BanPaginationAction> {
    @Nonnull
    public Guild getGuild();
}

