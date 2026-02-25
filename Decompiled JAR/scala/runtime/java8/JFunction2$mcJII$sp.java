/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime.java8;

import java.io.Serializable;
import scala.Function2;
import scala.runtime.BoxesRunTime;

@FunctionalInterface
public interface JFunction2$mcJII$sp
extends Function2,
Serializable {
    @Override
    public long apply$mcJII$sp(int var1, int var2);

    default public Object apply(Object v1, Object v2) {
        return BoxesRunTime.boxToLong(this.apply$mcJII$sp(BoxesRunTime.unboxToInt(v1), BoxesRunTime.unboxToInt(v2)));
    }
}

