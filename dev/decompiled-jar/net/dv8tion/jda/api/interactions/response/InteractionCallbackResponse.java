/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.interactions.response;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.requests.restaction.interactions.InteractionCallbackAction;

public interface InteractionCallbackResponse {
    @Nullable
    public Message getMessage();

    @Nonnull
    public InteractionCallbackAction.ResponseType getResponseType();
}

