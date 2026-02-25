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
import scala.collection.GenTraversable;
import scala.collection.Seq;
import scala.collection.generic.CanCombineFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.mutable.Builder;
import scala.collection.parallel.mutable.ParIterable;
import scala.collection.parallel.mutable.ParSeq$;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0005%aa\u0002\u0007\u000e!\u0003\r\tA\u0006\u0005\u0006\u0005\u0002!\ta\u0011\u0005\u0006\u000f\u0002!\t\u0005\u0013\u0005\u0006%\u00021\ta\u0015\u0005\u00067\u00021\t\u0001\u0018\u0005\u0006;\u0002!\tEX\u0004\u0006?6A\t\u0001\u0019\u0004\u0006\u00195A\t!\u0019\u0005\u0006K\u001e!\tA\u001a\u0005\u0006O\u001e!\u0019\u0001\u001b\u0005\u0006i\u001e!\t!\u001e\u0005\u0006{\u001e!\tA \u0002\u0007!\u0006\u00148+Z9\u000b\u00059y\u0011aB7vi\u0006\u0014G.\u001a\u0006\u0003!E\t\u0001\u0002]1sC2dW\r\u001c\u0006\u0003%M\t!bY8mY\u0016\u001cG/[8o\u0015\u0005!\u0012!B:dC2\f7\u0001A\u000b\u0003/\t\u001ar\u0001\u0001\r\u001dW=\u0012\u0014\b\u0005\u0002\u001a55\t1#\u0003\u0002\u001c'\t1\u0011I\\=SK\u001a\u00042!\b\u0010!\u001b\u0005\t\u0012BA\u0010\u0012\u0005\u00199UM\\*fcB\u0011\u0011E\t\u0007\u0001\t\u0015\u0019\u0003A1\u0001%\u0005\u0005!\u0016CA\u0013)!\tIb%\u0003\u0002('\t9aj\u001c;iS:<\u0007CA\r*\u0013\tQ3CA\u0002B]f\u00042\u0001L\u0017!\u001b\u0005i\u0011B\u0001\u0018\u000e\u0005-\u0001\u0016M]%uKJ\f'\r\\3\u0011\u0007A\n\u0004%D\u0001\u0010\u0013\taq\u0002\u0005\u00034m\u0001BT\"\u0001\u001b\u000b\u0005U\n\u0012aB4f]\u0016\u0014\u0018nY\u0005\u0003oQ\u0012!cR3oKJL7\rU1s)\u0016l\u0007\u000f\\1uKB\u0011A\u0006\u0001\t\u0006ai\u0002C(P\u0005\u0003w=\u0011!\u0002U1s'\u0016\fH*[6f!\ra\u0003\u0001\t\t\u0004}\u0001\u0003S\"A \u000b\u00059\t\u0012BA!@\u0005\r\u0019V-]\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0015\u0003\u0011\u0003\"!G#\n\u0005\u0019\u001b\"\u0001B+oSR\f\u0011bY8na\u0006t\u0017n\u001c8\u0016\u0003%\u00132A\u0013'P\r\u0011Y\u0005\u0001A%\u0003\u0019q\u0012XMZ5oK6,g\u000e\u001e \u0011\u0007Mj\u0005(\u0003\u0002Oi\t\u0001r)\u001a8fe&\u001c7i\\7qC:LwN\u001c\t\u0004gAC\u0014BA)5\u0005M9UM\\3sS\u000e\u0004\u0016M]\"p[B\fg.[8o\u0003\u0019)\b\u000fZ1uKR\u0019A\tV-\t\u000bU\u001b\u0001\u0019\u0001,\u0002\u0003%\u0004\"!G,\n\u0005a\u001b\"aA%oi\")!l\u0001a\u0001A\u0005!Q\r\\3n\u0003\r\u0019X-]\u000b\u0002{\u0005)Ao\\*fcV\tA(\u0001\u0004QCJ\u001cV-\u001d\t\u0003Y\u001d\u0019\"a\u00022\u0011\u0007M\u001a\u0007(\u0003\u0002ei\tQ\u0001+\u0019:GC\u000e$xN]=\u0002\rqJg.\u001b;?)\u0005\u0001\u0017\u0001D2b]\n+\u0018\u000e\u001c3Ge>lWCA5s+\u0005Q\u0007#B\u001al[F\u001c\u0018B\u000175\u00059\u0019\u0015M\\\"p[\nLg.\u001a$s_6\u0004\"A\\8\u000e\u0003\u001dI!\u0001]'\u0003\t\r{G\u000e\u001c\t\u0003CI$QaI\u0005C\u0002\u0011\u00022\u0001\f\u0001r\u0003)qWm\u001e\"vS2$WM]\u000b\u0003mn,\u0012a\u001e\t\u0005aaTH0\u0003\u0002z\u001f\tA1i\\7cS:,'\u000f\u0005\u0002\"w\u0012)1E\u0003b\u0001IA\u0019A\u0006\u0001>\u0002\u00179,woQ8nE&tWM]\u000b\u0004\u007f\u0006\u0015QCAA\u0001!\u0019\u0001\u00040a\u0001\u0002\bA\u0019\u0011%!\u0002\u0005\u000b\rZ!\u0019\u0001\u0013\u0011\t1\u0002\u00111\u0001")
public interface ParSeq<T>
extends ParIterable<T>,
scala.collection.parallel.ParSeq<T> {
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

    public void update(int var1, T var2);

    @Override
    public scala.collection.mutable.Seq<T> seq();

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

