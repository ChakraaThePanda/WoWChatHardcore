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
import scala.collection.GenIterable;
import scala.collection.GenTraversable;
import scala.collection.Iterable$;
import scala.collection.IterableLike;
import scala.collection.Seq;
import scala.collection.Traversable;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.mutable.Builder;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\t4q!\u0003\u0006\u0011\u0002\u0007\u0005q\u0002C\u00033\u0001\u0011\u00051\u0007C\u00038\u0001\u0011\u0005\u0003\bC\u0003=\u0001\u0011\u0005ShB\u0003?\u0015!\u0005qHB\u0003\n\u0015!\u0005\u0001\tC\u0003H\u000b\u0011\u0005\u0001\nC\u0003J\u000b\u0011\r!\nC\u0003W\u000b\u0011\u0005qK\u0001\u0005Ji\u0016\u0014\u0018M\u00197f\u0015\tYA\"\u0001\u0006d_2dWm\u0019;j_:T\u0011!D\u0001\u0006g\u000e\fG.Y\u0002\u0001+\t\u00012d\u0005\u0004\u0001#U!sE\f\t\u0003%Mi\u0011\u0001D\u0005\u0003)1\u0011a!\u00118z%\u00164\u0007c\u0001\f\u001835\t!\"\u0003\u0002\u0019\u0015\tYAK]1wKJ\u001c\u0018M\u00197f!\tQ2\u0004\u0004\u0001\u0005\rq\u0001AQ1\u0001\u001e\u0005\u0005\t\u0015C\u0001\u0010\"!\t\u0011r$\u0003\u0002!\u0019\t9aj\u001c;iS:<\u0007C\u0001\n#\u0013\t\u0019CBA\u0002B]f\u00042AF\u0013\u001a\u0013\t1#BA\u0006HK:LE/\u001a:bE2,\u0007\u0003\u0002\u0015,35j\u0011!\u000b\u0006\u0003U)\tqaZ3oKJL7-\u0003\u0002-S\tQr)\u001a8fe&\u001cGK]1wKJ\u001c\u0018M\u00197f)\u0016l\u0007\u000f\\1uKB\u0011a\u0003\u0001\t\u0005-=J\u0012'\u0003\u00021\u0015\ta\u0011\n^3sC\ndW\rT5lKB\u0019a\u0003A\r\u0002\r\u0011Jg.\u001b;%)\u0005!\u0004C\u0001\n6\u0013\t1DB\u0001\u0003V]&$\u0018!C2p[B\fg.[8o+\u0005I\u0004c\u0001\u0015;[%\u00111(\u000b\u0002\u0011\u000f\u0016tWM]5d\u0007>l\u0007/\u00198j_:\f1a]3r+\u0005\t\u0014\u0001C%uKJ\f'\r\\3\u0011\u0005Y)1cA\u0003B\tB\u0019\u0001FQ\u0017\n\u0005\rK#!F$f]R\u0013\u0018M^3sg\u0006\u0014G.\u001a$bGR|'/\u001f\t\u0004Q\u0015k\u0013B\u0001$*\u0005I!&/\u0019<feN\f'\r\\3GC\u000e$xN]=\u0002\rqJg.\u001b;?)\u0005y\u0014\u0001D2b]\n+\u0018\u000e\u001c3Ge>lWCA&U+\u0005a\u0005#\u0002\u0015N\u001fN+\u0016B\u0001(*\u00051\u0019\u0015M\u001c\"vS2$gI]8n!\t\u0001\u0016+D\u0001\u0006\u0013\t\u0011&H\u0001\u0003D_2d\u0007C\u0001\u000eU\t\u0015arA1\u0001\u001e!\r1\u0002aU\u0001\u000b]\u0016<()^5mI\u0016\u0014XC\u0001-a+\u0005I\u0006\u0003\u0002.^?\u0006l\u0011a\u0017\u0006\u00039*\tq!\\;uC\ndW-\u0003\u0002_7\n9!)^5mI\u0016\u0014\bC\u0001\u000ea\t\u0015a\u0002B1\u0001\u001e!\r1\u0002a\u0018")
public interface Iterable<A>
extends Traversable<A>,
GenIterable<A>,
IterableLike<A, Iterable<A>> {
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

