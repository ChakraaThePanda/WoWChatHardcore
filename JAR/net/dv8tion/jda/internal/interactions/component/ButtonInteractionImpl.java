/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.interactions.component;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.interactions.components.Component;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.buttons.ButtonInteraction;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.JDAImpl;
import net.dv8tion.jda.internal.interactions.component.ComponentInteractionImpl;

public class ButtonInteractionImpl
extends ComponentInteractionImpl
implements ButtonInteraction {
    private final Button button;

    public ButtonInteractionImpl(JDAImpl jda, DataObject data) {
        super(jda, data);
        this.button = this.message != null ? this.message.getButtonById(this.customId) : null;
    }

    @Override
    @Nonnull
    public Component.Type getComponentType() {
        return Component.Type.BUTTON;
    }

    @Override
    @Nonnull
    public Button getButton() {
        return this.button;
    }
}

