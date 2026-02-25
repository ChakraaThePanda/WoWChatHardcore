/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelOutboundInvoker;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import scala.Array$;
import scala.Function1;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Predef$ArrowAssoc$;
import scala.Some;
import scala.Tuple2;
import scala.collection.Seq;
import scala.collection.TraversableOnce;
import scala.collection.immutable.IndexedSeq$;
import scala.collection.immutable.Map;
import scala.collection.mutable.ArrayOps;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.NonLocalReturnControl;
import scala.runtime.RichInt$;
import scala.runtime.java8.JFunction1$mcVI$sp;
import scala.util.Random$;
import wowchat.common.ByteUtils$;
import wowchat.common.CommonConnectionCallback;
import wowchat.common.Global$;
import wowchat.common.Packet;
import wowchat.common.WowChatConfig$;
import wowchat.game.AuthChallengeMessage;
import wowchat.game.CharEnumMessage;
import wowchat.game.GamePacketHandlerWotLK;
import wowchat.game.GamePacketsCataclysm15595;
import wowchat.game.GuildInfo;
import wowchat.game.GuildMember;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@ScalaSignature(bytes="\u0006\u0001\u0005mf\u0001\u0002\u0011\"\u0001\u0019B\u0001B\f\u0001\u0003\u0002\u0003\u0006Ia\f\u0005\tk\u0001\u0011\t\u0011)A\u0005m!A\u0011\t\u0001B\u0001B\u0003%!\t\u0003\u0005I\u0001\t\u0005\t\u0015!\u0003J\u0011\u0015y\u0005\u0001\"\u0001Q\u0011\u00151\u0006\u0001\"\u0015X\u0011\u0015\u0001\u0007\u0001\"\u0011b\u0011\u0015Y\u0007\u0001\"\u0005m\u0011\u0015q\u0007\u0001\"\u0015p\u0011\u0015!\b\u0001\"\u0015v\u0011\u00159\b\u0001\"\u0015y\u0011\u0015q\b\u0001\"\u0015\u0000\u0011\u001d\tI\u0002\u0001C)\u00037Aq!a\n\u0001\t#\nI\u0003C\u0004\u0002,\u0001!\t&!\f\t\u000f\u0005]\u0002\u0001\"\u0015\u0002:!9\u00111\b\u0001\u0005R\u0005u\u0002bBA*\u0001\u0011E\u0013Q\u000b\u0005\b\u00033\u0002A\u0011BA.\u0011%\ty\u0006\u0001a\u0001\n\u0013\t\t\u0007C\u0005\u0002d\u0001\u0001\r\u0011\"\u0003\u0002f!9\u00111\u000e\u0001!B\u0013y\u0003\"CA7\u0001\u0001\u0007I\u0011BA1\u0011%\ty\u0007\u0001a\u0001\n\u0013\t\t\bC\u0004\u0002v\u0001\u0001\u000b\u0015B\u0018\t\u000f\u0005]\u0004\u0001\"\u0001\u0002z!9\u0011Q\u0011\u0001\u0005\u0002\u0005\u001d\u0005bBAH\u0001\u0011\u0005\u0011\u0011\u0013\u0005\b\u0003G\u0003A\u0011AAS\u0011\u001d\tY\u000b\u0001C\u0001\u0003[Cq!!.\u0001\t\u0003\t9LA\u0010HC6,\u0007+Y2lKRD\u0015M\u001c3mKJ\u001c\u0015\r^1dYf\u001cX.M\u001b6sUR!AI\u0012\u0002\t\u001d\fW.\u001a\u0006\u0002I\u00059qo\\<dQ\u0006$8\u0001A\n\u0004\u0001\u001dZ\u0003C\u0001\u0015*\u001b\u0005\t\u0013B\u0001\u0016\"\u0005Y9\u0015-\\3QC\u000e\\W\r\u001e%b]\u0012dWM],pi2[\u0005C\u0001\u0015-\u0013\ti\u0013EA\rHC6,\u0007+Y2lKR\u001c8)\u0019;bG2L8/\\\u00196ke*\u0014a\u0002:fC2l\u0017\n\u001a\t\u0003aMj\u0011!\r\u0006\u0002e\u0005)1oY1mC&\u0011A'\r\u0002\u0004\u0013:$\u0018!\u0003:fC2lg*Y7f!\t9dH\u0004\u00029yA\u0011\u0011(M\u0007\u0002u)\u00111(J\u0001\u0007yI|w\u000e\u001e \n\u0005u\n\u0014A\u0002)sK\u0012,g-\u0003\u0002@\u0001\n11\u000b\u001e:j]\u001eT!!P\u0019\u0002\u0015M,7o]5p].+\u0017\u0010E\u00021\u0007\u0016K!\u0001R\u0019\u0003\u000b\u0005\u0013(/Y=\u0011\u0005A2\u0015BA$2\u0005\u0011\u0011\u0015\u0010^3\u0002#\u001d\fW.Z#wK:$8)\u00197mE\u0006\u001c7\u000e\u0005\u0002K\u001b6\t1J\u0003\u0002MG\u000511m\\7n_:L!AT&\u00031\r{W.\\8o\u0007>tg.Z2uS>t7)\u00197mE\u0006\u001c7.\u0001\u0004=S:LGO\u0010\u000b\u0006#J\u001bF+\u0016\t\u0003Q\u0001AQAL\u0003A\u0002=BQ!N\u0003A\u0002YBQ!Q\u0003A\u0002\tCQ\u0001S\u0003A\u0002%\u000bAb\u00195b]:,G\u000eU1sg\u0016$\"\u0001W.\u0011\u0005AJ\u0016B\u0001.2\u0005\u0011)f.\u001b;\t\u000bq3\u0001\u0019A/\u0002\u00075\u001cx\r\u0005\u0002K=&\u0011ql\u0013\u0002\u0007!\u0006\u001c7.\u001a;\u0002!\t,\u0018\u000e\u001c3DQ\u0006$X*Z:tC\u001e,G\u0003B/cI\u001aDQaY\u0004A\u0002\u0015\u000b!\u0001\u001e9\t\u000b\u0015<\u0001\u0019\u0001\"\u0002!U$h\rO'fgN\fw-\u001a\"zi\u0016\u001c\b\"B4\b\u0001\u0004A\u0017aD;uMb\"\u0016M]4fi\nKH/Z:\u0011\u0007AJ')\u0003\u0002kc\t1q\n\u001d;j_:\fQcZ3u\u0007\"\fG\u000fU1dW\u0016$hI]8n)f\u0004X\r\u0006\u00020[\")1\r\u0003a\u0001\u000b\u0006\u0011\u0002/\u0019:tK\u0006+H\u000f[\"iC2dWM\\4f)\t\u00018\u000f\u0005\u0002)c&\u0011!/\t\u0002\u0015\u0003V$\bn\u00115bY2,gnZ3NKN\u001c\u0018mZ3\t\u000bqK\u0001\u0019A/\u0002#A\f'o]3BkRD'+Z:q_:\u001cX\r\u0006\u0002Fm\")AL\u0003a\u0001;\u0006i\u0001/\u0019:tK\u000eC\u0017M]#ok6$\"!_?\u0011\u0007AJ'\u0010\u0005\u0002)w&\u0011A0\t\u0002\u0010\u0007\"\f'/\u00128v[6+7o]1hK\")Al\u0003a\u0001;\u0006\u0001rO]5uKBc\u0017-_3s\u0019><\u0017N\u001c\u000b\u00041\u0006\u0005\u0001bBA\u0002\u0019\u0001\u0007\u0011QA\u0001\u0004_V$\b\u0003BA\u0004\u0003+i!!!\u0003\u000b\t\u0005-\u0011QB\u0001\u0007EV4g-\u001a:\u000b\t\u0005=\u0011\u0011C\u0001\u0006]\u0016$H/\u001f\u0006\u0003\u0003'\t!![8\n\t\u0005]\u0011\u0011\u0002\u0002\b\u0005f$XMQ;g\u0003A9(/\u001b;f\u0015>Lgn\u00115b]:,G\u000eF\u0004Y\u0003;\ty\"a\t\t\u000f\u0005\rQ\u00021\u0001\u0002\u0006!1\u0011\u0011E\u0007A\u0002=\n!!\u001b3\t\r\u0005\u0015R\u00021\u0001C\u0003A)HO\u001a\u001dDQ\u0006tg.\u001a7CsR,7/\u0001\brk\u0016\u0014\u0018pR;jY\u0012t\u0015-\\3\u0016\u0003a\u000b\u0001\u0003[1oI2,w)^5mIF+XM]=\u0015\t\u0005=\u0012Q\u0007\t\u0004Q\u0005E\u0012bAA\u001aC\tIq)^5mI&sgm\u001c\u0005\u00069>\u0001\r!X\u0001\u0017EVLG\u000eZ$vS2$'k\\:uKJ\u0004\u0016mY6fiV\tQ,\u0001\tqCJ\u001cXmR;jY\u0012\u0014vn\u001d;feR!\u0011qHA)!\u001d9\u0014\u0011IA#\u0003\u0017J1!a\u0011A\u0005\ri\u0015\r\u001d\t\u0004a\u0005\u001d\u0013bAA%c\t!Aj\u001c8h!\rA\u0013QJ\u0005\u0004\u0003\u001f\n#aC$vS2$W*Z7cKJDQ\u0001X\tA\u0002u\u000b\u0011\u0003]1sg\u0016tu\u000e^5gS\u000e\fG/[8o)\r1\u0014q\u000b\u0005\u00069J\u0001\r!X\u0001\u0016Q\u0006tG\r\\3`/>;vlQ(O\u001d\u0016\u001bE+S(O)\rA\u0016Q\f\u0005\u00069N\u0001\r!X\u0001\fE&$\bk\\:ji&|g.F\u00010\u0003=\u0011\u0017\u000e\u001e)pg&$\u0018n\u001c8`I\u0015\fHc\u0001-\u0002h!A\u0011\u0011N\u000b\u0002\u0002\u0003\u0007q&A\u0002yIE\nABY5u!>\u001c\u0018\u000e^5p]\u0002\nAAY=uK\u0006A!-\u001f;f?\u0012*\u0017\u000fF\u0002Y\u0003gB\u0001\"!\u001b\u0019\u0003\u0003\u0005\raL\u0001\u0006Ef$X\rI\u0001\noJLG/\u001a\"jiN$r\u0001WA>\u0003{\n\t\tC\u0004\u0002\u0004i\u0001\r!!\u0002\t\r\u0005}$\u00041\u00010\u0003\u00151\u0018\r\\;f\u0011\u0019\t\u0019I\u0007a\u0001_\u0005A!-\u001b;D_VtG/\u0001\u0005xe&$XMQ5u)\u0015A\u0016\u0011RAF\u0011\u001d\t\u0019a\u0007a\u0001\u0003\u000bAa!!$\u001c\u0001\u0004y\u0013a\u00012ji\u0006YqO]5uK\nKGoU3r)\u001dA\u00161SAK\u00033Cq!a\u0001\u001d\u0001\u0004\t)\u0001\u0003\u0004\u0002\u0018r\u0001\rAQ\u0001\u0006Ef$Xm\u001d\u0005\b\u00037c\u0002\u0019AAO\u0003\u001dIg\u000eZ5dKN\u0004B\u0001MAP_%\u0019\u0011\u0011U\u0019\u0003\u0015q\u0012X\r]3bi\u0016$g(\u0001\u0007xe&$X\rW8s\u0005f$X\rF\u0003Y\u0003O\u000bI\u000bC\u0004\u0002\u0004u\u0001\r!!\u0002\t\r\u00055T\u00041\u0001F\u0003=9(/\u001b;f1>\u0014()\u001f;f'\u0016\fHc\u0002-\u00020\u0006E\u00161\u0017\u0005\b\u0003\u0007q\u0002\u0019AA\u0003\u0011\u0019\t9J\ba\u0001\u0005\"9\u00111\u0014\u0010A\u0002\u0005u\u0015!\u00034mkND')\u001b;t)\rA\u0016\u0011\u0018\u0005\b\u0003\u0007y\u0002\u0019AA\u0003\u0001")
public class GamePacketHandlerCataclysm15595
extends GamePacketHandlerWotLK
implements GamePacketsCataclysm15595 {
    private final int realmId;
    private final byte[] sessionKey;
    private int bitPosition;
    private int byte;
    private final int CMSG_CHAR_ENUM;
    private final int SMSG_CHAR_ENUM;
    private final int CMSG_PLAYER_LOGIN;
    private final int CMSG_LOGOUT_REQUEST;
    private final int CMSG_NAME_QUERY;
    private final int SMSG_NAME_QUERY;
    private final int CMSG_WHO;
    private final int SMSG_WHO;
    private final int CMSG_GUILD_QUERY;
    private final int SMSG_GUILD_QUERY;
    private final int CMSG_GUILD_ROSTER;
    private final int SMSG_GUILD_ROSTER;
    private final int SMSG_GUILD_EVENT;
    private final int SMSG_MESSAGECHAT;
    private final int SMSG_GM_MESSAGECHAT;
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
    private final int WOW_CONNECTION;
    private final int CMSG_MESSAGECHAT_AFK;
    private final int CMSG_MESSAGECHAT_BATTLEGROUND;
    private final int CMSG_MESSAGECHAT_CHANNEL;
    private final int CMSG_MESSAGECHAT_DND;
    private final int CMSG_MESSAGECHAT_EMOTE;
    private final int CMSG_MESSAGECHAT_GUILD;
    private final int CMSG_MESSAGECHAT_OFFICER;
    private final int CMSG_MESSAGECHAT_PARTY;
    private final int CMSG_MESSAGECHAT_SAY;
    private final int CMSG_MESSAGECHAT_WHISPER;
    private final int CMSG_MESSAGECHAT_YELL;
    private final int SMSG_MOTD;

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
    public int CMSG_WHO() {
        return this.CMSG_WHO;
    }

    @Override
    public int SMSG_WHO() {
        return this.SMSG_WHO;
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
    public int SMSG_MESSAGECHAT() {
        return this.SMSG_MESSAGECHAT;
    }

    @Override
    public int SMSG_GM_MESSAGECHAT() {
        return this.SMSG_GM_MESSAGECHAT;
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
    public int WOW_CONNECTION() {
        return this.WOW_CONNECTION;
    }

    @Override
    public int CMSG_MESSAGECHAT_AFK() {
        return this.CMSG_MESSAGECHAT_AFK;
    }

    @Override
    public int CMSG_MESSAGECHAT_BATTLEGROUND() {
        return this.CMSG_MESSAGECHAT_BATTLEGROUND;
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
    public int SMSG_MOTD() {
        return this.SMSG_MOTD;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$CMSG_CHAR_ENUM_$eq(int x$1) {
        this.CMSG_CHAR_ENUM = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$SMSG_CHAR_ENUM_$eq(int x$1) {
        this.SMSG_CHAR_ENUM = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$CMSG_PLAYER_LOGIN_$eq(int x$1) {
        this.CMSG_PLAYER_LOGIN = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$CMSG_LOGOUT_REQUEST_$eq(int x$1) {
        this.CMSG_LOGOUT_REQUEST = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$CMSG_NAME_QUERY_$eq(int x$1) {
        this.CMSG_NAME_QUERY = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$SMSG_NAME_QUERY_$eq(int x$1) {
        this.SMSG_NAME_QUERY = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$CMSG_WHO_$eq(int x$1) {
        this.CMSG_WHO = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$SMSG_WHO_$eq(int x$1) {
        this.SMSG_WHO = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$CMSG_GUILD_QUERY_$eq(int x$1) {
        this.CMSG_GUILD_QUERY = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$SMSG_GUILD_QUERY_$eq(int x$1) {
        this.SMSG_GUILD_QUERY = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$CMSG_GUILD_ROSTER_$eq(int x$1) {
        this.CMSG_GUILD_ROSTER = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$SMSG_GUILD_ROSTER_$eq(int x$1) {
        this.SMSG_GUILD_ROSTER = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$SMSG_GUILD_EVENT_$eq(int x$1) {
        this.SMSG_GUILD_EVENT = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$SMSG_MESSAGECHAT_$eq(int x$1) {
        this.SMSG_MESSAGECHAT = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$SMSG_GM_MESSAGECHAT_$eq(int x$1) {
        this.SMSG_GM_MESSAGECHAT = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$CMSG_JOIN_CHANNEL_$eq(int x$1) {
        this.CMSG_JOIN_CHANNEL = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$SMSG_CHANNEL_NOTIFY_$eq(int x$1) {
        this.SMSG_CHANNEL_NOTIFY = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$SMSG_NOTIFICATION_$eq(int x$1) {
        this.SMSG_NOTIFICATION = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$CMSG_PING_$eq(int x$1) {
        this.CMSG_PING = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$SMSG_AUTH_CHALLENGE_$eq(int x$1) {
        this.SMSG_AUTH_CHALLENGE = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$CMSG_AUTH_CHALLENGE_$eq(int x$1) {
        this.CMSG_AUTH_CHALLENGE = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$SMSG_AUTH_RESPONSE_$eq(int x$1) {
        this.SMSG_AUTH_RESPONSE = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$SMSG_LOGIN_VERIFY_WORLD_$eq(int x$1) {
        this.SMSG_LOGIN_VERIFY_WORLD = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$SMSG_SERVER_MESSAGE_$eq(int x$1) {
        this.SMSG_SERVER_MESSAGE = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$SMSG_WARDEN_DATA_$eq(int x$1) {
        this.SMSG_WARDEN_DATA = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$CMSG_WARDEN_DATA_$eq(int x$1) {
        this.CMSG_WARDEN_DATA = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$SMSG_INVALIDATE_PLAYER_$eq(int x$1) {
        this.SMSG_INVALIDATE_PLAYER = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$CMSG_KEEP_ALIVE_$eq(int x$1) {
        this.CMSG_KEEP_ALIVE = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$SMSG_TIME_SYNC_REQ_$eq(int x$1) {
        this.SMSG_TIME_SYNC_REQ = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$CMSG_TIME_SYNC_RESP_$eq(int x$1) {
        this.CMSG_TIME_SYNC_RESP = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$WOW_CONNECTION_$eq(int x$1) {
        this.WOW_CONNECTION = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$CMSG_MESSAGECHAT_AFK_$eq(int x$1) {
        this.CMSG_MESSAGECHAT_AFK = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$CMSG_MESSAGECHAT_BATTLEGROUND_$eq(int x$1) {
        this.CMSG_MESSAGECHAT_BATTLEGROUND = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$CMSG_MESSAGECHAT_CHANNEL_$eq(int x$1) {
        this.CMSG_MESSAGECHAT_CHANNEL = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$CMSG_MESSAGECHAT_DND_$eq(int x$1) {
        this.CMSG_MESSAGECHAT_DND = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$CMSG_MESSAGECHAT_EMOTE_$eq(int x$1) {
        this.CMSG_MESSAGECHAT_EMOTE = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$CMSG_MESSAGECHAT_GUILD_$eq(int x$1) {
        this.CMSG_MESSAGECHAT_GUILD = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$CMSG_MESSAGECHAT_OFFICER_$eq(int x$1) {
        this.CMSG_MESSAGECHAT_OFFICER = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$CMSG_MESSAGECHAT_PARTY_$eq(int x$1) {
        this.CMSG_MESSAGECHAT_PARTY = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$CMSG_MESSAGECHAT_SAY_$eq(int x$1) {
        this.CMSG_MESSAGECHAT_SAY = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$CMSG_MESSAGECHAT_WHISPER_$eq(int x$1) {
        this.CMSG_MESSAGECHAT_WHISPER = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$CMSG_MESSAGECHAT_YELL_$eq(int x$1) {
        this.CMSG_MESSAGECHAT_YELL = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsCataclysm15595$_setter_$SMSG_MOTD_$eq(int x$1) {
        this.SMSG_MOTD = x$1;
    }

    @Override
    public void channelParse(Packet msg) {
        int n = msg.id();
        if (this.WOW_CONNECTION() == n) {
            this.handle_WOW_CONNECTION(msg);
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
            this.writeBits(out, ((Object)utf8TargetBytes).length, 10);
            return BoxedUnit.UNIT;
        });
        this.writeBits(out, utf8MessageBytes.length, 9);
        this.flushBits(out);
        out.writeBytes(utf8MessageBytes);
        Object object = utf8TargetBytes2.isDefined() ? out.writeBytes(utf8TargetBytes2.get()) : BoxedUnit.UNIT;
        return new Packet(this.getChatPacketFromType(tp), out);
    }

    public int getChatPacketFromType(byte tp) {
        int n;
        byte by = tp;
        if (this.ChatEvents().CHAT_MSG_CHANNEL() == by) {
            n = this.CMSG_MESSAGECHAT_CHANNEL();
        } else if (this.ChatEvents().CHAT_MSG_EMOTE() == by) {
            n = this.CMSG_MESSAGECHAT_EMOTE();
        } else if (this.ChatEvents().CHAT_MSG_GUILD() == by) {
            n = this.CMSG_MESSAGECHAT_GUILD();
        } else if (this.ChatEvents().CHAT_MSG_OFFICER() == by) {
            n = this.CMSG_MESSAGECHAT_OFFICER();
        } else if (this.ChatEvents().CHAT_MSG_SAY() == by) {
            n = this.CMSG_MESSAGECHAT_SAY();
        } else if (this.ChatEvents().CHAT_MSG_WHISPER() == by) {
            n = this.CMSG_MESSAGECHAT_WHISPER();
        } else if (this.ChatEvents().CHAT_MSG_YELL() == by) {
            n = this.CMSG_MESSAGECHAT_YELL();
        } else {
            throw new UnsupportedOperationException(new StringBuilder(28).append("Type ").append(this.ChatEvents().valueOf(tp)).append(" cannot be sent to WoW!").toString());
        }
        return n;
    }

    @Override
    public AuthChallengeMessage parseAuthChallenge(Packet msg) {
        byte[] account = Global$.MODULE$.config().wow().account();
        msg.byteBuf().skipBytes(32);
        int serverSeed = msg.byteBuf().readInt();
        int clientSeed = Random$.MODULE$.nextInt();
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.update(account);
        md.update((byte[])Array$.MODULE$.apply(Predef$.MODULE$.wrapByteArray(new byte[]{0, 0, 0, 0}), ClassTag$.MODULE$.Byte()));
        md.update(ByteUtils$.MODULE$.intToBytes(clientSeed));
        md.update(ByteUtils$.MODULE$.intToBytes(serverSeed));
        md.update(this.sessionKey);
        byte[] digest = md.digest();
        ByteBuf out = PooledByteBufAllocator.DEFAULT.buffer(200, 400);
        out.writeShortLE(0);
        out.writeBytes(new byte[9]);
        out.writeByte(digest[10]);
        out.writeByte(digest[18]);
        out.writeByte(digest[12]);
        out.writeByte(digest[5]);
        out.writeBytes(new byte[8]);
        out.writeByte(digest[15]);
        out.writeByte(digest[9]);
        out.writeByte(digest[19]);
        out.writeByte(digest[4]);
        out.writeByte(digest[7]);
        out.writeByte(digest[16]);
        out.writeByte(digest[3]);
        out.writeShortLE(WowChatConfig$.MODULE$.getGameBuild());
        out.writeByte(digest[8]);
        out.writeIntLE(this.realmId);
        out.writeByte(0);
        out.writeByte(digest[17]);
        out.writeByte(digest[6]);
        out.writeByte(digest[0]);
        out.writeByte(digest[1]);
        out.writeByte(digest[11]);
        out.writeInt(clientSeed);
        out.writeByte(digest[2]);
        out.writeIntLE(0);
        out.writeByte(digest[14]);
        out.writeByte(digest[13]);
        out.writeIntLE(this.addonInfo().length);
        out.writeBytes(this.addonInfo());
        out.writeByte(account.length >> 5);
        out.writeByte(account.length << 3);
        out.writeBytes(account);
        return new AuthChallengeMessage(this.sessionKey, out);
    }

    @Override
    public byte parseAuthResponse(Packet msg) {
        ByteBuf byteBuf;
        if (msg.byteBuf().readableBytes() >= 17) {
            byteBuf = msg.byteBuf().skipBytes(16);
        } else if (msg.byteBuf().readableBytes() >= 2) {
            byteBuf = msg.byteBuf().skipBytes(1);
        } else {
            return (byte)this.AuthResponseCodes().AUTH_FAILED();
        }
        return super.parseAuthResponse(msg);
    }

    @Override
    public Option<CharEnumMessage> parseCharEnum(Packet msg) {
        Option option;
        Object object = new Object();
        try {
            byte[] characterBytes = Global$.MODULE$.config().wow().character().toLowerCase().getBytes("UTF-8");
            msg.readBits(24);
            int charactersNum = msg.readBits(17);
            byte[][] guids = new byte[charactersNum][];
            byte[][] guildGuids = new byte[charactersNum][];
            int[] nameLenghts = new int[charactersNum];
            RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), charactersNum).foreach$mVc$sp((JFunction1$mcVI$sp & scala.Serializable)i -> {
                guids$1[i] = new byte[8];
                guildGuids$1[i] = new byte[8];
                msg.readBitSeq(guids[i], Predef$.MODULE$.wrapIntArray(new int[]{3}));
                msg.readBitSeq(guildGuids[i], Predef$.MODULE$.wrapIntArray(new int[]{1, 7, 2}));
                nameLenghts$1[i] = msg.readBits(7);
                msg.readBitSeq(guids[i], Predef$.MODULE$.wrapIntArray(new int[]{4, 7}));
                msg.readBitSeq(guildGuids[i], Predef$.MODULE$.wrapIntArray(new int[]{3}));
                msg.readBitSeq(guids[i], Predef$.MODULE$.wrapIntArray(new int[]{5}));
                msg.readBitSeq(guildGuids[i], Predef$.MODULE$.wrapIntArray(new int[]{6}));
                msg.readBitSeq(guids[i], Predef$.MODULE$.wrapIntArray(new int[]{1}));
                msg.readBitSeq(guildGuids[i], Predef$.MODULE$.wrapIntArray(new int[]{5, 4}));
                msg.readBit();
                msg.readBitSeq(guids[i], Predef$.MODULE$.wrapIntArray(new int[]{0, 2, 6}));
                msg.readBitSeq(guildGuids[i], Predef$.MODULE$.wrapIntArray(new int[]{0}));
            });
            RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), charactersNum).foreach((Function1<Object, ByteBuf> & Serializable & scala.Serializable)i -> GamePacketHandlerCataclysm15595.$anonfun$parseCharEnum$2(msg, guildGuids, guids, nameLenghts, characterBytes, object, BoxesRunTime.unboxToInt(i)));
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
        this.writeBitSeq(out, bytes, Predef$.MODULE$.wrapIntArray(new int[]{2, 3, 0, 6, 4, 5, 1, 7}));
        this.writeXorByteSeq(out, bytes, Predef$.MODULE$.wrapIntArray(new int[]{2, 7, 0, 3, 5, 6, 1, 4}));
    }

    @Override
    public void writeJoinChannel(ByteBuf out, int id, byte[] utf8ChannelBytes) {
        out.writeIntLE(id);
        this.writeBit(out, 0);
        this.writeBit(out, 0);
        this.writeBits(out, utf8ChannelBytes.length, 8);
        this.writeBits(out, 0, 8);
        this.flushBits(out);
        out.writeBytes(utf8ChannelBytes);
    }

    @Override
    public void queryGuildName() {
        ByteBuf out = PooledByteBufAllocator.DEFAULT.buffer(16, 16);
        out.writeLongLE(this.guildGuid());
        out.writeLongLE(BoxesRunTime.unboxToLong(this.selfCharacterId().get()));
        ((ChannelOutboundInvoker)this.ctx().get()).writeAndFlush(new Packet(this.CMSG_GUILD_QUERY(), out));
    }

    @Override
    public GuildInfo handleGuildQuery(Packet msg) {
        msg.byteBuf().skipBytes(4);
        return super.handleGuildQuery(msg);
    }

    @Override
    public Packet buildGuildRosterPacket() {
        ByteBuf byteBuf = PooledByteBufAllocator.DEFAULT.buffer(18, 18);
        byteBuf.writeBytes(new byte[18]);
        return new Packet(this.CMSG_GUILD_ROSTER(), byteBuf);
    }

    @Override
    public Map<Object, GuildMember> parseGuildRoster(Packet msg) {
        int motdLength = msg.readBits(11);
        int count = msg.readBits(18);
        byte[][] guids = new byte[count][];
        int[] pNoteLengths = new int[count];
        int[] oNoteLengths = new int[count];
        int[] nameLengths = new int[count];
        RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), count).foreach$mVc$sp((JFunction1$mcVI$sp & scala.Serializable)i -> {
            guids$2[i] = new byte[8];
            msg.readBitSeq(guids[i], Predef$.MODULE$.wrapIntArray(new int[]{3, 4}));
            msg.readBits(2);
            pNoteLengths$1[i] = msg.readBits(8);
            oNoteLengths$1[i] = msg.readBits(8);
            msg.readBitSeq(guids[i], Predef$.MODULE$.wrapIntArray(new int[]{0}));
            nameLengths$1[i] = msg.readBits(7);
            msg.readBitSeq(guids[i], Predef$.MODULE$.wrapIntArray(new int[]{1, 2, 6, 5, 7}));
        });
        int gInfoLength = msg.readBits(12);
        Map<Object, GuildMember> guildRosterMap = ((TraversableOnce)RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), count).map((Function1<Object, Tuple2> & Serializable & scala.Serializable)i -> GamePacketHandlerCataclysm15595.$anonfun$parseGuildRoster$2(msg, guids, pNoteLengths, oNoteLengths, nameLengths, BoxesRunTime.unboxToInt(i)), IndexedSeq$.MODULE$.canBuildFrom())).toMap(Predef$.MODULE$.$conforms());
        msg.byteBuf().skipBytes(gInfoLength);
        this.guildMotd_$eq(new Some<String>(((Object)msg.byteBuf().readCharSequence(motdLength, Charset.forName("UTF-8"))).toString()));
        return guildRosterMap;
    }

    @Override
    public String parseNotification(Packet msg) {
        int length = msg.readBits(13);
        return ((Object)msg.byteBuf().readCharSequence(length, Charset.forName("UTF-8"))).toString();
    }

    private void handle_WOW_CONNECTION(Packet msg) {
        ByteBuf byteBuf = PooledByteBufAllocator.DEFAULT.buffer(48, 48);
        String connectionString = "RLD OF WARCRAFT CONNECTION - CLIENT TO SERVER";
        byteBuf.writeBytes(connectionString.getBytes());
        byteBuf.writeByte(0);
        ((ChannelOutboundInvoker)this.ctx().get()).writeAndFlush(new Packet(this.WOW_CONNECTION(), byteBuf));
    }

    private int bitPosition() {
        return this.bitPosition;
    }

    private void bitPosition_$eq(int x$1) {
        this.bitPosition = x$1;
    }

    private int byte() {
        return this.byte;
    }

    private void byte_$eq(int x$1) {
        this.byte = x$1;
    }

    public void writeBits(ByteBuf out, int value, int bitCount) {
        RichInt$.MODULE$.to$extension0(Predef$.MODULE$.intWrapper(bitCount - 1), 0).by(-1).foreach$mVc$sp((JFunction1$mcVI$sp & scala.Serializable)i -> this.writeBit(out, value >> i & 1));
    }

    public void writeBit(ByteBuf out, int bit) {
        block1: {
            this.bitPosition_$eq(this.bitPosition() - 1);
            if (bit != 0) {
                this.byte_$eq(this.byte() | 1 << this.bitPosition());
            }
            if (this.bitPosition() != 0) break block1;
            this.flushBits(out);
        }
    }

    public void writeBitSeq(ByteBuf out, byte[] bytes, Seq<Object> indices) {
        indices.foreach((JFunction1$mcVI$sp & scala.Serializable)i -> this.writeBit(out, bytes[i]));
    }

    public void writeXorByte(ByteBuf out, byte by) {
        block0: {
            if (by == 0) break block0;
            out.writeByte((byte)(by ^ 1));
        }
    }

    public void writeXorByteSeq(ByteBuf out, byte[] bytes, Seq<Object> indices) {
        indices.foreach((JFunction1$mcVI$sp & scala.Serializable)i -> this.writeXorByte(out, bytes[i]));
    }

    public void flushBits(ByteBuf out) {
        if (this.bitPosition() == 8) {
            return;
        }
        out.writeByte((byte)(this.byte() & 0xFF));
        this.bitPosition_$eq(8);
        this.byte_$eq(0);
    }

    public static final /* synthetic */ ByteBuf $anonfun$parseCharEnum$2(Packet msg$1, byte[][] guildGuids$1, byte[][] guids$1, int[] nameLenghts$1, byte[] characterBytes$1, Object nonLocalReturnKey1$1, int i) {
        msg$1.byteBuf().skipBytes(1);
        msg$1.byteBuf().skipBytes(207);
        msg$1.byteBuf().readIntLE();
        msg$1.readXorByteSeq(guildGuids$1[i], Predef$.MODULE$.wrapIntArray(new int[]{2}));
        msg$1.byteBuf().skipBytes(2);
        msg$1.readXorByteSeq(guildGuids$1[i], Predef$.MODULE$.wrapIntArray(new int[]{3}));
        msg$1.byteBuf().skipBytes(9);
        msg$1.readXorByteSeq(guids$1[i], Predef$.MODULE$.wrapIntArray(new int[]{4}));
        msg$1.byteBuf().readIntLE();
        msg$1.readXorByteSeq(guildGuids$1[i], Predef$.MODULE$.wrapIntArray(new int[]{5}));
        msg$1.byteBuf().skipBytes(4);
        msg$1.readXorByteSeq(guildGuids$1[i], Predef$.MODULE$.wrapIntArray(new int[]{6}));
        msg$1.byteBuf().skipBytes(4);
        msg$1.readXorByteSeq(guids$1[i], Predef$.MODULE$.wrapIntArray(new int[]{3}));
        msg$1.byteBuf().skipBytes(9);
        msg$1.readXorByteSeq(guids$1[i], Predef$.MODULE$.wrapIntArray(new int[]{7}));
        msg$1.byteBuf().skipBytes(1);
        String name = ((Object)msg$1.byteBuf().readCharSequence(nameLenghts$1[i], Charset.forName("UTF-8"))).toString();
        msg$1.byteBuf().skipBytes(1);
        msg$1.readXorByteSeq(guids$1[i], Predef$.MODULE$.wrapIntArray(new int[]{0, 2}));
        msg$1.readXorByteSeq(guildGuids$1[i], Predef$.MODULE$.wrapIntArray(new int[]{1, 7}));
        msg$1.byteBuf().skipBytes(5);
        byte race = msg$1.byteBuf().readByte();
        msg$1.byteBuf().skipBytes(1);
        msg$1.readXorByteSeq(guids$1[i], Predef$.MODULE$.wrapIntArray(new int[]{6}));
        msg$1.readXorByteSeq(guildGuids$1[i], Predef$.MODULE$.wrapIntArray(new int[]{4, 0}));
        msg$1.readXorByteSeq(guids$1[i], Predef$.MODULE$.wrapIntArray(new int[]{5, 1}));
        if (new ArrayOps.ofByte(Predef$.MODULE$.byteArrayOps(name.toLowerCase().getBytes("UTF-8"))).sameElements(Predef$.MODULE$.wrapByteArray(characterBytes$1))) {
            throw new NonLocalReturnControl<Some<CharEnumMessage>>(nonLocalReturnKey1$1, new Some<CharEnumMessage>(new CharEnumMessage(name, ByteUtils$.MODULE$.bytesToLongLE(guids$1[i]), race, ByteUtils$.MODULE$.bytesToLongLE(guildGuids$1[i]))));
        }
        return msg$1.byteBuf().skipBytes(4);
    }

    public static final /* synthetic */ Tuple2 $anonfun$parseGuildRoster$2(Packet msg$2, byte[][] guids$2, int[] pNoteLengths$1, int[] oNoteLengths$1, int[] nameLengths$1, int i) {
        byte charClass = msg$2.byteBuf().readByte();
        msg$2.byteBuf().skipBytes(4);
        msg$2.readXorByteSeq(guids$2[i], Predef$.MODULE$.wrapIntArray(new int[]{0}));
        msg$2.byteBuf().skipBytes(40);
        msg$2.readXorByteSeq(guids$2[i], Predef$.MODULE$.wrapIntArray(new int[]{2}));
        byte flags = msg$2.byteBuf().readByte();
        int zoneId = msg$2.byteBuf().readIntLE();
        msg$2.byteBuf().skipBytes(8);
        msg$2.readXorByteSeq(guids$2[i], Predef$.MODULE$.wrapIntArray(new int[]{7}));
        msg$2.byteBuf().skipBytes(4);
        msg$2.byteBuf().skipBytes(pNoteLengths$1[i]);
        msg$2.readXorByteSeq(guids$2[i], Predef$.MODULE$.wrapIntArray(new int[]{3}));
        byte level = msg$2.byteBuf().readByte();
        msg$2.byteBuf().skipBytes(4);
        msg$2.readXorByteSeq(guids$2[i], Predef$.MODULE$.wrapIntArray(new int[]{5, 4}));
        msg$2.byteBuf().skipBytes(1);
        msg$2.readXorByteSeq(guids$2[i], Predef$.MODULE$.wrapIntArray(new int[]{1}));
        float lastLogoff = msg$2.byteBuf().readFloatLE();
        msg$2.byteBuf().skipBytes(oNoteLengths$1[i]);
        msg$2.readXorByteSeq(guids$2[i], Predef$.MODULE$.wrapIntArray(new int[]{6}));
        String name = ((Object)msg$2.byteBuf().readCharSequence(nameLengths$1[i], Charset.forName("UTF-8"))).toString();
        boolean isOnline = (flags & 1) == 1;
        return Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(BoxesRunTime.boxToLong(ByteUtils$.MODULE$.bytesToLongLE(guids$2[i]))), new GuildMember(name, isOnline, charClass, level, zoneId, lastLogoff));
    }

    public GamePacketHandlerCataclysm15595(int realmId, String realmName, byte[] sessionKey, CommonConnectionCallback gameEventCallback) {
        this.realmId = realmId;
        this.sessionKey = sessionKey;
        super(realmId, realmName, sessionKey, gameEventCallback);
        GamePacketsCataclysm15595.$init$(this);
        this.bitPosition = 8;
        this.byte = 0;
    }
}

