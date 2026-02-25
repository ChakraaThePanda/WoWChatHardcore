/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.entities.detached.mixin;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.detached.IDetachableEntity;
import net.dv8tion.jda.api.exceptions.DetachedEntityException;

public interface IDetachableEntityMixin
extends IDetachableEntity {
    default public void checkAttached() {
        if (this.isDetached()) {
            throw this.detachedException();
        }
    }

    @Nonnull
    default public DetachedEntityException detachedException() {
        return new DetachedEntityException();
    }

    @Nonnull
    default public DetachedEntityException detachedRequiresChannelException() {
        return new DetachedEntityException("Getting/checking permissions requires a GuildChannel");
    }
}

