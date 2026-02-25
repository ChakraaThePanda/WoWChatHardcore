/*
 * Decompiled with CFR 0.152.
 */
package wowchat.realm;

import com.typesafe.scalalogging.Logger;
import com.typesafe.scalalogging.StrictLogging;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;
import scala.Enumeration;
import scala.MatchError;
import scala.Predef$;
import scala.collection.immutable.StringOps;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import wowchat.common.ByteUtils$;
import wowchat.common.Packet;
import wowchat.common.WowChatConfig$;
import wowchat.common.WowExpansion$;
import wowchat.realm.RealmPackets$;
import wowchat.realm.RealmPackets$AuthResult$;

@ScalaSignature(bytes="\u0006\u0001y3A!\u0003\u0006\u0001\u001f!)a\u0005\u0001C\u0001O!9!\u0006\u0001a\u0001\n\u0013Y\u0003b\u0002\u001a\u0001\u0001\u0004%Ia\r\u0005\u0007s\u0001\u0001\u000b\u0015\u0002\u0017\t\u000fi\u0002\u0001\u0019!C\u0005W!91\b\u0001a\u0001\n\u0013a\u0004B\u0002 \u0001A\u0003&A\u0006C\u0003@\u0001\u0011\u0005\u0003I\u0001\nSK\u0006dW\u000eU1dW\u0016$H)Z2pI\u0016\u0014(BA\u0006\r\u0003\u0015\u0011X-\u00197n\u0015\u0005i\u0011aB<po\u000eD\u0017\r^\u0002\u0001'\r\u0001\u0001\u0003\b\t\u0003#ii\u0011A\u0005\u0006\u0003'Q\tQaY8eK\u000eT!!\u0006\f\u0002\u000f!\fg\u000e\u001a7fe*\u0011q\u0003G\u0001\u0006]\u0016$H/\u001f\u0006\u00023\u0005\u0011\u0011n\\\u0005\u00037I\u0011ACQ=uKR{W*Z:tC\u001e,G)Z2pI\u0016\u0014\bCA\u000f%\u001b\u0005q\"BA\u0010!\u00031\u00198-\u00197bY><w-\u001b8h\u0015\t\t#%\u0001\u0005usB,7/\u00194f\u0015\u0005\u0019\u0013aA2p[&\u0011QE\b\u0002\u000e'R\u0014\u0018n\u0019;M_\u001e<\u0017N\\4\u0002\rqJg.\u001b;?)\u0005A\u0003CA\u0015\u0001\u001b\u0005Q\u0011\u0001B:ju\u0016,\u0012\u0001\f\t\u0003[Aj\u0011A\f\u0006\u0002_\u0005)1oY1mC&\u0011\u0011G\f\u0002\u0004\u0013:$\u0018\u0001C:ju\u0016|F%Z9\u0015\u0005Q:\u0004CA\u00176\u0013\t1dF\u0001\u0003V]&$\bb\u0002\u001d\u0004\u0003\u0003\u0005\r\u0001L\u0001\u0004q\u0012\n\u0014!B:ju\u0016\u0004\u0013AA5e\u0003\u0019IGm\u0018\u0013fcR\u0011A'\u0010\u0005\bq\u0019\t\t\u00111\u0001-\u0003\rIG\rI\u0001\u0007I\u0016\u001cw\u000eZ3\u0015\tQ\n\u0015*\u0015\u0005\u0006\u0005\"\u0001\raQ\u0001\u0004GRD\bC\u0001#H\u001b\u0005)%B\u0001$\u0017\u0003\u001d\u0019\u0007.\u00198oK2L!\u0001S#\u0003+\rC\u0017M\u001c8fY\"\u000bg\u000e\u001a7fe\u000e{g\u000e^3yi\")!\n\u0003a\u0001\u0017\u0006\u0011\u0011N\u001c\t\u0003\u0019>k\u0011!\u0014\u0006\u0003\u001dZ\taAY;gM\u0016\u0014\u0018B\u0001)N\u0005\u001d\u0011\u0015\u0010^3Ck\u001aDQA\u0015\u0005A\u0002M\u000b1a\\;u!\r!\u0016lW\u0007\u0002+*\u0011akV\u0001\u0005kRLGNC\u0001Y\u0003\u0011Q\u0017M^1\n\u0005i+&\u0001\u0002'jgR\u0004\"!\f/\n\u0005us#AB!osJ+g\r")
public class RealmPacketDecoder
extends ByteToMessageDecoder
implements StrictLogging {
    private int size;
    private int id;
    private final Logger logger;

    @Override
    public Logger logger() {
        return this.logger;
    }

    @Override
    public void com$typesafe$scalalogging$StrictLogging$_setter_$logger_$eq(Logger x$1) {
        this.logger = x$1;
    }

    private int size() {
        return this.size;
    }

    private void size_$eq(int x$1) {
        this.size = x$1;
    }

    private int id() {
        return this.id;
    }

    private void id_$eq(int x$1) {
        this.id = x$1;
    }

    @Override
    public void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        BoxedUnit boxedUnit;
        BoxedUnit boxedUnit2;
        if (in.readableBytes() == 0) {
            return;
        }
        if (this.size() == 0 && this.id() == 0) {
            Object object;
            in.markReaderIndex();
            this.id_$eq(in.readByte());
            int n = this.id();
            if (RealmPackets$.MODULE$.CMD_AUTH_LOGON_CHALLENGE() == n) {
                int n2;
                if (in.readableBytes() < 2) {
                    in.resetReaderIndex();
                    return;
                }
                in.markReaderIndex();
                in.skipBytes(1);
                byte result2 = in.readByte();
                if (RealmPackets$AuthResult$.MODULE$.isSuccess(result2)) {
                    in.skipBytes(115);
                    byte securityFlags = in.readByte();
                    int securityLength = 0;
                    if ((securityFlags & 1) == 1) {
                        securityLength += 20;
                    }
                    if ((securityFlags & 2) == 2) {
                        securityLength += 12;
                    }
                    if ((securityFlags & 4) == 4) {
                        ++securityLength;
                    }
                    n2 = 118 + securityLength;
                } else {
                    n2 = 2;
                }
                this.size_$eq(n2);
                object = in.resetReaderIndex();
            } else if (RealmPackets$.MODULE$.CMD_AUTH_LOGON_PROOF() == n) {
                int n3;
                if (in.readableBytes() < 1) {
                    in.resetReaderIndex();
                    return;
                }
                in.markReaderIndex();
                byte result3 = in.readByte();
                if (RealmPackets$AuthResult$.MODULE$.isSuccess(result3)) {
                    Enumeration.Value value = WowChatConfig$.MODULE$.getExpansion();
                    Enumeration.Value value2 = WowExpansion$.MODULE$.Vanilla();
                    n3 = !(value != null ? !((Object)value).equals(value2) : value2 != null) ? 25 : 31;
                } else {
                    n3 = in.readableBytes() == 0 ? 1 : 3;
                }
                this.size_$eq(n3);
                object = in.resetReaderIndex();
            } else if (RealmPackets$.MODULE$.CMD_REALM_LIST() == n) {
                if (in.readableBytes() < 2) {
                    in.resetReaderIndex();
                    return;
                }
                this.size_$eq(in.readShortLE());
                object = BoxedUnit.UNIT;
            } else {
                throw new MatchError(BoxesRunTime.boxToInteger(n));
            }
            boxedUnit2 = object;
        } else {
            boxedUnit2 = BoxedUnit.UNIT;
        }
        if (this.size() > in.readableBytes()) {
            return;
        }
        ByteBuf byteBuf = in.readBytes(this.size());
        Packet packet = new Packet(this.id(), byteBuf);
        if (this.logger().underlying().isDebugEnabled()) {
            int arg$macro$1 = this.id();
            String arg$macro$2 = ByteUtils$.MODULE$.toHexString(byteBuf, true, false);
            this.logger().underlying().debug(new StringOps("RECV REALM PACKET: %04X - %s").format(Predef$.MODULE$.genericWrapArray(new Object[]{BoxesRunTime.boxToInteger(arg$macro$1), arg$macro$2})));
            boxedUnit = BoxedUnit.UNIT;
        } else {
            boxedUnit = BoxedUnit.UNIT;
        }
        out.add(packet);
        this.size_$eq(0);
        this.id_$eq(0);
    }

    public RealmPacketDecoder() {
        StrictLogging.$init$(this);
        this.size = 0;
        this.id = 0;
    }
}

