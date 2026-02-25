/*
 * Decompiled with CFR 0.152.
 */
package wowchat.discord;

import net.dv8tion.jda.api.JDA;
import scala.Enumeration;
import scala.MatchError;
import wowchat.common.WowChatConfig$;
import wowchat.common.WowExpansion$;
import wowchat.discord.MessageResolver;
import wowchat.discord.MessageResolverCataclysm;
import wowchat.discord.MessageResolverMoP;
import wowchat.discord.MessageResolverTBC;
import wowchat.discord.MessageResolverWotLK;

public final class MessageResolver$ {
    public static MessageResolver$ MODULE$;

    static {
        new MessageResolver$();
    }

    public MessageResolver apply(JDA jda) {
        MessageResolver messageResolver;
        Enumeration.Value value = WowChatConfig$.MODULE$.getExpansion();
        Enumeration.Value value2 = WowExpansion$.MODULE$.Vanilla();
        Enumeration.Value value3 = value;
        if (!(value2 != null ? !((Object)value2).equals(value3) : value3 != null)) {
            messageResolver = new MessageResolver(jda);
        } else {
            Enumeration.Value value4 = WowExpansion$.MODULE$.TBC();
            Enumeration.Value value5 = value;
            if (!(value4 != null ? !((Object)value4).equals(value5) : value5 != null)) {
                messageResolver = new MessageResolverTBC(jda);
            } else {
                Enumeration.Value value6 = WowExpansion$.MODULE$.WotLK();
                Enumeration.Value value7 = value;
                if (!(value6 != null ? !((Object)value6).equals(value7) : value7 != null)) {
                    messageResolver = new MessageResolverWotLK(jda);
                } else {
                    Enumeration.Value value8 = WowExpansion$.MODULE$.Cataclysm();
                    Enumeration.Value value9 = value;
                    if (!(value8 != null ? !((Object)value8).equals(value9) : value9 != null)) {
                        messageResolver = new MessageResolverCataclysm(jda);
                    } else {
                        Enumeration.Value value10 = WowExpansion$.MODULE$.MoP();
                        Enumeration.Value value11 = value;
                        if (!(value10 != null ? !((Object)value10).equals(value11) : value11 != null)) {
                            messageResolver = new MessageResolverMoP(jda);
                        } else {
                            throw new MatchError(value);
                        }
                    }
                }
            }
        }
        return messageResolver;
    }

    private MessageResolver$() {
        MODULE$ = this;
    }
}

