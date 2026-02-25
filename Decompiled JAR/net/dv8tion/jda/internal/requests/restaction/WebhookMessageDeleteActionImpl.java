/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.requests.restaction;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.requests.Route;
import net.dv8tion.jda.api.requests.restaction.WebhookMessageDeleteAction;
import net.dv8tion.jda.internal.requests.restaction.AbstractWebhookMessageActionImpl;

public class WebhookMessageDeleteActionImpl
extends AbstractWebhookMessageActionImpl<Void, WebhookMessageDeleteActionImpl>
implements WebhookMessageDeleteAction {
    public WebhookMessageDeleteActionImpl(JDA api2, Route.CompiledRoute route) {
        super(api2, route);
    }

    @Override
    protected Route.CompiledRoute finalizeRoute() {
        Route.CompiledRoute route = super.finalizeRoute();
        if (this.threadId != null) {
            route = route.withQueryParams("thread_id", this.threadId);
        }
        return route;
    }
}

