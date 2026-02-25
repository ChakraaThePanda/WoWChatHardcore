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
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import scala.Function1;
import scala.Option;
import scala.Option$;
import scala.Predef$;
import scala.Serializable;
import scala.collection.immutable.StringOps;
import scala.concurrent.ExecutionContext$;
import scala.concurrent.ExecutionContextExecutorService;
import scala.concurrent.impl.ExecutionContextImpl;
import scala.math.package$;
import scala.runtime.BoxedUnit;
import scala.runtime.RichDouble$;

public final class ExecutionContextImpl$ {
    public static ExecutionContextImpl$ MODULE$;

    static {
        new ExecutionContextImpl$();
    }

    public ExecutorService createDefaultExecutorService(Function1<Throwable, BoxedUnit> reporter) {
        int numThreads = ExecutionContextImpl$.getInt$1("scala.concurrent.context.numThreads", "x1");
        int maxNoOfThreads = ExecutionContextImpl$.getInt$1("scala.concurrent.context.maxThreads", "x1");
        int desiredParallelism = ExecutionContextImpl$.range$1(ExecutionContextImpl$.getInt$1("scala.concurrent.context.minThreads", "1"), numThreads, maxNoOfThreads);
        int maxExtraThreads = ExecutionContextImpl$.getInt$1("scala.concurrent.context.maxExtraThreads", "256");
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = new Thread.UncaughtExceptionHandler(reporter){
            private final Function1 reporter$1;

            public void uncaughtException(Thread thread2, Throwable cause) {
                this.reporter$1.apply(cause);
            }
            {
                this.reporter$1 = reporter$1;
            }
        };
        ExecutionContextImpl.DefaultThreadFactory threadFactory = new ExecutionContextImpl.DefaultThreadFactory(true, maxExtraThreads, "scala-execution-context-global", uncaughtExceptionHandler);
        return new ForkJoinPool(desiredParallelism, threadFactory, uncaughtExceptionHandler, true);
    }

    public ExecutionContextImpl fromExecutor(Executor e, Function1<Throwable, BoxedUnit> reporter) {
        Option<Executor> option = Option$.MODULE$.apply(e);
        if (option == null) {
            throw null;
        }
        Option<Executor> getOrElse_this = option;
        return new ExecutionContextImpl(getOrElse_this.isEmpty() ? ExecutionContextImpl$.$anonfun$fromExecutor$1(reporter) : getOrElse_this.get(), reporter);
    }

    public Function1<Throwable, BoxedUnit> fromExecutor$default$2() {
        return ExecutionContext$.MODULE$.defaultReporter();
    }

    public ExecutionContextImpl fromExecutorService(ExecutorService es, Function1<Throwable, BoxedUnit> reporter) {
        return new ExecutionContextExecutorService(es, reporter){

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

    public Function1<Throwable, BoxedUnit> fromExecutorService$default$2() {
        return ExecutionContext$.MODULE$.defaultReporter();
    }

    private static final int getInt$1(String name, String string) {
        int n;
        String string2;
        String string3;
        try {
            string3 = System.getProperty(name, string);
        }
        catch (SecurityException securityException) {
            string3 = string2 = string;
        }
        if (string2.charAt(0) == 'x') {
            String string4 = string2.substring(1);
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            double d = (double)Runtime.getRuntime().availableProcessors() * new StringOps(string4).toDouble();
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            n = (int)RichDouble$.MODULE$.ceil$extension(d);
        } else {
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            n = new StringOps(string2).toInt();
        }
        return n;
    }

    private static final int range$1(int floor, int desired, int ceiling) {
        return package$.MODULE$.min(package$.MODULE$.max(floor, desired), ceiling);
    }

    public static final /* synthetic */ ExecutorService $anonfun$fromExecutor$1(Function1 reporter$2) {
        if (MODULE$ == null) {
            throw null;
        }
        int createDefaultExecutorService_numThreads = ExecutionContextImpl$.getInt$1("scala.concurrent.context.numThreads", "x1");
        int createDefaultExecutorService_maxNoOfThreads = ExecutionContextImpl$.getInt$1("scala.concurrent.context.maxThreads", "x1");
        int createDefaultExecutorService_desiredParallelism = ExecutionContextImpl$.range$1(ExecutionContextImpl$.getInt$1("scala.concurrent.context.minThreads", "1"), createDefaultExecutorService_numThreads, createDefaultExecutorService_maxNoOfThreads);
        int createDefaultExecutorService_maxExtraThreads = ExecutionContextImpl$.getInt$1("scala.concurrent.context.maxExtraThreads", "256");
        Thread.UncaughtExceptionHandler createDefaultExecutorService_uncaughtExceptionHandler = new /* invalid duplicate definition of identical inner class */;
        ExecutionContextImpl.DefaultThreadFactory createDefaultExecutorService_threadFactory = new ExecutionContextImpl.DefaultThreadFactory(true, createDefaultExecutorService_maxExtraThreads, "scala-execution-context-global", createDefaultExecutorService_uncaughtExceptionHandler);
        return new ForkJoinPool(createDefaultExecutorService_desiredParallelism, createDefaultExecutorService_threadFactory, createDefaultExecutorService_uncaughtExceptionHandler, true);
    }

    private ExecutionContextImpl$() {
        MODULE$ = this;
    }
}

