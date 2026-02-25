/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.requests.restaction.pagination;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.ThreadMember;
import net.dv8tion.jda.api.entities.channel.concrete.ThreadChannel;
import net.dv8tion.jda.api.exceptions.ParsingException;
import net.dv8tion.jda.api.requests.Request;
import net.dv8tion.jda.api.requests.Response;
import net.dv8tion.jda.api.requests.Route;
import net.dv8tion.jda.api.requests.restaction.pagination.PaginationAction;
import net.dv8tion.jda.api.requests.restaction.pagination.ThreadMemberPaginationAction;
import net.dv8tion.jda.api.utils.data.DataArray;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.entities.EntityBuilder;
import net.dv8tion.jda.internal.entities.channel.concrete.ThreadChannelImpl;
import net.dv8tion.jda.internal.requests.restaction.pagination.PaginationActionImpl;

public class ThreadMemberPaginationActionImpl
extends PaginationActionImpl<ThreadMember, ThreadMemberPaginationAction>
implements ThreadMemberPaginationAction {
    private final ThreadChannelImpl channel;

    public ThreadMemberPaginationActionImpl(ThreadChannel channel) {
        super(channel.getJDA(), Route.Channels.LIST_THREAD_MEMBERS.compile(channel.getId()).withQueryParams("with_member", "true"), 1, 100, 100);
        this.channel = (ThreadChannelImpl)channel;
        this.order = PaginationAction.PaginationOrder.FORWARD;
    }

    @Override
    @Nonnull
    public ThreadChannel getThreadChannel() {
        return this.channel;
    }

    @Override
    @Nonnull
    public EnumSet<PaginationAction.PaginationOrder> getSupportedOrders() {
        return EnumSet.of(this.getOrder());
    }

    @Override
    protected long getKey(ThreadMember it) {
        return it.getIdLong();
    }

    @Override
    protected void handleSuccess(Response response, Request<List<ThreadMember>> request) {
        DataArray array = response.getArray();
        ArrayList<ThreadMember> members = new ArrayList<ThreadMember>(array.length());
        EntityBuilder builder = this.api.getEntityBuilder();
        for (int i = 0; i < array.length(); ++i) {
            try {
                DataObject object = array.getObject(i);
                if (object.isNull("member")) continue;
                ThreadMember threadMember = builder.createThreadMember(this.channel.getGuild(), this.channel, object);
                members.add(threadMember);
                continue;
            }
            catch (NullPointerException | ParsingException e) {
                LOG.warn("Encountered an exception in ThreadMemberPaginationAction", e);
            }
        }
        if (this.useCache) {
            this.cached.addAll(members);
        }
        if (!members.isEmpty()) {
            this.last = members.get(members.size() - 1);
            this.lastKey = ((ThreadMember)this.last).getIdLong();
        }
        request.onSuccess(members);
    }
}

