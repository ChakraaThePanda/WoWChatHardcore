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
import scala.collection.GenTraversable;
import scala.collection.Seq;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.mutable.Builder;
import scala.collection.mutable.Iterable$;
import scala.collection.mutable.Traversable;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.mutable.ParIterable;
import scala.collection.parallel.mutable.ParIterable$;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001I4qAC\u0006\u0011\u0002\u0007\u0005!\u0003C\u0003@\u0001\u0011\u0005\u0001\tC\u0003E\u0001\u0011\u0005S\t\u0003\u0004J\u0001\u0001&\tF\u0013\u0005\u0006\u001f\u0002!\t\u0005U\u0004\u0006#.A\tA\u0015\u0004\u0006\u0015-A\ta\u0015\u0005\u00065\u001a!\ta\u0017\u0005\u00069\u001a!\u0019!\u0018\u0005\u0006S\u001a!\tA\u001b\u0002\t\u0013R,'/\u00192mK*\u0011A\"D\u0001\b[V$\u0018M\u00197f\u0015\tqq\"\u0001\u0006d_2dWm\u0019;j_:T\u0011\u0001E\u0001\u0006g\u000e\fG.Y\u0002\u0001+\t\u0019bdE\u0004\u0001)a9#&M\u001b\u0011\u0005U1R\"A\b\n\u0005]y!AB!osJ+g\rE\u0002\u001a5qi\u0011aC\u0005\u00037-\u00111\u0002\u0016:bm\u0016\u00148/\u00192mKB\u0011QD\b\u0007\u0001\t\u0015y\u0002A1\u0001!\u0005\u0005\t\u0015CA\u0011%!\t)\"%\u0003\u0002$\u001f\t9aj\u001c;iS:<\u0007CA\u000b&\u0013\t1sBA\u0002B]f\u00042\u0001K\u0015\u001d\u001b\u0005i\u0011B\u0001\u0006\u000e!\u0011Yc\u0006\b\u0019\u000e\u00031R!!L\u0007\u0002\u000f\u001d,g.\u001a:jG&\u0011q\u0006\f\u0002\u001b\u000f\u0016tWM]5d)J\fg/\u001a:tC\ndW\rV3na2\fG/\u001a\t\u00033\u0001\u0001B\u0001\u000b\u001a\u001di%\u00111'\u0004\u0002\r\u0013R,'/\u00192mK2K7.\u001a\t\u00043\u0001a\u0002\u0003\u0002\u001579aJ!aN\u0007\u0003\u001dA\u000b'/\u00197mK2L'0\u00192mKB\u0019\u0011(\u0010\u000f\u000e\u0003iR!\u0001D\u001e\u000b\u0005qj\u0011\u0001\u00039be\u0006dG.\u001a7\n\u0005yR$a\u0003)be&#XM]1cY\u0016\fa\u0001J5oSR$C#A!\u0011\u0005U\u0011\u0015BA\"\u0010\u0005\u0011)f.\u001b;\u0002\u0013\r|W\u000e]1oS>tW#\u0001$\u0011\u0007-:\u0005'\u0003\u0002IY\t\u0001r)\u001a8fe&\u001c7i\\7qC:LwN\\\u0001\fa\u0006\u00148i\\7cS:,'/F\u0001L!\u0011aU\n\b\u001d\u000e\u0003mJ!AT\u001e\u0003\u0011\r{WNY5oKJ\f1a]3r+\u0005!\u0014\u0001C%uKJ\f'\r\\3\u0011\u0005e11c\u0001\u0004U/B\u00191&\u0016\u0019\n\u0005Yc#!F$f]R\u0013\u0018M^3sg\u0006\u0014G.\u001a$bGR|'/\u001f\t\u0004Wa\u0003\u0014BA--\u0005I!&/\u0019<feN\f'\r\\3GC\u000e$xN]=\u0002\rqJg.\u001b;?)\u0005\u0011\u0016\u0001D2b]\n+\u0018\u000e\u001c3Ge>lWC\u00010h+\u0005y\u0006#B\u0016aE\u001aD\u0017BA1-\u00051\u0019\u0015M\u001c\"vS2$gI]8n!\t\u0019G-D\u0001\u0007\u0013\t)wI\u0001\u0003D_2d\u0007CA\u000fh\t\u0015y\u0002B1\u0001!!\rI\u0002AZ\u0001\u000b]\u0016<()^5mI\u0016\u0014XCA6q+\u0005a\u0007\u0003B\rn_FL!A\\\u0006\u0003\u000f\t+\u0018\u000e\u001c3feB\u0011Q\u0004\u001d\u0003\u0006?%\u0011\r\u0001\t\t\u00043\u0001y\u0007")
public interface Iterable<A>
extends Traversable<A>,
scala.collection.Iterable<A> {
    public static <A> CanBuildFrom<Iterable<?>, A, Iterable<A>> canBuildFrom() {
        return Iterable$.MODULE$.canBuildFrom();
    }

    public static GenTraversable iterate(Object object, int n, Function1 function1) {
        Iterable$ iterable$ = Iterable$.MODULE$;
        if (iterable$ == null) {
            throw null;
        }
        Builder iterate_b = ((GenericCompanion)iterable$).newBuilder();
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
        return Iterable$.MODULE$.range(object, object2, object3, integral);
    }

    public static GenTraversable range(Object object, Object object2, Integral integral) {
        return Iterable$.MODULE$.range(object, object2, integral);
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, int n5, Function5 function5) {
        Iterable$ iterable$ = Iterable$.MODULE$;
        if (iterable$ == null) {
            throw null;
        }
        Iterable$ tabulate_this = iterable$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$7$adapted(tabulate_this, n2, n3, n4, n5, function5, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, Function4 function4) {
        Iterable$ iterable$ = Iterable$.MODULE$;
        if (iterable$ == null) {
            throw null;
        }
        Iterable$ tabulate_this = iterable$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$5$adapted(tabulate_this, n2, n3, n4, function4, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, Function3 function3) {
        Iterable$ iterable$ = Iterable$.MODULE$;
        if (iterable$ == null) {
            throw null;
        }
        Iterable$ tabulate_this = iterable$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$3$adapted(tabulate_this, n2, n3, function3, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, Function2 function2) {
        Iterable$ iterable$ = Iterable$.MODULE$;
        if (iterable$ == null) {
            throw null;
        }
        Iterable$ tabulate_this = iterable$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$1$adapted(tabulate_this, n2, function2, arg_0));
    }

    public static GenTraversable tabulate(int n, Function1 function1) {
        return Iterable$.MODULE$.tabulate(n, function1);
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, int n5, Function0 function0) {
        Iterable$ iterable$ = Iterable$.MODULE$;
        if (iterable$ == null) {
            throw null;
        }
        Iterable$ fill_this = iterable$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$4$adapted(fill_this, n2, n3, n4, n5, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, Function0 function0) {
        Iterable$ iterable$ = Iterable$.MODULE$;
        if (iterable$ == null) {
            throw null;
        }
        Iterable$ fill_this = iterable$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$3$adapted(fill_this, n2, n3, n4, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, Function0 function0) {
        Iterable$ iterable$ = Iterable$.MODULE$;
        if (iterable$ == null) {
            throw null;
        }
        Iterable$ fill_this = iterable$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$2$adapted(fill_this, n2, n3, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, Function0 function0) {
        Iterable$ iterable$ = Iterable$.MODULE$;
        if (iterable$ == null) {
            throw null;
        }
        Iterable$ fill_this = iterable$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$1$adapted(fill_this, n2, function0, arg_0));
    }

    public static GenTraversable fill(int n, Function0 function0) {
        Iterable$ iterable$ = Iterable$.MODULE$;
        if (iterable$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)iterable$).newBuilder();
        fill_b.sizeHint(n);
        for (int fill_i = 0; fill_i < n; ++fill_i) {
            fill_b.$plus$eq(function0.apply());
        }
        return (GenTraversable)fill_b.result();
    }

    public static GenTraversable concat(Seq seq) {
        return Iterable$.MODULE$.concat(seq);
    }

    public static GenTraversableFactory.GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return Iterable$.MODULE$.ReusableCBF();
    }

    public static GenTraversable apply(Seq seq) {
        return Iterable$.MODULE$.apply(seq);
    }

    public static GenTraversable empty() {
        return Iterable$.MODULE$.empty();
    }

    public static /* synthetic */ GenericCompanion companion$(Iterable $this) {
        return $this.companion();
    }

    @Override
    default public GenericCompanion<Iterable> companion() {
        return Iterable$.MODULE$;
    }

    public static /* synthetic */ Combiner parCombiner$(Iterable $this) {
        return $this.parCombiner();
    }

    @Override
    default public Combiner<A, ParIterable<A>> parCombiner() {
        return ParIterable$.MODULE$.newCombiner();
    }

    public static /* synthetic */ Iterable seq$(Iterable $this) {
        return $this.seq();
    }

    @Override
    default public Iterable<A> seq() {
        return this;
    }

    public static void $init$(Iterable $this) {
    }
}

