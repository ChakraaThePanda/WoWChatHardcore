/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function1;
import scala.Option;
import scala.collection.GenSeqLike;
import scala.collection.Seq;
import scala.collection.SeqLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.Growable;
import scala.collection.mutable.Queue;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001U4A!\u0004\b\u0001+!)q\u0005\u0001C\u0001Q!)!\u0006\u0001C!W!)q\u0006\u0001C!a!)A\u0007\u0001C!k!)A\b\u0001C!{!)a\t\u0001C!\u000f\")\u0001\n\u0001C!\u0013\")!\u000b\u0001C!'\")\u0001\f\u0001C!3\")!\f\u0001C!7\")A\f\u0001C!;\")\u0001\r\u0001C!C\n\t2+\u001f8dQJ|g.\u001b>fIF+X-^3\u000b\u0005=\u0001\u0012aB7vi\u0006\u0014G.\u001a\u0006\u0003#I\t!bY8mY\u0016\u001cG/[8o\u0015\u0005\u0019\u0012!B:dC2\f7\u0001A\u000b\u0003-u\u0019\"\u0001A\f\u0011\u0007aI2$D\u0001\u000f\u0013\tQbBA\u0003Rk\u0016,X\r\u0005\u0002\u001d;1\u0001A!\u0002\u0010\u0001\u0005\u0004y\"!A!\u0012\u0005\u0001\"\u0003CA\u0011#\u001b\u0005\u0011\u0012BA\u0012\u0013\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"!I\u0013\n\u0005\u0019\u0012\"aA!os\u00061A(\u001b8jiz\"\u0012!\u000b\t\u00041\u0001Y\u0012aB5t\u000b6\u0004H/_\u000b\u0002YA\u0011\u0011%L\u0005\u0003]I\u0011qAQ8pY\u0016\fg.\u0001\u0005%a2,8\u000fJ3r)\t\t$'D\u0001\u0001\u0011\u0015\u00194\u00011\u0001\u001c\u0003\u0011)G.Z7\u0002\u001b\u0011\u0002H.^:%a2,8\u000fJ3r)\t\td\u0007C\u00038\t\u0001\u0007\u0001(\u0001\u0002ygB\u0019\u0011HO\u000e\u000e\u0003AI!a\u000f\t\u0003\u001fQ\u0013\u0018M^3sg\u0006\u0014G.Z(oG\u0016\fq!\u001a8rk\u0016,X\r\u0006\u0002?\u0003B\u0011\u0011eP\u0005\u0003\u0001J\u0011A!\u00168ji\")!)\u0002a\u0001\u0007\u0006)Q\r\\3ngB\u0019\u0011\u0005R\u000e\n\u0005\u0015\u0013\"A\u0003\u001fsKB,\u0017\r^3e}\u00059A-Z9vKV,G#A\u000e\u0002\u0019\u0011,\u0017/^3vK\u001aK'o\u001d;\u0015\u0005)k\u0005cA\u0011L7%\u0011AJ\u0005\u0002\u0007\u001fB$\u0018n\u001c8\t\u000b9;\u0001\u0019A(\u0002\u0003A\u0004B!\t)\u001cY%\u0011\u0011K\u0005\u0002\n\rVt7\r^5p]F\n!\u0002Z3rk\u0016,X-\u00117m)\t!v\u000bE\u0002\u0019+nI!A\u0016\b\u0003\u0007M+\u0017\u000fC\u0003O\u0011\u0001\u0007q*A\u0003ge>tG/F\u0001\u001c\u0003\u0015\u0019G.Z1s)\u0005q\u0014AB3rk\u0006d7\u000f\u0006\u0002-=\")ql\u0003a\u0001I\u0005!A\u000f[1u\u0003!!xn\u0015;sS:<G#\u00012\u0011\u0005\rTgB\u00013i!\t)'#D\u0001g\u0015\t9G#\u0001\u0004=e>|GOP\u0005\u0003SJ\ta\u0001\u0015:fI\u00164\u0017BA6m\u0005\u0019\u0019FO]5oO*\u0011\u0011N\u0005\u0015\u0005\u00019\f8\u000f\u0005\u0002\"_&\u0011\u0001O\u0005\u0002\u000bI\u0016\u0004(/Z2bi\u0016$\u0017%\u0001:\u0002\u0003S\u0019\u0016P\\2ie>t\u0017N_1uS>t\u0007E^5bAM,G.Z2uSZ,\u0007e\u001c<feJLG-\u001b8hA=4\u0007%\\3uQ>$7\u000fI5tA%t\u0007.\u001a:f]Rd\u0017\u0010I;oe\u0016d\u0017.\u00192mK:\u00023i\u001c8tS\u0012,'\u000f\t6bm\u0006tS\u000f^5m]\r|gnY;se\u0016tGOL\"p]\u000e,(O]3oi2Kgn[3e#V,W/\u001a\u0011bg\u0002\ng\u000eI1mi\u0016\u0014h.\u0019;jm\u0016t\u0013%\u0001;\u0002\rIr\u0013'\r\u00181\u0001")
public class SynchronizedQueue<A>
extends Queue<A> {
    @Override
    public synchronized boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public synchronized SynchronizedQueue<A> $plus$eq(A elem) {
        return (SynchronizedQueue)super.$plus$eq((Object)elem);
    }

    @Override
    public synchronized SynchronizedQueue<A> $plus$plus$eq(TraversableOnce<A> xs) {
        return (SynchronizedQueue)Growable.$plus$plus$eq$(this, xs);
    }

    @Override
    public void enqueue(Seq<A> elems) {
        synchronized (this) {
            SynchronizedQueue cfr_ignored_0 = (SynchronizedQueue)Growable.$plus$plus$eq$(this, elems);
            return;
        }
    }

    @Override
    public synchronized A dequeue() {
        return super.dequeue();
    }

    @Override
    public synchronized Option<A> dequeueFirst(Function1<A, Object> p) {
        return super.dequeueFirst(p);
    }

    @Override
    public synchronized scala.collection.mutable.Seq<A> dequeueAll(Function1<A, Object> p) {
        return super.dequeueAll(p);
    }

    @Override
    public synchronized A front() {
        return super.front();
    }

    @Override
    public synchronized void clear() {
        super.clear();
    }

    @Override
    public synchronized boolean equals(Object that) {
        return GenSeqLike.equals$(this, that);
    }

    @Override
    public synchronized String toString() {
        return SeqLike.toString$(this);
    }
}

