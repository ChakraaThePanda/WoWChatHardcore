/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.Unmodifiable
 */
package net.dv8tion.jda.api.interactions.components.selections;

import java.util.List;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenuInteraction;
import net.dv8tion.jda.api.interactions.components.selections.SelectOption;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;
import net.dv8tion.jda.internal.utils.Helpers;
import org.jetbrains.annotations.Unmodifiable;

public interface StringSelectInteraction
extends SelectMenuInteraction<String, StringSelectMenu> {
    @Override
    @Nonnull
    public @Unmodifiable List<String> getValues();

    @Nonnull
    default public @Unmodifiable List<SelectOption> getSelectedOptions() {
        StringSelectMenu menu = (StringSelectMenu)this.getComponent();
        List<String> values2 = this.getValues();
        return menu.getOptions().stream().filter(it -> values2.contains(it.getValue())).collect(Helpers.toUnmodifiableList());
    }
}

