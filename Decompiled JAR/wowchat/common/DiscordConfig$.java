/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple6;
import scala.collection.immutable.Set;
import scala.runtime.AbstractFunction6;
import scala.runtime.BoxesRunTime;
import wowchat.common.DiscordConfig;

public final class DiscordConfig$
extends AbstractFunction6<String, Object, Set<String>, Set<String>, Object, Option<String>, DiscordConfig>
implements Serializable {
    public static DiscordConfig$ MODULE$;

    static {
        new DiscordConfig$();
    }

    @Override
    public final String toString() {
        return "DiscordConfig";
    }

    @Override
    public DiscordConfig apply(String token, boolean enableDotCommands, Set<String> dotCommandsWhitelist, Set<String> enableCommandsChannels, boolean enableTagFailedNotifications, Option<String> itemDatabase) {
        return new DiscordConfig(token, enableDotCommands, dotCommandsWhitelist, enableCommandsChannels, enableTagFailedNotifications, itemDatabase);
    }

    public Option<Tuple6<String, Object, Set<String>, Set<String>, Object, Option<String>>> unapply(DiscordConfig x$0) {
        return x$0 == null ? None$.MODULE$ : new Some<Tuple6<String, Boolean, Set<String>, Set<String>, Boolean, Option<String>>>(new Tuple6<String, Boolean, Set<String>, Set<String>, Boolean, Option<String>>(x$0.token(), BoxesRunTime.boxToBoolean(x$0.enableDotCommands()), x$0.dotCommandsWhitelist(), x$0.enableCommandsChannels(), BoxesRunTime.boxToBoolean(x$0.enableTagFailedNotifications()), x$0.itemDatabase()));
    }

    private Object readResolve() {
        return MODULE$;
    }

    private DiscordConfig$() {
        MODULE$ = this;
    }
}

