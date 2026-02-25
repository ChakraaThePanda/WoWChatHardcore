/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.audio.hooks;

import java.util.EnumSet;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.audio.SpeakingMode;
import net.dv8tion.jda.api.audio.hooks.ConnectionStatus;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.UserSnowflake;

public interface ConnectionListener {
    default public void onPing(long ping) {
    }

    default public void onStatusChange(@Nonnull ConnectionStatus status) {
    }

    default public void onUserSpeakingModeUpdate(@Nonnull User user, @Nonnull EnumSet<SpeakingMode> modes) {
    }

    default public void onUserSpeakingModeUpdate(@Nonnull UserSnowflake user, @Nonnull EnumSet<SpeakingMode> modes) {
    }
}

