/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.requests.restaction.pagination;

import java.util.Collection;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.Entitlement;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.UserSnowflake;
import net.dv8tion.jda.api.requests.restaction.pagination.PaginationAction;
import net.dv8tion.jda.internal.utils.Checks;

public interface EntitlementPaginationAction
extends PaginationAction<Entitlement, EntitlementPaginationAction> {
    @Nonnull
    @CheckReturnValue
    public EntitlementPaginationAction user(@Nullable UserSnowflake var1);

    @Nonnull
    @CheckReturnValue
    public EntitlementPaginationAction skuIds(long ... var1);

    @Nonnull
    @CheckReturnValue
    public EntitlementPaginationAction skuIds(String ... var1);

    @Nonnull
    @CheckReturnValue
    public EntitlementPaginationAction skuIds(@Nonnull Collection<String> var1);

    @Nonnull
    @CheckReturnValue
    public EntitlementPaginationAction guild(long var1);

    @Nonnull
    @CheckReturnValue
    default public EntitlementPaginationAction guild(@Nonnull String guildId) {
        Checks.notNull(guildId, "guildId");
        Checks.isSnowflake(guildId, "guildId");
        return this.guild(Long.parseUnsignedLong(guildId));
    }

    @Nonnull
    @CheckReturnValue
    default public EntitlementPaginationAction guild(@Nonnull Guild guild) {
        Checks.notNull(guild, "guild");
        return this.guild(guild.getIdLong());
    }

    @Nonnull
    @CheckReturnValue
    public EntitlementPaginationAction excludeEnded(boolean var1);
}

