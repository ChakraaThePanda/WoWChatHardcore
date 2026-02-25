/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime.java8;

import java.io.Serializable;
import scala.Function1;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;

@FunctionalInterface
public interface JFunction1$mcVF$sp
extends Function1,
Serializable {
    @Override
    public void apply$mcVF$sp(float var1);

    default public Object apply(Object t) {
        this.apply$mcVF$sp(BoxesRunTime.unboxToFloat(t));
        return BoxedUnit.UNIT;
    }
}

