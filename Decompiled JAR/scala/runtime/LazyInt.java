/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import scala.Serializable;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001}2A\u0001C\u0005\u0001\u001d!)a\u0003\u0001C\u0001/!I!\u0004\u0001a\u0001\u0002\u0003\u0006Ka\u0007\u0005\u0006E\u0001!\ta\t\u0005\nI\u0001\u0001\r\u0011!Q!\n\u0015BQ\u0001\u000b\u0001\u0005\u0002%BQA\u000b\u0001\u0005\u0002-BQ!\f\u0001\u0005B9\u0012q\u0001T1{s&sGO\u0003\u0002\u000b\u0017\u00059!/\u001e8uS6,'\"\u0001\u0007\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001M\u0019\u0001aD\n\u0011\u0005A\tR\"A\u0006\n\u0005IY!AB!osJ+g\r\u0005\u0002\u0011)%\u0011Qc\u0003\u0002\r'\u0016\u0014\u0018.\u00197ju\u0006\u0014G.Z\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003a\u0001\"!\u0007\u0001\u000e\u0003%\tAbX5oSRL\u0017\r\\5{K\u0012\u0004\"\u0001\u0005\u000f\n\u0005uY!a\u0002\"p_2,\u0017M\u001c\u0015\u0003\u0005}\u0001\"\u0001\u0005\u0011\n\u0005\u0005Z!\u0001\u0003<pY\u0006$\u0018\u000e\\3\u0002\u0017%t\u0017\u000e^5bY&TX\rZ\u000b\u00027\u00051qL^1mk\u0016\u0004\"\u0001\u0005\u0014\n\u0005\u001dZ!aA%oi\u0006)a/\u00197vKV\tQ%\u0001\u0006j]&$\u0018.\u00197ju\u0016$\"!\n\u0017\t\u000b!2\u0001\u0019A\u0013\u0002\u0011Q|7\u000b\u001e:j]\u001e$\u0012a\f\t\u0003a]r!!M\u001b\u0011\u0005IZQ\"A\u001a\u000b\u0005Qj\u0011A\u0002\u001fs_>$h(\u0003\u00027\u0017\u00051\u0001K]3eK\u001aL!\u0001O\u001d\u0003\rM#(/\u001b8h\u0015\t14\u0002\u000b\u0003\u0001w!r\u0004C\u0001\t=\u0013\ti4B\u0001\tTKJL\u0017\r\u001c,feNLwN\\+J\tz\t\u0011\u0001")
public class LazyInt
implements Serializable {
    public static final long serialVersionUID = 1L;
    private volatile boolean _initialized;
    private int _value;

    public boolean initialized() {
        return this._initialized;
    }

    public int value() {
        return this._value;
    }

    public int initialize(int value) {
        this._value = value;
        this._initialized = true;
        return value;
    }

    public String toString() {
        return new StringBuilder(8).append("LazyInt ").append((Object)(this._initialized ? new StringBuilder(4).append("of: ").append(this._value).toString() : "thunk")).toString();
    }
}

