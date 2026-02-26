/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime.java8;

import java.io.Serializable;
import scala.Function2;
import scala.runtime.BoxesRunTime;

@FunctionalInterface
public interface JFunction2$mcDDI$sp
extends Function2,
Serializable {
    @Override
    public double apply$mcDDI$sp(double var1, int var3);

    default public Object apply(Object v1, Object v2) {
        return BoxesRunTime.boxToDouble(this.apply$mcDDI$sp(BoxesRunTime.unboxToDouble(v1), BoxesRunTime.unboxToInt(v2)));
    }
}

