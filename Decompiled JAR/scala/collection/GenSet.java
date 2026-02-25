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
import scala.collection.GenSet$;
import scala.collection.GenSetLike;
import scala.collection.GenTraversable;
import scala.collection.Seq;
import scala.collection.Set;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericSetTemplate;
import scala.collection.mutable.Builder;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001}3q!\u0003\u0006\u0011\u0002\u0007\u0005q\u0002C\u00030\u0001\u0011\u0005\u0001\u0007C\u00035\u0001\u0011\u0005S\u0007C\u0003:\u0001\u0019\u0005!hB\u0003?\u0015!\u0005qHB\u0003\n\u0015!\u0005\u0001\tC\u0003E\u000b\u0011\u0005Q\tC\u0003G\u000b\u0011\rq\tC\u0003P\u000b\u0011\u0005\u0001K\u0001\u0004HK:\u001cV\r\u001e\u0006\u0003\u00171\t!bY8mY\u0016\u001cG/[8o\u0015\u0005i\u0011!B:dC2\f7\u0001A\u000b\u0003!m\u0019R\u0001A\t\u0016K!\u0002\"AE\n\u000e\u00031I!\u0001\u0006\u0007\u0003\r\u0005s\u0017PU3g!\u00111r#\u0007\u0013\u000e\u0003)I!\u0001\u0007\u0006\u0003\u0015\u001d+gnU3u\u0019&\\W\r\u0005\u0002\u001b71\u0001A!\u0002\u000f\u0001\u0005\u0004i\"!A!\u0012\u0005y\t\u0003C\u0001\n \u0013\t\u0001CBA\u0004O_RD\u0017N\\4\u0011\u0005I\u0011\u0013BA\u0012\r\u0005\r\te.\u001f\t\u0004-\u0001I\u0002c\u0001\f'3%\u0011qE\u0003\u0002\f\u000f\u0016t\u0017\n^3sC\ndW\r\u0005\u0003*YeqS\"\u0001\u0016\u000b\u0005-R\u0011aB4f]\u0016\u0014\u0018nY\u0005\u0003[)\u0012!cR3oKJL7mU3u)\u0016l\u0007\u000f\\1uKB\u0011a\u0003A\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0015\u0003E\u0002\"A\u0005\u001a\n\u0005Mb!\u0001B+oSR\f\u0011bY8na\u0006t\u0017n\u001c8\u0016\u0003Y\u00022!K\u001c/\u0013\tA$F\u0001\tHK:,'/[2D_6\u0004\u0018M\\5p]\u0006\u00191/Z9\u0016\u0003m\u00022A\u0006\u001f\u001a\u0013\ti$BA\u0002TKR\faaR3o'\u0016$\bC\u0001\f\u0006'\t)\u0011\tE\u0002*\u0005:J!a\u0011\u0016\u0003+\u001d+g\u000e\u0016:bm\u0016\u00148/\u00192mK\u001a\u000b7\r^8ss\u00061A(\u001b8jiz\"\u0012aP\u0001\rG\u0006t')^5mI\u001a\u0013x.\\\u000b\u0003\u0011:+\u0012!\u0013\t\u0004\u0015.kU\"A\u0003\n\u00051\u0013%aE$f]\u0016\u0014\u0018nY\"b]\n+\u0018\u000e\u001c3Ge>l\u0007C\u0001\u000eO\t\u0015arA1\u0001\u001e\u0003)qWm\u001e\"vS2$WM]\u000b\u0003#f+\u0012A\u0015\t\u0005'ZC&,D\u0001U\u0015\t)&\"A\u0004nkR\f'\r\\3\n\u0005]#&a\u0002\"vS2$WM\u001d\t\u00035e#Q\u0001\b\u0005C\u0002u\u00012a\u00170Y\u001b\u0005a&BA/\u000b\u0003%IW.\\;uC\ndW-\u0003\u0002>9\u0002")
public interface GenSet<A>
extends GenSetLike<A, GenSet<A>>,
GenIterable<A>,
GenericSetTemplate<A, GenSet> {
    public static <A> GenTraversableFactory.GenericCanBuildFrom<A> canBuildFrom() {
        return GenSet$.MODULE$.canBuildFrom();
    }

    public static GenTraversable iterate(Object object, int n, Function1 function1) {
        GenSet$ genSet$ = GenSet$.MODULE$;
        if (genSet$ == null) {
            throw null;
        }
        Builder iterate_b = ((GenericCompanion)genSet$).newBuilder();
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
        return GenSet$.MODULE$.range(object, object2, object3, integral);
    }

    public static GenTraversable range(Object object, Object object2, Integral integral) {
        return GenSet$.MODULE$.range(object, object2, integral);
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, int n5, Function5 function5) {
        GenSet$ genSet$ = GenSet$.MODULE$;
        if (genSet$ == null) {
            throw null;
        }
        GenSet$ tabulate_this = genSet$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$7$adapted(tabulate_this, n2, n3, n4, n5, function5, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, Function4 function4) {
        GenSet$ genSet$ = GenSet$.MODULE$;
        if (genSet$ == null) {
            throw null;
        }
        GenSet$ tabulate_this = genSet$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$5$adapted(tabulate_this, n2, n3, n4, function4, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, Function3 function3) {
        GenSet$ genSet$ = GenSet$.MODULE$;
        if (genSet$ == null) {
            throw null;
        }
        GenSet$ tabulate_this = genSet$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$3$adapted(tabulate_this, n2, n3, function3, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, Function2 function2) {
        GenSet$ genSet$ = GenSet$.MODULE$;
        if (genSet$ == null) {
            throw null;
        }
        GenSet$ tabulate_this = genSet$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$1$adapted(tabulate_this, n2, function2, arg_0));
    }

    public static GenTraversable tabulate(int n, Function1 function1) {
        return GenSet$.MODULE$.tabulate(n, function1);
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, int n5, Function0 function0) {
        GenSet$ genSet$ = GenSet$.MODULE$;
        if (genSet$ == null) {
            throw null;
        }
        GenSet$ fill_this = genSet$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$4$adapted(fill_this, n2, n3, n4, n5, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, Function0 function0) {
        GenSet$ genSet$ = GenSet$.MODULE$;
        if (genSet$ == null) {
            throw null;
        }
        GenSet$ fill_this = genSet$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$3$adapted(fill_this, n2, n3, n4, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, Function0 function0) {
        GenSet$ genSet$ = GenSet$.MODULE$;
        if (genSet$ == null) {
            throw null;
        }
        GenSet$ fill_this = genSet$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$2$adapted(fill_this, n2, n3, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, Function0 function0) {
        GenSet$ genSet$ = GenSet$.MODULE$;
        if (genSet$ == null) {
            throw null;
        }
        GenSet$ fill_this = genSet$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$1$adapted(fill_this, n2, function0, arg_0));
    }

    public static GenTraversable fill(int n, Function0 function0) {
        GenSet$ genSet$ = GenSet$.MODULE$;
        if (genSet$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)genSet$).newBuilder();
        fill_b.sizeHint(n);
        for (int fill_i = 0; fill_i < n; ++fill_i) {
            fill_b.$plus$eq(function0.apply());
        }
        return (GenTraversable)fill_b.result();
    }

    public static GenTraversable concat(Seq seq) {
        return GenSet$.MODULE$.concat(seq);
    }

    public static GenTraversableFactory.GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return GenSet$.MODULE$.ReusableCBF();
    }

    public static /* synthetic */ GenericCompanion companion$(GenSet $this) {
        return $this.companion();
    }

    @Override
    default public GenericCompanion<GenSet> companion() {
        return GenSet$.MODULE$;
    }

    @Override
    public Set<A> seq();

    public static void $init$(GenSet $this) {
    }
}

