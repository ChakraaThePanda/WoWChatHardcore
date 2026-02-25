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
import scala.collection.GenIterable;
import scala.collection.GenTraversable;
import scala.collection.Iterable;
import scala.collection.Seq;
import scala.collection.generic.CanCombineFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericParTemplate;
import scala.collection.mutable.Builder;
import scala.collection.parallel.ParIterable$;
import scala.collection.parallel.ParIterableLike;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001e4qAC\u0006\u0011\u0002\u0007\u0005!\u0003C\u0003;\u0001\u0011\u00051\bC\u0003@\u0001\u0011\u0005\u0003\tC\u0003K\u0001\u0011\u00051jB\u0003U\u0017!\u0005QKB\u0003\u000b\u0017!\u0005a\u000bC\u0003[\u000b\u0011\u00051\fC\u0003]\u000b\u0011\rQ\fC\u0003j\u000b\u0011\u0005!\u000eC\u0003s\u000b\u0011\u00051OA\u0006QCJLE/\u001a:bE2,'B\u0001\u0007\u000e\u0003!\u0001\u0018M]1mY\u0016d'B\u0001\b\u0010\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002!\u0005)1oY1mC\u000e\u0001QCA\n\u001f'\u0015\u0001A\u0003G\u00140!\t)b#D\u0001\u0010\u0013\t9rB\u0001\u0004B]f\u0014VM\u001a\t\u00043iaR\"A\u0007\n\u0005mi!aC$f]&#XM]1cY\u0016\u0004\"!\b\u0010\r\u0001\u00111q\u0004\u0001CC\u0002\u0001\u0012\u0011\u0001V\t\u0003C\u0011\u0002\"!\u0006\u0012\n\u0005\rz!a\u0002(pi\"Lgn\u001a\t\u0003+\u0015J!AJ\b\u0003\u0007\u0005s\u0017\u0010\u0005\u0003)WqiS\"A\u0015\u000b\u0005)j\u0011aB4f]\u0016\u0014\u0018nY\u0005\u0003Y%\u0012!cR3oKJL7\rU1s)\u0016l\u0007\u000f\\1uKB\u0011a\u0006A\u0007\u0002\u0017A)a\u0006\r\u000f3g%\u0011\u0011g\u0003\u0002\u0010!\u0006\u0014\u0018\n^3sC\ndW\rT5lKB\u0019a\u0006\u0001\u000f\u0011\u0007Q:DD\u0004\u0002\u0016k%\u0011agD\u0001\ba\u0006\u001c7.Y4f\u0013\tA\u0014H\u0001\u0005Ji\u0016\u0014\u0018M\u00197f\u0015\t1t\"\u0001\u0004%S:LG\u000f\n\u000b\u0002yA\u0011Q#P\u0005\u0003}=\u0011A!\u00168ji\u0006I1m\\7qC:LwN\\\u000b\u0002\u0003J\u0019!\tR$\u0007\t\r\u0003\u0001!\u0011\u0002\ryI,g-\u001b8f[\u0016tGO\u0010\t\u0004Q\u0015k\u0013B\u0001$*\u0005A9UM\\3sS\u000e\u001cu.\u001c9b]&|g\u000eE\u0002)\u00116J!!S\u0015\u0003'\u001d+g.\u001a:jGB\u000b'oQ8na\u0006t\u0017n\u001c8\u0002\u0019M$(/\u001b8h!J,g-\u001b=\u0016\u00031\u0003\"!\u0014*\u000e\u00039S!a\u0014)\u0002\t1\fgn\u001a\u0006\u0002#\u0006!!.\u0019<b\u0013\t\u0019fJ\u0001\u0004TiJLgnZ\u0001\f!\u0006\u0014\u0018\n^3sC\ndW\r\u0005\u0002/\u000bM\u0011Qa\u0016\t\u0004Qak\u0013BA-*\u0005)\u0001\u0016M\u001d$bGR|'/_\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003U\u000bAbY1o\u0005VLG\u000e\u001a$s_6,\"AX4\u0016\u0003}\u0003R\u0001\u000b1cM\"L!!Y\u0015\u0003\u001d\r\u000bgnQ8nE&tWM\u0012:p[B\u00111\rZ\u0007\u0002\u000b%\u0011Q-\u0012\u0002\u0005\u0007>dG\u000e\u0005\u0002\u001eO\u0012)qd\u0002b\u0001AA\u0019a\u0006\u00014\u0002\u00159,wOQ;jY\u0012,'/\u0006\u0002laV\tA\u000e\u0005\u0003/[>\f\u0018B\u00018\f\u0005!\u0019u.\u001c2j]\u0016\u0014\bCA\u000fq\t\u0015y\u0002B1\u0001!!\rq\u0003a\\\u0001\f]\u0016<8i\\7cS:,'/\u0006\u0002uoV\tQ\u000f\u0005\u0003/[ZD\bCA\u000fx\t\u0015y\u0012B1\u0001!!\rq\u0003A\u001e")
public interface ParIterable<T>
extends GenIterable<T>,
GenericParTemplate<T, ParIterable>,
ParIterableLike<T, ParIterable<T>, Iterable<T>> {
    public static <T> CanCombineFrom<ParIterable<?>, T, ParIterable<T>> canBuildFrom() {
        return ParIterable$.MODULE$.canBuildFrom();
    }

    public static GenTraversable iterate(Object object, int n, Function1 function1) {
        ParIterable$ parIterable$ = ParIterable$.MODULE$;
        if (parIterable$ == null) {
            throw null;
        }
        Builder iterate_b = ((GenericCompanion)parIterable$).newBuilder();
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
        return ParIterable$.MODULE$.range(object, object2, object3, integral);
    }

    public static GenTraversable range(Object object, Object object2, Integral integral) {
        return ParIterable$.MODULE$.range(object, object2, integral);
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, int n5, Function5 function5) {
        ParIterable$ parIterable$ = ParIterable$.MODULE$;
        if (parIterable$ == null) {
            throw null;
        }
        ParIterable$ tabulate_this = parIterable$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$7$adapted(tabulate_this, n2, n3, n4, n5, function5, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, Function4 function4) {
        ParIterable$ parIterable$ = ParIterable$.MODULE$;
        if (parIterable$ == null) {
            throw null;
        }
        ParIterable$ tabulate_this = parIterable$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$5$adapted(tabulate_this, n2, n3, n4, function4, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, Function3 function3) {
        ParIterable$ parIterable$ = ParIterable$.MODULE$;
        if (parIterable$ == null) {
            throw null;
        }
        ParIterable$ tabulate_this = parIterable$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$3$adapted(tabulate_this, n2, n3, function3, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, Function2 function2) {
        ParIterable$ parIterable$ = ParIterable$.MODULE$;
        if (parIterable$ == null) {
            throw null;
        }
        ParIterable$ tabulate_this = parIterable$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$1$adapted(tabulate_this, n2, function2, arg_0));
    }

    public static GenTraversable tabulate(int n, Function1 function1) {
        return ParIterable$.MODULE$.tabulate(n, function1);
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, int n5, Function0 function0) {
        ParIterable$ parIterable$ = ParIterable$.MODULE$;
        if (parIterable$ == null) {
            throw null;
        }
        ParIterable$ fill_this = parIterable$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$4$adapted(fill_this, n2, n3, n4, n5, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, Function0 function0) {
        ParIterable$ parIterable$ = ParIterable$.MODULE$;
        if (parIterable$ == null) {
            throw null;
        }
        ParIterable$ fill_this = parIterable$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$3$adapted(fill_this, n2, n3, n4, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, Function0 function0) {
        ParIterable$ parIterable$ = ParIterable$.MODULE$;
        if (parIterable$ == null) {
            throw null;
        }
        ParIterable$ fill_this = parIterable$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$2$adapted(fill_this, n2, n3, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, Function0 function0) {
        ParIterable$ parIterable$ = ParIterable$.MODULE$;
        if (parIterable$ == null) {
            throw null;
        }
        ParIterable$ fill_this = parIterable$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$1$adapted(fill_this, n2, function0, arg_0));
    }

    public static GenTraversable fill(int n, Function0 function0) {
        ParIterable$ parIterable$ = ParIterable$.MODULE$;
        if (parIterable$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)parIterable$).newBuilder();
        fill_b.sizeHint(n);
        for (int fill_i = 0; fill_i < n; ++fill_i) {
            fill_b.$plus$eq(function0.apply());
        }
        return (GenTraversable)fill_b.result();
    }

    public static GenTraversable concat(Seq seq) {
        return ParIterable$.MODULE$.concat(seq);
    }

    public static GenTraversableFactory.GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return ParIterable$.MODULE$.ReusableCBF();
    }

    public static GenTraversable apply(Seq seq) {
        return ParIterable$.MODULE$.apply(seq);
    }

    public static GenTraversable empty() {
        return ParIterable$.MODULE$.empty();
    }

    public static /* synthetic */ GenericCompanion companion$(ParIterable $this) {
        return $this.companion();
    }

    @Override
    default public GenericCompanion<ParIterable> companion() {
        return ParIterable$.MODULE$;
    }

    public static /* synthetic */ String stringPrefix$(ParIterable $this) {
        return $this.stringPrefix();
    }

    @Override
    default public String stringPrefix() {
        return "ParIterable";
    }

    public static void $init$(ParIterable $this) {
    }
}

