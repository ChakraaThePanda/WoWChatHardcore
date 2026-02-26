/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.mutable;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.BufferedIterator;
import scala.collection.DebugUtils$;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.Iterator$;
import scala.collection.Seq;
import scala.collection.Traversable;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.DelegatedSignalling;
import scala.collection.generic.Signalling;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.FlatHashTable;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.AugmentedIterableIterator;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.IterableSplitter;
import scala.collection.parallel.ParIterable;
import scala.collection.parallel.RemainsIterator;
import scala.collection.parallel.SeqSplitter;
import scala.collection.parallel.mutable.SizeMapUtils;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0005%ba\u0002\r\u001a!\u0003\r\tA\t\u0005\u0006q\u0001!\t!\u000f\u0005\u0006{\u0001!\tE\u0010\u0004\u0006\u0005\u0002\t\ta\u0011\u0005\t\u0019\u000e\u0011\t\u0019!C\u0001\u001b\"A\u0011k\u0001BA\u0002\u0013\u0005!\u000b\u0003\u0005V\u0007\t\u0005\t\u0015)\u0003O\u0011!16A!b\u0001\n\u0003i\u0005\u0002C,\u0004\u0005\u0003\u0005\u000b\u0011\u0002(\t\u0011a\u001b!Q1A\u0005\u00025C\u0001\"W\u0002\u0003\u0002\u0003\u0006IA\u0014\u0005\u00065\u000e!\ta\u0017\u0005\u0007C\u000e\u0001\u000b\u0015\u0002(\t\r\t\u001c\u0001\u0015!\u0003d\u0011\u001917\u0001)C\u0005s!)qm\u0001D\u0001Q\")Qn\u0001C\u0001\u001b\")an\u0001C\u0001}!)qn\u0001C\u0001a\")\u0011o\u0001C\u0001e\")1o\u0001C\u0001i\")Ap\u0001C!{\"9\u00111C\u0002\u0005\u0012\u0005U\u0001bBA\u000f\u0007\u0011E\u0011q\u0004\u0002\u0011!\u0006\u0014h\t\\1u\u0011\u0006\u001c\b\u000eV1cY\u0016T!AG\u000e\u0002\u000f5,H/\u00192mK*\u0011A$H\u0001\ta\u0006\u0014\u0018\r\u001c7fY*\u0011adH\u0001\u000bG>dG.Z2uS>t'\"\u0001\u0011\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u00111eL\n\u0004\u0001\u0011B\u0003CA\u0013'\u001b\u0005y\u0012BA\u0014 \u0005\u0019\te.\u001f*fMB\u0019\u0011fK\u0017\u000e\u0003)R!AG\u000f\n\u00051R#!\u0004$mCRD\u0015m\u001d5UC\ndW\r\u0005\u0002/_1\u0001A!\u0002\u0019\u0001\u0005\u0004\t$!\u0001+\u0012\u0005I*\u0004CA\u00134\u0013\t!tDA\u0004O_RD\u0017N\\4\u0011\u0005\u00152\u0014BA\u001c \u0005\r\te._\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0015\u0003i\u0002\"!J\u001e\n\u0005qz\"\u0001B+oSR\f\u0011#\u00197xCf\u001c\u0018J\\5u'&TX-T1q+\u0005y\u0004CA\u0013A\u0013\t\tuDA\u0004C_>dW-\u00198\u00031A\u000b'O\u00127bi\"\u000b7\u000f\u001b+bE2,\u0017\n^3sCR|'o\u0005\u0003\u0004I\u0011C\u0005cA#G[5\t1$\u0003\u0002H7\t\u0001\u0012\n^3sC\ndWm\u00159mSR$XM\u001d\t\u0003\u0013*k\u0011!G\u0005\u0003\u0017f\u0011AbU5{K6\u000b\u0007/\u0016;jYN\f1!\u001b3y+\u0005q\u0005CA\u0013P\u0013\t\u0001vDA\u0002J]R\fq!\u001b3y?\u0012*\u0017\u000f\u0006\u0002;'\"9A+BA\u0001\u0002\u0004q\u0015a\u0001=%c\u0005!\u0011\u000e\u001a=!\u0003\u0015)h\u000e^5m\u0003\u0019)h\u000e^5mA\u0005IAo\u001c;bYNL'0Z\u0001\u000bi>$\u0018\r\\:ju\u0016\u0004\u0013A\u0002\u001fj]&$h\b\u0006\u0003]=~\u0003\u0007CA/\u0004\u001b\u0005\u0001\u0001\"\u0002'\f\u0001\u0004q\u0005\"\u0002,\f\u0001\u0004q\u0005\"\u0002-\f\u0001\u0004q\u0015!\u0003;sCZ,'o]3e\u0003%IG/\u001a:uC\ndW\rE\u0002&I\u0012J!!Z\u0010\u0003\u000b\u0005\u0013(/Y=\u0002\tM\u001c\u0017M\\\u0001\f]\u0016<\u0018\n^3sCR|'\u000f\u0006\u0003ES.d\u0007\"\u00026\u0010\u0001\u0004q\u0015!B5oI\u0016D\b\"\u0002,\u0010\u0001\u0004q\u0005\"\u0002-\u0010\u0001\u0004q\u0015!\u0003:f[\u0006Lg.\u001b8h\u0003\u001dA\u0017m\u001d(fqR\fAA\\3yiR\tQ&A\u0002ekB,\u0012\u0001R\u0001\u0006gBd\u0017\u000e^\u000b\u0002kB\u0019a/\u001f#\u000f\u0005\u0015:\u0018B\u0001= \u0003\u001d\u0001\u0018mY6bO\u0016L!A_>\u0003\u0007M+\u0017O\u0003\u0002y?\u0005\u0001B-\u001a2vO&sgm\u001c:nCRLwN\\\u000b\u0002}B\u0019q0!\u0004\u000f\t\u0005\u0005\u0011\u0011\u0002\t\u0004\u0003\u0007yRBAA\u0003\u0015\r\t9!I\u0001\u0007yI|w\u000e\u001e \n\u0007\u0005-q$\u0001\u0004Qe\u0016$WMZ\u0005\u0005\u0003\u001f\t\tB\u0001\u0004TiJLgn\u001a\u0006\u0004\u0003\u0017y\u0012AC2pk:$X\t\\3ngR)a*a\u0006\u0002\u001c!1\u0011\u0011\u0004\fA\u00029\u000bAA\u001a:p[\")aK\u0006a\u0001\u001d\u0006\u00012m\\;oi\n+8m[3u'&TXm\u001d\u000b\u0006\u001d\u0006\u0005\u0012Q\u0005\u0005\u0007\u0003G9\u0002\u0019\u0001(\u0002\u0015\u0019\u0014x.\u001c2vG.,G\u000f\u0003\u0004\u0002(]\u0001\rAT\u0001\fk:$\u0018\u000e\u001c2vG.,G\u000f")
public interface ParFlatHashTable<T>
extends FlatHashTable<T> {
    public static /* synthetic */ boolean alwaysInitSizeMap$(ParFlatHashTable $this) {
        return $this.alwaysInitSizeMap();
    }

    @Override
    default public boolean alwaysInitSizeMap() {
        return true;
    }

    public static void $init$(ParFlatHashTable $this) {
    }

    public abstract class ParFlatHashTableIterator
    implements IterableSplitter<T>,
    SizeMapUtils {
        private int idx;
        private final int until;
        private final int totalsize;
        private int traversed;
        private final Object[] itertable;
        private Signalling signalDelegate;
        public final /* synthetic */ ParFlatHashTable $outer;

        @Override
        public int calcNumElems(int from, int until, int tableLength, int sizeMapBucketSize) {
            return SizeMapUtils.calcNumElems$(this, from, until, tableLength, sizeMapBucketSize);
        }

        @Override
        public Seq<IterableSplitter<T>> splitWithSignalling() {
            return IterableSplitter.splitWithSignalling$(this);
        }

        @Override
        public <S> boolean shouldSplitFurther(ParIterable<S> coll, int parallelismLevel) {
            return IterableSplitter.shouldSplitFurther$(this, coll, parallelismLevel);
        }

        @Override
        public String buildString(Function1<Function1<String, BoxedUnit>, BoxedUnit> closure) {
            return IterableSplitter.buildString$(this, closure);
        }

        @Override
        public IterableSplitter.Taken newTaken(int until) {
            return IterableSplitter.newTaken$(this, until);
        }

        @Override
        public <U extends IterableSplitter.Taken> U newSliceInternal(U it, int from1) {
            return (U)IterableSplitter.newSliceInternal$(this, it, from1);
        }

        @Override
        public IterableSplitter<T> drop(int n) {
            return IterableSplitter.drop$(this, n);
        }

        @Override
        public IterableSplitter<T> take(int n) {
            return IterableSplitter.take$(this, n);
        }

        @Override
        public IterableSplitter<T> slice(int from1, int until1) {
            return IterableSplitter.slice$(this, from1, until1);
        }

        @Override
        public <S> IterableSplitter.Mapped<S> map(Function1<T, S> f) {
            return IterableSplitter.map$(this, f);
        }

        @Override
        public <U, PI extends IterableSplitter<U>> IterableSplitter.Appended<U, PI> appendParIterable(PI that) {
            return IterableSplitter.appendParIterable$(this, that);
        }

        @Override
        public <S> IterableSplitter.Zipped<S> zipParSeq(SeqSplitter<S> that) {
            return IterableSplitter.zipParSeq$(this, that);
        }

        @Override
        public <S, U, R> IterableSplitter.ZippedAll<U, R> zipAllParSeq(SeqSplitter<S> that, U thisElem, R thatElem) {
            return IterableSplitter.zipAllParSeq$(this, that, thisElem, thatElem);
        }

        @Override
        public boolean isAborted() {
            return DelegatedSignalling.isAborted$(this);
        }

        @Override
        public void abort() {
            DelegatedSignalling.abort$(this);
        }

        @Override
        public int indexFlag() {
            return DelegatedSignalling.indexFlag$(this);
        }

        @Override
        public void setIndexFlag(int f) {
            DelegatedSignalling.setIndexFlag$(this, f);
        }

        @Override
        public void setIndexFlagIfGreater(int f) {
            DelegatedSignalling.setIndexFlagIfGreater$(this, f);
        }

        @Override
        public void setIndexFlagIfLesser(int f) {
            DelegatedSignalling.setIndexFlagIfLesser$(this, f);
        }

        @Override
        public int tag() {
            return DelegatedSignalling.tag$(this);
        }

        @Override
        public int count(Function1<T, Object> p) {
            return AugmentedIterableIterator.count$(this, p);
        }

        @Override
        public <U> U reduce(Function2<U, U, U> op) {
            return (U)AugmentedIterableIterator.reduce$(this, op);
        }

        @Override
        public <U> U fold(U z, Function2<U, U, U> op) {
            return (U)AugmentedIterableIterator.fold$(this, z, op);
        }

        @Override
        public <U> U sum(Numeric<U> num) {
            return (U)AugmentedIterableIterator.sum$(this, num);
        }

        @Override
        public <U> U product(Numeric<U> num) {
            return (U)AugmentedIterableIterator.product$(this, num);
        }

        @Override
        public <U> T min(Ordering<U> ord) {
            return AugmentedIterableIterator.min$(this, ord);
        }

        @Override
        public <U> T max(Ordering<U> ord) {
            return AugmentedIterableIterator.max$(this, ord);
        }

        @Override
        public <U> void copyToArray(Object array, int from, int len) {
            AugmentedIterableIterator.copyToArray$(this, array, from, len);
        }

        @Override
        public <U> U reduceLeft(int howmany, Function2<U, U, U> op) {
            return (U)AugmentedIterableIterator.reduceLeft$(this, howmany, op);
        }

        @Override
        public <S, That> Combiner<S, That> map2combiner(Function1<T, S> f, Combiner<S, That> cb) {
            return AugmentedIterableIterator.map2combiner$(this, f, cb);
        }

        @Override
        public <S, That> Combiner<S, That> collect2combiner(PartialFunction<T, S> pf, Combiner<S, That> cb) {
            return AugmentedIterableIterator.collect2combiner$(this, pf, cb);
        }

        @Override
        public <S, That> Combiner<S, That> flatmap2combiner(Function1<T, GenTraversableOnce<S>> f, Combiner<S, That> cb) {
            return AugmentedIterableIterator.flatmap2combiner$(this, f, cb);
        }

        @Override
        public <U, Coll, Bld extends Builder<U, Coll>> Bld copy2builder(Bld b) {
            return (Bld)AugmentedIterableIterator.copy2builder$(this, b);
        }

        @Override
        public <U, This> Combiner<U, This> filter2combiner(Function1<T, Object> pred, Combiner<U, This> cb) {
            return AugmentedIterableIterator.filter2combiner$(this, pred, cb);
        }

        @Override
        public <U, This> Combiner<U, This> filterNot2combiner(Function1<T, Object> pred, Combiner<U, This> cb) {
            return AugmentedIterableIterator.filterNot2combiner$(this, pred, cb);
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> partition2combiners(Function1<T, Object> pred, Combiner<U, This> btrue, Combiner<U, This> bfalse) {
            return AugmentedIterableIterator.partition2combiners$(this, pred, btrue, bfalse);
        }

        @Override
        public <U, This> Combiner<U, This> take2combiner(int n, Combiner<U, This> cb) {
            return AugmentedIterableIterator.take2combiner$(this, n, cb);
        }

        @Override
        public <U, This> Combiner<U, This> drop2combiner(int n, Combiner<U, This> cb) {
            return AugmentedIterableIterator.drop2combiner$(this, n, cb);
        }

        @Override
        public <U, This> Combiner<U, This> slice2combiner(int from, int until, Combiner<U, This> cb) {
            return AugmentedIterableIterator.slice2combiner$(this, from, until, cb);
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> splitAt2combiners(int at, Combiner<U, This> before, Combiner<U, This> after) {
            return AugmentedIterableIterator.splitAt2combiners$(this, at, before, after);
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Object> takeWhile2combiner(Function1<T, Object> p, Combiner<U, This> cb) {
            return AugmentedIterableIterator.takeWhile2combiner$(this, p, cb);
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> span2combiners(Function1<T, Object> p, Combiner<U, This> before, Combiner<U, This> after) {
            return AugmentedIterableIterator.span2combiners$(this, p, before, after);
        }

        @Override
        public <U, A> void scanToArray(U z, Function2<U, U, U> op, Object array, int from) {
            AugmentedIterableIterator.scanToArray$(this, z, op, array, from);
        }

        @Override
        public <U, That> Combiner<U, That> scanToCombiner(U startValue, Function2<U, U, U> op, Combiner<U, That> cb) {
            return AugmentedIterableIterator.scanToCombiner$(this, startValue, op, cb);
        }

        @Override
        public <U, That> Combiner<U, That> scanToCombiner(int howmany, U startValue, Function2<U, U, U> op, Combiner<U, That> cb) {
            return AugmentedIterableIterator.scanToCombiner$(this, howmany, startValue, op, cb);
        }

        @Override
        public <U, S, That> Combiner<Tuple2<U, S>, That> zip2combiner(RemainsIterator<S> otherpit, Combiner<Tuple2<U, S>, That> cb) {
            return AugmentedIterableIterator.zip2combiner$(this, otherpit, cb);
        }

        @Override
        public <U, S, That> Combiner<Tuple2<U, S>, That> zipAll2combiner(RemainsIterator<S> that, U thiselem, S thatelem, Combiner<Tuple2<U, S>, That> cb) {
            return AugmentedIterableIterator.zipAll2combiner$(this, that, thiselem, thatelem, cb);
        }

        @Override
        public boolean isRemainingCheap() {
            return RemainsIterator.isRemainingCheap$(this);
        }

        @Override
        public Iterator<T> seq() {
            return Iterator.seq$(this);
        }

        @Override
        public boolean isEmpty() {
            return Iterator.isEmpty$(this);
        }

        @Override
        public boolean isTraversableAgain() {
            return Iterator.isTraversableAgain$(this);
        }

        @Override
        public boolean hasDefiniteSize() {
            return Iterator.hasDefiniteSize$(this);
        }

        @Override
        public Iterator<T> sliceIterator(int from, int until) {
            return Iterator.sliceIterator$(this, from, until);
        }

        @Override
        public <B> Iterator<B> $plus$plus(Function0<GenTraversableOnce<B>> that) {
            return Iterator.$plus$plus$(this, that);
        }

        @Override
        public <B> Iterator<B> flatMap(Function1<T, GenTraversableOnce<B>> f) {
            return Iterator.flatMap$(this, f);
        }

        @Override
        public Iterator<T> filter(Function1<T, Object> p) {
            return Iterator.filter$(this, p);
        }

        @Override
        public <B> boolean corresponds(GenTraversableOnce<B> that, Function2<T, B, Object> p) {
            return Iterator.corresponds$(this, that, p);
        }

        @Override
        public Iterator<T> withFilter(Function1<T, Object> p) {
            return Iterator.withFilter$(this, p);
        }

        @Override
        public Iterator<T> filterNot(Function1<T, Object> p) {
            return Iterator.filterNot$(this, p);
        }

        @Override
        public <B> Iterator<B> collect(PartialFunction<T, B> pf) {
            return Iterator.collect$(this, pf);
        }

        @Override
        public <B> Iterator<B> scanLeft(B z, Function2<B, T, B> op) {
            return Iterator.scanLeft$(this, z, op);
        }

        @Override
        public <B> Iterator<B> scanRight(B z, Function2<T, B, B> op) {
            return Iterator.scanRight$(this, z, op);
        }

        @Override
        public Iterator<T> takeWhile(Function1<T, Object> p) {
            return Iterator.takeWhile$(this, p);
        }

        @Override
        public Tuple2<Iterator<T>, Iterator<T>> partition(Function1<T, Object> p) {
            return Iterator.partition$(this, p);
        }

        @Override
        public Tuple2<Iterator<T>, Iterator<T>> span(Function1<T, Object> p) {
            return Iterator.span$(this, p);
        }

        @Override
        public Iterator<T> dropWhile(Function1<T, Object> p) {
            return Iterator.dropWhile$(this, p);
        }

        @Override
        public <B> Iterator<Tuple2<T, B>> zip(Iterator<B> that) {
            return Iterator.zip$(this, that);
        }

        @Override
        public <A1> Iterator<A1> padTo(int len, A1 elem) {
            return Iterator.padTo$(this, len, elem);
        }

        @Override
        public Iterator<Tuple2<T, Object>> zipWithIndex() {
            return Iterator.zipWithIndex$(this);
        }

        @Override
        public <B, A1, B1> Iterator<Tuple2<A1, B1>> zipAll(Iterator<B> that, A1 thisElem, B1 thatElem) {
            return Iterator.zipAll$(this, that, thisElem, thatElem);
        }

        @Override
        public <U> void foreach(Function1<T, U> f) {
            Iterator.foreach$(this, f);
        }

        @Override
        public boolean forall(Function1<T, Object> p) {
            return Iterator.forall$(this, p);
        }

        @Override
        public boolean exists(Function1<T, Object> p) {
            return Iterator.exists$(this, p);
        }

        @Override
        public boolean contains(Object elem) {
            return Iterator.contains$(this, elem);
        }

        @Override
        public Option<T> find(Function1<T, Object> p) {
            return Iterator.find$(this, p);
        }

        @Override
        public int indexWhere(Function1<T, Object> p) {
            return Iterator.indexWhere$(this, p);
        }

        @Override
        public int indexWhere(Function1<T, Object> p, int from) {
            return Iterator.indexWhere$(this, p, from);
        }

        @Override
        public <B> int indexOf(B elem) {
            return Iterator.indexOf$(this, elem);
        }

        @Override
        public <B> int indexOf(B elem, int from) {
            return Iterator.indexOf$(this, elem, from);
        }

        @Override
        public BufferedIterator<T> buffered() {
            return Iterator.buffered$(this);
        }

        @Override
        public <B> Iterator.GroupedIterator<B> grouped(int size) {
            return Iterator.grouped$(this, size);
        }

        @Override
        public <B> Iterator.GroupedIterator<B> sliding(int size, int step) {
            return Iterator.sliding$(this, size, step);
        }

        @Override
        public <B> int sliding$default$2() {
            return Iterator.sliding$default$2$(this);
        }

        @Override
        public int length() {
            return Iterator.length$(this);
        }

        @Override
        public Tuple2<Iterator<T>, Iterator<T>> duplicate() {
            return Iterator.duplicate$(this);
        }

        @Override
        public <B> Iterator<B> patch(int from, Iterator<B> patchElems, int replaced) {
            return Iterator.patch$(this, from, patchElems, replaced);
        }

        @Override
        public boolean sameElements(Iterator<?> that) {
            return Iterator.sameElements$(this, that);
        }

        @Override
        public Traversable<T> toTraversable() {
            return Iterator.toTraversable$(this);
        }

        @Override
        public Iterator<T> toIterator() {
            return Iterator.toIterator$(this);
        }

        @Override
        public Stream<T> toStream() {
            return Iterator.toStream$(this);
        }

        @Override
        public String toString() {
            return Iterator.toString$(this);
        }

        @Override
        public List<T> reversed() {
            return TraversableOnce.reversed$(this);
        }

        @Override
        public int size() {
            return TraversableOnce.size$(this);
        }

        @Override
        public boolean nonEmpty() {
            return TraversableOnce.nonEmpty$(this);
        }

        @Override
        public <B> Option<B> collectFirst(PartialFunction<T, B> pf) {
            return TraversableOnce.collectFirst$(this, pf);
        }

        @Override
        public <B> B $div$colon(B z, Function2<B, T, B> op) {
            return (B)TraversableOnce.$div$colon$(this, z, op);
        }

        @Override
        public <B> B $colon$bslash(B z, Function2<T, B, B> op) {
            return (B)TraversableOnce.$colon$bslash$(this, z, op);
        }

        @Override
        public <B> B foldLeft(B z, Function2<B, T, B> op) {
            return (B)TraversableOnce.foldLeft$(this, z, op);
        }

        @Override
        public <B> B foldRight(B z, Function2<T, B, B> op) {
            return (B)TraversableOnce.foldRight$(this, z, op);
        }

        @Override
        public <B> B reduceLeft(Function2<B, T, B> op) {
            return (B)TraversableOnce.reduceLeft$(this, op);
        }

        @Override
        public <B> B reduceRight(Function2<T, B, B> op) {
            return (B)TraversableOnce.reduceRight$(this, op);
        }

        @Override
        public <B> Option<B> reduceLeftOption(Function2<B, T, B> op) {
            return TraversableOnce.reduceLeftOption$(this, op);
        }

        @Override
        public <B> Option<B> reduceRightOption(Function2<T, B, B> op) {
            return TraversableOnce.reduceRightOption$(this, op);
        }

        @Override
        public <A1> Option<A1> reduceOption(Function2<A1, A1, A1> op) {
            return TraversableOnce.reduceOption$(this, op);
        }

        @Override
        public <B> B aggregate(Function0<B> z, Function2<B, T, B> seqop, Function2<B, B, B> combop) {
            return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
        }

        @Override
        public <B> T maxBy(Function1<T, B> f, Ordering<B> cmp) {
            return TraversableOnce.maxBy$(this, f, cmp);
        }

        @Override
        public <B> T minBy(Function1<T, B> f, Ordering<B> cmp) {
            return TraversableOnce.minBy$(this, f, cmp);
        }

        @Override
        public <B> void copyToBuffer(Buffer<B> dest) {
            TraversableOnce.copyToBuffer$(this, dest);
        }

        @Override
        public <B> void copyToArray(Object xs, int start) {
            TraversableOnce.copyToArray$(this, xs, start);
        }

        @Override
        public <B> void copyToArray(Object xs) {
            TraversableOnce.copyToArray$(this, xs);
        }

        @Override
        public <B> Object toArray(ClassTag<B> evidence$1) {
            return TraversableOnce.toArray$(this, evidence$1);
        }

        @Override
        public List<T> toList() {
            return TraversableOnce.toList$(this);
        }

        @Override
        public Iterable<T> toIterable() {
            return TraversableOnce.toIterable$(this);
        }

        @Override
        public Seq<T> toSeq() {
            return TraversableOnce.toSeq$(this);
        }

        @Override
        public IndexedSeq<T> toIndexedSeq() {
            return TraversableOnce.toIndexedSeq$(this);
        }

        @Override
        public <B> Buffer<B> toBuffer() {
            return TraversableOnce.toBuffer$(this);
        }

        @Override
        public <B> Set<B> toSet() {
            return TraversableOnce.toSet$(this);
        }

        @Override
        public Vector<T> toVector() {
            return TraversableOnce.toVector$(this);
        }

        @Override
        public <Col> Col to(CanBuildFrom<Nothing$, T, Col> cbf) {
            return (Col)TraversableOnce.to$(this, cbf);
        }

        @Override
        public <T, U> Map<T, U> toMap(Predef$.less.colon.less<T, Tuple2<T, U>> ev) {
            return TraversableOnce.toMap$(this, ev);
        }

        @Override
        public String mkString(String start, String sep, String end) {
            return TraversableOnce.mkString$(this, start, sep, end);
        }

        @Override
        public String mkString(String sep) {
            return TraversableOnce.mkString$(this, sep);
        }

        @Override
        public String mkString() {
            return TraversableOnce.mkString$(this);
        }

        @Override
        public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
            return TraversableOnce.addString$(this, b, start, sep, end);
        }

        @Override
        public StringBuilder addString(StringBuilder b, String sep) {
            return TraversableOnce.addString$(this, b, sep);
        }

        @Override
        public StringBuilder addString(StringBuilder b) {
            return TraversableOnce.addString$(this, b);
        }

        @Override
        public int sizeHintIfCheap() {
            return GenTraversableOnce.sizeHintIfCheap$(this);
        }

        @Override
        public Signalling signalDelegate() {
            return this.signalDelegate;
        }

        @Override
        public void signalDelegate_$eq(Signalling x$1) {
            this.signalDelegate = x$1;
        }

        public int idx() {
            return this.idx;
        }

        public void idx_$eq(int x$1) {
            this.idx = x$1;
        }

        public int until() {
            return this.until;
        }

        public int totalsize() {
            return this.totalsize;
        }

        private void scan() {
            while (this.itertable[this.idx()] == null) {
                this.idx_$eq(this.idx() + 1);
            }
        }

        public abstract IterableSplitter<T> newIterator(int var1, int var2, int var3);

        @Override
        public int remaining() {
            return this.totalsize() - this.traversed;
        }

        @Override
        public boolean hasNext() {
            return this.traversed < this.totalsize();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public T next() {
            if (this.hasNext()) {
                void var1_1;
                Object r = this.scala$collection$parallel$mutable$ParFlatHashTable$ParFlatHashTableIterator$$$outer().entryToElem(this.itertable[this.idx()]);
                ++this.traversed;
                this.idx_$eq(this.idx() + 1);
                if (this.hasNext()) {
                    this.scan();
                }
                return var1_1;
            }
            return Iterator$.MODULE$.empty().next();
        }

        @Override
        public IterableSplitter<T> dup() {
            return this.newIterator(this.idx(), this.until(), this.totalsize());
        }

        @Override
        public Seq<IterableSplitter<T>> split() {
            if (this.remaining() > 1) {
                int divpt = (this.until() + this.idx()) / 2;
                int fstidx = this.idx();
                int fsttotal = this.calcNumElems(this.idx(), divpt, this.itertable.length, this.scala$collection$parallel$mutable$ParFlatHashTable$ParFlatHashTableIterator$$$outer().sizeMapBucketSize());
                IterableSplitter fstit = this.newIterator(fstidx, divpt, fsttotal);
                int snduntil = this.until();
                int sndtotal = this.remaining() - fsttotal;
                IterableSplitter sndit = this.newIterator(divpt, snduntil, sndtotal);
                return new $colon$colon<Nothing$>((Nothing$)((Object)fstit), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)sndit), Nil$.MODULE$));
            }
            return new $colon$colon<Nothing$>((Nothing$)((Object)this), Nil$.MODULE$);
        }

        @Override
        public String debugInformation() {
            return this.buildString((Function1<Function1<String, BoxedUnit>, BoxedUnit>)(Function1<Function1, Object> & java.io.Serializable & Serializable)append -> {
                append.apply("Parallel flat hash table iterator");
                append.apply("---------------------------------");
                append.apply(new java.lang.StringBuilder(20).append("Traversed/total: ").append($this.traversed).append(" / ").append(this.totalsize()).toString());
                append.apply(new java.lang.StringBuilder(20).append("Table idx/until: ").append(this.idx()).append(" / ").append(this.until()).toString());
                append.apply(new java.lang.StringBuilder(14).append("Table length: ").append($this.itertable.length).toString());
                append.apply("Table: ");
                append.apply(DebugUtils$.MODULE$.arrayString($this.itertable, 0, $this.itertable.length));
                append.apply("Sizemap: ");
                append.apply(DebugUtils$.MODULE$.arrayString(this.scala$collection$parallel$mutable$ParFlatHashTable$ParFlatHashTableIterator$$$outer().sizemap(), 0, this.scala$collection$parallel$mutable$ParFlatHashTable$ParFlatHashTableIterator$$$outer().sizemap().length));
                return BoxedUnit.UNIT;
            });
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public int countElems(int from, int until) {
            void var3_3;
            int count = 0;
            for (int i = from; i < until; ++i) {
                if (this.itertable[i] == null) continue;
                ++count;
            }
            return (int)var3_3;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public int countBucketSizes(int frombucket, int untilbucket) {
            void var3_3;
            int count = 0;
            for (int i = frombucket; i < untilbucket; ++i) {
                count += this.scala$collection$parallel$mutable$ParFlatHashTable$ParFlatHashTableIterator$$$outer().sizemap()[i];
            }
            return (int)var3_3;
        }

        public /* synthetic */ ParFlatHashTable scala$collection$parallel$mutable$ParFlatHashTable$ParFlatHashTableIterator$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ void $anonfun$debugInformation$1(ParFlatHashTableIterator $this, Function1 append) {
            append.apply("Parallel flat hash table iterator");
            append.apply("---------------------------------");
            append.apply(new java.lang.StringBuilder(20).append("Traversed/total: ").append($this.traversed).append(" / ").append($this.totalsize()).toString());
            append.apply(new java.lang.StringBuilder(20).append("Table idx/until: ").append($this.idx()).append(" / ").append($this.until()).toString());
            append.apply(new java.lang.StringBuilder(14).append("Table length: ").append($this.itertable.length).toString());
            append.apply("Table: ");
            append.apply(DebugUtils$.MODULE$.arrayString($this.itertable, 0, $this.itertable.length));
            append.apply("Sizemap: ");
            append.apply(DebugUtils$.MODULE$.arrayString($this.scala$collection$parallel$mutable$ParFlatHashTable$ParFlatHashTableIterator$$$outer().sizemap(), 0, $this.scala$collection$parallel$mutable$ParFlatHashTable$ParFlatHashTableIterator$$$outer().sizemap().length));
        }

        public ParFlatHashTableIterator(ParFlatHashTable $outer, int idx, int until, int totalsize) {
            this.idx = idx;
            this.until = until;
            this.totalsize = totalsize;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            GenTraversableOnce.$init$(this);
            TraversableOnce.$init$(this);
            Iterator.$init$(this);
            RemainsIterator.$init$(this);
            AugmentedIterableIterator.$init$(this);
            DelegatedSignalling.$init$(this);
            IterableSplitter.$init$(this);
            SizeMapUtils.$init$(this);
            this.traversed = 0;
            this.itertable = $outer.table();
            if (this.hasNext()) {
                this.scan();
            }
        }
    }
}

