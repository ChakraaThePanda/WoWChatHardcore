/*
 * Decompiled with CFR 0.152.
 */
package scala.util;

import scala.Function0;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\r4A!\u0003\u0006\u0001\u001f!AQ\u0003\u0001B\u0001B\u0003%a\u0003C\u0003\"\u0001\u0011\u0005!\u0005C\u0004'\u0001\t\u0007I\u0011B\u0014\t\r-\u0002\u0001\u0015!\u0003)\u0011\u0015\u0001\u0005\u0001\"\u0001B\u0011\u0015\u0011\u0005\u0001\"\u0001D\u0011\u0015\u0001\u0006\u0001\"\u0001R\u0011\u00151\u0006\u0001\"\u0011X\u0005=!\u0015P\\1nS\u000e4\u0016M]5bE2,'BA\u0006\r\u0003\u0011)H/\u001b7\u000b\u00035\tQa]2bY\u0006\u001c\u0001!\u0006\u0002\u00111M\u0011\u0001!\u0005\t\u0003%Mi\u0011\u0001D\u0005\u0003)1\u0011a!\u00118z%\u00164\u0017\u0001B5oSR\u0004\"a\u0006\r\r\u0001\u0011)\u0011\u0004\u0001b\u00015\t\tA+\u0005\u0002\u001c=A\u0011!\u0003H\u0005\u0003;1\u0011qAT8uQ&tw\r\u0005\u0002\u0013?%\u0011\u0001\u0005\u0004\u0002\u0004\u0003:L\u0018A\u0002\u001fj]&$h\b\u0006\u0002$KA\u0019A\u0005\u0001\f\u000e\u0003)AQ!\u0006\u0002A\u0002Y\t!\u0001\u001e7\u0016\u0003!\u0012\"!\u000b\u0017\u0007\t)\"\u0001\u0001\u000b\u0002\ryI,g-\u001b8f[\u0016tGOP\u0001\u0004i2\u0004\u0003cA\u00173-5\taF\u0003\u00020a\u0005!A.\u00198h\u0015\u0005\t\u0014\u0001\u00026bm\u0006L!a\r\u0018\u0003-%s\u0007.\u001a:ji\u0006\u0014G.\u001a+ie\u0016\fG\rT8dC2DQ!N\u0015\u0005BY\nA\"\u001b8ji&\fGNV1mk\u0016$\u0012a\u000e\n\u0004qY\tb\u0001\u0002\u0016:\u0001]2AA\u000f\u0003\u0003w\t)A%\u00198p]N\u0011\u0011\b\f\u0005\u0006Ce\"\t!\u0010\u000b\u0002}A\u0011q#\u000f\u0005\u0006ke\"\tEN\u0001\u0006m\u0006dW/Z\u000b\u0002-\u0005Iq/\u001b;i-\u0006dW/Z\u000b\u0003\t\u001e#\"!\u0012(\u0015\u0005\u0019K\u0005CA\fH\t\u0015AeA1\u0001\u001b\u0005\u0005\u0019\u0006B\u0002&\u0007\t\u0003\u00071*A\u0003uQVt7\u000eE\u0002\u0013\u0019\u001aK!!\u0014\u0007\u0003\u0011q\u0012\u0017P\\1nKzBQa\u0014\u0004A\u0002Y\taA\\3xm\u0006d\u0017!\u0003<bYV,w\fJ3r)\t\u0011V\u000b\u0005\u0002\u0013'&\u0011A\u000b\u0004\u0002\u0005+:LG\u000fC\u0003P\u000f\u0001\u0007a#\u0001\u0005u_N#(/\u001b8h)\u0005A\u0006CA-a\u001d\tQf\f\u0005\u0002\\\u00195\tAL\u0003\u0002^\u001d\u00051AH]8pizJ!a\u0018\u0007\u0002\rA\u0013X\rZ3g\u0013\t\t'M\u0001\u0004TiJLgn\u001a\u0006\u0003?2\u0001")
public class DynamicVariable<T> {
    public final T scala$util$DynamicVariable$$init;
    private final InheritableThreadLocal<T> tl;

    private InheritableThreadLocal<T> tl() {
        return this.tl;
    }

    public T value() {
        return this.tl().get();
    }

    public <S> S withValue(T newval, Function0<S> thunk) {
        S s;
        T oldval = this.value();
        this.tl().set(newval);
        try {
            s = thunk.apply();
        }
        finally {
            this.tl().set(oldval);
        }
        return s;
    }

    public void value_$eq(T newval) {
        this.tl().set(newval);
    }

    public String toString() {
        return new StringBuilder(17).append("DynamicVariable(").append(this.value()).append(")").toString();
    }

    public DynamicVariable(T init) {
        this.scala$util$DynamicVariable$$init = init;
        this.tl = new InheritableThreadLocal<T>(this){
            private final /* synthetic */ DynamicVariable $outer;

            public Object initialValue() {
                return this.$outer.scala$util$DynamicVariable$$init;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
            }
        };
    }
}

