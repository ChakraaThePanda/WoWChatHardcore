/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function1;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.Iterator;
import scala.collection.mutable.AbstractIterable;
import scala.collection.mutable.Queue;
import scala.collection.mutable.Subscriber;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001%4A!\u0004\b\u0001+!)a\u0007\u0001C\u0001o!9\u0011\b\u0001b\u0001\n#Q\u0004B\u0002 \u0001A\u0003%1\bC\u0004@\u0001\t\u0007I\u0011\u0001!\t\r\u0011\u0003\u0001\u0015!\u0003B\u0011\u0015)\u0005\u0001\"\u0001G\u0011\u0015q\u0005\u0001\"\u0011A\u0011\u0015y\u0005\u0001\"\u0001Q\u0011\u0015)\u0006\u0001\"\u0001W\u0011\u0015A\u0006\u0001\"\u0001Z\u0011\u0015Q\u0006\u0001\"\u0011\\\u0011\u0015\t\u0007\u0001\"\u0011c\u0005\u001dA\u0015n\u001d;pefT!a\u0004\t\u0002\u000f5,H/\u00192mK*\u0011\u0011CE\u0001\u000bG>dG.Z2uS>t'\"A\n\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0019acK\u0011\u0014\u000b\u00019R\u0006M\u001a\u0011\u0007aI2$D\u0001\u000f\u0013\tQbB\u0001\tBEN$(/Y2u\u0013R,'/\u00192mKB!A$H\u0010+\u001b\u0005\u0011\u0012B\u0001\u0010\u0013\u0005\u0019!V\u000f\u001d7feA\u0011\u0001%\t\u0007\u0001\t\u0015\u0011\u0003A1\u0001$\u0005\r\u0001VOY\t\u0003I\u001d\u0002\"\u0001H\u0013\n\u0005\u0019\u0012\"a\u0002(pi\"Lgn\u001a\t\u00039!J!!\u000b\n\u0003\u0007\u0005s\u0017\u0010\u0005\u0002!W\u0011)A\u0006\u0001b\u0001G\t\u0019QI\u001e;\u0011\taq#fH\u0005\u0003_9\u0011!bU;cg\u000e\u0014\u0018NY3s!\rA\u0012gG\u0005\u0003e9\u0011\u0001\"\u0013;fe\u0006\u0014G.\u001a\t\u00039QJ!!\u000e\n\u0003\u0019M+'/[1mSj\f'\r\\3\u0002\rqJg.\u001b;?)\u0005A\u0004\u0003\u0002\r\u0001U}\t1\u0001\\8h+\u0005Y\u0004c\u0001\r=7%\u0011QH\u0004\u0002\u0006#V,W/Z\u0001\u0005Y><\u0007%\u0001\u0006nCbD\u0015n\u001d;pef,\u0012!\u0011\t\u00039\tK!a\u0011\n\u0003\u0007%sG/A\u0006nCbD\u0015n\u001d;pef\u0004\u0013A\u00028pi&4\u0017\u0010F\u0002H\u00152\u0003\"\u0001\b%\n\u0005%\u0013\"\u0001B+oSRDQa\u0013\u0004A\u0002}\t1\u0001];c\u0011\u0015ie\u00011\u0001+\u0003\u0015)g/\u001a8u\u0003\u0011\u0019\u0018N_3\u0002\u0011%$XM]1u_J,\u0012!\u0015\t\u0004%N[R\"\u0001\t\n\u0005Q\u0003\"\u0001C%uKJ\fGo\u001c:\u0002\r\u00154XM\u001c;t+\u00059\u0006c\u0001*TU\u0005)1\r\\3beR\tq)\u0001\u0004fcV\fGn\u001d\u000b\u00039~\u0003\"\u0001H/\n\u0005y\u0013\"a\u0002\"p_2,\u0017M\u001c\u0005\u0006A.\u0001\raJ\u0001\u0004_\nT\u0017\u0001\u00035bg\"\u001cu\u000eZ3\u0015\u0003\u0005CC\u0001\u00013hQB\u0011A$Z\u0005\u0003MJ\u0011\u0001cU3sS\u0006dg+\u001a:tS>tW+\u0013#\u0002\u000bY\fG.^3\u001f\u0011!sw\f\u0005e\u001553\b")
public class History<Evt, Pub>
extends AbstractIterable<Tuple2<Pub, Evt>>
implements Subscriber<Evt, Pub>,
Serializable {
    public static final long serialVersionUID = 5219213543849892588L;
    private final Queue<Tuple2<Pub, Evt>> log = new Queue();
    private final int maxHistory;

    public Queue<Tuple2<Pub, Evt>> log() {
        return this.log;
    }

    public int maxHistory() {
        return this.maxHistory;
    }

    @Override
    public void notify(Pub pub, Evt event) {
        if (this.log().length() >= this.maxHistory()) {
            this.log().dequeue();
        }
        this.log().enqueue(Predef$.MODULE$.wrapRefArray((Object[])new Tuple2[]{new Tuple2<Pub, Evt>(pub, event)}));
    }

    @Override
    public int size() {
        return this.log().length();
    }

    @Override
    public Iterator<Tuple2<Pub, Evt>> iterator() {
        return this.log().iterator();
    }

    public Iterator<Evt> events() {
        return this.log().iterator().map((Function1<Tuple2, Object> & java.io.Serializable & Serializable)x$1 -> x$1._2());
    }

    public void clear() {
        this.log().clear();
    }

    @Override
    public boolean equals(Object obj) {
        boolean bl;
        if (obj instanceof History) {
            History history = (History)obj;
            bl = this.log().equals(history.log());
        } else {
            bl = false;
        }
        return bl;
    }

    public int hashCode() {
        return this.log().hashCode();
    }

    public History() {
        this.maxHistory = 1000;
    }
}

