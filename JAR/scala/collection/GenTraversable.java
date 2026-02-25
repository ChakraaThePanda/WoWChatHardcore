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
import scala.collection.GenTraversable$;
import scala.collection.GenTraversableLike;
import scala.collection.Seq;
import scala.collection.Traversable;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.mutable.Builder;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001m3q!\u0003\u0006\u0011\u0002\u0007\u0005q\u0002C\u00030\u0001\u0011\u0005\u0001\u0007C\u00035\u0001\u0019\u0005Q\u0007C\u0003:\u0001\u0011\u0005!hB\u0003?\u0015!\u0005qHB\u0003\n\u0015!\u0005\u0001\tC\u0003E\u000b\u0011\u0005Q\tC\u0003G\u000b\u0011\rq\tC\u0003P\u000b\u0011\u0005\u0001K\u0001\bHK:$&/\u0019<feN\f'\r\\3\u000b\u0005-a\u0011AC2pY2,7\r^5p]*\tQ\"A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u0005AY2#\u0002\u0001\u0012+\u0015B\u0003C\u0001\n\u0014\u001b\u0005a\u0011B\u0001\u000b\r\u0005\u0019\te.\u001f*fMB!acF\r%\u001b\u0005Q\u0011B\u0001\r\u000b\u0005I9UM\u001c+sCZ,'o]1cY\u0016d\u0015n[3\u0011\u0005iYB\u0002\u0001\u0003\u00079\u0001!)\u0019A\u000f\u0003\u0003\u0005\u000b\"AH\u0011\u0011\u0005Iy\u0012B\u0001\u0011\r\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"A\u0005\u0012\n\u0005\rb!aA!osB\u0019a\u0003A\r\u0011\u0007Y1\u0013$\u0003\u0002(\u0015\t\u0011r)\u001a8Ue\u00064XM]:bE2,wJ\\2f!\u0011IC&\u0007\u0018\u000e\u0003)R!a\u000b\u0006\u0002\u000f\u001d,g.\u001a:jG&\u0011QF\u000b\u0002\u001b\u000f\u0016tWM]5d)J\fg/\u001a:tC\ndW\rV3na2\fG/\u001a\t\u0003-\u0001\ta\u0001J5oSR$C#A\u0019\u0011\u0005I\u0011\u0014BA\u001a\r\u0005\u0011)f.\u001b;\u0002\u0007M,\u0017/F\u00017!\r1r'G\u0005\u0003q)\u00111\u0002\u0016:bm\u0016\u00148/\u00192mK\u0006I1m\\7qC:LwN\\\u000b\u0002wA\u0019\u0011\u0006\u0010\u0018\n\u0005uR#\u0001E$f]\u0016\u0014\u0018nY\"p[B\fg.[8o\u000399UM\u001c+sCZ,'o]1cY\u0016\u0004\"AF\u0003\u0014\u0005\u0015\t\u0005cA\u0015C]%\u00111I\u000b\u0002\u0016\u000f\u0016tGK]1wKJ\u001c\u0018M\u00197f\r\u0006\u001cGo\u001c:z\u0003\u0019a\u0014N\\5u}Q\tq(\u0001\u0007dC:\u0014U/\u001b7e\rJ|W.\u0006\u0002I\u001dV\t\u0011\nE\u0002K\u00176k\u0011!B\u0005\u0003\u0019\n\u00131cR3oKJL7mQ1o\u0005VLG\u000e\u001a$s_6\u0004\"A\u0007(\u0005\u000bq9!\u0019A\u000f\u0002\u00159,wOQ;jY\u0012,'/\u0006\u0002R3V\t!\u000b\u0005\u0003T-bSV\"\u0001+\u000b\u0005US\u0011aB7vi\u0006\u0014G.Z\u0005\u0003/R\u0013qAQ;jY\u0012,'\u000f\u0005\u0002\u001b3\u0012)A\u0004\u0003b\u0001;A\u0019ac\u000e-")
public interface GenTraversable<A>
extends GenTraversableLike<A, GenTraversable<A>>,
GenericTraversableTemplate<A, GenTraversable> {
    public static <A> GenTraversableFactory.GenericCanBuildFrom<A> canBuildFrom() {
        return GenTraversable$.MODULE$.canBuildFrom();
    }

    public static <A> GenTraversable<A> iterate(A a, int n, Function1<A, A> function1) {
        GenTraversable$ genTraversable$ = GenTraversable$.MODULE$;
        if (genTraversable$ == null) {
            throw null;
        }
        Builder iterate_b = ((GenericCompanion)genTraversable$).newBuilder();
        if (n > 0) {
            iterate_b.sizeHint(n);
            A iterate_acc = a;
            iterate_b.$plus$eq(a);
            for (int iterate_i = 1; iterate_i < n; ++iterate_i) {
                iterate_acc = function1.apply(iterate_acc);
                iterate_b.$plus$eq(iterate_acc);
            }
        }
        return (GenTraversable)iterate_b.result();
    }

    public static <T> GenTraversable<T> range(T t, T t2, T t3, Integral<T> integral) {
        return GenTraversable$.MODULE$.range(t, t2, t3, integral);
    }

    public static <T> GenTraversable<T> range(T t, T t2, Integral<T> integral) {
        return GenTraversable$.MODULE$.range(t, t2, integral);
    }

    public static <A> GenTraversable<GenTraversable<GenTraversable<GenTraversable<GenTraversable<A>>>>> tabulate(int n, int n2, int n3, int n4, int n5, Function5<Object, Object, Object, Object, Object, A> function5) {
        GenTraversable$ genTraversable$ = GenTraversable$.MODULE$;
        if (genTraversable$ == null) {
            throw null;
        }
        GenTraversable$ tabulate_this = genTraversable$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$7$adapted(tabulate_this, n2, n3, n4, n5, function5, arg_0));
    }

    public static <A> GenTraversable<GenTraversable<GenTraversable<GenTraversable<A>>>> tabulate(int n, int n2, int n3, int n4, Function4<Object, Object, Object, Object, A> function4) {
        GenTraversable$ genTraversable$ = GenTraversable$.MODULE$;
        if (genTraversable$ == null) {
            throw null;
        }
        GenTraversable$ tabulate_this = genTraversable$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$5$adapted(tabulate_this, n2, n3, n4, function4, arg_0));
    }

    public static <A> GenTraversable<GenTraversable<GenTraversable<A>>> tabulate(int n, int n2, int n3, Function3<Object, Object, Object, A> function3) {
        GenTraversable$ genTraversable$ = GenTraversable$.MODULE$;
        if (genTraversable$ == null) {
            throw null;
        }
        GenTraversable$ tabulate_this = genTraversable$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$3$adapted(tabulate_this, n2, n3, function3, arg_0));
    }

    public static <A> GenTraversable<GenTraversable<A>> tabulate(int n, int n2, Function2<Object, Object, A> function2) {
        GenTraversable$ genTraversable$ = GenTraversable$.MODULE$;
        if (genTraversable$ == null) {
            throw null;
        }
        GenTraversable$ tabulate_this = genTraversable$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$1$adapted(tabulate_this, n2, function2, arg_0));
    }

    public static <A> GenTraversable<A> tabulate(int n, Function1<Object, A> function1) {
        return GenTraversable$.MODULE$.tabulate(n, function1);
    }

    public static <A> GenTraversable<GenTraversable<GenTraversable<GenTraversable<GenTraversable<A>>>>> fill(int n, int n2, int n3, int n4, int n5, Function0<A> function0) {
        GenTraversable$ genTraversable$ = GenTraversable$.MODULE$;
        if (genTraversable$ == null) {
            throw null;
        }
        GenTraversable$ fill_this = genTraversable$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$4$adapted(fill_this, n2, n3, n4, n5, function0, arg_0));
    }

    public static <A> GenTraversable<GenTraversable<GenTraversable<GenTraversable<A>>>> fill(int n, int n2, int n3, int n4, Function0<A> function0) {
        GenTraversable$ genTraversable$ = GenTraversable$.MODULE$;
        if (genTraversable$ == null) {
            throw null;
        }
        GenTraversable$ fill_this = genTraversable$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$3$adapted(fill_this, n2, n3, n4, function0, arg_0));
    }

    public static <A> GenTraversable<GenTraversable<GenTraversable<A>>> fill(int n, int n2, int n3, Function0<A> function0) {
        GenTraversable$ genTraversable$ = GenTraversable$.MODULE$;
        if (genTraversable$ == null) {
            throw null;
        }
        GenTraversable$ fill_this = genTraversable$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$2$adapted(fill_this, n2, n3, function0, arg_0));
    }

    public static <A> GenTraversable<GenTraversable<A>> fill(int n, int n2, Function0<A> function0) {
        GenTraversable$ genTraversable$ = GenTraversable$.MODULE$;
        if (genTraversable$ == null) {
            throw null;
        }
        GenTraversable$ fill_this = genTraversable$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$1$adapted(fill_this, n2, function0, arg_0));
    }

    public static <A> GenTraversable<A> fill(int n, Function0<A> function0) {
        GenTraversable$ genTraversable$ = GenTraversable$.MODULE$;
        if (genTraversable$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)genTraversable$).newBuilder();
        fill_b.sizeHint(n);
        for (int fill_i = 0; fill_i < n; ++fill_i) {
            fill_b.$plus$eq(function0.apply());
        }
        return (GenTraversable)fill_b.result();
    }

    public static <A> GenTraversable<A> concat(Seq<Traversable<A>> seq) {
        return GenTraversable$.MODULE$.concat(seq);
    }

    public static GenTraversableFactory.GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return GenTraversable$.MODULE$.ReusableCBF();
    }

    public static <A> GenTraversable<A> apply(Seq<A> seq) {
        return GenTraversable$.MODULE$.apply(seq);
    }

    public static <A> GenTraversable<A> empty() {
        return GenTraversable$.MODULE$.empty();
    }

    @Override
    public Traversable<A> seq();

    public static /* synthetic */ GenericCompanion companion$(GenTraversable $this) {
        return $this.companion();
    }

    @Override
    default public GenericCompanion<GenTraversable> companion() {
        return GenTraversable$.MODULE$;
    }

    public static void $init$(GenTraversable $this) {
    }
}

