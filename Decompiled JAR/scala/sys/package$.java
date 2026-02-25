/*
 * Decompiled with CFR 0.152.
 */
package scala.sys;

import scala.Function0;
import scala.Predef$;
import scala.collection.IndexedSeq;
import scala.collection.JavaConverters$;
import scala.collection.immutable.Map;
import scala.collection.immutable.Map$;
import scala.collection.mutable.ArrayOps;
import scala.collection.mutable.MapLike;
import scala.runtime.BoxedUnit;
import scala.runtime.Nothing$;
import scala.sys.ShutdownHookThread;
import scala.sys.ShutdownHookThread$;
import scala.sys.SystemProperties;

public final class package$ {
    public static package$ MODULE$;

    static {
        new package$();
    }

    public Nothing$ error(String message) {
        throw new RuntimeException(message);
    }

    public Nothing$ exit() {
        return this.exit(0);
    }

    public Nothing$ exit(int status) {
        System.exit(status);
        throw new Throwable();
    }

    public Runtime runtime() {
        return Runtime.getRuntime();
    }

    public SystemProperties props() {
        return new SystemProperties();
    }

    public Map<String, String> env() {
        return (Map)Map$.MODULE$.apply(((MapLike)JavaConverters$.MODULE$.mapAsScalaMapConverter(System.getenv()).asScala()).toSeq());
    }

    /*
     * WARNING - void declaration
     */
    public ShutdownHookThread addShutdownHook(Function0<BoxedUnit> body) {
        void var2_2;
        if (ShutdownHookThread$.MODULE$ == null) {
            throw null;
        }
        ShutdownHookThread apply_t = new ShutdownHookThread(body){
            private final Function0 body$1;

            public void run() {
                this.body$1.apply$mcV$sp();
            }
            {
                this.body$1 = body$1;
                super(ShutdownHookThread$.MODULE$.scala$sys$ShutdownHookThread$$hookName());
            }
        };
        MODULE$.runtime().addShutdownHook(apply_t);
        return var2_2;
    }

    public IndexedSeq<Thread> allThreads() {
        Thread[] tarray = new Thread[Thread.activeCount()];
        int got = Thread.enumerate(tarray);
        return Predef$.MODULE$.wrapRefArray((Object[])new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])tarray)).take(got));
    }

    private package$() {
        MODULE$ = this;
    }
}

