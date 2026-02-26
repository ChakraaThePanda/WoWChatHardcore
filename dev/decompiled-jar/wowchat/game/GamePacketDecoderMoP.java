/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import io.netty.buffer.ByteBuf;
import java.util.zip.Inflater;
import scala.Tuple2;
import scala.Tuple2$mcII$sp;
import scala.reflect.ScalaSignature;
import wowchat.common.ByteUtils$;
import wowchat.game.GameHeaderCrypt;
import wowchat.game.GamePacketDecoderCataclysm;
import wowchat.game.GamePacketsMoP18414;

@ScalaSignature(bytes="\u0006\u0001Y3A!\u0003\u0006\u0001\u001f!)q\u0003\u0001C\u00011!9!\u0004\u0001b\u0001\n#Z\u0002B\u0002\u0014\u0001A\u0003%A\u0004C\u0003(\u0001\u0011\u0005\u0003\u0006C\u0003?\u0001\u0011\u0005s\bC\u0003G\u0001\u0011\u0005s\tC\u0003K\u0001\u0011\u00053\nC\u0003Q\u0001\u0011\u0005\u0013K\u0001\u000bHC6,\u0007+Y2lKR$UmY8eKJlu\u000e\u0015\u0006\u0003\u00171\tAaZ1nK*\tQ\"A\u0004x_^\u001c\u0007.\u0019;\u0004\u0001M\u0019\u0001\u0001\u0005\u000b\u0011\u0005E\u0011R\"\u0001\u0006\n\u0005MQ!AG$b[\u0016\u0004\u0016mY6fi\u0012+7m\u001c3fe\u000e\u000bG/Y2msNl\u0007CA\t\u0016\u0013\t1\"BA\nHC6,\u0007+Y2lKR\u001cXj\u001c)2qQ\nD'\u0001\u0004=S:LGO\u0010\u000b\u00023A\u0011\u0011\u0003A\u0001\tS:4G.\u0019;feV\tA\u0004\u0005\u0002\u001eI5\taD\u0003\u0002 A\u0005\u0019!0\u001b9\u000b\u0005\u0005\u0012\u0013\u0001B;uS2T\u0011aI\u0001\u0005U\u00064\u0018-\u0003\u0002&=\tA\u0011J\u001c4mCR,'/A\u0005j]\u001ad\u0017\r^3sA\u0005y\u0001/\u0019:tK\u001e\u000bW.\u001a%fC\u0012,'\u000f\u0006\u0002*eA!!&L\u00180\u001b\u0005Y#\"\u0001\u0017\u0002\u000bM\u001c\u0017\r\\1\n\u00059Z#A\u0002+va2,'\u0007\u0005\u0002+a%\u0011\u0011g\u000b\u0002\u0004\u0013:$\b\"B\u001a\u0005\u0001\u0004!\u0014AA5o!\t)D(D\u00017\u0015\t9\u0004(\u0001\u0004ck\u001a4WM\u001d\u0006\u0003si\nQA\\3uifT\u0011aO\u0001\u0003S>L!!\u0010\u001c\u0003\u000f\tKH/\u001a\"vM\u0006A\u0002/\u0019:tK\u001e\u000bW.\u001a%fC\u0012,'/\u00128def\u0004H/\u001a3\u0015\u0007%\u0002\u0015\tC\u00034\u000b\u0001\u0007A\u0007C\u0003C\u000b\u0001\u00071)A\u0003def\u0004H\u000f\u0005\u0002\u0012\t&\u0011QI\u0003\u0002\u0010\u000f\u0006lW\rS3bI\u0016\u00148I]=qi\u0006\u0019r-\u001a;EK\u000e|W\u000e\u001d:fgN,GmU5{KR\u0011q\u0006\u0013\u0005\u0006\u0013\u001a\u0001\r\u0001N\u0001\bEf$XMQ;g\u0003E9W\r\u001e#fG>l\u0007O]3tg\u0016$\u0017\n\u001a\u000b\u0004_1s\u0005\"B'\b\u0001\u0004y\u0013AA5e\u0011\u0015yu\u00011\u00015\u0003\r\u0011WOZ\u0001\rSN\u001cu.\u001c9sKN\u001cX\r\u001a\u000b\u0003%V\u0003\"AK*\n\u0005Q[#a\u0002\"p_2,\u0017M\u001c\u0005\u0006\u001b\"\u0001\ra\f")
public class GamePacketDecoderMoP
extends GamePacketDecoderCataclysm
implements GamePacketsMoP18414 {
    private final Inflater inflater;
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
    public Inflater inflater() {
        return this.inflater;
    }

    @Override
    public Tuple2<Object, Object> parseGameHeader(ByteBuf in) {
        int size = in.readShortLE() - 2;
        short id = in.readShortLE();
        return new Tuple2$mcII$sp(id, size);
    }

    @Override
    public Tuple2<Object, Object> parseGameHeaderEncrypted(ByteBuf in, GameHeaderCrypt crypt) {
        byte[] header = new byte[this.HEADER_LENGTH()];
        in.readBytes(header);
        byte[] decrypted = crypt.decrypt(header);
        int raw = (int)ByteUtils$.MODULE$.bytesToLongLE(decrypted);
        int id = raw & 0x1FFF;
        int size = raw >>> 13;
        return new Tuple2$mcII$sp(id, size);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public int getDecompressedSize(ByteBuf byteBuf) {
        void var2_2;
        int size = byteBuf.readIntLE();
        byteBuf.skipBytes(8);
        return (int)var2_2;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public int getDecompressedId(int id, ByteBuf buf) {
        void var3_3;
        short newId = buf.readShortLE();
        buf.skipBytes(2);
        return (int)var3_3;
    }

    @Override
    public boolean isCompressed(int id) {
        return id == this.SMSG_COMPRESSED_DATA();
    }

    public GamePacketDecoderMoP() {
        GamePacketsMoP18414.$init$(this);
        this.inflater = new Inflater(true);
    }
}

