/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel;

import scala.Function0;
import scala.Option;
import scala.Serializable;
import scala.collection.Seq;
import scala.reflect.ScalaSignature;
import scala.runtime.java8.JFunction0$mcV$sp;
import scala.util.control.BreakControl;
import scala.util.control.Breaks;
import scala.util.control.Breaks$;

@ScalaSignature(bytes="\u0006\u0001\u0005\u0005aaB\t\u0013!\u0003\r\t!\u0007\u0005\u0006?\u0001!\t\u0001I\u0003\u0005I\u0001\u0001Q\u0005C\u00031\u0001\u0011\u0005\u0011\u0007C\u00036\u0001\u0019\u0005a\u0007C\u00049\u0001\u0001\u0007i\u0011\u0001\u001f\t\u000fu\u0002\u0001\u0019!D\u0001}!)\u0011\t\u0001D\u0001\u0005\"1a\t\u0001D\u0001%\u001dCa!\u0015\u0001\u0005\u0002I\u0011\u0006bB0\u0001\u0001\u0004%\t\u0001\u0019\u0005\bQ\u0002\u0001\r\u0011\"\u0001j\u0011\u0015Y\u0007\u0001\"\u0001!\u0011\u0019a\u0007\u0001\"\u0001\u0013[\"1\u0001\u000f\u0001C\u0001%EDa\u0001\u001e\u0001\u0005\u0002I)\bBB@\u0001\t\u0003\u0011\u0002E\u0001\u0003UCN\\'BA\n\u0015\u0003!\u0001\u0018M]1mY\u0016d'BA\u000b\u0017\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002/\u0005)1oY1mC\u000e\u0001Qc\u0001\u000e(gM\u0011\u0001a\u0007\t\u00039ui\u0011AF\u0005\u0003=Y\u0011a!\u00118z%\u00164\u0017A\u0002\u0013j]&$H\u0005F\u0001\"!\ta\"%\u0003\u0002$-\t!QK\\5u\u0005\u0019\u0011Vm];miB\u0011ae\n\u0007\u0001\t\u0015A\u0003A1\u0001*\u0005\u0005\u0011\u0016C\u0001\u0016.!\ta2&\u0003\u0002--\t9aj\u001c;iS:<\u0007C\u0001\u000f/\u0013\tycCA\u0002B]f\fAA]3qeV\t!\u0007\u0005\u0002'g\u00111A\u0007\u0001CC\u0002%\u0012!\u0001\u00169\u0002\t1,\u0017M\u001a\u000b\u0003C]BQ\u0001\u000f\u0003A\u0002e\naA]3tk2$\bc\u0001\u000f;K%\u00111H\u0006\u0002\u0007\u001fB$\u0018n\u001c8\u0016\u0003\u0015\n!B]3tk2$x\fJ3r)\t\ts\bC\u0004A\r\u0005\u0005\t\u0019A\u0013\u0002\u0007a$\u0013'\u0001\ntQ>,H\u000eZ*qY&$h)\u001e:uQ\u0016\u0014X#A\"\u0011\u0005q!\u0015BA#\u0017\u0005\u001d\u0011un\u001c7fC:\fQa\u001d9mSR,\u0012\u0001\u0013\t\u0004\u00132{eB\u0001\u000fK\u0013\tYe#A\u0004qC\u000e\\\u0017mZ3\n\u00055s%aA*fc*\u00111J\u0006\t\u0005!\u0002)#'D\u0001\u0013\u0003\u0015iWM]4f)\t\t3\u000bC\u0003U\u0013\u0001\u0007Q+\u0001\u0003uQ\u0006$(F\u0001\u001aWW\u00059\u0006C\u0001-^\u001b\u0005I&B\u0001.\\\u0003%)hn\u00195fG.,GM\u0003\u0002]-\u0005Q\u0011M\u001c8pi\u0006$\u0018n\u001c8\n\u0005yK&!E;oG\",7m[3e-\u0006\u0014\u0018.\u00198dK\u0006IA\u000f\u001b:po\u0006\u0014G.Z\u000b\u0002CB\u0011\u0011JY\u0005\u0003G:\u0013\u0011\u0002\u00165s_^\f'\r\\3)\u0005))\u0007C\u0001\u000fg\u0013\t9gC\u0001\u0005w_2\fG/\u001b7f\u00035!\bN]8xC\ndWm\u0018\u0013fcR\u0011\u0011E\u001b\u0005\b\u0001.\t\t\u00111\u0001b\u0003A1wN]<be\u0012$\u0006N]8xC\ndW-A\u0004uefdU-\u00194\u0015\u0005\u0005r\u0007\"B8\u000e\u0001\u0004I\u0014a\u00027bgR\u0014Xm]\u0001\tiJLX*\u001a:hKR\u0011\u0011E\u001d\u0005\u0006g:\u0001\r!V\u0001\u0002i\u0006yQ.\u001a:hKRC'o\\<bE2,7\u000f\u0006\u0002\"m\")Ak\u0004a\u0001oB\u001a\u0001P_?\u0011\tA\u0003\u0011\u0010 \t\u0003Mi$\u0011b\u001f<\u0002\u0002\u0003\u0005)\u0011A\u0015\u0003\u0007}#\u0013\u0007\u0005\u0002'{\u0012IaP^A\u0001\u0002\u0003\u0015\t!\u000b\u0002\u0004?\u0012\u0012\u0014aC:jO:\fG.\u00112peR\u0004")
public interface Task<R, Tp> {
    public static /* synthetic */ Object repr$(Task $this) {
        return $this.repr();
    }

    default public Tp repr() {
        return (Tp)this;
    }

    public void leaf(Option<R> var1);

    public R result();

    public void result_$eq(R var1);

    public boolean shouldSplitFurther();

    public Seq<Task<R, Tp>> split();

    public static /* synthetic */ void merge$(Task $this, Object that) {
        $this.merge(that);
    }

    default public void merge(Tp that) {
    }

    public Throwable throwable();

    public void throwable_$eq(Throwable var1);

    public static /* synthetic */ void forwardThrowable$(Task $this) {
        $this.forwardThrowable();
    }

    default public void forwardThrowable() {
        if (this.throwable() != null) {
            throw this.throwable();
        }
    }

    public static /* synthetic */ void tryLeaf$(Task $this, Option lastres) {
        $this.tryLeaf(lastres);
    }

    /*
     * WARNING - void declaration
     */
    default public void tryLeaf(Option<R> lastres) {
        try {
            void tryBreakable_op;
            Breaks$ breaks$ = Breaks$.MODULE$;
            JFunction0$mcV$sp & Serializable intersect = (JFunction0$mcV$sp & Serializable)() -> {
                this.leaf(lastres);
                this.result_$eq(this.result());
            };
            if (breaks$ == null) {
                throw null;
            }
            Breaks$ tryBreakable_this = breaks$;
            new Breaks.TryBlock<T>(tryBreakable_this, (Function0)tryBreakable_op){
                private final /* synthetic */ Breaks $outer;
                private final Function0 op$1;

                public T catchBreak(Function0<T> onBreak) {
                    try {
                        return (T)this.op$1.apply();
                    }
                    catch (BreakControl ex) {
                        if (ex != this.$outer.scala$util$control$Breaks$$breakException()) {
                            throw ex;
                        }
                        return onBreak.apply();
                    }
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                    this.op$1 = op$1;
                }
            }.catchBreak((JFunction0$mcV$sp & Serializable)() -> this.signalAbort());
            return;
        }
        catch (Throwable thr) {
            this.result_$eq(this.result());
            this.throwable_$eq(thr);
            this.signalAbort();
            return;
        }
    }

    public static /* synthetic */ void tryMerge$(Task $this, Object t) {
        $this.tryMerge(t);
    }

    default public void tryMerge(Tp t) {
        Task that = (Task)t;
        if (this.throwable() == null && that.throwable() == null) {
            this.merge(t);
        }
        this.mergeThrowables(that);
    }

    public static /* synthetic */ void mergeThrowables$(Task $this, Task that) {
        $this.mergeThrowables(that);
    }

    default public void mergeThrowables(Task<?, ?> that) {
        if (this.throwable() != null && that.throwable() != null) {
            this.throwable().addSuppressed(that.throwable());
            return;
        }
        if (this.throwable() == null && that.throwable() != null) {
            this.throwable_$eq(that.throwable());
        }
    }

    public static /* synthetic */ void signalAbort$(Task $this) {
        $this.signalAbort();
    }

    default public void signalAbort() {
    }

    public static void $init$(Task $this) {
        $this.throwable_$eq(null);
    }
}

