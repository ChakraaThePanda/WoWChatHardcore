/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.None$;
import scala.Serializable;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.parallel.Task;
import scala.collection.parallel.Tasks;
import scala.concurrent.Await$;
import scala.concurrent.ExecutionContext;
import scala.concurrent.Future;
import scala.concurrent.Future$;
import scala.concurrent.duration.Duration$;
import scala.math.package$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.util.Failure;
import scala.util.Success;
import scala.util.Try;

@ScalaSignature(bytes="\u0006\u0001\u00014Qa\u0003\u0007\u0003\u0019IA\u0001b\u0007\u0001\u0003\u0002\u0003\u0006I!\b\u0005\u0006G\u0001!\t\u0001\n\u0005\bO\u0001\u0011\r\u0011\"\u0003)\u0011\u0019a\u0003\u0001)A\u0005S!9Q\u0006\u0001b\u0001\n\u0003q\u0003BB\u0018\u0001A\u0003%Q\u0004C\u00031\u0001\u0011%\u0011\u0007C\u0003J\u0001\u0011\u0005!\nC\u0003W\u0001\u0011\u0005q\u000bC\u0003`\u0001\u0011\u0005\u0001FA\u0006GkR,(/\u001a+bg.\u001c(BA\u0007\u000f\u0003!\u0001\u0018M]1mY\u0016d'BA\b\u0011\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002#\u0005)1oY1mCN\u0019\u0001aE\f\u0011\u0005Q)R\"\u0001\t\n\u0005Y\u0001\"AB!osJ+g\r\u0005\u0002\u001935\tA\"\u0003\u0002\u001b\u0019\t)A+Y:lg\u0006AQ\r_3dkR|'o\u0001\u0001\u0011\u0005y\tS\"A\u0010\u000b\u0005\u0001\u0002\u0012AC2p]\u000e,(O]3oi&\u0011!e\b\u0002\u0011\u000bb,7-\u001e;j_:\u001cuN\u001c;fqR\fa\u0001P5oSRtDCA\u0013'!\tA\u0002\u0001C\u0003\u001c\u0005\u0001\u0007Q$\u0001\u0005nCb$W\r\u001d;i+\u0005I\u0003C\u0001\u000b+\u0013\tY\u0003CA\u0002J]R\f\u0011\"\\1yI\u0016\u0004H\u000f\u001b\u0011\u0002\u0017\u0015tg/\u001b:p]6,g\u000e^\u000b\u0002;\u0005aQM\u001c<je>tW.\u001a8uA\u0005!Q\r_3d+\r\u0011\u0004h\u0012\u000b\u0003g\u0005\u00032A\b\u001b7\u0013\t)tD\u0001\u0004GkR,(/\u001a\t\u0003oab\u0001\u0001B\u0003:\u000f\t\u0007!HA\u0001S#\tYd\b\u0005\u0002\u0015y%\u0011Q\b\u0005\u0002\b\u001d>$\b.\u001b8h!\t!r(\u0003\u0002A!\t\u0019\u0011I\\=\t\u000b\t;\u0001\u0019A\"\u0002\u0019Q|\u0007\u000fT3wK2$\u0016m]6\u0011\ta!eGR\u0005\u0003\u000b2\u0011A\u0001V1tWB\u0011qg\u0012\u0003\u0006\u0011\u001e\u0011\rA\u000f\u0002\u0003)B\fq!\u001a=fGV$X-F\u0002L!V#\"\u0001T)\u0011\u0007Qiu*\u0003\u0002O!\tIa)\u001e8di&|g\u000e\r\t\u0003oA#Q!\u000f\u0005C\u0002iBQA\u0015\u0005A\u0002M\u000bA\u0001^1tWB!\u0001\u0004R(U!\t9T\u000bB\u0003I\u0011\t\u0007!(\u0001\u000bfq\u0016\u001cW\u000f^3B]\u0012<\u0016-\u001b;SKN,H\u000e^\u000b\u00041jsFCA-\\!\t9$\fB\u0003:\u0013\t\u0007!\bC\u0003S\u0013\u0001\u0007A\f\u0005\u0003\u0019\tfk\u0006CA\u001c_\t\u0015A\u0015B1\u0001;\u0003A\u0001\u0018M]1mY\u0016d\u0017n]7MKZ,G\u000e")
public final class FutureTasks
implements Tasks {
    private final int maxdepth;
    private final ExecutionContext environment;
    private final ArrayBuffer<String> debugMessages;

    @Override
    public ArrayBuffer<String> debuglog(String s) {
        return Tasks.debuglog$(this, s);
    }

    @Override
    public ArrayBuffer<String> debugMessages() {
        return this.debugMessages;
    }

    @Override
    public void scala$collection$parallel$Tasks$_setter_$debugMessages_$eq(ArrayBuffer<String> x$1) {
        this.debugMessages = x$1;
    }

    private int maxdepth() {
        return this.maxdepth;
    }

    @Override
    public ExecutionContext environment() {
        return this.environment;
    }

    private <R, Tp> Future<R> exec(Task<R, Tp> topLevelTask) {
        ExecutionContext ec = this.environment();
        return this.compute$1(topLevelTask, 0, ec).map((Function1<Task, Object> & java.io.Serializable & Serializable)t -> {
            t.forwardThrowable();
            return t.result();
        }, ec);
    }

    @Override
    public <R, Tp> Function0<R> execute(Task<R, Tp> task) {
        return () -> FutureTasks.$anonfun$execute$3(this.exec(task));
    }

    @Override
    public <R, Tp> R executeAndWaitResult(Task<R, Tp> task) {
        return this.execute(task).apply();
    }

    @Override
    public int parallelismLevel() {
        return Runtime.getRuntime().availableProcessors();
    }

    /*
     * WARNING - void declaration
     */
    private final Future compute$1(Task task, int depth, ExecutionContext ec$1) {
        void apply_body;
        if (task.shouldSplitFurther() && depth < this.maxdepth()) {
            return ((Future)task.split().iterator().map((Function1<Task, Future> & java.io.Serializable & Serializable)subtask -> this.compute$1((Task)subtask, depth + 1, ec$1)).reduceLeft((Function2<Future, Future, Future> & java.io.Serializable & Serializable)(firstFuture, nextFuture) -> firstFuture.flatMap((Function1<Task, Future> & java.io.Serializable & Serializable)firstTask -> nextFuture.map((Function1<Task, Task> & java.io.Serializable & Serializable)nextTask -> {
                firstTask.tryMerge(nextTask.repr());
                return firstTask;
            }, ec$1), ec$1))).andThen(new Serializable(null, task){
                public static final long serialVersionUID = 0L;
                private final Task task$1;

                public final <A1 extends Try<Task<R, Tp>>, B1> B1 applyOrElse(A1 x1, Function1<A1, B1> function1) {
                    Object object;
                    if (x1 instanceof Success) {
                        Task firstTask = (Task)((Success)x1).value();
                        this.task$1.throwable_$eq(firstTask.throwable());
                        this.task$1.result_$eq(firstTask.result());
                        object = BoxedUnit.UNIT;
                    } else if (x1 instanceof Failure) {
                        Throwable exception = ((Failure)x1).exception();
                        this.task$1.throwable_$eq(exception);
                        object = BoxedUnit.UNIT;
                    } else {
                        object = function1.apply(x1);
                    }
                    return object;
                }

                public final boolean isDefinedAt(Try<Task<R, Tp>> x1) {
                    boolean bl = x1 instanceof Success ? true : x1 instanceof Failure;
                    return bl;
                }
                {
                    this.task$1 = task$1;
                }
            }, ec$1);
        }
        Future$ future$ = Future$.MODULE$;
        Function0<Task> & java.io.Serializable & Serializable intersect = (Function0<Task> & java.io.Serializable & Serializable)() -> {
            task.tryLeaf(None$.MODULE$);
            return task;
        };
        if (future$ == null) {
            throw null;
        }
        return future$.unit().map(arg_0 -> Future$.$anonfun$apply$1((Function0)apply_body, arg_0), ec$1);
    }

    public static final /* synthetic */ Object $anonfun$execute$3(Future future$1) {
        return Await$.MODULE$.result(future$1, Duration$.MODULE$.Inf());
    }

    public FutureTasks(ExecutionContext executor) {
        Tasks.$init$(this);
        this.maxdepth = (int)(package$.MODULE$.log(this.parallelismLevel()) / package$.MODULE$.log(2.0) + 1.0);
        this.environment = executor;
    }
}

