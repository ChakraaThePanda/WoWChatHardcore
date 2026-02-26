/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import scala.Predef$;
import scala.Serializable;
import scala.collection.mutable.ArrayOps;
import scala.reflect.ScalaSignature;
import scala.runtime.IntRef;
import scala.runtime.RichInt$;
import scala.runtime.java8.JFunction1$mcVI$sp;

@ScalaSignature(bytes="\u0006\u0001\r4Aa\u0005\u000b\u00013!A\u0001\u0005\u0001B\u0001B\u0003%\u0011\u0005C\u0003(\u0001\u0011\u0005\u0001\u0006C\u0004-\u0001\t\u0007I\u0011B\u0017\t\rE\u0002\u0001\u0015!\u0003/\u0011\u001d\u0011\u0004A1A\u0005\nMBa!\u000e\u0001!\u0002\u0013!\u0004b\u0002\u001c\u0001\u0001\u0004%I!\f\u0005\bo\u0001\u0001\r\u0011\"\u00039\u0011\u0019q\u0004\u0001)Q\u0005]!9q\b\u0001a\u0001\n\u0013i\u0003b\u0002!\u0001\u0001\u0004%I!\u0011\u0005\u0007\u0007\u0002\u0001\u000b\u0015\u0002\u0018\t\u000b\u0011\u0003A\u0011A#\t\u000b!\u0003A\u0011A%\t\u000b!\u0003A\u0011A+\t\u000b!\u0003A\u0011A,\t\u000bm\u0003A\u0011\u0002/\t\u000by\u0003A\u0011B0\u0003\u0007I\u001bEG\u0003\u0002\u0016-\u0005!q-Y7f\u0015\u00059\u0012aB<po\u000eD\u0017\r^\u0002\u0001'\t\u0001!\u0004\u0005\u0002\u001c=5\tADC\u0001\u001e\u0003\u0015\u00198-\u00197b\u0013\tyBD\u0001\u0004B]f\u0014VMZ\u0001\u0004W\u0016L\bcA\u000e#I%\u00111\u0005\b\u0002\u0006\u0003J\u0014\u0018-\u001f\t\u00037\u0015J!A\n\u000f\u0003\t\tKH/Z\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0005%Z\u0003C\u0001\u0016\u0001\u001b\u0005!\u0002\"\u0002\u0011\u0003\u0001\u0004\t\u0013aC*C\u001fb{F*\u0012(H)\"+\u0012A\f\t\u00037=J!\u0001\r\u000f\u0003\u0007%sG/\u0001\u0007T\u0005>Cv\fT#O\u000fRC\u0005%\u0001\u0003tE>DX#\u0001\u001b\u0011\u0007m\u0011c&A\u0003tE>D\b%A\u0001j\u0003\u0015Iw\fJ3r)\tID\b\u0005\u0002\u001cu%\u00111\b\b\u0002\u0005+:LG\u000fC\u0004>\u0011\u0005\u0005\t\u0019\u0001\u0018\u0002\u0007a$\u0013'\u0001\u0002jA\u0005\t!.A\u0003k?\u0012*\u0017\u000f\u0006\u0002:\u0005\"9QhCA\u0001\u0002\u0004q\u0013A\u00016!\u0003A\u0019'/\u001f9u)>\u0014\u0015\u0010^3BeJ\f\u0017\u0010\u0006\u0002\"\r\")q)\u0004a\u0001C\u0005\u0019Qn]4\u0002\u000b\r\u0014\u0018\u0010\u001d;\u0015\u0005)#\u0006CA&S\u001b\u0005a%BA'O\u0003\u0019\u0011WO\u001a4fe*\u0011q\nU\u0001\u0006]\u0016$H/\u001f\u0006\u0002#\u0006\u0011\u0011n\\\u0005\u0003'2\u0013qAQ=uK\n+h\rC\u0003H\u001d\u0001\u0007\u0011\u0005\u0006\u0002K-\")qi\u0004a\u0001IQ\u0019!\nW-\t\u000b\u001d\u0003\u0002\u0019\u0001&\t\u000bi\u0003\u0002\u0019\u0001\u0018\u0002\r1,gn\u001a;i\u0003!Ig.\u001b;T\u0005>DHC\u0001\u001b^\u0011\u0015\u0001\u0013\u00031\u0001\"\u0003\u0011\u0019x/\u00199\u0015\te\u0002\u0017M\u0019\u0005\u0006mI\u0001\rA\f\u0005\u0006\u007fI\u0001\rA\f\u0005\u0006eI\u0001\r\u0001\u000e")
public class RC4 {
    private final int SBOX_LENGTH;
    private final int[] sbox;
    private int i;
    private int j;

    private int SBOX_LENGTH() {
        return this.SBOX_LENGTH;
    }

    private int[] sbox() {
        return this.sbox;
    }

    private int i() {
        return this.i;
    }

    private void i_$eq(int x$1) {
        this.i = x$1;
    }

    private int j() {
        return this.j;
    }

    private void j_$eq(int x$1) {
        this.j = x$1;
    }

    /*
     * WARNING - void declaration
     */
    public byte[] cryptToByteArray(byte[] msg) {
        void var2_2;
        byte[] code = new byte[msg.length];
        new ArrayOps.ofByte(Predef$.MODULE$.byteArrayOps(msg)).indices().foreach$mVc$sp((JFunction1$mcVI$sp & Serializable)n -> {
            this.i_$eq((this.i() + 1) % this.SBOX_LENGTH());
            this.j_$eq((this.j() + this.sbox()[this.i()]) % this.SBOX_LENGTH());
            this.swap(this.i(), this.j(), this.sbox());
            int rand = this.sbox()[(this.sbox()[this.i()] + this.sbox()[this.j()]) % this.SBOX_LENGTH()];
            code$1[n] = (byte)(rand ^ msg[n]);
        });
        return var2_2;
    }

    public ByteBuf crypt(byte[] msg) {
        ByteBuf byteBuf = PooledByteBufAllocator.DEFAULT.buffer(msg.length, msg.length);
        return byteBuf.writeBytes(this.cryptToByteArray(msg));
    }

    public ByteBuf crypt(byte msg) {
        return this.crypt(new byte[]{msg});
    }

    public ByteBuf crypt(ByteBuf msg, int length) {
        byte[] arr = new byte[length];
        msg.readBytes(arr);
        return this.crypt(arr);
    }

    /*
     * WARNING - void declaration
     */
    private int[] initSBox(byte[] key) {
        void var2_2;
        int[] sbox = new int[this.SBOX_LENGTH()];
        IntRef j = IntRef.create(0);
        RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), this.SBOX_LENGTH()).foreach$mVc$sp((JFunction1$mcVI$sp & Serializable)i -> {
            sbox$1[i] = i;
        });
        RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), this.SBOX_LENGTH()).foreach$mVc$sp((JFunction1$mcVI$sp & Serializable)i -> {
            j$1.elem = (j$1.elem + sbox[i] + key[i % key.length] + this.SBOX_LENGTH()) % this.SBOX_LENGTH();
            this.swap(i, j$1.elem, sbox);
        });
        return var2_2;
    }

    private void swap(int i, int j, int[] sbox) {
        int temp = sbox[i];
        sbox[i] = sbox[j];
        sbox[j] = temp;
    }

    public RC4(byte[] key) {
        this.SBOX_LENGTH = 256;
        this.sbox = this.initSBox(key);
        this.i = 0;
        this.j = 0;
    }
}

