/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities.automod.build;

import java.util.Collection;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.automod.AutoModRule;
import net.dv8tion.jda.api.entities.automod.AutoModTriggerType;
import net.dv8tion.jda.api.entities.automod.build.AntiSpamTriggerConfig;
import net.dv8tion.jda.api.entities.automod.build.CustomKeywordTriggerConfig;
import net.dv8tion.jda.api.entities.automod.build.MentionSpamTriggerConfig;
import net.dv8tion.jda.api.entities.automod.build.PresetKeywordTriggerConfig;
import net.dv8tion.jda.api.utils.data.SerializableData;

public interface TriggerConfig
extends SerializableData {
    @Nonnull
    public AutoModTriggerType getType();

    @Nonnull
    public static MentionSpamTriggerConfig mentionSpam(int mentionLimit) {
        return new MentionSpamTriggerConfig(mentionLimit);
    }

    @Nonnull
    public static AntiSpamTriggerConfig antiSpam() {
        return new AntiSpamTriggerConfig();
    }

    @Nonnull
    public static CustomKeywordTriggerConfig keywordFilter(@Nonnull Collection<String> keywords) {
        return new CustomKeywordTriggerConfig().addKeywords(keywords);
    }

    @Nonnull
    public static CustomKeywordTriggerConfig keywordFilter(String ... keywords) {
        return new CustomKeywordTriggerConfig().addKeywords(keywords);
    }

    @Nonnull
    public static CustomKeywordTriggerConfig patternFilter(@Nonnull Collection<String> patterns) {
        return new CustomKeywordTriggerConfig().addPatterns(patterns);
    }

    @Nonnull
    public static CustomKeywordTriggerConfig patternFilter(String ... patterns) {
        return new CustomKeywordTriggerConfig().addPatterns(patterns);
    }

    @Nonnull
    public static PresetKeywordTriggerConfig presetKeywordFilter(@Nonnull Collection<AutoModRule.KeywordPreset> presets) {
        return new PresetKeywordTriggerConfig().enablePresets(presets);
    }

    @Nonnull
    public static PresetKeywordTriggerConfig presetKeywordFilter(AutoModRule.KeywordPreset ... presets) {
        return new PresetKeywordTriggerConfig().enablePresets(presets);
    }
}

