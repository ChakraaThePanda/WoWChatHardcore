/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities.automod;

import java.util.EnumSet;
import java.util.List;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.ISnowflake;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.automod.AutoModEventType;
import net.dv8tion.jda.api.entities.automod.AutoModResponse;
import net.dv8tion.jda.api.entities.automod.AutoModTriggerType;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.managers.AutoModRuleManager;
import net.dv8tion.jda.api.requests.restaction.AuditableRestAction;

public interface AutoModRule
extends ISnowflake {
    public static final int MAX_RULE_NAME_LENGTH = 100;
    public static final int MAX_KEYWORD_LENGTH = 60;
    public static final int MAX_KEYWORD_AMOUNT = 1000;
    public static final int MAX_ALLOWLIST_CUSTOM_AMOUNT = 100;
    public static final int MAX_ALLOWLIST_PRESET_AMOUNT = 1000;
    public static final int MAX_PATTERN_LENGTH = 260;
    public static final int MAX_PATTERN_AMOUNT = 10;
    public static final int MAX_MENTION_LIMIT = 50;
    public static final int MAX_EXEMPT_ROLES = 20;
    public static final int MAX_EXEMPT_CHANNELS = 50;

    @Nonnull
    public Guild getGuild();

    public long getCreatorIdLong();

    @Nonnull
    default public String getCreatorId() {
        return Long.toUnsignedString(this.getCreatorIdLong());
    }

    @Nonnull
    public String getName();

    @Nonnull
    public AutoModEventType getEventType();

    @Nonnull
    public AutoModTriggerType getTriggerType();

    public boolean isEnabled();

    @Nonnull
    public List<Role> getExemptRoles();

    @Nonnull
    public List<GuildChannel> getExemptChannels();

    @Nonnull
    public List<AutoModResponse> getActions();

    @Nonnull
    public List<String> getFilteredKeywords();

    @Nonnull
    public List<String> getFilteredRegex();

    @Nonnull
    public EnumSet<KeywordPreset> getFilteredPresets();

    @Nonnull
    public List<String> getAllowlist();

    public int getMentionLimit();

    public boolean isMentionRaidProtectionEnabled();

    @Nonnull
    @CheckReturnValue
    default public AutoModRuleManager getManager() {
        return this.getGuild().modifyAutoModRuleById(this.getId());
    }

    @Nonnull
    @CheckReturnValue
    default public AuditableRestAction<Void> delete() {
        return this.getGuild().deleteAutoModRuleById(this.getId());
    }

    public static enum KeywordPreset {
        PROFANITY(1),
        SEXUAL_CONTENT(2),
        SLURS(3),
        UNKNOWN(-1);

        private final int key;

        private KeywordPreset(int key) {
            this.key = key;
        }

        public int getKey() {
            return this.key;
        }

        @Nonnull
        public static KeywordPreset fromKey(int key) {
            for (KeywordPreset preset : KeywordPreset.values()) {
                if (preset.key != key) continue;
                return preset;
            }
            return UNKNOWN;
        }
    }
}

