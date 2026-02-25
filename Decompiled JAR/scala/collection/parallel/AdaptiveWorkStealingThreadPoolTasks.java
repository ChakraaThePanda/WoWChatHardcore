/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel;

import scala.Function1;
import scala.Serializable;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.parallel.AdaptiveWorkStealingTasks;
import scala.collection.parallel.Task;
import scala.collection.parallel.Tasks;
import scala.collection.parallel.ThreadPoolTasks;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u00154q\u0001C\u0005\u0011\u0002\u0007\u0005\u0001\u0003C\u0003\u001d\u0001\u0011\u0005QD\u0002\u0003\"\u0001\u0001\u0011\u0003\u0002C \u0003\u0005\u000b\u0007I\u0011\u0001!\t\u0011\u0011\u0013!\u0011!Q\u0001\n\u0005CQ!\u0012\u0002\u0005\u0002\u0019CQ!\u0013\u0002\u0005\u0002)CQA\u0015\u0001\u0005\u0002M\u00131%\u00113baRLg/Z,pe.\u001cF/Z1mS:<G\u000b\u001b:fC\u0012\u0004vn\u001c7UCN\\7O\u0003\u0002\u000b\u0017\u0005A\u0001/\u0019:bY2,GN\u0003\u0002\r\u001b\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u00039\tQa]2bY\u0006\u001c\u0001a\u0005\u0003\u0001#UI\u0002C\u0001\n\u0014\u001b\u0005i\u0011B\u0001\u000b\u000e\u0005\u0019\te.\u001f*fMB\u0011acF\u0007\u0002\u0013%\u0011\u0001$\u0003\u0002\u0010)\"\u0014X-\u00193Q_>dG+Y:lgB\u0011aCG\u0005\u00037%\u0011\u0011$\u00113baRLg/Z,pe.\u001cF/Z1mS:<G+Y:lg\u00061A%\u001b8ji\u0012\"\u0012A\b\t\u0003%}I!\u0001I\u0007\u0003\tUs\u0017\u000e\u001e\u0002\f/J\f\u0007\u000f]3e)\u0006\u001c8.F\u0002$cm\u001aBA\u0001\u0013-{A\u0011QEK\u0007\u0002M)\u0011q\u0005K\u0001\u0005Y\u0006twMC\u0001*\u0003\u0011Q\u0017M^1\n\u0005-2#AB(cU\u0016\u001cG\u000f\u0005\u0003.]=RT\"\u0001\u0001\n\u0005\u0005:\u0002C\u0001\u00192\u0019\u0001!QA\r\u0002C\u0002M\u0012\u0011AU\t\u0003i]\u0002\"AE\u001b\n\u0005Yj!a\u0002(pi\"Lgn\u001a\t\u0003%aJ!!O\u0007\u0003\u0007\u0005s\u0017\u0010\u0005\u00021w\u0011)AH\u0001b\u0001g\t\u0011A\u000b\u001d\t\u0005[yz#(\u0003\u0002\"5\u0005!!m\u001c3z+\u0005\t\u0005\u0003\u0002\fC_iJ!aQ\u0005\u0003\tQ\u000b7o[\u0001\u0006E>$\u0017\u0010I\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0005\u001dC\u0005\u0003B\u0017\u0003_iBQaP\u0003A\u0002\u0005\u000bQa\u001d9mSR,\u0012a\u0013\t\u0004\u0019>kdB\u0001\nN\u0013\tqU\"A\u0004qC\u000e\\\u0017mZ3\n\u0005A\u000b&aA*fc*\u0011a*D\u0001\u000f]\u0016<xK]1qa\u0016$G+Y:l+\r!v+\u0017\u000b\u0003+j\u0003B!\f\u0002W1B\u0011\u0001g\u0016\u0003\u0006e\u001d\u0011\ra\r\t\u0003ae#Q\u0001P\u0004C\u0002MBQaW\u0004A\u0002q\u000b\u0011A\u0019\t\u0005-\t3\u0006\f\u000b\u0003\u0001=\u0006\u001c\u0007C\u0001\n`\u0013\t\u0001WB\u0001\u0006eKB\u0014XmY1uK\u0012\f\u0013AY\u00010kN,\u0007\u0005Y!eCB$\u0018N^3X_J\\7\u000b^3bY&twMR8sW*{\u0017N\u001c+bg.\u001c\b\rI5ogR,\u0017\rZ\u0011\u0002I\u00061!GL\u00192]A\u0002")
public interface AdaptiveWorkStealingThreadPoolTasks
extends ThreadPoolTasks,
AdaptiveWorkStealingTasks {
    public static /* synthetic */ WrappedTask newWrappedTask$(AdaptiveWorkStealingThreadPoolTasks $this, Task b) {
        return $this.newWrappedTask(b);
    }

    default public <R, Tp> WrappedTask<R, Tp> newWrappedTask(Task<R, Tp> b) {
        return new WrappedTask<R, Tp>(this, b);
    }

    public static void $init$(AdaptiveWorkStealingThreadPoolTasks $this) {
    }

    public class WrappedTask<R, Tp>
    implements ThreadPoolTasks.WrappedTask<R, Tp>,
    AdaptiveWorkStealingTasks.WrappedTask<R, Tp> {
        private final Task<R, Tp> body;
        private volatile AdaptiveWorkStealingTasks.WrappedTask<R, Tp> next;
        private volatile boolean shouldWaitFor;
        private volatile boolean owned;
        private volatile boolean completed;
        public final /* synthetic */ AdaptiveWorkStealingThreadPoolTasks $outer;

        @Override
        public void compute() {
            AdaptiveWorkStealingTasks.WrappedTask.compute$(this);
        }

        @Override
        public void internal() {
            AdaptiveWorkStealingTasks.WrappedTask.internal$(this);
        }

        @Override
        public AdaptiveWorkStealingTasks.WrappedTask<R, Tp> spawnSubtasks() {
            return AdaptiveWorkStealingTasks.WrappedTask.spawnSubtasks$(this);
        }

        @Override
        public void printChain() {
            AdaptiveWorkStealingTasks.WrappedTask.printChain$(this);
        }

        @Override
        public void start() {
            ThreadPoolTasks.WrappedTask.start$(this);
        }

        @Override
        public void sync() {
            ThreadPoolTasks.WrappedTask.sync$(this);
        }

        @Override
        public boolean tryCancel() {
            return ThreadPoolTasks.WrappedTask.tryCancel$(this);
        }

        @Override
        public void run() {
            ThreadPoolTasks.WrappedTask.run$(this);
        }

        @Override
        public void release() {
            ThreadPoolTasks.WrappedTask.release$(this);
        }

        @Override
        public AdaptiveWorkStealingTasks.WrappedTask<R, Tp> next() {
            return this.next;
        }

        @Override
        public void next_$eq(AdaptiveWorkStealingTasks.WrappedTask<R, Tp> x$1) {
            this.next = x$1;
        }

        @Override
        public boolean shouldWaitFor() {
            return this.shouldWaitFor;
        }

        @Override
        public void shouldWaitFor_$eq(boolean x$1) {
            this.shouldWaitFor = x$1;
        }

        @Override
        public boolean owned() {
            return this.owned;
        }

        @Override
        public void owned_$eq(boolean x$1) {
            this.owned = x$1;
        }

        @Override
        public boolean completed() {
            return this.completed;
        }

        @Override
        public void completed_$eq(boolean x$1) {
            this.completed = x$1;
        }

        @Override
        public Task<R, Tp> body() {
            return this.body;
        }

        @Override
        public Seq<AdaptiveWorkStealingTasks.WrappedTask<R, Tp>> split() {
            return this.body().split().map((Function1<Task, WrappedTask> & java.io.Serializable & Serializable)b -> this.scala$collection$parallel$AdaptiveWorkStealingThreadPoolTasks$WrappedTask$$$outer().newWrappedTask(b), Seq$.MODULE$.canBuildFrom());
        }

        public /* synthetic */ AdaptiveWorkStealingThreadPoolTasks scala$collection$parallel$AdaptiveWorkStealingThreadPoolTasks$WrappedTask$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ AdaptiveWorkStealingTasks scala$collection$parallel$AdaptiveWorkStealingTasks$WrappedTask$$$outer() {
            return this.scala$collection$parallel$AdaptiveWorkStealingThreadPoolTasks$WrappedTask$$$outer();
        }

        @Override
        public /* synthetic */ ThreadPoolTasks scala$collection$parallel$ThreadPoolTasks$WrappedTask$$$outer() {
            return this.scala$collection$parallel$AdaptiveWorkStealingThreadPoolTasks$WrappedTask$$$outer();
        }

        @Override
        public /* synthetic */ Tasks scala$collection$parallel$Tasks$WrappedTask$$$outer() {
            return this.scala$collection$parallel$AdaptiveWorkStealingThreadPoolTasks$WrappedTask$$$outer();
        }

        public WrappedTask(AdaptiveWorkStealingThreadPoolTasks $outer, Task<R, Tp> body) {
            this.body = body;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Tasks.WrappedTask.$init$(this);
            ThreadPoolTasks.WrappedTask.$init$(this);
            AdaptiveWorkStealingTasks.WrappedTask.$init$(this);
        }
    }
}

