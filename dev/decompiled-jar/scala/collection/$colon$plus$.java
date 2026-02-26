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

public final class $colon$plus$ {
    public static $colon$plus$ MODULE$;

    static {
        new $colon$plus$();
    }

    /*
     * WARNING - void declaration
     */
    public <T, Coll extends SeqLike<T, Coll>> Option<Tuple2<Coll, T>> unapply(Coll t) {
        void $minus$greater$extension_y;
        void $minus$greater$extension_$this;
        if (t.isEmpty()) {
            return None$.MODULE$;
        }
        Object a = t.last();
        Object Repr = Predef$.MODULE$.ArrowAssoc(t.init());
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        return new Some<Tuple2<Coll, T>>(new Tuple2<void, void>($minus$greater$extension_$this, $minus$greater$extension_y));
    }

    private $colon$plus$() {
        MODULE$ = this;
    }
}

