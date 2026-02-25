/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.Seq;
import scala.runtime.AbstractFunction2;
import scala.runtime.BoxesRunTime;
import wowchat.common.FiltersConfig;

public final class FiltersConfig$
extends AbstractFunction2<Object, Seq<String>, FiltersConfig>
implements Serializable {
    public static FiltersConfig$ MODULE$;

    static {
        new FiltersConfig$();
    }

    @Override
    public final String toString() {
        return "FiltersConfig";
    }

    @Override
    public FiltersConfig apply(boolean enabled, Seq<String> patterns) {
        return new FiltersConfig(enabled, patterns);
    }

    public Option<Tuple2<Object, Seq<String>>> unapply(FiltersConfig x$0) {
        return x$0 == null ? None$.MODULE$ : new Some<Tuple2<Boolean, Seq<String>>>(new Tuple2<Boolean, Seq<String>>(BoxesRunTime.boxToBoolean(x$0.enabled()), x$0.patterns()));
    }

    private Object readResolve() {
        return MODULE$;
    }

    private FiltersConfig$() {
        MODULE$ = this;
    }
}

