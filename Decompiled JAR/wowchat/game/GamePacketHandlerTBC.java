/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelOutboundInvoker;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
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
import wowchat.common.CommonConnectionCallback;
import wowchat.common.Global$;
import wowchat.common.Packet;
import wowchat.common.Packet$;
import wowchat.game.CharEnumMessage;
import wowchat.game.ChatMessage;
import wowchat.game.GamePacketHandler;
import wowchat.game.GamePacketsTBC;
import wowchat.game.GuildMember;

@ScalaSignature(bytes="\u0006\u0001\u0005]b\u0001B\n\u0015\u0001eA\u0001\"\t\u0001\u0003\u0002\u0003\u0006IA\t\u0005\tQ\u0001\u0011\t\u0011)A\u0005S!AA\u0007\u0001B\u0001B\u0003%Q\u0007\u0003\u0005<\u0001\t\u0005\t\u0015!\u0003=\u0011\u0015\u0011\u0005\u0001\"\u0001D\u0011\u001dI\u0005A1A\u0005R)Caa\u0013\u0001!\u0002\u0013)\u0004b\u0002'\u0001\u0005\u0004%I!\u0014\u0005\u0007#\u0002\u0001\u000b\u0011\u0002(\t\u000bI\u0003A\u0011K*\t\u000b]\u0003A\u0011\u000b-\t\u000by\u0003A\u0011K0\t\u000b\u001d\u0004A\u0011\u000b5\t\u000b9\u0004A\u0011B8\t\u000bE\u0004A\u0011\u0003:\t\u000bu\u0004A\u0011\u000b@\t\u000f\u00055\u0001\u0001\"\u0015\u0002\u0010!9\u0011\u0011\u0007\u0001\u0005\n\u0005M\"\u0001F$b[\u0016\u0004\u0016mY6fi\"\u000bg\u000e\u001a7feR\u00135I\u0003\u0002\u0016-\u0005!q-Y7f\u0015\u00059\u0012aB<po\u000eD\u0017\r^\u0002\u0001'\r\u0001!D\b\t\u00037qi\u0011\u0001F\u0005\u0003;Q\u0011\u0011cR1nKB\u000b7m[3u\u0011\u0006tG\r\\3s!\tYr$\u0003\u0002!)\tqq)Y7f!\u0006\u001c7.\u001a;t)\n\u001b\u0015a\u0002:fC2l\u0017\n\u001a\t\u0003G\u0019j\u0011\u0001\n\u0006\u0002K\u0005)1oY1mC&\u0011q\u0005\n\u0002\u0004\u0013:$\u0018!\u0003:fC2lg*Y7f!\tQ\u0013G\u0004\u0002,_A\u0011A\u0006J\u0007\u0002[)\u0011a\u0006G\u0001\u0007yI|w\u000e\u001e \n\u0005A\"\u0013A\u0002)sK\u0012,g-\u0003\u00023g\t11\u000b\u001e:j]\u001eT!\u0001\r\u0013\u0002\u0015M,7o]5p].+\u0017\u0010E\u0002$maJ!a\u000e\u0013\u0003\u000b\u0005\u0013(/Y=\u0011\u0005\rJ\u0014B\u0001\u001e%\u0005\u0011\u0011\u0015\u0010^3\u0002#\u001d\fW.Z#wK:$8)\u00197mE\u0006\u001c7\u000e\u0005\u0002>\u00016\taH\u0003\u0002@-\u000511m\\7n_:L!!\u0011 \u00031\r{W.\\8o\u0007>tg.Z2uS>t7)\u00197mE\u0006\u001c7.\u0001\u0004=S:LGO\u0010\u000b\u0006\t\u00163u\t\u0013\t\u00037\u0001AQ!I\u0003A\u0002\tBQ\u0001K\u0003A\u0002%BQ\u0001N\u0003A\u0002UBQaO\u0003A\u0002q\n\u0011\"\u00193e_:LeNZ8\u0016\u0003U\n!\"\u00193e_:LeNZ8!\u0003-\u0019wN\u001c8fGR$\u0016.\\3\u0016\u00039\u0003\"aI(\n\u0005A##\u0001\u0002'p]\u001e\fAbY8o]\u0016\u001cG\u000fV5nK\u0002\nAC];o\u0017\u0016,\u0007/\u00117jm\u0016,\u00050Z2vi>\u0014X#\u0001+\u0011\u0005\r*\u0016B\u0001,%\u0005\u0011)f.\u001b;\u0002\u0019\rD\u0017M\u001c8fYB\u000b'o]3\u0015\u0005QK\u0006\"\u0002.\f\u0001\u0004Y\u0016aA7tOB\u0011Q\bX\u0005\u0003;z\u0012a\u0001U1dW\u0016$\u0018!\u00049beN,7\t[1s\u000b:,X\u000e\u0006\u0002aMB\u00191%Y2\n\u0005\t$#AB(qi&|g\u000e\u0005\u0002\u001cI&\u0011Q\r\u0006\u0002\u0010\u0007\"\f'/\u00128v[6+7o]1hK\")!\f\u0004a\u00017\u0006\u0001\u0002/\u0019:tK\u000eC\u0017\r^'fgN\fw-\u001a\u000b\u0003S6\u00042aI1k!\tY2.\u0003\u0002m)\tY1\t[1u\u001b\u0016\u001c8/Y4f\u0011\u0015QV\u00021\u0001\\\u0003AA\u0017M\u001c3mK~\u001bVjU$`\u001b>#F\t\u0006\u0002Ua\")!L\u0004a\u00017\u0006y\u0001/\u0019:tKN+'O^3s\u001b>$H\r\u0006\u0002tyB\u0019A/\u001f6\u000f\u0005U<hB\u0001\u0017w\u0013\u0005)\u0013B\u0001=%\u0003\u001d\u0001\u0018mY6bO\u0016L!A_>\u0003\u0007M+\u0017O\u0003\u0002yI!)!l\u0004a\u00017\u0006\u0001\u0002/\u0019:tK\u001e+\u0018\u000e\u001c3S_N$XM\u001d\u000b\u0004\u007f\u0006-\u0001C\u0002\u0016\u0002\u00029\u000b)!C\u0002\u0002\u0004M\u00121!T1q!\rY\u0012qA\u0005\u0004\u0003\u0013!\"aC$vS2$W*Z7cKJDQA\u0017\tA\u0002m\u000b\u0001c\u001e:ji\u0016Tu.\u001b8DQ\u0006tg.\u001a7\u0015\u000fQ\u000b\t\"!\u000b\u0002.!9\u00111C\tA\u0002\u0005U\u0011aA8viB!\u0011qCA\u0013\u001b\t\tIB\u0003\u0003\u0002\u001c\u0005u\u0011A\u00022vM\u001a,'O\u0003\u0003\u0002 \u0005\u0005\u0012!\u00028fiRL(BAA\u0012\u0003\tIw.\u0003\u0003\u0002(\u0005e!a\u0002\"zi\u0016\u0014UO\u001a\u0005\u0007\u0003W\t\u0002\u0019\u0001\u0012\u0002\u0005%$\u0007BBA\u0018#\u0001\u0007Q'\u0001\tvi\u001aD4\t[1o]\u0016d')\u001f;fg\u0006I\u0002.\u00198eY\u0016|6+T*H?RKU*R0T3:\u001buLU#R)\r!\u0016Q\u0007\u0005\u00065J\u0001\ra\u0017")
public class GamePacketHandlerTBC
extends GamePacketHandler
implements GamePacketsTBC {
    private final byte[] addonInfo;
    private final long connectTime;
    private final int SMSG_GM_MESSAGECHAT;
    private final int SMSG_MOTD;
    private final int CMSG_KEEP_ALIVE;

    @Override
    public int SMSG_GM_MESSAGECHAT() {
        return this.SMSG_GM_MESSAGECHAT;
    }

    @Override
    public int SMSG_MOTD() {
        return this.SMSG_MOTD;
    }

    @Override
    public int CMSG_KEEP_ALIVE() {
        return this.CMSG_KEEP_ALIVE;
    }

    @Override
    public void wowchat$game$GamePacketsTBC$_setter_$SMSG_GM_MESSAGECHAT_$eq(int x$1) {
        this.SMSG_GM_MESSAGECHAT = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsTBC$_setter_$SMSG_MOTD_$eq(int x$1) {
        this.SMSG_MOTD = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsTBC$_setter_$CMSG_KEEP_ALIVE_$eq(int x$1) {
        this.CMSG_KEEP_ALIVE = x$1;
    }

    @Override
    public byte[] addonInfo() {
        return this.addonInfo;
    }

    private long connectTime() {
        return this.connectTime;
    }

    @Override
    public void runKeepAliveExecutor() {
        this.executorService().scheduleWithFixedDelay(() -> ((ChannelOutboundInvoker)this.ctx().get()).writeAndFlush(new Packet(this.CMSG_KEEP_ALIVE(), Packet$.MODULE$.apply$default$2())), 15L, 30L, TimeUnit.SECONDS);
    }

    @Override
    public void channelParse(Packet msg) {
        int n = msg.id();
        if (this.SMSG_GM_MESSAGECHAT() == n) {
            this.handle_SMSG_MESSAGECHAT(msg);
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        } else if (this.SMSG_MOTD() == n) {
            this.handle_SMSG_MOTD(msg);
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        } else if (this.SMSG_TIME_SYNC_REQ() == n) {
            this.handle_SMSG_TIME_SYNC_REQ(msg);
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        } else {
            super.channelParse(msg);
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        }
    }

    @Override
    public Option<CharEnumMessage> parseCharEnum(Packet msg) {
        Option option;
        Object object = new Object();
        try {
            byte[] characterBytes = Global$.MODULE$.config().wow().character().toLowerCase().getBytes("UTF-8");
            byte charactersNum = msg.byteBuf().readByte();
            RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), charactersNum).foreach((Function1<Object, ByteBuf> & Serializable & scala.Serializable)i -> GamePacketHandlerTBC.$anonfun$parseCharEnum$1(msg, characterBytes, object, BoxesRunTime.unboxToInt(i)));
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
    public Option<ChatMessage> parseChatMessage(Packet msg) {
        Option channelName;
        byte tp = msg.byteBuf().readByte();
        int lang = msg.byteBuf().readIntLE();
        if (lang == -1) {
            return None$.MODULE$;
        }
        long guid = msg.byteBuf().readLongLE();
        if (tp != this.ChatEvents().CHAT_MSG_SYSTEM() && guid == BoxesRunTime.unboxToLong(this.selfCharacterId().get())) {
            return None$.MODULE$;
        }
        msg.byteBuf().skipBytes(4);
        Option option = channelName = tp == this.ChatEvents().CHAT_MSG_CHANNEL() ? new Some<String>(msg.readString()) : None$.MODULE$;
        if (!Global$.MODULE$.wowToDiscord().contains(new Tuple2(BoxesRunTime.boxToByte(tp), channelName.map((Function1<String, String> & Serializable & scala.Serializable)x$2 -> x$2.toLowerCase())))) {
            return None$.MODULE$;
        }
        msg.byteBuf().skipBytes(8);
        int txtLen = msg.byteBuf().readIntLE();
        String txt = ((Object)msg.byteBuf().readCharSequence(txtLen - 1, Charset.forName("UTF-8"))).toString();
        msg.byteBuf().skipBytes(1);
        return new Some<ChatMessage>(new ChatMessage(guid, tp, txt, channelName));
    }

    private void handle_SMSG_MOTD(Packet msg) {
        block0: {
            if (!Global$.MODULE$.config().wow().enableServerMotd()) break block0;
            this.parseServerMotd(msg).foreach((Function1<ChatMessage, Object> & Serializable & scala.Serializable)chatMessage -> {
                this.sendChatMessage(chatMessage);
                return BoxedUnit.UNIT;
            });
        }
    }

    public Seq<ChatMessage> parseServerMotd(Packet msg) {
        int lineCount = msg.byteBuf().readIntLE();
        return RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), lineCount).map((Function1<Object, ChatMessage> & Serializable & scala.Serializable)i -> GamePacketHandlerTBC.$anonfun$parseServerMotd$1(this, msg, BoxesRunTime.unboxToInt(i)), IndexedSeq$.MODULE$.canBuildFrom());
    }

    @Override
    public Map<Object, GuildMember> parseGuildRoster(Packet msg) {
        int count = msg.byteBuf().readIntLE();
        this.guildMotd_$eq(new Some<String>(msg.readString()));
        String ginfo = msg.readString();
        int rankscount = msg.byteBuf().readIntLE();
        RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), rankscount).foreach((Function1<Object, ByteBuf> & Serializable & scala.Serializable)i -> GamePacketHandlerTBC.$anonfun$parseGuildRoster$1(msg, BoxesRunTime.unboxToInt(i)));
        return ((TraversableOnce)RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), count).map((Function1<Object, Tuple2> & Serializable & scala.Serializable)i -> GamePacketHandlerTBC.$anonfun$parseGuildRoster$2(msg, BoxesRunTime.unboxToInt(i)), IndexedSeq$.MODULE$.canBuildFrom())).toMap(Predef$.MODULE$.$conforms());
    }

    @Override
    public void writeJoinChannel(ByteBuf out, int id, byte[] utf8ChannelBytes) {
        out.writeIntLE(id);
        out.writeByte(0);
        out.writeByte(1);
        super.writeJoinChannel(out, id, utf8ChannelBytes);
    }

    private void handle_SMSG_TIME_SYNC_REQ(Packet msg) {
        int counter2 = msg.byteBuf().readIntLE();
        int uptime = (int)(System.currentTimeMillis() - this.connectTime());
        ByteBuf byteBuf = PooledByteBufAllocator.DEFAULT.buffer(8, 8);
        byteBuf.writeIntLE(counter2);
        byteBuf.writeIntLE(uptime);
        ((ChannelOutboundInvoker)this.ctx().get()).writeAndFlush(new Packet(this.CMSG_TIME_SYNC_RESP(), byteBuf));
    }

    public static final /* synthetic */ byte $anonfun$addonInfo$1(int x$1) {
        return (byte)x$1;
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
        msg$1.byteBuf().skipBytes(171);
        return msg$1.byteBuf().skipBytes(9);
    }

    public static final /* synthetic */ ChatMessage $anonfun$parseServerMotd$1(GamePacketHandlerTBC $this, Packet msg$2, int i) {
        String message = msg$2.readString();
        return new ChatMessage(0L, $this.ChatEvents().CHAT_MSG_SYSTEM(), message, None$.MODULE$);
    }

    public static final /* synthetic */ ByteBuf $anonfun$parseGuildRoster$1(Packet msg$3, int i) {
        return msg$3.byteBuf().skipBytes(56);
    }

    public static final /* synthetic */ Tuple2 $anonfun$parseGuildRoster$2(Packet msg$3, int i) {
        long guid = msg$3.byteBuf().readLongLE();
        boolean isOnline = msg$3.byteBuf().readBoolean();
        String name = msg$3.readString();
        msg$3.byteBuf().skipBytes(4);
        byte level = msg$3.byteBuf().readByte();
        byte charClass = msg$3.byteBuf().readByte();
        msg$3.byteBuf().skipBytes(1);
        int zoneId = msg$3.byteBuf().readIntLE();
        float lastLogoff = !isOnline ? msg$3.byteBuf().readFloatLE() : 0.0f;
        msg$3.skipString();
        msg$3.skipString();
        return Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(BoxesRunTime.boxToLong(guid)), new GuildMember(name, isOnline, charClass, level, zoneId, lastLogoff));
    }

    public GamePacketHandlerTBC(int realmId, String realmName, byte[] sessionKey, CommonConnectionCallback gameEventCallback) {
        super(realmId, realmName, sessionKey, gameEventCallback);
        GamePacketsTBC.$init$(this);
        this.addonInfo = (byte[])new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(new int[]{208, 1, 0, 0, 120, 156, 117, 207, 59, 14, 194, 48, 12, 128, 225, 114, 15, 46, 67, 24, 80, 165, 102, 161, 101, 70, 38, 113, 43, 171, 137, 83, 25, 135, 71, 79, 15, 11, 98, 113, 189, 126, 214, 111, 217, 37, 90, 87, 144, 120, 61, 212, 160, 84, 248, 210, 54, 187, 252, 220, 119, 205, 119, 220, 207, 28, 168, 38, 28, 9, 83, 244, 196, 148, 97, 177, 150, 136, 35, 241, 100, 6, 142, 37, 223, 64, 187, 50, 109, 218, 128, 47, 181, 80, 96, 84, 51, 121, 242, 125, 149, 7, 190, 109, 172, 148, 162, 3, 158, 77, 109, 249, 190, 96, 176, 179, 173, 98, 238, 75, 152, 81, 183, 126, 241, 16, 164, 152, 114, 6, 138, 38, 12, 144, 144, 237, 123, 131, 64, 196, 126, 166, 148, 182, 152, 24, 197, 54, 202, 232, 129, 97, 66, 249, 235, 7, 99, 171, 139, 236})).map((Function1<Object, Object> & Serializable & scala.Serializable)x$1 -> BoxesRunTime.boxToByte(GamePacketHandlerTBC.$anonfun$addonInfo$1(BoxesRunTime.unboxToInt(x$1))), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Byte()));
        this.connectTime = System.currentTimeMillis();
    }
}

