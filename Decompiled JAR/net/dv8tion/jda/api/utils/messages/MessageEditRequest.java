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
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.interactions.components.LayoutComponent;
import net.dv8tion.jda.api.utils.AttachedFile;
import net.dv8tion.jda.api.utils.FileUpload;
import net.dv8tion.jda.api.utils.messages.MessageCreateData;
import net.dv8tion.jda.api.utils.messages.MessageEditData;
import net.dv8tion.jda.api.utils.messages.MessageRequest;
import net.dv8tion.jda.internal.utils.Checks;

public interface MessageEditRequest<R extends MessageEditRequest<R>>
extends MessageRequest<R> {
    @Nonnull
    public R setAttachments(@Nullable Collection<? extends AttachedFile> var1);

    @Nonnull
    default public R setAttachments(AttachedFile ... attachments) {
        Checks.noneNull(attachments, "Attachments");
        return this.setAttachments(Arrays.asList(attachments));
    }

    @Override
    @Nonnull
    default public R setFiles(@Nullable Collection<? extends FileUpload> files2) {
        return this.setAttachments(files2);
    }

    @Nonnull
    public R setReplace(boolean var1);

    public boolean isReplace();

    @Nonnull
    public R applyData(@Nonnull MessageEditData var1);

    @Nonnull
    default public R applyCreateData(@Nonnull MessageCreateData data) {
        List layoutComponents = data.getComponents().stream().map(LayoutComponent::createCopy).collect(Collectors.toList());
        return (R)((MessageEditRequest)((MessageEditRequest)((MessageEditRequest)((MessageEditRequest)((MessageEditRequest)((MessageEditRequest)((MessageEditRequest)this.setReplace(true).setContent(data.getContent())).setAllowedMentions(data.getAllowedMentions())).mentionUsers(data.getMentionedUsers())).mentionRoles(data.getMentionedRoles())).mentionRepliedUser(data.isMentionRepliedUser())).setEmbeds(data.getEmbeds())).setComponents(layoutComponents)).setFiles(data.getFiles());
    }

    @Override
    @Nonnull
    default public R applyMessage(@Nonnull Message message) {
        Checks.notNull(message, "Message");
        Checks.check(!message.getType().isSystem(), "Cannot copy a system message");
        return this.applyCreateData(MessageCreateData.fromMessage(message));
    }
}

