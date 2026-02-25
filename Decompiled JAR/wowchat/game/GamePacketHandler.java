/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import com.typesafe.scalalogging.Logger;
import com.typesafe.scalalogging.StrictLogging;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.util.AttributeKey;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import scala.Array$;
import scala.Enumeration;
import scala.Function0;
import scala.Function1;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Option$;
import scala.Predef$;
import scala.Predef$ArrowAssoc$;
import scala.Some;
import scala.Tuple2;
import scala.collection.Iterable;
import scala.collection.IterableLike;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.IndexedSeq$;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.ArrayOps;
import scala.collection.mutable.HashMap;
import scala.collection.mutable.ListBuffer;
import scala.collection.mutable.ListBuffer$;
import scala.collection.mutable.Map;
import scala.collection.mutable.Map$;
import scala.math.Ordering$String$;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.NonLocalReturnControl;
import scala.runtime.RichInt$;
import scala.runtime.java8.JFunction0$mcI$sp;
import scala.runtime.java8.JFunction0$mcV$sp;
import scala.util.Random$;
import wowchat.commands.CommandHandler$;
import wowchat.commands.WhoResponse;
import wowchat.common.ByteUtils$;
import wowchat.common.ChannelConfig;
import wowchat.common.CommonConnectionCallback;
import wowchat.common.Global$;
import wowchat.common.GuildNotificationConfig;
import wowchat.common.LRUMap$;
import wowchat.common.Packet;
import wowchat.common.Packet$;
import wowchat.common.Platform$;
import wowchat.common.WowChatConfig$;
import wowchat.common.WowExpansion$;
import wowchat.game.AuthChallengeMessage;
import wowchat.game.CharEnumMessage;
import wowchat.game.ChatMessage;
import wowchat.game.GameCommandHandler;
import wowchat.game.GameHeaderCrypt;
import wowchat.game.GamePackets;
import wowchat.game.GamePackets$AuthResponseCodes$;
import wowchat.game.GamePackets$ChatChannelIds$;
import wowchat.game.GamePackets$ChatEvents$;
import wowchat.game.GamePackets$ChatNotify$;
import wowchat.game.GamePackets$Classes$;
import wowchat.game.GamePackets$Genders$;
import wowchat.game.GamePackets$GuildEvents$;
import wowchat.game.GamePackets$Races$;
import wowchat.game.GamePackets$ServerMessageType$;
import wowchat.game.GameResources$;
import wowchat.game.GuildInfo;
import wowchat.game.GuildMember;
import wowchat.game.NameQueryMessage;
import wowchat.game.Player;
import wowchat.game.warden.WardenHandler;
import wowchat.game.warden.WardenPackets$;

@ScalaSignature(bytes="\u0006\u0001\u0011\u001da\u0001\u00022d\u0001!D!\"!\u0003\u0001\u0005\u0003\u0005\u000b\u0011BA\u0006\u0011)\t9\u0002\u0001B\u0001B\u0003%\u0011\u0011\u0004\u0005\u000b\u0003_\u0001!\u0011!Q\u0001\n\u0005E\u0002BCA\u001f\u0001\t\u0005\t\u0015!\u0003\u0002@!9\u00111\n\u0001\u0005\u0002\u00055\u0003\"CA-\u0001\t\u0007I\u0011CA.\u0011!\ti\u0006\u0001Q\u0001\n\u0005E\u0002\"CA0\u0001\u0001\u0007I\u0011CA1\u0011%\ty\u0007\u0001a\u0001\n#\t\t\b\u0003\u0005\u0002~\u0001\u0001\u000b\u0015BA2\u0011-\ty\b\u0001a\u0001\u0002\u0004%\t\"!!\t\u0017\u0005\r\u0005\u00011AA\u0002\u0013E\u0011Q\u0011\u0005\f\u0003\u0013\u0003\u0001\u0019!A!B\u0013\t9\u0004C\u0005\u0002\f\u0002\u0001\r\u0011\"\u0005\u0002\u000e\"I\u0011Q\u0013\u0001A\u0002\u0013E\u0011q\u0013\u0005\t\u00037\u0003\u0001\u0015)\u0003\u0002\u0010\"Y\u0011Q\u0014\u0001A\u0002\u0003\u0007I\u0011CAP\u0011-\t\t\u000b\u0001a\u0001\u0002\u0004%\t\"a)\t\u0017\u0005\u001d\u0006\u00011A\u0001B\u0003&\u0011\u0011\u000e\u0005\f\u0003S\u0003\u0001\u0019!a\u0001\n#\tY\u000bC\u0006\u00024\u0002\u0001\r\u00111A\u0005\u0012\u0005U\u0006bCA]\u0001\u0001\u0007\t\u0011)Q\u0005\u0003[C\u0011\"a/\u0001\u0001\u0004%\t\"!0\t\u0013\u0005\u0005\u0007\u00011A\u0005\u0012\u0005\r\u0007\u0002CAd\u0001\u0001\u0006K!a0\t\u0013\u0005%\u0007\u00011A\u0005\u0012\u0005-\u0007\"CAk\u0001\u0001\u0007I\u0011CAl\u0011!\tY\u000e\u0001Q!\n\u00055\u0007\"CAo\u0001\t\u0007I\u0011CAp\u0011!\t9\u0010\u0001Q\u0001\n\u0005\u0005\b\"CA}\u0001\t\u0007I\u0011CA~\u0011!\u0011)\u0001\u0001Q\u0001\n\u0005u\bb\u0003B\u0004\u0001\u0001\u0007\t\u0019!C\t\u0003?C1B!\u0003\u0001\u0001\u0004\u0005\r\u0011\"\u0005\u0003\f!Y!q\u0002\u0001A\u0002\u0003\u0005\u000b\u0015BA5\u0011%\u0011\t\u0002\u0001b\u0001\n#\u0011\u0019\u0002\u0003\u0005\u0003*\u0001\u0001\u000b\u0011\u0002B\u000b\u0011%\u0011Y\u0003\u0001b\u0001\n\u0013\u0011i\u0003\u0003\u0005\u0003B\u0001\u0001\u000b\u0011\u0002B\u0018\u0011%\u0011\u0019\u0005\u0001a\u0001\n\u0013\u0011)\u0005C\u0005\u0003V\u0001\u0001\r\u0011\"\u0003\u0003X!A!1\f\u0001!B\u0013\u00119\u0005C\u0005\u0003^\u0001\u0001\r\u0011\"\u0003\u0002\u000e\"I!q\f\u0001A\u0002\u0013%!\u0011\r\u0005\t\u0005K\u0002\u0001\u0015)\u0003\u0002\u0010\"9!q\r\u0001\u0005B\t%\u0004b\u0002B7\u0001\u0011E!q\u000e\u0005\b\u0005c\u0002A\u0011\u0002B8\u0011\u001d\u0011\u0019\b\u0001C\u0005\u0005_BqA!\u001e\u0001\t\u0003\u00119\bC\u0004\u0003z\u0001!\tAa\u001f\t\u000f\t\u0005\u0005\u0001\"\u0005\u0003p!9!1\u0011\u0001\u0005\u0012\t=\u0004b\u0002BC\u0001\u0011%!q\u000e\u0005\b\u0005\u000f\u0003A\u0011\u0003BE\u0011\u001d\u0011\t\n\u0001C\u0001\u0005'CqA!(\u0001\t\u0003\u0012y\nC\u0004\u0003.\u0002!\tBa,\t\u000f\tu\u0006\u0001\"\u0011\u0003@\"9!1\u0019\u0001\u0005\u0002\t\u0015\u0007b\u0002Bf\u0001\u0011\u0005#Q\u001a\u0005\b\u0005'\u0004A\u0011\tBk\u0011\u001d\u00119\u000e\u0001C\t\u00053DqAa;\u0001\t\u0003\u0012i\u000fC\u0004\u0003r\u0002!\tEa=\t\u000f\r\u0005\u0001\u0001\"\u0005\u0004\u0004!91q\u0001\u0001\u0005\n\r%\u0001bBB\u0007\u0001\u0011E1q\u0002\u0005\b\u00073\u0001A\u0011BB\u000e\u0011\u001d\u0019y\u0002\u0001C\u0005\u0005_Bqa!\t\u0001\t#\u0019\u0019\u0003C\u0004\u0004(\u0001!Ia!\u000b\t\u000f\r5\u0002\u0001\"\u0005\u00040!91\u0011\b\u0001\u0005\n\rm\u0002bBB \u0001\u0011E1\u0011\t\u0005\b\u0007\u001b\u0002A\u0011CB(\u0011\u001d\u0019)\u0006\u0001C\u0005\u0007/Bqaa\u0017\u0001\t#\u0019i\u0006C\u0004\u0004j\u0001!Iaa\u001b\t\u000f\r=\u0004\u0001\"\u0005\u0004r!91Q\u000f\u0001\u0005\n\r]\u0004bBB>\u0001\u0011E1Q\u0010\u0005\b\u00073\u0003A\u0011BBN\u0011\u001d\u0019y\n\u0001C\t\u0007CCqa!+\u0001\t#\u0019Y\u000bC\u0004\u00040\u0002!\tb!-\t\u000f\r]\u0006\u0001\"\u0005\u0004:\"91q\u0018\u0001\u0005\n\r\u0005\u0007bBBc\u0001\u0011%1q\u0019\u0005\b\u0007\u0017\u0004A\u0011CBg\u0011\u001d\u0019\t\u000e\u0001C\u0005\u0007'Dqaa6\u0001\t#\u0019I\u000eC\u0004\u0004l\u0002!Ia!<\t\u000f\rE\b\u0001\"\u0003\u0004t\"91q\u001f\u0001\u0005\u0012\re\bbBB\u007f\u0001\u0011%1q \u0005\b\t\u0007\u0001A\u0011\u0003C\u0003\u0005E9\u0015-\\3QC\u000e\\W\r\u001e%b]\u0012dWM\u001d\u0006\u0003I\u0016\fAaZ1nK*\ta-A\u0004x_^\u001c\u0007.\u0019;\u0004\u0001M)\u0001![:xuB\u0011!.]\u0007\u0002W*\u0011A.\\\u0001\bG\"\fgN\\3m\u0015\tqw.A\u0003oKR$\u0018PC\u0001q\u0003\tIw.\u0003\u0002sW\na2\t[1o]\u0016d\u0017J\u001c2pk:$\u0007*\u00198eY\u0016\u0014\u0018\tZ1qi\u0016\u0014\bC\u0001;v\u001b\u0005\u0019\u0017B\u0001<d\u0005I9\u0015-\\3D_6l\u0017M\u001c3IC:$G.\u001a:\u0011\u0005QD\u0018BA=d\u0005-9\u0015-\\3QC\u000e\\W\r^:\u0011\u0007m\f)!D\u0001}\u0015\tih0\u0001\u0007tG\u0006d\u0017\r\\8hO&twMC\u0002\u0000\u0003\u0003\t\u0001\u0002^=qKN\fg-\u001a\u0006\u0003\u0003\u0007\t1aY8n\u0013\r\t9\u0001 \u0002\u000e'R\u0014\u0018n\u0019;M_\u001e<\u0017N\\4\u0002\u000fI,\u0017\r\\7JIB!\u0011QBA\n\u001b\t\tyA\u0003\u0002\u0002\u0012\u0005)1oY1mC&!\u0011QCA\b\u0005\rIe\u000e^\u0001\ne\u0016\fG.\u001c(b[\u0016\u0004B!a\u0007\u0002*9!\u0011QDA\u0013!\u0011\ty\"a\u0004\u000e\u0005\u0005\u0005\"bAA\u0012O\u00061AH]8pizJA!a\n\u0002\u0010\u00051\u0001K]3eK\u001aLA!a\u000b\u0002.\t11\u000b\u001e:j]\u001eTA!a\n\u0002\u0010\u0005Q1/Z:tS>t7*Z=\u0011\r\u00055\u00111GA\u001c\u0013\u0011\t)$a\u0004\u0003\u000b\u0005\u0013(/Y=\u0011\t\u00055\u0011\u0011H\u0005\u0005\u0003w\tyA\u0001\u0003CsR,\u0017!E4b[\u0016,e/\u001a8u\u0007\u0006dGNY1dWB!\u0011\u0011IA$\u001b\t\t\u0019EC\u0002\u0002F\u0015\faaY8n[>t\u0017\u0002BA%\u0003\u0007\u0012\u0001dQ8n[>t7i\u001c8oK\u000e$\u0018n\u001c8DC2d'-Y2l\u0003\u0019a\u0014N\\5u}QQ\u0011qJA)\u0003'\n)&a\u0016\u0011\u0005Q\u0004\u0001bBA\u0005\u000b\u0001\u0007\u00111\u0002\u0005\b\u0003/)\u0001\u0019AA\r\u0011\u001d\ty#\u0002a\u0001\u0003cAq!!\u0010\u0006\u0001\u0004\ty$A\u0005bI\u0012|g.\u00138g_V\u0011\u0011\u0011G\u0001\u000bC\u0012$wN\\%oM>\u0004\u0013aD:fY\u001a\u001c\u0005.\u0019:bGR,'/\u00133\u0016\u0005\u0005\r\u0004CBA\u0007\u0003K\nI'\u0003\u0003\u0002h\u0005=!AB(qi&|g\u000e\u0005\u0003\u0002\u000e\u0005-\u0014\u0002BA7\u0003\u001f\u0011A\u0001T8oO\u0006\u00192/\u001a7g\u0007\"\f'/Y2uKJLEm\u0018\u0013fcR!\u00111OA=!\u0011\ti!!\u001e\n\t\u0005]\u0014q\u0002\u0002\u0005+:LG\u000fC\u0005\u0002|%\t\t\u00111\u0001\u0002d\u0005\u0019\u0001\u0010J\u0019\u0002!M,GNZ\"iCJ\f7\r^3s\u0013\u0012\u0004\u0013A\u00037b]\u001e,\u0018mZ3JIV\u0011\u0011qG\u0001\u000fY\u0006tw-^1hK&#w\fJ3r)\u0011\t\u0019(a\"\t\u0013\u0005mD\"!AA\u0002\u0005]\u0012a\u00037b]\u001e,\u0018mZ3JI\u0002\nq!\u001b8X_JdG-\u0006\u0002\u0002\u0010B!\u0011QBAI\u0013\u0011\t\u0019*a\u0004\u0003\u000f\t{w\u000e\\3b]\u0006Y\u0011N\\,pe2$w\fJ3r)\u0011\t\u0019(!'\t\u0013\u0005mt\"!AA\u0002\u0005=\u0015\u0001C5o/>\u0014H\u000e\u001a\u0011\u0002\u0013\u001d,\u0018\u000e\u001c3Hk&$WCAA5\u000359W/\u001b7e\u000fVLGm\u0018\u0013fcR!\u00111OAS\u0011%\tYHEA\u0001\u0002\u0004\tI'\u0001\u0006hk&dGmR;jI\u0002\n\u0011bZ;jY\u0012LeNZ8\u0016\u0005\u00055\u0006c\u0001;\u00020&\u0019\u0011\u0011W2\u0003\u0013\u001d+\u0018\u000e\u001c3J]\u001a|\u0017!D4vS2$\u0017J\u001c4p?\u0012*\u0017\u000f\u0006\u0003\u0002t\u0005]\u0006\"CA>+\u0005\u0005\t\u0019AAW\u0003)9W/\u001b7e\u0013:4w\u000eI\u0001\nOVLG\u000eZ'pi\u0012,\"!a0\u0011\r\u00055\u0011QMA\r\u000359W/\u001b7e\u001b>$Hm\u0018\u0013fcR!\u00111OAc\u0011%\tY\bGA\u0001\u0002\u0004\ty,\u0001\u0006hk&dG-T8uI\u0002\n1a\u0019;y+\t\ti\r\u0005\u0004\u0002\u000e\u0005\u0015\u0014q\u001a\t\u0004U\u0006E\u0017bAAjW\n)2\t[1o]\u0016d\u0007*\u00198eY\u0016\u00148i\u001c8uKb$\u0018aB2uq~#S-\u001d\u000b\u0005\u0003g\nI\u000eC\u0005\u0002|m\t\t\u00111\u0001\u0002N\u0006!1\r\u001e=!\u00031\u0001H.Y=feJ{7\u000f^3s+\t\t\t\u000f\u0005\u0005\u0002d\u00065\u0018\u0011NAy\u001b\t\t)O\u0003\u0003\u0002h\u0006%\u0018aB7vi\u0006\u0014G.\u001a\u0006\u0005\u0003W\fy!\u0001\u0006d_2dWm\u0019;j_:LA!a<\u0002f\n\u0019Q*\u00199\u0011\u0007Q\f\u00190C\u0002\u0002v\u000e\u0014a\u0001\u00157bs\u0016\u0014\u0018!\u00049mCf,'OU8ti\u0016\u0014\b%A\u0006hk&dGMU8ti\u0016\u0014XCAA\u007f!!\t\u0019/!<\u0002j\u0005}\bc\u0001;\u0003\u0002%\u0019!1A2\u0003\u0017\u001d+\u0018\u000e\u001c3NK6\u0014WM]\u0001\rOVLG\u000e\u001a*pgR,'\u000fI\u0001\u0019Y\u0006\u001cHOU3rk\u0016\u001cH/\u001a3Hk&dGMU8ti\u0016\u0014\u0018\u0001\b7bgR\u0014V-];fgR,GmR;jY\u0012\u0014vn\u001d;fe~#S-\u001d\u000b\u0005\u0003g\u0012i\u0001C\u0005\u0002|\t\n\t\u00111\u0001\u0002j\u0005IB.Y:u%\u0016\fX/Z:uK\u0012<U/\u001b7e%>\u001cH/\u001a:!\u0003=)\u00070Z2vi>\u00148+\u001a:wS\u000e,WC\u0001B\u000b!\u0011\u00119B!\n\u000e\u0005\te!\u0002\u0002B\u000e\u0005;\t!bY8oGV\u0014(/\u001a8u\u0015\u0011\u0011yB!\t\u0002\tU$\u0018\u000e\u001c\u0006\u0003\u0005G\tAA[1wC&!!q\u0005B\r\u0005a\u00196\r[3ek2,G-\u0012=fGV$xN]*feZL7-Z\u0001\u0011Kb,7-\u001e;peN+'O^5dK\u0002\n!#];fk\u0016$7\t[1u\u001b\u0016\u001c8/Y4fgV\u0011!q\u0006\t\t\u0003G\u0014\t$!\u001b\u00036%!!1GAs\u0005\u001dA\u0015m\u001d5NCB\u0004b!a9\u00038\tm\u0012\u0002\u0002B\u001d\u0003K\u0014!\u0002T5ti\n+hMZ3s!\r!(QH\u0005\u0004\u0005\u007f\u0019'aC\"iCRlUm]:bO\u0016\f1#];fk\u0016$7\t[1u\u001b\u0016\u001c8/Y4fg\u0002\nQb^1sI\u0016t\u0007*\u00198eY\u0016\u0014XC\u0001B$!\u0019\ti!!\u001a\u0003JA!!1\nB)\u001b\t\u0011iEC\u0002\u0003P\r\faa^1sI\u0016t\u0017\u0002\u0002B*\u0005\u001b\u0012QbV1sI\u0016t\u0007*\u00198eY\u0016\u0014\u0018!E<be\u0012,g\u000eS1oI2,'o\u0018\u0013fcR!\u00111\u000fB-\u0011%\tY(KA\u0001\u0002\u0004\u00119%\u0001\bxCJ$WM\u001c%b]\u0012dWM\u001d\u0011\u0002!I,7-Z5wK\u0012\u001c\u0005.\u0019:F]Vl\u0017\u0001\u0006:fG\u0016Lg/\u001a3DQ\u0006\u0014XI\\;n?\u0012*\u0017\u000f\u0006\u0003\u0002t\t\r\u0004\"CA>Y\u0005\u0005\t\u0019AAH\u0003E\u0011XmY3jm\u0016$7\t[1s\u000b:,X\u000eI\u0001\u0010G\"\fgN\\3m\u0013:\f7\r^5wKR!\u00111\u000fB6\u0011\u001d\tIM\fa\u0001\u0003\u001f\fAC];o\u0017\u0016,\u0007/\u00117jm\u0016,\u00050Z2vi>\u0014XCAA:\u0003=\u0011XO\u001c)j]\u001e,\u00050Z2vi>\u0014\u0018A\u0006:v]\u001e+\u0018\u000e\u001c3S_N$XM]#yK\u000e,Ho\u001c:\u0002'\t,\u0018\u000e\u001c3Hk&dG-[3t\u001f:d\u0017N\\3\u0016\u0005\u0005e\u0011\u0001G4fi\u001e+\u0018\u000e\u001c3jKN|e\u000e\\5oK6+7o]1hKR!\u0011\u0011\u0004B?\u0011\u001d\u0011yh\ra\u0001\u0003\u001f\u000b\u0001\"[:Ti\u0006$Xo]\u0001\u0015kB$\u0017\r^3Hk&dG-[3t\u001f:d\u0017N\\3\u0002\u001dE,XM]=Hk&dGMT1nK\u0006\tR\u000f\u001d3bi\u0016<U/\u001b7e%>\u001cH/\u001a:\u0002-\t,\u0018\u000e\u001c3Hk&dGMU8ti\u0016\u0014\b+Y2lKR,\"Aa#\u0011\t\u0005\u0005#QR\u0005\u0005\u0005\u001f\u000b\u0019E\u0001\u0004QC\u000e\\W\r^\u0001\u000bg\u0016tG\rT8h_V$XC\u0001BK!\u0019\ti!!\u001a\u0003\u0018B\u0019!N!'\n\u0007\tm5NA\u0007DQ\u0006tg.\u001a7GkR,(/Z\u0001\u0011g\u0016tG-T3tg\u0006<W\rV8X_^$\u0002\"a\u001d\u0003\"\n\u0015&\u0011\u0016\u0005\b\u0005GK\u0004\u0019AA\u001c\u0003\t!\b\u000fC\u0004\u0003(f\u0002\r!!\u0007\u0002\u000f5,7o]1hK\"9!1V\u001dA\u0002\u0005}\u0016A\u0002;be\u001e,G/\u0001\tck&dGm\u00115bi6+7o]1hKRA!1\u0012BY\u0005g\u00139\fC\u0004\u0003$j\u0002\r!a\u000e\t\u000f\tU&\b1\u0001\u00022\u0005\u0001R\u000f\u001e49\u001b\u0016\u001c8/Y4f\u0005f$Xm\u001d\u0005\b\u0005sS\u0004\u0019\u0001B^\u0003=)HO\u001a\u001dUCJ<W\r\u001e\"zi\u0016\u001c\bCBA\u0007\u0003K\n\t$\u0001\ttK:$gj\u001c;jM&\u001c\u0017\r^5p]R!\u00111\u000fBa\u0011\u001d\u00119k\u000fa\u0001\u00033\tQb]3oI:\u000bW.Z)vKJLH\u0003BA:\u0005\u000fDqA!3=\u0001\u0004\tI'\u0001\u0003hk&$\u0017!\u00035b]\u0012dWm\u00165p)\u0011\tyLa4\t\u000f\tEW\b1\u0001\u0002@\u0006I\u0011M]4v[\u0016tGo]\u0001\fQ\u0006tG\r\\3H[>$H\r\u0006\u0002\u0002@\u0006y!-^5mI^Cw.T3tg\u0006<W\r\u0006\u0003\u0003\\\n\u001d\b\u0003\u0002Bo\u0005Gl!Aa8\u000b\u0007\t\u0005X.\u0001\u0004ck\u001a4WM]\u0005\u0005\u0005K\u0014yNA\u0004CsR,')\u001e4\t\u000f\t%x\b1\u0001\u0002\u001a\u0005!a.Y7f\u00035\u0019\u0007.\u00198oK2\f5\r^5wKR!\u00111\u000fBx\u0011\u001d\tI\r\u0011a\u0001\u0003\u001f\f1b\u00195b]:,GNU3bIR1\u00111\u000fB{\u0005oDq!!3B\u0001\u0004\ty\rC\u0004\u0003z\u0006\u0003\rAa?\u0002\u00075\u001cx\r\u0005\u0003\u0002\u000e\tu\u0018\u0002\u0002B\u0000\u0003\u001f\u00111!\u00118z\u00031\u0019\u0007.\u00198oK2\u0004\u0016M]:f)\u0011\t\u0019h!\u0002\t\u000f\te(\t1\u0001\u0003\f\u0006Q\u0002.\u00198eY\u0016|6+T*H?\u0006+F\u000bS0D\u0011\u0006cE*\u0012(H\u000bR!\u00111OB\u0006\u0011\u001d\u0011Ip\u0011a\u0001\u0005\u0017\u000b!\u0003]1sg\u0016\fU\u000f\u001e5DQ\u0006dG.\u001a8hKR!1\u0011CB\f!\r!81C\u0005\u0004\u0007+\u0019'\u0001F!vi\"\u001c\u0005.\u00197mK:<W-T3tg\u0006<W\rC\u0004\u0003z\u0012\u0003\rAa#\u00023!\fg\u000e\u001a7f?Nk5kR0B+RCuLU#T!>s5+\u0012\u000b\u0005\u0003g\u001ai\u0002C\u0004\u0003z\u0016\u0003\rAa#\u0002\u0019M,g\u000eZ\"iCJ,e.^7\u0002#A\f'o]3BkRD'+Z:q_:\u001cX\r\u0006\u0003\u00028\r\u0015\u0002b\u0002B}\u000f\u0002\u0007!1R\u0001\u0017Q\u0006tG\r\\3`'6\u001bvi\u0018(B\u001b\u0016{\u0016+V#S3R!\u00111OB\u0016\u0011\u001d\u0011I\u0010\u0013a\u0001\u0005\u0017\u000ba\u0002]1sg\u0016t\u0015-\\3Rk\u0016\u0014\u0018\u0010\u0006\u0003\u00042\r]\u0002c\u0001;\u00044%\u00191QG2\u0003!9\u000bW.Z)vKJLX*Z:tC\u001e,\u0007b\u0002B}\u0013\u0002\u0007!1R\u0001\u0016Q\u0006tG\r\\3`'6\u001bviX\"I\u0003J{VIT+N)\u0011\t\u0019h!\u0010\t\u000f\te(\n1\u0001\u0003\f\u0006i\u0001/\u0019:tK\u000eC\u0017M]#ok6$Baa\u0011\u0004LA1\u0011QBA3\u0007\u000b\u00022\u0001^B$\u0013\r\u0019Ie\u0019\u0002\u0010\u0007\"\f'/\u00128v[6+7o]1hK\"9!\u0011`&A\u0002\t-\u0015\u0001E<sSR,\u0007\u000b\\1zKJdunZ5o)\u0011\t\u0019h!\u0015\t\u000f\rMC\n1\u0001\u0003\\\u0006\u0019q.\u001e;\u0002=!\fg\u000e\u001a7f?Nk5kR0M\u001f\u001eKej\u0018,F%&3\u0015lX,P%2#E\u0003BA:\u00073BqA!?N\u0001\u0004\u0011Y)\u0001\txe&$XMS8j]\u000eC\u0017M\u001c8fYRA\u00111OB0\u0007C\u001a)\u0007C\u0004\u0004T9\u0003\rAa7\t\u000f\r\rd\n1\u0001\u0002\f\u0005\u0011\u0011\u000e\u001a\u0005\b\u0007Or\u0005\u0019AA\u0019\u0003A)HO\u001a\u001dDQ\u0006tg.\u001a7CsR,7/A\fiC:$G.Z0T\u001bN;ulR+J\u0019\u0012{\u0016+V#S3R!\u00111OB7\u0011\u001d\u0011Ip\u0014a\u0001\u0005\u0017\u000b\u0001\u0003[1oI2,w)^5mIF+XM]=\u0015\t\u0005561\u000f\u0005\b\u0005s\u0004\u0006\u0019\u0001BF\u0003]A\u0017M\u001c3mK~\u001bVjU$`\u000fVKE\nR0F-\u0016sE\u000b\u0006\u0003\u0002t\re\u0004b\u0002B}#\u0002\u0007!1R\u0001\u0011Q\u0006tG\r\\3Hk&dG-\u0012<f]R$b!a\u001d\u0004\u0000\r\r\u0005bBBA%\u0002\u0007\u0011qG\u0001\u0006KZ,g\u000e\u001e\u0005\b\u0007\u000b\u0013\u0006\u0019ABD\u0003!iWm]:bO\u0016\u001c\bCBBE\u0007'\u000bIB\u0004\u0003\u0004\f\u000e=e\u0002BA\u0010\u0007\u001bK!!!\u0005\n\t\rE\u0015qB\u0001\ba\u0006\u001c7.Y4f\u0013\u0011\u0019)ja&\u0003\u0007M+\u0017O\u0003\u0003\u0004\u0012\u0006=\u0011\u0001\u00075b]\u0012dWmX*N'\u001e{v)V%M\t~\u0013vj\u0015+F%R!\u00111OBO\u0011\u001d\u0011Ip\u0015a\u0001\u0005\u0017\u000b\u0001\u0003]1sg\u0016<U/\u001b7e%>\u001cH/\u001a:\u0015\t\r\r6q\u0015\t\t\u00037\u0019)+!\u001b\u0002\u0000&!\u0011q^A\u0017\u0011\u001d\u0011I\u0010\u0016a\u0001\u0005\u0017\u000bq\u0003[1oI2,wlU'T\u000f~kUiU*B\u000f\u0016\u001b\u0005*\u0011+\u0015\t\u0005M4Q\u0016\u0005\b\u0005s,\u0006\u0019\u0001BF\u0003=\u0019XM\u001c3DQ\u0006$X*Z:tC\u001e,G\u0003BA:\u0007gCqa!.W\u0001\u0004\u0011Y$A\u0006dQ\u0006$X*Z:tC\u001e,\u0017\u0001\u00059beN,7\t[1u\u001b\u0016\u001c8/Y4f)\u0011\u0019Yl!0\u0011\r\u00055\u0011Q\rB\u001e\u0011\u001d\u0011Ip\u0016a\u0001\u0005\u0017\u000b!\u0004[1oI2,wlU'T\u000f~\u001b\u0005*\u0011(O\u000b2{fj\u0014+J\rf#B!a\u001d\u0004D\"9!\u0011 -A\u0002\t-\u0015\u0001\u00075b]\u0012dWmX*N'\u001e{fj\u0014+J\r&\u001b\u0015\tV%P\u001dR!\u00111OBe\u0011\u001d\u0011I0\u0017a\u0001\u0005\u0017\u000b\u0011\u0003]1sg\u0016tu\u000e^5gS\u000e\fG/[8o)\u0011\tIba4\t\u000f\te(\f1\u0001\u0003\f\u0006y\u0001.\u00198eY\u0016|6+T*H?^Cu\n\u0006\u0003\u0002t\rU\u0007b\u0002B}7\u0002\u0007!1R\u0001\u0011a\u0006\u00148/Z,i_J+7\u000f]8og\u0016$Baa7\u0004jB11\u0011RBJ\u0007;\u0004Baa8\u0004f6\u00111\u0011\u001d\u0006\u0004\u0007G,\u0017\u0001C2p[6\fg\u000eZ:\n\t\r\u001d8\u0011\u001d\u0002\f/\"|'+Z:q_:\u001cX\rC\u0004\u0003zr\u0003\rAa#\u00025!\fg\u000e\u001a7f?Nk5kR0T\u000bJ3VIU0N\u000bN\u001b\u0016iR#\u0015\t\u0005M4q\u001e\u0005\b\u0005sl\u0006\u0019\u0001BF\u0003uA\u0017M\u001c3mK~\u001bVjU$`\u0013:3\u0016\tT%E\u0003R+u\f\u0015'B3\u0016\u0013F\u0003BA:\u0007kDqA!?_\u0001\u0004\u0011Y)A\u000bqCJ\u001cX-\u00138wC2LG-\u0019;f!2\f\u00170\u001a:\u0015\t\u0005%41 \u0005\b\u0005s|\u0006\u0019\u0001BF\u0003]A\u0017M\u001c3mK~\u001bVjU$`/\u0006\u0013F)\u0012(`\t\u0006#\u0016\t\u0006\u0003\u0002t\u0011\u0005\u0001b\u0002B}A\u0002\u0007!1R\u0001\u0018S:LG/[1mSj,w+\u0019:eK:D\u0015M\u001c3mKJ,\"A!\u0013")
public class GamePacketHandler
extends ChannelInboundHandlerAdapter
implements GameCommandHandler,
GamePackets,
StrictLogging {
    private final String realmName;
    private final byte[] sessionKey;
    private final CommonConnectionCallback gameEventCallback;
    private final byte[] addonInfo;
    private Option<Object> selfCharacterId;
    private byte languageId;
    private boolean inWorld;
    private long guildGuid;
    private GuildInfo guildInfo;
    private Option<String> guildMotd;
    private Option<ChannelHandlerContext> ctx;
    private final Map<Object, Player> playerRoster;
    private final Map<Object, GuildMember> guildRoster;
    private long lastRequestedGuildRoster;
    private final ScheduledExecutorService executorService;
    private final HashMap<Object, ListBuffer<ChatMessage>> queuedChatMessages;
    private Option<WardenHandler> wardenHandler;
    private boolean receivedCharEnum;
    private final Logger logger;
    private final AttributeKey<GameHeaderCrypt> CRYPT;
    private final int CMSG_CHAR_ENUM;
    private final int SMSG_CHAR_ENUM;
    private final int CMSG_PLAYER_LOGIN;
    private final int CMSG_LOGOUT_REQUEST;
    private final int CMSG_NAME_QUERY;
    private final int SMSG_NAME_QUERY;
    private final int CMSG_GUILD_QUERY;
    private final int SMSG_GUILD_QUERY;
    private final int CMSG_WHO;
    private final int SMSG_WHO;
    private final int CMSG_GUILD_ROSTER;
    private final int SMSG_GUILD_ROSTER;
    private final int SMSG_GUILD_EVENT;
    private final int CMSG_MESSAGECHAT;
    private final int SMSG_MESSAGECHAT;
    private final int CMSG_JOIN_CHANNEL;
    private final int SMSG_CHANNEL_NOTIFY;
    private final int SMSG_NOTIFICATION;
    private final int CMSG_PING;
    private final int SMSG_AUTH_CHALLENGE;
    private final int CMSG_AUTH_CHALLENGE;
    private final int SMSG_AUTH_RESPONSE;
    private final int SMSG_LOGIN_VERIFY_WORLD;
    private final int SMSG_SERVER_MESSAGE;
    private final int SMSG_WARDEN_DATA;
    private final int CMSG_WARDEN_DATA;
    private final int SMSG_INVALIDATE_PLAYER;
    private final int SMSG_TIME_SYNC_REQ;
    private final int CMSG_TIME_SYNC_RESP;
    private volatile GamePackets$ChatEvents$ ChatEvents$module;
    private volatile GamePackets$GuildEvents$ GuildEvents$module;
    private volatile GamePackets$Races$ Races$module;
    private volatile GamePackets$Classes$ Classes$module;
    private volatile GamePackets$Genders$ Genders$module;
    private volatile GamePackets$AuthResponseCodes$ AuthResponseCodes$module;
    private volatile GamePackets$ChatNotify$ ChatNotify$module;
    private volatile GamePackets$ServerMessageType$ ServerMessageType$module;
    private volatile GamePackets$ChatChannelIds$ ChatChannelIds$module;

    @Override
    public Logger logger() {
        return this.logger;
    }

    @Override
    public void com$typesafe$scalalogging$StrictLogging$_setter_$logger_$eq(Logger x$1) {
        this.logger = x$1;
    }

    @Override
    public AttributeKey<GameHeaderCrypt> CRYPT() {
        return this.CRYPT;
    }

    @Override
    public int CMSG_CHAR_ENUM() {
        return this.CMSG_CHAR_ENUM;
    }

    @Override
    public int SMSG_CHAR_ENUM() {
        return this.SMSG_CHAR_ENUM;
    }

    @Override
    public int CMSG_PLAYER_LOGIN() {
        return this.CMSG_PLAYER_LOGIN;
    }

    @Override
    public int CMSG_LOGOUT_REQUEST() {
        return this.CMSG_LOGOUT_REQUEST;
    }

    @Override
    public int CMSG_NAME_QUERY() {
        return this.CMSG_NAME_QUERY;
    }

    @Override
    public int SMSG_NAME_QUERY() {
        return this.SMSG_NAME_QUERY;
    }

    @Override
    public int CMSG_GUILD_QUERY() {
        return this.CMSG_GUILD_QUERY;
    }

    @Override
    public int SMSG_GUILD_QUERY() {
        return this.SMSG_GUILD_QUERY;
    }

    @Override
    public int CMSG_WHO() {
        return this.CMSG_WHO;
    }

    @Override
    public int SMSG_WHO() {
        return this.SMSG_WHO;
    }

    @Override
    public int CMSG_GUILD_ROSTER() {
        return this.CMSG_GUILD_ROSTER;
    }

    @Override
    public int SMSG_GUILD_ROSTER() {
        return this.SMSG_GUILD_ROSTER;
    }

    @Override
    public int SMSG_GUILD_EVENT() {
        return this.SMSG_GUILD_EVENT;
    }

    @Override
    public int CMSG_MESSAGECHAT() {
        return this.CMSG_MESSAGECHAT;
    }

    @Override
    public int SMSG_MESSAGECHAT() {
        return this.SMSG_MESSAGECHAT;
    }

    @Override
    public int CMSG_JOIN_CHANNEL() {
        return this.CMSG_JOIN_CHANNEL;
    }

    @Override
    public int SMSG_CHANNEL_NOTIFY() {
        return this.SMSG_CHANNEL_NOTIFY;
    }

    @Override
    public int SMSG_NOTIFICATION() {
        return this.SMSG_NOTIFICATION;
    }

    @Override
    public int CMSG_PING() {
        return this.CMSG_PING;
    }

    @Override
    public int SMSG_AUTH_CHALLENGE() {
        return this.SMSG_AUTH_CHALLENGE;
    }

    @Override
    public int CMSG_AUTH_CHALLENGE() {
        return this.CMSG_AUTH_CHALLENGE;
    }

    @Override
    public int SMSG_AUTH_RESPONSE() {
        return this.SMSG_AUTH_RESPONSE;
    }

    @Override
    public int SMSG_LOGIN_VERIFY_WORLD() {
        return this.SMSG_LOGIN_VERIFY_WORLD;
    }

    @Override
    public int SMSG_SERVER_MESSAGE() {
        return this.SMSG_SERVER_MESSAGE;
    }

    @Override
    public int SMSG_WARDEN_DATA() {
        return this.SMSG_WARDEN_DATA;
    }

    @Override
    public int CMSG_WARDEN_DATA() {
        return this.CMSG_WARDEN_DATA;
    }

    @Override
    public int SMSG_INVALIDATE_PLAYER() {
        return this.SMSG_INVALIDATE_PLAYER;
    }

    @Override
    public int SMSG_TIME_SYNC_REQ() {
        return this.SMSG_TIME_SYNC_REQ;
    }

    @Override
    public int CMSG_TIME_SYNC_RESP() {
        return this.CMSG_TIME_SYNC_RESP;
    }

    @Override
    public GamePackets$ChatEvents$ ChatEvents() {
        if (this.ChatEvents$module == null) {
            this.ChatEvents$lzycompute$1();
        }
        return this.ChatEvents$module;
    }

    @Override
    public GamePackets$GuildEvents$ GuildEvents() {
        if (this.GuildEvents$module == null) {
            this.GuildEvents$lzycompute$1();
        }
        return this.GuildEvents$module;
    }

    @Override
    public GamePackets$Races$ Races() {
        if (this.Races$module == null) {
            this.Races$lzycompute$1();
        }
        return this.Races$module;
    }

    @Override
    public GamePackets$Classes$ Classes() {
        if (this.Classes$module == null) {
            this.Classes$lzycompute$1();
        }
        return this.Classes$module;
    }

    @Override
    public GamePackets$Genders$ Genders() {
        if (this.Genders$module == null) {
            this.Genders$lzycompute$1();
        }
        return this.Genders$module;
    }

    @Override
    public GamePackets$AuthResponseCodes$ AuthResponseCodes() {
        if (this.AuthResponseCodes$module == null) {
            this.AuthResponseCodes$lzycompute$1();
        }
        return this.AuthResponseCodes$module;
    }

    @Override
    public GamePackets$ChatNotify$ ChatNotify() {
        if (this.ChatNotify$module == null) {
            this.ChatNotify$lzycompute$1();
        }
        return this.ChatNotify$module;
    }

    @Override
    public GamePackets$ServerMessageType$ ServerMessageType() {
        if (this.ServerMessageType$module == null) {
            this.ServerMessageType$lzycompute$1();
        }
        return this.ServerMessageType$module;
    }

    @Override
    public GamePackets$ChatChannelIds$ ChatChannelIds() {
        if (this.ChatChannelIds$module == null) {
            this.ChatChannelIds$lzycompute$1();
        }
        return this.ChatChannelIds$module;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$CRYPT_$eq(AttributeKey<GameHeaderCrypt> x$1) {
        this.CRYPT = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$CMSG_CHAR_ENUM_$eq(int x$1) {
        this.CMSG_CHAR_ENUM = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_CHAR_ENUM_$eq(int x$1) {
        this.SMSG_CHAR_ENUM = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$CMSG_PLAYER_LOGIN_$eq(int x$1) {
        this.CMSG_PLAYER_LOGIN = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$CMSG_LOGOUT_REQUEST_$eq(int x$1) {
        this.CMSG_LOGOUT_REQUEST = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$CMSG_NAME_QUERY_$eq(int x$1) {
        this.CMSG_NAME_QUERY = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_NAME_QUERY_$eq(int x$1) {
        this.SMSG_NAME_QUERY = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$CMSG_GUILD_QUERY_$eq(int x$1) {
        this.CMSG_GUILD_QUERY = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_GUILD_QUERY_$eq(int x$1) {
        this.SMSG_GUILD_QUERY = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$CMSG_WHO_$eq(int x$1) {
        this.CMSG_WHO = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_WHO_$eq(int x$1) {
        this.SMSG_WHO = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$CMSG_GUILD_ROSTER_$eq(int x$1) {
        this.CMSG_GUILD_ROSTER = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_GUILD_ROSTER_$eq(int x$1) {
        this.SMSG_GUILD_ROSTER = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_GUILD_EVENT_$eq(int x$1) {
        this.SMSG_GUILD_EVENT = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$CMSG_MESSAGECHAT_$eq(int x$1) {
        this.CMSG_MESSAGECHAT = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_MESSAGECHAT_$eq(int x$1) {
        this.SMSG_MESSAGECHAT = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$CMSG_JOIN_CHANNEL_$eq(int x$1) {
        this.CMSG_JOIN_CHANNEL = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_CHANNEL_NOTIFY_$eq(int x$1) {
        this.SMSG_CHANNEL_NOTIFY = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_NOTIFICATION_$eq(int x$1) {
        this.SMSG_NOTIFICATION = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$CMSG_PING_$eq(int x$1) {
        this.CMSG_PING = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_AUTH_CHALLENGE_$eq(int x$1) {
        this.SMSG_AUTH_CHALLENGE = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$CMSG_AUTH_CHALLENGE_$eq(int x$1) {
        this.CMSG_AUTH_CHALLENGE = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_AUTH_RESPONSE_$eq(int x$1) {
        this.SMSG_AUTH_RESPONSE = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_LOGIN_VERIFY_WORLD_$eq(int x$1) {
        this.SMSG_LOGIN_VERIFY_WORLD = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_SERVER_MESSAGE_$eq(int x$1) {
        this.SMSG_SERVER_MESSAGE = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_WARDEN_DATA_$eq(int x$1) {
        this.SMSG_WARDEN_DATA = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$CMSG_WARDEN_DATA_$eq(int x$1) {
        this.CMSG_WARDEN_DATA = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_INVALIDATE_PLAYER_$eq(int x$1) {
        this.SMSG_INVALIDATE_PLAYER = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_TIME_SYNC_REQ_$eq(int x$1) {
        this.SMSG_TIME_SYNC_REQ = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$CMSG_TIME_SYNC_RESP_$eq(int x$1) {
        this.CMSG_TIME_SYNC_RESP = x$1;
    }

    public byte[] addonInfo() {
        return this.addonInfo;
    }

    public Option<Object> selfCharacterId() {
        return this.selfCharacterId;
    }

    public void selfCharacterId_$eq(Option<Object> x$1) {
        this.selfCharacterId = x$1;
    }

    public byte languageId() {
        return this.languageId;
    }

    public void languageId_$eq(byte x$1) {
        this.languageId = x$1;
    }

    public boolean inWorld() {
        return this.inWorld;
    }

    public void inWorld_$eq(boolean x$1) {
        this.inWorld = x$1;
    }

    public long guildGuid() {
        return this.guildGuid;
    }

    public void guildGuid_$eq(long x$1) {
        this.guildGuid = x$1;
    }

    public GuildInfo guildInfo() {
        return this.guildInfo;
    }

    public void guildInfo_$eq(GuildInfo x$1) {
        this.guildInfo = x$1;
    }

    public Option<String> guildMotd() {
        return this.guildMotd;
    }

    public void guildMotd_$eq(Option<String> x$1) {
        this.guildMotd = x$1;
    }

    public Option<ChannelHandlerContext> ctx() {
        return this.ctx;
    }

    public void ctx_$eq(Option<ChannelHandlerContext> x$1) {
        this.ctx = x$1;
    }

    public Map<Object, Player> playerRoster() {
        return this.playerRoster;
    }

    public Map<Object, GuildMember> guildRoster() {
        return this.guildRoster;
    }

    public long lastRequestedGuildRoster() {
        return this.lastRequestedGuildRoster;
    }

    public void lastRequestedGuildRoster_$eq(long x$1) {
        this.lastRequestedGuildRoster = x$1;
    }

    public ScheduledExecutorService executorService() {
        return this.executorService;
    }

    private HashMap<Object, ListBuffer<ChatMessage>> queuedChatMessages() {
        return this.queuedChatMessages;
    }

    private Option<WardenHandler> wardenHandler() {
        return this.wardenHandler;
    }

    private void wardenHandler_$eq(Option<WardenHandler> x$1) {
        this.wardenHandler = x$1;
    }

    private boolean receivedCharEnum() {
        return this.receivedCharEnum;
    }

    private void receivedCharEnum_$eq(boolean x$1) {
        this.receivedCharEnum = x$1;
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        this.executorService().shutdown();
        this.ctx_$eq(None$.MODULE$);
        this.gameEventCallback.disconnected();
        Global$.MODULE$.game_$eq(None$.MODULE$);
        if (this.inWorld()) {
            Global$.MODULE$.discord().sendMessageFromWow(None$.MODULE$, "Disconnected from server!", this.ChatEvents().CHAT_MSG_SYSTEM(), None$.MODULE$);
        }
        super.channelInactive(ctx);
    }

    public void runKeepAliveExecutor() {
    }

    private void runPingExecutor() {
        this.executorService().scheduleWithFixedDelay(new Runnable(this){
            private int pingId;
            private final /* synthetic */ GamePacketHandler $outer;

            private int pingId() {
                return this.pingId;
            }

            private void pingId_$eq(int x$1) {
                this.pingId = x$1;
            }

            public void run() {
                int latency = Random$.MODULE$.nextInt(50) + 90;
                ByteBuf byteBuf = PooledByteBufAllocator.DEFAULT.buffer(8, 8);
                byteBuf.writeIntLE(this.pingId());
                byteBuf.writeIntLE(latency);
                ((ChannelOutboundInvoker)this.$outer.ctx().get()).writeAndFlush(new Packet(this.$outer.CMSG_PING(), byteBuf));
                this.pingId_$eq(this.pingId() + 1);
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.pingId = 0;
            }
        }, 30L, 30L, TimeUnit.SECONDS);
    }

    private void runGuildRosterExecutor() {
        this.executorService().scheduleWithFixedDelay(() -> {
            block0: {
                if (System.currentTimeMillis() - this.lastRequestedGuildRoster() < 60000L) break block0;
                this.updateGuildRoster();
            }
        }, 61L, 61L, TimeUnit.SECONDS);
    }

    public String buildGuildiesOnline() {
        String characterName = Global$.MODULE$.config().wow().character();
        return ((TraversableOnce)((TraversableLike)this.guildRoster().valuesIterator().filter((Function1<GuildMember, Object> & Serializable & scala.Serializable)guildMember -> BoxesRunTime.boxToBoolean(GamePacketHandler.$anonfun$buildGuildiesOnline$1(characterName, guildMember))).toSeq().sortBy((Function1<GuildMember, String> & Serializable & scala.Serializable)x$2 -> x$2.name(), Ordering$String$.MODULE$)).map((Function1<GuildMember, String> & Serializable & scala.Serializable)m -> new StringBuilder(8).append(m.name()).append(" (").append(m.level()).append(" ").append(this.Classes().valueOf(m.charClass())).append(" in ").append(GameResources$.MODULE$.AREA().getOrElse(BoxesRunTime.boxToInteger(m.zoneId()), (Function0<String> & Serializable & scala.Serializable)() -> "Unknown Zone")).append(")").toString(), Seq$.MODULE$.canBuildFrom())).mkString(this.getGuildiesOnlineMessage(false), ", ", "");
    }

    public String getGuildiesOnlineMessage(boolean isStatus) {
        int size = this.guildRoster().count((Function1<Tuple2, Object> & Serializable & scala.Serializable)x$3 -> BoxesRunTime.boxToBoolean(GamePacketHandler.$anonfun$getGuildiesOnlineMessage$1(x$3))) - 1;
        String guildies = new StringBuilder(7).append("guildie").append((Object)(size != 1 ? "s" : "")).toString();
        return isStatus ? new StringBuilder(8).append(size).append(" ").append(guildies).append(" online").toString() : (size <= 0 ? "Currently no guildies online." : new StringBuilder(20).append("Currently ").append(size).append(" ").append(guildies).append(" online:\n").toString());
    }

    public void updateGuildiesOnline() {
        Global$.MODULE$.discord().changeGuildStatus(this.getGuildiesOnlineMessage(true));
    }

    public void queryGuildName() {
        ByteBuf out = PooledByteBufAllocator.DEFAULT.buffer(4, 4);
        out.writeIntLE((int)this.guildGuid());
        ((ChannelOutboundInvoker)this.ctx().get()).writeAndFlush(new Packet(this.CMSG_GUILD_QUERY(), out));
    }

    private void updateGuildRoster() {
        this.lastRequestedGuildRoster_$eq(System.currentTimeMillis());
        ((ChannelOutboundInvoker)this.ctx().get()).writeAndFlush(this.buildGuildRosterPacket());
    }

    public Packet buildGuildRosterPacket() {
        return new Packet(this.CMSG_GUILD_ROSTER(), Packet$.MODULE$.apply$default$2());
    }

    public Option<ChannelFuture> sendLogout() {
        return this.ctx().flatMap((Function1<ChannelHandlerContext, Option> & Serializable & scala.Serializable)ctx -> ctx.channel().isActive() ? new Some<ChannelFuture>(ctx.writeAndFlush(new Packet(this.CMSG_LOGOUT_REQUEST(), Packet$.MODULE$.apply$default$2()))) : None$.MODULE$);
    }

    @Override
    public void sendMessageToWow(byte tp, String message, Option<String> target) {
        this.ctx().fold((JFunction0$mcV$sp & scala.Serializable)() -> {
            BoxedUnit boxedUnit;
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("Cannot send message! Not connected to WoW!");
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
        }, (Function1<ChannelHandlerContext, Object> & Serializable & scala.Serializable)ctx -> {
            ctx.writeAndFlush(this.buildChatMessage(tp, message.getBytes("UTF-8"), target.map((Function1<String, byte[]> & Serializable & scala.Serializable)x$4 -> x$4.getBytes("UTF-8"))));
            return BoxedUnit.UNIT;
        });
    }

    public Packet buildChatMessage(byte tp, byte[] utf8MessageBytes, Option<byte[]> utf8TargetBytes2) {
        ByteBuf out = PooledByteBufAllocator.DEFAULT.buffer(128, 8192);
        out.writeIntLE(tp);
        out.writeIntLE(this.languageId());
        utf8TargetBytes2.foreach((Function1<byte[], ByteBuf> & Serializable & scala.Serializable)utf8TargetBytes -> {
            out.writeBytes((byte[])utf8TargetBytes);
            return out.writeByte(0);
        });
        out.writeBytes(utf8MessageBytes);
        out.writeByte(0);
        return new Packet(this.CMSG_MESSAGECHAT(), out);
    }

    @Override
    public void sendNotification(String message) {
        this.sendMessageToWow(this.ChatEvents().CHAT_MSG_GUILD(), message, None$.MODULE$);
    }

    public void sendNameQuery(long guid) {
        this.ctx().foreach((Function1<ChannelHandlerContext, ChannelFuture> & Serializable & scala.Serializable)ctx -> {
            ByteBuf out = PooledByteBufAllocator.DEFAULT.buffer(8, 8);
            out.writeLongLE(guid);
            return ctx.writeAndFlush(new Packet(this.CMSG_NAME_QUERY(), out));
        });
    }

    @Override
    public Option<String> handleWho(Option<String> arguments) {
        Option option;
        if (arguments.isDefined()) {
            ByteBuf byteBuf = this.buildWhoMessage(arguments.get());
            ((ChannelOutboundInvoker)this.ctx().get()).writeAndFlush(new Packet(this.CMSG_WHO(), byteBuf));
            option = None$.MODULE$;
        } else {
            option = new Some<String>(this.buildGuildiesOnline());
        }
        return option;
    }

    @Override
    public Option<String> handleGmotd() {
        return this.guildMotd().map((Function1<String, String> & Serializable & scala.Serializable)guildMotd -> {
            GuildNotificationConfig guildNotificationConfig = (GuildNotificationConfig)Global$.MODULE$.config().guildConfig().notificationConfigs().apply("motd");
            return guildNotificationConfig.format().replace("%time", Global$.MODULE$.getTime()).replace("%user", "").replace("%message", (CharSequence)guildMotd);
        });
    }

    public ByteBuf buildWhoMessage(String name) {
        ByteBuf byteBuf = PooledByteBufAllocator.DEFAULT.buffer(64, 64);
        byteBuf.writeIntLE(0);
        byteBuf.writeIntLE(100);
        byteBuf.writeBytes(name.getBytes("UTF-8"));
        byteBuf.writeByte(0);
        byteBuf.writeByte(0);
        byteBuf.writeIntLE(-1);
        byteBuf.writeIntLE(-1);
        byteBuf.writeIntLE(0);
        return byteBuf.writeIntLE(0);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        BoxedUnit boxedUnit;
        if (this.logger().underlying().isInfoEnabled()) {
            this.logger().underlying().info("Connected! Authenticating...");
            boxedUnit = BoxedUnit.UNIT;
        } else {
            boxedUnit = BoxedUnit.UNIT;
        }
        this.ctx_$eq(new Some<ChannelHandlerContext>(ctx));
        Global$.MODULE$.game_$eq(new Some<GameCommandHandler>(this));
        this.runPingExecutor();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        Object object = msg;
        if (object instanceof Packet) {
            Packet packet = (Packet)object;
            this.channelParse(packet);
            packet.byteBuf().release();
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        } else {
            BoxedUnit boxedUnit;
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("Packet is instance of {}", new Object[]{object.getClass()});
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
            BoxedUnit boxedUnit2 = boxedUnit;
        }
    }

    public void channelParse(Packet msg) {
        int n = msg.id();
        if (this.SMSG_AUTH_CHALLENGE() == n) {
            this.handle_SMSG_AUTH_CHALLENGE(msg);
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        } else if (this.SMSG_AUTH_RESPONSE() == n) {
            this.handle_SMSG_AUTH_RESPONSE(msg);
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        } else if (this.SMSG_NAME_QUERY() == n) {
            this.handle_SMSG_NAME_QUERY(msg);
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        } else if (this.SMSG_CHAR_ENUM() == n) {
            this.handle_SMSG_CHAR_ENUM(msg);
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        } else if (this.SMSG_LOGIN_VERIFY_WORLD() == n) {
            this.handle_SMSG_LOGIN_VERIFY_WORLD(msg);
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        } else if (this.SMSG_GUILD_QUERY() == n) {
            this.handle_SMSG_GUILD_QUERY(msg);
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        } else if (this.SMSG_GUILD_EVENT() == n) {
            this.handle_SMSG_GUILD_EVENT(msg);
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        } else if (this.SMSG_GUILD_ROSTER() == n) {
            this.handle_SMSG_GUILD_ROSTER(msg);
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        } else if (this.SMSG_MESSAGECHAT() == n) {
            this.handle_SMSG_MESSAGECHAT(msg);
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        } else if (this.SMSG_CHANNEL_NOTIFY() == n) {
            this.handle_SMSG_CHANNEL_NOTIFY(msg);
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        } else if (this.SMSG_NOTIFICATION() == n) {
            this.handle_SMSG_NOTIFICATION(msg);
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        } else if (this.SMSG_WHO() == n) {
            this.handle_SMSG_WHO(msg);
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        } else if (this.SMSG_SERVER_MESSAGE() == n) {
            this.handle_SMSG_SERVER_MESSAGE(msg);
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        } else if (this.SMSG_INVALIDATE_PLAYER() == n) {
            this.handle_SMSG_INVALIDATE_PLAYER(msg);
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        } else if (this.SMSG_WARDEN_DATA() == n) {
            this.handle_SMSG_WARDEN_DATA(msg);
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        } else {
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        }
    }

    private void handle_SMSG_AUTH_CHALLENGE(Packet msg) {
        AuthChallengeMessage authChallengeMessage = this.parseAuthChallenge(msg);
        this.ctx().get().channel().attr(this.CRYPT()).get().init(authChallengeMessage.sessionKey());
        ((ChannelOutboundInvoker)this.ctx().get()).writeAndFlush(new Packet(this.CMSG_AUTH_CHALLENGE(), authChallengeMessage.byteBuf()));
    }

    public AuthChallengeMessage parseAuthChallenge(Packet msg) {
        byte[] account = Global$.MODULE$.config().wow().account();
        int serverSeed = msg.byteBuf().readInt();
        int clientSeed = Random$.MODULE$.nextInt();
        ByteBuf out = PooledByteBufAllocator.DEFAULT.buffer(200, 400);
        out.writeShortLE(0);
        out.writeIntLE(WowChatConfig$.MODULE$.getGameBuild());
        out.writeIntLE(0);
        out.writeBytes(account);
        out.writeByte(0);
        out.writeInt(clientSeed);
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.update(account);
        md.update((byte[])Array$.MODULE$.apply(Predef$.MODULE$.wrapByteArray(new byte[]{0, 0, 0, 0}), ClassTag$.MODULE$.Byte()));
        md.update(ByteUtils$.MODULE$.intToBytes(clientSeed));
        md.update(ByteUtils$.MODULE$.intToBytes(serverSeed));
        md.update(this.sessionKey);
        out.writeBytes(md.digest());
        out.writeBytes(this.addonInfo());
        return new AuthChallengeMessage(this.sessionKey, out);
    }

    private void handle_SMSG_AUTH_RESPONSE(Packet msg) {
        byte code = this.parseAuthResponse(msg);
        if (code == this.AuthResponseCodes().AUTH_OK()) {
            BoxedUnit boxedUnit;
            if (this.logger().underlying().isInfoEnabled()) {
                this.logger().underlying().info("Successfully logged in!");
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
            this.sendCharEnum();
        } else if (code == this.AuthResponseCodes().AUTH_WAIT_QUEUE()) {
            BoxedUnit boxedUnit;
            Object object = msg.byteBuf().readableBytes() >= 14 ? msg.byteBuf().skipBytes(10) : BoxedUnit.UNIT;
            int position = msg.byteBuf().readIntLE();
            if (this.logger().underlying().isInfoEnabled()) {
                this.logger().underlying().info("Queue enabled. Position: {}", new Object[]{BoxesRunTime.boxToInteger(position)});
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
        } else {
            BoxedUnit boxedUnit;
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error(this.AuthResponseCodes().getMessage(code));
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
            this.ctx().foreach((Function1<ChannelHandlerContext, ChannelFuture> & Serializable & scala.Serializable)x$5 -> x$5.close());
            this.gameEventCallback.error();
        }
    }

    private void sendCharEnum() {
        block0: {
            if (this.receivedCharEnum()) break block0;
            ((ChannelOutboundInvoker)this.ctx().get()).writeAndFlush(new Packet(this.CMSG_CHAR_ENUM(), Packet$.MODULE$.apply$default$2()));
        }
    }

    public byte parseAuthResponse(Packet msg) {
        return msg.byteBuf().readByte();
    }

    private void handle_SMSG_NAME_QUERY(Packet msg) {
        NameQueryMessage nameQueryMessage = this.parseNameQuery(msg);
        this.queuedChatMessages().remove(BoxesRunTime.boxToLong(nameQueryMessage.guid())).foreach((Function1<ListBuffer, Map> & Serializable & scala.Serializable)messages -> {
            messages.foreach((Function1<ChatMessage, Object> & Serializable & scala.Serializable)message -> {
                GamePacketHandler.$anonfun$handle_SMSG_NAME_QUERY$2(nameQueryMessage, message);
                return BoxedUnit.UNIT;
            });
            return (Map)this.playerRoster().$plus$eq(Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(BoxesRunTime.boxToLong(nameQueryMessage.guid())), new Player(nameQueryMessage.name(), nameQueryMessage.charClass())));
        });
    }

    public NameQueryMessage parseNameQuery(Packet msg) {
        long guid = msg.byteBuf().readLongLE();
        String name = msg.readString();
        msg.skipString();
        msg.byteBuf().skipBytes(4);
        msg.byteBuf().skipBytes(4);
        byte charClass = (byte)msg.byteBuf().readIntLE();
        return new NameQueryMessage(guid, name, charClass);
    }

    private void handle_SMSG_CHAR_ENUM(Packet msg) {
        BoxedUnit boxedUnit;
        if (this.receivedCharEnum()) {
            if (this.inWorld()) {
                return;
            }
            if (this.logger().underlying().isInfoEnabled()) {
                this.logger().underlying().info("Received character enum more than once. Trying to join the world again...");
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
        } else {
            boxedUnit = BoxedUnit.UNIT;
        }
        this.receivedCharEnum_$eq(true);
        this.parseCharEnum(msg).fold((JFunction0$mcV$sp & scala.Serializable)() -> {
            BoxedUnit boxedUnit;
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("Character {} not found!", new Object[]{Global$.MODULE$.config().wow().character()});
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
        }, (Function1<CharEnumMessage, Object> & Serializable & scala.Serializable)character -> {
            GamePacketHandler.$anonfun$handle_SMSG_CHAR_ENUM$2(this, character);
            return BoxedUnit.UNIT;
        });
    }

    public Option<CharEnumMessage> parseCharEnum(Packet msg) {
        Option option;
        Object object = new Object();
        try {
            byte[] characterBytes = Global$.MODULE$.config().wow().character().toLowerCase().getBytes("UTF-8");
            byte charactersNum = msg.byteBuf().readByte();
            RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), charactersNum).foreach((Function1<Object, ByteBuf> & Serializable & scala.Serializable)i -> GamePacketHandler.$anonfun$parseCharEnum$1(msg, characterBytes, object, BoxesRunTime.unboxToInt(i)));
            option = None$.MODULE$;
        }
        catch (NonLocalReturnControl ex) {
            if (ex.key() == object) {
                option = (Option)ex.value();
            }
            throw ex;
        }
        return option;
    }

    public void writePlayerLogin(ByteBuf out) {
        out.writeLongLE(BoxesRunTime.unboxToLong(this.selfCharacterId().get()));
    }

    private void handle_SMSG_LOGIN_VERIFY_WORLD(Packet msg) {
        BoxedUnit boxedUnit;
        if (this.inWorld()) {
            return;
        }
        if (this.logger().underlying().isInfoEnabled()) {
            this.logger().underlying().info("Successfully joined the world!");
            boxedUnit = BoxedUnit.UNIT;
        } else {
            boxedUnit = BoxedUnit.UNIT;
        }
        this.inWorld_$eq(true);
        Global$.MODULE$.discord().changeRealmStatus(this.realmName);
        this.gameEventCallback.connected();
        this.runKeepAliveExecutor();
        this.runGuildRosterExecutor();
        if (this.guildGuid() != 0L) {
            this.queryGuildName();
            this.updateGuildRoster();
        }
        ((IterableLike)Global$.MODULE$.config().channels().flatMap((Function1<ChannelConfig, Iterable> & Serializable & scala.Serializable)channelConfig -> Option$.MODULE$.option2Iterable((Option)channelConfig.wow().channel().fold((Function0<None$> & Serializable & scala.Serializable)() -> None$.MODULE$, (Function1<String, Some> & Serializable & scala.Serializable)channelName -> new Some(Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(channelConfig.wow().id().getOrElse((JFunction0$mcI$sp & scala.Serializable)() -> this.ChatChannelIds().getId((String)channelName))), channelName)))), Seq$.MODULE$.canBuildFrom())).foreach((Function1<Tuple2, ChannelFuture> & Serializable & scala.Serializable)x0$1 -> {
            String name;
            int id;
            Tuple2 tuple2 = x0$1;
            if (tuple2 != null) {
                BoxedUnit boxedUnit;
                id = tuple2._1$mcI$sp();
                name = (String)tuple2._2();
                if (this.logger().underlying().isInfoEnabled()) {
                    this.logger().underlying().info("Joining channel {}", new Object[]{name});
                    boxedUnit = BoxedUnit.UNIT;
                } else {
                    boxedUnit = BoxedUnit.UNIT;
                }
            } else {
                throw new MatchError(tuple2);
            }
            ByteBuf byteBuf = PooledByteBufAllocator.DEFAULT.buffer(50, 200);
            this.writeJoinChannel(byteBuf, id, name.getBytes("UTF-8"));
            ChannelFuture channelFuture = ((ChannelOutboundInvoker)this.ctx().get()).writeAndFlush(new Packet(this.CMSG_JOIN_CHANNEL(), byteBuf));
            return channelFuture;
        });
    }

    public void writeJoinChannel(ByteBuf out, int id, byte[] utf8ChannelBytes) {
        out.writeBytes(utf8ChannelBytes);
        out.writeByte(0);
        out.writeByte(0);
    }

    private void handle_SMSG_GUILD_QUERY(Packet msg) {
        this.guildInfo_$eq(this.handleGuildQuery(msg));
    }

    public GuildInfo handleGuildQuery(Packet msg) {
        msg.byteBuf().skipBytes(4);
        String name = msg.readString();
        scala.collection.immutable.Map<Object, String> ranks = ((TraversableOnce)((TraversableLike)RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), 10).map((Function1<Object, Tuple2> & Serializable & scala.Serializable)x$6 -> Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$6))), msg.readString()), IndexedSeq$.MODULE$.canBuildFrom())).filter((Function1<Tuple2, Object> & Serializable & scala.Serializable)x0$1 -> BoxesRunTime.boxToBoolean(GamePacketHandler.$anonfun$handleGuildQuery$2(x0$1)))).toMap(Predef$.MODULE$.$conforms());
        return new GuildInfo(name, ranks);
    }

    private void handle_SMSG_GUILD_EVENT(Packet msg) {
        byte event = msg.byteBuf().readByte();
        byte numStrings = msg.byteBuf().readByte();
        IndexedSeq<String> messages = RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), numStrings).map((Function1<Object, String> & Serializable & scala.Serializable)i -> msg.readString(), IndexedSeq$.MODULE$.canBuildFrom());
        this.handleGuildEvent(event, messages);
    }

    public void handleGuildEvent(byte event, Seq<String> messages) {
        String string;
        if (messages.forall((Function1<String, Object> & Serializable & scala.Serializable)x$7 -> BoxesRunTime.boxToBoolean(GamePacketHandler.$anonfun$handleGuildEvent$1(x$7)))) {
            return;
        }
        if (event != this.GuildEvents().GE_MOTD() && Global$.MODULE$.config().wow().character().equalsIgnoreCase((String)messages.head())) {
            return;
        }
        byte by = event;
        if (this.GuildEvents().GE_PROMOTED() == by) {
            string = "promoted";
        } else if (this.GuildEvents().GE_DEMOTED() == by) {
            string = "demoted";
        } else if (this.GuildEvents().GE_MOTD() == by) {
            string = "motd";
        } else if (this.GuildEvents().GE_JOINED() == by) {
            string = "joined";
        } else if (this.GuildEvents().GE_LEFT() == by) {
            string = "left";
        } else if (this.GuildEvents().GE_REMOVED() == by) {
            string = "removed";
        } else if (this.GuildEvents().GE_SIGNED_ON() == by) {
            string = "online";
        } else if (this.GuildEvents().GE_SIGNED_OFF() == by) {
            string = "offline";
        } else {
            return;
        }
        String eventConfigKey = string;
        GuildNotificationConfig guildNotificationConfig = (GuildNotificationConfig)Global$.MODULE$.config().guildConfig().notificationConfigs().apply(eventConfigKey);
        if (guildNotificationConfig.enabled()) {
            byte by2 = event;
            boolean bl = this.GuildEvents().GE_PROMOTED() == by2 ? true : this.GuildEvents().GE_DEMOTED() == by2;
            String string2 = bl ? guildNotificationConfig.format().replace("%time", Global$.MODULE$.getTime()).replace("%user", (CharSequence)messages.head()).replace("%message", (CharSequence)messages.head()).replace("%target", (CharSequence)messages.apply(true)).replace("%rank", (CharSequence)messages.apply(2)) : (this.GuildEvents().GE_REMOVED() == by2 ? guildNotificationConfig.format().replace("%time", Global$.MODULE$.getTime()).replace("%user", (CharSequence)messages.apply(true)).replace("%message", (CharSequence)messages.apply(true)).replace("%target", (CharSequence)messages.head()) : guildNotificationConfig.format().replace("%time", Global$.MODULE$.getTime()).replace("%user", (CharSequence)messages.head()).replace("%message", (CharSequence)messages.head()));
            String formatted = string2;
            Global$.MODULE$.discord().sendGuildNotification(eventConfigKey, formatted);
        }
        this.updateGuildRoster();
    }

    private void handle_SMSG_GUILD_ROSTER(Packet msg) {
        this.guildRoster().clear();
        this.guildRoster().$plus$plus$eq(this.parseGuildRoster(msg));
        this.updateGuildiesOnline();
    }

    public scala.collection.immutable.Map<Object, GuildMember> parseGuildRoster(Packet msg) {
        int count = msg.byteBuf().readIntLE();
        this.guildMotd_$eq(new Some<String>(msg.readString()));
        String ginfo = msg.readString();
        int rankscount = msg.byteBuf().readIntLE();
        RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), rankscount).foreach((Function1<Object, ByteBuf> & Serializable & scala.Serializable)i -> GamePacketHandler.$anonfun$parseGuildRoster$1(msg, BoxesRunTime.unboxToInt(i)));
        return ((TraversableOnce)RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), count).map((Function1<Object, Tuple2> & Serializable & scala.Serializable)i -> GamePacketHandler.$anonfun$parseGuildRoster$2(msg, BoxesRunTime.unboxToInt(i)), IndexedSeq$.MODULE$.canBuildFrom())).toMap(Predef$.MODULE$.$conforms());
    }

    public void handle_SMSG_MESSAGECHAT(Packet msg) {
        BoxedUnit boxedUnit;
        if (this.logger().underlying().isDebugEnabled()) {
            this.logger().underlying().debug("RECV CHAT: {}", new Object[]{ByteUtils$.MODULE$.toHexString(msg.byteBuf(), true, true)});
            boxedUnit = BoxedUnit.UNIT;
        } else {
            boxedUnit = BoxedUnit.UNIT;
        }
        this.parseChatMessage(msg).foreach((Function1<ChatMessage, Object> & Serializable & scala.Serializable)chatMessage -> {
            this.sendChatMessage(chatMessage);
            return BoxedUnit.UNIT;
        });
    }

    public void sendChatMessage(ChatMessage chatMessage) {
        if (chatMessage.guid() == 0L) {
            Global$.MODULE$.discord().sendMessageFromWow(None$.MODULE$, chatMessage.message(), chatMessage.tp(), None$.MODULE$);
        } else {
            this.playerRoster().get(BoxesRunTime.boxToLong(chatMessage.guid())).fold((JFunction0$mcV$sp & scala.Serializable)() -> this.queuedChatMessages().get(BoxesRunTime.boxToLong(chatMessage.guid())).fold((JFunction0$mcV$sp & scala.Serializable)() -> {
                this.queuedChatMessages().$plus$eq(Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(BoxesRunTime.boxToLong(chatMessage.guid())), ListBuffer$.MODULE$.apply(Predef$.MODULE$.wrapRefArray((Object[])new ChatMessage[]{chatMessage}))));
                this.sendNameQuery(chatMessage.guid());
            }, (Function1<ListBuffer, Object> & Serializable & scala.Serializable)x$8 -> {
                x$8.$plus$eq(chatMessage);
                return BoxedUnit.UNIT;
            }), (Function1<Player, Object> & Serializable & scala.Serializable)name -> {
                GamePacketHandler.$anonfun$sendChatMessage$4(chatMessage, name);
                return BoxedUnit.UNIT;
            });
        }
    }

    public Option<ChatMessage> parseChatMessage(Packet msg) {
        None$ channelName;
        Option option;
        byte tp = msg.byteBuf().readByte();
        int lang = msg.byteBuf().readIntLE();
        if (lang == -1) {
            return None$.MODULE$;
        }
        if (tp == this.ChatEvents().CHAT_MSG_CHANNEL()) {
            Some<String> ret = new Some<String>(msg.readString());
            msg.byteBuf().skipBytes(4);
            option = ret;
        } else {
            option = channelName = None$.MODULE$;
        }
        if (!Global$.MODULE$.wowToDiscord().contains(new Tuple2(BoxesRunTime.boxToByte(tp), channelName.map((Function1<String, String> & Serializable & scala.Serializable)x$9 -> x$9.toLowerCase())))) {
            return None$.MODULE$;
        }
        long guid = msg.byteBuf().readLongLE();
        if (tp != this.ChatEvents().CHAT_MSG_SYSTEM() && guid == BoxesRunTime.unboxToLong(this.selfCharacterId().get())) {
            return None$.MODULE$;
        }
        byte by = tp;
        boolean bl = this.ChatEvents().CHAT_MSG_SAY() == by ? true : this.ChatEvents().CHAT_MSG_YELL() == by;
        Object object = bl ? msg.byteBuf().skipBytes(8) : BoxedUnit.UNIT;
        int txtLen = msg.byteBuf().readIntLE();
        String txt = ((Object)msg.byteBuf().readCharSequence(txtLen - 1, Charset.forName("UTF-8"))).toString();
        return new Some<ChatMessage>(new ChatMessage(guid, tp, txt, channelName));
    }

    private void handle_SMSG_CHANNEL_NOTIFY(Packet msg) {
        byte id = msg.byteBuf().readByte();
        String channelName = msg.readString();
        byte by = id;
        if (this.ChatNotify().CHAT_YOU_JOINED_NOTICE() == by) {
            BoxedUnit boxedUnit;
            if (this.logger().underlying().isInfoEnabled()) {
                this.logger().underlying().info("Joined Channel: [{}]", new Object[]{channelName});
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
            BoxedUnit boxedUnit2 = boxedUnit;
        } else if (this.ChatNotify().CHAT_WRONG_PASSWORD_NOTICE() == by) {
            BoxedUnit boxedUnit;
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("Wrong password for {}.", new Object[]{channelName});
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
            BoxedUnit boxedUnit3 = boxedUnit;
        } else if (this.ChatNotify().CHAT_MUTED_NOTICE() == by) {
            BoxedUnit boxedUnit;
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("[{}] You do not have permission to speak.", new Object[]{channelName});
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
            BoxedUnit boxedUnit4 = boxedUnit;
        } else if (this.ChatNotify().CHAT_BANNED_NOTICE() == by) {
            BoxedUnit boxedUnit;
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("[{}] You are banned from that channel.", new Object[]{channelName});
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
            BoxedUnit boxedUnit5 = boxedUnit;
        } else if (this.ChatNotify().CHAT_WRONG_FACTION_NOTICE() == by) {
            BoxedUnit boxedUnit;
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("Wrong alliance for {}.", new Object[]{channelName});
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
            BoxedUnit boxedUnit6 = boxedUnit;
        } else if (this.ChatNotify().CHAT_INVALID_NAME_NOTICE() == by) {
            BoxedUnit boxedUnit;
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("Invalid channel name");
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
            BoxedUnit boxedUnit7 = boxedUnit;
        } else if (this.ChatNotify().CHAT_THROTTLED_NOTICE() == by) {
            BoxedUnit boxedUnit;
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("[{}] The number of messages that can be sent to this channel is limited, please wait to send another message.", new Object[]{channelName});
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
            BoxedUnit boxedUnit8 = boxedUnit;
        } else if (this.ChatNotify().CHAT_NOT_IN_AREA_NOTICE() == by) {
            BoxedUnit boxedUnit;
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("[{}] You are not in the correct area for this channel.", new Object[]{channelName});
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
            BoxedUnit boxedUnit9 = boxedUnit;
        } else if (this.ChatNotify().CHAT_NOT_IN_LFG_NOTICE() == by) {
            BoxedUnit boxedUnit;
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("[{}] You must be queued in looking for group before joining this channel.", new Object[]{channelName});
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
            BoxedUnit boxedUnit10 = boxedUnit;
        } else {
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        }
    }

    private void handle_SMSG_NOTIFICATION(Packet msg) {
        BoxedUnit boxedUnit;
        if (this.logger().underlying().isInfoEnabled()) {
            this.logger().underlying().info("Notification: {}", new Object[]{this.parseNotification(msg)});
            boxedUnit = BoxedUnit.UNIT;
        } else {
            boxedUnit = BoxedUnit.UNIT;
        }
    }

    public String parseNotification(Packet msg) {
        return msg.readString();
    }

    private void handle_SMSG_WHO(Packet msg) {
        String exactName;
        Seq<WhoResponse> displayResults = this.parseWhoResponse(msg);
        Option<WhoResponse> exactMatch = displayResults.find(arg_0 -> GamePacketHandler.$anonfun$handle_SMSG_WHO$1$adapted(exactName = CommandHandler$.MODULE$.whoRequest().playerName().toLowerCase(), arg_0));
        Iterable<String> handledResponses = CommandHandler$.MODULE$.handleWhoResponse(exactMatch, this.guildInfo(), this.guildRoster(), (Function1<GuildMember, Object> & Serializable & scala.Serializable)guildMember -> BoxesRunTime.boxToBoolean(GamePacketHandler.$anonfun$handle_SMSG_WHO$2(guildMember)));
        if (handledResponses.isEmpty()) {
            if (displayResults.isEmpty()) {
                Iterable<String> approximateMatches = CommandHandler$.MODULE$.handleWhoResponse(exactMatch, this.guildInfo(), this.guildRoster(), (Function1<GuildMember, Object> & Serializable & scala.Serializable)guildMember -> BoxesRunTime.boxToBoolean(GamePacketHandler.$anonfun$handle_SMSG_WHO$3(exactName, guildMember)));
                if (approximateMatches.isEmpty()) {
                    CommandHandler$.MODULE$.whoRequest().messageChannel().sendMessage(new StringBuilder(38).append("No player named ").append(CommandHandler$.MODULE$.whoRequest().playerName()).append(" is currently playing.").toString()).queue();
                } else {
                    ((IterableLike)approximateMatches.take(3)).foreach((Function1<String, Object> & Serializable & scala.Serializable)x$11 -> {
                        GamePacketHandler.$anonfun$handle_SMSG_WHO$4(x$11);
                        return BoxedUnit.UNIT;
                    });
                }
            } else {
                ((IterableLike)displayResults.take(3)).foreach((Function1<WhoResponse, Object> & Serializable & scala.Serializable)whoResponse -> {
                    GamePacketHandler.$anonfun$handle_SMSG_WHO$5(this, whoResponse);
                    return BoxedUnit.UNIT;
                });
            }
        } else {
            handledResponses.foreach((Function1<String, Object> & Serializable & scala.Serializable)x$13 -> {
                GamePacketHandler.$anonfun$handle_SMSG_WHO$8(x$13);
                return BoxedUnit.UNIT;
            });
        }
    }

    public Seq<WhoResponse> parseWhoResponse(Packet msg) {
        int displayCount = msg.byteBuf().readIntLE();
        int matchCount = msg.byteBuf().readIntLE();
        return displayCount == 0 ? (Seq)Nil$.MODULE$ : (Seq)RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), displayCount).map((Function1<Object, WhoResponse> & Serializable & scala.Serializable)i -> GamePacketHandler.$anonfun$parseWhoResponse$1(this, msg, BoxesRunTime.unboxToInt(i)), IndexedSeq$.MODULE$.canBuildFrom());
    }

    private void handle_SMSG_SERVER_MESSAGE(Packet msg) {
        int tp = msg.byteBuf().readIntLE();
        String txt = msg.readString();
        int n = tp;
        String string = this.ServerMessageType().SERVER_MSG_SHUTDOWN_TIME() == n ? new StringBuilder(12).append("Shutdown in ").append(txt).toString() : (this.ServerMessageType().SERVER_MSG_RESTART_TIME() == n ? new StringBuilder(11).append("Restart in ").append(txt).toString() : (this.ServerMessageType().SERVER_MSG_SHUTDOWN_CANCELLED() == n ? "Shutdown cancelled." : (this.ServerMessageType().SERVER_MSG_RESTART_CANCELLED() == n ? "Restart cancelled." : txt)));
        String message = string;
        this.sendChatMessage(new ChatMessage(0L, this.ChatEvents().CHAT_MSG_SYSTEM(), message, None$.MODULE$));
    }

    private void handle_SMSG_INVALIDATE_PLAYER(Packet msg) {
        long guid = this.parseInvalidatePlayer(msg);
        this.playerRoster().remove(BoxesRunTime.boxToLong(guid));
    }

    public long parseInvalidatePlayer(Packet msg) {
        return msg.byteBuf().readLongLE();
    }

    private void handle_SMSG_WARDEN_DATA(Packet msg) {
        block9: {
            BoxedUnit boxedUnit;
            Enumeration.Value value = Global$.MODULE$.config().wow().platform();
            Enumeration.Value value2 = Platform$.MODULE$.Windows();
            if (!(value != null ? !((Object)value).equals(value2) : value2 != null)) {
                BoxedUnit boxedUnit2;
                if (this.logger().underlying().isErrorEnabled()) {
                    this.logger().underlying().error("WARDEN ON WINDOWS IS NOT SUPPORTED! BOT WILL SOON DISCONNECT! TRY TO USE PLATFORM MAC!");
                    boxedUnit2 = BoxedUnit.UNIT;
                } else {
                    boxedUnit2 = BoxedUnit.UNIT;
                }
                return;
            }
            if (this.wardenHandler().isEmpty()) {
                this.wardenHandler_$eq(new Some<WardenHandler>(this.initializeWardenHandler()));
                if (this.logger().underlying().isInfoEnabled()) {
                    this.logger().underlying().info("Warden handling initialized!");
                    boxedUnit = BoxedUnit.UNIT;
                } else {
                    boxedUnit = BoxedUnit.UNIT;
                }
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
            Tuple2<Object, Option<ByteBuf>> tuple2 = this.wardenHandler().get().handle(msg);
            if (tuple2 == null) {
                throw new MatchError(tuple2);
            }
            int id = tuple2._1$mcI$sp();
            Option<ByteBuf> out = tuple2._2();
            Tuple2<Integer, Option<ByteBuf>> tuple22 = new Tuple2<Integer, Option<ByteBuf>>(BoxesRunTime.boxToInteger(id), out);
            Tuple2<Integer, Option<ByteBuf>> tuple23 = tuple22;
            int id2 = tuple23._1$mcI$sp();
            Option<ByteBuf> out2 = tuple23._2();
            if (!out2.isDefined()) break block9;
            ((ChannelOutboundInvoker)this.ctx().get()).writeAndFlush(new Packet(this.CMSG_WARDEN_DATA(), out2.get()));
            if (id2 == WardenPackets$.MODULE$.WARDEN_SMSG_HASH_REQUEST()) {
                this.sendCharEnum();
            }
        }
    }

    public WardenHandler initializeWardenHandler() {
        return new WardenHandler(this.sessionKey);
    }

    private final void ChatEvents$lzycompute$1() {
        GamePacketHandler gamePacketHandler = this;
        synchronized (gamePacketHandler) {
            if (this.ChatEvents$module == null) {
                this.ChatEvents$module = new GamePackets$ChatEvents$(this);
            }
        }
    }

    private final void GuildEvents$lzycompute$1() {
        GamePacketHandler gamePacketHandler = this;
        synchronized (gamePacketHandler) {
            if (this.GuildEvents$module == null) {
                this.GuildEvents$module = new GamePackets$GuildEvents$(this);
            }
        }
    }

    private final void Races$lzycompute$1() {
        GamePacketHandler gamePacketHandler = this;
        synchronized (gamePacketHandler) {
            if (this.Races$module == null) {
                this.Races$module = new GamePackets$Races$(this);
            }
        }
    }

    private final void Classes$lzycompute$1() {
        GamePacketHandler gamePacketHandler = this;
        synchronized (gamePacketHandler) {
            if (this.Classes$module == null) {
                this.Classes$module = new GamePackets$Classes$(this);
            }
        }
    }

    private final void Genders$lzycompute$1() {
        GamePacketHandler gamePacketHandler = this;
        synchronized (gamePacketHandler) {
            if (this.Genders$module == null) {
                this.Genders$module = new GamePackets$Genders$(this);
            }
        }
    }

    private final void AuthResponseCodes$lzycompute$1() {
        GamePacketHandler gamePacketHandler = this;
        synchronized (gamePacketHandler) {
            if (this.AuthResponseCodes$module == null) {
                this.AuthResponseCodes$module = new GamePackets$AuthResponseCodes$(this);
            }
        }
    }

    private final void ChatNotify$lzycompute$1() {
        GamePacketHandler gamePacketHandler = this;
        synchronized (gamePacketHandler) {
            if (this.ChatNotify$module == null) {
                this.ChatNotify$module = new GamePackets$ChatNotify$(this);
            }
        }
    }

    private final void ServerMessageType$lzycompute$1() {
        GamePacketHandler gamePacketHandler = this;
        synchronized (gamePacketHandler) {
            if (this.ServerMessageType$module == null) {
                this.ServerMessageType$module = new GamePackets$ServerMessageType$(this);
            }
        }
    }

    private final void ChatChannelIds$lzycompute$1() {
        GamePacketHandler gamePacketHandler = this;
        synchronized (gamePacketHandler) {
            if (this.ChatChannelIds$module == null) {
                this.ChatChannelIds$module = new GamePackets$ChatChannelIds$(this);
            }
        }
    }

    public static final /* synthetic */ byte $anonfun$addonInfo$1(int x$1) {
        return (byte)x$1;
    }

    public static final /* synthetic */ boolean $anonfun$buildGuildiesOnline$1(String characterName$1, GuildMember guildMember) {
        return guildMember.isOnline() && !guildMember.name().equalsIgnoreCase(characterName$1);
    }

    public static final /* synthetic */ boolean $anonfun$getGuildiesOnlineMessage$1(Tuple2 x$3) {
        return ((GuildMember)x$3._2()).isOnline();
    }

    public static final /* synthetic */ void $anonfun$handle_SMSG_NAME_QUERY$2(NameQueryMessage nameQueryMessage$1, ChatMessage message) {
        Global$.MODULE$.discord().sendMessageFromWow(new Some<String>(nameQueryMessage$1.name()), message.message(), message.tp(), message.channel());
    }

    public static final /* synthetic */ void $anonfun$handle_SMSG_CHAR_ENUM$2(GamePacketHandler $this, CharEnumMessage character) {
        BoxedUnit boxedUnit;
        if ($this.logger().underlying().isInfoEnabled()) {
            $this.logger().underlying().info("Logging in with character {}", new Object[]{character.name()});
            boxedUnit = BoxedUnit.UNIT;
        } else {
            boxedUnit = BoxedUnit.UNIT;
        }
        $this.selfCharacterId_$eq(new Some<Object>(BoxesRunTime.boxToLong(character.guid())));
        $this.languageId_$eq($this.Races().getLanguage(character.race()));
        $this.guildGuid_$eq(character.guildGuid());
        ByteBuf out = PooledByteBufAllocator.DEFAULT.buffer(16, 16);
        $this.writePlayerLogin(out);
        ((ChannelOutboundInvoker)$this.ctx().get()).writeAndFlush(new Packet($this.CMSG_PLAYER_LOGIN(), out));
    }

    public static final /* synthetic */ ByteBuf $anonfun$parseCharEnum$1(Packet msg$1, byte[] characterBytes$1, Object nonLocalReturnKey1$1, int i) {
        long guid = msg$1.byteBuf().readLongLE();
        String name = msg$1.readString();
        byte race = msg$1.byteBuf().readByte();
        msg$1.byteBuf().skipBytes(1);
        msg$1.byteBuf().skipBytes(1);
        msg$1.byteBuf().skipBytes(1);
        msg$1.byteBuf().skipBytes(1);
        msg$1.byteBuf().skipBytes(1);
        msg$1.byteBuf().skipBytes(1);
        msg$1.byteBuf().skipBytes(1);
        msg$1.byteBuf().skipBytes(1);
        msg$1.byteBuf().skipBytes(4);
        msg$1.byteBuf().skipBytes(4);
        msg$1.byteBuf().skipBytes(12);
        int guildGuid = msg$1.byteBuf().readIntLE();
        if (new ArrayOps.ofByte(Predef$.MODULE$.byteArrayOps(name.toLowerCase().getBytes("UTF-8"))).sameElements(Predef$.MODULE$.wrapByteArray(characterBytes$1))) {
            throw new NonLocalReturnControl<Some<CharEnumMessage>>(nonLocalReturnKey1$1, new Some<CharEnumMessage>(new CharEnumMessage(name, guid, race, guildGuid)));
        }
        msg$1.byteBuf().skipBytes(4);
        msg$1.byteBuf().skipBytes(1);
        msg$1.byteBuf().skipBytes(12);
        msg$1.byteBuf().skipBytes(95);
        return msg$1.byteBuf().skipBytes(5);
    }

    public static final /* synthetic */ boolean $anonfun$handleGuildQuery$2(Tuple2 x0$1) {
        Tuple2 tuple2 = x0$1;
        if (tuple2 == null) {
            throw new MatchError(tuple2);
        }
        String name = (String)tuple2._2();
        boolean bl = new StringOps(Predef$.MODULE$.augmentString(name)).nonEmpty();
        return bl;
    }

    public static final /* synthetic */ boolean $anonfun$handleGuildEvent$1(String x$7) {
        return x$7.trim().isEmpty();
    }

    public static final /* synthetic */ ByteBuf $anonfun$parseGuildRoster$1(Packet msg$4, int i) {
        return msg$4.byteBuf().skipBytes(4);
    }

    public static final /* synthetic */ Tuple2 $anonfun$parseGuildRoster$2(Packet msg$4, int i) {
        long guid = msg$4.byteBuf().readLongLE();
        boolean isOnline = msg$4.byteBuf().readBoolean();
        String name = msg$4.readString();
        msg$4.byteBuf().skipBytes(4);
        byte level = msg$4.byteBuf().readByte();
        byte charClass = msg$4.byteBuf().readByte();
        int zoneId = msg$4.byteBuf().readIntLE();
        float lastLogoff = !isOnline ? msg$4.byteBuf().readFloatLE() : 0.0f;
        msg$4.skipString();
        msg$4.skipString();
        return Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(BoxesRunTime.boxToLong(guid)), new GuildMember(name, isOnline, charClass, level, zoneId, lastLogoff));
    }

    public static final /* synthetic */ void $anonfun$sendChatMessage$4(ChatMessage chatMessage$1, Player name) {
        Global$.MODULE$.discord().sendMessageFromWow(new Some<String>(name.name()), chatMessage$1.message(), chatMessage$1.tp(), chatMessage$1.channel());
    }

    public static final /* synthetic */ boolean $anonfun$handle_SMSG_WHO$1(String exactName$1, WhoResponse x$10) {
        String string = x$10.playerName().toLowerCase();
        String string2 = exactName$1;
        return !(string != null ? !string.equals(string2) : string2 != null);
    }

    public static final /* synthetic */ boolean $anonfun$handle_SMSG_WHO$2(GuildMember guildMember) {
        return guildMember.name().equalsIgnoreCase(CommandHandler$.MODULE$.whoRequest().playerName());
    }

    public static final /* synthetic */ boolean $anonfun$handle_SMSG_WHO$3(String exactName$1, GuildMember guildMember) {
        return guildMember.name().toLowerCase().contains(exactName$1);
    }

    public static final /* synthetic */ void $anonfun$handle_SMSG_WHO$4(String x$11) {
        CommandHandler$.MODULE$.whoRequest().messageChannel().sendMessage(x$11).queue();
    }

    public static final /* synthetic */ boolean $anonfun$handle_SMSG_WHO$6(GuildMember guildMember) {
        return guildMember.name().equalsIgnoreCase(CommandHandler$.MODULE$.whoRequest().playerName());
    }

    public static final /* synthetic */ void $anonfun$handle_SMSG_WHO$7(String x$12) {
        CommandHandler$.MODULE$.whoRequest().messageChannel().sendMessage(x$12).queue();
    }

    public static final /* synthetic */ void $anonfun$handle_SMSG_WHO$5(GamePacketHandler $this, WhoResponse whoResponse) {
        CommandHandler$.MODULE$.handleWhoResponse(new Some<WhoResponse>(whoResponse), $this.guildInfo(), $this.guildRoster(), (Function1<GuildMember, Object> & Serializable & scala.Serializable)guildMember -> BoxesRunTime.boxToBoolean(GamePacketHandler.$anonfun$handle_SMSG_WHO$6(guildMember))).foreach((Function1<String, Object> & Serializable & scala.Serializable)x$12 -> {
            GamePacketHandler.$anonfun$handle_SMSG_WHO$7(x$12);
            return BoxedUnit.UNIT;
        });
    }

    public static final /* synthetic */ void $anonfun$handle_SMSG_WHO$8(String x$13) {
        CommandHandler$.MODULE$.whoRequest().messageChannel().sendMessage(x$13).queue();
    }

    public static final /* synthetic */ WhoResponse $anonfun$parseWhoResponse$1(GamePacketHandler $this, Packet msg$5, int i) {
        String playerName = msg$5.readString();
        String guildName = msg$5.readString();
        int lvl = msg$5.byteBuf().readIntLE();
        String cls = $this.Classes().valueOf((byte)msg$5.byteBuf().readIntLE());
        String race = $this.Races().valueOf((byte)msg$5.byteBuf().readIntLE());
        Enumeration.Value value = WowChatConfig$.MODULE$.getExpansion();
        Enumeration.Value value2 = WowExpansion$.MODULE$.Vanilla();
        None$ gender = (value == null ? value2 != null : !((Object)value).equals(value2)) ? new Some<String>($this.Genders().valueOf(msg$5.byteBuf().readByte())) : None$.MODULE$;
        int zone = msg$5.byteBuf().readIntLE();
        return new WhoResponse(playerName, guildName, lvl, cls, race, gender, (String)GameResources$.MODULE$.AREA().getOrElse(BoxesRunTime.boxToInteger(zone), (Function0<String> & Serializable & scala.Serializable)() -> "Unknown Zone"));
    }

    public GamePacketHandler(int realmId, String realmName, byte[] sessionKey, CommonConnectionCallback gameEventCallback) {
        this.realmName = realmName;
        this.sessionKey = sessionKey;
        this.gameEventCallback = gameEventCallback;
        GamePackets.$init$(this);
        StrictLogging.$init$(this);
        this.addonInfo = (byte[])new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(new int[]{86, 1, 0, 0, 120, 156, 117, 204, 189, 14, 194, 48, 12, 4, 224, 242, 30, 188, 12, 97, 64, 149, 200, 66, 195, 140, 76, 226, 34, 11, 199, 169, 140, 203, 79, 159, 30, 22, 36, 6, 115, 235, 119, 119, 129, 105, 89, 64, 203, 105, 51, 103, 163, 38, 199, 190, 91, 213, 199, 122, 223, 125, 18, 190, 22, 192, 140, 113, 36, 228, 18, 73, 168, 194, 228, 149, 72, 10, 201, 197, 61, 216, 182, 122, 6, 75, 248, 52, 15, 21, 70, 115, 103, 187, 56, 204, 122, 199, 151, 139, 189, 220, 38, 204, 254, 48, 66, 214, 230, 202, 1, 168, 184, 144, 128, 81, 252, 183, 164, 80, 112, 184, 18, 243, 63, 38, 65, 253, 181, 55, 144, 25, 102, 143})).map((Function1<Object, Object> & Serializable & scala.Serializable)x$1 -> BoxesRunTime.boxToByte(GamePacketHandler.$anonfun$addonInfo$1(BoxesRunTime.unboxToInt(x$1))), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Byte()));
        this.selfCharacterId = None$.MODULE$;
        this.inWorld = false;
        this.guildMotd = None$.MODULE$;
        this.ctx = None$.MODULE$;
        this.playerRoster = LRUMap$.MODULE$.empty();
        this.guildRoster = Map$.MODULE$.empty();
        this.executorService = Executors.newSingleThreadScheduledExecutor();
        this.queuedChatMessages = new HashMap();
        this.wardenHandler = None$.MODULE$;
        this.receivedCharEnum = false;
    }

    public static final /* synthetic */ Object $anonfun$handle_SMSG_WHO$1$adapted(String exactName$1, WhoResponse x$10) {
        return BoxesRunTime.boxToBoolean(GamePacketHandler.$anonfun$handle_SMSG_WHO$1(exactName$1, x$10));
    }
}

