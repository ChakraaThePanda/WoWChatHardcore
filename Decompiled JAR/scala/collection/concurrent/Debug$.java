/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;
import scala.Console$;
import scala.Function1;
import scala.Serializable;
import scala.collection.JavaConverters$;
import scala.runtime.BoxedUnit;

public final class Debug$ {
    public static Debug$ MODULE$;
    private ConcurrentLinkedQueue<Object> logbuffer;
    private volatile boolean bitmap$0;

    static {
        new Debug$();
    }

    private ConcurrentLinkedQueue<Object> logbuffer$lzycompute() {
        synchronized (this) {
            if (!this.bitmap$0) {
                this.logbuffer = new ConcurrentLinkedQueue();
                this.bitmap$0 = true;
            }
        }
        return this.logbuffer;
    }

    public ConcurrentLinkedQueue<Object> logbuffer() {
        if (!this.bitmap$0) {
            return this.logbuffer$lzycompute();
        }
        return this.logbuffer;
    }

    public boolean log(Object s) {
        return this.logbuffer().add(s);
    }

    public void flush() {
        JavaConverters$.MODULE$.asScalaIteratorConverter(this.logbuffer().iterator()).asScala().foreach((Function1<Object, Object> & java.io.Serializable & Serializable)s -> {
            Debug$.$anonfun$flush$1(s);
            return BoxedUnit.UNIT;
        });
        this.logbuffer().clear();
    }

    public void clear() {
        this.logbuffer().clear();
    }

    public static final /* synthetic */ void $anonfun$flush$1(Object s) {
        Console$.MODULE$.out().println(s.toString());
    }

    private Debug$() {
        MODULE$ = this;
    }
}

