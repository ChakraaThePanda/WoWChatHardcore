/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import io.netty.buffer.ByteBuf;
import scala.reflect.ScalaSignature;
import wowchat.common.ByteUtils$;

@ScalaSignature(bytes="\u0006\u0001\u0005\rq!B\t\u0013\u0011\u00039b!B\r\u0013\u0011\u0003Q\u0002\"B\u0011\u0002\t\u0003\u0011\u0003\"B\u0012\u0002\t\u0003!\u0003\"\u0002\u0019\u0002\t\u0003\t\u0004\"B\u001a\u0002\t\u0003!\u0004\"B\u001c\u0002\t\u0003A\u0004\"\u0002\u001e\u0002\t\u0003Y\u0004\"B!\u0002\t\u0003\u0011\u0005\"\u0002#\u0002\t\u0003)\u0005\"B*\u0002\t\u0003!\u0006\"B,\u0002\t\u0003A\u0006\"\u0002.\u0002\t\u0003Y\u0006\"\u0002.\u0002\t\u0003i\u0006bB9\u0002#\u0003%\tA\u001d\u0005\b{\u0006\t\n\u0011\"\u0001s\u0011\u0015q\u0018\u0001\"\u0001\u0000\u0003%\u0011\u0015\u0010^3Vi&d7O\u0003\u0002\u0014)\u000511m\\7n_:T\u0011!F\u0001\bo><8\r[1u\u0007\u0001\u0001\"\u0001G\u0001\u000e\u0003I\u0011\u0011BQ=uKV#\u0018\u000e\\:\u0014\u0005\u0005Y\u0002C\u0001\u000f \u001b\u0005i\"\"\u0001\u0010\u0002\u000bM\u001c\u0017\r\\1\n\u0005\u0001j\"AB!osJ+g-\u0001\u0004=S:LGO\u0010\u000b\u0002/\u0005a1\u000f[8siR{')\u001f;fgR\u0011Qe\u000b\t\u00049\u0019B\u0013BA\u0014\u001e\u0005\u0015\t%O]1z!\ta\u0012&\u0003\u0002+;\t!!)\u001f;f\u0011\u0015a3\u00011\u0001.\u0003\u0015\u0019\bn\u001c:u!\tab&\u0003\u00020;\t\u0019\u0011J\u001c;\u0002\u001dMDwN\u001d;U_\nKH/Z:M\u000bR\u0011QE\r\u0005\u0006Y\u0011\u0001\r!L\u0001\u000bS:$Hk\u001c\"zi\u0016\u001cHCA\u00136\u0011\u00151T\u00011\u0001.\u0003\rIg\u000e^\u0001\rS:$Hk\u001c\"zi\u0016\u001cH*\u0012\u000b\u0003KeBQA\u000e\u0004A\u00025\n1\u0002\\8oOR{')\u001f;fgR\u0011Q\u0005\u0010\u0005\u0006{\u001d\u0001\rAP\u0001\u0005Y>tw\r\u0005\u0002\u001d\u007f%\u0011\u0001)\b\u0002\u0005\u0019>tw-A\u0007m_:<Gk\u001c\"zi\u0016\u001cH*\u0012\u000b\u0003K\rCQ!\u0010\u0005A\u0002y\n1b\u001d;sS:<Gk\\%oiR\u0011QF\u0012\u0005\u0006\u000f&\u0001\r\u0001S\u0001\u0004gR\u0014\bCA%Q\u001d\tQe\n\u0005\u0002L;5\tAJ\u0003\u0002N-\u00051AH]8pizJ!aT\u000f\u0002\rA\u0013X\rZ3g\u0013\t\t&K\u0001\u0004TiJLgn\u001a\u0006\u0003\u001fv\t1BY=uKN$v\u000eT8oOR\u0011a(\u0016\u0005\u0006-*\u0001\r!J\u0001\u0006Ef$Xm]\u0001\u000eEf$Xm\u001d+p\u0019>tw\rT#\u0015\u0005yJ\u0006\"\u0002,\f\u0001\u0004)\u0013a\u0003;p\u0011\u0016D8\u000b\u001e:j]\u001e$\"\u0001\u0013/\t\u000bYc\u0001\u0019A\u0013\u0015\t!s&n\u001c\u0005\u0006?6\u0001\r\u0001Y\u0001\bEf$XMQ;g!\t\t\u0007.D\u0001c\u0015\t\u0019G-\u0001\u0004ck\u001a4WM\u001d\u0006\u0003K\u001a\fQA\\3uifT\u0011aZ\u0001\u0003S>L!!\u001b2\u0003\u000f\tKH/\u001a\"vM\"91.\u0004I\u0001\u0002\u0004a\u0017!C1eIN\u0003\u0018mY3t!\taR.\u0003\u0002o;\t9!i\\8mK\u0006t\u0007b\u00029\u000e!\u0003\u0005\r\u0001\\\u0001\u0011e\u0016\u001cx\u000e\u001c<f!2\f\u0017N\u001c+fqR\fQ\u0003^8IKb\u001cFO]5oO\u0012\"WMZ1vYR$#'F\u0001tU\taGoK\u0001v!\t180D\u0001x\u0015\tA\u00180A\u0005v]\u000eDWmY6fI*\u0011!0H\u0001\u000bC:tw\u000e^1uS>t\u0017B\u0001?x\u0005E)hn\u00195fG.,GMV1sS\u0006t7-Z\u0001\u0016i>DU\r_*ue&tw\r\n3fM\u0006,H\u000e\u001e\u00134\u00039!xNQ5oCJL8\u000b\u001e:j]\u001e$2\u0001SA\u0001\u0011\u0015y\u0006\u00031\u0001a\u0001")
public final class ByteUtils {
    public static String toBinaryString(ByteBuf byteBuf) {
        return ByteUtils$.MODULE$.toBinaryString(byteBuf);
    }

    public static boolean toHexString$default$3() {
        return ByteUtils$.MODULE$.toHexString$default$3();
    }

    public static boolean toHexString$default$2() {
        return ByteUtils$.MODULE$.toHexString$default$2();
    }

    public static String toHexString(ByteBuf byteBuf, boolean bl, boolean bl2) {
        return ByteUtils$.MODULE$.toHexString(byteBuf, bl, bl2);
    }

    public static String toHexString(byte[] byArray) {
        return ByteUtils$.MODULE$.toHexString(byArray);
    }

    public static long bytesToLongLE(byte[] byArray) {
        return ByteUtils$.MODULE$.bytesToLongLE(byArray);
    }

    public static long bytesToLong(byte[] byArray) {
        return ByteUtils$.MODULE$.bytesToLong(byArray);
    }

    public static int stringToInt(String string) {
        return ByteUtils$.MODULE$.stringToInt(string);
    }

    public static byte[] longToBytesLE(long l) {
        return ByteUtils$.MODULE$.longToBytesLE(l);
    }

    public static byte[] longToBytes(long l) {
        return ByteUtils$.MODULE$.longToBytes(l);
    }

    public static byte[] intToBytesLE(int n) {
        return ByteUtils$.MODULE$.intToBytesLE(n);
    }

    public static byte[] intToBytes(int n) {
        return ByteUtils$.MODULE$.intToBytes(n);
    }

    public static byte[] shortToBytesLE(int n) {
        return ByteUtils$.MODULE$.shortToBytesLE(n);
    }

    public static byte[] shortToBytes(int n) {
        return ByteUtils$.MODULE$.shortToBytes(n);
    }
}

