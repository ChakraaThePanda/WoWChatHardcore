/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import java.util.NoSuchElementException;
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
import scala.collection.GenSet;
import scala.collection.GenSetLike;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.IterableView;
import scala.collection.Iterator;
import scala.collection.Map;
import scala.collection.MapLike;
import scala.collection.Parallel;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.Set;
import scala.collection.Traversable;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.DelegatedSignalling;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericParMapCompanion;
import scala.collection.generic.GenericParMapTemplate;
import scala.collection.generic.GenericParTemplate;
import scala.collection.generic.GenericSetTemplate;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.generic.Signalling;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.AugmentedIterableIterator;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.CombinerFactory;
import scala.collection.parallel.IterableSplitter;
import scala.collection.parallel.ParIterable;
import scala.collection.parallel.ParIterableLike;
import scala.collection.parallel.ParIterableLike$ScanLeaf$;
import scala.collection.parallel.ParIterableLike$ScanNode$;
import scala.collection.parallel.ParMap;
import scala.collection.parallel.ParMap$;
import scala.collection.parallel.ParMapLike$;
import scala.collection.parallel.ParSeq;
import scala.collection.parallel.ParSet;
import scala.collection.parallel.ParSet$;
import scala.collection.parallel.ParSetLike;
import scala.collection.parallel.RemainsIterator;
import scala.collection.parallel.SeqSplitter;
import scala.collection.parallel.Splitter;
import scala.collection.parallel.TaskSupport;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.LambdaDeserialize;
import scala.runtime.Nothing$;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@ScalaSignature(bytes="\u0006\u0001\u00055ga\u0002\u0011\"!\u0003\r\t\u0001\u000b\u0005\u0006=\u0002!\ta\u0018\u0005\u0006G\u0002!\t\u0001\u001a\u0005\u0006O\u00021\t\u0001\u001b\u0005\u0006S\u0002!\tA\u001b\u0005\u0006Y\u0002!\t!\u001c\u0005\u0006q\u0002!\t!\u001f\u0005\u0006}\u0002!\ta \u0005\t\u0003\u0007\u0001\u0001\u0015\"\u0003\u0002\u0006!9\u00111\u0001\u0001\u0005\u0002\u0005\u001d\u0002\u0002CA\u0015\u0001\u0001&I!a\u000b\t\u000f\u0005%\u0002\u0001\"\u0001\u00022\u00191\u00111\u0007\u0001\t\u0003kAq!!\u0010\r\t\u0003\ty\u0004\u0003\u0004y\u0019\u0011\u0005\u0011Q\t\u0005\b\u0003\u0013bA\u0011AA\u0014\u0011\u001d\tY\u0005\u0004C\u0001\u0003\u001bBq!a\u0015\r\t\u0003\t)\u0006C\u0004\u0002Z1!\t%a\u0017\t\u000f\u0005\rD\u0002\"\u0011\u0002f!9\u0011q\u000f\u0007\u0005B\u0005edABAA\u0001!\t\u0019\tC\u0004\u0002>U!\t!a#\t\u000f\u0005%S\u0003\"\u0001\u00022!9\u0011\u0011L\u000b\u0005B\u0005m\u0003bBA2+\u0011\u0005\u0013q\u0012\u0005\b\u0003o*B\u0011AAN\u0011\u001d\t\u0019\u000b\u0001C\u0001\u0003KCq!a*\u0001\t\u0003\tI\u000bC\u0004\u0002.\u0002!\t!a,\t\u000f\u0005E\u0006\u0001\"\u0001\u00024\"9\u00111\u0018\u0001\u0005\u0002\u0005u&A\u0003)be6\u000b\u0007\u000fT5lK*\u0011!eI\u0001\ta\u0006\u0014\u0018\r\u001c7fY*\u0011A%J\u0001\u000bG>dG.Z2uS>t'\"\u0001\u0014\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U)\u0011\u0006\u000e B\u0015N!\u0001A\u000b\u0018Y!\tYC&D\u0001&\u0013\tiSE\u0001\u0004B]f\u0014VM\u001a\t\u0006_A\u0012T\bQ\u0007\u0002G%\u0011\u0011g\t\u0002\u000b\u000f\u0016tW*\u00199MS.,\u0007CA\u001a5\u0019\u0001!Q!\u000e\u0001C\u0002Y\u0012\u0011aS\t\u0003oi\u0002\"a\u000b\u001d\n\u0005e*#a\u0002(pi\"Lgn\u001a\t\u0003WmJ!\u0001P\u0013\u0003\u0007\u0005s\u0017\u0010\u0005\u00024}\u00111q\b\u0001CC\u0002Y\u0012\u0011A\u0016\t\u0003g\u0005#aA\u0011\u0001\u0005\u0006\u0004\u0019%\u0001\u0002*faJ\f\"a\u000e#\u0013\u0007\u0015;UK\u0002\u0003G\u0001\u0001!%\u0001\u0004\u001fsK\u001aLg.Z7f]Rt\u0004C\u0002%\u0001eu\u0002\u0015*D\u0001\"!\t\u0019$\n\u0002\u0004L\u0001\u0011\u0015\r\u0001\u0014\u0002\u000b'\u0016\fX/\u001a8uS\u0006d\u0017CA\u001cN%\rquJ\u0015\u0004\u0005\r\u0002\u0001Q\n\u0005\u00030!Jj\u0014BA)$\u0005\ri\u0015\r\u001d\t\u0006_M\u0013T(S\u0005\u0003)\u000e\u0012q!T1q\u0019&\\W\r\u0005\u0003I-Jj\u0014BA,\"\u0005\u0019\u0001\u0016M]'baB)\u0001*W.A\u0013&\u0011!,\t\u0002\u0010!\u0006\u0014\u0018\n^3sC\ndW\rT5lKB!1\u0006\u0018\u001a>\u0013\tiVE\u0001\u0004UkBdWMM\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0015\u0003\u0001\u0004\"aK1\n\u0005\t,#\u0001B+oSR\fq\u0001Z3gCVdG\u000f\u0006\u0002>K\")aM\u0001a\u0001e\u0005\u00191.Z=\u0002\u000b\u0015l\u0007\u000f^=\u0016\u0003\u0001\u000bQ!\u00199qYf$\"!P6\t\u000b\u0019$\u0001\u0019\u0001\u001a\u0002\u0013\u001d,Go\u0014:FYN,WC\u00018q)\ry7\u000f\u001e\t\u0003gA$Q!]\u0003C\u0002I\u0014\u0011!V\t\u0003{iBQAZ\u0003A\u0002IBaaY\u0003\u0005\u0002\u0004)\bcA\u0016w_&\u0011q/\n\u0002\ty\tLh.Y7f}\u0005A1m\u001c8uC&t7\u000f\u0006\u0002{{B\u00111f_\u0005\u0003y\u0016\u0012qAQ8pY\u0016\fg\u000eC\u0003g\r\u0001\u0007!'A\u0006jg\u0012+g-\u001b8fI\u0006#Hc\u0001>\u0002\u0002!)am\u0002a\u0001e\u0005a1.Z=t\u0013R,'/\u0019;peR!\u0011qAA\u0007!\u0011A\u0015\u0011\u0002\u001a\n\u0007\u0005-\u0011E\u0001\tJi\u0016\u0014\u0018M\u00197f'Bd\u0017\u000e\u001e;fe\"9\u0011q\u0002\u0005A\u0002\u0005E\u0011!A:+\t\u0005M\u0011Q\u0003\t\u0005\u0011\u0006%1l\u000b\u0002\u0002\u0018A!\u0011\u0011DA\u0012\u001b\t\tYB\u0003\u0003\u0002\u001e\u0005}\u0011!C;oG\",7m[3e\u0015\r\t\t#J\u0001\u000bC:tw\u000e^1uS>t\u0017\u0002BA\u0013\u00037\u0011\u0011#\u001e8dQ\u0016\u001c7.\u001a3WCJL\u0017M\\2f+\t\t9!\u0001\bwC2,Xm]%uKJ\fGo\u001c:\u0015\t\u00055\u0012q\u0006\t\u0005\u0011\u0006%Q\bC\u0004\u0002\u0010)\u0001\r!!\u0005\u0016\u0005\u00055\"!\u0004#fM\u0006,H\u000e^&fsN+Go\u0005\u0003\rU\u0005]\u0002\u0003\u0002%\u0002:IJ1!a\u000f\"\u0005\u0019\u0001\u0016M]*fi\u00061A(\u001b8jiz\"\"!!\u0011\u0011\u0007\u0005\rC\"D\u0001\u0001)\rQ\u0018q\t\u0005\u0006M:\u0001\rAM\u0001\tgBd\u0017\u000e\u001e;fe\u0006)A\u0005\u001d7vgR!\u0011qGA(\u0011\u0019\t\t\u0006\u0005a\u0001e\u0005!Q\r\\3n\u0003\u0019!S.\u001b8vgR!\u0011qGA,\u0011\u0019\t\t&\u0005a\u0001e\u0005!1/\u001b>f+\t\ti\u0006E\u0002,\u0003?J1!!\u0019&\u0005\rIe\u000e^\u0001\bM>\u0014X-Y2i+\u0011\t9'!\u001e\u0015\u0007\u0001\fI\u0007C\u0004\u0002lM\u0001\r!!\u001c\u0002\u0003\u0019\u0004baKA8e\u0005M\u0014bAA9K\tIa)\u001e8di&|g.\r\t\u0004g\u0005UD!B9\u0014\u0005\u00041\u0014aA:fcV\u0011\u00111\u0010\t\u0005_\u0005u$'C\u0002\u0002\u0000\r\u00121aU3u\u0005U!UMZ1vYR4\u0016\r\\;fg&#XM]1cY\u0016\u001cB!\u0006\u0016\u0002\u0006B!\u0001*a\">\u0013\r\tI)\t\u0002\f!\u0006\u0014\u0018\n^3sC\ndW\r\u0006\u0002\u0002\u000eB\u0019\u00111I\u000b\u0016\t\u0005E\u0015\u0011\u0014\u000b\u0004A\u0006M\u0005bBA63\u0001\u0007\u0011Q\u0013\t\u0007W\u0005=T(a&\u0011\u0007M\nI\nB\u0003r3\t\u0007a'\u0006\u0002\u0002\u001eB!q&a(>\u0013\r\t\tk\t\u0002\t\u0013R,'/\u00192mK\u000611.Z=TKR,\"!a\u000e\u0002\t-,\u0017p]\u000b\u0003\u0003W\u0003B\u0001SADe\u00051a/\u00197vKN,\"!!\"\u0002\u0015\u0019LG\u000e^3s\u0017\u0016L8\u000fF\u0002V\u0003kCq!a.\u001f\u0001\u0004\tI,A\u0001q!\u0015Y\u0013q\u000e\u001a{\u0003%i\u0017\r\u001d,bYV,7/\u0006\u0003\u0002@\u0006\u0015G\u0003BAa\u0003\u0013\u0004R\u0001\u0013,3\u0003\u0007\u00042aMAc\t\u0019\t9m\bb\u0001m\t\t1\u000bC\u0004\u0002l}\u0001\r!a3\u0011\r-\ny'PAb\u0001")
public interface ParMapLike<K, V, Repr extends ParMapLike<K, V, Repr, Sequential> & ParMap<K, V>, Sequential extends Map<K, V> & MapLike<K, V, Sequential>>
extends GenMapLike<K, V, Repr>,
ParIterableLike<Tuple2<K, V>, Repr, Sequential> {
    public static /* synthetic */ Object default$(ParMapLike $this, Object key) {
        return $this.default(key);
    }

    @Override
    default public V default(K key) {
        throw new NoSuchElementException(new java.lang.StringBuilder(15).append("key not found: ").append(key).toString());
    }

    public Repr empty();

    public static /* synthetic */ Object apply$(ParMapLike $this, Object key) {
        return $this.apply(key);
    }

    @Override
    default public V apply(K key) {
        Object object;
        Option option = this.get(key);
        if (option instanceof Some) {
            object = ((Some)option).value();
        } else if (None$.MODULE$.equals(option)) {
            object = this.default(key);
        } else {
            throw new MatchError(option);
        }
        return (V)object;
    }

    public static /* synthetic */ Object getOrElse$(ParMapLike $this, Object key, Function0 function0) {
        return $this.getOrElse((K)key, function0);
    }

    @Override
    default public <U> U getOrElse(K key, Function0<U> function0) {
        Object object;
        Option option = this.get(key);
        if (option instanceof Some) {
            object = ((Some)option).value();
        } else if (None$.MODULE$.equals(option)) {
            object = function0.apply();
        } else {
            throw new MatchError(option);
        }
        return (U)object;
    }

    public static /* synthetic */ boolean contains$(ParMapLike $this, Object key) {
        return $this.contains(key);
    }

    @Override
    default public boolean contains(K key) {
        return this.get(key).isDefined();
    }

    public static /* synthetic */ boolean isDefinedAt$(ParMapLike $this, Object key) {
        return $this.isDefinedAt(key);
    }

    @Override
    default public boolean isDefinedAt(K key) {
        return this.contains(key);
    }

    public static /* synthetic */ IterableSplitter scala$collection$parallel$ParMapLike$$keysIterator$(ParMapLike $this, IterableSplitter s) {
        return $this.scala$collection$parallel$ParMapLike$$keysIterator(s);
    }

    default public IterableSplitter<K> scala$collection$parallel$ParMapLike$$keysIterator(IterableSplitter<Tuple2<K, V>> s) {
        return new IterableSplitter<K>(this, s){
            private final IterableSplitter<Tuple2<K, V>> iter;
            private Signalling signalDelegate;
            private final /* synthetic */ ParMapLike $outer;

            public Seq<IterableSplitter<K>> splitWithSignalling() {
                return IterableSplitter.splitWithSignalling$(this);
            }

            public <S> boolean shouldSplitFurther(ParIterable<S> coll, int parallelismLevel) {
                return IterableSplitter.shouldSplitFurther$(this, coll, parallelismLevel);
            }

            public String buildString(Function1<Function1<String, BoxedUnit>, BoxedUnit> closure) {
                return IterableSplitter.buildString$(this, closure);
            }

            public String debugInformation() {
                return IterableSplitter.debugInformation$(this);
            }

            public IterableSplitter.Taken newTaken(int until) {
                return IterableSplitter.newTaken$(this, until);
            }

            public <U extends IterableSplitter.Taken> U newSliceInternal(U it, int from1) {
                return (U)IterableSplitter.newSliceInternal$(this, it, from1);
            }

            public IterableSplitter<K> drop(int n) {
                return IterableSplitter.drop$(this, n);
            }

            public IterableSplitter<K> take(int n) {
                return IterableSplitter.take$(this, n);
            }

            public IterableSplitter<K> slice(int from1, int until1) {
                return IterableSplitter.slice$(this, from1, until1);
            }

            public <S> IterableSplitter.Mapped<S> map(Function1<K, S> f) {
                return IterableSplitter.map$(this, f);
            }

            public <U, PI extends IterableSplitter<U>> IterableSplitter.Appended<U, PI> appendParIterable(PI that) {
                return IterableSplitter.appendParIterable$(this, that);
            }

            public <S> IterableSplitter.Zipped<S> zipParSeq(SeqSplitter<S> that) {
                return IterableSplitter.zipParSeq$(this, that);
            }

            public <S, U, R> IterableSplitter.ZippedAll<U, R> zipAllParSeq(SeqSplitter<S> that, U thisElem, R thatElem) {
                return IterableSplitter.zipAllParSeq$(this, that, thisElem, thatElem);
            }

            public boolean isAborted() {
                return DelegatedSignalling.isAborted$(this);
            }

            public void abort() {
                DelegatedSignalling.abort$(this);
            }

            public int indexFlag() {
                return DelegatedSignalling.indexFlag$(this);
            }

            public void setIndexFlag(int f) {
                DelegatedSignalling.setIndexFlag$(this, f);
            }

            public void setIndexFlagIfGreater(int f) {
                DelegatedSignalling.setIndexFlagIfGreater$(this, f);
            }

            public void setIndexFlagIfLesser(int f) {
                DelegatedSignalling.setIndexFlagIfLesser$(this, f);
            }

            public int tag() {
                return DelegatedSignalling.tag$(this);
            }

            public int count(Function1<K, Object> p) {
                return AugmentedIterableIterator.count$(this, p);
            }

            public <U> U reduce(Function2<U, U, U> op) {
                return (U)AugmentedIterableIterator.reduce$(this, op);
            }

            public <U> U fold(U z, Function2<U, U, U> op) {
                return (U)AugmentedIterableIterator.fold$(this, z, op);
            }

            public <U> U sum(Numeric<U> num) {
                return (U)AugmentedIterableIterator.sum$(this, num);
            }

            public <U> U product(Numeric<U> num) {
                return (U)AugmentedIterableIterator.product$(this, num);
            }

            public <U> K min(Ordering<U> ord) {
                return (K)AugmentedIterableIterator.min$(this, ord);
            }

            public <U> K max(Ordering<U> ord) {
                return (K)AugmentedIterableIterator.max$(this, ord);
            }

            public <U> void copyToArray(Object array, int from, int len) {
                AugmentedIterableIterator.copyToArray$(this, array, from, len);
            }

            public <U> U reduceLeft(int howmany, Function2<U, U, U> op) {
                return (U)AugmentedIterableIterator.reduceLeft$(this, howmany, op);
            }

            public <S, That> Combiner<S, That> map2combiner(Function1<K, S> f, Combiner<S, That> cb) {
                return AugmentedIterableIterator.map2combiner$(this, f, cb);
            }

            public <S, That> Combiner<S, That> collect2combiner(PartialFunction<K, S> pf, Combiner<S, That> cb) {
                return AugmentedIterableIterator.collect2combiner$(this, pf, cb);
            }

            public <S, That> Combiner<S, That> flatmap2combiner(Function1<K, GenTraversableOnce<S>> f, Combiner<S, That> cb) {
                return AugmentedIterableIterator.flatmap2combiner$(this, f, cb);
            }

            public <U, Coll, Bld extends Builder<U, Coll>> Bld copy2builder(Bld b) {
                return (Bld)AugmentedIterableIterator.copy2builder$(this, b);
            }

            public <U, This> Combiner<U, This> filter2combiner(Function1<K, Object> pred, Combiner<U, This> cb) {
                return AugmentedIterableIterator.filter2combiner$(this, pred, cb);
            }

            public <U, This> Combiner<U, This> filterNot2combiner(Function1<K, Object> pred, Combiner<U, This> cb) {
                return AugmentedIterableIterator.filterNot2combiner$(this, pred, cb);
            }

            public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> partition2combiners(Function1<K, Object> pred, Combiner<U, This> btrue, Combiner<U, This> bfalse) {
                return AugmentedIterableIterator.partition2combiners$(this, pred, btrue, bfalse);
            }

            public <U, This> Combiner<U, This> take2combiner(int n, Combiner<U, This> cb) {
                return AugmentedIterableIterator.take2combiner$(this, n, cb);
            }

            public <U, This> Combiner<U, This> drop2combiner(int n, Combiner<U, This> cb) {
                return AugmentedIterableIterator.drop2combiner$(this, n, cb);
            }

            public <U, This> Combiner<U, This> slice2combiner(int from, int until, Combiner<U, This> cb) {
                return AugmentedIterableIterator.slice2combiner$(this, from, until, cb);
            }

            public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> splitAt2combiners(int at, Combiner<U, This> before, Combiner<U, This> after) {
                return AugmentedIterableIterator.splitAt2combiners$(this, at, before, after);
            }

            public <U, This> Tuple2<Combiner<U, This>, Object> takeWhile2combiner(Function1<K, Object> p, Combiner<U, This> cb) {
                return AugmentedIterableIterator.takeWhile2combiner$(this, p, cb);
            }

            public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> span2combiners(Function1<K, Object> p, Combiner<U, This> before, Combiner<U, This> after) {
                return AugmentedIterableIterator.span2combiners$(this, p, before, after);
            }

            public <U, A> void scanToArray(U z, Function2<U, U, U> op, Object array, int from) {
                AugmentedIterableIterator.scanToArray$(this, z, op, array, from);
            }

            public <U, That> Combiner<U, That> scanToCombiner(U startValue, Function2<U, U, U> op, Combiner<U, That> cb) {
                return AugmentedIterableIterator.scanToCombiner$(this, startValue, op, cb);
            }

            public <U, That> Combiner<U, That> scanToCombiner(int howmany, U startValue, Function2<U, U, U> op, Combiner<U, That> cb) {
                return AugmentedIterableIterator.scanToCombiner$(this, howmany, startValue, op, cb);
            }

            public <U, S, That> Combiner<Tuple2<U, S>, That> zip2combiner(RemainsIterator<S> otherpit, Combiner<Tuple2<U, S>, That> cb) {
                return AugmentedIterableIterator.zip2combiner$(this, otherpit, cb);
            }

            public <U, S, That> Combiner<Tuple2<U, S>, That> zipAll2combiner(RemainsIterator<S> that, U thiselem, S thatelem, Combiner<Tuple2<U, S>, That> cb) {
                return AugmentedIterableIterator.zipAll2combiner$(this, that, thiselem, thatelem, cb);
            }

            public boolean isRemainingCheap() {
                return RemainsIterator.isRemainingCheap$(this);
            }

            public Iterator<K> seq() {
                return Iterator.seq$(this);
            }

            public boolean isEmpty() {
                return Iterator.isEmpty$(this);
            }

            public boolean isTraversableAgain() {
                return Iterator.isTraversableAgain$(this);
            }

            public boolean hasDefiniteSize() {
                return Iterator.hasDefiniteSize$(this);
            }

            public Iterator<K> sliceIterator(int from, int until) {
                return Iterator.sliceIterator$(this, from, until);
            }

            public <B> Iterator<B> $plus$plus(Function0<GenTraversableOnce<B>> that) {
                return Iterator.$plus$plus$(this, that);
            }

            public <B> Iterator<B> flatMap(Function1<K, GenTraversableOnce<B>> f) {
                return Iterator.flatMap$(this, f);
            }

            public Iterator<K> filter(Function1<K, Object> p) {
                return Iterator.filter$(this, p);
            }

            public <B> boolean corresponds(GenTraversableOnce<B> that, Function2<K, B, Object> p) {
                return Iterator.corresponds$(this, that, p);
            }

            public Iterator<K> withFilter(Function1<K, Object> p) {
                return Iterator.withFilter$(this, p);
            }

            public Iterator<K> filterNot(Function1<K, Object> p) {
                return Iterator.filterNot$(this, p);
            }

            public <B> Iterator<B> collect(PartialFunction<K, B> pf) {
                return Iterator.collect$(this, pf);
            }

            public <B> Iterator<B> scanLeft(B z, Function2<B, K, B> op) {
                return Iterator.scanLeft$(this, z, op);
            }

            public <B> Iterator<B> scanRight(B z, Function2<K, B, B> op) {
                return Iterator.scanRight$(this, z, op);
            }

            public Iterator<K> takeWhile(Function1<K, Object> p) {
                return Iterator.takeWhile$(this, p);
            }

            public Tuple2<Iterator<K>, Iterator<K>> partition(Function1<K, Object> p) {
                return Iterator.partition$(this, p);
            }

            public Tuple2<Iterator<K>, Iterator<K>> span(Function1<K, Object> p) {
                return Iterator.span$(this, p);
            }

            public Iterator<K> dropWhile(Function1<K, Object> p) {
                return Iterator.dropWhile$(this, p);
            }

            public <B> Iterator<Tuple2<K, B>> zip(Iterator<B> that) {
                return Iterator.zip$(this, that);
            }

            public <A1> Iterator<A1> padTo(int len, A1 elem) {
                return Iterator.padTo$(this, len, elem);
            }

            public Iterator<Tuple2<K, Object>> zipWithIndex() {
                return Iterator.zipWithIndex$(this);
            }

            public <B, A1, B1> Iterator<Tuple2<A1, B1>> zipAll(Iterator<B> that, A1 thisElem, B1 thatElem) {
                return Iterator.zipAll$(this, that, thisElem, thatElem);
            }

            public <U> void foreach(Function1<K, U> f) {
                Iterator.foreach$(this, f);
            }

            public boolean forall(Function1<K, Object> p) {
                return Iterator.forall$(this, p);
            }

            public boolean exists(Function1<K, Object> p) {
                return Iterator.exists$(this, p);
            }

            public boolean contains(Object elem) {
                return Iterator.contains$(this, elem);
            }

            public Option<K> find(Function1<K, Object> p) {
                return Iterator.find$(this, p);
            }

            public int indexWhere(Function1<K, Object> p) {
                return Iterator.indexWhere$(this, p);
            }

            public int indexWhere(Function1<K, Object> p, int from) {
                return Iterator.indexWhere$(this, p, from);
            }

            public <B> int indexOf(B elem) {
                return Iterator.indexOf$(this, elem);
            }

            public <B> int indexOf(B elem, int from) {
                return Iterator.indexOf$(this, elem, from);
            }

            public BufferedIterator<K> buffered() {
                return Iterator.buffered$(this);
            }

            public <B> Iterator.GroupedIterator<B> grouped(int size) {
                return Iterator.grouped$(this, size);
            }

            public <B> Iterator.GroupedIterator<B> sliding(int size, int step) {
                return Iterator.sliding$(this, size, step);
            }

            public <B> int sliding$default$2() {
                return Iterator.sliding$default$2$(this);
            }

            public int length() {
                return Iterator.length$(this);
            }

            public Tuple2<Iterator<K>, Iterator<K>> duplicate() {
                return Iterator.duplicate$(this);
            }

            public <B> Iterator<B> patch(int from, Iterator<B> patchElems, int replaced) {
                return Iterator.patch$(this, from, patchElems, replaced);
            }

            public boolean sameElements(Iterator<?> that) {
                return Iterator.sameElements$(this, that);
            }

            public Traversable<K> toTraversable() {
                return Iterator.toTraversable$(this);
            }

            public Iterator<K> toIterator() {
                return Iterator.toIterator$(this);
            }

            public Stream<K> toStream() {
                return Iterator.toStream$(this);
            }

            public String toString() {
                return Iterator.toString$(this);
            }

            public List<K> reversed() {
                return TraversableOnce.reversed$(this);
            }

            public int size() {
                return TraversableOnce.size$(this);
            }

            public boolean nonEmpty() {
                return TraversableOnce.nonEmpty$(this);
            }

            public <B> Option<B> collectFirst(PartialFunction<K, B> pf) {
                return TraversableOnce.collectFirst$(this, pf);
            }

            public <B> B $div$colon(B z, Function2<B, K, B> op) {
                return (B)TraversableOnce.$div$colon$(this, z, op);
            }

            public <B> B $colon$bslash(B z, Function2<K, B, B> op) {
                return (B)TraversableOnce.$colon$bslash$(this, z, op);
            }

            public <B> B foldLeft(B z, Function2<B, K, B> op) {
                return (B)TraversableOnce.foldLeft$(this, z, op);
            }

            public <B> B foldRight(B z, Function2<K, B, B> op) {
                return (B)TraversableOnce.foldRight$(this, z, op);
            }

            public <B> B reduceLeft(Function2<B, K, B> op) {
                return (B)TraversableOnce.reduceLeft$(this, op);
            }

            public <B> B reduceRight(Function2<K, B, B> op) {
                return (B)TraversableOnce.reduceRight$(this, op);
            }

            public <B> Option<B> reduceLeftOption(Function2<B, K, B> op) {
                return TraversableOnce.reduceLeftOption$(this, op);
            }

            public <B> Option<B> reduceRightOption(Function2<K, B, B> op) {
                return TraversableOnce.reduceRightOption$(this, op);
            }

            public <A1> Option<A1> reduceOption(Function2<A1, A1, A1> op) {
                return TraversableOnce.reduceOption$(this, op);
            }

            public <B> B aggregate(Function0<B> z, Function2<B, K, B> seqop, Function2<B, B, B> combop) {
                return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
            }

            public <B> K maxBy(Function1<K, B> f, Ordering<B> cmp) {
                return (K)TraversableOnce.maxBy$(this, f, cmp);
            }

            public <B> K minBy(Function1<K, B> f, Ordering<B> cmp) {
                return (K)TraversableOnce.minBy$(this, f, cmp);
            }

            public <B> void copyToBuffer(Buffer<B> dest) {
                TraversableOnce.copyToBuffer$(this, dest);
            }

            public <B> void copyToArray(Object xs, int start) {
                TraversableOnce.copyToArray$(this, xs, start);
            }

            public <B> void copyToArray(Object xs) {
                TraversableOnce.copyToArray$(this, xs);
            }

            public <B> Object toArray(ClassTag<B> evidence$1) {
                return TraversableOnce.toArray$(this, evidence$1);
            }

            public List<K> toList() {
                return TraversableOnce.toList$(this);
            }

            public Iterable<K> toIterable() {
                return TraversableOnce.toIterable$(this);
            }

            public Seq<K> toSeq() {
                return TraversableOnce.toSeq$(this);
            }

            public IndexedSeq<K> toIndexedSeq() {
                return TraversableOnce.toIndexedSeq$(this);
            }

            public <B> Buffer<B> toBuffer() {
                return TraversableOnce.toBuffer$(this);
            }

            public <B> scala.collection.immutable.Set<B> toSet() {
                return TraversableOnce.toSet$(this);
            }

            public Vector<K> toVector() {
                return TraversableOnce.toVector$(this);
            }

            public <Col> Col to(CanBuildFrom<Nothing$, K, Col> cbf) {
                return (Col)TraversableOnce.to$(this, cbf);
            }

            public <T, U> scala.collection.immutable.Map<T, U> toMap(Predef$.less.colon.less<K, Tuple2<T, U>> ev) {
                return TraversableOnce.toMap$(this, ev);
            }

            public String mkString(String start, String sep, String end) {
                return TraversableOnce.mkString$(this, start, sep, end);
            }

            public String mkString(String sep) {
                return TraversableOnce.mkString$(this, sep);
            }

            public String mkString() {
                return TraversableOnce.mkString$(this);
            }

            public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
                return TraversableOnce.addString$(this, b, start, sep, end);
            }

            public StringBuilder addString(StringBuilder b, String sep) {
                return TraversableOnce.addString$(this, b, sep);
            }

            public StringBuilder addString(StringBuilder b) {
                return TraversableOnce.addString$(this, b);
            }

            public int sizeHintIfCheap() {
                return GenTraversableOnce.sizeHintIfCheap$(this);
            }

            public Signalling signalDelegate() {
                return this.signalDelegate;
            }

            public void signalDelegate_$eq(Signalling x$1) {
                this.signalDelegate = x$1;
            }

            private IterableSplitter<Tuple2<K, V>> iter() {
                return this.iter;
            }

            public boolean hasNext() {
                return this.iter().hasNext();
            }

            public K next() {
                return (K)((Tuple2)this.iter().next())._1();
            }

            /*
             * WARNING - void declaration
             */
            public Seq<IterableSplitter<K>> split() {
                void var1_1;
                Seq<A> ss = this.iter().split().map((Function1<IterableSplitter, IterableSplitter> & java.io.Serializable & Serializable)x$1 -> $this.$outer.scala$collection$parallel$ParMapLike$$keysIterator(x$1), Seq$.MODULE$.canBuildFrom());
                ss.foreach((Function1<IterableSplitter, Object> & java.io.Serializable & Serializable)(A x$2) -> {
                    $anon$1.$anonfun$split$2(this, x$2);
                    return BoxedUnit.UNIT;
                });
                return var1_1;
            }

            public int remaining() {
                return this.iter().remaining();
            }

            public IterableSplitter<K> dup() {
                return this.$outer.scala$collection$parallel$ParMapLike$$keysIterator(this.iter().dup());
            }

            public static final /* synthetic */ void $anonfun$split$2($anon$1 $this, IterableSplitter x$2) {
                x$2.signalDelegate_$eq($this.signalDelegate());
            }
            {
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
                this.iter = s$1;
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$split$1(scala.collection.parallel.ParMapLike$$anon$1 scala.collection.parallel.IterableSplitter ), $anonfun$split$2$adapted(scala.collection.parallel.ParMapLike$$anon$1 scala.collection.parallel.IterableSplitter )}, serializedLambda);
            }
        };
    }

    public static /* synthetic */ IterableSplitter keysIterator$(ParMapLike $this) {
        return $this.keysIterator();
    }

    @Override
    default public IterableSplitter<K> keysIterator() {
        return this.scala$collection$parallel$ParMapLike$$keysIterator(this.splitter());
    }

    public static /* synthetic */ IterableSplitter scala$collection$parallel$ParMapLike$$valuesIterator$(ParMapLike $this, IterableSplitter s) {
        return $this.scala$collection$parallel$ParMapLike$$valuesIterator(s);
    }

    default public IterableSplitter<V> scala$collection$parallel$ParMapLike$$valuesIterator(IterableSplitter<Tuple2<K, V>> s) {
        return new IterableSplitter<V>(this, s){
            private final IterableSplitter<Tuple2<K, V>> iter;
            private Signalling signalDelegate;
            private final /* synthetic */ ParMapLike $outer;

            public Seq<IterableSplitter<V>> splitWithSignalling() {
                return IterableSplitter.splitWithSignalling$(this);
            }

            public <S> boolean shouldSplitFurther(ParIterable<S> coll, int parallelismLevel) {
                return IterableSplitter.shouldSplitFurther$(this, coll, parallelismLevel);
            }

            public String buildString(Function1<Function1<String, BoxedUnit>, BoxedUnit> closure) {
                return IterableSplitter.buildString$(this, closure);
            }

            public String debugInformation() {
                return IterableSplitter.debugInformation$(this);
            }

            public IterableSplitter.Taken newTaken(int until) {
                return IterableSplitter.newTaken$(this, until);
            }

            public <U extends IterableSplitter.Taken> U newSliceInternal(U it, int from1) {
                return (U)IterableSplitter.newSliceInternal$(this, it, from1);
            }

            public IterableSplitter<V> drop(int n) {
                return IterableSplitter.drop$(this, n);
            }

            public IterableSplitter<V> take(int n) {
                return IterableSplitter.take$(this, n);
            }

            public IterableSplitter<V> slice(int from1, int until1) {
                return IterableSplitter.slice$(this, from1, until1);
            }

            public <S> IterableSplitter.Mapped<S> map(Function1<V, S> f) {
                return IterableSplitter.map$(this, f);
            }

            public <U, PI extends IterableSplitter<U>> IterableSplitter.Appended<U, PI> appendParIterable(PI that) {
                return IterableSplitter.appendParIterable$(this, that);
            }

            public <S> IterableSplitter.Zipped<S> zipParSeq(SeqSplitter<S> that) {
                return IterableSplitter.zipParSeq$(this, that);
            }

            public <S, U, R> IterableSplitter.ZippedAll<U, R> zipAllParSeq(SeqSplitter<S> that, U thisElem, R thatElem) {
                return IterableSplitter.zipAllParSeq$(this, that, thisElem, thatElem);
            }

            public boolean isAborted() {
                return DelegatedSignalling.isAborted$(this);
            }

            public void abort() {
                DelegatedSignalling.abort$(this);
            }

            public int indexFlag() {
                return DelegatedSignalling.indexFlag$(this);
            }

            public void setIndexFlag(int f) {
                DelegatedSignalling.setIndexFlag$(this, f);
            }

            public void setIndexFlagIfGreater(int f) {
                DelegatedSignalling.setIndexFlagIfGreater$(this, f);
            }

            public void setIndexFlagIfLesser(int f) {
                DelegatedSignalling.setIndexFlagIfLesser$(this, f);
            }

            public int tag() {
                return DelegatedSignalling.tag$(this);
            }

            public int count(Function1<V, Object> p) {
                return AugmentedIterableIterator.count$(this, p);
            }

            public <U> U reduce(Function2<U, U, U> op) {
                return (U)AugmentedIterableIterator.reduce$(this, op);
            }

            public <U> U fold(U z, Function2<U, U, U> op) {
                return (U)AugmentedIterableIterator.fold$(this, z, op);
            }

            public <U> U sum(Numeric<U> num) {
                return (U)AugmentedIterableIterator.sum$(this, num);
            }

            public <U> U product(Numeric<U> num) {
                return (U)AugmentedIterableIterator.product$(this, num);
            }

            public <U> V min(Ordering<U> ord) {
                return (V)AugmentedIterableIterator.min$(this, ord);
            }

            public <U> V max(Ordering<U> ord) {
                return (V)AugmentedIterableIterator.max$(this, ord);
            }

            public <U> void copyToArray(Object array, int from, int len) {
                AugmentedIterableIterator.copyToArray$(this, array, from, len);
            }

            public <U> U reduceLeft(int howmany, Function2<U, U, U> op) {
                return (U)AugmentedIterableIterator.reduceLeft$(this, howmany, op);
            }

            public <S, That> Combiner<S, That> map2combiner(Function1<V, S> f, Combiner<S, That> cb) {
                return AugmentedIterableIterator.map2combiner$(this, f, cb);
            }

            public <S, That> Combiner<S, That> collect2combiner(PartialFunction<V, S> pf, Combiner<S, That> cb) {
                return AugmentedIterableIterator.collect2combiner$(this, pf, cb);
            }

            public <S, That> Combiner<S, That> flatmap2combiner(Function1<V, GenTraversableOnce<S>> f, Combiner<S, That> cb) {
                return AugmentedIterableIterator.flatmap2combiner$(this, f, cb);
            }

            public <U, Coll, Bld extends Builder<U, Coll>> Bld copy2builder(Bld b) {
                return (Bld)AugmentedIterableIterator.copy2builder$(this, b);
            }

            public <U, This> Combiner<U, This> filter2combiner(Function1<V, Object> pred, Combiner<U, This> cb) {
                return AugmentedIterableIterator.filter2combiner$(this, pred, cb);
            }

            public <U, This> Combiner<U, This> filterNot2combiner(Function1<V, Object> pred, Combiner<U, This> cb) {
                return AugmentedIterableIterator.filterNot2combiner$(this, pred, cb);
            }

            public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> partition2combiners(Function1<V, Object> pred, Combiner<U, This> btrue, Combiner<U, This> bfalse) {
                return AugmentedIterableIterator.partition2combiners$(this, pred, btrue, bfalse);
            }

            public <U, This> Combiner<U, This> take2combiner(int n, Combiner<U, This> cb) {
                return AugmentedIterableIterator.take2combiner$(this, n, cb);
            }

            public <U, This> Combiner<U, This> drop2combiner(int n, Combiner<U, This> cb) {
                return AugmentedIterableIterator.drop2combiner$(this, n, cb);
            }

            public <U, This> Combiner<U, This> slice2combiner(int from, int until, Combiner<U, This> cb) {
                return AugmentedIterableIterator.slice2combiner$(this, from, until, cb);
            }

            public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> splitAt2combiners(int at, Combiner<U, This> before, Combiner<U, This> after) {
                return AugmentedIterableIterator.splitAt2combiners$(this, at, before, after);
            }

            public <U, This> Tuple2<Combiner<U, This>, Object> takeWhile2combiner(Function1<V, Object> p, Combiner<U, This> cb) {
                return AugmentedIterableIterator.takeWhile2combiner$(this, p, cb);
            }

            public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> span2combiners(Function1<V, Object> p, Combiner<U, This> before, Combiner<U, This> after) {
                return AugmentedIterableIterator.span2combiners$(this, p, before, after);
            }

            public <U, A> void scanToArray(U z, Function2<U, U, U> op, Object array, int from) {
                AugmentedIterableIterator.scanToArray$(this, z, op, array, from);
            }

            public <U, That> Combiner<U, That> scanToCombiner(U startValue, Function2<U, U, U> op, Combiner<U, That> cb) {
                return AugmentedIterableIterator.scanToCombiner$(this, startValue, op, cb);
            }

            public <U, That> Combiner<U, That> scanToCombiner(int howmany, U startValue, Function2<U, U, U> op, Combiner<U, That> cb) {
                return AugmentedIterableIterator.scanToCombiner$(this, howmany, startValue, op, cb);
            }

            public <U, S, That> Combiner<Tuple2<U, S>, That> zip2combiner(RemainsIterator<S> otherpit, Combiner<Tuple2<U, S>, That> cb) {
                return AugmentedIterableIterator.zip2combiner$(this, otherpit, cb);
            }

            public <U, S, That> Combiner<Tuple2<U, S>, That> zipAll2combiner(RemainsIterator<S> that, U thiselem, S thatelem, Combiner<Tuple2<U, S>, That> cb) {
                return AugmentedIterableIterator.zipAll2combiner$(this, that, thiselem, thatelem, cb);
            }

            public boolean isRemainingCheap() {
                return RemainsIterator.isRemainingCheap$(this);
            }

            public Iterator<V> seq() {
                return Iterator.seq$(this);
            }

            public boolean isEmpty() {
                return Iterator.isEmpty$(this);
            }

            public boolean isTraversableAgain() {
                return Iterator.isTraversableAgain$(this);
            }

            public boolean hasDefiniteSize() {
                return Iterator.hasDefiniteSize$(this);
            }

            public Iterator<V> sliceIterator(int from, int until) {
                return Iterator.sliceIterator$(this, from, until);
            }

            public <B> Iterator<B> $plus$plus(Function0<GenTraversableOnce<B>> that) {
                return Iterator.$plus$plus$(this, that);
            }

            public <B> Iterator<B> flatMap(Function1<V, GenTraversableOnce<B>> f) {
                return Iterator.flatMap$(this, f);
            }

            public Iterator<V> filter(Function1<V, Object> p) {
                return Iterator.filter$(this, p);
            }

            public <B> boolean corresponds(GenTraversableOnce<B> that, Function2<V, B, Object> p) {
                return Iterator.corresponds$(this, that, p);
            }

            public Iterator<V> withFilter(Function1<V, Object> p) {
                return Iterator.withFilter$(this, p);
            }

            public Iterator<V> filterNot(Function1<V, Object> p) {
                return Iterator.filterNot$(this, p);
            }

            public <B> Iterator<B> collect(PartialFunction<V, B> pf) {
                return Iterator.collect$(this, pf);
            }

            public <B> Iterator<B> scanLeft(B z, Function2<B, V, B> op) {
                return Iterator.scanLeft$(this, z, op);
            }

            public <B> Iterator<B> scanRight(B z, Function2<V, B, B> op) {
                return Iterator.scanRight$(this, z, op);
            }

            public Iterator<V> takeWhile(Function1<V, Object> p) {
                return Iterator.takeWhile$(this, p);
            }

            public Tuple2<Iterator<V>, Iterator<V>> partition(Function1<V, Object> p) {
                return Iterator.partition$(this, p);
            }

            public Tuple2<Iterator<V>, Iterator<V>> span(Function1<V, Object> p) {
                return Iterator.span$(this, p);
            }

            public Iterator<V> dropWhile(Function1<V, Object> p) {
                return Iterator.dropWhile$(this, p);
            }

            public <B> Iterator<Tuple2<V, B>> zip(Iterator<B> that) {
                return Iterator.zip$(this, that);
            }

            public <A1> Iterator<A1> padTo(int len, A1 elem) {
                return Iterator.padTo$(this, len, elem);
            }

            public Iterator<Tuple2<V, Object>> zipWithIndex() {
                return Iterator.zipWithIndex$(this);
            }

            public <B, A1, B1> Iterator<Tuple2<A1, B1>> zipAll(Iterator<B> that, A1 thisElem, B1 thatElem) {
                return Iterator.zipAll$(this, that, thisElem, thatElem);
            }

            public <U> void foreach(Function1<V, U> f) {
                Iterator.foreach$(this, f);
            }

            public boolean forall(Function1<V, Object> p) {
                return Iterator.forall$(this, p);
            }

            public boolean exists(Function1<V, Object> p) {
                return Iterator.exists$(this, p);
            }

            public boolean contains(Object elem) {
                return Iterator.contains$(this, elem);
            }

            public Option<V> find(Function1<V, Object> p) {
                return Iterator.find$(this, p);
            }

            public int indexWhere(Function1<V, Object> p) {
                return Iterator.indexWhere$(this, p);
            }

            public int indexWhere(Function1<V, Object> p, int from) {
                return Iterator.indexWhere$(this, p, from);
            }

            public <B> int indexOf(B elem) {
                return Iterator.indexOf$(this, elem);
            }

            public <B> int indexOf(B elem, int from) {
                return Iterator.indexOf$(this, elem, from);
            }

            public BufferedIterator<V> buffered() {
                return Iterator.buffered$(this);
            }

            public <B> Iterator.GroupedIterator<B> grouped(int size) {
                return Iterator.grouped$(this, size);
            }

            public <B> Iterator.GroupedIterator<B> sliding(int size, int step) {
                return Iterator.sliding$(this, size, step);
            }

            public <B> int sliding$default$2() {
                return Iterator.sliding$default$2$(this);
            }

            public int length() {
                return Iterator.length$(this);
            }

            public Tuple2<Iterator<V>, Iterator<V>> duplicate() {
                return Iterator.duplicate$(this);
            }

            public <B> Iterator<B> patch(int from, Iterator<B> patchElems, int replaced) {
                return Iterator.patch$(this, from, patchElems, replaced);
            }

            public boolean sameElements(Iterator<?> that) {
                return Iterator.sameElements$(this, that);
            }

            public Traversable<V> toTraversable() {
                return Iterator.toTraversable$(this);
            }

            public Iterator<V> toIterator() {
                return Iterator.toIterator$(this);
            }

            public Stream<V> toStream() {
                return Iterator.toStream$(this);
            }

            public String toString() {
                return Iterator.toString$(this);
            }

            public List<V> reversed() {
                return TraversableOnce.reversed$(this);
            }

            public int size() {
                return TraversableOnce.size$(this);
            }

            public boolean nonEmpty() {
                return TraversableOnce.nonEmpty$(this);
            }

            public <B> Option<B> collectFirst(PartialFunction<V, B> pf) {
                return TraversableOnce.collectFirst$(this, pf);
            }

            public <B> B $div$colon(B z, Function2<B, V, B> op) {
                return (B)TraversableOnce.$div$colon$(this, z, op);
            }

            public <B> B $colon$bslash(B z, Function2<V, B, B> op) {
                return (B)TraversableOnce.$colon$bslash$(this, z, op);
            }

            public <B> B foldLeft(B z, Function2<B, V, B> op) {
                return (B)TraversableOnce.foldLeft$(this, z, op);
            }

            public <B> B foldRight(B z, Function2<V, B, B> op) {
                return (B)TraversableOnce.foldRight$(this, z, op);
            }

            public <B> B reduceLeft(Function2<B, V, B> op) {
                return (B)TraversableOnce.reduceLeft$(this, op);
            }

            public <B> B reduceRight(Function2<V, B, B> op) {
                return (B)TraversableOnce.reduceRight$(this, op);
            }

            public <B> Option<B> reduceLeftOption(Function2<B, V, B> op) {
                return TraversableOnce.reduceLeftOption$(this, op);
            }

            public <B> Option<B> reduceRightOption(Function2<V, B, B> op) {
                return TraversableOnce.reduceRightOption$(this, op);
            }

            public <A1> Option<A1> reduceOption(Function2<A1, A1, A1> op) {
                return TraversableOnce.reduceOption$(this, op);
            }

            public <B> B aggregate(Function0<B> z, Function2<B, V, B> seqop, Function2<B, B, B> combop) {
                return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
            }

            public <B> V maxBy(Function1<V, B> f, Ordering<B> cmp) {
                return (V)TraversableOnce.maxBy$(this, f, cmp);
            }

            public <B> V minBy(Function1<V, B> f, Ordering<B> cmp) {
                return (V)TraversableOnce.minBy$(this, f, cmp);
            }

            public <B> void copyToBuffer(Buffer<B> dest) {
                TraversableOnce.copyToBuffer$(this, dest);
            }

            public <B> void copyToArray(Object xs, int start) {
                TraversableOnce.copyToArray$(this, xs, start);
            }

            public <B> void copyToArray(Object xs) {
                TraversableOnce.copyToArray$(this, xs);
            }

            public <B> Object toArray(ClassTag<B> evidence$1) {
                return TraversableOnce.toArray$(this, evidence$1);
            }

            public List<V> toList() {
                return TraversableOnce.toList$(this);
            }

            public Iterable<V> toIterable() {
                return TraversableOnce.toIterable$(this);
            }

            public Seq<V> toSeq() {
                return TraversableOnce.toSeq$(this);
            }

            public IndexedSeq<V> toIndexedSeq() {
                return TraversableOnce.toIndexedSeq$(this);
            }

            public <B> Buffer<B> toBuffer() {
                return TraversableOnce.toBuffer$(this);
            }

            public <B> scala.collection.immutable.Set<B> toSet() {
                return TraversableOnce.toSet$(this);
            }

            public Vector<V> toVector() {
                return TraversableOnce.toVector$(this);
            }

            public <Col> Col to(CanBuildFrom<Nothing$, V, Col> cbf) {
                return (Col)TraversableOnce.to$(this, cbf);
            }

            public <T, U> scala.collection.immutable.Map<T, U> toMap(Predef$.less.colon.less<V, Tuple2<T, U>> ev) {
                return TraversableOnce.toMap$(this, ev);
            }

            public String mkString(String start, String sep, String end) {
                return TraversableOnce.mkString$(this, start, sep, end);
            }

            public String mkString(String sep) {
                return TraversableOnce.mkString$(this, sep);
            }

            public String mkString() {
                return TraversableOnce.mkString$(this);
            }

            public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
                return TraversableOnce.addString$(this, b, start, sep, end);
            }

            public StringBuilder addString(StringBuilder b, String sep) {
                return TraversableOnce.addString$(this, b, sep);
            }

            public StringBuilder addString(StringBuilder b) {
                return TraversableOnce.addString$(this, b);
            }

            public int sizeHintIfCheap() {
                return GenTraversableOnce.sizeHintIfCheap$(this);
            }

            public Signalling signalDelegate() {
                return this.signalDelegate;
            }

            public void signalDelegate_$eq(Signalling x$1) {
                this.signalDelegate = x$1;
            }

            private IterableSplitter<Tuple2<K, V>> iter() {
                return this.iter;
            }

            public boolean hasNext() {
                return this.iter().hasNext();
            }

            public V next() {
                return (V)((Tuple2)this.iter().next())._2();
            }

            /*
             * WARNING - void declaration
             */
            public Seq<IterableSplitter<V>> split() {
                void var1_1;
                Seq<A> ss = this.iter().split().map((Function1<IterableSplitter, IterableSplitter> & java.io.Serializable & Serializable)x$3 -> $this.$outer.scala$collection$parallel$ParMapLike$$valuesIterator(x$3), Seq$.MODULE$.canBuildFrom());
                ss.foreach((Function1<IterableSplitter, Object> & java.io.Serializable & Serializable)(A x$4) -> {
                    $anon$2.$anonfun$split$4(this, x$4);
                    return BoxedUnit.UNIT;
                });
                return var1_1;
            }

            public int remaining() {
                return this.iter().remaining();
            }

            public IterableSplitter<V> dup() {
                return this.$outer.scala$collection$parallel$ParMapLike$$valuesIterator(this.iter().dup());
            }

            public static final /* synthetic */ void $anonfun$split$4($anon$2 $this, IterableSplitter x$4) {
                x$4.signalDelegate_$eq($this.signalDelegate());
            }
            {
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
                this.iter = s$2;
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$split$3(scala.collection.parallel.ParMapLike$$anon$2 scala.collection.parallel.IterableSplitter ), $anonfun$split$4$adapted(scala.collection.parallel.ParMapLike$$anon$2 scala.collection.parallel.IterableSplitter )}, serializedLambda);
            }
        };
    }

    public static /* synthetic */ IterableSplitter valuesIterator$(ParMapLike $this) {
        return $this.valuesIterator();
    }

    @Override
    default public IterableSplitter<V> valuesIterator() {
        return this.scala$collection$parallel$ParMapLike$$valuesIterator(this.splitter());
    }

    public static /* synthetic */ ParSet keySet$(ParMapLike $this) {
        return $this.keySet();
    }

    @Override
    default public ParSet<K> keySet() {
        return new DefaultKeySet();
    }

    public static /* synthetic */ ParIterable keys$(ParMapLike $this) {
        return $this.keys();
    }

    @Override
    default public ParIterable<K> keys() {
        return this.keySet();
    }

    public static /* synthetic */ ParIterable values$(ParMapLike $this) {
        return $this.values();
    }

    @Override
    default public ParIterable<V> values() {
        return new DefaultValuesIterable();
    }

    public static /* synthetic */ ParMap filterKeys$(ParMapLike $this, Function1 p) {
        return $this.filterKeys(p);
    }

    @Override
    default public ParMap<K, V> filterKeys(Function1<K, Object> p) {
        return new ParMap<K, V>(this, p){
            private Repr filtered;
            private volatile transient TaskSupport scala$collection$parallel$ParIterableLike$$_tasksupport;
            private volatile ParIterableLike$ScanNode$ ScanNode$module;
            private volatile ParIterableLike$ScanLeaf$ ScanLeaf$module;
            private volatile boolean bitmap$0;
            private final /* synthetic */ ParMapLike $outer;
            private final Function1 p$1;

            public GenericParMapCompanion<ParMap> mapCompanion() {
                return ParMap.mapCompanion$(this);
            }

            public ParMap<K, V> empty() {
                return ParMap.empty$(this);
            }

            public String stringPrefix() {
                return ParMap.stringPrefix$(this);
            }

            public <U> ParMap<K, U> updated(K key, U value) {
                return ParMap.updated$(this, key, value);
            }

            public V default(K key) {
                return (V)ParMapLike.default$(this, key);
            }

            public V apply(K key) {
                return (V)ParMapLike.apply$(this, key);
            }

            public <U> U getOrElse(K key, Function0<U> function0) {
                return (U)ParMapLike.getOrElse$(this, key, function0);
            }

            public boolean isDefinedAt(K key) {
                return ParMapLike.isDefinedAt$(this, key);
            }

            public IterableSplitter<K> keysIterator() {
                return ParMapLike.keysIterator$(this);
            }

            public IterableSplitter<V> valuesIterator() {
                return ParMapLike.valuesIterator$(this);
            }

            public ParSet<K> keySet() {
                return ParMapLike.keySet$(this);
            }

            public ParIterable<K> keys() {
                return ParMapLike.keys$(this);
            }

            public ParIterable<V> values() {
                return ParMapLike.values$(this);
            }

            public ParMap<K, V> filterKeys(Function1<K, Object> p) {
                return ParMapLike.filterKeys$(this, p);
            }

            public <S> ParMap<K, S> mapValues(Function1<V, S> f) {
                return ParMapLike.mapValues$(this, f);
            }

            public GenericCompanion<ParIterable> companion() {
                return ParIterable.companion$(this);
            }

            public void initTaskSupport() {
                ParIterableLike.initTaskSupport$(this);
            }

            public TaskSupport tasksupport() {
                return ParIterableLike.tasksupport$(this);
            }

            public void tasksupport_$eq(TaskSupport ts) {
                ParIterableLike.tasksupport_$eq$(this, ts);
            }

            public ParIterable repr() {
                return ParIterableLike.repr$(this);
            }

            public final boolean isTraversableAgain() {
                return ParIterableLike.isTraversableAgain$(this);
            }

            public boolean hasDefiniteSize() {
                return ParIterableLike.hasDefiniteSize$(this);
            }

            public boolean isEmpty() {
                return ParIterableLike.isEmpty$(this);
            }

            public boolean nonEmpty() {
                return ParIterableLike.nonEmpty$(this);
            }

            public Object head() {
                return ParIterableLike.head$(this);
            }

            public Option<Tuple2<K, V>> headOption() {
                return ParIterableLike.headOption$(this);
            }

            public ParIterable tail() {
                return ParIterableLike.tail$(this);
            }

            public Object last() {
                return ParIterableLike.last$(this);
            }

            public Option<Tuple2<K, V>> lastOption() {
                return ParIterableLike.lastOption$(this);
            }

            public ParIterable init() {
                return ParIterableLike.init$(this);
            }

            public Splitter<Tuple2<K, V>> iterator() {
                return ParIterableLike.iterator$(this);
            }

            public ParIterable par() {
                return ParIterableLike.par$(this);
            }

            public boolean isStrictSplitterCollection() {
                return ParIterableLike.isStrictSplitterCollection$(this);
            }

            public <S, That> Combiner<S, That> reuse(Option<Combiner<S, That>> oldc, Combiner<S, That> newc) {
                return ParIterableLike.reuse$(this, oldc, newc);
            }

            public <R, Tp> ParIterableLike.TaskOps<R, Tp> task2ops(ParIterableLike.StrictSplitterCheckTask<R, Tp> tsk) {
                return ParIterableLike.task2ops$(this, tsk);
            }

            public <R> ParIterableLike.NonDivisible<R> wrap(Function0<R> body) {
                return ParIterableLike.wrap$(this, body);
            }

            public <PI extends DelegatedSignalling> ParIterableLike.SignallingOps<PI> delegatedSignalling2ops(PI it) {
                return ParIterableLike.delegatedSignalling2ops$(this, it);
            }

            public <Elem, To> ParIterableLike.BuilderOps<Elem, To> builder2ops(Builder<Elem, To> cb) {
                return ParIterableLike.builder2ops$(this, cb);
            }

            public <S, That> CanBuildFrom<Map<K, V>, S, That> bf2seq(CanBuildFrom<ParMap<K, V>, S, That> bf) {
                return ParIterableLike.bf2seq$(this, bf);
            }

            public ParIterable sequentially(Function1 b) {
                return ParIterableLike.sequentially$(this, b);
            }

            public String mkString(String start, String sep, String end) {
                return ParIterableLike.mkString$(this, start, sep, end);
            }

            public String mkString(String sep) {
                return ParIterableLike.mkString$(this, sep);
            }

            public String mkString() {
                return ParIterableLike.mkString$(this);
            }

            public String toString() {
                return ParIterableLike.toString$(this);
            }

            public boolean canEqual(Object other) {
                return ParIterableLike.canEqual$(this, other);
            }

            public <U> U reduce(Function2<U, U, U> op) {
                return (U)ParIterableLike.reduce$(this, op);
            }

            public <U> Option<U> reduceOption(Function2<U, U, U> op) {
                return ParIterableLike.reduceOption$(this, op);
            }

            public <U> U fold(U z, Function2<U, U, U> op) {
                return (U)ParIterableLike.fold$(this, z, op);
            }

            public <S> S aggregate(Function0<S> z, Function2<S, Tuple2<K, V>, S> seqop, Function2<S, S, S> combop) {
                return (S)ParIterableLike.aggregate$(this, z, seqop, combop);
            }

            public <S> S foldLeft(S z, Function2<S, Tuple2<K, V>, S> op) {
                return (S)ParIterableLike.foldLeft$(this, z, op);
            }

            public <S> S foldRight(S z, Function2<Tuple2<K, V>, S, S> op) {
                return (S)ParIterableLike.foldRight$(this, z, op);
            }

            public <U> U reduceLeft(Function2<U, Tuple2<K, V>, U> op) {
                return (U)ParIterableLike.reduceLeft$(this, op);
            }

            public <U> U reduceRight(Function2<Tuple2<K, V>, U, U> op) {
                return (U)ParIterableLike.reduceRight$(this, op);
            }

            public <U> Option<U> reduceLeftOption(Function2<U, Tuple2<K, V>, U> op) {
                return ParIterableLike.reduceLeftOption$(this, op);
            }

            public <U> Option<U> reduceRightOption(Function2<Tuple2<K, V>, U, U> op) {
                return ParIterableLike.reduceRightOption$(this, op);
            }

            public int count(Function1<Tuple2<K, V>, Object> p) {
                return ParIterableLike.count$(this, p);
            }

            public <U> U sum(Numeric<U> num) {
                return (U)ParIterableLike.sum$(this, num);
            }

            public <U> U product(Numeric<U> num) {
                return (U)ParIterableLike.product$(this, num);
            }

            public Object min(Ordering ord) {
                return ParIterableLike.min$(this, ord);
            }

            public Object max(Ordering ord) {
                return ParIterableLike.max$(this, ord);
            }

            public Object maxBy(Function1 f, Ordering cmp) {
                return ParIterableLike.maxBy$(this, f, cmp);
            }

            public Object minBy(Function1 f, Ordering cmp) {
                return ParIterableLike.minBy$(this, f, cmp);
            }

            public <S, That> That map(Function1<Tuple2<K, V>, S> f, CanBuildFrom<ParMap<K, V>, S, That> bf) {
                return (That)ParIterableLike.map$(this, f, bf);
            }

            public <S, That> That collect(PartialFunction<Tuple2<K, V>, S> pf, CanBuildFrom<ParMap<K, V>, S, That> bf) {
                return (That)ParIterableLike.collect$(this, pf, bf);
            }

            public <S, That> That flatMap(Function1<Tuple2<K, V>, GenTraversableOnce<S>> f, CanBuildFrom<ParMap<K, V>, S, That> bf) {
                return (That)ParIterableLike.flatMap$(this, f, bf);
            }

            public boolean forall(Function1<Tuple2<K, V>, Object> p) {
                return ParIterableLike.forall$(this, p);
            }

            public boolean exists(Function1<Tuple2<K, V>, Object> p) {
                return ParIterableLike.exists$(this, p);
            }

            public Option<Tuple2<K, V>> find(Function1<Tuple2<K, V>, Object> p) {
                return ParIterableLike.find$(this, p);
            }

            public CombinerFactory<Tuple2<K, V>, ParMap<K, V>> combinerFactory() {
                return ParIterableLike.combinerFactory$(this);
            }

            public <S, That> CombinerFactory<S, That> combinerFactory(Function0<Combiner<S, That>> cbf) {
                return ParIterableLike.combinerFactory$(this, cbf);
            }

            public ParIterable withFilter(Function1 pred) {
                return ParIterableLike.withFilter$(this, pred);
            }

            public ParIterable filter(Function1 pred) {
                return ParIterableLike.filter$(this, pred);
            }

            public ParIterable filterNot(Function1 pred) {
                return ParIterableLike.filterNot$(this, pred);
            }

            public <U, That> That $plus$plus(GenTraversableOnce<U> that, CanBuildFrom<ParMap<K, V>, U, That> bf) {
                return (That)ParIterableLike.$plus$plus$(this, that, bf);
            }

            public Tuple2<ParMap<K, V>, ParMap<K, V>> partition(Function1<Tuple2<K, V>, Object> pred) {
                return ParIterableLike.partition$(this, pred);
            }

            public <K> scala.collection.parallel.immutable.ParMap<K, ParMap<K, V>> groupBy(Function1<Tuple2<K, V>, K> f) {
                return ParIterableLike.groupBy$(this, f);
            }

            public ParIterable take(int n) {
                return ParIterableLike.take$(this, n);
            }

            public ParIterable drop(int n) {
                return ParIterableLike.drop$(this, n);
            }

            public ParIterable slice(int unc_from, int unc_until) {
                return ParIterableLike.slice$(this, unc_from, unc_until);
            }

            public Tuple2<ParMap<K, V>, ParMap<K, V>> splitAt(int n) {
                return ParIterableLike.splitAt$(this, n);
            }

            public <U, That> That scan(U z, Function2<U, U, U> op, CanBuildFrom<ParMap<K, V>, U, That> bf) {
                return (That)ParIterableLike.scan$(this, z, op, bf);
            }

            public <S, That> That scanLeft(S z, Function2<S, Tuple2<K, V>, S> op, CanBuildFrom<ParMap<K, V>, S, That> bf) {
                return (That)ParIterableLike.scanLeft$(this, z, op, bf);
            }

            public <S, That> That scanRight(S z, Function2<Tuple2<K, V>, S, S> op, CanBuildFrom<ParMap<K, V>, S, That> bf) {
                return (That)ParIterableLike.scanRight$(this, z, op, bf);
            }

            public ParIterable takeWhile(Function1 pred) {
                return ParIterableLike.takeWhile$(this, pred);
            }

            public Tuple2<ParMap<K, V>, ParMap<K, V>> span(Function1<Tuple2<K, V>, Object> pred) {
                return ParIterableLike.span$(this, pred);
            }

            public ParIterable dropWhile(Function1 pred) {
                return ParIterableLike.dropWhile$(this, pred);
            }

            public <U> void copyToArray(Object xs) {
                ParIterableLike.copyToArray$(this, xs);
            }

            public <U> void copyToArray(Object xs, int start) {
                ParIterableLike.copyToArray$(this, xs, start);
            }

            public <U> void copyToArray(Object xs, int start, int len) {
                ParIterableLike.copyToArray$(this, xs, start, len);
            }

            public <U> boolean sameElements(GenIterable<U> that) {
                return ParIterableLike.sameElements$(this, that);
            }

            public <U, S, That> That zip(GenIterable<S> that, CanBuildFrom<ParMap<K, V>, Tuple2<U, S>, That> bf) {
                return (That)ParIterableLike.zip$(this, that, bf);
            }

            public <U, That> That zipWithIndex(CanBuildFrom<ParMap<K, V>, Tuple2<U, Object>, That> bf) {
                return (That)ParIterableLike.zipWithIndex$(this, bf);
            }

            public <S, U, That> That zipAll(GenIterable<S> that, U thisElem, S thatElem, CanBuildFrom<ParMap<K, V>, Tuple2<U, S>, That> bf) {
                return (That)ParIterableLike.zipAll$(this, that, thisElem, thatElem, bf);
            }

            public <U, That> That toParCollection(Function0<Combiner<U, That>> cbf) {
                return (That)ParIterableLike.toParCollection$(this, cbf);
            }

            public <K, V, That> That toParMap(Function0<Combiner<Tuple2<K, V>, That>> cbf, Predef$.less.colon.less<Tuple2<K, V>, Tuple2<K, V>> ev) {
                return (That)ParIterableLike.toParMap$(this, cbf, ev);
            }

            public IterableView<Tuple2<K, V>, Map<K, V>> view() {
                return ParIterableLike.view$(this);
            }

            public <U> Object toArray(ClassTag<U> evidence$1) {
                return ParIterableLike.toArray$(this, evidence$1);
            }

            public List<Tuple2<K, V>> toList() {
                return ParIterableLike.toList$(this);
            }

            public IndexedSeq<Tuple2<K, V>> toIndexedSeq() {
                return ParIterableLike.toIndexedSeq$(this);
            }

            public Stream<Tuple2<K, V>> toStream() {
                return ParIterableLike.toStream$(this);
            }

            public Iterator<Tuple2<K, V>> toIterator() {
                return ParIterableLike.toIterator$(this);
            }

            public <U> Buffer<U> toBuffer() {
                return ParIterableLike.toBuffer$(this);
            }

            public GenTraversable<Tuple2<K, V>> toTraversable() {
                return ParIterableLike.toTraversable$(this);
            }

            public ParIterable<Tuple2<K, V>> toIterable() {
                return ParIterableLike.toIterable$(this);
            }

            public ParSeq<Tuple2<K, V>> toSeq() {
                return ParIterableLike.toSeq$(this);
            }

            public <U> scala.collection.parallel.immutable.ParSet<U> toSet() {
                return ParIterableLike.toSet$(this);
            }

            public <K, V> scala.collection.parallel.immutable.ParMap<K, V> toMap(Predef$.less.colon.less<Tuple2<K, V>, Tuple2<K, V>> ev) {
                return ParIterableLike.toMap$(this, ev);
            }

            public Vector<Tuple2<K, V>> toVector() {
                return ParIterableLike.toVector$(this);
            }

            public <Col> Col to(CanBuildFrom<Nothing$, Tuple2<K, V>, Col> cbf) {
                return (Col)ParIterableLike.to$(this, cbf);
            }

            public int scanBlockSize() {
                return ParIterableLike.scanBlockSize$(this);
            }

            public <S> S $div$colon(S z, Function2<S, Tuple2<K, V>, S> op) {
                return (S)ParIterableLike.$div$colon$(this, z, op);
            }

            public <S> S $colon$bslash(S z, Function2<Tuple2<K, V>, S, S> op) {
                return (S)ParIterableLike.$colon$bslash$(this, z, op);
            }

            public String debugInformation() {
                return ParIterableLike.debugInformation$(this);
            }

            public Seq<String> brokenInvariants() {
                return ParIterableLike.brokenInvariants$(this);
            }

            public ArrayBuffer<String> debugBuffer() {
                return ParIterableLike.debugBuffer$(this);
            }

            public void debugclear() {
                ParIterableLike.debugclear$(this);
            }

            public ArrayBuffer<String> debuglog(String s) {
                return ParIterableLike.debuglog$(this, s);
            }

            public void printDebugBuffer() {
                ParIterableLike.printDebugBuffer$(this);
            }

            public Combiner<Tuple2<K, V>, ParMap<K, V>> parCombiner() {
                return CustomParallelizable.parCombiner$(this);
            }

            public Combiner<Tuple2<K, V>, ParMap<K, V>> newCombiner() {
                return GenericParMapTemplate.newCombiner$(this);
            }

            public <P, Q> Combiner<Tuple2<P, Q>, ParMap<P, Q>> genericMapCombiner() {
                return GenericParMapTemplate.genericMapCombiner$(this);
            }

            public Builder<Tuple2<K, V>, ParIterable<Tuple2<K, V>>> newBuilder() {
                return GenericParTemplate.newBuilder$(this);
            }

            public <B> Combiner<B, ParIterable<B>> genericBuilder() {
                return GenericParTemplate.genericBuilder$(this);
            }

            public <B> Combiner<B, ParIterable<B>> genericCombiner() {
                return GenericParTemplate.genericCombiner$(this);
            }

            public <A1, A2> Tuple2<ParIterable<A1>, ParIterable<A2>> unzip(Function1<Tuple2<K, V>, Tuple2<A1, A2>> asPair) {
                return GenericTraversableTemplate.unzip$(this, asPair);
            }

            public <A1, A2, A3> Tuple3<ParIterable<A1>, ParIterable<A2>, ParIterable<A3>> unzip3(Function1<Tuple2<K, V>, Tuple3<A1, A2, A3>> asTriple) {
                return GenericTraversableTemplate.unzip3$(this, asTriple);
            }

            public GenTraversable flatten(Function1 asTraversable) {
                return GenericTraversableTemplate.flatten$(this, asTraversable);
            }

            public GenTraversable transpose(Function1 asTraversable) {
                return GenericTraversableTemplate.transpose$(this, asTraversable);
            }

            public int hashCode() {
                return GenMapLike.hashCode$(this);
            }

            public boolean equals(Object that) {
                return GenMapLike.equals$(this, that);
            }

            public int sizeHintIfCheap() {
                return GenTraversableOnce.sizeHintIfCheap$(this);
            }

            public TaskSupport scala$collection$parallel$ParIterableLike$$_tasksupport() {
                return this.scala$collection$parallel$ParIterableLike$$_tasksupport;
            }

            public void scala$collection$parallel$ParIterableLike$$_tasksupport_$eq(TaskSupport x$1) {
                this.scala$collection$parallel$ParIterableLike$$_tasksupport = x$1;
            }

            public ParIterableLike$ScanNode$ ScanNode() {
                if (this.ScanNode$module == null) {
                    this.ScanNode$lzycompute$3();
                }
                return this.ScanNode$module;
            }

            public ParIterableLike$ScanLeaf$ ScanLeaf() {
                if (this.ScanLeaf$module == null) {
                    this.ScanLeaf$lzycompute$3();
                }
                return this.ScanLeaf$module;
            }

            private Repr filtered$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.filtered = (ParMap)this.$outer.filter((Function1<Tuple2, Object> & java.io.Serializable & Serializable)(A kv) -> BoxesRunTime.boxToBoolean($anon$3.$anonfun$filtered$1(this, kv)));
                        this.bitmap$0 = true;
                    }
                }
                return this.filtered;
            }

            private Repr filtered() {
                if (!this.bitmap$0) {
                    return this.filtered$lzycompute();
                }
                return this.filtered;
            }

            public <U> void foreach(Function1<Tuple2<K, V>, U> f) {
                this.$outer.foreach((Function1<Tuple2, Object> & java.io.Serializable & Serializable)(A kv) -> {
                    if (BoxesRunTime.unboxToBoolean($this.p$1.apply(kv._1()))) {
                        return f.apply((Tuple2<K, V>)kv);
                    }
                    return BoxedUnit.UNIT;
                });
            }

            public IterableSplitter<Tuple2<K, V>> splitter() {
                return this.filtered().splitter();
            }

            public boolean contains(K key) {
                return this.$outer.contains(key) && BoxesRunTime.unboxToBoolean(this.p$1.apply(key));
            }

            public Option<V> get(K key) {
                if (!BoxesRunTime.unboxToBoolean(this.p$1.apply(key))) {
                    return None$.MODULE$;
                }
                return this.$outer.get(key);
            }

            public Map<K, V> seq() {
                return ((MapLike)this.$outer.seq()).filterKeys(this.p$1);
            }

            public int size() {
                return this.filtered().size();
            }

            public <U> ParMap<K, U> $plus(Tuple2<K, U> kv) {
                return ((ParIterableLike)ParMap$.MODULE$.apply(Nil$.MODULE$)).$plus$plus(this, ParMap$.MODULE$.canBuildFrom()).$plus(kv);
            }

            public ParMap<K, V> $minus(K key) {
                return (ParMap)((GenMapLike)((ParIterableLike)ParMap$.MODULE$.apply(Nil$.MODULE$)).$plus$plus(this, ParMap$.MODULE$.canBuildFrom())).$minus(key);
            }

            private final void ScanNode$lzycompute$3() {
                synchronized (this) {
                    if (this.ScanNode$module == null) {
                        this.ScanNode$module = new ParIterableLike$ScanNode$(this);
                    }
                    return;
                }
            }

            private final void ScanLeaf$lzycompute$3() {
                synchronized (this) {
                    if (this.ScanLeaf$module == null) {
                        this.ScanLeaf$module = new ParIterableLike$ScanLeaf$(this);
                    }
                    return;
                }
            }

            public static final /* synthetic */ boolean $anonfun$filtered$1($anon$3 $this, Tuple2 kv) {
                return BoxesRunTime.unboxToBoolean($this.p$1.apply(kv._1()));
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.p$1 = p$1;
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

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$filtered$1$adapted(scala.collection.parallel.ParMapLike$$anon$3 scala.Tuple2 ), $anonfun$foreach$5(scala.collection.parallel.ParMapLike$$anon$3 scala.Function1 scala.Tuple2 ), $anonfun$dropWhile$1(scala.Tuple2 ), $anonfun$filter$1(scala.collection.parallel.Combiner ), $anonfun$filterNot$1(scala.collection.parallel.Combiner ), $anonfun$groupBy$1(), $anonfun$groupBy$2(scala.collection.parallel.ParIterableLike scala.collection.parallel.immutable.HashMapCombiner ), $anonfun$takeWhile$1(scala.collection.parallel.Combiner ), $anonfun$takeWhile$2(scala.Tuple2 )}, serializedLambda);
            }
        };
    }

    public static /* synthetic */ ParMap mapValues$(ParMapLike $this, Function1 f) {
        return $this.mapValues(f);
    }

    @Override
    default public <S> ParMap<K, S> mapValues(Function1<V, S> f) {
        return new ParMap<K, S>(this, f){
            private volatile transient TaskSupport scala$collection$parallel$ParIterableLike$$_tasksupport;
            private volatile ParIterableLike$ScanNode$ ScanNode$module;
            private volatile ParIterableLike$ScanLeaf$ ScanLeaf$module;
            private final /* synthetic */ ParMapLike $outer;
            private final Function1 f$4;

            public GenericParMapCompanion<ParMap> mapCompanion() {
                return ParMap.mapCompanion$(this);
            }

            public ParMap<K, S> empty() {
                return ParMap.empty$(this);
            }

            public String stringPrefix() {
                return ParMap.stringPrefix$(this);
            }

            public <U> ParMap<K, U> updated(K key, U value) {
                return ParMap.updated$(this, key, value);
            }

            public S default(K key) {
                return (S)ParMapLike.default$(this, key);
            }

            public S apply(K key) {
                return (S)ParMapLike.apply$(this, key);
            }

            public <U> U getOrElse(K key, Function0<U> function0) {
                return (U)ParMapLike.getOrElse$(this, key, function0);
            }

            public boolean isDefinedAt(K key) {
                return ParMapLike.isDefinedAt$(this, key);
            }

            public IterableSplitter<K> keysIterator() {
                return ParMapLike.keysIterator$(this);
            }

            public IterableSplitter<S> valuesIterator() {
                return ParMapLike.valuesIterator$(this);
            }

            public ParSet<K> keySet() {
                return ParMapLike.keySet$(this);
            }

            public ParIterable<K> keys() {
                return ParMapLike.keys$(this);
            }

            public ParIterable<S> values() {
                return ParMapLike.values$(this);
            }

            public ParMap<K, S> filterKeys(Function1<K, Object> p) {
                return ParMapLike.filterKeys$(this, p);
            }

            public <S> ParMap<K, S> mapValues(Function1<S, S> f) {
                return ParMapLike.mapValues$(this, f);
            }

            public GenericCompanion<ParIterable> companion() {
                return ParIterable.companion$(this);
            }

            public void initTaskSupport() {
                ParIterableLike.initTaskSupport$(this);
            }

            public TaskSupport tasksupport() {
                return ParIterableLike.tasksupport$(this);
            }

            public void tasksupport_$eq(TaskSupport ts) {
                ParIterableLike.tasksupport_$eq$(this, ts);
            }

            public ParIterable repr() {
                return ParIterableLike.repr$(this);
            }

            public final boolean isTraversableAgain() {
                return ParIterableLike.isTraversableAgain$(this);
            }

            public boolean hasDefiniteSize() {
                return ParIterableLike.hasDefiniteSize$(this);
            }

            public boolean isEmpty() {
                return ParIterableLike.isEmpty$(this);
            }

            public boolean nonEmpty() {
                return ParIterableLike.nonEmpty$(this);
            }

            public Object head() {
                return ParIterableLike.head$(this);
            }

            public Option<Tuple2<K, S>> headOption() {
                return ParIterableLike.headOption$(this);
            }

            public ParIterable tail() {
                return ParIterableLike.tail$(this);
            }

            public Object last() {
                return ParIterableLike.last$(this);
            }

            public Option<Tuple2<K, S>> lastOption() {
                return ParIterableLike.lastOption$(this);
            }

            public ParIterable init() {
                return ParIterableLike.init$(this);
            }

            public Splitter<Tuple2<K, S>> iterator() {
                return ParIterableLike.iterator$(this);
            }

            public ParIterable par() {
                return ParIterableLike.par$(this);
            }

            public boolean isStrictSplitterCollection() {
                return ParIterableLike.isStrictSplitterCollection$(this);
            }

            public <S, That> Combiner<S, That> reuse(Option<Combiner<S, That>> oldc, Combiner<S, That> newc) {
                return ParIterableLike.reuse$(this, oldc, newc);
            }

            public <R, Tp> ParIterableLike.TaskOps<R, Tp> task2ops(ParIterableLike.StrictSplitterCheckTask<R, Tp> tsk) {
                return ParIterableLike.task2ops$(this, tsk);
            }

            public <R> ParIterableLike.NonDivisible<R> wrap(Function0<R> body) {
                return ParIterableLike.wrap$(this, body);
            }

            public <PI extends DelegatedSignalling> ParIterableLike.SignallingOps<PI> delegatedSignalling2ops(PI it) {
                return ParIterableLike.delegatedSignalling2ops$(this, it);
            }

            public <Elem, To> ParIterableLike.BuilderOps<Elem, To> builder2ops(Builder<Elem, To> cb) {
                return ParIterableLike.builder2ops$(this, cb);
            }

            public <S, That> CanBuildFrom<Map<K, S>, S, That> bf2seq(CanBuildFrom<ParMap<K, S>, S, That> bf) {
                return ParIterableLike.bf2seq$(this, bf);
            }

            public ParIterable sequentially(Function1 b) {
                return ParIterableLike.sequentially$(this, b);
            }

            public String mkString(String start, String sep, String end) {
                return ParIterableLike.mkString$(this, start, sep, end);
            }

            public String mkString(String sep) {
                return ParIterableLike.mkString$(this, sep);
            }

            public String mkString() {
                return ParIterableLike.mkString$(this);
            }

            public String toString() {
                return ParIterableLike.toString$(this);
            }

            public boolean canEqual(Object other) {
                return ParIterableLike.canEqual$(this, other);
            }

            public <U> U reduce(Function2<U, U, U> op) {
                return (U)ParIterableLike.reduce$(this, op);
            }

            public <U> Option<U> reduceOption(Function2<U, U, U> op) {
                return ParIterableLike.reduceOption$(this, op);
            }

            public <U> U fold(U z, Function2<U, U, U> op) {
                return (U)ParIterableLike.fold$(this, z, op);
            }

            public <S> S aggregate(Function0<S> z, Function2<S, Tuple2<K, S>, S> seqop, Function2<S, S, S> combop) {
                return (S)ParIterableLike.aggregate$(this, z, seqop, combop);
            }

            public <S> S foldLeft(S z, Function2<S, Tuple2<K, S>, S> op) {
                return (S)ParIterableLike.foldLeft$(this, z, op);
            }

            public <S> S foldRight(S z, Function2<Tuple2<K, S>, S, S> op) {
                return (S)ParIterableLike.foldRight$(this, z, op);
            }

            public <U> U reduceLeft(Function2<U, Tuple2<K, S>, U> op) {
                return (U)ParIterableLike.reduceLeft$(this, op);
            }

            public <U> U reduceRight(Function2<Tuple2<K, S>, U, U> op) {
                return (U)ParIterableLike.reduceRight$(this, op);
            }

            public <U> Option<U> reduceLeftOption(Function2<U, Tuple2<K, S>, U> op) {
                return ParIterableLike.reduceLeftOption$(this, op);
            }

            public <U> Option<U> reduceRightOption(Function2<Tuple2<K, S>, U, U> op) {
                return ParIterableLike.reduceRightOption$(this, op);
            }

            public int count(Function1<Tuple2<K, S>, Object> p) {
                return ParIterableLike.count$(this, p);
            }

            public <U> U sum(Numeric<U> num) {
                return (U)ParIterableLike.sum$(this, num);
            }

            public <U> U product(Numeric<U> num) {
                return (U)ParIterableLike.product$(this, num);
            }

            public Object min(Ordering ord) {
                return ParIterableLike.min$(this, ord);
            }

            public Object max(Ordering ord) {
                return ParIterableLike.max$(this, ord);
            }

            public Object maxBy(Function1 f, Ordering cmp) {
                return ParIterableLike.maxBy$(this, f, cmp);
            }

            public Object minBy(Function1 f, Ordering cmp) {
                return ParIterableLike.minBy$(this, f, cmp);
            }

            public <S, That> That map(Function1<Tuple2<K, S>, S> f, CanBuildFrom<ParMap<K, S>, S, That> bf) {
                return (That)ParIterableLike.map$(this, f, bf);
            }

            public <S, That> That collect(PartialFunction<Tuple2<K, S>, S> pf, CanBuildFrom<ParMap<K, S>, S, That> bf) {
                return (That)ParIterableLike.collect$(this, pf, bf);
            }

            public <S, That> That flatMap(Function1<Tuple2<K, S>, GenTraversableOnce<S>> f, CanBuildFrom<ParMap<K, S>, S, That> bf) {
                return (That)ParIterableLike.flatMap$(this, f, bf);
            }

            public boolean forall(Function1<Tuple2<K, S>, Object> p) {
                return ParIterableLike.forall$(this, p);
            }

            public boolean exists(Function1<Tuple2<K, S>, Object> p) {
                return ParIterableLike.exists$(this, p);
            }

            public Option<Tuple2<K, S>> find(Function1<Tuple2<K, S>, Object> p) {
                return ParIterableLike.find$(this, p);
            }

            public CombinerFactory<Tuple2<K, S>, ParMap<K, S>> combinerFactory() {
                return ParIterableLike.combinerFactory$(this);
            }

            public <S, That> CombinerFactory<S, That> combinerFactory(Function0<Combiner<S, That>> cbf) {
                return ParIterableLike.combinerFactory$(this, cbf);
            }

            public ParIterable withFilter(Function1 pred) {
                return ParIterableLike.withFilter$(this, pred);
            }

            public ParIterable filter(Function1 pred) {
                return ParIterableLike.filter$(this, pred);
            }

            public ParIterable filterNot(Function1 pred) {
                return ParIterableLike.filterNot$(this, pred);
            }

            public <U, That> That $plus$plus(GenTraversableOnce<U> that, CanBuildFrom<ParMap<K, S>, U, That> bf) {
                return (That)ParIterableLike.$plus$plus$(this, that, bf);
            }

            public Tuple2<ParMap<K, S>, ParMap<K, S>> partition(Function1<Tuple2<K, S>, Object> pred) {
                return ParIterableLike.partition$(this, pred);
            }

            public <K> scala.collection.parallel.immutable.ParMap<K, ParMap<K, S>> groupBy(Function1<Tuple2<K, S>, K> f) {
                return ParIterableLike.groupBy$(this, f);
            }

            public ParIterable take(int n) {
                return ParIterableLike.take$(this, n);
            }

            public ParIterable drop(int n) {
                return ParIterableLike.drop$(this, n);
            }

            public ParIterable slice(int unc_from, int unc_until) {
                return ParIterableLike.slice$(this, unc_from, unc_until);
            }

            public Tuple2<ParMap<K, S>, ParMap<K, S>> splitAt(int n) {
                return ParIterableLike.splitAt$(this, n);
            }

            public <U, That> That scan(U z, Function2<U, U, U> op, CanBuildFrom<ParMap<K, S>, U, That> bf) {
                return (That)ParIterableLike.scan$(this, z, op, bf);
            }

            public <S, That> That scanLeft(S z, Function2<S, Tuple2<K, S>, S> op, CanBuildFrom<ParMap<K, S>, S, That> bf) {
                return (That)ParIterableLike.scanLeft$(this, z, op, bf);
            }

            public <S, That> That scanRight(S z, Function2<Tuple2<K, S>, S, S> op, CanBuildFrom<ParMap<K, S>, S, That> bf) {
                return (That)ParIterableLike.scanRight$(this, z, op, bf);
            }

            public ParIterable takeWhile(Function1 pred) {
                return ParIterableLike.takeWhile$(this, pred);
            }

            public Tuple2<ParMap<K, S>, ParMap<K, S>> span(Function1<Tuple2<K, S>, Object> pred) {
                return ParIterableLike.span$(this, pred);
            }

            public ParIterable dropWhile(Function1 pred) {
                return ParIterableLike.dropWhile$(this, pred);
            }

            public <U> void copyToArray(Object xs) {
                ParIterableLike.copyToArray$(this, xs);
            }

            public <U> void copyToArray(Object xs, int start) {
                ParIterableLike.copyToArray$(this, xs, start);
            }

            public <U> void copyToArray(Object xs, int start, int len) {
                ParIterableLike.copyToArray$(this, xs, start, len);
            }

            public <U> boolean sameElements(GenIterable<U> that) {
                return ParIterableLike.sameElements$(this, that);
            }

            public <U, S, That> That zip(GenIterable<S> that, CanBuildFrom<ParMap<K, S>, Tuple2<U, S>, That> bf) {
                return (That)ParIterableLike.zip$(this, that, bf);
            }

            public <U, That> That zipWithIndex(CanBuildFrom<ParMap<K, S>, Tuple2<U, Object>, That> bf) {
                return (That)ParIterableLike.zipWithIndex$(this, bf);
            }

            public <S, U, That> That zipAll(GenIterable<S> that, U thisElem, S thatElem, CanBuildFrom<ParMap<K, S>, Tuple2<U, S>, That> bf) {
                return (That)ParIterableLike.zipAll$(this, that, thisElem, thatElem, bf);
            }

            public <U, That> That toParCollection(Function0<Combiner<U, That>> cbf) {
                return (That)ParIterableLike.toParCollection$(this, cbf);
            }

            public <K, V, That> That toParMap(Function0<Combiner<Tuple2<K, V>, That>> cbf, Predef$.less.colon.less<Tuple2<K, S>, Tuple2<K, V>> ev) {
                return (That)ParIterableLike.toParMap$(this, cbf, ev);
            }

            public IterableView<Tuple2<K, S>, Map<K, S>> view() {
                return ParIterableLike.view$(this);
            }

            public <U> Object toArray(ClassTag<U> evidence$1) {
                return ParIterableLike.toArray$(this, evidence$1);
            }

            public List<Tuple2<K, S>> toList() {
                return ParIterableLike.toList$(this);
            }

            public IndexedSeq<Tuple2<K, S>> toIndexedSeq() {
                return ParIterableLike.toIndexedSeq$(this);
            }

            public Stream<Tuple2<K, S>> toStream() {
                return ParIterableLike.toStream$(this);
            }

            public Iterator<Tuple2<K, S>> toIterator() {
                return ParIterableLike.toIterator$(this);
            }

            public <U> Buffer<U> toBuffer() {
                return ParIterableLike.toBuffer$(this);
            }

            public GenTraversable<Tuple2<K, S>> toTraversable() {
                return ParIterableLike.toTraversable$(this);
            }

            public ParIterable<Tuple2<K, S>> toIterable() {
                return ParIterableLike.toIterable$(this);
            }

            public ParSeq<Tuple2<K, S>> toSeq() {
                return ParIterableLike.toSeq$(this);
            }

            public <U> scala.collection.parallel.immutable.ParSet<U> toSet() {
                return ParIterableLike.toSet$(this);
            }

            public <K, V> scala.collection.parallel.immutable.ParMap<K, V> toMap(Predef$.less.colon.less<Tuple2<K, S>, Tuple2<K, V>> ev) {
                return ParIterableLike.toMap$(this, ev);
            }

            public Vector<Tuple2<K, S>> toVector() {
                return ParIterableLike.toVector$(this);
            }

            public <Col> Col to(CanBuildFrom<Nothing$, Tuple2<K, S>, Col> cbf) {
                return (Col)ParIterableLike.to$(this, cbf);
            }

            public int scanBlockSize() {
                return ParIterableLike.scanBlockSize$(this);
            }

            public <S> S $div$colon(S z, Function2<S, Tuple2<K, S>, S> op) {
                return (S)ParIterableLike.$div$colon$(this, z, op);
            }

            public <S> S $colon$bslash(S z, Function2<Tuple2<K, S>, S, S> op) {
                return (S)ParIterableLike.$colon$bslash$(this, z, op);
            }

            public String debugInformation() {
                return ParIterableLike.debugInformation$(this);
            }

            public Seq<String> brokenInvariants() {
                return ParIterableLike.brokenInvariants$(this);
            }

            public ArrayBuffer<String> debugBuffer() {
                return ParIterableLike.debugBuffer$(this);
            }

            public void debugclear() {
                ParIterableLike.debugclear$(this);
            }

            public ArrayBuffer<String> debuglog(String s) {
                return ParIterableLike.debuglog$(this, s);
            }

            public void printDebugBuffer() {
                ParIterableLike.printDebugBuffer$(this);
            }

            public Combiner<Tuple2<K, S>, ParMap<K, S>> parCombiner() {
                return CustomParallelizable.parCombiner$(this);
            }

            public Combiner<Tuple2<K, S>, ParMap<K, S>> newCombiner() {
                return GenericParMapTemplate.newCombiner$(this);
            }

            public <P, Q> Combiner<Tuple2<P, Q>, ParMap<P, Q>> genericMapCombiner() {
                return GenericParMapTemplate.genericMapCombiner$(this);
            }

            public Builder<Tuple2<K, S>, ParIterable<Tuple2<K, S>>> newBuilder() {
                return GenericParTemplate.newBuilder$(this);
            }

            public <B> Combiner<B, ParIterable<B>> genericBuilder() {
                return GenericParTemplate.genericBuilder$(this);
            }

            public <B> Combiner<B, ParIterable<B>> genericCombiner() {
                return GenericParTemplate.genericCombiner$(this);
            }

            public <A1, A2> Tuple2<ParIterable<A1>, ParIterable<A2>> unzip(Function1<Tuple2<K, S>, Tuple2<A1, A2>> asPair) {
                return GenericTraversableTemplate.unzip$(this, asPair);
            }

            public <A1, A2, A3> Tuple3<ParIterable<A1>, ParIterable<A2>, ParIterable<A3>> unzip3(Function1<Tuple2<K, S>, Tuple3<A1, A2, A3>> asTriple) {
                return GenericTraversableTemplate.unzip3$(this, asTriple);
            }

            public GenTraversable flatten(Function1 asTraversable) {
                return GenericTraversableTemplate.flatten$(this, asTraversable);
            }

            public GenTraversable transpose(Function1 asTraversable) {
                return GenericTraversableTemplate.transpose$(this, asTraversable);
            }

            public int hashCode() {
                return GenMapLike.hashCode$(this);
            }

            public boolean equals(Object that) {
                return GenMapLike.equals$(this, that);
            }

            public int sizeHintIfCheap() {
                return GenTraversableOnce.sizeHintIfCheap$(this);
            }

            public TaskSupport scala$collection$parallel$ParIterableLike$$_tasksupport() {
                return this.scala$collection$parallel$ParIterableLike$$_tasksupport;
            }

            public void scala$collection$parallel$ParIterableLike$$_tasksupport_$eq(TaskSupport x$1) {
                this.scala$collection$parallel$ParIterableLike$$_tasksupport = x$1;
            }

            public ParIterableLike$ScanNode$ ScanNode() {
                if (this.ScanNode$module == null) {
                    this.ScanNode$lzycompute$4();
                }
                return this.ScanNode$module;
            }

            public ParIterableLike$ScanLeaf$ ScanLeaf() {
                if (this.ScanLeaf$module == null) {
                    this.ScanLeaf$lzycompute$4();
                }
                return this.ScanLeaf$module;
            }

            public <U> void foreach(Function1<Tuple2<K, S>, U> g) {
                this.$outer.withFilter((Function1<Tuple2, Object> & java.io.Serializable & Serializable)(T check$ifrefutable$3) -> BoxesRunTime.boxToBoolean($anon$4.$anonfun$foreach$6(check$ifrefutable$3))).foreach((Function1<Tuple2, Object> & java.io.Serializable & Serializable)(A x$7) -> {
                    if (x$7 == null) {
                        throw new MatchError((Object)null);
                    }
                    T1 k = x$7._1();
                    T2 v = x$7._2();
                    R r = g.apply(new Tuple2<T1, R>(k, $this.f$4.apply(v)));
                    return r;
                });
            }

            public IterableSplitter.Mapped<Tuple2<K, S>> splitter() {
                return this.$outer.splitter().map((Function1<Tuple2, Tuple2> & java.io.Serializable & Serializable)kv -> new Tuple2<T1, R>(kv._1(), $this.f$4.apply(kv._2())));
            }

            public int size() {
                return this.$outer.size();
            }

            public boolean contains(K key) {
                return this.$outer.contains(key);
            }

            /*
             * WARNING - void declaration
             */
            public Option<S> get(K key) {
                void map_f;
                Option<V> option = this.$outer.get(key);
                Function1 function1 = this.f$4;
                if (option == null) {
                    throw null;
                }
                Option<V> map_this = option;
                if (map_this.isEmpty()) {
                    return None$.MODULE$;
                }
                return new Some<R>(map_f.apply(map_this.get()));
            }

            public Map<K, S> seq() {
                return ((MapLike)this.$outer.seq()).mapValues(this.f$4);
            }

            public <U> ParMap<K, U> $plus(Tuple2<K, U> kv) {
                return ((ParIterableLike)ParMap$.MODULE$.apply(Nil$.MODULE$)).$plus$plus(this, ParMap$.MODULE$.canBuildFrom()).$plus(kv);
            }

            public ParMap<K, S> $minus(K key) {
                return (ParMap)((GenMapLike)((ParIterableLike)ParMap$.MODULE$.apply(Nil$.MODULE$)).$plus$plus(this, ParMap$.MODULE$.canBuildFrom())).$minus(key);
            }

            private final void ScanNode$lzycompute$4() {
                synchronized (this) {
                    if (this.ScanNode$module == null) {
                        this.ScanNode$module = new ParIterableLike$ScanNode$(this);
                    }
                    return;
                }
            }

            private final void ScanLeaf$lzycompute$4() {
                synchronized (this) {
                    if (this.ScanLeaf$module == null) {
                        this.ScanLeaf$module = new ParIterableLike$ScanLeaf$(this);
                    }
                    return;
                }
            }

            public static final /* synthetic */ boolean $anonfun$foreach$6(Tuple2 check$ifrefutable$3) {
                boolean bl = check$ifrefutable$3 != null;
                return bl;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.f$4 = f$4;
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

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$foreach$6$adapted(scala.Tuple2 ), $anonfun$foreach$7(scala.collection.parallel.ParMapLike$$anon$4 scala.Function1 scala.Tuple2 ), $anonfun$splitter$1(scala.collection.parallel.ParMapLike$$anon$4 scala.Tuple2 ), $anonfun$dropWhile$1(scala.Tuple2 ), $anonfun$filter$1(scala.collection.parallel.Combiner ), $anonfun$filterNot$1(scala.collection.parallel.Combiner ), $anonfun$groupBy$1(), $anonfun$groupBy$2(scala.collection.parallel.ParIterableLike scala.collection.parallel.immutable.HashMapCombiner ), $anonfun$takeWhile$1(scala.collection.parallel.Combiner ), $anonfun$takeWhile$2(scala.Tuple2 )}, serializedLambda);
            }
        };
    }

    public static void $init$(ParMapLike $this) {
    }

    public class DefaultKeySet
    implements ParSet<K> {
        private volatile transient TaskSupport scala$collection$parallel$ParIterableLike$$_tasksupport;
        private volatile ParIterableLike$ScanNode$ ScanNode$module;
        private volatile ParIterableLike$ScanLeaf$ ScanLeaf$module;

        @Override
        public ParSet<K> empty() {
            return ParSet.empty$(this);
        }

        @Override
        public GenericCompanion<ParSet> companion() {
            return ParSet.companion$(this);
        }

        @Override
        public String stringPrefix() {
            return ParSet.stringPrefix$(this);
        }

        @Override
        public ParSet<K> union(GenSet<K> that) {
            return ParSetLike.union$(this, that);
        }

        @Override
        public ParSet<K> diff(GenSet<K> that) {
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
        public K head() {
            return ParIterableLike.head$(this);
        }

        @Override
        public Option<K> headOption() {
            return ParIterableLike.headOption$(this);
        }

        @Override
        public ParIterable tail() {
            return ParIterableLike.tail$(this);
        }

        @Override
        public K last() {
            return ParIterableLike.last$(this);
        }

        @Override
        public Option<K> lastOption() {
            return ParIterableLike.lastOption$(this);
        }

        @Override
        public ParIterable init() {
            return ParIterableLike.init$(this);
        }

        @Override
        public Splitter<K> iterator() {
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
        public <S, That> CanBuildFrom<Set<K>, S, That> bf2seq(CanBuildFrom<ParSet<K>, S, That> bf) {
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
        public <S> S aggregate(Function0<S> z, Function2<S, K, S> seqop, Function2<S, S, S> combop) {
            return (S)ParIterableLike.aggregate$(this, z, seqop, combop);
        }

        @Override
        public <S> S foldLeft(S z, Function2<S, K, S> op) {
            return (S)ParIterableLike.foldLeft$(this, z, op);
        }

        @Override
        public <S> S foldRight(S z, Function2<K, S, S> op) {
            return (S)ParIterableLike.foldRight$(this, z, op);
        }

        @Override
        public <U> U reduceLeft(Function2<U, K, U> op) {
            return (U)ParIterableLike.reduceLeft$(this, op);
        }

        @Override
        public <U> U reduceRight(Function2<K, U, U> op) {
            return (U)ParIterableLike.reduceRight$(this, op);
        }

        @Override
        public <U> Option<U> reduceLeftOption(Function2<U, K, U> op) {
            return ParIterableLike.reduceLeftOption$(this, op);
        }

        @Override
        public <U> Option<U> reduceRightOption(Function2<K, U, U> op) {
            return ParIterableLike.reduceRightOption$(this, op);
        }

        @Override
        public int count(Function1<K, Object> p) {
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
        public <U> K min(Ordering<U> ord) {
            return ParIterableLike.min$(this, ord);
        }

        @Override
        public <U> K max(Ordering<U> ord) {
            return ParIterableLike.max$(this, ord);
        }

        @Override
        public <S> K maxBy(Function1<K, S> f, Ordering<S> cmp) {
            return ParIterableLike.maxBy$(this, f, cmp);
        }

        @Override
        public <S> K minBy(Function1<K, S> f, Ordering<S> cmp) {
            return ParIterableLike.minBy$(this, f, cmp);
        }

        @Override
        public <S, That> That map(Function1<K, S> f, CanBuildFrom<ParSet<K>, S, That> bf) {
            return (That)ParIterableLike.map$(this, f, bf);
        }

        @Override
        public <S, That> That collect(PartialFunction<K, S> pf, CanBuildFrom<ParSet<K>, S, That> bf) {
            return (That)ParIterableLike.collect$(this, pf, bf);
        }

        @Override
        public <S, That> That flatMap(Function1<K, GenTraversableOnce<S>> f, CanBuildFrom<ParSet<K>, S, That> bf) {
            return (That)ParIterableLike.flatMap$(this, f, bf);
        }

        @Override
        public boolean forall(Function1<K, Object> p) {
            return ParIterableLike.forall$(this, p);
        }

        @Override
        public boolean exists(Function1<K, Object> p) {
            return ParIterableLike.exists$(this, p);
        }

        @Override
        public Option<K> find(Function1<K, Object> p) {
            return ParIterableLike.find$(this, p);
        }

        @Override
        public CombinerFactory<K, ParSet<K>> combinerFactory() {
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
        public <U, That> That $plus$plus(GenTraversableOnce<U> that, CanBuildFrom<ParSet<K>, U, That> bf) {
            return (That)ParIterableLike.$plus$plus$(this, that, bf);
        }

        @Override
        public Tuple2<ParSet<K>, ParSet<K>> partition(Function1<K, Object> pred) {
            return ParIterableLike.partition$(this, pred);
        }

        @Override
        public <K> scala.collection.parallel.immutable.ParMap<K, ParSet<K>> groupBy(Function1<K, K> f) {
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
        public Tuple2<ParSet<K>, ParSet<K>> splitAt(int n) {
            return ParIterableLike.splitAt$(this, n);
        }

        @Override
        public <U, That> That scan(U z, Function2<U, U, U> op, CanBuildFrom<ParSet<K>, U, That> bf) {
            return (That)ParIterableLike.scan$(this, z, op, bf);
        }

        @Override
        public <S, That> That scanLeft(S z, Function2<S, K, S> op, CanBuildFrom<ParSet<K>, S, That> bf) {
            return (That)ParIterableLike.scanLeft$(this, z, op, bf);
        }

        @Override
        public <S, That> That scanRight(S z, Function2<K, S, S> op, CanBuildFrom<ParSet<K>, S, That> bf) {
            return (That)ParIterableLike.scanRight$(this, z, op, bf);
        }

        @Override
        public ParIterable takeWhile(Function1 pred) {
            return ParIterableLike.takeWhile$(this, pred);
        }

        @Override
        public Tuple2<ParSet<K>, ParSet<K>> span(Function1<K, Object> pred) {
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
        public <U, S, That> That zip(GenIterable<S> that, CanBuildFrom<ParSet<K>, Tuple2<U, S>, That> bf) {
            return (That)ParIterableLike.zip$(this, that, bf);
        }

        @Override
        public <U, That> That zipWithIndex(CanBuildFrom<ParSet<K>, Tuple2<U, Object>, That> bf) {
            return (That)ParIterableLike.zipWithIndex$(this, bf);
        }

        @Override
        public <S, U, That> That zipAll(GenIterable<S> that, U thisElem, S thatElem, CanBuildFrom<ParSet<K>, Tuple2<U, S>, That> bf) {
            return (That)ParIterableLike.zipAll$(this, that, thisElem, thatElem, bf);
        }

        @Override
        public <U, That> That toParCollection(Function0<Combiner<U, That>> cbf) {
            return (That)ParIterableLike.toParCollection$(this, cbf);
        }

        @Override
        public <K, V, That> That toParMap(Function0<Combiner<Tuple2<K, V>, That>> cbf, Predef$.less.colon.less<K, Tuple2<K, V>> ev) {
            return (That)ParIterableLike.toParMap$(this, cbf, ev);
        }

        @Override
        public IterableView<K, Set<K>> view() {
            return ParIterableLike.view$(this);
        }

        @Override
        public <U> Object toArray(ClassTag<U> evidence$1) {
            return ParIterableLike.toArray$(this, evidence$1);
        }

        @Override
        public List<K> toList() {
            return ParIterableLike.toList$(this);
        }

        @Override
        public IndexedSeq<K> toIndexedSeq() {
            return ParIterableLike.toIndexedSeq$(this);
        }

        @Override
        public Stream<K> toStream() {
            return ParIterableLike.toStream$(this);
        }

        @Override
        public Iterator<K> toIterator() {
            return ParIterableLike.toIterator$(this);
        }

        @Override
        public <U> Buffer<U> toBuffer() {
            return ParIterableLike.toBuffer$(this);
        }

        @Override
        public GenTraversable<K> toTraversable() {
            return ParIterableLike.toTraversable$(this);
        }

        @Override
        public ParIterable<K> toIterable() {
            return ParIterableLike.toIterable$(this);
        }

        @Override
        public ParSeq<K> toSeq() {
            return ParIterableLike.toSeq$(this);
        }

        @Override
        public <U> scala.collection.parallel.immutable.ParSet<U> toSet() {
            return ParIterableLike.toSet$(this);
        }

        @Override
        public <K, V> scala.collection.parallel.immutable.ParMap<K, V> toMap(Predef$.less.colon.less<K, Tuple2<K, V>> ev) {
            return ParIterableLike.toMap$(this, ev);
        }

        @Override
        public Vector<K> toVector() {
            return ParIterableLike.toVector$(this);
        }

        @Override
        public <Col> Col to(CanBuildFrom<Nothing$, K, Col> cbf) {
            return (Col)ParIterableLike.to$(this, cbf);
        }

        @Override
        public int scanBlockSize() {
            return ParIterableLike.scanBlockSize$(this);
        }

        @Override
        public <S> S $div$colon(S z, Function2<S, K, S> op) {
            return (S)ParIterableLike.$div$colon$(this, z, op);
        }

        @Override
        public <S> S $colon$bslash(S z, Function2<K, S, S> op) {
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
        public Combiner<K, ParSet<K>> parCombiner() {
            return CustomParallelizable.parCombiner$(this);
        }

        @Override
        public Builder<K, ParSet<K>> newBuilder() {
            return GenericParTemplate.newBuilder$(this);
        }

        @Override
        public Combiner<K, ParSet<K>> newCombiner() {
            return GenericParTemplate.newCombiner$(this);
        }

        @Override
        public <B> Combiner<B, ParSet<B>> genericBuilder() {
            return GenericParTemplate.genericBuilder$(this);
        }

        @Override
        public <B> Combiner<B, ParSet<B>> genericCombiner() {
            return GenericParTemplate.genericCombiner$(this);
        }

        @Override
        public <A1, A2> Tuple2<ParSet<A1>, ParSet<A2>> unzip(Function1<K, Tuple2<A1, A2>> asPair) {
            return GenericTraversableTemplate.unzip$(this, asPair);
        }

        @Override
        public <A1, A2, A3> Tuple3<ParSet<A1>, ParSet<A2>, ParSet<A3>> unzip3(Function1<K, Tuple3<A1, A2, A3>> asTriple) {
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
        public boolean apply(K elem) {
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
        public boolean subsetOf(GenSet<K> that) {
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
        public <A> Function1<A, Object> compose(Function1<A, K> g) {
            return Function1.compose$(this, g);
        }

        @Override
        public <A> Function1<K, A> andThen(Function1<Object, A> g) {
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
        public boolean contains(K key) {
            return this.scala$collection$parallel$ParMapLike$DefaultKeySet$$$outer().contains(key);
        }

        @Override
        public IterableSplitter<K> splitter() {
            return this.scala$collection$parallel$ParMapLike$DefaultKeySet$$$outer().scala$collection$parallel$ParMapLike$$keysIterator(this.scala$collection$parallel$ParMapLike$DefaultKeySet$$$outer().splitter());
        }

        @Override
        public ParSet<K> $plus(K elem) {
            return (ParSet)((GenSetLike)((ParIterableLike)ParSet$.MODULE$.apply(Nil$.MODULE$)).$plus$plus(this, ParSet$.MODULE$.canBuildFrom())).$plus(elem);
        }

        @Override
        public ParSet<K> $minus(K elem) {
            return (ParSet)((GenSetLike)((ParIterableLike)ParSet$.MODULE$.apply(Nil$.MODULE$)).$plus$plus(this, ParSet$.MODULE$.canBuildFrom())).$minus(elem);
        }

        @Override
        public int size() {
            return this.scala$collection$parallel$ParMapLike$DefaultKeySet$$$outer().size();
        }

        @Override
        public <U> void foreach(Function1<K, U> f) {
            this.scala$collection$parallel$ParMapLike$DefaultKeySet$$$outer().withFilter((Function1<Tuple2, Object> & java.io.Serializable & Serializable)(T check$ifrefutable$1) -> BoxesRunTime.boxToBoolean(bl = check$ifrefutable$1 != null)).foreach((Function1<Tuple2, Object> & java.io.Serializable & Serializable)(A x$5) -> {
                if (x$5 == null) {
                    throw new MatchError((Object)null);
                }
                Object k = x$5._1();
                Object r = f.apply(k);
                return r;
            });
        }

        @Override
        public Set<K> seq() {
            return ((MapLike)this.scala$collection$parallel$ParMapLike$DefaultKeySet$$$outer().seq()).keySet();
        }

        public /* synthetic */ ParMapLike scala$collection$parallel$ParMapLike$DefaultKeySet$$$outer() {
            return ParMapLike.this;
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

        public DefaultKeySet() {
            if (ParMapLike.this == null) {
                throw null;
            }
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
            ParIterable.$init$(this);
            ParSetLike.$init$(this);
            ParSet.$init$(this);
        }
    }

    public class DefaultValuesIterable
    implements ParIterable<V> {
        private volatile transient TaskSupport scala$collection$parallel$ParIterableLike$$_tasksupport;
        private volatile ParIterableLike$ScanNode$ ScanNode$module;
        private volatile ParIterableLike$ScanLeaf$ ScanLeaf$module;

        @Override
        public GenericCompanion<ParIterable> companion() {
            return ParIterable.companion$(this);
        }

        @Override
        public String stringPrefix() {
            return ParIterable.stringPrefix$(this);
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
        public ParIterable<V> repr() {
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
        public V head() {
            return ParIterableLike.head$(this);
        }

        @Override
        public Option<V> headOption() {
            return ParIterableLike.headOption$(this);
        }

        @Override
        public ParIterable<V> tail() {
            return ParIterableLike.tail$(this);
        }

        @Override
        public V last() {
            return ParIterableLike.last$(this);
        }

        @Override
        public Option<V> lastOption() {
            return ParIterableLike.lastOption$(this);
        }

        @Override
        public ParIterable<V> init() {
            return ParIterableLike.init$(this);
        }

        @Override
        public Splitter<V> iterator() {
            return ParIterableLike.iterator$(this);
        }

        @Override
        public ParIterable<V> par() {
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
        public <S, That> CanBuildFrom<Iterable<V>, S, That> bf2seq(CanBuildFrom<ParIterable<V>, S, That> bf) {
            return ParIterableLike.bf2seq$(this, bf);
        }

        @Override
        public <S, That extends Parallel> ParIterable<V> sequentially(Function1<Iterable<V>, Parallelizable<S, That>> b) {
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
        public <S> S aggregate(Function0<S> z, Function2<S, V, S> seqop, Function2<S, S, S> combop) {
            return (S)ParIterableLike.aggregate$(this, z, seqop, combop);
        }

        @Override
        public <S> S foldLeft(S z, Function2<S, V, S> op) {
            return (S)ParIterableLike.foldLeft$(this, z, op);
        }

        @Override
        public <S> S foldRight(S z, Function2<V, S, S> op) {
            return (S)ParIterableLike.foldRight$(this, z, op);
        }

        @Override
        public <U> U reduceLeft(Function2<U, V, U> op) {
            return (U)ParIterableLike.reduceLeft$(this, op);
        }

        @Override
        public <U> U reduceRight(Function2<V, U, U> op) {
            return (U)ParIterableLike.reduceRight$(this, op);
        }

        @Override
        public <U> Option<U> reduceLeftOption(Function2<U, V, U> op) {
            return ParIterableLike.reduceLeftOption$(this, op);
        }

        @Override
        public <U> Option<U> reduceRightOption(Function2<V, U, U> op) {
            return ParIterableLike.reduceRightOption$(this, op);
        }

        @Override
        public int count(Function1<V, Object> p) {
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
        public <U> V min(Ordering<U> ord) {
            return ParIterableLike.min$(this, ord);
        }

        @Override
        public <U> V max(Ordering<U> ord) {
            return ParIterableLike.max$(this, ord);
        }

        @Override
        public <S> V maxBy(Function1<V, S> f, Ordering<S> cmp) {
            return ParIterableLike.maxBy$(this, f, cmp);
        }

        @Override
        public <S> V minBy(Function1<V, S> f, Ordering<S> cmp) {
            return ParIterableLike.minBy$(this, f, cmp);
        }

        @Override
        public <S, That> That map(Function1<V, S> f, CanBuildFrom<ParIterable<V>, S, That> bf) {
            return (That)ParIterableLike.map$(this, f, bf);
        }

        @Override
        public <S, That> That collect(PartialFunction<V, S> pf, CanBuildFrom<ParIterable<V>, S, That> bf) {
            return (That)ParIterableLike.collect$(this, pf, bf);
        }

        @Override
        public <S, That> That flatMap(Function1<V, GenTraversableOnce<S>> f, CanBuildFrom<ParIterable<V>, S, That> bf) {
            return (That)ParIterableLike.flatMap$(this, f, bf);
        }

        @Override
        public boolean forall(Function1<V, Object> p) {
            return ParIterableLike.forall$(this, p);
        }

        @Override
        public boolean exists(Function1<V, Object> p) {
            return ParIterableLike.exists$(this, p);
        }

        @Override
        public Option<V> find(Function1<V, Object> p) {
            return ParIterableLike.find$(this, p);
        }

        @Override
        public CombinerFactory<V, ParIterable<V>> combinerFactory() {
            return ParIterableLike.combinerFactory$(this);
        }

        @Override
        public <S, That> CombinerFactory<S, That> combinerFactory(Function0<Combiner<S, That>> cbf) {
            return ParIterableLike.combinerFactory$(this, cbf);
        }

        @Override
        public ParIterable<V> withFilter(Function1<V, Object> pred) {
            return ParIterableLike.withFilter$(this, pred);
        }

        @Override
        public ParIterable<V> filter(Function1<V, Object> pred) {
            return ParIterableLike.filter$(this, pred);
        }

        @Override
        public ParIterable<V> filterNot(Function1<V, Object> pred) {
            return ParIterableLike.filterNot$(this, pred);
        }

        @Override
        public <U, That> That $plus$plus(GenTraversableOnce<U> that, CanBuildFrom<ParIterable<V>, U, That> bf) {
            return (That)ParIterableLike.$plus$plus$(this, that, bf);
        }

        @Override
        public Tuple2<ParIterable<V>, ParIterable<V>> partition(Function1<V, Object> pred) {
            return ParIterableLike.partition$(this, pred);
        }

        @Override
        public <K> scala.collection.parallel.immutable.ParMap<K, ParIterable<V>> groupBy(Function1<V, K> f) {
            return ParIterableLike.groupBy$(this, f);
        }

        @Override
        public ParIterable<V> take(int n) {
            return ParIterableLike.take$(this, n);
        }

        @Override
        public ParIterable<V> drop(int n) {
            return ParIterableLike.drop$(this, n);
        }

        @Override
        public ParIterable<V> slice(int unc_from, int unc_until) {
            return ParIterableLike.slice$(this, unc_from, unc_until);
        }

        @Override
        public Tuple2<ParIterable<V>, ParIterable<V>> splitAt(int n) {
            return ParIterableLike.splitAt$(this, n);
        }

        @Override
        public <U, That> That scan(U z, Function2<U, U, U> op, CanBuildFrom<ParIterable<V>, U, That> bf) {
            return (That)ParIterableLike.scan$(this, z, op, bf);
        }

        @Override
        public <S, That> That scanLeft(S z, Function2<S, V, S> op, CanBuildFrom<ParIterable<V>, S, That> bf) {
            return (That)ParIterableLike.scanLeft$(this, z, op, bf);
        }

        @Override
        public <S, That> That scanRight(S z, Function2<V, S, S> op, CanBuildFrom<ParIterable<V>, S, That> bf) {
            return (That)ParIterableLike.scanRight$(this, z, op, bf);
        }

        @Override
        public ParIterable<V> takeWhile(Function1<V, Object> pred) {
            return ParIterableLike.takeWhile$(this, pred);
        }

        @Override
        public Tuple2<ParIterable<V>, ParIterable<V>> span(Function1<V, Object> pred) {
            return ParIterableLike.span$(this, pred);
        }

        @Override
        public ParIterable<V> dropWhile(Function1<V, Object> pred) {
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
        public <U, S, That> That zip(GenIterable<S> that, CanBuildFrom<ParIterable<V>, Tuple2<U, S>, That> bf) {
            return (That)ParIterableLike.zip$(this, that, bf);
        }

        @Override
        public <U, That> That zipWithIndex(CanBuildFrom<ParIterable<V>, Tuple2<U, Object>, That> bf) {
            return (That)ParIterableLike.zipWithIndex$(this, bf);
        }

        @Override
        public <S, U, That> That zipAll(GenIterable<S> that, U thisElem, S thatElem, CanBuildFrom<ParIterable<V>, Tuple2<U, S>, That> bf) {
            return (That)ParIterableLike.zipAll$(this, that, thisElem, thatElem, bf);
        }

        @Override
        public <U, That> That toParCollection(Function0<Combiner<U, That>> cbf) {
            return (That)ParIterableLike.toParCollection$(this, cbf);
        }

        @Override
        public <K, V, That> That toParMap(Function0<Combiner<Tuple2<K, V>, That>> cbf, Predef$.less.colon.less<V, Tuple2<K, V>> ev) {
            return (That)ParIterableLike.toParMap$(this, cbf, ev);
        }

        @Override
        public IterableView<V, Iterable<V>> view() {
            return ParIterableLike.view$(this);
        }

        @Override
        public <U> Object toArray(ClassTag<U> evidence$1) {
            return ParIterableLike.toArray$(this, evidence$1);
        }

        @Override
        public List<V> toList() {
            return ParIterableLike.toList$(this);
        }

        @Override
        public IndexedSeq<V> toIndexedSeq() {
            return ParIterableLike.toIndexedSeq$(this);
        }

        @Override
        public Stream<V> toStream() {
            return ParIterableLike.toStream$(this);
        }

        @Override
        public Iterator<V> toIterator() {
            return ParIterableLike.toIterator$(this);
        }

        @Override
        public <U> Buffer<U> toBuffer() {
            return ParIterableLike.toBuffer$(this);
        }

        @Override
        public GenTraversable<V> toTraversable() {
            return ParIterableLike.toTraversable$(this);
        }

        @Override
        public ParIterable<V> toIterable() {
            return ParIterableLike.toIterable$(this);
        }

        @Override
        public ParSeq<V> toSeq() {
            return ParIterableLike.toSeq$(this);
        }

        @Override
        public <U> scala.collection.parallel.immutable.ParSet<U> toSet() {
            return ParIterableLike.toSet$(this);
        }

        @Override
        public <K, V> scala.collection.parallel.immutable.ParMap<K, V> toMap(Predef$.less.colon.less<V, Tuple2<K, V>> ev) {
            return ParIterableLike.toMap$(this, ev);
        }

        @Override
        public Vector<V> toVector() {
            return ParIterableLike.toVector$(this);
        }

        @Override
        public <Col> Col to(CanBuildFrom<Nothing$, V, Col> cbf) {
            return (Col)ParIterableLike.to$(this, cbf);
        }

        @Override
        public int scanBlockSize() {
            return ParIterableLike.scanBlockSize$(this);
        }

        @Override
        public <S> S $div$colon(S z, Function2<S, V, S> op) {
            return (S)ParIterableLike.$div$colon$(this, z, op);
        }

        @Override
        public <S> S $colon$bslash(S z, Function2<V, S, S> op) {
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
        public Combiner<V, ParIterable<V>> parCombiner() {
            return CustomParallelizable.parCombiner$(this);
        }

        @Override
        public Builder<V, ParIterable<V>> newBuilder() {
            return GenericParTemplate.newBuilder$(this);
        }

        @Override
        public Combiner<V, ParIterable<V>> newCombiner() {
            return GenericParTemplate.newCombiner$(this);
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
        public <A1, A2> Tuple2<ParIterable<A1>, ParIterable<A2>> unzip(Function1<V, Tuple2<A1, A2>> asPair) {
            return GenericTraversableTemplate.unzip$(this, asPair);
        }

        @Override
        public <A1, A2, A3> Tuple3<ParIterable<A1>, ParIterable<A2>, ParIterable<A3>> unzip3(Function1<V, Tuple3<A1, A2, A3>> asTriple) {
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
                this.ScanNode$lzycompute$2();
            }
            return this.ScanNode$module;
        }

        @Override
        public ParIterableLike$ScanLeaf$ ScanLeaf() {
            if (this.ScanLeaf$module == null) {
                this.ScanLeaf$lzycompute$2();
            }
            return this.ScanLeaf$module;
        }

        @Override
        public IterableSplitter<V> splitter() {
            return this.scala$collection$parallel$ParMapLike$DefaultValuesIterable$$$outer().scala$collection$parallel$ParMapLike$$valuesIterator(this.scala$collection$parallel$ParMapLike$DefaultValuesIterable$$$outer().splitter());
        }

        @Override
        public int size() {
            return this.scala$collection$parallel$ParMapLike$DefaultValuesIterable$$$outer().size();
        }

        @Override
        public <U> void foreach(Function1<V, U> f) {
            this.scala$collection$parallel$ParMapLike$DefaultValuesIterable$$$outer().withFilter((Function1<Tuple2, Object> & java.io.Serializable & Serializable)(T check$ifrefutable$2) -> BoxesRunTime.boxToBoolean(bl = check$ifrefutable$2 != null)).foreach((Function1<Tuple2, Object> & java.io.Serializable & Serializable)(A x$6) -> {
                if (x$6 == null) {
                    throw new MatchError((Object)null);
                }
                Object v = x$6._2();
                Object r = f.apply(v);
                return r;
            });
        }

        @Override
        public Iterable<V> seq() {
            return ((MapLike)this.scala$collection$parallel$ParMapLike$DefaultValuesIterable$$$outer().seq()).values();
        }

        public /* synthetic */ ParMapLike scala$collection$parallel$ParMapLike$DefaultValuesIterable$$$outer() {
            return ParMapLike.this;
        }

        private final void ScanNode$lzycompute$2() {
            synchronized (this) {
                if (this.ScanNode$module == null) {
                    this.ScanNode$module = new ParIterableLike$ScanNode$(this);
                }
                return;
            }
        }

        private final void ScanLeaf$lzycompute$2() {
            synchronized (this) {
                if (this.ScanLeaf$module == null) {
                    this.ScanLeaf$module = new ParIterableLike$ScanLeaf$(this);
                }
                return;
            }
        }

        public DefaultValuesIterable() {
            if (ParMapLike.this == null) {
                throw null;
            }
            GenTraversableOnce.$init$(this);
            Parallelizable.$init$(this);
            GenericTraversableTemplate.$init$(this);
            GenTraversable.$init$(this);
            GenIterable.$init$(this);
            GenericParTemplate.$init$(this);
            CustomParallelizable.$init$(this);
            ParIterableLike.$init$(this);
            ParIterable.$init$(this);
        }
    }
}

