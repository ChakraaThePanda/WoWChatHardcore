/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.utils.messages;

import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.IMentionable;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.ItemComponent;
import net.dv8tion.jda.api.interactions.components.LayoutComponent;
import net.dv8tion.jda.api.utils.FileUpload;
import net.dv8tion.jda.api.utils.messages.AllowedMentionsData;
import net.dv8tion.jda.api.utils.messages.MessageData;
import net.dv8tion.jda.internal.utils.Checks;

public interface MessageRequest<R extends MessageRequest<R>>
extends MessageData {
    public static void setDefaultMentions(@Nullable Collection<Message.MentionType> allowedMentions) {
        AllowedMentionsData.setDefaultMentions(allowedMentions);
    }

    @Nonnull
    public static EnumSet<Message.MentionType> getDefaultMentions() {
        return AllowedMentionsData.getDefaultMentions();
    }

    public static void setDefaultMentionRepliedUser(boolean mention) {
        AllowedMentionsData.setDefaultMentionRepliedUser(mention);
    }

    public static boolean isDefaultMentionRepliedUser() {
        return AllowedMentionsData.isDefaultMentionRepliedUser();
    }

    @Nonnull
    public R setContent(@Nullable String var1);

    @Nonnull
    public R setEmbeds(@Nonnull Collection<? extends MessageEmbed> var1);

    @Nonnull
    default public R setEmbeds(MessageEmbed ... embeds) {
        return this.setEmbeds(Arrays.asList(embeds));
    }

    @Nonnull
    public R setComponents(@Nonnull Collection<? extends LayoutComponent> var1);

    @Nonnull
    default public R setComponents(LayoutComponent ... components) {
        return this.setComponents(Arrays.asList(components));
    }

    @Nonnull
    default public R setActionRow(@Nonnull Collection<? extends ItemComponent> components) {
        return this.setComponents(ActionRow.of(components));
    }

    @Nonnull
    default public R setActionRow(ItemComponent ... components) {
        return this.setComponents(ActionRow.of(components));
    }

    @Nonnull
    public R setSuppressEmbeds(boolean var1);

    @Nonnull
    public R setFiles(@Nullable Collection<? extends FileUpload> var1);

    @Nonnull
    default public R setFiles(FileUpload ... files2) {
        Checks.noneNull(files2, "Files");
        return this.setFiles(Arrays.asList(files2));
    }

    @Nonnull
    @CheckReturnValue
    public R mentionRepliedUser(boolean var1);

    @Nonnull
    @CheckReturnValue
    public R setAllowedMentions(@Nullable Collection<Message.MentionType> var1);

    @Nonnull
    @CheckReturnValue
    public R mention(@Nonnull Collection<? extends IMentionable> var1);

    @Nonnull
    @CheckReturnValue
    default public R mention(IMentionable ... mentions) {
        Checks.notNull(mentions, "Mentions");
        return this.mention(Arrays.asList(mentions));
    }

    @Nonnull
    @CheckReturnValue
    public R mentionUsers(@Nonnull Collection<String> var1);

    @Nonnull
    @CheckReturnValue
    default public R mentionUsers(String ... userIds) {
        Checks.notNull(userIds, "User IDs");
        return this.mentionUsers(Arrays.asList(userIds));
    }

    @Nonnull
    @CheckReturnValue
    default public R mentionUsers(long ... userIds) {
        Checks.notNull(userIds, "UserId array");
        String[] stringIds = new String[userIds.length];
        for (int i = 0; i < userIds.length; ++i) {
            stringIds[i] = Long.toUnsignedString(userIds[i]);
        }
        return this.mentionUsers(stringIds);
    }

    @Nonnull
    @CheckReturnValue
    public R mentionRoles(@Nonnull Collection<String> var1);

    @Nonnull
    @CheckReturnValue
    default public R mentionRoles(String ... roleIds) {
        Checks.notNull(roleIds, "Role IDs");
        return this.mentionRoles(Arrays.asList(roleIds));
    }

    @Nonnull
    @CheckReturnValue
    default public R mentionRoles(long ... roleIds) {
        Checks.notNull(roleIds, "RoleId array");
        String[] stringIds = new String[roleIds.length];
        for (int i = 0; i < roleIds.length; ++i) {
            stringIds[i] = Long.toUnsignedString(roleIds[i]);
        }
        return this.mentionRoles(stringIds);
    }

    @Nonnull
    public R applyMessage(@Nonnull Message var1);
}

