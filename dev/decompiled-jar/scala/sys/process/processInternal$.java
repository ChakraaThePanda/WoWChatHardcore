/*
 * Decompiled with CFR 0.152.
 */
package scala.sys.process;

import java.io.IOException;
import java.io.InterruptedIOException;
import scala.Console$;
import scala.Function0;
import scala.Function1;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.collection.Seq;
import scala.sys.package$;

public final class processInternal$ {
    public static processInternal$ MODULE$;
    private final boolean processDebug;

    static {
        new processInternal$();
    }

    public final boolean processDebug() {
        return this.processDebug;
    }

    public <T> PartialFunction<Throwable, T> onError(Function1<Throwable, T> handler) {
        return new Serializable(handler){
            public static final long serialVersionUID = 0L;
            private final Function1 handler$1;

            public final <A1 extends Throwable, B1> B1 applyOrElse(A1 x1, Function1<A1, B1> function1) {
                return (B1)this.handler$1.apply(x1);
            }

            public final boolean isDefinedAt(Throwable x1) {
                return true;
            }
            {
                this.handler$1 = handler$1;
            }
        };
    }

    public <T> PartialFunction<Throwable, T> onIOInterrupt(Function0<T> handler) {
        return new Serializable(handler){
            public static final long serialVersionUID = 0L;
            private final Function0 handler$2;

            public final <A1 extends Throwable, B1> B1 applyOrElse(A1 x1, Function1<A1, B1> function1) {
                Object object = x1 instanceof InterruptedIOException ? this.handler$2.apply() : function1.apply(x1);
                return (B1)object;
            }

            public final boolean isDefinedAt(Throwable x1) {
                boolean bl = x1 instanceof InterruptedIOException;
                return bl;
            }
            {
                this.handler$2 = handler$2;
            }
        };
    }

    public <T> PartialFunction<Throwable, T> onInterrupt(Function0<T> handler) {
        return new Serializable(handler){
            public static final long serialVersionUID = 0L;
            private final Function0 handler$3;

            public final <A1 extends Throwable, B1> B1 applyOrElse(A1 x1, Function1<A1, B1> function1) {
                Object object = x1 instanceof InterruptedException ? this.handler$3.apply() : function1.apply(x1);
                return (B1)object;
            }

            public final boolean isDefinedAt(Throwable x1) {
                boolean bl = x1 instanceof InterruptedException;
                return bl;
            }
            {
                this.handler$3 = handler$3;
            }
        };
    }

    public <T> PartialFunction<Throwable, T> ioFailure(Function1<IOException, T> handler) {
        return new Serializable(handler){
            public static final long serialVersionUID = 0L;
            private final Function1 handler$4;

            public final <A1 extends Throwable, B1> B1 applyOrElse(A1 x1, Function1<A1, B1> function1) {
                Object object;
                if (x1 instanceof IOException) {
                    IOException iOException = (IOException)x1;
                    object = this.handler$4.apply(iOException);
                } else {
                    object = function1.apply(x1);
                }
                return object;
            }

            public final boolean isDefinedAt(Throwable x1) {
                boolean bl = x1 instanceof IOException;
                return bl;
            }
            {
                this.handler$4 = handler$4;
            }
        };
    }

    public void dbg(Seq<Object> msgs) {
        if (this.processDebug()) {
            Console$.MODULE$.println(new StringBuilder(10).append("[process] ").append(msgs.mkString(" ")).toString());
        }
    }

    private processInternal$() {
        MODULE$ = this;
        this.processDebug = package$.MODULE$.props().contains("scala.process.debug");
        this.dbg(Predef$.MODULE$.genericWrapArray(new Object[]{"Initializing process package."}));
    }
}

