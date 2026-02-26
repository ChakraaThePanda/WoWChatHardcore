/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities.channel.attribute;

import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;

public interface IAgeRestrictedChannel
extends GuildChannel {
    public boolean isNSFW();
}

