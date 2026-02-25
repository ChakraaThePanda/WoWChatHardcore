/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.automod;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.automod.AutoModExecution;
import net.dv8tion.jda.api.entities.automod.AutoModResponse;
import net.dv8tion.jda.api.entities.automod.AutoModTriggerType;
import net.dv8tion.jda.api.entities.channel.unions.GuildMessageChannelUnion;
import net.dv8tion.jda.api.events.Event;

public class AutoModExecutionEvent
extends Event
implements AutoModExecution {
    private final AutoModExecution execution;

    public AutoModExecutionEvent(@Nonnull JDA api2, long responseNumber, @Nonnull AutoModExecution execution) {
        super(api2, responseNumber);
        this.execution = execution;
    }

    @Override
    @Nonnull
    public Guild getGuild() {
        return this.execution.getGuild();
    }

    @Override
    @Nullable
    public GuildMessageChannelUnion getChannel() {
        return this.execution.getChannel();
    }

    @Override
    @Nonnull
    public AutoModResponse getResponse() {
        return this.execution.getResponse();
    }

    @Override
    @Nonnull
    public AutoModTriggerType getTriggerType() {
        return this.execution.getTriggerType();
    }

    @Override
    public long getUserIdLong() {
        return this.execution.getUserIdLong();
    }

    @Override
    public long getRuleIdLong() {
        return this.execution.getRuleIdLong();
    }

    @Override
    public long getMessageIdLong() {
        return this.execution.getMessageIdLong();
    }

    @Override
    public long getAlertMessageIdLong() {
        return this.execution.getAlertMessageIdLong();
    }

    @Override
    @Nonnull
    public String getContent() {
        return this.execution.getContent();
    }

    @Override
    @Nullable
    public String getMatchedContent() {
        return this.execution.getMatchedContent();
    }

    @Override
    @Nullable
    public String getMatchedKeyword() {
        return this.execution.getMatchedKeyword();
    }
}

