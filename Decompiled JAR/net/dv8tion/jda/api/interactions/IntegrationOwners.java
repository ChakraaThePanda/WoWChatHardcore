/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.interactions;

import javax.annotation.Nullable;

public interface IntegrationOwners {
    default public boolean isUserIntegration() {
        return this.getAuthorizingUserIdLong() != 0L;
    }

    public long getAuthorizingUserIdLong();

    @Nullable
    default public String getAuthorizingUserId() {
        if (this.getAuthorizingUserIdLong() == 0L) {
            return null;
        }
        return Long.toUnsignedString(this.getAuthorizingUserIdLong());
    }

    default public boolean isGuildIntegration() {
        return this.getAuthorizingGuildIdLong() != null;
    }

    @Nullable
    public Long getAuthorizingGuildIdLong();

    @Nullable
    default public String getAuthorizingGuildId() {
        if (this.getAuthorizingGuildIdLong() == null) {
            return null;
        }
        return Long.toUnsignedString(this.getAuthorizingGuildIdLong());
    }
}

