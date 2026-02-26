/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import scala.Function0;
import scala.Function1;
import scala.Serializable;
import scala.collection.AbstractIterator;
import scala.collection.Iterator;
import scala.collection.Iterator$;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.mutable.AbstractSet;
import scala.collection.mutable.HashEntry;
import scala.collection.mutable.HashTable;
import scala.collection.mutable.LinkedHashSet$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;

@ScalaSignature(bytes="\u0006\u0001\t\u001dc\u0001\u0002\u0015*\u0001ABaA\u0018\u0001\u0005\u0002\u0005\u0005\u0004bBA2\u0001\u0011\u0005\u0013QM\u0003\u0006\u0003'\u0001\u0001a\u0015\u0005\n\u0003S\u0002\u0001\u0019!C\t\u0003WB\u0011\"!\u001d\u0001\u0001\u0004%\t\"a\u001d\t\u0011\u0005]\u0004\u0001)Q\u0005\u0003[B\u0011\"!!\u0001\u0001\u0004%\t\"a\u001b\t\u0013\u0005\r\u0005\u00011A\u0005\u0012\u0005\u0015\u0005\u0002CAE\u0001\u0001\u0006K!!\u001c\t\u000f\u00055\u0005\u0001\"\u0011\u0002\u0010\"9\u0011q\u0013\u0001\u0005\u0002\u0005e\u0005bBAS\u0001\u0011\u0005\u0011q\u0015\u0005\b\u0003w\u0003A\u0011AA_\u0011\u001d\t9\r\u0001C!\u0003\u0013Dq!!4\u0001\t\u0003\ny\rC\u0004\u0002T\u0002!\t!!6\t\u000f\u0005}\u0007\u0001\"\u0011\u0002b\"9\u0011Q\u001f\u0001\u0005R\u0005]\bb\u0002B\u0002\u0001\u0011E!Q\u0001\u0005\b\u0005+\u0001A\u0011\tB\f\u0011\u001d\u0011I\u0002\u0001C\u0005\u00057AqA!\f\u0001\t\u0013\u0011ycB\u0003VS!\u0005aKB\u0003)S!\u0005q\u000bC\u0003_1\u0011\u0005q\fC\u0003a1\u0011\r\u0011\r\u0003\u0004p1\u0001\u0006I\u0001\u001d\u0005\b\u0003\u000fAB\u0011IA\u0005\r\u001d\t\u0019\u0002\u0007\u0002.\u0003+A!\"!\n\u001e\u0005\u000b\u0007I\u0011AA\u0014\u0011)\tI#\bB\u0001B\u0003%\u0011q\u0004\u0005\u0007=v!\t!a\u000b\t\u0013\u0005=R\u00041A\u0005\u0002\u0005E\u0002\"CA\u001a;\u0001\u0007I\u0011AA\u001b\u0011!\t\t%\bQ!\n\u0005\r\u0002\"CA\";\u0001\u0007I\u0011AA\u0019\u0011%\t)%\ba\u0001\n\u0003\t9\u0005\u0003\u0005\u0002Lu\u0001\u000b\u0015BA\u0012\u0011%\ti\u0005GA\u0001\n\u0013\tyEA\u0007MS:\\W\r\u001a%bg\"\u001cV\r\u001e\u0006\u0003U-\nq!\\;uC\ndWM\u0003\u0002-[\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u00039\nQa]2bY\u0006\u001c\u0001!\u0006\u00022qM9\u0001A\r\"F\u0019B[\u0006cA\u001a5m5\t\u0011&\u0003\u00026S\tY\u0011IY:ue\u0006\u001cGoU3u!\t9\u0004\b\u0004\u0001\u0005\u000be\u0002!\u0019\u0001\u001e\u0003\u0003\u0005\u000b\"aO \u0011\u0005qjT\"A\u0017\n\u0005yj#a\u0002(pi\"Lgn\u001a\t\u0003y\u0001K!!Q\u0017\u0003\u0007\u0005s\u0017\u0010E\u00024\u0007ZJ!\u0001R\u0015\u0003\u0007M+G\u000f\u0005\u0003G\u0013ZZU\"A$\u000b\u0005![\u0013aB4f]\u0016\u0014\u0018nY\u0005\u0003\u0015\u001e\u0013!cR3oKJL7mU3u)\u0016l\u0007\u000f\\1uKB\u00111\u0007\u0001\t\u0005g53t*\u0003\u0002OS\t91+\u001a;MS.,\u0007cA\u001a\u0001mA!1'\u0015\u001cT\u0013\t\u0011\u0016FA\u0005ICNDG+\u00192mKB\u0019A+\b\u001c\u000f\u0005M:\u0012!\u0004'j].,G\rS1tQN+G\u000f\u0005\u000241M\u0019\u0001\u0004W.\u0011\u0007\u0019K6*\u0003\u0002[\u000f\n\tR*\u001e;bE2,7+\u001a;GC\u000e$xN]=\u0011\u0005qb\u0016BA/.\u00051\u0019VM]5bY&T\u0018M\u00197f\u0003\u0019a\u0014N\\5u}Q\ta+\u0001\u0007dC:\u0014U/\u001b7e\rJ|W.\u0006\u0002c[V\t1\rE\u0003GI\u001adg.\u0003\u0002f\u000f\na1)\u00198Ck&dGM\u0012:p[B\u0011q\r[\u0007\u00021%\u0011\u0011N\u001b\u0002\u0005\u0007>dG.\u0003\u0002l\u000f\n\u0001r)\u001a8fe&\u001c7i\\7qC:LwN\u001c\t\u0003o5$Q!\u000f\u000eC\u0002i\u00022a\r\u0001m\u0003-\u0011V-^:bE2,7I\u0011$\u0013\u0007E<(P\u0002\u0003s\u0001\u0001\u0001(\u0001\u0004\u001fsK\u001aLg.Z7f]Rt\u0014B\u0001;v\u0003=\u0019X\r^\"b]\n+\u0018\u000e\u001c3Ge>l\u0017B\u0001<H\u000559UM\\*fi\u001a\u000b7\r^8ssB\u0011A\b_\u0005\u0003s6\u0012a!\u00118z%\u00164\u0007C\u0002$ew~\n)\u0001\r\u0002}}B\u00191\u0007A?\u0011\u0005]rH!C@\u0001\u0003\u0003\u0005\tQ!\u0001;\u0005\ryF%M\u0005\u0004\u0003\u0007\u0019(!\u0002\u0013b]>t\u0007cA\u001a\u0001\u007f\u0005)Q-\u001c9usV!\u00111BA\t+\t\ti\u0001\u0005\u00034\u0001\u0005=\u0001cA\u001c\u0002\u0012\u0011)\u0011\b\bb\u0001u\t)QI\u001c;ssV!\u0011qCA\u0011'\u0015ir/!\u0007\\!\u001d\u0019\u00141DA\u0010\u0003GI1!!\b*\u0005%A\u0015m\u001d5F]R\u0014\u0018\u0010E\u00028\u0003C!Q!O\u000fC\u0002i\u0002BaZ\u000f\u0002 \u0005\u00191.Z=\u0016\u0005\u0005}\u0011\u0001B6fs\u0002\"B!a\t\u0002.!9\u0011Q\u0005\u0011A\u0002\u0005}\u0011aB3be2LWM]\u000b\u0003\u0003G\t1\"Z1sY&,'o\u0018\u0013fcR!\u0011qGA\u001f!\ra\u0014\u0011H\u0005\u0004\u0003wi#\u0001B+oSRD\u0011\"a\u0010#\u0003\u0003\u0005\r!a\t\u0002\u0007a$\u0013'\u0001\u0005fCJd\u0017.\u001a:!\u0003\u0015a\u0017\r^3s\u0003%a\u0017\r^3s?\u0012*\u0017\u000f\u0006\u0003\u00028\u0005%\u0003\"CA K\u0005\u0005\t\u0019AA\u0012\u0003\u0019a\u0017\r^3sA\u0005Y!/Z1e%\u0016\u001cx\u000e\u001c<f)\t\t\t\u0006\u0005\u0003\u0002T\u0005uSBAA+\u0015\u0011\t9&!\u0017\u0002\t1\fgn\u001a\u0006\u0003\u00037\nAA[1wC&!\u0011qLA+\u0005\u0019y%M[3diR\tq*A\u0005d_6\u0004\u0018M\\5p]V\u0011\u0011q\r\t\u0004\r*\\\u0015A\u00034jeN$XI\u001c;ssV\u0011\u0011Q\u000e\t\u0004\u0003_\u001aQ\"\u0001\u0001\u0002\u001d\u0019L'o\u001d;F]R\u0014\u0018p\u0018\u0013fcR!\u0011qGA;\u0011%\ty$BA\u0001\u0002\u0004\ti'A\u0006gSJ\u001cH/\u00128uef\u0004\u0003f\u0001\u0004\u0002|A\u0019A(! \n\u0007\u0005}TFA\u0005ue\u0006t7/[3oi\u0006IA.Y:u\u000b:$(/_\u0001\u000eY\u0006\u001cH/\u00128uef|F%Z9\u0015\t\u0005]\u0012q\u0011\u0005\n\u0003\u007fA\u0011\u0011!a\u0001\u0003[\n!\u0002\\1ti\u0016sGO]=!Q\rI\u00111P\u0001\u0005g&TX-\u0006\u0002\u0002\u0012B\u0019A(a%\n\u0007\u0005UUFA\u0002J]R\f\u0001bY8oi\u0006Lgn\u001d\u000b\u0005\u00037\u000b\t\u000bE\u0002=\u0003;K1!a(.\u0005\u001d\u0011un\u001c7fC:Da!a)\f\u0001\u00041\u0014\u0001B3mK6\f\u0001\u0002\n9mkN$S-\u001d\u000b\u0005\u0003_\nI\u000b\u0003\u0004\u0002$2\u0001\rA\u000e\u0015\b\u0019\u00055\u00161WA\\!\ra\u0014qV\u0005\u0004\u0003ck#\u0001\u00063faJ,7-\u0019;fI>3XM\u001d:jI&tw-\t\u0002\u00026\u0006a4&\u0010\u0011tQ>,H\u000e\u001a\u0011o_R\u0004#-\u001a\u0011pm\u0016\u0014(/\u001b3eK:\u00043o\u001c\u0011ji\u0002\u001aH/Y=tA\r|gn]5ti\u0016tG\u000fI<ji\"\u0004\u0013\r\u001a3/C\t\tI,\u0001\u00043]E\nd\u0006M\u0001\nI5Lg.^:%KF$B!a\u001c\u0002@\"1\u00111U\u0007A\u0002YBs!DAW\u0003\u0007\f9,\t\u0002\u0002F\u0006yT&\u0010\u0011tQ>,H\u000e\u001a\u0011o_R\u0004#-\u001a\u0011pm\u0016\u0014(/\u001b3eK:\u00043o\u001c\u0011ji\u0002\u001aH/Y=tA\r|gn]5ti\u0016tG\u000fI<ji\"\u0004#/Z7pm\u0016t\u0013aA1eIR!\u00111TAf\u0011\u0019\t\u0019K\u0004a\u0001m\u00051!/Z7pm\u0016$B!a'\u0002R\"1\u00111U\bA\u0002Y\n\u0001\"\u001b;fe\u0006$xN]\u000b\u0003\u0003/\u0004R!!7\u0002\\Zj\u0011aK\u0005\u0004\u0003;\\#\u0001C%uKJ\fGo\u001c:\u0002\u000f\u0019|'/Z1dQV!\u00111]Ay)\u0011\t9$!:\t\u000f\u0005\u001d\u0018\u00031\u0001\u0002j\u0006\ta\r\u0005\u0004=\u0003W4\u0014q^\u0005\u0004\u0003[l#!\u0003$v]\u000e$\u0018n\u001c82!\r9\u0014\u0011\u001f\u0003\u0007\u0003g\f\"\u0019\u0001\u001e\u0003\u0003U\u000bABZ8sK\u0006\u001c\u0007.\u00128uef,B!!?\u0003\u0002Q!\u0011qGA~\u0011\u001d\t9O\u0005a\u0001\u0003{\u0004r\u0001PAv\u0003[\ny\u0010E\u00028\u0005\u0003!a!a=\u0013\u0005\u0004Q\u0014AD2sK\u0006$XMT3x\u000b:$(/_\u000b\u0005\u0005\u000f\u0011\t\u0002\u0006\u0004\u0002n\t%!1\u0002\u0005\u0007\u0003K\u0019\u0002\u0019\u0001\u001c\t\u000f\t51\u00031\u0001\u0003\u0010\u0005)A-^7nsB\u0019qG!\u0005\u0005\r\tM1C1\u0001;\u0005\u0005\u0011\u0015!B2mK\u0006\u0014HCAA\u001c\u0003-9(/\u001b;f\u001f\nTWm\u0019;\u0015\t\u0005]\"Q\u0004\u0005\b\u0005?)\u0002\u0019\u0001B\u0011\u0003\ryW\u000f\u001e\t\u0005\u0005G\u0011I#\u0004\u0002\u0003&)!!qEA-\u0003\tIw.\u0003\u0003\u0003,\t\u0015\"AE(cU\u0016\u001cGoT;uaV$8\u000b\u001e:fC6\f!B]3bI>\u0013'.Z2u)\u0011\t9D!\r\t\u000f\tMb\u00031\u0001\u00036\u0005\u0011\u0011N\u001c\t\u0005\u0005G\u00119$\u0003\u0003\u0003:\t\u0015\"!E(cU\u0016\u001cG/\u00138qkR\u001cFO]3b[\":\u0001A!\u0010\u0003D\t\u0015\u0003c\u0001\u001f\u0003@%\u0019!\u0011I\u0017\u0003!M+'/[1m-\u0016\u00148/[8o+&#\u0015!\u0002<bYV,g$A\u0001")
public class LinkedHashSet<A>
extends AbstractSet<A>
implements HashTable<A, Entry<A>>,
Serializable {
    public static final long serialVersionUID = 1L;
    private transient Entry<A> firstEntry;
    private transient Entry<A> lastEntry;
    private transient int _loadFactor;
    private transient HashEntry<A, Entry<A>>[] table;
    private transient int tableSize;
    private transient int threshold;
    private transient int[] sizemap;
    private transient int seedvalue;

    public static <A> CanBuildFrom<LinkedHashSet<?>, A, LinkedHashSet<A>> canBuildFrom() {
        return LinkedHashSet$.MODULE$.canBuildFrom();
    }

    public static <A> CanBuildFrom<LinkedHashSet<?>, A, LinkedHashSet<A>> setCanBuildFrom() {
        return LinkedHashSet$.MODULE$.setCanBuildFrom();
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
    public void init(ObjectInputStream in, Function0<Entry<A>> readEntry2) {
        HashTable.init$(this, in, readEntry2);
    }

    @Override
    public void serializeTo(ObjectOutputStream out, Function1<Entry<A>, BoxedUnit> writeEntry) {
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
    public Iterator<Entry<A>> entriesIterator() {
        return HashTable.entriesIterator$(this);
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
    public void initWithContents(HashTable.Contents<A, Entry<A>> c) {
        HashTable.initWithContents$(this, c);
    }

    @Override
    public HashTable.Contents<A, Entry<A>> hashTableContents() {
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
    public HashEntry<A, Entry<A>>[] table() {
        return this.table;
    }

    @Override
    public void table_$eq(HashEntry<A, Entry<A>>[] x$1) {
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
    public GenericCompanion<LinkedHashSet> companion() {
        return LinkedHashSet$.MODULE$;
    }

    public Entry<A> firstEntry() {
        return this.firstEntry;
    }

    public void firstEntry_$eq(Entry<A> x$1) {
        this.firstEntry = x$1;
    }

    public Entry<A> lastEntry() {
        return this.lastEntry;
    }

    public void lastEntry_$eq(Entry<A> x$1) {
        this.lastEntry = x$1;
    }

    @Override
    public int size() {
        return this.tableSize();
    }

    @Override
    public boolean contains(A elem) {
        return this.findEntry((Object)elem) != null;
    }

    @Override
    public LinkedHashSet<A> $plus$eq(A elem) {
        this.add(elem);
        return this;
    }

    @Override
    public LinkedHashSet<A> $minus$eq(A elem) {
        this.remove(elem);
        return this;
    }

    @Override
    public boolean add(A elem) {
        return this.findOrAddEntry((Object)elem, (Object)null) == null;
    }

    @Override
    public boolean remove(A elem) {
        Entry e = (Entry)this.removeEntry((Object)elem);
        if (e == null) {
            return false;
        }
        if (e.earlier() == null) {
            this.firstEntry_$eq(e.later());
        } else {
            e.earlier().later_$eq(e.later());
        }
        if (e.later() == null) {
            this.lastEntry_$eq(e.earlier());
        } else {
            e.later().earlier_$eq(e.earlier());
        }
        e.earlier_$eq(null);
        e.later_$eq(null);
        return true;
    }

    @Override
    public Iterator<A> iterator() {
        return new AbstractIterator<A>(this){
            private Entry<A> cur;

            private Entry<A> cur() {
                return this.cur;
            }

            private void cur_$eq(Entry<A> x$1) {
                this.cur = x$1;
            }

            public boolean hasNext() {
                return this.cur() != null;
            }

            /*
             * WARNING - void declaration
             */
            public A next() {
                if (this.hasNext()) {
                    void var1_1;
                    A res = this.cur().key();
                    this.cur_$eq(this.cur().later());
                    return var1_1;
                }
                return (A)Iterator$.MODULE$.empty().next();
            }
            {
                this.cur = $outer.firstEntry();
            }
        };
    }

    @Override
    public <U> void foreach(Function1<A, U> f) {
        for (Entry<A> cur = this.firstEntry(); cur != null; cur = cur.later()) {
            f.apply(cur.key());
        }
    }

    @Override
    public <U> void foreachEntry(Function1<Entry<A>, U> f) {
        for (Entry<A> cur = this.firstEntry(); cur != null; cur = cur.later()) {
            f.apply(cur);
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public <B> Entry<A> createNewEntry(A key, B dummy) {
        void var3_3;
        Entry<A> e = new Entry<A>(key);
        if (this.firstEntry() == null) {
            this.firstEntry_$eq(e);
        } else {
            this.lastEntry().later_$eq(e);
            e.earlier_$eq(this.lastEntry());
        }
        this.lastEntry_$eq(e);
        return var3_3;
    }

    @Override
    public void clear() {
        this.clearTable();
        this.firstEntry_$eq(null);
        this.lastEntry_$eq(null);
    }

    private void writeObject(ObjectOutputStream out) {
        this.serializeTo(out, (Function1<Entry<A>, BoxedUnit>)(Function1<Entry, Object> & java.io.Serializable & Serializable)e -> {
            out.writeObject(e.key());
            return BoxedUnit.UNIT;
        });
    }

    private void readObject(ObjectInputStream in) {
        this.firstEntry_$eq(null);
        this.lastEntry_$eq(null);
        this.init(in, (Function0<Entry<A>>)(Function0<Entry> & java.io.Serializable & Serializable)() -> this.createNewEntry(in.readObject(), (Object)null));
    }

    public LinkedHashSet() {
        HashTable.HashUtils.$init$(this);
        HashTable.$init$(this);
        this.firstEntry = null;
        this.lastEntry = null;
    }

    public static final class Entry<A>
    implements HashEntry<A, Entry<A>>,
    Serializable {
        private final A key;
        private Entry<A> earlier;
        private Entry<A> later;
        private Entry<A> next;

        @Override
        public Entry<A> next() {
            return this.next;
        }

        @Override
        public void next_$eq(Entry<A> x$1) {
            this.next = x$1;
        }

        @Override
        public A key() {
            return this.key;
        }

        public Entry<A> earlier() {
            return this.earlier;
        }

        public void earlier_$eq(Entry<A> x$1) {
            this.earlier = x$1;
        }

        public Entry<A> later() {
            return this.later;
        }

        public void later_$eq(Entry<A> x$1) {
            this.later = x$1;
        }

        public Entry(A key) {
            this.key = key;
            HashEntry.$init$(this);
            this.earlier = null;
            this.later = null;
        }
    }
}

