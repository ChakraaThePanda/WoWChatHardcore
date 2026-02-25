/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import java.util.zip.Inflater;
import scala.Tuple2;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import wowchat.game.GamePacketDecoderWotLK;
import wowchat.game.GamePacketsCataclysm15595;

@ScalaSignature(bytes="\u0006\u0001m3A!\u0003\u0006\u0001\u001f!)q\u0003\u0001C\u00011!9!\u0004\u0001b\u0001\n#Y\u0002B\u0002\u0014\u0001A\u0003%A\u0004C\u0003(\u0001\u0011\u0005\u0003\u0006C\u0003<\u0001\u0011\u0005C\bC\u0003N\u0001\u0011\u0005a\nC\u0003Q\u0001\u0011\u0005\u0011\u000bC\u0003V\u0001\u0011\u0005aK\u0001\u000eHC6,\u0007+Y2lKR$UmY8eKJ\u001c\u0015\r^1dYf\u001cXN\u0003\u0002\f\u0019\u0005!q-Y7f\u0015\u0005i\u0011aB<po\u000eD\u0017\r^\u0002\u0001'\r\u0001\u0001\u0003\u0006\t\u0003#Ii\u0011AC\u0005\u0003')\u0011acR1nKB\u000b7m[3u\t\u0016\u001cw\u000eZ3s/>$Hj\u0013\t\u0003#UI!A\u0006\u0006\u00033\u001d\u000bW.\u001a)bG.,Go]\"bi\u0006\u001cG._:ncU*\u0014(N\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003e\u0001\"!\u0005\u0001\u0002\u0011%tg\r\\1uKJ,\u0012\u0001\b\t\u0003;\u0011j\u0011A\b\u0006\u0003?\u0001\n1A_5q\u0015\t\t#%\u0001\u0003vi&d'\"A\u0012\u0002\t)\fg/Y\u0005\u0003Ky\u0011\u0001\"\u00138gY\u0006$XM]\u0001\nS:4G.\u0019;fe\u0002\nqb\u00195b]:,G.\u00138bGRLg/\u001a\u000b\u0003S=\u0002\"AK\u0017\u000e\u0003-R\u0011\u0001L\u0001\u0006g\u000e\fG.Y\u0005\u0003]-\u0012A!\u00168ji\")\u0001\u0007\u0002a\u0001c\u0005\u00191\r\u001e=\u0011\u0005IJT\"A\u001a\u000b\u0005Q*\u0014aB2iC:tW\r\u001c\u0006\u0003m]\nQA\\3uifT\u0011\u0001O\u0001\u0003S>L!AO\u001a\u0003+\rC\u0017M\u001c8fY\"\u000bg\u000e\u001a7fe\u000e{g\u000e^3yi\u0006QA-Z2p[B\u0014Xm]:\u0015\u0007uJ5\n\u0005\u0003+}\u0001\u001b\u0015BA ,\u0005\u0019!V\u000f\u001d7feA\u0011!&Q\u0005\u0003\u0005.\u00121!\u00138u!\t!u)D\u0001F\u0015\t1U'\u0001\u0004ck\u001a4WM]\u0005\u0003\u0011\u0016\u0013qAQ=uK\n+h\rC\u0003K\u000b\u0001\u0007\u0001)\u0001\u0002jI\")A*\u0002a\u0001\u0007\u00069!-\u001f;f\u0005V4\u0017aE4fi\u0012+7m\\7qe\u0016\u001c8/\u001a3TSj,GC\u0001!P\u0011\u0015ae\u00011\u0001D\u0003E9W\r\u001e#fG>l\u0007O]3tg\u0016$\u0017\n\u001a\u000b\u0004\u0001J\u001b\u0006\"\u0002&\b\u0001\u0004\u0001\u0005\"\u0002+\b\u0001\u0004\u0019\u0015a\u00012vM\u0006a\u0011n]\"p[B\u0014Xm]:fIR\u0011qK\u0017\t\u0003UaK!!W\u0016\u0003\u000f\t{w\u000e\\3b]\")!\n\u0003a\u0001\u0001\u0002")
public class GamePacketDecoderCataclysm
extends GamePacketDecoderWotLK
implements GamePacketsCataclysm15595 {
    private final Inflater inflater;
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

    public Inflater inflater() {
        return this.inflater;
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        this.inflater().end();
        super.channelInactive(ctx);
    }

    @Override
    public Tuple2<Object, ByteBuf> decompress(int id, ByteBuf byteBuf) {
        Tuple2<Integer, ByteBuf> tuple2;
        if (this.isCompressed(id)) {
            int decompressedSize = this.getDecompressedSize(byteBuf);
            byte[] compressed = new byte[byteBuf.readableBytes()];
            byteBuf.readBytes(compressed);
            byteBuf.release();
            byte[] decompressed = new byte[decompressedSize];
            this.inflater().setInput(compressed);
            this.inflater().inflate(decompressed);
            ByteBuf ret = PooledByteBufAllocator.DEFAULT.buffer(decompressed.length, decompressed.length);
            ret.writeBytes(decompressed);
            tuple2 = new Tuple2<Integer, ByteBuf>(BoxesRunTime.boxToInteger(this.getDecompressedId(id, ret)), ret);
        } else {
            tuple2 = new Tuple2<Integer, ByteBuf>(BoxesRunTime.boxToInteger(id), byteBuf);
        }
        return tuple2;
    }

    public int getDecompressedSize(ByteBuf byteBuf) {
        return byteBuf.readIntLE();
    }

    public int getDecompressedId(int id, ByteBuf buf) {
        return id ^ 0x8000;
    }

    public boolean isCompressed(int id) {
        return (id & 0x8000) == 32768;
    }

    public GamePacketDecoderCataclysm() {
        GamePacketsCataclysm15595.$init$(this);
        this.inflater = new Inflater();
    }
}

