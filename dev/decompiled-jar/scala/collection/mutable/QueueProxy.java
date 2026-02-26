/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Proxy;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.TraversableOnce;
import scala.collection.mutable.Queue;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001!4qAD\b\u0011\u0002\u0007\u0005a\u0003C\u0003,\u0001\u0011\u0005A\u0006C\u00031\u0001\u0019\u0005\u0011\u0007C\u00033\u0001\u0011\u00053\u0007C\u0003:\u0001\u0011\u0005#\bC\u0003<\u0001\u0011\u0005C\bC\u0003A\u0001\u0011\u0005\u0013\tC\u0003F\u0001\u0011\u0005c\tC\u0003N\u0001\u0011\u0005c\nC\u0003U\u0001\u0011\u0005S\u000bC\u0003W\u0001\u0011\u0005s\u000bC\u0003Y\u0001\u0011\u0005C\u0006C\u0003Z\u0001\u0011\u0005#\fC\u0003_\u0001\u0011\u0005sL\u0001\u0006Rk\u0016,X\r\u0015:pqfT!\u0001E\t\u0002\u000f5,H/\u00192mK*\u0011!cE\u0001\u000bG>dG.Z2uS>t'\"\u0001\u000b\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0011qCH\n\u0004\u0001aA\u0003cA\r\u001b95\tq\"\u0003\u0002\u001c\u001f\t)\u0011+^3vKB\u0011QD\b\u0007\u0001\t\u0015y\u0002A1\u0001!\u0005\u0005\t\u0015CA\u0011&!\t\u00113%D\u0001\u0014\u0013\t!3CA\u0004O_RD\u0017N\\4\u0011\u0005\t2\u0013BA\u0014\u0014\u0005\r\te.\u001f\t\u0003E%J!AK\n\u0003\u000bA\u0013x\u000e_=\u0002\r\u0011Jg.\u001b;%)\u0005i\u0003C\u0001\u0012/\u0013\ty3C\u0001\u0003V]&$\u0018\u0001B:fY\u001a,\u0012\u0001G\u0001\u0006CB\u0004H.\u001f\u000b\u00039QBQ!N\u0002A\u0002Y\n\u0011A\u001c\t\u0003E]J!\u0001O\n\u0003\u0007%sG/\u0001\u0004mK:<G\u000f[\u000b\u0002m\u00059\u0011n]#naRLX#A\u001f\u0011\u0005\tr\u0014BA \u0014\u0005\u001d\u0011un\u001c7fC:\f\u0001\u0002\n9mkN$S-\u001d\u000b\u0003\u0005\u000ek\u0011\u0001\u0001\u0005\u0006\t\u001a\u0001\r\u0001H\u0001\u0005K2,W.A\u0007%a2,8\u000f\n9mkN$S-\u001d\u000b\u0003\u0005\u001eCQ\u0001S\u0004A\u0002%\u000b!!\u001b;\u0011\u0007)[E$D\u0001\u0012\u0013\ta\u0015CA\bUe\u00064XM]:bE2,wJ\\2f\u0003\u001d)g.];fk\u0016$\"!L(\t\u000bAC\u0001\u0019A)\u0002\u000b\u0015dW-\\:\u0011\u0007\t\u0012F$\u0003\u0002T'\tQAH]3qK\u0006$X\r\u001a \u0002\u000f\u0011,\u0017/^3vKR\tA$A\u0003ge>tG/F\u0001\u001d\u0003\u0015\u0019G.Z1s\u0003!IG/\u001a:bi>\u0014X#A.\u0011\u0007)cF$\u0003\u0002^#\tA\u0011\n^3sCR|'/A\u0003dY>tW\rF\u0001\u0019Q\u0011\u0001\u0011\r\u001a4\u0011\u0005\t\u0012\u0017BA2\u0014\u0005)!W\r\u001d:fG\u0006$X\rZ\u0011\u0002K\u0006!\u0005O]8ys&tw\rI5tA\u0011,\u0007O]3dCR,G\r\t3vK\u0002\"x\u000e\t7bG.\u0004sN\u001a\u0011vg\u0016\u0004\u0013M\u001c3!G>l\u0007/\u001b7fe6bWM^3mAM,\b\u000f]8si\u0006\nq-\u0001\u00043]E\nd\u0006\r")
public interface QueueProxy<A>
extends Proxy {
    @Override
    public Queue<A> self();

    public static /* synthetic */ Object apply$(QueueProxy $this, int n) {
        return $this.apply(n);
    }

    default public A apply(int n) {
        return this.self().apply(n);
    }

    public static /* synthetic */ int length$(QueueProxy $this) {
        return $this.length();
    }

    default public int length() {
        return this.self().length();
    }

    public static /* synthetic */ boolean isEmpty$(QueueProxy $this) {
        return $this.isEmpty();
    }

    default public boolean isEmpty() {
        return this.self().isEmpty();
    }

    public static /* synthetic */ QueueProxy $plus$eq$(QueueProxy $this, Object elem) {
        return $this.$plus$eq(elem);
    }

    default public QueueProxy<A> $plus$eq(A elem) {
        this.self().$plus$eq((Object)elem);
        return this;
    }

    public static /* synthetic */ QueueProxy $plus$plus$eq$(QueueProxy $this, TraversableOnce it) {
        return $this.$plus$plus$eq(it);
    }

    default public QueueProxy<A> $plus$plus$eq(TraversableOnce<A> it) {
        this.self().$plus$plus$eq(it);
        return this;
    }

    public static /* synthetic */ void enqueue$(QueueProxy $this, Seq elems) {
        $this.enqueue(elems);
    }

    default public void enqueue(Seq<A> elems) {
        this.self().$plus$plus$eq(elems);
    }

    public static /* synthetic */ Object dequeue$(QueueProxy $this) {
        return $this.dequeue();
    }

    default public A dequeue() {
        return this.self().dequeue();
    }

    public static /* synthetic */ Object front$(QueueProxy $this) {
        return $this.front();
    }

    default public A front() {
        return this.self().front();
    }

    public static /* synthetic */ void clear$(QueueProxy $this) {
        $this.clear();
    }

    default public void clear() {
        this.self().clear();
    }

    public static /* synthetic */ Iterator iterator$(QueueProxy $this) {
        return $this.iterator();
    }

    default public Iterator<A> iterator() {
        return this.self().iterator();
    }

    public static /* synthetic */ Queue clone$(QueueProxy $this) {
        return $this.clone();
    }

    default public Queue<A> clone() {
        return new QueueProxy<A>(this){
            private final /* synthetic */ QueueProxy $outer;

            public A apply(int n) {
                return (A)QueueProxy.apply$(this, n);
            }

            public int length() {
                return QueueProxy.length$(this);
            }

            public boolean isEmpty() {
                return QueueProxy.isEmpty$(this);
            }

            public QueueProxy<A> $plus$eq(A elem) {
                return QueueProxy.$plus$eq$(this, elem);
            }

            public QueueProxy<A> $plus$plus$eq(TraversableOnce<A> it) {
                return QueueProxy.$plus$plus$eq$(this, it);
            }

            public void enqueue(Seq<A> elems) {
                QueueProxy.enqueue$(this, elems);
            }

            public A dequeue() {
                return (A)QueueProxy.dequeue$(this);
            }

            public A front() {
                return (A)QueueProxy.front$(this);
            }

            public void clear() {
                QueueProxy.clear$(this);
            }

            public Iterator<A> iterator() {
                return QueueProxy.iterator$(this);
            }

            public Queue<A> clone() {
                return QueueProxy.clone$(this);
            }

            public int hashCode() {
                return Proxy.hashCode$(this);
            }

            public boolean equals(Object that) {
                return Proxy.equals$(this, that);
            }

            public String toString() {
                return Proxy.toString$(this);
            }

            public Queue<A> self() {
                return this.$outer.self().clone();
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                Proxy.$init$(this);
                QueueProxy.$init$(this);
            }
        };
    }

    public static void $init$(QueueProxy $this) {
    }
}

