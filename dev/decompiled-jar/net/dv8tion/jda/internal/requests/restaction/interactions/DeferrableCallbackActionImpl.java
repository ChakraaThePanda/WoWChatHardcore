/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.requests.restaction.interactions;

import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.requests.Request;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.interactions.InteractionHookImpl;
import net.dv8tion.jda.internal.interactions.response.InteractionCallbackResponseImpl;
import net.dv8tion.jda.internal.requests.restaction.interactions.InteractionCallbackImpl;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;

public abstract class DeferrableCallbackActionImpl
extends InteractionCallbackImpl<InteractionHook> {
    protected final InteractionHookImpl hook;

    public DeferrableCallbackActionImpl(InteractionHookImpl hook) {
        super(hook.getInteraction());
        this.hook = hook;
    }

    @Override
    protected void handleSuccess(net.dv8tion.jda.api.requests.Response response, Request<InteractionHook> request) {
        this.interaction.releaseHook(true);
        this.parseOptionalBody(response);
        request.onSuccess(this.hook);
    }

    private void parseOptionalBody(net.dv8tion.jda.api.requests.Response response) {
        Response rawResponse = response.getRawResponse();
        if (rawResponse == null) {
            return;
        }
        ResponseBody body = rawResponse.body();
        if (body == null) {
            return;
        }
        MediaType mediaType = body.contentType();
        if (mediaType != null && mediaType.toString().startsWith("application/json")) {
            response.optObject().flatMap((? super T obj) -> obj.optObject("resource")).ifPresent(resource -> this.hook.setCallbackResponse(new InteractionCallbackResponseImpl(this.hook, (DataObject)resource)));
        }
    }
}

