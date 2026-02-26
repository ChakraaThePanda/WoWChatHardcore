/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.requests.restaction.interactions;

import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.requests.restaction.interactions.InteractionCallbackAction;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.api.utils.messages.MessageCreateBuilder;
import net.dv8tion.jda.api.utils.messages.MessageCreateData;
import net.dv8tion.jda.internal.interactions.InteractionHookImpl;
import net.dv8tion.jda.internal.requests.restaction.interactions.DeferrableCallbackActionImpl;
import net.dv8tion.jda.internal.utils.message.MessageCreateBuilderMixin;
import okhttp3.RequestBody;

public class ReplyCallbackActionImpl
extends DeferrableCallbackActionImpl
implements ReplyCallbackAction,
MessageCreateBuilderMixin<ReplyCallbackAction> {
    private final MessageCreateBuilder builder = new MessageCreateBuilder();
    private int flags;

    public ReplyCallbackActionImpl(InteractionHookImpl hook) {
        super(hook);
    }

    @Override
    public MessageCreateBuilder getBuilder() {
        return this.builder;
    }

    @Override
    @Nonnull
    public ReplyCallbackActionImpl closeResources() {
        this.builder.closeFiles();
        return this;
    }

    @Override
    @Nonnull
    protected RequestBody finalizeData() {
        DataObject json = DataObject.empty();
        if (this.builder.isEmpty()) {
            json.put("type", InteractionCallbackAction.ResponseType.DEFERRED_CHANNEL_MESSAGE_WITH_SOURCE.getRaw());
            if (this.flags != 0) {
                json.put("data", DataObject.empty().put("flags", this.flags));
            }
            return this.getRequestBody(json);
        }
        json.put("type", InteractionCallbackAction.ResponseType.CHANNEL_MESSAGE_WITH_SOURCE.getRaw());
        try (MessageCreateData data = this.builder.build();){
            DataObject msg = data.toData();
            msg.put("flags", msg.getInt("flags", 0) | this.flags);
            json.put("data", msg);
            RequestBody requestBody = this.getMultipartBody(data.getFiles(), json);
            return requestBody;
        }
    }

    @Override
    @Nonnull
    public ReplyCallbackActionImpl setEphemeral(boolean ephemeral) {
        int flag = Message.MessageFlag.EPHEMERAL.getValue();
        this.flags = ephemeral ? (this.flags |= flag) : (this.flags &= ~flag);
        return this;
    }

    @Override
    @Nonnull
    public ReplyCallbackAction setCheck(BooleanSupplier checks) {
        return (ReplyCallbackAction)super.setCheck(checks);
    }

    @Override
    @Nonnull
    public ReplyCallbackAction timeout(long timeout2, @Nonnull TimeUnit unit) {
        return (ReplyCallbackAction)super.timeout(timeout2, unit);
    }

    @Override
    @Nonnull
    public ReplyCallbackAction deadline(long timestamp) {
        return (ReplyCallbackAction)super.deadline(timestamp);
    }
}

