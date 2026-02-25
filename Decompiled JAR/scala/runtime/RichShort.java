/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import scala.Proxy;
import scala.math.Numeric$ShortIsIntegral$;
import scala.math.Ordered;
import scala.math.Ordering$Short$;
import scala.math.ScalaNumericAnyConversions;
import scala.reflect.ScalaSignature;
import scala.runtime.OrderedProxy;
import scala.runtime.RichShort$;
import scala.runtime.ScalaNumberProxy;
import scala.runtime.ScalaWholeNumberProxy;

@ScalaSignature(bytes="\u0006\u0001\u00055e\u0001B\u0013'\u0005-B\u0001b\u000e\u0001\u0003\u0006\u0004%\t\u0001\u000f\u0005\ts\u0001\u0011\t\u0011)A\u0005i!)!\b\u0001C\u0001w!)a\b\u0001C\t\u007f!)\u0001\u000b\u0001C\t#\")\u0011\f\u0001C!5\")a\f\u0001C!?\")1\r\u0001C!I\")\u0001\u000e\u0001C!S\")Q\u000e\u0001C!]\")!\u000f\u0001C!g\")A\u000f\u0001C!k\")\u0011\u0010\u0001C!q!)!\u0010\u0001C!w\")a\u0010\u0001C!\u007f\"9\u00111\u0001\u0001\u0005B\u0005\u0015\u0001\u0002CA\u0004\u0001\u0005\u0005I\u0011I5\t\u0013\u0005%\u0001!!A\u0005B\u0005-q!CA\fM\u0005\u0005\t\u0012AA\r\r!)c%!A\t\u0002\u0005m\u0001B\u0002\u001e\u0015\t\u0003\t\u0019\u0003C\u0004\u0002&Q!)!a\n\t\u000f\u00055B\u0003\"\u0002\u00020!9\u00111\u0007\u000b\u0005\u0006\u0005U\u0002bBA\u001d)\u0011\u0015\u00111\b\u0005\b\u0003\u007f!BQAA!\u0011\u001d\t)\u0005\u0006C\u0003\u0003\u000fBq!a\u0013\u0015\t\u000b\ti\u0005C\u0004\u0002RQ!)!a\u0015\t\u000f\u0005]C\u0003\"\u0002\u0002Z!9\u0011Q\f\u000b\u0005\u0006\u0005}\u0003bBA2)\u0011\u0015\u0011Q\r\u0005\b\u0003[\"BQAA8\u0011\u001d\t9\b\u0006C\u0003\u0003sB\u0011\"! \u0015\u0003\u0003%)!a \t\u0013\u0005\rE#!A\u0005\u0006\u0005\u0015%!\u0003*jG\"\u001c\u0006n\u001c:u\u0015\t9\u0003&A\u0004sk:$\u0018.\\3\u000b\u0003%\nQa]2bY\u0006\u001c\u0001aE\u0002\u0001YA\u0002\"!\f\u0018\u000e\u0003!J!a\f\u0015\u0003\r\u0005s\u0017PV1m!\r\t$\u0007N\u0007\u0002M%\u00111G\n\u0002\u0016'\u000e\fG.Y,i_2,g*^7cKJ\u0004&o\u001c=z!\tiS'\u0003\u00027Q\t)1\u000b[8si\u0006!1/\u001a7g+\u0005!\u0014!B:fY\u001a\u0004\u0013A\u0002\u001fj]&$h\b\u0006\u0002={A\u0011\u0011\u0007\u0001\u0005\u0006o\r\u0001\r\u0001N\u0001\u0004]VlW#\u0001!\u000f\u0005\u0005keB\u0001\"K\u001d\t\u0019\u0005J\u0004\u0002E\u000f6\tQI\u0003\u0002GU\u00051AH]8pizJ\u0011!K\u0005\u0003\u0013\"\nA!\\1uQ&\u00111\nT\u0001\b\u001dVlWM]5d\u0015\tI\u0005&\u0003\u0002O\u001f\u0006y1\u000b[8si&\u001b\u0018J\u001c;fOJ\fGN\u0003\u0002L\u0019\u0006\u0019qN\u001d3\u0016\u0003Is!a\u0015,\u000f\u0005\t#\u0016BA+M\u0003!y%\u000fZ3sS:<\u0017BA,Y\u0003\u0015\u0019\u0006n\u001c:u\u0015\t)F*A\u0006e_V\u0014G.\u001a,bYV,G#A.\u0011\u00055b\u0016BA/)\u0005\u0019!u.\u001e2mK\u0006Qa\r\\8biZ\u000bG.^3\u0015\u0003\u0001\u0004\"!L1\n\u0005\tD#!\u0002$m_\u0006$\u0018!\u00037p]\u001e4\u0016\r\\;f)\u0005)\u0007CA\u0017g\u0013\t9\u0007F\u0001\u0003M_:<\u0017\u0001C5oiZ\u000bG.^3\u0015\u0003)\u0004\"!L6\n\u00051D#aA%oi\u0006I!-\u001f;f-\u0006dW/\u001a\u000b\u0002_B\u0011Q\u0006]\u0005\u0003c\"\u0012AAQ=uK\u0006Q1\u000f[8siZ\u000bG.^3\u0015\u0003Q\nA\"[:WC2LGm\u00155peR,\u0012A\u001e\t\u0003[]L!\u0001\u001f\u0015\u0003\u000f\t{w\u000e\\3b]\u0006\u0019\u0011MY:\u0002\u00075\f\u0007\u0010\u0006\u00025y\")QP\u0004a\u0001i\u0005!A\u000f[1u\u0003\ri\u0017N\u001c\u000b\u0004i\u0005\u0005\u0001\"B?\u0010\u0001\u0004!\u0014AB:jO:,X.F\u0001k\u0003!A\u0017m\u001d5D_\u0012,\u0017AB3rk\u0006d7\u000fF\u0002w\u0003\u001bA\u0011\"a\u0004\u0013\u0003\u0003\u0005\r!!\u0005\u0002\u0007a$\u0013\u0007E\u0002.\u0003'I1!!\u0006)\u0005\r\te._\u0001\n%&\u001c\u0007n\u00155peR\u0004\"!\r\u000b\u0014\u0007Q\ti\u0002E\u0002.\u0003?I1!!\t)\u0005\u0019\te.\u001f*fMR\u0011\u0011\u0011D\u0001\u000e]VlG%\u001a=uK:\u001c\u0018n\u001c8\u0015\u0007\u0001\u000bI\u0003\u0003\u0004\u0002,Y\u0001\r\u0001P\u0001\u0006IQD\u0017n]\u0001\u000e_J$G%\u001a=uK:\u001c\u0018n\u001c8\u0015\u0007I\u000b\t\u0004\u0003\u0004\u0002,]\u0001\r\u0001P\u0001\u0016I>,(\r\\3WC2,X\rJ3yi\u0016t7/[8o)\rQ\u0016q\u0007\u0005\u0007\u0003WA\u0002\u0019\u0001\u001f\u0002)\u0019dw.\u0019;WC2,X\rJ3yi\u0016t7/[8o)\ry\u0016Q\b\u0005\u0007\u0003WI\u0002\u0019\u0001\u001f\u0002'1|gn\u001a,bYV,G%\u001a=uK:\u001c\u0018n\u001c8\u0015\u0007\u0011\f\u0019\u0005\u0003\u0004\u0002,i\u0001\r\u0001P\u0001\u0013S:$h+\u00197vK\u0012*\u0007\u0010^3og&|g\u000eF\u0002j\u0003\u0013Ba!a\u000b\u001c\u0001\u0004a\u0014a\u00052zi\u00164\u0016\r\\;fI\u0015DH/\u001a8tS>tGc\u00018\u0002P!1\u00111\u0006\u000fA\u0002q\nAc\u001d5peR4\u0016\r\\;fI\u0015DH/\u001a8tS>tGcA:\u0002V!1\u00111F\u000fA\u0002q\na#[:WC2LGm\u00155peR$S\r\u001f;f]NLwN\u001c\u000b\u0004m\u0006m\u0003BBA\u0016=\u0001\u0007A(A\u0007bEN$S\r\u001f;f]NLwN\u001c\u000b\u0004i\u0005\u0005\u0004BBA\u0016?\u0001\u0007A(A\u0007nCb$S\r\u001f;f]NLwN\u001c\u000b\u0005\u0003O\nY\u0007F\u00025\u0003SBQ! \u0011A\u0002QBa!a\u000b!\u0001\u0004a\u0014!D7j]\u0012*\u0007\u0010^3og&|g\u000e\u0006\u0003\u0002r\u0005UDc\u0001\u001b\u0002t!)Q0\ta\u0001i!1\u00111F\u0011A\u0002q\n\u0001c]5h]VlG%\u001a=uK:\u001c\u0018n\u001c8\u0015\u0007)\fY\b\u0003\u0004\u0002,\t\u0002\r\u0001P\u0001\u0013Q\u0006\u001c\bnQ8eK\u0012*\u0007\u0010^3og&|g\u000eF\u0002j\u0003\u0003Ca!a\u000b$\u0001\u0004a\u0014\u0001E3rk\u0006d7\u000fJ3yi\u0016t7/[8o)\u0011\t9)a#\u0015\u0007Y\fI\tC\u0005\u0002\u0010\u0011\n\t\u00111\u0001\u0002\u0012!1\u00111\u0006\u0013A\u0002q\u0002")
public final class RichShort
implements ScalaWholeNumberProxy<Object> {
    private final short self;

    public static boolean equals$extension(short s, Object object) {
        return RichShort$.MODULE$.equals$extension(s, object);
    }

    public static int hashCode$extension(short s) {
        return RichShort$.MODULE$.hashCode$extension(s);
    }

    public static int signum$extension(short s) {
        return RichShort$.MODULE$.signum$extension(s);
    }

    public static short min$extension(short s, short s2) {
        return RichShort$.MODULE$.min$extension(s, s2);
    }

    public static short max$extension(short s, short s2) {
        return RichShort$.MODULE$.max$extension(s, s2);
    }

    public static short abs$extension(short s) {
        return RichShort$.MODULE$.abs$extension(s);
    }

    public static boolean isValidShort$extension(short s) {
        return RichShort$.MODULE$.isValidShort$extension(s);
    }

    public static short shortValue$extension(short s) {
        return RichShort$.MODULE$.shortValue$extension(s);
    }

    public static byte byteValue$extension(short s) {
        return RichShort$.MODULE$.byteValue$extension(s);
    }

    public static int intValue$extension(short s) {
        return RichShort$.MODULE$.intValue$extension(s);
    }

    public static long longValue$extension(short s) {
        return RichShort$.MODULE$.longValue$extension(s);
    }

    public static float floatValue$extension(short s) {
        return RichShort$.MODULE$.floatValue$extension(s);
    }

    public static double doubleValue$extension(short s) {
        return RichShort$.MODULE$.doubleValue$extension(s);
    }

    public static Ordering$Short$ ord$extension(short s) {
        return RichShort$.MODULE$.ord$extension(s);
    }

    public static Numeric$ShortIsIntegral$ num$extension(short s) {
        return RichShort$.MODULE$.num$extension(s);
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
    public boolean isValidByte() {
        return ScalaNumericAnyConversions.isValidByte$(this);
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
    public short self() {
        return this.self;
    }

    public Numeric$ShortIsIntegral$ num() {
        return RichShort$.MODULE$.num$extension(this.self());
    }

    public Ordering$Short$ ord() {
        return RichShort$.MODULE$.ord$extension(this.self());
    }

    @Override
    public double doubleValue() {
        return RichShort$.MODULE$.doubleValue$extension(this.self());
    }

    @Override
    public float floatValue() {
        return RichShort$.MODULE$.floatValue$extension(this.self());
    }

    @Override
    public long longValue() {
        return RichShort$.MODULE$.longValue$extension(this.self());
    }

    @Override
    public int intValue() {
        return RichShort$.MODULE$.intValue$extension(this.self());
    }

    @Override
    public byte byteValue() {
        return RichShort$.MODULE$.byteValue$extension(this.self());
    }

    @Override
    public short shortValue() {
        return RichShort$.MODULE$.shortValue$extension(this.self());
    }

    @Override
    public boolean isValidShort() {
        return RichShort$.MODULE$.isValidShort$extension(this.self());
    }

    @Override
    public short abs() {
        return RichShort$.MODULE$.abs$extension(this.self());
    }

    @Override
    public short max(short that) {
        return RichShort$.MODULE$.max$extension(this.self(), that);
    }

    @Override
    public short min(short that) {
        return RichShort$.MODULE$.min$extension(this.self(), that);
    }

    @Override
    public int signum() {
        return RichShort$.MODULE$.signum$extension(this.self());
    }

    @Override
    public int hashCode() {
        return RichShort$.MODULE$.hashCode$extension(this.self());
    }

    @Override
    public boolean equals(Object x$1) {
        return RichShort$.MODULE$.equals$extension(this.self(), x$1);
    }

    public RichShort(short self) {
        this.self = self;
        ScalaNumericAnyConversions.$init$(this);
        Proxy.$init$(this);
        Ordered.$init$(this);
        OrderedProxy.$init$(this);
        ScalaNumberProxy.$init$(this);
        ScalaWholeNumberProxy.$init$(this);
    }
}

