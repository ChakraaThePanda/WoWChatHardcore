/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import scala.Function0;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.parallel.AdaptiveWorkStealingTasks;
import scala.collection.parallel.AdaptiveWorkStealingThreadPoolTasks;
import scala.collection.parallel.Task;
import scala.collection.parallel.TaskSupport;
import scala.collection.parallel.Tasks;
import scala.collection.parallel.ThreadPoolTaskSupport$;
import scala.collection.parallel.ThreadPoolTasks;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u00193A\u0001C\u0005\u0001!!AA\u0004\u0001BC\u0002\u0013\u0005Q\u0004\u0003\u0005)\u0001\t\u0005\t\u0015!\u0003\u001f\u0011\u0015I\u0003\u0001\"\u0001+\u000f\u001d)\u0014\"!A\t\u0002Y2q\u0001C\u0005\u0002\u0002#\u0005q\u0007C\u0003*\u000b\u0011\u0005\u0001\bC\u0004:\u000bE\u0005I\u0011\u0001\u001e\u0003+QC'/Z1e!>|G\u000eV1tWN+\b\u000f]8si*\u0011!bC\u0001\ta\u0006\u0014\u0018\r\u001c7fY*\u0011A\"D\u0001\u000bG>dG.Z2uS>t'\"\u0001\b\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001M!\u0001!E\u000b\u001a!\t\u00112#D\u0001\u000e\u0013\t!RB\u0001\u0004B]f\u0014VM\u001a\t\u0003-]i\u0011!C\u0005\u00031%\u00111\u0002V1tWN+\b\u000f]8siB\u0011aCG\u0005\u00037%\u00111%\u00113baRLg/Z,pe.\u001cF/Z1mS:<G\u000b\u001b:fC\u0012\u0004vn\u001c7UCN\\7/A\u0006f]ZL'o\u001c8nK:$X#\u0001\u0010\u0011\u0005}1S\"\u0001\u0011\u000b\u0005\u0005\u0012\u0013AC2p]\u000e,(O]3oi*\u00111\u0005J\u0001\u0005kRLGNC\u0001&\u0003\u0011Q\u0017M^1\n\u0005\u001d\u0002#A\u0005+ie\u0016\fG\rU8pY\u0016CXmY;u_J\fA\"\u001a8wSJ|g.\\3oi\u0002\na\u0001P5oSRtDCA\u0016-!\t1\u0002\u0001C\u0004\u001d\u0007A\u0005\t\u0019\u0001\u0010)\t\u0001q\u0013g\r\t\u0003%=J!\u0001M\u0007\u0003\u0015\u0011,\u0007O]3dCR,G-I\u00013\u0003\u0005*8/\u001a\u0011a\r>\u00148NS8j]R\u000b7o[*vaB|'\u000f\u001e1!S:\u001cH/Z1eC\u0005!\u0014A\u0002\u001a/cEr\u0003'A\u000bUQJ,\u0017\r\u001a)p_2$\u0016m]6TkB\u0004xN\u001d;\u0011\u0005Y)1CA\u0003\u0012)\u00051\u0014a\u0007\u0013mKN\u001c\u0018N\\5uI\u001d\u0014X-\u0019;fe\u0012\"WMZ1vYR$\u0013'F\u0001<U\tqBhK\u0001>!\tq4)D\u0001@\u0015\t\u0001\u0015)A\u0005v]\u000eDWmY6fI*\u0011!)D\u0001\u000bC:tw\u000e^1uS>t\u0017B\u0001#@\u0005E)hn\u00195fG.,GMV1sS\u0006t7-\u001a\u0015\u0005\u000b9\n4\u0007")
public class ThreadPoolTaskSupport
implements TaskSupport,
AdaptiveWorkStealingThreadPoolTasks {
    private final ThreadPoolExecutor environment;
    private volatile int totaltasks;
    private final ArrayBuffer<String> debugMessages;

    public static ThreadPoolExecutor $lessinit$greater$default$1() {
        return ThreadPoolTaskSupport$.MODULE$.$lessinit$greater$default$1();
    }

    @Override
    public <R, Tp> AdaptiveWorkStealingThreadPoolTasks.WrappedTask<R, Tp> newWrappedTask(Task<R, Tp> b) {
        return AdaptiveWorkStealingThreadPoolTasks.newWrappedTask$(this, b);
    }

    @Override
    public ThreadPoolExecutor executor() {
        return ThreadPoolTasks.executor$(this);
    }

    @Override
    public LinkedBlockingQueue<Runnable> queue() {
        return ThreadPoolTasks.queue$(this);
    }

    @Override
    public <R, Tp> Function0<R> execute(Task<R, Tp> task) {
        return ThreadPoolTasks.execute$(this, task);
    }

    @Override
    public <R, Tp> R executeAndWaitResult(Task<R, Tp> task) {
        return (R)ThreadPoolTasks.executeAndWaitResult$(this, task);
    }

    @Override
    public int parallelismLevel() {
        return ThreadPoolTasks.parallelismLevel$(this);
    }

    @Override
    public ArrayBuffer<String> debuglog(String s) {
        return Tasks.debuglog$(this, s);
    }

    @Override
    public int totaltasks() {
        return this.totaltasks;
    }

    @Override
    public void totaltasks_$eq(int x$1) {
        this.totaltasks = x$1;
    }

    @Override
    public ArrayBuffer<String> debugMessages() {
        return this.debugMessages;
    }

    @Override
    public void scala$collection$parallel$Tasks$_setter_$debugMessages_$eq(ArrayBuffer<String> x$1) {
        this.debugMessages = x$1;
    }

    @Override
    public ThreadPoolExecutor environment() {
        return this.environment;
    }

    public ThreadPoolTaskSupport(ThreadPoolExecutor environment) {
        this.environment = environment;
        Tasks.$init$(this);
        ThreadPoolTasks.$init$(this);
        AdaptiveWorkStealingTasks.$init$(this);
        AdaptiveWorkStealingThreadPoolTasks.$init$(this);
    }
}

