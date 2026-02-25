/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime.java8;

import java.io.Serializable;
import scala.Function2;
import scala.runtime.BoxesRunTime;

@FunctionalInterface
public interface JFunction2$mcIID$sp
extends Function2,
Serializable {
    @Override
    public int apply$mcIID$sp(int var1, double var2);

    default public Object apply(Object v1, Object v2) {
        return BoxesRunTime.boxToInteger(this.apply$mcIID$sp(BoxesRunTime.unboxToInt(v1), BoxesRunTime.unboxToDouble(v2)));
    }
}

