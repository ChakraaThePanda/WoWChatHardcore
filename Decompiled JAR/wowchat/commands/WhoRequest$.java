/*
 * Decompiled with CFR 0.152.
 */
package wowchat.commands;

import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.runtime.AbstractFunction2;
import wowchat.commands.WhoRequest;

public final class WhoRequest$
extends AbstractFunction2<MessageChannel, String, WhoRequest>
implements Serializable {
    public static WhoRequest$ MODULE$;

    static {
        new WhoRequest$();
    }

    @Override
    public final String toString() {
        return "WhoRequest";
    }

    @Override
    public WhoRequest apply(MessageChannel messageChannel, String playerName) {
        return new WhoRequest(messageChannel, playerName);
    }

    public Option<Tuple2<MessageChannel, String>> unapply(WhoRequest x$0) {
        return x$0 == null ? None$.MODULE$ : new Some<Tuple2<MessageChannel, String>>(new Tuple2<MessageChannel, String>(x$0.messageChannel(), x$0.playerName()));
    }

    private Object readResolve() {
        return MODULE$;
    }

    private WhoRequest$() {
        MODULE$ = this;
    }
}

