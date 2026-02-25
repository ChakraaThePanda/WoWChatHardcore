/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple5;
import scala.runtime.AbstractFunction5;
import scala.runtime.BoxesRunTime;
import wowchat.common.FiltersConfig;
import wowchat.common.WowChannelConfig;

public final class WowChannelConfig$
extends AbstractFunction5<Option<Object>, Object, Option<String>, String, Option<FiltersConfig>, WowChannelConfig>
implements Serializable {
    public static WowChannelConfig$ MODULE$;

    static {
        new WowChannelConfig$();
    }

    public Option<String> $lessinit$greater$default$3() {
        return None$.MODULE$;
    }

    @Override
    public final String toString() {
        return "WowChannelConfig";
    }

    @Override
    public WowChannelConfig apply(Option<Object> id, byte tp, Option<String> channel, String format, Option<FiltersConfig> filters) {
        return new WowChannelConfig(id, tp, channel, format, filters);
    }

    public Option<String> apply$default$3() {
        return None$.MODULE$;
    }

    public Option<Tuple5<Option<Object>, Object, Option<String>, String, Option<FiltersConfig>>> unapply(WowChannelConfig x$0) {
        return x$0 == null ? None$.MODULE$ : new Some<Tuple5<Option<Object>, Byte, Option<String>, String, Option<FiltersConfig>>>(new Tuple5<Option<Object>, Byte, Option<String>, String, Option<FiltersConfig>>(x$0.id(), BoxesRunTime.boxToByte(x$0.tp()), x$0.channel(), x$0.format(), x$0.filters()));
    }

    private Object readResolve() {
        return MODULE$;
    }

    private WowChannelConfig$() {
        MODULE$ = this;
    }
}

