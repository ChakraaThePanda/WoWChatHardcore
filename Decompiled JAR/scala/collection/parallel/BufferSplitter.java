/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.BufferedIterator;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.Iterator;
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
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.AugmentedIterableIterator;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.IterableSplitter;
import scala.collection.parallel.ParIterable;
import scala.collection.parallel.RemainsIterator;
import scala.collection.parallel.SeqSplitter;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001A4Q\u0001E\t\u0001#]A\u0001\"\f\u0001\u0003\u0006\u0004%IA\f\u0005\tk\u0001\u0011\t\u0011)A\u0005_!Aa\u0007\u0001BA\u0002\u0013%q\u0007\u0003\u0005<\u0001\t\u0005\r\u0011\"\u0003=\u0011!\u0011\u0005A!A!B\u0013A\u0004\u0002C\"\u0001\u0005\u000b\u0007I\u0011B\u001c\t\u0011\u0011\u0003!\u0011!Q\u0001\naB\u0001\"\u0012\u0001\u0003\u0002\u0003\u0006IA\u0012\u0005\u0006\u0019\u0002!\t!\u0014\u0005\u0006'\u0002!\t\u0001\u0016\u0005\u00061\u0002!\t!\u0017\u0005\u00065\u0002!\ta\u000e\u0005\u00067\u0002!\t\u0001\u0018\u0005\u0006;\u0002!\tA\u0018\u0005\u0007G\u0002!\t%\u00053\u0003\u001d\t+hMZ3s'Bd\u0017\u000e\u001e;fe*\u0011!cE\u0001\ta\u0006\u0014\u0018\r\u001c7fY*\u0011A#F\u0001\u000bG>dG.Z2uS>t'\"\u0001\f\u0002\u000bM\u001c\u0017\r\\1\u0016\u0005a\u00193c\u0001\u0001\u001a;A\u0011!dG\u0007\u0002+%\u0011A$\u0006\u0002\u0007\u0003:L(+\u001a4\u0011\u0007yy\u0012%D\u0001\u0012\u0013\t\u0001\u0013C\u0001\tJi\u0016\u0014\u0018M\u00197f'Bd\u0017\u000e\u001e;feB\u0011!e\t\u0007\u0001\t\u0015!\u0003A1\u0001'\u0005\u0005!6\u0001A\t\u0003O)\u0002\"A\u0007\u0015\n\u0005%*\"a\u0002(pi\"Lgn\u001a\t\u00035-J!\u0001L\u000b\u0003\u0007\u0005s\u00170\u0001\u0004ck\u001a4WM]\u000b\u0002_A\u0019\u0001gM\u0011\u000e\u0003ER!AM\n\u0002\u000f5,H/\u00192mK&\u0011A'\r\u0002\f\u0003J\u0014\u0018-\u001f\"vM\u001a,'/A\u0004ck\u001a4WM\u001d\u0011\u0002\u000b%tG-\u001a=\u0016\u0003a\u0002\"AG\u001d\n\u0005i*\"aA%oi\u0006I\u0011N\u001c3fq~#S-\u001d\u000b\u0003{\u0001\u0003\"A\u0007 \n\u0005}*\"\u0001B+oSRDq!\u0011\u0003\u0002\u0002\u0003\u0007\u0001(A\u0002yIE\na!\u001b8eKb\u0004\u0013!B;oi&d\u0017AB;oi&d\u0007%A\u0004`g&<G-\u001a7\u0011\u0005\u001dSU\"\u0001%\u000b\u0005%\u001b\u0012aB4f]\u0016\u0014\u0018nY\u0005\u0003\u0017\"\u0013!bU5h]\u0006dG.\u001b8h\u0003\u0019a\u0014N\\5u}Q)aj\u0014)R%B\u0019a\u0004A\u0011\t\u000b5J\u0001\u0019A\u0018\t\u000bYJ\u0001\u0019\u0001\u001d\t\u000b\rK\u0001\u0019\u0001\u001d\t\u000b\u0015K\u0001\u0019\u0001$\u0002\u000f!\f7OT3yiV\tQ\u000b\u0005\u0002\u001b-&\u0011q+\u0006\u0002\b\u0005>|G.Z1o\u0003\u0011qW\r\u001f;\u0015\u0003\u0005\n\u0011B]3nC&t\u0017N\\4\u0002\u0007\u0011,\b/F\u0001O\u0003\u0015\u0019\b\u000f\\5u+\u0005y\u0006c\u00011b;5\t1#\u0003\u0002c'\t\u00191+Z9\u0002!\u0011,'-^4J]\u001a|'/\\1uS>tW#A3\u0011\u0005\u0019lgBA4l!\tAW#D\u0001j\u0015\tQW%\u0001\u0004=e>|GOP\u0005\u0003YV\ta\u0001\u0015:fI\u00164\u0017B\u00018p\u0005\u0019\u0019FO]5oO*\u0011A.\u0006")
public class BufferSplitter<T>
implements IterableSplitter<T> {
    private final ArrayBuffer<T> buffer;
    private int index;
    private final int until;
    private Signalling signalDelegate;

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
        return (T)AugmentedIterableIterator.min$(this, ord);
    }

    @Override
    public <U> T max(Ordering<U> ord) {
        return (T)AugmentedIterableIterator.max$(this, ord);
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
        return (T)TraversableOnce.maxBy$(this, f, cmp);
    }

    @Override
    public <B> T minBy(Function1<T, B> f, Ordering<B> cmp) {
        return (T)TraversableOnce.minBy$(this, f, cmp);
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

    private ArrayBuffer<T> buffer() {
        return this.buffer;
    }

    private int index() {
        return this.index;
    }

    private void index_$eq(int x$1) {
        this.index = x$1;
    }

    private int until() {
        return this.until;
    }

    @Override
    public boolean hasNext() {
        return this.index() < this.until();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public T next() {
        void var1_1;
        T r = this.buffer().apply(this.index());
        this.index_$eq(this.index() + 1);
        return var1_1;
    }

    @Override
    public int remaining() {
        return this.until() - this.index();
    }

    @Override
    public BufferSplitter<T> dup() {
        return new BufferSplitter<T>(this.buffer(), this.index(), this.until(), this.signalDelegate());
    }

    @Override
    public Seq<IterableSplitter<T>> split() {
        if (this.remaining() > 1) {
            int divsz = (this.until() - this.index()) / 2;
            return new $colon$colon<Nothing$>((Nothing$)((Object)new BufferSplitter<T>(this.buffer(), this.index(), this.index() + divsz, this.signalDelegate())), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)new BufferSplitter<T>(this.buffer(), this.index() + divsz, this.until(), this.signalDelegate())), Nil$.MODULE$));
        }
        return new $colon$colon<Nothing$>((Nothing$)((Object)this), Nil$.MODULE$);
    }

    @Override
    public String debugInformation() {
        return this.buildString((Function1<Function1<String, BoxedUnit>, BoxedUnit>)(Function1<Function1, Object> & java.io.Serializable & Serializable)append -> {
            append.apply("---------------");
            append.apply("Buffer iterator");
            append.apply(new java.lang.StringBuilder(8).append("buffer: ").append(this.buffer()).toString());
            append.apply(new java.lang.StringBuilder(7).append("index: ").append(this.index()).toString());
            append.apply(new java.lang.StringBuilder(7).append("until: ").append(this.until()).toString());
            append.apply("---------------");
            return BoxedUnit.UNIT;
        });
    }

    public static final /* synthetic */ void $anonfun$debugInformation$1(BufferSplitter $this, Function1 append) {
        append.apply("---------------");
        append.apply("Buffer iterator");
        append.apply(new java.lang.StringBuilder(8).append("buffer: ").append($this.buffer()).toString());
        append.apply(new java.lang.StringBuilder(7).append("index: ").append($this.index()).toString());
        append.apply(new java.lang.StringBuilder(7).append("until: ").append($this.until()).toString());
        append.apply("---------------");
    }

    public BufferSplitter(ArrayBuffer<T> buffer, int index, int until, Signalling _sigdel) {
        this.buffer = buffer;
        this.index = index;
        this.until = until;
        GenTraversableOnce.$init$(this);
        TraversableOnce.$init$(this);
        Iterator.$init$(this);
        RemainsIterator.$init$(this);
        AugmentedIterableIterator.$init$(this);
        DelegatedSignalling.$init$(this);
        IterableSplitter.$init$(this);
        this.signalDelegate_$eq(_sigdel);
    }
}

