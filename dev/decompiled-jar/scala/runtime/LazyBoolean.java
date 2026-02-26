/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import scala.Serializable;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001m2A\u0001C\u0005\u0001\u001d!)a\u0003\u0001C\u0001/!I!\u0004\u0001a\u0001\u0002\u0003\u0006Ka\u0007\u0005\u0006E\u0001!\ta\t\u0005\nI\u0001\u0001\r\u0011!Q!\nmAQ!\n\u0001\u0005\u0002\rBQA\n\u0001\u0005\u0002\u001dBQ!\u000b\u0001\u0005B)\u00121\u0002T1{s\n{w\u000e\\3b]*\u0011!bC\u0001\beVtG/[7f\u0015\u0005a\u0011!B:dC2\f7\u0001A\n\u0004\u0001=\u0019\u0002C\u0001\t\u0012\u001b\u0005Y\u0011B\u0001\n\f\u0005\u0019\te.\u001f*fMB\u0011\u0001\u0003F\u0005\u0003+-\u0011AbU3sS\u0006d\u0017N_1cY\u0016\fa\u0001P5oSRtD#\u0001\r\u0011\u0005e\u0001Q\"A\u0005\u0002\u0019}Kg.\u001b;jC2L'0\u001a3\u0011\u0005Aa\u0012BA\u000f\f\u0005\u001d\u0011un\u001c7fC:D#AA\u0010\u0011\u0005A\u0001\u0013BA\u0011\f\u0005!1x\u000e\\1uS2,\u0017aC5oSRL\u0017\r\\5{K\u0012,\u0012aG\u0001\u0007?Z\fG.^3\u0002\u000bY\fG.^3\u0002\u0015%t\u0017\u000e^5bY&TX\r\u0006\u0002\u001cQ!)QE\u0002a\u00017\u0005AAo\\*ue&tw\rF\u0001,!\ta3G\u0004\u0002.cA\u0011afC\u0007\u0002_)\u0011\u0001'D\u0001\u0007yI|w\u000e\u001e \n\u0005IZ\u0011A\u0002)sK\u0012,g-\u0003\u00025k\t11\u000b\u001e:j]\u001eT!AM\u0006)\t\u00019TE\u000f\t\u0003!aJ!!O\u0006\u0003!M+'/[1m-\u0016\u00148/[8o+&#e$A\u0001")
public class LazyBoolean
implements Serializable {
    public static final long serialVersionUID = 1L;
    private volatile boolean _initialized;
    private boolean _value;

    public boolean initialized() {
        return this._initialized;
    }

    public boolean value() {
        return this._value;
    }

    public boolean initialize(boolean value) {
        this._value = value;
        this._initialized = true;
        return value;
    }

    public String toString() {
        return new StringBuilder(12).append("LazyBoolean ").append((Object)(this._initialized ? new StringBuilder(4).append("of: ").append(this._value).toString() : "thunk")).toString();
    }
}

