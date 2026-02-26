/*
 * Decompiled with CFR 0.152.
 */
package io.netty.util.concurrent;

import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Promise;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

class PromiseTask<V>
extends DefaultPromise<V>
implements RunnableFuture<V> {
    private static final Runnable COMPLETED = new SentinelRunnable("COMPLETED");
    private static final Runnable CANCELLED = new SentinelRunnable("CANCELLED");
    private static final Runnable FAILED = new SentinelRunnable("FAILED");
    private Object task;

    PromiseTask(EventExecutor executor, Runnable runnable2, V result2) {
        super(executor);
        this.task = result2 == null ? runnable2 : new RunnableAdapter<V>(runnable2, result2);
    }

    PromiseTask(EventExecutor executor, Runnable runnable2) {
        super(executor);
        this.task = runnable2;
    }

    PromiseTask(EventExecutor executor, Callable<V> callable) {
        super(executor);
        this.task = callable;
    }

    public final int hashCode() {
        return System.identityHashCode(this);
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    V runTask() throws Throwable {
        Object task = this.task;
        if (task instanceof Callable) {
            return ((Callable)task).call();
        }
        ((Runnable)task).run();
        return null;
    }

    @Override
    public void run() {
        try {
            if (this.setUncancellableInternal()) {
                V result2 = this.runTask();
                this.setSuccessInternal(result2);
            }
        }
        catch (Throwable e) {
            this.setFailureInternal(e);
        }
    }

    private boolean clearTaskAfterCompletion(boolean done, Runnable result2) {
        if (done) {
            this.task = result2;
        }
        return done;
    }

    @Override
    public final Promise<V> setFailure(Throwable cause) {
        throw new IllegalStateException();
    }

    protected final Promise<V> setFailureInternal(Throwable cause) {
        super.setFailure(cause);
        this.clearTaskAfterCompletion(true, FAILED);
        return this;
    }

    @Override
    public final boolean tryFailure(Throwable cause) {
        return false;
    }

    protected final boolean tryFailureInternal(Throwable cause) {
        return this.clearTaskAfterCompletion(super.tryFailure(cause), FAILED);
    }

    @Override
    public final Promise<V> setSuccess(V result2) {
        throw new IllegalStateException();
    }

    protected final Promise<V> setSuccessInternal(V result2) {
        super.setSuccess(result2);
        this.clearTaskAfterCompletion(true, COMPLETED);
        return this;
    }

    @Override
    public final boolean trySuccess(V result2) {
        return false;
    }

    protected final boolean trySuccessInternal(V result2) {
        return this.clearTaskAfterCompletion(super.trySuccess(result2), COMPLETED);
    }

    @Override
    public final boolean setUncancellable() {
        throw new IllegalStateException();
    }

    protected final boolean setUncancellableInternal() {
        return super.setUncancellable();
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return this.clearTaskAfterCompletion(super.cancel(mayInterruptIfRunning), CANCELLED);
    }

    @Override
    protected StringBuilder toStringBuilder() {
        StringBuilder buf = super.toStringBuilder();
        buf.setCharAt(buf.length() - 1, ',');
        return buf.append(" task: ").append(this.task).append(')');
    }

    private static class SentinelRunnable
    implements Runnable {
        private final String name;

        SentinelRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
        }

        public String toString() {
            return this.name;
        }
    }

    private static final class RunnableAdapter<T>
    implements Callable<T> {
        final Runnable task;
        final T result;

        RunnableAdapter(Runnable task, T result2) {
            this.task = task;
            this.result = result2;
        }

        @Override
        public T call() {
            this.task.run();
            return this.result;
        }

        public String toString() {
            return "Callable(task: " + this.task + ", result: " + this.result + ')';
        }
    }
}

