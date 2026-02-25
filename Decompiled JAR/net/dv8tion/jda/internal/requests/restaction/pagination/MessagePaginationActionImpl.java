/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.requests.restaction.pagination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;
import net.dv8tion.jda.api.exceptions.ParsingException;
import net.dv8tion.jda.api.requests.Request;
import net.dv8tion.jda.api.requests.Response;
import net.dv8tion.jda.api.requests.Route;
import net.dv8tion.jda.api.requests.restaction.pagination.MessagePaginationAction;
import net.dv8tion.jda.api.requests.restaction.pagination.PaginationAction;
import net.dv8tion.jda.api.utils.data.DataArray;
import net.dv8tion.jda.internal.entities.EntityBuilder;
import net.dv8tion.jda.internal.entities.ReceivedMessage;
import net.dv8tion.jda.internal.requests.restaction.pagination.PaginationActionImpl;
import net.dv8tion.jda.internal.utils.Checks;

public class MessagePaginationActionImpl
extends PaginationActionImpl<Message, MessagePaginationAction>
implements MessagePaginationAction {
    private final MessageChannel channel;

    public MessagePaginationActionImpl(MessageChannel channel) {
        super(channel.getJDA(), Route.Messages.GET_MESSAGE_HISTORY.compile(channel.getId()), 1, 100, 100);
        if (channel instanceof GuildChannel) {
            GuildChannel guildChannel = (GuildChannel)((Object)channel);
            Member selfMember = guildChannel.getGuild().getSelfMember();
            Checks.checkAccess(selfMember, guildChannel);
            if (!selfMember.hasPermission(guildChannel, Permission.MESSAGE_HISTORY)) {
                throw new InsufficientPermissionException(guildChannel, Permission.MESSAGE_HISTORY);
            }
        }
        this.channel = channel;
    }

    @Override
    @Nonnull
    public MessageChannelUnion getChannel() {
        return (MessageChannelUnion)this.channel;
    }

    @Override
    protected void handleSuccess(Response response, Request<List<Message>> request) {
        DataArray array = response.getArray();
        ArrayList<ReceivedMessage> messages = new ArrayList<ReceivedMessage>(array.length());
        EntityBuilder builder = this.api.getEntityBuilder();
        for (int i = 0; i < array.length(); ++i) {
            try {
                ReceivedMessage msg = builder.createMessageWithChannel(array.getObject(i), this.channel, false);
                messages.add(msg);
                continue;
            }
            catch (NullPointerException | ParsingException e) {
                LOG.warn("Encountered an exception in MessagePagination", e);
                continue;
            }
            catch (IllegalArgumentException e) {
                if ("UNKNOWN_MESSAGE_TYPE".equals(e.getMessage())) {
                    LOG.warn("Skipping unknown message type during pagination", e);
                    continue;
                }
                LOG.warn("Unexpected issue trying to parse message during pagination", e);
            }
        }
        if (this.order == PaginationAction.PaginationOrder.FORWARD) {
            Collections.reverse(messages);
        }
        if (this.useCache) {
            this.cached.addAll(messages);
        }
        if (!messages.isEmpty()) {
            this.last = messages.get(messages.size() - 1);
            this.lastKey = ((Message)this.last).getIdLong();
        }
        request.onSuccess(messages);
    }

    @Override
    protected long getKey(Message it) {
        return it.getIdLong();
    }
}

