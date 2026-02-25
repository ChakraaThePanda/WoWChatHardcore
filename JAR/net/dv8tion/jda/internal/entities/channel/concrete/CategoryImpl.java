/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.entities.channel.concrete;

import gnu.trove.map.TLongObjectMap;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.PermissionOverride;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.concrete.Category;
import net.dv8tion.jda.api.entities.channel.concrete.ForumChannel;
import net.dv8tion.jda.api.entities.channel.concrete.MediaChannel;
import net.dv8tion.jda.api.entities.channel.concrete.NewsChannel;
import net.dv8tion.jda.api.entities.channel.concrete.StageChannel;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.managers.channel.concrete.CategoryManager;
import net.dv8tion.jda.api.requests.restaction.ChannelAction;
import net.dv8tion.jda.api.requests.restaction.order.CategoryOrderAction;
import net.dv8tion.jda.api.utils.MiscUtil;
import net.dv8tion.jda.internal.entities.GuildImpl;
import net.dv8tion.jda.internal.entities.channel.middleman.AbstractGuildChannelImpl;
import net.dv8tion.jda.internal.entities.channel.mixin.concrete.CategoryMixin;
import net.dv8tion.jda.internal.managers.channel.concrete.CategoryManagerImpl;
import net.dv8tion.jda.internal.utils.PermissionUtil;

public class CategoryImpl
extends AbstractGuildChannelImpl<CategoryImpl>
implements Category,
CategoryMixin<CategoryImpl> {
    private final TLongObjectMap<PermissionOverride> overrides = MiscUtil.newLongMap();
    private int position;

    public CategoryImpl(long id, GuildImpl guild) {
        super(id, guild);
    }

    @Override
    public boolean isDetached() {
        return false;
    }

    @Override
    @Nonnull
    public GuildImpl getGuild() {
        return (GuildImpl)super.getGuild();
    }

    @Override
    @Nonnull
    public ChannelType getType() {
        return ChannelType.CATEGORY;
    }

    @Override
    public int getPositionRaw() {
        return this.position;
    }

    @Override
    @Nonnull
    public ChannelAction<TextChannel> createTextChannel(@Nonnull String name) {
        ChannelAction<TextChannel> action = this.getGuild().createTextChannel(name, this);
        return this.trySync(action);
    }

    @Override
    @Nonnull
    public ChannelAction<NewsChannel> createNewsChannel(@Nonnull String name) {
        ChannelAction<NewsChannel> action = this.getGuild().createNewsChannel(name, this);
        return this.trySync(action);
    }

    @Override
    @Nonnull
    public ChannelAction<VoiceChannel> createVoiceChannel(@Nonnull String name) {
        ChannelAction<VoiceChannel> action = this.getGuild().createVoiceChannel(name, this);
        return this.trySync(action);
    }

    @Override
    @Nonnull
    public ChannelAction<StageChannel> createStageChannel(@Nonnull String name) {
        ChannelAction<StageChannel> action = this.getGuild().createStageChannel(name, this);
        return this.trySync(action);
    }

    @Override
    @Nonnull
    public ChannelAction<ForumChannel> createForumChannel(@Nonnull String name) {
        ChannelAction<ForumChannel> action = this.getGuild().createForumChannel(name, this);
        return this.trySync(action);
    }

    @Override
    @Nonnull
    public ChannelAction<MediaChannel> createMediaChannel(@Nonnull String name) {
        ChannelAction<MediaChannel> action = this.getGuild().createMediaChannel(name, this);
        return this.trySync(action);
    }

    @Override
    @Nonnull
    public CategoryOrderAction modifyTextChannelPositions() {
        return this.getGuild().modifyTextChannelPositions(this);
    }

    @Override
    @Nonnull
    public CategoryOrderAction modifyVoiceChannelPositions() {
        return this.getGuild().modifyVoiceChannelPositions(this);
    }

    @Override
    @Nonnull
    public ChannelAction<Category> createCopy() {
        return this.createCopy(this.getGuild());
    }

    @Override
    @Nonnull
    public CategoryManager getManager() {
        return new CategoryManagerImpl(this);
    }

    @Override
    public TLongObjectMap<PermissionOverride> getPermissionOverrideMap() {
        return this.overrides;
    }

    @Override
    public CategoryImpl setPosition(int position) {
        this.position = position;
        return this;
    }

    private <T extends GuildChannel> ChannelAction<T> trySync(ChannelAction<T> action) {
        Member selfMember = this.getGuild().getSelfMember();
        if (!selfMember.canSync(this)) {
            long botPerms = PermissionUtil.getEffectivePermission((GuildChannel)this, selfMember);
            for (PermissionOverride override : this.getPermissionOverrides()) {
                long perms = override.getDeniedRaw() | override.getAllowedRaw();
                if ((perms & (botPerms ^ 0xFFFFFFFFFFFFFFFFL)) == 0L) continue;
                return action;
            }
        }
        return action.syncPermissionOverrides();
    }
}

