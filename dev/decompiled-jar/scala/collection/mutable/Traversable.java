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
import scala.Mutable;
import scala.collection.GenTraversable;
import scala.collection.Seq;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.mutable.Builder;
import scala.collection.mutable.Traversable$;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u00054q!\u0003\u0006\u0011\u0002\u0007\u0005\u0011\u0003C\u00035\u0001\u0011\u0005Q\u0007C\u0003:\u0001\u0011\u0005#\bC\u0003?\u0001\u0011\u0005shB\u0003A\u0015!\u0005\u0011IB\u0003\n\u0015!\u0005!\tC\u0003J\u000b\u0011\u0005!\nC\u0003L\u000b\u0011\rA\nC\u0003Y\u000b\u0011\u0005\u0011LA\u0006Ue\u00064XM]:bE2,'BA\u0006\r\u0003\u001diW\u000f^1cY\u0016T!!\u0004\b\u0002\u0015\r|G\u000e\\3di&|gNC\u0001\u0010\u0003\u0015\u00198-\u00197b\u0007\u0001)\"A\u0005\u000f\u0014\r\u0001\u0019r#J\u00172!\t!R#D\u0001\u000f\u0013\t1bB\u0001\u0004B]f\u0014VM\u001a\t\u00041eQR\"\u0001\u0007\n\u0005%a\u0001CA\u000e\u001d\u0019\u0001!Q!\b\u0001C\u0002y\u0011\u0011!Q\t\u0003?\t\u0002\"\u0001\u0006\u0011\n\u0005\u0005r!a\u0002(pi\"Lgn\u001a\t\u0003)\rJ!\u0001\n\b\u0003\u0007\u0005s\u0017\u0010\u0005\u0003'SiYS\"A\u0014\u000b\u0005!b\u0011aB4f]\u0016\u0014\u0018nY\u0005\u0003U\u001d\u0012!dR3oKJL7\r\u0016:bm\u0016\u00148/\u00192mKR+W\u000e\u001d7bi\u0016\u0004\"\u0001\f\u0001\u000e\u0003)\u0001B\u0001\u0007\u0018\u001ba%\u0011q\u0006\u0004\u0002\u0010)J\fg/\u001a:tC\ndW\rT5lKB\u0019A\u0006\u0001\u000e\u0011\u0005Q\u0011\u0014BA\u001a\u000f\u0005\u001diU\u000f^1cY\u0016\fa\u0001J5oSR$C#\u0001\u001c\u0011\u0005Q9\u0014B\u0001\u001d\u000f\u0005\u0011)f.\u001b;\u0002\u0013\r|W\u000e]1oS>tW#A\u001e\u0011\u0007\u0019b4&\u0003\u0002>O\t\u0001r)\u001a8fe&\u001c7i\\7qC:LwN\\\u0001\u0004g\u0016\fX#\u0001\u0019\u0002\u0017Q\u0013\u0018M^3sg\u0006\u0014G.\u001a\t\u0003Y\u0015\u00192!B\"G!\r1CiK\u0005\u0003\u000b\u001e\u0012QcR3o)J\fg/\u001a:tC\ndWMR1di>\u0014\u0018\u0010E\u0002'\u000f.J!\u0001S\u0014\u0003%Q\u0013\u0018M^3sg\u0006\u0014G.\u001a$bGR|'/_\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003\u0005\u000bAbY1o\u0005VLG\u000e\u001a$s_6,\"!\u0014,\u0016\u00039\u0003RAJ(R+^K!\u0001U\u0014\u0003\u0019\r\u000bgNQ;jY\u00124%o\\7\u0011\u0005I\u001bV\"A\u0003\n\u0005Qc$\u0001B\"pY2\u0004\"a\u0007,\u0005\u000bu9!\u0019\u0001\u0010\u0011\u00071\u0002Q+\u0001\u0006oK^\u0014U/\u001b7eKJ,\"AW0\u0016\u0003m\u0003B\u0001\f/_A&\u0011QL\u0003\u0002\b\u0005VLG\u000eZ3s!\tYr\fB\u0003\u001e\u0011\t\u0007a\u0004E\u0002-\u0001y\u0003")
public interface Traversable<A>
extends scala.collection.Traversable<A>,
Mutable {
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

