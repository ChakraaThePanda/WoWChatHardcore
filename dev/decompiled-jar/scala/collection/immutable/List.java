/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.Function4;
import scala.Function5;
import scala.MatchError;
import scala.Option;
import scala.PartialFunction;
import scala.Product;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.AbstractSeq;
import scala.collection.GenIterable;
import scala.collection.GenSeq;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.IterableLike;
import scala.collection.Iterator;
import scala.collection.LinearSeqLike;
import scala.collection.LinearSeqOptimized;
import scala.collection.Seq;
import scala.collection.SeqLike;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.Iterable;
import scala.collection.immutable.LinearSeq;
import scala.collection.immutable.LinearSeq$;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.ListSerializeEnd$;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Seq$;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Stream$Empty$;
import scala.collection.immutable.Traversable;
import scala.collection.mutable.Builder;
import scala.collection.mutable.ListBuffer;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.immutable.ParSeq;
import scala.math.Integral;
import scala.math.package$;
import scala.reflect.ScalaSignature;
import scala.runtime.AbstractFunction1;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\r\rd!B\u00193\u0003CI\u0004\"\u00021\u0001\t\u0003\t\u0007\"\u00022\u0001\t\u0003\u001a\u0007\"B4\u0001\r\u0003A\u0007\"\u00027\u0001\r\u0003i\u0007\"\u00028\u0001\r\u0003y\u0007\"\u00029\u0001\t\u0003\t\b\"\u0002>\u0001\t\u0003Y\bbBA\u0003\u0001\u0011\u0005\u0011q\u0001\u0005\b\u0003'\u0001AQAA\u000b\u0011\u001d\tI\u0004\u0001C\u0005\u0003wAq!a\u0017\u0001\t\u0003\ni\u0006C\u0004\u0002|\u0001!\t%! \t\r\u0005M\u0005\u0001\"\u0011p\u0011\u001d\t)\n\u0001C!\u0003/Cq!a)\u0001\t\u0003\n)\u000bC\u0004\u0002*\u0002!\t%a+\t\u000f\u0005U\u0006\u0001\"\u0011\u00028\"9\u00111\u0018\u0001\u0005B\u0005u\u0006bBAd\u0001\u0011\u0015\u0013\u0011\u001a\u0005\b\u0003?\u0004AQIAq\u0011\u001d\ti\u0010\u0001C#\u0003\u007fDqAa\u0006\u0001\t\u000b\u0012I\u0002C\u0004\u0003$\u0001!)E!\n\t\u000f\t-\u0002\u0001\"\u0012\u0003.!9!1\u0007\u0001\u0005F\tU\u0002B\u0002B&\u0001\u0011\u0005s\u000eC\u0004\u0003N\u0001!\tEa\u0014\t\u000f\t\u001d\u0004\u0001\"\u0011\u0003j!9!1\u0010\u0001\u0005B\tu\u0004b\u0002BC\u0001\u0011U!qQ\u0004\b\u0005?\u0013\u0004\u0012\u0001BQ\r\u0019\t$\u0007#\u0001\u0003$\"1\u0001\r\tC\u0001\u0005WCqA!,!\t\u0007\u0011y\u000bC\u0004\u0003D\u0002\"\tA!2\t\u000f\tm\u0007\u0005\"\u0011\u0003^\"9!q\u001d\u0011\u0005B\t%\bB\u0003B\u007fA\t\u0007I\u0011\u0001\u001b\u0003\u0000\"A1q\u0001\u0011!\u0002\u0013\u0019\tA\u0002\u0004\u0004\f\u0001\"1Q\u0002\u0005\u000b\u0007#A#\u00111A\u0005\n\rM\u0001BCB\u000eQ\t\u0005\r\u0011\"\u0003\u0004\u001e!Q11\u0005\u0015\u0003\u0002\u0003\u0006Ka!\u0006\t\r\u0001DC\u0011AB\u0017\u0011\u001d\u0019\u0019\u0004\u000bC\u0005\u0007kAqaa\u0012)\t\u0013\u0019I\u0005C\u0004\u0004V!\"IAa\"\t\u0013\rU\u0003%!A\u0005\n\rm#\u0001\u0002'jgRT!a\r\u001b\u0002\u0013%lW.\u001e;bE2,'BA\u001b7\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002o\u0005)1oY1mC\u000e\u0001QC\u0001\u001eB'\u001d\u00011hS(S3v\u00032\u0001P\u001f@\u001b\u0005!\u0014B\u0001 5\u0005-\t%m\u001d;sC\u000e$8+Z9\u0011\u0005\u0001\u000bE\u0002\u0001\u0003\u0007\u0005\u0002!)\u0019A\"\u0003\u0003\u0005\u000b\"\u0001\u0012%\u0011\u0005\u00153U\"\u0001\u001c\n\u0005\u001d3$a\u0002(pi\"Lgn\u001a\t\u0003\u000b&K!A\u0013\u001c\u0003\u0007\u0005s\u0017\u0010E\u0002M\u001b~j\u0011AM\u0005\u0003\u001dJ\u0012\u0011\u0002T5oK\u0006\u00148+Z9\u0011\u0005\u0015\u0003\u0016BA)7\u0005\u001d\u0001&o\u001c3vGR\u0004Ba\u0015,@16\tAK\u0003\u0002Vi\u00059q-\u001a8fe&\u001c\u0017BA,U\u0005i9UM\\3sS\u000e$&/\u0019<feN\f'\r\\3UK6\u0004H.\u0019;f!\ta\u0005\u0001\u0005\u0003=5~b\u0016BA.5\u0005Ia\u0015N\\3beN+\u0017o\u00149uS6L'0\u001a3\u0011\u00071\u0003q\b\u0005\u0002F=&\u0011qL\u000e\u0002\r'\u0016\u0014\u0018.\u00197ju\u0006\u0014G.Z\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003q\u000b\u0011bY8na\u0006t\u0017n\u001c8\u0016\u0003\u0011\u00042aU3Y\u0013\t1GK\u0001\tHK:,'/[2D_6\u0004\u0018M\\5p]\u00069\u0011n]#naRLX#A5\u0011\u0005\u0015S\u0017BA67\u0005\u001d\u0011un\u001c7fC:\fA\u0001[3bIV\tq(\u0001\u0003uC&dW#\u0001/\u0002\u0019\u0011\u001aw\u000e\\8oI\r|Gn\u001c8\u0016\u0005I,HCA:y!\ra\u0005\u0001\u001e\t\u0003\u0001V$QA\u001e\u0004C\u0002]\u0014\u0011AQ\t\u0003\u007f!CQ!\u001f\u0004A\u0002Q\f\u0011\u0001_\u0001\u0013I\r|Gn\u001c8%G>dwN\u001c\u0013d_2|g.\u0006\u0002}\u007fR\u0019Q0!\u0001\u0011\u00071\u0003a\u0010\u0005\u0002A\u007f\u0012)ao\u0002b\u0001o\"1\u00111A\u0004A\u0002u\fa\u0001\u001d:fM&D\u0018A\u0007:fm\u0016\u00148/Z0%G>dwN\u001c\u0013d_2|g\u000eJ2pY>tW\u0003BA\u0005\u0003\u001f!B!a\u0003\u0002\u0012A!A\nAA\u0007!\r\u0001\u0015q\u0002\u0003\u0006m\"\u0011\ra\u001e\u0005\b\u0003\u0007A\u0001\u0019AA\u0006\u0003-i\u0017\r]\"p]N,'O^3\u0016\t\u0005]\u0011Q\u0004\u000b\u0005\u00033\t9\u0003\u0005\u0003M\u0001\u0005m\u0001c\u0001!\u0002\u001e\u00111a/\u0003b\u0001\u0003?\t2aPA\u0011!\r)\u00151E\u0005\u0004\u0003K1$AB!osJ+g\rC\u0004\u0002*%\u0001\r!a\u000b\u0002\u0003\u0019\u0004b!RA\u0017\u007f\u0005m\u0011bAA\u0018m\tIa)\u001e8di&|g.\r\u0015\u0004\u0013\u0005M\u0002cA#\u00026%\u0019\u0011q\u0007\u001c\u0003\r%tG.\u001b8f\u0003UI7\u000fT5lK2K7\u000f\u001e*fkN\f'\r\\3D\u0005\u001a#2![A\u001f\u0011\u001d\tyD\u0003a\u0001\u0003\u0003\n!A\u001941\u0011\u0005\r\u00131JA)\u0003/\u0002\u0012bUA#\u0003\u0013\ny%!\u0016\n\u0007\u0005\u001dCK\u0001\u0007DC:\u0014U/\u001b7e\rJ|W\u000eE\u0002A\u0003\u0017\"1\"!\u0014\u0002>\u0005\u0005\t\u0011!B\u0001\u0007\n\u0019q\fJ\u0019\u0011\u0007\u0001\u000b\t\u0006B\u0006\u0002T\u0005u\u0012\u0011!A\u0001\u0006\u0003\u0019%aA0%eA\u0019\u0001)a\u0016\u0005\u0017\u0005e\u0013QHA\u0001\u0002\u0003\u0015\ta\u0011\u0002\u0004?\u0012\u001a\u0014A\u0003\u0013qYV\u001cH\u0005\u001d7vgV1\u0011qLA8\u0003K\"B!!\u0019\u0002rQ!\u00111MA5!\r\u0001\u0015Q\r\u0003\u0007\u0003OZ!\u0019A\"\u0003\tQC\u0017\r\u001e\u0005\b\u0003\u007fY\u00019AA6!!\u0019\u0016Q\t/\u0002n\u0005\r\u0004c\u0001!\u0002p\u0011)ao\u0003b\u0001o\"9\u00111O\u0006A\u0002\u0005U\u0014\u0001\u0002;iCR\u0004R\u0001PA<\u0003[J1!!\u001f5\u0005I9UM\u001c+sCZ,'o]1cY\u0016|enY3\u0002\u0017\u0011\u0002H.^:%G>dwN\\\u000b\u0007\u0003\u007f\ni)!\"\u0015\t\u0005\u0005\u0015q\u0012\u000b\u0005\u0003\u0007\u000b9\tE\u0002A\u0003\u000b#a!a\u001a\r\u0005\u0004\u0019\u0005bBA \u0019\u0001\u000f\u0011\u0011\u0012\t\t'\u0006\u0015C,a#\u0002\u0004B\u0019\u0001)!$\u0005\u000bYd!\u0019A<\t\u000f\u0005EE\u00021\u0001\u0002\f\u0006!Q\r\\3n\u0003\u0019!x\u000eT5ti\u0006!A/Y6f)\ra\u0016\u0011\u0014\u0005\b\u00037s\u0001\u0019AAO\u0003\u0005q\u0007cA#\u0002 &\u0019\u0011\u0011\u0015\u001c\u0003\u0007%sG/\u0001\u0003ee>\u0004Hc\u0001/\u0002(\"9\u00111T\bA\u0002\u0005u\u0015!B:mS\u000e,G#\u0002/\u0002.\u0006E\u0006bBAX!\u0001\u0007\u0011QT\u0001\u0005MJ|W\u000eC\u0004\u00024B\u0001\r!!(\u0002\u000bUtG/\u001b7\u0002\u0013Q\f7.\u001a*jO\"$Hc\u0001/\u0002:\"9\u00111T\tA\u0002\u0005u\u0015aB:qY&$\u0018\t\u001e\u000b\u0005\u0003\u007f\u000b)\rE\u0003F\u0003\u0003dF,C\u0002\u0002DZ\u0012a\u0001V;qY\u0016\u0014\u0004bBAN%\u0001\u0007\u0011QT\u0001\u0004[\u0006\u0004XCBAf\u00033\f\t\u000e\u0006\u0003\u0002N\u0006mG\u0003BAh\u0003'\u00042\u0001QAi\t\u0019\t9g\u0005b\u0001\u0007\"9\u0011qH\nA\u0004\u0005U\u0007\u0003C*\u0002Fq\u000b9.a4\u0011\u0007\u0001\u000bI\u000eB\u0003w'\t\u00071\tC\u0004\u0002*M\u0001\r!!8\u0011\r\u0015\u000bicPAl\u0003\u001d\u0019w\u000e\u001c7fGR,b!a9\u0002r\u0006%H\u0003BAs\u0003g$B!a:\u0002lB\u0019\u0001)!;\u0005\r\u0005\u001dDC1\u0001D\u0011\u001d\ty\u0004\u0006a\u0002\u0003[\u0004\u0002bUA#9\u0006=\u0018q\u001d\t\u0004\u0001\u0006EH!\u0002<\u0015\u0005\u0004\u0019\u0005bBA{)\u0001\u0007\u0011q_\u0001\u0003a\u001a\u0004b!RA}\u007f\u0005=\u0018bAA~m\ty\u0001+\u0019:uS\u0006dg)\u001e8di&|g.A\u0004gY\u0006$X*\u00199\u0016\r\t\u0005!q\u0002B\u0004)\u0011\u0011\u0019A!\u0005\u0015\t\t\u0015!\u0011\u0002\t\u0004\u0001\n\u001dAABA4+\t\u00071\tC\u0004\u0002@U\u0001\u001dAa\u0003\u0011\u0011M\u000b)\u0005\u0018B\u0007\u0005\u000b\u00012\u0001\u0011B\b\t\u00151XC1\u0001D\u0011\u001d\tI#\u0006a\u0001\u0005'\u0001b!RA\u0017\u007f\tU\u0001#\u0002\u001f\u0002x\t5\u0011!\u0003;bW\u0016<\u0006.\u001b7f)\ra&1\u0004\u0005\b\u0005;1\u0002\u0019\u0001B\u0010\u0003\u0005\u0001\b#B#\u0002.}J\u0007f\u0001\f\u00024\u0005IAM]8q/\"LG.\u001a\u000b\u00049\n\u001d\u0002b\u0002B\u000f/\u0001\u0007!q\u0004\u0015\u0004/\u0005M\u0012\u0001B:qC:$B!a0\u00030!9!Q\u0004\rA\u0002\t}\u0001f\u0001\r\u00024\u00059am\u001c:fC\u000eDW\u0003\u0002B\u001c\u0005\u000b\"BA!\u000f\u0003@A\u0019QIa\u000f\n\u0007\tubG\u0001\u0003V]&$\bbBA\u00153\u0001\u0007!\u0011\t\t\u0007\u000b\u00065rHa\u0011\u0011\u0007\u0001\u0013)\u0005\u0002\u0004\u0003He\u0011\ra\u0011\u0002\u0002+\"\u001a\u0011$a\r\u0002\u000fI,g/\u001a:tK\u0006Iam\u001c7e%&<\u0007\u000e^\u000b\u0005\u0005#\u00129\u0006\u0006\u0003\u0003T\t\rD\u0003\u0002B+\u00053\u00022\u0001\u0011B,\t\u001518D1\u0001D\u0011\u001d\u0011Yf\u0007a\u0001\u0005;\n!a\u001c9\u0011\u0011\u0015\u0013yf\u0010B+\u0005+J1A!\u00197\u0005%1UO\\2uS>t'\u0007C\u0004\u0003fm\u0001\rA!\u0016\u0002\u0003i\fAb\u001d;sS:<\u0007K]3gSb,\"Aa\u001b\u0011\t\t5$qO\u0007\u0003\u0005_RAA!\u001d\u0003t\u0005!A.\u00198h\u0015\t\u0011)(\u0001\u0003kCZ\f\u0017\u0002\u0002B=\u0005_\u0012aa\u0015;sS:<\u0017\u0001\u0003;p'R\u0014X-Y7\u0016\u0005\t}\u0004\u0003\u0002'\u0003\u0002~J1Aa!3\u0005\u0019\u0019FO]3b[\u0006aqO]5uKJ+\u0007\u000f\\1dKR\u0011\u0011\u0011E\u0015\u0006\u0001\t-%qR\u0005\u0004\u0005\u001b\u0013$\u0001\u0004\u0013d_2|g\u000eJ2pY>t'b\u0001BIe\u0005\u0019a*\u001b7)\u000f\u0001\u0011)Ja'\u0003\u001eB\u0019QIa&\n\u0007\teeG\u0001\tTKJL\u0017\r\u001c,feNLwN\\+J\t\u0006)a/\u00197vKzA1\u0016ev5SL\u001f!,\u0001\u0003MSN$\bC\u0001'!'\u0011\u0001#QU/\u0011\tM\u00139\u000bW\u0005\u0004\u0005S#&AC*fc\u001a\u000b7\r^8ssR\u0011!\u0011U\u0001\rG\u0006t')^5mI\u001a\u0013x.\\\u000b\u0005\u0005c\u0013y,\u0006\u0002\u00034BI1+!\u0012\u00036\nu&\u0011\u0019\t\u0005\u0005o\u0013I,D\u0001!\u0013\r\u0011Y,\u001a\u0002\u0005\u0007>dG\u000eE\u0002A\u0005\u007f#QA\u0011\u0012C\u0002\r\u0003B\u0001\u0014\u0001\u0003>\u0006Qa.Z<Ck&dG-\u001a:\u0016\t\t\u001d'q[\u000b\u0003\u0005\u0013\u0004\u0002Ba3\u0003R\nU'\u0011\\\u0007\u0003\u0005\u001bT1Aa45\u0003\u001diW\u000f^1cY\u0016LAAa5\u0003N\n9!)^5mI\u0016\u0014\bc\u0001!\u0003X\u0012)!i\tb\u0001\u0007B!A\n\u0001Bk\u0003\u0015)W\u000e\u001d;z+\u0011\u0011yN!:\u0016\u0005\t\u0005\b\u0003\u0002'\u0001\u0005G\u00042\u0001\u0011Bs\t\u0015\u0011EE1\u0001D\u0003\u0015\t\u0007\u000f\u001d7z+\u0011\u0011YO!=\u0015\t\t5(1\u001f\t\u0005\u0019\u0002\u0011y\u000fE\u0002A\u0005c$QAQ\u0013C\u0002\rCqA!>&\u0001\u0004\u001190\u0001\u0002ygB)QI!?\u0003p&\u0019!1 \u001c\u0003\u0015q\u0012X\r]3bi\u0016$g(A\tqCJ$\u0018.\u00197O_R\f\u0005\u000f\u001d7jK\u0012,\"a!\u0001\u0013\r\r\r\u0011\u0011EB\u0005\r\u0019\u0019)a\n\u0001\u0004\u0002\taAH]3gS:,W.\u001a8u}\u0005\u0011\u0002/\u0019:uS\u0006dgj\u001c;BaBd\u0017.\u001a3!!\u0015)\u0015Q\u0006%I\u0005I\u0019VM]5bY&T\u0018\r^5p]B\u0013x\u000e_=\u0016\t\r=1\u0011D\n\u0005Q\u0005\u0005R,\u0001\u0003pe&<WCAB\u000b!\u0011a\u0005aa\u0006\u0011\u0007\u0001\u001bI\u0002B\u0003CQ\t\u00071)\u0001\u0005pe&<w\fJ3r)\u0011\u0011Ida\b\t\u0013\r\u0005\"&!AA\u0002\rU\u0011a\u0001=%c\u0005)qN]5hA!\u001a1fa\n\u0011\u0007\u0015\u001bI#C\u0002\u0004,Y\u0012\u0011\u0002\u001e:b]NLWM\u001c;\u0015\t\r=2\u0011\u0007\t\u0006\u0005oC3q\u0003\u0005\b\u0007#a\u0003\u0019AB\u000b\u0003-9(/\u001b;f\u001f\nTWm\u0019;\u0015\t\te2q\u0007\u0005\b\u0007si\u0003\u0019AB\u001e\u0003\ryW\u000f\u001e\t\u0005\u0007{\u0019\u0019%\u0004\u0002\u0004@)!1\u0011\tB:\u0003\tIw.\u0003\u0003\u0004F\r}\"AE(cU\u0016\u001cGoT;uaV$8\u000b\u001e:fC6\f!B]3bI>\u0013'.Z2u)\u0011\u0011Ida\u0013\t\u000f\r5c\u00061\u0001\u0004P\u0005\u0011\u0011N\u001c\t\u0005\u0007{\u0019\t&\u0003\u0003\u0004T\r}\"!E(cU\u0016\u001cG/\u00138qkR\u001cFO]3b[\u0006Y!/Z1e%\u0016\u001cx\u000e\u001c<fQ\u001dA#Q\u0013BN\u00073r\u0012!\u0001\u000b\u0003\u0007;\u0002BA!\u001c\u0004`%!1\u0011\rB8\u0005\u0019y%M[3di\u0002")
public abstract class List<A>
extends AbstractSeq<A>
implements LinearSeq<A>,
Product,
LinearSeqOptimized<A, List<A>>,
Serializable {
    public static final long serialVersionUID = -6084104484083858598L;

    public static <A> List<A> empty() {
        return List$.MODULE$.empty();
    }

    public static <A> CanBuildFrom<List<?>, A, List<A>> canBuildFrom() {
        return List$.MODULE$.canBuildFrom();
    }

    public static Some unapplySeq(Seq seq) {
        return List$.MODULE$.unapplySeq(seq);
    }

    public static GenTraversable iterate(Object object, int n, Function1 function1) {
        List$ list$ = List$.MODULE$;
        if (list$ == null) {
            throw null;
        }
        Builder iterate_b = ((GenericCompanion)list$).newBuilder();
        if (n > 0) {
            iterate_b.sizeHint(n);
            Object iterate_acc = object;
            iterate_b.$plus$eq(object);
            for (int iterate_i = 1; iterate_i < n; ++iterate_i) {
                iterate_acc = function1.apply(iterate_acc);
                iterate_b.$plus$eq(iterate_acc);
            }
        }
        return (GenTraversable)iterate_b.result();
    }

    public static GenTraversable range(Object object, Object object2, Object object3, Integral integral) {
        return List$.MODULE$.range(object, object2, object3, integral);
    }

    public static GenTraversable range(Object object, Object object2, Integral integral) {
        return List$.MODULE$.range(object, object2, integral);
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, int n5, Function5 function5) {
        List$ list$ = List$.MODULE$;
        if (list$ == null) {
            throw null;
        }
        List$ tabulate_this = list$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$7$adapted(tabulate_this, n2, n3, n4, n5, function5, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, Function4 function4) {
        List$ list$ = List$.MODULE$;
        if (list$ == null) {
            throw null;
        }
        List$ tabulate_this = list$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$5$adapted(tabulate_this, n2, n3, n4, function4, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, Function3 function3) {
        List$ list$ = List$.MODULE$;
        if (list$ == null) {
            throw null;
        }
        List$ tabulate_this = list$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$3$adapted(tabulate_this, n2, n3, function3, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, Function2 function2) {
        List$ list$ = List$.MODULE$;
        if (list$ == null) {
            throw null;
        }
        List$ tabulate_this = list$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$1$adapted(tabulate_this, n2, function2, arg_0));
    }

    public static GenTraversable tabulate(int n, Function1 function1) {
        return List$.MODULE$.tabulate(n, function1);
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, int n5, Function0 function0) {
        List$ list$ = List$.MODULE$;
        if (list$ == null) {
            throw null;
        }
        List$ fill_this = list$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$4$adapted(fill_this, n2, n3, n4, n5, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, Function0 function0) {
        List$ list$ = List$.MODULE$;
        if (list$ == null) {
            throw null;
        }
        List$ fill_this = list$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$3$adapted(fill_this, n2, n3, n4, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, Function0 function0) {
        List$ list$ = List$.MODULE$;
        if (list$ == null) {
            throw null;
        }
        List$ fill_this = list$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$2$adapted(fill_this, n2, n3, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, Function0 function0) {
        List$ list$ = List$.MODULE$;
        if (list$ == null) {
            throw null;
        }
        List$ fill_this = list$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$1$adapted(fill_this, n2, function0, arg_0));
    }

    public static GenTraversable fill(int n, Function0 function0) {
        List$ list$ = List$.MODULE$;
        if (list$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)list$).newBuilder();
        fill_b.sizeHint(n);
        for (int fill_i = 0; fill_i < n; ++fill_i) {
            fill_b.$plus$eq(function0.apply());
        }
        return (GenTraversable)fill_b.result();
    }

    public static GenTraversable concat(Seq seq) {
        return List$.MODULE$.concat(seq);
    }

    public static GenTraversableFactory.GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return List$.MODULE$.ReusableCBF();
    }

    @Override
    public /* synthetic */ boolean scala$collection$LinearSeqOptimized$$super$sameElements(GenIterable that) {
        return IterableLike.sameElements$(this, that);
    }

    @Override
    public int length() {
        return LinearSeqOptimized.length$(this);
    }

    @Override
    public A apply(int n) {
        return (A)LinearSeqOptimized.apply$(this, n);
    }

    @Override
    public boolean forall(Function1<A, Object> p) {
        return LinearSeqOptimized.forall$(this, p);
    }

    @Override
    public boolean exists(Function1<A, Object> p) {
        return LinearSeqOptimized.exists$(this, p);
    }

    @Override
    public <A1> boolean contains(A1 elem) {
        return LinearSeqOptimized.contains$(this, elem);
    }

    @Override
    public Option<A> find(Function1<A, Object> p) {
        return LinearSeqOptimized.find$(this, p);
    }

    @Override
    public <B> B foldLeft(B z, Function2<B, A, B> op) {
        return (B)LinearSeqOptimized.foldLeft$(this, z, op);
    }

    @Override
    public <B> B reduceLeft(Function2<B, A, B> op) {
        return (B)LinearSeqOptimized.reduceLeft$(this, op);
    }

    @Override
    public <B> B reduceRight(Function2<A, B, B> op) {
        return (B)LinearSeqOptimized.reduceRight$(this, op);
    }

    @Override
    public A last() {
        return (A)LinearSeqOptimized.last$(this);
    }

    @Override
    public LinearSeqOptimized dropRight(int n) {
        return LinearSeqOptimized.dropRight$(this, n);
    }

    @Override
    public <B> boolean sameElements(GenIterable<B> that) {
        return LinearSeqOptimized.sameElements$(this, that);
    }

    @Override
    public int lengthCompare(int len) {
        return LinearSeqOptimized.lengthCompare$(this, len);
    }

    @Override
    public boolean isDefinedAt(int x) {
        return LinearSeqOptimized.isDefinedAt$(this, x);
    }

    @Override
    public int segmentLength(Function1<A, Object> p, int from) {
        return LinearSeqOptimized.segmentLength$(this, p, from);
    }

    @Override
    public int indexWhere(Function1<A, Object> p, int from) {
        return LinearSeqOptimized.indexWhere$(this, p, from);
    }

    @Override
    public int lastIndexWhere(Function1<A, Object> p, int end) {
        return LinearSeqOptimized.lastIndexWhere$(this, p, end);
    }

    @Override
    public Iterator<List<A>> tails() {
        return LinearSeqOptimized.tails$(this);
    }

    @Override
    public Iterator<Object> productIterator() {
        return Product.productIterator$(this);
    }

    @Override
    public String productPrefix() {
        return Product.productPrefix$(this);
    }

    @Override
    public LinearSeq<A> seq() {
        return LinearSeq.seq$(this);
    }

    @Override
    public scala.collection.LinearSeq<A> thisCollection() {
        return LinearSeqLike.thisCollection$(this);
    }

    @Override
    public scala.collection.LinearSeq toCollection(LinearSeqLike repr) {
        return LinearSeqLike.toCollection$(this, repr);
    }

    @Override
    public int hashCode() {
        return LinearSeqLike.hashCode$(this);
    }

    @Override
    public Iterator<A> iterator() {
        return LinearSeqLike.iterator$(this);
    }

    @Override
    public final <B> boolean corresponds(GenSeq<B> that, Function2<A, B, Object> p) {
        return LinearSeqLike.corresponds$(this, that, p);
    }

    @Override
    public scala.collection.immutable.Seq<A> toSeq() {
        return scala.collection.immutable.Seq.toSeq$(this);
    }

    @Override
    public Combiner<A, ParSeq<A>> parCombiner() {
        return scala.collection.immutable.Seq.parCombiner$(this);
    }

    @Override
    public GenericCompanion<List> companion() {
        return List$.MODULE$;
    }

    @Override
    public abstract boolean isEmpty();

    @Override
    public abstract A head();

    public <B> List<B> $colon$colon(B x) {
        return new $colon$colon<B>(x, this);
    }

    public <B> List<B> $colon$colon$colon(List<B> prefix) {
        if (this.isEmpty()) {
            return prefix;
        }
        if (prefix.isEmpty()) {
            return this;
        }
        return ((ListBuffer)new ListBuffer().$plus$plus$eq((TraversableOnce)prefix)).prependToList(this);
    }

    /*
     * WARNING - void declaration
     */
    public <B> List<B> reverse_$colon$colon$colon(List<B> prefix) {
        void var2_2;
        List<B> these = this;
        List pres = prefix;
        while (!pres.isEmpty()) {
            B b = pres.head();
            these = these.$colon$colon(b);
            pres = (List)pres.tail();
        }
        return var2_2;
    }

    public final <B> List<B> mapConserve(Function1<A, B> f) {
        List list = this;
        List list2 = this;
        $colon$colon<Nothing$> loop$1_mappedLast = null;
        $colon$colon<Nothing$> loop$1_mappedHead = null;
        while (true) {
            List loop$1_tail0;
            List loop$1_unchanged;
            List loop$1_pending;
            if (loop$1_pending.isEmpty()) {
                if (loop$1_mappedHead == null) {
                    return loop$1_unchanged;
                }
                loop$1_mappedLast.tl_$eq(loop$1_unchanged);
                return loop$1_mappedHead;
            }
            A loop$1_head0 = loop$1_pending.head();
            B loop$1_head1 = f.apply(loop$1_head0);
            if (loop$1_head1 == loop$1_head0) {
                loop$1_pending = (List)loop$1_pending.tail();
                continue;
            }
            $colon$colon<Nothing$> loop$1_mappedHead1 = loop$1_mappedHead;
            $colon$colon<Nothing$> loop$1_mappedLast1 = loop$1_mappedLast;
            for (List loop$1_xc = loop$1_unchanged; loop$1_xc != loop$1_pending; loop$1_xc = (List)loop$1_xc.tail()) {
                $colon$colon<Nothing$> loop$1_next = new $colon$colon<Nothing$>((Nothing$)loop$1_xc.head(), Nil$.MODULE$);
                if (loop$1_mappedHead1 == null) {
                    loop$1_mappedHead1 = loop$1_next;
                }
                if (loop$1_mappedLast1 != null) {
                    loop$1_mappedLast1.tl_$eq(loop$1_next);
                }
                loop$1_mappedLast1 = loop$1_next;
            }
            $colon$colon<Nothing$> loop$1_next = new $colon$colon<Nothing$>((Nothing$)loop$1_head1, Nil$.MODULE$);
            if (loop$1_mappedHead1 == null) {
                loop$1_mappedHead1 = loop$1_next;
            }
            if (loop$1_mappedLast1 != null) {
                loop$1_mappedLast1.tl_$eq(loop$1_next);
            }
            loop$1_mappedLast1 = loop$1_next;
            loop$1_pending = loop$1_tail0 = (List)loop$1_pending.tail();
            loop$1_unchanged = loop$1_tail0;
            loop$1_mappedLast = loop$1_mappedLast1;
            loop$1_mappedHead = loop$1_mappedHead1;
        }
    }

    private boolean isLikeListReusableCBF(CanBuildFrom<?, ?, ?> bf) {
        return bf == List$.MODULE$.ReusableCBF() || bf == LinearSeq$.MODULE$.ReusableCBF() || bf == scala.collection.LinearSeq$.MODULE$.ReusableCBF() || bf == Seq$.MODULE$.ReusableCBF() || bf == scala.collection.Seq$.MODULE$.ReusableCBF();
    }

    @Override
    public <B, That> That $plus$plus(GenTraversableOnce<B> that, CanBuildFrom<List<A>, B, That> bf) {
        if (this.isLikeListReusableCBF(bf)) {
            return (That)that.seq().toList().$colon$colon$colon(this);
        }
        return (That)TraversableLike.$plus$plus$(this, that, bf);
    }

    @Override
    public <B, That> That $plus$colon(B elem, CanBuildFrom<List<A>, B, That> bf) {
        Object object = bf instanceof GenTraversableFactory.GenericCanBuildFrom ? this.$colon$colon(elem) : SeqLike.$plus$colon$(this, elem, bf);
        return (That)object;
    }

    @Override
    public List<A> toList() {
        return this;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public List<A> take(int n) {
        void var2_2;
        $colon$colon<Nothing$> h;
        if (this.isEmpty() || n <= 0) {
            return Nil$.MODULE$;
        }
        $colon$colon<Nothing$> t = h = new $colon$colon<Nothing$>((Nothing$)this.head(), Nil$.MODULE$);
        List rest = (List)this.tail();
        int i = 1;
        while (true) {
            if (rest.isEmpty()) {
                return this;
            }
            if (!(i < n)) break;
            ++i;
            $colon$colon<Nothing$> nx = new $colon$colon<Nothing$>((Nothing$)rest.head(), Nil$.MODULE$);
            t.tl_$eq(nx);
            t = nx;
            rest = (List)rest.tail();
        }
        return var2_2;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public List<A> drop(int n) {
        void var2_2;
        List these = this;
        for (int count = n; !these.isEmpty() && count > 0; --count) {
            these = (List)these.tail();
        }
        return var2_2;
    }

    @Override
    public List<A> slice(int from, int until) {
        int lo = package$.MODULE$.max(from, 0);
        if (until <= lo || this.isEmpty()) {
            return Nil$.MODULE$;
        }
        return ((List)this.drop(lo)).take(until - lo);
    }

    @Override
    public List<A> takeRight(int n) {
        return this.loop$2((List)this.drop(n), this);
    }

    @Override
    public Tuple2<List<A>, List<A>> splitAt(int n) {
        ListBuffer b = new ListBuffer();
        int i = 0;
        List these = this;
        while (!these.isEmpty() && i < n) {
            ++i;
            b.$plus$eq((Object)these.head());
            these = (List)these.tail();
        }
        return new Tuple2<List<A>, List<A>>(b.toList(), these);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final <B, That> That map(Function1<A, B> f, CanBuildFrom<List<A>, B, That> bf) {
        if (this.isLikeListReusableCBF(bf)) {
            void var3_3;
            $colon$colon<Nothing$> h;
            if (this == Nil$.MODULE$) {
                return (That)Nil$.MODULE$;
            }
            $colon$colon<Nothing$> t = h = new $colon$colon<Nothing$>((Nothing$)f.apply(this.head()), Nil$.MODULE$);
            for (List rest = (List)this.tail(); rest != Nil$.MODULE$; rest = (List)rest.tail()) {
                $colon$colon<Nothing$> nx = new $colon$colon<Nothing$>((Nothing$)f.apply(rest.head()), Nil$.MODULE$);
                t.tl_$eq(nx);
                t = nx;
            }
            return var3_3;
        }
        return (That)TraversableLike.map$(this, f, bf);
    }

    @Override
    public final <B, That> That collect(PartialFunction<A, B> pf, CanBuildFrom<List<A>, B, That> bf) {
        if (this.isLikeListReusableCBF(bf)) {
            if (this == Nil$.MODULE$) {
                return (That)Nil$.MODULE$;
            }
            List rest = this;
            $colon$colon<Nothing$> h = null;
            do {
                Object x;
                if ((x = pf.applyOrElse(rest.head(), List$.MODULE$.partialNotApplied())) != List$.MODULE$.partialNotApplied()) {
                    h = new $colon$colon<Nothing$>((Nothing$)x, Nil$.MODULE$);
                }
                if ((rest = (List)rest.tail()) != Nil$.MODULE$) continue;
                if (h == null) {
                    return (That)Nil$.MODULE$;
                }
                return (That)h;
            } while (h == null);
            $colon$colon<Nothing$> t = h;
            do {
                Object x;
                if ((x = pf.applyOrElse(rest.head(), List$.MODULE$.partialNotApplied())) == List$.MODULE$.partialNotApplied()) continue;
                $colon$colon<Nothing$> nx = new $colon$colon<Nothing$>((Nothing$)x, Nil$.MODULE$);
                t.tl_$eq(nx);
                t = nx;
            } while ((rest = (List)rest.tail()) != Nil$.MODULE$);
            return (That)h;
        }
        return (That)TraversableLike.collect$(this, pf, bf);
    }

    @Override
    public final <B, That> That flatMap(Function1<A, GenTraversableOnce<B>> f, CanBuildFrom<List<A>, B, That> bf) {
        if (this.isLikeListReusableCBF(bf)) {
            if (this == Nil$.MODULE$) {
                return (That)Nil$.MODULE$;
            }
            List rest = this;
            public class Scala_collection_immutable_List$Appender$1
            extends AbstractFunction1<B, BoxedUnit> {
                private $colon$colon<B> h;
                private $colon$colon<B> t;

                public $colon$colon<B> h() {
                    return this.h;
                }

                public void h_$eq($colon$colon<B> x$1) {
                    this.h = x$1;
                }

                public $colon$colon<B> t() {
                    return this.t;
                }

                public void t_$eq($colon$colon<B> x$1) {
                    this.t = x$1;
                }

                public void apply(B b) {
                    if (this.h() == null) {
                        this.h_$eq(new $colon$colon<Nothing$>((Nothing$)b, Nil$.MODULE$));
                        this.t_$eq(this.h());
                        return;
                    }
                    $colon$colon<Nothing$> nx = new $colon$colon<Nothing$>((Nothing$)b, Nil$.MODULE$);
                    this.t().tl_$eq(nx);
                    this.t_$eq(nx);
                }

                public void appendLast($colon$colon<B> last) {
                    if (this.h() == null) {
                        this.h_$eq(last);
                        return;
                    }
                    this.t().tl_$eq(last);
                }

                public Scala_collection_immutable_List$Appender$1(List $outer) {
                    this.h = null;
                    this.t = null;
                }
            }
            Scala_collection_immutable_List$Appender$1 appender = null;
            List lastList = null;
            while (rest != Nil$.MODULE$) {
                TraversableOnce<B> c = f.apply(rest.head()).seq();
                rest = (List)rest.tail();
                if (c == Nil$.MODULE$) continue;
                if (lastList != null) {
                    if (appender == null) {
                        appender = new Scala_collection_immutable_List$Appender$1(null);
                    }
                    List foreach_these = lastList;
                    while (!foreach_these.isEmpty()) {
                        appender.apply(foreach_these.head());
                        foreach_these = (List)foreach_these.tail();
                    }
                    lastList = null;
                }
                if (c instanceof $colon$colon) {
                    lastList = ($colon$colon)c;
                    continue;
                }
                if (appender == null) {
                    appender = new Scala_collection_immutable_List$Appender$1(null);
                }
                c.foreach(appender);
            }
            if (appender == null || appender.h() == null) {
                if (lastList == null) {
                    return (That)Nil$.MODULE$;
                }
                return (That)lastList;
            }
            if (lastList != null) {
                appender.appendLast(lastList);
            }
            return (That)appender.h();
        }
        return (That)TraversableLike.flatMap$(this, f, bf);
    }

    @Override
    public final List<A> takeWhile(Function1<A, Object> p) {
        ListBuffer b = new ListBuffer();
        List these = this;
        while (!these.isEmpty() && BoxesRunTime.unboxToBoolean(p.apply(these.head()))) {
            b.$plus$eq((Object)these.head());
            these = (List)these.tail();
        }
        return b.toList();
    }

    @Override
    public final List<A> dropWhile(Function1<A, Object> p) {
        return this.loop$3(this, p);
    }

    @Override
    public final Tuple2<List<A>, List<A>> span(Function1<A, Object> p) {
        ListBuffer b = new ListBuffer();
        List these = this;
        while (!these.isEmpty() && BoxesRunTime.unboxToBoolean(p.apply(these.head()))) {
            b.$plus$eq((Object)these.head());
            these = (List)these.tail();
        }
        return new Tuple2<List<A>, List<A>>(b.toList(), these);
    }

    @Override
    public final <U> void foreach(Function1<A, U> f) {
        List these = this;
        while (!these.isEmpty()) {
            f.apply(these.head());
            these = (List)these.tail();
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public List<A> reverse() {
        void var1_1;
        List result2 = Nil$.MODULE$;
        List these = this;
        while (!these.isEmpty()) {
            A a = these.head();
            result2 = result2.$colon$colon(a);
            these = (List)these.tail();
        }
        return var1_1;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public <B> B foldRight(B z, Function2<A, B, B> op) {
        void var4_4;
        Object object = this.reverse();
        if (object == null) {
            throw null;
        }
        Object foldLeft_this = object;
        Object foldLeft_acc = z;
        Object foldLeft_these = foldLeft_this;
        while (!foldLeft_these.isEmpty()) {
            Object a = foldLeft_these.head();
            foldLeft_acc = op.apply(a, foldLeft_acc);
            foldLeft_these = (LinearSeqOptimized)foldLeft_these.tail();
        }
        return var4_4;
    }

    @Override
    public String stringPrefix() {
        return "List";
    }

    @Override
    public Stream<A> toStream() {
        if (this.isEmpty()) {
            return Stream$Empty$.MODULE$;
        }
        return new Stream.Cons<A>(this.head(), (Function0<Stream> & java.io.Serializable & Serializable)() -> ((List)this.tail()).toStream());
    }

    public final Object writeReplace() {
        return new SerializationProxy(this);
    }

    private final List loop$1(List mappedHead, $colon$colon mappedLast, List unchanged, List pending, Function1 f$1) {
        while (true) {
            List tail0;
            if (pending.isEmpty()) {
                if (mappedHead == null) {
                    return unchanged;
                }
                mappedLast.tl_$eq(unchanged);
                return mappedHead;
            }
            A head0 = pending.head();
            Object head1 = f$1.apply(head0);
            if (head1 == head0) {
                pending = (List)pending.tail();
                continue;
            }
            $colon$colon<Nothing$> mappedHead1 = mappedHead;
            $colon$colon<Nothing$> mappedLast1 = mappedLast;
            for (List xc = unchanged; xc != pending; xc = (List)xc.tail()) {
                $colon$colon<Nothing$> next = new $colon$colon<Nothing$>((Nothing$)xc.head(), Nil$.MODULE$);
                if (mappedHead1 == null) {
                    mappedHead1 = next;
                }
                if (mappedLast1 != null) {
                    mappedLast1.tl_$eq(next);
                }
                mappedLast1 = next;
            }
            $colon$colon<Nothing$> next = new $colon$colon<Nothing$>((Nothing$)head1, Nil$.MODULE$);
            if (mappedHead1 == null) {
                mappedHead1 = next;
            }
            if (mappedLast1 != null) {
                mappedLast1.tl_$eq(next);
            }
            mappedLast1 = next;
            pending = tail0 = (List)pending.tail();
            unchanged = tail0;
            mappedLast = mappedLast1;
            mappedHead = mappedHead1;
        }
    }

    private static final List loop$default$1$1() {
        return Nil$.MODULE$;
    }

    private final List loop$2(List lead, List lag) {
        while (!((Object)Nil$.MODULE$).equals(lead)) {
            if (lead instanceof $colon$colon) {
                lag = (List)lag.tail();
                lead = (($colon$colon)lead).tl$access$1();
                continue;
            }
            throw new MatchError(lead);
        }
        return lag;
    }

    private final List loop$3(List xs, Function1 p$1) {
        while (!xs.isEmpty() && BoxesRunTime.unboxToBoolean(p$1.apply(xs.head()))) {
            xs = (List)xs.tail();
        }
        return xs;
    }

    public List() {
        Traversable.$init$(this);
        Iterable.$init$(this);
        scala.collection.immutable.Seq.$init$(this);
        LinearSeqLike.$init$(this);
        scala.collection.LinearSeq.$init$(this);
        LinearSeq.$init$(this);
        Product.$init$(this);
        LinearSeqOptimized.$init$(this);
    }

    public static class SerializationProxy<A>
    implements Serializable {
        public static final long serialVersionUID = 1L;
        private transient List<A> orig;

        private List<A> orig() {
            return this.orig;
        }

        private void orig_$eq(List<A> x$1) {
            this.orig = x$1;
        }

        private void writeObject(ObjectOutputStream out) {
            out.defaultWriteObject();
            List xs = this.orig();
            while (!xs.isEmpty()) {
                out.writeObject(xs.head());
                xs = (List)xs.tail();
            }
            out.writeObject(ListSerializeEnd$.MODULE$);
        }

        private void readObject(ObjectInputStream in) {
            in.defaultReadObject();
            Builder builder = List$.MODULE$.newBuilder();
            while (true) {
                Object object;
                if (ListSerializeEnd$.MODULE$.equals(object = in.readObject())) {
                    this.orig_$eq(builder.result());
                    return;
                }
                builder.$plus$eq(object);
            }
        }

        private Object readResolve() {
            return this.orig();
        }

        public SerializationProxy(List<A> orig) {
            this.orig = orig;
        }
    }
}

