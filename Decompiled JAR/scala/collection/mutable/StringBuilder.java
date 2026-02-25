/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import java.util.Locale;
import java.util.regex.PatternSyntaxException;
import java.util.stream.IntStream;
import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.GenIterable;
import scala.collection.GenSeq;
import scala.collection.IndexedSeqOptimized;
import scala.collection.IterableLike;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.SeqLike;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.Growable;
import scala.collection.immutable.List;
import scala.collection.immutable.StringLike;
import scala.collection.mutable.AbstractSeq;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.GrowingBuilder;
import scala.collection.mutable.IndexedSeq;
import scala.collection.mutable.IndexedSeqLike;
import scala.collection.mutable.IndexedSeqView;
import scala.collection.mutable.ReusableBuilder;
import scala.math.Ordered;
import scala.reflect.ClassTag;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.util.matching.Regex;

@ScalaSignature(bytes="\u0006\u0001\rea\u0001\u0002&L\u0005IC\u0001B \u0001\u0003\u0006\u0004%Ia \u0005\u000b\u0003\u000b\u0001!\u0011!Q\u0001\n\u0005\u0005\u0001bBA\u0004\u0001\u0011\u0005\u0011\u0011\u0002\u0005\t\u0003\u001b\u0001\u0001\u0015\"\u0015\u0002\u0010!A\u0011\u0011\u0003\u0001!\n#\n\u0019\u0002\u0003\u0005\u0002\u001a\u0001\u0001K\u0011KA\u000e\u0011\u001d\t9\u0001\u0001C\u0001\u0003GAq!a\u0002\u0001\t\u0003\t\u0019\u0004C\u0004\u0002\b\u0001!\t!!\u000e\t\u000f\u0005\u001d\u0001\u0001\"\u0001\u0002<!9\u0011\u0011\t\u0001\u0005\u0002\u0005\r\u0003bBA&\u0001\u0011\u0005\u0013Q\n\u0005\b\u0003\u001f\u0002A\u0011AA)\u0011\u001d\ti\u0006\u0001C\u0001\u0003?Bq!!\u0019\u0001\t\u0003\t\u0019\u0007C\u0004\u0002:\u0001!\t!!\u0014\t\u000f\u0005%\u0004\u0001\"\u0001\u0002l!9\u0011\u0011\u000f\u0001\u0005\u0002\u0005M\u0004bBA=\u0001\u0011\u0005\u00131\u0010\u0005\b\u0003\u007f\u0002A\u0011AAA\u0011\u001d\t)\t\u0001C\u0001\u0003\u000fCq!a$\u0001\t\u0003\t\t\nC\u0004\u0002\u001c\u0002!\t!!(\t\u000f\u0005m\u0005\u0001\"\u0001\u0002$\"9\u00111\u0016\u0001\u0005\u0002\u00055\u0006bBAZ\u0001\u0011\u0005\u0011Q\u0017\u0005\b\u0003{\u0003A\u0011AA`\u0011\u001d\t)\r\u0001C\u0001\u0003\u000fDq!!4\u0001\t\u0003\ty\rC\u0004\u0002T\u0002!\t!!6\t\u000f\u0005M\u0007\u0001\"\u0001\u0002`\"9\u00111\u001b\u0001\u0005\u0002\u0005\r\bbBAc\u0001\u0011\u0005\u0011\u0011\u001e\u0005\b\u0003\u000b\u0004A\u0011AA{\u0011\u001d\t)\r\u0001C\u0001\u0003sDq!a5\u0001\t\u0003\u0011\u0019\u0001C\u0004\u0002T\u0002!\tA!\u0004\t\u000f\u0005M\u0007\u0001\"\u0001\u0003\u0018!9\u00111\u001b\u0001\u0005\u0002\t\u0005\u0002bBAj\u0001\u0011\u0005!Q\u0005\u0005\b\u0003'\u0004A\u0011\u0001B\u0018\u0011\u001d\t\u0019\u000e\u0001C\u0001\u0005sAq!a5\u0001\t\u0003\u0011\u0019\u0005C\u0004\u0003H\u0001!\tA!\u0013\t\u000f\t=\u0003\u0001\"\u0001\u0003R!9!\u0011\f\u0001\u0005\u0002\tm\u0003b\u0002B3\u0001\u0011\u0005!q\r\u0005\b\u0005K\u0002A\u0011\u0001B7\u0011\u001d\u0011I\u0006\u0001C\u0001\u0005gBqA!\u0017\u0001\t\u0003\u0011I\bC\u0004\u0003f\u0001!\tAa \t\u000f\t\u0015\u0004\u0001\"\u0001\u0003\u0006\"9!Q\r\u0001\u0005\u0002\t-\u0005b\u0002B3\u0001\u0011\u0005!\u0011\u0013\u0005\b\u0005K\u0002A\u0011\u0001BL\u0011\u001d\u0011)\u0007\u0001C\u0001\u0005;CqA!\u001a\u0001\t\u0003\u0011\u0019\u000bC\u0004\u0003f\u0001!\tA!+\t\u000f\t=\u0006\u0001\"\u0001\u00032\"9!q\u0016\u0001\u0005\u0002\tU\u0006b\u0002B_\u0001\u0011\u0005!q\u0018\u0005\b\u0005{\u0003A\u0011\u0001Bb\u0011\u001d\u0011I\r\u0001C!\u0003\u001fAqA!9\u0001\t\u0003\n\u0019\u0004C\u0004\u0003d\u0002!\t!a\r\t\u000f\t\u0015\b\u0001\"\u0011\u0003h\"9!Q\u001e\u0001\u0005B\t=\bb\u0002By\u0001\u0011\u0005!1_\u0004\b\u0007\u0003Y\u0005\u0012AB\u0002\r\u0019Q5\n#\u0001\u0004\u0006!9\u0011q\u0001$\u0005\u0002\r5\u0001bBA\r\r\u0012\u0005\u0011q\u0002\u0005\n\u0007\u001f1\u0015\u0011!C\u0005\u0007#\u0011Qb\u0015;sS:<')^5mI\u0016\u0014(B\u0001'N\u0003\u001diW\u000f^1cY\u0016T!AT(\u0002\u0015\r|G\u000e\\3di&|gNC\u0001Q\u0003\u0015\u00198-\u00197b\u0007\u0001\u0019r\u0001A*\\G\u001al7\u0010E\u0002U+^k\u0011aS\u0005\u0003-.\u00131\"\u00112tiJ\f7\r^*fcB\u0011\u0001,W\u0007\u0002\u001f&\u0011!l\u0014\u0002\u0005\u0007\"\f'\u000f\u0005\u0002]C6\tQL\u0003\u0002_?\u0006!A.\u00198h\u0015\u0005\u0001\u0017\u0001\u00026bm\u0006L!AY/\u0003\u0019\rC\u0017M]*fcV,gnY3\u0011\u0007Q#w+\u0003\u0002f\u0017\nQ\u0011J\u001c3fq\u0016$7+Z9\u0011\u0007\u001dTG.D\u0001i\u0015\tIW*A\u0005j[6,H/\u00192mK&\u00111\u000e\u001b\u0002\u000b'R\u0014\u0018N\\4MS.,\u0007C\u0001+\u0001!\u0011!fn\u00169\n\u0005=\\%a\u0004*fkN\f'\r\\3Ck&dG-\u001a:\u0011\u0005EDhB\u0001:w!\t\u0019x*D\u0001u\u0015\t)\u0018+\u0001\u0004=e>|GOP\u0005\u0003o>\u000ba\u0001\u0015:fI\u00164\u0017BA={\u0005\u0019\u0019FO]5oO*\u0011qo\u0014\t\u00031rL!!`(\u0003\u0019M+'/[1mSj\f'\r\\3\u0002\u0015UtG-\u001a:ms&tw-\u0006\u0002\u0002\u0002A\u0019A,a\u0001\n\u0005)k\u0016aC;oI\u0016\u0014H._5oO\u0002\na\u0001P5oSRtDc\u00017\u0002\f!1ap\u0001a\u0001\u0003\u0003\ta\u0002\u001e5jg\u000e{G\u000e\\3di&|g.F\u0001m\u00031!xnQ8mY\u0016\u001cG/[8o)\ra\u0017Q\u0003\u0005\u0007\u0003/)\u0001\u0019\u00017\u0002\tI,\u0007O]\u0001\u000b]\u0016<()^5mI\u0016\u0014XCAA\u000f!\u0015!\u0016qD,m\u0013\r\t\tc\u0013\u0002\u000f\u000fJ|w/\u001b8h\u0005VLG\u000eZ3s)\u0015a\u0017QEA\u0018\u0011\u001d\t9c\u0002a\u0001\u0003S\tA\"\u001b8ji\u000e\u000b\u0007/Y2jif\u00042\u0001WA\u0016\u0013\r\tic\u0014\u0002\u0004\u0013:$\bBBA\u0019\u000f\u0001\u0007\u0001/A\u0005j]&$h+\u00197vKR\tA\u000eF\u0002m\u0003oAq!!\u000f\n\u0001\u0004\tI#\u0001\u0005dCB\f7-\u001b;z)\ra\u0017Q\b\u0005\u0007\u0003\u007fQ\u0001\u0019\u00019\u0002\u0007M$(/A\u0004u_\u0006\u0013(/Y=\u0016\u0005\u0005\u0015\u0003\u0003\u0002-\u0002H]K1!!\u0013P\u0005\u0015\t%O]1z\u0003\u0019aWM\\4uQV\u0011\u0011\u0011F\u0001\u000bY\u0016tw\r\u001e5`I\u0015\fH\u0003BA*\u00033\u00022\u0001WA+\u0013\r\t9f\u0014\u0002\u0005+:LG\u000fC\u0004\u0002\\5\u0001\r!!\u000b\u0002\u00039\fQa\u00197fCJ$\"!a\u0015\u0002\u0013M,G\u000fT3oORDG\u0003BA*\u0003KBq!a\u001a\u0010\u0001\u0004\tI#A\u0002mK:\fa\"\u001a8tkJ,7)\u00199bG&$\u0018\u0010\u0006\u0003\u0002T\u00055\u0004bBA8#\u0001\u0007\u0011\u0011F\u0001\f]\u0016<8)\u00199bG&$\u00180\u0001\u0004dQ\u0006\u0014\u0018\t\u001e\u000b\u0004/\u0006U\u0004bBA<%\u0001\u0007\u0011\u0011F\u0001\u0006S:$W\r_\u0001\u0006CB\u0004H.\u001f\u000b\u0004/\u0006u\u0004bBA<'\u0001\u0007\u0011\u0011F\u0001\rI\u0016dW\r^3DQ\u0006\u0014\u0018\t\u001e\u000b\u0004Y\u0006\r\u0005bBA<)\u0001\u0007\u0011\u0011F\u0001\ng\u0016$8\t[1s\u0003R$b!a\u0015\u0002\n\u0006-\u0005bBA<+\u0001\u0007\u0011\u0011\u0006\u0005\u0007\u0003\u001b+\u0002\u0019A,\u0002\u0005\rD\u0017AB;qI\u0006$X\r\u0006\u0004\u0002T\u0005M\u0015q\u0013\u0005\b\u0003+3\u0002\u0019AA\u0015\u0003\u0005I\u0007BBAM-\u0001\u0007q+A\u0001d\u0003%\u0019XOY:ue&tw\rF\u0002q\u0003?Cq!!)\u0018\u0001\u0004\tI#A\u0003ti\u0006\u0014H\u000fF\u0003q\u0003K\u000b9\u000bC\u0004\u0002\"b\u0001\r!!\u000b\t\u000f\u0005%\u0006\u00041\u0001\u0002*\u0005\u0019QM\u001c3\u0002\u0017M,(mU3rk\u0016t7-\u001a\u000b\u00067\u0006=\u0016\u0011\u0017\u0005\b\u0003CK\u0002\u0019AA\u0015\u0011\u001d\tI+\u0007a\u0001\u0003S\t\u0001\u0002\n9mkN$S-\u001d\u000b\u0005\u0003o\u000bI,D\u0001\u0001\u0011\u0019\tYL\u0007a\u0001/\u0006\t\u00010A\u0007%a2,8\u000f\n9mkN$S-\u001d\u000b\u0005\u0003o\u000b\t\r\u0003\u0004\u0002Dn\u0001\r\u0001]\u0001\u0002g\u0006I\u0011\r\u001d9f]\u0012\fE\u000e\u001c\u000b\u0004Y\u0006%\u0007BBAf9\u0001\u0007\u0001/\u0001\u0002yg\u0006)A\u0005\u001d7vgR!\u0011qWAi\u0011\u0019\tY,\ba\u0001/\u00061\u0011\r\u001d9f]\u0012$2\u0001\\Al\u0011\u001d\tYL\ba\u0001\u00033\u00042\u0001WAn\u0013\r\tin\u0014\u0002\u0004\u0003:LHc\u00017\u0002b\"1\u00111Y\u0010A\u0002A$2\u0001\\As\u0011\u0019\t9\u000f\ta\u0001Y\u0006\u00111O\u0019\u000b\u0004Y\u0006-\bbBAfC\u0001\u0007\u0011Q\u001e\t\u0006\u0003_\f\tpV\u0007\u0002\u001b&\u0019\u00111_'\u0003\u001fQ\u0013\u0018M^3sg\u0006\u0014G.Z(oG\u0016$2\u0001\\A|\u0011\u001d\tYM\ta\u0001\u0003\u000b\"r\u0001\\A~\u0003{\u0014\t\u0001C\u0004\u0002L\u000e\u0002\r!!\u0012\t\u000f\u0005}8\u00051\u0001\u0002*\u00051qN\u001a4tKRDq!a\u001a$\u0001\u0004\tI\u0003F\u0002m\u0005\u000bAq!a/%\u0001\u0004\u00119\u0001E\u0002Y\u0005\u0013I1Aa\u0003P\u0005\u001d\u0011un\u001c7fC:$2\u0001\u001cB\b\u0011\u001d\tY,\na\u0001\u0005#\u00012\u0001\u0017B\n\u0013\r\u0011)b\u0014\u0002\u0005\u0005f$X\rF\u0002m\u00053Aq!a/'\u0001\u0004\u0011Y\u0002E\u0002Y\u0005;I1Aa\bP\u0005\u0015\u0019\u0006n\u001c:u)\ra'1\u0005\u0005\b\u0003w;\u0003\u0019AA\u0015)\ra'q\u0005\u0005\b\u0003wC\u0003\u0019\u0001B\u0015!\rA&1F\u0005\u0004\u0005[y%\u0001\u0002'p]\u001e$2\u0001\u001cB\u0019\u0011\u001d\tY,\u000ba\u0001\u0005g\u00012\u0001\u0017B\u001b\u0013\r\u00119d\u0014\u0002\u0006\r2|\u0017\r\u001e\u000b\u0004Y\nm\u0002bBA^U\u0001\u0007!Q\b\t\u00041\n}\u0012b\u0001B!\u001f\n1Ai\\;cY\u0016$2\u0001\u001cB#\u0011\u0019\tYl\u000ba\u0001/\u00061A-\u001a7fi\u0016$R\u0001\u001cB&\u0005\u001bBq!!)-\u0001\u0004\tI\u0003C\u0004\u0002*2\u0002\r!!\u000b\u0002\u000fI,\u0007\u000f\\1dKR9ANa\u0015\u0003V\t]\u0003bBAQ[\u0001\u0007\u0011\u0011\u0006\u0005\b\u0003Sk\u0003\u0019AA\u0015\u0011\u0019\ty$\fa\u0001a\u0006I\u0011N\\:feR\fE\u000e\u001c\u000b\nY\nu#q\fB1\u0005GBq!a\u001e/\u0001\u0004\tI\u0003C\u0004\u0002@9\u0002\r!!\u0012\t\u000f\u0005}h\u00061\u0001\u0002*!9\u0011q\r\u0018A\u0002\u0005%\u0012AB5og\u0016\u0014H\u000fF\u0003m\u0005S\u0012Y\u0007C\u0004\u0002x=\u0002\r!!\u000b\t\u000f\u0005mv\u00061\u0001\u0002ZR)ANa\u001c\u0003r!9\u0011q\u000f\u0019A\u0002\u0005%\u0002BBA^a\u0001\u0007\u0001\u000fF\u0003m\u0005k\u00129\bC\u0004\u0002xE\u0002\r!!\u000b\t\u000f\u0005-\u0017\u00071\u0001\u0002nR)ANa\u001f\u0003~!9\u0011q\u000f\u001aA\u0002\u0005%\u0002bBAfe\u0001\u0007\u0011Q\t\u000b\u0006Y\n\u0005%1\u0011\u0005\b\u0003o\u001a\u0004\u0019AA\u0015\u0011\u001d\tYl\ra\u0001\u0005\u000f!R\u0001\u001cBD\u0005\u0013Cq!a\u001e5\u0001\u0004\tI\u0003C\u0004\u0002<R\u0002\rA!\u0005\u0015\u000b1\u0014iIa$\t\u000f\u0005]T\u00071\u0001\u0002*!9\u00111X\u001bA\u0002\tmA#\u00027\u0003\u0014\nU\u0005bBA<m\u0001\u0007\u0011\u0011\u0006\u0005\b\u0003w3\u0004\u0019AA\u0015)\u0015a'\u0011\u0014BN\u0011\u001d\t9h\u000ea\u0001\u0003SAq!a/8\u0001\u0004\u0011I\u0003F\u0003m\u0005?\u0013\t\u000bC\u0004\u0002xa\u0002\r!!\u000b\t\u000f\u0005m\u0006\b1\u0001\u00034Q)AN!*\u0003(\"9\u0011qO\u001dA\u0002\u0005%\u0002bBA^s\u0001\u0007!Q\b\u000b\u0006Y\n-&Q\u0016\u0005\b\u0003oR\u0004\u0019AA\u0015\u0011\u0019\tYL\u000fa\u0001/\u00069\u0011N\u001c3fq>3G\u0003BA\u0015\u0005gCa!a\u0010<\u0001\u0004\u0001HCBA\u0015\u0005o\u0013I\f\u0003\u0004\u0002@q\u0002\r\u0001\u001d\u0005\b\u0005wc\u0004\u0019AA\u0015\u0003%1'o\\7J]\u0012,\u00070A\u0006mCN$\u0018J\u001c3fq>3G\u0003BA\u0015\u0005\u0003Da!a\u0010>\u0001\u0004\u0001HCBA\u0015\u0005\u000b\u00149\r\u0003\u0004\u0002@y\u0002\r\u0001\u001d\u0005\b\u0005ws\u0004\u0019AA\u0015\u0003\u001d\u0011XM^3sg\u0016Dsa\u0010Bg\u00053\u0014i\u000e\u0005\u0003\u0003P\nUWB\u0001Bi\u0015\r\u0011\u0019nT\u0001\u000bC:tw\u000e^1uS>t\u0017\u0002\u0002Bl\u0005#\u0014\u0011\"\\5he\u0006$\u0018n\u001c8\"\u0005\tm\u0017!\u001d1sKZ,'o]3aAI,G/\u001e:og\u0002\n\u0007E\\3xA%t7\u000f^1oG\u0016t\u0003\u0005I+tK\u0002\u0002'/\u001a<feN,7i\u001c8uK:$8\u000f\u0019\u0011u_\u0002*\b\u000fZ1uK\u0002Jg\u000e\t9mC\u000e,\u0007%\u00198eAI,G/\u001e:oAQD\u0017\r\u001e\u0011TiJLgn\u001a\"vS2$WM\u001d\u0011jiN,GN\u001a\u0018\"\u0005\t}\u0017!\u0002\u001a/q9\u0002\u0014!B2m_:,\u0017a\u0004:fm\u0016\u00148/Z\"p]R,g\u000e^:\u0002\u0011Q|7\u000b\u001e:j]\u001e$\"A!;\u0011\u0007q\u0013Y/\u0003\u0002z;\u0006AQn[*ue&tw-\u0006\u0002\u0003j\u00061!/Z:vYR$\u0012\u0001\u001d\u0015\b\u0001\t](Q B\u0000!\rA&\u0011`\u0005\u0004\u0005w|%\u0001E*fe&\fGNV3sg&|g.V%E\u0003\u00151\u0018\r\\;f=!IyVk\u00010.T\u000f !D*ue&twMQ;jY\u0012,'\u000f\u0005\u0002U\rN!aia\u0002|!\rA6\u0011B\u0005\u0004\u0007\u0017y%AB!osJ+g\r\u0006\u0002\u0004\u0004\u0005Y!/Z1e%\u0016\u001cx\u000e\u001c<f)\t\u0019\u0019\u0002E\u0002]\u0007+I1aa\u0006^\u0005\u0019y%M[3di\u0002")
public final class StringBuilder
extends AbstractSeq<Object>
implements CharSequence,
IndexedSeq<Object>,
StringLike<StringBuilder>,
ReusableBuilder<Object, String>,
Serializable {
    public static final long serialVersionUID = -8525408645367278351L;
    private final java.lang.StringBuilder underlying;

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
    public <NewTo> Builder<Object, NewTo> mapResult(Function1<String, NewTo> f) {
        return Builder.mapResult$(this, f);
    }

    @Override
    public Growable $plus$eq(Object elem1, Object elem2, Seq elems) {
        return Growable.$plus$eq$(this, elem1, elem2, elems);
    }

    @Override
    public Growable<Object> $plus$plus$eq(TraversableOnce<Object> xs) {
        return Growable.$plus$plus$eq$(this, xs);
    }

    @Override
    public Object slice(int from, int until) {
        return StringLike.slice$(this, from, until);
    }

    @Override
    public String $times(int n) {
        return StringLike.$times$(this, n);
    }

    @Override
    public int compare(String other) {
        return StringLike.compare$(this, other);
    }

    @Override
    public String stripLineEnd() {
        return StringLike.stripLineEnd$(this);
    }

    @Override
    public Iterator<String> linesWithSeparators() {
        return StringLike.linesWithSeparators$(this);
    }

    @Override
    public Iterator<String> lines() {
        return StringLike.lines$(this);
    }

    @Override
    public Iterator<String> linesIterator() {
        return StringLike.linesIterator$(this);
    }

    @Override
    public String capitalize() {
        return StringLike.capitalize$(this);
    }

    @Override
    public String stripPrefix(String prefix) {
        return StringLike.stripPrefix$(this, prefix);
    }

    @Override
    public String stripSuffix(String suffix) {
        return StringLike.stripSuffix$(this, suffix);
    }

    @Override
    public String replaceAllLiterally(String literal, String replacement) {
        return StringLike.replaceAllLiterally$(this, literal, replacement);
    }

    @Override
    public String stripMargin(char marginChar) {
        return StringLike.stripMargin$(this, marginChar);
    }

    @Override
    public String stripMargin() {
        return StringLike.stripMargin$(this);
    }

    @Override
    public String[] split(char separator) {
        return StringLike.split$((StringLike)this, separator);
    }

    @Override
    public String[] split(char[] separators) throws PatternSyntaxException {
        return StringLike.split$((StringLike)this, separators);
    }

    @Override
    public Regex r() {
        return StringLike.r$(this);
    }

    @Override
    public Regex r(Seq<String> groupNames) {
        return StringLike.r$(this, groupNames);
    }

    @Override
    public boolean toBoolean() {
        return StringLike.toBoolean$(this);
    }

    @Override
    public byte toByte() {
        return StringLike.toByte$(this);
    }

    @Override
    public short toShort() {
        return StringLike.toShort$(this);
    }

    @Override
    public int toInt() {
        return StringLike.toInt$(this);
    }

    @Override
    public long toLong() {
        return StringLike.toLong$(this);
    }

    @Override
    public float toFloat() {
        return StringLike.toFloat$(this);
    }

    @Override
    public double toDouble() {
        return StringLike.toDouble$(this);
    }

    @Override
    public <B> Object toArray(ClassTag<B> evidence$1) {
        return StringLike.toArray$(this, evidence$1);
    }

    @Override
    public String format(Seq<Object> args2) {
        return StringLike.format$(this, args2);
    }

    @Override
    public String formatLocal(Locale l, Seq<Object> args2) {
        return StringLike.formatLocal$(this, l, args2);
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
    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceLeft(Function2 op) {
        return TraversableOnce.reduceLeft$(this, op);
    }

    @Override
    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceRight(Function2 op) {
        return this.iterator().reduceRight(op);
    }

    @Override
    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$zip(GenIterable that, CanBuildFrom bf) {
        return IterableLike.zip$(this, that, bf);
    }

    @Override
    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$head() {
        return IterableLike.head$(this);
    }

    @Override
    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$tail() {
        return TraversableLike.tail$(this);
    }

    @Override
    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$last() {
        return TraversableLike.last$(this);
    }

    @Override
    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$init() {
        return TraversableLike.init$(this);
    }

    @Override
    public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$sameElements(GenIterable that) {
        return IterableLike.sameElements$(this, that);
    }

    @Override
    public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$endsWith(GenSeq that) {
        return SeqLike.endsWith$(this, that);
    }

    @Override
    public boolean isEmpty() {
        return IndexedSeqOptimized.isEmpty$(this);
    }

    @Override
    public <U> void foreach(Function1<Object, U> f) {
        IndexedSeqOptimized.foreach$(this, f);
    }

    @Override
    public boolean forall(Function1<Object, Object> p) {
        return IndexedSeqOptimized.forall$(this, p);
    }

    @Override
    public boolean exists(Function1<Object, Object> p) {
        return IndexedSeqOptimized.exists$(this, p);
    }

    @Override
    public Option<Object> find(Function1<Object, Object> p) {
        return IndexedSeqOptimized.find$(this, p);
    }

    @Override
    public <B> B foldLeft(B z, Function2<B, Object, B> op) {
        return (B)IndexedSeqOptimized.foldLeft$(this, z, op);
    }

    @Override
    public <B> B foldRight(B z, Function2<Object, B, B> op) {
        return (B)IndexedSeqOptimized.foldRight$(this, z, op);
    }

    @Override
    public <B> B reduceLeft(Function2<B, Object, B> op) {
        return (B)IndexedSeqOptimized.reduceLeft$(this, op);
    }

    @Override
    public <B> B reduceRight(Function2<Object, B, B> op) {
        return (B)IndexedSeqOptimized.reduceRight$(this, op);
    }

    @Override
    public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<StringBuilder, Tuple2<A1, B>, That> bf) {
        return (That)IndexedSeqOptimized.zip$(this, that, bf);
    }

    @Override
    public <A1, That> That zipWithIndex(CanBuildFrom<StringBuilder, Tuple2<A1, Object>, That> bf) {
        return (That)IndexedSeqOptimized.zipWithIndex$(this, bf);
    }

    @Override
    public Object head() {
        return IndexedSeqOptimized.head$(this);
    }

    @Override
    public Object tail() {
        return IndexedSeqOptimized.tail$(this);
    }

    @Override
    public Object last() {
        return IndexedSeqOptimized.last$(this);
    }

    @Override
    public Object init() {
        return IndexedSeqOptimized.init$(this);
    }

    @Override
    public Object take(int n) {
        return IndexedSeqOptimized.take$(this, n);
    }

    @Override
    public Object drop(int n) {
        return IndexedSeqOptimized.drop$(this, n);
    }

    @Override
    public Object takeRight(int n) {
        return IndexedSeqOptimized.takeRight$(this, n);
    }

    @Override
    public Object dropRight(int n) {
        return IndexedSeqOptimized.dropRight$(this, n);
    }

    @Override
    public Tuple2<StringBuilder, StringBuilder> splitAt(int n) {
        return IndexedSeqOptimized.splitAt$(this, n);
    }

    @Override
    public Object takeWhile(Function1 p) {
        return IndexedSeqOptimized.takeWhile$(this, p);
    }

    @Override
    public Object dropWhile(Function1 p) {
        return IndexedSeqOptimized.dropWhile$(this, p);
    }

    @Override
    public Tuple2<StringBuilder, StringBuilder> span(Function1<Object, Object> p) {
        return IndexedSeqOptimized.span$(this, p);
    }

    @Override
    public <B> boolean sameElements(GenIterable<B> that) {
        return IndexedSeqOptimized.sameElements$(this, that);
    }

    @Override
    public <B> void copyToArray(Object xs, int start, int len) {
        IndexedSeqOptimized.copyToArray$(this, xs, start, len);
    }

    @Override
    public int lengthCompare(int len) {
        return IndexedSeqOptimized.lengthCompare$(this, len);
    }

    @Override
    public int segmentLength(Function1<Object, Object> p, int from) {
        return IndexedSeqOptimized.segmentLength$(this, p, from);
    }

    @Override
    public int indexWhere(Function1<Object, Object> p, int from) {
        return IndexedSeqOptimized.indexWhere$(this, p, from);
    }

    @Override
    public int lastIndexWhere(Function1<Object, Object> p, int end) {
        return IndexedSeqOptimized.lastIndexWhere$(this, p, end);
    }

    @Override
    public Iterator<Object> reverseIterator() {
        return IndexedSeqOptimized.reverseIterator$(this);
    }

    @Override
    public <B> boolean startsWith(GenSeq<B> that, int offset) {
        return IndexedSeqOptimized.startsWith$(this, that, offset);
    }

    @Override
    public <B> boolean endsWith(GenSeq<B> that) {
        return IndexedSeqOptimized.endsWith$(this, that);
    }

    @Override
    public List<Object> toList() {
        return IndexedSeqOptimized.toList$(this);
    }

    @Override
    public GenericCompanion<IndexedSeq> companion() {
        return IndexedSeq.companion$(this);
    }

    @Override
    public IndexedSeq<Object> seq() {
        return IndexedSeq.seq$(this);
    }

    @Override
    public IndexedSeq toCollection(Object repr) {
        return IndexedSeqLike.toCollection$(this, repr);
    }

    @Override
    public IndexedSeqView<Object, IndexedSeq<Object>> view() {
        return IndexedSeqLike.view$(this);
    }

    @Override
    public IndexedSeqView<Object, IndexedSeq<Object>> view(int from, int until) {
        return IndexedSeqLike.view$(this, from, until);
    }

    @Override
    public int hashCode() {
        return scala.collection.IndexedSeqLike.hashCode$(this);
    }

    @Override
    public Iterator<Object> iterator() {
        return scala.collection.IndexedSeqLike.iterator$(this);
    }

    @Override
    public <A1> Buffer<A1> toBuffer() {
        return scala.collection.IndexedSeqLike.toBuffer$(this);
    }

    @Override
    public int sizeHintIfCheap() {
        return scala.collection.IndexedSeqLike.sizeHintIfCheap$(this);
    }

    @Override
    public IntStream chars() {
        return CharSequence.super.chars();
    }

    @Override
    public IntStream codePoints() {
        return CharSequence.super.codePoints();
    }

    private java.lang.StringBuilder underlying() {
        return this.underlying;
    }

    @Override
    public StringBuilder thisCollection() {
        return this;
    }

    public StringBuilder toCollection(StringBuilder repr) {
        return repr;
    }

    @Override
    public GrowingBuilder<Object, StringBuilder> newBuilder() {
        return new GrowingBuilder<Object, StringBuilder>(new StringBuilder());
    }

    /*
     * WARNING - void declaration
     */
    public char[] toArray() {
        void var1_1;
        char[] arr = new char[this.length()];
        this.underlying().getChars(0, this.length(), arr, 0);
        return var1_1;
    }

    @Override
    public int length() {
        return this.underlying().length();
    }

    public void length_$eq(int n) {
        this.underlying().setLength(n);
    }

    @Override
    public void clear() {
        this.setLength(0);
    }

    public void setLength(int len) {
        this.underlying().setLength(len);
    }

    public int capacity() {
        return this.underlying().capacity();
    }

    public void ensureCapacity(int newCapacity) {
        this.underlying().ensureCapacity(newCapacity);
    }

    @Override
    public char charAt(int index) {
        return this.underlying().charAt(index);
    }

    @Override
    public char apply(int index) {
        return this.underlying().charAt(index);
    }

    public StringBuilder deleteCharAt(int index) {
        this.underlying().deleteCharAt(index);
        return this;
    }

    public void setCharAt(int index, char ch) {
        this.underlying().setCharAt(index, ch);
    }

    @Override
    public void update(int i, char c) {
        this.setCharAt(i, c);
    }

    public String substring(int start) {
        return this.substring(start, this.length());
    }

    public String substring(int start, int end) {
        return this.underlying().substring(start, end);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return this.substring(start, end);
    }

    public StringBuilder $plus$eq(char x) {
        this.append(x);
        return this;
    }

    public StringBuilder $plus$plus$eq(String s) {
        this.underlying().append(s);
        return this;
    }

    public StringBuilder appendAll(String xs) {
        this.underlying().append(xs);
        return this;
    }

    public StringBuilder $plus(char x) {
        this.$plus$eq(x);
        return this;
    }

    public StringBuilder append(Object x) {
        this.underlying().append(String.valueOf(x));
        return this;
    }

    public StringBuilder append(String s) {
        this.underlying().append(s);
        return this;
    }

    public StringBuilder append(StringBuilder sb) {
        this.underlying().append(sb);
        return this;
    }

    public StringBuilder appendAll(TraversableOnce<Object> xs) {
        return this.appendAll((char[])xs.toArray(ClassTag$.MODULE$.Char()));
    }

    public StringBuilder appendAll(char[] xs) {
        this.underlying().append(xs);
        return this;
    }

    public StringBuilder appendAll(char[] xs, int offset, int len) {
        this.underlying().append(xs, offset, len);
        return this;
    }

    public StringBuilder append(boolean x) {
        this.underlying().append(x);
        return this;
    }

    public StringBuilder append(byte x) {
        return this.append((int)x);
    }

    public StringBuilder append(short x) {
        return this.append((int)x);
    }

    public StringBuilder append(int x) {
        this.underlying().append(x);
        return this;
    }

    public StringBuilder append(long x) {
        this.underlying().append(x);
        return this;
    }

    public StringBuilder append(float x) {
        this.underlying().append(x);
        return this;
    }

    public StringBuilder append(double x) {
        this.underlying().append(x);
        return this;
    }

    public StringBuilder append(char x) {
        this.underlying().append(x);
        return this;
    }

    public StringBuilder delete(int start, int end) {
        this.underlying().delete(start, end);
        return this;
    }

    public StringBuilder replace(int start, int end, String str) {
        this.underlying().replace(start, end, str);
        return this;
    }

    public StringBuilder insertAll(int index, char[] str, int offset, int len) {
        this.underlying().insert(index, str, offset, len);
        return this;
    }

    public StringBuilder insert(int index, Object x) {
        return this.insert(index, String.valueOf(x));
    }

    public StringBuilder insert(int index, String x) {
        this.underlying().insert(index, x);
        return this;
    }

    public StringBuilder insertAll(int index, TraversableOnce<Object> xs) {
        return this.insertAll(index, (char[])xs.toArray(ClassTag$.MODULE$.Char()));
    }

    public StringBuilder insertAll(int index, char[] xs) {
        this.underlying().insert(index, xs);
        return this;
    }

    public StringBuilder insert(int index, boolean x) {
        return this.insert(index, String.valueOf(x));
    }

    public StringBuilder insert(int index, byte x) {
        return this.insert(index, (int)x);
    }

    public StringBuilder insert(int index, short x) {
        return this.insert(index, (int)x);
    }

    public StringBuilder insert(int index, int x) {
        return this.insert(index, String.valueOf(x));
    }

    public StringBuilder insert(int index, long x) {
        return this.insert(index, String.valueOf(x));
    }

    public StringBuilder insert(int index, float x) {
        return this.insert(index, String.valueOf(x));
    }

    public StringBuilder insert(int index, double x) {
        return this.insert(index, String.valueOf(x));
    }

    public StringBuilder insert(int index, char x) {
        return this.insert(index, String.valueOf(x));
    }

    @Override
    public int indexOf(String str) {
        return this.underlying().indexOf(str);
    }

    @Override
    public int indexOf(String str, int fromIndex) {
        return this.underlying().indexOf(str, fromIndex);
    }

    @Override
    public int lastIndexOf(String str) {
        return this.underlying().lastIndexOf(str);
    }

    @Override
    public int lastIndexOf(String str, int fromIndex) {
        return this.underlying().lastIndexOf(str, fromIndex);
    }

    @Override
    public StringBuilder reverse() {
        return new StringBuilder(new java.lang.StringBuilder(this.underlying()).reverse());
    }

    @Override
    public StringBuilder clone() {
        return new StringBuilder(new java.lang.StringBuilder(this.underlying()));
    }

    public StringBuilder reverseContents() {
        this.underlying().reverse();
        return this;
    }

    @Override
    public String toString() {
        return this.underlying().toString();
    }

    @Override
    public String mkString() {
        return this.toString();
    }

    @Override
    public String result() {
        return this.toString();
    }

    public StringBuilder(java.lang.StringBuilder underlying) {
        this.underlying = underlying;
        scala.collection.IndexedSeqLike.$init$(this);
        scala.collection.IndexedSeq.$init$(this);
        IndexedSeqLike.$init$(this);
        IndexedSeq.$init$(this);
        IndexedSeqOptimized.$init$(this);
        Ordered.$init$(this);
        StringLike.$init$(this);
        Growable.$init$(this);
        Builder.$init$(this);
    }

    public StringBuilder(int initCapacity, String initValue) {
        this(new java.lang.StringBuilder(initValue.length() + initCapacity).append(initValue));
    }

    public StringBuilder() {
        this(16, "");
    }

    public StringBuilder(int capacity) {
        this(capacity, "");
    }

    public StringBuilder(String str) {
        this(16, str);
    }
}

