/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import scala.Function0;
import scala.Function1;
import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.AbstractIterator;
import scala.collection.Iterator;
import scala.collection.Iterator$;
import scala.collection.Map;
import scala.collection.MapLike;
import scala.collection.Set;
import scala.collection.generic.CanBuildFrom;
import scala.collection.mutable.AbstractMap;
import scala.collection.mutable.HashEntry;
import scala.collection.mutable.HashTable;
import scala.collection.mutable.LinkedEntry;
import scala.collection.mutable.LinkedHashMap$;
import scala.collection.mutable.LinkedHashSet;
import scala.collection.mutable.LinkedHashSet$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\tUu!B\u00181\u0011\u00039d!B\u001d1\u0011\u0003Q\u0004B\u00024\u0002\t\u0003\u0011I\u0005C\u0004\u0003L\u0005!\u0019A!\u0014\t\u0011\t=\u0014\u0001)A\u0005\u0005cBa\u0001[\u0001\u0005\u0002\t]\u0004\"\u0003BC\u0003\u0005\u0005I\u0011\u0002BD\r\u0011I\u0004\u0007\u0001\"\t\u000b\u0019<A\u0011A4\t\u000b!<A\u0011I5\t\u000b)<A\u0011I6\u0006\t=<\u0001\u0001\u0019\u0005\ba\u001e\u0001\r\u0011\"\u0005r\u0011\u001d!x\u00011A\u0005\u0012UDaa_\u0004!B\u0013\u0011\b\u0002CA\u0001\u000f\u0001\u0007I\u0011C9\t\u0013\u0005\rq\u00011A\u0005\u0012\u0005\u0015\u0001bBA\u0005\u000f\u0001\u0006KA\u001d\u0005\b\u0003\u001b9A\u0011AA\b\u0011\u001d\tYb\u0002C!\u0003;Aq!a\n\b\t\u0003\nI\u0003C\u0004\u00022\u001d!\t%a\r\t\u000f\u0005]r\u0001\"\u0001\u0002:!9\u0011QK\u0004\u0005\u0002\u0005]\u0003bBA1\u000f\u0011\u0005\u00111\r\u0004\u0007\u0003[:\u0001\"a\u001c\t\u0015\u0005]\u0014D!A!\u0002\u0013\tI\b\u0003\u0004g3\u0011\u0005\u0011q\u0010\u0005\u0007Qf!\t%!\"\t\u000f\u0005%u\u0001\"\u0011\u0002\f\u001a1\u00111S\u0004\t\u0003+C!\"a)\u001f\u0005\u0003\u0005\u000b\u0011BAS\u0011\u00191g\u0004\"\u0001\u0002(\"1\u0001N\bC!\u0003\u000bCq!!,\b\t\u0003\nyK\u0002\u0004\u0002>\u001eA\u0011q\u0018\u0005\u0007M\u000e\"\t!!2\t\r!\u001cC\u0011IAe\u0011\u001d\t\tn\u0002C!\u0003'Dq!a7\b\t\u0003\ni\u000eC\u0004\u0002b\u001e!\t%a9\t\u000f\u0005\u001dx\u0001\"\u0011\u0002j\"9\u0011q_\u0004\u0005R\u0005e\bb\u0002B\u0003\u000f\u0011E!q\u0001\u0005\b\u0005+9A\u0011\tB\f\u0011\u001d\u0011Ib\u0002C\u0005\u00057AqA!\r\b\t\u0013\u0011\u0019$A\u0007MS:\\W\r\u001a%bg\"l\u0015\r\u001d\u0006\u0003cI\nq!\\;uC\ndWM\u0003\u00024i\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003U\nQa]2bY\u0006\u001c\u0001\u0001\u0005\u00029\u00035\t\u0001GA\u0007MS:\\W\r\u001a%bg\"l\u0015\r]\n\u0004\u0003m\u001a\u0007c\u0001\u001f@\u00036\tQH\u0003\u0002?e\u00059q-\u001a8fe&\u001c\u0017B\u0001!>\u0005EiU\u000f^1cY\u0016l\u0015\r\u001d$bGR|'/\u001f\t\u0003q\u001d)2aQ%U'\u00199AIV-^GB!\u0001(R$T\u0013\t1\u0005GA\u0006BEN$(/Y2u\u001b\u0006\u0004\bC\u0001%J\u0019\u0001!QAS\u0004C\u0002-\u0013\u0011!Q\t\u0003\u0019B\u0003\"!\u0014(\u000e\u0003QJ!a\u0014\u001b\u0003\u000f9{G\u000f[5oOB\u0011Q*U\u0005\u0003%R\u00121!\u00118z!\tAE\u000bB\u0003V\u000f\t\u00071JA\u0001C!\u0011AtkR*\n\u0005a\u0003$aA'baB)\u0001HW$T9&\u00111\f\r\u0002\b\u001b\u0006\u0004H*[6f!\u0011AtaR*\u0011\tarv\tY\u0005\u0003?B\u0012\u0011\u0002S1tQR\u000b'\r\\3\u0011\ta\nwiU\u0005\u0003EB\u00121\u0002T5oW\u0016$WI\u001c;ssB\u0011Q\nZ\u0005\u0003KR\u0012AbU3sS\u0006d\u0017N_1cY\u0016\fa\u0001P5oSRtD#\u0001/\u0002\u000b\u0015l\u0007\u000f^=\u0016\u0003q\u000bAa]5{KV\tA\u000e\u0005\u0002N[&\u0011a\u000e\u000e\u0002\u0004\u0013:$(!B#oiJL\u0018A\u00034jeN$XI\u001c;ssV\t!\u000f\u0005\u0002t\u00175\tq!\u0001\bgSJ\u001cH/\u00128uef|F%Z9\u0015\u0005YL\bCA'x\u0013\tAHG\u0001\u0003V]&$\bb\u0002>\u000e\u0003\u0003\u0005\rA]\u0001\u0004q\u0012\n\u0014a\u00034jeN$XI\u001c;ss\u0002B#AD?\u0011\u00055s\u0018BA@5\u0005%!(/\u00198tS\u0016tG/A\u0005mCN$XI\u001c;ss\u0006iA.Y:u\u000b:$(/_0%KF$2A^A\u0004\u0011\u001dQ\b#!AA\u0002I\f!\u0002\\1ti\u0016sGO]=!Q\t\tR0A\u0002hKR$B!!\u0005\u0002\u0018A!Q*a\u0005T\u0013\r\t)\u0002\u000e\u0002\u0007\u001fB$\u0018n\u001c8\t\r\u0005e!\u00031\u0001H\u0003\rYW-_\u0001\tG>tG/Y5ogR!\u0011qDA\u0013!\ri\u0015\u0011E\u0005\u0004\u0003G!$a\u0002\"p_2,\u0017M\u001c\u0005\u0007\u00033\u0019\u0002\u0019A$\u0002\u0007A,H\u000f\u0006\u0004\u0002\u0012\u0005-\u0012Q\u0006\u0005\u0007\u00033!\u0002\u0019A$\t\r\u0005=B\u00031\u0001T\u0003\u00151\u0018\r\\;f\u0003\u0019\u0011X-\\8wKR!\u0011\u0011CA\u001b\u0011\u0019\tI\"\u0006a\u0001\u000f\u0006AA\u0005\u001d7vg\u0012*\u0017\u000fF\u0002t\u0003wAq!!\u0010\u0017\u0001\u0004\ty$\u0001\u0002lmB)Q*!\u0011H'&\u0019\u00111\t\u001b\u0003\rQ+\b\u000f\\33Q\u001d1\u0012qIA'\u0003#\u00022!TA%\u0013\r\tY\u0005\u000e\u0002\u0015I\u0016\u0004(/Z2bi\u0016$wJ^3se&$\u0017N\\4\"\u0005\u0005=\u0013\u0001P\u0016>AMDw.\u001e7eA9|G\u000f\t2fA=4XM\u001d:jI\u0012,g\u000eI:pA%$\be\u001d;bsN\u00043m\u001c8tSN$XM\u001c;!o&$\b\u000e\t9vi:\n#!a\u0015\u0002\rIr\u0013'\r\u00181\u0003%!S.\u001b8vg\u0012*\u0017\u000fF\u0002t\u00033Ba!!\u0007\u0018\u0001\u00049\u0005fB\f\u0002H\u0005u\u0013\u0011K\u0011\u0003\u0003?\nq(L\u001f!g\"|W\u000f\u001c3!]>$\bEY3!_Z,'O]5eI\u0016t\u0007e]8!SR\u00043\u000f^1zg\u0002\u001awN\\:jgR,g\u000e\u001e\u0011xSRD\u0007E]3n_Z,g&\u0001\u0005ji\u0016\u0014\u0018\r^8s+\t\t)\u0007\u0005\u0004\u0002h\u0005%\u0014qH\u0007\u0002e%\u0019\u00111\u000e\u001a\u0003\u0011%#XM]1u_J\u0014ABR5mi\u0016\u0014X\rZ&fsN\u001c2!GA9!\r\u0019\u00181O\u0005\u0005\u0003[\n)(\u0003\u0002\\e\u0005\t\u0001\u000f\u0005\u0004N\u0003w:\u0015qD\u0005\u0004\u0003{\"$!\u0003$v]\u000e$\u0018n\u001c82)\u0011\t\t)a!\u0011\u0005ML\u0002bBA<7\u0001\u0007\u0011\u0011P\u000b\u0003\u0003\u000f\u0003B\u0001O\u0004H\u0019\u0006Qa-\u001b7uKJ\\U-_:\u0015\t\u00055\u0015\u0011\u0013\t\u0007\u0003O\nyiR*\n\u0005a\u0013\u0004bBA<;\u0001\u0007\u0011\u0011\u0010\u0002\r\u001b\u0006\u0004\b/\u001a3WC2,Xm]\u000b\u0005\u0003/\u000byjE\u0002\u001f\u00033\u0003Ra]AN\u0003;KA!a%\u0002vA\u0019\u0001*a(\u0005\r\u0005\u0005fD1\u0001L\u0005\u0005\u0019\u0015!\u00014\u0011\r5\u000bYhUAO)\u0011\tI+a+\u0011\tMt\u0012Q\u0014\u0005\b\u0003G\u0003\u0003\u0019AAS\u0003%i\u0017\r\u001d,bYV,7/\u0006\u0003\u00022\u0006]F\u0003BAZ\u0003s\u0003r!a\u001a\u0002\u0010\u001e\u000b)\fE\u0002I\u0003o#a!!)#\u0005\u0004Y\u0005bBARE\u0001\u0007\u00111\u0018\t\u0007\u001b\u0006m4+!.\u0003\u001b\u0011+g-Y;mi.+\u0017pU3u'\r\u0019\u0013\u0011\u0019\t\u0004g\u0006\r\u0017\u0002BA_\u0003k\"\"!a2\u0011\u0005M\u001cSCAAf!\u0011A\u0014QZ$\n\u0007\u0005=\u0007GA\u0007MS:\\W\r\u001a%bg\"\u001cV\r^\u0001\u0007W\u0016L8+\u001a;\u0016\u0005\u0005U\u0007#BA4\u0003/<\u0015bAAme\t\u00191+\u001a;\u0002\u0019-,\u0017p]%uKJ\fGo\u001c:\u0016\u0005\u0005}\u0007#BA4\u0003S:\u0015A\u0004<bYV,7/\u0013;fe\u0006$xN]\u000b\u0003\u0003K\u0004R!a\u001a\u0002jM\u000bqAZ8sK\u0006\u001c\u0007.\u0006\u0003\u0002l\u0006MHc\u0001<\u0002n\"9\u00111U\u0015A\u0002\u0005=\bcB'\u0002|\u0005}\u0012\u0011\u001f\t\u0004\u0011\u0006MHABA{S\t\u00071JA\u0001V\u000311wN]3bG\",e\u000e\u001e:z+\u0011\tYPa\u0001\u0015\u0007Y\fi\u0010C\u0004\u0002$*\u0002\r!a@\u0011\r5\u000bYH\u001dB\u0001!\rA%1\u0001\u0003\u0007\u0003kT#\u0019A&\u0002\u001d\r\u0014X-\u0019;f\u001d\u0016<XI\u001c;ssV!!\u0011\u0002B\t)\u0015\u0011(1\u0002B\u0007\u0011\u0019\tIb\u000ba\u0001\u000f\"9\u0011qF\u0016A\u0002\t=\u0001c\u0001%\u0003\u0012\u00111!1C\u0016C\u0002-\u0013!AQ\u0019\u0002\u000b\rdW-\u0019:\u0015\u0003Y\f1b\u001e:ji\u0016|%M[3diR\u0019aO!\b\t\u000f\t}Q\u00061\u0001\u0003\"\u0005\u0019q.\u001e;\u0011\t\t\r\"QF\u0007\u0003\u0005KQAAa\n\u0003*\u0005\u0011\u0011n\u001c\u0006\u0003\u0005W\tAA[1wC&!!q\u0006B\u0013\u0005Iy%M[3di>+H\u000f];u'R\u0014X-Y7\u0002\u0015I,\u0017\rZ(cU\u0016\u001cG\u000fF\u0002w\u0005kAqAa\u000e/\u0001\u0004\u0011I$\u0001\u0002j]B!!1\u0005B\u001e\u0013\u0011\u0011iD!\n\u0003#=\u0013'.Z2u\u0013:\u0004X\u000f^*ue\u0016\fW\u000eK\u0004\b\u0005\u0003\nyCa\u0012\u0011\u00075\u0013\u0019%C\u0002\u0003FQ\u0012\u0001cU3sS\u0006dg+\u001a:tS>tW+\u0013#\u001f\u0003\u0005!\u0012aN\u0001\rG\u0006t')^5mI\u001a\u0013x.\\\u000b\u0007\u0005\u001f\u00129Ga\u001b\u0016\u0005\tE\u0003#\u0003\u001f\u0003T\t]#1\rB7\u0013\r\u0011)&\u0010\u0002\r\u0007\u0006t')^5mI\u001a\u0013x.\u001c\t\u0005\u00053\u0012Y&D\u0001\u0002\u0013\u0011\u0011iFa\u0018\u0003\t\r{G\u000e\\\u0005\u0004\u0005Cj$!D$f]6\u000b\u0007OR1di>\u0014\u0018\u0010E\u0004N\u0003\u0003\u0012)G!\u001b\u0011\u0007!\u00139\u0007B\u0003K\u0007\t\u00071\nE\u0002I\u0005W\"Q!V\u0002C\u0002-\u0003b\u0001O\u0004\u0003f\t%\u0014a\u0003*fkN\f'\r\\3D\u0005\u001a\u0003bA!\u0017\u0003tA\u0003\u0016\u0002\u0002B;\u0005?\u0012q\"T1q\u0007\u0006t')^5mI\u001a\u0013x.\\\u000b\u0007\u0005s\u0012yHa!\u0016\u0005\tm\u0004C\u0002\u001d\b\u0005{\u0012\t\tE\u0002I\u0005\u007f\"QAS\u0003C\u0002-\u00032\u0001\u0013BB\t\u0015)VA1\u0001L\u0003-\u0011X-\u00193SKN|GN^3\u0015\u0005\t%\u0005\u0003\u0002BF\u0005#k!A!$\u000b\t\t=%\u0011F\u0001\u0005Y\u0006tw-\u0003\u0003\u0003\u0014\n5%AB(cU\u0016\u001cG\u000f")
public class LinkedHashMap<A, B>
extends AbstractMap<A, B>
implements HashTable<A, LinkedEntry<A, B>>,
Serializable {
    public static final long serialVersionUID = 1L;
    private transient LinkedEntry<A, B> firstEntry;
    private transient LinkedEntry<A, B> lastEntry;
    private transient int _loadFactor;
    private transient HashEntry<A, LinkedEntry<A, B>>[] table;
    private transient int tableSize;
    private transient int threshold;
    private transient int[] sizemap;
    private transient int seedvalue;

    public static <A, B> CanBuildFrom<LinkedHashMap<?, ?>, Tuple2<A, B>, LinkedHashMap<A, B>> canBuildFrom() {
        return LinkedHashMap$.MODULE$.canBuildFrom();
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
    public void init(ObjectInputStream in, Function0<LinkedEntry<A, B>> readEntry2) {
        HashTable.init$(this, in, readEntry2);
    }

    @Override
    public void serializeTo(ObjectOutputStream out, Function1<LinkedEntry<A, B>, BoxedUnit> writeEntry) {
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
    public Iterator<LinkedEntry<A, B>> entriesIterator() {
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
    public void initWithContents(HashTable.Contents<A, LinkedEntry<A, B>> c) {
        HashTable.initWithContents$(this, c);
    }

    @Override
    public HashTable.Contents<A, LinkedEntry<A, B>> hashTableContents() {
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
    public HashEntry<A, LinkedEntry<A, B>>[] table() {
        return this.table;
    }

    @Override
    public void table_$eq(HashEntry<A, LinkedEntry<A, B>>[] x$1) {
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
    public LinkedHashMap<A, B> empty() {
        return LinkedHashMap$.MODULE$.empty();
    }

    @Override
    public int size() {
        return this.tableSize();
    }

    public LinkedEntry<A, B> firstEntry() {
        return this.firstEntry;
    }

    public void firstEntry_$eq(LinkedEntry<A, B> x$1) {
        this.firstEntry = x$1;
    }

    public LinkedEntry<A, B> lastEntry() {
        return this.lastEntry;
    }

    public void lastEntry_$eq(LinkedEntry<A, B> x$1) {
        this.lastEntry = x$1;
    }

    @Override
    public Option<B> get(A key) {
        LinkedEntry e = (LinkedEntry)this.findEntry((Object)key);
        if (e == null) {
            return None$.MODULE$;
        }
        return new Some(e.value());
    }

    @Override
    public boolean contains(A key) {
        if (this.getClass() == LinkedHashMap.class) {
            return this.findEntry((Object)key) != null;
        }
        return MapLike.contains$(this, key);
    }

    @Override
    public Option<B> put(A key, B value) {
        LinkedEntry e = (LinkedEntry)this.findOrAddEntry((Object)key, (Object)value);
        if (e == null) {
            return None$.MODULE$;
        }
        Object v = e.value();
        e.value_$eq(value);
        return new Some(v);
    }

    @Override
    public Option<B> remove(A key) {
        LinkedEntry e = (LinkedEntry)this.removeEntry((Object)key);
        if (e == null) {
            return None$.MODULE$;
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
        return new Some(e.value());
    }

    @Override
    public LinkedHashMap<A, B> $plus$eq(Tuple2<A, B> kv) {
        this.put(kv._1(), kv._2());
        return this;
    }

    public LinkedHashMap<A, B> $minus$eq(A key) {
        this.remove(key);
        return this;
    }

    @Override
    public Iterator<Tuple2<A, B>> iterator() {
        return new AbstractIterator<Tuple2<A, B>>(this){
            private LinkedEntry<A, B> cur;

            private LinkedEntry<A, B> cur() {
                return this.cur;
            }

            private void cur_$eq(LinkedEntry<A, B> x$1) {
                this.cur = x$1;
            }

            public boolean hasNext() {
                return this.cur() != null;
            }

            /*
             * WARNING - void declaration
             */
            public Tuple2<A, B> next() {
                if (this.hasNext()) {
                    void var1_1;
                    Tuple2<A, B> res = new Tuple2<A, B>(this.cur().key(), this.cur().value());
                    this.cur_$eq(this.cur().later());
                    return var1_1;
                }
                return (Tuple2)((Object)Iterator$.MODULE$.empty().next());
            }
            {
                this.cur = $outer.firstEntry();
            }
        };
    }

    @Override
    public Map<A, B> filterKeys(Function1<A, Object> p) {
        return new FilteredKeys(this, p);
    }

    @Override
    public <C> Map<A, C> mapValues(Function1<B, C> f) {
        return new MappedValues<C>(this, f);
    }

    @Override
    public Set<A> keySet() {
        return new DefaultKeySet(this);
    }

    @Override
    public Iterator<A> keysIterator() {
        return new AbstractIterator<A>(this){
            private LinkedEntry<A, B> cur;

            private LinkedEntry<A, B> cur() {
                return this.cur;
            }

            private void cur_$eq(LinkedEntry<A, B> x$1) {
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
    public Iterator<B> valuesIterator() {
        return new AbstractIterator<B>(this){
            private LinkedEntry<A, B> cur;

            private LinkedEntry<A, B> cur() {
                return this.cur;
            }

            private void cur_$eq(LinkedEntry<A, B> x$1) {
                this.cur = x$1;
            }

            public boolean hasNext() {
                return this.cur() != null;
            }

            /*
             * WARNING - void declaration
             */
            public B next() {
                if (this.hasNext()) {
                    void var1_1;
                    B res = this.cur().value();
                    this.cur_$eq(this.cur().later());
                    return var1_1;
                }
                return (B)Iterator$.MODULE$.empty().next();
            }
            {
                this.cur = $outer.firstEntry();
            }
        };
    }

    @Override
    public <U> void foreach(Function1<Tuple2<A, B>, U> f) {
        for (LinkedEntry<A, B> cur = this.firstEntry(); cur != null; cur = cur.later()) {
            f.apply(new Tuple2<A, B>(cur.key(), cur.value()));
        }
    }

    @Override
    public <U> void foreachEntry(Function1<LinkedEntry<A, B>, U> f) {
        for (LinkedEntry<A, B> cur = this.firstEntry(); cur != null; cur = cur.later()) {
            f.apply(cur);
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public <B1> LinkedEntry<A, B> createNewEntry(A key, B1 value) {
        void var3_3;
        LinkedEntry<A, B1> e = new LinkedEntry<A, B1>(key, value);
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
        this.serializeTo(out, (Function1<LinkedEntry<A, B>, BoxedUnit>)(Function1<LinkedEntry, Object> & java.io.Serializable & Serializable)entry -> {
            LinkedHashMap.$anonfun$writeObject$1(out, entry);
            return BoxedUnit.UNIT;
        });
    }

    private void readObject(ObjectInputStream in) {
        this.firstEntry_$eq(null);
        this.lastEntry_$eq(null);
        this.init(in, (Function0<LinkedEntry<A, B>>)(Function0<LinkedEntry> & java.io.Serializable & Serializable)() -> this.createNewEntry(in.readObject(), in.readObject()));
    }

    public static final /* synthetic */ void $anonfun$writeObject$1(ObjectOutputStream out$1, LinkedEntry entry) {
        out$1.writeObject(entry.key());
        out$1.writeObject(entry.value());
    }

    public LinkedHashMap() {
        HashTable.HashUtils.$init$(this);
        HashTable.$init$(this);
        this.firstEntry = null;
        this.lastEntry = null;
    }

    public class DefaultKeySet
    extends MapLike.DefaultKeySet {
        @Override
        public LinkedHashSet<A> empty() {
            return LinkedHashSet$.MODULE$.empty();
        }

        public /* synthetic */ LinkedHashMap scala$collection$mutable$LinkedHashMap$DefaultKeySet$$$outer() {
            return (LinkedHashMap)this.$outer;
        }

        public DefaultKeySet(LinkedHashMap $outer) {
        }
    }

    public class FilteredKeys
    extends MapLike.FilteredKeys {
        @Override
        public LinkedHashMap<A, Nothing$> empty() {
            return LinkedHashMap$.MODULE$.empty();
        }

        public /* synthetic */ LinkedHashMap scala$collection$mutable$LinkedHashMap$FilteredKeys$$$outer() {
            return (LinkedHashMap)this.$outer;
        }

        public FilteredKeys(LinkedHashMap $outer, Function1<A, Object> p) {
            super($outer, p);
        }
    }

    public class MappedValues<C>
    extends MapLike.MappedValues<C> {
        @Override
        public LinkedHashMap<A, Nothing$> empty() {
            return LinkedHashMap$.MODULE$.empty();
        }

        public /* synthetic */ LinkedHashMap scala$collection$mutable$LinkedHashMap$MappedValues$$$outer() {
            return (LinkedHashMap)this.$outer;
        }

        public MappedValues(LinkedHashMap $outer, Function1<B, C> f) {
            super($outer, f);
        }
    }
}

