/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.mutable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import scala.Array$;
import scala.Function0;
import scala.Function1;
import scala.Option;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.Iterator;
import scala.collection.TraversableLike;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.collection.mutable.ArrayOps;
import scala.collection.mutable.DefaultEntry;
import scala.collection.mutable.HashEntry;
import scala.collection.mutable.HashTable;
import scala.collection.mutable.HashTable$;
import scala.collection.mutable.UnrolledBuffer;
import scala.collection.parallel.BucketCombiner;
import scala.collection.parallel.Task;
import scala.collection.parallel.mutable.ParHashMap;
import scala.collection.parallel.mutable.ParHashMapCombiner$;
import scala.collection.parallel.mutable.ParHashMapCombiner$table$1$;
import scala.collection.parallel.package$;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.LazyRef;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0005\rhA\u0002\u0017.\u0003\u0003iS\u0007\u0003\u0005i\u0001\t\u0015\r\u0011\"\u0003j\u0011!i\u0007A!A!\u0002\u0013Q\u0007\"\u00028\u0001\t\u0003y\u0007bB9\u0001\u0005\u0004%I!\u001b\u0005\u0007e\u0002\u0001\u000b\u0011\u00026\t\u000fM\u0004!\u0019!C\u0005S\"1A\u000f\u0001Q\u0001\n)DQ!\u001e\u0001\u0005\u0002YDQA\u001f\u0001\u0005\u0002m4A\u0001 \u0001\u0001{\"Q\u00111\u0002\u0006\u0003\u0002\u0003\u0006I!!\u0004\t\u0015\u0005\u0005\"B!A!\u0002\u0013\t\u0019\u0003C\u0005\u0002n)\u0011\t\u0011)A\u0005U\"I\u0011q\u000e\u0006\u0003\u0002\u0003\u0006IA\u001b\u0005\u0007]*!\t!!\u001d\t\u000fiT\u0001\u0019!C\u0001S\"I\u00111\u0010\u0006A\u0002\u0013\u0005\u0011Q\u0010\u0005\b\u0003\u0007S\u0001\u0015)\u0003k\u0011\u001d\t)I\u0003C\u0001\u0003\u000fCq!a%\u000b\t\u0013\t)\nC\u0004\u0002 *!\t!!)\t\u000f\u0005=&\u0002\"\u0011\u00022\"9\u0011q\u0017\u0006\u0005\u0002\u0005efaBA\u0013\u0001\u0001\u0001\u0011q\u0005\u0005\n\u0003_A\"\u0011!Q\u0001\n)D\u0011\"!\r\u0019\u0005\u0003\u0005\u000b\u0011\u00026\t\u0013\u0005M\u0002D!A!\u0002\u0013Q\u0007B\u00028\u0019\t\u0003\t)\u0004C\u0004\u0002>a!\t!a\u0010\t\u000f\u0005-\u0003\u0004\"\u0001\u0002N!9\u0011\u0011\f\r\u0005\u0012\u0005ms\u0001CA^[!\u0005q&!0\u0007\u000f1j\u0003\u0012A\u0018\u0002@\"1a.\tC\u0001\u0003\u0003D\u0011\"a1\"\u0005\u0004%\t!L5\t\u000f\u0005\u0015\u0017\u0005)A\u0005U\"I\u0011qY\u0011C\u0002\u0013\u0005Q&\u001b\u0005\b\u0003\u0013\f\u0003\u0015!\u0003k\u0011%\tY-\tb\u0001\n\u0003i\u0013\u000eC\u0004\u0002N\u0006\u0002\u000b\u0011\u00026\t\u0013\u0005=\u0017E1A\u0005\u00025J\u0007bBAiC\u0001\u0006IA\u001b\u0005\b\u0003'\fC\u0011AAk\u0005I\u0001\u0016M\u001d%bg\"l\u0015\r]\"p[\nLg.\u001a:\u000b\u00059z\u0013aB7vi\u0006\u0014G.\u001a\u0006\u0003aE\n\u0001\u0002]1sC2dW\r\u001c\u0006\u0003eM\n!bY8mY\u0016\u001cG/[8o\u0015\u0005!\u0014!B:dC2\fWc\u0001\u001cB\u0019N\u0019\u0001a\u000e-\u0011\raJ4H\u0014*X\u001b\u0005y\u0013B\u0001\u001e0\u00059\u0011UoY6fi\u000e{WNY5oKJ\u0004B\u0001P\u001f@\u00176\t1'\u0003\u0002?g\t1A+\u001e9mKJ\u0002\"\u0001Q!\r\u0001\u0011)!\t\u0001b\u0001\t\n\t1j\u0001\u0001\u0012\u0005\u0015C\u0005C\u0001\u001fG\u0013\t95GA\u0004O_RD\u0017N\\4\u0011\u0005qJ\u0015B\u0001&4\u0005\r\te.\u001f\t\u0003\u00012#Q!\u0014\u0001C\u0002\u0011\u0013\u0011A\u0016\t\u0005\u001fB{4*D\u0001.\u0013\t\tVF\u0001\u0006QCJD\u0015m\u001d5NCB\u0004BaU+@\u00176\tAK\u0003\u0002/c%\u0011a\u000b\u0016\u0002\r\t\u00164\u0017-\u001e7u\u000b:$(/\u001f\t\u0005\u001f\u0002y4\nE\u0002ZK~r!AW2\u000f\u0005m\u0013gB\u0001/b\u001d\ti\u0006-D\u0001_\u0015\ty6)\u0001\u0004=e>|GOP\u0005\u0002i%\u0011!gM\u0005\u0003]EJ!\u0001\u001a+\u0002\u0013!\u000b7\u000f\u001b+bE2,\u0017B\u00014h\u0005%A\u0015m\u001d5Vi&d7O\u0003\u0002e)\u0006yA/\u00192mK2{\u0017\r\u001a$bGR|'/F\u0001k!\ta4.\u0003\u0002mg\t\u0019\u0011J\u001c;\u0002!Q\f'\r\\3M_\u0006$g)Y2u_J\u0004\u0013A\u0002\u001fj]&$h\b\u0006\u0002Xa\")\u0001n\u0001a\u0001U\u0006Qan\u001c8nCN\\G.\u001a8\u0002\u00179|g.\\1tW2,g\u000eI\u0001\ng\u0016,GM^1mk\u0016\f!b]3fIZ\fG.^3!\u0003!!\u0003\u000f\\;tI\u0015\fHCA<y\u001b\u0005\u0001\u0001\"B=\t\u0001\u0004Y\u0014\u0001B3mK6\faA]3tk2$H#\u0001(\u0003\u0015\u0019KG\u000e\u001c\"m_\u000e\\7o\u0005\u0003\u000b}\u0006\r\u0001C\u0001\u001f\u0000\u0013\r\t\ta\r\u0002\u0007\u0003:L(+\u001a4\u0011\ra\n)A[A\u0005\u0013\r\t9a\f\u0002\u0005)\u0006\u001c8\u000e\u0005\u0002x\u0015\u00059!-^2lKR\u001c\b#\u0002\u001f\u0002\u0010\u0005M\u0011bAA\tg\t)\u0011I\u001d:bsB)\u0011QCA\u000e%:\u00191+a\u0006\n\u0007\u0005eA+\u0001\bV]J|G\u000e\\3e\u0005V4g-\u001a:\n\t\u0005u\u0011q\u0004\u0002\t+:\u0014x\u000e\u001c7fI*\u0019\u0011\u0011\u0004+\u0002\u000bQ\f'\r\\3\u0011\u0005]D\"aD!eI&tw\rS1tQR\u000b'\r\\3\u0014\taq\u0018\u0011\u0006\t\u0006'\u0006-rHU\u0005\u0004\u0003[!&!\u0003%bg\"$\u0016M\u00197f\u0003!qW/\\3mK6\u001c\u0018A\u00017g\u0003)y6/Z3em\u0006dW/\u001a\u000b\t\u0003G\t9$!\u000f\u0002<!1\u0011q\u0006\u000fA\u0002)Da!!\r\u001d\u0001\u0004Q\u0007BBA\u001a9\u0001\u0007!.A\u0004tKR\u001c\u0016N_3\u0015\t\u0005\u0005\u0013q\t\t\u0004y\u0005\r\u0013bAA#g\t!QK\\5u\u0011\u0019\tI%\ba\u0001U\u0006\u00111O_\u0001\fS:\u001cXM\u001d;F]R\u0014\u0018\u0010\u0006\u0003\u0002P\u0005U\u0003c\u0001\u001f\u0002R%\u0019\u00111K\u001a\u0003\u000f\t{w\u000e\\3b]\"1\u0011q\u000b\u0010A\u0002I\u000b\u0011!Z\u0001\u000fGJ,\u0017\r^3OK^,e\u000e\u001e:z+\u0011\ti&!\u001b\u0015\u000b\u0015\u000by&a\u0019\t\r\u0005\u0005t\u00041\u0001@\u0003\rYW-\u001f\u0005\b\u0003Kz\u0002\u0019AA4\u0003\u0005A\bc\u0001!\u0002j\u00111\u00111N\u0010C\u0002\u0011\u0013\u0011\u0001W\u0001\u0007_\u001a47/\u001a;\u0002\u000f!|w/\\1osRQ\u0011\u0011BA:\u0003k\n9(!\u001f\t\u000f\u0005-q\u00021\u0001\u0002\u000e!9\u0011\u0011E\bA\u0002\u0005\r\u0002BBA7\u001f\u0001\u0007!\u000e\u0003\u0004\u0002p=\u0001\rA[\u0001\u000be\u0016\u001cX\u000f\u001c;`I\u0015\fH\u0003BA!\u0003\u007fB\u0001\"!!\u0012\u0003\u0003\u0005\rA[\u0001\u0004q\u0012\n\u0014a\u0002:fgVdG\u000fI\u0001\u0005Y\u0016\fg\r\u0006\u0003\u0002B\u0005%\u0005bBAF'\u0001\u0007\u0011QR\u0001\u0005aJ,g\u000f\u0005\u0003=\u0003\u001fS\u0017bAAIg\t1q\n\u001d;j_:\f\u0011BZ5mY\ncwnY6\u0015\u000b)\f9*a'\t\r\u0005eE\u00031\u0001k\u0003\u0015\u0011Gn\\2l\u0011\u001d\ti\n\u0006a\u0001\u0003'\tQ!\u001a7f[N\fQa\u001d9mSR,\"!a)\u0011\r\u0005\u0015\u00161VA\u0005\u001b\t\t9KC\u0002\u0002*F\n\u0011\"[7nkR\f'\r\\3\n\t\u00055\u0016q\u0015\u0002\u0005\u0019&\u001cH/A\u0003nKJ<W\r\u0006\u0003\u0002B\u0005M\u0006bBA[-\u0001\u0007\u0011\u0011B\u0001\u0005i\"\fG/\u0001\ntQ>,H\u000eZ*qY&$h)\u001e:uQ\u0016\u0014XCAA(\u0003I\u0001\u0016M\u001d%bg\"l\u0015\r]\"p[\nLg.\u001a:\u0011\u0005=\u000b3CA\u0011\u007f)\t\ti,\u0001\teSN\u001c'/[7j]\u0006tGOY5ug\u0006\tB-[:de&l\u0017N\\1oi\nLGo\u001d\u0011\u0002\u00139,XN\u00197pG.\u001c\u0018A\u00038v[\ndwnY6tA\u0005\u0001B-[:de&l\u0017N\\1oi6\f7o[\u0001\u0012I&\u001c8M]5nS:\fg\u000e^7bg.\u0004\u0013!\u00048p]6\f7o\u001b7f]\u001e$\b.\u0001\bo_:l\u0017m]6mK:<G\u000f\u001b\u0011\u0002\u000b\u0005\u0004\b\u000f\\=\u0016\r\u0005]\u0017Q\\Aq+\t\tI\u000e\u0005\u0004P\u0001\u0005m\u0017q\u001c\t\u0004\u0001\u0006uG!\u0002\",\u0005\u0004!\u0005c\u0001!\u0002b\u0012)Qj\u000bb\u0001\t\u0002")
public abstract class ParHashMapCombiner<K, V>
extends BucketCombiner<Tuple2<K, V>, ParHashMap<K, V>, DefaultEntry<K, V>, ParHashMapCombiner<K, V>>
implements HashTable.HashUtils<K> {
    private final int tableLoadFactor;
    private final int nonmasklen;
    private final int seedvalue;

    public static <K, V> ParHashMapCombiner<K, V> apply() {
        return ParHashMapCombiner$.MODULE$.apply();
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

    private int tableLoadFactor() {
        return this.tableLoadFactor;
    }

    private int nonmasklen() {
        return this.nonmasklen;
    }

    private int seedvalue() {
        return this.seedvalue;
    }

    @Override
    public ParHashMapCombiner<K, V> $plus$eq(Tuple2<K, V> elem) {
        this.sz_$eq(this.sz() + 1);
        int pos = this.improve(this.elemHashCode(elem._1()), this.seedvalue()) >>> this.nonmasklen();
        if (this.buckets()[pos] == null) {
            this.buckets()[pos] = new UnrolledBuffer(ClassTag$.MODULE$.apply(DefaultEntry.class));
        }
        this.buckets()[pos].$plus$eq(new DefaultEntry<K, V>(elem._1(), elem._2()));
        return this;
    }

    @Override
    public ParHashMap<K, V> result() {
        if (this.size() >= ParHashMapCombiner$.MODULE$.numblocks() * this.sizeMapBucketSize()) {
            AddingHashTable table = new AddingHashTable(this.size(), this.tableLoadFactor(), this.seedvalue());
            UnrolledBuffer.Unrolled[] bucks = (UnrolledBuffer.Unrolled[])TraversableLike.map$(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.buckets())), (Function1<UnrolledBuffer, UnrolledBuffer.Unrolled> & java.io.Serializable & Serializable)b -> {
                if (b != null) {
                    return b.headPtr();
                }
                return null;
            }, Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.apply(UnrolledBuffer.Unrolled.class)));
            int insertcount = BoxesRunTime.unboxToInt(this.combinerTaskSupport().executeAndWaitResult(new FillBlocks(this, bucks, table, 0, bucks.length)));
            table.setSize(insertcount);
            HashTable.Contents c = table.hashTableContents();
            return new ParHashMap(c);
        }
        LazyRef table$module = new LazyRef();
        for (int i = 0; i < ParHashMapCombiner$.MODULE$.numblocks(); ++i) {
            if (this.buckets()[i] == null) continue;
            this.buckets()[i].foreach((Function1<DefaultEntry, Object> & java.io.Serializable & Serializable)elem -> {
                ParHashMapCombiner.$anonfun$result$2(this, table$module, elem);
                return BoxedUnit.UNIT;
            });
        }
        return new ParHashMap(this.table$2(table$module).hashTableContents());
    }

    private static final /* synthetic */ ParHashMapCombiner$table$1$ table$lzycompute$1(LazyRef table$module$1) {
        synchronized (table$module$1) {
            ParHashMapCombiner$table$1$ parHashMapCombiner$table$1$ = table$module$1.initialized() ? (ParHashMapCombiner$table$1$)table$module$1.value() : table$module$1.initialize(new ParHashMapCombiner$table$1$(null));
            return parHashMapCombiner$table$1$;
        }
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private final ParHashMapCombiner$table$1$ table$2(LazyRef table$module$1) {
        if (table$module$1.initialized()) {
            return (ParHashMapCombiner$table$1$)table$module$1.value();
        }
        return ParHashMapCombiner.table$lzycompute$1(table$module$1);
    }

    public static final /* synthetic */ void $anonfun$result$2(ParHashMapCombiner $this, LazyRef table$module$1, DefaultEntry elem) {
        $this.table$2(table$module$1).insertEntry(elem);
    }

    public ParHashMapCombiner(int tableLoadFactor) {
        this.tableLoadFactor = tableLoadFactor;
        super(ParHashMapCombiner$.MODULE$.numblocks());
        HashTable.HashUtils.$init$(this);
        this.nonmasklen = ParHashMapCombiner$.MODULE$.nonmasklength();
        this.seedvalue = 27;
    }

    public class AddingHashTable
    implements HashTable<K, DefaultEntry<K, V>> {
        private transient int _loadFactor;
        private transient HashEntry<K, DefaultEntry<K, V>>[] table;
        private transient int tableSize;
        private transient int threshold;
        private transient int[] sizemap;
        private transient int seedvalue;

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
        public boolean alwaysInitSizeMap() {
            return HashTable.alwaysInitSizeMap$(this);
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

        public void setSize(int sz) {
            this.tableSize_$eq(sz);
        }

        public boolean insertEntry(DefaultEntry<K, V> e) {
            DefaultEntry olde;
            int h = this.index(this.elemHashCode((K)e.key()));
            DefaultEntry ce = olde = (DefaultEntry)this.table()[h];
            while (ce != null) {
                if (BoxesRunTime.equals(ce.key(), e.key())) {
                    h = -1;
                    ce = null;
                    continue;
                }
                ce = (DefaultEntry)ce.next();
            }
            if (h != -1) {
                e.next_$eq((Object)olde);
                this.table()[h] = e;
                this.nnSizeMapAdd(h);
                return true;
            }
            return false;
        }

        @Override
        public <X> Nothing$ createNewEntry(K key, X x) {
            return Predef$.MODULE$.$qmark$qmark$qmark();
        }

        public /* synthetic */ ParHashMapCombiner scala$collection$parallel$mutable$ParHashMapCombiner$AddingHashTable$$$outer() {
            return ParHashMapCombiner.this;
        }

        public AddingHashTable(int numelems, int lf, int _seedvalue) {
            if (ParHashMapCombiner.this == null) {
                throw null;
            }
            HashTable.HashUtils.$init$(this);
            HashTable.$init$(this);
            this._loadFactor_$eq(lf);
            this.table_$eq(new HashEntry[HashTable$.MODULE$.capacity(HashTable$.MODULE$.sizeForThreshold(this._loadFactor(), numelems))]);
            this.tableSize_$eq(0);
            this.seedvalue_$eq(_seedvalue);
            this.threshold_$eq(HashTable$.MODULE$.newThreshold(this._loadFactor(), this.table().length));
            this.sizeMapInit(this.table().length);
        }
    }

    public class FillBlocks
    implements Task<Object, FillBlocks> {
        private final UnrolledBuffer.Unrolled<DefaultEntry<K, V>>[] buckets;
        private final AddingHashTable table;
        private final int offset;
        private final int howmany;
        private int result;
        private volatile Throwable throwable;
        public final /* synthetic */ ParHashMapCombiner $outer;

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
            int until = this.offset + this.howmany;
            this.result_$eq(0);
            for (int i = this.offset; i < until; ++i) {
                this.result_$eq(this.result() + this.fillBlock(i, this.buckets[i]));
            }
        }

        /*
         * WARNING - void declaration
         */
        private int fillBlock(int block, UnrolledBuffer.Unrolled<DefaultEntry<K, V>> elems) {
            void var3_3;
            int insertcount = 0;
            int i = 0;
            AddingHashTable t = this.table;
            for (UnrolledBuffer.Unrolled unrolled = elems; unrolled != null; unrolled = unrolled.next()) {
                DefaultEntry[] chunkarr = (DefaultEntry[])unrolled.array();
                int chunksz = unrolled.size();
                while (i < chunksz) {
                    DefaultEntry elem = chunkarr[i];
                    if (t.insertEntry(elem)) {
                        ++insertcount;
                    }
                    ++i;
                }
                i = 0;
            }
            return (int)var3_3;
        }

        public List<FillBlocks> split() {
            int fp = this.howmany / 2;
            return new $colon$colon<Nothing$>((Nothing$)((Object)new FillBlocks(this.scala$collection$parallel$mutable$ParHashMapCombiner$FillBlocks$$$outer(), this.buckets, this.table, this.offset, fp)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)new FillBlocks(this.scala$collection$parallel$mutable$ParHashMapCombiner$FillBlocks$$$outer(), this.buckets, this.table, this.offset + fp, this.howmany - fp)), Nil$.MODULE$));
        }

        @Override
        public void merge(FillBlocks that) {
            this.result_$eq(this.result() + that.result());
        }

        @Override
        public boolean shouldSplitFurther() {
            return this.howmany > package$.MODULE$.thresholdFromSize(ParHashMapCombiner$.MODULE$.numblocks(), this.scala$collection$parallel$mutable$ParHashMapCombiner$FillBlocks$$$outer().combinerTaskSupport().parallelismLevel());
        }

        public /* synthetic */ ParHashMapCombiner scala$collection$parallel$mutable$ParHashMapCombiner$FillBlocks$$$outer() {
            return this.$outer;
        }

        public FillBlocks(ParHashMapCombiner $outer, UnrolledBuffer.Unrolled<DefaultEntry<K, V>>[] buckets, AddingHashTable table, int offset, int howmany) {
            this.buckets = buckets;
            this.table = table;
            this.offset = offset;
            this.howmany = howmany;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Task.$init$(this);
            this.result = Integer.MIN_VALUE;
        }
    }
}

