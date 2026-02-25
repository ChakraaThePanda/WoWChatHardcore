/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.SeqLike;
import scala.collection.TraversableOnce;
import scala.collection.immutable.List;
import scala.collection.mutable.Stack;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001E4A\u0001D\u0007\u0001)!)a\u0005\u0001C\u0001O!)\u0011\u0006\u0001C!U!)a\u0006\u0001C!_!)a\u0006\u0001C!g!)Q\b\u0001C!}!)Q\t\u0001C!\r\")q\t\u0001C!\u0011\")\u0011\n\u0001C!\u0015\")a\n\u0001C!\u001f\")1\u000b\u0001C!)\")A\f\u0001C!;\n\t2+\u001f8dQJ|g.\u001b>fIN#\u0018mY6\u000b\u00059y\u0011aB7vi\u0006\u0014G.\u001a\u0006\u0003!E\t!bY8mY\u0016\u001cG/[8o\u0015\u0005\u0011\u0012!B:dC2\f7\u0001A\u000b\u0003+q\u0019\"\u0001\u0001\f\u0011\u0007]A\"$D\u0001\u000e\u0013\tIRBA\u0003Ti\u0006\u001c7\u000e\u0005\u0002\u001c91\u0001A!B\u000f\u0001\u0005\u0004q\"!A!\u0012\u0005}\u0019\u0003C\u0001\u0011\"\u001b\u0005\t\u0012B\u0001\u0012\u0012\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"\u0001\t\u0013\n\u0005\u0015\n\"aA!os\u00061A(\u001b8jiz\"\u0012\u0001\u000b\t\u0004/\u0001Q\u0012aB5t\u000b6\u0004H/_\u000b\u0002WA\u0011\u0001\u0005L\u0005\u0003[E\u0011qAQ8pY\u0016\fg.\u0001\u0003qkNDGC\u0001\u00192\u001b\u0005\u0001\u0001\"\u0002\u001a\u0004\u0001\u0004Q\u0012\u0001B3mK6$B\u0001\r\u001b7q!)Q\u0007\u0002a\u00015\u0005)Q\r\\3nc!)q\u0007\u0002a\u00015\u0005)Q\r\\3ne!)\u0011\b\u0002a\u0001u\u0005)Q\r\\3ngB\u0019\u0001e\u000f\u000e\n\u0005q\n\"A\u0003\u001fsKB,\u0017\r^3e}\u00059\u0001/^:i\u00032dGC\u0001\u0019@\u0011\u0015\u0001U\u00011\u0001B\u0003\tA8\u000fE\u0002C\u0007ji\u0011aD\u0005\u0003\t>\u0011q\u0002\u0016:bm\u0016\u00148/\u00192mK>s7-Z\u0001\u0004i>\u0004X#\u0001\u000e\u0002\u0007A|\u0007\u000fF\u0001\u001b\u0003\u0015\u0019G.Z1s)\u0005Y\u0005C\u0001\u0011M\u0013\ti\u0015C\u0001\u0003V]&$\u0018\u0001C5uKJ\fGo\u001c:\u0016\u0003A\u00032AQ)\u001b\u0013\t\u0011vB\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u0003\u0019!x\u000eT5tiV\tQ\u000bE\u0002W3jq!\u0001I,\n\u0005a\u000b\u0012a\u00029bG.\fw-Z\u0005\u00035n\u0013A\u0001T5ti*\u0011\u0001,E\u0001\ti>\u001cFO]5oOR\ta\f\u0005\u0002`M:\u0011\u0001\r\u001a\t\u0003CFi\u0011A\u0019\u0006\u0003GN\ta\u0001\u0010:p_Rt\u0014BA3\u0012\u0003\u0019\u0001&/\u001a3fM&\u0011q\r\u001b\u0002\u0007'R\u0014\u0018N\\4\u000b\u0005\u0015\f\u0002\u0006\u0002\u0001k[>\u0004\"\u0001I6\n\u00051\f\"A\u00033faJ,7-\u0019;fI\u0006\na.AA\u000b'ft7\r\u001b:p]&T\u0018\r^5p]\u00022\u0018.\u0019\u0011tK2,7\r^5wK\u0002zg/\u001a:sS\u0012Lgn\u001a\u0011pM\u0002jW\r\u001e5pIN\u0004\u0013n\u001d\u0011j]\",'/\u001a8uYf\u0004SO\u001c:fY&\f'\r\\3/A\r{gn]5eKJ\u0004#.\u0019<b]U$\u0018\u000e\u001c\u0018d_:\u001cWO\u001d:f]RtC*\u001b8lK\u0012\u0014En\\2lS:<G)Z9vKV,\u0007%\u001b8ti\u0016\fGML\u0011\u0002a\u00061!GL\u00192]A\u0002")
public class SynchronizedStack<A>
extends Stack<A> {
    @Override
    public synchronized boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public synchronized SynchronizedStack<A> push(A elem) {
        return (SynchronizedStack)super.push(elem);
    }

    @Override
    public synchronized SynchronizedStack<A> push(A elem1, A elem2, Seq<A> elems) {
        return (SynchronizedStack)super.push(elem1, elem2, elems);
    }

    @Override
    public synchronized SynchronizedStack<A> pushAll(TraversableOnce<A> xs) {
        return (SynchronizedStack)super.pushAll(this.elems());
    }

    @Override
    public synchronized A top() {
        return super.top();
    }

    @Override
    public synchronized A pop() {
        return super.pop();
    }

    @Override
    public synchronized void clear() {
        super.clear();
    }

    @Override
    public synchronized Iterator<A> iterator() {
        return super.iterator();
    }

    @Override
    public synchronized List<A> toList() {
        return super.toList();
    }

    @Override
    public synchronized String toString() {
        return SeqLike.toString$(this);
    }
}

