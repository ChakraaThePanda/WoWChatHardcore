/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.interactions.component;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.interactions.components.Component;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenuInteraction;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.JDAImpl;
import net.dv8tion.jda.internal.interactions.component.ComponentInteractionImpl;

public abstract class SelectMenuInteractionImpl<T, S extends SelectMenu>
extends ComponentInteractionImpl
implements SelectMenuInteraction<T, S> {
    private final S menu;

    public SelectMenuInteractionImpl(JDAImpl jda, Class<S> type, DataObject data) {
        super(jda, data);
        this.menu = this.message != null ? (SelectMenu)this.message.getActionRows().stream().flatMap(row -> row.getComponents().stream()).filter(type::isInstance).map(type::cast).filter(c -> this.customId.equals(c.getId())).findFirst().orElse(null) : null;
    }

    @Override
    @Nonnull
    public S getComponent() {
        return this.menu;
    }

    @Override
    @Nonnull
    public Component.Type getComponentType() {
        return this.menu.getType();
    }
}

