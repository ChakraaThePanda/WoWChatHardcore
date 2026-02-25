/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.mutable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import scala.Function1;
import scala.MatchError;
import scala.Option;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.Iterator;
import scala.collection.TraversableLike;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.ArrayOps;
import scala.collection.mutable.FlatHashTable;
import scala.collection.mutable.FlatHashTable$;
import scala.collection.mutable.UnrolledBuffer;
import scala.collection.mutable.UnrolledBuffer$;
import scala.collection.parallel.BucketCombiner;
import scala.collection.parallel.Task;
import scala.collection.parallel.mutable.ParHashMapCombiner$;
import scala.collection.parallel.mutable.ParHashSet;
import scala.collection.parallel.mutable.ParHashSetCombiner$;
import scala.collection.parallel.package$;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.IntRef;
import scala.runtime.LambdaDeserialize;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\t}aA\u0002\u001c8\u0003\u00039t\b\u0003\u0005l\u0001\t\u0015\r\u0011\"\u0003m\u0011!\u0001\bA!A!\u0002\u0013i\u0007\"B9\u0001\t\u0003\u0011\bb\u0002;\u0001\u0005\u0004%I\u0001\u001c\u0005\u0007k\u0002\u0001\u000b\u0011B7\t\u000fY\u0004!\u0019!C\u0005Y\"1q\u000f\u0001Q\u0001\n5DQ\u0001\u001f\u0001\u0005\u0002eDQ! \u0001\u0005\u0002yDaa \u0001\u0005\n\u0005\u0005\u0001bBA\u0007\u0001\u0011%\u0011\u0011\u0001\u0004\u0007\u0003\u001f\u0001\u0001!!\u0005\t\u0013\u0005eAB!A!\u0002\u0013i\u0007\"CA\u000e\u0019\t\u0005\t\u0015!\u0003n\u0011%\ti\u0002\u0004B\u0001B\u0003%Q\u000e\u0003\u0004r\u0019\u0011\u0005\u0011q\u0004\u0005\b\u0003SaA\u0011IA\u0016\u0011\u0019\ti\u0004\u0004C\u0001Y\"9\u0011q\b\u0007\u0005\u0002\u0005\u0005\u0003bBA'\u0019\u0011\u0005\u0011q\n\u0004\u0007\u0003;\u0002\u0001!a\u0018\t\u0015\u0005UTC!A!\u0002\u0013\t9\b\u0003\u0006\u0002~U\u0011\t\u0011)A\u0005\u0003CA\u0011\"a \u0016\u0005\u000b\u0007I\u0011\u00017\t\u0013\u0005\u0005UC!A!\u0002\u0013i\u0007\"CAB+\t\u0015\r\u0011\"\u0001m\u0011%\t))\u0006B\u0001B\u0003%Q\u000e\u0003\u0004r+\u0011\u0005\u0011q\u0011\u0005\t{V\u0001\r\u0011\"\u0001\u0002\u0012\"I\u00111S\u000bA\u0002\u0013\u0005\u0011Q\u0013\u0005\t\u00037+\u0002\u0015)\u0003\u0002h!9\u0011QT\u000b\u0005\u0002\u0005}\u0005\u0002CAV+\t\u0007I\u0011\u00027\t\u000f\u00055V\u0003)A\u0005[\"9\u0011qV\u000b\u0005\n\u0005E\u0006bBA\\+\u0011%\u0011\u0011\u0018\u0005\b\u0003{+B\u0011BA`\u0011\u001d\tY-\u0006C\u0005\u0003\u001bDq!!7\u0016\t\u0003\tY\u000eC\u0004\u0002jV!\t%a;\t\u000f\u0005EX\u0003\"\u0001\u0002t\u001eA\u00111`\u001c\t\u0002e\niPB\u00047o!\u0005\u0011(a@\t\rE\\C\u0011\u0001B\u0001\u0011%\u0011\u0019a\u000bb\u0001\n\u00039D\u000eC\u0004\u0003\u0006-\u0002\u000b\u0011B7\t\u0013\t\u001d1F1A\u0005\u0002]b\u0007b\u0002B\u0005W\u0001\u0006I!\u001c\u0005\n\u0005\u0017Y#\u0019!C\u0001o1DqA!\u0004,A\u0003%Q\u000eC\u0005\u0003\u0010-\u0012\r\u0011\"\u00018Y\"9!\u0011C\u0016!\u0002\u0013i\u0007b\u0002B\nW\u0011\u0005!Q\u0003\u0002\u0013!\u0006\u0014\b*Y:i'\u0016$8i\\7cS:,'O\u0003\u00029s\u00059Q.\u001e;bE2,'B\u0001\u001e<\u0003!\u0001\u0018M]1mY\u0016d'B\u0001\u001f>\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002}\u0005)1oY1mCV\u0011\u0001iR\n\u0004\u0001\u0005S\u0006C\u0002\"D\u000bJ3\u0016,D\u0001:\u0013\t!\u0015H\u0001\bCk\u000e\\W\r^\"p[\nLg.\u001a:\u0011\u0005\u0019;E\u0002\u0001\u0003\u0006\u0011\u0002\u0011\rA\u0013\u0002\u0002)\u000e\u0001\u0011CA&P!\taU*D\u0001>\u0013\tqUHA\u0004O_RD\u0017N\\4\u0011\u00051\u0003\u0016BA)>\u0005\r\te.\u001f\t\u0004'R+U\"A\u001c\n\u0005U;$A\u0003)be\"\u000b7\u000f[*fiB\u0011AjV\u0005\u00031v\u0012a!\u00118z%\u00164\u0007cA*\u0001\u000bB\u00191\f[#\u000f\u0005q+gBA/e\u001d\tq6M\u0004\u0002`E6\t\u0001M\u0003\u0002b\u0013\u00061AH]8pizJ\u0011AP\u0005\u0003yuJ!\u0001O\u001e\n\u0005\u0019<\u0017!\u0004$mCRD\u0015m\u001d5UC\ndWM\u0003\u00029w%\u0011\u0011N\u001b\u0002\n\u0011\u0006\u001c\b.\u0016;jYNT!AZ4\u0002\u001fQ\f'\r\\3M_\u0006$g)Y2u_J,\u0012!\u001c\t\u0003\u0019:L!a\\\u001f\u0003\u0007%sG/\u0001\tuC\ndW\rT8bI\u001a\u000b7\r^8sA\u00051A(\u001b8jiz\"\"!W:\t\u000b-\u001c\u0001\u0019A7\u0002\u00159|g.\\1tW2,g.A\u0006o_:l\u0017m]6mK:\u0004\u0013!C:fK\u00124\u0018\r\\;f\u0003)\u0019X-\u001a3wC2,X\rI\u0001\tIAdWo\u001d\u0013fcR\u0011!p_\u0007\u0002\u0001!)A\u0010\u0003a\u0001\u000b\u0006!Q\r\\3n\u0003\u0019\u0011Xm];miR\t!+A\u0006qCJ\u0004v\u000e];mCR,WCAA\u0002!\u0015\t)!!\u0003F\u001d\r\t9!Z\u0007\u0002O&\u0019\u00111\u00026\u0003\u0011\r{g\u000e^3oiN\f1b]3r!>\u0004X\u000f\\1uK\n\u0019\u0012\t\u001a3j]\u001e4E.\u0019;ICNDG+\u00192mKN!ABVA\n!\u0015\t9!!\u0006F\u0013\r\t9b\u001a\u0002\u000e\r2\fG\u000fS1tQR\u000b'\r\\3\u0002\u00119,X.\u001a7f[N\f!\u0001\u001c4\u0002\u0017%t7/Z3em\u0006dW/\u001a\u000b\t\u0003C\t\u0019#!\n\u0002(A\u0011!\u0010\u0004\u0005\u0007\u00033\u0001\u0002\u0019A7\t\r\u0005m\u0001\u00031\u0001n\u0011\u0019\ti\u0002\u0005a\u0001[\u0006AAo\\*ue&tw\r\u0006\u0002\u0002.A!\u0011qFA\u001c\u001d\u0011\t\t$a\r\u0011\u0005}k\u0014bAA\u001b{\u00051\u0001K]3eK\u001aLA!!\u000f\u0002<\t11\u000b\u001e:j]\u001eT1!!\u000e>\u0003-!\u0018M\u00197f\u0019\u0016tw\r\u001e5\u0002\u000fM,GoU5{KR!\u00111IA%!\ra\u0015QI\u0005\u0004\u0003\u000fj$\u0001B+oSRDa!a\u0013\u0014\u0001\u0004i\u0017AA:{\u0003-Ign]3si\u0016sGO]=\u0015\u000f5\f\t&!\u0016\u0002Z!1\u00111\u000b\u000bA\u00025\f\u0001\"\u001b8tKJ$\u0018\t\u001e\u0005\u0007\u0003/\"\u0002\u0019A7\u0002\u0017\r|W.Z:CK\u001a|'/\u001a\u0005\u0007\u00037\"\u0002\u0019\u0001,\u0002\u00119,w/\u00128uef\u0014!BR5mY\ncwnY6t'\u0011)b+!\u0019\u0011\u000f\t\u000b\u0019'a\u001a\u0002t%\u0019\u0011QM\u001d\u0003\tQ\u000b7o\u001b\t\u0007\u0019\u0006%T.!\u001c\n\u0007\u0005-TH\u0001\u0004UkBdWM\r\t\u0006\u0003\u000f\tyGV\u0005\u0004\u0003c:'AD+oe>dG.\u001a3Ck\u001a4WM\u001d\t\u0003uV\tqAY;dW\u0016$8\u000fE\u0003M\u0003s\ni'C\u0002\u0002|u\u0012Q!\u0011:sCf\fQ\u0001^1cY\u0016\faa\u001c4gg\u0016$\u0018aB8gMN,G\u000fI\u0001\bQ><X.\u00198z\u0003!Awn^7b]f\u0004CCCA:\u0003\u0013\u000bY)!$\u0002\u0010\"9\u0011Q\u000f\u000fA\u0002\u0005]\u0004bBA?9\u0001\u0007\u0011\u0011\u0005\u0005\u0007\u0003\u007fb\u0002\u0019A7\t\r\u0005\rE\u00041\u0001n+\t\t9'\u0001\u0006sKN,H\u000e^0%KF$B!a\u0011\u0002\u0018\"I\u0011\u0011\u0014\u0010\u0002\u0002\u0003\u0007\u0011qM\u0001\u0004q\u0012\n\u0014a\u0002:fgVdG\u000fI\u0001\u0005Y\u0016\fg\r\u0006\u0003\u0002D\u0005\u0005\u0006bBARA\u0001\u0007\u0011QU\u0001\u0005aJ,g\u000fE\u0003M\u0003O\u000b9'C\u0002\u0002*v\u0012aa\u00149uS>t\u0017!\u00032m_\u000e\\7/\u001b>f\u0003)\u0011Gn\\2lg&TX\rI\u0001\u000bE2|7m[*uCJ$HcA7\u00024\"1\u0011QW\u0012A\u00025\fQA\u00197pG.\faB\\3yi\ncwnY6Ti\u0006\u0014H\u000fF\u0002n\u0003wCa!!.%\u0001\u0004i\u0017!\u00034jY2\u0014En\\2l)!\t9'!1\u0002D\u0006\u001d\u0007BBA[K\u0001\u0007Q\u000eC\u0004\u0002F\u0016\u0002\r!!\u001c\u0002\u000b\u0015dW-\\:\t\u000f\u0005%W\u00051\u0001\u0002n\u0005IA.\u001a4u_Z,'o]\u0001\nS:\u001cXM\u001d;BY2$\u0002\"a\u001a\u0002P\u0006M\u0017q\u001b\u0005\u0007\u0003#4\u0003\u0019A7\u0002\u000b\u0005$\bk\\:\t\r\u0005Ug\u00051\u0001n\u0003%\u0011WMZ8sKB{7\u000fC\u0004\u0002F\u001a\u0002\r!!\u001c\u0002\u000bM\u0004H.\u001b;\u0016\u0005\u0005u\u0007CBAp\u0003K\f\u0019(\u0004\u0002\u0002b*\u0019\u00111]\u001e\u0002\u0013%lW.\u001e;bE2,\u0017\u0002BAt\u0003C\u0014A\u0001T5ti\u0006)Q.\u001a:hKR!\u00111IAw\u0011\u001d\ty\u000f\u000ba\u0001\u0003g\nA\u0001\u001e5bi\u0006\u00112\u000f[8vY\u0012\u001c\u0006\u000f\\5u\rV\u0014H\u000f[3s+\t\t)\u0010E\u0002M\u0003oL1!!?>\u0005\u001d\u0011un\u001c7fC:\f!\u0003U1s\u0011\u0006\u001c\bnU3u\u0007>l'-\u001b8feB\u00111kK\n\u0003WY#\"!!@\u0002!\u0011L7o\u0019:j[&t\u0017M\u001c;cSR\u001c\u0018!\u00053jg\u000e\u0014\u0018.\\5oC:$(-\u001b;tA\u0005Ia.^7cY>\u001c7n]\u0001\u000b]Vl'\r\\8dWN\u0004\u0013\u0001\u00053jg\u000e\u0014\u0018.\\5oC:$X.Y:l\u0003E!\u0017n]2sS6Lg.\u00198u[\u0006\u001c8\u000eI\u0001\u000e]>tW.Y:lY\u0016tw\r\u001e5\u0002\u001d9|g.\\1tW2,gn\u001a;iA\u0005)\u0011\r\u001d9msV!!q\u0003B\u000f+\t\u0011I\u0002\u0005\u0003T\u0001\tm\u0001c\u0001$\u0003\u001e\u0011)\u0001*\u000eb\u0001\u0015\u0002")
public abstract class ParHashSetCombiner<T>
extends BucketCombiner<T, ParHashSet<T>, Object, ParHashSetCombiner<T>>
implements FlatHashTable.HashUtils<T> {
    private final int tableLoadFactor;
    private final int nonmasklen;
    private final int scala$collection$parallel$mutable$ParHashSetCombiner$$seedvalue;

    public static <T> ParHashSetCombiner<T> apply() {
        return ParHashSetCombiner$.MODULE$.apply();
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
    public final Object elemToEntry(T elem) {
        return FlatHashTable.HashUtils.elemToEntry$(this, elem);
    }

    @Override
    public final T entryToElem(Object entry) {
        return (T)FlatHashTable.HashUtils.entryToElem$(this, entry);
    }

    private int tableLoadFactor() {
        return this.tableLoadFactor;
    }

    private int nonmasklen() {
        return this.nonmasklen;
    }

    public int scala$collection$parallel$mutable$ParHashSetCombiner$$seedvalue() {
        return this.scala$collection$parallel$mutable$ParHashSetCombiner$$seedvalue;
    }

    @Override
    public ParHashSetCombiner<T> $plus$eq(T elem) {
        Object entry = this.elemToEntry(elem);
        this.sz_$eq(this.sz() + 1);
        int pos = this.improve(entry.hashCode(), this.scala$collection$parallel$mutable$ParHashSetCombiner$$seedvalue()) >>> this.nonmasklen();
        if (this.buckets()[pos] == null) {
            this.buckets()[pos] = new UnrolledBuffer<Object>(ClassTag$.MODULE$.AnyRef());
        }
        this.buckets()[pos].$plus$eq(entry);
        return this;
    }

    @Override
    public ParHashSet<T> result() {
        FlatHashTable.Contents<T> contents = this.size() >= ParHashSetCombiner$.MODULE$.numblocks() * this.sizeMapBucketSize() ? this.parPopulate() : this.seqPopulate();
        return new ParHashSet<T>(contents);
    }

    private FlatHashTable.Contents<T> parPopulate() {
        AddingFlatHashTable table = new AddingFlatHashTable(this.size(), this.tableLoadFactor(), this.scala$collection$parallel$mutable$ParHashSetCombiner$$seedvalue());
        Tuple2<Object, UnrolledBuffer<Object>> tuple2 = this.combinerTaskSupport().executeAndWaitResult(new FillBlocks(this, this.buckets(), table, 0, this.buckets().length));
        if (tuple2 == null) {
            throw new MatchError((Object)null);
        }
        int n = tuple2._1$mcI$sp();
        UnrolledBuffer<Object> unrolledBuffer = tuple2._2();
        IntRef leftinserts = IntRef.create(0);
        unrolledBuffer.foreach((Function1<Object, Object> & java.io.Serializable & Serializable)entry -> {
            ParHashSetCombiner.$anonfun$parPopulate$1(leftinserts, table, entry);
            return BoxedUnit.UNIT;
        });
        table.setSize(leftinserts.elem + n);
        return table.hashTableContents();
    }

    private FlatHashTable.Contents<T> seqPopulate() {
        return new FlatHashTable<T>(this){
            private transient int _loadFactor;
            private transient Object[] table;
            private transient int tableSize;
            private transient int threshold;
            private transient int[] sizemap;
            private transient int seedvalue;

            public int capacity(int expectedSize) {
                return FlatHashTable.capacity$(this, expectedSize);
            }

            public int initialSize() {
                return FlatHashTable.initialSize$(this);
            }

            public int randomSeed() {
                return FlatHashTable.randomSeed$(this);
            }

            public int tableSizeSeed() {
                return FlatHashTable.tableSizeSeed$(this);
            }

            public void init(ObjectInputStream in, Function1<T, BoxedUnit> f) {
                FlatHashTable.init$(this, in, f);
            }

            public void serializeTo(ObjectOutputStream out) {
                FlatHashTable.serializeTo$(this, out);
            }

            public Option<T> findEntry(T elem) {
                return FlatHashTable.findEntry$(this, elem);
            }

            public boolean containsElem(T elem) {
                return FlatHashTable.containsElem$(this, elem);
            }

            public boolean addElem(T elem) {
                return FlatHashTable.addElem$(this, elem);
            }

            public boolean addEntry(Object newEntry) {
                return FlatHashTable.addEntry$(this, newEntry);
            }

            public boolean removeElem(T elem) {
                return FlatHashTable.removeElem$(this, elem);
            }

            public Iterator<T> iterator() {
                return FlatHashTable.iterator$(this);
            }

            public void nnSizeMapAdd(int h) {
                FlatHashTable.nnSizeMapAdd$(this, h);
            }

            public void nnSizeMapRemove(int h) {
                FlatHashTable.nnSizeMapRemove$(this, h);
            }

            public void nnSizeMapReset(int tableLength) {
                FlatHashTable.nnSizeMapReset$(this, tableLength);
            }

            public final int totalSizeMapBuckets() {
                return FlatHashTable.totalSizeMapBuckets$(this);
            }

            public int calcSizeMapSize(int tableLength) {
                return FlatHashTable.calcSizeMapSize$(this, tableLength);
            }

            public void sizeMapInit(int tableLength) {
                FlatHashTable.sizeMapInit$(this, tableLength);
            }

            public void sizeMapInitAndRebuild() {
                FlatHashTable.sizeMapInitAndRebuild$(this);
            }

            public void printSizeMap() {
                FlatHashTable.printSizeMap$(this);
            }

            public void printContents() {
                FlatHashTable.printContents$(this);
            }

            public void sizeMapDisable() {
                FlatHashTable.sizeMapDisable$(this);
            }

            public boolean isSizeMapDefined() {
                return FlatHashTable.isSizeMapDefined$(this);
            }

            public boolean alwaysInitSizeMap() {
                return FlatHashTable.alwaysInitSizeMap$(this);
            }

            public final int index(int hcode) {
                return FlatHashTable.index$(this, hcode);
            }

            public void clearTable() {
                FlatHashTable.clearTable$(this);
            }

            public FlatHashTable.Contents<T> hashTableContents() {
                return FlatHashTable.hashTableContents$(this);
            }

            public void initWithContents(FlatHashTable.Contents<T> c) {
                FlatHashTable.initWithContents$(this, c);
            }

            public final int sizeMapBucketBitSize() {
                return FlatHashTable.HashUtils.sizeMapBucketBitSize$(this);
            }

            public final int sizeMapBucketSize() {
                return FlatHashTable.HashUtils.sizeMapBucketSize$(this);
            }

            public final int improve(int hcode, int seed) {
                return FlatHashTable.HashUtils.improve$(this, hcode, seed);
            }

            public final Object elemToEntry(T elem) {
                return FlatHashTable.HashUtils.elemToEntry$(this, elem);
            }

            public final T entryToElem(Object entry) {
                return (T)FlatHashTable.HashUtils.entryToElem$(this, entry);
            }

            public int _loadFactor() {
                return this._loadFactor;
            }

            public void _loadFactor_$eq(int x$1) {
                this._loadFactor = x$1;
            }

            public Object[] table() {
                return this.table;
            }

            public void table_$eq(Object[] x$1) {
                this.table = x$1;
            }

            public int tableSize() {
                return this.tableSize;
            }

            public void tableSize_$eq(int x$1) {
                this.tableSize = x$1;
            }

            public int threshold() {
                return this.threshold;
            }

            public void threshold_$eq(int x$1) {
                this.threshold = x$1;
            }

            public int[] sizemap() {
                return this.sizemap;
            }

            public void sizemap_$eq(int[] x$1) {
                this.sizemap = x$1;
            }

            public int seedvalue() {
                return this.seedvalue;
            }

            public void seedvalue_$eq(int x$1) {
                this.seedvalue = x$1;
            }

            public static final /* synthetic */ boolean $anonfun$new$1(UnrolledBuffer buffer) {
                return buffer != null;
            }

            public static final /* synthetic */ boolean $anonfun$new$3($anon$1 $this, Object entry) {
                return $this.addEntry(entry);
            }

            public static final /* synthetic */ void $anonfun$new$2($anon$1 $this, UnrolledBuffer buffer) {
                buffer.foreach((Function1<Object, Object> & java.io.Serializable & Serializable)entry -> BoxesRunTime.boxToBoolean($anon$1.$anonfun$new$3($this, entry)));
            }
            {
                FlatHashTable.HashUtils.$init$(this);
                FlatHashTable.$init$(this);
                this.sizeMapInit(this.table().length);
                this.seedvalue_$eq($outer.scala$collection$parallel$mutable$ParHashSetCombiner$$seedvalue());
                Function1<UnrolledBuffer, Object> & java.io.Serializable & Serializable withFilter_p = (Function1<UnrolledBuffer, Object> & java.io.Serializable & Serializable)buffer -> BoxesRunTime.boxToBoolean($anon$1.$anonfun$new$1(buffer));
                ArrayOps.ofRef<Object> withFilter_this = new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])$outer.buckets()));
                new TraversableLike.WithFilter(withFilter_this, withFilter_p).foreach((Function1<UnrolledBuffer, Object> & java.io.Serializable & Serializable)buffer -> {
                    $anon$1.$anonfun$new$2(this, buffer);
                    return BoxedUnit.UNIT;
                });
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$new$3$adapted(scala.collection.parallel.mutable.ParHashSetCombiner$$anon$1 java.lang.Object ), $anonfun$new$1$adapted(scala.collection.mutable.UnrolledBuffer ), $anonfun$new$2$adapted(scala.collection.parallel.mutable.ParHashSetCombiner$$anon$1 scala.collection.mutable.UnrolledBuffer )}, serializedLambda);
            }
        }.hashTableContents();
    }

    public static final /* synthetic */ void $anonfun$parPopulate$1(IntRef leftinserts$1, AddingFlatHashTable table$1, Object entry) {
        leftinserts$1.elem += table$1.insertEntry(0, table$1.tableLength(), entry);
    }

    public ParHashSetCombiner(int tableLoadFactor) {
        this.tableLoadFactor = tableLoadFactor;
        super(ParHashSetCombiner$.MODULE$.numblocks());
        FlatHashTable.HashUtils.$init$(this);
        this.nonmasklen = ParHashSetCombiner$.MODULE$.nonmasklength();
        this.scala$collection$parallel$mutable$ParHashSetCombiner$$seedvalue = 27;
    }

    public class AddingFlatHashTable
    implements FlatHashTable<T> {
        private transient int _loadFactor;
        private transient Object[] table;
        private transient int tableSize;
        private transient int threshold;
        private transient int[] sizemap;
        private transient int seedvalue;

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
        public void init(ObjectInputStream in, Function1<T, BoxedUnit> f) {
            FlatHashTable.init$(this, in, f);
        }

        @Override
        public void serializeTo(ObjectOutputStream out) {
            FlatHashTable.serializeTo$(this, out);
        }

        @Override
        public Option<T> findEntry(T elem) {
            return FlatHashTable.findEntry$(this, elem);
        }

        @Override
        public boolean containsElem(T elem) {
            return FlatHashTable.containsElem$(this, elem);
        }

        @Override
        public boolean addElem(T elem) {
            return FlatHashTable.addElem$(this, elem);
        }

        @Override
        public boolean addEntry(Object newEntry) {
            return FlatHashTable.addEntry$(this, newEntry);
        }

        @Override
        public boolean removeElem(T elem) {
            return FlatHashTable.removeElem$(this, elem);
        }

        @Override
        public Iterator<T> iterator() {
            return FlatHashTable.iterator$(this);
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
        public FlatHashTable.Contents<T> hashTableContents() {
            return FlatHashTable.hashTableContents$(this);
        }

        @Override
        public void initWithContents(FlatHashTable.Contents<T> c) {
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
        public final Object elemToEntry(T elem) {
            return FlatHashTable.HashUtils.elemToEntry$(this, elem);
        }

        @Override
        public final T entryToElem(Object entry) {
            return FlatHashTable.HashUtils.entryToElem$(this, entry);
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

        public String toString() {
            String string = "AFHT(%s)";
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return new StringOps(string).format(Predef$.MODULE$.genericWrapArray(new Object[]{BoxesRunTime.boxToInteger(this.table().length)}));
        }

        public int tableLength() {
            return this.table().length;
        }

        public void setSize(int sz) {
            this.tableSize_$eq(sz);
        }

        public int insertEntry(int insertAt, int comesBefore, Object newEntry) {
            int h = insertAt;
            if (insertAt == -1) {
                h = this.index(newEntry.hashCode());
            }
            Object curEntry = this.table()[h];
            while (curEntry != null) {
                if (BoxesRunTime.equals(curEntry, newEntry)) {
                    return 0;
                }
                if (++h >= comesBefore) {
                    return -1;
                }
                curEntry = this.table()[h];
            }
            this.table()[h] = newEntry;
            this.nnSizeMapAdd(h);
            return 1;
        }

        public /* synthetic */ ParHashSetCombiner scala$collection$parallel$mutable$ParHashSetCombiner$AddingFlatHashTable$$$outer() {
            return ParHashSetCombiner.this;
        }

        public AddingFlatHashTable(int numelems, int lf, int inseedvalue) {
            if (ParHashSetCombiner.this == null) {
                throw null;
            }
            FlatHashTable.HashUtils.$init$(this);
            FlatHashTable.$init$(this);
            this._loadFactor_$eq(lf);
            this.table_$eq(new Object[this.capacity(FlatHashTable$.MODULE$.sizeForThreshold(numelems, this._loadFactor()))]);
            this.tableSize_$eq(0);
            this.threshold_$eq(FlatHashTable$.MODULE$.newThreshold(this._loadFactor(), this.table().length));
            this.seedvalue_$eq(inseedvalue);
            this.sizeMapInit(this.table().length);
        }
    }

    public class FillBlocks
    implements Task<Tuple2<Object, UnrolledBuffer<Object>>, FillBlocks> {
        private final UnrolledBuffer<Object>[] buckets;
        private final AddingFlatHashTable table;
        private final int offset;
        private final int howmany;
        private Tuple2<Object, UnrolledBuffer<Object>> result;
        private final int blocksize;
        private volatile Throwable throwable;
        public final /* synthetic */ ParHashSetCombiner $outer;

        @Override
        public Object repr() {
            return Task.repr$(this);
        }

        @Override
        public void forwardThrowable() {
            Task.forwardThrowable$(this);
        }

        @Override
        public void tryLeaf(Option<Tuple2<Object, UnrolledBuffer<Object>>> lastres) {
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

        public int offset() {
            return this.offset;
        }

        public int howmany() {
            return this.howmany;
        }

        @Override
        public Tuple2<Object, UnrolledBuffer<Object>> result() {
            return this.result;
        }

        @Override
        public void result_$eq(Tuple2<Object, UnrolledBuffer<Object>> x$1) {
            this.result = x$1;
        }

        @Override
        public void leaf(Option<Tuple2<Object, UnrolledBuffer<Object>>> prev) {
            int totalinserts = 0;
            UnrolledBuffer<Object> leftover = new UnrolledBuffer<Object>(ClassTag$.MODULE$.AnyRef());
            for (int i = this.offset(); i < this.offset() + this.howmany(); ++i) {
                Tuple2<Object, UnrolledBuffer<Object>> tuple2 = this.fillBlock(i, this.buckets[i], leftover);
                if (tuple2 == null) {
                    throw new MatchError((Object)null);
                }
                int n = tuple2._1$mcI$sp();
                UnrolledBuffer<Object> unrolledBuffer = tuple2._2();
                totalinserts += n;
                leftover = unrolledBuffer;
            }
            this.result_$eq(new Tuple2<Object, UnrolledBuffer<Object>>(BoxesRunTime.boxToInteger(totalinserts), leftover));
        }

        private int blocksize() {
            return this.blocksize;
        }

        private int blockStart(int block) {
            return block * this.blocksize();
        }

        private int nextBlockStart(int block) {
            return (block + 1) * this.blocksize();
        }

        private Tuple2<Object, UnrolledBuffer<Object>> fillBlock(int block, UnrolledBuffer<Object> elems, UnrolledBuffer<Object> leftovers) {
            Tuple2<Object, UnrolledBuffer<Object>> tuple2;
            int beforePos = this.nextBlockStart(block);
            Tuple2<Object, UnrolledBuffer<Object>> tuple22 = tuple2 = elems != null ? this.insertAll(-1, beforePos, elems) : new Tuple2<Object, UnrolledBuffer<Object>>(BoxesRunTime.boxToInteger(0), (UnrolledBuffer<Object>)UnrolledBuffer$.MODULE$.apply(Nil$.MODULE$, ClassTag$.MODULE$.AnyRef()));
            if (tuple2 == null) {
                throw new MatchError((Object)null);
            }
            int n = tuple2._1$mcI$sp();
            UnrolledBuffer<Object> unrolledBuffer = tuple2._2();
            Tuple2<Object, UnrolledBuffer<Object>> tuple23 = this.insertAll(this.blockStart(block), beforePos, leftovers);
            if (tuple23 == null) {
                throw new MatchError((Object)null);
            }
            int n2 = tuple23._1$mcI$sp();
            UnrolledBuffer<Object> unrolledBuffer2 = tuple23._2();
            return new Tuple2<Object, UnrolledBuffer<Object>>(BoxesRunTime.boxToInteger(n + n2), unrolledBuffer.concat(unrolledBuffer2));
        }

        private Tuple2<Object, UnrolledBuffer<Object>> insertAll(int atPos, int beforePos, UnrolledBuffer<Object> elems) {
            UnrolledBuffer<Object> leftovers = new UnrolledBuffer<Object>(ClassTag$.MODULE$.AnyRef());
            int inserted = 0;
            int i = 0;
            AddingFlatHashTable t = this.table;
            for (UnrolledBuffer.Unrolled<Object> unrolled = elems.headPtr(); unrolled != null; unrolled = unrolled.next()) {
                Object[] chunkarr = (Object[])unrolled.array();
                int chunksz = unrolled.size();
                while (i < chunksz) {
                    Object entry = chunkarr[i];
                    int res = t.insertEntry(atPos, beforePos, entry);
                    if (res >= 0) {
                        inserted += res;
                    } else {
                        leftovers.$plus$eq(entry);
                    }
                    ++i;
                }
                i = 0;
            }
            return new Tuple2<Object, UnrolledBuffer<Object>>(BoxesRunTime.boxToInteger(inserted), leftovers);
        }

        public List<FillBlocks> split() {
            int fp = this.howmany() / 2;
            return new $colon$colon<Nothing$>((Nothing$)((Object)new FillBlocks(this.scala$collection$parallel$mutable$ParHashSetCombiner$FillBlocks$$$outer(), this.buckets, this.table, this.offset(), fp)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)new FillBlocks(this.scala$collection$parallel$mutable$ParHashSetCombiner$FillBlocks$$$outer(), this.buckets, this.table, this.offset() + fp, this.howmany() - fp)), Nil$.MODULE$));
        }

        @Override
        public void merge(FillBlocks that) {
            int beforePos;
            int atPos = this.blockStart(that.offset());
            Tuple2<Object, UnrolledBuffer<Object>> tuple2 = this.insertAll(atPos, beforePos = this.blockStart(that.offset() + that.howmany()), (UnrolledBuffer)((Tuple2)this.result())._2());
            if (tuple2 == null) {
                throw new MatchError((Object)null);
            }
            int n = tuple2._1$mcI$sp();
            UnrolledBuffer<Object> unrolledBuffer = tuple2._2();
            this.result_$eq(new Tuple2<Object, UnrolledBuffer<Object>>(BoxesRunTime.boxToInteger(((Tuple2)this.result())._1$mcI$sp() + ((Tuple2)that.result())._1$mcI$sp() + n), unrolledBuffer.concat((UnrolledBuffer)((Tuple2)that.result())._2())));
        }

        @Override
        public boolean shouldSplitFurther() {
            return this.howmany() > package$.MODULE$.thresholdFromSize(ParHashMapCombiner$.MODULE$.numblocks(), this.scala$collection$parallel$mutable$ParHashSetCombiner$FillBlocks$$$outer().combinerTaskSupport().parallelismLevel());
        }

        public /* synthetic */ ParHashSetCombiner scala$collection$parallel$mutable$ParHashSetCombiner$FillBlocks$$$outer() {
            return this.$outer;
        }

        public FillBlocks(ParHashSetCombiner $outer, UnrolledBuffer<Object>[] buckets, AddingFlatHashTable table, int offset, int howmany) {
            this.buckets = buckets;
            this.table = table;
            this.offset = offset;
            this.howmany = howmany;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Task.$init$(this);
            this.result = new Tuple2<Integer, UnrolledBuffer<Object>>(BoxesRunTime.boxToInteger(Integer.MIN_VALUE), new UnrolledBuffer<Object>(ClassTag$.MODULE$.AnyRef()));
            this.blocksize = table.tableLength() >> ParHashSetCombiner$.MODULE$.discriminantbits();
        }
    }
}

