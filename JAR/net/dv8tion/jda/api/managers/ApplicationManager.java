/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.managers;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Icon;
import net.dv8tion.jda.api.interactions.IntegrationType;
import net.dv8tion.jda.api.managers.Manager;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.api.utils.data.SerializableData;

public interface ApplicationManager
extends Manager<ApplicationManager> {
    public static final long DESCRIPTION = 1L;
    public static final long ICON = 2L;
    public static final long COVER_IMAGE = 4L;
    public static final long INTERACTIONS_ENDPOINT_URL = 8L;
    public static final long TAGS = 16L;
    public static final long CUSTOM_INSTALL_URL = 32L;
    public static final long INSTALL_PARAMS = 64L;
    public static final long INTEGRATION_TYPES_CONFIG = 128L;

    @Override
    @Nonnull
    @CheckReturnValue
    public ApplicationManager reset(long var1);

    @Override
    @Nonnull
    @CheckReturnValue
    public ApplicationManager reset(long ... var1);

    @Nonnull
    @CheckReturnValue
    public ApplicationManager setDescription(@Nonnull String var1);

    @Nonnull
    @CheckReturnValue
    public ApplicationManager setIcon(@Nullable Icon var1);

    @Nonnull
    @CheckReturnValue
    public ApplicationManager setCoverImage(@Nullable Icon var1);

    @Nonnull
    @CheckReturnValue
    public ApplicationManager setTags(@Nonnull Collection<String> var1);

    @Nonnull
    @CheckReturnValue
    public ApplicationManager setInteractionsEndpointUrl(@Nullable String var1);

    @Nonnull
    @CheckReturnValue
    public ApplicationManager setCustomInstallUrl(@Nullable String var1);

    @Nonnull
    @CheckReturnValue
    public ApplicationManager setInstallParams(@Nullable IntegrationTypeConfig var1);

    @Nonnull
    @CheckReturnValue
    public ApplicationManager setIntegrationTypeConfig(@Nullable Map<IntegrationType, IntegrationTypeConfig> var1);

    public static class IntegrationTypeConfig
    implements SerializableData {
        private final Set<String> scopes;
        private final long permissions;

        private IntegrationTypeConfig(Set<String> scopes, long permissions) {
            this.scopes = scopes;
            this.permissions = permissions;
        }

        @Nonnull
        public static IntegrationTypeConfig of(@Nullable Collection<String> scopes, @Nullable Collection<Permission> permissions) {
            return new IntegrationTypeConfig(scopes == null ? Collections.emptySet() : new LinkedHashSet<String>(scopes), permissions == null ? 0L : Permission.getRaw(permissions));
        }

        @Override
        @Nonnull
        public DataObject toData() {
            return DataObject.empty().put("scopes", this.scopes).put("permissions", this.permissions);
        }
    }
}

