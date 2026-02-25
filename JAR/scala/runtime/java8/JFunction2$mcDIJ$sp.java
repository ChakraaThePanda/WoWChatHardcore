/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime.java8;

import java.io.Serializable;
import scala.Function2;
import scala.runtime.BoxesRunTime;

@FunctionalInterface
public interface JFunction2$mcDIJ$sp
extends Function2,
Serializable {
    @Override
    public double apply$mcDIJ$sp(int var1, long var2);

    default public Object apply(Object v1, Object v2) {
        return BoxesRunTime.boxToDouble(this.apply$mcDIJ$sp(BoxesRunTime.unboxToInt(v1), BoxesRunTime.unboxToLong(v2)));
    }
}

