/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.interactions.components.selections;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.IMentionable;
import net.dv8tion.jda.api.entities.Mentions;
import net.dv8tion.jda.api.interactions.components.selections.EntitySelectMenu;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenuInteraction;

public interface EntitySelectInteraction
extends SelectMenuInteraction<IMentionable, EntitySelectMenu> {
    @Nonnull
    public Mentions getMentions();
}

