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
import scala.collection.Seq;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.immutable.LinearSeq$;
import scala.collection.mutable.Builder;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u00054q!\u0003\u0006\u0011\u0002\u0007\u0005\u0011\u0003C\u00035\u0001\u0011\u0005Q\u0007C\u0003:\u0001\u0011\u0005#\bC\u0003?\u0001\u0011\u0005shB\u0003A\u0015!\u0005\u0011IB\u0003\n\u0015!\u0005!\tC\u0003G\u000b\u0011\u0005q\tC\u0003I\u000b\u0011\r\u0011\nC\u0003V\u000b\u0011\u0005aKA\u0005MS:,\u0017M]*fc*\u00111\u0002D\u0001\nS6lW\u000f^1cY\u0016T!!\u0004\b\u0002\u0015\r|G\u000e\\3di&|gNC\u0001\u0010\u0003\u0015\u00198-\u00197b\u0007\u0001)\"AE\u000f\u0014\r\u0001\u0019rCJ\u00151!\t!R#D\u0001\u000f\u0013\t1bB\u0001\u0004B]f\u0014VM\u001a\t\u00041eYR\"\u0001\u0006\n\u0005iQ!aA*fcB\u0011A$\b\u0007\u0001\t\u0019q\u0002\u0001\"b\u0001?\t\t\u0011)\u0005\u0002!GA\u0011A#I\u0005\u0003E9\u0011qAT8uQ&tw\r\u0005\u0002\u0015I%\u0011QE\u0004\u0002\u0004\u0003:L\bcA\u0014)75\tA\"\u0003\u0002\n\u0019A!!&L\u000e0\u001b\u0005Y#B\u0001\u0017\r\u0003\u001d9WM\\3sS\u000eL!AL\u0016\u00035\u001d+g.\u001a:jGR\u0013\u0018M^3sg\u0006\u0014G.\u001a+f[Bd\u0017\r^3\u0011\u0005a\u0001\u0001\u0003B\u001427MJ!A\r\u0007\u0003\u001b1Kg.Z1s'\u0016\fH*[6f!\rA\u0002aG\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0015\u0003Y\u0002\"\u0001F\u001c\n\u0005ar!\u0001B+oSR\f\u0011bY8na\u0006t\u0017n\u001c8\u0016\u0003m\u00022A\u000b\u001f0\u0013\ti4F\u0001\tHK:,'/[2D_6\u0004\u0018M\\5p]\u0006\u00191/Z9\u0016\u0003M\n\u0011\u0002T5oK\u0006\u00148+Z9\u0011\u0005a)1CA\u0003D!\rQCiL\u0005\u0003\u000b.\u0012!bU3r\r\u0006\u001cGo\u001c:z\u0003\u0019a\u0014N\\5u}Q\t\u0011)\u0001\u0007dC:\u0014U/\u001b7e\rJ|W.\u0006\u0002K'V\t1\nE\u0003+\u0019:\u0013F+\u0003\u0002NW\ta1)\u00198Ck&dGM\u0012:p[B\u0011q\nU\u0007\u0002\u000b%\u0011\u0011\u000b\u0010\u0002\u0005\u0007>dG\u000e\u0005\u0002\u001d'\u0012)ad\u0002b\u0001?A\u0019\u0001\u0004\u0001*\u0002\u00159,wOQ;jY\u0012,'/\u0006\u0002X?V\t\u0001\f\u0005\u0003Z9z\u0003W\"\u0001.\u000b\u0005mc\u0011aB7vi\u0006\u0014G.Z\u0005\u0003;j\u0013qAQ;jY\u0012,'\u000f\u0005\u0002\u001d?\u0012)a\u0004\u0003b\u0001?A\u0019\u0001\u0004\u00010")
public interface LinearSeq<A>
extends scala.collection.immutable.Seq<A>,
scala.collection.LinearSeq<A> {
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

