/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.mutable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.CustomParallelizable;
import scala.collection.DebugUtils$;
import scala.collection.GenIterable;
import scala.collection.GenSet;
import scala.collection.GenSetLike;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.IterableView;
import scala.collection.Iterator;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.CanCombineFrom;
import scala.collection.generic.DelegatedSignalling;
import scala.collection.generic.GenericParTemplate;
import scala.collection.generic.GenericSetTemplate;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.generic.Growable;
import scala.collection.generic.Shrinkable;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.Cloneable;
import scala.collection.mutable.FlatHashTable;
import scala.collection.mutable.HashSet;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.CombinerFactory;
import scala.collection.parallel.ParIterableLike;
import scala.collection.parallel.ParIterableLike$ScanLeaf$;
import scala.collection.parallel.ParIterableLike$ScanNode$;
import scala.collection.parallel.ParSet;
import scala.collection.parallel.TaskSupport;
import scala.collection.parallel.immutable.ParMap;
import scala.collection.parallel.mutable.ParFlatHashTable;
import scala.collection.parallel.mutable.ParHashSet$;
import scala.collection.parallel.mutable.ParIterable;
import scala.collection.parallel.mutable.ParSeq;
import scala.collection.parallel.mutable.ParSetLike;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0005\u0015h\u0001B\u0010!\u0001%B\u0001\u0002\u0016\u0001\u0003\u0002\u0003\u0006I!\u0016\u0005\u00079\u0002!\t\u0001J/\t\u000bq\u0003A\u0011A0\t\u000b\u0001\u0004A\u0011I1\t\u000f\u0005%\u0002\u0001\"\u0011\u0002,!9\u0011Q\u0006\u0001\u0005B\u0005=\u0002bBA4\u0001\u0011\u0005\u0013\u0011\u000e\u0005\b\u0003W\u0002A\u0011AA7\u0011\u001d\t)\b\u0001C!\u0003oBq!!\u001f\u0001\t\u0003\tY\bC\u0004\u0002\u0002\u0002!\t!a!\t\u000f\u0005\u001d\u0005\u0001\"\u0011\u0002\n\"9\u0011\u0011\u0013\u0001\u0005\u0002\u0005M\u0005bBAO\u0001\u0011\u0005\u0011q\u0006\u0004\u0007\u0003k\u0001\u0001!a\u000e\t\u0015\u0005}rB!A!\u0002\u0013\t\t\u0005\u0003\u0007\u0002H=\u0011\t\u0011)A\u0005\u0003\u0003\nI\u0005\u0003\u0007\u0002N=\u0011\t\u0011)A\u0005\u0003\u0003\ny\u0005\u0003\u0004]\u001f\u0011\u0005\u00111\u000b\u0005\b\u00037zA\u0011AA/\u0011\u001d\ty\n\u0001C\u0005\u0003CCq!a-\u0001\t\u0013\t)\fC\u0004\u0002B\u0002!\t%a1\b\u000b\r\u0004\u0003\u0012\u00013\u0007\u000b}\u0001\u0003\u0012A3\t\u000bqKB\u0011A5\t\u000b)LB1A6\t\u000beLB\u0011\t>\t\u000f\u0005\u001d\u0011\u0004\"\u0011\u0002\n!I\u0011QC\r\u0002\u0002\u0013%\u0011q\u0003\u0002\u000b!\u0006\u0014\b*Y:i'\u0016$(BA\u0011#\u0003\u001diW\u000f^1cY\u0016T!a\t\u0013\u0002\u0011A\f'/\u00197mK2T!!\n\u0014\u0002\u0015\r|G\u000e\\3di&|gNC\u0001(\u0003\u0015\u00198-\u00197b\u0007\u0001)\"AK\u001b\u0014\u000f\u0001YsFP#O#B\u0011A&L\u0007\u0002M%\u0011aF\n\u0002\u0007\u0003:L(+\u001a4\u0011\u0007A\n4'D\u0001!\u0013\t\u0011\u0004E\u0001\u0004QCJ\u001cV\r\u001e\t\u0003iUb\u0001\u0001B\u00037\u0001\t\u0007qGA\u0001U#\tA4\b\u0005\u0002-s%\u0011!H\n\u0002\b\u001d>$\b.\u001b8h!\taC(\u0003\u0002>M\t\u0019\u0011I\\=\u0011\t}\u00125\u0007R\u0007\u0002\u0001*\u0011\u0011\tJ\u0001\bO\u0016tWM]5d\u0013\t\u0019\u0005I\u0001\nHK:,'/[2QCJ$V-\u001c9mCR,\u0007C\u0001\u0019\u0001!\u0015\u0001di\r%J\u0013\t9\u0005E\u0001\u0006QCJ\u001cV\r\u001e'jW\u0016\u00042\u0001\r\u00014!\rQEjM\u0007\u0002\u0017*\u0011\u0011\u0005J\u0005\u0003\u001b.\u0013q\u0001S1tQN+G\u000fE\u00021\u001fNJ!\u0001\u0015\u0011\u0003!A\u000b'O\u00127bi\"\u000b7\u000f\u001b+bE2,\u0007C\u0001\u0017S\u0013\t\u0019fE\u0001\u0007TKJL\u0017\r\\5{C\ndW-\u0001\u0005d_:$XM\u001c;t!\r1\u0016l\r\b\u0003\u0015^K!\u0001W&\u0002\u001b\u0019c\u0017\r\u001e%bg\"$\u0016M\u00197f\u0013\tQ6L\u0001\u0005D_:$XM\u001c;t\u0015\tA6*\u0001\u0004=S:LGO\u0010\u000b\u0003\u0011zCQ\u0001\u0016\u0002A\u0002U#\u0012\u0001S\u0001\nG>l\u0007/\u00198j_:,\u0012A\u0019\b\u0003aa\t!\u0002U1s\u0011\u0006\u001c\bnU3u!\t\u0001\u0014dE\u0002\u001aMF\u00032aP4E\u0013\tA\u0007IA\u0007QCJ\u001cV\r\u001e$bGR|'/\u001f\u000b\u0002I\u0006a1-\u00198Ck&dGM\u0012:p[V\u0011An^\u000b\u0002[B)qH\u001c9wq&\u0011q\u000e\u0011\u0002\u000f\u0007\u0006t7i\\7cS:,gI]8n!\t\t(/D\u0001\u001a\u0013\t\u0019HO\u0001\u0003D_2d\u0017BA;A\u0005A9UM\\3sS\u000e\u001cu.\u001c9b]&|g\u000e\u0005\u00025o\u0012)ag\u0007b\u0001oA\u0019\u0001\u0007\u0001<\u0002\u00159,wOQ;jY\u0012,'/F\u0002|\u0003\u0007)\u0012\u0001 \t\u0007{z\f\t!!\u0002\u000e\u0003\tJ!a \u0012\u0003\u0011\r{WNY5oKJ\u00042\u0001NA\u0002\t\u00151DD1\u00018!\u0011\u0001\u0004!!\u0001\u0002\u00179,woQ8nE&tWM]\u000b\u0005\u0003\u0017\t\t\"\u0006\u0002\u0002\u000eA1QP`A\b\u0003'\u00012\u0001NA\t\t\u00151TD1\u00018!\u0011\u0001\u0004!a\u0004\u0002\u0017I,\u0017\r\u001a*fg>dg/\u001a\u000b\u0003\u00033\u0001B!a\u0007\u0002&5\u0011\u0011Q\u0004\u0006\u0005\u0003?\t\t#\u0001\u0003mC:<'BAA\u0012\u0003\u0011Q\u0017M^1\n\t\u0005\u001d\u0012Q\u0004\u0002\u0007\u001f\nTWm\u0019;\u0002\u000b\u0015l\u0007\u000f^=\u0016\u0003!\u000b\u0001\"\u001b;fe\u0006$xN]\u000b\u0003\u0003c\u00012!a\r\u0010\u001b\u0005\u0001!A\u0005)be\"\u000b7\u000f[*fi&#XM]1u_J\u001c2aDA\u001d!\u0011\t\u0019$a\u000f\n\u0007\u0005urJ\u0001\rQCJ4E.\u0019;ICNDG+\u00192mK&#XM]1u_J\fQa\u001d;beR\u00042\u0001LA\"\u0013\r\t)E\n\u0002\u0004\u0013:$\u0018!D5uKJ\fG/Z:V]RLG.\u0003\u0003\u0002L\u0005m\u0012!B;oi&d\u0017!\u0004;pi\u0006dW\t\\3nK:$8/\u0003\u0003\u0002R\u0005m\u0012!\u0003;pi\u0006d7/\u001b>f)!\t\t$!\u0016\u0002X\u0005e\u0003bBA '\u0001\u0007\u0011\u0011\t\u0005\b\u0003\u000f\u001a\u0002\u0019AA!\u0011\u001d\tie\u0005a\u0001\u0003\u0003\n1B\\3x\u0013R,'/\u0019;peRA\u0011\u0011GA0\u0003C\n\u0019\u0007C\u0004\u0002@Q\u0001\r!!\u0011\t\u000f\u0005-C\u00031\u0001\u0002B!9\u0011Q\r\u000bA\u0002\u0005\u0005\u0013!\u0002;pi\u0006d\u0017\u0001B:ju\u0016,\"!!\u0011\u0002\u000b\rdW-\u0019:\u0015\u0005\u0005=\u0004c\u0001\u0017\u0002r%\u0019\u00111\u000f\u0014\u0003\tUs\u0017\u000e^\u0001\u0004g\u0016\fX#A%\u0002\u0011\u0011\u0002H.^:%KF$B!a\r\u0002~!1\u0011q\u0010\u0006A\u0002M\nA!\u001a7f[\u0006IA%\\5okN$S-\u001d\u000b\u0005\u0003g\t)\t\u0003\u0004\u0002\u0000-\u0001\raM\u0001\rgR\u0014\u0018N\\4Qe\u00164\u0017\u000e_\u000b\u0003\u0003\u0017\u0003B!a\u0007\u0002\u000e&!\u0011qRA\u000f\u0005\u0019\u0019FO]5oO\u0006A1m\u001c8uC&t7\u000f\u0006\u0003\u0002\u0016\u0006m\u0005c\u0001\u0017\u0002\u0018&\u0019\u0011\u0011\u0014\u0014\u0003\u000f\t{w\u000e\\3b]\"1\u0011qP\u0007A\u0002M\n\u0001b\u001d9mSR$XM]\u0001\foJLG/Z(cU\u0016\u001cG\u000f\u0006\u0003\u0002p\u0005\r\u0006bBAS+\u0001\u0007\u0011qU\u0001\u0002gB!\u0011\u0011VAX\u001b\t\tYK\u0003\u0003\u0002.\u0006\u0005\u0012AA5p\u0013\u0011\t\t,a+\u0003%=\u0013'.Z2u\u001fV$\b/\u001e;TiJ,\u0017-\\\u0001\u000be\u0016\fGm\u00142kK\u000e$H\u0003BA8\u0003oCq!!/\u0017\u0001\u0004\tY,\u0001\u0002j]B!\u0011\u0011VA_\u0013\u0011\ty,a+\u0003#=\u0013'.Z2u\u0013:\u0004X\u000f^*ue\u0016\fW.\u0001\teK\n,x-\u00138g_Jl\u0017\r^5p]V\u0011\u0011Q\u0019\t\u0005\u0003\u000f\f)N\u0004\u0003\u0002J\u0006E\u0007cAAfM5\u0011\u0011Q\u001a\u0006\u0004\u0003\u001fD\u0013A\u0002\u001fs_>$h(C\u0002\u0002T\u001a\na\u0001\u0015:fI\u00164\u0017\u0002BAH\u0003/T1!a5'Q\u001d\u0001\u00111\\Aq\u0003G\u00042\u0001LAo\u0013\r\tyN\n\u0002\u0011'\u0016\u0014\u0018.\u00197WKJ\u001c\u0018n\u001c8V\u0013\u0012\u000bQA^1mk\u0016t\u0012!\u0001")
public class ParHashSet<T>
implements scala.collection.parallel.mutable.ParSet<T>,
ParFlatHashTable<T>,
Serializable {
    public static final long serialVersionUID = 1L;
    private transient int _loadFactor;
    private transient Object[] table;
    private transient int tableSize;
    private transient int threshold;
    private transient int[] sizemap;
    private transient int seedvalue;
    private volatile transient TaskSupport scala$collection$parallel$ParIterableLike$$_tasksupport;
    private volatile ParIterableLike$ScanNode$ ScanNode$module;
    private volatile ParIterableLike$ScanLeaf$ ScanLeaf$module;

    public static <T> CanCombineFrom<ParHashSet<?>, T, ParHashSet<T>> canBuildFrom() {
        return ParHashSet$.MODULE$.canBuildFrom();
    }

    public static <A> CanBuildFrom<ParHashSet<?>, A, ParHashSet<A>> setCanBuildFrom() {
        return ParHashSet$.MODULE$.setCanBuildFrom();
    }

    @Override
    public boolean alwaysInitSizeMap() {
        return ParFlatHashTable.alwaysInitSizeMap$(this);
    }

    @Override
    public int capacity(int expectedSize) {
        return FlatHashTable.capacity$(this, expectedSize);
    }

    @Override
    public int initialSize() {
        return FlatHashTable.initialSize$(this);
    }

    @Override
    public int randomSeed() {
        return FlatHashTable.randomSeed$(this);
    }

    @Override
    public int tableSizeSeed() {
        return FlatHashTable.tableSizeSeed$(this);
    }

    @Override
    public void init(ObjectInputStream in, Function1<T, BoxedUnit> f) {
        FlatHashTable.init$(this, in, f);
    }

    @Override
    public void serializeTo(ObjectOutputStream out) {
        FlatHashTable.serializeTo$(this, out);
    }

    @Override
    public Option<T> findEntry(T elem) {
        return FlatHashTable.findEntry$(this, elem);
    }

    @Override
    public boolean containsElem(T elem) {
        return FlatHashTable.containsElem$(this, elem);
    }

    @Override
    public boolean addElem(T elem) {
        return FlatHashTable.addElem$(this, elem);
    }

    @Override
    public boolean addEntry(Object newEntry) {
        return FlatHashTable.addEntry$(this, newEntry);
    }

    @Override
    public boolean removeElem(T elem) {
        return FlatHashTable.removeElem$(this, elem);
    }

    @Override
    public void nnSizeMapAdd(int h) {
        FlatHashTable.nnSizeMapAdd$(this, h);
    }

    @Override
    public void nnSizeMapRemove(int h) {
        FlatHashTable.nnSizeMapRemove$(this, h);
    }

    @Override
    public void nnSizeMapReset(int tableLength) {
        FlatHashTable.nnSizeMapReset$(this, tableLength);
    }

    @Override
    public final int totalSizeMapBuckets() {
        return FlatHashTable.totalSizeMapBuckets$(this);
    }

    @Override
    public int calcSizeMapSize(int tableLength) {
        return FlatHashTable.calcSizeMapSize$(this, tableLength);
    }

    @Override
    public void sizeMapInit(int tableLength) {
        FlatHashTable.sizeMapInit$(this, tableLength);
    }

    @Override
    public void sizeMapInitAndRebuild() {
        FlatHashTable.sizeMapInitAndRebuild$(this);
    }

    @Override
    public void printSizeMap() {
        FlatHashTable.printSizeMap$(this);
    }

    @Override
    public void printContents() {
        FlatHashTable.printContents$(this);
    }

    @Override
    public void sizeMapDisable() {
        FlatHashTable.sizeMapDisable$(this);
    }

    @Override
    public boolean isSizeMapDefined() {
        return FlatHashTable.isSizeMapDefined$(this);
    }

    @Override
    public final int index(int hcode) {
        return FlatHashTable.index$(this, hcode);
    }

    @Override
    public void clearTable() {
        FlatHashTable.clearTable$(this);
    }

    @Override
    public FlatHashTable.Contents<T> hashTableContents() {
        return FlatHashTable.hashTableContents$(this);
    }

    @Override
    public void initWithContents(FlatHashTable.Contents<T> c) {
        FlatHashTable.initWithContents$(this, c);
    }

    @Override
    public final int sizeMapBucketBitSize() {
        return FlatHashTable.HashUtils.sizeMapBucketBitSize$(this);
    }

    @Override
    public final int sizeMapBucketSize() {
        return FlatHashTable.HashUtils.sizeMapBucketSize$(this);
    }

    @Override
    public final int improve(int hcode, int seed) {
        return FlatHashTable.HashUtils.improve$(this, hcode, seed);
    }

    @Override
    public final Object elemToEntry(T elem) {
        return FlatHashTable.HashUtils.elemToEntry$(this, elem);
    }

    @Override
    public final T entryToElem(Object entry) {
        return (T)FlatHashTable.HashUtils.entryToElem$(this, entry);
    }

    @Override
    public scala.collection.parallel.mutable.ParSet $plus(Object elem) {
        return ParSetLike.$plus$(this, elem);
    }

    @Override
    public scala.collection.parallel.mutable.ParSet $minus(Object elem) {
        return ParSetLike.$minus$(this, elem);
    }

    @Override
    public /* synthetic */ Object scala$collection$mutable$Cloneable$$super$clone() {
        return super.clone();
    }

    @Override
    public Object clone() {
        return Cloneable.clone$(this);
    }

    @Override
    public Shrinkable<T> $minus$eq(T elem1, T elem2, Seq<T> elems) {
        return Shrinkable.$minus$eq$(this, elem1, elem2, elems);
    }

    @Override
    public Shrinkable<T> $minus$minus$eq(TraversableOnce<T> xs) {
        return Shrinkable.$minus$minus$eq$(this, xs);
    }

    @Override
    public Growable<T> $plus$eq(T elem1, T elem2, Seq<T> elems) {
        return Growable.$plus$eq$(this, elem1, elem2, elems);
    }

    @Override
    public Growable<T> $plus$plus$eq(TraversableOnce<T> xs) {
        return Growable.$plus$plus$eq$(this, xs);
    }

    @Override
    public ParSet union(GenSet that) {
        return scala.collection.parallel.ParSetLike.union$(this, that);
    }

    @Override
    public ParSet diff(GenSet that) {
        return scala.collection.parallel.ParSetLike.diff$(this, that);
    }

    @Override
    public ParIterable<T> toIterable() {
        return ParIterable.toIterable$(this);
    }

    @Override
    public ParSeq<T> toSeq() {
        return ParIterable.toSeq$(this);
    }

    @Override
    public void initTaskSupport() {
        ParIterableLike.initTaskSupport$(this);
    }

    @Override
    public TaskSupport tasksupport() {
        return ParIterableLike.tasksupport$(this);
    }

    @Override
    public void tasksupport_$eq(TaskSupport ts) {
        ParIterableLike.tasksupport_$eq$(this, ts);
    }

    @Override
    public scala.collection.parallel.ParIterable repr() {
        return ParIterableLike.repr$(this);
    }

    @Override
    public final boolean isTraversableAgain() {
        return ParIterableLike.isTraversableAgain$(this);
    }

    @Override
    public boolean hasDefiniteSize() {
        return ParIterableLike.hasDefiniteSize$(this);
    }

    @Override
    public boolean isEmpty() {
        return ParIterableLike.isEmpty$(this);
    }

    @Override
    public boolean nonEmpty() {
        return ParIterableLike.nonEmpty$(this);
    }

    @Override
    public T head() {
        return (T)ParIterableLike.head$(this);
    }

    @Override
    public Option<T> headOption() {
        return ParIterableLike.headOption$(this);
    }

    @Override
    public scala.collection.parallel.ParIterable tail() {
        return ParIterableLike.tail$(this);
    }

    @Override
    public T last() {
        return (T)ParIterableLike.last$(this);
    }

    @Override
    public Option<T> lastOption() {
        return ParIterableLike.lastOption$(this);
    }

    @Override
    public scala.collection.parallel.ParIterable init() {
        return ParIterableLike.init$(this);
    }

    @Override
    public scala.collection.parallel.ParIterable par() {
        return ParIterableLike.par$(this);
    }

    @Override
    public boolean isStrictSplitterCollection() {
        return ParIterableLike.isStrictSplitterCollection$(this);
    }

    @Override
    public <S, That> Combiner<S, That> reuse(Option<Combiner<S, That>> oldc, Combiner<S, That> newc) {
        return ParIterableLike.reuse$(this, oldc, newc);
    }

    @Override
    public <R, Tp> ParIterableLike.TaskOps<R, Tp> task2ops(ParIterableLike.StrictSplitterCheckTask<R, Tp> tsk) {
        return ParIterableLike.task2ops$(this, tsk);
    }

    @Override
    public <R> ParIterableLike.NonDivisible<R> wrap(Function0<R> body) {
        return ParIterableLike.wrap$(this, body);
    }

    @Override
    public <PI extends DelegatedSignalling> ParIterableLike.SignallingOps<PI> delegatedSignalling2ops(PI it) {
        return ParIterableLike.delegatedSignalling2ops$(this, it);
    }

    @Override
    public <Elem, To> ParIterableLike.BuilderOps<Elem, To> builder2ops(Builder<Elem, To> cb) {
        return ParIterableLike.builder2ops$(this, cb);
    }

    @Override
    public <S, That> CanBuildFrom<HashSet<T>, S, That> bf2seq(CanBuildFrom<ParHashSet<T>, S, That> bf) {
        return ParIterableLike.bf2seq$(this, bf);
    }

    @Override
    public scala.collection.parallel.ParIterable sequentially(Function1 b) {
        return ParIterableLike.sequentially$(this, b);
    }

    @Override
    public String mkString(String start, String sep, String end) {
        return ParIterableLike.mkString$(this, start, sep, end);
    }

    @Override
    public String mkString(String sep) {
        return ParIterableLike.mkString$(this, sep);
    }

    @Override
    public String mkString() {
        return ParIterableLike.mkString$(this);
    }

    @Override
    public String toString() {
        return ParIterableLike.toString$(this);
    }

    @Override
    public boolean canEqual(Object other) {
        return ParIterableLike.canEqual$(this, other);
    }

    @Override
    public <U> U reduce(Function2<U, U, U> op) {
        return (U)ParIterableLike.reduce$(this, op);
    }

    @Override
    public <U> Option<U> reduceOption(Function2<U, U, U> op) {
        return ParIterableLike.reduceOption$(this, op);
    }

    @Override
    public <U> U fold(U z, Function2<U, U, U> op) {
        return (U)ParIterableLike.fold$(this, z, op);
    }

    @Override
    public <S> S aggregate(Function0<S> z, Function2<S, T, S> seqop, Function2<S, S, S> combop) {
        return (S)ParIterableLike.aggregate$(this, z, seqop, combop);
    }

    @Override
    public <S> S foldLeft(S z, Function2<S, T, S> op) {
        return (S)ParIterableLike.foldLeft$(this, z, op);
    }

    @Override
    public <S> S foldRight(S z, Function2<T, S, S> op) {
        return (S)ParIterableLike.foldRight$(this, z, op);
    }

    @Override
    public <U> U reduceLeft(Function2<U, T, U> op) {
        return (U)ParIterableLike.reduceLeft$(this, op);
    }

    @Override
    public <U> U reduceRight(Function2<T, U, U> op) {
        return (U)ParIterableLike.reduceRight$(this, op);
    }

    @Override
    public <U> Option<U> reduceLeftOption(Function2<U, T, U> op) {
        return ParIterableLike.reduceLeftOption$(this, op);
    }

    @Override
    public <U> Option<U> reduceRightOption(Function2<T, U, U> op) {
        return ParIterableLike.reduceRightOption$(this, op);
    }

    @Override
    public <U> void foreach(Function1<T, U> f) {
        ParIterableLike.foreach$(this, f);
    }

    @Override
    public int count(Function1<T, Object> p) {
        return ParIterableLike.count$(this, p);
    }

    @Override
    public <U> U sum(Numeric<U> num) {
        return (U)ParIterableLike.sum$(this, num);
    }

    @Override
    public <U> U product(Numeric<U> num) {
        return (U)ParIterableLike.product$(this, num);
    }

    @Override
    public <U> T min(Ordering<U> ord) {
        return (T)ParIterableLike.min$(this, ord);
    }

    @Override
    public <U> T max(Ordering<U> ord) {
        return (T)ParIterableLike.max$(this, ord);
    }

    @Override
    public <S> T maxBy(Function1<T, S> f, Ordering<S> cmp) {
        return (T)ParIterableLike.maxBy$(this, f, cmp);
    }

    @Override
    public <S> T minBy(Function1<T, S> f, Ordering<S> cmp) {
        return (T)ParIterableLike.minBy$(this, f, cmp);
    }

    @Override
    public <S, That> That map(Function1<T, S> f, CanBuildFrom<ParHashSet<T>, S, That> bf) {
        return (That)ParIterableLike.map$(this, f, bf);
    }

    @Override
    public <S, That> That collect(PartialFunction<T, S> pf, CanBuildFrom<ParHashSet<T>, S, That> bf) {
        return (That)ParIterableLike.collect$(this, pf, bf);
    }

    @Override
    public <S, That> That flatMap(Function1<T, GenTraversableOnce<S>> f, CanBuildFrom<ParHashSet<T>, S, That> bf) {
        return (That)ParIterableLike.flatMap$(this, f, bf);
    }

    @Override
    public boolean forall(Function1<T, Object> p) {
        return ParIterableLike.forall$(this, p);
    }

    @Override
    public boolean exists(Function1<T, Object> p) {
        return ParIterableLike.exists$(this, p);
    }

    @Override
    public Option<T> find(Function1<T, Object> p) {
        return ParIterableLike.find$(this, p);
    }

    @Override
    public CombinerFactory<T, ParHashSet<T>> combinerFactory() {
        return ParIterableLike.combinerFactory$(this);
    }

    @Override
    public <S, That> CombinerFactory<S, That> combinerFactory(Function0<Combiner<S, That>> cbf) {
        return ParIterableLike.combinerFactory$(this, cbf);
    }

    @Override
    public scala.collection.parallel.ParIterable withFilter(Function1 pred) {
        return ParIterableLike.withFilter$(this, pred);
    }

    @Override
    public scala.collection.parallel.ParIterable filter(Function1 pred) {
        return ParIterableLike.filter$(this, pred);
    }

    @Override
    public scala.collection.parallel.ParIterable filterNot(Function1 pred) {
        return ParIterableLike.filterNot$(this, pred);
    }

    @Override
    public <U, That> That $plus$plus(GenTraversableOnce<U> that, CanBuildFrom<ParHashSet<T>, U, That> bf) {
        return (That)ParIterableLike.$plus$plus$(this, that, bf);
    }

    @Override
    public Tuple2<ParHashSet<T>, ParHashSet<T>> partition(Function1<T, Object> pred) {
        return ParIterableLike.partition$(this, pred);
    }

    @Override
    public <K> ParMap<K, ParHashSet<T>> groupBy(Function1<T, K> f) {
        return ParIterableLike.groupBy$(this, f);
    }

    @Override
    public scala.collection.parallel.ParIterable take(int n) {
        return ParIterableLike.take$(this, n);
    }

    @Override
    public scala.collection.parallel.ParIterable drop(int n) {
        return ParIterableLike.drop$(this, n);
    }

    @Override
    public scala.collection.parallel.ParIterable slice(int unc_from, int unc_until) {
        return ParIterableLike.slice$(this, unc_from, unc_until);
    }

    @Override
    public Tuple2<ParHashSet<T>, ParHashSet<T>> splitAt(int n) {
        return ParIterableLike.splitAt$(this, n);
    }

    @Override
    public <U, That> That scan(U z, Function2<U, U, U> op, CanBuildFrom<ParHashSet<T>, U, That> bf) {
        return (That)ParIterableLike.scan$(this, z, op, bf);
    }

    @Override
    public <S, That> That scanLeft(S z, Function2<S, T, S> op, CanBuildFrom<ParHashSet<T>, S, That> bf) {
        return (That)ParIterableLike.scanLeft$(this, z, op, bf);
    }

    @Override
    public <S, That> That scanRight(S z, Function2<T, S, S> op, CanBuildFrom<ParHashSet<T>, S, That> bf) {
        return (That)ParIterableLike.scanRight$(this, z, op, bf);
    }

    @Override
    public scala.collection.parallel.ParIterable takeWhile(Function1 pred) {
        return ParIterableLike.takeWhile$(this, pred);
    }

    @Override
    public Tuple2<ParHashSet<T>, ParHashSet<T>> span(Function1<T, Object> pred) {
        return ParIterableLike.span$(this, pred);
    }

    @Override
    public scala.collection.parallel.ParIterable dropWhile(Function1 pred) {
        return ParIterableLike.dropWhile$(this, pred);
    }

    @Override
    public <U> void copyToArray(Object xs) {
        ParIterableLike.copyToArray$(this, xs);
    }

    @Override
    public <U> void copyToArray(Object xs, int start) {
        ParIterableLike.copyToArray$(this, xs, start);
    }

    @Override
    public <U> void copyToArray(Object xs, int start, int len) {
        ParIterableLike.copyToArray$(this, xs, start, len);
    }

    @Override
    public <U> boolean sameElements(GenIterable<U> that) {
        return ParIterableLike.sameElements$(this, that);
    }

    @Override
    public <U, S, That> That zip(GenIterable<S> that, CanBuildFrom<ParHashSet<T>, Tuple2<U, S>, That> bf) {
        return (That)ParIterableLike.zip$(this, that, bf);
    }

    @Override
    public <U, That> That zipWithIndex(CanBuildFrom<ParHashSet<T>, Tuple2<U, Object>, That> bf) {
        return (That)ParIterableLike.zipWithIndex$(this, bf);
    }

    @Override
    public <S, U, That> That zipAll(GenIterable<S> that, U thisElem, S thatElem, CanBuildFrom<ParHashSet<T>, Tuple2<U, S>, That> bf) {
        return (That)ParIterableLike.zipAll$(this, that, thisElem, thatElem, bf);
    }

    @Override
    public <U, That> That toParCollection(Function0<Combiner<U, That>> cbf) {
        return (That)ParIterableLike.toParCollection$(this, cbf);
    }

    @Override
    public <K, V, That> That toParMap(Function0<Combiner<Tuple2<K, V>, That>> cbf, Predef$.less.colon.less<T, Tuple2<K, V>> ev) {
        return (That)ParIterableLike.toParMap$(this, cbf, ev);
    }

    @Override
    public IterableView<T, HashSet<T>> view() {
        return ParIterableLike.view$(this);
    }

    @Override
    public <U> Object toArray(ClassTag<U> evidence$1) {
        return ParIterableLike.toArray$(this, evidence$1);
    }

    @Override
    public List<T> toList() {
        return ParIterableLike.toList$(this);
    }

    @Override
    public IndexedSeq<T> toIndexedSeq() {
        return ParIterableLike.toIndexedSeq$(this);
    }

    @Override
    public Stream<T> toStream() {
        return ParIterableLike.toStream$(this);
    }

    @Override
    public Iterator<T> toIterator() {
        return ParIterableLike.toIterator$(this);
    }

    @Override
    public <U> Buffer<U> toBuffer() {
        return ParIterableLike.toBuffer$(this);
    }

    @Override
    public GenTraversable<T> toTraversable() {
        return ParIterableLike.toTraversable$(this);
    }

    @Override
    public <U> scala.collection.parallel.immutable.ParSet<U> toSet() {
        return ParIterableLike.toSet$(this);
    }

    @Override
    public <K, V> ParMap<K, V> toMap(Predef$.less.colon.less<T, Tuple2<K, V>> ev) {
        return ParIterableLike.toMap$(this, ev);
    }

    @Override
    public Vector<T> toVector() {
        return ParIterableLike.toVector$(this);
    }

    @Override
    public <Col> Col to(CanBuildFrom<Nothing$, T, Col> cbf) {
        return (Col)ParIterableLike.to$(this, cbf);
    }

    @Override
    public int scanBlockSize() {
        return ParIterableLike.scanBlockSize$(this);
    }

    @Override
    public <S> S $div$colon(S z, Function2<S, T, S> op) {
        return (S)ParIterableLike.$div$colon$(this, z, op);
    }

    @Override
    public <S> S $colon$bslash(S z, Function2<T, S, S> op) {
        return (S)ParIterableLike.$colon$bslash$(this, z, op);
    }

    @Override
    public Seq<String> brokenInvariants() {
        return ParIterableLike.brokenInvariants$(this);
    }

    @Override
    public ArrayBuffer<String> debugBuffer() {
        return ParIterableLike.debugBuffer$(this);
    }

    @Override
    public void debugclear() {
        ParIterableLike.debugclear$(this);
    }

    @Override
    public ArrayBuffer<String> debuglog(String s) {
        return ParIterableLike.debuglog$(this, s);
    }

    @Override
    public void printDebugBuffer() {
        ParIterableLike.printDebugBuffer$(this);
    }

    @Override
    public Combiner<T, ParHashSet<T>> parCombiner() {
        return CustomParallelizable.parCombiner$(this);
    }

    @Override
    public Builder<T, ParHashSet<T>> newBuilder() {
        return GenericParTemplate.newBuilder$(this);
    }

    @Override
    public Combiner<T, ParHashSet<T>> newCombiner() {
        return GenericParTemplate.newCombiner$(this);
    }

    @Override
    public <B> Combiner<B, ParHashSet<B>> genericBuilder() {
        return GenericParTemplate.genericBuilder$(this);
    }

    @Override
    public <B> Combiner<B, ParHashSet<B>> genericCombiner() {
        return GenericParTemplate.genericCombiner$(this);
    }

    @Override
    public <A1, A2> Tuple2<ParHashSet<A1>, ParHashSet<A2>> unzip(Function1<T, Tuple2<A1, A2>> asPair) {
        return GenericTraversableTemplate.unzip$(this, asPair);
    }

    @Override
    public <A1, A2, A3> Tuple3<ParHashSet<A1>, ParHashSet<A2>, ParHashSet<A3>> unzip3(Function1<T, Tuple3<A1, A2, A3>> asTriple) {
        return GenericTraversableTemplate.unzip3$(this, asTriple);
    }

    @Override
    public GenTraversable flatten(Function1 asTraversable) {
        return GenericTraversableTemplate.flatten$(this, asTraversable);
    }

    @Override
    public GenTraversable transpose(Function1 asTraversable) {
        return GenericTraversableTemplate.transpose$(this, asTraversable);
    }

    @Override
    public boolean apply(T elem) {
        return GenSetLike.apply$(this, elem);
    }

    @Override
    public Object intersect(GenSet that) {
        return GenSetLike.intersect$(this, that);
    }

    @Override
    public Object $amp(GenSet that) {
        return GenSetLike.$amp$(this, that);
    }

    @Override
    public Object $bar(GenSet that) {
        return GenSetLike.$bar$(this, that);
    }

    @Override
    public Object $amp$tilde(GenSet that) {
        return GenSetLike.$amp$tilde$(this, that);
    }

    @Override
    public boolean subsetOf(GenSet<T> that) {
        return GenSetLike.subsetOf$(this, that);
    }

    @Override
    public boolean equals(Object that) {
        return GenSetLike.equals$(this, that);
    }

    @Override
    public int hashCode() {
        return GenSetLike.hashCode$(this);
    }

    @Override
    public boolean apply$mcZD$sp(double v1) {
        return Function1.apply$mcZD$sp$(this, v1);
    }

    @Override
    public double apply$mcDD$sp(double v1) {
        return Function1.apply$mcDD$sp$(this, v1);
    }

    @Override
    public float apply$mcFD$sp(double v1) {
        return Function1.apply$mcFD$sp$(this, v1);
    }

    @Override
    public int apply$mcID$sp(double v1) {
        return Function1.apply$mcID$sp$(this, v1);
    }

    @Override
    public long apply$mcJD$sp(double v1) {
        return Function1.apply$mcJD$sp$(this, v1);
    }

    @Override
    public void apply$mcVD$sp(double v1) {
        Function1.apply$mcVD$sp$(this, v1);
    }

    @Override
    public boolean apply$mcZF$sp(float v1) {
        return Function1.apply$mcZF$sp$(this, v1);
    }

    @Override
    public double apply$mcDF$sp(float v1) {
        return Function1.apply$mcDF$sp$(this, v1);
    }

    @Override
    public float apply$mcFF$sp(float v1) {
        return Function1.apply$mcFF$sp$(this, v1);
    }

    @Override
    public int apply$mcIF$sp(float v1) {
        return Function1.apply$mcIF$sp$(this, v1);
    }

    @Override
    public long apply$mcJF$sp(float v1) {
        return Function1.apply$mcJF$sp$(this, v1);
    }

    @Override
    public void apply$mcVF$sp(float v1) {
        Function1.apply$mcVF$sp$(this, v1);
    }

    @Override
    public boolean apply$mcZI$sp(int v1) {
        return Function1.apply$mcZI$sp$(this, v1);
    }

    @Override
    public double apply$mcDI$sp(int v1) {
        return Function1.apply$mcDI$sp$(this, v1);
    }

    @Override
    public float apply$mcFI$sp(int v1) {
        return Function1.apply$mcFI$sp$(this, v1);
    }

    @Override
    public int apply$mcII$sp(int v1) {
        return Function1.apply$mcII$sp$(this, v1);
    }

    @Override
    public long apply$mcJI$sp(int v1) {
        return Function1.apply$mcJI$sp$(this, v1);
    }

    @Override
    public void apply$mcVI$sp(int v1) {
        Function1.apply$mcVI$sp$(this, v1);
    }

    @Override
    public boolean apply$mcZJ$sp(long v1) {
        return Function1.apply$mcZJ$sp$(this, v1);
    }

    @Override
    public double apply$mcDJ$sp(long v1) {
        return Function1.apply$mcDJ$sp$(this, v1);
    }

    @Override
    public float apply$mcFJ$sp(long v1) {
        return Function1.apply$mcFJ$sp$(this, v1);
    }

    @Override
    public int apply$mcIJ$sp(long v1) {
        return Function1.apply$mcIJ$sp$(this, v1);
    }

    @Override
    public long apply$mcJJ$sp(long v1) {
        return Function1.apply$mcJJ$sp$(this, v1);
    }

    @Override
    public void apply$mcVJ$sp(long v1) {
        Function1.apply$mcVJ$sp$(this, v1);
    }

    @Override
    public <A> Function1<A, Object> compose(Function1<A, T> g) {
        return Function1.compose$(this, g);
    }

    @Override
    public <A> Function1<T, A> andThen(Function1<Object, A> g) {
        return Function1.andThen$(this, g);
    }

    @Override
    public int sizeHintIfCheap() {
        return GenTraversableOnce.sizeHintIfCheap$(this);
    }

    @Override
    public int _loadFactor() {
        return this._loadFactor;
    }

    @Override
    public void _loadFactor_$eq(int x$1) {
        this._loadFactor = x$1;
    }

    @Override
    public Object[] table() {
        return this.table;
    }

    @Override
    public void table_$eq(Object[] x$1) {
        this.table = x$1;
    }

    @Override
    public int tableSize() {
        return this.tableSize;
    }

    @Override
    public void tableSize_$eq(int x$1) {
        this.tableSize = x$1;
    }

    @Override
    public int threshold() {
        return this.threshold;
    }

    @Override
    public void threshold_$eq(int x$1) {
        this.threshold = x$1;
    }

    @Override
    public int[] sizemap() {
        return this.sizemap;
    }

    @Override
    public void sizemap_$eq(int[] x$1) {
        this.sizemap = x$1;
    }

    @Override
    public int seedvalue() {
        return this.seedvalue;
    }

    @Override
    public void seedvalue_$eq(int x$1) {
        this.seedvalue = x$1;
    }

    @Override
    public TaskSupport scala$collection$parallel$ParIterableLike$$_tasksupport() {
        return this.scala$collection$parallel$ParIterableLike$$_tasksupport;
    }

    @Override
    public void scala$collection$parallel$ParIterableLike$$_tasksupport_$eq(TaskSupport x$1) {
        this.scala$collection$parallel$ParIterableLike$$_tasksupport = x$1;
    }

    @Override
    public ParIterableLike$ScanNode$ ScanNode() {
        if (this.ScanNode$module == null) {
            this.ScanNode$lzycompute$1();
        }
        return this.ScanNode$module;
    }

    @Override
    public ParIterableLike$ScanLeaf$ ScanLeaf() {
        if (this.ScanLeaf$module == null) {
            this.ScanLeaf$lzycompute$1();
        }
        return this.ScanLeaf$module;
    }

    public ParHashSet$ companion() {
        return ParHashSet$.MODULE$;
    }

    @Override
    public ParHashSet<T> empty() {
        return new ParHashSet<T>();
    }

    public ParHashSetIterator iterator() {
        return this.splitter();
    }

    @Override
    public int size() {
        return this.tableSize();
    }

    @Override
    public void clear() {
        this.clearTable();
    }

    @Override
    public HashSet<T> seq() {
        return new HashSet<T>(this.hashTableContents());
    }

    @Override
    public ParHashSet<T> $plus$eq(T elem) {
        this.addElem(elem);
        return this;
    }

    @Override
    public ParHashSet<T> $minus$eq(T elem) {
        this.removeElem(elem);
        return this;
    }

    @Override
    public String stringPrefix() {
        return "ParHashSet";
    }

    @Override
    public boolean contains(T elem) {
        return this.containsElem(elem);
    }

    public ParHashSetIterator splitter() {
        return new ParHashSetIterator(this, 0, this.table().length, this.size());
    }

    private void writeObject(ObjectOutputStream s) {
        this.serializeTo(s);
    }

    private void readObject(ObjectInputStream in) {
        this.init(in, (Function1<T, BoxedUnit>)(Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
            ParHashSet.$anonfun$readObject$1(x);
            return BoxedUnit.UNIT;
        });
    }

    @Override
    public String debugInformation() {
        return DebugUtils$.MODULE$.buildString((Function1<Function1<Object, BoxedUnit>, BoxedUnit>)(Function1<Function1, Object> & java.io.Serializable & Serializable)append -> {
            append.apply("Parallel flat hash table set");
            append.apply(new StringBuilder(11).append("No. elems: ").append(this.tableSize()).toString());
            append.apply(new StringBuilder(14).append("Table length: ").append(this.table().length).toString());
            append.apply("Table: ");
            append.apply(DebugUtils$.MODULE$.arrayString(this.table(), 0, this.table().length));
            append.apply("Sizemap: ");
            append.apply(DebugUtils$.MODULE$.arrayString(this.sizemap(), 0, this.sizemap().length));
            return BoxedUnit.UNIT;
        });
    }

    private final void ScanNode$lzycompute$1() {
        synchronized (this) {
            if (this.ScanNode$module == null) {
                this.ScanNode$module = new ParIterableLike$ScanNode$(this);
            }
            return;
        }
    }

    private final void ScanLeaf$lzycompute$1() {
        synchronized (this) {
            if (this.ScanLeaf$module == null) {
                this.ScanLeaf$module = new ParIterableLike$ScanLeaf$(this);
            }
            return;
        }
    }

    public static final /* synthetic */ void $anonfun$readObject$1(Object x) {
    }

    public static final /* synthetic */ void $anonfun$debugInformation$1(ParHashSet $this, Function1 append) {
        append.apply("Parallel flat hash table set");
        append.apply(new StringBuilder(11).append("No. elems: ").append($this.tableSize()).toString());
        append.apply(new StringBuilder(14).append("Table length: ").append($this.table().length).toString());
        append.apply("Table: ");
        append.apply(DebugUtils$.MODULE$.arrayString($this.table(), 0, $this.table().length));
        append.apply("Sizemap: ");
        append.apply(DebugUtils$.MODULE$.arrayString($this.sizemap(), 0, $this.sizemap().length));
    }

    public ParHashSet(FlatHashTable.Contents<T> contents) {
        GenTraversableOnce.$init$(this);
        Parallelizable.$init$(this);
        GenSetLike.$init$(this);
        GenericTraversableTemplate.$init$(this);
        GenTraversable.$init$(this);
        GenIterable.$init$(this);
        GenericSetTemplate.$init$(this);
        GenSet.$init$(this);
        GenericParTemplate.$init$(this);
        CustomParallelizable.$init$(this);
        ParIterableLike.$init$(this);
        scala.collection.parallel.ParIterable.$init$(this);
        ParIterable.$init$(this);
        scala.collection.parallel.ParSetLike.$init$(this);
        ParSet.$init$(this);
        Growable.$init$(this);
        Shrinkable.$init$(this);
        Cloneable.$init$(this);
        ParSetLike.$init$(this);
        scala.collection.parallel.mutable.ParSet.$init$(this);
        FlatHashTable.HashUtils.$init$(this);
        FlatHashTable.$init$(this);
        ParFlatHashTable.$init$(this);
        this.initWithContents(contents);
    }

    public ParHashSet() {
        this(null);
    }

    public class ParHashSetIterator
    extends ParFlatHashTable.ParFlatHashTableIterator {
        public ParHashSetIterator newIterator(int start, int until, int total) {
            return new ParHashSetIterator(this.scala$collection$parallel$mutable$ParHashSet$ParHashSetIterator$$$outer(), start, until, total);
        }

        public /* synthetic */ ParHashSet scala$collection$parallel$mutable$ParHashSet$ParHashSetIterator$$$outer() {
            return (ParHashSet)this.$outer;
        }

        public ParHashSetIterator(ParHashSet $outer, int start, int iteratesUntil, int totalElements) {
            super($outer, start, iteratesUntil, totalElements);
        }
    }
}

