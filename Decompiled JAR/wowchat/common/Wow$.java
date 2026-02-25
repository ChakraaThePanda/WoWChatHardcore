/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import scala.Enumeration;
import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple9;
import scala.runtime.AbstractFunction9;
import scala.runtime.BoxesRunTime;
import wowchat.common.RealmListConfig;
import wowchat.common.Wow;

public final class Wow$
extends AbstractFunction9<String, Enumeration.Value, Option<Object>, Option<Object>, RealmListConfig, byte[], String, String, Object, Wow>
implements Serializable {
    public static Wow$ MODULE$;

    static {
        new Wow$();
    }

    @Override
    public final String toString() {
        return "Wow";
    }

    @Override
    public Wow apply(String locale, Enumeration.Value platform, Option<Object> realmBuild, Option<Object> gameBuild, RealmListConfig realmlist, byte[] account, String password, String character, boolean enableServerMotd) {
        return new Wow(locale, platform, realmBuild, gameBuild, realmlist, account, password, character, enableServerMotd);
    }

    public Option<Tuple9<String, Enumeration.Value, Option<Object>, Option<Object>, RealmListConfig, byte[], String, String, Object>> unapply(Wow x$0) {
        return x$0 == null ? None$.MODULE$ : new Some<Tuple9<String, Enumeration.Value, Option<Object>, Option<Object>, RealmListConfig, byte[], String, String, Boolean>>(new Tuple9<String, Enumeration.Value, Option<Object>, Option<Object>, RealmListConfig, byte[], String, String, Boolean>(x$0.locale(), x$0.platform(), x$0.realmBuild(), x$0.gameBuild(), x$0.realmlist(), x$0.account(), x$0.password(), x$0.character(), BoxesRunTime.boxToBoolean(x$0.enableServerMotd())));
    }

    private Object readResolve() {
        return MODULE$;
    }

    private Wow$() {
        MODULE$ = this;
    }
}

