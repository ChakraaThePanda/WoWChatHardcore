/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.guild.voice;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.entities.channel.unions.AudioChannelUnion;
import net.dv8tion.jda.api.events.UpdateEvent;
import net.dv8tion.jda.api.events.guild.voice.GenericGuildVoiceEvent;

public class GuildVoiceUpdateEvent
extends GenericGuildVoiceEvent
implements UpdateEvent<Member, AudioChannel> {
    public static final String IDENTIFIER = "audio-channel";
    private final AudioChannel previous;
    private final AudioChannel next;

    public GuildVoiceUpdateEvent(@Nonnull JDA api2, long responseNumber, @Nonnull Member member, @Nullable AudioChannel previous) {
        super(api2, responseNumber, member);
        this.previous = previous;
        this.next = member.getVoiceState().getChannel();
    }

    @Nullable
    public AudioChannelUnion getChannelLeft() {
        return (AudioChannelUnion)this.previous;
    }

    @Nullable
    public AudioChannelUnion getChannelJoined() {
        return (AudioChannelUnion)this.next;
    }

    @Override
    @Nonnull
    public String getPropertyIdentifier() {
        return IDENTIFIER;
    }

    @Override
    @Nonnull
    public Member getEntity() {
        return this.member;
    }

    @Override
    @Nullable
    public AudioChannel getOldValue() {
        return this.previous;
    }

    @Override
    @Nullable
    public AudioChannel getNewValue() {
        return this.next;
    }
}

