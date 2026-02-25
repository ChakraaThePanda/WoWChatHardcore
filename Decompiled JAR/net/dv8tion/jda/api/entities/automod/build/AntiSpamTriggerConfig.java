/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities.automod.build;

import net.dv8tion.jda.api.entities.automod.AutoModTriggerType;
import net.dv8tion.jda.api.entities.automod.build.AbstractTriggerConfig;

public class AntiSpamTriggerConfig
extends AbstractTriggerConfig<AntiSpamTriggerConfig> {
    protected AntiSpamTriggerConfig() {
        super(AutoModTriggerType.SPAM);
    }
}

