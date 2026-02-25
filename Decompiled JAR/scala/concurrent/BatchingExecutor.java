/*
 * Decompiled with CFR 0.152.
 */
package scala.concurrent;

import java.util.concurrent.Executor;
import scala.Function0;
import scala.MatchError;
import scala.Predef$;
import scala.Serializable;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.concurrent.BlockContext;
import scala.concurrent.BlockContext$;
import scala.concurrent.CanAwait;
import scala.concurrent.OnCompleteRunnable;
import scala.reflect.ScalaSignature;
import scala.runtime.java8.JFunction0$mcV$sp;

@ScalaSignature(bytes="\u0006\u0001q4\u0001b\u0004\t\u0011\u0002\u0007\u0005\u0001\u0003\u0006\u0005\u0006I\u0001!\tA\n\u0005\bW\u0001\u0011\r\u0011\"\u0003-\r\u0011y\u0004\u0001\u0002!\t\u0011\u0015\u001b!Q1A\u0005\u0002\u0019C\u0001bR\u0002\u0003\u0002\u0003\u0006I\u0001\r\u0005\u0006\u0011\u000e!\t!\u0013\u0005\n\u001b\u000e\u0001\r\u00111A\u0005\n9C\u0011bT\u0002A\u0002\u0003\u0007I\u0011\u0002)\t\u0013M\u001b\u0001\u0019!A!B\u0013\t\u0005\"\u0002+\u0004\t\u00032\u0003\"B+\u0004\t\u00032\u0006\"\u00028\u0001\r#y\u0007\"\u0002:\u0001\t\u0003\u001a\b\"\u0002<\u0001\t\u00039(\u0001\u0005\"bi\u000eD\u0017N\\4Fq\u0016\u001cW\u000f^8s\u0015\t\t\"#\u0001\u0006d_:\u001cWO\u001d:f]RT\u0011aE\u0001\u0006g\u000e\fG.Y\n\u0004\u0001Ui\u0002C\u0001\f\u001c\u001b\u00059\"B\u0001\r\u001a\u0003\u0011a\u0017M\\4\u000b\u0003i\tAA[1wC&\u0011Ad\u0006\u0002\u0007\u001f\nTWm\u0019;\u0011\u0005y\u0011S\"A\u0010\u000b\u0005E\u0001#BA\u0011\u001a\u0003\u0011)H/\u001b7\n\u0005\rz\"\u0001C#yK\u000e,Ho\u001c:\u0002\r\u0011Jg.\u001b;%\u0007\u0001!\u0012a\n\t\u0003Q%j\u0011AE\u0005\u0003UI\u0011A!\u00168ji\u0006Yq\f^1tWNdunY1m+\u0005i\u0003c\u0001\f/a%\u0011qf\u0006\u0002\f)\"\u0014X-\u00193M_\u000e\fG\u000eE\u00022sqr!AM\u001c\u000f\u0005M2T\"\u0001\u001b\u000b\u0005U*\u0013A\u0002\u001fs_>$h(C\u0001\u0014\u0013\tA$#A\u0004qC\u000e\\\u0017mZ3\n\u0005iZ$\u0001\u0002'jgRT!\u0001\u000f\n\u0011\u0005Yi\u0014B\u0001 \u0018\u0005!\u0011VO\u001c8bE2,'!\u0002\"bi\u000eD7\u0003B\u0002\u0016y\u0005\u0003\"AQ\"\u000e\u0003AI!\u0001\u0012\t\u0003\u0019\tcwnY6D_:$X\r\u001f;\u0002\u000f%t\u0017\u000e^5bYV\t\u0001'\u0001\u0005j]&$\u0018.\u00197!\u0003\u0019a\u0014N\\5u}Q\u0011!\n\u0014\t\u0003\u0017\u000ei\u0011\u0001\u0001\u0005\u0006\u000b\u001a\u0001\r\u0001M\u0001\u0013a\u0006\u0014XM\u001c;CY>\u001c7nQ8oi\u0016DH/F\u0001B\u0003Y\u0001\u0018M]3oi\ncwnY6D_:$X\r\u001f;`I\u0015\fHCA\u0014R\u0011\u001d\u0011\u0006\"!AA\u0002\u0005\u000b1\u0001\u001f\u00132\u0003M\u0001\u0018M]3oi\ncwnY6D_:$X\r\u001f;!\u0003\r\u0011XO\\\u0001\bE2|7m[(o+\t96\f\u0006\u0002YSR\u0011\u0011\f\u001a\t\u00035nc\u0001\u0001B\u0003]\u0017\t\u0007QLA\u0001U#\tq\u0016\r\u0005\u0002)?&\u0011\u0001M\u0005\u0002\b\u001d>$\b.\u001b8h!\tA#-\u0003\u0002d%\t\u0019\u0011I\\=\t\u000b\u0015\\\u00019\u00014\u0002\u0015A,'/\\5tg&|g\u000e\u0005\u0002CO&\u0011\u0001\u000e\u0005\u0002\t\u0007\u0006t\u0017i^1ji\"1!n\u0003CA\u0002-\fQ\u0001\u001e5v].\u00042\u0001\u000b7Z\u0013\ti'C\u0001\u0005=Eft\u0017-\\3?\u0003A)hNY1uG\",G-\u0012=fGV$X\r\u0006\u0002(a\")\u0011\u000f\u0004a\u0001y\u0005\t!/A\u0004fq\u0016\u001cW\u000f^3\u0015\u0005\u001d\"\b\"B;\u000e\u0001\u0004a\u0014\u0001\u0003:v]:\f'\r\\3\u0002\u0013\t\fGo\u00195bE2,GC\u0001=|!\tA\u00130\u0003\u0002{%\t9!i\\8mK\u0006t\u0007\"B;\u000f\u0001\u0004a\u0004")
public interface BatchingExecutor
extends Executor {
    public void scala$concurrent$BatchingExecutor$_setter_$scala$concurrent$BatchingExecutor$$_tasksLocal_$eq(ThreadLocal<List<Runnable>> var1);

    public ThreadLocal<List<Runnable>> scala$concurrent$BatchingExecutor$$_tasksLocal();

    public void unbatchedExecute(Runnable var1);

    public static /* synthetic */ void execute$(BatchingExecutor $this, Runnable runnable2) {
        $this.execute(runnable2);
    }

    @Override
    default public void execute(Runnable runnable2) {
        if (this.batchable(runnable2)) {
            List<Runnable> list = this.scala$concurrent$BatchingExecutor$$_tasksLocal().get();
            if (list == null) {
                this.unbatchedExecute(new Batch(this, Nil$.MODULE$.$colon$colon(runnable2)));
                return;
            }
            this.scala$concurrent$BatchingExecutor$$_tasksLocal().set(list.$colon$colon(runnable2));
            return;
        }
        this.unbatchedExecute(runnable2);
    }

    public static /* synthetic */ boolean batchable$(BatchingExecutor $this, Runnable runnable2) {
        return $this.batchable(runnable2);
    }

    default public boolean batchable(Runnable runnable2) {
        boolean bl = runnable2 instanceof OnCompleteRunnable;
        return bl;
    }

    public static void $init$(BatchingExecutor $this) {
        $this.scala$concurrent$BatchingExecutor$_setter_$scala$concurrent$BatchingExecutor$$_tasksLocal_$eq(new ThreadLocal<List<Runnable>>());
    }

    public class Batch
    implements Runnable,
    BlockContext {
        private final List<Runnable> initial;
        private BlockContext parentBlockContext;
        public final /* synthetic */ BatchingExecutor $outer;

        public List<Runnable> initial() {
            return this.initial;
        }

        private BlockContext parentBlockContext() {
            return this.parentBlockContext;
        }

        private void parentBlockContext_$eq(BlockContext x$1) {
            this.parentBlockContext = x$1;
        }

        @Override
        public void run() {
            Predef$.MODULE$.require(this.scala$concurrent$BatchingExecutor$Batch$$$outer().scala$concurrent$BatchingExecutor$$_tasksLocal().get() == null);
            BlockContext prevBlockContext = BlockContext$.MODULE$.current();
            BlockContext$.MODULE$.withBlockContext(this, (JFunction0$mcV$sp & Serializable)() -> {
                try {
                    this.parentBlockContext_$eq(prevBlockContext);
                    this.processBatch$1(this.initial());
                }
                finally {
                    this.scala$concurrent$BatchingExecutor$Batch$$$outer().scala$concurrent$BatchingExecutor$$_tasksLocal().remove();
                    this.parentBlockContext_$eq(null);
                }
            });
        }

        @Override
        public <T> T blockOn(Function0<T> thunk, CanAwait permission) {
            List<Runnable> tasks = this.scala$concurrent$BatchingExecutor$Batch$$$outer().scala$concurrent$BatchingExecutor$$_tasksLocal().get();
            this.scala$concurrent$BatchingExecutor$Batch$$$outer().scala$concurrent$BatchingExecutor$$_tasksLocal().set(Nil$.MODULE$);
            if (tasks != null && tasks.nonEmpty()) {
                this.scala$concurrent$BatchingExecutor$Batch$$$outer().unbatchedExecute(new Batch(this.scala$concurrent$BatchingExecutor$Batch$$$outer(), tasks));
            }
            Predef$.MODULE$.require(this.parentBlockContext() != null);
            return this.parentBlockContext().blockOn(thunk, permission);
        }

        public /* synthetic */ BatchingExecutor scala$concurrent$BatchingExecutor$Batch$$$outer() {
            return this.$outer;
        }

        private final void processBatch$1(List batch) {
            while (true) {
                if (((Object)Nil$.MODULE$).equals(batch)) {
                    return;
                }
                if (!(batch instanceof $colon$colon)) break;
                $colon$colon $colon$colon = ($colon$colon)batch;
                Runnable head = (Runnable)$colon$colon.head();
                List tail = $colon$colon.tl$access$1();
                this.scala$concurrent$BatchingExecutor$Batch$$$outer().scala$concurrent$BatchingExecutor$$_tasksLocal().set(tail);
                try {
                    head.run();
                }
                catch (Throwable t) {
                    List<Runnable> remaining = this.scala$concurrent$BatchingExecutor$Batch$$$outer().scala$concurrent$BatchingExecutor$$_tasksLocal().get();
                    this.scala$concurrent$BatchingExecutor$Batch$$$outer().scala$concurrent$BatchingExecutor$$_tasksLocal().set(Nil$.MODULE$);
                    this.scala$concurrent$BatchingExecutor$Batch$$$outer().unbatchedExecute(new Batch(this.scala$concurrent$BatchingExecutor$Batch$$$outer(), remaining));
                    throw t;
                }
                batch = this.scala$concurrent$BatchingExecutor$Batch$$$outer().scala$concurrent$BatchingExecutor$$_tasksLocal().get();
            }
            throw new MatchError(batch);
        }

        public Batch(BatchingExecutor $outer, List<Runnable> initial) {
            this.initial = initial;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }
}

