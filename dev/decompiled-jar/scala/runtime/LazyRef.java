/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import scala.Serializable;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001!3A\u0001C\u0005\u0001\u001d!)q\u0003\u0001C\u00011!Ia\u0005\u0001a\u0001\u0002\u0003\u0006Ka\n\u0005\u0006]\u0001!\ta\f\u0005\na\u0001\u0001\r\u0011!Q!\nmAQ!\r\u0001\u0005\u0002IBQa\r\u0001\u0005\u0002QBQA\u000e\u0001\u0005B]\u0012q\u0001T1{sJ+gM\u0003\u0002\u000b\u0017\u00059!/\u001e8uS6,'\"\u0001\u0007\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0011q\"H\n\u0004\u0001A!\u0002CA\t\u0013\u001b\u0005Y\u0011BA\n\f\u0005\u0019\te.\u001f*fMB\u0011\u0011#F\u0005\u0003--\u0011AbU3sS\u0006d\u0017N_1cY\u0016\fa\u0001P5oSRtD#A\r\u0011\u0007i\u00011$D\u0001\n!\taR\u0004\u0004\u0001\u0005\u000by\u0001!\u0019A\u0010\u0003\u0003Q\u000b\"\u0001I\u0012\u0011\u0005E\t\u0013B\u0001\u0012\f\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"!\u0005\u0013\n\u0005\u0015Z!aA!os\u0006aq,\u001b8ji&\fG.\u001b>fIB\u0011\u0011\u0003K\u0005\u0003S-\u0011qAQ8pY\u0016\fg\u000e\u000b\u0002\u0003WA\u0011\u0011\u0003L\u0005\u0003[-\u0011\u0001B^8mCRLG.Z\u0001\fS:LG/[1mSj,G-F\u0001(\u0003\u0019yf/\u00197vK\u0006)a/\u00197vKV\t1$\u0001\u0006j]&$\u0018.\u00197ju\u0016$\"aG\u001b\t\u000bE2\u0001\u0019A\u000e\u0002\u0011Q|7\u000b\u001e:j]\u001e$\u0012\u0001\u000f\t\u0003s\u0001s!A\u000f \u0011\u0005mZQ\"\u0001\u001f\u000b\u0005uj\u0011A\u0002\u001fs_>$h(\u0003\u0002@\u0017\u00051\u0001K]3eK\u001aL!!\u0011\"\u0003\rM#(/\u001b8h\u0015\ty4\u0002\u000b\u0003\u0001\tF:\u0005CA\tF\u0013\t15B\u0001\tTKJL\u0017\r\u001c,feNLwN\\+J\tz\t\u0011\u0001")
public class LazyRef<T>
implements Serializable {
    public static final long serialVersionUID = 1L;
    private volatile boolean _initialized;
    private T _value;

    public boolean initialized() {
        return this._initialized;
    }

    public T value() {
        return this._value;
    }

    public T initialize(T value) {
        this._value = value;
        this._initialized = true;
        return value;
    }

    public String toString() {
        return new StringBuilder(8).append("LazyRef ").append((Object)(this._initialized ? new StringBuilder(4).append("of: ").append(this._value).toString() : "thunk")).toString();
    }
}

