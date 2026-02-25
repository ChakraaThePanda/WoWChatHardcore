/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel;

import scala.Function1;
import scala.collection.GenTraversableOnce;
import scala.collection.parallel.ExecutionContextTaskSupport;
import scala.collection.parallel.ExecutionContextTaskSupport$;
import scala.collection.parallel.ParIterableLike;
import scala.collection.parallel.TaskSupport;
import scala.collection.parallel.package;

public final class package$ {
    public static package$ MODULE$;
    private final int MIN_FOR_COPY;
    private final int CHECK_RATE;
    private final double SQRT2;
    private final int availableProcessors;
    private final TaskSupport defaultTaskSupport;

    static {
        new package$();
    }

    public int MIN_FOR_COPY() {
        return this.MIN_FOR_COPY;
    }

    public int CHECK_RATE() {
        return this.CHECK_RATE;
    }

    public double SQRT2() {
        return this.SQRT2;
    }

    public int availableProcessors() {
        return this.availableProcessors;
    }

    public int thresholdFromSize(int sz, int parallelismLevel) {
        if (parallelismLevel > 1) {
            return 1 + sz / (8 * parallelismLevel);
        }
        return sz;
    }

    public TaskSupport defaultTaskSupport() {
        return this.defaultTaskSupport;
    }

    public <Coll> Coll setTaskSupport(Coll c, TaskSupport t) {
        if (c instanceof ParIterableLike) {
            ((ParIterableLike)c).tasksupport_$eq(t);
        }
        return c;
    }

    public <C, T> package.CollectionsHaveToParArray<C, T> CollectionsHaveToParArray(C c, Function1<C, GenTraversableOnce<T>> asGto) {
        return new package.CollectionsHaveToParArray<C, T>(c, asGto);
    }

    private package$() {
        MODULE$ = this;
        this.MIN_FOR_COPY = 512;
        this.CHECK_RATE = 512;
        this.SQRT2 = scala.math.package$.MODULE$.sqrt(2.0);
        this.availableProcessors = Runtime.getRuntime().availableProcessors();
        this.defaultTaskSupport = new ExecutionContextTaskSupport(ExecutionContextTaskSupport$.MODULE$.$lessinit$greater$default$1());
    }
}

