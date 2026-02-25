/*
 * Decompiled with CFR 0.152.
 */
package scala.util;

import scala.Function0;
import scala.Predef$;
import scala.Serializable;
import scala.collection.GenTraversable;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.Growable;
import scala.collection.immutable.List$;
import scala.collection.immutable.Range;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Stream$;
import scala.collection.immutable.Stream$cons$;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.Builder;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.RichInt$;
import scala.runtime.java8.JFunction0$mcC$sp;
import scala.util.Random$;

@ScalaSignature(bytes="\u0006\u0001\u0005ud\u0001B\r\u001b\u0001}A\u0001b\n\u0001\u0003\u0006\u0004%\t\u0001\u000b\u0005\t_\u0001\u0011\t\u0011)A\u0005S!)\u0001\u0007\u0001C\u0001c!)\u0001\u0007\u0001C\u0001k!)\u0001\u0007\u0001C\u0001w!)\u0001\u0007\u0001C\u0001\u0001\")\u0011\t\u0001C\u0001\u0005\")a\t\u0001C\u0001\u000f\")1\u000b\u0001C\u0001)\")\u0001\f\u0001C\u00013\")Q\f\u0001C\u0001)\")a\f\u0001C\u0001?\")a\f\u0001C\u0001A\")1\r\u0001C\u0001I\")Q\r\u0001C\u0001M\")A\u000f\u0001C\u0001k\")\u0011\u0010\u0001C\u0001u\")A\u0010\u0001C\u0001{\"9\u0011Q\n\u0001\u0005\u0002\u0005=saBA/5!\u0005\u0011q\f\u0004\u00073iA\t!!\u0019\t\rA*B\u0011AA2\u0011\u001d\t)'\u0006C\u0002\u0003OB\u0011\"!\u001c\u0016\u0003\u0003%I!a\u001c\u0003\rI\u000bg\u000eZ8n\u0015\tYB$\u0001\u0003vi&d'\"A\u000f\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001M\u0019\u0001\u0001\t\u0013\u0011\u0005\u0005\u0012S\"\u0001\u000f\n\u0005\rb\"AB!osJ+g\r\u0005\u0002\"K%\u0011a\u0005\b\u0002\r'\u0016\u0014\u0018.\u00197ju\u0006\u0014G.Z\u0001\u0005g\u0016dg-F\u0001*!\tQc&D\u0001,\u0015\tYBFC\u0001.\u0003\u0011Q\u0017M^1\n\u0005eY\u0013!B:fY\u001a\u0004\u0013A\u0002\u001fj]&$h\b\u0006\u00023iA\u00111\u0007A\u0007\u00025!)qe\u0001a\u0001SQ\u0011!G\u000e\u0005\u0006o\u0011\u0001\r\u0001O\u0001\u0005g\u0016,G\r\u0005\u0002\"s%\u0011!\b\b\u0002\u0005\u0019>tw\r\u0006\u00023y!)q'\u0002a\u0001{A\u0011\u0011EP\u0005\u0003\u007fq\u00111!\u00138u)\u0005\u0011\u0014a\u00038fqR\u0014un\u001c7fC:$\u0012a\u0011\t\u0003C\u0011K!!\u0012\u000f\u0003\u000f\t{w\u000e\\3b]\u0006Ia.\u001a=u\u0005f$Xm\u001d\u000b\u0003\u0011.\u0003\"!I%\n\u0005)c\"\u0001B+oSRDQ\u0001\u0014\u0005A\u00025\u000bQAY=uKN\u00042!\t(Q\u0013\tyEDA\u0003BeJ\f\u0017\u0010\u0005\u0002\"#&\u0011!\u000b\b\u0002\u0005\u0005f$X-\u0001\u0006oKb$Hi\\;cY\u0016$\u0012!\u0016\t\u0003CYK!a\u0016\u000f\u0003\r\u0011{WO\u00197f\u0003%qW\r\u001f;GY>\fG\u000fF\u0001[!\t\t3,\u0003\u0002]9\t)a\t\\8bi\u0006aa.\u001a=u\u000f\u0006,8o]5b]\u00069a.\u001a=u\u0013:$H#A\u001f\u0015\u0005u\n\u0007\"\u00022\u000e\u0001\u0004i\u0014!\u00018\u0002\u00119,\u0007\u0010\u001e'p]\u001e$\u0012\u0001O\u0001\u000b]\u0016DHo\u0015;sS:<GCA4s!\tAwN\u0004\u0002j[B\u0011!\u000eH\u0007\u0002W*\u0011ANH\u0001\u0007yI|w\u000e\u001e \n\u00059d\u0012A\u0002)sK\u0012,g-\u0003\u0002qc\n11\u000b\u001e:j]\u001eT!A\u001c\u000f\t\u000bM|\u0001\u0019A\u001f\u0002\r1,gn\u001a;i\u0003EqW\r\u001f;Qe&tG/\u00192mK\u000eC\u0017M\u001d\u000b\u0002mB\u0011\u0011e^\u0005\u0003qr\u0011Aa\u00115be\u000691/\u001a;TK\u0016$GC\u0001%|\u0011\u00159\u0014\u00031\u00019\u0003\u001d\u0019\b.\u001e4gY\u0016,RA`A\u0019\u0003\u000b!2a`A%)\u0011\t\t!!\u000e\u0011\r\u0005\r\u0011QAA\u0018\u0019\u0001!q!a\u0002\u0013\u0005\u0004\tIA\u0001\u0002D\u0007V!\u00111BA\u0012#\u0011\ti!a\u0005\u0011\u0007\u0005\ny!C\u0002\u0002\u0012q\u0011qAT8uQ&tw\r\u0005\u0004\u0002\u0016\u0005m\u0011\u0011\u0005\b\u0004C\u0005]\u0011bAA\r9\u00059\u0001/Y2lC\u001e,\u0017\u0002BA\u000f\u0003?\u0011q\u0002\u0016:bm\u0016\u00148/\u00192mK>s7-\u001a\u0006\u0004\u00033a\u0002\u0003BA\u0002\u0003G!\u0001\"!\n\u0002\u0006\t\u0007\u0011q\u0005\u0002\u00021F!\u0011QBA\u0015!\r\t\u00131F\u0005\u0004\u0003[a\"aA!osB!\u00111AA\u0019\t\u001d\t\u0019D\u0005b\u0001\u0003O\u0011\u0011\u0001\u0016\u0005\b\u0003o\u0011\u00029AA\u001d\u0003\t\u0011g\r\u0005\u0006\u0002<\u0005\u0015\u0013\u0011AA\u0018\u0003\u0003i!!!\u0010\u000b\t\u0005}\u0012\u0011I\u0001\bO\u0016tWM]5d\u0015\r\t\u0019\u0005H\u0001\u000bG>dG.Z2uS>t\u0017\u0002BA$\u0003{\u0011AbQ1o\u0005VLG\u000e\u001a$s_6Dq!a\u0013\u0013\u0001\u0004\t\t!\u0001\u0002yg\u0006a\u0011\r\u001c9iC:,X.\u001a:jGV\u0011\u0011\u0011\u000b\t\u0006\u0003'\nIF^\u0007\u0003\u0003+RA!a\u0016\u0002B\u0005I\u0011.\\7vi\u0006\u0014G.Z\u0005\u0005\u00037\n)F\u0001\u0004TiJ,\u0017-\\\u0001\u0007%\u0006tGm\\7\u0011\u0005M*2CA\u000b3)\t\ty&\u0001\nkCZ\f'+\u00198e_6$vNU1oI>lGc\u0001\u001a\u0002j!1\u00111N\fA\u0002%\n\u0011A]\u0001\fe\u0016\fGMU3t_24X\r\u0006\u0002\u0002rA!\u00111OA=\u001b\t\t)HC\u0002\u0002x1\nA\u0001\\1oO&!\u00111PA;\u0005\u0019y%M[3di\u0002")
public class Random
implements Serializable {
    private final java.util.Random self;

    public static Random javaRandomToRandom(java.util.Random random) {
        return Random$.MODULE$.javaRandomToRandom(random);
    }

    public java.util.Random self() {
        return this.self;
    }

    public boolean nextBoolean() {
        return this.self().nextBoolean();
    }

    public void nextBytes(byte[] bytes) {
        this.self().nextBytes(bytes);
    }

    public double nextDouble() {
        return this.self().nextDouble();
    }

    public float nextFloat() {
        return this.self().nextFloat();
    }

    public double nextGaussian() {
        return this.self().nextGaussian();
    }

    public int nextInt() {
        return this.self().nextInt();
    }

    public int nextInt(int n) {
        return this.self().nextInt(n);
    }

    public long nextLong() {
        return this.self().nextLong();
    }

    public String nextString(int length) {
        List$ list$ = List$.MODULE$;
        if (list$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)list$).newBuilder();
        fill_b.sizeHint(length);
        for (int fill_i = 0; fill_i < length; ++fill_i) {
            fill_b.$plus$eq(BoxesRunTime.boxToCharacter(this.safeChar$1()));
        }
        return ((TraversableOnce)((Object)((GenTraversable)fill_b.result()))).mkString();
    }

    public char nextPrintableChar() {
        int low = 33;
        int high = 127;
        return (char)(this.self().nextInt(high - low) + low);
    }

    public void setSeed(long seed) {
        this.self().setSeed(seed);
    }

    public <T, CC extends TraversableOnce<Object>> CC shuffle(CC xs, CanBuildFrom<CC, T, CC> bf) {
        Growable buf = new ArrayBuffer().$plus$plus$eq((TraversableOnce)xs);
        int n = ((ArrayBuffer)buf).length();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        Range range = RichInt$.MODULE$.to$extension0(n, 2).by(-1);
        if (range == null) {
            throw null;
        }
        Range foreach$mVc$sp_this = range;
        if (!foreach$mVc$sp_this.isEmpty()) {
            int foreach$mVc$sp_i = foreach$mVc$sp_this.start();
            while (true) {
                Random.$anonfun$shuffle$1(this, (ArrayBuffer)buf, foreach$mVc$sp_i);
                if (foreach$mVc$sp_i == foreach$mVc$sp_this.scala$collection$immutable$Range$$lastElement()) break;
                foreach$mVc$sp_i += foreach$mVc$sp_this.step();
            }
        }
        return (CC)((TraversableOnce)((Builder)bf.apply(xs).$plus$plus$eq(buf)).result());
    }

    /*
     * WARNING - void declaration
     */
    public Stream<Object> alphanumeric() {
        void continually_apply_tl;
        void continually_apply_hd;
        void continually_elem;
        JFunction0$mcC$sp & Serializable intersect = (JFunction0$mcC$sp & Serializable)() -> this.nextAlphaNum$1();
        if (Stream$.MODULE$ == null) {
            throw null;
        }
        Function0<Stream> & java.io.Serializable & Serializable intersect2 = () -> Stream$.$anonfun$continually$1((Function0)continually_elem);
        Character c = BoxesRunTime.boxToCharacter(this.nextAlphaNum$1());
        if (Stream$cons$.MODULE$ == null) {
            throw null;
        }
        return new Stream.Cons<void>(continually_apply_hd, (Function0<Stream<void>>)continually_apply_tl);
    }

    private final char safeChar$1() {
        int surrogateStart = 55296;
        return (char)(this.nextInt(surrogateStart - 1) + 1);
    }

    private static final void swap$1(int i1, int i2, ArrayBuffer buf$1) {
        Object tmp = buf$1.apply(i1);
        buf$1.update(i1, buf$1.apply(i2));
        buf$1.update(i2, tmp);
    }

    public static final /* synthetic */ void $anonfun$shuffle$1(Random $this, ArrayBuffer buf$1, int n) {
        int k = $this.nextInt(n);
        Random.swap$1(n - 1, k, buf$1);
    }

    private final char nextAlphaNum$1() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        return chars.charAt(this.self().nextInt(chars.length()));
    }

    public Random(java.util.Random self) {
        this.self = self;
    }

    public Random(long seed) {
        this(new java.util.Random(seed));
    }

    public Random(int seed) {
        this((long)seed);
    }

    public Random() {
        this(new java.util.Random());
    }
}

