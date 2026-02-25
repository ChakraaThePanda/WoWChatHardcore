/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;

public final class $colon$colon$
implements Serializable {
    public static $colon$colon$ MODULE$;

    static {
        new $colon$colon$();
    }

    public final String toString() {
        return "::";
    }

    public <B> $colon$colon<B> apply(B head, List<B> tl) {
        return new $colon$colon<B>(head, tl);
    }

    public <B> Option<Tuple2<B, List<B>>> unapply($colon$colon<B> x$0) {
        if (x$0 == null) {
            return None$.MODULE$;
        }
        return new Some<Tuple2<B, List<B>>>(new Tuple2<B, List<B>>(x$0.head(), x$0.tl()));
    }

    private Object readResolve() {
        return MODULE$;
    }

    private $colon$colon$() {
        MODULE$ = this;
    }
}

