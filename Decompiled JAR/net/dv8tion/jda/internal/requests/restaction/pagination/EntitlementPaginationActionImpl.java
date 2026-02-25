/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.requests.restaction.pagination;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Entitlement;
import net.dv8tion.jda.api.entities.UserSnowflake;
import net.dv8tion.jda.api.exceptions.ParsingException;
import net.dv8tion.jda.api.requests.Request;
import net.dv8tion.jda.api.requests.Response;
import net.dv8tion.jda.api.requests.Route;
import net.dv8tion.jda.api.requests.restaction.pagination.EntitlementPaginationAction;
import net.dv8tion.jda.api.requests.restaction.pagination.PaginationAction;
import net.dv8tion.jda.api.utils.data.DataArray;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.entities.EntityBuilder;
import net.dv8tion.jda.internal.requests.restaction.pagination.PaginationActionImpl;
import net.dv8tion.jda.internal.utils.Checks;

public class EntitlementPaginationActionImpl
extends PaginationActionImpl<Entitlement, EntitlementPaginationAction>
implements EntitlementPaginationAction {
    protected List<String> skuIds = new ArrayList<String>();
    protected long guildId = 0L;
    protected long userId = 0L;
    protected boolean excludeEnded;

    public EntitlementPaginationActionImpl(JDA api2) {
        super(api2, Route.Applications.GET_ENTITLEMENTS.compile(api2.getSelfUser().getApplicationId()), 1, 100, 100);
    }

    @Override
    @Nonnull
    public EnumSet<PaginationAction.PaginationOrder> getSupportedOrders() {
        return EnumSet.of(PaginationAction.PaginationOrder.BACKWARD, PaginationAction.PaginationOrder.FORWARD);
    }

    @Override
    @Nonnull
    public EntitlementPaginationAction user(@Nullable UserSnowflake user) {
        this.userId = user == null ? 0L : user.getIdLong();
        return this;
    }

    @Override
    @Nonnull
    public EntitlementPaginationAction skuIds(long ... skuIds) {
        this.skuIds.clear();
        for (long skuId : skuIds) {
            this.skuIds.add(Long.toUnsignedString(skuId));
        }
        return this;
    }

    @Override
    @Nonnull
    public EntitlementPaginationAction skuIds(String ... skuIds) {
        Checks.noneNull(skuIds, "skuIds");
        for (String skuId : skuIds) {
            Checks.isSnowflake(skuId, "skuId");
        }
        this.skuIds.clear();
        Collections.addAll(this.skuIds, skuIds);
        return this;
    }

    @Override
    @Nonnull
    public EntitlementPaginationAction skuIds(@Nonnull Collection<String> skuIds) {
        Checks.noneNull(skuIds, "skuIds");
        this.skuIds.clear();
        for (String skuId : skuIds) {
            Checks.isSnowflake(skuId, "skuId");
            this.skuIds.add(skuId);
        }
        return this;
    }

    @Override
    @Nonnull
    public EntitlementPaginationAction guild(long guildId) {
        this.guildId = guildId;
        return this;
    }

    @Override
    @Nonnull
    public EntitlementPaginationAction excludeEnded(boolean excludeEnded) {
        this.excludeEnded = excludeEnded;
        return this;
    }

    @Override
    protected Route.CompiledRoute finalizeRoute() {
        Route.CompiledRoute route = super.finalizeRoute();
        if (this.userId != 0L) {
            route = route.withQueryParams("user_id", Long.toUnsignedString(this.userId));
        }
        if (!this.skuIds.isEmpty()) {
            route = route.withQueryParams("sku_ids", String.join((CharSequence)",", this.skuIds));
        }
        if (this.guildId != 0L) {
            route = route.withQueryParams("guild_id", Long.toUnsignedString(this.guildId));
        }
        if (this.excludeEnded) {
            route = route.withQueryParams("exclude_ended", String.valueOf(true));
        }
        return route;
    }

    @Override
    protected void handleSuccess(Response response, Request<List<Entitlement>> request) {
        DataArray array = response.getArray();
        ArrayList<Entitlement> entitlements = new ArrayList<Entitlement>(array.length());
        EntityBuilder builder = this.api.getEntityBuilder();
        for (int i = 0; i < array.length(); ++i) {
            try {
                DataObject object = array.getObject(i);
                Entitlement entitlement = builder.createEntitlement(object);
                entitlements.add(entitlement);
                continue;
            }
            catch (NullPointerException | ParsingException e) {
                LOG.warn("Encountered an exception in EntitlementPaginationAction", e);
            }
        }
        if (!entitlements.isEmpty()) {
            if (this.useCache) {
                this.cached.addAll(entitlements);
            }
            this.last = entitlements.get(entitlements.size() - 1);
            this.lastKey = ((Entitlement)this.last).getIdLong();
        }
        request.onSuccess(entitlements);
    }

    @Override
    protected long getKey(Entitlement it) {
        return it.getIdLong();
    }
}

