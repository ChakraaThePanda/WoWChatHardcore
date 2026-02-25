/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.requests.restaction.pagination;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.audit.ActionType;
import net.dv8tion.jda.api.audit.AuditLogEntry;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.UserSnowflake;
import net.dv8tion.jda.api.requests.restaction.pagination.PaginationAction;

public interface AuditLogPaginationAction
extends PaginationAction<AuditLogEntry, AuditLogPaginationAction> {
    @Nonnull
    public Guild getGuild();

    @Nonnull
    @CheckReturnValue
    public AuditLogPaginationAction type(@Nullable ActionType var1);

    @Nonnull
    @CheckReturnValue
    public AuditLogPaginationAction user(@Nullable UserSnowflake var1);
}

