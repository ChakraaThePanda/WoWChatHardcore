/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.managers.channel.attribute;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.channel.attribute.ICategorizableChannel;
import net.dv8tion.jda.api.entities.channel.attribute.IPermissionContainer;
import net.dv8tion.jda.api.entities.channel.concrete.Category;
import net.dv8tion.jda.api.managers.channel.ChannelManager;
import net.dv8tion.jda.api.managers.channel.attribute.IPermissionContainerManager;
import net.dv8tion.jda.api.managers.channel.attribute.IPositionableChannelManager;

public interface ICategorizableChannelManager<T extends ICategorizableChannel, M extends ICategorizableChannelManager<T, M>>
extends ChannelManager<T, M>,
IPermissionContainerManager<T, M>,
IPositionableChannelManager<T, M> {
    @Nonnull
    @CheckReturnValue
    public M setParent(@Nullable Category var1);

    @Nonnull
    @CheckReturnValue
    default public M sync() {
        if (!(this.getChannel() instanceof ICategorizableChannel)) {
            throw new IllegalStateException("sync() requires that the channel be categorizable as it syncs the channel to the parent category.");
        }
        ICategorizableChannel categorizableChannel = (ICategorizableChannel)this.getChannel();
        if (categorizableChannel.getParentCategory() == null) {
            throw new IllegalStateException("sync() requires a parent category");
        }
        return this.sync(categorizableChannel.getParentCategory());
    }

    @Nonnull
    @CheckReturnValue
    public M sync(@Nonnull IPermissionContainer var1);
}

