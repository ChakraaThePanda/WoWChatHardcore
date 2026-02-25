/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.utils.messages;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.interactions.components.LayoutComponent;
import net.dv8tion.jda.api.utils.AttachedFile;

public interface MessageData {
    @Nonnull
    public String getContent();

    @Nonnull
    public List<MessageEmbed> getEmbeds();

    @Nonnull
    public List<LayoutComponent> getComponents();

    @Nonnull
    public List<? extends AttachedFile> getAttachments();

    public boolean isSuppressEmbeds();

    @Nonnull
    public Set<String> getMentionedUsers();

    @Nonnull
    public Set<String> getMentionedRoles();

    @Nonnull
    public EnumSet<Message.MentionType> getAllowedMentions();

    public boolean isMentionRepliedUser();
}

