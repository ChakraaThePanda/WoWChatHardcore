/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.immutable;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.MatchError;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.AbstractIterator;
import scala.collection.BufferedIterator;
import scala.collection.CustomParallelizable;
import scala.collection.GenIterable;
import scala.collection.GenSeq;
import scala.collection.GenSeqLike;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.IterableLike;
import scala.collection.Iterator;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.SeqView;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.DelegatedSignalling;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericParTemplate;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.generic.Signalling;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.AugmentedIterableIterator;
import scala.collection.parallel.AugmentedSeqIterator;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.CombinerFactory;
import scala.collection.parallel.IterableSplitter;
import scala.collection.parallel.ParIterableLike;
import scala.collection.parallel.ParIterableLike$ScanLeaf$;
import scala.collection.parallel.ParIterableLike$ScanNode$;
import scala.collection.parallel.ParSeq;
import scala.collection.parallel.ParSeqLike;
import scala.collection.parallel.PreciseSplitter;
import scala.collection.parallel.RemainsIterator;
import scala.collection.parallel.SeqSplitter;
import scala.collection.parallel.TaskSupport;
import scala.collection.parallel.immutable.ParIterable;
import scala.collection.parallel.immutable.ParMap;
import scala.collection.parallel.immutable.ParSet;
import scala.collection.parallel.immutable.Repetition$ParIterator$;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.package$;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.LambdaDeserialize;
import scala.runtime.Nothing$;
import scala.runtime.RichInt$;
import scala.runtime.java8.JFunction2$mcIII$sp;

@ScalaSignature(bytes="\u0006\u0001\u0005}b!B\u000f\u001f\u0001\u00012\u0003\u0002\u0003\u001f\u0001\u0005\u0003\u0005\u000b\u0011\u0002\u0019\t\u0011u\u0002!Q1A\u0005\u0002yB\u0001B\u0011\u0001\u0003\u0002\u0003\u0006Ia\u0010\u0005\u0006\u0007\u0002!\t\u0001\u0012\u0005\u0006\u0011\u0002!\t!\u0013\u0005\u0006\u0019\u0002!\t%\u0014\u0005\u0006'\u0002!\t\u0001\u0016\u0004\u0005/\u0002\u0001\u0001\f\u0003\u0005^\u0011\t\u0005\r\u0011\"\u0001?\u0011!q\u0006B!a\u0001\n\u0003y\u0006\u0002C3\t\u0005\u0003\u0005\u000b\u0015B \t\u0011\u0019D!Q1A\u0005\u0002yB\u0001b\u001a\u0005\u0003\u0002\u0003\u0006Ia\u0010\u0005\ty!\u0011\t\u0011)A\u0005a!)1\t\u0003C\u0001Q\")a\u000e\u0003C\u0001}!)q\u000e\u0003C\u0001a\")A\u000f\u0003C\u0001k\")a\u000f\u0003C\u0001o\")\u0001\u0010\u0003C\u0001s\"9\u00111\u0002\u0005\u0005\u0002\u00055q!CA\u000b\u0001\u0005\u0005\t\u0012AA\f\r!9\u0006!!A\t\u0002\u0005e\u0001BB\"\u0018\t\u0003\tY\u0002C\u0005\u0002\u001e]\t\n\u0011\"\u0001\u0002 !I\u0011QG\f\u0012\u0002\u0013\u0005\u0011q\u0004\u0005\n\u0003o9\u0012\u0013!C\u0001\u0003sAa!!\u0010\u0001\t\u00039(A\u0003*fa\u0016$\u0018\u000e^5p]*\u0011q\u0004I\u0001\nS6lW\u000f^1cY\u0016T!!\t\u0012\u0002\u0011A\f'/\u00197mK2T!a\t\u0013\u0002\u0015\r|G\u000e\\3di&|gNC\u0001&\u0003\u0015\u00198-\u00197b+\t9#gE\u0002\u0001Q1\u0002\"!\u000b\u0016\u000e\u0003\u0011J!a\u000b\u0013\u0003\r\u0005s\u0017PU3g!\ric\u0006M\u0007\u0002=%\u0011qF\b\u0002\u0007!\u0006\u00148+Z9\u0011\u0005E\u0012D\u0002\u0001\u0003\u0006g\u0001\u0011\r!\u000e\u0002\u0002)\u000e\u0001\u0011C\u0001\u001c:!\tIs'\u0003\u00029I\t9aj\u001c;iS:<\u0007CA\u0015;\u0013\tYDEA\u0002B]f\fA!\u001a7f[\u00061A.\u001a8hi\",\u0012a\u0010\t\u0003S\u0001K!!\u0011\u0013\u0003\u0007%sG/A\u0004mK:<G\u000f\u001b\u0011\u0002\rqJg.\u001b;?)\r)ei\u0012\t\u0004[\u0001\u0001\u0004\"\u0002\u001f\u0005\u0001\u0004\u0001\u0004\"B\u001f\u0005\u0001\u0004y\u0014!B1qa2LHC\u0001\u0019K\u0011\u0015YU\u00011\u0001@\u0003\rIG\r_\u0001\u0004g\u0016\fX#\u0001(\u0011\u0007=\u000b\u0006'D\u0001Q\u0015\ty\"%\u0003\u0002S!\n\u00191+Z9\u0002\rU\u0004H-\u0019;f)\r1TK\u0016\u0005\u0006\u0017\u001e\u0001\ra\u0010\u0005\u0006y\u001d\u0001\r\u0001\r\u0002\f!\u0006\u0014\u0018\n^3sCR|'oE\u0002\tQe\u00032AW.1\u001b\u0005\u0001\u0013B\u0001/!\u0005-\u0019V-]*qY&$H/\u001a:\u0002\u0003%\fQ![0%KF$\"\u0001Y2\u0011\u0005%\n\u0017B\u00012%\u0005\u0011)f.\u001b;\t\u000f\u0011T\u0011\u0011!a\u0001\u007f\u0005\u0019\u0001\u0010J\u0019\u0002\u0005%\u0004\u0013!B;oi&d\u0017AB;oi&d\u0007\u0005\u0006\u0003jW2l\u0007C\u00016\t\u001b\u0005\u0001\u0001bB/\u0010!\u0003\u0005\ra\u0010\u0005\bM>\u0001\n\u00111\u0001@\u0011\u001dat\u0002%AA\u0002A\n\u0011B]3nC&t\u0017N\\4\u0002\u000f!\f7OT3yiV\t\u0011\u000f\u0005\u0002*e&\u00111\u000f\n\u0002\b\u0005>|G.Z1o\u0003\u0011qW\r\u001f;\u0015\u0003A\n1\u0001Z;q+\u0005I\u0017A\u00029ta2LG\u000fF\u0002{\u0003\u0003\u00012a\u001f@Z\u001d\tIC0\u0003\u0002~I\u00059\u0001/Y2lC\u001e,\u0017B\u0001*\u0000\u0015\tiH\u0005C\u0004\u0002\u0004Q\u0001\r!!\u0002\u0002\u000bML'0Z:\u0011\t%\n9aP\u0005\u0004\u0003\u0013!#A\u0003\u001fsKB,\u0017\r^3e}\u0005)1\u000f\u001d7jiV\u0011\u0011q\u0002\t\u0006\u0003#\t\u0019\"W\u0007\u0002E%\u0011!KI\u0001\f!\u0006\u0014\u0018\n^3sCR|'\u000f\u0005\u0002k/M\u0011q\u0003\u000b\u000b\u0003\u0003/\t1\u0004\n7fgNLg.\u001b;%OJ,\u0017\r^3sI\u0011,g-Y;mi\u0012\nTCAA\u0011U\ry\u00141E\u0016\u0003\u0003K\u0001B!a\n\u000225\u0011\u0011\u0011\u0006\u0006\u0005\u0003W\ti#A\u0005v]\u000eDWmY6fI*\u0019\u0011q\u0006\u0013\u0002\u0015\u0005tgn\u001c;bi&|g.\u0003\u0003\u00024\u0005%\"!E;oG\",7m[3e-\u0006\u0014\u0018.\u00198dK\u0006YB\u0005\\3tg&t\u0017\u000e\u001e\u0013he\u0016\fG/\u001a:%I\u00164\u0017-\u001e7uII\n1\u0004\n7fgNLg.\u001b;%OJ,\u0017\r^3sI\u0011,g-Y;mi\u0012\u001aTCAA\u001eU\r\u0001\u00141E\u0001\tgBd\u0017\u000e\u001e;fe\u0002")
public class Repetition<T>
implements scala.collection.parallel.immutable.ParSeq<T> {
    private volatile Repetition$ParIterator$ ParIterator$module;
    public final T scala$collection$parallel$immutable$Repetition$$elem;
    private final int length;
    private volatile transient TaskSupport scala$collection$parallel$ParIterableLike$$_tasksupport;
    private volatile ParIterableLike$ScanNode$ ScanNode$module;
    private volatile ParIterableLike$ScanLeaf$ ScanLeaf$module;

    @Override
    public GenericCompanion<scala.collection.parallel.immutable.ParSeq> companion() {
        return scala.collection.parallel.immutable.ParSeq.companion$(this);
    }

    @Override
    public scala.collection.parallel.immutable.ParSeq<T> toSeq() {
        return scala.collection.parallel.immutable.ParSeq.toSeq$(this);
    }

    @Override
    public ParIterable<T> toIterable() {
        return ParIterable.toIterable$(this);
    }

    @Override
    public String toString() {
        return ParSeq.toString$(this);
    }

    @Override
    public String stringPrefix() {
        return ParSeq.stringPrefix$(this);
    }

    @Override
    public /* synthetic */ Object scala$collection$parallel$ParSeqLike$$super$zip(GenIterable that, CanBuildFrom bf) {
        return ParIterableLike.zip$(this, that, bf);
    }

    @Override
    public PreciseSplitter<T> iterator() {
        return ParSeqLike.iterator$(this);
    }

    @Override
    public int size() {
        return ParSeqLike.size$(this);
    }

    @Override
    public int segmentLength(Function1<T, Object> p, int from) {
        return ParSeqLike.segmentLength$(this, p, from);
    }

    @Override
    public int indexWhere(Function1<T, Object> p, int from) {
        return ParSeqLike.indexWhere$(this, p, from);
    }

    @Override
    public int lastIndexWhere(Function1<T, Object> p, int end) {
        return ParSeqLike.lastIndexWhere$(this, p, end);
    }

    @Override
    public ParSeq reverse() {
        return ParSeqLike.reverse$(this);
    }

    @Override
    public <S, That> That reverseMap(Function1<T, S> f, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<T>, S, That> bf) {
        return (That)ParSeqLike.reverseMap$(this, f, bf);
    }

    @Override
    public <S> boolean startsWith(GenSeq<S> that, int offset) {
        return ParSeqLike.startsWith$(this, that, offset);
    }

    @Override
    public <U> boolean sameElements(GenIterable<U> that) {
        return ParSeqLike.sameElements$(this, that);
    }

    @Override
    public <S> boolean endsWith(GenSeq<S> that) {
        return ParSeqLike.endsWith$(this, that);
    }

    @Override
    public <U, That> That patch(int from, GenSeq<U> patch, int replaced, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<T>, U, That> bf) {
        return (That)ParSeqLike.patch$(this, from, patch, replaced, bf);
    }

    @Override
    public <U, That> That updated(int index, U elem, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<T>, U, That> bf) {
        return (That)ParSeqLike.updated$(this, index, elem, bf);
    }

    @Override
    public <U, That> That $plus$colon(U elem, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<T>, U, That> bf) {
        return (That)ParSeqLike.$plus$colon$(this, elem, bf);
    }

    @Override
    public <U, That> That $colon$plus(U elem, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<T>, U, That> bf) {
        return (That)ParSeqLike.$colon$plus$(this, elem, bf);
    }

    @Override
    public <U, That> That padTo(int len, U elem, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<T>, U, That> bf) {
        return (That)ParSeqLike.padTo$(this, len, elem, bf);
    }

    @Override
    public <U, S, That> That zip(GenIterable<S> that, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<T>, Tuple2<U, S>, That> bf) {
        return (That)ParSeqLike.zip$(this, that, bf);
    }

    @Override
    public <S> boolean corresponds(GenSeq<S> that, Function2<T, S, Object> p) {
        return ParSeqLike.corresponds$(this, that, p);
    }

    @Override
    public ParSeq diff(GenSeq that) {
        return ParSeqLike.diff$(this, that);
    }

    @Override
    public ParSeq intersect(GenSeq that) {
        return ParSeqLike.intersect$(this, that);
    }

    @Override
    public ParSeq distinct() {
        return ParSeqLike.distinct$(this);
    }

    @Override
    public SeqView<T, scala.collection.immutable.Seq<T>> view() {
        return ParSeqLike.view$(this);
    }

    @Override
    public SeqSplitter<T> down(IterableSplitter<?> p) {
        return ParSeqLike.down$(this, p);
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
    public <S, That> CanBuildFrom<scala.collection.immutable.Seq<T>, S, That> bf2seq(CanBuildFrom<scala.collection.parallel.immutable.ParSeq<T>, S, That> bf) {
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
    public <S, That> That map(Function1<T, S> f, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<T>, S, That> bf) {
        return (That)ParIterableLike.map$(this, f, bf);
    }

    @Override
    public <S, That> That collect(PartialFunction<T, S> pf, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<T>, S, That> bf) {
        return (That)ParIterableLike.collect$(this, pf, bf);
    }

    @Override
    public <S, That> That flatMap(Function1<T, GenTraversableOnce<S>> f, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<T>, S, That> bf) {
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
    public CombinerFactory<T, scala.collection.parallel.immutable.ParSeq<T>> combinerFactory() {
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
    public <U, That> That $plus$plus(GenTraversableOnce<U> that, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<T>, U, That> bf) {
        return (That)ParIterableLike.$plus$plus$(this, that, bf);
    }

    @Override
    public Tuple2<scala.collection.parallel.immutable.ParSeq<T>, scala.collection.parallel.immutable.ParSeq<T>> partition(Function1<T, Object> pred) {
        return ParIterableLike.partition$(this, pred);
    }

    @Override
    public <K> ParMap<K, scala.collection.parallel.immutable.ParSeq<T>> groupBy(Function1<T, K> f) {
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
    public Tuple2<scala.collection.parallel.immutable.ParSeq<T>, scala.collection.parallel.immutable.ParSeq<T>> splitAt(int n) {
        return ParIterableLike.splitAt$(this, n);
    }

    @Override
    public <U, That> That scan(U z, Function2<U, U, U> op, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<T>, U, That> bf) {
        return (That)ParIterableLike.scan$(this, z, op, bf);
    }

    @Override
    public <S, That> That scanLeft(S z, Function2<S, T, S> op, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<T>, S, That> bf) {
        return (That)ParIterableLike.scanLeft$(this, z, op, bf);
    }

    @Override
    public <S, That> That scanRight(S z, Function2<T, S, S> op, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<T>, S, That> bf) {
        return (That)ParIterableLike.scanRight$(this, z, op, bf);
    }

    @Override
    public scala.collection.parallel.ParIterable takeWhile(Function1 pred) {
        return ParIterableLike.takeWhile$(this, pred);
    }

    @Override
    public Tuple2<scala.collection.parallel.immutable.ParSeq<T>, scala.collection.parallel.immutable.ParSeq<T>> span(Function1<T, Object> pred) {
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
    public <U, That> That zipWithIndex(CanBuildFrom<scala.collection.parallel.immutable.ParSeq<T>, Tuple2<U, Object>, That> bf) {
        return (That)ParIterableLike.zipWithIndex$(this, bf);
    }

    @Override
    public <S, U, That> That zipAll(GenIterable<S> that, U thisElem, S thatElem, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<T>, Tuple2<U, S>, That> bf) {
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
    public <U> ParSet<U> toSet() {
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
    public String debugInformation() {
        return ParIterableLike.debugInformation$(this);
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
    public Combiner<T, scala.collection.parallel.immutable.ParSeq<T>> parCombiner() {
        return CustomParallelizable.parCombiner$(this);
    }

    @Override
    public Builder<T, scala.collection.parallel.immutable.ParSeq<T>> newBuilder() {
        return GenericParTemplate.newBuilder$(this);
    }

    @Override
    public Combiner<T, scala.collection.parallel.immutable.ParSeq<T>> newCombiner() {
        return GenericParTemplate.newCombiner$(this);
    }

    @Override
    public <B> Combiner<B, scala.collection.parallel.immutable.ParSeq<B>> genericBuilder() {
        return GenericParTemplate.genericBuilder$(this);
    }

    @Override
    public <B> Combiner<B, scala.collection.parallel.immutable.ParSeq<B>> genericCombiner() {
        return GenericParTemplate.genericCombiner$(this);
    }

    @Override
    public <A1, A2> Tuple2<scala.collection.parallel.immutable.ParSeq<A1>, scala.collection.parallel.immutable.ParSeq<A2>> unzip(Function1<T, Tuple2<A1, A2>> asPair) {
        return GenericTraversableTemplate.unzip$(this, asPair);
    }

    @Override
    public <A1, A2, A3> Tuple3<scala.collection.parallel.immutable.ParSeq<A1>, scala.collection.parallel.immutable.ParSeq<A2>, scala.collection.parallel.immutable.ParSeq<A3>> unzip3(Function1<T, Tuple3<A1, A2, A3>> asTriple) {
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
    public boolean isDefinedAt(int idx) {
        return GenSeqLike.isDefinedAt$(this, idx);
    }

    @Override
    public int prefixLength(Function1<T, Object> p) {
        return GenSeqLike.prefixLength$(this, p);
    }

    @Override
    public int indexWhere(Function1<T, Object> p) {
        return GenSeqLike.indexWhere$(this, p);
    }

    @Override
    public <B> int indexOf(B elem) {
        return GenSeqLike.indexOf$(this, elem);
    }

    @Override
    public <B> int indexOf(B elem, int from) {
        return GenSeqLike.indexOf$(this, elem, from);
    }

    @Override
    public <B> int lastIndexOf(B elem) {
        return GenSeqLike.lastIndexOf$(this, elem);
    }

    @Override
    public <B> int lastIndexOf(B elem, int end) {
        return GenSeqLike.lastIndexOf$(this, elem, end);
    }

    @Override
    public int lastIndexWhere(Function1<T, Object> p) {
        return GenSeqLike.lastIndexWhere$(this, p);
    }

    @Override
    public <B> boolean startsWith(GenSeq<B> that) {
        return GenSeqLike.startsWith$(this, that);
    }

    @Override
    public <B, That> That union(GenSeq<B> that, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<T>, B, That> bf) {
        return (That)GenSeqLike.union$(this, that, bf);
    }

    @Override
    public int hashCode() {
        return GenSeqLike.hashCode$(this);
    }

    @Override
    public boolean equals(Object that) {
        return GenSeqLike.equals$(this, that);
    }

    @Override
    public int sizeHintIfCheap() {
        return GenTraversableOnce.sizeHintIfCheap$(this);
    }

    public Repetition$ParIterator$ ParIterator() {
        if (this.ParIterator$module == null) {
            this.ParIterator$lzycompute$1();
        }
        return this.ParIterator$module;
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

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public T apply(int idx) {
        if (0 <= idx && idx < this.length()) {
            return this.scala$collection$parallel$immutable$Repetition$$elem;
        }
        throw new IndexOutOfBoundsException(String.valueOf(BoxesRunTime.boxToInteger(idx)));
    }

    @Override
    public scala.collection.immutable.Seq<T> seq() {
        return new scala.collection.immutable.Seq<T>(this){
            private final /* synthetic */ Repetition $outer;

            public GenericCompanion<scala.collection.immutable.Seq> companion() {
                return scala.collection.immutable.Seq.companion$(this);
            }

            public scala.collection.immutable.Seq<T> toSeq() {
                return scala.collection.immutable.Seq.toSeq$(this);
            }

            public scala.collection.immutable.Seq<T> seq() {
                return scala.collection.immutable.Seq.seq$(this);
            }

            public Combiner<T, scala.collection.parallel.immutable.ParSeq<T>> parCombiner() {
                return scala.collection.immutable.Seq.parCombiner$(this);
            }

            public int length() {
                return this.$outer.length();
            }

            public T apply(int idx) {
                return this.$outer.apply(idx);
            }

            /*
             * WARNING - void declaration
             */
            public Iterator<T> iterator() {
                void continually_elem;
                Function0<Object> & java.io.Serializable & Serializable intersect = (Function0<Object> & java.io.Serializable & Serializable)() -> $this.$outer.scala$collection$parallel$immutable$Repetition$$elem;
                if (package$.MODULE$.Iterator() == null) {
                    throw null;
                }
                return new AbstractIterator<A>((Function0)continually_elem){
                    private final Function0 elem$3;

                    public boolean hasNext() {
                        return true;
                    }

                    public A next() {
                        return (A)this.elem$3.apply();
                    }
                    {
                        this.elem$3 = elem$3;
                    }
                }.take(this.length());
            }

            public scala.collection.parallel.immutable.ParSeq<T> par() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                scala.collection.immutable.Traversable.$init$(this);
                scala.collection.immutable.Iterable.$init$(this);
                scala.collection.immutable.Seq.$init$(this);
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$iterator$1(scala.collection.parallel.immutable.Repetition$$anon$1 ), $anonfun$groupBy$1(scala.collection.TraversableLike scala.Function1 scala.collection.mutable.Map java.lang.Object ), $anonfun$groupBy$3$adapted(scala.Tuple2 ), $anonfun$groupBy$4(scala.collection.mutable.Builder scala.Tuple2 )}, serializedLambda);
            }
        };
    }

    public Nothing$ update(int idx, T elem) {
        throw new UnsupportedOperationException();
    }

    public ParIterator splitter() {
        return new ParIterator(this, this.ParIterator().$lessinit$greater$default$1(), this.ParIterator().$lessinit$greater$default$2(), this.ParIterator().$lessinit$greater$default$3());
    }

    private final void ParIterator$lzycompute$1() {
        synchronized (this) {
            if (this.ParIterator$module == null) {
                this.ParIterator$module = new Repetition$ParIterator$(this);
            }
            return;
        }
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

    public Repetition(T elem, int length) {
        this.scala$collection$parallel$immutable$Repetition$$elem = elem;
        this.length = length;
        GenTraversableOnce.$init$(this);
        Parallelizable.$init$(this);
        GenSeqLike.$init$(this);
        GenericTraversableTemplate.$init$(this);
        GenTraversable.$init$(this);
        GenIterable.$init$(this);
        GenSeq.$init$(this);
        GenericParTemplate.$init$(this);
        CustomParallelizable.$init$(this);
        ParIterableLike.$init$(this);
        scala.collection.parallel.ParIterable.$init$(this);
        ParSeqLike.$init$(this);
        ParSeq.$init$(this);
        ParIterable.$init$(this);
        scala.collection.parallel.immutable.ParSeq.$init$(this);
    }

    public class ParIterator
    implements SeqSplitter<T> {
        private int i;
        private final int until;
        private final T elem;
        private Signalling signalDelegate;
        public final /* synthetic */ Repetition $outer;

        @Override
        public Seq<SeqSplitter<T>> splitWithSignalling() {
            return SeqSplitter.splitWithSignalling$(this);
        }

        @Override
        public Seq<SeqSplitter<T>> psplitWithSignalling(Seq<Object> sizes) {
            return SeqSplitter.psplitWithSignalling$(this, sizes);
        }

        @Override
        public SeqSplitter.Taken newTaken(int until) {
            return SeqSplitter.newTaken$(this, until);
        }

        @Override
        public SeqSplitter<T> take(int n) {
            return SeqSplitter.take$(this, n);
        }

        @Override
        public SeqSplitter<T> slice(int from1, int until1) {
            return SeqSplitter.slice$(this, from1, until1);
        }

        @Override
        public <S> SeqSplitter.Mapped<S> map(Function1<T, S> f) {
            return SeqSplitter.map$(this, f);
        }

        @Override
        public <U, PI extends SeqSplitter<U>> SeqSplitter.Appended<U, PI> appendParSeq(PI that) {
            return SeqSplitter.appendParSeq$(this, that);
        }

        @Override
        public <S> SeqSplitter.Zipped<S> zipParSeq(SeqSplitter<S> that) {
            return SeqSplitter.zipParSeq$(this, that);
        }

        @Override
        public <S, U, R> SeqSplitter.ZippedAll<U, R> zipAllParSeq(SeqSplitter<S> that, U thisElem, R thatElem) {
            return SeqSplitter.zipAllParSeq$(this, that, thisElem, thatElem);
        }

        @Override
        public SeqSplitter<T> reverse() {
            return SeqSplitter.reverse$(this);
        }

        @Override
        public <U> SeqSplitter.Patched<U> patchParSeq(int from, SeqSplitter<U> patchElems, int replaced) {
            return SeqSplitter.patchParSeq$(this, from, patchElems, replaced);
        }

        @Override
        public int prefixLength(Function1<T, Object> pred) {
            return AugmentedSeqIterator.prefixLength$(this, pred);
        }

        @Override
        public int indexWhere(Function1<T, Object> pred) {
            return AugmentedSeqIterator.indexWhere$(this, pred);
        }

        @Override
        public int lastIndexWhere(Function1<T, Object> pred) {
            return AugmentedSeqIterator.lastIndexWhere$(this, pred);
        }

        @Override
        public <S> boolean corresponds(Function2<T, S, Object> corr, Iterator<S> that) {
            return AugmentedSeqIterator.corresponds$(this, corr, that);
        }

        @Override
        public <U, This> Combiner<U, This> reverse2combiner(Combiner<U, This> cb) {
            return AugmentedSeqIterator.reverse2combiner$(this, cb);
        }

        @Override
        public <S, That> Combiner<S, That> reverseMap2combiner(Function1<T, S> f, Combiner<S, That> cb) {
            return AugmentedSeqIterator.reverseMap2combiner$(this, f, cb);
        }

        @Override
        public <U, That> Combiner<U, That> updated2combiner(int index, U elem, Combiner<U, That> cb) {
            return AugmentedSeqIterator.updated2combiner$(this, index, elem, cb);
        }

        @Override
        public <S> boolean shouldSplitFurther(scala.collection.parallel.ParIterable<S> coll, int parallelismLevel) {
            return IterableSplitter.shouldSplitFurther$(this, coll, parallelismLevel);
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
        public <U extends IterableSplitter.Taken> U newSliceInternal(U it, int from1) {
            return (U)IterableSplitter.newSliceInternal$(this, it, from1);
        }

        @Override
        public IterableSplitter<T> drop(int n) {
            return IterableSplitter.drop$(this, n);
        }

        @Override
        public <U, PI extends IterableSplitter<U>> IterableSplitter.Appended<U, PI> appendParIterable(PI that) {
            return IterableSplitter.appendParIterable$(this, that);
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

        public int i() {
            return this.i;
        }

        public void i_$eq(int x$1) {
            this.i = x$1;
        }

        public int until() {
            return this.until;
        }

        @Override
        public int remaining() {
            return this.until() - this.i();
        }

        @Override
        public boolean hasNext() {
            return this.i() < this.until();
        }

        @Override
        public T next() {
            this.i_$eq(this.i() + 1);
            return this.elem;
        }

        public ParIterator dup() {
            return new ParIterator(this.scala$collection$parallel$immutable$Repetition$ParIterator$$$outer(), this.i(), this.until(), this.elem);
        }

        @Override
        public Seq<SeqSplitter<T>> psplit(Seq<Object> sizes) {
            Seq incr = sizes.scanLeft(BoxesRunTime.boxToInteger(0), (JFunction2$mcIII$sp & Serializable)(x$1, x$2) -> x$1 + x$2, Seq$.MODULE$.canBuildFrom());
            return ((TraversableLike)((IterableLike)incr.init()).zip((GenIterable)incr.tail(), Seq$.MODULE$.canBuildFrom())).withFilter((Function1<Tuple2, Object> & java.io.Serializable & Serializable)(A check$ifrefutable$1) -> BoxesRunTime.boxToBoolean(bl = check$ifrefutable$1 != null)).map((Function1<Tuple2, ParIterator> & java.io.Serializable & Serializable)x$3 -> {
                int n;
                int start;
                if (x$3 != null) {
                    start = x$3._1$mcI$sp();
                    int end = x$3._2$mcI$sp();
                    n = this.i() + end;
                    if (Predef$.MODULE$ == null) {
                        throw null;
                    }
                } else {
                    throw new MatchError((Object)null);
                }
                ParIterator parIterator = new ParIterator(this.scala$collection$parallel$immutable$Repetition$ParIterator$$$outer(), this.i() + start, RichInt$.MODULE$.min$extension(n, this.until()), $this.elem);
                return parIterator;
            }, Seq$.MODULE$.canBuildFrom());
        }

        @Override
        public Seq<SeqSplitter<T>> split() {
            return this.psplit(Predef$.MODULE$.wrapIntArray(new int[]{this.remaining() / 2, this.remaining() - this.remaining() / 2}));
        }

        public /* synthetic */ Repetition scala$collection$parallel$immutable$Repetition$ParIterator$$$outer() {
            return this.$outer;
        }

        public ParIterator(Repetition $outer, int i, int until, T elem) {
            this.i = i;
            this.until = until;
            this.elem = elem;
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
            AugmentedSeqIterator.$init$(this);
            SeqSplitter.$init$(this);
        }
    }
}

