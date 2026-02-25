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
import scala.collection.LinearSeq$;
import scala.collection.LinearSeqLike;
import scala.collection.Seq;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.mutable.Builder;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001q3q!\u0003\u0006\u0011\u0002\u0007\u0005q\u0002C\u00030\u0001\u0011\u0005\u0001\u0007C\u00035\u0001\u0011\u0005S\u0007C\u0003:\u0001\u0011\u0005#hB\u0003<\u0015!\u0005AHB\u0003\n\u0015!\u0005Q\bC\u0003B\u000b\u0011\u0005!\tC\u0003D\u000b\u0011\rA\tC\u0003Q\u000b\u0011\u0005\u0011KA\u0005MS:,\u0017M]*fc*\u00111\u0002D\u0001\u000bG>dG.Z2uS>t'\"A\u0007\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0011\u0001cG\n\u0006\u0001E)Be\u000b\t\u0003%Mi\u0011\u0001D\u0005\u0003)1\u0011a!\u00118z%\u00164\u0007c\u0001\f\u001835\t!\"\u0003\u0002\u0019\u0015\t\u00191+Z9\u0011\u0005iYB\u0002\u0001\u0003\u00079\u0001!)\u0019A\u000f\u0003\u0003\u0005\u000b\"AH\u0011\u0011\u0005Iy\u0012B\u0001\u0011\r\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"A\u0005\u0012\n\u0005\rb!aA!osB!Q\u0005K\r+\u001b\u00051#BA\u0014\u000b\u0003\u001d9WM\\3sS\u000eL!!\u000b\u0014\u00035\u001d+g.\u001a:jGR\u0013\u0018M^3sg\u0006\u0014G.\u001a+f[Bd\u0017\r^3\u0011\u0005Y\u0001\u0001\u0003\u0002\f-39J!!\f\u0006\u0003\u001b1Kg.Z1s'\u0016\fH*[6f!\r1\u0002!G\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0015\u0003E\u0002\"A\u0005\u001a\n\u0005Mb!\u0001B+oSR\f\u0011bY8na\u0006t\u0017n\u001c8\u0016\u0003Y\u00022!J\u001c+\u0013\tAdE\u0001\tHK:,'/[2D_6\u0004\u0018M\\5p]\u0006\u00191/Z9\u0016\u00039\n\u0011\u0002T5oK\u0006\u00148+Z9\u0011\u0005Y)1CA\u0003?!\r)sHK\u0005\u0003\u0001\u001a\u0012!bU3r\r\u0006\u001cGo\u001c:z\u0003\u0019a\u0014N\\5u}Q\tA(\u0001\u0007dC:\u0014U/\u001b7e\rJ|W.\u0006\u0002F\u001dV\ta\tE\u0003&\u000f&ku*\u0003\u0002IM\ta1)\u00198Ck&dGM\u0012:p[B\u0011!jS\u0007\u0002\u000b%\u0011Aj\u000e\u0002\u0005\u0007>dG\u000e\u0005\u0002\u001b\u001d\u0012)Ad\u0002b\u0001;A\u0019a\u0003A'\u0002\u00159,wOQ;jY\u0012,'/\u0006\u0002S5V\t1\u000b\u0005\u0003U/f[V\"A+\u000b\u0005YS\u0011aB7vi\u0006\u0014G.Z\u0005\u00031V\u0013qAQ;jY\u0012,'\u000f\u0005\u0002\u001b5\u0012)A\u0004\u0003b\u0001;A\u0019a\u0003A-")
public interface LinearSeq<A>
extends Seq<A>,
LinearSeqLike<A, LinearSeq<A>> {
    public static <A> CanBuildFrom<LinearSeq<?>, A, LinearSeq<A>> canBuildFrom() {
        return LinearSeq$.MODULE$.canBuildFrom();
    }

    public static Some unapplySeq(Seq seq) {
        return LinearSeq$.MODULE$.unapplySeq(seq);
    }

    public static GenTraversable iterate(Object object, int n, Function1 function1) {
        LinearSeq$ linearSeq$ = LinearSeq$.MODULE$;
        if (linearSeq$ == null) {
            throw null;
        }
        Builder iterate_b = ((GenericCompanion)linearSeq$).newBuilder();
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
        return LinearSeq$.MODULE$.range(object, object2, object3, integral);
    }

    public static GenTraversable range(Object object, Object object2, Integral integral) {
        return LinearSeq$.MODULE$.range(object, object2, integral);
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, int n5, Function5 function5) {
        LinearSeq$ linearSeq$ = LinearSeq$.MODULE$;
        if (linearSeq$ == null) {
            throw null;
        }
        LinearSeq$ tabulate_this = linearSeq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$7$adapted(tabulate_this, n2, n3, n4, n5, function5, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, Function4 function4) {
        LinearSeq$ linearSeq$ = LinearSeq$.MODULE$;
        if (linearSeq$ == null) {
            throw null;
        }
        LinearSeq$ tabulate_this = linearSeq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$5$adapted(tabulate_this, n2, n3, n4, function4, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, Function3 function3) {
        LinearSeq$ linearSeq$ = LinearSeq$.MODULE$;
        if (linearSeq$ == null) {
            throw null;
        }
        LinearSeq$ tabulate_this = linearSeq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$3$adapted(tabulate_this, n2, n3, function3, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, Function2 function2) {
        LinearSeq$ linearSeq$ = LinearSeq$.MODULE$;
        if (linearSeq$ == null) {
            throw null;
        }
        LinearSeq$ tabulate_this = linearSeq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$1$adapted(tabulate_this, n2, function2, arg_0));
    }

    public static GenTraversable tabulate(int n, Function1 function1) {
        return LinearSeq$.MODULE$.tabulate(n, function1);
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, int n5, Function0 function0) {
        LinearSeq$ linearSeq$ = LinearSeq$.MODULE$;
        if (linearSeq$ == null) {
            throw null;
        }
        LinearSeq$ fill_this = linearSeq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$4$adapted(fill_this, n2, n3, n4, n5, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, Function0 function0) {
        LinearSeq$ linearSeq$ = LinearSeq$.MODULE$;
        if (linearSeq$ == null) {
            throw null;
        }
        LinearSeq$ fill_this = linearSeq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$3$adapted(fill_this, n2, n3, n4, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, Function0 function0) {
        LinearSeq$ linearSeq$ = LinearSeq$.MODULE$;
        if (linearSeq$ == null) {
            throw null;
        }
        LinearSeq$ fill_this = linearSeq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$2$adapted(fill_this, n2, n3, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, Function0 function0) {
        LinearSeq$ linearSeq$ = LinearSeq$.MODULE$;
        if (linearSeq$ == null) {
            throw null;
        }
        LinearSeq$ fill_this = linearSeq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$1$adapted(fill_this, n2, function0, arg_0));
    }

    public static GenTraversable fill(int n, Function0 function0) {
        LinearSeq$ linearSeq$ = LinearSeq$.MODULE$;
        if (linearSeq$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)linearSeq$).newBuilder();
        fill_b.sizeHint(n);
        for (int fill_i = 0; fill_i < n; ++fill_i) {
            fill_b.$plus$eq(function0.apply());
        }
        return (GenTraversable)fill_b.result();
    }

    public static GenTraversable concat(Seq seq) {
        return LinearSeq$.MODULE$.concat(seq);
    }

    public static GenTraversableFactory.GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return LinearSeq$.MODULE$.ReusableCBF();
    }

    public static GenTraversable empty() {
        return LinearSeq$.MODULE$.empty();
    }

    public static /* synthetic */ GenericCompanion companion$(LinearSeq $this) {
        return $this.companion();
    }

    @Override
    default public GenericCompanion<LinearSeq> companion() {
        return LinearSeq$.MODULE$;
    }

    public static /* synthetic */ LinearSeq seq$(LinearSeq $this) {
        return $this.seq();
    }

    @Override
    default public LinearSeq<A> seq() {
        return this;
    }

    public static void $init$(LinearSeq $this) {
    }
}

