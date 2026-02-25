/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

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
import scala.collection.GenSet;
import scala.collection.GenSetLike;
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
import scala.collection.SetLike;
import scala.collection.SetProxyLike;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.TraversableProxyLike;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.FilterMonadic;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericSetTemplate;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.generic.Subtractable;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.SetProxy;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Traversable;
import scala.collection.immutable.Vector;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.immutable.ParMap;
import scala.collection.parallel.immutable.ParSet;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0005MbaB\u0007\u000f!\u0003\r\t!\u0006\u0005\u0006c\u0001!\tA\r\u0005\u0006m\u0001!\te\u000e\u0005\u0006s\u0001!IA\u000f\u0005\u0006\t\u0002!\te\u000e\u0005\u0006\u000b\u0002!\tE\u0012\u0005\u0006\u001f\u0002!\t\u0005\u0015\u0005\u0006%\u0002!\te\u0015\u0005\u0006%\u0002!\t%\u0018\u0005\u0006Y\u0002!\t%\u001c\u0005\u0006q\u0002!\t%\u001f\u0005\u0006{\u0002!\tE \u0005\b\u0003\u001f\u0001A\u0011IA\t\u0005!i\u0015\r\u001d)s_bL(BA\b\u0011\u0003%IW.\\;uC\ndWM\u0003\u0002\u0012%\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003M\tQa]2bY\u0006\u001c\u0001!F\u0002\u0017C-\u001aB\u0001A\f\u001c[A\u0011\u0001$G\u0007\u0002%%\u0011!D\u0005\u0002\u0007\u0003:L(+\u001a4\u0011\tqirDK\u0007\u0002\u001d%\u0011aD\u0004\u0002\u0004\u001b\u0006\u0004\bC\u0001\u0011\"\u0019\u0001!QA\t\u0001C\u0002\r\u0012\u0011!Q\t\u0003I\u001d\u0002\"\u0001G\u0013\n\u0005\u0019\u0012\"a\u0002(pi\"Lgn\u001a\t\u00031!J!!\u000b\n\u0003\u0007\u0005s\u0017\u0010\u0005\u0002!W\u00111A\u0006\u0001CC\u0002\r\u0012\u0011A\u0011\t\u0006]=z\"fG\u0007\u0002!%\u0011\u0001\u0007\u0005\u0002\r\u001b\u0006\u0004\bK]8ys2K7.Z\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0015\u0003M\u0002\"\u0001\u0007\u001b\n\u0005U\u0012\"\u0001B+oSR\fAA]3qeV\t\u0001\b\u0005\u0003\u001d\u0001}Q\u0013\u0001\u00038foB\u0013x\u000e_=\u0016\u0005mrDC\u0001\u001fB!\u0011a\u0002aH\u001f\u0011\u0005\u0001rD!B \u0004\u0005\u0004\u0001%A\u0001\"2#\tQs\u0005C\u0003C\u0007\u0001\u00071)A\u0004oK^\u001cV\r\u001c4\u0011\tqir$P\u0001\u0006K6\u0004H/_\u0001\bkB$\u0017\r^3e+\t9%\nF\u0002I\u00176\u0003B\u0001\b\u0001 \u0013B\u0011\u0001E\u0013\u0003\u0006\u007f\u0015\u0011\r\u0001\u0011\u0005\u0006\u0019\u0016\u0001\raH\u0001\u0004W\u0016L\b\"\u0002(\u0006\u0001\u0004I\u0015!\u0002<bYV,\u0017A\u0002\u0013nS:,8\u000f\u0006\u00029#\")AJ\u0002a\u0001?\u0005)A\u0005\u001d7vgV\u0011Ak\u0016\u000b\u0003+b\u0003B\u0001H\u000f -B\u0011\u0001e\u0016\u0003\u0006\u007f\u001d\u0011\r\u0001\u0011\u0005\u00063\u001e\u0001\rAW\u0001\u0003WZ\u0004B\u0001G. -&\u0011AL\u0005\u0002\u0007)V\u0004H.\u001a\u001a\u0016\u0005y\u000bG\u0003B0cK\u001e\u0004B\u0001\b\u0001 AB\u0011\u0001%\u0019\u0003\u0006\u007f!\u0011\r\u0001\u0011\u0005\u0006G\"\u0001\r\u0001Z\u0001\u0006K2,W.\r\t\u00051m{\u0002\rC\u0003g\u0011\u0001\u0007A-A\u0003fY\u0016l'\u0007C\u0003i\u0011\u0001\u0007\u0011.A\u0003fY\u0016l7\u000fE\u0002\u0019U\u0012L!a\u001b\n\u0003\u0015q\u0012X\r]3bi\u0016$g(\u0001\u0006%a2,8\u000f\n9mkN,\"A\\9\u0015\u0005=\u0014\b\u0003\u0002\u000f\u0001?A\u0004\"\u0001I9\u0005\u000b}J!\u0019\u0001!\t\u000bML\u0001\u0019\u0001;\u0002\u0005a\u001c\bc\u0001\u0018vo&\u0011a\u000f\u0005\u0002\u0013\u000f\u0016tGK]1wKJ\u001c\u0018M\u00197f\u001f:\u001cW\r\u0005\u0003\u00197~\u0001\u0018AB6fsN+G/F\u0001{!\ra2pH\u0005\u0003y:\u00111aU3u\u0003)1\u0017\u000e\u001c;fe.+\u0017p\u001d\u000b\u00037}Dq!!\u0001\f\u0001\u0004\t\u0019!A\u0001q!\u0019A\u0012QA\u0010\u0002\n%\u0019\u0011q\u0001\n\u0003\u0013\u0019+hn\u0019;j_:\f\u0004c\u0001\r\u0002\f%\u0019\u0011Q\u0002\n\u0003\u000f\t{w\u000e\\3b]\u0006IQ.\u00199WC2,Xm]\u000b\u0005\u0003'\tI\u0002\u0006\u0003\u0002\u0016\u0005u\u0001#\u0002\u000f\u001e?\u0005]\u0001c\u0001\u0011\u0002\u001a\u00111\u00111\u0004\u0007C\u0002\r\u0012\u0011a\u0011\u0005\b\u0003?a\u0001\u0019AA\u0011\u0003\u00051\u0007C\u0002\r\u0002\u0006)\n9\u0002K\u0004\u0001\u0003K\tY#a\f\u0011\u0007a\t9#C\u0002\u0002*I\u0011!\u0002Z3qe\u0016\u001c\u0017\r^3eC\t\ti#\u0001#qe>D\u00180\u001b8hA%\u001c\b\u0005Z3qe\u0016\u001c\u0017\r^3eA\u0011,X\r\t;pA1\f7m\u001b\u0011pM\u0002*8/\u001a\u0011b]\u0012\u00043m\\7qS2,'/\f7fm\u0016d\u0007e];qa>\u0014H/\t\u0002\u00022\u00051!GL\u00192]A\u0002")
public interface MapProxy<A, B>
extends scala.collection.immutable.Map<A, B>,
MapProxyLike<A, B, scala.collection.immutable.Map<A, B>> {
    public static /* synthetic */ MapProxy repr$(MapProxy $this) {
        return $this.repr();
    }

    @Override
    default public MapProxy<A, B> repr() {
        return this;
    }

    private <B1> MapProxy<A, B1> newProxy(scala.collection.immutable.Map<A, B1> newSelf) {
        return new MapProxy<A, B1>(null, newSelf){
            private final scala.collection.immutable.Map<A, B1> self;

            public MapProxy<A, B1> repr() {
                return MapProxy.repr$(this);
            }

            public MapProxy<A, B1> empty() {
                return MapProxy.empty$(this);
            }

            public <B1> MapProxy<A, B1> updated(A key, B1 value) {
                return MapProxy.updated$(this, key, value);
            }

            public MapProxy<A, B1> $minus(A key) {
                return MapProxy.$minus$(this, key);
            }

            public <B1> scala.collection.immutable.Map<A, B1> $plus(Tuple2<A, B1> kv) {
                return MapProxy.$plus$(this, kv);
            }

            public <B1> MapProxy<A, B1> $plus(Tuple2<A, B1> elem1, Tuple2<A, B1> elem2, Seq<Tuple2<A, B1>> elems) {
                return MapProxy.$plus$(this, elem1, elem2, elems);
            }

            public <B1> MapProxy<A, B1> $plus$plus(GenTraversableOnce<Tuple2<A, B1>> xs) {
                return MapProxy.$plus$plus$(this, xs);
            }

            public scala.collection.immutable.Set<A> keySet() {
                return MapProxy.keySet$(this);
            }

            public scala.collection.immutable.Map<A, B1> filterKeys(Function1<A, Object> p) {
                return MapProxy.filterKeys$(this, p);
            }

            public <C> scala.collection.immutable.Map<A, C> mapValues(Function1<B1, C> f) {
                return MapProxy.mapValues$(this, f);
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

            public Map filterNot(Function1 p) {
                return MapProxyLike.filterNot$(this, p);
            }

            public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
                return MapProxyLike.addString$(this, b, start, sep, end);
            }

            public Iterator<scala.collection.immutable.Map<A, B1>> grouped(int size) {
                return IterableProxyLike.grouped$(this, size);
            }

            public Iterator<scala.collection.immutable.Map<A, B1>> sliding(int size) {
                return IterableProxyLike.sliding$(this, size);
            }

            public Iterator<scala.collection.immutable.Map<A, B1>> sliding(int size, int step) {
                return IterableProxyLike.sliding$(this, size, step);
            }

            public Iterable takeRight(int n) {
                return IterableProxyLike.takeRight$(this, n);
            }

            public Iterable dropRight(int n) {
                return IterableProxyLike.dropRight$(this, n);
            }

            public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<scala.collection.immutable.Map<A, B1>, Tuple2<A1, B>, That> bf) {
                return (That)IterableProxyLike.zip$(this, that, bf);
            }

            public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<scala.collection.immutable.Map<A, B1>, Tuple2<A1, B>, That> bf) {
                return (That)IterableProxyLike.zipAll$(this, that, thisElem, thatElem, bf);
            }

            public <A1, That> That zipWithIndex(CanBuildFrom<scala.collection.immutable.Map<A, B1>, Tuple2<A1, Object>, That> bf) {
                return (That)IterableProxyLike.zipWithIndex$(this, bf);
            }

            public <B> boolean sameElements(GenIterable<B> that) {
                return IterableProxyLike.sameElements$(this, that);
            }

            public IterableView<Tuple2<A, B1>, scala.collection.immutable.Map<A, B1>> view() {
                return IterableProxyLike.view$(this);
            }

            public IterableView<Tuple2<A, B1>, scala.collection.immutable.Map<A, B1>> view(int from, int until) {
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

            public <B, That> That $plus$plus(GenTraversableOnce<B> xs, CanBuildFrom<scala.collection.immutable.Map<A, B1>, B, That> bf) {
                return (That)TraversableProxyLike.$plus$plus$(this, xs, bf);
            }

            public <B, That> That map(Function1<Tuple2<A, B1>, B> f, CanBuildFrom<scala.collection.immutable.Map<A, B1>, B, That> bf) {
                return (That)TraversableProxyLike.map$(this, f, bf);
            }

            public <B, That> That flatMap(Function1<Tuple2<A, B1>, GenTraversableOnce<B>> f, CanBuildFrom<scala.collection.immutable.Map<A, B1>, B, That> bf) {
                return (That)TraversableProxyLike.flatMap$(this, f, bf);
            }

            public scala.collection.Traversable filter(Function1 p) {
                return TraversableProxyLike.filter$(this, p);
            }

            public <B, That> That collect(PartialFunction<Tuple2<A, B1>, B> pf, CanBuildFrom<scala.collection.immutable.Map<A, B1>, B, That> bf) {
                return (That)TraversableProxyLike.collect$(this, pf, bf);
            }

            public Tuple2<scala.collection.immutable.Map<A, B1>, scala.collection.immutable.Map<A, B1>> partition(Function1<Tuple2<A, B1>, Object> p) {
                return TraversableProxyLike.partition$(this, p);
            }

            public <K> scala.collection.immutable.Map<K, scala.collection.immutable.Map<A, B1>> groupBy(Function1<Tuple2<A, B1>, K> f) {
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

            public <B, That> That scanLeft(B z, Function2<B, Tuple2<A, B1>, B> op, CanBuildFrom<scala.collection.immutable.Map<A, B1>, B, That> bf) {
                return (That)TraversableProxyLike.scanLeft$(this, z, op, bf);
            }

            public <B, That> That scanRight(B z, Function2<Tuple2<A, B1>, B, B> op, CanBuildFrom<scala.collection.immutable.Map<A, B1>, B, That> bf) {
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

            public scala.collection.Traversable tail() {
                return TraversableProxyLike.tail$(this);
            }

            public Object last() {
                return TraversableProxyLike.last$(this);
            }

            public Option<Tuple2<A, B1>> lastOption() {
                return TraversableProxyLike.lastOption$(this);
            }

            public scala.collection.Traversable init() {
                return TraversableProxyLike.init$(this);
            }

            public scala.collection.Traversable take(int n) {
                return TraversableProxyLike.take$(this, n);
            }

            public scala.collection.Traversable drop(int n) {
                return TraversableProxyLike.drop$(this, n);
            }

            public scala.collection.Traversable slice(int from, int until) {
                return TraversableProxyLike.slice$(this, from, until);
            }

            public scala.collection.Traversable takeWhile(Function1 p) {
                return TraversableProxyLike.takeWhile$(this, p);
            }

            public scala.collection.Traversable dropWhile(Function1 p) {
                return TraversableProxyLike.dropWhile$(this, p);
            }

            public Tuple2<scala.collection.immutable.Map<A, B1>, scala.collection.immutable.Map<A, B1>> span(Function1<Tuple2<A, B1>, Object> p) {
                return TraversableProxyLike.span$(this, p);
            }

            public Tuple2<scala.collection.immutable.Map<A, B1>, scala.collection.immutable.Map<A, B1>> splitAt(int n) {
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

            public scala.collection.Traversable<Tuple2<A, B1>> toTraversable() {
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

            public scala.collection.immutable.Map<A, B1> seq() {
                return scala.collection.immutable.Map.seq$(this);
            }

            public <V1> scala.collection.immutable.Map<A, V1> withDefault(Function1<A, V1> d) {
                return scala.collection.immutable.Map.withDefault$(this, d);
            }

            public <V1> scala.collection.immutable.Map<A, V1> withDefaultValue(V1 d) {
                return scala.collection.immutable.Map.withDefaultValue$(this, d);
            }

            public Combiner<Tuple2<A, B1>, ParMap<A, B1>> parCombiner() {
                return scala.collection.immutable.MapLike.parCombiner$(this);
            }

            public <W, That> That transform(Function2<A, B1, W> f, CanBuildFrom<scala.collection.immutable.Map<A, B1>, Tuple2<A, W>, That> bf) {
                return (That)scala.collection.immutable.MapLike.transform$(this, f, bf);
            }

            public Builder<Tuple2<A, B1>, scala.collection.immutable.Map<A, B1>> newBuilder() {
                return MapLike.newBuilder$(this);
            }

            public <K1 extends A, V1> V1 applyOrElse(K1 x, Function1<K1, V1> function1) {
                return (V1)MapLike.applyOrElse$(this, x, function1);
            }

            public Subtractable $minus(Object elem1, Object elem2, Seq elems) {
                return Subtractable.$minus$(this, elem1, elem2, elems);
            }

            public Subtractable $minus$minus(GenTraversableOnce xs) {
                return Subtractable.$minus$minus$(this, xs);
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

            public GenericCompanion<scala.collection.immutable.Iterable> companion() {
                return scala.collection.immutable.Iterable.companion$(this);
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

            public <B> Builder<B, scala.collection.immutable.Iterable<B>> genericBuilder() {
                return GenericTraversableTemplate.genericBuilder$(this);
            }

            public <A1, A2> Tuple2<scala.collection.immutable.Iterable<A1>, scala.collection.immutable.Iterable<A2>> unzip(Function1<Tuple2<A, B1>, Tuple2<A1, A2>> asPair) {
                return GenericTraversableTemplate.unzip$(this, asPair);
            }

            public <A1, A2, A3> Tuple3<scala.collection.immutable.Iterable<A1>, scala.collection.immutable.Iterable<A2>, scala.collection.immutable.Iterable<A3>> unzip3(Function1<Tuple2<A, B1>, Tuple3<A1, A2, A3>> asTriple) {
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

            public <B, That> That $plus$plus$colon(TraversableOnce<B> that, CanBuildFrom<scala.collection.immutable.Map<A, B1>, B, That> bf) {
                return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
            }

            public <B, That> That $plus$plus$colon(scala.collection.Traversable<B> that, CanBuildFrom<scala.collection.immutable.Map<A, B1>, B, That> bf) {
                return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
            }

            public Object filterImpl(Function1 p, boolean isFlipped) {
                return TraversableLike.filterImpl$(this, p, isFlipped);
            }

            public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<scala.collection.immutable.Map<A, B1>, B, That> cbf) {
                return (That)TraversableLike.scan$(this, z, op, cbf);
            }

            public Object sliceWithKnownDelta(int from, int until, int delta) {
                return TraversableLike.sliceWithKnownDelta$(this, from, until, delta);
            }

            public Object sliceWithKnownBound(int from, int until) {
                return TraversableLike.sliceWithKnownBound$(this, from, until);
            }

            public Iterator<scala.collection.immutable.Map<A, B1>> tails() {
                return TraversableLike.tails$(this);
            }

            public Iterator<scala.collection.immutable.Map<A, B1>> inits() {
                return TraversableLike.inits$(this);
            }

            public <Col> Col to(CanBuildFrom<Nothing$, Tuple2<A, B1>, Col> cbf) {
                return (Col)TraversableLike.to$(this, cbf);
            }

            public FilterMonadic<Tuple2<A, B1>, scala.collection.immutable.Map<A, B1>> withFilter(Function1<Tuple2<A, B1>, Object> p) {
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

            public scala.collection.immutable.Map<A, B1> self() {
                return this.self;
            }
            {
                GenTraversableOnce.$init$(this);
                TraversableOnce.$init$(this);
                Parallelizable.$init$(this);
                TraversableLike.$init$(this);
                GenericTraversableTemplate.$init$(this);
                GenTraversable.$init$(this);
                scala.collection.Traversable.$init$(this);
                Traversable.$init$(this);
                GenIterable.$init$(this);
                IterableLike.$init$(this);
                Iterable.$init$(this);
                scala.collection.immutable.Iterable.$init$(this);
                GenMapLike.$init$(this);
                PartialFunction.$init$(this);
                Subtractable.$init$(this);
                MapLike.$init$(this);
                Map.$init$(this);
                scala.collection.immutable.MapLike.$init$(this);
                scala.collection.immutable.Map.$init$(this);
                Proxy.$init$(this);
                TraversableProxyLike.$init$(this);
                IterableProxyLike.$init$(this);
                MapProxyLike.$init$(this);
                MapProxy.$init$(this);
                this.self = newSelf$1;
            }
        };
    }

    public static /* synthetic */ MapProxy empty$(MapProxy $this) {
        return $this.empty();
    }

    @Override
    default public MapProxy<A, B> empty() {
        return this.newProxy(((scala.collection.immutable.Map)this.self()).empty());
    }

    public static /* synthetic */ MapProxy updated$(MapProxy $this, Object key, Object value) {
        return $this.updated((A)key, (B1)value);
    }

    @Override
    default public <B1> MapProxy<A, B1> updated(A key, B1 value) {
        return this.newProxy(((scala.collection.immutable.MapLike)this.self()).updated(key, value));
    }

    public static /* synthetic */ MapProxy $minus$(MapProxy $this, Object key) {
        return $this.$minus((A)key);
    }

    @Override
    default public MapProxy<A, B> $minus(A key) {
        return this.newProxy((scala.collection.immutable.Map)((MapLike)this.self()).$minus(key));
    }

    public static /* synthetic */ scala.collection.immutable.Map $plus$(MapProxy $this, Tuple2 kv) {
        return $this.$plus(kv);
    }

    @Override
    default public <B1> scala.collection.immutable.Map<A, B1> $plus(Tuple2<A, B1> kv) {
        return this.newProxy(((scala.collection.immutable.Map)this.self()).$plus(kv));
    }

    public static /* synthetic */ MapProxy $plus$(MapProxy $this, Tuple2 elem1, Tuple2 elem2, Seq elems) {
        return $this.$plus(elem1, elem2, elems);
    }

    @Override
    default public <B1> MapProxy<A, B1> $plus(Tuple2<A, B1> elem1, Tuple2<A, B1> elem2, Seq<Tuple2<A, B1>> elems) {
        return this.newProxy(((scala.collection.immutable.MapLike)this.self()).$plus(elem1, elem2, elems));
    }

    public static /* synthetic */ MapProxy $plus$plus$(MapProxy $this, GenTraversableOnce xs) {
        return $this.$plus$plus(xs);
    }

    @Override
    default public <B1> MapProxy<A, B1> $plus$plus(GenTraversableOnce<Tuple2<A, B1>> xs) {
        return this.newProxy(((scala.collection.immutable.MapLike)this.self()).$plus$plus(xs.seq()));
    }

    public static /* synthetic */ scala.collection.immutable.Set keySet$(MapProxy $this) {
        return $this.keySet();
    }

    @Override
    default public scala.collection.immutable.Set<A> keySet() {
        return new SetProxy<A>(this){
            private final scala.collection.immutable.Set<A> self;

            public SetProxy<A> repr() {
                return SetProxy.repr$(this);
            }

            public SetProxy<A> empty() {
                return SetProxy.empty$(this);
            }

            public SetProxy<A> $plus(A elem) {
                return SetProxy.$plus$(this, elem);
            }

            public SetProxy<A> $minus(A elem) {
                return SetProxy.$minus$(this, elem);
            }

            public boolean contains(A elem) {
                return SetProxyLike.contains$(this, elem);
            }

            public boolean isEmpty() {
                return SetProxyLike.isEmpty$(this);
            }

            public boolean apply(A elem) {
                return SetProxyLike.apply$(this, elem);
            }

            public Set intersect(GenSet that) {
                return SetProxyLike.intersect$(this, that);
            }

            public Set $amp(GenSet that) {
                return SetProxyLike.$amp$(this, that);
            }

            public Set union(GenSet that) {
                return SetProxyLike.union$(this, that);
            }

            public Set $bar(GenSet that) {
                return SetProxyLike.$bar$(this, that);
            }

            public Set diff(GenSet that) {
                return SetProxyLike.diff$(this, that);
            }

            public Set $amp$tilde(GenSet that) {
                return SetProxyLike.$amp$tilde$(this, that);
            }

            public boolean subsetOf(GenSet<A> that) {
                return SetProxyLike.subsetOf$(this, that);
            }

            public Iterator<A> iterator() {
                return IterableProxyLike.iterator$(this);
            }

            public Iterator<scala.collection.immutable.Set<A>> grouped(int size) {
                return IterableProxyLike.grouped$(this, size);
            }

            public Iterator<scala.collection.immutable.Set<A>> sliding(int size) {
                return IterableProxyLike.sliding$(this, size);
            }

            public Iterator<scala.collection.immutable.Set<A>> sliding(int size, int step) {
                return IterableProxyLike.sliding$(this, size, step);
            }

            public Iterable takeRight(int n) {
                return IterableProxyLike.takeRight$(this, n);
            }

            public Iterable dropRight(int n) {
                return IterableProxyLike.dropRight$(this, n);
            }

            public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<scala.collection.immutable.Set<A>, Tuple2<A1, B>, That> bf) {
                return (That)IterableProxyLike.zip$(this, that, bf);
            }

            public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<scala.collection.immutable.Set<A>, Tuple2<A1, B>, That> bf) {
                return (That)IterableProxyLike.zipAll$(this, that, thisElem, thatElem, bf);
            }

            public <A1, That> That zipWithIndex(CanBuildFrom<scala.collection.immutable.Set<A>, Tuple2<A1, Object>, That> bf) {
                return (That)IterableProxyLike.zipWithIndex$(this, bf);
            }

            public <B> boolean sameElements(GenIterable<B> that) {
                return IterableProxyLike.sameElements$(this, that);
            }

            public IterableView<A, scala.collection.immutable.Set<A>> view() {
                return IterableProxyLike.view$(this);
            }

            public IterableView<A, scala.collection.immutable.Set<A>> view(int from, int until) {
                return IterableProxyLike.view$(this, from, until);
            }

            public <U> void foreach(Function1<A, U> f) {
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

            public <B, That> That $plus$plus(GenTraversableOnce<B> xs, CanBuildFrom<scala.collection.immutable.Set<A>, B, That> bf) {
                return (That)TraversableProxyLike.$plus$plus$(this, xs, bf);
            }

            public <B, That> That map(Function1<A, B> f, CanBuildFrom<scala.collection.immutable.Set<A>, B, That> bf) {
                return (That)TraversableProxyLike.map$(this, f, bf);
            }

            public <B, That> That flatMap(Function1<A, GenTraversableOnce<B>> f, CanBuildFrom<scala.collection.immutable.Set<A>, B, That> bf) {
                return (That)TraversableProxyLike.flatMap$(this, f, bf);
            }

            public scala.collection.Traversable filter(Function1 p) {
                return TraversableProxyLike.filter$(this, p);
            }

            public scala.collection.Traversable filterNot(Function1 p) {
                return TraversableProxyLike.filterNot$(this, p);
            }

            public <B, That> That collect(PartialFunction<A, B> pf, CanBuildFrom<scala.collection.immutable.Set<A>, B, That> bf) {
                return (That)TraversableProxyLike.collect$(this, pf, bf);
            }

            public Tuple2<scala.collection.immutable.Set<A>, scala.collection.immutable.Set<A>> partition(Function1<A, Object> p) {
                return TraversableProxyLike.partition$(this, p);
            }

            public <K> scala.collection.immutable.Map<K, scala.collection.immutable.Set<A>> groupBy(Function1<A, K> f) {
                return TraversableProxyLike.groupBy$(this, f);
            }

            public boolean forall(Function1<A, Object> p) {
                return TraversableProxyLike.forall$(this, p);
            }

            public boolean exists(Function1<A, Object> p) {
                return TraversableProxyLike.exists$(this, p);
            }

            public int count(Function1<A, Object> p) {
                return TraversableProxyLike.count$(this, p);
            }

            public Option<A> find(Function1<A, Object> p) {
                return TraversableProxyLike.find$(this, p);
            }

            public <B> B foldLeft(B z, Function2<B, A, B> op) {
                return (B)TraversableProxyLike.foldLeft$(this, z, op);
            }

            public <B> B $div$colon(B z, Function2<B, A, B> op) {
                return (B)TraversableProxyLike.$div$colon$(this, z, op);
            }

            public <B> B foldRight(B z, Function2<A, B, B> op) {
                return (B)TraversableProxyLike.foldRight$(this, z, op);
            }

            public <B> B $colon$bslash(B z, Function2<A, B, B> op) {
                return (B)TraversableProxyLike.$colon$bslash$(this, z, op);
            }

            public <B> B reduceLeft(Function2<B, A, B> op) {
                return (B)TraversableProxyLike.reduceLeft$(this, op);
            }

            public <B> Option<B> reduceLeftOption(Function2<B, A, B> op) {
                return TraversableProxyLike.reduceLeftOption$(this, op);
            }

            public <B> B reduceRight(Function2<A, B, B> op) {
                return (B)TraversableProxyLike.reduceRight$(this, op);
            }

            public <B> Option<B> reduceRightOption(Function2<A, B, B> op) {
                return TraversableProxyLike.reduceRightOption$(this, op);
            }

            public <B, That> That scanLeft(B z, Function2<B, A, B> op, CanBuildFrom<scala.collection.immutable.Set<A>, B, That> bf) {
                return (That)TraversableProxyLike.scanLeft$(this, z, op, bf);
            }

            public <B, That> That scanRight(B z, Function2<A, B, B> op, CanBuildFrom<scala.collection.immutable.Set<A>, B, That> bf) {
                return (That)TraversableProxyLike.scanRight$(this, z, op, bf);
            }

            public <B> B sum(Numeric<B> num) {
                return (B)TraversableProxyLike.sum$(this, num);
            }

            public <B> B product(Numeric<B> num) {
                return (B)TraversableProxyLike.product$(this, num);
            }

            public <B> A min(Ordering<B> cmp) {
                return (A)TraversableProxyLike.min$(this, cmp);
            }

            public <B> A max(Ordering<B> cmp) {
                return (A)TraversableProxyLike.max$(this, cmp);
            }

            public A head() {
                return (A)TraversableProxyLike.head$(this);
            }

            public Option<A> headOption() {
                return TraversableProxyLike.headOption$(this);
            }

            public scala.collection.Traversable tail() {
                return TraversableProxyLike.tail$(this);
            }

            public A last() {
                return (A)TraversableProxyLike.last$(this);
            }

            public Option<A> lastOption() {
                return TraversableProxyLike.lastOption$(this);
            }

            public scala.collection.Traversable init() {
                return TraversableProxyLike.init$(this);
            }

            public scala.collection.Traversable take(int n) {
                return TraversableProxyLike.take$(this, n);
            }

            public scala.collection.Traversable drop(int n) {
                return TraversableProxyLike.drop$(this, n);
            }

            public scala.collection.Traversable slice(int from, int until) {
                return TraversableProxyLike.slice$(this, from, until);
            }

            public scala.collection.Traversable takeWhile(Function1 p) {
                return TraversableProxyLike.takeWhile$(this, p);
            }

            public scala.collection.Traversable dropWhile(Function1 p) {
                return TraversableProxyLike.dropWhile$(this, p);
            }

            public Tuple2<scala.collection.immutable.Set<A>, scala.collection.immutable.Set<A>> span(Function1<A, Object> p) {
                return TraversableProxyLike.span$(this, p);
            }

            public Tuple2<scala.collection.immutable.Set<A>, scala.collection.immutable.Set<A>> splitAt(int n) {
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

            public List<A> toList() {
                return TraversableProxyLike.toList$(this);
            }

            public Iterable<A> toIterable() {
                return TraversableProxyLike.toIterable$(this);
            }

            public Seq<A> toSeq() {
                return TraversableProxyLike.toSeq$(this);
            }

            public IndexedSeq<A> toIndexedSeq() {
                return TraversableProxyLike.toIndexedSeq$(this);
            }

            public <B> Buffer<B> toBuffer() {
                return TraversableProxyLike.toBuffer$(this);
            }

            public Stream<A> toStream() {
                return TraversableProxyLike.toStream$(this);
            }

            public <B> scala.collection.immutable.Set<B> toSet() {
                return TraversableProxyLike.toSet$(this);
            }

            public <T, U> scala.collection.immutable.Map<T, U> toMap(Predef$.less.colon.less<A, Tuple2<T, U>> ev) {
                return TraversableProxyLike.toMap$(this, ev);
            }

            public scala.collection.Traversable<A> toTraversable() {
                return TraversableProxyLike.toTraversable$(this);
            }

            public Iterator<A> toIterator() {
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

            public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
                return TraversableProxyLike.addString$(this, b, start, sep, end);
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

            public GenericCompanion<scala.collection.immutable.Set> companion() {
                return scala.collection.immutable.Set.companion$(this);
            }

            public scala.collection.immutable.Set<A> seq() {
                return scala.collection.immutable.Set.seq$(this);
            }

            public Combiner<A, ParSet<A>> parCombiner() {
                return scala.collection.immutable.Set.parCombiner$(this);
            }

            public /* synthetic */ Object scala$collection$SetLike$$super$map(Function1 f, CanBuildFrom bf) {
                return TraversableLike.map$(this, f, bf);
            }

            public Builder<A, scala.collection.immutable.Set<A>> newBuilder() {
                return SetLike.newBuilder$(this);
            }

            public Set $plus(Object elem1, Object elem2, Seq elems) {
                return SetLike.$plus$(this, elem1, elem2, elems);
            }

            public Set $plus$plus(GenTraversableOnce elems) {
                return SetLike.$plus$plus$(this, elems);
            }

            public Iterator<scala.collection.immutable.Set<A>> subsets(int len) {
                return SetLike.subsets$(this, len);
            }

            public Iterator<scala.collection.immutable.Set<A>> subsets() {
                return SetLike.subsets$(this);
            }

            public Subtractable $minus(Object elem1, Object elem2, Seq elems) {
                return Subtractable.$minus$(this, elem1, elem2, elems);
            }

            public Subtractable $minus$minus(GenTraversableOnce xs) {
                return Subtractable.$minus$minus$(this, xs);
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

            public <A> Function1<A, Object> compose(Function1<A, A> g) {
                return Function1.compose$(this, g);
            }

            public <A> Function1<A, A> andThen(Function1<Object, A> g) {
                return Function1.andThen$(this, g);
            }

            public Iterable<A> thisCollection() {
                return IterableLike.thisCollection$(this);
            }

            public Iterable toCollection(Object repr) {
                return IterableLike.toCollection$(this, repr);
            }

            public boolean canEqual(Object that) {
                return IterableLike.canEqual$(this, that);
            }

            public <B> Builder<B, scala.collection.immutable.Set<B>> genericBuilder() {
                return GenericTraversableTemplate.genericBuilder$(this);
            }

            public <A1, A2> Tuple2<scala.collection.immutable.Set<A1>, scala.collection.immutable.Set<A2>> unzip(Function1<A, Tuple2<A1, A2>> asPair) {
                return GenericTraversableTemplate.unzip$(this, asPair);
            }

            public <A1, A2, A3> Tuple3<scala.collection.immutable.Set<A1>, scala.collection.immutable.Set<A2>, scala.collection.immutable.Set<A3>> unzip3(Function1<A, Tuple3<A1, A2, A3>> asTriple) {
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

            public <B, That> That $plus$plus$colon(TraversableOnce<B> that, CanBuildFrom<scala.collection.immutable.Set<A>, B, That> bf) {
                return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
            }

            public <B, That> That $plus$plus$colon(scala.collection.Traversable<B> that, CanBuildFrom<scala.collection.immutable.Set<A>, B, That> bf) {
                return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
            }

            public Object filterImpl(Function1 p, boolean isFlipped) {
                return TraversableLike.filterImpl$(this, p, isFlipped);
            }

            public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<scala.collection.immutable.Set<A>, B, That> cbf) {
                return (That)TraversableLike.scan$(this, z, op, cbf);
            }

            public Object sliceWithKnownDelta(int from, int until, int delta) {
                return TraversableLike.sliceWithKnownDelta$(this, from, until, delta);
            }

            public Object sliceWithKnownBound(int from, int until) {
                return TraversableLike.sliceWithKnownBound$(this, from, until);
            }

            public Iterator<scala.collection.immutable.Set<A>> tails() {
                return TraversableLike.tails$(this);
            }

            public Iterator<scala.collection.immutable.Set<A>> inits() {
                return TraversableLike.inits$(this);
            }

            public <Col> Col to(CanBuildFrom<Nothing$, A, Col> cbf) {
                return (Col)TraversableLike.to$(this, cbf);
            }

            public FilterMonadic<A, scala.collection.immutable.Set<A>> withFilter(Function1<A, Object> p) {
                return TraversableLike.withFilter$(this, p);
            }

            public Parallel par() {
                return Parallelizable.par$(this);
            }

            public List<A> reversed() {
                return TraversableOnce.reversed$(this);
            }

            public <B> Option<B> collectFirst(PartialFunction<A, B> pf) {
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

            public <B> B aggregate(Function0<B> z, Function2<B, A, B> seqop, Function2<B, B, B> combop) {
                return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
            }

            public <B> A maxBy(Function1<A, B> f, Ordering<B> cmp) {
                return (A)TraversableOnce.maxBy$(this, f, cmp);
            }

            public <B> A minBy(Function1<A, B> f, Ordering<B> cmp) {
                return (A)TraversableOnce.minBy$(this, f, cmp);
            }

            public Vector<A> toVector() {
                return TraversableOnce.toVector$(this);
            }

            public int sizeHintIfCheap() {
                return GenTraversableOnce.sizeHintIfCheap$(this);
            }

            public scala.collection.immutable.Set<A> self() {
                return this.self;
            }
            {
                GenTraversableOnce.$init$(this);
                TraversableOnce.$init$(this);
                Parallelizable.$init$(this);
                TraversableLike.$init$(this);
                GenericTraversableTemplate.$init$(this);
                GenTraversable.$init$(this);
                scala.collection.Traversable.$init$(this);
                Traversable.$init$(this);
                GenIterable.$init$(this);
                IterableLike.$init$(this);
                Iterable.$init$(this);
                scala.collection.immutable.Iterable.$init$(this);
                GenSetLike.$init$(this);
                GenericSetTemplate.$init$(this);
                GenSet.$init$(this);
                Subtractable.$init$(this);
                SetLike.$init$(this);
                Set.$init$(this);
                scala.collection.immutable.Set.$init$(this);
                Proxy.$init$(this);
                TraversableProxyLike.$init$(this);
                IterableProxyLike.$init$(this);
                SetProxyLike.$init$(this);
                SetProxy.$init$(this);
                this.self = ((scala.collection.immutable.MapLike)$outer.self()).keySet();
            }
        };
    }

    public static /* synthetic */ scala.collection.immutable.Map filterKeys$(MapProxy $this, Function1 p) {
        return $this.filterKeys(p);
    }

    @Override
    default public scala.collection.immutable.Map<A, B> filterKeys(Function1<A, Object> p) {
        return ((scala.collection.immutable.MapLike)this.self()).filterKeys(p);
    }

    public static /* synthetic */ scala.collection.immutable.Map mapValues$(MapProxy $this, Function1 f) {
        return $this.mapValues(f);
    }

    @Override
    default public <C> scala.collection.immutable.Map<A, C> mapValues(Function1<B, C> f) {
        return ((scala.collection.immutable.MapLike)this.self()).mapValues(f);
    }

    public static void $init$(MapProxy $this) {
    }
}

