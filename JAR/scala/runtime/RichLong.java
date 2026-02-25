/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import scala.Proxy;
import scala.collection.immutable.NumericRange;
import scala.math.Numeric$LongIsIntegral$;
import scala.math.Ordered;
import scala.math.Ordering$Long$;
import scala.math.ScalaNumericAnyConversions;
import scala.reflect.ScalaSignature;
import scala.runtime.IntegralProxy;
import scala.runtime.OrderedProxy;
import scala.runtime.RichLong$;
import scala.runtime.ScalaNumberProxy;
import scala.runtime.ScalaWholeNumberProxy;

@ScalaSignature(bytes="\u0006\u0001\tEa\u0001B\u001b7\u0005mB\u0001b\u0012\u0001\u0003\u0006\u0004%\t\u0001\u0013\u0005\t\u0013\u0002\u0011\t\u0011)A\u0005\t\")!\n\u0001C\u0001\u0017\")a\n\u0001C\t\u001f\")\u0001\r\u0001C\tC\")\u0011\u000e\u0001C!U\")a\u000e\u0001C!_\")1\u000f\u0001C!i\")Q\u000f\u0001C!m\")!\u0010\u0001C!w\"1q\u0010\u0001C!\u0003\u0003Aq!!\u0003\u0001\t\u0003\nY\u0001C\u0004\u0002\u0014\u0001!\t%a\u0003\t\u000f\u0005U\u0001\u0001\"\u0011\u0002\f!9\u0011q\u0003\u0001\u0005B\u0005-\u0001bBA\r\u0001\u0011\u0005\u00111\u0002\u0005\u0007\u00037\u0001A\u0011\t%\t\u000f\u0005u\u0001\u0001\"\u0011\u0002 !9\u0011Q\u0005\u0001\u0005B\u0005\u001d\u0002bBA\u0016\u0001\u0011\u0005\u0013Q\u0006\u0005\u0007\u0003_\u0001A\u0011\u0001%\t\u000f\u0005\u0005\u0003\u0001\"\u0001\u0002D!9\u0011Q\u000b\u0001\u0005\u0002\u0005\r\u0003bBA,\u0001\u0011\u0005\u00111\t\u0005\t\u00033\u0002\u0011\u0011!C!m\"I\u00111\f\u0001\u0002\u0002\u0013\u0005\u0013QL\u0004\n\u0003S2\u0014\u0011!E\u0001\u0003W2\u0001\"\u000e\u001c\u0002\u0002#\u0005\u0011Q\u000e\u0005\u0007\u0015r!\t!!\u001e\t\u000f\u0005]D\u0004\"\u0002\u0002z!9\u0011q\u0010\u000f\u0005\u0006\u0005\u0005\u0005bBAC9\u0011\u0015\u0011q\u0011\u0005\b\u0003\u0017cBQAAG\u0011\u001d\t\t\n\bC\u0003\u0003'Cq!a&\u001d\t\u000b\tI\nC\u0004\u0002\u001er!)!a(\t\u000f\u0005\rF\u0004\"\u0002\u0002&\"9\u0011\u0011\u0016\u000f\u0005\u0006\u0005-\u0006bBAX9\u0011\u0015\u0011\u0011\u0017\u0005\b\u0003kcBQAA\\\u0011\u001d\tY\f\bC\u0003\u0003{Cq!!1\u001d\t\u000b\t\u0019\rC\u0004\u0002Hr!)!!3\t\u000f\u00055G\u0004\"\u0002\u0002P\"9\u0011q\u001b\u000f\u0005\u0006\u0005e\u0007bBAq9\u0011\u0015\u00111\u001d\u0005\b\u0003OdBQAAu\u0011\u001d\ty\u000f\bC\u0003\u0003cDq!!>\u001d\t\u000b\t9\u0010C\u0004\u0002|r!)!!@\t\u0013\t\u0005A$!A\u0005\u0006\t\r\u0001\"\u0003B\u00049\u0005\u0005IQ\u0001B\u0005\u0005!\u0011\u0016n\u00195M_:<'BA\u001c9\u0003\u001d\u0011XO\u001c;j[\u0016T\u0011!O\u0001\u0006g\u000e\fG.Y\u0002\u0001'\r\u0001A\b\u0011\t\u0003{yj\u0011\u0001O\u0005\u0003\u007fa\u0012a!\u00118z-\u0006d\u0007cA!C\t6\ta'\u0003\u0002Dm\ti\u0011J\u001c;fOJ\fG\u000e\u0015:pqf\u0004\"!P#\n\u0005\u0019C$\u0001\u0002'p]\u001e\fAa]3mMV\tA)A\u0003tK24\u0007%\u0001\u0004=S:LGO\u0010\u000b\u0003\u00196\u0003\"!\u0011\u0001\t\u000b\u001d\u001b\u0001\u0019\u0001#\u0002\u00079,X.F\u0001Q\u001d\t\tVL\u0004\u0002S5:\u00111\u000b\u0017\b\u0003)^k\u0011!\u0016\u0006\u0003-j\na\u0001\u0010:p_Rt\u0014\"A\u001d\n\u0005eC\u0014\u0001B7bi\"L!a\u0017/\u0002\u000f9+X.\u001a:jG*\u0011\u0011\fO\u0005\u0003=~\u000ba\u0002T8oO&\u001b\u0018J\u001c;fOJ\fGN\u0003\u0002\\9\u0006\u0019qN\u001d3\u0016\u0003\tt!a\u00194\u000f\u0005I#\u0017BA3]\u0003!y%\u000fZ3sS:<\u0017BA4i\u0003\u0011auN\\4\u000b\u0005\u0015d\u0016a\u00033pk\ndWMV1mk\u0016$\u0012a\u001b\t\u0003{1L!!\u001c\u001d\u0003\r\u0011{WO\u00197f\u0003)1Gn\\1u-\u0006dW/\u001a\u000b\u0002aB\u0011Q(]\u0005\u0003eb\u0012QA\u00127pCR\f\u0011\u0002\\8oOZ\u000bG.^3\u0015\u0003\u0011\u000b\u0001\"\u001b8u-\u0006dW/\u001a\u000b\u0002oB\u0011Q\b_\u0005\u0003sb\u00121!\u00138u\u0003%\u0011\u0017\u0010^3WC2,X\rF\u0001}!\tiT0\u0003\u0002\u007fq\t!!)\u001f;f\u0003)\u0019\bn\u001c:u-\u0006dW/\u001a\u000b\u0003\u0003\u0007\u00012!PA\u0003\u0013\r\t9\u0001\u000f\u0002\u0006'\"|'\u000f^\u0001\fSN4\u0016\r\\5e\u0005f$X-\u0006\u0002\u0002\u000eA\u0019Q(a\u0004\n\u0007\u0005E\u0001HA\u0004C_>dW-\u00198\u0002\u0019%\u001ch+\u00197jINCwN\u001d;\u0002\u0017%\u001ch+\u00197jI\u000eC\u0017M]\u0001\u000bSN4\u0016\r\\5e\u0013:$\u0018aC5t-\u0006d\u0017\u000e\u001a'p]\u001e\f1!\u00192t\u0003\ri\u0017\r\u001f\u000b\u0004\t\u0006\u0005\u0002BBA\u0012%\u0001\u0007A)\u0001\u0003uQ\u0006$\u0018aA7j]R\u0019A)!\u000b\t\r\u0005\r2\u00031\u0001E\u0003\u0019\u0019\u0018n\u001a8v[V\tq/A\u0003s_VtG\rK\u0004\u0016\u0003g\tI$!\u0010\u0011\u0007u\n)$C\u0002\u00028a\u0012!\u0002Z3qe\u0016\u001c\u0017\r^3eC\t\tY$A:uQ&\u001c\b%[:!C:\u0004\u0013N\u001c;fO\u0016\u0014\b\u0005^=qKn\u0002C\u000f[3sK\u0002J7\u000f\t8pAI,\u0017m]8oAQ|\u0007E]8v]\u0012\u0004\u0013\u000e\u001e\u0018!AA+'\u000f[1qg\u0002Jx.\u001e\u0011nK\u0006tG\u000f\t;pA\r\fG\u000e\u001c\u0011uQ&\u001c\be\u001c8!C\u00022Gn\\1uS:<W\u0006]8j]R\u0004c/\u00197vK~\n#!a\u0010\u0002\rIr\u0013'\r\u00181\u00039!xNQ5oCJL8\u000b\u001e:j]\u001e,\"!!\u0012\u0011\t\u0005\u001d\u0013q\n\b\u0005\u0003\u0013\nY\u0005\u0005\u0002Uq%\u0019\u0011Q\n\u001d\u0002\rA\u0013X\rZ3g\u0013\u0011\t\t&a\u0015\u0003\rM#(/\u001b8h\u0015\r\ti\u0005O\u0001\fi>DU\r_*ue&tw-A\u0007u_>\u001bG/\u00197TiJLgnZ\u0001\tQ\u0006\u001c\bnQ8eK\u00061Q-];bYN$B!!\u0004\u0002`!I\u0011\u0011\r\u000e\u0002\u0002\u0003\u0007\u00111M\u0001\u0004q\u0012\n\u0004cA\u001f\u0002f%\u0019\u0011q\r\u001d\u0003\u0007\u0005s\u00170\u0001\u0005SS\u000eDGj\u001c8h!\t\tEdE\u0002\u001d\u0003_\u00022!PA9\u0013\r\t\u0019\b\u000f\u0002\u0007\u0003:L(+\u001a4\u0015\u0005\u0005-\u0014!\u00048v[\u0012*\u0007\u0010^3og&|g\u000eF\u0002Q\u0003wBa!! \u001f\u0001\u0004a\u0015!\u0002\u0013uQ&\u001c\u0018!D8sI\u0012*\u0007\u0010^3og&|g\u000eF\u0002c\u0003\u0007Ca!!  \u0001\u0004a\u0015!\u00063pk\ndWMV1mk\u0016$S\r\u001f;f]NLwN\u001c\u000b\u0004U\u0006%\u0005BBA?A\u0001\u0007A*\u0001\u000bgY>\fGOV1mk\u0016$S\r\u001f;f]NLwN\u001c\u000b\u0004_\u0006=\u0005BBA?C\u0001\u0007A*A\nm_:<g+\u00197vK\u0012*\u0007\u0010^3og&|g\u000eF\u0002u\u0003+Ca!! #\u0001\u0004a\u0015AE5oiZ\u000bG.^3%Kb$XM\\:j_:$2A^AN\u0011\u0019\tih\ta\u0001\u0019\u0006\u0019\"-\u001f;f-\u0006dW/\u001a\u0013fqR,gn]5p]R\u001910!)\t\r\u0005uD\u00051\u0001M\u0003Q\u0019\bn\u001c:u-\u0006dW/\u001a\u0013fqR,gn]5p]R!\u0011\u0011AAT\u0011\u0019\ti(\na\u0001\u0019\u0006)\u0012n\u001d,bY&$')\u001f;fI\u0015DH/\u001a8tS>tG\u0003BA\u0007\u0003[Ca!! '\u0001\u0004a\u0015AF5t-\u0006d\u0017\u000eZ*i_J$H%\u001a=uK:\u001c\u0018n\u001c8\u0015\t\u00055\u00111\u0017\u0005\u0007\u0003{:\u0003\u0019\u0001'\u0002+%\u001ch+\u00197jI\u000eC\u0017M\u001d\u0013fqR,gn]5p]R!\u0011QBA]\u0011\u0019\ti\b\u000ba\u0001\u0019\u0006!\u0012n\u001d,bY&$\u0017J\u001c;%Kb$XM\\:j_:$B!!\u0004\u0002@\"1\u0011QP\u0015A\u00021\u000bQ#[:WC2LG\rT8oO\u0012*\u0007\u0010^3og&|g\u000e\u0006\u0003\u0002\u000e\u0005\u0015\u0007BBA?U\u0001\u0007A*A\u0007bEN$S\r\u001f;f]NLwN\u001c\u000b\u0004\t\u0006-\u0007BBA?W\u0001\u0007A*A\u0007nCb$S\r\u001f;f]NLwN\u001c\u000b\u0005\u0003#\f)\u000eF\u0002E\u0003'Da!a\t-\u0001\u0004!\u0005BBA?Y\u0001\u0007A*A\u0007nS:$S\r\u001f;f]NLwN\u001c\u000b\u0005\u00037\fy\u000eF\u0002E\u0003;Da!a\t.\u0001\u0004!\u0005BBA?[\u0001\u0007A*\u0001\ttS\u001etW/\u001c\u0013fqR,gn]5p]R\u0019q/!:\t\r\u0005ud\u00061\u0001M\u0003=\u0011x.\u001e8eI\u0015DH/\u001a8tS>tGc\u0001#\u0002l\"1\u0011QP\u0018A\u00021CsaLA\u001a\u0003s\ti$\u0001\ru_\nKg.\u0019:z'R\u0014\u0018N\\4%Kb$XM\\:j_:$B!!\u0012\u0002t\"1\u0011Q\u0010\u0019A\u00021\u000bQ\u0003^8IKb\u001cFO]5oO\u0012*\u0007\u0010^3og&|g\u000e\u0006\u0003\u0002F\u0005e\bBBA?c\u0001\u0007A*A\fu_>\u001bG/\u00197TiJLgn\u001a\u0013fqR,gn]5p]R!\u0011QIA\u0000\u0011\u0019\tiH\ra\u0001\u0019\u0006\u0011\u0002.Y:i\u0007>$W\rJ3yi\u0016t7/[8o)\r1(Q\u0001\u0005\u0007\u0003{\u001a\u0004\u0019\u0001'\u0002!\u0015\fX/\u00197tI\u0015DH/\u001a8tS>tG\u0003\u0002B\u0006\u0005\u001f!B!!\u0004\u0003\u000e!I\u0011\u0011\r\u001b\u0002\u0002\u0003\u0007\u00111\r\u0005\u0007\u0003{\"\u0004\u0019\u0001'")
public final class RichLong
implements IntegralProxy<Object> {
    private final long self;

    public static boolean equals$extension(long l, Object object) {
        return RichLong$.MODULE$.equals$extension(l, object);
    }

    public static int hashCode$extension(long l) {
        return RichLong$.MODULE$.hashCode$extension(l);
    }

    public static String toOctalString$extension(long l) {
        return RichLong$.MODULE$.toOctalString$extension(l);
    }

    public static String toHexString$extension(long l) {
        return RichLong$.MODULE$.toHexString$extension(l);
    }

    public static String toBinaryString$extension(long l) {
        return RichLong$.MODULE$.toBinaryString$extension(l);
    }

    public static long round$extension(long l) {
        return RichLong$.MODULE$.round$extension(l);
    }

    public static int signum$extension(long l) {
        return RichLong$.MODULE$.signum$extension(l);
    }

    public static long min$extension(long l, long l2) {
        return RichLong$.MODULE$.min$extension(l, l2);
    }

    public static long max$extension(long l, long l2) {
        return RichLong$.MODULE$.max$extension(l, l2);
    }

    public static long abs$extension(long l) {
        return RichLong$.MODULE$.abs$extension(l);
    }

    public static boolean isValidLong$extension(long l) {
        return RichLong$.MODULE$.isValidLong$extension(l);
    }

    public static boolean isValidInt$extension(long l) {
        return RichLong$.MODULE$.isValidInt$extension(l);
    }

    public static boolean isValidChar$extension(long l) {
        return RichLong$.MODULE$.isValidChar$extension(l);
    }

    public static boolean isValidShort$extension(long l) {
        return RichLong$.MODULE$.isValidShort$extension(l);
    }

    public static boolean isValidByte$extension(long l) {
        return RichLong$.MODULE$.isValidByte$extension(l);
    }

    public static short shortValue$extension(long l) {
        return RichLong$.MODULE$.shortValue$extension(l);
    }

    public static byte byteValue$extension(long l) {
        return RichLong$.MODULE$.byteValue$extension(l);
    }

    public static int intValue$extension(long l) {
        return RichLong$.MODULE$.intValue$extension(l);
    }

    public static long longValue$extension(long l) {
        return RichLong$.MODULE$.longValue$extension(l);
    }

    public static float floatValue$extension(long l) {
        return RichLong$.MODULE$.floatValue$extension(l);
    }

    public static double doubleValue$extension(long l) {
        return RichLong$.MODULE$.doubleValue$extension(l);
    }

    public static Ordering$Long$ ord$extension(long l) {
        return RichLong$.MODULE$.ord$extension(l);
    }

    public static Numeric$LongIsIntegral$ num$extension(long l) {
        return RichLong$.MODULE$.num$extension(l);
    }

    @Override
    public NumericRange.Exclusive until(Object end) {
        return IntegralProxy.until$(this, end);
    }

    @Override
    public NumericRange.Exclusive until(Object end, Object step) {
        return IntegralProxy.until$(this, end, step);
    }

    @Override
    public NumericRange.Inclusive to(Object end) {
        return IntegralProxy.to$(this, end);
    }

    @Override
    public NumericRange.Inclusive to(Object end, Object step) {
        return IntegralProxy.to$(this, end, step);
    }

    @Override
    public boolean isWhole() {
        return ScalaWholeNumberProxy.isWhole$(this);
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
    public long self() {
        return this.self;
    }

    public Numeric$LongIsIntegral$ num() {
        return RichLong$.MODULE$.num$extension(this.self());
    }

    public Ordering$Long$ ord() {
        return RichLong$.MODULE$.ord$extension(this.self());
    }

    @Override
    public double doubleValue() {
        return RichLong$.MODULE$.doubleValue$extension(this.self());
    }

    @Override
    public float floatValue() {
        return RichLong$.MODULE$.floatValue$extension(this.self());
    }

    @Override
    public long longValue() {
        return RichLong$.MODULE$.longValue$extension(this.self());
    }

    @Override
    public int intValue() {
        return RichLong$.MODULE$.intValue$extension(this.self());
    }

    @Override
    public byte byteValue() {
        return RichLong$.MODULE$.byteValue$extension(this.self());
    }

    @Override
    public short shortValue() {
        return RichLong$.MODULE$.shortValue$extension(this.self());
    }

    @Override
    public boolean isValidByte() {
        return RichLong$.MODULE$.isValidByte$extension(this.self());
    }

    @Override
    public boolean isValidShort() {
        return RichLong$.MODULE$.isValidShort$extension(this.self());
    }

    @Override
    public boolean isValidChar() {
        return RichLong$.MODULE$.isValidChar$extension(this.self());
    }

    @Override
    public boolean isValidInt() {
        return RichLong$.MODULE$.isValidInt$extension(this.self());
    }

    public boolean isValidLong() {
        return RichLong$.MODULE$.isValidLong$extension(this.self());
    }

    @Override
    public long abs() {
        return RichLong$.MODULE$.abs$extension(this.self());
    }

    @Override
    public long max(long that) {
        return RichLong$.MODULE$.max$extension(this.self(), that);
    }

    @Override
    public long min(long that) {
        return RichLong$.MODULE$.min$extension(this.self(), that);
    }

    @Override
    public int signum() {
        return RichLong$.MODULE$.signum$extension(this.self());
    }

    public long round() {
        return RichLong$.MODULE$.round$extension(this.self());
    }

    public String toBinaryString() {
        return RichLong$.MODULE$.toBinaryString$extension(this.self());
    }

    public String toHexString() {
        return RichLong$.MODULE$.toHexString$extension(this.self());
    }

    public String toOctalString() {
        return RichLong$.MODULE$.toOctalString$extension(this.self());
    }

    @Override
    public int hashCode() {
        return RichLong$.MODULE$.hashCode$extension(this.self());
    }

    @Override
    public boolean equals(Object x$1) {
        return RichLong$.MODULE$.equals$extension(this.self(), x$1);
    }

    public RichLong(long self) {
        this.self = self;
        ScalaNumericAnyConversions.$init$(this);
        Proxy.$init$(this);
        Ordered.$init$(this);
        OrderedProxy.$init$(this);
        ScalaNumberProxy.$init$(this);
        ScalaWholeNumberProxy.$init$(this);
        IntegralProxy.$init$(this);
    }
}

