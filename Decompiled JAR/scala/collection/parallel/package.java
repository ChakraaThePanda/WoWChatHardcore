/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel;

import scala.Function1;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterator;
import scala.collection.parallel.TaskSupport;
import scala.collection.parallel.mutable.ParArray;
import scala.collection.parallel.mutable.ResizableParArrayCombiner;
import scala.collection.parallel.package$;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005\rq!B\u000b\u0017\u0011\u0003ib!B\u0010\u0017\u0011\u0003\u0001\u0003\"B\u0013\u0002\t\u00031\u0003bB\u0014\u0002\u0005\u0004%\t\u0001\u000b\u0005\u0007Y\u0005\u0001\u000b\u0011B\u0015\t\u000f5\n!\u0019!C\u0001Q!1a&\u0001Q\u0001\n%BqaL\u0001C\u0002\u0013\u0005\u0001\u0007\u0003\u00045\u0003\u0001\u0006I!\r\u0005\bk\u0005\u0011\r\u0011\"\u0001)\u0011\u00191\u0014\u0001)A\u0005S!)q'\u0001C\u0001q!9Q(\u0001b\u0001\n\u0003q\u0004B\u0002\"\u0002A\u0003%q\bC\u0003D\u0003\u0011\u0005AI\u0002\u0003V\u0003\u00051\u0006\u0002\u0003*\u0010\u0005\u0003\u0005\u000b\u0011\u0002-\t\u0011m{!\u0011!Q\u0001\fqCQ!J\b\u0005\u0002\u0019DQ\u0001\\\b\u0005\u00025Dq\u0001^\u0001\u0002\u0002\u0013\rQ/A\u0004qC\u000e\\\u0017mZ3\u000b\u0005]A\u0012\u0001\u00039be\u0006dG.\u001a7\u000b\u0005eQ\u0012AC2pY2,7\r^5p]*\t1$A\u0003tG\u0006d\u0017m\u0001\u0001\u0011\u0005y\tQ\"\u0001\f\u0003\u000fA\f7m[1hKN\u0011\u0011!\t\t\u0003E\rj\u0011AG\u0005\u0003Ii\u0011a!\u00118z%\u00164\u0017A\u0002\u001fj]&$h\bF\u0001\u001e\u00031i\u0015JT0G\u001fJ{6i\u0014)Z+\u0005I\u0003C\u0001\u0012+\u0013\tY#DA\u0002J]R\fQ\"T%O?\u001a{%kX\"P!f\u0003\u0013AC\"I\u000b\u000e[uLU!U\u000b\u0006Y1\tS#D\u0017~\u0013\u0016\tV#!\u0003\u0015\u0019\u0016K\u0015+3+\u0005\t\u0004C\u0001\u00123\u0013\t\u0019$D\u0001\u0004E_V\u0014G.Z\u0001\u0007'F\u0013FK\r\u0011\u0002'\u00054\u0018-\u001b7bE2,\u0007K]8dKN\u001cxN]:\u0002)\u00054\u0018-\u001b7bE2,\u0007K]8dKN\u001cxN]:!\u0003E!\bN]3tQ>dGM\u0012:p[NK'0\u001a\u000b\u0004SeZ\u0004\"\u0002\u001e\f\u0001\u0004I\u0013AA:{\u0011\u0015a4\u00021\u0001*\u0003A\u0001\u0018M]1mY\u0016d\u0017n]7MKZ,G.\u0001\neK\u001a\fW\u000f\u001c;UCN\\7+\u001e9q_J$X#A \u0011\u0005y\u0001\u0015BA!\u0017\u0005-!\u0016m]6TkB\u0004xN\u001d;\u0002'\u0011,g-Y;miR\u000b7o[*vaB|'\u000f\u001e\u0011\u0002\u001dM,G\u000fV1tWN+\b\u000f]8siV\u0011Q\t\u0013\u000b\u0004\rF\u001b\u0006CA$I\u0019\u0001!Q!\u0013\bC\u0002)\u0013AaQ8mYF\u00111J\u0014\t\u0003E1K!!\u0014\u000e\u0003\u000f9{G\u000f[5oOB\u0011!eT\u0005\u0003!j\u00111!\u00118z\u0011\u0015\u0011f\u00021\u0001G\u0003\u0005\u0019\u0007\"\u0002+\u000f\u0001\u0004y\u0014!\u0001;\u00033\r{G\u000e\\3di&|gn\u001d%bm\u0016$v\u000eU1s\u0003J\u0014\u0018-_\u000b\u0004/f#7CA\b\"!\t9\u0015\fB\u0003[\u001f\t\u0007!JA\u0001D\u0003\u0015\t7o\u0012;p!\u0011\u0011S\fW0\n\u0005yS\"!\u0003$v]\u000e$\u0018n\u001c82!\r\u0001\u0017mY\u0007\u00021%\u0011!\r\u0007\u0002\u0013\u000f\u0016tGK]1wKJ\u001c\u0018M\u00197f\u001f:\u001cW\r\u0005\u0002HI\u0012)Qm\u0004b\u0001\u0015\n\tA\u000b\u0006\u0002hWR\u0011\u0001N\u001b\t\u0005S>A6-D\u0001\u0002\u0011\u0015Y&\u0003q\u0001]\u0011\u0015\u0011&\u00031\u0001Y\u0003)!x\u000eU1s\u0003J\u0014\u0018-_\u000b\u0002]B\u0019qN]2\u000e\u0003AT!!\u001d\f\u0002\u000f5,H/\u00192mK&\u00111\u000f\u001d\u0002\t!\u0006\u0014\u0018I\u001d:bs\u0006I2i\u001c7mK\u000e$\u0018n\u001c8t\u0011\u00064X\rV8QCJ\f%O]1z+\r1(\u0010 \u000b\u0004o\u0006\u0005AC\u0001=~!\u0011Iw\"_>\u0011\u0005\u001dSH!\u0002.\u0015\u0005\u0004Q\u0005CA$}\t\u0015)GC1\u0001K\u0011\u0015YF\u0003q\u0001\u007f!\u0011\u0011S,_@\u0011\u0007\u0001\f7\u0010C\u0003S)\u0001\u0007\u0011\u0010")
public final class package {
    public static <C, T> CollectionsHaveToParArray<C, T> CollectionsHaveToParArray(C c, Function1<C, GenTraversableOnce<T>> function1) {
        return package$.MODULE$.CollectionsHaveToParArray(c, function1);
    }

    public static <Coll> Coll setTaskSupport(Coll Coll, TaskSupport taskSupport) {
        return package$.MODULE$.setTaskSupport(Coll, taskSupport);
    }

    public static TaskSupport defaultTaskSupport() {
        return package$.MODULE$.defaultTaskSupport();
    }

    public static int thresholdFromSize(int n, int n2) {
        return package$.MODULE$.thresholdFromSize(n, n2);
    }

    public static int availableProcessors() {
        return package$.MODULE$.availableProcessors();
    }

    public static double SQRT2() {
        return package$.MODULE$.SQRT2();
    }

    public static int CHECK_RATE() {
        return package$.MODULE$.CHECK_RATE();
    }

    public static int MIN_FOR_COPY() {
        return package$.MODULE$.MIN_FOR_COPY();
    }

    public static class CollectionsHaveToParArray<C, T> {
        private final C c;
        private final Function1<C, GenTraversableOnce<T>> asGto;

        public ParArray<T> toParArray() {
            GenTraversableOnce<T> t = this.asGto.apply(this.c);
            if (t instanceof ParArray) {
                return (ParArray)t;
            }
            Iterator<T> it = t.toIterator();
            ResizableParArrayCombiner cb = scala.collection.parallel.mutable.package$.MODULE$.ParArrayCombiner().apply();
            while (it.hasNext()) {
                cb.$plus$eq(it.next());
            }
            return (ParArray)cb.result();
        }

        public CollectionsHaveToParArray(C c, Function1<C, GenTraversableOnce<T>> asGto) {
            this.c = c;
            this.asGto = asGto;
        }
    }
}

