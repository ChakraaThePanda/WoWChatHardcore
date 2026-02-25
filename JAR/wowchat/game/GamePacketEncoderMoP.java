/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import scala.Predef$;
import scala.collection.TraversableOnce;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.ArrayOps;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import wowchat.common.ByteUtils$;
import wowchat.common.Packet;
import wowchat.game.GameHeaderCrypt;
import wowchat.game.GamePacketEncoderCataclysm;
import wowchat.game.GamePacketsMoP18414;

@ScalaSignature(bytes="\u0006\u0001a2Aa\u0001\u0003\u0001\u0013!)\u0011\u0003\u0001C\u0001%!)A\u0003\u0001C!+\t!r)Y7f!\u0006\u001c7.\u001a;F]\u000e|G-\u001a:N_BS!!\u0002\u0004\u0002\t\u001d\fW.\u001a\u0006\u0002\u000f\u00059qo\\<dQ\u0006$8\u0001A\n\u0004\u0001)q\u0001CA\u0006\r\u001b\u0005!\u0011BA\u0007\u0005\u0005i9\u0015-\\3QC\u000e\\W\r^#oG>$WM]\"bi\u0006\u001cG._:n!\tYq\"\u0003\u0002\u0011\t\t\u0019r)Y7f!\u0006\u001c7.\u001a;t\u001b>\u0004\u0016\u0007\u000f\u001b2i\u00051A(\u001b8jiz\"\u0012a\u0005\t\u0003\u0017\u0001\ta!\u001a8d_\u0012,G\u0003\u0002\f\u001dQA\u0002\"a\u0006\u000e\u000e\u0003aQ\u0011!G\u0001\u0006g\u000e\fG.Y\u0005\u00037a\u0011A!\u00168ji\")QD\u0001a\u0001=\u0005\u00191\r\u001e=\u0011\u0005}1S\"\u0001\u0011\u000b\u0005\u0005\u0012\u0013aB2iC:tW\r\u001c\u0006\u0003G\u0011\nQA\\3uifT\u0011!J\u0001\u0003S>L!a\n\u0011\u0003+\rC\u0017M\u001c8fY\"\u000bg\u000e\u001a7fe\u000e{g\u000e^3yi\")\u0011F\u0001a\u0001U\u0005\u0019Qn]4\u0011\u0005-rS\"\u0001\u0017\u000b\u000552\u0011AB2p[6|g.\u0003\u00020Y\t1\u0001+Y2lKRDQ!\r\u0002A\u0002I\n1a\\;u!\t\u0019d'D\u00015\u0015\t)$%\u0001\u0004ck\u001a4WM]\u0005\u0003oQ\u0012qAQ=uK\n+h\r")
public class GamePacketEncoderMoP
extends GamePacketEncoderCataclysm
implements GamePacketsMoP18414 {
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
    public void encode(ChannelHandlerContext ctx, Packet msg, ByteBuf out) {
        BoxedUnit boxedUnit;
        byte[] header;
        byte[] byArray;
        GameHeaderCrypt crypt = ctx.channel().attr(this.CRYPT()).get();
        boolean unencrypted = this.isUnencryptedPacket(msg.id());
        int headerSize = 4;
        int size = msg.byteBuf().writerIndex();
        ArrayBuffer array = new ArrayBuffer(headerSize);
        if (unencrypted) {
            array.$plus$plus$eq((TraversableOnce)new ArrayOps.ofByte(Predef$.MODULE$.byteArrayOps(ByteUtils$.MODULE$.shortToBytesLE(size + 2))));
            array.$plus$plus$eq((TraversableOnce)new ArrayOps.ofByte(Predef$.MODULE$.byteArrayOps(ByteUtils$.MODULE$.shortToBytesLE(msg.id()))));
            byArray = (byte[])array.toArray(ClassTag$.MODULE$.Byte());
        } else {
            array.$plus$plus$eq((TraversableOnce)new ArrayOps.ofByte(Predef$.MODULE$.byteArrayOps(ByteUtils$.MODULE$.intToBytesLE(size << 13 | msg.id() & 0x1FFF))));
            byArray = header = crypt.encrypt((byte[])array.toArray(ClassTag$.MODULE$.Byte()));
        }
        if (this.logger().underlying().isDebugEnabled()) {
            int arg$macro$1 = msg.id();
            String arg$macro$2 = ByteUtils$.MODULE$.toHexString(msg.byteBuf(), true, false);
            this.logger().underlying().debug(new StringOps("SEND PACKET: %04X - %s").format(Predef$.MODULE$.genericWrapArray(new Object[]{BoxesRunTime.boxToInteger(arg$macro$1), arg$macro$2})));
            boxedUnit = BoxedUnit.UNIT;
        } else {
            boxedUnit = BoxedUnit.UNIT;
        }
        out.writeBytes(header);
        out.writeBytes(msg.byteBuf());
        msg.byteBuf().release();
    }

    public GamePacketEncoderMoP() {
        GamePacketsMoP18414.$init$(this);
    }
}

