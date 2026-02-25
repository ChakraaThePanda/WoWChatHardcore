/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Array$;
import scala.Function1;
import scala.Option;
import scala.Predef$;
import scala.Serializable;
import scala.collection.AbstractIterator;
import scala.collection.BitSetLike;
import scala.collection.GenSet;
import scala.collection.GenSetLike;
import scala.collection.Iterator;
import scala.collection.SortedSet;
import scala.collection.SortedSetLike;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.Sorted;
import scala.collection.immutable.Range;
import scala.collection.mutable.AbstractSet;
import scala.collection.mutable.BitSet$;
import scala.collection.mutable.StringBuilder;
import scala.math.Ordering;
import scala.reflect.ScalaSignature;
import scala.runtime.RichInt$;

@ScalaSignature(bytes="\u0006\u0001\u0005Ef\u0001\u0002\u0012$\u0001)B\u0001b\u0011\u0001\u0003\u0002\u0004%)\u0002\u0012\u0005\t\u0017\u0002\u0011\t\u0019!C\u000b\u0019\"A!\u000b\u0001B\u0001B\u00036Q\tC\u0003T\u0001\u0011\u0005A\u000bC\u0003W\u0001\u0011\u0005s\u000bC\u0003T\u0001\u0011\u0005\u0001\fC\u0003T\u0001\u0011\u00051\fC\u0003]\u0001\u0011EQ\fC\u0003g\u0001\u0011Eq\rC\u0003l\u0001\u0011UA\u000eC\u0003q\u0001\u0011U\u0011\u000fC\u0003t\u0001\u0011EA\u000fC\u0003x\u0001\u0011\u0005\u0003\u0010C\u0003\u007f\u0001\u0011\u0005s\u0010C\u0004\u0002\u0004\u0001!\t!!\u0002\t\u000f\u0005E\u0001\u0001\"\u0001\u0002\u0014!9\u0011\u0011\u0004\u0001\u0005\u0002\u0005m\u0001bBA\u0011\u0001\u0011\u0005\u00111\u0005\u0005\b\u0003O\u0001A\u0011AA\u0015\u0011\u001d\ti\u0003\u0001C\u0001\u0003_Aq!a\r\u0001\t\u0003\n)\u0004C\u0004\u00028\u0001!\t!!\u000f\t\r\u0005U\u0003\u0001\"\u0011\\\u000f\u001d\t\u0019g\tE\u0001\u0003K2aAI\u0012\t\u0002\u0005\u001d\u0004BB*\u001a\t\u0003\tY\bC\u0003W3\u0011\u0005q\u000bC\u0004\u0002~e!\t!a \t\u0013\u0005\u001d\u0015D1A\u0005\u0004\u0005%\u0005\u0002CAI3\u0001\u0006I!a#\t\u000f\u0005M\u0015\u0004\"\u0001\u0002\u0016\"11/\u0007C\u0001\u00033C\u0011\"!(\u001a\u0003\u0003%I!a(\u0003\r\tKGoU3u\u0015\t!S%A\u0004nkR\f'\r\\3\u000b\u0005\u0019:\u0013AC2pY2,7\r^5p]*\t\u0001&A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\u000f\u0001Y3GN\u001d>\u0001B\u0019A&L\u0018\u000e\u0003\rJ!AL\u0012\u0003\u0017\u0005\u00137\u000f\u001e:bGR\u001cV\r\u001e\t\u0003aEj\u0011aJ\u0005\u0003e\u001d\u00121!\u00138u!\raCgL\u0005\u0003k\r\u0012\u0011bU8si\u0016$7+\u001a;\u0011\u0005]BT\"A\u0013\n\u0005\t*\u0003cA\u001c;y%\u00111(\n\u0002\u000b\u0005&$8+\u001a;MS.,\u0007C\u0001\u0017\u0001!\u0011ach\f\u001f\n\u0005}\u001a#aB*fi2K7.\u001a\t\u0003a\u0005K!AQ\u0014\u0003\u0019M+'/[1mSj\f'\r\\3\u0002\u000b\u0015dW-\\:\u0016\u0003\u0015\u00032\u0001\r$I\u0013\t9uEA\u0003BeJ\f\u0017\u0010\u0005\u00021\u0013&\u0011!j\n\u0002\u0005\u0019>tw-A\u0005fY\u0016l7o\u0018\u0013fcR\u0011Q\n\u0015\t\u0003a9K!aT\u0014\u0003\tUs\u0017\u000e\u001e\u0005\b#\n\t\t\u00111\u0001F\u0003\rAH%M\u0001\u0007K2,Wn\u001d\u0011\u0002\rqJg.\u001b;?)\taT\u000bC\u0003D\t\u0001\u0007Q)A\u0003f[B$\u00180F\u0001=)\ta\u0014\fC\u0003[\r\u0001\u0007q&\u0001\u0005j]&$8+\u001b>f)\u0005a\u0014A\u00028x_J$7/F\u00010Q\u0011AqL\u00193\u0011\u0005A\u0002\u0017BA1(\u0005Q!W\r\u001d:fG\u0006$X\rZ(wKJ\u0014\u0018\u000eZ5oO\u0006\n1-\u0001&J]R,'O\\1mA%l\u0007\u000f\\3nK:$\u0018\r^5p]\u0002\"w.Z:!]>$\b%\u00193nSR\u00043/\u001a8tS\ndW\rI8wKJ\u0014\u0018\u000eZ5oO\u0002zg\r\t;iSN\u0004S.\u001a;i_\u0012t\u0013%A3\u0002\rIr\u0013'\r\u00181\u0003\u00119xN\u001d3\u0015\u0005!C\u0007\"B5\n\u0001\u0004y\u0013aA5eq\"\"\u0011b\u00182e\u0003))\b\u000fZ1uK^{'\u000f\u001a\u000b\u0004\u001b6t\u0007\"B5\u000b\u0001\u0004y\u0003\"B8\u000b\u0001\u0004A\u0015!A<\u0002\u001d\u0015t7/\u001e:f\u0007\u0006\u0004\u0018mY5usR\u0011QJ\u001d\u0005\u0006S.\u0001\raL\u0001\u0012MJ|WNQ5u\u001b\u0006\u001c8NT8D_BLHC\u0001\u001fv\u0011\u00151H\u00021\u0001F\u0003\u00159xN\u001d3t\u0003\r\tG\r\u001a\u000b\u0003sr\u0004\"\u0001\r>\n\u0005m<#a\u0002\"p_2,\u0017M\u001c\u0005\u0006{6\u0001\raL\u0001\u0005K2,W.\u0001\u0004sK6|g/\u001a\u000b\u0004s\u0006\u0005\u0001\"B?\u000f\u0001\u0004y\u0013\u0001\u0003\u0013qYV\u001cH%Z9\u0015\t\u0005\u001d\u0011\u0011B\u0007\u0002\u0001!)Qp\u0004a\u0001_!*qbXA\u0007I\u0006\u0012\u0011qB\u0001G\u001fZ,'O]5eK\u0002\nG\r\u001a\u0011u_\u0002\u0002(/\u001a<f]R\u00043&\u0010\u0011b]\u0012\u0004\u0013\r\u001a3!MJ|W\u000eI3yQ&\u0014\u0017\u000e^5oO\u0002\"\u0017N\u001a4fe\u0016tG\u000f\t2fQ\u00064\u0018n\u001c:/\u0003%!S.\u001b8vg\u0012*\u0017\u000f\u0006\u0003\u0002\b\u0005U\u0001\"B?\u0011\u0001\u0004y\u0003&\u0002\t`\u0003\u001b!\u0017a\u0002\u0013cCJ$S-\u001d\u000b\u0005\u0003\u000f\ti\u0002\u0003\u0004\u0002 E\u0001\r\u0001P\u0001\u0006_RDWM]\u0001\bI\u0005l\u0007\u000fJ3r)\u0011\t9!!\n\t\r\u0005}!\u00031\u0001=\u0003\u0019!S\u000f\u001d\u0013fcR!\u0011qAA\u0016\u0011\u0019\tyb\u0005a\u0001y\u0005iA%Y7qIQLG\u000eZ3%KF$B!a\u0002\u00022!1\u0011q\u0004\u000bA\u0002q\nQa\u00197fCJ$\u0012!T\u0001\fi>LU.\\;uC\ndW-\u0006\u0002\u0002<A!\u0011QHA\"\u001b\t\tyDC\u0002\u0002B\u0015\n\u0011\"[7nkR\f'\r\\3\n\u0007\t\ny\u0004K\u0004\u0017\u0003\u000f\ni%!\u0015\u0011\u0007A\nI%C\u0002\u0002L\u001d\u0012!\u0002Z3qe\u0016\u001c\u0017\r^3eC\t\ty%AAp\u0013\u001a\u0004C\u000f[5tA\tKGoU3uA\r|g\u000e^1j]N\u0004\u0013\r\t<bYV,\u0007\u0005\u001e5bi\u0002J7\u000fI\u00193q\u0001z'\u000fI4sK\u0006$XM\u001d\u0017!i\",\u0007E]3tk2$\be\u001c4!i\"L7\u000fI7fi\"|G\rI5tA\u0005t\u0007eJ5n[V$\u0018M\u00197fO\u0001\u0012\u0015\u000e^*fi\u0002\"\b.\u0019;!g\"\f'/Z:!gR\fG/\u001a\u0011xSRD\u0007\u0005\u001e5jg\u0002jW\u000f^1cY\u0016\u0004#)\u001b;TKRt\u0003\u0005\u00165vg2\u0002\u0013N\u001a\u0011uQ\u0016\u0004S.\u001e;bE2,\u0007EQ5u'\u0016$\b%[:![>$\u0017NZ5fI2\u0002\u0013\u000e\u001e\u0011xS2d\u0007E^5pY\u0006$X\r\t;iK\u0002JW.\\;uC\nLG.\u001b;zA=4\u0007\u0005\u001e5fAI,7/\u001e7u]\u0005\u0012\u00111K\u0001\u0007e9\n$G\f\u0019\u0002\u000b\rdwN\\3)\u000f\u0001\tI&a\u0018\u0002bA\u0019\u0001'a\u0017\n\u0007\u0005usE\u0001\tTKJL\u0017\r\u001c,feNLwN\\+J\t\u0006)a/\u00197vKzAQO/\tl\\\u0011[27\u0001\u0004CSR\u001cV\r\u001e\t\u0003Ye\u0019b!GA5\u0003_\u0002\u0005c\u0001\u0019\u0002l%\u0019\u0011QN\u0014\u0003\r\u0005s\u0017PU3g!\u0015\t\t(a\u001e=\u001b\t\t\u0019HC\u0002\u0002v\u0015\nqaZ3oKJL7-\u0003\u0003\u0002z\u0005M$!\u0004\"jiN+GOR1di>\u0014\u0018\u0010\u0006\u0002\u0002f\u0005Qa.Z<Ck&dG-\u001a:\u0016\u0005\u0005\u0005\u0005#\u0002\u0017\u0002\u0004>b\u0014bAACG\t9!)^5mI\u0016\u0014\u0018\u0001D2b]\n+\u0018\u000e\u001c3Ge>lWCAAF!\u001d\t\t(!$=_qJA!a$\u0002t\ta1)\u00198Ck&dGM\u0012:p[\u0006i1-\u00198Ck&dGM\u0012:p[\u0002\n1B\u001a:p[\nKG/T1tWR\u0019A(a&\t\u000b\r{\u0002\u0019A#\u0015\u0007q\nY\nC\u0003DA\u0001\u0007Q)A\u0006sK\u0006$'+Z:pYZ,GCAAQ!\u0011\t\u0019+!,\u000e\u0005\u0005\u0015&\u0002BAT\u0003S\u000bA\u0001\\1oO*\u0011\u00111V\u0001\u0005U\u00064\u0018-\u0003\u0003\u00020\u0006\u0015&AB(cU\u0016\u001cG\u000f")
public class BitSet
extends AbstractSet<Object>
implements scala.collection.mutable.SortedSet<Object>,
scala.collection.BitSet,
Serializable {
    public static final long serialVersionUID = 8483111450368547763L;
    private long[] elems;

    public static BitSet fromBitMask(long[] lArray) {
        return BitSet$.MODULE$.fromBitMask(lArray);
    }

    public static CanBuildFrom<BitSet, Object, BitSet> canBuildFrom() {
        return BitSet$.MODULE$.canBuildFrom();
    }

    public static CanBuildFrom<BitSet, Object, BitSet> bitsetCanBuildFrom() {
        return BitSet$.MODULE$.bitsetCanBuildFrom();
    }

    @Override
    public long[] toBitMask() {
        return BitSetLike.toBitMask$(this);
    }

    @Override
    public int size() {
        return BitSetLike.size$(this);
    }

    @Override
    public boolean isEmpty() {
        return BitSetLike.isEmpty$(this);
    }

    @Override
    public Ordering<Object> ordering() {
        return BitSetLike.ordering$(this);
    }

    @Override
    public BitSetLike rangeImpl(Option from, Option until) {
        return BitSetLike.rangeImpl$(this, from, until);
    }

    @Override
    public Iterator<Object> iterator() {
        return BitSetLike.iterator$(this);
    }

    @Override
    public AbstractIterator<Object> keysIteratorFrom(int start) {
        return BitSetLike.keysIteratorFrom$(this, start);
    }

    @Override
    public <U> void foreach(Function1<Object, U> f) {
        BitSetLike.foreach$(this, f);
    }

    @Override
    public BitSetLike $bar(scala.collection.BitSet other) {
        return BitSetLike.$bar$(this, other);
    }

    @Override
    public BitSetLike $amp(scala.collection.BitSet other) {
        return BitSetLike.$amp$(this, other);
    }

    @Override
    public BitSetLike $amp$tilde(scala.collection.BitSet other) {
        return BitSetLike.$amp$tilde$(this, other);
    }

    @Override
    public BitSetLike $up(scala.collection.BitSet other) {
        return BitSetLike.$up$(this, other);
    }

    @Override
    public boolean contains(int elem) {
        return BitSetLike.contains$(this, elem);
    }

    @Override
    public boolean subsetOf(scala.collection.BitSet other) {
        return BitSetLike.subsetOf$(this, other);
    }

    @Override
    public int head() {
        return BitSetLike.head$(this);
    }

    @Override
    public int last() {
        return BitSetLike.last$(this);
    }

    @Override
    public StringBuilder addString(StringBuilder sb, String start, String sep, String end) {
        return BitSetLike.addString$(this, sb, start, sep, end);
    }

    @Override
    public String stringPrefix() {
        return BitSetLike.stringPrefix$(this);
    }

    @Override
    public /* synthetic */ boolean scala$collection$SortedSetLike$$super$subsetOf(GenSet that) {
        return GenSetLike.subsetOf$(this, that);
    }

    @Override
    public SortedSet keySet() {
        return SortedSetLike.keySet$(this);
    }

    @Override
    public Object firstKey() {
        return SortedSetLike.firstKey$(this);
    }

    @Override
    public Object lastKey() {
        return SortedSetLike.lastKey$(this);
    }

    @Override
    public SortedSet from(Object from) {
        return SortedSetLike.from$(this, from);
    }

    @Override
    public SortedSet until(Object until) {
        return SortedSetLike.until$(this, until);
    }

    @Override
    public SortedSet range(Object from, Object until) {
        return SortedSetLike.range$(this, from, until);
    }

    @Override
    public boolean subsetOf(GenSet<Object> that) {
        return SortedSetLike.subsetOf$(this, that);
    }

    @Override
    public Iterator iteratorFrom(Object start) {
        return SortedSetLike.iteratorFrom$(this, start);
    }

    @Override
    public int compare(Object k0, Object k1) {
        return Sorted.compare$(this, k0, k1);
    }

    @Override
    public Sorted to(Object to) {
        return Sorted.to$(this, to);
    }

    @Override
    public boolean hasAll(Iterator<Object> j) {
        return Sorted.hasAll$(this, j);
    }

    public final long[] elems() {
        return this.elems;
    }

    public final void elems_$eq(long[] x$1) {
        this.elems = x$1;
    }

    @Override
    public BitSet empty() {
        return BitSet$.MODULE$.empty();
    }

    @Override
    public int nwords() {
        return this.elems().length;
    }

    @Override
    public long word(int idx) {
        if (idx < this.nwords()) {
            return this.elems()[idx];
        }
        return 0L;
    }

    public final void updateWord(int idx, long w) {
        this.ensureCapacity(idx);
        this.elems()[idx] = w;
    }

    public final void ensureCapacity(int idx) {
        Predef$.MODULE$.require(idx < 0x2000000);
        if (idx >= this.nwords()) {
            int newlen = this.nwords();
            while (idx >= newlen) {
                int n = newlen * 2;
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                newlen = RichInt$.MODULE$.min$extension(n, 0x2000000);
            }
            long[] elems1 = new long[newlen];
            Array$.MODULE$.copy(this.elems(), 0, elems1, 0, this.nwords());
            this.elems_$eq(elems1);
        }
    }

    @Override
    public BitSet fromBitMaskNoCopy(long[] words) {
        if (words.length == 0) {
            return this.empty();
        }
        return new BitSet(words);
    }

    @Override
    public boolean add(int elem) {
        Predef$.MODULE$.require(elem >= 0);
        if (this.contains(elem)) {
            return false;
        }
        int idx = elem >> 6;
        this.updateWord(idx, this.word(idx) | 1L << elem);
        return true;
    }

    @Override
    public boolean remove(int elem) {
        Predef$.MODULE$.require(elem >= 0);
        if (this.contains(elem)) {
            int idx = elem >> 6;
            this.updateWord(idx, this.word(idx) & (1L << elem ^ 0xFFFFFFFFFFFFFFFFL));
            return true;
        }
        return false;
    }

    public BitSet $plus$eq(int elem) {
        this.add(elem);
        return this;
    }

    public BitSet $minus$eq(int elem) {
        this.remove(elem);
        return this;
    }

    public BitSet $bar$eq(BitSet other) {
        this.ensureCapacity(other.nwords() - 1);
        int n = 0;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        Range range = RichInt$.MODULE$.until$extension0(n, other.nwords());
        if (range == null) {
            throw null;
        }
        Range foreach$mVc$sp_this = range;
        if (!foreach$mVc$sp_this.isEmpty()) {
            int foreach$mVc$sp_i = foreach$mVc$sp_this.start();
            while (true) {
                this.elems()[foreach$mVc$sp_i] = this.elems()[foreach$mVc$sp_i] | other.word(foreach$mVc$sp_i);
                if (foreach$mVc$sp_i == foreach$mVc$sp_this.scala$collection$immutable$Range$$lastElement()) break;
                foreach$mVc$sp_i += foreach$mVc$sp_this.step();
            }
        }
        return this;
    }

    public BitSet $amp$eq(BitSet other) {
        int n = 0;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        Range range = RichInt$.MODULE$.until$extension0(n, this.nwords());
        if (range == null) {
            throw null;
        }
        Range foreach$mVc$sp_this = range;
        if (!foreach$mVc$sp_this.isEmpty()) {
            int foreach$mVc$sp_i = foreach$mVc$sp_this.start();
            while (true) {
                this.elems()[foreach$mVc$sp_i] = this.elems()[foreach$mVc$sp_i] & other.word(foreach$mVc$sp_i);
                if (foreach$mVc$sp_i == foreach$mVc$sp_this.scala$collection$immutable$Range$$lastElement()) break;
                foreach$mVc$sp_i += foreach$mVc$sp_this.step();
            }
        }
        return this;
    }

    public BitSet $up$eq(BitSet other) {
        this.ensureCapacity(other.nwords() - 1);
        int n = 0;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        Range range = RichInt$.MODULE$.until$extension0(n, other.nwords());
        if (range == null) {
            throw null;
        }
        Range foreach$mVc$sp_this = range;
        if (!foreach$mVc$sp_this.isEmpty()) {
            int foreach$mVc$sp_i = foreach$mVc$sp_this.start();
            while (true) {
                this.elems()[foreach$mVc$sp_i] = this.elems()[foreach$mVc$sp_i] ^ other.word(foreach$mVc$sp_i);
                if (foreach$mVc$sp_i == foreach$mVc$sp_this.scala$collection$immutable$Range$$lastElement()) break;
                foreach$mVc$sp_i += foreach$mVc$sp_this.step();
            }
        }
        return this;
    }

    public BitSet $amp$tilde$eq(BitSet other) {
        this.ensureCapacity(other.nwords() - 1);
        int n = 0;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        Range range = RichInt$.MODULE$.until$extension0(n, other.nwords());
        if (range == null) {
            throw null;
        }
        Range foreach$mVc$sp_this = range;
        if (!foreach$mVc$sp_this.isEmpty()) {
            int foreach$mVc$sp_i = foreach$mVc$sp_this.start();
            while (true) {
                this.elems()[foreach$mVc$sp_i] = this.elems()[foreach$mVc$sp_i] & (other.word(foreach$mVc$sp_i) ^ 0xFFFFFFFFFFFFFFFFL);
                if (foreach$mVc$sp_i == foreach$mVc$sp_this.scala$collection$immutable$Range$$lastElement()) break;
                foreach$mVc$sp_i += foreach$mVc$sp_this.step();
            }
        }
        return this;
    }

    @Override
    public void clear() {
        this.elems_$eq(new long[this.elems().length]);
    }

    public scala.collection.immutable.BitSet toImmutable() {
        return scala.collection.immutable.BitSet$.MODULE$.fromBitMaskNoCopy(this.elems());
    }

    @Override
    public BitSet clone() {
        long[] elems1 = new long[this.elems().length];
        Array$.MODULE$.copy(this.elems(), 0, elems1, 0, this.elems().length);
        return new BitSet(elems1);
    }

    public BitSet(long[] elems) {
        this.elems = elems;
        Sorted.$init$(this);
        SortedSetLike.$init$(this);
        SortedSet.$init$(this);
        scala.collection.mutable.SortedSet.$init$(this);
        BitSetLike.$init$(this);
        scala.collection.BitSet.$init$(this);
    }

    public BitSet(int initSize) {
        int n = initSize + 63 >> 6;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        this(new long[RichInt$.MODULE$.max$extension(n, 1)]);
    }

    public BitSet() {
        this(0);
    }
}

