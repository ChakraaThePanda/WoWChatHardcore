/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import scala.Serializable;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001i2AAB\u0004\u0001\u0019!)A\u0003\u0001C\u0001+!I\u0001\u0004\u0001a\u0001\u0002\u0003\u0006K!\u0007\u0005\u0006A\u0001!\t!\t\u0005\u0006E\u0001!\ta\t\u0005\u0006O\u0001!\t\u0005\u000b\u0002\t\u0019\u0006T\u00180\u00168ji*\u0011\u0001\"C\u0001\beVtG/[7f\u0015\u0005Q\u0011!B:dC2\f7\u0001A\n\u0004\u00015\t\u0002C\u0001\b\u0010\u001b\u0005I\u0011B\u0001\t\n\u0005\u0019\te.\u001f*fMB\u0011aBE\u0005\u0003'%\u0011AbU3sS\u0006d\u0017N_1cY\u0016\fa\u0001P5oSRtD#\u0001\f\u0011\u0005]\u0001Q\"A\u0004\u0002\u0019}Kg.\u001b;jC2L'0\u001a3\u0011\u00059Q\u0012BA\u000e\n\u0005\u001d\u0011un\u001c7fC:D#AA\u000f\u0011\u00059q\u0012BA\u0010\n\u0005!1x\u000e\\1uS2,\u0017aC5oSRL\u0017\r\\5{K\u0012,\u0012!G\u0001\u000bS:LG/[1mSj,G#\u0001\u0013\u0011\u00059)\u0013B\u0001\u0014\n\u0005\u0011)f.\u001b;\u0002\u0011Q|7\u000b\u001e:j]\u001e$\u0012!\u000b\t\u0003UEr!aK\u0018\u0011\u00051JQ\"A\u0017\u000b\u00059Z\u0011A\u0002\u001fs_>$h(\u0003\u00021\u0013\u00051\u0001K]3eK\u001aL!AM\u001a\u0003\rM#(/\u001b8h\u0015\t\u0001\u0014\u0002\u000b\u0003\u0001kaJ\u0004C\u0001\b7\u0013\t9\u0014B\u0001\tTKJL\u0017\r\u001c,feNLwN\\+J\t\u0006)a/\u00197vKz\t\u0011\u0001")
public class LazyUnit
implements Serializable {
    public static final long serialVersionUID = 1L;
    private volatile boolean _initialized;

    public boolean initialized() {
        return this._initialized;
    }

    public void initialize() {
        this._initialized = true;
    }

    public String toString() {
        return new StringBuilder(8).append("LazyUnit").append((Object)(this._initialized ? "" : " thunk")).toString();
    }
}

