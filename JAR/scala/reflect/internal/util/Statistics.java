/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.MatchError;
import scala.Option;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.Tuple2$mcII$sp;
import scala.Tuple2$mcJJ$sp;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.MapLike;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.Set;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Range;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.HashMap;
import scala.collection.mutable.Iterable$;
import scala.collection.mutable.ListBuffer;
import scala.collection.mutable.Map;
import scala.collection.mutable.SynchronizedMap;
import scala.math.Ordered;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.Reporter;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.settings.MutableSettings;
import scala.reflect.internal.util.NoPosition$;
import scala.reflect.internal.util.StatisticsStatics;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.LongRef;
import scala.runtime.RichInt$;
import scala.runtime.Statics;

@ScalaSignature(bytes="\u0006\u0001\u0011}h\u0001CA\u0010\u0003C\t\t!a\r\t\u0015\u0005u\u0002A!b\u0001\n\u0003\ty\u0004\u0003\u0006\u0002J\u0001\u0011\t\u0011)A\u0005\u0003\u0003B!\"a\u0013\u0001\u0005\u0003\u0005\u000b\u0011BA'\u0011\u001d\t9\u0006\u0001C\u0001\u00033Bq!a\u0019\u0001\t\u0003\t)'\u0002\u0004\u0002r\u0001\u0001\u00111\u000f\u0005\b\u0003\u007f\u0002AQAAA\u0011\u001d\ty\b\u0001C\u0003\u0005\u0007Bq!a \u0001\t\u000b\u0011i\u0005C\u0004\u00032\u0002!)Aa-\t\u000f\t}\u0007\u0001\"\u0002\u0003b\"9!\u0011\u001e\u0001\u0005\u0006\t-\bbBB*\u0001\u0011\u00151Q\u000b\u0005\b\u0007;\u0002AQAB0\u0011\u001d\u0019I\r\u0001C\u0003\u0007\u0017Dqaa5\u0001\t\u0003\u0019)\u000eC\u0004\u0004b\u0002!\taa9\t\u000f\r-\b\u0001\"\u0001\u0004n\"911\u001f\u0001\u0005\u0002\rU\bbBB~\u0001\u0011\u00051Q \u0005\b\t\u0007\u0001A\u0011\u0001C\u0003\u0011\u001d!Y\u0001\u0001C\u0001\t\u001bAq\u0001\"\u000b\u0001\t\u0003!Y\u0003C\u0004\u0005N\u0001!\t\u0001b\u0014\t\u000f\u0011m\u0004\u0001\"\u0001\u0004l!9AQ\u0010\u0001\u0005\u0002\u0011}\u0004b\u0002CD\u0001\u0011%A\u0011\u0012\u0004\n\u0003#\u0003\u0001\u0013aA\u0001\u0003'Cq!!&\u001d\t\u0003\t9\nC\u0005\u0002\u001ar\u0011\rQ\"\u0001\u0002\u001c\"I\u00111\u0017\u000fC\u0002\u001b\u0005\u0011Q\u0017\u0005\b\u0003\u000bdB\u0011AAd\u0011\u001d\tI\r\bC\u0001\u0003\u0017Dq!a6\u001d\t\u0003\tY\nC\u0005\u0002Zr\u0011\r\u0011\"\u0001\u0002\\\u001aI!1\u0019\u0001\u0011\u0002\u0007\u0005!Q\u0019\u0005\b\u0003+#C\u0011AAL\u0011\u001d\t)\r\nD\t\u0003\u000f4a!a#\u0001\u0001\u00055\u0005BCAMO\t\u0015\r\u0011\"\u0001\u0002\u001c\"Q\u00111_\u0014\u0003\u0002\u0003\u0006I!!(\t\u0015\u0005MvE!b\u0001\n\u0003\t)\f\u0003\u0006\u0002v\u001e\u0012\t\u0011)A\u0005\u0003oCq!a\u0016(\t\u0003\t9\u0010C\u0005\u0002~\u001e\u0002\r\u0011\"\u0001\u0002\u0000\"I!qA\u0014A\u0002\u0013\u0005!\u0011\u0002\u0005\t\u0005\u001f9\u0003\u0015)\u0003\u0003\u0002!9!\u0011C\u0014\u0005\u0002\tM\u0001b\u0002B\rO\u0011\u0005#1\u0004\u0005\b\u0005K9C\u0011\tB\u0014\u0011\u001d\u0011Ic\nC!\u0005W1a\u0001b\u0005\u0001\u0001\u0011U\u0001BCAMi\t\u0015\r\u0011\"\u0001\u0002\u001c\"Q\u00111\u001f\u001b\u0003\u0002\u0003\u0006I!!(\t\u0015\u0005MFG!b\u0001\n\u0003\t)\f\u0003\u0006\u0002vR\u0012\t\u0011)A\u0005\u0003oC!\u0002b\u00065\u0005\u0003%\u000b\u0011\u0002C\r\u0011\u001d\t9\u0006\u000eC\u0001\t7AqA!\u000b5\t\u0003\u0012YC\u0002\u0004\u0005\u0014\u0002!AQ\u0013\u0005\f\u00033c$\u0011!Q\u0001\n\u0005u\u0005\u0006\u0003\u0006\u0002Fr\u0012)\u0019!C!\u0005\u000fD!B!3=\u0005\u0003\u0005\u000b\u0011BAD\u0011\u001d\t9\u0006\u0010C\u0001\t/CqA!\u000b=\t\u0003\u0012Y\u0003C\u0007\u0005 r\u0002\n1!A\u0001\n\u0013\tY\n\u000b\u0004\u0007\u0005{\u0003\u0001Aa0\t\u0017\u0005e5I!A!\u0002\u0013\ti\n\u000b\u0005\u000b\u0003\u000b\u001c%Q1A\u0005B\t\u001d\u0007B\u0003Be\u0007\n\u0005\t\u0015!\u0003\u0002\b\"9\u0011qK\"\u0005\u0002\t-\u0007b\u0002Bi\u0007\u0012\u0005!1\u001b\u0005\b\u0005+\u001cE\u0011\u0001Bl\u0011\u001d\u0011Ic\u0011C!\u0005O3aA!>\u0001\u0001\t]\bBCAM\u0017\n\u0015\r\u0011\"\u0001\u0002\u001c\"Q\u00111_&\u0003\u0002\u0003\u0006I!!(\t\u0015\u0005M6J!b\u0001\n\u0003\t)\f\u0003\u0006\u0002v.\u0013\t\u0011)A\u0005\u0003oCq!a\u0016L\t\u0003\u0011I\u0010C\u0005\u0003\u0000.\u0013\r\u0011\"\u0003\u0004\u0002!A1QC&!\u0002\u0013\u0019\u0019\u0001C\u0005\u0004\u0018-\u0013\r\u0011\"\u0003\u0004\u001a!A1QF&!\u0002\u0013\u0019Y\u0002C\u0006\u00040-\u0013\r\u0011\"\u0001\u0002\"\rE\u0002\u0002CB\u001d\u0017\u0002\u0006Iaa\r\t\u0017\rm2J1A\u0005\u0002\u0005\u00052\u0011\u0001\u0005\t\u0007{Y\u0005\u0015!\u0003\u0004\u0004!91qH&\u0005\u0002\r\u0005\u0003b\u0002Bi\u0017\u0012\u000511\t\u0005\b\u0005+\\E\u0011AB#\u0011\u001d\u0019Ie\u0013C\t\u0007\u0017BqA!\u000bL\t\u0003\u00129K\u0002\u0004\u0004\u0002\u0002\u000111\u0011\u0005\f\u00033s&\u0011!Q\u0001\n\u0005uE\n\u0003\u0006\u0002Fz\u0013)\u0019!C!\u0007\u000bC!B!3_\u0005\u0003\u0005\u000b\u0011\u0002Bz\u0011\u001d\t9F\u0018C\u0001\u0007\u000fCqa!\u0013_\t#\u001aiI\u0002\u0004\u0004|\u0001\u00011Q\u0010\u0005\f\u00033#'\u0011!Q\u0001\n\u0005uE\nC\u0006\u0002F\u0012\u0014\t\u0011)A\u0005\u0005g\u0004\u0007bBA,I\u0012\u000511\u0013\u0005\n\u00073#\u0007\u0019!C\u0001\u0007\u0003B\u0011ba'e\u0001\u0004%\ta!(\t\u0011\r\u0005F\r)Q\u0005\u0003sBqA!\u0005e\t\u0003\u0019\u0019\u000bC\u0004\u0003\u001a\u0011$\tea*\t\u000f\t\u0015B\r\"\u0011\u0003(!9!\u0011\u00063\u0005B\t\u001dfA\u0002B,\u0001\u0001\u0011I\u0006\u0003\u0006\u0002\u001a>\u0014)\u0019!C\u0001\u00037C!\"a=p\u0005\u0003\u0005\u000b\u0011BAO\u0011)\t\u0019l\u001cBC\u0002\u0013\u0005\u0011Q\u0017\u0005\u000b\u0003k|'\u0011!Q\u0001\n\u0005]\u0006B\u0003B@_\n\u0005I\u0015!\u0003\u0003\u0002\"Q!qQ8\u0003\u0004\u0003\u0006YA!#\t\u000f\u0005]s\u000e\"\u0001\u0003\u0012\"9!qT8\u0005B\t\u0005\u0006b\u0002B\u0015_\u0012\u0005#q\u0015\u0004\u0007\u0007O\u0002\u0001a!\u001b\t\u000f\u0005]\u0013\u0010\"\u0001\u0004l!I1QN=A\u0002\u0013%1q\u000e\u0005\n\u0007WK\b\u0019!C\u0005\u0007[C\u0001b!-zA\u0003&1\u0011\u000f\u0005\b\u0007gKH\u0011AB[\u0011\u001d\u0019Y,\u001fC\u0001\u0007{C\u0011\u0002\")\u0001\u0005\u0004%I\u0001b)\t\u0011\u0011\u001d\u0006\u0001)A\u0005\tKC1\u0002\"+\u0001\u0001\u0004%\t!!\f\u0005,\"YAQ\u0016\u0001A\u0002\u0013\u0005\u0011Q\u0006CX\u0011!!\u0019\f\u0001Q!\n\u00055\u0007b\u0003C[\u0001\u0001\u0007I\u0011AA\u0017\tWC1\u0002b.\u0001\u0001\u0004%\t!!\f\u0005:\"AAQ\u0018\u0001!B\u0013\ti\rC\u0004\u0005@\u0002!)\u0001b+\t\u000f\u0011\r\u0007\u0001\"\u0001\u0005F\"9A1\u001a\u0001\u0005\u0006\u0011-\u0006b\u0002Ch\u0001\u0011\u0005A\u0011\u001b\u0005\b\t+\u0004AQ\u0001CV\u0011\u001d!I\u000e\u0001C\u0003\t7Dq\u0001b:\u0001\t\u000b!IO\u0001\u0006Ti\u0006$\u0018n\u001d;jGNTA!a\t\u0002&\u0005!Q\u000f^5m\u0015\u0011\t9#!\u000b\u0002\u0011%tG/\u001a:oC2TA!a\u000b\u0002.\u00059!/\u001a4mK\u000e$(BAA\u0018\u0003\u0015\u00198-\u00197b\u0007\u0001\u00192\u0001AA\u001b!\u0011\t9$!\u000f\u000e\u0005\u00055\u0012\u0002BA\u001e\u0003[\u0011a!\u00118z%\u00164\u0017aC:z[\n|G\u000eV1cY\u0016,\"!!\u0011\u0011\t\u0005\r\u0013QI\u0007\u0003\u0003KIA!a\u0012\u0002&\tY1+_7c_2$\u0016M\u00197f\u00031\u0019\u00180\u001c2pYR\u000b'\r\\3!\u0003!\u0019X\r\u001e;j]\u001e\u001c\b\u0003BA(\u0003'j!!!\u0015\u000b\t\u0005-\u0013QE\u0005\u0005\u0003+\n\tFA\bNkR\f'\r\\3TKR$\u0018N\\4t\u0003\u0019a\u0014N\\5u}Q1\u00111LA0\u0003C\u00022!!\u0018\u0001\u001b\t\t\t\u0003C\u0004\u0002>\u0011\u0001\r!!\u0011\t\u000f\u0005-C\u00011\u0001\u0002N\u0005\u0001\u0012N\\5u\rJ|WnU3ui&twm\u001d\u000b\u0005\u0003O\ni\u0007\u0005\u0003\u00028\u0005%\u0014\u0002BA6\u0003[\u0011A!\u00168ji\"9\u0011qN\u0003A\u0002\u00055\u0013aD2veJ,g\u000e^*fiRLgnZ:\u0003\u001bQKW.\u001a:T]\u0006\u00048\u000f[8u!!\t9$!\u001e\u0002z\u0005e\u0014\u0002BA<\u0003[\u0011a\u0001V;qY\u0016\u0014\u0004\u0003BA\u001c\u0003wJA!! \u0002.\t!Aj\u001c8h\u0003)IgnY\"pk:$XM\u001d\u000b\u0005\u0003O\n\u0019\tC\u0004\u0002\u0006\u001e\u0001\r!a\"\u0002\u0003\r\u00042!!#(\u001b\u0005\u0001!aB\"pk:$XM]\n\bO\u0005U\u0012qRAw!\r\tI\t\b\u0002\t#V\fg\u000e^5usN\u0019A$!\u000e\u0002\r\u0011Jg.\u001b;%)\t\t9'\u0001\u0004qe\u00164\u0017\u000e_\u000b\u0003\u0003;\u0003B!a(\u0002.:!\u0011\u0011UAU!\u0011\t\u0019+!\f\u000e\u0005\u0005\u0015&\u0002BAT\u0003c\ta\u0001\u0010:p_Rt\u0014\u0002BAV\u0003[\ta\u0001\u0015:fI\u00164\u0017\u0002BAX\u0003c\u0013aa\u0015;sS:<'\u0002BAV\u0003[\ta\u0001\u001d5bg\u0016\u001cXCAA\\!\u0019\tI,a0\u0002\u001e:!\u0011qGA^\u0013\u0011\ti,!\f\u0002\u000fA\f7m[1hK&!\u0011\u0011YAb\u0005\r\u0019V-\u001d\u0006\u0005\u0003{\u000bi#\u0001\u0006v]\u0012,'\u000f\\=j]\u001e,\"!a$\u0002\rMDwn^!u)\u0011\ti-a5\u0011\t\u0005]\u0012qZ\u0005\u0005\u0003#\fiCA\u0004C_>dW-\u00198\t\u000f\u0005U\u0017\u00051\u0001\u0002\u001e\u0006)\u0001\u000f[1tK\u0006!A.\u001b8f\u0003!\u0019\u0007.\u001b7ee\u0016tWCAAo!\u0019\ty.!;\u0002\u00106\u0011\u0011\u0011\u001d\u0006\u0005\u0003G\f)/A\u0004nkR\f'\r\\3\u000b\t\u0005\u001d\u0018QF\u0001\u000bG>dG.Z2uS>t\u0017\u0002BAv\u0003C\u0014!\u0002T5ti\n+hMZ3s!\u0019\tI,a<\u0002\b&!\u0011\u0011_Ab\u0005\u001dy%\u000fZ3sK\u0012\fq\u0001\u001d:fM&D\b%A\u0004qQ\u0006\u001cXm\u001d\u0011\u0015\r\u0005\u001d\u0015\u0011`A~\u0011\u001d\tI\n\fa\u0001\u0003;Cq!a--\u0001\u0004\t9,A\u0003wC2,X-\u0006\u0002\u0003\u0002A!\u0011q\u0007B\u0002\u0013\u0011\u0011)!!\f\u0003\u0007%sG/A\u0005wC2,Xm\u0018\u0013fcR!\u0011q\rB\u0006\u0011%\u0011iALA\u0001\u0002\u0004\u0011\t!A\u0002yIE\naA^1mk\u0016\u0004\u0013aB2p[B\f'/\u001a\u000b\u0005\u0005\u0003\u0011)\u0002C\u0004\u0003\u0018A\u0002\r!a\"\u0002\tQD\u0017\r^\u0001\u0007KF,\u0018\r\\:\u0015\t\u00055'Q\u0004\u0005\b\u0005/\t\u0004\u0019\u0001B\u0010!\u0011\t9D!\t\n\t\t\r\u0012Q\u0006\u0002\u0004\u0003:L\u0018\u0001\u00035bg\"\u001cu\u000eZ3\u0015\u0005\t\u0005\u0011\u0001\u0003;p'R\u0014\u0018N\\4\u0015\u0005\t5\u0002\u0003\u0002B\u0018\u0005si!A!\r\u000b\t\tM\"QG\u0001\u0005Y\u0006twM\u0003\u0002\u00038\u0005!!.\u0019<b\u0013\u0011\tyK!\r)\u0007\u001d\u0011i\u0004\u0005\u0003\u00028\t}\u0012\u0002\u0002B!\u0003[\u0011a!\u001b8mS:,GCBA4\u0005\u000b\u00129\u0005C\u0004\u0002\u0006\"\u0001\r!a\"\t\u000f\t%\u0003\u00021\u0001\u0003\u0002\u0005)A-\u001a7uC\"\u001a\u0001B!\u0010\u0016\t\t=#1\u0016\u000b\u0007\u0003O\u0012\tF!,\t\u000f\tM\u0013\u00021\u0001\u0003V\u0005!1\r\u001e:t!\u001d\tIi\u001cBU\u0003\u000f\u0013\u0001\"U;b]Rl\u0015\r]\u000b\u0007\u00057\u00129G!\u001e\u0014\u000f=\u0014iF!\u001f\u0002\u0010BA\u0011q\u001cB0\u0005G\u0012\u0019(\u0003\u0003\u0003b\u0005\u0005(a\u0002%bg\"l\u0015\r\u001d\t\u0005\u0005K\u00129\u0007\u0004\u0001\u0005\u000f\t%tN1\u0001\u0003l\t\t1*\u0005\u0003\u0003n\t}\u0001\u0003BA\u001c\u0005_JAA!\u001d\u0002.\t9aj\u001c;iS:<\u0007\u0003\u0002B3\u0005k\"qAa\u001ep\u0005\u0004\u0011YGA\u0001W!!\tyNa\u001f\u0003d\tM\u0014\u0002\u0002B?\u0003C\u0014qbU=oG\"\u0014xN\\5{K\u0012l\u0015\r]\u0001\nS:LGOV1mk\u0016\u0004b!a\u000e\u0003\u0004\nM\u0014\u0002\u0002BC\u0003[\u0011\u0001\u0002\u00102z]\u0006lWMP\u0001\u000bKZLG-\u001a8dK\u0012\u001a\u0004\u0003CA\u001c\u0005\u0017\u0013\u0019Ha$\n\t\t5\u0015Q\u0006\u0002\n\rVt7\r^5p]F\u0002b!!/\u0002p\nMD\u0003\u0003BJ\u00053\u0013YJ!(\u0015\t\tU%q\u0013\t\b\u0003\u0013{'1\rB:\u0011\u001d\u00119I\u001ea\u0002\u0005\u0013Cq!!'w\u0001\u0004\ti\nC\u0004\u00024Z\u0004\r!a.\t\u0011\t}d\u000f\"a\u0001\u0005\u0003\u000bq\u0001Z3gCVdG\u000f\u0006\u0003\u0003t\t\r\u0006b\u0002BSo\u0002\u0007!1M\u0001\u0004W\u0016LHCAAO!\u0011\u0011)Ga+\u0005\u000f\t%\u0014B1\u0001\u0003l!9!QU\u0005A\u0002\t%\u0006fA\u0005\u0003>\u0005a1\u000f^1si\u000e{WO\u001c;feR!!Q\u0017B\\!!\t9$!\u001e\u0003\u0002\t\u0005\u0001b\u0002B]\u0015\u0001\u0007!1X\u0001\u0003g\u000e\u00042!!#D\u0005)\u0019VOY\"pk:$XM]\n\u0006\u0007\u0006\u001d%\u0011\u0019\t\u0004\u0003\u0013##aC*vEF+\u0018M\u001c;jif\u001cR\u0001JA\u001b\u0003\u001f+\"!a\"\u0002\u0017UtG-\u001a:ms&tw\r\t\u000b\u0007\u0005w\u0013iMa4\t\u000f\u0005eu\t1\u0001\u0002\u001e\"9\u0011QY$A\u0002\u0005\u001d\u0015!B:uCJ$HC\u0001B[\u0003\u0011\u0019Ho\u001c9\u0015\t\u0005\u001d$\u0011\u001c\u0005\b\u00057L\u0005\u0019\u0001B[\u0003\u0011\u0001(/\u001a<)\u0007)\u0011i$A\u0006ti>\u00048i\\;oi\u0016\u0014HCBA4\u0005G\u0014)\u000fC\u0004\u0003:.\u0001\rAa/\t\u000f\tE7\u00021\u0001\u00036\"\u001a1B!\u0010\u0002\u0015M$\u0018M\u001d;US6,'\u000f\u0006\u0003\u0003n\n=\bcAAE\r!9!\u0011\u001f\u0007A\u0002\tM\u0018A\u0001;n!\r\tIi\u0013\u0002\u0006)&lWM]\n\u0006\u0017\u0006U\u0012q\u0012\u000b\u0007\u0005g\u0014YP!@\t\u000f\u0005e\u0005\u000b1\u0001\u0002\u001e\"9\u00111\u0017)A\u0002\u0005]\u0016\u0001\u0004;pi\u0006dG\u000b\u001b:fC\u0012\u001cXCAB\u0002!\u0011\u0019)a!\u0005\u000e\u0005\r\u001d!\u0002BB\u0005\u0007\u0017\ta!\u0019;p[&\u001c'\u0002BB\u0007\u0007\u001f\t!bY8oGV\u0014(/\u001a8u\u0015\u0011\t\u0019C!\u000e\n\t\rM1q\u0001\u0002\u000e\u0003R|W.[2J]R,w-\u001a:\u0002\u001bQ|G/\u00197UQJ,\u0017\rZ:!\u0003-!\bN]3bI:\u000bgn\\:\u0016\u0005\rm\u0001C\u0002B\u0018\u0007;\u0019\t#\u0003\u0003\u0004 \tE\"a\u0003+ie\u0016\fG\rT8dC2\u0004Baa\t\u0004*5\u00111Q\u0005\u0006\u0005\u0007O\ti#A\u0004sk:$\u0018.\\3\n\t\r-2Q\u0005\u0002\b\u0019>twMU3g\u00031!\bN]3bI:\u000bgn\\:!\u0003)!x\u000e^1m\u001d\u0006twn]\u000b\u0003\u0007g\u0001Ba!\u0002\u00046%!1qGB\u0004\u0005)\tEo\\7jG2{gnZ\u0001\fi>$\u0018\r\u001c(b]>\u001c\b%A\u0004uS6LgnZ:\u0002\u0011QLW.\u001b8hg\u0002\nQA\\1o_N,\"!!\u001f\u0015\u0005\t5H\u0003BA4\u0007\u000fBqAa7\\\u0001\u0004\u0011i/\u0001\u0003tQ><H\u0003BAO\u0007\u001bBqaa\u0014]\u0001\u0004\tI(\u0001\u0002og\"\u001aAB!\u0010\u0002\u0013M$x\u000e\u001d+j[\u0016\u0014HCBA4\u0007/\u001aI\u0006C\u0004\u0003r6\u0001\rAa=\t\u000f\tEW\u00021\u0001\u0003n\"\u001aQB!\u0010\u0002\u0013A,8\u000f\u001b+j[\u0016\u0014HC\u0002Bw\u0007C\u001a\t\rC\u0004\u0004d9\u0001\ra!\u001a\u0002\rQLW.\u001a:t!\r\tI)\u001f\u0002\u000b)&lWM]*uC\u000e\\7cA=\u00026Q\u00111QM\u0001\u0006K2,Wn]\u000b\u0003\u0007c\u0002b!!/\u0004t\r]\u0014\u0002BB;\u0003\u0007\u0014A\u0001T5tiBA\u0011qGA;\u0007s\nI\bE\u0002\u0002\n\u0012\u0014ab\u0015;bG.\f'\r\\3US6,'oE\u0003e\u0007\u007f\u001a\t\nE\u0002\u0002\nz\u0013\u0001bU;c)&lWM]\n\u0006=\nM(\u0011Y\u000b\u0003\u0005g$baa \u0004\n\u000e-\u0005bBAME\u0002\u0007\u0011Q\u0014\u0005\b\u0003\u000b\u0014\u0007\u0019\u0001Bz)\u0011\u0011ica$\t\u000f\r=3\r1\u0001\u0002zA1\u0011\u0011XAx\u0007s\"ba!\u001f\u0004\u0016\u000e]\u0005bBAMO\u0002\u0007\u0011Q\u0014\u0005\b\u0003\u000b<\u0007\u0019\u0001Bz\u00035\u0019\b/Z2jM&\u001cg*\u00198pg\u0006\t2\u000f]3dS\u001aL7MT1o_N|F%Z9\u0015\t\u0005\u001d4q\u0014\u0005\n\u0005\u001bI\u0017\u0011!a\u0001\u0003s\nab\u001d9fG&4\u0017n\u0019(b]>\u001c\b\u0005\u0006\u0003\u0003\u0002\r\u0015\u0006b\u0002B\fW\u0002\u00071\u0011\u0010\u000b\u0005\u0003\u001b\u001cI\u000bC\u0004\u0003\u00181\u0004\rAa\b\u0002\u0013\u0015dW-\\:`I\u0015\fH\u0003BA4\u0007_C\u0011B!\u0004}\u0003\u0003\u0005\ra!\u001d\u0002\r\u0015dW-\\:!\u0003\u0011\u0001Xo\u001d5\u0015\t\t58q\u0017\u0005\b\u0007ss\b\u0019AB=\u0003\u0005!\u0018a\u00019paR!\u0011qMB`\u0011\u001d\u0011Yn a\u0001\u0005[D\u0001ba1\u000f\t\u0003\u00071QY\u0001\u0006i&lWM\u001d\t\u0007\u0003o\u0011\u0019i!\u001f)\u00079\u0011i$\u0001\u0005q_B$\u0016.\\3s)\u0019\t9g!4\u0004P\"911M\bA\u0002\r\u0015\u0004b\u0002Bn\u001f\u0001\u0007!Q\u001e\u0015\u0004\u001f\tu\u0012A\u00038fo\u000e{WO\u001c;feR1\u0011qQBl\u00073Dq!!'\u0011\u0001\u0004\ti\nC\u0004\u00024B\u0001\raa7\u0011\r\u0005]2Q\\AO\u0013\u0011\u0019y.!\f\u0003\u0015q\u0012X\r]3bi\u0016$g(A\u0007oK^\u0014V\r\\\"pk:$XM\u001d\u000b\u0007\u0003\u000f\u001b)oa:\t\u000f\u0005e\u0015\u00031\u0001\u0002\u001e\"91\u0011^\tA\u0002\u0005\u001d\u0015aA2ue\u0006ia.Z<Tk\n\u001cu.\u001e8uKJ$bAa/\u0004p\u000eE\bbBAM%\u0001\u0007\u0011Q\u0014\u0005\b\u0007S\u0014\u0002\u0019AAD\u0003!qWm\u001e+j[\u0016\u0014HC\u0002Bz\u0007o\u001cI\u0010C\u0004\u0002\u001aN\u0001\r!!(\t\u000f\u0005M6\u00031\u0001\u0004\\\u0006Ya.Z<Tk\n$\u0016.\\3s)\u0019\u0011\u0019pa@\u0005\u0002!9\u0011\u0011\u0014\u000bA\u0002\u0005u\u0005bBBb)\u0001\u0007!1_\u0001\u0012]\u0016<8\u000b^1dW\u0006\u0014G.\u001a+j[\u0016\u0014HCBB=\t\u000f!I\u0001C\u0004\u0002\u001aV\u0001\r!!(\t\u000f\r\rW\u00031\u0001\u0003t\u00069a.Z<WS\u0016<HC\u0002C\b\tK!9\u0003\u0006\u0003\u0005\u0012\u0011\r\u0002cAAEi\t!a+[3x'\u0015!\u0014QGAH\u0003\u0015\tX/\u00198u!\u0019\t9Da!\u0003 QAA\u0011\u0003C\u000f\t?!\t\u0003C\u0004\u0002\u001aj\u0002\r!!(\t\u000f\u0005M&\b1\u0001\u00028\"AAq\u0003\u001e\u0005\u0002\u0004!I\u0002\u0003\u0005\u0005\u0018Y!\t\u0019\u0001C\r\u0011\u001d\tIJ\u0006a\u0001\u0003;Cq!a-\u0017\u0001\u0004\u0019Y.A\u0006oK^\fV/\u00198u\u001b\u0006\u0004XC\u0002C\u0017\to!Y\u0004\u0006\u0004\u00050\u0011%C1\n\u000b\u0005\tc!)\u0005\u0006\u0003\u00054\u0011u\u0002cBAE_\u0012UB\u0011\b\t\u0005\u0005K\"9\u0004B\u0004\u0003j]\u0011\rAa\u001b\u0011\t\t\u0015D1\b\u0003\b\u0005o:\"\u0019\u0001B6\u0011%!ydFA\u0001\u0002\b!\t%\u0001\u0006fm&$WM\\2fIE\u0002\u0002\"a\u000e\u0003\f\u0012eB1\t\t\u0007\u0003s\u000by\u000f\"\u000f\t\u0011\t}t\u0003\"a\u0001\t\u000f\u0002b!a\u000e\u0003\u0004\u0012e\u0002bBAM/\u0001\u0007\u0011Q\u0014\u0005\b\u0003g;\u0002\u0019ABn\u0003)qWm\u001e\"z\u00072\f7o]\u000b\u0005\t#\"I\u0007\u0006\u0004\u0005T\u0011]D\u0011\u0010\u000b\u0005\t+\"\u0019\b\u0006\u0003\u0005X\u0011-\u0004cBAE_\u0012eCq\r\u0019\u0005\t7\"\u0019\u0007\u0005\u0004\u0002 \u0012uC\u0011M\u0005\u0005\t?\n\tLA\u0003DY\u0006\u001c8\u000f\u0005\u0003\u0003f\u0011\rDa\u0003C31\u0005\u0005\t\u0011!B\u0001\u0005W\u00121a\u0018\u00132!\u0011\u0011)\u0007\"\u001b\u0005\u000f\t]\u0004D1\u0001\u0003l!IAQ\u000e\r\u0002\u0002\u0003\u000fAqN\u0001\u000bKZLG-\u001a8dK\u0012\u0012\u0004\u0003CA\u001c\u0005\u0017#9\u0007\"\u001d\u0011\r\u0005e\u0016q\u001eC4\u0011!\u0011y\b\u0007CA\u0002\u0011U\u0004CBA\u001c\u0005\u0007#9\u0007C\u0004\u0002\u001ab\u0001\r!!(\t\u000f\u0005M\u0006\u00041\u0001\u0004\\\u0006ia.Z<US6,'o\u0015;bG.\fQ\"\u00197m#V\fg\u000e^5uS\u0016\u001cXC\u0001CA!\u0019\tI\fb!\u0002\u0010&!AQQAb\u0005!IE/\u001a:bE2,\u0017aC:i_^\u0004VM]2f]R$bA!\f\u0005\f\u0012=\u0005b\u0002CG7\u0001\u0007\u0011\u0011P\u0001\u0002q\"9A\u0011S\u000eA\u0002\u0005e\u0014\u0001\u00022bg\u0016\u0014!BU3m\u0007>,h\u000e^3s'\u0015a\u0014q\u0011Ba)\u0019!I\nb'\u0005\u001eB\u0019\u0011\u0011\u0012\u001f\t\u000f\u0005e\u0005\t1\u0001\u0002\u001e\"9\u0011Q\u0019!A\u0002\u0005\u001d\u0015\u0001D:va\u0016\u0014H\u0005\u001d:fM&D\u0018AA9t+\t!)\u000b\u0005\u0005\u0002`\n}\u0013QTAH\u0003\r\t8\u000fI\u0001\u001bCJ,7i\u001c7e'R\fGo\u001d'pG\u0006dG._#oC\ndW\rZ\u000b\u0003\u0003\u001b\fa$\u0019:f\u0007>dGm\u0015;biNdunY1mYf,e.\u00192mK\u0012|F%Z9\u0015\t\u0005\u001dD\u0011\u0017\u0005\u000b\u0005\u001b\t9!!AA\u0002\u00055\u0017aG1sK\u000e{G\u000eZ*uCR\u001cHj\\2bY2LXI\\1cY\u0016$\u0007%A\rbe\u0016Du\u000e^*uCR\u001cHj\\2bY2LXI\\1cY\u0016$\u0017!H1sK\"{Go\u0015;biNdunY1mYf,e.\u00192mK\u0012|F%Z9\u0015\t\u0005\u001dD1\u0018\u0005\u000b\u0005\u001b\ti!!AA\u0002\u00055\u0017AG1sK\"{Go\u0015;biNdunY1mYf,e.\u00192mK\u0012\u0004\u0013aB3oC\ndW\r\u001a\u0015\u0005\u0003#\u0011i$A\u0006f]\u0006\u0014G.\u001a3`I\u0015\fH\u0003BA4\t\u000fD\u0001\u0002\"3\u0002\u0014\u0001\u0007\u0011QZ\u0001\u0005G>tG-\u0001\u0006i_R,e.\u00192mK\u0012DC!!\u0006\u0003>\u0005q\u0001n\u001c;F]\u0006\u0014G.\u001a3`I\u0015\fH\u0003BA4\t'D\u0001\u0002\"3\u0002\u0018\u0001\u0007\u0011QZ\u0001\u001cCJ,7\u000b^1uSN$\u0018nY:M_\u000e\fG\u000e\\=F]\u0006\u0014G.\u001a3)\t\u0005e!QH\u0001\u0019e\u0016\u0004xN\u001d;Ti\u0006$\u0018n\u001d;jGN|e/\u001a:iK\u0006$G\u0003BA4\t;D\u0001\u0002b8\u0002\u001c\u0001\u0007A\u0011]\u0001\te\u0016\u0004xN\u001d;feB!\u00111\tCr\u0013\u0011!)/!\n\u0003\u0011I+\u0007o\u001c:uKJ\fQ\u0001^5nK\u0012,B\u0001b;\u0005rR!AQ\u001eC~)\u0011!y\u000f\">\u0011\t\t\u0015D\u0011\u001f\u0003\t\tg\fiB1\u0001\u0003l\t\tA\u000bC\u0005\u0005x\u0006uA\u00111\u0001\u0005z\u0006!!m\u001c3z!\u0019\t9Da!\u0005p\"A11YA\u000f\u0001\u0004\u0011\u0019\u0010\u000b\u0003\u0002\u001e\tu\u0002")
public abstract class Statistics {
    private final SymbolTable symbolTable;
    private final HashMap<String, Quantity> scala$reflect$internal$util$Statistics$$qs;
    private boolean areColdStatsLocallyEnabled;
    private boolean areHotStatsLocallyEnabled;

    public SymbolTable symbolTable() {
        return this.symbolTable;
    }

    public void initFromSettings(MutableSettings currentSettings) {
        this.enabled_$eq(currentSettings.YstatisticsEnabled());
        this.hotEnabled_$eq(currentSettings.YhotStatisticsEnabled());
    }

    public final void incCounter(Counter c) {
        if (this.areColdStatsLocallyEnabled() && c != null) {
            c.value_$eq(c.value() + 1);
        }
    }

    public final void incCounter(Counter c, int delta) {
        if (this.areColdStatsLocallyEnabled() && c != null) {
            c.value_$eq(c.value() + delta);
        }
    }

    public final <K> void incCounter(QuantMap<K, Counter> ctrs, K key) {
        if (this.areColdStatsLocallyEnabled() && ctrs != null) {
            Counter counter = ctrs.apply(key);
            counter.value_$eq(counter.value() + 1);
        }
    }

    public final Tuple2<Object, Object> startCounter(SubCounter sc) {
        if (this.areColdStatsLocallyEnabled() && sc != null) {
            return sc.start();
        }
        return null;
    }

    public final void stopCounter(SubCounter sc, Tuple2<Object, Object> start) {
        if (this.areColdStatsLocallyEnabled() && sc != null) {
            sc.stop(start);
        }
    }

    public final Tuple2<Object, Object> startTimer(Timer tm) {
        if (this.areColdStatsLocallyEnabled() && tm != null) {
            return tm.start();
        }
        return null;
    }

    public final void stopTimer(Timer tm, Tuple2<Object, Object> start) {
        if (this.areColdStatsLocallyEnabled() && tm != null) {
            tm.stop(start);
        }
    }

    public final Tuple2<Object, Object> pushTimer(TimerStack timers, Function0<StackableTimer> timer) {
        if (this.areColdStatsLocallyEnabled() && timers != null) {
            return timers.push(timer.apply());
        }
        return null;
    }

    public final void popTimer(TimerStack timers, Tuple2<Object, Object> prev) {
        if (this.areColdStatsLocallyEnabled() && timers != null) {
            timers.pop(prev);
        }
    }

    public Counter newCounter(String prefix, Seq<String> phases) {
        return new Counter(this, prefix, phases);
    }

    public Counter newRelCounter(String prefix, Counter ctr) {
        return new RelCounter(this, prefix, ctr);
    }

    public SubCounter newSubCounter(String prefix, Counter ctr) {
        return new SubCounter(this, prefix, ctr);
    }

    public Timer newTimer(String prefix, Seq<String> phases) {
        return new Timer(this, prefix, phases);
    }

    public Timer newSubTimer(String prefix, Timer timer) {
        return new SubTimer(this, prefix, timer);
    }

    public StackableTimer newStackableTimer(String prefix, Timer timer) {
        return new StackableTimer(this, prefix, timer);
    }

    public View newView(String prefix, Seq<String> phases, Function0<Object> quant) {
        return new View(this, prefix, phases, quant);
    }

    public <K, V> QuantMap<K, V> newQuantMap(String prefix, Seq<String> phases, Function0<V> initValue, Function1<V, Ordered<V>> evidence$1) {
        return new QuantMap(this, prefix, phases, initValue, evidence$1);
    }

    public <V> QuantMap<Class<?>, V> newByClass(String prefix, Seq<String> phases, Function0<V> initValue, Function1<V, Ordered<V>> evidence$2) {
        return new QuantMap(this, prefix, phases, initValue, evidence$2);
    }

    public TimerStack newTimerStack() {
        return new TimerStack();
    }

    public Iterable<Quantity> allQuantities() {
        return this.scala$reflect$internal$util$Statistics$$qs().withFilter((Function1<Tuple2, Object> & java.io.Serializable & Serializable)check$ifrefutable$1 -> BoxesRunTime.boxToBoolean(bl = check$ifrefutable$1 != null)).withFilter((Function1<Tuple2, Object> & java.io.Serializable & Serializable)x$2 -> BoxesRunTime.boxToBoolean(Statistics.$anonfun$allQuantities$2(x$2))).flatMap((Function1<Tuple2, List> & java.io.Serializable & Serializable)x$3 -> {
            if (x$3 == null) {
                throw new MatchError((Object)null);
            }
            Quantity q = (Quantity)x$3._2();
            List list = q.children().toList().$colon$colon(q).withFilter((Function1<Quantity, Object> & java.io.Serializable & Serializable)r -> BoxesRunTime.boxToBoolean(Statistics.$anonfun$allQuantities$4(r))).map((Function1<Quantity, Quantity> & java.io.Serializable & Serializable)r -> r, List$.MODULE$.canBuildFrom());
            return list;
        }, Iterable$.MODULE$.canBuildFrom());
    }

    public String scala$reflect$internal$util$Statistics$$showPercent(long x, long base) {
        if (base == 0L) {
            return "";
        }
        double arg$macro$1 = (double)x / (double)base * (double)100;
        return new StringOps(" (%2.1f%%)").format(Predef$.MODULE$.genericWrapArray(new Object[]{BoxesRunTime.boxToDouble(arg$macro$1)}));
    }

    public HashMap<String, Quantity> scala$reflect$internal$util$Statistics$$qs() {
        return this.scala$reflect$internal$util$Statistics$$qs;
    }

    public boolean areColdStatsLocallyEnabled() {
        return this.areColdStatsLocallyEnabled;
    }

    public void areColdStatsLocallyEnabled_$eq(boolean x$1) {
        this.areColdStatsLocallyEnabled = x$1;
    }

    public boolean areHotStatsLocallyEnabled() {
        return this.areHotStatsLocallyEnabled;
    }

    public void areHotStatsLocallyEnabled_$eq(boolean x$1) {
        this.areHotStatsLocallyEnabled = x$1;
    }

    public final boolean enabled() {
        return this.areColdStatsLocallyEnabled();
    }

    public void enabled_$eq(boolean cond) {
        if (cond && !this.areColdStatsLocallyEnabled()) {
            StatisticsStatics.enableColdStats();
            this.areColdStatsLocallyEnabled_$eq(true);
        }
    }

    public final boolean hotEnabled() {
        return this.areColdStatsLocallyEnabled() && this.areHotStatsLocallyEnabled();
    }

    public void hotEnabled_$eq(boolean cond) {
        if (cond && this.areColdStatsLocallyEnabled() && !this.areHotStatsLocallyEnabled()) {
            StatisticsStatics.enableHotStats();
            this.areHotStatsLocallyEnabled_$eq(true);
        }
    }

    public final boolean areStatisticsLocallyEnabled() {
        return this.areColdStatsLocallyEnabled();
    }

    public final void reportStatisticsOverhead(Reporter reporter) {
        long start = System.nanoTime();
        LongRef total = LongRef.create(0L);
        int n = 1;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        Range.Inclusive inclusive = RichInt$.MODULE$.to$extension0(n, 10000);
        if (inclusive == null) {
            throw null;
        }
        Range.Inclusive foreach$mVc$sp_this = inclusive;
        if (!foreach$mVc$sp_this.isEmpty()) {
            int foreach$mVc$sp_i = foreach$mVc$sp_this.start();
            while (true) {
                Statistics.$anonfun$reportStatisticsOverhead$1(total, foreach$mVc$sp_i);
                if (foreach$mVc$sp_i == foreach$mVc$sp_this.scala$collection$immutable$Range$$lastElement()) break;
                foreach$mVc$sp_i += foreach$mVc$sp_this.step();
            }
        }
        long total2 = System.nanoTime() - start;
        String variation = new StringBuilder(8).append((double)total.elem / 10000.0).append("ns to ").append((double)total2 / 10000.0).append("ns").toString();
        reporter.echo(NoPosition$.MODULE$, new StringBuilder(52).append("Enabling statistics, measuring overhead = ").append(variation).append(" per timer").toString());
    }

    public final <T> T timed(Timer timer, Function0<T> body) {
        T t;
        Tuple2<Object, Object> tuple2 = this.areColdStatsLocallyEnabled() && timer != null ? timer.start() : null;
        try {
            t = body.apply();
        }
        catch (Throwable throwable) {
            if (this.areColdStatsLocallyEnabled() && timer != null) {
                timer.stop(tuple2);
            }
            throw throwable;
        }
        if (this.areColdStatsLocallyEnabled() && timer != null) {
            timer.stop(tuple2);
            return t;
        }
        return t;
    }

    public static final /* synthetic */ boolean $anonfun$allQuantities$2(Tuple2 x$2) {
        if (x$2 == null) {
            throw new MatchError((Object)null);
        }
        Quantity q = (Quantity)x$2._2();
        Quantity quantity = q.underlying();
        boolean bl = quantity != null && quantity.equals(q);
        return bl;
    }

    public static final /* synthetic */ boolean $anonfun$allQuantities$4(Quantity r) {
        String string = r.prefix();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return new StringOps(string).nonEmpty();
    }

    public static final /* synthetic */ void $anonfun$reportStatisticsOverhead$1(LongRef total$1, int i) {
        long time = System.nanoTime();
        total$1.elem += System.nanoTime() - time;
    }

    public Statistics(SymbolTable symbolTable, MutableSettings settings) {
        this.symbolTable = symbolTable;
        this.initFromSettings(settings);
        this.scala$reflect$internal$util$Statistics$$qs = new HashMap();
        this.areColdStatsLocallyEnabled = false;
        this.areHotStatsLocallyEnabled = false;
    }

    public class Counter
    implements Quantity,
    Ordered<Counter> {
        private final String prefix;
        private final Seq<String> phases;
        private int value;
        private final ListBuffer<Quantity> children;
        public final /* synthetic */ Statistics $outer;

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
        public Quantity underlying() {
            return ((Quantity)this).underlying();
        }

        @Override
        public boolean showAt(String phase) {
            return ((Quantity)this).showAt(phase);
        }

        @Override
        public String line() {
            return ((Quantity)this).line();
        }

        @Override
        public ListBuffer<Quantity> children() {
            return this.children;
        }

        @Override
        public void scala$reflect$internal$util$Statistics$Quantity$_setter_$children_$eq(ListBuffer<Quantity> x$1) {
            this.children = x$1;
        }

        @Override
        public String prefix() {
            return this.prefix;
        }

        @Override
        public Seq<String> phases() {
            return this.phases;
        }

        public int value() {
            return this.value;
        }

        public void value_$eq(int x$1) {
            this.value = x$1;
        }

        @Override
        public int compare(Counter that) {
            if (this.value() < that.value()) {
                return -1;
            }
            if (this.value() > that.value()) {
                return 1;
            }
            return 0;
        }

        public boolean equals(Object that) {
            Counter counter;
            boolean bl = that instanceof Counter && ((Counter)that).scala$reflect$internal$util$Statistics$Counter$$$outer() == this.scala$reflect$internal$util$Statistics$Counter$$$outer() ? this.compare(counter = (Counter)that) == 0 : false;
            return bl;
        }

        public int hashCode() {
            return this.value();
        }

        public String toString() {
            return Integer.toString(this.value());
        }

        public /* synthetic */ Statistics scala$reflect$internal$util$Statistics$Counter$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ Statistics scala$reflect$internal$util$Statistics$Quantity$$$outer() {
            return this.scala$reflect$internal$util$Statistics$Counter$$$outer();
        }

        public Counter(Statistics $outer, String prefix, Seq<String> phases) {
            this.prefix = prefix;
            this.phases = phases;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Quantity.$init$(this);
            Ordered.$init$(this);
            this.value = 0;
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    public class QuantMap<K, V>
    extends HashMap<K, V>
    implements SynchronizedMap<K, V>,
    Quantity {
        private final String prefix;
        private final Seq<String> phases;
        private final Function0<V> initValue;
        private final Function1<V, Ordered<V>> evidence$3;
        private final ListBuffer<Quantity> children;
        public final /* synthetic */ Statistics $outer;

        @Override
        public Quantity underlying() {
            return ((Quantity)this).underlying();
        }

        @Override
        public boolean showAt(String phase) {
            return ((Quantity)this).showAt(phase);
        }

        @Override
        public String line() {
            return ((Quantity)this).line();
        }

        @Override
        public /* synthetic */ Option scala$collection$mutable$SynchronizedMap$$super$get(Object key) {
            return super.get(key);
        }

        @Override
        public /* synthetic */ Iterator scala$collection$mutable$SynchronizedMap$$super$iterator() {
            return super.iterator();
        }

        @Override
        public /* synthetic */ SynchronizedMap scala$collection$mutable$SynchronizedMap$$super$$plus$eq(Tuple2 kv) {
            return (SynchronizedMap)super.$plus$eq(kv);
        }

        @Override
        public /* synthetic */ SynchronizedMap scala$collection$mutable$SynchronizedMap$$super$$minus$eq(Object key) {
            return (SynchronizedMap)super.$minus$eq(key);
        }

        @Override
        public /* synthetic */ int scala$collection$mutable$SynchronizedMap$$super$size() {
            return super.size();
        }

        @Override
        public /* synthetic */ Option scala$collection$mutable$SynchronizedMap$$super$put(Object key, Object value) {
            return super.put(key, value);
        }

        @Override
        public /* synthetic */ void scala$collection$mutable$SynchronizedMap$$super$update(Object key, Object value) {
            super.update(key, value);
        }

        @Override
        public /* synthetic */ Option scala$collection$mutable$SynchronizedMap$$super$remove(Object key) {
            return super.remove(key);
        }

        @Override
        public /* synthetic */ void scala$collection$mutable$SynchronizedMap$$super$clear() {
            super.clear();
        }

        @Override
        public /* synthetic */ Object scala$collection$mutable$SynchronizedMap$$super$getOrElseUpdate(Object key, Function0 op) {
            return super.getOrElseUpdate(key, op);
        }

        @Override
        public /* synthetic */ SynchronizedMap scala$collection$mutable$SynchronizedMap$$super$transform(Function2 f) {
            this.iterator().foreach(arg_0 -> scala.collection.mutable.MapLike.$anonfun$transform$1$adapted(this, f, arg_0));
            return this;
        }

        @Override
        public /* synthetic */ SynchronizedMap scala$collection$mutable$SynchronizedMap$$super$retain(Function2 p) {
            this.toList().withFilter(scala.collection.mutable.MapLike::$anonfun$retain$1$adapted).foreach(arg_0 -> scala.collection.mutable.MapLike.$anonfun$retain$2(this, p, arg_0));
            return this;
        }

        @Override
        public /* synthetic */ Iterable scala$collection$mutable$SynchronizedMap$$super$values() {
            return super.values();
        }

        @Override
        public /* synthetic */ Iterator scala$collection$mutable$SynchronizedMap$$super$valuesIterator() {
            return super.valuesIterator();
        }

        @Override
        public /* synthetic */ Map scala$collection$mutable$SynchronizedMap$$super$clone() {
            return scala.collection.mutable.MapLike.clone$(this);
        }

        @Override
        public /* synthetic */ void scala$collection$mutable$SynchronizedMap$$super$foreach(Function1 f) {
            this.foreachEntry(arg_0 -> HashMap.$anonfun$foreach$1(f, arg_0));
        }

        @Override
        public /* synthetic */ Object scala$collection$mutable$SynchronizedMap$$super$apply(Object key) {
            return super.apply(key);
        }

        @Override
        public /* synthetic */ Set scala$collection$mutable$SynchronizedMap$$super$keySet() {
            return super.keySet();
        }

        @Override
        public /* synthetic */ Iterable scala$collection$mutable$SynchronizedMap$$super$keys() {
            return MapLike.keys$(this);
        }

        @Override
        public /* synthetic */ Iterator scala$collection$mutable$SynchronizedMap$$super$keysIterator() {
            return super.keysIterator();
        }

        @Override
        public /* synthetic */ boolean scala$collection$mutable$SynchronizedMap$$super$isEmpty() {
            return MapLike.isEmpty$(this);
        }

        @Override
        public /* synthetic */ boolean scala$collection$mutable$SynchronizedMap$$super$contains(Object key) {
            return super.contains(key);
        }

        @Override
        public /* synthetic */ boolean scala$collection$mutable$SynchronizedMap$$super$isDefinedAt(Object key) {
            return MapLike.isDefinedAt$(this, key);
        }

        @Override
        public Option<V> get(K key) {
            return SynchronizedMap.get$(this, key);
        }

        @Override
        public Iterator<Tuple2<K, V>> iterator() {
            return SynchronizedMap.iterator$(this);
        }

        @Override
        public SynchronizedMap<K, V> $plus$eq(Tuple2<K, V> kv) {
            return SynchronizedMap.$plus$eq$(this, kv);
        }

        @Override
        public SynchronizedMap<K, V> $minus$eq(K key) {
            return SynchronizedMap.$minus$eq$(this, key);
        }

        @Override
        public int size() {
            return SynchronizedMap.size$(this);
        }

        @Override
        public Option<V> put(K key, V value) {
            return SynchronizedMap.put$(this, key, value);
        }

        @Override
        public void update(K key, V value) {
            SynchronizedMap.update$(this, key, value);
        }

        @Override
        public Option<V> remove(K key) {
            return SynchronizedMap.remove$(this, key);
        }

        @Override
        public void clear() {
            SynchronizedMap.clear$(this);
        }

        @Override
        public V getOrElseUpdate(K key, Function0<V> function0) {
            return (V)SynchronizedMap.getOrElseUpdate$(this, key, function0);
        }

        @Override
        public SynchronizedMap<K, V> transform(Function2<K, V, V> f) {
            return SynchronizedMap.transform$(this, f);
        }

        @Override
        public SynchronizedMap<K, V> retain(Function2<K, V, Object> p) {
            return SynchronizedMap.retain$(this, p);
        }

        @Override
        public Iterable<V> values() {
            return SynchronizedMap.values$(this);
        }

        @Override
        public Iterator<V> valuesIterator() {
            return SynchronizedMap.valuesIterator$(this);
        }

        @Override
        public Map<K, V> clone() {
            return SynchronizedMap.clone$(this);
        }

        @Override
        public <U> void foreach(Function1<Tuple2<K, V>, U> f) {
            SynchronizedMap.foreach$(this, f);
        }

        @Override
        public V apply(K key) {
            return (V)SynchronizedMap.apply$(this, key);
        }

        @Override
        public Set<K> keySet() {
            return SynchronizedMap.keySet$(this);
        }

        @Override
        public Iterable<K> keys() {
            return SynchronizedMap.keys$(this);
        }

        @Override
        public Iterator<K> keysIterator() {
            return SynchronizedMap.keysIterator$(this);
        }

        @Override
        public boolean isEmpty() {
            return SynchronizedMap.isEmpty$(this);
        }

        @Override
        public boolean contains(K key) {
            return SynchronizedMap.contains$(this, key);
        }

        @Override
        public boolean isDefinedAt(K key) {
            return SynchronizedMap.isDefinedAt$(this, key);
        }

        @Override
        public ListBuffer<Quantity> children() {
            return this.children;
        }

        @Override
        public void scala$reflect$internal$util$Statistics$Quantity$_setter_$children_$eq(ListBuffer<Quantity> x$1) {
            this.children = x$1;
        }

        @Override
        public String prefix() {
            return this.prefix;
        }

        @Override
        public Seq<String> phases() {
            return this.phases;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public V default(K key) {
            void var2_2;
            V elem = this.initValue.apply();
            this.update(key, elem);
            return var2_2;
        }

        @Override
        public String toString() {
            return ((TraversableOnce)((TraversableLike)this.toSeq().sortWith((Function2<Tuple2, Tuple2, Object> & java.io.Serializable & Serializable)(x$6, x$7) -> BoxesRunTime.boxToBoolean(QuantMap.$anonfun$toString$2(this, x$6, x$7)))).map((Function1<Tuple2, String> & java.io.Serializable & Serializable)(A x0$1) -> {
                if (x0$1 != null) {
                    Object cls = x0$1._1();
                    Object elem = x0$1._2();
                    if (cls instanceof Class) {
                        Class clazz = (Class)cls;
                        return new StringBuilder(2).append(clazz.toString().substring(clazz.toString().lastIndexOf("$") + 1)).append(": ").append(elem).toString();
                    }
                }
                if (x0$1 == null) throw new MatchError((Object)null);
                Object key = x0$1._1();
                Object elem = x0$1._2();
                return new StringBuilder(2).append(key).append(": ").append(elem).toString();
            }, Seq$.MODULE$.canBuildFrom())).mkString(", ");
        }

        public /* synthetic */ Statistics scala$reflect$internal$util$Statistics$QuantMap$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ Statistics scala$reflect$internal$util$Statistics$Quantity$$$outer() {
            return this.scala$reflect$internal$util$Statistics$QuantMap$$$outer();
        }

        public static final /* synthetic */ boolean $anonfun$toString$2(QuantMap $this, Tuple2 x$6, Tuple2 x$7) {
            return $this.evidence$3.apply(x$6._2()).$greater(x$7._2());
        }

        public QuantMap(Statistics $outer, String prefix, Seq<String> phases, Function0<V> initValue, Function1<V, Ordered<V>> evidence$3) {
            this.prefix = prefix;
            this.phases = phases;
            this.initValue = initValue;
            this.evidence$3 = evidence$3;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            SynchronizedMap.$init$(this);
            Quantity.$init$(this);
        }
    }

    public interface Quantity {
        public void scala$reflect$internal$util$Statistics$Quantity$_setter_$children_$eq(ListBuffer<Quantity> var1);

        public String prefix();

        public Seq<String> phases();

        default public Quantity underlying() {
            return this;
        }

        default public boolean showAt(String phase) {
            return this.phases().isEmpty() || this.phases().contains(phase);
        }

        default public String line() {
            String arg$macro$1 = this.prefix();
            return new StringOps("%-30s: %s").format(Predef$.MODULE$.genericWrapArray(new Object[]{arg$macro$1, this}));
        }

        public ListBuffer<Quantity> children();

        public /* synthetic */ Statistics scala$reflect$internal$util$Statistics$Quantity$$$outer();

        public static void $init$(Quantity $this) {
            String string = $this.prefix();
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            if (new StringOps(string).nonEmpty()) {
                Quantity quantity = $this.underlying();
                String key = new StringBuilder(1).append((Object)(quantity == null || !quantity.equals($this) ? $this.underlying().prefix() : "")).append("/").append($this.prefix()).toString();
                $this.scala$reflect$internal$util$Statistics$Quantity$$$outer().scala$reflect$internal$util$Statistics$$qs().update(key, $this);
            }
            $this.scala$reflect$internal$util$Statistics$Quantity$_setter_$children_$eq(new ListBuffer<Quantity>());
        }
    }

    private class RelCounter
    extends Counter
    implements SubQuantity {
        private final Counter underlying;

        private /* synthetic */ String super$prefix() {
            return super.prefix();
        }

        @Override
        public Counter underlying() {
            return this.underlying;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public String toString() {
            void assert_assertion;
            boolean bl;
            if (this.value() == 0) {
                return "0";
            }
            boolean bl2 = bl = this.underlying().value() != 0;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            if (assert_assertion == false) {
                throw new AssertionError((Object)new StringBuilder(18).append("assertion failed: ").append((Object)RelCounter.$anonfun$toString$1(this)).toString());
            }
            float arg$macro$1 = (float)this.value() / (float)this.underlying().value();
            return new StringOps("%2.1f").format(Predef$.MODULE$.genericWrapArray(new Object[]{BoxesRunTime.boxToFloat(arg$macro$1)}));
        }

        public /* synthetic */ Statistics scala$reflect$internal$util$Statistics$RelCounter$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ Statistics scala$reflect$internal$util$Statistics$SubQuantity$$$outer() {
            return this.scala$reflect$internal$util$Statistics$RelCounter$$$outer();
        }

        public static final /* synthetic */ String $anonfun$toString$1(RelCounter $this) {
            return new StringBuilder(1).append($this.super$prefix()).append("/").append($this.underlying().line()).toString();
        }

        public RelCounter(Statistics $outer, String prefix, Counter underlying) {
            this.underlying = underlying;
            super($outer, prefix, underlying.phases());
            SubQuantity.$init$(this);
        }
    }

    public class StackableTimer
    extends SubTimer
    implements Ordered<StackableTimer> {
        private long specificNanos;

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

        public long specificNanos() {
            return this.specificNanos;
        }

        public void specificNanos_$eq(long x$1) {
            this.specificNanos = x$1;
        }

        @Override
        public int compare(StackableTimer that) {
            if (this.specificNanos() < that.specificNanos()) {
                return -1;
            }
            if (this.specificNanos() > that.specificNanos()) {
                return 1;
            }
            return 0;
        }

        public boolean equals(Object that) {
            StackableTimer stackableTimer;
            boolean bl = that instanceof StackableTimer && ((StackableTimer)that).scala$reflect$internal$util$Statistics$StackableTimer$$$outer() == this.scala$reflect$internal$util$Statistics$StackableTimer$$$outer() ? this.compare(stackableTimer = (StackableTimer)that) == 0 : false;
            return bl;
        }

        public int hashCode() {
            return Statics.longHash(this.specificNanos());
        }

        @Override
        public String toString() {
            return new StringBuilder(21).append(super.toString()).append(" aggregate, ").append(this.show(this.specificNanos())).append(" specific").toString();
        }

        public /* synthetic */ Statistics scala$reflect$internal$util$Statistics$StackableTimer$$$outer() {
            return this.$outer;
        }

        public StackableTimer(Statistics $outer, String prefix, Timer underlying) {
            super($outer, prefix, underlying);
            Ordered.$init$(this);
            this.specificNanos = 0L;
        }
    }

    public class SubCounter
    extends Counter
    implements SubQuantity {
        private final Counter underlying;

        @Override
        public Counter underlying() {
            return this.underlying;
        }

        public Tuple2<Object, Object> start() {
            return new Tuple2$mcII$sp(this.value(), this.underlying().value());
        }

        /*
         * WARNING - void declaration
         */
        public void stop(Tuple2<Object, Object> prev) {
            void var3_3;
            void var2_2;
            if (prev == null) {
                throw new MatchError((Object)null);
            }
            int value0 = prev._1$mcI$sp();
            int uvalue0 = prev._2$mcI$sp();
            this.value_$eq((int)(var2_2 + this.underlying().value() - var3_3));
        }

        @Override
        public String toString() {
            return new StringBuilder(0).append(this.value()).append(this.scala$reflect$internal$util$Statistics$SubCounter$$$outer().scala$reflect$internal$util$Statistics$$showPercent(this.value(), this.underlying().value())).toString();
        }

        public /* synthetic */ Statistics scala$reflect$internal$util$Statistics$SubCounter$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ Statistics scala$reflect$internal$util$Statistics$SubQuantity$$$outer() {
            return this.scala$reflect$internal$util$Statistics$SubCounter$$$outer();
        }

        public SubCounter(Statistics $outer, String prefix, Counter underlying) {
            this.underlying = underlying;
            super($outer, prefix, underlying.phases());
            SubQuantity.$init$(this);
        }
    }

    public interface SubQuantity
    extends Quantity {
        @Override
        public Quantity underlying();

        public /* synthetic */ Statistics scala$reflect$internal$util$Statistics$SubQuantity$$$outer();

        public static void $init$(SubQuantity $this) {
            $this.underlying().children().$plus$eq((Object)$this);
        }
    }

    public class SubTimer
    extends Timer
    implements SubQuantity {
        private final Timer underlying;

        @Override
        public Timer underlying() {
            return this.underlying;
        }

        @Override
        public String show(long ns) {
            return new StringBuilder(0).append(super.show(ns)).append(this.scala$reflect$internal$util$Statistics$SubTimer$$$outer().scala$reflect$internal$util$Statistics$$showPercent(ns, this.underlying().totalNanos().get())).toString();
        }

        public /* synthetic */ Statistics scala$reflect$internal$util$Statistics$SubTimer$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ Statistics scala$reflect$internal$util$Statistics$SubQuantity$$$outer() {
            return this.scala$reflect$internal$util$Statistics$SubTimer$$$outer();
        }

        public SubTimer(Statistics $outer, String prefix, Timer underlying) {
            this.underlying = underlying;
            super($outer, prefix, underlying.phases());
            SubQuantity.$init$(this);
        }
    }

    public class Timer
    implements Quantity {
        private final String prefix;
        private final Seq<String> phases;
        private final AtomicInteger scala$reflect$internal$util$Statistics$Timer$$totalThreads;
        private final ThreadLocal<LongRef> threadNanos;
        private final AtomicLong totalNanos;
        private final AtomicInteger timings;
        private final ListBuffer<Quantity> children;
        public final /* synthetic */ Statistics $outer;

        @Override
        public Quantity underlying() {
            return ((Quantity)this).underlying();
        }

        @Override
        public boolean showAt(String phase) {
            return ((Quantity)this).showAt(phase);
        }

        @Override
        public String line() {
            return ((Quantity)this).line();
        }

        @Override
        public ListBuffer<Quantity> children() {
            return this.children;
        }

        @Override
        public void scala$reflect$internal$util$Statistics$Quantity$_setter_$children_$eq(ListBuffer<Quantity> x$1) {
            this.children = x$1;
        }

        @Override
        public String prefix() {
            return this.prefix;
        }

        @Override
        public Seq<String> phases() {
            return this.phases;
        }

        public AtomicInteger scala$reflect$internal$util$Statistics$Timer$$totalThreads() {
            return this.scala$reflect$internal$util$Statistics$Timer$$totalThreads;
        }

        private ThreadLocal<LongRef> threadNanos() {
            return this.threadNanos;
        }

        public AtomicLong totalNanos() {
            return this.totalNanos;
        }

        public AtomicInteger timings() {
            return this.timings;
        }

        public long nanos() {
            return this.totalNanos().get();
        }

        public Tuple2<Object, Object> start() {
            return new Tuple2$mcJJ$sp(this.threadNanos().get().elem, System.nanoTime());
        }

        /*
         * WARNING - void declaration
         */
        public void stop(Tuple2<Object, Object> prev) {
            void var4_3;
            void var2_2;
            if (prev == null) {
                throw new MatchError((Object)null);
            }
            long nanos0 = prev._1$mcJ$sp();
            long start = prev._2$mcJ$sp();
            void newThreadNanos = var2_2 + System.nanoTime() - var4_3;
            LongRef threadNanosCount = this.threadNanos().get();
            void diff = newThreadNanos - threadNanosCount.elem;
            threadNanosCount.elem = newThreadNanos;
            this.totalNanos().addAndGet((long)diff);
            this.timings().incrementAndGet();
        }

        public String show(long ns) {
            return new StringBuilder(2).append((double)(ns / 1000L) / 1000.0).append("ms").toString();
        }

        public String toString() {
            int threads = this.scala$reflect$internal$util$Statistics$Timer$$totalThreads().get();
            return new StringBuilder(8).append(this.timings()).append(" spans, ").append(threads > 1 ? new StringBuilder(10).append(threads).append(" threads, ").toString() : BoxedUnit.UNIT).append(this.show(this.totalNanos().get())).toString();
        }

        public /* synthetic */ Statistics scala$reflect$internal$util$Statistics$Timer$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ Statistics scala$reflect$internal$util$Statistics$Quantity$$$outer() {
            return this.scala$reflect$internal$util$Statistics$Timer$$$outer();
        }

        public Timer(Statistics $outer, String prefix, Seq<String> phases) {
            this.prefix = prefix;
            this.phases = phases;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Quantity.$init$(this);
            this.scala$reflect$internal$util$Statistics$Timer$$totalThreads = new AtomicInteger();
            this.threadNanos = new ThreadLocal<LongRef>(this){
                private final /* synthetic */ Timer $outer;

                public LongRef initialValue() {
                    this.$outer.scala$reflect$internal$util$Statistics$Timer$$totalThreads().incrementAndGet();
                    return new LongRef(0L);
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                }
            };
            this.totalNanos = new AtomicLong();
            this.timings = new AtomicInteger();
        }
    }

    public class TimerStack {
        private List<Tuple2<StackableTimer, Object>> elems;

        private List<Tuple2<StackableTimer, Object>> elems() {
            return this.elems;
        }

        private void elems_$eq(List<Tuple2<StackableTimer, Object>> x$1) {
            this.elems = x$1;
        }

        public Tuple2<Object, Object> push(StackableTimer t) {
            Tuple2<StackableTimer, Long> tuple2 = new Tuple2<StackableTimer, Long>(t, BoxesRunTime.boxToLong(0L));
            this.elems_$eq(this.elems().$colon$colon(tuple2));
            return t.start();
        }

        /*
         * Unable to fully structure code
         * Could not resolve type clashes
         */
        public void pop(Tuple2<Object, Object> prev) {
            block9: {
                block8: {
                    if (prev == null) {
                        throw new MatchError((Object)null);
                    }
                    nanos0 = prev._1$mcJ$sp();
                    start = prev._2$mcJ$sp();
                    duration = System.nanoTime() - var5_3;
                    var9_5 = this.elems();
                    if (!(var9_5 instanceof $colon$colon)) break block8;
                    var10_6 = ($colon$colon)var9_5;
                    var11_7 = (Tuple2)var10_6.head();
                    rest = var10_6.tl$access$1();
                    if (var11_7 != null) break block9;
                }
                throw new MatchError(var9_5);
            }
            topTimer = (StackableTimer)var11_7._1();
            var21_10 = var11_7._2$mcJ$sp();
            var13_9.totalNanos().addAndGet((long)(var3_2 + duration));
            var13_9.specificNanos_$eq(var13_9.specificNanos() + (duration - var21_10));
            var13_9.timings().incrementAndGet();
            if (!(var12_8 instanceof $colon$colon)) ** GOTO lbl-1000
            var14_11 = ($colon$colon)var12_8;
            var15_12 = (Tuple2)var14_11.head();
            elems1 = var14_11.tl$access$1();
            if (var15_12 != null) {
                outerTimer = (StackableTimer)var15_12._1();
                outerNested = var15_12._2$mcJ$sp();
                var20_16 = new Tuple2<StackableTimer, Long>(outerTimer, BoxesRunTime.boxToLong(outerNested + duration));
                var2_17 /* !! */  = elems1.$colon$colon(var20_16);
            } else if (Nil$.MODULE$.equals(var12_8)) {
                var2_17 /* !! */  = Nil$.MODULE$;
            } else {
                throw new MatchError(var12_8);
            }
            this.elems_$eq(var2_17 /* !! */ );
        }

        public /* synthetic */ Statistics scala$reflect$internal$util$Statistics$TimerStack$$$outer() {
            return Statistics.this;
        }

        public TimerStack() {
            if (Statistics.this == null) {
                throw null;
            }
            this.elems = Nil$.MODULE$;
        }
    }

    public class View
    implements Quantity {
        private final String prefix;
        private final Seq<String> phases;
        private final Function0<Object> quant;
        private final ListBuffer<Quantity> children;
        public final /* synthetic */ Statistics $outer;

        @Override
        public Quantity underlying() {
            return ((Quantity)this).underlying();
        }

        @Override
        public boolean showAt(String phase) {
            return ((Quantity)this).showAt(phase);
        }

        @Override
        public String line() {
            return ((Quantity)this).line();
        }

        @Override
        public ListBuffer<Quantity> children() {
            return this.children;
        }

        @Override
        public void scala$reflect$internal$util$Statistics$Quantity$_setter_$children_$eq(ListBuffer<Quantity> x$1) {
            this.children = x$1;
        }

        @Override
        public String prefix() {
            return this.prefix;
        }

        @Override
        public Seq<String> phases() {
            return this.phases;
        }

        public String toString() {
            return this.quant.apply().toString();
        }

        public /* synthetic */ Statistics scala$reflect$internal$util$Statistics$View$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ Statistics scala$reflect$internal$util$Statistics$Quantity$$$outer() {
            return this.scala$reflect$internal$util$Statistics$View$$$outer();
        }

        public View(Statistics $outer, String prefix, Seq<String> phases, Function0<Object> quant) {
            this.prefix = prefix;
            this.phases = phases;
            this.quant = quant;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Quantity.$init$(this);
        }
    }
}

