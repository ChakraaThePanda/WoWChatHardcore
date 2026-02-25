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
import scala.collection.GenIterable$;
import scala.collection.GenIterableLike;
import scala.collection.GenTraversable;
import scala.collection.Iterable;
import scala.collection.Seq;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.mutable.Builder;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001m3q!\u0003\u0006\u0011\u0002\u0007\u0005q\u0002C\u00030\u0001\u0011\u0005\u0001\u0007C\u00035\u0001\u0019\u0005Q\u0007C\u0003:\u0001\u0011\u0005#hB\u0003?\u0015!\u0005qHB\u0003\n\u0015!\u0005\u0001\tC\u0003E\u000b\u0011\u0005Q\tC\u0003G\u000b\u0011\rq\tC\u0003P\u000b\u0011\u0005\u0001KA\u0006HK:LE/\u001a:bE2,'BA\u0006\r\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002\u001b\u0005)1oY1mC\u000e\u0001QC\u0001\t\u001c'\u0015\u0001\u0011#F\u0013)!\t\u00112#D\u0001\r\u0013\t!BB\u0001\u0004B]f\u0014VM\u001a\t\u0005-]IB%D\u0001\u000b\u0013\tA\"BA\bHK:LE/\u001a:bE2,G*[6f!\tQ2\u0004\u0004\u0001\u0005\rq\u0001AQ1\u0001\u001e\u0005\u0005\t\u0015C\u0001\u0010\"!\t\u0011r$\u0003\u0002!\u0019\t9aj\u001c;iS:<\u0007C\u0001\n#\u0013\t\u0019CBA\u0002B]f\u00042A\u0006\u0001\u001a!\r1b%G\u0005\u0003O)\u0011abR3o)J\fg/\u001a:tC\ndW\r\u0005\u0003*YeqS\"\u0001\u0016\u000b\u0005-R\u0011aB4f]\u0016\u0014\u0018nY\u0005\u0003[)\u0012!dR3oKJL7\r\u0016:bm\u0016\u00148/\u00192mKR+W\u000e\u001d7bi\u0016\u0004\"A\u0006\u0001\u0002\r\u0011Jg.\u001b;%)\u0005\t\u0004C\u0001\n3\u0013\t\u0019DB\u0001\u0003V]&$\u0018aA:fcV\ta\u0007E\u0002\u0017oeI!\u0001\u000f\u0006\u0003\u0011%#XM]1cY\u0016\f\u0011bY8na\u0006t\u0017n\u001c8\u0016\u0003m\u00022!\u000b\u001f/\u0013\ti$F\u0001\tHK:,'/[2D_6\u0004\u0018M\\5p]\u0006Yq)\u001a8Ji\u0016\u0014\u0018M\u00197f!\t1Ra\u0005\u0002\u0006\u0003B\u0019\u0011F\u0011\u0018\n\u0005\rS#!F$f]R\u0013\u0018M^3sg\u0006\u0014G.\u001a$bGR|'/_\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003}\nAbY1o\u0005VLG\u000e\u001a$s_6,\"\u0001\u0013(\u0016\u0003%\u00032AS&N\u001b\u0005)\u0011B\u0001'C\u0005M9UM\\3sS\u000e\u001c\u0015M\u001c\"vS2$gI]8n!\tQb\nB\u0003\u001d\u000f\t\u0007Q$\u0001\u0006oK^\u0014U/\u001b7eKJ,\"!U-\u0016\u0003I\u0003Ba\u0015,Y56\tAK\u0003\u0002V\u0015\u00059Q.\u001e;bE2,\u0017BA,U\u0005\u001d\u0011U/\u001b7eKJ\u0004\"AG-\u0005\u000bqA!\u0019A\u000f\u0011\u0007Y9\u0004\f")
public interface GenIterable<A>
extends GenIterableLike<A, GenIterable<A>>,
GenTraversable<A> {
    public static <A> GenTraversableFactory.GenericCanBuildFrom<A> canBuildFrom() {
        return GenIterable$.MODULE$.canBuildFrom();
    }

    public static GenTraversable iterate(Object object, int n, Function1 function1) {
        GenIterable$ genIterable$ = GenIterable$.MODULE$;
        if (genIterable$ == null) {
            throw null;
        }
        Builder iterate_b = ((GenericCompanion)genIterable$).newBuilder();
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
        return GenIterable$.MODULE$.range(object, object2, object3, integral);
    }

    public static GenTraversable range(Object object, Object object2, Integral integral) {
        return GenIterable$.MODULE$.range(object, object2, integral);
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, int n5, Function5 function5) {
        GenIterable$ genIterable$ = GenIterable$.MODULE$;
        if (genIterable$ == null) {
            throw null;
        }
        GenIterable$ tabulate_this = genIterable$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$7$adapted(tabulate_this, n2, n3, n4, n5, function5, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, Function4 function4) {
        GenIterable$ genIterable$ = GenIterable$.MODULE$;
        if (genIterable$ == null) {
            throw null;
        }
        GenIterable$ tabulate_this = genIterable$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$5$adapted(tabulate_this, n2, n3, n4, function4, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, Function3 function3) {
        GenIterable$ genIterable$ = GenIterable$.MODULE$;
        if (genIterable$ == null) {
            throw null;
        }
        GenIterable$ tabulate_this = genIterable$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$3$adapted(tabulate_this, n2, n3, function3, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, Function2 function2) {
        GenIterable$ genIterable$ = GenIterable$.MODULE$;
        if (genIterable$ == null) {
            throw null;
        }
        GenIterable$ tabulate_this = genIterable$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$1$adapted(tabulate_this, n2, function2, arg_0));
    }

    public static GenTraversable tabulate(int n, Function1 function1) {
        return GenIterable$.MODULE$.tabulate(n, function1);
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, int n5, Function0 function0) {
        GenIterable$ genIterable$ = GenIterable$.MODULE$;
        if (genIterable$ == null) {
            throw null;
        }
        GenIterable$ fill_this = genIterable$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$4$adapted(fill_this, n2, n3, n4, n5, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, Function0 function0) {
        GenIterable$ genIterable$ = GenIterable$.MODULE$;
        if (genIterable$ == null) {
            throw null;
        }
        GenIterable$ fill_this = genIterable$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$3$adapted(fill_this, n2, n3, n4, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, Function0 function0) {
        GenIterable$ genIterable$ = GenIterable$.MODULE$;
        if (genIterable$ == null) {
            throw null;
        }
        GenIterable$ fill_this = genIterable$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$2$adapted(fill_this, n2, n3, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, Function0 function0) {
        GenIterable$ genIterable$ = GenIterable$.MODULE$;
        if (genIterable$ == null) {
            throw null;
        }
        GenIterable$ fill_this = genIterable$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$1$adapted(fill_this, n2, function0, arg_0));
    }

    public static GenTraversable fill(int n, Function0 function0) {
        GenIterable$ genIterable$ = GenIterable$.MODULE$;
        if (genIterable$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)genIterable$).newBuilder();
        fill_b.sizeHint(n);
        for (int fill_i = 0; fill_i < n; ++fill_i) {
            fill_b.$plus$eq(function0.apply());
        }
        return (GenTraversable)fill_b.result();
    }

    public static GenTraversable concat(Seq seq) {
        return GenIterable$.MODULE$.concat(seq);
    }

    public static GenTraversableFactory.GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return GenIterable$.MODULE$.ReusableCBF();
    }

    public static GenTraversable apply(Seq seq) {
        return GenIterable$.MODULE$.apply(seq);
    }

    public static GenTraversable empty() {
        return GenIterable$.MODULE$.empty();
    }

    @Override
    public Iterable<A> seq();

    public static /* synthetic */ GenericCompanion companion$(GenIterable $this) {
        return $this.companion();
    }

    @Override
    default public GenericCompanion<GenIterable> companion() {
        return GenIterable$.MODULE$;
    }

    public static void $init$(GenIterable $this) {
    }
}

