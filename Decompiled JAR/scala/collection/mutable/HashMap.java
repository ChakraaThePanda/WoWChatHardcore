/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import scala.Function0;
import scala.Function1;
import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.AbstractIterator;
import scala.collection.CustomParallelizable;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.MapLike;
import scala.collection.Set;
import scala.collection.generic.CanBuildFrom;
import scala.collection.mutable.AbstractMap;
import scala.collection.mutable.DefaultEntry;
import scala.collection.mutable.HashEntry;
import scala.collection.mutable.HashMap$;
import scala.collection.mutable.HashTable;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.mutable.ParHashMap;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.LambdaDeserialize;

@ScalaSignature(bytes="\u0006\u0001\t\u0005d\u0001B\u0014)\u0001=B\u0001B\u0019\u0001\u0003\u0002\u0003\u0006Ia\u0019\u0005\u0007U\u0002!\tAK6\u0006\t5\u0004\u0001A\u0014\u0005\u0006]\u0002!\te\u001c\u0005\u0006a\u0002!\t%\u001d\u0005\u0006k\u0002!\tE\u001e\u0005\u0006U\u0002!\tA\u001f\u0005\u0006w\u0002!\t\u0005 \u0005\u0006{\u0002!\tE \u0005\b\u0003\u0013\u0001A\u0011IA\u0006\u0011\u001d\ty\u0001\u0001C\u0001\u0003#Aq!a\u0007\u0001\t\u0003\ni\u0002\u0003\u0005\u0002,\u0001\u0001K\u0011BA\u0017\u0011!\tI\u0004\u0001Q\u0005\n\u0005m\u0002\u0002CA\"\u0001\u0001&I!!\u0012\t\u0011\u0005-\u0003\u0001)C\u0005\u0003\u001bBq!a\u0015\u0001\t\u0003\n)\u0006C\u0004\u0002^\u0001!\t%a\u0018\t\u000f\u0005\u0015\u0004\u0001\"\u0011\u0002h!9\u00111\u000e\u0001\u0005\u0002\u00055\u0004bBA:\u0001\u0011\u0005\u0011Q\u000f\u0005\b\u0003s\u0002A\u0011AA>\u0011\u001d\t\u0019\t\u0001C!\u0003\u000bCq!!'\u0001\t\u0003\nY\nC\u0004\u0002$\u0002!\t%!*\t\u000f\u00055\u0006\u0001\"\u0011\u00020\"9\u00111\u0017\u0001\u0005B\u0005U\u0006bBA]\u0001\u0011\u0005\u00111\u0018\u0005\b\u0003\u0003\u0004A\u0011CAb\u0011\u001d\t\t\u000e\u0001C\u0005\u0003'Dq!!;\u0001\t\u0013\tYoB\u0004\u0003\u0002!B\tAa\u0001\u0007\r\u001dB\u0003\u0012\u0001B\u0003\u0011\u0019Q\u0017\u0005\"\u0001\u0003\u0016!9!qC\u0011\u0005\u0004\te\u0001\u0002\u0003B\u001eC\u0001\u0006IA!\u0010\t\r9\fC\u0011\u0001B\"\u0011%\u0011\t&IA\u0001\n\u0013\u0011\u0019FA\u0004ICNDW*\u00199\u000b\u0005%R\u0013aB7vi\u0006\u0014G.\u001a\u0006\u0003W1\n!bY8mY\u0016\u001cG/[8o\u0015\u0005i\u0013!B:dC2\f7\u0001A\u000b\u0004a]\u00125c\u0002\u00012\t\u001e[\u0015k\u0018\t\u0005eM*\u0014)D\u0001)\u0013\t!\u0004FA\u0006BEN$(/Y2u\u001b\u0006\u0004\bC\u0001\u001c8\u0019\u0001!Q\u0001\u000f\u0001C\u0002e\u0012\u0011!Q\t\u0003uy\u0002\"a\u000f\u001f\u000e\u00031J!!\u0010\u0017\u0003\u000f9{G\u000f[5oOB\u00111hP\u0005\u0003\u00012\u00121!\u00118z!\t1$\tB\u0003D\u0001\t\u0007\u0011HA\u0001C!\u0011\u0011T)N!\n\u0005\u0019C#aA'baB)!\u0007S\u001bB\u0015&\u0011\u0011\n\u000b\u0002\b\u001b\u0006\u0004H*[6f!\u0011\u0011\u0004!N!\u0011\tIbUGT\u0005\u0003\u001b\"\u0012\u0011\u0002S1tQR\u000b'\r\\3\u0011\tIzU'Q\u0005\u0003!\"\u0012A\u0002R3gCVdG/\u00128uef\u0004BAU*V16\t!&\u0003\u0002UU\t!2)^:u_6\u0004\u0016M]1mY\u0016d\u0017N_1cY\u0016\u0004Ba\u000f,6\u0003&\u0011q\u000b\f\u0002\u0007)V\u0004H.\u001a\u001a\u0011\tekV'Q\u0007\u00025*\u0011\u0011f\u0017\u0006\u00039*\n\u0001\u0002]1sC2dW\r\\\u0005\u0003=j\u0013!\u0002U1s\u0011\u0006\u001c\b.T1q!\tY\u0004-\u0003\u0002bY\ta1+\u001a:jC2L'0\u00192mK\u0006A1m\u001c8uK:$8\u000f\u0005\u0003eOVreB\u0001\u001af\u0013\t1\u0007&A\u0005ICNDG+\u00192mK&\u0011\u0001.\u001b\u0002\t\u0007>tG/\u001a8ug*\u0011a\rK\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0005)c\u0007\"\u00022\u0003\u0001\u0004\u0019'!B#oiJL\u0018!B3naRLX#\u0001&\u0002\u000b\rdW-\u0019:\u0015\u0003I\u0004\"aO:\n\u0005Qd#\u0001B+oSR\fAa]5{KV\tq\u000f\u0005\u0002<q&\u0011\u0011\u0010\f\u0002\u0004\u0013:$H#\u0001&\u0002\u0007A\f'/F\u0001Y\u0003!\u0019wN\u001c;bS:\u001cHcA@\u0002\u0006A\u00191(!\u0001\n\u0007\u0005\rAFA\u0004C_>dW-\u00198\t\r\u0005\u001d\u0011\u00021\u00016\u0003\rYW-_\u0001\u0006CB\u0004H.\u001f\u000b\u0004\u0003\u00065\u0001BBA\u0004\u0015\u0001\u0007Q'A\u0002hKR$B!a\u0005\u0002\u001aA!1(!\u0006B\u0013\r\t9\u0002\f\u0002\u0007\u001fB$\u0018n\u001c8\t\r\u0005\u001d1\u00021\u00016\u0003=9W\r^(s\u000b2\u001cX-\u00169eCR,G#B!\u0002 \u0005\u0005\u0002BBA\u0004\u0019\u0001\u0007Q\u0007\u0003\u0005\u0002$1!\t\u0019AA\u0013\u00031!WMZ1vYR4\u0016\r\\;f!\u0011Y\u0014qE!\n\u0007\u0005%BF\u0001\u0005=Eft\u0017-\\3?\u0003%1\u0017N\u001c3F]R\u0014\u0018\u0010\u0006\u0004\u00020\u0005M\u0012Q\u0007\t\u0004\u0003c\u0019Q\"\u0001\u0001\t\r\u0005\u001dQ\u00021\u00016\u0011\u0019\t9$\u0004a\u0001o\u0006\t\u0001.\u0001\u0005o_R4u.\u001e8e)\u0015y\u0018QHA \u0011\u0019\t9A\u0004a\u0001k!9\u0011\u0011\t\bA\u0002\u0005=\u0012!A3\u0002\u0011\u0005$G-\u00128uef$R!QA$\u0003\u0013Bq!!\u0011\u0010\u0001\u0004\ty\u0003\u0003\u0004\u00028=\u0001\ra^\u0001\nC\u0012$WI\u001c;ssB\"RA]A(\u0003#Bq!!\u0011\u0011\u0001\u0004\ty\u0003\u0003\u0004\u00028A\u0001\ra^\u0001\u0004aV$HCBA\n\u0003/\nI\u0006\u0003\u0004\u0002\bE\u0001\r!\u000e\u0005\u0007\u00037\n\u0002\u0019A!\u0002\u000bY\fG.^3\u0002\rU\u0004H-\u0019;f)\u0015\u0011\u0018\u0011MA2\u0011\u0019\t9A\u0005a\u0001k!1\u00111\f\nA\u0002\u0005\u000baA]3n_Z,G\u0003BA\n\u0003SBa!a\u0002\u0014\u0001\u0004)\u0014\u0001\u0003\u0013qYV\u001cH%Z9\u0015\t\u0005E\u0012q\u000e\u0005\u0007\u0003c\"\u0002\u0019A+\u0002\u0005-4\u0018!\u0003\u0013nS:,8\u000fJ3r)\u0011\t\t$a\u001e\t\r\u0005\u001dQ\u00031\u00016\u0003!IG/\u001a:bi>\u0014XCAA?!\u0011\u0011\u0016qP+\n\u0007\u0005\u0005%F\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u0003\u001d1wN]3bG\",B!a\"\u0002\u0016R\u0019!/!#\t\u000f\u0005-u\u00031\u0001\u0002\u000e\u0006\ta\r\u0005\u0004<\u0003\u001f+\u00161S\u0005\u0004\u0003#c#!\u0003$v]\u000e$\u0018n\u001c82!\r1\u0014Q\u0013\u0003\u0007\u0003/;\"\u0019A\u001d\u0003\u0003U\u000baa[3z'\u0016$XCAAO!\u0011\u0011\u0016qT\u001b\n\u0007\u0005\u0005&FA\u0002TKR\faA^1mk\u0016\u001cXCAAT!\u0011\u0011\u0016\u0011V!\n\u0007\u0005-&F\u0001\u0005Ji\u0016\u0014\u0018M\u00197f\u00031YW-_:Ji\u0016\u0014\u0018\r^8s+\t\t\t\f\u0005\u0003S\u0003\u007f*\u0014A\u0004<bYV,7/\u0013;fe\u0006$xN]\u000b\u0003\u0003o\u0003BAUA@\u0003\u0006QQo]3TSj,W*\u00199\u0015\u0007I\fi\f\u0003\u0004\u0002@r\u0001\ra`\u0001\u0002i\u0006q1M]3bi\u0016tUm^#oiJLX\u0003BAc\u0003\u001b$b!a\f\u0002H\u0006%\u0007BBA\u0004;\u0001\u0007Q\u0007C\u0004\u0002\\u\u0001\r!a3\u0011\u0007Y\ni\r\u0002\u0004\u0002Pv\u0011\r!\u000f\u0002\u0003\u0005F\n1b\u001e:ji\u0016|%M[3diR\u0019!/!6\t\u000f\u0005]g\u00041\u0001\u0002Z\u0006\u0019q.\u001e;\u0011\t\u0005m\u0017Q]\u0007\u0003\u0003;TA!a8\u0002b\u0006\u0011\u0011n\u001c\u0006\u0003\u0003G\fAA[1wC&!\u0011q]Ao\u0005Iy%M[3di>+H\u000f];u'R\u0014X-Y7\u0002\u0015I,\u0017\rZ(cU\u0016\u001cG\u000fF\u0002s\u0003[Dq!a< \u0001\u0004\t\t0\u0001\u0002j]B!\u00111\\Az\u0013\u0011\t)0!8\u0003#=\u0013'.Z2u\u0013:\u0004X\u000f^*ue\u0016\fW\u000eK\u0004\u0001\u0003s\fY&a@\u0011\u0007m\nY0C\u0002\u0002~2\u0012\u0001cU3sS\u0006dg+\u001a:tS>tW+\u0013#\u001f\u0003\u0005\tq\u0001S1tQ6\u000b\u0007\u000f\u0005\u00023CM!\u0011Ea\u0002`!\u0019\u0011IAa\u0004\u0003\u00145\u0011!1\u0002\u0006\u0004\u0005\u001bQ\u0013aB4f]\u0016\u0014\u0018nY\u0005\u0005\u0005#\u0011YAA\tNkR\f'\r\\3NCB4\u0015m\u0019;pef\u0004\"A\r\u0001\u0015\u0005\t\r\u0011\u0001D2b]\n+\u0018\u000e\u001c3Ge>lWC\u0002B\u000e\u0005g\u00119$\u0006\u0002\u0003\u001eAQ!\u0011\u0002B\u0010\u0005G\u0011yC!\u000f\n\t\t\u0005\"1\u0002\u0002\r\u0007\u0006t')^5mI\u001a\u0013x.\u001c\t\u0005\u0005K\u00119#D\u0001\"\u0013\u0011\u0011ICa\u000b\u0003\t\r{G\u000e\\\u0005\u0005\u0005[\u0011YAA\u0007HK:l\u0015\r\u001d$bGR|'/\u001f\t\u0007wY\u0013\tD!\u000e\u0011\u0007Y\u0012\u0019\u0004B\u00039G\t\u0007\u0011\bE\u00027\u0005o!QaQ\u0012C\u0002e\u0002bA\r\u0001\u00032\tU\u0012a\u0003*fkN\f'\r\\3D\u0005\u001a\u0003bA!\n\u0003@yr\u0014\u0002\u0002B!\u0005W\u0011q\"T1q\u0007\u0006t')^5mI\u001a\u0013x.\\\u000b\u0007\u0005\u000b\u0012YEa\u0014\u0016\u0005\t\u001d\u0003C\u0002\u001a\u0001\u0005\u0013\u0012i\u0005E\u00027\u0005\u0017\"Q\u0001O\u0013C\u0002e\u00022A\u000eB(\t\u0015\u0019UE1\u0001:\u0003-\u0011X-\u00193SKN|GN^3\u0015\u0005\tU\u0003\u0003\u0002B,\u0005;j!A!\u0017\u000b\t\tm\u0013\u0011]\u0001\u0005Y\u0006tw-\u0003\u0003\u0003`\te#AB(cU\u0016\u001cG\u000f")
public class HashMap<A, B>
extends AbstractMap<A, B>
implements HashTable<A, DefaultEntry<A, B>>,
CustomParallelizable<Tuple2<A, B>, ParHashMap<A, B>>,
Serializable {
    public static final long serialVersionUID = 1L;
    private transient int _loadFactor;
    private transient HashEntry<A, DefaultEntry<A, B>>[] table;
    private transient int tableSize;
    private transient int threshold;
    private transient int[] sizemap;
    private transient int seedvalue;

    public static <A, B> CanBuildFrom<HashMap<?, ?>, Tuple2<A, B>, HashMap<A, B>> canBuildFrom() {
        return HashMap$.MODULE$.canBuildFrom();
    }

    @Override
    public Combiner<Tuple2<A, B>, ParHashMap<A, B>> parCombiner() {
        return CustomParallelizable.parCombiner$(this);
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
    public void init(ObjectInputStream in, Function0<DefaultEntry<A, B>> readEntry2) {
        HashTable.init$(this, in, readEntry2);
    }

    @Override
    public void serializeTo(ObjectOutputStream out, Function1<DefaultEntry<A, B>, BoxedUnit> writeEntry) {
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
    public Iterator<DefaultEntry<A, B>> entriesIterator() {
        return HashTable.entriesIterator$(this);
    }

    @Override
    public <U> void foreachEntry(Function1<DefaultEntry<A, B>, U> f) {
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
    public boolean alwaysInitSizeMap() {
        return HashTable.alwaysInitSizeMap$(this);
    }

    @Override
    public boolean elemEquals(A key1, A key2) {
        return HashTable.elemEquals$(this, key1, key2);
    }

    @Override
    public final int index(int hcode) {
        return HashTable.index$(this, hcode);
    }

    @Override
    public void initWithContents(HashTable.Contents<A, DefaultEntry<A, B>> c) {
        HashTable.initWithContents$(this, c);
    }

    @Override
    public HashTable.Contents<A, DefaultEntry<A, B>> hashTableContents() {
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
    public int elemHashCode(A key) {
        return HashTable.HashUtils.elemHashCode$(this, key);
    }

    @Override
    public final int improve(int hcode, int seed) {
        return HashTable.HashUtils.improve$(this, hcode, seed);
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
    public HashEntry<A, DefaultEntry<A, B>>[] table() {
        return this.table;
    }

    @Override
    public void table_$eq(HashEntry<A, DefaultEntry<A, B>>[] x$1) {
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
    public HashMap<A, B> empty() {
        return HashMap$.MODULE$.empty();
    }

    @Override
    public void clear() {
        this.clearTable();
    }

    @Override
    public int size() {
        return this.tableSize();
    }

    @Override
    public ParHashMap<A, B> par() {
        return new ParHashMap<A, B>(this.hashTableContents());
    }

    @Override
    public boolean contains(A key) {
        return this.findEntry((Object)key) != null;
    }

    @Override
    public B apply(A key) {
        DefaultEntry result2 = (DefaultEntry)this.findEntry((Object)key);
        if (result2 == null) {
            return (B)this.default(key);
        }
        return result2.value();
    }

    @Override
    public Option<B> get(A key) {
        DefaultEntry e = (DefaultEntry)this.findEntry((Object)key);
        if (e == null) {
            return None$.MODULE$;
        }
        return new Some(e.value());
    }

    @Override
    public B getOrElseUpdate(A key, Function0<B> defaultValue) {
        int hash = this.elemHashCode(key);
        int i = this.index(hash);
        DefaultEntry<A, B> firstEntry = this.findEntry(key, i);
        if (firstEntry != null) {
            return firstEntry.value();
        }
        HashEntry<A, DefaultEntry<A, B>>[] table0 = this.table();
        B b = defaultValue.apply();
        int newEntryIndex = table0 == this.table() ? i : this.index(hash);
        HashEntry e = this.createNewEntry((Object)key, (Object)b);
        DefaultEntry<A, B> secondEntry = this.findEntry(key, newEntryIndex);
        if (secondEntry == null) {
            this.addEntry((DefaultEntry<A, B>)e, newEntryIndex);
        } else {
            secondEntry.value_$eq(b);
        }
        return b;
    }

    /*
     * WARNING - void declaration
     */
    private DefaultEntry<A, B> findEntry(A key, int h) {
        void var3_3;
        DefaultEntry e = (DefaultEntry)this.table()[h];
        while (this.notFound(key, e)) {
            e = (DefaultEntry)e.next();
        }
        return var3_3;
    }

    private boolean notFound(A key, DefaultEntry<A, B> e) {
        return e != null && !this.elemEquals(e.key(), key);
    }

    private B addEntry(DefaultEntry<A, B> e, int h) {
        if (this.tableSize() >= this.threshold()) {
            this.addEntry(e);
        } else {
            this.addEntry0(e, h);
        }
        return e.value();
    }

    private void addEntry0(DefaultEntry<A, B> e, int h) {
        e.next_$eq((Object)((DefaultEntry)this.table()[h]));
        this.table()[h] = e;
        this.tableSize_$eq(this.tableSize() + 1);
        this.nnSizeMapAdd(h);
    }

    @Override
    public Option<B> put(A key, B value) {
        DefaultEntry e = (DefaultEntry)this.findOrAddEntry((Object)key, (Object)value);
        if (e == null) {
            return None$.MODULE$;
        }
        Object v = e.value();
        e.value_$eq(value);
        return new Some(v);
    }

    @Override
    public void update(A key, B value) {
        this.put(key, value);
    }

    @Override
    public Option<B> remove(A key) {
        DefaultEntry e = (DefaultEntry)this.removeEntry((Object)key);
        if (e != null) {
            return new Some(e.value());
        }
        return None$.MODULE$;
    }

    @Override
    public HashMap<A, B> $plus$eq(Tuple2<A, B> kv) {
        DefaultEntry e = (DefaultEntry)this.findOrAddEntry((Object)kv._1(), (Object)kv._2());
        if (e != null) {
            e.value_$eq(kv._2());
        }
        return this;
    }

    public HashMap<A, B> $minus$eq(A key) {
        this.removeEntry((Object)key);
        return this;
    }

    @Override
    public Iterator<Tuple2<A, B>> iterator() {
        return this.entriesIterator().map((Function1<DefaultEntry, Tuple2> & java.io.Serializable & Serializable)e -> new Tuple2(e.key(), e.value()));
    }

    @Override
    public <U> void foreach(Function1<Tuple2<A, B>, U> f) {
        this.foreachEntry((Function1<DefaultEntry<A, B>, U>)(Function1<DefaultEntry, Object> & java.io.Serializable & Serializable)e -> f.apply(new Tuple2(e.key(), e.value())));
    }

    @Override
    public Set<A> keySet() {
        return new MapLike.DefaultKeySet(this){
            private final /* synthetic */ HashMap $outer;

            public <U> void foreach(Function1<A, U> f) {
                this.$outer.foreachEntry((Function1<DefaultEntry, Object> & java.io.Serializable & Serializable)e -> f.apply(e.key()));
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$foreach$2(scala.Function1 scala.collection.mutable.DefaultEntry )}, serializedLambda);
            }
        };
    }

    @Override
    public Iterable<B> values() {
        return new MapLike.DefaultValuesIterable(this){
            private final /* synthetic */ HashMap $outer;

            public <U> void foreach(Function1<B, U> f) {
                this.$outer.foreachEntry((Function1<DefaultEntry, Object> & java.io.Serializable & Serializable)e -> f.apply(e.value()));
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$foreach$3(scala.Function1 scala.collection.mutable.DefaultEntry )}, serializedLambda);
            }
        };
    }

    @Override
    public Iterator<A> keysIterator() {
        return new AbstractIterator<A>(this){
            private final Iterator<DefaultEntry<A, B>> iter;

            private Iterator<DefaultEntry<A, B>> iter() {
                return this.iter;
            }

            public boolean hasNext() {
                return this.iter().hasNext();
            }

            public A next() {
                return this.iter().next().key();
            }
            {
                this.iter = $outer.entriesIterator();
            }
        };
    }

    @Override
    public Iterator<B> valuesIterator() {
        return new AbstractIterator<B>(this){
            private final Iterator<DefaultEntry<A, B>> iter;

            private Iterator<DefaultEntry<A, B>> iter() {
                return this.iter;
            }

            public boolean hasNext() {
                return this.iter().hasNext();
            }

            public B next() {
                return this.iter().next().value();
            }
            {
                this.iter = $outer.entriesIterator();
            }
        };
    }

    public void useSizeMap(boolean t) {
        if (t) {
            if (!this.isSizeMapDefined()) {
                this.sizeMapInitAndRebuild();
                return;
            }
        } else {
            this.sizeMapDisable();
        }
    }

    @Override
    public <B1> DefaultEntry<A, B> createNewEntry(A key, B1 value) {
        return new DefaultEntry<A, B1>(key, value);
    }

    private void writeObject(ObjectOutputStream out) {
        this.serializeTo(out, (Function1<DefaultEntry<A, B>, BoxedUnit>)(Function1<DefaultEntry, Object> & java.io.Serializable & Serializable)entry -> {
            HashMap.$anonfun$writeObject$1(out, entry);
            return BoxedUnit.UNIT;
        });
    }

    private void readObject(ObjectInputStream in) {
        this.init(in, (Function0<DefaultEntry<A, B>>)(Function0<DefaultEntry> & java.io.Serializable & Serializable)() -> this.createNewEntry(in.readObject(), in.readObject()));
    }

    public static final /* synthetic */ void $anonfun$writeObject$1(ObjectOutputStream out$1, DefaultEntry entry) {
        out$1.writeObject(entry.key());
        out$1.writeObject(entry.value());
    }

    public HashMap(HashTable.Contents<A, DefaultEntry<A, B>> contents) {
        HashTable.HashUtils.$init$(this);
        HashTable.$init$(this);
        CustomParallelizable.$init$(this);
        this.initWithContents(contents);
    }

    public HashMap() {
        this(null);
    }
}

