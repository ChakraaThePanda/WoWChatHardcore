/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.stage;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.StageInstance;
import net.dv8tion.jda.api.events.stage.GenericStageInstanceEvent;

public class StageInstanceCreateEvent
extends GenericStageInstanceEvent {
    public StageInstanceCreateEvent(@Nonnull JDA api2, long responseNumber, @Nonnull StageInstance stageInstance) {
        super(api2, responseNumber, stageInstance);
    }
}

