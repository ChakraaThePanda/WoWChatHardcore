/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import scala.Function1;
import scala.Proxy;
import scala.collection.immutable.NumericRange;
import scala.math.Numeric$FloatAsIfIntegral$;
import scala.math.Numeric$FloatIsFractional$;
import scala.math.Ordered;
import scala.math.Ordering$Float$;
import scala.math.ScalaNumericAnyConversions;
import scala.reflect.ScalaSignature;
import scala.runtime.FractionalProxy;
import scala.runtime.OrderedProxy;
import scala.runtime.RichFloat$;
import scala.runtime.ScalaNumberProxy;

@ScalaSignature(bytes="\u0006\u0001\t}b\u0001B!C\u0005\u001dC\u0001b\u0015\u0001\u0003\u0006\u0004%\t\u0001\u0016\u0005\t+\u0002\u0011\t\u0011)A\u0005!\")a\u000b\u0001C\u0001/\")!\f\u0001C\t7\")A\u000e\u0001C\t[\")Q\u000f\u0001C\tm\")!\u0010\u0001C!w\"1q\u0010\u0001C!\u0003\u0003Aq!a\u0001\u0001\t\u0003\n)\u0001C\u0004\u0002\u000e\u0001!\t%a\u0004\t\u000f\u0005]\u0001\u0001\"\u0011\u0002\u001a!9\u0011\u0011\u0005\u0001\u0005B\u0005\r\u0002bBA\u0016\u0001\u0011\u0005\u0013Q\u0006\u0005\b\u0003k\u0001A\u0011IA\u001c\u0011\u001d\tI\u0004\u0001C!\u0003oAq!a\u000f\u0001\t\u0003\n9\u0004C\u0004\u0002>\u0001!\t%a\u000e\t\u000f\u0005}\u0002\u0001\"\u0001\u00028!9\u0011\u0011\t\u0001\u0005\u0002\u0005]\u0002bBA\"\u0001\u0011\u0005\u0011q\u0007\u0005\b\u0003\u000b\u0002A\u0011AA\u001c\u0011\u0019\t9\u0005\u0001C!)\"9\u0011\u0011\n\u0001\u0005B\u0005-\u0003bBA)\u0001\u0011\u0005\u00131\u000b\u0005\b\u0003/\u0002A\u0011IA-\u0011\u001d\tY\u0006\u0001C\u0001\u00033Ba!!\u0018\u0001\t\u0003!\u0006BBA0\u0001\u0011\u0005A\u000b\u0003\u0004\u0002b\u0001!\t\u0001\u0016\u0005\u0007\u0003G\u0002A\u0011\u0001+\t\u0013\u0005\u0015\u0004!!A\u0005B\u0005=\u0001\"CA4\u0001\u0005\u0005I\u0011IA5\u000f%\t)HQA\u0001\u0012\u0003\t9H\u0002\u0005B\u0005\u0006\u0005\t\u0012AA=\u0011\u00191&\u0005\"\u0001\u0002\u0002\"9\u00111\u0011\u0012\u0005\u0006\u0005\u0015\u0005bBAFE\u0011\u0015\u0011Q\u0012\u0005\b\u0003#\u0013CQAAJ\u0011\u001d\t9J\tC\u0003\u00033Cq!!(#\t\u000b\ty\nC\u0004\u0002$\n\")!!*\t\u000f\u0005%&\u0005\"\u0002\u0002,\"9\u0011q\u0016\u0012\u0005\u0006\u0005E\u0006bBA[E\u0011\u0015\u0011q\u0017\u0005\b\u0003w\u0013CQAA_\u0011\u001d\t\tM\tC\u0003\u0003\u0007Dq!a2#\t\u000b\tI\rC\u0004\u0002N\n\")!a4\t\u000f\u0005M'\u0005\"\u0002\u0002V\"9\u0011\u0011\u001c\u0012\u0005\u0006\u0005m\u0007bBApE\u0011\u0015\u0011\u0011\u001d\u0005\b\u0003K\u0014CQAAt\u0011\u001d\tYO\tC\u0003\u0003[Dq!!=#\t\u000b\t\u0019\u0010C\u0004\u0002x\n\")!!?\t\u000f\t\u0005!\u0005\"\u0002\u0003\u0004!9!1\u0002\u0012\u0005\u0006\t5\u0001b\u0002B\tE\u0011\u0015!1\u0003\u0005\b\u0005/\u0011CQ\u0001B\r\u0011\u001d\u0011iB\tC\u0003\u0005?AqAa\t#\t\u000b\u0011)\u0003C\u0004\u0003*\t\")Aa\u000b\t\u0013\t=\"%!A\u0005\u0006\tE\u0002\"\u0003B\u001bE\u0005\u0005IQ\u0001B\u001c\u0005%\u0011\u0016n\u00195GY>\fGO\u0003\u0002D\t\u00069!/\u001e8uS6,'\"A#\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001M\u0019\u0001\u0001\u0013'\u0011\u0005%SU\"\u0001#\n\u0005-#%AB!osZ\u000bG\u000eE\u0002N\u001dBk\u0011AQ\u0005\u0003\u001f\n\u0013qB\u0012:bGRLwN\\1m!J|\u00070\u001f\t\u0003\u0013FK!A\u0015#\u0003\u000b\u0019cw.\u0019;\u0002\tM,GNZ\u000b\u0002!\u0006)1/\u001a7gA\u00051A(\u001b8jiz\"\"\u0001W-\u0011\u00055\u0003\u0001\"B*\u0004\u0001\u0004\u0001\u0016a\u00018v[V\tAL\u0004\u0002^S:\u0011aL\u001a\b\u0003?\u0012t!\u0001Y2\u000e\u0003\u0005T!A\u0019$\u0002\rq\u0012xn\u001c;?\u0013\u0005)\u0015BA3E\u0003\u0011i\u0017\r\u001e5\n\u0005\u001dD\u0017a\u0002(v[\u0016\u0014\u0018n\u0019\u0006\u0003K\u0012K!A[6\u0002#\u0019cw.\u0019;Jg\u001a\u0013\u0018m\u0019;j_:\fGN\u0003\u0002hQ\u0006\u0019qN\u001d3\u0016\u00039t!a\u001c:\u000f\u0005y\u0003\u0018BA9i\u0003!y%\u000fZ3sS:<\u0017BA:u\u0003\u00151En\\1u\u0015\t\t\b.A\u0006j]R,wM]1m\u001dVlW#A<\u000f\u0005uC\u0018BA=l\u0003E1En\\1u\u0003NLe-\u00138uK\u001e\u0014\u0018\r\\\u0001\fI>,(\r\\3WC2,X\rF\u0001}!\tIU0\u0003\u0002\u007f\t\n1Ai\\;cY\u0016\f!B\u001a7pCR4\u0016\r\\;f)\u0005\u0001\u0016!\u00037p]\u001e4\u0016\r\\;f)\t\t9\u0001E\u0002J\u0003\u0013I1!a\u0003E\u0005\u0011auN\\4\u0002\u0011%tGOV1mk\u0016$\"!!\u0005\u0011\u0007%\u000b\u0019\"C\u0002\u0002\u0016\u0011\u00131!\u00138u\u0003%\u0011\u0017\u0010^3WC2,X\r\u0006\u0002\u0002\u001cA\u0019\u0011*!\b\n\u0007\u0005}AI\u0001\u0003CsR,\u0017AC:i_J$h+\u00197vKR\u0011\u0011Q\u0005\t\u0004\u0013\u0006\u001d\u0012bAA\u0015\t\n)1\u000b[8si\u00069\u0011n],i_2,GCAA\u0018!\rI\u0015\u0011G\u0005\u0004\u0003g!%a\u0002\"p_2,\u0017M\\\u0001\fSN4\u0016\r\\5e\u0005f$X-\u0006\u0002\u00020\u0005a\u0011n\u001d,bY&$7\u000b[8si\u0006Y\u0011n\u001d,bY&$7\t[1s\u0003)I7OV1mS\u0012Le\u000e^\u0001\u0006SNt\u0015MT\u0001\u000bSNLeNZ5oSRL\u0018!D5t!>\u001c\u0018J\u001c4j]&$\u00180A\u0007jg:+w-\u00138gS:LG/_\u0001\u0004C\n\u001c\u0018aA7bqR\u0019\u0001+!\u0014\t\r\u0005=s\u00031\u0001Q\u0003\u0011!\b.\u0019;\u0002\u00075Lg\u000eF\u0002Q\u0003+Ba!a\u0014\u0019\u0001\u0004\u0001\u0016AB:jO:,X.\u0006\u0002\u0002\u0012\u0005)!o\\;oI\u0006!1-Z5m\u0003\u00151Gn\\8s\u0003%!xNU1eS\u0006t7/A\u0005u_\u0012+wM]3fg\u0006A\u0001.Y:i\u0007>$W-\u0001\u0004fcV\fGn\u001d\u000b\u0005\u0003_\tY\u0007C\u0005\u0002n\u0001\n\t\u00111\u0001\u0002p\u0005\u0019\u0001\u0010J\u0019\u0011\u0007%\u000b\t(C\u0002\u0002t\u0011\u00131!\u00118z\u0003%\u0011\u0016n\u00195GY>\fG\u000f\u0005\u0002NEM\u0019!%a\u001f\u0011\u0007%\u000bi(C\u0002\u0002\u0000\u0011\u0013a!\u00118z%\u00164GCAA<\u00035qW/\u001c\u0013fqR,gn]5p]R\u0019A,a\"\t\r\u0005%E\u00051\u0001Y\u0003\u0015!C\u000f[5t\u00035y'\u000f\u001a\u0013fqR,gn]5p]R\u0019a.a$\t\r\u0005%U\u00051\u0001Y\u0003UIg\u000e^3he\u0006dg*^7%Kb$XM\\:j_:$2a^AK\u0011\u0019\tII\na\u00011\u0006)Bm\\;cY\u00164\u0016\r\\;fI\u0015DH/\u001a8tS>tGcA>\u0002\u001c\"1\u0011\u0011R\u0014A\u0002a\u000bAC\u001a7pCR4\u0016\r\\;fI\u0015DH/\u001a8tS>tG\u0003BA\u0001\u0003CCa!!#)\u0001\u0004A\u0016a\u00057p]\u001e4\u0016\r\\;fI\u0015DH/\u001a8tS>tG\u0003BA\u0003\u0003OCa!!#*\u0001\u0004A\u0016AE5oiZ\u000bG.^3%Kb$XM\\:j_:$B!a\u0004\u0002.\"1\u0011\u0011\u0012\u0016A\u0002a\u000b1CY=uKZ\u000bG.^3%Kb$XM\\:j_:$B!!\u0007\u00024\"1\u0011\u0011R\u0016A\u0002a\u000bAc\u001d5peR4\u0016\r\\;fI\u0015DH/\u001a8tS>tG\u0003BA\u0012\u0003sCa!!#-\u0001\u0004A\u0016!E5t/\"|G.\u001a\u0013fqR,gn]5p]R!\u0011QFA`\u0011\u0019\tI)\fa\u00011\u0006)\u0012n\u001d,bY&$')\u001f;fI\u0015DH/\u001a8tS>tG\u0003BA\u0018\u0003\u000bDa!!#/\u0001\u0004A\u0016AF5t-\u0006d\u0017\u000eZ*i_J$H%\u001a=uK:\u001c\u0018n\u001c8\u0015\t\u0005=\u00121\u001a\u0005\u0007\u0003\u0013{\u0003\u0019\u0001-\u0002+%\u001ch+\u00197jI\u000eC\u0017M\u001d\u0013fqR,gn]5p]R!\u0011qFAi\u0011\u0019\tI\t\ra\u00011\u0006!\u0012n\u001d,bY&$\u0017J\u001c;%Kb$XM\\:j_:$B!a\f\u0002X\"1\u0011\u0011R\u0019A\u0002a\u000bq\"[:OC:#S\r\u001f;f]NLwN\u001c\u000b\u0005\u0003_\ti\u000e\u0003\u0004\u0002\nJ\u0002\r\u0001W\u0001\u0015SNLeNZ5oSRLH%\u001a=uK:\u001c\u0018n\u001c8\u0015\t\u0005=\u00121\u001d\u0005\u0007\u0003\u0013\u001b\u0004\u0019\u0001-\u0002/%\u001c\bk\\:J]\u001aLg.\u001b;zI\u0015DH/\u001a8tS>tG\u0003BA\u0018\u0003SDa!!#5\u0001\u0004A\u0016aF5t\u001d\u0016<\u0017J\u001c4j]&$\u0018\u0010J3yi\u0016t7/[8o)\u0011\ty#a<\t\r\u0005%U\u00071\u0001Y\u00035\t'm\u001d\u0013fqR,gn]5p]R\u0019\u0001+!>\t\r\u0005%e\u00071\u0001Y\u00035i\u0017\r\u001f\u0013fqR,gn]5p]R!\u00111`A\u0000)\r\u0001\u0016Q \u0005\u0007\u0003\u001f:\u0004\u0019\u0001)\t\r\u0005%u\u00071\u0001Y\u00035i\u0017N\u001c\u0013fqR,gn]5p]R!!Q\u0001B\u0005)\r\u0001&q\u0001\u0005\u0007\u0003\u001fB\u0004\u0019\u0001)\t\r\u0005%\u0005\b1\u0001Y\u0003A\u0019\u0018n\u001a8v[\u0012*\u0007\u0010^3og&|g\u000e\u0006\u0003\u0002\u0012\t=\u0001BBAEs\u0001\u0007\u0001,A\bs_VtG\rJ3yi\u0016t7/[8o)\u0011\t\tB!\u0006\t\r\u0005%%\b1\u0001Y\u00039\u0019W-\u001b7%Kb$XM\\:j_:$2\u0001\u0015B\u000e\u0011\u0019\tIi\u000fa\u00011\u0006ya\r\\8pe\u0012*\u0007\u0010^3og&|g\u000eF\u0002Q\u0005CAa!!#=\u0001\u0004A\u0016a\u0005;p%\u0006$\u0017.\u00198tI\u0015DH/\u001a8tS>tGc\u0001)\u0003(!1\u0011\u0011R\u001fA\u0002a\u000b1\u0003^8EK\u001e\u0014X-Z:%Kb$XM\\:j_:$2\u0001\u0015B\u0017\u0011\u0019\tII\u0010a\u00011\u0006\u0011\u0002.Y:i\u0007>$W\rJ3yi\u0016t7/[8o)\u0011\tyAa\r\t\r\u0005%u\b1\u0001Y\u0003A)\u0017/^1mg\u0012*\u0007\u0010^3og&|g\u000e\u0006\u0003\u0003:\tuB\u0003BA\u0018\u0005wA\u0011\"!\u001cA\u0003\u0003\u0005\r!a\u001c\t\r\u0005%\u0005\t1\u0001Y\u0001")
public final class RichFloat
implements FractionalProxy<Object> {
    private final float self;

    public static boolean equals$extension(float f, Object object) {
        return RichFloat$.MODULE$.equals$extension(f, object);
    }

    public static int hashCode$extension(float f) {
        return RichFloat$.MODULE$.hashCode$extension(f);
    }

    public static float toDegrees$extension(float f) {
        return RichFloat$.MODULE$.toDegrees$extension(f);
    }

    public static float toRadians$extension(float f) {
        return RichFloat$.MODULE$.toRadians$extension(f);
    }

    public static float floor$extension(float f) {
        return RichFloat$.MODULE$.floor$extension(f);
    }

    public static float ceil$extension(float f) {
        return RichFloat$.MODULE$.ceil$extension(f);
    }

    public static int round$extension(float f) {
        return RichFloat$.MODULE$.round$extension(f);
    }

    public static int signum$extension(float f) {
        return RichFloat$.MODULE$.signum$extension(f);
    }

    public static float min$extension(float f, float f2) {
        return RichFloat$.MODULE$.min$extension(f, f2);
    }

    public static float max$extension(float f, float f2) {
        return RichFloat$.MODULE$.max$extension(f, f2);
    }

    public static float abs$extension(float f) {
        return RichFloat$.MODULE$.abs$extension(f);
    }

    public static boolean isNegInfinity$extension(float f) {
        return RichFloat$.MODULE$.isNegInfinity$extension(f);
    }

    public static boolean isPosInfinity$extension(float f) {
        return RichFloat$.MODULE$.isPosInfinity$extension(f);
    }

    public static boolean isInfinity$extension(float f) {
        return RichFloat$.MODULE$.isInfinity$extension(f);
    }

    public static boolean isNaN$extension(float f) {
        return RichFloat$.MODULE$.isNaN$extension(f);
    }

    public static boolean isValidInt$extension(float f) {
        return RichFloat$.MODULE$.isValidInt$extension(f);
    }

    public static boolean isValidChar$extension(float f) {
        return RichFloat$.MODULE$.isValidChar$extension(f);
    }

    public static boolean isValidShort$extension(float f) {
        return RichFloat$.MODULE$.isValidShort$extension(f);
    }

    public static boolean isValidByte$extension(float f) {
        return RichFloat$.MODULE$.isValidByte$extension(f);
    }

    public static boolean isWhole$extension(float f) {
        return RichFloat$.MODULE$.isWhole$extension(f);
    }

    public static short shortValue$extension(float f) {
        return RichFloat$.MODULE$.shortValue$extension(f);
    }

    public static byte byteValue$extension(float f) {
        return RichFloat$.MODULE$.byteValue$extension(f);
    }

    public static int intValue$extension(float f) {
        return RichFloat$.MODULE$.intValue$extension(f);
    }

    public static long longValue$extension(float f) {
        return RichFloat$.MODULE$.longValue$extension(f);
    }

    public static float floatValue$extension(float f) {
        return RichFloat$.MODULE$.floatValue$extension(f);
    }

    public static double doubleValue$extension(float f) {
        return RichFloat$.MODULE$.doubleValue$extension(f);
    }

    public static Numeric$FloatAsIfIntegral$ integralNum$extension(float f) {
        return RichFloat$.MODULE$.integralNum$extension(f);
    }

    public static Ordering$Float$ ord$extension(float f) {
        return RichFloat$.MODULE$.ord$extension(f);
    }

    public static Numeric$FloatIsFractional$ num$extension(float f) {
        return RichFloat$.MODULE$.num$extension(f);
    }

    @Override
    public Function1 until(Object end) {
        return FractionalProxy.until$(this, end);
    }

    @Override
    public NumericRange.Exclusive until(Object end, Object step) {
        return FractionalProxy.until$(this, end, step);
    }

    @Override
    public Function1 to(Object end) {
        return FractionalProxy.to$(this, end);
    }

    @Override
    public NumericRange.Inclusive to(Object end, Object step) {
        return FractionalProxy.to$(this, end, step);
    }

    @Override
    public Object underlying() {
        return ScalaNumberProxy.underlying$(this);
    }

    @Override
    public int compare(Object y) {
        return OrderedProxy.compare$(this, y);
    }

    @Override
    public boolean $less(Object that) {
        return Ordered.$less$(this, that);
    }

    @Override
    public boolean $greater(Object that) {
        return Ordered.$greater$(this, that);
    }

    @Override
    public boolean $less$eq(Object that) {
        return Ordered.$less$eq$(this, that);
    }

    @Override
    public boolean $greater$eq(Object that) {
        return Ordered.$greater$eq$(this, that);
    }

    @Override
    public int compareTo(Object that) {
        return Ordered.compareTo$(this, that);
    }

    @Override
    public String toString() {
        return Proxy.toString$(this);
    }

    @Override
    public char toChar() {
        return ScalaNumericAnyConversions.toChar$(this);
    }

    @Override
    public byte toByte() {
        return ScalaNumericAnyConversions.toByte$(this);
    }

    @Override
    public short toShort() {
        return ScalaNumericAnyConversions.toShort$(this);
    }

    @Override
    public int toInt() {
        return ScalaNumericAnyConversions.toInt$(this);
    }

    @Override
    public long toLong() {
        return ScalaNumericAnyConversions.toLong$(this);
    }

    @Override
    public float toFloat() {
        return ScalaNumericAnyConversions.toFloat$(this);
    }

    @Override
    public double toDouble() {
        return ScalaNumericAnyConversions.toDouble$(this);
    }

    @Override
    public int unifiedPrimitiveHashcode() {
        return ScalaNumericAnyConversions.unifiedPrimitiveHashcode$(this);
    }

    @Override
    public boolean unifiedPrimitiveEquals(Object x) {
        return ScalaNumericAnyConversions.unifiedPrimitiveEquals$(this, x);
    }

    @Override
    public float self() {
        return this.self;
    }

    public Numeric$FloatIsFractional$ num() {
        return RichFloat$.MODULE$.num$extension(this.self());
    }

    public Ordering$Float$ ord() {
        return RichFloat$.MODULE$.ord$extension(this.self());
    }

    public Numeric$FloatAsIfIntegral$ integralNum() {
        return RichFloat$.MODULE$.integralNum$extension(this.self());
    }

    @Override
    public double doubleValue() {
        return RichFloat$.MODULE$.doubleValue$extension(this.self());
    }

    @Override
    public float floatValue() {
        return RichFloat$.MODULE$.floatValue$extension(this.self());
    }

    @Override
    public long longValue() {
        return RichFloat$.MODULE$.longValue$extension(this.self());
    }

    @Override
    public int intValue() {
        return RichFloat$.MODULE$.intValue$extension(this.self());
    }

    @Override
    public byte byteValue() {
        return RichFloat$.MODULE$.byteValue$extension(this.self());
    }

    @Override
    public short shortValue() {
        return RichFloat$.MODULE$.shortValue$extension(this.self());
    }

    @Override
    public boolean isWhole() {
        return RichFloat$.MODULE$.isWhole$extension(this.self());
    }

    @Override
    public boolean isValidByte() {
        return RichFloat$.MODULE$.isValidByte$extension(this.self());
    }

    @Override
    public boolean isValidShort() {
        return RichFloat$.MODULE$.isValidShort$extension(this.self());
    }

    @Override
    public boolean isValidChar() {
        return RichFloat$.MODULE$.isValidChar$extension(this.self());
    }

    @Override
    public boolean isValidInt() {
        return RichFloat$.MODULE$.isValidInt$extension(this.self());
    }

    public boolean isNaN() {
        return RichFloat$.MODULE$.isNaN$extension(this.self());
    }

    public boolean isInfinity() {
        return RichFloat$.MODULE$.isInfinity$extension(this.self());
    }

    public boolean isPosInfinity() {
        return RichFloat$.MODULE$.isPosInfinity$extension(this.self());
    }

    public boolean isNegInfinity() {
        return RichFloat$.MODULE$.isNegInfinity$extension(this.self());
    }

    @Override
    public float abs() {
        return RichFloat$.MODULE$.abs$extension(this.self());
    }

    @Override
    public float max(float that) {
        return RichFloat$.MODULE$.max$extension(this.self(), that);
    }

    @Override
    public float min(float that) {
        return RichFloat$.MODULE$.min$extension(this.self(), that);
    }

    @Override
    public int signum() {
        return RichFloat$.MODULE$.signum$extension(this.self());
    }

    public int round() {
        return RichFloat$.MODULE$.round$extension(this.self());
    }

    public float ceil() {
        return RichFloat$.MODULE$.ceil$extension(this.self());
    }

    public float floor() {
        return RichFloat$.MODULE$.floor$extension(this.self());
    }

    public float toRadians() {
        return RichFloat$.MODULE$.toRadians$extension(this.self());
    }

    public float toDegrees() {
        return RichFloat$.MODULE$.toDegrees$extension(this.self());
    }

    @Override
    public int hashCode() {
        return RichFloat$.MODULE$.hashCode$extension(this.self());
    }

    @Override
    public boolean equals(Object x$1) {
        return RichFloat$.MODULE$.equals$extension(this.self(), x$1);
    }

    public RichFloat(float self) {
        this.self = self;
        ScalaNumericAnyConversions.$init$(this);
        Proxy.$init$(this);
        Ordered.$init$(this);
        OrderedProxy.$init$(this);
        ScalaNumberProxy.$init$(this);
        FractionalProxy.$init$(this);
    }
}

