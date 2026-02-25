/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import scala.Predef$;
import scala.Serializable;
import scala.collection.mutable.ArrayOps;
import scala.reflect.ScalaSignature;
import scala.runtime.java8.JFunction1$mcVI$sp;

@ScalaSignature(bytes="\u0006\u0001\u00194A\u0001G\r\u0001=!)Q\u0005\u0001C\u0001M!9\u0011\u0006\u0001a\u0001\n#Q\u0003b\u0002\u0018\u0001\u0001\u0004%\tb\f\u0005\u0007k\u0001\u0001\u000b\u0015B\u0016\t\u000fY\u0002\u0001\u0019!C\u0005o!91\b\u0001a\u0001\n\u0013a\u0004B\u0002 \u0001A\u0003&\u0001\bC\u0004@\u0001\u0001\u0007I\u0011B\u001c\t\u000f\u0001\u0003\u0001\u0019!C\u0005\u0003\"11\t\u0001Q!\naBq\u0001\u0012\u0001A\u0002\u0013%q\u0007C\u0004F\u0001\u0001\u0007I\u0011\u0002$\t\r!\u0003\u0001\u0015)\u00039\u0011\u001dI\u0005\u00011A\u0005\n]BqA\u0013\u0001A\u0002\u0013%1\n\u0003\u0004N\u0001\u0001\u0006K\u0001\u000f\u0005\n\u001d\u0002\u0001\r\u00111A\u0005\u0012=C\u0011B\u0016\u0001A\u0002\u0003\u0007I\u0011C,\t\u0013e\u0003\u0001\u0019!A!B\u0013\u0001\u0006\"\u0002.\u0001\t\u0003Y\u0006\"\u00020\u0001\t\u0003y\u0006\"B1\u0001\t\u0003\u0011\u0007\"B3\u0001\t\u0003Q#aD$b[\u0016DU-\u00193fe\u000e\u0013\u0018\u0010\u001d;\u000b\u0005iY\u0012\u0001B4b[\u0016T\u0011\u0001H\u0001\bo><8\r[1u\u0007\u0001\u0019\"\u0001A\u0010\u0011\u0005\u0001\u001aS\"A\u0011\u000b\u0003\t\nQa]2bY\u0006L!\u0001J\u0011\u0003\r\u0005s\u0017PU3g\u0003\u0019a\u0014N\\5u}Q\tq\u0005\u0005\u0002)\u00015\t\u0011$\u0001\u0007`S:LG/[1mSj,G-F\u0001,!\t\u0001C&\u0003\u0002.C\t9!i\\8mK\u0006t\u0017\u0001E0j]&$\u0018.\u00197ju\u0016$w\fJ3r)\t\u00014\u0007\u0005\u0002!c%\u0011!'\t\u0002\u0005+:LG\u000fC\u00045\u0007\u0005\u0005\t\u0019A\u0016\u0002\u0007a$\u0013'A\u0007`S:LG/[1mSj,G\rI\u0001\b?N,g\u000eZ0j+\u0005A\u0004C\u0001\u0011:\u0013\tQ\u0014EA\u0002J]R\f1bX:f]\u0012|\u0016n\u0018\u0013fcR\u0011\u0001'\u0010\u0005\bi\u0019\t\t\u00111\u00019\u0003!y6/\u001a8e?&\u0004\u0013aB0tK:$wL[\u0001\f?N,g\u000eZ0k?\u0012*\u0017\u000f\u0006\u00021\u0005\"9A'CA\u0001\u0002\u0004A\u0014\u0001C0tK:$wL\u001b\u0011\u0002\u000f}\u0013Xm\u0019<`S\u0006YqL]3dm~Kw\fJ3r)\t\u0001t\tC\u00045\u0019\u0005\u0005\t\u0019\u0001\u001d\u0002\u0011}\u0013Xm\u0019<`S\u0002\nqa\u0018:fGZ|&.A\u0006`e\u0016\u001cgo\u00186`I\u0015\fHC\u0001\u0019M\u0011\u001d!t\"!AA\u0002a\n\u0001b\u0018:fGZ|&\u000eI\u0001\u0005?.,\u00170F\u0001Q!\r\u0001\u0013kU\u0005\u0003%\u0006\u0012Q!\u0011:sCf\u0004\"\u0001\t+\n\u0005U\u000b#\u0001\u0002\"zi\u0016\f\u0001bX6fs~#S-\u001d\u000b\u0003aaCq\u0001\u000e\n\u0002\u0002\u0003\u0007\u0001+A\u0003`W\u0016L\b%A\u0004eK\u000e\u0014\u0018\u0010\u001d;\u0015\u0005Ac\u0006\"B/\u0015\u0001\u0004\u0001\u0016\u0001\u00023bi\u0006\fq!\u001a8def\u0004H\u000f\u0006\u0002QA\")Q,\u0006a\u0001!\u0006!\u0011N\\5u)\t\u00014\rC\u0003e-\u0001\u0007\u0001+A\u0002lKf\fa![:J]&$\b")
public class GameHeaderCrypt {
    private boolean _initialized = false;
    private int _send_i = 0;
    private int _send_j = 0;
    private int _recv_i = 0;
    private int _recv_j = 0;
    private byte[] _key;

    public boolean _initialized() {
        return this._initialized;
    }

    public void _initialized_$eq(boolean x$1) {
        this._initialized = x$1;
    }

    private int _send_i() {
        return this._send_i;
    }

    private void _send_i_$eq(int x$1) {
        this._send_i = x$1;
    }

    private int _send_j() {
        return this._send_j;
    }

    private void _send_j_$eq(int x$1) {
        this._send_j = x$1;
    }

    private int _recv_i() {
        return this._recv_i;
    }

    private void _recv_i_$eq(int x$1) {
        this._recv_i = x$1;
    }

    private int _recv_j() {
        return this._recv_j;
    }

    private void _recv_j_$eq(int x$1) {
        this._recv_j = x$1;
    }

    public byte[] _key() {
        return this._key;
    }

    public void _key_$eq(byte[] x$1) {
        this._key = x$1;
    }

    public byte[] decrypt(byte[] data) {
        if (!this._initialized()) {
            return data;
        }
        new ArrayOps.ofByte(Predef$.MODULE$.byteArrayOps(data)).indices().foreach$mVc$sp((JFunction1$mcVI$sp & Serializable)i -> {
            this._recv_i_$eq(this._recv_i() % this._key().length);
            byte x = (byte)(data[i] - this._recv_j() ^ this._key()[this._recv_i()]);
            this._recv_i_$eq(this._recv_i() + 1);
            this._recv_j_$eq(data[i]);
            data$1[i] = x;
        });
        return data;
    }

    public byte[] encrypt(byte[] data) {
        if (!this._initialized()) {
            return data;
        }
        new ArrayOps.ofByte(Predef$.MODULE$.byteArrayOps(data)).indices().foreach$mVc$sp((JFunction1$mcVI$sp & Serializable)i -> {
            this._send_i_$eq(this._send_i() % this._key().length);
            byte x = (byte)((byte)(data[i] ^ this._key()[this._send_i()]) + this._send_j());
            this._send_i_$eq(this._send_i() + 1);
            data$2[i] = x;
            this._send_j_$eq(x);
        });
        return data;
    }

    public void init(byte[] key) {
        this._key_$eq(key);
        this._send_i_$eq(0);
        this._send_j_$eq(0);
        this._recv_i_$eq(0);
        this._recv_j_$eq(0);
        this._initialized_$eq(true);
    }

    public boolean isInit() {
        return this._initialized();
    }
}

