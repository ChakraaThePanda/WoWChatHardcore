/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.utils.messages;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.EmbedType;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.ItemComponent;
import net.dv8tion.jda.api.interactions.components.LayoutComponent;
import net.dv8tion.jda.api.utils.FileUpload;
import net.dv8tion.jda.api.utils.messages.MessageCreateData;
import net.dv8tion.jda.api.utils.messages.MessageEditData;
import net.dv8tion.jda.api.utils.messages.MessagePollData;
import net.dv8tion.jda.api.utils.messages.MessageRequest;
import net.dv8tion.jda.internal.utils.Checks;

public interface MessageCreateRequest<R extends MessageCreateRequest<R>>
extends MessageRequest<R> {
    @Nonnull
    public R addContent(@Nonnull String var1);

    @Nonnull
    public R addEmbeds(@Nonnull Collection<? extends MessageEmbed> var1);

    @Nonnull
    default public R addEmbeds(MessageEmbed ... embeds) {
        return this.addEmbeds(Arrays.asList(embeds));
    }

    @Nonnull
    public R addComponents(@Nonnull Collection<? extends LayoutComponent> var1);

    @Nonnull
    default public R addComponents(LayoutComponent ... components) {
        return this.addComponents(Arrays.asList(components));
    }

    @Nonnull
    default public R addActionRow(@Nonnull Collection<? extends ItemComponent> components) {
        return this.addComponents(ActionRow.of(components));
    }

    @Nonnull
    default public R addActionRow(ItemComponent ... components) {
        return this.addComponents(ActionRow.of(components));
    }

    @Nonnull
    public R addFiles(@Nonnull Collection<? extends FileUpload> var1);

    @Nonnull
    default public R addFiles(FileUpload ... files2) {
        return this.addFiles(Arrays.asList(files2));
    }

    @Nonnull
    public List<FileUpload> getAttachments();

    @Nullable
    public MessagePollData getPoll();

    @Nonnull
    public R setPoll(@Nullable MessagePollData var1);

    @Nonnull
    public R setTTS(boolean var1);

    @Nonnull
    public R setSuppressedNotifications(boolean var1);

    @Nonnull
    public R setVoiceMessage(boolean var1);

    @Nonnull
    default public R applyData(@Nonnull MessageCreateData data) {
        Checks.notNull(data, "MessageCreateData");
        List layoutComponents = data.getComponents().stream().map(LayoutComponent::createCopy).collect(Collectors.toList());
        return (R)((MessageCreateRequest)((MessageCreateRequest)((MessageCreateRequest)((MessageCreateRequest)((MessageCreateRequest)((MessageCreateRequest)((MessageCreateRequest)((MessageCreateRequest)((MessageCreateRequest)this.setContent(data.getContent())).setAllowedMentions(data.getAllowedMentions())).mentionUsers(data.getMentionedUsers())).mentionRoles(data.getMentionedRoles())).mentionRepliedUser(data.isMentionRepliedUser())).setEmbeds(data.getEmbeds())).setTTS(data.isTTS()).setSuppressEmbeds(data.isSuppressEmbeds())).setSuppressedNotifications(data.isSuppressedNotifications()).setVoiceMessage(data.isVoiceMessage()).setComponents(layoutComponents)).setPoll(data.getPoll()).setFiles(data.getFiles()));
    }

    @Override
    @Nonnull
    default public R applyMessage(@Nonnull Message message) {
        Checks.notNull(message, "Message");
        Checks.check(!message.getType().isSystem(), "Cannot copy a system message");
        List embeds = message.getEmbeds().stream().filter(e -> e.getType() == EmbedType.RICH).collect(Collectors.toList());
        return ((MessageCreateRequest)((MessageCreateRequest)((MessageCreateRequest)this.setContent(message.getContentRaw())).setEmbeds(embeds)).setTTS(message.isTTS()).setSuppressedNotifications(message.isSuppressedNotifications()).setVoiceMessage(message.isVoiceMessage()).setComponents(message.getActionRows())).setPoll(message.getPoll() != null ? MessagePollData.from(message.getPoll()) : null);
    }

    @Nonnull
    default public R applyEditData(@Nonnull MessageEditData data) {
        Checks.notNull(data, "MessageEditData");
        if (data.isSet(1)) {
            this.setContent(data.getContent());
        }
        if (data.isSet(2)) {
            this.setEmbeds(data.getEmbeds());
        }
        if (data.isSet(4)) {
            List layoutComponents = data.getComponents().stream().map(LayoutComponent::createCopy).collect(Collectors.toList());
            this.setComponents(layoutComponents);
        }
        if (data.isSet(8)) {
            this.setFiles(data.getFiles());
        }
        if (data.isSet(16)) {
            this.setAllowedMentions(data.getAllowedMentions());
            this.mentionUsers(data.getMentionedUsers());
            this.mentionRoles(data.getMentionedRoles());
            this.mentionRepliedUser(data.isMentionRepliedUser());
        }
        return (R)this;
    }
}

