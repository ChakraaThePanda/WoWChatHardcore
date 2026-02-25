/*
 * Decompiled with CFR 0.152.
 */
package wowchat.realm;

import com.typesafe.scalalogging.Logger;
import com.typesafe.scalalogging.StrictLogging;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundInvoker;
import java.io.Serializable;
import java.security.MessageDigest;
import scala.Array$;
import scala.Enumeration;
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
import scala.collection.immutable.IndexedSeq$;
import scala.collection.immutable.Map;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.ArrayBuilder;
import scala.collection.mutable.ArrayOps;
import scala.io.StdIn$;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.RichInt$;
import wowchat.common.ByteUtils$;
import wowchat.common.Global$;
import wowchat.common.Packet;
import wowchat.common.Platform$;
import wowchat.common.WowChatConfig$;
import wowchat.common.WowExpansion$;
import wowchat.realm.BigNumber;
import wowchat.realm.BigNumber$;
import wowchat.realm.RealmConnectionCallback;
import wowchat.realm.RealmList;
import wowchat.realm.RealmPackets$;
import wowchat.realm.RealmPackets$AuthResult$;
import wowchat.realm.SRPClient;

@ScalaSignature(bytes="\u0006\u0001\u00055f\u0001\u0002\u000f\u001e\u0001\tB\u0001b\u000e\u0001\u0003\u0002\u0003\u0006I\u0001\u000f\u0005\u0006y\u0001!\t!\u0010\u0005\b\u0001\u0002\u0011\r\u0011\"\u0003B\u0011\u0019)\u0005\u0001)A\u0005\u0005\"9a\t\u0001a\u0001\n\u00139\u0005bB)\u0001\u0001\u0004%IA\u0015\u0005\u00071\u0002\u0001\u000b\u0015\u0002%\t\u000fe\u0003\u0001\u0019!C\u00055\"9a\f\u0001a\u0001\n\u0013y\u0006BB1\u0001A\u0003&1\fC\u0005c\u0001\u0001\u0007\t\u0019!C\u0005G\"I!\u000e\u0001a\u0001\u0002\u0004%Ia\u001b\u0005\n[\u0002\u0001\r\u0011!Q!\n\u0011DqA\u001c\u0001A\u0002\u0013%q\u000eC\u0004t\u0001\u0001\u0007I\u0011\u0002;\t\rY\u0004\u0001\u0015)\u0003q\u0011\u001d9\bA1A\u0005\naDq!a\b\u0001A\u0003%\u0011\u0010C\u0004\u0002\"\u0001!\t%a\t\t\u000f\u0005\u001d\u0002\u0001\"\u0011\u0002*!9\u0011Q\u0006\u0001\u0005B\u0005=\u0002bBA\u001f\u0001\u0011%\u0011q\b\u0005\b\u0003\u0013\u0002A\u0011BA&\u0011\u001d\ty\u0005\u0001C\u0005\u0003#Bq!!\u0016\u0001\t#\t9\u0006C\u0004\u0002z\u0001!I!a\u001f\t\u0013\u0005U\u0005!%A\u0005\n\u0005]%A\u0005*fC2l\u0007+Y2lKRD\u0015M\u001c3mKJT!AH\u0010\u0002\u000bI,\u0017\r\\7\u000b\u0003\u0001\nqa^8xG\"\fGo\u0001\u0001\u0014\u0007\u0001\u0019S\u0006\u0005\u0002%W5\tQE\u0003\u0002'O\u000591\r[1o]\u0016d'B\u0001\u0015*\u0003\u0015qW\r\u001e;z\u0015\u0005Q\u0013AA5p\u0013\taSE\u0001\u000fDQ\u0006tg.\u001a7J]\n|WO\u001c3IC:$G.\u001a:BI\u0006\u0004H/\u001a:\u0011\u00059*T\"A\u0018\u000b\u0005A\n\u0014\u0001D:dC2\fGn\\4hS:<'B\u0001\u001a4\u0003!!\u0018\u0010]3tC\u001a,'\"\u0001\u001b\u0002\u0007\r|W.\u0003\u00027_\ti1\u000b\u001e:jGRdunZ4j]\u001e\fqC]3bY6\u001cuN\u001c8fGRLwN\\\"bY2\u0014\u0017mY6\u0011\u0005eRT\"A\u000f\n\u0005mj\"a\u0006*fC2l7i\u001c8oK\u000e$\u0018n\u001c8DC2d'-Y2l\u0003\u0019a\u0014N\\5u}Q\u0011ah\u0010\t\u0003s\u0001AQa\u000e\u0002A\u0002a\n\u0011b\u001d:q\u00072LWM\u001c;\u0016\u0003\t\u0003\"!O\"\n\u0005\u0011k\"!C*S!\u000ec\u0017.\u001a8u\u0003)\u0019(\u000f]\"mS\u0016tG\u000fI\u0001\u0004GRDX#\u0001%\u0011\u0007%ce*D\u0001K\u0015\u0005Y\u0015!B:dC2\f\u0017BA'K\u0005\u0019y\u0005\u000f^5p]B\u0011AeT\u0005\u0003!\u0016\u0012Qc\u00115b]:,G\u000eS1oI2,'oQ8oi\u0016DH/A\u0004dib|F%Z9\u0015\u0005M3\u0006CA%U\u0013\t)&J\u0001\u0003V]&$\bbB,\u0007\u0003\u0003\u0005\r\u0001S\u0001\u0004q\u0012\n\u0014\u0001B2uq\u0002\n!#\u001a=qK\u000e$X\r\u001a#jg\u000e|gN\\3diV\t1\f\u0005\u0002J9&\u0011QL\u0013\u0002\b\u0005>|G.Z1o\u0003Y)\u0007\u0010]3di\u0016$G)[:d_:tWm\u0019;`I\u0015\fHCA*a\u0011\u001d9\u0016\"!AA\u0002m\u000b1#\u001a=qK\u000e$X\r\u001a#jg\u000e|gN\\3di\u0002\n!b]3tg&|gnS3z+\u0005!\u0007cA%fO&\u0011aM\u0013\u0002\u0006\u0003J\u0014\u0018-\u001f\t\u0003\u0013\"L!!\u001b&\u0003\t\tKH/Z\u0001\u000fg\u0016\u001c8/[8o\u0017\u0016Lx\fJ3r)\t\u0019F\u000eC\u0004X\u0019\u0005\u0005\t\u0019\u00013\u0002\u0017M,7o]5p].+\u0017\u0010I\u0001\u000bY><wN\\*uCR,W#\u00019\u0011\u0005%\u000b\u0018B\u0001:K\u0005\rIe\u000e^\u0001\u000fY><wN\\*uCR,w\fJ3r)\t\u0019V\u000fC\u0004X\u001f\u0005\u0005\t\u0019\u00019\u0002\u00171|wm\u001c8Ti\u0006$X\rI\u0001\u000fEVLG\u000eZ\"sG\"\u000b7\u000f[3t+\u0005I\b#\u0002>\u0000\u0003\u0007!W\"A>\u000b\u0005ql\u0018!C5n[V$\u0018M\u00197f\u0015\tq(*\u0001\u0006d_2dWm\u0019;j_:L1!!\u0001|\u0005\ri\u0015\r\u001d\t\u0007\u0013\u0006\u0015\u0001/!\u0003\n\u0007\u0005\u001d!J\u0001\u0004UkBdWM\r\t\u0005\u0003\u0017\t9B\u0004\u0003\u0002\u000e\u0005MQBAA\b\u0015\r\t\tbH\u0001\u0007G>lWn\u001c8\n\t\u0005U\u0011qB\u0001\t!2\fGOZ8s[&!\u0011\u0011DA\u000e\u0005\u00151\u0016\r\\;f\u0013\r\tiB\u0013\u0002\f\u000b:,X.\u001a:bi&|g.A\bck&dGm\u0011:d\u0011\u0006\u001c\b.Z:!\u0003=\u0019\u0007.\u00198oK2Le.Y2uSZ,GcA*\u0002&!)ai\u0005a\u0001\u001d\u0006i1\r[1o]\u0016d\u0017i\u0019;jm\u0016$2aUA\u0016\u0011\u00151E\u00031\u0001O\u0003-\u0019\u0007.\u00198oK2\u0014V-\u00193\u0015\u000bM\u000b\t$a\r\t\u000b\u0019+\u0002\u0019\u0001(\t\u000f\u0005UR\u00031\u0001\u00028\u0005\u0019Qn]4\u0011\u0007%\u000bI$C\u0002\u0002<)\u00131!\u00118z\u0003}A\u0017M\u001c3mK~\u001bU\nR0B+RCu\fT(H\u001f:{6\tS!M\u0019\u0016su)\u0012\u000b\u0004'\u0006\u0005\u0003bBA\u001b-\u0001\u0007\u00111\t\t\u0005\u0003\u001b\t)%\u0003\u0003\u0002H\u0005=!A\u0002)bG.,G/A\u000eiC:$G.Z0D\u001b\u0012{\u0016)\u0016+I?2{ui\u0014(`!J{uJ\u0012\u000b\u0004'\u00065\u0003bBA\u001b/\u0001\u0007\u00111I\u0001\u0016Q\u0006tG\r\\3`\u00076#uLU#B\u00196{F*S*U)\r\u0019\u00161\u000b\u0005\b\u0003kA\u0002\u0019AA\"\u00039\u0001\u0018M]:f%\u0016\fG.\u001c'jgR$B!!\u0017\u0002xA1\u00111LA6\u0003crA!!\u0018\u0002h9!\u0011qLA3\u001b\t\t\tGC\u0002\u0002d\u0005\na\u0001\u0010:p_Rt\u0014\"A&\n\u0007\u0005%$*A\u0004qC\u000e\\\u0017mZ3\n\t\u00055\u0014q\u000e\u0002\u0004'\u0016\f(bAA5\u0015B\u0019\u0011(a\u001d\n\u0007\u0005UTDA\u0005SK\u0006dW\u000eT5ti\"9\u0011QG\rA\u0002\u0005\r\u0013a\u0002;p\u0003J\u0014\u0018-\u001f\u000b\bI\u0006u\u0014QRAI\u0011\u001d\tyH\u0007a\u0001\u0003\u0003\u000bqAY=uK\n+h\r\u0005\u0003\u0002\u0004\u0006%UBAAC\u0015\r\t9iJ\u0001\u0007EV4g-\u001a:\n\t\u0005-\u0015Q\u0011\u0002\b\u0005f$XMQ;g\u0011\u0019\tyI\u0007a\u0001a\u0006!1/\u001b>f\u0011!\t\u0019J\u0007I\u0001\u0002\u0004Y\u0016a\u0002:fm\u0016\u00148/Z\u0001\u0012i>\f%O]1zI\u0011,g-Y;mi\u0012\u001aTCAAMU\rY\u00161T\u0016\u0003\u0003;\u0003B!a(\u0002*6\u0011\u0011\u0011\u0015\u0006\u0005\u0003G\u000b)+A\u0005v]\u000eDWmY6fI*\u0019\u0011q\u0015&\u0002\u0015\u0005tgn\u001c;bi&|g.\u0003\u0003\u0002,\u0006\u0005&!E;oG\",7m[3e-\u0006\u0014\u0018.\u00198dK\u0002")
public class RealmPacketHandler
extends ChannelInboundHandlerAdapter
implements StrictLogging {
    private final RealmConnectionCallback realmConnectionCallback;
    private final SRPClient srpClient;
    private Option<ChannelHandlerContext> ctx;
    private boolean expectedDisconnect;
    private byte[] sessionKey;
    private int logonState;
    private final Map<Tuple2<Object, Enumeration.Value>, byte[]> buildCrcHashes;
    private final Logger logger;

    @Override
    public Logger logger() {
        return this.logger;
    }

    @Override
    public void com$typesafe$scalalogging$StrictLogging$_setter_$logger_$eq(Logger x$1) {
        this.logger = x$1;
    }

    private SRPClient srpClient() {
        return this.srpClient;
    }

    private Option<ChannelHandlerContext> ctx() {
        return this.ctx;
    }

    private void ctx_$eq(Option<ChannelHandlerContext> x$1) {
        this.ctx = x$1;
    }

    private boolean expectedDisconnect() {
        return this.expectedDisconnect;
    }

    private void expectedDisconnect_$eq(boolean x$1) {
        this.expectedDisconnect = x$1;
    }

    private byte[] sessionKey() {
        return this.sessionKey;
    }

    private void sessionKey_$eq(byte[] x$1) {
        this.sessionKey = x$1;
    }

    private int logonState() {
        return this.logonState;
    }

    private void logonState_$eq(int x$1) {
        this.logonState = x$1;
    }

    private Map<Tuple2<Object, Enumeration.Value>, byte[]> buildCrcHashes() {
        return this.buildCrcHashes;
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        if (!this.expectedDisconnect()) {
            this.realmConnectionCallback.disconnected();
        }
        super.channelInactive(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        String string;
        BoxedUnit boxedUnit;
        if (this.logger().underlying().isInfoEnabled()) {
            this.logger().underlying().info("Connected! Sending account login information...");
            boxedUnit = BoxedUnit.UNIT;
        } else {
            boxedUnit = BoxedUnit.UNIT;
        }
        this.ctx_$eq(new Some<ChannelHandlerContext>(ctx));
        byte[] version = (byte[])new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])WowChatConfig$.MODULE$.getVersion().split("\\."))).map((Function1<String, Object> & Serializable & scala.Serializable)x$17 -> BoxesRunTime.boxToByte(RealmPacketHandler.$anonfun$channelActive$1(x$17)), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Byte()));
        byte[] accountConfig = Global$.MODULE$.config().wow().account();
        Enumeration.Value value = Global$.MODULE$.config().wow().platform();
        Enumeration.Value value2 = Platform$.MODULE$.Windows();
        Enumeration.Value value3 = value;
        if (!(value2 != null ? !((Object)value2).equals(value3) : value3 != null)) {
            string = "Win";
        } else {
            Enumeration.Value value4 = Platform$.MODULE$.Mac();
            Enumeration.Value value5 = value;
            if (!(value4 != null ? !((Object)value4).equals(value5) : value5 != null)) {
                string = "OSX";
            } else {
                throw new MatchError(value);
            }
        }
        String platformString = string;
        String localeString = Global$.MODULE$.config().wow().locale();
        ByteBuf byteBuf = PooledByteBufAllocator.DEFAULT.buffer(50, 100);
        Enumeration.Value value6 = WowChatConfig$.MODULE$.getExpansion();
        Enumeration.Value value7 = WowExpansion$.MODULE$.Vanilla();
        ByteBuf byteBuf2 = !(value6 != null ? !((Object)value6).equals(value7) : value7 != null) ? byteBuf.writeByte(3) : byteBuf.writeByte(8);
        byteBuf.writeShortLE(30 + accountConfig.length);
        byteBuf.writeIntLE(ByteUtils$.MODULE$.stringToInt("WoW"));
        byteBuf.writeByte(version[0]);
        byteBuf.writeByte(version[1]);
        byteBuf.writeByte(version[2]);
        byteBuf.writeShortLE(WowChatConfig$.MODULE$.getRealmBuild());
        byteBuf.writeIntLE(ByteUtils$.MODULE$.stringToInt("x86"));
        byteBuf.writeIntLE(ByteUtils$.MODULE$.stringToInt(platformString));
        byteBuf.writeIntLE(ByteUtils$.MODULE$.stringToInt(localeString));
        byteBuf.writeIntLE(0);
        byteBuf.writeByte(127);
        byteBuf.writeByte(0);
        byteBuf.writeByte(0);
        byteBuf.writeByte(1);
        byteBuf.writeByte(accountConfig.length);
        byteBuf.writeBytes(accountConfig);
        ctx.writeAndFlush(new Packet(RealmPackets$.MODULE$.CMD_AUTH_LOGON_CHALLENGE(), byteBuf));
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        Object object = msg;
        if (object instanceof Packet) {
            Packet packet = (Packet)object;
            int n = packet.id();
            if (RealmPackets$.MODULE$.CMD_AUTH_LOGON_CHALLENGE() == n && this.logonState() == 0) {
                this.handle_CMD_AUTH_LOGON_CHALLENGE(packet);
                BoxedUnit boxedUnit = BoxedUnit.UNIT;
            } else if (RealmPackets$.MODULE$.CMD_AUTH_LOGON_PROOF() == n && this.logonState() == 1) {
                this.handle_CMD_AUTH_LOGON_PROOF(packet);
                BoxedUnit boxedUnit = BoxedUnit.UNIT;
            } else if (RealmPackets$.MODULE$.CMD_REALM_LIST() == n && this.logonState() == 2) {
                this.handle_CMD_REALM_LIST(packet);
                BoxedUnit boxedUnit = BoxedUnit.UNIT;
            } else {
                BoxedUnit boxedUnit;
                if (this.logger().underlying().isInfoEnabled()) {
                    int arg$macro$1 = packet.id();
                    Integer arg$macro$2 = BoxesRunTime.boxToInteger(this.logonState());
                    this.logger().underlying().info(new StringOps("Received packet %04X in unexpected logonState %s").format(Predef$.MODULE$.genericWrapArray(new Object[]{BoxesRunTime.boxToInteger(arg$macro$1), arg$macro$2})));
                    boxedUnit = BoxedUnit.UNIT;
                } else {
                    boxedUnit = BoxedUnit.UNIT;
                }
                packet.byteBuf().release();
                return;
            }
            packet.byteBuf().release();
            this.logonState_$eq(this.logonState() + 1);
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        } else {
            BoxedUnit boxedUnit;
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("Packet is instance of {}", new Object[]{object.getClass()});
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
            BoxedUnit boxedUnit2 = boxedUnit;
        }
    }

    private void handle_CMD_AUTH_LOGON_CHALLENGE(Packet msg) {
        Option option;
        byte by = msg.byteBuf().readByte();
        byte result2 = msg.byteBuf().readByte();
        if (!RealmPackets$AuthResult$.MODULE$.isSuccess(result2)) {
            BoxedUnit boxedUnit;
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error(RealmPackets$AuthResult$.MODULE$.getMessage(result2));
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
            ((ChannelOutboundInvoker)this.ctx().get()).close();
            this.realmConnectionCallback.error();
            return;
        }
        byte[] B = this.toArray(msg.byteBuf(), 32, this.toArray$default$3());
        byte gLength = msg.byteBuf().readByte();
        byte[] g = this.toArray(msg.byteBuf(), gLength, this.toArray$default$3());
        byte nLength = msg.byteBuf().readByte();
        byte[] n = this.toArray(msg.byteBuf(), nLength, this.toArray$default$3());
        byte[] salt = this.toArray(msg.byteBuf(), 32, this.toArray$default$3());
        msg.byteBuf().skipBytes(16);
        byte securityFlag = msg.byteBuf().readByte();
        if (securityFlag == 4) {
            BoxedUnit boxedUnit;
            msg.byteBuf().readByte();
            if (this.logger().underlying().isInfoEnabled()) {
                this.logger().underlying().info("Token two factor authentication is enabled for this account. Input the token:");
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
            option = new Some<String>(StdIn$.MODULE$.readLine());
        } else {
            if (securityFlag != 0) {
                BoxedUnit boxedUnit;
                if (this.logger().underlying().isErrorEnabled()) {
                    this.logger().underlying().error("Two factor authentication of type {} is enabled for this account which is not supported. Please disable it or use another account.", new Object[]{BoxesRunTime.boxToByte(securityFlag)});
                    boxedUnit = BoxedUnit.UNIT;
                } else {
                    boxedUnit = BoxedUnit.UNIT;
                }
                ((ChannelOutboundInvoker)this.ctx().get()).close();
                this.realmConnectionCallback.error();
                return;
            }
            option = None$.MODULE$;
        }
        None$ token2 = option;
        this.srpClient().step1(Global$.MODULE$.config().wow().account(), Global$.MODULE$.config().wow().password(), BigNumber$.MODULE$.apply(B, BigNumber$.MODULE$.apply$default$2()), BigNumber$.MODULE$.apply(g, BigNumber$.MODULE$.apply$default$2()), BigNumber$.MODULE$.apply(n, BigNumber$.MODULE$.apply$default$2()), BigNumber$.MODULE$.apply(salt, BigNumber$.MODULE$.apply$default$2()));
        BigNumber qual$1 = this.srpClient().K();
        int x$1 = 40;
        boolean x$2 = qual$1.asByteArray$default$2();
        this.sessionKey_$eq(qual$1.asByteArray(x$1, x$2));
        BigNumber qual$2 = this.srpClient().A();
        int x$3 = 32;
        boolean x$4 = qual$2.asByteArray$default$2();
        byte[] aArray = qual$2.asByteArray(x$3, x$4);
        ByteBuf ret = PooledByteBufAllocator.DEFAULT.buffer(74, 128);
        ret.writeBytes(aArray);
        ret.writeBytes(this.srpClient().M().asByteArray(20, false));
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.update(aArray);
        md.update((byte[])this.buildCrcHashes().getOrElse(new Tuple2<Integer, Enumeration.Value>(BoxesRunTime.boxToInteger(WowChatConfig$.MODULE$.getRealmBuild()), Global$.MODULE$.config().wow().platform()), (Function0<byte[]> & Serializable & scala.Serializable)() -> new byte[20]));
        ret.writeBytes(md.digest());
        ret.writeByte(0);
        ret.writeByte(securityFlag);
        token2.foreach((Function1<String, ByteBuf> & Serializable & scala.Serializable)token -> {
            ret.writeByte(token.length());
            return ret.writeBytes(token.getBytes("UTF-8"));
        });
        ((ChannelOutboundInvoker)this.ctx().get()).writeAndFlush(new Packet(RealmPackets$.MODULE$.CMD_AUTH_LOGON_PROOF(), ret));
    }

    private void handle_CMD_AUTH_LOGON_PROOF(Packet msg) {
        BoxedUnit boxedUnit;
        byte result2 = msg.byteBuf().readByte();
        if (!RealmPackets$AuthResult$.MODULE$.isSuccess(result2)) {
            BoxedUnit boxedUnit2;
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error(RealmPackets$AuthResult$.MODULE$.getMessage(result2));
                boxedUnit2 = BoxedUnit.UNIT;
            } else {
                boxedUnit2 = BoxedUnit.UNIT;
            }
            this.expectedDisconnect_$eq(true);
            ((ChannelOutboundInvoker)this.ctx().get()).close();
            if (result2 == RealmPackets$AuthResult$.MODULE$.WOW_FAIL_UNKNOWN_ACCOUNT()) {
                this.realmConnectionCallback.disconnected();
            } else {
                this.realmConnectionCallback.error();
            }
            return;
        }
        byte[] proof = this.toArray(msg.byteBuf(), 20, false);
        if (!new ArrayOps.ofByte(Predef$.MODULE$.byteArrayOps(proof)).sameElements(Predef$.MODULE$.wrapByteArray(this.srpClient().generateHashLogonProof()))) {
            BoxedUnit boxedUnit3;
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("Logon proof generated by client and server differ. Something is very wrong! Will try to reconnect in a moment.");
                boxedUnit3 = BoxedUnit.UNIT;
            } else {
                boxedUnit3 = BoxedUnit.UNIT;
            }
            this.expectedDisconnect_$eq(true);
            ((ChannelOutboundInvoker)this.ctx().get()).close();
            this.realmConnectionCallback.disconnected();
            return;
        }
        int n = msg.byteBuf().readIntLE();
        if (this.logger().underlying().isInfoEnabled()) {
            this.logger().underlying().info("Successfully logged into realm server. Looking for realm {}", new Object[]{Global$.MODULE$.config().wow().realmlist().name()});
            boxedUnit = BoxedUnit.UNIT;
        } else {
            boxedUnit = BoxedUnit.UNIT;
        }
        ByteBuf ret = PooledByteBufAllocator.DEFAULT.buffer(4, 4);
        ret.writeIntLE(0);
        ((ChannelOutboundInvoker)this.ctx().get()).writeAndFlush(new Packet(RealmPackets$.MODULE$.CMD_REALM_LIST(), ret));
    }

    private void handle_CMD_REALM_LIST(Packet msg) {
        BoxedUnit boxedUnit;
        String configRealm = Global$.MODULE$.config().wow().realmlist().name();
        Seq<RealmList> parsedRealmList = this.parseRealmList(msg);
        Seq realms = (Seq)parsedRealmList.filter((Function1<RealmList, Object> & Serializable & scala.Serializable)x0$1 -> BoxesRunTime.boxToBoolean(RealmPacketHandler.$anonfun$handle_CMD_REALM_LIST$1(configRealm, x0$1)));
        if (realms.isEmpty()) {
            BoxedUnit boxedUnit2;
            BoxedUnit boxedUnit3;
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("Realm {} not found!", new Object[]{configRealm});
                boxedUnit3 = BoxedUnit.UNIT;
            } else {
                boxedUnit3 = BoxedUnit.UNIT;
            }
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("{} possible realms:", new Object[]{BoxesRunTime.boxToInteger(parsedRealmList.length())});
                boxedUnit2 = BoxedUnit.UNIT;
            } else {
                boxedUnit2 = BoxedUnit.UNIT;
            }
            parsedRealmList.foreach((Function1<RealmList, Object> & Serializable & scala.Serializable)realm -> {
                RealmPacketHandler.$anonfun$handle_CMD_REALM_LIST$2(this, realm);
                return BoxedUnit.UNIT;
            });
            boxedUnit = BoxedUnit.UNIT;
        } else if (realms.length() > 1) {
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("Too many realms returned. Something is very wrong! This should never happen.");
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
        } else {
            String[] splt = ((RealmList)realms.head()).address().split(":");
            int port = new StringOps(Predef$.MODULE$.augmentString(splt[1])).toInt() & 0xFFFF;
            this.realmConnectionCallback.success(splt[0], port, ((RealmList)realms.head()).name(), ((RealmList)realms.head()).realmId(), this.sessionKey());
            boxedUnit = BoxedUnit.UNIT;
        }
        this.expectedDisconnect_$eq(true);
        ((ChannelOutboundInvoker)this.ctx().get()).close();
    }

    public Seq<RealmList> parseRealmList(Packet msg) {
        msg.byteBuf().readIntLE();
        byte numRealms = msg.byteBuf().readByte();
        return RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), numRealms).map((Function1<Object, RealmList> & Serializable & scala.Serializable)i -> RealmPacketHandler.$anonfun$parseRealmList$1(msg, BoxesRunTime.unboxToInt(i)), IndexedSeq$.MODULE$.canBuildFrom());
    }

    private byte[] toArray(ByteBuf byteBuf, int size, boolean reverse) {
        ArrayBuilder<Object> ret = Array$.MODULE$.newBuilder(ClassTag$.MODULE$.Byte());
        RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), size).foreach((Function1<Object, ArrayBuilder> & Serializable & scala.Serializable)x$18 -> RealmPacketHandler.$anonfun$toArray$1(ret, byteBuf, BoxesRunTime.unboxToInt(x$18)));
        return reverse ? (byte[])new ArrayOps.ofByte(Predef$.MODULE$.byteArrayOps((byte[])ret.result())).reverse() : (byte[])ret.result();
    }

    private boolean toArray$default$3() {
        return true;
    }

    public static final /* synthetic */ byte $anonfun$buildCrcHashes$1(int x$1) {
        return (byte)x$1;
    }

    public static final /* synthetic */ byte $anonfun$buildCrcHashes$2(int x$2) {
        return (byte)x$2;
    }

    public static final /* synthetic */ byte $anonfun$buildCrcHashes$3(int x$3) {
        return (byte)x$3;
    }

    public static final /* synthetic */ byte $anonfun$buildCrcHashes$4(int x$4) {
        return (byte)x$4;
    }

    public static final /* synthetic */ byte $anonfun$buildCrcHashes$5(int x$5) {
        return (byte)x$5;
    }

    public static final /* synthetic */ byte $anonfun$buildCrcHashes$6(int x$6) {
        return (byte)x$6;
    }

    public static final /* synthetic */ byte $anonfun$buildCrcHashes$7(int x$7) {
        return (byte)x$7;
    }

    public static final /* synthetic */ byte $anonfun$buildCrcHashes$8(int x$8) {
        return (byte)x$8;
    }

    public static final /* synthetic */ byte $anonfun$buildCrcHashes$9(int x$9) {
        return (byte)x$9;
    }

    public static final /* synthetic */ byte $anonfun$buildCrcHashes$10(int x$10) {
        return (byte)x$10;
    }

    public static final /* synthetic */ byte $anonfun$buildCrcHashes$11(int x$11) {
        return (byte)x$11;
    }

    public static final /* synthetic */ byte $anonfun$buildCrcHashes$12(int x$12) {
        return (byte)x$12;
    }

    public static final /* synthetic */ byte $anonfun$buildCrcHashes$13(int x$13) {
        return (byte)x$13;
    }

    public static final /* synthetic */ byte $anonfun$buildCrcHashes$14(int x$14) {
        return (byte)x$14;
    }

    public static final /* synthetic */ byte $anonfun$buildCrcHashes$15(int x$15) {
        return (byte)x$15;
    }

    public static final /* synthetic */ byte $anonfun$buildCrcHashes$16(int x$16) {
        return (byte)x$16;
    }

    public static final /* synthetic */ byte $anonfun$channelActive$1(String x$17) {
        return new StringOps(Predef$.MODULE$.augmentString(x$17)).toByte();
    }

    public static final /* synthetic */ boolean $anonfun$handle_CMD_REALM_LIST$1(String configRealm$1, RealmList x0$1) {
        RealmList realmList = x0$1;
        if (realmList == null) {
            throw new MatchError(realmList);
        }
        String name = realmList.name();
        boolean bl = name.equalsIgnoreCase(configRealm$1);
        return bl;
    }

    public static final /* synthetic */ void $anonfun$handle_CMD_REALM_LIST$2(RealmPacketHandler $this, RealmList realm) {
        BoxedUnit boxedUnit;
        if ($this.logger().underlying().isErrorEnabled()) {
            $this.logger().underlying().error(realm.name());
            boxedUnit = BoxedUnit.UNIT;
        } else {
            boxedUnit = BoxedUnit.UNIT;
        }
    }

    public static final /* synthetic */ RealmList $anonfun$parseRealmList$1(Packet msg$1, int i) {
        msg$1.byteBuf().skipBytes(4);
        byte realmFlags = msg$1.byteBuf().readByte();
        String name = (realmFlags & 4) == 4 ? msg$1.readString().replaceAll(" \\(\\d+,\\d+,\\d+\\)", "") : msg$1.readString();
        String address = msg$1.readString();
        msg$1.byteBuf().skipBytes(4);
        msg$1.byteBuf().skipBytes(1);
        msg$1.byteBuf().skipBytes(1);
        byte realmId = msg$1.byteBuf().readByte();
        return new RealmList(name, address, realmId);
    }

    public static final /* synthetic */ ArrayBuilder $anonfun$toArray$1(ArrayBuilder ret$2, ByteBuf byteBuf$1, int x$18) {
        return (ArrayBuilder)ret$2.$plus$eq(BoxesRunTime.boxToByte(byteBuf$1.readByte()));
    }

    public RealmPacketHandler(RealmConnectionCallback realmConnectionCallback) {
        this.realmConnectionCallback = realmConnectionCallback;
        StrictLogging.$init$(this);
        this.srpClient = new SRPClient();
        this.ctx = None$.MODULE$;
        this.expectedDisconnect = false;
        this.logonState = 0;
        this.buildCrcHashes = (Map)Predef$.MODULE$.Map().apply(Predef$.MODULE$.wrapRefArray((Object[])new Tuple2[]{Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(new Tuple2<Integer, Enumeration.Value>(BoxesRunTime.boxToInteger(4544), Platform$.MODULE$.Windows())), new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(new int[]{215, 172, 41, 12, 194, 228, 47, 156, 200, 58, 144, 35, 128, 58, 67, 36, 67, 89, 240, 48})).map((Function1<Object, Object> & Serializable & scala.Serializable)x$1 -> BoxesRunTime.boxToByte(RealmPacketHandler.$anonfun$buildCrcHashes$1(BoxesRunTime.unboxToInt(x$1))), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Byte()))), Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(new Tuple2<Integer, Enumeration.Value>(BoxesRunTime.boxToInteger(4565), Platform$.MODULE$.Windows())), new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(new int[]{26, 192, 44, 233, 62, 123, 130, 209, 126, 135, 24, 117, 141, 103, 245, 159, 176, 202, 75, 93})).map((Function1<Object, Object> & Serializable & scala.Serializable)x$2 -> BoxesRunTime.boxToByte(RealmPacketHandler.$anonfun$buildCrcHashes$2(BoxesRunTime.unboxToInt(x$2))), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Byte()))), Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(new Tuple2<Integer, Enumeration.Value>(BoxesRunTime.boxToInteger(4620), Platform$.MODULE$.Windows())), new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(new int[]{60, 119, 237, 149, 214, 0, 249, 212, 39, 13, 161, 162, 145, 199, 246, 69, 202, 79, 42, 172})).map((Function1<Object, Object> & Serializable & scala.Serializable)x$3 -> BoxesRunTime.boxToByte(RealmPacketHandler.$anonfun$buildCrcHashes$3(BoxesRunTime.unboxToInt(x$3))), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Byte()))), Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(new Tuple2<Integer, Enumeration.Value>(BoxesRunTime.boxToInteger(4695), Platform$.MODULE$.Windows())), new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(new int[]{55, 192, 18, 145, 39, 28, 187, 137, 29, 143, 238, 193, 91, 47, 20, 122, 163, 228, 12, 128})).map((Function1<Object, Object> & Serializable & scala.Serializable)x$4 -> BoxesRunTime.boxToByte(RealmPacketHandler.$anonfun$buildCrcHashes$4(BoxesRunTime.unboxToInt(x$4))), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Byte()))), Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(new Tuple2<Integer, Enumeration.Value>(BoxesRunTime.boxToInteger(4878), Platform$.MODULE$.Windows())), new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(new int[]{3, 223, 179, 195, 247, 36, 121, 249, 188, 197, 237, 216, 220, 161, 2, 94, 141, 17, 175, 15})).map((Function1<Object, Object> & Serializable & scala.Serializable)x$5 -> BoxesRunTime.boxToByte(RealmPacketHandler.$anonfun$buildCrcHashes$5(BoxesRunTime.unboxToInt(x$5))), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Byte()))), Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(new Tuple2<Integer, Enumeration.Value>(BoxesRunTime.boxToInteger(5086), Platform$.MODULE$.Windows())), new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(new int[]{197, 97, 181, 43, 59, 221, 221, 23, 106, 70, 67, 60, 109, 6, 123, 167, 69, 230, 176, 0})).map((Function1<Object, Object> & Serializable & scala.Serializable)x$6 -> BoxesRunTime.boxToByte(RealmPacketHandler.$anonfun$buildCrcHashes$6(BoxesRunTime.unboxToInt(x$6))), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Byte()))), Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(new Tuple2<Integer, Enumeration.Value>(BoxesRunTime.boxToInteger(5302), Platform$.MODULE$.Windows())), new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(new int[]{112, 221, 24, 60, 230, 113, 231, 153, 9, 224, 37, 84, 233, 76, 190, 63, 44, 51, 140, 85})).map((Function1<Object, Object> & Serializable & scala.Serializable)x$7 -> BoxesRunTime.boxToByte(RealmPacketHandler.$anonfun$buildCrcHashes$7(BoxesRunTime.unboxToInt(x$7))), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Byte()))), Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(new Tuple2<Integer, Enumeration.Value>(BoxesRunTime.boxToInteger(5464), Platform$.MODULE$.Windows())), new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(new int[]{77, 248, 165, 5, 228, 254, 141, 131, 51, 80, 140, 14, 133, 132, 101, 227, 87, 23, 134, 131})).map((Function1<Object, Object> & Serializable & scala.Serializable)x$8 -> BoxesRunTime.boxToByte(RealmPacketHandler.$anonfun$buildCrcHashes$8(BoxesRunTime.unboxToInt(x$8))), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Byte()))), Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(new Tuple2<Integer, Enumeration.Value>(BoxesRunTime.boxToInteger(5875), Platform$.MODULE$.Mac())), new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(new int[]{141, 23, 60, 195, 129, 150, 30, 235, 171, 243, 54, 245, 230, 103, 91, 16, 27, 181, 19, 229})).map((Function1<Object, Object> & Serializable & scala.Serializable)x$9 -> BoxesRunTime.boxToByte(RealmPacketHandler.$anonfun$buildCrcHashes$9(BoxesRunTime.unboxToInt(x$9))), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Byte()))), Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(new Tuple2<Integer, Enumeration.Value>(BoxesRunTime.boxToInteger(5875), Platform$.MODULE$.Windows())), new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(new int[]{149, 237, 178, 124, 120, 35, 179, 99, 203, 221, 171, 86, 163, 146, 231, 203, 115, 252, 202, 32})).map((Function1<Object, Object> & Serializable & scala.Serializable)x$10 -> BoxesRunTime.boxToByte(RealmPacketHandler.$anonfun$buildCrcHashes$10(BoxesRunTime.unboxToInt(x$10))), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Byte()))), Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(new Tuple2<Integer, Enumeration.Value>(BoxesRunTime.boxToInteger(6005), Platform$.MODULE$.Windows())), new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(new int[]{6, 151, 50, 56, 118, 86, 150, 65, 72, 121, 40, 253, 199, 201, 227, 59, 68, 112, 200, 128})).map((Function1<Object, Object> & Serializable & scala.Serializable)x$11 -> BoxesRunTime.boxToByte(RealmPacketHandler.$anonfun$buildCrcHashes$11(BoxesRunTime.unboxToInt(x$11))), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Byte()))), Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(new Tuple2<Integer, Enumeration.Value>(BoxesRunTime.boxToInteger(6141), Platform$.MODULE$.Windows())), new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(new int[]{46, 82, 54, 229, 102, 174, 169, 191, 250, 12, 192, 65, 103, 156, 45, 181, 46, 33, 201, 220})).map((Function1<Object, Object> & Serializable & scala.Serializable)x$12 -> BoxesRunTime.boxToByte(RealmPacketHandler.$anonfun$buildCrcHashes$12(BoxesRunTime.unboxToInt(x$12))), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Byte()))), Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(new Tuple2<Integer, Enumeration.Value>(BoxesRunTime.boxToInteger(8606), Platform$.MODULE$.Mac())), new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(new int[]{216, 176, 236, 254, 83, 75, 193, 19, 30, 25, 186, 209, 212, 192, 232, 19, 238, 228, 153, 79})).map((Function1<Object, Object> & Serializable & scala.Serializable)x$13 -> BoxesRunTime.boxToByte(RealmPacketHandler.$anonfun$buildCrcHashes$13(BoxesRunTime.unboxToInt(x$13))), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Byte()))), Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(new Tuple2<Integer, Enumeration.Value>(BoxesRunTime.boxToInteger(8606), Platform$.MODULE$.Windows())), new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(new int[]{49, 154, 250, 163, 242, 85, 150, 130, 249, 255, 101, 139, 224, 20, 86, 37, 95, 69, 111, 177})).map((Function1<Object, Object> & Serializable & scala.Serializable)x$14 -> BoxesRunTime.boxToByte(RealmPacketHandler.$anonfun$buildCrcHashes$14(BoxesRunTime.unboxToInt(x$14))), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Byte()))), Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(new Tuple2<Integer, Enumeration.Value>(BoxesRunTime.boxToInteger(12340), Platform$.MODULE$.Mac())), new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(new int[]{183, 6, 209, 63, 242, 244, 1, 136, 57, 114, 148, 97, 227, 248, 160, 226, 181, 253, 192, 52})).map((Function1<Object, Object> & Serializable & scala.Serializable)x$15 -> BoxesRunTime.boxToByte(RealmPacketHandler.$anonfun$buildCrcHashes$15(BoxesRunTime.unboxToInt(x$15))), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Byte()))), Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(new Tuple2<Integer, Enumeration.Value>(BoxesRunTime.boxToInteger(12340), Platform$.MODULE$.Windows())), new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(new int[]{205, 203, 189, 81, 136, 49, 94, 107, 77, 25, 68, 157, 73, 45, 188, 250, 241, 86, 163, 71})).map((Function1<Object, Object> & Serializable & scala.Serializable)x$16 -> BoxesRunTime.boxToByte(RealmPacketHandler.$anonfun$buildCrcHashes$16(BoxesRunTime.unboxToInt(x$16))), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Byte())))}));
    }
}

