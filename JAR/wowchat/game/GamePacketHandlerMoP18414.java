/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import scala.Array$;
import scala.Function0;
import scala.Function1;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Predef$ArrowAssoc$;
import scala.Some;
import scala.Tuple2;
import scala.collection.Seq;
import scala.collection.TraversableOnce;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.IndexedSeq$;
import scala.collection.immutable.Map;
import scala.collection.immutable.Nil$;
import scala.collection.mutable.ArrayOps;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.NonLocalReturnControl;
import scala.runtime.RichInt$;
import scala.runtime.java8.JFunction1$mcII$sp;
import scala.runtime.java8.JFunction1$mcVI$sp;
import scala.util.Random$;
import wowchat.commands.WhoResponse;
import wowchat.common.ByteUtils$;
import wowchat.common.CommonConnectionCallback;
import wowchat.common.Global$;
import wowchat.common.Packet;
import wowchat.common.WowChatConfig$;
import wowchat.game.AuthChallengeMessage;
import wowchat.game.CharEnumMessage;
import wowchat.game.ChatMessage;
import wowchat.game.GamePacketHandlerCataclysm15595;
import wowchat.game.GamePacketsMoP18414;
import wowchat.game.GameResources$;
import wowchat.game.GuildInfo;
import wowchat.game.GuildMember;
import wowchat.game.NameQueryMessage;
import wowchat.game.warden.WardenHandler;
import wowchat.game.warden.WardenHandlerMoP18414;

@ScalaSignature(bytes="\u0006\u0001\u0005}g\u0001\u0002\u0011\"\u0001\u0019B\u0001B\f\u0001\u0003\u0002\u0003\u0006Ia\f\u0005\tk\u0001\u0011\t\u0011)A\u0005m!A\u0011\t\u0001B\u0001B\u0003%!\t\u0003\u0005I\u0001\t\u0005\t\u0015!\u0003J\u0011\u0015y\u0005\u0001\"\u0001Q\u0011\u001d1\u0006A1A\u0005R]Ca\u0001\u0017\u0001!\u0002\u0013\u0011\u0005\"B-\u0001\t#R\u0006\"B2\u0001\t\u0003\"\u0007\"\u00028\u0001\t\u0003z\u0007\"B;\u0001\t#2\b\"B>\u0001\t#b\b\"\u0002@\u0001\t#z\bbBA\r\u0001\u0011E\u00131\u0004\u0005\b\u0003{\u0001A\u0011KA \u0011\u001d\tI\u0005\u0001C)\u0003\u0017Bq!a\u0014\u0001\t#\n\t\u0006C\u0004\u0002^\u0001!\t&a\u0018\t\u000f\u0005\u0015\u0004\u0001\"\u0015\u0002h!9\u00111\u000f\u0001\u0005R\u0005U\u0004bBA<\u0001\u0011E\u0013\u0011\u0010\u0005\b\u0003\u0007\u0003A\u0011KAC\u0011\u001d\t\t\n\u0001C)\u0003'Cq!!'\u0001\t#\nY\nC\u0004\u0002,\u0002!\t&!,\t\u000f\u0005E\u0006\u0001\"\u0015\u00024\"9\u0011\u0011\u0019\u0001\u0005\n\u0005\r\u0007bBAd\u0001\u0011%\u0011\u0011\u001a\u0005\b\u0003\u001b\u0004A\u0011BAh\u0011\u001d\t\u0019\u000e\u0001C\u0005\u0003+Dq!!7\u0001\t\u0013\tYNA\rHC6,\u0007+Y2lKRD\u0015M\u001c3mKJlu\u000eU\u00199iE\"$B\u0001\u0012$\u0003\u00119\u0017-\\3\u000b\u0003\u0011\nqa^8xG\"\fGo\u0001\u0001\u0014\u0007\u000193\u0006\u0005\u0002)S5\t\u0011%\u0003\u0002+C\tyr)Y7f!\u0006\u001c7.\u001a;IC:$G.\u001a:DCR\f7\r\\=t[F*T'O\u001b\u0011\u0005!b\u0013BA\u0017\"\u0005M9\u0015-\\3QC\u000e\\W\r^:N_B\u000b\u0004\bN\u00195\u0003\u001d\u0011X-\u00197n\u0013\u0012\u0004\"\u0001M\u001a\u000e\u0003ER\u0011AM\u0001\u0006g\u000e\fG.Y\u0005\u0003iE\u00121!\u00138u\u0003%\u0011X-\u00197n\u001d\u0006lW\r\u0005\u00028}9\u0011\u0001\b\u0010\t\u0003sEj\u0011A\u000f\u0006\u0003w\u0015\na\u0001\u0010:p_Rt\u0014BA\u001f2\u0003\u0019\u0001&/\u001a3fM&\u0011q\b\u0011\u0002\u0007'R\u0014\u0018N\\4\u000b\u0005u\n\u0014AC:fgNLwN\\&fsB\u0019\u0001gQ#\n\u0005\u0011\u000b$!B!se\u0006L\bC\u0001\u0019G\u0013\t9\u0015G\u0001\u0003CsR,\u0017!E4b[\u0016,e/\u001a8u\u0007\u0006dGNY1dWB\u0011!*T\u0007\u0002\u0017*\u0011AjI\u0001\u0007G>lWn\u001c8\n\u00059[%\u0001G\"p[6|gnQ8o]\u0016\u001cG/[8o\u0007\u0006dGNY1dW\u00061A(\u001b8jiz\"R!\u0015*T)V\u0003\"\u0001\u000b\u0001\t\u000b9*\u0001\u0019A\u0018\t\u000bU*\u0001\u0019\u0001\u001c\t\u000b\u0005+\u0001\u0019\u0001\"\t\u000b!+\u0001\u0019A%\u0002\u0013\u0005$Gm\u001c8J]\u001a|W#\u0001\"\u0002\u0015\u0005$Gm\u001c8J]\u001a|\u0007%\u0001\u0007dQ\u0006tg.\u001a7QCJ\u001cX\r\u0006\u0002\\=B\u0011\u0001\u0007X\u0005\u0003;F\u0012A!\u00168ji\")q\f\u0003a\u0001A\u0006\u0019Qn]4\u0011\u0005)\u000b\u0017B\u00012L\u0005\u0019\u0001\u0016mY6fi\u0006\u0001\"-^5mI\u000eC\u0017\r^'fgN\fw-\u001a\u000b\u0005A\u0016<\u0017\u000eC\u0003g\u0013\u0001\u0007Q)\u0001\u0002ua\")\u0001.\u0003a\u0001\u0005\u0006\u0001R\u000f\u001e49\u001b\u0016\u001c8/Y4f\u0005f$Xm\u001d\u0005\u0006U&\u0001\ra[\u0001\u0010kR4\u0007\bV1sO\u0016$()\u001f;fgB\u0019\u0001\u0007\u001c\"\n\u00055\f$AB(qi&|g.A\u0007tK:$g*Y7f#V,'/\u001f\u000b\u00037BDQ!\u001d\u0006A\u0002I\fAaZ;jIB\u0011\u0001g]\u0005\u0003iF\u0012A\u0001T8oO\u0006q\u0001/\u0019:tK:\u000bW.Z)vKJLHCA<{!\tA\u00030\u0003\u0002zC\t\u0001b*Y7f#V,'/_'fgN\fw-\u001a\u0005\u0006?.\u0001\r\u0001Y\u0001\u0016a\u0006\u00148/Z%om\u0006d\u0017\u000eZ1uKBc\u0017-_3s)\t\u0011X\u0010C\u0003`\u0019\u0001\u0007\u0001-A\bck&dGm\u00165p\u001b\u0016\u001c8/Y4f)\u0011\t\t!!\u0006\u0011\t\u0005\r\u0011\u0011C\u0007\u0003\u0003\u000bQA!a\u0002\u0002\n\u00051!-\u001e4gKJTA!a\u0003\u0002\u000e\u0005)a.\u001a;us*\u0011\u0011qB\u0001\u0003S>LA!a\u0005\u0002\u0006\t9!)\u001f;f\u0005V4\u0007BBA\f\u001b\u0001\u0007a'\u0001\u0003oC6,\u0017\u0001\u00059beN,w\u000b[8SKN\u0004xN\\:f)\u0011\ti\"a\u000f\u0011\r\u0005}\u0011\u0011FA\u0018\u001d\u0011\t\t#!\n\u000f\u0007e\n\u0019#C\u00013\u0013\r\t9#M\u0001\ba\u0006\u001c7.Y4f\u0013\u0011\tY#!\f\u0003\u0007M+\u0017OC\u0002\u0002(E\u0002B!!\r\u000285\u0011\u00111\u0007\u0006\u0004\u0003k\u0019\u0013\u0001C2p[6\fg\u000eZ:\n\t\u0005e\u00121\u0007\u0002\f/\"|'+Z:q_:\u001cX\rC\u0003`\u001d\u0001\u0007\u0001-\u0001\nqCJ\u001cX-Q;uQ\u000eC\u0017\r\u001c7f]\u001e,G\u0003BA!\u0003\u000f\u00022\u0001KA\"\u0013\r\t)%\t\u0002\u0015\u0003V$\bn\u00115bY2,gnZ3NKN\u001c\u0018mZ3\t\u000b}{\u0001\u0019\u00011\u0002#A\f'o]3BkRD'+Z:q_:\u001cX\rF\u0002F\u0003\u001bBQa\u0018\tA\u0002\u0001\fQ\u0002]1sg\u0016\u001c\u0005.\u0019:F]VlG\u0003BA*\u00037\u0002B\u0001\r7\u0002VA\u0019\u0001&a\u0016\n\u0007\u0005e\u0013EA\bDQ\u0006\u0014XI\\;n\u001b\u0016\u001c8/Y4f\u0011\u0015y\u0016\u00031\u0001a\u0003A9(/\u001b;f!2\f\u00170\u001a:M_\u001eLg\u000eF\u0002\\\u0003CBq!a\u0019\u0013\u0001\u0004\t\t!A\u0002pkR\f\u0001c\u001e:ji\u0016Tu.\u001b8DQ\u0006tg.\u001a7\u0015\u000fm\u000bI'a\u001b\u0002p!9\u00111M\nA\u0002\u0005\u0005\u0001BBA7'\u0001\u0007q&\u0001\u0002jI\"1\u0011\u0011O\nA\u0002\t\u000b\u0001#\u001e;gq\rC\u0017M\u001c8fY\nKH/Z:\u0002\u001dE,XM]=Hk&dGMT1nKV\t1,\u0001\tiC:$G.Z$vS2$\u0017+^3ssR!\u00111PAA!\rA\u0013QP\u0005\u0004\u0003\u007f\n#!C$vS2$\u0017J\u001c4p\u0011\u0015yV\u00031\u0001a\u0003A\u0001\u0018M]:f\u0007\"\fG/T3tg\u0006<W\r\u0006\u0003\u0002\b\u0006=\u0005\u0003\u0002\u0019m\u0003\u0013\u00032\u0001KAF\u0013\r\ti)\t\u0002\f\u0007\"\fG/T3tg\u0006<W\rC\u0003`-\u0001\u0007\u0001-A\bqCJ\u001cXmU3sm\u0016\u0014Xj\u001c;e)\u0011\t)*a&\u0011\r\u0005}\u0011\u0011FAE\u0011\u0015yv\u00031\u0001a\u0003A\u0001\u0018M]:f\u000fVLG\u000e\u001a*pgR,'\u000f\u0006\u0003\u0002\u001e\u0006%\u0006CB\u001c\u0002 J\f\u0019+C\u0002\u0002\"\u0002\u00131!T1q!\rA\u0013QU\u0005\u0004\u0003O\u000b#aC$vS2$W*Z7cKJDQa\u0018\rA\u0002\u0001\f\u0011\u0003]1sg\u0016tu\u000e^5gS\u000e\fG/[8o)\r1\u0014q\u0016\u0005\u0006?f\u0001\r\u0001Y\u0001\u0018S:LG/[1mSj,w+\u0019:eK:D\u0015M\u001c3mKJ,\"!!.\u0011\t\u0005]\u0016QX\u0007\u0003\u0003sS1!a/\"\u0003\u00199\u0018M\u001d3f]&!\u0011qXA]\u000559\u0016M\u001d3f]\"\u000bg\u000e\u001a7fe\u00061\u0002.\u00198eY\u0016|6+T*H?\u001e+\u0016\n\u0014#`\u001b>#F\tF\u0002\\\u0003\u000bDQaX\u000eA\u0002\u0001\fa\u0004[1oI2,wlU'T\u000f~;U+\u0013'E?J\u000bejS*`+B#\u0015\tV#\u0015\u0007m\u000bY\rC\u0003`9\u0001\u0007\u0001-A\u0010iC:$G.Z0T\u001bN;ulR+J\u0019\u0012{\u0016J\u0014,J)\u0016{\u0016iQ\"F!R#2aWAi\u0011\u0015yV\u00041\u0001a\u0003}A\u0017M\u001c3mK~\u001bVjU$`\u000fVKE\nR0N\u000b6\u0013UIU0M\u001f\u001e;U\t\u0012\u000b\u00047\u0006]\u0007\"B0\u001f\u0001\u0004\u0001\u0017a\u00065b]\u0012dWmX*N'\u001e{v)V%M\t~cU)\u0011,F)\rY\u0016Q\u001c\u0005\u0006?~\u0001\r\u0001\u0019")
public class GamePacketHandlerMoP18414
extends GamePacketHandlerCataclysm15595
implements GamePacketsMoP18414 {
    private final int realmId;
    private final byte[] sessionKey;
    private final byte[] addonInfo;
    private final int CMSG_MESSAGECHAT_AFK;
    private final int CMSG_MESSAGECHAT_CHANNEL;
    private final int CMSG_MESSAGECHAT_DND;
    private final int CMSG_MESSAGECHAT_EMOTE;
    private final int CMSG_MESSAGECHAT_GUILD;
    private final int CMSG_MESSAGECHAT_OFFICER;
    private final int CMSG_MESSAGECHAT_PARTY;
    private final int CMSG_MESSAGECHAT_SAY;
    private final int CMSG_MESSAGECHAT_WHISPER;
    private final int CMSG_MESSAGECHAT_YELL;
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
    private final int CMSG_KEEP_ALIVE;
    private final int SMSG_TIME_SYNC_REQ;
    private final int CMSG_TIME_SYNC_RESP;
    private final int SMSG_GUILD_MOTD;
    private final int SMSG_GUILD_RANKS_UPDATE;
    private final int SMSG_GUILD_INVITE_ACCEPT;
    private final int SMSG_GUILD_MEMBER_LOGGED;
    private final int SMSG_GUILD_LEAVE;
    private final int SMSG_MOTD;
    private final int SMSG_COMPRESSED_DATA;

    @Override
    public int CMSG_MESSAGECHAT_AFK() {
        return this.CMSG_MESSAGECHAT_AFK;
    }

    @Override
    public int CMSG_MESSAGECHAT_CHANNEL() {
        return this.CMSG_MESSAGECHAT_CHANNEL;
    }

    @Override
    public int CMSG_MESSAGECHAT_DND() {
        return this.CMSG_MESSAGECHAT_DND;
    }

    @Override
    public int CMSG_MESSAGECHAT_EMOTE() {
        return this.CMSG_MESSAGECHAT_EMOTE;
    }

    @Override
    public int CMSG_MESSAGECHAT_GUILD() {
        return this.CMSG_MESSAGECHAT_GUILD;
    }

    @Override
    public int CMSG_MESSAGECHAT_OFFICER() {
        return this.CMSG_MESSAGECHAT_OFFICER;
    }

    @Override
    public int CMSG_MESSAGECHAT_PARTY() {
        return this.CMSG_MESSAGECHAT_PARTY;
    }

    @Override
    public int CMSG_MESSAGECHAT_SAY() {
        return this.CMSG_MESSAGECHAT_SAY;
    }

    @Override
    public int CMSG_MESSAGECHAT_WHISPER() {
        return this.CMSG_MESSAGECHAT_WHISPER;
    }

    @Override
    public int CMSG_MESSAGECHAT_YELL() {
        return this.CMSG_MESSAGECHAT_YELL;
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
    public int CMSG_KEEP_ALIVE() {
        return this.CMSG_KEEP_ALIVE;
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
    public int SMSG_GUILD_MOTD() {
        return this.SMSG_GUILD_MOTD;
    }

    @Override
    public int SMSG_GUILD_RANKS_UPDATE() {
        return this.SMSG_GUILD_RANKS_UPDATE;
    }

    @Override
    public int SMSG_GUILD_INVITE_ACCEPT() {
        return this.SMSG_GUILD_INVITE_ACCEPT;
    }

    @Override
    public int SMSG_GUILD_MEMBER_LOGGED() {
        return this.SMSG_GUILD_MEMBER_LOGGED;
    }

    @Override
    public int SMSG_GUILD_LEAVE() {
        return this.SMSG_GUILD_LEAVE;
    }

    @Override
    public int SMSG_MOTD() {
        return this.SMSG_MOTD;
    }

    @Override
    public int SMSG_COMPRESSED_DATA() {
        return this.SMSG_COMPRESSED_DATA;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$CMSG_MESSAGECHAT_AFK_$eq(int x$1) {
        this.CMSG_MESSAGECHAT_AFK = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$CMSG_MESSAGECHAT_CHANNEL_$eq(int x$1) {
        this.CMSG_MESSAGECHAT_CHANNEL = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$CMSG_MESSAGECHAT_DND_$eq(int x$1) {
        this.CMSG_MESSAGECHAT_DND = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$CMSG_MESSAGECHAT_EMOTE_$eq(int x$1) {
        this.CMSG_MESSAGECHAT_EMOTE = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$CMSG_MESSAGECHAT_GUILD_$eq(int x$1) {
        this.CMSG_MESSAGECHAT_GUILD = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$CMSG_MESSAGECHAT_OFFICER_$eq(int x$1) {
        this.CMSG_MESSAGECHAT_OFFICER = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$CMSG_MESSAGECHAT_PARTY_$eq(int x$1) {
        this.CMSG_MESSAGECHAT_PARTY = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$CMSG_MESSAGECHAT_SAY_$eq(int x$1) {
        this.CMSG_MESSAGECHAT_SAY = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$CMSG_MESSAGECHAT_WHISPER_$eq(int x$1) {
        this.CMSG_MESSAGECHAT_WHISPER = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$CMSG_MESSAGECHAT_YELL_$eq(int x$1) {
        this.CMSG_MESSAGECHAT_YELL = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$CMSG_CHAR_ENUM_$eq(int x$1) {
        this.CMSG_CHAR_ENUM = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$SMSG_CHAR_ENUM_$eq(int x$1) {
        this.SMSG_CHAR_ENUM = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$CMSG_PLAYER_LOGIN_$eq(int x$1) {
        this.CMSG_PLAYER_LOGIN = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$CMSG_LOGOUT_REQUEST_$eq(int x$1) {
        this.CMSG_LOGOUT_REQUEST = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$CMSG_NAME_QUERY_$eq(int x$1) {
        this.CMSG_NAME_QUERY = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$SMSG_NAME_QUERY_$eq(int x$1) {
        this.SMSG_NAME_QUERY = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$CMSG_GUILD_QUERY_$eq(int x$1) {
        this.CMSG_GUILD_QUERY = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$SMSG_GUILD_QUERY_$eq(int x$1) {
        this.SMSG_GUILD_QUERY = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$CMSG_WHO_$eq(int x$1) {
        this.CMSG_WHO = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$SMSG_WHO_$eq(int x$1) {
        this.SMSG_WHO = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$CMSG_GUILD_ROSTER_$eq(int x$1) {
        this.CMSG_GUILD_ROSTER = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$SMSG_GUILD_ROSTER_$eq(int x$1) {
        this.SMSG_GUILD_ROSTER = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$SMSG_MESSAGECHAT_$eq(int x$1) {
        this.SMSG_MESSAGECHAT = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$CMSG_JOIN_CHANNEL_$eq(int x$1) {
        this.CMSG_JOIN_CHANNEL = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$SMSG_CHANNEL_NOTIFY_$eq(int x$1) {
        this.SMSG_CHANNEL_NOTIFY = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$SMSG_NOTIFICATION_$eq(int x$1) {
        this.SMSG_NOTIFICATION = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$CMSG_PING_$eq(int x$1) {
        this.CMSG_PING = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$SMSG_AUTH_CHALLENGE_$eq(int x$1) {
        this.SMSG_AUTH_CHALLENGE = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$CMSG_AUTH_CHALLENGE_$eq(int x$1) {
        this.CMSG_AUTH_CHALLENGE = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$SMSG_AUTH_RESPONSE_$eq(int x$1) {
        this.SMSG_AUTH_RESPONSE = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$SMSG_LOGIN_VERIFY_WORLD_$eq(int x$1) {
        this.SMSG_LOGIN_VERIFY_WORLD = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$SMSG_SERVER_MESSAGE_$eq(int x$1) {
        this.SMSG_SERVER_MESSAGE = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$SMSG_WARDEN_DATA_$eq(int x$1) {
        this.SMSG_WARDEN_DATA = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$CMSG_WARDEN_DATA_$eq(int x$1) {
        this.CMSG_WARDEN_DATA = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$SMSG_INVALIDATE_PLAYER_$eq(int x$1) {
        this.SMSG_INVALIDATE_PLAYER = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$CMSG_KEEP_ALIVE_$eq(int x$1) {
        this.CMSG_KEEP_ALIVE = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$SMSG_TIME_SYNC_REQ_$eq(int x$1) {
        this.SMSG_TIME_SYNC_REQ = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$CMSG_TIME_SYNC_RESP_$eq(int x$1) {
        this.CMSG_TIME_SYNC_RESP = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$SMSG_GUILD_MOTD_$eq(int x$1) {
        this.SMSG_GUILD_MOTD = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$SMSG_GUILD_RANKS_UPDATE_$eq(int x$1) {
        this.SMSG_GUILD_RANKS_UPDATE = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$SMSG_GUILD_INVITE_ACCEPT_$eq(int x$1) {
        this.SMSG_GUILD_INVITE_ACCEPT = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$SMSG_GUILD_MEMBER_LOGGED_$eq(int x$1) {
        this.SMSG_GUILD_MEMBER_LOGGED = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$SMSG_GUILD_LEAVE_$eq(int x$1) {
        this.SMSG_GUILD_LEAVE = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$SMSG_MOTD_$eq(int x$1) {
        this.SMSG_MOTD = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsMoP18414$_setter_$SMSG_COMPRESSED_DATA_$eq(int x$1) {
        this.SMSG_COMPRESSED_DATA = x$1;
    }

    @Override
    public byte[] addonInfo() {
        return this.addonInfo;
    }

    @Override
    public void channelParse(Packet msg) {
        int n = msg.id();
        if (this.SMSG_GUILD_MOTD() == n) {
            this.handle_SMSG_GUILD_MOTD(msg);
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        } else if (this.SMSG_GUILD_RANKS_UPDATE() == n) {
            this.handle_SMSG_GUILD_RANKS_UPDATE(msg);
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        } else if (this.SMSG_GUILD_INVITE_ACCEPT() == n) {
            this.handle_SMSG_GUILD_INVITE_ACCEPT(msg);
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        } else if (this.SMSG_GUILD_MEMBER_LOGGED() == n) {
            this.handle_SMSG_GUILD_MEMBER_LOGGED(msg);
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        } else if (this.SMSG_GUILD_LEAVE() == n) {
            this.handle_SMSG_GUILD_LEAVE(msg);
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        } else {
            super.channelParse(msg);
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        }
    }

    @Override
    public Packet buildChatMessage(byte tp, byte[] utf8MessageBytes, Option<byte[]> utf8TargetBytes2) {
        ByteBuf out = PooledByteBufAllocator.DEFAULT.buffer(128, 8192);
        out.writeIntLE(this.languageId());
        utf8TargetBytes2.foreach((Function1<byte[], Object> & Serializable & scala.Serializable)utf8TargetBytes -> {
            GamePacketHandlerMoP18414.$anonfun$buildChatMessage$1(this, tp, out, utf8TargetBytes);
            return BoxedUnit.UNIT;
        });
        this.writeBits(out, utf8MessageBytes.length, 8);
        if (tp == this.ChatEvents().CHAT_MSG_WHISPER()) {
            this.writeBits(out, utf8TargetBytes2.get().length, 9);
        }
        this.flushBits(out);
        out.writeBytes(utf8MessageBytes);
        Object object = utf8TargetBytes2.isDefined() ? out.writeBytes(utf8TargetBytes2.get()) : BoxedUnit.UNIT;
        return new Packet(this.getChatPacketFromType(tp), out);
    }

    @Override
    public void sendNameQuery(long guid) {
        this.ctx().foreach((Function1<ChannelHandlerContext, ChannelFuture> & Serializable & scala.Serializable)ctx -> {
            ByteBuf out = PooledByteBufAllocator.DEFAULT.buffer(10, 10);
            byte[] guidBytes = ByteUtils$.MODULE$.longToBytesLE(guid);
            this.writeBitSeq(out, guidBytes, Predef$.MODULE$.wrapIntArray(new int[]{4}));
            this.writeBit(out, 0);
            this.writeBitSeq(out, guidBytes, Predef$.MODULE$.wrapIntArray(new int[]{6, 0, 7, 1}));
            this.writeBit(out, 0);
            this.writeBitSeq(out, guidBytes, Predef$.MODULE$.wrapIntArray(new int[]{5, 2, 3}));
            this.flushBits(out);
            this.writeXorByteSeq(out, guidBytes, Predef$.MODULE$.wrapIntArray(new int[]{7, 5, 1, 2, 6, 3, 0, 4}));
            return ctx.writeAndFlush(new Packet(this.CMSG_NAME_QUERY(), out));
        });
    }

    @Override
    public NameQueryMessage parseNameQuery(Packet msg) {
        byte by;
        boolean hasNameData;
        byte[] guid = new byte[8];
        byte[] guid2 = new byte[8];
        byte[] guid3 = new byte[8];
        msg.readBitSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{3, 6, 7, 2, 5, 4, 0, 1}));
        msg.readXorByteSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{5, 4, 7, 6, 1, 2}));
        boolean bl = hasNameData = msg.readBit() == 0;
        if (hasNameData) {
            msg.byteBuf().skipBytes(8);
            byte charClass = msg.byteBuf().readByte();
            msg.byteBuf().skipBytes(3);
            by = charClass;
        } else {
            by = (byte)255;
        }
        byte charClass = by;
        msg.readXorByteSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{0, 3}));
        if (!hasNameData) {
            BoxedUnit boxedUnit;
            long longGuid = ByteUtils$.MODULE$.bytesToLongLE(guid);
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("RECV SMSG_NAME_QUERY - Name not known for guid {}", new Object[]{BoxesRunTime.boxToLong(longGuid)});
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
            return new NameQueryMessage(longGuid, "UNKNOWN", charClass);
        }
        msg.resetBitReader();
        msg.readBitSeq(guid2, Predef$.MODULE$.wrapIntArray(new int[]{2, 7}));
        msg.readBitSeq(guid3, Predef$.MODULE$.wrapIntArray(new int[]{7, 2, 0}));
        msg.readBit();
        msg.readBitSeq(guid2, Predef$.MODULE$.wrapIntArray(new int[]{4}));
        msg.readBitSeq(guid3, Predef$.MODULE$.wrapIntArray(new int[]{5}));
        msg.readBitSeq(guid2, Predef$.MODULE$.wrapIntArray(new int[]{1, 3, 0}));
        msg.readBits(35);
        msg.readBitSeq(guid3, Predef$.MODULE$.wrapIntArray(new int[]{6, 3}));
        msg.readBitSeq(guid2, Predef$.MODULE$.wrapIntArray(new int[]{5}));
        msg.readBitSeq(guid3, Predef$.MODULE$.wrapIntArray(new int[]{1, 4}));
        int nameLength = msg.readBits(6);
        msg.readBitSeq(guid2, Predef$.MODULE$.wrapIntArray(new int[]{6}));
        msg.resetBitReader();
        msg.readXorByteSeq(guid3, Predef$.MODULE$.wrapIntArray(new int[]{6, 0}));
        String name = ((Object)msg.byteBuf().readCharSequence(nameLength, Charset.forName("UTF-8"))).toString();
        return new NameQueryMessage(ByteUtils$.MODULE$.bytesToLongLE(guid), name, charClass);
    }

    @Override
    public long parseInvalidatePlayer(Packet msg) {
        byte[] guid = new byte[8];
        msg.readBitSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{6, 3, 1, 2, 7, 5, 0, 4}));
        msg.readXorByteSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{7, 1, 2, 3, 6, 0, 4, 5}));
        return ByteUtils$.MODULE$.bytesToLongLE(guid);
    }

    @Override
    public ByteBuf buildWhoMessage(String name) {
        ByteBuf byteBuf = PooledByteBufAllocator.DEFAULT.buffer(64, 64);
        byteBuf.writeIntLE(-1);
        byteBuf.writeIntLE(-1);
        byteBuf.writeIntLE(100);
        byteBuf.writeIntLE(0);
        this.writeBit(byteBuf, 1);
        this.writeBit(byteBuf, 1);
        this.writeBit(byteBuf, 0);
        this.writeBits(byteBuf, 0, 9);
        this.writeBit(byteBuf, 1);
        this.writeBits(byteBuf, name.length(), 6);
        this.writeBits(byteBuf, 0, 4);
        this.writeBits(byteBuf, 0, 9);
        this.writeBits(byteBuf, 0, 7);
        this.writeBits(byteBuf, 0, 3);
        this.flushBits(byteBuf);
        return byteBuf.writeBytes(name.getBytes("UTF-8"));
    }

    @Override
    public Seq<WhoResponse> parseWhoResponse(Packet msg) {
        Seq seq;
        int displayCount = msg.readBits(6);
        if (displayCount == 0) {
            seq = Nil$.MODULE$;
        } else {
            byte[][] accountId = new byte[displayCount][];
            byte[][] playerGuid = new byte[displayCount][];
            byte[][] guildGuid = new byte[displayCount][];
            int[] guildNameLengths = new int[displayCount];
            int[] playerNameLengths = new int[displayCount];
            RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), displayCount).foreach$mVc$sp((JFunction1$mcVI$sp & scala.Serializable)i -> {
                accountId$1[i] = new byte[8];
                playerGuid$1[i] = new byte[8];
                guildGuid$1[i] = new byte[8];
                msg.readBitSeq(accountId[i], Predef$.MODULE$.wrapIntArray(new int[]{2}));
                msg.readBitSeq(playerGuid[i], Predef$.MODULE$.wrapIntArray(new int[]{2}));
                msg.readBitSeq(accountId[i], Predef$.MODULE$.wrapIntArray(new int[]{7}));
                msg.readBitSeq(guildGuid[i], Predef$.MODULE$.wrapIntArray(new int[]{5}));
                guildNameLengths$1[i] = msg.readBits(7);
                msg.readBitSeq(accountId[i], Predef$.MODULE$.wrapIntArray(new int[]{1, 5}));
                msg.readBitSeq(guildGuid[i], Predef$.MODULE$.wrapIntArray(new int[]{7}));
                msg.readBitSeq(playerGuid[i], Predef$.MODULE$.wrapIntArray(new int[]{5}));
                msg.readBit();
                msg.readBitSeq(guildGuid[i], Predef$.MODULE$.wrapIntArray(new int[]{1}));
                msg.readBitSeq(playerGuid[i], Predef$.MODULE$.wrapIntArray(new int[]{6}));
                msg.readBitSeq(guildGuid[i], Predef$.MODULE$.wrapIntArray(new int[]{2}));
                msg.readBitSeq(playerGuid[i], Predef$.MODULE$.wrapIntArray(new int[]{4}));
                msg.readBitSeq(guildGuid[i], Predef$.MODULE$.wrapIntArray(new int[]{0, 3}));
                msg.readBitSeq(accountId[i], Predef$.MODULE$.wrapIntArray(new int[]{6}));
                msg.readBit();
                msg.readBitSeq(playerGuid[i], Predef$.MODULE$.wrapIntArray(new int[]{1}));
                msg.readBitSeq(guildGuid[i], Predef$.MODULE$.wrapIntArray(new int[]{4}));
                msg.readBitSeq(accountId[i], Predef$.MODULE$.wrapIntArray(new int[]{0}));
                msg.readBits(35);
                msg.readBitSeq(playerGuid[i], Predef$.MODULE$.wrapIntArray(new int[]{3}));
                msg.readBitSeq(guildGuid[i], Predef$.MODULE$.wrapIntArray(new int[]{6}));
                msg.readBitSeq(playerGuid[i], Predef$.MODULE$.wrapIntArray(new int[]{0}));
                msg.readBitSeq(accountId[i], Predef$.MODULE$.wrapIntArray(new int[]{4, 3}));
                msg.readBitSeq(playerGuid[i], Predef$.MODULE$.wrapIntArray(new int[]{7}));
                playerNameLengths$1[i] = msg.readBits(6);
            });
            seq = RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), displayCount).map((Function1<Object, WhoResponse> & Serializable & scala.Serializable)i -> GamePacketHandlerMoP18414.$anonfun$parseWhoResponse$2(this, msg, playerGuid, playerNameLengths, guildGuid, guildNameLengths, accountId, BoxesRunTime.unboxToInt(i)), IndexedSeq$.MODULE$.canBuildFrom());
        }
        return seq;
    }

    @Override
    public AuthChallengeMessage parseAuthChallenge(Packet msg) {
        byte[] account = Global$.MODULE$.config().wow().account();
        msg.byteBuf().skipBytes(35);
        int serverSeed = msg.byteBuf().readInt();
        int clientSeed = Random$.MODULE$.nextInt();
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.update(account);
        md.update((byte[])Array$.MODULE$.apply(Predef$.MODULE$.wrapByteArray(new byte[]{0, 0, 0, 0}), ClassTag$.MODULE$.Byte()));
        md.update(ByteUtils$.MODULE$.intToBytes(clientSeed));
        md.update(ByteUtils$.MODULE$.intToBytes(serverSeed));
        md.update(this.sessionKey);
        byte[] digest = md.digest();
        ByteBuf out = PooledByteBufAllocator.DEFAULT.buffer(200, 1000);
        out.writeShortLE(0);
        out.writeLongLE(0L);
        out.writeByte(digest[18]);
        out.writeByte(digest[14]);
        out.writeByte(digest[3]);
        out.writeByte(digest[4]);
        out.writeByte(digest[0]);
        out.writeIntLE(this.realmId);
        out.writeByte(digest[11]);
        out.writeInt(clientSeed);
        out.writeByte(digest[19]);
        out.writeShortLE(1);
        out.writeByte(digest[2]);
        out.writeByte(digest[9]);
        out.writeByte(digest[12]);
        out.writeLongLE(0L);
        out.writeIntLE(0);
        out.writeByte(digest[16]);
        out.writeByte(digest[5]);
        out.writeByte(digest[6]);
        out.writeByte(digest[8]);
        out.writeShortLE(WowChatConfig$.MODULE$.getGameBuild());
        out.writeByte(digest[17]);
        out.writeByte(digest[7]);
        out.writeByte(digest[13]);
        out.writeByte(digest[15]);
        out.writeByte(digest[1]);
        out.writeByte(digest[10]);
        out.writeIntLE(this.addonInfo().length);
        out.writeBytes(this.addonInfo());
        this.writeBit(out, 0);
        this.writeBits(out, account.length, 11);
        this.flushBits(out);
        out.writeBytes(account);
        return new AuthChallengeMessage(this.sessionKey, out);
    }

    @Override
    public byte parseAuthResponse(Packet msg) {
        return (byte)(msg.readBit() == 1 ? this.AuthResponseCodes().AUTH_OK() : this.AuthResponseCodes().AUTH_FAILED());
    }

    @Override
    public Option<CharEnumMessage> parseCharEnum(Packet msg) {
        Option option;
        Object object = new Object();
        try {
            byte[] characterBytes = Global$.MODULE$.config().wow().character().toLowerCase().getBytes("UTF-8");
            msg.readBits(21);
            int charactersNum = msg.readBits(16);
            byte[][] guids = new byte[charactersNum][];
            byte[][] guildGuids = new byte[charactersNum][];
            int[] nameLenghts = new int[charactersNum];
            RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), charactersNum).foreach$mVc$sp((JFunction1$mcVI$sp & scala.Serializable)i -> {
                guids$1[i] = new byte[8];
                guildGuids$1[i] = new byte[8];
                msg.readBitSeq(guildGuids[i], Predef$.MODULE$.wrapIntArray(new int[]{4}));
                msg.readBitSeq(guids[i], Predef$.MODULE$.wrapIntArray(new int[]{0}));
                msg.readBitSeq(guildGuids[i], Predef$.MODULE$.wrapIntArray(new int[]{3}));
                msg.readBitSeq(guids[i], Predef$.MODULE$.wrapIntArray(new int[]{3, 7}));
                msg.readBits(2);
                msg.readBitSeq(guids[i], Predef$.MODULE$.wrapIntArray(new int[]{6}));
                msg.readBitSeq(guildGuids[i], Predef$.MODULE$.wrapIntArray(new int[]{6}));
                nameLenghts$1[i] = msg.readBits(6);
                msg.readBitSeq(guids[i], Predef$.MODULE$.wrapIntArray(new int[]{1}));
                msg.readBitSeq(guildGuids[i], Predef$.MODULE$.wrapIntArray(new int[]{1, 0}));
                msg.readBitSeq(guids[i], Predef$.MODULE$.wrapIntArray(new int[]{4}));
                msg.readBitSeq(guildGuids[i], Predef$.MODULE$.wrapIntArray(new int[]{7}));
                msg.readBitSeq(guids[i], Predef$.MODULE$.wrapIntArray(new int[]{2, 5}));
                msg.readBitSeq(guildGuids[i], Predef$.MODULE$.wrapIntArray(new int[]{2, 5}));
            });
            msg.readBit();
            RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), charactersNum).foreach$mVc$sp((JFunction1$mcVI$sp & scala.Serializable)i -> {
                msg.byteBuf().skipBytes(4);
                msg.readXorByteSeq(guids[i], Predef$.MODULE$.wrapIntArray(new int[]{1}));
                msg.byteBuf().skipBytes(2);
                msg.readXorByteSeq(guildGuids[i], Predef$.MODULE$.wrapIntArray(new int[]{2, 0, 6}));
                String name = ((Object)msg.byteBuf().readCharSequence(nameLenghts[i], Charset.forName("UTF-8"))).toString();
                msg.readXorByteSeq(guildGuids[i], Predef$.MODULE$.wrapIntArray(new int[]{3}));
                msg.byteBuf().skipBytes(10);
                msg.readXorByteSeq(guildGuids[i], Predef$.MODULE$.wrapIntArray(new int[]{5}));
                msg.byteBuf().skipBytes(207);
                msg.byteBuf().skipBytes(4);
                msg.readXorByteSeq(guids[i], Predef$.MODULE$.wrapIntArray(new int[]{3, 5}));
                msg.byteBuf().skipBytes(4);
                msg.readXorByteSeq(guildGuids[i], Predef$.MODULE$.wrapIntArray(new int[]{4}));
                msg.byteBuf().readIntLE();
                byte race = msg.byteBuf().readByte();
                msg.byteBuf().skipBytes(1);
                msg.readXorByteSeq(guildGuids[i], Predef$.MODULE$.wrapIntArray(new int[]{1}));
                msg.byteBuf().skipBytes(1);
                msg.readXorByteSeq(guids[i], Predef$.MODULE$.wrapIntArray(new int[]{0, 2}));
                msg.byteBuf().skipBytes(3);
                msg.byteBuf().skipBytes(4);
                msg.readXorByteSeq(guids[i], Predef$.MODULE$.wrapIntArray(new int[]{4, 7}));
                msg.byteBuf().skipBytes(12);
                msg.readXorByteSeq(guids[i], Predef$.MODULE$.wrapIntArray(new int[]{6}));
                msg.byteBuf().skipBytes(8);
                msg.readXorByteSeq(guildGuids[i], Predef$.MODULE$.wrapIntArray(new int[]{7}));
                msg.byteBuf().skipBytes(4);
                if (new ArrayOps.ofByte(Predef$.MODULE$.byteArrayOps(name.toLowerCase().getBytes("UTF-8"))).sameElements(Predef$.MODULE$.wrapByteArray(characterBytes))) {
                    throw new NonLocalReturnControl<Some<CharEnumMessage>>(object, new Some<CharEnumMessage>(new CharEnumMessage(name, ByteUtils$.MODULE$.bytesToLongLE(guids[i]), race, ByteUtils$.MODULE$.bytesToLongLE(guildGuids[i]))));
                }
            });
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

    @Override
    public void writePlayerLogin(ByteBuf out) {
        byte[] bytes = ByteUtils$.MODULE$.longToBytesLE(BoxesRunTime.unboxToLong(this.selfCharacterId().get()));
        out.writeIntLE(1128792064);
        this.writeBitSeq(out, bytes, Predef$.MODULE$.wrapIntArray(new int[]{1, 4, 7, 3, 2, 6, 5, 0}));
        this.writeXorByteSeq(out, bytes, Predef$.MODULE$.wrapIntArray(new int[]{5, 1, 0, 6, 2, 4, 7, 3}));
    }

    @Override
    public void writeJoinChannel(ByteBuf out, int id, byte[] utf8ChannelBytes) {
        out.writeIntLE(id);
        this.writeBit(out, 0);
        this.writeBits(out, utf8ChannelBytes.length, 7);
        this.writeBits(out, 0, 7);
        this.writeBit(out, 0);
        this.flushBits(out);
        out.writeBytes(utf8ChannelBytes);
    }

    @Override
    public void queryGuildName() {
        byte[] playerGuidArr = ByteUtils$.MODULE$.longToBytesLE(BoxesRunTime.unboxToLong(this.selfCharacterId().get()));
        byte[] guildGuidArr = ByteUtils$.MODULE$.longToBytesLE(this.guildGuid());
        ByteBuf out = PooledByteBufAllocator.DEFAULT.buffer(18, 18);
        this.writeBitSeq(out, playerGuidArr, Predef$.MODULE$.wrapIntArray(new int[]{7, 3, 4}));
        this.writeBitSeq(out, guildGuidArr, Predef$.MODULE$.wrapIntArray(new int[]{3, 4}));
        this.writeBitSeq(out, playerGuidArr, Predef$.MODULE$.wrapIntArray(new int[]{2, 6}));
        this.writeBitSeq(out, guildGuidArr, Predef$.MODULE$.wrapIntArray(new int[]{2, 5}));
        this.writeBitSeq(out, playerGuidArr, Predef$.MODULE$.wrapIntArray(new int[]{1, 5}));
        this.writeBitSeq(out, guildGuidArr, Predef$.MODULE$.wrapIntArray(new int[]{7}));
        this.writeBitSeq(out, playerGuidArr, Predef$.MODULE$.wrapIntArray(new int[]{0}));
        this.writeBitSeq(out, guildGuidArr, Predef$.MODULE$.wrapIntArray(new int[]{1, 6, 0}));
        this.writeXorByteSeq(out, playerGuidArr, Predef$.MODULE$.wrapIntArray(new int[]{7}));
        this.writeXorByteSeq(out, guildGuidArr, Predef$.MODULE$.wrapIntArray(new int[]{2, 4, 7}));
        this.writeXorByteSeq(out, playerGuidArr, Predef$.MODULE$.wrapIntArray(new int[]{6, 0}));
        this.writeXorByteSeq(out, guildGuidArr, Predef$.MODULE$.wrapIntArray(new int[]{6, 0, 3}));
        this.writeXorByteSeq(out, playerGuidArr, Predef$.MODULE$.wrapIntArray(new int[]{2}));
        this.writeXorByteSeq(out, guildGuidArr, Predef$.MODULE$.wrapIntArray(new int[]{5}));
        this.writeXorByteSeq(out, playerGuidArr, Predef$.MODULE$.wrapIntArray(new int[]{3}));
        this.writeXorByteSeq(out, guildGuidArr, Predef$.MODULE$.wrapIntArray(new int[]{1}));
        this.writeXorByteSeq(out, playerGuidArr, Predef$.MODULE$.wrapIntArray(new int[]{4, 1, 5}));
        ((ChannelOutboundInvoker)this.ctx().get()).writeAndFlush(new Packet(this.CMSG_GUILD_QUERY(), out));
    }

    @Override
    public GuildInfo handleGuildQuery(Packet msg) {
        byte[] guildGuidArr = new byte[8];
        msg.readBitSeq(guildGuidArr, Predef$.MODULE$.wrapIntArray(new int[]{5}));
        msg.readBit();
        int ranksNum = msg.readBits(21);
        msg.readBits(4);
        IndexedSeq rankLengths = RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), ranksNum).map((JFunction1$mcII$sp & scala.Serializable)x$2 -> msg.readBits(7), IndexedSeq$.MODULE$.canBuildFrom());
        msg.readBits(4);
        int guildNameLength = msg.readBits(7);
        msg.readBitSeq(guildGuidArr, Predef$.MODULE$.wrapIntArray(new int[]{3, 7, 2, 1, 0, 4, 6}));
        msg.byteBuf().skipBytes(8);
        msg.readXorByteSeq(guildGuidArr, Predef$.MODULE$.wrapIntArray(new int[]{2, 7}));
        msg.byteBuf().skipBytes(8);
        Map<Object, String> ranks = ((TraversableOnce)RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), ranksNum).map((Function1<Object, Tuple2> & Serializable & scala.Serializable)i -> GamePacketHandlerMoP18414.$anonfun$handleGuildQuery$2(msg, rankLengths, BoxesRunTime.unboxToInt(i)), IndexedSeq$.MODULE$.canBuildFrom())).toMap(Predef$.MODULE$.$conforms());
        String name = ((Object)msg.byteBuf().readCharSequence(guildNameLength, Charset.forName("UTF-8"))).toString();
        return new GuildInfo(name, ranks);
    }

    @Override
    public Option<ChatMessage> parseChatMessage(Packet msg) {
        Option option;
        String txt;
        byte language2;
        int messageLength;
        boolean hasSenderName = msg.readBit() == 0;
        msg.readBit();
        int n = hasSenderName ? msg.readBits(11) : 0;
        msg.readBit();
        boolean hasChannelName = msg.readBit() == 0;
        msg.readBit();
        msg.readBit();
        boolean hasChatTag = msg.readBit() == 0;
        boolean hasRealmId = msg.readBit() == 0;
        byte[] groupGuid = new byte[8];
        msg.readBitSeq(groupGuid, Predef$.MODULE$.wrapIntArray(new int[]{0, 1, 5, 4, 3, 2, 6, 7}));
        Serializable serializable = hasChatTag ? BoxesRunTime.boxToInteger(msg.readBits(9)) : BoxedUnit.UNIT;
        msg.readBit();
        byte[] receiverGuid = new byte[8];
        msg.readBitSeq(receiverGuid, Predef$.MODULE$.wrapIntArray(new int[]{7, 6, 1, 4, 0, 2, 3, 5}));
        msg.readBit();
        boolean hasLanguage = msg.readBit() == 0;
        boolean hasPrefix = msg.readBit() == 0;
        byte[] senderGuid = new byte[8];
        msg.readBitSeq(senderGuid, Predef$.MODULE$.wrapIntArray(new int[]{0, 3, 7, 2, 1, 5, 4, 6}));
        boolean hasAchievement = msg.readBit() == 0;
        boolean hasMessage = msg.readBit() == 0;
        int channelNameLength = hasChannelName ? msg.readBits(7) : 0;
        int n2 = messageLength = hasMessage ? msg.readBits(12) : 0;
        if (!hasMessage || messageLength == 0) {
            return None$.MODULE$;
        }
        boolean hasReceiver = msg.readBit() == 0;
        int addonPrefixLength = hasPrefix ? msg.readBits(5) : 0;
        msg.readBit();
        int n3 = hasReceiver ? msg.readBits(11) : 0;
        msg.readBit();
        byte[] guildGuid = new byte[8];
        msg.readBitSeq(guildGuid, Predef$.MODULE$.wrapIntArray(new int[]{2, 5, 7, 4, 0, 1, 3, 6}));
        msg.readXorByteSeq(guildGuid, Predef$.MODULE$.wrapIntArray(new int[]{4, 5, 7, 3, 2, 6, 0, 1}));
        Option channelName = hasChannelName ? new Some<String>(((Object)msg.byteBuf().readCharSequence(channelNameLength, Charset.forName("UTF-8"))).toString()) : None$.MODULE$;
        Object object = hasPrefix ? msg.byteBuf().skipBytes(addonPrefixLength) : BoxedUnit.UNIT;
        msg.readXorByteSeq(senderGuid, Predef$.MODULE$.wrapIntArray(new int[]{4, 7, 1, 5, 0, 6, 2, 3}));
        byte tp = msg.byteBuf().readByte();
        if (tp != this.ChatEvents().CHAT_MSG_SYSTEM() && ByteUtils$.MODULE$.bytesToLongLE(senderGuid) == BoxesRunTime.unboxToLong(this.selfCharacterId().get())) {
            return None$.MODULE$;
        }
        if (tp != this.ChatEvents().CHAT_MSG_GUILD_ACHIEVEMENT() && !Global$.MODULE$.wowToDiscord().contains(new Tuple2(BoxesRunTime.boxToByte(tp), channelName.map((Function1<String, String> & Serializable & scala.Serializable)x$3 -> x$3.toLowerCase())))) {
            return None$.MODULE$;
        }
        Option achievementId = hasAchievement ? new Some<Integer>(BoxesRunTime.boxToInteger(msg.byteBuf().readIntLE())) : None$.MODULE$;
        msg.readXorByteSeq(groupGuid, Predef$.MODULE$.wrapIntArray(new int[]{1, 3, 4, 6, 0, 2, 5, 7}));
        msg.readXorByteSeq(receiverGuid, Predef$.MODULE$.wrapIntArray(new int[]{4, 7, 1, 5, 0, 6, 2, 3}));
        byte by = language2 = hasLanguage ? msg.byteBuf().readByte() : (byte)0;
        if (language2 == -1) {
            return None$.MODULE$;
        }
        Object object2 = hasRealmId ? msg.byteBuf().skipBytes(4) : BoxedUnit.UNIT;
        String string = txt = hasMessage ? ((Object)msg.byteBuf().readCharSequence(messageLength, Charset.forName("UTF-8"))).toString() : "";
        if (hasAchievement) {
            this.handleAchievementEvent(ByteUtils$.MODULE$.bytesToLongLE(senderGuid), BoxesRunTime.unboxToInt(achievementId.get()));
            option = None$.MODULE$;
        } else {
            option = new Some<ChatMessage>(new ChatMessage(ByteUtils$.MODULE$.bytesToLongLE(senderGuid), tp, txt, channelName));
        }
        return option;
    }

    @Override
    public Seq<ChatMessage> parseServerMotd(Packet msg) {
        int lineCount = msg.readBits(4);
        IndexedSeq messageLengths = RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), lineCount).map((JFunction1$mcII$sp & scala.Serializable)i -> msg.readBits(7), IndexedSeq$.MODULE$.canBuildFrom());
        return messageLengths.map((Function1<Object, ChatMessage> & Serializable & scala.Serializable)messageLength -> GamePacketHandlerMoP18414.$anonfun$parseServerMotd$2(this, msg, BoxesRunTime.unboxToInt(messageLength)), IndexedSeq$.MODULE$.canBuildFrom());
    }

    @Override
    public Map<Object, GuildMember> parseGuildRoster(Packet msg) {
        int count = msg.readBits(17);
        int motdLength = msg.readBits(10);
        byte[][] guids = new byte[count][];
        int[] pNoteLengths = new int[count];
        int[] oNoteLengths = new int[count];
        int[] nameLengths = new int[count];
        RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), count).foreach$mVc$sp((JFunction1$mcVI$sp & scala.Serializable)i -> {
            guids$2[i] = new byte[8];
            oNoteLengths$1[i] = msg.readBits(8);
            msg.readBitSeq(guids[i], Predef$.MODULE$.wrapIntArray(new int[]{5}));
            msg.readBit();
            pNoteLengths$1[i] = msg.readBits(8);
            msg.readBitSeq(guids[i], Predef$.MODULE$.wrapIntArray(new int[]{7, 0, 6}));
            nameLengths$1[i] = msg.readBits(6);
            msg.readBit();
            msg.readBitSeq(guids[i], Predef$.MODULE$.wrapIntArray(new int[]{3, 4, 1, 2}));
        });
        int gInfoLength = msg.readBits(11);
        Map<Object, GuildMember> guildRosterMap = ((TraversableOnce)RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), count).map((Function1<Object, Tuple2> & Serializable & scala.Serializable)i -> GamePacketHandlerMoP18414.$anonfun$parseGuildRoster$2(msg, nameLengths, guids, oNoteLengths, pNoteLengths, BoxesRunTime.unboxToInt(i)), IndexedSeq$.MODULE$.canBuildFrom())).toMap(Predef$.MODULE$.$conforms());
        msg.byteBuf().skipBytes(4);
        msg.byteBuf().skipBytes(4);
        msg.byteBuf().skipBytes(gInfoLength);
        msg.byteBuf().skipBytes(4);
        this.guildMotd_$eq(new Some<String>(((Object)msg.byteBuf().readCharSequence(motdLength, Charset.forName("UTF-8"))).toString()));
        return guildRosterMap;
    }

    @Override
    public String parseNotification(Packet msg) {
        int length = msg.readBits(12);
        return ((Object)msg.byteBuf().readCharSequence(length, Charset.forName("UTF-8"))).toString();
    }

    @Override
    public WardenHandler initializeWardenHandler() {
        return new WardenHandlerMoP18414(this.sessionKey);
    }

    private void handle_SMSG_GUILD_MOTD(Packet msg) {
        String motd;
        int length = msg.readBits(10);
        String string = motd = ((Object)msg.byteBuf().readCharSequence(length, Charset.forName("UTF-8"))).toString();
        this.handleGuildEvent((byte)this.GuildEvents().GE_MOTD(), Nil$.MODULE$.$colon$colon(string));
    }

    private void handle_SMSG_GUILD_RANKS_UPDATE(Packet msg) {
        byte[] guid = new byte[8];
        byte[] targetGuid = new byte[8];
        msg.readBitSeq(targetGuid, Predef$.MODULE$.wrapIntArray(new int[]{5, 6}));
        msg.readBitSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{0, 1}));
        msg.readBitSeq(targetGuid, Predef$.MODULE$.wrapIntArray(new int[]{3}));
        msg.readBitSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{4}));
        msg.readBitSeq(targetGuid, Predef$.MODULE$.wrapIntArray(new int[]{2}));
        msg.readBitSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{6, 3, 7}));
        msg.readBitSeq(targetGuid, Predef$.MODULE$.wrapIntArray(new int[]{4, 0, 1}));
        msg.readBitSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{2}));
        msg.readBitSeq(targetGuid, Predef$.MODULE$.wrapIntArray(new int[]{7}));
        byte rankOrder = msg.readBit();
        msg.readBitSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{5}));
        msg.readXorByteSeq(targetGuid, Predef$.MODULE$.wrapIntArray(new int[]{2}));
        msg.readXorByteSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{1}));
        msg.readXorByteSeq(targetGuid, Predef$.MODULE$.wrapIntArray(new int[]{6, 1, 5}));
        msg.readXorByteSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{0}));
        int rank = msg.byteBuf().readIntLE();
        msg.readXorByteSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{3, 7}));
        msg.readXorByteSeq(targetGuid, Predef$.MODULE$.wrapIntArray(new int[]{7}));
        msg.readXorByteSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{2}));
        msg.readXorByteSeq(targetGuid, Predef$.MODULE$.wrapIntArray(new int[]{3, 4}));
        msg.readXorByteSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{6, 5}));
        msg.readXorByteSeq(targetGuid, Predef$.MODULE$.wrapIntArray(new int[]{0}));
        msg.readXorByteSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{4}));
        long guidLong = ByteUtils$.MODULE$.bytesToLongLE(guid);
        long targetGuidLong = ByteUtils$.MODULE$.bytesToLongLE(targetGuid);
        Option name = this.guildRoster().get(BoxesRunTime.boxToLong(guidLong)).map((Function1<GuildMember, String> & Serializable & scala.Serializable)x$5 -> x$5.name());
        if (name.isEmpty()) {
            BoxedUnit boxedUnit;
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("GUID {} for SMSG_GUILD_RANKS_UPDATE not found in guild roster!", new Object[]{BoxesRunTime.boxToLong(guidLong)});
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
            return;
        }
        Option targetName = this.guildRoster().get(BoxesRunTime.boxToLong(targetGuidLong)).map((Function1<GuildMember, String> & Serializable & scala.Serializable)x$6 -> x$6.name());
        if (targetName.isEmpty()) {
            BoxedUnit boxedUnit;
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("Target GUID {} for SMSG_GUILD_RANKS_UPDATE not found in guild roster!", new Object[]{BoxesRunTime.boxToLong(targetGuidLong)});
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
            return;
        }
        Option guildRank = this.guildInfo().ranks().get(BoxesRunTime.boxToInteger(rank));
        if (guildRank.isEmpty()) {
            BoxedUnit boxedUnit;
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("Rank ID {} for SMSG_GUILD_RANKS_UPDATE not found!", new Object[]{BoxesRunTime.boxToInteger(rank)});
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
            return;
        }
        byte event = (byte)(rankOrder == 1 ? this.GuildEvents().GE_PROMOTED() : this.GuildEvents().GE_DEMOTED());
        String string = (String)name.get();
        String string2 = (String)targetName.get();
        String string3 = (String)guildRank.get();
        this.handleGuildEvent(event, Nil$.MODULE$.$colon$colon(string3).$colon$colon(string2).$colon$colon(string));
    }

    private void handle_SMSG_GUILD_INVITE_ACCEPT(Packet msg) {
        byte[] guid = new byte[8];
        msg.readBitSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{6, 1, 3}));
        int nameLength = msg.readBits(6);
        msg.readBitSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{7, 4, 2, 5, 0}));
        msg.readXorByteSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{2, 4, 1, 6, 5}));
        msg.byteBuf().skipBytes(4);
        msg.readXorByteSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{3, 0}));
        String name = ((Object)msg.byteBuf().readCharSequence(nameLength, Charset.forName("UTF-8"))).toString();
        msg.readXorByteSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{7}));
        String string = name;
        this.handleGuildEvent((byte)this.GuildEvents().GE_JOINED(), Nil$.MODULE$.$colon$colon(string));
    }

    private void handle_SMSG_GUILD_MEMBER_LOGGED(Packet msg) {
        byte[] guid = new byte[8];
        msg.readBitSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{0, 6}));
        msg.readBit();
        msg.readBitSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{2, 5, 3}));
        int nameLength = msg.readBits(6);
        msg.readBitSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{1, 7, 4}));
        boolean isOnline = msg.readBit() == 1;
        msg.readXorByteSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{3, 2, 0}));
        msg.byteBuf().skipBytes(4);
        msg.readXorByteSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{6}));
        String name = ((Object)msg.byteBuf().readCharSequence(nameLength, Charset.forName("UTF-8"))).toString();
        msg.readXorByteSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{4, 5, 7, 1}));
        byte event = (byte)(isOnline ? this.GuildEvents().GE_SIGNED_ON() : this.GuildEvents().GE_SIGNED_OFF());
        String string = name;
        this.handleGuildEvent(event, Nil$.MODULE$.$colon$colon(string));
    }

    private void handle_SMSG_GUILD_LEAVE(Packet msg) {
        String string;
        Tuple2<Integer, byte[]> tuple2;
        Tuple2<Integer, byte[]> tuple22;
        boolean kicked;
        byte[] guid = new byte[8];
        msg.readBitSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{2}));
        int nameLength = msg.readBits(6);
        msg.readBitSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{6, 5}));
        boolean bl = kicked = msg.readBit() == 1;
        if (kicked) {
            msg.readBits(2);
            int kickerNameLength = msg.readBits(6);
            byte[] kickerGuid = new byte[8];
            msg.readBitSeq(kickerGuid, Predef$.MODULE$.wrapIntArray(new int[]{1, 3, 4, 2, 5, 7, 6, 0}));
            msg.readBit();
            tuple22 = new Tuple2<Integer, byte[]>(BoxesRunTime.boxToInteger(kickerNameLength), kickerGuid);
        } else {
            tuple22 = tuple2 = new Tuple2<Integer, byte[]>(BoxesRunTime.boxToInteger(0), null);
        }
        if (tuple2 == null) {
            throw new MatchError(tuple2);
        }
        int kickerNameLength = tuple2._1$mcI$sp();
        byte[] kickerGuid = tuple2._2();
        Tuple2<Integer, byte[]> tuple23 = new Tuple2<Integer, byte[]>(BoxesRunTime.boxToInteger(kickerNameLength), kickerGuid);
        Tuple2<Integer, byte[]> tuple24 = tuple23;
        int kickerNameLength2 = tuple24._1$mcI$sp();
        byte[] kickerGuid2 = tuple24._2();
        msg.readBitSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{1, 0, 3, 4, 7}));
        if (kicked) {
            msg.readXorByteSeq(kickerGuid2, Predef$.MODULE$.wrapIntArray(new int[]{1, 3, 5, 2, 0, 4, 6, 7}));
            String kickerName = ((Object)msg.byteBuf().readCharSequence(kickerNameLength2, Charset.forName("UTF-8"))).toString();
            msg.byteBuf().skipBytes(4);
            string = kickerName;
        } else {
            string = "";
        }
        String kickerName = string;
        String name = ((Object)msg.byteBuf().readCharSequence(nameLength, Charset.forName("UTF-8"))).toString();
        msg.readXorByteSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{1}));
        msg.byteBuf().skipBytes(4);
        msg.readXorByteSeq(guid, Predef$.MODULE$.wrapIntArray(new int[]{0, 4, 2, 3, 6, 5, 7}));
        if (kicked) {
            String string2 = name;
            String string3 = kickerName;
            this.handleGuildEvent((byte)this.GuildEvents().GE_REMOVED(), Nil$.MODULE$.$colon$colon(string3).$colon$colon(string2));
        } else {
            String string4 = name;
            this.handleGuildEvent((byte)this.GuildEvents().GE_LEFT(), Nil$.MODULE$.$colon$colon(string4));
        }
    }

    public static final /* synthetic */ byte $anonfun$addonInfo$1(int x$1) {
        return (byte)x$1;
    }

    public static final /* synthetic */ void $anonfun$buildChatMessage$1(GamePacketHandlerMoP18414 $this, byte tp$1, ByteBuf out$1, byte[] utf8TargetBytes) {
        block0: {
            if (tp$1 != $this.ChatEvents().CHAT_MSG_CHANNEL()) break block0;
            $this.writeBits(out$1, utf8TargetBytes.length, 9);
        }
    }

    public static final /* synthetic */ WhoResponse $anonfun$parseWhoResponse$2(GamePacketHandlerMoP18414 $this, Packet msg$1, byte[][] playerGuid$1, int[] playerNameLengths$1, byte[][] guildGuid$1, int[] guildNameLengths$1, byte[][] accountId$1, int i) {
        msg$1.readXorByteSeq(playerGuid$1[i], Predef$.MODULE$.wrapIntArray(new int[]{1}));
        msg$1.byteBuf().skipBytes(4);
        msg$1.readXorByteSeq(playerGuid$1[i], Predef$.MODULE$.wrapIntArray(new int[]{7}));
        msg$1.byteBuf().skipBytes(4);
        msg$1.readXorByteSeq(playerGuid$1[i], Predef$.MODULE$.wrapIntArray(new int[]{4}));
        String playerName = ((Object)msg$1.byteBuf().readCharSequence(playerNameLengths$1[i], Charset.forName("UTF-8"))).toString();
        msg$1.readXorByteSeq(guildGuid$1[i], Predef$.MODULE$.wrapIntArray(new int[]{1}));
        msg$1.readXorByteSeq(playerGuid$1[i], Predef$.MODULE$.wrapIntArray(new int[]{0}));
        msg$1.readXorByteSeq(guildGuid$1[i], Predef$.MODULE$.wrapIntArray(new int[]{2, 0, 4}));
        msg$1.readXorByteSeq(playerGuid$1[i], Predef$.MODULE$.wrapIntArray(new int[]{3}));
        msg$1.readXorByteSeq(guildGuid$1[i], Predef$.MODULE$.wrapIntArray(new int[]{6}));
        msg$1.byteBuf().skipBytes(4);
        String guildName = ((Object)msg$1.byteBuf().readCharSequence(guildNameLengths$1[i], Charset.forName("UTF-8"))).toString();
        msg$1.readXorByteSeq(guildGuid$1[i], Predef$.MODULE$.wrapIntArray(new int[]{3}));
        msg$1.readXorByteSeq(accountId$1[i], Predef$.MODULE$.wrapIntArray(new int[]{4}));
        String cls = $this.Classes().valueOf(msg$1.byteBuf().readByte());
        msg$1.readXorByteSeq(accountId$1[i], Predef$.MODULE$.wrapIntArray(new int[]{7}));
        msg$1.readXorByteSeq(playerGuid$1[i], Predef$.MODULE$.wrapIntArray(new int[]{6, 2}));
        msg$1.readXorByteSeq(accountId$1[i], Predef$.MODULE$.wrapIntArray(new int[]{2, 3}));
        String race = $this.Races().valueOf(msg$1.byteBuf().readByte());
        msg$1.readXorByteSeq(guildGuid$1[i], Predef$.MODULE$.wrapIntArray(new int[]{7}));
        msg$1.readXorByteSeq(accountId$1[i], Predef$.MODULE$.wrapIntArray(new int[]{1, 5, 6}));
        msg$1.readXorByteSeq(playerGuid$1[i], Predef$.MODULE$.wrapIntArray(new int[]{5}));
        msg$1.readXorByteSeq(accountId$1[i], Predef$.MODULE$.wrapIntArray(new int[]{0}));
        Some<String> gender = new Some<String>($this.Genders().valueOf(msg$1.byteBuf().readByte()));
        msg$1.readXorByteSeq(guildGuid$1[i], Predef$.MODULE$.wrapIntArray(new int[]{5}));
        byte lvl = msg$1.byteBuf().readByte();
        int zone = msg$1.byteBuf().readIntLE();
        return new WhoResponse(playerName, guildName, lvl, cls, race, gender, (String)GameResources$.MODULE$.AREA().getOrElse(BoxesRunTime.boxToInteger(zone), (Function0<String> & Serializable & scala.Serializable)() -> "Unknown Zone"));
    }

    public static final /* synthetic */ Tuple2 $anonfun$handleGuildQuery$2(Packet msg$3, IndexedSeq rankLengths$1, int i) {
        msg$3.byteBuf().skipBytes(4);
        int id = msg$3.byteBuf().readIntLE();
        String name = ((Object)msg$3.byteBuf().readCharSequence(BoxesRunTime.unboxToInt(rankLengths$1.apply(i)), Charset.forName("UTF-8"))).toString();
        return Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(BoxesRunTime.boxToInteger(id)), name);
    }

    public static final /* synthetic */ ChatMessage $anonfun$parseServerMotd$2(GamePacketHandlerMoP18414 $this, Packet msg$4, int messageLength) {
        String message = ((Object)msg$4.byteBuf().readCharSequence(messageLength, Charset.forName("UTF-8"))).toString();
        return new ChatMessage(0L, $this.ChatEvents().CHAT_MSG_SYSTEM(), message, None$.MODULE$);
    }

    public static final /* synthetic */ Tuple2 $anonfun$parseGuildRoster$2(Packet msg$5, int[] nameLengths$1, byte[][] guids$2, int[] oNoteLengths$1, int[] pNoteLengths$1, int i) {
        byte charClass = msg$5.byteBuf().readByte();
        msg$5.byteBuf().skipBytes(4);
        String name = ((Object)msg$5.byteBuf().readCharSequence(nameLengths$1[i], Charset.forName("UTF-8"))).toString();
        msg$5.readXorByteSeq(guids$2[i], Predef$.MODULE$.wrapIntArray(new int[]{0}));
        msg$5.byteBuf().skipBytes(24);
        byte level = msg$5.byteBuf().readByte();
        byte flags = msg$5.byteBuf().readByte();
        int zoneId = msg$5.byteBuf().readIntLE();
        msg$5.byteBuf().skipBytes(4);
        msg$5.readXorByteSeq(guids$2[i], Predef$.MODULE$.wrapIntArray(new int[]{3}));
        msg$5.byteBuf().skipBytes(8);
        msg$5.byteBuf().skipBytes(oNoteLengths$1[i]);
        float lastLogoff = msg$5.byteBuf().readFloatLE();
        msg$5.byteBuf().skipBytes(1);
        msg$5.byteBuf().skipBytes(4);
        msg$5.byteBuf().skipBytes(4);
        msg$5.readXorByteSeq(guids$2[i], Predef$.MODULE$.wrapIntArray(new int[]{5, 7}));
        msg$5.byteBuf().skipBytes(pNoteLengths$1[i]);
        msg$5.readXorByteSeq(guids$2[i], Predef$.MODULE$.wrapIntArray(new int[]{4}));
        msg$5.byteBuf().skipBytes(8);
        msg$5.byteBuf().skipBytes(4);
        msg$5.readXorByteSeq(guids$2[i], Predef$.MODULE$.wrapIntArray(new int[]{6, 1, 2}));
        boolean isOnline = (flags & 1) == 1;
        return Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(BoxesRunTime.boxToLong(ByteUtils$.MODULE$.bytesToLongLE(guids$2[i]))), new GuildMember(name, isOnline, charClass, level, zoneId, lastLogoff));
    }

    public GamePacketHandlerMoP18414(int realmId, String realmName, byte[] sessionKey, CommonConnectionCallback gameEventCallback) {
        this.realmId = realmId;
        this.sessionKey = sessionKey;
        super(realmId, realmName, sessionKey, gameEventCallback);
        GamePacketsMoP18414.$init$(this);
        this.addonInfo = (byte[])new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(new int[]{48, 5, 0, 0, 120, 156, 117, 147, 97, 110, 131, 48, 12, 133, 217, 61, 118, 132, 93, 162, 237, 86, 212, 169, 72, 172, 208, 254, 157, 76, 226, 130, 69, 136, 145, 9, 108, 237, 229, 183, 160, 73, 211, 38, 57, 252, 228, 123, 118, 226, 151, 231, 167, 44, 203, 182, 142, 238, 119, 16, 251, 190, 49, 29, 225, 130, 3, 250, 112, 62, 100, 15, 195, 199, 227, 49, 251, 199, 197, 116, 128, 236, 184, 189, 37, 56, 122, 208, 201, 108, 2, 177, 87, 217, 22, 164, 65, 153, 58, 30, 19, 56, 4, 135, 87, 66, 103, 11, 242, 52, 192, 168, 137, 200, 91, 242, 173, 222, 192, 129, 233, 11, 144, 30, 245, 169, 118, 224, 208, 91, 16, 13, 117, 224, 34, 108, 113, 210, 43, 29, 69, 171, 42, 88, 208, 94, 64, 8, 26, 135, 147, 38, 227, 161, 129, 112, 228, 54, 201, 106, 252, 12, 58, 28, 193, 132, 19, 144, 221, 11, 12, 122, 243, 243, 190, 20, 190, 146, 126, 244, 51, 54, 115, 91, 51, 59, 13, 190, 120, 195, 179, 15, 40, 175, 60, 139, 7, 167, 72, 114, 119, 27, 59, 117, 246, 188, 136, 230, 232, 134, 230, 69, 53, 203, 130, 122, 70, 242, 153, 156, 221, 130, 239, 211, 116, 199, 62, 8, 187, 180, 64, 37, 7, 63, 141, 104, 244, 27, 29, 2, 14, 27, 23, 39, 133, 100, 10, 87, 73, 197, 38, 134, 36, 149, 163, 85, 113, 30, 91, 1, 139, 42, 63, 50, 247, 177, 118, 207, 146, 190, 100, 1, 70, 88, 39, 188, 96, 9, 86, 33, 37, 134, 159, 29, 80, 235, 34, 77, 63, 223, 154, 28, 181, 234, 132, 87, 150, 54, 53, 105, 189, 110, 132, 238, 100, 77, 3, 22, 224, 161, 69, 109, 95, 106, 238, 81, 183, 183, 94, 109, 171, 122, 114, 250, 179, 70, 76, 30, 69, 101, 23, 38, 91, 5, 150, 120, 166, 238, 192, 165, 84, 255, 191, 205, 56, 133, 93, 199, 100, 80, 161, 107, 71, 189, 223, 102, 14, 221, 239, 226, 255, 85, 124, 197, 239, 27, 122, 235, 150, 196})).map((Function1<Object, Object> & Serializable & scala.Serializable)x$1 -> BoxesRunTime.boxToByte(GamePacketHandlerMoP18414.$anonfun$addonInfo$1(BoxesRunTime.unboxToInt(x$1))), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Byte()));
    }
}

