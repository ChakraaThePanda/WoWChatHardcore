/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import java.util.NoSuchElementException;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.None$;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Predef$any2stringadd$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.GenSeq;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.Parallel;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.TraversableView;
import scala.collection.ViewMkString;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.generic.SliceInterval;
import scala.collection.generic.SliceInterval$;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.ParIterable;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BooleanRef;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.IntRef;
import scala.runtime.NonLocalReturnControl;
import scala.runtime.NonLocalReturnControl$mcV$sp;
import scala.runtime.Nothing$;
import scala.runtime.ObjectRef;

@ScalaSignature(bytes="\u0006\u0001\u0015=daB9s!\u0003\r\ta\u001e\u0005\b\u0003\u0003\u0002A\u0011AA\"\u0011\u001d\tY\u0005\u0001D\t\u0003\u001bB\u0001\"a\u0014\u0001A\u0013E\u0011\u0011\u000b\u0005\t\u0003S\u0002\u0001\u0015\"\u0005\u0002R!9\u00111\u000e\u0001\u0005\u0002\u00055\u0004bBA?\u0001\u0011\u0005\u0013Q\u000e\u0005\t\u0003\u007f\u0002\u0001\u0015\"\u0015\u0002\u0002\"9\u0011q\u0012\u0001\u0005\u0002\u0005Ee\u0001CAZ\u0001\u0005\u0005!/!.\t\u000f\u0005e\u0018\u0002\"\u0001\u0002|\u001aI\u00111\u0019\u0001\u0011\u0002\u0007\u0005\u0011Q\u0019\u0005\b\u0003\u0003ZA\u0011AA\"\u0011\u001d\tym\u0003D\u0001\u0003#D!\"a\u0013\f\u0011\u000b\u0007I\u0011AA'\u0011!\tIg\u0003Q\u0005V\u00055\u0004bBAs\u0017\u0011\u0005\u0013q\u001d\u0005\b\u0003_\\A\u0011IAy\u0011\u001d\t\u0019p\u0003C!\u0003ODq!! \f\t\u0003\ni\u0007C\u0004\u0002v.!\t%a>\u0007\u0013\u0005}\b\u0001%A\u0002\u0002\t\u0005\u0001bBA!+\u0011\u0005\u00111\t\u0005\b\u0005\u000b)BQ\tB\u0004\u0011\u001d\ty-\u0006C#\u0005\u001f1\u0011Ba\u0007\u0001!\u0003\r\tA!\b\t\u000f\u0005\u0005\u0013\u0004\"\u0001\u0002D!I!qE\rCB\u001bE!\u0011\u0006\u0005\b\u0003\u001fLB\u0011\u0001B\u0019\u0011!\ty%\u0007Q\u0005V\u00055d!\u0003B\u001f\u0001A\u0005\u0019\u0011\u0001B \u0011\u001d\t\tE\bC\u0001\u0003\u0007B\u0011Ba\u0011\u001f\u0005\u00046\tB!\u0012\t\u0011\t5c\u0004)C\t\u0005\u001fB\u0001Ba\u0016\u001fA\u0013E!q\n\u0005\b\u0003\u001ftB\u0011\u0001B-\u0011!\tyE\bQ\u0005V\u00055d!\u0003B3\u0001A\u0005\u0019\u0011\u0001B4\u0011\u001d\t\t%\nC\u0001\u0003\u0007B\u0011B!\u001d&\u0005\u00046\tBa\u001d\t\u000f\u0005=W\u0005\"\u0001\u0003x!A\u0011qJ\u0013!\n+\niGB\u0005\u0003\u0004\u0002\u0001\n1!\u0001\u0003\u0006\"9\u0011\u0011\t\u0016\u0005\u0002\u0005\r\u0003\"\u0003B9U\t\u0007k\u0011\u0003BH\u0011\u001d\tyM\u000bC\u0001\u00053C\u0001\"a\u0014+A\u0013U\u0013Q\u000e\u0004\n\u0005K\u0003\u0001\u0013aA\u0001\u0005OCq!!\u00110\t\u0003\t\u0019\u0005C\u0005\u00032>\u0012\rU\"\u0005\u00034\"9\u0011qZ\u0018\u0005\u0002\tm\u0006\u0002CA(_\u0001&)&!\u001c\u0007\u0013\t\u001d\u0007\u0001%A\u0002\u0002\t%\u0007bBA!i\u0011\u0005\u00111\t\u0005\n\u0005'$$\u0019)D\t\u0005+Dq!a45\t\u0003\u0011I\u000e\u0003\u0005\u0002PQ\u0002KQKA7\r%\u0011)\u000f\u0001I\u0001\u0004\u0003\u00119\u000fC\u0004\u0002Be\"\t!a\u0011\t\u0013\t%\u0018H1Q\u0007\u0012\t-\bbBAhs\u0011\u0005!q\u001e\u0005\t\u0003\u001fJ\u0004\u0015\"\u0016\u0002n\u0019I!1 \u0001\u0011\u0002\u0007\u0005!Q \u0005\b\u0003\u0003rD\u0011AA\"\u0011%\u0011IO\u0010b!\u000e#\u0011Y\u000fC\u0004\u0002Pz\"\tAa@\t\u0011\u0005=c\b)C+\u0003[2\u0011ba\u0003\u0001!\u0003\r\ta!\u0004\t\u000f\u0005\u00053\t\"\u0001\u0002D!I!\u0011^\"CB\u001bE!1\u001e\u0005\b\u0003\u001f\u001cE\u0011AB\b\u0011!\tye\u0011Q\u0005V\u00055\u0004bBB\u000e\u0001\u0011\u00053Q\u0004\u0005\b\u0007k\u0001A\u0011IB\u001c\u0011\u001d\u0019)\u0004\u0001C!\u0007#Bqaa\u001a\u0001\t\u0003\u001aI\u0007C\u0004\u0004\u0000\u0001!\te!!\t\u000f\ru\u0005\u0001\"\u0011\u0004 \"91q\u0017\u0001\u0005B\re\u0006\u0002CBf\u0001\u0001&Ya!4\t\u000f\rE\u0007\u0001\"\u0005\u0004T\"91q\u001d\u0001\u0005\u0012\r%\bbBB}\u0001\u0011E11 \u0005\b\t\u0013\u0001A\u0011\u0003C\u0006\u0011\u001d!I\u0002\u0001C\t\t7Aq\u0001b\u000b\u0001\t#!i\u0003C\u0004\u00054\u0001!\t\u0002\"\u000e\t\u000f\u0011m\u0002\u0001\"\u0005\u0005>!9A\u0011\t\u0001\u0005\u0012\u0011\r\u0003b\u0002C$\u0001\u0011EA\u0011\n\u0005\b\t\u001f\u0002A\u0011\u0003C)\u0011\u001d!)\u0006\u0001C!\t/Bq\u0001b\u0017\u0001\t\u0003\"i\u0006C\u0004\u0005b\u0001!\t\u0005b\u0019\t\u000f\u00115\u0004\u0001\"\u0011\u0005p!9A\u0011\u000f\u0001\u0005B\u0011M\u0004b\u0002C<\u0001\u0011\u0005C\u0011\u0010\u0005\b\t{\u0002A\u0011\tC@\u0011\u001d!)\t\u0001C!\t\u000fCq\u0001b#\u0001\t\u0003\"i\tC\u0004\u0005\u0012\u0002!\t\u0005b%\t\u000f\u0011]\u0005\u0001\"\u0011\u0005\u001a\"9AQ\u0014\u0001\u0005B\u0011}\u0005b\u0002Ca\u0001\u0011\u0005C1\u0019\u0005\b\tg\u0004A\u0011\tC{\u0011\u001d)y\u0001\u0001C!\u000b#Aq!b\f\u0001\t\u0003*\t\u0004C\u0004\u0006X\u0001!\t%\"\u0017\t\u000f\u0015u\u0003\u0001\"\u0011\u0006`!9Qq\r\u0001\u0005B\u0015}\u0003bBC5\u0001\u0011\u0005Cq\u000e\u0005\b\u0003k\u0004A\u0011IA|\u00119)Y\u0007\u0001I\u0001\u0004\u0003\u0005I\u0011\u0002C8\u000b[\u00121\u0003\u0016:bm\u0016\u00148/\u00192mKZKWm\u001e'jW\u0016T!a\u001d;\u0002\u0015\r|G\u000e\\3di&|gNC\u0001v\u0003\u0015\u00198-\u00197b\u0007\u0001)r\u0001_A\u0004\u0003k\t\tcE\u0004\u0001sv\fI\"a\u000f\u0011\u0005i\\X\"\u0001;\n\u0005q$(AB!osJ+g\r\u0005\u0003\u007f\u007f\u0006\rQ\"\u0001:\n\u0007\u0005\u0005!OA\u0006Ue\u00064XM]:bE2,\u0007\u0003BA\u0003\u0003\u000fa\u0001\u0001\u0002\u0005\u0002\n\u0001!)\u0019AA\u0006\u0005\u0005\t\u0015\u0003BA\u0007\u0003'\u00012A_A\b\u0013\r\t\t\u0002\u001e\u0002\b\u001d>$\b.\u001b8h!\rQ\u0018QC\u0005\u0004\u0003/!(aA!osB9a0a\u0007\u0002\u0004\u0005}\u0011bAA\u000fe\nyAK]1wKJ\u001c\u0018M\u00197f\u0019&\\W\r\u0005\u0003\u0002\u0006\u0005\u0005B\u0001CA\u0012\u0001\u0011\u0015\r!!\n\u0003\tQC\u0017n]\t\u0005\u0003\u001b\t9C\u0005\u0004\u0002*\u00055\u0012\u0011\b\u0004\u0007\u0003W\u0001\u0001!a\n\u0003\u0019q\u0012XMZ5oK6,g\u000e\u001e \u0011\u000fy\fy#a\u0001\u00024%\u0019\u0011\u0011\u0007:\u0003\u001fQ\u0013\u0018M^3sg\u0006\u0014G.\u001a,jK^\u0004B!!\u0002\u00026\u0011A\u0011q\u0007\u0001\u0005\u0006\u0004\tYA\u0001\u0003D_2d\u0007\u0003\u0003@\u0001\u0003\u0007\t\u0019$a\b\u0011\u000by\fi$a\u0001\n\u0007\u0005}\"O\u0001\u0007WS\u0016<Xj[*ue&tw-\u0001\u0004%S:LG\u000f\n\u000b\u0003\u0003\u000b\u00022A_A$\u0013\r\tI\u0005\u001e\u0002\u0005+:LG/\u0001\u0006v]\u0012,'\u000f\\=j]\u001e,\"!a\r\u0002\u001dYLWm^%eK:$\u0018NZ5feV\u0011\u00111\u000b\t\u0005\u0003+\n\u0019G\u0004\u0003\u0002X\u0005}\u0003cAA-i6\u0011\u00111\f\u0006\u0004\u0003;2\u0018A\u0002\u001fs_>$h(C\u0002\u0002bQ\fa\u0001\u0015:fI\u00164\u0017\u0002BA3\u0003O\u0012aa\u0015;sS:<'bAA1i\u0006aa/[3x\u0013\u0012\u001cFO]5oO\u0006aa/[3x)>\u001cFO]5oOV\u0011\u0011q\u000e\t\u0005\u0003c\nY(\u0004\u0002\u0002t)!\u0011QOA<\u0003\u0011a\u0017M\\4\u000b\u0005\u0005e\u0014\u0001\u00026bm\u0006LA!!\u001a\u0002t\u0005a1\u000f\u001e:j]\u001e\u0004&/\u001a4jq\u0006Qa.Z<Ck&dG-\u001a:\u0016\u0005\u0005\r\u0005\u0003CAC\u0003\u0017\u000b\u0019!a\b\u000e\u0005\u0005\u001d%bAAEe\u00069Q.\u001e;bE2,\u0017\u0002BAG\u0003\u000f\u0013qAQ;jY\u0012,'/A\u0003g_J\u001cW-\u0006\u0004\u0002\u0014\u00065\u0016q\u0013\u000b\u0005\u0003+\u000bY\n\u0005\u0003\u0002\u0006\u0005]EaBAM\u0011\t\u0007\u00111\u0002\u0002\u0005)\"\fG\u000fC\u0004\u0002\u001e\"\u0001\u001d!a(\u0002\u0005\t4\u0007CCAQ\u0003O\u000b\u0019$a+\u0002\u00166\u0011\u00111\u0015\u0006\u0004\u0003K\u0013\u0018aB4f]\u0016\u0014\u0018nY\u0005\u0005\u0003S\u000b\u0019K\u0001\u0007DC:\u0014U/\u001b7e\rJ|W\u000e\u0005\u0003\u0002\u0006\u00055FaBAX\u0011\t\u0007\u0011\u0011\u0017\u0002\u0002\u0005F!\u00111AA\n\u0005M\t%m\u001d;sC\u000e$HK]1og\u001a|'/\\3e+\u0011\t9,!0\u0014\r%I\u0018\u0011XA`!\u0011qx0a/\u0011\t\u0005\u0015\u0011Q\u0018\u0003\t\u0003_KAQ1\u0001\u0002\fA)\u0011\u0011Y\u0006\u0002<6\t\u0001AA\u0006Ue\u0006t7OZ8s[\u0016$W\u0003BAd\u0003\u001b\u001cBaC=\u0002JB9a0a\f\u0002L\u0006M\u0002\u0003BA\u0003\u0003\u001b$\u0001\"a,\f\t\u000b\u0007\u00111B\u0001\bM>\u0014X-Y2i+\u0011\t\u0019.!9\u0015\t\u0005\u0015\u0013Q\u001b\u0005\b\u0003/l\u0001\u0019AAm\u0003\u00051\u0007c\u0002>\u0002\\\u0006-\u0017q\\\u0005\u0004\u0003;$(!\u0003$v]\u000e$\u0018n\u001c82!\u0011\t)!!9\u0005\u000f\u0005\rXB1\u0001\u0002\f\t\tQ+\u0001\u0006iK\u0006$w\n\u001d;j_:,\"!!;\u0011\u000bi\fY/a3\n\u0007\u00055HO\u0001\u0004PaRLwN\\\u0001\u0005Y\u0006\u001cH/\u0006\u0002\u0002L\u0006QA.Y:u\u001fB$\u0018n\u001c8\u0002\u0011Q|7\u000b\u001e:j]\u001e$\"!a\u001c\u0002\rqJg.\u001b;?)\t\ti\u0010E\u0003\u0002B&\tYLA\u0005F[B$\u0018PV5foN!Q#\u001fB\u0002!\u0015\t\tmCA\u0007\u0003\u001dI7/R7qif,\"A!\u0003\u0011\u0007i\u0014Y!C\u0002\u0003\u000eQ\u0014qAQ8pY\u0016\fg.\u0006\u0003\u0003\u0012\teA\u0003BA#\u0005'Aq!a6\u0019\u0001\u0004\u0011)\u0002E\u0004{\u00037\fiAa\u0006\u0011\t\u0005\u0015!\u0011\u0004\u0003\b\u0003GD\"\u0019AA\u0006\u0005\u00191uN]2fIV!!q\u0004B\u0013'\u0011I\u0012P!\t\u0011\u000b\u0005\u00057Ba\t\u0011\t\u0005\u0015!Q\u0005\u0003\b\u0003_K\"\u0019AA\u0006\u0003\u00191wN]2fIV\u0011!1\u0006\t\u0006}\n5\"1E\u0005\u0004\u0005_\u0011(AB$f]N+\u0017/\u0006\u0003\u00034\tmB\u0003BA#\u0005kAq!a6\u001d\u0001\u0004\u00119\u0004E\u0004{\u00037\u0014\u0019C!\u000f\u0011\t\u0005\u0015!1\b\u0003\b\u0003Gd\"\u0019AA\u0006\u0005\u0019\u0019F.[2fIN!a$\u001fB!!\u0015\t\tmCA\u0002\u0003%)g\u000e\u001a9pS:$8/\u0006\u0002\u0003HA!\u0011\u0011\u0015B%\u0013\u0011\u0011Y%a)\u0003\u001bMc\u0017nY3J]R,'O^1m\u0003\u00111'o\\7\u0016\u0005\tE\u0003c\u0001>\u0003T%\u0019!Q\u000b;\u0003\u0007%sG/A\u0003v]RLG.\u0006\u0003\u0003\\\t\rD\u0003BA#\u0005;Bq!a6$\u0001\u0004\u0011y\u0006E\u0004{\u00037\f\u0019A!\u0019\u0011\t\u0005\u0015!1\r\u0003\b\u0003G\u001c#\u0019AA\u0006\u0005\u0019i\u0015\r\u001d9fIV!!\u0011\u000eB8'\u0011)\u0013Pa\u001b\u0011\u000b\u0005\u00057B!\u001c\u0011\t\u0005\u0015!q\u000e\u0003\b\u0003_+#\u0019AA\u0006\u0003\u001di\u0017\r\u001d9j]\u001e,\"A!\u001e\u0011\u000fi\fY.a\u0001\u0003nU!!\u0011\u0010BA)\u0011\t)Ea\u001f\t\u000f\u0005]\u0007\u00061\u0001\u0003~A9!0a7\u0003n\t}\u0004\u0003BA\u0003\u0005\u0003#q!a9)\u0005\u0004\tYA\u0001\u0006GY\u0006$X*\u00199qK\u0012,BAa\"\u0003\u000eN!!&\u001fBE!\u0015\t\tm\u0003BF!\u0011\t)A!$\u0005\u000f\u0005=&F1\u0001\u0002\fU\u0011!\u0011\u0013\t\bu\u0006m\u00171\u0001BJ!\u0015q(Q\u0013BF\u0013\r\u00119J\u001d\u0002\u0013\u000f\u0016tGK]1wKJ\u001c\u0018M\u00197f\u001f:\u001cW-\u0006\u0003\u0003\u001c\n\rF\u0003BA#\u0005;Cq!a6.\u0001\u0004\u0011y\nE\u0004{\u00037\u0014YI!)\u0011\t\u0005\u0015!1\u0015\u0003\b\u0003Gl#\u0019AA\u0006\u0005!\t\u0005\u000f]3oI\u0016$W\u0003\u0002BU\u0005_\u001bBaL=\u0003,B)\u0011\u0011Y\u0006\u0003.B!\u0011Q\u0001BX\t\u001d\tyk\fb\u0001\u0003c\u000bAA]3tiV\u0011!Q\u0017\t\u0006}\n]&QV\u0005\u0004\u0005s\u0013(AD$f]R\u0013\u0018M^3sg\u0006\u0014G.Z\u000b\u0005\u0005{\u0013)\r\u0006\u0003\u0002F\t}\u0006bBAle\u0001\u0007!\u0011\u0019\t\bu\u0006m'Q\u0016Bb!\u0011\t)A!2\u0005\u000f\u0005\r(G1\u0001\u0002\f\tI\u0001K]3qK:$W\rZ\u000b\u0005\u0005\u0017\u0014\tn\u0005\u00035s\n5\u0007#BAa\u0017\t=\u0007\u0003BA\u0003\u0005#$q!a,5\u0005\u0004\t\t,A\u0002ggR,\"Aa6\u0011\u000by\u00149La4\u0016\t\tm'1\u001d\u000b\u0005\u0003\u000b\u0012i\u000eC\u0004\u0002X^\u0002\rAa8\u0011\u000fi\fYNa4\u0003bB!\u0011Q\u0001Br\t\u001d\t\u0019o\u000eb\u0001\u0003\u0017\u0011\u0001BR5mi\u0016\u0014X\rZ\n\u0005se\u0014\t%\u0001\u0003qe\u0016$WC\u0001Bw!\u001dQ\u00181\\A\u0002\u0005\u0013)BA!=\u0003zR!\u0011Q\tBz\u0011\u001d\t9\u000e\u0010a\u0001\u0005k\u0004rA_An\u0003\u0007\u00119\u0010\u0005\u0003\u0002\u0006\teHaBAry\t\u0007\u00111\u0002\u0002\u000b)\u0006\\WM\\,iS2,7\u0003\u0002 z\u0005\u0003*Ba!\u0001\u0004\nQ!\u0011QIB\u0002\u0011\u001d\t9.\u0011a\u0001\u0007\u000b\u0001rA_An\u0003\u0007\u00199\u0001\u0005\u0003\u0002\u0006\r%AaBAr\u0003\n\u0007\u00111\u0002\u0002\r\tJ|\u0007\u000f]3e/\"LG.Z\n\u0005\u0007f\u0014\t%\u0006\u0003\u0004\u0012\reA\u0003BA#\u0007'Aq!a6G\u0001\u0004\u0019)\u0002E\u0004{\u00037\f\u0019aa\u0006\u0011\t\u0005\u00151\u0011\u0004\u0003\b\u0003G4%\u0019AA\u0006\u0003)!\u0003\u000f\\;tIAdWo]\u000b\u0007\u0007?\u0019ic!\n\u0015\t\r\u00052q\u0006\u000b\u0005\u0007G\u00199\u0003\u0005\u0003\u0002\u0006\r\u0015BaBAM\u0011\n\u0007\u00111\u0002\u0005\b\u0003;C\u00059AB\u0015!)\t\t+a*\u0002 \r-21\u0005\t\u0005\u0003\u000b\u0019i\u0003B\u0004\u00020\"\u0013\r!!-\t\u000f\rE\u0002\n1\u0001\u00044\u0005\u0011\u0001p\u001d\t\u0006}\nU51F\u0001\u0011IAdWo\u001d\u0013qYV\u001cHeY8m_:,ba!\u000f\u0004H\r}B\u0003BB\u001e\u0007\u0013\"Ba!\u0010\u0004BA!\u0011QAB \t\u001d\tI*\u0013b\u0001\u0003\u0017Aq!!(J\u0001\b\u0019\u0019\u0005\u0005\u0006\u0002\"\u0006\u001d\u0016qDB#\u0007{\u0001B!!\u0002\u0004H\u00119\u0011qV%C\u0002\u0005E\u0006bBB\u0019\u0013\u0002\u000711\n\t\u0006}\u000e53QI\u0005\u0004\u0007\u001f\u0012(a\u0004+sCZ,'o]1cY\u0016|enY3\u0016\r\rM3\u0011MB-)\u0011\u0019)fa\u0019\u0015\t\r]31\f\t\u0005\u0003\u000b\u0019I\u0006B\u0004\u0002\u001a*\u0013\r!a\u0003\t\u000f\u0005u%\nq\u0001\u0004^AQ\u0011\u0011UAT\u0003?\u0019yfa\u0016\u0011\t\u0005\u00151\u0011\r\u0003\b\u0003_S%\u0019AAY\u0011\u001d\u0019\tD\u0013a\u0001\u0007K\u0002BA`@\u0004`\u0005\u0019Q.\u00199\u0016\r\r-4\u0011PB9)\u0011\u0019iga\u001f\u0015\t\r=41\u000f\t\u0005\u0003\u000b\u0019\t\bB\u0004\u0002\u001a.\u0013\r!a\u0003\t\u000f\u0005u5\nq\u0001\u0004vAQ\u0011\u0011UAT\u0003?\u00199ha\u001c\u0011\t\u0005\u00151\u0011\u0010\u0003\b\u0003_[%\u0019AA\u0006\u0011\u001d\t9n\u0013a\u0001\u0007{\u0002rA_An\u0003\u0007\u00199(A\u0004d_2dWm\u0019;\u0016\r\r\r5\u0011SBE)\u0011\u0019)ia%\u0015\t\r\u001d51\u0012\t\u0005\u0003\u000b\u0019I\tB\u0004\u0002\u001a2\u0013\r!a\u0003\t\u000f\u0005uE\nq\u0001\u0004\u000eBQ\u0011\u0011UAT\u0003?\u0019yia\"\u0011\t\u0005\u00151\u0011\u0013\u0003\b\u0003_c%\u0019AA\u0006\u0011\u001d\u0019)\n\u0014a\u0001\u0007/\u000b!\u0001\u001d4\u0011\u000fi\u001cI*a\u0001\u0004\u0010&\u001911\u0014;\u0003\u001fA\u000b'\u000f^5bY\u001a+hn\u0019;j_:\fqA\u001a7bi6\u000b\u0007/\u0006\u0004\u0004\"\u000e=6q\u0015\u000b\u0005\u0007G\u001b\t\f\u0006\u0003\u0004&\u000e%\u0006\u0003BA\u0003\u0007O#q!!'N\u0005\u0004\tY\u0001C\u0004\u0002\u001e6\u0003\u001daa+\u0011\u0015\u0005\u0005\u0016qUA\u0010\u0007[\u001b)\u000b\u0005\u0003\u0002\u0006\r=FaBAX\u001b\n\u0007\u00111\u0002\u0005\b\u0003/l\u0005\u0019ABZ!\u001dQ\u00181\\A\u0002\u0007k\u0003RA BK\u0007[\u000bqA\u001a7biR,g.\u0006\u0003\u0004<\u000e\u0005G\u0003BB_\u0007\u0007\u0004R!!1\f\u0007\u007f\u0003B!!\u0002\u0004B\u00129\u0011q\u0016(C\u0002\u0005-\u0001bBBc\u001d\u0002\u000f1qY\u0001\u000eCN$&/\u0019<feN\f'\r\\3\u0011\u000fi\fY.a\u0001\u0004JB)aP!&\u0004@\u00061\u0011m\u001d+iSN$B!a\b\u0004P\"91\u0011G(A\u0002\t\u0005\u0013!\u00038fo\u001a{'oY3e+\u0011\u0019)na7\u0015\t\r]7Q\u001c\t\u0006\u0003\u0003\\1\u0011\u001c\t\u0005\u0003\u000b\u0019Y\u000eB\u0004\u00020B\u0013\r!a\u0003\t\u0011\rE\u0002\u000b\"a\u0001\u0007?\u0004RA_Bq\u0007KL1aa9u\u0005!a$-\u001f8b[\u0016t\u0004#\u0002@\u0003.\re\u0017a\u00038fo\u0006\u0003\b/\u001a8eK\u0012,Baa;\u0004rR!1Q^Bz!\u0015\t\tmCBx!\u0011\t)a!=\u0005\u000f\u0005=\u0016K1\u0001\u00022\"91Q_)A\u0002\r]\u0018\u0001\u0002;iCR\u0004RA B\\\u0007_\fAB\\3x!J,\u0007/\u001a8eK\u0012,Ba!@\u0005\u0004Q!1q C\u0003!\u0015\t\tm\u0003C\u0001!\u0011\t)\u0001b\u0001\u0005\u000f\u0005=&K1\u0001\u00022\"91Q\u001f*A\u0002\u0011\u001d\u0001#\u0002@\u00038\u0012\u0005\u0011!\u00038fo6\u000b\u0007\u000f]3e+\u0011!i\u0001b\u0005\u0015\t\u0011=AQ\u0003\t\u0006\u0003\u0003\\A\u0011\u0003\t\u0005\u0003\u000b!\u0019\u0002B\u0004\u00020N\u0013\r!a\u0003\t\u000f\u0005]7\u000b1\u0001\u0005\u0018A9!0a7\u0002\u0004\u0011E\u0011!\u00048fo\u001ac\u0017\r^'baB,G-\u0006\u0003\u0005\u001e\u0011\rB\u0003\u0002C\u0010\tK\u0001R!!1\f\tC\u0001B!!\u0002\u0005$\u00119\u0011q\u0016+C\u0002\u0005-\u0001bBAl)\u0002\u0007Aq\u0005\t\bu\u0006m\u00171\u0001C\u0015!\u0015q(Q\u0013C\u0011\u0003-qWm\u001e$jYR,'/\u001a3\u0015\t\t\u0005Cq\u0006\u0005\b\tc)\u0006\u0019\u0001Bw\u0003\u0005\u0001\u0018!\u00038foNc\u0017nY3e)\u0011\u0011\t\u0005b\u000e\t\u000f\u0011eb\u000b1\u0001\u0003H\u0005Qq,\u001a8ea>Lg\u000e^:\u0002\u001f9,w\u000f\u0012:paB,Gm\u00165jY\u0016$BA!\u0011\u0005@!9A\u0011G,A\u0002\t5\u0018!\u00048foR\u000b7.\u001a8XQ&dW\r\u0006\u0003\u0003B\u0011\u0015\u0003b\u0002C\u00191\u0002\u0007!Q^\u0001\t]\u0016<H+Y6f]R!!\u0011\tC&\u0011\u001d!i%\u0017a\u0001\u0005#\n\u0011A\\\u0001\u000b]\u0016<HI]8qa\u0016$G\u0003\u0002B!\t'Bq\u0001\"\u0014[\u0001\u0004\u0011\t&\u0001\u0004gS2$XM\u001d\u000b\u0005\u0003?!I\u0006C\u0004\u00052m\u0003\rA!<\u0002\u0015]LG\u000f\u001b$jYR,'\u000f\u0006\u0003\u0002 \u0011}\u0003b\u0002C\u00199\u0002\u0007!Q^\u0001\na\u0006\u0014H/\u001b;j_:$B\u0001\"\u001a\u0005lA9!\u0010b\u001a\u0002 \u0005}\u0011b\u0001C5i\n1A+\u001e9mKJBq\u0001\"\r^\u0001\u0004\u0011i/\u0001\u0003j]&$XCAA\u0010\u0003\u0011!'o\u001c9\u0015\t\u0005}AQ\u000f\u0005\b\t\u001bz\u0006\u0019\u0001B)\u0003\u0011!\u0018m[3\u0015\t\u0005}A1\u0010\u0005\b\t\u001b\u0002\u0007\u0019\u0001B)\u0003\u0015\u0019H.[2f)\u0019\ty\u0002\"!\u0005\u0004\"9!QJ1A\u0002\tE\u0003b\u0002B,C\u0002\u0007!\u0011K\u0001\nIJ|\u0007o\u00165jY\u0016$B!a\b\u0005\n\"9A\u0011\u00072A\u0002\t5\u0018!\u0003;bW\u0016<\u0006.\u001b7f)\u0011\ty\u0002b$\t\u000f\u0011E2\r1\u0001\u0003n\u0006!1\u000f]1o)\u0011!)\u0007\"&\t\u000f\u0011EB\r1\u0001\u0003n\u000691\u000f\u001d7ji\u0006#H\u0003\u0002C3\t7Cq\u0001\"\u0014f\u0001\u0004\u0011\t&\u0001\u0005tG\u0006tG*\u001a4u+\u0019!\t\u000b\"-\u0005*R!A1\u0015C_)\u0011!)\u000bb-\u0015\t\u0011\u001dF1\u0016\t\u0005\u0003\u000b!I\u000bB\u0004\u0002\u001a\u001a\u0014\r!a\u0003\t\u000f\u0005ue\rq\u0001\u0005.BQ\u0011\u0011UAT\u0003?!y\u000bb*\u0011\t\u0005\u0015A\u0011\u0017\u0003\b\u0003_3'\u0019AA\u0006\u0011\u001d!)L\u001aa\u0001\to\u000b!a\u001c9\u0011\u0013i$I\fb,\u0002\u0004\u0011=\u0016b\u0001C^i\nIa)\u001e8di&|gN\r\u0005\b\t\u007f3\u0007\u0019\u0001CX\u0003\u0005Q\u0018!C:dC:\u0014\u0016n\u001a5u+\u0019!)\r\"6\u0005NR!Aq\u0019Cn)\u0011!I\rb6\u0015\t\u0011-Gq\u001a\t\u0005\u0003\u000b!i\rB\u0004\u0002\u001a\u001e\u0014\r!a\u0003\t\u000f\u0005uu\rq\u0001\u0005RBQ\u0011\u0011UAT\u0003?!\u0019\u000eb3\u0011\t\u0005\u0015AQ\u001b\u0003\b\u0003_;'\u0019AA\u0006\u0011\u001d!)l\u001aa\u0001\t3\u0004\u0012B\u001fC]\u0003\u0007!\u0019\u000eb5\t\u000f\u0011}v\r1\u0001\u0005T\":q\rb8\u0005l\u0012=\b\u0003\u0002Cq\tOl!\u0001b9\u000b\u0007\u0011\u0015H/\u0001\u0006b]:|G/\u0019;j_:LA\u0001\";\u0005d\nIQ.[4sCRLwN\\\u0011\u0003\t[\f\u0001\u000e\u00165fA\t,\u0007.\u0019<j_J\u0004sN\u001a\u0011ag\u000e\fgNU5hQR\u0004\u0007\u0005[1tA\rD\u0017M\\4fI:\u0002C\u000b[3!aJ,g/[8vg\u0002\u0012W\r[1wS>\u0014\beY1oA\t,\u0007E]3qe>$WoY3eA]LG\u000f\u001b\u0011tG\u0006t'+[4ii:\u0012XM^3sg\u0016t\u0013E\u0001Cy\u0003\u0015\u0011d&\u000f\u00181\u0003\u001d9'o\\;q\u0005f,B\u0001b>\u0006\bQ!A\u0011`C\u0006!!!Y0\"\u0001\u0006\u0006\u0005}QB\u0001C\u007f\u0015\r!yP]\u0001\nS6lW\u000f^1cY\u0016LA!b\u0001\u0005~\n\u0019Q*\u00199\u0011\t\u0005\u0015Qq\u0001\u0003\b\u000b\u0013A'\u0019AA\u0006\u0005\u0005Y\u0005bBAlQ\u0002\u0007QQ\u0002\t\bu\u0006m\u00171AC\u0003\u0003\u0015)hN_5q+\u0019)\u0019\"b\u0007\u0006$Q!QQCC\u0014!\u001dQHqMC\f\u000b?\u0001R!!1\f\u000b3\u0001B!!\u0002\u0006\u001c\u00119QQD5C\u0002\u0005-!AA!2!\u0015\t\tmCC\u0011!\u0011\t)!b\t\u0005\u000f\u0015\u0015\u0012N1\u0001\u0002\f\t\u0011\u0011I\r\u0005\b\u000bSI\u00079AC\u0016\u0003\u0019\t7\u000fU1jeB9!0a7\u0002\u0004\u00155\u0002c\u0002>\u0005h\u0015eQ\u0011E\u0001\u0007k:T\u0018\u000e]\u001a\u0016\u0011\u0015MRqHC#\u000b\u0017\"B!\"\u000e\u0006PAI!0b\u000e\u0006<\u0015\u0005SqI\u0005\u0004\u000bs!(A\u0002+va2,7\u0007E\u0003\u0002B.)i\u0004\u0005\u0003\u0002\u0006\u0015}BaBC\u000fU\n\u0007\u00111\u0002\t\u0006\u0003\u0003\\Q1\t\t\u0005\u0003\u000b))\u0005B\u0004\u0006&)\u0014\r!a\u0003\u0011\u000b\u0005\u00057\"\"\u0013\u0011\t\u0005\u0015Q1\n\u0003\b\u000b\u001bR'\u0019AA\u0006\u0005\t\t5\u0007C\u0004\u0006R)\u0004\u001d!b\u0015\u0002\u0011\u0005\u001cHK]5qY\u0016\u0004rA_An\u0003\u0007))\u0006E\u0005{\u000bo)i$b\u0011\u0006J\u0005Ia-\u001b7uKJtu\u000e\u001e\u000b\u0005\u0003?)Y\u0006C\u0004\u00052-\u0004\rA!<\u0002\u000b%t\u0017\u000e^:\u0016\u0005\u0015\u0005\u0004#\u0002@\u0006d\u0005}\u0011bAC3e\nA\u0011\n^3sCR|'/A\u0003uC&d7/\u0001\u0003uC&d\u0017AC:va\u0016\u0014H\u0005^1jY&!Q\u0011NA\u000e\u0001")
public interface TraversableViewLike<A, Coll, This extends TraversableView<A, Coll> & TraversableViewLike<A, Coll, This>>
extends Traversable<A>,
ViewMkString<A> {
    public /* synthetic */ TraversableView scala$collection$TraversableViewLike$$super$tail();

    public Coll underlying();

    default public String viewIdentifier() {
        return "";
    }

    public static /* synthetic */ String viewIdString$(TraversableViewLike $this) {
        return $this.viewIdString();
    }

    default public String viewIdString() {
        return "";
    }

    default public String viewToString() {
        return new java.lang.StringBuilder(5).append(this.stringPrefix()).append(this.viewIdString()).append("(...)").toString();
    }

    public static /* synthetic */ String stringPrefix$(TraversableViewLike $this) {
        return $this.stringPrefix();
    }

    @Override
    default public String stringPrefix() {
        return "TraversableView";
    }

    @Override
    default public Builder<A, This> newBuilder() {
        throw new UnsupportedOperationException(Predef$any2stringadd$.MODULE$.$plus$extension(Predef$.MODULE$.any2stringadd(this), ".newBuilder"));
    }

    default public <B, That> That force(CanBuildFrom<Coll, B, That> bf) {
        Builder<B, That> b = bf.apply(this.underlying());
        b.$plus$plus$eq(this);
        return b.result();
    }

    @Override
    default public <B, That> That $plus$plus(GenTraversableOnce<B> xs, CanBuildFrom<This, B, That> bf) {
        return (That)this.newAppended(xs.seq().toTraversable());
    }

    @Override
    default public <B, That> That $plus$plus$colon(TraversableOnce<B> xs, CanBuildFrom<This, B, That> bf) {
        return (That)this.newPrepended(xs.seq().toTraversable());
    }

    @Override
    default public <B, That> That $plus$plus$colon(Traversable<B> xs, CanBuildFrom<This, B, That> bf) {
        return (That)this.newPrepended(xs);
    }

    @Override
    default public <B, That> That map(Function1<A, B> f, CanBuildFrom<This, B, That> bf) {
        return (That)this.newMapped(f);
    }

    @Override
    default public <B, That> That collect(PartialFunction<A, B> pf, CanBuildFrom<This, B, That> bf) {
        return this.filter((Function1<Object, Object> & java.io.Serializable & Serializable)x -> BoxesRunTime.boxToBoolean(pf.isDefinedAt(x))).map((Function1<A, B>)pf, bf);
    }

    @Override
    default public <B, That> That flatMap(Function1<A, GenTraversableOnce<B>> f, CanBuildFrom<This, B, That> bf) {
        return (That)this.newFlatMapped(f);
    }

    @Override
    default public <B> Transformed<B> flatten(Function1<A, GenTraversableOnce<B>> asTraversable) {
        return this.newFlatMapped(asTraversable);
    }

    private This asThis(Transformed<A> xs) {
        return (This)xs;
    }

    default public <B> Transformed<B> newForced(Function0<GenSeq<B>> xs) {
        return new Forced<B>(this, xs){
            private final GenSeq<B> forced;
            private final /* synthetic */ TraversableViewLike $outer;

            public <U> void foreach(Function1<B, U> f) {
                Forced.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return Forced.viewIdentifier$(this);
            }

            public GenSeq<B> forced() {
                return this.forced;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Forced$$$outer() {
                return this.$outer;
            }
            {
                GenSeq forced;
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.forced = forced = (GenSeq)xs$1.apply();
                Forced.$init$(this);
            }
        };
    }

    default public <B> Transformed<B> newAppended(GenTraversable<B> that) {
        return new Appended<B>(this, that){
            private final GenTraversable<B> rest;
            private final /* synthetic */ TraversableViewLike $outer;

            public <U> void foreach(Function1<B, U> f) {
                Appended.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return Appended.viewIdentifier$(this);
            }

            public GenTraversable<B> rest() {
                return this.rest;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Appended$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.rest = that$1;
                Appended.$init$(this);
            }
        };
    }

    default public <B> Transformed<B> newPrepended(GenTraversable<B> that) {
        return new Prepended<B>(this, that){
            private final GenTraversable<B> fst;
            private final /* synthetic */ TraversableViewLike $outer;

            public <U> void foreach(Function1<B, U> f) {
                Prepended.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return Prepended.viewIdentifier$(this);
            }

            public GenTraversable<B> fst() {
                return this.fst;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Prepended$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.fst = that$2;
                Prepended.$init$(this);
            }
        };
    }

    default public <B> Transformed<B> newMapped(Function1<A, B> f) {
        return new Mapped<B>(this, f){
            private final Function1<A, B> mapping;
            private final /* synthetic */ TraversableViewLike $outer;

            public <U> void foreach(Function1<B, U> f) {
                Mapped.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return Mapped.viewIdentifier$(this);
            }

            public Function1<A, B> mapping() {
                return this.mapping;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Mapped$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.mapping = f$7;
                Mapped.$init$(this);
            }
        };
    }

    default public <B> Transformed<B> newFlatMapped(Function1<A, GenTraversableOnce<B>> f) {
        return new FlatMapped<B>(this, f){
            private final Function1<A, GenTraversableOnce<B>> mapping;
            private final /* synthetic */ TraversableViewLike $outer;

            public <U> void foreach(Function1<B, U> f) {
                FlatMapped.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return FlatMapped.viewIdentifier$(this);
            }

            public Function1<A, GenTraversableOnce<B>> mapping() {
                return this.mapping;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$FlatMapped$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.mapping = f$8;
                FlatMapped.$init$(this);
            }
        };
    }

    default public Transformed<A> newFiltered(Function1<A, Object> p) {
        return new Filtered(this, p){
            private final Function1<A, Object> pred;
            private final /* synthetic */ TraversableViewLike $outer;

            public <U> void foreach(Function1<A, U> f) {
                Filtered.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return Filtered.viewIdentifier$(this);
            }

            public Function1<A, Object> pred() {
                return this.pred;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Filtered$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.pred = p$1;
                Filtered.$init$(this);
            }
        };
    }

    default public Transformed<A> newSliced(SliceInterval _endpoints) {
        return new Sliced(this, _endpoints){
            private final SliceInterval endpoints;
            private final /* synthetic */ TraversableViewLike $outer;

            public int from() {
                return Sliced.from$(this);
            }

            public int until() {
                return Sliced.until$(this);
            }

            public <U> void foreach(Function1<A, U> f) {
                Sliced.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return Sliced.viewIdentifier$(this);
            }

            public SliceInterval endpoints() {
                return this.endpoints;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Sliced$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.endpoints = _endpoints$1;
                Sliced.$init$(this);
            }
        };
    }

    default public Transformed<A> newDroppedWhile(Function1<A, Object> p) {
        return new DroppedWhile(this, p){
            private final Function1<A, Object> pred;
            private final /* synthetic */ TraversableViewLike $outer;

            public <U> void foreach(Function1<A, U> f) {
                DroppedWhile.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return DroppedWhile.viewIdentifier$(this);
            }

            public Function1<A, Object> pred() {
                return this.pred;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$DroppedWhile$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.pred = p$2;
                DroppedWhile.$init$(this);
            }
        };
    }

    default public Transformed<A> newTakenWhile(Function1<A, Object> p) {
        return new TakenWhile(this, p){
            private final Function1<A, Object> pred;
            private final /* synthetic */ TraversableViewLike $outer;

            public <U> void foreach(Function1<A, U> f) {
                TakenWhile.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return TakenWhile.viewIdentifier$(this);
            }

            public Function1<A, Object> pred() {
                return this.pred;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$TakenWhile$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.pred = p$3;
                TakenWhile.$init$(this);
            }
        };
    }

    default public Transformed<A> newTaken(int n) {
        return this.newSliced(SliceInterval$.MODULE$.apply(0, n));
    }

    default public Transformed<A> newDropped(int n) {
        return this.newSliced(SliceInterval$.MODULE$.apply(n, Integer.MAX_VALUE));
    }

    @Override
    default public This filter(Function1<A, Object> p) {
        return this.asThis(this.newFiltered(p));
    }

    default public This withFilter(Function1<A, Object> p) {
        return this.asThis(this.newFiltered(p));
    }

    @Override
    default public Tuple2<This, This> partition(Function1<A, Object> p) {
        return new Tuple2<This, This>(this.asThis(this.newFiltered(p)), this.asThis(this.newFiltered((Function1<Object, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToBoolean(TraversableViewLike.$anonfun$partition$1(p, x$1)))));
    }

    @Override
    default public This init() {
        return this.asThis(this.newSliced(SliceInterval$.MODULE$.apply(0, this.size() - 1)));
    }

    @Override
    default public This drop(int n) {
        return this.asThis(this.newDropped(n));
    }

    @Override
    default public This take(int n) {
        return this.asThis(this.newTaken(n));
    }

    @Override
    default public This slice(int from, int until) {
        return this.asThis(this.newSliced(SliceInterval$.MODULE$.apply(from, until)));
    }

    @Override
    default public This dropWhile(Function1<A, Object> p) {
        return this.asThis(this.newDroppedWhile(p));
    }

    @Override
    default public This takeWhile(Function1<A, Object> p) {
        return this.asThis(this.newTakenWhile(p));
    }

    @Override
    default public Tuple2<This, This> span(Function1<A, Object> p) {
        return new Tuple2<This, This>(this.asThis(this.newTakenWhile(p)), this.asThis(this.newDroppedWhile(p)));
    }

    @Override
    default public Tuple2<This, This> splitAt(int n) {
        return new Tuple2<This, This>(this.asThis(this.newTaken(n)), this.asThis(this.newDropped(n)));
    }

    @Override
    default public <B, That> That scanLeft(B z, Function2<B, A, B> op, CanBuildFrom<This, B, That> bf) {
        return (That)this.newForced((Function0<Seq> & java.io.Serializable & Serializable)() -> this.thisSeq().scanLeft(z, op, Seq$.MODULE$.canBuildFrom()));
    }

    @Override
    default public <B, That> That scanRight(B z, Function2<A, B, B> op, CanBuildFrom<This, B, That> bf) {
        return (That)this.newForced((Function0<Seq> & java.io.Serializable & Serializable)() -> this.thisSeq().scanRight(z, op, Seq$.MODULE$.canBuildFrom()));
    }

    @Override
    default public <K> Map<K, This> groupBy(Function1<A, K> f) {
        return this.thisSeq().groupBy(f).mapValues((Function1<Seq, TraversableView> & java.io.Serializable & Serializable)xs -> this.asThis(this.newForced((Function0<Seq> & java.io.Serializable & Serializable)() -> xs)));
    }

    @Override
    default public <A1, A2> Tuple2<Transformed<A1>, Transformed<A2>> unzip(Function1<A, Tuple2<A1, A2>> asPair) {
        return new Tuple2<Transformed<A1>, Transformed<A2>>(this.newMapped((Function1<Object, Object> & java.io.Serializable & Serializable)x -> ((Tuple2)asPair.apply(x))._1()), this.newMapped((Function1<Object, Object> & java.io.Serializable & Serializable)x -> ((Tuple2)asPair.apply(x))._2()));
    }

    @Override
    default public <A1, A2, A3> Tuple3<Transformed<A1>, Transformed<A2>, Transformed<A3>> unzip3(Function1<A, Tuple3<A1, A2, A3>> asTriple) {
        return new Tuple3<Transformed<A1>, Transformed<A2>, Transformed<A3>>(this.newMapped((Function1<Object, Object> & java.io.Serializable & Serializable)x -> ((Tuple3)asTriple.apply(x))._1()), this.newMapped((Function1<Object, Object> & java.io.Serializable & Serializable)x -> ((Tuple3)asTriple.apply(x))._2()), this.newMapped((Function1<Object, Object> & java.io.Serializable & Serializable)x -> ((Tuple3)asTriple.apply(x))._3()));
    }

    @Override
    default public This filterNot(Function1<A, Object> p) {
        return this.asThis(this.newFiltered((Function1<Object, Object> & java.io.Serializable & Serializable)a -> BoxesRunTime.boxToBoolean(TraversableViewLike.$anonfun$filterNot$1(p, a))));
    }

    @Override
    default public Iterator<This> inits() {
        return this.thisSeq().inits().map((Function1<Seq, TraversableView> & java.io.Serializable & Serializable)as -> this.newForced((Function0<Seq> & java.io.Serializable & Serializable)() -> as));
    }

    @Override
    default public Iterator<This> tails() {
        return this.thisSeq().tails().map((Function1<Seq, TraversableView> & java.io.Serializable & Serializable)as -> this.newForced((Function0<Seq> & java.io.Serializable & Serializable)() -> as));
    }

    @Override
    default public This tail() {
        if (this.isEmpty()) {
            return (This)this.scala$collection$TraversableViewLike$$super$tail();
        }
        return this.asThis(this.newDropped(1));
    }

    public static /* synthetic */ String toString$(TraversableViewLike $this) {
        return $this.toString();
    }

    @Override
    default public String toString() {
        return this.viewToString();
    }

    public static /* synthetic */ boolean $anonfun$partition$1(Function1 p$4, Object x$1) {
        return !BoxesRunTime.unboxToBoolean(p$4.apply(x$1));
    }

    public static /* synthetic */ boolean $anonfun$filterNot$1(Function1 p$5, Object a) {
        return !BoxesRunTime.unboxToBoolean(p$5.apply(a));
    }

    public static void $init$(TraversableViewLike $this) {
    }

    public abstract class AbstractTransformed<B>
    implements Transformed<B> {
        private Coll underlying;
        private volatile boolean bitmap$0;

        @Override
        public final String viewIdString() {
            return ((Transformed)this).viewIdString();
        }

        @Override
        public Option<B> headOption() {
            return ((Transformed)this).headOption();
        }

        @Override
        public B last() {
            return (B)((Transformed)this).last();
        }

        @Override
        public Option<B> lastOption() {
            return ((Transformed)this).lastOption();
        }

        @Override
        public String stringPrefix() {
            return ((Transformed)this).stringPrefix();
        }

        @Override
        public String toString() {
            return ((Transformed)this).toString();
        }

        @Override
        public /* synthetic */ TraversableView scala$collection$TraversableViewLike$$super$tail() {
            return (TraversableView)TraversableLike.tail$(this);
        }

        @Override
        public String viewIdentifier() {
            return ((TraversableViewLike)this).viewIdentifier();
        }

        @Override
        public String viewToString() {
            return ((TraversableViewLike)this).viewToString();
        }

        @Override
        public Builder<B, TraversableView<B, Coll>> newBuilder() {
            return ((TraversableViewLike)this).newBuilder();
        }

        @Override
        public <B, That> That force(CanBuildFrom<Coll, B, That> bf) {
            return (That)((TraversableViewLike)this).force(bf);
        }

        @Override
        public <B, That> That $plus$plus(GenTraversableOnce<B> xs, CanBuildFrom<TraversableView<B, Coll>, B, That> bf) {
            return (That)((TraversableViewLike)this).$plus$plus((GenTraversableOnce<B>)xs, bf);
        }

        @Override
        public <B, That> That $plus$plus$colon(TraversableOnce<B> xs, CanBuildFrom<TraversableView<B, Coll>, B, That> bf) {
            return (That)((TraversableViewLike)this).$plus$plus$colon((TraversableOnce<B>)xs, (CanBuildFrom<This, B, That>)bf);
        }

        @Override
        public <B, That> That $plus$plus$colon(Traversable<B> xs, CanBuildFrom<TraversableView<B, Coll>, B, That> bf) {
            return (That)((TraversableViewLike)this).$plus$plus$colon((Traversable<B>)xs, (CanBuildFrom<This, B, That>)bf);
        }

        @Override
        public <B, That> That map(Function1<B, B> f, CanBuildFrom<TraversableView<B, Coll>, B, That> bf) {
            return (That)((TraversableViewLike)this).map((Function1<A, B>)f, bf);
        }

        @Override
        public <B, That> That collect(PartialFunction<B, B> pf, CanBuildFrom<TraversableView<B, Coll>, B, That> bf) {
            return (That)((TraversableViewLike)this).collect((PartialFunction<A, B>)pf, bf);
        }

        @Override
        public <B, That> That flatMap(Function1<B, GenTraversableOnce<B>> f, CanBuildFrom<TraversableView<B, Coll>, B, That> bf) {
            return (That)((TraversableViewLike)this).flatMap((Function1<A, GenTraversableOnce<B>>)f, bf);
        }

        @Override
        public <B> Transformed<B> flatten(Function1<B, GenTraversableOnce<B>> asTraversable) {
            return ((TraversableViewLike)this).flatten(asTraversable);
        }

        @Override
        public <B> Transformed<B> newForced(Function0<GenSeq<B>> xs) {
            return ((TraversableViewLike)this).newForced(xs);
        }

        @Override
        public <B> Transformed<B> newAppended(GenTraversable<B> that) {
            return ((TraversableViewLike)this).newAppended(that);
        }

        @Override
        public <B> Transformed<B> newPrepended(GenTraversable<B> that) {
            return ((TraversableViewLike)this).newPrepended(that);
        }

        @Override
        public <B> Transformed<B> newMapped(Function1<B, B> f) {
            return ((TraversableViewLike)this).newMapped(f);
        }

        @Override
        public <B> Transformed<B> newFlatMapped(Function1<B, GenTraversableOnce<B>> f) {
            return ((TraversableViewLike)this).newFlatMapped(f);
        }

        @Override
        public Transformed<B> newFiltered(Function1<B, Object> p) {
            return ((TraversableViewLike)this).newFiltered(p);
        }

        @Override
        public Transformed<B> newSliced(SliceInterval _endpoints) {
            return ((TraversableViewLike)this).newSliced(_endpoints);
        }

        @Override
        public Transformed<B> newDroppedWhile(Function1<B, Object> p) {
            return ((TraversableViewLike)this).newDroppedWhile(p);
        }

        @Override
        public Transformed<B> newTakenWhile(Function1<B, Object> p) {
            return ((TraversableViewLike)this).newTakenWhile(p);
        }

        @Override
        public Transformed<B> newTaken(int n) {
            return ((TraversableViewLike)this).newTaken(n);
        }

        @Override
        public Transformed<B> newDropped(int n) {
            return ((TraversableViewLike)this).newDropped(n);
        }

        @Override
        public TraversableView<B, Coll> filter(Function1<B, Object> p) {
            return ((TraversableViewLike)this).filter(p);
        }

        @Override
        public TraversableView<B, Coll> withFilter(Function1<B, Object> p) {
            return ((TraversableViewLike)this).withFilter(p);
        }

        @Override
        public Tuple2<TraversableView<B, Coll>, TraversableView<B, Coll>> partition(Function1<B, Object> p) {
            return ((TraversableViewLike)this).partition(p);
        }

        @Override
        public TraversableView<B, Coll> init() {
            return ((TraversableViewLike)this).init();
        }

        @Override
        public TraversableView<B, Coll> drop(int n) {
            return ((TraversableViewLike)this).drop(n);
        }

        @Override
        public TraversableView<B, Coll> take(int n) {
            return ((TraversableViewLike)this).take(n);
        }

        @Override
        public TraversableView<B, Coll> slice(int from, int until) {
            return ((TraversableViewLike)this).slice(from, until);
        }

        @Override
        public TraversableView<B, Coll> dropWhile(Function1<B, Object> p) {
            return ((TraversableViewLike)this).dropWhile(p);
        }

        @Override
        public TraversableView<B, Coll> takeWhile(Function1<B, Object> p) {
            return ((TraversableViewLike)this).takeWhile(p);
        }

        @Override
        public Tuple2<TraversableView<B, Coll>, TraversableView<B, Coll>> span(Function1<B, Object> p) {
            return ((TraversableViewLike)this).span(p);
        }

        @Override
        public Tuple2<TraversableView<B, Coll>, TraversableView<B, Coll>> splitAt(int n) {
            return ((TraversableViewLike)this).splitAt(n);
        }

        @Override
        public <B, That> That scanLeft(B z, Function2<B, B, B> op, CanBuildFrom<TraversableView<B, Coll>, B, That> bf) {
            return (That)((TraversableViewLike)this).scanLeft((B)z, (Function2<B, A, B>)op, bf);
        }

        @Override
        public <B, That> That scanRight(B z, Function2<B, B, B> op, CanBuildFrom<TraversableView<B, Coll>, B, That> bf) {
            return (That)((TraversableViewLike)this).scanRight((B)z, (Function2<A, B, B>)op, bf);
        }

        @Override
        public <K> Map<K, TraversableView<B, Coll>> groupBy(Function1<B, K> f) {
            return ((TraversableViewLike)this).groupBy(f);
        }

        @Override
        public <A1, A2> Tuple2<Transformed<A1>, Transformed<A2>> unzip(Function1<B, Tuple2<A1, A2>> asPair) {
            return ((TraversableViewLike)this).unzip(asPair);
        }

        @Override
        public <A1, A2, A3> Tuple3<Transformed<A1>, Transformed<A2>, Transformed<A3>> unzip3(Function1<B, Tuple3<A1, A2, A3>> asTriple) {
            return ((TraversableViewLike)this).unzip3(asTriple);
        }

        @Override
        public TraversableView<B, Coll> filterNot(Function1<B, Object> p) {
            return ((TraversableViewLike)this).filterNot(p);
        }

        @Override
        public Iterator<TraversableView<B, Coll>> inits() {
            return ((TraversableViewLike)this).inits();
        }

        @Override
        public Iterator<TraversableView<B, Coll>> tails() {
            return ((TraversableViewLike)this).tails();
        }

        @Override
        public TraversableView<B, Coll> tail() {
            return ((TraversableViewLike)this).tail();
        }

        @Override
        public Seq<B> thisSeq() {
            return ViewMkString.thisSeq$(this);
        }

        @Override
        public String mkString() {
            return ViewMkString.mkString$(this);
        }

        @Override
        public String mkString(String sep) {
            return ViewMkString.mkString$(this, sep);
        }

        @Override
        public String mkString(String start, String sep, String end) {
            return ViewMkString.mkString$(this, start, sep, end);
        }

        @Override
        public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
            return ViewMkString.addString$(this, b, start, sep, end);
        }

        @Override
        public GenericCompanion<Traversable> companion() {
            return Traversable.companion$(this);
        }

        @Override
        public Traversable<B> seq() {
            return Traversable.seq$(this);
        }

        @Override
        public <B> Builder<B, Traversable<B>> genericBuilder() {
            return GenericTraversableTemplate.genericBuilder$(this);
        }

        @Override
        public GenTraversable transpose(Function1 asTraversable) {
            return GenericTraversableTemplate.transpose$(this, asTraversable);
        }

        @Override
        public Object repr() {
            return TraversableLike.repr$(this);
        }

        @Override
        public final boolean isTraversableAgain() {
            return TraversableLike.isTraversableAgain$(this);
        }

        @Override
        public Traversable<B> thisCollection() {
            return TraversableLike.thisCollection$(this);
        }

        @Override
        public Traversable toCollection(Object repr) {
            return TraversableLike.toCollection$(this, repr);
        }

        @Override
        public Combiner<B, ParIterable<B>> parCombiner() {
            return TraversableLike.parCombiner$(this);
        }

        @Override
        public boolean isEmpty() {
            return TraversableLike.isEmpty$(this);
        }

        @Override
        public boolean hasDefiniteSize() {
            return TraversableLike.hasDefiniteSize$(this);
        }

        @Override
        public Object filterImpl(Function1 p, boolean isFlipped) {
            return TraversableLike.filterImpl$(this, p, isFlipped);
        }

        @Override
        public boolean forall(Function1<B, Object> p) {
            return TraversableLike.forall$(this, p);
        }

        @Override
        public boolean exists(Function1<B, Object> p) {
            return TraversableLike.exists$(this, p);
        }

        @Override
        public Option<B> find(Function1<B, Object> p) {
            return TraversableLike.find$(this, p);
        }

        @Override
        public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<TraversableView<B, Coll>, B, That> cbf) {
            return (That)TraversableLike.scan$(this, z, op, cbf);
        }

        @Override
        public B head() {
            return (B)TraversableLike.head$(this);
        }

        @Override
        public Object sliceWithKnownDelta(int from, int until, int delta) {
            return TraversableLike.sliceWithKnownDelta$(this, from, until, delta);
        }

        @Override
        public Object sliceWithKnownBound(int from, int until) {
            return TraversableLike.sliceWithKnownBound$(this, from, until);
        }

        @Override
        public <B> void copyToArray(Object xs, int start, int len) {
            TraversableLike.copyToArray$(this, xs, start, len);
        }

        @Override
        public Traversable<B> toTraversable() {
            return TraversableLike.toTraversable$(this);
        }

        @Override
        public Iterator<B> toIterator() {
            return TraversableLike.toIterator$(this);
        }

        @Override
        public Stream<B> toStream() {
            return TraversableLike.toStream$(this);
        }

        @Override
        public <Col> Col to(CanBuildFrom<Nothing$, B, Col> cbf) {
            return (Col)TraversableLike.to$(this, cbf);
        }

        @Override
        public TraversableView<B, TraversableView<B, Coll>> view() {
            return TraversableLike.view$(this);
        }

        @Override
        public TraversableView<B, TraversableView<B, Coll>> view(int from, int until) {
            return TraversableLike.view$(this, from, until);
        }

        @Override
        public Parallel par() {
            return Parallelizable.par$(this);
        }

        @Override
        public List<B> reversed() {
            return TraversableOnce.reversed$(this);
        }

        @Override
        public int size() {
            return TraversableOnce.size$(this);
        }

        @Override
        public boolean nonEmpty() {
            return TraversableOnce.nonEmpty$(this);
        }

        @Override
        public int count(Function1<B, Object> p) {
            return TraversableOnce.count$(this, p);
        }

        @Override
        public <B> Option<B> collectFirst(PartialFunction<B, B> pf) {
            return TraversableOnce.collectFirst$(this, pf);
        }

        @Override
        public <B> B $div$colon(B z, Function2<B, B, B> op) {
            return (B)TraversableOnce.$div$colon$(this, z, op);
        }

        @Override
        public <B> B $colon$bslash(B z, Function2<B, B, B> op) {
            return (B)TraversableOnce.$colon$bslash$(this, z, op);
        }

        @Override
        public <B> B foldLeft(B z, Function2<B, B, B> op) {
            return (B)TraversableOnce.foldLeft$(this, z, op);
        }

        @Override
        public <B> B foldRight(B z, Function2<B, B, B> op) {
            return (B)TraversableOnce.foldRight$(this, z, op);
        }

        @Override
        public <B> B reduceLeft(Function2<B, B, B> op) {
            return (B)TraversableOnce.reduceLeft$(this, op);
        }

        @Override
        public <B> B reduceRight(Function2<B, B, B> op) {
            return (B)TraversableOnce.reduceRight$(this, op);
        }

        @Override
        public <B> Option<B> reduceLeftOption(Function2<B, B, B> op) {
            return TraversableOnce.reduceLeftOption$(this, op);
        }

        @Override
        public <B> Option<B> reduceRightOption(Function2<B, B, B> op) {
            return TraversableOnce.reduceRightOption$(this, op);
        }

        @Override
        public <A1> A1 reduce(Function2<A1, A1, A1> op) {
            return (A1)TraversableOnce.reduce$(this, op);
        }

        @Override
        public <A1> Option<A1> reduceOption(Function2<A1, A1, A1> op) {
            return TraversableOnce.reduceOption$(this, op);
        }

        @Override
        public <A1> A1 fold(A1 z, Function2<A1, A1, A1> op) {
            return (A1)TraversableOnce.fold$(this, z, op);
        }

        @Override
        public <B> B aggregate(Function0<B> z, Function2<B, B, B> seqop, Function2<B, B, B> combop) {
            return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
        }

        @Override
        public <B> B sum(Numeric<B> num) {
            return (B)TraversableOnce.sum$(this, num);
        }

        @Override
        public <B> B product(Numeric<B> num) {
            return (B)TraversableOnce.product$(this, num);
        }

        @Override
        public <B> B min(Ordering<B> cmp) {
            return (B)TraversableOnce.min$(this, cmp);
        }

        @Override
        public <B> B max(Ordering<B> cmp) {
            return (B)TraversableOnce.max$(this, cmp);
        }

        @Override
        public <B> B maxBy(Function1<B, B> f, Ordering<B> cmp) {
            return (B)TraversableOnce.maxBy$(this, f, cmp);
        }

        @Override
        public <B> B minBy(Function1<B, B> f, Ordering<B> cmp) {
            return (B)TraversableOnce.minBy$(this, f, cmp);
        }

        @Override
        public <B> void copyToBuffer(Buffer<B> dest) {
            TraversableOnce.copyToBuffer$(this, dest);
        }

        @Override
        public <B> void copyToArray(Object xs, int start) {
            TraversableOnce.copyToArray$(this, xs, start);
        }

        @Override
        public <B> void copyToArray(Object xs) {
            TraversableOnce.copyToArray$(this, xs);
        }

        @Override
        public <B> Object toArray(ClassTag<B> evidence$1) {
            return TraversableOnce.toArray$(this, evidence$1);
        }

        @Override
        public List<B> toList() {
            return TraversableOnce.toList$(this);
        }

        @Override
        public Iterable<B> toIterable() {
            return TraversableOnce.toIterable$(this);
        }

        @Override
        public Seq<B> toSeq() {
            return TraversableOnce.toSeq$(this);
        }

        @Override
        public IndexedSeq<B> toIndexedSeq() {
            return TraversableOnce.toIndexedSeq$(this);
        }

        @Override
        public <B> Buffer<B> toBuffer() {
            return TraversableOnce.toBuffer$(this);
        }

        @Override
        public <B> Set<B> toSet() {
            return TraversableOnce.toSet$(this);
        }

        @Override
        public Vector<B> toVector() {
            return TraversableOnce.toVector$(this);
        }

        @Override
        public <T, U> Map<T, U> toMap(Predef$.less.colon.less<B, Tuple2<T, U>> ev) {
            return TraversableOnce.toMap$(this, ev);
        }

        @Override
        public StringBuilder addString(StringBuilder b, String sep) {
            return TraversableOnce.addString$(this, b, sep);
        }

        @Override
        public StringBuilder addString(StringBuilder b) {
            return TraversableOnce.addString$(this, b);
        }

        @Override
        public int sizeHintIfCheap() {
            return GenTraversableOnce.sizeHintIfCheap$(this);
        }

        private Coll underlying$lzycompute() {
            synchronized (this) {
                if (!this.bitmap$0) {
                    this.underlying = ((Transformed)this).underlying();
                    this.bitmap$0 = true;
                }
            }
            return this.underlying;
        }

        @Override
        public Coll underlying() {
            if (!this.bitmap$0) {
                return this.underlying$lzycompute();
            }
            return this.underlying;
        }

        public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$AbstractTransformed$$$outer() {
            return TraversableViewLike.this;
        }

        @Override
        public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Transformed$$$outer() {
            return this.scala$collection$TraversableViewLike$AbstractTransformed$$$outer();
        }

        public AbstractTransformed() {
            if (TraversableViewLike.this == null) {
                throw null;
            }
            GenTraversableOnce.$init$(this);
            TraversableOnce.$init$(this);
            Parallelizable.$init$(this);
            TraversableLike.$init$(this);
            GenericTraversableTemplate.$init$(this);
            GenTraversable.$init$(this);
            Traversable.$init$(this);
            ViewMkString.$init$(this);
            TraversableViewLike.$init$(this);
            Transformed.$init$(this);
        }
    }

    public interface Appended<B>
    extends Transformed<B> {
        public GenTraversable<B> rest();

        public static /* synthetic */ void foreach$(Appended $this, Function1 f) {
            $this.foreach(f);
        }

        @Override
        default public <U> void foreach(Function1<B, U> f) {
            this.scala$collection$TraversableViewLike$Appended$$$outer().foreach(f);
            this.rest().foreach(f);
        }

        public static /* synthetic */ String viewIdentifier$(Appended $this) {
            return $this.viewIdentifier();
        }

        @Override
        default public String viewIdentifier() {
            return "A";
        }

        public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Appended$$$outer();

        public static void $init$(Appended $this) {
        }
    }

    public interface DroppedWhile
    extends Transformed<A> {
        public Function1<A, Object> pred();

        public static /* synthetic */ void foreach$(DroppedWhile $this, Function1 f) {
            $this.foreach(f);
        }

        @Override
        default public <U> void foreach(Function1<A, U> f) {
            BooleanRef go = BooleanRef.create(false);
            this.scala$collection$TraversableViewLike$DroppedWhile$$$outer().foreach((Function1<Object, Object> & java.io.Serializable & Serializable)(A x) -> {
                if (!go$1.elem && !BoxesRunTime.unboxToBoolean(this.pred().apply(x))) {
                    go$1.elem = true;
                }
                if (go$1.elem) {
                    return f.apply(x);
                }
                return BoxedUnit.UNIT;
            });
        }

        public static /* synthetic */ String viewIdentifier$(DroppedWhile $this) {
            return $this.viewIdentifier();
        }

        @Override
        default public String viewIdentifier() {
            return "D";
        }

        public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$DroppedWhile$$$outer();

        public static void $init$(DroppedWhile $this) {
        }
    }

    public interface EmptyView
    extends Transformed<Nothing$> {
        public static /* synthetic */ boolean isEmpty$(EmptyView $this) {
            return $this.isEmpty();
        }

        @Override
        default public boolean isEmpty() {
            return true;
        }

        public static /* synthetic */ void foreach$(EmptyView $this, Function1 f) {
            $this.foreach(f);
        }

        @Override
        default public <U> void foreach(Function1<Nothing$, U> f) {
        }

        public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$EmptyView$$$outer();

        public static void $init$(EmptyView $this) {
        }
    }

    public interface Filtered
    extends Transformed<A> {
        public Function1<A, Object> pred();

        public static /* synthetic */ void foreach$(Filtered $this, Function1 f) {
            $this.foreach(f);
        }

        @Override
        default public <U> void foreach(Function1<A, U> f) {
            this.scala$collection$TraversableViewLike$Filtered$$$outer().foreach((Function1<Object, Object> & java.io.Serializable & Serializable)(A x) -> {
                if (BoxesRunTime.unboxToBoolean(this.pred().apply(x))) {
                    return f.apply(x);
                }
                return BoxedUnit.UNIT;
            });
        }

        public static /* synthetic */ String viewIdentifier$(Filtered $this) {
            return $this.viewIdentifier();
        }

        @Override
        default public String viewIdentifier() {
            return "F";
        }

        public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Filtered$$$outer();

        public static void $init$(Filtered $this) {
        }
    }

    public interface FlatMapped<B>
    extends Transformed<B> {
        public Function1<A, GenTraversableOnce<B>> mapping();

        public static /* synthetic */ void foreach$(FlatMapped $this, Function1 f) {
            $this.foreach(f);
        }

        @Override
        default public <U> void foreach(Function1<B, U> f) {
            this.scala$collection$TraversableViewLike$FlatMapped$$$outer().foreach((Function1<Object, Object> & java.io.Serializable & Serializable)(A x) -> {
                this.mapping().apply(x).seq().foreach((Function1<Object, Object> & java.io.Serializable & Serializable)(A y) -> f.apply(y));
                return BoxedUnit.UNIT;
            });
        }

        public static /* synthetic */ String viewIdentifier$(FlatMapped $this) {
            return $this.viewIdentifier();
        }

        @Override
        default public String viewIdentifier() {
            return "N";
        }

        public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$FlatMapped$$$outer();

        public static /* synthetic */ void $anonfun$foreach$3(FlatMapped $this, Function1 f$3, Object x) {
            $this.mapping().apply(x).seq().foreach((Function1<Object, Object> & java.io.Serializable & Serializable)(A y) -> f.apply(y));
        }

        public static void $init$(FlatMapped $this) {
        }
    }

    public interface Forced<B>
    extends Transformed<B> {
        public GenSeq<B> forced();

        public static /* synthetic */ void foreach$(Forced $this, Function1 f) {
            $this.foreach(f);
        }

        @Override
        default public <U> void foreach(Function1<B, U> f) {
            this.forced().foreach(f);
        }

        public static /* synthetic */ String viewIdentifier$(Forced $this) {
            return $this.viewIdentifier();
        }

        @Override
        default public String viewIdentifier() {
            return "C";
        }

        public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Forced$$$outer();

        public static void $init$(Forced $this) {
        }
    }

    public interface Mapped<B>
    extends Transformed<B> {
        public Function1<A, B> mapping();

        public static /* synthetic */ void foreach$(Mapped $this, Function1 f) {
            $this.foreach(f);
        }

        @Override
        default public <U> void foreach(Function1<B, U> f) {
            this.scala$collection$TraversableViewLike$Mapped$$$outer().foreach((Function1<Object, Object> & java.io.Serializable & Serializable)(A x) -> f.apply(this.mapping().apply(x)));
        }

        public static /* synthetic */ String viewIdentifier$(Mapped $this) {
            return $this.viewIdentifier();
        }

        @Override
        default public String viewIdentifier() {
            return "M";
        }

        public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Mapped$$$outer();

        public static void $init$(Mapped $this) {
        }
    }

    public interface Prepended<B>
    extends Transformed<B> {
        public GenTraversable<B> fst();

        public static /* synthetic */ void foreach$(Prepended $this, Function1 f) {
            $this.foreach(f);
        }

        @Override
        default public <U> void foreach(Function1<B, U> f) {
            this.fst().foreach(f);
            this.scala$collection$TraversableViewLike$Prepended$$$outer().foreach(f);
        }

        public static /* synthetic */ String viewIdentifier$(Prepended $this) {
            return $this.viewIdentifier();
        }

        @Override
        default public String viewIdentifier() {
            return "A";
        }

        public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Prepended$$$outer();

        public static void $init$(Prepended $this) {
        }
    }

    public interface Sliced
    extends Transformed<A> {
        public SliceInterval endpoints();

        public static /* synthetic */ int from$(Sliced $this) {
            return $this.from();
        }

        default public int from() {
            return this.endpoints().from();
        }

        public static /* synthetic */ int until$(Sliced $this) {
            return $this.until();
        }

        default public int until() {
            return this.endpoints().until();
        }

        public static /* synthetic */ void foreach$(Sliced $this, Function1 f) {
            $this.foreach(f);
        }

        @Override
        default public <U> void foreach(Function1<A, U> f) {
            Object object = new Object();
            try {
                IntRef index = IntRef.create(0);
                this.scala$collection$TraversableViewLike$Sliced$$$outer().foreach((Function1<Object, Object> & java.io.Serializable & Serializable)(A x) -> {
                    Sliced.$anonfun$foreach$1(this, index, object, f, x);
                    return BoxedUnit.UNIT;
                });
                return;
            }
            catch (NonLocalReturnControl ex) {
                if (ex.key() == object) {
                    ex.value$mcV$sp();
                    return;
                }
                throw ex;
            }
        }

        public static /* synthetic */ String viewIdentifier$(Sliced $this) {
            return $this.viewIdentifier();
        }

        @Override
        default public String viewIdentifier() {
            return "S";
        }

        public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Sliced$$$outer();

        public static /* synthetic */ void $anonfun$foreach$1(Sliced $this, IntRef index$1, Object nonLocalReturnKey2$1, Function1 f$1, Object x) {
            if ($this.from() <= index$1.elem) {
                if ($this.until() <= index$1.elem) {
                    throw new NonLocalReturnControl$mcV$sp(nonLocalReturnKey2$1, BoxedUnit.UNIT);
                }
                f$1.apply(x);
            }
            ++index$1.elem;
        }

        public static void $init$(Sliced $this) {
        }
    }

    public interface TakenWhile
    extends Transformed<A> {
        public Function1<A, Object> pred();

        public static /* synthetic */ void foreach$(TakenWhile $this, Function1 f) {
            $this.foreach(f);
        }

        @Override
        default public <U> void foreach(Function1<A, U> f) {
            Object object = new Object();
            try {
                this.scala$collection$TraversableViewLike$TakenWhile$$$outer().foreach((Function1<Object, Object> & java.io.Serializable & Serializable)(A x) -> {
                    if (!BoxesRunTime.unboxToBoolean(this.pred().apply(x))) {
                        throw new NonLocalReturnControl$mcV$sp(object, BoxedUnit.UNIT);
                    }
                    return f.apply(x);
                });
                return;
            }
            catch (NonLocalReturnControl ex) {
                if (ex.key() == object) {
                    ex.value$mcV$sp();
                    return;
                }
                throw ex;
            }
        }

        public static /* synthetic */ String viewIdentifier$(TakenWhile $this) {
            return $this.viewIdentifier();
        }

        @Override
        default public String viewIdentifier() {
            return "T";
        }

        public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$TakenWhile$$$outer();

        public static void $init$(TakenWhile $this) {
        }
    }

    public interface Transformed<B>
    extends TraversableView<B, Coll> {
        @Override
        public <U> void foreach(Function1<B, U> var1);

        @Override
        default public Coll underlying() {
            return this.scala$collection$TraversableViewLike$Transformed$$$outer().underlying();
        }

        @Override
        default public String viewIdString() {
            return new java.lang.StringBuilder(0).append(this.scala$collection$TraversableViewLike$Transformed$$$outer().viewIdString()).append(this.viewIdentifier()).toString();
        }

        @Override
        default public Option<B> headOption() {
            Object object = new Object();
            try {
                this.foreach((Function1)(Function1<Object, Nothing$> & java.io.Serializable & Serializable)x -> {
                    throw new NonLocalReturnControl<Some<Object>>(object, new Some<Object>(x));
                });
                return None$.MODULE$;
            }
            catch (NonLocalReturnControl ex) {
                if (ex.key() == object) {
                    return (Option)ex.value();
                }
                throw ex;
            }
        }

        @Override
        default public B last() {
            BooleanRef empty = BooleanRef.create(true);
            ObjectRef<Object> result2 = ObjectRef.create(null);
            this.foreach((Function1)(Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
                Transformed.$anonfun$last$1(empty, result2, x);
                return BoxedUnit.UNIT;
            });
            if (empty.elem) {
                throw new NoSuchElementException("last of empty traversable");
            }
            return (B)result2.elem;
        }

        @Override
        default public Option<B> lastOption() {
            BooleanRef empty = BooleanRef.create(true);
            ObjectRef<Object> result2 = ObjectRef.create(null);
            this.foreach((Function1)(Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
                Transformed.$anonfun$lastOption$1(empty, result2, x);
                return BoxedUnit.UNIT;
            });
            if (empty.elem) {
                return None$.MODULE$;
            }
            return new Some(result2.elem);
        }

        @Override
        default public String stringPrefix() {
            return this.scala$collection$TraversableViewLike$Transformed$$$outer().stringPrefix();
        }

        @Override
        default public String toString() {
            return this.viewToString();
        }

        public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Transformed$$$outer();

        public static /* synthetic */ void $anonfun$last$1(BooleanRef empty$1, ObjectRef result$1, Object x) {
            empty$1.elem = false;
            result$1.elem = x;
        }

        public static /* synthetic */ void $anonfun$lastOption$1(BooleanRef empty$2, ObjectRef result$2, Object x) {
            empty$2.elem = false;
            result$2.elem = x;
        }

        public static void $init$(Transformed $this) {
        }
    }
}

