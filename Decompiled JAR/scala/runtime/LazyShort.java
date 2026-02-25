/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import scala.Serializable;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001}2A\u0001C\u0005\u0001\u001d!)a\u0003\u0001C\u0001/!I!\u0004\u0001a\u0001\u0002\u0003\u0006Ka\u0007\u0005\u0006E\u0001!\ta\t\u0005\nI\u0001\u0001\r\u0011!Q!\n\u0015BQ\u0001\u000b\u0001\u0005\u0002%BQA\u000b\u0001\u0005\u0002-BQ!\f\u0001\u0005B9\u0012\u0011\u0002T1{sNCwN\u001d;\u000b\u0005)Y\u0011a\u0002:v]RLW.\u001a\u0006\u0002\u0019\u0005)1oY1mC\u000e\u00011c\u0001\u0001\u0010'A\u0011\u0001#E\u0007\u0002\u0017%\u0011!c\u0003\u0002\u0007\u0003:L(+\u001a4\u0011\u0005A!\u0012BA\u000b\f\u00051\u0019VM]5bY&T\u0018M\u00197f\u0003\u0019a\u0014N\\5u}Q\t\u0001\u0004\u0005\u0002\u001a\u00015\t\u0011\"\u0001\u0007`S:LG/[1mSj,G\r\u0005\u0002\u00119%\u0011Qd\u0003\u0002\b\u0005>|G.Z1oQ\t\u0011q\u0004\u0005\u0002\u0011A%\u0011\u0011e\u0003\u0002\tm>d\u0017\r^5mK\u0006Y\u0011N\\5uS\u0006d\u0017N_3e+\u0005Y\u0012AB0wC2,X\r\u0005\u0002\u0011M%\u0011qe\u0003\u0002\u0006'\"|'\u000f^\u0001\u0006m\u0006dW/Z\u000b\u0002K\u0005Q\u0011N\\5uS\u0006d\u0017N_3\u0015\u0005\u0015b\u0003\"\u0002\u0015\u0007\u0001\u0004)\u0013\u0001\u0003;p'R\u0014\u0018N\\4\u0015\u0003=\u0002\"\u0001M\u001c\u000f\u0005E*\u0004C\u0001\u001a\f\u001b\u0005\u0019$B\u0001\u001b\u000e\u0003\u0019a$o\\8u}%\u0011agC\u0001\u0007!J,G-\u001a4\n\u0005aJ$AB*ue&twM\u0003\u00027\u0017!\"\u0001a\u000f\u0015?!\t\u0001B(\u0003\u0002>\u0017\t\u00012+\u001a:jC24VM]:j_:,\u0016\n\u0012\u0010\u0002\u0003\u0001")
public class LazyShort
implements Serializable {
    public static final long serialVersionUID = 1L;
    private volatile boolean _initialized;
    private short _value;

    public boolean initialized() {
        return this._initialized;
    }

    public short value() {
        return this._value;
    }

    public short initialize(short value) {
        this._value = value;
        this._initialized = true;
        return value;
    }

    public String toString() {
        return new StringBuilder(10).append("LazyShort ").append((Object)(this._initialized ? new StringBuilder(4).append("of: ").append(this._value).toString() : "thunk")).toString();
    }
}

