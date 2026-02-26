/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import java.util.Arrays;
import java.util.NoSuchElementException;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.None$;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.BufferedIterator;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.Growable;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.AbstractMap;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.LongMap$;
import scala.collection.mutable.ReusableBuilder;
import scala.collection.mutable.StringBuilder;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@ScalaSignature(bytes="\u0006\u0001\ruf\u0001B(Q\u0005]C\u0001B\u001e\u0001\u0003\u0002\u0003\u0006Ia\u001e\u0005\tu\u0002\u0011\t\u0011)A\u0005w\"Aa\u0010\u0001B\u0001B\u0003%q\u0010\u0003\u0005\u0002\u0006\u0001!\tAUA\u0004\u0011\u001d\t)\u0001\u0001C\u0001\u0003\u001fAq!!\u0002\u0001\t\u0003\t\t\u0002C\u0004\u0002\u0006\u0001!\t!!\u0006\t\u000f\u0005\u0015\u0001\u0001\"\u0001\u0002\u001a!9\u0011q\u0004\u0001!B\u0013Y\bbBA\u0011\u0001\u0001\u0006Ka\u001f\u0005\t\u0003G\u0001\u0001\u0015)\u0003\u0002&!A\u00111\u0006\u0001!B\u0013\t)\u0003C\u0004\u0002.\u0001\u0001\u000b\u0015B>\t\u000f\u0005=\u0002\u0001)Q\u0005w\"A\u0011\u0011\u0007\u0001!B\u0013\t\u0019\u0004\u0003\u0005\u0002:\u0001\u0001\u000b\u0015BA\u001e\u0011!\ti\u0004\u0001Q\u0005\n\u0005}\u0002\u0002CA&\u0001\u0011\u0005!+!\u0014\t\u000f\u0005=\u0004\u0001\"\u0011\u0002r!9\u00111\u000f\u0001\u0005B\u0005U\u0004bBA<\u0001\u0011%\u0011\u0011\u0010\u0005\b\u0003w\u0002A\u0011BA?\u0011\u001d\t\u0019\t\u0001C\u0005\u0003\u000bCq!!#\u0001\t\u0013\tY\tC\u0004\u0002\u0010\u0002!I!!%\t\u000f\u0005U\u0005\u0001\"\u0011\u0002\u0018\"9\u0011Q\u0014\u0001\u0005B\u0005}\u0005bBAU\u0001\u0011\u0005\u00131\u0016\u0005\b\u0003\u0007\u0004A\u0011IAc\u0011\u001d\ty\r\u0001C\u0001\u0003#Dq!!6\u0001\t\u0003\n9\u000eC\u0004\u0002<\u0002!\t%a7\t\u000f\u0005}\u0007\u0001\"\u0003\u0002b\"9\u0011q\u001c\u0001\u0005\u0002\u0005\u001d\bbBAu\u0001\u0011\u0005\u00131\u001e\u0005\b\u0003g\u0004A\u0011IA{\u0011\u001d\tY\u0010\u0001C\u0001\u0003{Dq!a?\u0001\t\u0003\u0011)\u0001C\u0004\u0003\u0012\u0001!\tAa\u0005\t\u000f\t]\u0001\u0001\"\u0001\u0003\u001a!9!1\u0005\u0001\u0005B\t\u0015\u0002b\u0002B\u001b\u0001\u0011\u0005\u0013q\u0002\u0005\b\u0005o\u0001A\u0011\tB\u001d\u0011\u001d\u00119\u0005\u0001C!\u0005\u0013BqAa\u0018\u0001\t\u0003\u0012\t\u0007C\u0004\u0003p\u0001!\tA!\u001d\t\u000f\t}\u0004\u0001\"\u0001\u0003\u0002\"9!Q\u0012\u0001\u0005\u0002\t=\u0005b\u0002BO\u0001\u0011\u0005!qT\u0004\b\u0005K\u0003\u0006\u0012\u0001BT\r\u0019y\u0005\u000b#\u0001\u0003*\"9\u0011QA\u001a\u0005\u0002\t-\u0006\"\u0003BWg\t\u0007IQ\u0002BX\u0011!\u0011)l\rQ\u0001\u000e\tE\u0006\"\u0003B\\g\t\u0007IQ\u0002B]\u0011!\u0011yl\rQ\u0001\u000e\tm\u0006\"\u0003Bag\t\u0007IQ\u0002Bb\u0011!\u0011Im\rQ\u0001\u000e\t\u0015\u0007\"\u0003Bfg\t\u0007IQ\u0002Bg\u0011!\u0011\u0019n\rQ\u0001\u000e\t=\u0007\"\u0003Bkg\t\u0007I\u0011\u0002Bl\u0011!\u0011Yn\rQ\u0001\n\te\u0007b\u0002Bog\u0011\r!q\u001c\u0005\t\u0005{\u001c\u0004\u0015!\u0003\u0003\u0000\u001a111C\u001a\u0003\u0007+Aq!!\u0002B\t\u0003\u00199\u0003\u0003\u0006\u0004,\u0005\u0003\r\u0011\"\u0001S\u0007[A!ba\fB\u0001\u0004%\tAUB\u0019\u0011!\u00199$\u0011Q!\n\r\u0015\u0002bBA~\u0003\u0012\u00051\u0011\b\u0005\b\u0007\u0003\nE\u0011AAt\u0011\u001d\u0019\u0019%\u0011C\u0001\u0007\u000bBq!!64\t\u0003\u0019y\u0005C\u0004\u0002tM\"\taa\u0019\t\u000f\r54\u0007\"\u0001\u0004p!91QP\u001a\u0005\u0002\r}\u0004bBB?g\u0011\u000511\u0013\u0005\n\u0007S\u001b\u0014\u0011!C\u0005\u0007W\u0013q\u0001T8oO6\u000b\u0007O\u0003\u0002R%\u00069Q.\u001e;bE2,'BA*U\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002+\u0006)1oY1mC\u000e\u0001QC\u0001-d'\u0015\u0001\u0011\f\\8t!\u0011Q6,X1\u000e\u0003AK!\u0001\u0018)\u0003\u0017\u0005\u00137\u000f\u001e:bGRl\u0015\r\u001d\t\u0003=~k\u0011\u0001V\u0005\u0003AR\u0013A\u0001T8oOB\u0011!m\u0019\u0007\u0001\t\u0015!\u0007A1\u0001f\u0005\u00051\u0016C\u00014j!\tqv-\u0003\u0002i)\n9aj\u001c;iS:<\u0007C\u00010k\u0013\tYGKA\u0002B]f\u0004BAW7^C&\u0011a\u000e\u0015\u0002\u0004\u001b\u0006\u0004\b#\u0002.q;\u0006\u0014\u0018BA9Q\u0005\u001di\u0015\r\u001d'jW\u0016\u00042A\u0017\u0001b!\tqF/\u0003\u0002v)\na1+\u001a:jC2L'0\u00192mK\u0006aA-\u001a4bk2$XI\u001c;ssB!a\f_/b\u0013\tIHKA\u0005Gk:\u001cG/[8oc\u0005\t\u0012N\\5uS\u0006d')\u001e4gKJ\u001c\u0016N_3\u0011\u0005yc\u0018BA?U\u0005\rIe\u000e^\u0001\nS:LGO\u00117b].\u00042AXA\u0001\u0013\r\t\u0019\u0001\u0016\u0002\b\u0005>|G.Z1o\u0003\u0019a\u0014N\\5u}Q9!/!\u0003\u0002\f\u00055\u0001\"\u0002<\u0005\u0001\u00049\b\"\u0002>\u0005\u0001\u0004Y\b\"\u0002@\u0005\u0001\u0004yH#\u0001:\u0015\u0007I\f\u0019\u0002C\u0003w\r\u0001\u0007q\u000fF\u0002s\u0003/AQA_\u0004A\u0002m$RA]A\u000e\u0003;AQA\u001e\u0005A\u0002]DQA\u001f\u0005A\u0002m\fA!\\1tW\u0006IQ\r\u001f;sC.+\u0017p]\u0001\nu\u0016\u0014xNV1mk\u0016\u00042AXA\u0014\u0013\r\tI\u0003\u0016\u0002\u0007\u0003:L(+\u001a4\u0002\u00115LgNV1mk\u0016\fQaX:ju\u0016\fqa\u0018<bG\u0006tG/A\u0003`W\u0016L8\u000f\u0005\u0003_\u0003ki\u0016bAA\u001c)\n)\u0011I\u001d:bs\u00069qL^1mk\u0016\u001c\b#\u00020\u00026\u0005\u0015\u0012!\u00053fM\u0006,H\u000e^%oSRL\u0017\r\\5{KR!\u0011\u0011IA$!\rq\u00161I\u0005\u0004\u0003\u000b\"&\u0001B+oSRDa!!\u0013\u0012\u0001\u0004Y\u0018!\u00018\u0002\u0019%t\u0017\u000e^5bY&TX\rV8\u0015%\u0005\u0005\u0013qJA*\u0003/\nY&a\u0018\u0002d\u0005\u001d\u00141\u000e\u0005\u0007\u0003#\u0012\u0002\u0019A>\u0002\u00035Da!!\u0016\u0013\u0001\u0004Y\u0018AA3l\u0011\u001d\tIF\u0005a\u0001\u0003K\t!A\u001f<\t\u000f\u0005u#\u00031\u0001\u0002&\u0005\u0011QN\u001e\u0005\u0007\u0003C\u0012\u0002\u0019A>\u0002\u0005MT\bBBA3%\u0001\u000710\u0001\u0002wG\"9\u0011\u0011\u000e\nA\u0002\u0005M\u0012AA6{\u0011\u001d\tiG\u0005a\u0001\u0003w\t!A\u001e>\u0002\tML'0Z\u000b\u0002w\u0006)Q-\u001c9usV\t!/\u0001\u0006j[\n\fG.\u00198dK\u0012,\u0012a`\u0001\bi>Le\u000eZ3y)\rY\u0018q\u0010\u0005\u0007\u0003\u00033\u0002\u0019A/\u0002\u0003-\f\u0011b]3fW\u0016k\u0007\u000f^=\u0015\u0007m\f9\t\u0003\u0004\u0002\u0002^\u0001\r!X\u0001\ng\u0016,7.\u00128uef$2a_AG\u0011\u0019\t\t\t\u0007a\u0001;\u0006y1/Z3l\u000b:$(/_(s\u001fB,g\u000eF\u0002|\u0003'Ca!!!\u001a\u0001\u0004i\u0016\u0001C2p]R\f\u0017N\\:\u0015\u0007}\fI\n\u0003\u0004\u0002\u001cj\u0001\r!X\u0001\u0004W\u0016L\u0018aA4fiR!\u0011\u0011UAT!\u0011q\u00161U1\n\u0007\u0005\u0015FK\u0001\u0004PaRLwN\u001c\u0005\u0007\u00037[\u0002\u0019A/\u0002\u0013\u001d,Go\u0014:FYN,W\u0003BAW\u0003c#b!a,\u00028\u0006e\u0006c\u00012\u00022\u00129\u00111\u0017\u000fC\u0002\u0005U&A\u0001,2#\t\t\u0017\u000e\u0003\u0004\u0002\u001cr\u0001\r!\u0018\u0005\t\u0003wcB\u00111\u0001\u0002>\u00069A-\u001a4bk2$\b#\u00020\u0002@\u0006=\u0016bAAa)\nAAHY=oC6,g(A\bhKR|%/\u00127tKV\u0003H-\u0019;f)\u0015\t\u0017qYAe\u0011\u0019\tY*\ba\u0001;\"A\u00111Z\u000f\u0005\u0002\u0004\ti-\u0001\u0007eK\u001a\fW\u000f\u001c;WC2,X\r\u0005\u0003_\u0003\u007f\u000b\u0017!C4fi>\u0013h*\u001e7m)\r\t\u00171\u001b\u0005\u0007\u00037s\u0002\u0019A/\u0002\u000b\u0005\u0004\b\u000f\\=\u0015\u0007\u0005\fI\u000e\u0003\u0004\u0002\u001c~\u0001\r!\u0018\u000b\u0004C\u0006u\u0007BBANA\u0001\u0007Q,\u0001\u0004sKB\f7m\u001b\u000b\u0005\u0003\u0003\n\u0019\u000f\u0003\u0004\u0002f\u0006\u0002\ra_\u0001\b]\u0016<X*Y:l)\t\t\t%A\u0002qkR$b!!)\u0002n\u0006=\bBBANG\u0001\u0007Q\f\u0003\u0004\u0002r\u000e\u0002\r!Y\u0001\u0006m\u0006dW/Z\u0001\u0007kB$\u0017\r^3\u0015\r\u0005\u0005\u0013q_A}\u0011\u0019\tY\n\na\u0001;\"1\u0011\u0011\u001f\u0013A\u0002\u0005\f\u0001\u0002\n9mkN$S-\u001d\u000b\u0007\u0003\u007f\u0014\tAa\u0001\u000e\u0003\u0001Aa!a'&\u0001\u0004i\u0006BBAyK\u0001\u0007\u0011\r\u0006\u0003\u0002\u0000\n\u001d\u0001b\u0002B\u0005M\u0001\u0007!1B\u0001\u0003WZ\u0004RA\u0018B\u0007;\u0006L1Aa\u0004U\u0005\u0019!V\u000f\u001d7fe\u0005IA%\\5okN$S-\u001d\u000b\u0005\u0003\u007f\u0014)\u0002\u0003\u0004\u0002\u001c\u001e\u0002\r!X\u0001\tSR,'/\u0019;peV\u0011!1\u0004\t\u0007\u0005;\u0011yBa\u0003\u000e\u0003IK1A!\tS\u0005!IE/\u001a:bi>\u0014\u0018a\u00024pe\u0016\f7\r[\u000b\u0005\u0005O\u0011\t\u0004\u0006\u0003\u0002B\t%\u0002b\u0002B\u0016S\u0001\u0007!QF\u0001\u0002MB1a\f\u001fB\u0006\u0005_\u00012A\u0019B\u0019\t\u0019\u0011\u0019$\u000bb\u0001K\n\tQ+A\u0003dY>tW-A\u0003%a2,8/\u0006\u0003\u0003<\t\u0005C\u0003\u0002B\u001f\u0005\u0007\u0002BA\u0017\u0001\u0003@A\u0019!M!\u0011\u0005\u000f\u0005M6F1\u0001\u00026\"9!\u0011B\u0016A\u0002\t\u0015\u0003C\u00020\u0003\u000eu\u0013y$\u0001\u0006%a2,8\u000f\n9mkN,BAa\u0013\u0003RQ!!Q\nB*!\u0011Q\u0006Aa\u0014\u0011\u0007\t\u0014\t\u0006B\u0004\u000242\u0012\r!!.\t\u000f\tUC\u00061\u0001\u0003X\u0005\u0011\u0001p\u001d\t\u0007\u0005;\u0011IF!\u0018\n\u0007\tm#K\u0001\nHK:$&/\u0019<feN\f'\r\\3P]\u000e,\u0007C\u00020\u0003\u000eu\u0013y%A\u0004va\u0012\fG/\u001a3\u0016\t\t\r$\u0011\u000e\u000b\u0007\u0005K\u0012YG!\u001c\u0011\ti\u0003!q\r\t\u0004E\n%DaBAZ[\t\u0007\u0011Q\u0017\u0005\u0007\u00037k\u0003\u0019A/\t\u000f\u0005EX\u00061\u0001\u0003h\u0005Qam\u001c:fC\u000eD7*Z=\u0016\t\tM$1\u0010\u000b\u0005\u0003\u0003\u0012)\bC\u0004\u0003,9\u0002\rAa\u001e\u0011\u000byCXL!\u001f\u0011\u0007\t\u0014Y\b\u0002\u0004\u0003~9\u0012\r!\u001a\u0002\u0002\u0003\u0006aam\u001c:fC\u000eDg+\u00197vKV!!1\u0011BF)\u0011\t\tE!\"\t\u000f\t-r\u00061\u0001\u0003\bB)a\f_1\u0003\nB\u0019!Ma#\u0005\r\tutF1\u0001f\u00031i\u0017\r\u001d,bYV,7OT8x+\u0011\u0011\tJa&\u0015\t\tM%\u0011\u0014\t\u00055\u0002\u0011)\nE\u0002c\u0005/#a!a-1\u0005\u0004)\u0007b\u0002B\u0016a\u0001\u0007!1\u0014\t\u0006=b\f'QS\u0001\u0010iJ\fgn\u001d4pe64\u0016\r\\;fgR!\u0011q BQ\u0011\u001d\u0011Y#\ra\u0001\u0005G\u0003BA\u0018=bC\u00069Aj\u001c8h\u001b\u0006\u0004\bC\u0001.4'\u0011\u0019\u0014QE:\u0015\u0005\t\u001d\u0016!C%oI\u0016DX*Y:l+\t\u0011\tl\u0004\u0002\u00034v!qh\u0000\u0000\u0000\u0004)Ie\u000eZ3y\u001b\u0006\u001c8\u000eI\u0001\u000b\u001b&\u001c8/\u001b8h\u0005&$XC\u0001B^\u001f\t\u0011i,\b\u0003\u0001\u0002\u0001\u0001\u0011aC'jgNLgn\u001a\"ji\u0002\n\u0011BV1dC:$()\u001b;\u0016\u0005\t\u0015wB\u0001Bd;\u0011\u0001\u0005\u0001\u0001\u0001\u0002\u0015Y\u000b7-\u00198u\u0005&$\b%\u0001\u0006NSN\u001ch+Y2b]R,\"Aa4\u0010\u0005\tEW\u0004\u0002a\u0001\u0001\u0001\t1\"T5tgZ\u000b7-\u00198uA\u0005\u0001R\r_2faRLwN\u001c#fM\u0006,H\u000e^\u000b\u0003\u00053\u0004BA\u0018=^M\u0006\tR\r_2faRLwN\u001c#fM\u0006,H\u000e\u001e\u0011\u0002\u0019\r\fgNQ;jY\u00124%o\\7\u0016\r\t\u0005(1\u001fB}+\t\u0011\u0019\u000f\u0005\u0006\u0003f\n-(q\u001eB{\u0005wl!Aa:\u000b\u0007\t%(+A\u0004hK:,'/[2\n\t\t5(q\u001d\u0002\r\u0007\u0006t')^5mI\u001a\u0013x.\u001c\t\u00055\u0002\u0011\t\u0010E\u0002c\u0005g$Q\u0001Z C\u0002\u0015\u0004bA\u0018B\u0007;\n]\bc\u00012\u0003z\u00121!1G C\u0002\u0015\u0004BA\u0017\u0001\u0003x\u0006Y!+Z;tC\ndWm\u0011\"G%\u0019\u0019\t!!\n\u0004\u0006\u0019111\u0001!\u0001\u0005\u007f\u0014A\u0002\u0010:fM&tW-\\3oiz\u0002\"B!:\u0003l\u000e\u001d1\u0011BB\u0004!\rQ\u0006!\u001b\t\u0006=\n5Q,\u001b\u0005\t\u0003+\u001c\t\u0001\"\u0001\u0004\u000eQ!1qBB$!\u0011\u0019\t\"Q5\u000e\u0003M\u0012a\u0002T8oO6\u000b\u0007OQ;jY\u0012,'/\u0006\u0003\u0004\u0018\r\r2#B!\u0002&\re\u0001c\u0002.\u0004\u001c\r}1QE\u0005\u0004\u0007;\u0001&a\u0004*fkN\f'\r\\3Ck&dG-\u001a:\u0011\ry\u0013i!XB\u0011!\r\u001171\u0005\u0003\u0006I\u0006\u0013\r!\u001a\t\u00055\u0002\u0019\t\u0003\u0006\u0002\u0004*A)1\u0011C!\u0004\"\u0005)Q\r\\3ngV\u00111QE\u0001\nK2,Wn]0%KF$B!!\u0011\u00044!I1Q\u0007#\u0002\u0002\u0003\u00071QE\u0001\u0004q\u0012\n\u0014AB3mK6\u001c\b\u0005\u0006\u0003\u0004<\ruR\"A!\t\u000f\r}b\t1\u0001\u0004 \u0005)QM\u001c;ss\u0006)1\r\\3be\u00061!/Z:vYR$\"a!\n\t\u0011\r%31\u0002a\u0001\u0007\u000f\tAA\u001a:p[\"A\u0011Q[B\u0001\t\u0003\u0019i\u0005\u0006\u0002\u0004\u0010U!1\u0011KB,)\u0011\u0019\u0019f!\u0017\u0011\ti\u00031Q\u000b\t\u0004E\u000e]C!\u00023J\u0005\u0004)\u0007bBB\u0016\u0013\u0002\u000711\f\t\u0006=\u000eu3\u0011M\u0005\u0004\u0007?\"&A\u0003\u001fsKB,\u0017\r^3e}A1aL!\u0004^\u0007+*Ba!\u001a\u0004lU\u00111q\r\t\u00055\u0002\u0019I\u0007E\u0002c\u0007W\"Q\u0001\u001a&C\u0002\u0015\f1b^5uQ\u0012+g-Y;miV!1\u0011OB<)\u0011\u0019\u0019h!\u001f\u0011\ti\u00031Q\u000f\t\u0004E\u000e]D!\u00023L\u0005\u0004)\u0007bBA^\u0017\u0002\u000711\u0010\t\u0006=bl6QO\u0001\bMJ|WNW5q+\u0011\u0019\tia\"\u0015\r\r\r5\u0011RBG!\u0011Q\u0006a!\"\u0011\u0007\t\u001c9\tB\u0003e\u0019\n\u0007Q\rC\u0004\u0004\f2\u0003\r!a\r\u0002\t-,\u0017p\u001d\u0005\b\u0007\u001fc\u0005\u0019ABI\u0003\u00191\u0018\r\\;fgB)a,!\u000e\u0004\u0006V!1QSBN)\u0019\u00199j!(\u0004&B!!\fABM!\r\u001171\u0014\u0003\u0006I6\u0013\r!\u001a\u0005\b\u0007\u0017k\u0005\u0019ABP!\u0015\u0011ib!)^\u0013\r\u0019\u0019K\u0015\u0002\t\u0013R,'/\u00192mK\"91qR'A\u0002\r\u001d\u0006C\u0002B\u000f\u0007C\u001bI*A\u0006sK\u0006$'+Z:pYZ,GCABW!\u0011\u0019yk!/\u000e\u0005\rE&\u0002BBZ\u0007k\u000bA\u0001\\1oO*\u00111qW\u0001\u0005U\u00064\u0018-\u0003\u0003\u0004<\u000eE&AB(cU\u0016\u001cG\u000f")
public final class LongMap<V>
extends AbstractMap<Object, V>
implements Serializable {
    private final Function1<Object, V> defaultEntry;
    private int mask;
    public int scala$collection$mutable$LongMap$$extraKeys;
    public Object scala$collection$mutable$LongMap$$zeroValue;
    public Object scala$collection$mutable$LongMap$$minValue;
    private int _size;
    private int _vacant;
    public long[] scala$collection$mutable$LongMap$$_keys;
    public Object[] scala$collection$mutable$LongMap$$_values;

    public static <V> LongMap<V> fromZip(Iterable<Object> iterable, Iterable<V> iterable2) {
        return LongMap$.MODULE$.fromZip(iterable, iterable2);
    }

    public static <V> LongMap<V> fromZip(long[] lArray, Object object) {
        return LongMap$.MODULE$.fromZip(lArray, object);
    }

    public static <V, U> CanBuildFrom<LongMap<V>, Tuple2<Object, U>, LongMap<U>> canBuildFrom() {
        return LongMap$.MODULE$.canBuildFrom();
    }

    private void defaultInitialize(int n) {
        this.mask = n < 0 ? 7 : (1 << 32 - Integer.numberOfLeadingZeros(n - 1)) - 1 & 0x3FFFFFFF | 7;
        this.scala$collection$mutable$LongMap$$_keys = new long[this.mask + 1];
        this.scala$collection$mutable$LongMap$$_values = new Object[this.mask + 1];
    }

    public void initializeTo(int m, int ek, Object zv, Object mv, int sz, int vc, long[] kz, Object[] vz) {
        this.mask = m;
        this.scala$collection$mutable$LongMap$$extraKeys = ek;
        this.scala$collection$mutable$LongMap$$zeroValue = zv;
        this.scala$collection$mutable$LongMap$$minValue = mv;
        this._size = sz;
        this._vacant = vc;
        this.scala$collection$mutable$LongMap$$_keys = kz;
        this.scala$collection$mutable$LongMap$$_values = vz;
    }

    @Override
    public int size() {
        return this._size + (this.scala$collection$mutable$LongMap$$extraKeys + 1) / 2;
    }

    @Override
    public LongMap<V> empty() {
        return new LongMap<V>();
    }

    private boolean imbalanced() {
        return (double)(this._size + this._vacant) > 0.5 * (double)this.mask || this._vacant > this._size;
    }

    private int toIndex(long k) {
        int h = (int)((k ^ k >>> 32) & 0xFFFFFFFFL);
        int x = (h ^ h >>> 16) * -2048144789;
        return (x ^ x >>> 13) & this.mask;
    }

    /*
     * WARNING - void declaration
     */
    private int seekEmpty(long k) {
        void var3_2;
        int e = this.toIndex(k);
        int x = 0;
        while (this.scala$collection$mutable$LongMap$$_keys[e] != 0L) {
            e = e + 2 * (++x + 1) * x - 3 & this.mask;
        }
        return (int)var3_2;
    }

    private int seekEntry(long k) {
        int e = this.toIndex(k);
        int x = 0;
        while (true) {
            long q;
            if ((q = this.scala$collection$mutable$LongMap$$_keys[e]) == k) {
                return e;
            }
            if (!(q != 0L)) break;
            e = e + 2 * (++x + 1) * x - 3 & this.mask;
        }
        return e | Integer.MIN_VALUE;
    }

    private int seekEntryOrOpen(long k) {
        long q;
        int e = this.toIndex(k);
        int x = 0;
        while (true) {
            if ((q = this.scala$collection$mutable$LongMap$$_keys[e]) == k) {
                return e;
            }
            if (!(q + q != 0L)) break;
            e = e + 2 * (++x + 1) * x - 3 & this.mask;
        }
        if (q == 0L) {
            return e | Integer.MIN_VALUE;
        }
        int o = e | 0xC0000000;
        while (true) {
            if ((q = this.scala$collection$mutable$LongMap$$_keys[e]) == k) {
                return e;
            }
            if (!(q != 0L)) break;
            e = e + 2 * (++x + 1) * x - 3 & this.mask;
        }
        return o;
    }

    @Override
    public boolean contains(long key) {
        if (key == -key) {
            return ((int)(key >>> 63) + 1 & this.scala$collection$mutable$LongMap$$extraKeys) != 0;
        }
        return this.seekEntry(key) >= 0;
    }

    @Override
    public Option<V> get(long key) {
        if (key == -key) {
            if (((int)(key >>> 63) + 1 & this.scala$collection$mutable$LongMap$$extraKeys) == 0) {
                return None$.MODULE$;
            }
            if (key == 0L) {
                return new Some<Object>(this.scala$collection$mutable$LongMap$$zeroValue);
            }
            return new Some<Object>(this.scala$collection$mutable$LongMap$$minValue);
        }
        int i = this.seekEntry(key);
        if (i < 0) {
            return None$.MODULE$;
        }
        return new Some<Object>(this.scala$collection$mutable$LongMap$$_values[i]);
    }

    @Override
    public <V1> V1 getOrElse(long key, Function0<V1> function0) {
        if (key == -key) {
            if (((int)(key >>> 63) + 1 & this.scala$collection$mutable$LongMap$$extraKeys) == 0) {
                return function0.apply();
            }
            if (key == 0L) {
                return (V1)this.scala$collection$mutable$LongMap$$zeroValue;
            }
            return (V1)this.scala$collection$mutable$LongMap$$minValue;
        }
        int i = this.seekEntry(key);
        if (i < 0) {
            return function0.apply();
        }
        return (V1)this.scala$collection$mutable$LongMap$$_values[i];
    }

    @Override
    public V getOrElseUpdate(long key, Function0<V> defaultValue) {
        if (key == -key) {
            int kbits = (int)(key >>> 63) + 1;
            if ((kbits & this.scala$collection$mutable$LongMap$$extraKeys) == 0) {
                V value = defaultValue.apply();
                this.scala$collection$mutable$LongMap$$extraKeys |= kbits;
                if (key == 0L) {
                    this.scala$collection$mutable$LongMap$$zeroValue = value;
                } else {
                    this.scala$collection$mutable$LongMap$$minValue = value;
                }
                return value;
            }
            if (key == 0L) {
                return (V)this.scala$collection$mutable$LongMap$$zeroValue;
            }
            return (V)this.scala$collection$mutable$LongMap$$minValue;
        }
        int i = this.seekEntryOrOpen(key);
        if (i < 0) {
            long[] ok = this.scala$collection$mutable$LongMap$$_keys;
            V v = defaultValue.apply();
            if (ok != this.scala$collection$mutable$LongMap$$_keys && (i = this.seekEntryOrOpen(key)) >= 0) {
                --this._size;
            }
            ++this._size;
            int j = i & 0x3FFFFFFF;
            this.scala$collection$mutable$LongMap$$_keys[j] = key;
            this.scala$collection$mutable$LongMap$$_values[j] = v;
            if ((i & 0x40000000) != 0) {
                --this._vacant;
            } else if (this.imbalanced()) {
                this.repack();
            }
            return v;
        }
        return (V)this.scala$collection$mutable$LongMap$$_values[i];
    }

    public V getOrNull(long key) {
        if (key == -key) {
            if (((int)(key >>> 63) + 1 & this.scala$collection$mutable$LongMap$$extraKeys) == 0) {
                return null;
            }
            if (key == 0L) {
                return (V)this.scala$collection$mutable$LongMap$$zeroValue;
            }
            return (V)this.scala$collection$mutable$LongMap$$minValue;
        }
        int i = this.seekEntry(key);
        if (i < 0) {
            return null;
        }
        return (V)this.scala$collection$mutable$LongMap$$_values[i];
    }

    @Override
    public V apply(long key) {
        if (key == -key) {
            if (((int)(key >>> 63) + 1 & this.scala$collection$mutable$LongMap$$extraKeys) == 0) {
                return this.defaultEntry.apply(BoxesRunTime.boxToLong(key));
            }
            if (key == 0L) {
                return (V)this.scala$collection$mutable$LongMap$$zeroValue;
            }
            return (V)this.scala$collection$mutable$LongMap$$minValue;
        }
        int i = this.seekEntry(key);
        if (i < 0) {
            return this.defaultEntry.apply(BoxesRunTime.boxToLong(key));
        }
        return (V)this.scala$collection$mutable$LongMap$$_values[i];
    }

    @Override
    public V default(long key) {
        return this.defaultEntry.apply(BoxesRunTime.boxToLong(key));
    }

    private void repack(int newMask) {
        long[] ok = this.scala$collection$mutable$LongMap$$_keys;
        Object[] ov = this.scala$collection$mutable$LongMap$$_values;
        this.mask = newMask;
        this.scala$collection$mutable$LongMap$$_keys = new long[this.mask + 1];
        this.scala$collection$mutable$LongMap$$_values = new Object[this.mask + 1];
        this._vacant = 0;
        for (int i = 0; i < ok.length; ++i) {
            long k = ok[i];
            if (k == -k) continue;
            int j = this.seekEmpty(k);
            this.scala$collection$mutable$LongMap$$_keys[j] = k;
            this.scala$collection$mutable$LongMap$$_values[j] = ov[i];
        }
    }

    public void repack() {
        int m = this.mask;
        if ((double)(this._size + this._vacant) >= 0.5 * (double)this.mask && !((double)this._vacant > 0.2 * (double)this.mask)) {
            m = (m << 1) + 1 & 0x3FFFFFFF;
        }
        while (m > 8 && 8 * this._size < m) {
            m >>>= 1;
        }
        this.repack(m);
    }

    @Override
    public Option<V> put(long key, V value) {
        if (key == -key) {
            if (key == 0L) {
                Option ans = (this.scala$collection$mutable$LongMap$$extraKeys & 1) == 1 ? new Some<Object>(this.scala$collection$mutable$LongMap$$zeroValue) : None$.MODULE$;
                this.scala$collection$mutable$LongMap$$zeroValue = value;
                this.scala$collection$mutable$LongMap$$extraKeys |= 1;
                return ans;
            }
            Option ans = (this.scala$collection$mutable$LongMap$$extraKeys & 2) == 1 ? new Some<Object>(this.scala$collection$mutable$LongMap$$minValue) : None$.MODULE$;
            this.scala$collection$mutable$LongMap$$minValue = value;
            this.scala$collection$mutable$LongMap$$extraKeys |= 2;
            return ans;
        }
        int i = this.seekEntryOrOpen(key);
        if (i < 0) {
            int j = i & 0x3FFFFFFF;
            this.scala$collection$mutable$LongMap$$_keys[j] = key;
            this.scala$collection$mutable$LongMap$$_values[j] = value;
            ++this._size;
            if ((i & 0x40000000) != 0) {
                --this._vacant;
            } else if (this.imbalanced()) {
                this.repack();
            }
            return None$.MODULE$;
        }
        Some<Object> ans = new Some<Object>(this.scala$collection$mutable$LongMap$$_values[i]);
        this.scala$collection$mutable$LongMap$$_keys[i] = key;
        this.scala$collection$mutable$LongMap$$_values[i] = value;
        return ans;
    }

    @Override
    public void update(long key, V value) {
        if (key == -key) {
            if (key == 0L) {
                this.scala$collection$mutable$LongMap$$zeroValue = value;
                this.scala$collection$mutable$LongMap$$extraKeys |= 1;
                return;
            }
            this.scala$collection$mutable$LongMap$$minValue = value;
            this.scala$collection$mutable$LongMap$$extraKeys |= 2;
            return;
        }
        int i = this.seekEntryOrOpen(key);
        if (i < 0) {
            int j = i & 0x3FFFFFFF;
            this.scala$collection$mutable$LongMap$$_keys[j] = key;
            this.scala$collection$mutable$LongMap$$_values[j] = value;
            ++this._size;
            if ((i & 0x40000000) != 0) {
                --this._vacant;
                return;
            }
            if (this.imbalanced()) {
                this.repack();
                return;
            }
        } else {
            this.scala$collection$mutable$LongMap$$_keys[i] = key;
            this.scala$collection$mutable$LongMap$$_values[i] = value;
        }
    }

    public LongMap<V> $plus$eq(long key, V value) {
        this.update(key, value);
        return this;
    }

    @Override
    public LongMap<V> $plus$eq(Tuple2<Object, V> kv) {
        this.update(kv._1$mcJ$sp(), kv._2());
        return this;
    }

    @Override
    public LongMap<V> $minus$eq(long key) {
        if (key == -key) {
            if (key == 0L) {
                this.scala$collection$mutable$LongMap$$extraKeys &= 2;
                this.scala$collection$mutable$LongMap$$zeroValue = null;
            } else {
                this.scala$collection$mutable$LongMap$$extraKeys &= 1;
                this.scala$collection$mutable$LongMap$$minValue = null;
            }
        } else {
            int i = this.seekEntry(key);
            if (i >= 0) {
                --this._size;
                ++this._vacant;
                this.scala$collection$mutable$LongMap$$_keys[i] = Long.MIN_VALUE;
                this.scala$collection$mutable$LongMap$$_values[i] = null;
            }
        }
        return this;
    }

    @Override
    public Iterator<Tuple2<Object, V>> iterator() {
        return new Iterator<Tuple2<Object, V>>(this){
            private final long[] kz;
            private final Object[] vz;
            private Tuple2<Object, V> nextPair;
            private Tuple2<Object, V> anotherPair;
            private int index;

            public Iterator<Tuple2<Object, V>> seq() {
                return Iterator.seq$(this);
            }

            public boolean isEmpty() {
                return Iterator.isEmpty$(this);
            }

            public boolean isTraversableAgain() {
                return Iterator.isTraversableAgain$(this);
            }

            public boolean hasDefiniteSize() {
                return Iterator.hasDefiniteSize$(this);
            }

            public Iterator<Tuple2<Object, V>> take(int n) {
                return Iterator.take$(this, n);
            }

            public Iterator<Tuple2<Object, V>> drop(int n) {
                return Iterator.drop$(this, n);
            }

            public Iterator<Tuple2<Object, V>> slice(int from, int until) {
                return Iterator.slice$(this, from, until);
            }

            public Iterator<Tuple2<Object, V>> sliceIterator(int from, int until) {
                return Iterator.sliceIterator$(this, from, until);
            }

            public <B> Iterator<B> map(Function1<Tuple2<Object, V>, B> f) {
                return Iterator.map$(this, f);
            }

            public <B> Iterator<B> $plus$plus(Function0<GenTraversableOnce<B>> that) {
                return Iterator.$plus$plus$(this, that);
            }

            public <B> Iterator<B> flatMap(Function1<Tuple2<Object, V>, GenTraversableOnce<B>> f) {
                return Iterator.flatMap$(this, f);
            }

            public Iterator<Tuple2<Object, V>> filter(Function1<Tuple2<Object, V>, Object> p) {
                return Iterator.filter$(this, p);
            }

            public <B> boolean corresponds(GenTraversableOnce<B> that, Function2<Tuple2<Object, V>, B, Object> p) {
                return Iterator.corresponds$(this, that, p);
            }

            public Iterator<Tuple2<Object, V>> withFilter(Function1<Tuple2<Object, V>, Object> p) {
                return Iterator.withFilter$(this, p);
            }

            public Iterator<Tuple2<Object, V>> filterNot(Function1<Tuple2<Object, V>, Object> p) {
                return Iterator.filterNot$(this, p);
            }

            public <B> Iterator<B> collect(PartialFunction<Tuple2<Object, V>, B> pf) {
                return Iterator.collect$(this, pf);
            }

            public <B> Iterator<B> scanLeft(B z, Function2<B, Tuple2<Object, V>, B> op) {
                return Iterator.scanLeft$(this, z, op);
            }

            public <B> Iterator<B> scanRight(B z, Function2<Tuple2<Object, V>, B, B> op) {
                return Iterator.scanRight$(this, z, op);
            }

            public Iterator<Tuple2<Object, V>> takeWhile(Function1<Tuple2<Object, V>, Object> p) {
                return Iterator.takeWhile$(this, p);
            }

            public Tuple2<Iterator<Tuple2<Object, V>>, Iterator<Tuple2<Object, V>>> partition(Function1<Tuple2<Object, V>, Object> p) {
                return Iterator.partition$(this, p);
            }

            public Tuple2<Iterator<Tuple2<Object, V>>, Iterator<Tuple2<Object, V>>> span(Function1<Tuple2<Object, V>, Object> p) {
                return Iterator.span$(this, p);
            }

            public Iterator<Tuple2<Object, V>> dropWhile(Function1<Tuple2<Object, V>, Object> p) {
                return Iterator.dropWhile$(this, p);
            }

            public <B> Iterator<Tuple2<Tuple2<Object, V>, B>> zip(Iterator<B> that) {
                return Iterator.zip$(this, that);
            }

            public <A1> Iterator<A1> padTo(int len, A1 elem) {
                return Iterator.padTo$(this, len, elem);
            }

            public Iterator<Tuple2<Tuple2<Object, V>, Object>> zipWithIndex() {
                return Iterator.zipWithIndex$(this);
            }

            public <B, A1, B1> Iterator<Tuple2<A1, B1>> zipAll(Iterator<B> that, A1 thisElem, B1 thatElem) {
                return Iterator.zipAll$(this, that, thisElem, thatElem);
            }

            public <U> void foreach(Function1<Tuple2<Object, V>, U> f) {
                Iterator.foreach$(this, f);
            }

            public boolean forall(Function1<Tuple2<Object, V>, Object> p) {
                return Iterator.forall$(this, p);
            }

            public boolean exists(Function1<Tuple2<Object, V>, Object> p) {
                return Iterator.exists$(this, p);
            }

            public boolean contains(Object elem) {
                return Iterator.contains$(this, elem);
            }

            public Option<Tuple2<Object, V>> find(Function1<Tuple2<Object, V>, Object> p) {
                return Iterator.find$(this, p);
            }

            public int indexWhere(Function1<Tuple2<Object, V>, Object> p) {
                return Iterator.indexWhere$(this, p);
            }

            public int indexWhere(Function1<Tuple2<Object, V>, Object> p, int from) {
                return Iterator.indexWhere$(this, p, from);
            }

            public <B> int indexOf(B elem) {
                return Iterator.indexOf$(this, elem);
            }

            public <B> int indexOf(B elem, int from) {
                return Iterator.indexOf$(this, elem, from);
            }

            public BufferedIterator<Tuple2<Object, V>> buffered() {
                return Iterator.buffered$(this);
            }

            public <B> Iterator.GroupedIterator<B> grouped(int size) {
                return Iterator.grouped$(this, size);
            }

            public <B> Iterator.GroupedIterator<B> sliding(int size, int step) {
                return Iterator.sliding$(this, size, step);
            }

            public <B> int sliding$default$2() {
                return Iterator.sliding$default$2$(this);
            }

            public int length() {
                return Iterator.length$(this);
            }

            public Tuple2<Iterator<Tuple2<Object, V>>, Iterator<Tuple2<Object, V>>> duplicate() {
                return Iterator.duplicate$(this);
            }

            public <B> Iterator<B> patch(int from, Iterator<B> patchElems, int replaced) {
                return Iterator.patch$(this, from, patchElems, replaced);
            }

            public <B> void copyToArray(Object xs, int start, int len) {
                Iterator.copyToArray$(this, xs, start, len);
            }

            public boolean sameElements(Iterator<?> that) {
                return Iterator.sameElements$(this, that);
            }

            public Traversable<Tuple2<Object, V>> toTraversable() {
                return Iterator.toTraversable$(this);
            }

            public Iterator<Tuple2<Object, V>> toIterator() {
                return Iterator.toIterator$(this);
            }

            public Stream<Tuple2<Object, V>> toStream() {
                return Iterator.toStream$(this);
            }

            public String toString() {
                return Iterator.toString$(this);
            }

            public List<Tuple2<Object, V>> reversed() {
                return TraversableOnce.reversed$(this);
            }

            public int size() {
                return TraversableOnce.size$(this);
            }

            public boolean nonEmpty() {
                return TraversableOnce.nonEmpty$(this);
            }

            public int count(Function1<Tuple2<Object, V>, Object> p) {
                return TraversableOnce.count$(this, p);
            }

            public <B> Option<B> collectFirst(PartialFunction<Tuple2<Object, V>, B> pf) {
                return TraversableOnce.collectFirst$(this, pf);
            }

            public <B> B $div$colon(B z, Function2<B, Tuple2<Object, V>, B> op) {
                return (B)TraversableOnce.$div$colon$(this, z, op);
            }

            public <B> B $colon$bslash(B z, Function2<Tuple2<Object, V>, B, B> op) {
                return (B)TraversableOnce.$colon$bslash$(this, z, op);
            }

            public <B> B foldLeft(B z, Function2<B, Tuple2<Object, V>, B> op) {
                return (B)TraversableOnce.foldLeft$(this, z, op);
            }

            public <B> B foldRight(B z, Function2<Tuple2<Object, V>, B, B> op) {
                return (B)TraversableOnce.foldRight$(this, z, op);
            }

            public <B> B reduceLeft(Function2<B, Tuple2<Object, V>, B> op) {
                return (B)TraversableOnce.reduceLeft$(this, op);
            }

            public <B> B reduceRight(Function2<Tuple2<Object, V>, B, B> op) {
                return (B)TraversableOnce.reduceRight$(this, op);
            }

            public <B> Option<B> reduceLeftOption(Function2<B, Tuple2<Object, V>, B> op) {
                return TraversableOnce.reduceLeftOption$(this, op);
            }

            public <B> Option<B> reduceRightOption(Function2<Tuple2<Object, V>, B, B> op) {
                return TraversableOnce.reduceRightOption$(this, op);
            }

            public <A1> A1 reduce(Function2<A1, A1, A1> op) {
                return (A1)TraversableOnce.reduce$(this, op);
            }

            public <A1> Option<A1> reduceOption(Function2<A1, A1, A1> op) {
                return TraversableOnce.reduceOption$(this, op);
            }

            public <A1> A1 fold(A1 z, Function2<A1, A1, A1> op) {
                return (A1)TraversableOnce.fold$(this, z, op);
            }

            public <B> B aggregate(Function0<B> z, Function2<B, Tuple2<Object, V>, B> seqop, Function2<B, B, B> combop) {
                return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
            }

            public <B> B sum(Numeric<B> num) {
                return (B)TraversableOnce.sum$(this, num);
            }

            public <B> B product(Numeric<B> num) {
                return (B)TraversableOnce.product$(this, num);
            }

            public Object min(Ordering cmp) {
                return TraversableOnce.min$(this, cmp);
            }

            public Object max(Ordering cmp) {
                return TraversableOnce.max$(this, cmp);
            }

            public Object maxBy(Function1 f, Ordering cmp) {
                return TraversableOnce.maxBy$(this, f, cmp);
            }

            public Object minBy(Function1 f, Ordering cmp) {
                return TraversableOnce.minBy$(this, f, cmp);
            }

            public <B> void copyToBuffer(Buffer<B> dest) {
                TraversableOnce.copyToBuffer$(this, dest);
            }

            public <B> void copyToArray(Object xs, int start) {
                TraversableOnce.copyToArray$(this, xs, start);
            }

            public <B> void copyToArray(Object xs) {
                TraversableOnce.copyToArray$(this, xs);
            }

            public <B> Object toArray(ClassTag<B> evidence$1) {
                return TraversableOnce.toArray$(this, evidence$1);
            }

            public List<Tuple2<Object, V>> toList() {
                return TraversableOnce.toList$(this);
            }

            public Iterable<Tuple2<Object, V>> toIterable() {
                return TraversableOnce.toIterable$(this);
            }

            public Seq<Tuple2<Object, V>> toSeq() {
                return TraversableOnce.toSeq$(this);
            }

            public IndexedSeq<Tuple2<Object, V>> toIndexedSeq() {
                return TraversableOnce.toIndexedSeq$(this);
            }

            public <B> Buffer<B> toBuffer() {
                return TraversableOnce.toBuffer$(this);
            }

            public <B> Set<B> toSet() {
                return TraversableOnce.toSet$(this);
            }

            public Vector<Tuple2<Object, V>> toVector() {
                return TraversableOnce.toVector$(this);
            }

            public <Col> Col to(CanBuildFrom<Nothing$, Tuple2<Object, V>, Col> cbf) {
                return (Col)TraversableOnce.to$(this, cbf);
            }

            public <T, U> Map<T, U> toMap(Predef$.less.colon.less<Tuple2<Object, V>, Tuple2<T, U>> ev) {
                return TraversableOnce.toMap$(this, ev);
            }

            public String mkString(String start, String sep, String end) {
                return TraversableOnce.mkString$(this, start, sep, end);
            }

            public String mkString(String sep) {
                return TraversableOnce.mkString$(this, sep);
            }

            public String mkString() {
                return TraversableOnce.mkString$(this);
            }

            public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
                return TraversableOnce.addString$(this, b, start, sep, end);
            }

            public StringBuilder addString(StringBuilder b, String sep) {
                return TraversableOnce.addString$(this, b, sep);
            }

            public StringBuilder addString(StringBuilder b) {
                return TraversableOnce.addString$(this, b);
            }

            public int sizeHintIfCheap() {
                return GenTraversableOnce.sizeHintIfCheap$(this);
            }

            public boolean hasNext() {
                block6: {
                    block5: {
                        if (this.nextPair != null) break block5;
                        if (this.index >= this.kz.length) break block6;
                        long q = this.kz[this.index];
                        while (q == -q) {
                            ++this.index;
                            if (this.index >= this.kz.length) {
                                return false;
                            }
                            q = this.kz[this.index];
                        }
                        this.nextPair = new Tuple2<Long, Object>(BoxesRunTime.boxToLong(this.kz[this.index]), this.vz[this.index]);
                        ++this.index;
                    }
                    return true;
                }
                return false;
            }

            /*
             * WARNING - void declaration
             */
            public Tuple2<Object, V> next() {
                void var1_1;
                if (this.nextPair == null && !this.hasNext()) {
                    throw new NoSuchElementException("next");
                }
                Tuple2<Object, V> ans = this.nextPair;
                if (this.anotherPair != null) {
                    this.nextPair = this.anotherPair;
                    this.anotherPair = null;
                } else {
                    this.nextPair = null;
                }
                return var1_1;
            }
            {
                GenTraversableOnce.$init$(this);
                TraversableOnce.$init$(this);
                Iterator.$init$(this);
                this.kz = $outer.scala$collection$mutable$LongMap$$_keys;
                this.vz = $outer.scala$collection$mutable$LongMap$$_values;
                this.nextPair = $outer.scala$collection$mutable$LongMap$$extraKeys == 0 ? null : (($outer.scala$collection$mutable$LongMap$$extraKeys & 1) == 1 ? new Tuple2<Long, Object>(BoxesRunTime.boxToLong(0L), $outer.scala$collection$mutable$LongMap$$zeroValue) : new Tuple2<Long, Object>(BoxesRunTime.boxToLong(Long.MIN_VALUE), $outer.scala$collection$mutable$LongMap$$minValue));
                this.anotherPair = $outer.scala$collection$mutable$LongMap$$extraKeys == 3 ? new Tuple2<Long, Object>(BoxesRunTime.boxToLong(Long.MIN_VALUE), $outer.scala$collection$mutable$LongMap$$minValue) : null;
                this.index = 0;
            }
        };
    }

    @Override
    public <U> void foreach(Function1<Tuple2<Object, V>, U> f) {
        if ((this.scala$collection$mutable$LongMap$$extraKeys & 1) == 1) {
            f.apply(new Tuple2<Long, Object>(BoxesRunTime.boxToLong(0L), this.scala$collection$mutable$LongMap$$zeroValue));
        }
        if ((this.scala$collection$mutable$LongMap$$extraKeys & 2) == 2) {
            f.apply(new Tuple2<Long, Object>(BoxesRunTime.boxToLong(Long.MIN_VALUE), this.scala$collection$mutable$LongMap$$minValue));
        }
        int i = 0;
        int j = 0;
        while (i < this.scala$collection$mutable$LongMap$$_keys.length & j < this._size) {
            long k = this.scala$collection$mutable$LongMap$$_keys[i];
            if (k != -k) {
                ++j;
                f.apply(new Tuple2<Long, Object>(BoxesRunTime.boxToLong(k), this.scala$collection$mutable$LongMap$$_values[i]));
            }
            ++i;
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public LongMap<V> clone() {
        void var3_3;
        long[] kz = Arrays.copyOf(this.scala$collection$mutable$LongMap$$_keys, this.scala$collection$mutable$LongMap$$_keys.length);
        Object[] vz = Arrays.copyOf(this.scala$collection$mutable$LongMap$$_values, this.scala$collection$mutable$LongMap$$_values.length);
        LongMap<V> lm = new LongMap<V>(this.defaultEntry, 1, false);
        lm.initializeTo(this.mask, this.scala$collection$mutable$LongMap$$extraKeys, this.scala$collection$mutable$LongMap$$zeroValue, this.scala$collection$mutable$LongMap$$minValue, this._size, this._vacant, kz, vz);
        return var3_3;
    }

    /*
     * WARNING - void declaration
     */
    public <V1> LongMap<V1> $plus(Tuple2<Object, V1> kv) {
        void var2_2;
        Object lm = this.clone();
        ((LongMap)lm).$plus$eq(kv);
        return var2_2;
    }

    /*
     * WARNING - void declaration
     */
    public <V1> LongMap<V1> $plus$plus(GenTraversableOnce<Tuple2<Object, V1>> xs) {
        void var2_2;
        Object lm = this.clone();
        xs.foreach(arg_0 -> LongMap.$anonfun$$plus$plus$1((LongMap)lm, arg_0));
        return var2_2;
    }

    public <V1> LongMap<V1> updated(long key, V1 value) {
        Object lm = this.clone();
        ((LongMap)lm).$plus$eq(key, value);
        return lm;
    }

    public <A> void foreachKey(Function1<Object, A> f) {
        if ((this.scala$collection$mutable$LongMap$$extraKeys & 1) == 1) {
            f.apply(BoxesRunTime.boxToLong(0L));
        }
        if ((this.scala$collection$mutable$LongMap$$extraKeys & 2) == 2) {
            f.apply(BoxesRunTime.boxToLong(Long.MIN_VALUE));
        }
        int i = 0;
        int j = 0;
        while (i < this.scala$collection$mutable$LongMap$$_keys.length & j < this._size) {
            long k = this.scala$collection$mutable$LongMap$$_keys[i];
            if (k != -k) {
                ++j;
                f.apply(BoxesRunTime.boxToLong(k));
            }
            ++i;
        }
    }

    public <A> void foreachValue(Function1<V, A> f) {
        if ((this.scala$collection$mutable$LongMap$$extraKeys & 1) == 1) {
            f.apply(this.scala$collection$mutable$LongMap$$zeroValue);
        }
        if ((this.scala$collection$mutable$LongMap$$extraKeys & 2) == 2) {
            f.apply(this.scala$collection$mutable$LongMap$$minValue);
        }
        int i = 0;
        int j = 0;
        while (i < this.scala$collection$mutable$LongMap$$_keys.length & j < this._size) {
            long k = this.scala$collection$mutable$LongMap$$_keys[i];
            if (k != -k) {
                ++j;
                f.apply(this.scala$collection$mutable$LongMap$$_values[i]);
            }
            ++i;
        }
    }

    public <V1> LongMap<V1> mapValuesNow(Function1<V, V1> f) {
        Object zv = (this.scala$collection$mutable$LongMap$$extraKeys & 1) == 1 ? f.apply(this.scala$collection$mutable$LongMap$$zeroValue) : null;
        Object mv = (this.scala$collection$mutable$LongMap$$extraKeys & 2) == 2 ? f.apply(this.scala$collection$mutable$LongMap$$minValue) : null;
        LongMap<Nothing$> lm = new LongMap<Nothing$>(LongMap$.MODULE$.scala$collection$mutable$LongMap$$exceptionDefault(), 1, false);
        long[] kz = Arrays.copyOf(this.scala$collection$mutable$LongMap$$_keys, this.scala$collection$mutable$LongMap$$_keys.length);
        Object[] vz = new Object[this.scala$collection$mutable$LongMap$$_values.length];
        int i = 0;
        int j = 0;
        while (i < this.scala$collection$mutable$LongMap$$_keys.length & j < this._size) {
            long k = this.scala$collection$mutable$LongMap$$_keys[i];
            if (k != -k) {
                ++j;
                vz[i] = f.apply(this.scala$collection$mutable$LongMap$$_values[i]);
            }
            ++i;
        }
        lm.initializeTo(this.mask, this.scala$collection$mutable$LongMap$$extraKeys, zv, mv, this._size, this._vacant, kz, vz);
        return lm;
    }

    public LongMap<V> transformValues(Function1<V, V> f) {
        if ((this.scala$collection$mutable$LongMap$$extraKeys & 1) == 1) {
            this.scala$collection$mutable$LongMap$$zeroValue = f.apply(this.scala$collection$mutable$LongMap$$zeroValue);
        }
        if ((this.scala$collection$mutable$LongMap$$extraKeys & 2) == 2) {
            this.scala$collection$mutable$LongMap$$minValue = f.apply(this.scala$collection$mutable$LongMap$$minValue);
        }
        int i = 0;
        int j = 0;
        while (i < this.scala$collection$mutable$LongMap$$_keys.length & j < this._size) {
            long k = this.scala$collection$mutable$LongMap$$_keys[i];
            if (k != -k) {
                ++j;
                this.scala$collection$mutable$LongMap$$_values[i] = f.apply(this.scala$collection$mutable$LongMap$$_values[i]);
            }
            ++i;
        }
        return this;
    }

    public static final /* synthetic */ LongMap $anonfun$$plus$plus$1(LongMap lm$1, Tuple2 kv) {
        return lm$1.$plus$eq(kv);
    }

    public LongMap(Function1<Object, V> defaultEntry, int initialBufferSize, boolean initBlank) {
        this.defaultEntry = defaultEntry;
        this.mask = 0;
        this.scala$collection$mutable$LongMap$$extraKeys = 0;
        this.scala$collection$mutable$LongMap$$zeroValue = null;
        this.scala$collection$mutable$LongMap$$minValue = null;
        this._size = 0;
        this._vacant = 0;
        this.scala$collection$mutable$LongMap$$_keys = null;
        this.scala$collection$mutable$LongMap$$_values = null;
        if (initBlank) {
            this.defaultInitialize(initialBufferSize);
        }
    }

    public LongMap() {
        this(LongMap$.MODULE$.scala$collection$mutable$LongMap$$exceptionDefault(), 16, true);
    }

    public LongMap(Function1<Object, V> defaultEntry) {
        this(defaultEntry, 16, true);
    }

    public LongMap(int initialBufferSize) {
        this(LongMap$.MODULE$.scala$collection$mutable$LongMap$$exceptionDefault(), initialBufferSize, true);
    }

    public LongMap(Function1<Object, V> defaultEntry, int initialBufferSize) {
        this(defaultEntry, initialBufferSize, true);
    }

    public static final class LongMapBuilder<V>
    implements ReusableBuilder<Tuple2<Object, V>, LongMap<V>> {
        private LongMap<V> elems;

        @Override
        public void sizeHint(int size) {
            Builder.sizeHint$((Builder)this, size);
        }

        @Override
        public void sizeHint(TraversableLike<?, ?> coll) {
            Builder.sizeHint$((Builder)this, coll);
        }

        @Override
        public void sizeHint(TraversableLike<?, ?> coll, int delta) {
            Builder.sizeHint$(this, coll, delta);
        }

        @Override
        public void sizeHintBounded(int size, TraversableLike<?, ?> boundingColl) {
            Builder.sizeHintBounded$(this, size, boundingColl);
        }

        @Override
        public <NewTo> Builder<Tuple2<Object, V>, NewTo> mapResult(Function1<LongMap<V>, NewTo> f) {
            return Builder.mapResult$(this, f);
        }

        @Override
        public Growable $plus$eq(Object elem1, Object elem2, Seq elems) {
            return Growable.$plus$eq$(this, elem1, elem2, elems);
        }

        @Override
        public Growable<Tuple2<Object, V>> $plus$plus$eq(TraversableOnce<Tuple2<Object, V>> xs) {
            return Growable.$plus$plus$eq$(this, xs);
        }

        public LongMap<V> elems() {
            return this.elems;
        }

        public void elems_$eq(LongMap<V> x$1) {
            this.elems = x$1;
        }

        @Override
        public LongMapBuilder<V> $plus$eq(Tuple2<Object, V> entry) {
            this.elems().$plus$eq((Tuple2)entry);
            return this;
        }

        @Override
        public void clear() {
            this.elems_$eq(new LongMap());
        }

        @Override
        public LongMap<V> result() {
            return this.elems();
        }

        public LongMapBuilder() {
            Growable.$init$(this);
            Builder.$init$(this);
            this.elems = new LongMap();
        }
    }
}

