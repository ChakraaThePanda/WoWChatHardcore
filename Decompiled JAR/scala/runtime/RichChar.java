/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import scala.Proxy;
import scala.collection.immutable.NumericRange;
import scala.math.Numeric$CharIsIntegral$;
import scala.math.Ordered;
import scala.math.Ordering$Char$;
import scala.math.ScalaNumericAnyConversions;
import scala.reflect.ScalaSignature;
import scala.runtime.IntegralProxy;
import scala.runtime.OrderedProxy;
import scala.runtime.RichChar$;
import scala.runtime.ScalaNumberProxy;
import scala.runtime.ScalaWholeNumberProxy;

@ScalaSignature(bytes="\u0006\u0001\tUf\u0001B+W\u0005mC\u0001b\u001a\u0001\u0003\u0006\u0004%\t\u0001\u001b\u0005\tS\u0002\u0011\t\u0011)A\u0005I\")!\u000e\u0001C\u0001W\")a\u000e\u0001C\t_\"9\u0011\u0011\u0001\u0001\u0005\u0012\u0005\r\u0001bBA\n\u0001\u0011\u0005\u0013Q\u0003\u0005\b\u0003;\u0001A\u0011IA\u0010\u0011\u001d\t9\u0003\u0001C!\u0003SAq!!\r\u0001\t\u0003\n\u0019\u0004C\u0004\u0002<\u0001!\t%!\u0010\t\u000f\u0005\u0015\u0003\u0001\"\u0011\u0002H!9\u0011q\n\u0001\u0005B\u0005E\u0003BBA-\u0001\u0011\u0005\u0003\u000eC\u0004\u0002\\\u0001!\t%!\u0018\t\u000f\u0005\r\u0004\u0001\"\u0011\u0002f!9\u0011\u0011\u000e\u0001\u0005B\u0005-\u0004bBA7\u0001\u0011\u0005\u00111\u000e\u0005\b\u0003_\u0002A\u0011AA)\u0011\u001d\t\t\b\u0001C\u0001\u0003#Bq!a\u001d\u0001\t\u0003\t\t\u0006C\u0004\u0002v\u0001!\t!!\u0015\t\u000f\u0005]\u0004\u0001\"\u0001\u0002R!9\u0011\u0011\u0010\u0001\u0005\u0002\u0005E\u0003bBA>\u0001\u0011\u0005\u0011\u0011\u000b\u0005\b\u0003{\u0002A\u0011AA)\u0011\u001d\ty\b\u0001C\u0001\u0003#Bq!!!\u0001\t\u0003\t\t\u0006C\u0004\u0002\u0004\u0002!\t!!\u0015\t\u000f\u0005\u0015\u0005\u0001\"\u0001\u0002R!9\u0011q\u0011\u0001\u0005\u0002\u0005E\u0003bBAE\u0001\u0011\u0005\u0011\u0011\u000b\u0005\b\u0003\u0017\u0003A\u0011AA)\u0011\u001d\ti\t\u0001C\u0001\u0003#Ba!a$\u0001\t\u0003A\u0007BBAI\u0001\u0011\u0005\u0001\u000e\u0003\u0004\u0002\u0014\u0002!\t\u0001\u001b\u0005\b\u0003+\u0003A\u0011AA6\u0011\u001d\t9\n\u0001C\u0001\u0003WBq!!'\u0001\t\u0003\tY\n\u0003\u0004\u0002\u001e\u0002!\t\u0001\u001b\u0005\n\u0003?\u0003\u0011\u0011!C!\u0003gA\u0011\"!)\u0001\u0003\u0003%\t%a)\b\u0013\u0005=f+!A\t\u0002\u0005Ef\u0001C+W\u0003\u0003E\t!a-\t\r)dC\u0011AA^\u0011\u001d\ti\f\fC\u0003\u0003\u007fCq!!2-\t\u000b\t9\rC\u0004\u0002L2\")!!4\t\u000f\u0005EG\u0006\"\u0002\u0002T\"9\u0011q\u001b\u0017\u0005\u0006\u0005e\u0007bBAoY\u0011\u0015\u0011q\u001c\u0005\b\u0003GdCQAAs\u0011\u001d\tI\u000f\fC\u0003\u0003WDq!a<-\t\u000b\t\t\u0010C\u0004\u0002v2\")!a>\t\u000f\u0005mH\u0006\"\u0002\u0002~\"9!Q\u0001\u0017\u0005\u0006\t\u001d\u0001b\u0002B\bY\u0011\u0015!\u0011\u0003\u0005\b\u0005+aCQ\u0001B\f\u0011\u001d\u0011Y\u0002\fC\u0003\u0005;AqA!\t-\t\u000b\u0011\u0019\u0003C\u0004\u0003(1\")A!\u000b\t\u000f\t5B\u0006\"\u0002\u00030!9!1\u0007\u0017\u0005\u0006\tU\u0002b\u0002B\u001dY\u0011\u0015!1\b\u0005\b\u0005\u007faCQ\u0001B!\u0011\u001d\u0011)\u0005\fC\u0003\u0005\u000fBqAa\u0013-\t\u000b\u0011i\u0005C\u0004\u0003R1\")Aa\u0015\t\u000f\t]C\u0006\"\u0002\u0003Z!9!Q\f\u0017\u0005\u0006\t}\u0003b\u0002B2Y\u0011\u0015!Q\r\u0005\b\u0005SbCQ\u0001B6\u0011\u001d\u0011y\u0007\fC\u0003\u0005cBqA!\u001e-\t\u000b\u00119\bC\u0004\u0003|1\")A! \t\u000f\t\u0005E\u0006\"\u0002\u0003\u0004\"9!q\u0011\u0017\u0005\u0006\t%\u0005b\u0002BGY\u0011\u0015!q\u0012\u0005\b\u0005'cCQ\u0001BK\u0011\u001d\u0011I\n\fC\u0003\u00057CqAa(-\t\u000b\u0011\t\u000bC\u0005\u0003&2\n\t\u0011\"\u0002\u0003(\"I!1\u0016\u0017\u0002\u0002\u0013\u0015!Q\u0016\u0002\t%&\u001c\u0007n\u00115be*\u0011q\u000bW\u0001\beVtG/[7f\u0015\u0005I\u0016!B:dC2\f7\u0001A\n\u0004\u0001q\u0003\u0007CA/_\u001b\u0005A\u0016BA0Y\u0005\u0019\te.\u001f,bYB\u0019\u0011M\u00193\u000e\u0003YK!a\u0019,\u0003\u001b%sG/Z4sC2\u0004&o\u001c=z!\tiV-\u0003\u0002g1\n!1\t[1s\u0003\u0011\u0019X\r\u001c4\u0016\u0003\u0011\fQa]3mM\u0002\na\u0001P5oSRtDC\u00017n!\t\t\u0007\u0001C\u0003h\u0007\u0001\u0007A-A\u0002ok6,\u0012\u0001\u001d\b\u0003cvt!A\u001d>\u000f\u0005MDhB\u0001;x\u001b\u0005)(B\u0001<[\u0003\u0019a$o\\8u}%\t\u0011,\u0003\u0002z1\u0006!Q.\u0019;i\u0013\tYH0A\u0004Ok6,'/[2\u000b\u0005eD\u0016B\u0001@\u0000\u00039\u0019\u0005.\u0019:Jg&sG/Z4sC2T!a\u001f?\u0002\u0007=\u0014H-\u0006\u0002\u0002\u00069!\u0011qAA\u0007\u001d\r\u0011\u0018\u0011B\u0005\u0004\u0003\u0017a\u0018\u0001C(sI\u0016\u0014\u0018N\\4\n\t\u0005=\u0011\u0011C\u0001\u0005\u0007\"\f'OC\u0002\u0002\fq\f1\u0002Z8vE2,g+\u00197vKR\u0011\u0011q\u0003\t\u0004;\u0006e\u0011bAA\u000e1\n1Ai\\;cY\u0016\f!B\u001a7pCR4\u0016\r\\;f)\t\t\t\u0003E\u0002^\u0003GI1!!\nY\u0005\u00151En\\1u\u0003%awN\\4WC2,X\r\u0006\u0002\u0002,A\u0019Q,!\f\n\u0007\u0005=\u0002L\u0001\u0003M_:<\u0017\u0001C5oiZ\u000bG.^3\u0015\u0005\u0005U\u0002cA/\u00028%\u0019\u0011\u0011\b-\u0003\u0007%sG/A\u0005csR,g+\u00197vKR\u0011\u0011q\b\t\u0004;\u0006\u0005\u0013bAA\"1\n!!)\u001f;f\u0003)\u0019\bn\u001c:u-\u0006dW/\u001a\u000b\u0003\u0003\u0013\u00022!XA&\u0013\r\ti\u0005\u0017\u0002\u0006'\"|'\u000f^\u0001\fSN4\u0016\r\\5e\u0007\"\f'/\u0006\u0002\u0002TA\u0019Q,!\u0016\n\u0007\u0005]\u0003LA\u0004C_>dW-\u00198\u0002\u0007\u0005\u00147/A\u0002nCb$2\u0001ZA0\u0011\u0019\t\tG\u0004a\u0001I\u0006!A\u000f[1u\u0003\ri\u0017N\u001c\u000b\u0004I\u0006\u001d\u0004BBA1\u001f\u0001\u0007A-\u0001\u0004tS\u001etW/\\\u000b\u0003\u0003k\tq!Y:ES\u001eLG/A\u0005jg\u000e{g\u000e\u001e:pY\u00069\u0011n\u001d#jO&$\u0018\u0001C5t\u0019\u0016$H/\u001a:\u0002\u001f%\u001cH*\u001a;uKJ|%\u000fR5hSR\fA\"[:XQ&$Xm\u001d9bG\u0016\f1\"[:Ta\u0006\u001cWm\u00115be\u0006y\u0011n\u001d%jO\"\u001cVO\u001d:pO\u0006$X-\u0001\bjg2{woU;se><\u0017\r^3\u0002\u0017%\u001c8+\u001e:s_\u001e\fG/Z\u0001\u0019SN,f.[2pI\u0016LE-\u001a8uS\u001aLWM]*uCJ$\u0018aF5t+:L7m\u001c3f\u0013\u0012,g\u000e^5gS\u0016\u0014\b+\u0019:u\u0003UI7/\u00133f]RLg-[3s\u0013\u001etwN]1cY\u0016\f!\"[:NSJ\u0014xN]3e\u0003\u001dI7\u000fT8xKJ\fq![:VaB,'/A\u0006jgRKG\u000f\\3DCN,\u0017a\u0002;p\u0019><XM]\u0001\bi>,\u0006\u000f]3s\u0003-!x\u000eV5uY\u0016\u001c\u0015m]3\u0002\u000f\u001d,G\u000fV=qK\u0006yq-\u001a;Ok6,'/[2WC2,X-A\thKR$\u0015N]3di&|g.\u00197jif,\"!a\u0010\u0002\u0019I,g/\u001a:tK\nKH/Z:\u0002\u0011!\f7\u000f[\"pI\u0016\fa!Z9vC2\u001cH\u0003BA*\u0003KC\u0011\"a*+\u0003\u0003\u0005\r!!+\u0002\u0007a$\u0013\u0007E\u0002^\u0003WK1!!,Y\u0005\r\te._\u0001\t%&\u001c\u0007n\u00115beB\u0011\u0011\rL\n\u0004Y\u0005U\u0006cA/\u00028&\u0019\u0011\u0011\u0018-\u0003\r\u0005s\u0017PU3g)\t\t\t,A\u0007ok6$S\r\u001f;f]NLwN\u001c\u000b\u0004a\u0006\u0005\u0007BBAb]\u0001\u0007A.A\u0003%i\"L7/A\u0007pe\u0012$S\r\u001f;f]NLwN\u001c\u000b\u0005\u0003\u000b\tI\r\u0003\u0004\u0002D>\u0002\r\u0001\\\u0001\u0016I>,(\r\\3WC2,X\rJ3yi\u0016t7/[8o)\u0011\t)\"a4\t\r\u0005\r\u0007\u00071\u0001m\u0003Q1Gn\\1u-\u0006dW/\u001a\u0013fqR,gn]5p]R!\u0011qDAk\u0011\u0019\t\u0019-\ra\u0001Y\u0006\u0019Bn\u001c8h-\u0006dW/\u001a\u0013fqR,gn]5p]R!\u0011\u0011FAn\u0011\u0019\t\u0019M\ra\u0001Y\u0006\u0011\u0012N\u001c;WC2,X\rJ3yi\u0016t7/[8o)\u0011\t\u0019$!9\t\r\u0005\r7\u00071\u0001m\u0003M\u0011\u0017\u0010^3WC2,X\rJ3yi\u0016t7/[8o)\u0011\ti$a:\t\r\u0005\rG\u00071\u0001m\u0003Q\u0019\bn\u001c:u-\u0006dW/\u001a\u0013fqR,gn]5p]R!\u0011qIAw\u0011\u0019\t\u0019-\u000ea\u0001Y\u0006)\u0012n\u001d,bY&$7\t[1sI\u0015DH/\u001a8tS>tG\u0003BA*\u0003gDa!a17\u0001\u0004a\u0017!D1cg\u0012*\u0007\u0010^3og&|g\u000eF\u0002e\u0003sDa!a18\u0001\u0004a\u0017!D7bq\u0012*\u0007\u0010^3og&|g\u000e\u0006\u0003\u0002\u0000\n\rAc\u00013\u0003\u0002!1\u0011\u0011\r\u001dA\u0002\u0011Da!a19\u0001\u0004a\u0017!D7j]\u0012*\u0007\u0010^3og&|g\u000e\u0006\u0003\u0003\n\t5Ac\u00013\u0003\f!1\u0011\u0011M\u001dA\u0002\u0011Da!a1:\u0001\u0004a\u0017\u0001E:jO:,X\u000eJ3yi\u0016t7/[8o)\u0011\t)Da\u0005\t\r\u0005\r'\b1\u0001m\u0003E\t7\u000fR5hSR$S\r\u001f;f]NLwN\u001c\u000b\u0005\u0003k\u0011I\u0002\u0003\u0004\u0002Dn\u0002\r\u0001\\\u0001\u0014SN\u001cuN\u001c;s_2$S\r\u001f;f]NLwN\u001c\u000b\u0005\u0003'\u0012y\u0002\u0003\u0004\u0002Dr\u0002\r\u0001\\\u0001\u0012SN$\u0015nZ5uI\u0015DH/\u001a8tS>tG\u0003BA*\u0005KAa!a1>\u0001\u0004a\u0017AE5t\u0019\u0016$H/\u001a:%Kb$XM\\:j_:$B!a\u0015\u0003,!1\u00111\u0019 A\u00021\f\u0011$[:MKR$XM](s\t&<\u0017\u000e\u001e\u0013fqR,gn]5p]R!\u00111\u000bB\u0019\u0011\u0019\t\u0019m\u0010a\u0001Y\u00061\u0012n],iSR,7\u000f]1dK\u0012*\u0007\u0010^3og&|g\u000e\u0006\u0003\u0002T\t]\u0002BBAb\u0001\u0002\u0007A.A\u000bjgN\u0003\u0018mY3DQ\u0006\u0014H%\u001a=uK:\u001c\u0018n\u001c8\u0015\t\u0005M#Q\b\u0005\u0007\u0003\u0007\f\u0005\u0019\u00017\u00023%\u001c\b*[4i'V\u0014(o\\4bi\u0016$S\r\u001f;f]NLwN\u001c\u000b\u0005\u0003'\u0012\u0019\u0005\u0003\u0004\u0002D\n\u0003\r\u0001\\\u0001\u0019SNdun^*veJ|w-\u0019;fI\u0015DH/\u001a8tS>tG\u0003BA*\u0005\u0013Ba!a1D\u0001\u0004a\u0017!F5t'V\u0014(o\\4bi\u0016$S\r\u001f;f]NLwN\u001c\u000b\u0005\u0003'\u0012y\u0005\u0003\u0004\u0002D\u0012\u0003\r\u0001\\\u0001#SN,f.[2pI\u0016LE-\u001a8uS\u001aLWM]*uCJ$H%\u001a=uK:\u001c\u0018n\u001c8\u0015\t\u0005M#Q\u000b\u0005\u0007\u0003\u0007,\u0005\u0019\u00017\u0002C%\u001cXK\\5d_\u0012,\u0017\nZ3oi&4\u0017.\u001a:QCJ$H%\u001a=uK:\u001c\u0018n\u001c8\u0015\t\u0005M#1\f\u0005\u0007\u0003\u00074\u0005\u0019\u00017\u0002?%\u001c\u0018\nZ3oi&4\u0017.\u001a:JO:|'/\u00192mK\u0012*\u0007\u0010^3og&|g\u000e\u0006\u0003\u0002T\t\u0005\u0004BBAb\u000f\u0002\u0007A.\u0001\u000bjg6K'O]8sK\u0012$S\r\u001f;f]NLwN\u001c\u000b\u0005\u0003'\u00129\u0007\u0003\u0004\u0002D\"\u0003\r\u0001\\\u0001\u0012SNdun^3sI\u0015DH/\u001a8tS>tG\u0003BA*\u0005[Ba!a1J\u0001\u0004a\u0017!E5t+B\u0004XM\u001d\u0013fqR,gn]5p]R!\u00111\u000bB:\u0011\u0019\t\u0019M\u0013a\u0001Y\u0006)\u0012n\u001d+ji2,7)Y:fI\u0015DH/\u001a8tS>tG\u0003BA*\u0005sBa!a1L\u0001\u0004a\u0017!\u0005;p\u0019><XM\u001d\u0013fqR,gn]5p]R\u0019AMa \t\r\u0005\rG\n1\u0001m\u0003E!x.\u00169qKJ$S\r\u001f;f]NLwN\u001c\u000b\u0004I\n\u0015\u0005BBAb\u001b\u0002\u0007A.A\u000bu_RKG\u000f\\3DCN,G%\u001a=uK:\u001c\u0018n\u001c8\u0015\u0007\u0011\u0014Y\t\u0003\u0004\u0002D:\u0003\r\u0001\\\u0001\u0012O\u0016$H+\u001f9fI\u0015DH/\u001a8tS>tG\u0003BA\u001b\u0005#Ca!a1P\u0001\u0004a\u0017!G4fi:+X.\u001a:jGZ\u000bG.^3%Kb$XM\\:j_:$B!!\u000e\u0003\u0018\"1\u00111\u0019)A\u00021\f1dZ3u\t&\u0014Xm\u0019;j_:\fG.\u001b;zI\u0015DH/\u001a8tS>tG\u0003BA \u0005;Ca!a1R\u0001\u0004a\u0017A\u0006:fm\u0016\u00148/\u001a\"zi\u0016\u001cH%\u001a=uK:\u001c\u0018n\u001c8\u0015\u0007\u0011\u0014\u0019\u000b\u0003\u0004\u0002DJ\u0003\r\u0001\\\u0001\u0013Q\u0006\u001c\bnQ8eK\u0012*\u0007\u0010^3og&|g\u000e\u0006\u0003\u00024\t%\u0006BBAb'\u0002\u0007A.\u0001\tfcV\fGn\u001d\u0013fqR,gn]5p]R!!q\u0016BZ)\u0011\t\u0019F!-\t\u0013\u0005\u001dF+!AA\u0002\u0005%\u0006BBAb)\u0002\u0007A\u000e")
public final class RichChar
implements IntegralProxy<Object> {
    private final char self;

    public static boolean equals$extension(char c, Object object) {
        return RichChar$.MODULE$.equals$extension(c, object);
    }

    public static int hashCode$extension(char c) {
        return RichChar$.MODULE$.hashCode$extension(c);
    }

    public static char reverseBytes$extension(char c) {
        return RichChar$.MODULE$.reverseBytes$extension(c);
    }

    public static byte getDirectionality$extension(char c) {
        return RichChar$.MODULE$.getDirectionality$extension(c);
    }

    public static int getNumericValue$extension(char c) {
        return RichChar$.MODULE$.getNumericValue$extension(c);
    }

    public static int getType$extension(char c) {
        return RichChar$.MODULE$.getType$extension(c);
    }

    public static char toTitleCase$extension(char c) {
        return RichChar$.MODULE$.toTitleCase$extension(c);
    }

    public static char toUpper$extension(char c) {
        return RichChar$.MODULE$.toUpper$extension(c);
    }

    public static char toLower$extension(char c) {
        return RichChar$.MODULE$.toLower$extension(c);
    }

    public static boolean isTitleCase$extension(char c) {
        return RichChar$.MODULE$.isTitleCase$extension(c);
    }

    public static boolean isUpper$extension(char c) {
        return RichChar$.MODULE$.isUpper$extension(c);
    }

    public static boolean isLower$extension(char c) {
        return RichChar$.MODULE$.isLower$extension(c);
    }

    public static boolean isMirrored$extension(char c) {
        return RichChar$.MODULE$.isMirrored$extension(c);
    }

    public static boolean isIdentifierIgnorable$extension(char c) {
        return RichChar$.MODULE$.isIdentifierIgnorable$extension(c);
    }

    public static boolean isUnicodeIdentifierPart$extension(char c) {
        return RichChar$.MODULE$.isUnicodeIdentifierPart$extension(c);
    }

    public static boolean isUnicodeIdentifierStart$extension(char c) {
        return RichChar$.MODULE$.isUnicodeIdentifierStart$extension(c);
    }

    public static boolean isSurrogate$extension(char c) {
        return RichChar$.MODULE$.isSurrogate$extension(c);
    }

    public static boolean isLowSurrogate$extension(char c) {
        return RichChar$.MODULE$.isLowSurrogate$extension(c);
    }

    public static boolean isHighSurrogate$extension(char c) {
        return RichChar$.MODULE$.isHighSurrogate$extension(c);
    }

    public static boolean isSpaceChar$extension(char c) {
        return RichChar$.MODULE$.isSpaceChar$extension(c);
    }

    public static boolean isWhitespace$extension(char c) {
        return RichChar$.MODULE$.isWhitespace$extension(c);
    }

    public static boolean isLetterOrDigit$extension(char c) {
        return RichChar$.MODULE$.isLetterOrDigit$extension(c);
    }

    public static boolean isLetter$extension(char c) {
        return RichChar$.MODULE$.isLetter$extension(c);
    }

    public static boolean isDigit$extension(char c) {
        return RichChar$.MODULE$.isDigit$extension(c);
    }

    public static boolean isControl$extension(char c) {
        return RichChar$.MODULE$.isControl$extension(c);
    }

    public static int asDigit$extension(char c) {
        return RichChar$.MODULE$.asDigit$extension(c);
    }

    public static int signum$extension(char c) {
        return RichChar$.MODULE$.signum$extension(c);
    }

    public static char min$extension(char c, char c2) {
        return RichChar$.MODULE$.min$extension(c, c2);
    }

    public static char max$extension(char c, char c2) {
        return RichChar$.MODULE$.max$extension(c, c2);
    }

    public static char abs$extension(char c) {
        return RichChar$.MODULE$.abs$extension(c);
    }

    public static boolean isValidChar$extension(char c) {
        return RichChar$.MODULE$.isValidChar$extension(c);
    }

    public static short shortValue$extension(char c) {
        return RichChar$.MODULE$.shortValue$extension(c);
    }

    public static byte byteValue$extension(char c) {
        return RichChar$.MODULE$.byteValue$extension(c);
    }

    public static int intValue$extension(char c) {
        return RichChar$.MODULE$.intValue$extension(c);
    }

    public static long longValue$extension(char c) {
        return RichChar$.MODULE$.longValue$extension(c);
    }

    public static float floatValue$extension(char c) {
        return RichChar$.MODULE$.floatValue$extension(c);
    }

    public static double doubleValue$extension(char c) {
        return RichChar$.MODULE$.doubleValue$extension(c);
    }

    public static Ordering$Char$ ord$extension(char c) {
        return RichChar$.MODULE$.ord$extension(c);
    }

    public static Numeric$CharIsIntegral$ num$extension(char c) {
        return RichChar$.MODULE$.num$extension(c);
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
    public boolean isValidByte() {
        return ScalaNumericAnyConversions.isValidByte$(this);
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
    public int unifiedPrimitiveHashcode() {
        return ScalaNumericAnyConversions.unifiedPrimitiveHashcode$(this);
    }

    @Override
    public boolean unifiedPrimitiveEquals(Object x) {
        return ScalaNumericAnyConversions.unifiedPrimitiveEquals$(this, x);
    }

    @Override
    public char self() {
        return this.self;
    }

    public Numeric$CharIsIntegral$ num() {
        return RichChar$.MODULE$.num$extension(this.self());
    }

    public Ordering$Char$ ord() {
        return RichChar$.MODULE$.ord$extension(this.self());
    }

    @Override
    public double doubleValue() {
        return RichChar$.MODULE$.doubleValue$extension(this.self());
    }

    @Override
    public float floatValue() {
        return RichChar$.MODULE$.floatValue$extension(this.self());
    }

    @Override
    public long longValue() {
        return RichChar$.MODULE$.longValue$extension(this.self());
    }

    @Override
    public int intValue() {
        return RichChar$.MODULE$.intValue$extension(this.self());
    }

    @Override
    public byte byteValue() {
        return RichChar$.MODULE$.byteValue$extension(this.self());
    }

    @Override
    public short shortValue() {
        return RichChar$.MODULE$.shortValue$extension(this.self());
    }

    @Override
    public boolean isValidChar() {
        return RichChar$.MODULE$.isValidChar$extension(this.self());
    }

    @Override
    public char abs() {
        return RichChar$.MODULE$.abs$extension(this.self());
    }

    @Override
    public char max(char that) {
        return RichChar$.MODULE$.max$extension(this.self(), that);
    }

    @Override
    public char min(char that) {
        return RichChar$.MODULE$.min$extension(this.self(), that);
    }

    @Override
    public int signum() {
        return RichChar$.MODULE$.signum$extension(this.self());
    }

    public int asDigit() {
        return RichChar$.MODULE$.asDigit$extension(this.self());
    }

    public boolean isControl() {
        return RichChar$.MODULE$.isControl$extension(this.self());
    }

    public boolean isDigit() {
        return RichChar$.MODULE$.isDigit$extension(this.self());
    }

    public boolean isLetter() {
        return RichChar$.MODULE$.isLetter$extension(this.self());
    }

    public boolean isLetterOrDigit() {
        return RichChar$.MODULE$.isLetterOrDigit$extension(this.self());
    }

    public boolean isWhitespace() {
        return RichChar$.MODULE$.isWhitespace$extension(this.self());
    }

    public boolean isSpaceChar() {
        return RichChar$.MODULE$.isSpaceChar$extension(this.self());
    }

    public boolean isHighSurrogate() {
        return RichChar$.MODULE$.isHighSurrogate$extension(this.self());
    }

    public boolean isLowSurrogate() {
        return RichChar$.MODULE$.isLowSurrogate$extension(this.self());
    }

    public boolean isSurrogate() {
        return RichChar$.MODULE$.isSurrogate$extension(this.self());
    }

    public boolean isUnicodeIdentifierStart() {
        return RichChar$.MODULE$.isUnicodeIdentifierStart$extension(this.self());
    }

    public boolean isUnicodeIdentifierPart() {
        return RichChar$.MODULE$.isUnicodeIdentifierPart$extension(this.self());
    }

    public boolean isIdentifierIgnorable() {
        return RichChar$.MODULE$.isIdentifierIgnorable$extension(this.self());
    }

    public boolean isMirrored() {
        return RichChar$.MODULE$.isMirrored$extension(this.self());
    }

    public boolean isLower() {
        return RichChar$.MODULE$.isLower$extension(this.self());
    }

    public boolean isUpper() {
        return RichChar$.MODULE$.isUpper$extension(this.self());
    }

    public boolean isTitleCase() {
        return RichChar$.MODULE$.isTitleCase$extension(this.self());
    }

    public char toLower() {
        return RichChar$.MODULE$.toLower$extension(this.self());
    }

    public char toUpper() {
        return RichChar$.MODULE$.toUpper$extension(this.self());
    }

    public char toTitleCase() {
        return RichChar$.MODULE$.toTitleCase$extension(this.self());
    }

    public int getType() {
        return RichChar$.MODULE$.getType$extension(this.self());
    }

    public int getNumericValue() {
        return RichChar$.MODULE$.getNumericValue$extension(this.self());
    }

    public byte getDirectionality() {
        return RichChar$.MODULE$.getDirectionality$extension(this.self());
    }

    public char reverseBytes() {
        return RichChar$.MODULE$.reverseBytes$extension(this.self());
    }

    @Override
    public int hashCode() {
        return RichChar$.MODULE$.hashCode$extension(this.self());
    }

    @Override
    public boolean equals(Object x$1) {
        return RichChar$.MODULE$.equals$extension(this.self(), x$1);
    }

    public RichChar(char self) {
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

