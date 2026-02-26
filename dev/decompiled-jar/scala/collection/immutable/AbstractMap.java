/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.Function1;
import scala.Function2;
import scala.Predef$;
import scala.Tuple2;
import scala.collection.GenTraversableOnce;
import scala.collection.Seq;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.immutable.Iterable;
import scala.collection.immutable.Map;
import scala.collection.immutable.MapLike;
import scala.collection.immutable.Set;
import scala.collection.immutable.Traversable;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.immutable.ParMap;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u00152QAA\u0002\u0002\u0002)AQA\t\u0001\u0005\u0002\r\u00121\"\u00112tiJ\f7\r^'ba*\u0011A!B\u0001\nS6lW\u000f^1cY\u0016T!AB\u0004\u0002\u0015\r|G\u000e\\3di&|gNC\u0001\t\u0003\u0015\u00198-\u00197b\u0007\u0001)2aC\t\u001d'\r\u0001AB\b\t\u0005\u001b9y1$D\u0001\u0006\u0013\t\u0011Q\u0001\u0005\u0002\u0011#1\u0001A!\u0002\n\u0001\u0005\u0004\u0019\"!A&\u0012\u0005QA\u0002CA\u000b\u0017\u001b\u00059\u0011BA\f\b\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"!F\r\n\u0005i9!aA!osB\u0011\u0001\u0003\b\u0003\u0007;\u0001!)\u0019A\n\u0003\u0003Y\u0003Ba\b\u0011\u001075\t1!\u0003\u0002\"\u0007\t\u0019Q*\u00199\u0002\rqJg.\u001b;?)\u0005!\u0003\u0003B\u0010\u0001\u001fm\u0001")
public abstract class AbstractMap<K, V>
extends scala.collection.AbstractMap<K, V>
implements Map<K, V> {
    @Override
    public Map<K, V> empty() {
        return Map.empty$(this);
    }

    @Override
    public <T, U> Map<T, U> toMap(Predef$.less.colon.less<Tuple2<K, V>, Tuple2<T, U>> ev) {
        return Map.toMap$(this, ev);
    }

    @Override
    public Map<K, V> seq() {
        return Map.seq$(this);
    }

    @Override
    public <V1> Map<K, V1> withDefault(Function1<K, V1> d) {
        return Map.withDefault$(this, d);
    }

    @Override
    public <V1> Map<K, V1> withDefaultValue(V1 d) {
        return Map.withDefaultValue$(this, d);
    }

    @Override
    public Combiner<Tuple2<K, V>, ParMap<K, V>> parCombiner() {
        return MapLike.parCombiner$(this);
    }

    @Override
    public <V1> Map<K, V1> updated(K key, V1 value) {
        return MapLike.updated$(this, key, value);
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
    public Map<K, V> filterKeys(Function1<K, Object> p) {
        return MapLike.filterKeys$(this, p);
    }

    @Override
    public <W> Map<K, W> mapValues(Function1<V, W> f) {
        return MapLike.mapValues$(this, f);
    }

    @Override
    public Set<K> keySet() {
        return MapLike.keySet$(this);
    }

    @Override
    public <W, That> That transform(Function2<K, V, W> f, CanBuildFrom<Map<K, V>, Tuple2<K, W>, That> bf) {
        return (That)MapLike.transform$(this, f, bf);
    }

    @Override
    public GenericCompanion<Iterable> companion() {
        return Iterable.companion$(this);
    }

    public AbstractMap() {
        Traversable.$init$(this);
        Iterable.$init$(this);
        MapLike.$init$(this);
        Map.$init$(this);
    }
}

