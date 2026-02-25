/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import scala.Serializable;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001}2A\u0001C\u0005\u0001\u001d!)a\u0003\u0001C\u0001/!I!\u0004\u0001a\u0001\u0002\u0003\u0006Ka\u0007\u0005\u0006E\u0001!\ta\t\u0005\nI\u0001\u0001\r\u0011!Q!\n\u0015BQ\u0001\u000b\u0001\u0005\u0002%BQA\u000b\u0001\u0005\u0002-BQ!\f\u0001\u0005B9\u0012\u0001\u0002T1{s\nKH/\u001a\u0006\u0003\u0015-\tqA];oi&lWMC\u0001\r\u0003\u0015\u00198-\u00197b\u0007\u0001\u00192\u0001A\b\u0014!\t\u0001\u0012#D\u0001\f\u0013\t\u00112B\u0001\u0004B]f\u0014VM\u001a\t\u0003!QI!!F\u0006\u0003\u0019M+'/[1mSj\f'\r\\3\u0002\rqJg.\u001b;?)\u0005A\u0002CA\r\u0001\u001b\u0005I\u0011\u0001D0j]&$\u0018.\u00197ju\u0016$\u0007C\u0001\t\u001d\u0013\ti2BA\u0004C_>dW-\u00198)\u0005\ty\u0002C\u0001\t!\u0013\t\t3B\u0001\u0005w_2\fG/\u001b7f\u0003-Ig.\u001b;jC2L'0\u001a3\u0016\u0003m\taa\u0018<bYV,\u0007C\u0001\t'\u0013\t93B\u0001\u0003CsR,\u0017!\u0002<bYV,W#A\u0013\u0002\u0015%t\u0017\u000e^5bY&TX\r\u0006\u0002&Y!)\u0001F\u0002a\u0001K\u0005AAo\\*ue&tw\rF\u00010!\t\u0001tG\u0004\u00022kA\u0011!gC\u0007\u0002g)\u0011A'D\u0001\u0007yI|w\u000e\u001e \n\u0005YZ\u0011A\u0002)sK\u0012,g-\u0003\u00029s\t11\u000b\u001e:j]\u001eT!AN\u0006)\t\u0001Y\u0004F\u0010\t\u0003!qJ!!P\u0006\u0003!M+'/[1m-\u0016\u00148/[8o+&#e$A\u0001")
public class LazyByte
implements Serializable {
    public static final long serialVersionUID = 1L;
    private volatile boolean _initialized;
    private byte _value;

    public boolean initialized() {
        return this._initialized;
    }

    public byte value() {
        return this._value;
    }

    public byte initialize(byte value) {
        this._value = value;
        this._initialized = true;
        return value;
    }

    public String toString() {
        return new StringBuilder(9).append("LazyByte ").append((Object)(this._initialized ? new StringBuilder(4).append("of: ").append(this._value).toString() : "thunk")).toString();
    }
}

