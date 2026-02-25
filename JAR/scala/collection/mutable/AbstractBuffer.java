/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.collection.GenTraversableOnce;
import scala.collection.Seq;
import scala.collection.TraversableOnce;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.Growable;
import scala.collection.generic.Shrinkable;
import scala.collection.generic.Subtractable;
import scala.collection.mutable.AbstractSeq;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.BufferLike;
import scala.collection.script.Message;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\t2QAA\u0002\u0002\u0002)AQa\b\u0001\u0005\u0002\u0001\u0012a\"\u00112tiJ\f7\r\u001e\"vM\u001a,'O\u0003\u0002\u0005\u000b\u00059Q.\u001e;bE2,'B\u0001\u0004\b\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002\u0011\u0005)1oY1mC\u000e\u0001QCA\u0006\u0013'\r\u0001A\u0002\b\t\u0004\u001b9\u0001R\"A\u0002\n\u0005=\u0019!aC!cgR\u0014\u0018m\u0019;TKF\u0004\"!\u0005\n\r\u0001\u0011)1\u0003\u0001b\u0001)\t\t\u0011)\u0005\u0002\u00163A\u0011acF\u0007\u0002\u000f%\u0011\u0001d\u0002\u0002\b\u001d>$\b.\u001b8h!\t1\"$\u0003\u0002\u001c\u000f\t\u0019\u0011I\\=\u0011\u00075i\u0002#\u0003\u0002\u001f\u0007\t1!)\u001e4gKJ\fa\u0001P5oSRtD#A\u0011\u0011\u00075\u0001\u0001\u0003")
public abstract class AbstractBuffer<A>
extends AbstractSeq<A>
implements Buffer<A> {
    @Override
    public GenericCompanion<Buffer> companion() {
        return Buffer.companion$(this);
    }

    @Override
    public void remove(int n, int count) {
        BufferLike.remove$(this, n, count);
    }

    @Override
    public Buffer $minus$eq(Object x) {
        return BufferLike.$minus$eq$(this, x);
    }

    @Override
    public Buffer $plus$plus$eq$colon(TraversableOnce xs) {
        return BufferLike.$plus$plus$eq$colon$(this, xs);
    }

    @Override
    public void append(Seq<A> elems) {
        BufferLike.append$(this, elems);
    }

    @Override
    public void appendAll(TraversableOnce<A> xs) {
        BufferLike.appendAll$(this, xs);
    }

    @Override
    public void prepend(Seq<A> elems) {
        BufferLike.prepend$(this, elems);
    }

    @Override
    public void prependAll(TraversableOnce<A> xs) {
        BufferLike.prependAll$(this, xs);
    }

    @Override
    public void insert(int n, Seq<A> elems) {
        BufferLike.insert$(this, n, elems);
    }

    @Override
    public void trimStart(int n) {
        BufferLike.trimStart$(this, n);
    }

    @Override
    public void trimEnd(int n) {
        BufferLike.trimEnd$(this, n);
    }

    @Override
    public void $less$less(Message<A> cmd) {
        BufferLike.$less$less$(this, cmd);
    }

    @Override
    public String stringPrefix() {
        return BufferLike.stringPrefix$(this);
    }

    @Override
    public Buffer<A> $plus$plus(GenTraversableOnce<A> xs) {
        return BufferLike.$plus$plus$(this, xs);
    }

    @Override
    public Buffer<A> $minus(A elem) {
        return BufferLike.$minus$(this, elem);
    }

    @Override
    public Buffer<A> $minus(A elem1, A elem2, Seq<A> elems) {
        return BufferLike.$minus$(this, elem1, elem2, elems);
    }

    @Override
    public Buffer<A> $minus$minus(GenTraversableOnce<A> xs) {
        return BufferLike.$minus$minus$(this, xs);
    }

    @Override
    public Buffer<A> clone() {
        return BufferLike.clone$(this);
    }

    @Override
    public Shrinkable<A> $minus$eq(A elem1, A elem2, Seq<A> elems) {
        return Shrinkable.$minus$eq$(this, elem1, elem2, elems);
    }

    @Override
    public Shrinkable<A> $minus$minus$eq(TraversableOnce<A> xs) {
        return Shrinkable.$minus$minus$eq$(this, xs);
    }

    @Override
    public Growable<A> $plus$eq(A elem1, A elem2, Seq<A> elems) {
        return Growable.$plus$eq$(this, elem1, elem2, elems);
    }

    @Override
    public Growable<A> $plus$plus$eq(TraversableOnce<A> xs) {
        return Growable.$plus$plus$eq$(this, xs);
    }

    public AbstractBuffer() {
        Growable.$init$(this);
        Shrinkable.$init$(this);
        Subtractable.$init$(this);
        BufferLike.$init$(this);
        Buffer.$init$(this);
    }
}

