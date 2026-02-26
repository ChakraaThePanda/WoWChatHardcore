/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import scala.Serializable;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001}2A\u0001C\u0005\u0001\u001d!)a\u0003\u0001C\u0001/!I!\u0004\u0001a\u0001\u0002\u0003\u0006Ka\u0007\u0005\u0006E\u0001!\ta\t\u0005\nI\u0001\u0001\r\u0011!Q!\n\u0015BQ\u0001\u000b\u0001\u0005\u0002%BQA\u000b\u0001\u0005\u0002-BQ!\f\u0001\u0005B9\u0012!\u0002T1{s\u0012{WO\u00197f\u0015\tQ1\"A\u0004sk:$\u0018.\\3\u000b\u00031\tQa]2bY\u0006\u001c\u0001aE\u0002\u0001\u001fM\u0001\"\u0001E\t\u000e\u0003-I!AE\u0006\u0003\r\u0005s\u0017PU3g!\t\u0001B#\u0003\u0002\u0016\u0017\ta1+\u001a:jC2L'0\u00192mK\u00061A(\u001b8jiz\"\u0012\u0001\u0007\t\u00033\u0001i\u0011!C\u0001\r?&t\u0017\u000e^5bY&TX\r\u001a\t\u0003!qI!!H\u0006\u0003\u000f\t{w\u000e\\3b]\"\u0012!a\b\t\u0003!\u0001J!!I\u0006\u0003\u0011Y|G.\u0019;jY\u0016\f1\"\u001b8ji&\fG.\u001b>fIV\t1$\u0001\u0004`m\u0006dW/\u001a\t\u0003!\u0019J!aJ\u0006\u0003\r\u0011{WO\u00197f\u0003\u00151\u0018\r\\;f+\u0005)\u0013AC5oSRL\u0017\r\\5{KR\u0011Q\u0005\f\u0005\u0006Q\u0019\u0001\r!J\u0001\ti>\u001cFO]5oOR\tq\u0006\u0005\u00021o9\u0011\u0011'\u000e\t\u0003e-i\u0011a\r\u0006\u0003i5\ta\u0001\u0010:p_Rt\u0014B\u0001\u001c\f\u0003\u0019\u0001&/\u001a3fM&\u0011\u0001(\u000f\u0002\u0007'R\u0014\u0018N\\4\u000b\u0005YZ\u0001\u0006\u0002\u0001<Qy\u0002\"\u0001\u0005\u001f\n\u0005uZ!\u0001E*fe&\fGNV3sg&|g.V%E=\u0005\t\u0001")
public class LazyDouble
implements Serializable {
    public static final long serialVersionUID = 1L;
    private volatile boolean _initialized;
    private double _value;

    public boolean initialized() {
        return this._initialized;
    }

    public double value() {
        return this._value;
    }

    public double initialize(double value) {
        this._value = value;
        this._initialized = true;
        return value;
    }

    public String toString() {
        return new StringBuilder(11).append("LazyDouble ").append((Object)(this._initialized ? new StringBuilder(4).append("of: ").append(this._value).toString() : "thunk")).toString();
    }
}

