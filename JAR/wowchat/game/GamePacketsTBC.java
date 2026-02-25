/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import scala.reflect.ScalaSignature;
import wowchat.game.GamePackets;

@ScalaSignature(bytes="\u0006\u0001\t2q!\u0002\u0004\u0011\u0002\u0007\u00051\u0002C\u0003\u0017\u0001\u0011\u0005q\u0003C\u0004\u001c\u0001\t\u0007I\u0011\u0001\u000f\t\u000f\u0001\u0002!\u0019!C\u00019!9\u0011\u0005\u0001b\u0001\n\u0003a\"AD$b[\u0016\u0004\u0016mY6fiN$&i\u0011\u0006\u0003\u000f!\tAaZ1nK*\t\u0011\"A\u0004x_^\u001c\u0007.\u0019;\u0004\u0001M\u0019\u0001\u0001\u0004\n\u0011\u00055\u0001R\"\u0001\b\u000b\u0003=\tQa]2bY\u0006L!!\u0005\b\u0003\r\u0005s\u0017PU3g!\t\u0019B#D\u0001\u0007\u0013\t)bAA\u0006HC6,\u0007+Y2lKR\u001c\u0018A\u0002\u0013j]&$H\u0005F\u0001\u0019!\ti\u0011$\u0003\u0002\u001b\u001d\t!QK\\5u\u0003M\u0019VjU$`\u000f6{V*R*T\u0003\u001e+5\tS!U+\u0005i\u0002CA\u0007\u001f\u0013\tybBA\u0002J]R\f\u0011bU'T\u000f~ku\n\u0016#\u0002\u001f\rk5kR0L\u000b\u0016\u0003v,\u0011'J-\u0016\u0003")
public interface GamePacketsTBC
extends GamePackets {
    public void wowchat$game$GamePacketsTBC$_setter_$SMSG_GM_MESSAGECHAT_$eq(int var1);

    public void wowchat$game$GamePacketsTBC$_setter_$SMSG_MOTD_$eq(int var1);

    public void wowchat$game$GamePacketsTBC$_setter_$CMSG_KEEP_ALIVE_$eq(int var1);

    public int SMSG_GM_MESSAGECHAT();

    public int SMSG_MOTD();

    public int CMSG_KEEP_ALIVE();

    public static void $init$(GamePacketsTBC $this) {
        $this.wowchat$game$GamePacketsTBC$_setter_$SMSG_GM_MESSAGECHAT_$eq(946);
        $this.wowchat$game$GamePacketsTBC$_setter_$SMSG_MOTD_$eq(829);
        $this.wowchat$game$GamePacketsTBC$_setter_$CMSG_KEEP_ALIVE_$eq(1030);
    }
}

