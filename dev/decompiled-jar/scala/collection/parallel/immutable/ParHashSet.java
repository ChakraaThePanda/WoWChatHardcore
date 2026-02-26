/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.immutable;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.BufferedIterator;
import scala.collection.CustomParallelizable;
import scala.collection.GenIterable;
import scala.collection.GenSet;
import scala.collection.GenSetLike;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.IterableView;
import scala.collection.Iterator;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.Traversable;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.CanCombineFrom;
import scala.collection.generic.DelegatedSignalling;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericParTemplate;
import scala.collection.generic.GenericSetTemplate;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.generic.Signalling;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.HashSet;
import scala.collection.immutable.HashSet$;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.immutable.TrieIterator;
import scala.collection.immutable.Vector;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.AugmentedIterableIterator;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.CombinerFactory;
import scala.collection.parallel.IterableSplitter;
import scala.collection.parallel.ParIterableLike;
import scala.collection.parallel.ParIterableLike$ScanLeaf$;
import scala.collection.parallel.ParIterableLike$ScanNode$;
import scala.collection.parallel.ParSet;
import scala.collection.parallel.ParSetLike;
import scala.collection.parallel.RemainsIterator;
import scala.collection.parallel.SeqSplitter;
import scala.collection.parallel.Splitter;
import scala.collection.parallel.TaskSupport;
import scala.collection.parallel.immutable.ParHashSet$;
import scala.collection.parallel.immutable.ParIterable;
import scala.collection.parallel.immutable.ParMap;
import scala.collection.parallel.immutable.ParSeq;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0005=h\u0001\u0002\u0013&\u00019B\u0001b\u0016\u0001\u0003\u0002\u0003\u0006Ia\u0014\u0005\u00071\u0002!\t!J-\t\u000ba\u0003A\u0011A.\t\u000bq\u0003A\u0011I/\t\u000b\u001d\u0004A\u0011\t5\t\u000b%\u0004A\u0011\u00016\t\u000b9\u0004A\u0011I8\t\u000bA\u0004A\u0011A9\t\u000bQ\u0004A\u0011A;\t\u000b]\u0004A\u0011\u0001=\t\u000bu\u0004A\u0011\t@\t\u000f\u0005\u0015\u0001\u0001\"\u0015\u0002\b\u00191\u00111\u0006\u0001\u0001\u0003[A!\"a\f\u000e\u0005\u0003\u0007I\u0011AA\u0019\u0011)\t\t%\u0004BA\u0002\u0013\u0005\u00111\t\u0005\u000b\u0003\u001fj!\u0011!Q!\n\u0005M\u0002\"CA)\u001b\t\u0015\r\u0011\"\u0001\u007f\u0011%\t\u0019&\u0004B\u0001B\u0003%q\u0010\u0003\u0004Y\u001b\u0011\u0005\u0011Q\u000b\u0005\t\u0003?j\u0001\u0019!C\u0001}\"I\u0011\u0011M\u0007A\u0002\u0013\u0005\u00111\r\u0005\b\u0003Oj\u0001\u0015)\u0003\u0000\u0011\u0019\tI'\u0004C\u0001U\"9\u00111N\u0007\u0005\n\u00055\u0004bBA:\u001b\u0011\u0005\u0011Q\u000f\u0005\b\u0003{jA\u0011AA@\u0011\u001d\t\t)\u0004C\u0001\u0003\u0007Ca!!\"\u000e\t\u0003qxaBAJK!\u0005\u0011Q\u0013\u0004\u0007I\u0015B\t!a&\t\rasB\u0011AAP\u0011\u001d\t\tK\bC\u0001\u0003GCq!a,\u001f\t\u0007\t\t\fC\u0004\u0002Jz!\t!a3\t\u0013\u0005mg$!A\u0005\n\u0005u'A\u0003)be\"\u000b7\u000f[*fi*\u0011aeJ\u0001\nS6lW\u000f^1cY\u0016T!\u0001K\u0015\u0002\u0011A\f'/\u00197mK2T!AK\u0016\u0002\u0015\r|G\u000e\\3di&|gNC\u0001-\u0003\u0015\u00198-\u00197b\u0007\u0001)\"a\f\u001e\u0014\r\u0001\u0001Dg\u0011&U!\t\t$'D\u0001,\u0013\t\u00194F\u0001\u0004B]f\u0014VM\u001a\t\u0004kYBT\"A\u0013\n\u0005]*#A\u0002)beN+G\u000f\u0005\u0002:u1\u0001A!B\u001e\u0001\u0005\u0004a$!\u0001+\u0012\u0005u\u0002\u0005CA\u0019?\u0013\ty4FA\u0004O_RD\u0017N\\4\u0011\u0005E\n\u0015B\u0001\",\u0005\r\te.\u001f\t\u0005\t\u001eC\u0014*D\u0001F\u0015\t1\u0015&A\u0004hK:,'/[2\n\u0005!+%AE$f]\u0016\u0014\u0018n\u0019)beR+W\u000e\u001d7bi\u0016\u0004\"!\u000e\u0001\u0011\u000b-c\u0005HT(\u000e\u0003\u001dJ!!T\u0014\u0003\u0015A\u000b'oU3u\u0019&\\W\rE\u00026\u0001a\u00022\u0001\u0015*9\u001b\u0005\t&B\u0001\u0014*\u0013\t\u0019\u0016KA\u0004ICND7+\u001a;\u0011\u0005E*\u0016B\u0001,,\u00051\u0019VM]5bY&T\u0018M\u00197f\u0003\u0011!(/[3\u0002\rqJg.\u001b;?)\tq%\fC\u0003X\u0005\u0001\u0007q\nF\u0001O\u0003%\u0019w.\u001c9b]&|g.F\u0001_%\ry\u0016\r\u001a\u0004\u0005A\u0002\u0001aL\u0001\u0007=e\u00164\u0017N\\3nK:$h\bE\u0002EE&K!aY#\u0003!\u001d+g.\u001a:jG\u000e{W\u000e]1oS>t\u0007c\u0001#f\u0013&\u0011a-\u0012\u0002\u0014\u000f\u0016tWM]5d!\u0006\u00148i\\7qC:LwN\\\u0001\u0006K6\u0004H/_\u000b\u0002\u001d\u0006A1\u000f\u001d7jiR,'/F\u0001l!\rYE\u000eO\u0005\u0003[\u001e\u0012\u0001#\u0013;fe\u0006\u0014G.Z*qY&$H/\u001a:\u0002\u0007M,\u0017/F\u0001P\u0003\u0019!S.\u001b8vgR\u0011aJ\u001d\u0005\u0006g\"\u0001\r\u0001O\u0001\u0002K\u0006)A\u0005\u001d7vgR\u0011aJ\u001e\u0005\u0006g&\u0001\r\u0001O\u0001\tG>tG/Y5ogR\u0011\u0011\u0010 \t\u0003ciL!a_\u0016\u0003\u000f\t{w\u000e\\3b]\")1O\u0003a\u0001q\u0005!1/\u001b>f+\u0005y\bcA\u0019\u0002\u0002%\u0019\u00111A\u0016\u0003\u0007%sG/A\u0003sKV\u001cX-\u0006\u0004\u0002\n\u0005M\u0011\u0011\u0004\u000b\u0007\u0003\u0017\ti\"a\n\u0011\u000f-\u000bi!!\u0005\u0002\u0018%\u0019\u0011qB\u0014\u0003\u0011\r{WNY5oKJ\u00042!OA\n\t\u0019\t)\u0002\u0004b\u0001y\t\t1\u000bE\u0002:\u00033!a!a\u0007\r\u0005\u0004a$\u0001\u0002+iCRDq!a\b\r\u0001\u0004\t\t#\u0001\u0003pY\u0012\u001c\u0007#B\u0019\u0002$\u0005-\u0011bAA\u0013W\t1q\n\u001d;j_:Dq!!\u000b\r\u0001\u0004\tY!\u0001\u0003oK^\u001c'A\u0005)be\"\u000b7\u000f[*fi&#XM]1u_J\u001c2!\u0004\u0019l\u0003\u0019!(/\u001b;feV\u0011\u00111\u0007\t\u0006\u0003k\tY\u0004\u000f\b\u0004c\u0005]\u0012bAA\u001dW\u00059\u0001/Y2lC\u001e,\u0017\u0002BA\u001f\u0003\u007f\u0011\u0001\"\u0013;fe\u0006$xN\u001d\u0006\u0004\u0003sY\u0013A\u0003;sSR,'o\u0018\u0013fcR!\u0011QIA&!\r\t\u0014qI\u0005\u0004\u0003\u0013Z#\u0001B+oSRD\u0011\"!\u0014\u0010\u0003\u0003\u0005\r!a\r\u0002\u0007a$\u0013'A\u0004ue&$XM\u001d\u0011\u0002\u0005MT\u0018aA:{AQ1\u0011qKA.\u0003;\u00022!!\u0017\u000e\u001b\u0005\u0001\u0001bBA\u0018'\u0001\u0007\u00111\u0007\u0005\u0007\u0003#\u001a\u0002\u0019A@\u0002\u0003%\fQ![0%KF$B!!\u0012\u0002f!A\u0011QJ\u000b\u0002\u0002\u0003\u0007q0\u0001\u0002jA\u0005\u0019A-\u001e9\u0002\u001f\u0011,\bO\u0012:p[&#XM]1u_J$B!a\u0016\u0002p!9\u0011\u0011\u000f\rA\u0002\u0005M\u0012AA5u\u0003\u0015\u0019\b\u000f\\5u+\t\t9\bE\u0003\u00026\u0005e4.\u0003\u0003\u0002|\u0005}\"aA*fc\u0006!a.\u001a=u)\u0005A\u0014a\u00025bg:+\u0007\u0010^\u000b\u0002s\u0006I!/Z7bS:Lgn\u001a\u0015\b\u0001\u0005%\u0015qRAI!\r\t\u00141R\u0005\u0004\u0003\u001b[#\u0001E*fe&\fGNV3sg&|g.V%E\u0003\u00151\u0018\r\\;f=\u0005\t\u0011A\u0003)be\"\u000b7\u000f[*fiB\u0011QGH\n\u0005=\u0005eE\u000b\u0005\u0003E\u00037K\u0015bAAO\u000b\ni\u0001+\u0019:TKR4\u0015m\u0019;pef$\"!!&\u0002\u00179,woQ8nE&tWM]\u000b\u0005\u0003K\u000bY+\u0006\u0002\u0002(B91*!\u0004\u0002*\u00065\u0006cA\u001d\u0002,\u0012)1\b\tb\u0001yA!Q\u0007AAU\u00031\u0019\u0017M\u001c\"vS2$gI]8n+\u0011\t\u0019,!2\u0016\u0005\u0005U\u0006#\u0003#\u00028\u0006m\u00161YAd\u0013\r\tI,\u0012\u0002\u000f\u0007\u0006t7i\\7cS:,gI]8n!\u0011\ti,a0\u000e\u0003yI1!!1c\u0005\u0011\u0019u\u000e\u001c7\u0011\u0007e\n)\rB\u0003<C\t\u0007A\b\u0005\u00036\u0001\u0005\r\u0017\u0001\u00034s_6$&/[3\u0016\t\u00055\u00171\u001b\u000b\u0005\u0003\u001f\f)\u000e\u0005\u00036\u0001\u0005E\u0007cA\u001d\u0002T\u0012)1H\tb\u0001y!9\u0011q\u001b\u0012A\u0002\u0005e\u0017!\u0001;\u0011\tA\u0013\u0016\u0011[\u0001\fe\u0016\fGMU3t_24X\r\u0006\u0002\u0002`B!\u0011\u0011]Av\u001b\t\t\u0019O\u0003\u0003\u0002f\u0006\u001d\u0018\u0001\u00027b]\u001eT!!!;\u0002\t)\fg/Y\u0005\u0005\u0003[\f\u0019O\u0001\u0004PE*,7\r\u001e")
public class ParHashSet<T>
implements scala.collection.parallel.immutable.ParSet<T>,
Serializable {
    public static final long serialVersionUID = 1L;
    private final HashSet<T> trie;
    private volatile transient TaskSupport scala$collection$parallel$ParIterableLike$$_tasksupport;
    private volatile ParIterableLike$ScanNode$ ScanNode$module;
    private volatile ParIterableLike$ScanLeaf$ ScanLeaf$module;

    public static <T> ParHashSet<T> fromTrie(HashSet<T> hashSet) {
        return ParHashSet$.MODULE$.fromTrie(hashSet);
    }

    public static <T> CanCombineFrom<ParHashSet<?>, T, ParHashSet<T>> canBuildFrom() {
        return ParHashSet$.MODULE$.canBuildFrom();
    }

    public static <A> CanBuildFrom<ParHashSet<?>, A, ParHashSet<A>> setCanBuildFrom() {
        return ParHashSet$.MODULE$.setCanBuildFrom();
    }

    @Override
    public String stringPrefix() {
        return scala.collection.parallel.immutable.ParSet.stringPrefix$(this);
    }

    @Override
    public <U> scala.collection.parallel.immutable.ParSet<U> toSet() {
        return scala.collection.parallel.immutable.ParSet.toSet$(this);
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
    public ParSet union(GenSet that) {
        return ParSetLike.union$(this, that);
    }

    @Override
    public ParSet diff(GenSet that) {
        return ParSetLike.diff$(this, that);
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
    public Splitter<T> iterator() {
        return ParIterableLike.iterator$(this);
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
    public GenericCompanion<ParHashSet> companion() {
        return ParHashSet$.MODULE$;
    }

    @Override
    public ParHashSet<T> empty() {
        return new ParHashSet<T>();
    }

    @Override
    public IterableSplitter<T> splitter() {
        return new ParHashSetIterator(this, this.trie.iterator(), this.trie.size());
    }

    @Override
    public HashSet<T> seq() {
        return this.trie;
    }

    @Override
    public ParHashSet<T> $minus(T e) {
        return new ParHashSet<T>(this.trie.$minus((Object)e));
    }

    @Override
    public ParHashSet<T> $plus(T e) {
        return new ParHashSet<T>(this.trie.$plus((Object)e));
    }

    @Override
    public boolean contains(T e) {
        return this.trie.contains(e);
    }

    @Override
    public int size() {
        return this.trie.size();
    }

    @Override
    public <S, That> Combiner<S, That> reuse(Option<Combiner<S, That>> oldc, Combiner<S, That> newc) {
        Combiner<S, That> combiner;
        if (oldc instanceof Some) {
            combiner = (Combiner<S, That>)((Some)oldc).value();
        } else if (None$.MODULE$.equals(oldc)) {
            combiner = newc;
        } else {
            throw new MatchError(oldc);
        }
        return combiner;
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

    public ParHashSet(HashSet<T> trie) {
        this.trie = trie;
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
        ParSetLike.$init$(this);
        ParSet.$init$(this);
        ParIterable.$init$(this);
        scala.collection.parallel.immutable.ParSet.$init$(this);
    }

    public ParHashSet() {
        this((HashSet)HashSet$.MODULE$.empty());
    }

    public class ParHashSetIterator
    implements IterableSplitter<T> {
        private Iterator<T> triter;
        private final int sz;
        private int i;
        private Signalling signalDelegate;
        public final /* synthetic */ ParHashSet $outer;

        @Override
        public Seq<IterableSplitter<T>> splitWithSignalling() {
            return IterableSplitter.splitWithSignalling$(this);
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

        public Iterator<T> triter() {
            return this.triter;
        }

        public void triter_$eq(Iterator<T> x$1) {
            this.triter = x$1;
        }

        public int sz() {
            return this.sz;
        }

        public int i() {
            return this.i;
        }

        public void i_$eq(int x$1) {
            this.i = x$1;
        }

        @Override
        public IterableSplitter<T> dup() {
            ParHashSetIterator parHashSetIterator;
            Iterator iterator2 = this.triter();
            if (iterator2 instanceof TrieIterator) {
                TrieIterator trieIterator = (TrieIterator)iterator2;
                parHashSetIterator = this.dupFromIterator(trieIterator.dupIterator());
            } else {
                Buffer buff = this.triter().toBuffer();
                this.triter_$eq(buff.iterator());
                parHashSetIterator = this.dupFromIterator(buff.iterator());
            }
            return parHashSetIterator;
        }

        /*
         * WARNING - void declaration
         */
        private ParHashSetIterator dupFromIterator(Iterator<T> it) {
            void var2_2;
            ParHashSetIterator phit = new ParHashSetIterator(this.scala$collection$parallel$immutable$ParHashSet$ParHashSetIterator$$$outer(), it, this.sz());
            phit.i_$eq(this.i());
            return var2_2;
        }

        @Override
        public Seq<IterableSplitter<T>> split() {
            Seq seq;
            block8: {
                block5: {
                    Iterator iterator2;
                    Tuple2 tuple2;
                    int previousRemaining;
                    block7: {
                        Tuple2 tuple22;
                        block6: {
                            if (this.remaining() < 2) {
                                return new $colon$colon<Nothing$>((Nothing$)((Object)this), Nil$.MODULE$);
                            }
                            Iterator iterator3 = this.triter();
                            if (!(iterator3 instanceof TrieIterator)) break block5;
                            TrieIterator trieIterator = (TrieIterator)iterator3;
                            previousRemaining = this.remaining();
                            tuple22 = trieIterator.split();
                            if (tuple22 == null) break block6;
                            tuple2 = tuple22._1();
                            iterator2 = tuple22._2();
                            if (tuple2 != null) break block7;
                        }
                        throw new MatchError(tuple22);
                    }
                    Iterator iterator4 = tuple2._1();
                    int n = tuple2._2$mcI$sp();
                    int sndlength = previousRemaining - n;
                    seq = new $colon$colon<Nothing$>((Nothing$)((Object)new ParHashSetIterator(this.scala$collection$parallel$immutable$ParHashSet$ParHashSetIterator$$$outer(), iterator4, n)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)new ParHashSetIterator(this.scala$collection$parallel$immutable$ParHashSet$ParHashSetIterator$$$outer(), iterator2, sndlength)), Nil$.MODULE$));
                    break block8;
                }
                Buffer buff = this.triter().toBuffer();
                Tuple2 tuple2 = buff.splitAt(buff.length() / 2);
                if (tuple2 == null) {
                    throw new MatchError((Object)null);
                }
                Buffer buffer = (Buffer)tuple2._1();
                Buffer buffer2 = (Buffer)tuple2._2();
                seq = new $colon$colon<Nothing$>((Nothing$)((Object)buffer), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)buffer2), Nil$.MODULE$)).map((Function1<Buffer, ParHashSetIterator> & java.io.Serializable & Serializable)b -> new ParHashSetIterator(this.scala$collection$parallel$immutable$ParHashSet$ParHashSetIterator$$$outer(), b.iterator(), b.length()), Seq$.MODULE$.canBuildFrom());
            }
            return seq;
        }

        @Override
        public T next() {
            this.i_$eq(this.i() + 1);
            return this.triter().next();
        }

        @Override
        public boolean hasNext() {
            return this.i() < this.sz();
        }

        @Override
        public int remaining() {
            return this.sz() - this.i();
        }

        public /* synthetic */ ParHashSet scala$collection$parallel$immutable$ParHashSet$ParHashSetIterator$$$outer() {
            return this.$outer;
        }

        public ParHashSetIterator(ParHashSet $outer, Iterator<T> triter, int sz) {
            this.triter = triter;
            this.sz = sz;
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
            this.i = 0;
        }
    }
}

