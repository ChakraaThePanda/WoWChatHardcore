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
import scala.collection.GenTraversable;
import scala.collection.Seq;
import scala.collection.Traversable$;
import scala.collection.TraversableLike;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.mutable.Builder;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001=4qa\u0003\u0007\u0011\u0002\u0007\u0005\u0011\u0003C\u00035\u0001\u0011\u0005Q\u0007C\u0003:\u0001\u0011\u0005#\bC\u0003?\u0001\u0011\u0005shB\u0003A\u0019!\u0005\u0011IB\u0003\f\u0019!\u0005!\tC\u0003J\u000b\u0011\u0005!\n\u0003\u0005L\u000b\t\u0007I\u0011\u0001\u0007M\u0011\u0019)V\u0001)A\u0005\u001b\")a+\u0002C\u0002/\")1-\u0002C\u0001I\nYAK]1wKJ\u001c\u0018M\u00197f\u0015\tia\"\u0001\u0006d_2dWm\u0019;j_:T\u0011aD\u0001\u0006g\u000e\fG.Y\u0002\u0001+\t\u0011Rd\u0005\u0004\u0001']9#&\f\t\u0003)Ui\u0011AD\u0005\u0003-9\u0011a!\u00118z%\u00164\u0007\u0003\u0002\r\u001a7\u0019j\u0011\u0001D\u0005\u000351\u0011q\u0002\u0016:bm\u0016\u00148/\u00192mK2K7.\u001a\t\u00039ua\u0001\u0001\u0002\u0004\u001f\u0001\u0011\u0015\ra\b\u0002\u0002\u0003F\u0011\u0001e\t\t\u0003)\u0005J!A\t\b\u0003\u000f9{G\u000f[5oOB\u0011A\u0003J\u0005\u0003K9\u00111!\u00118z!\rA\u0002a\u0007\t\u00041!Z\u0012BA\u0015\r\u000599UM\u001c+sCZ,'o]1cY\u0016\u00042\u0001G\u0016\u001c\u0013\taCBA\bUe\u00064XM]:bE2,wJ\\2f!\u0011q\u0013gG\u001a\u000e\u0003=R!\u0001\r\u0007\u0002\u000f\u001d,g.\u001a:jG&\u0011!g\f\u0002\u001b\u000f\u0016tWM]5d)J\fg/\u001a:tC\ndW\rV3na2\fG/\u001a\t\u00031\u0001\ta\u0001J5oSR$C#\u0001\u001c\u0011\u0005Q9\u0014B\u0001\u001d\u000f\u0005\u0011)f.\u001b;\u0002\u0013\r|W\u000e]1oS>tW#A\u001e\u0011\u00079b4'\u0003\u0002>_\t\u0001r)\u001a8fe&\u001c7i\\7qC:LwN\\\u0001\u0004g\u0016\fX#\u0001\u0014\u0002\u0017Q\u0013\u0018M^3sg\u0006\u0014G.\u001a\t\u00031\u0015\u00192!B\"G!\rqCiM\u0005\u0003\u000b>\u0012QcR3o)J\fg/\u001a:tC\ndWMR1di>\u0014\u0018\u0010E\u0002/\u000fNJ!\u0001S\u0018\u0003%Q\u0013\u0018M^3sg\u0006\u0014G.\u001a$bGR|'/_\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003\u0005\u000baA\u0019:fC.\u001cX#A'\u0011\u00059\u001bV\"A(\u000b\u0005A\u000b\u0016aB2p]R\u0014x\u000e\u001c\u0006\u0003%:\tA!\u001e;jY&\u0011Ak\u0014\u0002\u0007\u0005J,\u0017m[:\u0002\u000f\t\u0014X-Y6tA\u0005a1-\u00198Ck&dGM\u0012:p[V\u0011\u0001,Y\u000b\u00023B)aF\u0017/aE&\u00111l\f\u0002\r\u0007\u0006t')^5mI\u001a\u0013x.\u001c\t\u0003;zk\u0011!B\u0005\u0003?r\u0012AaQ8mYB\u0011A$\u0019\u0003\u0006=%\u0011\ra\b\t\u00041\u0001\u0001\u0017A\u00038fo\n+\u0018\u000e\u001c3feV\u0011Q-\\\u000b\u0002MB!qM\u001b7o\u001b\u0005A'BA5\r\u0003\u001diW\u000f^1cY\u0016L!a\u001b5\u0003\u000f\t+\u0018\u000e\u001c3feB\u0011A$\u001c\u0003\u0006=)\u0011\ra\b\t\u00041\u0001a\u0007")
public interface Traversable<A>
extends TraversableLike<A, Traversable<A>>,
GenTraversable<A> {
    public static <A> CanBuildFrom<Traversable<?>, A, Traversable<A>> canBuildFrom() {
        return Traversable$.MODULE$.canBuildFrom();
    }

    public static GenTraversable iterate(Object object, int n, Function1 function1) {
        Traversable$ traversable$ = Traversable$.MODULE$;
        if (traversable$ == null) {
            throw null;
        }
        Builder iterate_b = ((GenericCompanion)traversable$).newBuilder();
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
        return Traversable$.MODULE$.range(object, object2, object3, integral);
    }

    public static GenTraversable range(Object object, Object object2, Integral integral) {
        return Traversable$.MODULE$.range(object, object2, integral);
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, int n5, Function5 function5) {
        Traversable$ traversable$ = Traversable$.MODULE$;
        if (traversable$ == null) {
            throw null;
        }
        Traversable$ tabulate_this = traversable$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$7$adapted(tabulate_this, n2, n3, n4, n5, function5, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, Function4 function4) {
        Traversable$ traversable$ = Traversable$.MODULE$;
        if (traversable$ == null) {
            throw null;
        }
        Traversable$ tabulate_this = traversable$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$5$adapted(tabulate_this, n2, n3, n4, function4, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, Function3 function3) {
        Traversable$ traversable$ = Traversable$.MODULE$;
        if (traversable$ == null) {
            throw null;
        }
        Traversable$ tabulate_this = traversable$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$3$adapted(tabulate_this, n2, n3, function3, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, Function2 function2) {
        Traversable$ traversable$ = Traversable$.MODULE$;
        if (traversable$ == null) {
            throw null;
        }
        Traversable$ tabulate_this = traversable$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$1$adapted(tabulate_this, n2, function2, arg_0));
    }

    public static GenTraversable tabulate(int n, Function1 function1) {
        return Traversable$.MODULE$.tabulate(n, function1);
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, int n5, Function0 function0) {
        Traversable$ traversable$ = Traversable$.MODULE$;
        if (traversable$ == null) {
            throw null;
        }
        Traversable$ fill_this = traversable$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$4$adapted(fill_this, n2, n3, n4, n5, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, Function0 function0) {
        Traversable$ traversable$ = Traversable$.MODULE$;
        if (traversable$ == null) {
            throw null;
        }
        Traversable$ fill_this = traversable$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$3$adapted(fill_this, n2, n3, n4, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, Function0 function0) {
        Traversable$ traversable$ = Traversable$.MODULE$;
        if (traversable$ == null) {
            throw null;
        }
        Traversable$ fill_this = traversable$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$2$adapted(fill_this, n2, n3, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, Function0 function0) {
        Traversable$ traversable$ = Traversable$.MODULE$;
        if (traversable$ == null) {
            throw null;
        }
        Traversable$ fill_this = traversable$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$1$adapted(fill_this, n2, function0, arg_0));
    }

    public static GenTraversable fill(int n, Function0 function0) {
        Traversable$ traversable$ = Traversable$.MODULE$;
        if (traversable$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)traversable$).newBuilder();
        fill_b.sizeHint(n);
        for (int fill_i = 0; fill_i < n; ++fill_i) {
            fill_b.$plus$eq(function0.apply());
        }
        return (GenTraversable)fill_b.result();
    }

    public static GenTraversable concat(Seq seq) {
        return Traversable$.MODULE$.concat(seq);
    }

    public static GenTraversableFactory.GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return Traversable$.MODULE$.ReusableCBF();
    }

    public static GenTraversable apply(Seq seq) {
        return Traversable$.MODULE$.apply(seq);
    }

    public static GenTraversable empty() {
        return Traversable$.MODULE$.empty();
    }

    public static /* synthetic */ GenericCompanion companion$(Traversable $this) {
        return $this.companion();
    }

    @Override
    default public GenericCompanion<Traversable> companion() {
        return Traversable$.MODULE$;
    }

    public static /* synthetic */ Traversable seq$(Traversable $this) {
        return $this.seq();
    }

    @Override
    default public Traversable<A> seq() {
        return this;
    }

    public static void $init$(Traversable $this) {
    }
}

