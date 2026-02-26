/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.interaction.component;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.component.GenericComponentInteractionCreateEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.buttons.ButtonInteraction;

public class ButtonInteractionEvent
extends GenericComponentInteractionCreateEvent
implements ButtonInteraction {
    private final ButtonInteraction interaction;

    public ButtonInteractionEvent(@Nonnull JDA api2, long responseNumber, @Nonnull ButtonInteraction interaction) {
        super(api2, responseNumber, interaction);
        this.interaction = interaction;
    }

    @Override
    @Nonnull
    public ButtonInteraction getInteraction() {
        return this.interaction;
    }

    @Override
    @Nonnull
    public Button getComponent() {
        return this.interaction.getComponent();
    }

    @Override
    @Nonnull
    public Button getButton() {
        return this.interaction.getButton();
    }
}

