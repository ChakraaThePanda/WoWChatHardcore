/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import scala.Function1;
import scala.Proxy;
import scala.collection.immutable.NumericRange;
import scala.math.Numeric$DoubleAsIfIntegral$;
import scala.math.Numeric$DoubleIsFractional$;
import scala.math.Ordered;
import scala.math.Ordering$Double$;
import scala.math.ScalaNumericAnyConversions;
import scala.reflect.ScalaSignature;
import scala.runtime.FractionalProxy;
import scala.runtime.OrderedProxy;
import scala.runtime.RichDouble$;
import scala.runtime.ScalaNumberProxy;

@ScalaSignature(bytes="\u0006\u0001\t\u0005c\u0001B!C\u0005\u001dC\u0001b\u0015\u0001\u0003\u0006\u0004%\t\u0001\u0016\u0005\t+\u0002\u0011\t\u0011)A\u0005!\")a\u000b\u0001C\u0001/\")!\f\u0001C\t7\")A\u000e\u0001C\t[\")Q\u000f\u0001C\tm\")!\u0010\u0001C!w\")A\u0010\u0001C!{\"9\u00111\u0001\u0001\u0005B\u0005\u0015\u0001bBA\u0007\u0001\u0011\u0005\u0013q\u0002\u0005\b\u0003/\u0001A\u0011IA\r\u0011\u001d\t\t\u0003\u0001C!\u0003GAq!a\u000b\u0001\t\u0003\ni\u0003C\u0004\u00026\u0001!\t%a\u000e\t\u000f\u0005e\u0002\u0001\"\u0011\u00028!9\u00111\b\u0001\u0005B\u0005]\u0002bBA\u001f\u0001\u0011\u0005\u0013q\u0007\u0005\b\u0003\u007f\u0001A\u0011AA\u001c\u0011\u001d\t\t\u0005\u0001C\u0001\u0003oAq!a\u0011\u0001\t\u0003\t9\u0004C\u0004\u0002F\u0001!\t!a\u000e\t\r\u0005\u001d\u0003\u0001\"\u0011U\u0011\u001d\tI\u0005\u0001C!\u0003\u0017Bq!!\u0015\u0001\t\u0003\n\u0019\u0006C\u0004\u0002X\u0001!\t%!\u0017\t\u000f\u0005m\u0003\u0001\"\u0001\u0002^!1\u0011q\f\u0001\u0005\u0002QCa!!\u0019\u0001\t\u0003!\u0006BBA2\u0001\u0011\u0005A\u000b\u0003\u0004\u0002f\u0001!\t\u0001\u0016\u0005\n\u0003O\u0002\u0011\u0011!C!\u0003\u001fA\u0011\"!\u001b\u0001\u0003\u0003%\t%a\u001b\b\u0013\u0005]$)!A\t\u0002\u0005ed\u0001C!C\u0003\u0003E\t!a\u001f\t\rY\u0013C\u0011AAB\u0011\u001d\t)I\tC\u0003\u0003\u000fCq!!$#\t\u000b\ty\tC\u0004\u0002\u0014\n\")!!&\t\u000f\u0005e%\u0005\"\u0002\u0002\u001c\"9\u0011q\u0014\u0012\u0005\u0006\u0005\u0005\u0006bBASE\u0011\u0015\u0011q\u0015\u0005\b\u0003W\u0013CQAAW\u0011\u001d\t\tL\tC\u0003\u0003gCq!a.#\t\u000b\tI\fC\u0004\u0002>\n\")!a0\t\u000f\u0005\r'\u0005\"\u0002\u0002F\"9\u0011\u0011\u001a\u0012\u0005\u0006\u0005-\u0007bBAhE\u0011\u0015\u0011\u0011\u001b\u0005\b\u0003+\u0014CQAAl\u0011\u001d\tYN\tC\u0003\u0003;Dq!!9#\t\u000b\t\u0019\u000fC\u0004\u0002h\n\")!!;\t\u000f\u00055(\u0005\"\u0002\u0002p\"9\u00111\u001f\u0012\u0005\u0006\u0005U\bbBA}E\u0011\u0015\u00111 \u0005\b\u0005\u0007\u0011CQ\u0001B\u0003\u0011\u001d\u0011iA\tC\u0003\u0005\u001fAqAa\u0005#\t\u000b\u0011)\u0002C\u0004\u0003\u001a\t\")Aa\u0007\t\u000f\t}!\u0005\"\u0002\u0003\"!9!Q\u0005\u0012\u0005\u0006\t\u001d\u0002b\u0002B\u0016E\u0011\u0015!Q\u0006\u0005\n\u0005c\u0011\u0013\u0011!C\u0003\u0005gA\u0011Ba\u000e#\u0003\u0003%)A!\u000f\u0003\u0015IK7\r\u001b#pk\ndWM\u0003\u0002D\t\u00069!/\u001e8uS6,'\"A#\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001M\u0019\u0001\u0001\u0013'\u0011\u0005%SU\"\u0001#\n\u0005-#%AB!osZ\u000bG\u000eE\u0002N\u001dBk\u0011AQ\u0005\u0003\u001f\n\u0013qB\u0012:bGRLwN\\1m!J|\u00070\u001f\t\u0003\u0013FK!A\u0015#\u0003\r\u0011{WO\u00197f\u0003\u0011\u0019X\r\u001c4\u0016\u0003A\u000bQa]3mM\u0002\na\u0001P5oSRtDC\u0001-Z!\ti\u0005\u0001C\u0003T\u0007\u0001\u0007\u0001+A\u0002ok6,\u0012\u0001\u0018\b\u0003;&t!A\u00184\u000f\u0005}#gB\u00011d\u001b\u0005\t'B\u00012G\u0003\u0019a$o\\8u}%\tQ)\u0003\u0002f\t\u0006!Q.\u0019;i\u0013\t9\u0007.A\u0004Ok6,'/[2\u000b\u0005\u0015$\u0015B\u00016l\u0003I!u.\u001e2mK&\u001bhI]1di&|g.\u00197\u000b\u0005\u001dD\u0017aA8sIV\taN\u0004\u0002pe:\u0011a\f]\u0005\u0003c\"\f\u0001b\u0014:eKJLgnZ\u0005\u0003gR\fa\u0001R8vE2,'BA9i\u0003-Ig\u000e^3he\u0006dg*^7\u0016\u0003]t!!\u0018=\n\u0005e\\\u0017A\u0005#pk\ndW-Q:JM&sG/Z4sC2\f1\u0002Z8vE2,g+\u00197vKR\t\u0001+\u0001\u0006gY>\fGOV1mk\u0016$\u0012A \t\u0003\u0013~L1!!\u0001E\u0005\u00151En\\1u\u0003%awN\\4WC2,X\r\u0006\u0002\u0002\bA\u0019\u0011*!\u0003\n\u0007\u0005-AI\u0001\u0003M_:<\u0017\u0001C5oiZ\u000bG.^3\u0015\u0005\u0005E\u0001cA%\u0002\u0014%\u0019\u0011Q\u0003#\u0003\u0007%sG/A\u0005csR,g+\u00197vKR\u0011\u00111\u0004\t\u0004\u0013\u0006u\u0011bAA\u0010\t\n!!)\u001f;f\u0003)\u0019\bn\u001c:u-\u0006dW/\u001a\u000b\u0003\u0003K\u00012!SA\u0014\u0013\r\tI\u0003\u0012\u0002\u0006'\"|'\u000f^\u0001\bSN<\u0006n\u001c7f)\t\ty\u0003E\u0002J\u0003cI1!a\rE\u0005\u001d\u0011un\u001c7fC:\f1\"[:WC2LGMQ=uKV\u0011\u0011qF\u0001\rSN4\u0016\r\\5e'\"|'\u000f^\u0001\fSN4\u0016\r\\5e\u0007\"\f'/\u0001\u0006jgZ\u000bG.\u001b3J]R\fQ![:OC:\u000b!\"[:J]\u001aLg.\u001b;z\u00035I7\u000fU8t\u0013:4\u0017N\\5us\u0006i\u0011n\u001d(fO&sg-\u001b8jif\f1!\u00192t\u0003\ri\u0017\r\u001f\u000b\u0004!\u00065\u0003BBA(/\u0001\u0007\u0001+\u0001\u0003uQ\u0006$\u0018aA7j]R\u0019\u0001+!\u0016\t\r\u0005=\u0003\u00041\u0001Q\u0003\u0019\u0019\u0018n\u001a8v[V\u0011\u0011\u0011C\u0001\u0006e>,h\u000eZ\u000b\u0003\u0003\u000f\tAaY3jY\u0006)a\r\\8pe\u0006IAo\u001c*bI&\fgn]\u0001\ni>$Um\u001a:fKN\f\u0001\u0002[1tQ\u000e{G-Z\u0001\u0007KF,\u0018\r\\:\u0015\t\u0005=\u0012Q\u000e\u0005\n\u0003_\u0002\u0013\u0011!a\u0001\u0003c\n1\u0001\u001f\u00132!\rI\u00151O\u0005\u0004\u0003k\"%aA!os\u0006Q!+[2i\t>,(\r\\3\u0011\u00055\u00133c\u0001\u0012\u0002~A\u0019\u0011*a \n\u0007\u0005\u0005EI\u0001\u0004B]f\u0014VM\u001a\u000b\u0003\u0003s\nQB\\;nI\u0015DH/\u001a8tS>tGc\u0001/\u0002\n\"1\u00111\u0012\u0013A\u0002a\u000bQ\u0001\n;iSN\fQb\u001c:eI\u0015DH/\u001a8tS>tGc\u00018\u0002\u0012\"1\u00111R\u0013A\u0002a\u000bQ#\u001b8uK\u001e\u0014\u0018\r\u001c(v[\u0012*\u0007\u0010^3og&|g\u000eF\u0002x\u0003/Ca!a#'\u0001\u0004A\u0016!\u00063pk\ndWMV1mk\u0016$S\r\u001f;f]NLwN\u001c\u000b\u0004w\u0006u\u0005BBAFO\u0001\u0007\u0001,\u0001\u000bgY>\fGOV1mk\u0016$S\r\u001f;f]NLwN\u001c\u000b\u0004{\u0006\r\u0006BBAFQ\u0001\u0007\u0001,A\nm_:<g+\u00197vK\u0012*\u0007\u0010^3og&|g\u000e\u0006\u0003\u0002\u0006\u0005%\u0006BBAFS\u0001\u0007\u0001,\u0001\nj]R4\u0016\r\\;fI\u0015DH/\u001a8tS>tG\u0003BA\b\u0003_Ca!a#+\u0001\u0004A\u0016a\u00052zi\u00164\u0016\r\\;fI\u0015DH/\u001a8tS>tG\u0003BA\r\u0003kCa!a#,\u0001\u0004A\u0016\u0001F:i_J$h+\u00197vK\u0012*\u0007\u0010^3og&|g\u000e\u0006\u0003\u0002$\u0005m\u0006BBAFY\u0001\u0007\u0001,A\tjg^Cw\u000e\\3%Kb$XM\\:j_:$B!!\f\u0002B\"1\u00111R\u0017A\u0002a\u000bQ#[:WC2LGMQ=uK\u0012*\u0007\u0010^3og&|g\u000e\u0006\u0003\u00020\u0005\u001d\u0007BBAF]\u0001\u0007\u0001,\u0001\fjgZ\u000bG.\u001b3TQ>\u0014H\u000fJ3yi\u0016t7/[8o)\u0011\ty#!4\t\r\u0005-u\u00061\u0001Y\u0003UI7OV1mS\u0012\u001c\u0005.\u0019:%Kb$XM\\:j_:$B!a\f\u0002T\"1\u00111\u0012\u0019A\u0002a\u000bA#[:WC2LG-\u00138uI\u0015DH/\u001a8tS>tG\u0003BA\u0018\u00033Da!a#2\u0001\u0004A\u0016aD5t\u001d\u0006tE%\u001a=uK:\u001c\u0018n\u001c8\u0015\t\u0005=\u0012q\u001c\u0005\u0007\u0003\u0017\u0013\u0004\u0019\u0001-\u0002)%\u001c\u0018J\u001c4j]&$\u0018\u0010J3yi\u0016t7/[8o)\u0011\ty#!:\t\r\u0005-5\u00071\u0001Y\u0003]I7\u000fU8t\u0013:4\u0017N\\5us\u0012*\u0007\u0010^3og&|g\u000e\u0006\u0003\u00020\u0005-\bBBAFi\u0001\u0007\u0001,A\fjg:+w-\u00138gS:LG/\u001f\u0013fqR,gn]5p]R!\u0011qFAy\u0011\u0019\tY)\u000ea\u00011\u0006i\u0011MY:%Kb$XM\\:j_:$2\u0001UA|\u0011\u0019\tYI\u000ea\u00011\u0006iQ.\u0019=%Kb$XM\\:j_:$B!!@\u0003\u0002Q\u0019\u0001+a@\t\r\u0005=s\u00071\u0001Q\u0011\u0019\tYi\u000ea\u00011\u0006iQ.\u001b8%Kb$XM\\:j_:$BAa\u0002\u0003\fQ\u0019\u0001K!\u0003\t\r\u0005=\u0003\b1\u0001Q\u0011\u0019\tY\t\u000fa\u00011\u0006\u00012/[4ok6$S\r\u001f;f]NLwN\u001c\u000b\u0005\u0003#\u0011\t\u0002\u0003\u0004\u0002\ff\u0002\r\u0001W\u0001\u0010e>,h\u000e\u001a\u0013fqR,gn]5p]R!\u0011q\u0001B\f\u0011\u0019\tYI\u000fa\u00011\u0006q1-Z5mI\u0015DH/\u001a8tS>tGc\u0001)\u0003\u001e!1\u00111R\u001eA\u0002a\u000bqB\u001a7p_J$S\r\u001f;f]NLwN\u001c\u000b\u0004!\n\r\u0002BBAFy\u0001\u0007\u0001,A\nu_J\u000bG-[1og\u0012*\u0007\u0010^3og&|g\u000eF\u0002Q\u0005SAa!a#>\u0001\u0004A\u0016a\u0005;p\t\u0016<'/Z3tI\u0015DH/\u001a8tS>tGc\u0001)\u00030!1\u00111\u0012 A\u0002a\u000b!\u0003[1tQ\u000e{G-\u001a\u0013fqR,gn]5p]R!\u0011q\u0002B\u001b\u0011\u0019\tYi\u0010a\u00011\u0006\u0001R-];bYN$S\r\u001f;f]NLwN\u001c\u000b\u0005\u0005w\u0011y\u0004\u0006\u0003\u00020\tu\u0002\"CA8\u0001\u0006\u0005\t\u0019AA9\u0011\u0019\tY\t\u0011a\u00011\u0002")
public final class RichDouble
implements FractionalProxy<Object> {
    private final double self;

    public static boolean equals$extension(double d, Object object) {
        return RichDouble$.MODULE$.equals$extension(d, object);
    }

    public static int hashCode$extension(double d) {
        return RichDouble$.MODULE$.hashCode$extension(d);
    }

    public static double toDegrees$extension(double d) {
        return RichDouble$.MODULE$.toDegrees$extension(d);
    }

    public static double toRadians$extension(double d) {
        return RichDouble$.MODULE$.toRadians$extension(d);
    }

    public static double floor$extension(double d) {
        return RichDouble$.MODULE$.floor$extension(d);
    }

    public static double ceil$extension(double d) {
        return RichDouble$.MODULE$.ceil$extension(d);
    }

    public static long round$extension(double d) {
        return RichDouble$.MODULE$.round$extension(d);
    }

    public static int signum$extension(double d) {
        return RichDouble$.MODULE$.signum$extension(d);
    }

    public static double min$extension(double d, double d2) {
        return RichDouble$.MODULE$.min$extension(d, d2);
    }

    public static double max$extension(double d, double d2) {
        return RichDouble$.MODULE$.max$extension(d, d2);
    }

    public static double abs$extension(double d) {
        return RichDouble$.MODULE$.abs$extension(d);
    }

    public static boolean isNegInfinity$extension(double d) {
        return RichDouble$.MODULE$.isNegInfinity$extension(d);
    }

    public static boolean isPosInfinity$extension(double d) {
        return RichDouble$.MODULE$.isPosInfinity$extension(d);
    }

    public static boolean isInfinity$extension(double d) {
        return RichDouble$.MODULE$.isInfinity$extension(d);
    }

    public static boolean isNaN$extension(double d) {
        return RichDouble$.MODULE$.isNaN$extension(d);
    }

    public static boolean isValidInt$extension(double d) {
        return RichDouble$.MODULE$.isValidInt$extension(d);
    }

    public static boolean isValidChar$extension(double d) {
        return RichDouble$.MODULE$.isValidChar$extension(d);
    }

    public static boolean isValidShort$extension(double d) {
        return RichDouble$.MODULE$.isValidShort$extension(d);
    }

    public static boolean isValidByte$extension(double d) {
        return RichDouble$.MODULE$.isValidByte$extension(d);
    }

    public static boolean isWhole$extension(double d) {
        return RichDouble$.MODULE$.isWhole$extension(d);
    }

    public static short shortValue$extension(double d) {
        return RichDouble$.MODULE$.shortValue$extension(d);
    }

    public static byte byteValue$extension(double d) {
        return RichDouble$.MODULE$.byteValue$extension(d);
    }

    public static int intValue$extension(double d) {
        return RichDouble$.MODULE$.intValue$extension(d);
    }

    public static long longValue$extension(double d) {
        return RichDouble$.MODULE$.longValue$extension(d);
    }

    public static float floatValue$extension(double d) {
        return RichDouble$.MODULE$.floatValue$extension(d);
    }

    public static double doubleValue$extension(double d) {
        return RichDouble$.MODULE$.doubleValue$extension(d);
    }

    public static Numeric$DoubleAsIfIntegral$ integralNum$extension(double d) {
        return RichDouble$.MODULE$.integralNum$extension(d);
    }

    public static Ordering$Double$ ord$extension(double d) {
        return RichDouble$.MODULE$.ord$extension(d);
    }

    public static Numeric$DoubleIsFractional$ num$extension(double d) {
        return RichDouble$.MODULE$.num$extension(d);
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
    public double self() {
        return this.self;
    }

    public Numeric$DoubleIsFractional$ num() {
        return RichDouble$.MODULE$.num$extension(this.self());
    }

    public Ordering$Double$ ord() {
        return RichDouble$.MODULE$.ord$extension(this.self());
    }

    public Numeric$DoubleAsIfIntegral$ integralNum() {
        return RichDouble$.MODULE$.integralNum$extension(this.self());
    }

    @Override
    public double doubleValue() {
        return RichDouble$.MODULE$.doubleValue$extension(this.self());
    }

    @Override
    public float floatValue() {
        return RichDouble$.MODULE$.floatValue$extension(this.self());
    }

    @Override
    public long longValue() {
        return RichDouble$.MODULE$.longValue$extension(this.self());
    }

    @Override
    public int intValue() {
        return RichDouble$.MODULE$.intValue$extension(this.self());
    }

    @Override
    public byte byteValue() {
        return RichDouble$.MODULE$.byteValue$extension(this.self());
    }

    @Override
    public short shortValue() {
        return RichDouble$.MODULE$.shortValue$extension(this.self());
    }

    @Override
    public boolean isWhole() {
        return RichDouble$.MODULE$.isWhole$extension(this.self());
    }

    @Override
    public boolean isValidByte() {
        return RichDouble$.MODULE$.isValidByte$extension(this.self());
    }

    @Override
    public boolean isValidShort() {
        return RichDouble$.MODULE$.isValidShort$extension(this.self());
    }

    @Override
    public boolean isValidChar() {
        return RichDouble$.MODULE$.isValidChar$extension(this.self());
    }

    @Override
    public boolean isValidInt() {
        return RichDouble$.MODULE$.isValidInt$extension(this.self());
    }

    public boolean isNaN() {
        return RichDouble$.MODULE$.isNaN$extension(this.self());
    }

    public boolean isInfinity() {
        return RichDouble$.MODULE$.isInfinity$extension(this.self());
    }

    public boolean isPosInfinity() {
        return RichDouble$.MODULE$.isPosInfinity$extension(this.self());
    }

    public boolean isNegInfinity() {
        return RichDouble$.MODULE$.isNegInfinity$extension(this.self());
    }

    @Override
    public double abs() {
        return RichDouble$.MODULE$.abs$extension(this.self());
    }

    @Override
    public double max(double that) {
        return RichDouble$.MODULE$.max$extension(this.self(), that);
    }

    @Override
    public double min(double that) {
        return RichDouble$.MODULE$.min$extension(this.self(), that);
    }

    @Override
    public int signum() {
        return RichDouble$.MODULE$.signum$extension(this.self());
    }

    public long round() {
        return RichDouble$.MODULE$.round$extension(this.self());
    }

    public double ceil() {
        return RichDouble$.MODULE$.ceil$extension(this.self());
    }

    public double floor() {
        return RichDouble$.MODULE$.floor$extension(this.self());
    }

    public double toRadians() {
        return RichDouble$.MODULE$.toRadians$extension(this.self());
    }

    public double toDegrees() {
        return RichDouble$.MODULE$.toDegrees$extension(this.self());
    }

    @Override
    public int hashCode() {
        return RichDouble$.MODULE$.hashCode$extension(this.self());
    }

    @Override
    public boolean equals(Object x$1) {
        return RichDouble$.MODULE$.equals$extension(this.self(), x$1);
    }

    public RichDouble(double self) {
        this.self = self;
        ScalaNumericAnyConversions.$init$(this);
        Proxy.$init$(this);
        Ordered.$init$(this);
        OrderedProxy.$init$(this);
        ScalaNumberProxy.$init$(this);
        FractionalProxy.$init$(this);
    }
}

