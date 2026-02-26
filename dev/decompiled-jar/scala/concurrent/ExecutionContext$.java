/*
 * Decompiled with CFR 0.152.
 */
package scala.concurrent;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import scala.Function1;
import scala.Option;
import scala.Option$;
import scala.Serializable;
import scala.concurrent.ExecutionContext$Implicits$;
import scala.concurrent.ExecutionContextExecutor;
import scala.concurrent.ExecutionContextExecutorService;
import scala.concurrent.impl.ExecutionContextImpl;
import scala.concurrent.impl.ExecutionContextImpl$;
import scala.runtime.BoxedUnit;

public final class ExecutionContext$ {
    public static ExecutionContext$ MODULE$;

    static {
        new ExecutionContext$();
    }

    public ExecutionContextExecutor global() {
        return (ExecutionContextExecutor)ExecutionContext$Implicits$.MODULE$.global();
    }

    public ExecutionContextExecutorService fromExecutorService(ExecutorService e, Function1<Throwable, BoxedUnit> reporter) {
        if (ExecutionContextImpl$.MODULE$ == null) {
            throw null;
        }
        return new ExecutionContextExecutorService(e, reporter){

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

    public ExecutionContextExecutorService fromExecutorService(ExecutorService e) {
        return this.fromExecutorService(e, this.defaultReporter());
    }

    public ExecutionContextExecutor fromExecutor(Executor e, Function1<Throwable, BoxedUnit> reporter) {
        if (ExecutionContextImpl$.MODULE$ == null) {
            throw null;
        }
        Option<Executor> option = Option$.MODULE$.apply(e);
        if (option == null) {
            throw null;
        }
        Option<Executor> fromExecutor_getOrElse_this = option;
        return new ExecutionContextImpl(fromExecutor_getOrElse_this.isEmpty() ? ExecutionContextImpl$.$anonfun$fromExecutor$1(reporter) : fromExecutor_getOrElse_this.get(), reporter);
    }

    public ExecutionContextExecutor fromExecutor(Executor e) {
        return this.fromExecutor(e, this.defaultReporter());
    }

    public Function1<Throwable, BoxedUnit> defaultReporter() {
        return (Function1<Throwable, Object> & java.io.Serializable & Serializable)x$1 -> {
            x$1.printStackTrace();
            return BoxedUnit.UNIT;
        };
    }

    private ExecutionContext$() {
        MODULE$ = this;
    }
}

