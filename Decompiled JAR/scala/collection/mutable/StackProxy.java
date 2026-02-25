/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Proxy;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.TraversableOnce;
import scala.collection.immutable.List;
import scala.collection.mutable.Stack;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001e4q\u0001E\t\u0011\u0002\u0007\u0005\u0001\u0004C\u0003.\u0001\u0011\u0005a\u0006C\u00033\u0001\u0019\u00051\u0007C\u00035\u0001\u0011\u0005S\u0007C\u0003<\u0001\u0011\u0005C\bC\u0003>\u0001\u0011\u0005c\bC\u0003C\u0001\u0011\u00051\tC\u0003H\u0001\u0011\u0005\u0003\nC\u0003P\u0001\u0011\u0005\u0003\u000bC\u0003P\u0001\u0011\u0005#\fC\u0003]\u0001\u0011\u0005S\fC\u0003_\u0001\u0011\u0005s\fC\u0003a\u0001\u0011\u0005c\u0006C\u0003b\u0001\u0011\u0005#\rC\u0003g\u0001\u0011\u0005s\rC\u0003p\u0001\u0011\u0005\u0003O\u0001\u0006Ti\u0006\u001c7\u000e\u0015:pqfT!AE\n\u0002\u000f5,H/\u00192mK*\u0011A#F\u0001\u000bG>dG.Z2uS>t'\"\u0001\f\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0011\u0011\u0004I\n\u0004\u0001iQ\u0003cA\u000e\u001d=5\t\u0011#\u0003\u0002\u001e#\t)1\u000b^1dWB\u0011q\u0004\t\u0007\u0001\t\u0015\t\u0003A1\u0001#\u0005\u0005\t\u0015CA\u0012(!\t!S%D\u0001\u0016\u0013\t1SCA\u0004O_RD\u0017N\\4\u0011\u0005\u0011B\u0013BA\u0015\u0016\u0005\r\te.\u001f\t\u0003I-J!\u0001L\u000b\u0003\u000bA\u0013x\u000e_=\u0002\r\u0011Jg.\u001b;%)\u0005y\u0003C\u0001\u00131\u0013\t\tTC\u0001\u0003V]&$\u0018\u0001B:fY\u001a,\u0012AG\u0001\u0006CB\u0004H.\u001f\u000b\u0003=YBQaN\u0002A\u0002a\n\u0011A\u001c\t\u0003IeJ!AO\u000b\u0003\u0007%sG/\u0001\u0004mK:<G\u000f[\u000b\u0002q\u00059\u0011n]#naRLX#A \u0011\u0005\u0011\u0002\u0015BA!\u0016\u0005\u001d\u0011un\u001c7fC:\f\u0001\u0002\n9mkN$S-\u001d\u000b\u0003\t\u0016k\u0011\u0001\u0001\u0005\u0006\r\u001a\u0001\rAH\u0001\u0005K2,W.A\u0004qkND\u0017\t\u001c7\u0015\u0005\u0011K\u0005\"\u0002&\b\u0001\u0004Y\u0015A\u0001=t!\raUJH\u0007\u0002'%\u0011aj\u0005\u0002\u0010)J\fg/\u001a:tC\ndWm\u00148dK\u0006!\u0001/^:i)\u0011!\u0015kU+\t\u000bIC\u0001\u0019\u0001\u0010\u0002\u000b\u0015dW-\\\u0019\t\u000bQC\u0001\u0019\u0001\u0010\u0002\u000b\u0015dW-\u001c\u001a\t\u000bYC\u0001\u0019A,\u0002\u000b\u0015dW-\\:\u0011\u0007\u0011Bf$\u0003\u0002Z+\tQAH]3qK\u0006$X\r\u001a \u0015\u0005\u0011[\u0006\"\u0002$\n\u0001\u0004q\u0012a\u0001;paV\ta$A\u0002q_B$\u0012AH\u0001\u0006G2,\u0017M]\u0001\tSR,'/\u0019;peV\t1\rE\u0002MIzI!!Z\n\u0003\u0011%#XM]1u_J\fa\u0001^8MSN$X#\u00015\u0011\u0007%dgD\u0004\u0002%U&\u00111.F\u0001\ba\u0006\u001c7.Y4f\u0013\tigN\u0001\u0003MSN$(BA6\u0016\u0003\u0015\u0019Gn\u001c8f)\u0005Q\u0002\u0006\u0002\u0001sk^\u0004\"\u0001J:\n\u0005Q,\"A\u00033faJ,7-\u0019;fI\u0006\na/\u0001#qe>D\u00180\u001b8hA%\u001c\b\u0005Z3qe\u0016\u001c\u0017\r^3eA\u0011,X\r\t;pA1\f7m\u001b\u0011pM\u0002*8/\u001a\u0011b]\u0012\u00043m\\7qS2,'/\f7fm\u0016d\u0007e];qa>\u0014H/I\u0001y\u0003\u0019\u0011d&M\u0019/a\u0001")
public interface StackProxy<A>
extends Proxy {
    @Override
    public Stack<A> self();

    public static /* synthetic */ Object apply$(StackProxy $this, int n) {
        return $this.apply(n);
    }

    default public A apply(int n) {
        return this.self().apply(n);
    }

    public static /* synthetic */ int length$(StackProxy $this) {
        return $this.length();
    }

    default public int length() {
        return this.self().length();
    }

    public static /* synthetic */ boolean isEmpty$(StackProxy $this) {
        return $this.isEmpty();
    }

    default public boolean isEmpty() {
        return this.self().isEmpty();
    }

    public static /* synthetic */ StackProxy $plus$eq$(StackProxy $this, Object elem) {
        return $this.$plus$eq(elem);
    }

    default public StackProxy<A> $plus$eq(A elem) {
        this.self().push(elem);
        return this;
    }

    public static /* synthetic */ StackProxy pushAll$(StackProxy $this, TraversableOnce xs) {
        return $this.pushAll(xs);
    }

    default public StackProxy<A> pushAll(TraversableOnce<A> xs) {
        this.self().pushAll(xs);
        return this;
    }

    public static /* synthetic */ StackProxy push$(StackProxy $this, Object elem1, Object elem2, Seq elems) {
        return $this.push(elem1, elem2, elems);
    }

    default public StackProxy<A> push(A elem1, A elem2, Seq<A> elems) {
        this.self().push(elem1).push(elem2).pushAll(elems);
        return this;
    }

    public static /* synthetic */ StackProxy push$(StackProxy $this, Object elem) {
        return $this.push(elem);
    }

    default public StackProxy<A> push(A elem) {
        this.self().push(elem);
        return this;
    }

    public static /* synthetic */ Object top$(StackProxy $this) {
        return $this.top();
    }

    default public A top() {
        return this.self().top();
    }

    public static /* synthetic */ Object pop$(StackProxy $this) {
        return $this.pop();
    }

    default public A pop() {
        return this.self().pop();
    }

    public static /* synthetic */ void clear$(StackProxy $this) {
        $this.clear();
    }

    default public void clear() {
        this.self().clear();
    }

    public static /* synthetic */ Iterator iterator$(StackProxy $this) {
        return $this.iterator();
    }

    default public Iterator<A> iterator() {
        return this.self().iterator();
    }

    public static /* synthetic */ List toList$(StackProxy $this) {
        return $this.toList();
    }

    default public List<A> toList() {
        return this.self().toList();
    }

    public static /* synthetic */ Stack clone$(StackProxy $this) {
        return $this.clone();
    }

    default public Stack<A> clone() {
        return new StackProxy<A>(this){
            private final /* synthetic */ StackProxy $outer;

            public A apply(int n) {
                return (A)StackProxy.apply$(this, n);
            }

            public int length() {
                return StackProxy.length$(this);
            }

            public boolean isEmpty() {
                return StackProxy.isEmpty$(this);
            }

            public StackProxy<A> $plus$eq(A elem) {
                return StackProxy.$plus$eq$(this, elem);
            }

            public StackProxy<A> pushAll(TraversableOnce<A> xs) {
                return StackProxy.pushAll$(this, xs);
            }

            public StackProxy<A> push(A elem1, A elem2, Seq<A> elems) {
                return StackProxy.push$(this, elem1, elem2, elems);
            }

            public StackProxy<A> push(A elem) {
                return StackProxy.push$(this, elem);
            }

            public A top() {
                return (A)StackProxy.top$(this);
            }

            public A pop() {
                return (A)StackProxy.pop$(this);
            }

            public void clear() {
                StackProxy.clear$(this);
            }

            public Iterator<A> iterator() {
                return StackProxy.iterator$(this);
            }

            public List<A> toList() {
                return StackProxy.toList$(this);
            }

            public Stack<A> clone() {
                return StackProxy.clone$(this);
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

            public Stack<A> self() {
                return this.$outer.self().clone();
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                Proxy.$init$(this);
                StackProxy.$init$(this);
            }
        };
    }

    public static void $init$(StackProxy $this) {
    }
}

