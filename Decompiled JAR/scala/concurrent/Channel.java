/*
 * Decompiled with CFR 0.152.
 */
package scala.concurrent;

import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\r4A!\u0006\f\u00017!)\u0011\u0005\u0001C\u0001E\u0019!\u0001\u0007\u0001\u00012\u0011\u0015\t#\u0001\"\u00014\u0011%A$\u00011AA\u0002\u0013\u0005\u0011\bC\u0005;\u0005\u0001\u0007\t\u0019!C\u0001w!I\u0011I\u0001a\u0001\u0002\u0003\u0006KA\u000e\u0005\b\u0005\n\u0001\r\u0011\"\u0001D\u0011\u001d!%\u00011A\u0005\u0002\u0015Caa\u0012\u0002!B\u0013!\u0004b\u0002%\u0001\u0001\u0004%I!\u0013\u0005\b\u0017\u0002\u0001\r\u0011\"\u0003M\u0011\u0019q\u0005\u0001)Q\u0005\u0015\"9q\n\u0001a\u0001\n\u0013I\u0005b\u0002)\u0001\u0001\u0004%I!\u0015\u0005\u0007'\u0002\u0001\u000b\u0015\u0002&\t\u000fQ\u0003\u0001\u0019!C\u0005+\"9\u0011\f\u0001a\u0001\n\u0013Q\u0006B\u0002/\u0001A\u0003&a\u000bC\u0003^\u0001\u0011\u0005a\fC\u0003b\u0001\u0011\u0005!MA\u0004DQ\u0006tg.\u001a7\u000b\u0005]A\u0012AC2p]\u000e,(O]3oi*\t\u0011$A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u0005q93C\u0001\u0001\u001e!\tqr$D\u0001\u0019\u0013\t\u0001\u0003D\u0001\u0004B]f\u0014VMZ\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003\r\u00022\u0001\n\u0001&\u001b\u00051\u0002C\u0001\u0014(\u0019\u0001!Q\u0001\u000b\u0001C\u0002%\u0012\u0011!Q\t\u0003U5\u0002\"AH\u0016\n\u00051B\"a\u0002(pi\"Lgn\u001a\t\u0003=9J!a\f\r\u0003\u0007\u0005s\u0017P\u0001\u0006MS:\\W\r\u001a'jgR,\"AM\u001c\u0014\u0005\tiB#\u0001\u001b\u0011\u0007U\u0012a'D\u0001\u0001!\t1s\u0007B\u0003)\u0005\t\u0007\u0011&\u0001\u0003fY\u0016lW#\u0001\u001c\u0002\u0011\u0015dW-\\0%KF$\"\u0001P \u0011\u0005yi\u0014B\u0001 \u0019\u0005\u0011)f.\u001b;\t\u000f\u0001+\u0011\u0011!a\u0001m\u0005\u0019\u0001\u0010J\u0019\u0002\u000b\u0015dW-\u001c\u0011\u0002\t9,\u0007\u0010^\u000b\u0002i\u0005Aa.\u001a=u?\u0012*\u0017\u000f\u0006\u0002=\r\"9\u0001\tCA\u0001\u0002\u0004!\u0014!\u00028fqR\u0004\u0013aB<sSR$XM\\\u000b\u0002\u0015B\u0019QGA\u0013\u0002\u0017]\u0014\u0018\u000e\u001e;f]~#S-\u001d\u000b\u0003y5Cq\u0001Q\u0006\u0002\u0002\u0003\u0007!*\u0001\u0005xe&$H/\u001a8!\u0003-a\u0017m\u001d;Xe&$H/\u001a8\u0002\u001f1\f7\u000f^,sSR$XM\\0%KF$\"\u0001\u0010*\t\u000f\u0001s\u0011\u0011!a\u0001\u0015\u0006aA.Y:u/JLG\u000f^3oA\u0005AaN]3bI\u0016\u00148/F\u0001W!\tqr+\u0003\u0002Y1\t\u0019\u0011J\u001c;\u0002\u00199\u0014X-\u00193feN|F%Z9\u0015\u0005qZ\u0006b\u0002!\u0012\u0003\u0003\u0005\rAV\u0001\n]J,\u0017\rZ3sg\u0002\nQa\u001e:ji\u0016$\"\u0001P0\t\u000b\u0001\u001c\u0002\u0019A\u0013\u0002\u0003a\fAA]3bIV\tQ\u0005")
public class Channel<A> {
    private LinkedList<A> written = new LinkedList();
    private LinkedList<A> lastWritten = this.written();
    private int nreaders = 0;

    private LinkedList<A> written() {
        return this.written;
    }

    private void written_$eq(LinkedList<A> x$1) {
        this.written = x$1;
    }

    private LinkedList<A> lastWritten() {
        return this.lastWritten;
    }

    private void lastWritten_$eq(LinkedList<A> x$1) {
        this.lastWritten = x$1;
    }

    private int nreaders() {
        return this.nreaders;
    }

    private void nreaders_$eq(int x$1) {
        this.nreaders = x$1;
    }

    public synchronized void write(A x) {
        this.lastWritten().elem_$eq(x);
        this.lastWritten().next_$eq(new LinkedList());
        this.lastWritten_$eq(this.lastWritten().next());
        if (this.nreaders() > 0) {
            this.notify();
        }
    }

    /*
     * WARNING - void declaration
     */
    public synchronized A read() {
        void var2_2;
        while (this.written().next() == null) {
            try {
                this.nreaders_$eq(this.nreaders() + 1);
                this.wait();
            }
            finally {
                this.nreaders_$eq(this.nreaders() - 1);
            }
        }
        A x = this.written().elem();
        this.written_$eq(this.written().next());
        return var2_2;
    }

    public class LinkedList<A> {
        private A elem;
        private LinkedList<A> next;

        public A elem() {
            return this.elem;
        }

        public void elem_$eq(A x$1) {
            this.elem = x$1;
        }

        public LinkedList<A> next() {
            return this.next;
        }

        public void next_$eq(LinkedList<A> x$1) {
            this.next = x$1;
        }

        public /* synthetic */ Channel scala$concurrent$Channel$LinkedList$$$outer() {
            return Channel.this;
        }

        public LinkedList() {
            if (Channel.this == null) {
                throw null;
            }
            this.next = null;
        }
    }
}

