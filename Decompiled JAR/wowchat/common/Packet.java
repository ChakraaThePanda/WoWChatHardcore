/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import io.netty.buffer.ByteBuf;
import scala.Function1;
import scala.MatchError;
import scala.Option;
import scala.Predef$;
import scala.Product;
import scala.Serializable;
import scala.Tuple2;
import scala.Tuple2$mcII$sp;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.TraversableOnce;
import scala.collection.mutable.ArrayBuffer$;
import scala.collection.mutable.Builder;
import scala.io.Source$;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.RichInt$;
import scala.runtime.ScalaRunTime$;
import scala.runtime.Statics;
import scala.runtime.java8.JFunction0$mcV$sp;
import scala.runtime.java8.JFunction1$mcVI$sp;
import scala.runtime.java8.JFunction2$mcIII$sp;
import scala.util.control.Breaks$;
import wowchat.common.Packet$;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@ScalaSignature(bytes="\u0006\u0001\u00055g\u0001\u0002\u0015*\u0001:B\u0001b\u000f\u0001\u0003\u0016\u0004%\t\u0001\u0010\u0005\t\u0001\u0002\u0011\t\u0012)A\u0005{!A\u0011\t\u0001BK\u0002\u0013\u0005!\t\u0003\u0005N\u0001\tE\t\u0015!\u0003D\u0011\u0015q\u0005\u0001\"\u0001P\u0011\u0015!\u0006\u0001\"\u0001V\u0011\u0015\t\u0007\u0001\"\u0001c\u0011\u001d\u0019\u0007\u00011A\u0005\nqBq\u0001\u001a\u0001A\u0002\u0013%Q\r\u0003\u0004l\u0001\u0001\u0006K!\u0010\u0005\bY\u0002\u0001\r\u0011\"\u0003n\u0011\u001d\t\b\u00011A\u0005\nIDa\u0001\u001e\u0001!B\u0013q\u0007\"B;\u0001\t\u00031\b\"B<\u0001\t\u0003i\u0007\"\u0002=\u0001\t\u0003I\b\"\u0002?\u0001\t\u0003i\bbBA\t\u0001\u0011\u0005\u00111\u0003\u0005\b\u0003/\u0001A\u0011AA\r\u0011%\ty\u0002AA\u0001\n\u0003\t\t\u0003C\u0005\u0002(\u0001\t\n\u0011\"\u0001\u0002*!I\u0011q\b\u0001\u0012\u0002\u0013\u0005\u0011\u0011\t\u0005\n\u0003\u000b\u0002\u0011\u0011!C!\u0003\u000fB\u0001\"a\u0016\u0001\u0003\u0003%\t\u0001\u0010\u0005\n\u00033\u0002\u0011\u0011!C\u0001\u00037B\u0011\"!\u001a\u0001\u0003\u0003%\t%a\u001a\t\u0013\u0005U\u0004!!A\u0005\u0002\u0005]\u0004\"CAA\u0001\u0005\u0005I\u0011IAB\u0011%\t)\tAA\u0001\n\u0003\n9\tC\u0005\u0002\n\u0002\t\t\u0011\"\u0011\u0002\f\u001eI\u0011qR\u0015\u0002\u0002#\u0005\u0011\u0011\u0013\u0004\tQ%\n\t\u0011#\u0001\u0002\u0014\"1a\n\tC\u0001\u0003CC\u0011\"!\"!\u0003\u0003%)%a\"\t\u0013\u0005\r\u0006%!A\u0005\u0002\u0006\u0015\u0006\"CAVAE\u0005I\u0011AA!\u0011%\ti\u000bIA\u0001\n\u0003\u000by\u000bC\u0005\u0002B\u0002\n\n\u0011\"\u0001\u0002B!I\u00111\u0019\u0011\u0002\u0002\u0013%\u0011Q\u0019\u0002\u0007!\u0006\u001c7.\u001a;\u000b\u0005)Z\u0013AB2p[6|gNC\u0001-\u0003\u001d9xn^2iCR\u001c\u0001a\u0005\u0003\u0001_UB\u0004C\u0001\u00194\u001b\u0005\t$\"\u0001\u001a\u0002\u000bM\u001c\u0017\r\\1\n\u0005Q\n$AB!osJ+g\r\u0005\u00021m%\u0011q'\r\u0002\b!J|G-^2u!\t\u0001\u0014(\u0003\u0002;c\ta1+\u001a:jC2L'0\u00192mK\u0006\u0011\u0011\u000eZ\u000b\u0002{A\u0011\u0001GP\u0005\u0003\u007fE\u00121!\u00138u\u0003\rIG\rI\u0001\bEf$XMQ;g+\u0005\u0019\u0005C\u0001#L\u001b\u0005)%B\u0001$H\u0003\u0019\u0011WO\u001a4fe*\u0011\u0001*S\u0001\u0006]\u0016$H/\u001f\u0006\u0002\u0015\u0006\u0011\u0011n\\\u0005\u0003\u0019\u0016\u0013qAQ=uK\n+h-\u0001\u0005csR,')\u001e4!\u0003\u0019a\u0014N\\5u}Q\u0019\u0001KU*\u0011\u0005E\u0003Q\"A\u0015\t\u000bm*\u0001\u0019A\u001f\t\u000f\u0005+\u0001\u0013!a\u0001\u0007\u0006Q!/Z1e'R\u0014\u0018N\\4\u0016\u0003Y\u0003\"a\u00160\u000f\u0005ac\u0006CA-2\u001b\u0005Q&BA..\u0003\u0019a$o\\8u}%\u0011Q,M\u0001\u0007!J,G-\u001a4\n\u0005}\u0003'AB*ue&twM\u0003\u0002^c\u0005Q1o[5q'R\u0014\u0018N\\4\u0016\u0003A\u000b1BY5u!>\u001c\u0018\u000e^5p]\u0006y!-\u001b;Q_NLG/[8o?\u0012*\u0017\u000f\u0006\u0002gSB\u0011\u0001gZ\u0005\u0003QF\u0012A!\u00168ji\"9!.CA\u0001\u0002\u0004i\u0014a\u0001=%c\u0005a!-\u001b;Q_NLG/[8oA\u0005!!-\u001f;f+\u0005q\u0007C\u0001\u0019p\u0013\t\u0001\u0018G\u0001\u0003CsR,\u0017\u0001\u00032zi\u0016|F%Z9\u0015\u0005\u0019\u001c\bb\u00026\r\u0003\u0003\u0005\rA\\\u0001\u0006Ef$X\rI\u0001\u000fe\u0016\u001cX\r\u001e\"jiJ+\u0017\rZ3s+\u00051\u0017a\u0002:fC\u0012\u0014\u0015\u000e^\u0001\te\u0016\fGMQ5ugR\u0011QH\u001f\u0005\u0006wB\u0001\r!P\u0001\u0007Y\u0016tw\r\u001e5\u0002\u0015I,\u0017\r\u001a\"jiN+\u0017\u000f\u0006\u0003g}\u0006\u001d\u0001BB@\u0012\u0001\u0004\t\t!\u0001\u0003nCN\\\u0007\u0003\u0002\u0019\u0002\u00049L1!!\u00022\u0005\u0015\t%O]1z\u0011\u001d\tI!\u0005a\u0001\u0003\u0017\tq!\u001b8eS\u000e,7\u000f\u0005\u00031\u0003\u001bi\u0014bAA\bc\tQAH]3qK\u0006$X\r\u001a \u0002\u0017I,\u0017\r\u001a-pe\nKH/\u001a\u000b\u0004]\u0006U\u0001\"B@\u0013\u0001\u0004q\u0017A\u0004:fC\u0012DvN\u001d\"zi\u0016\u001cV-\u001d\u000b\u0006M\u0006m\u0011Q\u0004\u0005\u0007\u007fN\u0001\r!!\u0001\t\u000f\u0005%1\u00031\u0001\u0002\f\u0005!1m\u001c9z)\u0015\u0001\u00161EA\u0013\u0011\u001dYD\u0003%AA\u0002uBq!\u0011\u000b\u0011\u0002\u0003\u00071)\u0001\bd_BLH\u0005Z3gCVdG\u000fJ\u0019\u0016\u0005\u0005-\"fA\u001f\u0002.-\u0012\u0011q\u0006\t\u0005\u0003c\tY$\u0004\u0002\u00024)!\u0011QGA\u001c\u0003%)hn\u00195fG.,GMC\u0002\u0002:E\n!\"\u00198o_R\fG/[8o\u0013\u0011\ti$a\r\u0003#Ut7\r[3dW\u0016$g+\u0019:jC:\u001cW-\u0001\bd_BLH\u0005Z3gCVdG\u000f\n\u001a\u0016\u0005\u0005\r#fA\"\u0002.\u0005i\u0001O]8ek\u000e$\bK]3gSb,\"!!\u0013\u0011\t\u0005-\u0013QK\u0007\u0003\u0003\u001bRA!a\u0014\u0002R\u0005!A.\u00198h\u0015\t\t\u0019&\u0001\u0003kCZ\f\u0017bA0\u0002N\u0005a\u0001O]8ek\u000e$\u0018I]5us\u0006q\u0001O]8ek\u000e$X\t\\3nK:$H\u0003BA/\u0003G\u00022\u0001MA0\u0013\r\t\t'\r\u0002\u0004\u0003:L\bb\u00026\u001a\u0003\u0003\u0005\r!P\u0001\u0010aJ|G-^2u\u0013R,'/\u0019;peV\u0011\u0011\u0011\u000e\t\u0007\u0003W\n\t(!\u0018\u000e\u0005\u00055$bAA8c\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\n\t\u0005M\u0014Q\u000e\u0002\t\u0013R,'/\u0019;pe\u0006A1-\u00198FcV\fG\u000e\u0006\u0003\u0002z\u0005}\u0004c\u0001\u0019\u0002|%\u0019\u0011QP\u0019\u0003\u000f\t{w\u000e\\3b]\"A!nGA\u0001\u0002\u0004\ti&\u0001\u0005iCND7i\u001c3f)\u0005i\u0014\u0001\u0003;p'R\u0014\u0018N\\4\u0015\u0005\u0005%\u0013AB3rk\u0006d7\u000f\u0006\u0003\u0002z\u00055\u0005\u0002\u00036\u001f\u0003\u0003\u0005\r!!\u0018\u0002\rA\u000b7m[3u!\t\t\u0006e\u0005\u0003!\u0003+C\u0004cBAL\u0003;k4\tU\u0007\u0003\u00033S1!a'2\u0003\u001d\u0011XO\u001c;j[\u0016LA!a(\u0002\u001a\n\t\u0012IY:ue\u0006\u001cGOR;oGRLwN\u001c\u001a\u0015\u0005\u0005E\u0015!B1qa2LH#\u0002)\u0002(\u0006%\u0006\"B\u001e$\u0001\u0004i\u0004bB!$!\u0003\u0005\raQ\u0001\u0010CB\u0004H.\u001f\u0013eK\u001a\fW\u000f\u001c;%e\u00059QO\\1qa2LH\u0003BAY\u0003{\u0003R\u0001MAZ\u0003oK1!!.2\u0005\u0019y\u0005\u000f^5p]B)\u0001'!/>\u0007&\u0019\u00111X\u0019\u0003\rQ+\b\u000f\\33\u0011!\ty,JA\u0001\u0002\u0004\u0001\u0016a\u0001=%a\u0005YB\u0005\\3tg&t\u0017\u000e\u001e\u0013he\u0016\fG/\u001a:%I\u00164\u0017-\u001e7uII\n1B]3bIJ+7o\u001c7wKR\u0011\u0011q\u0019\t\u0005\u0003\u0017\nI-\u0003\u0003\u0002L\u00065#AB(cU\u0016\u001cG\u000f")
public class Packet
implements Product,
Serializable {
    private final int id;
    private final ByteBuf byteBuf;
    private int bitPosition;
    private byte byte;

    public static ByteBuf $lessinit$greater$default$2() {
        return Packet$.MODULE$.$lessinit$greater$default$2();
    }

    public static Option<Tuple2<Object, ByteBuf>> unapply(Packet packet) {
        return Packet$.MODULE$.unapply(packet);
    }

    public static ByteBuf apply$default$2() {
        return Packet$.MODULE$.apply$default$2();
    }

    public static Packet apply(int n, ByteBuf byteBuf) {
        return Packet$.MODULE$.apply(n, byteBuf);
    }

    public static Function1<Tuple2<Object, ByteBuf>, Packet> tupled() {
        return Packet$.MODULE$.tupled();
    }

    public static Function1<Object, Function1<ByteBuf, Packet>> curried() {
        return Packet$.MODULE$.curried();
    }

    public int id() {
        return this.id;
    }

    public ByteBuf byteBuf() {
        return this.byteBuf;
    }

    public String readString() {
        Builder ret = ArrayBuffer$.MODULE$.newBuilder();
        Breaks$.MODULE$.breakable((JFunction0$mcV$sp & Serializable)() -> {
            while (this.byteBuf().readableBytes() > 0) {
                byte value = this.byteBuf().readByte();
                if (value == 0) {
                    throw Breaks$.MODULE$.break();
                }
                ret.$plus$eq(BoxesRunTime.boxToByte(value));
            }
        });
        return Source$.MODULE$.fromBytes((byte[])((TraversableOnce)ret.result()).toArray(ClassTag$.MODULE$.Byte()), "UTF-8").mkString();
    }

    public Packet skipString() {
        while (this.byteBuf().readableBytes() > 0 && this.byteBuf().readByte() != 0) {
        }
        return this;
    }

    private int bitPosition() {
        return this.bitPosition;
    }

    private void bitPosition_$eq(int x$1) {
        this.bitPosition = x$1;
    }

    private byte byte() {
        return this.byte;
    }

    private void byte_$eq(byte x$1) {
        this.byte = x$1;
    }

    public void resetBitReader() {
        this.bitPosition_$eq(7);
        this.byte_$eq((byte)0);
    }

    public byte readBit() {
        block0: {
            this.bitPosition_$eq(this.bitPosition() + 1);
            if (this.bitPosition() <= 7) break block0;
            this.bitPosition_$eq(0);
            this.byte_$eq(this.byteBuf().readByte());
        }
        return (byte)(this.byte() >> 7 - this.bitPosition() & 1);
    }

    public int readBits(int length) {
        return BoxesRunTime.unboxToInt(RichInt$.MODULE$.to$extension0(Predef$.MODULE$.intWrapper(length - 1), 0).by(-1).foldLeft(BoxesRunTime.boxToInteger(0), (JFunction2$mcIII$sp & Serializable)(x0$1, x1$1) -> {
            Tuple2$mcII$sp tuple2$mcII$sp = new Tuple2$mcII$sp(x0$1, x1$1);
            if (tuple2$mcII$sp == null) {
                throw new MatchError(tuple2$mcII$sp);
            }
            int result2 = ((Tuple2)tuple2$mcII$sp)._1$mcI$sp();
            int i = ((Tuple2)tuple2$mcII$sp)._2$mcI$sp();
            int n = result2 | this.readBit() << i;
            return n;
        }));
    }

    public void readBitSeq(byte[] mask, Seq<Object> indices) {
        indices.foreach((JFunction1$mcVI$sp & Serializable)i -> {
            mask$1[i] = this.readBit();
        });
    }

    public byte readXorByte(byte mask) {
        return mask != 0 ? (byte)((byte)(mask ^ this.byteBuf().readByte())) : mask;
    }

    public void readXorByteSeq(byte[] mask, Seq<Object> indices) {
        indices.foreach((JFunction1$mcVI$sp & Serializable)i -> {
            mask$2[i] = this.readXorByte(mask[i]);
        });
    }

    public Packet copy(int id, ByteBuf byteBuf) {
        return new Packet(id, byteBuf);
    }

    public int copy$default$1() {
        return this.id();
    }

    public ByteBuf copy$default$2() {
        return this.byteBuf();
    }

    @Override
    public String productPrefix() {
        return "Packet";
    }

    @Override
    public int productArity() {
        return 2;
    }

    @Override
    public Object productElement(int x$1) {
        Comparable<ByteBuf> comparable;
        int n = x$1;
        switch (n) {
            case 0: {
                comparable = BoxesRunTime.boxToInteger(this.id());
                break;
            }
            case 1: {
                comparable = this.byteBuf();
                break;
            }
            default: {
                throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(x$1)).toString());
            }
        }
        return comparable;
    }

    @Override
    public Iterator<Object> productIterator() {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    @Override
    public boolean canEqual(Object x$1) {
        return x$1 instanceof Packet;
    }

    public int hashCode() {
        int n = -889275714;
        n = Statics.mix(n, this.id());
        n = Statics.mix(n, Statics.anyHash(this.byteBuf()));
        return Statics.finalizeHash(n, 2);
    }

    public String toString() {
        return ScalaRunTime$.MODULE$._toString(this);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean equals(Object x$1) {
        if (this == x$1) return true;
        Object object = x$1;
        if (!(object instanceof Packet)) return false;
        boolean bl = true;
        if (!bl) return false;
        Packet packet = (Packet)x$1;
        if (this.id() != packet.id()) return false;
        ByteBuf byteBuf = this.byteBuf();
        ByteBuf byteBuf2 = packet.byteBuf();
        if (byteBuf == null) {
            if (byteBuf2 != null) {
                return false;
            }
        } else if (!((Object)byteBuf).equals(byteBuf2)) return false;
        if (!packet.canEqual(this)) return false;
        return true;
    }

    public Packet(int id, ByteBuf byteBuf) {
        this.id = id;
        this.byteBuf = byteBuf;
        Product.$init$(this);
        this.bitPosition = 7;
        this.byte = 0;
    }
}

