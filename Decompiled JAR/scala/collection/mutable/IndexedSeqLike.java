/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.GenIterable;
import scala.collection.GenSeq;
import scala.collection.GenSeqLike;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.IndexedSeqOptimized;
import scala.collection.Iterable;
import scala.collection.IterableLike;
import scala.collection.IterableView;
import scala.collection.IterableViewLike;
import scala.collection.Iterator;
import scala.collection.Parallel;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.SeqView;
import scala.collection.SeqViewLike;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.TraversableView;
import scala.collection.TraversableViewLike;
import scala.collection.ViewMkString;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.generic.SliceInterval;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Range;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.Cloneable;
import scala.collection.mutable.IndexedSeq;
import scala.collection.mutable.IndexedSeqView;
import scala.collection.mutable.SeqLike;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.mutable.ParSeq;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.LambdaDeserialize;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001-3qa\u0002\u0005\u0011\u0002\u0007\u0005q\u0002C\u0003$\u0001\u0011\u0005A\u0005\u0003\u0004)\u0001\u0001&\t&\u000b\u0005\u0007]\u0001\u0001K\u0011K\u0018\t\u000bI\u0002a\u0011A\u001a\t\u000bm\u0002A\u0011\t\u001f\t\u000bm\u0002A\u0011\t$\u0003\u001d%sG-\u001a=fIN+\u0017\u000fT5lK*\u0011\u0011BC\u0001\b[V$\u0018M\u00197f\u0015\tYA\"\u0001\u0006d_2dWm\u0019;j_:T\u0011!D\u0001\u0006g\u000e\fG.Y\u0002\u0001+\r\u0001\"$I\n\u0004\u0001E)\u0002C\u0001\n\u0014\u001b\u0005a\u0011B\u0001\u000b\r\u0005\r\te.\u001f\t\u0005-]A\u0002%D\u0001\u000b\u0013\t9!\u0002\u0005\u0002\u001a51\u0001A!B\u000e\u0001\u0005\u0004a\"!A!\u0012\u0005u\t\u0002C\u0001\n\u001f\u0013\tyBBA\u0004O_RD\u0017N\\4\u0011\u0005e\tCA\u0002\u0012\u0001\t\u000b\u0007AD\u0001\u0003SKB\u0014\u0018A\u0002\u0013j]&$H\u0005F\u0001&!\t\u0011b%\u0003\u0002(\u0019\t!QK\\5u\u00039!\b.[:D_2dWm\u0019;j_:,\u0012A\u000b\t\u0004W1BR\"\u0001\u0005\n\u00055B!AC%oI\u0016DX\rZ*fc\u0006aAo\\\"pY2,7\r^5p]R\u0011!\u0006\r\u0005\u0006c\r\u0001\r\u0001I\u0001\u0005e\u0016\u0004(/\u0001\u0004va\u0012\fG/\u001a\u000b\u0004KQJ\u0004\"B\u001b\u0005\u0001\u00041\u0014aA5eqB\u0011!cN\u0005\u0003q1\u00111!\u00138u\u0011\u0015QD\u00011\u0001\u0019\u0003\u0011)G.Z7\u0002\tYLWm^\u000b\u0002{I\u0019a\bQ\"\u0007\t}*\u0001!\u0010\u0002\ryI,g-\u001b8f[\u0016tGO\u0010\t\u0003%\u0005K!A\u0011\u0007\u0003\r\u0005s\u0017PU3g!\u0011YC\t\u0007\u0011\n\u0005\u0015C!AD%oI\u0016DX\rZ*fcZKWm\u001e\u000b\u0004\u0007\u001eK\u0005\"\u0002%\u0007\u0001\u00041\u0014\u0001\u00024s_6DQA\u0013\u0004A\u0002Y\nQ!\u001e8uS2\u0004")
public interface IndexedSeqLike<A, Repr>
extends scala.collection.IndexedSeqLike<A, Repr> {
    public static /* synthetic */ IndexedSeq thisCollection$(IndexedSeqLike $this) {
        return $this.thisCollection();
    }

    @Override
    default public IndexedSeq<A> thisCollection() {
        return (IndexedSeq)this;
    }

    public static /* synthetic */ IndexedSeq toCollection$(IndexedSeqLike $this, Object repr) {
        return $this.toCollection(repr);
    }

    @Override
    default public IndexedSeq<A> toCollection(Repr repr) {
        return (IndexedSeq)repr;
    }

    public void update(int var1, A var2);

    public static /* synthetic */ IndexedSeqView view$(IndexedSeqLike $this) {
        return $this.view();
    }

    @Override
    default public IndexedSeqView<A, Repr> view() {
        return new IndexedSeqView<A, Repr>(this){
            private Repr underlying;
            private volatile boolean bitmap$0;
            private final /* synthetic */ IndexedSeqLike $outer;

            public /* synthetic */ IndexedSeqView scala$collection$mutable$IndexedSeqView$$super$tail() {
                return (IndexedSeqView)TraversableViewLike.tail$(this);
            }

            public IndexedSeqView.Transformed<A> newFiltered(Function1<A, Object> p) {
                return IndexedSeqView.newFiltered$(this, p);
            }

            public IndexedSeqView.Transformed<A> newSliced(SliceInterval _endpoints) {
                return IndexedSeqView.newSliced$(this, _endpoints);
            }

            public IndexedSeqView.Transformed<A> newDroppedWhile(Function1<A, Object> p) {
                return IndexedSeqView.newDroppedWhile$(this, p);
            }

            public IndexedSeqView.Transformed<A> newTakenWhile(Function1<A, Object> p) {
                return IndexedSeqView.newTakenWhile$(this, p);
            }

            public IndexedSeqView.Transformed<A> newReversed() {
                return IndexedSeqView.newReversed$(this);
            }

            public IndexedSeqView<A, Repr> filter(Function1<A, Object> p) {
                return IndexedSeqView.filter$(this, p);
            }

            public IndexedSeqView<A, Repr> init() {
                return IndexedSeqView.init$(this);
            }

            public IndexedSeqView<A, Repr> drop(int n) {
                return IndexedSeqView.drop$(this, n);
            }

            public IndexedSeqView<A, Repr> take(int n) {
                return IndexedSeqView.take$(this, n);
            }

            public IndexedSeqView<A, Repr> slice(int from, int until) {
                return IndexedSeqView.slice$(this, from, until);
            }

            public IndexedSeqView<A, Repr> dropWhile(Function1<A, Object> p) {
                return IndexedSeqView.dropWhile$(this, p);
            }

            public IndexedSeqView<A, Repr> takeWhile(Function1<A, Object> p) {
                return IndexedSeqView.takeWhile$(this, p);
            }

            public Tuple2<IndexedSeqView<A, Repr>, IndexedSeqView<A, Repr>> span(Function1<A, Object> p) {
                return IndexedSeqView.span$(this, p);
            }

            public Tuple2<IndexedSeqView<A, Repr>, IndexedSeqView<A, Repr>> splitAt(int n) {
                return IndexedSeqView.splitAt$(this, n);
            }

            public IndexedSeqView<A, Repr> reverse() {
                return IndexedSeqView.reverse$(this);
            }

            public IndexedSeqView<A, Repr> tail() {
                return IndexedSeqView.tail$(this);
            }

            public <B> SeqViewLike.Transformed<B> newForced(Function0<GenSeq<B>> xs) {
                return SeqViewLike.newForced$(this, xs);
            }

            public <B> SeqViewLike.Transformed<B> newAppended(GenTraversable<B> that) {
                return SeqViewLike.newAppended$(this, that);
            }

            public <B> SeqViewLike.Transformed<B> newPrepended(GenTraversable<B> that) {
                return SeqViewLike.newPrepended$(this, that);
            }

            public <B> SeqViewLike.Transformed<B> newMapped(Function1<A, B> f) {
                return SeqViewLike.newMapped$(this, f);
            }

            public <B> SeqViewLike.Transformed<B> newFlatMapped(Function1<A, GenTraversableOnce<B>> f) {
                return SeqViewLike.newFlatMapped$(this, f);
            }

            public <B> SeqViewLike.Transformed<Tuple2<A, B>> newZipped(GenIterable<B> that) {
                return SeqViewLike.newZipped$(this, that);
            }

            public <A1, B> SeqViewLike.Transformed<Tuple2<A1, B>> newZippedAll(GenIterable<B> that, A1 _thisElem, B _thatElem) {
                return SeqViewLike.newZippedAll$(this, that, _thisElem, _thatElem);
            }

            public <B> SeqViewLike.Transformed<B> newPatched(int _from, GenSeq<B> _patch, int _replaced) {
                return SeqViewLike.newPatched$(this, _from, _patch, _replaced);
            }

            public SeqViewLike.Transformed<A> newTaken(int n) {
                return SeqViewLike.newTaken$(this, n);
            }

            public SeqViewLike.Transformed<A> newDropped(int n) {
                return SeqViewLike.newDropped$(this, n);
            }

            public <B, That> That patch(int from, GenSeq<B> patch, int replaced, CanBuildFrom<IndexedSeqView<A, Repr>, B, That> bf) {
                return (That)SeqViewLike.patch$(this, from, patch, replaced, bf);
            }

            public <B, That> That padTo(int len, B elem, CanBuildFrom<IndexedSeqView<A, Repr>, B, That> bf) {
                return (That)SeqViewLike.padTo$(this, len, elem, bf);
            }

            public <B, That> That reverseMap(Function1<A, B> f, CanBuildFrom<IndexedSeqView<A, Repr>, B, That> bf) {
                return (That)SeqViewLike.reverseMap$(this, f, bf);
            }

            public <B, That> That updated(int index, B elem, CanBuildFrom<IndexedSeqView<A, Repr>, B, That> bf) {
                return (That)SeqViewLike.updated$(this, index, elem, bf);
            }

            public <B, That> That $plus$colon(B elem, CanBuildFrom<IndexedSeqView<A, Repr>, B, That> bf) {
                return (That)SeqViewLike.$plus$colon$(this, elem, bf);
            }

            public <B, That> That $colon$plus(B elem, CanBuildFrom<IndexedSeqView<A, Repr>, B, That> bf) {
                return (That)SeqViewLike.$colon$plus$(this, elem, bf);
            }

            public <B, That> That union(GenSeq<B> that, CanBuildFrom<IndexedSeqView<A, Repr>, B, That> bf) {
                return (That)SeqViewLike.union$(this, that, bf);
            }

            public SeqView diff(GenSeq that) {
                return SeqViewLike.diff$(this, that);
            }

            public SeqView intersect(GenSeq that) {
                return SeqViewLike.intersect$(this, that);
            }

            public SeqView sorted(Ordering ord) {
                return SeqViewLike.sorted$(this, ord);
            }

            public SeqView sortWith(Function2 lt) {
                return SeqViewLike.sortWith$(this, lt);
            }

            public SeqView sortBy(Function1 f, Ordering ord) {
                return SeqViewLike.sortBy$(this, f, ord);
            }

            public Iterator<IndexedSeqView<A, Repr>> combinations(int n) {
                return SeqViewLike.combinations$(this, n);
            }

            public Iterator<IndexedSeqView<A, Repr>> permutations() {
                return SeqViewLike.permutations$(this);
            }

            public SeqView distinct() {
                return SeqViewLike.distinct$(this);
            }

            public String stringPrefix() {
                return SeqViewLike.stringPrefix$(this);
            }

            public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<IndexedSeqView<A, Repr>, Tuple2<A1, B>, That> bf) {
                return (That)IterableViewLike.zip$(this, that, bf);
            }

            public <A1, That> That zipWithIndex(CanBuildFrom<IndexedSeqView<A, Repr>, Tuple2<A1, Object>, That> bf) {
                return (That)IterableViewLike.zipWithIndex$(this, bf);
            }

            public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<IndexedSeqView<A, Repr>, Tuple2<A1, B>, That> bf) {
                return (That)IterableViewLike.zipAll$(this, that, thisElem, thatElem, bf);
            }

            public Iterator<IndexedSeqView<A, Repr>> grouped(int size) {
                return IterableViewLike.grouped$(this, size);
            }

            public Iterator<IndexedSeqView<A, Repr>> sliding(int size, int step) {
                return IterableViewLike.sliding$(this, size, step);
            }

            public Iterator<IndexedSeqView<A, Repr>> sliding(int size) {
                return IterableViewLike.sliding$(this, size);
            }

            public IterableView dropRight(int n) {
                return IterableViewLike.dropRight$(this, n);
            }

            public IterableView takeRight(int n) {
                return IterableViewLike.takeRight$(this, n);
            }

            public /* synthetic */ TraversableView scala$collection$TraversableViewLike$$super$tail() {
                return (TraversableView)IndexedSeqOptimized.tail$(this);
            }

            public String viewIdentifier() {
                return TraversableViewLike.viewIdentifier$(this);
            }

            public String viewIdString() {
                return TraversableViewLike.viewIdString$(this);
            }

            public String viewToString() {
                return TraversableViewLike.viewToString$(this);
            }

            public Builder<A, IndexedSeqView<A, Repr>> newBuilder() {
                return TraversableViewLike.newBuilder$(this);
            }

            public <B, That> That force(CanBuildFrom<Repr, B, That> bf) {
                return (That)TraversableViewLike.force$(this, bf);
            }

            public <B, That> That $plus$plus(GenTraversableOnce<B> xs, CanBuildFrom<IndexedSeqView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.$plus$plus$(this, xs, bf);
            }

            public <B, That> That $plus$plus$colon(TraversableOnce<B> xs, CanBuildFrom<IndexedSeqView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.$plus$plus$colon$((TraversableViewLike)this, xs, bf);
            }

            public <B, That> That $plus$plus$colon(Traversable<B> xs, CanBuildFrom<IndexedSeqView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.$plus$plus$colon$((TraversableViewLike)this, xs, bf);
            }

            public <B, That> That map(Function1<A, B> f, CanBuildFrom<IndexedSeqView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.map$(this, f, bf);
            }

            public <B, That> That collect(PartialFunction<A, B> pf, CanBuildFrom<IndexedSeqView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.collect$(this, pf, bf);
            }

            public <B, That> That flatMap(Function1<A, GenTraversableOnce<B>> f, CanBuildFrom<IndexedSeqView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.flatMap$(this, f, bf);
            }

            public <B> TraversableViewLike.Transformed<B> flatten(Function1<A, GenTraversableOnce<B>> asTraversable) {
                return TraversableViewLike.flatten$(this, asTraversable);
            }

            public TraversableView withFilter(Function1 p) {
                return TraversableViewLike.withFilter$(this, p);
            }

            public Tuple2<IndexedSeqView<A, Repr>, IndexedSeqView<A, Repr>> partition(Function1<A, Object> p) {
                return TraversableViewLike.partition$(this, p);
            }

            public <B, That> That scanLeft(B z, Function2<B, A, B> op, CanBuildFrom<IndexedSeqView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.scanLeft$(this, z, op, bf);
            }

            public <B, That> That scanRight(B z, Function2<A, B, B> op, CanBuildFrom<IndexedSeqView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.scanRight$(this, z, op, bf);
            }

            public <K> Map<K, IndexedSeqView<A, Repr>> groupBy(Function1<A, K> f) {
                return TraversableViewLike.groupBy$(this, f);
            }

            public <A1, A2> Tuple2<TraversableViewLike.Transformed<A1>, TraversableViewLike.Transformed<A2>> unzip(Function1<A, Tuple2<A1, A2>> asPair) {
                return TraversableViewLike.unzip$(this, asPair);
            }

            public <A1, A2, A3> Tuple3<TraversableViewLike.Transformed<A1>, TraversableViewLike.Transformed<A2>, TraversableViewLike.Transformed<A3>> unzip3(Function1<A, Tuple3<A1, A2, A3>> asTriple) {
                return TraversableViewLike.unzip3$(this, asTriple);
            }

            public TraversableView filterNot(Function1 p) {
                return TraversableViewLike.filterNot$(this, p);
            }

            public Iterator<IndexedSeqView<A, Repr>> inits() {
                return TraversableViewLike.inits$(this);
            }

            public Iterator<IndexedSeqView<A, Repr>> tails() {
                return TraversableViewLike.tails$(this);
            }

            public String toString() {
                return TraversableViewLike.toString$(this);
            }

            public Seq<A> thisSeq() {
                return ViewMkString.thisSeq$(this);
            }

            public String mkString() {
                return ViewMkString.mkString$(this);
            }

            public String mkString(String sep) {
                return ViewMkString.mkString$(this, sep);
            }

            public String mkString(String start, String sep, String end) {
                return ViewMkString.mkString$(this, start, sep, end);
            }

            public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
                return ViewMkString.addString$(this, b, start, sep, end);
            }

            public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceLeft(Function2 op) {
                return TraversableOnce.reduceLeft$(this, op);
            }

            public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceRight(Function2 op) {
                return this.iterator().reduceRight(op);
            }

            public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$zip(GenIterable that, CanBuildFrom bf) {
                return IterableLike.zip$(this, that, bf);
            }

            public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$head() {
                return IterableLike.head$(this);
            }

            public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$tail() {
                return TraversableLike.tail$(this);
            }

            public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$last() {
                return TraversableLike.last$(this);
            }

            public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$init() {
                return TraversableLike.init$(this);
            }

            public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$sameElements(GenIterable that) {
                return IterableLike.sameElements$(this, that);
            }

            public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$endsWith(GenSeq that) {
                return scala.collection.SeqLike.endsWith$(this, that);
            }

            public boolean isEmpty() {
                return IndexedSeqOptimized.isEmpty$(this);
            }

            public <U> void foreach(Function1<A, U> f) {
                IndexedSeqOptimized.foreach$(this, f);
            }

            public boolean forall(Function1<A, Object> p) {
                return IndexedSeqOptimized.forall$(this, p);
            }

            public boolean exists(Function1<A, Object> p) {
                return IndexedSeqOptimized.exists$(this, p);
            }

            public Option<A> find(Function1<A, Object> p) {
                return IndexedSeqOptimized.find$(this, p);
            }

            public <B> B foldLeft(B z, Function2<B, A, B> op) {
                return (B)IndexedSeqOptimized.foldLeft$(this, z, op);
            }

            public <B> B foldRight(B z, Function2<A, B, B> op) {
                return (B)IndexedSeqOptimized.foldRight$(this, z, op);
            }

            public <B> B reduceLeft(Function2<B, A, B> op) {
                return (B)IndexedSeqOptimized.reduceLeft$(this, op);
            }

            public <B> B reduceRight(Function2<A, B, B> op) {
                return (B)IndexedSeqOptimized.reduceRight$(this, op);
            }

            public A head() {
                return (A)IndexedSeqOptimized.head$(this);
            }

            public A last() {
                return (A)IndexedSeqOptimized.last$(this);
            }

            public <B> boolean sameElements(GenIterable<B> that) {
                return IndexedSeqOptimized.sameElements$(this, that);
            }

            public <B> void copyToArray(Object xs, int start, int len) {
                IndexedSeqOptimized.copyToArray$(this, xs, start, len);
            }

            public int lengthCompare(int len) {
                return IndexedSeqOptimized.lengthCompare$(this, len);
            }

            public int segmentLength(Function1<A, Object> p, int from) {
                return IndexedSeqOptimized.segmentLength$(this, p, from);
            }

            public int indexWhere(Function1<A, Object> p, int from) {
                return IndexedSeqOptimized.indexWhere$(this, p, from);
            }

            public int lastIndexWhere(Function1<A, Object> p, int end) {
                return IndexedSeqOptimized.lastIndexWhere$(this, p, end);
            }

            public Iterator<A> reverseIterator() {
                return IndexedSeqOptimized.reverseIterator$(this);
            }

            public <B> boolean startsWith(GenSeq<B> that, int offset) {
                return IndexedSeqOptimized.startsWith$(this, that, offset);
            }

            public <B> boolean endsWith(GenSeq<B> that) {
                return IndexedSeqOptimized.endsWith$(this, that);
            }

            public List<A> toList() {
                return IndexedSeqOptimized.toList$(this);
            }

            public GenericCompanion<IndexedSeq> companion() {
                return IndexedSeq.companion$(this);
            }

            public IndexedSeq<A> seq() {
                return IndexedSeq.seq$(this);
            }

            public IndexedSeq<A> thisCollection() {
                return IndexedSeqLike.thisCollection$(this);
            }

            public IndexedSeq toCollection(Object repr) {
                return IndexedSeqLike.toCollection$(this, repr);
            }

            public IndexedSeqView<A, IndexedSeqView<A, Repr>> view() {
                return IndexedSeqLike.view$(this);
            }

            public IndexedSeqView<A, IndexedSeqView<A, Repr>> view(int from, int until) {
                return IndexedSeqLike.view$(this, from, until);
            }

            public int hashCode() {
                return scala.collection.IndexedSeqLike.hashCode$(this);
            }

            public <A1> Buffer<A1> toBuffer() {
                return scala.collection.IndexedSeqLike.toBuffer$(this);
            }

            public int sizeHintIfCheap() {
                return scala.collection.IndexedSeqLike.sizeHintIfCheap$(this);
            }

            public Combiner<A, ParSeq<A>> parCombiner() {
                return SeqLike.parCombiner$(this);
            }

            public SeqLike<A, scala.collection.mutable.Seq<A>> transform(Function1<A, A> f) {
                return SeqLike.transform$(this, f);
            }

            public /* synthetic */ Object scala$collection$mutable$Cloneable$$super$clone() {
                return super.clone();
            }

            public Object clone() {
                return Cloneable.clone$(this);
            }

            public int size() {
                return scala.collection.SeqLike.size$(this);
            }

            public <B> int indexOfSlice(GenSeq<B> that) {
                return scala.collection.SeqLike.indexOfSlice$(this, that);
            }

            public <B> int indexOfSlice(GenSeq<B> that, int from) {
                return scala.collection.SeqLike.indexOfSlice$(this, that, from);
            }

            public <B> int lastIndexOfSlice(GenSeq<B> that) {
                return scala.collection.SeqLike.lastIndexOfSlice$(this, that);
            }

            public <B> int lastIndexOfSlice(GenSeq<B> that, int end) {
                return scala.collection.SeqLike.lastIndexOfSlice$(this, that, end);
            }

            public <B> boolean containsSlice(GenSeq<B> that) {
                return scala.collection.SeqLike.containsSlice$(this, that);
            }

            public <A1> boolean contains(A1 elem) {
                return scala.collection.SeqLike.contains$(this, elem);
            }

            public <B> boolean corresponds(GenSeq<B> that, Function2<A, B, Object> p) {
                return scala.collection.SeqLike.corresponds$(this, that, p);
            }

            public Seq<A> toSeq() {
                return scala.collection.SeqLike.toSeq$(this);
            }

            public Range indices() {
                return scala.collection.SeqLike.indices$(this);
            }

            public boolean isDefinedAt(int idx) {
                return GenSeqLike.isDefinedAt$(this, idx);
            }

            public int prefixLength(Function1<A, Object> p) {
                return GenSeqLike.prefixLength$(this, p);
            }

            public int indexWhere(Function1<A, Object> p) {
                return GenSeqLike.indexWhere$(this, p);
            }

            public <B> int indexOf(B elem) {
                return GenSeqLike.indexOf$(this, elem);
            }

            public <B> int indexOf(B elem, int from) {
                return GenSeqLike.indexOf$(this, elem, from);
            }

            public <B> int lastIndexOf(B elem) {
                return GenSeqLike.lastIndexOf$(this, elem);
            }

            public <B> int lastIndexOf(B elem, int end) {
                return GenSeqLike.lastIndexOf$(this, elem, end);
            }

            public int lastIndexWhere(Function1<A, Object> p) {
                return GenSeqLike.lastIndexWhere$(this, p);
            }

            public <B> boolean startsWith(GenSeq<B> that) {
                return GenSeqLike.startsWith$(this, that);
            }

            public boolean equals(Object that) {
                return GenSeqLike.equals$(this, that);
            }

            public <A1, B1> PartialFunction<A1, B1> orElse(PartialFunction<A1, B1> that) {
                return PartialFunction.orElse$(this, that);
            }

            public <C> PartialFunction<Object, C> andThen(Function1<A, C> k) {
                return PartialFunction.andThen$(this, k);
            }

            public Function1<Object, Option<A>> lift() {
                return PartialFunction.lift$(this);
            }

            public Object applyOrElse(Object x, Function1 function1) {
                return PartialFunction.applyOrElse$(this, x, function1);
            }

            public <U> Function1<Object, Object> runWith(Function1<A, U> action) {
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

            public <A> Function1<A, A> compose(Function1<A, Object> g) {
                return Function1.compose$(this, g);
            }

            public Iterable<A> toIterable() {
                return IterableLike.toIterable$(this);
            }

            public Iterator<A> toIterator() {
                return IterableLike.toIterator$(this);
            }

            public Stream<A> toStream() {
                return IterableLike.toStream$(this);
            }

            public boolean canEqual(Object that) {
                return IterableLike.canEqual$(this, that);
            }

            public <B> Builder<B, IndexedSeq<B>> genericBuilder() {
                return GenericTraversableTemplate.genericBuilder$(this);
            }

            public GenTraversable transpose(Function1 asTraversable) {
                return GenericTraversableTemplate.transpose$(this, asTraversable);
            }

            public Object repr() {
                return TraversableLike.repr$(this);
            }

            public final boolean isTraversableAgain() {
                return TraversableLike.isTraversableAgain$(this);
            }

            public boolean hasDefiniteSize() {
                return TraversableLike.hasDefiniteSize$(this);
            }

            public Object filterImpl(Function1 p, boolean isFlipped) {
                return TraversableLike.filterImpl$(this, p, isFlipped);
            }

            public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<IndexedSeqView<A, Repr>, B, That> cbf) {
                return (That)TraversableLike.scan$(this, z, op, cbf);
            }

            public Option<A> headOption() {
                return TraversableLike.headOption$(this);
            }

            public Option<A> lastOption() {
                return TraversableLike.lastOption$(this);
            }

            public Object sliceWithKnownDelta(int from, int until, int delta) {
                return TraversableLike.sliceWithKnownDelta$(this, from, until, delta);
            }

            public Object sliceWithKnownBound(int from, int until) {
                return TraversableLike.sliceWithKnownBound$(this, from, until);
            }

            public Traversable<A> toTraversable() {
                return TraversableLike.toTraversable$(this);
            }

            public <Col> Col to(CanBuildFrom<Nothing$, A, Col> cbf) {
                return (Col)TraversableLike.to$(this, cbf);
            }

            public Parallel par() {
                return Parallelizable.par$(this);
            }

            public List<A> reversed() {
                return TraversableOnce.reversed$(this);
            }

            public boolean nonEmpty() {
                return TraversableOnce.nonEmpty$(this);
            }

            public int count(Function1<A, Object> p) {
                return TraversableOnce.count$(this, p);
            }

            public <B> Option<B> collectFirst(PartialFunction<A, B> pf) {
                return TraversableOnce.collectFirst$(this, pf);
            }

            public <B> B $div$colon(B z, Function2<B, A, B> op) {
                return (B)TraversableOnce.$div$colon$(this, z, op);
            }

            public <B> B $colon$bslash(B z, Function2<A, B, B> op) {
                return (B)TraversableOnce.$colon$bslash$(this, z, op);
            }

            public <B> Option<B> reduceLeftOption(Function2<B, A, B> op) {
                return TraversableOnce.reduceLeftOption$(this, op);
            }

            public <B> Option<B> reduceRightOption(Function2<A, B, B> op) {
                return TraversableOnce.reduceRightOption$(this, op);
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

            public <B> B sum(Numeric<B> num) {
                return (B)TraversableOnce.sum$(this, num);
            }

            public <B> B product(Numeric<B> num) {
                return (B)TraversableOnce.product$(this, num);
            }

            public <B> A min(Ordering<B> cmp) {
                return (A)TraversableOnce.min$(this, cmp);
            }

            public <B> A max(Ordering<B> cmp) {
                return (A)TraversableOnce.max$(this, cmp);
            }

            public <B> A maxBy(Function1<A, B> f, Ordering<B> cmp) {
                return (A)TraversableOnce.maxBy$(this, f, cmp);
            }

            public <B> A minBy(Function1<A, B> f, Ordering<B> cmp) {
                return (A)TraversableOnce.minBy$(this, f, cmp);
            }

            public <B> void copyToBuffer(Buffer<B> dest) {
                TraversableOnce.copyToBuffer$(this, dest);
            }

            public <B> void copyToArray(Object xs, int start) {
                TraversableOnce.copyToArray$(this, xs, start);
            }

            public <B> void copyToArray(Object xs) {
                TraversableOnce.copyToArray$(this, xs);
            }

            public <B> Object toArray(ClassTag<B> evidence$1) {
                return TraversableOnce.toArray$(this, evidence$1);
            }

            public scala.collection.immutable.IndexedSeq<A> toIndexedSeq() {
                return TraversableOnce.toIndexedSeq$(this);
            }

            public <B> Set<B> toSet() {
                return TraversableOnce.toSet$(this);
            }

            public Vector<A> toVector() {
                return TraversableOnce.toVector$(this);
            }

            public <T, U> Map<T, U> toMap(Predef$.less.colon.less<A, Tuple2<T, U>> ev) {
                return TraversableOnce.toMap$(this, ev);
            }

            public StringBuilder addString(StringBuilder b, String sep) {
                return TraversableOnce.addString$(this, b, sep);
            }

            public StringBuilder addString(StringBuilder b) {
                return TraversableOnce.addString$(this, b);
            }

            private Repr underlying$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.underlying = this.$outer.repr();
                        this.bitmap$0 = true;
                    }
                }
                return this.underlying;
            }

            public Repr underlying() {
                if (!this.bitmap$0) {
                    return this.underlying$lzycompute();
                }
                return this.underlying;
            }

            public Iterator<A> iterator() {
                return this.$outer.iterator();
            }

            public int length() {
                return this.$outer.length();
            }

            public A apply(int idx) {
                return this.$outer.apply(idx);
            }

            public void update(int idx, A elem) {
                this.$outer.update(idx, elem);
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
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
                PartialFunction.$init$(this);
                GenSeqLike.$init$(this);
                GenSeq.$init$(this);
                scala.collection.SeqLike.$init$(this);
                Seq.$init$(this);
                Cloneable.$init$(this);
                SeqLike.$init$(this);
                scala.collection.mutable.Seq.$init$(this);
                scala.collection.IndexedSeqLike.$init$(this);
                scala.collection.IndexedSeq.$init$(this);
                IndexedSeqLike.$init$(this);
                IndexedSeq.$init$(this);
                IndexedSeqOptimized.$init$(this);
                ViewMkString.$init$(this);
                TraversableViewLike.$init$(this);
                IterableViewLike.$init$(this);
                SeqViewLike.$init$(this);
                IndexedSeqView.$init$(this);
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$groupBy$1(scala.collection.TraversableViewLike scala.collection.Seq ), $anonfun$sortBy$1(scala.collection.SeqViewLike scala.Function1 scala.math.Ordering ), $anonfun$sortWith$1(scala.collection.SeqViewLike scala.Function2 )}, serializedLambda);
            }
        };
    }

    public static /* synthetic */ IndexedSeqView view$(IndexedSeqLike $this, int from, int until) {
        return $this.view(from, until);
    }

    @Override
    default public IndexedSeqView<A, Repr> view(int from, int until) {
        return this.view().slice(from, until);
    }

    public static void $init$(IndexedSeqLike $this) {
    }
}

