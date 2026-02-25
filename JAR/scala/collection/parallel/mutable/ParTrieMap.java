/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.mutable;

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
import scala.collection.CustomParallelizable;
import scala.collection.GenIterable;
import scala.collection.GenMapLike;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.IterableView;
import scala.collection.Iterator;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.concurrent.BasicNode;
import scala.collection.concurrent.CNode;
import scala.collection.concurrent.INode;
import scala.collection.concurrent.LNode;
import scala.collection.concurrent.MainNode;
import scala.collection.concurrent.SNode;
import scala.collection.concurrent.TNode;
import scala.collection.concurrent.TrieMap;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.CanCombineFrom;
import scala.collection.generic.DelegatedSignalling;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericParMapCompanion;
import scala.collection.generic.GenericParMapTemplate;
import scala.collection.generic.GenericParTemplate;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.generic.Growable;
import scala.collection.generic.Shrinkable;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.Cloneable;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.CombinerFactory;
import scala.collection.parallel.IterableSplitter;
import scala.collection.parallel.ParIterableLike;
import scala.collection.parallel.ParIterableLike$ScanLeaf$;
import scala.collection.parallel.ParIterableLike$ScanNode$;
import scala.collection.parallel.ParMap;
import scala.collection.parallel.ParSet;
import scala.collection.parallel.Splitter;
import scala.collection.parallel.Task;
import scala.collection.parallel.TaskSupport;
import scala.collection.parallel.mutable.ParIterable;
import scala.collection.parallel.mutable.ParMapLike;
import scala.collection.parallel.mutable.ParSeq;
import scala.collection.parallel.mutable.ParTrieMap$;
import scala.collection.parallel.mutable.ParTrieMapCombiner;
import scala.collection.parallel.mutable.ParTrieMapSplitter;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@ScalaSignature(bytes="\u0006\u0001\t=a\u0001B\u0014)\u0005EB\u0001\u0002\u0019\u0001\u0003\u0006\u0004%I!\u0019\u0005\tE\u0002\u0011\t\u0011)A\u0005)\"11\r\u0001C\u0001Y\u0011DQa\u0019\u0001\u0005\u0002\u0019DQa\u001a\u0001\u0005B!DQ\u0001\u001c\u0001\u0005B5DaA\u001c\u0001!\n#z\u0007\"B<\u0001\t\u0003\n\u0007\"\u0002=\u0001\t\u0003I\b\"B?\u0001\t\u0003r\bBBA\u0003\u0001\u0011\u0005a\rC\u0004\u0002\b\u0001!\t!!\u0003\t\u000f\u0005U\u0001\u0001\"\u0001\u0002\u0018!9\u0011q\u0004\u0001\u0005\u0002\u0005\u0005\u0002bBA\u0014\u0001\u0011\u0005\u0011\u0011\u0006\u0005\b\u0003[\u0001A\u0011AA\u0018\u0011\u001d\t9\u0004\u0001C\u0001\u0003sAq!!\u0010\u0001\t\u0003\ny\u0004C\u0004\u0002H\u0001!\t%!\u0013\u0007\r\u0005m\u0003\u0001AA/\u0011)\t9\u0007\u0006B\u0001B\u0003%\u0011\u0011\t\u0005\u000b\u0003S\"\"\u0011!Q\u0001\n\u0005\u0005\u0003BCA6)\t\u0005\t\u0015!\u0003\u0002n!11\r\u0006C\u0001\u0003sB\u0011\"!\u0002\u0015\u0001\u0004%\t!a\u0010\t\u0013\u0005\u0005E\u00031A\u0005\u0002\u0005\r\u0005\u0002CAE)\u0001\u0006K!!\u0011\t\u000f\u0005-E\u0003\"\u0001\u0002\u000e\"9\u0011Q\u0013\u000b\u0005\u0002\u0005]\u0005bBAQ)\u0011\u0005\u00111\u0015\u0005\b\u0003W#B\u0011IAW\u000f\u001d\t\u0019\f\u000bE\u0001\u0003k3aa\n\u0015\t\u0002\u0005]\u0006BB2\"\t\u0003\ty\f\u0003\u0004mC\u0011\u0005\u0011\u0011\u0019\u0005\u0007]\u0006\"\t!a4\t\u000f\u0005\u0005\u0018\u0005b\u0001\u0002d\"I!QA\u0011\u0002\u0002\u0013%!q\u0001\u0002\u000b!\u0006\u0014HK]5f\u001b\u0006\u0004(BA\u0015+\u0003\u001diW\u000f^1cY\u0016T!a\u000b\u0017\u0002\u0011A\f'/\u00197mK2T!!\f\u0018\u0002\u0015\r|G\u000e\\3di&|gNC\u00010\u0003\u0015\u00198-\u00197b\u0007\u0001)2AM\u001fH'\u001d\u00011gN%Q5v\u0003\"\u0001N\u001b\u000e\u00039J!A\u000e\u0018\u0003\r\u0005s\u0017PU3g!\u0011A\u0014h\u000f$\u000e\u0003!J!A\u000f\u0015\u0003\rA\u000b'/T1q!\taT\b\u0004\u0001\u0005\u000by\u0002!\u0019A \u0003\u0003-\u000b\"\u0001Q\"\u0011\u0005Q\n\u0015B\u0001\"/\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"\u0001\u000e#\n\u0005\u0015s#aA!osB\u0011Ah\u0012\u0003\u0006\u0011\u0002\u0011\ra\u0010\u0002\u0002-B)!*T\u001eG\u001f6\t1J\u0003\u0002MY\u00059q-\u001a8fe&\u001c\u0017B\u0001(L\u0005U9UM\\3sS\u000e\u0004\u0016M]'baR+W\u000e\u001d7bi\u0016\u0004\"\u0001\u000f\u0001\u0011\ra\n6HR*U\u0013\t\u0011\u0006F\u0001\u0006QCJl\u0015\r\u001d'jW\u0016\u0004B\u0001\u000f\u0001<\rB!Q\u000bW\u001eG\u001b\u00051&BA,-\u0003)\u0019wN\\2veJ,g\u000e^\u0005\u00033Z\u0013q\u0001\u0016:jK6\u000b\u0007\u000f\u0005\u000397n2\u0015B\u0001/)\u0005I\u0001\u0016M\u001d+sS\u0016l\u0015\r]\"p[\nLg.\u001a:\u0011\u0005Qr\u0016BA0/\u00051\u0019VM]5bY&T\u0018M\u00197f\u0003\u0015\u0019GO]5f+\u0005!\u0016AB2ue&,\u0007%\u0001\u0004=S:LGO\u0010\u000b\u0003'\u0016DQ\u0001Y\u0002A\u0002Q#\u0012aU\u0001\r[\u0006\u00048i\\7qC:LwN\\\u000b\u0002SB\u0019!J[(\n\u0005-\\%AF$f]\u0016\u0014\u0018n\u0019)be6\u000b\u0007oQ8na\u0006t\u0017n\u001c8\u0002\u000b\u0015l\u0007\u000f^=\u0016\u0003M\u000b1B\\3x\u0007>l'-\u001b8feV\t\u0001\u000f\u0005\u0003reR\u001cV\"\u0001\u0016\n\u0005MT#\u0001C\"p[\nLg.\u001a:\u0011\tQ*8HR\u0005\u0003m:\u0012a\u0001V;qY\u0016\u0014\u0014aA:fc\u0006A1\u000f\u001d7jiR,'/F\u0001{!\u0011A4p\u000f$\n\u0005qD#A\u0005)beR\u0013\u0018.Z'baN\u0003H.\u001b;uKJ\fQa\u00197fCJ$\u0012a \t\u0004i\u0005\u0005\u0011bAA\u0002]\t!QK\\5u\u0003\u0019\u0011Xm];mi\u0006\u0019q-\u001a;\u0015\t\u0005-\u0011\u0011\u0003\t\u0005i\u00055a)C\u0002\u0002\u00109\u0012aa\u00149uS>t\u0007BBA\n\u0019\u0001\u00071(A\u0002lKf\f1\u0001];u)\u0019\tY!!\u0007\u0002\u001c!1\u00111C\u0007A\u0002mBa!!\b\u000e\u0001\u00041\u0015!\u0002<bYV,\u0017AB;qI\u0006$X\rF\u0003\u0000\u0003G\t)\u0003\u0003\u0004\u0002\u00149\u0001\ra\u000f\u0005\u0007\u0003;q\u0001\u0019\u0001$\u0002\rI,Wn\u001c<f)\u0011\tY!a\u000b\t\r\u0005Mq\u00021\u0001<\u0003!!\u0003\u000f\\;tI\u0015\fH\u0003BA\u0019\u0003gi\u0011\u0001\u0001\u0005\u0007\u0003k\u0001\u0002\u0019\u0001;\u0002\u0005-4\u0018!\u0003\u0013nS:,8\u000fJ3r)\u0011\t\t$a\u000f\t\r\u0005M\u0011\u00031\u0001<\u0003\u0011\u0019\u0018N_3\u0016\u0005\u0005\u0005\u0003c\u0001\u001b\u0002D%\u0019\u0011Q\t\u0018\u0003\u0007%sG/\u0001\u0007tiJLgn\u001a)sK\u001aL\u00070\u0006\u0002\u0002LA!\u0011QJA,\u001b\t\tyE\u0003\u0003\u0002R\u0005M\u0013\u0001\u00027b]\u001eT!!!\u0016\u0002\t)\fg/Y\u0005\u0005\u00033\nyE\u0001\u0004TiJLgn\u001a\u0002\u0005'&TXm\u0005\u0003\u0015g\u0005}\u0003cB9\u0002b\u0005\u0005\u0013QM\u0005\u0004\u0003GR#\u0001\u0002+bg.\u00042!!\r\u0015\u0003\u0019ygMZ:fi\u00069\u0001n\\<nC:L\u0018!B1se\u0006L\b#\u0002\u001b\u0002p\u0005M\u0014bAA9]\t)\u0011I\u001d:bsB\u0019Q+!\u001e\n\u0007\u0005]dKA\u0005CCNL7MT8eKRA\u0011QMA>\u0003{\ny\bC\u0004\u0002ha\u0001\r!!\u0011\t\u000f\u0005%\u0004\u00041\u0001\u0002B!9\u00111\u000e\rA\u0002\u00055\u0014A\u0003:fgVdGo\u0018\u0013fcR\u0019q0!\"\t\u0013\u0005\u001d%$!AA\u0002\u0005\u0005\u0013a\u0001=%c\u00059!/Z:vYR\u0004\u0013\u0001\u00027fC\u001a$2a`AH\u0011\u001d\t\t\n\ba\u0001\u0003'\u000bA\u0001\u001d:fmB)A'!\u0004\u0002B\u0005)1\u000f\u001d7jiV\u0011\u0011\u0011\u0014\t\u0007\u00037\u000bi*!\u001a\u000e\u00031J1!a(-\u0005\r\u0019V-]\u0001\u0013g\"|W\u000f\u001c3Ta2LGOR;si\",'/\u0006\u0002\u0002&B\u0019A'a*\n\u0007\u0005%fFA\u0004C_>dW-\u00198\u0002\u000b5,'oZ3\u0015\u0007}\fy\u000bC\u0004\u00022~\u0001\r!!\u001a\u0002\tQD\u0017\r^\u0001\u000b!\u0006\u0014HK]5f\u001b\u0006\u0004\bC\u0001\u001d\"'\u0011\t\u0013\u0011X/\u0011\t)\u000bYlT\u0005\u0004\u0003{[%!\u0004)be6\u000b\u0007OR1di>\u0014\u0018\u0010\u0006\u0002\u00026V1\u00111YAe\u0003\u001b,\"!!2\u0011\ra\u0002\u0011qYAf!\ra\u0014\u0011\u001a\u0003\u0006}\r\u0012\ra\u0010\t\u0004y\u00055G!\u0002%$\u0005\u0004yTCBAi\u00033\fi.\u0006\u0002\u0002TB1\u0011O]Ak\u0003?\u0004b\u0001N;\u0002X\u0006m\u0007c\u0001\u001f\u0002Z\u0012)a\b\nb\u0001\u007fA\u0019A(!8\u0005\u000b!##\u0019A \u0011\ra\u0002\u0011q[An\u00031\u0019\u0017M\u001c\"vS2$gI]8n+\u0019\t)/!@\u0003\u0002U\u0011\u0011q\u001d\t\n\u0015\u0006%\u0018Q^A}\u0005\u0007I1!a;L\u00059\u0019\u0015M\\\"p[\nLg.\u001a$s_6\u0004B!a<\u0002r6\t\u0011%\u0003\u0003\u0002t\u0006U(\u0001B\"pY2L1!a>L\u000559UM\\'ba\u001a\u000b7\r^8ssB1A'^A~\u0003\u007f\u00042\u0001PA\u007f\t\u0015qTE1\u0001@!\ra$\u0011\u0001\u0003\u0006\u0011\u0016\u0012\ra\u0010\t\u0007q\u0001\tY0a@\u0002\u0017I,\u0017\r\u001a*fg>dg/\u001a\u000b\u0003\u0005\u0013\u0001B!!\u0014\u0003\f%!!QBA(\u0005\u0019y%M[3di\u0002")
public final class ParTrieMap<K, V>
implements scala.collection.parallel.mutable.ParMap<K, V>,
ParTrieMapCombiner<K, V>,
Serializable {
    private final TrieMap<K, V> scala$collection$parallel$mutable$ParTrieMap$$ctrie;
    private volatile transient TaskSupport _combinerTaskSupport;
    private volatile transient TaskSupport scala$collection$parallel$ParIterableLike$$_tasksupport;
    private volatile ParIterableLike$ScanNode$ ScanNode$module;
    private volatile ParIterableLike$ScanLeaf$ ScanLeaf$module;

    public static <K, V> CanCombineFrom<ParTrieMap<?, ?>, Tuple2<K, V>, ParTrieMap<K, V>> canBuildFrom() {
        return ParTrieMap$.MODULE$.canBuildFrom();
    }

    @Override
    public <N extends Tuple2<K, V>, NewTo> Combiner<N, NewTo> combine(Combiner<N, NewTo> other) {
        return ParTrieMapCombiner.combine$(this, other);
    }

    @Override
    public boolean canBeShared() {
        return ParTrieMapCombiner.canBeShared$(this);
    }

    @Override
    public TaskSupport combinerTaskSupport() {
        return Combiner.combinerTaskSupport$(this);
    }

    @Override
    public void combinerTaskSupport_$eq(TaskSupport cts) {
        Combiner.combinerTaskSupport_$eq$(this, cts);
    }

    @Override
    public Object resultWithTaskSupport() {
        return Combiner.resultWithTaskSupport$(this);
    }

    @Override
    public void sizeHint(int size) {
        Builder.sizeHint$((Builder)this, size);
    }

    @Override
    public void sizeHint(TraversableLike<?, ?> coll) {
        Builder.sizeHint$((Builder)this, coll);
    }

    @Override
    public void sizeHint(TraversableLike<?, ?> coll, int delta) {
        Builder.sizeHint$(this, coll, delta);
    }

    @Override
    public void sizeHintBounded(int size, TraversableLike<?, ?> boundingColl) {
        Builder.sizeHintBounded$(this, size, boundingColl);
    }

    @Override
    public <NewTo> Builder<Tuple2<K, V>, NewTo> mapResult(Function1<ParTrieMap<K, V>, NewTo> f) {
        return Builder.mapResult$(this, f);
    }

    @Override
    public <U> scala.collection.parallel.mutable.ParMap<K, U> updated(K key, U value) {
        return scala.collection.parallel.mutable.ParMap.updated$(this, key, value);
    }

    @Override
    public scala.collection.parallel.mutable.ParMap<K, V> withDefault(Function1<K, V> d) {
        return scala.collection.parallel.mutable.ParMap.withDefault$(this, d);
    }

    @Override
    public scala.collection.parallel.mutable.ParMap<K, V> withDefaultValue(V d) {
        return scala.collection.parallel.mutable.ParMap.withDefaultValue$(this, d);
    }

    @Override
    public <U> scala.collection.parallel.mutable.ParMap<K, U> $plus(Tuple2<K, U> kv) {
        return ParMapLike.$plus$(this, kv);
    }

    @Override
    public scala.collection.parallel.mutable.ParMap $minus(Object key) {
        return ParMapLike.$minus$(this, key);
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
    public Shrinkable<K> $minus$eq(K elem1, K elem2, Seq<K> elems) {
        return Shrinkable.$minus$eq$(this, elem1, elem2, elems);
    }

    @Override
    public Shrinkable<K> $minus$minus$eq(TraversableOnce<K> xs) {
        return Shrinkable.$minus$minus$eq$(this, xs);
    }

    @Override
    public Growable $plus$eq(Object elem1, Object elem2, Seq elems) {
        return Growable.$plus$eq$(this, elem1, elem2, elems);
    }

    @Override
    public Growable<Tuple2<K, V>> $plus$plus$eq(TraversableOnce<Tuple2<K, V>> xs) {
        return Growable.$plus$plus$eq$(this, xs);
    }

    @Override
    public GenericCompanion<ParIterable> companion() {
        return ParIterable.companion$(this);
    }

    @Override
    public ParIterable<Tuple2<K, V>> toIterable() {
        return ParIterable.toIterable$(this);
    }

    @Override
    public ParSeq<Tuple2<K, V>> toSeq() {
        return ParIterable.toSeq$(this);
    }

    @Override
    public V default(K key) {
        return (V)scala.collection.parallel.ParMapLike.default$(this, key);
    }

    @Override
    public V apply(K key) {
        return (V)scala.collection.parallel.ParMapLike.apply$(this, key);
    }

    @Override
    public <U> U getOrElse(K key, Function0<U> function0) {
        return (U)scala.collection.parallel.ParMapLike.getOrElse$(this, key, function0);
    }

    @Override
    public boolean contains(K key) {
        return scala.collection.parallel.ParMapLike.contains$(this, key);
    }

    @Override
    public boolean isDefinedAt(K key) {
        return scala.collection.parallel.ParMapLike.isDefinedAt$(this, key);
    }

    @Override
    public IterableSplitter<K> keysIterator() {
        return scala.collection.parallel.ParMapLike.keysIterator$(this);
    }

    @Override
    public IterableSplitter<V> valuesIterator() {
        return scala.collection.parallel.ParMapLike.valuesIterator$(this);
    }

    @Override
    public ParSet<K> keySet() {
        return scala.collection.parallel.ParMapLike.keySet$(this);
    }

    @Override
    public scala.collection.parallel.ParIterable<K> keys() {
        return scala.collection.parallel.ParMapLike.keys$(this);
    }

    @Override
    public scala.collection.parallel.ParIterable<V> values() {
        return scala.collection.parallel.ParMapLike.values$(this);
    }

    @Override
    public ParMap<K, V> filterKeys(Function1<K, Object> p) {
        return scala.collection.parallel.ParMapLike.filterKeys$(this, p);
    }

    @Override
    public <S> ParMap<K, S> mapValues(Function1<V, S> f) {
        return scala.collection.parallel.ParMapLike.mapValues$(this, f);
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
    public Option<Tuple2<K, V>> headOption() {
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
    public Option<Tuple2<K, V>> lastOption() {
        return ParIterableLike.lastOption$(this);
    }

    @Override
    public scala.collection.parallel.ParIterable init() {
        return ParIterableLike.init$(this);
    }

    @Override
    public Splitter<Tuple2<K, V>> iterator() {
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
    public <S, That> CanBuildFrom<TrieMap<K, V>, S, That> bf2seq(CanBuildFrom<ParTrieMap<K, V>, S, That> bf) {
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
    public <S> S aggregate(Function0<S> z, Function2<S, Tuple2<K, V>, S> seqop, Function2<S, S, S> combop) {
        return (S)ParIterableLike.aggregate$(this, z, seqop, combop);
    }

    @Override
    public <S> S foldLeft(S z, Function2<S, Tuple2<K, V>, S> op) {
        return (S)ParIterableLike.foldLeft$(this, z, op);
    }

    @Override
    public <S> S foldRight(S z, Function2<Tuple2<K, V>, S, S> op) {
        return (S)ParIterableLike.foldRight$(this, z, op);
    }

    @Override
    public <U> U reduceLeft(Function2<U, Tuple2<K, V>, U> op) {
        return (U)ParIterableLike.reduceLeft$(this, op);
    }

    @Override
    public <U> U reduceRight(Function2<Tuple2<K, V>, U, U> op) {
        return (U)ParIterableLike.reduceRight$(this, op);
    }

    @Override
    public <U> Option<U> reduceLeftOption(Function2<U, Tuple2<K, V>, U> op) {
        return ParIterableLike.reduceLeftOption$(this, op);
    }

    @Override
    public <U> Option<U> reduceRightOption(Function2<Tuple2<K, V>, U, U> op) {
        return ParIterableLike.reduceRightOption$(this, op);
    }

    @Override
    public <U> void foreach(Function1<Tuple2<K, V>, U> f) {
        ParIterableLike.foreach$(this, f);
    }

    @Override
    public int count(Function1<Tuple2<K, V>, Object> p) {
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
    public <S, That> That map(Function1<Tuple2<K, V>, S> f, CanBuildFrom<ParTrieMap<K, V>, S, That> bf) {
        return (That)ParIterableLike.map$(this, f, bf);
    }

    @Override
    public <S, That> That collect(PartialFunction<Tuple2<K, V>, S> pf, CanBuildFrom<ParTrieMap<K, V>, S, That> bf) {
        return (That)ParIterableLike.collect$(this, pf, bf);
    }

    @Override
    public <S, That> That flatMap(Function1<Tuple2<K, V>, GenTraversableOnce<S>> f, CanBuildFrom<ParTrieMap<K, V>, S, That> bf) {
        return (That)ParIterableLike.flatMap$(this, f, bf);
    }

    @Override
    public boolean forall(Function1<Tuple2<K, V>, Object> p) {
        return ParIterableLike.forall$(this, p);
    }

    @Override
    public boolean exists(Function1<Tuple2<K, V>, Object> p) {
        return ParIterableLike.exists$(this, p);
    }

    @Override
    public Option<Tuple2<K, V>> find(Function1<Tuple2<K, V>, Object> p) {
        return ParIterableLike.find$(this, p);
    }

    @Override
    public CombinerFactory<Tuple2<K, V>, ParTrieMap<K, V>> combinerFactory() {
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
    public <U, That> That $plus$plus(GenTraversableOnce<U> that, CanBuildFrom<ParTrieMap<K, V>, U, That> bf) {
        return (That)ParIterableLike.$plus$plus$(this, that, bf);
    }

    @Override
    public Tuple2<ParTrieMap<K, V>, ParTrieMap<K, V>> partition(Function1<Tuple2<K, V>, Object> pred) {
        return ParIterableLike.partition$(this, pred);
    }

    @Override
    public <K> scala.collection.parallel.immutable.ParMap<K, ParTrieMap<K, V>> groupBy(Function1<Tuple2<K, V>, K> f) {
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
    public Tuple2<ParTrieMap<K, V>, ParTrieMap<K, V>> splitAt(int n) {
        return ParIterableLike.splitAt$(this, n);
    }

    @Override
    public <U, That> That scan(U z, Function2<U, U, U> op, CanBuildFrom<ParTrieMap<K, V>, U, That> bf) {
        return (That)ParIterableLike.scan$(this, z, op, bf);
    }

    @Override
    public <S, That> That scanLeft(S z, Function2<S, Tuple2<K, V>, S> op, CanBuildFrom<ParTrieMap<K, V>, S, That> bf) {
        return (That)ParIterableLike.scanLeft$(this, z, op, bf);
    }

    @Override
    public <S, That> That scanRight(S z, Function2<Tuple2<K, V>, S, S> op, CanBuildFrom<ParTrieMap<K, V>, S, That> bf) {
        return (That)ParIterableLike.scanRight$(this, z, op, bf);
    }

    @Override
    public scala.collection.parallel.ParIterable takeWhile(Function1 pred) {
        return ParIterableLike.takeWhile$(this, pred);
    }

    @Override
    public Tuple2<ParTrieMap<K, V>, ParTrieMap<K, V>> span(Function1<Tuple2<K, V>, Object> pred) {
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
    public <U, S, That> That zip(GenIterable<S> that, CanBuildFrom<ParTrieMap<K, V>, Tuple2<U, S>, That> bf) {
        return (That)ParIterableLike.zip$(this, that, bf);
    }

    @Override
    public <U, That> That zipWithIndex(CanBuildFrom<ParTrieMap<K, V>, Tuple2<U, Object>, That> bf) {
        return (That)ParIterableLike.zipWithIndex$(this, bf);
    }

    @Override
    public <S, U, That> That zipAll(GenIterable<S> that, U thisElem, S thatElem, CanBuildFrom<ParTrieMap<K, V>, Tuple2<U, S>, That> bf) {
        return (That)ParIterableLike.zipAll$(this, that, thisElem, thatElem, bf);
    }

    @Override
    public <U, That> That toParCollection(Function0<Combiner<U, That>> cbf) {
        return (That)ParIterableLike.toParCollection$(this, cbf);
    }

    @Override
    public <K, V, That> That toParMap(Function0<Combiner<Tuple2<K, V>, That>> cbf, Predef$.less.colon.less<Tuple2<K, V>, Tuple2<K, V>> ev) {
        return (That)ParIterableLike.toParMap$(this, cbf, ev);
    }

    @Override
    public IterableView<Tuple2<K, V>, TrieMap<K, V>> view() {
        return ParIterableLike.view$(this);
    }

    @Override
    public <U> Object toArray(ClassTag<U> evidence$1) {
        return ParIterableLike.toArray$(this, evidence$1);
    }

    @Override
    public List<Tuple2<K, V>> toList() {
        return ParIterableLike.toList$(this);
    }

    @Override
    public IndexedSeq<Tuple2<K, V>> toIndexedSeq() {
        return ParIterableLike.toIndexedSeq$(this);
    }

    @Override
    public Stream<Tuple2<K, V>> toStream() {
        return ParIterableLike.toStream$(this);
    }

    @Override
    public Iterator<Tuple2<K, V>> toIterator() {
        return ParIterableLike.toIterator$(this);
    }

    @Override
    public <U> Buffer<U> toBuffer() {
        return ParIterableLike.toBuffer$(this);
    }

    @Override
    public GenTraversable<Tuple2<K, V>> toTraversable() {
        return ParIterableLike.toTraversable$(this);
    }

    @Override
    public <U> scala.collection.parallel.immutable.ParSet<U> toSet() {
        return ParIterableLike.toSet$(this);
    }

    @Override
    public <K, V> scala.collection.parallel.immutable.ParMap<K, V> toMap(Predef$.less.colon.less<Tuple2<K, V>, Tuple2<K, V>> ev) {
        return ParIterableLike.toMap$(this, ev);
    }

    @Override
    public Vector<Tuple2<K, V>> toVector() {
        return ParIterableLike.toVector$(this);
    }

    @Override
    public <Col> Col to(CanBuildFrom<Nothing$, Tuple2<K, V>, Col> cbf) {
        return (Col)ParIterableLike.to$(this, cbf);
    }

    @Override
    public int scanBlockSize() {
        return ParIterableLike.scanBlockSize$(this);
    }

    @Override
    public <S> S $div$colon(S z, Function2<S, Tuple2<K, V>, S> op) {
        return (S)ParIterableLike.$div$colon$(this, z, op);
    }

    @Override
    public <S> S $colon$bslash(S z, Function2<Tuple2<K, V>, S, S> op) {
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
    public Combiner<Tuple2<K, V>, ParTrieMap<K, V>> parCombiner() {
        return CustomParallelizable.parCombiner$(this);
    }

    @Override
    public <P, Q> Combiner<Tuple2<P, Q>, ParTrieMap<P, Q>> genericMapCombiner() {
        return GenericParMapTemplate.genericMapCombiner$(this);
    }

    @Override
    public Builder<Tuple2<K, V>, ParIterable<Tuple2<K, V>>> newBuilder() {
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
    public <A1, A2> Tuple2<ParIterable<A1>, ParIterable<A2>> unzip(Function1<Tuple2<K, V>, Tuple2<A1, A2>> asPair) {
        return GenericTraversableTemplate.unzip$(this, asPair);
    }

    @Override
    public <A1, A2, A3> Tuple3<ParIterable<A1>, ParIterable<A2>, ParIterable<A3>> unzip3(Function1<Tuple2<K, V>, Tuple3<A1, A2, A3>> asTriple) {
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
    public TaskSupport _combinerTaskSupport() {
        return this._combinerTaskSupport;
    }

    @Override
    public void _combinerTaskSupport_$eq(TaskSupport x$1) {
        this._combinerTaskSupport = x$1;
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

    public TrieMap<K, V> scala$collection$parallel$mutable$ParTrieMap$$ctrie() {
        return this.scala$collection$parallel$mutable$ParTrieMap$$ctrie;
    }

    @Override
    public GenericParMapCompanion<ParTrieMap> mapCompanion() {
        return ParTrieMap$.MODULE$;
    }

    @Override
    public ParTrieMap<K, V> empty() {
        return ParTrieMap$.MODULE$.empty();
    }

    @Override
    public Combiner<Tuple2<K, V>, ParTrieMap<K, V>> newCombiner() {
        return ParTrieMap$.MODULE$.newCombiner();
    }

    @Override
    public TrieMap<K, V> seq() {
        return this.scala$collection$parallel$mutable$ParTrieMap$$ctrie();
    }

    public ParTrieMapSplitter<K, V> splitter() {
        return new ParTrieMapSplitter(0, (TrieMap)this.scala$collection$parallel$mutable$ParTrieMap$$ctrie().readOnlySnapshot(), true);
    }

    @Override
    public void clear() {
        this.scala$collection$parallel$mutable$ParTrieMap$$ctrie().clear();
    }

    @Override
    public ParTrieMap<K, V> result() {
        return this;
    }

    @Override
    public Option<V> get(K key) {
        return this.scala$collection$parallel$mutable$ParTrieMap$$ctrie().get(key);
    }

    @Override
    public Option<V> put(K key, V value) {
        return this.scala$collection$parallel$mutable$ParTrieMap$$ctrie().put(key, value);
    }

    public void update(K key, V value) {
        this.scala$collection$parallel$mutable$ParTrieMap$$ctrie().update(key, value);
    }

    public Option<V> remove(K key) {
        return this.scala$collection$parallel$mutable$ParTrieMap$$ctrie().remove(key);
    }

    @Override
    public ParTrieMap<K, V> $plus$eq(Tuple2<K, V> kv) {
        this.scala$collection$parallel$mutable$ParTrieMap$$ctrie().$plus$eq((Tuple2)kv);
        return this;
    }

    public ParTrieMap<K, V> $minus$eq(K key) {
        this.scala$collection$parallel$mutable$ParTrieMap$$ctrie().$minus$eq((Object)key);
        return this;
    }

    @Override
    public int size() {
        int n;
        MainNode<K, V> r = this.scala$collection$parallel$mutable$ParTrieMap$$ctrie().readRoot(this.scala$collection$parallel$mutable$ParTrieMap$$ctrie().readRoot$default$1()).gcasRead(this.scala$collection$parallel$mutable$ParTrieMap$$ctrie());
        if (r instanceof TNode) {
            n = ((TNode)r).cachedSize(this.scala$collection$parallel$mutable$ParTrieMap$$ctrie());
        } else if (r instanceof LNode) {
            n = ((LNode)r).cachedSize(this.scala$collection$parallel$mutable$ParTrieMap$$ctrie());
        } else if (r instanceof CNode) {
            CNode cNode = (CNode)r;
            this.tasksupport().executeAndWaitResult(new Size(this, 0, cNode.array().length, cNode.array()));
            n = cNode.cachedSize(this.scala$collection$parallel$mutable$ParTrieMap$$ctrie());
        } else {
            throw new MatchError(r);
        }
        return n;
    }

    @Override
    public String stringPrefix() {
        return "ParTrieMap";
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

    public ParTrieMap(TrieMap<K, V> ctrie) {
        this.scala$collection$parallel$mutable$ParTrieMap$$ctrie = ctrie;
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
        scala.collection.parallel.ParIterable.$init$(this);
        scala.collection.parallel.ParMapLike.$init$(this);
        ParMap.$init$(this);
        ParIterable.$init$(this);
        Growable.$init$(this);
        Shrinkable.$init$(this);
        Cloneable.$init$(this);
        ParMapLike.$init$(this);
        scala.collection.parallel.mutable.ParMap.$init$(this);
        Builder.$init$(this);
        Combiner.$init$(this);
        ParTrieMapCombiner.$init$(this);
    }

    public ParTrieMap() {
        this(new TrieMap());
    }

    public class Size
    implements Task<Object, Size> {
        private final int offset;
        private final int howmany;
        private final BasicNode[] array;
        private int result;
        private volatile Throwable throwable;
        public final /* synthetic */ ParTrieMap $outer;

        @Override
        public Object repr() {
            return Task.repr$(this);
        }

        @Override
        public void forwardThrowable() {
            Task.forwardThrowable$(this);
        }

        @Override
        public void tryLeaf(Option<Object> lastres) {
            Task.tryLeaf$(this, lastres);
        }

        @Override
        public void tryMerge(Object t) {
            Task.tryMerge$(this, t);
        }

        @Override
        public void mergeThrowables(Task<?, ?> that) {
            Task.mergeThrowables$(this, that);
        }

        @Override
        public void signalAbort() {
            Task.signalAbort$(this);
        }

        @Override
        public Throwable throwable() {
            return this.throwable;
        }

        @Override
        public void throwable_$eq(Throwable x$1) {
            this.throwable = x$1;
        }

        @Override
        public int result() {
            return this.result;
        }

        @Override
        public void result_$eq(int x$1) {
            this.result = x$1;
        }

        @Override
        public void leaf(Option<Object> prev) {
            int sz = 0;
            int until = this.offset + this.howmany;
            for (int i = this.offset; i < until; ++i) {
                BasicNode basicNode = this.array[i];
                if (basicNode instanceof SNode) {
                    ++sz;
                    continue;
                }
                if (basicNode instanceof INode) {
                    INode iNode = (INode)basicNode;
                    sz += iNode.cachedSize(this.scala$collection$parallel$mutable$ParTrieMap$Size$$$outer().scala$collection$parallel$mutable$ParTrieMap$$ctrie());
                    continue;
                }
                throw new MatchError(basicNode);
            }
            this.result_$eq(sz);
        }

        @Override
        public Seq<Size> split() {
            int fp = this.howmany / 2;
            return new $colon$colon<Nothing$>((Nothing$)((Object)new Size(this.scala$collection$parallel$mutable$ParTrieMap$Size$$$outer(), this.offset, fp, this.array)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)new Size(this.scala$collection$parallel$mutable$ParTrieMap$Size$$$outer(), this.offset + fp, this.howmany - fp, this.array)), Nil$.MODULE$));
        }

        @Override
        public boolean shouldSplitFurther() {
            return this.howmany > 1;
        }

        @Override
        public void merge(Size that) {
            this.result_$eq(this.result() + that.result());
        }

        public /* synthetic */ ParTrieMap scala$collection$parallel$mutable$ParTrieMap$Size$$$outer() {
            return this.$outer;
        }

        public Size(ParTrieMap $outer, int offset, int howmany, BasicNode[] array) {
            this.offset = offset;
            this.howmany = howmany;
            this.array = array;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Task.$init$(this);
            this.result = -1;
        }
    }
}

