/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.ForkJoinWorkerThread;
import scala.Function0;
import scala.Serializable;
import scala.collection.parallel.ForkJoinTasks$;
import scala.collection.parallel.HavingForkJoinPool;
import scala.collection.parallel.Task;
import scala.collection.parallel.Tasks;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005\u001daaB\t\u0013!\u0003\r\t!\u0007\u0005\u0006K\u0001!\tA\n\u0004\bU\u0001\u0001\n1!\u0001,\u0011\u0015)#\u0001\"\u0001'\u0011\u0015A%\u0001\"\u0001'\u0011\u0015I%\u0001\"\u0001'\u0011\u0015Q%\u0001\"\u0001L\u0011\u0015y\u0005A\"\u0005Q\u0011\u0015a\u0006\u0001\"\u0001^\u0011\u001d\t\u0007A1A\u0007\u0002uCQA\u0019\u0001\u0005\u0002\rDQa\u001c\u0001\u0005\u0002ADQ\u0001\u001f\u0001\u0005\u0002e<Q! \n\t\u0002y4Q!\u0005\n\t\u0002}Dq!!\u0001\u000f\t\u0003\t\u0019\u0001C\u0005\u0002\u00069A)\u0019!C\u0001;\niai\u001c:l\u0015>Lg\u000eV1tWNT!a\u0005\u000b\u0002\u0011A\f'/\u00197mK2T!!\u0006\f\u0002\u0015\r|G\u000e\\3di&|gNC\u0001\u0018\u0003\u0015\u00198-\u00197b\u0007\u0001\u0019B\u0001\u0001\u000e\u001fEA\u00111\u0004H\u0007\u0002-%\u0011QD\u0006\u0002\u0007\u0003:L(+\u001a4\u0011\u0005}\u0001S\"\u0001\n\n\u0005\u0005\u0012\"!\u0002+bg.\u001c\bCA\u0010$\u0013\t!#C\u0001\nICZLgn\u001a$pe.Tu.\u001b8Q_>d\u0017A\u0002\u0013j]&$H\u0005F\u0001(!\tY\u0002&\u0003\u0002*-\t!QK\\5u\u0005-9&/\u00199qK\u0012$\u0016m]6\u0016\u00071bdiE\u0002\u0003[]\u0002\"AL\u001b\u000e\u0003=R!\u0001M\u0019\u0002\u0015\r|gnY;se\u0016tGO\u0003\u00023g\u0005!Q\u000f^5m\u0015\u0005!\u0014\u0001\u00026bm\u0006L!AN\u0018\u0003\u001fI+7-\u001e:tSZ,\u0017i\u0019;j_:\u0004B\u0001O\u001d;\u000b6\t\u0001!\u0003\u0002+AA\u00111\b\u0010\u0007\u0001\t\u0015i$A1\u0001?\u0005\u0005\u0011\u0016CA C!\tY\u0002)\u0003\u0002B-\t9aj\u001c;iS:<\u0007CA\u000eD\u0013\t!eCA\u0002B]f\u0004\"a\u000f$\u0005\r\u001d\u0013AQ1\u0001?\u0005\t!\u0006/A\u0003ti\u0006\u0014H/\u0001\u0003ts:\u001c\u0017!\u0003;ss\u000e\u000bgnY3m)\u0005a\u0005CA\u000eN\u0013\tqeCA\u0004C_>dW-\u00198\u0002\u001d9,wo\u0016:baB,G\rV1tWV\u0019\u0011\u000b\u0016,\u0015\u0005I;\u0006\u0003\u0002\u001d\u0003'V\u0003\"a\u000f+\u0005\u000bu:!\u0019\u0001 \u0011\u0005m2F!B$\b\u0005\u0004q\u0004\"\u0002-\b\u0001\u0004I\u0016!\u00012\u0011\t}Q6+V\u0005\u00037J\u0011A\u0001V1tW\u0006aam\u001c:l\u0015>Lg\u000eU8pYV\ta\f\u0005\u0002/?&\u0011\u0001m\f\u0002\r\r>\u00148NS8j]B{w\u000e\\\u0001\fK:4\u0018N]8o[\u0016tG/A\u0004fq\u0016\u001cW\u000f^3\u0016\u0007\u0011Lg\u000e\u0006\u0002fUB\u00191D\u001a5\n\u0005\u001d4\"!\u0003$v]\u000e$\u0018n\u001c81!\tY\u0014\u000eB\u0003>\u0015\t\u0007a\bC\u0003l\u0015\u0001\u0007A.\u0001\u0003uCN\\\u0007\u0003B\u0010[Q6\u0004\"a\u000f8\u0005\u000b\u001dS!\u0019\u0001 \u0002)\u0015DXmY;uK\u0006sGmV1jiJ+7/\u001e7u+\r\t8o\u001e\u000b\u0003eR\u0004\"aO:\u0005\u000buZ!\u0019\u0001 \t\u000b-\\\u0001\u0019A;\u0011\t}Q&O\u001e\t\u0003w]$QaR\u0006C\u0002y\n\u0001\u0003]1sC2dW\r\\5t[2+g/\u001a7\u0016\u0003i\u0004\"aG>\n\u0005q4\"aA%oi\u0006iai\u001c:l\u0015>Lg\u000eV1tWN\u0004\"a\b\b\u0014\u00059Q\u0012A\u0002\u001fj]&$h\bF\u0001\u007f\u0003M!WMZ1vYR4uN]6K_&t\u0007k\\8m\u0001")
public interface ForkJoinTasks
extends Tasks,
HavingForkJoinPool {
    public static ForkJoinPool defaultForkJoinPool() {
        return ForkJoinTasks$.MODULE$.defaultForkJoinPool();
    }

    public <R, Tp> WrappedTask<R, Tp> newWrappedTask(Task<R, Tp> var1);

    public static /* synthetic */ ForkJoinPool forkJoinPool$(ForkJoinTasks $this) {
        return $this.forkJoinPool();
    }

    @Override
    default public ForkJoinPool forkJoinPool() {
        return this.environment();
    }

    @Override
    public ForkJoinPool environment();

    public static /* synthetic */ Function0 execute$(ForkJoinTasks $this, Task task) {
        return $this.execute(task);
    }

    @Override
    default public <R, Tp> Function0<R> execute(Task<R, Tp> task) {
        WrappedTask fjtask = this.newWrappedTask(task);
        Thread thread2 = Thread.currentThread();
        if (thread2 instanceof ForkJoinWorkerThread && ((ForkJoinWorkerThread)thread2).getPool() == this.forkJoinPool()) {
            ((ForkJoinTask)((Object)fjtask)).fork();
        } else {
            this.forkJoinPool().execute((ForkJoinTask)((Object)fjtask));
        }
        return (Function0<Object> & java.io.Serializable & Serializable)() -> {
            fjtask.sync();
            fjtask.body().forwardThrowable();
            return fjtask.body().result();
        };
    }

    public static /* synthetic */ Object executeAndWaitResult$(ForkJoinTasks $this, Task task) {
        return $this.executeAndWaitResult(task);
    }

    @Override
    default public <R, Tp> R executeAndWaitResult(Task<R, Tp> task) {
        WrappedTask<R, Tp> fjtask = this.newWrappedTask(task);
        Thread thread2 = Thread.currentThread();
        if (thread2 instanceof ForkJoinWorkerThread && ((ForkJoinWorkerThread)thread2).getPool() == this.forkJoinPool()) {
            ((ForkJoinTask)((Object)fjtask)).fork();
        } else {
            this.forkJoinPool().execute((ForkJoinTask)((Object)fjtask));
        }
        fjtask.sync();
        fjtask.body().forwardThrowable();
        return fjtask.body().result();
    }

    public static /* synthetic */ int parallelismLevel$(ForkJoinTasks $this) {
        return $this.parallelismLevel();
    }

    @Override
    default public int parallelismLevel() {
        return this.forkJoinPool().getParallelism();
    }

    public static void $init$(ForkJoinTasks $this) {
    }

    public interface WrappedTask<R, Tp>
    extends Tasks.WrappedTask<R, Tp> {
        public static /* synthetic */ void start$(WrappedTask $this) {
            $this.start();
        }

        @Override
        default public void start() {
            ((ForkJoinTask)((Object)this)).fork();
        }

        public static /* synthetic */ void sync$(WrappedTask $this) {
            $this.sync();
        }

        @Override
        default public void sync() {
            ((ForkJoinTask)((Object)this)).join();
        }

        public static /* synthetic */ boolean tryCancel$(WrappedTask $this) {
            return $this.tryCancel();
        }

        @Override
        default public boolean tryCancel() {
            return ((ForkJoinTask)((Object)this)).tryUnfork();
        }

        public /* synthetic */ ForkJoinTasks scala$collection$parallel$ForkJoinTasks$WrappedTask$$$outer();

        public static void $init$(WrappedTask $this) {
        }
    }
}

