/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.requests.restaction.pagination;

import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.exceptions.ParsingException;
import net.dv8tion.jda.api.requests.Request;
import net.dv8tion.jda.api.requests.Response;
import net.dv8tion.jda.api.requests.Route;
import net.dv8tion.jda.api.requests.restaction.pagination.PaginationAction;
import net.dv8tion.jda.api.requests.restaction.pagination.ReactionPaginationAction;
import net.dv8tion.jda.api.utils.data.DataArray;
import net.dv8tion.jda.internal.entities.EntityBuilder;
import net.dv8tion.jda.internal.entities.UserImpl;
import net.dv8tion.jda.internal.requests.restaction.pagination.PaginationActionImpl;

public class ReactionPaginationActionImpl
extends PaginationActionImpl<User, ReactionPaginationAction>
implements ReactionPaginationAction {
    protected final MessageReaction reaction;

    public ReactionPaginationActionImpl(MessageReaction reaction) {
        this(reaction, MessageReaction.ReactionType.NORMAL);
    }

    public ReactionPaginationActionImpl(MessageReaction reaction, MessageReaction.ReactionType type) {
        super(reaction.getJDA(), ReactionPaginationActionImpl.getCompiledRoute(reaction.getChannelId(), reaction.getMessageId(), ReactionPaginationActionImpl.getCode(reaction), type), 1, 100, 100);
        super.order(PaginationAction.PaginationOrder.FORWARD);
        this.reaction = reaction;
    }

    public ReactionPaginationActionImpl(Message message, String code, MessageReaction.ReactionType type) {
        super(message.getJDA(), ReactionPaginationActionImpl.getCompiledRoute(message.getChannelId(), message.getId(), code, type), 1, 100, 100);
        super.order(PaginationAction.PaginationOrder.FORWARD);
        this.reaction = null;
    }

    public ReactionPaginationActionImpl(MessageChannel channel, String messageId, String code, MessageReaction.ReactionType type) {
        super(channel.getJDA(), ReactionPaginationActionImpl.getCompiledRoute(channel.getId(), messageId, code, type), 1, 100, 100);
        super.order(PaginationAction.PaginationOrder.FORWARD);
        this.reaction = null;
    }

    private static Route.CompiledRoute getCompiledRoute(String channelId, String messageId, String code, MessageReaction.ReactionType type) {
        return Route.Messages.GET_REACTION_USERS.compile(channelId, messageId, code).withQueryParams("type", String.valueOf(type.getId()));
    }

    protected static String getCode(MessageReaction reaction) {
        return reaction.getEmoji().getAsReactionCode();
    }

    @Override
    @Nonnull
    public MessageReaction getReaction() {
        if (this.reaction == null) {
            throw new IllegalStateException("Cannot get reaction for this action");
        }
        return this.reaction;
    }

    @Override
    @Nonnull
    public EnumSet<PaginationAction.PaginationOrder> getSupportedOrders() {
        return EnumSet.of(PaginationAction.PaginationOrder.FORWARD);
    }

    @Override
    protected void handleSuccess(Response response, Request<List<User>> request) {
        EntityBuilder builder = this.api.getEntityBuilder();
        DataArray array = response.getArray();
        LinkedList<UserImpl> users = new LinkedList<UserImpl>();
        for (int i = 0; i < array.length(); ++i) {
            try {
                UserImpl user = builder.createUser(array.getObject(i));
                users.add(user);
                if (this.useCache) {
                    this.cached.add(user);
                }
                this.last = user;
                this.lastKey = ((User)this.last).getIdLong();
                continue;
            }
            catch (NullPointerException | ParsingException e) {
                LOG.warn("Encountered exception in ReactionPagination", e);
            }
        }
        request.onSuccess(users);
    }

    @Override
    protected long getKey(User it) {
        return it.getIdLong();
    }
}

