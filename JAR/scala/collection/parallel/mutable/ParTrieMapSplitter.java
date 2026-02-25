/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.mutable;

import scala.Function1;
import scala.Function2;
import scala.PartialFunction;
import scala.Tuple2;
import scala.collection.GenTraversableOnce;
import scala.collection.Seq;
import scala.collection.concurrent.TrieMap;
import scala.collection.concurrent.TrieMapIterator;
import scala.collection.generic.DelegatedSignalling;
import scala.collection.generic.Signalling;
import scala.collection.mutable.Builder;
import scala.collection.parallel.AugmentedIterableIterator;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.IterableSplitter;
import scala.collection.parallel.ParIterable;
import scala.collection.parallel.RemainsIterator;
import scala.collection.parallel.SeqSplitter;
import scala.collection.parallel.mutable.ParTrieMap;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;

@ScalaSignature(bytes="\u0006\u0001m4Q\u0001E\t\u0001+eA\u0001\u0002\u000f\u0001\u0003\u0002\u0003\u0006I!\u000f\u0005\ty\u0001\u0011\t\u0011)A\u0005{!A\u0001\t\u0001B\u0001B\u0003%\u0011\tC\u0003E\u0001\u0011\u0005Q\t\u0003\u0005L\u0001!\u0015\r\u0011\"\u0001M\u0011\u001di\u0005\u00011A\u0005\u00021CqA\u0014\u0001A\u0002\u0013\u0005q\n\u0003\u0004V\u0001\u0001\u0006K!\u000f\u0005\u0006-\u0002!\tf\u0016\u0005\u0006=\u0002!\te\u0018\u0005\u0006W\u0002!\t\u0001\u001c\u0005\u0006[\u0002!\tE\u001c\u0005\u0006_\u0002!\t\u0001\u001d\u0005\u0006q\u0002!\t%\u001f\u0005\u0006u\u0002!\t\u0001\u0014\u0002\u0013!\u0006\u0014HK]5f\u001b\u0006\u00048\u000b\u001d7jiR,'O\u0003\u0002\u0013'\u00059Q.\u001e;bE2,'B\u0001\u000b\u0016\u0003!\u0001\u0018M]1mY\u0016d'B\u0001\f\u0018\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u00021\u0005)1oY1mCV\u0019!dI\u0018\u0014\u0007\u0001Y\u0012\u0007\u0005\u0003\u001d?\u0005rS\"A\u000f\u000b\u0005y)\u0012AC2p]\u000e,(O]3oi&\u0011\u0001%\b\u0002\u0010)JLW-T1q\u0013R,'/\u0019;peB\u0011!e\t\u0007\u0001\t\u0015!\u0003A1\u0001'\u0005\u0005Y5\u0001A\t\u0003O-\u0002\"\u0001K\u0015\u000e\u0003]I!AK\f\u0003\u000f9{G\u000f[5oOB\u0011\u0001\u0006L\u0005\u0003[]\u00111!\u00118z!\t\u0011s\u0006B\u00031\u0001\t\u0007aEA\u0001W!\r\u00114'N\u0007\u0002'%\u0011Ag\u0005\u0002\u0011\u0013R,'/\u00192mKN\u0003H.\u001b;uKJ\u0004B\u0001\u000b\u001c\"]%\u0011qg\u0006\u0002\u0007)V\u0004H.\u001a\u001a\u0002\u00071,g\u000f\u0005\u0002)u%\u00111h\u0006\u0002\u0004\u0013:$\u0018AA2u!\u0011ab(\t\u0018\n\u0005}j\"a\u0002+sS\u0016l\u0015\r]\u0001\t[V\u001cH/\u00138jiB\u0011\u0001FQ\u0005\u0003\u0007^\u0011qAQ8pY\u0016\fg.\u0001\u0004=S:LGO\u0010\u000b\u0005\r\"K%\n\u0005\u0003H\u0001\u0005rS\"A\t\t\u000ba\"\u0001\u0019A\u001d\t\u000bq\"\u0001\u0019A\u001f\t\u000b\u0001#\u0001\u0019A!\u0002\u0013Q|G/\u00197tSj,W#A\u001d\u0002\u0011%$XM]1uK\u0012\fA\"\u001b;fe\u0006$X\rZ0%KF$\"\u0001U*\u0011\u0005!\n\u0016B\u0001*\u0018\u0005\u0011)f.\u001b;\t\u000fQ;\u0011\u0011!a\u0001s\u0005\u0019\u0001\u0010J\u0019\u0002\u0013%$XM]1uK\u0012\u0004\u0013a\u00038fo&#XM]1u_J$BA\u0012-[9\")\u0011,\u0003a\u0001s\u0005!q\f\\3w\u0011\u0015Y\u0016\u00021\u0001>\u0003\ry6\r\u001e\u0005\u0006;&\u0001\r!Q\u0001\n?6,8\u000f^%oSR\f!c\u001d5pk2$7\u000b\u001d7ji\u001a+(\u000f\u001e5feV\u0011\u0001m\u001a\u000b\u0004\u0003\u0006L\u0007\"\u00022\u000b\u0001\u0004\u0019\u0017\u0001B2pY2\u00042A\r3g\u0013\t)7CA\u0006QCJLE/\u001a:bE2,\u0007C\u0001\u0012h\t\u0015A'B1\u0001'\u0005\u0005\u0019\u0006\"\u00026\u000b\u0001\u0004I\u0014\u0001\u00059be\u0006dG.\u001a7jg6dUM^3m\u0003\r!W\u000f]\u000b\u0002\r\u0006!a.\u001a=u)\u0005)\u0014!B:qY&$X#A9\u0011\u0007I,\u0018G\u0004\u0002)g&\u0011AoF\u0001\ba\u0006\u001c7.Y4f\u0013\t1xOA\u0002TKFT!\u0001^\f\u0002!%\u001c(+Z7bS:LgnZ\"iK\u0006\u0004X#A!\u0002\u0013I,W.Y5oS:<\u0007")
public class ParTrieMapSplitter<K, V>
extends TrieMapIterator<K, V>
implements IterableSplitter<Tuple2<K, V>> {
    private int totalsize;
    private final TrieMap<K, V> ct;
    private int iterated;
    private Signalling signalDelegate;
    private volatile boolean bitmap$0;

    @Override
    public Seq<IterableSplitter<Tuple2<K, V>>> splitWithSignalling() {
        return IterableSplitter.splitWithSignalling$(this);
    }

    @Override
    public String buildString(Function1<Function1<String, BoxedUnit>, BoxedUnit> closure) {
        return IterableSplitter.buildString$(this, closure);
    }

    @Override
    public String debugInformation() {
        return IterableSplitter.debugInformation$(this);
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
    public IterableSplitter<Tuple2<K, V>> drop(int n) {
        return IterableSplitter.drop$(this, n);
    }

    @Override
    public IterableSplitter<Tuple2<K, V>> take(int n) {
        return IterableSplitter.take$(this, n);
    }

    @Override
    public IterableSplitter<Tuple2<K, V>> slice(int from1, int until1) {
        return IterableSplitter.slice$(this, from1, until1);
    }

    @Override
    public <S> IterableSplitter.Mapped<S> map(Function1<Tuple2<K, V>, S> f) {
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
    public int count(Function1<Tuple2<K, V>, Object> p) {
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
    public Object min(Ordering ord) {
        return AugmentedIterableIterator.min$(this, ord);
    }

    @Override
    public Object max(Ordering ord) {
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
    public <S, That> Combiner<S, That> map2combiner(Function1<Tuple2<K, V>, S> f, Combiner<S, That> cb) {
        return AugmentedIterableIterator.map2combiner$(this, f, cb);
    }

    @Override
    public <S, That> Combiner<S, That> collect2combiner(PartialFunction<Tuple2<K, V>, S> pf, Combiner<S, That> cb) {
        return AugmentedIterableIterator.collect2combiner$(this, pf, cb);
    }

    @Override
    public <S, That> Combiner<S, That> flatmap2combiner(Function1<Tuple2<K, V>, GenTraversableOnce<S>> f, Combiner<S, That> cb) {
        return AugmentedIterableIterator.flatmap2combiner$(this, f, cb);
    }

    @Override
    public <U, Coll, Bld extends Builder<U, Coll>> Bld copy2builder(Bld b) {
        return (Bld)AugmentedIterableIterator.copy2builder$(this, b);
    }

    @Override
    public <U, This> Combiner<U, This> filter2combiner(Function1<Tuple2<K, V>, Object> pred, Combiner<U, This> cb) {
        return AugmentedIterableIterator.filter2combiner$(this, pred, cb);
    }

    @Override
    public <U, This> Combiner<U, This> filterNot2combiner(Function1<Tuple2<K, V>, Object> pred, Combiner<U, This> cb) {
        return AugmentedIterableIterator.filterNot2combiner$(this, pred, cb);
    }

    @Override
    public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> partition2combiners(Function1<Tuple2<K, V>, Object> pred, Combiner<U, This> btrue, Combiner<U, This> bfalse) {
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
    public <U, This> Tuple2<Combiner<U, This>, Object> takeWhile2combiner(Function1<Tuple2<K, V>, Object> p, Combiner<U, This> cb) {
        return AugmentedIterableIterator.takeWhile2combiner$(this, p, cb);
    }

    @Override
    public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> span2combiners(Function1<Tuple2<K, V>, Object> p, Combiner<U, This> before, Combiner<U, This> after) {
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
    public Signalling signalDelegate() {
        return this.signalDelegate;
    }

    @Override
    public void signalDelegate_$eq(Signalling x$1) {
        this.signalDelegate = x$1;
    }

    private int totalsize$lzycompute() {
        synchronized (this) {
            if (!this.bitmap$0) {
                this.totalsize = ((ParTrieMap)this.ct.par()).size();
                this.bitmap$0 = true;
            }
        }
        return this.totalsize;
    }

    public int totalsize() {
        if (!this.bitmap$0) {
            return this.totalsize$lzycompute();
        }
        return this.totalsize;
    }

    public int iterated() {
        return this.iterated;
    }

    public void iterated_$eq(int x$1) {
        this.iterated = x$1;
    }

    @Override
    public ParTrieMapSplitter<K, V> newIterator(int _lev, TrieMap<K, V> _ct, boolean _mustInit) {
        return new ParTrieMapSplitter<K, V>(_lev, _ct, _mustInit);
    }

    @Override
    public <S> boolean shouldSplitFurther(ParIterable<S> coll, int parallelismLevel) {
        int maxsplits = 3 + Integer.highestOneBit(parallelismLevel);
        return this.level() < maxsplits;
    }

    /*
     * WARNING - void declaration
     */
    public ParTrieMapSplitter<K, V> dup() {
        void var1_1;
        TrieMapIterator it = this.newIterator(0, (TrieMap)this.ct, false);
        this.dupTo(it);
        ((ParTrieMapSplitter)it).iterated_$eq(this.iterated());
        return var1_1;
    }

    @Override
    public Tuple2<K, V> next() {
        this.iterated_$eq(this.iterated() + 1);
        return super.next();
    }

    @Override
    public Seq<IterableSplitter<Tuple2<K, V>>> split() {
        return this.subdivide();
    }

    @Override
    public boolean isRemainingCheap() {
        return false;
    }

    @Override
    public int remaining() {
        return this.totalsize() - this.iterated();
    }

    public ParTrieMapSplitter(int lev, TrieMap<K, V> ct, boolean mustInit) {
        this.ct = ct;
        super(lev, ct, mustInit);
        RemainsIterator.$init$(this);
        AugmentedIterableIterator.$init$(this);
        DelegatedSignalling.$init$(this);
        IterableSplitter.$init$(this);
        this.iterated = 0;
    }
}

