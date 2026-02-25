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
import scala.collection.GenIterable;
import scala.collection.GenSeq$;
import scala.collection.GenSeqLike;
import scala.collection.GenTraversable;
import scala.collection.Seq;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.mutable.Builder;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001y3q!\u0003\u0006\u0011\u0002\u0007\u0005q\u0002C\u00033\u0001\u0011\u00051\u0007C\u00038\u0001\u0019\u0005\u0001\bC\u0003=\u0001\u0011\u0005ShB\u0003B\u0015!\u0005!IB\u0003\n\u0015!\u00051\tC\u0003H\u000b\u0011\u0005\u0001\nC\u0003J\u000b\u0011\r!\nC\u0003S\u000b\u0011\u00051K\u0001\u0004HK:\u001cV-\u001d\u0006\u0003\u00171\t!bY8mY\u0016\u001cG/[8o\u0015\u0005i\u0011!B:dC2\f7\u0001A\u000b\u0003!m\u0019b\u0001A\t\u0016K!Z\u0003C\u0001\n\u0014\u001b\u0005a\u0011B\u0001\u000b\r\u0005\u0019\te.\u001f*fMB!acF\r%\u001b\u0005Q\u0011B\u0001\r\u000b\u0005)9UM\\*fc2K7.\u001a\t\u00035ma\u0001\u0001\u0002\u0004\u001d\u0001\u0011\u0015\r!\b\u0002\u0002\u0003F\u0011a$\t\t\u0003%}I!\u0001\t\u0007\u0003\u000f9{G\u000f[5oOB\u0011!CI\u0005\u0003G1\u00111!\u00118z!\r1\u0002!\u0007\t\u0004-\u0019J\u0012BA\u0014\u000b\u0005-9UM\\%uKJ\f'\r\\3\u0011\u0005II\u0013B\u0001\u0016\r\u0005\u0019)\u0015/^1mgB!AfL\r2\u001b\u0005i#B\u0001\u0018\u000b\u0003\u001d9WM\\3sS\u000eL!\u0001M\u0017\u00035\u001d+g.\u001a:jGR\u0013\u0018M^3sg\u0006\u0014G.\u001a+f[Bd\u0017\r^3\u0011\u0005Y\u0001\u0011A\u0002\u0013j]&$H\u0005F\u00015!\t\u0011R'\u0003\u00027\u0019\t!QK\\5u\u0003\r\u0019X-]\u000b\u0002sA\u0019aCO\r\n\u0005mR!aA*fc\u0006I1m\\7qC:LwN\\\u000b\u0002}A\u0019AfP\u0019\n\u0005\u0001k#\u0001E$f]\u0016\u0014\u0018nY\"p[B\fg.[8o\u0003\u00199UM\\*fcB\u0011a#B\n\u0003\u000b\u0011\u00032\u0001L#2\u0013\t1UFA\u000bHK:$&/\u0019<feN\f'\r\\3GC\u000e$xN]=\u0002\rqJg.\u001b;?)\u0005\u0011\u0015\u0001D2b]\n+\u0018\u000e\u001c3Ge>lWCA&R+\u0005a\u0005cA'O!6\tQ!\u0003\u0002P\u000b\n\u0019r)\u001a8fe&\u001c7)\u00198Ck&dGM\u0012:p[B\u0011!$\u0015\u0003\u00069\u001d\u0011\r!H\u0001\u000b]\u0016<()^5mI\u0016\u0014XC\u0001+]+\u0005)\u0006\u0003\u0002,Z7vk\u0011a\u0016\u0006\u00031*\tq!\\;uC\ndW-\u0003\u0002[/\n9!)^5mI\u0016\u0014\bC\u0001\u000e]\t\u0015a\u0002B1\u0001\u001e!\r1\"h\u0017")
public interface GenSeq<A>
extends GenSeqLike<A, GenSeq<A>>,
GenIterable<A> {
    public static <A> GenTraversableFactory.GenericCanBuildFrom<A> canBuildFrom() {
        return GenSeq$.MODULE$.canBuildFrom();
    }

    public static GenTraversable iterate(Object object, int n, Function1 function1) {
        GenSeq$ genSeq$ = GenSeq$.MODULE$;
        if (genSeq$ == null) {
            throw null;
        }
        Builder iterate_b = ((GenericCompanion)genSeq$).newBuilder();
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
        return GenSeq$.MODULE$.range(object, object2, object3, integral);
    }

    public static GenTraversable range(Object object, Object object2, Integral integral) {
        return GenSeq$.MODULE$.range(object, object2, integral);
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, int n5, Function5 function5) {
        GenSeq$ genSeq$ = GenSeq$.MODULE$;
        if (genSeq$ == null) {
            throw null;
        }
        GenSeq$ tabulate_this = genSeq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$7$adapted(tabulate_this, n2, n3, n4, n5, function5, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, Function4 function4) {
        GenSeq$ genSeq$ = GenSeq$.MODULE$;
        if (genSeq$ == null) {
            throw null;
        }
        GenSeq$ tabulate_this = genSeq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$5$adapted(tabulate_this, n2, n3, n4, function4, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, Function3 function3) {
        GenSeq$ genSeq$ = GenSeq$.MODULE$;
        if (genSeq$ == null) {
            throw null;
        }
        GenSeq$ tabulate_this = genSeq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$3$adapted(tabulate_this, n2, n3, function3, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, Function2 function2) {
        GenSeq$ genSeq$ = GenSeq$.MODULE$;
        if (genSeq$ == null) {
            throw null;
        }
        GenSeq$ tabulate_this = genSeq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$1$adapted(tabulate_this, n2, function2, arg_0));
    }

    public static GenTraversable tabulate(int n, Function1 function1) {
        return GenSeq$.MODULE$.tabulate(n, function1);
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, int n5, Function0 function0) {
        GenSeq$ genSeq$ = GenSeq$.MODULE$;
        if (genSeq$ == null) {
            throw null;
        }
        GenSeq$ fill_this = genSeq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$4$adapted(fill_this, n2, n3, n4, n5, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, Function0 function0) {
        GenSeq$ genSeq$ = GenSeq$.MODULE$;
        if (genSeq$ == null) {
            throw null;
        }
        GenSeq$ fill_this = genSeq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$3$adapted(fill_this, n2, n3, n4, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, Function0 function0) {
        GenSeq$ genSeq$ = GenSeq$.MODULE$;
        if (genSeq$ == null) {
            throw null;
        }
        GenSeq$ fill_this = genSeq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$2$adapted(fill_this, n2, n3, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, Function0 function0) {
        GenSeq$ genSeq$ = GenSeq$.MODULE$;
        if (genSeq$ == null) {
            throw null;
        }
        GenSeq$ fill_this = genSeq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$1$adapted(fill_this, n2, function0, arg_0));
    }

    public static GenTraversable fill(int n, Function0 function0) {
        GenSeq$ genSeq$ = GenSeq$.MODULE$;
        if (genSeq$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)genSeq$).newBuilder();
        fill_b.sizeHint(n);
        for (int fill_i = 0; fill_i < n; ++fill_i) {
            fill_b.$plus$eq(function0.apply());
        }
        return (GenTraversable)fill_b.result();
    }

    public static GenTraversable concat(Seq seq) {
        return GenSeq$.MODULE$.concat(seq);
    }

    public static GenTraversableFactory.GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return GenSeq$.MODULE$.ReusableCBF();
    }

    public static GenTraversable empty() {
        return GenSeq$.MODULE$.empty();
    }

    @Override
    public Seq<A> seq();

    public static /* synthetic */ GenericCompanion companion$(GenSeq $this) {
        return $this.companion();
    }

    @Override
    default public GenericCompanion<GenSeq> companion() {
        return GenSeq$.MODULE$;
    }

    public static void $init$(GenSeq $this) {
    }
}

