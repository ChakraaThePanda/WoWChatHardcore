/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.collection.immutable.Map;
import scala.runtime.AbstractFunction1;
import wowchat.common.GuildConfig;
import wowchat.common.GuildNotificationConfig;

public final class GuildConfig$
extends AbstractFunction1<Map<String, GuildNotificationConfig>, GuildConfig>
implements Serializable {
    public static GuildConfig$ MODULE$;

    static {
        new GuildConfig$();
    }

    @Override
    public final String toString() {
        return "GuildConfig";
    }

    @Override
    public GuildConfig apply(Map<String, GuildNotificationConfig> notificationConfigs) {
        return new GuildConfig(notificationConfigs);
    }

    public Option<Map<String, GuildNotificationConfig>> unapply(GuildConfig x$0) {
        return x$0 == null ? None$.MODULE$ : new Some<Map<String, GuildNotificationConfig>>(x$0.notificationConfigs());
    }

    private Object readResolve() {
        return MODULE$;
    }

    private GuildConfig$() {
        MODULE$ = this;
    }
}

