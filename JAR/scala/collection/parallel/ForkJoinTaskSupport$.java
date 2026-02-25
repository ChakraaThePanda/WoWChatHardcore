/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel;

import java.util.concurrent.ForkJoinPool;
import scala.collection.parallel.ForkJoinTasks$;

public final class ForkJoinTaskSupport$ {
    public static ForkJoinTaskSupport$ MODULE$;

    static {
        new ForkJoinTaskSupport$();
    }

    public ForkJoinPool $lessinit$greater$default$1() {
        return ForkJoinTasks$.MODULE$.defaultForkJoinPool();
    }

    private ForkJoinTaskSupport$() {
        MODULE$ = this;
    }
}

