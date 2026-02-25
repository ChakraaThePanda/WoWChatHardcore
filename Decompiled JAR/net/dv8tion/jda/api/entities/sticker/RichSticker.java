/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities.sticker;

import java.util.Set;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.sticker.Sticker;

public interface RichSticker
extends Sticker {
    @Nonnull
    public Sticker.Type getType();

    @Nonnull
    public Set<String> getTags();

    @Nonnull
    public String getDescription();
}

