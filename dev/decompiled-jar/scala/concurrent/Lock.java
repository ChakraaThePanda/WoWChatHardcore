/*
 * Decompiled with CFR 0.152.
 */
package scala.concurrent;

import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u000192Aa\u0002\u0005\u0001\u001b!)!\u0003\u0001C\u0001'!9a\u0003\u0001a\u0001\n\u00039\u0002bB\u000e\u0001\u0001\u0004%\t\u0001\b\u0005\u0007E\u0001\u0001\u000b\u0015\u0002\r\t\u000b\r\u0002A\u0011\u0001\u0013\t\u000b\u0015\u0002A\u0011\u0001\u0013\u0003\t1{7m\u001b\u0006\u0003\u0013)\t!bY8oGV\u0014(/\u001a8u\u0015\u0005Y\u0011!B:dC2\f7\u0001A\n\u0003\u00019\u0001\"a\u0004\t\u000e\u0003)I!!\u0005\u0006\u0003\r\u0005s\u0017PU3g\u0003\u0019a\u0014N\\5u}Q\tA\u0003\u0005\u0002\u0016\u00015\t\u0001\"A\u0005bm\u0006LG.\u00192mKV\t\u0001\u0004\u0005\u0002\u00103%\u0011!D\u0003\u0002\b\u0005>|G.Z1o\u00035\tg/Y5mC\ndWm\u0018\u0013fcR\u0011Q\u0004\t\t\u0003\u001fyI!a\b\u0006\u0003\tUs\u0017\u000e\u001e\u0005\bC\r\t\t\u00111\u0001\u0019\u0003\rAH%M\u0001\u000bCZ\f\u0017\u000e\\1cY\u0016\u0004\u0013aB1dcVL'/\u001a\u000b\u0002;\u00059!/\u001a7fCN,\u0007\u0006\u0002\u0001(U1\u0002\"a\u0004\u0015\n\u0005%R!A\u00033faJ,7-\u0019;fI\u0006\n1&A\u0012vg\u0016\u0004#.\u0019<b]U$\u0018\u000e\u001c\u0018d_:\u001cWO\u001d:f]RtCn\\2lg:bunY6\"\u00035\naA\r\u00182c9\u0012\u0004")
public class Lock {
    private boolean available = true;

    public boolean available() {
        return this.available;
    }

    public void available_$eq(boolean x$1) {
        this.available = x$1;
    }

    public synchronized void acquire() {
        while (!this.available()) {
            this.wait();
        }
        this.available_$eq(false);
    }

    public synchronized void release() {
        this.available_$eq(true);
        this.notify();
    }
}

