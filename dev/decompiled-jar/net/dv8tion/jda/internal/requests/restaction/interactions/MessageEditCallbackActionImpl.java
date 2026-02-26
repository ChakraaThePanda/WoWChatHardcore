/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.requests.restaction.interactions;

import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.requests.restaction.interactions.InteractionCallbackAction;
import net.dv8tion.jda.api.requests.restaction.interactions.MessageEditCallbackAction;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.api.utils.messages.MessageEditBuilder;
import net.dv8tion.jda.api.utils.messages.MessageEditData;
import net.dv8tion.jda.internal.interactions.InteractionHookImpl;
import net.dv8tion.jda.internal.requests.restaction.interactions.DeferrableCallbackActionImpl;
import net.dv8tion.jda.internal.utils.message.MessageEditBuilderMixin;
import okhttp3.RequestBody;

public class MessageEditCallbackActionImpl
extends DeferrableCallbackActionImpl
implements MessageEditCallbackAction,
MessageEditBuilderMixin<MessageEditCallbackAction> {
    private final MessageEditBuilder builder = new MessageEditBuilder();

    public MessageEditCallbackActionImpl(InteractionHookImpl hook) {
        super(hook);
    }

    @Override
    public MessageEditBuilder getBuilder() {
        return this.builder;
    }

    @Override
    @Nonnull
    public MessageEditCallbackActionImpl setCheck(BooleanSupplier checks) {
        return (MessageEditCallbackActionImpl)super.setCheck(checks);
    }

    @Override
    @Nonnull
    public MessageEditCallbackActionImpl timeout(long timeout2, @Nonnull TimeUnit unit) {
        return (MessageEditCallbackActionImpl)super.timeout(timeout2, unit);
    }

    @Override
    @Nonnull
    public MessageEditCallbackActionImpl deadline(long timestamp) {
        return (MessageEditCallbackActionImpl)super.deadline(timestamp);
    }

    @Override
    @Nonnull
    public MessageEditCallbackActionImpl closeResources() {
        this.builder.closeFiles();
        return this;
    }

    private boolean isEmpty() {
        return this.builder.isEmpty();
    }

    @Override
    protected RequestBody finalizeData() {
        DataObject json = DataObject.empty();
        if (this.isEmpty()) {
            return this.getRequestBody(json.put("type", InteractionCallbackAction.ResponseType.DEFERRED_MESSAGE_UPDATE.getRaw()));
        }
        json.put("type", InteractionCallbackAction.ResponseType.MESSAGE_UPDATE.getRaw());
        try (MessageEditData data = this.builder.build();){
            json.put("data", data);
            RequestBody requestBody = this.getMultipartBody(data.getFiles(), json);
            return requestBody;
        }
    }
}

