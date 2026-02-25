/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.managers;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.annotations.ForRemoval;
import net.dv8tion.jda.api.entities.StageInstance;
import net.dv8tion.jda.api.managers.Manager;

public interface StageInstanceManager
extends Manager<StageInstanceManager> {
    public static final long TOPIC = 1L;
    @Deprecated
    @ForRemoval(deadline="5.3.0")
    public static final long PRIVACY_LEVEL = 2L;

    @Override
    @Nonnull
    @CheckReturnValue
    public StageInstanceManager reset(long var1);

    @Override
    @Nonnull
    @CheckReturnValue
    public StageInstanceManager reset(long ... var1);

    @Nonnull
    public StageInstance getStageInstance();

    @Nonnull
    @CheckReturnValue
    public StageInstanceManager setTopic(@Nullable String var1);
}

