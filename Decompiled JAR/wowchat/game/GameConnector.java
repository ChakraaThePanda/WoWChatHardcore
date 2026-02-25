/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import com.typesafe.scalalogging.Logger;
import com.typesafe.scalalogging.StrictLogging;
import io.netty.bootstrap.AbstractBootstrap;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;
import scala.Enumeration;
import scala.Function0;
import scala.Function1;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Some;
import scala.Unit$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.java8.JFunction0$mcV$sp;
import scala.runtime.java8.JFunction0$mcZ$sp;
import scala.sys.package$;
import scala.util.Try$;
import wowchat.common.CommonConnectionCallback;
import wowchat.common.Global$;
import wowchat.common.IdleStateCallback;
import wowchat.common.WowChatConfig$;
import wowchat.common.WowExpansion$;
import wowchat.game.GameHeaderCrypt;
import wowchat.game.GameHeaderCryptMoP;
import wowchat.game.GameHeaderCryptTBC;
import wowchat.game.GameHeaderCryptWotLK;
import wowchat.game.GamePacketDecoder;
import wowchat.game.GamePacketDecoderCataclysm;
import wowchat.game.GamePacketDecoderMoP;
import wowchat.game.GamePacketDecoderWotLK;
import wowchat.game.GamePacketEncoder;
import wowchat.game.GamePacketEncoderCataclysm;
import wowchat.game.GamePacketEncoderMoP;
import wowchat.game.GamePacketHandler;
import wowchat.game.GamePacketHandlerCataclysm15595;
import wowchat.game.GamePacketHandlerMoP18414;
import wowchat.game.GamePacketHandlerTBC;
import wowchat.game.GamePacketHandlerWotLK;
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

@ScalaSignature(bytes="\u0006\u0001]4A\u0001E\t\u0001-!A1\u0006\u0001B\u0001B\u0003%A\u0006\u0003\u00058\u0001\t\u0005\t\u0015!\u00039\u0011!Y\u0004A!A!\u0002\u0013a\u0003\u0002\u0003\u001f\u0001\u0005\u0003\u0005\u000b\u0011\u0002\u001d\t\u0011u\u0002!\u0011!Q\u0001\nyB\u0001\u0002\u0012\u0001\u0003\u0002\u0003\u0006I!\u0012\u0005\u0006\u0017\u0002!\t\u0001\u0014\u0005\b)\u0002\u0001\r\u0011\"\u0003V\u0011\u001d\u0011\u0007\u00011A\u0005\n\rDa!\u001b\u0001!B\u00131\u0006b\u00026\u0001\u0001\u0004%\ta\u001b\u0005\ba\u0002\u0001\r\u0011\"\u0001r\u0011\u0019\u0019\b\u0001)Q\u0005Y\")A\u000f\u0001C\u0001k\")a\u000f\u0001C\u0001k\niq)Y7f\u0007>tg.Z2u_JT!AE\n\u0002\t\u001d\fW.\u001a\u0006\u0002)\u00059qo\\<dQ\u0006$8\u0001A\n\u0005\u0001]i\u0012\u0005\u0005\u0002\u001975\t\u0011DC\u0001\u001b\u0003\u0015\u00198-\u00197b\u0013\ta\u0012D\u0001\u0004B]f\u0014VM\u001a\t\u0003=}i\u0011!E\u0005\u0003AE\u00111bR1nKB\u000b7m[3ugB\u0011!%K\u0007\u0002G)\u0011A%J\u0001\rg\u000e\fG.\u00197pO\u001eLgn\u001a\u0006\u0003M\u001d\n\u0001\u0002^=qKN\fg-\u001a\u0006\u0002Q\u0005\u00191m\\7\n\u0005)\u001a#!D*ue&\u001cG\u000fT8hO&tw-\u0001\u0003i_N$\bCA\u00175\u001d\tq#\u0007\u0005\u0002035\t\u0001G\u0003\u00022+\u00051AH]8pizJ!aM\r\u0002\rA\u0013X\rZ3g\u0013\t)dG\u0001\u0004TiJLgn\u001a\u0006\u0003ge\tA\u0001]8siB\u0011\u0001$O\u0005\u0003ue\u00111!\u00138u\u0003%\u0011X-\u00197n\u001d\u0006lW-A\u0004sK\u0006dW.\u00133\u0002\u0015M,7o]5p].+\u0017\u0010E\u0002\u0019\u007f\u0005K!\u0001Q\r\u0003\u000b\u0005\u0013(/Y=\u0011\u0005a\u0011\u0015BA\"\u001a\u0005\u0011\u0011\u0015\u0010^3\u0002#\u001d\fW.Z#wK:$8)\u00197mE\u0006\u001c7\u000e\u0005\u0002G\u00136\tqI\u0003\u0002I'\u000511m\\7n_:L!AS$\u00031\r{W.\\8o\u0007>tg.Z2uS>t7)\u00197mE\u0006\u001c7.\u0001\u0004=S:LGO\u0010\u000b\b\u001b:{\u0005+\u0015*T!\tq\u0002\u0001C\u0003,\u000f\u0001\u0007A\u0006C\u00038\u000f\u0001\u0007\u0001\bC\u0003<\u000f\u0001\u0007A\u0006C\u0003=\u000f\u0001\u0007\u0001\bC\u0003>\u000f\u0001\u0007a\bC\u0003E\u000f\u0001\u0007Q)A\u0004dQ\u0006tg.\u001a7\u0016\u0003Y\u00032\u0001G,Z\u0013\tA\u0016D\u0001\u0004PaRLwN\u001c\t\u00035\u0002l\u0011a\u0017\u0006\u0003)rS!!\u00180\u0002\u000b9,G\u000f^=\u000b\u0003}\u000b!![8\n\u0005\u0005\\&aB\"iC:tW\r\\\u0001\fG\"\fgN\\3m?\u0012*\u0017\u000f\u0006\u0002eOB\u0011\u0001$Z\u0005\u0003Mf\u0011A!\u00168ji\"9\u0001.CA\u0001\u0002\u00041\u0016a\u0001=%c\u0005A1\r[1o]\u0016d\u0007%A\u0004iC:$G.\u001a:\u0016\u00031\u00042\u0001G,n!\tqb.\u0003\u0002p#\t\tr)Y7f!\u0006\u001c7.\u001a;IC:$G.\u001a:\u0002\u0017!\fg\u000e\u001a7fe~#S-\u001d\u000b\u0003IJDq\u0001\u001b\u0007\u0002\u0002\u0003\u0007A.\u0001\u0005iC:$G.\u001a:!\u0003\u001d\u0019wN\u001c8fGR,\u0012\u0001Z\u0001\u000bI&\u001c8m\u001c8oK\u000e$\b")
public class GameConnector
implements GamePackets,
StrictLogging {
    private final String host;
    private final int port;
    public final String wowchat$game$GameConnector$$realmName;
    public final int wowchat$game$GameConnector$$realmId;
    public final byte[] wowchat$game$GameConnector$$sessionKey;
    public final CommonConnectionCallback wowchat$game$GameConnector$$gameEventCallback;
    private Option<Channel> channel;
    private Option<GamePacketHandler> handler;
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

    private Option<Channel> channel() {
        return this.channel;
    }

    private void channel_$eq(Option<Channel> x$1) {
        this.channel = x$1;
    }

    public Option<GamePacketHandler> handler() {
        return this.handler;
    }

    public void handler_$eq(Option<GamePacketHandler> x$1) {
        this.handler = x$1;
    }

    public void connect() {
        BoxedUnit boxedUnit;
        if (BoxesRunTime.unboxToBoolean(this.channel().fold((JFunction0$mcZ$sp & scala.Serializable)() -> false, (Function1<Channel, Object> & Serializable & scala.Serializable)x$1 -> BoxesRunTime.boxToBoolean(x$1.isActive())))) {
            BoxedUnit boxedUnit2;
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("Refusing to connect to game server. Connection already exists.");
                boxedUnit2 = BoxedUnit.UNIT;
            } else {
                boxedUnit2 = BoxedUnit.UNIT;
            }
            return;
        }
        if (this.logger().underlying().isInfoEnabled()) {
            this.logger().underlying().info("Connecting to game server {} ({}:{})", this.wowchat$game$GameConnector$$realmName, this.host, BoxesRunTime.boxToInteger(this.port));
            boxedUnit = BoxedUnit.UNIT;
        } else {
            boxedUnit = BoxedUnit.UNIT;
        }
        Bootstrap bootstrap = new Bootstrap();
        ((Bootstrap)((AbstractBootstrap)((AbstractBootstrap)((AbstractBootstrap)bootstrap.group(Global$.MODULE$.group())).channel(NioSocketChannel.class)).option(ChannelOption.CONNECT_TIMEOUT_MILLIS, (Integer)Predef$.MODULE$.int2Integer(10000))).option(ChannelOption.SO_KEEPALIVE, (Boolean)Predef$.MODULE$.boolean2Boolean(true))).remoteAddress(new InetSocketAddress(this.host, this.port)).handler(new ChannelInitializer<SocketChannel>(this){
            private final /* synthetic */ GameConnector $outer;

            public void initChannel(SocketChannel socketChannel) throws Exception {
                GamePacketHandler gamePacketHandler;
                GamePacketDecoder gamePacketDecoder;
                GamePacketEncoder gamePacketEncoder;
                Enumeration.Value value = WowChatConfig$.MODULE$.getExpansion();
                Enumeration.Value value2 = WowExpansion$.MODULE$.Cataclysm();
                Enumeration.Value value3 = value;
                if (!(value2 != null ? !((Object)value2).equals(value3) : value3 != null)) {
                    gamePacketEncoder = new GamePacketEncoderCataclysm();
                } else {
                    Enumeration.Value value4 = WowExpansion$.MODULE$.MoP();
                    Enumeration.Value value5 = value;
                    gamePacketEncoder = !(value4 != null ? !((Object)value4).equals(value5) : value5 != null) ? new GamePacketEncoderMoP() : new GamePacketEncoder();
                }
                GamePacketEncoderCataclysm encoder = gamePacketEncoder;
                Enumeration.Value value6 = WowChatConfig$.MODULE$.getExpansion();
                Enumeration.Value value7 = WowExpansion$.MODULE$.WotLK();
                Enumeration.Value value8 = value6;
                if (!(value7 != null ? !((Object)value7).equals(value8) : value8 != null)) {
                    gamePacketDecoder = new GamePacketDecoderWotLK();
                } else {
                    Enumeration.Value value9 = WowExpansion$.MODULE$.Cataclysm();
                    Enumeration.Value value10 = value6;
                    if (!(value9 != null ? !((Object)value9).equals(value10) : value10 != null)) {
                        gamePacketDecoder = new GamePacketDecoderCataclysm();
                    } else {
                        Enumeration.Value value11 = WowExpansion$.MODULE$.MoP();
                        Enumeration.Value value12 = value6;
                        gamePacketDecoder = !(value11 != null ? !((Object)value11).equals(value12) : value12 != null) ? new GamePacketDecoderMoP() : new GamePacketDecoder();
                    }
                }
                GamePacketDecoderWotLK decoder = gamePacketDecoder;
                Enumeration.Value value13 = WowChatConfig$.MODULE$.getExpansion();
                Enumeration.Value value14 = WowExpansion$.MODULE$.Vanilla();
                Enumeration.Value value15 = value13;
                if (!(value14 != null ? !((Object)value14).equals(value15) : value15 != null)) {
                    socketChannel.attr(this.$outer.CRYPT()).set(new GameHeaderCrypt());
                    gamePacketHandler = new GamePacketHandler(this.$outer.wowchat$game$GameConnector$$realmId, this.$outer.wowchat$game$GameConnector$$realmName, this.$outer.wowchat$game$GameConnector$$sessionKey, this.$outer.wowchat$game$GameConnector$$gameEventCallback);
                } else {
                    Enumeration.Value value16 = WowExpansion$.MODULE$.TBC();
                    Enumeration.Value value17 = value13;
                    if (!(value16 != null ? !((Object)value16).equals(value17) : value17 != null)) {
                        socketChannel.attr(this.$outer.CRYPT()).set(new GameHeaderCryptTBC());
                        gamePacketHandler = new GamePacketHandlerTBC(this.$outer.wowchat$game$GameConnector$$realmId, this.$outer.wowchat$game$GameConnector$$realmName, this.$outer.wowchat$game$GameConnector$$sessionKey, this.$outer.wowchat$game$GameConnector$$gameEventCallback);
                    } else {
                        Enumeration.Value value18 = WowExpansion$.MODULE$.WotLK();
                        Enumeration.Value value19 = value13;
                        if (!(value18 != null ? !((Object)value18).equals(value19) : value19 != null)) {
                            socketChannel.attr(this.$outer.CRYPT()).set(new GameHeaderCryptWotLK());
                            gamePacketHandler = new GamePacketHandlerWotLK(this.$outer.wowchat$game$GameConnector$$realmId, this.$outer.wowchat$game$GameConnector$$realmName, this.$outer.wowchat$game$GameConnector$$sessionKey, this.$outer.wowchat$game$GameConnector$$gameEventCallback);
                        } else {
                            Enumeration.Value value20 = WowExpansion$.MODULE$.Cataclysm();
                            Enumeration.Value value21 = value13;
                            if (!(value20 != null ? !((Object)value20).equals(value21) : value21 != null)) {
                                socketChannel.attr(this.$outer.CRYPT()).set(new GameHeaderCryptWotLK());
                                gamePacketHandler = new GamePacketHandlerCataclysm15595(this.$outer.wowchat$game$GameConnector$$realmId, this.$outer.wowchat$game$GameConnector$$realmName, this.$outer.wowchat$game$GameConnector$$sessionKey, this.$outer.wowchat$game$GameConnector$$gameEventCallback);
                            } else {
                                Enumeration.Value value22 = WowExpansion$.MODULE$.MoP();
                                Enumeration.Value value23 = value13;
                                if (!(value22 != null ? !((Object)value22).equals(value23) : value23 != null)) {
                                    socketChannel.attr(this.$outer.CRYPT()).set(new GameHeaderCryptMoP());
                                    gamePacketHandler = new GamePacketHandlerMoP18414(this.$outer.wowchat$game$GameConnector$$realmId, this.$outer.wowchat$game$GameConnector$$realmName, this.$outer.wowchat$game$GameConnector$$sessionKey, this.$outer.wowchat$game$GameConnector$$gameEventCallback);
                                } else {
                                    throw new MatchError(value13);
                                }
                            }
                        }
                    }
                }
                this.$outer.handler_$eq(new Some<GamePacketHandler>(gamePacketHandler));
                socketChannel.pipeline().addLast(new IdleStateHandler(60, 120, 0), new IdleStateCallback(), decoder, encoder, this.$outer.handler().get());
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
            }
        });
        this.channel_$eq(new Some<Channel>(bootstrap.connect().addListener((GenericFutureListener<? extends Future<? super Void>>)((GenericFutureListener<Future>)future -> Try$.MODULE$.apply((Function0<Object> & Serializable & scala.Serializable)() -> future.get(10L, TimeUnit.SECONDS)).fold((Function1<Throwable, Object> & Serializable & scala.Serializable)throwable -> {
            GameConnector.$anonfun$connect$5(this, throwable);
            return BoxedUnit.UNIT;
        }, (Function1<Object, Unit$> & Serializable & scala.Serializable)x$2 -> Unit$.MODULE$))).channel()));
    }

    public void disconnect() {
        if (Global$.MODULE$.group().isShuttingDown() || Global$.MODULE$.group().isShutdown() || Global$.MODULE$.group().isTerminated()) {
            return;
        }
        this.channel().foreach((Function1<Channel, ChannelFuture> & Serializable & scala.Serializable)channel -> {
            this.handler().get().sendLogout().foreach((Function1<ChannelFuture, ChannelFuture> & Serializable & scala.Serializable)x$3 -> x$3.await());
            return channel.close();
        });
        this.channel_$eq(None$.MODULE$);
    }

    private final void ChatEvents$lzycompute$1() {
        GameConnector gameConnector = this;
        synchronized (gameConnector) {
            if (this.ChatEvents$module == null) {
                this.ChatEvents$module = new GamePackets$ChatEvents$(this);
            }
        }
    }

    private final void GuildEvents$lzycompute$1() {
        GameConnector gameConnector = this;
        synchronized (gameConnector) {
            if (this.GuildEvents$module == null) {
                this.GuildEvents$module = new GamePackets$GuildEvents$(this);
            }
        }
    }

    private final void Races$lzycompute$1() {
        GameConnector gameConnector = this;
        synchronized (gameConnector) {
            if (this.Races$module == null) {
                this.Races$module = new GamePackets$Races$(this);
            }
        }
    }

    private final void Classes$lzycompute$1() {
        GameConnector gameConnector = this;
        synchronized (gameConnector) {
            if (this.Classes$module == null) {
                this.Classes$module = new GamePackets$Classes$(this);
            }
        }
    }

    private final void Genders$lzycompute$1() {
        GameConnector gameConnector = this;
        synchronized (gameConnector) {
            if (this.Genders$module == null) {
                this.Genders$module = new GamePackets$Genders$(this);
            }
        }
    }

    private final void AuthResponseCodes$lzycompute$1() {
        GameConnector gameConnector = this;
        synchronized (gameConnector) {
            if (this.AuthResponseCodes$module == null) {
                this.AuthResponseCodes$module = new GamePackets$AuthResponseCodes$(this);
            }
        }
    }

    private final void ChatNotify$lzycompute$1() {
        GameConnector gameConnector = this;
        synchronized (gameConnector) {
            if (this.ChatNotify$module == null) {
                this.ChatNotify$module = new GamePackets$ChatNotify$(this);
            }
        }
    }

    private final void ServerMessageType$lzycompute$1() {
        GameConnector gameConnector = this;
        synchronized (gameConnector) {
            if (this.ServerMessageType$module == null) {
                this.ServerMessageType$module = new GamePackets$ServerMessageType$(this);
            }
        }
    }

    private final void ChatChannelIds$lzycompute$1() {
        GameConnector gameConnector = this;
        synchronized (gameConnector) {
            if (this.ChatChannelIds$module == null) {
                this.ChatChannelIds$module = new GamePackets$ChatChannelIds$(this);
            }
        }
    }

    public static final /* synthetic */ void $anonfun$connect$5(GameConnector $this, Throwable throwable) {
        BoxedUnit boxedUnit;
        if ($this.logger().underlying().isErrorEnabled()) {
            $this.logger().underlying().error("Failed to connect to game server! {}", new Object[]{throwable.getMessage()});
            boxedUnit = BoxedUnit.UNIT;
        } else {
            boxedUnit = BoxedUnit.UNIT;
        }
        $this.wowchat$game$GameConnector$$gameEventCallback.disconnected();
    }

    public GameConnector(String host, int port, String realmName, int realmId, byte[] sessionKey, CommonConnectionCallback gameEventCallback) {
        this.host = host;
        this.port = port;
        this.wowchat$game$GameConnector$$realmName = realmName;
        this.wowchat$game$GameConnector$$realmId = realmId;
        this.wowchat$game$GameConnector$$sessionKey = sessionKey;
        this.wowchat$game$GameConnector$$gameEventCallback = gameEventCallback;
        GamePackets.$init$(this);
        StrictLogging.$init$(this);
        package$.MODULE$.addShutdownHook((JFunction0$mcV$sp & scala.Serializable)() -> this.disconnect());
        this.channel = None$.MODULE$;
        this.handler = None$.MODULE$;
    }
}

