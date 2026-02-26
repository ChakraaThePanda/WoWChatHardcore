/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.immutable;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.Function4;
import scala.Function5;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.CustomParallelizable;
import scala.collection.GenIterable;
import scala.collection.GenSeq;
import scala.collection.GenSeqLike;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterator;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.SeqView;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.CanCombineFrom;
import scala.collection.generic.DelegatedSignalling;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericParTemplate;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.generic.Signalling;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.immutable.Vector$;
import scala.collection.immutable.VectorIterator;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.ArrayBuffer$;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
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
import scala.collection.parallel.immutable.ParVector$;
import scala.math.Integral;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.Nothing$;
import scala.runtime.ObjectRef;
import scala.runtime.java8.JFunction1$mcVI$sp;

@ScalaSignature(bytes="\u0006\u0001\u0005\u0005d\u0001B\r\u001b\u0001\rB\u0001\u0002\u0014\u0001\u0003\u0002\u0003\u0006I\u0001\u0012\u0005\u0006\u001b\u0002!\tA\u0014\u0005\u0006!\u0002!\t%\u0015\u0005\u0007\u001b\u0002!\t!a\u0002\t\u000f\u0005%\u0001\u0001\"\u0001\u0002\f!9\u0011q\u0003\u0001\u0005\u0002\u0005e\u0001bBA\u000e\u0001\u0011\u0005\u0011Q\u0004\u0005\b\u0003K\u0001A\u0011IA\u0014\u0011\u001d\tI\u0003\u0001C!\u0003O1a!a\u000b\u0001\u0001\u00055\u0002BCA\u001b\u0015\t\u0005\t\u0015!\u0003\u0002\u0012!Q\u0011q\u0007\u0006\u0003\u0002\u0003\u0006I!!\u0005\t\r5SA\u0011AA\u001d\u0011\u001d\t\u0019E\u0003C\u0001\u00033Aq!!\u0012\u000b\t\u0003\ti\u0002C\u0004\u0002H)!\t!!\u0013\t\u000f\u0005M#\u0002\"\u0001\u0002V\u001d)1K\u0007E\u0001)\u001a)\u0011D\u0007E\u0001+\")Qj\u0005C\u00013\")!l\u0005C\u00027\")\u0011n\u0005C\u0001U\")!o\u0005C\u0001g\"9\u0011pEA\u0001\n\u0013Q(!\u0003)beZ+7\r^8s\u0015\tYB$A\u0005j[6,H/\u00192mK*\u0011QDH\u0001\ta\u0006\u0014\u0018\r\u001c7fY*\u0011q\u0004I\u0001\u000bG>dG.Z2uS>t'\"A\u0011\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0011AeL\n\u0007\u0001\u0015J\u0003hP%\u0011\u0005\u0019:S\"\u0001\u0011\n\u0005!\u0002#AB!osJ+g\rE\u0002+W5j\u0011AG\u0005\u0003Yi\u0011a\u0001U1s'\u0016\f\bC\u0001\u00180\u0019\u0001!a\u0001\r\u0001\u0005\u0006\u0004\t$!\u0001+\u0012\u0005I*\u0004C\u0001\u00144\u0013\t!\u0004EA\u0004O_RD\u0017N\\4\u0011\u0005\u00192\u0014BA\u001c!\u0005\r\te.\u001f\t\u0005sqjc(D\u0001;\u0015\tYd$A\u0004hK:,'/[2\n\u0005uR$AE$f]\u0016\u0014\u0018n\u0019)beR+W\u000e\u001d7bi\u0016\u0004\"A\u000b\u0001\u0011\u000b\u0001\u000bUf\u0011#\u000e\u0003qI!A\u0011\u000f\u0003\u0015A\u000b'oU3r\u0019&\\W\rE\u0002+\u00015\u00022!R$.\u001b\u00051%BA\u000e\u001f\u0013\tAeI\u0001\u0004WK\u000e$xN\u001d\t\u0003M)K!a\u0013\u0011\u0003\u0019M+'/[1mSj\f'\r\\3\u0002\rY,7\r^8s\u0003\u0019a\u0014N\\5u}Q\u00111i\u0014\u0005\u0006\u0019\n\u0001\r\u0001R\u0001\nG>l\u0007/\u00198j_:,\u0012A\u0015\b\u0003UI\t\u0011\u0002U1s-\u0016\u001cGo\u001c:\u0011\u0005)\u001a2cA\nW\u0013B\u0019\u0011h\u0016 \n\u0005aS$A\u0003)be\u001a\u000b7\r^8ssR\tA+\u0001\u0007dC:\u0014U/\u001b7e\rJ|W.\u0006\u0002]OV\tQ\fE\u0003:=\u00024\u0007.\u0003\u0002`u\tq1)\u00198D_6\u0014\u0017N\\3Ge>l\u0007CA1c\u001b\u0005\u0019\u0012BA2e\u0005\u0011\u0019u\u000e\u001c7\n\u0005\u0015T$\u0001E$f]\u0016\u0014\u0018nY\"p[B\fg.[8o!\tqs\rB\u00031+\t\u0007\u0011\u0007E\u0002+\u0001\u0019\f!B\\3x\u0005VLG\u000eZ3s+\tY\u0007/F\u0001m!\u0011\u0001Un\\9\n\u00059d\"\u0001C\"p[\nLg.\u001a:\u0011\u00059\u0002H!\u0002\u0019\u0017\u0005\u0004\t\u0004c\u0001\u0016\u0001_\u0006Ya.Z<D_6\u0014\u0017N\\3s+\t!x/F\u0001v!\u0011\u0001UN\u001e=\u0011\u00059:H!\u0002\u0019\u0018\u0005\u0004\t\u0004c\u0001\u0016\u0001m\u0006Y!/Z1e%\u0016\u001cx\u000e\u001c<f)\u0005Y\bc\u0001?\u0002\u00045\tQP\u0003\u0002\u007f\u007f\u0006!A.\u00198h\u0015\t\t\t!\u0001\u0003kCZ\f\u0017bAA\u0003{\n1qJ\u00196fGR$\u0012aQ\u0001\u0006CB\u0004H.\u001f\u000b\u0004[\u00055\u0001bBA\b\u000b\u0001\u0007\u0011\u0011C\u0001\u0004S\u0012D\bc\u0001\u0014\u0002\u0014%\u0019\u0011Q\u0003\u0011\u0003\u0007%sG/\u0001\u0004mK:<G\u000f[\u000b\u0003\u0003#\t\u0001b\u001d9mSR$XM]\u000b\u0003\u0003?\u0001B\u0001QA\u0011[%\u0019\u00111\u0005\u000f\u0003\u0017M+\u0017o\u00159mSR$XM]\u0001\u0004g\u0016\fX#\u0001#\u0002\u0011Q|g+Z2u_J\u0014\u0011\u0003U1s-\u0016\u001cGo\u001c:Ji\u0016\u0014\u0018\r^8s'\u0015Q\u0011qFA\u0010!\u0011)\u0015\u0011G\u0017\n\u0007\u0005MbI\u0001\bWK\u000e$xN]%uKJ\fGo\u001c:\u0002\r}\u001bH/\u0019:u\u0003\u0011yVM\u001c3\u0015\r\u0005m\u0012qHA!!\r\tiDC\u0007\u0002\u0001!9\u0011QG\u0007A\u0002\u0005E\u0001bBA\u001c\u001b\u0001\u0007\u0011\u0011C\u0001\ne\u0016l\u0017-\u001b8j]\u001e\f1\u0001Z;q\u0003\u0015\u0019\b\u000f\\5u+\t\tY\u0005\u0005\u0004\u0002N\u0005=\u00131H\u0007\u0002=%\u0019\u0011\u0011\u000b\u0010\u0003\u0007M+\u0017/\u0001\u0004qgBd\u0017\u000e\u001e\u000b\u0005\u0003\u0017\n9\u0006C\u0004\u0002ZE\u0001\r!a\u0017\u0002\u000bML'0Z:\u0011\u000b\u0019\ni&!\u0005\n\u0007\u0005}\u0003E\u0001\u0006=e\u0016\u0004X-\u0019;fIz\u0002")
public class ParVector<T>
implements scala.collection.parallel.immutable.ParSeq<T>,
Serializable {
    private final Vector<T> vector;
    private volatile transient TaskSupport scala$collection$parallel$ParIterableLike$$_tasksupport;
    private volatile ParIterableLike$ScanNode$ ScanNode$module;
    private volatile ParIterableLike$ScanLeaf$ ScanLeaf$module;

    public static <T> CanCombineFrom<ParVector<?>, T, ParVector<T>> canBuildFrom() {
        return ParVector$.MODULE$.canBuildFrom();
    }

    public static GenTraversable iterate(Object object, int n, Function1 function1) {
        ParVector$ parVector$ = ParVector$.MODULE$;
        if (parVector$ == null) {
            throw null;
        }
        Builder iterate_b = ((GenericCompanion)parVector$).newBuilder();
        if (n > 0) {
            iterate_b.sizeHint(n);
            Object iterate_acc = object;
            iterate_b.$plus$eq(object);
            for (int iterate_i = 1; iterate_i < n; ++iterate_i) {
                iterate_acc = function1.apply(iterate_acc);
                iterate_b.$plus$eq(iterate_acc);
            }
        }
        return (GenTraversable)iterate_b.result();
    }

    public static GenTraversable range(Object object, Object object2, Object object3, Integral integral) {
        return ParVector$.MODULE$.range(object, object2, object3, integral);
    }

    public static GenTraversable range(Object object, Object object2, Integral integral) {
        return ParVector$.MODULE$.range(object, object2, integral);
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, int n5, Function5 function5) {
        ParVector$ parVector$ = ParVector$.MODULE$;
        if (parVector$ == null) {
            throw null;
        }
        ParVector$ tabulate_this = parVector$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$7$adapted(tabulate_this, n2, n3, n4, n5, function5, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, Function4 function4) {
        ParVector$ parVector$ = ParVector$.MODULE$;
        if (parVector$ == null) {
            throw null;
        }
        ParVector$ tabulate_this = parVector$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$5$adapted(tabulate_this, n2, n3, n4, function4, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, Function3 function3) {
        ParVector$ parVector$ = ParVector$.MODULE$;
        if (parVector$ == null) {
            throw null;
        }
        ParVector$ tabulate_this = parVector$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$3$adapted(tabulate_this, n2, n3, function3, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, Function2 function2) {
        ParVector$ parVector$ = ParVector$.MODULE$;
        if (parVector$ == null) {
            throw null;
        }
        ParVector$ tabulate_this = parVector$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$1$adapted(tabulate_this, n2, function2, arg_0));
    }

    public static GenTraversable tabulate(int n, Function1 function1) {
        return ParVector$.MODULE$.tabulate(n, function1);
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, int n5, Function0 function0) {
        ParVector$ parVector$ = ParVector$.MODULE$;
        if (parVector$ == null) {
            throw null;
        }
        ParVector$ fill_this = parVector$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$4$adapted(fill_this, n2, n3, n4, n5, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, Function0 function0) {
        ParVector$ parVector$ = ParVector$.MODULE$;
        if (parVector$ == null) {
            throw null;
        }
        ParVector$ fill_this = parVector$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$3$adapted(fill_this, n2, n3, n4, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, Function0 function0) {
        ParVector$ parVector$ = ParVector$.MODULE$;
        if (parVector$ == null) {
            throw null;
        }
        ParVector$ fill_this = parVector$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$2$adapted(fill_this, n2, n3, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, Function0 function0) {
        ParVector$ parVector$ = ParVector$.MODULE$;
        if (parVector$ == null) {
            throw null;
        }
        ParVector$ fill_this = parVector$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$1$adapted(fill_this, n2, function0, arg_0));
    }

    public static GenTraversable fill(int n, Function0 function0) {
        ParVector$ parVector$ = ParVector$.MODULE$;
        if (parVector$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)parVector$).newBuilder();
        fill_b.sizeHint(n);
        for (int fill_i = 0; fill_i < n; ++fill_i) {
            fill_b.$plus$eq(function0.apply());
        }
        return (GenTraversable)fill_b.result();
    }

    public static GenTraversable concat(Seq seq) {
        return ParVector$.MODULE$.concat(seq);
    }

    public static GenTraversableFactory.GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return ParVector$.MODULE$.ReusableCBF();
    }

    public static GenTraversable empty() {
        return ParVector$.MODULE$.empty();
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
    public <S, That> That reverseMap(Function1<T, S> f, CanBuildFrom<ParVector<T>, S, That> bf) {
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
    public <U, That> That patch(int from, GenSeq<U> patch, int replaced, CanBuildFrom<ParVector<T>, U, That> bf) {
        return (That)ParSeqLike.patch$(this, from, patch, replaced, bf);
    }

    @Override
    public <U, That> That updated(int index, U elem, CanBuildFrom<ParVector<T>, U, That> bf) {
        return (That)ParSeqLike.updated$(this, index, elem, bf);
    }

    @Override
    public <U, That> That $plus$colon(U elem, CanBuildFrom<ParVector<T>, U, That> bf) {
        return (That)ParSeqLike.$plus$colon$(this, elem, bf);
    }

    @Override
    public <U, That> That $colon$plus(U elem, CanBuildFrom<ParVector<T>, U, That> bf) {
        return (That)ParSeqLike.$colon$plus$(this, elem, bf);
    }

    @Override
    public <U, That> That padTo(int len, U elem, CanBuildFrom<ParVector<T>, U, That> bf) {
        return (That)ParSeqLike.padTo$(this, len, elem, bf);
    }

    @Override
    public <U, S, That> That zip(GenIterable<S> that, CanBuildFrom<ParVector<T>, Tuple2<U, S>, That> bf) {
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
    public SeqView<T, Vector<T>> view() {
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
    public <S, That> CanBuildFrom<Vector<T>, S, That> bf2seq(CanBuildFrom<ParVector<T>, S, That> bf) {
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
    public <S, That> That map(Function1<T, S> f, CanBuildFrom<ParVector<T>, S, That> bf) {
        return (That)ParIterableLike.map$(this, f, bf);
    }

    @Override
    public <S, That> That collect(PartialFunction<T, S> pf, CanBuildFrom<ParVector<T>, S, That> bf) {
        return (That)ParIterableLike.collect$(this, pf, bf);
    }

    @Override
    public <S, That> That flatMap(Function1<T, GenTraversableOnce<S>> f, CanBuildFrom<ParVector<T>, S, That> bf) {
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
    public CombinerFactory<T, ParVector<T>> combinerFactory() {
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
    public <U, That> That $plus$plus(GenTraversableOnce<U> that, CanBuildFrom<ParVector<T>, U, That> bf) {
        return (That)ParIterableLike.$plus$plus$(this, that, bf);
    }

    @Override
    public Tuple2<ParVector<T>, ParVector<T>> partition(Function1<T, Object> pred) {
        return ParIterableLike.partition$(this, pred);
    }

    @Override
    public <K> ParMap<K, ParVector<T>> groupBy(Function1<T, K> f) {
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
    public Tuple2<ParVector<T>, ParVector<T>> splitAt(int n) {
        return ParIterableLike.splitAt$(this, n);
    }

    @Override
    public <U, That> That scan(U z, Function2<U, U, U> op, CanBuildFrom<ParVector<T>, U, That> bf) {
        return (That)ParIterableLike.scan$(this, z, op, bf);
    }

    @Override
    public <S, That> That scanLeft(S z, Function2<S, T, S> op, CanBuildFrom<ParVector<T>, S, That> bf) {
        return (That)ParIterableLike.scanLeft$(this, z, op, bf);
    }

    @Override
    public <S, That> That scanRight(S z, Function2<T, S, S> op, CanBuildFrom<ParVector<T>, S, That> bf) {
        return (That)ParIterableLike.scanRight$(this, z, op, bf);
    }

    @Override
    public scala.collection.parallel.ParIterable takeWhile(Function1 pred) {
        return ParIterableLike.takeWhile$(this, pred);
    }

    @Override
    public Tuple2<ParVector<T>, ParVector<T>> span(Function1<T, Object> pred) {
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
    public <U, That> That zipWithIndex(CanBuildFrom<ParVector<T>, Tuple2<U, Object>, That> bf) {
        return (That)ParIterableLike.zipWithIndex$(this, bf);
    }

    @Override
    public <S, U, That> That zipAll(GenIterable<S> that, U thisElem, S thatElem, CanBuildFrom<ParVector<T>, Tuple2<U, S>, That> bf) {
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
    public Combiner<T, ParVector<T>> parCombiner() {
        return CustomParallelizable.parCombiner$(this);
    }

    @Override
    public Builder<T, ParVector<T>> newBuilder() {
        return GenericParTemplate.newBuilder$(this);
    }

    @Override
    public Combiner<T, ParVector<T>> newCombiner() {
        return GenericParTemplate.newCombiner$(this);
    }

    @Override
    public <B> Combiner<B, ParVector<B>> genericBuilder() {
        return GenericParTemplate.genericBuilder$(this);
    }

    @Override
    public <B> Combiner<B, ParVector<B>> genericCombiner() {
        return GenericParTemplate.genericCombiner$(this);
    }

    @Override
    public <A1, A2> Tuple2<ParVector<A1>, ParVector<A2>> unzip(Function1<T, Tuple2<A1, A2>> asPair) {
        return GenericTraversableTemplate.unzip$(this, asPair);
    }

    @Override
    public <A1, A2, A3> Tuple3<ParVector<A1>, ParVector<A2>, ParVector<A3>> unzip3(Function1<T, Tuple3<A1, A2, A3>> asTriple) {
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
    public <B, That> That union(GenSeq<B> that, CanBuildFrom<ParVector<T>, B, That> bf) {
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

    public ParVector$ companion() {
        return ParVector$.MODULE$;
    }

    @Override
    public T apply(int idx) {
        return this.vector.apply(idx);
    }

    @Override
    public int length() {
        return this.vector.length();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public SeqSplitter<T> splitter() {
        void var1_1;
        ParVectorIterator pit = new ParVectorIterator(this.vector.startIndex(), this.vector.endIndex());
        this.vector.initIterator(pit);
        return var1_1;
    }

    @Override
    public Vector<T> seq() {
        return this.vector;
    }

    @Override
    public Vector<T> toVector() {
        return this.vector;
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

    public ParVector(Vector<T> vector) {
        this.vector = vector;
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

    public ParVector() {
        this((Vector)Vector$.MODULE$.apply(Nil$.MODULE$));
    }

    public class ParVectorIterator
    extends VectorIterator<T>
    implements SeqSplitter<T> {
        private Signalling signalDelegate;

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
        public Signalling signalDelegate() {
            return this.signalDelegate;
        }

        @Override
        public void signalDelegate_$eq(Signalling x$1) {
            this.signalDelegate = x$1;
        }

        @Override
        public int remaining() {
            return this.remainingElementCount();
        }

        @Override
        public SeqSplitter<T> dup() {
            return new ParVector(this.remainingVector()).splitter();
        }

        @Override
        public Seq<ParVectorIterator> split() {
            int rem = this.remaining();
            if (rem >= 2) {
                return this.psplit(Predef$.MODULE$.wrapIntArray(new int[]{rem / 2, rem - rem / 2}));
            }
            return new $colon$colon<Nothing$>((Nothing$)((Object)this), Nil$.MODULE$);
        }

        @Override
        public Seq<ParVectorIterator> psplit(Seq<Object> sizes) {
            ObjectRef remvector = ObjectRef.create(this.remainingVector());
            ArrayBuffer splitted = new ArrayBuffer();
            sizes.foreach((JFunction1$mcVI$sp & Serializable)sz -> {
                splitted.$plus$eq(((Vector)remvector$1.elem).take(sz));
                remvector$1.elem = ((Vector)remvector$1.elem).drop(sz);
            });
            return splitted.map((Function1<Vector, ParVectorIterator> & java.io.Serializable & Serializable)v -> (ParVectorIterator)new ParVector(v).splitter(), ArrayBuffer$.MODULE$.canBuildFrom());
        }

        public /* synthetic */ ParVector scala$collection$parallel$immutable$ParVector$ParVectorIterator$$$outer() {
            return ParVector.this;
        }

        public ParVectorIterator(int _start, int _end) {
            if (ParVector.this == null) {
                throw null;
            }
            super(_start, _end);
            RemainsIterator.$init$(this);
            AugmentedIterableIterator.$init$(this);
            DelegatedSignalling.$init$(this);
            IterableSplitter.$init$(this);
            AugmentedSeqIterator.$init$(this);
            SeqSplitter.$init$(this);
        }
    }
}

