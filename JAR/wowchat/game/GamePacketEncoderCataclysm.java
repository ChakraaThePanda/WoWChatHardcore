/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import scala.reflect.ScalaSignature;
import wowchat.game.GamePacketEncoder;
import wowchat.game.GamePacketsCataclysm15595;
import wowchat.game.GamePacketsTBC;
import wowchat.game.GamePacketsWotLK;

@ScalaSignature(bytes="\u0006\u0001\u00052Aa\u0001\u0003\u0001\u0013!)\u0011\u0003\u0001C\u0001%!)A\u0003\u0001C)+\tQr)Y7f!\u0006\u001c7.\u001a;F]\u000e|G-\u001a:DCR\f7\r\\=t[*\u0011QAB\u0001\u0005O\u0006lWMC\u0001\b\u0003\u001d9xn^2iCR\u001c\u0001aE\u0002\u0001\u00159\u0001\"a\u0003\u0007\u000e\u0003\u0011I!!\u0004\u0003\u0003#\u001d\u000bW.\u001a)bG.,G/\u00128d_\u0012,'\u000f\u0005\u0002\f\u001f%\u0011\u0001\u0003\u0002\u0002\u001a\u000f\u0006lW\rU1dW\u0016$8oQ1uC\u000ed\u0017p]72kUJT'\u0001\u0004=S:LGO\u0010\u000b\u0002'A\u00111\u0002A\u0001\u0014SN,f.\u001a8def\u0004H/\u001a3QC\u000e\\W\r\u001e\u000b\u0003-q\u0001\"a\u0006\u000e\u000e\u0003aQ\u0011!G\u0001\u0006g\u000e\fG.Y\u0005\u00037a\u0011qAQ8pY\u0016\fg\u000eC\u0003\u001e\u0005\u0001\u0007a$\u0001\u0002jIB\u0011qcH\u0005\u0003Aa\u00111!\u00138u\u0001")
public class GamePacketEncoderCataclysm
extends GamePacketEncoder
implements GamePacketsCataclysm15595 {
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
    public void wowchat$game$GamePacketsWotLK$_setter_$SMSG_GM_MESSAGECHAT_$eq(int x$1) {
    }

    @Override
    public void wowchat$game$GamePacketsWotLK$_setter_$CMSG_KEEP_ALIVE_$eq(int x$1) {
    }

    @Override
    public void wowchat$game$GamePacketsTBC$_setter_$SMSG_GM_MESSAGECHAT_$eq(int x$1) {
    }

    @Override
    public void wowchat$game$GamePacketsTBC$_setter_$SMSG_MOTD_$eq(int x$1) {
    }

    @Override
    public void wowchat$game$GamePacketsTBC$_setter_$CMSG_KEEP_ALIVE_$eq(int x$1) {
    }

    @Override
    public boolean isUnencryptedPacket(int id) {
        return super.isUnencryptedPacket(id) || id == this.WOW_CONNECTION();
    }

    public GamePacketEncoderCataclysm() {
        GamePacketsTBC.$init$(this);
        GamePacketsWotLK.$init$(this);
        GamePacketsCataclysm15595.$init$(this);
    }
}

