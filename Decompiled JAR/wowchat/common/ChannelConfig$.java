/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import scala.Enumeration;
import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple3;
import scala.runtime.AbstractFunction3;
import wowchat.common.ChannelConfig;
import wowchat.common.DiscordChannelConfig;
import wowchat.common.WowChannelConfig;

public final class ChannelConfig$
extends AbstractFunction3<Enumeration.Value, WowChannelConfig, DiscordChannelConfig, ChannelConfig>
implements Serializable {
    public static ChannelConfig$ MODULE$;

    static {
        new ChannelConfig$();
    }

    @Override
    public final String toString() {
        return "ChannelConfig";
    }

    @Override
    public ChannelConfig apply(Enumeration.Value chatDirection, WowChannelConfig wow, DiscordChannelConfig discord) {
        return new ChannelConfig(chatDirection, wow, discord);
    }

    public Option<Tuple3<Enumeration.Value, WowChannelConfig, DiscordChannelConfig>> unapply(ChannelConfig x$0) {
        return x$0 == null ? None$.MODULE$ : new Some<Tuple3<Enumeration.Value, WowChannelConfig, DiscordChannelConfig>>(new Tuple3<Enumeration.Value, WowChannelConfig, DiscordChannelConfig>(x$0.chatDirection(), x$0.wow(), x$0.discord()));
    }

    private Object readResolve() {
        return MODULE$;
    }

    private ChannelConfig$() {
        MODULE$ = this;
    }
}

