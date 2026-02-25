/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.interactions.components.selections;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.ComponentInteraction;
import net.dv8tion.jda.api.interactions.components.ItemComponent;
import net.dv8tion.jda.api.interactions.components.LayoutComponent;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;
import net.dv8tion.jda.api.requests.RestAction;

public interface SelectMenuInteraction<T, S extends SelectMenu>
extends ComponentInteraction {
    @Nonnull
    public S getComponent();

    @Nonnull
    default public S getSelectMenu() {
        return (S)this.getComponent();
    }

    @Nonnull
    public List<T> getValues();

    @Nonnull
    @CheckReturnValue
    default public RestAction<Void> editSelectMenu(@Nullable SelectMenu newMenu) {
        Message message = this.getMessage();
        ArrayList<ActionRow> components = new ArrayList<ActionRow>(message.getActionRows());
        LayoutComponent.updateComponent(components, this.getComponentId(), (ItemComponent)newMenu);
        if (this.isAcknowledged()) {
            return this.getHook().editMessageComponentsById(message.getId(), components).map(it -> null);
        }
        return this.editComponents(components).map(it -> null);
    }
}

