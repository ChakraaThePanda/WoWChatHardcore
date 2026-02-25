/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Function0;
import scala.Function1;
import scala.Option;
import scala.PartialFunction;
import scala.Tuple2;
import scala.collection.AbstractIterable;
import scala.collection.GenMapLike;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.Map;
import scala.collection.MapLike;
import scala.collection.Seq;
import scala.collection.Set;
import scala.collection.generic.Subtractable;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.ParMap;
import scala.reflect.ScalaSignature;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@ScalaSignature(bytes="\u0006\u0001\u00192QAA\u0002\u0002\u0002!AQa\t\u0001\u0005\u0002\u0011\u00121\"\u00112tiJ\f7\r^'ba*\u0011A!B\u0001\u000bG>dG.Z2uS>t'\"\u0001\u0004\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0019\u0011\u0002\u0006\u0010\u0014\u0007\u0001Q\u0001\u0005E\u0002\f\u00199i\u0011aA\u0005\u0003\u001b\r\u0011\u0001#\u00112tiJ\f7\r^%uKJ\f'\r\\3\u0011\t=\u0001\"#H\u0007\u0002\u000b%\u0011\u0011#\u0002\u0002\u0007)V\u0004H.\u001a\u001a\u0011\u0005M!B\u0002\u0001\u0003\u0006+\u0001\u0011\rA\u0006\u0002\u0002\u0017F\u0011qC\u0007\t\u0003\u001faI!!G\u0003\u0003\u000f9{G\u000f[5oOB\u0011qbG\u0005\u00039\u0015\u00111!\u00118z!\t\u0019b\u0004\u0002\u0004 \u0001\u0011\u0015\rA\u0006\u0002\u0002-B!1\"\t\n\u001e\u0013\t\u00113AA\u0002NCB\fa\u0001P5oSRtD#A\u0013\u0011\t-\u0001!#\b")
public abstract class AbstractMap<K, V>
extends AbstractIterable<Tuple2<K, V>>
implements Map<K, V> {
    @Override
    public Map<K, V> empty() {
        return Map.empty$(this);
    }

    @Override
    public Map<K, V> seq() {
        return Map.seq$(this);
    }

    @Override
    public Builder<Tuple2<K, V>, Map<K, V>> newBuilder() {
        return MapLike.newBuilder$(this);
    }

    @Override
    public boolean isEmpty() {
        return MapLike.isEmpty$(this);
    }

    @Override
    public <V1> V1 getOrElse(K key, Function0<V1> function0) {
        return (V1)MapLike.getOrElse$(this, key, function0);
    }

    @Override
    public V apply(K key) {
        return (V)MapLike.apply$(this, key);
    }

    @Override
    public boolean contains(K key) {
        return MapLike.contains$(this, key);
    }

    @Override
    public boolean isDefinedAt(K key) {
        return MapLike.isDefinedAt$(this, key);
    }

    @Override
    public <K1 extends K, V1> V1 applyOrElse(K1 x, Function1<K1, V1> function1) {
        return (V1)MapLike.applyOrElse$(this, x, function1);
    }

    @Override
    public Set<K> keySet() {
        return MapLike.keySet$(this);
    }

    @Override
    public Iterator<K> keysIterator() {
        return MapLike.keysIterator$(this);
    }

    @Override
    public Iterable<K> keys() {
        return MapLike.keys$(this);
    }

    @Override
    public Iterable<V> values() {
        return MapLike.values$(this);
    }

    @Override
    public Iterator<V> valuesIterator() {
        return MapLike.valuesIterator$(this);
    }

    @Override
    public V default(K key) {
        return (V)MapLike.default$(this, key);
    }

    @Override
    public Map<K, V> filterKeys(Function1<K, Object> p) {
        return MapLike.filterKeys$(this, p);
    }

    @Override
    public <W> Map<K, W> mapValues(Function1<V, W> f) {
        return MapLike.mapValues$(this, f);
    }

    @Override
    public <V1> Map<K, V1> updated(K key, V1 value) {
        return MapLike.updated$(this, key, value);
    }

    @Override
    public <V1> Map<K, V1> $plus(Tuple2<K, V1> kv1, Tuple2<K, V1> kv2, Seq<Tuple2<K, V1>> kvs) {
        return MapLike.$plus$(this, kv1, kv2, kvs);
    }

    @Override
    public <V1> Map<K, V1> $plus$plus(GenTraversableOnce<Tuple2<K, V1>> xs) {
        return MapLike.$plus$plus$(this, xs);
    }

    @Override
    public Map<K, V> filterNot(Function1<Tuple2<K, V>, Object> p) {
        return MapLike.filterNot$(this, p);
    }

    @Override
    public Seq<Tuple2<K, V>> toSeq() {
        return MapLike.toSeq$(this);
    }

    @Override
    public <E> Buffer<E> toBuffer() {
        return MapLike.toBuffer$(this);
    }

    @Override
    public Combiner<Tuple2<K, V>, ParMap<K, V>> parCombiner() {
        return MapLike.parCombiner$(this);
    }

    @Override
    public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
        return MapLike.addString$(this, b, start, sep, end);
    }

    @Override
    public String stringPrefix() {
        return MapLike.stringPrefix$(this);
    }

    @Override
    public String toString() {
        return MapLike.toString$(this);
    }

    @Override
    public Subtractable $minus(Object elem1, Object elem2, Seq elems) {
        return Subtractable.$minus$(this, elem1, elem2, elems);
    }

    @Override
    public Subtractable $minus$minus(GenTraversableOnce xs) {
        return Subtractable.$minus$minus$(this, xs);
    }

    @Override
    public <A1 extends K, B1> PartialFunction<A1, B1> orElse(PartialFunction<A1, B1> that) {
        return PartialFunction.orElse$(this, that);
    }

    @Override
    public <C> PartialFunction<K, C> andThen(Function1<V, C> k) {
        return PartialFunction.andThen$(this, k);
    }

    @Override
    public Function1<K, Option<V>> lift() {
        return PartialFunction.lift$(this);
    }

    @Override
    public <U> Function1<K, Object> runWith(Function1<V, U> action) {
        return PartialFunction.runWith$(this, action);
    }

    @Override
    public boolean apply$mcZD$sp(double v1) {
        return Function1.apply$mcZD$sp$(this, v1);
    }

    @Override
    public double apply$mcDD$sp(double v1) {
        return Function1.apply$mcDD$sp$(this, v1);
    }

    @Override
    public float apply$mcFD$sp(double v1) {
        return Function1.apply$mcFD$sp$(this, v1);
    }

    @Override
    public int apply$mcID$sp(double v1) {
        return Function1.apply$mcID$sp$(this, v1);
    }

    @Override
    public long apply$mcJD$sp(double v1) {
        return Function1.apply$mcJD$sp$(this, v1);
    }

    @Override
    public void apply$mcVD$sp(double v1) {
        Function1.apply$mcVD$sp$(this, v1);
    }

    @Override
    public boolean apply$mcZF$sp(float v1) {
        return Function1.apply$mcZF$sp$(this, v1);
    }

    @Override
    public double apply$mcDF$sp(float v1) {
        return Function1.apply$mcDF$sp$(this, v1);
    }

    @Override
    public float apply$mcFF$sp(float v1) {
        return Function1.apply$mcFF$sp$(this, v1);
    }

    @Override
    public int apply$mcIF$sp(float v1) {
        return Function1.apply$mcIF$sp$(this, v1);
    }

    @Override
    public long apply$mcJF$sp(float v1) {
        return Function1.apply$mcJF$sp$(this, v1);
    }

    @Override
    public void apply$mcVF$sp(float v1) {
        Function1.apply$mcVF$sp$(this, v1);
    }

    @Override
    public boolean apply$mcZI$sp(int v1) {
        return Function1.apply$mcZI$sp$(this, v1);
    }

    @Override
    public double apply$mcDI$sp(int v1) {
        return Function1.apply$mcDI$sp$(this, v1);
    }

    @Override
    public float apply$mcFI$sp(int v1) {
        return Function1.apply$mcFI$sp$(this, v1);
    }

    @Override
    public int apply$mcII$sp(int v1) {
        return Function1.apply$mcII$sp$(this, v1);
    }

    @Override
    public long apply$mcJI$sp(int v1) {
        return Function1.apply$mcJI$sp$(this, v1);
    }

    @Override
    public void apply$mcVI$sp(int v1) {
        Function1.apply$mcVI$sp$(this, v1);
    }

    @Override
    public boolean apply$mcZJ$sp(long v1) {
        return Function1.apply$mcZJ$sp$(this, v1);
    }

    @Override
    public double apply$mcDJ$sp(long v1) {
        return Function1.apply$mcDJ$sp$(this, v1);
    }

    @Override
    public float apply$mcFJ$sp(long v1) {
        return Function1.apply$mcFJ$sp$(this, v1);
    }

    @Override
    public int apply$mcIJ$sp(long v1) {
        return Function1.apply$mcIJ$sp$(this, v1);
    }

    @Override
    public long apply$mcJJ$sp(long v1) {
        return Function1.apply$mcJJ$sp$(this, v1);
    }

    @Override
    public void apply$mcVJ$sp(long v1) {
        Function1.apply$mcVJ$sp$(this, v1);
    }

    @Override
    public <A> Function1<A, V> compose(Function1<A, K> g) {
        return Function1.compose$(this, g);
    }

    @Override
    public int hashCode() {
        return GenMapLike.hashCode$(this);
    }

    @Override
    public boolean equals(Object that) {
        return GenMapLike.equals$(this, that);
    }

    public AbstractMap() {
        GenMapLike.$init$(this);
        PartialFunction.$init$(this);
        Subtractable.$init$(this);
        MapLike.$init$(this);
        Map.$init$(this);
    }
}

