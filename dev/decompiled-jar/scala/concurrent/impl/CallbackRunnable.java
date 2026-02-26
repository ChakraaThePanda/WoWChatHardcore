/*
 * Decompiled with CFR 0.152.
 */
package scala.concurrent.impl;

import scala.Function1;
import scala.Option;
import scala.Predef$;
import scala.concurrent.ExecutionContext;
import scala.concurrent.OnCompleteRunnable;
import scala.reflect.ScalaSignature;
import scala.util.Try;
import scala.util.control.NonFatal$;

@ScalaSignature(bytes="\u0006\u0001a3Aa\u0003\u0007\u0007'!AA\u0005\u0001BC\u0002\u0013\u0005Q\u0005\u0003\u0005*\u0001\t\u0005\t\u0015!\u0003'\u0011!Q\u0003A!b\u0001\n\u0003Y\u0003\u0002C!\u0001\u0005\u0003\u0005\u000b\u0011\u0002\u0017\t\u000b\t\u0003A\u0011A\"\t\u000f!\u0003\u0001\u0019!C\u0001\u0013\"9!\n\u0001a\u0001\n\u0003Y\u0005BB)\u0001A\u0003&\u0001\u0007C\u0003S\u0001\u0011\u00053\u000bC\u0003U\u0001\u0011\u0005QK\u0001\tDC2d'-Y2l%Vtg.\u00192mK*\u0011QBD\u0001\u0005S6\u0004HN\u0003\u0002\u0010!\u0005Q1m\u001c8dkJ\u0014XM\u001c;\u000b\u0003E\tQa]2bY\u0006\u001c\u0001!\u0006\u0002\u0015qM!\u0001!F\u000f!!\t12$D\u0001\u0018\u0015\tA\u0012$\u0001\u0003mC:<'\"\u0001\u000e\u0002\t)\fg/Y\u0005\u00039]\u0011aa\u00142kK\u000e$\bC\u0001\f\u001f\u0013\tyrC\u0001\u0005Sk:t\u0017M\u00197f!\t\t#%D\u0001\u000f\u0013\t\u0019cB\u0001\nP]\u000e{W\u000e\u001d7fi\u0016\u0014VO\u001c8bE2,\u0017\u0001C3yK\u000e,Ho\u001c:\u0016\u0003\u0019\u0002\"!I\u0014\n\u0005!r!\u0001E#yK\u000e,H/[8o\u0007>tG/\u001a=u\u0003%)\u00070Z2vi>\u0014\b%\u0001\u0006p]\u000e{W\u000e\u001d7fi\u0016,\u0012\u0001\f\t\u0005[9\u0002d(D\u0001\u0011\u0013\ty\u0003CA\u0005Gk:\u001cG/[8ocA\u0019\u0011\u0007\u000e\u001c\u000e\u0003IR!a\r\t\u0002\tU$\u0018\u000e\\\u0005\u0003kI\u00121\u0001\u0016:z!\t9\u0004\b\u0004\u0001\u0005\u000be\u0002!\u0019\u0001\u001e\u0003\u0003Q\u000b\"a\u000f \u0011\u00055b\u0014BA\u001f\u0011\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"!L \n\u0005\u0001\u0003\"aA!os\u0006YqN\\\"p[BdW\r^3!\u0003\u0019a\u0014N\\5u}Q\u0019AIR$\u0011\u0007\u0015\u0003a'D\u0001\r\u0011\u0015!S\u00011\u0001'\u0011\u0015QS\u00011\u0001-\u0003\u00151\u0018\r\\;f+\u0005\u0001\u0014!\u0003<bYV,w\fJ3r)\tau\n\u0005\u0002.\u001b&\u0011a\n\u0005\u0002\u0005+:LG\u000fC\u0004Q\u000f\u0005\u0005\t\u0019\u0001\u0019\u0002\u0007a$\u0013'\u0001\u0004wC2,X\rI\u0001\u0004eVtG#\u0001'\u0002!\u0015DXmY;uK^KG\u000f\u001b,bYV,GC\u0001'W\u0011\u00159&\u00021\u00011\u0003\u00051\b")
public final class CallbackRunnable<T>
implements Runnable,
OnCompleteRunnable {
    private final ExecutionContext executor;
    private final Function1<Try<T>, Object> onComplete;
    private Try<T> value;

    public ExecutionContext executor() {
        return this.executor;
    }

    public Function1<Try<T>, Object> onComplete() {
        return this.onComplete;
    }

    public Try<T> value() {
        return this.value;
    }

    public void value_$eq(Try<T> x$1) {
        this.value = x$1;
    }

    @Override
    public void run() {
        Predef$.MODULE$.require(this.value() != null);
        try {
            this.onComplete().apply(this.value());
            return;
        }
        catch (Throwable throwable) {
            Option<Throwable> option = NonFatal$.MODULE$.unapply(throwable);
            if (!option.isEmpty()) {
                Throwable e = option.get();
                this.executor().reportFailure(e);
                return;
            }
            throw throwable;
        }
    }

    public void executeWithValue(Try<T> v) {
        Predef$.MODULE$.require(this.value() == null);
        this.value_$eq(v);
        try {
            this.executor().execute(this);
            return;
        }
        catch (Throwable throwable) {
            Option<Throwable> option = NonFatal$.MODULE$.unapply(throwable);
            if (!option.isEmpty()) {
                Throwable t = option.get();
                this.executor().reportFailure(t);
                return;
            }
            throw throwable;
        }
    }

    public CallbackRunnable(ExecutionContext executor, Function1<Try<T>, Object> onComplete) {
        this.executor = executor;
        this.onComplete = onComplete;
        this.value = null;
    }
}

