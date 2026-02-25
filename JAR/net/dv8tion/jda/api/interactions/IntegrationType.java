/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.interactions;

import java.util.Set;
import javax.annotation.Nonnull;
import net.dv8tion.jda.internal.utils.Helpers;

public enum IntegrationType {
    UNKNOWN("-1"),
    GUILD_INSTALL("0"),
    USER_INSTALL("1");

    public static final Set<IntegrationType> ALL;
    private final String key;

    private IntegrationType(String key) {
        this.key = key;
    }

    @Nonnull
    public String getType() {
        return this.key;
    }

    @Nonnull
    public static IntegrationType fromKey(@Nonnull String key) {
        for (IntegrationType value : IntegrationType.values()) {
            if (!value.key.equals(key)) continue;
            return value;
        }
        return UNKNOWN;
    }

    static {
        ALL = Helpers.unmodifiableEnumSet((Enum)GUILD_INSTALL, (Enum[])new IntegrationType[]{USER_INSTALL});
    }
}

