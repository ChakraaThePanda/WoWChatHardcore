/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.interactions.commands;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.IMentionable;

public interface ICommandReference
extends IMentionable {
    @Nonnull
    public String getName();

    @Nonnull
    public String getFullCommandName();

    @Override
    @Nonnull
    default public String getAsMention() {
        return "</" + this.getFullCommandName() + ":" + this.getIdLong() + ">";
    }
}

