/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.immutable;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.BufferedIterator;
import scala.collection.CustomParallelizable;
import scala.collection.GenIterable;
import scala.collection.GenSeq;
import scala.collection.GenSeqLike;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.Iterator$;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.SeqView;
import scala.collection.Traversable;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.DelegatedSignalling;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericParTemplate;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.generic.Signalling;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Range;
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
import scala.collection.parallel.immutable.ParRange$ParRangeIterator$;
import scala.collection.parallel.immutable.ParSet;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.ObjectRef;

@ScalaSignature(bytes="\u0006\u0001\u0005\u0015h\u0001B\u0013'\u0001=B\u0001B\u0010\u0001\u0003\u0006\u0004%\ta\u0010\u0005\t\u000b\u0002\u0011\t\u0011)A\u0005\u0001\")a\t\u0001C\u0001\u000f\")!\n\u0001C!\u007f!)1\n\u0001C\u0003\u0019\")\u0011\u000b\u0001C\u0003%\")a\u000b\u0001C\u0001/\u001a!!\f\u0001\u0001\\\u0011!q\u0004B!A!\u0002\u0013\u0001\u0005\"\u0002$\t\t\u0003\u0001\u0007\"\u00022\t\t\u0003\u001a\u0007b\u00027\t\u0001\u0004%I\u0001\u0014\u0005\b[\"\u0001\r\u0011\"\u0003o\u0011\u0019!\b\u0002)Q\u0005q!9Q\u000f\u0003b\u0001\n\u0013a\u0005B\u0002<\tA\u0003%\u0001\bC\u0003x\u0011\u0011\u0015A\nC\u0003y\u0011\u0011\u0015\u0011\u0010C\u0003~\u0011\u0011\u0015a\u0010C\u0003\u0000\u0011\u0011%q\b\u0003\u0004\u0002\u0002!!\ta\u0016\u0005\b\u0003\u0007AA\u0011AA\u0003\u0011\u001d\t)\u0002\u0003C\u0001\u0003/Aq!a\t\t\t\u0003\n)\u0003C\u0004\u0002J!!\t%a\u0013\t\u000f\u0005}\u0003\u0002\"\u0011\u0002b\u001dI\u0011q\u0010\u0001\u0002\u0002#\u0005\u0011\u0011\u0011\u0004\t5\u0002\t\t\u0011#\u0001\u0002\u0004\"1a\t\bC\u0001\u0003\u000bC\u0011\"a\"\u001d#\u0003%\t!!#\t\r\t\u0004A\u0011IAP\u000f\u001d\t\tM\nE\u0001\u0003\u00074a!\n\u0014\t\u0002\u0005\u0015\u0007B\u0002$\"\t\u0003\t9\r\u0003\u0004RC\u0011\u0005\u0011\u0011\u001a\u0005\n\u00037\f\u0013\u0011!C\u0005\u0003;\u0014\u0001\u0002U1s%\u0006tw-\u001a\u0006\u0003O!\n\u0011\"[7nkR\f'\r\\3\u000b\u0005%R\u0013\u0001\u00039be\u0006dG.\u001a7\u000b\u0005-b\u0013AC2pY2,7\r^5p]*\tQ&A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\t\u0001\u0001Dg\u000f\t\u0003cIj\u0011\u0001L\u0005\u0003g1\u0012a!\u00118z%\u00164\u0007cA\u001b7q5\ta%\u0003\u00028M\t1\u0001+\u0019:TKF\u0004\"!M\u001d\n\u0005ib#aA%oiB\u0011\u0011\u0007P\u0005\u0003{1\u0012AbU3sS\u0006d\u0017N_1cY\u0016\fQA]1oO\u0016,\u0012\u0001\u0011\t\u0003\u0003\u000ek\u0011A\u0011\u0006\u0003O)J!\u0001\u0012\"\u0003\u000bI\u000bgnZ3\u0002\rI\fgnZ3!\u0003\u0019a\u0014N\\5u}Q\u0011\u0001*\u0013\t\u0003k\u0001AQAP\u0002A\u0002\u0001\u000b1a]3r\u0003\u0019aWM\\4uQV\t\u0001\b\u000b\u0002\u0006\u001dB\u0011\u0011gT\u0005\u0003!2\u0012a!\u001b8mS:,\u0017!B1qa2LHC\u0001\u001dT\u0011\u0015!f\u00011\u00019\u0003\rIG\r\u001f\u0015\u0003\r9\u000b\u0001b\u001d9mSR$XM]\u000b\u00021B\u0011\u0011\fC\u0007\u0002\u0001\t\u0001\u0002+\u0019:SC:<W-\u0013;fe\u0006$xN]\n\u0004\u0011Ab\u0006cA/_q5\t\u0001&\u0003\u0002`Q\tY1+Z9Ta2LG\u000f^3s)\tA\u0016\rC\u0004?\u0015A\u0005\t\u0019\u0001!\u0002\u0011Q|7\u000b\u001e:j]\u001e$\u0012\u0001\u001a\t\u0003K*l\u0011A\u001a\u0006\u0003O\"\fA\u0001\\1oO*\t\u0011.\u0001\u0003kCZ\f\u0017BA6g\u0005\u0019\u0019FO]5oO\u0006\u0019\u0011N\u001c3\u0002\u000f%tGm\u0018\u0013fcR\u0011qN\u001d\t\u0003cAL!!\u001d\u0017\u0003\tUs\u0017\u000e\u001e\u0005\bg6\t\t\u00111\u00019\u0003\rAH%M\u0001\u0005S:$\u0007%A\u0002mK:\fA\u0001\\3oA\u0005I!/Z7bS:LgnZ\u0001\bQ\u0006\u001ch*\u001a=u+\u0005Q\bCA\u0019|\u0013\taHFA\u0004C_>dW-\u00198\u0002\t9,\u0007\u0010\u001e\u000b\u0002q\u0005I!/\u00198hK2,g\r^\u0001\u0004IV\u0004\u0018!B:qY&$XCAA\u0004!\u0015\tI!a\u0004]\u001d\r\t\u00141B\u0005\u0004\u0003\u001ba\u0013a\u00029bG.\fw-Z\u0005\u0005\u0003#\t\u0019BA\u0002TKFT1!!\u0004-\u0003\u0019\u00018\u000f\u001d7jiR!\u0011qAA\r\u0011\u001d\tYb\u0006a\u0001\u0003;\tQa]5{KN\u0004B!MA\u0010q%\u0019\u0011\u0011\u0005\u0017\u0003\u0015q\u0012X\r]3bi\u0016$g(A\u0004g_J,\u0017m\u00195\u0016\t\u0005\u001d\u0012q\u0007\u000b\u0004_\u0006%\u0002bBA\u00161\u0001\u0007\u0011QF\u0001\u0002MB1\u0011'a\f9\u0003gI1!!\r-\u0005%1UO\\2uS>t\u0017\u0007\u0005\u0003\u00026\u0005]B\u0002\u0001\u0003\b\u0003sA\"\u0019AA\u001e\u0005\u0005)\u0016\u0003BA\u001f\u0003\u0007\u00022!MA \u0013\r\t\t\u0005\f\u0002\b\u001d>$\b.\u001b8h!\r\t\u0014QI\u0005\u0004\u0003\u000fb#aA!os\u00061!/\u001a3vG\u0016,B!!\u0014\u0002RQ!\u0011qJA+!\u0011\t)$!\u0015\u0005\u000f\u0005e\u0012D1\u0001\u0002TE\u0019\u0001(a\u0011\t\u000f\u0005]\u0013\u00041\u0001\u0002Z\u0005\u0011q\u000e\u001d\t\nc\u0005m\u0013qJA(\u0003\u001fJ1!!\u0018-\u0005%1UO\\2uS>t''\u0001\u0007nCB\u00144m\\7cS:,'/\u0006\u0004\u0002d\u00055\u00141\u000f\u000b\u0007\u0003K\n9(a\u001f\u0011\u000fu\u000b9'a\u001b\u0002r%\u0019\u0011\u0011\u000e\u0015\u0003\u0011\r{WNY5oKJ\u0004B!!\u000e\u0002n\u00119\u0011q\u000e\u000eC\u0002\u0005m\"!A*\u0011\t\u0005U\u00121\u000f\u0003\b\u0003kR\"\u0019AA\u001e\u0005\u0011!\u0006.\u0019;\t\u000f\u0005-\"\u00041\u0001\u0002zA1\u0011'a\f9\u0003WBq!! \u001b\u0001\u0004\t)'\u0001\u0002dE\u0006\u0001\u0002+\u0019:SC:<W-\u0013;fe\u0006$xN\u001d\t\u00033r\u0019\"\u0001\b\u0019\u0015\u0005\u0005\u0005\u0015a\u0007\u0013mKN\u001c\u0018N\\5uI\u001d\u0014X-\u0019;fe\u0012\"WMZ1vYR$\u0013'\u0006\u0002\u0002\f*\u001a\u0001)!$,\u0005\u0005=\u0005\u0003BAI\u00037k!!a%\u000b\t\u0005U\u0015qS\u0001\nk:\u001c\u0007.Z2lK\u0012T1!!'-\u0003)\tgN\\8uCRLwN\\\u0005\u0005\u0003;\u000b\u0019JA\tv]\u000eDWmY6fIZ\u000b'/[1oG\u0016$\"!!)\u0011\t\u0005\r\u0016\u0011\u0017\b\u0005\u0003K\u000bi\u000bE\u0002\u0002(2j!!!+\u000b\u0007\u0005-f&\u0001\u0004=e>|GOP\u0005\u0004\u0003_c\u0013A\u0002)sK\u0012,g-C\u0002l\u0003gS1!a,-Q\u001d\u0001\u0011qWA_\u0003\u007f\u00032!MA]\u0013\r\tY\f\f\u0002\u0011'\u0016\u0014\u0018.\u00197WKJ\u001c\u0018n\u001c8V\u0013\u0012\u000bQA^1mk\u0016t\u0012!A\u0001\t!\u0006\u0014(+\u00198hKB\u0011Q'I\n\u0004CAZDCAAb)%A\u00151ZAh\u0003'\f9\u000e\u0003\u0004\u0002N\u000e\u0002\r\u0001O\u0001\u0006gR\f'\u000f\u001e\u0005\u0007\u0003#\u001c\u0003\u0019\u0001\u001d\u0002\u0007\u0015tG\r\u0003\u0004\u0002V\u000e\u0002\r\u0001O\u0001\u0005gR,\u0007\u000f\u0003\u0004\u0002Z\u000e\u0002\rA_\u0001\nS:\u001cG.^:jm\u0016\f1B]3bIJ+7o\u001c7wKR\u0011\u0011q\u001c\t\u0004K\u0006\u0005\u0018bAArM\n1qJ\u00196fGR\u0004")
public class ParRange
implements scala.collection.parallel.immutable.ParSeq<Object>,
Serializable {
    public static final long serialVersionUID = 1L;
    private volatile ParRange$ParRangeIterator$ ParRangeIterator$module;
    private final Range range;
    private volatile transient TaskSupport scala$collection$parallel$ParIterableLike$$_tasksupport;
    private volatile ParIterableLike$ScanNode$ ScanNode$module;
    private volatile ParIterableLike$ScanLeaf$ ScanLeaf$module;

    @Override
    public GenericCompanion<scala.collection.parallel.immutable.ParSeq> companion() {
        return scala.collection.parallel.immutable.ParSeq.companion$(this);
    }

    @Override
    public scala.collection.parallel.immutable.ParSeq<Object> toSeq() {
        return scala.collection.parallel.immutable.ParSeq.toSeq$(this);
    }

    @Override
    public ParIterable<Object> toIterable() {
        return ParIterable.toIterable$(this);
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
    public PreciseSplitter<Object> iterator() {
        return ParSeqLike.iterator$(this);
    }

    @Override
    public int size() {
        return ParSeqLike.size$(this);
    }

    @Override
    public int segmentLength(Function1<Object, Object> p, int from) {
        return ParSeqLike.segmentLength$(this, p, from);
    }

    @Override
    public int indexWhere(Function1<Object, Object> p, int from) {
        return ParSeqLike.indexWhere$(this, p, from);
    }

    @Override
    public int lastIndexWhere(Function1<Object, Object> p, int end) {
        return ParSeqLike.lastIndexWhere$(this, p, end);
    }

    @Override
    public ParSeq reverse() {
        return ParSeqLike.reverse$(this);
    }

    @Override
    public <S, That> That reverseMap(Function1<Object, S> f, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<Object>, S, That> bf) {
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
    public <U, That> That patch(int from, GenSeq<U> patch, int replaced, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<Object>, U, That> bf) {
        return (That)ParSeqLike.patch$(this, from, patch, replaced, bf);
    }

    @Override
    public <U, That> That updated(int index, U elem, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<Object>, U, That> bf) {
        return (That)ParSeqLike.updated$(this, index, elem, bf);
    }

    @Override
    public <U, That> That $plus$colon(U elem, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<Object>, U, That> bf) {
        return (That)ParSeqLike.$plus$colon$(this, elem, bf);
    }

    @Override
    public <U, That> That $colon$plus(U elem, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<Object>, U, That> bf) {
        return (That)ParSeqLike.$colon$plus$(this, elem, bf);
    }

    @Override
    public <U, That> That padTo(int len, U elem, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<Object>, U, That> bf) {
        return (That)ParSeqLike.padTo$(this, len, elem, bf);
    }

    @Override
    public <U, S, That> That zip(GenIterable<S> that, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<Object>, Tuple2<U, S>, That> bf) {
        return (That)ParSeqLike.zip$(this, that, bf);
    }

    @Override
    public <S> boolean corresponds(GenSeq<S> that, Function2<Object, S, Object> p) {
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
    public SeqView<Object, scala.collection.immutable.Seq<Object>> view() {
        return ParSeqLike.view$(this);
    }

    @Override
    public SeqSplitter<Object> down(IterableSplitter<?> p) {
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
    public Object head() {
        return ParIterableLike.head$(this);
    }

    @Override
    public Option<Object> headOption() {
        return ParIterableLike.headOption$(this);
    }

    @Override
    public scala.collection.parallel.ParIterable tail() {
        return ParIterableLike.tail$(this);
    }

    @Override
    public Object last() {
        return ParIterableLike.last$(this);
    }

    @Override
    public Option<Object> lastOption() {
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
    public <S, That> CanBuildFrom<scala.collection.immutable.Seq<Object>, S, That> bf2seq(CanBuildFrom<scala.collection.parallel.immutable.ParSeq<Object>, S, That> bf) {
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
    public <S> S aggregate(Function0<S> z, Function2<S, Object, S> seqop, Function2<S, S, S> combop) {
        return (S)ParIterableLike.aggregate$(this, z, seqop, combop);
    }

    @Override
    public <S> S foldLeft(S z, Function2<S, Object, S> op) {
        return (S)ParIterableLike.foldLeft$(this, z, op);
    }

    @Override
    public <S> S foldRight(S z, Function2<Object, S, S> op) {
        return (S)ParIterableLike.foldRight$(this, z, op);
    }

    @Override
    public <U> U reduceLeft(Function2<U, Object, U> op) {
        return (U)ParIterableLike.reduceLeft$(this, op);
    }

    @Override
    public <U> U reduceRight(Function2<Object, U, U> op) {
        return (U)ParIterableLike.reduceRight$(this, op);
    }

    @Override
    public <U> Option<U> reduceLeftOption(Function2<U, Object, U> op) {
        return ParIterableLike.reduceLeftOption$(this, op);
    }

    @Override
    public <U> Option<U> reduceRightOption(Function2<Object, U, U> op) {
        return ParIterableLike.reduceRightOption$(this, op);
    }

    @Override
    public <U> void foreach(Function1<Object, U> f) {
        ParIterableLike.foreach$(this, f);
    }

    @Override
    public int count(Function1<Object, Object> p) {
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
    public Object min(Ordering ord) {
        return ParIterableLike.min$(this, ord);
    }

    @Override
    public Object max(Ordering ord) {
        return ParIterableLike.max$(this, ord);
    }

    @Override
    public Object maxBy(Function1 f, Ordering cmp) {
        return ParIterableLike.maxBy$(this, f, cmp);
    }

    @Override
    public Object minBy(Function1 f, Ordering cmp) {
        return ParIterableLike.minBy$(this, f, cmp);
    }

    @Override
    public <S, That> That map(Function1<Object, S> f, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<Object>, S, That> bf) {
        return (That)ParIterableLike.map$(this, f, bf);
    }

    @Override
    public <S, That> That collect(PartialFunction<Object, S> pf, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<Object>, S, That> bf) {
        return (That)ParIterableLike.collect$(this, pf, bf);
    }

    @Override
    public <S, That> That flatMap(Function1<Object, GenTraversableOnce<S>> f, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<Object>, S, That> bf) {
        return (That)ParIterableLike.flatMap$(this, f, bf);
    }

    @Override
    public boolean forall(Function1<Object, Object> p) {
        return ParIterableLike.forall$(this, p);
    }

    @Override
    public boolean exists(Function1<Object, Object> p) {
        return ParIterableLike.exists$(this, p);
    }

    @Override
    public Option<Object> find(Function1<Object, Object> p) {
        return ParIterableLike.find$(this, p);
    }

    @Override
    public CombinerFactory<Object, scala.collection.parallel.immutable.ParSeq<Object>> combinerFactory() {
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
    public <U, That> That $plus$plus(GenTraversableOnce<U> that, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<Object>, U, That> bf) {
        return (That)ParIterableLike.$plus$plus$(this, that, bf);
    }

    @Override
    public Tuple2<scala.collection.parallel.immutable.ParSeq<Object>, scala.collection.parallel.immutable.ParSeq<Object>> partition(Function1<Object, Object> pred) {
        return ParIterableLike.partition$(this, pred);
    }

    @Override
    public <K> ParMap<K, scala.collection.parallel.immutable.ParSeq<Object>> groupBy(Function1<Object, K> f) {
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
    public Tuple2<scala.collection.parallel.immutable.ParSeq<Object>, scala.collection.parallel.immutable.ParSeq<Object>> splitAt(int n) {
        return ParIterableLike.splitAt$(this, n);
    }

    @Override
    public <U, That> That scan(U z, Function2<U, U, U> op, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<Object>, U, That> bf) {
        return (That)ParIterableLike.scan$(this, z, op, bf);
    }

    @Override
    public <S, That> That scanLeft(S z, Function2<S, Object, S> op, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<Object>, S, That> bf) {
        return (That)ParIterableLike.scanLeft$(this, z, op, bf);
    }

    @Override
    public <S, That> That scanRight(S z, Function2<Object, S, S> op, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<Object>, S, That> bf) {
        return (That)ParIterableLike.scanRight$(this, z, op, bf);
    }

    @Override
    public scala.collection.parallel.ParIterable takeWhile(Function1 pred) {
        return ParIterableLike.takeWhile$(this, pred);
    }

    @Override
    public Tuple2<scala.collection.parallel.immutable.ParSeq<Object>, scala.collection.parallel.immutable.ParSeq<Object>> span(Function1<Object, Object> pred) {
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
    public <U, That> That zipWithIndex(CanBuildFrom<scala.collection.parallel.immutable.ParSeq<Object>, Tuple2<U, Object>, That> bf) {
        return (That)ParIterableLike.zipWithIndex$(this, bf);
    }

    @Override
    public <S, U, That> That zipAll(GenIterable<S> that, U thisElem, S thatElem, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<Object>, Tuple2<U, S>, That> bf) {
        return (That)ParIterableLike.zipAll$(this, that, thisElem, thatElem, bf);
    }

    @Override
    public <U, That> That toParCollection(Function0<Combiner<U, That>> cbf) {
        return (That)ParIterableLike.toParCollection$(this, cbf);
    }

    @Override
    public <K, V, That> That toParMap(Function0<Combiner<Tuple2<K, V>, That>> cbf, Predef$.less.colon.less<Object, Tuple2<K, V>> ev) {
        return (That)ParIterableLike.toParMap$(this, cbf, ev);
    }

    @Override
    public <U> Object toArray(ClassTag<U> evidence$1) {
        return ParIterableLike.toArray$(this, evidence$1);
    }

    @Override
    public List<Object> toList() {
        return ParIterableLike.toList$(this);
    }

    @Override
    public IndexedSeq<Object> toIndexedSeq() {
        return ParIterableLike.toIndexedSeq$(this);
    }

    @Override
    public Stream<Object> toStream() {
        return ParIterableLike.toStream$(this);
    }

    @Override
    public Iterator<Object> toIterator() {
        return ParIterableLike.toIterator$(this);
    }

    @Override
    public <U> Buffer<U> toBuffer() {
        return ParIterableLike.toBuffer$(this);
    }

    @Override
    public GenTraversable<Object> toTraversable() {
        return ParIterableLike.toTraversable$(this);
    }

    @Override
    public <U> ParSet<U> toSet() {
        return ParIterableLike.toSet$(this);
    }

    @Override
    public <K, V> ParMap<K, V> toMap(Predef$.less.colon.less<Object, Tuple2<K, V>> ev) {
        return ParIterableLike.toMap$(this, ev);
    }

    @Override
    public Vector<Object> toVector() {
        return ParIterableLike.toVector$(this);
    }

    @Override
    public <Col> Col to(CanBuildFrom<Nothing$, Object, Col> cbf) {
        return (Col)ParIterableLike.to$(this, cbf);
    }

    @Override
    public int scanBlockSize() {
        return ParIterableLike.scanBlockSize$(this);
    }

    @Override
    public <S> S $div$colon(S z, Function2<S, Object, S> op) {
        return (S)ParIterableLike.$div$colon$(this, z, op);
    }

    @Override
    public <S> S $colon$bslash(S z, Function2<Object, S, S> op) {
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
    public Combiner<Object, scala.collection.parallel.immutable.ParSeq<Object>> parCombiner() {
        return CustomParallelizable.parCombiner$(this);
    }

    @Override
    public Builder<Object, scala.collection.parallel.immutable.ParSeq<Object>> newBuilder() {
        return GenericParTemplate.newBuilder$(this);
    }

    @Override
    public Combiner<Object, scala.collection.parallel.immutable.ParSeq<Object>> newCombiner() {
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
    public <A1, A2> Tuple2<scala.collection.parallel.immutable.ParSeq<A1>, scala.collection.parallel.immutable.ParSeq<A2>> unzip(Function1<Object, Tuple2<A1, A2>> asPair) {
        return GenericTraversableTemplate.unzip$(this, asPair);
    }

    @Override
    public <A1, A2, A3> Tuple3<scala.collection.parallel.immutable.ParSeq<A1>, scala.collection.parallel.immutable.ParSeq<A2>, scala.collection.parallel.immutable.ParSeq<A3>> unzip3(Function1<Object, Tuple3<A1, A2, A3>> asTriple) {
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
    public int prefixLength(Function1<Object, Object> p) {
        return GenSeqLike.prefixLength$(this, p);
    }

    @Override
    public int indexWhere(Function1<Object, Object> p) {
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
    public int lastIndexWhere(Function1<Object, Object> p) {
        return GenSeqLike.lastIndexWhere$(this, p);
    }

    @Override
    public <B> boolean startsWith(GenSeq<B> that) {
        return GenSeqLike.startsWith$(this, that);
    }

    @Override
    public <B, That> That union(GenSeq<B> that, CanBuildFrom<scala.collection.parallel.immutable.ParSeq<Object>, B, That> bf) {
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

    public ParRange$ParRangeIterator$ ParRangeIterator() {
        if (this.ParRangeIterator$module == null) {
            this.ParRangeIterator$lzycompute$1();
        }
        return this.ParRangeIterator$module;
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

    public Range range() {
        return this.range;
    }

    @Override
    public Range seq() {
        return this.range();
    }

    @Override
    public final int length() {
        return this.range().length();
    }

    @Override
    public final int apply(int idx) {
        return this.range().apply$mcII$sp(idx);
    }

    public ParRangeIterator splitter() {
        return new ParRangeIterator(this, this.ParRangeIterator().$lessinit$greater$default$1());
    }

    @Override
    public String toString() {
        return new java.lang.StringBuilder(3).append("Par").append(this.range()).toString();
    }

    private final void ParRangeIterator$lzycompute$1() {
        synchronized (this) {
            if (this.ParRangeIterator$module == null) {
                this.ParRangeIterator$module = new ParRange$ParRangeIterator$(this);
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

    public ParRange(Range range) {
        this.range = range;
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

    public class ParRangeIterator
    implements SeqSplitter<Object> {
        private final Range range;
        private int ind;
        private final int len;
        private Signalling signalDelegate;
        public final /* synthetic */ ParRange $outer;

        @Override
        public Seq<SeqSplitter<Object>> splitWithSignalling() {
            return SeqSplitter.splitWithSignalling$(this);
        }

        @Override
        public Seq<SeqSplitter<Object>> psplitWithSignalling(Seq<Object> sizes) {
            return SeqSplitter.psplitWithSignalling$(this, sizes);
        }

        @Override
        public SeqSplitter.Taken newTaken(int until) {
            return SeqSplitter.newTaken$(this, until);
        }

        @Override
        public SeqSplitter<Object> take(int n) {
            return SeqSplitter.take$(this, n);
        }

        @Override
        public SeqSplitter<Object> slice(int from1, int until1) {
            return SeqSplitter.slice$(this, from1, until1);
        }

        @Override
        public <S> SeqSplitter.Mapped<S> map(Function1<Object, S> f) {
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
        public SeqSplitter<Object> reverse() {
            return SeqSplitter.reverse$(this);
        }

        @Override
        public <U> SeqSplitter.Patched<U> patchParSeq(int from, SeqSplitter<U> patchElems, int replaced) {
            return SeqSplitter.patchParSeq$(this, from, patchElems, replaced);
        }

        @Override
        public int prefixLength(Function1<Object, Object> pred) {
            return AugmentedSeqIterator.prefixLength$(this, pred);
        }

        @Override
        public int indexWhere(Function1<Object, Object> pred) {
            return AugmentedSeqIterator.indexWhere$(this, pred);
        }

        @Override
        public int lastIndexWhere(Function1<Object, Object> pred) {
            return AugmentedSeqIterator.lastIndexWhere$(this, pred);
        }

        @Override
        public <S> boolean corresponds(Function2<Object, S, Object> corr, Iterator<S> that) {
            return AugmentedSeqIterator.corresponds$(this, corr, that);
        }

        @Override
        public <U, This> Combiner<U, This> reverse2combiner(Combiner<U, This> cb) {
            return AugmentedSeqIterator.reverse2combiner$(this, cb);
        }

        @Override
        public <S, That> Combiner<S, That> reverseMap2combiner(Function1<Object, S> f, Combiner<S, That> cb) {
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
        public IterableSplitter<Object> drop(int n) {
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
        public int count(Function1<Object, Object> p) {
            return AugmentedIterableIterator.count$(this, p);
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
        public <S, That> Combiner<S, That> collect2combiner(PartialFunction<Object, S> pf, Combiner<S, That> cb) {
            return AugmentedIterableIterator.collect2combiner$(this, pf, cb);
        }

        @Override
        public <S, That> Combiner<S, That> flatmap2combiner(Function1<Object, GenTraversableOnce<S>> f, Combiner<S, That> cb) {
            return AugmentedIterableIterator.flatmap2combiner$(this, f, cb);
        }

        @Override
        public <U, Coll, Bld extends Builder<U, Coll>> Bld copy2builder(Bld b) {
            return (Bld)AugmentedIterableIterator.copy2builder$(this, b);
        }

        @Override
        public <U, This> Combiner<U, This> filter2combiner(Function1<Object, Object> pred, Combiner<U, This> cb) {
            return AugmentedIterableIterator.filter2combiner$(this, pred, cb);
        }

        @Override
        public <U, This> Combiner<U, This> filterNot2combiner(Function1<Object, Object> pred, Combiner<U, This> cb) {
            return AugmentedIterableIterator.filterNot2combiner$(this, pred, cb);
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> partition2combiners(Function1<Object, Object> pred, Combiner<U, This> btrue, Combiner<U, This> bfalse) {
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
        public <U, This> Tuple2<Combiner<U, This>, Object> takeWhile2combiner(Function1<Object, Object> p, Combiner<U, This> cb) {
            return AugmentedIterableIterator.takeWhile2combiner$(this, p, cb);
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> span2combiners(Function1<Object, Object> p, Combiner<U, This> before, Combiner<U, This> after) {
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
        public Iterator<Object> seq() {
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
        public Iterator<Object> sliceIterator(int from, int until) {
            return Iterator.sliceIterator$(this, from, until);
        }

        @Override
        public <B> Iterator<B> $plus$plus(Function0<GenTraversableOnce<B>> that) {
            return Iterator.$plus$plus$(this, that);
        }

        @Override
        public <B> Iterator<B> flatMap(Function1<Object, GenTraversableOnce<B>> f) {
            return Iterator.flatMap$(this, f);
        }

        @Override
        public Iterator<Object> filter(Function1<Object, Object> p) {
            return Iterator.filter$(this, p);
        }

        @Override
        public <B> boolean corresponds(GenTraversableOnce<B> that, Function2<Object, B, Object> p) {
            return Iterator.corresponds$(this, that, p);
        }

        @Override
        public Iterator<Object> withFilter(Function1<Object, Object> p) {
            return Iterator.withFilter$(this, p);
        }

        @Override
        public Iterator<Object> filterNot(Function1<Object, Object> p) {
            return Iterator.filterNot$(this, p);
        }

        @Override
        public <B> Iterator<B> collect(PartialFunction<Object, B> pf) {
            return Iterator.collect$(this, pf);
        }

        @Override
        public <B> Iterator<B> scanLeft(B z, Function2<B, Object, B> op) {
            return Iterator.scanLeft$(this, z, op);
        }

        @Override
        public <B> Iterator<B> scanRight(B z, Function2<Object, B, B> op) {
            return Iterator.scanRight$(this, z, op);
        }

        @Override
        public Iterator<Object> takeWhile(Function1<Object, Object> p) {
            return Iterator.takeWhile$(this, p);
        }

        @Override
        public Tuple2<Iterator<Object>, Iterator<Object>> partition(Function1<Object, Object> p) {
            return Iterator.partition$(this, p);
        }

        @Override
        public Tuple2<Iterator<Object>, Iterator<Object>> span(Function1<Object, Object> p) {
            return Iterator.span$(this, p);
        }

        @Override
        public Iterator<Object> dropWhile(Function1<Object, Object> p) {
            return Iterator.dropWhile$(this, p);
        }

        @Override
        public <B> Iterator<Tuple2<Object, B>> zip(Iterator<B> that) {
            return Iterator.zip$(this, that);
        }

        @Override
        public <A1> Iterator<A1> padTo(int len, A1 elem) {
            return Iterator.padTo$(this, len, elem);
        }

        @Override
        public Iterator<Tuple2<Object, Object>> zipWithIndex() {
            return Iterator.zipWithIndex$(this);
        }

        @Override
        public <B, A1, B1> Iterator<Tuple2<A1, B1>> zipAll(Iterator<B> that, A1 thisElem, B1 thatElem) {
            return Iterator.zipAll$(this, that, thisElem, thatElem);
        }

        @Override
        public boolean forall(Function1<Object, Object> p) {
            return Iterator.forall$(this, p);
        }

        @Override
        public boolean exists(Function1<Object, Object> p) {
            return Iterator.exists$(this, p);
        }

        @Override
        public boolean contains(Object elem) {
            return Iterator.contains$(this, elem);
        }

        @Override
        public Option<Object> find(Function1<Object, Object> p) {
            return Iterator.find$(this, p);
        }

        @Override
        public int indexWhere(Function1<Object, Object> p, int from) {
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
        public BufferedIterator<Object> buffered() {
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
        public Tuple2<Iterator<Object>, Iterator<Object>> duplicate() {
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
        public Traversable<Object> toTraversable() {
            return Iterator.toTraversable$(this);
        }

        @Override
        public Iterator<Object> toIterator() {
            return Iterator.toIterator$(this);
        }

        @Override
        public Stream<Object> toStream() {
            return Iterator.toStream$(this);
        }

        @Override
        public List<Object> reversed() {
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
        public <B> Option<B> collectFirst(PartialFunction<Object, B> pf) {
            return TraversableOnce.collectFirst$(this, pf);
        }

        @Override
        public <B> B $div$colon(B z, Function2<B, Object, B> op) {
            return (B)TraversableOnce.$div$colon$(this, z, op);
        }

        @Override
        public <B> B $colon$bslash(B z, Function2<Object, B, B> op) {
            return (B)TraversableOnce.$colon$bslash$(this, z, op);
        }

        @Override
        public <B> B foldLeft(B z, Function2<B, Object, B> op) {
            return (B)TraversableOnce.foldLeft$(this, z, op);
        }

        @Override
        public <B> B foldRight(B z, Function2<Object, B, B> op) {
            return (B)TraversableOnce.foldRight$(this, z, op);
        }

        @Override
        public <B> B reduceLeft(Function2<B, Object, B> op) {
            return (B)TraversableOnce.reduceLeft$(this, op);
        }

        @Override
        public <B> B reduceRight(Function2<Object, B, B> op) {
            return (B)TraversableOnce.reduceRight$(this, op);
        }

        @Override
        public <B> Option<B> reduceLeftOption(Function2<B, Object, B> op) {
            return TraversableOnce.reduceLeftOption$(this, op);
        }

        @Override
        public <B> Option<B> reduceRightOption(Function2<Object, B, B> op) {
            return TraversableOnce.reduceRightOption$(this, op);
        }

        @Override
        public <A1> Option<A1> reduceOption(Function2<A1, A1, A1> op) {
            return TraversableOnce.reduceOption$(this, op);
        }

        @Override
        public <B> B aggregate(Function0<B> z, Function2<B, Object, B> seqop, Function2<B, B, B> combop) {
            return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
        }

        @Override
        public Object maxBy(Function1 f, Ordering cmp) {
            return TraversableOnce.maxBy$(this, f, cmp);
        }

        @Override
        public Object minBy(Function1 f, Ordering cmp) {
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
        public List<Object> toList() {
            return TraversableOnce.toList$(this);
        }

        @Override
        public Iterable<Object> toIterable() {
            return TraversableOnce.toIterable$(this);
        }

        @Override
        public Seq<Object> toSeq() {
            return TraversableOnce.toSeq$(this);
        }

        @Override
        public IndexedSeq<Object> toIndexedSeq() {
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
        public Vector<Object> toVector() {
            return TraversableOnce.toVector$(this);
        }

        @Override
        public <Col> Col to(CanBuildFrom<Nothing$, Object, Col> cbf) {
            return (Col)TraversableOnce.to$(this, cbf);
        }

        @Override
        public <T, U> Map<T, U> toMap(Predef$.less.colon.less<Object, Tuple2<T, U>> ev) {
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

        @Override
        public String toString() {
            return new java.lang.StringBuilder(24).append("ParRangeIterator(over: ").append(this.range).append(")").toString();
        }

        private int ind() {
            return this.ind;
        }

        private void ind_$eq(int x$1) {
            this.ind = x$1;
        }

        private int len() {
            return this.len;
        }

        @Override
        public final int remaining() {
            return this.len() - this.ind();
        }

        @Override
        public final boolean hasNext() {
            return this.ind() < this.len();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final int next() {
            if (this.hasNext()) {
                void var1_1;
                int r = this.range.apply$mcII$sp(this.ind());
                this.ind_$eq(this.ind() + 1);
                return (int)var1_1;
            }
            return BoxesRunTime.unboxToInt(Iterator$.MODULE$.empty().next());
        }

        private Range rangeleft() {
            return this.range.drop(this.ind());
        }

        public ParRangeIterator dup() {
            return new ParRangeIterator(this.scala$collection$parallel$immutable$ParRange$ParRangeIterator$$$outer(), this.rangeleft());
        }

        @Override
        public Seq<SeqSplitter<Object>> split() {
            Range rleft = this.rangeleft();
            int elemleft = rleft.length();
            if (elemleft < 2) {
                return new $colon$colon<Nothing$>((Nothing$)((Object)new ParRangeIterator(this.scala$collection$parallel$immutable$ParRange$ParRangeIterator$$$outer(), rleft)), Nil$.MODULE$);
            }
            return new $colon$colon<Nothing$>((Nothing$)((Object)new ParRangeIterator(this.scala$collection$parallel$immutable$ParRange$ParRangeIterator$$$outer(), rleft.take(elemleft / 2))), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)new ParRangeIterator(this.scala$collection$parallel$immutable$ParRange$ParRangeIterator$$$outer(), rleft.drop(elemleft / 2))), Nil$.MODULE$));
        }

        @Override
        public Seq<SeqSplitter<Object>> psplit(Seq<Object> sizes) {
            ObjectRef<Range> rleft = ObjectRef.create(this.rangeleft());
            return sizes.map((Function1<Object, ParRangeIterator> & java.io.Serializable & Serializable)sz -> ParRangeIterator.$anonfun$psplit$1(this, rleft, BoxesRunTime.unboxToInt(sz)), Seq$.MODULE$.canBuildFrom());
        }

        @Override
        public <U> void foreach(Function1<Object, U> f) {
            Range range = this.rangeleft();
            if (range == null) {
                throw null;
            }
            Range foreach$mVc$sp_this = range;
            if (!foreach$mVc$sp_this.isEmpty()) {
                int foreach$mVc$sp_i = foreach$mVc$sp_this.start();
                while (true) {
                    f.apply$mcVI$sp(foreach$mVc$sp_i);
                    if (foreach$mVc$sp_i == foreach$mVc$sp_this.scala$collection$immutable$Range$$lastElement()) break;
                    foreach$mVc$sp_i += foreach$mVc$sp_this.step();
                }
            }
            this.ind_$eq(this.len());
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public <U> U reduce(Function2<U, U, U> op) {
            void var2_2;
            U r = this.rangeleft().reduceLeft(op);
            this.ind_$eq(this.len());
            return var2_2;
        }

        @Override
        public <S, That> Combiner<S, That> map2combiner(Function1<Object, S> f, Combiner<S, That> cb) {
            while (this.hasNext()) {
                cb.$plus$eq(f.apply(BoxesRunTime.boxToInteger(this.next())));
            }
            return cb;
        }

        public /* synthetic */ ParRange scala$collection$parallel$immutable$ParRange$ParRangeIterator$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ ParRangeIterator $anonfun$psplit$1(ParRangeIterator $this, ObjectRef rleft$1, int sz) {
            Range fronttaken = ((Range)rleft$1.elem).take(sz);
            rleft$1.elem = ((Range)rleft$1.elem).drop(sz);
            return new ParRangeIterator($this.scala$collection$parallel$immutable$ParRange$ParRangeIterator$$$outer(), fronttaken);
        }

        public ParRangeIterator(ParRange $outer, Range range) {
            this.range = range;
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
            this.ind = 0;
            this.len = range.length();
        }
    }
}

