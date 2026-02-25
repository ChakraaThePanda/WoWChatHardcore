/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import io.netty.buffer.ByteBuf;
import scala.Predef$;
import scala.Tuple2;
import scala.Tuple2$mcII$sp;
import scala.collection.mutable.ArrayOps;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import wowchat.game.GameHeaderCrypt;
import wowchat.game.GamePacketDecoder;
import wowchat.game.GamePacketsTBC;
import wowchat.game.GamePacketsWotLK;

@ScalaSignature(bytes="\u0006\u0001A2Aa\u0001\u0003\u0001\u0013!)\u0011\u0003\u0001C\u0001%!)A\u0003\u0001C!+\t1r)Y7f!\u0006\u001c7.\u001a;EK\u000e|G-\u001a:X_Rd5J\u0003\u0002\u0006\r\u0005!q-Y7f\u0015\u00059\u0011aB<po\u000eD\u0017\r^\u0002\u0001'\r\u0001!B\u0004\t\u0003\u00171i\u0011\u0001B\u0005\u0003\u001b\u0011\u0011\u0011cR1nKB\u000b7m[3u\t\u0016\u001cw\u000eZ3s!\tYq\"\u0003\u0002\u0011\t\t\u0001r)Y7f!\u0006\u001c7.\u001a;t/>$HjS\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003M\u0001\"a\u0003\u0001\u00021A\f'o]3HC6,\u0007*Z1eKJ,en\u0019:zaR,G\rF\u0002\u0017?-\u0002Ba\u0006\u000e\u001d95\t\u0001DC\u0001\u001a\u0003\u0015\u00198-\u00197b\u0013\tY\u0002D\u0001\u0004UkBdWM\r\t\u0003/uI!A\b\r\u0003\u0007%sG\u000fC\u0003!\u0005\u0001\u0007\u0011%\u0001\u0002j]B\u0011!%K\u0007\u0002G)\u0011A%J\u0001\u0007EV4g-\u001a:\u000b\u0005\u0019:\u0013!\u00028fiRL(\"\u0001\u0015\u0002\u0005%|\u0017B\u0001\u0016$\u0005\u001d\u0011\u0015\u0010^3Ck\u001aDQ\u0001\f\u0002A\u00025\nQa\u0019:zaR\u0004\"a\u0003\u0018\n\u0005=\"!aD$b[\u0016DU-\u00193fe\u000e\u0013\u0018\u0010\u001d;")
public class GamePacketDecoderWotLK
extends GamePacketDecoder
implements GamePacketsWotLK {
    private final int SMSG_GM_MESSAGECHAT;
    private final int CMSG_KEEP_ALIVE;
    private final int SMSG_MOTD;

    @Override
    public int SMSG_GM_MESSAGECHAT() {
        return this.SMSG_GM_MESSAGECHAT;
    }

    @Override
    public int CMSG_KEEP_ALIVE() {
        return this.CMSG_KEEP_ALIVE;
    }

    @Override
    public void wowchat$game$GamePacketsWotLK$_setter_$SMSG_GM_MESSAGECHAT_$eq(int x$1) {
        this.SMSG_GM_MESSAGECHAT = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsWotLK$_setter_$CMSG_KEEP_ALIVE_$eq(int x$1) {
        this.CMSG_KEEP_ALIVE = x$1;
    }

    @Override
    public int SMSG_MOTD() {
        return this.SMSG_MOTD;
    }

    @Override
    public void wowchat$game$GamePacketsTBC$_setter_$SMSG_GM_MESSAGECHAT_$eq(int x$1) {
    }

    @Override
    public void wowchat$game$GamePacketsTBC$_setter_$SMSG_MOTD_$eq(int x$1) {
        this.SMSG_MOTD = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsTBC$_setter_$CMSG_KEEP_ALIVE_$eq(int x$1) {
    }

    @Override
    public Tuple2<Object, Object> parseGameHeaderEncrypted(ByteBuf in, GameHeaderCrypt crypt) {
        Tuple2$mcII$sp tuple2$mcII$sp;
        byte[] header = new byte[this.HEADER_LENGTH()];
        in.readBytes(header);
        byte[] decrypted = crypt.decrypt(header);
        if ((BoxesRunTime.unboxToByte(new ArrayOps.ofByte(Predef$.MODULE$.byteArrayOps(decrypted)).head()) & 0x80) == 128) {
            byte nextByte = BoxesRunTime.unboxToByte(new ArrayOps.ofByte(Predef$.MODULE$.byteArrayOps(crypt.decrypt(new byte[]{in.readByte()}))).head());
            int size = ((decrypted[0] & 0x7F) << 16 | (decrypted[1] & 0xFF) << 8 | decrypted[2] & 0xFF) - 2;
            int id = (nextByte & 0xFF) << 8 | decrypted[3] & 0xFF;
            tuple2$mcII$sp = new Tuple2$mcII$sp(id, size);
        } else {
            int size = ((decrypted[0] & 0xFF) << 8 | decrypted[1] & 0xFF) - 2;
            int id = (decrypted[3] & 0xFF) << 8 | decrypted[2] & 0xFF;
            tuple2$mcII$sp = new Tuple2$mcII$sp(id, size);
        }
        return tuple2$mcII$sp;
    }

    public GamePacketDecoderWotLK() {
        GamePacketsTBC.$init$(this);
        GamePacketsWotLK.$init$(this);
    }
}

