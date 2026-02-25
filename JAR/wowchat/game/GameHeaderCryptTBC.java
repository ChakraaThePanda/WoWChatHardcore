/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import scala.Array$;
import scala.Function1;
import scala.Predef$;
import scala.Serializable;
import scala.collection.mutable.ArrayOps;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import wowchat.game.GameHeaderCrypt;

@ScalaSignature(bytes="\u0006\u0001\u00052Aa\u0001\u0003\u0001\u0013!)a\u0002\u0001C\u0001\u001f!)\u0011\u0003\u0001C!%\t\u0011r)Y7f\u0011\u0016\fG-\u001a:Def\u0004H\u000f\u0016\"D\u0015\t)a!\u0001\u0003hC6,'\"A\u0004\u0002\u000f]|wo\u00195bi\u000e\u00011C\u0001\u0001\u000b!\tYA\"D\u0001\u0005\u0013\tiAAA\bHC6,\u0007*Z1eKJ\u001c%/\u001f9u\u0003\u0019a\u0014N\\5u}Q\t\u0001\u0003\u0005\u0002\f\u0001\u0005!\u0011N\\5u)\t\u0019\u0012\u0004\u0005\u0002\u0015/5\tQCC\u0001\u0017\u0003\u0015\u00198-\u00197b\u0013\tARC\u0001\u0003V]&$\b\"\u0002\u000e\u0003\u0001\u0004Y\u0012aA6fsB\u0019A\u0003\b\u0010\n\u0005u)\"!B!se\u0006L\bC\u0001\u000b \u0013\t\u0001SC\u0001\u0003CsR,\u0007")
public class GameHeaderCryptTBC
extends GameHeaderCrypt {
    @Override
    public void init(byte[] key) {
        super.init(key);
        byte[] hmacSeed = (byte[])new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(new int[]{56, 167, 131, 21, 248, 146, 37, 48, 113, 152, 103, 177, 140, 4, 226, 170})).map((Function1<Object, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToByte(GameHeaderCryptTBC.$anonfun$init$1(BoxesRunTime.unboxToInt(x$1))), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Byte()));
        Mac md = Mac.getInstance("HmacSHA1");
        md.init(new SecretKeySpec(hmacSeed, "HmacSHA1"));
        md.update(key);
        this._key_$eq(md.doFinal());
    }

    public static final /* synthetic */ byte $anonfun$init$1(int x$1) {
        return (byte)x$1;
    }
}

