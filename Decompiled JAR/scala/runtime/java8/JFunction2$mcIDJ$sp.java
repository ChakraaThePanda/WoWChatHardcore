/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime.java8;

import java.io.Serializable;
import scala.Function2;
import scala.runtime.BoxesRunTime;

@FunctionalInterface
public interface JFunction2$mcIDJ$sp
extends Function2,
Serializable {
    @Override
    public int apply$mcIDJ$sp(double var1, long var3);

    default public Object apply(Object v1, Object v2) {
        return BoxesRunTime.boxToInteger(this.apply$mcIDJ$sp(BoxesRunTime.unboxToDouble(v1), BoxesRunTime.unboxToLong(v2)));
    }
}

