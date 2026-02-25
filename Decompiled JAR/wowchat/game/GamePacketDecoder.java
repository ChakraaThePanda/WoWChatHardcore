/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import com.typesafe.scalalogging.Logger;
import com.typesafe.scalalogging.StrictLogging;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.AttributeKey;
import java.util.List;
import scala.MatchError;
import scala.Predef$;
import scala.Tuple2;
import scala.Tuple2$mcII$sp;
import scala.collection.immutable.StringOps;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import wowchat.common.ByteUtils$;
import wowchat.common.Packet;
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

@ScalaSignature(bytes="\u0006\u0001m4AAD\b\u0001)!)q\u0006\u0001C\u0001a!9!\u0007\u0001b\u0001\n#\u0019\u0004B\u0002\u001e\u0001A\u0003%A\u0007C\u0004<\u0001\u0001\u0007I\u0011B\u001a\t\u000fq\u0002\u0001\u0019!C\u0005{!11\t\u0001Q!\nQBq\u0001\u0012\u0001A\u0002\u0013%1\u0007C\u0004F\u0001\u0001\u0007I\u0011\u0002$\t\r!\u0003\u0001\u0015)\u00035\u0011\u0015I\u0005\u0001\"\u0011K\u0011\u0015A\u0007\u0001\"\u0001j\u0011\u0015q\u0007\u0001\"\u0001p\u0011\u00151\b\u0001\"\u0001x\u0005E9\u0015-\\3QC\u000e\\W\r\u001e#fG>$WM\u001d\u0006\u0003!E\tAaZ1nK*\t!#A\u0004x_^\u001c\u0007.\u0019;\u0004\u0001M!\u0001!F\u0011&!\t1r$D\u0001\u0018\u0015\tA\u0012$A\u0003d_\u0012,7M\u0003\u0002\u001b7\u00059\u0001.\u00198eY\u0016\u0014(B\u0001\u000f\u001e\u0003\u0015qW\r\u001e;z\u0015\u0005q\u0012AA5p\u0013\t\u0001sC\u0001\u000bCsR,Gk\\'fgN\fw-\u001a#fG>$WM\u001d\t\u0003E\rj\u0011aD\u0005\u0003I=\u00111bR1nKB\u000b7m[3ugB\u0011a%L\u0007\u0002O)\u0011\u0001&K\u0001\rg\u000e\fG.\u00197pO\u001eLgn\u001a\u0006\u0003U-\n\u0001\u0002^=qKN\fg-\u001a\u0006\u0002Y\u0005\u00191m\\7\n\u00059:#!D*ue&\u001cG\u000fT8hO&tw-\u0001\u0004=S:LGO\u0010\u000b\u0002cA\u0011!\u0005A\u0001\u000e\u0011\u0016\u000bE)\u0012*`\u0019\u0016su\t\u0016%\u0016\u0003Q\u0002\"!\u000e\u001d\u000e\u0003YR\u0011aN\u0001\u0006g\u000e\fG.Y\u0005\u0003sY\u00121!\u00138u\u00039AU)\u0011#F%~cUIT$U\u0011\u0002\nAa]5{K\u0006A1/\u001b>f?\u0012*\u0017\u000f\u0006\u0002?\u0003B\u0011QgP\u0005\u0003\u0001Z\u0012A!\u00168ji\"9!)BA\u0001\u0002\u0004!\u0014a\u0001=%c\u0005)1/\u001b>fA\u0005\u0011\u0011\u000eZ\u0001\u0007S\u0012|F%Z9\u0015\u0005y:\u0005b\u0002\"\t\u0003\u0003\u0005\r\u0001N\u0001\u0004S\u0012\u0004\u0013A\u00023fG>$W\r\u0006\u0003?\u0017N[\u0006\"\u0002'\u000b\u0001\u0004i\u0015aA2uqB\u0011a*U\u0007\u0002\u001f*\u0011\u0001kG\u0001\bG\"\fgN\\3m\u0013\t\u0011vJA\u000bDQ\u0006tg.\u001a7IC:$G.\u001a:D_:$X\r\u001f;\t\u000bQS\u0001\u0019A+\u0002\u0005%t\u0007C\u0001,Z\u001b\u00059&B\u0001-\u001c\u0003\u0019\u0011WO\u001a4fe&\u0011!l\u0016\u0002\b\u0005f$XMQ;g\u0011\u0015a&\u00021\u0001^\u0003\ryW\u000f\u001e\t\u0004=\u000e,W\"A0\u000b\u0005\u0001\f\u0017\u0001B;uS2T\u0011AY\u0001\u0005U\u00064\u0018-\u0003\u0002e?\n!A*[:u!\t)d-\u0003\u0002hm\t1\u0011I\\=SK\u001a\fq\u0002]1sg\u0016<\u0015-\\3IK\u0006$WM\u001d\u000b\u0003U6\u0004B!N65i%\u0011AN\u000e\u0002\u0007)V\u0004H.\u001a\u001a\t\u000bQ[\u0001\u0019A+\u00021A\f'o]3HC6,\u0007*Z1eKJ,en\u0019:zaR,G\rF\u0002kaFDQ\u0001\u0016\u0007A\u0002UCQA\u001d\u0007A\u0002M\fQa\u0019:zaR\u0004\"A\t;\n\u0005U|!aD$b[\u0016DU-\u00193fe\u000e\u0013\u0018\u0010\u001d;\u0002\u0015\u0011,7m\\7qe\u0016\u001c8\u000fF\u0002ysj\u0004B!N65+\")A)\u0004a\u0001i!)A+\u0004a\u0001+\u0002")
public class GamePacketDecoder
extends ByteToMessageDecoder
implements GamePackets,
StrictLogging {
    private final int HEADER_LENGTH;
    private int size;
    private int id;
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

    public int HEADER_LENGTH() {
        return this.HEADER_LENGTH;
    }

    private int size() {
        return this.size;
    }

    private void size_$eq(int x$1) {
        this.size = x$1;
    }

    private int id() {
        return this.id;
    }

    private void id_$eq(int x$1) {
        this.id = x$1;
    }

    @Override
    public void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        BoxedUnit boxedUnit;
        if (in.readableBytes() < this.HEADER_LENGTH()) {
            return;
        }
        GameHeaderCrypt crypt = ctx.channel().attr(this.CRYPT()).get();
        if (this.size() == 0 && this.id() == 0) {
            Tuple2<Object, Object> tuple = crypt.isInit() ? this.parseGameHeaderEncrypted(in, crypt) : this.parseGameHeader(in);
            this.id_$eq(tuple._1$mcI$sp());
            this.size_$eq(tuple._2$mcI$sp());
        }
        if (this.size() > in.readableBytes()) {
            return;
        }
        ByteBuf byteBuf = in.readBytes(this.size());
        Tuple2<Object, ByteBuf> tuple2 = this.decompress(this.id(), byteBuf);
        if (tuple2 == null) {
            throw new MatchError(tuple2);
        }
        int newId = tuple2._1$mcI$sp();
        ByteBuf decompressed = tuple2._2();
        Tuple2<Integer, ByteBuf> tuple22 = new Tuple2<Integer, ByteBuf>(BoxesRunTime.boxToInteger(newId), decompressed);
        Tuple2<Integer, ByteBuf> tuple23 = tuple22;
        int newId2 = tuple23._1$mcI$sp();
        ByteBuf decompressed2 = tuple23._2();
        Packet packet = new Packet(newId2, decompressed2);
        if (this.logger().underlying().isDebugEnabled()) {
            int arg$macro$1 = newId2;
            String arg$macro$2 = ByteUtils$.MODULE$.toHexString(decompressed2, true, false);
            this.logger().underlying().debug(new StringOps("RECV PACKET: %04X - %s").format(Predef$.MODULE$.genericWrapArray(new Object[]{BoxesRunTime.boxToInteger(arg$macro$1), arg$macro$2})));
            boxedUnit = BoxedUnit.UNIT;
        } else {
            boxedUnit = BoxedUnit.UNIT;
        }
        out.add(packet);
        this.size_$eq(0);
        this.id_$eq(0);
    }

    public Tuple2<Object, Object> parseGameHeader(ByteBuf in) {
        int size = in.readShort() - 2;
        short id = in.readShortLE();
        return new Tuple2$mcII$sp(id, size);
    }

    public Tuple2<Object, Object> parseGameHeaderEncrypted(ByteBuf in, GameHeaderCrypt crypt) {
        byte[] header = new byte[this.HEADER_LENGTH()];
        in.readBytes(header);
        byte[] decrypted = crypt.decrypt(header);
        int size = ((decrypted[0] & 0xFF) << 8 | decrypted[1] & 0xFF) - 2;
        int id = (decrypted[3] & 0xFF) << 8 | decrypted[2] & 0xFF;
        return new Tuple2$mcII$sp(id, size);
    }

    public Tuple2<Object, ByteBuf> decompress(int id, ByteBuf in) {
        return new Tuple2<Object, ByteBuf>(BoxesRunTime.boxToInteger(id), in);
    }

    private final void ChatEvents$lzycompute$1() {
        GamePacketDecoder gamePacketDecoder = this;
        synchronized (gamePacketDecoder) {
            if (this.ChatEvents$module == null) {
                this.ChatEvents$module = new GamePackets$ChatEvents$(this);
            }
        }
    }

    private final void GuildEvents$lzycompute$1() {
        GamePacketDecoder gamePacketDecoder = this;
        synchronized (gamePacketDecoder) {
            if (this.GuildEvents$module == null) {
                this.GuildEvents$module = new GamePackets$GuildEvents$(this);
            }
        }
    }

    private final void Races$lzycompute$1() {
        GamePacketDecoder gamePacketDecoder = this;
        synchronized (gamePacketDecoder) {
            if (this.Races$module == null) {
                this.Races$module = new GamePackets$Races$(this);
            }
        }
    }

    private final void Classes$lzycompute$1() {
        GamePacketDecoder gamePacketDecoder = this;
        synchronized (gamePacketDecoder) {
            if (this.Classes$module == null) {
                this.Classes$module = new GamePackets$Classes$(this);
            }
        }
    }

    private final void Genders$lzycompute$1() {
        GamePacketDecoder gamePacketDecoder = this;
        synchronized (gamePacketDecoder) {
            if (this.Genders$module == null) {
                this.Genders$module = new GamePackets$Genders$(this);
            }
        }
    }

    private final void AuthResponseCodes$lzycompute$1() {
        GamePacketDecoder gamePacketDecoder = this;
        synchronized (gamePacketDecoder) {
            if (this.AuthResponseCodes$module == null) {
                this.AuthResponseCodes$module = new GamePackets$AuthResponseCodes$(this);
            }
        }
    }

    private final void ChatNotify$lzycompute$1() {
        GamePacketDecoder gamePacketDecoder = this;
        synchronized (gamePacketDecoder) {
            if (this.ChatNotify$module == null) {
                this.ChatNotify$module = new GamePackets$ChatNotify$(this);
            }
        }
    }

    private final void ServerMessageType$lzycompute$1() {
        GamePacketDecoder gamePacketDecoder = this;
        synchronized (gamePacketDecoder) {
            if (this.ServerMessageType$module == null) {
                this.ServerMessageType$module = new GamePackets$ServerMessageType$(this);
            }
        }
    }

    private final void ChatChannelIds$lzycompute$1() {
        GamePacketDecoder gamePacketDecoder = this;
        synchronized (gamePacketDecoder) {
            if (this.ChatChannelIds$module == null) {
                this.ChatChannelIds$module = new GamePackets$ChatChannelIds$(this);
            }
        }
    }

    public GamePacketDecoder() {
        GamePackets.$init$(this);
        StrictLogging.$init$(this);
        this.HEADER_LENGTH = 4;
        this.size = 0;
        this.id = 0;
    }
}

