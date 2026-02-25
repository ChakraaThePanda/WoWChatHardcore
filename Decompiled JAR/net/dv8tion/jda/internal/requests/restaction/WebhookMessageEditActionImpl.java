/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.requests.restaction;

import java.util.function.Function;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.requests.Request;
import net.dv8tion.jda.api.requests.Response;
import net.dv8tion.jda.api.requests.Route;
import net.dv8tion.jda.api.requests.restaction.WebhookMessageEditAction;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.api.utils.messages.MessageEditBuilder;
import net.dv8tion.jda.api.utils.messages.MessageEditData;
import net.dv8tion.jda.internal.requests.restaction.AbstractWebhookMessageActionImpl;
import net.dv8tion.jda.internal.utils.message.MessageEditBuilderMixin;
import okhttp3.RequestBody;

public class WebhookMessageEditActionImpl<T>
extends AbstractWebhookMessageActionImpl<T, WebhookMessageEditActionImpl<T>>
implements WebhookMessageEditAction<T>,
MessageEditBuilderMixin<WebhookMessageEditAction<T>> {
    private final Function<DataObject, T> transformer;
    private final MessageEditBuilder builder = new MessageEditBuilder();

    public WebhookMessageEditActionImpl(JDA api2, Route.CompiledRoute route, Function<DataObject, T> transformer) {
        super(api2, route);
        this.transformer = transformer;
    }

    @Override
    public MessageEditBuilder getBuilder() {
        return this.builder;
    }

    @Override
    protected RequestBody finalizeData() {
        try (MessageEditData data = this.builder.build();){
            DataObject payload = data.toData();
            RequestBody requestBody = this.getMultipartBody(data.getFiles(), payload);
            return requestBody;
        }
    }

    @Override
    protected Route.CompiledRoute finalizeRoute() {
        Route.CompiledRoute route = super.finalizeRoute();
        if (this.threadId != null) {
            route = route.withQueryParams("thread_id", this.threadId);
        }
        return route;
    }

    @Override
    protected void handleSuccess(Response response, Request<T> request) {
        T message = this.transformer.apply(response.getObject());
        request.onSuccess(message);
    }
}

