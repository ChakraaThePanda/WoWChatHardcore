/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import java.util.NoSuchElementException;
import scala.Function1;
import scala.Option;
import scala.Predef$;
import scala.Serializable;
import scala.collection.AbstractIterator;
import scala.collection.AbstractSet;
import scala.collection.BitSetLike;
import scala.collection.BitSetLike$;
import scala.collection.GenSet;
import scala.collection.GenSetLike;
import scala.collection.Iterator;
import scala.collection.SortedSetLike;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.Sorted;
import scala.collection.immutable.BitSet$;
import scala.collection.immutable.Iterable;
import scala.collection.immutable.Set;
import scala.collection.immutable.SortedSet;
import scala.collection.immutable.Traversable;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.immutable.ParSet;
import scala.math.Ordering;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005]e!\u0002\u00180\u0003\u00031\u0004\"\u0002'\u0001\t\u0003i\u0005\"\u0002(\u0001\t\u0003z\u0005\"\u0002)\u0001\t#\t\u0006\"\u0002.\u0001\r#Y\u0006\"\u00021\u0001\t\u0003\t\u0007\"\u00023\u0001\t\u0003)w!B70\u0011\u0003qg!\u0002\u00180\u0011\u0003y\u0007\"\u0002'\t\t\u0003I\bb\u0002(\t\u0005\u0004%\ta\u0014\u0005\u0007u\"\u0001\u000b\u0011\u0002%\t\u000bmDA\u0011\u0002?\t\u000f\u0005\r\u0001\u0002\"\u0001\u0002\u0006!I\u00111\u0003\u0005C\u0002\u0013\r\u0011Q\u0003\u0005\t\u0003;A\u0001\u0015!\u0003\u0002\u0018!9\u0011q\u0004\u0005\u0005\u0002\u0005\u0005\u0002B\u0002)\t\t\u0003\t)C\u0002\u0004\u0002*!\u0001\u00111\u0006\u0005\n'J\u0011)\u0019!C\u0001\u0003[A\u0011\"a\f\u0013\u0005\u0003\u0005\u000b\u0011B,\t\r1\u0013B\u0011AA\u0019\u0011\u001d\tID\u0005C\t\u0003wAq!!\u0010\u0013\t#\ty\u0004\u0003\u0004[%\u0011E\u00111\t\u0005\b\u0003\u0013\u0012B\u0011IA\u001e\u0011\u0019\tYE\u0005C!\u001f\u001a1\u0011\u0011\u000b\u0005\u0001\u0003'B!\"!\u0016\u001c\u0005\u000b\u0007I\u0011AA\u0017\u0011%\t9f\u0007B\u0001B\u0003%q\u000bC\u0005\u0002Zm\u0011\t\u0011)A\u0005/\"1Aj\u0007C\u0001\u00037Bq!!\u000f\u001c\t#\tY\u0004C\u0004\u0002>m!\t\"a\u0019\t\ri[B\u0011CA4\u0011\u001d\tIe\u0007C!\u0003wAa!a\u0013\u001c\t\u0003zeABA7\u0011\u0001\ty\u0007C\u0005TK\t\u0015\r\u0011\"\u0001\u0002r!I\u0011qF\u0013\u0003\u0002\u0003\u0006I\u0001\u0016\u0005\u0007\u0019\u0016\"\t!a\u001d\t\u000f\u0005eR\u0005\"\u0005\u0002<!9\u0011QH\u0013\u0005\u0012\u0005e\u0004B\u0002.&\t#\ti\b\u0003\u0004\u0002L\u0015\"\te\u0014\u0005\n\u0003\u0007C\u0011\u0011!C\u0005\u0003\u000b\u0013aAQ5u'\u0016$(B\u0001\u00192\u0003%IW.\\;uC\ndWM\u0003\u00023g\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003Q\nQa]2bY\u0006\u001c\u0001a\u0005\u0004\u0001o}\u001aU)\u0013\t\u0004qeZT\"A\u0019\n\u0005i\n$aC!cgR\u0014\u0018m\u0019;TKR\u0004\"\u0001P\u001f\u000e\u0003MJ!AP\u001a\u0003\u0007%sG\u000fE\u0002A\u0003nj\u0011aL\u0005\u0003\u0005>\u0012\u0011bU8si\u0016$7+\u001a;\u0011\u0005a\"\u0015B\u0001\u00182!\rAd\tS\u0005\u0003\u000fF\u0012!BQ5u'\u0016$H*[6f!\t\u0001\u0005\u0001\u0005\u0002=\u0015&\u00111j\r\u0002\r'\u0016\u0014\u0018.\u00197ju\u0006\u0014G.Z\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003!\u000bQ!Z7qif,\u0012\u0001S\u0001\u0012MJ|WNQ5u\u001b\u0006\u001c8NT8D_BLHC\u0001%S\u0011\u0015\u00196\u00011\u0001U\u0003\u0015)G.Z7t!\raTkV\u0005\u0003-N\u0012Q!\u0011:sCf\u0004\"\u0001\u0010-\n\u0005e\u001b$\u0001\u0002'p]\u001e\f!\"\u001e9eCR,wk\u001c:e)\rAEL\u0018\u0005\u0006;\u0012\u0001\raO\u0001\u0004S\u0012D\b\"B0\u0005\u0001\u00049\u0016!A<\u0002\u000b\u0011\u0002H.^:\u0015\u0005!\u0013\u0007\"B2\u0006\u0001\u0004Y\u0014\u0001B3mK6\fa\u0001J7j]V\u001cHC\u0001%g\u0011\u0015\u0019g\u00011\u0001<Q\u0011\u0001\u0001n\u001b7\u0011\u0005qJ\u0017B\u000164\u0005A\u0019VM]5bYZ+'o]5p]VKE)A\u0003wC2,XM\b\u0005\u00179f\u0018TZ;dK\u0004\u0019\u0011\u0015\u000e^*fiB\u0011\u0001\tC\n\u0005\u0011A\u001c\u0018\n\u0005\u0002=c&\u0011!o\r\u0002\u0007\u0003:L(+\u001a4\u0011\u0007Q<\b*D\u0001v\u0015\t1\u0018'A\u0004hK:,'/[2\n\u0005a,(!\u0004\"jiN+GOR1di>\u0014\u0018\u0010F\u0001o\u0003\u0019)W\u000e\u001d;zA\u0005Y1M]3bi\u0016\u001cV.\u00197m)\rAUp \u0005\u0006}2\u0001\raV\u0001\u0002C\"1\u0011\u0011\u0001\u0007A\u0002]\u000b\u0011AY\u0001\u000b]\u0016<()^5mI\u0016\u0014XCAA\u0004!\u0019\tI!a\u0004<\u00116\u0011\u00111\u0002\u0006\u0004\u0003\u001b\t\u0014aB7vi\u0006\u0014G.Z\u0005\u0005\u0003#\tYAA\u0004Ck&dG-\u001a:\u0002\u0019\r\fgNQ;jY\u00124%o\\7\u0016\u0005\u0005]\u0001C\u0002;\u0002\u001a![\u0004*C\u0002\u0002\u001cU\u0014AbQ1o\u0005VLG\u000e\u001a$s_6\fQbY1o\u0005VLG\u000e\u001a$s_6\u0004\u0013a\u00034s_6\u0014\u0015\u000e^'bg.$2\u0001SA\u0012\u0011\u0015\u0019\u0006\u00031\u0001U)\rA\u0015q\u0005\u0005\u0006'F\u0001\r\u0001\u0016\u0002\b\u0005&$8+\u001a;2'\t\u0011\u0002*F\u0001X\u0003\u0019)G.Z7tAQ!\u00111GA\u001c!\r\t)DE\u0007\u0002\u0011!)1+\u0006a\u0001/\u00061an^8sIN,\u0012aO\u0001\u0005o>\u0014H\rF\u0002X\u0003\u0003BQ!X\fA\u0002m\"R\u0001SA#\u0003\u000fBQ!\u0018\rA\u0002mBQa\u0018\rA\u0002]\u000bA\u0001[3bI\u0006!A/Y5mQ\u0015\u0011\u0002n[A(=!yRl!bG\t>%\"a\u0002\"jiN+GOM\n\u00037!\u000ba!\u001a7f[N\u0004\u0014aB3mK6\u001c\b\u0007I\u0001\u0007K2,Wn]\u0019\u0015\r\u0005u\u0013qLA1!\r\t)d\u0007\u0005\u0007\u0003+z\u0002\u0019A,\t\r\u0005es\u00041\u0001X)\r9\u0016Q\r\u0005\u0006;\u0006\u0002\ra\u000f\u000b\u0006\u0011\u0006%\u00141\u000e\u0005\u0006;\n\u0002\ra\u000f\u0005\u0006?\n\u0002\ra\u0016\u0002\b\u0005&$8+\u001a;O'\t)\u0003*F\u0001U)\u0011\t)(a\u001e\u0011\u0007\u0005UR\u0005C\u0003TQ\u0001\u0007A\u000bF\u0002X\u0003wBQ!\u0018\u0016A\u0002m\"R\u0001SA@\u0003\u0003CQ!X\u0016A\u0002mBQaX\u0016A\u0002]\u000b1B]3bIJ+7o\u001c7wKR\u0011\u0011q\u0011\t\u0005\u0003\u0013\u000b\u0019*\u0004\u0002\u0002\f*!\u0011QRAH\u0003\u0011a\u0017M\\4\u000b\u0005\u0005E\u0015\u0001\u00026bm\u0006LA!!&\u0002\f\n1qJ\u00196fGR\u0004")
public abstract class BitSet
extends AbstractSet<Object>
implements SortedSet<Object>,
scala.collection.BitSet,
Serializable {
    public static final long serialVersionUID = 1611436763290191562L;

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
    public scala.collection.mutable.StringBuilder addString(scala.collection.mutable.StringBuilder sb, String start, String sep, String end) {
        return BitSetLike.addString$(this, sb, start, sep, end);
    }

    @Override
    public String stringPrefix() {
        return BitSetLike.stringPrefix$(this);
    }

    @Override
    public /* synthetic */ boolean scala$collection$immutable$SortedSet$$super$equals(Object that) {
        return GenSetLike.equals$(this, that);
    }

    @Override
    public boolean equals(Object that) {
        return SortedSet.equals$(this, that);
    }

    @Override
    public /* synthetic */ boolean scala$collection$SortedSetLike$$super$subsetOf(GenSet that) {
        return GenSetLike.subsetOf$(this, that);
    }

    @Override
    public scala.collection.SortedSet keySet() {
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
    public scala.collection.SortedSet from(Object from) {
        return SortedSetLike.from$(this, from);
    }

    @Override
    public scala.collection.SortedSet until(Object until) {
        return SortedSetLike.until$(this, until);
    }

    @Override
    public scala.collection.SortedSet range(Object from, Object until) {
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

    @Override
    public GenericCompanion<Set> companion() {
        return Set.companion$(this);
    }

    @Override
    public <B> Set<B> toSet() {
        return Set.toSet$(this);
    }

    @Override
    public Set<Object> seq() {
        return Set.seq$(this);
    }

    @Override
    public Combiner<Object, ParSet<Object>> parCombiner() {
        return Set.parCombiner$(this);
    }

    @Override
    public BitSet empty() {
        return BitSet$.MODULE$.empty();
    }

    @Override
    public BitSet fromBitMaskNoCopy(long[] elems) {
        return BitSet$.MODULE$.fromBitMaskNoCopy(elems);
    }

    public abstract BitSet updateWord(int var1, long var2);

    /*
     * WARNING - void declaration
     */
    @Override
    public BitSet $plus(int elem) {
        void require_requirement;
        boolean bl;
        boolean bl2 = bl = elem >= 0;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        if (require_requirement == false) {
            throw new IllegalArgumentException(new StringBuilder(20).append("requirement failed: ").append((Object)BitSet.$anonfun$$plus$1()).toString());
        }
        if (this.contains(elem)) {
            return this;
        }
        int idx = elem >> 6;
        return this.updateWord(idx, this.word(idx) | 1L << elem);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public BitSet $minus(int elem) {
        void require_requirement;
        boolean bl;
        boolean bl2 = bl = elem >= 0;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        if (require_requirement == false) {
            throw new IllegalArgumentException(new StringBuilder(20).append("requirement failed: ").append((Object)BitSet.$anonfun$$minus$1()).toString());
        }
        if (this.contains(elem)) {
            int idx = elem >> 6;
            return this.updateWord(idx, this.word(idx) & (1L << elem ^ 0xFFFFFFFFFFFFFFFFL));
        }
        return this;
    }

    public static final /* synthetic */ String $anonfun$$plus$1() {
        return "bitset element must be >= 0";
    }

    public static final /* synthetic */ String $anonfun$$minus$1() {
        return "bitset element must be >= 0";
    }

    public BitSet() {
        Traversable.$init$(this);
        Iterable.$init$(this);
        Set.$init$(this);
        Sorted.$init$(this);
        SortedSetLike.$init$(this);
        scala.collection.SortedSet.$init$(this);
        SortedSet.$init$(this);
        BitSetLike.$init$(this);
        scala.collection.BitSet.$init$(this);
    }

    public static class BitSet1
    extends BitSet {
        public static final long serialVersionUID = 2260107458435649300L;
        private final long elems;

        public long elems() {
            return this.elems;
        }

        @Override
        public int nwords() {
            return 1;
        }

        @Override
        public long word(int idx) {
            if (idx == 0) {
                return this.elems();
            }
            return 0L;
        }

        @Override
        public BitSet updateWord(int idx, long w) {
            if (idx == 0) {
                return new BitSet1(w);
            }
            if (idx == 1) {
                return BitSet$.MODULE$.scala$collection$immutable$BitSet$$createSmall(this.elems(), w);
            }
            return this.fromBitMaskNoCopy(BitSetLike$.MODULE$.updateArray(new long[]{this.elems()}, idx, w));
        }

        @Override
        public int head() {
            if (this.elems() == 0L) {
                throw new NoSuchElementException("Empty BitSet");
            }
            return Long.numberOfTrailingZeros(this.elems());
        }

        @Override
        public BitSet tail() {
            if (this.elems() == 0L) {
                throw new NoSuchElementException("Empty BitSet");
            }
            return new BitSet1(this.elems() - Long.lowestOneBit(this.elems()));
        }

        public BitSet1(long elems) {
            this.elems = elems;
        }
    }

    public static class BitSet2
    extends BitSet {
        private final long elems0;
        private final long elems1;

        public long elems0() {
            return this.elems0;
        }

        @Override
        public int nwords() {
            return 2;
        }

        @Override
        public long word(int idx) {
            if (idx == 0) {
                return this.elems0();
            }
            if (idx == 1) {
                return this.elems1;
            }
            return 0L;
        }

        @Override
        public BitSet updateWord(int idx, long w) {
            if (idx == 0) {
                return new BitSet2(w, this.elems1);
            }
            if (idx == 1) {
                return BitSet$.MODULE$.scala$collection$immutable$BitSet$$createSmall(this.elems0(), w);
            }
            return this.fromBitMaskNoCopy(BitSetLike$.MODULE$.updateArray(new long[]{this.elems0(), this.elems1}, idx, w));
        }

        @Override
        public int head() {
            if (this.elems0() == 0L) {
                if (this.elems1 == 0L) {
                    throw new NoSuchElementException("Empty BitSet");
                }
                return 64 + Long.numberOfTrailingZeros(this.elems1);
            }
            return Long.numberOfTrailingZeros(this.elems0());
        }

        @Override
        public BitSet tail() {
            if (this.elems0() == 0L) {
                if (this.elems1 == 0L) {
                    throw new NoSuchElementException("Empty BitSet");
                }
                return BitSet$.MODULE$.scala$collection$immutable$BitSet$$createSmall(this.elems0(), this.elems1 - Long.lowestOneBit(this.elems1));
            }
            return new BitSet2(this.elems0() - Long.lowestOneBit(this.elems0()), this.elems1);
        }

        public BitSet2(long elems0, long elems1) {
            this.elems0 = elems0;
            this.elems1 = elems1;
        }
    }

    public static class BitSetN
    extends BitSet {
        private final long[] elems;

        public long[] elems() {
            return this.elems;
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

        @Override
        public BitSet updateWord(int idx, long w) {
            return this.fromBitMaskNoCopy(BitSetLike$.MODULE$.updateArray(this.elems(), idx, w));
        }

        @Override
        public BitSet tail() {
            int n = this.nwords();
            for (int i = 0; i < n; ++i) {
                long wi = this.word(i);
                if (wi == 0L) continue;
                return this.fromBitMaskNoCopy(BitSetLike$.MODULE$.updateArray(this.elems(), i, wi - Long.lowestOneBit(wi)));
            }
            throw new NoSuchElementException("Empty BitSet");
        }

        public BitSetN(long[] elems) {
            this.elems = elems;
        }
    }
}

