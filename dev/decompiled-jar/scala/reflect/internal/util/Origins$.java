/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import scala.Function0;
import scala.Function1;
import scala.Predef$;
import scala.Serializable;
import scala.collection.immutable.Nil$;
import scala.collection.mutable.ArrayOps;
import scala.collection.mutable.HashMap;
import scala.collection.mutable.HashMap$;
import scala.reflect.internal.util.Origins;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.java8.JFunction0$mcV$sp;
import scala.sys.ShutdownHookThread;
import scala.sys.ShutdownHookThread$;
import scala.sys.package$;

public final class Origins$ {
    public static Origins$ MODULE$;
    private final HashMap<String, Origins> counters;
    private final String thisClass;

    static {
        new Origins$();
    }

    private HashMap<String, Origins> counters() {
        return this.counters;
    }

    private String thisClass() {
        return this.thisClass;
    }

    public Origins lookup(String tag, Function1<String, Origins> orElse) {
        return this.counters().getOrElseUpdate(tag, (Function0<Origins> & java.io.Serializable & Serializable)() -> (Origins)orElse.apply(tag));
    }

    public Origins register(Origins x) {
        this.counters().update(x.tag(), x);
        return x;
    }

    private boolean preCutoff(StackTraceElement el) {
        String string = el.getClassName();
        String string2 = this.thisClass();
        return !(string == null ? string2 != null : !string.equals(string2)) || el.getClassName().startsWith("java.lang.");
    }

    private Origins.OriginId findCutoff() {
        Function1<StackTraceElement, Object> & java.io.Serializable & Serializable dropWhile_p = (Function1<StackTraceElement, Object> & java.io.Serializable & Serializable)el -> BoxesRunTime.boxToBoolean(Origins$.MODULE$.preCutoff(el));
        ArrayOps.ofRef<Object> dropWhile_this = new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])Thread.currentThread().getStackTrace()));
        StackTraceElement cutoff = (StackTraceElement)new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])dropWhile_this.drop(dropWhile_this.prefixLength(dropWhile_p)))).head();
        return new Origins.OriginId(cutoff.getClassName(), cutoff.getMethodName());
    }

    public Origins apply(String tag) {
        return this.counters().getOrElseUpdate(tag, (Function0<Origins>)(Function0<Origins.OneLine> & java.io.Serializable & Serializable)() -> new Origins.OneLine(tag, MODULE$.findCutoff()));
    }

    public Origins apply(String tag, int frames) {
        return this.counters().getOrElseUpdate(tag, (Function0<Origins>)(Function0<Origins.MultiLine> & java.io.Serializable & Serializable)() -> new Origins.MultiLine(tag, MODULE$.findCutoff(), frames));
    }

    /*
     * WARNING - void declaration
     */
    private Origins$() {
        void addShutdownHook_body;
        MODULE$ = this;
        this.counters = (HashMap)HashMap$.MODULE$.apply(Nil$.MODULE$);
        this.thisClass = this.getClass().getName();
        JFunction0$mcV$sp & Serializable intersect = (JFunction0$mcV$sp & Serializable)() -> MODULE$.counters().values().foreach((Function1<Origins, Object> & java.io.Serializable & Serializable)x$4 -> {
            x$4.purge();
            return BoxedUnit.UNIT;
        });
        if (package$.MODULE$ == null) {
            throw null;
        }
        if (ShutdownHookThread$.MODULE$ == null) {
            throw null;
        }
        ShutdownHookThread addShutdownHook_apply_t = new ShutdownHookThread((Function0)addShutdownHook_body){
            private final Function0 body$1;

            public void run() {
                this.body$1.apply$mcV$sp();
            }
            {
                this.body$1 = body$1;
                super(ShutdownHookThread$.MODULE$.scala$sys$ShutdownHookThread$$hookName());
            }
        };
        package$.MODULE$.runtime().addShutdownHook(addShutdownHook_apply_t);
        if (Predef$.MODULE$ == null) {
            throw null;
        }
    }
}

