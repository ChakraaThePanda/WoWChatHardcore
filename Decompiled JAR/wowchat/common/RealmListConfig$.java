/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple3;
import scala.runtime.AbstractFunction3;
import scala.runtime.BoxesRunTime;
import wowchat.common.RealmListConfig;

public final class RealmListConfig$
extends AbstractFunction3<String, String, Object, RealmListConfig>
implements Serializable {
    public static RealmListConfig$ MODULE$;

    static {
        new RealmListConfig$();
    }

    @Override
    public final String toString() {
        return "RealmListConfig";
    }

    @Override
    public RealmListConfig apply(String name, String host, int port) {
        return new RealmListConfig(name, host, port);
    }

    public Option<Tuple3<String, String, Object>> unapply(RealmListConfig x$0) {
        return x$0 == null ? None$.MODULE$ : new Some<Tuple3<String, String, Integer>>(new Tuple3<String, String, Integer>(x$0.name(), x$0.host(), BoxesRunTime.boxToInteger(x$0.port())));
    }

    private Object readResolve() {
        return MODULE$;
    }

    private RealmListConfig$() {
        MODULE$ = this;
    }
}

