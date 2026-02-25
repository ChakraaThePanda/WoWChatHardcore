/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.immutable.Map;
import scala.runtime.AbstractFunction2;
import wowchat.game.GuildInfo;

public final class GuildInfo$
extends AbstractFunction2<String, Map<Object, String>, GuildInfo>
implements Serializable {
    public static GuildInfo$ MODULE$;

    static {
        new GuildInfo$();
    }

    @Override
    public final String toString() {
        return "GuildInfo";
    }

    @Override
    public GuildInfo apply(String name, Map<Object, String> ranks) {
        return new GuildInfo(name, ranks);
    }

    public Option<Tuple2<String, Map<Object, String>>> unapply(GuildInfo x$0) {
        return x$0 == null ? None$.MODULE$ : new Some<Tuple2<String, Map<Object, String>>>(new Tuple2<String, Map<Object, String>>(x$0.name(), x$0.ranks()));
    }

    private Object readResolve() {
        return MODULE$;
    }

    private GuildInfo$() {
        MODULE$ = this;
    }
}

