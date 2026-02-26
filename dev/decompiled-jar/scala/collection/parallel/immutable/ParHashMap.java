/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.immutable;

import java.util.concurrent.atomic.AtomicInteger;
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
import scala.collection.GenMapLike;
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
import scala.collection.generic.GenericParMapCompanion;
import scala.collection.generic.GenericParMapTemplate;
import scala.collection.generic.GenericParTemplate;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.generic.Signalling;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.HashMap;
import scala.collection.immutable.HashMap$;
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
import scala.collection.parallel.ParMap;
import scala.collection.parallel.ParMapLike;
import scala.collection.parallel.ParSet;
import scala.collection.parallel.RemainsIterator;
import scala.collection.parallel.SeqSplitter;
import scala.collection.parallel.Splitter;
import scala.collection.parallel.TaskSupport;
import scala.collection.parallel.immutable.HashMapCombiner;
import scala.collection.parallel.immutable.HashMapCombiner$;
import scala.collection.parallel.immutable.ParHashMap$;
import scala.collection.parallel.immutable.ParIterable;
import scala.collection.parallel.immutable.ParSeq;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.Nothing$;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@ScalaSignature(bytes="\u0006\u0001\tud\u0001B\u0016-\u0001UB\u0001\"\u0019\u0001\u0003\u0002\u0003\u0006I!\u0017\u0005\u0007E\u0002!\t\u0001L2\t\u000b\t\u0004A\u0011A3\t\u000b\u0019\u0004A\u0011I4\t\u000b-\u0004A\u0011\t7\t\r5\u0004\u0001\u0015\"\u0015o\u0011\u0015\u0011\b\u0001\"\u0001t\u0011\u0015Q\b\u0001\"\u0011|\u0011\u0015a\b\u0001\"\u0001~\u0011\u001d\t\t\u0001\u0001C\u0001\u0003\u0007Aq!a\u0006\u0001\t\u0003\tI\u0002C\u0004\u0002$\u0001!\t%!\n\t\u000f\u00055\u0002\u0001\"\u0015\u00020\u00191\u0011q\n\u0001\u0001\u0003#B!\"a\u0015\u000f\u0005\u0003\u0007I\u0011AA+\u0011)\tYH\u0004BA\u0002\u0013\u0005\u0011Q\u0010\u0005\u000b\u0003\u0013s!\u0011!Q!\n\u0005]\u0003BCAF\u001d\t\u0015\r\u0011\"\u0001\u0002&!Q\u0011Q\u0012\b\u0003\u0002\u0003\u0006I!a\n\t\r\ttA\u0011AAH\u0011%\tIJ\u0004a\u0001\n\u0003\t)\u0003C\u0005\u0002\u001c:\u0001\r\u0011\"\u0001\u0002\u001e\"A\u0011\u0011\u0015\b!B\u0013\t9\u0003\u0003\u0004\u0002$:!\ta\u001d\u0005\b\u0003KsA\u0011BAT\u0011\u001d\tiK\u0004C\u0001\u0003_Cq!a.\u000f\t\u0003\tI\fC\u0004\u0002<:!\t!!0\t\u000f\u0005\u0015g\u0002\"\u0001\u0002&!9\u0011q\u0019\b\u0005B\u0005%\u0007\u0002CAn\u0001\u0011\u0005a&!8\b\u000f\u0005-H\u0006#\u0001\u0002n\u001a11\u0006\fE\u0001\u0003_DaAY\u0011\u0005\u0002\u0005]\bBB6\"\t\u0003\tI\u0010\u0003\u0004nC\u0011\u0005!q\u0001\u0005\b\u00053\tC1\u0001B\u000e\u0011\u001d\u0011i$\tC\u0001\u0005\u007fA\u0011Ba\u0015\"\u0001\u0004%\tA!\u0016\t\u0013\t-\u0014\u00051A\u0005\u0002\t5\u0004\u0002\u0003B9C\u0001\u0006KAa\u0016\t\u0013\tM\u0014%!A\u0005\n\tU$A\u0003)be\"\u000b7\u000f['ba*\u0011QFL\u0001\nS6lW\u000f^1cY\u0016T!a\f\u0019\u0002\u0011A\f'/\u00197mK2T!!\r\u001a\u0002\u0015\r|G\u000e\\3di&|gNC\u00014\u0003\u0015\u00198-\u00197b\u0007\u0001)2AN!L'\u0019\u0001qgO'U=B\u0011\u0001(O\u0007\u0002e%\u0011!H\r\u0002\u0007\u0003:L(+\u001a4\u0011\tqjtHS\u0007\u0002Y%\u0011a\b\f\u0002\u0007!\u0006\u0014X*\u00199\u0011\u0005\u0001\u000bE\u0002\u0001\u0003\u0006\u0005\u0002\u0011\ra\u0011\u0002\u0002\u0017F\u0011Ai\u0012\t\u0003q\u0015K!A\u0012\u001a\u0003\u000f9{G\u000f[5oOB\u0011\u0001\bS\u0005\u0003\u0013J\u00121!\u00118z!\t\u00015\n\u0002\u0004M\u0001\u0011\u0015\ra\u0011\u0002\u0002-B)a*U K'6\tqJ\u0003\u0002Qa\u00059q-\u001a8fe&\u001c\u0017B\u0001*P\u0005U9UM\\3sS\u000e\u0004\u0016M]'baR+W\u000e\u001d7bi\u0016\u0004\"\u0001\u0010\u0001\u0011\rU3vH\u0013-Z\u001b\u0005q\u0013BA,/\u0005)\u0001\u0016M]'ba2K7.\u001a\t\u0005y\u0001y$\n\u0005\u0003[9~RU\"A.\u000b\u00055\u0002\u0014BA/\\\u0005\u001dA\u0015m\u001d5NCB\u0004\"\u0001O0\n\u0005\u0001\u0014$\u0001D*fe&\fG.\u001b>bE2,\u0017\u0001\u0002;sS\u0016\fa\u0001P5oSRtDC\u0001-e\u0011\u0015\t'\u00011\u0001Z)\u0005A\u0016\u0001D7ba\u000e{W\u000e]1oS>tW#\u00015\u0011\u00079K7+\u0003\u0002k\u001f\n1r)\u001a8fe&\u001c\u0007+\u0019:NCB\u001cu.\u001c9b]&|g.A\u0003f[B$\u00180F\u0001Y\u0003-qWm^\"p[\nLg.\u001a:\u0016\u0003=\u0004B\u0001\u00109@\u0015&\u0011\u0011\u000f\f\u0002\u0010\u0011\u0006\u001c\b.T1q\u0007>l'-\u001b8fe\u0006A1\u000f\u001d7jiR,'/F\u0001u!\r)Vo^\u0005\u0003m:\u0012\u0001#\u0013;fe\u0006\u0014G.Z*qY&$H/\u001a:\u0011\taBxHS\u0005\u0003sJ\u0012a\u0001V;qY\u0016\u0014\u0014aA:fcV\t\u0011,\u0001\u0004%[&tWo\u001d\u000b\u00031zDQa`\u0005A\u0002}\n\u0011a[\u0001\u0006IAdWo]\u000b\u0005\u0003\u000b\tY\u0001\u0006\u0003\u0002\b\u0005E\u0001#\u0002\u001f\u0001\u007f\u0005%\u0001c\u0001!\u0002\f\u00119\u0011Q\u0002\u0006C\u0002\u0005=!!A+\u0012\u0005);\u0005bBA\n\u0015\u0001\u0007\u0011QC\u0001\u0003WZ\u0004R\u0001\u000f=@\u0003\u0013\t1aZ3u)\u0011\tY\"!\t\u0011\ta\niBS\u0005\u0004\u0003?\u0011$AB(qi&|g\u000eC\u0003\u0000\u0017\u0001\u0007q(\u0001\u0003tSj,WCAA\u0014!\rA\u0014\u0011F\u0005\u0004\u0003W\u0011$aA%oi\u0006)!/Z;tKV1\u0011\u0011GA\u001e\u0003\u0003\"b!a\r\u0002F\u0005-\u0003cB+\u00026\u0005e\u0012qH\u0005\u0004\u0003oq#\u0001C\"p[\nLg.\u001a:\u0011\u0007\u0001\u000bY\u0004\u0002\u0004\u0002>5\u0011\ra\u0011\u0002\u0002'B\u0019\u0001)!\u0011\u0005\r\u0005\rSB1\u0001D\u0005\u0011!\u0006.\u0019;\t\u000f\u0005\u001dS\u00021\u0001\u0002J\u0005!q\u000e\u001c3d!\u0015A\u0014QDA\u001a\u0011\u001d\ti%\u0004a\u0001\u0003g\tAA\\3xG\n\u0011\u0002+\u0019:ICNDW*\u00199Ji\u0016\u0014\u0018\r^8s'\rqq\u0007^\u0001\u0007iJLG/\u001a:\u0016\u0005\u0005]\u0003CBA-\u0003?\n)GD\u00029\u00037J1!!\u00183\u0003\u001d\u0001\u0018mY6bO\u0016LA!!\u0019\u0002d\tA\u0011\n^3sCR|'OC\u0002\u0002^I\u0002R\u0001\u000f=@\u0003OR3ASA5W\t\tY\u0007\u0005\u0003\u0002n\u0005]TBAA8\u0015\u0011\t\t(a\u001d\u0002\u0013Ut7\r[3dW\u0016$'bAA;e\u0005Q\u0011M\u001c8pi\u0006$\u0018n\u001c8\n\t\u0005e\u0014q\u000e\u0002\u0012k:\u001c\u0007.Z2lK\u00124\u0016M]5b]\u000e,\u0017A\u0003;sSR,'o\u0018\u0013fcR!\u0011qPAC!\rA\u0014\u0011Q\u0005\u0004\u0003\u0007\u0013$\u0001B+oSRD\u0011\"a\"\u0011\u0003\u0003\u0005\r!a\u0016\u0002\u0007a$\u0013'A\u0004ue&$XM\u001d\u0011\u0002\u0005MT\u0018aA:{AQ1\u0011\u0011SAK\u0003/\u00032!a%\u000f\u001b\u0005\u0001\u0001bBA*)\u0001\u0007\u0011q\u000b\u0005\b\u0003\u0017#\u0002\u0019AA\u0014\u0003\u0005I\u0017!B5`I\u0015\fH\u0003BA@\u0003?C\u0011\"a\"\u0017\u0003\u0003\u0005\r!a\n\u0002\u0005%\u0004\u0013a\u00013va\u0006yA-\u001e9Ge>l\u0017\n^3sCR|'\u000f\u0006\u0003\u0002\u0012\u0006%\u0006bBAV3\u0001\u0007\u0011qK\u0001\u0003SR\fQa\u001d9mSR,\"!!-\u0011\u000b\u0005e\u00131\u0017;\n\t\u0005U\u00161\r\u0002\u0004'\u0016\f\u0018\u0001\u00028fqR$\u0012a^\u0001\bQ\u0006\u001ch*\u001a=u+\t\ty\fE\u00029\u0003\u0003L1!a13\u0005\u001d\u0011un\u001c7fC:\f\u0011B]3nC&t\u0017N\\4\u0002\u0011Q|7\u000b\u001e:j]\u001e$\"!a3\u0011\t\u00055\u0017q[\u0007\u0003\u0003\u001fTA!!5\u0002T\u0006!A.\u00198h\u0015\t\t).\u0001\u0003kCZ\f\u0017\u0002BAm\u0003\u001f\u0014aa\u0015;sS:<\u0017A\u00049sS:$H)\u001a2vO&sgm\u001c\u000b\u0003\u0003\u007fBs\u0001AAq\u0003O\fI\u000fE\u00029\u0003GL1!!:3\u0005A\u0019VM]5bYZ+'o]5p]VKE)A\u0003wC2,XMH\u0001\u0002\u0003)\u0001\u0016M\u001d%bg\"l\u0015\r\u001d\t\u0003y\u0005\u001aB!IAy=B!a*a=T\u0013\r\t)p\u0014\u0002\u000e!\u0006\u0014X*\u00199GC\u000e$xN]=\u0015\u0005\u00055XCBA~\u0005\u0003\u0011)!\u0006\u0002\u0002~B1A\bAA\u0000\u0005\u0007\u00012\u0001\u0011B\u0001\t\u0015\u00115E1\u0001D!\r\u0001%Q\u0001\u0003\u0006\u0019\u000e\u0012\raQ\u000b\u0007\u0005\u0013\u0011\tB!\u0006\u0016\u0005\t-\u0001cB+\u00026\t5!q\u0003\t\u0007qa\u0014yAa\u0005\u0011\u0007\u0001\u0013\t\u0002B\u0003CI\t\u00071\tE\u0002A\u0005+!Q\u0001\u0014\u0013C\u0002\r\u0003b\u0001\u0010\u0001\u0003\u0010\tM\u0011\u0001D2b]\n+\u0018\u000e\u001c3Ge>lWC\u0002B\u000f\u0005k\u0011I$\u0006\u0002\u0003 AIaJ!\t\u0003&\tE\"1H\u0005\u0004\u0005Gy%AD\"b]\u000e{WNY5oK\u001a\u0013x.\u001c\t\u0005\u0005O\u0011I#D\u0001\"\u0013\u0011\u0011YC!\f\u0003\t\r{G\u000e\\\u0005\u0004\u0005_y%!D$f]6\u000b\u0007OR1di>\u0014\u0018\u0010\u0005\u00049q\nM\"q\u0007\t\u0004\u0001\nUB!\u0002\"&\u0005\u0004\u0019\u0005c\u0001!\u0003:\u0011)A*\nb\u0001\u0007B1A\b\u0001B\u001a\u0005o\t\u0001B\u001a:p[R\u0013\u0018.Z\u000b\u0007\u0005\u0003\u00129Ea\u0013\u0015\t\t\r#Q\n\t\u0007y\u0001\u0011)E!\u0013\u0011\u0007\u0001\u00139\u0005B\u0003CM\t\u00071\tE\u0002A\u0005\u0017\"Q\u0001\u0014\u0014C\u0002\rCqAa\u0014'\u0001\u0004\u0011\t&A\u0001u!\u0019QFL!\u0012\u0003J\u0005iAo\u001c;bY\u000e|WNY5oKN,\"Aa\u0016\u0011\t\te#qM\u0007\u0003\u00057RAA!\u0018\u0003`\u00051\u0011\r^8nS\u000eTAA!\u0019\u0003d\u0005Q1m\u001c8dkJ\u0014XM\u001c;\u000b\t\t\u0015\u00141[\u0001\u0005kRLG.\u0003\u0003\u0003j\tm#!D!u_6L7-\u00138uK\u001e,'/A\tu_R\fGnY8nE&tWm]0%KF$B!a \u0003p!I\u0011q\u0011\u0015\u0002\u0002\u0003\u0007!qK\u0001\u000fi>$\u0018\r\\2p[\nLg.Z:!\u0003-\u0011X-\u00193SKN|GN^3\u0015\u0005\t]\u0004\u0003BAg\u0005sJAAa\u001f\u0002P\n1qJ\u00196fGR\u0004")
public class ParHashMap<K, V>
implements scala.collection.parallel.immutable.ParMap<K, V>,
Serializable {
    public static final long serialVersionUID = 1L;
    private final HashMap<K, V> trie;
    private volatile transient TaskSupport scala$collection$parallel$ParIterableLike$$_tasksupport;
    private volatile ParIterableLike$ScanNode$ ScanNode$module;
    private volatile ParIterableLike$ScanLeaf$ ScanLeaf$module;

    public static void totalcombines_$eq(AtomicInteger atomicInteger) {
        ParHashMap$.MODULE$.totalcombines_$eq(atomicInteger);
    }

    public static AtomicInteger totalcombines() {
        return ParHashMap$.MODULE$.totalcombines();
    }

    public static <K, V> ParHashMap<K, V> fromTrie(HashMap<K, V> hashMap) {
        return ParHashMap$.MODULE$.fromTrie(hashMap);
    }

    public static <K, V> CanCombineFrom<ParHashMap<?, ?>, Tuple2<K, V>, ParHashMap<K, V>> canBuildFrom() {
        return ParHashMap$.MODULE$.canBuildFrom();
    }

    @Override
    public String stringPrefix() {
        return scala.collection.parallel.immutable.ParMap.stringPrefix$(this);
    }

    @Override
    public <P, Q> scala.collection.parallel.immutable.ParMap<P, Q> toMap(Predef$.less.colon.less<Tuple2<K, V>, Tuple2<P, Q>> ev) {
        return scala.collection.parallel.immutable.ParMap.toMap$(this, ev);
    }

    @Override
    public <U> scala.collection.parallel.immutable.ParMap<K, U> updated(K key, U value) {
        return scala.collection.parallel.immutable.ParMap.updated$(this, key, value);
    }

    @Override
    public <U> scala.collection.parallel.immutable.ParMap<K, U> withDefault(Function1<K, U> d) {
        return scala.collection.parallel.immutable.ParMap.withDefault$(this, d);
    }

    @Override
    public <U> scala.collection.parallel.immutable.ParMap<K, U> withDefaultValue(U d) {
        return scala.collection.parallel.immutable.ParMap.withDefaultValue$(this, d);
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
        return (V)ParMapLike.default$(this, key);
    }

    @Override
    public V apply(K key) {
        return (V)ParMapLike.apply$(this, key);
    }

    @Override
    public <U> U getOrElse(K key, Function0<U> function0) {
        return (U)ParMapLike.getOrElse$(this, key, function0);
    }

    @Override
    public boolean contains(K key) {
        return ParMapLike.contains$(this, key);
    }

    @Override
    public boolean isDefinedAt(K key) {
        return ParMapLike.isDefinedAt$(this, key);
    }

    @Override
    public IterableSplitter<K> keysIterator() {
        return ParMapLike.keysIterator$(this);
    }

    @Override
    public IterableSplitter<V> valuesIterator() {
        return ParMapLike.valuesIterator$(this);
    }

    @Override
    public ParSet<K> keySet() {
        return ParMapLike.keySet$(this);
    }

    @Override
    public scala.collection.parallel.ParIterable<K> keys() {
        return ParMapLike.keys$(this);
    }

    @Override
    public scala.collection.parallel.ParIterable<V> values() {
        return ParMapLike.values$(this);
    }

    @Override
    public ParMap<K, V> filterKeys(Function1<K, Object> p) {
        return ParMapLike.filterKeys$(this, p);
    }

    @Override
    public <S> ParMap<K, S> mapValues(Function1<V, S> f) {
        return ParMapLike.mapValues$(this, f);
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
    public <S, That> CanBuildFrom<HashMap<K, V>, S, That> bf2seq(CanBuildFrom<ParHashMap<K, V>, S, That> bf) {
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
    public <S, That> That map(Function1<Tuple2<K, V>, S> f, CanBuildFrom<ParHashMap<K, V>, S, That> bf) {
        return (That)ParIterableLike.map$(this, f, bf);
    }

    @Override
    public <S, That> That collect(PartialFunction<Tuple2<K, V>, S> pf, CanBuildFrom<ParHashMap<K, V>, S, That> bf) {
        return (That)ParIterableLike.collect$(this, pf, bf);
    }

    @Override
    public <S, That> That flatMap(Function1<Tuple2<K, V>, GenTraversableOnce<S>> f, CanBuildFrom<ParHashMap<K, V>, S, That> bf) {
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
    public CombinerFactory<Tuple2<K, V>, ParHashMap<K, V>> combinerFactory() {
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
    public <U, That> That $plus$plus(GenTraversableOnce<U> that, CanBuildFrom<ParHashMap<K, V>, U, That> bf) {
        return (That)ParIterableLike.$plus$plus$(this, that, bf);
    }

    @Override
    public Tuple2<ParHashMap<K, V>, ParHashMap<K, V>> partition(Function1<Tuple2<K, V>, Object> pred) {
        return ParIterableLike.partition$(this, pred);
    }

    @Override
    public <K> scala.collection.parallel.immutable.ParMap<K, ParHashMap<K, V>> groupBy(Function1<Tuple2<K, V>, K> f) {
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
    public Tuple2<ParHashMap<K, V>, ParHashMap<K, V>> splitAt(int n) {
        return ParIterableLike.splitAt$(this, n);
    }

    @Override
    public <U, That> That scan(U z, Function2<U, U, U> op, CanBuildFrom<ParHashMap<K, V>, U, That> bf) {
        return (That)ParIterableLike.scan$(this, z, op, bf);
    }

    @Override
    public <S, That> That scanLeft(S z, Function2<S, Tuple2<K, V>, S> op, CanBuildFrom<ParHashMap<K, V>, S, That> bf) {
        return (That)ParIterableLike.scanLeft$(this, z, op, bf);
    }

    @Override
    public <S, That> That scanRight(S z, Function2<Tuple2<K, V>, S, S> op, CanBuildFrom<ParHashMap<K, V>, S, That> bf) {
        return (That)ParIterableLike.scanRight$(this, z, op, bf);
    }

    @Override
    public scala.collection.parallel.ParIterable takeWhile(Function1 pred) {
        return ParIterableLike.takeWhile$(this, pred);
    }

    @Override
    public Tuple2<ParHashMap<K, V>, ParHashMap<K, V>> span(Function1<Tuple2<K, V>, Object> pred) {
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
    public <U, S, That> That zip(GenIterable<S> that, CanBuildFrom<ParHashMap<K, V>, Tuple2<U, S>, That> bf) {
        return (That)ParIterableLike.zip$(this, that, bf);
    }

    @Override
    public <U, That> That zipWithIndex(CanBuildFrom<ParHashMap<K, V>, Tuple2<U, Object>, That> bf) {
        return (That)ParIterableLike.zipWithIndex$(this, bf);
    }

    @Override
    public <S, U, That> That zipAll(GenIterable<S> that, U thisElem, S thatElem, CanBuildFrom<ParHashMap<K, V>, Tuple2<U, S>, That> bf) {
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
    public IterableView<Tuple2<K, V>, HashMap<K, V>> view() {
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
    public Combiner<Tuple2<K, V>, ParHashMap<K, V>> parCombiner() {
        return CustomParallelizable.parCombiner$(this);
    }

    @Override
    public <P, Q> Combiner<Tuple2<P, Q>, ParHashMap<P, Q>> genericMapCombiner() {
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
    public GenericParMapCompanion<ParHashMap> mapCompanion() {
        return ParHashMap$.MODULE$;
    }

    @Override
    public ParHashMap<K, V> empty() {
        return new ParHashMap<K, V>();
    }

    @Override
    public HashMapCombiner<K, V> newCombiner() {
        return HashMapCombiner$.MODULE$.apply();
    }

    @Override
    public IterableSplitter<Tuple2<K, V>> splitter() {
        return new ParHashMapIterator(this, this.trie.iterator(), this.trie.size());
    }

    @Override
    public HashMap<K, V> seq() {
        return this.trie;
    }

    @Override
    public ParHashMap<K, V> $minus(K k) {
        return new ParHashMap<K, V>(this.trie.$minus((Object)k));
    }

    @Override
    public <U> ParHashMap<K, U> $plus(Tuple2<K, U> kv) {
        return new ParHashMap<K, V>(this.trie.$plus(kv));
    }

    @Override
    public Option<V> get(K k) {
        return this.trie.get(k);
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

    public void printDebugInfo() {
        Predef$.MODULE$.println("Parallel hash trie");
        Predef$.MODULE$.println(new java.lang.StringBuilder(27).append("Top level inner trie type: ").append(this.trie.getClass()).toString());
        HashMap<K, V> hashMap = this.trie;
        if (hashMap instanceof HashMap.HashMap1) {
            HashMap.HashMap1 hashMap1 = (HashMap.HashMap1)hashMap;
            Predef$.MODULE$.println("single node type");
            Predef$.MODULE$.println(new java.lang.StringBuilder(12).append("key stored: ").append(hashMap1.getKey()).toString());
            Predef$.MODULE$.println(new java.lang.StringBuilder(13).append("hash of key: ").append(hashMap1.getHash()).toString());
            Predef$.MODULE$.println(new java.lang.StringBuilder(19).append("computed hash of ").append(hashMap1.getKey()).append(": ").append(hashMap1.computeHashFor(hashMap1.getKey())).toString());
            Predef$.MODULE$.println(new java.lang.StringBuilder(15).append("trie.get(key): ").append(hashMap1.get(hashMap1.getKey())).toString());
            return;
        }
        Predef$.MODULE$.println("other kind of node");
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

    public ParHashMap(HashMap<K, V> trie) {
        this.trie = trie;
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
        ParMapLike.$init$(this);
        ParMap.$init$(this);
        ParIterable.$init$(this);
        scala.collection.parallel.immutable.ParMap.$init$(this);
    }

    public ParHashMap() {
        this((HashMap<K, V>)HashMap$.MODULE$.empty());
    }

    public class ParHashMapIterator
    implements IterableSplitter<Tuple2<K, V>> {
        private Iterator<Tuple2<K, V>> triter;
        private final int sz;
        private int i;
        private Signalling signalDelegate;
        public final /* synthetic */ ParHashMap $outer;

        @Override
        public Seq<IterableSplitter<Tuple2<K, V>>> splitWithSignalling() {
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
        public boolean isRemainingCheap() {
            return RemainsIterator.isRemainingCheap$(this);
        }

        @Override
        public Iterator<Tuple2<K, V>> seq() {
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
        public Iterator<Tuple2<K, V>> sliceIterator(int from, int until) {
            return Iterator.sliceIterator$(this, from, until);
        }

        @Override
        public <B> Iterator<B> $plus$plus(Function0<GenTraversableOnce<B>> that) {
            return Iterator.$plus$plus$(this, that);
        }

        @Override
        public <B> Iterator<B> flatMap(Function1<Tuple2<K, V>, GenTraversableOnce<B>> f) {
            return Iterator.flatMap$(this, f);
        }

        @Override
        public Iterator<Tuple2<K, V>> filter(Function1<Tuple2<K, V>, Object> p) {
            return Iterator.filter$(this, p);
        }

        @Override
        public <B> boolean corresponds(GenTraversableOnce<B> that, Function2<Tuple2<K, V>, B, Object> p) {
            return Iterator.corresponds$(this, that, p);
        }

        @Override
        public Iterator<Tuple2<K, V>> withFilter(Function1<Tuple2<K, V>, Object> p) {
            return Iterator.withFilter$(this, p);
        }

        @Override
        public Iterator<Tuple2<K, V>> filterNot(Function1<Tuple2<K, V>, Object> p) {
            return Iterator.filterNot$(this, p);
        }

        @Override
        public <B> Iterator<B> collect(PartialFunction<Tuple2<K, V>, B> pf) {
            return Iterator.collect$(this, pf);
        }

        @Override
        public <B> Iterator<B> scanLeft(B z, Function2<B, Tuple2<K, V>, B> op) {
            return Iterator.scanLeft$(this, z, op);
        }

        @Override
        public <B> Iterator<B> scanRight(B z, Function2<Tuple2<K, V>, B, B> op) {
            return Iterator.scanRight$(this, z, op);
        }

        @Override
        public Iterator<Tuple2<K, V>> takeWhile(Function1<Tuple2<K, V>, Object> p) {
            return Iterator.takeWhile$(this, p);
        }

        @Override
        public Tuple2<Iterator<Tuple2<K, V>>, Iterator<Tuple2<K, V>>> partition(Function1<Tuple2<K, V>, Object> p) {
            return Iterator.partition$(this, p);
        }

        @Override
        public Tuple2<Iterator<Tuple2<K, V>>, Iterator<Tuple2<K, V>>> span(Function1<Tuple2<K, V>, Object> p) {
            return Iterator.span$(this, p);
        }

        @Override
        public Iterator<Tuple2<K, V>> dropWhile(Function1<Tuple2<K, V>, Object> p) {
            return Iterator.dropWhile$(this, p);
        }

        @Override
        public <B> Iterator<Tuple2<Tuple2<K, V>, B>> zip(Iterator<B> that) {
            return Iterator.zip$(this, that);
        }

        @Override
        public <A1> Iterator<A1> padTo(int len, A1 elem) {
            return Iterator.padTo$(this, len, elem);
        }

        @Override
        public Iterator<Tuple2<Tuple2<K, V>, Object>> zipWithIndex() {
            return Iterator.zipWithIndex$(this);
        }

        @Override
        public <B, A1, B1> Iterator<Tuple2<A1, B1>> zipAll(Iterator<B> that, A1 thisElem, B1 thatElem) {
            return Iterator.zipAll$(this, that, thisElem, thatElem);
        }

        @Override
        public <U> void foreach(Function1<Tuple2<K, V>, U> f) {
            Iterator.foreach$(this, f);
        }

        @Override
        public boolean forall(Function1<Tuple2<K, V>, Object> p) {
            return Iterator.forall$(this, p);
        }

        @Override
        public boolean exists(Function1<Tuple2<K, V>, Object> p) {
            return Iterator.exists$(this, p);
        }

        @Override
        public boolean contains(Object elem) {
            return Iterator.contains$(this, elem);
        }

        @Override
        public Option<Tuple2<K, V>> find(Function1<Tuple2<K, V>, Object> p) {
            return Iterator.find$(this, p);
        }

        @Override
        public int indexWhere(Function1<Tuple2<K, V>, Object> p) {
            return Iterator.indexWhere$(this, p);
        }

        @Override
        public int indexWhere(Function1<Tuple2<K, V>, Object> p, int from) {
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
        public BufferedIterator<Tuple2<K, V>> buffered() {
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
        public Tuple2<Iterator<Tuple2<K, V>>, Iterator<Tuple2<K, V>>> duplicate() {
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
        public Traversable<Tuple2<K, V>> toTraversable() {
            return Iterator.toTraversable$(this);
        }

        @Override
        public Iterator<Tuple2<K, V>> toIterator() {
            return Iterator.toIterator$(this);
        }

        @Override
        public Stream<Tuple2<K, V>> toStream() {
            return Iterator.toStream$(this);
        }

        @Override
        public List<Tuple2<K, V>> reversed() {
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
        public <B> Option<B> collectFirst(PartialFunction<Tuple2<K, V>, B> pf) {
            return TraversableOnce.collectFirst$(this, pf);
        }

        @Override
        public <B> B $div$colon(B z, Function2<B, Tuple2<K, V>, B> op) {
            return (B)TraversableOnce.$div$colon$(this, z, op);
        }

        @Override
        public <B> B $colon$bslash(B z, Function2<Tuple2<K, V>, B, B> op) {
            return (B)TraversableOnce.$colon$bslash$(this, z, op);
        }

        @Override
        public <B> B foldLeft(B z, Function2<B, Tuple2<K, V>, B> op) {
            return (B)TraversableOnce.foldLeft$(this, z, op);
        }

        @Override
        public <B> B foldRight(B z, Function2<Tuple2<K, V>, B, B> op) {
            return (B)TraversableOnce.foldRight$(this, z, op);
        }

        @Override
        public <B> B reduceLeft(Function2<B, Tuple2<K, V>, B> op) {
            return (B)TraversableOnce.reduceLeft$(this, op);
        }

        @Override
        public <B> B reduceRight(Function2<Tuple2<K, V>, B, B> op) {
            return (B)TraversableOnce.reduceRight$(this, op);
        }

        @Override
        public <B> Option<B> reduceLeftOption(Function2<B, Tuple2<K, V>, B> op) {
            return TraversableOnce.reduceLeftOption$(this, op);
        }

        @Override
        public <B> Option<B> reduceRightOption(Function2<Tuple2<K, V>, B, B> op) {
            return TraversableOnce.reduceRightOption$(this, op);
        }

        @Override
        public <A1> Option<A1> reduceOption(Function2<A1, A1, A1> op) {
            return TraversableOnce.reduceOption$(this, op);
        }

        @Override
        public <B> B aggregate(Function0<B> z, Function2<B, Tuple2<K, V>, B> seqop, Function2<B, B, B> combop) {
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
        public List<Tuple2<K, V>> toList() {
            return TraversableOnce.toList$(this);
        }

        @Override
        public Iterable<Tuple2<K, V>> toIterable() {
            return TraversableOnce.toIterable$(this);
        }

        @Override
        public Seq<Tuple2<K, V>> toSeq() {
            return TraversableOnce.toSeq$(this);
        }

        @Override
        public IndexedSeq<Tuple2<K, V>> toIndexedSeq() {
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
        public Vector<Tuple2<K, V>> toVector() {
            return TraversableOnce.toVector$(this);
        }

        @Override
        public <Col> Col to(CanBuildFrom<Nothing$, Tuple2<K, V>, Col> cbf) {
            return (Col)TraversableOnce.to$(this, cbf);
        }

        @Override
        public <T, U> Map<T, U> toMap(Predef$.less.colon.less<Tuple2<K, V>, Tuple2<T, U>> ev) {
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

        public Iterator<Tuple2<K, V>> triter() {
            return this.triter;
        }

        public void triter_$eq(Iterator<Tuple2<K, V>> x$1) {
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
        public IterableSplitter<Tuple2<K, V>> dup() {
            ParHashMapIterator parHashMapIterator;
            Iterator iterator2 = this.triter();
            if (iterator2 instanceof TrieIterator) {
                TrieIterator trieIterator = (TrieIterator)iterator2;
                parHashMapIterator = this.dupFromIterator(trieIterator.dupIterator());
            } else {
                Buffer buff = this.triter().toBuffer();
                this.triter_$eq(buff.iterator());
                parHashMapIterator = this.dupFromIterator(buff.iterator());
            }
            return parHashMapIterator;
        }

        /*
         * WARNING - void declaration
         */
        private ParHashMapIterator dupFromIterator(Iterator<Tuple2<K, V>> it) {
            void var2_2;
            ParHashMapIterator phit = new ParHashMapIterator(this.scala$collection$parallel$immutable$ParHashMap$ParHashMapIterator$$$outer(), it, this.sz());
            phit.i_$eq(this.i());
            return var2_2;
        }

        @Override
        public Seq<IterableSplitter<Tuple2<K, V>>> split() {
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
                    seq = new $colon$colon<Nothing$>((Nothing$)((Object)new ParHashMapIterator(this.scala$collection$parallel$immutable$ParHashMap$ParHashMapIterator$$$outer(), iterator4, n)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)new ParHashMapIterator(this.scala$collection$parallel$immutable$ParHashMap$ParHashMapIterator$$$outer(), iterator2, sndlength)), Nil$.MODULE$));
                    break block8;
                }
                Buffer buff = this.triter().toBuffer();
                Tuple2 tuple2 = buff.splitAt(buff.length() / 2);
                if (tuple2 == null) {
                    throw new MatchError((Object)null);
                }
                Buffer buffer = (Buffer)tuple2._1();
                Buffer buffer2 = (Buffer)tuple2._2();
                seq = new $colon$colon<Nothing$>((Nothing$)((Object)buffer), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)buffer2), Nil$.MODULE$)).map((Function1<Buffer, ParHashMapIterator> & java.io.Serializable & Serializable)b -> new ParHashMapIterator(this.scala$collection$parallel$immutable$ParHashMap$ParHashMapIterator$$$outer(), b.iterator(), b.length()), Seq$.MODULE$.canBuildFrom());
            }
            return seq;
        }

        @Override
        public Tuple2<K, V> next() {
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

        @Override
        public String toString() {
            return new java.lang.StringBuilder(18).append("HashTrieIterator(").append(this.sz()).append(")").toString();
        }

        public /* synthetic */ ParHashMap scala$collection$parallel$immutable$ParHashMap$ParHashMapIterator$$$outer() {
            return this.$outer;
        }

        public ParHashMapIterator(ParHashMap $outer, Iterator<Tuple2<K, V>> triter, int sz) {
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

