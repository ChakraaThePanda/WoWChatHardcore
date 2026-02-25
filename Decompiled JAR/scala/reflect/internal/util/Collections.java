/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import java.util.NoSuchElementException;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Option$;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.BufferedIterator;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.LinearSeqOptimized;
import scala.collection.Seq;
import scala.collection.SeqLike;
import scala.collection.Traversable;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Map;
import scala.collection.immutable.Map$;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.BitSet;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.LinkedHashMap;
import scala.collection.mutable.LinkedHashMap$;
import scala.collection.mutable.ListBuffer;
import scala.collection.mutable.ListBuffer$;
import scala.collection.mutable.Set;
import scala.collection.mutable.Set$;
import scala.collection.mutable.StringBuilder;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.util.Collections$;
import scala.reflect.internal.util.package$;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.LambdaDeserialize;
import scala.runtime.Nothing$;
import scala.runtime.ObjectRef;

@ScalaSignature(bytes="\u0006\u0001\u0015]da\u0002\u0017.!\u0003\r\tA\u000e\u0005\u0006w\u0001!\t\u0001\u0010\u0005\u0006\u0001\u0002!)!\u0011\u0005\u0006g\u0002!)\u0001\u001e\u0005\b\u0003\u000b\u0001AQAA\u0004\u0011\u001d\tY\u0002\u0001C\u0003\u0003;Aq!!\u0012\u0001\t\u000b\t9\u0005C\u0004\u0002b\u0001!)!a\u0019\t\u000f\u0005\u0005\u0004\u0001\"\u0002\u0002x!9\u0011q\u0012\u0001\u0005\u0006\u0005E\u0005bBAV\u0001\u0011\u0015\u0011Q\u0016\u0005\b\u0003s\u0003AQAA^\u0011\u001d\tI\u000e\u0001C\u0003\u00037Dq!a@\u0001\t\u000b\u0011\t\u0001C\u0004\u0003\"\u0001!)Aa\t\t\u000f\t5\u0003\u0001\"\u0002\u0003P!9!q\u000e\u0001\u0005\u0006\tE\u0004b\u0002BM\u0001\u0011\u0015!1\u0014\u0005\b\u0005o\u0003AQ\u0001B]\u0011\u001d\u0011y\r\u0001C\u0003\u0005#DqAa:\u0001\t\u000b\u0011I\u000fC\u0004\u0004\u0002\u0001!)aa\u0001\t\u000f\r\u0015\u0002\u0001\"\u0002\u0004(!91\u0011\f\u0001\u0005\u0006\rm\u0003bBBB\u0001\u0011\u00151Q\u0011\u0005\b\u0007;\u0003AQABP\u0011\u001d\u0019i\f\u0001C\u0003\u0007\u007fCqa!7\u0001\t\u000b\u0019Y\u000eC\u0004\u0004~\u0002!)aa@\t\u000f\u0011e\u0001\u0001\"\u0002\u0005\u001c!9AQ\b\u0001\u0005\u0006\u0011}\u0002b\u0002C1\u0001\u0011\u0015A1\r\u0005\b\t\u001b\u0003AQ\u0001CH\u0011\u001d!\t\u000b\u0001C\u0003\tGCq\u0001b0\u0001\t\u000b!\t\rC\u0004\u0005\\\u0002!)\u0001\"8\t\u000f\u0011=\b\u0001\"\u0002\u0005r\"9Q1\u0001\u0001\u0005\u0006\u0015\u0015\u0001bBC\u0010\u0001\u0011\u0015Q\u0011\u0005\u0005\b\u000b{\u0001AQAC \u0011\u001d)\t\u0006\u0001C\u0003\u000b':q!\"\u001b.\u0011\u0003)YG\u0002\u0004-[!\u0005Qq\u000e\u0005\b\u000bgRC\u0011AC;\u0005-\u0019u\u000e\u001c7fGRLwN\\:\u000b\u00059z\u0013\u0001B;uS2T!\u0001M\u0019\u0002\u0011%tG/\u001a:oC2T!AM\u001a\u0002\u000fI,g\r\\3di*\tA'A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\u0005\u00019\u0004C\u0001\u001d:\u001b\u0005\u0019\u0014B\u0001\u001e4\u0005\u0019\te.\u001f*fM\u00061A%\u001b8ji\u0012\"\u0012!\u0010\t\u0003qyJ!aP\u001a\u0003\tUs\u0017\u000e^\u0001\rG>\u0014(/Z:q_:$7oM\u000b\u0005\u0005:C6\f\u0006\u0003D;\u001aLGC\u0001#H!\tAT)\u0003\u0002Gg\t9!i\\8mK\u0006t\u0007\"\u0002%\u0003\u0001\u0004I\u0015!\u00014\u0011\raREj\u0016.E\u0013\tY5GA\u0005Gk:\u001cG/[8ogA\u0011QJ\u0014\u0007\u0001\t\u0015y%A1\u0001Q\u0005\u0005\t\u0015CA)U!\tA$+\u0003\u0002Tg\t9aj\u001c;iS:<\u0007C\u0001\u001dV\u0013\t16GA\u0002B]f\u0004\"!\u0014-\u0005\u000be\u0013!\u0019\u0001)\u0003\u0003\t\u0003\"!T.\u0005\u000bq\u0013!\u0019\u0001)\u0003\u0003\rCQA\u0018\u0002A\u0002}\u000b1\u0001_:2!\r\u00017\r\u0014\b\u0003q\u0005L!AY\u001a\u0002\u000fA\f7m[1hK&\u0011A-\u001a\u0002\u0005\u0019&\u001cHO\u0003\u0002cg!)qM\u0001a\u0001Q\u0006\u0019\u0001p\u001d\u001a\u0011\u0007\u0001\u001cw\u000bC\u0003k\u0005\u0001\u00071.A\u0002ygN\u00022\u0001Y2[Q\t\u0011Q\u000e\u0005\u0002oc6\tqN\u0003\u0002qg\u0005Q\u0011M\u001c8pi\u0006$\u0018n\u001c8\n\u0005I|'a\u0002;bS2\u0014XmY\u0001\b[\u0016D\u0018n\u001d;t+\t)X\u0010\u0006\u0002w}R\u0011Ai\u001e\u0005\u0006q\u000e\u0001\r!_\u0001\u0002aB!\u0001H\u001f?E\u0013\tY8GA\u0005Gk:\u001cG/[8ocA\u0011Q* \u0003\u0006\u001f\u000e\u0011\r\u0001\u0015\u0005\u0007\u007f\u000e\u0001\r!!\u0001\u0002\u0007a\u001c8\u000f\u0005\u0003aG\u0006\r\u0001c\u00011dy\u00069QNZ8sC2dW\u0003BA\u0005\u0003'!B!a\u0003\u0002\u0016Q\u0019A)!\u0004\t\ra$\u0001\u0019AA\b!\u0015A$0!\u0005E!\ri\u00151\u0003\u0003\u0006\u001f\u0012\u0011\r\u0001\u0015\u0005\u0007\u007f\u0012\u0001\r!a\u0006\u0011\t\u0001\u001c\u0017\u0011\u0004\t\u0005A\u000e\f\t\"\u0001\u0003n[\u0006\u0004XCBA\u0010\u0003{\t)\u0004\u0006\u0003\u0002\"\u0005}B\u0003BA\u0012\u0003o\u0001b!!\n\u00020\u0005ERBAA\u0014\u0015\u0011\tI#a\u000b\u0002\u0013%lW.\u001e;bE2,'bAA\u0017g\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\n\u0007\u0011\f9\u0003\u0005\u0004\u0002&\u0005=\u00121\u0007\t\u0004\u001b\u0006UB!B-\u0006\u0005\u0004\u0001\u0006B\u0002%\u0006\u0001\u0004\tI\u0004\u0005\u00049u\u0006m\u00121\u0007\t\u0004\u001b\u0006uB!B(\u0006\u0005\u0004\u0001\u0006BB@\u0006\u0001\u0004\t\t\u0005\u0005\u0003aG\u0006\r\u0003\u0003\u00021d\u0003w\tQ!\u001c4j]\u0012,B!!\u0013\u0002VQ!\u00111JA.)\u0011\ti%a\u0016\u0011\u000ba\ny%a\u0015\n\u0007\u0005E3G\u0001\u0004PaRLwN\u001c\t\u0004\u001b\u0006UC!B(\u0007\u0005\u0004\u0001\u0006B\u0002=\u0007\u0001\u0004\tI\u0006E\u00039u\u0006MC\t\u0003\u0004\u0000\r\u0001\u0007\u0011Q\f\t\u0005A\u000e\fy\u0006\u0005\u0003aG\u0006M\u0013\u0001C7g_J,\u0017m\u00195\u0016\t\u0005\u0015\u0014q\u000e\u000b\u0005\u0003O\n\t\bF\u0002>\u0003SBa\u0001S\u0004A\u0002\u0005-\u0004#\u0002\u001d{\u0003[j\u0004cA'\u0002p\u0011)qj\u0002b\u0001!\"1qp\u0002a\u0001\u0003g\u0002B\u0001Y2\u0002vA!\u0001mYA7+\u0011\tI(a!\u0015\t\u0005m\u0014Q\u0011\u000b\u0004{\u0005u\u0004B\u0002%\t\u0001\u0004\ty\bE\u00039u\u0006\u0005U\bE\u0002N\u0003\u0007#Qa\u0014\u0005C\u0002ACaa \u0005A\u0002\u0005\u001d\u0005#\u00021\u0002\n\u00065\u0015bAAFK\nYAK]1wKJ\u001c\u0018M\u00197f!\u0015\u0001\u0017\u0011RAA\u0003\u001di\u0017\r\u001d'jgR,b!a%\u0002$\u0006mE\u0003BAK\u0003K#B!a&\u0002\u001eB!\u0001mYAM!\ri\u00151\u0014\u0003\u00063&\u0011\r\u0001\u0015\u0005\u0007\u0011&\u0001\r!a(\u0011\raR\u0018\u0011UAM!\ri\u00151\u0015\u0003\u0006\u001f&\u0011\r\u0001\u0015\u0005\b\u0003OK\u0001\u0019AAU\u0003\t\t7\u000f\u0005\u0003aG\u0006\u0005\u0016AE:b[\u0016,E.Z7f]R\u001cX)];bYN$R\u0001RAX\u0003kCq!!-\u000b\u0001\u0004\t\u0019,A\u0003uQ&\u001c8\u000fE\u0002aG^Bq!a.\u000b\u0001\u0004\t\u0019,\u0001\u0003uQ\u0006$\u0018\u0001D2pY2,7\r\u001e$jeN$XCBA_\u0003'\f)\r\u0006\u0003\u0002@\u0006UG\u0003BAa\u0003\u000f\u0004R\u0001OA(\u0003\u0007\u00042!TAc\t\u0015I6B1\u0001Q\u0011\u001d\tIm\u0003a\u0001\u0003\u0017\f!\u0001\u001d4\u0011\u000fa\ni-!5\u0002D&\u0019\u0011qZ\u001a\u0003\u001fA\u000b'\u000f^5bY\u001a+hn\u0019;j_:\u00042!TAj\t\u0015y5B1\u0001Q\u0011\u001d\t9k\u0003a\u0001\u0003/\u0004B\u0001Y2\u0002R\u0006!Q.\u001993+!\ti.!=\u0002v\u0006\u0015HCBAp\u0003o\fY\u0010\u0006\u0003\u0002b\u0006\u001d\b\u0003\u00021d\u0003G\u00042!TAs\t\u0015aFB1\u0001Q\u0011\u0019AE\u00021\u0001\u0002jBI\u0001(a;\u0002p\u0006M\u00181]\u0005\u0004\u0003[\u001c$!\u0003$v]\u000e$\u0018n\u001c83!\ri\u0015\u0011\u001f\u0003\u0006\u001f2\u0011\r\u0001\u0015\t\u0004\u001b\u0006UH!B-\r\u0005\u0004\u0001\u0006B\u00020\r\u0001\u0004\tI\u0010\u0005\u0003aG\u0006=\bBB4\r\u0001\u0004\ti\u0010\u0005\u0003aG\u0006M\u0018\u0001D7baJ\u001auN\\:feZ,WC\u0002B\u0002\u0005\u0017\u0011)\u0002\u0006\u0004\u0003\u0006\t]!1\u0004\u000b\u0005\u0005\u000f\u0011y\u0001\u0005\u0003aG\n%\u0001cA'\u0003\f\u00111q*\u0004b\u0001\u0005\u001b\t\"!U\u001c\t\r!k\u0001\u0019\u0001B\t!%A\u00141\u001eB\u0005\u0005'\u0011I\u0001E\u0002N\u0005+!Q!W\u0007C\u0002ACqA!\u0007\u000e\u0001\u0004\u00119!\u0001\u0002yg\"9!QD\u0007A\u0002\t}\u0011AA=t!\u0011\u00017Ma\u0005\u0002\t5\f\u0007oM\u000b\u000b\u0005K\u00119Da\u000f\u0003@\t5B\u0003\u0003B\u0014\u0005\u0003\u0012)E!\u0013\u0015\t\t%\"\u0011\u0007\t\u0005A\u000e\u0014Y\u0003E\u0002N\u0005[!aAa\f\u000f\u0005\u0004\u0001&!\u0001#\t\r!s\u0001\u0019\u0001B\u001a!)A$J!\u000e\u0003:\tu\"1\u0006\t\u0004\u001b\n]B!B(\u000f\u0005\u0004\u0001\u0006cA'\u0003<\u0011)\u0011L\u0004b\u0001!B\u0019QJa\u0010\u0005\u000bqs!\u0019\u0001)\t\rys\u0001\u0019\u0001B\"!\u0011\u00017M!\u000e\t\r\u001dt\u0001\u0019\u0001B$!\u0011\u00017M!\u000f\t\r)t\u0001\u0019\u0001B&!\u0011\u00017M!\u0010\u0002\u0011\u0019d\u0017\r^'baJ*\u0002B!\u0015\u0003b\t\u0015$\u0011\f\u000b\u0007\u0005'\u00129Ga\u001b\u0015\t\tU#1\f\t\u0005A\u000e\u00149\u0006E\u0002N\u00053\"Q\u0001X\bC\u0002ACa\u0001S\bA\u0002\tu\u0003#\u0003\u001d\u0002l\n}#1\rB+!\ri%\u0011\r\u0003\u0006\u001f>\u0011\r\u0001\u0015\t\u0004\u001b\n\u0015D!B-\u0010\u0005\u0004\u0001\u0006B\u00020\u0010\u0001\u0004\u0011I\u0007\u0005\u0003aG\n}\u0003BB4\u0010\u0001\u0004\u0011i\u0007\u0005\u0003aG\n\r\u0014!\u00034pY\u0012dUM\u001a;3+!\u0011\u0019Ha!\u0003\n\nmDC\u0002B;\u0005#\u0013)\n\u0006\u0003\u0003x\t5E\u0003\u0002B=\u0005{\u00022!\u0014B>\t\u0015I\u0006C1\u0001Q\u0011\u0019A\u0005\u00031\u0001\u0003\u0000AQ\u0001H\u0013B=\u0005\u0003\u00139I!\u001f\u0011\u00075\u0013\u0019\t\u0002\u0004\u0003\u0006B\u0011\r\u0001\u0015\u0002\u0003\u0003F\u00022!\u0014BE\t\u0019\u0011Y\t\u0005b\u0001!\n\u0011\u0011I\r\u0005\b\u0005\u001f\u0003\u0002\u0019\u0001B=\u0003\tQ\b\u0007\u0003\u0004_!\u0001\u0007!1\u0013\t\u0005A\u000e\u0014\t\t\u0003\u0004h!\u0001\u0007!q\u0013\t\u0005A\u000e\u00149)A\u0006gY\u0006$8i\u001c7mK\u000e$XC\u0002BO\u0005[\u0013)\u000b\u0006\u0003\u0003 \nEF\u0003\u0002BQ\u0005O\u0003B\u0001Y2\u0003$B\u0019QJ!*\u0005\u000be\u000b\"\u0019\u0001)\t\u000f\u0005%\u0017\u00031\u0001\u0003*B9\u0001(!4\u0003,\n=\u0006cA'\u0003.\u0012)q*\u0005b\u0001!B)\u0001-!#\u0003$\"9!1W\tA\u0002\tU\u0016!B3mK6\u001c\b\u0003\u00021d\u0005W\u000b!\u0002Z5ti&t7\r\u001e\"z+\u0019\u0011YLa1\u0003LR!!Q\u0018Bg)\u0011\u0011yL!2\u0011\t\u0001\u001c'\u0011\u0019\t\u0004\u001b\n\rG!B(\u0013\u0005\u0004\u0001\u0006B\u0002%\u0013\u0001\u0004\u00119\r\u0005\u00049u\n\u0005'\u0011\u001a\t\u0004\u001b\n-G!B-\u0013\u0005\u0004\u0001\u0006b\u0002B\r%\u0001\u0007!qX\u0001\u0010M2\fG\u000f^3ogR{W)\u001c9usR\u0019AIa5\t\r}\u001c\u0002\u0019\u0001Bk!\u0015\u0001'q\u001bBn\u0013\r\u0011I.\u001a\u0002\u0004'\u0016\f\b\u0007\u0002Bo\u0005C\u0004R\u0001\u0019Bl\u0005?\u00042!\u0014Bq\t-\u0011\u0019Oa5\u0002\u0002\u0003\u0005)\u0011\u0001)\u0003\u0007}#\u0013\u0007\u000b\u0002\u0014[\u0006\u0001bm\u001c:fC\u000eDw+\u001b;i\u0013:$W\r_\u000b\u0005\u0005W\u0014)\u0010\u0006\u0003\u0003n\nuHcA\u001f\u0003p\"1\u0001\n\u0006a\u0001\u0005c\u0004\u0002\u0002OAv\u0005g\u001490\u0010\t\u0004\u001b\nUH!B(\u0015\u0005\u0004\u0001\u0006c\u0001\u001d\u0003z&\u0019!1`\u001a\u0003\u0007%sG\u000fC\u0004\u0003\u001aQ\u0001\rAa@\u0011\t\u0001\u001c'1_\u0001\u000bM&tGm\u0014:FYN,W\u0003BB\u0003\u0007\u001b!Baa\u0002\u0004\u001eQ!1\u0011BB\r)\u0011\u0019Yaa\u0004\u0011\u00075\u001bi\u0001B\u0003P+\t\u0007\u0001\u000b\u0003\u0005\u0004\u0012U!\t\u0019AB\n\u0003\u0019y'/\u00127tKB)\u0001h!\u0006\u0004\f%\u00191qC\u001a\u0003\u0011q\u0012\u0017P\\1nKzBa\u0001_\u000bA\u0002\rm\u0001#\u0002\u001d{\u0007\u0017!\u0005b\u0002B\r+\u0001\u00071q\u0004\t\u0006A\u000e\u000521B\u0005\u0004\u0007G)'a\u0004+sCZ,'o]1cY\u0016|enY3\u0002\u000f5\f\u0007O\u0012:p[VA1\u0011FB&\u0007\u000b\u001ay\u0005\u0006\u0003\u0004,\rUC\u0003BB\u0017\u0007#\u0002\u0002ba\f\u0004>\r\r3Q\n\b\u0005\u0007c\u0019I\u0004E\u0002\u00044Mj!a!\u000e\u000b\u0007\r]R'\u0001\u0004=e>|GOP\u0005\u0004\u0007w\u0019\u0014A\u0002)sK\u0012,g-\u0003\u0003\u0004@\r\u0005#aA'ba*\u001911H\u001a\u0011\u00075\u001b)\u0005B\u0004\u0003\u0006Z\u0011\raa\u0012\u0012\u0007\r%C\u000bE\u0002N\u0007\u0017\"Qa\u0014\fC\u0002A\u00032!TB(\t\u0015IfC1\u0001Q\u0011\u0019Ae\u00031\u0001\u0004TA1\u0001H_B%\u0007\u001bBqA!\u0007\u0017\u0001\u0004\u00199\u0006\u0005\u0003aG\u000e%\u0013!\u00047j].,G-T1q\rJ|W.\u0006\u0005\u0004^\rU4qNB=)\u0011\u0019yfa \u0015\t\r\u000541\u0010\t\t\u0007G\u001aIg!\u001c\u0004x5\u00111Q\r\u0006\u0005\u0007O\nY#A\u0004nkR\f'\r\\3\n\t\r-4Q\r\u0002\u000e\u0019&t7.\u001a3ICNDW*\u00199\u0011\u00075\u001by\u0007B\u0004\u0003\u0006^\u0011\ra!\u001d\u0012\u0007\rMD\u000bE\u0002N\u0007k\"QaT\fC\u0002A\u00032!TB=\t\u0015IvC1\u0001Q\u0011\u0019Au\u00031\u0001\u0004~A1\u0001H_B:\u0007oBqA!\u0007\u0018\u0001\u0004\u0019\t\t\u0005\u0003aG\u000eM\u0014\u0001D7ba^KG\u000f[%oI\u0016DXCBBD\u0007/\u001by\t\u0006\u0003\u0004\n\u000eeE\u0003BBF\u0007#\u0003B\u0001Y2\u0004\u000eB\u0019Qja$\u0005\u000beC\"\u0019\u0001)\t\r!C\u0002\u0019ABJ!%A\u00141^BK\u0005o\u001ci\tE\u0002N\u0007/#Qa\u0014\rC\u0002ACqA!\u0007\u0019\u0001\u0004\u0019Y\n\u0005\u0003aG\u000eU\u0015aC2pY2,7\r^'baJ*\u0002b!)\u0004*\u000e561\u0018\u000b\u0007\u0007G\u001b\u0019la.\u0015\t\r\u00156q\u0016\t\t\u0007_\u0019ida*\u0004,B\u0019Qj!+\u0005\u000b=K\"\u0019\u0001)\u0011\u00075\u001bi\u000bB\u0003Z3\t\u0007\u0001\u000b\u0003\u0004y3\u0001\u00071\u0011\u0017\t\tq\u0005-8qUBV\t\"1a,\u0007a\u0001\u0007k\u0003B\u0001Y2\u0004(\"1q-\u0007a\u0001\u0007s\u0003B\u0001Y2\u0004,\u0012)A,\u0007b\u0001!\u0006Aam\u001c:fC\u000eD''\u0006\u0004\u0004B\u000e-7q\u001a\u000b\u0007\u0007\u0007\u001c\tn!6\u0015\u0007u\u001a)\r\u0003\u0004I5\u0001\u00071q\u0019\t\tq\u0005-8\u0011ZBg{A\u0019Qja3\u0005\u000b=S\"\u0019\u0001)\u0011\u00075\u001by\rB\u0003Z5\t\u0007\u0001\u000b\u0003\u0004_5\u0001\u000711\u001b\t\u0005A\u000e\u001cI\r\u0003\u0004h5\u0001\u00071q\u001b\t\u0005A\u000e\u001ci-\u0001\u0005g_J,\u0017m\u001954+!\u0019ina:\u0004l\u000e=H\u0003CBp\u0007c\u001c)p!?\u0015\u0007u\u001a\t\u000f\u0003\u0004I7\u0001\u000711\u001d\t\nq)\u001b)o!;\u0004nv\u00022!TBt\t\u0015y5D1\u0001Q!\ri51\u001e\u0003\u00063n\u0011\r\u0001\u0015\t\u0004\u001b\u000e=H!\u0002/\u001c\u0005\u0004\u0001\u0006B\u00020\u001c\u0001\u0004\u0019\u0019\u0010\u0005\u0003aG\u000e\u0015\bBB4\u001c\u0001\u0004\u00199\u0010\u0005\u0003aG\u000e%\bB\u00026\u001c\u0001\u0004\u0019Y\u0010\u0005\u0003aG\u000e5\u0018aB3ySN$8OM\u000b\u0007\t\u0003!Y\u0001b\u0004\u0015\r\u0011\rA\u0011\u0003C\u000b)\r!EQ\u0001\u0005\u0007\u0011r\u0001\r\u0001b\u0002\u0011\u0011a\nY\u000f\"\u0003\u0005\u000e\u0011\u00032!\u0014C\u0006\t\u0015yED1\u0001Q!\riEq\u0002\u0003\u00063r\u0011\r\u0001\u0015\u0005\u0007=r\u0001\r\u0001b\u0005\u0011\t\u0001\u001cG\u0011\u0002\u0005\u0007Or\u0001\r\u0001b\u0006\u0011\t\u0001\u001cGQB\u0001\bKbL7\u000f^:4+!!i\u0002b\n\u0005,\u0011=B\u0003\u0003C\u0010\tc!)\u0004\"\u000f\u0015\u0007\u0011#\t\u0003\u0003\u0004I;\u0001\u0007A1\u0005\t\nq)#)\u0003\"\u000b\u0005.\u0011\u00032!\u0014C\u0014\t\u0015yUD1\u0001Q!\riE1\u0006\u0003\u00063v\u0011\r\u0001\u0015\t\u0004\u001b\u0012=B!\u0002/\u001e\u0005\u0004\u0001\u0006B\u00020\u001e\u0001\u0004!\u0019\u0004\u0005\u0003aG\u0012\u0015\u0002BB4\u001e\u0001\u0004!9\u0004\u0005\u0003aG\u0012%\u0002B\u00026\u001e\u0001\u0004!Y\u0004\u0005\u0003aG\u00125\u0012a\u00024pe\u0006dGnM\u000b\t\t\u0003\"Y\u0005b\u0014\u0005TQAA1\tC+\t3\"i\u0006F\u0002E\t\u000bBa\u0001\u0013\u0010A\u0002\u0011\u001d\u0003#\u0003\u001dK\t\u0013\"i\u0005\"\u0015E!\riE1\n\u0003\u0006\u001fz\u0011\r\u0001\u0015\t\u0004\u001b\u0012=C!B-\u001f\u0005\u0004\u0001\u0006cA'\u0005T\u0011)AL\bb\u0001!\"1aL\ba\u0001\t/\u0002B\u0001Y2\u0005J!1qM\ba\u0001\t7\u0002B\u0001Y2\u0005N!1!N\ba\u0001\t?\u0002B\u0001Y2\u0005R\u0005QQ.\u00199GS2$XM\u001d\u001a\u0016\u0011\u0011\u0015D\u0011\u0010C?\tc\"b\u0001b\u001a\u0005\u0002\u0012\u001dE\u0003\u0002C5\tg\u0002R\u0001\u0019C6\t_J1\u0001\"\u001cf\u0005!IE/\u001a:bi>\u0014\bcA'\u0005r\u0011)Al\bb\u0001!\"1\u0001j\ba\u0001\tk\u0002\u0012\u0002OAv\to\"Y\bb \u0011\u00075#I\bB\u0003P?\t\u0007\u0001\u000bE\u0002N\t{\"Q!W\u0010C\u0002A\u0003R\u0001OA(\t_Bq\u0001b! \u0001\u0004!))A\u0002ji\u0006\u0003R\u0001\u0019C6\toBq\u0001\"# \u0001\u0004!Y)A\u0002ji\n\u0003R\u0001\u0019C6\tw\n1b]3rk\u0016t7-Z(qiV!A\u0011\u0013CM)\u0011!\u0019\nb'\u0011\u000ba\ny\u0005\"&\u0011\t\u0001\u001cGq\u0013\t\u0004\u001b\u0012eE!B(!\u0005\u0004\u0001\u0006bBATA\u0001\u0007AQ\u0014\t\u0005A\u000e$y\nE\u00039\u0003\u001f\"9*A\u0006ue\u00064XM]:f\u001fB$XC\u0002CS\to#y\u000b\u0006\u0003\u0005(\u0012mF\u0003\u0002CU\tc\u0003R\u0001OA(\tW\u0003B\u0001Y2\u0005.B\u0019Q\nb,\u0005\u000be\u000b#\u0019\u0001)\t\r!\u000b\u0003\u0019\u0001CZ!\u0019A$\u0010\".\u0005:B\u0019Q\nb.\u0005\u000b=\u000b#\u0019\u0001)\u0011\u000ba\ny\u0005\",\t\u000f\u0005\u001d\u0016\u00051\u0001\u0005>B!\u0001m\u0019C[\u0003E\u0011\u0017\u000e^*fi\nK\bK]3eS\u000e\fG/Z\u000b\u0005\t\u0007$)\u000e\u0006\u0003\u0005F\u0012]G\u0003\u0002Cd\t\u001b\u0004Baa\u0019\u0005J&!A1ZB3\u0005\u0019\u0011\u0015\u000e^*fi\"9Aq\u001a\u0012A\u0002\u0011E\u0017\u0001\u00029sK\u0012\u0004R\u0001\u000f>\u0005T\u0012\u00032!\u0014Ck\t\u0015y%E1\u0001Q\u0011\u001d\u0011IB\ta\u0001\t3\u0004B\u0001Y2\u0005T\u0006A1/Z9vK:\u001cW-\u0006\u0003\u0005`\u0012\u001dH\u0003\u0002Cq\tS\u0004R\u0001OA(\tG\u0004B\u0001Y2\u0005fB\u0019Q\nb:\u0005\u000b=\u001b#\u0019\u0001)\t\u000f\u0005\u001d6\u00051\u0001\u0005lB!\u0001m\u0019Cw!\u0015A\u0014q\nCs\u00035!(/\u00198ta>\u001cXmU1gKV!A1\u001fC\u007f)\u0011!)\u0010b@\u0011\u000ba\ny\u0005b>\u0011\t\u0001\u001cG\u0011 \t\u0005A\u000e$Y\u0010E\u0002N\t{$Qa\u0014\u0013C\u0002ACq!\"\u0001%\u0001\u0004!90A\u0002bgN\f!b]1nK2+gn\u001a;i)\u0015!UqAC\n\u0011\u0019qV\u00051\u0001\u0006\nA\"Q1BC\b!\u0011\u00017-\"\u0004\u0011\u00075+y\u0001B\u0006\u0006\u0012\u0015\u001d\u0011\u0011!A\u0001\u0006\u0003\u0001&aA0%e!1q-\na\u0001\u000b+\u0001D!b\u0006\u0006\u001cA!\u0001mYC\r!\riU1\u0004\u0003\f\u000b;)\u0019\"!A\u0001\u0002\u000b\u0005\u0001KA\u0002`IM\nabY8na\u0006\u0014X\rT3oORD7\u000f\u0006\u0004\u0003x\u0016\rRq\u0006\u0005\u0007=\u001a\u0002\r!\"\n1\t\u0015\u001dR1\u0006\t\u0005A\u000e,I\u0003E\u0002N\u000bW!1\"\"\f\u0006$\u0005\u0005\t\u0011!B\u0001!\n\u0019q\f\n\u001b\t\r\u001d4\u0003\u0019AC\u0019a\u0011)\u0019$b\u000e\u0011\t\u0001\u001cWQ\u0007\t\u0004\u001b\u0016]BaCC\u001d\u000b_\t\t\u0011!A\u0003\u0002A\u00131a\u0018\u00136Q\t1S.A\u0005iCNdUM\\4uQR)A)\"\u0011\u0006N!9!\u0011D\u0014A\u0002\u0015\r\u0003\u0007BC#\u000b\u0013\u0002B\u0001Y2\u0006HA\u0019Q*\"\u0013\u0005\u0017\u0015-S\u0011IA\u0001\u0002\u0003\u0015\t\u0001\u0015\u0002\u0004?\u00122\u0004bBC(O\u0001\u0007!q_\u0001\u0004Y\u0016t\u0017aB:v[NK'0\u001a\u000b\u0007\u0005o,)&b\u0019\t\r}D\u0003\u0019AC,!\u0011\u00017-\"\u00171\t\u0015mSq\f\t\u0005A\u000e,i\u0006E\u0002N\u000b?\"1\"\"\u0019\u0006V\u0005\u0005\t\u0011!B\u0001!\n\u0019q\fJ\u001c\t\u000f\u0015\u0015\u0004\u00061\u0001\u0003x\u0006\u0019\u0011mY2)\u0005!j\u0017aC\"pY2,7\r^5p]N\u00042!\"\u001c+\u001b\u0005i3\u0003\u0002\u00168\u000bc\u00022!\"\u001c\u0001\u0003\u0019a\u0014N\\5u}Q\u0011Q1\u000e")
public interface Collections {
    public static /* synthetic */ boolean corresponds3$(Collections $this, List xs1, List xs2, List xs3, Function3 f) {
        return $this.corresponds3(xs1, xs2, xs3, f);
    }

    default public <A, B, C> boolean corresponds3(List<A> xs1, List<B> xs2, List<C> xs3, Function3<A, B, C, Object> f) {
        while (true) {
            if (xs1.isEmpty()) {
                return xs2.isEmpty() && xs3.isEmpty();
            }
            if (xs2.isEmpty() || xs3.isEmpty() || !BoxesRunTime.unboxToBoolean(f.apply(xs1.head(), xs2.head(), xs3.head()))) break;
            xs3 = (List)xs3.tail();
            xs2 = (List)xs2.tail();
            xs1 = (List)xs1.tail();
        }
        return false;
    }

    public static /* synthetic */ boolean mexists$(Collections $this, List xss, Function1 p) {
        return $this.mexists(xss, p);
    }

    default public <A> boolean mexists(List<List<A>> xss, Function1<A, Object> p) {
        boolean bl;
        block7: {
            if (xss == null) {
                throw null;
            }
            LinearSeqOptimized exists_these = xss;
            while (!exists_these.isEmpty()) {
                boolean bl2;
                block6: {
                    List list = (List)exists_these.head();
                    if (list == null) {
                        throw null;
                    }
                    LinearSeqOptimized $anonfun$mexists$1$adapted_$anonfun$mexists$1_exists_these = list;
                    while (!$anonfun$mexists$1$adapted_$anonfun$mexists$1_exists_these.isEmpty()) {
                        if (BoxesRunTime.unboxToBoolean(p.apply($anonfun$mexists$1$adapted_$anonfun$mexists$1_exists_these.head()))) {
                            bl2 = true;
                            break block6;
                        }
                        $anonfun$mexists$1$adapted_$anonfun$mexists$1_exists_these = (LinearSeqOptimized)$anonfun$mexists$1$adapted_$anonfun$mexists$1_exists_these.tail();
                    }
                    bl2 = false;
                }
                if (bl2) {
                    bl = true;
                    break block7;
                }
                exists_these = (LinearSeqOptimized)exists_these.tail();
            }
            bl = false;
        }
        return bl;
    }

    public static /* synthetic */ boolean mforall$(Collections $this, List xss, Function1 p) {
        return $this.mforall(xss, p);
    }

    default public <A> boolean mforall(List<List<A>> xss, Function1<A, Object> p) {
        boolean bl;
        block7: {
            if (xss == null) {
                throw null;
            }
            LinearSeqOptimized forall_these = xss;
            while (!forall_these.isEmpty()) {
                boolean bl2;
                block6: {
                    List list = (List)forall_these.head();
                    if (list == null) {
                        throw null;
                    }
                    LinearSeqOptimized $anonfun$mforall$1$adapted_$anonfun$mforall$1_forall_these = list;
                    while (!$anonfun$mforall$1$adapted_$anonfun$mforall$1_forall_these.isEmpty()) {
                        if (!BoxesRunTime.unboxToBoolean(p.apply($anonfun$mforall$1$adapted_$anonfun$mforall$1_forall_these.head()))) {
                            bl2 = false;
                            break block6;
                        }
                        $anonfun$mforall$1$adapted_$anonfun$mforall$1_forall_these = (LinearSeqOptimized)$anonfun$mforall$1$adapted_$anonfun$mforall$1_forall_these.tail();
                    }
                    bl2 = true;
                }
                if (!bl2) {
                    bl = false;
                    break block7;
                }
                forall_these = (LinearSeqOptimized)forall_these.tail();
            }
            bl = true;
        }
        return bl;
    }

    public static /* synthetic */ List mmap$(Collections $this, List xss, Function1 f) {
        return $this.mmap(xss, f);
    }

    default public <A, B> List<List<B>> mmap(List<List<A>> xss, Function1<A, B> f) {
        return xss.map((Function1<List, List> & java.io.Serializable & Serializable)x$3 -> x$3.map(f, List$.MODULE$.canBuildFrom()), List$.MODULE$.canBuildFrom());
    }

    public static /* synthetic */ Option mfind$(Collections $this, List xss, Function1 p) {
        return $this.mfind(xss, p);
    }

    default public <A> Option<A> mfind(List<List<A>> xss, Function1<A, Object> p) {
        ObjectRef<Object> res = ObjectRef.create(null);
        Function1<Object, Object> & java.io.Serializable & Serializable mforeach_f = (Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
            if ((Option)res$1.elem == null && BoxesRunTime.unboxToBoolean(p.apply(x))) {
                res$1.elem = new Some<Object>(x);
            }
            return BoxedUnit.UNIT;
        };
        if (xss == null) {
            throw null;
        }
        List mforeach_foreach_these = xss;
        while (!mforeach_foreach_these.isEmpty()) {
            List list = mforeach_foreach_these.head();
            if (list == null) {
                throw null;
            }
            List $anonfun$mforeach$1$adapted_$anonfun$mforeach$1_foreach_these = list;
            while (!$anonfun$mforeach$1$adapted_$anonfun$mforeach$1_foreach_these.isEmpty()) {
                mforeach_f.apply($anonfun$mforeach$1$adapted_$anonfun$mforeach$1_foreach_these.head());
                $anonfun$mforeach$1$adapted_$anonfun$mforeach$1_foreach_these = (List)$anonfun$mforeach$1$adapted_$anonfun$mforeach$1_foreach_these.tail();
            }
            mforeach_foreach_these = (List)mforeach_foreach_these.tail();
        }
        if ((Option)res.elem == null) {
            return None$.MODULE$;
        }
        return (Option)res.elem;
    }

    public static /* synthetic */ void mforeach$(Collections $this, List xss, Function1 f) {
        $this.mforeach(xss, f);
    }

    default public <A> void mforeach(List<List<A>> xss, Function1<A, BoxedUnit> f) {
        if (xss == null) {
            throw null;
        }
        List foreach_these = xss;
        while (!foreach_these.isEmpty()) {
            List list = foreach_these.head();
            if (list == null) {
                throw null;
            }
            List $anonfun$mforeach$1$adapted_$anonfun$mforeach$1_foreach_these = list;
            while (!$anonfun$mforeach$1$adapted_$anonfun$mforeach$1_foreach_these.isEmpty()) {
                f.apply($anonfun$mforeach$1$adapted_$anonfun$mforeach$1_foreach_these.head());
                $anonfun$mforeach$1$adapted_$anonfun$mforeach$1_foreach_these = (List)$anonfun$mforeach$1$adapted_$anonfun$mforeach$1_foreach_these.tail();
            }
            foreach_these = (List)foreach_these.tail();
        }
    }

    public static /* synthetic */ void mforeach$(Collections $this, Traversable xss, Function1 f) {
        $this.mforeach(xss, f);
    }

    default public <A> void mforeach(Traversable<Traversable<A>> xss, Function1<A, BoxedUnit> f) {
        xss.foreach((Function1<Traversable, Object> & java.io.Serializable & Serializable)x$5 -> {
            x$5.foreach(f);
            return BoxedUnit.UNIT;
        });
    }

    public static /* synthetic */ List mapList$(Collections $this, List as, Function1 f) {
        return $this.mapList(as, f);
    }

    /*
     * WARNING - void declaration
     */
    default public <A, B> List<B> mapList(List<A> as, Function1<A, B> f) {
        void var3_3;
        $colon$colon<Nothing$> head;
        if (as == Nil$.MODULE$) {
            return Nil$.MODULE$;
        }
        $colon$colon<Nothing$> tail = head = new $colon$colon<Nothing$>((Nothing$)f.apply(as.head()), Nil$.MODULE$);
        for (List rest = (List)as.tail(); rest != Nil$.MODULE$; rest = (List)rest.tail()) {
            $colon$colon<Nothing$> next = new $colon$colon<Nothing$>((Nothing$)f.apply(rest.head()), Nil$.MODULE$);
            tail.tl_$eq(next);
            tail = next;
        }
        return var3_3;
    }

    public static /* synthetic */ boolean sameElementsEquals$(Collections $this, List thiss, List that) {
        return $this.sameElementsEquals(thiss, that);
    }

    default public boolean sameElementsEquals(List<Object> thiss, List<Object> that) {
        block4: {
            block3: {
                if (thiss == that) break block3;
                List these = thiss;
                List those = that;
                while (!these.isEmpty() && !those.isEmpty() && these.head().equals(those.head())) {
                    these = (List)these.tail();
                    those = (List)those.tail();
                }
                if (!(these.isEmpty() && those.isEmpty())) break block4;
            }
            return true;
        }
        return false;
    }

    public static /* synthetic */ Option collectFirst$(Collections $this, List as, PartialFunction pf) {
        return $this.collectFirst(as, pf);
    }

    default public <A, B> Option<B> collectFirst(List<A> as, PartialFunction<A, B> pf) {
        return this.loop$1(as, pf);
    }

    public static /* synthetic */ List map2$(Collections $this, List xs1, List xs2, Function2 f) {
        return $this.map2(xs1, xs2, f);
    }

    default public <A, B, C> List<C> map2(List<A> xs1, List<B> xs2, Function2<A, B, C> f) {
        ListBuffer lb = new ListBuffer();
        List ys1 = xs1;
        List ys2 = xs2;
        while (!ys1.isEmpty() && !ys2.isEmpty()) {
            lb.$plus$eq(f.apply(ys1.head(), ys2.head()));
            ys1 = (List)ys1.tail();
            ys2 = (List)ys2.tail();
        }
        return lb.toList();
    }

    public static /* synthetic */ List map2Conserve$(Collections $this, List xs, List ys, Function2 f) {
        return $this.map2Conserve(xs, ys, f);
    }

    default public <A, B> List<A> map2Conserve(List<A> xs, List<B> ys, Function2<A, B, A> f) {
        List<B> list = ys;
        List<A> list2 = xs;
        List<A> list3 = xs;
        ListBuffer loop$2_mapped = null;
        while (true) {
            List loop$2_tail1;
            Object loop$2_head01;
            List loop$2_unchanged;
            List loop$2_pending1;
            List loop$2_pending0;
            if (loop$2_pending0.isEmpty() || loop$2_pending1.isEmpty()) {
                if (loop$2_mapped == null) {
                    return loop$2_unchanged;
                }
                return loop$2_mapped.prependToList(loop$2_unchanged);
            }
            Object loop$2_head00 = loop$2_pending0.head();
            A loop$2_head1 = f.apply(loop$2_head00, loop$2_head01 = loop$2_pending1.head());
            if (loop$2_head1 == loop$2_head00) {
                loop$2_pending1 = (List)loop$2_pending1.tail();
                loop$2_pending0 = (List)loop$2_pending0.tail();
                continue;
            }
            ListBuffer loop$2_b = loop$2_mapped == null ? new ListBuffer() : loop$2_mapped;
            for (List loop$2_xc = loop$2_unchanged; loop$2_xc != loop$2_pending0 && loop$2_xc != loop$2_pending1; loop$2_xc = (List)loop$2_xc.tail()) {
                loop$2_b.$plus$eq(loop$2_xc.head());
            }
            loop$2_b.$plus$eq((Object)loop$2_head1);
            List loop$2_tail0 = (List)loop$2_pending0.tail();
            loop$2_pending1 = loop$2_tail1 = (List)loop$2_pending1.tail();
            loop$2_pending0 = loop$2_tail0;
            loop$2_unchanged = loop$2_tail0;
            loop$2_mapped = loop$2_b;
        }
    }

    public static /* synthetic */ List map3$(Collections $this, List xs1, List xs2, List xs3, Function3 f) {
        return $this.map3(xs1, xs2, xs3, f);
    }

    default public <A, B, C, D> List<D> map3(List<A> xs1, List<B> xs2, List<C> xs3, Function3<A, B, C, D> f) {
        if (xs1.isEmpty() || xs2.isEmpty() || xs3.isEmpty()) {
            return Nil$.MODULE$;
        }
        D d = f.apply(xs1.head(), xs2.head(), xs3.head());
        return this.map3((List)xs1.tail(), (List)xs2.tail(), (List)xs3.tail(), f).$colon$colon(d);
    }

    public static /* synthetic */ List flatMap2$(Collections $this, List xs1, List xs2, Function2 f) {
        return $this.flatMap2(xs1, xs2, f);
    }

    default public <A, B, C> List<C> flatMap2(List<A> xs1, List<B> xs2, Function2<A, B, List<C>> f) {
        ListBuffer lb = null;
        List ys1 = xs1;
        List ys2 = xs2;
        while (!ys1.isEmpty() && !ys2.isEmpty()) {
            List<C> cs = f.apply(ys1.head(), ys2.head());
            if (cs != Nil$.MODULE$) {
                if (lb == null) {
                    lb = new ListBuffer();
                }
                lb.$plus$plus$eq((TraversableOnce)cs);
            }
            ys1 = (List)ys1.tail();
            ys2 = (List)ys2.tail();
        }
        if (lb == null) {
            return Nil$.MODULE$;
        }
        return lb.result();
    }

    public static /* synthetic */ Object foldLeft2$(Collections $this, List xs1, List xs2, Object z0, Function3 f) {
        return $this.foldLeft2(xs1, xs2, z0, f);
    }

    default public <A1, A2, B> B foldLeft2(List<A1> xs1, List<A2> xs2, B z0, Function3<B, A1, A2, B> f) {
        List ys1 = xs1;
        List ys2 = xs2;
        B res = z0;
        while (!ys1.isEmpty() && !ys2.isEmpty()) {
            res = f.apply(res, ys1.head(), ys2.head());
            ys1 = (List)ys1.tail();
            ys2 = (List)ys2.tail();
        }
        return res;
    }

    public static /* synthetic */ List flatCollect$(Collections $this, List elems, PartialFunction pf) {
        return $this.flatCollect(elems, pf);
    }

    default public <A, B> List<B> flatCollect(List<A> elems, PartialFunction<A, Traversable<B>> pf) {
        ListBuffer lb = new ListBuffer();
        elems.withFilter((Function1<Object, Object> & java.io.Serializable & Serializable)x -> BoxesRunTime.boxToBoolean(pf.isDefinedAt(x))).foreach((Function1<Object, ListBuffer> & java.io.Serializable & Serializable)x -> lb.$plus$plus$eq((TraversableOnce)pf.apply(x)));
        return lb.toList();
    }

    public static /* synthetic */ List distinctBy$(Collections $this, List xs, Function1 f) {
        return $this.distinctBy(xs, f);
    }

    default public <A, B> List<A> distinctBy(List<A> xs, Function1<A, B> f) {
        ListBuffer buf = new ListBuffer();
        Set seen = (Set)Set$.MODULE$.apply(Nil$.MODULE$);
        if (xs == null) {
            throw null;
        }
        List foreach_these = xs;
        while (!foreach_these.isEmpty()) {
            A a = foreach_these.head();
            Collections.$anonfun$distinctBy$1(f, seen, buf, a);
            foreach_these = (List)foreach_these.tail();
        }
        return buf.toList();
    }

    public static /* synthetic */ boolean flattensToEmpty$(Collections $this, Seq xss) {
        return $this.flattensToEmpty(xss);
    }

    default public boolean flattensToEmpty(Seq<Seq<?>> xss) {
        block2: {
            while (!xss.isEmpty()) {
                if (((SeqLike)xss.head()).isEmpty()) {
                    xss = (Seq)xss.tail();
                    continue;
                }
                break block2;
            }
            return true;
        }
        return false;
    }

    public static /* synthetic */ void foreachWithIndex$(Collections $this, List xs, Function2 f) {
        $this.foreachWithIndex(xs, f);
    }

    default public <A> void foreachWithIndex(List<A> xs, Function2<A, Object, BoxedUnit> f) {
        int index = 0;
        List ys = xs;
        while (!ys.isEmpty()) {
            f.apply(ys.head(), BoxesRunTime.boxToInteger(index));
            ys = (List)ys.tail();
            ++index;
        }
    }

    public static /* synthetic */ Object findOrElse$(Collections $this, TraversableOnce xs, Function1 p, Function0 orElse) {
        return $this.findOrElse(xs, p, orElse);
    }

    default public <A> A findOrElse(TraversableOnce<A> xs, Function1<A, Object> p, Function0<A> orElse) {
        Option<A> option = xs.find(p);
        if (option == null) {
            throw null;
        }
        Option<A> getOrElse_this = option;
        A a = getOrElse_this.isEmpty() ? orElse.apply() : getOrElse_this.get();
        return a;
    }

    public static /* synthetic */ Map mapFrom$(Collections $this, List xs, Function1 f) {
        return $this.mapFrom(xs, f);
    }

    default public <A, A1, B> Map<A1, B> mapFrom(List<A> xs, Function1<A, B> f) {
        return (Map)Predef$.MODULE$.Map().apply(xs.map((Function1<Object, Tuple2> & java.io.Serializable & Serializable)x -> new Tuple2(x, f.apply(x)), List$.MODULE$.canBuildFrom()));
    }

    public static /* synthetic */ LinkedHashMap linkedMapFrom$(Collections $this, List xs, Function1 f) {
        return $this.linkedMapFrom(xs, f);
    }

    default public <A, A1, B> LinkedHashMap<A1, B> linkedMapFrom(List<A> xs, Function1<A, B> f) {
        return (LinkedHashMap)LinkedHashMap$.MODULE$.apply(xs.map((Function1<Object, Tuple2> & java.io.Serializable & Serializable)x -> new Tuple2(x, f.apply(x)), List$.MODULE$.canBuildFrom()));
    }

    public static /* synthetic */ List mapWithIndex$(Collections $this, List xs, Function2 f) {
        return $this.mapWithIndex(xs, f);
    }

    default public <A, B> List<B> mapWithIndex(List<A> xs, Function2<A, Object, B> f) {
        ListBuffer lb = new ListBuffer();
        int index = 0;
        List ys = xs;
        while (!ys.isEmpty()) {
            lb.$plus$eq(f.apply(ys.head(), BoxesRunTime.boxToInteger(index)));
            ys = (List)ys.tail();
            ++index;
        }
        return lb.toList();
    }

    public static /* synthetic */ Map collectMap2$(Collections $this, List xs1, List xs2, Function2 p) {
        return $this.collectMap2(xs1, xs2, p);
    }

    default public <A, B, C> Map<A, B> collectMap2(List<A> xs1, List<B> xs2, Function2<A, B, Object> p) {
        if (xs1.isEmpty() || xs2.isEmpty()) {
            return (Map)Predef$.MODULE$.Map().apply(Nil$.MODULE$);
        }
        Builder buf = Map$.MODULE$.newBuilder();
        List ys1 = xs1;
        List ys2 = xs2;
        while (!ys1.isEmpty() && !ys2.isEmpty()) {
            B x2;
            A x1 = ys1.head();
            if (BoxesRunTime.unboxToBoolean(p.apply(x1, x2 = ys2.head()))) {
                buf.$plus$eq(new Tuple2<A, B>(x1, x2));
            }
            ys1 = (List)ys1.tail();
            ys2 = (List)ys2.tail();
        }
        return buf.result();
    }

    public static /* synthetic */ void foreach2$(Collections $this, List xs1, List xs2, Function2 f) {
        $this.foreach2(xs1, xs2, f);
    }

    default public <A, B> void foreach2(List<A> xs1, List<B> xs2, Function2<A, B, BoxedUnit> f) {
        List ys1 = xs1;
        List ys2 = xs2;
        while (!ys1.isEmpty() && !ys2.isEmpty()) {
            f.apply(ys1.head(), ys2.head());
            ys1 = (List)ys1.tail();
            ys2 = (List)ys2.tail();
        }
    }

    public static /* synthetic */ void foreach3$(Collections $this, List xs1, List xs2, List xs3, Function3 f) {
        $this.foreach3(xs1, xs2, xs3, f);
    }

    default public <A, B, C> void foreach3(List<A> xs1, List<B> xs2, List<C> xs3, Function3<A, B, C, BoxedUnit> f) {
        List ys1 = xs1;
        List ys2 = xs2;
        List ys3 = xs3;
        while (!(ys1.isEmpty() || ys2.isEmpty() || ys3.isEmpty())) {
            f.apply(ys1.head(), ys2.head(), ys3.head());
            ys1 = (List)ys1.tail();
            ys2 = (List)ys2.tail();
            ys3 = (List)ys3.tail();
        }
    }

    public static /* synthetic */ boolean exists2$(Collections $this, List xs1, List xs2, Function2 f) {
        return $this.exists2(xs1, xs2, f);
    }

    default public <A, B> boolean exists2(List<A> xs1, List<B> xs2, Function2<A, B, Object> f) {
        List ys1 = xs1;
        List ys2 = xs2;
        while (!ys1.isEmpty() && !ys2.isEmpty()) {
            if (BoxesRunTime.unboxToBoolean(f.apply(ys1.head(), ys2.head()))) {
                return true;
            }
            ys1 = (List)ys1.tail();
            ys2 = (List)ys2.tail();
        }
        return false;
    }

    public static /* synthetic */ boolean exists3$(Collections $this, List xs1, List xs2, List xs3, Function3 f) {
        return $this.exists3(xs1, xs2, xs3, f);
    }

    default public <A, B, C> boolean exists3(List<A> xs1, List<B> xs2, List<C> xs3, Function3<A, B, C, Object> f) {
        List ys1 = xs1;
        List ys2 = xs2;
        List ys3 = xs3;
        while (!(ys1.isEmpty() || ys2.isEmpty() || ys3.isEmpty())) {
            if (BoxesRunTime.unboxToBoolean(f.apply(ys1.head(), ys2.head(), ys3.head()))) {
                return true;
            }
            ys1 = (List)ys1.tail();
            ys2 = (List)ys2.tail();
            ys3 = (List)ys3.tail();
        }
        return false;
    }

    public static /* synthetic */ boolean forall3$(Collections $this, List xs1, List xs2, List xs3, Function3 f) {
        return $this.forall3(xs1, xs2, xs3, f);
    }

    default public <A, B, C> boolean forall3(List<A> xs1, List<B> xs2, List<C> xs3, Function3<A, B, C, Object> f) {
        List ys1 = xs1;
        List ys2 = xs2;
        List ys3 = xs3;
        while (!(ys1.isEmpty() || ys2.isEmpty() || ys3.isEmpty())) {
            if (!BoxesRunTime.unboxToBoolean(f.apply(ys1.head(), ys2.head(), ys3.head()))) {
                return false;
            }
            ys1 = (List)ys1.tail();
            ys2 = (List)ys2.tail();
            ys3 = (List)ys3.tail();
        }
        return true;
    }

    public static /* synthetic */ Iterator mapFilter2$(Collections $this, Iterator itA, Iterator itB, Function2 f) {
        return $this.mapFilter2(itA, itB, f);
    }

    default public <A, B, C> Iterator<C> mapFilter2(Iterator<A> itA, Iterator<B> itB, Function2<A, B, Option<C>> f) {
        return new Iterator<C>(null, itA, itB, f){
            private Option<C> head;
            private final Iterator itA$1;
            private final Iterator itB$1;
            private final Function2 f$8;

            public Iterator<C> seq() {
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

            public Iterator<C> take(int n) {
                return Iterator.take$(this, n);
            }

            public Iterator<C> drop(int n) {
                return Iterator.drop$(this, n);
            }

            public Iterator<C> slice(int from, int until) {
                return Iterator.slice$(this, from, until);
            }

            public Iterator<C> sliceIterator(int from, int until) {
                return Iterator.sliceIterator$(this, from, until);
            }

            public <B> Iterator<B> map(Function1<C, B> f) {
                return Iterator.map$(this, f);
            }

            public <B> Iterator<B> $plus$plus(Function0<GenTraversableOnce<B>> that) {
                return Iterator.$plus$plus$(this, that);
            }

            public <B> Iterator<B> flatMap(Function1<C, GenTraversableOnce<B>> f) {
                return Iterator.flatMap$(this, f);
            }

            public Iterator<C> filter(Function1<C, Object> p) {
                return Iterator.filter$(this, p);
            }

            public <B> boolean corresponds(GenTraversableOnce<B> that, Function2<C, B, Object> p) {
                return Iterator.corresponds$(this, that, p);
            }

            public Iterator<C> withFilter(Function1<C, Object> p) {
                return Iterator.withFilter$(this, p);
            }

            public Iterator<C> filterNot(Function1<C, Object> p) {
                return Iterator.filterNot$(this, p);
            }

            public <B> Iterator<B> collect(PartialFunction<C, B> pf) {
                return Iterator.collect$(this, pf);
            }

            public <B> Iterator<B> scanLeft(B z, Function2<B, C, B> op) {
                return Iterator.scanLeft$(this, z, op);
            }

            public <B> Iterator<B> scanRight(B z, Function2<C, B, B> op) {
                return Iterator.scanRight$(this, z, op);
            }

            public Iterator<C> takeWhile(Function1<C, Object> p) {
                return Iterator.takeWhile$(this, p);
            }

            public Tuple2<Iterator<C>, Iterator<C>> partition(Function1<C, Object> p) {
                return Iterator.partition$(this, p);
            }

            public Tuple2<Iterator<C>, Iterator<C>> span(Function1<C, Object> p) {
                return Iterator.span$(this, p);
            }

            public Iterator<C> dropWhile(Function1<C, Object> p) {
                return Iterator.dropWhile$(this, p);
            }

            public <B> Iterator<Tuple2<C, B>> zip(Iterator<B> that) {
                return Iterator.zip$(this, that);
            }

            public <A1> Iterator<A1> padTo(int len, A1 elem) {
                return Iterator.padTo$(this, len, elem);
            }

            public Iterator<Tuple2<C, Object>> zipWithIndex() {
                return Iterator.zipWithIndex$(this);
            }

            public <B, A1, B1> Iterator<Tuple2<A1, B1>> zipAll(Iterator<B> that, A1 thisElem, B1 thatElem) {
                return Iterator.zipAll$(this, that, thisElem, thatElem);
            }

            public <U> void foreach(Function1<C, U> f) {
                Iterator.foreach$(this, f);
            }

            public boolean forall(Function1<C, Object> p) {
                return Iterator.forall$(this, p);
            }

            public boolean exists(Function1<C, Object> p) {
                return Iterator.exists$(this, p);
            }

            public boolean contains(Object elem) {
                return Iterator.contains$(this, elem);
            }

            public Option<C> find(Function1<C, Object> p) {
                return Iterator.find$(this, p);
            }

            public int indexWhere(Function1<C, Object> p) {
                return Iterator.indexWhere$(this, p);
            }

            public int indexWhere(Function1<C, Object> p, int from) {
                return Iterator.indexWhere$(this, p, from);
            }

            public <B> int indexOf(B elem) {
                return Iterator.indexOf$(this, elem);
            }

            public <B> int indexOf(B elem, int from) {
                return Iterator.indexOf$(this, elem, from);
            }

            public BufferedIterator<C> buffered() {
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

            public Tuple2<Iterator<C>, Iterator<C>> duplicate() {
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

            public Traversable<C> toTraversable() {
                return Iterator.toTraversable$(this);
            }

            public Iterator<C> toIterator() {
                return Iterator.toIterator$(this);
            }

            public Stream<C> toStream() {
                return Iterator.toStream$(this);
            }

            public String toString() {
                return Iterator.toString$(this);
            }

            public List<C> reversed() {
                return TraversableOnce.reversed$(this);
            }

            public int size() {
                return TraversableOnce.size$(this);
            }

            public boolean nonEmpty() {
                return TraversableOnce.nonEmpty$(this);
            }

            public int count(Function1<C, Object> p) {
                return TraversableOnce.count$(this, p);
            }

            public <B> Option<B> collectFirst(PartialFunction<C, B> pf) {
                return TraversableOnce.collectFirst$(this, pf);
            }

            public <B> B $div$colon(B z, Function2<B, C, B> op) {
                return (B)TraversableOnce.$div$colon$(this, z, op);
            }

            public <B> B $colon$bslash(B z, Function2<C, B, B> op) {
                return (B)TraversableOnce.$colon$bslash$(this, z, op);
            }

            public <B> B foldLeft(B z, Function2<B, C, B> op) {
                return (B)TraversableOnce.foldLeft$(this, z, op);
            }

            public <B> B foldRight(B z, Function2<C, B, B> op) {
                return (B)TraversableOnce.foldRight$(this, z, op);
            }

            public <B> B reduceLeft(Function2<B, C, B> op) {
                return (B)TraversableOnce.reduceLeft$(this, op);
            }

            public <B> B reduceRight(Function2<C, B, B> op) {
                return (B)TraversableOnce.reduceRight$(this, op);
            }

            public <B> Option<B> reduceLeftOption(Function2<B, C, B> op) {
                return TraversableOnce.reduceLeftOption$(this, op);
            }

            public <B> Option<B> reduceRightOption(Function2<C, B, B> op) {
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

            public <B> B aggregate(Function0<B> z, Function2<B, C, B> seqop, Function2<B, B, B> combop) {
                return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
            }

            public <B> B sum(Numeric<B> num) {
                return (B)TraversableOnce.sum$(this, num);
            }

            public <B> B product(Numeric<B> num) {
                return (B)TraversableOnce.product$(this, num);
            }

            public <B> C min(Ordering<B> cmp) {
                return (C)TraversableOnce.min$(this, cmp);
            }

            public <B> C max(Ordering<B> cmp) {
                return (C)TraversableOnce.max$(this, cmp);
            }

            public <B> C maxBy(Function1<C, B> f, Ordering<B> cmp) {
                return (C)TraversableOnce.maxBy$(this, f, cmp);
            }

            public <B> C minBy(Function1<C, B> f, Ordering<B> cmp) {
                return (C)TraversableOnce.minBy$(this, f, cmp);
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

            public List<C> toList() {
                return TraversableOnce.toList$(this);
            }

            public Iterable<C> toIterable() {
                return TraversableOnce.toIterable$(this);
            }

            public Seq<C> toSeq() {
                return TraversableOnce.toSeq$(this);
            }

            public IndexedSeq<C> toIndexedSeq() {
                return TraversableOnce.toIndexedSeq$(this);
            }

            public <B> Buffer<B> toBuffer() {
                return TraversableOnce.toBuffer$(this);
            }

            public <B> scala.collection.immutable.Set<B> toSet() {
                return TraversableOnce.toSet$(this);
            }

            public Vector<C> toVector() {
                return TraversableOnce.toVector$(this);
            }

            public <Col> Col to(CanBuildFrom<Nothing$, C, Col> cbf) {
                return (Col)TraversableOnce.to$(this, cbf);
            }

            public <T, U> Map<T, U> toMap(Predef$.less.colon.less<C, Tuple2<T, U>> ev) {
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

            private void advanceHead() {
                while (this.head.isEmpty() && this.itA$1.hasNext() && this.itB$1.hasNext()) {
                    A x = this.itA$1.next();
                    A y = this.itB$1.next();
                    this.head = (Option)this.f$8.apply(x, y);
                }
            }

            public boolean hasNext() {
                this.advanceHead();
                return !this.head.isEmpty();
            }

            public C next() {
                this.advanceHead();
                Option<C> option = this.head;
                if (option == null) {
                    throw null;
                }
                Option<C> getOrElse_this = option;
                if (getOrElse_this.isEmpty()) {
                    throw $anon$1.$anonfun$next$1();
                }
                C c = getOrElse_this.get();
                this.head = None$.MODULE$;
                return c;
            }

            public static final /* synthetic */ Nothing$ $anonfun$next$1() {
                throw new NoSuchElementException("next on empty Iterator");
            }
            {
                this.itA$1 = itA$1;
                this.itB$1 = itB$1;
                this.f$8 = f$8;
                GenTraversableOnce.$init$(this);
                TraversableOnce.$init$(this);
                Iterator.$init$(this);
                this.head = None$.MODULE$;
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$next$1()}, serializedLambda);
            }
        };
    }

    public static /* synthetic */ Option sequenceOpt$(Collections $this, List as) {
        return $this.sequenceOpt(as);
    }

    default public <A> Option<List<A>> sequenceOpt(List<Option<A>> as) {
        Option option;
        block7: {
            Some some;
            if (as == Nil$.MODULE$) {
                some = package$.MODULE$.SomeOfNil();
            } else {
                ListBuffer traverseOpt_result = null;
                for (List traverseOpt_curr = as; traverseOpt_curr != Nil$.MODULE$; traverseOpt_curr = (List)traverseOpt_curr.tail()) {
                    Object traverseOpt_b;
                    Option option2 = Collections.$anonfun$sequenceOpt$1(traverseOpt_curr.head());
                    if (option2 instanceof Some) {
                        traverseOpt_b = ((Some)option2).value();
                        if (traverseOpt_result == null) {
                            traverseOpt_result = (ListBuffer)ListBuffer$.MODULE$.empty();
                        }
                    } else {
                        if (None$.MODULE$.equals(option2)) {
                            option = None$.MODULE$;
                            break block7;
                        }
                        throw new MatchError(option2);
                    }
                    traverseOpt_result.$plus$eq(traverseOpt_b);
                }
                some = new Some(traverseOpt_result.toList());
            }
            option = some;
        }
        return option;
    }

    public static /* synthetic */ Option traverseOpt$(Collections $this, List as, Function1 f) {
        return $this.traverseOpt(as, f);
    }

    default public <A, B> Option<List<B>> traverseOpt(List<A> as, Function1<A, Option<B>> f) {
        if (as == Nil$.MODULE$) {
            return package$.MODULE$.SomeOfNil();
        }
        ListBuffer result2 = null;
        for (List curr = as; curr != Nil$.MODULE$; curr = (List)curr.tail()) {
            Object b;
            Option<B> option = f.apply(curr.head());
            if (option instanceof Some) {
                b = ((Some)option).value();
                if (result2 == null) {
                    result2 = (ListBuffer)ListBuffer$.MODULE$.empty();
                }
            } else {
                if (None$.MODULE$.equals(option)) {
                    return None$.MODULE$;
                }
                throw new MatchError(option);
            }
            result2.$plus$eq(b);
        }
        return new Some<List<B>>(result2.toList());
    }

    public static /* synthetic */ BitSet bitSetByPredicate$(Collections $this, List xs, Function1 pred) {
        return $this.bitSetByPredicate(xs, pred);
    }

    /*
     * WARNING - void declaration
     */
    default public <A> BitSet bitSetByPredicate(List<A> xs, Function1<A, Object> pred) {
        void var3_3;
        BitSet bs = new BitSet();
        List ys = xs;
        int i = 0;
        while (!ys.isEmpty()) {
            if (BoxesRunTime.unboxToBoolean(pred.apply(ys.head()))) {
                bs.add(i);
            }
            ys = (List)ys.tail();
            ++i;
        }
        return var3_3;
    }

    public static /* synthetic */ Option sequence$(Collections $this, List as) {
        return $this.sequence(as);
    }

    default public <A> Option<List<A>> sequence(List<Option<A>> as) {
        boolean bl;
        block4: {
            if (as == null) {
                throw null;
            }
            LinearSeqOptimized exists_these = as;
            while (!exists_these.isEmpty()) {
                if (((Option)exists_these.head()).isEmpty()) {
                    bl = true;
                    break block4;
                }
                exists_these = (LinearSeqOptimized)exists_these.tail();
            }
            bl = false;
        }
        if (bl) {
            return None$.MODULE$;
        }
        return new Some<GenTraversable>(as.flatten((Function1<Option, Iterable> & java.io.Serializable & Serializable)xo -> Option$.MODULE$.option2Iterable(xo)));
    }

    public static /* synthetic */ Option transposeSafe$(Collections $this, List ass) {
        return $this.transposeSafe(ass);
    }

    default public <A> Option<List<List<A>>> transposeSafe(List<List<A>> ass) {
        try {
            return new Some<GenTraversable>(ass.transpose((Function1)Predef$.MODULE$.$conforms()));
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return None$.MODULE$;
        }
    }

    public static /* synthetic */ boolean sameLength$(Collections $this, List xs1, List xs2) {
        return $this.sameLength(xs1, xs2);
    }

    default public boolean sameLength(List<?> xs1, List<?> xs2) {
        return this.compareLengths(xs1, xs2) == 0;
    }

    public static /* synthetic */ int compareLengths$(Collections $this, List xs1, List xs2) {
        return $this.compareLengths(xs1, xs2);
    }

    default public int compareLengths(List<?> xs1, List<?> xs2) {
        while (true) {
            if (xs1.isEmpty()) {
                if (xs2.isEmpty()) {
                    return 0;
                }
                return -1;
            }
            if (xs2.isEmpty()) {
                return 1;
            }
            xs2 = (List)xs2.tail();
            xs1 = (List)xs1.tail();
        }
    }

    public static /* synthetic */ boolean hasLength$(Collections $this, List xs, int len) {
        return $this.hasLength(xs, len);
    }

    default public boolean hasLength(List<?> xs, int len) {
        return xs.lengthCompare(len) == 0;
    }

    public static /* synthetic */ int sumSize$(Collections $this, List xss, int acc) {
        return $this.sumSize(xss, acc);
    }

    default public int sumSize(List<List<?>> xss, int acc) {
        while (!xss.isEmpty()) {
            acc += ((SeqLike)xss.head()).size();
            xss = (List)xss.tail();
        }
        return acc;
    }

    public static /* synthetic */ boolean $anonfun$mexists$1(Function1 p$1, List x$1) {
        boolean bl;
        block3: {
            if (x$1 == null) {
                throw null;
            }
            LinearSeqOptimized exists_these = x$1;
            while (!exists_these.isEmpty()) {
                if (BoxesRunTime.unboxToBoolean(p$1.apply(exists_these.head()))) {
                    bl = true;
                    break block3;
                }
                exists_these = (LinearSeqOptimized)exists_these.tail();
            }
            bl = false;
        }
        return bl;
    }

    public static /* synthetic */ boolean $anonfun$mforall$1(Function1 p$2, List x$2) {
        boolean bl;
        block3: {
            if (x$2 == null) {
                throw null;
            }
            LinearSeqOptimized forall_these = x$2;
            while (!forall_these.isEmpty()) {
                if (!BoxesRunTime.unboxToBoolean(p$2.apply(forall_these.head()))) {
                    bl = false;
                    break block3;
                }
                forall_these = (LinearSeqOptimized)forall_these.tail();
            }
            bl = true;
        }
        return bl;
    }

    public static /* synthetic */ void $anonfun$mfind$1(ObjectRef res$1, Function1 p$3, Object x) {
        if ((Option)res$1.elem == null && BoxesRunTime.unboxToBoolean(p$3.apply(x))) {
            res$1.elem = new Some<Object>(x);
        }
    }

    public static /* synthetic */ void $anonfun$mforeach$1(Function1 f$2, List x$4) {
        if (x$4 == null) {
            throw null;
        }
        List foreach_these = x$4;
        while (!foreach_these.isEmpty()) {
            f$2.apply(foreach_these.head());
            foreach_these = (List)foreach_these.tail();
        }
    }

    public static /* synthetic */ void $anonfun$mforeach$2(Function1 f$3, Traversable x$5) {
        x$5.foreach(f$3);
    }

    private Option loop$1(List rest, PartialFunction pf$1) {
        Option option;
        block4: {
            while (true) {
                boolean bl = false;
                $colon$colon $colon$colon = null;
                if (((Object)Nil$.MODULE$).equals(rest)) {
                    option = None$.MODULE$;
                    break block4;
                }
                if (rest instanceof $colon$colon) {
                    bl = true;
                    $colon$colon = ($colon$colon)rest;
                    Object a = $colon$colon.head();
                    if (pf$1.isDefinedAt(a)) {
                        option = new Some(pf$1.apply(a));
                        break block4;
                    }
                }
                if (!bl) break;
                rest = $colon$colon.tl$access$1();
            }
            throw new MatchError(rest);
        }
        return option;
    }

    private List loop$2(ListBuffer mapped, List unchanged, List pending0, List pending1, Function2 f$4) {
        while (true) {
            List tail1;
            Object head01;
            if (pending0.isEmpty() || pending1.isEmpty()) {
                if (mapped == null) {
                    return unchanged;
                }
                return mapped.prependToList(unchanged);
            }
            Object head00 = pending0.head();
            Object head1 = f$4.apply(head00, head01 = pending1.head());
            if (head1 == head00) {
                pending1 = (List)pending1.tail();
                pending0 = (List)pending0.tail();
                continue;
            }
            ListBuffer b = mapped == null ? new ListBuffer() : mapped;
            for (List xc = unchanged; xc != pending0 && xc != pending1; xc = (List)xc.tail()) {
                b.$plus$eq(xc.head());
            }
            b.$plus$eq(head1);
            List tail0 = (List)pending0.tail();
            pending1 = tail1 = (List)pending1.tail();
            pending0 = tail0;
            unchanged = tail0;
            mapped = b;
        }
    }

    public static /* synthetic */ Object $anonfun$distinctBy$1(Function1 f$5, Set seen$1, ListBuffer buf$1, Object x) {
        Object y = f$5.apply(x);
        if (!seen$1.apply(y)) {
            buf$1.$plus$eq(x);
            return seen$1.$plus$eq(y);
        }
        return BoxedUnit.UNIT;
    }

    public static /* synthetic */ Option $anonfun$sequenceOpt$1(Option x) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return x;
    }

    public static void $init$(Collections $this) {
    }

    public static /* synthetic */ Object $anonfun$mexists$1$adapted(Function1 p$1, List x$1) {
        boolean bl;
        block3: {
            if (x$1 == null) {
                throw null;
            }
            LinearSeqOptimized $anonfun$mexists$1_exists_these = x$1;
            while (!$anonfun$mexists$1_exists_these.isEmpty()) {
                if (BoxesRunTime.unboxToBoolean(p$1.apply($anonfun$mexists$1_exists_these.head()))) {
                    bl = true;
                    break block3;
                }
                $anonfun$mexists$1_exists_these = (LinearSeqOptimized)$anonfun$mexists$1_exists_these.tail();
            }
            bl = false;
        }
        return BoxesRunTime.boxToBoolean(bl);
    }

    public static /* synthetic */ Object $anonfun$mforall$1$adapted(Function1 p$2, List x$2) {
        boolean bl;
        block3: {
            if (x$2 == null) {
                throw null;
            }
            LinearSeqOptimized $anonfun$mforall$1_forall_these = x$2;
            while (!$anonfun$mforall$1_forall_these.isEmpty()) {
                if (!BoxesRunTime.unboxToBoolean(p$2.apply($anonfun$mforall$1_forall_these.head()))) {
                    bl = false;
                    break block3;
                }
                $anonfun$mforall$1_forall_these = (LinearSeqOptimized)$anonfun$mforall$1_forall_these.tail();
            }
            bl = true;
        }
        return BoxesRunTime.boxToBoolean(bl);
    }

    public static /* synthetic */ Object $anonfun$mforeach$1$adapted(Function1 f$2, List x$4) {
        if (x$4 == null) {
            throw null;
        }
        List $anonfun$mforeach$1_foreach_these = x$4;
        while (!$anonfun$mforeach$1_foreach_these.isEmpty()) {
            f$2.apply($anonfun$mforeach$1_foreach_these.head());
            $anonfun$mforeach$1_foreach_these = (List)$anonfun$mforeach$1_foreach_these.tail();
        }
        return BoxedUnit.UNIT;
    }

    public static /* synthetic */ Object $anonfun$sequence$1$adapted(Option x$7) {
        return BoxesRunTime.boxToBoolean(x$7.isEmpty());
    }
}

