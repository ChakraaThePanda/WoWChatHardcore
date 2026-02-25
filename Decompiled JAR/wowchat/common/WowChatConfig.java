/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import io.netty.util.AttributeKey;
import scala.Enumeration;
import scala.Equals;
import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.Tuple5;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;
import wowchat.common.ChannelConfig;
import wowchat.common.DiscordConfig;
import wowchat.common.FiltersConfig;
import wowchat.common.GuildConfig;
import wowchat.common.Wow;
import wowchat.common.WowChatConfig$;
import wowchat.game.GameHeaderCrypt;
import wowchat.game.GamePackets$AuthResponseCodes$;
import wowchat.game.GamePackets$ChatChannelIds$;
import wowchat.game.GamePackets$ChatEvents$;
import wowchat.game.GamePackets$ChatNotify$;
import wowchat.game.GamePackets$Classes$;
import wowchat.game.GamePackets$Genders$;
import wowchat.game.GamePackets$GuildEvents$;
import wowchat.game.GamePackets$Races$;
import wowchat.game.GamePackets$ServerMessageType$;

@ScalaSignature(bytes="\u0006\u0001\t\rg\u0001B\u001a5\u0001fB\u0001B\u0012\u0001\u0003\u0016\u0004%\ta\u0012\u0005\t\u0019\u0002\u0011\t\u0012)A\u0005\u0011\"AQ\n\u0001BK\u0002\u0013\u0005a\n\u0003\u0005S\u0001\tE\t\u0015!\u0003P\u0011!\u0019\u0006A!f\u0001\n\u0003!\u0006\u0002\u0003-\u0001\u0005#\u0005\u000b\u0011B+\t\u0011e\u0003!Q3A\u0005\u0002iC\u0001B\u001b\u0001\u0003\u0012\u0003\u0006Ia\u0017\u0005\tW\u0002\u0011)\u001a!C\u0001Y\"A1\u000f\u0001B\tB\u0003%Q\u000eC\u0003u\u0001\u0011\u0005Q\u000fC\u0004}\u0001\u0005\u0005I\u0011A?\t\u0013\u0005\u001d\u0001!%A\u0005\u0002\u0005%\u0001\"CA\u0010\u0001E\u0005I\u0011AA\u0011\u0011%\t)\u0003AI\u0001\n\u0003\t9\u0003C\u0005\u0002,\u0001\t\n\u0011\"\u0001\u0002.!I\u0011\u0011\u0007\u0001\u0012\u0002\u0013\u0005\u00111\u0007\u0005\n\u0003o\u0001\u0011\u0011!C!\u0003sA\u0011\"a\u0013\u0001\u0003\u0003%\t!!\u0014\t\u0013\u0005U\u0003!!A\u0005\u0002\u0005]\u0003\"CA2\u0001\u0005\u0005I\u0011IA3\u0011%\t\u0019\bAA\u0001\n\u0003\t)\bC\u0005\u0002\u0000\u0001\t\t\u0011\"\u0011\u0002\u0002\"I\u00111\u0011\u0001\u0002\u0002\u0013\u0005\u0013Q\u0011\u0005\n\u0003\u000f\u0003\u0011\u0011!C!\u0003\u0013;q!!$5\u0011\u0003\tyI\u0002\u00044i!\u0005\u0011\u0011\u0013\u0005\u0007in!\t!a(\t\u0017\u0005\u00056\u00041AA\u0002\u0013%\u00111\u0015\u0005\f\u0003g[\u0002\u0019!a\u0001\n\u0013\t)\fC\u0006\u0002@n\u0001\r\u0011!Q!\n\u0005\u0015\u0006bCAa7\u0001\u0007\t\u0019!C\u0005\u0003\u0007D1\"a7\u001c\u0001\u0004\u0005\r\u0011\"\u0003\u0002^\"Y\u0011\u0011]\u000eA\u0002\u0003\u0005\u000b\u0015BAc\u0011\u001d\t\u0019o\u0007C\u0001\u0003KD!\"a;\u001c\u0011\u000b\u0007I\u0011AAR\u0011)\tio\u0007EC\u0002\u0013\u0005\u00111\u0019\u0005\u000b\u0003_\\\u0002R1A\u0005\n\u00055\u0003BCAy7!\u0015\r\u0011\"\u0001\u0002N!Q\u00111_\u000e\t\u0006\u0004%\t!!\u0014\t\u000f\u0005U8\u0004\"\u0003\u0002x\"9!\u0011B\u000e\u0005\n\t-\u0001b\u0002B\u00167\u0011%!Q\u0006\u0005\b\u0005kYB\u0011\u0002B\u001c\u0011\u001d\u0011id\u0007C\u0005\u0005\u007fAqA!\u0012\u001c\t\u0013\u00119\u0005C\u0004\u0003Rm!IAa\u0015\t\u0013\u0005\r8$!A\u0005\u0002\nu\u0005\"\u0003BU7\u0005\u0005I\u0011\u0011BV\u0011%\u0011IlGA\u0001\n\u0013\u0011YLA\u0007X_^\u001c\u0005.\u0019;D_:4\u0017n\u001a\u0006\u0003kY\naaY8n[>t'\"A\u001c\u0002\u000f]|wo\u00195bi\u000e\u00011\u0003\u0002\u0001;\u0001\u000e\u0003\"a\u000f \u000e\u0003qR\u0011!P\u0001\u0006g\u000e\fG.Y\u0005\u0003\u007fq\u0012a!\u00118z%\u00164\u0007CA\u001eB\u0013\t\u0011EHA\u0004Qe>$Wo\u0019;\u0011\u0005m\"\u0015BA#=\u00051\u0019VM]5bY&T\u0018M\u00197f\u0003\u001d!\u0017n]2pe\u0012,\u0012\u0001\u0013\t\u0003\u0013*k\u0011\u0001N\u0005\u0003\u0017R\u0012Q\u0002R5tG>\u0014HmQ8oM&<\u0017\u0001\u00033jg\u000e|'\u000f\u001a\u0011\u0002\u0007]|w/F\u0001P!\tI\u0005+\u0003\u0002Ri\t\u0019qk\\<\u0002\t]|w\u000fI\u0001\fOVLG\u000eZ\"p]\u001aLw-F\u0001V!\tIe+\u0003\u0002Xi\tYq)^5mI\u000e{gNZ5h\u000319W/\u001b7e\u0007>tg-[4!\u0003!\u0019\u0007.\u00198oK2\u001cX#A.\u0011\u0007q#wM\u0004\u0002^E:\u0011a,Y\u0007\u0002?*\u0011\u0001\rO\u0001\u0007yI|w\u000e\u001e \n\u0003uJ!a\u0019\u001f\u0002\u000fA\f7m[1hK&\u0011QM\u001a\u0002\u0004'\u0016\f(BA2=!\tI\u0005.\u0003\u0002ji\ti1\t[1o]\u0016d7i\u001c8gS\u001e\f\u0011b\u00195b]:,Gn\u001d\u0011\u0002\u000f\u0019LG\u000e^3sgV\tQ\u000eE\u0002<]BL!a\u001c\u001f\u0003\r=\u0003H/[8o!\tI\u0015/\u0003\u0002si\tia)\u001b7uKJ\u001c8i\u001c8gS\u001e\f\u0001BZ5mi\u0016\u00148\u000fI\u0001\u0007y%t\u0017\u000e\u001e \u0015\rY<\b0\u001f>|!\tI\u0005\u0001C\u0003G\u0017\u0001\u0007\u0001\nC\u0003N\u0017\u0001\u0007q\nC\u0003T\u0017\u0001\u0007Q\u000bC\u0003Z\u0017\u0001\u00071\fC\u0003l\u0017\u0001\u0007Q.\u0001\u0003d_BLH#\u0003<\u007f\u007f\u0006\u0005\u00111AA\u0003\u0011\u001d1E\u0002%AA\u0002!Cq!\u0014\u0007\u0011\u0002\u0003\u0007q\nC\u0004T\u0019A\u0005\t\u0019A+\t\u000fec\u0001\u0013!a\u00017\"91\u000e\u0004I\u0001\u0002\u0004i\u0017AD2paf$C-\u001a4bk2$H%M\u000b\u0003\u0003\u0017Q3\u0001SA\u0007W\t\ty\u0001\u0005\u0003\u0002\u0012\u0005mQBAA\n\u0015\u0011\t)\"a\u0006\u0002\u0013Ut7\r[3dW\u0016$'bAA\ry\u0005Q\u0011M\u001c8pi\u0006$\u0018n\u001c8\n\t\u0005u\u00111\u0003\u0002\u0012k:\u001c\u0007.Z2lK\u00124\u0016M]5b]\u000e,\u0017AD2paf$C-\u001a4bk2$HEM\u000b\u0003\u0003GQ3aTA\u0007\u00039\u0019w\u000e]=%I\u00164\u0017-\u001e7uIM*\"!!\u000b+\u0007U\u000bi!\u0001\bd_BLH\u0005Z3gCVdG\u000f\n\u001b\u0016\u0005\u0005=\"fA.\u0002\u000e\u0005q1m\u001c9zI\u0011,g-Y;mi\u0012*TCAA\u001bU\ri\u0017QB\u0001\u000eaJ|G-^2u!J,g-\u001b=\u0016\u0005\u0005m\u0002\u0003BA\u001f\u0003\u000fj!!a\u0010\u000b\t\u0005\u0005\u00131I\u0001\u0005Y\u0006twM\u0003\u0002\u0002F\u0005!!.\u0019<b\u0013\u0011\tI%a\u0010\u0003\rM#(/\u001b8h\u00031\u0001(o\u001c3vGR\f%/\u001b;z+\t\ty\u0005E\u0002<\u0003#J1!a\u0015=\u0005\rIe\u000e^\u0001\u000faJ|G-^2u\u000b2,W.\u001a8u)\u0011\tI&a\u0018\u0011\u0007m\nY&C\u0002\u0002^q\u00121!\u00118z\u0011%\t\t\u0007FA\u0001\u0002\u0004\ty%A\u0002yIE\nq\u0002\u001d:pIV\u001cG/\u0013;fe\u0006$xN]\u000b\u0003\u0003O\u0002b!!\u001b\u0002p\u0005eSBAA6\u0015\r\ti\u0007P\u0001\u000bG>dG.Z2uS>t\u0017\u0002BA9\u0003W\u0012\u0001\"\u0013;fe\u0006$xN]\u0001\tG\u0006tW)];bYR!\u0011qOA?!\rY\u0014\u0011P\u0005\u0004\u0003wb$a\u0002\"p_2,\u0017M\u001c\u0005\n\u0003C2\u0012\u0011!a\u0001\u00033\n\u0001\u0002[1tQ\u000e{G-\u001a\u000b\u0003\u0003\u001f\n\u0001\u0002^8TiJLgn\u001a\u000b\u0003\u0003w\ta!Z9vC2\u001cH\u0003BA<\u0003\u0017C\u0011\"!\u0019\u001a\u0003\u0003\u0005\r!!\u0017\u0002\u001b]{wo\u00115bi\u000e{gNZ5h!\tI5dE\u0003\u001cu\u0005M5\t\u0005\u0003\u0002\u0016\u0006mUBAAL\u0015\r\tIJN\u0001\u0005O\u0006lW-\u0003\u0003\u0002\u001e\u0006]%aC$b[\u0016\u0004\u0016mY6fiN$\"!a$\u0002\u000fY,'o]5p]V\u0011\u0011Q\u0015\t\u0005\u0003O\u000byK\u0004\u0003\u0002*\u0006-\u0006C\u00010=\u0013\r\ti\u000bP\u0001\u0007!J,G-\u001a4\n\t\u0005%\u0013\u0011\u0017\u0006\u0004\u0003[c\u0014a\u0003<feNLwN\\0%KF$B!a.\u0002>B\u00191(!/\n\u0007\u0005mFH\u0001\u0003V]&$\b\"CA1=\u0005\u0005\t\u0019AAS\u0003!1XM]:j_:\u0004\u0013!C3ya\u0006t7/[8o+\t\t)\r\u0005\u0003\u0002H\u0006Ug\u0002BAe\u0003#tA!a3\u0002P:\u0019a,!4\n\u0003]J!!\u000e\u001c\n\u0007\u0005MG'\u0001\u0007X_^,\u0005\u0010]1og&|g.\u0003\u0003\u0002X\u0006e'\u0001D,po\u0016C\b/\u00198tS>t'bAAji\u0005iQ\r\u001f9b]NLwN\\0%KF$B!a.\u0002`\"I\u0011\u0011M\u0011\u0002\u0002\u0003\u0007\u0011QY\u0001\u000bKb\u0004\u0018M\\:j_:\u0004\u0013!B1qa2LHc\u0001<\u0002h\"9\u0011\u0011^\u0012A\u0002\u0005\u0015\u0016\u0001C2p]\u001a4\u0015\u000e\\3\u0002\u0015\u001d,GOV3sg&|g.\u0001\u0007hKR,\u0005\u0010]1og&|g.\u0001\tck&dGM\u0012:p[Z+'o]5p]\u0006iq-\u001a;SK\u0006dWNQ;jY\u0012\fAbZ3u\u000f\u0006lWMQ;jY\u0012\fabY8om\u0016\u0014H\u000fV8VaB,'\u000f\u0006\u0003\u0002z\n\u0015\u0001#B\u001e\u0002|\u0006}\u0018bAA\u007fy\t)\u0011I\u001d:bsB\u00191H!\u0001\n\u0007\t\rAH\u0001\u0003CsR,\u0007b\u0002B\u0004S\u0001\u0007\u0011QU\u0001\bC\u000e\u001cw.\u001e8u\u00039\u0001\u0018M]:f%\u0016\fG.\u001c7jgR$BA!\u0004\u0003\u0014A\u0019\u0011Ja\u0004\n\u0007\tEAGA\bSK\u0006dW\u000eT5ti\u000e{gNZ5h\u0011\u001d\u0011)B\u000ba\u0001\u0005/\tqa^8x\u0007>tg\r\u0005\u0003\u0003\u001a\t\u001dRB\u0001B\u000e\u0015\u0011\u0011iBa\b\u0002\r\r|gNZ5h\u0015\u0011\u0011\tCa\t\u0002\u0011QL\b/Z:bM\u0016T!A!\n\u0002\u0007\r|W.\u0003\u0003\u0003*\tm!AB\"p]\u001aLw-\u0001\tqCJ\u001cXmR;jY\u0012\u001cuN\u001c4jOR\u0019QKa\f\t\u000f\tE2\u00061\u0001\u00034\u0005Iq-^5mI\u000e{gN\u001a\t\u0005w9\u00149\"A\u0007qCJ\u001cXm\u00115b]:,Gn\u001d\u000b\u00047\ne\u0002b\u0002B\u001eY\u0001\u0007!qC\u0001\rG\"\fgN\\3mg\u000e{gNZ\u0001\ra\u0006\u00148/\u001a$jYR,'o\u001d\u000b\u0004[\n\u0005\u0003b\u0002B\"[\u0001\u0007!1G\u0001\fM&dG/\u001a:t\u0007>tg-\u0001\u0007hKR\u001cuN\u001c4jO>\u0003H\u000f\u0006\u0004\u00034\t%#Q\n\u0005\b\u0005\u0017r\u0003\u0019\u0001B\f\u0003\r\u0019gm\u001a\u0005\b\u0005\u001fr\u0003\u0019AAS\u0003\u0011\u0001\u0018\r\u001e5\u0002\r\u001d,Go\u00149u+\u0011\u0011)Fa\u0018\u0015\r\t]#\u0011\u0014BN)\u0011\u0011IFa\u001b\u0011\tmr'1\f\t\u0005\u0005;\u0012y\u0006\u0004\u0001\u0005\u000f\t\u0005tF1\u0001\u0003d\t\tA+\u0005\u0003\u0003f\u0005e\u0003cA\u001e\u0003h%\u0019!\u0011\u000e\u001f\u0003\u000f9{G\u000f[5oO\"I!QN\u0018\u0002\u0002\u0003\u000f!qN\u0001\u000bKZLG-\u001a8dK\u0012\n\u0004C\u0002B9\u0005\u001b\u0013YF\u0004\u0003\u0003t\t\u001de\u0002\u0002B;\u0005\u0007sAAa\u001e\u0003~9\u0019QL!\u001f\n\u0007\tmD(A\u0004sK\u001adWm\u0019;\n\t\t}$\u0011Q\u0001\beVtG/[7f\u0015\r\u0011Y\bP\u0005\u0004G\n\u0015%\u0002\u0002B@\u0005\u0003KAA!#\u0003\f\u0006AQO\\5wKJ\u001cXMC\u0002d\u0005\u000bKAAa$\u0003\u0012\n9A+\u001f9f)\u0006<\u0017\u0002\u0002BJ\u0005+\u0013\u0001\u0002V=qKR\u000bwm\u001d\u0006\u0005\u0005/\u0013\t)A\u0002ba&DqAa\u00130\u0001\u0004\u00119\u0002C\u0004\u0003P=\u0002\r!!*\u0015\u0017Y\u0014yJ!)\u0003$\n\u0015&q\u0015\u0005\u0006\rB\u0002\r\u0001\u0013\u0005\u0006\u001bB\u0002\ra\u0014\u0005\u0006'B\u0002\r!\u0016\u0005\u00063B\u0002\ra\u0017\u0005\u0006WB\u0002\r!\\\u0001\bk:\f\u0007\u000f\u001d7z)\u0011\u0011iK!.\u0011\tmr'q\u0016\t\tw\tE\u0006jT+\\[&\u0019!1\u0017\u001f\u0003\rQ+\b\u000f\\36\u0011!\u00119,MA\u0001\u0002\u00041\u0018a\u0001=%a\u0005Y!/Z1e%\u0016\u001cx\u000e\u001c<f)\t\u0011i\f\u0005\u0003\u0002>\t}\u0016\u0002\u0002Ba\u0003\u007f\u0011aa\u00142kK\u000e$\b")
public class WowChatConfig
implements Product,
Serializable {
    private final DiscordConfig discord;
    private final Wow wow;
    private final GuildConfig guildConfig;
    private final Seq<ChannelConfig> channels;
    private final Option<FiltersConfig> filters;

    public static Option<Tuple5<DiscordConfig, Wow, GuildConfig, Seq<ChannelConfig>, Option<FiltersConfig>>> unapply(WowChatConfig wowChatConfig) {
        return WowChatConfig$.MODULE$.unapply(wowChatConfig);
    }

    public static WowChatConfig apply(DiscordConfig discordConfig, Wow wow, GuildConfig guildConfig, Seq<ChannelConfig> seq, Option<FiltersConfig> option) {
        return WowChatConfig$.MODULE$.apply(discordConfig, wow, guildConfig, seq, option);
    }

    public static int getGameBuild() {
        return WowChatConfig$.MODULE$.getGameBuild();
    }

    public static int getRealmBuild() {
        return WowChatConfig$.MODULE$.getRealmBuild();
    }

    public static Enumeration.Value getExpansion() {
        return WowChatConfig$.MODULE$.getExpansion();
    }

    public static String getVersion() {
        return WowChatConfig$.MODULE$.getVersion();
    }

    public static WowChatConfig apply(String string) {
        return WowChatConfig$.MODULE$.apply(string);
    }

    public static GamePackets$ChatChannelIds$ ChatChannelIds() {
        return WowChatConfig$.MODULE$.ChatChannelIds();
    }

    public static GamePackets$ServerMessageType$ ServerMessageType() {
        return WowChatConfig$.MODULE$.ServerMessageType();
    }

    public static GamePackets$ChatNotify$ ChatNotify() {
        return WowChatConfig$.MODULE$.ChatNotify();
    }

    public static GamePackets$AuthResponseCodes$ AuthResponseCodes() {
        return WowChatConfig$.MODULE$.AuthResponseCodes();
    }

    public static GamePackets$Genders$ Genders() {
        return WowChatConfig$.MODULE$.Genders();
    }

    public static GamePackets$Classes$ Classes() {
        return WowChatConfig$.MODULE$.Classes();
    }

    public static GamePackets$Races$ Races() {
        return WowChatConfig$.MODULE$.Races();
    }

    public static GamePackets$GuildEvents$ GuildEvents() {
        return WowChatConfig$.MODULE$.GuildEvents();
    }

    public static GamePackets$ChatEvents$ ChatEvents() {
        return WowChatConfig$.MODULE$.ChatEvents();
    }

    public static int CMSG_TIME_SYNC_RESP() {
        return WowChatConfig$.MODULE$.CMSG_TIME_SYNC_RESP();
    }

    public static int SMSG_TIME_SYNC_REQ() {
        return WowChatConfig$.MODULE$.SMSG_TIME_SYNC_REQ();
    }

    public static int SMSG_INVALIDATE_PLAYER() {
        return WowChatConfig$.MODULE$.SMSG_INVALIDATE_PLAYER();
    }

    public static int CMSG_WARDEN_DATA() {
        return WowChatConfig$.MODULE$.CMSG_WARDEN_DATA();
    }

    public static int SMSG_WARDEN_DATA() {
        return WowChatConfig$.MODULE$.SMSG_WARDEN_DATA();
    }

    public static int SMSG_SERVER_MESSAGE() {
        return WowChatConfig$.MODULE$.SMSG_SERVER_MESSAGE();
    }

    public static int SMSG_LOGIN_VERIFY_WORLD() {
        return WowChatConfig$.MODULE$.SMSG_LOGIN_VERIFY_WORLD();
    }

    public static int SMSG_AUTH_RESPONSE() {
        return WowChatConfig$.MODULE$.SMSG_AUTH_RESPONSE();
    }

    public static int CMSG_AUTH_CHALLENGE() {
        return WowChatConfig$.MODULE$.CMSG_AUTH_CHALLENGE();
    }

    public static int SMSG_AUTH_CHALLENGE() {
        return WowChatConfig$.MODULE$.SMSG_AUTH_CHALLENGE();
    }

    public static int CMSG_PING() {
        return WowChatConfig$.MODULE$.CMSG_PING();
    }

    public static int SMSG_NOTIFICATION() {
        return WowChatConfig$.MODULE$.SMSG_NOTIFICATION();
    }

    public static int SMSG_CHANNEL_NOTIFY() {
        return WowChatConfig$.MODULE$.SMSG_CHANNEL_NOTIFY();
    }

    public static int CMSG_JOIN_CHANNEL() {
        return WowChatConfig$.MODULE$.CMSG_JOIN_CHANNEL();
    }

    public static int SMSG_MESSAGECHAT() {
        return WowChatConfig$.MODULE$.SMSG_MESSAGECHAT();
    }

    public static int CMSG_MESSAGECHAT() {
        return WowChatConfig$.MODULE$.CMSG_MESSAGECHAT();
    }

    public static int SMSG_GUILD_EVENT() {
        return WowChatConfig$.MODULE$.SMSG_GUILD_EVENT();
    }

    public static int SMSG_GUILD_ROSTER() {
        return WowChatConfig$.MODULE$.SMSG_GUILD_ROSTER();
    }

    public static int CMSG_GUILD_ROSTER() {
        return WowChatConfig$.MODULE$.CMSG_GUILD_ROSTER();
    }

    public static int SMSG_WHO() {
        return WowChatConfig$.MODULE$.SMSG_WHO();
    }

    public static int CMSG_WHO() {
        return WowChatConfig$.MODULE$.CMSG_WHO();
    }

    public static int SMSG_GUILD_QUERY() {
        return WowChatConfig$.MODULE$.SMSG_GUILD_QUERY();
    }

    public static int CMSG_GUILD_QUERY() {
        return WowChatConfig$.MODULE$.CMSG_GUILD_QUERY();
    }

    public static int SMSG_NAME_QUERY() {
        return WowChatConfig$.MODULE$.SMSG_NAME_QUERY();
    }

    public static int CMSG_NAME_QUERY() {
        return WowChatConfig$.MODULE$.CMSG_NAME_QUERY();
    }

    public static int CMSG_LOGOUT_REQUEST() {
        return WowChatConfig$.MODULE$.CMSG_LOGOUT_REQUEST();
    }

    public static int CMSG_PLAYER_LOGIN() {
        return WowChatConfig$.MODULE$.CMSG_PLAYER_LOGIN();
    }

    public static int SMSG_CHAR_ENUM() {
        return WowChatConfig$.MODULE$.SMSG_CHAR_ENUM();
    }

    public static int CMSG_CHAR_ENUM() {
        return WowChatConfig$.MODULE$.CMSG_CHAR_ENUM();
    }

    public static AttributeKey<GameHeaderCrypt> CRYPT() {
        return WowChatConfig$.MODULE$.CRYPT();
    }

    public DiscordConfig discord() {
        return this.discord;
    }

    public Wow wow() {
        return this.wow;
    }

    public GuildConfig guildConfig() {
        return this.guildConfig;
    }

    public Seq<ChannelConfig> channels() {
        return this.channels;
    }

    public Option<FiltersConfig> filters() {
        return this.filters;
    }

    public WowChatConfig copy(DiscordConfig discord, Wow wow, GuildConfig guildConfig, Seq<ChannelConfig> channels, Option<FiltersConfig> filters) {
        return new WowChatConfig(discord, wow, guildConfig, channels, filters);
    }

    public DiscordConfig copy$default$1() {
        return this.discord();
    }

    public Wow copy$default$2() {
        return this.wow();
    }

    public GuildConfig copy$default$3() {
        return this.guildConfig();
    }

    public Seq<ChannelConfig> copy$default$4() {
        return this.channels();
    }

    public Option<FiltersConfig> copy$default$5() {
        return this.filters();
    }

    @Override
    public String productPrefix() {
        return "WowChatConfig";
    }

    @Override
    public int productArity() {
        return 5;
    }

    @Override
    public Object productElement(int x$1) {
        Equals equals;
        int n = x$1;
        switch (n) {
            case 0: {
                equals = this.discord();
                break;
            }
            case 1: {
                equals = this.wow();
                break;
            }
            case 2: {
                equals = this.guildConfig();
                break;
            }
            case 3: {
                equals = this.channels();
                break;
            }
            case 4: {
                equals = this.filters();
                break;
            }
            default: {
                throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(x$1)).toString());
            }
        }
        return equals;
    }

    @Override
    public Iterator<Object> productIterator() {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    @Override
    public boolean canEqual(Object x$1) {
        return x$1 instanceof WowChatConfig;
    }

    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode(this);
    }

    public String toString() {
        return ScalaRunTime$.MODULE$._toString(this);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean equals(Object x$1) {
        if (this == x$1) return true;
        Object object = x$1;
        if (!(object instanceof WowChatConfig)) return false;
        boolean bl = true;
        if (!bl) return false;
        WowChatConfig wowChatConfig = (WowChatConfig)x$1;
        DiscordConfig discordConfig = this.discord();
        DiscordConfig discordConfig2 = wowChatConfig.discord();
        if (discordConfig == null) {
            if (discordConfig2 != null) {
                return false;
            }
        } else if (!((Object)discordConfig).equals(discordConfig2)) return false;
        Wow wow = this.wow();
        Wow wow2 = wowChatConfig.wow();
        if (wow == null) {
            if (wow2 != null) {
                return false;
            }
        } else if (!((Object)wow).equals(wow2)) return false;
        GuildConfig guildConfig = this.guildConfig();
        GuildConfig guildConfig2 = wowChatConfig.guildConfig();
        if (guildConfig == null) {
            if (guildConfig2 != null) {
                return false;
            }
        } else if (!((Object)guildConfig).equals(guildConfig2)) return false;
        Seq<ChannelConfig> seq = this.channels();
        Seq<ChannelConfig> seq2 = wowChatConfig.channels();
        if (seq == null) {
            if (seq2 != null) {
                return false;
            }
        } else if (!seq.equals(seq2)) return false;
        Option<FiltersConfig> option = this.filters();
        Option<FiltersConfig> option2 = wowChatConfig.filters();
        if (option == null) {
            if (option2 != null) {
                return false;
            }
        } else if (!option.equals(option2)) return false;
        if (!wowChatConfig.canEqual(this)) return false;
        return true;
    }

    public WowChatConfig(DiscordConfig discord, Wow wow, GuildConfig guildConfig, Seq<ChannelConfig> channels, Option<FiltersConfig> filters) {
        this.discord = discord;
        this.wow = wow;
        this.guildConfig = guildConfig;
        this.channels = channels;
        this.filters = filters;
        Product.$init$(this);
    }
}

