/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.requests.restaction;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.channel.forums.ForumTagSnowflake;
import net.dv8tion.jda.api.requests.restaction.AbstractWebhookMessageAction;
import net.dv8tion.jda.api.requests.restaction.ThreadCreateMetadata;
import net.dv8tion.jda.api.utils.messages.MessageCreateRequest;

public interface WebhookMessageCreateAction<T>
extends MessageCreateRequest<WebhookMessageCreateAction<T>>,
AbstractWebhookMessageAction<T, WebhookMessageCreateAction<T>> {
    @Nonnull
    @CheckReturnValue
    public WebhookMessageCreateAction<T> setEphemeral(boolean var1);

    @Nonnull
    @CheckReturnValue
    public WebhookMessageCreateAction<T> setUsername(@Nullable String var1);

    @Nonnull
    @CheckReturnValue
    public WebhookMessageCreateAction<T> setAvatarUrl(@Nullable String var1);

    @Nonnull
    @CheckReturnValue
    public WebhookMessageCreateAction<T> createThread(@Nonnull ThreadCreateMetadata var1);

    @Nonnull
    @CheckReturnValue
    default public WebhookMessageCreateAction<T> createThread(@Nonnull String threadName, ForumTagSnowflake ... tags) {
        return this.createThread(new ThreadCreateMetadata(threadName).addTags(tags));
    }
}

