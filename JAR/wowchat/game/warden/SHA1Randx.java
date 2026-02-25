/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game.warden;

import java.security.MessageDigest;
import scala.Function1;
import scala.Predef$;
import scala.Serializable;
import scala.collection.TraversableOnce;
import scala.collection.immutable.IndexedSeq$;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.RichInt$;

@ScalaSignature(bytes="\u0006\u0001a3Aa\u0005\u000b\u00017!A!\u0005\u0001B\u0001B\u0003%1\u0005C\u0003*\u0001\u0011\u0005!\u0006C\u0004/\u0001\t\u0007I\u0011B\u0018\t\ra\u0002\u0001\u0015!\u00031\u0011\u001dI\u0004A1A\u0005\niBaA\u0010\u0001!\u0002\u0013Y\u0004bB \u0001\u0005\u0004%I\u0001\u0011\u0005\u0007\u0003\u0002\u0001\u000b\u0011B\u0012\t\u000f\t\u0003!\u0019!C\u0005\u0001\"11\t\u0001Q\u0001\n\rBq\u0001\u0012\u0001A\u0002\u0013%\u0001\tC\u0004F\u0001\u0001\u0007I\u0011\u0002$\t\r1\u0003\u0001\u0015)\u0003$\u0011\u001di\u0005\u00011A\u0005\niBqA\u0014\u0001A\u0002\u0013%q\n\u0003\u0004R\u0001\u0001\u0006Ka\u000f\u0005\u0006%\u0002!Ia\u0015\u0005\u0006)\u0002!\t!\u0016\u0002\n'\"\u000b\u0015GU1oIbT!!\u0006\f\u0002\r]\f'\u000fZ3o\u0015\t9\u0002$\u0001\u0003hC6,'\"A\r\u0002\u000f]|wo\u00195bi\u000e\u00011C\u0001\u0001\u001d!\ti\u0002%D\u0001\u001f\u0015\u0005y\u0012!B:dC2\f\u0017BA\u0011\u001f\u0005\u0019\te.\u001f*fM\u0006Q1/Z:tS>t7*Z=\u0011\u0007u!c%\u0003\u0002&=\t)\u0011I\u001d:bsB\u0011QdJ\u0005\u0003Qy\u0011AAQ=uK\u00061A(\u001b8jiz\"\"aK\u0017\u0011\u00051\u0002Q\"\u0001\u000b\t\u000b\t\u0012\u0001\u0019A\u0012\u0002\u00055$W#\u0001\u0019\u0011\u0005E2T\"\u0001\u001a\u000b\u0005M\"\u0014\u0001C:fGV\u0014\u0018\u000e^=\u000b\u0003U\nAA[1wC&\u0011qG\r\u0002\u000e\u001b\u0016\u001c8/Y4f\t&<Wm\u001d;\u0002\u00075$\u0007%A\u0006lKfD\u0015\r\u001c4TSj,W#A\u001e\u0011\u0005ua\u0014BA\u001f\u001f\u0005\rIe\u000e^\u0001\rW\u0016L\b*\u00197g'&TX\rI\u0001\u0003_F*\u0012aI\u0001\u0004_F\u0002\u0013AA83\u0003\ry'\u0007I\u0001\u0003_B\naa\u001c\u0019`I\u0015\fHCA$K!\ti\u0002*\u0003\u0002J=\t!QK\\5u\u0011\u001dYE\"!AA\u0002\r\n1\u0001\u001f\u00132\u0003\ry\u0007\u0007I\u0001\u0006S:$W\r_\u0001\nS:$W\r_0%KF$\"a\u0012)\t\u000f-{\u0011\u0011!a\u0001w\u00051\u0011N\u001c3fq\u0002\naAZ5mYV\u0003X#A$\u0002\u0011\u001d,g.\u001a:bi\u0016$\"a\t,\t\u000b]\u0013\u0002\u0019A\u001e\u0002\tML'0\u001a")
public class SHA1Randx {
    private final MessageDigest md = MessageDigest.getInstance("SHA1");
    private final int keyHalfSize;
    private final byte[] o1;
    private final byte[] o2;
    private byte[] o0;
    private int index;

    private MessageDigest md() {
        return this.md;
    }

    private int keyHalfSize() {
        return this.keyHalfSize;
    }

    private byte[] o1() {
        return this.o1;
    }

    private byte[] o2() {
        return this.o2;
    }

    private byte[] o0() {
        return this.o0;
    }

    private void o0_$eq(byte[] x$1) {
        this.o0 = x$1;
    }

    private int index() {
        return this.index;
    }

    private void index_$eq(int x$1) {
        this.index = x$1;
    }

    private void fillUp() {
        this.md().update(this.o1());
        this.md().update(this.o0());
        this.md().update(this.o2());
        this.o0_$eq(this.md().digest());
        this.index_$eq(0);
    }

    public byte[] generate(int size) {
        return (byte[])((TraversableOnce)RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), size).map((Function1<Object, Object> & java.io.Serializable & Serializable)i -> BoxesRunTime.boxToByte(SHA1Randx.$anonfun$generate$1(this, BoxesRunTime.unboxToInt(i))), IndexedSeq$.MODULE$.canBuildFrom())).toArray(ClassTag$.MODULE$.Byte());
    }

    /*
     * WARNING - void declaration
     */
    public static final /* synthetic */ byte $anonfun$generate$1(SHA1Randx $this, int i) {
        void var2_2;
        if ($this.index() >= $this.o0().length) {
            $this.fillUp();
        }
        byte ret = $this.o0()[$this.index()];
        $this.index_$eq($this.index() + 1);
        return (byte)var2_2;
    }

    public SHA1Randx(byte[] sessionKey) {
        this.keyHalfSize = sessionKey.length / 2;
        this.md().update(sessionKey, 0, this.keyHalfSize());
        this.o1 = this.md().digest();
        this.md().update(sessionKey, this.keyHalfSize(), this.keyHalfSize());
        this.o2 = this.md().digest();
        this.o0 = new byte[20];
        this.index = 0;
        this.fillUp();
    }
}

