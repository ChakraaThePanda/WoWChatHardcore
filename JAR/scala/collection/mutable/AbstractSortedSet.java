/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.collection.GenSet;
import scala.collection.GenSetLike;
import scala.collection.Iterator;
import scala.collection.SortedSet;
import scala.collection.SortedSetLike;
import scala.collection.generic.Sorted;
import scala.collection.mutable.AbstractSet;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\t2QAA\u0002\u0002\u0002)AQa\b\u0001\u0005\u0002\u0001\u0012\u0011#\u00112tiJ\f7\r^*peR,GmU3u\u0015\t!Q!A\u0004nkR\f'\r\\3\u000b\u0005\u00199\u0011AC2pY2,7\r^5p]*\t\u0001\"A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u0005-\u00112c\u0001\u0001\r9A\u0019QB\u0004\t\u000e\u0003\rI!aD\u0002\u0003\u0017\u0005\u00137\u000f\u001e:bGR\u001cV\r\u001e\t\u0003#Ia\u0001\u0001B\u0003\u0014\u0001\t\u0007ACA\u0001B#\t)\u0012\u0004\u0005\u0002\u0017/5\tq!\u0003\u0002\u0019\u000f\t9aj\u001c;iS:<\u0007C\u0001\f\u001b\u0013\tYrAA\u0002B]f\u00042!D\u000f\u0011\u0013\tq2AA\u0005T_J$X\rZ*fi\u00061A(\u001b8jiz\"\u0012!\t\t\u0004\u001b\u0001\u0001\u0002")
public abstract class AbstractSortedSet<A>
extends AbstractSet<A>
implements scala.collection.mutable.SortedSet<A> {
    @Override
    public scala.collection.mutable.SortedSet<A> empty() {
        return scala.collection.mutable.SortedSet.empty$(this);
    }

    @Override
    public /* synthetic */ boolean scala$collection$SortedSetLike$$super$subsetOf(GenSet that) {
        return GenSetLike.subsetOf$(this, that);
    }

    @Override
    public SortedSet keySet() {
        return SortedSetLike.keySet$(this);
    }

    @Override
    public A firstKey() {
        return (A)SortedSetLike.firstKey$(this);
    }

    @Override
    public A lastKey() {
        return (A)SortedSetLike.lastKey$(this);
    }

    @Override
    public SortedSet from(Object from) {
        return SortedSetLike.from$(this, from);
    }

    @Override
    public SortedSet until(Object until) {
        return SortedSetLike.until$(this, until);
    }

    @Override
    public SortedSet range(Object from, Object until) {
        return SortedSetLike.range$(this, from, until);
    }

    @Override
    public boolean subsetOf(GenSet<A> that) {
        return SortedSetLike.subsetOf$(this, that);
    }

    @Override
    public Iterator<A> iteratorFrom(A start) {
        return SortedSetLike.iteratorFrom$(this, start);
    }

    @Override
    public int compare(A k0, A k1) {
        return Sorted.compare$(this, k0, k1);
    }

    @Override
    public Sorted to(Object to) {
        return Sorted.to$(this, to);
    }

    @Override
    public boolean hasAll(Iterator<A> j) {
        return Sorted.hasAll$(this, j);
    }

    public AbstractSortedSet() {
        Sorted.$init$(this);
        SortedSetLike.$init$(this);
        SortedSet.$init$(this);
        scala.collection.mutable.SortedSet.$init$(this);
    }
}

