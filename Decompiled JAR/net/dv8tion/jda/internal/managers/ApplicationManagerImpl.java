/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.managers;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Icon;
import net.dv8tion.jda.api.interactions.IntegrationType;
import net.dv8tion.jda.api.managers.ApplicationManager;
import net.dv8tion.jda.api.requests.Request;
import net.dv8tion.jda.api.requests.Response;
import net.dv8tion.jda.api.requests.Route;
import net.dv8tion.jda.api.utils.data.DataArray;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.managers.ManagerBase;
import net.dv8tion.jda.internal.utils.Checks;
import okhttp3.RequestBody;

public class ApplicationManagerImpl
extends ManagerBase<ApplicationManager>
implements ApplicationManager {
    protected String description;
    protected Icon icon;
    protected Icon coverImage;
    protected Set<String> tags;
    protected String interactionsEndpointUrl;
    protected String customInstallUrl;
    protected ApplicationManager.IntegrationTypeConfig installParams;
    protected Map<IntegrationType, ApplicationManager.IntegrationTypeConfig> integrationTypeConfig;

    public ApplicationManagerImpl(JDA jda) {
        super(jda, Route.Applications.EDIT_BOT_APPLICATION.compile(new String[0]));
    }

    @Override
    @Nonnull
    @CheckReturnValue
    public ApplicationManagerImpl reset(long fields) {
        super.reset(fields);
        if ((fields & 1L) == 1L) {
            this.description = null;
        }
        if ((fields & 2L) == 2L) {
            this.icon = null;
        }
        if ((fields & 4L) == 4L) {
            this.coverImage = null;
        }
        return this;
    }

    @Override
    @Nonnull
    @CheckReturnValue
    public ApplicationManagerImpl reset(long ... fields) {
        super.reset(fields);
        return this;
    }

    @Override
    @Nonnull
    @CheckReturnValue
    public ApplicationManager reset() {
        super.reset();
        return this;
    }

    @Override
    @Nonnull
    public ApplicationManager setDescription(@Nonnull String description) {
        Checks.notNull(description, "Description");
        Checks.notLonger(description.trim(), 400, "Description");
        this.description = description.trim();
        this.set |= 1L;
        return this;
    }

    @Override
    @Nonnull
    public ApplicationManager setIcon(Icon icon) {
        this.icon = icon;
        this.set |= 2L;
        return this;
    }

    @Override
    @Nonnull
    public ApplicationManager setCoverImage(Icon coverImage) {
        this.coverImage = coverImage;
        this.set |= 4L;
        return this;
    }

    @Override
    @Nonnull
    public ApplicationManager setTags(@Nonnull Collection<String> tags) {
        Checks.noneNull(tags, "Tags");
        LinkedHashSet<String> tagSet = new LinkedHashSet<String>();
        for (String tag : tags) {
            Checks.notLonger(tag.trim(), 20, "Tag");
            Checks.notBlank(tag, "Tag");
            tagSet.add(tag.trim());
        }
        this.tags = tagSet;
        this.set |= 0x10L;
        return this;
    }

    @Override
    @Nonnull
    public ApplicationManager setInteractionsEndpointUrl(@Nullable String interactionsEndpointUrl) {
        if (interactionsEndpointUrl != null) {
            this.checkUrl(interactionsEndpointUrl);
        }
        this.interactionsEndpointUrl = interactionsEndpointUrl;
        this.set |= 8L;
        return this;
    }

    @Override
    @Nonnull
    public ApplicationManager setCustomInstallUrl(@Nullable String customInstallUrl) {
        if (customInstallUrl != null) {
            this.checkUrl(customInstallUrl);
        }
        this.customInstallUrl = customInstallUrl;
        this.set |= 0x20L;
        return this;
    }

    @Override
    @Nonnull
    public ApplicationManager setInstallParams(@Nullable ApplicationManager.IntegrationTypeConfig installParams) {
        this.installParams = installParams;
        this.set |= 0x40L;
        return this;
    }

    @Override
    @Nonnull
    public ApplicationManager setIntegrationTypeConfig(@Nullable Map<IntegrationType, ApplicationManager.IntegrationTypeConfig> config) {
        if (config != null) {
            Checks.noneNull(config.keySet(), "IntegrationTypeConfig");
            Checks.noneNull(config.values(), "IntegrationTypeConfig");
            Checks.check(!config.keySet().contains((Object)IntegrationType.UNKNOWN), "IntegrationTypeConfig must not be set for UNKNOWN");
        }
        this.integrationTypeConfig = config;
        this.set |= 0x80L;
        return this;
    }

    @Override
    protected RequestBody finalizeData() {
        DataObject body = DataObject.empty();
        if (this.shouldUpdate(1L)) {
            body.put("description", this.description);
        }
        if (this.shouldUpdate(2L)) {
            body.put("icon", this.icon == null ? null : this.icon.getEncoding());
        }
        if (this.shouldUpdate(4L)) {
            body.put("cover_image", this.coverImage == null ? null : this.coverImage.getEncoding());
        }
        if (this.shouldUpdate(16L)) {
            body.put("tags", DataArray.fromCollection(this.tags));
        }
        if (this.shouldUpdate(8L)) {
            body.put("interactions_endpoint_url", this.interactionsEndpointUrl);
        }
        if (this.shouldUpdate(32L)) {
            body.put("custom_install_url", this.customInstallUrl);
        }
        if (this.shouldUpdate(64L)) {
            body.put("install_params", this.installParams);
        }
        if (this.shouldUpdate(128L)) {
            DataObject config = DataObject.empty();
            this.integrationTypeConfig.forEach((key, value) -> config.put(key.name(), DataObject.empty().put("oauth2_install_params", value)));
            body.put("integration_type_config", config);
        }
        this.reset();
        return this.getRequestBody(body);
    }

    @Override
    protected void handleSuccess(Response response, Request<Void> request) {
        request.onSuccess(null);
    }

    protected void checkUrl(String url) {
        Checks.notLonger(url, 2048, "URL");
        Checks.notBlank(url, "URL");
        Checks.noWhitespace(url, "URL");
    }
}

