/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.Tuple2;
import scala.collection.GenTraversableOnce;
import scala.collection.Seq;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.Growable;
import scala.collection.generic.Shrinkable;
import scala.collection.mutable.Builder;
import scala.collection.mutable.Cloneable;
import scala.collection.mutable.Iterable;
import scala.collection.mutable.Map;
import scala.collection.mutable.MapLike;
import scala.collection.mutable.Traversable;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.mutable.ParMap;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u00152QAA\u0002\u0002\u0002)AQA\t\u0001\u0005\u0002\r\u00121\"\u00112tiJ\f7\r^'ba*\u0011A!B\u0001\b[V$\u0018M\u00197f\u0015\t1q!\u0001\u0006d_2dWm\u0019;j_:T\u0011\u0001C\u0001\u0006g\u000e\fG.Y\u0002\u0001+\rY\u0011\u0003H\n\u0004\u00011q\u0002\u0003B\u0007\u000f\u001fmi\u0011!B\u0005\u0003\u0005\u0015\u0001\"\u0001E\t\r\u0001\u0011)!\u0003\u0001b\u0001'\t\t1*\u0005\u0002\u00151A\u0011QCF\u0007\u0002\u000f%\u0011qc\u0002\u0002\b\u001d>$\b.\u001b8h!\t)\u0012$\u0003\u0002\u001b\u000f\t\u0019\u0011I\\=\u0011\u0005AaB!B\u000f\u0001\u0005\u0004\u0019\"!\u0001,\u0011\t}\u0001sbG\u0007\u0002\u0007%\u0011\u0011e\u0001\u0002\u0004\u001b\u0006\u0004\u0018A\u0002\u001fj]&$h\bF\u0001%!\u0011y\u0002aD\u000e")
public abstract class AbstractMap<K, V>
extends scala.collection.AbstractMap<K, V>
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
    public Map<K, V> withDefault(Function1<K, V> d) {
        return Map.withDefault$(this, d);
    }

    @Override
    public Map<K, V> withDefaultValue(V d) {
        return Map.withDefaultValue$(this, d);
    }

    @Override
    public Builder<Tuple2<K, V>, Map<K, V>> newBuilder() {
        return MapLike.newBuilder$(this);
    }

    @Override
    public Combiner<Tuple2<K, V>, ParMap<K, V>> parCombiner() {
        return MapLike.parCombiner$(this);
    }

    @Override
    public Seq<Tuple2<K, V>> toSeq() {
        return MapLike.toSeq$(this);
    }

    @Override
    public Option<V> put(K key, V value) {
        return MapLike.put$(this, key, value);
    }

    @Override
    public void update(K key, V value) {
        MapLike.update$(this, key, value);
    }

    @Override
    public <V1> Map<K, V1> updated(K key, V1 value) {
        return MapLike.updated$(this, key, value);
    }

    @Override
    public <V1> Map<K, V1> $plus(Tuple2<K, V1> kv) {
        return MapLike.$plus$(this, kv);
    }

    @Override
    public <V1> Map<K, V1> $plus(Tuple2<K, V1> elem1, Tuple2<K, V1> elem2, Seq<Tuple2<K, V1>> elems) {
        return MapLike.$plus$(this, elem1, elem2, elems);
    }

    @Override
    public <V1> Map<K, V1> $plus$plus(GenTraversableOnce<Tuple2<K, V1>> xs) {
        return MapLike.$plus$plus$(this, xs);
    }

    @Override
    public Option<V> remove(K key) {
        return MapLike.remove$(this, key);
    }

    @Override
    public Map<K, V> $minus(K key) {
        return MapLike.$minus$(this, key);
    }

    @Override
    public void clear() {
        MapLike.clear$(this);
    }

    @Override
    public V getOrElseUpdate(K key, Function0<V> op) {
        return (V)MapLike.getOrElseUpdate$(this, key, op);
    }

    @Override
    public MapLike<K, V, Map<K, V>> transform(Function2<K, V, V> f) {
        return MapLike.transform$(this, f);
    }

    @Override
    public MapLike<K, V, Map<K, V>> retain(Function2<K, V, Object> p) {
        return MapLike.retain$(this, p);
    }

    @Override
    public Map<K, V> clone() {
        return MapLike.clone$(this);
    }

    @Override
    public Map<K, V> result() {
        return MapLike.result$(this);
    }

    @Override
    public Map<K, V> $minus(K elem1, K elem2, Seq<K> elems) {
        return MapLike.$minus$(this, elem1, elem2, elems);
    }

    @Override
    public Map<K, V> $minus$minus(GenTraversableOnce<K> xs) {
        return MapLike.$minus$minus$(this, xs);
    }

    @Override
    public /* synthetic */ Object scala$collection$mutable$Cloneable$$super$clone() {
        return super.clone();
    }

    @Override
    public Shrinkable<K> $minus$eq(K elem1, K elem2, Seq<K> elems) {
        return Shrinkable.$minus$eq$(this, elem1, elem2, elems);
    }

    @Override
    public Shrinkable<K> $minus$minus$eq(TraversableOnce<K> xs) {
        return Shrinkable.$minus$minus$eq$(this, xs);
    }

    @Override
    public void sizeHint(int size) {
        Builder.sizeHint$((Builder)this, size);
    }

    @Override
    public void sizeHint(TraversableLike<?, ?> coll) {
        Builder.sizeHint$((Builder)this, coll);
    }

    @Override
    public void sizeHint(TraversableLike<?, ?> coll, int delta) {
        Builder.sizeHint$(this, coll, delta);
    }

    @Override
    public void sizeHintBounded(int size, TraversableLike<?, ?> boundingColl) {
        Builder.sizeHintBounded$(this, size, boundingColl);
    }

    @Override
    public <NewTo> Builder<Tuple2<K, V>, NewTo> mapResult(Function1<Map<K, V>, NewTo> f) {
        return Builder.mapResult$(this, f);
    }

    @Override
    public Growable $plus$eq(Object elem1, Object elem2, Seq elems) {
        return Growable.$plus$eq$(this, elem1, elem2, elems);
    }

    @Override
    public Growable<Tuple2<K, V>> $plus$plus$eq(TraversableOnce<Tuple2<K, V>> xs) {
        return Growable.$plus$plus$eq$(this, xs);
    }

    @Override
    public GenericCompanion<Iterable> companion() {
        return Iterable.companion$(this);
    }

    public AbstractMap() {
        Traversable.$init$(this);
        Iterable.$init$(this);
        Growable.$init$(this);
        Builder.$init$(this);
        Shrinkable.$init$(this);
        Cloneable.$init$(this);
        MapLike.$init$(this);
        Map.$init$(this);
    }
}

