/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities.channel.middleman;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.ISnowflake;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.entities.sticker.StickerSnowflake;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.requests.restaction.MessageCreateAction;
import net.dv8tion.jda.internal.utils.Checks;

public interface GuildMessageChannel
extends GuildChannel,
MessageChannel {
    @Override
    default public boolean canTalk() {
        return this.canTalk(this.getGuild().getSelfMember());
    }

    public boolean canTalk(@Nonnull Member var1);

    @Nonnull
    @CheckReturnValue
    public RestAction<Void> removeReactionById(@Nonnull String var1, @Nonnull Emoji var2, @Nonnull User var3);

    @Nonnull
    @CheckReturnValue
    default public RestAction<Void> removeReactionById(long messageId, @Nonnull Emoji emoji, @Nonnull User user) {
        return this.removeReactionById(Long.toUnsignedString(messageId), emoji, user);
    }

    @Nonnull
    @CheckReturnValue
    default public RestAction<Void> deleteMessages(@Nonnull Collection<Message> messages) {
        Checks.notEmpty(messages, "Messages collection");
        return this.deleteMessagesByIds(messages.stream().map(ISnowflake::getId).collect(Collectors.toList()));
    }

    @Nonnull
    @CheckReturnValue
    public RestAction<Void> deleteMessagesByIds(@Nonnull Collection<String> var1);

    @Nonnull
    @CheckReturnValue
    public RestAction<Void> clearReactionsById(@Nonnull String var1);

    @Nonnull
    @CheckReturnValue
    default public RestAction<Void> clearReactionsById(long messageId) {
        return this.clearReactionsById(Long.toUnsignedString(messageId));
    }

    @Nonnull
    @CheckReturnValue
    public RestAction<Void> clearReactionsById(@Nonnull String var1, @Nonnull Emoji var2);

    @Nonnull
    @CheckReturnValue
    default public RestAction<Void> clearReactionsById(long messageId, @Nonnull Emoji emoji) {
        return this.clearReactionsById(Long.toUnsignedString(messageId), emoji);
    }

    @Nonnull
    @CheckReturnValue
    public MessageCreateAction sendStickers(@Nonnull Collection<? extends StickerSnowflake> var1);

    @Nonnull
    @CheckReturnValue
    default public MessageCreateAction sendStickers(StickerSnowflake ... stickers) {
        Checks.notEmpty(stickers, "Stickers");
        return this.sendStickers(Arrays.asList(stickers));
    }
}

