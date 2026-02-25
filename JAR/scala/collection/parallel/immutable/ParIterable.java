/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.immutable;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.Function4;
import scala.Function5;
import scala.Immutable;
import scala.Serializable;
import scala.collection.GenTraversable;
import scala.collection.Seq;
import scala.collection.generic.CanCombineFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.mutable.Builder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.immutable.ParIterable$;
import scala.collection.parallel.immutable.ParSeq;
import scala.collection.parallel.immutable.ParSeq$;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001u4qa\u0003\u0007\u0011\u0002\u0007\u0005Q\u0003C\u0003B\u0001\u0011\u0005!\tC\u0003G\u0001\u0011\u0005s\tC\u0003R\u0001\u0011\u0005#\u000bC\u0003T\u0001\u0011\u0005CkB\u0003Y\u0019!\u0005\u0011LB\u0003\f\u0019!\u0005!\fC\u0003_\r\u0011\u0005q\fC\u0003a\r\u0011\r\u0011\rC\u0003n\r\u0011\u0005a\u000eC\u0003w\r\u0011\u0005qOA\u0006QCJLE/\u001a:bE2,'BA\u0007\u000f\u0003%IW.\\;uC\ndWM\u0003\u0002\u0010!\u0005A\u0001/\u0019:bY2,GN\u0003\u0002\u0012%\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003M\tQa]2bY\u0006\u001c\u0001!\u0006\u0002\u0017CM9\u0001aF\u000e+[Ur\u0004C\u0001\r\u001a\u001b\u0005\u0011\u0012B\u0001\u000e\u0013\u0005\u0019\te.\u001f*fMB\u0019A$H\u0010\u000e\u0003AI!A\b\t\u0003\u0017\u001d+g.\u0013;fe\u0006\u0014G.\u001a\t\u0003A\u0005b\u0001\u0001\u0002\u0004#\u0001\u0011\u0015\ra\t\u0002\u0002)F\u0011Ae\n\t\u00031\u0015J!A\n\n\u0003\u000f9{G\u000f[5oOB\u0011\u0001\u0004K\u0005\u0003SI\u00111!\u00118z!\rYCfH\u0007\u0002\u001d%\u00111B\u0004\t\u0005]Ez2'D\u00010\u0015\t\u0001\u0004#A\u0004hK:,'/[2\n\u0005Iz#AE$f]\u0016\u0014\u0018n\u0019)beR+W\u000e\u001d7bi\u0016\u0004\"\u0001\u000e\u0001\u000e\u00031\u0001Ra\u000b\u001c qeJ!a\u000e\b\u0003\u001fA\u000b'/\u0013;fe\u0006\u0014G.\u001a'jW\u0016\u00042\u0001\u000e\u0001 !\rQDhH\u0007\u0002w)\u0011Q\u0002E\u0005\u0003{m\u0012\u0001\"\u0013;fe\u0006\u0014G.\u001a\t\u00031}J!\u0001\u0011\n\u0003\u0013%kW.\u001e;bE2,\u0017A\u0002\u0013j]&$H\u0005F\u0001D!\tAB)\u0003\u0002F%\t!QK\\5u\u0003%\u0019w.\u001c9b]&|g.F\u0001I%\rI5J\u0014\u0004\u0005\u0015\u0002\u0001\u0001J\u0001\u0007=e\u00164\u0017N\\3nK:$h\bE\u0002/\u0019NJ!!T\u0018\u0003!\u001d+g.\u001a:jG\u000e{W\u000e]1oS>t\u0007c\u0001\u0018Pg%\u0011\u0001k\f\u0002\u0014\u000f\u0016tWM]5d!\u0006\u00148i\\7qC:LwN\\\u0001\u000bi>LE/\u001a:bE2,W#\u0001\u001d\u0002\u000bQ|7+Z9\u0016\u0003U\u00032\u0001\u000e, \u0013\t9FB\u0001\u0004QCJ\u001cV-]\u0001\f!\u0006\u0014\u0018\n^3sC\ndW\r\u0005\u00025\rM\u0011aa\u0017\t\u0004]q\u001b\u0014BA/0\u0005)\u0001\u0016M\u001d$bGR|'/_\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003e\u000bAbY1o\u0005VLG\u000e\u001a$s_6,\"AY6\u0016\u0003\r\u0004RA\f3gU2L!!Z\u0018\u0003\u001d\r\u000bgnQ8nE&tWM\u0012:p[B\u0011q\r[\u0007\u0002\r%\u0011\u0011\u000e\u0014\u0002\u0005\u0007>dG\u000e\u0005\u0002!W\u0012)!\u0005\u0003b\u0001GA\u0019A\u0007\u00016\u0002\u00159,wOQ;jY\u0012,'/\u0006\u0002piV\t\u0001\u000f\u0005\u0003,cN,\u0018B\u0001:\u000f\u0005!\u0019u.\u001c2j]\u0016\u0014\bC\u0001\u0011u\t\u0015\u0011\u0013B1\u0001$!\r!\u0004a]\u0001\f]\u0016<8i\\7cS:,'/\u0006\u0002ywV\t\u0011\u0010\u0005\u0003,cjd\bC\u0001\u0011|\t\u0015\u0011#B1\u0001$!\r!\u0004A\u001f")
public interface ParIterable<T>
extends scala.collection.parallel.ParIterable<T>,
Immutable {
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

    public static void $init$(ParIterable $this) {
    }
}

