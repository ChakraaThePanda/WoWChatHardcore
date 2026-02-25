/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime.java8;

import java.io.Serializable;
import scala.Function2;
import scala.runtime.BoxesRunTime;

@FunctionalInterface
public interface JFunction2$mcJJI$sp
extends Function2,
Serializable {
    @Override
    public long apply$mcJJI$sp(long var1, int var3);

    default public Object apply(Object v1, Object v2) {
        return BoxesRunTime.boxToLong(this.apply$mcJJI$sp(BoxesRunTime.unboxToLong(v1), BoxesRunTime.unboxToInt(v2)));
    }
}

