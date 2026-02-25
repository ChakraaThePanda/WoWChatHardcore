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
import wowchat.game.RC4;

@ScalaSignature(bytes="\u0006\u0001!3Aa\u0004\t\u0001+!)!\u0004\u0001C\u00017!IQ\u0004\u0001a\u0001\u0002\u0004%IA\b\u0005\nE\u0001\u0001\r\u00111A\u0005\n\rB\u0011\u0002\f\u0001A\u0002\u0003\u0005\u000b\u0015B\u0010\t\u00135\u0002\u0001\u0019!a\u0001\n\u0013q\u0002\"\u0003\u0018\u0001\u0001\u0004\u0005\r\u0011\"\u00030\u0011%\t\u0004\u00011A\u0001B\u0003&q\u0004C\u00043\u0001\t\u0007I\u0011C\u001a\t\ri\u0002\u0001\u0015!\u00035\u0011\u001dY\u0004A1A\u0005\u0012MBa\u0001\u0010\u0001!\u0002\u0013!\u0004\"B\u001f\u0001\t\u0003r\u0004\"B!\u0001\t\u0003\u0012\u0005\"\u0002#\u0001\t\u0003*%\u0001F$b[\u0016DU-\u00193fe\u000e\u0013\u0018\u0010\u001d;X_Rd5J\u0003\u0002\u0012%\u0005!q-Y7f\u0015\u0005\u0019\u0012aB<po\u000eD\u0017\r^\u0002\u0001'\t\u0001a\u0003\u0005\u0002\u001815\t\u0001#\u0003\u0002\u001a!\tyq)Y7f\u0011\u0016\fG-\u001a:Def\u0004H/\u0001\u0004=S:LGO\u0010\u000b\u00029A\u0011q\u0003A\u0001\fG2LWM\u001c;Def\u0004H/F\u0001 !\t9\u0002%\u0003\u0002\"!\t\u0019!k\u0011\u001b\u0002\u001f\rd\u0017.\u001a8u\u0007JL\b\u000f^0%KF$\"\u0001\n\u0016\u0011\u0005\u0015BS\"\u0001\u0014\u000b\u0003\u001d\nQa]2bY\u0006L!!\u000b\u0014\u0003\tUs\u0017\u000e\u001e\u0005\bW\r\t\t\u00111\u0001 \u0003\rAH%M\u0001\rG2LWM\u001c;Def\u0004H\u000fI\u0001\fg\u0016\u0014h/\u001a:Def\u0004H/A\btKJ4XM]\"ssB$x\fJ3r)\t!\u0003\u0007C\u0004,\r\u0005\u0005\t\u0019A\u0010\u0002\u0019M,'O^3s\u0007JL\b\u000f\u001e\u0011\u0002\u001dM,'O^3s\u00116\f7mU3fIV\tA\u0007E\u0002&k]J!A\u000e\u0014\u0003\u000b\u0005\u0013(/Y=\u0011\u0005\u0015B\u0014BA\u001d'\u0005\u0011\u0011\u0015\u0010^3\u0002\u001fM,'O^3s\u00116\f7mU3fI\u0002\nab\u00197jK:$\b*\\1d'\u0016,G-A\bdY&,g\u000e\u001e%nC\u000e\u001cV-\u001a3!\u0003\u001d!Wm\u0019:zaR$\"\u0001N \t\u000b\u0001c\u0001\u0019\u0001\u001b\u0002\t\u0011\fG/Y\u0001\bK:\u001c'/\u001f9u)\t!4\tC\u0003A\u001b\u0001\u0007A'\u0001\u0003j]&$HC\u0001\u0013G\u0011\u00159e\u00021\u00015\u0003\rYW-\u001f")
public class GameHeaderCryptWotLK
extends GameHeaderCrypt {
    private RC4 clientCrypt;
    private RC4 serverCrypt;
    private final byte[] serverHmacSeed = (byte[])new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(new int[]{204, 152, 174, 4, 232, 151, 234, 202, 18, 221, 192, 147, 66, 145, 83, 87})).map((Function1<Object, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToByte(GameHeaderCryptWotLK.$anonfun$serverHmacSeed$1(BoxesRunTime.unboxToInt(x$1))), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Byte()));
    private final byte[] clientHmacSeed = (byte[])new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(new int[]{194, 179, 114, 60, 198, 174, 217, 181, 52, 60, 83, 238, 47, 67, 103, 206})).map((Function1<Object, Object> & java.io.Serializable & Serializable)x$2 -> BoxesRunTime.boxToByte(GameHeaderCryptWotLK.$anonfun$clientHmacSeed$1(BoxesRunTime.unboxToInt(x$2))), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Byte()));

    private RC4 clientCrypt() {
        return this.clientCrypt;
    }

    private void clientCrypt_$eq(RC4 x$1) {
        this.clientCrypt = x$1;
    }

    private RC4 serverCrypt() {
        return this.serverCrypt;
    }

    private void serverCrypt_$eq(RC4 x$1) {
        this.serverCrypt = x$1;
    }

    public byte[] serverHmacSeed() {
        return this.serverHmacSeed;
    }

    public byte[] clientHmacSeed() {
        return this.clientHmacSeed;
    }

    @Override
    public byte[] decrypt(byte[] data) {
        if (!this._initialized()) {
            return data;
        }
        return this.serverCrypt().cryptToByteArray(data);
    }

    @Override
    public byte[] encrypt(byte[] data) {
        if (!this._initialized()) {
            return data;
        }
        return this.clientCrypt().cryptToByteArray(data);
    }

    @Override
    public void init(byte[] key) {
        Mac md = Mac.getInstance("HmacSHA1");
        md.init(new SecretKeySpec(this.serverHmacSeed(), "HmacSHA1"));
        md.update(key);
        byte[] serverKey = md.doFinal();
        md.init(new SecretKeySpec(this.clientHmacSeed(), "HmacSHA1"));
        md.update(key);
        byte[] clientKey = md.doFinal();
        this.serverCrypt_$eq(new RC4(serverKey));
        this.serverCrypt().cryptToByteArray(new byte[1024]);
        this.clientCrypt_$eq(new RC4(clientKey));
        this.clientCrypt().cryptToByteArray(new byte[1024]);
        this._initialized_$eq(true);
    }

    public static final /* synthetic */ byte $anonfun$serverHmacSeed$1(int x$1) {
        return (byte)x$1;
    }

    public static final /* synthetic */ byte $anonfun$clientHmacSeed$1(int x$2) {
        return (byte)x$2;
    }
}

