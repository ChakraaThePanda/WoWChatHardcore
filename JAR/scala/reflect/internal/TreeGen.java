/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import java.lang.invoke.LambdaMetafactory;
import scala.Function1;
import scala.Function2;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Option$;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.Tuple4;
import scala.collection.AbstractTraversable;
import scala.collection.IterableLike;
import scala.collection.Iterator;
import scala.collection.LinearSeqOptimized;
import scala.collection.SeqLike;
import scala.collection.generic.CanBuildFrom;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Nil$;
import scala.collection.mutable.Builder;
import scala.collection.mutable.ListBuffer;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Trees;
import scala.reflect.internal.Constants;
import scala.reflect.internal.Names;
import scala.reflect.internal.StdAttachments$ForAttachment$;
import scala.reflect.internal.StdAttachments$NoWarnAttachment$;
import scala.reflect.internal.StdAttachments$PatVarDefAttachment$;
import scala.reflect.internal.StdAttachments$SyntheticUnitAttachment$;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.TreeGen$Filter$;
import scala.reflect.internal.TreeGen$ValEq$;
import scala.reflect.internal.TreeGen$ValFrom$;
import scala.reflect.internal.TreeGen$Yield$;
import scala.reflect.internal.TreeGen$patvarTransformer$;
import scala.reflect.internal.TreeGen$patvarTransformerForFor$;
import scala.reflect.internal.TreeInfo;
import scala.reflect.internal.Trees;
import scala.reflect.internal.Trees$EmptyTree$;
import scala.reflect.internal.Trees$pendingSuperCall$;
import scala.reflect.internal.Types;
import scala.reflect.internal.util.Collections;
import scala.reflect.internal.util.FreshNameCreator;
import scala.reflect.internal.util.NoPosition$;
import scala.reflect.internal.util.Position;
import scala.reflect.internal.util.package$;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.IntRef;
import scala.runtime.NonLocalReturnControl;
import scala.runtime.Nothing$;
import scala.runtime.Tuple2Zipped$;
import scala.runtime.Tuple2Zipped$Ops$;

@ScalaSignature(bytes="\u0006\u0001\u0019Ua\u0001CA\u0005\u0003\u0017\t\t!!\u0007\t\u000f\u0005\r\u0002\u0001\"\u0001\u0002&!I\u00111\u0006\u0001C\u0002\u001b\u0005\u0011Q\u0006\u0005\b\u0003k\u0001A\u0011AA\u001c\u0011\u001d\t)\u0006\u0001C\u0001\u0003/Bq!a\u0017\u0001\t\u0003\ti\u0006C\u0004\u0002b\u0001!\t!a\u0019\t\u000f\u0005\u001d\u0004\u0001\"\u0001\u0002j!9\u00111\u000e\u0001\u0005\u0002\u00055\u0004\"CAK\u0001E\u0005I\u0011AAL\u0011\u001d\ti\u000b\u0001C\u0001\u0003_Cq!!,\u0001\t\u0003\t9\u000eC\u0004\u0002.\u0002!\t!!9\t\u000f\u00055\u0006\u0001\"\u0001\u0002h\"9\u0011Q\u0016\u0001\u0005\u0002\u0005=\bbBAW\u0001\u0011\u0005\u0011q\u001f\u0005\b\u0003[\u0003A\u0011\u0001B\u0001\u0011\u001d\u0011I\u0001\u0001C\u0001\u0005\u0017AqA!\u0005\u0001\t\u0003\u0011\u0019\u0002C\u0004\u0003\u0012\u0001!\tA!\u0007\t\u000f\t\u0005\u0002\u0001\"\u0001\u0003$!9!\u0011\u0006\u0001\u0005\u0002\t-\u0002b\u0002B\u001c\u0001\u0011\u0005!\u0011\b\u0005\b\u0005o\u0001A\u0011\u0001B%\u0011\u001d\u0011i\u0005\u0001C\u0001\u0005\u001fBqA!\u0014\u0001\t\u0003\u0011\u0019\u0006C\u0004\u0003Z\u0001!\tAa\u0017\t\u000f\t\u0005\u0004\u0001\"\u0001\u0003d!9!q\r\u0001\u0005\u0002\t%\u0004b\u0002B4\u0001\u0011\u0005!q\u000e\u0005\b\u0005g\u0002A\u0011\u0001B;\u0011\u001d\u0011y\b\u0001C\u0001\u0005\u0003CqA!\"\u0001\t\u0003\u00119\tC\u0004\u0003\u000e\u0002!\tAa$\t\u000f\t]\u0005\u0001\"\u0001\u0003\u001a\"9!q\u0014\u0001\u0005\u0002\t\u0005\u0006b\u0002BU\u0001\u0011%!1\u0016\u0005\b\u0005w\u0003A\u0011\u0002B_\u0011\u001d\u0011I\r\u0001C\u0005\u0005\u0017DqAa4\u0001\t\u0003\u0011\t\u000eC\u0005\u0003\\\u0002\t\n\u0011\"\u0001\u0002\u0018\"I!Q\u001c\u0001\u0012\u0002\u0013\u0005\u0011q\u0013\u0005\b\u0005?\u0004A\u0011\u0001Bq\u0011%\u0011Y\u000fAI\u0001\n\u0003\t9\nC\u0005\u0003n\u0002\t\n\u0011\"\u0001\u0002\u0018\"9!q\u001e\u0001\u0005\u0002\tE\b\"\u0003B\u0000\u0001E\u0005I\u0011AAL\u0011\u001d\u0019\t\u0001\u0001C\u0001\u0007\u0007Aqa!\u0003\u0001\t\u0003\u0019Y\u0001C\u0004\u0004\u000e\u0001!\taa\u0004\t\u000f\rM\u0001\u0001\"\u0001\u0004\u0016!911\u0005\u0001\u0005\u0002\r\u0015\u0002bBB\u0012\u0001\u0011\u000511\u0006\u0005\b\u0007k\u0001A\u0011AB\u001c\u0011%\u0019\t\u0005AI\u0001\n\u0003\t9\nC\u0004\u0004D\u0001!\ta!\u0012\t\u000f\r5\u0003\u0001\"\u0001\u0004P!911\f\u0001\u0005\u0002\ru\u0003\"CB2\u0001E\u0005I\u0011AAL\u0011\u001d\u0019)\u0007\u0001C\u0001\u0007OBqa!\u001d\u0001\t\u0003\u0019\u0019\bC\u0004\u0004z\u0001!\taa\u0003\t\u000f\rm\u0004\u0001\"\u0001\u0004~!91\u0011\u0012\u0001\u0005\u0002\u0005%\u0004bBBF\u0001\u0011\u00051Q\u0012\u0005\n\u0007\u000f\u0004\u0011\u0013!C\u0001\u0007\u0013Dqa!4\u0001\t\u0003\u0019y\rC\u0005\u0004j\u0002\t\n\u0011\"\u0001\u0004J\"911\u001e\u0001\u0005\u0002\r5\bb\u0002C\t\u0001\u0011\u0005A1\u0003\u0005\b\tK\u0001A\u0011\u0001C\u0014\u0011\u001d!i\u0003\u0001C\u0001\t_Aq\u0001\"\r\u0001\t\u0003!\u0019\u0004C\u0005\u0005<\u0001\t\n\u0011\"\u0001\u0002\u0018\"9AQ\b\u0001\u0005\u0002\u0011}\u0002b\u0002C\"\u0001\u0011\u0005AQ\t\u0005\b\t\u0017\u0002A\u0011\u0001C'\u0011%!9\u0007AI\u0001\n\u0003\u0019I\rC\u0005\u0005j\u0001\t\n\u0011\"\u0001\u0004J\u001e9A1\u000e\u0001\t\u0002\u00115da\u0002C8\u0001!\u0005A\u0011\u000f\u0005\b\u0003G\u0001F\u0011\u0001C:\u0011\u001d!)\b\u0015C\u0001\toBq\u0001b Q\t\u0003!\tiB\u0004\u0005\u000e\u0002A\t\u0001b$\u0007\u000f\u0011E\u0005\u0001#\u0001\u0005\u0014\"9\u00111E+\u0005\u0002\u0011U\u0005b\u0002C;+\u0012\u0005Aq\u0013\u0005\b\t\u007f*F\u0011\u0001CO\u000f\u001d!\t\u000b\u0001E\u0001\tG3q\u0001\"*\u0001\u0011\u0003!9\u000bC\u0004\u0002$i#\t\u0001\"+\t\u000f\u0011U$\f\"\u0001\u0005,\"9Aq\u0010.\u0005\u0002\u0011=va\u0002CZ\u0001!\u0005AQ\u0017\u0004\b\to\u0003\u0001\u0012\u0001C]\u0011\u001d\t\u0019c\u0018C\u0001\twCq\u0001\"\u001e`\t\u0003!i\fC\u0004\u0005\u0000}#\t\u0001\"1\t\u000f\u0011\u0015\u0007\u0001\"\u0001\u0005H\"9A1\u001d\u0001\u0005\u0002\u0011\u0015\bb\u0002Cx\u0001\u0011%A\u0011\u001f\u0005\b\t\u007f\u0004A\u0011BC\u0001\u0011\u001d!\u0019\u000f\u0001C\u0001\u000b\u0013Aq!\"\u0006\u0001\t\u0003)9\u0002C\u0004\u0006*\u0001!I!b\u000b\t\u000f\u0015=\u0002\u0001\"\u0001\u00062!9Q1\b\u0001\u0005\n\u0015u\u0002bBC#\u0001\u0011\u0005Qq\t\u0005\n\u000bk\u0002\u0011\u0013!C\u0001\u000bo2a!b\u001f\u0001\u0001\u0015u\u0004bBA\u0012]\u0012\u0005Q1\u0012\u0005\n\u000b\u001fs'\u0019!C\u0001\u000b#C\u0001\"\"*oA\u0003%Q1\u0013\u0005\b\u000bOsG\u0011ACU\u0011\u001d)yK\u001cC!\u000bcCq\u0001\"\u001eo\t\u0003)Y\fC\u0004\u0006B\u0002!I!b1\u0007\r\u0015%\u0007\u0001ACf\u0011))\u0019N\u001eB\u0001B\u0003%\u0011q\u0012\u0005\b\u0003G1H\u0011ACk\u0011\u001d)YN\u001eC!\u000b;Dq!\"9\u0001\t\u0003)\u0019oB\u0004\u0006f\u0002A\t!b:\u0007\u000f\u0015%\b\u0001#\u0001\u0006l\"9\u00111\u0005?\u0005\u0002\u00155xaBCx\u0001!\u0005Q\u0011\u001f\u0004\b\u000bg\u0004\u0001\u0012AC{\u0011\u001d\t\u0019c C\u0001\u000boDq!\"?\u0001\t\u0003)Y\u0010C\u0004\u0006\u0000\u0002!\tA\"\u0001\t\u000f\u00195\u0001\u0001\"\u0001\u0007\u0010\t9AK]3f\u000f\u0016t'\u0002BA\u0007\u0003\u001f\t\u0001\"\u001b8uKJt\u0017\r\u001c\u0006\u0005\u0003#\t\u0019\"A\u0004sK\u001adWm\u0019;\u000b\u0005\u0005U\u0011!B:dC2\f7\u0001A\n\u0004\u0001\u0005m\u0001\u0003BA\u000f\u0003?i!!a\u0005\n\t\u0005\u0005\u00121\u0003\u0002\u0007\u0003:L(+\u001a4\u0002\rqJg.\u001b;?)\t\t9\u0003E\u0002\u0002*\u0001i!!a\u0003\u0002\r\u001ddwNY1m+\t\ty\u0003\u0005\u0003\u0002*\u0005E\u0012\u0002BA\u001a\u0003\u0017\u00111bU=nE>dG+\u00192mK\u00061!o\\8u\u0013\u0012$B!!\u000f\u0002HA!\u00111HA \u001d\r\tiDA\u0007\u0002\u0001%!\u0011\u0011IA\"\u0005\u0019\u0019V\r\\3di&!\u0011QIA\u0006\u0005\u0015!&/Z3t\u0011\u001d\tIe\u0001a\u0001\u0003\u0017\nAA\\1nKB!\u00111HA'\u0013\u0011\ty%!\u0015\u0003\t9\u000bW.Z\u0005\u0005\u0003'\nYAA\u0003OC6,7/\u0001\u0007s_>$8kY1mC\u0012{G\u000f\u0006\u0003\u0002:\u0005e\u0003bBA%\t\u0001\u0007\u00111J\u0001\tg\u000e\fG.\u0019#piR!\u0011\u0011HA0\u0011\u001d\tI%\u0002a\u0001\u0003\u0017\n!c]2bY\u0006\feN\\8uCRLwN\u001c#piR!\u0011\u0011HA3\u0011\u001d\tIE\u0002a\u0001\u0003\u0017\n\u0011c]2bY\u0006\fe.\u001f*fM\u000e{gn\u001d;s+\t\tI$A\ntG\u0006d\u0017MR;oGRLwN\\\"p]N$(\u000f\u0006\u0005\u0002p\u0005U\u0014qQAF!\u0011\tY$!\u001d\n\t\u0005M\u00141\t\u0002\u0005)J,W\rC\u0004\u0002x!\u0001\r!!\u001f\u0002\u000f\u0005\u0014x\r\u001e9fgB1\u00111PAA\u0003_rA!!\b\u0002~%!\u0011qPA\n\u0003\u001d\u0001\u0018mY6bO\u0016LA!a!\u0002\u0006\n!A*[:u\u0015\u0011\ty(a\u0005\t\u000f\u0005%\u0005\u00021\u0001\u0002p\u00051!/Z:ua\u0016D\u0011\"!$\t!\u0003\u0005\r!a$\u0002\u0017\u0005\u00147\u000f\u001e:bGR4UO\u001c\t\u0005\u0003;\t\t*\u0003\u0003\u0002\u0014\u0006M!a\u0002\"p_2,\u0017M\\\u0001\u001eg\u000e\fG.\u0019$v]\u000e$\u0018n\u001c8D_:\u001cHO\u001d\u0013eK\u001a\fW\u000f\u001c;%gU\u0011\u0011\u0011\u0014\u0016\u0005\u0003\u001f\u000bYj\u000b\u0002\u0002\u001eB!\u0011qTAU\u001b\t\t\tK\u0003\u0003\u0002$\u0006\u0015\u0016!C;oG\",7m[3e\u0015\u0011\t9+a\u0005\u0002\u0015\u0005tgn\u001c;bi&|g.\u0003\u0003\u0002,\u0006\u0005&!E;oG\",7m[3e-\u0006\u0014\u0018.\u00198dK\u0006aQn['fi\"|GmQ1mYRQ\u0011qNAY\u0003\u007f\u000b\u0019-a5\t\u000f\u0005M&\u00021\u0001\u00026\u0006A!/Z2fSZ,'\u000f\u0005\u0003\u0002<\u0005]\u0016\u0002BA]\u0003w\u0013aaU=nE>d\u0017\u0002BA_\u0003\u0017\u0011qaU=nE>d7\u000fC\u0004\u0002B*\u0001\r!a\u0013\u0002\u00155,G\u000f[8e\u001d\u0006lW\rC\u0004\u0002F*\u0001\r!a2\u0002\u000bQ\f'oZ:\u0011\r\u0005m\u0014\u0011QAe!\u0011\tY$a3\n\t\u00055\u0017q\u001a\u0002\u0005)f\u0004X-\u0003\u0003\u0002R\u0006-!!\u0002+za\u0016\u001c\bbBAk\u0015\u0001\u0007\u0011\u0011P\u0001\u0005CJ<7\u000f\u0006\u0005\u0002p\u0005e\u0017Q\\Ap\u0011\u001d\tYn\u0003a\u0001\u0003k\u000ba!\\3uQ>$\u0007bBAc\u0017\u0001\u0007\u0011q\u0019\u0005\b\u0003+\\\u0001\u0019AA=)\u0019\ty'a9\u0002f\"9\u00111\u001c\u0007A\u0002\u0005U\u0006bBAk\u0019\u0001\u0007\u0011\u0011\u0010\u000b\u0007\u0003_\nI/!<\t\u000f\u0005-X\u00021\u0001\u0002p\u00051A/\u0019:hKRDq!!6\u000e\u0001\u0004\tI\b\u0006\u0005\u0002p\u0005E\u00181_A{\u0011\u001d\t\u0019L\u0004a\u0001\u0003kCq!!1\u000f\u0001\u0004\tY\u0005C\u0004\u0002V:\u0001\r!!\u001f\u0015\u0015\u0005=\u0014\u0011`A~\u0003{\fy\u0010C\u0004\u00024>\u0001\r!a\u001c\t\u000f\u0005mw\u00021\u0001\u00026\"9\u0011QY\bA\u0002\u0005\u001d\u0007bBAk\u001f\u0001\u0007\u0011\u0011\u0010\u000b\t\u0003_\u0012\u0019A!\u0002\u0003\b!9\u00111\u001e\tA\u0002\u0005=\u0004bBAc!\u0001\u0007\u0011q\u0019\u0005\b\u0003+\u0004\u0002\u0019AA=\u00035i7NT;mY\u0006\u0014\u0018pQ1mYR1\u0011q\u000eB\u0007\u0005\u001fAq!a7\u0012\u0001\u0004\t)\fC\u0004\u0002FF\u0001\r!a2\u0002+5\\\u0017\t\u001e;sS\n,H/\u001a3Rk\u0006d\u0017NZ5feR!\u0011q\u000eB\u000b\u0011\u001d\u00119B\u0005a\u0001\u0003\u0013\f1\u0001\u001e9f)\u0019\tyGa\u0007\u0003\u001e!9!qC\nA\u0002\u0005%\u0007b\u0002B\u0010'\u0001\u0007\u0011QW\u0001\bi\u0016\u0014XnU=n\u0003=i7.\u00119qYfLeMT3fI\u0016$G\u0003BA8\u0005KAqAa\n\u0015\u0001\u0004\ty'\u0001\u0003rk\u0006d\u0017aH7l\u0003R$(/\u001b2vi\u0016$\u0017+^1mS\u001aLWM]%g!>\u001c8/\u001b2mKR!!Q\u0006B\u001a!\u0019\tiBa\f\u0002p%!!\u0011GA\n\u0005\u0019y\u0005\u000f^5p]\"9!QG\u000bA\u0002\u0005%\u0017A\u00029sK\u001aL\u00070A\bnW\u0006#HO]5ckR,GMU3g)\u0019\u0011YD!\u0011\u0003FA!\u00111\bB\u001f\u0013\u0011\u0011y$a\u0011\u0003\u000fI+g\r\u0016:fK\"9!1\t\fA\u0002\u0005%\u0017a\u00019sK\"9!q\t\fA\u0002\u0005U\u0016aA:z[R!!1\bB&\u0011\u001d\u00119e\u0006a\u0001\u0003k\u000b\u0011#\\6V]\u0006$HO]5ckR,GMU3g)\u0011\u0011YD!\u0015\t\u000f\t\u001d\u0003\u00041\u0001\u00026R!!1\bB+\u0011\u001d\u00119&\u0007a\u0001\u0003\u0017\n\u0001BZ;mY:\u000bW.Z\u0001\ngR\f'-\u001b7ju\u0016$B!a\u001c\u0003^!9!q\f\u000eA\u0002\u0005=\u0014\u0001\u0002;sK\u0016\fQb\u001d;bE2,G+\u001f9f\r>\u0014H\u0003BAe\u0005KBqAa\u0018\u001c\u0001\u0004\ty'A\u000bnW\u0006#HO]5ckR,Gm\u0015;bE2,'+\u001a4\u0015\r\u0005=$1\u000eB7\u0011\u001d\u0011\u0019\u0005\ba\u0001\u0003\u0013DqAa\u0012\u001d\u0001\u0004\t)\f\u0006\u0003\u0002p\tE\u0004b\u0002B$;\u0001\u0007\u0011QW\u0001\u0011[.\fE\u000f\u001e:jEV$X\r\u001a+iSN$BAa\u001e\u0003~A!\u00111\bB=\u0013\u0011\u0011Y(a\u0011\u0003\tQC\u0017n\u001d\u0005\b\u0005\u000fr\u0002\u0019AA[\u0003Ei7.\u0011;ue&\u0014W\u000f^3e\u0013\u0012,g\u000e\u001e\u000b\u0005\u0005w\u0011\u0019\tC\u0004\u0003H}\u0001\r!!.\u0002%5\\\u0017\t\u001e;sS\n,H/\u001a3TK2,7\r\u001e\u000b\u0007\u0005w\u0011IIa#\t\u000f\t\u001d\u0002\u00051\u0001\u0002p!9!q\t\u0011A\u0002\u0005U\u0016aC7l)f\u0004X-\u00119qYf$b!a\u001c\u0003\u0012\nU\u0005b\u0002BJC\u0001\u0007\u0011qN\u0001\u0004MVt\u0007bBAcC\u0001\u0007\u0011\u0011P\u0001\u0012[.\f\u0005\u000f\u001d7jK\u0012$\u0016\u0010]3Ue\u0016,GCBA8\u00057\u0013i\nC\u0004\u0003\u0014\n\u0002\r!a\u001c\t\u000f\u0005\u0015'\u00051\u0001\u0002z\u0005)Rn[!uiJL'-\u001e;fIRK\b/Z!qa2LH\u0003CA8\u0005G\u0013)Ka*\t\u000f\u0005-8\u00051\u0001\u0002p!9\u00111\\\u0012A\u0002\u0005U\u0006bBAcG\u0001\u0007\u0011qY\u0001\u0012[.\u001c\u0016N\\4mKRK\b/Z!qa2LHCCA8\u0005[\u0013\tLa-\u00038\"9!q\u0016\u0013A\u0002\u0005=\u0014!\u0002<bYV,\u0007b\u0002B\fI\u0001\u0007\u0011\u0011\u001a\u0005\b\u0005k#\u0003\u0019AA[\u0003\u00119\b.\u0019;\t\u000f\teF\u00051\u0001\u0002\u0010\u0006YqO]1q\u0013:\f\u0005\u000f\u001d7z\u00039!\u0018\u0010]3UKN$8+_7c_2$BAa0\u0003FB!\u00111\bBa\u0013\u0011\u0011\u0019-a/\u0003\u00195+G\u000f[8e'fl'm\u001c7\t\u000f\t\u001dW\u00051\u0001\u0002\u0010\u0006\u0019\u0011M\\=\u0002\u001dQL\b/Z\"bgR\u001c\u00160\u001c2pYR!!q\u0018Bg\u0011\u001d\u00119M\na\u0001\u0003\u001f\u000ba\"\\6Jg&s7\u000f^1oG\u0016|e\r\u0006\u0006\u0002p\tM'Q\u001bBl\u00053DqAa,(\u0001\u0004\ty\u0007C\u0004\u0003\u0018\u001d\u0002\r!!3\t\u0013\t\u001dw\u0005%AA\u0002\u0005=\u0005\"\u0003B]OA\u0005\t\u0019AAH\u0003ai7.S:J]N$\u0018M\\2f\u001f\u001a$C-\u001a4bk2$HeM\u0001\u0019[.L5/\u00138ti\u0006t7-Z(gI\u0011,g-Y;mi\u0012\"\u0014AD7l\u0003NLen\u001d;b]\u000e,wJ\u001a\u000b\u000b\u0003_\u0012\u0019O!:\u0003h\n%\bb\u0002BXU\u0001\u0007\u0011q\u000e\u0005\b\u0005/Q\u0003\u0019AAe\u0011%\u00119M\u000bI\u0001\u0002\u0004\ty\tC\u0005\u0003:*\u0002\n\u00111\u0001\u0002\u0010\u0006ARn[!t\u0013:\u001cH/\u00198dK>3G\u0005Z3gCVdG\u000fJ\u001a\u000215\\\u0017i]%ogR\fgnY3PM\u0012\"WMZ1vYR$C'A\nnCf\u0014W-T6Bg&s7\u000f^1oG\u0016|e\r\u0006\u0006\u0002p\tM(Q\u001fB}\u0005wDqAa\u0018.\u0001\u0004\ty\u0007C\u0004\u0003x6\u0002\r!!3\u0002\u0005A$\bb\u0002B\f[\u0001\u0007\u0011\u0011\u001a\u0005\n\u0005{l\u0003\u0013!a\u0001\u0003\u001f\u000bqBY3g_J,'+\u001a4DQ\u0016\u001c7n]\u0001\u001e[\u0006L(-Z'l\u0003NLen\u001d;b]\u000e,wJ\u001a\u0013eK\u001a\fW\u000f\u001c;%i\u0005IQn[\"mCN\u001cxJ\u001a\u000b\u0005\u0003_\u001a)\u0001C\u0004\u0004\b=\u0002\r!!3\u0002\u0005Q\u0004\u0018!B7l\u001d&dWCAA8\u0003\u0019i7NW3s_R!\u0011qNB\t\u0011\u001d\u00199!\ra\u0001\u0003\u0013\fa\"\\6D_:\u001cH/\u00198u5\u0016\u0014x\u000e\u0006\u0003\u0004\u0018\r\u0005\u0002\u0003BA\u001e\u00073IAaa\u0007\u0004\u001e\tA1i\u001c8ti\u0006tG/\u0003\u0003\u0004 \u0005-!!C\"p]N$\u0018M\u001c;t\u0011\u001d\u00199A\ra\u0001\u0003\u0013\f!\"\\6OC6,G-\u0011:h)\u0019\tyga\n\u0004*!9\u0011\u0011J\u001aA\u0002\u0005-\u0003b\u0002B0g\u0001\u0007\u0011q\u000e\u000b\u0007\u0003_\u001aic!\r\t\u000f\r=B\u00071\u0001\u0002p\u0005\u0019A\u000e[:\t\u000f\rMB\u00071\u0001\u0002p\u0005\u0019!\u000f[:\u0002\u000f5\\G+\u001e9mKR1\u0011qNB\u001d\u0007{Aqaa\u000f6\u0001\u0004\tI(A\u0003fY\u0016l7\u000fC\u0005\u0004@U\u0002\n\u00111\u0001\u0002\u0010\u0006aa\r\\1ui\u0016tWK\\1ss\u0006\tRn\u001b+va2,G\u0005Z3gCVdG\u000f\n\u001a\u0002\u001b5\\G*\u001b;fe\u0006dWK\\5u+\t\u00199\u0005\u0005\u0003\u0002<\r%\u0013\u0002BB&\u0003\u0007\u0012q\u0001T5uKJ\fG.A\u0006nWVs\u0017\u000e\u001e\"m_\u000e\\G\u0003BB)\u0007/\u0002B!a\u000f\u0004T%!1QKA\"\u0005\u0015\u0011En\\2l\u0011\u001d\u0019I\u0006\u000fa\u0001\u0003_\nA!\u001a=qe\u0006YQn\u001b+va2,G+\u001f9f)\u0019\tyga\u0018\u0004b!911H\u001dA\u0002\u0005e\u0004\"CB sA\u0005\t\u0019AAH\u0003Ui7\u000eV;qY\u0016$\u0016\u0010]3%I\u00164\u0017-\u001e7uII\nQ!\\6B]\u0012$b!a\u001c\u0004j\r5\u0004bBB6w\u0001\u0007\u0011qN\u0001\u0006iJ,W-\r\u0005\b\u0007_Z\u0004\u0019AA8\u0003\u0015!(/Z33\u0003\u0011i7n\u0014:\u0015\r\u0005=4QOB<\u0011\u001d\u0019Y\u0007\u0010a\u0001\u0003_Bqaa\u001c=\u0001\u0004\ty'\u0001\u000bnWJ+h\u000e^5nKVs\u0017N^3sg\u0016\u0014VMZ\u0001\u000b[.\u001cV-]!qa2LH\u0003BB@\u0007\u000b\u0003B!a\u000f\u0004\u0002&!11QA\"\u0005\u0015\t\u0005\u000f\u001d7z\u0011\u001d\u00199I\u0010a\u0001\u0003_\n1!\u0019:h\u0003=i7nU;qKJLe.\u001b;DC2d\u0017AC7l)\u0016l\u0007\u000f\\1uKRq1qRBK\u00073\u001b\u0019k!,\u00046\u000ee\u0006\u0003BA\u001e\u0007#KAaa%\u0002D\tAA+Z7qY\u0006$X\rC\u0004\u0004\u0018\u0002\u0003\r!!\u001f\u0002\u000fA\f'/\u001a8ug\"911\u0014!A\u0002\ru\u0015\u0001B:fY\u001a\u0004B!a\u000f\u0004 &!1\u0011UA\"\u0005\u00191\u0016\r\u001c#fM\"91Q\u0015!A\u0002\r\u001d\u0016AC2p]N$(/T8egB!\u00111HBU\u0013\u0011\u0019Y+a\u0011\u0003\u00135{G-\u001b4jKJ\u001c\bbBBX\u0001\u0002\u00071\u0011W\u0001\tmB\f'/Y7tgB1\u00111PAA\u0007g\u0003b!a\u001f\u0002\u0002\u000eu\u0005bBB\\\u0001\u0002\u0007\u0011\u0011P\u0001\u0005E>$\u0017\u0010C\u0005\u0004<\u0002\u0003\n\u00111\u0001\u0004>\u0006A1/\u001e9feB{7\u000f\u0005\u0003\u0002<\r}\u0016\u0002BBa\u0007\u0007\u0014\u0001\u0002U8tSRLwN\\\u0005\u0005\u0007\u000b\fYAA\u0005Q_NLG/[8og\u0006!Rn\u001b+f[Bd\u0017\r^3%I\u00164\u0017-\u001e7uIY*\"aa3+\t\ru\u00161T\u0001\n[.\u0004\u0016M]3oiN$\u0002b!5\u0004`\u000e\r8Q\u001d\t\u0007\u0007'\u001ci.a\u001c\u000e\u0005\rU'\u0002BBl\u00073\f\u0011\"[7nkR\f'\r\\3\u000b\t\rm\u00171C\u0001\u000bG>dG.Z2uS>t\u0017\u0002BAB\u0007+Dqa!9C\u0001\u0004\u00199+A\u0005po:,'/T8eg\"91q\u0013\"A\u0002\u0005e\u0004\"CBt\u0005B\u0005\t\u0019AB_\u0003%\u0001\u0018M]3oiB{7/A\nnWB\u000b'/\u001a8ug\u0012\"WMZ1vYR$3'\u0001\u0006nW\u000ec\u0017m]:EK\u001a$\"ba<\u0004v\u000eeH\u0011\u0001C\u0007!\u0011\tYd!=\n\t\rM\u00181\t\u0002\t\u00072\f7o\u001d#fM\"91q\u001f#A\u0002\r\u001d\u0016\u0001B7pINDq!!\u0013E\u0001\u0004\u0019Y\u0010\u0005\u0003\u0002<\ru\u0018\u0002BB\u0000\u0003#\u0012\u0001\u0002V=qK:\u000bW.\u001a\u0005\b\t\u0007!\u0005\u0019\u0001C\u0003\u0003\u001d!\b/\u0019:b[N\u0004b!a\u001f\u0002\u0002\u0012\u001d\u0001\u0003BA\u001e\t\u0013IA\u0001b\u0003\u0002D\t9A+\u001f9f\t\u00164\u0007b\u0002C\b\t\u0002\u00071qR\u0001\u0006i\u0016l\u0007\u000f\\\u0001\u0006[.tUm\u001e\u000b\r\u0003_\")\u0002b\u0006\u0005\u001a\u0011uA\u0011\u0005\u0005\b\u0007/+\u0005\u0019AA=\u0011\u001d\u0019Y*\u0012a\u0001\u0007;Cq\u0001b\u0007F\u0001\u0004\tI(A\u0003ti\u0006$8\u000fC\u0004\u0005 \u0015\u0003\ra!0\u0002\t9\u0004xn\u001d\u0005\b\tG)\u0005\u0019AB_\u0003\u0011\u0019\u0007o\\:\u0002%5\\g)\u001e8di&|g\u000eV=qKR\u0013X-\u001a\u000b\u0007\u0003_\"I\u0003b\u000b\t\u000f\u0005]d\t1\u0001\u0002z!9\u0011\u0011\u0012$A\u0002\u0005=\u0014aD7l'ftG\u000f[3uS\u000e,f.\u001b;\u0015\u0005\r\u001d\u0013aB7l\u00052|7m\u001b\u000b\u0007\u0003_\")\u0004b\u000e\t\u000f\u0011m\u0001\n1\u0001\u0002z!IA\u0011\b%\u0011\u0002\u0003\u0007\u0011qR\u0001\nI>4E.\u0019;uK:\f\u0011#\\6CY>\u001c7\u000e\n3fM\u0006,H\u000e\u001e\u00133\u00035i7\u000e\u0016:fK>\u0013(\t\\8dWR!\u0011q\u000eC!\u0011\u001d!YB\u0013a\u0001\u0003s\n\u0001\"\\6BgNLwM\u001c\u000b\u0007\u0003_\"9\u0005\"\u0013\t\u000f\r=2\n1\u0001\u0002p!911G&A\u0002\u0005=\u0014aD7l!\u0006\u001c7.Y4f\u001f\nTWm\u0019;\u0015\u0011\u0011=CQ\u000bC0\tG\u0002B!a\u000f\u0005R%!A1KA\"\u0005)\u0001\u0016mY6bO\u0016$UM\u001a\u0005\b\t/b\u0005\u0019\u0001C-\u0003\u0011!WM\u001a8\u0011\t\u0005mB1L\u0005\u0005\t;\n\u0019EA\u0005N_\u0012,H.\u001a#fM\"IA\u0011\r'\u0011\u0002\u0003\u00071QX\u0001\u0007a&$\u0007k\\:\t\u0013\u0011\u0015D\n%AA\u0002\ru\u0016A\u00029lOB{7/A\rnWB\u000b7m[1hK>\u0013'.Z2uI\u0011,g-Y;mi\u0012\u0012\u0014!G7l!\u0006\u001c7.Y4f\u001f\nTWm\u0019;%I\u00164\u0017-\u001e7uIM\nqAV1m\rJ|W\u000eE\u0002\u0002>A\u0013qAV1m\rJ|WnE\u0002Q\u00037!\"\u0001\"\u001c\u0002\u000b\u0005\u0004\b\u000f\\=\u0015\r\u0005=D\u0011\u0010C?\u0011\u001d!YH\u0015a\u0001\u0003_\n1\u0001]1u\u0011\u001d\u0019\u0019D\u0015a\u0001\u0003_\nq!\u001e8baBd\u0017\u0010\u0006\u0003\u0005\u0004\u0012-\u0005CBA\u000f\u0005_!)\t\u0005\u0005\u0002\u001e\u0011\u001d\u0015qNA8\u0013\u0011!I)a\u0005\u0003\rQ+\b\u000f\\33\u0011\u001d\u0011yf\u0015a\u0001\u0003_\nQAV1m\u000bF\u00042!!\u0010V\u0005\u00151\u0016\r\\#r'\r)\u00161\u0004\u000b\u0003\t\u001f#b!a\u001c\u0005\u001a\u0012m\u0005b\u0002C>/\u0002\u0007\u0011q\u000e\u0005\b\u0007g9\u0006\u0019AA8)\u0011!\u0019\tb(\t\u000f\t}\u0003\f1\u0001\u0002p\u00051a)\u001b7uKJ\u00042!!\u0010[\u0005\u00191\u0015\u000e\u001c;feN\u0019!,a\u0007\u0015\u0005\u0011\rF\u0003BB@\t[CqAa\u0018]\u0001\u0004\ty\u0007\u0006\u0003\u0003.\u0011E\u0006b\u0002B0;\u0002\u0007\u0011qN\u0001\u00063&,G\u000e\u001a\t\u0004\u0003{y&!B-jK2$7cA0\u0002\u001cQ\u0011AQ\u0017\u000b\u0005\u0003_\"y\fC\u0004\u0003`\u0005\u0004\r!a\u001c\u0015\t\t5B1\u0019\u0005\b\u0005?\u0012\u0007\u0019AA8\u0003\u0015i7NR8s)\u0019!I\rb7\u0005`R!\u0011q\u000eCf\u0011\u001d!im\u0019a\u0002\t\u001f\fQA\u001a:fg\"\u0004B\u0001\"5\u0005X6\u0011A1\u001b\u0006\u0005\t+\fY!\u0001\u0003vi&d\u0017\u0002\u0002Cm\t'\u0014\u0001C\u0012:fg\"t\u0015-\\3De\u0016\fGo\u001c:\t\u000f\u0011u7\r1\u0001\u0002z\u0005)QM\\;ng\"9A\u0011]2A\u0002\u0005=\u0014!C:vO\u0006\u0014(i\u001c3z\u0003!i7\u000eU1u\t\u00164GC\u0002Ct\tW$i\u000f\u0006\u0003\u00044\u0012%\bb\u0002CgI\u0002\u000fAq\u001a\u0005\b\tw\"\u0007\u0019AA8\u0011\u001d\u0019\u0019\u0004\u001aa\u0001\u0003_\n\u0011\u0004\u001d:pa\u0006<\u0017\r^3O_^\u000b'O\\!ui\u0006\u001c\u0007.\\3oiR1A1\u001fC~\totA\u0001\">\u0005x2\u0001\u0001b\u0002C}K\u0002\u00071QT\u0001\u0003i>Dq\u0001\"@f\u0001\u0004\ty'\u0001\u0003ge>l\u0017!\b9s_B\fw-\u0019;f!\u0006$h+\u0019:EK\u001a\fE\u000f^1dQ6,g\u000e^:\u0015\r\u0015\rQqAC\u0003\u001d\u0011!)0\"\u0002\t\u000f\u0011eh\r1\u0001\u0004\u001e\"9AQ 4A\u0002\u0005=D\u0003CC\u0006\u000b\u001f)\t\"b\u0005\u0015\t\rMVQ\u0002\u0005\b\t\u001b<\u00079\u0001Ch\u0011\u001d\u00199p\u001aa\u0001\u0007OCq\u0001b\u001fh\u0001\u0004\ty\u0007C\u0004\u00044\u001d\u0004\r!a\u001c\u0002\u00175\\w)\u001a8fe\u0006$xN\u001d\u000b\u000b\u000b3)i\"\"\t\u0006$\u0015\u001dB\u0003BA8\u000b7Aq\u0001\"4i\u0001\b!y\rC\u0004\u0006 !\u0004\ra!0\u0002\u0007A|7\u000fC\u0004\u0005|!\u0004\r!a\u001c\t\u000f\u0015\u0015\u0002\u000e1\u0001\u0002\u0010\u0006)a/\u00197fc\"911\u00075A\u0002\u0005=\u0014AC;oo\u0006\u0014h.\u00192mKR!\u0011qNC\u0017\u0011\u001d!Y(\u001ba\u0001\u0003_\n!#\\6DQ\u0016\u001c7.\u00134SK\u001a,H/\u00192mKR1Q1GC\u001c\u000bs!B!a\u001c\u00066!9AQ\u001a6A\u0004\u0011=\u0007b\u0002C>U\u0002\u0007\u0011q\u000e\u0005\b\u0007gQ\u0007\u0019AA8\u0003=i\u0017\r^2i-\u0006\u0014\b+\u0019;uKJtG\u0003BC \u000b\u0007\u0002b!!\b\u00030\u0015\u0005\u0003\u0003CA\u000f\t\u000f\u000bY%a\u001c\t\u000f\t}3\u000e1\u0001\u0002p\u0005IQn\u001b,jg&$xN\u001d\u000b\t\u000b\u0013*i%\"\u0017\u0006^Q!\u0011qNC&\u0011\u001d!i\r\u001ca\u0002\t\u001fDq!b\u0014m\u0001\u0004)\t&A\u0003dCN,7\u000f\u0005\u0004\u0002|\u0005\u0005U1\u000b\t\u0005\u0003w))&\u0003\u0003\u0006X\u0005\r#aB\"bg\u0016$UM\u001a\u0005\b\u000b7b\u0007\u0019AAH\u0003=\u0019\u0007.Z2l\u000bbD\u0017-^:uSZ,\u0007\"\u0003B\u001bYB\u0005\t\u0019AC0!\u0011)\t'b\u001c\u000f\t\u0015\rT1\u000e\t\u0005\u000bK\n\u0019\"\u0004\u0002\u0006h)!Q\u0011NA\f\u0003\u0019a$o\\8u}%!QQNA\n\u0003\u0019\u0001&/\u001a3fM&!Q\u0011OC:\u0005\u0019\u0019FO]5oO*!QQNA\n\u0003Mi7NV5tSR|'\u000f\n3fM\u0006,H\u000e\u001e\u00134+\t)IH\u000b\u0003\u0006`\u0005m%aD$fiZ\u000b'\u000f\u0016:bm\u0016\u00148/\u001a:\u0014\u00079,y\b\u0005\u0003\u0002<\u0015\u0005\u0015\u0002BCB\u000b\u000b\u0013\u0011\u0002\u0016:bm\u0016\u00148/\u001a:\n\t\u0005\u0015Sq\u0011\u0006\u0005\u000b\u0013\u000by!A\u0002ba&$\"!\"$\u0011\u0007\u0005ub.A\u0002ck\u001a,\"!b%\u0011\r\u0015UU1TCP\u001b\t)9J\u0003\u0003\u0006\u001a\u000ee\u0017aB7vi\u0006\u0014G.Z\u0005\u0005\u000b;+9J\u0001\u0006MSN$()\u001e4gKJ\u0004B\"!\b\u0006\"\u0006-\u0013qNB_\u0003_JA!b)\u0002\u0014\t1A+\u001e9mKR\nAAY;gA\u00059a.Y7f!>\u001cHCBB_\u000bW+i\u000bC\u0004\u0003`I\u0004\r!a\u001c\t\u000f\u0005%#\u000f1\u0001\u0002L\u0005AAO]1wKJ\u001cX\r\u0006\u0003\u00064\u0016e\u0006\u0003BA\u000f\u000bkKA!b.\u0002\u0014\t!QK\\5u\u0011\u001d\u0011yf\u001da\u0001\u0003_\"B!\"0\u0006@B111[Bo\u000b?CqAa\u0018u\u0001\u0004\ty'\u0001\u0007hKR4\u0016M]5bE2,7\u000f\u0006\u0003\u0006F\u0016\u001d\u0007CBA>\u0003\u0003+y\nC\u0004\u0003`U\u0004\r!a\u001c\u0003#A\u000bGO^1s)J\fgn\u001d4pe6,'oE\u0002w\u000b\u001b\u0004B!a\u000f\u0006P&!Q\u0011[CC\u0005-!&/\u00198tM>\u0014X.\u001a:\u0002\r\u0019|'OR8s)\u0011)9.\"7\u0011\u0007\u0005ub\u000fC\u0004\u0006Tb\u0004\r!a$\u0002\u0013Q\u0014\u0018M\\:g_JlG\u0003BA8\u000b?DqAa\u0018z\u0001\u0004\ty'\u0001\tjgB\u000bGOV1s/\u0006\u0014h.\u00192mKV\u0011\u0011qR\u0001\u0012a\u0006$h/\u0019:Ue\u0006t7OZ8s[\u0016\u0014\bcAA\u001fy\n\t\u0002/\u0019;wCJ$&/\u00198tM>\u0014X.\u001a:\u0014\u0007q,9\u000e\u0006\u0002\u0006h\u00069\u0002/\u0019;wCJ$&/\u00198tM>\u0014X.\u001a:G_J4uN\u001d\t\u0004\u0003{y(a\u00069biZ\f'\u000f\u0016:b]N4wN]7fe\u001a{'OR8s'\ryXq\u001b\u000b\u0003\u000bc\f1\"\\6V]\u000eDWmY6fIR!\u0011qNC\u007f\u0011!\u0019I&a\u0001A\u0002\u0005=\u0014\u0001E7l'ftG\u000f[3uS\u000e\u0004\u0016M]1n)\u0011\u0019iJb\u0001\t\u0011\u0019\u0015\u0011Q\u0001a\u0001\r\u000f\tQ\u0001\u001d8b[\u0016\u0004B!a\u000f\u0007\n%!a1BA)\u0005!!VM]7OC6,\u0017AB7l\u0007\u0006\u001cH\u000f\u0006\u0004\u0002p\u0019Ea1\u0003\u0005\t\u0005?\n9\u00011\u0001\u0002p!A!q_A\u0004\u0001\u0004\tI\r")
public abstract class TreeGen {
    private volatile TreeGen$ValFrom$ ValFrom$module;
    private volatile TreeGen$ValEq$ ValEq$module;
    private volatile TreeGen$Filter$ Filter$module;
    private volatile TreeGen$Yield$ Yield$module;
    private volatile TreeGen$patvarTransformer$ patvarTransformer$module;
    private volatile TreeGen$patvarTransformerForFor$ patvarTransformerForFor$module;

    public TreeGen$ValFrom$ ValFrom() {
        if (this.ValFrom$module == null) {
            this.ValFrom$lzycompute$1();
        }
        return this.ValFrom$module;
    }

    public TreeGen$ValEq$ ValEq() {
        if (this.ValEq$module == null) {
            this.ValEq$lzycompute$1();
        }
        return this.ValEq$module;
    }

    public TreeGen$Filter$ Filter() {
        if (this.Filter$module == null) {
            this.Filter$lzycompute$1();
        }
        return this.Filter$module;
    }

    public TreeGen$Yield$ Yield() {
        if (this.Yield$module == null) {
            this.Yield$lzycompute$1();
        }
        return this.Yield$module;
    }

    public TreeGen$patvarTransformer$ patvarTransformer() {
        if (this.patvarTransformer$module == null) {
            this.patvarTransformer$lzycompute$1();
        }
        return this.patvarTransformer$module;
    }

    public TreeGen$patvarTransformerForFor$ patvarTransformerForFor() {
        if (this.patvarTransformerForFor$module == null) {
            this.patvarTransformerForFor$lzycompute$1();
        }
        return this.patvarTransformerForFor$module;
    }

    public abstract SymbolTable global();

    public Trees.Select rootId(Names.Name name) {
        return new Trees.Select(this.global(), new Trees.Ident(this.global(), this.global().nme().ROOTPKG()), name);
    }

    public Trees.Select rootScalaDot(Names.Name name) {
        return new Trees.Select(this.global(), this.rootId(this.global().nme().scala_()).setSymbol(this.global().definitions().ScalaPackage()), name);
    }

    public Trees.Select scalaDot(Names.Name name) {
        return new Trees.Select(this.global(), new Trees.Ident(this.global(), this.global().nme().scala_()).setSymbol(this.global().definitions().ScalaPackage()), name);
    }

    public Trees.Select scalaAnnotationDot(Names.Name name) {
        return new Trees.Select(this.global(), this.scalaDot(this.global().nme().annotation()), name);
    }

    public Trees.Select scalaAnyRefConstr() {
        return this.scalaDot(this.global().tpnme().AnyRef());
    }

    public Trees.Tree scalaFunctionConstr(List<Trees.Tree> argtpes, Trees.Tree restpe, boolean abstractFun) {
        Trees.RefTree cls = abstractFun ? this.mkAttributedRef(this.global().definitions().AbstractFunctionClass().apply(argtpes.length())) : this.mkAttributedRef(this.global().definitions().FunctionClass().apply(argtpes.length()));
        return new Trees.AppliedTypeTree(this.global(), (Trees.Tree)((Object)cls), argtpes.$colon$plus(restpe, List$.MODULE$.canBuildFrom()));
    }

    public boolean scalaFunctionConstr$default$3() {
        return false;
    }

    public Trees.Tree mkMethodCall(Symbols.Symbol receiver, Names.Name methodName, List<Types.Type> targs, List<Trees.Tree> args2) {
        return this.mkMethodCall(new Trees.Select(this.global(), (Trees.Tree)((Object)this.mkAttributedRef(receiver)), methodName), targs, args2);
    }

    public Trees.Tree mkMethodCall(Symbols.Symbol method, List<Types.Type> targs, List<Trees.Tree> args2) {
        return this.mkMethodCall((Trees.Tree)((Object)this.mkAttributedRef(method)), targs, args2);
    }

    public Trees.Tree mkMethodCall(Symbols.Symbol method, List<Trees.Tree> args2) {
        return this.mkMethodCall(method, (List<Types.Type>)Nil$.MODULE$, args2);
    }

    public Trees.Tree mkMethodCall(Trees.Tree target, List<Trees.Tree> args2) {
        return this.mkMethodCall(target, (List<Types.Type>)Nil$.MODULE$, args2);
    }

    public Trees.Tree mkMethodCall(Symbols.Symbol receiver, Names.Name methodName, List<Trees.Tree> args2) {
        return this.mkMethodCall(receiver, methodName, (List<Types.Type>)Nil$.MODULE$, args2);
    }

    public Trees.Tree mkMethodCall(Trees.Tree receiver, Symbols.Symbol method, List<Types.Type> targs, List<Trees.Tree> args2) {
        return this.mkMethodCall(this.global().Select(receiver, method), targs, args2);
    }

    public Trees.Tree mkMethodCall(Trees.Tree target, List<Types.Type> targs, List<Trees.Tree> args2) {
        List list;
        SymbolTable symbolTable = this.global();
        if (this.global() == null) {
            throw null;
        }
        if (targs == Nil$.MODULE$) {
            list = Nil$.MODULE$;
        } else {
            $colon$colon<Nothing$> mapList_head;
            Types.Type type = targs.head();
            $colon$colon<Nothing$> mapList_tail = mapList_head = new $colon$colon<Nothing$>((Nothing$)((Object)TreeGen.$anonfun$mkMethodCall$1(this, type)), Nil$.MODULE$);
            for (List mapList_rest = (List)targs.tail(); mapList_rest != Nil$.MODULE$; mapList_rest = (List)mapList_rest.tail()) {
                type = (Types.Type)mapList_rest.head();
                $colon$colon<Nothing$> mapList_next = new $colon$colon<Nothing$>((Nothing$)((Object)TreeGen.$anonfun$mkMethodCall$1(this, type)), Nil$.MODULE$);
                mapList_tail.tl_$eq(mapList_next);
                mapList_tail = mapList_next;
            }
            list = mapList_head;
        }
        return new Trees.Apply(symbolTable, this.mkTypeApply(target, list), args2);
    }

    /*
     * WARNING - void declaration
     */
    public Trees.Tree mkNullaryCall(Symbols.Symbol method, List<Types.Type> targs) {
        Nil$ nil$;
        Trees.Tree tree = (Trees.Tree)((Object)this.mkAttributedRef(method));
        if (this.global() == null) {
            throw null;
        }
        if (targs == Nil$.MODULE$) {
            nil$ = Nil$.MODULE$;
        } else {
            void var3_4;
            $colon$colon<Nothing$> mapList_head;
            Types.Type type = targs.head();
            $colon$colon<Nothing$> mapList_tail = mapList_head = new $colon$colon<Nothing$>((Nothing$)((Object)TreeGen.$anonfun$mkNullaryCall$1(this, type)), Nil$.MODULE$);
            for (List mapList_rest = (List)targs.tail(); mapList_rest != Nil$.MODULE$; mapList_rest = (List)mapList_rest.tail()) {
                type = (Types.Type)mapList_rest.head();
                $colon$colon<Nothing$> mapList_next = new $colon$colon<Nothing$>((Nothing$)((Object)TreeGen.$anonfun$mkNullaryCall$1(this, type)), Nil$.MODULE$);
                mapList_tail.tl_$eq(mapList_next);
                mapList_tail = mapList_next;
            }
            nil$ = var3_4;
        }
        return this.mkTypeApply(tree, nil$);
    }

    public Trees.Tree mkAttributedQualifier(Types.Type tpe) {
        return this.mkAttributedQualifier(tpe, this.global().NoSymbol());
    }

    /*
     * WARNING - void declaration
     */
    public Trees.Tree mkAttributedQualifier(Types.Type tpe, Symbols.Symbol termSym) {
        Trees.Tree tree;
        if (this.global().NoPrefix().equals(tpe)) {
            tree = this.global().EmptyTree();
        } else if (tpe instanceof Types.ThisType) {
            Symbols.Symbol clazz = ((Types.ThisType)tpe).sym();
            tree = clazz.isEffectiveRoot() ? this.global().EmptyTree() : this.mkAttributedThis(clazz);
        } else if (tpe instanceof Types.SingleType) {
            Types.SingleType singleType = (Types.SingleType)tpe;
            Types.Type pre = singleType.pre();
            Symbols.Symbol sym = singleType.sym();
            tree = this.mkApplyIfNeeded(this.mkAttributedStableRef(pre, sym));
        } else if (tpe instanceof Types.TypeRef) {
            Trees.Tree tree2;
            Types.TypeRef typeRef = (Types.TypeRef)tpe;
            Types.Type pre = typeRef.pre();
            Symbols.Symbol sym = typeRef.sym();
            if (sym.isRoot()) {
                tree2 = this.mkAttributedThis(sym);
            } else if (sym.isModuleClass()) {
                tree2 = this.mkApplyIfNeeded((Trees.Tree)((Object)this.mkAttributedRef(pre, sym.sourceModule())));
            } else if (sym.isModule() || sym.isClass()) {
                void assert_assertion;
                SymbolTable symbolTable = this.global();
                boolean bl = this.global().phase().erasedTypes();
                if (symbolTable == null) {
                    throw null;
                }
                SymbolTable assert_this = symbolTable;
                if (assert_assertion == false) {
                    throw assert_this.throwAssertionError(TreeGen.failMessage$1(tpe, termSym));
                }
                tree2 = this.mkAttributedThis(sym);
            } else if (sym.isType()) {
                void assert_assertion;
                boolean bl;
                SymbolTable symbolTable = this.global();
                Symbols.Symbol symbol = termSym;
                Symbols.NoSymbol noSymbol = this.global().NoSymbol();
                boolean bl2 = (symbol == null ? noSymbol != null : !symbol.equals(noSymbol)) ? true : (bl = false);
                if (symbolTable == null) {
                    throw null;
                }
                SymbolTable assert_this = symbolTable;
                if (assert_assertion == false) {
                    throw assert_this.throwAssertionError(TreeGen.failMessage$1(tpe, termSym));
                }
                tree2 = ((Trees.Tree)((Object)this.mkAttributedIdent(termSym))).setType(tpe);
            } else {
                tree2 = (Trees.Tree)((Object)this.mkAttributedRef(pre, sym));
            }
            tree = tree2;
        } else if (tpe instanceof Types.ConstantType) {
            Constants.Constant value = ((Types.ConstantType)tpe).value();
            tree = new Trees.Literal(this.global(), value).setType(tpe);
        } else if (tpe instanceof Types.AnnotatedType) {
            Types.Type atp = ((Types.AnnotatedType)tpe).underlying();
            tree = this.mkAttributedQualifier(atp);
        } else if (tpe instanceof Types.RefinedType) {
            void assert_assertion;
            boolean bl;
            Option option;
            List<Types.Type> parents;
            block31: {
                parents = ((Types.RefinedType)tpe).parents();
                if (parents == null) {
                    throw null;
                }
                LinearSeqOptimized find_these = parents;
                while (!find_these.isEmpty()) {
                    if (((Types.Type)find_these.head()).isStable()) {
                        option = new Some(find_these.head());
                        break block31;
                    }
                    find_these = (LinearSeqOptimized)find_these.tail();
                }
                option = None$.MODULE$;
            }
            SymbolTable symbolTable = this.global();
            boolean bl3 = bl = !option.isEmpty();
            if (symbolTable == null) {
                throw null;
            }
            SymbolTable assert_this = symbolTable;
            if (assert_assertion == false) {
                throw assert_this.throwAssertionError(TreeGen.$anonfun$mkAttributedQualifier$4(parents, tpe, termSym));
            }
            tree = this.mkAttributedQualifier((Types.Type)option.get());
        } else {
            throw this.global().abort(new StringBuilder(24).append("bad qualifier received: ").append(TreeGen.failMessage$1(tpe, termSym)).toString());
        }
        return tree;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public Trees.Tree mkApplyIfNeeded(Trees.Tree qual) {
        Types.Type type = qual.tpe();
        if (!(type instanceof Types.MethodType)) return qual;
        Types.MethodType methodType = (Types.MethodType)type;
        List<Symbols.Symbol> list = methodType.params();
        Types.Type restpe = methodType.resultType();
        if (!((Object)Nil$.MODULE$).equals(list)) return qual;
        return this.global().atPos(qual.pos(), new Trees.Apply(this.global(), qual, Nil$.MODULE$).setType(restpe));
    }

    public Option<Trees.Tree> mkAttributedQualifierIfPossible(Types.Type prefix) {
        Symbols.Symbol sym;
        boolean bl = this.global().NoType().equals(prefix) ? true : (this.global().NoPrefix().equals(prefix) ? true : this.global().ErrorType().equals(prefix));
        Option option = bl ? None$.MODULE$ : (prefix instanceof Types.TypeRef && ((sym = ((Types.TypeRef)prefix).sym()).isModule() || sym.isClass() || sym.isType()) ? None$.MODULE$ : new Some<Trees.Tree>(this.mkAttributedQualifier(prefix)));
        return option;
    }

    public Trees.RefTree mkAttributedRef(Types.Type pre, Symbols.Symbol sym) {
        Trees.Tree qual = this.mkAttributedQualifier(pre);
        Trees.RefTree refTree = ((Object)this.global().EmptyTree()).equals(qual) ? this.mkAttributedIdent(sym) : (qual instanceof Trees.This && qual.symbol().isEffectiveRoot() ? this.mkAttributedIdent(sym) : this.mkAttributedSelect(qual, sym));
        return refTree;
    }

    /*
     * WARNING - void declaration
     */
    public Trees.RefTree mkAttributedRef(Symbols.Symbol sym) {
        if (sym.owner().isStaticOwner()) {
            void assert_assertion;
            boolean bl;
            if (sym.owner().isRoot()) {
                return this.mkAttributedIdent(sym);
            }
            Symbols.Symbol ownerModule = sym.owner().sourceModule();
            SymbolTable symbolTable = this.global();
            Symbols.Symbol symbol = ownerModule;
            Symbols.NoSymbol noSymbol = this.global().NoSymbol();
            boolean bl2 = (symbol == null ? noSymbol != null : !symbol.equals(noSymbol)) ? true : (bl = false);
            if (symbolTable == null) {
                throw null;
            }
            SymbolTable assert_this = symbolTable;
            if (assert_assertion == false) {
                throw assert_this.throwAssertionError(sym.owner());
            }
            return this.mkAttributedSelect((Trees.Tree)((Object)this.mkAttributedRef(sym.owner().sourceModule())), sym);
        }
        if (sym.owner().isClass()) {
            return this.mkAttributedRef(sym.owner().thisType(), sym);
        }
        return this.mkAttributedIdent(sym);
    }

    public Trees.RefTree mkUnattributedRef(Symbols.Symbol sym) {
        return this.mkUnattributedRef(sym.fullNameAsName('.'));
    }

    /*
     * WARNING - void declaration
     */
    public Trees.RefTree mkUnattributedRef(Names.Name fullName) {
        void var9_9;
        void foldLeft_z;
        void var5_5;
        void var4_4;
        List<Names.Name> list = this.global().nme().segments(fullName.toString(), fullName.isTermName());
        if (!(list instanceof $colon$colon)) {
            throw new MatchError(list);
        }
        $colon$colon $colon$colon = ($colon$colon)list;
        Names.Name hd = (Names.Name)$colon$colon.head();
        List tl = $colon$colon.tl$access$1();
        void hd2 = var4_4;
        void tl2 = var5_5;
        Trees.Ident ident = new Trees.Ident(this.global(), (Names.Name)hd2);
        if (tl2 == null) {
            throw null;
        }
        Trees.Select foldLeft_acc = foldLeft_z;
        LinearSeqOptimized foldLeft_these = tl2;
        while (!foldLeft_these.isEmpty()) {
            Names.Name name = (Names.Name)foldLeft_these.head();
            Trees.RefTree refTree = foldLeft_acc;
            foldLeft_acc = TreeGen.$anonfun$mkUnattributedRef$1(this, refTree, name);
            foldLeft_these = (LinearSeqOptimized)foldLeft_these.tail();
        }
        return (Trees.RefTree)var9_9;
    }

    public Trees.Tree stabilize(Trees.Tree tree) {
        Types.Type type = this.stableTypeFor(tree);
        Trees.Tree tree2 = this.global().NoType().equals(type) ? tree : tree.setType(type);
        return tree2;
    }

    public Types.Type stableTypeFor(Trees.Tree tree) {
        Types.Type type;
        if (!this.global().treeInfo().admitsTypeSelection(tree)) {
            return this.global().NoType();
        }
        if (tree instanceof Trees.This) {
            type = this.global().ThisType().apply(tree.symbol());
        } else if (tree instanceof Trees.Ident) {
            type = this.global().singleType(tree.symbol().owner().thisType(), tree.symbol());
        } else if (tree instanceof Trees.Select) {
            Trees.Tree qual = ((Trees.Select)tree).qualifier();
            type = this.global().singleType(qual.tpe(), tree.symbol());
        } else {
            type = this.global().NoType();
        }
        return type;
    }

    public Trees.Tree mkAttributedStableRef(Types.Type pre, Symbols.Symbol sym) {
        return this.stabilize((Trees.Tree)((Object)this.mkAttributedRef(pre, sym)));
    }

    public Trees.Tree mkAttributedStableRef(Symbols.Symbol sym) {
        return this.stabilize((Trees.Tree)((Object)this.mkAttributedRef(sym)));
    }

    public Trees.This mkAttributedThis(Symbols.Symbol sym) {
        return (Trees.This)new Trees.This(this.global(), sym.name().toTypeName()).setSymbol(sym).setType(sym.thisType());
    }

    public Trees.RefTree mkAttributedIdent(Symbols.Symbol sym) {
        return (Trees.RefTree)((Object)new Trees.Ident(this.global(), sym.name()).setSymbol(sym).setType(sym.tpeHK()));
    }

    /*
     * Enabled aggressive block sorting
     */
    public Trees.RefTree mkAttributedSelect(Trees.Tree qual, Symbols.Symbol sym) {
        Types.Type type;
        Trees.Select tree;
        block9: {
            block8: {
                Trees.Tree tree2;
                Symbols.Symbol qualsym;
                if (qual.symbol() != null) {
                    if (qual.symbol().isEffectiveRoot()) return this.mkAttributedIdent(sym);
                    if (qual.symbol().isEmptyPackage()) {
                        return this.mkAttributedIdent(sym);
                    }
                }
                Symbols.Symbol symbol = qualsym = qual.tpe() != null ? qual.tpe().typeSymbol() : (qual.symbol() != null ? qual.symbol() : this.global().NoSymbol());
                if (sym != null && qualsym.hasPackageFlag() && !sym.isDefinedInPackage() && !sym.moduleClass().isDefinedInPackage()) {
                    Symbols.Symbol packageObject = qualsym.packageObject();
                    tree2 = new Trees.Select(this.global(), qual, this.global().nme().PACKAGE()).setSymbol(packageObject).setType(packageObject.typeOfThis());
                } else {
                    tree2 = qual;
                }
                Trees.Tree pkgQualifier = tree2;
                tree = this.global().Select(pkgQualifier, sym);
                if (pkgQualifier.tpe() == null) {
                    return tree;
                }
                Symbols.Symbol symbol2 = sym.rawowner();
                Symbols.ClassSymbol classSymbol = this.global().definitions().ObjectClass();
                if (!(symbol2 == null ? classSymbol != null : !symbol2.equals(classSymbol))) break block8;
                Symbols.Symbol symbol3 = sym.rawowner();
                Symbols.ClassSymbol classSymbol2 = this.global().definitions().AnyClass();
                if (symbol3 != null ? !symbol3.equals(classSymbol2) : classSymbol2 != null) break block9;
            }
            type = sym.tpeHK().normalize();
            return (Trees.RefTree)((Object)tree.setType(type));
        }
        type = qual.tpe().memberType(sym);
        return (Trees.RefTree)((Object)tree.setType(type));
    }

    public Trees.Tree mkTypeApply(Trees.Tree fun, List<Trees.Tree> targs) {
        if (targs.isEmpty()) {
            return fun;
        }
        return new Trees.TypeApply(this.global(), fun, targs);
    }

    public Trees.Tree mkAppliedTypeTree(Trees.Tree fun, List<Trees.Tree> targs) {
        if (targs.isEmpty()) {
            return fun;
        }
        return new Trees.AppliedTypeTree(this.global(), fun, targs);
    }

    public Trees.Tree mkAttributedTypeApply(Trees.Tree target, Symbols.Symbol method, List<Types.Type> targs) {
        return this.mkTypeApply((Trees.Tree)((Object)this.mkAttributedSelect(target, method)), targs.map((Function1<Types.Type, Trees.TypeTree> & java.io.Serializable & Serializable)tp -> this.global().TypeTree((Types.Type)tp), List$.MODULE$.canBuildFrom()));
    }

    private Trees.Tree mkSingleTypeApply(Trees.Tree value, Types.Type tpe, Symbols.Symbol what, boolean wrapInApply) {
        Types.Type type = tpe.dealias();
        Trees.Tree tapp = this.mkAttributedTypeApply(value, what, Nil$.MODULE$.$colon$colon(type));
        if (wrapInApply) {
            return new Trees.Apply(this.global(), tapp, Nil$.MODULE$);
        }
        return tapp;
    }

    private Symbols.MethodSymbol typeTestSymbol(boolean any) {
        if (any) {
            return this.global().definitions().Any_isInstanceOf();
        }
        return this.global().definitions().Object_isInstanceOf();
    }

    private Symbols.MethodSymbol typeCastSymbol(boolean any) {
        if (any) {
            return this.global().definitions().Any_asInstanceOf();
        }
        return this.global().definitions().Object_asInstanceOf();
    }

    public Trees.Tree mkIsInstanceOf(Trees.Tree value, Types.Type tpe, boolean any, boolean wrapInApply) {
        return this.mkSingleTypeApply(value, tpe, this.typeTestSymbol(any), wrapInApply);
    }

    public boolean mkIsInstanceOf$default$3() {
        return true;
    }

    public boolean mkIsInstanceOf$default$4() {
        return true;
    }

    public Trees.Tree mkAsInstanceOf(Trees.Tree value, Types.Type tpe, boolean any, boolean wrapInApply) {
        return this.mkSingleTypeApply(value, tpe, this.typeCastSymbol(any), wrapInApply);
    }

    public boolean mkAsInstanceOf$default$3() {
        return true;
    }

    public boolean mkAsInstanceOf$default$4() {
        return true;
    }

    public Trees.Tree maybeMkAsInstanceOf(Trees.Tree tree, Types.Type pt, Types.Type tpe, boolean beforeRefChecks) {
        Types.Type type = pt;
        Types.Type type2 = this.global().definitions().UnitTpe();
        if (!(type == null ? type2 != null : !type.equals(type2)) || tpe.$less$colon$less(pt)) {
            return tree;
        }
        return this.global().atPos(tree.pos(), this.mkAsInstanceOf(tree, pt, true, !beforeRefChecks));
    }

    public boolean maybeMkAsInstanceOf$default$4() {
        return false;
    }

    public Trees.Tree mkClassOf(Types.Type tp) {
        return new Trees.Literal(this.global(), new Constants.Constant(this.global(), tp)).setType(this.global().ConstantType().apply(new Constants.Constant(this.global(), tp)));
    }

    public Trees.Tree mkNil() {
        return (Trees.Tree)((Object)this.mkAttributedRef(this.global().definitions().NilModule()));
    }

    public Trees.Tree mkZero(Types.Type tp) {
        Symbols.Symbol symbol = tp.typeSymbol();
        Trees.Tree tree = this.global().definitions().NothingClass().equals(symbol) ? this.mkMethodCall(this.global().definitions().Predef_$qmark$qmark$qmark(), (List<Trees.Tree>)Nil$.MODULE$).setType(this.global().definitions().NothingTpe()) : new Trees.Literal(this.global(), this.mkConstantZero(tp)).setType(tp);
        return tree;
    }

    public Constants.Constant mkConstantZero(Types.Type tp) {
        Constants.Constant constant;
        Symbols.Symbol symbol = tp.typeSymbol();
        Symbols.ClassSymbol classSymbol = this.global().definitions().UnitClass();
        if (!(classSymbol != null ? !classSymbol.equals(symbol) : symbol != null)) {
            constant = new Constants.Constant(this.global(), BoxedUnit.UNIT);
        } else {
            Symbols.ClassSymbol classSymbol2 = this.global().definitions().BooleanClass();
            if (!(classSymbol2 != null ? !classSymbol2.equals(symbol) : symbol != null)) {
                constant = new Constants.Constant(this.global(), BoxesRunTime.boxToBoolean(false));
            } else {
                Symbols.ClassSymbol classSymbol3 = this.global().definitions().FloatClass();
                if (!(classSymbol3 != null ? !classSymbol3.equals(symbol) : symbol != null)) {
                    constant = new Constants.Constant(this.global(), BoxesRunTime.boxToFloat(0.0f));
                } else {
                    Symbols.ClassSymbol classSymbol4 = this.global().definitions().DoubleClass();
                    if (!(classSymbol4 != null ? !classSymbol4.equals(symbol) : symbol != null)) {
                        constant = new Constants.Constant(this.global(), BoxesRunTime.boxToDouble(0.0));
                    } else {
                        Symbols.ClassSymbol classSymbol5 = this.global().definitions().ByteClass();
                        if (!(classSymbol5 != null ? !classSymbol5.equals(symbol) : symbol != null)) {
                            constant = new Constants.Constant(this.global(), BoxesRunTime.boxToByte((byte)0));
                        } else {
                            Symbols.ClassSymbol classSymbol6 = this.global().definitions().ShortClass();
                            if (!(classSymbol6 != null ? !classSymbol6.equals(symbol) : symbol != null)) {
                                constant = new Constants.Constant(this.global(), BoxesRunTime.boxToShort((short)0));
                            } else {
                                Symbols.ClassSymbol classSymbol7 = this.global().definitions().IntClass();
                                if (!(classSymbol7 != null ? !classSymbol7.equals(symbol) : symbol != null)) {
                                    constant = new Constants.Constant(this.global(), BoxesRunTime.boxToInteger(0));
                                } else {
                                    Symbols.ClassSymbol classSymbol8 = this.global().definitions().LongClass();
                                    if (!(classSymbol8 != null ? !classSymbol8.equals(symbol) : symbol != null)) {
                                        constant = new Constants.Constant(this.global(), BoxesRunTime.boxToLong(0L));
                                    } else {
                                        Symbols.ClassSymbol classSymbol9 = this.global().definitions().CharClass();
                                        constant = !(classSymbol9 != null ? !classSymbol9.equals(symbol) : symbol != null) ? new Constants.Constant(this.global(), BoxesRunTime.boxToCharacter((char)0)) : new Constants.Constant(this.global(), null);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return constant;
    }

    public Trees.Tree mkNamedArg(Names.Name name, Trees.Tree tree) {
        return this.mkNamedArg(new Trees.Ident(this.global(), name), tree);
    }

    public Trees.Tree mkNamedArg(Trees.Tree lhs, Trees.Tree rhs) {
        return this.global().atPos(rhs.pos(), new Trees.AssignOrNamedArg(this.global(), lhs, rhs));
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public Trees.Tree mkTuple(List<Trees.Tree> elems, boolean flattenUnary) {
        void var3_6;
        if (((Object)Nil$.MODULE$).equals(elems)) {
            Trees.Literal literal = this.mkLiteralUnit();
            return var3_6;
        }
        if (elems instanceof $colon$colon) {
            $colon$colon $colon$colon = ($colon$colon)elems;
            Trees.Tree tree = (Trees.Tree)$colon$colon.head();
            List list = $colon$colon.tl$access$1();
            if (((Object)Nil$.MODULE$).equals(list) && flattenUnary) {
                Trees.Tree tree2 = tree;
                return var3_6;
            }
        }
        Trees.Apply apply2 = new Trees.Apply(this.global(), this.scalaDot(this.global().definitions().TupleClass().apply(elems.length()).name().toTermName()), elems);
        return var3_6;
    }

    public boolean mkTuple$default$2() {
        return true;
    }

    public Trees.Literal mkLiteralUnit() {
        return new Trees.Literal(this.global(), new Constants.Constant(this.global(), BoxedUnit.UNIT));
    }

    public Trees.Block mkUnitBlock(Trees.Tree expr) {
        return new Trees.Block(this.global(), new $colon$colon<Nothing$>((Nothing$)((Object)expr), Nil$.MODULE$), this.mkLiteralUnit());
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public Trees.Tree mkTupleType(List<Trees.Tree> elems, boolean flattenUnary) {
        void var3_6;
        if (((Object)Nil$.MODULE$).equals(elems)) {
            Trees.Select select = this.scalaDot(this.global().tpnme().Unit());
            return var3_6;
        }
        Some<List<Trees.Tree>> some = List$.MODULE$.unapplySeq(elems);
        if (!some.isEmpty() && some.get() != null && ((LinearSeqOptimized)some.get()).lengthCompare(1) == 0) {
            Trees.Tree tree = (Trees.Tree)((LinearSeqOptimized)some.get()).apply(0);
            if (flattenUnary) {
                Trees.Tree tree2 = tree;
                return var3_6;
            }
        }
        Trees.AppliedTypeTree appliedTypeTree = new Trees.AppliedTypeTree(this.global(), this.scalaDot(this.global().definitions().TupleClass().apply(elems.length()).name()), elems);
        return var3_6;
    }

    public boolean mkTupleType$default$2() {
        return true;
    }

    public Trees.Tree mkAnd(Trees.Tree tree1, Trees.Tree tree2) {
        return new Trees.Apply(this.global(), this.global().Select(tree1, this.global().definitions().Boolean_and()), new $colon$colon<Nothing$>((Nothing$)((Object)tree2), Nil$.MODULE$));
    }

    public Trees.Tree mkOr(Trees.Tree tree1, Trees.Tree tree2) {
        return new Trees.Apply(this.global(), this.global().Select(tree1, this.global().definitions().Boolean_or()), new $colon$colon<Nothing$>((Nothing$)((Object)tree2), Nil$.MODULE$));
    }

    public Trees.Tree mkRuntimeUniverseRef() {
        Symbols.Symbol symbol = this.global().definitions().ReflectRuntimeUniverse();
        Symbols.NoSymbol noSymbol = this.global().NoSymbol();
        this.global().assert(symbol == null ? noSymbol != null : !symbol.equals(noSymbol));
        return ((Trees.Tree)((Object)this.mkAttributedRef(this.global().definitions().ReflectRuntimeUniverse()))).setType(this.global().singleType(this.global().definitions().ReflectRuntimeUniverse().owner().thisPrefix(), this.global().definitions().ReflectRuntimeUniverse()));
    }

    public Trees.Apply mkSeqApply(Trees.Tree arg) {
        Trees.Select factory2 = new Trees.Select(this.global(), (Trees.Tree)((Object)this.mkAttributedRef(this.global().definitions().SeqModule())), this.global().nme().apply());
        return new Trees.Apply(this.global(), factory2, new $colon$colon<Nothing$>((Nothing$)((Object)arg), Nil$.MODULE$));
    }

    public Trees.Select mkSuperInitCall() {
        return new Trees.Select(this.global(), new Trees.Super(this.global(), new Trees.This(this.global(), (Names.TypeName)this.global().tpnme().EMPTY()), (Names.TypeName)this.global().tpnme().EMPTY()), this.global().nme().CONSTRUCTOR());
    }

    /*
     * WARNING - void declaration
     */
    public Trees.Template mkTemplate(List<Trees.Tree> parents, Trees.ValDef self, Trees.Modifiers constrMods, List<List<Trees.ValDef>> vparamss, List<Trees.Tree> body, Position superPos) {
        Option constr;
        Option option;
        void var14_19;
        void var13_18;
        void var9_14;
        void var8_13;
        void var25_11;
        Trees.Tree tree2;
        void mmap_f;
        Function1<Trees.ValDef, Trees.ValDef> & java.io.Serializable & Serializable intersect = (Function1<Trees.ValDef, Trees.ValDef> & java.io.Serializable & Serializable)vd -> {
            Trees.Modifiers mods = (Trees.Modifiers)this.global().Modifiers(BoxesRunTime.boxToLong(vd.mods().flags() & 0x2010200L | 0x2000L | 0x20000000L));
            return this.global().atPos(vd.pos().makeTransparent(), new Trees.ValDef(this.global(), mods.withAnnotations(vd.mods().annotations()), vd.name(), vd.tpt().duplicate(), this.global().duplicateAndKeepPositions(vd.rhs())));
        };
        if (this.global() == null) {
            throw null;
        }
        List list = vparamss.map(arg_0 -> Collections.$anonfun$mmap$1((Function1)mmap_f, arg_0), List$.MODULE$.canBuildFrom());
        List<Object> vparamss1 = list;
        if (body == null) {
            throw null;
        }
        ListBuffer span_b = new ListBuffer();
        List span_these = body;
        while (!span_these.isEmpty() && TreeGen.$anonfun$mkTemplate$2(this, tree2 = span_these.head())) {
            span_b.$plus$eq(span_these.head());
            span_these = (List)span_these.tail();
        }
        List edefs = span_b.toList();
        void rest = var25_11;
        void edefs2 = var8_13;
        void rest2 = var9_14;
        Tuple2 tuple2 = edefs2.partition((Function1<Trees.Tree, Object> & java.io.Serializable & Serializable)tree -> BoxesRunTime.boxToBoolean(TreeGen.$anonfun$mkTemplate$3(this, tree)));
        if (tuple2 == null) {
            throw new MatchError((Object)null);
        }
        List evdefs = (List)tuple2._1();
        List etdefs = (List)tuple2._2();
        void evdefs2 = var13_18;
        void etdefs2 = var14_19;
        List gvdefs = evdefs2.map((Function1<Trees.Tree, Trees.ValDef> & java.io.Serializable & Serializable)x0$1 -> {
            if (!(x0$1 instanceof Trees.ValDef)) {
                throw new MatchError(x0$1);
            }
            Trees.ValDef valDef = (Trees.ValDef)x0$1;
            Trees.Tree tpt = valDef.tpt();
            Trees.TypeTree x$2 = (Trees.TypeTree)this.global().atPos(valDef.pos().focus(), (Trees.Tree)new Trees.TypeTree(this.global()).setOriginal(tpt).setPos(tpt.pos().focus()));
            Trees$EmptyTree$ x$3 = this.global().EmptyTree();
            Trees.Modifiers x$4 = this.global().copyValDef$default$2(valDef);
            Names.Name x$5 = this.global().copyValDef$default$3(valDef);
            Trees.ValDef valDef2 = this.global().copyValDef(valDef, x$4, x$5, x$2, x$3);
            return valDef2;
        }, List$.MODULE$.canBuildFrom());
        List<Trees.Tree> lvdefs = evdefs2.collect(new Serializable(this){
            public static final long serialVersionUID = 0L;
            private final /* synthetic */ TreeGen $outer;

            public final <A1 extends Trees.Tree, B1> B1 applyOrElse(A1 x1, Function1<A1, B1> function1) {
                Object object;
                if (x1 instanceof Trees.ValDef) {
                    Trees.ValDef valDef = (Trees.ValDef)x1;
                    Trees.Modifiers x$2 = valDef.mods().$bar(0x2000000000L);
                    Names.Name x$3 = this.$outer.global().copyValDef$default$3(valDef);
                    Trees.Tree x$4 = this.$outer.global().copyValDef$default$4(valDef);
                    Trees.Tree x$5 = this.$outer.global().copyValDef$default$5(valDef);
                    object = this.$outer.global().copyValDef(valDef, x$2, x$3, x$4, x$5);
                } else {
                    object = function1.apply(x1);
                }
                return object;
            }

            public final boolean isDefinedAt(Trees.Tree x1) {
                boolean bl = x1 instanceof Trees.ValDef;
                return bl;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
            }
        }, List$.MODULE$.canBuildFrom());
        if (constrMods.isTrait()) {
            boolean bl;
            block11: {
                LinearSeqOptimized forall_these = body;
                while (!forall_these.isEmpty()) {
                    Trees.Tree tree3 = (Trees.Tree)forall_these.head();
                    if (!TreeGen.$anonfun$mkTemplate$5(this, tree3)) {
                        bl = false;
                        break block11;
                    }
                    forall_these = (LinearSeqOptimized)forall_these.tail();
                }
                bl = true;
            }
            option = bl ? None$.MODULE$ : new Some<Trees.DefDef>(this.global().atPos(this.global().wrappingPos(superPos, lvdefs), new Trees.DefDef(this.global(), (Trees.Modifiers)this.global().NoMods(), this.global().nme().MIXIN_CONSTRUCTOR(), Nil$.MODULE$, package$.MODULE$.ListOfNil(), new Trees.TypeTree(this.global()), new Trees.Block(this.global(), lvdefs, this.mkLiteralUnit()))));
        } else {
            if (list.isEmpty() || !((SeqLike)list.head()).isEmpty() && ((Trees.ValDef)((IterableLike)list.head()).head()).mods().isImplicit()) {
                Nil$ nil$ = Nil$.MODULE$;
                vparamss1 = list.$colon$colon(nil$);
            }
            Trees$pendingSuperCall$ superCall = this.global().pendingSuperCall();
            option = constr = new Some<Trees.DefDef>(this.global().atPos(this.global().wrappingPos(superPos, ((List)vparamss1.flatten((Function1)Predef$.MODULE$.$conforms())).$colon$colon$colon(lvdefs)).makeTransparent(), new Trees.DefDef(this.global(), constrMods, this.global().nme().CONSTRUCTOR(), Nil$.MODULE$, vparamss1, new Trees.TypeTree(this.global()), new Trees.Block(this.global(), new $colon$colon<Nothing$>((Nothing$)((Object)superCall), Nil$.MODULE$).$colon$colon$colon(lvdefs), this.mkLiteralUnit()))));
        }
        if (constr == null) {
            throw null;
        }
        if (!constr.isEmpty()) {
            Trees.DefDef defDef = (Trees.DefDef)constr.get();
            TreeGen.$anonfun$mkTemplate$6(this, parents, gvdefs, defDef);
        }
        List fieldDefs = ((List)vparamss.flatten((Function1)Predef$.MODULE$.$conforms())).map((Function1<Trees.ValDef, Trees.ValDef> & java.io.Serializable & Serializable)vd -> {
            void var2_6;
            Trees.Modifiers x$7 = vd.mods().$amp$tilde(0x2000000L);
            Trees$EmptyTree$ x$8 = this.global().EmptyTree();
            Names.Name x$9 = this.global().copyValDef$default$3((Trees.Tree)vd);
            Trees.Tree x$10 = this.global().copyValDef$default$4((Trees.Tree)vd);
            Trees.ValDef field2 = this.global().copyValDef((Trees.Tree)vd, x$7, x$9, x$10, x$8);
            if (field2.pos().isRange() && vd.rhs().pos().isRange()) {
                field2.pos_$eq(field2.pos().withEnd(vd.rhs().pos().start() - 1));
            }
            return var2_6;
        }, List$.MODULE$.canBuildFrom());
        List list2 = etdefs2.$plus$plus$colon(Option$.MODULE$.option2Iterable(constr), List$.MODULE$.canBuildFrom());
        return new Trees.Template(this.global(), parents, self, rest2.$colon$colon$colon(list2).$colon$colon$colon(fieldDefs).$colon$colon$colon(gvdefs));
    }

    public Position mkTemplate$default$6() {
        return this.global().NoPosition();
    }

    public List<Trees.Tree> mkParents(Trees.Modifiers ownerMods, List<Trees.Tree> parents, Position parentPos) {
        if (ownerMods.isCase()) {
            return new $colon$colon<Nothing$>((Nothing$)((Object)this.scalaDot(this.global().tpnme().Product())), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)this.scalaDot(this.global().tpnme().Serializable())), Nil$.MODULE$)).$colon$colon$colon(parents);
        }
        if (parents.isEmpty()) {
            Trees.Select select = this.global().atPos(parentPos, this.scalaAnyRefConstr());
            return Nil$.MODULE$.$colon$colon(select);
        }
        return parents;
    }

    public Position mkParents$default$3() {
        return this.global().NoPosition();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public Trees.ClassDef mkClassDef(Trees.Modifiers mods, Names.TypeName name, List<Trees.TypeDef> tparams, Trees.Template templ) {
        block5: {
            if (!mods.isTrait()) ** GOTO lbl-1000
            v0 = templ.body();
            if (v0 == null) {
                throw null;
            }
            forall_these /* !! */  = v0;
            while (!forall_these /* !! */ .isEmpty()) {
                var8_6 = (Trees.Tree)forall_these /* !! */ .head();
                if (!TreeGen.$anonfun$mkClassDef$1(this, var8_6)) {
                    var7_7 = false;
                    break block5;
                }
                forall_these /* !! */  = (LinearSeqOptimized)forall_these /* !! */ .tail();
            }
            var7_7 = true;
        }
        if (var7_7) {
            v1 = true;
        } else lbl-1000:
        // 2 sources

        {
            v1 = false;
        }
        mods1 = v1 != false ? mods.$bar(128) : mods;
        return new Trees.ClassDef(this.global(), mods1, name, tparams, templ);
    }

    public Trees.Tree mkNew(List<Trees.Tree> parents, Trees.ValDef self, List<Trees.Tree> stats, Position npos, Position cpos) {
        if (parents.isEmpty()) {
            return this.mkNew(new $colon$colon<Nothing$>((Nothing$)((Object)this.scalaAnyRefConstr()), Nil$.MODULE$), self, stats, npos, cpos);
        }
        if (((SeqLike)parents.tail()).isEmpty() && stats.isEmpty()) {
            TreeInfo.Applied app = this.global().treeInfo().dissectApplied(parents.head());
            return this.global().atPos(npos.union(cpos), this.global().New(app.callee(), app.argss()));
        }
        Names.TypeName x = (Names.TypeName)this.global().tpnme().ANON_CLASS_NAME();
        return this.global().atPos(npos.union(cpos), new Trees.Block(this.global(), new $colon$colon<Nothing$>((Nothing$)((Object)this.global().atPos(cpos, new Trees.ClassDef(this.global(), (Trees.Modifiers)this.global().Modifiers(BoxesRunTime.boxToLong(32L)), x, Nil$.MODULE$, this.mkTemplate(parents, self, (Trees.Modifiers)this.global().NoMods(), package$.MODULE$.ListOfNil(), stats, cpos.focus())))), Nil$.MODULE$), this.global().atPos(npos, this.global().New((Trees.Tree)new Trees.Ident(this.global(), x).setPos(npos.focus()), (List<List<Trees.Tree>>)Nil$.MODULE$))));
    }

    public Trees.Tree mkFunctionTypeTree(List<Trees.Tree> argtpes, Trees.Tree restpe) {
        return new Trees.AppliedTypeTree(this.global(), this.rootScalaDot(this.global().newTypeName(new StringBuilder(8).append("Function").append(argtpes.length()).toString())), new $colon$colon<Nothing$>((Nothing$)((Object)restpe), Nil$.MODULE$).$colon$colon$colon(argtpes));
    }

    public Trees.Literal mkSyntheticUnit() {
        return (Trees.Literal)this.mkLiteralUnit().updateAttachment(this.global().SyntheticUnitAttachment(), ClassTag$.MODULE$.apply(StdAttachments$SyntheticUnitAttachment$.class));
    }

    public Trees.Tree mkBlock(List<Trees.Tree> stats, boolean doFlatten) {
        if (stats.isEmpty()) {
            return this.mkSyntheticUnit();
        }
        if (!stats.last().isTerm()) {
            return new Trees.Block(this.global(), stats, this.mkSyntheticUnit());
        }
        if (stats.length() == 1 && doFlatten) {
            return stats.head();
        }
        return new Trees.Block(this.global(), (List)stats.init(), stats.last());
    }

    public boolean mkBlock$default$2() {
        return true;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public Trees.Tree mkTreeOrBlock(List<Trees.Tree> stats) {
        void var2_5;
        if (((Object)Nil$.MODULE$).equals(stats)) {
            Trees$EmptyTree$ trees$EmptyTree$ = this.global().EmptyTree();
            return var2_5;
        }
        if (stats instanceof $colon$colon) {
            $colon$colon $colon$colon = ($colon$colon)stats;
            Trees.Tree head = (Trees.Tree)$colon$colon.head();
            List list = $colon$colon.tl$access$1();
            if (((Object)Nil$.MODULE$).equals(list)) {
                Trees.Tree tree = head;
                return var2_5;
            }
        }
        Trees.Tree tree = this.mkBlock(stats, this.mkBlock$default$2());
        return var2_5;
    }

    public Trees.Tree mkAssign(Trees.Tree lhs, Trees.Tree rhs) {
        Trees.Tree tree;
        if (lhs instanceof Trees.Apply) {
            Trees.Apply apply2 = (Trees.Apply)lhs;
            Trees.Tree fn = apply2.fun();
            List<Trees.Tree> args2 = apply2.args();
            tree = new Trees.Apply(this.global(), this.global().atPos(fn.pos(), new Trees.Select(this.global(), fn, this.global().nme().update())), args2.$colon$plus(rhs, List$.MODULE$.canBuildFrom()));
        } else {
            tree = new Trees.Assign(this.global(), lhs, rhs);
        }
        return tree;
    }

    public Trees.PackageDef mkPackageObject(Trees.ModuleDef defn, Position pidPos, Position pkgPos) {
        Names.TermName x$2 = this.global().nme().PACKAGEkw();
        Trees.Modifiers x$3 = this.global().copyModuleDef$default$2(defn);
        Trees.Template x$4 = this.global().copyModuleDef$default$4(defn);
        Trees.ModuleDef module = this.global().copyModuleDef(defn, x$3, x$2, x$4);
        Trees.Ident pid = this.global().atPos(pidPos, new Trees.Ident(this.global(), defn.name()));
        return this.global().atPos(pkgPos, new Trees.PackageDef(this.global(), pid, Nil$.MODULE$.$colon$colon(module)));
    }

    public Position mkPackageObject$default$2() {
        return this.global().NoPosition();
    }

    public Position mkPackageObject$default$3() {
        return this.global().NoPosition();
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public Trees.Tree mkFor(List<Trees.Tree> enums, Trees.Tree sugarBody, FreshNameCreator fresh) {
        void var4_24;
        void var9_11;
        Names.TermName termName;
        Names.TermName termName2;
        Trees.Tree tree;
        Option<Trees.Tree> option = this.Yield().unapply(sugarBody);
        if (!option.isEmpty()) {
            Trees.Tree tree2;
            tree = tree2 = option.get();
            termName2 = this.global().nme().flatMap();
            termName = this.global().nme().map();
        } else {
            tree = sugarBody;
            termName2 = this.global().nme().foreach();
            termName = this.global().nme().foreach();
        }
        Names.TermName mapName = termName;
        Names.TermName flatMapName = termName2;
        Trees.Tree body = tree;
        boolean bl = false;
        $colon$colon $colon$colon = null;
        if (enums instanceof $colon$colon) {
            bl = true;
            $colon$colon = ($colon$colon)enums;
            Trees.Tree t = (Trees.Tree)$colon$colon.head();
            List list = $colon$colon.tl$access$1();
            Option<Tuple2<Trees.Tree, Trees.Tree>> option2 = this.ValFrom().unapply(t);
            if (!option2.isEmpty()) {
                Trees.Tree pat2 = option2.get()._1();
                Trees.Tree rhs2 = option2.get()._2();
                if (((Object)Nil$.MODULE$).equals(list)) {
                    void var7_9;
                    Trees.Tree tree3 = this.makeCombination$1(this.closurePos$1(t.pos(), (Trees.Tree)var9_11), (Names.TermName)var7_9, rhs2, pat2, (Trees.Tree)var9_11, fresh);
                    return var4_24;
                }
            }
        }
        if (bl) {
            Trees.Tree t = (Trees.Tree)$colon$colon.head();
            List rest = $colon$colon.tl$access$1();
            Option<Tuple2<Trees.Tree, Trees.Tree>> option3 = this.ValFrom().unapply(t);
            if (!option3.isEmpty()) {
                Trees.Tree pat3 = option3.get()._1();
                Trees.Tree rhs3 = option3.get()._2();
                if (rest instanceof $colon$colon) {
                    $colon$colon $colon$colon2 = ($colon$colon)rest;
                    Trees.Tree tree4 = (Trees.Tree)$colon$colon2.head();
                    if (!this.ValFrom().unapply(tree4).isEmpty()) {
                        void var8_10;
                        Trees.Tree tree5 = this.makeCombination$1(this.closurePos$1(t.pos(), (Trees.Tree)var9_11), (Names.TermName)var8_10, rhs3, pat3, this.mkFor($colon$colon2, sugarBody, fresh), fresh);
                        return var4_24;
                    }
                }
            }
        }
        if (bl) {
            Trees.Tree t = (Trees.Tree)$colon$colon.head();
            List list = $colon$colon.tl$access$1();
            Option<Tuple2<Trees.Tree, Trees.Tree>> option4 = this.ValFrom().unapply(t);
            if (!option4.isEmpty()) {
                Trees.Tree pat4 = option4.get()._1();
                Trees.Tree rhs4 = option4.get()._2();
                if (list instanceof $colon$colon) {
                    $colon$colon $colon$colon3 = ($colon$colon)list;
                    Trees.Tree tree6 = (Trees.Tree)$colon$colon3.head();
                    List<Trees.Tree> rest = $colon$colon3.tl$access$1();
                    Option<Trees.Tree> option5 = this.Filter().unapply(tree6);
                    if (!option5.isEmpty()) {
                        Trees.Tree test = option5.get();
                        Trees.Tree tree7 = (Trees.Tree)this.ValFrom().apply(pat4, this.makeCombination$1(rhs4.pos().union(test.pos()), this.global().nme().withFilter(), rhs4, pat4.duplicate(), test, fresh)).setPos(t.pos());
                        Trees.Tree tree8 = this.mkFor(rest.$colon$colon(tree7), sugarBody, fresh);
                        return var4_24;
                    }
                }
            }
        }
        if (bl) {
            Trees.Tree t = (Trees.Tree)$colon$colon.head();
            List rest = $colon$colon.tl$access$1();
            Option<Tuple2<Trees.Tree, Trees.Tree>> option6 = this.ValFrom().unapply(t);
            if (!option6.isEmpty()) {
                void var64_67;
                Trees.Tree tree9;
                Trees.Tree pat5 = option6.get()._1();
                Trees.Tree rhs5 = option6.get()._2();
                Object object = rest.take(this.global().definitions().MaxTupleArity() - 1);
                if (object == null) {
                    throw null;
                }
                Object takeWhile_this = object;
                ListBuffer takeWhile_b = new ListBuffer();
                Object takeWhile_these = takeWhile_this;
                while (!((List)takeWhile_these).isEmpty() && TreeGen.$anonfun$mkFor$1(this, tree9 = (Trees.Tree)((List)takeWhile_these).head())) {
                    takeWhile_b.$plus$eq(((List)takeWhile_these).head());
                    takeWhile_these = (List)((AbstractTraversable)takeWhile_these).tail();
                }
                List<?> list = takeWhile_b.toList();
                this.global().assert(!list.isEmpty());
                Object rest1 = rest.drop(list.length());
                List<?> pats = list.map((Function1<Trees.Tree, Trees.Tree> & java.io.Serializable & Serializable)x0$1 -> {
                    void var3_3;
                    Option<Tuple2<Trees.Tree, Trees.Tree>> option = this.ValEq().unapply((Trees.Tree)x0$1);
                    if (option.isEmpty()) {
                        throw new MatchError(x0$1);
                    }
                    Trees.Tree pat = option.get()._1();
                    return var3_3;
                }, List$.MODULE$.canBuildFrom());
                List rhss = list.map((Function1<Trees.Tree, Trees.Tree> & java.io.Serializable & Serializable)x0$2 -> {
                    void var3_3;
                    Option<Tuple2<Trees.Tree, Trees.Tree>> option = this.ValEq().unapply((Trees.Tree)x0$2);
                    if (option.isEmpty()) {
                        throw new MatchError(x0$2);
                    }
                    Trees.Tree rhs = option.get()._2();
                    return var3_3;
                }, List$.MODULE$.canBuildFrom());
                Trees.Tree defpat1 = this.makeBind$1(pat5, fresh);
                List defpats = pats.map((Function1<Trees.Tree, Trees.Tree> & java.io.Serializable & Serializable)pat -> this.makeBind$1((Trees.Tree)pat, fresh), List$.MODULE$.canBuildFrom());
                Tuple2Zipped$ tuple2Zipped$ = Tuple2Zipped$.MODULE$;
                CanBuildFrom canBuildFrom = List$.MODULE$.canBuildFrom();
                Function2<Trees.Tree, Trees.Tree, List> & java.io.Serializable & Serializable intersect = (Function2<Trees.Tree, Trees.Tree, List> & java.io.Serializable & Serializable)(pat, rhs) -> this.mkPatDef((Trees.Tree)pat, (Trees.Tree)rhs, fresh);
                Tuple2 tuple2 = Tuple2Zipped$Ops$.MODULE$.zipped$extension(Predef$.MODULE$.tuple2ToZippedOps(new Tuple2(defpats, rhss)), Predef$.MODULE$.$conforms(), Predef$.MODULE$.$conforms());
                if (tuple2Zipped$ == null) {
                    throw null;
                }
                Tuple2Zipped$ flatMap$extension_this = tuple2Zipped$;
                Object object2 = new Object();
                try {
                    void flatMap$extension_f;
                    void flatMap$extension_$this;
                    void flatMap$extension_cbf;
                    Builder flatMap$extension_b = flatMap$extension_cbf.apply(flatMap$extension_this.coll1$extension(flatMap$extension_$this).repr());
                    Iterator flatMap$extension_elems2 = flatMap$extension_this.coll2$extension(flatMap$extension_$this).iterator();
                    flatMap$extension_this.coll1$extension(flatMap$extension_$this).foreach(arg_0 -> Tuple2Zipped$.$anonfun$flatMap$1(flatMap$extension_elems2, flatMap$extension_b, (Function2)flatMap$extension_f, object2, arg_0));
                    Object To = flatMap$extension_b.result();
                }
                catch (NonLocalReturnControl flatMap$extension_ex) {
                    if (flatMap$extension_ex.key() != object2) throw flatMap$extension_ex;
                    Object t2 = flatMap$extension_ex.value();
                }
                List pdefs = (List)var64_67;
                List<Trees.Tree> ids = defpats.$colon$colon(defpat1).map((Function1<Trees.Tree, Trees.Tree> & java.io.Serializable & Serializable)pat -> this.makeValue$1((Trees.Tree)pat), List$.MODULE$.canBuildFrom());
                Trees.Tree rhs1 = this.mkFor(new $colon$colon<Nothing$>((Nothing$)((Object)((Trees.Tree)this.ValFrom().apply(defpat1, rhs5).setPos(t.pos()))), Nil$.MODULE$), this.Yield().apply((Trees.Tree)new Trees.Block(this.global(), pdefs, this.global().atPos((Position)this.global().wrappingPos((List)ids), this.mkTuple(ids, this.mkTuple$default$2()))).setPos((Position)this.global().wrappingPos(pdefs))), fresh);
                List<Trees.Tree> allpats = pats.$colon$colon(pat5).map((Function1<Trees.Tree, Trees.Tree> & java.io.Serializable & Serializable)x$26 -> x$26.duplicate(), List$.MODULE$.canBuildFrom());
                Position position = t.pos();
                NoPosition$ noPosition$ = this.global().NoPosition();
                NoPosition$ pos1 = !(position != null ? !position.equals(noPosition$) : noPosition$ != null) ? this.global().NoPosition() : this.global().rangePos(t.pos().source(), t.pos().start(), t.pos().point(), rhs1.pos().end());
                Trees.Tree vfrom1 = (Trees.Tree)this.ValFrom().apply(this.global().atPos((Position)this.global().wrappingPos((List)allpats), this.mkTuple(allpats, this.mkTuple$default$2())), rhs1).setPos(pos1);
                Trees.Tree tree10 = this.mkFor(((List)rest1).$colon$colon(vfrom1), sugarBody, fresh);
                return var4_24;
            }
        }
        Trees$EmptyTree$ trees$EmptyTree$ = this.global().EmptyTree();
        return var4_24;
    }

    public List<Trees.ValDef> mkPatDef(Trees.Tree pat, Trees.Tree rhs, FreshNameCreator fresh) {
        return this.mkPatDef((Trees.Modifiers)this.global().Modifiers(BoxesRunTime.boxToLong(0L)), pat, rhs, fresh);
    }

    private Trees.ValDef propagateNoWarnAttachment(Trees.Tree from, Trees.ValDef to) {
        if (this.isPatVarWarnable() && from.hasAttachment(ClassTag$.MODULE$.apply(StdAttachments$NoWarnAttachment$.class))) {
            return (Trees.ValDef)to.updateAttachment(this.global().NoWarnAttachment(), ClassTag$.MODULE$.apply(StdAttachments$NoWarnAttachment$.class));
        }
        return to;
    }

    private Trees.ValDef propagatePatVarDefAttachments(Trees.Tree from, Trees.ValDef to) {
        return (Trees.ValDef)this.propagateNoWarnAttachment(from, to).updateAttachment(this.global().PatVarDefAttachment(), ClassTag$.MODULE$.apply(StdAttachments$PatVarDefAttachment$.class));
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public List<Trees.ValDef> mkPatDef(Trees.Modifiers mods, Trees.Tree pat, Trees.Tree rhs, FreshNameCreator fresh) {
        block5: {
            block6: {
                block4: {
                    var7_5 = this.matchVarPattern(pat);
                    if (!(var7_5 instanceof Some) || (var8_6 = (Tuple2)((Some)var7_5).value()) == null) break block4;
                    name = (Names.Name)var8_6._1();
                    tpt = (Trees.Tree)var8_6._2();
                    var5_9 /* !! */  = new $colon$colon<Nothing$>((Nothing$)this.global().atPos(pat.pos().union(rhs.pos()), this.propagateNoWarnAttachment(pat, new Trees.ValDef(this.global(), mods, name.toTermName(), tpt, rhs))), Nil$.MODULE$);
                    break block5;
                }
                if (!None$.MODULE$.equals(var7_5)) break block6;
                rhsUnchecked = this.mkUnchecked(rhs);
                var12_11 = this.patvarTransformer().transform(pat);
                if (!(var12_11 instanceof Trees.Typed)) ** GOTO lbl-1000
                var13_12 = (Trees.Typed)var12_11;
                expr = var13_12.expr();
                tpt = var13_12.tpt();
                if (!(expr instanceof Trees.Ident)) {
                    var31_16 = rhsTypedUnchecked = tpt.isEmpty() != false ? rhsUnchecked : (Trees.Tree)new Trees.Typed(this.global(), rhsUnchecked, tpt).setPos(rhs.pos().union(tpt.pos()));
                    var30_17 = expr;
                } else lbl-1000:
                // 2 sources

                {
                    var31_16 = rhsUnchecked;
                    var30_17 = var12_11;
                }
                pat1 = var30_17;
                rhs1 = var31_16;
                vars = this.getVariables((Trees.Tree)var17_18);
                matchExpr = this.global().atPos(var17_18.pos().union(rhs.pos()).makeTransparent(), new Trees.Match(this.global(), (Trees.Tree)var18_19, new $colon$colon<Nothing$>((Nothing$)this.global().atPos(var17_18.pos(), new Trees.CaseDef(this.global(), (Trees.Tree)var17_18, this.global().EmptyTree(), this.mkTuple(vars.map((Function1<Tuple4, Names.Name> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$mkPatDef$1(scala.Tuple4 ), (Lscala/Tuple4;)Lscala/reflect/internal/Names$Name;)(), List$.MODULE$.canBuildFrom()).map((Function1<Names.Name, Trees.Ident> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$mkPatDef$2(scala.reflect.internal.TreeGen scala.reflect.internal.Names$Name ), (Lscala/reflect/internal/Names$Name;)Lscala/reflect/internal/Trees$Ident;)((TreeGen)this), List$.MODULE$.canBuildFrom()), this.mkTuple$default$2()))), Nil$.MODULE$)));
                var21_22 = List$.MODULE$.unapplySeq(vars);
                if (!var21_22.isEmpty() && var21_22.get() != null && ((LinearSeqOptimized)var21_22.get()).lengthCompare(1) == 0 && (var22_23 = (Tuple4)((LinearSeqOptimized)var21_22.get()).apply(0)) != null) {
                    vname = (Names.Name)var22_23._1();
                    tpt = (Trees.Tree)var22_23._2();
                    pos = (Position)var22_23._3();
                    original = (Trees.Tree)var22_23._4();
                    var6_28 = new $colon$colon<Nothing$>((Nothing$)this.global().atPos(pat.pos().union(pos).union(rhs.pos()), this.propagatePatVarDefAttachments(original, new Trees.ValDef(this.global(), mods, vname.toTermName(), tpt, matchExpr))), Nil$.MODULE$);
                } else {
                    tmp = this.global().freshTermName(this.global().freshTermName$default$1(), fresh);
                    firstDef = this.global().atPos(matchExpr.pos(), new Trees.ValDef(this.global(), (Trees.Modifiers)this.global().Modifiers(BoxesRunTime.boxToLong(70368746799108L | mods.flags() & 0x80000000L)), tmp, new Trees.TypeTree(this.global()), matchExpr));
                    cnt = IntRef.create(0);
                    var6_28 = vars.withFilter((Function1<Tuple4<Names.Name, Trees.Tree, Position, Trees.Tree>, Object>)(Function1<Tuple4, Object> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$mkPatDef$3$adapted(scala.Tuple4 ), (Lscala/Tuple4;)Ljava/lang/Object;)()).map((Function1<Tuple4, Trees.ValDef> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$mkPatDef$4(scala.reflect.internal.TreeGen scala.runtime.IntRef scala.reflect.internal.Trees$Modifiers scala.reflect.internal.Names$TermName scala.Tuple4 ), (Lscala/Tuple4;)Lscala/reflect/internal/Trees$ValDef;)((TreeGen)this, (IntRef)cnt, (Trees.Modifiers)mods, (Names.TermName)tmp), List$.MODULE$.canBuildFrom()).$colon$colon(firstDef);
                }
                var5_9 /* !! */  = var6_28;
                break block5;
            }
            throw new MatchError(var7_5);
        }
        return var5_9 /* !! */ ;
    }

    public Trees.Tree mkGenerator(Position pos, Trees.Tree pat, boolean valeq, Trees.Tree rhs, FreshNameCreator fresh) {
        Trees.Tree pat1 = this.patvarTransformerForFor().transform(pat);
        if (valeq) {
            return (Trees.Tree)this.ValEq().apply(pat1, rhs).setPos(pos);
        }
        return (Trees.Tree)this.ValFrom().apply(pat1, this.mkCheckIfRefutable(pat1, rhs, fresh)).setPos(pos);
    }

    private Trees.Tree unwarnable(Trees.Tree pat) {
        pat.foreach((Function1<Trees.Tree, BoxedUnit>)(Function1<Trees.Tree, Object> & java.io.Serializable & Serializable)x0$1 -> {
            TreeGen.$anonfun$unwarnable$1(this, x0$1);
            return BoxedUnit.UNIT;
        });
        return pat;
    }

    public Trees.Tree mkCheckIfRefutable(Trees.Tree pat, Trees.Tree rhs, FreshNameCreator fresh) {
        if (this.global().treeInfo().isVarPatternDeep(pat)) {
            return rhs;
        }
        $colon$colon<Nothing$> cases = new $colon$colon<Nothing$>((Nothing$)((Object)new Trees.CaseDef(this.global(), this.unwarnable(pat.duplicate()), this.global().EmptyTree(), new Trees.Literal(this.global(), new Constants.Constant(this.global(), BoxesRunTime.boxToBoolean(true))))), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)new Trees.CaseDef(this.global(), new Trees.Ident(this.global(), this.global().nme().WILDCARD()), this.global().EmptyTree(), new Trees.Literal(this.global(), new Constants.Constant(this.global(), BoxesRunTime.boxToBoolean(false))))), Nil$.MODULE$));
        Trees.Tree visitor = this.mkVisitor(cases, false, this.global().nme().CHECK_IF_REFUTABLE_STRING(), fresh);
        return this.global().atPos(rhs.pos(), new Trees.Apply(this.global(), new Trees.Select(this.global(), rhs, this.global().nme().withFilter()), Nil$.MODULE$.$colon$colon(visitor)));
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private Option<Tuple2<Names.Name, Trees.Tree>> matchVarPattern(Trees.Tree tree) {
        void var2_7;
        if (tree instanceof Trees.Ident) {
            Names.Name name = ((Trees.Ident)tree).name();
            Some<Tuple2<Names.Name, Trees.TypeTree>> some = new Some<Tuple2<Names.Name, Trees.TypeTree>>(new Tuple2<Names.Name, Trees.TypeTree>(name, new Trees.TypeTree(this.global())));
            return var2_7;
        }
        if (tree instanceof Trees.Bind) {
            void var12_14;
            Trees.Bind bind = (Trees.Bind)tree;
            Names.Name name = bind.name();
            Trees.Tree body = bind.body();
            Option option = this.wildType$1(body);
            if (option == null) {
                throw null;
            }
            Option map_this = option;
            if (map_this.isEmpty()) {
                None$ none$ = None$.MODULE$;
            } else {
                Trees.Tree tree2 = (Trees.Tree)map_this.get();
                Some<Tuple2> some = new Some<Tuple2>(TreeGen.$anonfun$matchVarPattern$1(name, tree2));
            }
            void var2_4 = var12_14;
            return var2_7;
        }
        if (tree instanceof Trees.Typed) {
            Trees.Typed typed = (Trees.Typed)tree;
            Trees.Tree tree3 = typed.expr();
            Trees.Tree tpt = typed.tpt();
            if (tree3 instanceof Trees.Ident) {
                Names.Name name = ((Trees.Ident)tree3).name();
                Some<Tuple2<Names.Name, Trees.Tree>> some = new Some<Tuple2<Names.Name, Trees.Tree>>(new Tuple2<Names.Name, Trees.Tree>(name, tpt));
                return var2_7;
            }
        }
        None$ none$ = None$.MODULE$;
        return var2_7;
    }

    public Trees.Tree mkVisitor(List<Trees.CaseDef> cases, boolean checkExhaustive, String prefix, FreshNameCreator fresh) {
        Names.TermName x = this.global().freshTermName(prefix, fresh);
        Trees.Ident id = new Trees.Ident(this.global(), x);
        Trees.Ident sel = checkExhaustive ? id : this.mkUnchecked(id);
        return new Trees.Function(this.global(), new $colon$colon<Nothing$>((Nothing$)((Object)this.mkSyntheticParam(x)), Nil$.MODULE$), new Trees.Match(this.global(), sel, cases));
    }

    public String mkVisitor$default$3() {
        return "x$";
    }

    private List<Tuple4<Names.Name, Trees.Tree, Position, Trees.Tree>> getVariables(Trees.Tree tree) {
        return new GetVarTraverser().apply(tree);
    }

    public boolean isPatVarWarnable() {
        return true;
    }

    public Trees.Tree mkUnchecked(Trees.Tree expr) {
        return this.global().atPos(expr.pos(), new Trees.Annotated(this.global(), this.global().New(this.scalaDot(this.global().tpnme().unchecked()), (List<List<Trees.Tree>>)Nil$.MODULE$), expr));
    }

    public Trees.ValDef mkSyntheticParam(Names.TermName pname) {
        return new Trees.ValDef(this.global(), (Trees.Modifiers)this.global().Modifiers(BoxesRunTime.boxToLong(0x202000L)), pname, new Trees.TypeTree(this.global()), this.global().EmptyTree());
    }

    public Trees.Tree mkCast(Trees.Tree tree, Types.Type pt) {
        return this.global().atPos(tree.pos(), this.mkAsInstanceOf(tree, pt, true, false));
    }

    private final void ValFrom$lzycompute$1() {
        synchronized (this) {
            if (this.ValFrom$module == null) {
                this.ValFrom$module = new TreeGen$ValFrom$(this);
            }
            return;
        }
    }

    private final void ValEq$lzycompute$1() {
        synchronized (this) {
            if (this.ValEq$module == null) {
                this.ValEq$module = new TreeGen$ValEq$(this);
            }
            return;
        }
    }

    private final void Filter$lzycompute$1() {
        synchronized (this) {
            if (this.Filter$module == null) {
                this.Filter$module = new TreeGen$Filter$(this);
            }
            return;
        }
    }

    private final void Yield$lzycompute$1() {
        synchronized (this) {
            if (this.Yield$module == null) {
                this.Yield$module = new TreeGen$Yield$(this);
            }
            return;
        }
    }

    private final void patvarTransformer$lzycompute$1() {
        synchronized (this) {
            if (this.patvarTransformer$module == null) {
                this.patvarTransformer$module = new TreeGen$patvarTransformer$(this);
            }
            return;
        }
    }

    private final void patvarTransformerForFor$lzycompute$1() {
        synchronized (this) {
            if (this.patvarTransformerForFor$module == null) {
                this.patvarTransformerForFor$module = new TreeGen$patvarTransformerForFor$(this);
            }
            return;
        }
    }

    public static final /* synthetic */ Trees.TypeTree $anonfun$mkMethodCall$1(TreeGen $this, Types.Type tp) {
        return $this.global().TypeTree(tp);
    }

    public static final /* synthetic */ Trees.TypeTree $anonfun$mkNullaryCall$1(TreeGen $this, Types.Type tp) {
        return $this.global().TypeTree(tp);
    }

    private static final String failMessage$1(Types.Type tpe$1, Symbols.Symbol termSym$1) {
        return new StringBuilder(25).append("mkAttributedQualifier(").append(tpe$1).append(", ").append(termSym$1).append(")").toString();
    }

    public static final /* synthetic */ String $anonfun$mkAttributedQualifier$4(List parents$1, Types.Type tpe$1, Symbols.Symbol termSym$1) {
        return new StringBuilder(11).append(TreeGen.failMessage$1(tpe$1, termSym$1)).append(" parents = ").append(parents$1).toString();
    }

    public static final /* synthetic */ Trees.Select $anonfun$mkUnattributedRef$1(TreeGen $this, Trees.RefTree x$3, Names.Name x$4) {
        return new Trees.Select($this.global(), (Trees.Tree)((Object)x$3), x$4);
    }

    public static final /* synthetic */ boolean $anonfun$mkTemplate$2(TreeGen $this, Trees.Tree tree) {
        return $this.global().treeInfo().isEarlyDef(tree);
    }

    public static final /* synthetic */ boolean $anonfun$mkTemplate$3(TreeGen $this, Trees.Tree tree) {
        return $this.global().treeInfo().isEarlyValDef(tree);
    }

    public static final /* synthetic */ boolean $anonfun$mkTemplate$5(TreeGen $this, Trees.Tree tree) {
        return $this.global().treeInfo().isInterfaceMember(tree);
    }

    public static final /* synthetic */ void $anonfun$mkTemplate$6(TreeGen $this, List parents$2, List gvdefs$1, Trees.DefDef x$11) {
        $this.global().ensureNonOverlapping(x$11, gvdefs$1.$colon$colon$colon(parents$2), false);
    }

    public static final /* synthetic */ boolean $anonfun$mkClassDef$1(TreeGen $this, Trees.Tree tree) {
        return $this.global().treeInfo().isInterfaceMember(tree);
    }

    private final Position wrapped$1(Trees.Tree pat$1, Trees.Tree body$1) {
        return this.global().wrappingPos(new $colon$colon<Nothing$>((Nothing$)((Object)pat$1), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)body$1), Nil$.MODULE$)));
    }

    private final Position splitpos$1(Position pos$1, Trees.Tree pat$1, Trees.Tree body$1) {
        Position position = pos$1;
        NoPosition$ noPosition$ = this.global().NoPosition();
        return ((position == null ? noPosition$ != null : !position.equals(noPosition$)) ? this.wrapped$1(pat$1, body$1).withPoint(pos$1.point()) : pos$1).makeTransparent();
    }

    private final Trees.Tree makeClosure$1(Position pos, Trees.Tree pat, Trees.Tree body, FreshNameCreator fresh$1) {
        Trees.Tree tree;
        Tuple2 tuple2;
        Option<Tuple2<Names.Name, Trees.Tree>> option = this.matchVarPattern(pat);
        if (option instanceof Some && (tuple2 = (Tuple2)((Some)option).value()) != null) {
            Names.Name name = (Names.Name)tuple2._1();
            Trees.Tree tpt = (Trees.Tree)tuple2._2();
            tree = (Trees.Tree)new Trees.Function(this.global(), new $colon$colon<Nothing$>((Nothing$)((Object)this.global().atPos(pat.pos(), new Trees.ValDef(this.global(), (Trees.Modifiers)this.global().Modifiers(BoxesRunTime.boxToLong(8192L)), name.toTermName(), tpt, this.global().EmptyTree()))), Nil$.MODULE$), body).setPos(this.splitpos$1(pos, pat, body));
        } else if (None$.MODULE$.equals(option)) {
            tree = this.global().atPos(this.splitpos$1(pos, pat, body), this.mkVisitor(new $colon$colon<Nothing$>((Nothing$)((Object)new Trees.CaseDef(this.global(), pat, this.global().EmptyTree(), body)), Nil$.MODULE$), false, this.mkVisitor$default$3(), fresh$1));
        } else {
            throw new MatchError(option);
        }
        return tree;
    }

    private final Trees.Tree makeCombination$1(Position pos, Names.TermName meth, Trees.Tree qual, Trees.Tree pat, Trees.Tree body, FreshNameCreator fresh$1) {
        return (Trees.Tree)new Trees.Apply(this.global(), (Trees.Tree)new Trees.Select(this.global(), qual, meth).setPos(qual.pos()).updateAttachment(this.global().ForAttachment(), ClassTag$.MODULE$.apply(StdAttachments$ForAttachment$.class)), new $colon$colon<Nothing$>((Nothing$)((Object)this.makeClosure$1(pos, pat, body, fresh$1)), Nil$.MODULE$)).setPos(pos);
    }

    private final Trees.Tree makeBind$1(Trees.Tree pat, FreshNameCreator fresh$1) {
        Trees.Tree tree = pat instanceof Trees.Bind ? pat : (Trees.Tree)new Trees.Bind(this.global(), this.global().freshTermName(this.global().freshTermName$default$1(), fresh$1), pat).setPos(pat.pos());
        return tree;
    }

    private final Trees.Tree makeValue$1(Trees.Tree pat) {
        if (!(pat instanceof Trees.Bind)) {
            throw new MatchError(pat);
        }
        Names.Name name = ((Trees.Bind)pat).name();
        Trees.Tree tree = (Trees.Tree)new Trees.Ident(this.global(), name).setPos(pat.pos().focus());
        return tree;
    }

    private final Position closurePos$1(Position genpos, Trees.Tree body$2) {
        Position position = genpos;
        NoPosition$ noPosition$ = this.global().NoPosition();
        if (!(position != null ? !position.equals(noPosition$) : noPosition$ != null)) {
            return this.global().NoPosition();
        }
        Position position2 = body$2.pos();
        NoPosition$ noPosition$2 = this.global().NoPosition();
        int n = !(noPosition$2 != null ? !noPosition$2.equals(position2) : position2 != null) ? genpos.point() : position2.end();
        return this.global().rangePos(genpos.source(), genpos.start(), genpos.point(), n);
    }

    public static final /* synthetic */ boolean $anonfun$mkFor$1(TreeGen $this, Trees.Tree x$23) {
        return $this.ValEq().unapply(x$23).nonEmpty();
    }

    public static final /* synthetic */ Names.Name $anonfun$mkPatDef$1(Tuple4 x$29) {
        return (Names.Name)x$29._1();
    }

    public static final /* synthetic */ Trees.Ident $anonfun$mkPatDef$2(TreeGen $this, Names.Name name) {
        return new Trees.Ident($this.global(), name);
    }

    public static final /* synthetic */ Trees.ValDef $anonfun$mkPatDef$4(TreeGen $this, IntRef cnt$1, Trees.Modifiers mods$1, Names.TermName tmp$1, Tuple4 x$30) {
        Trees.Tree original;
        Position pos;
        Trees.Tree tpt;
        Names.Name vname;
        if (x$30 != null) {
            vname = (Names.Name)x$30._1();
            tpt = (Trees.Tree)x$30._2();
            pos = (Position)x$30._3();
            original = (Trees.Tree)x$30._4();
            ++cnt$1.elem;
        } else {
            throw new MatchError((Object)null);
        }
        Trees.ValDef valDef = $this.global().atPos(pos, $this.propagatePatVarDefAttachments(original, new Trees.ValDef($this.global(), mods$1, vname.toTermName(), tpt, new Trees.Select($this.global(), new Trees.Ident($this.global(), tmp$1), $this.global().TermName().apply(new StringBuilder(1).append("_").append(cnt$1.elem).toString())))));
        return valDef;
    }

    public static final /* synthetic */ void $anonfun$unwarnable$1(TreeGen $this, Trees.Tree x0$1) {
        if (x0$1 instanceof Trees.Bind) {
            ((Trees.Bind)x0$1).updateAttachment($this.global().NoWarnAttachment(), ClassTag$.MODULE$.apply(StdAttachments$NoWarnAttachment$.class));
            return;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private final Option wildType$1(Trees.Tree t) {
        void var2_6;
        if (t instanceof Trees.Ident) {
            Names.TermName termName = ((Trees.Ident)t).name().toTermName();
            Names.Name name = this.global().nme().WILDCARD();
            if (!(termName != null ? !termName.equals(name) : name != null)) {
                Some<Trees.TypeTree> some = new Some<Trees.TypeTree>(new Trees.TypeTree(this.global()));
                return var2_6;
            }
        }
        if (t instanceof Trees.Typed) {
            Trees.Typed typed = (Trees.Typed)t;
            Trees.Tree tree = typed.expr();
            Trees.Tree tpt = typed.tpt();
            if (tree instanceof Trees.Ident) {
                Names.TermName termName = ((Trees.Ident)tree).name().toTermName();
                Names.Name name = this.global().nme().WILDCARD();
                if (!(termName != null ? !termName.equals(name) : name != null)) {
                    Some<Trees.Tree> some = new Some<Trees.Tree>(tpt);
                    return var2_6;
                }
            }
        }
        None$ none$ = None$.MODULE$;
        return var2_6;
    }

    public static final /* synthetic */ Tuple2 $anonfun$matchVarPattern$1(Names.Name name$1, Trees.Tree x) {
        return new Tuple2<Names.Name, Trees.Tree>(name$1, x);
    }

    public static final /* synthetic */ Object $anonfun$mkAttributedQualifier$3$adapted(Types.Type x$1) {
        return BoxesRunTime.boxToBoolean(x$1.isStable());
    }

    public static final /* synthetic */ Object $anonfun$mkTemplate$2$adapted(TreeGen $this, Trees.Tree tree) {
        return BoxesRunTime.boxToBoolean(TreeGen.$anonfun$mkTemplate$2($this, tree));
    }

    public static final /* synthetic */ Object $anonfun$mkTemplate$5$adapted(TreeGen $this, Trees.Tree tree) {
        return BoxesRunTime.boxToBoolean(TreeGen.$anonfun$mkTemplate$5($this, tree));
    }

    public static final /* synthetic */ Object $anonfun$mkTemplate$6$adapted(TreeGen $this, List parents$2, List gvdefs$1, Trees.DefDef x$11) {
        TreeGen.$anonfun$mkTemplate$6($this, parents$2, gvdefs$1, x$11);
        return BoxedUnit.UNIT;
    }

    public static final /* synthetic */ Object $anonfun$mkClassDef$1$adapted(TreeGen $this, Trees.Tree tree) {
        return BoxesRunTime.boxToBoolean(TreeGen.$anonfun$mkClassDef$1($this, tree));
    }

    public static final /* synthetic */ Object $anonfun$mkFor$1$adapted(TreeGen $this, Trees.Tree x$23) {
        return BoxesRunTime.boxToBoolean(TreeGen.$anonfun$mkFor$1($this, x$23));
    }

    public static final /* synthetic */ Object $anonfun$mkPatDef$3$adapted(Tuple4 check$ifrefutable$1) {
        return BoxesRunTime.boxToBoolean(bl = check$ifrefutable$1 != null);
    }

    public class GetVarTraverser
    extends Trees.Traverser {
        private final ListBuffer<Tuple4<Names.Name, Trees.Tree, Position, Trees.Tree>> buf;

        public ListBuffer<Tuple4<Names.Name, Trees.Tree, Position, Trees.Tree>> buf() {
            return this.buf;
        }

        public Position namePos(Trees.Tree tree, Names.Name name) {
            if (!tree.pos().isRange() || name.containsName(this.scala$reflect$internal$TreeGen$GetVarTraverser$$$outer().global().nme().raw().DOLLAR())) {
                return tree.pos().focus();
            }
            int start = tree.pos().start();
            int end = start + name.decode().length();
            return this.scala$reflect$internal$TreeGen$GetVarTraverser$$$outer().global().rangePos(tree.pos().source(), start, start, end);
        }

        /*
         * Unable to fully structure code
         * Could not resolve type clashes
         */
        public void traverse(Trees.Tree tree) {
            block6: {
                block5: {
                    bl = this.buf().length();
                    var3_3 = false;
                    var4_4 = null;
                    if (!(tree instanceof Trees.Bind)) break block5;
                    var3_3 = true;
                    var4_4 = (Trees.Bind)tree;
                    var5_5 = var4_4.name();
                    v0 = this.scala$reflect$internal$TreeGen$GetVarTraverser$$$outer().global().nme().WILDCARD();
                    if (v0 != null ? v0.equals(var5_5) == false : var5_5 != null) break block5;
                    super.traverse(tree);
                    break block6;
                }
                if (!var3_3) ** GOTO lbl-1000
                name = var4_4.name();
                var7_7 = var4_4.body();
                if (var7_7 instanceof Trees.Typed) {
                    var8_8 = (Trees.Typed)var7_7;
                    tree1 = var8_8.expr();
                    tpt = var8_8.tpt();
                    newTree /* !! */  = this.scala$reflect$internal$TreeGen$GetVarTraverser$$$outer().global().treeInfo().mayBeTypePat(tpt) != false ? new Trees.TypeTree(this.scala$reflect$internal$TreeGen$GetVarTraverser$$$outer().global()) : tpt.duplicate();
                    this.add$1(name, newTree /* !! */ , tree);
                    this.traverse(tree1);
                } else if (var3_3) {
                    name = var4_4.name();
                    tree1 = var4_4.body();
                    this.add$1(name, new Trees.TypeTree(this.scala$reflect$internal$TreeGen$GetVarTraverser$$$outer().global()), tree);
                    this.traverse(tree1);
                } else {
                    super.traverse(tree);
                }
            }
            if (this.buf().length() > bl) {
                tree.setPos(tree.pos().makeTransparent());
            }
        }

        public List<Tuple4<Names.Name, Trees.Tree, Position, Trees.Tree>> apply(Trees.Tree tree) {
            this.traverse(tree);
            return this.buf().toList();
        }

        public /* synthetic */ TreeGen scala$reflect$internal$TreeGen$GetVarTraverser$$$outer() {
            return TreeGen.this;
        }

        public static final /* synthetic */ boolean $anonfun$traverse$1(Names.Name name$2, Tuple4 x$33) {
            Object T1 = x$33._1();
            return !(T1 != null ? !T1.equals(name$2) : name$2 != null);
        }

        /*
         * WARNING - void declaration
         */
        private final boolean seenName$1(Names.Name name) {
            void exists_p;
            ListBuffer<Tuple4<Names.Name, Trees.Tree, Position, Trees.Tree>> listBuffer = this.buf();
            Function1<Tuple4, Object> & java.io.Serializable & Serializable intersect = (Function1<Tuple4, Object> & java.io.Serializable & Serializable)x$33 -> BoxesRunTime.boxToBoolean(GetVarTraverser.$anonfun$traverse$1(name, x$33));
            if (listBuffer == null) {
                throw null;
            }
            return listBuffer.underlying().exists(exists_p);
        }

        private final Object add$1(Names.Name name, Trees.Tree t, Trees.Tree tree$1) {
            if (!this.seenName$1(name)) {
                return this.buf().$plus$eq((Object)new Tuple4<Names.Name, Trees.Tree, Position, Trees.Tree>(name, t, this.namePos(tree$1, name), tree$1));
            }
            return BoxedUnit.UNIT;
        }

        public GetVarTraverser() {
            if (TreeGen.this == null) {
                throw null;
            }
            super(TreeGen.this.global());
            this.buf = new ListBuffer();
        }
    }

    public class PatvarTransformer
    extends Trees.Transformer {
        private final boolean forFor;
        public final /* synthetic */ TreeGen $outer;

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public Trees.Tree transform(Trees.Tree tree) {
            boolean bl = false;
            Trees.Typed typed = null;
            boolean bl2 = false;
            Trees.Apply apply2 = null;
            if (tree instanceof Trees.Ident) {
                Names.Name name = ((Trees.Ident)tree).name();
                if (this.scala$reflect$internal$TreeGen$PatvarTransformer$$$outer().global().treeInfo().isVarPattern(tree)) {
                    Names.Name name2 = name;
                    Names.Name name3 = this.scala$reflect$internal$TreeGen$PatvarTransformer$$$outer().global().nme().WILDCARD();
                    if (name2 == null ? name3 != null : !name2.equals(name3)) {
                        Trees.Bind b = new Trees.Bind(this.scala$reflect$internal$TreeGen$PatvarTransformer$$$outer().global(), name, this.scala$reflect$internal$TreeGen$PatvarTransformer$$$outer().global().atPos(tree.pos().focus(), new Trees.Ident(this.scala$reflect$internal$TreeGen$PatvarTransformer$$$outer().global(), this.scala$reflect$internal$TreeGen$PatvarTransformer$$$outer().global().nme().WILDCARD())));
                        return this.scala$reflect$internal$TreeGen$PatvarTransformer$$$outer().global().atPos(tree.pos(), this.forFor && this.scala$reflect$internal$TreeGen$PatvarTransformer$$$outer().isPatVarWarnable() ? (Trees.Tree)b.updateAttachment(this.scala$reflect$internal$TreeGen$PatvarTransformer$$$outer().global().NoWarnAttachment(), ClassTag$.MODULE$.apply(StdAttachments$NoWarnAttachment$.class)) : b);
                    }
                }
            }
            if (tree instanceof Trees.Typed) {
                bl = true;
                typed = (Trees.Typed)tree;
                Trees.Tree id = typed.expr();
                Trees.Tree tpt = typed.tpt();
                if (id instanceof Trees.Ident) {
                    Trees.Ident ident = (Trees.Ident)id;
                    Names.Name name = ident.name();
                    if (this.scala$reflect$internal$TreeGen$PatvarTransformer$$$outer().global().treeInfo().isVarPattern(ident)) {
                        Names.Name name4 = name;
                        Names.Name name5 = this.scala$reflect$internal$TreeGen$PatvarTransformer$$$outer().global().nme().WILDCARD();
                        if (name4 == null ? name5 != null : !name4.equals(name5)) {
                            return this.scala$reflect$internal$TreeGen$PatvarTransformer$$$outer().global().atPos(tree.pos().withPoint(ident.pos().point()), new Trees.Bind(this.scala$reflect$internal$TreeGen$PatvarTransformer$$$outer().global(), name, this.scala$reflect$internal$TreeGen$PatvarTransformer$$$outer().global().atPos(tree.pos().withStart(tree.pos().point()), new Trees.Typed(this.scala$reflect$internal$TreeGen$PatvarTransformer$$$outer().global(), new Trees.Ident(this.scala$reflect$internal$TreeGen$PatvarTransformer$$$outer().global(), this.scala$reflect$internal$TreeGen$PatvarTransformer$$$outer().global().nme().WILDCARD()), tpt))));
                        }
                    }
                }
            }
            if (tree instanceof Trees.Apply) {
                bl2 = true;
                apply2 = (Trees.Apply)tree;
                Trees.Tree fn = apply2.fun();
                List<Trees.TreeApi> args2 = apply2.args();
                if (fn instanceof Trees.Apply) {
                    Trees.Apply apply3 = (Trees.Apply)fn;
                    return (Trees.Tree)((Object)this.treeCopy().Apply(tree, this.transform(apply3), this.transformTrees(args2)));
                }
            }
            if (bl2) {
                Trees.Tree fn = apply2.fun();
                List<Trees.TreeApi> args3 = apply2.args();
                return (Trees.Tree)((Object)this.treeCopy().Apply(tree, fn, this.transformTrees(args3)));
            }
            if (bl) {
                Trees.Tree expr = typed.expr();
                Trees.Tree tpt = typed.tpt();
                return (Trees.Tree)((Object)this.treeCopy().Typed(tree, this.transform(expr), tpt));
            }
            if (tree instanceof Trees.Bind) {
                Trees.Bind bind = (Trees.Bind)tree;
                Names.Name name = bind.name();
                Trees.Tree body = bind.body();
                return (Trees.Tree)((Object)this.treeCopy().Bind(tree, name, this.transform(body)));
            }
            boolean bl3 = tree instanceof Trees.Alternative ? true : tree instanceof Trees.Star;
            if (!bl3) return tree;
            return (Trees.Tree)super.transform(tree);
        }

        public /* synthetic */ TreeGen scala$reflect$internal$TreeGen$PatvarTransformer$$$outer() {
            return this.$outer;
        }

        public PatvarTransformer(TreeGen $outer, boolean forFor) {
            this.forFor = forFor;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            super($outer.global());
        }
    }
}

