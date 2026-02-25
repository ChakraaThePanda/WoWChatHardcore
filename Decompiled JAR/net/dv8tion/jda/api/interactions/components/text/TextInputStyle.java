/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.interactions.components.text;

import javax.annotation.Nonnull;

public enum TextInputStyle {
    UNKNOWN(-1),
    SHORT(1),
    PARAGRAPH(2);

    private final int key;

    private TextInputStyle(int type) {
        this.key = type;
    }

    public int getRaw() {
        return this.key;
    }

    @Nonnull
    public static TextInputStyle fromKey(int key) {
        for (TextInputStyle style : TextInputStyle.values()) {
            if (style.key != key) continue;
            return style;
        }
        return UNKNOWN;
    }
}

