/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.guild.member.update;

import java.util.EnumSet;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.member.update.GenericGuildMemberUpdateEvent;

public class GuildMemberUpdateFlagsEvent
extends GenericGuildMemberUpdateEvent<EnumSet<Member.MemberFlag>> {
    public static final String IDENTIFIER = "flags";

    public GuildMemberUpdateFlagsEvent(@Nonnull JDA api2, long responseNumber, @Nonnull Member member, @Nonnull EnumSet<Member.MemberFlag> previous) {
        super(api2, responseNumber, member, previous, member.getFlags(), IDENTIFIER);
    }
}

