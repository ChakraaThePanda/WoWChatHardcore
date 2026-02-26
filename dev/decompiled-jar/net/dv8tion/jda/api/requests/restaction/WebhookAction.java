/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.requests.restaction;

import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Icon;
import net.dv8tion.jda.api.entities.Webhook;
import net.dv8tion.jda.api.entities.channel.unions.IWebhookContainerUnion;
import net.dv8tion.jda.api.requests.restaction.AuditableRestAction;

public interface WebhookAction
extends AuditableRestAction<Webhook> {
    @Override
    @Nonnull
    @CheckReturnValue
    public WebhookAction setCheck(@Nullable BooleanSupplier var1);

    @Override
    @Nonnull
    @CheckReturnValue
    public WebhookAction timeout(long var1, @Nonnull TimeUnit var3);

    @Override
    @Nonnull
    @CheckReturnValue
    public WebhookAction deadline(long var1);

    @Nonnull
    public IWebhookContainerUnion getChannel();

    @Nonnull
    default public Guild getGuild() {
        return this.getChannel().getGuild();
    }

    @Nonnull
    @CheckReturnValue
    public WebhookAction setName(@Nonnull String var1);

    @Nonnull
    @CheckReturnValue
    public WebhookAction setAvatar(@Nullable Icon var1);
}

