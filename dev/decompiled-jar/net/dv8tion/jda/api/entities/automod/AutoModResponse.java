/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities.automod;

import java.time.Duration;
import java.util.EnumSet;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.annotations.Incubating;
import net.dv8tion.jda.api.entities.automod.AutoModTriggerType;
import net.dv8tion.jda.api.entities.channel.middleman.GuildMessageChannel;
import net.dv8tion.jda.api.utils.data.SerializableData;
import net.dv8tion.jda.internal.entities.automod.AutoModResponseImpl;
import net.dv8tion.jda.internal.utils.Checks;

public interface AutoModResponse
extends SerializableData {
    public static final int MAX_CUSTOM_MESSAGE_LENGTH = 150;

    @Nonnull
    public Type getType();

    @Nullable
    public GuildMessageChannel getChannel();

    @Nullable
    public String getCustomMessage();

    @Nullable
    public Duration getTimeoutDuration();

    @Nonnull
    public static AutoModResponse blockMessage() {
        return AutoModResponse.blockMessage(null);
    }

    @Nonnull
    public static AutoModResponse blockMessage(@Nullable String customMessage) {
        return new AutoModResponseImpl(Type.BLOCK_MESSAGE, customMessage);
    }

    @Nonnull
    public static AutoModResponse sendAlert(@Nonnull GuildMessageChannel channel) {
        Checks.notNull(channel, "Channel");
        return new AutoModResponseImpl(Type.SEND_ALERT_MESSAGE, channel);
    }

    @Nonnull
    public static AutoModResponse timeoutMember(@Nonnull Duration duration) {
        Checks.notNull(duration, "Duration");
        Checks.check(!duration.isNegative() && !duration.isZero(), "Duration must be positive");
        return new AutoModResponseImpl(Type.TIMEOUT, duration);
    }

    @Nonnull
    @Incubating
    public static AutoModResponse blockMemberInteraction() {
        return new AutoModResponseImpl(Type.BLOCK_MEMBER_INTERACTION);
    }

    public static enum Type {
        BLOCK_MESSAGE(1, EnumSet.of(AutoModTriggerType.KEYWORD, AutoModTriggerType.KEYWORD_PRESET, AutoModTriggerType.SPAM, AutoModTriggerType.MENTION_SPAM)),
        SEND_ALERT_MESSAGE(2, EnumSet.of(AutoModTriggerType.KEYWORD, AutoModTriggerType.KEYWORD_PRESET, AutoModTriggerType.SPAM, AutoModTriggerType.MENTION_SPAM)),
        TIMEOUT(3, EnumSet.of(AutoModTriggerType.KEYWORD, AutoModTriggerType.MENTION_SPAM)),
        BLOCK_MEMBER_INTERACTION(4, EnumSet.of(AutoModTriggerType.MEMBER_PROFILE_KEYWORD)),
        UNKNOWN(-1, EnumSet.noneOf(AutoModTriggerType.class));

        private final int key;
        private final EnumSet<AutoModTriggerType> supportedTypes;

        private Type(int key) {
            this.key = key;
            this.supportedTypes = EnumSet.complementOf(EnumSet.of(AutoModTriggerType.UNKNOWN));
        }

        private Type(int key, EnumSet<AutoModTriggerType> supportedTypes) {
            this.key = key;
            this.supportedTypes = supportedTypes;
        }

        public int getKey() {
            return this.key;
        }

        @Nonnull
        public EnumSet<AutoModTriggerType> getSupportedTypes() {
            return EnumSet.copyOf(this.supportedTypes);
        }

        public boolean isSupportedTrigger(@Nonnull AutoModTriggerType type) {
            Checks.notNull((Object)type, "AutoModTriggerType");
            return this.supportedTypes.contains((Object)type);
        }

        @Nonnull
        public static Type fromKey(int key) {
            for (Type type : Type.values()) {
                if (type.key != key) continue;
                return type;
            }
            return UNKNOWN;
        }
    }
}

