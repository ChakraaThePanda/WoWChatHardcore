/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.Unmodifiable
 */
package net.dv8tion.jda.api.entities.channel.attribute;

import java.util.List;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Webhook;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.requests.restaction.AuditableRestAction;
import net.dv8tion.jda.api.requests.restaction.WebhookAction;
import org.jetbrains.annotations.Unmodifiable;

public interface IWebhookContainer
extends GuildChannel {
    @Nonnull
    @CheckReturnValue
    public RestAction<@Unmodifiable List<Webhook>> retrieveWebhooks();

    @Nonnull
    @CheckReturnValue
    public WebhookAction createWebhook(@Nonnull String var1);

    @Nonnull
    @CheckReturnValue
    public AuditableRestAction<Void> deleteWebhookById(@Nonnull String var1);
}

