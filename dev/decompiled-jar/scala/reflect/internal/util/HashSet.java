/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.BufferedIterator;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.Traversable;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.Clearable;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Stream;
import scala.collection.immutable.StringOps;
import scala.collection.immutable.Vector;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.StringBuilder;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.math.package$;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.util.Set;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.Statics;

@ScalaSignature(bytes="\u0006\u0001\u0005%s!B\u000e\u001d\u0011\u0003)c!B\u0014\u001d\u0011\u0003A\u0003\"B\u0017\u0002\t\u0003q\u0003\"B\u0018\u0002\t\u0003\u0001\u0004BB\u0018\u0002\t\u0003\tYD\u0002\u0003(9\u0001\u0019\u0004\u0002\u0003%\u0006\u0005\u000b\u0007I\u0011A%\t\u0011U+!\u0011!Q\u0001\n)C\u0001BV\u0003\u0003\u0002\u0003\u0006Ia\u0016\u0005\u0006[\u0015!\tA\u0017\u0005\b=\u0016\u0001\r\u0011\"\u0003`\u0011\u001d\u0001W\u00011A\u0005\n\u0005DaaZ\u0003!B\u00139\u0006b\u00025\u0006\u0001\u0004%I!\u001b\u0005\b[\u0016\u0001\r\u0011\"\u0003o\u0011\u0019\u0001X\u0001)Q\u0005U\")\u0011/\u0002C\u0005e\")Q/\u0002C\u0001?\")a/\u0002C\u0001o\")\u00010\u0002C\u0001s\")10\u0002C\u0001y\")a0\u0002C\u0001\u007f\"9\u00111A\u0003\u0005\u0002\u0005\u0015\u0001bBA\r\u000b\u0011\u0005\u00111\u0004\u0005\b\u0003S)A\u0011BA\u0016\u0011\u0019\ty#\u0002C\u0005o\"9\u0011\u0011G\u0003\u0005B\u0005M\u0012a\u0002%bg\"\u001cV\r\u001e\u0006\u0003;y\tA!\u001e;jY*\u0011q\u0004I\u0001\tS:$XM\u001d8bY*\u0011\u0011EI\u0001\be\u00164G.Z2u\u0015\u0005\u0019\u0013!B:dC2\f7\u0001\u0001\t\u0003M\u0005i\u0011\u0001\b\u0002\b\u0011\u0006\u001c\bnU3u'\t\t\u0011\u0006\u0005\u0002+W5\t!%\u0003\u0002-E\t1\u0011I\\=SK\u001a\fa\u0001P5oSRtD#A\u0013\u0002\u000b\u0005\u0004\b\u000f\\=\u0016\u0007E\n9\u0004F\u00023\u0003s\u0001BAJ\u0003\u00026U\u0011AGO\n\u0004\u000bU\u0002\u0005c\u0001\u00147q%\u0011q\u0007\b\u0002\u0004'\u0016$\bCA\u001d;\u0019\u0001!QaO\u0003C\u0002q\u0012\u0011\u0001V\t\u0003{%\u0002\"A\u000b \n\u0005}\u0012#\u0001\u0002(vY2\u0004\"!\u0011$\u000e\u0003\tS!a\u0011#\u0002\u000f\u001d,g.\u001a:jG*\u0011QII\u0001\u000bG>dG.Z2uS>t\u0017BA$C\u0005%\u0019E.Z1sC\ndW-A\u0003mC\n,G.F\u0001K!\tY%K\u0004\u0002M!B\u0011QJI\u0007\u0002\u001d*\u0011q\nJ\u0001\u0007yI|w\u000e\u001e \n\u0005E\u0013\u0013A\u0002)sK\u0012,g-\u0003\u0002T)\n11\u000b\u001e:j]\u001eT!!\u0015\u0012\u0002\r1\f'-\u001a7!\u0003=Ig.\u001b;jC2\u001c\u0015\r]1dSRL\bC\u0001\u0016Y\u0013\tI&EA\u0002J]R$2a\u0017/^!\r1S\u0001\u000f\u0005\u0006\u0011&\u0001\rA\u0013\u0005\u0006-&\u0001\raV\u0001\u0005kN,G-F\u0001X\u0003!)8/\u001a3`I\u0015\fHC\u00012f!\tQ3-\u0003\u0002eE\t!QK\\5u\u0011\u001d17\"!AA\u0002]\u000b1\u0001\u001f\u00132\u0003\u0015)8/\u001a3!\u0003\u0015!\u0018M\u00197f+\u0005Q\u0007c\u0001\u0016lS%\u0011AN\t\u0002\u0006\u0003J\u0014\u0018-_\u0001\ni\u0006\u0014G.Z0%KF$\"AY8\t\u000f\u0019t\u0011\u0011!a\u0001U\u00061A/\u00192mK\u0002\nQ!\u001b8eKb$\"aV:\t\u000bQ\u0004\u0002\u0019A,\u0002\u0003a\fAa]5{K\u0006)1\r\\3beR\t!-A\tgS:$WI\u001c;ss>\u0013X\u000b\u001d3bi\u0016$\"\u0001\u000f>\t\u000bQ\u001c\u0002\u0019\u0001\u001d\u0002\u0013\u0019Lg\u000eZ#oiJLHC\u0001\u001d~\u0011\u0015!H\u00031\u00019\u0003!\tG\rZ#oiJLHc\u00012\u0002\u0002!)A/\u0006a\u0001q\u0005Q\u0011\r\u001a3F]R\u0014\u0018.Z:\u0015\u0007\t\f9\u0001C\u0004\u0002\nY\u0001\r!a\u0003\u0002\u0005a\u001c\b#BA\u0007\u0003'Adb\u0001\u0016\u0002\u0010%\u0019\u0011\u0011\u0003\u0012\u0002\u000fA\f7m[1hK&!\u0011QCA\f\u0005=!&/\u0019<feN\f'\r\\3P]\u000e,'bAA\tE\u0005A\u0011\u000e^3sCR|'/\u0006\u0002\u0002\u001eI)\u0011qD\u0015\u0002$\u00191\u0011\u0011E\f\u0001\u0003;\u0011A\u0002\u0010:fM&tW-\\3oiz\u0002R!!\u0004\u0002&aJA!a\n\u0002\u0018\tA\u0011\n^3sCR|'/A\u0006bI\u0012|E\u000eZ#oiJLHc\u00012\u0002.!)A\u000f\u0007a\u0001q\u0005IqM]8x)\u0006\u0014G.Z\u0001\ti>\u001cFO]5oOR\t!\nE\u0002:\u0003o!QaO\u0002C\u0002qBQAV\u0002A\u0002]+B!!\u0010\u0002DQ1\u0011qHA#\u0003\u000f\u0002BAJ\u0003\u0002BA\u0019\u0011(a\u0011\u0005\u000bm\"!\u0019\u0001\u001f\t\u000b!#\u0001\u0019\u0001&\t\u000bY#\u0001\u0019A,")
public class HashSet<T>
extends Set<T>
implements Clearable {
    private final String label;
    private final int initialCapacity;
    private int used;
    private Object[] scala$reflect$internal$util$HashSet$$table;

    public String label() {
        return this.label;
    }

    private int used() {
        return this.used;
    }

    private void used_$eq(int x$1) {
        this.used = x$1;
    }

    public Object[] scala$reflect$internal$util$HashSet$$table() {
        return this.scala$reflect$internal$util$HashSet$$table;
    }

    private void scala$reflect$internal$util$HashSet$$table_$eq(Object[] x$1) {
        this.scala$reflect$internal$util$HashSet$$table = x$1;
    }

    private int index(int x) {
        return package$.MODULE$.abs(x % this.scala$reflect$internal$util$HashSet$$table().length);
    }

    public int size() {
        return this.used();
    }

    @Override
    public void clear() {
        this.used_$eq(0);
        this.scala$reflect$internal$util$HashSet$$table_$eq(new Object[this.initialCapacity]);
    }

    public T findEntryOrUpdate(T x) {
        int h = this.index(Statics.anyHash(x));
        Object entry = this.scala$reflect$internal$util$HashSet$$table()[h];
        while (entry != null) {
            if (BoxesRunTime.equals(x, entry)) {
                return (T)entry;
            }
            h = this.index(h + 1);
            entry = this.scala$reflect$internal$util$HashSet$$table()[h];
        }
        this.scala$reflect$internal$util$HashSet$$table()[h] = x;
        this.used_$eq(this.used() + 1);
        if (this.used() > this.scala$reflect$internal$util$HashSet$$table().length >> 2) {
            this.growTable();
        }
        return x;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public T findEntry(T x) {
        void var3_3;
        int h = this.index(Statics.anyHash(x));
        Object entry = this.scala$reflect$internal$util$HashSet$$table()[h];
        while (entry != null && !BoxesRunTime.equals(x, entry)) {
            h = this.index(h + 1);
            entry = this.scala$reflect$internal$util$HashSet$$table()[h];
        }
        return var3_3;
    }

    @Override
    public void addEntry(T x) {
        int h = this.index(Statics.anyHash(x));
        Object entry = this.scala$reflect$internal$util$HashSet$$table()[h];
        while (entry != null) {
            if (BoxesRunTime.equals(x, entry)) {
                return;
            }
            h = this.index(h + 1);
            entry = this.scala$reflect$internal$util$HashSet$$table()[h];
        }
        this.scala$reflect$internal$util$HashSet$$table()[h] = x;
        this.used_$eq(this.used() + 1);
        if (this.used() > this.scala$reflect$internal$util$HashSet$$table().length >> 2) {
            this.growTable();
        }
    }

    public void addEntries(TraversableOnce<T> xs) {
        xs.foreach((Function1<Object, Object> & java.io.Serializable & Serializable)(A x) -> {
            this.addEntry(x);
            return BoxedUnit.UNIT;
        });
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(this){
            private int i;
            private final /* synthetic */ HashSet $outer;

            public Iterator<T> seq() {
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

            public Iterator<T> take(int n) {
                return Iterator.take$(this, n);
            }

            public Iterator<T> drop(int n) {
                return Iterator.drop$(this, n);
            }

            public Iterator<T> slice(int from, int until) {
                return Iterator.slice$(this, from, until);
            }

            public Iterator<T> sliceIterator(int from, int until) {
                return Iterator.sliceIterator$(this, from, until);
            }

            public <B> Iterator<B> map(Function1<T, B> f) {
                return Iterator.map$(this, f);
            }

            public <B> Iterator<B> $plus$plus(Function0<GenTraversableOnce<B>> that) {
                return Iterator.$plus$plus$(this, that);
            }

            public <B> Iterator<B> flatMap(Function1<T, GenTraversableOnce<B>> f) {
                return Iterator.flatMap$(this, f);
            }

            public Iterator<T> filter(Function1<T, Object> p) {
                return Iterator.filter$(this, p);
            }

            public <B> boolean corresponds(GenTraversableOnce<B> that, Function2<T, B, Object> p) {
                return Iterator.corresponds$(this, that, p);
            }

            public Iterator<T> withFilter(Function1<T, Object> p) {
                return Iterator.withFilter$(this, p);
            }

            public Iterator<T> filterNot(Function1<T, Object> p) {
                return Iterator.filterNot$(this, p);
            }

            public <B> Iterator<B> collect(PartialFunction<T, B> pf) {
                return Iterator.collect$(this, pf);
            }

            public <B> Iterator<B> scanLeft(B z, Function2<B, T, B> op) {
                return Iterator.scanLeft$(this, z, op);
            }

            public <B> Iterator<B> scanRight(B z, Function2<T, B, B> op) {
                return Iterator.scanRight$(this, z, op);
            }

            public Iterator<T> takeWhile(Function1<T, Object> p) {
                return Iterator.takeWhile$(this, p);
            }

            public Tuple2<Iterator<T>, Iterator<T>> partition(Function1<T, Object> p) {
                return Iterator.partition$(this, p);
            }

            public Tuple2<Iterator<T>, Iterator<T>> span(Function1<T, Object> p) {
                return Iterator.span$(this, p);
            }

            public Iterator<T> dropWhile(Function1<T, Object> p) {
                return Iterator.dropWhile$(this, p);
            }

            public <B> Iterator<Tuple2<T, B>> zip(Iterator<B> that) {
                return Iterator.zip$(this, that);
            }

            public <A1> Iterator<A1> padTo(int len, A1 elem) {
                return Iterator.padTo$(this, len, elem);
            }

            public Iterator<Tuple2<T, Object>> zipWithIndex() {
                return Iterator.zipWithIndex$(this);
            }

            public <B, A1, B1> Iterator<Tuple2<A1, B1>> zipAll(Iterator<B> that, A1 thisElem, B1 thatElem) {
                return Iterator.zipAll$(this, that, thisElem, thatElem);
            }

            public <U> void foreach(Function1<T, U> f) {
                Iterator.foreach$(this, f);
            }

            public boolean forall(Function1<T, Object> p) {
                return Iterator.forall$(this, p);
            }

            public boolean exists(Function1<T, Object> p) {
                return Iterator.exists$(this, p);
            }

            public boolean contains(Object elem) {
                return Iterator.contains$(this, elem);
            }

            public Option<T> find(Function1<T, Object> p) {
                return Iterator.find$(this, p);
            }

            public int indexWhere(Function1<T, Object> p) {
                return Iterator.indexWhere$(this, p);
            }

            public int indexWhere(Function1<T, Object> p, int from) {
                return Iterator.indexWhere$(this, p, from);
            }

            public <B> int indexOf(B elem) {
                return Iterator.indexOf$(this, elem);
            }

            public <B> int indexOf(B elem, int from) {
                return Iterator.indexOf$(this, elem, from);
            }

            public BufferedIterator<T> buffered() {
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

            public Tuple2<Iterator<T>, Iterator<T>> duplicate() {
                return Iterator.duplicate$(this);
            }

            public <B> Iterator<B> patch(int from, Iterator<B> patchElems, int replaced) {
                return Iterator.patch$(this, from, patchElems, replaced);
            }

            public <B> void copyToArray(Object xs, int start, int len) {
                Iterator.copyToArray$(this, xs, start, len);
            }

            public boolean sameElements(Iterator<?> that) {
                return Iterator.sameElements$(this, that);
            }

            public Traversable<T> toTraversable() {
                return Iterator.toTraversable$(this);
            }

            public Iterator<T> toIterator() {
                return Iterator.toIterator$(this);
            }

            public Stream<T> toStream() {
                return Iterator.toStream$(this);
            }

            public String toString() {
                return Iterator.toString$(this);
            }

            public List<T> reversed() {
                return TraversableOnce.reversed$(this);
            }

            public int size() {
                return TraversableOnce.size$(this);
            }

            public boolean nonEmpty() {
                return TraversableOnce.nonEmpty$(this);
            }

            public int count(Function1<T, Object> p) {
                return TraversableOnce.count$(this, p);
            }

            public <B> Option<B> collectFirst(PartialFunction<T, B> pf) {
                return TraversableOnce.collectFirst$(this, pf);
            }

            public <B> B $div$colon(B z, Function2<B, T, B> op) {
                return (B)TraversableOnce.$div$colon$(this, z, op);
            }

            public <B> B $colon$bslash(B z, Function2<T, B, B> op) {
                return (B)TraversableOnce.$colon$bslash$(this, z, op);
            }

            public <B> B foldLeft(B z, Function2<B, T, B> op) {
                return (B)TraversableOnce.foldLeft$(this, z, op);
            }

            public <B> B foldRight(B z, Function2<T, B, B> op) {
                return (B)TraversableOnce.foldRight$(this, z, op);
            }

            public <B> B reduceLeft(Function2<B, T, B> op) {
                return (B)TraversableOnce.reduceLeft$(this, op);
            }

            public <B> B reduceRight(Function2<T, B, B> op) {
                return (B)TraversableOnce.reduceRight$(this, op);
            }

            public <B> Option<B> reduceLeftOption(Function2<B, T, B> op) {
                return TraversableOnce.reduceLeftOption$(this, op);
            }

            public <B> Option<B> reduceRightOption(Function2<T, B, B> op) {
                return TraversableOnce.reduceRightOption$(this, op);
            }

            public <A1> A1 reduce(Function2<A1, A1, A1> op) {
                return (A1)TraversableOnce.reduce$(this, op);
            }

            public <A1> Option<A1> reduceOption(Function2<A1, A1, A1> op) {
                return TraversableOnce.reduceOption$(this, op);
            }

            public <A1> A1 fold(A1 z, Function2<A1, A1, A1> op) {
                return (A1)TraversableOnce.fold$(this, z, op);
            }

            public <B> B aggregate(Function0<B> z, Function2<B, T, B> seqop, Function2<B, B, B> combop) {
                return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
            }

            public <B> B sum(Numeric<B> num) {
                return (B)TraversableOnce.sum$(this, num);
            }

            public <B> B product(Numeric<B> num) {
                return (B)TraversableOnce.product$(this, num);
            }

            public <B> T min(Ordering<B> cmp) {
                return (T)TraversableOnce.min$(this, cmp);
            }

            public <B> T max(Ordering<B> cmp) {
                return (T)TraversableOnce.max$(this, cmp);
            }

            public <B> T maxBy(Function1<T, B> f, Ordering<B> cmp) {
                return (T)TraversableOnce.maxBy$(this, f, cmp);
            }

            public <B> T minBy(Function1<T, B> f, Ordering<B> cmp) {
                return (T)TraversableOnce.minBy$(this, f, cmp);
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

            public List<T> toList() {
                return TraversableOnce.toList$(this);
            }

            public Iterable<T> toIterable() {
                return TraversableOnce.toIterable$(this);
            }

            public Seq<T> toSeq() {
                return TraversableOnce.toSeq$(this);
            }

            public IndexedSeq<T> toIndexedSeq() {
                return TraversableOnce.toIndexedSeq$(this);
            }

            public <B> Buffer<B> toBuffer() {
                return TraversableOnce.toBuffer$(this);
            }

            public <B> scala.collection.immutable.Set<B> toSet() {
                return TraversableOnce.toSet$(this);
            }

            public Vector<T> toVector() {
                return TraversableOnce.toVector$(this);
            }

            public <Col> Col to(CanBuildFrom<Nothing$, T, Col> cbf) {
                return (Col)TraversableOnce.to$(this, cbf);
            }

            public <T, U> Map<T, U> toMap(Predef$.less.colon.less<T, Tuple2<T, U>> ev) {
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

            private int i() {
                return this.i;
            }

            private void i_$eq(int x$1) {
                this.i = x$1;
            }

            public boolean hasNext() {
                while (this.i() < this.$outer.scala$reflect$internal$util$HashSet$$table().length && this.$outer.scala$reflect$internal$util$HashSet$$table()[this.i()] == null) {
                    this.i_$eq(this.i() + 1);
                }
                return this.i() < this.$outer.scala$reflect$internal$util$HashSet$$table().length;
            }

            public T next() {
                if (this.hasNext()) {
                    this.i_$eq(this.i() + 1);
                    return (T)this.$outer.scala$reflect$internal$util$HashSet$$table()[this.i() - 1];
                }
                return null;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                GenTraversableOnce.$init$(this);
                TraversableOnce.$init$(this);
                Iterator.$init$(this);
                this.i = 0;
            }
        };
    }

    private void addOldEntry(T x) {
        int h = this.index(Statics.anyHash(x));
        Object entry = this.scala$reflect$internal$util$HashSet$$table()[h];
        while (entry != null) {
            h = this.index(h + 1);
            entry = this.scala$reflect$internal$util$HashSet$$table()[h];
        }
        this.scala$reflect$internal$util$HashSet$$table()[h] = x;
    }

    private void growTable() {
        Object[] oldtable = this.scala$reflect$internal$util$HashSet$$table();
        int growthFactor = this.scala$reflect$internal$util$HashSet$$table().length <= this.initialCapacity ? 8 : (this.scala$reflect$internal$util$HashSet$$table().length <= this.initialCapacity * 8 ? 4 : 2);
        this.scala$reflect$internal$util$HashSet$$table_$eq(new Object[this.scala$reflect$internal$util$HashSet$$table().length * growthFactor]);
        for (int i = 0; i < oldtable.length; ++i) {
            Object entry = oldtable[i];
            if (entry == null) continue;
            this.addOldEntry(entry);
        }
    }

    public String toString() {
        String string = "HashSet %s(%d / %d)";
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return new StringOps(string).format(Predef$.MODULE$.genericWrapArray(new Object[]{this.label(), BoxesRunTime.boxToInteger(this.used()), BoxesRunTime.boxToInteger(this.scala$reflect$internal$util$HashSet$$table().length)}));
    }

    public HashSet(String label, int initialCapacity) {
        this.label = label;
        this.initialCapacity = initialCapacity;
        this.used = 0;
        this.scala$reflect$internal$util$HashSet$$table = new Object[initialCapacity];
    }
}

