/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

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
import scala.collection.AbstractIterator;
import scala.collection.GenIterable;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.Iterator$;
import scala.collection.LinearSeqOptimized;
import scala.collection.Seq;
import scala.collection.Traversable;
import scala.collection.TraversableOnce$;
import scala.collection.TraversableOnce$appender$1$;
import scala.collection.TraversableOnce$counter$1$;
import scala.collection.TraversableOnce$counter$3$;
import scala.collection.TraversableOnce$folder$1$;
import scala.collection.TraversableOnce$maxer$1$;
import scala.collection.TraversableOnce$miner$1$;
import scala.collection.TraversableOnce$reducer$1$;
import scala.collection.TraversableOnce$reverser$1$;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Map;
import scala.collection.immutable.Map$;
import scala.collection.immutable.Set;
import scala.collection.immutable.Set$;
import scala.collection.immutable.Vector;
import scala.collection.immutable.Vector$;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.ArrayBuffer$;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.StringBuilder;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.AbstractFunction1;
import scala.runtime.LazyRef;
import scala.runtime.NonLocalReturnControl;
import scala.runtime.Nothing$;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0015mea\u0002+V!\u0003\r\tA\u0017\u0005\u0006Y\u0002!\t!\u001c\u0005\u0006c\u00021\tA\u001d\u0005\u0006y\u00021\t! \u0005\u0007\u0003\u0007\u0001a\u0011A?\t\u000f\u0005\u0015\u0001A\"\u0001\u0002\b!9\u00111\u0002\u0001\u0007\u0002\u00055\u0001bBA\u000b\u0001\u0019\u0005\u0011q\u0003\u0005\b\u00037\u0001a\u0011AA\u000f\u0011\u001d\t9\u0003\u0001D\u0001\u0003SA\u0001\"!\u0014\u0001A\u0013E\u0011q\n\u0005\b\u0003?\u0002A\u0011AA1\u0011\u0019\t\u0019\u0007\u0001C\u0001{\"9\u0011Q\r\u0001\u0005\u0002\u0005\u001d\u0004bBA6\u0001\u0011\u0005\u0011Q\u000e\u0005\b\u0003\u0003\u0003A\u0011AAB\u0011\u001d\tY\u000b\u0001C\u0001\u0003[Cq!a1\u0001\t\u0003\t)\rC\u0004\u0002V\u0002!\t!a6\t\u000f\u0005\u001d\b\u0001\"\u0001\u0002j\"9\u0011Q\u001f\u0001\u0005\u0002\u0005]\bb\u0002B\u0002\u0001\u0011\u0005!Q\u0001\u0005\b\u0005'\u0001A\u0011\u0001B\u000b\u0011\u001d\u0011\u0019\u0003\u0001C\u0001\u0005KAqAa\r\u0001\t\u0003\u0011)\u0004C\u0004\u0003D\u0001!\tA!\u0012\t\u000f\tU\u0003\u0001\"\u0001\u0003X!9!Q\u000f\u0001\u0005\u0002\t]\u0004b\u0002BE\u0001\u0011\u0005!1\u0012\u0005\b\u0005/\u0003A\u0011\u0001BM\u0011\u001d\u0011Y\u000b\u0001C\u0001\u0005[CqA!/\u0001\t\u0003\u0011Y\fC\u0004\u0003N\u0002!\tAa4\t\u000f\t\u0005\b\u0001\"\u0001\u0003d\"9\u0011q\u0005\u0001\u0005\u0002\tm\bbBA\u0014\u0001\u0011\u00051\u0011\u0002\u0005\b\u0007+\u0001A\u0011AB\f\u0011\u001d\u0019\t\u0004\u0001D\u0001\u0007gAqaa\u000f\u0001\t\u0003\ty\u0005C\u0004\u0004>\u0001!\taa\u0010\t\u000f\r\u001d\u0003\u0001\"\u0001\u0004J!91\u0011\u000b\u0001\u0005\u0002\rM\u0003bBB1\u0001\u0011\u000511\r\u0005\b\u0007[\u0002A\u0011AB8\u0011\u001d\u0019i\b\u0001C\u0001\u0007\u007fBqaa\"\u0001\t\u0003\u0019I\tC\u0004\u0004>\u0002!\taa0\t\u000f\rM\b\u0001\"\u0001\u0004v\"911\u001f\u0001\u0005\u0002\u0011\u001d\u0001bBBz\u0001\u0011\u0005A1\u0002\u0005\b\t\u001b\u0001A\u0011\u0001C\b\u0011\u001d!i\u0001\u0001C\u0001\tCAq\u0001\"\u0004\u0001\t\u0003!9cB\u0004\u0005,UC\t\u0001\"\f\u0007\rQ+\u0006\u0012\u0001C\u0018\u0011\u001d!9D\u000eC\u0001\tsAq\u0001b\u000f7\t\u0007!i\u0004C\u0004\u0005VY\"\u0019\u0001b\u0016\u0007\u0011\u0011]e'!\u0001V\t3Cq\u0001b\u000e;\t\u0003!i\fC\u0004\u0005Dj2\t\u0001\"2\t\u000f\u0011e'H\"\u0001\u0005\\\"9Aq\u001e\u001e\u0005\u0002\u0011E\bb\u0002C}u\u0011\u0005A1 \u0005\b\tsTD\u0011AC\u0006\r\u0019)iA\u000e\u0001\u0006\u0010!9AqG!\u0005\u0002\u0015m\u0001b\u0002Cb\u0003\u0012\u0005Qq\u0004\u0005\b\t3\fE\u0011AC\u0017\u0011\u001d)YD\u000eC\u0002\u000b{1a\u0001b\u00187\u0001\u0011\u0005\u0004B\u0003C3\r\n\u0005\t\u0015!\u0003\u0005h!9Aq\u0007$\u0005\u0002\u0011=\u0004b\u0002C;\r\u0012\u0005Aq\u000f\u0004\u0007\t\u000b2\u0004\u0001b\u0012\t\u000f\u0011]\"\n\"\u0001\u0005J\u00191Qq\t\u001c\u0002\u000b\u0013B!\u0002\"\u0014M\u0005\u0003\u0005\u000b\u0011BC'\u0011\u001d!9\u0004\u0014C\u0001\u000b'Bq!\"\u0017M\t\u0003)Y\u0006C\u0004\u0006j1#\t!b\u001b\t\u000f\u0015mD\n\"\u0001\u0006~!9QQ\u0011'\u0005\u0002\u0015\u001d\u0005\"CCFm\u0005\u0005I1ACG\u0005=!&/\u0019<feN\f'\r\\3P]\u000e,'B\u0001,X\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u00021\u0006)1oY1mC\u000e\u0001QCA.g'\r\u0001A\f\u0019\t\u0003;zk\u0011aV\u0005\u0003?^\u00131!\u00118z!\r\t'\rZ\u0007\u0002+&\u00111-\u0016\u0002\u0013\u000f\u0016tGK]1wKJ\u001c\u0018M\u00197f\u001f:\u001cW\r\u0005\u0002fM2\u0001AAB4\u0001\t\u000b\u0007\u0001NA\u0001B#\tIG\f\u0005\u0002^U&\u00111n\u0016\u0002\b\u001d>$\b.\u001b8h\u0003\u0019!\u0013N\\5uIQ\ta\u000e\u0005\u0002^_&\u0011\u0001o\u0016\u0002\u0005+:LG/A\u0004g_J,\u0017m\u00195\u0016\u0005MTHC\u00018u\u0011\u0015)(\u00011\u0001w\u0003\u00051\u0007\u0003B/xIfL!\u0001_,\u0003\u0013\u0019+hn\u0019;j_:\f\u0004CA3{\t\u0015Y(A1\u0001i\u0005\u0005)\u0016aB5t\u000b6\u0004H/_\u000b\u0002}B\u0011Ql`\u0005\u0004\u0003\u00039&a\u0002\"p_2,\u0017M\\\u0001\u0010Q\u0006\u001cH)\u001a4j]&$XmU5{K\u0006\u00191/Z9\u0016\u0005\u0005%\u0001cA1\u0001I\u00061am\u001c:bY2$2A`A\b\u0011\u001d\t\tB\u0002a\u0001\u0003'\t\u0011\u0001\u001d\t\u0005;^$g0\u0001\u0004fq&\u001cHo\u001d\u000b\u0004}\u0006e\u0001bBA\t\u000f\u0001\u0007\u00111C\u0001\u0005M&tG\r\u0006\u0003\u0002 \u0005\u0015\u0002\u0003B/\u0002\"\u0011L1!a\tX\u0005\u0019y\u0005\u000f^5p]\"9\u0011\u0011\u0003\u0005A\u0002\u0005M\u0011aC2paf$v.\u0011:sCf,B!a\u000b\u0002:Q9a.!\f\u0002@\u0005%\u0003bBA\u0018\u0013\u0001\u0007\u0011\u0011G\u0001\u0003qN\u0004R!XA\u001a\u0003oI1!!\u000eX\u0005\u0015\t%O]1z!\r)\u0017\u0011\b\u0003\b\u0003wI!\u0019AA\u001f\u0005\u0005\u0011\u0015C\u00013]\u0011\u001d\t\t%\u0003a\u0001\u0003\u0007\nQa\u001d;beR\u00042!XA#\u0013\r\t9e\u0016\u0002\u0004\u0013:$\bbBA&\u0013\u0001\u0007\u00111I\u0001\u0004Y\u0016t\u0017\u0001\u0003:fm\u0016\u00148/\u001a3\u0016\u0005\u0005E\u0003#BA*\u00033\"gbA/\u0002V%\u0019\u0011qK,\u0002\u000fA\f7m[1hK&!\u00111LA/\u0005\u0011a\u0015n\u001d;\u000b\u0007\u0005]s+\u0001\u0003tSj,WCAA\"\u0003!qwN\\#naRL\u0018!B2pk:$H\u0003BA\"\u0003SBq!!\u0005\u000e\u0001\u0004\t\u0019\"\u0001\u0007d_2dWm\u0019;GSJ\u001cH/\u0006\u0003\u0002p\u0005UD\u0003BA9\u0003o\u0002R!XA\u0011\u0003g\u00022!ZA;\t\u0019\tYD\u0004b\u0001Q\"9\u0011\u0011\u0010\bA\u0002\u0005m\u0014A\u00019g!\u0019i\u0016Q\u00103\u0002t%\u0019\u0011qP,\u0003\u001fA\u000b'\u000f^5bY\u001a+hn\u0019;j_:\f!\u0002\n3jm\u0012\u001aw\u000e\\8o+\u0011\t))a#\u0015\t\u0005\u001d\u0015q\u0013\u000b\u0005\u0003\u0013\u000bi\tE\u0002f\u0003\u0017#a!a\u000f\u0010\u0005\u0004A\u0007bBAH\u001f\u0001\u0007\u0011\u0011S\u0001\u0003_B\u0004\u0002\"XAJ\u0003\u0013#\u0017\u0011R\u0005\u0004\u0003+;&!\u0003$v]\u000e$\u0018n\u001c83\u0011\u001d\tIj\u0004a\u0001\u0003\u0013\u000b\u0011A\u001f\u0015\b\u001f\u0005u\u00151UAT!\ri\u0016qT\u0005\u0004\u0003C;&A\u00033faJ,7-\u0019;fI\u0006\u0012\u0011QU\u0001\u001b+N,\u0007EZ8mI2+g\r\u001e\u0011j]N$X-\u00193!_\u001a\u0004sFO\u0011\u0003\u0003S\u000bqA\r\u00182e9\n\u0004'A\u0007%G>dwN\u001c\u0013cg2\f7\u000f[\u000b\u0005\u0003_\u000b)\f\u0006\u0003\u00022\u0006mF\u0003BAZ\u0003o\u00032!ZA[\t\u0019\tY\u0004\u0005b\u0001Q\"9\u0011q\u0012\tA\u0002\u0005e\u0006\u0003C/\u0002\u0014\u0012\f\u0019,a-\t\u000f\u0005e\u0005\u00031\u0001\u00024\":\u0001#!(\u0002@\u0006\u001d\u0016EAAa\u0003m)6/\u001a\u0011g_2$'+[4ii\u0002Jgn\u001d;fC\u0012\u0004sN\u001a\u0011;9\u0006Aam\u001c7e\u0019\u00164G/\u0006\u0003\u0002H\u00065G\u0003BAe\u0003'$B!a3\u0002PB\u0019Q-!4\u0005\r\u0005m\u0012C1\u0001i\u0011\u001d\ty)\u0005a\u0001\u0003#\u0004\u0002\"XAJ\u0003\u0017$\u00171\u001a\u0005\b\u00033\u000b\u0002\u0019AAf\u0003%1w\u000e\u001c3SS\u001eDG/\u0006\u0003\u0002Z\u0006}G\u0003BAn\u0003K$B!!8\u0002bB\u0019Q-a8\u0005\r\u0005m\"C1\u0001i\u0011\u001d\tyI\u0005a\u0001\u0003G\u0004\u0002\"XAJI\u0006u\u0017Q\u001c\u0005\b\u00033\u0013\u0002\u0019AAo\u0003)\u0011X\rZ;dK2+g\r^\u000b\u0005\u0003W\fy\u000f\u0006\u0003\u0002n\u0006E\bcA3\u0002p\u00129\u00111H\nC\u0002\u0005u\u0002bBAH'\u0001\u0007\u00111\u001f\t\t;\u0006M\u0015Q\u001e3\u0002n\u0006Y!/\u001a3vG\u0016\u0014\u0016n\u001a5u+\u0011\tI0!@\u0015\t\u0005m\u0018q \t\u0004K\u0006uHaBA\u001e)\t\u0007\u0011Q\b\u0005\b\u0003\u001f#\u0002\u0019\u0001B\u0001!!i\u00161\u00133\u0002|\u0006m\u0018\u0001\u0005:fIV\u001cW\rT3gi>\u0003H/[8o+\u0011\u00119A!\u0004\u0015\t\t%!q\u0002\t\u0006;\u0006\u0005\"1\u0002\t\u0004K\n5AaBA\u001e+\t\u0007\u0011Q\b\u0005\b\u0003\u001f+\u0002\u0019\u0001B\t!!i\u00161\u0013B\u0006I\n-\u0011!\u0005:fIV\u001cWMU5hQR|\u0005\u000f^5p]V!!q\u0003B\u000f)\u0011\u0011IBa\b\u0011\u000bu\u000b\tCa\u0007\u0011\u0007\u0015\u0014i\u0002B\u0004\u0002<Y\u0011\r!!\u0010\t\u000f\u0005=e\u00031\u0001\u0003\"AAQ,a%e\u00057\u0011Y\"\u0001\u0004sK\u0012,8-Z\u000b\u0005\u0005O\u0011Y\u0003\u0006\u0003\u0003*\t=\u0002cA3\u0003,\u00119!QF\fC\u0002\u0005u\"AA!2\u0011\u001d\tyi\u0006a\u0001\u0005c\u0001\u0012\"XAJ\u0005S\u0011IC!\u000b\u0002\u0019I,G-^2f\u001fB$\u0018n\u001c8\u0016\t\t]\"Q\b\u000b\u0005\u0005s\u0011y\u0004E\u0003^\u0003C\u0011Y\u0004E\u0002f\u0005{!qA!\f\u0019\u0005\u0004\ti\u0004C\u0004\u0002\u0010b\u0001\rA!\u0011\u0011\u0013u\u000b\u0019Ja\u000f\u0003<\tm\u0012\u0001\u00024pY\u0012,BAa\u0012\u0003NQ!!\u0011\nB*)\u0011\u0011YEa\u0014\u0011\u0007\u0015\u0014i\u0005B\u0004\u0003.e\u0011\r!!\u0010\t\u000f\u0005=\u0015\u00041\u0001\u0003RAIQ,a%\u0003L\t-#1\n\u0005\b\u00033K\u0002\u0019\u0001B&\u0003%\twm\u001a:fO\u0006$X-\u0006\u0003\u0003Z\t}C\u0003\u0002B.\u0005[\"bA!\u0018\u0003b\t\u001d\u0004cA3\u0003`\u00111\u00111\b\u000eC\u0002!DqAa\u0019\u001b\u0001\u0004\u0011)'A\u0003tKF|\u0007\u000f\u0005\u0005^\u0003'\u0013i\u0006\u001aB/\u0011\u001d\u0011IG\u0007a\u0001\u0005W\naaY8nE>\u0004\b#C/\u0002\u0014\nu#Q\fB/\u0011!\tIJ\u0007CA\u0002\t=\u0004#B/\u0003r\tu\u0013b\u0001B:/\nAAHY=oC6,g(A\u0002tk6,BA!\u001f\u0003~Q!!1\u0010B@!\r)'Q\u0010\u0003\b\u0003wY\"\u0019AA\u001f\u0011\u001d\u0011\ti\u0007a\u0002\u0005\u0007\u000b1A\\;n!\u0019\t\u0019F!\"\u0003|%!!qQA/\u0005\u001dqU/\\3sS\u000e\fq\u0001\u001d:pIV\u001cG/\u0006\u0003\u0003\u000e\nEE\u0003\u0002BH\u0005'\u00032!\u001aBI\t\u001d\tY\u0004\bb\u0001\u0003{AqA!!\u001d\u0001\b\u0011)\n\u0005\u0004\u0002T\t\u0015%qR\u0001\u0004[&tW\u0003\u0002BN\u0005S#2\u0001\u001aBO\u0011\u001d\u0011y*\ba\u0002\u0005C\u000b1aY7q!\u0019\t\u0019Fa)\u0003(&!!QUA/\u0005!y%\u000fZ3sS:<\u0007cA3\u0003*\u00129\u00111H\u000fC\u0002\u0005u\u0012aA7bqV!!q\u0016B\\)\r!'\u0011\u0017\u0005\b\u0005?s\u00029\u0001BZ!\u0019\t\u0019Fa)\u00036B\u0019QMa.\u0005\u000f\u0005mbD1\u0001\u0002>\u0005)Q.\u0019=CsV!!Q\u0018Bd)\u0011\u0011yL!3\u0015\u0007\u0011\u0014\t\rC\u0004\u0003 ~\u0001\u001dAa1\u0011\r\u0005M#1\u0015Bc!\r)'q\u0019\u0003\u0007\u0003wy\"\u0019\u00015\t\rU|\u0002\u0019\u0001Bf!\u0015iv\u000f\u001aBc\u0003\u0015i\u0017N\u001c\"z+\u0011\u0011\tNa7\u0015\t\tM'Q\u001c\u000b\u0004I\nU\u0007b\u0002BPA\u0001\u000f!q\u001b\t\u0007\u0003'\u0012\u0019K!7\u0011\u0007\u0015\u0014Y\u000e\u0002\u0004\u0002<\u0001\u0012\r\u0001\u001b\u0005\u0007k\u0002\u0002\rAa8\u0011\u000bu;HM!7\u0002\u0019\r|\u0007/\u001f+p\u0005V4g-\u001a:\u0016\t\t\u0015(\u0011 \u000b\u0004]\n\u001d\bb\u0002BuC\u0001\u0007!1^\u0001\u0005I\u0016\u001cH\u000f\u0005\u0004\u0003n\nM(q_\u0007\u0003\u0005_T1A!=V\u0003\u001diW\u000f^1cY\u0016LAA!>\u0003p\n1!)\u001e4gKJ\u00042!\u001aB}\t\u001d\tY$\tb\u0001\u0003{)BA!@\u0004\u0006Q)aNa@\u0004\b!9\u0011q\u0006\u0012A\u0002\r\u0005\u0001#B/\u00024\r\r\u0001cA3\u0004\u0006\u00119\u00111\b\u0012C\u0002\u0005u\u0002bBA!E\u0001\u0007\u00111I\u000b\u0005\u0007\u0017\u0019\u0019\u0002F\u0002o\u0007\u001bAq!a\f$\u0001\u0004\u0019y\u0001E\u0003^\u0003g\u0019\t\u0002E\u0002f\u0007'!q!a\u000f$\u0005\u0004\ti$A\u0004u_\u0006\u0013(/Y=\u0016\t\re1q\u0004\u000b\u0005\u00077\u0019\t\u0003E\u0003^\u0003g\u0019i\u0002E\u0002f\u0007?!q!a\u000f%\u0005\u0004\ti\u0004C\u0005\u0004$\u0011\n\t\u0011q\u0001\u0004&\u0005QQM^5eK:\u001cW\rJ\u0019\u0011\r\r\u001d2QFB\u000f\u001b\t\u0019ICC\u0002\u0004,]\u000bqA]3gY\u0016\u001cG/\u0003\u0003\u00040\r%\"\u0001C\"mCN\u001cH+Y4\u0002\u001bQ|GK]1wKJ\u001c\u0018M\u00197f+\t\u0019)\u0004\u0005\u0003b\u0007o!\u0017bAB\u001d+\nYAK]1wKJ\u001c\u0018M\u00197f\u0003\u0019!x\u000eT5ti\u0006QAo\\%uKJ\f'\r\\3\u0016\u0005\r\u0005\u0003\u0003B1\u0004D\u0011L1a!\u0012V\u0005!IE/\u001a:bE2,\u0017!\u0002;p'\u0016\fXCAB&!\u0011\t7Q\n3\n\u0007\r=SKA\u0002TKF\fA\u0002^8J]\u0012,\u00070\u001a3TKF,\"a!\u0016\u0011\u000b\r]3Q\f3\u000e\u0005\re#bAB.+\u0006I\u0011.\\7vi\u0006\u0014G.Z\u0005\u0005\u0007?\u001aIF\u0001\u0006J]\u0012,\u00070\u001a3TKF\f\u0001\u0002^8Ck\u001a4WM]\u000b\u0005\u0007K\u001aY'\u0006\u0002\u0004hA1!Q\u001eBz\u0007S\u00022!ZB6\t\u001d\tYD\u000bb\u0001\u0003{\tQ\u0001^8TKR,Ba!\u001d\u0004|U\u001111\u000f\t\u0007\u0007/\u001a)h!\u001f\n\t\r]4\u0011\f\u0002\u0004'\u0016$\bcA3\u0004|\u00119\u00111H\u0016C\u0002\u0005u\u0012\u0001\u0003;p-\u0016\u001cGo\u001c:\u0016\u0005\r\u0005\u0005#BA*\u0007\u0007#\u0017\u0002BBC\u0003;\u0012aAV3di>\u0014\u0018A\u0001;p+\u0011\u0019Yia$\u0015\t\r55Q\u0016\t\u0006K\u000e=5\u0011\u0014\u0003\b\u0007#k#\u0019ABJ\u0005\r\u0019u\u000e\\\u000b\u0004Q\u000eUEaBBL\u0007\u001f\u0013\r\u0001\u001b\u0002\u0002?*\u001aAma',\u0005\ru\u0005\u0003BBP\u0007Sk!a!)\u000b\t\r\r6QU\u0001\nk:\u001c\u0007.Z2lK\u0012T1aa*X\u0003)\tgN\\8uCRLwN\\\u0005\u0005\u0007W\u001b\tKA\tv]\u000eDWmY6fIZ\u000b'/[1oG\u0016Dqaa,.\u0001\b\u0019\t,A\u0002dE\u001a\u0004\u0002ba-\u0004:&$7QR\u0007\u0003\u0007kS1aa.V\u0003\u001d9WM\\3sS\u000eLAaa/\u00046\na1)\u00198Ck&dGM\u0012:p[\u0006)Ao\\'baV11\u0011YBf\u0007#$Baa1\u0004TBA1qKBc\u0007\u0013\u001cy-\u0003\u0003\u0004H\u000ee#aA'baB\u0019Qma3\u0005\r\r5gF1\u0001i\u0005\u0005!\u0006cA3\u0004R\u0012)1P\fb\u0001Q\"91Q\u001b\u0018A\u0004\r]\u0017AA3w!\u001d\u0019Ina:e\u0007[tAaa7\u0004dB\u00191Q\\,\u000e\u0005\r}'bABq3\u00061AH]8pizJ1a!:X\u0003\u0019\u0001&/\u001a3fM&!1\u0011^Bv\u0005A!C.Z:tI\r|Gn\u001c8%Y\u0016\u001c8OC\u0002\u0004f^\u0003r!XBx\u0007\u0013\u001cy-C\u0002\u0004r^\u0013a\u0001V;qY\u0016\u0014\u0014\u0001C7l'R\u0014\u0018N\\4\u0015\u0011\r]8Q`B\u0000\t\u0007\u0001Ba!7\u0004z&!11`Bv\u0005\u0019\u0019FO]5oO\"9\u0011\u0011I\u0018A\u0002\r]\bb\u0002C\u0001_\u0001\u00071q_\u0001\u0004g\u0016\u0004\bb\u0002C\u0003_\u0001\u00071q_\u0001\u0004K:$G\u0003BB|\t\u0013Aq\u0001\"\u00011\u0001\u0004\u001990\u0006\u0002\u0004x\u0006I\u0011\r\u001a3TiJLgn\u001a\u000b\u000b\t#!9\u0002b\u0007\u0005\u001e\u0011}\u0001\u0003BA*\t'IA\u0001\"\u0006\u0002^\ti1\u000b\u001e:j]\u001e\u0014U/\u001b7eKJDq\u0001\"\u00073\u0001\u0004!\t\"A\u0001c\u0011\u001d\t\tE\ra\u0001\u0007oDq\u0001\"\u00013\u0001\u0004\u00199\u0010C\u0004\u0005\u0006I\u0002\raa>\u0015\r\u0011EA1\u0005C\u0013\u0011\u001d!Ib\ra\u0001\t#Aq\u0001\"\u00014\u0001\u0004\u00199\u0010\u0006\u0003\u0005\u0012\u0011%\u0002b\u0002C\ri\u0001\u0007A\u0011C\u0001\u0010)J\fg/\u001a:tC\ndWm\u00148dKB\u0011\u0011MN\n\u0004m\u0011E\u0002cA/\u00054%\u0019AQG,\u0003\r\u0005s\u0017PU3g\u0003\u0019a\u0014N\\5u}Q\u0011AQF\u0001\u0012C2$XM\u001d8bi\u0016LU\u000e\u001d7jG&$X\u0003\u0002C \t'\"B\u0001\"\u0011\u0005LA\u0019A1\t&\u000e\u0003Y\u0012aCR8sG\u0016LU\u000e\u001d7jG&$\u0018)\u001c2jOVLG/_\n\u0004\u0015\u0012EBC\u0001C!\u0011\u001d!i\u0005\u000fa\u0001\t\u001f\nA\u0001\u001e:bmB!\u0011\r\u0001C)!\r)G1\u000b\u0003\u0006Ob\u0012\r\u0001[\u0001\u0017M2\fG\u000f^3o)J\fg/\u001a:tC\ndWm\u00148dKV1A\u0011\fCA\t\u0013#B\u0001b\u0017\u0005\u0014R!AQ\fCB!\u0015!\u0019E\u0012C@\u0005)1E.\u0019;uK:|\u0005o]\u000b\u0005\tG\"igE\u0002G\tc\tQ\u0001\u001e:bmN\u0004B!\u0019\u0001\u0005jA!\u0011\r\u0001C6!\r)GQ\u000e\u0003\u0006O\u001a\u0013\r\u0001\u001b\u000b\u0005\tc\"\u0019\bE\u0003\u0005D\u0019#Y\u0007C\u0004\u0005f!\u0003\r\u0001b\u001a\u0002\u000f\u0019d\u0017\r\u001e;f]V\u0011A\u0011\u0010\t\u0006C\u0012mD1N\u0005\u0004\t{*&\u0001C%uKJ\fGo\u001c:\u0011\u0007\u0015$\t\tB\u0003hs\t\u0007\u0001\u000eC\u0004\u0004Vf\u0002\u001d\u0001\"\"\u0011\ru;Hq\u0011CI!\u0015)G\u0011\u0012C@\t\u001d!Y)\u000fb\u0001\t\u001b\u0013!aQ\"\u0016\u0007!$y\tB\u0004\u0004\u0018\u0012%%\u0019\u00015\u0011\t\u0005\u0004Aq\u0010\u0005\b\tKJ\u0004\u0019\u0001CK!\u0011\t\u0007\u0001b\"\u0003)\t+hMZ3sK\u0012\u001c\u0015M\u001c\"vS2$gI]8n+\u0019!Y\n\"/\u0005$N)!\b\"\r\u0005\u001eBQ11WB]\t?#9\fb/1\t\u0011\u0005F1\u0017\t\u0006K\u0012\rF\u0011\u0017\u0003\b\t\u0017S$\u0019\u0001CS+\u0011!9\u000b\",\u0012\u0007%$I\u000b\u0005\u0003b\u0001\u0011-\u0006cA3\u0005.\u00129Aq\u0016CR\u0005\u0004A'!\u0001-\u0011\u0007\u0015$\u0019\f\u0002\u0006\u00056j\n\t\u0011!A\u0003\u0002!\u00141a\u0018\u00132!\r)G\u0011\u0018\u0003\u0006Oj\u0012\r\u0001\u001b\t\u0006K\u0012\rFq\u0017\u000b\u0003\t\u007f\u0003r\u0001b\u0011;\to#\t\rE\u0002f\tG\u000bABY;gM\u0016\u0014Hk\\\"pY2,B\u0001b2\u0005NR!A\u0011\u001aCh!\u0015)G1\u0015Cf!\r)GQ\u001a\u0003\u0007\u0003wa$\u0019\u00015\t\u000f\u0011EG\b1\u0001\u0005T\u0006!!-\u001e4g!\u0019\u0011i\u000f\"6\u0005L&!Aq\u001bBx\u0005-\t%O]1z\u0005V4g-\u001a:\u0002#Q\u0014\u0018M^3sg\u0006\u0014G.\u001a+p\u0007>dG.\u0006\u0003\u0005^\u0012\rH\u0003\u0002Cp\tK\u0004R!\u001aCR\tC\u00042!\u001aCr\t\u0019\tY$\u0010b\u0001Q\"9Aq]\u001fA\u0002\u0011%\u0018!\u0001;\u0011\u000b\u0005$Y\u000f\"9\n\u0007\u00115XK\u0001\bHK:$&/\u0019<feN\f'\r\\3\u0002\u00179,w/\u0013;fe\u0006$xN]\u000b\u0003\tg\u0004\u0002B!<\u0005v\u0012]F1X\u0005\u0005\to\u0014yOA\u0004Ck&dG-\u001a:\u0002\u000b\u0005\u0004\b\u000f\\=\u0015\t\u0011MHQ \u0005\b\t\u007f|\u0004\u0019AC\u0001\u0003\u00111'o\\71\t\u0015\rQq\u0001\t\u0006K\u0012\rVQ\u0001\t\u0004K\u0016\u001dAaCC\u0005\t{\f\t\u0011!A\u0003\u0002!\u00141a\u0018\u00133)\t!\u0019P\u0001\tP]\u000e,7)\u00198Ck&dGM\u0012:p[V!Q\u0011CC\f'\r\tU1\u0003\t\b\t\u0007RTQCC\r!\r)Wq\u0003\u0003\u0006O\u0006\u0013\r\u0001\u001b\t\u0003C\u0002!\"!\"\b\u0011\u000b\u0011\r\u0013)\"\u0006\u0016\t\u0015\u0005Rq\u0005\u000b\u0005\u000bG)I\u0003E\u0003b\tw*)\u0003E\u0002f\u000bO!a!a\u000fD\u0005\u0004A\u0007b\u0002Ci\u0007\u0002\u0007Q1\u0006\t\u0007\u0005[$).\"\n\u0016\t\u0015=RQ\u0007\u000b\u0005\u000bc)9\u0004E\u0003b\u0007o)\u0019\u0004E\u0002f\u000bk!a!a\u000fE\u0005\u0004A\u0007b\u0002Ct\t\u0002\u0007Q\u0011\b\t\u0006C\u0012-X1G\u0001\u0011\u001f:\u001cWmQ1o\u0005VLG\u000e\u001a$s_6,B!b\u0010\u0006FU\u0011Q\u0011\t\t\u0006\t\u0007\nU1\t\t\u0004K\u0016\u0015C!B4F\u0005\u0004A'\u0001C'p]\u0006$w\n]:\u0016\t\u0015-S\u0011K\n\u0004\u0019\u0012E\u0002\u0003B1\u0001\u000b\u001f\u00022!ZC)\t\u00199G\n\"b\u0001QR!QQKC,!\u0015!\u0019\u0005TC(\u0011\u001d!iE\u0014a\u0001\u000b\u001b\n1!\\1q+\u0011)i&b\u0019\u0015\t\u0015}SQ\r\t\u0005C\u0002)\t\u0007E\u0002f\u000bG\"a!a\u000fP\u0005\u0004A\u0007BB;P\u0001\u0004)9\u0007\u0005\u0004^o\u0016=S\u0011M\u0001\bM2\fG/T1q+\u0011)i'b\u001d\u0015\t\u0015=TQ\u000f\t\u0005C\u0002)\t\bE\u0002f\u000bg\"a!a\u000fQ\u0005\u0004A\u0007BB;Q\u0001\u0004)9\b\u0005\u0004^o\u0016=S\u0011\u0010\t\u0005C\n,\t(\u0001\u0006xSRDg)\u001b7uKJ$B!b \u0006\u0002B)\u0011\rb\u001f\u0006P!9\u0011\u0011C)A\u0002\u0015\r\u0005#B/x\u000b\u001fr\u0018A\u00024jYR,'\u000f\u0006\u0003\u0006N\u0015%\u0005bBA\t%\u0002\u0007Q1Q\u0001\t\u001b>t\u0017\rZ(qgV!QqRCK)\u0011)\t*b&\u0011\u000b\u0011\rC*b%\u0011\u0007\u0015,)\nB\u0003h'\n\u0007\u0001\u000eC\u0004\u0005NM\u0003\r!\"'\u0011\t\u0005\u0004Q1\u0013")
public interface TraversableOnce<A>
extends GenTraversableOnce<A> {
    public static <A> MonadOps<A> MonadOps(TraversableOnce<A> traversableOnce) {
        return TraversableOnce$.MODULE$.MonadOps(traversableOnce);
    }

    public static <A> OnceCanBuildFrom<A> OnceCanBuildFrom() {
        return TraversableOnce$.MODULE$.OnceCanBuildFrom();
    }

    public static <A, CC> FlattenOps<A> flattenTraversableOnce(TraversableOnce<CC> traversableOnce, Function1<CC, TraversableOnce<A>> function1) {
        TraversableOnce$ traversableOnce$ = TraversableOnce$.MODULE$;
        if (traversableOnce$ == null) {
            throw null;
        }
        TraversableOnce$ flattenTraversableOnce_this = traversableOnce$;
        return new FlattenOps<A>(flattenTraversableOnce_this.MonadOps(traversableOnce).map(function1));
    }

    public static <A> ForceImplicitAmbiguity alternateImplicit(TraversableOnce<A> traversableOnce) {
        return TraversableOnce$.MODULE$.alternateImplicit(traversableOnce);
    }

    @Override
    public <U> void foreach(Function1<A, U> var1);

    @Override
    public boolean isEmpty();

    @Override
    public boolean hasDefiniteSize();

    @Override
    public TraversableOnce<A> seq();

    @Override
    public boolean forall(Function1<A, Object> var1);

    @Override
    public boolean exists(Function1<A, Object> var1);

    @Override
    public Option<A> find(Function1<A, Object> var1);

    @Override
    public <B> void copyToArray(Object var1, int var2, int var3);

    public static /* synthetic */ List reversed$(TraversableOnce $this) {
        return $this.reversed();
    }

    default public List<A> reversed() {
        LazyRef reverser$module = new LazyRef();
        this.foreach(this.reverser$2(reverser$module));
        return this.reverser$2(reverser$module).elems();
    }

    public static /* synthetic */ int size$(TraversableOnce $this) {
        return $this.size();
    }

    @Override
    default public int size() {
        LazyRef counter$module = new LazyRef();
        this.foreach(this.counter$2(counter$module));
        return this.counter$2(counter$module).result();
    }

    public static /* synthetic */ boolean nonEmpty$(TraversableOnce $this) {
        return $this.nonEmpty();
    }

    @Override
    default public boolean nonEmpty() {
        return !this.isEmpty();
    }

    public static /* synthetic */ int count$(TraversableOnce $this, Function1 p) {
        return $this.count(p);
    }

    @Override
    default public int count(Function1<A, Object> p) {
        TraversableOnce$counter$3$ traversableOnce$counter$3$;
        LazyRef<TraversableOnce$counter$3$> counter$module = new LazyRef<TraversableOnce$counter$3$>();
        this.foreach(this.counter$4(counter$module, p));
        if (counter$module.initialized()) {
            traversableOnce$counter$3$ = (TraversableOnce$counter$3$)counter$module.value();
        } else {
            TraversableOnce$counter$3$ traversableOnce$counter$3$2;
            synchronized (counter$module) {
                traversableOnce$counter$3$2 = counter$module.initialized() ? (TraversableOnce$counter$3$)counter$module.value() : counter$module.initialize(new TraversableOnce$counter$3$(null, p));
            }
            traversableOnce$counter$3$ = traversableOnce$counter$3$2;
        }
        return traversableOnce$counter$3$.result();
    }

    public static /* synthetic */ Option collectFirst$(TraversableOnce $this, PartialFunction pf) {
        return $this.collectFirst(pf);
    }

    default public <B> Option<B> collectFirst(PartialFunction<A, B> pf) {
        Object object = new Object();
        try {
            Iterator iterator2;
            if (this instanceof Iterator) {
                iterator2 = (Iterator)this;
            } else if (this instanceof GenIterable) {
                iterator2 = this.toIterator();
            } else {
                this.foreach(pf.runWith((Function1<Object, Nothing$> & java.io.Serializable & Serializable)b -> {
                    throw new NonLocalReturnControl<Some<Object>>(object, new Some<Object>(b));
                }));
                return None$.MODULE$;
            }
            AbstractFunction1 sentinel = new AbstractFunction1<A, Object>(null){

                public $anon$1 apply(A a) {
                    return this;
                }
            };
            while (iterator2.hasNext()) {
                Object x = pf.applyOrElse(iterator2.next(), sentinel);
                if (x == sentinel) continue;
                return new Some(x);
            }
            return None$.MODULE$;
        }
        catch (NonLocalReturnControl ex) {
            if (ex.key() == object) {
                return (Option)ex.value();
            }
            throw ex;
        }
    }

    public static /* synthetic */ Object $div$colon$(TraversableOnce $this, Object z, Function2 op) {
        return $this.$div$colon(z, op);
    }

    @Override
    default public <B> B $div$colon(B z, Function2<B, A, B> op) {
        return this.foldLeft(z, op);
    }

    public static /* synthetic */ Object $colon$bslash$(TraversableOnce $this, Object z, Function2 op) {
        return $this.$colon$bslash(z, op);
    }

    @Override
    default public <B> B $colon$bslash(B z, Function2<A, B, B> op) {
        return this.foldRight(z, op);
    }

    public static /* synthetic */ Object foldLeft$(TraversableOnce $this, Object z, Function2 op) {
        return $this.foldLeft(z, op);
    }

    @Override
    default public <B> B foldLeft(B z, Function2<B, A, B> op) {
        TraversableOnce$folder$1$ traversableOnce$folder$1$;
        LazyRef<TraversableOnce$folder$1$> folder$module = new LazyRef<TraversableOnce$folder$1$>();
        this.foreach(this.folder$2(folder$module, z, op));
        if (folder$module.initialized()) {
            traversableOnce$folder$1$ = (TraversableOnce$folder$1$)folder$module.value();
        } else {
            TraversableOnce$folder$1$ traversableOnce$folder$1$2;
            synchronized (folder$module) {
                traversableOnce$folder$1$2 = folder$module.initialized() ? (TraversableOnce$folder$1$)folder$module.value() : folder$module.initialize(new TraversableOnce$folder$1$(null, z, op));
            }
            traversableOnce$folder$1$ = traversableOnce$folder$1$2;
        }
        return traversableOnce$folder$1$.result();
    }

    public static /* synthetic */ Object foldRight$(TraversableOnce $this, Object z, Function2 op) {
        return $this.foldRight(z, op);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public <B> B foldRight(B z, Function2<A, B, B> op) {
        void var4_4;
        List<A> list = this.reversed();
        if (list == null) {
            throw null;
        }
        List<A> foldLeft_this = list;
        Object foldLeft_acc = z;
        LinearSeqOptimized foldLeft_these = foldLeft_this;
        while (!foldLeft_these.isEmpty()) {
            Object a = foldLeft_these.head();
            foldLeft_acc = op.apply(a, foldLeft_acc);
            foldLeft_these = (LinearSeqOptimized)foldLeft_these.tail();
        }
        return var4_4;
    }

    public static /* synthetic */ Object reduceLeft$(TraversableOnce $this, Function2 op) {
        return $this.reduceLeft(op);
    }

    default public <B> B reduceLeft(Function2<B, A, B> op) {
        TraversableOnce$reducer$1$ traversableOnce$reducer$1$;
        LazyRef<TraversableOnce$reducer$1$> reducer$module = new LazyRef<TraversableOnce$reducer$1$>();
        if (this.isEmpty()) {
            throw new UnsupportedOperationException("empty.reduceLeft");
        }
        this.foreach(this.reducer$2(reducer$module, op));
        if (reducer$module.initialized()) {
            traversableOnce$reducer$1$ = (TraversableOnce$reducer$1$)reducer$module.value();
        } else {
            TraversableOnce$reducer$1$ traversableOnce$reducer$1$2;
            synchronized (reducer$module) {
                traversableOnce$reducer$1$2 = reducer$module.initialized() ? (TraversableOnce$reducer$1$)reducer$module.value() : reducer$module.initialize(new TraversableOnce$reducer$1$(null, op));
            }
            traversableOnce$reducer$1$ = traversableOnce$reducer$1$2;
        }
        return traversableOnce$reducer$1$.acc();
    }

    public static /* synthetic */ Object reduceRight$(TraversableOnce $this, Function2 op) {
        return $this.reduceRight(op);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public <B> B reduceRight(Function2<A, B, B> op) {
        void reduceLeft_op;
        if (this.isEmpty()) {
            throw new UnsupportedOperationException("empty.reduceRight");
        }
        List<A> list = this.reversed();
        Function2<Object, Object, Object> & java.io.Serializable & Serializable intersect = (Function2<Object, Object, Object> & java.io.Serializable & Serializable)(x, y) -> op.apply(y, x);
        if (list == null) {
            throw null;
        }
        List<A> reduceLeft_this = list;
        if (reduceLeft_this.isEmpty()) {
            throw new UnsupportedOperationException("empty.reduceLeft");
        }
        return (B)((LinearSeqOptimized)reduceLeft_this.tail()).foldLeft(reduceLeft_this.head(), reduceLeft_op);
    }

    public static /* synthetic */ Option reduceLeftOption$(TraversableOnce $this, Function2 op) {
        return $this.reduceLeftOption(op);
    }

    @Override
    default public <B> Option<B> reduceLeftOption(Function2<B, A, B> op) {
        if (this.isEmpty()) {
            return None$.MODULE$;
        }
        return new Some<B>(this.reduceLeft(op));
    }

    public static /* synthetic */ Option reduceRightOption$(TraversableOnce $this, Function2 op) {
        return $this.reduceRightOption(op);
    }

    @Override
    default public <B> Option<B> reduceRightOption(Function2<A, B, B> op) {
        if (this.isEmpty()) {
            return None$.MODULE$;
        }
        return new Some<B>(this.reduceRight(op));
    }

    public static /* synthetic */ Object reduce$(TraversableOnce $this, Function2 op) {
        return $this.reduce(op);
    }

    @Override
    default public <A1> A1 reduce(Function2<A1, A1, A1> op) {
        return this.reduceLeft(op);
    }

    public static /* synthetic */ Option reduceOption$(TraversableOnce $this, Function2 op) {
        return $this.reduceOption(op);
    }

    @Override
    default public <A1> Option<A1> reduceOption(Function2<A1, A1, A1> op) {
        return this.reduceLeftOption(op);
    }

    public static /* synthetic */ Object fold$(TraversableOnce $this, Object z, Function2 op) {
        return $this.fold(z, op);
    }

    @Override
    default public <A1> A1 fold(A1 z, Function2<A1, A1, A1> op) {
        return this.foldLeft(z, op);
    }

    public static /* synthetic */ Object aggregate$(TraversableOnce $this, Function0 z, Function2 seqop, Function2 combop) {
        return $this.aggregate(z, seqop, combop);
    }

    @Override
    default public <B> B aggregate(Function0<B> z, Function2<B, A, B> seqop, Function2<B, B, B> combop) {
        return this.foldLeft(z.apply(), seqop);
    }

    public static /* synthetic */ Object sum$(TraversableOnce $this, Numeric num) {
        return $this.sum(num);
    }

    @Override
    default public <B> B sum(Numeric<B> num) {
        return this.foldLeft(num.zero(), (Function2<Object, Object, Object> & java.io.Serializable & Serializable)(x, y) -> num.plus(x, y));
    }

    public static /* synthetic */ Object product$(TraversableOnce $this, Numeric num) {
        return $this.product(num);
    }

    @Override
    default public <B> B product(Numeric<B> num) {
        return this.foldLeft(num.one(), (Function2<Object, Object, Object> & java.io.Serializable & Serializable)(x, y) -> num.times(x, y));
    }

    public static /* synthetic */ Object min$(TraversableOnce $this, Ordering cmp) {
        return $this.min(cmp);
    }

    @Override
    default public <B> A min(Ordering<B> cmp) {
        if (this.isEmpty()) {
            throw new UnsupportedOperationException("empty.min");
        }
        return (A)this.reduceLeft((Function2<Object, Object, Object> & java.io.Serializable & Serializable)(x, y) -> {
            if (cmp.lteq(x, y)) {
                return x;
            }
            return y;
        });
    }

    public static /* synthetic */ Object max$(TraversableOnce $this, Ordering cmp) {
        return $this.max(cmp);
    }

    @Override
    default public <B> A max(Ordering<B> cmp) {
        if (this.isEmpty()) {
            throw new UnsupportedOperationException("empty.max");
        }
        return (A)this.reduceLeft((Function2<Object, Object, Object> & java.io.Serializable & Serializable)(x, y) -> {
            if (cmp.gteq(x, y)) {
                return x;
            }
            return y;
        });
    }

    public static /* synthetic */ Object maxBy$(TraversableOnce $this, Function1 f, Ordering cmp) {
        return $this.maxBy(f, cmp);
    }

    @Override
    default public <B> A maxBy(Function1<A, B> f, Ordering<B> cmp) {
        TraversableOnce$maxer$1$ traversableOnce$maxer$1$;
        LazyRef<TraversableOnce$maxer$1$> maxer$module = new LazyRef<TraversableOnce$maxer$1$>();
        if (this.isEmpty()) {
            throw new UnsupportedOperationException("empty.maxBy");
        }
        this.foreach(this.maxer$2(maxer$module, f, cmp));
        if (maxer$module.initialized()) {
            traversableOnce$maxer$1$ = (TraversableOnce$maxer$1$)maxer$module.value();
        } else {
            TraversableOnce$maxer$1$ traversableOnce$maxer$1$2;
            synchronized (maxer$module) {
                traversableOnce$maxer$1$2 = maxer$module.initialized() ? (TraversableOnce$maxer$1$)maxer$module.value() : maxer$module.initialize(new TraversableOnce$maxer$1$(null, f, cmp));
            }
            traversableOnce$maxer$1$ = traversableOnce$maxer$1$2;
        }
        return traversableOnce$maxer$1$.maxElem();
    }

    public static /* synthetic */ Object minBy$(TraversableOnce $this, Function1 f, Ordering cmp) {
        return $this.minBy(f, cmp);
    }

    @Override
    default public <B> A minBy(Function1<A, B> f, Ordering<B> cmp) {
        TraversableOnce$miner$1$ traversableOnce$miner$1$;
        LazyRef<TraversableOnce$miner$1$> miner$module = new LazyRef<TraversableOnce$miner$1$>();
        if (this.isEmpty()) {
            throw new UnsupportedOperationException("empty.minBy");
        }
        this.foreach(this.miner$2(miner$module, f, cmp));
        if (miner$module.initialized()) {
            traversableOnce$miner$1$ = (TraversableOnce$miner$1$)miner$module.value();
        } else {
            TraversableOnce$miner$1$ traversableOnce$miner$1$2;
            synchronized (miner$module) {
                traversableOnce$miner$1$2 = miner$module.initialized() ? (TraversableOnce$miner$1$)miner$module.value() : miner$module.initialize(new TraversableOnce$miner$1$(null, f, cmp));
            }
            traversableOnce$miner$1$ = traversableOnce$miner$1$2;
        }
        return traversableOnce$miner$1$.minElem();
    }

    public static /* synthetic */ void copyToBuffer$(TraversableOnce $this, Buffer dest) {
        $this.copyToBuffer(dest);
    }

    default public <B> void copyToBuffer(Buffer<B> dest) {
        dest.$plus$plus$eq(this.seq());
    }

    public static /* synthetic */ void copyToArray$(TraversableOnce $this, Object xs, int start) {
        $this.copyToArray(xs, start);
    }

    @Override
    default public <B> void copyToArray(Object xs, int start) {
        this.copyToArray(xs, start, ScalaRunTime$.MODULE$.array_length(xs) - start);
    }

    public static /* synthetic */ void copyToArray$(TraversableOnce $this, Object xs) {
        $this.copyToArray(xs);
    }

    @Override
    default public <B> void copyToArray(Object xs) {
        this.copyToArray(xs, 0, ScalaRunTime$.MODULE$.array_length(xs));
    }

    public static /* synthetic */ Object toArray$(TraversableOnce $this, ClassTag evidence$1) {
        return $this.toArray(evidence$1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public <B> Object toArray(ClassTag<B> evidence$1) {
        if (this.isTraversableAgain()) {
            void var2_2;
            Object result2 = evidence$1.newArray(this.size());
            this.copyToArray(result2, 0);
            return var2_2;
        }
        return this.toBuffer().toArray(evidence$1);
    }

    @Override
    public Traversable<A> toTraversable();

    public static /* synthetic */ List toList$(TraversableOnce $this) {
        return $this.toList();
    }

    @Override
    default public List<A> toList() {
        return this.to(List$.MODULE$.canBuildFrom());
    }

    public static /* synthetic */ Iterable toIterable$(TraversableOnce $this) {
        return $this.toIterable();
    }

    @Override
    default public Iterable<A> toIterable() {
        return this.toStream();
    }

    public static /* synthetic */ Seq toSeq$(TraversableOnce $this) {
        return $this.toSeq();
    }

    @Override
    default public Seq<A> toSeq() {
        return this.toStream();
    }

    public static /* synthetic */ IndexedSeq toIndexedSeq$(TraversableOnce $this) {
        return $this.toIndexedSeq();
    }

    @Override
    default public IndexedSeq<A> toIndexedSeq() {
        return this.to(Predef$.MODULE$.fallbackStringCanBuildFrom());
    }

    public static /* synthetic */ Buffer toBuffer$(TraversableOnce $this) {
        return $this.toBuffer();
    }

    @Override
    default public <B> Buffer<B> toBuffer() {
        return this.to(ArrayBuffer$.MODULE$.canBuildFrom());
    }

    public static /* synthetic */ Set toSet$(TraversableOnce $this) {
        return $this.toSet();
    }

    @Override
    default public <B> Set<B> toSet() {
        return this.to(Set$.MODULE$.canBuildFrom());
    }

    public static /* synthetic */ Vector toVector$(TraversableOnce $this) {
        return $this.toVector();
    }

    @Override
    default public Vector<A> toVector() {
        return this.to(Vector$.MODULE$.canBuildFrom());
    }

    public static /* synthetic */ Object to$(TraversableOnce $this, CanBuildFrom cbf) {
        return $this.to(cbf);
    }

    @Override
    default public <Col> Col to(CanBuildFrom<Nothing$, A, Col> cbf) {
        Builder<A, Col> b = cbf.apply();
        b.$plus$plus$eq(this.seq());
        return b.result();
    }

    public static /* synthetic */ Map toMap$(TraversableOnce $this, Predef$.less.colon.less ev) {
        return $this.toMap(ev);
    }

    @Override
    default public <T, U> Map<T, U> toMap(Predef$.less.colon.less<A, Tuple2<T, U>> ev) {
        Builder b = Map$.MODULE$.newBuilder();
        b.$plus$plus$eq(this.seq());
        return b.result();
    }

    public static /* synthetic */ String mkString$(TraversableOnce $this, String start, String sep, String end) {
        return $this.mkString(start, sep, end);
    }

    @Override
    default public String mkString(String start, String sep, String end) {
        return this.addString(new StringBuilder(), start, sep, end).toString();
    }

    public static /* synthetic */ String mkString$(TraversableOnce $this, String sep) {
        return $this.mkString(sep);
    }

    @Override
    default public String mkString(String sep) {
        return this.mkString("", sep, "");
    }

    public static /* synthetic */ String mkString$(TraversableOnce $this) {
        return $this.mkString();
    }

    @Override
    default public String mkString() {
        return this.mkString("");
    }

    public static /* synthetic */ StringBuilder addString$(TraversableOnce $this, StringBuilder b, String start, String sep, String end) {
        return $this.addString(b, start, sep, end);
    }

    default public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
        LazyRef appender$module = new LazyRef();
        b.append(start);
        this.foreach(this.appender$2(appender$module, b, sep));
        b.append(end);
        return b;
    }

    public static /* synthetic */ StringBuilder addString$(TraversableOnce $this, StringBuilder b, String sep) {
        return $this.addString(b, sep);
    }

    default public StringBuilder addString(StringBuilder b, String sep) {
        return this.addString(b, "", sep, "");
    }

    public static /* synthetic */ StringBuilder addString$(TraversableOnce $this, StringBuilder b) {
        return $this.addString(b);
    }

    default public StringBuilder addString(StringBuilder b) {
        return this.addString(b, "");
    }

    private static /* synthetic */ TraversableOnce$reverser$1$ reverser$lzycompute$1(LazyRef reverser$module$1) {
        synchronized (reverser$module$1) {
            TraversableOnce$reverser$1$ traversableOnce$reverser$1$ = reverser$module$1.initialized() ? (TraversableOnce$reverser$1$)reverser$module$1.value() : reverser$module$1.initialize(new TraversableOnce$reverser$1$(null));
            return traversableOnce$reverser$1$;
        }
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private TraversableOnce$reverser$1$ reverser$2(LazyRef reverser$module$1) {
        if (reverser$module$1.initialized()) {
            return (TraversableOnce$reverser$1$)reverser$module$1.value();
        }
        return TraversableOnce.reverser$lzycompute$1(reverser$module$1);
    }

    private static /* synthetic */ TraversableOnce$counter$1$ counter$lzycompute$1(LazyRef counter$module$1) {
        synchronized (counter$module$1) {
            TraversableOnce$counter$1$ traversableOnce$counter$1$ = counter$module$1.initialized() ? (TraversableOnce$counter$1$)counter$module$1.value() : counter$module$1.initialize(new TraversableOnce$counter$1$(null));
            return traversableOnce$counter$1$;
        }
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private TraversableOnce$counter$1$ counter$2(LazyRef counter$module$1) {
        if (counter$module$1.initialized()) {
            return (TraversableOnce$counter$1$)counter$module$1.value();
        }
        return TraversableOnce.counter$lzycompute$1(counter$module$1);
    }

    private static /* synthetic */ TraversableOnce$counter$3$ counter$lzycompute$2(LazyRef counter$module$2, Function1 p$1) {
        synchronized (counter$module$2) {
            TraversableOnce$counter$3$ traversableOnce$counter$3$ = counter$module$2.initialized() ? (TraversableOnce$counter$3$)counter$module$2.value() : counter$module$2.initialize(new TraversableOnce$counter$3$(null, p$1));
            return traversableOnce$counter$3$;
        }
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private TraversableOnce$counter$3$ counter$4(LazyRef counter$module$2, Function1 p$1) {
        TraversableOnce$counter$3$ traversableOnce$counter$3$;
        if (counter$module$2.initialized()) {
            return (TraversableOnce$counter$3$)counter$module$2.value();
        }
        synchronized (counter$module$2) {
            traversableOnce$counter$3$ = counter$module$2.initialized() ? (TraversableOnce$counter$3$)counter$module$2.value() : counter$module$2.initialize(new TraversableOnce$counter$3$(null, p$1));
        }
        return traversableOnce$counter$3$;
    }

    private static /* synthetic */ TraversableOnce$folder$1$ folder$lzycompute$1(LazyRef folder$module$1, Object z$1, Function2 op$1) {
        synchronized (folder$module$1) {
            TraversableOnce$folder$1$ traversableOnce$folder$1$ = folder$module$1.initialized() ? (TraversableOnce$folder$1$)folder$module$1.value() : folder$module$1.initialize(new TraversableOnce$folder$1$(null, z$1, op$1));
            return traversableOnce$folder$1$;
        }
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private TraversableOnce$folder$1$ folder$2(LazyRef folder$module$1, Object z$1, Function2 op$1) {
        TraversableOnce$folder$1$ traversableOnce$folder$1$;
        if (folder$module$1.initialized()) {
            return (TraversableOnce$folder$1$)folder$module$1.value();
        }
        synchronized (folder$module$1) {
            traversableOnce$folder$1$ = folder$module$1.initialized() ? (TraversableOnce$folder$1$)folder$module$1.value() : folder$module$1.initialize(new TraversableOnce$folder$1$(null, z$1, op$1));
        }
        return traversableOnce$folder$1$;
    }

    private static /* synthetic */ TraversableOnce$reducer$1$ reducer$lzycompute$1(LazyRef reducer$module$1, Function2 op$3) {
        synchronized (reducer$module$1) {
            TraversableOnce$reducer$1$ traversableOnce$reducer$1$ = reducer$module$1.initialized() ? (TraversableOnce$reducer$1$)reducer$module$1.value() : reducer$module$1.initialize(new TraversableOnce$reducer$1$(null, op$3));
            return traversableOnce$reducer$1$;
        }
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private TraversableOnce$reducer$1$ reducer$2(LazyRef reducer$module$1, Function2 op$3) {
        TraversableOnce$reducer$1$ traversableOnce$reducer$1$;
        if (reducer$module$1.initialized()) {
            return (TraversableOnce$reducer$1$)reducer$module$1.value();
        }
        synchronized (reducer$module$1) {
            traversableOnce$reducer$1$ = reducer$module$1.initialized() ? (TraversableOnce$reducer$1$)reducer$module$1.value() : reducer$module$1.initialize(new TraversableOnce$reducer$1$(null, op$3));
        }
        return traversableOnce$reducer$1$;
    }

    private static /* synthetic */ TraversableOnce$maxer$1$ maxer$lzycompute$1(LazyRef maxer$module$1, Function1 f$1, Ordering cmp$3) {
        synchronized (maxer$module$1) {
            TraversableOnce$maxer$1$ traversableOnce$maxer$1$ = maxer$module$1.initialized() ? (TraversableOnce$maxer$1$)maxer$module$1.value() : maxer$module$1.initialize(new TraversableOnce$maxer$1$(null, f$1, cmp$3));
            return traversableOnce$maxer$1$;
        }
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private TraversableOnce$maxer$1$ maxer$2(LazyRef maxer$module$1, Function1 f$1, Ordering cmp$3) {
        TraversableOnce$maxer$1$ traversableOnce$maxer$1$;
        if (maxer$module$1.initialized()) {
            return (TraversableOnce$maxer$1$)maxer$module$1.value();
        }
        synchronized (maxer$module$1) {
            traversableOnce$maxer$1$ = maxer$module$1.initialized() ? (TraversableOnce$maxer$1$)maxer$module$1.value() : maxer$module$1.initialize(new TraversableOnce$maxer$1$(null, f$1, cmp$3));
        }
        return traversableOnce$maxer$1$;
    }

    private static /* synthetic */ TraversableOnce$miner$1$ miner$lzycompute$1(LazyRef miner$module$1, Function1 f$2, Ordering cmp$4) {
        synchronized (miner$module$1) {
            TraversableOnce$miner$1$ traversableOnce$miner$1$ = miner$module$1.initialized() ? (TraversableOnce$miner$1$)miner$module$1.value() : miner$module$1.initialize(new TraversableOnce$miner$1$(null, f$2, cmp$4));
            return traversableOnce$miner$1$;
        }
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private TraversableOnce$miner$1$ miner$2(LazyRef miner$module$1, Function1 f$2, Ordering cmp$4) {
        TraversableOnce$miner$1$ traversableOnce$miner$1$;
        if (miner$module$1.initialized()) {
            return (TraversableOnce$miner$1$)miner$module$1.value();
        }
        synchronized (miner$module$1) {
            traversableOnce$miner$1$ = miner$module$1.initialized() ? (TraversableOnce$miner$1$)miner$module$1.value() : miner$module$1.initialize(new TraversableOnce$miner$1$(null, f$2, cmp$4));
        }
        return traversableOnce$miner$1$;
    }

    private static /* synthetic */ TraversableOnce$appender$1$ appender$lzycompute$1(LazyRef appender$module$1, StringBuilder b$1, String sep$1) {
        synchronized (appender$module$1) {
            TraversableOnce$appender$1$ traversableOnce$appender$1$ = appender$module$1.initialized() ? (TraversableOnce$appender$1$)appender$module$1.value() : appender$module$1.initialize(new TraversableOnce$appender$1$(null, b$1, sep$1));
            return traversableOnce$appender$1$;
        }
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private TraversableOnce$appender$1$ appender$2(LazyRef appender$module$1, StringBuilder b$1, String sep$1) {
        if (appender$module$1.initialized()) {
            return (TraversableOnce$appender$1$)appender$module$1.value();
        }
        return TraversableOnce.appender$lzycompute$1(appender$module$1, b$1, sep$1);
    }

    public static void $init$(TraversableOnce $this) {
    }

    public static abstract class BufferedCanBuildFrom<A, CC extends TraversableOnce<Object>>
    implements CanBuildFrom<CC, A, CC> {
        public abstract <B> CC bufferToColl(ArrayBuffer<B> var1);

        public abstract <B> CC traversableToColl(GenTraversable<B> var1);

        public Builder<A, CC> newIterator() {
            return new ArrayBuffer().mapResult((Function1<ArrayBuffer, TraversableOnce> & java.io.Serializable & Serializable)buff -> this.bufferToColl((ArrayBuffer)buff));
        }

        @Override
        public Builder<A, CC> apply(CC from) {
            Builder<Object, Object> builder = from instanceof GenericTraversableTemplate ? ((GenericTraversableTemplate)from).genericBuilder().mapResult((Function1<Traversable, TraversableOnce> & java.io.Serializable & Serializable)x0$1 -> this.traversableToColl((GenTraversable)x0$1)) : this.newIterator();
            return builder;
        }

        @Override
        public Builder<A, CC> apply() {
            return this.newIterator();
        }
    }

    public static class FlattenOps<A> {
        public final TraversableOnce<TraversableOnce<A>> scala$collection$TraversableOnce$FlattenOps$$travs;

        public Iterator<A> flatten() {
            return new AbstractIterator<A>(this){
                private final Iterator<TraversableOnce<A>> its;
                private Iterator<A> it;

                private Iterator<TraversableOnce<A>> its() {
                    return this.its;
                }

                private Iterator<A> it() {
                    return this.it;
                }

                private void it_$eq(Iterator<A> x$1) {
                    this.it = x$1;
                }

                public boolean hasNext() {
                    block2: {
                        while (!this.it().hasNext()) {
                            if (this.its().hasNext()) {
                                this.it_$eq(((GenTraversableOnce)this.its().next()).toIterator());
                                continue;
                            }
                            break block2;
                        }
                        return true;
                    }
                    return false;
                }

                public A next() {
                    if (this.hasNext()) {
                        return this.it().next();
                    }
                    return (A)Iterator$.MODULE$.empty().next();
                }
                {
                    this.its = $outer.scala$collection$TraversableOnce$FlattenOps$$travs.toIterator();
                    this.it = Iterator$.MODULE$.empty();
                }
            };
        }

        public FlattenOps(TraversableOnce<TraversableOnce<A>> travs) {
            this.scala$collection$TraversableOnce$FlattenOps$$travs = travs;
        }
    }

    public static class ForceImplicitAmbiguity {
    }

    public static class MonadOps<A> {
        private final TraversableOnce<A> trav;

        public <B> TraversableOnce<B> map(Function1<A, B> f) {
            return this.trav.toIterator().map(f);
        }

        public <B> TraversableOnce<B> flatMap(Function1<A, GenTraversableOnce<B>> f) {
            return this.trav.toIterator().flatMap(f);
        }

        public Iterator<A> withFilter(Function1<A, Object> p) {
            return this.trav.toIterator().filter(p);
        }

        public TraversableOnce<A> filter(Function1<A, Object> p) {
            return this.withFilter(p);
        }

        public MonadOps(TraversableOnce<A> trav) {
            this.trav = trav;
        }
    }

    public static class OnceCanBuildFrom<A>
    extends BufferedCanBuildFrom<A, TraversableOnce> {
        @Override
        public <B> Iterator<B> bufferToColl(ArrayBuffer<B> buff) {
            return buff.iterator();
        }

        @Override
        public <B> Traversable<B> traversableToColl(GenTraversable<B> t) {
            return t.seq();
        }
    }
}

