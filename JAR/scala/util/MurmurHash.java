/*
 * Decompiled with CFR 0.152.
 */
package scala.util;

import scala.Function1;
import scala.collection.TraversableOnce;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Statics;
import scala.util.MurmurHash$;

@ScalaSignature(bytes="\u0006\u0001\tEc\u0001\u0002\u001f>\u0001\tC\u0001\"\u001c\u0001\u0003\u0002\u0003\u0006IA\u001c\u0005\u0006c\u0002!\tA\u001d\u0005\bm\u0002\u0001\r\u0011\"\u0003x\u0011\u001dA\b\u00011A\u0005\neDa\u0001 \u0001!B\u0013q\u0007bB?\u0001\u0001\u0004%Ia\u001e\u0005\b}\u0002\u0001\r\u0011\"\u0003\u0000\u0011\u001d\t\u0019\u0001\u0001Q!\n9D\u0001\"!\u0002\u0001\u0001\u0004%Ia\u001e\u0005\n\u0003\u000f\u0001\u0001\u0019!C\u0005\u0003\u0013Aq!!\u0004\u0001A\u0003&a\u000eC\u0005\u0002\u0010\u0001\u0001\r\u0011\"\u0003\u0002\u0012!I\u0011\u0011\u0004\u0001A\u0002\u0013%\u00111\u0004\u0005\t\u0003?\u0001\u0001\u0015)\u0003\u0002\u0014!A\u0011\u0011\u0005\u0001A\u0002\u0013%q\u000fC\u0005\u0002$\u0001\u0001\r\u0011\"\u0003\u0002&!9\u0011\u0011\u0006\u0001!B\u0013q\u0007bBA\u0016\u0001\u0011\u0005\u0011Q\u0006\u0005\b\u0003_\u0001A\u0011AA\u0019\u0011\u001d\t9\u0004\u0001C\u0001\u0003sAa!a\u0010\u0001\t\u00039\bbBA!\u0001\u0011\u0005\u00131I\u0004\b\u0003+j\u0004\u0012AA,\r\u0019aT\b#\u0001\u0002Z!1\u0011\u000f\u0007C\u0001\u00037B\u0011\"!\u0018\u0019\u0005\u0004%i!a\u0018\t\u0011\u0005\u0015\u0004\u0004)A\u0007\u0003CB\u0011\"a\u001a\u0019\u0005\u0004%i!!\u001b\t\u0011\u0005=\u0004\u0004)A\u0007\u0003WB\u0011\"!\u001d\u0019\u0005\u0004%i!a\u001d\t\u0011\u0005e\u0004\u0004)A\u0007\u0003kB\u0011\"a\u001f\u0019\u0005\u0004%i!! \t\u0011\u0005\r\u0005\u0004)A\u0007\u0003\u007fB\u0011\"!\"\u0019\u0005\u0004%i!a\"\t\u0011\u00055\u0005\u0004)A\u0007\u0003\u0013C\u0011\"a$\u0019\u0005\u0004%i!!%\t\u0011\u0005]\u0005\u0004)A\u0007\u0003'C\u0011\"!'\u0019\u0005\u0004%i!a'\t\u0011\u0005\u0005\u0006\u0004)A\u0007\u0003;C\u0011\"a)\u0019\u0005\u0004%i!!*\t\u0011\u0005-\u0006\u0004)A\u0007\u0003OC\u0011\"!,\u0019\u0005\u0004%i!a,\t\u0011\u0005U\u0006\u0004)A\u0007\u0003cC\u0011\"a.\u0019\u0005\u0004%i!!/\t\u0011\u0005}\u0006\u0004)A\u0007\u0003wC\u0011\"!1\u0019\u0005\u0004%\t!a1\t\u0011\u0005-\u0007\u0004)A\u0005\u0003\u000bD\u0011\"!4\u0019\u0005\u0004%\t!a1\t\u0011\u0005=\u0007\u0004)A\u0005\u0003\u000bDq!!5\u0019\t\u0003\t\u0019\u000e\u0003\u0004\u0002Xb!\ta\u001e\u0005\u0007\u00033DB\u0011A<\t\u000f\u0005m\u0007\u0004\"\u0001\u0002^\"9\u0011Q\u001e\r\u0005\u0002\u0005=\bbBAz1\u0011\u0005\u0011Q\u001f\u0005\b\u0003sDB\u0011AA~\u0011\u001d\ty\u0010\u0007C\u0001\u0005\u0003AqA!\u0005\u0019\t\u0003\u0011\u0019\u0002C\u0004\u00030a!\tA!\r\u0003\u00155+(/\\;s\u0011\u0006\u001c\bN\u0003\u0002?\u007f\u0005!Q\u000f^5m\u0015\u0005\u0001\u0015!B:dC2\f7\u0001A\u000b\u0003\u00076\u001b2\u0001\u0001#I!\t)e)D\u0001@\u0013\t9uH\u0001\u0004B]f\u0014VM\u001a\t\u0005\u000b&[%.\u0003\u0002K\u007f\tIa)\u001e8di&|g.\r\t\u0003\u00196c\u0001\u0001B\u0005O\u0001\u0001\u0006\t\u0011!b\u0001\u001f\n\tA+\u0005\u0002Q'B\u0011Q)U\u0005\u0003%~\u0012qAT8uQ&tw\r\u0005\u0002F)&\u0011Qk\u0010\u0002\u0004\u0003:L\bFB'X5z\u0013g\r\u0005\u0002F1&\u0011\u0011l\u0010\u0002\fgB,7-[1mSj,G-\r\u0003%7rkfBA#]\u0013\tiv(A\u0002J]R\fD\u0001J0aC:\u0011Q\tY\u0005\u0003C~\nA\u0001T8oOF\"Ae\u00193f\u001d\t)E-\u0003\u0002f\u007f\u0005)a\t\\8biF\"Ae\u001a5j\u001d\t)\u0005.\u0003\u0002j\u007f\u00051Ai\\;cY\u0016\u0004\"!R6\n\u00051|$\u0001B+oSR\fAa]3fIB\u0011Qi\\\u0005\u0003a~\u00121!\u00138u\u0003\u0019a\u0014N\\5u}Q\u00111/\u001e\t\u0004i\u0002YU\"A\u001f\t\u000b5\u0014\u0001\u0019\u00018\u0002\u0003!,\u0012A\\\u0001\u0006Q~#S-\u001d\u000b\u0003UjDqa\u001f\u0003\u0002\u0002\u0003\u0007a.A\u0002yIE\n!\u0001\u001b\u0011\u0002\u0003\r\fQaY0%KF$2A[A\u0001\u0011\u001dYx!!AA\u00029\f!a\u0019\u0011\u0002\u0003-\fQa[0%KF$2A[A\u0006\u0011\u001dY(\"!AA\u00029\f!a\u001b\u0011\u0002\r!\f7\u000f[3e+\t\t\u0019\u0002E\u0002F\u0003+I1!a\u0006@\u0005\u001d\u0011un\u001c7fC:\f!\u0002[1tQ\u0016$w\fJ3r)\rQ\u0017Q\u0004\u0005\tw6\t\t\u00111\u0001\u0002\u0014\u00059\u0001.Y:iK\u0012\u0004\u0013!\u00035bg\"4\u0018\r\\;f\u00035A\u0017m\u001d5wC2,Xm\u0018\u0013fcR\u0019!.a\n\t\u000fm\u0004\u0012\u0011!a\u0001]\u0006Q\u0001.Y:im\u0006dW/\u001a\u0011\u0002\u000bI,7/\u001a;\u0015\u0003)\fQ!\u00199qYf$2A[A\u001a\u0011\u0019\t)d\u0005a\u0001\u0017\u0006\tA/\u0001\u0004baB,g\u000e\u001a\u000b\u0004U\u0006m\u0002BBA\u001f)\u0001\u0007a.A\u0001j\u0003\u0011A\u0017m\u001d5\u0002\u0011!\f7\u000f[\"pI\u0016$\u0012A\u001c\u0015\b\u0001\u0005\u001d\u0013QJA)!\r)\u0015\u0011J\u0005\u0004\u0003\u0017z$A\u00033faJ,7-\u0019;fI\u0006\u0012\u0011qJ\u0001#kN,\u0007\u0005\u001e5fA=\u0014'.Z2uA5+(/\\;s\u0011\u0006\u001c\bn\r\u0011j]N$X-\u00193\"\u0005\u0005M\u0013A\u0002\u001a/cAr\u0003'\u0001\u0006NkJlWO\u001d%bg\"\u0004\"\u0001\u001e\r\u0014\u0005a!ECAA,\u000311\u0018n]5cY\u0016l\u0015mZ5d+\t\t\tg\u0004\u0002\u0002du!qSH\n|\u000351\u0018n]5cY\u0016l\u0015mZ5dA\u0005a\u0001.\u001b3eK:l\u0015mZ5d\u0003V\u0011\u00111N\b\u0003\u0003[jB!&+8\u000f\u0007i\u0001.\u001b3eK:l\u0015mZ5d\u0003\u0002\nA\u0002[5eI\u0016tW*Y4jG\n+\"!!\u001e\u0010\u0005\u0005]T\u0004\u0002\u0016XX\u0018\nQ\u0002[5eI\u0016tW*Y4jG\n\u0003\u0013\u0001\u0004<jg&\u0014G.Z'jq\u0016\u0014XCAA@\u001f\t\t\t)\b\u0003S9 P\u0013!\u0004<jg&\u0014G.Z'jq\u0016\u0014\b%\u0001\u0007iS\u0012$WM\\'jq\u0016\u0014\u0018)\u0006\u0002\u0002\n>\u0011\u00111R\u000f\u0005wv,B4A\u0007iS\u0012$WM\\'jq\u0016\u0014\u0018\tI\u0001\rQ&$G-\u001a8NSb,'OQ\u000b\u0003\u0003'{!!!&\u001e\t-t=Mf\u0001\u000eQ&$G-\u001a8NSb,'O\u0011\u0011\u0002\u0017\u0019Lg.\u00197NSb,'/M\u000b\u0003\u0003;{!!a(\u001e\t\u0015]/z[\u0001\rM&t\u0017\r\\'jq\u0016\u0014\u0018\u0007I\u0001\fM&t\u0017\r\\'jq\u0016\u0014('\u0006\u0002\u0002(>\u0011\u0011\u0011V\u000f\u0005\u0005Lv['\u0001\u0007gS:\fG.T5yKJ\u0014\u0004%\u0001\u0006tK\u0016$7\u000b\u001e:j]\u001e,\"!!-\u0010\u0005\u0005MV\u0004B|K\u0000J\u000f1b]3fIN#(/\u001b8hA\u0005I1/Z3e\u0003J\u0014\u0018-_\u000b\u0003\u0003w{!!!0\u001e\tq:!*Y\u0001\u000bg\u0016,G-\u0011:sCf\u0004\u0013\u0001D:u_J,G-T1hS\u000e\fUCAAc!\u0011)\u0015q\u00198\n\u0007\u0005%wHA\u0003BeJ\f\u00170A\u0007ti>\u0014X\rZ'bO&\u001c\u0017\tI\u0001\rgR|'/\u001a3NC\u001eL7MQ\u0001\u000egR|'/\u001a3NC\u001eL7M\u0011\u0011\u0002\u0013M$\u0018M\u001d;ICNDGc\u00018\u0002V\")QN\ra\u0001]\u0006Y1\u000f^1si6\u000bw-[2B\u0003-\u0019H/\u0019:u\u001b\u0006<\u0017n\u0019\"\u0002\u0015\u0015DH/\u001a8e\u0011\u0006\u001c\b\u000eF\u0005o\u0003?\f\t/!:\u0002j\"1\u0011qH\u001bA\u00029Da!a96\u0001\u0004q\u0017!\u0002<bYV,\u0007BBAtk\u0001\u0007a.\u0001\u0004nC\u001eL7-\u0011\u0005\u0007\u0003W,\u0004\u0019\u00018\u0002\r5\fw-[2C\u0003)qW\r\u001f;NC\u001eL7-\u0011\u000b\u0004]\u0006E\bBBAtm\u0001\u0007a.\u0001\u0006oKb$X*Y4jG\n#2A\\A|\u0011\u0019\tYo\u000ea\u0001]\u0006aa-\u001b8bY&TX\rS1tQR\u0019a.!@\t\r\u0005}\u0002\b1\u0001o\u0003%\t'O]1z\u0011\u0006\u001c\b.\u0006\u0003\u0003\u0004\t5Ac\u00018\u0003\u0006!9!qA\u001dA\u0002\t%\u0011!A1\u0011\u000b\u0015\u000b9Ma\u0003\u0011\u00071\u0013i\u0001B\u0005Os\u0001\u0006\t\u0011!b\u0001\u001f\"\u001a!QB,\u0002\u0015M$(/\u001b8h\u0011\u0006\u001c\b\u000eF\u0002o\u0005+AqAa\u0006;\u0001\u0004\u0011I\"A\u0001t!\u0011\u0011YB!\u000b\u000f\t\tu!Q\u0005\t\u0004\u0005?yTB\u0001B\u0011\u0015\r\u0011\u0019#Q\u0001\u0007yI|w\u000e\u001e \n\u0007\t\u001dr(\u0001\u0004Qe\u0016$WMZ\u0005\u0005\u0005W\u0011iC\u0001\u0004TiJLgn\u001a\u0006\u0004\u0005Oy\u0014!D:z[6,GO]5d\u0011\u0006\u001c\b.\u0006\u0003\u00034\t\u001dC#\u00028\u00036\t%\u0003b\u0002B\u001cw\u0001\u0007!\u0011H\u0001\u0003qN\u0004bAa\u000f\u0003B\t\u0015SB\u0001B\u001f\u0015\r\u0011ydP\u0001\u000bG>dG.Z2uS>t\u0017\u0002\u0002B\"\u0005{\u0011q\u0002\u0016:bm\u0016\u00148/\u00192mK>s7-\u001a\t\u0004\u0019\n\u001dC!\u0002(<\u0005\u0004y\u0005\"B7<\u0001\u0004q\u0007f\u0002\r\u0002H\u00055\u0013\u0011\u000b\u0015\b1\u0005\u001d\u0013QJA)Q\u001d9\u0012qIA'\u0003#\u0002")
public class MurmurHash<T>
implements Function1<T, BoxedUnit> {
    private final int seed;
    private int scala$util$MurmurHash$$h;
    private int scala$util$MurmurHash$$c;
    private int scala$util$MurmurHash$$k;
    private boolean scala$util$MurmurHash$$hashed;
    private int hashvalue;

    public static <T> int symmetricHash(TraversableOnce<T> traversableOnce, int n) {
        return MurmurHash$.MODULE$.symmetricHash(traversableOnce, n);
    }

    public static int stringHash(String string) {
        return MurmurHash$.MODULE$.stringHash(string);
    }

    public static <T> int arrayHash(Object object) {
        return MurmurHash$.MODULE$.arrayHash(object);
    }

    public static int finalizeHash(int n) {
        return MurmurHash$.MODULE$.finalizeHash(n);
    }

    public static int nextMagicB(int n) {
        return MurmurHash$.MODULE$.nextMagicB(n);
    }

    public static int nextMagicA(int n) {
        return MurmurHash$.MODULE$.nextMagicA(n);
    }

    public static int extendHash(int n, int n2, int n3, int n4) {
        return MurmurHash$.MODULE$.extendHash(n, n2, n3, n4);
    }

    public static int startMagicB() {
        return MurmurHash$.MODULE$.startMagicB();
    }

    public static int startMagicA() {
        return MurmurHash$.MODULE$.startMagicA();
    }

    public static int startHash(int n) {
        return MurmurHash$.MODULE$.startHash(n);
    }

    public static int[] storedMagicB() {
        return MurmurHash$.MODULE$.storedMagicB();
    }

    public static int[] storedMagicA() {
        return MurmurHash$.MODULE$.storedMagicA();
    }

    @Override
    public boolean apply$mcZD$sp(double v1) {
        return Function1.apply$mcZD$sp$(this, v1);
    }

    @Override
    public double apply$mcDD$sp(double v1) {
        return Function1.apply$mcDD$sp$(this, v1);
    }

    @Override
    public float apply$mcFD$sp(double v1) {
        return Function1.apply$mcFD$sp$(this, v1);
    }

    @Override
    public int apply$mcID$sp(double v1) {
        return Function1.apply$mcID$sp$(this, v1);
    }

    @Override
    public long apply$mcJD$sp(double v1) {
        return Function1.apply$mcJD$sp$(this, v1);
    }

    @Override
    public void apply$mcVD$sp(double v1) {
        Function1.apply$mcVD$sp$(this, v1);
    }

    @Override
    public boolean apply$mcZF$sp(float v1) {
        return Function1.apply$mcZF$sp$(this, v1);
    }

    @Override
    public double apply$mcDF$sp(float v1) {
        return Function1.apply$mcDF$sp$(this, v1);
    }

    @Override
    public float apply$mcFF$sp(float v1) {
        return Function1.apply$mcFF$sp$(this, v1);
    }

    @Override
    public int apply$mcIF$sp(float v1) {
        return Function1.apply$mcIF$sp$(this, v1);
    }

    @Override
    public long apply$mcJF$sp(float v1) {
        return Function1.apply$mcJF$sp$(this, v1);
    }

    @Override
    public void apply$mcVF$sp(float v1) {
        Function1.apply$mcVF$sp$(this, v1);
    }

    @Override
    public boolean apply$mcZI$sp(int v1) {
        return Function1.apply$mcZI$sp$(this, v1);
    }

    @Override
    public double apply$mcDI$sp(int v1) {
        return Function1.apply$mcDI$sp$(this, v1);
    }

    @Override
    public float apply$mcFI$sp(int v1) {
        return Function1.apply$mcFI$sp$(this, v1);
    }

    @Override
    public int apply$mcII$sp(int v1) {
        return Function1.apply$mcII$sp$(this, v1);
    }

    @Override
    public long apply$mcJI$sp(int v1) {
        return Function1.apply$mcJI$sp$(this, v1);
    }

    @Override
    public void apply$mcVI$sp(int v1) {
        Function1.apply$mcVI$sp$(this, v1);
    }

    @Override
    public boolean apply$mcZJ$sp(long v1) {
        return Function1.apply$mcZJ$sp$(this, v1);
    }

    @Override
    public double apply$mcDJ$sp(long v1) {
        return Function1.apply$mcDJ$sp$(this, v1);
    }

    @Override
    public float apply$mcFJ$sp(long v1) {
        return Function1.apply$mcFJ$sp$(this, v1);
    }

    @Override
    public int apply$mcIJ$sp(long v1) {
        return Function1.apply$mcIJ$sp$(this, v1);
    }

    @Override
    public long apply$mcJJ$sp(long v1) {
        return Function1.apply$mcJJ$sp$(this, v1);
    }

    @Override
    public void apply$mcVJ$sp(long v1) {
        Function1.apply$mcVJ$sp$(this, v1);
    }

    @Override
    public <A> Function1<A, BoxedUnit> compose(Function1<A, T> g) {
        return Function1.compose$(this, g);
    }

    @Override
    public <A> Function1<T, A> andThen(Function1<BoxedUnit, A> g) {
        return Function1.andThen$(this, g);
    }

    @Override
    public String toString() {
        return Function1.toString$(this);
    }

    public int scala$util$MurmurHash$$h() {
        return this.scala$util$MurmurHash$$h;
    }

    public void scala$util$MurmurHash$$h_$eq(int x$1) {
        this.scala$util$MurmurHash$$h = x$1;
    }

    public int scala$util$MurmurHash$$c() {
        return this.scala$util$MurmurHash$$c;
    }

    public void scala$util$MurmurHash$$c_$eq(int x$1) {
        this.scala$util$MurmurHash$$c = x$1;
    }

    public int scala$util$MurmurHash$$k() {
        return this.scala$util$MurmurHash$$k;
    }

    public void scala$util$MurmurHash$$k_$eq(int x$1) {
        this.scala$util$MurmurHash$$k = x$1;
    }

    private boolean scala$util$MurmurHash$$hashed() {
        return this.scala$util$MurmurHash$$hashed;
    }

    public void scala$util$MurmurHash$$hashed_$eq(boolean x$1) {
        this.scala$util$MurmurHash$$hashed = x$1;
    }

    private int hashvalue() {
        return this.hashvalue;
    }

    private void hashvalue_$eq(int x$1) {
        this.hashvalue = x$1;
    }

    public void reset() {
        this.scala$util$MurmurHash$$h_$eq(MurmurHash$.MODULE$.startHash(this.seed));
        this.scala$util$MurmurHash$$c_$eq(-1789642873);
        this.scala$util$MurmurHash$$k_$eq(718793509);
        this.scala$util$MurmurHash$$hashed_$eq(false);
    }

    @Override
    public void apply(T t) {
        this.scala$util$MurmurHash$$h_$eq(MurmurHash$.MODULE$.extendHash(this.scala$util$MurmurHash$$h(), Statics.anyHash(t), this.scala$util$MurmurHash$$c(), this.scala$util$MurmurHash$$k()));
        this.scala$util$MurmurHash$$c_$eq(MurmurHash$.MODULE$.nextMagicA(this.scala$util$MurmurHash$$c()));
        this.scala$util$MurmurHash$$k_$eq(MurmurHash$.MODULE$.nextMagicB(this.scala$util$MurmurHash$$k()));
        this.scala$util$MurmurHash$$hashed_$eq(false);
    }

    public void append(int i) {
        this.scala$util$MurmurHash$$h_$eq(MurmurHash$.MODULE$.extendHash(this.scala$util$MurmurHash$$h(), i, this.scala$util$MurmurHash$$c(), this.scala$util$MurmurHash$$k()));
        this.scala$util$MurmurHash$$c_$eq(MurmurHash$.MODULE$.nextMagicA(this.scala$util$MurmurHash$$c()));
        this.scala$util$MurmurHash$$k_$eq(MurmurHash$.MODULE$.nextMagicB(this.scala$util$MurmurHash$$k()));
        this.scala$util$MurmurHash$$hashed_$eq(false);
    }

    public int hash() {
        if (!this.scala$util$MurmurHash$$hashed()) {
            this.hashvalue_$eq(MurmurHash$.MODULE$.finalizeHash(this.scala$util$MurmurHash$$h()));
            this.scala$util$MurmurHash$$hashed_$eq(true);
        }
        return this.hashvalue();
    }

    public int hashCode() {
        return this.hash();
    }

    public void apply$mcD$sp(double t) {
        this.apply((T)BoxesRunTime.boxToDouble(t));
    }

    public void apply$mcF$sp(float t) {
        this.apply((T)BoxesRunTime.boxToFloat(t));
    }

    public void apply$mcI$sp(int t) {
        this.apply((T)BoxesRunTime.boxToInteger(t));
    }

    public void apply$mcJ$sp(long t) {
        this.apply((T)BoxesRunTime.boxToLong(t));
    }

    public MurmurHash(int seed) {
        this.seed = seed;
        this.scala$util$MurmurHash$$h = MurmurHash$.MODULE$.startHash(seed);
        this.scala$util$MurmurHash$$c = -1789642873;
        this.scala$util$MurmurHash$$k = 718793509;
        this.scala$util$MurmurHash$$hashed = false;
        this.hashvalue = this.scala$util$MurmurHash$$h();
    }
}

