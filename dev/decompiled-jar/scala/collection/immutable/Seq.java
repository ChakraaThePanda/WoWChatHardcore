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
import scala.Some;
import scala.collection.GenTraversable;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.immutable.Iterable;
import scala.collection.immutable.Seq$;
import scala.collection.mutable.Builder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.immutable.ParSeq;
import scala.collection.parallel.immutable.ParSeq$;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001Q4qa\u0003\u0007\u0011\u0002\u0007\u00051\u0003C\u0003A\u0001\u0011\u0005\u0011\tC\u0003F\u0001\u0011\u0005c\tC\u0003K\u0001\u0011\u00053\nC\u0003M\u0001\u0011\u00053\n\u0003\u0004N\u0001\u0001&\tFT\u0004\u0006'2A\t\u0001\u0016\u0004\u0006\u00171A\t!\u0016\u0005\u00063\u001e!\tA\u0017\u0005\u00067\u001e!\u0019\u0001\u0018\u0005\u0006Q\u001e!\t!\u001b\u0002\u0004'\u0016\f(BA\u0007\u000f\u0003%IW.\\;uC\ndWM\u0003\u0002\u0010!\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003E\tQa]2bY\u0006\u001c\u0001!\u0006\u0002\u0015?M9\u0001!F\r)WI2\u0004C\u0001\f\u0018\u001b\u0005\u0001\u0012B\u0001\r\u0011\u0005\u0019\te.\u001f*fMB\u0019!dG\u000f\u000e\u00031I!\u0001\b\u0007\u0003\u0011%#XM]1cY\u0016\u0004\"AH\u0010\r\u0001\u00111\u0001\u0005\u0001CC\u0002\u0005\u0012\u0011!Q\t\u0003E\u0015\u0002\"AF\u0012\n\u0005\u0011\u0002\"a\u0002(pi\"Lgn\u001a\t\u0003-\u0019J!a\n\t\u0003\u0007\u0005s\u0017\u0010E\u0002*Uui\u0011AD\u0005\u0003\u00179\u0001B\u0001L\u0018\u001ec5\tQF\u0003\u0002/\u001d\u00059q-\u001a8fe&\u001c\u0017B\u0001\u0019.\u0005i9UM\\3sS\u000e$&/\u0019<feN\f'\r\\3UK6\u0004H.\u0019;f!\tQ\u0002\u0001\u0005\u0003*gu)\u0014B\u0001\u001b\u000f\u0005\u001d\u0019V-\u001d'jW\u0016\u00042A\u0007\u0001\u001e!\u0011Is'H\u001d\n\u0005ar!A\u0004)be\u0006dG.\u001a7ju\u0006\u0014G.\u001a\t\u0004uyjR\"A\u001e\u000b\u00055a$BA\u001f\u000f\u0003!\u0001\u0018M]1mY\u0016d\u0017BA <\u0005\u0019\u0001\u0016M]*fc\u00061A%\u001b8ji\u0012\"\u0012A\u0011\t\u0003-\rK!\u0001\u0012\t\u0003\tUs\u0017\u000e^\u0001\nG>l\u0007/\u00198j_:,\u0012a\u0012\t\u0004Y!\u000b\u0014BA%.\u0005A9UM\\3sS\u000e\u001cu.\u001c9b]&|g.A\u0003u_N+\u0017/F\u00016\u0003\r\u0019X-]\u0001\fa\u0006\u00148i\\7cS:,'/F\u0001P!\u0011\u0001\u0016+H\u001d\u000e\u0003qJ!A\u0015\u001f\u0003\u0011\r{WNY5oKJ\f1aU3r!\tQra\u0005\u0002\b-B\u0019AfV\u0019\n\u0005ak#AC*fc\u001a\u000b7\r^8ss\u00061A(\u001b8jiz\"\u0012\u0001V\u0001\rG\u0006t')^5mI\u001a\u0013x.\\\u000b\u0003;\u001a,\u0012A\u0018\t\u0006Y}\u000bWmZ\u0005\u0003A6\u0012AbQ1o\u0005VLG\u000e\u001a$s_6\u0004\"AY2\u000e\u0003\u001dI!\u0001\u001a%\u0003\t\r{G\u000e\u001c\t\u0003=\u0019$Q\u0001I\u0005C\u0002\u0005\u00022A\u0007\u0001f\u0003)qWm\u001e\"vS2$WM]\u000b\u0003UJ,\u0012a\u001b\t\u0005Y>\f8/D\u0001n\u0015\tqg\"A\u0004nkR\f'\r\\3\n\u0005Al'a\u0002\"vS2$WM\u001d\t\u0003=I$Q\u0001\t\u0006C\u0002\u0005\u00022A\u0007\u0001r\u0001")
public interface Seq<A>
extends Iterable<A>,
scala.collection.Seq<A> {
    public static <A> CanBuildFrom<Seq<?>, A, Seq<A>> canBuildFrom() {
        return Seq$.MODULE$.canBuildFrom();
    }

    public static Some unapplySeq(scala.collection.Seq seq) {
        return Seq$.MODULE$.unapplySeq(seq);
    }

    public static GenTraversable iterate(Object object, int n, Function1 function1) {
        Seq$ seq$ = Seq$.MODULE$;
        if (seq$ == null) {
            throw null;
        }
        Builder iterate_b = ((GenericCompanion)seq$).newBuilder();
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
        return Seq$.MODULE$.range(object, object2, object3, integral);
    }

    public static GenTraversable range(Object object, Object object2, Integral integral) {
        return Seq$.MODULE$.range(object, object2, integral);
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, int n5, Function5 function5) {
        Seq$ seq$ = Seq$.MODULE$;
        if (seq$ == null) {
            throw null;
        }
        Seq$ tabulate_this = seq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$7$adapted(tabulate_this, n2, n3, n4, n5, function5, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, Function4 function4) {
        Seq$ seq$ = Seq$.MODULE$;
        if (seq$ == null) {
            throw null;
        }
        Seq$ tabulate_this = seq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$5$adapted(tabulate_this, n2, n3, n4, function4, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, Function3 function3) {
        Seq$ seq$ = Seq$.MODULE$;
        if (seq$ == null) {
            throw null;
        }
        Seq$ tabulate_this = seq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$3$adapted(tabulate_this, n2, n3, function3, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, Function2 function2) {
        Seq$ seq$ = Seq$.MODULE$;
        if (seq$ == null) {
            throw null;
        }
        Seq$ tabulate_this = seq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$1$adapted(tabulate_this, n2, function2, arg_0));
    }

    public static GenTraversable tabulate(int n, Function1 function1) {
        return Seq$.MODULE$.tabulate(n, function1);
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, int n5, Function0 function0) {
        Seq$ seq$ = Seq$.MODULE$;
        if (seq$ == null) {
            throw null;
        }
        Seq$ fill_this = seq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$4$adapted(fill_this, n2, n3, n4, n5, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, Function0 function0) {
        Seq$ seq$ = Seq$.MODULE$;
        if (seq$ == null) {
            throw null;
        }
        Seq$ fill_this = seq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$3$adapted(fill_this, n2, n3, n4, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, Function0 function0) {
        Seq$ seq$ = Seq$.MODULE$;
        if (seq$ == null) {
            throw null;
        }
        Seq$ fill_this = seq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$2$adapted(fill_this, n2, n3, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, Function0 function0) {
        Seq$ seq$ = Seq$.MODULE$;
        if (seq$ == null) {
            throw null;
        }
        Seq$ fill_this = seq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$1$adapted(fill_this, n2, function0, arg_0));
    }

    public static GenTraversable fill(int n, Function0 function0) {
        Seq$ seq$ = Seq$.MODULE$;
        if (seq$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)seq$).newBuilder();
        fill_b.sizeHint(n);
        for (int fill_i = 0; fill_i < n; ++fill_i) {
            fill_b.$plus$eq(function0.apply());
        }
        return (GenTraversable)fill_b.result();
    }

    public static GenTraversable concat(scala.collection.Seq seq) {
        return Seq$.MODULE$.concat(seq);
    }

    public static GenTraversableFactory.GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return Seq$.MODULE$.ReusableCBF();
    }

    public static GenTraversable empty() {
        return Seq$.MODULE$.empty();
    }

    public static /* synthetic */ GenericCompanion companion$(Seq $this) {
        return $this.companion();
    }

    @Override
    default public GenericCompanion<Seq> companion() {
        return Seq$.MODULE$;
    }

    public static /* synthetic */ Seq toSeq$(Seq $this) {
        return $this.toSeq();
    }

    @Override
    default public Seq<A> toSeq() {
        return this;
    }

    public static /* synthetic */ Seq seq$(Seq $this) {
        return $this.seq();
    }

    @Override
    default public Seq<A> seq() {
        return this;
    }

    public static /* synthetic */ Combiner parCombiner$(Seq $this) {
        return $this.parCombiner();
    }

    @Override
    default public Combiner<A, ParSeq<A>> parCombiner() {
        return ParSeq$.MODULE$.newCombiner();
    }

    public static void $init$(Seq $this) {
    }
}

