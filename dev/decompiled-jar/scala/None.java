/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.Function0;
import scala.Function1;
import scala.None$;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.collection.Iterator;
import scala.collection.immutable.List;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;
import scala.runtime.Null$;
import scala.util.Either;

@ScalaSignature(bytes="\u0006\u0001m;Q!\u0004\b\t\u0002F1Qa\u0005\b\t\u0002RAQ!I\u0001\u0005\u0002\tBQaI\u0001\u0005\u0002\u0011BQ\u0001K\u0001\u0005\u0002%BqAK\u0001\u0002\u0002\u0013\u00053\u0006C\u00045\u0003\u0005\u0005I\u0011A\u001b\t\u000fe\n\u0011\u0011!C\u0001u!9\u0001)AA\u0001\n\u0003\n\u0005b\u0002%\u0002\u0003\u0003%\t!\u0013\u0005\b\u0017\u0006\t\t\u0011\"\u0011M\u0011\u001di\u0015!!A\u0005B9CqaT\u0001\u0002\u0002\u0013%\u0001+\u0001\u0003O_:,'\"A\b\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001A\u0011!#A\u0007\u0002\u001d\t!aj\u001c8f'\u0011\tQc\u0007\u0010\u0011\u0007I1\u0002$\u0003\u0002\u0018\u001d\t1q\n\u001d;j_:\u0004\"AE\r\n\u0005iq!a\u0002(pi\"Lgn\u001a\t\u0003%qI!!\b\b\u0003\u000fA\u0013x\u000eZ;diB\u0011!cH\u0005\u0003A9\u0011AbU3sS\u0006d\u0017N_1cY\u0016\fa\u0001P5oSRtD#A\t\u0002\u000f%\u001cX)\u001c9usV\tQ\u0005\u0005\u0002\u0013M%\u0011qE\u0004\u0002\b\u0005>|G.Z1o\u0003\r9W\r^\u000b\u00021\u0005i\u0001O]8ek\u000e$\bK]3gSb,\u0012\u0001\f\t\u0003[Ij\u0011A\f\u0006\u0003_A\nA\u0001\\1oO*\t\u0011'\u0001\u0003kCZ\f\u0017BA\u001a/\u0005\u0019\u0019FO]5oO\u0006a\u0001O]8ek\u000e$\u0018I]5usV\ta\u0007\u0005\u0002\u0013o%\u0011\u0001H\u0004\u0002\u0004\u0013:$\u0018A\u00049s_\u0012,8\r^#mK6,g\u000e\u001e\u000b\u0003wy\u0002\"A\u0005\u001f\n\u0005ur!aA!os\"9qhBA\u0001\u0002\u00041\u0014a\u0001=%c\u0005y\u0001O]8ek\u000e$\u0018\n^3sCR|'/F\u0001C!\r\u0019eiO\u0007\u0002\t*\u0011QID\u0001\u000bG>dG.Z2uS>t\u0017BA$E\u0005!IE/\u001a:bi>\u0014\u0018\u0001C2b]\u0016\u000bX/\u00197\u0015\u0005\u0015R\u0005bB \n\u0003\u0003\u0005\raO\u0001\tQ\u0006\u001c\bnQ8eKR\ta'\u0001\u0005u_N#(/\u001b8h)\u0005a\u0013a\u0003:fC\u0012\u0014Vm]8mm\u0016$\u0012!\u0015\t\u0003[IK!a\u0015\u0018\u0003\r=\u0013'.Z2uQ\u0011\tQ\u000bW-\u0011\u0005I1\u0016BA,\u000f\u0005A\u0019VM]5bYZ+'o]5p]VKE)A\u0003wC2,XM\b\u0005G!\u00122@K3K-R\u0011\u0001Q\u000bW-")
public final class None {
    public static String toString() {
        return None$.MODULE$.toString();
    }

    public static int hashCode() {
        return None$.MODULE$.hashCode();
    }

    public static boolean canEqual(Object object) {
        return None$.MODULE$.canEqual(object);
    }

    public static Iterator<Object> productIterator() {
        return None$.MODULE$.productIterator();
    }

    public static Object productElement(int n) {
        return None$.MODULE$.productElement(n);
    }

    public static int productArity() {
        return None$.MODULE$.productArity();
    }

    public static String productPrefix() {
        return None$.MODULE$.productPrefix();
    }

    public static Nothing$ get() {
        return None$.MODULE$.get();
    }

    public static boolean isEmpty() {
        return None$.MODULE$.isEmpty();
    }

    public static <X> Either<Nothing$, X> toLeft(Function0<X> function0) {
        return None$.MODULE$.toLeft(function0);
    }

    public static <X> Either<X, Nothing$> toRight(Function0<X> function0) {
        return None$.MODULE$.toRight(function0);
    }

    public static List<Nothing$> toList() {
        return None$.MODULE$.toList();
    }

    public static Iterator<Nothing$> iterator() {
        return None$.MODULE$.iterator();
    }

    public static <B> Option<B> orElse(Function0<Option<B>> function0) {
        return None$.MODULE$.orElse(function0);
    }

    public static <B> Option<B> collect(PartialFunction<Nothing$, B> partialFunction) {
        return None$.MODULE$.collect(partialFunction);
    }

    public static <U> void foreach(Function1<Nothing$, U> function1) {
        None$.MODULE$.foreach(function1);
    }

    public static boolean forall(Function1<Nothing$, Object> function1) {
        return None$.MODULE$.forall(function1);
    }

    public static boolean exists(Function1<Nothing$, Object> function1) {
        return None$.MODULE$.exists(function1);
    }

    public static <A1> boolean contains(A1 A1) {
        return None$.MODULE$.contains(A1);
    }

    public static Option.WithFilter withFilter(Function1<Nothing$, Object> function1) {
        return None$.MODULE$.withFilter(function1);
    }

    public static boolean nonEmpty() {
        return None$.MODULE$.nonEmpty();
    }

    public static Option<Nothing$> filterNot(Function1<Nothing$, Object> function1) {
        return None$.MODULE$.filterNot(function1);
    }

    public static Option<Nothing$> filter(Function1<Nothing$, Object> function1) {
        return None$.MODULE$.filter(function1);
    }

    public static <B> Option<B> flatten(Predef$.less.colon.less<Nothing$, Option<B>> less2) {
        return None$.MODULE$.flatten(less2);
    }

    public static <B> Option<B> flatMap(Function1<Nothing$, Option<B>> function1) {
        return None$.MODULE$.flatMap(function1);
    }

    public static <B> B fold(Function0<B> function0, Function1<Nothing$, B> function1) {
        return None$.MODULE$.fold(function0, function1);
    }

    public static <B> Option<B> map(Function1<Nothing$, B> function1) {
        return None$.MODULE$.map(function1);
    }

    public static <A1> A1 orNull(Predef$.less.colon.less<Null$, A1> less2) {
        return None$.MODULE$.orNull(less2);
    }

    public static <B> B getOrElse(Function0<B> function0) {
        return None$.MODULE$.getOrElse(function0);
    }

    public static boolean isDefined() {
        return None$.MODULE$.isDefined();
    }
}

