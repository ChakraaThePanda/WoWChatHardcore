/*
 * Decompiled with CFR 0.152.
 */
package wowchat.commands;

import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple7;
import scala.runtime.AbstractFunction7;
import scala.runtime.BoxesRunTime;
import wowchat.commands.WhoResponse;

public final class WhoResponse$
extends AbstractFunction7<String, String, Object, String, String, Option<String>, String, WhoResponse>
implements Serializable {
    public static WhoResponse$ MODULE$;

    static {
        new WhoResponse$();
    }

    @Override
    public final String toString() {
        return "WhoResponse";
    }

    @Override
    public WhoResponse apply(String playerName, String guildName, int lvl, String cls, String race, Option<String> gender, String zone) {
        return new WhoResponse(playerName, guildName, lvl, cls, race, gender, zone);
    }

    public Option<Tuple7<String, String, Object, String, String, Option<String>, String>> unapply(WhoResponse x$0) {
        return x$0 == null ? None$.MODULE$ : new Some<Tuple7<String, String, Integer, String, String, Option<String>, String>>(new Tuple7<String, String, Integer, String, String, Option<String>, String>(x$0.playerName(), x$0.guildName(), BoxesRunTime.boxToInteger(x$0.lvl()), x$0.cls(), x$0.race(), x$0.gender(), x$0.zone()));
    }

    private Object readResolve() {
        return MODULE$;
    }

    private WhoResponse$() {
        MODULE$ = this;
    }
}

