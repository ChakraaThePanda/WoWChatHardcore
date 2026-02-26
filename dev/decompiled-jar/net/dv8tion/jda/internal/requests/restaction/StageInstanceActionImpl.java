/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.requests.restaction;

import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.StageInstance;
import net.dv8tion.jda.api.entities.channel.concrete.StageChannel;
import net.dv8tion.jda.api.requests.Request;
import net.dv8tion.jda.api.requests.Response;
import net.dv8tion.jda.api.requests.Route;
import net.dv8tion.jda.api.requests.restaction.StageInstanceAction;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.entities.GuildImpl;
import net.dv8tion.jda.internal.requests.RestActionImpl;
import net.dv8tion.jda.internal.utils.Checks;
import okhttp3.RequestBody;

public class StageInstanceActionImpl
extends RestActionImpl<StageInstance>
implements StageInstanceAction {
    private final StageChannel channel;
    private String topic;

    public StageInstanceActionImpl(StageChannel channel) {
        super(channel.getJDA(), Route.StageInstances.CREATE_INSTANCE.compile(new String[0]));
        this.channel = channel;
    }

    @Override
    @Nonnull
    public StageInstanceAction setCheck(BooleanSupplier checks) {
        return (StageInstanceAction)super.setCheck(checks);
    }

    @Override
    @Nonnull
    public StageInstanceAction timeout(long timeout2, @Nonnull TimeUnit unit) {
        return (StageInstanceAction)super.timeout(timeout2, unit);
    }

    @Override
    @Nonnull
    public StageInstanceAction deadline(long timestamp) {
        return (StageInstanceAction)super.deadline(timestamp);
    }

    @Override
    @Nonnull
    public StageInstanceAction setTopic(@Nonnull String topic) {
        Checks.notBlank(topic, "Topic");
        Checks.notLonger(topic, 120, "Topic");
        this.topic = topic;
        return this;
    }

    @Override
    protected RequestBody finalizeData() {
        DataObject body = DataObject.empty();
        body.put("channel_id", this.channel.getId());
        body.put("topic", this.topic);
        return this.getRequestBody(body);
    }

    @Override
    protected void handleSuccess(Response response, Request<StageInstance> request) {
        StageInstance instance = this.api.getEntityBuilder().createStageInstance((GuildImpl)this.channel.getGuild(), response.getObject());
        request.onSuccess(instance);
    }
}

