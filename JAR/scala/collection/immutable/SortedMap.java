/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import scala.Function1;
import scala.Function2;
import scala.MatchError;
import scala.Option;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.GenMapLike;
import scala.collection.GenSetLike;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.SortedMap;
import scala.collection.SortedMapLike;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.Sorted;
import scala.collection.immutable.Iterable;
import scala.collection.immutable.Map;
import scala.collection.immutable.MapLike;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Set;
import scala.collection.immutable.Set$;
import scala.collection.immutable.SortedMap$;
import scala.collection.immutable.SortedSet;
import scala.collection.immutable.SortedSet$;
import scala.collection.immutable.Traversable;
import scala.collection.mutable.Builder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.immutable.ParMap;
import scala.collection.parallel.immutable.ParSet;
import scala.math.Ordering;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.LambdaDeserialize;

@ScalaSignature(bytes="\u0006\u0001\t%caB\u000f\u001f!\u0003\r\t!\n\u0005\u0006\u000f\u0002!\t\u0001\u0013\u0005\u0007\u0019\u0002\u0001K\u0011K'\t\u000b]\u0003A\u0011\t-\t\u000be\u0003A\u0011\t.\t\u000b\u0015\u0004A\u0011\t4\u0007\t)\u0004\u0001b\u001b\u0005\u0006_\u001a!\t\u0001\u001d\u0005\u0006e\u001a!\te\u001d\u0005\u0006m\u001a!\te\u001e\u0005\u0006s\u001a!\tE\u001f\u0005\b\u0003\u000b1A\u0011IA\u0004\u0011\u0019\u0011\b\u0001\"\u0001\u0002\u001a!1!\u000f\u0001C!\u0003SAq!a\u0012\u0001\t\u0003\nI\u0005C\u0004\u0002`\u0001!\t%!\u0019\t\u000f\u0005M\u0004\u0001\"\u0011\u0002v!9\u0011Q\u0011\u0001\u0005B\u0005\u001d\u0005BDAG\u0001A\u0005\u0019\u0011!A\u0005\n\u0005=\u00151S\u0004\b\u00033s\u0002\u0012AAN\r\u0019ib\u0004#\u0001\u0002\u001e\"1q\u000e\u0006C\u0001\u0003[Cq!a,\u0015\t\u0007\t\t\f\u0003\u0004X)\u0011\u0005\u0011Q\u001d\u0005\u0007\u0019R!\t%a>\u0007\u0015\t5A\u0003%A\u0002\u0002\u0001\u0012y\u0001C\u0003H3\u0011\u0005\u0001\n\u0003\u0004s3\u0011\u0005#Q\u0007\u0005\u0007mf!\tE!\u0012\u0003\u0013M{'\u000f^3e\u001b\u0006\u0004(BA\u0010!\u0003%IW.\\;uC\ndWM\u0003\u0002\"E\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003\r\nQa]2bY\u0006\u001c\u0001!F\u0002'cm\u001ab\u0001A\u0014,{\u0001#\u0005C\u0001\u0015*\u001b\u0005\u0011\u0013B\u0001\u0016#\u0005\u0019\te.\u001f*fMB!A&L\u0018;\u001b\u0005q\u0012B\u0001\u0018\u001f\u0005\ri\u0015\r\u001d\t\u0003aEb\u0001\u0001B\u00033\u0001\t\u00071GA\u0001B#\t!t\u0007\u0005\u0002)k%\u0011aG\t\u0002\b\u001d>$\b.\u001b8h!\tA\u0003(\u0003\u0002:E\t\u0019\u0011I\\=\u0011\u0005AZDA\u0002\u001f\u0001\t\u000b\u00071GA\u0001C!\u0011qth\f\u001e\u000e\u0003\u0001J!!\b\u0011\u0011\u000b1\nuFO\"\n\u0005\ts\"aB'ba2K7.\u001a\t\u0005Y\u0001y#\bE\u0003?\u000b>R4)\u0003\u0002GA\ti1k\u001c:uK\u0012l\u0015\r\u001d'jW\u0016\fa\u0001J5oSR$C#A%\u0011\u0005!R\u0015BA&#\u0005\u0011)f.\u001b;\u0002\u00159,wOQ;jY\u0012,'/F\u0001O!\u0011y%\u000bV\"\u000e\u0003AS!!\u0015\u0011\u0002\u000f5,H/\u00192mK&\u00111\u000b\u0015\u0002\b\u0005VLG\u000eZ3s!\u0011ASk\f\u001e\n\u0005Y\u0013#A\u0002+va2,''A\u0003f[B$\u00180F\u0001D\u0003\u001d)\b\u000fZ1uK\u0012,\"a\u00170\u0015\u0007q\u000b7\r\u0005\u0003-\u0001=j\u0006C\u0001\u0019_\t\u0015yFA1\u0001a\u0005\t\u0011\u0015'\u0005\u0002;o!)!\r\u0002a\u0001_\u0005\u00191.Z=\t\u000b\u0011$\u0001\u0019A/\u0002\u000bY\fG.^3\u0002\r-,\u0017pU3u+\u00059\u0007c\u0001\u0017i_%\u0011\u0011N\b\u0002\n'>\u0014H/\u001a3TKR\u00141\u0003R3gCVdGoS3z'>\u0014H/\u001a3TKR\u001c2A\u00027h!\tig.D\u0001\u0001\u0013\tQW)\u0001\u0004=S:LGO\u0010\u000b\u0002cB\u0011QNB\u0001\u0006IAdWo\u001d\u000b\u0003ORDQ!\u001e\u0005A\u0002=\nA!\u001a7f[\u00061A%\\5okN$\"a\u001a=\t\u000bUL\u0001\u0019A\u0018\u0002\u0013I\fgnZ3J[BdG\u0003B4|\u0003\u0003AQ\u0001 \u0006A\u0002u\fAA\u001a:p[B\u0019\u0001F`\u0018\n\u0005}\u0014#AB(qi&|g\u000e\u0003\u0004\u0002\u0004)\u0001\r!`\u0001\u0006k:$\u0018\u000e\\\u0001\u0006i>\u001cV\r^\u000b\u0005\u0003\u0013\t\u0019\"\u0006\u0002\u0002\fA)A&!\u0004\u0002\u0012%\u0019\u0011q\u0002\u0010\u0003\u0007M+G\u000fE\u00021\u0003'!q!!\u0006\f\u0005\u0004\t9BA\u0001D#\tys'\u0006\u0003\u0002\u001c\u0005\u0005B\u0003BA\u000f\u0003G\u0001R\u0001\f\u00010\u0003?\u00012\u0001MA\u0011\t\u0015yFB1\u0001a\u0011\u001d\t)\u0003\u0004a\u0001\u0003O\t!a\u001b<\u0011\u000b!*v&a\b\u0016\t\u0005-\u0012\u0011\u0007\u000b\t\u0003[\t\u0019$!\u000f\u0002>A)A\u0006A\u0018\u00020A\u0019\u0001'!\r\u0005\u000b}k!\u0019\u00011\t\u000f\u0005UR\u00021\u0001\u00028\u0005)Q\r\\3ncA)\u0001&V\u0018\u00020!9\u00111H\u0007A\u0002\u0005]\u0012!B3mK6\u0014\u0004bBA \u001b\u0001\u0007\u0011\u0011I\u0001\u0006K2,Wn\u001d\t\u0006Q\u0005\r\u0013qG\u0005\u0004\u0003\u000b\u0012#A\u0003\u001fsKB,\u0017\r^3e}\u0005QA\u0005\u001d7vg\u0012\u0002H.^:\u0016\t\u0005-\u0013\u0011\u000b\u000b\u0005\u0003\u001b\n\u0019\u0006E\u0003-\u0001=\ny\u0005E\u00021\u0003#\"Qa\u0018\bC\u0002\u0001Dq!!\u0016\u000f\u0001\u0004\t9&\u0001\u0002ygB)a(!\u0017\u0002^%\u0019\u00111\f\u0011\u0003%\u001d+g\u000e\u0016:bm\u0016\u00148/\u00192mK>s7-\u001a\t\u0006QU{\u0013qJ\u0001\u000bM&dG/\u001a:LKf\u001cHcA\"\u0002d!9\u0011QM\bA\u0002\u0005\u001d\u0014!\u00019\u0011\r!\nIgLA7\u0013\r\tYG\t\u0002\n\rVt7\r^5p]F\u00022\u0001KA8\u0013\r\t\tH\t\u0002\b\u0005>|G.Z1o\u0003%i\u0017\r\u001d,bYV,7/\u0006\u0003\u0002x\u0005uD\u0003BA=\u0003\u007f\u0002R\u0001\f\u00010\u0003w\u00022\u0001MA?\t\u0019\t)\u0002\u0005b\u0001g!9\u0011\u0011\u0011\tA\u0002\u0005\r\u0015!\u00014\u0011\r!\nIGOA>\u0003\u0019)\u0017/^1mgR!\u0011QNAE\u0011\u0019\tY)\u0005a\u0001o\u0005!A\u000f[1u\u00031\u0019X\u000f]3sI\u0015\fX/\u00197t)\u0011\ti'!%\t\r\u0005-%\u00031\u00018\u0013\u0011\t))!&\n\u0007\u0005]\u0005E\u0001\u0006HK:l\u0015\r\u001d'jW\u0016\f\u0011bU8si\u0016$W*\u00199\u0011\u00051\"2c\u0001\u000b\u0002 B1\u0011\u0011UAT\u0003Wk!!a)\u000b\u0007\u0005\u0015\u0006%A\u0004hK:,'/[2\n\t\u0005%\u00161\u0015\u0002\u001a\u00136lW\u000f^1cY\u0016\u001cvN\u001d;fI6\u000b\u0007OR1di>\u0014\u0018\u0010\u0005\u0002-\u0001Q\u0011\u00111T\u0001\rG\u0006t')^5mI\u001a\u0013x.\\\u000b\u0007\u0003g\u000bY-a4\u0015\t\u0005U\u00161\u001b\t\u000b\u0003C\u000b9,a/\u0002H\u0006E\u0017\u0002BA]\u0003G\u0013AbQ1o\u0005VLG\u000e\u001a$s_6\u0004B!!0\u0002@6\tA#\u0003\u0003\u0002B\u0006\r'\u0001B\"pY2LA!!2\u0002$\n\u00012k\u001c:uK\u0012l\u0015\r\u001d$bGR|'/\u001f\t\u0007QU\u000bI-!4\u0011\u0007A\nY\rB\u00033-\t\u00071\u0007E\u00021\u0003\u001f$Q\u0001\u0010\fC\u0002M\u0002b\u0001\f\u0001\u0002J\u00065\u0007bBAk-\u0001\u000f\u0011q[\u0001\u0004_J$\u0007CBAm\u0003?\fIMD\u0002)\u00037L1!!8#\u0003\u001d\u0001\u0018mY6bO\u0016LA!!9\u0002d\nAqJ\u001d3fe&twMC\u0002\u0002^\n*b!a:\u0002n\u0006EH\u0003BAu\u0003g\u0004b\u0001\f\u0001\u0002l\u0006=\bc\u0001\u0019\u0002n\u0012)!g\u0006b\u0001gA\u0019\u0001'!=\u0005\u000bq:\"\u0019A\u001a\t\u000f\u0005Uw\u0003q\u0001\u0002vB1\u0011\u0011\\Ap\u0003W,b!!?\u0003\u0002\t\u0015A\u0003BA~\u0005\u0013\u0001ba\u0014*\u0002~\n\u001d\u0001C\u0002\u0015V\u0003\u007f\u0014\u0019\u0001E\u00021\u0005\u0003!QA\r\rC\u0002M\u00022\u0001\rB\u0003\t\u0015a\u0004D1\u00014!\u0019a\u0003!a@\u0003\u0004!9\u0011Q\u001b\rA\u0004\t-\u0001CBAm\u0003?\fyPA\u0004EK\u001a\fW\u000f\u001c;\u0016\r\tE!q\u0003B\u000e'\u0019IrEa\u0005\u0003\u001eA1A\u0006\u0001B\u000b\u00053\u00012\u0001\rB\f\t\u0015\u0011\u0014D1\u00014!\r\u0001$1\u0004\u0003\u0007ye!)\u0019A\u001a\u0011\u0011\t}!\u0011\u0007B\u000b\u00053qAA!\t\u000309!!1\u0005B\u0017\u001d\u0011\u0011)Ca\u000b\u000e\u0005\t\u001d\"b\u0001B\u0015I\u00051AH]8pizJ\u0011aI\u0005\u0003C\tJ1!!'!\u0013\u0011\u0011iAa\r\u000b\u0007\u0005e\u0005%\u0006\u0003\u00038\tuB\u0003\u0002B\u001d\u0005\u0003\u0002b\u0001\f\u0001\u0003\u0016\tm\u0002c\u0001\u0019\u0003>\u00111ql\u0007b\u0001\u0005\u007f\t2A!\u00078\u0011\u001d\t)c\u0007a\u0001\u0005\u0007\u0002b\u0001K+\u0003\u0016\tmB\u0003\u0002B\n\u0005\u000fBaA\u0019\u000fA\u0002\tU\u0001")
public interface SortedMap<A, B>
extends Map<A, B>,
scala.collection.SortedMap<A, B> {
    public static <A, B> CanBuildFrom<SortedMap<?, ?>, Tuple2<A, B>, SortedMap<A, B>> canBuildFrom(Ordering<A> ordering) {
        return SortedMap$.MODULE$.canBuildFrom(ordering);
    }

    public /* synthetic */ boolean scala$collection$immutable$SortedMap$$super$equals(Object var1);

    public static /* synthetic */ Builder newBuilder$(SortedMap $this) {
        return $this.newBuilder();
    }

    @Override
    default public Builder<Tuple2<A, B>, SortedMap<A, B>> newBuilder() {
        return SortedMap$.MODULE$.newBuilder(this.ordering());
    }

    public static /* synthetic */ SortedMap empty$(SortedMap $this) {
        return $this.empty();
    }

    @Override
    default public SortedMap<A, B> empty() {
        return SortedMap$.MODULE$.empty(this.ordering());
    }

    public static /* synthetic */ SortedMap updated$(SortedMap $this, Object key, Object value) {
        return $this.updated((A)key, (B1)value);
    }

    @Override
    default public <B1> SortedMap<A, B1> updated(A key, B1 value) {
        return this.$plus(new Tuple2<A, B1>(key, value));
    }

    public static /* synthetic */ SortedSet keySet$(SortedMap $this) {
        return $this.keySet();
    }

    @Override
    default public SortedSet<A> keySet() {
        return new DefaultKeySortedSet(this);
    }

    public static /* synthetic */ SortedMap $plus$(SortedMap $this, Tuple2 kv) {
        return $this.$plus(kv);
    }

    @Override
    default public <B1> SortedMap<A, B1> $plus(Tuple2<A, B1> kv) {
        throw new AbstractMethodError("SortedMap.+");
    }

    public static /* synthetic */ SortedMap $plus$(SortedMap $this, Tuple2 elem1, Tuple2 elem2, Seq elems) {
        return $this.$plus(elem1, elem2, elems);
    }

    @Override
    default public <B1> SortedMap<A, B1> $plus(Tuple2<A, B1> elem1, Tuple2<A, B1> elem2, Seq<Tuple2<A, B1>> elems) {
        return this.$plus(elem1).$plus(elem2).$plus$plus((GenTraversableOnce<Tuple2<A, B1>>)elems);
    }

    public static /* synthetic */ SortedMap $plus$plus$(SortedMap $this, GenTraversableOnce xs) {
        return $this.$plus$plus(xs);
    }

    @Override
    default public <B1> SortedMap<A, B1> $plus$plus(GenTraversableOnce<Tuple2<A, B1>> xs) {
        SortedMap sortedMap = (SortedMap)this.repr();
        return xs.seq().$div$colon(sortedMap, (Function2<SortedMap, Tuple2, SortedMap> & java.io.Serializable & Serializable)(x$3, x$4) -> x$3.$plus((Tuple2)x$4));
    }

    public static /* synthetic */ SortedMap filterKeys$(SortedMap $this, Function1 p) {
        return $this.filterKeys(p);
    }

    @Override
    default public SortedMap<A, B> filterKeys(Function1<A, Object> p) {
        return new Default<A, B>(this, p){
            private final /* synthetic */ SortedMap $outer;
            public final Function1 p$1;

            public <B1> SortedMap<A, B1> $plus(Tuple2<A, B1> kv) {
                return Default.$plus$(this, kv);
            }

            public SortedMap<A, B> $minus(A key) {
                return Default.$minus$(this, key);
            }

            public /* synthetic */ boolean scala$collection$immutable$SortedMap$$super$equals(Object that) {
                return GenMapLike.equals$(this, that);
            }

            public Builder<Tuple2<A, B>, SortedMap<A, B>> newBuilder() {
                return SortedMap.newBuilder$(this);
            }

            public SortedMap<A, B> empty() {
                return SortedMap.empty$(this);
            }

            public <B1> SortedMap<A, B1> updated(A key, B1 value) {
                return SortedMap.updated$(this, key, value);
            }

            public SortedSet<A> keySet() {
                return SortedMap.keySet$(this);
            }

            public <B1> SortedMap<A, B1> $plus(Tuple2<A, B1> elem1, Tuple2<A, B1> elem2, Seq<Tuple2<A, B1>> elems) {
                return SortedMap.$plus$(this, elem1, elem2, elems);
            }

            public <B1> SortedMap<A, B1> $plus$plus(GenTraversableOnce<Tuple2<A, B1>> xs) {
                return SortedMap.$plus$plus$(this, xs);
            }

            public SortedMap<A, B> filterKeys(Function1<A, Object> p) {
                return SortedMap.filterKeys$(this, p);
            }

            public <C> SortedMap<A, C> mapValues(Function1<B, C> f) {
                return SortedMap.mapValues$(this, f);
            }

            public boolean equals(Object that) {
                return SortedMap.equals$(this, that);
            }

            public A firstKey() {
                return (A)SortedMapLike.firstKey$(this);
            }

            public A lastKey() {
                return (A)SortedMapLike.lastKey$(this);
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

            public <T, U> Map<T, U> toMap(Predef$.less.colon.less<Tuple2<A, B>, Tuple2<T, U>> ev) {
                return Map.toMap$(this, ev);
            }

            public Map<A, B> seq() {
                return Map.seq$(this);
            }

            public <V1> Map<A, V1> withDefault(Function1<A, V1> d) {
                return Map.withDefault$(this, d);
            }

            public <V1> Map<A, V1> withDefaultValue(V1 d) {
                return Map.withDefaultValue$(this, d);
            }

            public Combiner<Tuple2<A, B>, ParMap<A, B>> parCombiner() {
                return MapLike.parCombiner$(this);
            }

            public <W, That> That transform(Function2<A, B, W> f, CanBuildFrom<SortedMap<A, B>, Tuple2<A, W>, That> bf) {
                return (That)MapLike.transform$(this, f, bf);
            }

            public GenericCompanion<Iterable> companion() {
                return Iterable.companion$(this);
            }

            public Ordering<A> ordering() {
                return this.$outer.ordering();
            }

            public SortedMap<A, B> rangeImpl(Option<A> from, Option<A> until) {
                return ((SortedMap)this.$outer.rangeImpl(from, until)).filterKeys(this.p$1);
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
                Traversable.$init$(this);
                Iterable.$init$(this);
                MapLike.$init$(this);
                Map.$init$(this);
                Sorted.$init$(this);
                SortedMapLike.$init$(this);
                scala.collection.SortedMap.$init$(this);
                SortedMap.$init$(this);
                SortedMap.Default.$init$(this);
                Default.$init$(this);
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$iteratorFrom$1$adapted(scala.collection.immutable.SortedMap$$anon$1 scala.Tuple2 ), $anonfun$groupBy$1(scala.collection.TraversableLike scala.Function1 scala.collection.mutable.Map java.lang.Object ), $anonfun$groupBy$3$adapted(scala.Tuple2 ), $anonfun$groupBy$4(scala.collection.mutable.Builder scala.Tuple2 )}, serializedLambda);
            }
        };
    }

    public static /* synthetic */ SortedMap mapValues$(SortedMap $this, Function1 f) {
        return $this.mapValues(f);
    }

    @Override
    default public <C> SortedMap<A, C> mapValues(Function1<B, C> f) {
        return new Default<A, C>(this, f){
            private final /* synthetic */ SortedMap $outer;
            private final Function1 f$1;

            public <B1> SortedMap<A, B1> $plus(Tuple2<A, B1> kv) {
                return Default.$plus$(this, kv);
            }

            public SortedMap<A, C> $minus(A key) {
                return Default.$minus$(this, key);
            }

            public /* synthetic */ boolean scala$collection$immutable$SortedMap$$super$equals(Object that) {
                return GenMapLike.equals$(this, that);
            }

            public Builder<Tuple2<A, C>, SortedMap<A, C>> newBuilder() {
                return SortedMap.newBuilder$(this);
            }

            public SortedMap<A, C> empty() {
                return SortedMap.empty$(this);
            }

            public <B1> SortedMap<A, B1> updated(A key, B1 value) {
                return SortedMap.updated$(this, key, value);
            }

            public SortedSet<A> keySet() {
                return SortedMap.keySet$(this);
            }

            public <B1> SortedMap<A, B1> $plus(Tuple2<A, B1> elem1, Tuple2<A, B1> elem2, Seq<Tuple2<A, B1>> elems) {
                return SortedMap.$plus$(this, elem1, elem2, elems);
            }

            public <B1> SortedMap<A, B1> $plus$plus(GenTraversableOnce<Tuple2<A, B1>> xs) {
                return SortedMap.$plus$plus$(this, xs);
            }

            public SortedMap<A, C> filterKeys(Function1<A, Object> p) {
                return SortedMap.filterKeys$(this, p);
            }

            public <C> SortedMap<A, C> mapValues(Function1<C, C> f) {
                return SortedMap.mapValues$(this, f);
            }

            public boolean equals(Object that) {
                return SortedMap.equals$(this, that);
            }

            public A firstKey() {
                return (A)SortedMapLike.firstKey$(this);
            }

            public A lastKey() {
                return (A)SortedMapLike.lastKey$(this);
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

            public <T, U> Map<T, U> toMap(Predef$.less.colon.less<Tuple2<A, C>, Tuple2<T, U>> ev) {
                return Map.toMap$(this, ev);
            }

            public Map<A, C> seq() {
                return Map.seq$(this);
            }

            public <V1> Map<A, V1> withDefault(Function1<A, V1> d) {
                return Map.withDefault$(this, d);
            }

            public <V1> Map<A, V1> withDefaultValue(V1 d) {
                return Map.withDefaultValue$(this, d);
            }

            public Combiner<Tuple2<A, C>, ParMap<A, C>> parCombiner() {
                return MapLike.parCombiner$(this);
            }

            public <W, That> That transform(Function2<A, C, W> f, CanBuildFrom<SortedMap<A, C>, Tuple2<A, W>, That> bf) {
                return (That)MapLike.transform$(this, f, bf);
            }

            public GenericCompanion<Iterable> companion() {
                return Iterable.companion$(this);
            }

            public Ordering<A> ordering() {
                return this.$outer.ordering();
            }

            public SortedMap<A, C> rangeImpl(Option<A> from, Option<A> until) {
                return ((SortedMap)this.$outer.rangeImpl(from, until)).mapValues(this.f$1);
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
                Traversable.$init$(this);
                Iterable.$init$(this);
                MapLike.$init$(this);
                Map.$init$(this);
                Sorted.$init$(this);
                SortedMapLike.$init$(this);
                scala.collection.SortedMap.$init$(this);
                SortedMap.$init$(this);
                SortedMap.Default.$init$(this);
                Default.$init$(this);
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$iteratorFrom$2(scala.collection.immutable.SortedMap$$anon$2 scala.Tuple2 ), $anonfun$groupBy$1(scala.collection.TraversableLike scala.Function1 scala.collection.mutable.Map java.lang.Object ), $anonfun$groupBy$3$adapted(scala.Tuple2 ), $anonfun$groupBy$4(scala.collection.mutable.Builder scala.Tuple2 )}, serializedLambda);
            }
        };
    }

    public static /* synthetic */ boolean equals$(SortedMap $this, Object that) {
        return $this.equals(that);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    default public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (!(that instanceof SortedMap)) return this.scala$collection$immutable$SortedMap$$super$equals(that);
        SortedMap sortedMap = (SortedMap)that;
        Ordering ordering = sortedMap.ordering();
        Ordering ordering2 = this.ordering();
        if (ordering == null) {
            if (ordering2 != null) {
                return this.scala$collection$immutable$SortedMap$$super$equals(that);
            }
        } else if (!ordering.equals(ordering2)) return this.scala$collection$immutable$SortedMap$$super$equals(that);
        if (!sortedMap.canEqual(this)) return false;
        if (this.size() != sortedMap.size()) return false;
        Iterator i1 = this.iterator();
        Iterator i2 = sortedMap.iterator();
        boolean allEqual = true;
        while (allEqual && i1.hasNext()) {
            if (!BoxesRunTime.equals(i1.next(), i2.next())) return false;
            boolean bl = true;
            allEqual = bl;
        }
        if (!allEqual) return false;
        return true;
    }

    public static void $init$(SortedMap $this) {
    }

    public static interface Default<A, B>
    extends SortedMap<A, B>,
    SortedMap.Default<A, B> {
        public static /* synthetic */ SortedMap $plus$(Default $this, Tuple2 kv) {
            return $this.$plus(kv);
        }

        @Override
        default public <B1> SortedMap<A, B1> $plus(Tuple2<A, B1> kv) {
            Builder b = SortedMap$.MODULE$.newBuilder(this.ordering());
            b.$plus$plus$eq(this);
            b.$plus$eq(new Tuple2<A, B1>(kv._1(), kv._2()));
            return b.result();
        }

        public static /* synthetic */ SortedMap $minus$(Default $this, Object key) {
            return $this.$minus((A)key);
        }

        @Override
        default public SortedMap<A, B> $minus(A key) {
            Builder b = this.newBuilder();
            this.withFilter((Function1<Tuple2, Object> & java.io.Serializable & Serializable)kv -> BoxesRunTime.boxToBoolean(Default.$anonfun$$minus$1(key, kv))).foreach((Function1<Tuple2, Builder> & java.io.Serializable & Serializable)kv -> b.$plus$eq(kv));
            return b.result();
        }

        public static /* synthetic */ boolean $anonfun$$minus$1(Object key$1, Tuple2 kv) {
            return !BoxesRunTime.equals(kv._1(), key$1);
        }

        public static void $init$(Default $this) {
        }
    }

    public class DefaultKeySortedSet
    extends SortedMapLike.DefaultKeySortedSet
    implements SortedSet<A> {
        @Override
        public /* synthetic */ boolean scala$collection$immutable$SortedSet$$super$equals(Object that) {
            return GenSetLike.equals$(this, that);
        }

        @Override
        public SortedSet<A> empty() {
            return SortedSet.empty$(this);
        }

        @Override
        public boolean equals(Object that) {
            return SortedSet.equals$(this, that);
        }

        @Override
        public GenericCompanion<Set> companion() {
            return Set.companion$(this);
        }

        @Override
        public Set<A> seq() {
            return Set.seq$(this);
        }

        @Override
        public Combiner<A, ParSet<A>> parCombiner() {
            return Set.parCombiner$(this);
        }

        @Override
        public SortedSet<A> $plus(A elem) {
            if (this.apply(elem)) {
                return this;
            }
            return (SortedSet)SortedSet$.MODULE$.apply(Nil$.MODULE$, this.ordering()).$plus$plus(this).$plus(elem);
        }

        @Override
        public SortedSet<A> $minus(A elem) {
            if (this.apply(elem)) {
                return (SortedSet)SortedSet$.MODULE$.apply(Nil$.MODULE$, this.ordering()).$plus$plus(this).$minus(elem);
            }
            return this;
        }

        @Override
        public SortedSet<A> rangeImpl(Option<A> from, Option<A> until) {
            SortedMap map = (SortedMap)this.scala$collection$immutable$SortedMap$DefaultKeySortedSet$$$outer().rangeImpl(from, until);
            return new DefaultKeySortedSet(map);
        }

        @Override
        public <C> Set<C> toSet() {
            Builder sb = Set$.MODULE$.newBuilder();
            this.foreach((Function1<Object, Builder> & java.io.Serializable & Serializable)(K x$1) -> sb.$plus$eq(x$1));
            return sb.result();
        }

        public /* synthetic */ SortedMap scala$collection$immutable$SortedMap$DefaultKeySortedSet$$$outer() {
            return (SortedMap)this.$outer;
        }

        public DefaultKeySortedSet(SortedMap $outer) {
            super($outer);
            Traversable.$init$(this);
            Iterable.$init$(this);
            Set.$init$(this);
            SortedSet.$init$(this);
        }
    }
}

