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
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.CustomParallelizable;
import scala.collection.GenIterable;
import scala.collection.GenMap;
import scala.collection.GenMapLike;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.IterableView;
import scala.collection.Iterator;
import scala.collection.Map;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.CanCombineFrom;
import scala.collection.generic.DelegatedSignalling;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericParMapCompanion;
import scala.collection.generic.GenericParMapTemplate;
import scala.collection.generic.GenericParTemplate;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.CombinerFactory;
import scala.collection.parallel.IterableSplitter;
import scala.collection.parallel.ParIterable;
import scala.collection.parallel.ParIterableLike;
import scala.collection.parallel.ParIterableLike$ScanLeaf$;
import scala.collection.parallel.ParIterableLike$ScanNode$;
import scala.collection.parallel.ParMap$;
import scala.collection.parallel.ParMapLike;
import scala.collection.parallel.ParSeq;
import scala.collection.parallel.ParSet;
import scala.collection.parallel.Splitter;
import scala.collection.parallel.TaskSupport;
import scala.collection.parallel.mutable.ParHashMap;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0005MeaB\u000b\u0017!\u0003\r\t!\b\u0005\u0006\u0015\u0002!\ta\u0013\u0005\u0006\u001f\u0002!\t\u0001\u0015\u0005\u0006)\u0002!\t!\u0016\u0005\u0006-\u0002!\te\u0016\u0005\u0006A\u0002!\t%\u0019\u0005\u0006Y\u00021\t!\\\u0004\u0006kZA\tA\u001e\u0004\u0006+YA\ta\u001e\u0005\u0006w\"!\t\u0001 \u0005\u0006)\"!\t! \u0005\b\u0003\u0013AA\u0011AA\u0006\u0011\u001d\t\t\u0003\u0003C\u0002\u0003G1q!!\u0012\t\u0003\u0003\t9\u0005\u0003\u0006\u0002Z5\u0011\t\u0011)A\u0005\u0003\u0017B!\"a\u0017\u000e\u0005\u0003\u0005\u000b\u0011BA/\u0011\u0019YX\u0002\"\u0001\u0002d!9\u00111N\u0007\u0005B\u00055\u0004bBA;\u001b\u0011\u0005\u0011q\u000f\u0005\b\u0003\u0003kA\u0011AAB\u0011\u001d\ti)\u0004C!\u0003\u001f\u0013a\u0001U1s\u001b\u0006\u0004(BA\f\u0019\u0003!\u0001\u0018M]1mY\u0016d'BA\r\u001b\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u00027\u0005)1oY1mC\u000e\u0001Qc\u0001\u0010*gM1\u0001aH\u00126{\r\u0003\"\u0001I\u0011\u000e\u0003iI!A\t\u000e\u0003\r\u0005s\u0017PU3g!\u0011!Se\n\u001a\u000e\u0003aI!A\n\r\u0003\r\u001d+g.T1q!\tA\u0013\u0006\u0004\u0001\u0005\u000b)\u0002!\u0019A\u0016\u0003\u0003-\u000b\"\u0001L\u0018\u0011\u0005\u0001j\u0013B\u0001\u0018\u001b\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"\u0001\t\u0019\n\u0005ER\"aA!osB\u0011\u0001f\r\u0003\u0007i\u0001!)\u0019A\u0016\u0003\u0003Y\u0003RAN\u001d(emj\u0011a\u000e\u0006\u0003qa\tqaZ3oKJL7-\u0003\u0002;o\t)r)\u001a8fe&\u001c\u0007+\u0019:NCB$V-\u001c9mCR,\u0007C\u0001\u001f\u0001\u001b\u00051\u0002c\u0001\u001f?\u0001&\u0011qH\u0006\u0002\f!\u0006\u0014\u0018\n^3sC\ndW\r\u0005\u0003!\u0003\u001e\u0012\u0014B\u0001\"\u001b\u0005\u0019!V\u000f\u001d7feA1A\bR\u00143\r\u001eK!!\u0012\f\u0003\u0015A\u000b'/T1q\u0019&\\W\r\u0005\u0003=\u0001\u001d\u0012\u0004\u0003\u0002\u0013IOIJ!!\u0013\r\u0003\u00075\u000b\u0007/\u0001\u0004%S:LG\u000f\n\u000b\u0002\u0019B\u0011\u0001%T\u0005\u0003\u001dj\u0011A!\u00168ji\u0006aQ.\u00199D_6\u0004\u0018M\\5p]V\t\u0011\u000bE\u00027%nJ!aU\u001c\u0003-\u001d+g.\u001a:jGB\u000b'/T1q\u0007>l\u0007/\u00198j_:\fQ!Z7qif,\u0012AR\u0001\rgR\u0014\u0018N\\4Qe\u00164\u0017\u000e_\u000b\u00021B\u0011\u0011LX\u0007\u00025*\u00111\fX\u0001\u0005Y\u0006twMC\u0001^\u0003\u0011Q\u0017M^1\n\u0005}S&AB*ue&tw-A\u0004va\u0012\fG/\u001a3\u0016\u0005\t,GcA2iUB!A\bA\u0014e!\tAS\rB\u0003g\u000b\t\u0007qMA\u0001V#\t\u0011t\u0006C\u0003j\u000b\u0001\u0007q%A\u0002lKfDQa[\u0003A\u0002\u0011\fQA^1mk\u0016\fQ\u0001\n9mkN,\"A\\9\u0015\u0005=\u0014\b\u0003\u0002\u001f\u0001OA\u0004\"\u0001K9\u0005\u000b\u00194!\u0019A4\t\u000bM4\u0001\u0019\u0001;\u0002\u0005-4\b\u0003\u0002\u0011BOA\fa\u0001U1s\u001b\u0006\u0004\bC\u0001\u001f\t'\tA\u0001\u0010E\u00027snJ!A_\u001c\u0003\u001bA\u000b'/T1q\r\u0006\u001cGo\u001c:z\u0003\u0019a\u0014N\\5u}Q\ta/F\u0003\u007f\u0003\u0007\t9!F\u0001\u0000!\u0019a\u0004!!\u0001\u0002\u0006A\u0019\u0001&a\u0001\u0005\u000b)R!\u0019A\u0016\u0011\u0007!\n9\u0001B\u00035\u0015\t\u00071&A\u0006oK^\u001cu.\u001c2j]\u0016\u0014XCBA\u0007\u00033\ti\"\u0006\u0002\u0002\u0010A9A(!\u0005\u0002\u0016\u0005}\u0011bAA\n-\tA1i\\7cS:,'\u000f\u0005\u0004!\u0003\u0006]\u00111\u0004\t\u0004Q\u0005eA!\u0002\u0016\f\u0005\u0004Y\u0003c\u0001\u0015\u0002\u001e\u0011)Ag\u0003b\u0001WA1A\bAA\f\u00037\tAbY1o\u0005VLG\u000e\u001a$s_6,b!!\n\u0002>\u0005\u0005SCAA\u0014!%1\u0014\u0011FA\u0017\u0003s\t\u0019%C\u0002\u0002,]\u0012abQ1o\u0007>l'-\u001b8f\rJ|W\u000e\u0005\u0003\u00020\u0005ER\"\u0001\u0005\n\t\u0005M\u0012Q\u0007\u0002\u0005\u0007>dG.C\u0002\u00028]\u0012QbR3o\u001b\u0006\u0004h)Y2u_JL\bC\u0002\u0011B\u0003w\ty\u0004E\u0002)\u0003{!QA\u000b\u0007C\u0002-\u00022\u0001KA!\t\u0015!DB1\u0001,!\u0019a\u0004!a\u000f\u0002@\tYq+\u001b;i\t\u00164\u0017-\u001e7u+\u0019\tI%a\u0014\u0002VM!QbHA&!\u0019a\u0004!!\u0014\u0002TA\u0019\u0001&a\u0014\u0005\r\u0005ESB1\u0001,\u0005\u0005\t\u0005c\u0001\u0015\u0002V\u00119\u0011qK\u0007\u0005\u0006\u0004Y#!\u0001\"\u0002\u0015UtG-\u001a:ms&tw-A\u0001e!\u001d\u0001\u0013qLA'\u0003'J1!!\u0019\u001b\u0005%1UO\\2uS>t\u0017\u0007\u0006\u0004\u0002f\u0005\u001d\u0014\u0011\u000e\t\b\u0003_i\u0011QJA*\u0011\u001d\tI\u0006\u0005a\u0001\u0003\u0017Bq!a\u0017\u0011\u0001\u0004\ti&\u0001\u0003tSj,WCAA8!\r\u0001\u0013\u0011O\u0005\u0004\u0003gR\"aA%oi\u0006\u0019q-\u001a;\u0015\t\u0005e\u0014q\u0010\t\u0006A\u0005m\u00141K\u0005\u0004\u0003{R\"AB(qi&|g\u000e\u0003\u0004j%\u0001\u0007\u0011QJ\u0001\tgBd\u0017\u000e\u001e;feV\u0011\u0011Q\u0011\t\u0006y\u0005\u001d\u00151R\u0005\u0004\u0003\u00133\"\u0001E%uKJ\f'\r\\3Ta2LG\u000f^3s!\u0019\u0001\u0013)!\u0014\u0002T\u00059A-\u001a4bk2$H\u0003BA*\u0003#Ca!\u001b\u000bA\u0002\u00055\u0003")
public interface ParMap<K, V>
extends GenMap<K, V>,
GenericParMapTemplate<K, V, ParMap>,
ParIterable<Tuple2<K, V>>,
ParMapLike<K, V, ParMap<K, V>, Map<K, V>> {
    public static <K, V> CanCombineFrom<ParMap<?, ?>, Tuple2<K, V>, ParMap<K, V>> canBuildFrom() {
        return ParMap$.MODULE$.canBuildFrom();
    }

    @Override
    default public GenericParMapCompanion<ParMap> mapCompanion() {
        return ParMap$.MODULE$;
    }

    @Override
    default public ParMap<K, V> empty() {
        return new ParHashMap();
    }

    @Override
    default public String stringPrefix() {
        return "ParMap";
    }

    @Override
    default public <U> ParMap<K, U> updated(K key, U value) {
        return this.$plus(new Tuple2<K, U>(key, value));
    }

    @Override
    public <U> ParMap<K, U> $plus(Tuple2<K, U> var1);

    public static void $init$(ParMap $this) {
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    public static abstract class WithDefault<A, B>
    implements ParMap<A, B> {
        private final ParMap<A, B> underlying;
        private final Function1<A, B> d;
        private volatile transient TaskSupport scala$collection$parallel$ParIterableLike$$_tasksupport;
        private volatile ParIterableLike$ScanNode$ ScanNode$module;
        private volatile ParIterableLike$ScanLeaf$ ScanLeaf$module;

        @Override
        public GenericParMapCompanion<ParMap> mapCompanion() {
            return ((ParMap)this).mapCompanion();
        }

        @Override
        public ParMap<A, B> empty() {
            return ((ParMap)this).empty();
        }

        @Override
        public String stringPrefix() {
            return ((ParMap)this).stringPrefix();
        }

        @Override
        public <U> ParMap<A, U> updated(A key, U value) {
            return ((ParMap)this).updated((K)key, (U)value);
        }

        @Override
        public B apply(A key) {
            return (B)ParMapLike.apply$(this, key);
        }

        @Override
        public <U> U getOrElse(A key, Function0<U> function0) {
            return (U)ParMapLike.getOrElse$(this, key, function0);
        }

        @Override
        public boolean contains(A key) {
            return ParMapLike.contains$(this, key);
        }

        @Override
        public boolean isDefinedAt(A key) {
            return ParMapLike.isDefinedAt$(this, key);
        }

        @Override
        public IterableSplitter<A> keysIterator() {
            return ParMapLike.keysIterator$(this);
        }

        @Override
        public IterableSplitter<B> valuesIterator() {
            return ParMapLike.valuesIterator$(this);
        }

        @Override
        public ParSet<A> keySet() {
            return ParMapLike.keySet$(this);
        }

        @Override
        public ParIterable<A> keys() {
            return ParMapLike.keys$(this);
        }

        @Override
        public ParIterable<B> values() {
            return ParMapLike.values$(this);
        }

        @Override
        public ParMap<A, B> filterKeys(Function1<A, Object> p) {
            return ParMapLike.filterKeys$(this, p);
        }

        @Override
        public <S> ParMap<A, S> mapValues(Function1<B, S> f) {
            return ParMapLike.mapValues$(this, f);
        }

        @Override
        public GenericCompanion<ParIterable> companion() {
            return ParIterable.companion$(this);
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
        public ParIterable repr() {
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
        public Option<Tuple2<A, B>> headOption() {
            return ParIterableLike.headOption$(this);
        }

        @Override
        public ParIterable tail() {
            return ParIterableLike.tail$(this);
        }

        @Override
        public Object last() {
            return ParIterableLike.last$(this);
        }

        @Override
        public Option<Tuple2<A, B>> lastOption() {
            return ParIterableLike.lastOption$(this);
        }

        @Override
        public ParIterable init() {
            return ParIterableLike.init$(this);
        }

        @Override
        public Splitter<Tuple2<A, B>> iterator() {
            return ParIterableLike.iterator$(this);
        }

        @Override
        public ParIterable par() {
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
        public <S, That> CanBuildFrom<Map<A, B>, S, That> bf2seq(CanBuildFrom<ParMap<A, B>, S, That> bf) {
            return ParIterableLike.bf2seq$(this, bf);
        }

        @Override
        public ParIterable sequentially(Function1 b) {
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
        public <S> S aggregate(Function0<S> z, Function2<S, Tuple2<A, B>, S> seqop, Function2<S, S, S> combop) {
            return (S)ParIterableLike.aggregate$(this, z, seqop, combop);
        }

        @Override
        public <S> S foldLeft(S z, Function2<S, Tuple2<A, B>, S> op) {
            return (S)ParIterableLike.foldLeft$(this, z, op);
        }

        @Override
        public <S> S foldRight(S z, Function2<Tuple2<A, B>, S, S> op) {
            return (S)ParIterableLike.foldRight$(this, z, op);
        }

        @Override
        public <U> U reduceLeft(Function2<U, Tuple2<A, B>, U> op) {
            return (U)ParIterableLike.reduceLeft$(this, op);
        }

        @Override
        public <U> U reduceRight(Function2<Tuple2<A, B>, U, U> op) {
            return (U)ParIterableLike.reduceRight$(this, op);
        }

        @Override
        public <U> Option<U> reduceLeftOption(Function2<U, Tuple2<A, B>, U> op) {
            return ParIterableLike.reduceLeftOption$(this, op);
        }

        @Override
        public <U> Option<U> reduceRightOption(Function2<Tuple2<A, B>, U, U> op) {
            return ParIterableLike.reduceRightOption$(this, op);
        }

        @Override
        public <U> void foreach(Function1<Tuple2<A, B>, U> f) {
            ParIterableLike.foreach$(this, f);
        }

        @Override
        public int count(Function1<Tuple2<A, B>, Object> p) {
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
        public <S, That> That map(Function1<Tuple2<A, B>, S> f, CanBuildFrom<ParMap<A, B>, S, That> bf) {
            return (That)ParIterableLike.map$(this, f, bf);
        }

        @Override
        public <S, That> That collect(PartialFunction<Tuple2<A, B>, S> pf, CanBuildFrom<ParMap<A, B>, S, That> bf) {
            return (That)ParIterableLike.collect$(this, pf, bf);
        }

        @Override
        public <S, That> That flatMap(Function1<Tuple2<A, B>, GenTraversableOnce<S>> f, CanBuildFrom<ParMap<A, B>, S, That> bf) {
            return (That)ParIterableLike.flatMap$(this, f, bf);
        }

        @Override
        public boolean forall(Function1<Tuple2<A, B>, Object> p) {
            return ParIterableLike.forall$(this, p);
        }

        @Override
        public boolean exists(Function1<Tuple2<A, B>, Object> p) {
            return ParIterableLike.exists$(this, p);
        }

        @Override
        public Option<Tuple2<A, B>> find(Function1<Tuple2<A, B>, Object> p) {
            return ParIterableLike.find$(this, p);
        }

        @Override
        public CombinerFactory<Tuple2<A, B>, ParMap<A, B>> combinerFactory() {
            return ParIterableLike.combinerFactory$(this);
        }

        @Override
        public <S, That> CombinerFactory<S, That> combinerFactory(Function0<Combiner<S, That>> cbf) {
            return ParIterableLike.combinerFactory$(this, cbf);
        }

        @Override
        public ParIterable withFilter(Function1 pred) {
            return ParIterableLike.withFilter$(this, pred);
        }

        @Override
        public ParIterable filter(Function1 pred) {
            return ParIterableLike.filter$(this, pred);
        }

        @Override
        public ParIterable filterNot(Function1 pred) {
            return ParIterableLike.filterNot$(this, pred);
        }

        @Override
        public <U, That> That $plus$plus(GenTraversableOnce<U> that, CanBuildFrom<ParMap<A, B>, U, That> bf) {
            return (That)ParIterableLike.$plus$plus$(this, that, bf);
        }

        @Override
        public Tuple2<ParMap<A, B>, ParMap<A, B>> partition(Function1<Tuple2<A, B>, Object> pred) {
            return ParIterableLike.partition$(this, pred);
        }

        @Override
        public <K> scala.collection.parallel.immutable.ParMap<K, ParMap<A, B>> groupBy(Function1<Tuple2<A, B>, K> f) {
            return ParIterableLike.groupBy$(this, f);
        }

        @Override
        public ParIterable take(int n) {
            return ParIterableLike.take$(this, n);
        }

        @Override
        public ParIterable drop(int n) {
            return ParIterableLike.drop$(this, n);
        }

        @Override
        public ParIterable slice(int unc_from, int unc_until) {
            return ParIterableLike.slice$(this, unc_from, unc_until);
        }

        @Override
        public Tuple2<ParMap<A, B>, ParMap<A, B>> splitAt(int n) {
            return ParIterableLike.splitAt$(this, n);
        }

        @Override
        public <U, That> That scan(U z, Function2<U, U, U> op, CanBuildFrom<ParMap<A, B>, U, That> bf) {
            return (That)ParIterableLike.scan$(this, z, op, bf);
        }

        @Override
        public <S, That> That scanLeft(S z, Function2<S, Tuple2<A, B>, S> op, CanBuildFrom<ParMap<A, B>, S, That> bf) {
            return (That)ParIterableLike.scanLeft$(this, z, op, bf);
        }

        @Override
        public <S, That> That scanRight(S z, Function2<Tuple2<A, B>, S, S> op, CanBuildFrom<ParMap<A, B>, S, That> bf) {
            return (That)ParIterableLike.scanRight$(this, z, op, bf);
        }

        @Override
        public ParIterable takeWhile(Function1 pred) {
            return ParIterableLike.takeWhile$(this, pred);
        }

        @Override
        public Tuple2<ParMap<A, B>, ParMap<A, B>> span(Function1<Tuple2<A, B>, Object> pred) {
            return ParIterableLike.span$(this, pred);
        }

        @Override
        public ParIterable dropWhile(Function1 pred) {
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
        public <U, S, That> That zip(GenIterable<S> that, CanBuildFrom<ParMap<A, B>, Tuple2<U, S>, That> bf) {
            return (That)ParIterableLike.zip$(this, that, bf);
        }

        @Override
        public <U, That> That zipWithIndex(CanBuildFrom<ParMap<A, B>, Tuple2<U, Object>, That> bf) {
            return (That)ParIterableLike.zipWithIndex$(this, bf);
        }

        @Override
        public <S, U, That> That zipAll(GenIterable<S> that, U thisElem, S thatElem, CanBuildFrom<ParMap<A, B>, Tuple2<U, S>, That> bf) {
            return (That)ParIterableLike.zipAll$(this, that, thisElem, thatElem, bf);
        }

        @Override
        public <U, That> That toParCollection(Function0<Combiner<U, That>> cbf) {
            return (That)ParIterableLike.toParCollection$(this, cbf);
        }

        @Override
        public <K, V, That> That toParMap(Function0<Combiner<Tuple2<K, V>, That>> cbf, Predef$.less.colon.less<Tuple2<A, B>, Tuple2<K, V>> ev) {
            return (That)ParIterableLike.toParMap$(this, cbf, ev);
        }

        @Override
        public IterableView<Tuple2<A, B>, Map<A, B>> view() {
            return ParIterableLike.view$(this);
        }

        @Override
        public <U> Object toArray(ClassTag<U> evidence$1) {
            return ParIterableLike.toArray$(this, evidence$1);
        }

        @Override
        public List<Tuple2<A, B>> toList() {
            return ParIterableLike.toList$(this);
        }

        @Override
        public IndexedSeq<Tuple2<A, B>> toIndexedSeq() {
            return ParIterableLike.toIndexedSeq$(this);
        }

        @Override
        public Stream<Tuple2<A, B>> toStream() {
            return ParIterableLike.toStream$(this);
        }

        @Override
        public Iterator<Tuple2<A, B>> toIterator() {
            return ParIterableLike.toIterator$(this);
        }

        @Override
        public <U> Buffer<U> toBuffer() {
            return ParIterableLike.toBuffer$(this);
        }

        @Override
        public GenTraversable<Tuple2<A, B>> toTraversable() {
            return ParIterableLike.toTraversable$(this);
        }

        @Override
        public ParIterable<Tuple2<A, B>> toIterable() {
            return ParIterableLike.toIterable$(this);
        }

        @Override
        public ParSeq<Tuple2<A, B>> toSeq() {
            return ParIterableLike.toSeq$(this);
        }

        @Override
        public <U> scala.collection.parallel.immutable.ParSet<U> toSet() {
            return ParIterableLike.toSet$(this);
        }

        @Override
        public <K, V> scala.collection.parallel.immutable.ParMap<K, V> toMap(Predef$.less.colon.less<Tuple2<A, B>, Tuple2<K, V>> ev) {
            return ParIterableLike.toMap$(this, ev);
        }

        @Override
        public Vector<Tuple2<A, B>> toVector() {
            return ParIterableLike.toVector$(this);
        }

        @Override
        public <Col> Col to(CanBuildFrom<Nothing$, Tuple2<A, B>, Col> cbf) {
            return (Col)ParIterableLike.to$(this, cbf);
        }

        @Override
        public int scanBlockSize() {
            return ParIterableLike.scanBlockSize$(this);
        }

        @Override
        public <S> S $div$colon(S z, Function2<S, Tuple2<A, B>, S> op) {
            return (S)ParIterableLike.$div$colon$(this, z, op);
        }

        @Override
        public <S> S $colon$bslash(S z, Function2<Tuple2<A, B>, S, S> op) {
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
        public Combiner<Tuple2<A, B>, ParMap<A, B>> parCombiner() {
            return CustomParallelizable.parCombiner$(this);
        }

        @Override
        public Combiner<Tuple2<A, B>, ParMap<A, B>> newCombiner() {
            return GenericParMapTemplate.newCombiner$(this);
        }

        @Override
        public <P, Q> Combiner<Tuple2<P, Q>, ParMap<P, Q>> genericMapCombiner() {
            return GenericParMapTemplate.genericMapCombiner$(this);
        }

        @Override
        public Builder<Tuple2<A, B>, ParIterable<Tuple2<A, B>>> newBuilder() {
            return GenericParTemplate.newBuilder$(this);
        }

        @Override
        public <B> Combiner<B, ParIterable<B>> genericBuilder() {
            return GenericParTemplate.genericBuilder$(this);
        }

        @Override
        public <B> Combiner<B, ParIterable<B>> genericCombiner() {
            return GenericParTemplate.genericCombiner$(this);
        }

        @Override
        public <A1, A2> Tuple2<ParIterable<A1>, ParIterable<A2>> unzip(Function1<Tuple2<A, B>, Tuple2<A1, A2>> asPair) {
            return GenericTraversableTemplate.unzip$(this, asPair);
        }

        @Override
        public <A1, A2, A3> Tuple3<ParIterable<A1>, ParIterable<A2>, ParIterable<A3>> unzip3(Function1<Tuple2<A, B>, Tuple3<A1, A2, A3>> asTriple) {
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
        public int hashCode() {
            return GenMapLike.hashCode$(this);
        }

        @Override
        public boolean equals(Object that) {
            return GenMapLike.equals$(this, that);
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
        public int size() {
            return this.underlying.size();
        }

        @Override
        public Option<B> get(A key) {
            return this.underlying.get(key);
        }

        @Override
        public IterableSplitter<Tuple2<A, B>> splitter() {
            return this.underlying.splitter();
        }

        @Override
        public B default(A key) {
            return this.d.apply(key);
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

        public WithDefault(ParMap<A, B> underlying, Function1<A, B> d) {
            this.underlying = underlying;
            this.d = d;
            GenTraversableOnce.$init$(this);
            Parallelizable.$init$(this);
            GenMapLike.$init$(this);
            GenericTraversableTemplate.$init$(this);
            GenTraversable.$init$(this);
            GenIterable.$init$(this);
            GenericParTemplate.$init$(this);
            GenericParMapTemplate.$init$(this);
            CustomParallelizable.$init$(this);
            ParIterableLike.$init$(this);
            ParIterable.$init$(this);
            ParMapLike.$init$(this);
            ParMap.$init$(this);
        }
    }
}

