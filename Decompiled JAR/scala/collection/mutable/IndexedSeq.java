/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.Function4;
import scala.Function5;
import scala.Some;
import scala.collection.GenTraversable;
import scala.collection.Seq;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.mutable.Builder;
import scala.collection.mutable.IndexedSeq$;
import scala.collection.mutable.IndexedSeqLike;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001y3q!\u0003\u0006\u0011\u0002\u0007\u0005\u0011\u0003C\u00035\u0001\u0011\u0005Q\u0007C\u0003:\u0001\u0011\u0005#\bC\u0003?\u0001\u0011\u0005shB\u0003A\u0015!\u0005\u0011IB\u0003\n\u0015!\u0005!\tC\u0003G\u000b\u0011\u0005q\tC\u0003I\u000b\u0011\r\u0011\nC\u0003V\u000b\u0011\u0005aK\u0001\u0006J]\u0012,\u00070\u001a3TKFT!a\u0003\u0007\u0002\u000f5,H/\u00192mK*\u0011QBD\u0001\u000bG>dG.Z2uS>t'\"A\b\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0011!#H\n\u0007\u0001M9b%\u000b\u0019\u0011\u0005Q)R\"\u0001\b\n\u0005Yq!AB!osJ+g\rE\u0002\u00193mi\u0011AC\u0005\u00035)\u00111aU3r!\taR\u0004\u0004\u0001\u0005\u000by\u0001!\u0019A\u0010\u0003\u0003\u0005\u000b\"\u0001I\u0012\u0011\u0005Q\t\u0013B\u0001\u0012\u000f\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"\u0001\u0006\u0013\n\u0005\u0015r!aA!osB\u0019q\u0005K\u000e\u000e\u00031I!!\u0003\u0007\u0011\t)j3dL\u0007\u0002W)\u0011A\u0006D\u0001\bO\u0016tWM]5d\u0013\tq3F\u0001\u000eHK:,'/[2Ue\u00064XM]:bE2,G+Z7qY\u0006$X\r\u0005\u0002\u0019\u0001A!\u0001$M\u000e4\u0013\t\u0011$B\u0001\bJ]\u0012,\u00070\u001a3TKFd\u0015n[3\u0011\u0007a\u00011$\u0001\u0004%S:LG\u000f\n\u000b\u0002mA\u0011AcN\u0005\u0003q9\u0011A!\u00168ji\u0006I1m\\7qC:LwN\\\u000b\u0002wA\u0019!\u0006P\u0018\n\u0005uZ#\u0001E$f]\u0016\u0014\u0018nY\"p[B\fg.[8o\u0003\r\u0019X-]\u000b\u0002g\u0005Q\u0011J\u001c3fq\u0016$7+Z9\u0011\u0005a)1CA\u0003D!\rQCiL\u0005\u0003\u000b.\u0012!bU3r\r\u0006\u001cGo\u001c:z\u0003\u0019a\u0014N\\5u}Q\t\u0011)\u0001\u0007dC:\u0014U/\u001b7e\rJ|W.\u0006\u0002K'V\t1\nE\u0003+\u0019:\u0013F+\u0003\u0002NW\ta1)\u00198Ck&dGM\u0012:p[B\u0011q\nU\u0007\u0002\u000b%\u0011\u0011\u000b\u0010\u0002\u0005\u0007>dG\u000e\u0005\u0002\u001d'\u0012)ad\u0002b\u0001?A\u0019\u0001\u0004\u0001*\u0002\u00159,wOQ;jY\u0012,'/\u0006\u0002X9V\t\u0001\f\u0005\u0003\u00193nk\u0016B\u0001.\u000b\u0005\u001d\u0011U/\u001b7eKJ\u0004\"\u0001\b/\u0005\u000byA!\u0019A\u0010\u0011\u0007a\u00011\f")
public interface IndexedSeq<A>
extends scala.collection.mutable.Seq<A>,
scala.collection.IndexedSeq<A>,
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

