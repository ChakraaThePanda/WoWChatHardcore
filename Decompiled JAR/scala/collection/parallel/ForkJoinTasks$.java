/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel;

import java.util.concurrent.ForkJoinPool;

public final class ForkJoinTasks$ {
    public static ForkJoinTasks$ MODULE$;
    private ForkJoinPool defaultForkJoinPool;
    private volatile boolean bitmap$0;

    static {
        new ForkJoinTasks$();
    }

    private ForkJoinPool defaultForkJoinPool$lzycompute() {
        synchronized (this) {
            if (!this.bitmap$0) {
                this.defaultForkJoinPool = new ForkJoinPool();
                this.bitmap$0 = true;
            }
        }
        return this.defaultForkJoinPool;
    }

    public ForkJoinPool defaultForkJoinPool() {
        if (!this.bitmap$0) {
            return this.defaultForkJoinPool$lzycompute();
        }
        return this.defaultForkJoinPool;
    }

    private ForkJoinTasks$() {
        MODULE$ = this;
    }
}

