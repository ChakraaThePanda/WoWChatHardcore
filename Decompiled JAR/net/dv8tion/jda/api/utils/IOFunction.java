/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.utils;

import java.io.IOException;
import net.dv8tion.jda.annotations.UnknownNullability;

@FunctionalInterface
public interface IOFunction<T, R> {
    @UnknownNullability
    public R apply(T var1) throws IOException;
}

