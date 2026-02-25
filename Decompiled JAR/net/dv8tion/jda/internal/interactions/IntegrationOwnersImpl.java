/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.interactions;

import javax.annotation.Nullable;
import net.dv8tion.jda.api.interactions.IntegrationOwners;
import net.dv8tion.jda.api.interactions.IntegrationType;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.utils.EntityString;

public class IntegrationOwnersImpl
implements IntegrationOwners {
    private final Long guildIntegration;
    private final long userIntegration;

    public IntegrationOwnersImpl(DataObject authorizedIntegrationOwners) {
        this.userIntegration = authorizedIntegrationOwners.getLong(IntegrationType.USER_INSTALL.getType(), 0L);
        this.guildIntegration = authorizedIntegrationOwners.hasKey(IntegrationType.GUILD_INSTALL.getType()) ? Long.valueOf(authorizedIntegrationOwners.getLong(IntegrationType.GUILD_INSTALL.getType())) : null;
    }

    @Override
    public long getAuthorizingUserIdLong() {
        return this.userIntegration;
    }

    @Override
    @Nullable
    public Long getAuthorizingGuildIdLong() {
        return this.guildIntegration;
    }

    public String toString() {
        return new EntityString(this).addMetadata("user", this.getAuthorizingUserId()).addMetadata("guild", this.getAuthorizingGuildId()).toString();
    }
}

