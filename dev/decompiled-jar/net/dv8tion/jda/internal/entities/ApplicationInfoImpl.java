/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.entities;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.ApplicationInfo;
import net.dv8tion.jda.api.entities.ApplicationTeam;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.interactions.IntegrationType;
import net.dv8tion.jda.internal.utils.Checks;
import net.dv8tion.jda.internal.utils.EntityString;

public class ApplicationInfoImpl
implements ApplicationInfo {
    private final JDA api;
    private final boolean doesBotRequireCodeGrant;
    private final boolean isBotPublic;
    private final long id;
    private final long flags;
    private final String iconId;
    private final String description;
    private final String termsOfServiceUrl;
    private final String privacyPolicyUrl;
    private final String name;
    private final User owner;
    private final ApplicationTeam team;
    private final List<String> tags;
    private final List<String> redirectUris;
    private final String interactionsEndpointUrl;
    private final String roleConnectionsVerificationUrl;
    private final String customAuthUrl;
    private final long defaultAuthUrlPerms;
    private final List<String> defaultAuthUrlScopes;
    private final long approxUserInstallCount;
    private final Map<IntegrationType, ApplicationInfo.IntegrationTypeConfiguration> integrationTypesConfig;
    private String scopes = "bot";

    public ApplicationInfoImpl(JDA api2, String description, boolean doesBotRequireCodeGrant, String iconId, long id, long flags, boolean isBotPublic, String name, String termsOfServiceUrl, String privacyPolicyUrl, User owner, ApplicationTeam team, List<String> tags, List<String> redirectUris, String interactionsEndpointUrl, String roleConnectionsVerificationUrl, String customAuthUrl, long defaultAuthUrlPerms, List<String> defaultAuthUrlScopes, long approxUserInstallCount, Map<IntegrationType, ApplicationInfo.IntegrationTypeConfiguration> integrationTypesConfig) {
        this.api = api2;
        this.description = description;
        this.doesBotRequireCodeGrant = doesBotRequireCodeGrant;
        this.iconId = iconId;
        this.id = id;
        this.flags = flags;
        this.isBotPublic = isBotPublic;
        this.name = name;
        this.termsOfServiceUrl = termsOfServiceUrl;
        this.privacyPolicyUrl = privacyPolicyUrl;
        this.owner = owner;
        this.team = team;
        this.tags = Collections.unmodifiableList(tags);
        this.redirectUris = Collections.unmodifiableList(redirectUris);
        this.interactionsEndpointUrl = interactionsEndpointUrl;
        this.roleConnectionsVerificationUrl = roleConnectionsVerificationUrl;
        this.customAuthUrl = customAuthUrl;
        this.defaultAuthUrlPerms = defaultAuthUrlPerms;
        this.defaultAuthUrlScopes = Collections.unmodifiableList(defaultAuthUrlScopes);
        this.approxUserInstallCount = approxUserInstallCount;
        this.integrationTypesConfig = integrationTypesConfig;
    }

    @Override
    public final boolean doesBotRequireCodeGrant() {
        return this.doesBotRequireCodeGrant;
    }

    public boolean equals(Object obj) {
        return obj instanceof ApplicationInfoImpl && this.id == ((ApplicationInfoImpl)obj).id;
    }

    @Override
    @Nonnull
    public String getDescription() {
        return this.description;
    }

    @Override
    public String getTermsOfServiceUrl() {
        return this.termsOfServiceUrl;
    }

    @Override
    public String getPrivacyPolicyUrl() {
        return this.privacyPolicyUrl;
    }

    @Override
    public String getIconId() {
        return this.iconId;
    }

    @Override
    public String getIconUrl() {
        return this.iconId == null ? null : "https://cdn.discordapp.com/app-icons/" + this.id + '/' + this.iconId + ".png";
    }

    @Override
    @Nonnull
    public ApplicationTeam getTeam() {
        return this.team;
    }

    @Override
    @Nonnull
    public ApplicationInfo setRequiredScopes(@Nonnull Collection<String> scopes) {
        Checks.noneNull(scopes, "Scopes");
        this.scopes = String.join((CharSequence)"+", scopes);
        if (!this.scopes.contains("bot")) {
            this.scopes = this.scopes.isEmpty() ? "bot" : this.scopes + "+bot";
        }
        return this;
    }

    @Override
    public long getIdLong() {
        return this.id;
    }

    @Override
    @Nonnull
    public String getInviteUrl(String guildId, Collection<Permission> permissions) {
        StringBuilder builder = new StringBuilder("https://discord.com/oauth2/authorize?client_id=");
        builder.append(this.getId());
        builder.append("&scope=").append(this.scopes);
        if (permissions != null && !permissions.isEmpty()) {
            builder.append("&permissions=");
            builder.append(Permission.getRaw(permissions));
        }
        if (guildId != null) {
            builder.append("&guild_id=");
            builder.append(guildId);
        }
        return builder.toString();
    }

    @Override
    @Nonnull
    public JDA getJDA() {
        return this.api;
    }

    @Override
    @Nonnull
    public String getName() {
        return this.name;
    }

    @Override
    @Nonnull
    public User getOwner() {
        return this.owner;
    }

    public int hashCode() {
        return Long.hashCode(this.id);
    }

    @Override
    public final boolean isBotPublic() {
        return this.isBotPublic;
    }

    @Override
    @Nonnull
    public List<String> getTags() {
        return this.tags;
    }

    @Override
    @Nonnull
    public List<String> getRedirectUris() {
        return this.redirectUris;
    }

    @Override
    @Nullable
    public String getInteractionsEndpointUrl() {
        return this.interactionsEndpointUrl;
    }

    @Override
    @Nullable
    public String getRoleConnectionsVerificationUrl() {
        return this.roleConnectionsVerificationUrl;
    }

    @Override
    @Nullable
    public String getCustomAuthorizationUrl() {
        return this.customAuthUrl;
    }

    @Override
    @Nonnull
    public EnumSet<Permission> getPermissions() {
        return Permission.getPermissions(this.defaultAuthUrlPerms);
    }

    @Override
    public long getPermissionsRaw() {
        return this.defaultAuthUrlPerms;
    }

    @Override
    public long getFlagsRaw() {
        return this.flags;
    }

    @Override
    @Nonnull
    public List<String> getScopes() {
        return this.defaultAuthUrlScopes;
    }

    @Override
    public long getUserInstallCount() {
        return this.approxUserInstallCount;
    }

    @Override
    @Nonnull
    public Map<IntegrationType, ApplicationInfo.IntegrationTypeConfiguration> getIntegrationTypesConfig() {
        return this.integrationTypesConfig;
    }

    public String toString() {
        return new EntityString(this).toString();
    }

    static class InstallParametersImpl
    implements ApplicationInfo.InstallParameters {
        private final List<String> scopes;
        private final Set<Permission> permissions;

        InstallParametersImpl(List<String> scopes, Set<Permission> permissions) {
            this.scopes = Collections.unmodifiableList(scopes);
            this.permissions = Collections.unmodifiableSet(permissions);
        }

        @Override
        @Nonnull
        public List<String> getScopes() {
            return this.scopes;
        }

        @Override
        @Nonnull
        public Set<Permission> getPermissions() {
            return this.permissions;
        }
    }

    static class IntegrationTypeConfigurationImpl
    implements ApplicationInfo.IntegrationTypeConfiguration {
        private final ApplicationInfo.InstallParameters installParameters;

        IntegrationTypeConfigurationImpl(ApplicationInfo.InstallParameters installParameters) {
            this.installParameters = installParameters;
        }

        @Override
        @Nullable
        public ApplicationInfo.InstallParameters getInstallParameters() {
            return this.installParameters;
        }
    }
}

