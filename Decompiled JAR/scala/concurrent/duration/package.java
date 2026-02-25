/*
 * Decompiled with CFR 0.152.
 */
package scala.concurrent.duration;

import java.util.concurrent.TimeUnit;
import scala.Tuple2;
import scala.concurrent.duration.Duration;
import scala.concurrent.duration.DurationConversions;
import scala.concurrent.duration.FiniteDuration;
import scala.concurrent.duration.package$;
import scala.concurrent.duration.package$DoubleMult$;
import scala.concurrent.duration.package$DurationDouble$;
import scala.concurrent.duration.package$DurationInt$;
import scala.concurrent.duration.package$DurationLong$;
import scala.concurrent.duration.package$IntMult$;
import scala.concurrent.duration.package$LongMult$;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\r\u0015t!B:u\u0011\u0003Yh!B?u\u0011\u0003q\bbBA\u0004\u0003\u0011\u0005\u0011\u0011B\u0004\b\u0003\u0017\t\u0001\u0012AA\u0007\r\u001d\t\t\"\u0001E\u0001\u0003'Aq!a\u0002\u0005\t\u0003\t)bB\u0004\u0002\u0018\u0005A\t!!\u0007\u0007\u000f\u0005m\u0011\u0001#\u0001\u0002\u001e!9\u0011qA\u0004\u0005\u0002\u0005}QABA\u0011\u0003\u0001\t\u0019\u0003C\u0005\u00024\u0005\u0011\r\u0011\"\u0002\u00026!A\u0011\u0011I\u0001!\u0002\u001b\t9\u0004C\u0005\u0002D\u0005\u0011\r\u0011\"\u0002\u0002F!A\u0011QJ\u0001!\u0002\u001b\t9\u0005C\u0005\u0002P\u0005\u0011\r\u0011\"\u0002\u0002R!A\u0011\u0011L\u0001!\u0002\u001b\t\u0019\u0006C\u0005\u0002\\\u0005\u0011\r\u0011\"\u0002\u0002^!A\u0011QM\u0001!\u0002\u001b\ty\u0006C\u0005\u0002h\u0005\u0011\r\u0011\"\u0002\u0002j!A\u0011\u0011O\u0001!\u0002\u001b\tY\u0007C\u0005\u0002t\u0005\u0011\r\u0011\"\u0002\u0002v!A\u0011QP\u0001!\u0002\u001b\t9\bC\u0005\u0002\u0000\u0005\u0011\r\u0011\"\u0002\u0002\u0002\"A\u0011\u0011R\u0001!\u0002\u001b\t\u0019\tC\u0004\u0002\f\u0006!\u0019!!$\t\u000f\u0005\u001d\u0016\u0001b\u0001\u0002*\"9\u00111X\u0001\u0005\u0004\u0005ufABAb\u0003\r\t)\r\u0003\b\u0002Tn!\t\u0011!B\u0003\u0006\u0004%I!!6\t\u0017\u0005]7D!B\u0001B\u0003%\u0011q\u0014\u0005\b\u0003\u000fYB\u0011AAm\u0011\u001d\t\to\u0007C)\u0003GD\u0011\"!;\u001c\u0003\u0003%\t%a;\t\u0013\u000558$!A\u0005B\u0005=\b\"\u0003B\u0001\u0003\u0005\u0005I1\u0001B\u0002\r\u0019\u00119!A\u0002\u0003\n!q!1B\u0012\u0005\u0002\u0003\u0015)Q1A\u0005\n\t5\u0001b\u0003B\bG\t\u0015\t\u0011)A\u0005\u0003kCq!a\u0002$\t\u0003\u0011\t\u0002C\u0004\u0002b\u000e\"\tFa\u0006\t\u0013\u0005%8%!A\u0005B\u0005-\b\"CAwG\u0005\u0005I\u0011\tB\u000e\u0011%\u0011y\"AA\u0001\n\u0007\u0011\tC\u0002\u0004\u0003&\u0005\u0019!q\u0005\u0005\u000f\u0005SYC\u0011!A\u0003\u0006\u000b\u0007I\u0011\u0002B\u0016\u0011-\u0011\u0019d\u000bB\u0003\u0002\u0003\u0006IA!\f\t\u000f\u0005\u001d1\u0006\"\u0001\u00036!9\u0011\u0011]\u0016\u0005R\tm\u0002\"CAuW\u0005\u0005I\u0011IAv\u0011%\tioKA\u0001\n\u0003\u0012y\u0004C\u0005\u0003D\u0005\t\t\u0011b\u0001\u0003F\u00191!\u0011J\u0001\u0004\u0005\u0017BaB!\u00144\t\u0003\u0005)Q!b\u0001\n\u0013\t)\u000eC\u0006\u0003PM\u0012)\u0011!Q\u0001\n\u0005}\u0005bBA\u0004g\u0011\u0005!\u0011\u000b\u0005\b\u00053\u001aD\u0011\u0001B.\u0011\u001d\u0011If\rC\u0001\u0005?B\u0011\"!;4\u0003\u0003%\t%a;\t\u0013\u000558'!A\u0005B\t\r\u0004\"\u0003B4\u0003\u0005\u0005I1\u0001B5\r\u0019\u0011i'A\u0002\u0003p!q!\u0011\u000f\u001f\u0005\u0002\u0003\u0015)Q1A\u0005\n\t5\u0001b\u0003B:y\t\u0015\t\u0011)A\u0005\u0003kCq!a\u0002=\t\u0003\u0011)\bC\u0004\u0003Zq\"\tAa\u001f\t\u000f\teC\b\"\u0001\u0003\u0000!I\u0011\u0011\u001e\u001f\u0002\u0002\u0013\u0005\u00131\u001e\u0005\n\u0003[d\u0014\u0011!C!\u0005\u0007C\u0011Ba\"\u0002\u0003\u0003%\u0019A!#\u0007\r\t5\u0015a\u0001BH\u00119\u0011\t*\u0012C\u0001\u0002\u000b\u0015)\u0019!C\u0005\u0005WA1Ba%F\u0005\u000b\u0005\t\u0015!\u0003\u0003.!9\u0011qA#\u0005\u0002\tU\u0005b\u0002B-\u000b\u0012\u0005!Q\u0014\u0005\n\u0003S,\u0015\u0011!C!\u0003WD\u0011\"!<F\u0003\u0003%\tE!)\t\u0013\t\u0015\u0016!!A\u0005\u0004\t\u001dv!\u0003BS\u0003\u0005\u0005\t\u0012\u0001BV\r%\u0011i)AA\u0001\u0012\u0003\u0011i\u000bC\u0004\u0002\b9#\tAa,\t\u000f\tEf\n\"\u0002\u00034\"I!Q\u0018(\u0002\u0002\u0013\u0015!q\u0018\u0005\n\u0005\u0007t\u0015\u0011!C\u0003\u0005\u000b<\u0011Ba\"\u0002\u0003\u0003E\tA!4\u0007\u0013\t5\u0014!!A\t\u0002\t=\u0007bBA\u0004)\u0012\u0005!\u0011\u001b\u0005\b\u0005'$FQ\u0001Bk\u0011\u001d\u0011i\u000e\u0016C\u0003\u0005?D\u0011B!0U\u0003\u0003%)Aa:\t\u0013\t\rG+!A\u0005\u0006\t-x!\u0003B4\u0003\u0005\u0005\t\u0012\u0001Bz\r%\u0011I%AA\u0001\u0012\u0003\u0011)\u0010C\u0004\u0002\bm#\tAa>\t\u000f\tM7\f\"\u0002\u0003z\"9!Q\\.\u0005\u0006\r\u0005\u0001\"\u0003B_7\u0006\u0005IQAB\u0005\u0011%\u0011\u0019mWA\u0001\n\u000b\u0019iaB\u0005\u0003D\u0005\t\t\u0011#\u0001\u0004\u0016\u0019I!QE\u0001\u0002\u0002#\u00051q\u0003\u0005\b\u0003\u000f\u0011G\u0011AB\r\u0011\u001d\u0019YB\u0019C\u0003\u0007;A\u0011B!0c\u0003\u0003%)a!\n\t\u0013\t\r'-!A\u0005\u0006\r%r!\u0003B\u0010\u0003\u0005\u0005\t\u0012AB\u0019\r%\u00119!AA\u0001\u0012\u0003\u0019\u0019\u0004C\u0004\u0002\b!$\ta!\u000e\t\u000f\rm\u0001\u000e\"\u0002\u00048!I!Q\u00185\u0002\u0002\u0013\u00151q\b\u0005\n\u0005\u0007D\u0017\u0011!C\u0003\u0007\u0007:\u0011B!\u0001\u0002\u0003\u0003E\taa\u0013\u0007\u0013\u0005\r\u0017!!A\t\u0002\r5\u0003bBA\u0004]\u0012\u00051q\n\u0005\b\u00077qGQAB)\u0011%\u0011iL\\A\u0001\n\u000b\u0019I\u0006C\u0005\u0003D:\f\t\u0011\"\u0002\u0004^\u00059\u0001/Y2lC\u001e,'BA;w\u0003!!WO]1uS>t'BA<y\u0003)\u0019wN\\2veJ,g\u000e\u001e\u0006\u0002s\u0006)1oY1mC\u000e\u0001\u0001C\u0001?\u0002\u001b\u0005!(a\u00029bG.\fw-Z\n\u0003\u0003}\u0004B!!\u0001\u0002\u00045\t\u00010C\u0002\u0002\u0006a\u0014a!\u00118z%\u00164\u0017A\u0002\u001fj]&$h\bF\u0001|\u0003\u0011\u0019\b/\u00198\u0011\u0007\u0005=A!D\u0001\u0002\u0005\u0011\u0019\b/\u00198\u0014\u0005\u0011yHCAA\u0007\u0003\u001d1'o\\7O_^\u00042!a\u0004\b\u0005\u001d1'o\\7O_^\u001c\"aB@\u0015\u0005\u0005e!\u0001\u0003+j[\u0016,f.\u001b;\u0011\t\u0005\u0015\u0012\u0011G\u0007\u0003\u0003OQ1a^A\u0015\u0015\u0011\tY#!\f\u0002\tU$\u0018\u000e\u001c\u0006\u0003\u0003_\tAA[1wC&!\u0011\u0011EA\u0014\u0003\u0011!\u0015)W*\u0016\u0005\u0005]rBAA\u001dI\t\tY$\u0003\u0003\u00024\u0005u\"\u0002BA \u0003O\t\u0001\u0002V5nKVs\u0017\u000e^\u0001\u0006\t\u0006K6\u000bI\u0001\u0006\u0011>+&kU\u000b\u0003\u0003\u000fz!!!\u0013%\u0005\u0005-\u0013\u0002BA\"\u0003{\ta\u0001S(V%N\u0003\u0013\u0001D'J\u0007J{5+R\"P\u001d\u0012\u001bVCAA*\u001f\t\t)\u0006\n\u0002\u0002X%!\u0011qJA\u001f\u00035i\u0015j\u0011*P'\u0016\u001buJ\u0014#TA\u0005aQ*\u0013'M\u0013N+5i\u0014(E'V\u0011\u0011qL\b\u0003\u0003C\"#!a\u0019\n\t\u0005m\u0013QH\u0001\u000e\u001b&cE*S*F\u0007>sEi\u0015\u0011\u0002\u000f5Ke*\u0016+F'V\u0011\u00111N\b\u0003\u0003[\"#!a\u001c\n\t\u0005\u001d\u0014QH\u0001\t\u001b&sU\u000bV#TA\u0005Ya*\u0011(P'\u0016\u001buJ\u0014#T+\t\t9h\u0004\u0002\u0002z\u0011\u0012\u00111P\u0005\u0005\u0003g\ni$\u0001\u0007O\u0003:{5+R\"P\u001d\u0012\u001b\u0006%A\u0004T\u000b\u000e{e\nR*\u0016\u0005\u0005\ruBAACI\t\t9)\u0003\u0003\u0002\u0000\u0005u\u0012\u0001C*F\u0007>sEi\u0015\u0011\u0002#A\f\u0017N]%oiR{G)\u001e:bi&|g\u000e\u0006\u0003\u0002\u0010\u0006U\u0005c\u0001?\u0002\u0012&\u0019\u00111\u0013;\u0003\u0011\u0011+(/\u0019;j_:Dq!a&\u0019\u0001\u0004\tI*A\u0001q!!\t\t!a'\u0002 \u0006\u0015\u0016bAAOq\n1A+\u001e9mKJ\u0002B!!\u0001\u0002\"&\u0019\u00111\u0015=\u0003\u0007%sG\u000fE\u0002\u0002\u0010%\t!\u0003]1je2{gn\u001a+p\tV\u0014\u0018\r^5p]R!\u00111VAY!\ra\u0018QV\u0005\u0004\u0003_#(A\u0004$j]&$X\rR;sCRLwN\u001c\u0005\b\u0003/K\u0002\u0019AAZ!!\t\t!a'\u00026\u0006\u0015\u0006\u0003BA\u0001\u0003oK1!!/y\u0005\u0011auN\\4\u0002\u001d\u0011,(/\u0019;j_:$v\u000eU1jeR!\u00111WA`\u0011\u001d\t\tM\u0007a\u0001\u0003\u001f\u000b\u0011\u0001\u001a\u0002\f\tV\u0014\u0018\r^5p]&sGoE\u0003\u001c\u0003\u000f\fi\r\u0005\u0003\u0002\u0002\u0005%\u0017bAAfq\n1\u0011I\\=WC2\u00042\u0001`Ah\u0013\r\t\t\u000e\u001e\u0002\u0014\tV\u0014\u0018\r^5p]\u000e{gN^3sg&|gn]\u0001)g\u000e\fG.\u0019\u0013d_:\u001cWO\u001d:f]R$C-\u001e:bi&|g\u000e\n#ve\u0006$\u0018n\u001c8J]R$CE\\\u000b\u0003\u0003?\u000b\u0011f]2bY\u0006$3m\u001c8dkJ\u0014XM\u001c;%IV\u0014\u0018\r^5p]\u0012\"UO]1uS>t\u0017J\u001c;%I9\u0004C\u0003BAn\u0003;\u00042!a\u0004\u001c\u0011\u001d\tyN\ba\u0001\u0003?\u000b\u0011A\\\u0001\u000bIV\u0014\u0018\r^5p]&sG\u0003BAV\u0003KDq!a: \u0001\u0004\t)+\u0001\u0003v]&$\u0018\u0001\u00035bg\"\u001cu\u000eZ3\u0015\u0005\u0005}\u0015AB3rk\u0006d7\u000f\u0006\u0003\u0002r\u0006]\b\u0003BA\u0001\u0003gL1!!>y\u0005\u001d\u0011un\u001c7fC:D\u0011\"!?\"\u0003\u0003\u0005\r!a?\u0002\u0007a$\u0013\u0007\u0005\u0003\u0002\u0002\u0005u\u0018bAA\u0000q\n\u0019\u0011I\\=\u0002\u0017\u0011+(/\u0019;j_:Le\u000e\u001e\u000b\u0005\u00037\u0014)\u0001C\u0004\u0002`\n\u0002\r!a(\u0003\u0019\u0011+(/\u0019;j_:duN\\4\u0014\u000b\r\n9-!4\u0002SM\u001c\u0017\r\\1%G>t7-\u001e:sK:$H\u0005Z;sCRLwN\u001c\u0013EkJ\fG/[8o\u0019>tw\r\n\u0013o+\t\t),\u0001\u0016tG\u0006d\u0017\rJ2p]\u000e,(O]3oi\u0012\"WO]1uS>tG\u0005R;sCRLwN\u001c'p]\u001e$CE\u001c\u0011\u0015\t\tM!Q\u0003\t\u0004\u0003\u001f\u0019\u0003bBApM\u0001\u0007\u0011Q\u0017\u000b\u0005\u0003W\u0013I\u0002C\u0004\u0002h\u001e\u0002\r!!*\u0015\t\u0005E(Q\u0004\u0005\n\u0003sL\u0013\u0011!a\u0001\u0003w\fA\u0002R;sCRLwN\u001c'p]\u001e$BAa\u0005\u0003$!9\u0011q\u001c\u0016A\u0002\u0005U&A\u0004#ve\u0006$\u0018n\u001c8E_V\u0014G.Z\n\u0006W\u0005\u001d\u0017QZ\u0001,g\u000e\fG.\u0019\u0013d_:\u001cWO\u001d:f]R$C-\u001e:bi&|g\u000e\n#ve\u0006$\u0018n\u001c8E_V\u0014G.\u001a\u0013%IV\u0011!Q\u0006\t\u0005\u0003\u0003\u0011y#C\u0002\u00032a\u0014a\u0001R8vE2,\u0017\u0001L:dC2\fGeY8oGV\u0014(/\u001a8uI\u0011,(/\u0019;j_:$C)\u001e:bi&|g\u000eR8vE2,G\u0005\n3!)\u0011\u00119D!\u000f\u0011\u0007\u0005=1\u0006C\u0004\u0002B:\u0002\rA!\f\u0015\t\u0005-&Q\b\u0005\b\u0003O|\u0003\u0019AAS)\u0011\t\tP!\u0011\t\u0013\u0005e\u0018'!AA\u0002\u0005m\u0018A\u0004#ve\u0006$\u0018n\u001c8E_V\u0014G.\u001a\u000b\u0005\u0005o\u00119\u0005C\u0004\u0002BJ\u0002\rA!\f\u0003\u000f%sG/T;miN\u00191'a2\u0002IM\u001c\u0017\r\\1%G>t7-\u001e:sK:$H\u0005Z;sCRLwN\u001c\u0013J]RlU\u000f\u001c;%I%\fQe]2bY\u0006$3m\u001c8dkJ\u0014XM\u001c;%IV\u0014\u0018\r^5p]\u0012Je\u000e^'vYR$C%\u001b\u0011\u0015\t\tM#Q\u000b\t\u0004\u0003\u001f\u0019\u0004b\u0002B,m\u0001\u0007\u0011qT\u0001\u0002S\u00061A\u0005^5nKN$B!a$\u0003^!9\u0011\u0011Y\u001cA\u0002\u0005=E\u0003BAV\u0005CBq!!19\u0001\u0004\tY\u000b\u0006\u0003\u0002r\n\u0015\u0004\"CA}u\u0005\u0005\t\u0019AA~\u0003\u001dIe\u000e^'vYR$BAa\u0015\u0003l!9!qK\u001eA\u0002\u0005}%\u0001\u0003'p]\u001elU\u000f\u001c;\u0014\u0007q\n9-A\u0013tG\u0006d\u0017\rJ2p]\u000e,(O]3oi\u0012\"WO]1uS>tG\u0005T8oO6+H\u000e\u001e\u0013%S\u000613oY1mC\u0012\u001awN\\2veJ,g\u000e\u001e\u0013ekJ\fG/[8oI1{gnZ'vYR$C%\u001b\u0011\u0015\t\t]$\u0011\u0010\t\u0004\u0003\u001fa\u0004b\u0002B,\u007f\u0001\u0007\u0011Q\u0017\u000b\u0005\u0003\u001f\u0013i\bC\u0004\u0002B\u0002\u0003\r!a$\u0015\t\u0005-&\u0011\u0011\u0005\b\u0003\u0003\f\u0005\u0019AAV)\u0011\t\tP!\"\t\u0013\u0005e8)!AA\u0002\u0005m\u0018\u0001\u0003'p]\u001elU\u000f\u001c;\u0015\t\t]$1\u0012\u0005\b\u0005/\"\u0005\u0019AA[\u0005)!u.\u001e2mK6+H\u000e^\n\u0004\u000b\u0006\u001d\u0017aJ:dC2\fGeY8oGV\u0014(/\u001a8uI\u0011,(/\u0019;j_:$Ci\\;cY\u0016lU\u000f\u001c;%I\u0019\f\u0001f]2bY\u0006$3m\u001c8dkJ\u0014XM\u001c;%IV\u0014\u0018\r^5p]\u0012\"u.\u001e2mK6+H\u000e\u001e\u0013%M\u0002\"BAa&\u0003\u001aB\u0019\u0011qB#\t\u000f\tm\u0005\n1\u0001\u0003.\u0005\ta\r\u0006\u0003\u0002\u0010\n}\u0005bBAa\u0013\u0002\u0007\u0011q\u0012\u000b\u0005\u0003c\u0014\u0019\u000bC\u0005\u0002z.\u000b\t\u00111\u0001\u0002|\u0006QAi\\;cY\u0016lU\u000f\u001c;\u0015\t\t]%\u0011\u0016\u0005\b\u00057c\u0005\u0019\u0001B\u0017!\r\tyAT\n\u0003\u001d~$\"Aa+\u0002!\u0011\"\u0018.\\3tI\u0015DH/\u001a8tS>tG\u0003\u0002B[\u0005s#B!a$\u00038\"9\u0011\u0011\u0019)A\u0002\u0005=\u0005b\u0002B^!\u0002\u0007!qS\u0001\u0006IQD\u0017n]\u0001\u0013Q\u0006\u001c\bnQ8eK\u0012*\u0007\u0010^3og&|g\u000e\u0006\u0003\u0002l\n\u0005\u0007b\u0002B^#\u0002\u0007!qS\u0001\u0011KF,\u0018\r\\:%Kb$XM\\:j_:$BAa2\u0003LR!\u0011\u0011\u001fBe\u0011%\tIPUA\u0001\u0002\u0004\tY\u0010C\u0004\u0003<J\u0003\rAa&\u0011\u0007\u0005=Ak\u0005\u0002U\u007fR\u0011!QZ\u0001\u0012IQLW.Z:%Kb$XM\\:j_:\u0004D\u0003\u0002Bl\u00057$B!a$\u0003Z\"9\u0011\u0011\u0019,A\u0002\u0005=\u0005b\u0002B^-\u0002\u0007!qO\u0001\u0012IQLW.Z:%Kb$XM\\:j_:\fD\u0003\u0002Bq\u0005K$B!a+\u0003d\"9\u0011\u0011Y,A\u0002\u0005-\u0006b\u0002B^/\u0002\u0007!q\u000f\u000b\u0005\u0003W\u0014I\u000fC\u0004\u0003<b\u0003\rAa\u001e\u0015\t\t5(\u0011\u001f\u000b\u0005\u0003c\u0014y\u000fC\u0005\u0002zf\u000b\t\u00111\u0001\u0002|\"9!1X-A\u0002\t]\u0004cAA\b7N\u00111l \u000b\u0003\u0005g$BAa?\u0003\u0000R!\u0011q\u0012B\u007f\u0011\u001d\t\t-\u0018a\u0001\u0003\u001fCqAa/^\u0001\u0004\u0011\u0019\u0006\u0006\u0003\u0004\u0004\r\u001dA\u0003BAV\u0007\u000bAq!!1_\u0001\u0004\tY\u000bC\u0004\u0003<z\u0003\rAa\u0015\u0015\t\u0005-81\u0002\u0005\b\u0005w{\u0006\u0019\u0001B*)\u0011\u0019yaa\u0005\u0015\t\u0005E8\u0011\u0003\u0005\n\u0003s\u0004\u0017\u0011!a\u0001\u0003wDqAa/a\u0001\u0004\u0011\u0019\u0006E\u0002\u0002\u0010\t\u001c\"AY@\u0015\u0005\rU\u0011\u0001\u00063ve\u0006$\u0018n\u001c8J]\u0012*\u0007\u0010^3og&|g\u000e\u0006\u0003\u0004 \r\rB\u0003BAV\u0007CAq!a:e\u0001\u0004\t)\u000bC\u0004\u0003<\u0012\u0004\rAa\u000e\u0015\t\u0005-8q\u0005\u0005\b\u0005w+\u0007\u0019\u0001B\u001c)\u0011\u0019Yca\f\u0015\t\u0005E8Q\u0006\u0005\n\u0003s4\u0017\u0011!a\u0001\u0003wDqAa/g\u0001\u0004\u00119\u0004E\u0002\u0002\u0010!\u001c\"\u0001[@\u0015\u0005\rEB\u0003BB\u001d\u0007{!B!a+\u0004<!9\u0011q\u001d6A\u0002\u0005\u0015\u0006b\u0002B^U\u0002\u0007!1\u0003\u000b\u0005\u0003W\u001c\t\u0005C\u0004\u0003<.\u0004\rAa\u0005\u0015\t\r\u00153\u0011\n\u000b\u0005\u0003c\u001c9\u0005C\u0005\u0002z2\f\t\u00111\u0001\u0002|\"9!1\u00187A\u0002\tM\u0001cAA\b]N\u0011an \u000b\u0003\u0007\u0017\"Baa\u0015\u0004XQ!\u00111VB+\u0011\u001d\t9\u000f\u001da\u0001\u0003KCqAa/q\u0001\u0004\tY\u000e\u0006\u0003\u0002l\u000em\u0003b\u0002B^c\u0002\u0007\u00111\u001c\u000b\u0005\u0007?\u001a\u0019\u0007\u0006\u0003\u0002r\u000e\u0005\u0004\"CA}e\u0006\u0005\t\u0019AA~\u0011\u001d\u0011YL\u001da\u0001\u00037\u0004")
public final class package {
    public static double DoubleMult(double d) {
        return package$.MODULE$.DoubleMult(d);
    }

    public static long LongMult(long l) {
        return package$.MODULE$.LongMult(l);
    }

    public static int IntMult(int n) {
        return package$.MODULE$.IntMult(n);
    }

    public static double DurationDouble(double d) {
        return package$.MODULE$.DurationDouble(d);
    }

    public static long DurationLong(long l) {
        return package$.MODULE$.DurationLong(l);
    }

    public static int DurationInt(int n) {
        return package$.MODULE$.DurationInt(n);
    }

    public static Tuple2<Object, TimeUnit> durationToPair(Duration duration) {
        return package$.MODULE$.durationToPair(duration);
    }

    public static FiniteDuration pairLongToDuration(Tuple2<Object, TimeUnit> tuple2) {
        return package$.MODULE$.pairLongToDuration(tuple2);
    }

    public static Duration pairIntToDuration(Tuple2<Object, TimeUnit> tuple2) {
        return package$.MODULE$.pairIntToDuration(tuple2);
    }

    public static TimeUnit SECONDS() {
        return package$.MODULE$.SECONDS();
    }

    public static TimeUnit NANOSECONDS() {
        return package$.MODULE$.NANOSECONDS();
    }

    public static TimeUnit MINUTES() {
        return package$.MODULE$.MINUTES();
    }

    public static TimeUnit MILLISECONDS() {
        return package$.MODULE$.MILLISECONDS();
    }

    public static TimeUnit MICROSECONDS() {
        return package$.MODULE$.MICROSECONDS();
    }

    public static TimeUnit HOURS() {
        return package$.MODULE$.HOURS();
    }

    public static TimeUnit DAYS() {
        return package$.MODULE$.DAYS();
    }

    public static final class DoubleMult {
        private final double scala$concurrent$duration$DoubleMult$$f;

        public double scala$concurrent$duration$DoubleMult$$f() {
            return this.scala$concurrent$duration$DoubleMult$$f;
        }

        public Duration $times(Duration d) {
            return package$DoubleMult$.MODULE$.$times$extension(this.scala$concurrent$duration$DoubleMult$$f(), d);
        }

        public int hashCode() {
            return package$DoubleMult$.MODULE$.hashCode$extension(this.scala$concurrent$duration$DoubleMult$$f());
        }

        public boolean equals(Object x$1) {
            return package$DoubleMult$.MODULE$.equals$extension(this.scala$concurrent$duration$DoubleMult$$f(), x$1);
        }

        public DoubleMult(double f) {
            this.scala$concurrent$duration$DoubleMult$$f = f;
        }
    }

    public static final class DurationDouble
    implements DurationConversions {
        private final double scala$concurrent$duration$DurationDouble$$d;

        @Override
        public FiniteDuration nanoseconds() {
            return DurationConversions.nanoseconds$(this);
        }

        @Override
        public FiniteDuration nanos() {
            return DurationConversions.nanos$(this);
        }

        @Override
        public FiniteDuration nanosecond() {
            return DurationConversions.nanosecond$(this);
        }

        @Override
        public FiniteDuration nano() {
            return DurationConversions.nano$(this);
        }

        @Override
        public FiniteDuration microseconds() {
            return DurationConversions.microseconds$(this);
        }

        @Override
        public FiniteDuration micros() {
            return DurationConversions.micros$(this);
        }

        @Override
        public FiniteDuration microsecond() {
            return DurationConversions.microsecond$(this);
        }

        @Override
        public FiniteDuration micro() {
            return DurationConversions.micro$(this);
        }

        @Override
        public FiniteDuration milliseconds() {
            return DurationConversions.milliseconds$(this);
        }

        @Override
        public FiniteDuration millis() {
            return DurationConversions.millis$(this);
        }

        @Override
        public FiniteDuration millisecond() {
            return DurationConversions.millisecond$(this);
        }

        @Override
        public FiniteDuration milli() {
            return DurationConversions.milli$(this);
        }

        @Override
        public FiniteDuration seconds() {
            return DurationConversions.seconds$(this);
        }

        @Override
        public FiniteDuration second() {
            return DurationConversions.second$(this);
        }

        @Override
        public FiniteDuration minutes() {
            return DurationConversions.minutes$(this);
        }

        @Override
        public FiniteDuration minute() {
            return DurationConversions.minute$(this);
        }

        @Override
        public FiniteDuration hours() {
            return DurationConversions.hours$(this);
        }

        @Override
        public FiniteDuration hour() {
            return DurationConversions.hour$(this);
        }

        @Override
        public FiniteDuration days() {
            return DurationConversions.days$(this);
        }

        @Override
        public FiniteDuration day() {
            return DurationConversions.day$(this);
        }

        @Override
        public <C> Object nanoseconds(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.nanoseconds$(this, c, ev);
        }

        @Override
        public <C> Object nanos(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.nanos$(this, c, ev);
        }

        @Override
        public <C> Object nanosecond(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.nanosecond$(this, c, ev);
        }

        @Override
        public <C> Object nano(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.nano$(this, c, ev);
        }

        @Override
        public <C> Object microseconds(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.microseconds$(this, c, ev);
        }

        @Override
        public <C> Object micros(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.micros$(this, c, ev);
        }

        @Override
        public <C> Object microsecond(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.microsecond$(this, c, ev);
        }

        @Override
        public <C> Object micro(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.micro$(this, c, ev);
        }

        @Override
        public <C> Object milliseconds(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.milliseconds$(this, c, ev);
        }

        @Override
        public <C> Object millis(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.millis$(this, c, ev);
        }

        @Override
        public <C> Object millisecond(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.millisecond$(this, c, ev);
        }

        @Override
        public <C> Object milli(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.milli$(this, c, ev);
        }

        @Override
        public <C> Object seconds(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.seconds$(this, c, ev);
        }

        @Override
        public <C> Object second(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.second$(this, c, ev);
        }

        @Override
        public <C> Object minutes(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.minutes$(this, c, ev);
        }

        @Override
        public <C> Object minute(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.minute$(this, c, ev);
        }

        @Override
        public <C> Object hours(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.hours$(this, c, ev);
        }

        @Override
        public <C> Object hour(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.hour$(this, c, ev);
        }

        @Override
        public <C> Object days(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.days$(this, c, ev);
        }

        @Override
        public <C> Object day(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.day$(this, c, ev);
        }

        public double scala$concurrent$duration$DurationDouble$$d() {
            return this.scala$concurrent$duration$DurationDouble$$d;
        }

        @Override
        public FiniteDuration durationIn(TimeUnit unit) {
            return package$DurationDouble$.MODULE$.durationIn$extension(this.scala$concurrent$duration$DurationDouble$$d(), unit);
        }

        public int hashCode() {
            return package$DurationDouble$.MODULE$.hashCode$extension(this.scala$concurrent$duration$DurationDouble$$d());
        }

        public boolean equals(Object x$1) {
            return package$DurationDouble$.MODULE$.equals$extension(this.scala$concurrent$duration$DurationDouble$$d(), x$1);
        }

        public DurationDouble(double d) {
            this.scala$concurrent$duration$DurationDouble$$d = d;
            DurationConversions.$init$(this);
        }
    }

    public static final class DurationInt
    implements DurationConversions {
        private final int scala$concurrent$duration$DurationInt$$n;

        @Override
        public FiniteDuration nanoseconds() {
            return DurationConversions.nanoseconds$(this);
        }

        @Override
        public FiniteDuration nanos() {
            return DurationConversions.nanos$(this);
        }

        @Override
        public FiniteDuration nanosecond() {
            return DurationConversions.nanosecond$(this);
        }

        @Override
        public FiniteDuration nano() {
            return DurationConversions.nano$(this);
        }

        @Override
        public FiniteDuration microseconds() {
            return DurationConversions.microseconds$(this);
        }

        @Override
        public FiniteDuration micros() {
            return DurationConversions.micros$(this);
        }

        @Override
        public FiniteDuration microsecond() {
            return DurationConversions.microsecond$(this);
        }

        @Override
        public FiniteDuration micro() {
            return DurationConversions.micro$(this);
        }

        @Override
        public FiniteDuration milliseconds() {
            return DurationConversions.milliseconds$(this);
        }

        @Override
        public FiniteDuration millis() {
            return DurationConversions.millis$(this);
        }

        @Override
        public FiniteDuration millisecond() {
            return DurationConversions.millisecond$(this);
        }

        @Override
        public FiniteDuration milli() {
            return DurationConversions.milli$(this);
        }

        @Override
        public FiniteDuration seconds() {
            return DurationConversions.seconds$(this);
        }

        @Override
        public FiniteDuration second() {
            return DurationConversions.second$(this);
        }

        @Override
        public FiniteDuration minutes() {
            return DurationConversions.minutes$(this);
        }

        @Override
        public FiniteDuration minute() {
            return DurationConversions.minute$(this);
        }

        @Override
        public FiniteDuration hours() {
            return DurationConversions.hours$(this);
        }

        @Override
        public FiniteDuration hour() {
            return DurationConversions.hour$(this);
        }

        @Override
        public FiniteDuration days() {
            return DurationConversions.days$(this);
        }

        @Override
        public FiniteDuration day() {
            return DurationConversions.day$(this);
        }

        @Override
        public <C> Object nanoseconds(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.nanoseconds$(this, c, ev);
        }

        @Override
        public <C> Object nanos(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.nanos$(this, c, ev);
        }

        @Override
        public <C> Object nanosecond(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.nanosecond$(this, c, ev);
        }

        @Override
        public <C> Object nano(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.nano$(this, c, ev);
        }

        @Override
        public <C> Object microseconds(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.microseconds$(this, c, ev);
        }

        @Override
        public <C> Object micros(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.micros$(this, c, ev);
        }

        @Override
        public <C> Object microsecond(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.microsecond$(this, c, ev);
        }

        @Override
        public <C> Object micro(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.micro$(this, c, ev);
        }

        @Override
        public <C> Object milliseconds(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.milliseconds$(this, c, ev);
        }

        @Override
        public <C> Object millis(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.millis$(this, c, ev);
        }

        @Override
        public <C> Object millisecond(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.millisecond$(this, c, ev);
        }

        @Override
        public <C> Object milli(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.milli$(this, c, ev);
        }

        @Override
        public <C> Object seconds(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.seconds$(this, c, ev);
        }

        @Override
        public <C> Object second(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.second$(this, c, ev);
        }

        @Override
        public <C> Object minutes(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.minutes$(this, c, ev);
        }

        @Override
        public <C> Object minute(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.minute$(this, c, ev);
        }

        @Override
        public <C> Object hours(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.hours$(this, c, ev);
        }

        @Override
        public <C> Object hour(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.hour$(this, c, ev);
        }

        @Override
        public <C> Object days(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.days$(this, c, ev);
        }

        @Override
        public <C> Object day(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.day$(this, c, ev);
        }

        public int scala$concurrent$duration$DurationInt$$n() {
            return this.scala$concurrent$duration$DurationInt$$n;
        }

        @Override
        public FiniteDuration durationIn(TimeUnit unit) {
            return package$DurationInt$.MODULE$.durationIn$extension(this.scala$concurrent$duration$DurationInt$$n(), unit);
        }

        public int hashCode() {
            return package$DurationInt$.MODULE$.hashCode$extension(this.scala$concurrent$duration$DurationInt$$n());
        }

        public boolean equals(Object x$1) {
            return package$DurationInt$.MODULE$.equals$extension(this.scala$concurrent$duration$DurationInt$$n(), x$1);
        }

        public DurationInt(int n) {
            this.scala$concurrent$duration$DurationInt$$n = n;
            DurationConversions.$init$(this);
        }
    }

    public static final class DurationLong
    implements DurationConversions {
        private final long scala$concurrent$duration$DurationLong$$n;

        @Override
        public FiniteDuration nanoseconds() {
            return DurationConversions.nanoseconds$(this);
        }

        @Override
        public FiniteDuration nanos() {
            return DurationConversions.nanos$(this);
        }

        @Override
        public FiniteDuration nanosecond() {
            return DurationConversions.nanosecond$(this);
        }

        @Override
        public FiniteDuration nano() {
            return DurationConversions.nano$(this);
        }

        @Override
        public FiniteDuration microseconds() {
            return DurationConversions.microseconds$(this);
        }

        @Override
        public FiniteDuration micros() {
            return DurationConversions.micros$(this);
        }

        @Override
        public FiniteDuration microsecond() {
            return DurationConversions.microsecond$(this);
        }

        @Override
        public FiniteDuration micro() {
            return DurationConversions.micro$(this);
        }

        @Override
        public FiniteDuration milliseconds() {
            return DurationConversions.milliseconds$(this);
        }

        @Override
        public FiniteDuration millis() {
            return DurationConversions.millis$(this);
        }

        @Override
        public FiniteDuration millisecond() {
            return DurationConversions.millisecond$(this);
        }

        @Override
        public FiniteDuration milli() {
            return DurationConversions.milli$(this);
        }

        @Override
        public FiniteDuration seconds() {
            return DurationConversions.seconds$(this);
        }

        @Override
        public FiniteDuration second() {
            return DurationConversions.second$(this);
        }

        @Override
        public FiniteDuration minutes() {
            return DurationConversions.minutes$(this);
        }

        @Override
        public FiniteDuration minute() {
            return DurationConversions.minute$(this);
        }

        @Override
        public FiniteDuration hours() {
            return DurationConversions.hours$(this);
        }

        @Override
        public FiniteDuration hour() {
            return DurationConversions.hour$(this);
        }

        @Override
        public FiniteDuration days() {
            return DurationConversions.days$(this);
        }

        @Override
        public FiniteDuration day() {
            return DurationConversions.day$(this);
        }

        @Override
        public <C> Object nanoseconds(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.nanoseconds$(this, c, ev);
        }

        @Override
        public <C> Object nanos(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.nanos$(this, c, ev);
        }

        @Override
        public <C> Object nanosecond(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.nanosecond$(this, c, ev);
        }

        @Override
        public <C> Object nano(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.nano$(this, c, ev);
        }

        @Override
        public <C> Object microseconds(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.microseconds$(this, c, ev);
        }

        @Override
        public <C> Object micros(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.micros$(this, c, ev);
        }

        @Override
        public <C> Object microsecond(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.microsecond$(this, c, ev);
        }

        @Override
        public <C> Object micro(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.micro$(this, c, ev);
        }

        @Override
        public <C> Object milliseconds(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.milliseconds$(this, c, ev);
        }

        @Override
        public <C> Object millis(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.millis$(this, c, ev);
        }

        @Override
        public <C> Object millisecond(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.millisecond$(this, c, ev);
        }

        @Override
        public <C> Object milli(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.milli$(this, c, ev);
        }

        @Override
        public <C> Object seconds(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.seconds$(this, c, ev);
        }

        @Override
        public <C> Object second(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.second$(this, c, ev);
        }

        @Override
        public <C> Object minutes(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.minutes$(this, c, ev);
        }

        @Override
        public <C> Object minute(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.minute$(this, c, ev);
        }

        @Override
        public <C> Object hours(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.hours$(this, c, ev);
        }

        @Override
        public <C> Object hour(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.hour$(this, c, ev);
        }

        @Override
        public <C> Object days(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.days$(this, c, ev);
        }

        @Override
        public <C> Object day(C c, DurationConversions.Classifier<C> ev) {
            return DurationConversions.day$(this, c, ev);
        }

        public long scala$concurrent$duration$DurationLong$$n() {
            return this.scala$concurrent$duration$DurationLong$$n;
        }

        @Override
        public FiniteDuration durationIn(TimeUnit unit) {
            return package$DurationLong$.MODULE$.durationIn$extension(this.scala$concurrent$duration$DurationLong$$n(), unit);
        }

        public int hashCode() {
            return package$DurationLong$.MODULE$.hashCode$extension(this.scala$concurrent$duration$DurationLong$$n());
        }

        public boolean equals(Object x$1) {
            return package$DurationLong$.MODULE$.equals$extension(this.scala$concurrent$duration$DurationLong$$n(), x$1);
        }

        public DurationLong(long n) {
            this.scala$concurrent$duration$DurationLong$$n = n;
            DurationConversions.$init$(this);
        }
    }

    public static final class IntMult {
        private final int scala$concurrent$duration$IntMult$$i;

        public int scala$concurrent$duration$IntMult$$i() {
            return this.scala$concurrent$duration$IntMult$$i;
        }

        public Duration $times(Duration d) {
            return package$IntMult$.MODULE$.$times$extension0(this.scala$concurrent$duration$IntMult$$i(), d);
        }

        public FiniteDuration $times(FiniteDuration d) {
            return package$IntMult$.MODULE$.$times$extension1(this.scala$concurrent$duration$IntMult$$i(), d);
        }

        public int hashCode() {
            return package$IntMult$.MODULE$.hashCode$extension(this.scala$concurrent$duration$IntMult$$i());
        }

        public boolean equals(Object x$1) {
            return package$IntMult$.MODULE$.equals$extension(this.scala$concurrent$duration$IntMult$$i(), x$1);
        }

        public IntMult(int i) {
            this.scala$concurrent$duration$IntMult$$i = i;
        }
    }

    public static final class LongMult {
        private final long scala$concurrent$duration$LongMult$$i;

        public long scala$concurrent$duration$LongMult$$i() {
            return this.scala$concurrent$duration$LongMult$$i;
        }

        public Duration $times(Duration d) {
            return package$LongMult$.MODULE$.$times$extension0(this.scala$concurrent$duration$LongMult$$i(), d);
        }

        public FiniteDuration $times(FiniteDuration d) {
            return package$LongMult$.MODULE$.$times$extension1(this.scala$concurrent$duration$LongMult$$i(), d);
        }

        public int hashCode() {
            return package$LongMult$.MODULE$.hashCode$extension(this.scala$concurrent$duration$LongMult$$i());
        }

        public boolean equals(Object x$1) {
            return package$LongMult$.MODULE$.equals$extension(this.scala$concurrent$duration$LongMult$$i(), x$1);
        }

        public LongMult(long i) {
            this.scala$concurrent$duration$LongMult$$i = i;
        }
    }
}

