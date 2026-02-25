/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

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
import scala.collection.immutable.Iterable$;
import scala.collection.immutable.Traversable;
import scala.collection.mutable.Builder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.immutable.ParIterable;
import scala.collection.parallel.immutable.ParIterable$;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001U4qAC\u0006\u0011\u0002\u0007\u0005!\u0003C\u0003@\u0001\u0011\u0005\u0001\tC\u0003E\u0001\u0011\u0005S\t\u0003\u0004J\u0001\u0001&\tF\u0013\u0005\u0006\u001f\u0002!\t\u0005U\u0004\u0006#.A\tA\u0015\u0004\u0006\u0015-A\ta\u0015\u0005\u00065\u001a!\ta\u0017\u0005\u00069\u001a!\u0019!\u0018\u0005\u0006S\u001a!\tA\u001b\u0002\t\u0013R,'/\u00192mK*\u0011A\"D\u0001\nS6lW\u000f^1cY\u0016T!AD\b\u0002\u0015\r|G\u000e\\3di&|gNC\u0001\u0011\u0003\u0015\u00198-\u00197b\u0007\u0001)\"a\u0005\u0010\u0014\u000f\u0001!\u0002d\n\u00162kA\u0011QCF\u0007\u0002\u001f%\u0011qc\u0004\u0002\u0007\u0003:L(+\u001a4\u0011\u0007eQB$D\u0001\f\u0013\tY2BA\u0006Ue\u00064XM]:bE2,\u0007CA\u000f\u001f\u0019\u0001!aa\b\u0001\u0005\u0006\u0004\u0001#!A!\u0012\u0005\u0005\"\u0003CA\u000b#\u0013\t\u0019sBA\u0004O_RD\u0017N\\4\u0011\u0005U)\u0013B\u0001\u0014\u0010\u0005\r\te.\u001f\t\u0004Q%bR\"A\u0007\n\u0005)i\u0001\u0003B\u0016/9Aj\u0011\u0001\f\u0006\u0003[5\tqaZ3oKJL7-\u0003\u00020Y\tQr)\u001a8fe&\u001cGK]1wKJ\u001c\u0018M\u00197f)\u0016l\u0007\u000f\\1uKB\u0011\u0011\u0004\u0001\t\u0005QIbB'\u0003\u00024\u001b\ta\u0011\n^3sC\ndW\rT5lKB\u0019\u0011\u0004\u0001\u000f\u0011\t!2D\u0004O\u0005\u0003o5\u0011a\u0002U1sC2dW\r\\5{C\ndW\rE\u0002:{qi\u0011A\u000f\u0006\u0003\u0019mR!\u0001P\u0007\u0002\u0011A\f'/\u00197mK2L!A\u0010\u001e\u0003\u0017A\u000b'/\u0013;fe\u0006\u0014G.Z\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0015\u0003\u0005\u0003\"!\u0006\"\n\u0005\r{!\u0001B+oSR\f\u0011bY8na\u0006t\u0017n\u001c8\u0016\u0003\u0019\u00032aK$1\u0013\tAEF\u0001\tHK:,'/[2D_6\u0004\u0018M\\5p]\u0006Y\u0001/\u0019:D_6\u0014\u0017N\\3s+\u0005Y\u0005\u0003\u0002'N9aj\u0011aO\u0005\u0003\u001dn\u0012\u0001bQ8nE&tWM]\u0001\u0004g\u0016\fX#\u0001\u001b\u0002\u0011%#XM]1cY\u0016\u0004\"!\u0007\u0004\u0014\u0007\u0019!v\u000bE\u0002,+BJ!A\u0016\u0017\u0003+\u001d+g\u000e\u0016:bm\u0016\u00148/\u00192mK\u001a\u000b7\r^8ssB\u00191\u0006\u0017\u0019\n\u0005ec#A\u0005+sCZ,'o]1cY\u00164\u0015m\u0019;pef\fa\u0001P5oSRtD#\u0001*\u0002\u0019\r\fgNQ;jY\u00124%o\\7\u0016\u0005y;W#A0\u0011\u000b-\u0002'M\u001a5\n\u0005\u0005d#\u0001D\"b]\n+\u0018\u000e\u001c3Ge>l\u0007CA2e\u001b\u00051\u0011BA3H\u0005\u0011\u0019u\u000e\u001c7\u0011\u0005u9G!B\u0010\t\u0005\u0004\u0001\u0003cA\r\u0001M\u0006Qa.Z<Ck&dG-\u001a:\u0016\u0005-\u001cX#\u00017\u0011\t5\u0004(\u000f^\u0007\u0002]*\u0011q.D\u0001\b[V$\u0018M\u00197f\u0013\t\thNA\u0004Ck&dG-\u001a:\u0011\u0005u\u0019H!B\u0010\n\u0005\u0004\u0001\u0003cA\r\u0001e\u0002")
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

