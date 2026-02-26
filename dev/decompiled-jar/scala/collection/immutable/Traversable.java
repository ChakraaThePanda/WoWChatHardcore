/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.Function4;
import scala.Function5;
import scala.Immutable;
import scala.collection.GenTraversable;
import scala.collection.Seq;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.immutable.Traversable$;
import scala.collection.mutable.Builder;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u00114q!\u0003\u0006\u0011\u0002\u0007\u0005\u0011\u0003C\u00035\u0001\u0011\u0005Q\u0007C\u0003:\u0001\u0011\u0005#\bC\u0003?\u0001\u0011\u0005shB\u0003A\u0015!\u0005\u0011IB\u0003\n\u0015!\u0005!\tC\u0003J\u000b\u0011\u0005!\nC\u0003L\u000b\u0011\rA\nC\u0003Y\u000b\u0011\u0005\u0011LA\u0006Ue\u00064XM]:bE2,'BA\u0006\r\u0003%IW.\\;uC\ndWM\u0003\u0002\u000e\u001d\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003=\tQa]2bY\u0006\u001c\u0001!\u0006\u0002\u00139M1\u0001aE\f&[E\u0002\"\u0001F\u000b\u000e\u00039I!A\u0006\b\u0003\r\u0005s\u0017PU3g!\rA\u0012DG\u0007\u0002\u0019%\u0011\u0011\u0002\u0004\t\u00037qa\u0001\u0001\u0002\u0004\u001e\u0001\u0011\u0015\rA\b\u0002\u0002\u0003F\u0011qD\t\t\u0003)\u0001J!!\t\b\u0003\u000f9{G\u000f[5oOB\u0011AcI\u0005\u0003I9\u00111!\u00118z!\u00111\u0013FG\u0016\u000e\u0003\u001dR!\u0001\u000b\u0007\u0002\u000f\u001d,g.\u001a:jG&\u0011!f\n\u0002\u001b\u000f\u0016tWM]5d)J\fg/\u001a:tC\ndW\rV3na2\fG/\u001a\t\u0003Y\u0001i\u0011A\u0003\t\u000519R\u0002'\u0003\u00020\u0019\tyAK]1wKJ\u001c\u0018M\u00197f\u0019&\\W\rE\u0002-\u0001i\u0001\"\u0001\u0006\u001a\n\u0005Mr!!C%n[V$\u0018M\u00197f\u0003\u0019!\u0013N\\5uIQ\ta\u0007\u0005\u0002\u0015o%\u0011\u0001H\u0004\u0002\u0005+:LG/A\u0005d_6\u0004\u0018M\\5p]V\t1\bE\u0002'y-J!!P\u0014\u0003!\u001d+g.\u001a:jG\u000e{W\u000e]1oS>t\u0017aA:fcV\t\u0001'A\u0006Ue\u00064XM]:bE2,\u0007C\u0001\u0017\u0006'\r)1I\u0012\t\u0004M\u0011[\u0013BA#(\u0005U9UM\u001c+sCZ,'o]1cY\u00164\u0015m\u0019;pef\u00042AJ$,\u0013\tAuE\u0001\nUe\u00064XM]:bE2,g)Y2u_JL\u0018A\u0002\u001fj]&$h\bF\u0001B\u00031\u0019\u0017M\u001c\"vS2$gI]8n+\tie+F\u0001O!\u00151s*U+X\u0013\t\u0001vE\u0001\u0007DC:\u0014U/\u001b7e\rJ|W\u000e\u0005\u0002S'6\tQ!\u0003\u0002Uy\t!1i\u001c7m!\tYb\u000bB\u0003\u001e\u000f\t\u0007a\u0004E\u0002-\u0001U\u000b!B\\3x\u0005VLG\u000eZ3s+\tQ&-F\u0001\\!\u0011av,Y2\u000e\u0003uS!A\u0018\u0007\u0002\u000f5,H/\u00192mK&\u0011\u0001-\u0018\u0002\b\u0005VLG\u000eZ3s!\tY\"\rB\u0003\u001e\u0011\t\u0007a\u0004E\u0002-\u0001\u0005\u0004")
public interface Traversable<A>
extends scala.collection.Traversable<A>,
Immutable {
    public static <A> CanBuildFrom<Traversable<?>, A, Traversable<A>> canBuildFrom() {
        return Traversable$.MODULE$.canBuildFrom();
    }

    public static GenTraversable iterate(Object object, int n, Function1 function1) {
        Traversable$ traversable$ = Traversable$.MODULE$;
        if (traversable$ == null) {
            throw null;
        }
        Builder iterate_b = ((GenericCompanion)traversable$).newBuilder();
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
        return Traversable$.MODULE$.range(object, object2, object3, integral);
    }

    public static GenTraversable range(Object object, Object object2, Integral integral) {
        return Traversable$.MODULE$.range(object, object2, integral);
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, int n5, Function5 function5) {
        Traversable$ traversable$ = Traversable$.MODULE$;
        if (traversable$ == null) {
            throw null;
        }
        Traversable$ tabulate_this = traversable$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$7$adapted(tabulate_this, n2, n3, n4, n5, function5, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, Function4 function4) {
        Traversable$ traversable$ = Traversable$.MODULE$;
        if (traversable$ == null) {
            throw null;
        }
        Traversable$ tabulate_this = traversable$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$5$adapted(tabulate_this, n2, n3, n4, function4, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, Function3 function3) {
        Traversable$ traversable$ = Traversable$.MODULE$;
        if (traversable$ == null) {
            throw null;
        }
        Traversable$ tabulate_this = traversable$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$3$adapted(tabulate_this, n2, n3, function3, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, Function2 function2) {
        Traversable$ traversable$ = Traversable$.MODULE$;
        if (traversable$ == null) {
            throw null;
        }
        Traversable$ tabulate_this = traversable$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$1$adapted(tabulate_this, n2, function2, arg_0));
    }

    public static GenTraversable tabulate(int n, Function1 function1) {
        return Traversable$.MODULE$.tabulate(n, function1);
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, int n5, Function0 function0) {
        Traversable$ traversable$ = Traversable$.MODULE$;
        if (traversable$ == null) {
            throw null;
        }
        Traversable$ fill_this = traversable$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$4$adapted(fill_this, n2, n3, n4, n5, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, Function0 function0) {
        Traversable$ traversable$ = Traversable$.MODULE$;
        if (traversable$ == null) {
            throw null;
        }
        Traversable$ fill_this = traversable$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$3$adapted(fill_this, n2, n3, n4, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, Function0 function0) {
        Traversable$ traversable$ = Traversable$.MODULE$;
        if (traversable$ == null) {
            throw null;
        }
        Traversable$ fill_this = traversable$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$2$adapted(fill_this, n2, n3, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, Function0 function0) {
        Traversable$ traversable$ = Traversable$.MODULE$;
        if (traversable$ == null) {
            throw null;
        }
        Traversable$ fill_this = traversable$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$1$adapted(fill_this, n2, function0, arg_0));
    }

    public static GenTraversable fill(int n, Function0 function0) {
        Traversable$ traversable$ = Traversable$.MODULE$;
        if (traversable$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)traversable$).newBuilder();
        fill_b.sizeHint(n);
        for (int fill_i = 0; fill_i < n; ++fill_i) {
            fill_b.$plus$eq(function0.apply());
        }
        return (GenTraversable)fill_b.result();
    }

    public static GenTraversable concat(Seq seq) {
        return Traversable$.MODULE$.concat(seq);
    }

    public static GenTraversableFactory.GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return Traversable$.MODULE$.ReusableCBF();
    }

    public static GenTraversable apply(Seq seq) {
        return Traversable$.MODULE$.apply(seq);
    }

    public static GenTraversable empty() {
        return Traversable$.MODULE$.empty();
    }

    public static /* synthetic */ GenericCompanion companion$(Traversable $this) {
        return $this.companion();
    }

    @Override
    default public GenericCompanion<Traversable> companion() {
        return Traversable$.MODULE$;
    }

    public static /* synthetic */ Traversable seq$(Traversable $this) {
        return $this.seq();
    }

    @Override
    default public Traversable<A> seq() {
        return this;
    }

    public static void $init$(Traversable $this) {
    }
}

