/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import java.util.NoSuchElementException;
import scala.Function1;
import scala.Option;
import scala.Predef$;
import scala.Serializable;
import scala.collection.AbstractIterator;
import scala.collection.BitSet;
import scala.collection.Iterator;
import scala.collection.Iterator$;
import scala.collection.SortedSet;
import scala.collection.SortedSetLike;
import scala.collection.immutable.Range;
import scala.collection.mutable.StringBuilder;
import scala.math.Ordering;
import scala.math.Ordering$Int$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.RichInt$;
import scala.runtime.java8.JFunction1$mcZI$sp;

@ScalaSignature(bytes="\u0006\u0001\u00055ga\u0002\u0012$!\u0003\r\t\u0001\u000b\u0005\u0006\t\u0002!\t!\u0012\u0005\u0006\u0013\u00021\tA\u0013\u0005\u0006\u0017\u00021\t\u0002\u0014\u0005\u0006\u001b\u00021\tB\u0014\u0005\u0006)\u00021\t\"\u0016\u0005\u00067\u0002!\t\u0001\u0018\u0005\u0006;\u0002!\t\u0005\u0014\u0005\u0006=\u0002!\te\u0018\u0005\u0006G\u0002!\u0019\u0001\u001a\u0005\u0006Y\u0002!\t!\u001c\u0005\u0006k\u0002!\tA\u001e\u0005\u0006u\u0002!\te\u001f\u0005\b\u0003\u0007\u0001A\u0011IA\u0003\u0011\u001d\t\t\u0003\u0001C\u0001\u0003GAq!a\f\u0001\t\u0003\t\t\u0004C\u0004\u00026\u0001!\t!a\u000e\t\u000f\u0005m\u0002\u0001\"\u0001\u0002>!9\u0011\u0011\t\u0001\u0005\u0002\u0005\r\u0003bBA%\u0001\u0011\u0005\u00111\n\u0005\u0007\u0003\u001f\u0002A\u0011\t'\t\r\u0005E\u0003\u0001\"\u0011M\u0011\u001d\t\u0019\u0006\u0001C!\u0003+Bq!a\"\u0001\t\u0003\nIiB\u0004\u0002\u001a\u000eB\t!a'\u0007\r\t\u001a\u0003\u0012AAO\u0011\u001d\ty*\u0007C\u0001\u0003CC!\"a)\u001a\u0005\u0004%)aIAS\u0011!\tY+\u0007Q\u0001\u000e\u0005\u001d\u0006\"CAW3\t\u0007IQBAX\u0011!\t),\u0007Q\u0001\u000e\u0005E\u0006BCA\\3\t\u0007IQA\u0012\u0002:\"A\u0011qX\r!\u0002\u001b\tY\f\u0003\u0005\u0002Bf!\taIAb\u0005)\u0011\u0015\u000e^*fi2K7.\u001a\u0006\u0003I\u0015\n!bY8mY\u0016\u001cG/[8o\u0015\u00051\u0013!B:dC2\f7\u0001A\u000b\u0003S]\u001a2\u0001\u0001\u0016/!\tYC&D\u0001&\u0013\tiSE\u0001\u0004B]f\u0014VM\u001a\t\u0005_A\u0012T'D\u0001$\u0013\t\t4EA\u0007T_J$X\rZ*fi2K7.\u001a\t\u0003WMJ!\u0001N\u0013\u0003\u0007%sG\u000f\u0005\u00027o1\u0001AA\u0002\u001d\u0001\t\u000b\u0007\u0011H\u0001\u0003UQ&\u001c\u0018C\u0001\u001e>!\tY3(\u0003\u0002=K\t9aj\u001c;iS:<'c\u0001 A\u0003\u001a!q\b\u0001\u0001>\u00051a$/\u001a4j]\u0016lWM\u001c;?!\ry\u0003!\u000e\t\u0004_\t\u0013\u0014BA\"$\u0005%\u0019vN\u001d;fIN+G/\u0001\u0004%S:LG\u000f\n\u000b\u0002\rB\u00111fR\u0005\u0003\u0011\u0016\u0012A!\u00168ji\u0006)Q-\u001c9usV\tQ'\u0001\u0004oo>\u0014Hm]\u000b\u0002e\u0005!qo\u001c:e)\ty%\u000b\u0005\u0002,!&\u0011\u0011+\n\u0002\u0005\u0019>tw\rC\u0003T\t\u0001\u0007!'A\u0002jIb\f\u0011C\u001a:p[\nKG/T1tW:{7i\u001c9z)\t)d\u000bC\u0003X\u000b\u0001\u0007\u0001,A\u0003fY\u0016l7\u000fE\u0002,3>K!AW\u0013\u0003\u000b\u0005\u0013(/Y=\u0002\u0013Q|')\u001b;NCN\\W#\u0001-\u0002\tML'0Z\u0001\bSN,U\u000e\u001d;z+\u0005\u0001\u0007CA\u0016b\u0013\t\u0011WEA\u0004C_>dW-\u00198\u0002\u0011=\u0014H-\u001a:j]\u001e,\u0012!\u001a\t\u0004M&\u0014dBA\u0016h\u0013\tAW%A\u0004qC\u000e\\\u0017mZ3\n\u0005)\\'\u0001C(sI\u0016\u0014\u0018N\\4\u000b\u0005!,\u0013!\u0003:b]\u001e,\u0017*\u001c9m)\r)dn\u001d\u0005\u0006_*\u0001\r\u0001]\u0001\u0005MJ|W\u000eE\u0002,cJJ!A]\u0013\u0003\r=\u0003H/[8o\u0011\u0015!(\u00021\u0001q\u0003\u0015)h\u000e^5m\u0003!IG/\u001a:bi>\u0014X#A<\u0011\u0007=B('\u0003\u0002zG\tA\u0011\n^3sCR|'/\u0001\tlKf\u001c\u0018\n^3sCR|'O\u0012:p[R\u0011Ap \t\u0004_u\u0014\u0014B\u0001@$\u0005A\t%m\u001d;sC\u000e$\u0018\n^3sCR|'\u000f\u0003\u0004\u0002\u00021\u0001\rAM\u0001\u0006gR\f'\u000f^\u0001\bM>\u0014X-Y2i+\u0011\t9!!\u0006\u0015\u0007\u0019\u000bI\u0001C\u0004\u0002\f5\u0001\r!!\u0004\u0002\u0003\u0019\u0004baKA\be\u0005M\u0011bAA\tK\tIa)\u001e8di&|g.\r\t\u0004m\u0005UAaBA\f\u001b\t\u0007\u0011\u0011\u0004\u0002\u0002+F\u0019!(a\u0007\u0011\u0007-\ni\"C\u0002\u0002 \u0015\u00121!\u00118z\u0003\u0011!#-\u0019:\u0015\u0007U\n)\u0003C\u0004\u0002(9\u0001\r!!\u000b\u0002\u000b=$\b.\u001a:\u0011\u0007=\nY#C\u0002\u0002.\r\u0012aAQ5u'\u0016$\u0018\u0001\u0002\u0013b[B$2!NA\u001a\u0011\u001d\t9c\u0004a\u0001\u0003S\t!\u0002J1na\u0012\"\u0018\u000e\u001c3f)\r)\u0014\u0011\b\u0005\b\u0003O\u0001\u0002\u0019AA\u0015\u0003\r!S\u000f\u001d\u000b\u0004k\u0005}\u0002bBA\u0014#\u0001\u0007\u0011\u0011F\u0001\tG>tG/Y5ogR\u0019\u0001-!\u0012\t\r\u0005\u001d#\u00031\u00013\u0003\u0011)G.Z7\u0002\u0011M,(m]3u\u001f\u001a$2\u0001YA'\u0011\u001d\t9c\u0005a\u0001\u0003S\tA\u0001[3bI\u0006!A.Y:u\u0003%\tG\rZ*ue&tw\r\u0006\u0006\u0002X\u0005\r\u0014qMA@\u0003\u0007\u0003B!!\u0017\u0002`5\u0011\u00111\f\u0006\u0004\u0003;\u001a\u0013aB7vi\u0006\u0014G.Z\u0005\u0005\u0003C\nYFA\u0007TiJLgn\u001a\"vS2$WM\u001d\u0005\b\u0003K2\u0002\u0019AA,\u0003\t\u0019(\rC\u0004\u0002\u0002Y\u0001\r!!\u001b\u0011\t\u0005-\u0014\u0011\u0010\b\u0005\u0003[\n)\bE\u0002\u0002p\u0015j!!!\u001d\u000b\u0007\u0005Mt%\u0001\u0004=e>|GOP\u0005\u0004\u0003o*\u0013A\u0002)sK\u0012,g-\u0003\u0003\u0002|\u0005u$AB*ue&twMC\u0002\u0002x\u0015Bq!!!\u0017\u0001\u0004\tI'A\u0002tKBDq!!\"\u0017\u0001\u0004\tI'A\u0002f]\u0012\fAb\u001d;sS:<\u0007K]3gSb,\"!a#\u0011\t\u00055\u0015qS\u0007\u0003\u0003\u001fSA!!%\u0002\u0014\u0006!A.\u00198h\u0015\t\t)*\u0001\u0003kCZ\f\u0017\u0002BA>\u0003\u001f\u000b!BQ5u'\u0016$H*[6f!\ty\u0013d\u0005\u0002\u001aU\u00051A(\u001b8jiz\"\"!a'\u0002\u000b1{wm\u0016'\u0016\u0005\u0005\u001dvBAAU;\u00051\u0011A\u0002'pO^c\u0005%\u0001\u0006X_J$G*\u001a8hi\",\"!!-\u0010\u0005\u0005MV$\u0001!\u0002\u0017]{'\u000f\u001a'f]\u001e$\b\u000eI\u0001\b\u001b\u0006D8+\u001b>f+\t\tYl\u0004\u0002\u0002>v!!\u0001\u0001\u0001\u0001\u0003!i\u0015\r_*ju\u0016\u0004\u0013aC;qI\u0006$X-\u0011:sCf$r\u0001WAc\u0003\u000f\fI\rC\u0003XC\u0001\u0007\u0001\fC\u0003TC\u0001\u0007!\u0007\u0003\u0004\u0002L\u0006\u0002\raT\u0001\u0002o\u0002")
public interface BitSetLike<This extends BitSetLike<This> & SortedSet<Object>>
extends SortedSetLike<Object, This> {
    @Override
    public This empty();

    public int nwords();

    public long word(int var1);

    public This fromBitMaskNoCopy(long[] var1);

    public static /* synthetic */ long[] toBitMask$(BitSetLike $this) {
        return $this.toBitMask();
    }

    /*
     * WARNING - void declaration
     */
    default public long[] toBitMask() {
        void var1_1;
        long[] a = new long[this.nwords()];
        int i = a.length;
        while (i > 0) {
            a[--i] = this.word(i);
        }
        return var1_1;
    }

    public static /* synthetic */ int size$(BitSetLike $this) {
        return $this.size();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public int size() {
        void var1_1;
        int s = 0;
        int i = this.nwords();
        while (i > 0) {
            s += Long.bitCount(this.word(--i));
        }
        return (int)var1_1;
    }

    public static /* synthetic */ boolean isEmpty$(BitSetLike $this) {
        return $this.isEmpty();
    }

    @Override
    default public boolean isEmpty() {
        int n = 0;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return RichInt$.MODULE$.until$extension0(n, this.nwords()).forall((JFunction1$mcZI$sp & Serializable)i -> this.word(i) == 0L);
    }

    public static /* synthetic */ Ordering ordering$(BitSetLike $this) {
        return $this.ordering();
    }

    @Override
    default public Ordering<Object> ordering() {
        return Ordering$Int$.MODULE$;
    }

    public static /* synthetic */ BitSetLike rangeImpl$(BitSetLike $this, Option from, Option until) {
        return $this.rangeImpl(from, until);
    }

    @Override
    default public This rangeImpl(Option<Object> from, Option<Object> until) {
        long[] a = this.toBitMask();
        int len = a.length;
        if (from.isDefined()) {
            int pos;
            int f = BoxesRunTime.unboxToInt(from.get());
            for (pos = 0; f >= 64 && pos < len; f -= 64, ++pos) {
                a[pos] = 0L;
            }
            if (f > 0 && pos < len) {
                a[pos] = a[pos] & ((1L << f) - 1L ^ 0xFFFFFFFFFFFFFFFFL);
            }
        }
        if (until.isDefined()) {
            int u = BoxesRunTime.unboxToInt(until.get());
            int w = u / 64;
            int b = u % 64;
            for (int clearw = w + 1; clearw < len; ++clearw) {
                a[clearw] = 0L;
            }
            if (w < len) {
                a[w] = a[w] & (1L << b) - 1L;
            }
        }
        return this.fromBitMaskNoCopy(a);
    }

    public static /* synthetic */ Iterator iterator$(BitSetLike $this) {
        return $this.iterator();
    }

    @Override
    default public Iterator<Object> iterator() {
        return this.iteratorFrom(BoxesRunTime.boxToInteger(0));
    }

    public static /* synthetic */ AbstractIterator keysIteratorFrom$(BitSetLike $this, int start) {
        return $this.keysIteratorFrom(start);
    }

    @Override
    default public AbstractIterator<Object> keysIteratorFrom(int start) {
        return new AbstractIterator<Object>(this, start){
            private int current;
            private final int end;
            private final /* synthetic */ BitSetLike $outer;

            private int current() {
                return this.current;
            }

            private void current_$eq(int x$1) {
                this.current = x$1;
            }

            private int end() {
                return this.end;
            }

            public boolean hasNext() {
                while (this.current() != this.end() && !this.$outer.contains(this.current())) {
                    this.current_$eq(this.current() + 1);
                }
                return this.current() != this.end();
            }

            /*
             * WARNING - void declaration
             */
            public int next() {
                if (this.hasNext()) {
                    void var1_1;
                    int r = this.current();
                    this.current_$eq(this.current() + 1);
                    return (int)var1_1;
                }
                return BoxesRunTime.unboxToInt(Iterator$.MODULE$.empty().next());
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.current = start$1;
                this.end = $outer.nwords() * 64;
            }
        };
    }

    public static /* synthetic */ void foreach$(BitSetLike $this, Function1 f) {
        $this.foreach(f);
    }

    @Override
    default public <U> void foreach(Function1<Object, U> f) {
        for (int i = 0; i < this.nwords(); ++i) {
            long w = this.word(i);
            int j = i * 64;
            while (w != 0L) {
                if ((w & 1L) == 1L) {
                    f.apply(BoxesRunTime.boxToInteger(j));
                }
                w >>>= 1;
                ++j;
            }
        }
    }

    public static /* synthetic */ BitSetLike $bar$(BitSetLike $this, BitSet other) {
        return $this.$bar(other);
    }

    default public This $bar(BitSet other) {
        int n = this.nwords();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int len = RichInt$.MODULE$.max$extension(n, other.nwords());
        long[] words = new long[len];
        int n2 = 0;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        Range range = RichInt$.MODULE$.until$extension0(n2, len);
        if (range == null) {
            throw null;
        }
        Range foreach$mVc$sp_this = range;
        if (!foreach$mVc$sp_this.isEmpty()) {
            int foreach$mVc$sp_i = foreach$mVc$sp_this.start();
            while (true) {
                words[foreach$mVc$sp_i] = this.word(foreach$mVc$sp_i) | other.word(foreach$mVc$sp_i);
                if (foreach$mVc$sp_i == foreach$mVc$sp_this.scala$collection$immutable$Range$$lastElement()) break;
                foreach$mVc$sp_i += foreach$mVc$sp_this.step();
            }
        }
        return this.fromBitMaskNoCopy(words);
    }

    public static /* synthetic */ BitSetLike $amp$(BitSetLike $this, BitSet other) {
        return $this.$amp(other);
    }

    default public This $amp(BitSet other) {
        int n = this.nwords();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int len = RichInt$.MODULE$.min$extension(n, other.nwords());
        long[] words = new long[len];
        int n2 = 0;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        Range range = RichInt$.MODULE$.until$extension0(n2, len);
        if (range == null) {
            throw null;
        }
        Range foreach$mVc$sp_this = range;
        if (!foreach$mVc$sp_this.isEmpty()) {
            int foreach$mVc$sp_i = foreach$mVc$sp_this.start();
            while (true) {
                words[foreach$mVc$sp_i] = this.word(foreach$mVc$sp_i) & other.word(foreach$mVc$sp_i);
                if (foreach$mVc$sp_i == foreach$mVc$sp_this.scala$collection$immutable$Range$$lastElement()) break;
                foreach$mVc$sp_i += foreach$mVc$sp_this.step();
            }
        }
        return this.fromBitMaskNoCopy(words);
    }

    public static /* synthetic */ BitSetLike $amp$tilde$(BitSetLike $this, BitSet other) {
        return $this.$amp$tilde(other);
    }

    default public This $amp$tilde(BitSet other) {
        int len = this.nwords();
        long[] words = new long[len];
        int n = 0;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        Range range = RichInt$.MODULE$.until$extension0(n, len);
        if (range == null) {
            throw null;
        }
        Range foreach$mVc$sp_this = range;
        if (!foreach$mVc$sp_this.isEmpty()) {
            int foreach$mVc$sp_i = foreach$mVc$sp_this.start();
            while (true) {
                words[foreach$mVc$sp_i] = this.word(foreach$mVc$sp_i) & (other.word(foreach$mVc$sp_i) ^ 0xFFFFFFFFFFFFFFFFL);
                if (foreach$mVc$sp_i == foreach$mVc$sp_this.scala$collection$immutable$Range$$lastElement()) break;
                foreach$mVc$sp_i += foreach$mVc$sp_this.step();
            }
        }
        return this.fromBitMaskNoCopy(words);
    }

    public static /* synthetic */ BitSetLike $up$(BitSetLike $this, BitSet other) {
        return $this.$up(other);
    }

    default public This $up(BitSet other) {
        int n = this.nwords();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int len = RichInt$.MODULE$.max$extension(n, other.nwords());
        long[] words = new long[len];
        int n2 = 0;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        Range range = RichInt$.MODULE$.until$extension0(n2, len);
        if (range == null) {
            throw null;
        }
        Range foreach$mVc$sp_this = range;
        if (!foreach$mVc$sp_this.isEmpty()) {
            int foreach$mVc$sp_i = foreach$mVc$sp_this.start();
            while (true) {
                words[foreach$mVc$sp_i] = this.word(foreach$mVc$sp_i) ^ other.word(foreach$mVc$sp_i);
                if (foreach$mVc$sp_i == foreach$mVc$sp_this.scala$collection$immutable$Range$$lastElement()) break;
                foreach$mVc$sp_i += foreach$mVc$sp_this.step();
            }
        }
        return this.fromBitMaskNoCopy(words);
    }

    public static /* synthetic */ boolean contains$(BitSetLike $this, int elem) {
        return $this.contains(elem);
    }

    @Override
    default public boolean contains(int elem) {
        return 0 <= elem && (this.word(elem >> 6) & 1L << elem) != 0L;
    }

    public static /* synthetic */ boolean subsetOf$(BitSetLike $this, BitSet other) {
        return $this.subsetOf(other);
    }

    default public boolean subsetOf(BitSet other) {
        int n = 0;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return RichInt$.MODULE$.until$extension0(n, this.nwords()).forall((JFunction1$mcZI$sp & Serializable)idx -> (this.word(idx) & (other.word(idx) ^ 0xFFFFFFFFFFFFFFFFL)) == 0L);
    }

    public static /* synthetic */ int head$(BitSetLike $this) {
        return $this.head();
    }

    @Override
    default public int head() {
        int n = this.nwords();
        for (int i = 0; i < n; ++i) {
            long wi = this.word(i);
            if (wi == 0L) continue;
            return 64 * i + Long.numberOfTrailingZeros(wi);
        }
        throw new NoSuchElementException("Empty BitSet");
    }

    public static /* synthetic */ int last$(BitSetLike $this) {
        return $this.last();
    }

    @Override
    default public int last() {
        for (int i = this.nwords() - 1; i >= 0; --i) {
            long wi = this.word(i);
            if (wi == 0L) continue;
            return 64 * i + 63 - Long.numberOfLeadingZeros(wi);
        }
        throw new NoSuchElementException("Empty BitSet");
    }

    public static /* synthetic */ StringBuilder addString$(BitSetLike $this, StringBuilder sb, String start, String sep, String end) {
        return $this.addString(sb, start, sep, end);
    }

    @Override
    default public StringBuilder addString(StringBuilder sb, String start, String sep, String end) {
        sb.append(start);
        String pre = "";
        int max = this.nwords() * 64;
        for (int i = 0; i != max; ++i) {
            if (!this.contains(i)) continue;
            sb.append(pre).append(i);
            pre = sep;
        }
        return sb.append(end);
    }

    public static /* synthetic */ String stringPrefix$(BitSetLike $this) {
        return $this.stringPrefix();
    }

    @Override
    default public String stringPrefix() {
        return "BitSet";
    }

    public static void $init$(BitSetLike $this) {
    }
}

