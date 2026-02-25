/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime.java8;

import java.io.Serializable;
import scala.Function2;
import scala.runtime.BoxesRunTime;

@FunctionalInterface
public interface JFunction2$mcJDD$sp
extends Function2,
Serializable {
    @Override
    public long apply$mcJDD$sp(double var1, double var3);

    default public Object apply(Object v1, Object v2) {
        return BoxesRunTime.boxToLong(this.apply$mcJDD$sp(BoxesRunTime.unboxToDouble(v1), BoxesRunTime.unboxToDouble(v2)));
    }
}

