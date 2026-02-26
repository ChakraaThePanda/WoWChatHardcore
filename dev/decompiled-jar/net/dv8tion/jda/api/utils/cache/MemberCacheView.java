/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.Unmodifiable
 */
package net.dv8tion.jda.api.utils.cache;

import java.util.Collection;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.utils.MiscUtil;
import net.dv8tion.jda.api.utils.cache.SnowflakeCacheView;
import org.jetbrains.annotations.Unmodifiable;

public interface MemberCacheView
extends SnowflakeCacheView<Member> {
    @Override
    @Nullable
    public Member getElementById(long var1);

    @Override
    @Nullable
    default public Member getElementById(@Nonnull String id) {
        return this.getElementById(MiscUtil.parseSnowflake(id));
    }

    @Nonnull
    public @Unmodifiable List<Member> getElementsByUsername(@Nonnull String var1, boolean var2);

    @Nonnull
    default public @Unmodifiable List<Member> getElementsByUsername(@Nonnull String name) {
        return this.getElementsByUsername(name, false);
    }

    @Nonnull
    public @Unmodifiable List<Member> getElementsByNickname(@Nullable String var1, boolean var2);

    @Nonnull
    default public @Unmodifiable List<Member> getElementsByNickname(@Nullable String name) {
        return this.getElementsByNickname(name, false);
    }

    @Nonnull
    public @Unmodifiable List<Member> getElementsWithRoles(Role ... var1);

    @Nonnull
    public @Unmodifiable List<Member> getElementsWithRoles(@Nonnull Collection<Role> var1);
}

