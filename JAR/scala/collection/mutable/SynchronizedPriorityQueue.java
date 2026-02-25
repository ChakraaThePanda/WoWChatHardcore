/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.TraversableOnce;
import scala.collection.mutable.PriorityQueue;
import scala.math.Ordering;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001U4A!\u0004\b\u0011+!Iq\u0005\u0001B\u0001B\u0003-\u0001f\f\u0005\u0006a\u0001!\t!\r\u0005\u0006k\u0001!\tE\u000e\u0005\u0006u\u0001!\te\u000f\u0005\u0006\u007f\u0001!\t\u0005\u0011\u0005\u0006\u000f\u0002!\t\u0005\u0013\u0005\u0006#\u0002!\tE\u0015\u0005\u0006'\u0002!\t\u0005\u0016\u0005\u0006+\u0002!\tE\u0016\u0005\u0006/\u0002!\t\u0005\u0017\u0005\u00069\u0002!\t%\u0018\u0005\u0006A\u0002!\t%\u0019\u0002\u001a'ft7\r\u001b:p]&TX\r\u001a)sS>\u0014\u0018\u000e^=Rk\u0016,XM\u0003\u0002\u0010!\u00059Q.\u001e;bE2,'BA\t\u0013\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002'\u0005)1oY1mC\u000e\u0001QC\u0001\f\u001e'\t\u0001q\u0003E\u0002\u00193mi\u0011AD\u0005\u000359\u0011Q\u0002\u0015:j_JLG/_)vKV,\u0007C\u0001\u000f\u001e\u0019\u0001!QA\b\u0001C\u0002}\u0011\u0011!Q\t\u0003A\u0011\u0002\"!\t\u0012\u000e\u0003II!a\t\n\u0003\u000f9{G\u000f[5oOB\u0011\u0011%J\u0005\u0003MI\u00111!\u00118z\u0003\ry'\u000f\u001a\t\u0004S1ZbBA\u0011+\u0013\tY##A\u0004qC\u000e\\\u0017mZ3\n\u00055r#\u0001C(sI\u0016\u0014\u0018N\\4\u000b\u0005-\u0012\u0012BA\u0014\u001a\u0003\u0019a\u0014N\\5u}Q\t!\u0007\u0006\u00024iA\u0019\u0001\u0004A\u000e\t\u000b\u001d\u0012\u00019\u0001\u0015\u0002\u000f%\u001cX)\u001c9usV\tq\u0007\u0005\u0002\"q%\u0011\u0011H\u0005\u0002\b\u0005>|G.Z1o\u0003!!\u0003\u000f\\;tI\u0015\fHC\u0001\u001f>\u001b\u0005\u0001\u0001\"\u0002 \u0005\u0001\u0004Y\u0012\u0001B3mK6\fQ\u0002\n9mkN$\u0003\u000f\\;tI\u0015\fHC\u0001\u001fB\u0011\u0015\u0011U\u00011\u0001D\u0003\tA8\u000fE\u0002E\u000bni\u0011\u0001E\u0005\u0003\rB\u0011q\u0002\u0016:bm\u0016\u00148/\u00192mK>s7-Z\u0001\bK:\fX/Z;f)\tIE\n\u0005\u0002\"\u0015&\u00111J\u0005\u0002\u0005+:LG\u000fC\u0003N\r\u0001\u0007a*A\u0003fY\u0016l7\u000fE\u0002\"\u001fnI!\u0001\u0015\n\u0003\u0015q\u0012X\r]3bi\u0016$g(A\u0004eKF,X-^3\u0015\u0003m\tA\u0001[3bIV\t1$A\u0003dY\u0016\f'\u000fF\u0001J\u0003!IG/\u001a:bi>\u0014X#A-\u0011\u0007\u0011S6$\u0003\u0002\\!\tA\u0011\n^3sCR|'/\u0001\u0004fcV\fGn\u001d\u000b\u0003oyCQaX\u0006A\u0002\u0011\nA\u0001\u001e5bi\u0006AAo\\*ue&tw\rF\u0001c!\t\u0019'N\u0004\u0002eQB\u0011QME\u0007\u0002M*\u0011q\rF\u0001\u0007yI|w\u000e\u001e \n\u0005%\u0014\u0012A\u0002)sK\u0012,g-\u0003\u0002lY\n11\u000b\u001e:j]\u001eT!!\u001b\n)\t\u0001q\u0017o\u001d\t\u0003C=L!\u0001\u001d\n\u0003\u0015\u0011,\u0007O]3dCR,G-I\u0001s\u0003\u0005\u00153i\\7qe\u0016DWM\\:jm\u0016\u00043/\u001f8dQJ|g.\u001b>bi&|g\u000e\t<jC\u0002\u001aX\r\\3di&4X\rI8wKJ\u0014\u0018\u000eZ5oO\u0002zg\rI7fi\"|Gm\u001d\u0011jg\u0002Jg\u000e[3sK:$H.\u001f\u0011v]J,G.[1cY\u0016t\u0003eQ8og&$WM\u001d\u0011kCZ\fg&\u001e;jY:\u001awN\\2veJ,g\u000e\u001e\u0018D_:\u001cWO\u001d:f]R\u001c6.\u001b9MSN$8+\u001a;!CN\u0004\u0013M\u001c\u0011bYR,'O\\1uSZ,g&I\u0001u\u0003\u0019\u0011d&M\u0019/a\u0001")
public class SynchronizedPriorityQueue<A>
extends PriorityQueue<A> {
    @Override
    public synchronized boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public SynchronizedPriorityQueue<A> $plus$eq(A elem) {
        synchronized (this) {
            SynchronizedPriorityQueue cfr_ignored_0 = (SynchronizedPriorityQueue)super.$plus$eq((Object)elem);
        }
        return this;
    }

    @Override
    public SynchronizedPriorityQueue<A> $plus$plus$eq(TraversableOnce<A> xs) {
        synchronized (this) {
            SynchronizedPriorityQueue cfr_ignored_0 = (SynchronizedPriorityQueue)super.$plus$plus$eq((TraversableOnce)xs);
        }
        return this;
    }

    @Override
    public void enqueue(Seq<A> elems) {
        synchronized (this) {
            SynchronizedPriorityQueue cfr_ignored_0 = (SynchronizedPriorityQueue)super.$plus$plus$eq((TraversableOnce)elems);
            return;
        }
    }

    @Override
    public synchronized A dequeue() {
        return super.dequeue();
    }

    @Override
    public synchronized A head() {
        return super.head();
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
    public synchronized boolean equals(Object that) {
        return super.equals(that);
    }

    @Override
    public synchronized String toString() {
        return super.toString();
    }

    public SynchronizedPriorityQueue(Ordering<A> ord) {
        super(ord);
    }
}

