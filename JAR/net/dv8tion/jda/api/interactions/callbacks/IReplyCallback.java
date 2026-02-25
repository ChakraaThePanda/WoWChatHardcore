/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.interactions.callbacks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.interactions.callbacks.IDeferrableCallback;
import net.dv8tion.jda.api.interactions.components.LayoutComponent;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;
import net.dv8tion.jda.api.utils.FileUpload;
import net.dv8tion.jda.api.utils.messages.MessageCreateData;
import net.dv8tion.jda.api.utils.messages.MessagePollData;
import net.dv8tion.jda.internal.requests.restaction.interactions.ReplyCallbackActionImpl;
import net.dv8tion.jda.internal.utils.Checks;

public interface IReplyCallback
extends IDeferrableCallback {
    @Nonnull
    @CheckReturnValue
    public ReplyCallbackAction deferReply();

    @Nonnull
    @CheckReturnValue
    default public ReplyCallbackAction deferReply(boolean ephemeral) {
        return this.deferReply().setEphemeral(ephemeral);
    }

    @Nonnull
    @CheckReturnValue
    default public ReplyCallbackAction reply(@Nonnull MessageCreateData message) {
        Checks.notNull(message, "Message");
        ReplyCallbackActionImpl action = (ReplyCallbackActionImpl)this.deferReply();
        return (ReplyCallbackAction)action.applyData(message);
    }

    @Nonnull
    @CheckReturnValue
    default public ReplyCallbackAction replyPoll(@Nonnull MessagePollData poll) {
        Checks.notNull(poll, "Message Poll");
        return (ReplyCallbackAction)this.deferReply().setPoll(poll);
    }

    @Nonnull
    @CheckReturnValue
    default public ReplyCallbackAction reply(@Nonnull String content) {
        Checks.notNull(content, "Content");
        return (ReplyCallbackAction)this.deferReply().setContent(content);
    }

    @Nonnull
    @CheckReturnValue
    default public ReplyCallbackAction replyEmbeds(@Nonnull Collection<? extends MessageEmbed> embeds) {
        return (ReplyCallbackAction)this.deferReply().addEmbeds(embeds);
    }

    @Nonnull
    @CheckReturnValue
    default public ReplyCallbackAction replyEmbeds(@Nonnull MessageEmbed embed, MessageEmbed ... embeds) {
        Checks.notNull(embed, "MessageEmbed");
        Checks.noneNull(embeds, "MessageEmbed");
        return (ReplyCallbackAction)((ReplyCallbackAction)this.deferReply().addEmbeds(embed)).addEmbeds(embeds);
    }

    @Nonnull
    @CheckReturnValue
    default public ReplyCallbackAction replyComponents(@Nonnull Collection<? extends LayoutComponent> components) {
        return (ReplyCallbackAction)this.deferReply().setComponents(components);
    }

    @Nonnull
    @CheckReturnValue
    default public ReplyCallbackAction replyComponents(@Nonnull LayoutComponent component, LayoutComponent ... other) {
        Checks.notNull(component, "LayoutComponents");
        Checks.noneNull(other, "LayoutComponents");
        ArrayList<LayoutComponent> layouts = new ArrayList<LayoutComponent>(1 + other.length);
        layouts.add(component);
        Collections.addAll(layouts, other);
        return this.replyComponents(layouts);
    }

    @Nonnull
    @CheckReturnValue
    default public ReplyCallbackAction replyFormat(@Nonnull String format, Object ... args2) {
        Checks.notNull(format, "Format String");
        return this.reply(String.format(format, args2));
    }

    @Nonnull
    @CheckReturnValue
    default public ReplyCallbackAction replyFiles(@Nonnull Collection<? extends FileUpload> files2) {
        Checks.notEmpty(files2, "File Collection");
        return (ReplyCallbackAction)this.deferReply().setFiles(files2);
    }

    @Nonnull
    @CheckReturnValue
    default public ReplyCallbackAction replyFiles(FileUpload ... files2) {
        Checks.notEmpty(files2, "File Collection");
        Checks.noneNull(files2, "FileUpload");
        return (ReplyCallbackAction)this.deferReply().setFiles(files2);
    }
}

