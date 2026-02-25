/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.ISnowflake;
import net.dv8tion.jda.api.utils.MiscUtil;
import net.dv8tion.jda.internal.entities.SkuSnowflakeImpl;

public interface SkuSnowflake
extends ISnowflake {
    @Nonnull
    public static SkuSnowflake fromId(long id) {
        return new SkuSnowflakeImpl(id);
    }

    @Nonnull
    public static SkuSnowflake fromId(@Nonnull String id) {
        return SkuSnowflake.fromId(MiscUtil.parseSnowflake(id));
    }
}

