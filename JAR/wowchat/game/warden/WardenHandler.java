/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game.warden;

import com.typesafe.scalalogging.Logger;
import com.typesafe.scalalogging.StrictLogging;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.zip.Inflater;
import scala.Array$;
import scala.Function1;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Some;
import scala.Tuple2;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.ArrayOps;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.RichInt$;
import scala.runtime.java8.JFunction1$mcVI$sp;
import wowchat.common.ByteUtils$;
import wowchat.common.Packet;
import wowchat.game.RC4;
import wowchat.game.warden.SHA1Randx;
import wowchat.game.warden.WardenPackets$;

@ScalaSignature(bytes="\u0006\u0001\u0005ed\u0001B\u0012%\u0001-B\u0001\u0002\u0010\u0001\u0003\u0002\u0003\u0006I!\u0010\u0005\u0006\u0007\u0002!\t\u0001\u0012\u0005\b\u0011\u0002\u0011\r\u0011\"\u0005J\u0011\u0019i\u0005\u0001)A\u0005\u0015\"9a\n\u0001b\u0001\n\u0013y\u0005BB*\u0001A\u0003%\u0001\u000bC\u0004U\u0001\u0001\u0007I\u0011B+\t\u000fi\u0003\u0001\u0019!C\u00057\"1\u0011\r\u0001Q!\nYCqA\u0019\u0001A\u0002\u0013%Q\u000bC\u0004d\u0001\u0001\u0007I\u0011\u00023\t\r\u0019\u0004\u0001\u0015)\u0003W\u0011%9\u0007\u00011AA\u0002\u0013%Q\u000bC\u0005i\u0001\u0001\u0007\t\u0019!C\u0005S\"I1\u000e\u0001a\u0001\u0002\u0003\u0006KA\u0016\u0005\bY\u0002\u0001\r\u0011\"\u0003n\u0011\u001d1\b\u00011A\u0005\n]Da!\u001f\u0001!B\u0013q\u0007b\u0002>\u0001\u0005\u0004%Ia\u001f\u0005\u0007y\u0002\u0001\u000b\u0011B\u001f\t\u000fu\u0004\u0001\u0019!C\u0005\u0013\"9a\u0010\u0001a\u0001\n\u0013y\bbBA\u0002\u0001\u0001\u0006KA\u0013\u0005\n\u0003\u000b\u0001\u0001\u0019!C\u0005\u0003\u000fA\u0011\"a\t\u0001\u0001\u0004%I!!\n\t\u0011\u0005%\u0002\u0001)Q\u0005\u0003\u0013Aq!a\u000b\u0001\t\u0003\ti\u0003C\u0004\u0002F\u0001!\t\"a\u0012\t\u000f\u0005-\u0003\u0001\"\u0005\u0002N!9\u00111\u000b\u0001\u0005\u0012\u0005U\u0003bBA0\u0001\u0011%\u0011\u0011\r\u0005\b\u0003O\u0002A\u0011BA5\u0011\u001d\ti\u0007\u0001C\u0005\u0003_Bq!a\u001d\u0001\t\u0013\t)HA\u0007XCJ$WM\u001c%b]\u0012dWM\u001d\u0006\u0003K\u0019\naa^1sI\u0016t'BA\u0014)\u0003\u00119\u0017-\\3\u000b\u0003%\nqa^8xG\"\fGo\u0001\u0001\u0014\u0007\u0001a#\u0007\u0005\u0002.a5\taFC\u00010\u0003\u0015\u00198-\u00197b\u0013\t\tdF\u0001\u0004B]f\u0014VM\u001a\t\u0003gij\u0011\u0001\u000e\u0006\u0003kY\nAb]2bY\u0006dwnZ4j]\u001eT!a\u000e\u001d\u0002\u0011QL\b/Z:bM\u0016T\u0011!O\u0001\u0004G>l\u0017BA\u001e5\u00055\u0019FO]5di2{wmZ5oO\u0006Q1/Z:tS>t7*Z=\u0011\u00075r\u0004)\u0003\u0002@]\t)\u0011I\u001d:bsB\u0011Q&Q\u0005\u0003\u0005:\u0012AAQ=uK\u00061A(\u001b8jiz\"\"!R$\u0011\u0005\u0019\u0003Q\"\u0001\u0013\t\u000bq\u0012\u0001\u0019A\u001f\u0002)]\u000b%\u000bR#O?6{E)\u0016'F?2+ej\u0012+I+\u0005Q\u0005CA\u0017L\u0013\taeFA\u0002J]R\fQcV!S\t\u0016su,T(E+2+u\fT#O\u000fRC\u0005%A\u0005tQ\u0006\f$+\u00198eqV\t\u0001\u000b\u0005\u0002G#&\u0011!\u000b\n\u0002\n'\"\u000b\u0015GU1oIb\f!b\u001d5bcI\u000bg\u000e\u001a=!\u0003-\u0019G.[3oi\u000e\u0013\u0018\u0010\u001d;\u0016\u0003Y\u0003\"a\u0016-\u000e\u0003\u0019J!!\u0017\u0014\u0003\u0007I\u001bE'A\bdY&,g\u000e^\"ssB$x\fJ3r)\tav\f\u0005\u0002.;&\u0011aL\f\u0002\u0005+:LG\u000fC\u0004a\u0011\u0005\u0005\t\u0019\u0001,\u0002\u0007a$\u0013'\u0001\u0007dY&,g\u000e^\"ssB$\b%A\u0006tKJ4XM]\"ssB$\u0018aD:feZ,'o\u0011:zaR|F%Z9\u0015\u0005q+\u0007b\u00021\f\u0003\u0003\u0005\rAV\u0001\rg\u0016\u0014h/\u001a:Def\u0004H\u000fI\u0001\f[>$W\u000f\\3Def\u0004H/A\bn_\u0012,H.Z\"ssB$x\fJ3r)\ta&\u000eC\u0004a\u001d\u0005\u0005\t\u0019\u0001,\u0002\u00195|G-\u001e7f\u0007JL\b\u000f\u001e\u0011\u0002\u00155|G-\u001e7f\u001d\u0006lW-F\u0001o!\tyG/D\u0001q\u0015\t\t(/\u0001\u0003mC:<'\"A:\u0002\t)\fg/Y\u0005\u0003kB\u0014aa\u0015;sS:<\u0017AD7pIVdWMT1nK~#S-\u001d\u000b\u00039bDq\u0001Y\t\u0002\u0002\u0003\u0007a.A\u0006n_\u0012,H.\u001a(b[\u0016\u0004\u0013AC7pIVdWmU3fIV\tQ(A\u0006n_\u0012,H.Z*fK\u0012\u0004\u0013\u0001D7pIVdW\rT3oORD\u0017\u0001E7pIVdW\rT3oORDw\fJ3r)\ra\u0016\u0011\u0001\u0005\bAZ\t\t\u00111\u0001K\u00035iw\u000eZ;mK2+gn\u001a;iA\u00051Qn\u001c3vY\u0016,\"!!\u0003\u0011\u000b5\nY!a\u0004\n\u0007\u00055aF\u0001\u0004PaRLwN\u001c\t\u0005\u0003#\ty\"\u0004\u0002\u0002\u0014)!\u0011QCA\f\u0003\u0019\u0011WO\u001a4fe*!\u0011\u0011DA\u000e\u0003\u0015qW\r\u001e;z\u0015\t\ti\"\u0001\u0002j_&!\u0011\u0011EA\n\u0005\u001d\u0011\u0015\u0010^3Ck\u001a\f!\"\\8ek2,w\fJ3r)\ra\u0016q\u0005\u0005\tAf\t\t\u00111\u0001\u0002\n\u00059Qn\u001c3vY\u0016\u0004\u0013A\u00025b]\u0012dW\r\u0006\u0003\u00020\u0005U\u0002CB\u0017\u00022)\u000bI!C\u0002\u000249\u0012a\u0001V;qY\u0016\u0014\u0004bBA\u001c7\u0001\u0007\u0011\u0011H\u0001\u0004[N<\u0007\u0003BA\u001e\u0003\u0003j!!!\u0010\u000b\u0007\u0005}\u0002&\u0001\u0004d_6lwN\\\u0005\u0005\u0003\u0007\niD\u0001\u0004QC\u000e\\W\r^\u0001\u001aO\u0016$XI\\2ssB$X\rZ'fgN\fw-\u001a'f]\u001e$\b\u000eF\u0002K\u0003\u0013Bq!a\u000e\u001d\u0001\u0004\tI$\u0001\u0007g_Jl'+Z:q_:\u001cX\r\u0006\u0003\u0002\u0010\u0005=\u0003bBA);\u0001\u0007\u0011qB\u0001\u0004_V$\u0018\u0001\b4pe6\u001c\u0005.Z1u\u0007\",7m[:SKF,Xm\u001d;ES\u001e,7\u000f\u001e\u000b\u00069\u0006]\u00131\f\u0005\b\u00033r\u0002\u0019AA\b\u0003\r\u0011X\r\u001e\u0005\u0007\u0003;r\u0002\u0019A\u001f\u0002\u0007-,\u00170A\u000fiC:$G.Z0X\u0003J#UIT0T\u001bN;u,T(E+2+u,V*F)\u0011\tI!a\u0019\t\u000f\u0005\u0015t\u00041\u0001\u0002\u0010\u0005IA-Z2ssB$X\rZ\u0001 Q\u0006tG\r\\3`/\u0006\u0013F)\u0012(`'6\u001bviX'P\tVcUiX\"B\u0007\"+E\u0003BA\u0005\u0003WBq!!\u001a!\u0001\u0004\ty!A\u0014iC:$G.Z0X\u0003J#UIT0T\u001bN;ul\u0011%F\u0003R{6\tS#D\u0017N{&+R)V\u000bN#F\u0003BA\u0005\u0003cBq!!\u001a\"\u0001\u0004\ty!A\u0010iC:$G.Z0X\u0003J#UIT0T\u001bN;u\fS!T\u0011~\u0013V)U+F'R#B!!\u0003\u0002x!9\u0011Q\r\u0012A\u0002\u0005=\u0001")
public class WardenHandler
implements StrictLogging {
    private final int WARDEN_MODULE_LENGTH;
    private final SHA1Randx sha1Randx;
    private RC4 clientCrypt;
    private RC4 serverCrypt;
    private RC4 moduleCrypt;
    private String moduleName;
    private final byte[] moduleSeed;
    private int moduleLength;
    private Option<ByteBuf> module;
    private final Logger logger;

    @Override
    public Logger logger() {
        return this.logger;
    }

    @Override
    public void com$typesafe$scalalogging$StrictLogging$_setter_$logger_$eq(Logger x$1) {
        this.logger = x$1;
    }

    public int WARDEN_MODULE_LENGTH() {
        return this.WARDEN_MODULE_LENGTH;
    }

    private SHA1Randx sha1Randx() {
        return this.sha1Randx;
    }

    private RC4 clientCrypt() {
        return this.clientCrypt;
    }

    private void clientCrypt_$eq(RC4 x$1) {
        this.clientCrypt = x$1;
    }

    private RC4 serverCrypt() {
        return this.serverCrypt;
    }

    private void serverCrypt_$eq(RC4 x$1) {
        this.serverCrypt = x$1;
    }

    private RC4 moduleCrypt() {
        return this.moduleCrypt;
    }

    private void moduleCrypt_$eq(RC4 x$1) {
        this.moduleCrypt = x$1;
    }

    private String moduleName() {
        return this.moduleName;
    }

    private void moduleName_$eq(String x$1) {
        this.moduleName = x$1;
    }

    private byte[] moduleSeed() {
        return this.moduleSeed;
    }

    private int moduleLength() {
        return this.moduleLength;
    }

    private void moduleLength_$eq(int x$1) {
        this.moduleLength = x$1;
    }

    private Option<ByteBuf> module() {
        return this.module;
    }

    private void module_$eq(Option<ByteBuf> x$1) {
        this.module = x$1;
    }

    public Tuple2<Object, Option<ByteBuf>> handle(Packet msg) {
        byte id;
        BoxedUnit boxedUnit;
        int length = this.getEncryptedMessageLength(msg);
        ByteBuf decrypted = this.serverCrypt().crypt(msg.byteBuf(), length);
        if (this.logger().underlying().isDebugEnabled()) {
            this.logger().underlying().debug("WARDEN PACKET ({}): {}", new Object[]{BoxesRunTime.boxToInteger(length), ByteUtils$.MODULE$.toHexString(decrypted, true, false)});
            boxedUnit = BoxedUnit.UNIT;
        } else {
            boxedUnit = BoxedUnit.UNIT;
        }
        byte by = id = decrypted.readByte();
        Option option = WardenPackets$.MODULE$.WARDEN_SMSG_MODULE_USE() == by ? this.handle_WARDEN_SMSG_MODULE_USE(decrypted) : (WardenPackets$.MODULE$.WARDEN_SMSG_MODULE_CACHE() == by ? this.handle_WARDEN_SMSG_MODULE_CACHE(decrypted) : (WardenPackets$.MODULE$.WARDEN_SMSG_CHEAT_CHECKS_REQUEST() == by ? this.handle_WARDEN_SMSG_CHEAT_CHECKS_REQUEST(decrypted) : (WardenPackets$.MODULE$.WARDEN_SMSG_MODULE_INITIALIZE() == by ? None$.MODULE$ : (WardenPackets$.MODULE$.WARDEN_SMSG_MEM_CHECKS_REQUEST() == by ? None$.MODULE$ : (WardenPackets$.MODULE$.WARDEN_SMSG_HASH_REQUEST() == by ? this.handle_WARDEN_SMSG_HASH_REQUEST(decrypted) : None$.MODULE$)))));
        None$ ret = option;
        decrypted.release();
        return new Tuple2<Object, Option<ByteBuf>>(BoxesRunTime.boxToInteger(id), ret);
    }

    public int getEncryptedMessageLength(Packet msg) {
        return msg.byteBuf().readableBytes();
    }

    public ByteBuf formResponse(ByteBuf out) {
        return out;
    }

    public void formCheatChecksRequestDigest(ByteBuf ret, byte[] key) {
        MessageDigest mdSHA1 = MessageDigest.getInstance("SHA1");
        mdSHA1.update(key);
        mdSHA1.update(ByteUtils$.MODULE$.intToBytesLE(-17958194));
        ret.writeBytes(mdSHA1.digest());
        MessageDigest mdMD5 = MessageDigest.getInstance("MD5");
        mdMD5.update(key);
        ret.writeBytes(mdMD5.digest());
    }

    private Option<ByteBuf> handle_WARDEN_SMSG_MODULE_USE(ByteBuf decrypted) {
        byte[] moduleNameArray = new byte[this.WARDEN_MODULE_LENGTH()];
        decrypted.readBytes(moduleNameArray);
        this.moduleName_$eq(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])new ArrayOps.ofByte(Predef$.MODULE$.byteArrayOps(moduleNameArray)).map((Function1<Object, String> & Serializable & scala.Serializable)object -> WardenHandler.$anonfun$handle_WARDEN_SMSG_MODULE_USE$1(BoxesRunTime.unboxToByte(object)), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.apply(String.class))))).mkString());
        decrypted.readBytes(this.moduleSeed());
        this.moduleLength_$eq(decrypted.readIntLE());
        this.moduleCrypt_$eq(new RC4(this.moduleSeed()));
        return new Some<ByteBuf>(this.formResponse(this.clientCrypt().crypt((byte)WardenPackets$.MODULE$.WARDEN_CMSG_MODULE_OK())));
    }

    private Option<ByteBuf> handle_WARDEN_SMSG_MODULE_CACHE(ByteBuf decrypted) {
        Option option;
        short length = decrypted.readShortLE();
        ByteBuf compressedBytes = decrypted.readBytes(length);
        if (this.module().isEmpty()) {
            this.module_$eq(new Some<ByteBuf>(PooledByteBufAllocator.DEFAULT.buffer(this.moduleLength(), this.moduleLength())));
        }
        this.module().get().writeBytes(compressedBytes);
        if (this.module().get().writableBytes() == 0) {
            byte[] moduleArr = new byte[this.moduleLength()];
            this.module().get().readBytes(moduleArr);
            ByteBuf unencryptedModule = this.moduleCrypt().crypt(moduleArr);
            int decompressedLength = unencryptedModule.readIntLE();
            byte[] unencryptedModuleArr = new byte[this.moduleLength() - 4];
            unencryptedModule.readBytes(unencryptedModuleArr);
            Inflater inflater = new Inflater();
            inflater.setInput(unencryptedModuleArr);
            byte[] decompressedData = new byte[decompressedLength];
            int count = inflater.inflate(decompressedData);
            inflater.end();
            FileOutputStream fos = new FileOutputStream(new StringBuilder(4).append(this.moduleName()).append(".bin").toString());
            fos.write(decompressedData);
            fos.close();
            option = new Some<ByteBuf>(this.formResponse(this.clientCrypt().crypt((byte)WardenPackets$.MODULE$.WARDEN_CMSG_MODULE_OK())));
        } else {
            option = None$.MODULE$;
        }
        return option;
    }

    private Option<ByteBuf> handle_WARDEN_SMSG_CHEAT_CHECKS_REQUEST(ByteBuf decrypted) {
        ByteBuf ret = PooledByteBufAllocator.DEFAULT.buffer(53, 53);
        byte strLength = decrypted.readByte();
        byte[] strArray = new byte[strLength];
        decrypted.readBytes(strArray);
        byte[] filteredArray = (byte[])new ArrayOps.ofByte(Predef$.MODULE$.byteArrayOps(strArray)).takeWhile((Function1<Object, Object> & Serializable & scala.Serializable)x$1 -> BoxesRunTime.boxToBoolean(WardenHandler.$anonfun$handle_WARDEN_SMSG_CHEAT_CHECKS_REQUEST$1(BoxesRunTime.unboxToByte(x$1))));
        ret.writeByte(WardenPackets$.MODULE$.WARDEN_CMSG_CHEAT_CHECKS_RESULT());
        this.formCheatChecksRequestDigest(ret, filteredArray);
        ByteBuf encrypted = this.clientCrypt().crypt(ret, ret.readableBytes());
        ret.release();
        return new Some<ByteBuf>(this.formResponse(encrypted));
    }

    private Option<ByteBuf> handle_WARDEN_SMSG_HASH_REQUEST(ByteBuf decrypted) {
        ByteBuf ret = PooledByteBufAllocator.DEFAULT.buffer(21, 21);
        int[] clientKey = new int[4];
        int[] serverKey = new int[4];
        int serverKey1 = 0;
        int serverKey2 = 0;
        RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), 4).foreach$mVc$sp((JFunction1$mcVI$sp & scala.Serializable)x$2 -> {
            clientKey$1[x$2] = decrypted.readIntLE();
        });
        serverKey[0] = clientKey[0];
        clientKey[0] = clientKey[0] ^ 0xDEADBEEF;
        serverKey1 = clientKey[1];
        clientKey[1] = clientKey[1] - 889275714;
        serverKey2 = clientKey[2];
        clientKey[2] = clientKey[2] + 87113506;
        clientKey[3] = clientKey[3] * 322433037;
        serverKey[1] = serverKey1 - 1778551428;
        serverKey[2] = serverKey2 + 174227012;
        serverKey[3] = 322433037 * clientKey[3];
        ByteBuf clientKeyBuf = PooledByteBufAllocator.DEFAULT.buffer(16, 16);
        new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(clientKey)).foreach((Function1<Object, ByteBuf> & Serializable & scala.Serializable)x$1 -> clientKeyBuf.writeIntLE(BoxesRunTime.unboxToInt(x$1)));
        byte[] clientKeyBytes = new byte[16];
        clientKeyBuf.readBytes(clientKeyBytes);
        clientKeyBuf.release();
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.update(clientKeyBytes);
        ret.writeByte(WardenPackets$.MODULE$.WARDEN_CMSG_HASH_RESULT());
        ret.writeBytes(md.digest());
        ByteBuf encrypted = this.clientCrypt().crypt(ret, ret.readableBytes());
        ret.release();
        this.clientCrypt_$eq(new RC4(clientKeyBytes));
        ByteBuf serverKeyBuf = PooledByteBufAllocator.DEFAULT.buffer(16, 16);
        new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(serverKey)).foreach((Function1<Object, ByteBuf> & Serializable & scala.Serializable)x$1 -> serverKeyBuf.writeIntLE(BoxesRunTime.unboxToInt(x$1)));
        byte[] serverKeyOutBytes = new byte[16];
        serverKeyBuf.readBytes(serverKeyOutBytes);
        serverKeyBuf.release();
        this.serverCrypt_$eq(new RC4(serverKeyOutBytes));
        return new Some<ByteBuf>(this.formResponse(encrypted));
    }

    public static final /* synthetic */ String $anonfun$handle_WARDEN_SMSG_MODULE_USE$1(byte by) {
        byte arg$macro$1 = by;
        return new StringOps("%02X").format(Predef$.MODULE$.genericWrapArray(new Object[]{BoxesRunTime.boxToByte(arg$macro$1)}));
    }

    public static final /* synthetic */ boolean $anonfun$handle_WARDEN_SMSG_CHEAT_CHECKS_REQUEST$1(byte x$1) {
        return x$1 != 0;
    }

    public WardenHandler(byte[] sessionKey) {
        StrictLogging.$init$(this);
        this.WARDEN_MODULE_LENGTH = 16;
        this.sha1Randx = new SHA1Randx(sessionKey);
        this.clientCrypt = new RC4(this.sha1Randx().generate(16));
        this.serverCrypt = new RC4(this.sha1Randx().generate(16));
        this.moduleName = "";
        this.moduleSeed = new byte[16];
        this.moduleLength = 0;
        this.module = None$.MODULE$;
    }
}

