/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Proxy;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.GenIterable;
import scala.collection.GenMapLike;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.IterableLike;
import scala.collection.IterableProxyLike;
import scala.collection.IterableView;
import scala.collection.Iterator;
import scala.collection.Map;
import scala.collection.MapLike;
import scala.collection.MapProxyLike;
import scala.collection.Parallel;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.Set;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.TraversableProxyLike;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.FilterMonadic;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.generic.Growable;
import scala.collection.generic.Shrinkable;
import scala.collection.generic.Subtractable;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.Cloneable;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.mutable.ParMap;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0005=aa\u0002\u0007\u000e!\u0003\r\t\u0001\u0006\u0005\u0006a\u0001!\t!\r\u0005\u0006k\u0001!IA\u000e\u0005\u0006\u0001\u0002!\t%\u0011\u0005\u0006\u0007\u0002!\t%\u0011\u0005\u0006\t\u0002!\t%\u0012\u0005\u0006\u001d\u0002!\te\u0014\u0005\u0006\u001d\u0002!\t%\u0017\u0005\u0006Q\u0002!\t%\u001b\u0005\u0006i\u0002!\t%\u001e\u0005\u0006o\u0002!\t\u0005\u001f\u0005\u0006y\u0002!\t% \u0002\t\u001b\u0006\u0004\bK]8ys*\u0011abD\u0001\b[V$\u0018M\u00197f\u0015\t\u0001\u0012#\u0001\u0006d_2dWm\u0019;j_:T\u0011AE\u0001\u0006g\u000e\fG.Y\u0002\u0001+\r)\u0002EK\n\u0005\u0001YQB\u0006\u0005\u0002\u001815\t\u0011#\u0003\u0002\u001a#\t1\u0011I\\=SK\u001a\u0004Ba\u0007\u000f\u001fS5\tQ\"\u0003\u0002\u001e\u001b\t\u0019Q*\u00199\u0011\u0005}\u0001C\u0002\u0001\u0003\u0006C\u0001\u0011\rA\t\u0002\u0002\u0003F\u00111E\n\t\u0003/\u0011J!!J\t\u0003\u000f9{G\u000f[5oOB\u0011qcJ\u0005\u0003QE\u00111!\u00118z!\ty\"\u0006B\u0003,\u0001\t\u0007!EA\u0001C!\u0015icFH\u0015\u001b\u001b\u0005y\u0011BA\u0018\u0010\u00051i\u0015\r\u001d)s_bLH*[6f\u0003\u0019!\u0013N\\5uIQ\t!\u0007\u0005\u0002\u0018g%\u0011A'\u0005\u0002\u0005+:LG/\u0001\u0005oK^\u0004&o\u001c=z+\t9$\b\u0006\u00029{A!1\u0004\u0001\u0010:!\ty\"\bB\u0003<\u0005\t\u0007AH\u0001\u0002CcE\u0011\u0011F\n\u0005\u0006}\t\u0001\raP\u0001\b]\u0016<8+\u001a7g!\u0011YBDH\u001d\u0002\tI,\u0007O]\u000b\u0002\u0005B!1\u0004\u0001\u0010*\u0003\u0015)W\u000e\u001d;z\u0003\u001d)\b\u000fZ1uK\u0012,\"AR%\u0015\u0007\u001dSE\n\u0005\u0003\u001c\u0001yA\u0005CA\u0010J\t\u0015YTA1\u0001=\u0011\u0015YU\u00011\u0001\u001f\u0003\rYW-\u001f\u0005\u0006\u001b\u0016\u0001\r\u0001S\u0001\u0006m\u0006dW/Z\u0001\u0006IAdWo]\u000b\u0003!N#\"!\u0015+\u0011\tmabD\u0015\t\u0003?M#Qa\u000f\u0004C\u0002qBQ!\u0016\u0004A\u0002Y\u000b!a\u001b<\u0011\t]9fDU\u0005\u00031F\u0011a\u0001V;qY\u0016\u0014TC\u0001.^)\u0011Yf,Y2\u0011\tm\u0001a\u0004\u0018\t\u0003?u#QaO\u0004C\u0002qBQaX\u0004A\u0002\u0001\fQ!\u001a7f[F\u0002BaF,\u001f9\")!m\u0002a\u0001A\u0006)Q\r\\3ne!)Am\u0002a\u0001K\u0006)Q\r\\3ngB\u0019qC\u001a1\n\u0005\u001d\f\"A\u0003\u001fsKB,\u0017\r^3e}\u0005QA\u0005\u001d7vg\u0012\u0002H.^:\u0016\u0005)lGCA6o!\u0011Y\u0002A\b7\u0011\u0005}iG!B\u001e\t\u0005\u0004a\u0004\"B8\t\u0001\u0004\u0001\u0018A\u0001=t!\ri\u0013o]\u0005\u0003e>\u0011!cR3o)J\fg/\u001a:tC\ndWm\u00148dKB!qc\u0016\u0010m\u0003\u0019!S.\u001b8vgR\u0011!I\u001e\u0005\u0006\u0017&\u0001\rAH\u0001\tIAdWo\u001d\u0013fcR\u0011\u0011P_\u0007\u0002\u0001!)QK\u0003a\u0001wB!qc\u0016\u0010*\u0003%!S.\u001b8vg\u0012*\u0017\u000f\u0006\u0002z}\")1j\u0003a\u0001=!:\u0001!!\u0001\u0002\b\u0005-\u0001cA\f\u0002\u0004%\u0019\u0011QA\t\u0003\u0015\u0011,\u0007O]3dCR,G-\t\u0002\u0002\n\u0005!\u0005O]8ys&tw\rI5tA\u0011,\u0007O]3dCR,G\r\t3vK\u0002\"x\u000e\t7bG.\u0004sN\u001a\u0011vg\u0016\u0004\u0013M\u001c3!G>l\u0007/\u001b7fe6bWM^3mAM,\b\u000f]8si\u0006\u0012\u0011QB\u0001\u0007e9\n\u0014G\f\u0019")
public interface MapProxy<A, B>
extends scala.collection.mutable.Map<A, B>,
MapProxyLike<A, B, scala.collection.mutable.Map<A, B>> {
    private <B1> MapProxy<A, B1> newProxy(scala.collection.mutable.Map<A, B1> newSelf) {
        return new MapProxy<A, B1>(null, newSelf){
            private final scala.collection.mutable.Map<A, B1> self;

            public MapProxy<A, B1> repr() {
                return MapProxy.repr$(this);
            }

            public MapProxy<A, B1> empty() {
                return MapProxy.empty$(this);
            }

            public <B1> MapProxy<A, B1> updated(A key, B1 value) {
                return MapProxy.updated$(this, key, value);
            }

            public <B1> scala.collection.mutable.Map<A, B1> $plus(Tuple2<A, B1> kv) {
                return MapProxy.$plus$(this, kv);
            }

            public <B1> MapProxy<A, B1> $plus(Tuple2<A, B1> elem1, Tuple2<A, B1> elem2, Seq<Tuple2<A, B1>> elems) {
                return MapProxy.$plus$(this, elem1, elem2, elems);
            }

            public <B1> MapProxy<A, B1> $plus$plus(GenTraversableOnce<Tuple2<A, B1>> xs) {
                return MapProxy.$plus$plus$(this, xs);
            }

            public MapProxy<A, B1> $minus(A key) {
                return MapProxy.$minus$(this, key);
            }

            public MapProxy<A, B1> $plus$eq(Tuple2<A, B1> kv) {
                return MapProxy.$plus$eq$(this, kv);
            }

            public MapProxy<A, B1> $minus$eq(A key) {
                return MapProxy.$minus$eq$(this, key);
            }

            public Option<B1> get(A key) {
                return MapProxyLike.get$(this, key);
            }

            public Iterator<Tuple2<A, B1>> iterator() {
                return MapProxyLike.iterator$(this);
            }

            public boolean isEmpty() {
                return MapProxyLike.isEmpty$(this);
            }

            public <B1> B1 getOrElse(A key, Function0<B1> function0) {
                return (B1)MapProxyLike.getOrElse$(this, key, function0);
            }

            public B1 apply(A key) {
                return (B1)MapProxyLike.apply$(this, key);
            }

            public boolean contains(A key) {
                return MapProxyLike.contains$(this, key);
            }

            public boolean isDefinedAt(A key) {
                return MapProxyLike.isDefinedAt$(this, key);
            }

            public Set<A> keySet() {
                return MapProxyLike.keySet$(this);
            }

            public Iterator<A> keysIterator() {
                return MapProxyLike.keysIterator$(this);
            }

            public Iterable<A> keys() {
                return MapProxyLike.keys$(this);
            }

            public Iterable<B1> values() {
                return MapProxyLike.values$(this);
            }

            public Iterator<B1> valuesIterator() {
                return MapProxyLike.valuesIterator$(this);
            }

            public B1 default(A key) {
                return (B1)MapProxyLike.default$(this, key);
            }

            public Map<A, B1> filterKeys(Function1<A, Object> p) {
                return MapProxyLike.filterKeys$(this, p);
            }

            public <C> Map<A, C> mapValues(Function1<B1, C> f) {
                return MapProxyLike.mapValues$(this, f);
            }

            public Map filterNot(Function1 p) {
                return MapProxyLike.filterNot$(this, p);
            }

            public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
                return MapProxyLike.addString$(this, b, start, sep, end);
            }

            public Iterator<scala.collection.mutable.Map<A, B1>> grouped(int size) {
                return IterableProxyLike.grouped$(this, size);
            }

            public Iterator<scala.collection.mutable.Map<A, B1>> sliding(int size) {
                return IterableProxyLike.sliding$(this, size);
            }

            public Iterator<scala.collection.mutable.Map<A, B1>> sliding(int size, int step) {
                return IterableProxyLike.sliding$(this, size, step);
            }

            public Iterable takeRight(int n) {
                return IterableProxyLike.takeRight$(this, n);
            }

            public Iterable dropRight(int n) {
                return IterableProxyLike.dropRight$(this, n);
            }

            public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<scala.collection.mutable.Map<A, B1>, Tuple2<A1, B>, That> bf) {
                return (That)IterableProxyLike.zip$(this, that, bf);
            }

            public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<scala.collection.mutable.Map<A, B1>, Tuple2<A1, B>, That> bf) {
                return (That)IterableProxyLike.zipAll$(this, that, thisElem, thatElem, bf);
            }

            public <A1, That> That zipWithIndex(CanBuildFrom<scala.collection.mutable.Map<A, B1>, Tuple2<A1, Object>, That> bf) {
                return (That)IterableProxyLike.zipWithIndex$(this, bf);
            }

            public <B> boolean sameElements(GenIterable<B> that) {
                return IterableProxyLike.sameElements$(this, that);
            }

            public IterableView<Tuple2<A, B1>, scala.collection.mutable.Map<A, B1>> view() {
                return IterableProxyLike.view$(this);
            }

            public IterableView<Tuple2<A, B1>, scala.collection.mutable.Map<A, B1>> view(int from, int until) {
                return IterableProxyLike.view$(this, from, until);
            }

            public <U> void foreach(Function1<Tuple2<A, B1>, U> f) {
                TraversableProxyLike.foreach$(this, f);
            }

            public boolean nonEmpty() {
                return TraversableProxyLike.nonEmpty$(this);
            }

            public int size() {
                return TraversableProxyLike.size$(this);
            }

            public boolean hasDefiniteSize() {
                return TraversableProxyLike.hasDefiniteSize$(this);
            }

            public <B, That> That $plus$plus(GenTraversableOnce<B> xs, CanBuildFrom<scala.collection.mutable.Map<A, B1>, B, That> bf) {
                return (That)TraversableProxyLike.$plus$plus$(this, xs, bf);
            }

            public <B, That> That map(Function1<Tuple2<A, B1>, B> f, CanBuildFrom<scala.collection.mutable.Map<A, B1>, B, That> bf) {
                return (That)TraversableProxyLike.map$(this, f, bf);
            }

            public <B, That> That flatMap(Function1<Tuple2<A, B1>, GenTraversableOnce<B>> f, CanBuildFrom<scala.collection.mutable.Map<A, B1>, B, That> bf) {
                return (That)TraversableProxyLike.flatMap$(this, f, bf);
            }

            public Traversable filter(Function1 p) {
                return TraversableProxyLike.filter$(this, p);
            }

            public <B, That> That collect(PartialFunction<Tuple2<A, B1>, B> pf, CanBuildFrom<scala.collection.mutable.Map<A, B1>, B, That> bf) {
                return (That)TraversableProxyLike.collect$(this, pf, bf);
            }

            public Tuple2<scala.collection.mutable.Map<A, B1>, scala.collection.mutable.Map<A, B1>> partition(Function1<Tuple2<A, B1>, Object> p) {
                return TraversableProxyLike.partition$(this, p);
            }

            public <K> scala.collection.immutable.Map<K, scala.collection.mutable.Map<A, B1>> groupBy(Function1<Tuple2<A, B1>, K> f) {
                return TraversableProxyLike.groupBy$(this, f);
            }

            public boolean forall(Function1<Tuple2<A, B1>, Object> p) {
                return TraversableProxyLike.forall$(this, p);
            }

            public boolean exists(Function1<Tuple2<A, B1>, Object> p) {
                return TraversableProxyLike.exists$(this, p);
            }

            public int count(Function1<Tuple2<A, B1>, Object> p) {
                return TraversableProxyLike.count$(this, p);
            }

            public Option<Tuple2<A, B1>> find(Function1<Tuple2<A, B1>, Object> p) {
                return TraversableProxyLike.find$(this, p);
            }

            public <B> B foldLeft(B z, Function2<B, Tuple2<A, B1>, B> op) {
                return (B)TraversableProxyLike.foldLeft$(this, z, op);
            }

            public <B> B $div$colon(B z, Function2<B, Tuple2<A, B1>, B> op) {
                return (B)TraversableProxyLike.$div$colon$(this, z, op);
            }

            public <B> B foldRight(B z, Function2<Tuple2<A, B1>, B, B> op) {
                return (B)TraversableProxyLike.foldRight$(this, z, op);
            }

            public <B> B $colon$bslash(B z, Function2<Tuple2<A, B1>, B, B> op) {
                return (B)TraversableProxyLike.$colon$bslash$(this, z, op);
            }

            public <B> B reduceLeft(Function2<B, Tuple2<A, B1>, B> op) {
                return (B)TraversableProxyLike.reduceLeft$(this, op);
            }

            public <B> Option<B> reduceLeftOption(Function2<B, Tuple2<A, B1>, B> op) {
                return TraversableProxyLike.reduceLeftOption$(this, op);
            }

            public <B> B reduceRight(Function2<Tuple2<A, B1>, B, B> op) {
                return (B)TraversableProxyLike.reduceRight$(this, op);
            }

            public <B> Option<B> reduceRightOption(Function2<Tuple2<A, B1>, B, B> op) {
                return TraversableProxyLike.reduceRightOption$(this, op);
            }

            public <B, That> That scanLeft(B z, Function2<B, Tuple2<A, B1>, B> op, CanBuildFrom<scala.collection.mutable.Map<A, B1>, B, That> bf) {
                return (That)TraversableProxyLike.scanLeft$(this, z, op, bf);
            }

            public <B, That> That scanRight(B z, Function2<Tuple2<A, B1>, B, B> op, CanBuildFrom<scala.collection.mutable.Map<A, B1>, B, That> bf) {
                return (That)TraversableProxyLike.scanRight$(this, z, op, bf);
            }

            public <B> B sum(Numeric<B> num) {
                return (B)TraversableProxyLike.sum$(this, num);
            }

            public <B> B product(Numeric<B> num) {
                return (B)TraversableProxyLike.product$(this, num);
            }

            public Object min(Ordering cmp) {
                return TraversableProxyLike.min$(this, cmp);
            }

            public Object max(Ordering cmp) {
                return TraversableProxyLike.max$(this, cmp);
            }

            public Object head() {
                return TraversableProxyLike.head$(this);
            }

            public Option<Tuple2<A, B1>> headOption() {
                return TraversableProxyLike.headOption$(this);
            }

            public Traversable tail() {
                return TraversableProxyLike.tail$(this);
            }

            public Object last() {
                return TraversableProxyLike.last$(this);
            }

            public Option<Tuple2<A, B1>> lastOption() {
                return TraversableProxyLike.lastOption$(this);
            }

            public Traversable init() {
                return TraversableProxyLike.init$(this);
            }

            public Traversable take(int n) {
                return TraversableProxyLike.take$(this, n);
            }

            public Traversable drop(int n) {
                return TraversableProxyLike.drop$(this, n);
            }

            public Traversable slice(int from, int until) {
                return TraversableProxyLike.slice$(this, from, until);
            }

            public Traversable takeWhile(Function1 p) {
                return TraversableProxyLike.takeWhile$(this, p);
            }

            public Traversable dropWhile(Function1 p) {
                return TraversableProxyLike.dropWhile$(this, p);
            }

            public Tuple2<scala.collection.mutable.Map<A, B1>, scala.collection.mutable.Map<A, B1>> span(Function1<Tuple2<A, B1>, Object> p) {
                return TraversableProxyLike.span$(this, p);
            }

            public Tuple2<scala.collection.mutable.Map<A, B1>, scala.collection.mutable.Map<A, B1>> splitAt(int n) {
                return TraversableProxyLike.splitAt$(this, n);
            }

            public <B> void copyToBuffer(Buffer<B> dest) {
                TraversableProxyLike.copyToBuffer$(this, dest);
            }

            public <B> void copyToArray(Object xs, int start, int len) {
                TraversableProxyLike.copyToArray$(this, xs, start, len);
            }

            public <B> void copyToArray(Object xs, int start) {
                TraversableProxyLike.copyToArray$(this, xs, start);
            }

            public <B> void copyToArray(Object xs) {
                TraversableProxyLike.copyToArray$(this, xs);
            }

            public <B> Object toArray(ClassTag<B> evidence$1) {
                return TraversableProxyLike.toArray$(this, evidence$1);
            }

            public List<Tuple2<A, B1>> toList() {
                return TraversableProxyLike.toList$(this);
            }

            public Iterable<Tuple2<A, B1>> toIterable() {
                return TraversableProxyLike.toIterable$(this);
            }

            public Seq<Tuple2<A, B1>> toSeq() {
                return TraversableProxyLike.toSeq$(this);
            }

            public IndexedSeq<Tuple2<A, B1>> toIndexedSeq() {
                return TraversableProxyLike.toIndexedSeq$(this);
            }

            public <B> Buffer<B> toBuffer() {
                return TraversableProxyLike.toBuffer$(this);
            }

            public Stream<Tuple2<A, B1>> toStream() {
                return TraversableProxyLike.toStream$(this);
            }

            public <B> scala.collection.immutable.Set<B> toSet() {
                return TraversableProxyLike.toSet$(this);
            }

            public <T, U> scala.collection.immutable.Map<T, U> toMap(Predef$.less.colon.less<Tuple2<A, B1>, Tuple2<T, U>> ev) {
                return TraversableProxyLike.toMap$(this, ev);
            }

            public Traversable<Tuple2<A, B1>> toTraversable() {
                return TraversableProxyLike.toTraversable$(this);
            }

            public Iterator<Tuple2<A, B1>> toIterator() {
                return TraversableProxyLike.toIterator$(this);
            }

            public String mkString(String start, String sep, String end) {
                return TraversableProxyLike.mkString$(this, start, sep, end);
            }

            public String mkString(String sep) {
                return TraversableProxyLike.mkString$(this, sep);
            }

            public String mkString() {
                return TraversableProxyLike.mkString$(this);
            }

            public StringBuilder addString(StringBuilder b, String sep) {
                return TraversableProxyLike.addString$(this, b, sep);
            }

            public StringBuilder addString(StringBuilder b) {
                return TraversableProxyLike.addString$(this, b);
            }

            public String stringPrefix() {
                return TraversableProxyLike.stringPrefix$(this);
            }

            public int hashCode() {
                return Proxy.hashCode$(this);
            }

            public boolean equals(Object that) {
                return Proxy.equals$(this, that);
            }

            public String toString() {
                return Proxy.toString$(this);
            }

            public scala.collection.mutable.Map<A, B1> seq() {
                return scala.collection.mutable.Map.seq$(this);
            }

            public scala.collection.mutable.Map<A, B1> withDefault(Function1<A, B1> d) {
                return scala.collection.mutable.Map.withDefault$(this, d);
            }

            public scala.collection.mutable.Map<A, B1> withDefaultValue(B1 d) {
                return scala.collection.mutable.Map.withDefaultValue$(this, d);
            }

            public Builder<Tuple2<A, B1>, scala.collection.mutable.Map<A, B1>> newBuilder() {
                return scala.collection.mutable.MapLike.newBuilder$(this);
            }

            public Combiner<Tuple2<A, B1>, ParMap<A, B1>> parCombiner() {
                return scala.collection.mutable.MapLike.parCombiner$(this);
            }

            public Option<B1> put(A key, B1 value) {
                return scala.collection.mutable.MapLike.put$(this, key, value);
            }

            public void update(A key, B1 value) {
                scala.collection.mutable.MapLike.update$(this, key, value);
            }

            public Option<B1> remove(A key) {
                return scala.collection.mutable.MapLike.remove$(this, key);
            }

            public void clear() {
                scala.collection.mutable.MapLike.clear$(this);
            }

            public B1 getOrElseUpdate(A key, Function0<B1> op) {
                return (B1)scala.collection.mutable.MapLike.getOrElseUpdate$(this, key, op);
            }

            public scala.collection.mutable.MapLike<A, B1, scala.collection.mutable.Map<A, B1>> transform(Function2<A, B1, B1> f) {
                return scala.collection.mutable.MapLike.transform$(this, f);
            }

            public scala.collection.mutable.MapLike<A, B1, scala.collection.mutable.Map<A, B1>> retain(Function2<A, B1, Object> p) {
                return scala.collection.mutable.MapLike.retain$(this, p);
            }

            public scala.collection.mutable.Map<A, B1> clone() {
                return scala.collection.mutable.MapLike.clone$(this);
            }

            public scala.collection.mutable.Map<A, B1> result() {
                return scala.collection.mutable.MapLike.result$(this);
            }

            public scala.collection.mutable.Map<A, B1> $minus(A elem1, A elem2, Seq<A> elems) {
                return scala.collection.mutable.MapLike.$minus$(this, elem1, elem2, elems);
            }

            public scala.collection.mutable.Map<A, B1> $minus$minus(GenTraversableOnce<A> xs) {
                return scala.collection.mutable.MapLike.$minus$minus$(this, xs);
            }

            public /* synthetic */ Object scala$collection$mutable$Cloneable$$super$clone() {
                return super.clone();
            }

            public Shrinkable<A> $minus$eq(A elem1, A elem2, Seq<A> elems) {
                return Shrinkable.$minus$eq$(this, elem1, elem2, elems);
            }

            public Shrinkable<A> $minus$minus$eq(TraversableOnce<A> xs) {
                return Shrinkable.$minus$minus$eq$(this, xs);
            }

            public void sizeHint(int size) {
                Builder.sizeHint$((Builder)this, size);
            }

            public void sizeHint(TraversableLike<?, ?> coll) {
                Builder.sizeHint$((Builder)this, coll);
            }

            public void sizeHint(TraversableLike<?, ?> coll, int delta) {
                Builder.sizeHint$(this, coll, delta);
            }

            public void sizeHintBounded(int size, TraversableLike<?, ?> boundingColl) {
                Builder.sizeHintBounded$(this, size, boundingColl);
            }

            public <NewTo> Builder<Tuple2<A, B1>, NewTo> mapResult(Function1<scala.collection.mutable.Map<A, B1>, NewTo> f) {
                return Builder.mapResult$(this, f);
            }

            public Growable $plus$eq(Object elem1, Object elem2, Seq elems) {
                return Growable.$plus$eq$(this, elem1, elem2, elems);
            }

            public Growable<Tuple2<A, B1>> $plus$plus$eq(TraversableOnce<Tuple2<A, B1>> xs) {
                return Growable.$plus$plus$eq$(this, xs);
            }

            public <K1 extends A, V1> V1 applyOrElse(K1 x, Function1<K1, V1> function1) {
                return (V1)MapLike.applyOrElse$(this, x, function1);
            }

            public <A1 extends A, B1> PartialFunction<A1, B1> orElse(PartialFunction<A1, B1> that) {
                return PartialFunction.orElse$(this, that);
            }

            public <C> PartialFunction<A, C> andThen(Function1<B1, C> k) {
                return PartialFunction.andThen$(this, k);
            }

            public Function1<A, Option<B1>> lift() {
                return PartialFunction.lift$(this);
            }

            public <U> Function1<A, Object> runWith(Function1<B1, U> action) {
                return PartialFunction.runWith$(this, action);
            }

            public boolean apply$mcZD$sp(double v1) {
                return Function1.apply$mcZD$sp$(this, v1);
            }

            public double apply$mcDD$sp(double v1) {
                return Function1.apply$mcDD$sp$(this, v1);
            }

            public float apply$mcFD$sp(double v1) {
                return Function1.apply$mcFD$sp$(this, v1);
            }

            public int apply$mcID$sp(double v1) {
                return Function1.apply$mcID$sp$(this, v1);
            }

            public long apply$mcJD$sp(double v1) {
                return Function1.apply$mcJD$sp$(this, v1);
            }

            public void apply$mcVD$sp(double v1) {
                Function1.apply$mcVD$sp$(this, v1);
            }

            public boolean apply$mcZF$sp(float v1) {
                return Function1.apply$mcZF$sp$(this, v1);
            }

            public double apply$mcDF$sp(float v1) {
                return Function1.apply$mcDF$sp$(this, v1);
            }

            public float apply$mcFF$sp(float v1) {
                return Function1.apply$mcFF$sp$(this, v1);
            }

            public int apply$mcIF$sp(float v1) {
                return Function1.apply$mcIF$sp$(this, v1);
            }

            public long apply$mcJF$sp(float v1) {
                return Function1.apply$mcJF$sp$(this, v1);
            }

            public void apply$mcVF$sp(float v1) {
                Function1.apply$mcVF$sp$(this, v1);
            }

            public boolean apply$mcZI$sp(int v1) {
                return Function1.apply$mcZI$sp$(this, v1);
            }

            public double apply$mcDI$sp(int v1) {
                return Function1.apply$mcDI$sp$(this, v1);
            }

            public float apply$mcFI$sp(int v1) {
                return Function1.apply$mcFI$sp$(this, v1);
            }

            public int apply$mcII$sp(int v1) {
                return Function1.apply$mcII$sp$(this, v1);
            }

            public long apply$mcJI$sp(int v1) {
                return Function1.apply$mcJI$sp$(this, v1);
            }

            public void apply$mcVI$sp(int v1) {
                Function1.apply$mcVI$sp$(this, v1);
            }

            public boolean apply$mcZJ$sp(long v1) {
                return Function1.apply$mcZJ$sp$(this, v1);
            }

            public double apply$mcDJ$sp(long v1) {
                return Function1.apply$mcDJ$sp$(this, v1);
            }

            public float apply$mcFJ$sp(long v1) {
                return Function1.apply$mcFJ$sp$(this, v1);
            }

            public int apply$mcIJ$sp(long v1) {
                return Function1.apply$mcIJ$sp$(this, v1);
            }

            public long apply$mcJJ$sp(long v1) {
                return Function1.apply$mcJJ$sp$(this, v1);
            }

            public void apply$mcVJ$sp(long v1) {
                Function1.apply$mcVJ$sp$(this, v1);
            }

            public <A> Function1<A, B1> compose(Function1<A, A> g) {
                return Function1.compose$(this, g);
            }

            public GenericCompanion<scala.collection.mutable.Iterable> companion() {
                return scala.collection.mutable.Iterable.companion$(this);
            }

            public Iterable<Tuple2<A, B1>> thisCollection() {
                return IterableLike.thisCollection$(this);
            }

            public Iterable toCollection(Object repr) {
                return IterableLike.toCollection$(this, repr);
            }

            public boolean canEqual(Object that) {
                return IterableLike.canEqual$(this, that);
            }

            public <B> Builder<B, scala.collection.mutable.Iterable<B>> genericBuilder() {
                return GenericTraversableTemplate.genericBuilder$(this);
            }

            public <A1, A2> Tuple2<scala.collection.mutable.Iterable<A1>, scala.collection.mutable.Iterable<A2>> unzip(Function1<Tuple2<A, B1>, Tuple2<A1, A2>> asPair) {
                return GenericTraversableTemplate.unzip$(this, asPair);
            }

            public <A1, A2, A3> Tuple3<scala.collection.mutable.Iterable<A1>, scala.collection.mutable.Iterable<A2>, scala.collection.mutable.Iterable<A3>> unzip3(Function1<Tuple2<A, B1>, Tuple3<A1, A2, A3>> asTriple) {
                return GenericTraversableTemplate.unzip3$(this, asTriple);
            }

            public GenTraversable flatten(Function1 asTraversable) {
                return GenericTraversableTemplate.flatten$(this, asTraversable);
            }

            public GenTraversable transpose(Function1 asTraversable) {
                return GenericTraversableTemplate.transpose$(this, asTraversable);
            }

            public final boolean isTraversableAgain() {
                return TraversableLike.isTraversableAgain$(this);
            }

            public <B, That> That $plus$plus$colon(TraversableOnce<B> that, CanBuildFrom<scala.collection.mutable.Map<A, B1>, B, That> bf) {
                return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
            }

            public <B, That> That $plus$plus$colon(Traversable<B> that, CanBuildFrom<scala.collection.mutable.Map<A, B1>, B, That> bf) {
                return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
            }

            public Object filterImpl(Function1 p, boolean isFlipped) {
                return TraversableLike.filterImpl$(this, p, isFlipped);
            }

            public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<scala.collection.mutable.Map<A, B1>, B, That> cbf) {
                return (That)TraversableLike.scan$(this, z, op, cbf);
            }

            public Object sliceWithKnownDelta(int from, int until, int delta) {
                return TraversableLike.sliceWithKnownDelta$(this, from, until, delta);
            }

            public Object sliceWithKnownBound(int from, int until) {
                return TraversableLike.sliceWithKnownBound$(this, from, until);
            }

            public Iterator<scala.collection.mutable.Map<A, B1>> tails() {
                return TraversableLike.tails$(this);
            }

            public Iterator<scala.collection.mutable.Map<A, B1>> inits() {
                return TraversableLike.inits$(this);
            }

            public <Col> Col to(CanBuildFrom<Nothing$, Tuple2<A, B1>, Col> cbf) {
                return (Col)TraversableLike.to$(this, cbf);
            }

            public FilterMonadic<Tuple2<A, B1>, scala.collection.mutable.Map<A, B1>> withFilter(Function1<Tuple2<A, B1>, Object> p) {
                return TraversableLike.withFilter$(this, p);
            }

            public Parallel par() {
                return Parallelizable.par$(this);
            }

            public List<Tuple2<A, B1>> reversed() {
                return TraversableOnce.reversed$(this);
            }

            public <B> Option<B> collectFirst(PartialFunction<Tuple2<A, B1>, B> pf) {
                return TraversableOnce.collectFirst$(this, pf);
            }

            public <A1> A1 reduce(Function2<A1, A1, A1> op) {
                return (A1)TraversableOnce.reduce$(this, op);
            }

            public <A1> Option<A1> reduceOption(Function2<A1, A1, A1> op) {
                return TraversableOnce.reduceOption$(this, op);
            }

            public <A1> A1 fold(A1 z, Function2<A1, A1, A1> op) {
                return (A1)TraversableOnce.fold$(this, z, op);
            }

            public <B> B aggregate(Function0<B> z, Function2<B, Tuple2<A, B1>, B> seqop, Function2<B, B, B> combop) {
                return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
            }

            public Object maxBy(Function1 f, Ordering cmp) {
                return TraversableOnce.maxBy$(this, f, cmp);
            }

            public Object minBy(Function1 f, Ordering cmp) {
                return TraversableOnce.minBy$(this, f, cmp);
            }

            public Vector<Tuple2<A, B1>> toVector() {
                return TraversableOnce.toVector$(this);
            }

            public int sizeHintIfCheap() {
                return GenTraversableOnce.sizeHintIfCheap$(this);
            }

            public scala.collection.mutable.Map<A, B1> self() {
                return this.self;
            }
            {
                GenTraversableOnce.$init$(this);
                TraversableOnce.$init$(this);
                Parallelizable.$init$(this);
                TraversableLike.$init$(this);
                GenericTraversableTemplate.$init$(this);
                GenTraversable.$init$(this);
                Traversable.$init$(this);
                scala.collection.mutable.Traversable.$init$(this);
                GenIterable.$init$(this);
                IterableLike.$init$(this);
                Iterable.$init$(this);
                scala.collection.mutable.Iterable.$init$(this);
                GenMapLike.$init$(this);
                PartialFunction.$init$(this);
                Subtractable.$init$(this);
                MapLike.$init$(this);
                Map.$init$(this);
                Growable.$init$(this);
                Builder.$init$(this);
                Shrinkable.$init$(this);
                Cloneable.$init$(this);
                scala.collection.mutable.MapLike.$init$(this);
                scala.collection.mutable.Map.$init$(this);
                Proxy.$init$(this);
                TraversableProxyLike.$init$(this);
                IterableProxyLike.$init$(this);
                MapProxyLike.$init$(this);
                MapProxy.$init$(this);
                this.self = newSelf$1;
            }
        };
    }

    public static /* synthetic */ MapProxy repr$(MapProxy $this) {
        return $this.repr();
    }

    @Override
    default public MapProxy<A, B> repr() {
        return this;
    }

    public static /* synthetic */ MapProxy empty$(MapProxy $this) {
        return $this.empty();
    }

    @Override
    default public MapProxy<A, B> empty() {
        return new MapProxy<A, B>(this){
            private final scala.collection.mutable.Map<A, B> self;

            public MapProxy<A, B> repr() {
                return MapProxy.repr$(this);
            }

            public MapProxy<A, B> empty() {
                return MapProxy.empty$(this);
            }

            public <B1> MapProxy<A, B1> updated(A key, B1 value) {
                return MapProxy.updated$(this, key, value);
            }

            public <B1> scala.collection.mutable.Map<A, B1> $plus(Tuple2<A, B1> kv) {
                return MapProxy.$plus$(this, kv);
            }

            public <B1> MapProxy<A, B1> $plus(Tuple2<A, B1> elem1, Tuple2<A, B1> elem2, Seq<Tuple2<A, B1>> elems) {
                return MapProxy.$plus$(this, elem1, elem2, elems);
            }

            public <B1> MapProxy<A, B1> $plus$plus(GenTraversableOnce<Tuple2<A, B1>> xs) {
                return MapProxy.$plus$plus$(this, xs);
            }

            public MapProxy<A, B> $minus(A key) {
                return MapProxy.$minus$(this, key);
            }

            public MapProxy<A, B> $plus$eq(Tuple2<A, B> kv) {
                return MapProxy.$plus$eq$(this, kv);
            }

            public MapProxy<A, B> $minus$eq(A key) {
                return MapProxy.$minus$eq$(this, key);
            }

            public Option<B> get(A key) {
                return MapProxyLike.get$(this, key);
            }

            public Iterator<Tuple2<A, B>> iterator() {
                return MapProxyLike.iterator$(this);
            }

            public boolean isEmpty() {
                return MapProxyLike.isEmpty$(this);
            }

            public <B1> B1 getOrElse(A key, Function0<B1> function0) {
                return (B1)MapProxyLike.getOrElse$(this, key, function0);
            }

            public B apply(A key) {
                return (B)MapProxyLike.apply$(this, key);
            }

            public boolean contains(A key) {
                return MapProxyLike.contains$(this, key);
            }

            public boolean isDefinedAt(A key) {
                return MapProxyLike.isDefinedAt$(this, key);
            }

            public Set<A> keySet() {
                return MapProxyLike.keySet$(this);
            }

            public Iterator<A> keysIterator() {
                return MapProxyLike.keysIterator$(this);
            }

            public Iterable<A> keys() {
                return MapProxyLike.keys$(this);
            }

            public Iterable<B> values() {
                return MapProxyLike.values$(this);
            }

            public Iterator<B> valuesIterator() {
                return MapProxyLike.valuesIterator$(this);
            }

            public B default(A key) {
                return (B)MapProxyLike.default$(this, key);
            }

            public Map<A, B> filterKeys(Function1<A, Object> p) {
                return MapProxyLike.filterKeys$(this, p);
            }

            public <C> Map<A, C> mapValues(Function1<B, C> f) {
                return MapProxyLike.mapValues$(this, f);
            }

            public Map filterNot(Function1 p) {
                return MapProxyLike.filterNot$(this, p);
            }

            public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
                return MapProxyLike.addString$(this, b, start, sep, end);
            }

            public Iterator<scala.collection.mutable.Map<A, B>> grouped(int size) {
                return IterableProxyLike.grouped$(this, size);
            }

            public Iterator<scala.collection.mutable.Map<A, B>> sliding(int size) {
                return IterableProxyLike.sliding$(this, size);
            }

            public Iterator<scala.collection.mutable.Map<A, B>> sliding(int size, int step) {
                return IterableProxyLike.sliding$(this, size, step);
            }

            public Iterable takeRight(int n) {
                return IterableProxyLike.takeRight$(this, n);
            }

            public Iterable dropRight(int n) {
                return IterableProxyLike.dropRight$(this, n);
            }

            public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<scala.collection.mutable.Map<A, B>, Tuple2<A1, B>, That> bf) {
                return (That)IterableProxyLike.zip$(this, that, bf);
            }

            public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<scala.collection.mutable.Map<A, B>, Tuple2<A1, B>, That> bf) {
                return (That)IterableProxyLike.zipAll$(this, that, thisElem, thatElem, bf);
            }

            public <A1, That> That zipWithIndex(CanBuildFrom<scala.collection.mutable.Map<A, B>, Tuple2<A1, Object>, That> bf) {
                return (That)IterableProxyLike.zipWithIndex$(this, bf);
            }

            public <B> boolean sameElements(GenIterable<B> that) {
                return IterableProxyLike.sameElements$(this, that);
            }

            public IterableView<Tuple2<A, B>, scala.collection.mutable.Map<A, B>> view() {
                return IterableProxyLike.view$(this);
            }

            public IterableView<Tuple2<A, B>, scala.collection.mutable.Map<A, B>> view(int from, int until) {
                return IterableProxyLike.view$(this, from, until);
            }

            public <U> void foreach(Function1<Tuple2<A, B>, U> f) {
                TraversableProxyLike.foreach$(this, f);
            }

            public boolean nonEmpty() {
                return TraversableProxyLike.nonEmpty$(this);
            }

            public int size() {
                return TraversableProxyLike.size$(this);
            }

            public boolean hasDefiniteSize() {
                return TraversableProxyLike.hasDefiniteSize$(this);
            }

            public <B, That> That $plus$plus(GenTraversableOnce<B> xs, CanBuildFrom<scala.collection.mutable.Map<A, B>, B, That> bf) {
                return (That)TraversableProxyLike.$plus$plus$(this, xs, bf);
            }

            public <B, That> That map(Function1<Tuple2<A, B>, B> f, CanBuildFrom<scala.collection.mutable.Map<A, B>, B, That> bf) {
                return (That)TraversableProxyLike.map$(this, f, bf);
            }

            public <B, That> That flatMap(Function1<Tuple2<A, B>, GenTraversableOnce<B>> f, CanBuildFrom<scala.collection.mutable.Map<A, B>, B, That> bf) {
                return (That)TraversableProxyLike.flatMap$(this, f, bf);
            }

            public Traversable filter(Function1 p) {
                return TraversableProxyLike.filter$(this, p);
            }

            public <B, That> That collect(PartialFunction<Tuple2<A, B>, B> pf, CanBuildFrom<scala.collection.mutable.Map<A, B>, B, That> bf) {
                return (That)TraversableProxyLike.collect$(this, pf, bf);
            }

            public Tuple2<scala.collection.mutable.Map<A, B>, scala.collection.mutable.Map<A, B>> partition(Function1<Tuple2<A, B>, Object> p) {
                return TraversableProxyLike.partition$(this, p);
            }

            public <K> scala.collection.immutable.Map<K, scala.collection.mutable.Map<A, B>> groupBy(Function1<Tuple2<A, B>, K> f) {
                return TraversableProxyLike.groupBy$(this, f);
            }

            public boolean forall(Function1<Tuple2<A, B>, Object> p) {
                return TraversableProxyLike.forall$(this, p);
            }

            public boolean exists(Function1<Tuple2<A, B>, Object> p) {
                return TraversableProxyLike.exists$(this, p);
            }

            public int count(Function1<Tuple2<A, B>, Object> p) {
                return TraversableProxyLike.count$(this, p);
            }

            public Option<Tuple2<A, B>> find(Function1<Tuple2<A, B>, Object> p) {
                return TraversableProxyLike.find$(this, p);
            }

            public <B> B foldLeft(B z, Function2<B, Tuple2<A, B>, B> op) {
                return (B)TraversableProxyLike.foldLeft$(this, z, op);
            }

            public <B> B $div$colon(B z, Function2<B, Tuple2<A, B>, B> op) {
                return (B)TraversableProxyLike.$div$colon$(this, z, op);
            }

            public <B> B foldRight(B z, Function2<Tuple2<A, B>, B, B> op) {
                return (B)TraversableProxyLike.foldRight$(this, z, op);
            }

            public <B> B $colon$bslash(B z, Function2<Tuple2<A, B>, B, B> op) {
                return (B)TraversableProxyLike.$colon$bslash$(this, z, op);
            }

            public <B> B reduceLeft(Function2<B, Tuple2<A, B>, B> op) {
                return (B)TraversableProxyLike.reduceLeft$(this, op);
            }

            public <B> Option<B> reduceLeftOption(Function2<B, Tuple2<A, B>, B> op) {
                return TraversableProxyLike.reduceLeftOption$(this, op);
            }

            public <B> B reduceRight(Function2<Tuple2<A, B>, B, B> op) {
                return (B)TraversableProxyLike.reduceRight$(this, op);
            }

            public <B> Option<B> reduceRightOption(Function2<Tuple2<A, B>, B, B> op) {
                return TraversableProxyLike.reduceRightOption$(this, op);
            }

            public <B, That> That scanLeft(B z, Function2<B, Tuple2<A, B>, B> op, CanBuildFrom<scala.collection.mutable.Map<A, B>, B, That> bf) {
                return (That)TraversableProxyLike.scanLeft$(this, z, op, bf);
            }

            public <B, That> That scanRight(B z, Function2<Tuple2<A, B>, B, B> op, CanBuildFrom<scala.collection.mutable.Map<A, B>, B, That> bf) {
                return (That)TraversableProxyLike.scanRight$(this, z, op, bf);
            }

            public <B> B sum(Numeric<B> num) {
                return (B)TraversableProxyLike.sum$(this, num);
            }

            public <B> B product(Numeric<B> num) {
                return (B)TraversableProxyLike.product$(this, num);
            }

            public Object min(Ordering cmp) {
                return TraversableProxyLike.min$(this, cmp);
            }

            public Object max(Ordering cmp) {
                return TraversableProxyLike.max$(this, cmp);
            }

            public Object head() {
                return TraversableProxyLike.head$(this);
            }

            public Option<Tuple2<A, B>> headOption() {
                return TraversableProxyLike.headOption$(this);
            }

            public Traversable tail() {
                return TraversableProxyLike.tail$(this);
            }

            public Object last() {
                return TraversableProxyLike.last$(this);
            }

            public Option<Tuple2<A, B>> lastOption() {
                return TraversableProxyLike.lastOption$(this);
            }

            public Traversable init() {
                return TraversableProxyLike.init$(this);
            }

            public Traversable take(int n) {
                return TraversableProxyLike.take$(this, n);
            }

            public Traversable drop(int n) {
                return TraversableProxyLike.drop$(this, n);
            }

            public Traversable slice(int from, int until) {
                return TraversableProxyLike.slice$(this, from, until);
            }

            public Traversable takeWhile(Function1 p) {
                return TraversableProxyLike.takeWhile$(this, p);
            }

            public Traversable dropWhile(Function1 p) {
                return TraversableProxyLike.dropWhile$(this, p);
            }

            public Tuple2<scala.collection.mutable.Map<A, B>, scala.collection.mutable.Map<A, B>> span(Function1<Tuple2<A, B>, Object> p) {
                return TraversableProxyLike.span$(this, p);
            }

            public Tuple2<scala.collection.mutable.Map<A, B>, scala.collection.mutable.Map<A, B>> splitAt(int n) {
                return TraversableProxyLike.splitAt$(this, n);
            }

            public <B> void copyToBuffer(Buffer<B> dest) {
                TraversableProxyLike.copyToBuffer$(this, dest);
            }

            public <B> void copyToArray(Object xs, int start, int len) {
                TraversableProxyLike.copyToArray$(this, xs, start, len);
            }

            public <B> void copyToArray(Object xs, int start) {
                TraversableProxyLike.copyToArray$(this, xs, start);
            }

            public <B> void copyToArray(Object xs) {
                TraversableProxyLike.copyToArray$(this, xs);
            }

            public <B> Object toArray(ClassTag<B> evidence$1) {
                return TraversableProxyLike.toArray$(this, evidence$1);
            }

            public List<Tuple2<A, B>> toList() {
                return TraversableProxyLike.toList$(this);
            }

            public Iterable<Tuple2<A, B>> toIterable() {
                return TraversableProxyLike.toIterable$(this);
            }

            public Seq<Tuple2<A, B>> toSeq() {
                return TraversableProxyLike.toSeq$(this);
            }

            public IndexedSeq<Tuple2<A, B>> toIndexedSeq() {
                return TraversableProxyLike.toIndexedSeq$(this);
            }

            public <B> Buffer<B> toBuffer() {
                return TraversableProxyLike.toBuffer$(this);
            }

            public Stream<Tuple2<A, B>> toStream() {
                return TraversableProxyLike.toStream$(this);
            }

            public <B> scala.collection.immutable.Set<B> toSet() {
                return TraversableProxyLike.toSet$(this);
            }

            public <T, U> scala.collection.immutable.Map<T, U> toMap(Predef$.less.colon.less<Tuple2<A, B>, Tuple2<T, U>> ev) {
                return TraversableProxyLike.toMap$(this, ev);
            }

            public Traversable<Tuple2<A, B>> toTraversable() {
                return TraversableProxyLike.toTraversable$(this);
            }

            public Iterator<Tuple2<A, B>> toIterator() {
                return TraversableProxyLike.toIterator$(this);
            }

            public String mkString(String start, String sep, String end) {
                return TraversableProxyLike.mkString$(this, start, sep, end);
            }

            public String mkString(String sep) {
                return TraversableProxyLike.mkString$(this, sep);
            }

            public String mkString() {
                return TraversableProxyLike.mkString$(this);
            }

            public StringBuilder addString(StringBuilder b, String sep) {
                return TraversableProxyLike.addString$(this, b, sep);
            }

            public StringBuilder addString(StringBuilder b) {
                return TraversableProxyLike.addString$(this, b);
            }

            public String stringPrefix() {
                return TraversableProxyLike.stringPrefix$(this);
            }

            public int hashCode() {
                return Proxy.hashCode$(this);
            }

            public boolean equals(Object that) {
                return Proxy.equals$(this, that);
            }

            public String toString() {
                return Proxy.toString$(this);
            }

            public scala.collection.mutable.Map<A, B> seq() {
                return scala.collection.mutable.Map.seq$(this);
            }

            public scala.collection.mutable.Map<A, B> withDefault(Function1<A, B> d) {
                return scala.collection.mutable.Map.withDefault$(this, d);
            }

            public scala.collection.mutable.Map<A, B> withDefaultValue(B d) {
                return scala.collection.mutable.Map.withDefaultValue$(this, d);
            }

            public Builder<Tuple2<A, B>, scala.collection.mutable.Map<A, B>> newBuilder() {
                return scala.collection.mutable.MapLike.newBuilder$(this);
            }

            public Combiner<Tuple2<A, B>, ParMap<A, B>> parCombiner() {
                return scala.collection.mutable.MapLike.parCombiner$(this);
            }

            public Option<B> put(A key, B value) {
                return scala.collection.mutable.MapLike.put$(this, key, value);
            }

            public void update(A key, B value) {
                scala.collection.mutable.MapLike.update$(this, key, value);
            }

            public Option<B> remove(A key) {
                return scala.collection.mutable.MapLike.remove$(this, key);
            }

            public void clear() {
                scala.collection.mutable.MapLike.clear$(this);
            }

            public B getOrElseUpdate(A key, Function0<B> op) {
                return (B)scala.collection.mutable.MapLike.getOrElseUpdate$(this, key, op);
            }

            public scala.collection.mutable.MapLike<A, B, scala.collection.mutable.Map<A, B>> transform(Function2<A, B, B> f) {
                return scala.collection.mutable.MapLike.transform$(this, f);
            }

            public scala.collection.mutable.MapLike<A, B, scala.collection.mutable.Map<A, B>> retain(Function2<A, B, Object> p) {
                return scala.collection.mutable.MapLike.retain$(this, p);
            }

            public scala.collection.mutable.Map<A, B> clone() {
                return scala.collection.mutable.MapLike.clone$(this);
            }

            public scala.collection.mutable.Map<A, B> result() {
                return scala.collection.mutable.MapLike.result$(this);
            }

            public scala.collection.mutable.Map<A, B> $minus(A elem1, A elem2, Seq<A> elems) {
                return scala.collection.mutable.MapLike.$minus$(this, elem1, elem2, elems);
            }

            public scala.collection.mutable.Map<A, B> $minus$minus(GenTraversableOnce<A> xs) {
                return scala.collection.mutable.MapLike.$minus$minus$(this, xs);
            }

            public /* synthetic */ Object scala$collection$mutable$Cloneable$$super$clone() {
                return super.clone();
            }

            public Shrinkable<A> $minus$eq(A elem1, A elem2, Seq<A> elems) {
                return Shrinkable.$minus$eq$(this, elem1, elem2, elems);
            }

            public Shrinkable<A> $minus$minus$eq(TraversableOnce<A> xs) {
                return Shrinkable.$minus$minus$eq$(this, xs);
            }

            public void sizeHint(int size) {
                Builder.sizeHint$((Builder)this, size);
            }

            public void sizeHint(TraversableLike<?, ?> coll) {
                Builder.sizeHint$((Builder)this, coll);
            }

            public void sizeHint(TraversableLike<?, ?> coll, int delta) {
                Builder.sizeHint$(this, coll, delta);
            }

            public void sizeHintBounded(int size, TraversableLike<?, ?> boundingColl) {
                Builder.sizeHintBounded$(this, size, boundingColl);
            }

            public <NewTo> Builder<Tuple2<A, B>, NewTo> mapResult(Function1<scala.collection.mutable.Map<A, B>, NewTo> f) {
                return Builder.mapResult$(this, f);
            }

            public Growable $plus$eq(Object elem1, Object elem2, Seq elems) {
                return Growable.$plus$eq$(this, elem1, elem2, elems);
            }

            public Growable<Tuple2<A, B>> $plus$plus$eq(TraversableOnce<Tuple2<A, B>> xs) {
                return Growable.$plus$plus$eq$(this, xs);
            }

            public <K1 extends A, V1> V1 applyOrElse(K1 x, Function1<K1, V1> function1) {
                return (V1)MapLike.applyOrElse$(this, x, function1);
            }

            public <A1 extends A, B1> PartialFunction<A1, B1> orElse(PartialFunction<A1, B1> that) {
                return PartialFunction.orElse$(this, that);
            }

            public <C> PartialFunction<A, C> andThen(Function1<B, C> k) {
                return PartialFunction.andThen$(this, k);
            }

            public Function1<A, Option<B>> lift() {
                return PartialFunction.lift$(this);
            }

            public <U> Function1<A, Object> runWith(Function1<B, U> action) {
                return PartialFunction.runWith$(this, action);
            }

            public boolean apply$mcZD$sp(double v1) {
                return Function1.apply$mcZD$sp$(this, v1);
            }

            public double apply$mcDD$sp(double v1) {
                return Function1.apply$mcDD$sp$(this, v1);
            }

            public float apply$mcFD$sp(double v1) {
                return Function1.apply$mcFD$sp$(this, v1);
            }

            public int apply$mcID$sp(double v1) {
                return Function1.apply$mcID$sp$(this, v1);
            }

            public long apply$mcJD$sp(double v1) {
                return Function1.apply$mcJD$sp$(this, v1);
            }

            public void apply$mcVD$sp(double v1) {
                Function1.apply$mcVD$sp$(this, v1);
            }

            public boolean apply$mcZF$sp(float v1) {
                return Function1.apply$mcZF$sp$(this, v1);
            }

            public double apply$mcDF$sp(float v1) {
                return Function1.apply$mcDF$sp$(this, v1);
            }

            public float apply$mcFF$sp(float v1) {
                return Function1.apply$mcFF$sp$(this, v1);
            }

            public int apply$mcIF$sp(float v1) {
                return Function1.apply$mcIF$sp$(this, v1);
            }

            public long apply$mcJF$sp(float v1) {
                return Function1.apply$mcJF$sp$(this, v1);
            }

            public void apply$mcVF$sp(float v1) {
                Function1.apply$mcVF$sp$(this, v1);
            }

            public boolean apply$mcZI$sp(int v1) {
                return Function1.apply$mcZI$sp$(this, v1);
            }

            public double apply$mcDI$sp(int v1) {
                return Function1.apply$mcDI$sp$(this, v1);
            }

            public float apply$mcFI$sp(int v1) {
                return Function1.apply$mcFI$sp$(this, v1);
            }

            public int apply$mcII$sp(int v1) {
                return Function1.apply$mcII$sp$(this, v1);
            }

            public long apply$mcJI$sp(int v1) {
                return Function1.apply$mcJI$sp$(this, v1);
            }

            public void apply$mcVI$sp(int v1) {
                Function1.apply$mcVI$sp$(this, v1);
            }

            public boolean apply$mcZJ$sp(long v1) {
                return Function1.apply$mcZJ$sp$(this, v1);
            }

            public double apply$mcDJ$sp(long v1) {
                return Function1.apply$mcDJ$sp$(this, v1);
            }

            public float apply$mcFJ$sp(long v1) {
                return Function1.apply$mcFJ$sp$(this, v1);
            }

            public int apply$mcIJ$sp(long v1) {
                return Function1.apply$mcIJ$sp$(this, v1);
            }

            public long apply$mcJJ$sp(long v1) {
                return Function1.apply$mcJJ$sp$(this, v1);
            }

            public void apply$mcVJ$sp(long v1) {
                Function1.apply$mcVJ$sp$(this, v1);
            }

            public <A> Function1<A, B> compose(Function1<A, A> g) {
                return Function1.compose$(this, g);
            }

            public GenericCompanion<scala.collection.mutable.Iterable> companion() {
                return scala.collection.mutable.Iterable.companion$(this);
            }

            public Iterable<Tuple2<A, B>> thisCollection() {
                return IterableLike.thisCollection$(this);
            }

            public Iterable toCollection(Object repr) {
                return IterableLike.toCollection$(this, repr);
            }

            public boolean canEqual(Object that) {
                return IterableLike.canEqual$(this, that);
            }

            public <B> Builder<B, scala.collection.mutable.Iterable<B>> genericBuilder() {
                return GenericTraversableTemplate.genericBuilder$(this);
            }

            public <A1, A2> Tuple2<scala.collection.mutable.Iterable<A1>, scala.collection.mutable.Iterable<A2>> unzip(Function1<Tuple2<A, B>, Tuple2<A1, A2>> asPair) {
                return GenericTraversableTemplate.unzip$(this, asPair);
            }

            public <A1, A2, A3> Tuple3<scala.collection.mutable.Iterable<A1>, scala.collection.mutable.Iterable<A2>, scala.collection.mutable.Iterable<A3>> unzip3(Function1<Tuple2<A, B>, Tuple3<A1, A2, A3>> asTriple) {
                return GenericTraversableTemplate.unzip3$(this, asTriple);
            }

            public GenTraversable flatten(Function1 asTraversable) {
                return GenericTraversableTemplate.flatten$(this, asTraversable);
            }

            public GenTraversable transpose(Function1 asTraversable) {
                return GenericTraversableTemplate.transpose$(this, asTraversable);
            }

            public final boolean isTraversableAgain() {
                return TraversableLike.isTraversableAgain$(this);
            }

            public <B, That> That $plus$plus$colon(TraversableOnce<B> that, CanBuildFrom<scala.collection.mutable.Map<A, B>, B, That> bf) {
                return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
            }

            public <B, That> That $plus$plus$colon(Traversable<B> that, CanBuildFrom<scala.collection.mutable.Map<A, B>, B, That> bf) {
                return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
            }

            public Object filterImpl(Function1 p, boolean isFlipped) {
                return TraversableLike.filterImpl$(this, p, isFlipped);
            }

            public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<scala.collection.mutable.Map<A, B>, B, That> cbf) {
                return (That)TraversableLike.scan$(this, z, op, cbf);
            }

            public Object sliceWithKnownDelta(int from, int until, int delta) {
                return TraversableLike.sliceWithKnownDelta$(this, from, until, delta);
            }

            public Object sliceWithKnownBound(int from, int until) {
                return TraversableLike.sliceWithKnownBound$(this, from, until);
            }

            public Iterator<scala.collection.mutable.Map<A, B>> tails() {
                return TraversableLike.tails$(this);
            }

            public Iterator<scala.collection.mutable.Map<A, B>> inits() {
                return TraversableLike.inits$(this);
            }

            public <Col> Col to(CanBuildFrom<Nothing$, Tuple2<A, B>, Col> cbf) {
                return (Col)TraversableLike.to$(this, cbf);
            }

            public FilterMonadic<Tuple2<A, B>, scala.collection.mutable.Map<A, B>> withFilter(Function1<Tuple2<A, B>, Object> p) {
                return TraversableLike.withFilter$(this, p);
            }

            public Parallel par() {
                return Parallelizable.par$(this);
            }

            public List<Tuple2<A, B>> reversed() {
                return TraversableOnce.reversed$(this);
            }

            public <B> Option<B> collectFirst(PartialFunction<Tuple2<A, B>, B> pf) {
                return TraversableOnce.collectFirst$(this, pf);
            }

            public <A1> A1 reduce(Function2<A1, A1, A1> op) {
                return (A1)TraversableOnce.reduce$(this, op);
            }

            public <A1> Option<A1> reduceOption(Function2<A1, A1, A1> op) {
                return TraversableOnce.reduceOption$(this, op);
            }

            public <A1> A1 fold(A1 z, Function2<A1, A1, A1> op) {
                return (A1)TraversableOnce.fold$(this, z, op);
            }

            public <B> B aggregate(Function0<B> z, Function2<B, Tuple2<A, B>, B> seqop, Function2<B, B, B> combop) {
                return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
            }

            public Object maxBy(Function1 f, Ordering cmp) {
                return TraversableOnce.maxBy$(this, f, cmp);
            }

            public Object minBy(Function1 f, Ordering cmp) {
                return TraversableOnce.minBy$(this, f, cmp);
            }

            public Vector<Tuple2<A, B>> toVector() {
                return TraversableOnce.toVector$(this);
            }

            public int sizeHintIfCheap() {
                return GenTraversableOnce.sizeHintIfCheap$(this);
            }

            public scala.collection.mutable.Map<A, B> self() {
                return this.self;
            }
            {
                GenTraversableOnce.$init$(this);
                TraversableOnce.$init$(this);
                Parallelizable.$init$(this);
                TraversableLike.$init$(this);
                GenericTraversableTemplate.$init$(this);
                GenTraversable.$init$(this);
                Traversable.$init$(this);
                scala.collection.mutable.Traversable.$init$(this);
                GenIterable.$init$(this);
                IterableLike.$init$(this);
                Iterable.$init$(this);
                scala.collection.mutable.Iterable.$init$(this);
                GenMapLike.$init$(this);
                PartialFunction.$init$(this);
                Subtractable.$init$(this);
                MapLike.$init$(this);
                Map.$init$(this);
                Growable.$init$(this);
                Builder.$init$(this);
                Shrinkable.$init$(this);
                Cloneable.$init$(this);
                scala.collection.mutable.MapLike.$init$(this);
                scala.collection.mutable.Map.$init$(this);
                Proxy.$init$(this);
                TraversableProxyLike.$init$(this);
                IterableProxyLike.$init$(this);
                MapProxyLike.$init$(this);
                MapProxy.$init$(this);
                this.self = ((scala.collection.mutable.Map)$outer.self()).empty();
            }
        };
    }

    public static /* synthetic */ MapProxy updated$(MapProxy $this, Object key, Object value) {
        return $this.updated((A)key, (B1)value);
    }

    @Override
    default public <B1> MapProxy<A, B1> updated(A key, B1 value) {
        return this.newProxy(((scala.collection.mutable.MapLike)this.self()).updated(key, value));
    }

    public static /* synthetic */ scala.collection.mutable.Map $plus$(MapProxy $this, Tuple2 kv) {
        return $this.$plus(kv);
    }

    @Override
    default public <B1> scala.collection.mutable.Map<A, B1> $plus(Tuple2<A, B1> kv) {
        return this.newProxy(((scala.collection.mutable.MapLike)this.self()).$plus(kv));
    }

    public static /* synthetic */ MapProxy $plus$(MapProxy $this, Tuple2 elem1, Tuple2 elem2, Seq elems) {
        return $this.$plus(elem1, elem2, elems);
    }

    @Override
    default public <B1> MapProxy<A, B1> $plus(Tuple2<A, B1> elem1, Tuple2<A, B1> elem2, Seq<Tuple2<A, B1>> elems) {
        return this.newProxy(((scala.collection.mutable.MapLike)this.self()).$plus(elem1, elem2, elems));
    }

    public static /* synthetic */ MapProxy $plus$plus$(MapProxy $this, GenTraversableOnce xs) {
        return $this.$plus$plus(xs);
    }

    @Override
    default public <B1> MapProxy<A, B1> $plus$plus(GenTraversableOnce<Tuple2<A, B1>> xs) {
        return this.newProxy(((scala.collection.mutable.MapLike)this.self()).$plus$plus(xs.seq()));
    }

    public static /* synthetic */ MapProxy $minus$(MapProxy $this, Object key) {
        return $this.$minus((A)key);
    }

    @Override
    default public MapProxy<A, B> $minus(A key) {
        return this.newProxy((scala.collection.mutable.Map)((scala.collection.mutable.MapLike)this.self()).$minus(key));
    }

    public static /* synthetic */ MapProxy $plus$eq$(MapProxy $this, Tuple2 kv) {
        return $this.$plus$eq(kv);
    }

    @Override
    default public MapProxy<A, B> $plus$eq(Tuple2<A, B> kv) {
        ((scala.collection.mutable.MapLike)this.self()).$plus$eq(kv);
        return this;
    }

    public static /* synthetic */ MapProxy $minus$eq$(MapProxy $this, Object key) {
        return $this.$minus$eq((A)key);
    }

    default public MapProxy<A, B> $minus$eq(A key) {
        ((scala.collection.mutable.MapLike)this.self()).$minus$eq(key);
        return this;
    }

    public static void $init$(MapProxy $this) {
    }
}

