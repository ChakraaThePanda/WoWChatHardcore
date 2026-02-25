/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple3;
import scala.runtime.AbstractFunction3;
import scala.runtime.BoxesRunTime;
import wowchat.game.NameQueryMessage;

public final class NameQueryMessage$
extends AbstractFunction3<Object, String, Object, NameQueryMessage>
implements Serializable {
    public static NameQueryMessage$ MODULE$;

    static {
        new NameQueryMessage$();
    }

    @Override
    public final String toString() {
        return "NameQueryMessage";
    }

    @Override
    public NameQueryMessage apply(long guid, String name, byte charClass) {
        return new NameQueryMessage(guid, name, charClass);
    }

    public Option<Tuple3<Object, String, Object>> unapply(NameQueryMessage x$0) {
        return x$0 == null ? None$.MODULE$ : new Some<Tuple3<Long, String, Byte>>(new Tuple3<Long, String, Byte>(BoxesRunTime.boxToLong(x$0.guid()), x$0.name(), BoxesRunTime.boxToByte(x$0.charClass())));
    }

    private Object readResolve() {
        return MODULE$;
    }

    private NameQueryMessage$() {
        MODULE$ = this;
    }
}

