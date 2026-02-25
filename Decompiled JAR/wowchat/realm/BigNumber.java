/*
 * Decompiled with CFR 0.152.
 */
package wowchat.realm;

import scala.Predef$;
import scala.Serializable;
import scala.math.BigInt;
import scala.reflect.ScalaSignature;
import scala.runtime.ObjectRef;
import scala.runtime.RichInt$;
import scala.runtime.java8.JFunction1$mcVI$sp;
import wowchat.realm.BigNumber$;

@ScalaSignature(bytes="\u0006\u0001\u0005Eq!B\u000b\u0017\u0011\u0003Yb!B\u000f\u0017\u0011\u0003q\u0002\"B\u0013\u0002\t\u00031\u0003\"B\u0014\u0002\t\u0003A\u0003\"B\u0014\u0002\t\u0003I\b\"B\u0014\u0002\t\u0003Y\b\"B\u0014\u0002\t\u0003y\b\u0002CA\u0004\u0003E\u0005I\u0011A;\t\u000f\u0005%\u0011\u0001\"\u0001\u0002\f\u0019!QD\u0006\u0001+\u0011!Y\u0013B!b\u0001\n\u0013a\u0003\u0002C\u001d\n\u0005\u0003\u0005\u000b\u0011B\u0017\t\u000b\u0015JA\u0011\u0001\u001e\t\u000bqJA\u0011A\u001f\t\u000b\u0001KA\u0011A!\t\u000b\rKA\u0011\u0001#\t\u000b\u0019KA\u0011A$\t\u000b1KA\u0011A'\t\u000bYKA\u0011A,\t\u000f!L\u0011\u0013!C\u0001S\"9A/CI\u0001\n\u0003)\u0018!\u0003\"jO:+XNY3s\u0015\t9\u0002$A\u0003sK\u0006dWNC\u0001\u001a\u0003\u001d9xn^2iCR\u001c\u0001\u0001\u0005\u0002\u001d\u00035\taCA\u0005CS\u001etU/\u001c2feN\u0011\u0011a\b\t\u0003A\rj\u0011!\t\u0006\u0002E\u0005)1oY1mC&\u0011A%\t\u0002\u0007\u0003:L(+\u001a4\u0002\rqJg.\u001b;?)\u0005Y\u0012!B1qa2LHCA\u0015x!\ta\u0012b\u0005\u0002\n?\u00051!-[4J]R,\u0012!\f\t\u0003]Yr!a\f\u001b\u000f\u0005A\u001aT\"A\u0019\u000b\u0005IR\u0012A\u0002\u001fs_>$h(C\u0001#\u0013\t)\u0014%A\u0004qC\u000e\\\u0017mZ3\n\u0005]B$A\u0002\"jO&sGO\u0003\u00026C\u00059!-[4J]R\u0004CCA\u0015<\u0011\u0015YC\u00021\u0001.\u0003\u0019!C/[7fgR\u0011\u0011F\u0010\u0005\u0006\u007f5\u0001\r!K\u0001\u0007]Vl'-\u001a:\u0002\r\u0011j\u0017N\\;t)\tI#\tC\u0003@\u001d\u0001\u0007\u0011&A\u0003%a2,8\u000f\u0006\u0002*\u000b\")qh\u0004a\u0001S\u00051Qn\u001c3Q_^$2!\u000b%K\u0011\u0015I\u0005\u00031\u0001*\u0003\u00111\u0018\r\\\u0019\t\u000b-\u0003\u0002\u0019A\u0015\u0002\tY\fGNM\u0001\fi>DU\r_*ue&tw-F\u0001O!\ty5K\u0004\u0002Q#B\u0011\u0001'I\u0005\u0003%\u0006\na\u0001\u0015:fI\u00164\u0017B\u0001+V\u0005\u0019\u0019FO]5oO*\u0011!+I\u0001\fCN\u0014\u0015\u0010^3BeJ\f\u0017\u0010F\u0002Y=\u000e\u00042\u0001I-\\\u0013\tQ\u0016EA\u0003BeJ\f\u0017\u0010\u0005\u0002!9&\u0011Q,\t\u0002\u0005\u0005f$X\rC\u0004`%A\u0005\t\u0019\u00011\u0002\u000fI,\u0017oU5{KB\u0011\u0001%Y\u0005\u0003E\u0006\u00121!\u00138u\u0011\u001d!'\u0003%AA\u0002\u0015\fqA]3wKJ\u001cX\r\u0005\u0002!M&\u0011q-\t\u0002\b\u0005>|G.Z1o\u0003U\t7OQ=uK\u0006\u0013(/Y=%I\u00164\u0017-\u001e7uIE*\u0012A\u001b\u0016\u0003A.\\\u0013\u0001\u001c\t\u0003[Jl\u0011A\u001c\u0006\u0003_B\f\u0011\"\u001e8dQ\u0016\u001c7.\u001a3\u000b\u0005E\f\u0013AC1o]>$\u0018\r^5p]&\u00111O\u001c\u0002\u0012k:\u001c\u0007.Z2lK\u00124\u0016M]5b]\u000e,\u0017!F1t\u0005f$X-\u0011:sCf$C-\u001a4bk2$HEM\u000b\u0002m*\u0012Qm\u001b\u0005\u0006q\u000e\u0001\r!L\u0001\u0006m\u0006dW/\u001a\u000b\u0003SiDQ\u0001\u001f\u0003A\u00029#2!\u000b?~\u0011\u0015AX\u00011\u0001O\u0011\u0015qX\u00011\u0001a\u0003\u0015\u0011\u0018\rZ5y)\u0015I\u0013\u0011AA\u0003\u0011\u0019\t\u0019A\u0002a\u00011\u0006)\u0011M\u001d:bs\"9AM\u0002I\u0001\u0002\u0004)\u0017aD1qa2LH\u0005Z3gCVdG\u000f\n\u001a\u0002\tI\fg\u000e\u001a\u000b\u0004S\u00055\u0001BBA\b\u0011\u0001\u0007\u0001-\u0001\u0004b[>,h\u000e\u001e")
public class BigNumber {
    private final BigInt bigInt;

    public static BigNumber rand(int n) {
        return BigNumber$.MODULE$.rand(n);
    }

    public static boolean apply$default$2() {
        return BigNumber$.MODULE$.apply$default$2();
    }

    public static BigNumber apply(byte[] byArray, boolean bl) {
        return BigNumber$.MODULE$.apply(byArray, bl);
    }

    public static BigNumber apply(String string, int n) {
        return BigNumber$.MODULE$.apply(string, n);
    }

    public static BigNumber apply(String string) {
        return BigNumber$.MODULE$.apply(string);
    }

    public static BigNumber apply(BigInt bigInt) {
        return BigNumber$.MODULE$.apply(bigInt);
    }

    private BigInt bigInt() {
        return this.bigInt;
    }

    public BigNumber $times(BigNumber number) {
        return new BigNumber(this.bigInt().$times(number.bigInt().abs()));
    }

    public BigNumber $minus(BigNumber number) {
        return new BigNumber(this.bigInt().$minus(number.bigInt().abs()));
    }

    public BigNumber $plus(BigNumber number) {
        return new BigNumber(this.bigInt().$plus(number.bigInt().abs()));
    }

    public BigNumber modPow(BigNumber val1, BigNumber val2) {
        return new BigNumber(this.bigInt().modPow(val1.bigInt().abs(), val2.bigInt().abs()));
    }

    public String toHexString() {
        return this.bigInt().toString(16).toUpperCase();
    }

    public byte[] asByteArray(int reqSize, boolean reverse) {
        ObjectRef<byte[]> array = ObjectRef.create(this.bigInt().toByteArray());
        if (((byte[])array.elem)[0] == 0) {
            byte[] tmp = new byte[((byte[])array.elem).length - 1];
            System.arraycopy((byte[])array.elem, 1, tmp, 0, tmp.length);
            array.elem = tmp;
        }
        int length = ((byte[])array.elem).length;
        if (reverse) {
            RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), length / 2).foreach$mVc$sp((JFunction1$mcVI$sp & Serializable)i -> {
                byte j = ((byte[])array$2.elem)[i];
                ((byte[])array$2.elem)[i] = ((byte[])array$2.elem)[length - 1 - i];
                ((byte[])array$2.elem)[length$2 - 1 - i] = j;
            });
        }
        if (reqSize > length) {
            byte[] newArray = new byte[reqSize];
            System.arraycopy((byte[])array.elem, 0, newArray, 0, length);
            return newArray;
        }
        return (byte[])array.elem;
    }

    public int asByteArray$default$1() {
        return 0;
    }

    public boolean asByteArray$default$2() {
        return true;
    }

    public BigNumber(BigInt bigInt) {
        this.bigInt = bigInt;
    }
}

