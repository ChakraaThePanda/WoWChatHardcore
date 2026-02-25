/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import scala.Array$;
import scala.Function1;
import scala.Predef$;
import scala.Serializable;
import scala.collection.mutable.ArrayOps;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import wowchat.game.GameHeaderCryptWotLK;

@ScalaSignature(bytes="\u0006\u0001\t2AAB\u0004\u0001\u0019!)\u0011\u0003\u0001C\u0001%!9A\u0003\u0001b\u0001\n#*\u0002BB\u0010\u0001A\u0003%a\u0003C\u0004!\u0001\t\u0007I\u0011K\u000b\t\r\u0005\u0002\u0001\u0015!\u0003\u0017\u0005I9\u0015-\\3IK\u0006$WM]\"ssB$Xj\u001c)\u000b\u0005!I\u0011\u0001B4b[\u0016T\u0011AC\u0001\bo><8\r[1u\u0007\u0001\u0019\"\u0001A\u0007\u0011\u00059yQ\"A\u0004\n\u0005A9!\u0001F$b[\u0016DU-\u00193fe\u000e\u0013\u0018\u0010\u001d;X_Rd5*\u0001\u0004=S:LGO\u0010\u000b\u0002'A\u0011a\u0002A\u0001\u000fg\u0016\u0014h/\u001a:I[\u0006\u001c7+Z3e+\u00051\u0002cA\f\u001b95\t\u0001DC\u0001\u001a\u0003\u0015\u00198-\u00197b\u0013\tY\u0002DA\u0003BeJ\f\u0017\u0010\u0005\u0002\u0018;%\u0011a\u0004\u0007\u0002\u0005\u0005f$X-A\btKJ4XM\u001d%nC\u000e\u001cV-\u001a3!\u00039\u0019G.[3oi\"k\u0017mY*fK\u0012\fqb\u00197jK:$\b*\\1d'\u0016,G\r\t")
public class GameHeaderCryptMoP
extends GameHeaderCryptWotLK {
    private final byte[] serverHmacSeed = (byte[])new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(new int[]{8, 241, 149, 159, 71, 229, 210, 219, 161, 61, 119, 143, 63, 62, 231, 0})).map((Function1<Object, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToByte(GameHeaderCryptMoP.$anonfun$serverHmacSeed$1(BoxesRunTime.unboxToInt(x$1))), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Byte()));
    private final byte[] clientHmacSeed = (byte[])new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(new int[]{64, 170, 211, 146, 38, 113, 67, 71, 58, 49, 8, 166, 231, 220, 152, 42})).map((Function1<Object, Object> & java.io.Serializable & Serializable)x$2 -> BoxesRunTime.boxToByte(GameHeaderCryptMoP.$anonfun$clientHmacSeed$1(BoxesRunTime.unboxToInt(x$2))), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Byte()));

    @Override
    public byte[] serverHmacSeed() {
        return this.serverHmacSeed;
    }

    @Override
    public byte[] clientHmacSeed() {
        return this.clientHmacSeed;
    }

    public static final /* synthetic */ byte $anonfun$serverHmacSeed$1(int x$1) {
        return (byte)x$1;
    }

    public static final /* synthetic */ byte $anonfun$clientHmacSeed$1(int x$2) {
        return (byte)x$2;
    }
}

