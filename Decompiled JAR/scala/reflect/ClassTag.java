/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect;

import java.lang.reflect.Array;
import scala.Equals;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Some;
import scala.collection.immutable.List;
import scala.collection.mutable.ArrayBuilder;
import scala.collection.mutable.WrappedArray;
import scala.reflect.ClassManifestDeprecatedApis;
import scala.reflect.ClassTag$;
import scala.reflect.OptManifest;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.Nothing$;
import scala.runtime.Null$;
import scala.runtime.Statics;

@ScalaSignature(bytes="\u0006\u0001\teha\u0002\u001e<!\u0003\r\t\u0001\u0011\u0005\u00067\u0002!\t\u0001\u0018\u0005\u0006A\u00021\t!\u0019\u0005\u0006]\u0002!\ta\u001c\u0005\u0006i\u0002!\t%\u001e\u0005\u0006w\u0002!\t\u0001 \u0005\b\u0003\u000b\u0001A\u0011IA\u0004\u0011\u001d\t\t\u0002\u0001C!\u0003'Aq!a\u0006\u0001\t\u0003\nI\u0002C\u0004\u0002\u001c\u0001!\t%!\b\b\u000f\u0005\u001d3\b#\u0001\u0002J\u00191!h\u000fE\u0001\u0003\u0017Bq!!\u0014\f\t\u0003\ty\u0005C\u0005\u0002R-\u0011\r\u0011\"\u0003\u0002T!A\u0011QL\u0006!\u0002\u0013\t)\u0006C\u0005\u0002`-\u0011\r\u0011\"\u0003\u0002b!A\u0011\u0011O\u0006!\u0002\u0013\t\u0019\u0007C\u0005\u0002t-\u0011\r\u0011\"\u0003\u0002v!A\u0011qP\u0006!\u0002\u0013\t9\bC\u0005\u0002\u0002.\u0011\r\u0011\"\u0001\u0002\u0004\"A\u0011QR\u0006!\u0002\u0013\t)\tC\u0005\u0002\u0010.\u0011\r\u0011\"\u0001\u0002\u0012\"A\u00111T\u0006!\u0002\u0013\t\u0019\nC\u0005\u0002\u001e.\u0011\r\u0011\"\u0001\u0002 \"A\u0011\u0011V\u0006!\u0002\u0013\t\t\u000bC\u0005\u0002,.\u0011\r\u0011\"\u0001\u0002.\"A\u0011\u0011W\u0006!\u0002\u0013\ty\u000bC\u0005\u00024.\u0011\r\u0011\"\u0001\u00026\"A\u0011qX\u0006!\u0002\u0013\t9\fC\u0005\u0002B.\u0011\r\u0011\"\u0001\u0002D\"A\u0011QZ\u0006!\u0002\u0013\t)\rC\u0005\u0002P.\u0011\r\u0011\"\u0001\u0002R\"A\u00111\\\u0006!\u0002\u0013\t\u0019\u000eC\u0005\u0002^.\u0011\r\u0011\"\u0001\u0002`\"A\u00111]\u0006!\u0002\u0013\t\t\u000fC\u0005\u0002f.\u0011\r\u0011\"\u0001\u0002h\"A\u00111^\u0006!\u0002\u0013\tI\u000fC\u0005\u0002n.\u0011\r\u0011\"\u0001\u0002p\"A\u00111_\u0006!\u0002\u0013\t\t\u0010C\u0005\u0002v.\u0011\r\u0011\"\u0001\u0002x\"A\u00111`\u0006!\u0002\u0013\tI\u0010C\u0005\u0002~.\u0011\r\u0011\"\u0001\u0002\u0000\"A!\u0011B\u0006!\u0002\u0013\u0011\t\u0001C\u0005\u0003\f-\u0011\r\u0011\"\u0001\u0003\u000e!A!\u0011C\u0006!\u0002\u0013\u0011y\u0001C\u0005\u0003\u0014-\u0011\r\u0011\"\u0001\u0003\u0016!A!\u0011D\u0006!\u0002\u0013\u00119\u0002C\u0005\u0003\u001c-\u0011\r\u0011\"\u0001\u0003\u001e!A!qE\u0006!\u0002\u0013\u0011y\u0002\u0003\u0005\u0003*-\u0001\u000b\u0011\u0002B\u0016\r\u0019\u0011)i\u0003\u0003\u0003\b\"I\u0001M\rBC\u0002\u0013\u0005!\u0011\u0013\u0005\u000b\u0005;\u0013$\u0011!Q\u0001\n\tM\u0005bBA'e\u0011\u0005!q\u0014\u0005\u0007iJ\"\tEa,\t\u000f\t\u00057\u0002\"\u0001\u0003D\"11p\u0003C\u0001\u00057D\u0011B!>\f\u0003\u0003%IAa>\u0003\u0011\rc\u0017m]:UC\u001eT!\u0001P\u001f\u0002\u000fI,g\r\\3di*\ta(A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u0005\u0005c5#\u0002\u0001C\rVC\u0006CA\"E\u001b\u0005i\u0014BA#>\u0005\u0019\te.\u001f*fMB\u0019q\t\u0013&\u000e\u0003mJ!!S\u001e\u00037\rc\u0017m]:NC:Lg-Z:u\t\u0016\u0004(/Z2bi\u0016$\u0017\t]5t!\tYE\n\u0004\u0001\u0005\u000b5\u0003!\u0019\u0001(\u0003\u0003Q\u000b\"a\u0014*\u0011\u0005\r\u0003\u0016BA)>\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"aQ*\n\u0005Qk$aA!osB\u00111IV\u0005\u0003/v\u0012a!R9vC2\u001c\bCA\"Z\u0013\tQVH\u0001\u0007TKJL\u0017\r\\5{C\ndW-\u0001\u0004%S:LG\u000f\n\u000b\u0002;B\u00111IX\u0005\u0003?v\u0012A!\u00168ji\u0006a!/\u001e8uS6,7\t\\1tgV\t!\r\r\u0002dYB\u0019A-[6\u000e\u0003\u0015T!AZ4\u0002\t1\fgn\u001a\u0006\u0002Q\u0006!!.\u0019<b\u0013\tQWMA\u0003DY\u0006\u001c8\u000f\u0005\u0002LY\u0012IQNAA\u0001\u0002\u0003\u0015\tA\u0014\u0002\u0004?\u0012\n\u0014\u0001B<sCB,\u0012\u0001\u001d\t\u0004\u000f\u0002\t\bcA\"s\u0015&\u00111/\u0010\u0002\u0006\u0003J\u0014\u0018-_\u0001\t]\u0016<\u0018I\u001d:bsR\u0011\u0011O\u001e\u0005\u0006o\u0012\u0001\r\u0001_\u0001\u0004Y\u0016t\u0007CA\"z\u0013\tQXHA\u0002J]R\fq!\u001e8baBd\u0017\u0010F\u0002~\u0003\u0003\u00012a\u0011@K\u0013\tyXH\u0001\u0004PaRLwN\u001c\u0005\u0007\u0003\u0007)\u0001\u0019\u0001*\u0002\u0003a\f\u0001bY1o\u000bF,\u0018\r\u001c\u000b\u0005\u0003\u0013\ty\u0001E\u0002D\u0003\u0017I1!!\u0004>\u0005\u001d\u0011un\u001c7fC:Da!a\u0001\u0007\u0001\u0004\u0011\u0016AB3rk\u0006d7\u000f\u0006\u0003\u0002\n\u0005U\u0001BBA\u0002\u000f\u0001\u0007!+\u0001\u0005iCND7i\u001c3f)\u0005A\u0018\u0001\u0003;p'R\u0014\u0018N\\4\u0015\u0005\u0005}\u0001\u0003BA\u0011\u0003_qA!a\t\u0002,A\u0019\u0011QE\u001f\u000e\u0005\u0005\u001d\"bAA\u0015\u007f\u00051AH]8pizJ1!!\f>\u0003\u0019\u0001&/\u001a3fM&!\u0011\u0011GA\u001a\u0005\u0019\u0019FO]5oO*\u0019\u0011QF\u001f)\u000b\u0001\t9$a\u0011\u0011\t\u0005e\u0012qH\u0007\u0003\u0003wQ1!!\u0010>\u0003)\tgN\\8uCRLwN\\\u0005\u0005\u0003\u0003\nYD\u0001\tj[Bd\u0017nY5u\u001d>$hi\\;oI\u0006\u0012\u0011QI\u0001\u001f\u001d>\u00043\t\\1tgR\u000bw\rI1wC&d\u0017M\u00197fA\u0019|'\u000f\t\u0013|)v\f\u0001b\u00117bgN$\u0016m\u001a\t\u0003\u000f.\u00192a\u0003\"Y\u0003\u0019a\u0014N\\5u}Q\u0011\u0011\u0011J\u0001\u000b\u001f\nTWm\u0019;U3B+UCAA+!\u0011!\u0017.a\u0016\u0011\u0007\u0011\fI&C\u0002\u0002\\\u0015\u0014aa\u00142kK\u000e$\u0018aC(cU\u0016\u001cG\u000fV-Q\u000b\u0002\n1BT8uQ&tw\rV-Q\u000bV\u0011\u00111\r\t\u0005I&\f)\u0007\u0005\u0003\u0002h\u00055TBAA5\u0015\r\tY'P\u0001\beVtG/[7f\u0013\u0011\ty'!\u001b\u0003\u00119{G\u000f[5oO\u0012\nABT8uQ&tw\rV-Q\u000b\u0002\n\u0001BT;mYRK\u0006+R\u000b\u0003\u0003o\u0002B\u0001Z5\u0002zA!\u0011qMA>\u0013\u0011\ti(!\u001b\u0003\u000b9+H\u000e\u001c\u0013\u0002\u00139+H\u000e\u001c+Z!\u0016\u0003\u0013\u0001\u0002\"zi\u0016,\"!!\"\u0011\t\u001d\u0003\u0011q\u0011\t\u0004\u0007\u0006%\u0015bAAF{\t!!)\u001f;f\u0003\u0015\u0011\u0015\u0010^3!\u0003\u0015\u0019\u0006n\u001c:u+\t\t\u0019\n\u0005\u0003H\u0001\u0005U\u0005cA\"\u0002\u0018&\u0019\u0011\u0011T\u001f\u0003\u000bMCwN\u001d;\u0002\rMCwN\u001d;!\u0003\u0011\u0019\u0005.\u0019:\u0016\u0005\u0005\u0005\u0006\u0003B$\u0001\u0003G\u00032aQAS\u0013\r\t9+\u0010\u0002\u0005\u0007\"\f'/A\u0003DQ\u0006\u0014\b%A\u0002J]R,\"!a,\u0011\u0007\u001d\u0003\u00010\u0001\u0003J]R\u0004\u0013\u0001\u0002'p]\u001e,\"!a.\u0011\t\u001d\u0003\u0011\u0011\u0018\t\u0004\u0007\u0006m\u0016bAA_{\t!Aj\u001c8h\u0003\u0015auN\\4!\u0003\u00151En\\1u+\t\t)\r\u0005\u0003H\u0001\u0005\u001d\u0007cA\"\u0002J&\u0019\u00111Z\u001f\u0003\u000b\u0019cw.\u0019;\u0002\r\u0019cw.\u0019;!\u0003\u0019!u.\u001e2mKV\u0011\u00111\u001b\t\u0005\u000f\u0002\t)\u000eE\u0002D\u0003/L1!!7>\u0005\u0019!u.\u001e2mK\u00069Ai\\;cY\u0016\u0004\u0013a\u0002\"p_2,\u0017M\\\u000b\u0003\u0003C\u0004Ba\u0012\u0001\u0002\n\u0005A!i\\8mK\u0006t\u0007%\u0001\u0003V]&$XCAAu!\r9\u0005!X\u0001\u0006+:LG\u000fI\u0001\u0004\u0003:LXCAAy!\r9\u0005AU\u0001\u0005\u0003:L\b%\u0001\u0004PE*,7\r^\u000b\u0003\u0003s\u0004Ba\u0012\u0001\u0002X\u00059qJ\u00196fGR\u0004\u0013AB!osZ\u000bG.\u0006\u0002\u0003\u0002A!q\t\u0001B\u0002!\r\u0019%QA\u0005\u0004\u0005\u000fi$AB!osZ\u000bG.A\u0004B]f4\u0016\r\u001c\u0011\u0002\r\u0005s\u0017PU3g+\t\u0011y\u0001E\u0002H\u0001\t\u000bq!\u00118z%\u00164\u0007%A\u0004O_RD\u0017N\\4\u0016\u0005\t]\u0001cA$\u0001\u001f\u0006Aaj\u001c;iS:<\u0007%\u0001\u0003Ok2dWC\u0001B\u0010!\u00119\u0005A!\t\u0011\u0007\r\u0013\u0019#C\u0002\u0003&u\u0012AAT;mY\u0006)a*\u001e7mA\u0005)1-Y2iKB)AM!\f\u00032%\u0019!qF3\u0003\u0015\rc\u0017m]:WC2,X\r\r\u0003\u00034\t]\u0002\u0003B$\u0001\u0005k\u00012a\u0013B\u001c\t-\u0011IDa\u000f\u0002\u0002\u0003\u0005)\u0011\u0001(\u0003\u0007}#cG\u0002\u0004\u0003>E\u0012!q\b\u0002\u0006I\u0005twN\\\n\u0005\u0005w\u0011Y\u0003\u0003\u0005\u0002N\tmB\u0011\u0001B\")\t\u0011)\u0005E\u0002L\u0005wA\u0001B!\u0013\u0003<\u0011\u0005#1J\u0001\rG>l\u0007/\u001e;f-\u0006dW/\u001a\u000b\u0005\u0005\u001b\u00129\u0006\r\u0003\u0003P\tM\u0003\u0003B$\u0001\u0005#\u00022a\u0013B*\t-\u0011)Fa\u0012\u0002\u0002\u0003\u0005)\u0011\u0001(\u0003\u0007}#\u0003\bC\u0004a\u0005\u000f\u0002\rA!\u00171\t\tm#q\f\t\u0005I&\u0014i\u0006E\u0002L\u0005?\"1B!\u0019\u0003X\u0005\u0005\t\u0011!B\u0001\u001d\n\u0019q\fJ\u001c\t\u0011\t\u0015$1\bC\u0005\u0005O\n\u0011\u0003\u001d:j[&$\u0018N^3DY\u0006\u001c8\u000fV1h+\u0011\u0011IGa!\u0015\t\t-$Q\u000f\u0019\u0005\u0005[\u0012\t\b\u0005\u0003H\u0001\t=\u0004cA&\u0003r\u0011Y!1\u000fB2\u0003\u0003\u0005\tQ!\u0001O\u0005\u0011yF%\r\u0019\t\u000f\u0001\u0014\u0019\u00071\u0001\u0003xA\"!\u0011\u0010B@!\u0019\t\tCa\u001f\u0003~%\u0019!.a\r\u0011\u0007-\u0013y\bB\u0006\u0003\u0002\nU\u0014\u0011!A\u0001\u0006\u0003q%aA0%s\u00111QJa\u0019C\u00029\u0013qbR3oKJL7m\u00117bgN$\u0016mZ\u000b\u0005\u0005\u0013\u0013yi\u0005\u00033\u0005\n-\u0005\u0003B$\u0001\u0005\u001b\u00032a\u0013BH\t\u0015i%G1\u0001O+\t\u0011\u0019\n\r\u0003\u0003\u0016\ne\u0005\u0003\u00023j\u0005/\u00032a\u0013BM\t)\u0011Y\nNA\u0001\u0002\u0003\u0015\tA\u0014\u0002\u0005?\u0012\n\u0014'A\u0007sk:$\u0018.\\3DY\u0006\u001c8\u000f\t\u000b\u0005\u0005C\u0013)\u000bE\u0003\u0003$J\u0012i)D\u0001\f\u0011\u0019\u0001W\u00071\u0001\u0003(B\"!\u0011\u0016BW!\u0011!\u0017Na+\u0011\u0007-\u0013i\u000bB\u0006\u0003\u001c\n\u0015\u0016\u0011!A\u0001\u0006\u0003qE\u0003\u0002BY\u0005g\u0003Ba\u0011:\u0003\u000e\")qO\u000ea\u0001q\":!Ga.\u0003>\n}\u0006cA\"\u0003:&\u0019!1X\u001f\u0003!M+'/[1m-\u0016\u00148/[8o+&#\u0015!\u0002<bYV,g$A\u0001\u0002\u000b\u0005\u0004\b\u000f\\=\u0016\t\t\u0015'1\u001a\u000b\u0005\u0005\u000f\u0014i\r\u0005\u0003H\u0001\t%\u0007cA&\u0003L\u0012)Qj\u000eb\u0001\u001d\"9!qZ\u001cA\u0002\tE\u0017!\u0004:v]RLW.Z\"mCN\u001c\u0018\u0007\r\u0003\u0003T\n]\u0007\u0003\u00023j\u0005+\u00042a\u0013Bl\t-\u0011IN!4\u0002\u0002\u0003\u0005)\u0011\u0001(\u0003\t}#\u0013GM\u000b\u0005\u0005;\u0014\u0019\u0010\u0006\u0003\u0003`\n-\b\u0003B\"\u007f\u0005C\u0004DAa9\u0003hB1\u0011\u0011\u0005B>\u0005K\u00042a\u0013Bt\t)\u0011I\u000fOA\u0001\u0002\u0003\u0015\tA\u0014\u0002\u0005?\u0012\n4\u0007C\u0004\u0003nb\u0002\rAa<\u0002\t\r$\u0018m\u001a\t\u0005\u000f\u0002\u0011\t\u0010E\u0002L\u0005g$Q!\u0014\u001dC\u00029\u000b1B]3bIJ+7o\u001c7wKR\u0011\u0011q\u000b")
public interface ClassTag<T>
extends ClassManifestDeprecatedApis<T>,
Equals {
    public static <T> ClassTag<T> apply(Class<?> clazz) {
        return ClassTag$.MODULE$.apply(clazz);
    }

    public static ClassTag<Null$> Null() {
        return ClassTag$.MODULE$.Null();
    }

    public static ClassTag<Nothing$> Nothing() {
        return ClassTag$.MODULE$.Nothing();
    }

    public static ClassTag<Object> AnyRef() {
        return ClassTag$.MODULE$.AnyRef();
    }

    public static ClassTag<Object> AnyVal() {
        return ClassTag$.MODULE$.AnyVal();
    }

    public static ClassTag<Object> Object() {
        return ClassTag$.MODULE$.Object();
    }

    public static ClassTag<Object> Any() {
        return ClassTag$.MODULE$.Any();
    }

    public static ClassTag<BoxedUnit> Unit() {
        return ClassTag$.MODULE$.Unit();
    }

    public static ClassTag<Object> Boolean() {
        return ClassTag$.MODULE$.Boolean();
    }

    public static ClassTag<Object> Double() {
        return ClassTag$.MODULE$.Double();
    }

    public static ClassTag<Object> Float() {
        return ClassTag$.MODULE$.Float();
    }

    public static ClassTag<Object> Long() {
        return ClassTag$.MODULE$.Long();
    }

    public static ClassTag<Object> Int() {
        return ClassTag$.MODULE$.Int();
    }

    public static ClassTag<Object> Char() {
        return ClassTag$.MODULE$.Char();
    }

    public static ClassTag<Object> Short() {
        return ClassTag$.MODULE$.Short();
    }

    public static ClassTag<Object> Byte() {
        return ClassTag$.MODULE$.Byte();
    }

    public Class<?> runtimeClass();

    default public ClassTag<Object> wrap() {
        return ClassTag$.MODULE$.apply(this.arrayClass(this.runtimeClass()));
    }

    public static /* synthetic */ Object newArray$(ClassTag $this, int len) {
        return $this.newArray(len);
    }

    @Override
    default public Object newArray(int len) {
        if (this.runtimeClass().isPrimitive()) {
            Object[] objectArray;
            Class<?> clazz = this.runtimeClass();
            Class<Integer> clazz2 = Integer.TYPE;
            if (!(clazz2 != null ? !clazz2.equals(clazz) : clazz != null)) {
                objectArray = new int[len];
            } else {
                Class<Double> clazz3 = Double.TYPE;
                if (!(clazz3 != null ? !clazz3.equals(clazz) : clazz != null)) {
                    objectArray = new double[len];
                } else {
                    Class<Long> clazz4 = Long.TYPE;
                    if (!(clazz4 != null ? !clazz4.equals(clazz) : clazz != null)) {
                        objectArray = new long[len];
                    } else {
                        Class<Float> clazz5 = Float.TYPE;
                        if (!(clazz5 != null ? !clazz5.equals(clazz) : clazz != null)) {
                            objectArray = new float[len];
                        } else {
                            Class<Character> clazz6 = Character.TYPE;
                            if (!(clazz6 != null ? !clazz6.equals(clazz) : clazz != null)) {
                                objectArray = new char[len];
                            } else {
                                Class<Byte> clazz7 = Byte.TYPE;
                                if (!(clazz7 != null ? !clazz7.equals(clazz) : clazz != null)) {
                                    objectArray = new byte[len];
                                } else {
                                    Class<Short> clazz8 = Short.TYPE;
                                    if (!(clazz8 != null ? !clazz8.equals(clazz) : clazz != null)) {
                                        objectArray = new short[len];
                                    } else {
                                        Class<Boolean> clazz9 = Boolean.TYPE;
                                        if (!(clazz9 != null ? !clazz9.equals(clazz) : clazz != null)) {
                                            objectArray = new boolean[len];
                                        } else {
                                            Class<Void> clazz10 = Void.TYPE;
                                            if (!(clazz10 != null ? !clazz10.equals(clazz) : clazz != null)) {
                                                objectArray = new BoxedUnit[len];
                                            } else {
                                                throw new MatchError(clazz);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return objectArray;
        }
        return Array.newInstance(this.runtimeClass(), len);
    }

    default public Option<T> unapply(Object x) {
        if (this.runtimeClass().isInstance(x)) {
            return new Some<Object>(x);
        }
        return None$.MODULE$;
    }

    @Override
    default public boolean canEqual(Object x) {
        return x instanceof ClassTag;
    }

    @Override
    default public boolean equals(Object x) {
        if (x instanceof ClassTag) {
            Class<?> clazz = this.runtimeClass();
            Class<?> clazz2 = ((ClassTag)x).runtimeClass();
            if (!(clazz != null ? !clazz.equals(clazz2) : clazz2 != null)) {
                return true;
            }
        }
        return false;
    }

    default public int hashCode() {
        return Statics.anyHash(this.runtimeClass());
    }

    default public String toString() {
        return ClassTag.prettyprint$1(this.runtimeClass());
    }

    private static String prettyprint$1(Class clazz) {
        if (clazz.isArray()) {
            return new StringBuilder(7).append("Array[").append(ClassTag.prettyprint$1(clazz.getComponentType())).append("]").toString();
        }
        return clazz.getName();
    }

    public static void $init$(ClassTag $this) {
    }

    public static class GenericClassTag<T>
    implements ClassTag<T> {
        public static final long serialVersionUID = 1L;
        private final Class<?> runtimeClass;

        @Override
        public ClassTag<Object> wrap() {
            return ((ClassTag)this).wrap();
        }

        @Override
        public Option<T> unapply(Object x) {
            return ((ClassTag)this).unapply(x);
        }

        @Override
        public boolean canEqual(Object x) {
            return ((ClassTag)this).canEqual(x);
        }

        @Override
        public boolean equals(Object x) {
            return ((ClassTag)this).equals(x);
        }

        @Override
        public int hashCode() {
            return ((ClassTag)this).hashCode();
        }

        @Override
        public String toString() {
            return ((ClassTag)this).toString();
        }

        @Override
        public Class<?> erasure() {
            return ClassManifestDeprecatedApis.erasure$(this);
        }

        @Override
        public boolean $less$colon$less(ClassTag<?> that) {
            return ClassManifestDeprecatedApis.$less$colon$less$(this, that);
        }

        @Override
        public boolean $greater$colon$greater(ClassTag<?> that) {
            return ClassManifestDeprecatedApis.$greater$colon$greater$(this, that);
        }

        @Override
        public <T> Class<Object> arrayClass(Class<?> tp) {
            return ClassManifestDeprecatedApis.arrayClass$(this, tp);
        }

        @Override
        public ClassTag<Object> arrayManifest() {
            return ClassManifestDeprecatedApis.arrayManifest$(this);
        }

        @Override
        public Object[] newArray2(int len) {
            return ClassManifestDeprecatedApis.newArray2$(this, len);
        }

        @Override
        public Object[][] newArray3(int len) {
            return ClassManifestDeprecatedApis.newArray3$(this, len);
        }

        @Override
        public Object[][][] newArray4(int len) {
            return ClassManifestDeprecatedApis.newArray4$(this, len);
        }

        @Override
        public Object[][][][] newArray5(int len) {
            return ClassManifestDeprecatedApis.newArray5$(this, len);
        }

        @Override
        public WrappedArray<T> newWrappedArray(int len) {
            return ClassManifestDeprecatedApis.newWrappedArray$(this, len);
        }

        @Override
        public ArrayBuilder<T> newArrayBuilder() {
            return ClassManifestDeprecatedApis.newArrayBuilder$(this);
        }

        @Override
        public List<OptManifest<?>> typeArguments() {
            return ClassManifestDeprecatedApis.typeArguments$(this);
        }

        @Override
        public String argString() {
            return ClassManifestDeprecatedApis.argString$(this);
        }

        @Override
        public Class<?> runtimeClass() {
            return this.runtimeClass;
        }

        @Override
        public Object newArray(int len) {
            return Array.newInstance(this.runtimeClass(), len);
        }

        public GenericClassTag(Class<?> runtimeClass) {
            this.runtimeClass = runtimeClass;
            ClassManifestDeprecatedApis.$init$(this);
            ClassTag.$init$(this);
        }
    }
}

