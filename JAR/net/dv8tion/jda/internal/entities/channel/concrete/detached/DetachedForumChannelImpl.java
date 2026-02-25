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
import net.dv8tion.jda.api.entities.channel.concrete.ForumChannel;
import net.dv8tion.jda.api.entities.channel.forums.BaseForumTag;
import net.dv8tion.jda.api.entities.channel.forums.ForumTag;
import net.dv8tion.jda.api.entities.channel.unions.GuildChannelUnion;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.entities.emoji.EmojiUnion;
import net.dv8tion.jda.api.managers.channel.concrete.ForumChannelManager;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.entities.channel.middleman.AbstractGuildChannelImpl;
import net.dv8tion.jda.internal.entities.channel.mixin.attribute.IInteractionPermissionMixin;
import net.dv8tion.jda.internal.entities.channel.mixin.concrete.ForumChannelMixin;
import net.dv8tion.jda.internal.entities.detached.DetachedGuildImpl;
import net.dv8tion.jda.internal.entities.emoji.CustomEmojiImpl;
import net.dv8tion.jda.internal.interactions.ChannelInteractionPermissions;
import net.dv8tion.jda.internal.utils.cache.SortedSnowflakeCacheViewImpl;

public class DetachedForumChannelImpl
extends AbstractGuildChannelImpl<DetachedForumChannelImpl>
implements ForumChannel,
GuildChannelUnion,
ForumChannelMixin<DetachedForumChannelImpl>,
IInteractionPermissionMixin<DetachedForumChannelImpl> {
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
    private int defaultLayout;
    protected int defaultThreadSlowmode;

    public DetachedForumChannelImpl(long id, DetachedGuildImpl guild) {
        super(id, guild);
    }

    @Override
    public boolean isDetached() {
        return true;
    }

    @Override
    @Nonnull
    public ForumChannelManager getManager() {
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
    @Nonnull
    public ForumChannel.Layout getDefaultLayout() {
        return ForumChannel.Layout.fromKey(this.defaultLayout);
    }

    @Override
    public int getRawFlags() {
        return this.flags;
    }

    @Override
    public int getRawSortOrder() {
        return this.defaultSortOrder;
    }

    public int getRawLayout() {
        return this.defaultLayout;
    }

    @Override
    public DetachedForumChannelImpl setParentCategory(long parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
        return this;
    }

    @Override
    public DetachedForumChannelImpl setPosition(int position) {
        this.position = position;
        return this;
    }

    @Override
    public DetachedForumChannelImpl setDefaultThreadSlowmode(int defaultThreadSlowmode) {
        this.defaultThreadSlowmode = defaultThreadSlowmode;
        return this;
    }

    @Override
    public DetachedForumChannelImpl setNSFW(boolean nsfw) {
        this.nsfw = nsfw;
        return this;
    }

    @Override
    public DetachedForumChannelImpl setSlowmode(int slowmode) {
        this.slowmode = slowmode;
        return this;
    }

    @Override
    public DetachedForumChannelImpl setTopic(String topic) {
        this.topic = topic;
        return this;
    }

    @Override
    public DetachedForumChannelImpl setFlags(int flags) {
        this.flags = flags;
        return this;
    }

    @Override
    public DetachedForumChannelImpl setDefaultReaction(DataObject emoji) {
        this.defaultReaction = emoji != null && !emoji.isNull("emoji_id") ? new CustomEmojiImpl("", emoji.getUnsignedLong("emoji_id"), false) : (emoji != null && !emoji.isNull("emoji_name") ? Emoji.fromUnicode(emoji.getString("emoji_name")) : null);
        return this;
    }

    @Override
    public DetachedForumChannelImpl setDefaultSortOrder(int defaultSortOrder) {
        this.defaultSortOrder = defaultSortOrder;
        return this;
    }

    @Override
    public DetachedForumChannelImpl setDefaultLayout(int layout) {
        this.defaultLayout = layout;
        return this;
    }

    @Override
    @Nonnull
    public DetachedForumChannelImpl setInteractionPermissions(@Nonnull ChannelInteractionPermissions interactionPermissions) {
        this.interactionPermissions = interactionPermissions;
        return this;
    }
}

