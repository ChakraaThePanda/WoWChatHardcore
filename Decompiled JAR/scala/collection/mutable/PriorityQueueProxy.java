/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Proxy;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.TraversableOnce;
import scala.collection.mutable.PriorityQueue;
import scala.collection.mutable.Queue;
import scala.math.Ordering;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001y4Q\u0001E\t\u0002\"aA\u0011\"\f\u0001\u0003\u0002\u0003\u0006YAL\u001b\t\u000bY\u0002A\u0011A\u001c\t\u000bm\u0002a\u0011\u0001\u001f\t\u000bu\u0002A\u0011\t \t\u000b\r\u0003A\u0011\t#\t\u000b!\u0003A\u0011I%\t\u000b5\u0003A\u0011\t(\t\u000bI\u0003A\u0011I*\t\u000be\u0003A\u0011\t.\t\u000b\r\u0004A\u0011\t3\t\u000b\u0015\u0004A\u0011\t4\t\u000b\u001d\u0004A\u0011\t5\t\u000b%\u0004A\u0011\t6\t\u000b9\u0004A\u0011I8\t\u0017A\u0004\u0001\u0013aA\u0001\u0002\u0013%\u0011/\u000e\u0002\u0013!JLwN]5usF+X-^3Qe>D\u0018P\u0003\u0002\u0013'\u00059Q.\u001e;bE2,'B\u0001\u000b\u0016\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002-\u0005)1oY1mC\u000e\u0001QCA\r!'\r\u0001!D\u000b\t\u00047qqR\"A\t\n\u0005u\t\"!\u0004)sS>\u0014\u0018\u000e^=Rk\u0016,X\r\u0005\u0002 A1\u0001A!B\u0011\u0001\u0005\u0004\u0011#!A!\u0012\u0005\r:\u0003C\u0001\u0013&\u001b\u0005)\u0012B\u0001\u0014\u0016\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"\u0001\n\u0015\n\u0005%*\"aA!osB\u0011AeK\u0005\u0003YU\u0011Q\u0001\u0015:pqf\f1a\u001c:e!\ry#G\b\b\u0003IAJ!!M\u000b\u0002\u000fA\f7m[1hK&\u00111\u0007\u000e\u0002\t\u001fJ$WM]5oO*\u0011\u0011'F\u0005\u0003[q\ta\u0001P5oSRtD#\u0001\u001d\u0015\u0005eR\u0004cA\u000e\u0001=!)QF\u0001a\u0002]\u0005!1/\u001a7g+\u0005Q\u0012\u0001C5uKJ\fGo\u001c:\u0016\u0003}\u00022\u0001Q!\u001f\u001b\u0005\u0019\u0012B\u0001\"\u0014\u0005!IE/\u001a:bi>\u0014\u0018A\u00027f]\u001e$\b.F\u0001F!\t!c)\u0003\u0002H+\t\u0019\u0011J\u001c;\u0002\u000f%\u001cX)\u001c9usV\t!\n\u0005\u0002%\u0017&\u0011A*\u0006\u0002\b\u0005>|G.Z1o\u0003!!\u0003\u000f\\;tI\u0015\fHCA(Q\u001b\u0005\u0001\u0001\"B)\b\u0001\u0004q\u0012\u0001B3mK6\fQ\u0002\n9mkN$\u0003\u000f\\;tI\u0015\fHCA(U\u0011\u0015)\u0006\u00021\u0001W\u0003\tIG\u000fE\u0002A/zI!\u0001W\n\u0003\u001fQ\u0013\u0018M^3sg\u0006\u0014G.Z(oG\u0016\fq!\u001a8rk\u0016,X\r\u0006\u0002\\=B\u0011A\u0005X\u0005\u0003;V\u0011A!\u00168ji\")q,\u0003a\u0001A\u0006)Q\r\\3ngB\u0019A%\u0019\u0010\n\u0005\t,\"A\u0003\u001fsKB,\u0017\r^3e}\u00059A-Z9vKV,G#\u0001\u0010\u0002\t!,\u0017\rZ\u000b\u0002=\u0005)1\r\\3beR\t1,A\u0004u_F+X-^3\u0016\u0003-\u00042a\u00077\u001f\u0013\ti\u0017CA\u0003Rk\u0016,X-A\u0003dY>tW\rF\u0001\u001b\u0003%\u0019X\u000f]3sI=\u0014H-F\u0001/S\t\u00011O\u0002\u0003u\u0001\u0001)(!\u0004\u001fm_\u000e\fG\u000eI2iS2$gh\u0005\u0002ts!\"\u0001a\u001e>}!\t!\u00030\u0003\u0002z+\tQA-\u001a9sK\u000e\fG/\u001a3\"\u0003m\fA\t\u001d:pqfLgn\u001a\u0011jg\u0002\"W\r\u001d:fG\u0006$X\r\u001a\u0011ek\u0016\u0004Co\u001c\u0011mC\u000e\\\u0007e\u001c4!kN,\u0007%\u00198eA\r|W\u000e]5mKJlC.\u001a<fY\u0002\u001aX\u000f\u001d9peR\f\u0013!`\u0001\u0007e9\n\u0014G\f\u0019")
public abstract class PriorityQueueProxy<A>
extends PriorityQueue<A>
implements Proxy {
    @Override
    public int hashCode() {
        return Proxy.hashCode$(this);
    }

    @Override
    public boolean equals(Object that) {
        return Proxy.equals$(this, that);
    }

    @Override
    public String toString() {
        return Proxy.toString$(this);
    }

    public /* synthetic */ Ordering scala$collection$mutable$PriorityQueueProxy$$super$ord() {
        return super.ord();
    }

    @Override
    public abstract PriorityQueue<A> self();

    @Override
    public Iterator<A> iterator() {
        return this.self().iterator();
    }

    @Override
    public int length() {
        return this.self().length();
    }

    @Override
    public boolean isEmpty() {
        return this.self().isEmpty();
    }

    @Override
    public PriorityQueueProxy<A> $plus$eq(A elem) {
        this.self().$plus$eq((Object)elem);
        return this;
    }

    @Override
    public PriorityQueueProxy<A> $plus$plus$eq(TraversableOnce<A> it) {
        this.self().$plus$plus$eq((TraversableOnce)it);
        return this;
    }

    @Override
    public void enqueue(Seq<A> elems) {
        this.self().$plus$plus$eq((TraversableOnce)elems);
    }

    @Override
    public A dequeue() {
        return this.self().dequeue();
    }

    @Override
    public A head() {
        return this.self().head();
    }

    @Override
    public void clear() {
        this.self().clear();
    }

    @Override
    public Queue<A> toQueue() {
        return this.self().toQueue();
    }

    @Override
    public PriorityQueue<A> clone() {
        return new PriorityQueueProxy<A>(this){
            private final /* synthetic */ PriorityQueueProxy $outer;

            public PriorityQueue<A> self() {
                return this.$outer.self().clone();
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                super($outer.scala$collection$mutable$PriorityQueueProxy$$super$ord());
            }
        };
    }

    public PriorityQueueProxy(Ordering<A> ord) {
        super(ord);
        Proxy.$init$(this);
    }
}

