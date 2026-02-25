/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.entities.channel.middleman;

import gnu.trove.map.TLongObjectMap;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.PermissionOverride;
import net.dv8tion.jda.api.utils.MiscUtil;
import net.dv8tion.jda.internal.entities.GuildImpl;
import net.dv8tion.jda.internal.entities.channel.middleman.AbstractGuildChannelImpl;
import net.dv8tion.jda.internal.entities.channel.mixin.middleman.StandardGuildChannelMixin;

public abstract class AbstractStandardGuildChannelImpl<T extends AbstractStandardGuildChannelImpl<T>>
extends AbstractGuildChannelImpl<T>
implements StandardGuildChannelMixin<T> {
    protected final TLongObjectMap<PermissionOverride> overrides = MiscUtil.newLongMap();
    protected long parentCategoryId;
    protected int position;

    public AbstractStandardGuildChannelImpl(long id, Guild guild) {
        super(id, guild);
    }

    @Override
    public long getParentCategoryIdLong() {
        return this.parentCategoryId;
    }

    @Override
    public int getPositionRaw() {
        return this.position;
    }

    @Override
    public TLongObjectMap<PermissionOverride> getPermissionOverrideMap() {
        return this.overrides;
    }

    @Override
    public T setParentCategory(long parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
        return (T)this;
    }

    @Override
    public T setPosition(int position) {
        this.onPositionChange();
        this.position = position;
        return (T)this;
    }

    protected final void onPositionChange() {
        if (!this.isDetached()) {
            ((GuildImpl)this.getGuild()).getChannelView().clearCachedLists();
        }
    }
}

