/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.mutable;

import scala.Array$;
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
import scala.collection.TraversableLike;
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
import scala.collection.mutable.ArrayBuffer$;
import scala.collection.mutable.ArrayOps;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.HashEntry;
import scala.collection.mutable.HashTable;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.AugmentedIterableIterator;
import scala.collection.parallel.BufferSplitter;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.IterableSplitter;
import scala.collection.parallel.ParIterable;
import scala.collection.parallel.RemainsIterator;
import scala.collection.parallel.SeqSplitter;
import scala.collection.parallel.mutable.SizeMapUtils;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u00055ea\u0002\u0011\"!\u0003\r\tA\u000b\u0005\u0006\u0015\u0002!\ta\u0013\u0005\u0006\u001f\u0002!\t\u0005\u0015\u0004\u0006)\u0002\t\t!\u0016\u0005\tE\u000e\u0011\t\u0019!C\u0005G\"Aqm\u0001BA\u0002\u0013%\u0001\u000e\u0003\u0005l\u0007\t\u0005\t\u0015)\u0003e\u0011!a7A!b\u0001\n\u0013\u0019\u0007\u0002C7\u0004\u0005\u0003\u0005\u000b\u0011\u00023\t\u00119\u001c!Q1A\u0005\n\rD\u0001b\\\u0002\u0003\u0002\u0003\u0006I\u0001\u001a\u0005\ta\u000e\u0011\t\u0019!C\u0005c\"A!o\u0001BA\u0002\u0013%1\u000f\u0003\u0005v\u0007\t\u0005\t\u0015)\u0003A\u0011\u001518\u0001\"\u0001x\u0011%\t)a\u0001b\u0001\n\u0013\t9\u0001\u0003\u0005\u0002\u0010\r\u0001\u000b\u0011BA\u0005\u0011!\t\tb\u0001a\u0001\n\u0013\u0019\u0007\"CA\n\u0007\u0001\u0007I\u0011BA\u000b\u0011\u001d\tIb\u0001Q!\n\u0011Dq!a\u0007\u0004\r\u0003\ti\u0002C\u0004\u0002$\r1\t!!\n\t\r\u0005U2\u0001\"\u0001Q\u0011\u001d\t9d\u0001C\u0001\u0003sAa!a\u000f\u0004\t\u0003Y\u0005BBA\u001f\u0007\u0011\u00051\r\u0003\u0005\u0002@\r!\teIA!\u0011\u001d\tIf\u0001C\u0001\u00037Bq!!\u0018\u0004\t\u0003\ty\u0006C\u0004\u0002j\r!I!a\u001b\t\u000f\u0005]4\u0001\"\u0005\u0002z!9\u0011\u0011Q\u0002\u0005\u0012\u0005\r%\u0001\u0004)be\"\u000b7\u000f\u001b+bE2,'B\u0001\u0012$\u0003\u001diW\u000f^1cY\u0016T!\u0001J\u0013\u0002\u0011A\f'/\u00197mK2T!AJ\u0014\u0002\u0015\r|G\u000e\\3di&|gNC\u0001)\u0003\u0015\u00198-\u00197b\u0007\u0001)2aK\u001cB'\r\u0001A\u0006\r\t\u0003[9j\u0011aJ\u0005\u0003_\u001d\u0012a!\u00118z%\u00164\u0007\u0003B\u00194k\u0001k\u0011A\r\u0006\u0003E\u0015J!\u0001\u000e\u001a\u0003\u0013!\u000b7\u000f\u001b+bE2,\u0007C\u0001\u001c8\u0019\u0001!Q\u0001\u000f\u0001C\u0002e\u0012\u0011aS\t\u0003uu\u0002\"!L\u001e\n\u0005q:#a\u0002(pi\"Lgn\u001a\t\u0003[yJ!aP\u0014\u0003\u0007\u0005s\u0017\u0010\u0005\u00027\u0003\u0012)!\t\u0001b\u0001\u0007\n)QI\u001c;ssF\u0011Ai\u0012\t\u0003[\u0015K!AR\u0014\u0003\t9+H\u000e\u001c\t\u0005c!+\u0004)\u0003\u0002Je\tI\u0001*Y:i\u000b:$(/_\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0015\u00031\u0003\"!L'\n\u00059;#\u0001B+oSR\f\u0011#\u00197xCf\u001c\u0018J\\5u'&TX-T1q+\u0005\t\u0006CA\u0017S\u0013\t\u0019vEA\u0004C_>dW-\u00198\u0003\u001b\u0015sGO]=Ji\u0016\u0014\u0018\r^8s+\r1Fl_\n\u0005\u00071:f\fE\u0002Y3nk\u0011aI\u0005\u00035\u000e\u0012\u0001#\u0013;fe\u0006\u0014G.Z*qY&$H/\u001a:\u0011\u0005YbF!B/\u0004\u0005\u0004I$!\u0001+\u0011\u0005}\u0003W\"A\u0011\n\u0005\u0005\f#\u0001D*ju\u0016l\u0015\r]+uS2\u001c\u0018aA5eqV\tA\r\u0005\u0002.K&\u0011am\n\u0002\u0004\u0013:$\u0018aB5eq~#S-\u001d\u000b\u0003\u0019&DqA[\u0003\u0002\u0002\u0003\u0007A-A\u0002yIE\nA!\u001b3yA\u0005)QO\u001c;jY\u00061QO\u001c;jY\u0002\n\u0011\u0002^8uC2\u001c\u0018N_3\u0002\u0015Q|G/\u00197tSj,\u0007%\u0001\u0002fgV\t\u0001)\u0001\u0004fg~#S-\u001d\u000b\u0003\u0019RDqA\u001b\u0007\u0002\u0002\u0003\u0007\u0001)A\u0002fg\u0002\na\u0001P5oSRtDc\u0002=\u007f\u007f\u0006\u0005\u00111\u0001\t\u0005s\u000eY&0D\u0001\u0001!\t14\u0010\u0002\u0004}\u0007\u0011\u0015\r! \u0002\t\u0013R,'OU3qeF\u0011!h\u0016\u0005\u0006E:\u0001\r\u0001\u001a\u0005\u0006Y:\u0001\r\u0001\u001a\u0005\u0006]:\u0001\r\u0001\u001a\u0005\u0006a:\u0001\r\u0001Q\u0001\nSR,'\u000f^1cY\u0016,\"!!\u0003\u0011\t5\nYaR\u0005\u0004\u0003\u001b9#!B!se\u0006L\u0018AC5uKJ$\u0018M\u00197fA\u0005IAO]1wKJ\u001cX\rZ\u0001\u000eiJ\fg/\u001a:tK\u0012|F%Z9\u0015\u00071\u000b9\u0002C\u0004k%\u0005\u0005\t\u0019\u00013\u0002\u0015Q\u0014\u0018M^3sg\u0016$\u0007%\u0001\u0006f]R\u0014\u0018PM5uK6$2aWA\u0010\u0011\u0019\t\t\u0003\u0006a\u0001\u0001\u0006\tQ-A\u0006oK^LE/\u001a:bi>\u0014H#\u0003>\u0002(\u0005-\u0012qFA\u001a\u0011\u0019\tI#\u0006a\u0001I\u00069\u0011\u000e\u001a=Ge>l\u0007BBA\u0017+\u0001\u0007A-\u0001\u0005jIb,f\u000e^5m\u0011\u0019\t\t$\u0006a\u0001I\u0006IAo\u001c;bYNK'0\u001a\u0005\u0006aV\u0001\r\u0001Q\u0001\bQ\u0006\u001ch*\u001a=u\u0003\u0011qW\r\u001f;\u0015\u0003m\u000bAa]2b]\u0006I!/Z7bS:LgnZ\u0001\u0011I\u0016\u0014WoZ%oM>\u0014X.\u0019;j_:,\"!a\u0011\u0011\t\u0005\u0015\u00131\u000b\b\u0005\u0003\u000f\ny\u0005E\u0002\u0002J\u001dj!!a\u0013\u000b\u0007\u00055\u0013&\u0001\u0004=e>|GOP\u0005\u0004\u0003#:\u0013A\u0002)sK\u0012,g-\u0003\u0003\u0002V\u0005]#AB*ue&twMC\u0002\u0002R\u001d\n1\u0001Z;q+\u0005Q\u0018!B:qY&$XCAA1!\u0015\t\u0019'!\u001aX\u001b\u0005)\u0013bAA4K\t\u00191+Z9\u0002)\r|gN^3siR{\u0017I\u001d:bs\n+hMZ3s)\u0011\ti'a\u001d\u0011\tE\nygW\u0005\u0004\u0003c\u0012$aC!se\u0006L()\u001e4gKJDa!!\u001e\u001e\u0001\u0004\u0001\u0015!C2iC&t\u0007.Z1e\u0003)\u0019w.\u001e8u\u000b2,Wn\u001d\u000b\u0006I\u0006m\u0014q\u0010\u0005\u0007\u0003{r\u0002\u0019\u00013\u0002\t\u0019\u0014x.\u001c\u0005\u0006Yz\u0001\r\u0001Z\u0001\u0011G>,h\u000e\u001e\"vG.,GoU5{KN$R\u0001ZAC\u0003\u0013Ca!a\" \u0001\u0004!\u0017A\u00034s_6\u0014UoY6fi\"1\u00111R\u0010A\u0002\u0011\f1\"\u001e8uS2\u0014UoY6fi\u0002")
public interface ParHashTable<K, Entry extends HashEntry<K, Entry>>
extends HashTable<K, Entry> {
    public static /* synthetic */ boolean alwaysInitSizeMap$(ParHashTable $this) {
        return $this.alwaysInitSizeMap();
    }

    @Override
    default public boolean alwaysInitSizeMap() {
        return true;
    }

    public static void $init$(ParHashTable $this) {
    }

    public abstract class EntryIterator<T, IterRepr extends IterableSplitter<T>>
    implements IterableSplitter<T>,
    SizeMapUtils {
        private int idx;
        private final int until;
        private final int totalsize;
        private Entry es;
        private final HashEntry<K, Entry>[] itertable;
        private int traversed;
        private Signalling signalDelegate;
        public final /* synthetic */ ParHashTable $outer;

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

        private int idx() {
            return this.idx;
        }

        private void idx_$eq(int x$1) {
            this.idx = x$1;
        }

        private int until() {
            return this.until;
        }

        private int totalsize() {
            return this.totalsize;
        }

        private Entry es() {
            return this.es;
        }

        private void es_$eq(Entry x$1) {
            this.es = x$1;
        }

        private HashEntry<K, Entry>[] itertable() {
            return this.itertable;
        }

        private int traversed() {
            return this.traversed;
        }

        private void traversed_$eq(int x$1) {
            this.traversed = x$1;
        }

        public abstract T entry2item(Entry var1);

        public abstract IterRepr newIterator(int var1, int var2, int var3, Entry var4);

        @Override
        public boolean hasNext() {
            return this.es() != null;
        }

        @Override
        public T next() {
            Object res = this.es();
            this.es_$eq((HashEntry)this.es().next());
            this.scan();
            this.traversed_$eq(this.traversed() + 1);
            return this.entry2item(res);
        }

        public void scan() {
            while (this.es() == null && this.idx() < this.until()) {
                this.es_$eq(this.itertable()[this.idx()]);
                this.idx_$eq(this.idx() + 1);
            }
        }

        @Override
        public int remaining() {
            return this.totalsize() - this.traversed();
        }

        @Override
        public String debugInformation() {
            return this.buildString((Function1<Function1<String, BoxedUnit>, BoxedUnit>)(Function1<Function1, Object> & java.io.Serializable & Serializable)append -> {
                append.apply("/--------------------\\");
                append.apply("Parallel hash table entry iterator");
                append.apply(new java.lang.StringBuilder(27).append("total hash table elements: ").append(this.scala$collection$parallel$mutable$ParHashTable$EntryIterator$$$outer().tableSize()).toString());
                append.apply(new java.lang.StringBuilder(5).append("pos: ").append(this.idx()).toString());
                append.apply(new java.lang.StringBuilder(7).append("until: ").append(this.until()).toString());
                append.apply(new java.lang.StringBuilder(11).append("traversed: ").append(this.traversed()).toString());
                append.apply(new java.lang.StringBuilder(11).append("totalsize: ").append(this.totalsize()).toString());
                append.apply(new java.lang.StringBuilder(15).append("current entry: ").append(this.es()).toString());
                append.apply(new java.lang.StringBuilder(23).append("underlying from ").append(this.idx()).append(" until ").append(this.until()).toString());
                append.apply(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])TraversableLike.map$(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.itertable())).slice(this.idx(), this.until()))), (Function1<HashEntry, String> & java.io.Serializable & Serializable)x -> {
                    if (x != null) {
                        return x.toString();
                    }
                    return "n/a";
                }, Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.apply(String.class))))).mkString(" | "));
                append.apply("\\--------------------/");
                return BoxedUnit.UNIT;
            });
        }

        public IterRepr dup() {
            return this.newIterator(this.idx(), this.until(), this.totalsize(), this.es());
        }

        @Override
        public Seq<IterableSplitter<T>> split() {
            if (this.remaining() > 1) {
                if (this.until() > this.idx()) {
                    int divsz = (this.until() - this.idx()) / 2;
                    int sidx = this.idx() + divsz + 1;
                    int suntil = this.until();
                    HashEntry ses = this.itertable()[sidx - 1];
                    int stotal = this.calcNumElems(sidx - 1, suntil, this.scala$collection$parallel$mutable$ParHashTable$EntryIterator$$$outer().table().length, this.scala$collection$parallel$mutable$ParHashTable$EntryIterator$$$outer().sizeMapBucketSize());
                    int fidx = this.idx();
                    int funtil = this.idx() + divsz;
                    Object fes = this.es();
                    int ftotal = this.totalsize() - stotal;
                    return new $colon$colon<Nothing$>((Nothing$)this.newIterator(fidx, funtil, ftotal, fes), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)this.newIterator(sidx, suntil, stotal, ses), Nil$.MODULE$));
                }
                ArrayBuffer<T> arr = this.convertToArrayBuffer(this.es());
                return new BufferSplitter<T>(arr, 0, arr.length(), this.signalDelegate()).split();
            }
            return new $colon$colon<Nothing$>((Nothing$)((Object)this), Nil$.MODULE$);
        }

        private ArrayBuffer<T> convertToArrayBuffer(Entry chainhead) {
            ArrayBuffer buff = (ArrayBuffer)ArrayBuffer$.MODULE$.apply(Nil$.MODULE$);
            for (Object curr = chainhead; curr != null; curr = (HashEntry)curr.next()) {
                buff.$plus$eq(curr);
            }
            return buff.map((Function1<HashEntry, Object> & java.io.Serializable & Serializable)e -> this.entry2item(e), ArrayBuffer$.MODULE$.canBuildFrom());
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public int countElems(int from, int until) {
            void var3_3;
            int c = 0;
            for (int idx = from; idx < until; ++idx) {
                for (HashEntry es = this.itertable()[idx]; es != null; es = (HashEntry)es.next()) {
                    ++c;
                }
            }
            return (int)var3_3;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public int countBucketSizes(int fromBucket, int untilBucket) {
            void var3_3;
            int c = 0;
            for (int idx = fromBucket; idx < untilBucket; ++idx) {
                c += this.scala$collection$parallel$mutable$ParHashTable$EntryIterator$$$outer().sizemap()[idx];
            }
            return (int)var3_3;
        }

        public /* synthetic */ ParHashTable scala$collection$parallel$mutable$ParHashTable$EntryIterator$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ void $anonfun$debugInformation$1(EntryIterator $this, Function1 append) {
            append.apply("/--------------------\\");
            append.apply("Parallel hash table entry iterator");
            append.apply(new java.lang.StringBuilder(27).append("total hash table elements: ").append($this.scala$collection$parallel$mutable$ParHashTable$EntryIterator$$$outer().tableSize()).toString());
            append.apply(new java.lang.StringBuilder(5).append("pos: ").append($this.idx()).toString());
            append.apply(new java.lang.StringBuilder(7).append("until: ").append($this.until()).toString());
            append.apply(new java.lang.StringBuilder(11).append("traversed: ").append($this.traversed()).toString());
            append.apply(new java.lang.StringBuilder(11).append("totalsize: ").append($this.totalsize()).toString());
            append.apply(new java.lang.StringBuilder(15).append("current entry: ").append($this.es()).toString());
            append.apply(new java.lang.StringBuilder(23).append("underlying from ").append($this.idx()).append(" until ").append($this.until()).toString());
            append.apply(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])TraversableLike.map$(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])$this.itertable())).slice($this.idx(), $this.until()))), (Function1<HashEntry, String> & java.io.Serializable & Serializable)x -> {
                if (x != null) {
                    return x.toString();
                }
                return "n/a";
            }, Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.apply(String.class))))).mkString(" | "));
            append.apply("\\--------------------/");
        }

        public EntryIterator(int idx, int until, int totalsize, Entry es) {
            this.idx = idx;
            this.until = until;
            this.totalsize = totalsize;
            this.es = es;
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
            this.itertable = $outer.table();
            this.traversed = 0;
            this.scan();
        }
    }
}

