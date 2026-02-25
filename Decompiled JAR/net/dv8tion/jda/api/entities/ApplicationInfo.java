/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.Unmodifiable
 */
package net.dv8tion.jda.api.entities;

import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.ApplicationTeam;
import net.dv8tion.jda.api.entities.ISnowflake;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.interactions.IntegrationType;
import net.dv8tion.jda.api.utils.ImageProxy;
import net.dv8tion.jda.internal.utils.Checks;
import org.jetbrains.annotations.Unmodifiable;

public interface ApplicationInfo
extends ISnowflake {
    public static final int MAX_DESCRIPTION_LENGTH = 400;
    public static final int MAX_URL_LENGTH = 2048;
    public static final int MAX_TAGS = 5;
    public static final int MAX_TAG_LENGTH = 20;

    public boolean doesBotRequireCodeGrant();

    @Nonnull
    public String getDescription();

    @Nullable
    public String getTermsOfServiceUrl();

    @Nullable
    public String getPrivacyPolicyUrl();

    @Nullable
    public String getIconId();

    @Nullable
    public String getIconUrl();

    @Nullable
    default public ImageProxy getIcon() {
        String iconUrl = this.getIconUrl();
        return iconUrl == null ? null : new ImageProxy(iconUrl);
    }

    @Nullable
    public ApplicationTeam getTeam();

    @Nonnull
    default public ApplicationInfo setRequiredScopes(String ... scopes) {
        Checks.noneNull(scopes, "Scopes");
        return this.setRequiredScopes(Arrays.asList(scopes));
    }

    @Nonnull
    public ApplicationInfo setRequiredScopes(@Nonnull Collection<String> var1);

    @Nonnull
    default public String getInviteUrl(@Nullable Collection<Permission> permissions) {
        return this.getInviteUrl(null, permissions);
    }

    @Nonnull
    default public String getInviteUrl(Permission ... permissions) {
        return this.getInviteUrl((String)null, permissions);
    }

    @Nonnull
    public String getInviteUrl(@Nullable String var1, @Nullable Collection<Permission> var2);

    @Nonnull
    default public String getInviteUrl(long guildId, @Nullable Collection<Permission> permissions) {
        return this.getInviteUrl(Long.toUnsignedString(guildId), permissions);
    }

    @Nonnull
    default public String getInviteUrl(@Nullable String guildId, Permission ... permissions) {
        return this.getInviteUrl(guildId, permissions == null ? null : Arrays.asList(permissions));
    }

    @Nonnull
    default public String getInviteUrl(long guildId, Permission ... permissions) {
        return this.getInviteUrl(Long.toUnsignedString(guildId), permissions);
    }

    @Nonnull
    public JDA getJDA();

    @Nonnull
    public String getName();

    @Nonnull
    public User getOwner();

    public boolean isBotPublic();

    @Nonnull
    public @Unmodifiable List<String> getTags();

    @Nonnull
    public @Unmodifiable List<String> getRedirectUris();

    @Nullable
    public String getInteractionsEndpointUrl();

    @Nullable
    public String getRoleConnectionsVerificationUrl();

    @Nullable
    public String getCustomAuthorizationUrl();

    @Nonnull
    public @Unmodifiable List<String> getScopes();

    @Nonnull
    public EnumSet<Permission> getPermissions();

    public long getPermissionsRaw();

    @Nonnull
    default public EnumSet<Flag> getFlags() {
        return Flag.fromRaw(this.getFlagsRaw());
    }

    public long getFlagsRaw();

    public long getUserInstallCount();

    @Nonnull
    public Map<IntegrationType, IntegrationTypeConfiguration> getIntegrationTypesConfig();

    public static enum Flag {
        GATEWAY_PRESENCE(4096L),
        GATEWAY_PRESENCE_LIMITED(8192L),
        GATEWAY_GUILD_MEMBERS(16384L),
        GATEWAY_GUILD_MEMBERS_LIMITED(32768L),
        VERIFICATION_PENDING_GUILD_LIMIT(65536L),
        EMBEDDED(131072L),
        GATEWAY_MESSAGE_CONTENT(262144L),
        GATEWAY_MESSAGE_CONTENT_LIMITED(524288L);

        private final long value;

        private Flag(long value) {
            this.value = value;
        }

        @Nonnull
        public static EnumSet<Flag> fromRaw(long raw) {
            EnumSet<Flag> set = EnumSet.noneOf(Flag.class);
            for (Flag flag : Flag.values()) {
                if ((raw & flag.value) == 0L) continue;
                set.add(flag);
            }
            return set;
        }
    }

    public static interface InstallParameters {
        @Nonnull
        public List<String> getScopes();

        @Nonnull
        public Set<Permission> getPermissions();
    }

    public static interface IntegrationTypeConfiguration {
        @Nullable
        public InstallParameters getInstallParameters();
    }
}

