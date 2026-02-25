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
import wowchat.game.CharEnumMessage;

public final class CharEnumMessage$
extends AbstractFunction4<String, Object, Object, Object, CharEnumMessage>
implements Serializable {
    public static CharEnumMessage$ MODULE$;

    static {
        new CharEnumMessage$();
    }

    @Override
    public final String toString() {
        return "CharEnumMessage";
    }

    @Override
    public CharEnumMessage apply(String name, long guid, byte race, long guildGuid) {
        return new CharEnumMessage(name, guid, race, guildGuid);
    }

    public Option<Tuple4<String, Object, Object, Object>> unapply(CharEnumMessage x$0) {
        return x$0 == null ? None$.MODULE$ : new Some<Tuple4<String, Long, Byte, Long>>(new Tuple4<String, Long, Byte, Long>(x$0.name(), BoxesRunTime.boxToLong(x$0.guid()), BoxesRunTime.boxToByte(x$0.race()), BoxesRunTime.boxToLong(x$0.guildGuid())));
    }

    private Object readResolve() {
        return MODULE$;
    }

    private CharEnumMessage$() {
        MODULE$ = this;
    }
}

