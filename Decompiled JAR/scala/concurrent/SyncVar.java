/*
 * Decompiled with CFR 0.152.
 */
package scala.concurrent;

import java.util.concurrent.TimeUnit;
import scala.None$;
import scala.Option;
import scala.Some;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001-4Aa\u0005\u000b\u00013!)q\u0004\u0001C\u0001A!9a\u0006\u0001a\u0001\n\u0013y\u0003bB\u001a\u0001\u0001\u0004%I\u0001\u000e\u0005\u0007u\u0001\u0001\u000b\u0015\u0002\u0019\t\u0013m\u0002\u0001\u0019!a\u0001\n\u0013a\u0004\"C\u001f\u0001\u0001\u0004\u0005\r\u0011\"\u0003?\u0011%\u0001\u0005\u00011A\u0001B\u0003&1\u0005C\u0003B\u0001\u0011\u0005A\bC\u0003C\u0001\u0011%1\tC\u0003B\u0001\u0011\u0005\u0011\nC\u0003O\u0001\u0011\u0005q\nC\u0003O\u0001\u0011\u0005\u0001\u000bC\u0003S\u0001\u0011\u00051\u000bC\u0003_\u0001\u0011\u0005q\fC\u0003b\u0001\u0011\u0005q\u0006C\u0003c\u0001\u0011\u00051\rC\u0003h\u0001\u0011%\u0001\u000eC\u0003k\u0001\u0011%1MA\u0004Ts:\u001cg+\u0019:\u000b\u0005U1\u0012AC2p]\u000e,(O]3oi*\tq#A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u0005i)3C\u0001\u0001\u001c!\taR$D\u0001\u0017\u0013\tqbC\u0001\u0004B]f\u0014VMZ\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003\u0005\u00022A\t\u0001$\u001b\u0005!\u0002C\u0001\u0013&\u0019\u0001!QA\n\u0001C\u0002\u001d\u0012\u0011!Q\t\u0003Q-\u0002\"\u0001H\u0015\n\u0005)2\"a\u0002(pi\"Lgn\u001a\t\u000391J!!\f\f\u0003\u0007\u0005s\u00170A\u0005jg\u0012+g-\u001b8fIV\t\u0001\u0007\u0005\u0002\u001dc%\u0011!G\u0006\u0002\b\u0005>|G.Z1o\u00035I7\u000fR3gS:,Gm\u0018\u0013fcR\u0011Q\u0007\u000f\t\u00039YJ!a\u000e\f\u0003\tUs\u0017\u000e\u001e\u0005\bs\r\t\t\u00111\u00011\u0003\rAH%M\u0001\u000bSN$UMZ5oK\u0012\u0004\u0013!\u0002<bYV,W#A\u0012\u0002\u0013Y\fG.^3`I\u0015\fHCA\u001b@\u0011\u001dId!!AA\u0002\r\naA^1mk\u0016\u0004\u0013aA4fi\u0006!r/Y5u\u001b\u0016\f7/\u001e:j]\u001e,E.\u00199tK\u0012$\"\u0001R$\u0011\u0005q)\u0015B\u0001$\u0017\u0005\u0011auN\\4\t\u000b!K\u0001\u0019\u0001#\u0002\u000fQLW.Z8viR\u0011!*\u0014\t\u00049-\u001b\u0013B\u0001'\u0017\u0005\u0019y\u0005\u000f^5p]\")\u0001J\u0003a\u0001\t\u0006!A/Y6f)\u0005\u0019CCA\u0012R\u0011\u0015AE\u00021\u0001E\u0003\r\u0019X\r\u001e\u000b\u0003kQCQ!V\u0007A\u0002\r\n\u0011\u0001\u001f\u0015\u0005\u001b]SF\f\u0005\u0002\u001d1&\u0011\u0011L\u0006\u0002\u000bI\u0016\u0004(/Z2bi\u0016$\u0017%A.\u0002!V\u001cX\r\t1qkR\u0004\u0007\u0005^8!K:\u001cXO]3!C\u00022\u0018\r\\;fA\r\fgN\\8uA\t,\u0007e\u001c<fe^\u0014\u0018\u000e\u001e;f]\u0002:\u0018\u000e\u001e5pkR\u0004\u0013\rI2peJ,7\u000f]8oI&tw\r\t1uC.,\u0007-I\u0001^\u0003\u0019\u0011d&\r\u0019/a\u0005\u0019\u0001/\u001e;\u0015\u0005U\u0002\u0007\"B+\u000f\u0001\u0004\u0019\u0013!B5t'\u0016$\u0018!B;og\u0016$H#A\u001b)\tA9V\rX\u0011\u0002M\u0006ySo]3!AR\f7.\u001a1!i>\u0004SM\\:ve\u0016\u0004\u0013\r\t<bYV,\u0007%[:!]\u00164XM\u001d\u0011eSN\u001c\u0017M\u001d3fI\u000611/\u001a;WC2$\"!N5\t\u000bU\u000b\u0002\u0019A\u0012\u0002\u0011Ut7/\u001a;WC2\u0004")
public class SyncVar<A> {
    private boolean isDefined = false;
    private A value;

    private boolean isDefined() {
        return this.isDefined;
    }

    private void isDefined_$eq(boolean x$1) {
        this.isDefined = x$1;
    }

    private A value() {
        return this.value;
    }

    private void value_$eq(A x$1) {
        this.value = x$1;
    }

    public synchronized A get() {
        while (!this.isDefined()) {
            this.wait();
        }
        return this.value();
    }

    private long waitMeasuringElapsed(long timeout2) {
        if (timeout2 <= 0L) {
            return 0L;
        }
        long start = System.nanoTime();
        this.wait(timeout2);
        long elapsed = System.nanoTime() - start;
        if (elapsed < 0L) {
            return 0L;
        }
        return TimeUnit.NANOSECONDS.toMillis(elapsed);
    }

    public synchronized Option<A> get(long timeout2) {
        long elapsed;
        for (long rest = timeout2; !this.isDefined() && rest > 0L; rest -= elapsed) {
            elapsed = this.waitMeasuringElapsed(rest);
        }
        if (this.isDefined()) {
            return new Some<A>(this.value());
        }
        return None$.MODULE$;
    }

    public synchronized A take() {
        A a;
        try {
            a = this.get();
        }
        finally {
            this.unsetVal();
        }
        return a;
    }

    public synchronized A take(long timeout2) {
        A a;
        try {
            a = this.get(timeout2).get();
        }
        finally {
            this.unsetVal();
        }
        return a;
    }

    public void set(A x) {
        this.setVal(x);
    }

    public synchronized void put(A x) {
        while (this.isDefined()) {
            this.wait();
        }
        this.setVal(x);
    }

    public synchronized boolean isSet() {
        return this.isDefined();
    }

    public synchronized void unset() {
        this.isDefined_$eq(false);
        this.value_$eq(null);
        this.notifyAll();
    }

    private synchronized void setVal(A x) {
        this.isDefined_$eq(true);
        this.value_$eq(x);
        this.notifyAll();
    }

    private synchronized void unsetVal() {
        this.isDefined_$eq(false);
        this.value_$eq(null);
        this.notifyAll();
    }
}

