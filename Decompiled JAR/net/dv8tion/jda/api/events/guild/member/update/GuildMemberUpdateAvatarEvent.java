/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.guild.member.update;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.member.update.GenericGuildMemberUpdateEvent;
import net.dv8tion.jda.api.utils.ImageProxy;

public class GuildMemberUpdateAvatarEvent
extends GenericGuildMemberUpdateEvent<String> {
    public static final String IDENTIFIER = "avatar";

    public GuildMemberUpdateAvatarEvent(@Nonnull JDA api2, long responseNumber, @Nonnull Member member, @Nullable String oldAvatarId) {
        super(api2, responseNumber, member, oldAvatarId, member.getAvatarId(), IDENTIFIER);
    }

    @Nullable
    public String getOldAvatarId() {
        return (String)this.getOldValue();
    }

    @Nullable
    public String getOldAvatarUrl() {
        return this.previous == null ? null : String.format("https://cdn.discordapp.com/guilds/%s/users/%s/avatars/%s.%s", this.getMember().getGuild().getId(), this.getMember().getId(), this.previous, ((String)this.previous).startsWith("a_") ? "gif" : "png");
    }

    @Nullable
    public ImageProxy getOldAvatar() {
        String oldAvatarUrl = this.getOldAvatarUrl();
        return oldAvatarUrl == null ? null : new ImageProxy(oldAvatarUrl);
    }

    @Nullable
    public String getNewAvatarId() {
        return (String)this.getNewValue();
    }

    @Nullable
    public String getNewAvatarUrl() {
        return this.next == null ? null : String.format("https://cdn.discordapp.com/guilds/%s/users/%s/avatars/%s.%s", this.getMember().getGuild().getId(), this.getMember().getId(), this.next, ((String)this.next).startsWith("a_") ? "gif" : "png");
    }

    @Nullable
    public ImageProxy getNewAvatar() {
        String newAvatarUrl = this.getNewAvatarUrl();
        return newAvatarUrl == null ? null : new ImageProxy(newAvatarUrl);
    }
}

