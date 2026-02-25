/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.utils.message;

import java.util.Collection;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.utils.AttachedFile;
import net.dv8tion.jda.api.utils.FileUpload;
import net.dv8tion.jda.api.utils.messages.MessageEditBuilder;
import net.dv8tion.jda.api.utils.messages.MessageEditData;
import net.dv8tion.jda.api.utils.messages.MessageEditRequest;
import net.dv8tion.jda.internal.utils.message.AbstractMessageBuilderMixin;

public interface MessageEditBuilderMixin<R extends MessageEditRequest<R>>
extends AbstractMessageBuilderMixin<R, MessageEditBuilder>,
MessageEditRequest<R> {
    @Override
    @Nonnull
    default public R setAttachments(@Nullable Collection<? extends AttachedFile> attachments) {
        ((MessageEditBuilder)this.getBuilder()).setAttachments((Collection)attachments);
        return (R)this;
    }

    @Override
    @Nonnull
    default public R setReplace(boolean isReplace) {
        ((MessageEditBuilder)this.getBuilder()).setReplace(isReplace);
        return (R)this;
    }

    @Override
    @Nonnull
    default public R setFiles(@Nullable Collection<? extends FileUpload> files2) {
        ((MessageEditBuilder)this.getBuilder()).setFiles(files2);
        return (R)this;
    }

    @Override
    @Nonnull
    default public R applyData(@Nonnull MessageEditData data) {
        ((MessageEditBuilder)this.getBuilder()).applyData(data);
        return (R)this;
    }

    @Override
    default public boolean isReplace() {
        return ((MessageEditBuilder)this.getBuilder()).isReplace();
    }
}

