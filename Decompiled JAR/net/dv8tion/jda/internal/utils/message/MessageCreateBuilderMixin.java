/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.utils.message;

import java.util.Collection;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.interactions.components.LayoutComponent;
import net.dv8tion.jda.api.utils.FileUpload;
import net.dv8tion.jda.api.utils.messages.MessageCreateBuilder;
import net.dv8tion.jda.api.utils.messages.MessageCreateRequest;
import net.dv8tion.jda.api.utils.messages.MessagePollData;
import net.dv8tion.jda.internal.utils.message.AbstractMessageBuilderMixin;

public interface MessageCreateBuilderMixin<R extends MessageCreateRequest<R>>
extends AbstractMessageBuilderMixin<R, MessageCreateBuilder>,
MessageCreateRequest<R> {
    @Override
    @Nonnull
    default public R addContent(@Nonnull String content) {
        ((MessageCreateBuilder)this.getBuilder()).addContent(content);
        return (R)this;
    }

    @Override
    @Nonnull
    default public R addEmbeds(@Nonnull Collection<? extends MessageEmbed> embeds) {
        ((MessageCreateBuilder)this.getBuilder()).addEmbeds((Collection)embeds);
        return (R)this;
    }

    @Override
    @Nonnull
    default public R addComponents(@Nonnull Collection<? extends LayoutComponent> components) {
        ((MessageCreateBuilder)this.getBuilder()).addComponents((Collection)components);
        return (R)this;
    }

    @Override
    @Nonnull
    default public R addFiles(@Nonnull Collection<? extends FileUpload> files2) {
        ((MessageCreateBuilder)this.getBuilder()).addFiles((Collection)files2);
        return (R)this;
    }

    @Override
    @Nullable
    default public MessagePollData getPoll() {
        return ((MessageCreateBuilder)this.getBuilder()).getPoll();
    }

    @Override
    @Nonnull
    default public R setPoll(@Nullable MessagePollData poll) {
        ((MessageCreateBuilder)this.getBuilder()).setPoll(poll);
        return (R)this;
    }

    @Override
    @Nonnull
    default public R setTTS(boolean tts) {
        ((MessageCreateBuilder)this.getBuilder()).setTTS(tts);
        return (R)this;
    }

    @Override
    @Nonnull
    default public R setFiles(@Nullable Collection<? extends FileUpload> files2) {
        ((MessageCreateBuilder)this.getBuilder()).setFiles((Collection)files2);
        return (R)this;
    }

    @Override
    @Nonnull
    default public List<FileUpload> getAttachments() {
        return ((MessageCreateBuilder)this.getBuilder()).getAttachments();
    }

    @Override
    @Nonnull
    default public R setSuppressedNotifications(boolean suppressed) {
        ((MessageCreateBuilder)this.getBuilder()).setSuppressedNotifications(suppressed);
        return (R)this;
    }

    @Override
    @Nonnull
    default public R setVoiceMessage(boolean voiceMessage) {
        ((MessageCreateBuilder)this.getBuilder()).setVoiceMessage(voiceMessage);
        return (R)this;
    }
}

