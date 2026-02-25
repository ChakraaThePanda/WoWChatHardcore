/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.interactions;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.exceptions.InteractionExpiredException;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.response.InteractionCallbackResponse;
import net.dv8tion.jda.api.requests.Route;
import net.dv8tion.jda.api.requests.restaction.WebhookMessageCreateAction;
import net.dv8tion.jda.api.requests.restaction.WebhookMessageDeleteAction;
import net.dv8tion.jda.api.requests.restaction.WebhookMessageRetrieveAction;
import net.dv8tion.jda.api.utils.MiscUtil;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.JDAImpl;
import net.dv8tion.jda.internal.entities.AbstractWebhookClient;
import net.dv8tion.jda.internal.entities.ReceivedMessage;
import net.dv8tion.jda.internal.interactions.DeferrableInteractionImpl;
import net.dv8tion.jda.internal.interactions.InteractionImpl;
import net.dv8tion.jda.internal.interactions.response.InteractionCallbackResponseImpl;
import net.dv8tion.jda.internal.requests.restaction.AbstractWebhookMessageActionImpl;
import net.dv8tion.jda.internal.requests.restaction.TriggerRestAction;
import net.dv8tion.jda.internal.requests.restaction.WebhookMessageCreateActionImpl;
import net.dv8tion.jda.internal.requests.restaction.WebhookMessageDeleteActionImpl;
import net.dv8tion.jda.internal.requests.restaction.WebhookMessageEditActionImpl;
import net.dv8tion.jda.internal.requests.restaction.WebhookMessageRetrieveActionImpl;
import net.dv8tion.jda.internal.utils.Checks;
import net.dv8tion.jda.internal.utils.JDALogger;

public class InteractionHookImpl
extends AbstractWebhookClient<Message>
implements InteractionHook {
    public static final String TIMEOUT_MESSAGE = "Timed out waiting for interaction acknowledgement";
    private final DeferrableInteractionImpl interaction;
    private final List<TriggerRestAction<?>> readyCallbacks = new LinkedList();
    private final Future<?> timeoutHandle;
    private final ReentrantLock mutex = new ReentrantLock();
    private final String token;
    private Exception exception;
    private boolean isReady;
    private boolean ephemeral;
    private InteractionCallbackResponseImpl callbackResponse;

    public InteractionHookImpl(@Nonnull DeferrableInteractionImpl interaction, @Nonnull JDA api2) {
        super(api2.getSelfUser().getApplicationIdLong(), interaction.getToken(), api2);
        this.interaction = interaction;
        this.token = interaction.getToken();
        this.timeoutHandle = api2.getGatewayPool().schedule(() -> this.fail(new TimeoutException(TIMEOUT_MESSAGE)), 10L, TimeUnit.SECONDS);
    }

    public InteractionHookImpl(@Nonnull JDA api2, @Nonnull String token) {
        super(api2.getSelfUser().getApplicationIdLong(), token, api2);
        this.interaction = null;
        this.token = token;
        this.timeoutHandle = null;
        this.isReady = true;
    }

    public boolean ack() {
        return this.interaction == null || this.interaction.ack();
    }

    public boolean isAck() {
        return this.interaction == null || this.interaction.isAcknowledged();
    }

    public void ready() {
        MiscUtil.locked(this.mutex, () -> {
            if (this.timeoutHandle != null) {
                this.timeoutHandle.cancel(false);
            }
            this.isReady = true;
            this.readyCallbacks.forEach(TriggerRestAction::run);
        });
    }

    public void fail(Exception exception) {
        MiscUtil.locked(this.mutex, () -> {
            if (!this.isReady && this.exception == null) {
                this.exception = exception;
                if (!this.readyCallbacks.isEmpty()) {
                    if (exception instanceof TimeoutException) {
                        JDALogger.getLog(InteractionHook.class).warn("Up to {} Interaction Followup Messages Timed out! Did you forget to acknowledge the interaction?", (Object)this.readyCallbacks.size());
                    }
                    this.readyCallbacks.forEach(callback -> callback.fail(exception));
                }
            }
        });
    }

    private <T extends TriggerRestAction<R>, R> T onReady(T runnable2) {
        return (T)MiscUtil.locked(this.mutex, () -> {
            if (this.isReady) {
                runnable2.run();
            } else if (this.exception != null) {
                runnable2.fail(this.exception);
            } else {
                this.readyCallbacks.add(runnable2);
            }
            return runnable2;
        });
    }

    public InteractionHookImpl setCallbackResponse(InteractionCallbackResponseImpl callbackResponse) {
        this.callbackResponse = callbackResponse;
        return this;
    }

    @Override
    @Nonnull
    public InteractionImpl getInteraction() {
        if (this.interaction == null) {
            throw new IllegalStateException("Cannot get interaction instance from this webhook.");
        }
        return this.interaction;
    }

    @Override
    @Nonnull
    public InteractionCallbackResponse getCallbackResponse() {
        if (!this.hasCallbackResponse()) {
            throw new IllegalStateException("Cannot get callback response. Has this interaction been acknowledged yet?");
        }
        return this.callbackResponse;
    }

    @Override
    public boolean hasCallbackResponse() {
        return this.callbackResponse != null;
    }

    @Override
    public long getExpirationTimestamp() {
        OffsetDateTime creationTime = this.interaction == null ? OffsetDateTime.now() : this.interaction.getTimeCreated();
        return creationTime.plus(15L, ChronoUnit.MINUTES).toEpochSecond() * 1000L;
    }

    @Override
    @Nonnull
    public InteractionHook setEphemeral(boolean ephemeral) {
        this.ephemeral = ephemeral;
        return this;
    }

    @Override
    @Nonnull
    public WebhookMessageCreateActionImpl<Message> sendRequest() {
        Route.CompiledRoute route = Route.Interactions.CREATE_FOLLOWUP.compile(this.api.getSelfUser().getApplicationId(), this.token);
        route = route.withQueryParams("wait", "true");
        WebhookMessageCreateAction action = new WebhookMessageCreateActionImpl<Message>(this.api, route, this::buildMessage).setEphemeral(this.ephemeral);
        ((AbstractWebhookMessageActionImpl)((Object)action)).setCheck(this::checkExpired);
        return (WebhookMessageCreateActionImpl)this.onReady(action);
    }

    @Override
    @Nonnull
    public WebhookMessageEditActionImpl<Message> editRequest(String messageId) {
        if (!"@original".equals(messageId)) {
            Checks.isSnowflake(messageId);
        }
        Route.CompiledRoute route = Route.Interactions.EDIT_FOLLOWUP.compile(this.api.getSelfUser().getApplicationId(), this.token, messageId);
        route = route.withQueryParams("wait", "true");
        WebhookMessageEditActionImpl<Message> action = new WebhookMessageEditActionImpl<Message>(this.api, route, this::buildMessage);
        action.setCheck(this::checkExpired);
        return this.onReady(action);
    }

    @Override
    @Nonnull
    public WebhookMessageDeleteAction deleteMessageById(@Nonnull String messageId) {
        if (!"@original".equals(messageId)) {
            Checks.isSnowflake(messageId);
        }
        Route.CompiledRoute route = Route.Interactions.DELETE_FOLLOWUP.compile(this.api.getSelfUser().getApplicationId(), this.token, messageId);
        WebhookMessageDeleteActionImpl action = new WebhookMessageDeleteActionImpl(this.api, route);
        action.setCheck(this::checkExpired);
        return this.onReady(action);
    }

    @Override
    @Nonnull
    public WebhookMessageRetrieveAction retrieveMessageById(@Nonnull String messageId) {
        if (!"@original".equals(messageId)) {
            Checks.isSnowflake(messageId);
        }
        Route.CompiledRoute route = Route.Interactions.GET_MESSAGE.compile(this.api.getSelfUser().getApplicationId(), this.token, messageId);
        WebhookMessageRetrieveActionImpl action = new WebhookMessageRetrieveActionImpl(this.api, route, (response, request) -> this.buildMessage(response.getObject()));
        action.setCheck(this::checkExpired);
        return this.onReady(action);
    }

    private boolean checkExpired() {
        if (this.isExpired()) {
            throw new InteractionExpiredException();
        }
        return true;
    }

    public Message buildMessage(DataObject json) {
        JDAImpl jda = (JDAImpl)this.api;
        MessageChannel channel = null;
        Guild guild = null;
        if (this.interaction != null) {
            channel = (MessageChannel)this.interaction.getChannel();
            guild = this.interaction.getGuild();
        }
        long channelId = json.getUnsignedLong("channel_id");
        if (channel == null) {
            channel = this.api.getChannelById(MessageChannel.class, channelId);
        }
        ReceivedMessage message = jda.getEntityBuilder().createMessageBestEffort(json, channel, guild);
        return message.withHook(this);
    }
}

