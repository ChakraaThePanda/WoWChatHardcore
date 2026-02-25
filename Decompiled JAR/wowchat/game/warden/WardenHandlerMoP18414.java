/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game.warden;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import java.security.MessageDigest;
import scala.reflect.ScalaSignature;
import wowchat.common.Packet;
import wowchat.game.warden.WardenHandler;

@ScalaSignature(bytes="\u0006\u0001)3A\u0001C\u0005\u0001!!AQ\u0003\u0001B\u0001B\u0003%a\u0003C\u0003 \u0001\u0011\u0005\u0001\u0005C\u0004$\u0001\t\u0007I\u0011\u000b\u0013\t\r!\u0002\u0001\u0015!\u0003&\u0011\u0015I\u0003\u0001\"\u0015+\u0011\u0015\u0019\u0004\u0001\"\u00155\u0011\u0015\t\u0005\u0001\"\u0015C\u0005U9\u0016M\u001d3f]\"\u000bg\u000e\u001a7fe6{\u0007+\r\u001d5cQR!AC\u0006\u0002\r]\f'\u000fZ3o\u0015\taQ\"\u0001\u0003hC6,'\"\u0001\b\u0002\u000f]|wo\u00195bi\u000e\u00011C\u0001\u0001\u0012!\t\u00112#D\u0001\n\u0013\t!\u0012BA\u0007XCJ$WM\u001c%b]\u0012dWM]\u0001\u000bg\u0016\u001c8/[8o\u0017\u0016L\bcA\f\u001b95\t\u0001DC\u0001\u001a\u0003\u0015\u00198-\u00197b\u0013\tY\u0002DA\u0003BeJ\f\u0017\u0010\u0005\u0002\u0018;%\u0011a\u0004\u0007\u0002\u0005\u0005f$X-\u0001\u0004=S:LGO\u0010\u000b\u0003C\t\u0002\"A\u0005\u0001\t\u000bU\u0011\u0001\u0019\u0001\f\u0002)]\u000b%\u000bR#O?6{E)\u0016'F?2+ej\u0012+I+\u0005)\u0003CA\f'\u0013\t9\u0003DA\u0002J]R\fQcV!S\t\u0016su,T(E+2+u\fT#O\u000fRC\u0005%A\rhKR,en\u0019:zaR,G-T3tg\u0006<W\rT3oORDGCA\u0013,\u0011\u0015aS\u00011\u0001.\u0003\ri7o\u001a\t\u0003]Ej\u0011a\f\u0006\u0003a5\taaY8n[>t\u0017B\u0001\u001a0\u0005\u0019\u0001\u0016mY6fi\u0006aam\u001c:n%\u0016\u001c\bo\u001c8tKR\u0011Qg\u0010\t\u0003muj\u0011a\u000e\u0006\u0003qe\naAY;gM\u0016\u0014(B\u0001\u001e<\u0003\u0015qW\r\u001e;z\u0015\u0005a\u0014AA5p\u0013\tqtGA\u0004CsR,')\u001e4\t\u000b\u00013\u0001\u0019A\u001b\u0002\u0007=,H/\u0001\u000fg_Jl7\t[3bi\u000eCWmY6t%\u0016\fX/Z:u\t&<Wm\u001d;\u0015\u0007\r3\u0005\n\u0005\u0002\u0018\t&\u0011Q\t\u0007\u0002\u0005+:LG\u000fC\u0003H\u000f\u0001\u0007Q'A\u0002sKRDQ!S\u0004A\u0002Y\t1a[3z\u0001")
public class WardenHandlerMoP18414
extends WardenHandler {
    private final int WARDEN_MODULE_LENGTH;

    @Override
    public int WARDEN_MODULE_LENGTH() {
        return this.WARDEN_MODULE_LENGTH;
    }

    @Override
    public int getEncryptedMessageLength(Packet msg) {
        return msg.byteBuf().readIntLE();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public ByteBuf formResponse(ByteBuf out) {
        void var3_3;
        int newLength = out.readableBytes() + 4;
        ByteBuf withHeader = PooledByteBufAllocator.DEFAULT.buffer(newLength, newLength);
        withHeader.writeIntLE(out.readableBytes());
        withHeader.writeBytes(out);
        out.release();
        return var3_3;
    }

    @Override
    public void formCheatChecksRequestDigest(ByteBuf ret, byte[] key) {
        MessageDigest mdSHA1 = MessageDigest.getInstance("SHA1");
        mdSHA1.update(key);
        ret.writeBytes(mdSHA1.digest());
        MessageDigest mdSHA256 = MessageDigest.getInstance("SHA-256");
        mdSHA256.update(key);
        ret.writeBytes(mdSHA256.digest());
    }

    public WardenHandlerMoP18414(byte[] sessionKey) {
        super(sessionKey);
        this.WARDEN_MODULE_LENGTH = 32;
    }
}

