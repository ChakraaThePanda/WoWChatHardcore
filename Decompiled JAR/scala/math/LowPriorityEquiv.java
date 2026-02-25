/*
 * Decompiled with CFR 0.152.
 */
package scala.math;

import scala.math.Equiv;
import scala.math.Equiv$;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001!2\u0001b\u0001\u0003\u0011\u0002\u0007\u0005\u0011\"\n\u0005\u0006\u001d\u0001!\ta\u0004\u0005\u0006'\u0001!\u0019\u0001\u0006\u0002\u0011\u0019><\bK]5pe&$\u00180R9vSZT!!\u0002\u0004\u0002\t5\fG\u000f\u001b\u0006\u0002\u000f\u0005)1oY1mC\u000e\u00011C\u0001\u0001\u000b!\tYA\"D\u0001\u0007\u0013\tiaA\u0001\u0004B]f\u0014VMZ\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0015\u0003A\u0001\"aC\t\n\u0005I1!\u0001B+oSR\fa\"\u001e8jm\u0016\u00148/\u00197FcVLg/\u0006\u0002\u00169U\ta\u0003E\u0002\u00181ii\u0011\u0001B\u0005\u00033\u0011\u0011Q!R9vSZ\u0004\"a\u0007\u000f\r\u0001\u0011)QD\u0001b\u0001=\t\tA+\u0005\u0002 EA\u00111\u0002I\u0005\u0003C\u0019\u0011qAT8uQ&tw\r\u0005\u0002\fG%\u0011AE\u0002\u0002\u0004\u0003:LhBA\f'\u0013\t9C!A\u0003FcVLg\u000f")
public interface LowPriorityEquiv {
    public static /* synthetic */ Equiv universalEquiv$(LowPriorityEquiv $this) {
        return $this.universalEquiv();
    }

    default public <T> Equiv<T> universalEquiv() {
        return ((Equiv$)this).universal();
    }

    public static void $init$(LowPriorityEquiv $this) {
    }
}

