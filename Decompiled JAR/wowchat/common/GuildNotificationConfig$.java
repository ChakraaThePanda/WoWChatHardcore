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
import wowchat.common.GuildNotificationConfig;

public final class GuildNotificationConfig$
extends AbstractFunction3<Object, String, Option<String>, GuildNotificationConfig>
implements Serializable {
    public static GuildNotificationConfig$ MODULE$;

    static {
        new GuildNotificationConfig$();
    }

    @Override
    public final String toString() {
        return "GuildNotificationConfig";
    }

    @Override
    public GuildNotificationConfig apply(boolean enabled, String format, Option<String> channel) {
        return new GuildNotificationConfig(enabled, format, channel);
    }

    public Option<Tuple3<Object, String, Option<String>>> unapply(GuildNotificationConfig x$0) {
        return x$0 == null ? None$.MODULE$ : new Some<Tuple3<Boolean, String, Option<String>>>(new Tuple3<Boolean, String, Option<String>>(BoxesRunTime.boxToBoolean(x$0.enabled()), x$0.format(), x$0.channel()));
    }

    private Object readResolve() {
        return MODULE$;
    }

    private GuildNotificationConfig$() {
        MODULE$ = this;
    }
}

