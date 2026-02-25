/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import scala.Proxy;
import scala.math.Numeric$ByteIsIntegral$;
import scala.math.Ordered;
import scala.math.Ordering$Byte$;
import scala.math.ScalaNumericAnyConversions;
import scala.reflect.ScalaSignature;
import scala.runtime.OrderedProxy;
import scala.runtime.RichByte$;
import scala.runtime.ScalaNumberProxy;
import scala.runtime.ScalaWholeNumberProxy;

@ScalaSignature(bytes="\u0006\u0001\u00055e\u0001B\u0013'\u0005-B\u0001b\u000e\u0001\u0003\u0006\u0004%\t\u0001\u000f\u0005\ts\u0001\u0011\t\u0011)A\u0005i!)!\b\u0001C\u0001w!)a\b\u0001C\t\u007f!)\u0001\u000b\u0001C\t#\")\u0011\f\u0001C!5\")a\f\u0001C!?\")1\r\u0001C!I\")\u0001\u000e\u0001C!S\")Q\u000e\u0001C!]\")q\u000e\u0001C!a\")A\u000f\u0001C!k\")\u0011\u0010\u0001C!q!)!\u0010\u0001C!w\")a\u0010\u0001C!\u007f\"9\u00111\u0001\u0001\u0005B\u0005\u0015\u0001\u0002CA\u0004\u0001\u0005\u0005I\u0011I5\t\u0013\u0005%\u0001!!A\u0005B\u0005-q!CA\fM\u0005\u0005\t\u0012AA\r\r!)c%!A\t\u0002\u0005m\u0001B\u0002\u001e\u0015\t\u0003\t\u0019\u0003C\u0004\u0002&Q!)!a\n\t\u000f\u00055B\u0003\"\u0002\u00020!9\u00111\u0007\u000b\u0005\u0006\u0005U\u0002bBA\u001d)\u0011\u0015\u00111\b\u0005\b\u0003\u007f!BQAA!\u0011\u001d\t)\u0005\u0006C\u0003\u0003\u000fBq!a\u0013\u0015\t\u000b\ti\u0005C\u0004\u0002RQ!)!a\u0015\t\u000f\u0005]C\u0003\"\u0002\u0002Z!9\u0011Q\f\u000b\u0005\u0006\u0005}\u0003bBA2)\u0011\u0015\u0011Q\r\u0005\b\u0003[\"BQAA8\u0011\u001d\t9\b\u0006C\u0003\u0003sB\u0011\"! \u0015\u0003\u0003%)!a \t\u0013\u0005\rE#!A\u0005\u0006\u0005\u0015%\u0001\u0003*jG\"\u0014\u0015\u0010^3\u000b\u0005\u001dB\u0013a\u0002:v]RLW.\u001a\u0006\u0002S\u0005)1oY1mC\u000e\u00011c\u0001\u0001-aA\u0011QFL\u0007\u0002Q%\u0011q\u0006\u000b\u0002\u0007\u0003:Lh+\u00197\u0011\u0007E\u0012D'D\u0001'\u0013\t\u0019dEA\u000bTG\u0006d\u0017m\u00165pY\u0016tU/\u001c2feB\u0013x\u000e_=\u0011\u00055*\u0014B\u0001\u001c)\u0005\u0011\u0011\u0015\u0010^3\u0002\tM,GNZ\u000b\u0002i\u0005)1/\u001a7gA\u00051A(\u001b8jiz\"\"\u0001P\u001f\u0011\u0005E\u0002\u0001\"B\u001c\u0004\u0001\u0004!\u0014a\u00018v[V\t\u0001I\u0004\u0002B\u001b:\u0011!I\u0013\b\u0003\u0007\"s!\u0001R$\u000e\u0003\u0015S!A\u0012\u0016\u0002\rq\u0012xn\u001c;?\u0013\u0005I\u0013BA%)\u0003\u0011i\u0017\r\u001e5\n\u0005-c\u0015a\u0002(v[\u0016\u0014\u0018n\u0019\u0006\u0003\u0013\"J!AT(\u0002\u001d\tKH/Z%t\u0013:$Xm\u001a:bY*\u00111\nT\u0001\u0004_J$W#\u0001*\u000f\u0005M3fB\u0001\"U\u0013\t)F*\u0001\u0005Pe\u0012,'/\u001b8h\u0013\t9\u0006,\u0001\u0003CsR,'BA+M\u0003-!w.\u001e2mKZ\u000bG.^3\u0015\u0003m\u0003\"!\f/\n\u0005uC#A\u0002#pk\ndW-\u0001\u0006gY>\fGOV1mk\u0016$\u0012\u0001\u0019\t\u0003[\u0005L!A\u0019\u0015\u0003\u000b\u0019cw.\u0019;\u0002\u00131|gn\u001a,bYV,G#A3\u0011\u000552\u0017BA4)\u0005\u0011auN\\4\u0002\u0011%tGOV1mk\u0016$\u0012A\u001b\t\u0003[-L!\u0001\u001c\u0015\u0003\u0007%sG/A\u0005csR,g+\u00197vKR\tA'\u0001\u0006tQ>\u0014HOV1mk\u0016$\u0012!\u001d\t\u0003[IL!a\u001d\u0015\u0003\u000bMCwN\u001d;\u0002\u0017%\u001ch+\u00197jI\nKH/Z\u000b\u0002mB\u0011Qf^\u0005\u0003q\"\u0012qAQ8pY\u0016\fg.A\u0002bEN\f1!\\1y)\t!D\u0010C\u0003~\u001d\u0001\u0007A'\u0001\u0003uQ\u0006$\u0018aA7j]R\u0019A'!\u0001\t\u000bu|\u0001\u0019\u0001\u001b\u0002\rMLwM\\;n+\u0005Q\u0017\u0001\u00035bg\"\u001cu\u000eZ3\u0002\r\u0015\fX/\u00197t)\r1\u0018Q\u0002\u0005\n\u0003\u001f\u0011\u0012\u0011!a\u0001\u0003#\t1\u0001\u001f\u00132!\ri\u00131C\u0005\u0004\u0003+A#aA!os\u0006A!+[2i\u0005f$X\r\u0005\u00022)M\u0019A#!\b\u0011\u00075\ny\"C\u0002\u0002\"!\u0012a!\u00118z%\u00164GCAA\r\u00035qW/\u001c\u0013fqR,gn]5p]R\u0019\u0001)!\u000b\t\r\u0005-b\u00031\u0001=\u0003\u0015!C\u000f[5t\u00035y'\u000f\u001a\u0013fqR,gn]5p]R\u0019!+!\r\t\r\u0005-r\u00031\u0001=\u0003U!w.\u001e2mKZ\u000bG.^3%Kb$XM\\:j_:$2AWA\u001c\u0011\u0019\tY\u0003\u0007a\u0001y\u0005!b\r\\8biZ\u000bG.^3%Kb$XM\\:j_:$2aXA\u001f\u0011\u0019\tY#\u0007a\u0001y\u0005\u0019Bn\u001c8h-\u0006dW/\u001a\u0013fqR,gn]5p]R\u0019A-a\u0011\t\r\u0005-\"\u00041\u0001=\u0003IIg\u000e\u001e,bYV,G%\u001a=uK:\u001c\u0018n\u001c8\u0015\u0007%\fI\u0005\u0003\u0004\u0002,m\u0001\r\u0001P\u0001\u0014Ef$XMV1mk\u0016$S\r\u001f;f]NLwN\u001c\u000b\u0004]\u0006=\u0003BBA\u00169\u0001\u0007A(\u0001\u000btQ>\u0014HOV1mk\u0016$S\r\u001f;f]NLwN\u001c\u000b\u0004a\u0006U\u0003BBA\u0016;\u0001\u0007A(A\u000bjgZ\u000bG.\u001b3CsR,G%\u001a=uK:\u001c\u0018n\u001c8\u0015\u0007Y\fY\u0006\u0003\u0004\u0002,y\u0001\r\u0001P\u0001\u000eC\n\u001cH%\u001a=uK:\u001c\u0018n\u001c8\u0015\u0007Q\n\t\u0007\u0003\u0004\u0002,}\u0001\r\u0001P\u0001\u000e[\u0006DH%\u001a=uK:\u001c\u0018n\u001c8\u0015\t\u0005\u001d\u00141\u000e\u000b\u0004i\u0005%\u0004\"B?!\u0001\u0004!\u0004BBA\u0016A\u0001\u0007A(A\u0007nS:$S\r\u001f;f]NLwN\u001c\u000b\u0005\u0003c\n)\bF\u00025\u0003gBQ!`\u0011A\u0002QBa!a\u000b\"\u0001\u0004a\u0014\u0001E:jO:,X\u000eJ3yi\u0016t7/[8o)\rQ\u00171\u0010\u0005\u0007\u0003W\u0011\u0003\u0019\u0001\u001f\u0002%!\f7\u000f[\"pI\u0016$S\r\u001f;f]NLwN\u001c\u000b\u0004S\u0006\u0005\u0005BBA\u0016G\u0001\u0007A(\u0001\tfcV\fGn\u001d\u0013fqR,gn]5p]R!\u0011qQAF)\r1\u0018\u0011\u0012\u0005\n\u0003\u001f!\u0013\u0011!a\u0001\u0003#Aa!a\u000b%\u0001\u0004a\u0004")
public final class RichByte
implements ScalaWholeNumberProxy<Object> {
    private final byte self;

    public static boolean equals$extension(byte by, Object object) {
        return RichByte$.MODULE$.equals$extension(by, object);
    }

    public static int hashCode$extension(byte by) {
        return RichByte$.MODULE$.hashCode$extension(by);
    }

    public static int signum$extension(byte by) {
        return RichByte$.MODULE$.signum$extension(by);
    }

    public static byte min$extension(byte by, byte by2) {
        return RichByte$.MODULE$.min$extension(by, by2);
    }

    public static byte max$extension(byte by, byte by2) {
        return RichByte$.MODULE$.max$extension(by, by2);
    }

    public static byte abs$extension(byte by) {
        return RichByte$.MODULE$.abs$extension(by);
    }

    public static boolean isValidByte$extension(byte by) {
        return RichByte$.MODULE$.isValidByte$extension(by);
    }

    public static short shortValue$extension(byte by) {
        return RichByte$.MODULE$.shortValue$extension(by);
    }

    public static byte byteValue$extension(byte by) {
        return RichByte$.MODULE$.byteValue$extension(by);
    }

    public static int intValue$extension(byte by) {
        return RichByte$.MODULE$.intValue$extension(by);
    }

    public static long longValue$extension(byte by) {
        return RichByte$.MODULE$.longValue$extension(by);
    }

    public static float floatValue$extension(byte by) {
        return RichByte$.MODULE$.floatValue$extension(by);
    }

    public static double doubleValue$extension(byte by) {
        return RichByte$.MODULE$.doubleValue$extension(by);
    }

    public static Ordering$Byte$ ord$extension(byte by) {
        return RichByte$.MODULE$.ord$extension(by);
    }

    public static Numeric$ByteIsIntegral$ num$extension(byte by) {
        return RichByte$.MODULE$.num$extension(by);
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
    public boolean isValidShort() {
        return ScalaNumericAnyConversions.isValidShort$(this);
    }

    @Override
    public boolean isValidInt() {
        return ScalaNumericAnyConversions.isValidInt$(this);
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
    public byte self() {
        return this.self;
    }

    public Numeric$ByteIsIntegral$ num() {
        return RichByte$.MODULE$.num$extension(this.self());
    }

    public Ordering$Byte$ ord() {
        return RichByte$.MODULE$.ord$extension(this.self());
    }

    @Override
    public double doubleValue() {
        return RichByte$.MODULE$.doubleValue$extension(this.self());
    }

    @Override
    public float floatValue() {
        return RichByte$.MODULE$.floatValue$extension(this.self());
    }

    @Override
    public long longValue() {
        return RichByte$.MODULE$.longValue$extension(this.self());
    }

    @Override
    public int intValue() {
        return RichByte$.MODULE$.intValue$extension(this.self());
    }

    @Override
    public byte byteValue() {
        return RichByte$.MODULE$.byteValue$extension(this.self());
    }

    @Override
    public short shortValue() {
        return RichByte$.MODULE$.shortValue$extension(this.self());
    }

    @Override
    public boolean isValidByte() {
        return RichByte$.MODULE$.isValidByte$extension(this.self());
    }

    @Override
    public byte abs() {
        return RichByte$.MODULE$.abs$extension(this.self());
    }

    @Override
    public byte max(byte that) {
        return RichByte$.MODULE$.max$extension(this.self(), that);
    }

    @Override
    public byte min(byte that) {
        return RichByte$.MODULE$.min$extension(this.self(), that);
    }

    @Override
    public int signum() {
        return RichByte$.MODULE$.signum$extension(this.self());
    }

    @Override
    public int hashCode() {
        return RichByte$.MODULE$.hashCode$extension(this.self());
    }

    @Override
    public boolean equals(Object x$1) {
        return RichByte$.MODULE$.equals$extension(this.self(), x$1);
    }

    public RichByte(byte self) {
        this.self = self;
        ScalaNumericAnyConversions.$init$(this);
        Proxy.$init$(this);
        Ordered.$init$(this);
        OrderedProxy.$init$(this);
        ScalaNumberProxy.$init$(this);
        ScalaWholeNumberProxy.$init$(this);
    }
}

