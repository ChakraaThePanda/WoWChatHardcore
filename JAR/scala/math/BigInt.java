/*
 * Decompiled with CFR 0.152.
 */
package scala.math;

import java.math.BigInteger;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.immutable.NumericRange;
import scala.collection.immutable.Range$BigInt$;
import scala.math.BigDecimal;
import scala.math.BigInt$;
import scala.math.Ordered;
import scala.math.ScalaNumber;
import scala.math.ScalaNumericAnyConversions;
import scala.math.ScalaNumericConversions;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.Statics;
import scala.util.Random;

@ScalaSignature(bytes="\u0006\u0001\r\u0005s!\u0002-Z\u0011\u0003qf!\u00021Z\u0011\u0003\t\u0007\"B5\u0002\t\u0003Q\u0007bB6\u0002\u0005\u0004%I\u0001\u001c\u0005\u0007a\u0006\u0001\u000b\u0011B7\t\u000fE\f!\u0019!C\u0005Y\"1!/\u0001Q\u0001\n5Dqa]\u0001C\u0002\u0013%A\u000fC\u0004\u0003H\u0006\u0001\u000b\u0011B;\t\u0013\t%\u0017A1A\u0005\n\u0005%\u0001\u0002\u0003Bf\u0003\u0001\u0006I!a\u0003\t\u000f\t5\u0017\u0001\"\u0001\u0003P\"9!QZ\u0001\u0005\u0002\tU\u0007b\u0002Bg\u0003\u0011\u0005!1\u001c\u0005\b\u0005\u001b\fA\u0011\u0001Bq\u0011\u001d\u0011i-\u0001C\u0001\u0005SDqA!4\u0002\t\u0003\u0019\t\u0001C\u0004\u0003N\u0006!\ta!\u0003\t\u000f\t5\u0017\u0001\"\u0001\u0004\u000e!9!QZ\u0001\u0005\u0002\rM\u0001bBB\f\u0003\u0011\u00051\u0011\u0004\u0005\b\u0007?\tA1AB\u0011\u0011\u001d\u0019)#\u0001C\u0002\u0007OAqaa\u000b\u0002\t\u0007\u0019i\u0003C\u0005\u00042\u0005\t\t\u0011\"\u0003\u00044\u0019!\u0001-\u0017\u0002z\u0011)\t9!\u0007BC\u0002\u0013\u0005\u0011\u0011\u0002\u0005\u000b\u00033I\"\u0011!Q\u0001\n\u0005-\u0001BB5\u001a\t\u0003\tY\u0002C\u0004\u0002 e!\t%!\t\t\u000f\u0005\r\u0012\u0004\"\u0011\u0002&!9\u0011qG\r\u0005B\u0005e\u0002bBA\u001e3\u0011\u0005\u0013\u0011\b\u0005\b\u0003{IB\u0011IA\u001d\u0011\u001d\ty$\u0007C!\u0003sAq!!\u0011\u001a\t\u0003\tI\u0004C\u0004\u0002De!\t!!\u000f\t\u000f\u0005\u0015\u0013\u0004\"\u0001\u0002:!9\u0011qI\r\u0005\n\u0005e\u0002bBA%3\u0011\u0005\u00111\n\u0005\b\u0003\u001bJB\u0011AA(\u0011\u001d\t\u0019#\u0007C\u0001\u0003#Bq!!\u0016\u001a\t\u0003\t9\u0006C\u0004\u0002\\e!\t!!\u0018\t\u000f\u0005\u0005\u0014\u0004\"\u0001\u0002d!9\u0011qM\r\u0005\u0002\u0005%\u0004bBA73\u0011\u0005\u0011q\u000e\u0005\b\u0003gJB\u0011AA;\u0011\u001d\tI(\u0007C\u0001\u0003wBq!!\"\u001a\t\u0003\t9\tC\u0004\u0002\u000ef!\t!a$\t\u000f\u0005M\u0015\u0004\"\u0001\u0002\u0016\"9\u0011\u0011T\r\u0005\u0002\u0005m\u0005bBAP3\u0011\u0005\u0011\u0011\u0015\u0005\b\u0003KKB\u0011AAT\u0011\u001d\tY+\u0007C\u0001\u0003[Cq!!-\u001a\t\u0003\t\u0019\fC\u0004\u00028f!\t!!/\t\u000f\u0005u\u0016\u0004\"\u0001\u0002@\"9\u00111Y\r\u0005\u0002\u0005\u0015\u0007bBAf3\u0011\u0005\u0011Q\u001a\u0005\b\u0003+LB\u0011AAl\u0011\u001d\tY.\u0007C\u0001\u0003;Dq!a8\u001a\t\u0003\ti\u000e\u0003\u0004\u0002bf!\t\u0001\u001c\u0005\b\u0003GLB\u0011AAo\u0011\u001d\t)/\u0007C\u0001\u0003ODq!a;\u001a\t\u0003\ti\u000fC\u0004\u0002rf!\t!a=\t\u000f\u0005]\u0018\u0004\"\u0001\u0002z\"1\u0011Q`\r\u0005\u00021Da!a@\u001a\t\u0003a\u0007B\u0002B\u00013\u0011\u0005A\u000eC\u0004\u0003\u0004e!\tA!\u0002\t\u000f\t-\u0011\u0004\"\u0011\u0003\u000e!9!QC\r\u0005B\t]\u0001b\u0002B\u00103\u0011\u0005!\u0011\u0005\u0005\b\u0005SIB\u0011AA\u0011\u0011\u001d\u0011Y#\u0007C\u0001\u0005[AqA!\u000e\u001a\t\u0003\u00119\u0004C\u0004\u0003@e!\tA!\u0011\t\u000f\t%\u0013\u0004\"\u0001\u0003L!I!\u0011P\r\u0012\u0002\u0013\u0005!1\u0010\u0005\b\u0005#KB\u0011\u0001BJ\u0011%\u0011y*GI\u0001\n\u0003\u0011Y\bC\u0004\u0003\"f!\tEa)\t\u000f\t\u0005\u0016\u0004\"\u0001\u0003<\"9!\u0011Y\r\u0005\u0002\t\r\u0017A\u0002\"jO&sGO\u0003\u0002[7\u0006!Q.\u0019;i\u0015\u0005a\u0016!B:dC2\f7\u0001\u0001\t\u0003?\u0006i\u0011!\u0017\u0002\u0007\u0005&<\u0017J\u001c;\u0014\u0007\u0005\u0011g\r\u0005\u0002dI6\t1,\u0003\u0002f7\n1\u0011I\\=SK\u001a\u0004\"aY4\n\u0005!\\&\u0001D*fe&\fG.\u001b>bE2,\u0017A\u0002\u001fj]&$h\bF\u0001_\u0003%i\u0017N\\\"bG\",G-F\u0001n!\t\u0019g.\u0003\u0002p7\n\u0019\u0011J\u001c;\u0002\u00155LgnQ1dQ\u0016$\u0007%A\u0005nCb\u001c\u0015m\u00195fI\u0006QQ.\u0019=DC\u000eDW\r\u001a\u0011\u0002\u000b\r\f7\r[3\u0016\u0003U\u00042a\u0019<y\u0013\t98LA\u0003BeJ\f\u0017\u0010\u0005\u0002`3M1\u0011D_?g\u0003\u0003\u0001\"aX>\n\u0005qL&aC*dC2\fg*^7cKJ\u0004\"a\u0018@\n\u0005}L&aF*dC2\fg*^7fe&\u001c7i\u001c8wKJ\u001c\u0018n\u001c8t!\u0011y\u00161\u0001=\n\u0007\u0005\u0015\u0011LA\u0004Pe\u0012,'/\u001a3\u0002\u0015\tLw-\u00138uK\u001e,'/\u0006\u0002\u0002\fA!\u0011QBA\u000b\u001b\t\tyAC\u0002[\u0003#Q!!a\u0005\u0002\t)\fg/Y\u0005\u0005\u0003/\tyA\u0001\u0006CS\u001eLe\u000e^3hKJ\f1BY5h\u0013:$XmZ3sAQ\u0019\u00010!\b\t\u000f\u0005\u001dA\u00041\u0001\u0002\f\u0005A\u0001.Y:i\u0007>$W\rF\u0001n\u0003\u0019)\u0017/^1mgR!\u0011qEA\u0017!\r\u0019\u0017\u0011F\u0005\u0004\u0003WY&a\u0002\"p_2,\u0017M\u001c\u0005\b\u0003_q\u0002\u0019AA\u0019\u0003\u0011!\b.\u0019;\u0011\u0007\r\f\u0019$C\u0002\u00026m\u00131!\u00118z\u0003-I7OV1mS\u0012\u0014\u0015\u0010^3\u0016\u0005\u0005\u001d\u0012\u0001D5t-\u0006d\u0017\u000eZ*i_J$\u0018aC5t-\u0006d\u0017\u000eZ\"iCJ\f!\"[:WC2LG-\u00138u\u0003-I7OV1mS\u0012duN\\4\u0002\u0019%\u001ch+\u00197jI\u001acw.\u0019;\u0002\u001b%\u001ch+\u00197jI\u0012{WO\u00197f\u0003E\u0011\u0017\u000e\u001e'f]\u001e$\bn\u0014<fe\u001adwn^\u0001\bSN<\u0006n\u001c7f)\t\t9#\u0001\u0006v]\u0012,'\u000f\\=j]\u001e$\"!a\u0003\u0015\t\u0005\u001d\u00121\u000b\u0005\u0007\u0003_I\u0003\u0019\u0001=\u0002\u000f\r|W\u000e]1sKR\u0019Q.!\u0017\t\r\u0005=\"\u00061\u0001y\u0003\u0015!\u0003\u000f\\;t)\rA\u0018q\f\u0005\u0007\u0003_Y\u0003\u0019\u0001=\u0002\r\u0011j\u0017N\\;t)\rA\u0018Q\r\u0005\u0007\u0003_a\u0003\u0019\u0001=\u0002\r\u0011\"\u0018.\\3t)\rA\u00181\u000e\u0005\u0007\u0003_i\u0003\u0019\u0001=\u0002\t\u0011\"\u0017N\u001e\u000b\u0004q\u0006E\u0004BBA\u0018]\u0001\u0007\u00010\u0001\u0005%a\u0016\u00148-\u001a8u)\rA\u0018q\u000f\u0005\u0007\u0003_y\u0003\u0019\u0001=\u0002\u0019\u0011\"\u0017N\u001e\u0013qKJ\u001cWM\u001c;\u0015\t\u0005u\u00141\u0011\t\u0006G\u0006}\u0004\u0010_\u0005\u0004\u0003\u0003[&A\u0002+va2,'\u0007\u0003\u0004\u00020A\u0002\r\u0001_\u0001\u000bI1,7o\u001d\u0013mKN\u001cHc\u0001=\u0002\n\"1\u00111R\u0019A\u00025\f\u0011A\\\u0001\u0011I\u001d\u0014X-\u0019;fe\u0012:'/Z1uKJ$2\u0001_AI\u0011\u0019\tYI\ra\u0001[\u0006!A%Y7q)\rA\u0018q\u0013\u0005\u0007\u0003_\u0019\u0004\u0019\u0001=\u0002\t\u0011\u0012\u0017M\u001d\u000b\u0004q\u0006u\u0005BBA\u0018i\u0001\u0007\u00010A\u0002%kB$2\u0001_AR\u0011\u0019\ty#\u000ea\u0001q\u0006QA%Y7qIQLG\u000eZ3\u0015\u0007a\fI\u000b\u0003\u0004\u00020Y\u0002\r\u0001_\u0001\u0004O\u000e$Gc\u0001=\u00020\"1\u0011qF\u001cA\u0002a\f1!\\8e)\rA\u0018Q\u0017\u0005\u0007\u0003_A\u0004\u0019\u0001=\u0002\u00075Lg\u000eF\u0002y\u0003wCa!a\f:\u0001\u0004A\u0018aA7bqR\u0019\u00010!1\t\r\u0005=\"\b1\u0001y\u0003\r\u0001xn\u001e\u000b\u0004q\u0006\u001d\u0007BBAew\u0001\u0007Q.A\u0002fqB\fa!\\8e!><H#\u0002=\u0002P\u0006E\u0007BBAey\u0001\u0007\u0001\u0010\u0003\u0004\u0002Tr\u0002\r\u0001_\u0001\u0002[\u0006QQn\u001c3J]Z,'o]3\u0015\u0007a\fI\u000e\u0003\u0004\u0002Tv\u0002\r\u0001_\u0001\rk:\f'/_0%[&tWo]\u000b\u0002q\u0006\u0019\u0011MY:\u0002\rMLwM\\;n\u00031)h.\u0019:z?\u0012\"\u0018\u000e\u001c3f\u0003\u001d!Xm\u001d;CSR$B!a\n\u0002j\"1\u00111\u0012\"A\u00025\faa]3u\u0005&$Hc\u0001=\u0002p\"1\u00111R\"A\u00025\f\u0001b\u00197fCJ\u0014\u0015\u000e\u001e\u000b\u0004q\u0006U\bBBAF\t\u0002\u0007Q.A\u0004gY&\u0004()\u001b;\u0015\u0007a\fY\u0010\u0003\u0004\u0002\f\u0016\u0003\r!\\\u0001\rY><Xm\u001d;TKR\u0014\u0015\u000e^\u0001\nE&$H*\u001a8hi\"\f\u0001BY5u\u0007>,h\u000e^\u0001\u0010SN\u0004&o\u001c2bE2,\u0007K]5nKR!\u0011q\u0005B\u0004\u0011\u0019\u0011I!\u0013a\u0001[\u0006I1-\u001a:uC&tG/_\u0001\nEf$XMV1mk\u0016$\"Aa\u0004\u0011\u0007\r\u0014\t\"C\u0002\u0003\u0014m\u0013AAQ=uK\u0006Q1\u000f[8siZ\u000bG.^3\u0015\u0005\te\u0001cA2\u0003\u001c%\u0019!QD.\u0003\u000bMCwN\u001d;\u0002\u0013\rD\u0017M\u001d,bYV,WC\u0001B\u0012!\r\u0019'QE\u0005\u0004\u0005OY&\u0001B\"iCJ\f\u0001\"\u001b8u-\u0006dW/Z\u0001\nY>twMV1mk\u0016$\"Aa\f\u0011\u0007\r\u0014\t$C\u0002\u00034m\u0013A\u0001T8oO\u0006Qa\r\\8biZ\u000bG.^3\u0015\u0005\te\u0002cA2\u0003<%\u0019!QH.\u0003\u000b\u0019cw.\u0019;\u0002\u0017\u0011|WO\u00197f-\u0006dW/\u001a\u000b\u0003\u0005\u0007\u00022a\u0019B#\u0013\r\u00119e\u0017\u0002\u0007\t>,(\r\\3\u0002\u000bUtG/\u001b7\u0015\r\t5#\u0011\u000fB;!\u0019\u0011yEa\u0018\u0003f9!!\u0011\u000bB.\u001b\t\u0011\u0019F\u0003\u0003\u0003V\t]\u0013!C5n[V$\u0018M\u00197f\u0015\r\u0011IfW\u0001\u000bG>dG.Z2uS>t\u0017\u0002\u0002B/\u0005'\nABT;nKJL7MU1oO\u0016LAA!\u0019\u0003d\tIQ\t_2mkNLg/\u001a\u0006\u0005\u0005;\u0012\u0019\u0006\u0005\u0003\u0003h\t5dbA2\u0003j%\u0019!1N.\u0002\u000fA\f7m[1hK&\u0019\u0001Ma\u001c\u000b\u0007\t-4\f\u0003\u0004\u0003tE\u0003\r\u0001_\u0001\u0004K:$\u0007\u0002\u0003B<#B\u0005\t\u0019\u0001=\u0002\tM$X\r]\u0001\u0010k:$\u0018\u000e\u001c\u0013eK\u001a\fW\u000f\u001c;%eU\u0011!Q\u0010\u0016\u0004q\n}4F\u0001BA!\u0011\u0011\u0019I!$\u000e\u0005\t\u0015%\u0002\u0002BD\u0005\u0013\u000b\u0011\"\u001e8dQ\u0016\u001c7.\u001a3\u000b\u0007\t-5,\u0001\u0006b]:|G/\u0019;j_:LAAa$\u0003\u0006\n\tRO\\2iK\u000e\\W\r\u001a,be&\fgnY3\u0002\u0005Q|GC\u0002BK\u00057\u0013i\n\u0005\u0004\u0003P\t]%QM\u0005\u0005\u00053\u0013\u0019GA\u0005J]\u000edWo]5wK\"1!1O*A\u0002aD\u0001Ba\u001eT!\u0003\u0005\r\u0001_\u0001\ri>$C-\u001a4bk2$HEM\u0001\ti>\u001cFO]5oOR\u0011!Q\u0015\t\u0005\u0005O\u0013)L\u0004\u0003\u0003*\nE\u0006c\u0001BV76\u0011!Q\u0016\u0006\u0004\u0005_k\u0016A\u0002\u001fs_>$h(C\u0002\u00034n\u000ba\u0001\u0015:fI\u00164\u0017\u0002\u0002B\\\u0005s\u0013aa\u0015;sS:<'b\u0001BZ7R!!Q\u0015B_\u0011\u0019\u0011yL\u0016a\u0001[\u0006)!/\u00193jq\u0006YAo\u001c\"zi\u0016\f%O]1z+\t\u0011)\r\u0005\u0003dm\n=\u0011AB2bG\",\u0007%\u0001\u0005nS:,8o\u00148f\u0003%i\u0017N\\;t\u001f:,\u0007%A\u0003baBd\u0017\u0010F\u0002y\u0005#DaAa5\f\u0001\u0004i\u0017!A5\u0015\u0007a\u00149\u000eC\u0004\u0003Z2\u0001\rAa\f\u0002\u00031$2\u0001\u001fBo\u0011\u001d\u0011y.\u0004a\u0001\u0005\u000b\f\u0011\u0001\u001f\u000b\u0006q\n\r(Q\u001d\u0005\u0007\u0003Ct\u0001\u0019A7\t\u000f\t\u001dh\u00021\u0001\u0003F\u0006IQ.Y4oSR,H-\u001a\u000b\bq\n-(q\u001eBy\u0011\u0019\u0011io\u0004a\u0001[\u0006I!-\u001b;mK:<G\u000f\u001b\u0005\u0007\u0005\u0013y\u0001\u0019A7\t\u000f\tMx\u00021\u0001\u0003v\u0006\u0019!O\u001c3\u0011\t\t](Q`\u0007\u0003\u0005sT1Aa?\\\u0003\u0011)H/\u001b7\n\t\t}(\u0011 \u0002\u0007%\u0006tGm\\7\u0015\u000ba\u001c\u0019aa\u0002\t\r\r\u0015\u0001\u00031\u0001n\u0003\u001dqW/\u001c2jiNDqAa=\u0011\u0001\u0004\u0011)\u0010F\u0002y\u0007\u0017AqAa8\u0012\u0001\u0004\u0011)\u000bF\u0003y\u0007\u001f\u0019\t\u0002C\u0004\u0003`J\u0001\rA!*\t\r\t}&\u00031\u0001n)\rA8Q\u0003\u0005\b\u0005?\u001c\u0002\u0019AA\u0006\u00035\u0001(o\u001c2bE2,\u0007K]5nKR)\u0001pa\u0007\u0004\u001e!1\u0011q \u000bA\u00025DqAa=\u0015\u0001\u0004\u0011)0\u0001\u0006j]R\u0014$-[4J]R$2\u0001_B\u0012\u0011\u0019\u0011\u0019.\u0006a\u0001[\u0006YAn\u001c8he\tLw-\u00138u)\rA8\u0011\u0006\u0005\b\u000534\u0002\u0019\u0001B\u0018\u0003UQ\u0017M^1CS\u001eLe\u000e^3hKJ\u0014$-[4J]R$2\u0001_B\u0018\u0011\u001d\u0011yn\u0006a\u0001\u0003\u0017\t1B]3bIJ+7o\u001c7wKR\u00111Q\u0007\t\u0005\u0007o\u0019i$\u0004\u0002\u0004:)!11HA\t\u0003\u0011a\u0017M\\4\n\t\r}2\u0011\b\u0002\u0007\u001f\nTWm\u0019;")
public final class BigInt
extends ScalaNumber
implements ScalaNumericConversions,
Serializable,
Ordered<BigInt> {
    private final BigInteger bigInteger;

    public static BigInt javaBigInteger2bigInt(BigInteger bigInteger) {
        return BigInt$.MODULE$.javaBigInteger2bigInt(bigInteger);
    }

    public static BigInt long2bigInt(long l) {
        return BigInt$.MODULE$.long2bigInt(l);
    }

    public static BigInt int2bigInt(int n) {
        return BigInt$.MODULE$.int2bigInt(n);
    }

    public static BigInt probablePrime(int n, Random random) {
        return BigInt$.MODULE$.probablePrime(n, random);
    }

    public static BigInt apply(BigInteger bigInteger) {
        return BigInt$.MODULE$.apply(bigInteger);
    }

    public static BigInt apply(String string, int n) {
        return BigInt$.MODULE$.apply(string, n);
    }

    public static BigInt apply(String string) {
        return BigInt$.MODULE$.apply(string);
    }

    public static BigInt apply(int n, Random random) {
        return BigInt$.MODULE$.apply(n, random);
    }

    public static BigInt apply(int n, int n2, Random random) {
        return BigInt$.MODULE$.apply(n, n2, random);
    }

    public static BigInt apply(int n, byte[] byArray) {
        return BigInt$.MODULE$.apply(n, byArray);
    }

    public static BigInt apply(byte[] byArray) {
        return BigInt$.MODULE$.apply(byArray);
    }

    public static BigInt apply(long l) {
        return BigInt$.MODULE$.apply(l);
    }

    public static BigInt apply(int n) {
        return BigInt$.MODULE$.apply(n);
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

    public BigInteger bigInteger() {
        return this.bigInteger;
    }

    public int hashCode() {
        if (this.isValidLong()) {
            return this.unifiedPrimitiveHashcode();
        }
        return Statics.anyHash(this.bigInteger());
    }

    public boolean equals(Object that) {
        boolean bl;
        if (that instanceof BigInt) {
            BigInt bigInt = (BigInt)that;
            bl = this.equals(bigInt);
        } else if (that instanceof BigDecimal) {
            bl = ((BigDecimal)that).equals(this);
        } else if (that instanceof Double) {
            double d = BoxesRunTime.unboxToDouble(that);
            bl = this.isValidDouble() && this.toDouble() == d;
        } else if (that instanceof Float) {
            float f = BoxesRunTime.unboxToFloat(that);
            bl = this.isValidFloat() && this.toFloat() == f;
        } else {
            bl = this.isValidLong() && this.unifiedPrimitiveEquals(that);
        }
        return bl;
    }

    @Override
    public boolean isValidByte() {
        return this.$greater$eq(BigInt$.MODULE$.int2bigInt(-128)) && this.$less$eq(BigInt$.MODULE$.int2bigInt(127));
    }

    @Override
    public boolean isValidShort() {
        return this.$greater$eq(BigInt$.MODULE$.int2bigInt(Short.MIN_VALUE)) && this.$less$eq(BigInt$.MODULE$.int2bigInt(Short.MAX_VALUE));
    }

    @Override
    public boolean isValidChar() {
        return this.$greater$eq(BigInt$.MODULE$.int2bigInt(0)) && this.$less$eq(BigInt$.MODULE$.int2bigInt(65535));
    }

    @Override
    public boolean isValidInt() {
        return this.$greater$eq(BigInt$.MODULE$.int2bigInt(Integer.MIN_VALUE)) && this.$less$eq(BigInt$.MODULE$.int2bigInt(Integer.MAX_VALUE));
    }

    public boolean isValidLong() {
        return this.$greater$eq(BigInt$.MODULE$.long2bigInt(Long.MIN_VALUE)) && this.$less$eq(BigInt$.MODULE$.long2bigInt(Long.MAX_VALUE));
    }

    public boolean isValidFloat() {
        block5: {
            block4: {
                int bitLen = this.bitLength();
                if (bitLen <= 24) break block4;
                int lowest = this.lowestSetBit();
                if (!(bitLen <= 128 && lowest >= bitLen - 24 && lowest < 128)) break block5;
            }
            if (!this.bitLengthOverflow()) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidDouble() {
        block5: {
            block4: {
                int bitLen = this.bitLength();
                if (bitLen <= 53) break block4;
                int lowest = this.lowestSetBit();
                if (!(bitLen <= 1024 && lowest >= bitLen - 53 && lowest < 1024)) break block5;
            }
            if (!this.bitLengthOverflow()) {
                return true;
            }
        }
        return false;
    }

    private boolean bitLengthOverflow() {
        BigInteger shifted = this.bigInteger().shiftRight(Integer.MAX_VALUE);
        return shifted.signum() != 0 && !shifted.equals(BigInt$.MODULE$.scala$math$BigInt$$minusOne());
    }

    @Override
    public boolean isWhole() {
        return true;
    }

    @Override
    public BigInteger underlying() {
        return this.bigInteger();
    }

    public boolean equals(BigInt that) {
        return this.compare(that) == 0;
    }

    @Override
    public int compare(BigInt that) {
        return this.bigInteger().compareTo(that.bigInteger());
    }

    public BigInt $plus(BigInt that) {
        return new BigInt(this.bigInteger().add(that.bigInteger()));
    }

    public BigInt $minus(BigInt that) {
        return new BigInt(this.bigInteger().subtract(that.bigInteger()));
    }

    public BigInt $times(BigInt that) {
        return new BigInt(this.bigInteger().multiply(that.bigInteger()));
    }

    public BigInt $div(BigInt that) {
        return new BigInt(this.bigInteger().divide(that.bigInteger()));
    }

    public BigInt $percent(BigInt that) {
        return new BigInt(this.bigInteger().remainder(that.bigInteger()));
    }

    public Tuple2<BigInt, BigInt> $div$percent(BigInt that) {
        BigInteger[] dr = this.bigInteger().divideAndRemainder(that.bigInteger());
        return new Tuple2<BigInt, BigInt>(new BigInt(dr[0]), new BigInt(dr[1]));
    }

    public BigInt $less$less(int n) {
        return new BigInt(this.bigInteger().shiftLeft(n));
    }

    public BigInt $greater$greater(int n) {
        return new BigInt(this.bigInteger().shiftRight(n));
    }

    public BigInt $amp(BigInt that) {
        return new BigInt(this.bigInteger().and(that.bigInteger()));
    }

    public BigInt $bar(BigInt that) {
        return new BigInt(this.bigInteger().or(that.bigInteger()));
    }

    public BigInt $up(BigInt that) {
        return new BigInt(this.bigInteger().xor(that.bigInteger()));
    }

    public BigInt $amp$tilde(BigInt that) {
        return new BigInt(this.bigInteger().andNot(that.bigInteger()));
    }

    public BigInt gcd(BigInt that) {
        return new BigInt(this.bigInteger().gcd(that.bigInteger()));
    }

    public BigInt mod(BigInt that) {
        return new BigInt(this.bigInteger().mod(that.bigInteger()));
    }

    public BigInt min(BigInt that) {
        return new BigInt(this.bigInteger().min(that.bigInteger()));
    }

    public BigInt max(BigInt that) {
        return new BigInt(this.bigInteger().max(that.bigInteger()));
    }

    public BigInt pow(int exp) {
        return new BigInt(this.bigInteger().pow(exp));
    }

    public BigInt modPow(BigInt exp, BigInt m) {
        return new BigInt(this.bigInteger().modPow(exp.bigInteger(), m.bigInteger()));
    }

    public BigInt modInverse(BigInt m) {
        return new BigInt(this.bigInteger().modInverse(m.bigInteger()));
    }

    public BigInt unary_$minus() {
        return new BigInt(this.bigInteger().negate());
    }

    public BigInt abs() {
        return new BigInt(this.bigInteger().abs());
    }

    public int signum() {
        return this.bigInteger().signum();
    }

    public BigInt unary_$tilde() {
        return new BigInt(this.bigInteger().not());
    }

    public boolean testBit(int n) {
        return this.bigInteger().testBit(n);
    }

    public BigInt setBit(int n) {
        return new BigInt(this.bigInteger().setBit(n));
    }

    public BigInt clearBit(int n) {
        return new BigInt(this.bigInteger().clearBit(n));
    }

    public BigInt flipBit(int n) {
        return new BigInt(this.bigInteger().flipBit(n));
    }

    public int lowestSetBit() {
        return this.bigInteger().getLowestSetBit();
    }

    public int bitLength() {
        return this.bigInteger().bitLength();
    }

    public int bitCount() {
        return this.bigInteger().bitCount();
    }

    public boolean isProbablePrime(int certainty) {
        return this.bigInteger().isProbablePrime(certainty);
    }

    @Override
    public byte byteValue() {
        return (byte)this.intValue();
    }

    @Override
    public short shortValue() {
        return (short)this.intValue();
    }

    public char charValue() {
        return (char)this.intValue();
    }

    @Override
    public int intValue() {
        return this.bigInteger().intValue();
    }

    @Override
    public long longValue() {
        return this.bigInteger().longValue();
    }

    @Override
    public float floatValue() {
        return this.bigInteger().floatValue();
    }

    @Override
    public double doubleValue() {
        return this.bigInteger().doubleValue();
    }

    public NumericRange.Exclusive<BigInt> until(BigInt end, BigInt step) {
        return Range$BigInt$.MODULE$.apply(this, end, step);
    }

    public BigInt until$default$2() {
        return BigInt$.MODULE$.apply(1);
    }

    public NumericRange.Inclusive<BigInt> to(BigInt end, BigInt step) {
        return Range$BigInt$.MODULE$.inclusive(this, end, step);
    }

    public BigInt to$default$2() {
        return BigInt$.MODULE$.apply(1);
    }

    public String toString() {
        return this.bigInteger().toString();
    }

    public String toString(int radix) {
        return this.bigInteger().toString(radix);
    }

    public byte[] toByteArray() {
        return this.bigInteger().toByteArray();
    }

    public BigInt(BigInteger bigInteger) {
        this.bigInteger = bigInteger;
        ScalaNumericAnyConversions.$init$(this);
        Ordered.$init$(this);
    }
}

