/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.guild.voice;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.voice.GenericGuildVoiceEvent;

public class GuildVoiceVideoEvent
extends GenericGuildVoiceEvent {
    private final boolean video;

    public GuildVoiceVideoEvent(@Nonnull JDA api2, long responseNumber, @Nonnull Member member, boolean video) {
        super(api2, responseNumber, member);
        this.video = video;
    }

    public boolean isSendingVideo() {
        return this.video;
    }
}

