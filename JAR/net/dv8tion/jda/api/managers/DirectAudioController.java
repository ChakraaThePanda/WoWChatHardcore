/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.managers;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;

public interface DirectAudioController {
    @Nonnull
    public JDA getJDA();

    public void connect(@Nonnull AudioChannel var1);

    public void disconnect(@Nonnull Guild var1);

    public void reconnect(@Nonnull AudioChannel var1);
}

