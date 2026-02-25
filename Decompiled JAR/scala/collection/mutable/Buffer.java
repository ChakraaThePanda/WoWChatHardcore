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
import scala.collection.mutable.Buffer$;
import scala.collection.mutable.BufferLike;
import scala.collection.mutable.Builder;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001m3q\u0001C\u0005\u0011\u0002\u0007\u0005\u0001\u0003C\u00034\u0001\u0011\u0005A\u0007C\u00039\u0001\u0011\u0005\u0013hB\u0003>\u0013!\u0005aHB\u0003\t\u0013!\u0005q\bC\u0003D\t\u0011\u0005A\tC\u0003F\t\u0011\ra\tC\u0003S\t\u0011\u00051K\u0001\u0004Ck\u001a4WM\u001d\u0006\u0003\u0015-\tq!\\;uC\ndWM\u0003\u0002\r\u001b\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u00039\tQa]2bY\u0006\u001c\u0001!\u0006\u0002\u00129M1\u0001A\u0005\f&YA\u0002\"a\u0005\u000b\u000e\u00035I!!F\u0007\u0003\r\u0005s\u0017PU3g!\r9\u0002DG\u0007\u0002\u0013%\u0011\u0011$\u0003\u0002\u0004'\u0016\f\bCA\u000e\u001d\u0019\u0001!Q!\b\u0001C\u0002y\u0011\u0011!Q\t\u0003?\t\u0002\"a\u0005\u0011\n\u0005\u0005j!a\u0002(pi\"Lgn\u001a\t\u0003'\rJ!\u0001J\u0007\u0003\u0007\u0005s\u0017\u0010\u0005\u0003'SiYS\"A\u0014\u000b\u0005!Z\u0011aB4f]\u0016\u0014\u0018nY\u0005\u0003U\u001d\u0012!dR3oKJL7\r\u0016:bm\u0016\u00148/\u00192mKR+W\u000e\u001d7bi\u0016\u0004\"a\u0006\u0001\u0011\t]i#dL\u0005\u0003]%\u0011!BQ;gM\u0016\u0014H*[6f!\r9\u0002A\u0007\t\u0003'EJ!AM\u0007\u0003\u0013\rcwN\\3bE2,\u0017A\u0002\u0013j]&$H\u0005F\u00016!\t\u0019b'\u0003\u00028\u001b\t!QK\\5u\u0003%\u0019w.\u001c9b]&|g.F\u0001;!\r13hK\u0005\u0003y\u001d\u0012\u0001cR3oKJL7mQ8na\u0006t\u0017n\u001c8\u0002\r\t+hMZ3s!\t9Ba\u0005\u0002\u0005\u0001B\u0019a%Q\u0016\n\u0005\t;#AC*fc\u001a\u000b7\r^8ss\u00061A(\u001b8jiz\"\u0012AP\u0001\rG\u0006t')^5mI\u001a\u0013x.\\\u000b\u0003\u000fB+\u0012\u0001\u0013\t\u0006M%[u*U\u0005\u0003\u0015\u001e\u0012AbQ1o\u0005VLG\u000e\u001a$s_6\u0004\"\u0001T'\u000e\u0003\u0011I!AT\u001e\u0003\t\r{G\u000e\u001c\t\u00037A#Q!\b\u0004C\u0002y\u00012a\u0006\u0001P\u0003)qWm\u001e\"vS2$WM]\u000b\u0003)f+\u0012!\u0016\t\u0005/YC&,\u0003\u0002X\u0013\t9!)^5mI\u0016\u0014\bCA\u000eZ\t\u0015irA1\u0001\u001f!\r9\u0002\u0001\u0017")
public interface Buffer<A>
extends scala.collection.mutable.Seq<A>,
BufferLike<A, Buffer<A>> {
    public static <A> CanBuildFrom<Buffer<?>, A, Buffer<A>> canBuildFrom() {
        return Buffer$.MODULE$.canBuildFrom();
    }

    public static Some unapplySeq(Seq seq) {
        return Buffer$.MODULE$.unapplySeq(seq);
    }

    public static GenTraversable iterate(Object object, int n, Function1 function1) {
        Buffer$ buffer$ = Buffer$.MODULE$;
        if (buffer$ == null) {
            throw null;
        }
        Builder iterate_b = ((GenericCompanion)buffer$).newBuilder();
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
        return Buffer$.MODULE$.range(object, object2, object3, integral);
    }

    public static GenTraversable range(Object object, Object object2, Integral integral) {
        return Buffer$.MODULE$.range(object, object2, integral);
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, int n5, Function5 function5) {
        Buffer$ buffer$ = Buffer$.MODULE$;
        if (buffer$ == null) {
            throw null;
        }
        Buffer$ tabulate_this = buffer$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$7$adapted(tabulate_this, n2, n3, n4, n5, function5, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, Function4 function4) {
        Buffer$ buffer$ = Buffer$.MODULE$;
        if (buffer$ == null) {
            throw null;
        }
        Buffer$ tabulate_this = buffer$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$5$adapted(tabulate_this, n2, n3, n4, function4, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, Function3 function3) {
        Buffer$ buffer$ = Buffer$.MODULE$;
        if (buffer$ == null) {
            throw null;
        }
        Buffer$ tabulate_this = buffer$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$3$adapted(tabulate_this, n2, n3, function3, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, Function2 function2) {
        Buffer$ buffer$ = Buffer$.MODULE$;
        if (buffer$ == null) {
            throw null;
        }
        Buffer$ tabulate_this = buffer$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$1$adapted(tabulate_this, n2, function2, arg_0));
    }

    public static GenTraversable tabulate(int n, Function1 function1) {
        return Buffer$.MODULE$.tabulate(n, function1);
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, int n5, Function0 function0) {
        Buffer$ buffer$ = Buffer$.MODULE$;
        if (buffer$ == null) {
            throw null;
        }
        Buffer$ fill_this = buffer$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$4$adapted(fill_this, n2, n3, n4, n5, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, Function0 function0) {
        Buffer$ buffer$ = Buffer$.MODULE$;
        if (buffer$ == null) {
            throw null;
        }
        Buffer$ fill_this = buffer$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$3$adapted(fill_this, n2, n3, n4, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, Function0 function0) {
        Buffer$ buffer$ = Buffer$.MODULE$;
        if (buffer$ == null) {
            throw null;
        }
        Buffer$ fill_this = buffer$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$2$adapted(fill_this, n2, n3, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, Function0 function0) {
        Buffer$ buffer$ = Buffer$.MODULE$;
        if (buffer$ == null) {
            throw null;
        }
        Buffer$ fill_this = buffer$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$1$adapted(fill_this, n2, function0, arg_0));
    }

    public static GenTraversable fill(int n, Function0 function0) {
        Buffer$ buffer$ = Buffer$.MODULE$;
        if (buffer$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)buffer$).newBuilder();
        fill_b.sizeHint(n);
        for (int fill_i = 0; fill_i < n; ++fill_i) {
            fill_b.$plus$eq(function0.apply());
        }
        return (GenTraversable)fill_b.result();
    }

    public static GenTraversable concat(Seq seq) {
        return Buffer$.MODULE$.concat(seq);
    }

    public static GenTraversableFactory.GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return Buffer$.MODULE$.ReusableCBF();
    }

    public static GenTraversable empty() {
        return Buffer$.MODULE$.empty();
    }

    public static /* synthetic */ GenericCompanion companion$(Buffer $this) {
        return $this.companion();
    }

    @Override
    default public GenericCompanion<Buffer> companion() {
        return Buffer$.MODULE$;
    }

    public static void $init$(Buffer $this) {
    }
}

