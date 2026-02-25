/*
 * Decompiled with CFR 0.152.
 */
package scala.math;

import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.Statics;

@ScalaSignature(bytes="\u0006\u0001\u001d4qa\u0006\r\u0011\u0002\u0007\u0005Q\u0004C\u0003#\u0001\u0011\u00051\u0005C\u0003(\u0001\u0019\u0005\u0001\u0006C\u0003-\u0001\u0019\u0005Q\u0006C\u0003/\u0001\u0019\u0005q\u0006C\u00034\u0001\u0019\u0005A\u0007C\u00039\u0001\u0019\u0005\u0011\bC\u0003>\u0001\u0019\u0005a\bC\u0003C\u0001\u0019\u00051\tC\u0003H\u0001\u0019\u0005\u0001\nC\u0003M\u0001\u0011\u0005Q\nC\u0003R\u0001\u0011\u0005!\u000bC\u0003T\u0001\u0011\u0005A\u000bC\u0003V\u0001\u0011\u0005a\u000bC\u0003X\u0001\u0011\u0005\u0001\fC\u0003Z\u0001\u0011\u0005!\fC\u0003\\\u0001\u0011\u0005A\fC\u0003^\u0001\u0011\u0005a\fC\u0003`\u0001\u0011\u0005a\fC\u0003a\u0001\u0011\u0005a\fC\u0003b\u0001\u0011\u0005a\fC\u0003c\u0001\u0011E\u0011\bC\u0003d\u0001\u0011EAM\u0001\u000eTG\u0006d\u0017MT;nKJL7-\u00118z\u0007>tg/\u001a:tS>t7O\u0003\u0002\u001a5\u0005!Q.\u0019;i\u0015\u0005Y\u0012!B:dC2\f7\u0001A\n\u0003\u0001y\u0001\"a\b\u0011\u000e\u0003iI!!\t\u000e\u0003\u0007\u0005s\u00170\u0001\u0004%S:LG\u000f\n\u000b\u0002IA\u0011q$J\u0005\u0003Mi\u0011A!\u00168ji\u00069\u0011n],i_2,G#A\u0015\u0011\u0005}Q\u0013BA\u0016\u001b\u0005\u001d\u0011un\u001c7fC:\f!\"\u001e8eKJd\u00170\u001b8h)\u0005q\u0012!\u00032zi\u00164\u0016\r\\;f)\u0005\u0001\u0004CA\u00102\u0013\t\u0011$D\u0001\u0003CsR,\u0017AC:i_J$h+\u00197vKR\tQ\u0007\u0005\u0002 m%\u0011qG\u0007\u0002\u0006'\"|'\u000f^\u0001\tS:$h+\u00197vKR\t!\b\u0005\u0002 w%\u0011AH\u0007\u0002\u0004\u0013:$\u0018!\u00037p]\u001e4\u0016\r\\;f)\u0005y\u0004CA\u0010A\u0013\t\t%D\u0001\u0003M_:<\u0017A\u00034m_\u0006$h+\u00197vKR\tA\t\u0005\u0002 \u000b&\u0011aI\u0007\u0002\u0006\r2|\u0017\r^\u0001\fI>,(\r\\3WC2,X\rF\u0001J!\ty\"*\u0003\u0002L5\t1Ai\\;cY\u0016\fa\u0001^8DQ\u0006\u0014X#\u0001(\u0011\u0005}y\u0015B\u0001)\u001b\u0005\u0011\u0019\u0005.\u0019:\u0002\rQ|')\u001f;f+\u0005\u0001\u0014a\u0002;p'\"|'\u000f^\u000b\u0002k\u0005)Ao\\%oiV\t!(\u0001\u0004u_2{gnZ\u000b\u0002\u007f\u00059Ao\u001c$m_\u0006$X#\u0001#\u0002\u0011Q|Gi\\;cY\u0016,\u0012!S\u0001\fSN4\u0016\r\\5e\u0005f$X-F\u0001*\u00031I7OV1mS\u0012\u001c\u0006n\u001c:u\u0003)I7OV1mS\u0012Le\u000e^\u0001\fSN4\u0016\r\\5e\u0007\"\f'/\u0001\rv]&4\u0017.\u001a3Qe&l\u0017\u000e^5wK\"\u000b7\u000f[2pI\u0016\fa#\u001e8jM&,G\r\u0015:j[&$\u0018N^3FcV\fGn\u001d\u000b\u0003S\u0015DQA\u001a\fA\u0002y\t\u0011\u0001\u001f")
public interface ScalaNumericAnyConversions {
    public boolean isWhole();

    public Object underlying();

    public byte byteValue();

    public short shortValue();

    public int intValue();

    public long longValue();

    public float floatValue();

    public double doubleValue();

    public static /* synthetic */ char toChar$(ScalaNumericAnyConversions $this) {
        return $this.toChar();
    }

    default public char toChar() {
        return (char)this.intValue();
    }

    public static /* synthetic */ byte toByte$(ScalaNumericAnyConversions $this) {
        return $this.toByte();
    }

    default public byte toByte() {
        return this.byteValue();
    }

    public static /* synthetic */ short toShort$(ScalaNumericAnyConversions $this) {
        return $this.toShort();
    }

    default public short toShort() {
        return this.shortValue();
    }

    public static /* synthetic */ int toInt$(ScalaNumericAnyConversions $this) {
        return $this.toInt();
    }

    default public int toInt() {
        return this.intValue();
    }

    public static /* synthetic */ long toLong$(ScalaNumericAnyConversions $this) {
        return $this.toLong();
    }

    default public long toLong() {
        return this.longValue();
    }

    public static /* synthetic */ float toFloat$(ScalaNumericAnyConversions $this) {
        return $this.toFloat();
    }

    default public float toFloat() {
        return this.floatValue();
    }

    public static /* synthetic */ double toDouble$(ScalaNumericAnyConversions $this) {
        return $this.toDouble();
    }

    default public double toDouble() {
        return this.doubleValue();
    }

    public static /* synthetic */ boolean isValidByte$(ScalaNumericAnyConversions $this) {
        return $this.isValidByte();
    }

    default public boolean isValidByte() {
        return this.isWhole() && this.toInt() == this.toByte();
    }

    public static /* synthetic */ boolean isValidShort$(ScalaNumericAnyConversions $this) {
        return $this.isValidShort();
    }

    default public boolean isValidShort() {
        return this.isWhole() && this.toInt() == this.toShort();
    }

    public static /* synthetic */ boolean isValidInt$(ScalaNumericAnyConversions $this) {
        return $this.isValidInt();
    }

    default public boolean isValidInt() {
        return this.isWhole() && this.toLong() == (long)this.toInt();
    }

    public static /* synthetic */ boolean isValidChar$(ScalaNumericAnyConversions $this) {
        return $this.isValidChar();
    }

    default public boolean isValidChar() {
        return this.isWhole() && this.toInt() >= 0 && this.toInt() <= 65535;
    }

    public static /* synthetic */ int unifiedPrimitiveHashcode$(ScalaNumericAnyConversions $this) {
        return $this.unifiedPrimitiveHashcode();
    }

    default public int unifiedPrimitiveHashcode() {
        long lv = this.toLong();
        if (lv >= Integer.MIN_VALUE && lv <= Integer.MAX_VALUE) {
            return (int)lv;
        }
        return Statics.longHash(lv);
    }

    public static /* synthetic */ boolean unifiedPrimitiveEquals$(ScalaNumericAnyConversions $this, Object x) {
        return $this.unifiedPrimitiveEquals(x);
    }

    default public boolean unifiedPrimitiveEquals(Object x) {
        boolean bl;
        if (x instanceof Character) {
            char c = BoxesRunTime.unboxToChar(x);
            bl = this.isValidChar() && this.toInt() == c;
        } else if (x instanceof Byte) {
            byte by = BoxesRunTime.unboxToByte(x);
            bl = this.isValidByte() && this.toByte() == by;
        } else if (x instanceof Short) {
            short s = BoxesRunTime.unboxToShort(x);
            bl = this.isValidShort() && this.toShort() == s;
        } else if (x instanceof Integer) {
            int n = BoxesRunTime.unboxToInt(x);
            bl = this.isValidInt() && this.toInt() == n;
        } else if (x instanceof Long) {
            long l = BoxesRunTime.unboxToLong(x);
            bl = this.toLong() == l;
        } else if (x instanceof Float) {
            float f = BoxesRunTime.unboxToFloat(x);
            bl = this.toFloat() == f;
        } else if (x instanceof Double) {
            double d = BoxesRunTime.unboxToDouble(x);
            bl = this.toDouble() == d;
        } else {
            bl = false;
        }
        return bl;
    }

    public static void $init$(ScalaNumericAnyConversions $this) {
    }
}

