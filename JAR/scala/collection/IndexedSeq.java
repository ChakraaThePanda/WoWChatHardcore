/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.Function4;
import scala.Function5;
import scala.Some;
import scala.collection.GenTraversable;
import scala.collection.IndexedSeq$;
import scala.collection.IndexedSeqLike;
import scala.collection.Seq;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.mutable.Builder;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001q3q!\u0003\u0006\u0011\u0002\u0007\u0005q\u0002C\u00030\u0001\u0011\u0005\u0001\u0007C\u00035\u0001\u0011\u0005S\u0007C\u0003:\u0001\u0011\u0005#hB\u0003<\u0015!\u0005AHB\u0003\n\u0015!\u0005Q\bC\u0003B\u000b\u0011\u0005!\tC\u0003D\u000b\u0011\u0005A\tC\u0003P\u000b\u0011\r\u0001K\u0001\u0006J]\u0012,\u00070\u001a3TKFT!a\u0003\u0007\u0002\u0015\r|G\u000e\\3di&|gNC\u0001\u000e\u0003\u0015\u00198-\u00197b\u0007\u0001)\"\u0001E\u000e\u0014\u000b\u0001\tR\u0003J\u0016\u0011\u0005I\u0019R\"\u0001\u0007\n\u0005Qa!AB!osJ+g\rE\u0002\u0017/ei\u0011AC\u0005\u00031)\u00111aU3r!\tQ2\u0004\u0004\u0001\u0005\rq\u0001AQ1\u0001\u001e\u0005\u0005\t\u0015C\u0001\u0010\"!\t\u0011r$\u0003\u0002!\u0019\t9aj\u001c;iS:<\u0007C\u0001\n#\u0013\t\u0019CBA\u0002B]f\u0004B!\n\u0015\u001aU5\taE\u0003\u0002(\u0015\u00059q-\u001a8fe&\u001c\u0017BA\u0015'\u0005i9UM\\3sS\u000e$&/\u0019<feN\f'\r\\3UK6\u0004H.\u0019;f!\t1\u0002\u0001\u0005\u0003\u0017Yeq\u0013BA\u0017\u000b\u00059Ie\u000eZ3yK\u0012\u001cV-\u001d'jW\u0016\u00042A\u0006\u0001\u001a\u0003\u0019!\u0013N\\5uIQ\t\u0011\u0007\u0005\u0002\u0013e%\u00111\u0007\u0004\u0002\u0005+:LG/A\u0005d_6\u0004\u0018M\\5p]V\ta\u0007E\u0002&o)J!\u0001\u000f\u0014\u0003!\u001d+g.\u001a:jG\u000e{W\u000e]1oS>t\u0017aA:fcV\ta&\u0001\u0006J]\u0012,\u00070\u001a3TKF\u0004\"AF\u0003\u0014\u0005\u0015q\u0004cA\u0013@U%\u0011\u0001I\n\u0002\u0012\u0013:$W\r_3e'\u0016\fh)Y2u_JL\u0018A\u0002\u001fj]&$h\bF\u0001=\u0003)qWm\u001e\"vS2$WM]\u000b\u0003\u000b6+\u0012A\u0012\t\u0005\u000f*ce*D\u0001I\u0015\tI%\"A\u0004nkR\f'\r\\3\n\u0005-C%a\u0002\"vS2$WM\u001d\t\u000355#Q\u0001H\u0004C\u0002u\u00012A\u0006\u0001M\u00031\u0019\u0017M\u001c\"vS2$gI]8n+\t\t&,F\u0001S!\u0015)3+V-\\\u0013\t!fE\u0001\u0007DC:\u0014U/\u001b7e\rJ|W\u000e\u0005\u0002W/6\tQ!\u0003\u0002Yo\t!1i\u001c7m!\tQ\"\fB\u0003\u001d\u0011\t\u0007Q\u0004E\u0002\u0017\u0001e\u0003")
public interface IndexedSeq<A>
extends Seq<A>,
IndexedSeqLike<A, IndexedSeq<A>> {
    public static <A> CanBuildFrom<IndexedSeq<?>, A, IndexedSeq<A>> canBuildFrom() {
        return IndexedSeq$.MODULE$.canBuildFrom();
    }

    public static Some unapplySeq(Seq seq) {
        return IndexedSeq$.MODULE$.unapplySeq(seq);
    }

    public static GenTraversable iterate(Object object, int n, Function1 function1) {
        IndexedSeq$ indexedSeq$ = IndexedSeq$.MODULE$;
        if (indexedSeq$ == null) {
            throw null;
        }
        Builder iterate_b = ((GenericCompanion)indexedSeq$).newBuilder();
        if (n > 0) {
            iterate_b.sizeHint(n);
            Object iterate_acc = object;
            iterate_b.$plus$eq(object);
            for (int iterate_i = 1; iterate_i < n; ++iterate_i) {
                iterate_acc = function1.apply(iterate_acc);
                iterate_b.$plus$eq(iterate_acc);
            }
        }
        return (GenTraversable)iterate_b.result();
    }

    public static GenTraversable range(Object object, Object object2, Object object3, Integral integral) {
        return IndexedSeq$.MODULE$.range(object, object2, object3, integral);
    }

    public static GenTraversable range(Object object, Object object2, Integral integral) {
        return IndexedSeq$.MODULE$.range(object, object2, integral);
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, int n5, Function5 function5) {
        IndexedSeq$ indexedSeq$ = IndexedSeq$.MODULE$;
        if (indexedSeq$ == null) {
            throw null;
        }
        IndexedSeq$ tabulate_this = indexedSeq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$7$adapted(tabulate_this, n2, n3, n4, n5, function5, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, Function4 function4) {
        IndexedSeq$ indexedSeq$ = IndexedSeq$.MODULE$;
        if (indexedSeq$ == null) {
            throw null;
        }
        IndexedSeq$ tabulate_this = indexedSeq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$5$adapted(tabulate_this, n2, n3, n4, function4, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, Function3 function3) {
        IndexedSeq$ indexedSeq$ = IndexedSeq$.MODULE$;
        if (indexedSeq$ == null) {
            throw null;
        }
        IndexedSeq$ tabulate_this = indexedSeq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$3$adapted(tabulate_this, n2, n3, function3, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, Function2 function2) {
        IndexedSeq$ indexedSeq$ = IndexedSeq$.MODULE$;
        if (indexedSeq$ == null) {
            throw null;
        }
        IndexedSeq$ tabulate_this = indexedSeq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$1$adapted(tabulate_this, n2, function2, arg_0));
    }

    public static GenTraversable tabulate(int n, Function1 function1) {
        return IndexedSeq$.MODULE$.tabulate(n, function1);
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, int n5, Function0 function0) {
        IndexedSeq$ indexedSeq$ = IndexedSeq$.MODULE$;
        if (indexedSeq$ == null) {
            throw null;
        }
        IndexedSeq$ fill_this = indexedSeq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$4$adapted(fill_this, n2, n3, n4, n5, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, Function0 function0) {
        IndexedSeq$ indexedSeq$ = IndexedSeq$.MODULE$;
        if (indexedSeq$ == null) {
            throw null;
        }
        IndexedSeq$ fill_this = indexedSeq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$3$adapted(fill_this, n2, n3, n4, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, Function0 function0) {
        IndexedSeq$ indexedSeq$ = IndexedSeq$.MODULE$;
        if (indexedSeq$ == null) {
            throw null;
        }
        IndexedSeq$ fill_this = indexedSeq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$2$adapted(fill_this, n2, n3, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, Function0 function0) {
        IndexedSeq$ indexedSeq$ = IndexedSeq$.MODULE$;
        if (indexedSeq$ == null) {
            throw null;
        }
        IndexedSeq$ fill_this = indexedSeq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$1$adapted(fill_this, n2, function0, arg_0));
    }

    public static GenTraversable fill(int n, Function0 function0) {
        IndexedSeq$ indexedSeq$ = IndexedSeq$.MODULE$;
        if (indexedSeq$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)indexedSeq$).newBuilder();
        fill_b.sizeHint(n);
        for (int fill_i = 0; fill_i < n; ++fill_i) {
            fill_b.$plus$eq(function0.apply());
        }
        return (GenTraversable)fill_b.result();
    }

    public static GenTraversable concat(Seq seq) {
        return IndexedSeq$.MODULE$.concat(seq);
    }

    public static GenTraversableFactory.GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return IndexedSeq$.MODULE$.ReusableCBF();
    }

    public static GenTraversable empty() {
        return IndexedSeq$.MODULE$.empty();
    }

    public static /* synthetic */ GenericCompanion companion$(IndexedSeq $this) {
        return $this.companion();
    }

    @Override
    default public GenericCompanion<IndexedSeq> companion() {
        return IndexedSeq$.MODULE$;
    }

    public static /* synthetic */ IndexedSeq seq$(IndexedSeq $this) {
        return $this.seq();
    }

    @Override
    default public IndexedSeq<A> seq() {
        return this;
    }

    public static void $init$(IndexedSeq $this) {
    }
}

