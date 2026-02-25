/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.managers;

import java.util.Arrays;
import java.util.Collection;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.automod.AutoModResponse;
import net.dv8tion.jda.api.entities.automod.build.TriggerConfig;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.managers.Manager;
import net.dv8tion.jda.internal.utils.Checks;

public interface AutoModRuleManager
extends Manager<AutoModRuleManager> {
    public static final long NAME = 1L;
    public static final long ENABLED = 2L;
    public static final long RESPONSE = 4L;
    public static final long EXEMPT_ROLES = 8L;
    public static final long EXEMPT_CHANNELS = 16L;
    public static final long TRIGGER_METADATA = 32L;

    @Override
    @Nonnull
    @CheckReturnValue
    public AutoModRuleManager reset(long var1);

    @Override
    @Nonnull
    @CheckReturnValue
    public AutoModRuleManager reset(long ... var1);

    @Nonnull
    @CheckReturnValue
    public AutoModRuleManager setName(@Nonnull String var1);

    @Nonnull
    @CheckReturnValue
    public AutoModRuleManager setEnabled(boolean var1);

    @Nonnull
    @CheckReturnValue
    public AutoModRuleManager setResponses(@Nonnull Collection<? extends AutoModResponse> var1);

    @Nonnull
    @CheckReturnValue
    default public AutoModRuleManager setResponses(AutoModResponse ... responses) {
        Checks.noneNull(responses, "Responses");
        return this.setResponses(Arrays.asList(responses));
    }

    @Nonnull
    @CheckReturnValue
    public AutoModRuleManager setExemptRoles(@Nonnull Collection<Role> var1);

    @Nonnull
    @CheckReturnValue
    default public AutoModRuleManager setExemptRoles(Role ... roles) {
        Checks.noneNull(roles, "Roles");
        return this.setExemptRoles(Arrays.asList(roles));
    }

    @Nonnull
    @CheckReturnValue
    public AutoModRuleManager setExemptChannels(@Nonnull Collection<? extends GuildChannel> var1);

    @Nonnull
    @CheckReturnValue
    default public AutoModRuleManager setExemptChannels(GuildChannel ... channels) {
        Checks.noneNull(channels, "Channels");
        return this.setExemptChannels(Arrays.asList(channels));
    }

    @Nonnull
    @CheckReturnValue
    public AutoModRuleManager setTriggerConfig(@Nonnull TriggerConfig var1);
}

