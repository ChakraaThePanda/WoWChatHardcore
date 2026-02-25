/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function1;
import scala.Tuple2;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.SortedMapLike;
import scala.collection.SortedSet;
import scala.collection.generic.Sorted;
import scala.collection.mutable.AbstractMap;
import scala.collection.mutable.Builder;
import scala.collection.mutable.SortedMap;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u00152QAA\u0002\u0002\u0002)AQA\t\u0001\u0005\u0002\r\u0012\u0011#\u00112tiJ\f7\r^*peR,G-T1q\u0015\t!Q!A\u0004nkR\f'\r\\3\u000b\u0005\u00199\u0011AC2pY2,7\r^5p]*\t\u0001\"A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u0007-\u0011RdE\u0002\u0001\u0019}\u0001B!\u0004\b\u001195\t1!\u0003\u0002\u0010\u0007\tY\u0011IY:ue\u0006\u001cG/T1q!\t\t\"\u0003\u0004\u0001\u0005\u000bM\u0001!\u0019\u0001\u000b\u0003\u0003\u0005\u000b\"!F\r\u0011\u0005Y9R\"A\u0004\n\u0005a9!a\u0002(pi\"Lgn\u001a\t\u0003-iI!aG\u0004\u0003\u0007\u0005s\u0017\u0010\u0005\u0002\u0012;\u0011)a\u0004\u0001b\u0001)\t\t!\t\u0005\u0003\u000eAAa\u0012BA\u0011\u0004\u0005%\u0019vN\u001d;fI6\u000b\u0007/\u0001\u0004=S:LGO\u0010\u000b\u0002IA!Q\u0002\u0001\t\u001d\u0001")
public abstract class AbstractSortedMap<A, B>
extends AbstractMap<A, B>
implements SortedMap<A, B> {
    @Override
    public Builder<Tuple2<A, B>, SortedMap<A, B>> newBuilder() {
        return SortedMap.newBuilder$(this);
    }

    @Override
    public SortedMap<A, B> empty() {
        return SortedMap.empty$(this);
    }

    @Override
    public <B1> SortedMap<A, B1> updated(A key, B1 value) {
        return SortedMap.updated$(this, key, value);
    }

    @Override
    public <B1> SortedMap<A, B1> $plus(Tuple2<A, B1> kv) {
        return SortedMap.$plus$(this, kv);
    }

    @Override
    public <B1> SortedMap<A, B1> $plus(Tuple2<A, B1> elem1, Tuple2<A, B1> elem2, Seq<Tuple2<A, B1>> elems) {
        return SortedMap.$plus$(this, elem1, elem2, elems);
    }

    @Override
    public <B1> SortedMap<A, B1> $plus$plus(GenTraversableOnce<Tuple2<A, B1>> xs) {
        return SortedMap.$plus$plus$(this, xs);
    }

    @Override
    public A firstKey() {
        return (A)SortedMapLike.firstKey$(this);
    }

    @Override
    public A lastKey() {
        return (A)SortedMapLike.lastKey$(this);
    }

    @Override
    public SortedSet<A> keySet() {
        return SortedMapLike.keySet$(this);
    }

    @Override
    public scala.collection.SortedMap<A, B> filterKeys(Function1<A, Object> p) {
        return SortedMapLike.filterKeys$(this, p);
    }

    @Override
    public <C> scala.collection.SortedMap<A, C> mapValues(Function1<B, C> f) {
        return SortedMapLike.mapValues$(this, f);
    }

    @Override
    public int compare(A k0, A k1) {
        return Sorted.compare$(this, k0, k1);
    }

    @Override
    public Sorted from(Object from) {
        return Sorted.from$(this, from);
    }

    @Override
    public Sorted until(Object until) {
        return Sorted.until$(this, until);
    }

    @Override
    public Sorted range(Object from, Object until) {
        return Sorted.range$(this, from, until);
    }

    @Override
    public Sorted to(Object to) {
        return Sorted.to$(this, to);
    }

    @Override
    public boolean hasAll(Iterator<A> j) {
        return Sorted.hasAll$(this, j);
    }

    public AbstractSortedMap() {
        Sorted.$init$(this);
        SortedMapLike.$init$(this);
        scala.collection.SortedMap.$init$(this);
        SortedMap.$init$(this);
    }
}

