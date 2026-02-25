/*
 * Decompiled with CFR 0.152.
 */
package wowchat.realm;

import java.security.MessageDigest;
import scala.Array$;
import scala.Predef$;
import scala.Serializable;
import scala.collection.mutable.ArrayOps;
import scala.math.BigInt$;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ObjectRef;
import scala.runtime.RichInt$;
import scala.runtime.java8.JFunction1$mcVI$sp;
import wowchat.realm.BigNumber;
import wowchat.realm.BigNumber$;

@ScalaSignature(bytes="\u0006\u0001\u0005Ua\u0001B\u000f\u001f\u0001\rBQA\u000b\u0001\u0005\u0002-BqA\f\u0001A\u0002\u0013\u0005q\u0006C\u00044\u0001\u0001\u0007I\u0011\u0001\u001b\t\ri\u0002\u0001\u0015)\u00031\u0011\u001dY\u0004\u00011A\u0005\u0002=Bq\u0001\u0010\u0001A\u0002\u0013\u0005Q\b\u0003\u0004@\u0001\u0001\u0006K\u0001\r\u0005\n\u0001\u0002\u0001\r\u00111A\u0005\u0002=B\u0011\"\u0011\u0001A\u0002\u0003\u0007I\u0011\u0001\"\t\u0013\u0011\u0003\u0001\u0019!A!B\u0013\u0001\u0004\"C#\u0001\u0001\u0004\u0005\r\u0011\"\u00010\u0011%1\u0005\u00011AA\u0002\u0013\u0005q\tC\u0005J\u0001\u0001\u0007\t\u0011)Q\u0005a!I!\n\u0001a\u0001\u0002\u0004%\ta\f\u0005\n\u0017\u0002\u0001\r\u00111A\u0005\u00021C\u0011B\u0014\u0001A\u0002\u0003\u0005\u000b\u0015\u0002\u0019\t\u0013=\u0003\u0001\u0019!a\u0001\n\u0003y\u0003\"\u0003)\u0001\u0001\u0004\u0005\r\u0011\"\u0001R\u0011%\u0019\u0006\u00011A\u0001B\u0003&\u0001\u0007C\u0005U\u0001\u0001\u0007\t\u0019!C\u0001_!IQ\u000b\u0001a\u0001\u0002\u0004%\tA\u0016\u0005\n1\u0002\u0001\r\u0011!Q!\nABq!\u0017\u0001A\u0002\u0013\u0005!\fC\u0004d\u0001\u0001\u0007I\u0011\u00013\t\r\u0019\u0004\u0001\u0015)\u0003\\\u0011\u00159\u0007\u0001\"\u0001i\u0011\u0015y\u0007\u0001\"\u0001q\u0011\u001d\t\t\u0002\u0001C!\u0003'\u0011\u0011b\u0015*Q\u00072LWM\u001c;\u000b\u0005}\u0001\u0013!\u0002:fC2l'\"A\u0011\u0002\u000f]|wo\u00195bi\u000e\u00011C\u0001\u0001%!\t)\u0003&D\u0001'\u0015\u00059\u0013!B:dC2\f\u0017BA\u0015'\u0005\u0019\te.\u001f*fM\u00061A(\u001b8jiz\"\u0012\u0001\f\t\u0003[\u0001i\u0011AH\u0001\u0002WV\t\u0001\u0007\u0005\u0002.c%\u0011!G\b\u0002\n\u0005&<g*^7cKJ\fQa[0%KF$\"!\u000e\u001d\u0011\u0005\u00152\u0014BA\u001c'\u0005\u0011)f.\u001b;\t\u000fe\u001a\u0011\u0011!a\u0001a\u0005\u0019\u0001\u0010J\u0019\u0002\u0005-\u0004\u0013!A1\u0002\u000b\u0005|F%Z9\u0015\u0005Ur\u0004bB\u001d\u0007\u0003\u0003\u0005\r\u0001M\u0001\u0003C\u0002\n\u0011!Q\u0001\u0006\u0003~#S-\u001d\u000b\u0003k\rCq!O\u0005\u0002\u0002\u0003\u0007\u0001'\u0001\u0002BA\u0005\t\u00010A\u0003y?\u0012*\u0017\u000f\u0006\u00026\u0011\"9\u0011\bDA\u0001\u0002\u0004\u0001\u0014A\u0001=!\u0003\u0005i\u0015!B'`I\u0015\fHCA\u001bN\u0011\u001dIt\"!AA\u0002A\n!!\u0014\u0011\u0002\u0003M\u000bQaU0%KF$\"!\u000e*\t\u000fe\u0012\u0012\u0011!a\u0001a\u0005\u00111\u000bI\u0001\u0002\u0017\u0006)1j\u0018\u0013fcR\u0011Qg\u0016\u0005\bsU\t\t\u00111\u00011\u0003\tY\u0005%\u0001\u0002nIV\t1\f\u0005\u0002]C6\tQL\u0003\u0002_?\u0006A1/Z2ve&$\u0018PC\u0001a\u0003\u0011Q\u0017M^1\n\u0005\tl&!D'fgN\fw-\u001a#jO\u0016\u001cH/\u0001\u0004nI~#S-\u001d\u000b\u0003k\u0015Dq!\u000f\r\u0002\u0002\u0003\u00071,A\u0002nI\u0002\nacZ3oKJ\fG/\u001a%bg\"dunZ8o!J|wNZ\u000b\u0002SB\u0019QE\u001b7\n\u0005-4#!B!se\u0006L\bCA\u0013n\u0013\tqgE\u0001\u0003CsR,\u0017!B:uKB\fDcC\u001brg\u0006\u0005\u0011QAA\u0005\u0003\u001bAQA]\u000eA\u0002%\fq!Y2d_VtG\u000fC\u0003u7\u0001\u0007Q/\u0001\u0005qCN\u001cxo\u001c:e!\t1XP\u0004\u0002xwB\u0011\u0001PJ\u0007\u0002s*\u0011!PI\u0001\u0007yI|w\u000e\u001e \n\u0005q4\u0013A\u0002)sK\u0012,g-\u0003\u0002\u007f\u007f\n11\u000b\u001e:j]\u001eT!\u0001 \u0014\t\r\u0005\r1\u00041\u00011\u0003\u0005\u0011\u0005BBA\u00047\u0001\u0007\u0001'A\u0001h\u0011\u0019\tYa\u0007a\u0001a\u0005\ta\n\u0003\u0004\u0002\u0010m\u0001\r\u0001M\u0001\u0002g\u0006AAo\\*ue&tw\rF\u0001v\u0001")
public class SRPClient {
    private BigNumber k = BigNumber$.MODULE$.apply(BigInt$.MODULE$.int2bigInt(3));
    private BigNumber a = BigNumber$.MODULE$.rand(19);
    private BigNumber A;
    private BigNumber x;
    private BigNumber M;
    private BigNumber S;
    private BigNumber K;
    private MessageDigest md = MessageDigest.getInstance("SHA1");

    public BigNumber k() {
        return this.k;
    }

    public void k_$eq(BigNumber x$1) {
        this.k = x$1;
    }

    public BigNumber a() {
        return this.a;
    }

    public void a_$eq(BigNumber x$1) {
        this.a = x$1;
    }

    public BigNumber A() {
        return this.A;
    }

    public void A_$eq(BigNumber x$1) {
        this.A = x$1;
    }

    public BigNumber x() {
        return this.x;
    }

    public void x_$eq(BigNumber x$1) {
        this.x = x$1;
    }

    public BigNumber M() {
        return this.M;
    }

    public void M_$eq(BigNumber x$1) {
        this.M = x$1;
    }

    public BigNumber S() {
        return this.S;
    }

    public void S_$eq(BigNumber x$1) {
        this.S = x$1;
    }

    public BigNumber K() {
        return this.K;
    }

    public void K_$eq(BigNumber x$1) {
        this.K = x$1;
    }

    public MessageDigest md() {
        return this.md;
    }

    public void md_$eq(MessageDigest x$1) {
        this.md = x$1;
    }

    public byte[] generateHashLogonProof() {
        BigNumber qual$1 = this.A();
        int x$1 = 32;
        boolean x$2 = qual$1.asByteArray$default$2();
        this.md().update(qual$1.asByteArray(x$1, x$2));
        this.md().update(this.M().asByteArray(20, false));
        BigNumber qual$2 = this.K();
        int x$3 = 40;
        boolean x$4 = qual$2.asByteArray$default$2();
        this.md().update(qual$2.asByteArray(x$3, x$4));
        return this.md().digest();
    }

    public void step1(byte[] account, String password, BigNumber B, BigNumber g, BigNumber N, BigNumber s) {
        String passwordUpper = password.toUpperCase();
        this.A_$eq(g.modPow(this.a(), N));
        BigNumber qual$1 = this.A();
        int x$1 = 32;
        boolean x$2 = qual$1.asByteArray$default$2();
        this.md().update(qual$1.asByteArray(x$1, x$2));
        this.md().update(B.asByteArray(32, B.asByteArray$default$2()));
        BigNumber u = BigNumber$.MODULE$.apply(this.md().digest(), true);
        byte[] user = (byte[])new ArrayOps.ofByte(Predef$.MODULE$.byteArrayOps((byte[])new ArrayOps.ofByte(Predef$.MODULE$.byteArrayOps(account)).$colon$plus(BoxesRunTime.boxToByte((byte)58), ClassTag$.MODULE$.Byte()))).$plus$plus(new ArrayOps.ofByte(Predef$.MODULE$.byteArrayOps(passwordUpper.getBytes("UTF-8"))), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Byte()));
        this.md().update(user);
        byte[] p = this.md().digest();
        this.md().update(s.asByteArray(32, s.asByteArray$default$2()));
        this.md().update(p);
        BigNumber x = BigNumber$.MODULE$.apply(this.md().digest(), true);
        this.S_$eq(B.$minus(g.modPow(x, N).$times(this.k())).modPow(this.a().$plus(u.$times(x)), N));
        BigNumber qual$2 = this.S();
        int x$3 = 32;
        boolean x$4 = qual$2.asByteArray$default$2();
        byte[] t = qual$2.asByteArray(x$3, x$4);
        byte[] t1 = new byte[16];
        byte[] t2 = new byte[16];
        byte[] vK = new byte[40];
        RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), 16).foreach$mVc$sp((JFunction1$mcVI$sp & Serializable)i -> {
            t1$1[i] = t[i * 2];
            t2$1[i] = t[i * 2 + 1];
        });
        this.md().update(t1);
        ObjectRef<byte[]> digest = ObjectRef.create(this.md().digest());
        RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), 20).foreach$mVc$sp((JFunction1$mcVI$sp & Serializable)i -> {
            vK$1[i * 2] = ((byte[])digest$1.elem)[i];
        });
        this.md().update(t2);
        digest.elem = this.md().digest();
        RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), 20).foreach$mVc$sp((JFunction1$mcVI$sp & Serializable)i -> {
            vK$1[i * 2 + 1] = ((byte[])digest$1.elem)[i];
        });
        this.md().update(N.asByteArray(32, N.asByteArray$default$2()));
        byte[] hash = this.md().digest();
        this.md().update(g.asByteArray(1, g.asByteArray$default$2()));
        digest.elem = this.md().digest();
        RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), 20).foreach$mVc$sp((JFunction1$mcVI$sp & Serializable)i -> {
            hash$1[i] = (byte)(hash[i] ^ ((byte[])digest$1.elem)[i]);
        });
        this.md().update(account);
        byte[] t4 = this.md().digest();
        this.K_$eq(BigNumber$.MODULE$.apply(vK, true));
        BigNumber t3 = BigNumber$.MODULE$.apply(hash, true);
        BigNumber t4_correct = BigNumber$.MODULE$.apply(t4, true);
        this.md().update(t3.asByteArray(20, t3.asByteArray$default$2()));
        this.md().update(t4_correct.asByteArray(20, t4_correct.asByteArray$default$2()));
        this.md().update(s.asByteArray(32, s.asByteArray$default$2()));
        BigNumber qual$3 = this.A();
        int x$5 = 32;
        boolean x$6 = qual$3.asByteArray$default$2();
        this.md().update(qual$3.asByteArray(x$5, x$6));
        this.md().update(B.asByteArray(32, B.asByteArray$default$2()));
        BigNumber qual$4 = this.K();
        int x$7 = 40;
        boolean x$8 = qual$4.asByteArray$default$2();
        this.md().update(qual$4.asByteArray(x$7, x$8));
        this.M_$eq(BigNumber$.MODULE$.apply(this.md().digest(), BigNumber$.MODULE$.apply$default$2()));
    }

    public String toString() {
        return new StringBuilder(29).append("SRPClient(").append("k=").append(this.k().toHexString()).append(", ").append("A=").append(this.A().toHexString()).append(", ").append("M=").append(this.M().toHexString()).append(", ").append("S=").append(this.S().toHexString()).append(", ").append("K=").append(this.K().toHexString()).append(")").toString();
    }
}

