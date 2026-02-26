/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.interactions;

import java.util.Set;
import javax.annotation.Nonnull;
import net.dv8tion.jda.internal.utils.Helpers;

public enum InteractionContextType {
    UNKNOWN("-1"),
    GUILD("0"),
    BOT_DM("1"),
    PRIVATE_CHANNEL("2");

    public static final Set<InteractionContextType> ALL;
    private final String key;

    private InteractionContextType(String key) {
        this.key = key;
    }

    @Nonnull
    public String getType() {
        return this.key;
    }

    @Nonnull
    public static InteractionContextType fromKey(@Nonnull String key) {
        for (InteractionContextType value : InteractionContextType.values()) {
            if (!value.key.equals(key)) continue;
            return value;
        }
        return UNKNOWN;
    }

    static {
        ALL = Helpers.unmodifiableEnumSet((Enum)GUILD, (Enum[])new InteractionContextType[]{BOT_DM, PRIVATE_CHANNEL});
    }
}

