/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import scala.Function1;
import scala.Function2;
import scala.MatchError;
import scala.Option;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.GenSet;
import scala.collection.GenSetLike;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterator;
import scala.collection.MapLike;
import scala.collection.Seq;
import scala.collection.SortedMap;
import scala.collection.SortedMapLike$;
import scala.collection.SortedSet;
import scala.collection.SortedSet$;
import scala.collection.SortedSetLike;
import scala.collection.generic.Sorted;
import scala.collection.immutable.Nil$;
import scala.collection.mutable.Builder;
import scala.math.Ordering;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.LambdaDeserialize;
import scala.runtime.ObjectRef;

@ScalaSignature(bytes="\u0006\u0001\u0005eea\u0002\f\u0018!\u0003\r\t\u0001\b\u0005\u0006\u000b\u0002!\tA\u0012\u0005\u0006\u0015\u0002!\ta\u0013\u0005\u0006\u0019\u0002!\ta\u0013\u0005\u0006\u001b\u00021\u0019A\u0014\u0005\u0006-\u00021\ta\u0016\u0005\u0006?\u0002!\t\u0005\u0019\u0004\u0005I\u0002AQ\rC\u0003k\u000f\u0011\u00051\u000eC\u0003N\u000f\u0011\ra\nC\u0003n\u000f\u0011\u0005c\u000eC\u0003r\u000f\u0011\u0005#\u000fC\u0003W\u000f\u0011\u0005C\u000fC\u0003x\u000f\u0011\u0005\u0003\u0010C\u0003\u007f\u0001\u0011\u0005s\u0010\u0003\u0004n\u0001\u0019\u0005\u0011Q\u0003\u0005\u0007[\u0002!\t%!\u000b\t\u000f\u0005\u001d\u0003\u0001\"\u0011\u0002J!9\u00111\f\u0001\u0005B\u0005u\u0003bBA8\u0001\u0011\u0005\u0013\u0011\u000f\u0005\b\u0003\u000f\u0003a\u0011AAE\u0011\u001d\t\t\n\u0001D\u0001\u0003'\u0013QbU8si\u0016$W*\u00199MS.,'B\u0001\r\u001a\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u00025\u0005)1oY1mC\u000e\u0001Q\u0003B\u000f+{Q\u001aB\u0001\u0001\u0010#\u0005B\u0011q\u0004I\u0007\u00023%\u0011\u0011%\u0007\u0002\u0007\u0003:L(+\u001a4\u0011\t\r2\u0003fM\u0007\u0002I)\u0011QeF\u0001\bO\u0016tWM]5d\u0013\t9CE\u0001\u0004T_J$X\r\u001a\t\u0003S)b\u0001\u0001B\u0003,\u0001\t\u0007AFA\u0001B#\ti\u0003\u0007\u0005\u0002 ]%\u0011q&\u0007\u0002\b\u001d>$\b.\u001b8h!\ty\u0012'\u0003\u000233\t\u0019\u0011I\\=\u0011\u0005%\"DAB\u001b\u0001\t\u000b\u0007aG\u0001\u0003UQ&\u001c\u0018CA\u00178%\rA$h\u0010\u0004\u0005s\u0001\u0001qG\u0001\u0007=e\u00164\u0017N\\3nK:$h\bE\u0003<\u0001!b4'D\u0001\u0018!\tIS\b\u0002\u0004?\u0001\u0011\u0015\r\u0001\f\u0002\u0002\u0005B!1\b\u0011\u0015=\u0013\t\tuCA\u0005T_J$X\rZ'baB)1h\u0011\u0015=g%\u0011Ai\u0006\u0002\b\u001b\u0006\u0004H*[6f\u0003\u0019!\u0013N\\5uIQ\tq\t\u0005\u0002 \u0011&\u0011\u0011*\u0007\u0002\u0005+:LG/\u0001\u0005gSJ\u001cHoS3z+\u0005A\u0013a\u00027bgR\\U-_\u0001\t_J$WM]5oOV\tq\nE\u0002Q'\"r!aH)\n\u0005IK\u0012a\u00029bG.\fw-Z\u0005\u0003)V\u0013\u0001b\u0014:eKJLgn\u001a\u0006\u0003%f\t\u0011B]1oO\u0016LU\u000e\u001d7\u0015\u0007MBV\fC\u0003Z\u000b\u0001\u0007!,\u0001\u0003ge>l\u0007cA\u0010\\Q%\u0011A,\u0007\u0002\u0007\u001fB$\u0018n\u001c8\t\u000by+\u0001\u0019\u0001.\u0002\u000bUtG/\u001b7\u0002\r-,\u0017pU3u+\u0005\t\u0007cA\u001ecQ%\u00111m\u0006\u0002\n'>\u0014H/\u001a3TKR\u00141\u0003R3gCVdGoS3z'>\u0014H/\u001a3TKR\u001c2a\u00024b!\t9\u0007.D\u0001\u0001\u0013\tI7IA\u0007EK\u001a\fW\u000f\u001c;LKf\u001cV\r^\u0001\u0007y%t\u0017\u000e\u001e \u0015\u00031\u0004\"aZ\u0004\u0002\u000b\u0011\u0002H.^:\u0015\u0005\u0005|\u0007\"\u00029\u000b\u0001\u0004A\u0013\u0001B3mK6\fa\u0001J7j]V\u001cHCA1t\u0011\u0015\u00018\u00021\u0001))\r\tWO\u001e\u0005\u000632\u0001\rA\u0017\u0005\u0006=2\u0001\rAW\u0001\u0011W\u0016L8/\u0013;fe\u0006$xN\u001d$s_6$\"!\u001f?\u0011\u0007mR\b&\u0003\u0002|/\tA\u0011\n^3sCR|'\u000fC\u0003~\u001b\u0001\u0007\u0001&A\u0003ti\u0006\u0014H/A\u0004va\u0012\fG/\u001a3\u0016\t\u0005\u0005\u0011q\u0001\u000b\u0007\u0003\u0007\ti!!\u0005\u0011\u000bm\u0002\u0005&!\u0002\u0011\u0007%\n9\u0001B\u0004\u0002\n9\u0011\r!a\u0003\u0003\u0005\t\u000b\u0014C\u0001\u001f1\u0011\u0019\tyA\u0004a\u0001Q\u0005\u00191.Z=\t\u000f\u0005Ma\u00021\u0001\u0002\u0006\u0005)a/\u00197vKV!\u0011qCA\u000f)\u0011\tI\"a\b\u0011\u000bm\u0002\u0005&a\u0007\u0011\u0007%\ni\u0002B\u0004\u0002\n=\u0011\r!a\u0003\t\u000f\u0005\u0005r\u00021\u0001\u0002$\u0005\u00111N\u001e\t\u0007?\u0005\u0015\u0002&a\u0007\n\u0007\u0005\u001d\u0012D\u0001\u0004UkBdWMM\u000b\u0005\u0003W\t\t\u0004\u0006\u0005\u0002.\u0005M\u0012\u0011HA\u001f!\u0015Y\u0004\tKA\u0018!\rI\u0013\u0011\u0007\u0003\b\u0003\u0013\u0001\"\u0019AA\u0006\u0011\u001d\t)\u0004\u0005a\u0001\u0003o\tQ!\u001a7f[F\u0002baHA\u0013Q\u0005=\u0002bBA\u001e!\u0001\u0007\u0011qG\u0001\u0006K2,WN\r\u0005\b\u0003\u007f\u0001\u0002\u0019AA!\u0003\u0015)G.Z7t!\u0015y\u00121IA\u001c\u0013\r\t)%\u0007\u0002\u000byI,\u0007/Z1uK\u0012t\u0014A\u00034jYR,'oS3zgR\u0019q(a\u0013\t\u000f\u00055\u0013\u00031\u0001\u0002P\u0005\t\u0001\u000f\u0005\u0004 \u0003#B\u0013QK\u0005\u0004\u0003'J\"!\u0003$v]\u000e$\u0018n\u001c82!\ry\u0012qK\u0005\u0004\u00033J\"a\u0002\"p_2,\u0017M\\\u0001\n[\u0006\u0004h+\u00197vKN,B!a\u0018\u0002fQ!\u0011\u0011MA5!\u0015Y\u0004\tKA2!\rI\u0013Q\r\u0003\u0007\u0003O\u0012\"\u0019\u0001\u0017\u0003\u0003\rCq!a\u001b\u0013\u0001\u0004\ti'A\u0001g!\u0019y\u0012\u0011\u000b\u001f\u0002d\u0005QA\u0005\u001d7vg\u0012\u0002H.^:\u0016\t\u0005M\u0014\u0011\u0010\u000b\u0005\u0003k\nY\bE\u0003<\u0001\"\n9\bE\u0002*\u0003s\"q!!\u0003\u0014\u0005\u0004\tY\u0001C\u0004\u0002~M\u0001\r!a \u0002\u0005a\u001c\b#B\u001e\u0002\u0002\u0006\u0015\u0015bAAB/\t\u0011r)\u001a8Ue\u00064XM]:bE2,wJ\\2f!\u0019y\u0012Q\u0005\u0015\u0002x\u0005a\u0011\u000e^3sCR|'O\u0012:p[R!\u00111RAH!\u0011Y$0!$\u0011\u000b}\t)\u0003\u000b\u001f\t\u000bu$\u0002\u0019\u0001\u0015\u0002%Y\fG.^3t\u0013R,'/\u0019;pe\u001a\u0013x.\u001c\u000b\u0005\u0003+\u000b9\nE\u0002<urBQ!`\u000bA\u0002!\u0002")
public interface SortedMapLike<A, B, This extends SortedMapLike<A, B, This> & SortedMap<A, B>>
extends Sorted<A, This>,
MapLike<A, B, This> {
    public static /* synthetic */ Object firstKey$(SortedMapLike $this) {
        return $this.firstKey();
    }

    @Override
    default public A firstKey() {
        return (A)((Tuple2)this.head())._1();
    }

    public static /* synthetic */ Object lastKey$(SortedMapLike $this) {
        return $this.lastKey();
    }

    @Override
    default public A lastKey() {
        return (A)((Tuple2)this.last())._1();
    }

    @Override
    public Ordering<A> ordering();

    @Override
    public This rangeImpl(Option<A> var1, Option<A> var2);

    public static /* synthetic */ SortedSet keySet$(SortedMapLike $this) {
        return $this.keySet();
    }

    @Override
    default public SortedSet<A> keySet() {
        return new DefaultKeySortedSet(this);
    }

    public static /* synthetic */ SortedMap updated$(SortedMapLike $this, Object key, Object value) {
        return $this.updated((A)key, (B1)value);
    }

    @Override
    default public <B1> SortedMap<A, B1> updated(A key, B1 value) {
        return this.$plus(new Tuple2<A, B1>(key, value));
    }

    @Override
    public <B1> SortedMap<A, B1> $plus(Tuple2<A, B1> var1);

    public static /* synthetic */ SortedMap $plus$(SortedMapLike $this, Tuple2 elem1, Tuple2 elem2, Seq elems) {
        return $this.$plus(elem1, elem2, elems);
    }

    @Override
    default public <B1> SortedMap<A, B1> $plus(Tuple2<A, B1> elem1, Tuple2<A, B1> elem2, Seq<Tuple2<A, B1>> elems) {
        ObjectRef m = ObjectRef.create(this.$plus(elem1).$plus(elem2));
        elems.foreach((Function1<Tuple2, Object> & java.io.Serializable & Serializable)e -> {
            m.elem = ((SortedMap)m.elem).$plus(e);
            return BoxedUnit.UNIT;
        });
        return (SortedMap)m.elem;
    }

    public static /* synthetic */ SortedMap filterKeys$(SortedMapLike $this, Function1 p) {
        return $this.filterKeys(p);
    }

    @Override
    default public SortedMap<A, B> filterKeys(Function1<A, Object> p) {
        return new SortedMap.Default<A, B>(this, p){
            private final /* synthetic */ SortedMapLike $outer;
            public final Function1 p$1;

            public <B1> SortedMap<A, B1> $plus(Tuple2<A, B1> kv) {
                return SortedMap.Default.$plus$(this, kv);
            }

            public SortedMap<A, B> $minus(A key) {
                return SortedMap.Default.$minus$(this, key);
            }

            public SortedMap<A, B> empty() {
                return SortedMap.empty$(this);
            }

            public Builder<Tuple2<A, B>, SortedMap<A, B>> newBuilder() {
                return SortedMap.newBuilder$(this);
            }

            public A firstKey() {
                return (A)SortedMapLike.firstKey$(this);
            }

            public A lastKey() {
                return (A)SortedMapLike.lastKey$(this);
            }

            public SortedSet<A> keySet() {
                return SortedMapLike.keySet$(this);
            }

            public <B1> SortedMap<A, B1> updated(A key, B1 value) {
                return SortedMapLike.updated$(this, key, value);
            }

            public <B1> SortedMap<A, B1> $plus(Tuple2<A, B1> elem1, Tuple2<A, B1> elem2, Seq<Tuple2<A, B1>> elems) {
                return SortedMapLike.$plus$(this, elem1, elem2, elems);
            }

            public SortedMap<A, B> filterKeys(Function1<A, Object> p) {
                return SortedMapLike.filterKeys$(this, p);
            }

            public <C> SortedMap<A, C> mapValues(Function1<B, C> f) {
                return SortedMapLike.mapValues$(this, f);
            }

            public <B1> SortedMap<A, B1> $plus$plus(GenTraversableOnce<Tuple2<A, B1>> xs) {
                return SortedMapLike.$plus$plus$(this, xs);
            }

            public int compare(A k0, A k1) {
                return Sorted.compare$(this, k0, k1);
            }

            public Sorted from(Object from) {
                return Sorted.from$(this, from);
            }

            public Sorted until(Object until) {
                return Sorted.until$(this, until);
            }

            public Sorted range(Object from, Object until) {
                return Sorted.range$(this, from, until);
            }

            public Sorted to(Object to) {
                return Sorted.to$(this, to);
            }

            public boolean hasAll(Iterator<A> j) {
                return Sorted.hasAll$(this, j);
            }

            public Ordering<A> ordering() {
                return this.$outer.ordering();
            }

            public SortedMap<A, B> rangeImpl(Option<A> from, Option<A> until) {
                return this.$outer.rangeImpl(from, until).filterKeys(this.p$1);
            }

            public Iterator<Tuple2<A, B>> iteratorFrom(A start) {
                return this.$outer.iteratorFrom(start).filter((Function1<Tuple2, Object> & java.io.Serializable & Serializable)(A x0$1) -> BoxesRunTime.boxToBoolean($anon$1.$anonfun$iteratorFrom$1(this, x0$1)));
            }

            public Iterator<A> keysIteratorFrom(A start) {
                return this.$outer.keysIteratorFrom(start).filter(this.p$1);
            }

            public Iterator<B> valuesIteratorFrom(A start) {
                return this.$outer.iteratorFrom(start).collect(new Serializable(this){
                    public static final long serialVersionUID = 0L;
                    private final /* synthetic */ $anon$1 $outer;

                    /*
                     * WARNING - void declaration
                     * Enabled aggressive block sorting
                     */
                    public final <A1 extends Tuple2<A, B>, B1> B1 applyOrElse(A1 x1, Function1<A1, B1> function1) {
                        void var3_7;
                        if (x1 != null) {
                            A k = x1._1();
                            B v = x1._2();
                            if (BoxesRunTime.unboxToBoolean(this.$outer.p$1.apply(k))) {
                                B b = v;
                                return var3_7;
                            }
                        }
                        B1 B1 = function1.apply(x1);
                        return var3_7;
                    }

                    public final boolean isDefinedAt(Tuple2<A, B> x1) {
                        A k;
                        boolean bl = x1 != null && BoxesRunTime.unboxToBoolean(this.$outer.p$1.apply(k = x1._1()));
                        return bl;
                    }
                    {
                        if ($outer == null) {
                            throw null;
                        }
                        this.$outer = $outer;
                    }
                });
            }

            public static final /* synthetic */ boolean $anonfun$iteratorFrom$1($anon$1 $this, Tuple2 x0$1) {
                if (x0$1 == null) {
                    throw new MatchError((Object)null);
                }
                T1 k = x0$1._1();
                boolean bl = BoxesRunTime.unboxToBoolean($this.p$1.apply(k));
                return bl;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.p$1 = p$1;
                super($outer, p$1);
                Sorted.$init$(this);
                SortedMapLike.$init$(this);
                SortedMap.$init$(this);
                SortedMap.Default.$init$(this);
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$iteratorFrom$1$adapted(scala.collection.SortedMapLike$$anon$1 scala.Tuple2 ), $anonfun$groupBy$1(scala.collection.TraversableLike scala.Function1 scala.collection.mutable.Map java.lang.Object ), $anonfun$groupBy$3$adapted(scala.Tuple2 ), $anonfun$groupBy$4(scala.collection.mutable.Builder scala.Tuple2 )}, serializedLambda);
            }
        };
    }

    public static /* synthetic */ SortedMap mapValues$(SortedMapLike $this, Function1 f) {
        return $this.mapValues(f);
    }

    @Override
    default public <C> SortedMap<A, C> mapValues(Function1<B, C> f) {
        return new SortedMap.Default<A, C>(this, f){
            private final /* synthetic */ SortedMapLike $outer;
            private final Function1 f$1;

            public <B1> SortedMap<A, B1> $plus(Tuple2<A, B1> kv) {
                return SortedMap.Default.$plus$(this, kv);
            }

            public SortedMap<A, C> $minus(A key) {
                return SortedMap.Default.$minus$(this, key);
            }

            public SortedMap<A, C> empty() {
                return SortedMap.empty$(this);
            }

            public Builder<Tuple2<A, C>, SortedMap<A, C>> newBuilder() {
                return SortedMap.newBuilder$(this);
            }

            public A firstKey() {
                return (A)SortedMapLike.firstKey$(this);
            }

            public A lastKey() {
                return (A)SortedMapLike.lastKey$(this);
            }

            public SortedSet<A> keySet() {
                return SortedMapLike.keySet$(this);
            }

            public <B1> SortedMap<A, B1> updated(A key, B1 value) {
                return SortedMapLike.updated$(this, key, value);
            }

            public <B1> SortedMap<A, B1> $plus(Tuple2<A, B1> elem1, Tuple2<A, B1> elem2, Seq<Tuple2<A, B1>> elems) {
                return SortedMapLike.$plus$(this, elem1, elem2, elems);
            }

            public SortedMap<A, C> filterKeys(Function1<A, Object> p) {
                return SortedMapLike.filterKeys$(this, p);
            }

            public <C> SortedMap<A, C> mapValues(Function1<C, C> f) {
                return SortedMapLike.mapValues$(this, f);
            }

            public <B1> SortedMap<A, B1> $plus$plus(GenTraversableOnce<Tuple2<A, B1>> xs) {
                return SortedMapLike.$plus$plus$(this, xs);
            }

            public int compare(A k0, A k1) {
                return Sorted.compare$(this, k0, k1);
            }

            public Sorted from(Object from) {
                return Sorted.from$(this, from);
            }

            public Sorted until(Object until) {
                return Sorted.until$(this, until);
            }

            public Sorted range(Object from, Object until) {
                return Sorted.range$(this, from, until);
            }

            public Sorted to(Object to) {
                return Sorted.to$(this, to);
            }

            public boolean hasAll(Iterator<A> j) {
                return Sorted.hasAll$(this, j);
            }

            public Ordering<A> ordering() {
                return this.$outer.ordering();
            }

            public SortedMap<A, C> rangeImpl(Option<A> from, Option<A> until) {
                return this.$outer.rangeImpl(from, until).mapValues(this.f$1);
            }

            public Iterator<Tuple2<A, C>> iteratorFrom(A start) {
                return this.$outer.iteratorFrom(start).map((Function1<Tuple2, Tuple2> & java.io.Serializable & Serializable)x0$1 -> {
                    if (x0$1 == null) {
                        throw new MatchError((Object)null);
                    }
                    T1 k = x0$1._1();
                    T2 v = x0$1._2();
                    Tuple2<T1, R> tuple2 = new Tuple2<T1, R>(k, $this.f$1.apply(v));
                    return tuple2;
                });
            }

            public Iterator<A> keysIteratorFrom(A start) {
                return this.$outer.keysIteratorFrom(start);
            }

            public Iterator<C> valuesIteratorFrom(A start) {
                return this.$outer.valuesIteratorFrom(start).map(this.f$1);
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.f$1 = f$1;
                super($outer, f$1);
                Sorted.$init$(this);
                SortedMapLike.$init$(this);
                SortedMap.$init$(this);
                SortedMap.Default.$init$(this);
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$iteratorFrom$2(scala.collection.SortedMapLike$$anon$2 scala.Tuple2 ), $anonfun$groupBy$1(scala.collection.TraversableLike scala.Function1 scala.collection.mutable.Map java.lang.Object ), $anonfun$groupBy$3$adapted(scala.Tuple2 ), $anonfun$groupBy$4(scala.collection.mutable.Builder scala.Tuple2 )}, serializedLambda);
            }
        };
    }

    public static /* synthetic */ SortedMap $plus$plus$(SortedMapLike $this, GenTraversableOnce xs) {
        return $this.$plus$plus(xs);
    }

    @Override
    default public <B1> SortedMap<A, B1> $plus$plus(GenTraversableOnce<Tuple2<A, B1>> xs) {
        SortedMap sortedMap = (SortedMap)this.repr();
        return xs.seq().$div$colon(sortedMap, (Function2<SortedMap, Tuple2, SortedMap> & java.io.Serializable & Serializable)(x$2, x$3) -> x$2.$plus((Tuple2)x$3));
    }

    public Iterator<Tuple2<A, B>> iteratorFrom(A var1);

    public Iterator<B> valuesIteratorFrom(A var1);

    public static void $init$(SortedMapLike $this) {
    }

    public class DefaultKeySortedSet
    extends MapLike.DefaultKeySet
    implements SortedSet<A> {
        @Override
        public SortedSet<A> empty() {
            return SortedSet.empty$(this);
        }

        @Override
        public /* synthetic */ boolean scala$collection$SortedSetLike$$super$subsetOf(GenSet that) {
            return GenSetLike.subsetOf$(this, that);
        }

        @Override
        public SortedSet<A> keySet() {
            return SortedSetLike.keySet$(this);
        }

        @Override
        public A firstKey() {
            return SortedSetLike.firstKey$(this);
        }

        @Override
        public A lastKey() {
            return SortedSetLike.lastKey$(this);
        }

        @Override
        public SortedSet<A> from(A from) {
            return SortedSetLike.from$(this, from);
        }

        @Override
        public SortedSet<A> until(A until) {
            return SortedSetLike.until$(this, until);
        }

        @Override
        public SortedSet<A> range(A from, A until) {
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

        @Override
        public Ordering<A> ordering() {
            return this.scala$collection$SortedMapLike$DefaultKeySortedSet$$$outer().ordering();
        }

        @Override
        public SortedSet<A> $plus(A elem) {
            return (SortedSet)SortedSet$.MODULE$.apply(Nil$.MODULE$, this.ordering()).$plus$plus(this).$plus(elem);
        }

        @Override
        public SortedSet<A> $minus(A elem) {
            return (SortedSet)SortedSet$.MODULE$.apply(Nil$.MODULE$, this.ordering()).$plus$plus(this).$minus(elem);
        }

        @Override
        public SortedSet<A> rangeImpl(Option<A> from, Option<A> until) {
            Object map = this.scala$collection$SortedMapLike$DefaultKeySortedSet$$$outer().rangeImpl(from, until);
            return new DefaultKeySortedSet((SortedMapLike)map);
        }

        @Override
        public Iterator<A> keysIteratorFrom(A start) {
            return this.scala$collection$SortedMapLike$DefaultKeySortedSet$$$outer().keysIteratorFrom(start);
        }

        public /* synthetic */ SortedMapLike scala$collection$SortedMapLike$DefaultKeySortedSet$$$outer() {
            return (SortedMapLike)this.$outer;
        }

        public DefaultKeySortedSet(SortedMapLike $outer) {
            Sorted.$init$(this);
            SortedSetLike.$init$(this);
            SortedSet.$init$(this);
        }
    }
}

