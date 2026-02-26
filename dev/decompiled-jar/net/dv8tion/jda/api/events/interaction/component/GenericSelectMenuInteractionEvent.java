/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.interaction.component;

import java.util.List;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.component.GenericComponentInteractionCreateEvent;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenuInteraction;

public class GenericSelectMenuInteractionEvent<T, S extends SelectMenu>
extends GenericComponentInteractionCreateEvent
implements SelectMenuInteraction<T, S> {
    private final SelectMenuInteraction<T, S> menuInteraction;

    public GenericSelectMenuInteractionEvent(@Nonnull JDA api2, long responseNumber, @Nonnull SelectMenuInteraction<T, S> interaction) {
        super(api2, responseNumber, interaction);
        this.menuInteraction = interaction;
    }

    @Override
    @Nonnull
    public SelectMenuInteraction<T, S> getInteraction() {
        return this.menuInteraction;
    }

    @Override
    @Nonnull
    public S getComponent() {
        return (S)this.menuInteraction.getComponent();
    }

    @Override
    @Nonnull
    public List<T> getValues() {
        return this.menuInteraction.getValues();
    }
}

