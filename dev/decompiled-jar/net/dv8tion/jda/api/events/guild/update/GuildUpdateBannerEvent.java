/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.guild.update;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.guild.update.GenericGuildUpdateEvent;
import net.dv8tion.jda.api.utils.ImageProxy;

public class GuildUpdateBannerEvent
extends GenericGuildUpdateEvent<String> {
    public static final String IDENTIFIER = "banner";

    public GuildUpdateBannerEvent(@Nonnull JDA api2, long responseNumber, @Nonnull Guild guild, @Nullable String previous) {
        super(api2, responseNumber, guild, previous, guild.getBannerId(), IDENTIFIER);
    }

    @Nullable
    public String getNewBannerId() {
        return (String)this.getNewValue();
    }

    @Nullable
    public String getNewBannerUrl() {
        return this.next == null ? null : String.format("https://cdn.discordapp.com/banners/%s/%s.%s", this.guild.getId(), this.next, ((String)this.next).startsWith("a_") ? "gif" : "png");
    }

    @Nullable
    public ImageProxy getNewBanner() {
        String newBannerUrl = this.getNewBannerUrl();
        return newBannerUrl == null ? null : new ImageProxy(newBannerUrl);
    }

    @Nullable
    public String getOldBannerId() {
        return (String)this.getOldValue();
    }

    @Nullable
    public String getOldBannerUrl() {
        return this.previous == null ? null : String.format("https://cdn.discordapp.com/banners/%s/%s.%s", this.guild.getId(), this.previous, ((String)this.previous).startsWith("a_") ? "gif" : "png");
    }

    @Nullable
    public ImageProxy getOldBanner() {
        String oldBannerUrl = this.getOldBannerUrl();
        return oldBannerUrl == null ? null : new ImageProxy(oldBannerUrl);
    }
}

