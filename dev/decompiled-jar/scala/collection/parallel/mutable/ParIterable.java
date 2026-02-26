/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.mutable;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.Function4;
import scala.Function5;
import scala.Mutable;
import scala.Serializable;
import scala.collection.GenTraversable;
import scala.collection.Seq;
import scala.collection.generic.CanCombineFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.mutable.Builder;
import scala.collection.mutable.Iterable;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.mutable.ParIterable$;
import scala.collection.parallel.mutable.ParSeq;
import scala.collection.parallel.mutable.ParSeq$;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0005\u0015aa\u0002\u0007\u000e!\u0003\r\tA\u0006\u0005\u0006\u0001\u0002!\t!\u0011\u0005\u0006\u000b\u0002!\tE\u0012\u0005\u0006!\u0002!\t%\u0015\u0005\u0006%\u0002!\te\u0015\u0005\u0006/\u00021\t\u0001W\u0004\u0006;6A\tA\u0018\u0004\u0006\u00195A\ta\u0018\u0005\u0006G\u001e!\t\u0001\u001a\u0005\u0006K\u001e!\u0019A\u001a\u0005\u0006e\u001e!\ta\u001d\u0005\u0006w\u001e!\t\u0001 \u0002\f!\u0006\u0014\u0018\n^3sC\ndWM\u0003\u0002\u000f\u001f\u00059Q.\u001e;bE2,'B\u0001\t\u0012\u0003!\u0001\u0018M]1mY\u0016d'B\u0001\n\u0014\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002)\u0005)1oY1mC\u000e\u0001QCA\f#'\u001d\u0001\u0001\u0004H\u0016/mu\u0002\"!\u0007\u000e\u000e\u0003MI!aG\n\u0003\r\u0005s\u0017PU3g!\rib\u0004I\u0007\u0002#%\u0011q$\u0005\u0002\f\u000f\u0016t\u0017\n^3sC\ndW\r\u0005\u0002\"E1\u0001A!B\u0012\u0001\u0005\u0004!#!\u0001+\u0012\u0005\u0015B\u0003CA\r'\u0013\t93CA\u0004O_RD\u0017N\\4\u0011\u0005eI\u0013B\u0001\u0016\u0014\u0005\r\te.\u001f\t\u0004Y5\u0002S\"A\b\n\u00051y\u0001\u0003B\u00183AQj\u0011\u0001\r\u0006\u0003cE\tqaZ3oKJL7-\u0003\u00024a\t\u0011r)\u001a8fe&\u001c\u0007+\u0019:UK6\u0004H.\u0019;f!\t)\u0004!D\u0001\u000e!\u0015as\u0007I\u001d;\u0013\tAtBA\bQCJLE/\u001a:bE2,G*[6f!\r)\u0004\u0001\t\t\u0004;m\u0002\u0013B\u0001\u001f\u0012\u0005!IE/\u001a:bE2,\u0007CA\r?\u0013\ty4CA\u0004NkR\f'\r\\3\u0002\r\u0011Jg.\u001b;%)\u0005\u0011\u0005CA\rD\u0013\t!5C\u0001\u0003V]&$\u0018!C2p[B\fg.[8o+\u00059%c\u0001%K\u001b\u001a!\u0011\n\u0001\u0001H\u00051a$/\u001a4j]\u0016lWM\u001c;?!\ry3\nN\u0005\u0003\u0019B\u0012\u0001cR3oKJL7mQ8na\u0006t\u0017n\u001c8\u0011\u0007=rE'\u0003\u0002Pa\t\u0019r)\u001a8fe&\u001c\u0007+\u0019:D_6\u0004\u0018M\\5p]\u0006QAo\\%uKJ\f'\r\\3\u0016\u0003e\nQ\u0001^8TKF,\u0012\u0001\u0016\t\u0004kU\u0003\u0013B\u0001,\u000e\u0005\u0019\u0001\u0016M]*fc\u0006\u00191/Z9\u0016\u0003e\u00032A\u0017/!\u001b\u0005Y&B\u0001\b\u0012\u0013\ta4,A\u0006QCJLE/\u001a:bE2,\u0007CA\u001b\b'\t9\u0001\rE\u00020CRJ!A\u0019\u0019\u0003\u0015A\u000b'OR1di>\u0014\u00180\u0001\u0004=S:LGO\u0010\u000b\u0002=\u0006a1-\u00198Ck&dGM\u0012:p[V\u0011q\r]\u000b\u0002QB)q&[6pc&\u0011!\u000e\r\u0002\u000f\u0007\u0006t7i\\7cS:,gI]8n!\taW.D\u0001\b\u0013\tq7J\u0001\u0003D_2d\u0007CA\u0011q\t\u0015\u0019\u0013B1\u0001%!\r)\u0004a\\\u0001\u000b]\u0016<()^5mI\u0016\u0014XC\u0001;z+\u0005)\b\u0003\u0002\u0017wqjL!a^\b\u0003\u0011\r{WNY5oKJ\u0004\"!I=\u0005\u000b\rR!\u0019\u0001\u0013\u0011\u0007U\u0002\u00010A\u0006oK^\u001cu.\u001c2j]\u0016\u0014XcA?\u0002\u0002U\ta\u0010E\u0003-m~\f\u0019\u0001E\u0002\"\u0003\u0003!QaI\u0006C\u0002\u0011\u00022!\u000e\u0001\u0000\u0001")
public interface ParIterable<T>
extends scala.collection.parallel.ParIterable<T>,
Mutable {
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

    public static /* synthetic */ ParIterable toIterable$(ParIterable $this) {
        return $this.toIterable();
    }

    @Override
    default public ParIterable<T> toIterable() {
        return this;
    }

    public static /* synthetic */ ParSeq toSeq$(ParIterable $this) {
        return $this.toSeq();
    }

    @Override
    default public ParSeq<T> toSeq() {
        return (ParSeq)this.toParCollection((Function0<Combiner> & java.io.Serializable & Serializable)() -> ParSeq$.MODULE$.newCombiner());
    }

    @Override
    public Iterable<T> seq();

    public static void $init$(ParIterable $this) {
    }
}

