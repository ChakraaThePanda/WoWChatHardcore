/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple6;
import scala.runtime.AbstractFunction6;
import scala.runtime.BoxesRunTime;
import wowchat.game.GuildMember;

public final class GuildMember$
extends AbstractFunction6<String, Object, Object, Object, Object, Object, GuildMember>
implements Serializable {
    public static GuildMember$ MODULE$;

    static {
        new GuildMember$();
    }

    @Override
    public final String toString() {
        return "GuildMember";
    }

    @Override
    public GuildMember apply(String name, boolean isOnline, byte charClass, byte level, int zoneId, float lastLogoff) {
        return new GuildMember(name, isOnline, charClass, level, zoneId, lastLogoff);
    }

    public Option<Tuple6<String, Object, Object, Object, Object, Object>> unapply(GuildMember x$0) {
        return x$0 == null ? None$.MODULE$ : new Some<Tuple6<String, Boolean, Byte, Byte, Integer, Float>>(new Tuple6<String, Boolean, Byte, Byte, Integer, Float>(x$0.name(), BoxesRunTime.boxToBoolean(x$0.isOnline()), BoxesRunTime.boxToByte(x$0.charClass()), BoxesRunTime.boxToByte(x$0.level()), BoxesRunTime.boxToInteger(x$0.zoneId()), BoxesRunTime.boxToFloat(x$0.lastLogoff())));
    }

    private Object readResolve() {
        return MODULE$;
    }

    private GuildMember$() {
        MODULE$ = this;
    }
}

