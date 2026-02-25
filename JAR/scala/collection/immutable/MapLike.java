/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import scala.Function1;
import scala.Function2;
import scala.MatchError;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.GenTraversableOnce;
import scala.collection.MapLike;
import scala.collection.Seq;
import scala.collection.SetLike;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.immutable.DefaultMap;
import scala.collection.immutable.Iterable;
import scala.collection.immutable.Map;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Set;
import scala.collection.immutable.Set$;
import scala.collection.immutable.Traversable;
import scala.collection.mutable.Builder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.immutable.ParMap;
import scala.collection.parallel.immutable.ParMap$;
import scala.collection.parallel.immutable.ParSet;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.LambdaDeserialize;

@ScalaSignature(bytes="\u0006\u0001\u0005Mea\u0002\t\u0012!\u0003\r\t\u0001\u0007\u0005\u0006\u0011\u0002!\t!\u0013\u0005\u0007\u001b\u0002\u0001K\u0011\u000b(\t\u000bM\u0003A\u0011\t+\t\u000b}\u0003a\u0011\u00011\t\u000b}\u0003A\u0011\t5\t\u000b]\u0004A\u0011\t=\t\u000f\u0005\u001d\u0001\u0001\"\u0011\u0002\n!9\u00111\u0004\u0001\u0005B\u0005u\u0001bBA\u0018\u0001\u0011\u0005\u0013\u0011\u0007\u0004\u0007\u0003s\u0001\u0001\"a\u000f\t\u000f\u0005\u0015#\u0002\"\u0001\u0002H!1qL\u0003C!\u0003\u0017Bq!!\u0015\u000b\t\u0003\n\u0019\u0006C\u0004\u0002X)!\t%!\u0017\t\u000f\u0005\u001d\u0004\u0001\"\u0001\u0002j\t9Q*\u00199MS.,'B\u0001\n\u0014\u0003%IW.\\;uC\ndWM\u0003\u0002\u0015+\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003Y\tQa]2bY\u0006\u001c\u0001!\u0006\u0003\u001aG5\u00024\u0003\u0002\u0001\u001b=m\u0002\"a\u0007\u000f\u000e\u0003UI!!H\u000b\u0003\r\u0005s\u0017PU3g!\u0015y\u0002%\t\u00170\u001b\u0005\u0019\u0012B\u0001\t\u0014!\t\u00113\u0005\u0004\u0001\u0005\u000b\u0011\u0002!\u0019A\u0013\u0003\u0003-\u000b\"AJ\u0015\u0011\u0005m9\u0013B\u0001\u0015\u0016\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"a\u0007\u0016\n\u0005-*\"aA!osB\u0011!%\f\u0003\u0007]\u0001!)\u0019A\u0013\u0003\u0003Y\u0003\"A\t\u0019\u0005\rE\u0002AQ1\u00013\u0005\u0011!\u0006.[:\u0012\u0005\u0019\u001a$c\u0001\u001b7q\u0019!Q\u0007\u0001\u00014\u00051a$/\u001a4j]\u0016lWM\u001c;?!\u00159\u0004!\t\u00170\u001b\u0005\t\u0002\u0003B\u001c:C1J!AO\t\u0003\u00075\u000b\u0007\u000f\u0005\u0003 yy\n\u0015BA\u001f\u0014\u00059\u0001\u0016M]1mY\u0016d\u0017N_1cY\u0016\u0004BaG \"Y%\u0011\u0001)\u0006\u0002\u0007)V\u0004H.\u001a\u001a\u0011\t\t3\u0015\u0005L\u0007\u0002\u0007*\u0011!\u0003\u0012\u0006\u0003\u000bN\t\u0001\u0002]1sC2dW\r\\\u0005\u0003\u000f\u000e\u0013a\u0001U1s\u001b\u0006\u0004\u0018A\u0002\u0013j]&$H\u0005F\u0001K!\tY2*\u0003\u0002M+\t!QK\\5u\u0003-\u0001\u0018M]\"p[\nLg.\u001a:\u0016\u0003=\u0003B\u0001U)?\u00036\tA)\u0003\u0002S\t\nA1i\\7cS:,'/A\u0004va\u0012\fG/\u001a3\u0016\u0005UCFc\u0001,\\;B!q'O\u0011X!\t\u0011\u0003\fB\u0003Z\u0007\t\u0007!L\u0001\u0002WcE\u0011A&\u000b\u0005\u00069\u000e\u0001\r!I\u0001\u0004W\u0016L\b\"\u00020\u0004\u0001\u00049\u0016!\u0002<bYV,\u0017!\u0002\u0013qYV\u001cXCA1e)\t\u0011W\r\u0005\u00038s\u0005\u001a\u0007C\u0001\u0012e\t\u0015IFA1\u0001[\u0011\u00151G\u00011\u0001h\u0003\tYg\u000f\u0005\u0003\u001c\u007f\u0005\u001aWCA5m)\u0011QW\u000e\u001d:\u0011\t]J\u0014e\u001b\t\u0003E1$Q!W\u0003C\u0002iCQA\\\u0003A\u0002=\fQ!\u001a7f[F\u0002BaG \"W\")\u0011/\u0002a\u0001_\u0006)Q\r\\3ne!)1/\u0002a\u0001i\u0006)Q\r\\3ngB\u00191$^8\n\u0005Y,\"A\u0003\u001fsKB,\u0017\r^3e}\u0005QA\u0005\u001d7vg\u0012\u0002H.^:\u0016\u0005edHC\u0001>~!\u00119\u0014(I>\u0011\u0005\tbH!B-\u0007\u0005\u0004Q\u0006\"\u0002@\u0007\u0001\u0004y\u0018A\u0001=t!\u0015y\u0012\u0011AA\u0003\u0013\r\t\u0019a\u0005\u0002\u0013\u000f\u0016tGK]1wKJ\u001c\u0018M\u00197f\u001f:\u001cW\r\u0005\u0003\u001c\u007f\u0005Z\u0018A\u00034jYR,'oS3zgR\u0019\u0001(a\u0003\t\u000f\u00055q\u00011\u0001\u0002\u0010\u0005\t\u0001\u000f\u0005\u0004\u001c\u0003#\t\u0013QC\u0005\u0004\u0003')\"!\u0003$v]\u000e$\u0018n\u001c82!\rY\u0012qC\u0005\u0004\u00033)\"a\u0002\"p_2,\u0017M\\\u0001\n[\u0006\u0004h+\u00197vKN,B!a\b\u0002&Q!\u0011\u0011EA\u0015!\u00159\u0014(IA\u0012!\r\u0011\u0013Q\u0005\u0003\u0007\u0003OA!\u0019A\u0013\u0003\u0003]Cq!a\u000b\t\u0001\u0004\ti#A\u0001g!\u0019Y\u0012\u0011\u0003\u0017\u0002$\u000511.Z=TKR,\"!a\r\u0011\t]\n)$I\u0005\u0004\u0003o\t\"aA*fi\n1\u0012*\\7vi\u0006\u0014G.\u001a#fM\u0006,H\u000e^&fsN+GoE\u0003\u000b\u0003{\t\u0019\u0004\u0005\u0003\u0002@\u0005\u0005S\"\u0001\u0001\n\u0007\u0005\r\u0003EA\u0007EK\u001a\fW\u000f\u001c;LKf\u001cV\r^\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0005\u0005%\u0003cAA \u0015Q!\u00111GA'\u0011\u0019\ty\u0005\u0004a\u0001C\u0005!Q\r\\3n\u0003\u0019!S.\u001b8vgR!\u00111GA+\u0011\u0019\ty%\u0004a\u0001C\u0005)Ao\\*fiV!\u00111LA1+\t\ti\u0006E\u00038\u0003k\ty\u0006E\u0002#\u0003C\"q!a\u0019\u000f\u0005\u0004\t)GA\u0001C#\t\t\u0013&A\u0005ue\u0006t7OZ8s[V1\u00111NAE\u0003c\"B!!\u001c\u0002\fR!\u0011qNA;!\r\u0011\u0013\u0011\u000f\u0003\u0007\u0003gz!\u0019A\u0013\u0003\tQC\u0017\r\u001e\u0005\b\u0003oz\u00019AA=\u0003\t\u0011g\rE\u0005\u0002|\u0005\u0005u&!\"\u0002p5\u0011\u0011Q\u0010\u0006\u0004\u0003\u007f\u001a\u0012aB4f]\u0016\u0014\u0018nY\u0005\u0005\u0003\u0007\u000biH\u0001\u0007DC:\u0014U/\u001b7e\rJ|W\u000eE\u0003\u001c\u007f\u0005\n9\tE\u0002#\u0003\u0013#a!a\n\u0010\u0005\u0004)\u0003bBA\u0016\u001f\u0001\u0007\u0011Q\u0012\t\b7\u0005=\u0015\u0005LAD\u0013\r\t\t*\u0006\u0002\n\rVt7\r^5p]J\u0002")
public interface MapLike<K, V, This extends MapLike<K, V, This> & Map<K, V>>
extends scala.collection.MapLike<K, V, This> {
    public static /* synthetic */ Combiner parCombiner$(MapLike $this) {
        return $this.parCombiner();
    }

    @Override
    default public Combiner<Tuple2<K, V>, ParMap<K, V>> parCombiner() {
        return ParMap$.MODULE$.newCombiner();
    }

    public static /* synthetic */ Map updated$(MapLike $this, Object key, Object value) {
        return $this.updated(key, value);
    }

    @Override
    default public <V1> Map<K, V1> updated(K key, V1 value) {
        return this.$plus(new Tuple2<K, V1>(key, value));
    }

    @Override
    public <V1> Map<K, V1> $plus(Tuple2<K, V1> var1);

    public static /* synthetic */ Map $plus$(MapLike $this, Tuple2 elem1, Tuple2 elem2, Seq elems) {
        return $this.$plus(elem1, elem2, elems);
    }

    @Override
    default public <V1> Map<K, V1> $plus(Tuple2<K, V1> elem1, Tuple2<K, V1> elem2, Seq<Tuple2<K, V1>> elems) {
        return this.$plus(elem1).$plus(elem2).$plus$plus(elems);
    }

    public static /* synthetic */ Map $plus$plus$(MapLike $this, GenTraversableOnce xs) {
        return $this.$plus$plus(xs);
    }

    @Override
    default public <V1> Map<K, V1> $plus$plus(GenTraversableOnce<Tuple2<K, V1>> xs) {
        Map map = (Map)this.repr();
        return xs.seq().$div$colon(map, (Function2<Map, Tuple2, Map> & java.io.Serializable & Serializable)(x$2, x$3) -> x$2.$plus(x$3));
    }

    public static /* synthetic */ Map filterKeys$(MapLike $this, Function1 p) {
        return $this.filterKeys(p);
    }

    @Override
    default public Map<K, V> filterKeys(Function1<K, Object> p) {
        return new DefaultMap<K, V>(this, p){

            public <B1> Map<K, B1> $plus(Tuple2<K, B1> kv) {
                return DefaultMap.$plus$(this, kv);
            }

            public Map<K, V> $minus(K key) {
                return DefaultMap.$minus$(this, key);
            }

            public Map<K, V> empty() {
                return Map.empty$(this);
            }

            public <T, U> Map<T, U> toMap(Predef$.less.colon.less<Tuple2<K, V>, Tuple2<T, U>> ev) {
                return Map.toMap$(this, ev);
            }

            public Map<K, V> seq() {
                return Map.seq$(this);
            }

            public <V1> Map<K, V1> withDefault(Function1<K, V1> d) {
                return Map.withDefault$(this, d);
            }

            public <V1> Map<K, V1> withDefaultValue(V1 d) {
                return Map.withDefaultValue$(this, d);
            }

            public Combiner<Tuple2<K, V>, ParMap<K, V>> parCombiner() {
                return MapLike.parCombiner$(this);
            }

            public <V1> Map<K, V1> updated(K key, V1 value) {
                return MapLike.updated$(this, key, value);
            }

            public <V1> Map<K, V1> $plus(Tuple2<K, V1> elem1, Tuple2<K, V1> elem2, Seq<Tuple2<K, V1>> elems) {
                return MapLike.$plus$(this, elem1, elem2, elems);
            }

            public <V1> Map<K, V1> $plus$plus(GenTraversableOnce<Tuple2<K, V1>> xs) {
                return MapLike.$plus$plus$(this, xs);
            }

            public Map<K, V> filterKeys(Function1<K, Object> p) {
                return MapLike.filterKeys$(this, p);
            }

            public <W> Map<K, W> mapValues(Function1<V, W> f) {
                return MapLike.mapValues$(this, f);
            }

            public Set<K> keySet() {
                return MapLike.keySet$(this);
            }

            public <W, That> That transform(Function2<K, V, W> f, CanBuildFrom<Map<K, V>, Tuple2<K, W>, That> bf) {
                return (That)MapLike.transform$(this, f, bf);
            }

            public GenericCompanion<Iterable> companion() {
                return Iterable.companion$(this);
            }
            {
                Traversable.$init$(this);
                Iterable.$init$(this);
                MapLike.$init$(this);
                Map.$init$(this);
                DefaultMap.$init$(this);
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$groupBy$1(scala.collection.TraversableLike scala.Function1 scala.collection.mutable.Map java.lang.Object ), $anonfun$groupBy$3$adapted(scala.Tuple2 ), $anonfun$groupBy$4(scala.collection.mutable.Builder scala.Tuple2 )}, serializedLambda);
            }
        };
    }

    public static /* synthetic */ Map mapValues$(MapLike $this, Function1 f) {
        return $this.mapValues(f);
    }

    @Override
    default public <W> Map<K, W> mapValues(Function1<V, W> f) {
        return new DefaultMap<K, W>(this, f){

            public <B1> Map<K, B1> $plus(Tuple2<K, B1> kv) {
                return DefaultMap.$plus$(this, kv);
            }

            public Map<K, W> $minus(K key) {
                return DefaultMap.$minus$(this, key);
            }

            public Map<K, W> empty() {
                return Map.empty$(this);
            }

            public <T, U> Map<T, U> toMap(Predef$.less.colon.less<Tuple2<K, W>, Tuple2<T, U>> ev) {
                return Map.toMap$(this, ev);
            }

            public Map<K, W> seq() {
                return Map.seq$(this);
            }

            public <V1> Map<K, V1> withDefault(Function1<K, V1> d) {
                return Map.withDefault$(this, d);
            }

            public <V1> Map<K, V1> withDefaultValue(V1 d) {
                return Map.withDefaultValue$(this, d);
            }

            public Combiner<Tuple2<K, W>, ParMap<K, W>> parCombiner() {
                return MapLike.parCombiner$(this);
            }

            public <V1> Map<K, V1> updated(K key, V1 value) {
                return MapLike.updated$(this, key, value);
            }

            public <V1> Map<K, V1> $plus(Tuple2<K, V1> elem1, Tuple2<K, V1> elem2, Seq<Tuple2<K, V1>> elems) {
                return MapLike.$plus$(this, elem1, elem2, elems);
            }

            public <V1> Map<K, V1> $plus$plus(GenTraversableOnce<Tuple2<K, V1>> xs) {
                return MapLike.$plus$plus$(this, xs);
            }

            public Map<K, W> filterKeys(Function1<K, Object> p) {
                return MapLike.filterKeys$(this, p);
            }

            public <W> Map<K, W> mapValues(Function1<W, W> f) {
                return MapLike.mapValues$(this, f);
            }

            public Set<K> keySet() {
                return MapLike.keySet$(this);
            }

            public <W, That> That transform(Function2<K, W, W> f, CanBuildFrom<Map<K, W>, Tuple2<K, W>, That> bf) {
                return (That)MapLike.transform$(this, f, bf);
            }

            public GenericCompanion<Iterable> companion() {
                return Iterable.companion$(this);
            }
            {
                Traversable.$init$(this);
                Iterable.$init$(this);
                MapLike.$init$(this);
                Map.$init$(this);
                DefaultMap.$init$(this);
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$groupBy$1(scala.collection.TraversableLike scala.Function1 scala.collection.mutable.Map java.lang.Object ), $anonfun$groupBy$3$adapted(scala.Tuple2 ), $anonfun$groupBy$4(scala.collection.mutable.Builder scala.Tuple2 )}, serializedLambda);
            }
        };
    }

    public static /* synthetic */ Set keySet$(MapLike $this) {
        return $this.keySet();
    }

    @Override
    default public Set<K> keySet() {
        return new ImmutableDefaultKeySet(this);
    }

    public static /* synthetic */ Object transform$(MapLike $this, Function2 f, CanBuildFrom bf) {
        return $this.transform(f, bf);
    }

    default public <W, That> That transform(Function2<K, V, W> f, CanBuildFrom<This, Tuple2<K, W>, That> bf) {
        Builder b = bf.apply(this.repr());
        this.withFilter((Function1<Tuple2, Object> & java.io.Serializable & Serializable)check$ifrefutable$1 -> BoxesRunTime.boxToBoolean(bl = check$ifrefutable$1 != null)).foreach((Function1<Tuple2, Builder> & java.io.Serializable & Serializable)x$4 -> {
            if (x$4 == null) {
                throw new MatchError((Object)null);
            }
            Object key = x$4._1();
            Object value = x$4._2();
            Builder builder = b.$plus$eq(new Tuple2(key, f.apply(key, value)));
            return builder;
        });
        return b.result();
    }

    public static void $init$(MapLike $this) {
    }

    public class ImmutableDefaultKeySet
    extends MapLike.DefaultKeySet
    implements Set<K> {
        @Override
        public GenericCompanion<Set> companion() {
            return Set.companion$(this);
        }

        @Override
        public Set<K> seq() {
            return Set.seq$(this);
        }

        @Override
        public Combiner<K, ParSet<K>> parCombiner() {
            return Set.parCombiner$(this);
        }

        @Override
        public Set<K> $plus(K elem) {
            if (this.apply(elem)) {
                return this;
            }
            return (Set)((SetLike)Set$.MODULE$.apply(Nil$.MODULE$)).$plus$plus(this).$plus(elem);
        }

        @Override
        public Set<K> $minus(K elem) {
            if (this.apply(elem)) {
                return (Set)((SetLike)Set$.MODULE$.apply(Nil$.MODULE$)).$plus$plus(this).$minus(elem);
            }
            return this;
        }

        @Override
        public <B> Set<B> toSet() {
            return this;
        }

        public /* synthetic */ MapLike scala$collection$immutable$MapLike$ImmutableDefaultKeySet$$$outer() {
            return (MapLike)this.$outer;
        }

        public ImmutableDefaultKeySet(MapLike $outer) {
            Traversable.$init$(this);
            Iterable.$init$(this);
            Set.$init$(this);
        }
    }
}

