/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime.java8;

import java.io.Serializable;
import scala.Function2;
import scala.runtime.BoxesRunTime;

@FunctionalInterface
public interface JFunction2$mcDII$sp
extends Function2,
Serializable {
    @Override
    public double apply$mcDII$sp(int var1, int var2);

    default public Object apply(Object v1, Object v2) {
        return BoxesRunTime.boxToDouble(this.apply$mcDII$sp(BoxesRunTime.unboxToInt(v1), BoxesRunTime.unboxToInt(v2)));
    }
}

