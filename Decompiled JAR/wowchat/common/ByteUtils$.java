/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import scala.Array$;
import scala.Function2;
import scala.MatchError;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.ArrayOps;
import scala.collection.mutable.StringBuilder;
import scala.package$;
import scala.reflect.ClassTag$;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.RichInt$;

public final class ByteUtils$ {
    public static ByteUtils$ MODULE$;

    static {
        new ByteUtils$();
    }

    public byte[] shortToBytes(int n) {
        return new byte[]{(byte)(n >> 8), (byte)n};
    }

    public byte[] shortToBytesLE(int n) {
        return new byte[]{(byte)n, (byte)(n >> 8)};
    }

    public byte[] intToBytes(int n) {
        return new byte[]{(byte)(n >> 24), (byte)(n >> 16), (byte)(n >> 8), (byte)n};
    }

    public byte[] intToBytesLE(int n) {
        return new byte[]{(byte)n, (byte)(n >> 8), (byte)(n >> 16), (byte)(n >> 24)};
    }

    public byte[] longToBytes(long l) {
        return new byte[]{(byte)(l >> 56), (byte)(l >> 48), (byte)(l >> 40), (byte)(l >> 32), (byte)(l >> 24), (byte)(l >> 16), (byte)(l >> 8), (byte)l};
    }

    public byte[] longToBytesLE(long l) {
        return new byte[]{(byte)l, (byte)(l >> 8), (byte)(l >> 16), (byte)(l >> 24), (byte)(l >> 32), (byte)(l >> 40), (byte)(l >> 48), (byte)(l >> 56)};
    }

    public int stringToInt(String str) {
        return (int)this.bytesToLong(str.getBytes("UTF-8"));
    }

    public long bytesToLong(byte[] bytes) {
        return BoxesRunTime.unboxToLong(new ArrayOps.ofByte(Predef$.MODULE$.byteArrayOps(bytes)).reverseIterator().zipWithIndex().foldLeft(BoxesRunTime.boxToLong(0L), (Function2<Object, Tuple2, Object> & java.io.Serializable & Serializable)(x0$1, x1$1) -> BoxesRunTime.boxToLong(ByteUtils$.$anonfun$bytesToLong$1(BoxesRunTime.unboxToLong(x0$1), x1$1))));
    }

    public long bytesToLongLE(byte[] bytes) {
        return BoxesRunTime.unboxToLong(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])new ArrayOps.ofByte(Predef$.MODULE$.byteArrayOps(bytes)).zipWithIndex(Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.apply(Tuple2.class))))).foldLeft(BoxesRunTime.boxToLong(0L), (Function2<Object, Tuple2, Object> & java.io.Serializable & Serializable)(x0$1, x1$1) -> BoxesRunTime.boxToLong(ByteUtils$.$anonfun$bytesToLongLE$1(BoxesRunTime.unboxToLong(x0$1), x1$1))));
    }

    /*
     * WARNING - void declaration
     */
    public String toHexString(byte[] bytes) {
        void var3_3;
        ByteBuf byteBuf = PooledByteBufAllocator.DEFAULT.buffer(bytes.length, bytes.length);
        byteBuf.writeBytes(bytes);
        String ret = this.toHexString(byteBuf, true, false);
        byteBuf.release();
        return var3_3;
    }

    public String toHexString(ByteBuf byteBuf, boolean addSpaces, boolean resolvePlainText) {
        StringBuilder ret = package$.MODULE$.StringBuilder().newBuilder();
        ByteBuf copy = byteBuf.copy();
        while (copy.readableBytes() > 0) {
            StringBuilder stringBuilder;
            byte by = copy.readByte();
            if (resolvePlainText && by >= 32 && by < 127) {
                stringBuilder = ret.$plus$plus$eq(new java.lang.StringBuilder(1).append((char)by).append(" ").toString());
            } else {
                byte arg$macro$1 = by;
                stringBuilder = ret.$plus$plus$eq(new StringOps("%02X").format(Predef$.MODULE$.genericWrapArray(new Object[]{BoxesRunTime.boxToByte(arg$macro$1)})));
            }
            java.io.Serializable serializable = addSpaces ? ret.$plus$eq(' ') : BoxedUnit.UNIT;
        }
        copy.release();
        return ret.mkString().trim();
    }

    public boolean toHexString$default$2() {
        return false;
    }

    public boolean toHexString$default$3() {
        return true;
    }

    public String toBinaryString(ByteBuf byteBuf) {
        StringBuilder ret = package$.MODULE$.StringBuilder().newBuilder();
        ByteBuf copy = byteBuf.copy();
        int i = 0;
        while (copy.readableBytes() > 0) {
            byte by = copy.readByte();
            java.io.Serializable serializable = i != 0 && i % 4 == 0 ? ret.$plus$plus$eq(System.lineSeparator()) : BoxedUnit.UNIT;
            int arg$macro$1 = new StringOps(Predef$.MODULE$.augmentString(RichInt$.MODULE$.toBinaryString$extension(Predef$.MODULE$.intWrapper(by & 0xFF)))).toInt();
            ret.$plus$plus$eq(new StringOps("%08d ").format(Predef$.MODULE$.genericWrapArray(new Object[]{BoxesRunTime.boxToInteger(arg$macro$1)})));
            ++i;
        }
        copy.release();
        return ret.mkString().trim();
    }

    public static final /* synthetic */ long $anonfun$bytesToLong$1(long x0$1, Tuple2 x1$1) {
        Tuple2 tuple2;
        long result2;
        block3: {
            Tuple2<Long, Tuple2> tuple22;
            block2: {
                tuple22 = new Tuple2<Long, Tuple2>(BoxesRunTime.boxToLong(x0$1), x1$1);
                if (tuple22 == null) break block2;
                result2 = tuple22._1$mcJ$sp();
                tuple2 = tuple22._2();
                if (tuple2 != null) break block3;
            }
            throw new MatchError(tuple22);
        }
        byte by = BoxesRunTime.unboxToByte(tuple2._1());
        int i = tuple2._2$mcI$sp();
        long l = result2 | ((long)by & 0xFFL) << i * 8;
        return l;
    }

    public static final /* synthetic */ long $anonfun$bytesToLongLE$1(long x0$1, Tuple2 x1$1) {
        Tuple2 tuple2;
        long result2;
        block3: {
            Tuple2<Long, Tuple2> tuple22;
            block2: {
                tuple22 = new Tuple2<Long, Tuple2>(BoxesRunTime.boxToLong(x0$1), x1$1);
                if (tuple22 == null) break block2;
                result2 = tuple22._1$mcJ$sp();
                tuple2 = tuple22._2();
                if (tuple2 != null) break block3;
            }
            throw new MatchError(tuple22);
        }
        byte by = BoxesRunTime.unboxToByte(tuple2._1());
        int i = tuple2._2$mcI$sp();
        long l = result2 | ((long)by & 0xFFL) << i * 8;
        return l;
    }

    private ByteUtils$() {
        MODULE$ = this;
    }
}

