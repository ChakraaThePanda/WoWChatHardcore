/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel;

import java.util.concurrent.RecursiveAction;
import scala.Function1;
import scala.Serializable;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.parallel.AdaptiveWorkStealingTasks;
import scala.collection.parallel.ForkJoinTasks;
import scala.collection.parallel.Task;
import scala.collection.parallel.Tasks;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001}3q\u0001C\u0005\u0011\u0002\u0007\u0005\u0001\u0003C\u0003\u001d\u0001\u0011\u0005QD\u0002\u0003\"\u0001\u0001\u0011\u0003\u0002C!\u0003\u0005\u000b\u0007I\u0011\u0001\"\t\u0011\u0019\u0013!\u0011!Q\u0001\n\rCQa\u0012\u0002\u0005\u0002!CQa\u0013\u0002\u0005\u00021CQ\u0001\u0016\u0001\u0005\u0002U\u0013\u0011%\u00113baRLg/Z,pe.\u001cF/Z1mS:<gi\u001c:l\u0015>Lg\u000eV1tWNT!AC\u0006\u0002\u0011A\f'/\u00197mK2T!\u0001D\u0007\u0002\u0015\r|G\u000e\\3di&|gNC\u0001\u000f\u0003\u0015\u00198-\u00197b\u0007\u0001\u0019B\u0001A\t\u00163A\u0011!cE\u0007\u0002\u001b%\u0011A#\u0004\u0002\u0007\u0003:L(+\u001a4\u0011\u0005Y9R\"A\u0005\n\u0005aI!!\u0004$pe.Tu.\u001b8UCN\\7\u000f\u0005\u0002\u00175%\u00111$\u0003\u0002\u001a\u0003\u0012\f\u0007\u000f^5wK^{'o[*uK\u0006d\u0017N\\4UCN\\7/\u0001\u0004%S:LG\u000f\n\u000b\u0002=A\u0011!cH\u0005\u0003A5\u0011A!\u00168ji\nYqK]1qa\u0016$G+Y:l+\r\u00193'P\n\u0005\u0005\u0011rs\b\u0005\u0002&Y5\taE\u0003\u0002(Q\u0005Q1m\u001c8dkJ\u0014XM\u001c;\u000b\u0005%R\u0013\u0001B;uS2T\u0011aK\u0001\u0005U\u00064\u0018-\u0003\u0002.M\ty!+Z2veNLg/Z!di&|g\u000e\u0005\u00030aEbT\"\u0001\u0001\n\u0005\u0005:\u0002C\u0001\u001a4\u0019\u0001!Q\u0001\u000e\u0002C\u0002U\u0012\u0011AU\t\u0003me\u0002\"AE\u001c\n\u0005aj!a\u0002(pi\"Lgn\u001a\t\u0003%iJ!aO\u0007\u0003\u0007\u0005s\u0017\u0010\u0005\u00023{\u0011)aH\u0001b\u0001k\t\u0011A\u000b\u001d\t\u0005_\u0001\u000bD(\u0003\u0002\"5\u0005!!m\u001c3z+\u0005\u0019\u0005\u0003\u0002\fEcqJ!!R\u0005\u0003\tQ\u000b7o[\u0001\u0006E>$\u0017\u0010I\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0005%S\u0005\u0003B\u0018\u0003cqBQ!Q\u0003A\u0002\r\u000bQa\u001d9mSR,\u0012!\u0014\t\u0004\u001dF{dB\u0001\nP\u0013\t\u0001V\"A\u0004qC\u000e\\\u0017mZ3\n\u0005I\u001b&aA*fc*\u0011\u0001+D\u0001\u000f]\u0016<xK]1qa\u0016$G+Y:l+\r1\u0016l\u0017\u000b\u0003/r\u0003Ba\f\u0002Y5B\u0011!'\u0017\u0003\u0006i\u001d\u0011\r!\u000e\t\u0003em#QAP\u0004C\u0002UBQ!X\u0004A\u0002y\u000b\u0011A\u0019\t\u0005-\u0011C&\f")
public interface AdaptiveWorkStealingForkJoinTasks
extends ForkJoinTasks,
AdaptiveWorkStealingTasks {
    public static /* synthetic */ WrappedTask newWrappedTask$(AdaptiveWorkStealingForkJoinTasks $this, Task b) {
        return $this.newWrappedTask(b);
    }

    default public <R, Tp> WrappedTask<R, Tp> newWrappedTask(Task<R, Tp> b) {
        return new WrappedTask<R, Tp>(this, b);
    }

    public static void $init$(AdaptiveWorkStealingForkJoinTasks $this) {
    }

    public class WrappedTask<R, Tp>
    extends RecursiveAction
    implements ForkJoinTasks.WrappedTask<R, Tp>,
    AdaptiveWorkStealingTasks.WrappedTask<R, Tp> {
        private final Task<R, Tp> body;
        private volatile AdaptiveWorkStealingTasks.WrappedTask<R, Tp> next;
        private volatile boolean shouldWaitFor;
        public final /* synthetic */ AdaptiveWorkStealingForkJoinTasks $outer;

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
            ForkJoinTasks.WrappedTask.start$(this);
        }

        @Override
        public void sync() {
            ForkJoinTasks.WrappedTask.sync$(this);
        }

        @Override
        public boolean tryCancel() {
            return ForkJoinTasks.WrappedTask.tryCancel$(this);
        }

        @Override
        public void release() {
            Tasks.WrappedTask.release$(this);
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
        public Task<R, Tp> body() {
            return this.body;
        }

        @Override
        public Seq<AdaptiveWorkStealingTasks.WrappedTask<R, Tp>> split() {
            return this.body().split().map((Function1<Task, WrappedTask> & java.io.Serializable & Serializable)b -> this.scala$collection$parallel$AdaptiveWorkStealingForkJoinTasks$WrappedTask$$$outer().newWrappedTask(b), Seq$.MODULE$.canBuildFrom());
        }

        public /* synthetic */ AdaptiveWorkStealingForkJoinTasks scala$collection$parallel$AdaptiveWorkStealingForkJoinTasks$WrappedTask$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ AdaptiveWorkStealingTasks scala$collection$parallel$AdaptiveWorkStealingTasks$WrappedTask$$$outer() {
            return this.scala$collection$parallel$AdaptiveWorkStealingForkJoinTasks$WrappedTask$$$outer();
        }

        @Override
        public /* synthetic */ ForkJoinTasks scala$collection$parallel$ForkJoinTasks$WrappedTask$$$outer() {
            return this.scala$collection$parallel$AdaptiveWorkStealingForkJoinTasks$WrappedTask$$$outer();
        }

        @Override
        public /* synthetic */ Tasks scala$collection$parallel$Tasks$WrappedTask$$$outer() {
            return this.scala$collection$parallel$AdaptiveWorkStealingForkJoinTasks$WrappedTask$$$outer();
        }

        public WrappedTask(AdaptiveWorkStealingForkJoinTasks $outer, Task<R, Tp> body) {
            this.body = body;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Tasks.WrappedTask.$init$(this);
            ForkJoinTasks.WrappedTask.$init$(this);
            AdaptiveWorkStealingTasks.WrappedTask.$init$(this);
        }
    }
}

