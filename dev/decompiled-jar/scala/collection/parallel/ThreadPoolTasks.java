/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicLong;
import scala.Function0;
import scala.Serializable;
import scala.collection.parallel.Task;
import scala.collection.parallel.Tasks;
import scala.collection.parallel.ThreadPoolTasks$;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005UeaB\u0011#!\u0003\r\t!\u000b\u0005\u0006e\u0001!\ta\r\u0004\bo\u0001\u0001\n1!\u00019\u0011\u0015\u0011$\u0001\"\u00014\u0011\u001d1&\u00011A\u0005\u0002]Cqa\u0018\u0002A\u0002\u0013\u0005\u0001\rC\u0004d\u0005\u0001\u0007I\u0011A,\t\u000f\u0015\u0014\u0001\u0019!C\u0001M\")\u0001N\u0001C\u0001g!)\u0011N\u0001C\u0001g!)!N\u0001C\u0001W\")AN\u0001C\u0001g!)QN\u0001C!g!)a\u000e\u0001D\t_\"91\u0010\u0001b\u0001\u000e\u0003a\bBBA\u0006\u0001\u0011\u0005A\u0010C\u0004\u0002\u000e\u0001!\t!a\u0004\t\u0013\u0005]\u0001\u00011A\u0005\u0002\u0005e\u0001\"CA\u0012\u0001\u0001\u0007I\u0011AA\u0013\u0011\u0019\tI\u0003\u0001C\u0005g!1\u00111\u0006\u0001\u0005\nMBq!!\f\u0001\t\u0003\ty\u0003C\u0004\u0002H\u0001!\t!!\u0013\t\u000f\u0005e\u0003\u0001\"\u0001\u0002\u001a\u001d9\u00111\u000e\u0012\t\u0002\u00055dAB\u0011#\u0011\u0003\ty\u0007C\u0004\u0002re!\t!a\u001d\t\u0013\u0005U\u0014D1A\u0005\u0002\u0005e\u0001\u0002CA<3\u0001\u0006I!a\u0007\t\u0013\u0005e\u0014D1A\u0005\u0002\u0005m\u0004\u0002CAE3\u0001\u0006I!! \t\u0011\u0005-\u0015D1A\u0005\u0002qDq!!$\u001aA\u0003%QPA\bUQJ,\u0017\r\u001a)p_2$\u0016m]6t\u0015\t\u0019C%\u0001\u0005qCJ\fG\u000e\\3m\u0015\t)c%\u0001\u0006d_2dWm\u0019;j_:T\u0011aJ\u0001\u0006g\u000e\fG.Y\u0002\u0001'\r\u0001!F\f\t\u0003W1j\u0011AJ\u0005\u0003[\u0019\u0012a!\u00118z%\u00164\u0007CA\u00181\u001b\u0005\u0011\u0013BA\u0019#\u0005\u0015!\u0016m]6t\u0003\u0019!\u0013N\\5uIQ\tA\u0007\u0005\u0002,k%\u0011aG\n\u0002\u0005+:LGOA\u0006Xe\u0006\u0004\b/\u001a3UCN\\WcA\u001dK)N!!A\u000f\"F!\tY\u0004)D\u0001=\u0015\tid(\u0001\u0003mC:<'\"A \u0002\t)\fg/Y\u0005\u0003\u0003r\u0012aa\u00142kK\u000e$\bCA\u001eD\u0013\t!EH\u0001\u0005Sk:t\u0017M\u00197f!\u00111u\tS*\u000e\u0003\u0001I!a\u000e\u0019\u0011\u0005%SE\u0002\u0001\u0003\u0006\u0017\n\u0011\r\u0001\u0014\u0002\u0002%F\u0011Q\n\u0015\t\u0003W9K!a\u0014\u0014\u0003\u000f9{G\u000f[5oOB\u00111&U\u0005\u0003%\u001a\u00121!\u00118z!\tIE\u000b\u0002\u0004V\u0005\u0011\u0015\r\u0001\u0014\u0002\u0003)B\fQa\\<oK\u0012,\u0012\u0001\u0017\t\u0003WeK!A\u0017\u0014\u0003\u000f\t{w\u000e\\3b]\"\u0012A\u0001\u0018\t\u0003WuK!A\u0018\u0014\u0003\u0011Y|G.\u0019;jY\u0016\f\u0011b\\<oK\u0012|F%Z9\u0015\u0005Q\n\u0007b\u00022\u0006\u0003\u0003\u0005\r\u0001W\u0001\u0004q\u0012\n\u0014!C2p[BdW\r^3eQ\t1A,A\u0007d_6\u0004H.\u001a;fI~#S-\u001d\u000b\u0003i\u001dDqAY\u0004\u0002\u0002\u0003\u0007\u0001,A\u0003ti\u0006\u0014H/\u0001\u0003ts:\u001c\u0017!\u0003;ss\u000e\u000bgnY3m)\u0005A\u0016a\u0001:v]\u00069!/\u001a7fCN,\u0017A\u00048fo^\u0013\u0018\r\u001d9fIR\u000b7o[\u000b\u0004aN,HCA9w!\u00111%A\u001d;\u0011\u0005%\u001bH!B&\u000e\u0005\u0004a\u0005CA%v\t\u0015)VB1\u0001M\u0011\u00159X\u00021\u0001y\u0003\u0005\u0011\u0007\u0003B\u0018zeRL!A\u001f\u0012\u0003\tQ\u000b7o[\u0001\fK:4\u0018N]8o[\u0016tG/F\u0001~!\rq\u0018qA\u0007\u0002\u007f*!\u0011\u0011AA\u0002\u0003)\u0019wN\\2veJ,g\u000e\u001e\u0006\u0004\u0003\u000bq\u0014\u0001B;uS2L1!!\u0003\u0000\u0005I!\u0006N]3bIB{w\u000e\\#yK\u000e,Ho\u001c:\u0002\u0011\u0015DXmY;u_J\fQ!];fk\u0016,\"!!\u0005\u0011\ty\f\u0019BQ\u0005\u0004\u0003+y(a\u0005'j].,GM\u00117pG.LgnZ)vKV,\u0017A\u0003;pi\u0006dG/Y:lgV\u0011\u00111\u0004\t\u0004W\u0005u\u0011bAA\u0010M\t\u0019\u0011J\u001c;)\u0005Ea\u0016A\u0004;pi\u0006dG/Y:lg~#S-\u001d\u000b\u0004i\u0005\u001d\u0002\u0002\u00032\u0013\u0003\u0003\u0005\r!a\u0007\u0002\u0013%t7M\u001d+bg.\u001c\u0018!\u00033fGJ$\u0016m]6t\u0003\u001d)\u00070Z2vi\u0016,b!!\r\u0002<\u0005\u0015C\u0003BA\u001a\u0003{\u0001RaKA\u001b\u0003sI1!a\u000e'\u0005%1UO\\2uS>t\u0007\u0007E\u0002J\u0003w!QaS\u000bC\u00021Cq!a\u0010\u0016\u0001\u0004\t\t%\u0001\u0003uCN\\\u0007CB\u0018z\u0003s\t\u0019\u0005E\u0002J\u0003\u000b\"Q!V\u000bC\u00021\u000bA#\u001a=fGV$X-\u00118e/\u0006LGOU3tk2$XCBA&\u0003\u001f\n9\u0006\u0006\u0003\u0002N\u0005E\u0003cA%\u0002P\u0011)1J\u0006b\u0001\u0019\"9\u0011q\b\fA\u0002\u0005M\u0003CB\u0018z\u0003\u001b\n)\u0006E\u0002J\u0003/\"Q!\u0016\fC\u00021\u000b\u0001\u0003]1sC2dW\r\\5t[2+g/\u001a7)\u000f\u0001\ti&a\u0019\u0002hA\u00191&a\u0018\n\u0007\u0005\u0005dE\u0001\u0006eKB\u0014XmY1uK\u0012\f#!!\u001a\u00027U\u001cX\r\t1G_J\\'j\\5o)\u0006\u001c8n\u001d1!S:\u001cH/Z1eC\t\tI'\u0001\u00043]E\nd\u0006M\u0001\u0010)\"\u0014X-\u00193Q_>dG+Y:lgB\u0011q&G\n\u00033)\na\u0001P5oSRtDCAA7\u0003!qW/\\\"pe\u0016\u001c\u0018!\u00038v[\u000e{'/Z:!\u0003\u0019!8m\\;oiV\u0011\u0011Q\u0010\t\u0005\u0003\u007f\n))\u0004\u0002\u0002\u0002*\u0019\u00111Q@\u0002\r\u0005$x.\\5d\u0013\u0011\t9)!!\u0003\u0015\u0005#x.\\5d\u0019>tw-A\u0004uG>,h\u000e\u001e\u0011\u0002#\u0011,g-Y;miRC'/Z1e!>|G.\u0001\neK\u001a\fW\u000f\u001c;UQJ,\u0017\r\u001a)p_2\u0004\u0003fB\r\u0002^\u0005\r\u0014q\r\u0015\b3\u0005u\u00131MA4Q\u001dA\u0012QLA2\u0003O\u0002")
public interface ThreadPoolTasks
extends Tasks {
    public static ThreadPoolExecutor defaultThreadPool() {
        return ThreadPoolTasks$.MODULE$.defaultThreadPool();
    }

    public static AtomicLong tcount() {
        return ThreadPoolTasks$.MODULE$.tcount();
    }

    public static int numCores() {
        return ThreadPoolTasks$.MODULE$.numCores();
    }

    public <R, Tp> WrappedTask<R, Tp> newWrappedTask(Task<R, Tp> var1);

    @Override
    public ThreadPoolExecutor environment();

    public static /* synthetic */ ThreadPoolExecutor executor$(ThreadPoolTasks $this) {
        return $this.executor();
    }

    default public ThreadPoolExecutor executor() {
        return this.environment();
    }

    public static /* synthetic */ LinkedBlockingQueue queue$(ThreadPoolTasks $this) {
        return $this.queue();
    }

    default public LinkedBlockingQueue<Runnable> queue() {
        return (LinkedBlockingQueue)this.executor().getQueue();
    }

    public int totaltasks();

    public void totaltasks_$eq(int var1);

    public static /* synthetic */ void scala$collection$parallel$ThreadPoolTasks$$incrTasks$(ThreadPoolTasks $this) {
        $this.scala$collection$parallel$ThreadPoolTasks$$incrTasks();
    }

    default public void scala$collection$parallel$ThreadPoolTasks$$incrTasks() {
        synchronized (this) {
            this.totaltasks_$eq(this.totaltasks() + 1);
            return;
        }
    }

    public static /* synthetic */ void scala$collection$parallel$ThreadPoolTasks$$decrTasks$(ThreadPoolTasks $this) {
        $this.scala$collection$parallel$ThreadPoolTasks$$decrTasks();
    }

    default public void scala$collection$parallel$ThreadPoolTasks$$decrTasks() {
        synchronized (this) {
            this.totaltasks_$eq(this.totaltasks() - 1);
            return;
        }
    }

    public static /* synthetic */ Function0 execute$(ThreadPoolTasks $this, Task task) {
        return $this.execute(task);
    }

    @Override
    default public <R, Tp> Function0<R> execute(Task<R, Tp> task) {
        WrappedTask t = this.newWrappedTask(task);
        t.start();
        return (Function0<Object> & java.io.Serializable & Serializable)() -> {
            t.sync();
            t.body().forwardThrowable();
            return t.body().result();
        };
    }

    public static /* synthetic */ Object executeAndWaitResult$(ThreadPoolTasks $this, Task task) {
        return $this.executeAndWaitResult(task);
    }

    @Override
    default public <R, Tp> R executeAndWaitResult(Task<R, Tp> task) {
        WrappedTask<R, Tp> t = this.newWrappedTask(task);
        t.start();
        t.sync();
        t.body().forwardThrowable();
        return t.body().result();
    }

    public static /* synthetic */ int parallelismLevel$(ThreadPoolTasks $this) {
        return $this.parallelismLevel();
    }

    @Override
    default public int parallelismLevel() {
        return ThreadPoolTasks$.MODULE$.numCores();
    }

    public static void $init$(ThreadPoolTasks $this) {
        $this.totaltasks_$eq(0);
    }

    public interface WrappedTask<R, Tp>
    extends Runnable,
    Tasks.WrappedTask<R, Tp> {
        public boolean owned();

        public void owned_$eq(boolean var1);

        public boolean completed();

        public void completed_$eq(boolean var1);

        public static /* synthetic */ void start$(WrappedTask $this) {
            $this.start();
        }

        @Override
        default public void start() {
            synchronized (this) {
                ThreadPoolExecutor threadPoolExecutor = this.scala$collection$parallel$ThreadPoolTasks$WrappedTask$$$outer().executor();
                synchronized (threadPoolExecutor) {
                    this.scala$collection$parallel$ThreadPoolTasks$WrappedTask$$$outer().scala$collection$parallel$ThreadPoolTasks$$incrTasks();
                    this.scala$collection$parallel$ThreadPoolTasks$WrappedTask$$$outer().executor().submit(this);
                }
                return;
            }
        }

        public static /* synthetic */ void sync$(WrappedTask $this) {
            $this.sync();
        }

        @Override
        default public void sync() {
            synchronized (this) {
                ThreadPoolExecutor threadPoolExecutor = this.scala$collection$parallel$ThreadPoolTasks$WrappedTask$$$outer().executor();
                synchronized (threadPoolExecutor) {
                    int coresize = this.scala$collection$parallel$ThreadPoolTasks$WrappedTask$$$outer().executor().getCorePoolSize();
                    if (coresize < this.scala$collection$parallel$ThreadPoolTasks$WrappedTask$$$outer().totaltasks()) {
                        this.scala$collection$parallel$ThreadPoolTasks$WrappedTask$$$outer().executor().setCorePoolSize(coresize + 1);
                    }
                }
                while (!this.completed()) {
                    this.wait();
                }
                return;
            }
        }

        public static /* synthetic */ boolean tryCancel$(WrappedTask $this) {
            return $this.tryCancel();
        }

        @Override
        default public boolean tryCancel() {
            synchronized (this) {
                boolean bl;
                if (!this.owned()) {
                    this.owned_$eq(true);
                    bl = true;
                } else {
                    bl = false;
                }
                boolean bl2 = bl;
                return bl2;
            }
        }

        public static /* synthetic */ void run$(WrappedTask $this) {
            $this.run();
        }

        @Override
        default public void run() {
            boolean isOkToRun = false;
            synchronized (this) {
                if (!this.owned()) {
                    this.owned_$eq(true);
                    isOkToRun = true;
                }
            }
            if (isOkToRun) {
                this.compute();
            }
        }

        public static /* synthetic */ void release$(WrappedTask $this) {
            $this.release();
        }

        @Override
        default public void release() {
            synchronized (this) {
                this.completed_$eq(true);
                ThreadPoolExecutor threadPoolExecutor = this.scala$collection$parallel$ThreadPoolTasks$WrappedTask$$$outer().executor();
                synchronized (threadPoolExecutor) {
                    this.scala$collection$parallel$ThreadPoolTasks$WrappedTask$$$outer().scala$collection$parallel$ThreadPoolTasks$$decrTasks();
                }
                this.notifyAll();
                return;
            }
        }

        public /* synthetic */ ThreadPoolTasks scala$collection$parallel$ThreadPoolTasks$WrappedTask$$$outer();

        public static void $init$(WrappedTask $this) {
            $this.owned_$eq(false);
            $this.completed_$eq(false);
        }
    }
}

