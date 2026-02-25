/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.entities;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.UserSnowflake;
import net.dv8tion.jda.internal.utils.EntityString;

public class UserSnowflakeImpl
implements UserSnowflake {
    protected final long id;

    public UserSnowflakeImpl(long id) {
        this.id = id;
    }

    @Override
    public long getIdLong() {
        return this.id;
    }

    @Override
    @Nonnull
    public String getAsMention() {
        return "<@" + this.getId() + ">";
    }

    @Override
    @Nonnull
    public String getDefaultAvatarId() {
        return String.valueOf((this.id >> 22) % 6L);
    }

    public int hashCode() {
        return Long.hashCode(this.id);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserSnowflakeImpl)) {
            return false;
        }
        return ((UserSnowflakeImpl)obj).getIdLong() == this.id;
    }

    public String toString() {
        return new EntityString(this).toString();
    }
}

