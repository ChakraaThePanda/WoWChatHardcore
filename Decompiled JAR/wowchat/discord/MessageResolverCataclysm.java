/*
 * Decompiled with CFR 0.152.
 */
package wowchat.discord;

import net.dv8tion.jda.api.JDA;
import scala.reflect.ScalaSignature;
import wowchat.discord.MessageResolverWotLK;

@ScalaSignature(bytes="\u0006\u0001-2A!\u0002\u0004\u0001\u0017!A\u0001\u0003\u0001B\u0001B\u0003%\u0011\u0003C\u0003\u001d\u0001\u0011\u0005Q\u0004C\u0004!\u0001\t\u0007I\u0011K\u0011\t\r)\u0002\u0001\u0015!\u0003#\u0005aiUm]:bO\u0016\u0014Vm]8mm\u0016\u00148)\u0019;bG2L8/\u001c\u0006\u0003\u000f!\tq\u0001Z5tG>\u0014HMC\u0001\n\u0003\u001d9xn^2iCR\u001c\u0001a\u0005\u0002\u0001\u0019A\u0011QBD\u0007\u0002\r%\u0011qB\u0002\u0002\u0015\u001b\u0016\u001c8/Y4f%\u0016\u001cx\u000e\u001c<fe^{G\u000fT&\u0002\u0007)$\u0017\r\u0005\u0002\u001355\t1C\u0003\u0002\u0015+\u0005\u0019\u0011\r]5\u000b\u0005A1\"BA\f\u0019\u0003\u001d!g\u000f\u000f;j_:T\u0011!G\u0001\u0004]\u0016$\u0018BA\u000e\u0014\u0005\rQE)Q\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0005yy\u0002CA\u0007\u0001\u0011\u0015\u0001\"\u00011\u0001\u0012\u0003=!WMZ1vYRd\u0015N\\6TSR,W#\u0001\u0012\u0011\u0005\rBS\"\u0001\u0013\u000b\u0005\u00152\u0013\u0001\u00027b]\u001eT\u0011aJ\u0001\u0005U\u00064\u0018-\u0003\u0002*I\t11\u000b\u001e:j]\u001e\f\u0001\u0003Z3gCVdG\u000fT5oWNKG/\u001a\u0011")
public class MessageResolverCataclysm
extends MessageResolverWotLK {
    private final String defaultLinkSite;

    @Override
    public String defaultLinkSite() {
        return this.defaultLinkSite;
    }

    public MessageResolverCataclysm(JDA jda) {
        super(jda);
        this.defaultLinkSite = "https://cata-twinhead.twinstar.cz/";
    }
}

