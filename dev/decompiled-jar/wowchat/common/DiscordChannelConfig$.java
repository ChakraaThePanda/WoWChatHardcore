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
import wowchat.common.DiscordChannelConfig;
import wowchat.common.FiltersConfig;

public final class DiscordChannelConfig$
extends AbstractFunction3<String, String, Option<FiltersConfig>, DiscordChannelConfig>
implements Serializable {
    public static DiscordChannelConfig$ MODULE$;

    static {
        new DiscordChannelConfig$();
    }

    @Override
    public final String toString() {
        return "DiscordChannelConfig";
    }

    @Override
    public DiscordChannelConfig apply(String channel, String format, Option<FiltersConfig> filters) {
        return new DiscordChannelConfig(channel, format, filters);
    }

    public Option<Tuple3<String, String, Option<FiltersConfig>>> unapply(DiscordChannelConfig x$0) {
        return x$0 == null ? None$.MODULE$ : new Some<Tuple3<String, String, Option<FiltersConfig>>>(new Tuple3<String, String, Option<FiltersConfig>>(x$0.channel(), x$0.format(), x$0.filters()));
    }

    private Object readResolve() {
        return MODULE$;
    }

    private DiscordChannelConfig$() {
        MODULE$ = this;
    }
}

