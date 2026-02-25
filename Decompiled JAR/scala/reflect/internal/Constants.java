/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.Function1;
import scala.MatchError;
import scala.Predef$;
import scala.Product;
import scala.Serializable;
import scala.collection.Iterator;
import scala.collection.TraversableLike;
import scala.collection.immutable.StringOps;
import scala.reflect.ClassTag;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Constants;
import scala.reflect.internal.Constants$Constant$;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Types;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.RichChar$;
import scala.runtime.ScalaRunTime$;
import scala.util.hashing.MurmurHash3$;

@ScalaSignature(bytes="\u0006\u0001\tEe!C A!\u0003\r\ta\u0012BE\u0011\u0015\t\u0006\u0001\"\u0001S\u0011\u001d1\u0006A1A\u0005\u0006]CqA\u0017\u0001C\u0002\u0013\u00151\fC\u0004_\u0001\t\u0007IQA0\t\u000f\t\u0004!\u0019!C\u0003G\"9a\r\u0001b\u0001\n\u000b9\u0007b\u00026\u0001\u0005\u0004%)a\u001b\u0005\b]\u0002\u0011\r\u0011\"\u0002p\u0011\u001d\u0011\bA1A\u0005\u0006MDqA\u001e\u0001C\u0002\u0013\u0015q\u000fC\u0004{\u0001\t\u0007IQA>\t\u000fy\u0004!\u0019!C\u0003\u007f\"I\u0011Q\u0001\u0001C\u0002\u0013\u0015\u0011q\u0001\u0005\n\u0003\u001b\u0001!\u0019!C\u0003\u0003\u001fA\u0011\"!\u0006\u0001\u0005\u0004%)!a\u0006\u0007\r\u0005u\u0001\u0001QA\u0010\u0011)\t)\u0004\u0005BK\u0002\u0013\u0005\u0011q\u0007\u0005\u000b\u0003\u007f\u0001\"\u0011#Q\u0001\n\u0005e\u0002bBA!!\u0011\u0005\u00111\t\u0005\n\u0003\u0013\u0002\"\u0019!C\u0001\u0003\u0017B\u0001\"a\u0015\u0011A\u0003%\u0011Q\n\u0005\b\u0003+\u0002B\u0011AA,\u0011\u001d\ty\u0006\u0005C\u0001\u0003/Bq!!\u0019\u0011\t\u0003\t9\u0006C\u0004\u0002dA!\t!a\u0016\t\u000f\u0005\u0015\u0004\u0003\"\u0001\u0002X!9\u0011q\r\t\u0005\u0002\u0005]\u0003bBA5!\u0011\u0005\u0011q\u000b\u0005\b\u0003W\u0002B\u0011AA,\u0011\u001d\ti\u0007\u0005C\u0001\u0003/Bq!a\u001c\u0011\t\u0003\t\t\bC\u0004\u0002~A!\t%a \t\u000f\u0005\u0015\u0005\u0003\"\u0001\u0002X!9\u0011q\u0011\t\u0005\u0002\u0005]\u0003bBAE!\u0011\u0005\u00111\u0012\u0005\b\u0003'\u0003B\u0011AAK\u0011\u001d\ti\n\u0005C\u0001\u0003?Cq!a*\u0011\t\u0003\tY\u0005C\u0004\u0002*B!\t!a+\t\u000f\u0005M\u0006\u0003\"\u0001\u00026\"9\u0011Q\u0018\t\u0005\u0002\u0005}\u0006bBAd!\u0011\u0005\u0011\u0011\u001a\u0005\b\u0003\u001f\u0004B\u0011AAi\u0011\u001d\tI\u000f\u0005C\u0001\u0003WDq!!=\u0011\t\u0003\t\t\u000eC\u0004\u0002tB!\t!!\u001d\t\u000f\u0005U\b\u0003\"\u0001\u0002x\"9!1\u0001\t\u0005B\t\u0015\u0001\"\u0003B\u0004!\u0005\u0005I\u0011\u0001B\u0005\u0011%\u0011i\u0001EI\u0001\n\u0003\u0011y\u0001C\u0005\u0003&A\t\t\u0011\"\u0011\u0003(!I!q\u0007\t\u0002\u0002\u0013\u0005\u00111\n\u0005\n\u0005s\u0001\u0012\u0011!C\u0001\u0005wA\u0011B!\u0011\u0011\u0003\u0003%\tEa\u0011\t\u0013\tE\u0003#!A\u0005\u0002\tM\u0003\"\u0003B,!\u0005\u0005I\u0011\tB-\u000f\u001d\u0011Y\u0006\u0001E\u0001\u0005;2q!!\b\u0001\u0011\u0003\u0011y\u0006C\u0004\u0002Bi\"\tAa\u001a\t\u0013\t%$(!A\u0005\u0002\n-\u0004\"\u0003B8u\u0005\u0005I\u0011\u0011B9\u0011%\u0011i\b\u0001b\u0001\n\u0007\u0011yHA\u0005D_:\u001cH/\u00198ug*\u0011\u0011IQ\u0001\tS:$XM\u001d8bY*\u00111\tR\u0001\be\u00164G.Z2u\u0015\u0005)\u0015!B:dC2\f7\u0001A\n\u0004\u0001!c\u0005CA%K\u001b\u0005!\u0015BA&E\u0005\u0019\te.\u001f*fMB\u0011Q\nU\u0007\u0002\u001d*\u0011qJQ\u0001\u0004CBL\u0017BA O\u0003\u0019!\u0013N\\5uIQ\t1\u000b\u0005\u0002J)&\u0011Q\u000b\u0012\u0002\u0005+:LG/A\u0003O_R\u000bw-F\u0001Y\u001f\u0005IV$\u0001\u0001\u0002\u000fUs\u0017\u000e\u001e+bOV\tAlD\u0001^;\u0005\t\u0011A\u0003\"p_2,\u0017M\u001c+bOV\t\u0001mD\u0001b;\u0005\u0011\u0011a\u0002\"zi\u0016$\u0016mZ\u000b\u0002I>\tQ-H\u0001\u0004\u0003!\u0019\u0006n\u001c:u)\u0006<W#\u00015\u0010\u0003%l\u0012\u0001B\u0001\b\u0007\"\f'\u000fV1h+\u0005aw\"A7\u001e\u0003\u0015\ta!\u00138u)\u0006<W#\u00019\u0010\u0003El\u0012AB\u0001\b\u0019>tw\rV1h+\u0005!x\"A;\u001e\u0003\u001d\t\u0001B\u00127pCR$\u0016mZ\u000b\u0002q>\t\u00110H\u0001\t\u0003%!u.\u001e2mKR\u000bw-F\u0001}\u001f\u0005iX$A\u0005\u0002\u0013M#(/\u001b8h)\u0006<WCAA\u0001\u001f\t\t\u0019!H\u0001\u000b\u0003\u001dqU\u000f\u001c7UC\u001e,\"!!\u0003\u0010\u0005\u0005-Q$A\u0006\u0002\u0011\rc\u0017M\u001f>UC\u001e,\"!!\u0005\u0010\u0005\u0005MQ$\u0001\u0007\u0002\u000f\u0015sW/\u001c+bOV\u0011\u0011\u0011D\b\u0003\u00037i\u0012!\u0004\u0002\t\u0007>t7\u000f^1oiN9\u0001#!\t\u0002*\u0005=\u0002\u0003BA\u0012\u0003Ki\u0011\u0001A\u0005\u0004\u0003O\u0001&aC\"p]N$\u0018M\u001c;Ba&\u00042!SA\u0016\u0013\r\ti\u0003\u0012\u0002\b!J|G-^2u!\rI\u0015\u0011G\u0005\u0004\u0003g!%\u0001D*fe&\fG.\u001b>bE2,\u0017!\u0002<bYV,WCAA\u001d!\rI\u00151H\u0005\u0004\u0003{!%aA!os\u00061a/\u00197vK\u0002\na\u0001P5oSRtD\u0003BA#\u0003\u000f\u00022!a\t\u0011\u0011\u001d\t)d\u0005a\u0001\u0003s\t1\u0001^1h+\t\ti\u0005E\u0002J\u0003\u001fJ1!!\u0015E\u0005\rIe\u000e^\u0001\u0005i\u0006<\u0007%A\u0006jg\nKH/\u001a*b]\u001e,WCAA-!\rI\u00151L\u0005\u0004\u0003;\"%a\u0002\"p_2,\u0017M\\\u0001\rSN\u001c\u0006n\u001c:u%\u0006tw-Z\u0001\fSN\u001c\u0005.\u0019:SC:<W-\u0001\u0006jg&sGOU1oO\u0016\f1\"[:M_:<'+\u00198hK\u0006a\u0011n\u001d$m_\u0006$(+\u00198hK\u0006I\u0011n\u001d(v[\u0016\u0014\u0018nY\u0001\u0010SNtuN\\+oSR\fe.\u001f,bY\u0006A\u0011n]!osZ\u000bG.A\u0002ua\u0016,\"!a\u001d\u0011\t\u0005\r\u0012QO\u0005\u0005\u0003o\nIH\u0001\u0003UsB,\u0017bAA>\u0001\n)A+\u001f9fg\u00061Q-];bYN$B!!\u0017\u0002\u0002\"9\u00111\u0011\u0011A\u0002\u0005e\u0012!B8uQ\u0016\u0014\u0018!B5t\u001d\u0006t\u0015\u0001\u00042p_2,\u0017M\u001c,bYV,\u0017!\u00032zi\u00164\u0016\r\\;f+\t\ti\tE\u0002J\u0003\u001fK1!!%E\u0005\u0011\u0011\u0015\u0010^3\u0002\u0015MDwN\u001d;WC2,X-\u0006\u0002\u0002\u0018B\u0019\u0011*!'\n\u0007\u0005mEIA\u0003TQ>\u0014H/A\u0005dQ\u0006\u0014h+\u00197vKV\u0011\u0011\u0011\u0015\t\u0004\u0013\u0006\r\u0016bAAS\t\n!1\t[1s\u0003!Ig\u000e\u001e,bYV,\u0017!\u00037p]\u001e4\u0016\r\\;f+\t\ti\u000bE\u0002J\u0003_K1!!-E\u0005\u0011auN\\4\u0002\u0015\u0019dw.\u0019;WC2,X-\u0006\u0002\u00028B\u0019\u0011*!/\n\u0007\u0005mFIA\u0003GY>\fG/A\u0006e_V\u0014G.\u001a,bYV,WCAAa!\rI\u00151Y\u0005\u0004\u0003\u000b$%A\u0002#pk\ndW-A\u0005d_:4XM\u001d;U_R!\u0011QIAf\u0011\u001d\tiM\u000ba\u0001\u0003g\n!\u0001\u001d;\u0002\u0017M$(/\u001b8h-\u0006dW/Z\u000b\u0003\u0003'\u0004B!!6\u0002d:!\u0011q[Ap!\r\tI\u000eR\u0007\u0003\u00037T1!!8G\u0003\u0019a$o\\8u}%\u0019\u0011\u0011\u001d#\u0002\rA\u0013X\rZ3g\u0013\u0011\t)/a:\u0003\rM#(/\u001b8h\u0015\r\t\t\u000fR\u0001\fKN\u001c\u0017\r]3e\u0007\"\f'\u000f\u0006\u0003\u0002T\u00065\bbBAxY\u0001\u0007\u0011\u0011U\u0001\u0003G\"\f!#Z:dCB,Gm\u0015;sS:<g+\u00197vK\u0006IA/\u001f9f-\u0006dW/Z\u0001\fgfl'm\u001c7WC2,X-\u0006\u0002\u0002zB!\u00111EA~\u0013\u0011\ti0a@\u0003\rMKXNY8m\u0013\r\u0011\t\u0001\u0011\u0002\b'fl'm\u001c7t\u0003!A\u0017m\u001d5D_\u0012,GCAA'\u0003\u0011\u0019w\u000e]=\u0015\t\u0005\u0015#1\u0002\u0005\n\u0003k\t\u0004\u0013!a\u0001\u0003s\tabY8qs\u0012\"WMZ1vYR$\u0013'\u0006\u0002\u0003\u0012)\"\u0011\u0011\bB\nW\t\u0011)\u0002\u0005\u0003\u0003\u0018\t\u0005RB\u0001B\r\u0015\u0011\u0011YB!\b\u0002\u0013Ut7\r[3dW\u0016$'b\u0001B\u0010\t\u0006Q\u0011M\u001c8pi\u0006$\u0018n\u001c8\n\t\t\r\"\u0011\u0004\u0002\u0012k:\u001c\u0007.Z2lK\u00124\u0016M]5b]\u000e,\u0017!\u00049s_\u0012,8\r\u001e)sK\u001aL\u00070\u0006\u0002\u0003*A!!1\u0006B\u001b\u001b\t\u0011iC\u0003\u0003\u00030\tE\u0012\u0001\u00027b]\u001eT!Aa\r\u0002\t)\fg/Y\u0005\u0005\u0003K\u0014i#\u0001\u0007qe>$Wo\u0019;Be&$\u00180\u0001\bqe>$Wo\u0019;FY\u0016lWM\u001c;\u0015\t\u0005e\"Q\b\u0005\n\u0005\u007f)\u0014\u0011!a\u0001\u0003\u001b\n1\u0001\u001f\u00132\u0003=\u0001(o\u001c3vGRLE/\u001a:bi>\u0014XC\u0001B#!\u0019\u00119E!\u0014\u0002:5\u0011!\u0011\n\u0006\u0004\u0005\u0017\"\u0015AC2pY2,7\r^5p]&!!q\nB%\u0005!IE/\u001a:bi>\u0014\u0018\u0001C2b]\u0016\u000bX/\u00197\u0015\t\u0005e#Q\u000b\u0005\n\u0005\u007f9\u0014\u0011!a\u0001\u0003s\t\u0001\u0002^8TiJLgn\u001a\u000b\u0003\u0005S\t\u0001bQ8ogR\fg\u000e\u001e\t\u0004\u0003GQ4#\u0002\u001e\u0003b\u0005=\u0002\u0003BA\u0012\u0005GJ1A!\u001aQ\u0005E\u0019uN\\:uC:$X\t\u001f;sC\u000e$xN\u001d\u000b\u0003\u0005;\nQ!\u00199qYf$B!!\u0012\u0003n!9\u0011Q\u0007\u001fA\u0002\u0005e\u0012aB;oCB\u0004H.\u001f\u000b\u0005\u0005g\u0012I\bE\u0003J\u0005k\nI$C\u0002\u0003x\u0011\u0013aa\u00149uS>t\u0007\"\u0003B>{\u0005\u0005\t\u0019AA#\u0003\rAH\u0005M\u0001\f\u0007>t7\u000f^1oiR\u000bw-\u0006\u0002\u0003\u0002B1!1\u0011BC\u0003\u000bj\u0011AQ\u0005\u0004\u0005\u000f\u0013%\u0001C\"mCN\u001cH+Y4\u0011\t\t-%QR\u0007\u0002\u0001&\u0019!q\u0012!\u0003\u0017MKXNY8m)\u0006\u0014G.\u001a")
public interface Constants
extends scala.reflect.api.Constants {
    @Override
    public Constants$Constant$ Constant();

    public void scala$reflect$internal$Constants$_setter_$ConstantTag_$eq(ClassTag<Constant> var1);

    public static /* synthetic */ int NoTag$(Constants $this) {
        return $this.NoTag();
    }

    default public int NoTag() {
        return 0;
    }

    public static /* synthetic */ int UnitTag$(Constants $this) {
        return $this.UnitTag();
    }

    default public int UnitTag() {
        return 1;
    }

    public static /* synthetic */ int BooleanTag$(Constants $this) {
        return $this.BooleanTag();
    }

    default public int BooleanTag() {
        return 2;
    }

    public static /* synthetic */ int ByteTag$(Constants $this) {
        return $this.ByteTag();
    }

    default public int ByteTag() {
        return 3;
    }

    public static /* synthetic */ int ShortTag$(Constants $this) {
        return $this.ShortTag();
    }

    default public int ShortTag() {
        return 4;
    }

    public static /* synthetic */ int CharTag$(Constants $this) {
        return $this.CharTag();
    }

    default public int CharTag() {
        return 5;
    }

    public static /* synthetic */ int IntTag$(Constants $this) {
        return $this.IntTag();
    }

    default public int IntTag() {
        return 6;
    }

    public static /* synthetic */ int LongTag$(Constants $this) {
        return $this.LongTag();
    }

    default public int LongTag() {
        return 7;
    }

    public static /* synthetic */ int FloatTag$(Constants $this) {
        return $this.FloatTag();
    }

    default public int FloatTag() {
        return 8;
    }

    public static /* synthetic */ int DoubleTag$(Constants $this) {
        return $this.DoubleTag();
    }

    default public int DoubleTag() {
        return 9;
    }

    public static /* synthetic */ int StringTag$(Constants $this) {
        return $this.StringTag();
    }

    default public int StringTag() {
        return 10;
    }

    public static /* synthetic */ int NullTag$(Constants $this) {
        return $this.NullTag();
    }

    default public int NullTag() {
        return 11;
    }

    public static /* synthetic */ int ClazzTag$(Constants $this) {
        return $this.ClazzTag();
    }

    default public int ClazzTag() {
        return 12;
    }

    public static /* synthetic */ int EnumTag$(Constants $this) {
        return $this.EnumTag();
    }

    default public int EnumTag() {
        return 13;
    }

    public ClassTag<Constant> ConstantTag();

    public static void $init$(Constants $this) {
        $this.scala$reflect$internal$Constants$_setter_$ConstantTag_$eq(ClassTag$.MODULE$.apply(Constant.class));
    }

    public class Constant
    extends Constants.ConstantApi
    implements Product,
    Serializable {
        private final Object value;
        private final int tag;

        @Override
        public Object value() {
            return this.value;
        }

        public int tag() {
            return this.tag;
        }

        public boolean isByteRange() {
            return this.isIntRange() && -128 <= this.intValue() && this.intValue() <= 127;
        }

        public boolean isShortRange() {
            return this.isIntRange() && Short.MIN_VALUE <= this.intValue() && this.intValue() <= Short.MAX_VALUE;
        }

        public boolean isCharRange() {
            return this.isIntRange() && 0 <= this.intValue() && this.intValue() <= 65535;
        }

        public boolean isIntRange() {
            return 3 <= this.tag() && this.tag() <= 6;
        }

        public boolean isLongRange() {
            return 3 <= this.tag() && this.tag() <= 7;
        }

        public boolean isFloatRange() {
            return 3 <= this.tag() && this.tag() <= 8;
        }

        public boolean isNumeric() {
            return 3 <= this.tag() && this.tag() <= 9;
        }

        public boolean isNonUnitAnyVal() {
            return 2 <= this.tag() && this.tag() <= 9;
        }

        public boolean isAnyVal() {
            return 1 <= this.tag() && this.tag() <= 9;
        }

        @Override
        public Types.Type tpe() {
            int n = this.tag();
            switch (n) {
                case 1: {
                    return this.scala$reflect$internal$Constants$Constant$$$outer().definitions().UnitTpe();
                }
                case 2: {
                    return this.scala$reflect$internal$Constants$Constant$$$outer().definitions().BooleanTpe();
                }
                case 3: {
                    return this.scala$reflect$internal$Constants$Constant$$$outer().definitions().ByteTpe();
                }
                case 4: {
                    return this.scala$reflect$internal$Constants$Constant$$$outer().definitions().ShortTpe();
                }
                case 5: {
                    return this.scala$reflect$internal$Constants$Constant$$$outer().definitions().CharTpe();
                }
                case 6: {
                    return this.scala$reflect$internal$Constants$Constant$$$outer().definitions().IntTpe();
                }
                case 7: {
                    return this.scala$reflect$internal$Constants$Constant$$$outer().definitions().LongTpe();
                }
                case 8: {
                    return this.scala$reflect$internal$Constants$Constant$$$outer().definitions().FloatTpe();
                }
                case 9: {
                    return this.scala$reflect$internal$Constants$Constant$$$outer().definitions().DoubleTpe();
                }
                case 10: {
                    return this.scala$reflect$internal$Constants$Constant$$$outer().definitions().StringTpe();
                }
                case 11: {
                    return this.scala$reflect$internal$Constants$Constant$$$outer().definitions().NullTpe();
                }
                case 12: {
                    return this.scala$reflect$internal$Constants$Constant$$$outer().definitions().ClassType(this.typeValue());
                }
                case 13: {
                    return this.scala$reflect$internal$Constants$Constant$$$outer().definitions().EnumType(this.symbolValue());
                }
            }
            throw new MatchError(BoxesRunTime.boxToInteger(n));
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public boolean equals(Object other) {
            boolean bl;
            if (!(other instanceof Constant)) return false;
            if (((Constant)other).scala$reflect$internal$Constants$Constant$$$outer() != this.scala$reflect$internal$Constants$Constant$$$outer()) return false;
            Constant constant = (Constant)other;
            if (this.tag() != constant.tag()) return false;
            switch (this.tag()) {
                case 11: {
                    return true;
                }
                case 8: {
                    if (Float.floatToRawIntBits(BoxesRunTime.unboxToFloat(this.value())) != Float.floatToRawIntBits(BoxesRunTime.unboxToFloat(constant.value()))) return false;
                    return true;
                }
                case 9: {
                    if (Double.doubleToRawLongBits(BoxesRunTime.unboxToDouble(this.value())) != Double.doubleToRawLongBits(BoxesRunTime.unboxToDouble(constant.value()))) return false;
                    return true;
                }
                default: {
                    bl = this.value().equals(constant.value());
                }
            }
            if (!bl) return false;
            return true;
        }

        public boolean isNaN() {
            Object object = this.value();
            boolean bl = object instanceof Float ? Float.isNaN(BoxesRunTime.unboxToFloat(object)) : (object instanceof Double ? Double.isNaN(BoxesRunTime.unboxToDouble(object)) : false);
            return bl;
        }

        public boolean booleanValue() {
            if (this.tag() == 2) {
                return BoxesRunTime.unboxToBoolean(this.value());
            }
            throw new Error(new StringBuilder(23).append("value ").append(this.value()).append(" is not a boolean").toString());
        }

        public byte byteValue() {
            switch (this.tag()) {
                case 3: {
                    return BoxesRunTime.unboxToByte(this.value());
                }
                case 4: {
                    return (byte)BoxesRunTime.unboxToShort(this.value());
                }
                case 5: {
                    return (byte)BoxesRunTime.unboxToChar(this.value());
                }
                case 6: {
                    return (byte)BoxesRunTime.unboxToInt(this.value());
                }
                case 7: {
                    return (byte)BoxesRunTime.unboxToLong(this.value());
                }
                case 8: {
                    return (byte)BoxesRunTime.unboxToFloat(this.value());
                }
                case 9: {
                    return (byte)BoxesRunTime.unboxToDouble(this.value());
                }
            }
            throw new Error(new StringBuilder(20).append("value ").append(this.value()).append(" is not a Byte").toString());
        }

        public short shortValue() {
            switch (this.tag()) {
                case 3: {
                    return BoxesRunTime.unboxToByte(this.value());
                }
                case 4: {
                    return BoxesRunTime.unboxToShort(this.value());
                }
                case 5: {
                    return (short)BoxesRunTime.unboxToChar(this.value());
                }
                case 6: {
                    return (short)BoxesRunTime.unboxToInt(this.value());
                }
                case 7: {
                    return (short)BoxesRunTime.unboxToLong(this.value());
                }
                case 8: {
                    return (short)BoxesRunTime.unboxToFloat(this.value());
                }
                case 9: {
                    return (short)BoxesRunTime.unboxToDouble(this.value());
                }
            }
            throw new Error(new StringBuilder(21).append("value ").append(this.value()).append(" is not a Short").toString());
        }

        public char charValue() {
            switch (this.tag()) {
                case 3: {
                    return (char)BoxesRunTime.unboxToByte(this.value());
                }
                case 4: {
                    return (char)BoxesRunTime.unboxToShort(this.value());
                }
                case 5: {
                    return BoxesRunTime.unboxToChar(this.value());
                }
                case 6: {
                    return (char)BoxesRunTime.unboxToInt(this.value());
                }
                case 7: {
                    return (char)BoxesRunTime.unboxToLong(this.value());
                }
                case 8: {
                    return (char)BoxesRunTime.unboxToFloat(this.value());
                }
                case 9: {
                    return (char)BoxesRunTime.unboxToDouble(this.value());
                }
            }
            throw new Error(new StringBuilder(20).append("value ").append(this.value()).append(" is not a Char").toString());
        }

        public int intValue() {
            switch (this.tag()) {
                case 3: {
                    return BoxesRunTime.unboxToByte(this.value());
                }
                case 4: {
                    return BoxesRunTime.unboxToShort(this.value());
                }
                case 5: {
                    return BoxesRunTime.unboxToChar(this.value());
                }
                case 6: {
                    return BoxesRunTime.unboxToInt(this.value());
                }
                case 7: {
                    return (int)BoxesRunTime.unboxToLong(this.value());
                }
                case 8: {
                    return (int)BoxesRunTime.unboxToFloat(this.value());
                }
                case 9: {
                    return (int)BoxesRunTime.unboxToDouble(this.value());
                }
            }
            throw new Error(new StringBuilder(20).append("value ").append(this.value()).append(" is not an Int").toString());
        }

        public long longValue() {
            switch (this.tag()) {
                case 3: {
                    return BoxesRunTime.unboxToByte(this.value());
                }
                case 4: {
                    return BoxesRunTime.unboxToShort(this.value());
                }
                case 5: {
                    return BoxesRunTime.unboxToChar(this.value());
                }
                case 6: {
                    return BoxesRunTime.unboxToInt(this.value());
                }
                case 7: {
                    return BoxesRunTime.unboxToLong(this.value());
                }
                case 8: {
                    return (long)BoxesRunTime.unboxToFloat(this.value());
                }
                case 9: {
                    return (long)BoxesRunTime.unboxToDouble(this.value());
                }
            }
            throw new Error(new StringBuilder(20).append("value ").append(this.value()).append(" is not a Long").toString());
        }

        public float floatValue() {
            switch (this.tag()) {
                case 3: {
                    return BoxesRunTime.unboxToByte(this.value());
                }
                case 4: {
                    return BoxesRunTime.unboxToShort(this.value());
                }
                case 5: {
                    return BoxesRunTime.unboxToChar(this.value());
                }
                case 6: {
                    return BoxesRunTime.unboxToInt(this.value());
                }
                case 7: {
                    return BoxesRunTime.unboxToLong(this.value());
                }
                case 8: {
                    return BoxesRunTime.unboxToFloat(this.value());
                }
                case 9: {
                    return (float)BoxesRunTime.unboxToDouble(this.value());
                }
            }
            throw new Error(new StringBuilder(21).append("value ").append(this.value()).append(" is not a Float").toString());
        }

        public double doubleValue() {
            switch (this.tag()) {
                case 3: {
                    return BoxesRunTime.unboxToByte(this.value());
                }
                case 4: {
                    return BoxesRunTime.unboxToShort(this.value());
                }
                case 5: {
                    return BoxesRunTime.unboxToChar(this.value());
                }
                case 6: {
                    return BoxesRunTime.unboxToInt(this.value());
                }
                case 7: {
                    return BoxesRunTime.unboxToLong(this.value());
                }
                case 8: {
                    return BoxesRunTime.unboxToFloat(this.value());
                }
                case 9: {
                    return BoxesRunTime.unboxToDouble(this.value());
                }
            }
            throw new Error(new StringBuilder(22).append("value ").append(this.value()).append(" is not a Double").toString());
        }

        public Constant convertTo(Types.Type pt) {
            Symbols.Symbol target;
            Symbols.Symbol symbol = target = pt.typeSymbol();
            Symbols.Symbol symbol2 = this.tpe().typeSymbol();
            if (!(symbol != null ? !symbol.equals(symbol2) : symbol2 != null)) {
                return this;
            }
            Symbols.Symbol symbol3 = target;
            Symbols.ClassSymbol classSymbol = this.scala$reflect$internal$Constants$Constant$$$outer().definitions().ByteClass();
            if (!(symbol3 != null ? !symbol3.equals(classSymbol) : classSymbol != null) && this.isByteRange()) {
                return new Constant(this.scala$reflect$internal$Constants$Constant$$$outer(), BoxesRunTime.boxToByte(this.byteValue()));
            }
            Symbols.Symbol symbol4 = target;
            Symbols.ClassSymbol classSymbol2 = this.scala$reflect$internal$Constants$Constant$$$outer().definitions().ShortClass();
            if (!(symbol4 != null ? !symbol4.equals(classSymbol2) : classSymbol2 != null) && this.isShortRange()) {
                return new Constant(this.scala$reflect$internal$Constants$Constant$$$outer(), BoxesRunTime.boxToShort(this.shortValue()));
            }
            Symbols.Symbol symbol5 = target;
            Symbols.ClassSymbol classSymbol3 = this.scala$reflect$internal$Constants$Constant$$$outer().definitions().CharClass();
            if (!(symbol5 != null ? !symbol5.equals(classSymbol3) : classSymbol3 != null) && this.isCharRange()) {
                return new Constant(this.scala$reflect$internal$Constants$Constant$$$outer(), BoxesRunTime.boxToCharacter(this.charValue()));
            }
            Symbols.Symbol symbol6 = target;
            Symbols.ClassSymbol classSymbol4 = this.scala$reflect$internal$Constants$Constant$$$outer().definitions().IntClass();
            if (!(symbol6 != null ? !symbol6.equals(classSymbol4) : classSymbol4 != null) && this.isIntRange()) {
                return new Constant(this.scala$reflect$internal$Constants$Constant$$$outer(), BoxesRunTime.boxToInteger(this.intValue()));
            }
            Symbols.Symbol symbol7 = target;
            Symbols.ClassSymbol classSymbol5 = this.scala$reflect$internal$Constants$Constant$$$outer().definitions().LongClass();
            if (!(symbol7 != null ? !symbol7.equals(classSymbol5) : classSymbol5 != null) && this.isLongRange()) {
                return new Constant(this.scala$reflect$internal$Constants$Constant$$$outer(), BoxesRunTime.boxToLong(this.longValue()));
            }
            Symbols.Symbol symbol8 = target;
            Symbols.ClassSymbol classSymbol6 = this.scala$reflect$internal$Constants$Constant$$$outer().definitions().FloatClass();
            if (!(symbol8 != null ? !symbol8.equals(classSymbol6) : classSymbol6 != null) && this.isFloatRange()) {
                return new Constant(this.scala$reflect$internal$Constants$Constant$$$outer(), BoxesRunTime.boxToFloat(this.floatValue()));
            }
            Symbols.Symbol symbol9 = target;
            Symbols.ClassSymbol classSymbol7 = this.scala$reflect$internal$Constants$Constant$$$outer().definitions().DoubleClass();
            if (!(symbol9 != null ? !symbol9.equals(classSymbol7) : classSymbol7 != null) && this.isNumeric()) {
                return new Constant(this.scala$reflect$internal$Constants$Constant$$$outer(), BoxesRunTime.boxToDouble(this.doubleValue()));
            }
            return null;
        }

        public String stringValue() {
            if (this.value() == null) {
                return "null";
            }
            if (this.tag() == 12) {
                return this.scala$reflect$internal$Constants$Constant$$$outer().definitions().signature(this.typeValue());
            }
            return this.value().toString();
        }

        public String escapedChar(char ch) {
            switch (ch) {
                case '\b': {
                    return "\\b";
                }
                case '\t': {
                    return "\\t";
                }
                case '\n': {
                    return "\\n";
                }
                case '\f': {
                    return "\\f";
                }
                case '\r': {
                    return "\\r";
                }
                case '\"': {
                    return "\\\"";
                }
                case '\'': {
                    return "\\'";
                }
                case '\\': {
                    return "\\\\";
                }
            }
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            if (RichChar$.MODULE$.isControl$extension(ch)) {
                String string = "\\u%04X";
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                return new StringOps(string).format(Predef$.MODULE$.genericWrapArray(new Object[]{BoxesRunTime.boxToInteger(ch)}));
            }
            return String.valueOf(ch);
        }

        public String escapedStringValue() {
            switch (this.tag()) {
                case 11: {
                    return "null";
                }
                case 10: {
                    return new StringBuilder(2).append("\"").append(this.escape$1(this.stringValue())).append("\"").toString();
                }
                case 12: {
                    String string;
                    Types.Type type = this.typeValue();
                    if (type instanceof Types.ErasedValueType) {
                        Symbols.Symbol clazz = ((Types.ErasedValueType)type).valueClazz();
                        string = this.show$1(clazz.tpe_$times());
                    } else {
                        string = this.show$1(this.typeValue());
                    }
                    return string;
                }
                case 5: {
                    return new StringBuilder(2).append("'").append(this.escapedChar(this.charValue())).append("'").toString();
                }
                case 7: {
                    return new StringBuilder(1).append(Long.toString(this.longValue())).append("L").toString();
                }
                case 13: {
                    return this.symbolValue().name().toString();
                }
            }
            return String.valueOf(this.value());
        }

        public Types.Type typeValue() {
            return (Types.Type)this.value();
        }

        public Symbols.Symbol symbolValue() {
            return (Symbols.Symbol)this.value();
        }

        public int hashCode() {
            int n;
            int seed = 17;
            int h = MurmurHash3$.MODULE$.mix(seed, this.tag());
            switch (this.tag()) {
                case 11: {
                    n = 0;
                    break;
                }
                case 8: {
                    n = Integer.hashCode(Float.floatToRawIntBits(BoxesRunTime.unboxToFloat(this.value())));
                    break;
                }
                case 9: {
                    n = Long.hashCode(Double.doubleToRawLongBits(BoxesRunTime.unboxToDouble(this.value())));
                    break;
                }
                default: {
                    n = this.value().hashCode();
                }
            }
            int valueHash = n;
            h = MurmurHash3$.MODULE$.mix(h, valueHash);
            return MurmurHash3$.MODULE$.finalizeHash(h, 2);
        }

        public Constant copy(Object value) {
            return new Constant(this.scala$reflect$internal$Constants$Constant$$$outer(), value);
        }

        public Object copy$default$1() {
            return this.value();
        }

        @Override
        public String productPrefix() {
            return "Constant";
        }

        @Override
        public int productArity() {
            return 1;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.value();
                }
            }
            throw new IndexOutOfBoundsException(Integer.toString(x$1));
        }

        @Override
        public Iterator<Object> productIterator() {
            return ScalaRunTime$.MODULE$.typedProductIterator(this);
        }

        @Override
        public boolean canEqual(Object x$1) {
            return x$1 instanceof Constant;
        }

        public String toString() {
            return ScalaRunTime$.MODULE$._toString(this);
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Constants$Constant$$$outer() {
            return (SymbolTable)this.$outer;
        }

        public static final /* synthetic */ String $anonfun$escapedStringValue$1(Constant $this, char ch) {
            String string = $this.escapedChar(ch);
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return string;
        }

        private final String escape$1(String text) {
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return (String)TraversableLike.flatMap$(new StringOps(text), (Function1<Object, Object> & java.io.Serializable & Serializable)ch -> new StringOps(Constant.$anonfun$escapedStringValue$1(this, BoxesRunTime.unboxToChar(ch))), Predef$.MODULE$.StringCanBuildFrom());
        }

        private final String show$1(Types.Type tpe) {
            return new StringBuilder(9).append("classOf[").append(this.scala$reflect$internal$Constants$Constant$$$outer().definitions().signature(tpe)).append("]").toString();
        }

        public Constant(SymbolTable $outer, Object value) {
            int n;
            this.value = value;
            super($outer);
            Product.$init$(this);
            if (value == null) {
                n = 11;
            } else if (value instanceof BoxedUnit) {
                n = 1;
            } else if (value instanceof Boolean) {
                n = 2;
            } else if (value instanceof Byte) {
                n = 3;
            } else if (value instanceof Short) {
                n = 4;
            } else if (value instanceof Integer) {
                n = 6;
            } else if (value instanceof Long) {
                n = 7;
            } else if (value instanceof Float) {
                n = 8;
            } else if (value instanceof Double) {
                n = 9;
            } else if (value instanceof String) {
                n = 10;
            } else if (value instanceof Character) {
                n = 5;
            } else if (value instanceof Types.Type && ((Types.Type)value).scala$reflect$internal$Types$Type$$$outer() == $outer) {
                n = 12;
            } else if (value instanceof Symbols.Symbol && ((Symbols.Symbol)value).scala$reflect$internal$Symbols$Symbol$$$outer() == $outer) {
                n = 13;
            } else {
                throw new Error(new StringBuilder(30).append("bad constant value: ").append(value).append(" of class ").append(value.getClass()).toString());
            }
            this.tag = n;
        }
    }
}

