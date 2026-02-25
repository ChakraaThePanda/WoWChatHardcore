/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.requests.restaction;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Entitlement;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.utils.MiscUtil;

public interface TestEntitlementCreateAction
extends RestAction<Entitlement> {
    @CheckReturnValue
    @Nonnull
    default public TestEntitlementCreateAction setSkuId(@Nonnull String skuId) {
        return this.setSkuId(MiscUtil.parseSnowflake(skuId));
    }

    @CheckReturnValue
    @Nonnull
    public TestEntitlementCreateAction setSkuId(long var1);

    @CheckReturnValue
    @Nonnull
    default public TestEntitlementCreateAction setOwnerId(@Nonnull String ownerId) {
        return this.setOwnerId(MiscUtil.parseSnowflake(ownerId));
    }

    @CheckReturnValue
    @Nonnull
    public TestEntitlementCreateAction setOwnerId(long var1);

    @CheckReturnValue
    @Nonnull
    public TestEntitlementCreateAction setOwnerType(@Nonnull OwnerType var1);

    public static enum OwnerType {
        GUILD_SUBSCRIPTION(1),
        USER_SUBSCRIPTION(2);

        private final int key;

        private OwnerType(int key) {
            this.key = key;
        }

        public int getKey() {
            return this.key;
        }
    }
}

