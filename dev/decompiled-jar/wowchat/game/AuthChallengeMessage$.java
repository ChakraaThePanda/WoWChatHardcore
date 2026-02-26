/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import io.netty.buffer.ByteBuf;
import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.runtime.AbstractFunction2;
import wowchat.game.AuthChallengeMessage;

public final class AuthChallengeMessage$
extends AbstractFunction2<byte[], ByteBuf, AuthChallengeMessage>
implements Serializable {
    public static AuthChallengeMessage$ MODULE$;

    static {
        new AuthChallengeMessage$();
    }

    @Override
    public final String toString() {
        return "AuthChallengeMessage";
    }

    @Override
    public AuthChallengeMessage apply(byte[] sessionKey, ByteBuf byteBuf) {
        return new AuthChallengeMessage(sessionKey, byteBuf);
    }

    public Option<Tuple2<byte[], ByteBuf>> unapply(AuthChallengeMessage x$0) {
        return x$0 == null ? None$.MODULE$ : new Some<Tuple2<byte[], ByteBuf>>(new Tuple2<byte[], ByteBuf>(x$0.sessionKey(), x$0.byteBuf()));
    }

    private Object readResolve() {
        return MODULE$;
    }

    private AuthChallengeMessage$() {
        MODULE$ = this;
    }
}

