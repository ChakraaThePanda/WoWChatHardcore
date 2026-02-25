/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import scala.Array$;
import scala.Function1;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Some;
import scala.Tuple2;
import scala.Tuple2$mcJI$sp;
import scala.collection.mutable.ArrayOps;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.NonLocalReturnControl;
import scala.runtime.RichInt$;
import scala.runtime.java8.JFunction2$mcJJI$sp;
import scala.util.Random$;
import wowchat.common.ByteUtils$;
import wowchat.common.CommonConnectionCallback;
import wowchat.common.Global$;
import wowchat.common.Packet;
import wowchat.common.WowChatConfig$;
import wowchat.game.AuthChallengeMessage;
import wowchat.game.CharEnumMessage;
import wowchat.game.ChatMessage;
import wowchat.game.GamePacketHandlerTBC;
import wowchat.game.GamePacketsWotLK;
import wowchat.game.GuildMember;
import wowchat.game.NameQueryMessage;

@ScalaSignature(bytes="\u0006\u0001\u0005\ra\u0001\u0002\b\u0010\u0001QA\u0001\u0002\b\u0001\u0003\u0002\u0003\u0006I!\b\u0005\tG\u0001\u0011\t\u0011)A\u0005I!Aq\u0006\u0001B\u0001B\u0003%\u0001\u0007\u0003\u00057\u0001\t\u0005\t\u0015!\u00038\u0011\u0015i\u0004\u0001\"\u0001?\u0011\u001d!\u0005A1A\u0005R\u0015CaA\u0012\u0001!\u0002\u0013\u0001\u0004\"B$\u0001\t#B\u0005\"B)\u0001\t#\u0012\u0006\"B,\u0001\t#B\u0006\"\u00021\u0001\t#\n\u0007\"B4\u0001\t#A\u0007\"B:\u0001\t\u0013!(AF$b[\u0016\u0004\u0016mY6fi\"\u000bg\u000e\u001a7fe^{G\u000fT&\u000b\u0005A\t\u0012\u0001B4b[\u0016T\u0011AE\u0001\bo><8\r[1u\u0007\u0001\u00192\u0001A\u000b\u001a!\t1r#D\u0001\u0010\u0013\tArB\u0001\u000bHC6,\u0007+Y2lKRD\u0015M\u001c3mKJ$&i\u0011\t\u0003-iI!aG\b\u0003!\u001d\u000bW.\u001a)bG.,Go],pi2[\u0015a\u0002:fC2l\u0017\n\u001a\t\u0003=\u0005j\u0011a\b\u0006\u0002A\u0005)1oY1mC&\u0011!e\b\u0002\u0004\u0013:$\u0018!\u0003:fC2lg*Y7f!\t)CF\u0004\u0002'UA\u0011qeH\u0007\u0002Q)\u0011\u0011fE\u0001\u0007yI|w\u000e\u001e \n\u0005-z\u0012A\u0002)sK\u0012,g-\u0003\u0002.]\t11\u000b\u001e:j]\u001eT!aK\u0010\u0002\u0015M,7o]5p].+\u0017\u0010E\u0002\u001fcMJ!AM\u0010\u0003\u000b\u0005\u0013(/Y=\u0011\u0005y!\u0014BA\u001b \u0005\u0011\u0011\u0015\u0010^3\u0002#\u001d\fW.Z#wK:$8)\u00197mE\u0006\u001c7\u000e\u0005\u00029w5\t\u0011H\u0003\u0002;#\u000511m\\7n_:L!\u0001P\u001d\u00031\r{W.\\8o\u0007>tg.Z2uS>t7)\u00197mE\u0006\u001c7.\u0001\u0004=S:LGO\u0010\u000b\u0006\u007f\u0001\u000b%i\u0011\t\u0003-\u0001AQ\u0001H\u0003A\u0002uAQaI\u0003A\u0002\u0011BQaL\u0003A\u0002ABQAN\u0003A\u0002]\n\u0011\"\u00193e_:LeNZ8\u0016\u0003A\n!\"\u00193e_:LeNZ8!\u0003I\u0001\u0018M]:f\u0003V$\bn\u00115bY2,gnZ3\u0015\u0005%c\u0005C\u0001\fK\u0013\tYuB\u0001\u000bBkRD7\t[1mY\u0016tw-Z'fgN\fw-\u001a\u0005\u0006\u001b\"\u0001\rAT\u0001\u0004[N<\u0007C\u0001\u001dP\u0013\t\u0001\u0016H\u0001\u0004QC\u000e\\W\r^\u0001\u000fa\u0006\u00148/\u001a(b[\u0016\fV/\u001a:z)\t\u0019f\u000b\u0005\u0002\u0017)&\u0011Qk\u0004\u0002\u0011\u001d\u0006lW-U;feflUm]:bO\u0016DQ!T\u0005A\u00029\u000bQ\u0002]1sg\u0016\u001c\u0005.\u0019:F]VlGCA-`!\rq\"\fX\u0005\u00037~\u0011aa\u00149uS>t\u0007C\u0001\f^\u0013\tqvBA\bDQ\u0006\u0014XI\\;n\u001b\u0016\u001c8/Y4f\u0011\u0015i%\u00021\u0001O\u0003A\u0001\u0018M]:f\u0007\"\fG/T3tg\u0006<W\r\u0006\u0002cMB\u0019aDW2\u0011\u0005Y!\u0017BA3\u0010\u0005-\u0019\u0005.\u0019;NKN\u001c\u0018mZ3\t\u000b5[\u0001\u0019\u0001(\u0002-!\fg\u000e\u001a7f\u0003\u000eD\u0017.\u001a<f[\u0016tG/\u0012<f]R$2!\u001b7r!\tq\".\u0003\u0002l?\t!QK\\5u\u0011\u0015iG\u00021\u0001o\u0003\u00119W/\u001b3\u0011\u0005yy\u0017B\u00019 \u0005\u0011auN\\4\t\u000bId\u0001\u0019A\u000f\u0002\u001b\u0005\u001c\u0007.[3wK6,g\u000e^%e\u0003))h\u000e]1dW\u001e+\u0018\u000e\u001a\u000b\u0003]VDQA^\u0007A\u0002]\fqAY=uK\n+h\r\u0005\u0002y\u007f6\t\u0011P\u0003\u0002{w\u00061!-\u001e4gKJT!\u0001`?\u0002\u000b9,G\u000f^=\u000b\u0003y\f!![8\n\u0007\u0005\u0005\u0011PA\u0004CsR,')\u001e4")
public class GamePacketHandlerWotLK
extends GamePacketHandlerTBC
implements GamePacketsWotLK {
    private final int realmId;
    private final byte[] sessionKey;
    private final byte[] addonInfo;
    private final int SMSG_GM_MESSAGECHAT;
    private final int CMSG_KEEP_ALIVE;

    @Override
    public int SMSG_GM_MESSAGECHAT() {
        return this.SMSG_GM_MESSAGECHAT;
    }

    @Override
    public int CMSG_KEEP_ALIVE() {
        return this.CMSG_KEEP_ALIVE;
    }

    @Override
    public void wowchat$game$GamePacketsWotLK$_setter_$SMSG_GM_MESSAGECHAT_$eq(int x$1) {
        this.SMSG_GM_MESSAGECHAT = x$1;
    }

    @Override
    public void wowchat$game$GamePacketsWotLK$_setter_$CMSG_KEEP_ALIVE_$eq(int x$1) {
        this.CMSG_KEEP_ALIVE = x$1;
    }

    @Override
    public byte[] addonInfo() {
        return this.addonInfo;
    }

    @Override
    public AuthChallengeMessage parseAuthChallenge(Packet msg) {
        byte[] account = Global$.MODULE$.config().wow().account();
        msg.byteBuf().skipBytes(4);
        int serverSeed = msg.byteBuf().readInt();
        int clientSeed = Random$.MODULE$.nextInt();
        ByteBuf out = PooledByteBufAllocator.DEFAULT.buffer(200, 400);
        out.writeShortLE(0);
        out.writeIntLE(WowChatConfig$.MODULE$.getGameBuild());
        out.writeIntLE(0);
        out.writeBytes(account);
        out.writeByte(0);
        out.writeInt(0);
        out.writeInt(clientSeed);
        out.writeIntLE(0);
        out.writeIntLE(0);
        out.writeIntLE(this.realmId);
        out.writeLongLE(3L);
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.update(account);
        md.update((byte[])Array$.MODULE$.apply(Predef$.MODULE$.wrapByteArray(new byte[]{0, 0, 0, 0}), ClassTag$.MODULE$.Byte()));
        md.update(ByteUtils$.MODULE$.intToBytes(clientSeed));
        md.update(ByteUtils$.MODULE$.intToBytes(serverSeed));
        md.update(this.sessionKey);
        out.writeBytes(md.digest());
        out.writeBytes(this.addonInfo());
        return new AuthChallengeMessage(this.sessionKey, out);
    }

    @Override
    public NameQueryMessage parseNameQuery(Packet msg) {
        Tuple2<String, Byte> tuple2;
        Tuple2<String, Byte> tuple22;
        long guid = this.unpackGuid(msg.byteBuf());
        byte nameKnown = msg.byteBuf().readByte();
        if (nameKnown == 0) {
            String name = msg.readString();
            msg.skipString();
            msg.byteBuf().skipBytes(1);
            msg.byteBuf().skipBytes(1);
            byte charClass = msg.byteBuf().readByte();
            tuple22 = new Tuple2<String, Byte>(name, BoxesRunTime.boxToByte(charClass));
        } else {
            BoxedUnit boxedUnit;
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("RECV SMSG_NAME_QUERY - Name not known for guid {}", new Object[]{BoxesRunTime.boxToLong(guid)});
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
            tuple22 = tuple2 = new Tuple2<String, Byte>("UNKNOWN", BoxesRunTime.boxToByte((byte)255));
        }
        if (tuple2 == null) {
            throw new MatchError(tuple2);
        }
        String name = tuple2._1();
        byte charClass = BoxesRunTime.unboxToByte(tuple2._2());
        Tuple2<String, Byte> tuple23 = new Tuple2<String, Byte>(name, BoxesRunTime.boxToByte(charClass));
        Tuple2<String, Byte> tuple24 = tuple23;
        String name2 = tuple24._1();
        byte charClass2 = BoxesRunTime.unboxToByte(tuple24._2());
        return new NameQueryMessage(guid, name2, charClass2);
    }

    @Override
    public Option<CharEnumMessage> parseCharEnum(Packet msg) {
        Option option;
        Object object = new Object();
        try {
            byte[] characterBytes = Global$.MODULE$.config().wow().character().toLowerCase().getBytes("UTF-8");
            byte charactersNum = msg.byteBuf().readByte();
            RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), charactersNum).foreach((Function1<Object, ByteBuf> & Serializable & scala.Serializable)i -> GamePacketHandlerWotLK.$anonfun$parseCharEnum$1(msg, characterBytes, object, BoxesRunTime.unboxToInt(i)));
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
        Option option;
        Option channelName;
        Serializable serializable;
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
        if (msg.id() == this.SMSG_GM_MESSAGECHAT()) {
            msg.byteBuf().skipBytes(4);
            serializable = msg.skipString();
        } else {
            serializable = BoxedUnit.UNIT;
        }
        Option option2 = channelName = tp == this.ChatEvents().CHAT_MSG_CHANNEL() ? new Some<String>(msg.readString()) : None$.MODULE$;
        if (tp != this.ChatEvents().CHAT_MSG_GUILD_ACHIEVEMENT() && !Global$.MODULE$.wowToDiscord().contains(new Tuple2(BoxesRunTime.boxToByte(tp), channelName.map((Function1<String, String> & Serializable & scala.Serializable)x$3 -> x$3.toLowerCase())))) {
            return None$.MODULE$;
        }
        msg.byteBuf().skipBytes(8);
        int txtLen = msg.byteBuf().readIntLE();
        String txt = ((Object)msg.byteBuf().readCharSequence(txtLen - 1, Charset.forName("UTF-8"))).toString();
        msg.byteBuf().skipBytes(1);
        msg.byteBuf().skipBytes(1);
        if (tp == this.ChatEvents().CHAT_MSG_GUILD_ACHIEVEMENT()) {
            this.handleAchievementEvent(guid, msg.byteBuf().readIntLE());
            option = None$.MODULE$;
        } else {
            option = new Some<ChatMessage>(new ChatMessage(guid, tp, txt, channelName));
        }
        return option;
    }

    public void handleAchievementEvent(long guid, int achievementId) {
        this.guildRoster().get(BoxesRunTime.boxToLong(guid)).foreach((Function1<GuildMember, Object> & Serializable & scala.Serializable)player -> {
            GamePacketHandlerWotLK.$anonfun$handleAchievementEvent$1(achievementId, player);
            return BoxedUnit.UNIT;
        });
    }

    private long unpackGuid(ByteBuf byteBuf) {
        byte set = byteBuf.readByte();
        return BoxesRunTime.unboxToLong(RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), 8).foldLeft(BoxesRunTime.boxToLong(0L), (JFunction2$mcJJI$sp & scala.Serializable)(x0$1, x1$1) -> {
            Tuple2$mcJI$sp tuple2$mcJI$sp = new Tuple2$mcJI$sp(x0$1, x1$1);
            if (tuple2$mcJI$sp == null) {
                throw new MatchError(tuple2$mcJI$sp);
            }
            long result2 = ((Tuple2)tuple2$mcJI$sp)._1$mcJ$sp();
            int i = ((Tuple2)tuple2$mcJI$sp)._2$mcI$sp();
            int onBit = 1 << i;
            long l = (set & onBit) == onBit ? result2 | ((long)byteBuf.readByte() & 0xFFL) << i * 8 : result2;
            return l;
        }));
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
        msg$1.byteBuf().skipBytes(4);
        msg$1.byteBuf().skipBytes(1);
        msg$1.byteBuf().skipBytes(12);
        msg$1.byteBuf().skipBytes(171);
        return msg$1.byteBuf().skipBytes(36);
    }

    public static final /* synthetic */ void $anonfun$handleAchievementEvent$1(int achievementId$1, GuildMember player) {
        Global$.MODULE$.discord().sendAchievementNotification(player.name(), achievementId$1);
    }

    public GamePacketHandlerWotLK(int realmId, String realmName, byte[] sessionKey, CommonConnectionCallback gameEventCallback) {
        this.realmId = realmId;
        this.sessionKey = sessionKey;
        super(realmId, realmName, sessionKey, gameEventCallback);
        GamePacketsWotLK.$init$(this);
        this.addonInfo = (byte[])new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(new int[]{158, 2, 0, 0, 120, 156, 117, 210, 193, 106, 195, 48, 12, 198, 113, 239, 41, 118, 233, 155, 236, 180, 180, 80, 194, 234, 203, 226, 158, 139, 98, 127, 75, 68, 108, 57, 56, 78, 183, 246, 61, 250, 190, 101, 183, 13, 148, 243, 79, 72, 240, 71, 175, 198, 152, 38, 242, 253, 78, 37, 92, 222, 253, 200, 184, 34, 65, 234, 185, 53, 47, 233, 123, 119, 50, 255, 188, 64, 72, 151, 213, 87, 206, 162, 90, 67, 165, 71, 89, 198, 60, 111, 112, 173, 17, 95, 140, 24, 44, 11, 39, 154, 181, 33, 150, 192, 50, 168, 11, 246, 20, 33, 129, 138, 70, 57, 245, 84, 79, 121, 216, 52, 135, 159, 170, 224, 1, 253, 58, 184, 156, 227, 162, 224, 209, 238, 71, 210, 11, 29, 109, 183, 150, 43, 110, 58, 198, 219, 60, 234, 178, 114, 12, 13, 201, 164, 106, 43, 203, 12, 175, 31, 108, 43, 82, 151, 253, 132, 186, 149, 199, 146, 47, 89, 149, 79, 226, 160, 130, 251, 45, 170, 223, 115, 156, 96, 73, 104, 128, 214, 219, 229, 9, 250, 19, 184, 66, 1, 221, 196, 49, 110, 49, 11, 202, 95, 123, 123, 28, 62, 158, 225, 147, 200, 141})).map((Function1<Object, Object> & Serializable & scala.Serializable)x$1 -> BoxesRunTime.boxToByte(GamePacketHandlerWotLK.$anonfun$addonInfo$1(BoxesRunTime.unboxToInt(x$1))), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Byte()));
    }
}

