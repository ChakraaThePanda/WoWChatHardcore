/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.Function4;
import scala.Function5;
import scala.collection.GenSeq;
import scala.collection.GenTraversable;
import scala.collection.Seq;
import scala.collection.generic.CanCombineFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.mutable.Builder;
import scala.collection.parallel.ParIterable;
import scala.collection.parallel.ParIterableLike;
import scala.collection.parallel.ParSeq$;
import scala.collection.parallel.ParSeqLike;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0005\rba\u0002\u0007\u000e!\u0003\r\t\u0001\u0006\u0005\u0006\u007f\u0001!\t\u0001\u0011\u0005\u0006\t\u0002!\t%\u0012\u0005\u0006\u001f\u00021\t\u0001\u0015\u0005\u0006-\u0002!\te\u0016\u0005\u0006G\u0002!\t\u0005Z\u0004\u0006Y6A\t!\u001c\u0004\u0006\u00195A\tA\u001c\u0005\u0006e\u001e!\ta\u001d\u0005\u0006i\u001e!\u0019!\u001e\u0005\b\u0003\u00079A\u0011AA\u0003\u0011\u001d\t)b\u0002C\u0001\u0003/\u0011a\u0001U1s'\u0016\f(B\u0001\b\u0010\u0003!\u0001\u0018M]1mY\u0016d'B\u0001\t\u0012\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002%\u0005)1oY1mC\u000e\u0001QCA\u000b!'\u0019\u0001aCG\u0015.iA\u0011q\u0003G\u0007\u0002#%\u0011\u0011$\u0005\u0002\u0007\u0003:L(+\u001a4\u0011\u0007mab$D\u0001\u0010\u0013\tirB\u0001\u0004HK:\u001cV-\u001d\t\u0003?\u0001b\u0001\u0001\u0002\u0004\"\u0001\u0011\u0015\rA\t\u0002\u0002)F\u00111E\n\t\u0003/\u0011J!!J\t\u0003\u000f9{G\u000f[5oOB\u0011qcJ\u0005\u0003QE\u00111!\u00118z!\rQ3FH\u0007\u0002\u001b%\u0011A&\u0004\u0002\f!\u0006\u0014\u0018\n^3sC\ndW\r\u0005\u0003/cy\u0019T\"A\u0018\u000b\u0005Az\u0011aB4f]\u0016\u0014\u0018nY\u0005\u0003e=\u0012!cR3oKJL7\rU1s)\u0016l\u0007\u000f\\1uKB\u0011!\u0006\u0001\t\u0006UUrr\u0007O\u0005\u0003m5\u0011!\u0002U1s'\u0016\fH*[6f!\rQ\u0003A\b\t\u0004sqrbBA\f;\u0013\tY\u0014#A\u0004qC\u000e\\\u0017mZ3\n\u0005ur$aA*fc*\u00111(E\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0015\u0003\u0005\u0003\"a\u0006\"\n\u0005\r\u000b\"\u0001B+oSR\f\u0011bY8na\u0006t\u0017n\u001c8\u0016\u0003\u0019\u00132aR%M\r\u0011A\u0005\u0001\u0001$\u0003\u0019q\u0012XMZ5oK6,g\u000e\u001e \u0011\u00079R5'\u0003\u0002L_\t\u0001r)\u001a8fe&\u001c7i\\7qC:LwN\u001c\t\u0004]5\u001b\u0014B\u0001(0\u0005M9UM\\3sS\u000e\u0004\u0016M]\"p[B\fg.[8o\u0003\u0015\t\u0007\u000f\u001d7z)\tq\u0012\u000bC\u0003S\u0007\u0001\u00071+A\u0001j!\t9B+\u0003\u0002V#\t\u0019\u0011J\u001c;\u0002\u0011Q|7\u000b\u001e:j]\u001e$\u0012\u0001\u0017\t\u00033\u0002t!A\u00170\u0011\u0005m\u000bR\"\u0001/\u000b\u0005u\u001b\u0012A\u0002\u001fs_>$h(\u0003\u0002`#\u00051\u0001K]3eK\u001aL!!\u00192\u0003\rM#(/\u001b8h\u0015\ty\u0016#\u0001\u0007tiJLgn\u001a)sK\u001aL\u00070F\u0001f!\t17.D\u0001h\u0015\tA\u0017.\u0001\u0003mC:<'\"\u00016\u0002\t)\fg/Y\u0005\u0003C\u001e\fa\u0001U1s'\u0016\f\bC\u0001\u0016\b'\t9q\u000eE\u0002/aNJ!!]\u0018\u0003\u0015A\u000b'OR1di>\u0014\u00180\u0001\u0004=S:LGO\u0010\u000b\u0002[\u0006a1-\u00198Ck&dGM\u0012:p[V\u0011ao`\u000b\u0002oB1a\u0006\u001f>\u007f\u0003\u0003I!!_\u0018\u0003\u001d\r\u000bgnQ8nE&tWM\u0012:p[B\u00111\u0010`\u0007\u0002\u000f%\u0011QP\u0013\u0002\u0005\u0007>dG\u000e\u0005\u0002 \u007f\u0012)\u0011%\u0003b\u0001EA\u0019!\u0006\u0001@\u0002\u00159,wOQ;jY\u0012,'/\u0006\u0003\u0002\b\u0005EQCAA\u0005!\u001dQ\u00131BA\b\u0003'I1!!\u0004\u000e\u0005!\u0019u.\u001c2j]\u0016\u0014\bcA\u0010\u0002\u0012\u0011)\u0011E\u0003b\u0001EA!!\u0006AA\b\u0003-qWm^\"p[\nLg.\u001a:\u0016\t\u0005e\u0011qD\u000b\u0003\u00037\u0001rAKA\u0006\u0003;\t\t\u0003E\u0002 \u0003?!Q!I\u0006C\u0002\t\u0002BA\u000b\u0001\u0002\u001e\u0001")
public interface ParSeq<T>
extends GenSeq<T>,
ParIterable<T>,
ParSeqLike<T, ParSeq<T>, Seq<T>> {
    public static <T> CanCombineFrom<ParSeq<?>, T, ParSeq<T>> canBuildFrom() {
        return ParSeq$.MODULE$.canBuildFrom();
    }

    public static GenTraversable iterate(Object object, int n, Function1 function1) {
        ParSeq$ parSeq$ = ParSeq$.MODULE$;
        if (parSeq$ == null) {
            throw null;
        }
        Builder iterate_b = ((GenericCompanion)parSeq$).newBuilder();
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
        return ParSeq$.MODULE$.range(object, object2, object3, integral);
    }

    public static GenTraversable range(Object object, Object object2, Integral integral) {
        return ParSeq$.MODULE$.range(object, object2, integral);
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, int n5, Function5 function5) {
        ParSeq$ parSeq$ = ParSeq$.MODULE$;
        if (parSeq$ == null) {
            throw null;
        }
        ParSeq$ tabulate_this = parSeq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$7$adapted(tabulate_this, n2, n3, n4, n5, function5, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, Function4 function4) {
        ParSeq$ parSeq$ = ParSeq$.MODULE$;
        if (parSeq$ == null) {
            throw null;
        }
        ParSeq$ tabulate_this = parSeq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$5$adapted(tabulate_this, n2, n3, n4, function4, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, Function3 function3) {
        ParSeq$ parSeq$ = ParSeq$.MODULE$;
        if (parSeq$ == null) {
            throw null;
        }
        ParSeq$ tabulate_this = parSeq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$3$adapted(tabulate_this, n2, n3, function3, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, Function2 function2) {
        ParSeq$ parSeq$ = ParSeq$.MODULE$;
        if (parSeq$ == null) {
            throw null;
        }
        ParSeq$ tabulate_this = parSeq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$1$adapted(tabulate_this, n2, function2, arg_0));
    }

    public static GenTraversable tabulate(int n, Function1 function1) {
        return ParSeq$.MODULE$.tabulate(n, function1);
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, int n5, Function0 function0) {
        ParSeq$ parSeq$ = ParSeq$.MODULE$;
        if (parSeq$ == null) {
            throw null;
        }
        ParSeq$ fill_this = parSeq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$4$adapted(fill_this, n2, n3, n4, n5, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, Function0 function0) {
        ParSeq$ parSeq$ = ParSeq$.MODULE$;
        if (parSeq$ == null) {
            throw null;
        }
        ParSeq$ fill_this = parSeq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$3$adapted(fill_this, n2, n3, n4, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, Function0 function0) {
        ParSeq$ parSeq$ = ParSeq$.MODULE$;
        if (parSeq$ == null) {
            throw null;
        }
        ParSeq$ fill_this = parSeq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$2$adapted(fill_this, n2, n3, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, Function0 function0) {
        ParSeq$ parSeq$ = ParSeq$.MODULE$;
        if (parSeq$ == null) {
            throw null;
        }
        ParSeq$ fill_this = parSeq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$1$adapted(fill_this, n2, function0, arg_0));
    }

    public static GenTraversable fill(int n, Function0 function0) {
        ParSeq$ parSeq$ = ParSeq$.MODULE$;
        if (parSeq$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)parSeq$).newBuilder();
        fill_b.sizeHint(n);
        for (int fill_i = 0; fill_i < n; ++fill_i) {
            fill_b.$plus$eq(function0.apply());
        }
        return (GenTraversable)fill_b.result();
    }

    public static GenTraversable concat(Seq seq) {
        return ParSeq$.MODULE$.concat(seq);
    }

    public static GenTraversableFactory.GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return ParSeq$.MODULE$.ReusableCBF();
    }

    public static GenTraversable empty() {
        return ParSeq$.MODULE$.empty();
    }

    public static /* synthetic */ GenericCompanion companion$(ParSeq $this) {
        return $this.companion();
    }

    @Override
    default public GenericCompanion<ParSeq> companion() {
        return ParSeq$.MODULE$;
    }

    @Override
    public T apply(int var1);

    public static /* synthetic */ String toString$(ParSeq $this) {
        return $this.toString();
    }

    @Override
    default public String toString() {
        return ParIterableLike.toString$(this);
    }

    public static /* synthetic */ String stringPrefix$(ParSeq $this) {
        return $this.stringPrefix();
    }

    @Override
    default public String stringPrefix() {
        return this.getClass().getSimpleName();
    }

    public static void $init$(ParSeq $this) {
    }
}

