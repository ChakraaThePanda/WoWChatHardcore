/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.script;

import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.script.Include;
import scala.collection.script.Location;

public final class Include$
implements Serializable {
    public static Include$ MODULE$;

    static {
        new Include$();
    }

    public final String toString() {
        return "Include";
    }

    public <A> Include<A> apply(Location location, A elem) {
        return new Include<A>(location, elem);
    }

    public <A> Option<Tuple2<Location, A>> unapply(Include<A> x$0) {
        if (x$0 == null) {
            return None$.MODULE$;
        }
        return new Some<Tuple2<Location, A>>(new Tuple2<Location, A>(x$0.location(), x$0.elem()));
    }

    private Object readResolve() {
        return MODULE$;
    }

    private Include$() {
        MODULE$ = this;
    }
}

