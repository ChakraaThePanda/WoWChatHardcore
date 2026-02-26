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
import scala.collection.GenTraversable;
import scala.collection.Seq;
import scala.collection.generic.CanCombineFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.mutable.Builder;
import scala.collection.parallel.immutable.ParIterable;
import scala.collection.parallel.immutable.ParSeq$;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001]4qAC\u0006\u0011\u0002\u0007\u0005A\u0003C\u0003A\u0001\u0011\u0005\u0011\tC\u0003F\u0001\u0011\u0005c\tC\u0003Q\u0001\u0011\u0005\u0013kB\u0003S\u0017!\u00051KB\u0003\u000b\u0017!\u0005A\u000bC\u0003Y\u000b\u0011\u0005\u0011\fC\u0003[\u000b\u0011\r1\fC\u0003h\u000b\u0011\u0005\u0001\u000eC\u0003q\u000b\u0011\u0005\u0011O\u0001\u0004QCJ\u001cV-\u001d\u0006\u0003\u00195\t\u0011\"[7nkR\f'\r\\3\u000b\u00059y\u0011\u0001\u00039be\u0006dG.\u001a7\u000b\u0005A\t\u0012AC2pY2,7\r^5p]*\t!#A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u0005U\u00013c\u0002\u0001\u00175%b\u0003g\u000e\t\u0003/ai\u0011!E\u0005\u00033E\u0011a!\u00118z%\u00164\u0007cA\u000e\u001d=5\tq\"\u0003\u0002\u001e\u001f\t1q)\u001a8TKF\u0004\"a\b\u0011\r\u0001\u00111\u0011\u0005\u0001CC\u0002\t\u0012\u0011\u0001V\t\u0003G\u0019\u0002\"a\u0006\u0013\n\u0005\u0015\n\"a\u0002(pi\"Lgn\u001a\t\u0003/\u001dJ!\u0001K\t\u0003\u0007\u0005s\u0017\u0010E\u0002+Wyi\u0011!D\u0005\u0003\u00155\u00012!\f\u0018\u001f\u001b\u0005Y\u0011BA\u0018\f\u0005-\u0001\u0016M]%uKJ\f'\r\\3\u0011\tE\"dDN\u0007\u0002e)\u00111gD\u0001\bO\u0016tWM]5d\u0013\t)$G\u0001\nHK:,'/[2QCJ$V-\u001c9mCR,\u0007CA\u0017\u0001!\u0015Q\u0003H\b\u001e<\u0013\tITB\u0001\u0006QCJ\u001cV-\u001d'jW\u0016\u00042!\f\u0001\u001f!\radHH\u0007\u0002{)\u0011AbD\u0005\u0003\u007fu\u00121aU3r\u0003\u0019!\u0013N\\5uIQ\t!\t\u0005\u0002\u0018\u0007&\u0011A)\u0005\u0002\u0005+:LG/A\u0005d_6\u0004\u0018M\\5p]V\tqIE\u0002I\u001563A!\u0013\u0001\u0001\u000f\naAH]3gS:,W.\u001a8u}A\u0019\u0011g\u0013\u001c\n\u00051\u0013$\u0001E$f]\u0016\u0014\u0018nY\"p[B\fg.[8o!\r\tdJN\u0005\u0003\u001fJ\u00121cR3oKJL7\rU1s\u0007>l\u0007/\u00198j_:\fQ\u0001^8TKF,\u0012AO\u0001\u0007!\u0006\u00148+Z9\u0011\u00055*1CA\u0003V!\r\tdKN\u0005\u0003/J\u0012!\u0002U1s\r\u0006\u001cGo\u001c:z\u0003\u0019a\u0014N\\5u}Q\t1+\u0001\u0007dC:\u0014U/\u001b7e\rJ|W.\u0006\u0002]KV\tQ\fE\u00032=\u0002$g-\u0003\u0002`e\tq1)\u00198D_6\u0014\u0017N\\3Ge>l\u0007CA1c\u001b\u0005)\u0011BA2L\u0005\u0011\u0019u\u000e\u001c7\u0011\u0005})G!B\u0011\b\u0005\u0004\u0011\u0003cA\u0017\u0001I\u0006Qa.Z<Ck&dG-\u001a:\u0016\u0005%tW#\u00016\u0011\t)ZWn\\\u0005\u0003Y6\u0011\u0001bQ8nE&tWM\u001d\t\u0003?9$Q!\t\u0005C\u0002\t\u00022!\f\u0001n\u0003-qWm^\"p[\nLg.\u001a:\u0016\u0005I,X#A:\u0011\t)ZGO\u001e\t\u0003?U$Q!I\u0005C\u0002\t\u00022!\f\u0001u\u0001")
public interface ParSeq<T>
extends scala.collection.parallel.ParSeq<T>,
ParIterable<T> {
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

    public static /* synthetic */ ParSeq toSeq$(ParSeq $this) {
        return $this.toSeq();
    }

    @Override
    default public ParSeq<T> toSeq() {
        return this;
    }

    public static void $init$(ParSeq $this) {
    }
}

