/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel;

import scala.Array$;
import scala.Function1;
import scala.Option;
import scala.Predef$;
import scala.Predef$any2stringadd$;
import scala.Product;
import scala.Serializable;
import scala.collection.Iterator;
import scala.collection.Set;
import scala.collection.Set$;
import scala.collection.TraversableOnce;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.ArrayOps;
import scala.collection.parallel.CompositeThrowable$;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0005\u001db\u0001\u0002\u000b\u0016\u0005rA\u0001b\u000b\u0001\u0003\u0016\u0004%\t\u0001\f\u0005\ti\u0001\u0011\t\u0012)A\u0005[!)Q\u0007\u0001C\u0001m!9!\bAA\u0001\n\u0003Y\u0004bB\u001f\u0001#\u0003%\tA\u0010\u0005\b\u0013\u0002\t\t\u0011\"\u0011K\u0011\u001d\u0019\u0006!!A\u0005\u0002QCq\u0001\u0017\u0001\u0002\u0002\u0013\u0005\u0011\fC\u0004`\u0001\u0005\u0005I\u0011\t1\t\u000f\u0011\u0004\u0011\u0011!C\u0001K\"9!\u000eAA\u0001\n\u0003Z\u0007b\u00027\u0001\u0003\u0003%\t%\\\u0004\boV\t\t\u0011#\u0001y\r\u001d!R#!A\t\u0002eDa!\u000e\b\u0005\u0002\u0005\u0005\u0001\"CA\u0002\u001d\u0005\u0005IQIA\u0003\u0011%\t9ADA\u0001\n\u0003\u000bI\u0001C\u0005\u0002\u000e9\t\t\u0011\"!\u0002\u0010!I\u00111\u0004\b\u0002\u0002\u0013%\u0011Q\u0004\u0002\u0013\u0007>l\u0007o\\:ji\u0016$\u0006N]8xC\ndWM\u0003\u0002\u0017/\u0005A\u0001/\u0019:bY2,GN\u0003\u0002\u00193\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003i\tQa]2bY\u0006\u001c\u0001a\u0005\u0003\u0001;\u0015B\u0003C\u0001\u0010#\u001d\ty\u0002%D\u0001\u001a\u0013\t\t\u0013$A\u0004qC\u000e\\\u0017mZ3\n\u0005\r\"#!C#yG\u0016\u0004H/[8o\u0015\t\t\u0013\u0004\u0005\u0002 M%\u0011q%\u0007\u0002\b!J|G-^2u!\ty\u0012&\u0003\u0002+3\ta1+\u001a:jC2L'0\u00192mK\u0006QA\u000f\u001b:po\u0006\u0014G.Z:\u0016\u00035\u00022AL\u00182\u001b\u00059\u0012B\u0001\u0019\u0018\u0005\r\u0019V\r\u001e\t\u0003=IJ!a\r\u0013\u0003\u0013QC'o\\<bE2,\u0017a\u0003;ie><\u0018M\u00197fg\u0002\na\u0001P5oSRtDCA\u001c:!\tA\u0004!D\u0001\u0016\u0011\u0015Y3\u00011\u0001.\u0003\u0011\u0019w\u000e]=\u0015\u0005]b\u0004bB\u0016\u0005!\u0003\u0005\r!L\u0001\u000fG>\u0004\u0018\u0010\n3fM\u0006,H\u000e\u001e\u00132+\u0005y$FA\u0017AW\u0005\t\u0005C\u0001\"H\u001b\u0005\u0019%B\u0001#F\u0003%)hn\u00195fG.,GM\u0003\u0002G3\u0005Q\u0011M\u001c8pi\u0006$\u0018n\u001c8\n\u0005!\u001b%!E;oG\",7m[3e-\u0006\u0014\u0018.\u00198dK\u0006i\u0001O]8ek\u000e$\bK]3gSb,\u0012a\u0013\t\u0003\u0019Fk\u0011!\u0014\u0006\u0003\u001d>\u000bA\u0001\\1oO*\t\u0001+\u0001\u0003kCZ\f\u0017B\u0001*N\u0005\u0019\u0019FO]5oO\u0006a\u0001O]8ek\u000e$\u0018I]5usV\tQ\u000b\u0005\u0002 -&\u0011q+\u0007\u0002\u0004\u0013:$\u0018A\u00049s_\u0012,8\r^#mK6,g\u000e\u001e\u000b\u00035v\u0003\"aH.\n\u0005qK\"aA!os\"9a\fCA\u0001\u0002\u0004)\u0016a\u0001=%c\u0005y\u0001O]8ek\u000e$\u0018\n^3sCR|'/F\u0001b!\rq#MW\u0005\u0003G^\u0011\u0001\"\u0013;fe\u0006$xN]\u0001\tG\u0006tW)];bYR\u0011a-\u001b\t\u0003?\u001dL!\u0001[\r\u0003\u000f\t{w\u000e\\3b]\"9aLCA\u0001\u0002\u0004Q\u0016\u0001\u00035bg\"\u001cu\u000eZ3\u0015\u0003U\u000ba!Z9vC2\u001cHC\u00014o\u0011\u001dqF\"!AA\u0002iCC\u0001\u00019tkB\u0011q$]\u0005\u0003ef\u0011!\u0002Z3qe\u0016\u001c\u0017\r^3eC\u0005!\u0018a\u0007;iSN\u00043\r\\1tg\u0002:\u0018\u000e\u001c7!E\u0016\u0004#/Z7pm\u0016$g&I\u0001w\u0003\u0019\u0011d&M\u0019/a\u0005\u00112i\\7q_NLG/\u001a+ie><\u0018M\u00197f!\tAdbE\u0002\u000fu\"\u0002Ba\u001f@.o5\tAP\u0003\u0002~3\u00059!/\u001e8uS6,\u0017BA@}\u0005E\t%m\u001d;sC\u000e$h)\u001e8di&|g.\r\u000b\u0002q\u0006AAo\\*ue&tw\rF\u0001L\u0003\u0015\t\u0007\u000f\u001d7z)\r9\u00141\u0002\u0005\u0006WE\u0001\r!L\u0001\bk:\f\u0007\u000f\u001d7z)\u0011\t\t\"a\u0006\u0011\t}\t\u0019\"L\u0005\u0004\u0003+I\"AB(qi&|g\u000e\u0003\u0005\u0002\u001aI\t\t\u00111\u00018\u0003\rAH\u0005M\u0001\fe\u0016\fGMU3t_24X\r\u0006\u0002\u0002 A\u0019A*!\t\n\u0007\u0005\rRJ\u0001\u0004PE*,7\r\u001e\u0015\u0005\u001dA\u001cX\u000f")
public final class CompositeThrowable
extends Exception
implements Product,
Serializable {
    private final Set<Throwable> throwables;

    public static Option<Set<Throwable>> unapply(CompositeThrowable compositeThrowable) {
        return CompositeThrowable$.MODULE$.unapply(compositeThrowable);
    }

    public static CompositeThrowable apply(Set<Throwable> set) {
        return CompositeThrowable$.MODULE$.apply(set);
    }

    public static <A> Function1<Set<Throwable>, A> andThen(Function1<CompositeThrowable, A> function1) {
        CompositeThrowable$ compositeThrowable$ = CompositeThrowable$.MODULE$;
        if (compositeThrowable$ == null) {
            throw null;
        }
        return arg_0 -> Function1.$anonfun$andThen$1(compositeThrowable$, function1, arg_0);
    }

    public static <A> Function1<A, CompositeThrowable> compose(Function1<A, Set<Throwable>> function1) {
        CompositeThrowable$ compositeThrowable$ = CompositeThrowable$.MODULE$;
        if (compositeThrowable$ == null) {
            throw null;
        }
        return arg_0 -> Function1.$anonfun$compose$1(compositeThrowable$, function1, arg_0);
    }

    public Set<Throwable> throwables() {
        return this.throwables;
    }

    public CompositeThrowable copy(Set<Throwable> throwables) {
        return new CompositeThrowable(throwables);
    }

    public Set<Throwable> copy$default$1() {
        return this.throwables();
    }

    @Override
    public String productPrefix() {
        return "CompositeThrowable";
    }

    @Override
    public int productArity() {
        return 1;
    }

    @Override
    public Object productElement(int x$1) {
        switch (x$1) {
            case 0: {
                return this.throwables();
            }
        }
        throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(x$1)).toString());
    }

    @Override
    public Iterator<Object> productIterator() {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    @Override
    public boolean canEqual(Object x$1) {
        return x$1 instanceof CompositeThrowable;
    }

    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode(this);
    }

    @Override
    public boolean equals(Object x$1) {
        block3: {
            block2: {
                if (this == x$1) break block2;
                boolean bl = x$1 instanceof CompositeThrowable;
                if (!bl) break block3;
                CompositeThrowable compositeThrowable = (CompositeThrowable)x$1;
                Set<Throwable> set = this.throwables();
                Set<Throwable> set2 = compositeThrowable.throwables();
                if (!(!(set != null ? !set.equals(set2) : set2 != null))) break block3;
            }
            return true;
        }
        return false;
    }

    public CompositeThrowable(Set<Throwable> throwables) {
        this.throwables = throwables;
        super(new StringBuilder(58).append("Multiple exceptions thrown during a parallel computation: ").append(((TraversableOnce)throwables.map(new Serializable(){
            public static final long serialVersionUID = 0L;

            public final String apply(Throwable t) {
                String string = "...";
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                return new StringBuilder(0).append(Predef$any2stringadd$.MODULE$.$plus$extension(Predef$.MODULE$.any2stringadd(t), "\n")).append(Predef$.MODULE$.genericArrayOps(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])t.getStackTrace())).take(10))).$plus$plus(new StringOps(string), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Any()))).mkString("\n")).toString();
            }
        }, Set$.MODULE$.canBuildFrom())).mkString("\n\n")).toString());
        Product.$init$(this);
    }
}

