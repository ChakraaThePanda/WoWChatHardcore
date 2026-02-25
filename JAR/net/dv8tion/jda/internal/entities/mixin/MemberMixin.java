/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.entities.mixin;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.internal.entities.detached.mixin.IDetachableEntityMixin;

public interface MemberMixin<T extends MemberMixin<T>>
extends Member,
IDetachableEntityMixin {
    public T setNickname(String var1);

    public T setAvatarId(String var1);

    public T setJoinDate(long var1);

    public T setBoostDate(long var1);

    public T setTimeOutEnd(long var1);

    public T setPending(boolean var1);

    public T setFlags(int var1);
}

