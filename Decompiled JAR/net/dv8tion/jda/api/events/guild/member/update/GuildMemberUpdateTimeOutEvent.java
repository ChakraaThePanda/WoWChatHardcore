/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.guild.member.update;

import java.time.OffsetDateTime;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.member.update.GenericGuildMemberUpdateEvent;

public class GuildMemberUpdateTimeOutEvent
extends GenericGuildMemberUpdateEvent<OffsetDateTime> {
    public static final String IDENTIFIER = "timeout_time";

    public GuildMemberUpdateTimeOutEvent(@Nonnull JDA api2, long responseNumber, @Nonnull Member member, @Nullable OffsetDateTime previous) {
        super(api2, responseNumber, member, previous, member.getTimeOutEnd(), IDENTIFIER);
    }

    @Nullable
    public OffsetDateTime getOldTimeOutEnd() {
        return (OffsetDateTime)this.getOldValue();
    }

    @Nullable
    public OffsetDateTime getNewTimeOutEnd() {
        return (OffsetDateTime)this.getNewValue();
    }
}

