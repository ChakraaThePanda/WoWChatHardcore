/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.interactions.components;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.interactions.components.ItemComponent;

public interface ActionComponent
extends ItemComponent {
    @Nullable
    public String getId();

    public boolean isDisabled();

    @Nonnull
    @CheckReturnValue
    default public ActionComponent asDisabled() {
        return this.withDisabled(true);
    }

    @Nonnull
    @CheckReturnValue
    default public ActionComponent asEnabled() {
        return this.withDisabled(false);
    }

    @Nonnull
    @CheckReturnValue
    public ActionComponent withDisabled(boolean var1);
}

