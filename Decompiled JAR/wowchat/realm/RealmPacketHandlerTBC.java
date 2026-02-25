/*
 * Decompiled with CFR 0.152.
 */
package wowchat.realm;

import scala.Function1;
import scala.Predef$;
import scala.Serializable;
import scala.collection.Seq;
import scala.collection.immutable.IndexedSeq$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.RichInt$;
import wowchat.common.Packet;
import wowchat.realm.RealmConnectionCallback;
import wowchat.realm.RealmList;
import wowchat.realm.RealmPacketHandler;

@ScalaSignature(bytes="\u0006\u0001I2A\u0001B\u0003\u0001\u0015!Aq\u0002\u0001B\u0001B\u0003%\u0001\u0003C\u0003\u0014\u0001\u0011\u0005A\u0003C\u0003\u0018\u0001\u0011E\u0003DA\u000bSK\u0006dW\u000eU1dW\u0016$\b*\u00198eY\u0016\u0014HKQ\"\u000b\u0005\u00199\u0011!\u0002:fC2l'\"\u0001\u0005\u0002\u000f]|wo\u00195bi\u000e\u00011C\u0001\u0001\f!\taQ\"D\u0001\u0006\u0013\tqQA\u0001\nSK\u0006dW\u000eU1dW\u0016$\b*\u00198eY\u0016\u0014\u0018a\u0006:fC2l7i\u001c8oK\u000e$\u0018n\u001c8DC2d'-Y2l!\ta\u0011#\u0003\u0002\u0013\u000b\t9\"+Z1m[\u000e{gN\\3di&|gnQ1mY\n\f7m[\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0005U1\u0002C\u0001\u0007\u0001\u0011\u0015y!\u00011\u0001\u0011\u00039\u0001\u0018M]:f%\u0016\fG.\u001c'jgR$\"!\u0007\u0016\u0011\u0007i!sE\u0004\u0002\u001cC9\u0011AdH\u0007\u0002;)\u0011a$C\u0001\u0007yI|w\u000e\u001e \n\u0003\u0001\nQa]2bY\u0006L!AI\u0012\u0002\u000fA\f7m[1hK*\t\u0001%\u0003\u0002&M\t\u00191+Z9\u000b\u0005\t\u001a\u0003C\u0001\u0007)\u0013\tISAA\u0005SK\u0006dW\u000eT5ti\")1f\u0001a\u0001Y\u0005\u0019Qn]4\u0011\u00055\u0002T\"\u0001\u0018\u000b\u0005=:\u0011AB2p[6|g.\u0003\u00022]\t1\u0001+Y2lKR\u0004")
public class RealmPacketHandlerTBC
extends RealmPacketHandler {
    @Override
    public Seq<RealmList> parseRealmList(Packet msg) {
        msg.byteBuf().readIntLE();
        short numRealms = msg.byteBuf().readShortLE();
        return RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), numRealms).map((Function1<Object, RealmList> & java.io.Serializable & Serializable)i -> RealmPacketHandlerTBC.$anonfun$parseRealmList$1(msg, BoxesRunTime.unboxToInt(i)), IndexedSeq$.MODULE$.canBuildFrom());
    }

    public static final /* synthetic */ RealmList $anonfun$parseRealmList$1(Packet msg$1, int i) {
        msg$1.byteBuf().skipBytes(1);
        msg$1.byteBuf().skipBytes(1);
        byte realmFlags = msg$1.byteBuf().readByte();
        String name = msg$1.readString();
        String address = msg$1.readString();
        msg$1.byteBuf().skipBytes(4);
        msg$1.byteBuf().skipBytes(1);
        msg$1.byteBuf().skipBytes(1);
        byte realmId = msg$1.byteBuf().readByte();
        Object object = (realmFlags & 4) == 4 ? msg$1.byteBuf().skipBytes(5) : BoxedUnit.UNIT;
        return new RealmList(name, address, realmId);
    }

    public RealmPacketHandlerTBC(RealmConnectionCallback realmConnectionCallback) {
        super(realmConnectionCallback);
    }
}

