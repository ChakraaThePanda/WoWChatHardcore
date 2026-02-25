/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.entities;

import java.time.OffsetDateTime;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Entitlement;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.requests.Route;
import net.dv8tion.jda.internal.requests.CompletedRestAction;
import net.dv8tion.jda.internal.requests.RestActionImpl;

public class EntitlementImpl
implements Entitlement {
    private final JDA api;
    private long id;
    private long skuId;
    private long applicationId;
    private long userId;
    private long guildId;
    private Entitlement.EntitlementType type;
    private boolean deleted;
    private OffsetDateTime startsAt;
    private OffsetDateTime endsAt;
    private boolean consumed;

    public EntitlementImpl(JDA api2, long id, long skuId, long applicationId, long userId, long guildId, Entitlement.EntitlementType type, boolean deleted, @Nullable OffsetDateTime startsAt, @Nullable OffsetDateTime endsAt, boolean consumed) {
        this.api = api2;
        this.id = id;
        this.skuId = skuId;
        this.applicationId = applicationId;
        this.userId = userId;
        this.guildId = guildId;
        this.type = type;
        this.deleted = deleted;
        this.startsAt = startsAt;
        this.endsAt = endsAt;
        this.consumed = consumed;
    }

    @Override
    public long getIdLong() {
        return this.id;
    }

    @Override
    public long getSkuIdLong() {
        return this.skuId;
    }

    @Override
    public long getApplicationIdLong() {
        return this.applicationId;
    }

    @Override
    public long getUserIdLong() {
        return this.userId;
    }

    @Override
    public long getGuildIdLong() {
        return this.guildId;
    }

    @Override
    @Nonnull
    public Entitlement.EntitlementType getType() {
        return this.type;
    }

    @Override
    public boolean isDeleted() {
        return this.deleted;
    }

    @Override
    @Nullable
    public OffsetDateTime getTimeStarting() {
        return this.startsAt;
    }

    @Override
    @Nullable
    public OffsetDateTime getTimeEnding() {
        return this.endsAt;
    }

    @Override
    public boolean isConsumed() {
        return this.consumed;
    }

    @Override
    @Nonnull
    public RestAction<Void> consume() {
        if (this.consumed) {
            return new CompletedRestAction<Void>(this.api, null);
        }
        Route.CompiledRoute route = Route.Applications.CONSUME_ENTITLEMENT.compile(this.getApplicationId(), this.getId());
        return new RestActionImpl<Void>(this.api, route);
    }
}

