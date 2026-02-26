/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime.java8;

import java.io.Serializable;
import scala.Function2;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;

@FunctionalInterface
public interface JFunction2$mcVDJ$sp
extends Function2,
Serializable {
    @Override
    public void apply$mcVDJ$sp(double var1, long var3);

    default public Object apply(Object v1, Object v2) {
        this.apply$mcVDJ$sp(BoxesRunTime.unboxToDouble(v1), BoxesRunTime.unboxToLong(v2));
        return BoxedUnit.UNIT;
    }
}

