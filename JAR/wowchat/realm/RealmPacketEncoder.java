/*
 * Decompiled with CFR 0.152.
 */
package wowchat.realm;

import com.typesafe.scalalogging.Logger;
import com.typesafe.scalalogging.StrictLogging;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import scala.Predef$;
import scala.collection.immutable.StringOps;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import wowchat.common.ByteUtils$;
import wowchat.common.Packet;

@ScalaSignature(bytes="\u0006\u0001\u00113Aa\u0001\u0003\u0001\u0013!)a\u0005\u0001C\u0001O!)!\u0006\u0001C!W\t\u0011\"+Z1m[B\u000b7m[3u\u000b:\u001cw\u000eZ3s\u0015\t)a!A\u0003sK\u0006dWNC\u0001\b\u0003\u001d9xn^2iCR\u001c\u0001aE\u0002\u0001\u0015q\u00012a\u0003\u000b\u0017\u001b\u0005a!BA\u0007\u000f\u0003\u0015\u0019w\u000eZ3d\u0015\ty\u0001#A\u0004iC:$G.\u001a:\u000b\u0005E\u0011\u0012!\u00028fiRL(\"A\n\u0002\u0005%|\u0017BA\u000b\r\u0005QiUm]:bO\u0016$vNQ=uK\u0016s7m\u001c3feB\u0011qCG\u0007\u00021)\u0011\u0011DB\u0001\u0007G>lWn\u001c8\n\u0005mA\"A\u0002)bG.,G\u000f\u0005\u0002\u001eI5\taD\u0003\u0002 A\u0005a1oY1mC2|wmZ5oO*\u0011\u0011EI\u0001\tif\u0004Xm]1gK*\t1%A\u0002d_6L!!\n\u0010\u0003\u001bM#(/[2u\u0019><w-\u001b8h\u0003\u0019a\u0014N\\5u}Q\t\u0001\u0006\u0005\u0002*\u00015\tA!\u0001\u0004f]\u000e|G-\u001a\u000b\u0005YIRD\b\u0005\u0002.a5\taFC\u00010\u0003\u0015\u00198-\u00197b\u0013\t\tdF\u0001\u0003V]&$\b\"B\u001a\u0003\u0001\u0004!\u0014aA2uqB\u0011Q\u0007O\u0007\u0002m)\u0011q\u0007E\u0001\bG\"\fgN\\3m\u0013\tIdGA\u000bDQ\u0006tg.\u001a7IC:$G.\u001a:D_:$X\r\u001f;\t\u000bm\u0012\u0001\u0019\u0001\f\u0002\u00075\u001cx\rC\u0003>\u0005\u0001\u0007a(A\u0002pkR\u0004\"a\u0010\"\u000e\u0003\u0001S!!\u0011\t\u0002\r\t,hMZ3s\u0013\t\u0019\u0005IA\u0004CsR,')\u001e4")
public class RealmPacketEncoder
extends MessageToByteEncoder<Packet>
implements StrictLogging {
    private final Logger logger;

    @Override
    public Logger logger() {
        return this.logger;
    }

    @Override
    public void com$typesafe$scalalogging$StrictLogging$_setter_$logger_$eq(Logger x$1) {
        this.logger = x$1;
    }

    @Override
    public void encode(ChannelHandlerContext ctx, Packet msg, ByteBuf out) {
        BoxedUnit boxedUnit;
        if (this.logger().underlying().isDebugEnabled()) {
            int arg$macro$1 = msg.id();
            String arg$macro$2 = ByteUtils$.MODULE$.toHexString(msg.byteBuf(), true, false);
            this.logger().underlying().debug(new StringOps("SEND REALM PACKET: %04X - %s").format(Predef$.MODULE$.genericWrapArray(new Object[]{BoxesRunTime.boxToInteger(arg$macro$1), arg$macro$2})));
            boxedUnit = BoxedUnit.UNIT;
        } else {
            boxedUnit = BoxedUnit.UNIT;
        }
        out.writeByte(msg.id());
        out.writeBytes(msg.byteBuf());
        msg.byteBuf().release();
    }

    public RealmPacketEncoder() {
        StrictLogging.$init$(this);
    }
}

