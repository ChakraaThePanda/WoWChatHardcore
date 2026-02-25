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
import scala.collection.mutable.Builder;
import scala.collection.mutable.LinearSeq$;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001y3q!\u0003\u0006\u0011\u0002\u0007\u0005\u0011\u0003C\u00035\u0001\u0011\u0005Q\u0007C\u0003:\u0001\u0011\u0005#\bC\u0003?\u0001\u0011\u0005shB\u0003A\u0015!\u0005\u0011IB\u0003\n\u0015!\u0005!\tC\u0003G\u000b\u0011\u0005q\tC\u0003I\u000b\u0011\r\u0011\nC\u0003V\u000b\u0011\u0005aKA\u0005MS:,\u0017M]*fc*\u00111\u0002D\u0001\b[V$\u0018M\u00197f\u0015\tia\"\u0001\u0006d_2dWm\u0019;j_:T\u0011aD\u0001\u0006g\u000e\fG.Y\u0002\u0001+\t\u0011Rd\u0005\u0004\u0001']1\u0013\u0006\r\t\u0003)Ui\u0011AD\u0005\u0003-9\u0011a!\u00118z%\u00164\u0007c\u0001\r\u001a75\t!\"\u0003\u0002\u001b\u0015\t\u00191+Z9\u0011\u0005qiB\u0002\u0001\u0003\u0006=\u0001\u0011\ra\b\u0002\u0002\u0003F\u0011\u0001e\t\t\u0003)\u0005J!A\t\b\u0003\u000f9{G\u000f[5oOB\u0011A\u0003J\u0005\u0003K9\u00111!\u00118z!\r9\u0003fG\u0007\u0002\u0019%\u0011\u0011\u0002\u0004\t\u0005U5Zr&D\u0001,\u0015\taC\"A\u0004hK:,'/[2\n\u00059Z#AG$f]\u0016\u0014\u0018n\u0019+sCZ,'o]1cY\u0016$V-\u001c9mCR,\u0007C\u0001\r\u0001!\u00119\u0013gG\u001a\n\u0005Ib!!\u0004'j]\u0016\f'oU3r\u0019&\\W\rE\u0002\u0019\u0001m\ta\u0001J5oSR$C#\u0001\u001c\u0011\u0005Q9\u0014B\u0001\u001d\u000f\u0005\u0011)f.\u001b;\u0002\u0013\r|W\u000e]1oS>tW#A\u001e\u0011\u0007)bt&\u0003\u0002>W\t\u0001r)\u001a8fe&\u001c7i\\7qC:LwN\\\u0001\u0004g\u0016\fX#A\u001a\u0002\u00131Kg.Z1s'\u0016\f\bC\u0001\r\u0006'\t)1\tE\u0002+\t>J!!R\u0016\u0003\u0015M+\u0017OR1di>\u0014\u00180\u0001\u0004=S:LGO\u0010\u000b\u0002\u0003\u0006a1-\u00198Ck&dGM\u0012:p[V\u0011!jU\u000b\u0002\u0017B)!\u0006\u0014(S)&\u0011Qj\u000b\u0002\r\u0007\u0006t')^5mI\u001a\u0013x.\u001c\t\u0003\u001fBk\u0011!B\u0005\u0003#r\u0012AaQ8mYB\u0011Ad\u0015\u0003\u0006=\u001d\u0011\ra\b\t\u00041\u0001\u0011\u0016A\u00038fo\n+\u0018\u000e\u001c3feV\u0011q\u000bX\u000b\u00021B!\u0001$W.^\u0013\tQ&BA\u0004Ck&dG-\u001a:\u0011\u0005qaF!\u0002\u0010\t\u0005\u0004y\u0002c\u0001\r\u00017\u0002")
public interface LinearSeq<A>
extends scala.collection.mutable.Seq<A>,
scala.collection.LinearSeq<A> {
    public static <A> CanBuildFrom<LinearSeq<?>, A, LinearSeq<A>> canBuildFrom() {
        return LinearSeq$.MODULE$.canBuildFrom();
    }

    public static Some unapplySeq(Seq seq) {
        return LinearSeq$.MODULE$.unapplySeq(seq);
    }

    public static GenTraversable iterate(Object object, int n, Function1 function1) {
        LinearSeq$ linearSeq$ = LinearSeq$.MODULE$;
        if (linearSeq$ == null) {
            throw null;
        }
        Builder iterate_b = ((GenericCompanion)linearSeq$).newBuilder();
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
        return LinearSeq$.MODULE$.range(object, object2, object3, integral);
    }

    public static GenTraversable range(Object object, Object object2, Integral integral) {
        return LinearSeq$.MODULE$.range(object, object2, integral);
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, int n5, Function5 function5) {
        LinearSeq$ linearSeq$ = LinearSeq$.MODULE$;
        if (linearSeq$ == null) {
            throw null;
        }
        LinearSeq$ tabulate_this = linearSeq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$7$adapted(tabulate_this, n2, n3, n4, n5, function5, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, Function4 function4) {
        LinearSeq$ linearSeq$ = LinearSeq$.MODULE$;
        if (linearSeq$ == null) {
            throw null;
        }
        LinearSeq$ tabulate_this = linearSeq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$5$adapted(tabulate_this, n2, n3, n4, function4, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, Function3 function3) {
        LinearSeq$ linearSeq$ = LinearSeq$.MODULE$;
        if (linearSeq$ == null) {
            throw null;
        }
        LinearSeq$ tabulate_this = linearSeq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$3$adapted(tabulate_this, n2, n3, function3, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, Function2 function2) {
        LinearSeq$ linearSeq$ = LinearSeq$.MODULE$;
        if (linearSeq$ == null) {
            throw null;
        }
        LinearSeq$ tabulate_this = linearSeq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$1$adapted(tabulate_this, n2, function2, arg_0));
    }

    public static GenTraversable tabulate(int n, Function1 function1) {
        return LinearSeq$.MODULE$.tabulate(n, function1);
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, int n5, Function0 function0) {
        LinearSeq$ linearSeq$ = LinearSeq$.MODULE$;
        if (linearSeq$ == null) {
            throw null;
        }
        LinearSeq$ fill_this = linearSeq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$4$adapted(fill_this, n2, n3, n4, n5, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, Function0 function0) {
        LinearSeq$ linearSeq$ = LinearSeq$.MODULE$;
        if (linearSeq$ == null) {
            throw null;
        }
        LinearSeq$ fill_this = linearSeq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$3$adapted(fill_this, n2, n3, n4, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, Function0 function0) {
        LinearSeq$ linearSeq$ = LinearSeq$.MODULE$;
        if (linearSeq$ == null) {
            throw null;
        }
        LinearSeq$ fill_this = linearSeq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$2$adapted(fill_this, n2, n3, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, Function0 function0) {
        LinearSeq$ linearSeq$ = LinearSeq$.MODULE$;
        if (linearSeq$ == null) {
            throw null;
        }
        LinearSeq$ fill_this = linearSeq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$1$adapted(fill_this, n2, function0, arg_0));
    }

    public static GenTraversable fill(int n, Function0 function0) {
        LinearSeq$ linearSeq$ = LinearSeq$.MODULE$;
        if (linearSeq$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)linearSeq$).newBuilder();
        fill_b.sizeHint(n);
        for (int fill_i = 0; fill_i < n; ++fill_i) {
            fill_b.$plus$eq(function0.apply());
        }
        return (GenTraversable)fill_b.result();
    }

    public static GenTraversable concat(Seq seq) {
        return LinearSeq$.MODULE$.concat(seq);
    }

    public static GenTraversableFactory.GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return LinearSeq$.MODULE$.ReusableCBF();
    }

    public static GenTraversable empty() {
        return LinearSeq$.MODULE$.empty();
    }

    public static /* synthetic */ GenericCompanion companion$(LinearSeq $this) {
        return $this.companion();
    }

    @Override
    default public GenericCompanion<LinearSeq> companion() {
        return LinearSeq$.MODULE$;
    }

    public static /* synthetic */ LinearSeq seq$(LinearSeq $this) {
        return $this.seq();
    }

    @Override
    default public LinearSeq<A> seq() {
        return this;
    }

    public static void $init$(LinearSeq $this) {
    }
}

