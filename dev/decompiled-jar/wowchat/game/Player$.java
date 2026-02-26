/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.runtime.AbstractFunction2;
import scala.runtime.BoxesRunTime;
import wowchat.game.Player;

public final class Player$
extends AbstractFunction2<String, Object, Player>
implements Serializable {
    public static Player$ MODULE$;

    static {
        new Player$();
    }

    @Override
    public final String toString() {
        return "Player";
    }

    @Override
    public Player apply(String name, byte charClass) {
        return new Player(name, charClass);
    }

    public Option<Tuple2<String, Object>> unapply(Player x$0) {
        return x$0 == null ? None$.MODULE$ : new Some<Tuple2<String, Byte>>(new Tuple2<String, Byte>(x$0.name(), BoxesRunTime.boxToByte(x$0.charClass())));
    }

    private Object readResolve() {
        return MODULE$;
    }

    private Player$() {
        MODULE$ = this;
    }
}

