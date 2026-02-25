/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game.warden;

import scala.reflect.ScalaSignature;
import wowchat.game.warden.WardenPackets$;

@ScalaSignature(bytes="\u0006\u0001-;Qa\u0007\u000f\t\u0002\r2Q!\n\u000f\t\u0002\u0019BQ!L\u0001\u0005\u00029BqaL\u0001C\u0002\u0013\u0005\u0001\u0007\u0003\u00045\u0003\u0001\u0006I!\r\u0005\bk\u0005\u0011\r\u0011\"\u00011\u0011\u00191\u0014\u0001)A\u0005c!9q'\u0001b\u0001\n\u0003\u0001\u0004B\u0002\u001d\u0002A\u0003%\u0011\u0007C\u0004:\u0003\t\u0007I\u0011\u0001\u0019\t\ri\n\u0001\u0015!\u00032\u0011\u001dY\u0014A1A\u0005\u0002ABa\u0001P\u0001!\u0002\u0013\t\u0004bB\u001f\u0002\u0005\u0004%\t\u0001\r\u0005\u0007}\u0005\u0001\u000b\u0011B\u0019\t\u000f}\n!\u0019!C\u0001a!1\u0001)\u0001Q\u0001\nEBq!Q\u0001C\u0002\u0013\u0005\u0001\u0007\u0003\u0004C\u0003\u0001\u0006I!\r\u0005\b\u0007\u0006\u0011\r\u0011\"\u00011\u0011\u0019!\u0015\u0001)A\u0005c!9Q)\u0001b\u0001\n\u0003\u0001\u0004B\u0002$\u0002A\u0003%\u0011\u0007C\u0004H\u0003\t\u0007I\u0011\u0001\u0019\t\r!\u000b\u0001\u0015!\u00032\u0011\u001dI\u0015A1A\u0005\u0002ABaAS\u0001!\u0002\u0013\t\u0014!D,be\u0012,g\u000eU1dW\u0016$8O\u0003\u0002\u001e=\u00051q/\u0019:eK:T!a\b\u0011\u0002\t\u001d\fW.\u001a\u0006\u0002C\u00059qo\\<dQ\u0006$8\u0001\u0001\t\u0003I\u0005i\u0011\u0001\b\u0002\u000e/\u0006\u0014H-\u001a8QC\u000e\\W\r^:\u0014\u0005\u00059\u0003C\u0001\u0015,\u001b\u0005I#\"\u0001\u0016\u0002\u000bM\u001c\u0017\r\\1\n\u00051J#AB!osJ+g-\u0001\u0004=S:LGO\u0010\u000b\u0002G\u0005Qr+\u0011*E\u000b:{6)T*H?6{E)\u0016'F?6K5kU%O\u000fV\t\u0011\u0007\u0005\u0002)e%\u00111'\u000b\u0002\u0004\u0013:$\u0018aG,B%\u0012+ejX\"N'\u001e{Vj\u0014#V\u0019\u0016{V*S*T\u0013:;\u0005%A\u000bX\u0003J#UIT0D\u001bN;u,T(E+2+ulT&\u0002-]\u000b%\u000bR#O?\u000ek5kR0N\u001f\u0012+F*R0P\u0017\u0002\nqdV!S\t\u0016sulQ'T\u000f~\u001b\u0005*R!U?\u000eCUiQ&T?J+5+\u0016'U\u0003\u0001:\u0016I\u0015#F\u001d~\u001bUjU$`\u0007\"+\u0015\tV0D\u0011\u0016\u001b5jU0S\u000bN+F\n\u0016\u0011\u0002;]\u000b%\u000bR#O?\u000ek5kR0N\u000b6{6\tS#D\u0017N{&+R*V\u0019R\u000badV!S\t\u0016sulQ'T\u000f~kU)T0D\u0011\u0016\u001b5jU0S\u000bN+F\n\u0016\u0011\u0002/]\u000b%\u000bR#O?\u000ek5kR0I\u0003NCuLU#T+2#\u0016\u0001G,B%\u0012+ejX\"N'\u001e{\u0006*Q*I?J+5+\u0016'UA\u0005Ir+\u0011*E\u000b:{6)T*H?6{E)\u0016'F?\u001a\u000b\u0015\nT#E\u0003i9\u0016I\u0015#F\u001d~\u001bUjU$`\u001b>#U\u000bT#`\r\u0006KE*\u0012#!\u0003Y9\u0016I\u0015#F\u001d~\u001bVjU$`\u001b>#U\u000bT#`+N+\u0015aF,B%\u0012+ejX*N'\u001e{Vj\u0014#V\u0019\u0016{VkU#!\u0003a9\u0016I\u0015#F\u001d~\u001bVjU$`\u001b>#U\u000bT#`\u0007\u0006\u001b\u0005*R\u0001\u001a/\u0006\u0013F)\u0012(`'6\u001bviX'P\tVcUiX\"B\u0007\"+\u0005%\u0001\u0011X\u0003J#UIT0T\u001bN;ul\u0011%F\u0003R{6\tS#D\u0017N{&+R)V\u000bN#\u0016!I,B%\u0012+ejX*N'\u001e{6\tS#B)~\u001b\u0005*R\"L'~\u0013V)U+F'R\u0003\u0013!H,B%\u0012+ejX*N'\u001e{Vj\u0014#V\u0019\u0016{\u0016JT%U\u0013\u0006c\u0015JW#\u0002=]\u000b%\u000bR#O?Nk5kR0N\u001f\u0012+F*R0J\u001d&#\u0016*\u0011'J5\u0016\u0003\u0013AH,B%\u0012+ejX*N'\u001e{V*R'`\u0007\"+5iS*`%\u0016\u000bV+R*U\u0003}9\u0016I\u0015#F\u001d~\u001bVjU$`\u001b\u0016kul\u0011%F\u0007.\u001bvLU#R+\u0016\u001bF\u000bI\u0001\u0019/\u0006\u0013F)\u0012(`'6\u001bvi\u0018%B'\"{&+R)V\u000bN#\u0016!G,B%\u0012+ejX*N'\u001e{\u0006*Q*I?J+\u0015+V#T)\u0002\u0002")
public final class WardenPackets {
    public static int WARDEN_SMSG_HASH_REQUEST() {
        return WardenPackets$.MODULE$.WARDEN_SMSG_HASH_REQUEST();
    }

    public static int WARDEN_SMSG_MEM_CHECKS_REQUEST() {
        return WardenPackets$.MODULE$.WARDEN_SMSG_MEM_CHECKS_REQUEST();
    }

    public static int WARDEN_SMSG_MODULE_INITIALIZE() {
        return WardenPackets$.MODULE$.WARDEN_SMSG_MODULE_INITIALIZE();
    }

    public static int WARDEN_SMSG_CHEAT_CHECKS_REQUEST() {
        return WardenPackets$.MODULE$.WARDEN_SMSG_CHEAT_CHECKS_REQUEST();
    }

    public static int WARDEN_SMSG_MODULE_CACHE() {
        return WardenPackets$.MODULE$.WARDEN_SMSG_MODULE_CACHE();
    }

    public static int WARDEN_SMSG_MODULE_USE() {
        return WardenPackets$.MODULE$.WARDEN_SMSG_MODULE_USE();
    }

    public static int WARDEN_CMSG_MODULE_FAILED() {
        return WardenPackets$.MODULE$.WARDEN_CMSG_MODULE_FAILED();
    }

    public static int WARDEN_CMSG_HASH_RESULT() {
        return WardenPackets$.MODULE$.WARDEN_CMSG_HASH_RESULT();
    }

    public static int WARDEN_CMSG_MEM_CHECKS_RESULT() {
        return WardenPackets$.MODULE$.WARDEN_CMSG_MEM_CHECKS_RESULT();
    }

    public static int WARDEN_CMSG_CHEAT_CHECKS_RESULT() {
        return WardenPackets$.MODULE$.WARDEN_CMSG_CHEAT_CHECKS_RESULT();
    }

    public static int WARDEN_CMSG_MODULE_OK() {
        return WardenPackets$.MODULE$.WARDEN_CMSG_MODULE_OK();
    }

    public static int WARDEN_CMSG_MODULE_MISSING() {
        return WardenPackets$.MODULE$.WARDEN_CMSG_MODULE_MISSING();
    }
}

