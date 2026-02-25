/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.interactions.command;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.interactions.commands.context.UserContextInteraction;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.JDAImpl;
import net.dv8tion.jda.internal.entities.MemberImpl;
import net.dv8tion.jda.internal.interactions.command.ContextInteractionImpl;

public class UserContextInteractionImpl
extends ContextInteractionImpl<User>
implements UserContextInteraction {
    private Member member;

    public UserContextInteractionImpl(JDAImpl jda, DataObject data) {
        super(jda, data);
    }

    @Override
    protected User parse(DataObject interaction, DataObject resolved) {
        DataObject users = resolved.getObject("users");
        DataObject user = users.getObject(users.keys().iterator().next());
        resolved.optObject("members").filter(m -> !m.keys().isEmpty()).ifPresent(members -> {
            DataObject member = members.getObject(members.keys().iterator().next());
            this.member = this.interactionEntityBuilder.createMember(this.guild, member);
            if (this.member instanceof MemberImpl) {
                this.api.getEntityBuilder().updateMemberCache((MemberImpl)this.member);
            }
        });
        return this.api.getEntityBuilder().createUser(user);
    }

    @Override
    public Member getTargetMember() {
        return this.member;
    }
}

