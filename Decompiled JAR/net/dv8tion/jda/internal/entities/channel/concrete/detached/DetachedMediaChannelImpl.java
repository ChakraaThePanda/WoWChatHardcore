/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.entities.channel.concrete.detached;

import gnu.trove.map.TLongObjectMap;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.PermissionOverride;
import net.dv8tion.jda.api.entities.channel.ChannelFlag;
import net.dv8tion.jda.api.entities.channel.attribute.IPostContainer;
import net.dv8tion.jda.api.entities.channel.concrete.MediaChannel;
import net.dv8tion.jda.api.entities.channel.forums.BaseForumTag;
import net.dv8tion.jda.api.entities.channel.forums.ForumTag;
import net.dv8tion.jda.api.entities.channel.unions.GuildChannelUnion;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.entities.emoji.EmojiUnion;
import net.dv8tion.jda.api.managers.channel.concrete.MediaChannelManager;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.entities.channel.middleman.AbstractGuildChannelImpl;
import net.dv8tion.jda.internal.entities.channel.mixin.attribute.IInteractionPermissionMixin;
import net.dv8tion.jda.internal.entities.channel.mixin.concrete.MediaChannelMixin;
import net.dv8tion.jda.internal.entities.detached.DetachedGuildImpl;
import net.dv8tion.jda.internal.entities.emoji.CustomEmojiImpl;
import net.dv8tion.jda.internal.interactions.ChannelInteractionPermissions;
import net.dv8tion.jda.internal.utils.cache.SortedSnowflakeCacheViewImpl;

public class DetachedMediaChannelImpl
extends AbstractGuildChannelImpl<DetachedMediaChannelImpl>
implements MediaChannel,
GuildChannelUnion,
MediaChannelMixin<DetachedMediaChannelImpl>,
IInteractionPermissionMixin<DetachedMediaChannelImpl> {
    private ChannelInteractionPermissions interactionPermissions;
    private final SortedSnowflakeCacheViewImpl<ForumTag> tagCache = new SortedSnowflakeCacheViewImpl<ForumTag>(ForumTag.class, BaseForumTag::getName, Comparator.naturalOrder());
    private Emoji defaultReaction;
    private String topic;
    private long parentCategoryId;
    private boolean nsfw = false;
    private int position;
    private int flags;
    private int slowmode;
    private int defaultSortOrder;
    protected int defaultThreadSlowmode;

    public DetachedMediaChannelImpl(long id, DetachedGuildImpl guild) {
        super(id, guild);
    }

    @Override
    public boolean isDetached() {
        return true;
    }

    @Override
    @Nonnull
    public MediaChannelManager getManager() {
        throw this.detachedException();
    }

    @Override
    @Nonnull
    public List<Member> getMembers() {
        throw this.detachedException();
    }

    @Override
    @Nonnull
    public EnumSet<ChannelFlag> getFlags() {
        return ChannelFlag.fromRaw(this.flags);
    }

    @Override
    @Nonnull
    public SortedSnowflakeCacheViewImpl<ForumTag> getAvailableTagCache() {
        return this.tagCache;
    }

    @Override
    public TLongObjectMap<PermissionOverride> getPermissionOverrideMap() {
        throw this.detachedException();
    }

    @Override
    @Nonnull
    public ChannelInteractionPermissions getInteractionPermissions() {
        return this.interactionPermissions;
    }

    @Override
    public boolean isNSFW() {
        return this.nsfw;
    }

    @Override
    public int getPositionRaw() {
        return this.position;
    }

    @Override
    public long getParentCategoryIdLong() {
        return this.parentCategoryId;
    }

    @Override
    public int getSlowmode() {
        return this.slowmode;
    }

    @Override
    public String getTopic() {
        return this.topic;
    }

    @Override
    public EmojiUnion getDefaultReaction() {
        return (EmojiUnion)this.defaultReaction;
    }

    @Override
    public int getDefaultThreadSlowmode() {
        return this.defaultThreadSlowmode;
    }

    @Override
    @Nonnull
    public IPostContainer.SortOrder getDefaultSortOrder() {
        return IPostContainer.SortOrder.fromKey(this.defaultSortOrder);
    }

    @Override
    public int getRawFlags() {
        return this.flags;
    }

    @Override
    public int getRawSortOrder() {
        return this.defaultSortOrder;
    }

    @Override
    public DetachedMediaChannelImpl setParentCategory(long parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
        return this;
    }

    @Override
    public DetachedMediaChannelImpl setPosition(int position) {
        this.position = position;
        return this;
    }

    @Override
    public DetachedMediaChannelImpl setDefaultThreadSlowmode(int defaultThreadSlowmode) {
        this.defaultThreadSlowmode = defaultThreadSlowmode;
        return this;
    }

    @Override
    public DetachedMediaChannelImpl setNSFW(boolean nsfw) {
        this.nsfw = nsfw;
        return this;
    }

    @Override
    public DetachedMediaChannelImpl setSlowmode(int slowmode) {
        this.slowmode = slowmode;
        return this;
    }

    @Override
    public DetachedMediaChannelImpl setTopic(String topic) {
        this.topic = topic;
        return this;
    }

    @Override
    public DetachedMediaChannelImpl setFlags(int flags) {
        this.flags = flags;
        return this;
    }

    @Override
    public DetachedMediaChannelImpl setDefaultReaction(DataObject emoji) {
        this.defaultReaction = emoji != null && !emoji.isNull("emoji_id") ? new CustomEmojiImpl("", emoji.getUnsignedLong("emoji_id"), false) : (emoji != null && !emoji.isNull("emoji_name") ? Emoji.fromUnicode(emoji.getString("emoji_name")) : null);
        return this;
    }

    @Override
    public DetachedMediaChannelImpl setDefaultSortOrder(int defaultSortOrder) {
        this.defaultSortOrder = defaultSortOrder;
        return this;
    }

    @Override
    @Nonnull
    public DetachedMediaChannelImpl setInteractionPermissions(@Nonnull ChannelInteractionPermissions interactionPermissions) {
        this.interactionPermissions = interactionPermissions;
        return this;
    }
}

