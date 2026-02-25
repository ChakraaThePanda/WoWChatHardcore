/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities;

import java.util.List;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.ISnowflake;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.entities.channel.middleman.StandardGuildChannel;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.entities.emoji.EmojiUnion;
import net.dv8tion.jda.api.managers.GuildWelcomeScreenManager;
import net.dv8tion.jda.api.utils.data.SerializableData;
import net.dv8tion.jda.internal.entities.GuildWelcomeScreenImpl;
import net.dv8tion.jda.internal.utils.Checks;

public interface GuildWelcomeScreen {
    public static final int MAX_DESCRIPTION_LENGTH = 140;
    public static final int MAX_WELCOME_CHANNELS = 5;

    @Nullable
    public Guild getGuild();

    @Nonnull
    @CheckReturnValue
    public GuildWelcomeScreenManager getManager();

    @Nullable
    public String getDescription();

    @Nonnull
    public List<Channel> getChannels();

    public static interface Channel
    extends ISnowflake,
    SerializableData {
        public static final int MAX_DESCRIPTION_LENGTH = 42;

        @Nonnull
        public static Channel of(@Nonnull StandardGuildChannel channel, @Nonnull String description) {
            return Channel.of(channel, description, null);
        }

        @Nonnull
        public static Channel of(@Nonnull StandardGuildChannel channel, @Nonnull String description, @Nullable Emoji emoji) {
            Checks.notNull(channel, "Channel");
            Checks.notBlank(description, "Description");
            Checks.notLonger(description, 42, "Description");
            return new GuildWelcomeScreenImpl.ChannelImpl(channel.getGuild(), channel.getIdLong(), description, (EmojiUnion)emoji);
        }

        @Nullable
        public Guild getGuild();

        @Override
        public long getIdLong();

        @Nullable
        public GuildChannel getChannel();

        @Nonnull
        public String getDescription();

        @Nullable
        public EmojiUnion getEmoji();
    }
}

