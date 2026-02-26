/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.pickling;

import java.util.Arrays;
import scala.Array$;
import scala.Function0;
import scala.Predef$;
import scala.Predef$ArrowAssoc$;
import scala.Tuple2;
import scala.collection.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Range;
import scala.collection.mutable.ArrayOps;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.RichInt$;

@ScalaSignature(bytes="\u0006\u0001\u0005Uc\u0001B\u000f\u001f\u0001\u001dB\u0001\u0002\f\u0001\u0003\u0002\u0003\u0006I!\f\u0005\tg\u0001\u0011\t\u0011)A\u0005i!Aq\u0007\u0001B\u0001B\u0003%A\u0007C\u00039\u0001\u0011\u0005\u0011\bC\u0004@\u0001\u0001\u0007I\u0011\u0001!\t\u000f\u0005\u0003\u0001\u0019!C\u0001\u0005\"1\u0001\n\u0001Q!\n5Bq!\u0013\u0001A\u0002\u0013\u0005!\nC\u0004L\u0001\u0001\u0007I\u0011\u0001'\t\r9\u0003\u0001\u0015)\u00035\u0011\u001dy\u0005\u00011A\u0005\u0002)Cq\u0001\u0015\u0001A\u0002\u0013\u0005\u0011\u000b\u0003\u0004T\u0001\u0001\u0006K\u0001\u000e\u0005\u0006)\u0002!I!\u0016\u0005\u0006-\u0002!\ta\u0016\u0005\u00065\u0002!\ta\u0017\u0005\u0006=\u0002!\ta\u0018\u0005\u0006E\u0002!\ta\u0019\u0005\u0006Q\u0002!\t!\u001b\u0005\u0006[\u0002!\tA\u001c\u0005\u0006a\u0002!\t!\u001d\u0005\u0006e\u0002!\t!\u001d\u0005\u0006g\u0002!\t\u0001\u001e\u0005\u0006k\u0002!\tA\u001e\u0005\u0006s\u0002!\tA\u001f\u0005\b\u0003\u0017\u0001A\u0011AA\u0007\u0011\u001d\tY\u0004\u0001C\u0001\u0003{Aq!a\u0014\u0001\t\u0003\t\tF\u0001\u0007QS\u000e\\G.\u001a\"vM\u001a,'O\u0003\u0002 A\u0005A\u0001/[2lY&twM\u0003\u0002\"E\u0005A\u0011N\u001c;fe:\fGN\u0003\u0002$I\u00059!/\u001a4mK\u000e$(\"A\u0013\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001M\u0011\u0001\u0001\u000b\t\u0003S)j\u0011\u0001J\u0005\u0003W\u0011\u0012a!\u00118z%\u00164\u0017\u0001\u00023bi\u0006\u00042!\u000b\u00181\u0013\tyCEA\u0003BeJ\f\u0017\u0010\u0005\u0002*c%\u0011!\u0007\n\u0002\u0005\u0005f$X-\u0001\u0003ge>l\u0007CA\u00156\u0013\t1DEA\u0002J]R\f!\u0001^8\u0002\rqJg.\u001b;?)\u0011QD(\u0010 \u0011\u0005m\u0002Q\"\u0001\u0010\t\u000b1\"\u0001\u0019A\u0017\t\u000bM\"\u0001\u0019\u0001\u001b\t\u000b]\"\u0001\u0019\u0001\u001b\u0002\u000b\tLH/Z:\u0016\u00035\n\u0011BY=uKN|F%Z9\u0015\u0005\r3\u0005CA\u0015E\u0013\t)EE\u0001\u0003V]&$\bbB$\u0007\u0003\u0003\u0005\r!L\u0001\u0004q\u0012\n\u0014A\u00022zi\u0016\u001c\b%A\u0005sK\u0006$\u0017J\u001c3fqV\tA'A\u0007sK\u0006$\u0017J\u001c3fq~#S-\u001d\u000b\u0003\u00076CqaR\u0005\u0002\u0002\u0003\u0007A'\u0001\u0006sK\u0006$\u0017J\u001c3fq\u0002\n!b\u001e:ji\u0016Le\u000eZ3y\u000399(/\u001b;f\u0013:$W\r_0%KF$\"a\u0011*\t\u000f\u001dc\u0011\u0011!a\u0001i\u0005YqO]5uK&sG-\u001a=!\u0003\u0011!'\r\\3\u0015\u0003\r\u000ba\"\u001a8tkJ,7)\u00199bG&$\u0018\u0010\u0006\u0002D1\")\u0011l\u0004a\u0001i\u0005A1-\u00199bG&$\u00180A\u0005xe&$XMQ=uKR\u00111\t\u0018\u0005\u0006;B\u0001\r\u0001N\u0001\u0002E\u0006AqO]5uK:\u000bG\u000f\u0006\u0002DA\")\u0011-\u0005a\u0001i\u0005\t\u00010\u0001\u0007xe&$X\rT8oO:\u000bG\u000f\u0006\u0002DI\")\u0011M\u0005a\u0001KB\u0011\u0011FZ\u0005\u0003O\u0012\u0012A\u0001T8oO\u0006A\u0001/\u0019;dQ:\u000bG\u000fF\u0002DU2DQa[\nA\u0002Q\n1\u0001]8t\u0011\u0015\t7\u00031\u00015\u0003%9(/\u001b;f\u0019>tw\r\u0006\u0002D_\")\u0011\r\u0006a\u0001K\u0006A!/Z1e\u0005f$X\rF\u00015\u0003\u001d\u0011X-\u00193OCR\f1B]3bI2{gn\u001a(biR\tQ-\u0001\u0005sK\u0006$Gj\u001c8h)\t)w\u000fC\u0003y1\u0001\u0007A'A\u0002mK:\fA\u0002^8J]\u0012,\u00070\u001a3TKF,\u0012a\u001f\t\u0005y~\f)A\u0004\u0002*{&\u0011a\u0010J\u0001\ba\u0006\u001c7.Y4f\u0013\u0011\t\t!a\u0001\u0003\u0015%sG-\u001a=fIN+\u0017O\u0003\u0002\u007fIA)\u0011&a\u00025[%\u0019\u0011\u0011\u0002\u0013\u0003\rQ+\b\u000f\\33\u0003\u0015)h\u000e^5m+\u0011\ty!a\u0007\u0015\r\u0005E\u0011QFA\u0019!\u0015a\u00181CA\f\u0013\u0011\t)\"a\u0001\u0003\t1K7\u000f\u001e\t\u0005\u00033\tY\u0002\u0004\u0001\u0005\u000f\u0005u!D1\u0001\u0002 \t\tA+\u0005\u0003\u0002\"\u0005\u001d\u0002cA\u0015\u0002$%\u0019\u0011Q\u0005\u0013\u0003\u000f9{G\u000f[5oOB\u0019\u0011&!\u000b\n\u0007\u0005-BEA\u0002B]fDa!a\f\u001b\u0001\u0004!\u0014aA3oI\"9\u00111\u0007\u000eA\u0002\u0005U\u0012AA8q!\u0015I\u0013qGA\f\u0013\r\tI\u0004\n\u0002\n\rVt7\r^5p]B\nQ\u0001^5nKN,B!a\u0010\u0002FQ1\u0011\u0011IA$\u0003\u0017\u0002R\u0001`A\n\u0003\u0007\u0002B!!\u0007\u0002F\u00119\u0011QD\u000eC\u0002\u0005}\u0001BBA%7\u0001\u0007A'A\u0001o\u0011\u001d\t\u0019d\u0007a\u0001\u0003\u001b\u0002R!KA\u001c\u0003\u0007\n1b\u0019:fCR,\u0017J\u001c3fqV\u0011\u00111\u000b\t\u0004S9\"\u0004")
public class PickleBuffer {
    private final byte[] data;
    private byte[] bytes;
    private int readIndex;
    private int writeIndex;

    public byte[] bytes() {
        return this.bytes;
    }

    public void bytes_$eq(byte[] x$1) {
        this.bytes = x$1;
    }

    public int readIndex() {
        return this.readIndex;
    }

    public void readIndex_$eq(int x$1) {
        this.readIndex = x$1;
    }

    public int writeIndex() {
        return this.writeIndex;
    }

    public void writeIndex_$eq(int x$1) {
        this.writeIndex = x$1;
    }

    private void dble() {
        this.bytes_$eq(Arrays.copyOf(this.bytes(), this.bytes().length * 2));
    }

    public void ensureCapacity(int capacity) {
        while (this.bytes().length < this.writeIndex() + capacity) {
            this.dble();
        }
    }

    public void writeByte(int b) {
        if (this.writeIndex() == this.bytes().length) {
            this.dble();
        }
        this.bytes()[this.writeIndex()] = (byte)b;
        this.writeIndex_$eq(this.writeIndex() + 1);
    }

    public void writeNat(int x) {
        this.writeLongNat((long)x & 0xFFFFFFFFL);
    }

    public void writeLongNat(long x) {
        long y = x >>> 7;
        if (y != 0L) {
            this.writeNatPrefix$1(y);
        }
        this.writeByte((int)(x & 0x7FL));
    }

    public void patchNat(int pos, int x) {
        this.bytes()[pos] = (byte)(x & 0x7F);
        int y = x >>> 7;
        if (y != 0) {
            this.patchNatPrefix$1(y, pos);
        }
    }

    public void writeLong(long x) {
        long y = x >> 8;
        long z = x & 0xFFL;
        if (-y != z >> 7) {
            this.writeLong(y);
        }
        this.writeByte((int)z);
    }

    /*
     * WARNING - void declaration
     */
    public int readByte() {
        void var1_1;
        byte x = this.bytes()[this.readIndex()];
        this.readIndex_$eq(this.readIndex() + 1);
        return (int)var1_1;
    }

    public int readNat() {
        return (int)this.readLongNat();
    }

    /*
     * WARNING - void declaration
     */
    public long readLongNat() {
        void var3_1;
        long b;
        long x = 0L;
        do {
            b = this.readByte();
            x = (x << 7) + (b & 0x7FL);
        } while ((b & 0x80L) != 0L);
        return (long)var3_1;
    }

    public long readLong(int len) {
        long x = 0L;
        for (int i = 0; i < len; ++i) {
            x = (x << 8) + (long)(this.readByte() & 0xFF);
        }
        int leading = 64 - (len << 3);
        return x << leading >> leading;
    }

    public IndexedSeq<Tuple2<Object, byte[]>> toIndexedSeq() {
        int saved = this.readIndex();
        this.readIndex_$eq(0);
        this.readNat();
        this.readNat();
        Tuple2[] result2 = new Tuple2[this.readNat()];
        Range range = new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])result2)).indices();
        if (range == null) {
            throw null;
        }
        Range foreach$mVc$sp_this = range;
        if (!foreach$mVc$sp_this.isEmpty()) {
            int foreach$mVc$sp_i = foreach$mVc$sp_this.start();
            while (true) {
                PickleBuffer.$anonfun$toIndexedSeq$1(this, result2, foreach$mVc$sp_i);
                if (foreach$mVc$sp_i == foreach$mVc$sp_this.scala$collection$immutable$Range$$lastElement()) break;
                foreach$mVc$sp_i += foreach$mVc$sp_this.step();
            }
        }
        this.readIndex_$eq(saved);
        return new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])result2)).toIndexedSeq();
    }

    public <T> List<T> until(int end, Function0<T> op) {
        if (this.readIndex() == end) {
            return Nil$.MODULE$;
        }
        T t = op.apply();
        return this.until(end, op).$colon$colon(t);
    }

    public <T> List<T> times(int n, Function0<T> op) {
        if (n == 0) {
            return Nil$.MODULE$;
        }
        T t = op.apply();
        return this.times(n - 1, op).$colon$colon(t);
    }

    /*
     * WARNING - void declaration
     */
    public int[] createIndex() {
        void var1_1;
        int[] index = new int[this.readNat()];
        int n = 0;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        Range range = RichInt$.MODULE$.until$extension0(n, index.length);
        if (range == null) {
            throw null;
        }
        Range foreach$mVc$sp_this = range;
        if (!foreach$mVc$sp_this.isEmpty()) {
            int foreach$mVc$sp_i = foreach$mVc$sp_this.start();
            while (true) {
                PickleBuffer.$anonfun$createIndex$1(this, index, foreach$mVc$sp_i);
                if (foreach$mVc$sp_i == foreach$mVc$sp_this.scala$collection$immutable$Range$$lastElement()) break;
                foreach$mVc$sp_i += foreach$mVc$sp_this.step();
            }
        }
        return var1_1;
    }

    private final void writeNatPrefix$1(long x) {
        long y = x >>> 7;
        if (y != 0L) {
            this.writeNatPrefix$1(y);
        }
        this.writeByte((int)(x & 0x7FL | 0x80L));
    }

    private final void patchNatPrefix$1(int x, int pos$1) {
        while (true) {
            this.writeByte(0);
            Array$.MODULE$.copy(this.bytes(), pos$1, this.bytes(), pos$1 + 1, this.writeIndex() - (pos$1 + 1));
            this.bytes()[pos$1] = (byte)(x & 0x7F | 0x80);
            int y = x >>> 7;
            if (y == 0) break;
            x = y;
        }
    }

    /*
     * WARNING - void declaration
     */
    public static final /* synthetic */ void $anonfun$toIndexedSeq$1(PickleBuffer $this, Tuple2[] result$1, int index) {
        void $minus$greater$extension_$this;
        int tag = $this.readNat();
        int len = $this.readNat();
        byte[] bytes = (byte[])new ArrayOps.ofByte(Predef$.MODULE$.byteArrayOps($this.data)).slice($this.readIndex(), len + $this.readIndex());
        $this.readIndex_$eq($this.readIndex() + len);
        Integer n = Predef$.MODULE$.ArrowAssoc(BoxesRunTime.boxToInteger(tag));
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        result$1[index] = new Tuple2<void, byte[]>($minus$greater$extension_$this, bytes);
    }

    public static final /* synthetic */ void $anonfun$createIndex$1(PickleBuffer $this, int[] index$1, int i) {
        index$1[i] = $this.readIndex();
        $this.readByte();
        $this.readIndex_$eq($this.readNat() + $this.readIndex());
    }

    public PickleBuffer(byte[] data, int from, int to) {
        this.data = data;
        this.bytes = data;
        this.readIndex = from;
        this.writeIndex = to;
    }
}

