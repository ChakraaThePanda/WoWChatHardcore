/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import scala.Function1;
import scala.Option;
import scala.Serializable;
import scala.collection.CustomParallelizable;
import scala.collection.Iterator;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.mutable.AbstractSet;
import scala.collection.mutable.FlatHashTable;
import scala.collection.mutable.HashSet$;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.mutable.ParHashSet;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;

@ScalaSignature(bytes="\u0006\u0001\u0005Eg\u0001\u0002\u000e\u001c\u0001\tB\u0001b\u0015\u0001\u0003\u0002\u0003\u0006I\u0001\u0016\u0005\u00077\u0002!\t!\b/\t\u000bm\u0003A\u0011\u00010\t\u000b}\u0003A\u0011\t1\t\u000b\u0011\u0004A\u0011I3\t\u000b%\u0004A\u0011\u00016\t\u000bA\u0004A\u0011A9\t\u000bQ\u0004A\u0011A;\t\u000b]\u0004A\u0011\t=\t\u000be\u0004A\u0011\t>\t\u000bq\u0004A\u0011I?\t\r}\u0004A\u0011IA\u0001\u0011\u001d\tI\u0001\u0001C!\u0003\u0017Aq!a\u0005\u0001\t\u0003\n)\u0002\u0003\u0004\u0002*\u0001!\tE\u0018\u0005\b\u0003W\u0001A\u0011BA\u0017\u0011\u001d\t\u0019\u0005\u0001C\u0005\u0003\u000bBq!!\u0015\u0001\t\u0003\t\u0019fB\u0004\u0002fmA\t!a\u001a\u0007\riY\u0002\u0012AA5\u0011\u0019YF\u0003\"\u0001\u0002r!9\u00111\u000f\u000b\u0005\u0004\u0005U\u0004\u0002CAG)\u0001\u0006I!a$\t\u000f\u0005UF\u0003\"\u0011\u00028\"I\u0011\u0011\u0019\u000b\u0002\u0002\u0013%\u00111\u0019\u0002\b\u0011\u0006\u001c\bnU3u\u0015\taR$A\u0004nkR\f'\r\\3\u000b\u0005yy\u0012AC2pY2,7\r^5p]*\t\u0001%A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u0005\rR3\u0003\u0003\u0001%i]r$)\u0012)\u0011\u0007\u00152\u0003&D\u0001\u001c\u0013\t93DA\u0006BEN$(/Y2u'\u0016$\bCA\u0015+\u0019\u0001!Qa\u000b\u0001C\u00021\u0012\u0011!Q\t\u0003[E\u0002\"AL\u0018\u000e\u0003}I!\u0001M\u0010\u0003\u000f9{G\u000f[5oOB\u0011aFM\u0005\u0003g}\u00111!\u00118z!\r)S\u0007K\u0005\u0003mm\u00111aU3u!\u0011A4\bK\u001f\u000e\u0003eR!AO\u000f\u0002\u000f\u001d,g.\u001a:jG&\u0011A(\u000f\u0002\u0013\u000f\u0016tWM]5d'\u0016$H+Z7qY\u0006$X\r\u0005\u0002&\u0001A!Qe\u0010\u0015B\u0013\t\u00015DA\u0004TKRd\u0015n[3\u0011\u0007\u0015\u0002\u0001\u0006E\u0002&\u0007\"J!\u0001R\u000e\u0003\u001b\u0019c\u0017\r\u001e%bg\"$\u0016M\u00197f!\u00111u\tK%\u000e\u0003uI!\u0001S\u000f\u0003)\r+8\u000f^8n!\u0006\u0014\u0018\r\u001c7fY&T\u0018M\u00197f!\rQe\nK\u0007\u0002\u0017*\u0011A\u0004\u0014\u0006\u0003\u001bv\t\u0001\u0002]1sC2dW\r\\\u0005\u0003\u001f.\u0013!\u0002U1s\u0011\u0006\u001c\bnU3u!\tq\u0013+\u0003\u0002S?\ta1+\u001a:jC2L'0\u00192mK\u0006A1m\u001c8uK:$8\u000fE\u0002V1\"r!!\n,\n\u0005][\u0012!\u0004$mCRD\u0015m\u001d5UC\ndW-\u0003\u0002Z5\nA1i\u001c8uK:$8O\u0003\u0002X7\u00051A(\u001b8jiz\"\"!Q/\t\u000bM\u0013\u0001\u0019\u0001+\u0015\u0003\u0005\u000b\u0011bY8na\u0006t\u0017n\u001c8\u0016\u0003\u0005\u00042\u0001\u000f2>\u0013\t\u0019\u0017H\u0001\tHK:,'/[2D_6\u0004\u0018M\\5p]\u0006!1/\u001b>f+\u00051\u0007C\u0001\u0018h\u0013\tAwDA\u0002J]R\f\u0001bY8oi\u0006Lgn\u001d\u000b\u0003W:\u0004\"A\f7\n\u00055|\"a\u0002\"p_2,\u0017M\u001c\u0005\u0006_\u001a\u0001\r\u0001K\u0001\u0005K2,W.\u0001\u0005%a2,8\u000fJ3r)\t\u00118/D\u0001\u0001\u0011\u0015yw\u00011\u0001)\u0003%!S.\u001b8vg\u0012*\u0017\u000f\u0006\u0002sm\")q\u000e\u0003a\u0001Q\u0005\u0019\u0001/\u0019:\u0016\u0003%\u000b1!\u00193e)\tY7\u0010C\u0003p\u0015\u0001\u0007\u0001&\u0001\u0004sK6|g/\u001a\u000b\u0003WzDQa\\\u0006A\u0002!\nQa\u00197fCJ$\"!a\u0001\u0011\u00079\n)!C\u0002\u0002\b}\u0011A!\u00168ji\u0006A\u0011\u000e^3sCR|'/\u0006\u0002\u0002\u000eA!a)a\u0004)\u0013\r\t\t\"\b\u0002\t\u0013R,'/\u0019;pe\u00069am\u001c:fC\u000eDW\u0003BA\f\u0003K!B!a\u0001\u0002\u001a!9\u00111\u0004\bA\u0002\u0005u\u0011!\u00014\u0011\r9\ny\u0002KA\u0012\u0013\r\t\tc\b\u0002\n\rVt7\r^5p]F\u00022!KA\u0013\t\u0019\t9C\u0004b\u0001Y\t\tQ+A\u0003dY>tW-A\u0006xe&$Xm\u00142kK\u000e$H\u0003BA\u0002\u0003_Aq!!\r\u0011\u0001\u0004\t\u0019$A\u0001t!\u0011\t)$a\u0010\u000e\u0005\u0005]\"\u0002BA\u001d\u0003w\t!![8\u000b\u0005\u0005u\u0012\u0001\u00026bm\u0006LA!!\u0011\u00028\t\u0011rJ\u00196fGR|U\u000f\u001e9viN#(/Z1n\u0003)\u0011X-\u00193PE*,7\r\u001e\u000b\u0005\u0003\u0007\t9\u0005C\u0004\u0002JE\u0001\r!a\u0013\u0002\u0005%t\u0007\u0003BA\u001b\u0003\u001bJA!a\u0014\u00028\t\trJ\u00196fGRLe\u000e];u'R\u0014X-Y7\u0002\u0015U\u001cXmU5{K6\u000b\u0007\u000f\u0006\u0003\u0002\u0004\u0005U\u0003BBA,%\u0001\u00071.A\u0001uQ\u001d\u0001\u00111LA1\u0003G\u00022ALA/\u0013\r\tyf\b\u0002\u0011'\u0016\u0014\u0018.\u00197WKJ\u001c\u0018n\u001c8V\u0013\u0012\u000bQA^1mk\u0016t\u0012!A\u0001\b\u0011\u0006\u001c\bnU3u!\t)Cc\u0005\u0003\u0015\u0003W\u0002\u0006\u0003\u0002\u001d\u0002nuJ1!a\u001c:\u0005EiU\u000f^1cY\u0016\u001cV\r\u001e$bGR|'/\u001f\u000b\u0003\u0003O\nAbY1o\u0005VLG\u000e\u001a$s_6,B!a\u001e\u0002\nV\u0011\u0011\u0011\u0010\t\nq\u0005m\u0014qPAD\u0003\u0017K1!! :\u00051\u0019\u0015M\u001c\"vS2$gI]8n!\u0011\t\t)a!\u000e\u0003QI1!!\"c\u0005\u0011\u0019u\u000e\u001c7\u0011\u0007%\nI\tB\u0003,-\t\u0007A\u0006\u0005\u0003&\u0001\u0005\u001d\u0015a\u0003*fkN\f'\r\\3D\u0005\u001a\u0013b!!%\u0002\u001e\u0006\rfABAJ\u0001\u0001\tyI\u0001\u0007=e\u00164\u0017N\\3nK:$h(\u0003\u0003\u0002\u0018\u0006e\u0015aD:fi\u000e\u000bgNQ;jY\u00124%o\\7\n\u0007\u0005m\u0015HA\u0007HK:\u001cV\r\u001e$bGR|'/\u001f\t\u0004]\u0005}\u0015bAAQ?\t1\u0011I\\=SK\u001a\u0004\u0002\u0002OA>\u0003K\u000b\u00141\u0017\u0019\u0005\u0003O\u000bY\u000b\u0005\u0003&\u0001\u0005%\u0006cA\u0015\u0002,\u0012Q\u0011Q\u0016\u0001\u0002\u0002\u0003\u0005)\u0011\u0001\u0017\u0003\u0007}#\u0013'\u0003\u0003\u00022\u0006U%!\u0002\u0013b]>t\u0007cA\u0013\u0001c\u0005)Q-\u001c9usV!\u0011\u0011XA`+\t\tY\f\u0005\u0003&\u0001\u0005u\u0006cA\u0015\u0002@\u0012)1\u0006\u0007b\u0001Y\u0005Y!/Z1e%\u0016\u001cx\u000e\u001c<f)\t\t)\r\u0005\u0003\u0002H\u00065WBAAe\u0015\u0011\tY-a\u000f\u0002\t1\fgnZ\u0005\u0005\u0003\u001f\fIM\u0001\u0004PE*,7\r\u001e")
public class HashSet<A>
extends AbstractSet<A>
implements FlatHashTable<A>,
CustomParallelizable<A, ParHashSet<A>>,
Serializable {
    public static final long serialVersionUID = 1L;
    private transient int _loadFactor;
    private transient Object[] table;
    private transient int tableSize;
    private transient int threshold;
    private transient int[] sizemap;
    private transient int seedvalue;

    public static <A> CanBuildFrom<HashSet<?>, A, HashSet<A>> canBuildFrom() {
        return HashSet$.MODULE$.canBuildFrom();
    }

    public static <A> CanBuildFrom<HashSet<?>, A, HashSet<A>> setCanBuildFrom() {
        return HashSet$.MODULE$.setCanBuildFrom();
    }

    @Override
    public Combiner<A, ParHashSet<A>> parCombiner() {
        return CustomParallelizable.parCombiner$(this);
    }

    @Override
    public int capacity(int expectedSize) {
        return FlatHashTable.capacity$(this, expectedSize);
    }

    @Override
    public int initialSize() {
        return FlatHashTable.initialSize$(this);
    }

    @Override
    public int randomSeed() {
        return FlatHashTable.randomSeed$(this);
    }

    @Override
    public int tableSizeSeed() {
        return FlatHashTable.tableSizeSeed$(this);
    }

    @Override
    public void init(ObjectInputStream in, Function1<A, BoxedUnit> f) {
        FlatHashTable.init$(this, in, f);
    }

    @Override
    public void serializeTo(ObjectOutputStream out) {
        FlatHashTable.serializeTo$(this, out);
    }

    @Override
    public Option<A> findEntry(A elem) {
        return FlatHashTable.findEntry$(this, elem);
    }

    @Override
    public boolean containsElem(A elem) {
        return FlatHashTable.containsElem$(this, elem);
    }

    @Override
    public boolean addElem(A elem) {
        return FlatHashTable.addElem$(this, elem);
    }

    @Override
    public boolean addEntry(Object newEntry) {
        return FlatHashTable.addEntry$(this, newEntry);
    }

    @Override
    public boolean removeElem(A elem) {
        return FlatHashTable.removeElem$(this, elem);
    }

    @Override
    public void nnSizeMapAdd(int h) {
        FlatHashTable.nnSizeMapAdd$(this, h);
    }

    @Override
    public void nnSizeMapRemove(int h) {
        FlatHashTable.nnSizeMapRemove$(this, h);
    }

    @Override
    public void nnSizeMapReset(int tableLength) {
        FlatHashTable.nnSizeMapReset$(this, tableLength);
    }

    @Override
    public final int totalSizeMapBuckets() {
        return FlatHashTable.totalSizeMapBuckets$(this);
    }

    @Override
    public int calcSizeMapSize(int tableLength) {
        return FlatHashTable.calcSizeMapSize$(this, tableLength);
    }

    @Override
    public void sizeMapInit(int tableLength) {
        FlatHashTable.sizeMapInit$(this, tableLength);
    }

    @Override
    public void sizeMapInitAndRebuild() {
        FlatHashTable.sizeMapInitAndRebuild$(this);
    }

    @Override
    public void printSizeMap() {
        FlatHashTable.printSizeMap$(this);
    }

    @Override
    public void printContents() {
        FlatHashTable.printContents$(this);
    }

    @Override
    public void sizeMapDisable() {
        FlatHashTable.sizeMapDisable$(this);
    }

    @Override
    public boolean isSizeMapDefined() {
        return FlatHashTable.isSizeMapDefined$(this);
    }

    @Override
    public boolean alwaysInitSizeMap() {
        return FlatHashTable.alwaysInitSizeMap$(this);
    }

    @Override
    public final int index(int hcode) {
        return FlatHashTable.index$(this, hcode);
    }

    @Override
    public void clearTable() {
        FlatHashTable.clearTable$(this);
    }

    @Override
    public FlatHashTable.Contents<A> hashTableContents() {
        return FlatHashTable.hashTableContents$(this);
    }

    @Override
    public void initWithContents(FlatHashTable.Contents<A> c) {
        FlatHashTable.initWithContents$(this, c);
    }

    @Override
    public final int sizeMapBucketBitSize() {
        return FlatHashTable.HashUtils.sizeMapBucketBitSize$(this);
    }

    @Override
    public final int sizeMapBucketSize() {
        return FlatHashTable.HashUtils.sizeMapBucketSize$(this);
    }

    @Override
    public final int improve(int hcode, int seed) {
        return FlatHashTable.HashUtils.improve$(this, hcode, seed);
    }

    @Override
    public final Object elemToEntry(A elem) {
        return FlatHashTable.HashUtils.elemToEntry$(this, elem);
    }

    @Override
    public final A entryToElem(Object entry) {
        return (A)FlatHashTable.HashUtils.entryToElem$(this, entry);
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
    public Object[] table() {
        return this.table;
    }

    @Override
    public void table_$eq(Object[] x$1) {
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
    public GenericCompanion<HashSet> companion() {
        return HashSet$.MODULE$;
    }

    @Override
    public int size() {
        return this.tableSize();
    }

    @Override
    public boolean contains(A elem) {
        return this.containsElem(elem);
    }

    @Override
    public HashSet<A> $plus$eq(A elem) {
        this.addElem(elem);
        return this;
    }

    @Override
    public HashSet<A> $minus$eq(A elem) {
        this.removeElem(elem);
        return this;
    }

    @Override
    public ParHashSet<A> par() {
        return new ParHashSet<A>(this.hashTableContents());
    }

    @Override
    public boolean add(A elem) {
        return this.addElem(elem);
    }

    @Override
    public boolean remove(A elem) {
        return this.removeElem(elem);
    }

    @Override
    public void clear() {
        this.clearTable();
    }

    @Override
    public Iterator<A> iterator() {
        return FlatHashTable.iterator$(this);
    }

    @Override
    public <U> void foreach(Function1<A, U> f) {
        int len = this.table().length;
        for (int i = 0; i < len; ++i) {
            Object curEntry = this.table()[i];
            if (curEntry == null) continue;
            f.apply(this.entryToElem(curEntry));
        }
    }

    @Override
    public HashSet<A> clone() {
        return (HashSet)new HashSet<A>().$plus$plus$eq(this);
    }

    private void writeObject(ObjectOutputStream s) {
        this.serializeTo(s);
    }

    private void readObject(ObjectInputStream in) {
        this.init(in, (Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
            HashSet.$anonfun$readObject$1(x);
            return BoxedUnit.UNIT;
        });
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

    public static final /* synthetic */ void $anonfun$readObject$1(Object x) {
    }

    public HashSet(FlatHashTable.Contents<A> contents) {
        FlatHashTable.HashUtils.$init$(this);
        FlatHashTable.$init$(this);
        CustomParallelizable.$init$(this);
        this.initWithContents(contents);
    }

    public HashSet() {
        this(null);
    }
}

