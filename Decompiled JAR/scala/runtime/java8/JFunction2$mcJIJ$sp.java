/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime.java8;

import java.io.Serializable;
import scala.Function2;
import scala.runtime.BoxesRunTime;

@FunctionalInterface
public interface JFunction2$mcJIJ$sp
extends Function2,
Serializable {
    @Override
    public long apply$mcJIJ$sp(int var1, long var2);

    default public Object apply(Object v1, Object v2) {
        return BoxesRunTime.boxToLong(this.apply$mcJIJ$sp(BoxesRunTime.unboxToInt(v1), BoxesRunTime.unboxToLong(v2)));
    }
}

