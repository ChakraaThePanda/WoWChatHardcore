/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Predef$ArrowAssoc$;
import scala.Some;
import scala.Tuple2;
import scala.collection.SeqLike;

public final class $plus$colon$ {
    public static $plus$colon$ MODULE$;

    static {
        new $plus$colon$();
    }

    /*
     * WARNING - void declaration
     */
    public <T, Coll extends SeqLike<T, Coll>> Option<Tuple2<T, Coll>> unapply(Coll t) {
        void $minus$greater$extension_y;
        void $minus$greater$extension_$this;
        if (t.isEmpty()) {
            return None$.MODULE$;
        }
        Object Repr = t.tail();
        Object a = Predef$.MODULE$.ArrowAssoc(t.head());
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        return new Some<Tuple2<T, Coll>>(new Tuple2<void, void>($minus$greater$extension_$this, $minus$greater$extension_y));
    }

    private $plus$colon$() {
        MODULE$ = this;
    }
}

