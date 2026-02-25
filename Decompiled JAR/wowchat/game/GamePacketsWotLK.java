/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import scala.reflect.ScalaSignature;
import wowchat.game.GamePacketsTBC;

@ScalaSignature(bytes="\u0006\u0001\u00012q\u0001B\u0003\u0011\u0002\u0007\u0005!\u0002C\u0003\u0016\u0001\u0011\u0005a\u0003C\u0004\u001b\u0001\t\u0007I\u0011I\u000e\t\u000f}\u0001!\u0019!C!7\t\u0001r)Y7f!\u0006\u001c7.\u001a;t/>$Hj\u0013\u0006\u0003\r\u001d\tAaZ1nK*\t\u0001\"A\u0004x_^\u001c\u0007.\u0019;\u0004\u0001M\u0019\u0001aC\t\u0011\u00051yQ\"A\u0007\u000b\u00039\tQa]2bY\u0006L!\u0001E\u0007\u0003\r\u0005s\u0017PU3g!\t\u00112#D\u0001\u0006\u0013\t!RA\u0001\bHC6,\u0007+Y2lKR\u001cHKQ\"\u0002\r\u0011Jg.\u001b;%)\u00059\u0002C\u0001\u0007\u0019\u0013\tIRB\u0001\u0003V]&$\u0018aE*N'\u001e{v)T0N\u000bN\u001b\u0016iR#D\u0011\u0006#V#\u0001\u000f\u0011\u00051i\u0012B\u0001\u0010\u000e\u0005\rIe\u000e^\u0001\u0010\u00076\u001bviX&F\u000bB{\u0016\tT%W\u000b\u0002")
public interface GamePacketsWotLK
extends GamePacketsTBC {
    public void wowchat$game$GamePacketsWotLK$_setter_$SMSG_GM_MESSAGECHAT_$eq(int var1);

    public void wowchat$game$GamePacketsWotLK$_setter_$CMSG_KEEP_ALIVE_$eq(int var1);

    @Override
    public int SMSG_GM_MESSAGECHAT();

    @Override
    public int CMSG_KEEP_ALIVE();

    public static void $init$(GamePacketsWotLK $this) {
        $this.wowchat$game$GamePacketsWotLK$_setter_$SMSG_GM_MESSAGECHAT_$eq(947);
        $this.wowchat$game$GamePacketsWotLK$_setter_$CMSG_KEEP_ALIVE_$eq(1031);
    }
}

