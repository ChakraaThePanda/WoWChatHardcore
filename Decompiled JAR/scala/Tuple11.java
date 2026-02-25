/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.Option;
import scala.Product;
import scala.Product11;
import scala.Serializable;
import scala.Tuple11$;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\r}f\u0001B\u00193\u0005VB\u0001\"\u001c\u0001\u0003\u0016\u0004%\tA\u001c\u0005\t_\u0002\u0011\t\u0012)A\u0005}!A\u0001\u000f\u0001BK\u0002\u0013\u0005\u0011\u000f\u0003\u0005s\u0001\tE\t\u0015!\u0003J\u0011!\u0019\bA!f\u0001\n\u0003!\b\u0002C;\u0001\u0005#\u0005\u000b\u0011\u0002'\t\u0011Y\u0004!Q3A\u0005\u0002]D\u0001\u0002\u001f\u0001\u0003\u0012\u0003\u0006Ia\u0014\u0005\ts\u0002\u0011)\u001a!C\u0001u\"A1\u0010\u0001B\tB\u0003%!\u000b\u0003\u0005}\u0001\tU\r\u0011\"\u0001~\u0011!q\bA!E!\u0002\u0013)\u0006\"C@\u0001\u0005+\u0007I\u0011AA\u0001\u0011%\t\u0019\u0001\u0001B\tB\u0003%\u0001\f\u0003\u0006\u0002\u0006\u0001\u0011)\u001a!C\u0001\u0003\u000fA\u0011\"!\u0003\u0001\u0005#\u0005\u000b\u0011B.\t\u0015\u0005-\u0001A!f\u0001\n\u0003\ti\u0001C\u0005\u0002\u0010\u0001\u0011\t\u0012)A\u0005=\"Q\u0011\u0011\u0003\u0001\u0003\u0016\u0004%\t!a\u0005\t\u0013\u0005U\u0001A!E!\u0002\u0013\t\u0007BCA\f\u0001\tU\r\u0011\"\u0001\u0002\u001a!I\u00111\u0004\u0001\u0003\u0012\u0003\u0006I\u0001\u001a\u0005\b\u0003;\u0001A\u0011AA\u0010\u0011\u001d\tI\u0004\u0001C!\u0003wA\u0011\"!\u0014\u0001\u0003\u0003%\t!a\u0014\t\u0013\u0005]\u0005!%A\u0005\u0002\u0005e\u0005\"CAd\u0001E\u0005I\u0011AAe\u0011%\t)\u000fAI\u0001\n\u0003\t9\u000fC\u0005\u0003\u0004\u0001\t\n\u0011\"\u0001\u0003\u0006!I!\u0011\u0005\u0001\u0012\u0002\u0013\u0005!1\u0005\u0005\n\u0005\u007f\u0001\u0011\u0013!C\u0001\u0005\u0003B\u0011B!\u0018\u0001#\u0003%\tAa\u0018\t\u0013\tm\u0004!%A\u0005\u0002\tu\u0004\"\u0003BM\u0001E\u0005I\u0011\u0001BN\u0011%\u00119\fAI\u0001\n\u0003\u0011I\fC\u0005\u0003V\u0002\t\n\u0011\"\u0001\u0003X\"I!1\u001f\u0001\u0002\u0002\u0013\u0005#Q\u001f\u0005\n\u0005o\u0004\u0011\u0011!C!\u0005sD\u0011ba\u0002\u0001\u0003\u0003%\ta!\u0003\t\u0013\rU\u0001!!A\u0005B\r]\u0001\"CB\u0010\u0001\u0005\u0005I\u0011IB\u0011\u000f%\u0019)CMA\u0001\u0012\u0003\u00199C\u0002\u00052e\u0005\u0005\t\u0012AB\u0015\u0011\u001d\tib\u000bC\u0001\u0007WA\u0011\"!\u000f,\u0003\u0003%)%a\u000f\t\u0013\r52&!A\u0005\u0002\u000e=\u0002\"CB<W\u0005\u0005I\u0011QB=\u0011%\u0019)lKA\u0001\n\u0013\u00199LA\u0004UkBdW-M\u0019\u000b\u0003M\nQa]2bY\u0006\u001c\u0001!\u0006\u00077\u0001*k\u0005k\u0015,Z9~\u0013WmE\u0003\u0001om:'\u000e\u0005\u00029s5\t!'\u0003\u0002;e\t1\u0011I\\=SK\u001a\u0004R\u0002\u000f\u001f?\u00132{%+\u0016-\\=\u0006$\u0017BA\u001f3\u0005%\u0001&o\u001c3vGR\f\u0014\u0007\u0005\u0002@\u00012\u0001AAB!\u0001\t\u000b\u0007!I\u0001\u0002UcE\u00111I\u0012\t\u0003q\u0011K!!\u0012\u001a\u0003\u000f9{G\u000f[5oOB\u0011\u0001hR\u0005\u0003\u0011J\u00121!\u00118z!\ty$\n\u0002\u0004L\u0001\u0011\u0015\rA\u0011\u0002\u0003)J\u0002\"aP'\u0005\r9\u0003AQ1\u0001C\u0005\t!6\u0007\u0005\u0002@!\u00121\u0011\u000b\u0001CC\u0002\t\u0013!\u0001\u0016\u001b\u0011\u0005}\u001aFA\u0002+\u0001\t\u000b\u0007!I\u0001\u0002UkA\u0011qH\u0016\u0003\u0007/\u0002!)\u0019\u0001\"\u0003\u0005Q3\u0004CA Z\t\u0019Q\u0006\u0001\"b\u0001\u0005\n\u0011Ak\u000e\t\u0003\u007fq#a!\u0018\u0001\u0005\u0006\u0004\u0011%A\u0001+9!\tyt\f\u0002\u0004a\u0001\u0011\u0015\rA\u0011\u0002\u0003)f\u0002\"a\u00102\u0005\r\r\u0004AQ1\u0001C\u0005\r!\u0016\u0007\r\t\u0003\u007f\u0015$aA\u001a\u0001\u0005\u0006\u0004\u0011%a\u0001+2cA\u0011\u0001\b[\u0005\u0003SJ\u0012q\u0001\u0015:pIV\u001cG\u000f\u0005\u00029W&\u0011AN\r\u0002\r'\u0016\u0014\u0018.\u00197ju\u0006\u0014G.Z\u0001\u0003?F*\u0012AP\u0001\u0004?F\u0002\u0013AA03+\u0005I\u0015aA03A\u0005\u0011qlM\u000b\u0002\u0019\u0006\u0019ql\r\u0011\u0002\u0005}#T#A(\u0002\u0007}#\u0004%\u0001\u0002`kU\t!+A\u0002`k\u0001\n!a\u0018\u001c\u0016\u0003U\u000b1a\u0018\u001c!\u0003\tyv'F\u0001Y\u0003\ryv\u0007I\u0001\u0003?b*\u0012aW\u0001\u0004?b\u0002\u0013AA0:+\u0005q\u0016aA0:A\u0005\u0019q,\r\u0019\u0016\u0003\u0005\fAaX\u00191A\u0005\u0019q,M\u0019\u0016\u0003\u0011\fAaX\u00192A\u00051A(\u001b8jiz\"\u0002$!\t\u0002$\u0005\u0015\u0012qEA\u0015\u0003W\ti#a\f\u00022\u0005M\u0012QGA\u001c!5A\u0004AP%M\u001fJ+\u0006l\u00170bI\")Qn\u0006a\u0001}!)\u0001o\u0006a\u0001\u0013\")1o\u0006a\u0001\u0019\")ao\u0006a\u0001\u001f\")\u0011p\u0006a\u0001%\")Ap\u0006a\u0001+\")qp\u0006a\u00011\"1\u0011QA\fA\u0002mCa!a\u0003\u0018\u0001\u0004q\u0006BBA\t/\u0001\u0007\u0011\r\u0003\u0004\u0002\u0018]\u0001\r\u0001Z\u0001\ti>\u001cFO]5oOR\u0011\u0011Q\b\t\u0005\u0003\u007f\tI%\u0004\u0002\u0002B)!\u00111IA#\u0003\u0011a\u0017M\\4\u000b\u0005\u0005\u001d\u0013\u0001\u00026bm\u0006LA!a\u0013\u0002B\t11\u000b\u001e:j]\u001e\fAaY8qsVA\u0012\u0011KA,\u00037\ny&a\u0019\u0002h\u0005-\u0014qNA:\u0003o\nY(a \u00151\u0005M\u0013\u0011QAB\u0003\u000b\u000b9)!#\u0002\f\u00065\u0015qRAI\u0003'\u000b)\n\u0005\r9\u0001\u0005U\u0013\u0011LA/\u0003C\n)'!\u001b\u0002n\u0005E\u0014QOA=\u0003{\u00022aPA,\t\u0015\t\u0015D1\u0001C!\ry\u00141\f\u0003\u0006\u0017f\u0011\rA\u0011\t\u0004\u007f\u0005}C!\u0002(\u001a\u0005\u0004\u0011\u0005cA \u0002d\u0011)\u0011+\u0007b\u0001\u0005B\u0019q(a\u001a\u0005\u000bQK\"\u0019\u0001\"\u0011\u0007}\nY\u0007B\u0003X3\t\u0007!\tE\u0002@\u0003_\"QAW\rC\u0002\t\u00032aPA:\t\u0015i\u0016D1\u0001C!\ry\u0014q\u000f\u0003\u0006Af\u0011\rA\u0011\t\u0004\u007f\u0005mD!B2\u001a\u0005\u0004\u0011\u0005cA \u0002\u0000\u0011)a-\u0007b\u0001\u0005\"AQ.\u0007I\u0001\u0002\u0004\t)\u0006\u0003\u0005q3A\u0005\t\u0019AA-\u0011!\u0019\u0018\u0004%AA\u0002\u0005u\u0003\u0002\u0003<\u001a!\u0003\u0005\r!!\u0019\t\u0011eL\u0002\u0013!a\u0001\u0003KB\u0001\u0002`\r\u0011\u0002\u0003\u0007\u0011\u0011\u000e\u0005\t\u007ff\u0001\n\u00111\u0001\u0002n!I\u0011QA\r\u0011\u0002\u0003\u0007\u0011\u0011\u000f\u0005\n\u0003\u0017I\u0002\u0013!a\u0001\u0003kB\u0011\"!\u0005\u001a!\u0003\u0005\r!!\u001f\t\u0013\u0005]\u0011\u0004%AA\u0002\u0005u\u0014AD2paf$C-\u001a4bk2$H%M\u000b\u0019\u00037\u000b\t,a-\u00026\u0006]\u0016\u0011XA^\u0003{\u000by,!1\u0002D\u0006\u0015WCAAOU\rq\u0014qT\u0016\u0003\u0003C\u0003B!a)\u0002.6\u0011\u0011Q\u0015\u0006\u0005\u0003O\u000bI+A\u0005v]\u000eDWmY6fI*\u0019\u00111\u0016\u001a\u0002\u0015\u0005tgn\u001c;bi&|g.\u0003\u0003\u00020\u0006\u0015&!E;oG\",7m[3e-\u0006\u0014\u0018.\u00198dK\u0012)\u0011I\u0007b\u0001\u0005\u0012)1J\u0007b\u0001\u0005\u0012)aJ\u0007b\u0001\u0005\u0012)\u0011K\u0007b\u0001\u0005\u0012)AK\u0007b\u0001\u0005\u0012)qK\u0007b\u0001\u0005\u0012)!L\u0007b\u0001\u0005\u0012)QL\u0007b\u0001\u0005\u0012)\u0001M\u0007b\u0001\u0005\u0012)1M\u0007b\u0001\u0005\u0012)aM\u0007b\u0001\u0005\u0006q1m\u001c9zI\u0011,g-Y;mi\u0012\u0012T\u0003GAf\u0003\u001f\f\t.a5\u0002V\u0006]\u0017\u0011\\An\u0003;\fy.!9\u0002dV\u0011\u0011Q\u001a\u0016\u0004\u0013\u0006}E!B!\u001c\u0005\u0004\u0011E!B&\u001c\u0005\u0004\u0011E!\u0002(\u001c\u0005\u0004\u0011E!B)\u001c\u0005\u0004\u0011E!\u0002+\u001c\u0005\u0004\u0011E!B,\u001c\u0005\u0004\u0011E!\u0002.\u001c\u0005\u0004\u0011E!B/\u001c\u0005\u0004\u0011E!\u00021\u001c\u0005\u0004\u0011E!B2\u001c\u0005\u0004\u0011E!\u00024\u001c\u0005\u0004\u0011\u0015AD2paf$C-\u001a4bk2$HeM\u000b\u0019\u0003S\fi/a<\u0002r\u0006M\u0018Q_A|\u0003s\fY0!@\u0002\u0000\n\u0005QCAAvU\ra\u0015q\u0014\u0003\u0006\u0003r\u0011\rA\u0011\u0003\u0006\u0017r\u0011\rA\u0011\u0003\u0006\u001dr\u0011\rA\u0011\u0003\u0006#r\u0011\rA\u0011\u0003\u0006)r\u0011\rA\u0011\u0003\u0006/r\u0011\rA\u0011\u0003\u00065r\u0011\rA\u0011\u0003\u0006;r\u0011\rA\u0011\u0003\u0006Ar\u0011\rA\u0011\u0003\u0006Gr\u0011\rA\u0011\u0003\u0006Mr\u0011\rAQ\u0001\u000fG>\u0004\u0018\u0010\n3fM\u0006,H\u000e\u001e\u00135+a\u00119Aa\u0003\u0003\u000e\t=!\u0011\u0003B\n\u0005+\u00119B!\u0007\u0003\u001c\tu!qD\u000b\u0003\u0005\u0013Q3aTAP\t\u0015\tUD1\u0001C\t\u0015YUD1\u0001C\t\u0015qUD1\u0001C\t\u0015\tVD1\u0001C\t\u0015!VD1\u0001C\t\u00159VD1\u0001C\t\u0015QVD1\u0001C\t\u0015iVD1\u0001C\t\u0015\u0001WD1\u0001C\t\u0015\u0019WD1\u0001C\t\u00151WD1\u0001C\u00039\u0019w\u000e]=%I\u00164\u0017-\u001e7uIU*\u0002D!\n\u0003*\t-\"Q\u0006B\u0018\u0005c\u0011\u0019D!\u000e\u00038\te\"1\bB\u001f+\t\u00119CK\u0002S\u0003?#Q!\u0011\u0010C\u0002\t#Qa\u0013\u0010C\u0002\t#QA\u0014\u0010C\u0002\t#Q!\u0015\u0010C\u0002\t#Q\u0001\u0016\u0010C\u0002\t#Qa\u0016\u0010C\u0002\t#QA\u0017\u0010C\u0002\t#Q!\u0018\u0010C\u0002\t#Q\u0001\u0019\u0010C\u0002\t#Qa\u0019\u0010C\u0002\t#QA\u001a\u0010C\u0002\t\u000babY8qs\u0012\"WMZ1vYR$c'\u0006\r\u0003D\t\u001d#\u0011\nB&\u0005\u001b\u0012yE!\u0015\u0003T\tU#q\u000bB-\u00057*\"A!\u0012+\u0007U\u000by\nB\u0003B?\t\u0007!\tB\u0003L?\t\u0007!\tB\u0003O?\t\u0007!\tB\u0003R?\t\u0007!\tB\u0003U?\t\u0007!\tB\u0003X?\t\u0007!\tB\u0003[?\t\u0007!\tB\u0003^?\t\u0007!\tB\u0003a?\t\u0007!\tB\u0003d?\t\u0007!\tB\u0003g?\t\u0007!)\u0001\bd_BLH\u0005Z3gCVdG\u000fJ\u001c\u00161\t\u0005$Q\rB4\u0005S\u0012YG!\u001c\u0003p\tE$1\u000fB;\u0005o\u0012I(\u0006\u0002\u0003d)\u001a\u0001,a(\u0005\u000b\u0005\u0003#\u0019\u0001\"\u0005\u000b-\u0003#\u0019\u0001\"\u0005\u000b9\u0003#\u0019\u0001\"\u0005\u000bE\u0003#\u0019\u0001\"\u0005\u000bQ\u0003#\u0019\u0001\"\u0005\u000b]\u0003#\u0019\u0001\"\u0005\u000bi\u0003#\u0019\u0001\"\u0005\u000bu\u0003#\u0019\u0001\"\u0005\u000b\u0001\u0004#\u0019\u0001\"\u0005\u000b\r\u0004#\u0019\u0001\"\u0005\u000b\u0019\u0004#\u0019\u0001\"\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%qUA\"q\u0010BB\u0005\u000b\u00139I!#\u0003\f\n5%q\u0012BI\u0005'\u0013)Ja&\u0016\u0005\t\u0005%fA.\u0002 \u0012)\u0011)\tb\u0001\u0005\u0012)1*\tb\u0001\u0005\u0012)a*\tb\u0001\u0005\u0012)\u0011+\tb\u0001\u0005\u0012)A+\tb\u0001\u0005\u0012)q+\tb\u0001\u0005\u0012)!,\tb\u0001\u0005\u0012)Q,\tb\u0001\u0005\u0012)\u0001-\tb\u0001\u0005\u0012)1-\tb\u0001\u0005\u0012)a-\tb\u0001\u0005\u0006q1m\u001c9zI\u0011,g-Y;mi\u0012JT\u0003\u0007BO\u0005C\u0013\u0019K!*\u0003(\n%&1\u0016BW\u0005_\u0013\tLa-\u00036V\u0011!q\u0014\u0016\u0004=\u0006}E!B!#\u0005\u0004\u0011E!B&#\u0005\u0004\u0011E!\u0002(#\u0005\u0004\u0011E!B)#\u0005\u0004\u0011E!\u0002+#\u0005\u0004\u0011E!B,#\u0005\u0004\u0011E!\u0002.#\u0005\u0004\u0011E!B/#\u0005\u0004\u0011E!\u00021#\u0005\u0004\u0011E!B2#\u0005\u0004\u0011E!\u00024#\u0005\u0004\u0011\u0015aD2paf$C-\u001a4bk2$H%\r\u0019\u00161\tm&q\u0018Ba\u0005\u0007\u0014)Ma2\u0003J\n-'Q\u001aBh\u0005#\u0014\u0019.\u0006\u0002\u0003>*\u001a\u0011-a(\u0005\u000b\u0005\u001b#\u0019\u0001\"\u0005\u000b-\u001b#\u0019\u0001\"\u0005\u000b9\u001b#\u0019\u0001\"\u0005\u000bE\u001b#\u0019\u0001\"\u0005\u000bQ\u001b#\u0019\u0001\"\u0005\u000b]\u001b#\u0019\u0001\"\u0005\u000bi\u001b#\u0019\u0001\"\u0005\u000bu\u001b#\u0019\u0001\"\u0005\u000b\u0001\u001c#\u0019\u0001\"\u0005\u000b\r\u001c#\u0019\u0001\"\u0005\u000b\u0019\u001c#\u0019\u0001\"\u0002\u001f\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%cE*\u0002D!7\u0003^\n}'\u0011\u001dBr\u0005K\u00149O!;\u0003l\n5(q\u001eBy+\t\u0011YNK\u0002e\u0003?#Q!\u0011\u0013C\u0002\t#Qa\u0013\u0013C\u0002\t#QA\u0014\u0013C\u0002\t#Q!\u0015\u0013C\u0002\t#Q\u0001\u0016\u0013C\u0002\t#Qa\u0016\u0013C\u0002\t#QA\u0017\u0013C\u0002\t#Q!\u0018\u0013C\u0002\t#Q\u0001\u0019\u0013C\u0002\t#Qa\u0019\u0013C\u0002\t#QA\u001a\u0013C\u0002\t\u000bQ\u0002\u001d:pIV\u001cG\u000f\u0015:fM&DXCAA\u001f\u0003=\u0001(o\u001c3vGRLE/\u001a:bi>\u0014XC\u0001B~!\u0015\u0011ipa\u0001G\u001b\t\u0011yPC\u0002\u0004\u0002I\n!bY8mY\u0016\u001cG/[8o\u0013\u0011\u0019)Aa@\u0003\u0011%#XM]1u_J\f\u0001bY1o\u000bF,\u0018\r\u001c\u000b\u0005\u0007\u0017\u0019\t\u0002E\u00029\u0007\u001bI1aa\u00043\u0005\u001d\u0011un\u001c7fC:D\u0001ba\u0005(\u0003\u0003\u0005\rAR\u0001\u0004q\u0012\n\u0014\u0001\u00035bg\"\u001cu\u000eZ3\u0015\u0005\re\u0001c\u0001\u001d\u0004\u001c%\u00191Q\u0004\u001a\u0003\u0007%sG/\u0001\u0004fcV\fGn\u001d\u000b\u0005\u0007\u0017\u0019\u0019\u0003\u0003\u0005\u0004\u0014%\n\t\u00111\u0001G\u0003\u001d!V\u000f\u001d7fcE\u0002\"\u0001O\u0016\u0014\u0007-:$\u000e\u0006\u0002\u0004(\u0005)\u0011\r\u001d9msVA2\u0011GB\u001c\u0007w\u0019yda\u0011\u0004H\r-3qJB*\u0007/\u001aYfa\u0018\u00151\rM2\u0011MB2\u0007K\u001a9g!\u001b\u0004l\r54qNB9\u0007g\u001a)\b\u0005\r9\u0001\rU2\u0011HB\u001f\u0007\u0003\u001a)e!\u0013\u0004N\rE3QKB-\u0007;\u00022aPB\u001c\t\u0015\teF1\u0001C!\ry41\b\u0003\u0006\u0017:\u0012\rA\u0011\t\u0004\u007f\r}B!\u0002(/\u0005\u0004\u0011\u0005cA \u0004D\u0011)\u0011K\fb\u0001\u0005B\u0019qha\u0012\u0005\u000bQs#\u0019\u0001\"\u0011\u0007}\u001aY\u0005B\u0003X]\t\u0007!\tE\u0002@\u0007\u001f\"QA\u0017\u0018C\u0002\t\u00032aPB*\t\u0015ifF1\u0001C!\ry4q\u000b\u0003\u0006A:\u0012\rA\u0011\t\u0004\u007f\rmC!B2/\u0005\u0004\u0011\u0005cA \u0004`\u0011)aM\fb\u0001\u0005\"1QN\fa\u0001\u0007kAa\u0001\u001d\u0018A\u0002\re\u0002BB:/\u0001\u0004\u0019i\u0004\u0003\u0004w]\u0001\u00071\u0011\t\u0005\u0007s:\u0002\ra!\u0012\t\rqt\u0003\u0019AB%\u0011\u0019yh\u00061\u0001\u0004N!9\u0011Q\u0001\u0018A\u0002\rE\u0003bBA\u0006]\u0001\u00071Q\u000b\u0005\b\u0003#q\u0003\u0019AB-\u0011\u001d\t9B\fa\u0001\u0007;\nq!\u001e8baBd\u00170\u0006\r\u0004|\r\u001d51RBH\u0007'\u001b9ja'\u0004 \u000e\r6qUBV\u0007_#Ba! \u00042B)\u0001ha \u0004\u0004&\u00191\u0011\u0011\u001a\u0003\r=\u0003H/[8o!aA\u0004a!\"\u0004\n\u000e55\u0011SBK\u00073\u001bij!)\u0004&\u000e%6Q\u0016\t\u0004\u007f\r\u001dE!B!0\u0005\u0004\u0011\u0005cA \u0004\f\u0012)1j\fb\u0001\u0005B\u0019qha$\u0005\u000b9{#\u0019\u0001\"\u0011\u0007}\u001a\u0019\nB\u0003R_\t\u0007!\tE\u0002@\u0007/#Q\u0001V\u0018C\u0002\t\u00032aPBN\t\u00159vF1\u0001C!\ry4q\u0014\u0003\u00065>\u0012\rA\u0011\t\u0004\u007f\r\rF!B/0\u0005\u0004\u0011\u0005cA \u0004(\u0012)\u0001m\fb\u0001\u0005B\u0019qha+\u0005\u000b\r|#\u0019\u0001\"\u0011\u0007}\u001ay\u000bB\u0003g_\t\u0007!\tC\u0005\u00044>\n\t\u00111\u0001\u0004\u0004\u0006\u0019\u0001\u0010\n\u0019\u0002\u0017I,\u0017\r\u001a*fg>dg/\u001a\u000b\u0003\u0007s\u0003B!a\u0010\u0004<&!1QXA!\u0005\u0019y%M[3di\u0002")
public final class Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>
implements Product11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>,
Serializable {
    private final T1 _1;
    private final T2 _2;
    private final T3 _3;
    private final T4 _4;
    private final T5 _5;
    private final T6 _6;
    private final T7 _7;
    private final T8 _8;
    private final T9 _9;
    private final T10 _10;
    private final T11 _11;

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> Option<Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>> unapply(Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> tuple11) {
        return Tuple11$.MODULE$.unapply(tuple11);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> apply(T1 T1, T2 T2, T3 T3, T4 T4, T5 T5, T6 T6, T7 T7, T8 T8, T9 T9, T10 T10, T11 T11) {
        return Tuple11$.MODULE$.apply(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11);
    }

    @Override
    public int productArity() {
        return Product11.productArity$(this);
    }

    @Override
    public Object productElement(int n) throws IndexOutOfBoundsException {
        return Product11.productElement$(this, n);
    }

    @Override
    public T1 _1() {
        return this._1;
    }

    @Override
    public T2 _2() {
        return this._2;
    }

    @Override
    public T3 _3() {
        return this._3;
    }

    @Override
    public T4 _4() {
        return this._4;
    }

    @Override
    public T5 _5() {
        return this._5;
    }

    @Override
    public T6 _6() {
        return this._6;
    }

    @Override
    public T7 _7() {
        return this._7;
    }

    @Override
    public T8 _8() {
        return this._8;
    }

    @Override
    public T9 _9() {
        return this._9;
    }

    @Override
    public T10 _10() {
        return this._10;
    }

    @Override
    public T11 _11() {
        return this._11;
    }

    public String toString() {
        return new StringBuilder(12).append("(").append(this._1()).append(",").append(this._2()).append(",").append(this._3()).append(",").append(this._4()).append(",").append(this._5()).append(",").append(this._6()).append(",").append(this._7()).append(",").append(this._8()).append(",").append(this._9()).append(",").append(this._10()).append(",").append(this._11()).append(")").toString();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> copy(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5, T6 _6, T7 _7, T8 _8, T9 _9, T10 _10, T11 _11) {
        return new Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11);
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> T1 copy$default$1() {
        return this._1();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> T10 copy$default$10() {
        return this._10();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> T11 copy$default$11() {
        return this._11();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> T2 copy$default$2() {
        return this._2();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> T3 copy$default$3() {
        return this._3();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> T4 copy$default$4() {
        return this._4();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> T5 copy$default$5() {
        return this._5();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> T6 copy$default$6() {
        return this._6();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> T7 copy$default$7() {
        return this._7();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> T8 copy$default$8() {
        return this._8();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> T9 copy$default$9() {
        return this._9();
    }

    @Override
    public String productPrefix() {
        return "Tuple11";
    }

    @Override
    public Iterator<Object> productIterator() {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    @Override
    public boolean canEqual(Object x$1) {
        return x$1 instanceof Tuple11;
    }

    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode(this);
    }

    @Override
    public boolean equals(Object x$1) {
        block3: {
            block2: {
                if (this == x$1) break block2;
                boolean bl = x$1 instanceof Tuple11;
                if (!bl) break block3;
                Tuple11 tuple11 = (Tuple11)x$1;
                if (!(BoxesRunTime.equals(this._1(), tuple11._1()) && BoxesRunTime.equals(this._2(), tuple11._2()) && BoxesRunTime.equals(this._3(), tuple11._3()) && BoxesRunTime.equals(this._4(), tuple11._4()) && BoxesRunTime.equals(this._5(), tuple11._5()) && BoxesRunTime.equals(this._6(), tuple11._6()) && BoxesRunTime.equals(this._7(), tuple11._7()) && BoxesRunTime.equals(this._8(), tuple11._8()) && BoxesRunTime.equals(this._9(), tuple11._9()) && BoxesRunTime.equals(this._10(), tuple11._10()) && BoxesRunTime.equals(this._11(), tuple11._11()))) break block3;
            }
            return true;
        }
        return false;
    }

    public Tuple11(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5, T6 _6, T7 _7, T8 _8, T9 _9, T10 _10, T11 _11) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        this._4 = _4;
        this._5 = _5;
        this._6 = _6;
        this._7 = _7;
        this._8 = _8;
        this._9 = _9;
        this._10 = _10;
        this._11 = _11;
        Product.$init$(this);
        Product11.$init$(this);
    }
}

