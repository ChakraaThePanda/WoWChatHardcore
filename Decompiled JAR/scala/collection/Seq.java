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
import scala.PartialFunction;
import scala.Some;
import scala.collection.GenSeq;
import scala.collection.GenTraversable;
import scala.collection.Iterable;
import scala.collection.Seq$;
import scala.collection.SeqLike;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.mutable.Builder;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u00154q!\u0003\u0006\u0011\u0002\u0007\u0005q\u0002C\u00039\u0001\u0011\u0005\u0011\bC\u0003>\u0001\u0011\u0005c\bC\u0003C\u0001\u0011\u00053iB\u0003E\u0015!\u0005QIB\u0003\n\u0015!\u0005a\tC\u0003K\u000b\u0011\u00051\nC\u0003M\u000b\u0011\rQ\nC\u0003Z\u000b\u0011\u0005!LA\u0002TKFT!a\u0003\u0007\u0002\u0015\r|G\u000e\\3di&|gNC\u0001\u000e\u0003\u0015\u00198-\u00197b\u0007\u0001)\"\u0001E\u000f\u0014\u000f\u0001\tRC\n\u0016.iA\u0011!cE\u0007\u0002\u0019%\u0011A\u0003\u0004\u0002\u0007\u0003:L(+\u001a4\u0011\tI1\u0002dG\u0005\u0003/1\u0011q\u0002U1si&\fGNR;oGRLwN\u001c\t\u0003%eI!A\u0007\u0007\u0003\u0007%sG\u000f\u0005\u0002\u001d;1\u0001AA\u0002\u0010\u0001\t\u000b\u0007qDA\u0001B#\t\u00013\u0005\u0005\u0002\u0013C%\u0011!\u0005\u0004\u0002\b\u001d>$\b.\u001b8h!\t\u0011B%\u0003\u0002&\u0019\t\u0019\u0011I\\=\u0011\u0007\u001dB3$D\u0001\u000b\u0013\tI#B\u0001\u0005Ji\u0016\u0014\u0018M\u00197f!\r93fG\u0005\u0003Y)\u0011aaR3o'\u0016\f\b\u0003\u0002\u001827Mj\u0011a\f\u0006\u0003a)\tqaZ3oKJL7-\u0003\u00023_\tQr)\u001a8fe&\u001cGK]1wKJ\u001c\u0018M\u00197f)\u0016l\u0007\u000f\\1uKB\u0011q\u0005\u0001\t\u0005OUZr'\u0003\u00027\u0015\t91+Z9MS.,\u0007cA\u0014\u00017\u00051A%\u001b8ji\u0012\"\u0012A\u000f\t\u0003%mJ!\u0001\u0010\u0007\u0003\tUs\u0017\u000e^\u0001\nG>l\u0007/\u00198j_:,\u0012a\u0010\t\u0004]\u0001\u001b\u0014BA!0\u0005A9UM\\3sS\u000e\u001cu.\u001c9b]&|g.A\u0002tKF,\u0012aN\u0001\u0004'\u0016\f\bCA\u0014\u0006'\t)q\tE\u0002/\u0011NJ!!S\u0018\u0003\u0015M+\u0017OR1di>\u0014\u00180\u0001\u0004=S:LGO\u0010\u000b\u0002\u000b\u0006a1-\u00198Ck&dGM\u0012:p[V\u0011ajV\u000b\u0002\u001fB)a\u0006\u0015*W1&\u0011\u0011k\f\u0002\r\u0007\u0006t')^5mI\u001a\u0013x.\u001c\t\u0003'Rk\u0011!B\u0005\u0003+\u0002\u0013AaQ8mYB\u0011Ad\u0016\u0003\u0006=\u001d\u0011\ra\b\t\u0004O\u00011\u0016A\u00038fo\n+\u0018\u000e\u001c3feV\u00111lY\u000b\u00029B!Q\f\u00192e\u001b\u0005q&BA0\u000b\u0003\u001diW\u000f^1cY\u0016L!!\u00190\u0003\u000f\t+\u0018\u000e\u001c3feB\u0011Ad\u0019\u0003\u0006=!\u0011\ra\b\t\u0004O\u0001\u0011\u0007")
public interface Seq<A>
extends PartialFunction<Object, A>,
Iterable<A>,
GenSeq<A>,
SeqLike<A, Seq<A>> {
    public static <A> CanBuildFrom<Seq<?>, A, Seq<A>> canBuildFrom() {
        return Seq$.MODULE$.canBuildFrom();
    }

    public static <A> Some<Seq<A>> unapplySeq(Seq<A> seq) {
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

    public static GenTraversable concat(Seq seq) {
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

    public static /* synthetic */ Seq seq$(Seq $this) {
        return $this.seq();
    }

    @Override
    default public Seq<A> seq() {
        return this;
    }

    public static void $init$(Seq $this) {
    }
}

