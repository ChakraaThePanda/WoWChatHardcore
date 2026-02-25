/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple4;
import scala.runtime.AbstractFunction4;
import scala.runtime.BoxesRunTime;
import wowchat.game.ChatMessage;

public final class ChatMessage$
extends AbstractFunction4<Object, Object, String, Option<String>, ChatMessage>
implements Serializable {
    public static ChatMessage$ MODULE$;

    static {
        new ChatMessage$();
    }

    public Option<String> $lessinit$greater$default$4() {
        return None$.MODULE$;
    }

    @Override
    public final String toString() {
        return "ChatMessage";
    }

    @Override
    public ChatMessage apply(long guid, byte tp, String message, Option<String> channel) {
        return new ChatMessage(guid, tp, message, channel);
    }

    public Option<String> apply$default$4() {
        return None$.MODULE$;
    }

    public Option<Tuple4<Object, Object, String, Option<String>>> unapply(ChatMessage x$0) {
        return x$0 == null ? None$.MODULE$ : new Some<Tuple4<Long, Byte, String, Option<String>>>(new Tuple4<Long, Byte, String, Option<String>>(BoxesRunTime.boxToLong(x$0.guid()), BoxesRunTime.boxToByte(x$0.tp()), x$0.message(), x$0.channel()));
    }

    private Object readResolve() {
        return MODULE$;
    }

    private ChatMessage$() {
        MODULE$ = this;
    }
}

