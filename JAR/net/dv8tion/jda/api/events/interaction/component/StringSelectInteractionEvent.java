/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.interaction.component;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.component.GenericSelectMenuInteractionEvent;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectInteraction;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;

public class StringSelectInteractionEvent
extends GenericSelectMenuInteractionEvent<String, StringSelectMenu>
implements StringSelectInteraction {
    private final StringSelectInteraction interaction;

    public StringSelectInteractionEvent(@Nonnull JDA api2, long responseNumber, @Nonnull StringSelectInteraction interaction) {
        super(api2, responseNumber, interaction);
        this.interaction = interaction;
    }

    @Override
    @Nonnull
    public StringSelectInteraction getInteraction() {
        return this.interaction;
    }
}

