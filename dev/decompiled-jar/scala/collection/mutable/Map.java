/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.GenTraversableOnce;
import scala.collection.Map;
import scala.collection.Seq;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.Growable;
import scala.collection.generic.Shrinkable;
import scala.collection.mutable.Builder;
import scala.collection.mutable.Cloneable;
import scala.collection.mutable.Iterable;
import scala.collection.mutable.Map$;
import scala.collection.mutable.MapLike;
import scala.collection.mutable.Traversable;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.mutable.ParMap;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005eda\u0002\r\u001a!\u0003\r\t\u0001\t\u0005\u0006\u0005\u0002!\ta\u0011\u0005\u0006\u000f\u0002!\t\u0005\u0013\u0005\u0006\u0013\u0002!\t\u0005\u0013\u0005\u0006\u0015\u0002!\ta\u0013\u0005\u0006#\u0002!\tAU\u0004\u0006)fA\t!\u0016\u0004\u00061eA\tA\u0016\u0005\u0006=\u001e!\ta\u0018\u0005\u0006A\u001e!\u0019!\u0019\u0005\u0007e\u001e\u0001\u000b\u0011B:\t\u000b\u001d;A\u0011\u0001<\u0007\tu<\u0001A \u0005\u000b\u0003Ga!\u0011!Q\u0001\n\u0005\u0005\u0002\"C'\r\u0005\u0003\u0005\u000b\u0011BA\u0013\u0011\u0019qF\u0002\"\u0001\u0002(!9\u0011q\u0006\u0007\u0005B\u0005E\u0002bBA\u001e\u0019\u0011\u0005\u0011Q\b\u0005\u0007\u000f2!\t%a\u0011\t\u000f\u0005\u0015C\u0002\"\u0011\u0002H!9\u00111\f\u0007\u0005B\u0005u\u0003bBA6\u0019\u0011\u0005\u0013Q\u000e\u0005\u0007\u00152!\t%!\u001d\t\rEcA\u0011IA;\u0005\ri\u0015\r\u001d\u0006\u00035m\tq!\\;uC\ndWM\u0003\u0002\u001d;\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003y\tQa]2bY\u0006\u001c\u0001!F\u0002\"_e\u001aR\u0001\u0001\u0012'wy\u0002\"a\t\u0013\u000e\u0003uI!!J\u000f\u0003\r\u0005s\u0017PU3g!\r9\u0003FK\u0007\u00023%\u0011\u0011&\u0007\u0002\t\u0013R,'/\u00192mKB!1eK\u00179\u0013\taSD\u0001\u0004UkBdWM\r\t\u0003]=b\u0001\u0001B\u00031\u0001\t\u0007\u0011GA\u0001L#\t\u0011T\u0007\u0005\u0002$g%\u0011A'\b\u0002\b\u001d>$\b.\u001b8h!\t\u0019c'\u0003\u00028;\t\u0019\u0011I\\=\u0011\u00059JD!\u0002\u001e\u0001\u0005\u0004\t$!\u0001,\u0011\tqjT\u0006O\u0007\u00027%\u0011\u0001d\u0007\t\u0006O}j\u0003(Q\u0005\u0003\u0001f\u0011q!T1q\u0019&\\W\r\u0005\u0003(\u00015B\u0014A\u0002\u0013j]&$H\u0005F\u0001E!\t\u0019S)\u0003\u0002G;\t!QK\\5u\u0003\u0015)W\u000e\u001d;z+\u0005\t\u0015aA:fc\u0006Yq/\u001b;i\t\u00164\u0017-\u001e7u)\t\tE\nC\u0003N\t\u0001\u0007a*A\u0001e!\u0011\u0019s*\f\u001d\n\u0005Ak\"!\u0003$v]\u000e$\u0018n\u001c82\u0003A9\u0018\u000e\u001e5EK\u001a\fW\u000f\u001c;WC2,X\r\u0006\u0002B'\")Q*\u0002a\u0001q\u0005\u0019Q*\u00199\u0011\u0005\u001d:1CA\u0004X!\rA6,X\u0007\u00023*\u0011!lG\u0001\bO\u0016tWM]5d\u0013\ta\u0016LA\tNkR\f'\r\\3NCB4\u0015m\u0019;pef\u0004\"a\n\u0001\u0002\rqJg.\u001b;?)\u0005)\u0016\u0001D2b]\n+\u0018\u000e\u001c3Ge>lWc\u00012oaV\t1\rE\u0003YI\u001ad\u0017/\u0003\u0002f3\na1)\u00198Ck&dGM\u0012:p[B\u0011q\r[\u0007\u0002\u000f%\u0011\u0011N\u001b\u0002\u0005\u0007>dG.\u0003\u0002l3\niq)\u001a8NCB4\u0015m\u0019;pef\u0004BaI\u0016n_B\u0011aF\u001c\u0003\u0006a%\u0011\r!\r\t\u0003]A$QAO\u0005C\u0002E\u0002Ba\n\u0001n_\u0006Y!+Z;tC\ndWm\u0011\"G!\u00119GO\r\u001a\n\u0005UT'aD'ba\u000e\u000bgNQ;jY\u00124%o\\7\u0016\u0007]TH0F\u0001y!\u00119\u0003!_>\u0011\u00059RH!\u0002\u0019\f\u0005\u0004\t\u0004C\u0001\u0018}\t\u0015Q4B1\u00012\u0005-9\u0016\u000e\u001e5EK\u001a\fW\u000f\u001c;\u0016\u000b}\fY\"a\b\u0014\u000b1\t\t!!\t\u0011\u0011\u0005\r\u0011QCA\r\u0003;qA!!\u0002\u0002\u00149!\u0011qAA\t\u001d\u0011\tI!a\u0004\u000e\u0005\u0005-!bAA\u0007?\u00051AH]8pizJ\u0011AH\u0005\u00039uI!\u0001V\u000e\n\u0007u\f9B\u0003\u0002U7A\u0019a&a\u0007\u0005\u000bAb!\u0019A\u0019\u0011\u00079\ny\u0002B\u0003;\u0019\t\u0007\u0011\u0007\u0005\u0004(\u0001\u0005e\u0011QD\u0001\u000bk:$WM\u001d7zS:<\u0007CB\u0012P\u00033\ti\u0002\u0006\u0004\u0002*\u0005-\u0012Q\u0006\t\u0007O2\tI\"!\b\t\u000f\u0005\rr\u00021\u0001\u0002\"!1Qj\u0004a\u0001\u0003K\t\u0001\u0002\n9mkN$S-\u001d\u000b\u0005\u0003g\t)$D\u0001\r\u0011\u001d\t9\u0004\u0005a\u0001\u0003s\t!a\u001b<\u0011\r\rZ\u0013\u0011DA\u000f\u0003%!S.\u001b8vg\u0012*\u0017\u000f\u0006\u0003\u00024\u0005}\u0002bBA!#\u0001\u0007\u0011\u0011D\u0001\u0004W\u0016LXCAA\u0015\u0003\u001d)\b\u000fZ1uK\u0012,B!!\u0013\u0002PQ1\u00111JA+\u0003/\u0002ba\u001a\u0007\u0002\u001a\u00055\u0003c\u0001\u0018\u0002P\u00119\u0011\u0011K\nC\u0002\u0005M#A\u0001,2#\r\ti\"\u000e\u0005\b\u0003\u0003\u001a\u0002\u0019AA\r\u0011\u001d\tIf\u0005a\u0001\u0003\u001b\nQA^1mk\u0016\fQ\u0001\n9mkN,B!a\u0018\u0002fQ!\u0011\u0011MA4!\u00199G\"!\u0007\u0002dA\u0019a&!\u001a\u0005\u000f\u0005ECC1\u0001\u0002T!9\u0011q\u0007\u000bA\u0002\u0005%\u0004CB\u0012,\u00033\t\u0019'\u0001\u0004%[&tWo\u001d\u000b\u0005\u0003S\ty\u0007C\u0004\u0002BU\u0001\r!!\u0007\u0015\t\u0005\u0005\u00121\u000f\u0005\u0007\u001bZ\u0001\r!!\n\u0015\t\u0005\u0005\u0012q\u000f\u0005\u0007\u001b^\u0001\r!!\b")
public interface Map<K, V>
extends Iterable<Tuple2<K, V>>,
scala.collection.Map<K, V>,
MapLike<K, V, Map<K, V>> {
    public static <K, V> CanBuildFrom<Map<?, ?>, Tuple2<K, V>, Map<K, V>> canBuildFrom() {
        return Map$.MODULE$.canBuildFrom();
    }

    public static /* synthetic */ Map empty$(Map $this) {
        return $this.empty();
    }

    @Override
    default public Map<K, V> empty() {
        return Map$.MODULE$.empty();
    }

    @Override
    default public Map<K, V> seq() {
        return this;
    }

    public static /* synthetic */ Map withDefault$(Map $this, Function1 d) {
        return $this.withDefault(d);
    }

    default public Map<K, V> withDefault(Function1<K, V> d) {
        return new WithDefault<K, V>(this, d);
    }

    public static /* synthetic */ Map withDefaultValue$(Map $this, Object d) {
        return $this.withDefaultValue(d);
    }

    default public Map<K, V> withDefaultValue(V d) {
        return new WithDefault(this, (Function1<Object, Object> & java.io.Serializable & Serializable)x -> d);
    }

    public static void $init$(Map $this) {
    }

    public static class WithDefault<K, V>
    extends Map.WithDefault<K, V>
    implements Map<K, V> {
        private final Map<K, V> underlying;
        private final Function1<K, V> d;

        @Override
        public Map<K, V> seq() {
            return ((Map)this).seq();
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

        @Override
        public WithDefault<K, V> $plus$eq(Tuple2<K, V> kv) {
            this.underlying.$plus$eq(kv);
            return this;
        }

        public WithDefault<K, V> $minus$eq(K key) {
            this.underlying.$minus$eq(key);
            return this;
        }

        @Override
        public WithDefault<K, V> empty() {
            return new WithDefault<K, V>(this.underlying.empty(), this.d);
        }

        @Override
        public <V1> WithDefault<K, V1> updated(K key, V1 value) {
            return new WithDefault<K, V1>(this.underlying.updated(key, value), this.d);
        }

        @Override
        public <V1> WithDefault<K, V1> $plus(Tuple2<K, V1> kv) {
            return this.updated((Object)kv._1(), (Object)kv._2());
        }

        @Override
        public WithDefault<K, V> $minus(K key) {
            return new WithDefault<K, V>(this.underlying.$minus(key), this.d);
        }

        @Override
        public Map<K, V> withDefault(Function1<K, V> d) {
            return new WithDefault<K, V>(this.underlying, d);
        }

        @Override
        public Map<K, V> withDefaultValue(V d) {
            return new WithDefault<K, V>(this.underlying, (Function1<Object, Object> & java.io.Serializable & Serializable)x -> d);
        }

        public WithDefault(Map<K, V> underlying, Function1<K, V> d) {
            this.underlying = underlying;
            this.d = d;
            super(underlying, d);
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
}

