/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.interaction.component;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.IMentionable;
import net.dv8tion.jda.api.entities.Mentions;
import net.dv8tion.jda.api.events.interaction.component.GenericSelectMenuInteractionEvent;
import net.dv8tion.jda.api.interactions.components.selections.EntitySelectInteraction;
import net.dv8tion.jda.api.interactions.components.selections.EntitySelectMenu;

public class EntitySelectInteractionEvent
extends GenericSelectMenuInteractionEvent<IMentionable, EntitySelectMenu>
implements EntitySelectInteraction {
    private final EntitySelectInteraction interaction;

    public EntitySelectInteractionEvent(@Nonnull JDA api2, long responseNumber, @Nonnull EntitySelectInteraction interaction) {
        super(api2, responseNumber, interaction);
        this.interaction = interaction;
    }

    @Override
    @Nonnull
    public EntitySelectInteraction getInteraction() {
        return this.interaction;
    }

    @Override
    @Nonnull
    public Mentions getMentions() {
        return this.interaction.getMentions();
    }
}

