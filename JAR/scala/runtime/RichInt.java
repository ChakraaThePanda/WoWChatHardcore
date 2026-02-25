/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import scala.Proxy;
import scala.collection.immutable.Range;
import scala.math.Numeric$IntIsIntegral$;
import scala.math.Ordered;
import scala.math.Ordering$Int$;
import scala.math.ScalaNumericAnyConversions;
import scala.reflect.ScalaSignature;
import scala.runtime.OrderedProxy;
import scala.runtime.RangedProxy;
import scala.runtime.RichInt$;
import scala.runtime.ScalaNumberProxy;

@ScalaSignature(bytes="\u0006\u0001\ted\u0001\u0002\u001e<\u0005\u0001C\u0001b\u0014\u0001\u0003\u0006\u0004%\t\u0001\u0015\u0005\t#\u0002\u0011\t\u0011)A\u0005\u0013\")!\u000b\u0001C\u0001'\")a\u000b\u0001C\t/\")\u0001\u000e\u0001C\tS\")\u0011\u000f\u0001C!e\")a\u000f\u0001C!o\")1\u0010\u0001C!y\"9\u0011\u0011\u0001\u0001\u0005B\u0005\r\u0001bBA\u0003\u0001\u0011\u0005\u0013q\u0001\u0005\b\u0003\u001f\u0001A\u0011IA\t\u0011\u001d\tI\u0002\u0001C\u0001\u00037Aq!a\t\u0001\t\u0003\n)\u0003C\u0004\u0002(\u0001!\t!!\n\t\r\u0005%\u0002\u0001\"\u0011Q\u0011\u001d\tY\u0003\u0001C!\u0003[Aq!a\r\u0001\t\u0003\n)\u0004\u0003\u0004\u0002:\u0001!\t\u0005\u0015\u0005\u0007\u0003w\u0001A\u0011\u0001)\t\u000f\u00055\u0003\u0001\"\u0001\u0002P!9\u0011\u0011\r\u0001\u0005\u0002\u0005=\u0003bBA2\u0001\u0011\u0005\u0011qJ\u0003\u0007\u0003K\u0002\u0001!a\u001a\t\u000f\u0005]\u0004\u0001\"\u0001\u0002z!9\u0011q\u000f\u0001\u0005\u0002\u0005}\u0004bBAD\u0001\u0011\u0005\u0011\u0011\u0012\u0005\b\u0003\u000f\u0003A\u0011AAN\u0011%\t\t\u000bAA\u0001\n\u0003\n\u0019\u0001C\u0005\u0002$\u0002\t\t\u0011\"\u0011\u0002&\u001eI\u0011\u0011W\u001e\u0002\u0002#\u0005\u00111\u0017\u0004\tum\n\t\u0011#\u0001\u00026\"1!k\bC\u0001\u0003{Cq!a0 \t\u000b\t\t\rC\u0004\u0002H~!)!!3\t\u000f\u00055w\u0004\"\u0002\u0002P\"9\u00111[\u0010\u0005\u0006\u0005U\u0007bBAm?\u0011\u0015\u00111\u001c\u0005\b\u0003?|BQAAq\u0011\u001d\t)o\bC\u0003\u0003ODq!a; \t\u000b\ti\u000fC\u0004\u0002r~!)!a=\t\u000f\u0005]x\u0004\"\u0002\u0002z\"9\u0011Q`\u0010\u0005\u0006\u0005}\bb\u0002B\u0002?\u0011\u0015!Q\u0001\u0005\b\u0005\u0013yBQ\u0001B\u0006\u0011\u001d\u0011\u0019b\bC\u0003\u0005+AqA!\b \t\u000b\u0011y\u0002C\u0004\u0003$}!)A!\n\t\u000f\t-r\u0004\"\u0002\u0003.!9!\u0011G\u0010\u0005\u0006\tM\u0002b\u0002B\u001c?\u0011\u0015!\u0011\b\u0005\b\u0005{yBQ\u0001B \u0011\u001d\u00119e\bC\u0003\u0005\u0013BqAa\u0015 \t\u000b\u0011)\u0006C\u0004\u0003^}!)Aa\u0018\t\u0013\t%t$!A\u0005\u0006\t-\u0004\"\u0003B8?\u0005\u0005IQ\u0001B9\u0005\u001d\u0011\u0016n\u00195J]RT!\u0001P\u001f\u0002\u000fI,h\u000e^5nK*\ta(A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\t\u0001\tU\t\u0014\t\u0003\u0005\u000ek\u0011!P\u0005\u0003\tv\u0012a!\u00118z-\u0006d\u0007c\u0001$H\u00136\t1(\u0003\u0002Iw\t\u00012kY1mC:+XNY3s!J|\u00070\u001f\t\u0003\u0005*K!aS\u001f\u0003\u0007%sG\u000fE\u0002G\u001b&K!AT\u001e\u0003\u0017I\u000bgnZ3e!J|\u00070_\u0001\u0005g\u0016dg-F\u0001J\u0003\u0015\u0019X\r\u001c4!\u0003\u0019a\u0014N\\5u}Q\u0011A+\u0016\t\u0003\r\u0002AQaT\u0002A\u0002%\u000b1A\\;n+\u0005AfBA-f\u001d\tQ&M\u0004\u0002\\A:\u0011AlX\u0007\u0002;*\u0011alP\u0001\u0007yI|w\u000e\u001e \n\u0003yJ!!Y\u001f\u0002\t5\fG\u000f[\u0005\u0003G\u0012\fqAT;nKJL7M\u0003\u0002b{%\u0011amZ\u0001\u000e\u0013:$\u0018j]%oi\u0016<'/\u00197\u000b\u0005\r$\u0017aA8sIV\t!N\u0004\u0002l]:\u0011!\f\\\u0005\u0003[\u0012\f\u0001b\u0014:eKJLgnZ\u0005\u0003_B\f1!\u00138u\u0015\tiG-A\u0006e_V\u0014G.\u001a,bYV,G#A:\u0011\u0005\t#\u0018BA;>\u0005\u0019!u.\u001e2mK\u0006Qa\r\\8biZ\u000bG.^3\u0015\u0003a\u0004\"AQ=\n\u0005il$!\u0002$m_\u0006$\u0018!\u00037p]\u001e4\u0016\r\\;f)\u0005i\bC\u0001\"\u007f\u0013\tyXH\u0001\u0003M_:<\u0017\u0001C5oiZ\u000bG.^3\u0015\u0003%\u000b\u0011BY=uKZ\u000bG.^3\u0015\u0005\u0005%\u0001c\u0001\"\u0002\f%\u0019\u0011QB\u001f\u0003\t\tKH/Z\u0001\u000bg\"|'\u000f\u001e,bYV,GCAA\n!\r\u0011\u0015QC\u0005\u0004\u0003/i$!B*i_J$\u0018aB5t/\"|G.\u001a\u000b\u0003\u0003;\u00012AQA\u0010\u0013\r\t\t#\u0010\u0002\b\u0005>|G.Z1o\u0003)I7OV1mS\u0012Le\u000e^\u000b\u0003\u0003;\t1\"[:WC2LG\rT8oO\u0006\u0019\u0011MY:\u0002\u00075\f\u0007\u0010F\u0002J\u0003_Aa!!\r\u0011\u0001\u0004I\u0015\u0001\u0002;iCR\f1!\\5o)\rI\u0015q\u0007\u0005\u0007\u0003c\t\u0002\u0019A%\u0002\rMLwM\\;n\u0003\u0015\u0011x.\u001e8eQ\u001d\u0019\u0012qHA#\u0003\u0013\u00022AQA!\u0013\r\t\u0019%\u0010\u0002\u000bI\u0016\u0004(/Z2bi\u0016$\u0017EAA$\u0003M$\b.[:!SN\u0004\u0013M\u001c\u0011j]R,w-\u001a:!if\u0004Xm\u000f\u0011uQ\u0016\u0014X\rI5tA9|\u0007E]3bg>t\u0007\u0005^8!e>,h\u000e\u001a\u0011ji:\u0002\u0003\u0005U3sQ\u0006\u00048\u000fI=pk\u0002jW-\u00198uAQ|\u0007eY1mY\u0002\"\b.[:!_:\u0004\u0013\r\t4m_\u0006$\u0018N\\4.a>Lg\u000e\u001e\u0011wC2,XmP\u0011\u0003\u0003\u0017\naA\r\u00182c9\u0002\u0014A\u0004;p\u0005&t\u0017M]=TiJLgnZ\u000b\u0003\u0003#\u0002B!a\u0015\u0002\\9!\u0011QKA,!\taV(C\u0002\u0002Zu\na\u0001\u0015:fI\u00164\u0017\u0002BA/\u0003?\u0012aa\u0015;sS:<'bAA-{\u0005YAo\u001c%fqN#(/\u001b8h\u00035!xnT2uC2\u001cFO]5oO\n\t\"+Z:vYR<\u0016\u000e\u001e5pkR\u001cF/\u001a9\u0011\t\u0005%\u00141O\u0007\u0003\u0003WRA!!\u001c\u0002p\u0005I\u0011.\\7vi\u0006\u0014G.\u001a\u0006\u0004\u0003cj\u0014AC2pY2,7\r^5p]&!\u0011QOA6\u0005\u0015\u0011\u0016M\\4f\u0003\u0015)h\u000e^5m)\u0011\t9'a\u001f\t\r\u0005u\u0004\u00041\u0001J\u0003\r)g\u000e\u001a\u000b\u0007\u0003O\n\t)a!\t\r\u0005u\u0014\u00041\u0001J\u0011\u0019\t))\u0007a\u0001\u0013\u0006!1\u000f^3q\u0003\t!x\u000e\u0006\u0003\u0002\f\u0006e\u0005\u0003BAG\u0003'sA!!\u001b\u0002\u0010&!\u0011\u0011SA6\u0003\u0015\u0011\u0016M\\4f\u0013\u0011\t)*a&\u0003\u0013%s7\r\\;tSZ,'\u0002BAI\u0003WBa!! \u001b\u0001\u0004IECBAF\u0003;\u000by\n\u0003\u0004\u0002~m\u0001\r!\u0013\u0005\u0007\u0003\u000b[\u0002\u0019A%\u0002\u0011!\f7\u000f[\"pI\u0016\fa!Z9vC2\u001cH\u0003BA\u000f\u0003OC\u0011\"!+\u001e\u0003\u0003\u0005\r!a+\u0002\u0007a$\u0013\u0007E\u0002C\u0003[K1!a,>\u0005\r\te._\u0001\b%&\u001c\u0007.\u00138u!\t1udE\u0002 \u0003o\u00032AQA]\u0013\r\tY,\u0010\u0002\u0007\u0003:L(+\u001a4\u0015\u0005\u0005M\u0016!\u00048v[\u0012*\u0007\u0010^3og&|g\u000eF\u0002Y\u0003\u0007Da!!2\"\u0001\u0004!\u0016!\u0002\u0013uQ&\u001c\u0018!D8sI\u0012*\u0007\u0010^3og&|g\u000eF\u0002k\u0003\u0017Da!!2#\u0001\u0004!\u0016!\u00063pk\ndWMV1mk\u0016$S\r\u001f;f]NLwN\u001c\u000b\u0004e\u0006E\u0007BBAcG\u0001\u0007A+\u0001\u000bgY>\fGOV1mk\u0016$S\r\u001f;f]NLwN\u001c\u000b\u0004o\u0006]\u0007BBAcI\u0001\u0007A+A\nm_:<g+\u00197vK\u0012*\u0007\u0010^3og&|g\u000eF\u0002}\u0003;Da!!2&\u0001\u0004!\u0016AE5oiZ\u000bG.^3%Kb$XM\\:j_:$B!a\u0001\u0002d\"1\u0011Q\u0019\u0014A\u0002Q\u000b1CY=uKZ\u000bG.^3%Kb$XM\\:j_:$B!a\u0002\u0002j\"1\u0011QY\u0014A\u0002Q\u000bAc\u001d5peR4\u0016\r\\;fI\u0015DH/\u001a8tS>tG\u0003BA\t\u0003_Da!!2)\u0001\u0004!\u0016!E5t/\"|G.\u001a\u0013fqR,gn]5p]R!\u00111DA{\u0011\u0019\t)-\u000ba\u0001)\u0006!\u0012n\u001d,bY&$\u0017J\u001c;%Kb$XM\\:j_:$B!!\b\u0002|\"1\u0011Q\u0019\u0016A\u0002Q\u000bQ#[:WC2LG\rT8oO\u0012*\u0007\u0010^3og&|g\u000e\u0006\u0003\u0002\u001e\t\u0005\u0001BBAcW\u0001\u0007A+A\u0007bEN$S\r\u001f;f]NLwN\u001c\u000b\u0004\u0013\n\u001d\u0001BBAcY\u0001\u0007A+A\u0007nCb$S\r\u001f;f]NLwN\u001c\u000b\u0005\u0005\u001b\u0011\t\u0002F\u0002J\u0005\u001fAa!!\r.\u0001\u0004I\u0005BBAc[\u0001\u0007A+A\u0007nS:$S\r\u001f;f]NLwN\u001c\u000b\u0005\u0005/\u0011Y\u0002F\u0002J\u00053Aa!!\r/\u0001\u0004I\u0005BBAc]\u0001\u0007A+\u0001\ttS\u001etW/\u001c\u0013fqR,gn]5p]R\u0019\u0011J!\t\t\r\u0005\u0015w\u00061\u0001U\u0003=\u0011x.\u001e8eI\u0015DH/\u001a8tS>tGcA%\u0003(!1\u0011Q\u0019\u0019A\u0002QCs\u0001MA \u0003\u000b\nI%\u0001\ru_\nKg.\u0019:z'R\u0014\u0018N\\4%Kb$XM\\:j_:$B!!\u0015\u00030!1\u0011QY\u0019A\u0002Q\u000bQ\u0003^8IKb\u001cFO]5oO\u0012*\u0007\u0010^3og&|g\u000e\u0006\u0003\u0002R\tU\u0002BBAce\u0001\u0007A+A\fu_>\u001bG/\u00197TiJLgn\u001a\u0013fqR,gn]5p]R!\u0011\u0011\u000bB\u001e\u0011\u0019\t)m\ra\u0001)\u0006\u0001RO\u001c;jY\u0012*\u0007\u0010^3og&|g\u000e\r\u000b\u0005\u0005\u0003\u0012)\u0005\u0006\u0003\u0002h\t\r\u0003BBA?i\u0001\u0007\u0011\n\u0003\u0004\u0002FR\u0002\r\u0001V\u0001\u0011k:$\u0018\u000e\u001c\u0013fqR,gn]5p]F\"BAa\u0013\u0003RQ1\u0011q\rB'\u0005\u001fBa!! 6\u0001\u0004I\u0005BBACk\u0001\u0007\u0011\n\u0003\u0004\u0002FV\u0002\r\u0001V\u0001\u000ei>$S\r\u001f;f]NLwN\u001c\u0019\u0015\t\t]#1\f\u000b\u0005\u0003\u0017\u0013I\u0006\u0003\u0004\u0002~Y\u0002\r!\u0013\u0005\u0007\u0003\u000b4\u0004\u0019\u0001+\u0002\u001bQ|G%\u001a=uK:\u001c\u0018n\u001c82)\u0011\u0011\tGa\u001a\u0015\r\u0005-%1\rB3\u0011\u0019\tih\u000ea\u0001\u0013\"1\u0011QQ\u001cA\u0002%Ca!!28\u0001\u0004!\u0016A\u00055bg\"\u001cu\u000eZ3%Kb$XM\\:j_:$B!a\u0001\u0003n!1\u0011Q\u0019\u001dA\u0002Q\u000b\u0001#Z9vC2\u001cH%\u001a=uK:\u001c\u0018n\u001c8\u0015\t\tM$q\u000f\u000b\u0005\u0003;\u0011)\bC\u0005\u0002*f\n\t\u00111\u0001\u0002,\"1\u0011QY\u001dA\u0002Q\u0003")
public final class RichInt
implements ScalaNumberProxy<Object>,
RangedProxy<Object> {
    private final int self;

    public static boolean equals$extension(int n, Object object) {
        return RichInt$.MODULE$.equals$extension(n, object);
    }

    public static int hashCode$extension(int n) {
        return RichInt$.MODULE$.hashCode$extension(n);
    }

    public static Range.Inclusive to$extension1(int n, int n2, int n3) {
        return RichInt$.MODULE$.to$extension1(n, n2, n3);
    }

    public static Range.Inclusive to$extension0(int n, int n2) {
        return RichInt$.MODULE$.to$extension0(n, n2);
    }

    public static Range until$extension1(int n, int n2, int n3) {
        return RichInt$.MODULE$.until$extension1(n, n2, n3);
    }

    public static Range until$extension0(int n, int n2) {
        return RichInt$.MODULE$.until$extension0(n, n2);
    }

    public static String toOctalString$extension(int n) {
        return RichInt$.MODULE$.toOctalString$extension(n);
    }

    public static String toHexString$extension(int n) {
        return RichInt$.MODULE$.toHexString$extension(n);
    }

    public static String toBinaryString$extension(int n) {
        return RichInt$.MODULE$.toBinaryString$extension(n);
    }

    public static int round$extension(int n) {
        return RichInt$.MODULE$.round$extension(n);
    }

    public static int signum$extension(int n) {
        return RichInt$.MODULE$.signum$extension(n);
    }

    public static int min$extension(int n, int n2) {
        return RichInt$.MODULE$.min$extension(n, n2);
    }

    public static int max$extension(int n, int n2) {
        return RichInt$.MODULE$.max$extension(n, n2);
    }

    public static int abs$extension(int n) {
        return RichInt$.MODULE$.abs$extension(n);
    }

    public static boolean isValidLong$extension(int n) {
        return RichInt$.MODULE$.isValidLong$extension(n);
    }

    public static boolean isValidInt$extension(int n) {
        return RichInt$.MODULE$.isValidInt$extension(n);
    }

    public static boolean isWhole$extension(int n) {
        return RichInt$.MODULE$.isWhole$extension(n);
    }

    public static short shortValue$extension(int n) {
        return RichInt$.MODULE$.shortValue$extension(n);
    }

    public static byte byteValue$extension(int n) {
        return RichInt$.MODULE$.byteValue$extension(n);
    }

    public static int intValue$extension(int n) {
        return RichInt$.MODULE$.intValue$extension(n);
    }

    public static long longValue$extension(int n) {
        return RichInt$.MODULE$.longValue$extension(n);
    }

    public static float floatValue$extension(int n) {
        return RichInt$.MODULE$.floatValue$extension(n);
    }

    public static double doubleValue$extension(int n) {
        return RichInt$.MODULE$.doubleValue$extension(n);
    }

    public static Ordering$Int$ ord$extension(int n) {
        return RichInt$.MODULE$.ord$extension(n);
    }

    public static Numeric$IntIsIntegral$ num$extension(int n) {
        return RichInt$.MODULE$.num$extension(n);
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
    public boolean isValidByte() {
        return ScalaNumericAnyConversions.isValidByte$(this);
    }

    @Override
    public boolean isValidShort() {
        return ScalaNumericAnyConversions.isValidShort$(this);
    }

    @Override
    public boolean isValidChar() {
        return ScalaNumericAnyConversions.isValidChar$(this);
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
    public int self() {
        return this.self;
    }

    public Numeric$IntIsIntegral$ num() {
        return RichInt$.MODULE$.num$extension(this.self());
    }

    public Ordering$Int$ ord() {
        return RichInt$.MODULE$.ord$extension(this.self());
    }

    @Override
    public double doubleValue() {
        return RichInt$.MODULE$.doubleValue$extension(this.self());
    }

    @Override
    public float floatValue() {
        return RichInt$.MODULE$.floatValue$extension(this.self());
    }

    @Override
    public long longValue() {
        return RichInt$.MODULE$.longValue$extension(this.self());
    }

    @Override
    public int intValue() {
        return RichInt$.MODULE$.intValue$extension(this.self());
    }

    @Override
    public byte byteValue() {
        return RichInt$.MODULE$.byteValue$extension(this.self());
    }

    @Override
    public short shortValue() {
        return RichInt$.MODULE$.shortValue$extension(this.self());
    }

    @Override
    public boolean isWhole() {
        return RichInt$.MODULE$.isWhole$extension(this.self());
    }

    @Override
    public boolean isValidInt() {
        return RichInt$.MODULE$.isValidInt$extension(this.self());
    }

    public boolean isValidLong() {
        return RichInt$.MODULE$.isValidLong$extension(this.self());
    }

    @Override
    public int abs() {
        return RichInt$.MODULE$.abs$extension(this.self());
    }

    @Override
    public int max(int that) {
        return RichInt$.MODULE$.max$extension(this.self(), that);
    }

    @Override
    public int min(int that) {
        return RichInt$.MODULE$.min$extension(this.self(), that);
    }

    @Override
    public int signum() {
        return RichInt$.MODULE$.signum$extension(this.self());
    }

    public int round() {
        return RichInt$.MODULE$.round$extension(this.self());
    }

    public String toBinaryString() {
        return RichInt$.MODULE$.toBinaryString$extension(this.self());
    }

    public String toHexString() {
        return RichInt$.MODULE$.toHexString$extension(this.self());
    }

    public String toOctalString() {
        return RichInt$.MODULE$.toOctalString$extension(this.self());
    }

    public Range until(int end) {
        return RichInt$.MODULE$.until$extension0(this.self(), end);
    }

    public Range until(int end, int step) {
        return RichInt$.MODULE$.until$extension1(this.self(), end, step);
    }

    public Range.Inclusive to(int end) {
        return RichInt$.MODULE$.to$extension0(this.self(), end);
    }

    public Range.Inclusive to(int end, int step) {
        return RichInt$.MODULE$.to$extension1(this.self(), end, step);
    }

    @Override
    public int hashCode() {
        return RichInt$.MODULE$.hashCode$extension(this.self());
    }

    @Override
    public boolean equals(Object x$1) {
        return RichInt$.MODULE$.equals$extension(this.self(), x$1);
    }

    public RichInt(int self) {
        this.self = self;
        ScalaNumericAnyConversions.$init$(this);
        Proxy.$init$(this);
        Ordered.$init$(this);
        OrderedProxy.$init$(this);
        ScalaNumberProxy.$init$(this);
    }
}

