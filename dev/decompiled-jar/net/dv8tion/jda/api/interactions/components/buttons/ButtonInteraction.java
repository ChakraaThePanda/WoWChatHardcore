/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.interactions.components.buttons;

import java.util.ArrayList;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.ComponentInteraction;
import net.dv8tion.jda.api.interactions.components.ItemComponent;
import net.dv8tion.jda.api.interactions.components.LayoutComponent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.requests.RestAction;

public interface ButtonInteraction
extends ComponentInteraction {
    @Override
    @Nonnull
    default public Button getComponent() {
        return this.getButton();
    }

    @Nonnull
    public Button getButton();

    @Nonnull
    @CheckReturnValue
    default public RestAction<Void> editButton(@Nullable Button newButton) {
        Message message = this.getMessage();
        ArrayList<ActionRow> components = new ArrayList<ActionRow>(message.getActionRows());
        LayoutComponent.updateComponent(components, this.getComponentId(), (ItemComponent)newButton);
        if (this.isAcknowledged()) {
            return this.getHook().editMessageComponentsById(message.getId(), components).map(it -> null);
        }
        return this.editComponents(components).map(it -> null);
    }
}

