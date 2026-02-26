/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.mutable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.None$;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
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
import scala.collection.immutable.IndexedSeq$;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.Cloneable;
import scala.collection.mutable.DefaultEntry;
import scala.collection.mutable.HashEntry;
import scala.collection.mutable.HashMap;
import scala.collection.mutable.HashTable;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.CombinerFactory;
import scala.collection.parallel.IterableSplitter;
import scala.collection.parallel.ParIterableLike;
import scala.collection.parallel.ParIterableLike$ScanLeaf$;
import scala.collection.parallel.ParIterableLike$ScanNode$;
import scala.collection.parallel.ParMap;
import scala.collection.parallel.ParSet;
import scala.collection.parallel.Splitter;
import scala.collection.parallel.TaskSupport;
import scala.collection.parallel.mutable.ParHashMap$;
import scala.collection.parallel.mutable.ParHashMapCombiner;
import scala.collection.parallel.mutable.ParHashMapCombiner$;
import scala.collection.parallel.mutable.ParHashTable;
import scala.collection.parallel.mutable.ParIterable;
import scala.collection.parallel.mutable.ParMapLike;
import scala.collection.parallel.mutable.ParSeq;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.RichInt$;
import scala.runtime.java8.JFunction2$mcIII$sp;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@ScalaSignature(bytes="\u0006\u0001\t]e\u0001B\u0016-\u0001UB\u0001B\u001a\u0001\u0003\u0002\u0003\u0006Ia\u001a\u0005\u0007]\u0002!\t\u0001M8\u0006\tE\u0004\u0001\u0001\u0019\u0005\u0006]\u0002!\tA\u001d\u0005\u0006g\u0002!\t\u0005\u001e\u0005\u0006q\u0002!\t%\u001f\u0005\u0007u\u0002\u0001K\u0011K>\t\r}\u0004A\u0011IA\u0001\u0011\u001d\t\u0019\u0001\u0001C\u0001\u0003\u000bAq!a\u0014\u0001\t\u0003\n\t\u0006C\u0004\u0002T\u0001!\t%!\u0016\t\u000f\u0005u\u0003\u0001\"\u0001\u0002`!9\u00111\u000e\u0001\u0005\u0002\u00055\u0004bBA;\u0001\u0011\u0005\u0011q\u000f\u0005\b\u0003{\u0002A\u0011AA@\u0011\u001d\t\u0019\t\u0001C\u0001\u0003\u000bCq!a#\u0001\t\u0003\ti\tC\u0004\u0002\u0012\u0002!\t%a%\u0007\r\u0005-\u0001\u0001AA\u0007\u0011)\tYb\u0005B\u0001B\u0003%\u0011Q\u0004\u0005\u000b\u0003G\u0019\"\u0011!Q\u0001\n\u0005u\u0001BCA\u0013'\t\u0005\t\u0015!\u0003\u0002\u001e!I\u0011qE\n\u0003\u0002\u0003\u0006I\u0001\u0019\u0005\u0007]N!\t!!\u000b\t\u000f\u0005M2\u0003\"\u0001\u00026!9\u00111H\n\u0005\u0002\u0005u\u0002bBAS\u0001\u0011E\u0011q\u0015\u0005\b\u0003o\u0003A\u0011BA]\u0011\u001d\tY\r\u0001C\u0005\u0003\u001bD\u0001\"!7\u0001\t\u0003r\u00131\u001c\u0005\b\u0003s\u0004A\u0011BA~\u0011\u001d\u0011i\u0001\u0001C\u0005\u0005\u001f9qA!\u000b-\u0011\u0003\u0011YC\u0002\u0004,Y!\u0005!Q\u0006\u0005\u0007]\n\"\tA!\u000e\t\u0013\t]\"\u00051A\u0005\u0002\u0005E\u0003\"\u0003B\u001dE\u0001\u0007I\u0011\u0001B\u001e\u0011!\u0011\tE\tQ!\n\u0005u\u0001B\u0002=#\t\u0003\u0011\u0019\u0005\u0003\u0004{E\u0011\u0005!\u0011\u000b\u0005\b\u0005S\u0012C1\u0001B6\u0011%\u0011iIIA\u0001\n\u0013\u0011yI\u0001\u0006QCJD\u0015m\u001d5NCBT!!\f\u0018\u0002\u000f5,H/\u00192mK*\u0011q\u0006M\u0001\ta\u0006\u0014\u0018\r\u001c7fY*\u0011\u0011GM\u0001\u000bG>dG.Z2uS>t'\"A\u001a\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0019a'Q&\u0014\u000f\u000194(\u0014+^GB\u0011\u0001(O\u0007\u0002e%\u0011!H\r\u0002\u0007\u0003:L(+\u001a4\u0011\tqjtHS\u0007\u0002Y%\u0011a\b\f\u0002\u0007!\u0006\u0014X*\u00199\u0011\u0005\u0001\u000bE\u0002\u0001\u0003\u0006\u0005\u0002\u0011\ra\u0011\u0002\u0002\u0017F\u0011Ai\u0012\t\u0003q\u0015K!A\u0012\u001a\u0003\u000f9{G\u000f[5oOB\u0011\u0001\bS\u0005\u0003\u0013J\u00121!\u00118z!\t\u00015\nB\u0003M\u0001\t\u00071IA\u0001W!\u0015q\u0015k\u0010&T\u001b\u0005y%B\u0001)1\u0003\u001d9WM\\3sS\u000eL!AU(\u0003+\u001d+g.\u001a:jGB\u000b'/T1q)\u0016l\u0007\u000f\\1uKB\u0011A\b\u0001\t\u0007yU{$j\u0016-\n\u0005Yc#A\u0003)be6\u000b\u0007\u000fT5lKB!A\bA K!\u0011I6l\u0010&\u000e\u0003iS!!\f\u0019\n\u0005qS&a\u0002%bg\"l\u0015\r\u001d\t\u0005yy{\u0004-\u0003\u0002`Y\ta\u0001+\u0019:ICNDG+\u00192mKB!\u0011,Y K\u0013\t\u0011'L\u0001\u0007EK\u001a\fW\u000f\u001c;F]R\u0014\u0018\u0010\u0005\u00029I&\u0011QM\r\u0002\r'\u0016\u0014\u0018.\u00197ju\u0006\u0014G.Z\u0001\tG>tG/\u001a8ugB!\u0001n[ a\u001d\tI\u0016.\u0003\u0002k5\u0006I\u0001*Y:i)\u0006\u0014G.Z\u0005\u0003Y6\u0014\u0001bQ8oi\u0016tGo\u001d\u0006\u0003Uj\u000ba\u0001P5oSRtDCA,q\u0011\u00151'\u00011\u0001h\u0005\u0015)e\u000e\u001e:z)\u00059\u0016\u0001D7ba\u000e{W\u000e]1oS>tW#A;\u0011\u0007938+\u0003\u0002x\u001f\n1r)\u001a8fe&\u001c\u0007+\u0019:NCB\u001cu.\u001c9b]&|g.A\u0003f[B$\u00180F\u0001X\u0003-qWm^\"p[\nLg.\u001a:\u0016\u0003q\u0004B\u0001P?@\u0015&\u0011a\u0010\f\u0002\u0013!\u0006\u0014\b*Y:i\u001b\u0006\u00048i\\7cS:,'/A\u0002tKF,\u0012\u0001W\u0001\tgBd\u0017\u000e\u001e;feV\u0011\u0011q\u0001\t\u0004\u0003\u0013\u0019R\"\u0001\u0001\u0003%A\u000b'\u000fS1tQ6\u000b\u0007/\u0013;fe\u0006$xN]\n\u0004'\u0005=\u0001\u0003CA\u0005\u0003#\t)\"a\u0002\n\u0007\u0005MaLA\u0007F]R\u0014\u00180\u0013;fe\u0006$xN\u001d\t\u0006q\u0005]qHS\u0005\u0004\u00033\u0011$A\u0002+va2,''A\u0003ti\u0006\u0014H\u000fE\u00029\u0003?I1!!\t3\u0005\rIe\u000e^\u0001\tk:$\u0018\u000e\\%eq\u0006IAo\u001c;bYNK'0Z\u0001\u0002KRQ\u0011qAA\u0016\u0003[\ty#!\r\t\u000f\u0005m\u0001\u00041\u0001\u0002\u001e!9\u00111\u0005\rA\u0002\u0005u\u0001bBA\u00131\u0001\u0007\u0011Q\u0004\u0005\u0007\u0003OA\u0002\u0019\u00011\u0002\u0015\u0015tGO]=3SR,W\u000e\u0006\u0003\u0002\u0016\u0005]\u0002BBA\u001d3\u0001\u0007\u0001-A\u0003f]R\u0014\u00180A\u0006oK^LE/\u001a:bi>\u0014HCCA\u0004\u0003\u007f\t\u0019%a\u0012\u0002L!9\u0011\u0011\t\u000eA\u0002\u0005u\u0011aB5eq\u001a\u0013x.\u001c\u0005\b\u0003\u000bR\u0002\u0019AA\u000f\u0003!IG\r_+oi&d\u0007bBA%5\u0001\u0007\u0011QD\u0001\bi>$\u0018\r\\*{\u0011\u0019\tiE\u0007a\u0001A\u0006\u0011Qm]\u0001\u0005g&TX-\u0006\u0002\u0002\u001e\u0005)1\r\\3beR\u0011\u0011q\u000b\t\u0004q\u0005e\u0013bAA.e\t!QK\\5u\u0003\r9W\r\u001e\u000b\u0005\u0003C\n9\u0007\u0005\u00039\u0003GR\u0015bAA3e\t1q\n\u001d;j_:Da!!\u001b\r\u0001\u0004y\u0014aA6fs\u0006\u0019\u0001/\u001e;\u0015\r\u0005\u0005\u0014qNA9\u0011\u0019\tI'\u0004a\u0001\u007f!1\u00111O\u0007A\u0002)\u000bQA^1mk\u0016\fa!\u001e9eCR,GCBA,\u0003s\nY\b\u0003\u0004\u0002j9\u0001\ra\u0010\u0005\u0007\u0003gr\u0001\u0019\u0001&\u0002\rI,Wn\u001c<f)\u0011\t\t'!!\t\r\u0005%t\u00021\u0001@\u0003!!\u0003\u000f\\;tI\u0015\fH\u0003BA\u0005\u0003\u000fCq!!#\u0011\u0001\u0004\t)\"\u0001\u0002lm\u0006IA%\\5okN$S-\u001d\u000b\u0005\u0003\u0013\ty\t\u0003\u0004\u0002jE\u0001\raP\u0001\rgR\u0014\u0018N\\4Qe\u00164\u0017\u000e_\u000b\u0003\u0003+\u0003B!a&\u0002\"6\u0011\u0011\u0011\u0014\u0006\u0005\u00037\u000bi*\u0001\u0003mC:<'BAAP\u0003\u0011Q\u0017M^1\n\t\u0005\r\u0016\u0011\u0014\u0002\u0007'R\u0014\u0018N\\4\u0002\u001d\r\u0014X-\u0019;f\u001d\u0016<XI\u001c;ssV!\u0011\u0011VAZ)\u0019\tY+!,\u00020B\u0019\u0011\u0011B\u0002\t\r\u0005%4\u00041\u0001@\u0011\u001d\t\u0019h\u0007a\u0001\u0003c\u00032\u0001QAZ\t\u0019\t)l\u0007b\u0001\u0007\n\u0011a+M\u0001\foJLG/Z(cU\u0016\u001cG\u000f\u0006\u0003\u0002X\u0005m\u0006bBA_9\u0001\u0007\u0011qX\u0001\u0004_V$\b\u0003BAa\u0003\u000fl!!a1\u000b\t\u0005\u0015\u0017QT\u0001\u0003S>LA!!3\u0002D\n\u0011rJ\u00196fGR|U\u000f\u001e9viN#(/Z1n\u0003)\u0011X-\u00193PE*,7\r\u001e\u000b\u0005\u0003/\ny\rC\u0004\u0002Rv\u0001\r!a5\u0002\u0005%t\u0007\u0003BAa\u0003+LA!a6\u0002D\n\trJ\u00196fGRLe\u000e];u'R\u0014X-Y7\u0002!\t\u0014xn[3o\u0013:4\u0018M]5b]R\u001cXCAAo!\u0019\ty.!9\u0002f6\t\u0001'C\u0002\u0002dB\u00121aU3r!\u0011\t9/!>\u000f\t\u0005%\u0018\u0011\u001f\t\u0004\u0003W\u0014TBAAw\u0015\r\ty\u000fN\u0001\u0007yI|w\u000e\u001e \n\u0007\u0005M('\u0001\u0004Qe\u0016$WMZ\u0005\u0005\u0003G\u000b9PC\u0002\u0002tJ\n1b\u00195fG.\u0014UoY6fiR!\u0011Q B\u0005!\u0019\tyP!\u0002\u0002\u00166\u0011!\u0011\u0001\u0006\u0004\u0005\u0007\u0001\u0014!C5n[V$\u0018M\u00197f\u0013\u0011\u00119A!\u0001\u0003\t1K7\u000f\u001e\u0005\b\u0005\u0017y\u0002\u0019AA\u000f\u0003\u0005I\u0017AC2iK\u000e\\WI\u001c;ssR!!\u0011\u0003B\u000f!\u0019\u0011\u0019B!\u0007\u0002f:\u0019\u0001H!\u0006\n\u0007\t]!'A\u0004qC\u000e\\\u0017mZ3\n\t\t\u001d!1\u0004\u0006\u0004\u0005/\u0011\u0004b\u0002B\u0006A\u0001\u0007\u0011Q\u0004\u0015\b\u0001\t\u0005\u00121\u000fB\u0014!\rA$1E\u0005\u0004\u0005K\u0011$\u0001E*fe&\fGNV3sg&|g.V%E=\u0005\t\u0011A\u0003)be\"\u000b7\u000f['baB\u0011AHI\n\u0005E\t=2\r\u0005\u0003O\u0005c\u0019\u0016b\u0001B\u001a\u001f\ni\u0001+\u0019:NCB4\u0015m\u0019;pef$\"Aa\u000b\u0002\u000b%$XM]:\u0002\u0013%$XM]:`I\u0015\fH\u0003BA,\u0005{A\u0011Ba\u0010&\u0003\u0003\u0005\r!!\b\u0002\u0007a$\u0013'\u0001\u0004ji\u0016\u00148\u000fI\u000b\u0007\u0005\u000b\u0012YEa\u0014\u0016\u0005\t\u001d\u0003C\u0002\u001f\u0001\u0005\u0013\u0012i\u0005E\u0002A\u0005\u0017\"QAQ\u0014C\u0002\r\u00032\u0001\u0011B(\t\u0015auE1\u0001D+\u0019\u0011\u0019F!\u0019\u0003fU\u0011!Q\u000b\t\t\u0005/\u0012IF!\u0018\u0003h5\ta&C\u0002\u0003\\9\u0012\u0001bQ8nE&tWM\u001d\t\bq\u0005]!q\fB2!\r\u0001%\u0011\r\u0003\u0006\u0005\"\u0012\ra\u0011\t\u0004\u0001\n\u0015D!\u0002')\u0005\u0004\u0019\u0005C\u0002\u001f\u0001\u0005?\u0012\u0019'\u0001\u0007dC:\u0014U/\u001b7e\rJ|W.\u0006\u0004\u0003n\t\u0015%\u0011R\u000b\u0003\u0005_\u0002\u0012B\u0014B9\u0005k\u0012\tIa#\n\u0007\tMtJ\u0001\bDC:\u001cu.\u001c2j]\u00164%o\\7\u0011\t\t]$\u0011P\u0007\u0002E%!!1\u0010B?\u0005\u0011\u0019u\u000e\u001c7\n\u0007\t}tJA\u0007HK:l\u0015\r\u001d$bGR|'/\u001f\t\bq\u0005]!1\u0011BD!\r\u0001%Q\u0011\u0003\u0006\u0005&\u0012\ra\u0011\t\u0004\u0001\n%E!\u0002'*\u0005\u0004\u0019\u0005C\u0002\u001f\u0001\u0005\u0007\u00139)A\u0006sK\u0006$'+Z:pYZ,GC\u0001BI!\u0011\t9Ja%\n\t\tU\u0015\u0011\u0014\u0002\u0007\u001f\nTWm\u0019;")
public class ParHashMap<K, V>
implements scala.collection.parallel.mutable.ParMap<K, V>,
ParHashTable<K, DefaultEntry<K, V>>,
Serializable {
    public static final long serialVersionUID = 1L;
    private transient int _loadFactor;
    private transient HashEntry<K, DefaultEntry<K, V>>[] table;
    private transient int tableSize;
    private transient int threshold;
    private transient int[] sizemap;
    private transient int seedvalue;
    private volatile transient TaskSupport scala$collection$parallel$ParIterableLike$$_tasksupport;
    private volatile ParIterableLike$ScanNode$ ScanNode$module;
    private volatile ParIterableLike$ScanLeaf$ ScanLeaf$module;

    public static <K, V> CanCombineFrom<ParHashMap<?, ?>, Tuple2<K, V>, ParHashMap<K, V>> canBuildFrom() {
        return ParHashMap$.MODULE$.canBuildFrom();
    }

    public static void iters_$eq(int n) {
        ParHashMap$.MODULE$.iters_$eq(n);
    }

    public static int iters() {
        return ParHashMap$.MODULE$.iters();
    }

    @Override
    public boolean alwaysInitSizeMap() {
        return ParHashTable.alwaysInitSizeMap$(this);
    }

    @Override
    public int tableSizeSeed() {
        return HashTable.tableSizeSeed$(this);
    }

    @Override
    public int initialSize() {
        return HashTable.initialSize$(this);
    }

    @Override
    public void init(ObjectInputStream in, Function0<DefaultEntry<K, V>> readEntry2) {
        HashTable.init$(this, in, readEntry2);
    }

    @Override
    public void serializeTo(ObjectOutputStream out, Function1<DefaultEntry<K, V>, BoxedUnit> writeEntry) {
        HashTable.serializeTo$(this, out, writeEntry);
    }

    @Override
    public HashEntry findEntry(Object key) {
        return HashTable.findEntry$(this, key);
    }

    @Override
    public void addEntry(HashEntry e) {
        HashTable.addEntry$(this, e);
    }

    @Override
    public HashEntry findOrAddEntry(Object key, Object value) {
        return HashTable.findOrAddEntry$(this, key, value);
    }

    @Override
    public HashEntry removeEntry(Object key) {
        return HashTable.removeEntry$(this, key);
    }

    @Override
    public Iterator<DefaultEntry<K, V>> entriesIterator() {
        return HashTable.entriesIterator$(this);
    }

    @Override
    public <U> void foreachEntry(Function1<DefaultEntry<K, V>, U> f) {
        HashTable.foreachEntry$(this, f);
    }

    @Override
    public void clearTable() {
        HashTable.clearTable$(this);
    }

    @Override
    public void nnSizeMapAdd(int h) {
        HashTable.nnSizeMapAdd$(this, h);
    }

    @Override
    public void nnSizeMapRemove(int h) {
        HashTable.nnSizeMapRemove$(this, h);
    }

    @Override
    public void nnSizeMapReset(int tableLength) {
        HashTable.nnSizeMapReset$(this, tableLength);
    }

    @Override
    public final int totalSizeMapBuckets() {
        return HashTable.totalSizeMapBuckets$(this);
    }

    @Override
    public int calcSizeMapSize(int tableLength) {
        return HashTable.calcSizeMapSize$(this, tableLength);
    }

    @Override
    public void sizeMapInit(int tableLength) {
        HashTable.sizeMapInit$(this, tableLength);
    }

    @Override
    public void sizeMapInitAndRebuild() {
        HashTable.sizeMapInitAndRebuild$(this);
    }

    @Override
    public void printSizeMap() {
        HashTable.printSizeMap$(this);
    }

    @Override
    public void sizeMapDisable() {
        HashTable.sizeMapDisable$(this);
    }

    @Override
    public boolean isSizeMapDefined() {
        return HashTable.isSizeMapDefined$(this);
    }

    @Override
    public boolean elemEquals(K key1, K key2) {
        return HashTable.elemEquals$(this, key1, key2);
    }

    @Override
    public final int index(int hcode) {
        return HashTable.index$(this, hcode);
    }

    @Override
    public void initWithContents(HashTable.Contents<K, DefaultEntry<K, V>> c) {
        HashTable.initWithContents$(this, c);
    }

    @Override
    public HashTable.Contents<K, DefaultEntry<K, V>> hashTableContents() {
        return HashTable.hashTableContents$(this);
    }

    @Override
    public final int sizeMapBucketBitSize() {
        return HashTable.HashUtils.sizeMapBucketBitSize$(this);
    }

    @Override
    public final int sizeMapBucketSize() {
        return HashTable.HashUtils.sizeMapBucketSize$(this);
    }

    @Override
    public int elemHashCode(K key) {
        return HashTable.HashUtils.elemHashCode$(this, key);
    }

    @Override
    public final int improve(int hcode, int seed) {
        return HashTable.HashUtils.improve$(this, hcode, seed);
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
    public int _loadFactor() {
        return this._loadFactor;
    }

    @Override
    public void _loadFactor_$eq(int x$1) {
        this._loadFactor = x$1;
    }

    @Override
    public HashEntry<K, DefaultEntry<K, V>>[] table() {
        return this.table;
    }

    @Override
    public void table_$eq(HashEntry<K, DefaultEntry<K, V>>[] x$1) {
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

    @Override
    public GenericParMapCompanion<ParHashMap> mapCompanion() {
        return ParHashMap$.MODULE$;
    }

    @Override
    public ParHashMap<K, V> empty() {
        return new ParHashMap<K, V>();
    }

    @Override
    public ParHashMapCombiner<K, V> newCombiner() {
        return ParHashMapCombiner$.MODULE$.apply();
    }

    @Override
    public HashMap<K, V> seq() {
        return new HashMap<K, V>(this.hashTableContents());
    }

    public ParHashMapIterator splitter() {
        return new ParHashMapIterator(this, 1, this.table().length, this.size(), (DefaultEntry)this.table()[0]);
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
    public Option<V> get(K key) {
        DefaultEntry e = (DefaultEntry)this.findEntry(key);
        if (e == null) {
            return None$.MODULE$;
        }
        return new Some(e.value());
    }

    @Override
    public Option<V> put(K key, V value) {
        DefaultEntry e = (DefaultEntry)this.findOrAddEntry(key, value);
        if (e == null) {
            return None$.MODULE$;
        }
        Object v = e.value();
        e.value_$eq(value);
        return new Some(v);
    }

    public void update(K key, V value) {
        this.put(key, value);
    }

    public Option<V> remove(K key) {
        DefaultEntry e = (DefaultEntry)this.removeEntry(key);
        if (e != null) {
            return new Some(e.value());
        }
        return None$.MODULE$;
    }

    public ParHashMap<K, V> $plus$eq(Tuple2<K, V> kv) {
        DefaultEntry e = (DefaultEntry)this.findOrAddEntry(kv._1(), kv._2());
        if (e != null) {
            e.value_$eq(kv._2());
        }
        return this;
    }

    public ParHashMap<K, V> $minus$eq(K key) {
        this.removeEntry(key);
        return this;
    }

    @Override
    public String stringPrefix() {
        return "ParHashMap";
    }

    @Override
    public <V1> DefaultEntry<K, V> createNewEntry(K key, V1 value) {
        return new DefaultEntry<K, V1>(key, value);
    }

    private void writeObject(ObjectOutputStream out) {
        this.serializeTo(out, (Function1<DefaultEntry<K, V>, BoxedUnit>)(Function1<DefaultEntry, Object> & java.io.Serializable & Serializable)entry -> {
            ParHashMap.$anonfun$writeObject$1(out, entry);
            return BoxedUnit.UNIT;
        });
    }

    private void readObject(ObjectInputStream in) {
        this.init(in, (Function0<DefaultEntry<K, V>>)(Function0<DefaultEntry> & java.io.Serializable & Serializable)() -> this.createNewEntry(in.readObject(), in.readObject()));
    }

    @Override
    public Seq<String> brokenInvariants() {
        int n = 0;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        IndexedSeq buckets = RichInt$.MODULE$.until$extension0(n, this.table().length / this.sizeMapBucketSize()).map((Function1<Object, List> & java.io.Serializable & Serializable)(A i) -> this.checkBucket(BoxesRunTime.unboxToInt(i)), IndexedSeq$.MODULE$.canBuildFrom());
        int n2 = 0;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        IndexedSeq elems = RichInt$.MODULE$.until$extension0(n2, this.table().length).map((Function1<Object, List> & java.io.Serializable & Serializable)(A i) -> this.checkEntry(BoxesRunTime.unboxToInt(i)), IndexedSeq$.MODULE$.canBuildFrom());
        return ((TraversableLike)buckets.flatMap((Function1<List, List> & java.io.Serializable & Serializable)(A x) -> x, IndexedSeq$.MODULE$.canBuildFrom())).$plus$plus(elems.flatMap((Function1<List, List> & java.io.Serializable & Serializable)(A x) -> x, IndexedSeq$.MODULE$.canBuildFrom()), IndexedSeq$.MODULE$.canBuildFrom());
    }

    private List<String> checkBucket(int i) {
        int expected = this.sizemap()[i];
        int n = i * this.sizeMapBucketSize();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int found = BoxesRunTime.unboxToInt(RichInt$.MODULE$.until$extension0(n, (i + 1) * this.sizeMapBucketSize()).foldLeft(BoxesRunTime.boxToInteger(0), (JFunction2$mcIII$sp & Serializable)(B acc, A c) -> acc + ParHashMap.count$1(this.table()[c])));
        if (found != expected) {
            return new $colon$colon<Nothing$>((Nothing$)((Object)new StringBuilder(38).append("Found ").append(found).append(" elements, while sizemap showed ").append(expected).toString()), Nil$.MODULE$);
        }
        return Nil$.MODULE$;
    }

    private List<String> checkEntry(int i) {
        return this.check$1(this.table()[i], i);
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

    public static final /* synthetic */ void $anonfun$writeObject$1(ObjectOutputStream out$1, DefaultEntry entry) {
        out$1.writeObject(entry.key());
        out$1.writeObject(entry.value());
    }

    private static final int count$1(HashEntry e) {
        if (e == null) {
            return 0;
        }
        return 1 + ParHashMap.count$1((HashEntry)e.next());
    }

    private final List check$1(HashEntry e, int i$1) {
        while (true) {
            if (e == null) {
                return Nil$.MODULE$;
            }
            if (this.index(this.elemHashCode((K)e.key())) != i$1) break;
            e = (HashEntry)e.next();
        }
        String string = new StringBuilder(27).append("Element ").append(e.key()).append(" at ").append(i$1).append(" with ").append(this.elemHashCode((K)e.key())).append(" maps to ").append(this.index(this.elemHashCode((K)e.key()))).toString();
        return this.check$1((HashEntry)e.next(), i$1).$colon$colon(string);
    }

    public ParHashMap(HashTable.Contents<K, DefaultEntry<K, V>> contents) {
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
        HashTable.HashUtils.$init$(this);
        HashTable.$init$(this);
        ParHashTable.$init$(this);
        this.initWithContents(contents);
    }

    public ParHashMap() {
        this(null);
    }

    public class ParHashMapIterator
    extends ParHashTable.EntryIterator<Tuple2<K, V>, ParHashMapIterator> {
        @Override
        public Tuple2<K, V> entry2item(DefaultEntry<K, V> entry) {
            return new Tuple2(entry.key(), entry.value());
        }

        @Override
        public ParHashMapIterator newIterator(int idxFrom, int idxUntil, int totalSz, DefaultEntry<K, V> es) {
            return new ParHashMapIterator(this.scala$collection$parallel$mutable$ParHashMap$ParHashMapIterator$$$outer(), idxFrom, idxUntil, totalSz, es);
        }

        public /* synthetic */ ParHashMap scala$collection$parallel$mutable$ParHashMap$ParHashMapIterator$$$outer() {
            return (ParHashMap)this.$outer;
        }

        public ParHashMapIterator(ParHashMap $outer, int start, int untilIdx, int totalSize, DefaultEntry<K, V> e) {
            super((ParHashTable)$outer, start, untilIdx, totalSize, e);
        }
    }
}

