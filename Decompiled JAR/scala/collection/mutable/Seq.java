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
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.mutable.Builder;
import scala.collection.mutable.Iterable;
import scala.collection.mutable.Seq$;
import scala.collection.mutable.SeqLike;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001y3q!\u0003\u0006\u0011\u0002\u0007\u0005\u0011\u0003C\u00035\u0001\u0011\u0005Q\u0007C\u0003:\u0001\u0011\u0005#\bC\u0003?\u0001\u0011\u0005shB\u0003A\u0015!\u0005\u0011IB\u0003\n\u0015!\u0005!\tC\u0003G\u000b\u0011\u0005q\tC\u0003I\u000b\u0011\r\u0011\nC\u0003V\u000b\u0011\u0005aKA\u0002TKFT!a\u0003\u0007\u0002\u000f5,H/\u00192mK*\u0011QBD\u0001\u000bG>dG.Z2uS>t'\"A\b\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0011!#H\n\u0007\u0001M9b%\u000b\u0019\u0011\u0005Q)R\"\u0001\b\n\u0005Yq!AB!osJ+g\rE\u0002\u00193mi\u0011AC\u0005\u00035)\u0011\u0001\"\u0013;fe\u0006\u0014G.\u001a\t\u00039ua\u0001\u0001B\u0003\u001f\u0001\t\u0007qDA\u0001B#\t\u00013\u0005\u0005\u0002\u0015C%\u0011!E\u0004\u0002\b\u001d>$\b.\u001b8h!\t!B%\u0003\u0002&\u001d\t\u0019\u0011I\\=\u0011\u0007\u001dB3$D\u0001\r\u0013\tIA\u0002\u0005\u0003+[myS\"A\u0016\u000b\u00051b\u0011aB4f]\u0016\u0014\u0018nY\u0005\u0003]-\u0012!dR3oKJL7\r\u0016:bm\u0016\u00148/\u00192mKR+W\u000e\u001d7bi\u0016\u0004\"\u0001\u0007\u0001\u0011\ta\t4dM\u0005\u0003e)\u0011qaU3r\u0019&\\W\rE\u0002\u0019\u0001m\ta\u0001J5oSR$C#\u0001\u001c\u0011\u0005Q9\u0014B\u0001\u001d\u000f\u0005\u0011)f.\u001b;\u0002\u0013\r|W\u000e]1oS>tW#A\u001e\u0011\u0007)bt&\u0003\u0002>W\t\u0001r)\u001a8fe&\u001c7i\\7qC:LwN\\\u0001\u0004g\u0016\fX#A\u001a\u0002\u0007M+\u0017\u000f\u0005\u0002\u0019\u000bM\u0011Qa\u0011\t\u0004U\u0011{\u0013BA#,\u0005)\u0019V-\u001d$bGR|'/_\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003\u0005\u000bAbY1o\u0005VLG\u000e\u001a$s_6,\"AS*\u0016\u0003-\u0003RA\u000b'O%RK!!T\u0016\u0003\u0019\r\u000bgNQ;jY\u00124%o\\7\u0011\u0005=\u0003V\"A\u0003\n\u0005Ec$\u0001B\"pY2\u0004\"\u0001H*\u0005\u000by9!\u0019A\u0010\u0011\u0007a\u0001!+\u0001\u0006oK^\u0014U/\u001b7eKJ,\"a\u0016/\u0016\u0003a\u0003B\u0001G-\\;&\u0011!L\u0003\u0002\b\u0005VLG\u000eZ3s!\taB\fB\u0003\u001f\u0011\t\u0007q\u0004E\u0002\u0019\u0001m\u0003")
public interface Seq<A>
extends Iterable<A>,
scala.collection.Seq<A>,
SeqLike<A, Seq<A>> {
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

