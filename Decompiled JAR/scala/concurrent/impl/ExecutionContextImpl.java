/*
 * Decompiled with CFR 0.152.
 */
package scala.concurrent.impl;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import scala.Function0;
import scala.Function1;
import scala.Option;
import scala.Option$;
import scala.Predef$;
import scala.Serializable;
import scala.concurrent.BlockContext;
import scala.concurrent.CanAwait;
import scala.concurrent.ExecutionContext;
import scala.concurrent.ExecutionContextExecutor;
import scala.concurrent.ExecutionContextExecutorService;
import scala.concurrent.impl.ExecutionContextImpl$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;

@ScalaSignature(bytes="\u0006\u0001\u0005=g!B\u000f\u001f\u0001\t\"\u0003\u0002C\u0017\u0001\u0005\u000b\u0007I\u0011A\u0018\t\u0011e\u0002!\u0011!Q\u0001\nAB\u0001B\u000f\u0001\u0003\u0006\u0004%\ta\u000f\u0005\t\u001d\u0002\u0011\t\u0011)A\u0005y!1q\n\u0001C\u0001=ACQ!\u0016\u0001\u0005BYCQa\u0018\u0001\u0005B\u0001<aa\u0019\u0010\t\u0002\u0001\"gAB\u000f\u001f\u0011\u0003\u0001S\rC\u0003P\u0013\u0011\u0005aM\u0002\u0003h\u0013\tA\u0007\u0002\u0003<\f\u0005\u0003\u0005\u000b\u0011B<\t\u0011i\\!\u0011!Q\u0001\nmD\u0001B`\u0006\u0003\u0002\u0003\u0006Ia \u0005\u000b\u0003\u001fY!\u0011!Q\u0001\n\u0005E\u0001BB(\f\t\u0003\ty\u0002C\u0005\u0002.-\u0011\r\u0011\"\u0004\u00020!A\u0011QH\u0006!\u0002\u001b\t\t\u0004C\u0004\u0002@-!i!!\u0011\t\u000f\u0005E3\u0002\"\u0004\u0002B!9\u0011QK\u0006\u0005\u0002\u0005]\u0003bBA;\u0017\u0011\u0005\u0011q\u000f\u0005\b\u0003kZA\u0011AA>\u0011\u001d\ti)\u0003C\u0001\u0003\u001fCq!!'\n\t\u0003\tY\nC\u0005\u0002$&\t\n\u0011\"\u0001\u0002&\"9\u0011qW\u0005\u0005\u0002\u0005e\u0006\"CAg\u0013E\u0005I\u0011AAS\u0005Q)\u00050Z2vi&|gnQ8oi\u0016DH/S7qY*\u0011q\u0004I\u0001\u0005S6\u0004HN\u0003\u0002\"E\u0005Q1m\u001c8dkJ\u0014XM\u001c;\u000b\u0003\r\nQa]2bY\u0006\u001c2\u0001A\u0013*!\t1s%D\u0001#\u0013\tA#E\u0001\u0004B]f\u0014VM\u001a\t\u0003U-j\u0011\u0001I\u0005\u0003Y\u0001\u0012\u0001$\u0012=fGV$\u0018n\u001c8D_:$X\r\u001f;Fq\u0016\u001cW\u000f^8s\u0003!)\u00070Z2vi>\u00148\u0001A\u000b\u0002aA\u0011\u0011gN\u0007\u0002e)\u0011\u0011e\r\u0006\u0003iU\nA!\u001e;jY*\ta'\u0001\u0003kCZ\f\u0017B\u0001\u001d3\u0005!)\u00050Z2vi>\u0014\u0018!C3yK\u000e,Ho\u001c:!\u0003!\u0011X\r]8si\u0016\u0014X#\u0001\u001f\u0011\t\u0019jthS\u0005\u0003}\t\u0012\u0011BR;oGRLwN\\\u0019\u0011\u0005\u0001CeBA!G\u001d\t\u0011U)D\u0001D\u0015\t!e&\u0001\u0004=e>|GOP\u0005\u0002G%\u0011qII\u0001\ba\u0006\u001c7.Y4f\u0013\tI%JA\u0005UQJ|w/\u00192mK*\u0011qI\t\t\u0003M1K!!\u0014\u0012\u0003\tUs\u0017\u000e^\u0001\ne\u0016\u0004xN\u001d;fe\u0002\na\u0001P5oSRtDcA)T)B\u0011!\u000bA\u0007\u0002=!)Q&\u0002a\u0001a!)!(\u0002a\u0001y\u00059Q\r_3dkR,GCA&X\u0011\u0015Af\u00011\u0001Z\u0003!\u0011XO\u001c8bE2,\u0007C\u0001.^\u001b\u0005Y&B\u0001/6\u0003\u0011a\u0017M\\4\n\u0005y[&\u0001\u0003*v]:\f'\r\\3\u0002\u001bI,\u0007o\u001c:u\r\u0006LG.\u001e:f)\tY\u0015\rC\u0003c\u000f\u0001\u0007q(A\u0001u\u0003Q)\u00050Z2vi&|gnQ8oi\u0016DH/S7qYB\u0011!+C\n\u0003\u0013\u0015\"\u0012\u0001\u001a\u0002\u0015\t\u00164\u0017-\u001e7u)\"\u0014X-\u00193GC\u000e$xN]=\u0014\t-IGn\u001c\t\u00035*L!a[.\u0003\r=\u0013'.Z2u!\t\tT.\u0003\u0002oe\tiA\u000b\u001b:fC\u00124\u0015m\u0019;pef\u0004\"\u0001]:\u000f\u0005E\n\u0018B\u0001:3\u000311uN]6K_&t\u0007k\\8m\u0013\t!XOA\u000eG_J\\'j\\5o/>\u00148.\u001a:UQJ,\u0017\r\u001a$bGR|'/\u001f\u0006\u0003eJ\n\u0001\u0002Z1f[>t\u0017n\u0019\t\u0003MaL!!\u001f\u0012\u0003\u000f\t{w\u000e\\3b]\u0006YQ.\u0019=CY>\u001c7.\u001a:t!\t1C0\u0003\u0002~E\t\u0019\u0011J\u001c;\u0002\rA\u0014XMZ5y!\u0011\t\t!!\u0003\u000f\t\u0005\r\u0011Q\u0001\t\u0003\u0005\nJ1!a\u0002#\u0003\u0019\u0001&/\u001a3fM&!\u00111BA\u0007\u0005\u0019\u0019FO]5oO*\u0019\u0011q\u0001\u0012\u0002\u0011Ut7-Y;hQR\u0004B!a\u0005\u0002\u001a9\u0019!,!\u0006\n\u0007\u0005]1,\u0001\u0004UQJ,\u0017\rZ\u0005\u0005\u00037\tiB\u0001\rV]\u000e\fWo\u001a5u\u000bb\u001cW\r\u001d;j_:D\u0015M\u001c3mKJT1!a\u0006\\))\t\t#!\n\u0002(\u0005%\u00121\u0006\t\u0004\u0003GYQ\"A\u0005\t\u000bY\u0004\u0002\u0019A<\t\u000bi\u0004\u0002\u0019A>\t\u000by\u0004\u0002\u0019A@\t\u000f\u0005=\u0001\u00031\u0001\u0002\u0012\u000592-\u001e:sK:$h*^7cKJ|eM\u00117pG.,'o]\u000b\u0003\u0003c\u0001B!a\r\u0002:5\u0011\u0011Q\u0007\u0006\u0004\u0003o\u0011\u0014AB1u_6L7-\u0003\u0003\u0002<\u0005U\"!D!u_6L7-\u00138uK\u001e,'/\u0001\rdkJ\u0014XM\u001c;Ok6\u0014WM](g\u00052|7m[3sg\u0002\n!B\\3x\u00052|7m[3s)\u00059\bfA\n\u0002FA!\u0011qIA'\u001b\t\tIEC\u0002\u0002L\t\n!\"\u00198o_R\fG/[8o\u0013\u0011\ty%!\u0013\u0003\u000fQ\f\u0017\u000e\u001c:fG\u0006YaM]3f\u00052|7m[3sQ\r!\u0012QI\u0001\u0005o&\u0014X-\u0006\u0003\u0002Z\u0005}C\u0003BA.\u0003c\u0002B!!\u0018\u0002`1\u0001AaBA1+\t\u0007\u00111\r\u0002\u0002)F!\u0011QMA6!\r1\u0013qM\u0005\u0004\u0003S\u0012#a\u0002(pi\"Lgn\u001a\t\u00045\u00065\u0014bAA87\n1A\u000b\u001b:fC\u0012Dq!a\u001d\u0016\u0001\u0004\tY&\u0001\u0004uQJ,\u0017\rZ\u0001\n]\u0016<H\u000b\u001b:fC\u0012$B!a\u001b\u0002z!)\u0001L\u0006a\u00013R!\u0011QPAB!\r\t\u0014qP\u0005\u0004\u0003\u0003\u0013$\u0001\u0006$pe.Tu.\u001b8X_J\\WM\u001d+ie\u0016\fG\rC\u0004\u0002\u0006^\u0001\r!a\"\u0002\u0007\u0019T\u0007\u000fE\u00022\u0003\u0013K1!a#3\u000511uN]6K_&t\u0007k\\8m\u0003q\u0019'/Z1uK\u0012+g-Y;mi\u0016CXmY;u_J\u001cVM\u001d<jG\u0016$B!!%\u0002\u0018B\u0019\u0011'a%\n\u0007\u0005U%GA\bFq\u0016\u001cW\u000f^8s'\u0016\u0014h/[2f\u0011\u0015Q\u0004\u00041\u0001=\u000311'o\\7Fq\u0016\u001cW\u000f^8s)\u0015\t\u0016QTAQ\u0011\u0019\ty*\u0007a\u0001a\u0005\tQ\rC\u0004;3A\u0005\t\u0019\u0001\u001f\u0002-\u0019\u0014x.\\#yK\u000e,Ho\u001c:%I\u00164\u0017-\u001e7uII*\"!a*+\u0007q\nIk\u000b\u0002\u0002,B!\u0011QVAZ\u001b\t\tyK\u0003\u0003\u00022\u0006%\u0013!C;oG\",7m[3e\u0013\u0011\t),a,\u0003#Ut7\r[3dW\u0016$g+\u0019:jC:\u001cW-A\nge>lW\t_3dkR|'oU3sm&\u001cW\r\u0006\u0004\u0002<\u0006\u001d\u00171\u001a\n\u0006\u0003{\u000b\u0016\u0011\u0019\u0004\u0007\u0003\u007fK\u0001!a/\u0003\u0019q\u0012XMZ5oK6,g\u000e\u001e \u0011\u0007)\n\u0019-C\u0002\u0002F\u0002\u0012q$\u0012=fGV$\u0018n\u001c8D_:$X\r\u001f;Fq\u0016\u001cW\u000f^8s'\u0016\u0014h/[2f\u0011\u001d\tIm\u0007a\u0001\u0003#\u000b!!Z:\t\u000fiZ\u0002\u0013!a\u0001y\u0005ibM]8n\u000bb,7-\u001e;peN+'O^5dK\u0012\"WMZ1vYR$#\u0007")
public class ExecutionContextImpl
implements ExecutionContextExecutor {
    private final Executor executor;
    private final Function1<Throwable, BoxedUnit> reporter;

    public static Function1<Throwable, BoxedUnit> fromExecutorService$default$2() {
        return ExecutionContextImpl$.MODULE$.fromExecutorService$default$2();
    }

    public static ExecutionContextImpl fromExecutorService(ExecutorService executorService, Function1<Throwable, BoxedUnit> function1) {
        if (ExecutionContextImpl$.MODULE$ == null) {
            throw null;
        }
        return new ExecutionContextExecutorService(executorService, function1){

            private final ExecutorService asExecutorService() {
                return (ExecutorService)this.executor();
            }

            public void execute(Runnable command) {
                this.executor().execute(command);
            }

            public void shutdown() {
                this.asExecutorService().shutdown();
            }

            public List<Runnable> shutdownNow() {
                return this.asExecutorService().shutdownNow();
            }

            public boolean isShutdown() {
                return this.asExecutorService().isShutdown();
            }

            public boolean isTerminated() {
                return this.asExecutorService().isTerminated();
            }

            public boolean awaitTermination(long l, TimeUnit timeUnit) {
                return this.asExecutorService().awaitTermination(l, timeUnit);
            }

            public <T> Future<T> submit(Callable<T> callable) {
                return this.asExecutorService().submit(callable);
            }

            public <T> Future<T> submit(Runnable runnable2, T t) {
                return this.asExecutorService().submit(runnable2, t);
            }

            public Future<?> submit(Runnable runnable2) {
                return this.asExecutorService().submit(runnable2);
            }

            public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> callables) {
                return this.asExecutorService().invokeAll(callables);
            }

            public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> callables, long l, TimeUnit timeUnit) {
                return this.asExecutorService().invokeAll(callables, l, timeUnit);
            }

            public <T> T invokeAny(Collection<? extends Callable<T>> callables) {
                return this.asExecutorService().invokeAny(callables);
            }

            public <T> T invokeAny(Collection<? extends Callable<T>> callables, long l, TimeUnit timeUnit) {
                return this.asExecutorService().invokeAny(callables, l, timeUnit);
            }
            {
                void getOrElse_default;
                Option<ExecutorService> option = Option$.MODULE$.apply(es$1);
                Serializable serializable = new Serializable(reporter$3){
                    public static final long serialVersionUID = 0L;
                    private final Function1 reporter$3;

                    public final ExecutorService apply() {
                        return ExecutionContextImpl$.MODULE$.createDefaultExecutorService(this.reporter$3);
                    }
                    {
                        this.reporter$3 = reporter$3;
                    }
                };
                if (option == null) {
                    throw null;
                }
                Option<ExecutorService> getOrElse_this = option;
                super((Executor)(getOrElse_this.isEmpty() ? getOrElse_default.apply() : getOrElse_this.get()), reporter$3);
            }
        };
    }

    public static Function1<Throwable, BoxedUnit> fromExecutor$default$2() {
        return ExecutionContextImpl$.MODULE$.fromExecutor$default$2();
    }

    public static ExecutionContextImpl fromExecutor(Executor executor, Function1<Throwable, BoxedUnit> function1) {
        if (ExecutionContextImpl$.MODULE$ == null) {
            throw null;
        }
        Option<Executor> option = Option$.MODULE$.apply(executor);
        if (option == null) {
            throw null;
        }
        Option<Executor> fromExecutor_getOrElse_this = option;
        return new ExecutionContextImpl(fromExecutor_getOrElse_this.isEmpty() ? ExecutionContextImpl$.$anonfun$fromExecutor$1(function1) : fromExecutor_getOrElse_this.get(), function1);
    }

    public static ExecutorService createDefaultExecutorService(Function1<Throwable, BoxedUnit> function1) {
        return ExecutionContextImpl$.MODULE$.createDefaultExecutorService(function1);
    }

    @Override
    public ExecutionContext prepare() {
        return ExecutionContext.prepare$(this);
    }

    public Executor executor() {
        return this.executor;
    }

    public Function1<Throwable, BoxedUnit> reporter() {
        return this.reporter;
    }

    @Override
    public void execute(Runnable runnable2) {
        this.executor().execute(runnable2);
    }

    @Override
    public void reportFailure(Throwable t) {
        this.reporter().apply(t);
    }

    public static final /* synthetic */ String $anonfun$new$1() {
        return "Executor must not be null";
    }

    /*
     * WARNING - void declaration
     */
    public ExecutionContextImpl(Executor executor, Function1<Throwable, BoxedUnit> reporter) {
        void require_requirement;
        boolean bl;
        this.executor = executor;
        this.reporter = reporter;
        ExecutionContext.$init$(this);
        boolean bl2 = bl = executor != null;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        if (require_requirement == false) {
            throw new IllegalArgumentException(new StringBuilder(20).append("requirement failed: ").append((Object)ExecutionContextImpl.$anonfun$new$1()).toString());
        }
    }

    public static final class DefaultThreadFactory
    implements ThreadFactory,
    ForkJoinPool.ForkJoinWorkerThreadFactory {
        private final boolean daemonic;
        private final int maxBlockers;
        private final String prefix;
        private final Thread.UncaughtExceptionHandler uncaught;
        private final AtomicInteger currentNumberOfBlockers;

        private final AtomicInteger currentNumberOfBlockers() {
            return this.currentNumberOfBlockers;
        }

        public final boolean scala$concurrent$impl$ExecutionContextImpl$DefaultThreadFactory$$newBlocker() {
            boolean bl;
            block1: {
                int n;
                do {
                    boolean bl2;
                    if (!(bl2 = this.maxBlockers == (n = this.currentNumberOfBlockers().get()) ? true : Integer.MAX_VALUE == n)) continue;
                    bl = false;
                    break block1;
                } while (!this.currentNumberOfBlockers().compareAndSet(n, n + 1));
                bl = true;
            }
            return bl;
        }

        public final boolean scala$concurrent$impl$ExecutionContextImpl$DefaultThreadFactory$$freeBlocker() {
            int n;
            do {
                n = this.currentNumberOfBlockers().get();
                switch (n) {
                    case 0: {
                        return false;
                    }
                }
            } while (!this.currentNumberOfBlockers().compareAndSet(n, n - 1));
            return true;
        }

        public <T extends Thread> T wire(T thread2) {
            thread2.setDaemon(this.daemonic);
            thread2.setUncaughtExceptionHandler(this.uncaught);
            thread2.setName(new StringBuilder(1).append(this.prefix).append("-").append(thread2.getId()).toString());
            return thread2;
        }

        @Override
        public Thread newThread(Runnable runnable2) {
            return this.wire(new Thread(runnable2));
        }

        @Override
        public ForkJoinWorkerThread newThread(ForkJoinPool fjp) {
            return this.wire(new BlockContext(this, fjp){
                private boolean isBlocked;
                private final /* synthetic */ DefaultThreadFactory $outer;

                public final <T> T blockOn(Function0<T> thunk, CanAwait permission) {
                    if (Thread.currentThread() == this && !this.isBlocked && this.$outer.scala$concurrent$impl$ExecutionContextImpl$DefaultThreadFactory$$newBlocker()) {
                        R r;
                        try {
                            this.isBlocked = true;
                            ForkJoinPool.ManagedBlocker b = new ForkJoinPool.ManagedBlocker(null, thunk){
                                private T result;
                                private boolean done;
                                private final Function0 thunk$1;

                                public boolean apply$mcZ$sp() {
                                    return Function0.apply$mcZ$sp$(this);
                                }

                                public byte apply$mcB$sp() {
                                    return Function0.apply$mcB$sp$(this);
                                }

                                public char apply$mcC$sp() {
                                    return Function0.apply$mcC$sp$(this);
                                }

                                public double apply$mcD$sp() {
                                    return Function0.apply$mcD$sp$(this);
                                }

                                public float apply$mcF$sp() {
                                    return Function0.apply$mcF$sp$(this);
                                }

                                public int apply$mcI$sp() {
                                    return Function0.apply$mcI$sp$(this);
                                }

                                public long apply$mcJ$sp() {
                                    return Function0.apply$mcJ$sp$(this);
                                }

                                public short apply$mcS$sp() {
                                    return Function0.apply$mcS$sp$(this);
                                }

                                public void apply$mcV$sp() {
                                    Function0.apply$mcV$sp$(this);
                                }

                                public String toString() {
                                    return Function0.toString$(this);
                                }

                                public final boolean block() {
                                    try {
                                        if (!this.done) {
                                            this.result = this.thunk$1.apply();
                                        }
                                    }
                                    finally {
                                        this.done = true;
                                    }
                                    return true;
                                }

                                public final boolean isReleasable() {
                                    return this.done;
                                }

                                public final T apply() {
                                    return this.result;
                                }
                                {
                                    this.thunk$1 = thunk$1;
                                    this.result = null;
                                    this.done = false;
                                }
                            };
                            ForkJoinPool.managedBlock(b);
                            r = b.apply();
                        }
                        finally {
                            this.isBlocked = false;
                            this.$outer.scala$concurrent$impl$ExecutionContextImpl$DefaultThreadFactory$$freeBlocker();
                        }
                        return (T)r;
                    }
                    return thunk.apply();
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                    super(fjp$1);
                    this.isBlocked = false;
                }
            });
        }

        public static final /* synthetic */ String $anonfun$new$2() {
            return "DefaultThreadFactory.prefix must be non null";
        }

        public static final /* synthetic */ String $anonfun$new$3() {
            return "DefaultThreadFactory.maxBlockers must be greater-or-equal-to 0";
        }

        /*
         * WARNING - void declaration
         */
        public DefaultThreadFactory(boolean daemonic, int maxBlockers, String prefix, Thread.UncaughtExceptionHandler uncaught) {
            void require_requirement;
            boolean bl;
            void require_requirement2;
            boolean bl2;
            this.daemonic = daemonic;
            this.maxBlockers = maxBlockers;
            this.prefix = prefix;
            this.uncaught = uncaught;
            boolean bl3 = bl2 = prefix != null;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            if (require_requirement2 == false) {
                throw new IllegalArgumentException(new StringBuilder(20).append("requirement failed: ").append((Object)DefaultThreadFactory.$anonfun$new$2()).toString());
            }
            boolean bl4 = bl = maxBlockers >= 0;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            if (require_requirement == false) {
                throw new IllegalArgumentException(new StringBuilder(20).append("requirement failed: ").append((Object)DefaultThreadFactory.$anonfun$new$3()).toString());
            }
            this.currentNumberOfBlockers = new AtomicInteger(0);
        }
    }
}

