/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.stage.update;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.StageInstance;
import net.dv8tion.jda.api.events.stage.update.GenericStageInstanceUpdateEvent;

public class StageInstanceUpdateTopicEvent
extends GenericStageInstanceUpdateEvent<String> {
    public static final String IDENTIFIER = "topic";

    public StageInstanceUpdateTopicEvent(@Nonnull JDA api2, long responseNumber, @Nonnull StageInstance stageInstance, String previous) {
        super(api2, responseNumber, stageInstance, previous, stageInstance.getTopic(), IDENTIFIER);
    }

    @Override
    @Nonnull
    public String getOldValue() {
        return (String)super.getOldValue();
    }

    @Override
    @Nonnull
    public String getNewValue() {
        return (String)super.getNewValue();
    }
}

