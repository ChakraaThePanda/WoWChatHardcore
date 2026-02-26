/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function1;
import scala.Serializable;
import scala.collection.Iterator;
import scala.collection.immutable.List;
import scala.collection.immutable.Set;
import scala.collection.mutable.AbstractSet;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005ua\u0001\u0002\t\u0012\u0001aA\u0001\u0002\r\u0001\u0003\u0002\u0004%\t\"\r\u0005\to\u0001\u0011\t\u0019!C\tq!Aa\b\u0001B\u0001B\u0003&!\u0007C\u0003@\u0001\u0011\u0005\u0001\tC\u0003D\u0001\u0011\u0005C\tC\u0003I\u0001\u0011\u0005\u0013\nC\u0003N\u0001\u0011\u0005a\nC\u0003R\u0001\u0011\u0005#\u000bC\u0003]\u0001\u0011\u0005S\fC\u0003b\u0001\u0011\u0005#\rC\u0003k\u0001\u0011\u00053\u000eC\u0003x\u0001\u0011\u0005\u0001\u0010C\u0003~\u0001\u0011\u0005a\u0010C\u0004\u0002\u0004\u0001!\t!!\u0002\t\u000f\u0005%\u0001\u0001\"\u0011\u0002\f\t\u0019\u0012*\\7vi\u0006\u0014G.Z*fi\u0006#\u0017\r\u001d;pe*\u0011!cE\u0001\b[V$\u0018M\u00197f\u0015\t!R#\u0001\u0006d_2dWm\u0019;j_:T\u0011AF\u0001\u0006g\u000e\fG.Y\u0002\u0001+\tI\u0002e\u0005\u0003\u00015)j\u0003cA\u000e\u001d=5\t\u0011#\u0003\u0002\u001e#\tY\u0011IY:ue\u0006\u001cGoU3u!\ty\u0002\u0005\u0004\u0001\u0005\u000b\u0005\u0002!\u0019\u0001\u0012\u0003\u0003\u0005\u000b\"aI\u0014\u0011\u0005\u0011*S\"A\u000b\n\u0005\u0019*\"a\u0002(pi\"Lgn\u001a\t\u0003I!J!!K\u000b\u0003\u0007\u0005s\u0017\u0010E\u0002\u001cWyI!\u0001L\t\u0003\u0007M+G\u000f\u0005\u0002%]%\u0011q&\u0006\u0002\r'\u0016\u0014\u0018.\u00197ju\u0006\u0014G.Z\u0001\u0004g\u0016$X#\u0001\u001a\u0011\u0007M2d$D\u00015\u0015\t)4#A\u0005j[6,H/\u00192mK&\u0011A\u0006N\u0001\bg\u0016$x\fJ3r)\tID\b\u0005\u0002%u%\u00111(\u0006\u0002\u0005+:LG\u000fC\u0004>\u0005\u0005\u0005\t\u0019\u0001\u001a\u0002\u0007a$\u0013'\u0001\u0003tKR\u0004\u0013A\u0002\u001fj]&$h\b\u0006\u0002B\u0005B\u00191\u0004\u0001\u0010\t\u000bA\"\u0001\u0019\u0001\u001a\u0002\tML'0Z\u000b\u0002\u000bB\u0011AER\u0005\u0003\u000fV\u00111!\u00138u\u0003\u001dI7/R7qif,\u0012A\u0013\t\u0003I-K!\u0001T\u000b\u0003\u000f\t{w\u000e\\3b]\u0006A1m\u001c8uC&t7\u000f\u0006\u0002K\u001f\")\u0001k\u0002a\u0001=\u0005!Q\r\\3n\u0003\u001d1wN]3bG\",\"a\u0015.\u0015\u0005e\"\u0006\"B+\t\u0001\u00041\u0016!\u00014\u0011\t\u0011:f$W\u0005\u00031V\u0011\u0011BR;oGRLwN\\\u0019\u0011\u0005}QF!B.\t\u0005\u0004\u0011#!A+\u0002\r\u0015D\u0018n\u001d;t)\tQe\fC\u0003`\u0013\u0001\u0007\u0001-A\u0001q!\u0011!sK\b&\u0002\rQ|G*[:u+\u0005\u0019\u0007c\u00013h=9\u0011A%Z\u0005\u0003MV\tq\u0001]1dW\u0006<W-\u0003\u0002iS\n!A*[:u\u0015\t1W#\u0001\u0005u_N#(/\u001b8h)\u0005a\u0007CA7u\u001d\tq'\u000f\u0005\u0002p+5\t\u0001O\u0003\u0002r/\u00051AH]8pizJ!a]\u000b\u0002\rA\u0013X\rZ3g\u0013\t)hO\u0001\u0004TiJLgn\u001a\u0006\u0003gV\t\u0001\"\u001b;fe\u0006$xN]\u000b\u0002sB\u0019!p\u001f\u0010\u000e\u0003MI!\u0001`\n\u0003\u0011%#XM]1u_J\f\u0001\u0002\n9mkN$S-\u001d\u000b\u0004\u007f\u0006\u0005Q\"\u0001\u0001\t\u000bAk\u0001\u0019\u0001\u0010\u0002\u0013\u0011j\u0017N\\;tI\u0015\fHcA@\u0002\b!)\u0001K\u0004a\u0001=\u0005)1\r\\3beR\t\u0011\bK\u0004\u0001\u0003\u001f\t)\"!\u0007\u0011\u0007\u0011\n\t\"C\u0002\u0002\u0014U\u0011!\u0002Z3qe\u0016\u001c\u0017\r^3eC\t\t9\"\u0001#bI\u0006\u0004Ho\u001c:tA\u0005\u0014X\rI5oQ\u0016\u0014XM\u001c;ms\u0002*hN]3mS\u0006\u0014G.\u001a\u0011b]\u0012\u0004\u0003O]8oK\u0002\"x\u000e\t9fe\u001a|'/\\1oG\u0016\u0004\u0003O]8cY\u0016l7/\t\u0002\u0002\u001c\u00051!GL\u00192]A\u0002")
public class ImmutableSetAdaptor<A>
extends AbstractSet<A>
implements Serializable {
    private Set<A> set;

    public Set<A> set() {
        return this.set;
    }

    public void set_$eq(Set<A> x$1) {
        this.set = x$1;
    }

    @Override
    public int size() {
        return this.set().size();
    }

    @Override
    public boolean isEmpty() {
        return this.set().isEmpty();
    }

    @Override
    public boolean contains(A elem) {
        return this.set().contains(elem);
    }

    @Override
    public <U> void foreach(Function1<A, U> f) {
        this.set().foreach(f);
    }

    @Override
    public boolean exists(Function1<A, Object> p) {
        return this.set().exists(p);
    }

    @Override
    public List<A> toList() {
        return this.set().toList();
    }

    @Override
    public String toString() {
        return this.set().toString();
    }

    @Override
    public Iterator<A> iterator() {
        return this.set().iterator();
    }

    @Override
    public ImmutableSetAdaptor<A> $plus$eq(A elem) {
        this.set_$eq((Set)this.set().$plus(elem));
        return this;
    }

    @Override
    public ImmutableSetAdaptor<A> $minus$eq(A elem) {
        this.set_$eq((Set)this.set().$minus(elem));
        return this;
    }

    @Override
    public void clear() {
        this.set_$eq((Set)this.set().empty());
    }

    public ImmutableSetAdaptor(Set<A> set) {
        this.set = set;
    }
}

